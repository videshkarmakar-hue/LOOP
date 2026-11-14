package com.videshkarmakar.loop.util

/**
 * Single source of truth for the app's GitHub-powered update channel.
 *
 * The updater reads public release metadata and release assets only; no token or private
 * credential is ever embedded. Point this at the repository that publishes this build's releases.
 */
object UpdateConfig {
    /** GitHub repository owner that publishes releases for this app. */
    const val REPO_OWNER: String = "videshkarmakar-hue"

    /** GitHub repository name that publishes releases for this app. */
    const val REPO_NAME: String = "LOOP"

    const val RELEASES_API: String =
        "https://api.github.com/repos/$REPO_OWNER/$REPO_NAME/releases"

    /**
     * Update policy manifest served from the repository's default branch.
     *
     * Editing this file changes the update requirement for every installed app without publishing
     * a new APK: minimum supported version, staged rollout, force-update wording, release notes.
     */
    const val POLICY_MANIFEST_URL: String =
        "https://raw.githubusercontent.com/$REPO_OWNER/$REPO_NAME/master/update.json"

    /** How long a fetched policy is trusted before another network lookup is made. */
    const val POLICY_CACHE_TTL_MS: Long = 15L * 60L * 1000L

    /** How long a release lookup is reused in memory before hitting the GitHub API again. */
    const val RELEASE_CACHE_TTL_MS: Long = 5L * 60L * 1000L

    /** How often a resume from background may trigger a lookup. */
    const val RESUME_CHECK_INTERVAL_MS: Long = 30_000L

    /** How often navigation between major sections may trigger a lookup. */
    const val NAVIGATION_CHECK_INTERVAL_MS: Long = 60_000L

    /** How often to poll for a newer release while the app process is alive. */
    const val PERIODIC_CHECK_INTERVAL_MS: Long = 30L * 60L * 1000L

    /** Delay before an automatic retry after a failed check or download. */
    const val RETRY_DELAY_MS: Long = 15_000L

    const val MAX_RETRY_ATTEMPTS: Int = 5
}
