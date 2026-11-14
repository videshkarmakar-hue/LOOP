package com.videshkarmakar.loop.util

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.core.content.FileProvider
import com.videshkarmakar.loop.App
import com.videshkarmakar.loop.App.Companion.context
import com.videshkarmakar.loop.R
import com.videshkarmakar.loop.util.FileUtil.getFileProvider
import com.videshkarmakar.loop.util.PreferenceUtil.getInt
import com.videshkarmakar.loop.util.PreferenceUtil.getLong
import com.videshkarmakar.loop.util.PreferenceUtil.getString
import com.videshkarmakar.loop.util.PreferenceUtil.updateLong
import com.videshkarmakar.loop.util.PreferenceUtil.updateString
import com.yausername.youtubedl_android.YoutubeDL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.FileOutputStream
import java.io.RandomAccessFile
import java.security.MessageDigest
import java.util.concurrent.TimeUnit
import java.util.regex.Pattern
import kotlin.math.max

object UpdateUtil {

    private const val TAG = "UpdateUtil"

    private val client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .followRedirects(true)
        .followSslRedirects(true)
        .build()

    private val requestForReleases: Request
        get() = Request.Builder()
            .url(UpdateConfig.RELEASES_API)
            .header("Accept", "application/vnd.github+json")
            .build()

    private val jsonFormat = Json { ignoreUnknownKeys = true }

    // region yt-dlp (unchanged behaviour)

    suspend fun updateYtDlp(): YoutubeDL.UpdateStatus? =
        withContext(Dispatchers.IO) {
            val channel = when (YT_DLP_UPDATE_CHANNEL.getInt()) {
                YT_DLP_NIGHTLY -> YoutubeDL.UpdateChannel.NIGHTLY
                else -> YoutubeDL.UpdateChannel.STABLE
            }

            YoutubeDL.getInstance().updateYoutubeDL(
                appContext = context,
                updateChannel = channel
            ).also {
                if (it == YoutubeDL.UpdateStatus.DONE) {
                    YoutubeDL.getInstance().version(context)?.let { v ->
                        PreferenceUtil.encodeString(YT_DLP_VERSION, v)
                    }
                }
                YT_DLP_UPDATE_TIME.updateLong(System.currentTimeMillis())
            }
        }

    // endregion

    // region release discovery

    /** Newest published release allowed by the selected update channel, or null. */
    suspend fun fetchLatestSuitableRelease(): LatestRelease? = withContext(Dispatchers.IO) {
        runCatching {
            client.newCall(requestForReleases).execute().use { response ->
                if (!response.isSuccessful) {
                    Log.w(TAG, "Release lookup failed: HTTP ${response.code}")
                    return@withContext null
                }
                val body = response.body?.string().orEmpty()
                val releases = jsonFormat.decodeFromString<List<LatestRelease>>(body)
                val stableOnly = UPDATE_CHANNEL.getInt() == STABLE
                releases.asSequence()
                    .filter { it.draft != true }
                    .filter { release ->
                        if (!stableOnly) return@filter true
                        release.preRelease != true && release.version() is Version.Stable
                    }
                    .maxByOrNull { it.version() }
            }
        }.onFailure { Log.w(TAG, "Release lookup error", it) }.getOrNull()
    }

    // endregion

    // region update policy (remote configuration)

    private val requestForPolicy: Request
        get() = Request.Builder()
            .url(UpdateConfig.POLICY_MANIFEST_URL)
            .header("Cache-Control", "no-cache")
            .build()

    /** Fetch the remote policy. Returns null on network/parse failure; callers fall back to cache. */
    suspend fun fetchUpdatePolicy(): UpdatePolicy? = withContext(Dispatchers.IO) {
        runCatching {
            client.newCall(requestForPolicy).execute().use { response ->
                if (!response.isSuccessful) {
                    Log.w(TAG, "Policy lookup failed: HTTP ${response.code}")
                    return@withContext null
                }
                val text = response.body?.string().orEmpty()
                val policy = jsonFormat.decodeFromString<UpdatePolicy>(text)
                UPDATE_POLICY_JSON.updateString(text)
                UPDATE_POLICY_TIME.updateLong(System.currentTimeMillis())
                policy
            }
        }.onFailure { Log.w(TAG, "Policy lookup error", it) }.getOrNull()
    }

    /** Last successfully fetched policy, used when the network is unavailable. */
    fun cachedUpdatePolicy(): UpdatePolicy? = runCatching {
        val text = UPDATE_POLICY_JSON.getString()
        if (text.isBlank()) null else jsonFormat.decodeFromString<UpdatePolicy>(text)
    }.getOrNull()

    fun cachedPolicyAgeMs(): Long = System.currentTimeMillis() - UPDATE_POLICY_TIME.getLong()

    /**
     * Combine the remote policy with the newest published release.
     *
     * The manifest is authoritative for policy (floor, mandatory flag, rollout, wording) while the
     * release is authoritative for the version number and notes.
     */
    fun effectivePolicy(manifest: UpdatePolicy?, release: LatestRelease?): UpdatePolicy? {
        if (manifest == null && release == null) return null
        val releaseVersion = release?.version()
        val latest = listOfNotNull(manifest?.latestVersion.toVersion(), releaseVersion)
            .maxOrNull() ?: EMPTY_VERSION
        val minimum = manifest?.minimumSupportedVersion?.toVersion()
            ?.takeIf { it.toNumber() > 0L } ?: latest
        return UpdatePolicy(
            latestVersion = latest.toVersionName(),
            minimumSupportedVersion = minimum.toVersionName(),
            updateRequired = manifest?.updateRequired ?: true,
            updateUrl = manifest?.updateUrl?.takeIf { it.isNotBlank() }
                ?: release?.htmlUrl.orEmpty(),
            releaseNotes = release?.body?.takeIf { it.isNotBlank() }
                ?: manifest?.releaseNotes.orEmpty(),
            releaseDate = manifest?.releaseDate.orEmpty(),
            rolloutPercentage = manifest?.rolloutPercentage ?: 100,
            forceUpdateMessage = manifest?.forceUpdateMessage.orEmpty(),
        )
    }

    // endregion

    // region installed version

    fun Context.getCurrentVersion(): Version {
        val name = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            packageManager.getPackageInfo(
                packageName, PackageManager.PackageInfoFlags.of(0)
            ).versionName
        } else {
            @Suppress("DEPRECATION")
            packageManager.getPackageInfo(packageName, 0).versionName
        }
        return name.toVersion()
    }

    /** Whether this app may hand an APK to the package installer (user-granted on Android 8+). */
    fun Context.canInstallPackages(): Boolean =
        Build.VERSION.SDK_INT < Build.VERSION_CODES.O || packageManager.canRequestPackageInstalls()

    fun Context.openInstallPermissionSettings() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return
        runCatching {
            startActivity(
                Intent(
                    android.provider.Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,
                    android.net.Uri.parse("package:$packageName")
                ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
        }.onFailure { Log.w(TAG, "Could not open install permission settings", it) }
    }

    // endregion

    // region asset selection & verification

    fun LatestRelease.selectApkAsset(abis: List<String> = Build.SUPPORTED_ABIS.toList()): AssetsItem? {
        val apks = assets.orEmpty().filter { it.name?.endsWith(".apk", ignoreCase = true) == true }
        if (apks.isEmpty()) return null
        for (abi in abis) {
            apks.firstOrNull { it.name?.contains(abi, ignoreCase = true) == true }?.let { return it }
        }
        return apks.firstOrNull { asset ->
            val n = asset.name.orEmpty().lowercase()
            KNOWN_ABIS.none { n.contains(it) }
        } ?: apks.firstOrNull()
    }

    private val KNOWN_ABIS = listOf(
        "arm64-v8a", "armeabi-v7a", "armeabi", "x86_64", "x86", "riscv64", "mips"
    )

    fun LatestRelease.selectChecksumAsset(): AssetsItem? = assets.orEmpty().firstOrNull { a ->
        val n = a.name.orEmpty().lowercase()
        n.endsWith(".sha256") || n.endsWith(".sha256sum") || n.endsWith(".sha256.txt") ||
            n == "sha256sums" || n == "sha256sums.txt" || n.contains("checksum")
    }

    fun isValidApkForRelease(context: Context, file: File, required: LatestRelease): Boolean {
        if (!file.exists() || file.length() <= 0L) return false
        val info = context.packageManager.getPackageArchiveInfo(file.absolutePath, 0) ?: return false
        val archiveVersion = info.versionName.toVersion()
        return archiveVersion >= required.version() && archiveVersion != EMPTY_VERSION
    }

    suspend fun fetchExpectedSha256(asset: AssetsItem, apkName: String): String? =
        withContext(Dispatchers.IO) {
            val url = asset.browserDownloadUrl ?: return@withContext null
            runCatching {
                client.newCall(Request.Builder().url(url).build()).execute().use { resp ->
                    if (!resp.isSuccessful) return@withContext null
                    parseChecksumManifest(resp.body?.string().orEmpty(), apkName)
                }
            }.onFailure { Log.w(TAG, "Checksum fetch error", it) }.getOrNull()
        }

    internal fun parseChecksumManifest(text: String, apkName: String): String? {
        val lines = text.lineSequence().map { it.trim() }.filter { it.isNotEmpty() }
        val entries = lines.mapNotNull { line ->
            val parts = line.split(Regex("\\s+"), limit = 2)
            val hash = parts.firstOrNull()?.takeIf { HEX64.matches(it) } ?: return@mapNotNull null
            val name = parts.getOrNull(1)?.trimStart('*')?.substringAfterLast('/')?.substringAfterLast('\\')
            hash.lowercase() to name
        }.toList()
        if (entries.isEmpty()) return null
        val match = entries.firstOrNull { it.second.equals(apkName, ignoreCase = true) }
            ?: entries.singleOrNull()?.takeIf { it.second == null }
            ?: entries.firstOrNull { apkName.contains(it.second.orEmpty(), ignoreCase = true) }
        return match?.first
    }

    fun sha256(file: File): String {
        val digest = MessageDigest.getInstance("SHA-256")
        file.inputStream().use { input ->
            val buffer = ByteArray(DEFAULT_BUFFER_SIZE)
            while (true) {
                val read = input.read(buffer)
                if (read <= 0) break
                digest.update(buffer, 0, read)
            }
        }
        return digest.digest().joinToString("") { "%02x".format(it) }
    }

    private val HEX64 = Regex("^[a-fA-F0-9]{64}$")

    // endregion

    // region download & install

    fun Context.getLatestApk(): File = File(getExternalFilesDir("apk"), "latest.apk")
    private fun Context.getStagingApk(): File = File(getExternalFilesDir("apk"), "latest.apk.part")

    fun installLatestApk(context: Context = App.context) = context.run {
        val apk = getLatestApk()
        if (!apk.exists()) {
            ToastUtil.makeToast(R.string.app_update_failed)
            return@run
        }
        runCatching {
            val contentUri = FileProvider.getUriForFile(this, getFileProvider(), apk)
            val intent = Intent(Intent.ACTION_VIEW).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                setDataAndType(contentUri, "application/vnd.android.package-archive")
            }
            startActivity(intent)
        }.onFailure { throwable: Throwable ->
            throwable.printStackTrace()
            ToastUtil.makeToast(R.string.app_update_failed)
        }
    }

    suspend fun deleteOutdatedApk(context: Context = App.context) = context.runCatching {
        val apkFile = getLatestApk()
        if (apkFile.exists()) {
            val apkVersion = packageManager.getPackageArchiveInfo(apkFile.absolutePath, 0)
                ?.versionName.toVersion()
            if (apkVersion <= context.getCurrentVersion()) {
                apkFile.delete()
            }
        }
        getStagingApk().takeIf { it.exists() }?.let { part ->
            if (!apkFile.exists()) part.delete()
        }
    }

    fun downloadApk(
        context: Context = App.context,
        latestRelease: LatestRelease
    ): Flow<DownloadStatus> = flow {
        val apk = context.getLatestApk()
        val part = context.getStagingApk()
        apk.parentFile?.mkdirs()

        if (isValidApkForRelease(context, apk, latestRelease)) {
            emit(DownloadStatus.Progress(100))
            emit(DownloadStatus.Finished(apk))
            return@flow
        }

        val apkAsset = latestRelease.selectApkAsset()
            ?: throw IllegalStateException("No compatible APK asset in release ${latestRelease.tagName ?: latestRelease.name}")
        val url = apkAsset.browserDownloadUrl
            ?: throw IllegalStateException("APK asset has no download URL")
        val expectedHash = latestRelease.selectChecksumAsset()?.let { fetchExpectedSha256(it, apkAsset.name.orEmpty()) }

        var attempt = 0
        var lastError: Exception? = null
        while (attempt < UpdateConfig.MAX_RETRY_ATTEMPTS) {
            attempt++
            try {
                emit(DownloadStatus.Progress(currentPercent(part, apkAsset.size)))
                downloadOnce(url, part, apkAsset.size?.toLong() ?: -1L) { percent ->
                    emit(DownloadStatus.Progress(percent))
                }

                val expectedSize = apkAsset.size?.toLong() ?: -1L
                if (expectedSize > 0 && part.length() != expectedSize) {
                    part.delete()
                    throw IllegalStateException("Downloaded size mismatch")
                }
                if (expectedHash != null) {
                    val actual = sha256(part)
                    if (!actual.equals(expectedHash, ignoreCase = true)) {
                        part.delete()
                        throw IllegalStateException("Checksum verification failed")
                    }
                }
                if (apk.exists()) apk.delete()
                if (!part.renameTo(apk)) {
                    part.copyTo(apk, overwrite = true)
                    part.delete()
                }
                if (!isValidApkForRelease(context, apk, latestRelease)) {
                    apk.delete()
                    throw IllegalStateException("Downloaded file is not a valid update package")
                }
                emit(DownloadStatus.Progress(100))
                emit(DownloadStatus.Finished(apk))
                return@flow
            } catch (e: Exception) {
                lastError = e
                Log.w(TAG, "Download attempt $attempt failed", e)
                if (attempt < UpdateConfig.MAX_RETRY_ATTEMPTS) {
                    emit(DownloadStatus.Progress(currentPercent(part, apkAsset.size)))
                    delay(UpdateConfig.RETRY_DELAY_MS)
                }
            }
        }
        throw (lastError ?: IllegalStateException("Download failed"))
    }.flowOn(Dispatchers.IO).distinctUntilChanged()

    private fun currentPercent(part: File, knownSize: Int?): Int {
        val total = (knownSize ?: -1).toLong()
        if (total <= 0L) return 0
        val have = if (part.exists()) part.length() else 0L
        return ((have.coerceAtMost(total) * 100) / total).toInt()
    }

    private inline fun downloadOnce(
        url: String,
        dest: File,
        knownTotal: Long,
        onProgress: (Int) -> Unit
    ) {
        val existing = if (dest.exists()) dest.length() else 0L
        val requestBuilder = Request.Builder().url(url)
        if (existing > 0) {
            requestBuilder.header("Range", "bytes=$existing-")
        }
        client.newCall(requestBuilder.build()).execute().use { response ->
            if (!(response.isSuccessful || response.code == 206)) {
                throw IllegalStateException("HTTP ${response.code}")
            }
            val body = response.body ?: throw IllegalStateException("Empty response body")
            val isPartial = response.code == 206
            val append = isPartial && existing > 0
            val resumeFrom = if (append) existing else 0L
            if (!append && dest.exists()) dest.delete()

            val total = when {
                isPartial -> {
                    val cr = response.header("Content-Range")
                    val totalStr = cr?.substringAfter('/')?.takeIf { it != "*" }
                    totalStr?.toLongOrNull() ?: (if (knownTotal > 0) knownTotal else resumeFrom + body.contentLength())
                }
                body.contentLength() > 0 -> body.contentLength()
                knownTotal > 0 -> knownTotal
                else -> -1L
            }

            val out = if (append) FileOutputStream(dest, true) else FileOutputStream(dest, false)
            out.use { output ->
                body.byteStream().use { input ->
                    val buffer = ByteArray(8_192)
                    var downloaded = resumeFrom
                    while (true) {
                        val read = input.read(buffer)
                        if (read == -1) break
                        output.write(buffer, 0, read)
                        downloaded += read
                        if (total > 0) {
                            onProgress(((downloaded.coerceAtMost(total) * 100) / total).toInt())
                        }
                    }
                    output.flush()
                }
            }
            if (total > 0 && dest.length() > total) {
                RandomAccessFile(dest, "rw").use { it.setLength(total) }
            }
        }
    }

    // endregion

    // region models

    @Serializable
    data class LatestRelease(
        @SerialName("html_url") val htmlUrl: String? = null,
        @SerialName("tag_name") val tagName: String? = null,
        val name: String? = null,
        val draft: Boolean? = null,
        @SerialName("prerelease") val preRelease: Boolean? = null,
        @SerialName("created_at") val createdAt: String? = null,
        @SerialName("published_at") val publishedAt: String? = null,
        val assets: List<AssetsItem>? = null,
        val body: String? = null,
    ) {
        fun version(): Version = (tagName ?: name).toVersion()
    }

    @Serializable
    data class AssetsItem(
        val name: String? = null,
        @SerialName("content_type") val contentType: String? = null,
        val size: Int? = null,
        @SerialName("download_count") val downloadCount: Int? = null,
        @SerialName("created_at") val createdAt: String? = null,
        @SerialName("updated_at") val updatedAt: String? = null,
        @SerialName("browser_download_url") val browserDownloadUrl: String? = null,
    )

    sealed class DownloadStatus {
        data class Progress(val percent: Int) : DownloadStatus()
        data class Finished(val file: File) : DownloadStatus()
    }

    // endregion

    // region versioning

    private val pattern = Pattern.compile(
        """v?(\d+)\.(\d+)\.(\d+)(?:[.\-](?:(alpha|beta|rc)[.\-]?(\d+)|(\d+)))?""",
        Pattern.CASE_INSENSITIVE
    )
    private val EMPTY_VERSION = Version.Stable()

    fun String?.toVersion(): Version = this?.run {
        val matcher = pattern.matcher(this)
        if (matcher.find()) {
            val major = matcher.group(1)?.toIntOrNull() ?: 0
            val minor = matcher.group(2)?.toIntOrNull() ?: 0
            val patch = matcher.group(3)?.toIntOrNull() ?: 0
            val qualifier = matcher.group(4)?.lowercase()
            val qualifierBuild = matcher.group(5)?.toIntOrNull()
            val plainBuild = matcher.group(6)?.toIntOrNull() ?: 0
            when (qualifier) {
                "alpha" -> Version.Alpha(major, minor, patch, qualifierBuild ?: 0)
                "beta" -> Version.Beta(major, minor, patch, qualifierBuild ?: 0)
                "rc" -> Version.ReleaseCandidate(major, minor, patch, qualifierBuild ?: 0)
                else -> Version.Stable(major, minor, patch, max(plainBuild, 0))
            }
        } else EMPTY_VERSION
    } ?: EMPTY_VERSION

    sealed class Version(
        val major: Int,
        val minor: Int,
        val patch: Int,
        val build: Int = 0
    ) : Comparable<Version> {
        companion object {
            private const val BUILD = 1L
            private const val PATCH = 100L
            private const val MINOR = 10_000L
            private const val MAJOR = 1_000_000L
        }

        abstract fun toVersionName(): String
        abstract fun toNumber(): Long

        class Alpha(versionMajor: Int = 0, versionMinor: Int = 0, versionPatch: Int = 0, versionBuild: Int = 0) :
            Version(versionMajor, versionMinor, versionPatch, versionBuild) {
            override fun toVersionName(): String = "${major}.${minor}.${patch}-alpha.$build"
            override fun toNumber(): Long = major * MAJOR + minor * MINOR + patch * PATCH + build * BUILD
        }

        class Beta(versionMajor: Int, versionMinor: Int, versionPatch: Int, versionBuild: Int) :
            Version(versionMajor, versionMinor, versionPatch, versionBuild) {
            override fun toVersionName(): String = "${major}.${minor}.${patch}-beta.$build"
            override fun toNumber(): Long = major * MAJOR + minor * MINOR + patch * PATCH + build * BUILD + 50
        }

        class ReleaseCandidate(versionMajor: Int, versionMinor: Int, versionPatch: Int, versionBuild: Int) :
            Version(versionMajor, versionMinor, versionPatch, versionBuild) {
            override fun toVersionName(): String = "${major}.${minor}.${patch}-rc.$build"
            override fun toNumber(): Long = major * MAJOR + minor * MINOR + patch * PATCH + build * BUILD + 75
        }

        class Stable(versionMajor: Int = 0, versionMinor: Int = 0, versionPatch: Int = 0, versionBuild: Int = 0) :
            Version(versionMajor, versionMinor, versionPatch, versionBuild) {
            override fun toVersionName(): String =
                if (build > 0) "${major}.${minor}.${patch}.${build}" else "${major}.${minor}.${patch}"

            override fun toNumber(): Long =
                major * MAJOR + minor * MINOR + patch * PATCH + build * BUILD + 100
        }

        override operator fun compareTo(other: Version): Int =
            this.toNumber().compareTo(other.toNumber())

        override fun toString(): String = toVersionName()
    }

    // endregion
}
