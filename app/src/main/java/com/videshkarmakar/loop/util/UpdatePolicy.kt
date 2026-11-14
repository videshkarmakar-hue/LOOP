package com.videshkarmakar.loop.util

import com.videshkarmakar.loop.util.UpdateUtil.Version
import com.videshkarmakar.loop.util.UpdateUtil.toVersion
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Remote update policy, published as `update.json` on the repository's default branch.
 *
 * This is the "backend" of the update system: changing these values changes what every installed
 * app does, without shipping a new APK.
 */
@Serializable
data class UpdatePolicy(
    @SerialName("latest_version") val latestVersion: String = "",
    @SerialName("minimum_supported_version") val minimumSupportedVersion: String = "",
    @SerialName("update_required") val updateRequired: Boolean = false,
    @SerialName("update_url") val updateUrl: String = "",
    @SerialName("release_notes") val releaseNotes: String = "",
    @SerialName("release_date") val releaseDate: String = "",
    @SerialName("rollout_percentage") val rolloutPercentage: Int = 100,
    @SerialName("force_update_message") val forceUpdateMessage: String = "",
)

enum class Requirement { NONE, OPTIONAL, REQUIRED }

/** Whether this install falls inside a staged rollout (0 and >=100 mean "everyone"/"nobody"). */
fun UpdatePolicy.isInRollout(rolloutBucket: Int): Boolean {
    val percentage = rolloutPercentage.coerceIn(0, 100)
    return percentage >= 100 || (percentage > 0 && rolloutBucket < percentage)
}

/**
 * Decide what this install must do.
 *
 * - below `minimum_supported_version` -> always required, rollout is irrelevant (security floor)
 * - `update_required` + inside the rollout -> required (staged mandatory release)
 * - newer release but still supported -> optional
 * - otherwise -> nothing to do
 */
fun UpdatePolicy.decide(installed: Version, rolloutBucket: Int): Requirement {
    val latest = latestVersion.toVersion()
    val minimum = minimumSupportedVersion.toVersion()
    return when {
        installed < minimum -> Requirement.REQUIRED
        installed < latest && updateRequired && isInRollout(rolloutBucket) -> Requirement.REQUIRED
        installed < latest -> Requirement.OPTIONAL
        else -> Requirement.NONE
    }
}
