#!/usr/bin/env python3
"""Intelligent change detection and semantic version classification.

Analyzes git diff/file changes and commit messages between the previous release
tag and HEAD. Primary evidence is actual code/file changes; commit messages are
secondary corroboration.

Outputs machine-readable KEY=VALUE lines for CI and a JSON summary.
"""
import argparse
import json
import pathlib
import re
import subprocess
import sys

ROOT = pathlib.Path(__file__).resolve().parents[1]

UI_PATH_HINTS = (
    "res/layout", "res/values", "res/color", "res/drawable", "res/font",
    "res/anim", "ui/", "/compose", "theme", "Theme", "Style", "Color",
)


def run(cmd, cwd=ROOT, check=True):
    r = subprocess.run(cmd, cwd=str(cwd), text=True, capture_output=True, encoding="utf-8", errors="replace")
    if check and r.returncode != 0:
        raise RuntimeError(f"cmd failed: {cmd}\n{r.stderr}\n{r.stdout}")
    return r.stdout


def get_prev_tag():
    try:
        out = run(["git", "describe", "--tags", "--abbrev=0", "--match", "v[0-9]*.[0-9]*.[0-9]*"]).strip()
        return out or None
    except Exception:
        return None


def list_changes(base):
    # returns list of (status, path, oldpath?)
    if base:
        out = run(["git", "diff", "--name-status", "-M", f"{base}..HEAD"], check=False)
    else:
        # no previous tag: treat tracked files as added
        out = run(["git", "ls-files"], check=False)
        return [("A", p.strip(), None) for p in out.splitlines() if p.strip()]
    items = []
    for line in out.splitlines():
        if not line.strip():
            continue
        parts = line.split("\t")
        status = parts[0][:1]
        if status in ("R", "C") and len(parts) >= 3:
            items.append((status, parts[2], parts[1]))
        elif len(parts) >= 2:
            items.append((status, parts[1], None))
    return items


def get_diff_text(base, paths=None):
    try:
        if base:
            cmd = ["git", "diff", "--unified=3", f"{base}..HEAD"]
        else:
            cmd = ["git", "show", "--unified=3", "--format=", "HEAD"]
        if paths:
            cmd += ["--"] + list(paths)
        return run(cmd, check=False)
    except Exception:
        return ""


def get_commit_messages(base):
    try:
        if base:
            return run(["git", "log", "--format=%B%n---COMMIT---", f"{base}..HEAD"], check=False)
        return run(["git", "log", "-30", "--format=%B%n---COMMIT---"], check=False)
    except Exception:
        return ""


def is_doc_only_path(p):
    if re.search(r"\.(md|markdown|rst|txt|adoc)$", p, re.I):
        return True
    if re.search(r"(^|/)docs?(/|$)", p, re.I):
        return True
    if re.search(r"(^|/)(README|CHANGELOG|CONTRIBUTING|LICENSE|CODE_OF_CONDUCT|SECURITY)(\.[^/]*)?$", p, re.I):
        return True
    if re.search(r"(^|/)fastlane/metadata/", p):
        return True
    return False


def is_nonfunctional_metadata(p):
    if re.search(r"^\.github/ISSUE_TEMPLATE/", p):
        return True
    if re.search(r"^\.github/FUNDING\.yml$", p):
        return True
    if re.search(r"^\.github/CODEOWNERS$", p):
        return True
    if p.startswith(".idea/") or p.startswith(".vscode/"):
        return True
    if p in (".editorconfig", ".gitattributes"):
        return True
    # screenshots/images outside packaged app resources are non-functional metadata
    if re.search(r"\.(png|jpe?g|gif|webp|svg|ico|drawio)$", p, re.I) and not p.startswith("app/src/"):
        return True
    return False


def is_functional_path(p):
    if p.startswith("app/src/") or p.startswith("app/schemas/"):
        return True
    if p in ("app/build.gradle.kts", "app/build.gradle", "app/proguard-rules.pro", "app/consumer-rules.pro"):
        return True
    if p.startswith("color/"):
        return True
    if p.startswith("gradle/") or p in (
        "build.gradle.kts", "build.gradle", "settings.gradle.kts", "settings.gradle",
        "gradle.properties", "gradlew", "gradlew.bat",
    ):
        return True
    if p.startswith(".github/workflows/") or p.startswith("scripts/"):
        return True
    if p == "update.json":
        return True
    if is_doc_only_path(p) or is_nonfunctional_metadata(p):
        return False
    # unknown files are treated conservatively as functional (could affect build/runtime)
    return True


def collect(changes):
    functional, docs_nf = [], []
    for status, path, old in changes:
        if is_functional_path(path):
            functional.append((status, path, old))
        else:
            docs_nf.append((status, path, old))
    return functional, docs_nf


def detect(changes, base):
    messages = get_commit_messages(base)
    full_diff = get_diff_text(base)

    functional, docs_nf = collect(changes)

    reasons = {"major": [], "minor": [], "patch": [], "info": []}
    changelog = {"features": [], "fixes": [], "improvements": [], "breaking": []}

    # --- commit messages (secondary corroboration) ---
    msg_blocks = [b.strip() for b in messages.split("---COMMIT---") if b.strip()]
    for m in msg_blocks:
        first = (m.splitlines()[0] if m else "").strip()
        if not first:
            continue
        lower = first.lower()
        if re.search(r"BREAKING CHANGE|^[a-zA-Z]+(\([^)]*\))?!:", m, re.M):
            reasons["major"].append(f"commit-signal: breaking marker in '{first[:100]}'")
            changelog["breaking"].append(first)
        if re.search(r"^feat(\([^)]*\))?:", m, re.M | re.I):
            reasons["minor"].append(f"commit-signal: feat '{first[:100]}'")
            changelog["features"].append(first)
        if re.search(r"^fix(\([^)]*\))?:", m, re.M | re.I):
            reasons["patch"].append(f"commit-signal: fix '{first[:100]}'")
            changelog["fixes"].append(first)
        if re.search(r"^perf(\([^)]*\))?:", m, re.M | re.I) or "performance" in lower or "faster" in lower or "optimiz" in lower:
            reasons["patch"].append(f"commit-signal: performance '{first[:100]}'")
            changelog["improvements"].append(first)
        if re.search(r"^refactor(\([^)]*\))?:", m, re.M | re.I):
            reasons["patch"].append(f"commit-signal: refactor '{first[:100]}'")
            changelog["improvements"].append(first)
        if re.search(r"^(ui|style)(\([^)]*\))?:", m, re.M | re.I) or any(w in lower for w in ["ui ", "layout", "color", "font", "spacing", "styling"]):
            reasons["patch"].append(f"commit-signal: ui/style '{first[:100]}'")
            changelog["improvements"].append(first)
        if re.search(r"^(security|sec)(\([^)]*\))?:", m, re.M | re.I) or "security" in lower:
            reasons["patch"].append(f"commit-signal: security/stability '{first[:100]}'")
            changelog["fixes"].append(first)

    # --- primary: actual file/diff analysis ---
    added_paths = [p for s, p, _ in functional if s == "A"]
    deleted_paths = [p for s, p, _ in functional if s == "D"]
    modified_paths = [p for s, p, _ in functional if s == "M"]
    major_suspected = False
    has_explicit_break = any("commit-signal: breaking marker" in r for r in reasons["major"])

    for s, p, old in functional:
        stem = pathlib.Path(p).stem

        # MAJOR: breaking/architectural/fundamental
        if p.endswith("AndroidManifest.xml"):
            mdiff = get_diff_text(base, [p])
            if re.search(r"^-[^\n]*android\.intent\.action\.MAIN", mdiff, re.M) or re.search(r"^-[^\n]*android\.intent\.category\.LAUNCHER", mdiff, re.M):
                reasons["major"].append(f"manifest: launcher/main entry changed in {p}")
            if re.search(r"^-[^\n]*<activity", mdiff, re.M):
                reasons["major"].append(f"manifest: activity removed/changed in {p} (possible breaking navigation change)")
                major_suspected = True
            if re.search(r"^-[^\n]*android:exported", mdiff, re.M):
                reasons["major"].append(f"manifest: exported component behavior changed in {p}")
                major_suspected = True

        if p.endswith(("build.gradle.kts", "build.gradle", "libs.versions.toml")):
            bdiff = get_diff_text(base, [p])
            if re.search(r"^-[^\n]*applicationId\s*=", bdiff, re.M) and re.search(r"^\+[^\n]*applicationId\s*=", bdiff, re.M):
                reasons["major"].append("build: applicationId changed (breaking install/identity compatibility)")
                has_explicit_break = True
            if re.search(r"^-[^\n]*namespace\s*=", bdiff, re.M) and re.search(r"^\+[^\n]*namespace\s*=", bdiff, re.M):
                reasons["major"].append(f"build: namespace changed in {p} (possible breaking change)")
                major_suspected = True
            # coarse major framework migration signals
            if re.search(r"agp|androidGradlePlugin|kotlin.*version|compose.*bom", bdiff, re.I) and re.search(r"^\+", bdiff, re.M) and re.search(r"^\-", bdiff, re.M):
                # only escalate if it looks like a big jump (heuristic)
                major_pairs = re.findall(r"^\-\s*.*?(\d+)\.", bdiff, re.M)
                minor_pairs = re.findall(r"^\+\s*.*?(\d+)\.", bdiff, re.M)
                # not enough info to be sure; treat as suspected only in explicit breaking context

        if "database" in p.lower() or "schema" in p.lower() or p.endswith(("Dao.kt", "Entity.kt")) or "/migration" in p.lower():
            ddiff = get_diff_text(base, [p])
            old_ver = re.findall(r"^-[^\n]*version\s*=\s*(\d+)", ddiff, re.M)
            new_ver = re.findall(r"^\+[^\n]*version\s*=\s*(\d+)", ddiff, re.M)
            if old_ver and new_ver:
                reasons["major"].append(f"database: schema version changed in {p} (migration/compatibility impact)")
                major_suspected = True
            if re.search(r"DROP\s+TABLE|DROP\s+COLUMN", ddiff, re.I):
                reasons["major"].append(f"database: destructive schema change detected in {p}")
                major_suspected = True
            if re.search(r"^-[^\n]*@Entity|^-[^\n]*@ColumnInfo", ddiff, re.M) and not re.search(r"fallbackToDestructiveMigration", ddiff):
                reasons["major"].append(f"database: entity/column removal signals in {p}")
                major_suspected = True

        if s == "D" and p.startswith("app/src/main/java/"):
            if re.search(r"(Activity|MainScreen|NavGraph|Navigation|Router|Route)\.kt$", p):
                reasons["major"].append(f"deletion: removed core screen/navigation component {p}")
                major_suspected = True
            elif re.search(r"(Screen|Page|Feature|Module)\.kt$", p):
                reasons["major"].append(f"deletion: removed feature/screen {p} (possible breaking change)")
                major_suspected = True

        if any(h in p.lower() for h in ("navgraph", "navigation", "route", "router")) and s == "M":
            ndiff = get_diff_text(base, [p])
            removed = len(re.findall(r"^-(?!-)", ndiff, re.M))
            added = len(re.findall(r"^\+(?!\+)", ndiff, re.M))
            if removed > 50 and removed > added * 1.5:
                reasons["major"].append(f"navigation: large structural rewrite/removal in {p}")
                major_suspected = True

        # MINOR: new features/screens/modules/APIs/settings/capabilities (additive)
        if s == "A" and p.startswith("app/src/main/java/"):
            if re.search(r"(Screen|Page|Activity|Fragment|Feature|Module)\.kt$", p):
                reasons["minor"].append(f"feature: added screen/module {p}")
                changelog["features"].append(f"New screen/module: {stem}")
            elif re.search(r"(Api|Service|Client|Repository|Endpoint|Integration|Provider)\w*\.kt$", p, re.I):
                reasons["minor"].append(f"feature: added API/integration component {p}")
                changelog["features"].append(f"New integration/component: {stem}")
            elif re.search(r"(Dialog|Sheet|Panel|Wizard|Onboarding)\w*\.kt$", p, re.I):
                reasons["minor"].append(f"feature: added UI capability {p}")
                changelog["features"].append(f"New UI component: {stem}")
            else:
                reasons["minor"].append(f"feature: added source file {p}")

        if s == "A" and p.startswith("app/src/main/res/") and ("/layout" in p or "/navigation" in p or "/xml" in p):
            reasons["minor"].append(f"feature: added resource {p}")

        if p.endswith("AndroidManifest.xml"):
            mdiff = get_diff_text(base, [p])
            if re.search(r"^\+[^\n]*<uses-permission", mdiff, re.M):
                reasons["minor"].append(f"feature: new permission/capability in {p}")
            if re.search(r"^\+[^\n]*<(activity|service|receiver|provider)", mdiff, re.M):
                reasons["minor"].append(f"feature: new app component in {p}")

        # PATCH: bug fixes, UI/styling, performance, minor logic/refactors, safe deps, CI
        if p.startswith("app/src/main/res/") and any(seg in p for seg in ("/values", "/drawable", "/color", "/font", "/anim", "/mipmap")):
            reasons["patch"].append(f"ui: resource/style adjustment in {p}")
            changelog["improvements"].append(f"UI/resource update: {pathlib.Path(p).name}")
        if any(h.lower() in p.lower() for h in UI_PATH_HINTS) and p.startswith("app/src/main/java/"):
            reasons["patch"].append(f"ui: UI code change in {p}")

        if s == "M" and p.startswith("app/src/main/java/"):
            reasons["patch"].append(f"code: modified {p}")
        if s == "M" and p.startswith("color/"):
            reasons["patch"].append(f"code/ui: modified {p}")

        if p.endswith("libs.versions.toml") or "dependencies" in pathlib.Path(p).name.lower() or p.endswith(("build.gradle.kts", "build.gradle", "gradle.properties")):
            bdiff = get_diff_text(base, [p])
            if re.search(r"^\+|^-", bdiff, re.M):
                reasons["patch"].append(f"deps/build: configuration or dependency update in {p}")
                changelog["improvements"].append(f"Build/dependency update: {pathlib.Path(p).name}")

        if p.startswith(".github/workflows/") or p.startswith("scripts/"):
            reasons["patch"].append(f"pipeline: CI/release automation changed in {p}")
            changelog["improvements"].append(f"Automation update: {pathlib.Path(p).name}")
        if p == "update.json":
            reasons["patch"].append("release: update manifest/policy changed")

    # diff-content signals (primary evidence)
    if re.search(r"^\+.*(const val\s+\w+\s*=\s*\"|stringPreferencesKey\(|booleanPreferencesKey\(|intPreferencesKey\(|preference)", full_diff, re.M):
        reasons["minor"].append("feature: new settings/preferences/capabilities detected in diff")
    if re.search(r"^\+.*@Entity", full_diff, re.M) and not re.search(r"^-[^\n]*@Entity", full_diff, re.M):
        reasons["minor"].append("feature: new database entity/entities added (additive)")
    if re.search(r"^\+.*(fix|bug|crash|exception|NPE|leak|race|ANR|null\s*check|safe)", full_diff, re.M | re.I):
        reasons["patch"].append("diff-signal: bug-fix/stability-oriented changes detected")
        if not changelog["fixes"]:
            changelog["fixes"].append("Bug fixes and stability improvements")
    if re.search(r"^\+.*(cache|optimi[sz]|faster|lazy|remember|memo|debounce|throttle)", full_diff, re.M | re.I):
        reasons["patch"].append("diff-signal: performance-related changes detected")
        if not any("performance" in x.lower() for x in changelog["improvements"]):
            changelog["improvements"].append("Performance improvements")

    # classify highest impact: MAJOR > MINOR > PATCH
    impact = "none"
    if reasons["major"]:
        impact = "major"
    elif reasons["minor"]:
        impact = "minor"
    elif reasons["patch"] or functional:
        impact = "patch"

    requires_review = False
    if impact == "major":
        has_explicit_break = any("commit-signal: breaking marker" in r for r in reasons["major"])
        if major_suspected or not has_explicit_break:
            requires_review = True
            reasons["info"].append(
                "Major impact is heuristic/suspected or lacks an explicit breaking-change marker; "
                "review is required before publishing a MAJOR release."
            )

    # unclear functional change -> PATCH only when backward compatibility is confirmed (no major signals)
    if impact == "none" and functional:
        impact = "patch"
        reasons["info"].append("Fallback: functional changes with unclear impact; defaulting to PATCH (no breaking signals detected).")

    # docs-only / comments/non-functional metadata only => no release
    skip_release = False
    skip_reason = ""
    if not functional:
        skip_release = True
        impact = "none"
        if changes:
            skip_reason = "Only documentation, comments, or non-functional metadata changed; no APK release."
        else:
            skip_reason = "No changes detected since the previous release."

    # dedupe changelog entries
    for k in changelog:
        seen = set()
        out = []
        for item in changelog[k]:
            s = item.strip()
            if s and s not in seen:
                seen.add(s)
                out.append(s)
        changelog[k] = out[:25]

    return {
        "prev_tag": base,
        "impact": impact,
        "skip_release": skip_release,
        "skip_reason": skip_reason,
        "requires_review": requires_review,
        "changed_files": len(changes),
        "functional_files": len(functional),
        "doc_or_nonfunctional_files": len(docs_nf),
        "reasons": reasons,
        "changelog": changelog,
    }


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--base", help="Base ref/tag (default: previous v*.*.* tag)")
    ap.add_argument("--format", choices=["env", "json"], default="env")
    ap.add_argument("--output", help="Write JSON summary to this path")
    args = ap.parse_args()

    base = args.base if args.base is not None else get_prev_tag()
    if args.base == "":
        base = None

    changes = list_changes(base)
    summary = detect(changes, base)

    if args.output:
        outp = pathlib.Path(args.output)
        outp.parent.mkdir(parents=True, exist_ok=True)
        outp.write_text(json.dumps(summary, indent=2, ensure_ascii=False), encoding="utf-8")

    if args.format == "json":
        print(json.dumps(summary, indent=2, ensure_ascii=False))
        return

    def b(v):
        return "true" if v else "false"

    print(f"PREV_TAG={summary['prev_tag'] or ''}")
    print(f"IMPACT={summary['impact']}")
    print(f"SKIP_RELEASE={b(summary['skip_release'])}")
    print(f"REQUIRES_REVIEW={b(summary['requires_review'])}")
    print(f"CHANGED_FILES={summary['changed_files']}")
    print(f"FUNCTIONAL_FILES={summary['functional_files']}")
    reason = (summary["skip_reason"] or "").replace("\n", " ").strip()[:400]
    print(f"SKIP_REASON={reason}")


if __name__ == "__main__":
    main()
