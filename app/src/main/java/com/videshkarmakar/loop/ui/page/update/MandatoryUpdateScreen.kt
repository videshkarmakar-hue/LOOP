package com.videshkarmakar.loop.ui.page.update

import android.Manifest
import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.videshkarmakar.loop.R
import com.videshkarmakar.loop.ui.theme.Matte
import com.videshkarmakar.loop.ui.theme.MilkerFontFamily
import com.videshkarmakar.loop.util.UpdateCoordinator
import com.videshkarmakar.loop.util.UPDATE_NOTIFIED_VERSION
import com.videshkarmakar.loop.util.PreferenceUtil.updateString
import com.videshkarmakar.loop.util.UpdateUtil.canInstallPackages
import com.videshkarmakar.loop.util.UpdateUtil.openInstallPermissionSettings

@Composable
fun MandatoryUpdateGate(content: @Composable () -> Unit) {
    val status by UpdateCoordinator.status.collectAsStateWithLifecycle()
    val context = LocalContext.current
    var promptedVersion by remember { mutableStateOf<String?>(null) }
    val notificationPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) {
            val current = UpdateCoordinator.status.value
            if (!current.upToDate && current.latestVersion.isNotBlank()) {
                val posted = com.videshkarmakar.loop.util.NotificationUtil.notifyAppUpdate(
                    context,
                    current.latestVersion,
                    current.mandatory
                )
                if (posted) {
                    UPDATE_NOTIFIED_VERSION.updateString(current.latestVersion)
                }
            }
        }
    }

    LaunchedEffect(status.visible, status.latestVersion, status.phase, status.requirement) {
        val version = status.latestVersion
        val updateFound = status.requirement != com.videshkarmakar.loop.util.Requirement.NONE
        if (
            Build.VERSION.SDK_INT >= 33 &&
            version.isNotBlank() &&
            updateFound &&
            (status.visible || status.phase == com.videshkarmakar.loop.util.UpdateCoordinator.Phase.IDLE) &&
            promptedVersion != version &&
            !com.videshkarmakar.loop.util.NotificationUtil.areNotificationsEnabled()
        ) {
            promptedVersion = version
            notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    content()
    if (status.visible) {
        UpdateModal(status)
    }
}

@Composable
private fun UpdateModal(status: UpdateCoordinator.Status) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val required = status.mandatory
    var installAllowed by remember { mutableStateOf(context.canInstallPackages()) }

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                installAllowed = context.canInstallPackages()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }

    LaunchedEffect(status.readyToInstall, installAllowed) {
        if (status.readyToInstall && installAllowed) {
            UpdateCoordinator.installIfReady(context)
        }
    }

    BackHandler(enabled = required) {}

    var shown by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { shown = true }
    val scale by animateFloatAsState(
        targetValue = if (shown) 1f else 0.94f,
        animationSpec = tween(durationMillis = 220, easing = FastOutSlowInEasing),
        label = "updateModalScale"
    )
    val alpha by animateFloatAsState(
        targetValue = if (shown) 1f else 0f,
        animationSpec = tween(durationMillis = 200),
        label = "updateModalAlpha"
    )

    Dialog(
        onDismissRequest = { if (!required) UpdateCoordinator.dismissOptional() },
        properties = DialogProperties(
            dismissOnBackPress = !required,
            dismissOnClickOutside = !required,
            usePlatformDefaultWidth = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.58f * alpha))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    enabled = false
                ) {},
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .widthIn(max = 420.dp)
                    .fillMaxWidth()
                    .scale(scale)
                    .clip(RoundedCornerShape(26.dp))
                    .background(Matte.Surface)
                    .padding(horizontal = 22.dp, vertical = 22.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BrandHeader(required = required)

                Spacer(Modifier.height(18.dp))

                Text(
                    text = stringResource(R.string.update_gate_title),
                    color = Matte.Chalk,
                    fontSize = 23.sp,
                    lineHeight = 28.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = status.message.ifBlank {
                        stringResource(
                            if (required) R.string.update_gate_required else R.string.update_gate_subtitle
                        )
                    },
                    color = Matte.TextSubtle,
                    fontSize = 12.5.sp,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(Modifier.height(18.dp))

                VersionTransition(
                    installed = status.installedVersion.ifBlank { "—" },
                    latest = status.latestVersion.ifBlank { "—" }
                )

                if (status.downloading || status.installing || status.checking) {
                    Spacer(Modifier.height(16.dp))
                    ProgressBlock(status)
                }

                if (status.notes.isNotBlank()) {
                    Spacer(Modifier.height(16.dp))
                    ReleaseNotes(status.notes)
                }

                if (status.error != null) {
                    Spacer(Modifier.height(14.dp))
                    Text(
                        text = stringResource(errorMessage(status)),
                        color = Matte.TextMuted,
                        fontSize = 11.5.sp,
                        lineHeight = 16.sp,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(Modifier.height(20.dp))

                PrimaryAction(
                    status = status,
                    installAllowed = installAllowed,
                    onInstallPermission = { context.openInstallPermissionSettings() }
                )

                if (required) {
                    Spacer(Modifier.height(12.dp))
                    Text(
                        text = stringResource(R.string.update_modal_footer_required),
                        color = Matte.TextMuted,
                        fontSize = 10.5.sp,
                        textAlign = TextAlign.Center
                    )
                } else {
                    Spacer(Modifier.height(4.dp))
                    TextButton(onClick = { UpdateCoordinator.dismissOptional() }) {
                        Text(
                            text = stringResource(R.string.update_modal_not_now),
                            color = Matte.TextSubtle,
                            fontSize = 12.sp
                        )
                    }
                }

                if (status.failed && status.updateUrl.isNotBlank()) {
                    TextButton(onClick = { UpdateCoordinator.startUpdate(context) }) {
                        Text(
                            text = stringResource(R.string.update_modal_open_release),
                            color = Matte.Coral,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun BrandHeader(required: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .width(26.dp)
                .height(13.dp)
                .clip(RoundedCornerShape(topStart = 13.dp, topEnd = 13.dp))
                .background(Matte.Coral)
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = stringResource(R.string.app_name),
            fontFamily = MilkerFontFamily,
            color = Matte.Chalk,
            fontSize = 17.sp,
            fontWeight = FontWeight.Black,
            letterSpacing = (-0.3).sp
        )
        Spacer(Modifier.weight(1f))
        Text(
            text = stringResource(
                if (required) R.string.update_modal_required_badge else R.string.update_modal_optional_badge
            ).uppercase(),
            color = if (required) Matte.Coral else Matte.TextMuted,
            fontSize = 9.sp,
            letterSpacing = 1.4.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(if (required) Matte.Coral.copy(alpha = 0.12f) else Matte.SurfaceHigh)
                .padding(horizontal = 9.dp, vertical = 4.dp)
        )
    }
}

@Composable
private fun VersionTransition(installed: String, latest: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        VersionColumn(
            label = stringResource(R.string.update_modal_installed),
            value = installed,
            accent = false,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "→",
            color = Matte.TextMuted,
            fontSize = 15.sp,
            modifier = Modifier.padding(horizontal = 6.dp)
        )
        VersionColumn(
            label = stringResource(R.string.update_modal_latest),
            value = latest,
            accent = true,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun VersionColumn(label: String, value: String, accent: Boolean, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(Matte.Background)
            .padding(vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label.uppercase(),
            color = Matte.TextMuted,
            fontSize = 8.5.sp,
            letterSpacing = 1.3.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(Modifier.height(3.dp))
        Text(
            text = value,
            color = if (accent) Matte.Coral else Matte.Chalk,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun ProgressBlock(status: UpdateCoordinator.Status) {
    val percent = status.percent
    val progress by animateFloatAsState(
        targetValue = percent / 100f,
        animationSpec = tween(durationMillis = 350, easing = FastOutSlowInEasing),
        label = "updateProgress"
    )
    val label = when {
        status.checking -> stringResource(R.string.update_gate_checking)
        status.readyToInstall -> stringResource(R.string.update_modal_installing)
        percent >= 100 -> stringResource(R.string.update_gate_verifying)
        percent <= 0 -> stringResource(R.string.update_modal_preparing)
        else -> stringResource(R.string.update_modal_downloading, percent)
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(text = label, color = Matte.TextSubtle, fontSize = 11.5.sp, modifier = Modifier.weight(1f))
            Text(text = "$percent%", color = Matte.Chalk, fontSize = 11.5.sp, fontWeight = FontWeight.SemiBold)
        }
        Spacer(Modifier.height(8.dp))
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .clip(RoundedCornerShape(2.dp)),
            color = Matte.Coral,
            trackColor = Matte.Outline
        )
    }
}

@Composable
private fun ReleaseNotes(notes: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(Matte.Background)
            .padding(14.dp)
    ) {
        Text(
            text = stringResource(R.string.update_modal_whats_new).uppercase(),
            color = Matte.TextMuted,
            fontSize = 8.5.sp,
            letterSpacing = 1.3.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(Modifier.height(6.dp))
        Text(
            text = notes,
            color = Matte.TextSubtle,
            fontSize = 11.5.sp,
            lineHeight = 17.sp,
            modifier = Modifier
                .heightIn(max = 168.dp)
                .verticalScroll(rememberScrollState())
        )
    }
}

@Composable
private fun PrimaryAction(
    status: UpdateCoordinator.Status,
    installAllowed: Boolean,
    onInstallPermission: () -> Unit
) {
    val context = LocalContext.current
    val readyToInstall = status.readyToInstall
    val label = when {
        status.downloading -> stringResource(R.string.update_modal_downloading, status.percent)
        readyToInstall && !installAllowed -> stringResource(R.string.update_gate_allow_installs)
        readyToInstall -> stringResource(R.string.update_modal_install)
        status.failed -> stringResource(R.string.update_modal_retry)
        else -> stringResource(R.string.update_modal_update_now)
    }

    Button(
        onClick = {
            if (readyToInstall && !installAllowed) onInstallPermission()
            else UpdateCoordinator.startUpdate(context)
        },
        enabled = !status.downloading,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Matte.Coral,
            contentColor = Color.White,
            disabledContainerColor = Matte.SurfaceHigh,
            disabledContentColor = Matte.TextSubtle
        )
    ) {
        Text(text = label, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
    }
}

private fun errorMessage(status: UpdateCoordinator.Status): Int = when (status.error) {
    UpdateCoordinator.ERROR_INSTALL_CANCELLED -> R.string.update_modal_error_install
    UpdateCoordinator.ERROR_RELEASE_UNAVAILABLE -> R.string.update_modal_error_release
    UpdateCoordinator.ERROR_OFFLINE -> R.string.update_modal_error_offline
    else -> R.string.update_modal_error_generic
}
