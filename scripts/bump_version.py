#!/usr/bin/env python3
"""Compute and optionally apply the next app version bump.

Updates `val currentVersion` (Stable major/minor/patch/build) and `versionCode`
in app/build.gradle.kts. Bump is detected from commit messages when not given
explicitly: BREAKING CHANGE or `type!:` -> major, `feat:` -> minor, else patch.
versionCode is always incremented by exactly 1.
"""
import argparse
import pathlib
import re
import sys

GRADLE = pathlib.Path("app/build.gradle.kts")


def read_state(text: str):
    m_code = re.search(r"versionCode\s*=\s*(\d+)", text)
    m_ver = re.search(
        r"val currentVersion: Version = Version\.Stable\(\s*"
        r"versionMajor\s*=\s*(\d+),\s*"
        r"versionMinor\s*=\s*(\d+),\s*"
        r"versionPatch\s*=\s*(\d+),\s*"
        r"versionBuild\s*=\s*(\d+),\s*\)",
        text,
        re.S,
    )
    if not m_code or not m_ver:
        print("ERROR: could not parse versionCode/currentVersion from app/build.gradle.kts", file=sys.stderr)
        sys.exit(1)
    return int(m_code.group(1)), tuple(int(x) for x in m_ver.groups())


def decide_bump(messages: str) -> str:
    if re.search(r"BREAKING CHANGE|^[a-zA-Z]+(\([^)]*\))?!:", messages, re.M):
        return "major"
    if re.search(r"^feat(\([^)]*\))?:", messages, re.M | re.I):
        return "minor"
    return "patch"


def next_version(ver, kind: str):
    major, minor, patch, build = ver
    if kind == "major":
        return (major + 1, 0, 0, 0)
    if kind == "minor":
        return (major, minor + 1, 0, 0)
    # patch: bump patch segment for a clean semantic version tag
    return (major, minor, patch + 1, 0)


def apply(text: str, new_code: int, new_ver) -> str:
    text, n = re.subn(r"versionCode\s*=\s*\d+", f"versionCode = {new_code}", text, count=1)
    if n != 1:
        raise SystemExit("ERROR: failed to update versionCode")
    text, n = re.subn(
        r"(val currentVersion: Version = Version\.Stable\(\s*"
        r"versionMajor\s*=\s*)\d+(,\s*"
        r"versionMinor\s*=\s*)\d+(,\s*"
        r"versionPatch\s*=\s*)\d+(,\s*"
        r"versionBuild\s*=\s*)\d+(,\s*\))",
        lambda m: (
            f"{m.group(1)}{new_ver[0]}{m.group(2)}{new_ver[1]}"
            f"{m.group(3)}{new_ver[2]}{m.group(4)}{new_ver[3]}{m.group(5)}"
        ),
        text,
        count=1,
        flags=re.S,
    )
    if n != 1:
        raise SystemExit("ERROR: failed to update currentVersion")
    return text


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--messages-file", help="File with commit messages to classify the bump")
    ap.add_argument("--bump", choices=["major", "minor", "patch"], help="Force bump type")
    ap.add_argument("--print-only", action="store_true", help="Compute only, do not modify files")
    args = ap.parse_args()

    text = GRADLE.read_text(encoding="utf-8")
    code, ver = read_state(text)

    if args.bump:
        kind = args.bump
    elif args.messages_file:
        msgs = pathlib.Path(args.messages_file).read_text(encoding="utf-8", errors="ignore")
        kind = decide_bump(msgs)
    else:
        kind = "patch"

    new_ver = next_version(ver, kind)
    new_code = code + 1
    tag = f"v{new_ver[0]}.{new_ver[1]}.{new_ver[2]}"
    version_name = f"{new_ver[0]}.{new_ver[1]}.{new_ver[2]}.{new_ver[3]}"

    # Machine-readable output for CI
    print(f"BUMP={kind}")
    print(f"CURRENT_VERSION_CODE={code}")
    print(f"NEW_VERSION_NAME={version_name}")
    print(f"NEW_VERSION_CODE={new_code}")
    print(f"NEW_TAG={tag}")

    if not args.print_only:
        GRADLE.write_text(apply(text, new_code, new_ver), encoding="utf-8")


if __name__ == "__main__":
    main()
