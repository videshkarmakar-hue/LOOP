package com.videshkarmakar.loop.util

import com.videshkarmakar.loop.util.UpdateUtil.AssetsItem
import com.videshkarmakar.loop.util.UpdateUtil.LatestRelease
import com.videshkarmakar.loop.util.UpdateUtil.parseChecksumManifest
import com.videshkarmakar.loop.util.UpdateUtil.selectApkAsset
import com.videshkarmakar.loop.util.UpdateUtil.toVersion
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Update-decision logic that must be right for the mandatory flow to be safe: parsing the installed
 * and published version strings, rejecting junk tags, choosing the right APK asset and matching a
 * published SHA-256 to it.
 */
class UpdateLogicTest {

    // region version parsing

    @Test
    fun parsesInstalledBuildSuffix() {
        val version = "1.2.1.3-(F-Droid)".toVersion()
        assertEquals("1.2.1.3", version.toVersionName())
        assertTrue(version > "1.2.1".toVersion())
        assertTrue(version < "1.2.2".toVersion())
    }

    @Test
    fun parsesTagPrefixAndQualifiers() {
        assertEquals("1.2.1", "v1.2.1".toVersion().toVersionName())
        assertEquals("1.3.0-beta.2", "v1.3.0-beta.2".toVersion().toVersionName())
        assertEquals("1.3.0-rc.1", "1.3.0-rc.1".toVersion().toVersionName())
    }

    @Test
    fun releaseChannelOrdering() {
        assertTrue("1.3.0-alpha.1".toVersion() < "1.3.0-beta.1".toVersion())
        assertTrue("1.3.0-beta.1".toVersion() < "1.3.0-rc.1".toVersion())
        assertTrue("1.3.0-rc.1".toVersion() < "1.3.0".toVersion())
    }

    @Test
    fun junkTagsNeverLookNewer() {
        val empty = "v - Debug Build".toVersion()
        assertEquals("0.0.0", empty.toVersionName())
        assertTrue(empty < "1.0.0".toVersion())
        assertTrue("".toVersion() == empty)
        assertTrue(null.toVersion() == empty)
    }

    @Test
    fun equalVersionsDoNotTriggerAnUpdate() {
        assertTrue("1.2.1.3-(F-Droid)".toVersion() >= "v1.2.1.3".toVersion())
        assertEquals(0, "1.2.1".toVersion().compareTo("v1.2.1".toVersion()))
    }

    // endregion

    // region update policy

    private fun policy(
        latest: String,
        minimum: String,
        required: Boolean = false,
        rollout: Int = 100
    ) = UpdatePolicy(
        latestVersion = latest,
        minimumSupportedVersion = minimum,
        updateRequired = required,
        rolloutPercentage = rollout
    )

    @Test
    fun upToDateWhenInstalledMatchesLatest() {
        assertEquals(Requirement.NONE, policy("1.2.1.5", "1.2.0").decide("1.2.1.5".toVersion(), 0))
        assertEquals(Requirement.NONE, policy("1.2.1.5", "1.2.0").decide("1.3.0".toVersion(), 0))
    }

    @Test
    fun newerButSupportedVersionIsOptional() {
        assertEquals(
            Requirement.OPTIONAL,
            policy("1.2.1.5", "1.2.0").decide("1.2.1".toVersion(), 42)
        )
    }

    @Test
    fun belowMinimumIsRequiredRegardlessOfRollout() {
        // A security floor applies to everyone, even a device outside a 0% rollout.
        assertEquals(
            Requirement.REQUIRED,
            policy("1.3.0", "1.2.0", required = false, rollout = 0)
                .decide("1.1.0".toVersion(), 99)
        )
    }

    @Test
    fun mandatoryReleaseHonoursStagedRollout() {
        val staged = policy("1.3.0", "1.0.0", required = true, rollout = 25)
        assertEquals(Requirement.REQUIRED, staged.decide("1.2.0".toVersion(), 10))
        assertEquals(Requirement.OPTIONAL, staged.decide("1.2.0".toVersion(), 50))
    }

    @Test
    fun parsesPolicyManifestJson() {
        val raw = """
            {
              "latest_version": "1.2.1.5",
              "minimum_supported_version": "1.2.1.0",
              "update_required": true,
              "update_url": "https://example.invalid/releases/latest",
              "release_notes": "Fixes",
              "release_date": "2026-11-13",
              "rollout_percentage": 50,
              "force_update_message": "Update required"
            }
        """.trimIndent()

        val parsed = Json { ignoreUnknownKeys = true }.decodeFromString<UpdatePolicy>(raw)
        assertEquals("1.2.1.5", parsed.latestVersion)
        assertEquals("1.2.1.0", parsed.minimumSupportedVersion)
        assertEquals(true, parsed.updateRequired)
        assertEquals(50, parsed.rolloutPercentage)
        assertEquals("Update required", parsed.forceUpdateMessage)
        assertEquals(Requirement.REQUIRED, parsed.decide("1.2.1.4".toVersion(), 3))
    }

    // endregion

    // region asset selection

    private fun apk(name: String) = AssetsItem(
        name = name,
        size = 100,
        browserDownloadUrl = "https://example.invalid/$name"
    )

    @Test
    fun selectsAssetForPrimaryAbi() {
        val release = LatestRelease(
            tagName = "v1.2.1.4",
            assets = listOf(
                apk("LOOP-1.2.1.4-armeabi-v7a.apk"),
                apk("LOOP-1.2.1.4-arm64-v8a.apk"),
                apk("LOOP-1.2.1.4-x86_64.apk")
            )
        )
        val arm64 = release.selectApkAsset(listOf("arm64-v8a"))
        assertEquals("LOOP-1.2.1.4-arm64-v8a.apk", arm64?.name)

        val x86 = release.selectApkAsset(listOf("x86_64", "arm64-v8a"))
        assertEquals("LOOP-1.2.1.4-x86_64.apk", x86?.name)
    }

    @Test
    fun fallsBackToUniversalAssetWhenNoAbiMatches() {
        val release = LatestRelease(
            tagName = "v1.2.1.4",
            assets = listOf(
                apk("LOOP-1.2.1.4-arm64-v8a.apk"),
                apk("LOOP-1.2.1.4-universal.apk")
            )
        )
        // No asset carries the device ABI, so the ABI-neutral build is used instead of nothing.
        val selected = release.selectApkAsset(listOf("mips"))
        assertEquals("LOOP-1.2.1.4-universal.apk", selected?.name)
    }

    @Test
    fun ignoresNonApkAssetsAndEmptyReleases() {
        val release = LatestRelease(
            tagName = "v1.2.1.4",
            assets = listOf(AssetsItem(name = "notes.txt"), AssetsItem(name = "app.apk.sha256"))
        )
        assertNull(release.selectApkAsset(listOf("arm64-v8a")))
        assertNull((LatestRelease(tagName = "v1.2.1.4")).selectApkAsset(listOf("arm64-v8a")))
    }

    // endregion

    // region checksum manifest

    @Test
    fun matchesChecksumEntryForTheChosenApk() {
        val manifest = """
            9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08  LOOP-v1.2.1.4-armeabi-v7a.apk
            a3f5c9d1b2e4f6078a9b0c1d2e3f405162738495a6b7c8d9e0f1a2b3c4d5e6f7 *LOOP-v1.2.1.4-arm64-v8a.apk
        """.trimIndent()

        assertEquals(
            "a3f5c9d1b2e4f6078a9b0c1d2e3f405162738495a6b7c8d9e0f1a2b3c4d5e6f7",
            parseChecksumManifest(manifest, "LOOP-v1.2.1.4-arm64-v8a.apk")
        )
    }

    @Test
    fun acceptsBareSingleHashManifest() {
        val hash = "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08"
        assertEquals(hash, parseChecksumManifest("$hash\n", "LOOP-v1.2.1.4-arm64-v8a.apk"))
    }

    @Test
    fun rejectsManifestWithoutAValidHash() {
        assertNull(parseChecksumManifest("not a checksum file", "app.apk"))
    }

    // endregion

    // region release notes

    @Test
    fun changelogGroupsBulletsUnderHeadings() {
        val notes = """
            ## New
            - Lossless 4K 60fps pipeline
            - Split chapters

            ## Fixes
            - Scoped storage on Android 15
        """.trimIndent()

        val items = parseReleaseNotes(notes)

        assertEquals(3, items.size)
        assertEquals("NEW", items[0].tag)
        assertEquals("Lossless 4K 60fps pipeline", items[0].title)
        assertEquals("FIXES", items[2].tag)
    }

    @Test
    fun changelogSplitsTitleFromDescription() {
        val items = parseReleaseNotes("- Instant clipboard sniffer: zero-latency background parsing")

        assertEquals(1, items.size)
        assertEquals("Instant clipboard sniffer", items[0].title)
        assertEquals("zero-latency background parsing", items[0].body)
        assertNull(items[0].tag)
    }

    @Test
    fun changelogIgnoresGenericHeadingsAndBlankBodies() {
        assertTrue(parseReleaseNotes("").isEmpty())
        assertTrue(parseReleaseNotes("   \n\n").isEmpty())

        val items = parseReleaseNotes("## What's new\n- One change")
        assertEquals(1, items.size)
        assertNull(items[0].tag)
    }

    // endregion
}
