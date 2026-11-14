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
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.videshkarmakar.loop.ui.theme.MilkerFontFamily
import com.videshkarmakar.loop.util.NotificationUtil
import com.videshkarmakar.loop.util.PreferenceUtil.updateString
import com.videshkarmakar.loop.util.Requirement
import com.videshkarmakar.loop.util.UPDATE_NOTIFIED_VERSION
import com.videshkarmakar.loop.util.UpdateCoordinator
import com.videshkarmakar.loop.util.UpdateUtil.canInstallPackages
import com.videshkarmakar.loop.util.UpdateUtil.openInstallPermissionSettings

private val Surface = Color(0xFF15171C)
private val SubSurface = Color(0xFF1B1E24)
private val SubCard = Color(0xFF121417)
private val Border = Color(0xFF232730)
private val Coral = Color(0xFFF75254)
private val CoralMuted = Color(0x1FF75254)
private val TextMuted = Color(0xFF9BA3AF)
private val TextSubtle = Color(0xFF636A78)
private val TextDark = Color(0xFF444A56)

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
                val posted = NotificationUtil.notifyAppUpdate(
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
        val updateFound = status.requirement != Requirement.NONE
        if (
            Build.VERSION.SDK_INT >= 33 &&
            version.isNotBlank() &&
            updateFound &&
            (status.visible || status.phase == UpdateCoordinator.Phase.IDLE) &&
            promptedVersion != version &&
            !NotificationUtil.areNotificationsEnabled()
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
        targetValue = if (shown) 1f else 0.96f,
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
                .background(Color.Black.copy(alpha = 0.52f * alpha))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    enabled = false
                ) {},
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .widthIn(max = 430.dp)
                    .fillMaxWidth()
                    .scale(scale)
                    .clip(RoundedCornerShape(28.dp))
                    .background(Surface)
                    .border(1.dp, Color.White.copy(alpha = 0.07f), RoundedCornerShape(28.dp))
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BrandHeader(required = required)

                Spacer(Modifier.height(20.dp))

                Text(
                    text = stringResource(R.string.update_gate_title),
                    color = Color.White,
                    fontSize = 24.sp,
                    lineHeight = 31.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    letterSpacing = (-0.3).sp
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = status.message.ifBlank {
                        stringResource(
                            if (required) R.string.update_gate_required else R.string.update_gate_subtitle
                        )
                    },
                    color = TextMuted,
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                Spacer(Modifier.height(24.dp))

                VersionComparison(
                    installed = status.installedVersion.ifBlank { "—" },
                    latest = status.latestVersion.ifBlank { "—" }
                )

                Spacer(Modifier.height(20.dp))

                ProgressSection(status)

                if (status.notes.isNotBlank()) {
                    Spacer(Modifier.height(20.dp))
                    ReleaseNotes(status.notes)
                }

                if (status.error != null) {
                    Spacer(Modifier.height(12.dp))
                    Text(
                        text = stringResource(errorMessage(status)),
                        color = TextMuted,
                        fontSize = 11.sp,
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
                    Spacer(Modifier.height(14.dp))
                    Text(
                        text = stringResource(R.string.update_modal_footer_required),
                        color = TextSubtle,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center
                    )
                } else {
                    Spacer(Modifier.height(6.dp))
                    TextButton(onClick = { UpdateCoordinator.dismissOptional() }) {
                        Text(
                            text = stringResource(R.string.update_modal_not_now),
                            color = TextMuted,
                            fontSize = 12.sp
                        )
                    }
                }

                if (status.failed && status.updateUrl.isNotBlank()) {
                    TextButton(onClick = { UpdateCoordinator.startUpdate(context) }) {
                        Text(
                            text = stringResource(R.string.update_modal_open_release),
                            color = Coral,
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
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(width = 24.dp, height = 12.dp)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                    .background(Coral)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = stringResource(R.string.app_name),
                fontFamily = MilkerFontFamily,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Black,
                letterSpacing = (-0.4).sp
            )
        }
        Spacer(Modifier.weight(1f))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(if (required) CoralMuted else Color.White.copy(alpha = 0.08f))
                .border(
                    1.dp,
                    if (required) Coral.copy(alpha = 0.2f) else Color.White.copy(alpha = 0.08f),
                    RoundedCornerShape(50)
                )
                .padding(horizontal = 10.dp, vertical = 4.dp)
        ) {
            Text(
                text = stringResource(
                    if (required) R.string.update_modal_required_badge else R.string.update_modal_optional_badge
                ).uppercase(),
                color = if (required) Coral else TextMuted,
                fontSize = 10.sp,
                letterSpacing = 0.8.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun VersionComparison(installed: String, latest: String) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            VersionBox(
                label = stringResource(R.string.update_modal_installed),
                value = installed,
                accent = false,
                modifier = Modifier.weight(1f)
            )
            VersionBox(
                label = stringResource(R.string.update_modal_latest),
                value = latest,
                accent = true,
                modifier = Modifier.weight(1f)
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .clip(CircleShape)
                .background(Surface)
                .padding(horizontal = 2.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "→", color = TextSubtle, fontSize = 12.sp)
        }
    }
}

@Composable
private fun VersionBox(label: String, value: String, accent: Boolean, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(SubSurface.copy(alpha = 0.9f))
            .border(1.dp, Border.copy(alpha = 0.6f), RoundedCornerShape(12.dp))
            .padding(vertical = 14.dp, horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label.uppercase(),
            color = TextSubtle,
            fontSize = 9.sp,
            letterSpacing = 1.2.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = value,
            color = if (accent) Coral else Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = (-0.2).sp
        )
    }
}

@Composable
private fun ProgressSection(status: UpdateCoordinator.Status) {
    val percent = status.percent.coerceIn(0, 100)
    val progress by animateFloatAsState(
        targetValue = percent / 100f,
        animationSpec = tween(durationMillis = 350, easing = FastOutSlowInEasing),
        label = "updateProgress"
    )
    val statusLabel = when {
        status.checking -> stringResource(R.string.update_gate_checking)
        status.installing || status.readyToInstall -> stringResource(R.string.update_modal_installing)
        status.downloading && percent >= 100 -> stringResource(R.string.update_gate_verifying)
        status.downloading && percent > 0 -> stringResource(R.string.update_modal_downloading, percent)
        status.downloading -> stringResource(R.string.update_modal_preparing)
        status.failed -> stringResource(R.string.update_modal_error_generic)
        else -> stringResource(R.string.update_modal_preparing)
    }
    val percentLabel = if (status.downloading || status.installing || status.readyToInstall) "$percent%" else if (status.checking) "" else "0%"

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = statusLabel,
                color = TextMuted,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.weight(1f)
            )
            if (percentLabel.isNotEmpty()) {
                Text(
                    text = percentLabel,
                    color = Color.White,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        Spacer(Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .clip(RoundedCornerShape(999.dp))
                .background(Border)
        ) {
            val trackWidthFraction = if (status.downloading || status.readyToInstall || status.installing) progress.coerceAtLeast(0.01f) else 0.01f
            Box(
                modifier = Modifier
                    .fillMaxWidth(trackWidthFraction)
                    .height(3.dp)
                    .clip(RoundedCornerShape(999.dp))
                    .background(Coral)
            )
            Box(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .fillMaxWidth(trackWidthFraction)
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = 3.dp)
                        .size(6.dp)
                        .clip(CircleShape)
                        .background(Coral)
                )
            }
        }
    }
}

@Composable
private fun ReleaseNotes(notes: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(SubCard)
            .border(1.dp, Border.copy(alpha = 0.7f), RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.update_modal_whats_new).uppercase(),
            color = TextSubtle,
            fontSize = 9.sp,
            letterSpacing = 1.2.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = notes,
            color = Color.White.copy(alpha = 0.8f),
            fontSize = 12.sp,
            lineHeight = 18.sp,
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
    val busy = status.downloading || status.installing || status.checking
    val label = when {
        status.downloading -> stringResource(R.string.update_modal_downloading, status.percent)
        status.installing || (readyToInstall && installAllowed) -> stringResource(R.string.update_modal_installing)
        readyToInstall && !installAllowed -> stringResource(R.string.update_gate_allow_installs)
        status.failed -> stringResource(R.string.update_modal_retry)
        status.checking -> stringResource(R.string.update_gate_checking)
        else -> stringResource(R.string.update_modal_update_now)
    }
    val enabled = when {
        status.downloading -> false
        status.installing -> false
        status.checking -> false
        readyToInstall && installAllowed -> true
        readyToInstall -> true
        else -> true
    }

    val bg = if (busy) SubSurface else Coral
    val fg = if (busy) Color.White else Color.White
    val borderColor = if (busy) Color.White.copy(alpha = 0.05f) else Color.Transparent

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(bg)
            .border(1.dp, borderColor, RoundedCornerShape(12.dp))
            .clickable(enabled = enabled) {
                when {
                    readyToInstall && !installAllowed -> onInstallPermission()
                    else -> UpdateCoordinator.startUpdate(context)
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            color = fg,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

private fun errorMessage(status: UpdateCoordinator.Status): Int = when (status.error) {
    UpdateCoordinator.ERROR_INSTALL_CANCELLED -> R.string.update_modal_error_install
    UpdateCoordinator.ERROR_RELEASE_UNAVAILABLE -> R.string.update_modal_error_release
    UpdateCoordinator.ERROR_OFFLINE -> R.string.update_modal_error_offline
    else -> R.string.update_modal_error_generic
}
