package com.videshkarmakar.loop.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import com.videshkarmakar.loop.App
import com.videshkarmakar.loop.util.PreferenceUtil.getBoolean
import com.videshkarmakar.loop.util.PreferenceUtil.getString
import com.videshkarmakar.loop.util.PreferenceUtil.updateString
import com.videshkarmakar.loop.util.UpdateUtil.Version
import com.videshkarmakar.loop.util.UpdateUtil.canInstallPackages
import com.videshkarmakar.loop.util.UpdateUtil.getCurrentVersion
import com.videshkarmakar.loop.util.UpdateUtil.getLatestApk
import com.videshkarmakar.loop.util.UpdateUtil.installLatestApk
import com.videshkarmakar.loop.util.UpdateUtil.isValidApkForRelease
import com.videshkarmakar.loop.util.UpdateUtil.openInstallPermissionSettings
import com.videshkarmakar.loop.util.UpdateUtil.toVersion
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.util.UUID

object UpdateCoordinator {

    private const val TAG = "UpdateCoordinator"

    const val ERROR_OFFLINE = "offline"
    const val ERROR_RELEASE_UNAVAILABLE = "release_unavailable"
    const val ERROR_INSTALL_CANCELLED = "install_cancelled"

    enum class Phase { CHECKING, IDLE, DOWNLOADING, INSTALLING, FAILED }
    enum class Trigger { LAUNCH, RESUME, NAVIGATION, PERIODIC, MANUAL }

    data class Status(
        val phase: Phase = Phase.CHECKING,
        val requirement: Requirement = Requirement.NONE,
        val installedVersion: String = "",
        val latestVersion: String = "",
        val percent: Int = 0,
        val error: String? = null,
        val notes: String = "",
        val message: String = "",
        val updateUrl: String = "",
        val dismissed: Boolean = false,
    ) {
        val mandatory: Boolean get() = requirement == Requirement.REQUIRED
        /** Mandatory updates are never hidden by a stale dismissed flag. */
        val visible: Boolean get() = requirement != Requirement.NONE && !(dismissed && !mandatory)
        val upToDate: Boolean get() = requirement == Requirement.NONE && phase == Phase.IDLE
        val checking: Boolean get() = phase == Phase.CHECKING
        val downloading: Boolean get() = phase == Phase.DOWNLOADING
        val installing: Boolean get() = phase == Phase.INSTALLING
        val failed: Boolean get() = phase == Phase.FAILED
        val readyToInstall: Boolean get() = phase == Phase.INSTALLING && percent >= 100
        val busy: Boolean get() = phase == Phase.DOWNLOADING || phase == Phase.INSTALLING
    }

    private val _status = MutableStateFlow(Status())
    val status: StateFlow<Status> = _status.asStateFlow()

    private var loopJob: Job? = null
    private var downloadJob: Job? = null
    private var checking = false
    private var lastCheckAt = 0L
    private var release: UpdateUtil.LatestRelease? = null
    private var releaseFetchedAt = 0L
    private var installerLaunched = false
    /** Prevents re-triggering an automatic download on every check for the same version. */
    private var autoDownloadTriedVersion: String = ""

    fun start() {
        if (loopJob?.isActive == true) return
        loopJob = App.applicationScope.launch(Dispatchers.IO) {
            runCatching { applyCachedPolicy() }
            runCatching { reconcileReadyPackage(App.context) }
            while (isActive) {
                refresh(Trigger.PERIODIC)
                delay(UpdateConfig.PERIODIC_CHECK_INTERVAL_MS)
            }
        }
    }

    fun refresh(trigger: Trigger = Trigger.MANUAL) {
        if (trigger == Trigger.MANUAL) {
            release = null
            releaseFetchedAt = 0L
            autoDownloadTriedVersion = ""
        }
        App.applicationScope.launch(Dispatchers.IO) {
            runCatching { checkForUpdates(trigger) }
                .onFailure { Log.w(TAG, "Update check failed", it) }
        }
    }

    fun onNavigation() = refresh(Trigger.NAVIGATION)

    fun refreshAfterResume(context: Context = App.context) {
        if (installerLaunched) {
            installerLaunched = false
            val current = _status.value
            _status.value = if (installedSatisfies(context, current)) {
                UPDATE_OPTIONAL_DISMISSED.updateString("")
                UPDATE_NOTIFIED_VERSION.updateString("")
                current.copy(phase = Phase.IDLE, requirement = Requirement.NONE, error = null, dismissed = false)
            } else {
                // Installation wasn't completed: require an explicit retry, don't loop the installer.
                autoDownloadTriedVersion = current.latestVersion
                current.copy(phase = Phase.FAILED, error = ERROR_INSTALL_CANCELLED)
            }
        }
        refresh(Trigger.RESUME)
    }

    fun startUpdate(context: Context = App.context) {
        val current = _status.value
        val pending = release
        when {
            current.readyToInstall -> launchInstaller(context)
            current.busy -> Unit
            pending != null && isValidApkForRelease(context, context.getLatestApk(), pending) -> {
                _status.value = current.copy(phase = Phase.INSTALLING, percent = 100, error = null)
                launchInstaller(context)
            }
            pending != null -> {
                autoDownloadTriedVersion = ""
                startDownload(context)
            }
            current.updateUrl.isNotBlank() -> openUrl(context, current.updateUrl)
            else -> {
                autoDownloadTriedVersion = ""
                refresh()
            }
        }
    }

    fun installIfReady(context: Context = App.context) {
        if (_status.value.readyToInstall) launchInstaller(context)
    }

    fun dismissOptional() {
        val current = _status.value
        if (current.requirement != Requirement.OPTIONAL) return
        UPDATE_OPTIONAL_DISMISSED.updateString(current.latestVersion)
        _status.value = current.copy(dismissed = true)
    }

    private suspend fun checkForUpdates(trigger: Trigger) {
        if (checking || _status.value.busy) return
        if (System.currentTimeMillis() - lastCheckAt < trigger.throttleMs) return
        checking = true
        try {
            if (!_status.value.visible && !_status.value.failed) {
                _status.value = _status.value.copy(phase = Phase.CHECKING, error = null)
            }
            performCheck(App.context)
        } finally {
            checking = false
            lastCheckAt = System.currentTimeMillis()
        }
    }

    private suspend fun performCheck(context: Context) {
        val installed = context.getCurrentVersion()
        val pending = releaseWithCache()
        val policy = UpdateUtil.effectivePolicy(policyWithCache(), pending)
        if (policy == null) {
            _status.value = _status.value.copy(phase = Phase.FAILED, error = ERROR_OFFLINE, installedVersion = installed.toVersionName())
            return
        }

        val requirement = policy.decide(installed, rolloutBucket())
        if (requirement == Requirement.NONE) {
            autoDownloadTriedVersion = ""
            UPDATE_OPTIONAL_DISMISSED.updateString("")
            emit(policy, installed, Phase.IDLE)
            Log.i(TAG, "Update check: up to date ($installed)")
            return
        }

        // Reuse an already-verified package instead of downloading again.
        val ready = pending?.let { isValidApkForRelease(context, context.getLatestApk(), it) } == true
        emit(policy, installed, if (ready) Phase.INSTALLING else Phase.IDLE, percent = if (ready) 100 else 0)
        maybeNotifyUpdate(context, policy, requirement)
        Log.i(TAG, "Update check: installed=$installed latest=${policy.latestVersion} requirement=$requirement ready=$ready")

        if (ready) {
            if (requirement == Requirement.REQUIRED) tryLaunchInstaller(context)
            return
        }

        // Auto-download mandatory updates once per version on an unmetered connection.
        if (requirement == Requirement.REQUIRED && canAutoDownload() && autoDownloadTriedVersion != policy.latestVersion) {
            autoDownloadTriedVersion = policy.latestVersion
            startDownload(context)
        }
    }

    private fun emit(policy: UpdatePolicy, installed: Version, phase: Phase, percent: Int = 0, error: String? = null) {
        val requirement = policy.decide(installed, rolloutBucket())
        val storedDismissed = UPDATE_OPTIONAL_DISMISSED.getString() == policy.latestVersion
        _status.value = Status(
            phase = phase,
            requirement = requirement,
            installedVersion = installed.toVersionName(),
            latestVersion = policy.latestVersion,
            percent = percent,
            error = error,
            notes = policy.releaseNotes,
            message = policy.forceUpdateMessage,
            updateUrl = policy.updateUrl,
            // A mandatory update must never stay hidden because it was dismissed earlier.
            dismissed = storedDismissed && requirement != Requirement.REQUIRED,
        )
    }

    private fun applyCachedPolicy(context: Context = App.context) {
        val policy = UpdateUtil.cachedUpdatePolicy() ?: return
        emit(policy, context.getCurrentVersion(), Phase.IDLE)
    }

    private fun reconcileReadyPackage(context: Context) {
        val current = _status.value
        if (current.requirement == Requirement.NONE || current.busy) return
        val pending = release ?: return
        if (isValidApkForRelease(context, context.getLatestApk(), pending)) {
            _status.value = current.copy(phase = Phase.INSTALLING, percent = 100, error = null)
            if (current.mandatory) tryLaunchInstaller(context)
        }
    }

    private suspend fun policyWithCache(): UpdatePolicy? {
        val age = UpdateUtil.cachedPolicyAgeMs()
        return if (age in 0 until UpdateConfig.POLICY_CACHE_TTL_MS) {
            UpdateUtil.cachedUpdatePolicy() ?: UpdateUtil.fetchUpdatePolicy()
        } else {
            UpdateUtil.fetchUpdatePolicy() ?: UpdateUtil.cachedUpdatePolicy()
        }
    }

    private suspend fun releaseWithCache(): UpdateUtil.LatestRelease? {
        val cached = release
        if (cached != null && System.currentTimeMillis() - releaseFetchedAt < UpdateConfig.RELEASE_CACHE_TTL_MS) return cached
        val fetched = runCatching { UpdateUtil.fetchLatestSuitableRelease() }
            .onFailure { Log.w(TAG, "Release lookup failed", it) }.getOrNull()
        if (fetched != null) { release = fetched; releaseFetchedAt = System.currentTimeMillis(); return fetched }
        return cached
    }

    private fun startDownload(context: Context) {
        if (downloadJob?.isActive == true) return
        val pending = release
        if (pending == null) {
            _status.value = _status.value.copy(phase = Phase.FAILED, error = ERROR_RELEASE_UNAVAILABLE)
            return
        }
        if (isValidApkForRelease(context, context.getLatestApk(), pending)) {
            _status.value = _status.value.copy(phase = Phase.INSTALLING, percent = 100, error = null)
            tryLaunchInstaller(context)
            return
        }
        downloadJob = App.applicationScope.launch(Dispatchers.IO) {
            _status.value = _status.value.copy(phase = Phase.DOWNLOADING, percent = 0, error = null)
            try {
                UpdateUtil.downloadApk(context, pending).collect { ds ->
                    when (ds) {
                        is UpdateUtil.DownloadStatus.Progress -> {
                            _status.value = _status.value.copy(phase = Phase.DOWNLOADING, percent = ds.percent)
                        }
                        is UpdateUtil.DownloadStatus.Finished -> {
                            _status.value = _status.value.copy(phase = Phase.INSTALLING, percent = 100, error = null)
                            // Auto-install once the package is verified and ready.
                            tryLaunchInstaller(context)
                        }
                    }
                }
            } catch (t: Throwable) {
                Log.w(TAG, "Update download failed", t)
                _status.value = _status.value.copy(phase = Phase.FAILED, error = t.message ?: "download_failed")
            }
        }
    }

    /** Hand off to the system installer when a package is ready and installs are permitted. */
    private fun tryLaunchInstaller(context: Context) {
        if (_status.value.readyToInstall && context.canInstallPackages()) {
            launchInstaller(context)
        }
    }

    private fun launchInstaller(context: Context) {
        if (installerLaunched) return
        if (!context.canInstallPackages()) {
            context.openInstallPermissionSettings()
            return
        }
        installerLaunched = true
        installLatestApk(context)
    }

    private fun installedSatisfies(context: Context, status: Status): Boolean =
        status.requirement == Requirement.NONE || context.getCurrentVersion() >= status.latestVersion.toVersion()

    private fun canAutoDownload(): Boolean {
        if (!UPDATE_AUTO_DOWNLOAD.getBoolean()) return false
        return runCatching { !App.connectivityManager.isActiveNetworkMetered }.getOrDefault(false)
    }

    /** Post a system notification once per discovered update version. */
    private fun maybeNotifyUpdate(context: Context, policy: UpdatePolicy, requirement: Requirement) {
        val version = policy.latestVersion
        if (version.isBlank() || UPDATE_NOTIFIED_VERSION.getString() == version) return
        val posted = runCatching {
            NotificationUtil.notifyAppUpdate(context, version, requirement == Requirement.REQUIRED)
        }.onFailure { Log.w(TAG, "Failed to post update notification", it) }.getOrDefault(false)
        if (posted) UPDATE_NOTIFIED_VERSION.updateString(version)
    }

    private fun rolloutBucket(): Int {
        var id = UPDATE_ROLLOUT_ID.getString()
        if (id.isBlank()) { id = UUID.randomUUID().toString(); UPDATE_ROLLOUT_ID.updateString(id) }
        return (id.hashCode() and Int.MAX_VALUE) % 100
    }

    private fun openUrl(context: Context, url: String) {
        runCatching { context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)) }
            .onFailure { Log.w(TAG, "Could not open $url", it) }
    }

    private val Trigger.throttleMs: Long
        get() = when (this) {
            Trigger.RESUME -> UpdateConfig.RESUME_CHECK_INTERVAL_MS
            Trigger.NAVIGATION -> UpdateConfig.NAVIGATION_CHECK_INTERVAL_MS
            Trigger.LAUNCH, Trigger.MANUAL, Trigger.PERIODIC -> 0L
        }
}
