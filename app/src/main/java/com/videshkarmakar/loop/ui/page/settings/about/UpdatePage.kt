package com.videshkarmakar.loop.ui.page.settings.about

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronLeft
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.videshkarmakar.loop.R
import com.videshkarmakar.loop.util.PRE_RELEASE
import com.videshkarmakar.loop.util.PreferenceUtil.getBoolean
import com.videshkarmakar.loop.util.PreferenceUtil.getInt
import com.videshkarmakar.loop.util.PreferenceUtil.updateBoolean
import com.videshkarmakar.loop.util.PreferenceUtil.updateInt
import com.videshkarmakar.loop.util.STABLE
import com.videshkarmakar.loop.util.UPDATE_AUTO_DOWNLOAD
import com.videshkarmakar.loop.util.UPDATE_CHANNEL
import com.videshkarmakar.loop.util.UpdateCoordinator
import com.videshkarmakar.loop.util.parseReleaseNotes

@Composable
fun UpdatePage(onNavigateBack: () -> Unit) {
    val context = LocalContext.current
    val status by UpdateCoordinator.status.collectAsStateWithLifecycle()

    var autoDownload by remember { mutableStateOf(UPDATE_AUTO_DOWNLOAD.getBoolean()) }
    var channel by remember { mutableStateOf(UPDATE_CHANNEL.getInt()) }
    var showChannelDialog by remember { mutableStateOf(false) }
    var refreshAngle by remember { mutableStateOf(0f) }

    val rotation by animateFloatAsState(
        targetValue = refreshAngle,
        animationSpec = tween(durationMillis = 650, easing = FastOutSlowInEasing),
        label = "updateRefreshRotation"
    )

    val checkNow = {
        refreshAngle += 360f
        UpdateCoordinator.refresh()
    }

    Box(modifier = Modifier.fillMaxSize().background(PageBackground)) {
        Column(modifier = Modifier.fillMaxSize()) {
            UpdateTopBar(
                checking = status.checking,
                rotation = rotation,
                onBack = onNavigateBack,
                onRefresh = checkNow
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 24.dp)
            ) {
                HeroCard(
                    status = status,
                    onPrimary = {
                        if (status.failed || status.checking) checkNow()
                        else UpdateCoordinator.startUpdate(context)
                    },
                    onOpenRelease = {
                        status.updateUrl.takeIf { it.isNotBlank() }?.let { url ->
                            runCatching {
                                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                            }
                        }
                    }
                )

                Spacer(modifier = Modifier.height(22.dp))

                ChangelogSection(
                    version = status.latestVersion.ifBlank { status.installedVersion },
                    notes = status.notes
                )

                Spacer(modifier = Modifier.height(22.dp))

                PreferencesSection(
                    autoDownload = autoDownload,
                    onAutoDownloadChange = {
                        autoDownload = it
                        UPDATE_AUTO_DOWNLOAD.updateBoolean(it)
                    },
                    channel = channel,
                    onChannelClick = { showChannelDialog = true }
                )

                Spacer(modifier = Modifier.height(20.dp))
                Signature()
            }
        }
    }

    if (showChannelDialog) {
        ChannelDialog(
            current = channel,
            onDismiss = { showChannelDialog = false },
            onSelect = { selected ->
                showChannelDialog = false
                if (selected != channel) {
                    channel = selected
                    UPDATE_CHANNEL.updateInt(selected)
                    UpdateCoordinator.refresh()
                }
            }
        )
    }
}

@Composable
private fun UpdateTopBar(checking: Boolean, rotation: Float, onBack: () -> Unit, onRefresh: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircleIconButton(Icons.Outlined.ChevronLeft, stringResource(R.string.back), onBack)
        Text(
            text = stringResource(R.string.update_page_title).uppercase(),
            modifier = Modifier.weight(1f),
            color = TextPrimary,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 1.3.sp,
            textAlign = TextAlign.Center,
            maxLines = 1
        )
        CircleIconButton(
            icon = Icons.Outlined.Refresh,
            description = stringResource(R.string.check_for_updates),
            onClick = onRefresh,
            enabled = !checking,
            rotation = rotation
        )
    }
}

@Composable
private fun CircleIconButton(
    icon: ImageVector,
    description: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    rotation: Float = 0f
) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(CircleSurface)
            .border(1.dp, CircleBorder, CircleShape)
            .clickable(enabled = enabled, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = description,
            tint = if (enabled) TextSubtle else TextDim,
            modifier = Modifier.size(17.dp).rotate(rotation)
        )
    }
}

@Composable
private fun HeroCard(status: UpdateCoordinator.Status, onPrimary: () -> Unit, onOpenRelease: () -> Unit) {
    val shape = RoundedCornerShape(24.dp)
    val targetVersion = status.latestVersion.ifBlank { status.installedVersion }
    val title = when {
        status.checking && status.latestVersion.isBlank() -> stringResource(R.string.update_page_title_checking)
        status.upToDate -> stringResource(R.string.update_page_title_up_to_date, status.installedVersion)
        status.failed -> stringResource(R.string.update_page_title_failed)
        else -> stringResource(R.string.update_page_title_available, targetVersion)
    }

    val pill = when {
        status.downloading -> Pill(stringResource(R.string.update_page_pill_downloading), Crimson)
        status.readyToInstall -> Pill(stringResource(R.string.update_page_pill_installing), Emerald)
        status.installing -> Pill(stringResource(R.string.update_page_pill_installing), Emerald)
        status.upToDate -> Pill(stringResource(R.string.update_page_pill_up_to_date), Emerald)
        status.failed -> Pill(stringResource(R.string.update_page_pill_failed), Amber)
        status.checking -> Pill(stringResource(R.string.update_gate_checking), TextSubtle)
        status.mandatory -> Pill(stringResource(R.string.update_page_pill_required), Emerald)
        else -> Pill(stringResource(R.string.update_page_pill_signed), Emerald)
    }

    val ctaLabel = when {
        status.downloading -> stringResource(R.string.update_page_cta_downloading, status.percent)
        status.installing -> stringResource(R.string.update_page_cta_installing)
        status.failed -> stringResource(R.string.update_page_cta_retry)
        status.upToDate -> stringResource(R.string.update_page_cta_up_to_date)
        status.checking -> stringResource(R.string.update_gate_checking)
        else -> stringResource(R.string.update_page_cta)
    }
    val ctaEnabled = !status.downloading && !status.installing && !status.upToDate

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .background(Brush.verticalGradient(listOf(HeroTop, HeroBottom)))
            .border(1.dp, HeroBorder, shape)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(width = 190.dp, height = 96.dp)
                .clip(RoundedCornerShape(topStart = 96.dp, topEnd = 96.dp))
                .background(Brush.verticalGradient(listOf(Crimson.copy(alpha = 0.22f), Color.Transparent)))
        )

        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_about_app_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(58.dp)
                    .clip(RoundedCornerShape(17.dp))
                    .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(17.dp))
            )

            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = title,
                color = TextPrimary,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-0.2).sp,
                textAlign = TextAlign.Center
            )

            if (status.installedVersion.isNotBlank()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stringResource(R.string.update_page_installed, status.installedVersion),
                    color = TextDim,
                    fontSize = 11.sp,
                    fontFamily = FontFamily.Monospace,
                    letterSpacing = 0.4.sp
                )
            }

            Spacer(modifier = Modifier.height(14.dp))
            StatusPill(pill)

            status.error?.let { err ->
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(errorMessageRes(err)),
                    color = TextMuted,
                    fontSize = 11.sp,
                    lineHeight = 16.sp,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(18.dp))
            PrimaryCta(label = ctaLabel, enabled = ctaEnabled, onClick = onPrimary)

            if (status.downloading) {
                Spacer(modifier = Modifier.height(10.dp))
                LinearProgressIndicator(
                    progress = { status.percent / 100f },
                    modifier = Modifier.fillMaxWidth().height(3.dp).clip(RoundedCornerShape(2.dp)),
                    color = Crimson,
                    trackColor = TrackColor
                )
            }

            if (status.updateUrl.isNotBlank() && !status.busy) {
                Spacer(modifier = Modifier.height(6.dp))
                TextButton(onClick = onOpenRelease) {
                    Text(stringResource(R.string.update_page_view_release), color = TextMuted, fontSize = 11.sp)
                }
            }
        }
    }
}

private data class Pill(val text: String, val color: Color)

@Composable
private fun StatusPill(pill: Pill) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(ChipSurface)
            .border(1.dp, ChipBorder, RoundedCornerShape(50))
            .padding(horizontal = 12.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PulsingDot(pill.color)
        Spacer(modifier = Modifier.width(8.dp))
        Text(pill.text, color = pill.color, fontSize = 11.sp, fontWeight = FontWeight.Medium)
    }
}

@Composable
private fun PulsingDot(color: Color) {
    val alpha by rememberInfiniteTransition(label = "updatePillPulse").animateFloat(
        initialValue = 1f,
        targetValue = 0.35f,
        animationSpec = infiniteRepeatable(tween(1100, easing = FastOutSlowInEasing), RepeatMode.Reverse),
        label = "updatePillPulseAlpha"
    )
    Box(modifier = Modifier.size(6.dp).clip(CircleShape).background(color.copy(alpha = alpha)))
}

@Composable
private fun PrimaryCta(label: String, enabled: Boolean, onClick: () -> Unit) {
    val shape = RoundedCornerShape(16.dp)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .then(
                if (enabled) Modifier.shadow(
                    16.dp, shape, clip = false,
                    ambientColor = Crimson.copy(alpha = 0.3f),
                    spotColor = Crimson.copy(alpha = 0.45f)
                ) else Modifier
            )
            .clip(shape)
            .background(if (enabled) Crimson else DisabledSurface)
            .clickable(enabled = enabled, onClick = onClick),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Outlined.Download, null, tint = if (enabled) Color.White else TextMuted, modifier = Modifier.size(17.dp))
        Spacer(modifier = Modifier.width(10.dp))
        Text(label, color = if (enabled) Color.White else TextMuted, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun ChangelogSection(version: String, notes: String) {
    val items = remember(notes) { parseReleaseNotes(notes) }
    if (items.isEmpty()) return
    Column(modifier = Modifier.fillMaxWidth()) {
        SectionHeader(stringResource(R.string.update_page_changelog, version))
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(CardSurface)
                .border(1.dp, CardBorder, RoundedCornerShape(16.dp))
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            items.forEachIndexed { index, item ->
                if (index > 0) {
                    HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp), thickness = 1.dp, color = DividerColor)
                }
                ChangeRow(tag = item.tag, title = item.title, body = item.body)
            }
        }
    }
}

@Composable
private fun ChangeRow(tag: String?, title: String, body: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        if (tag != null) TagBadge(tag, Modifier.padding(top = 1.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = TextPrimary, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, lineHeight = 17.sp)
            if (body.isNotBlank()) {
                Spacer(modifier = Modifier.height(3.dp))
                Text(body, color = TextBody, fontSize = 11.sp, lineHeight = 16.5.sp)
            }
        }
    }
}

@Composable
private fun TagBadge(tag: String, modifier: Modifier = Modifier) {
    val (fg, bg, border) = tagColors(tag)
    val shape = RoundedCornerShape(6.dp)
    Text(
        text = tag,
        modifier = modifier
            .clip(shape)
            .background(bg)
            .border(1.dp, border, shape)
            .padding(horizontal = 7.dp, vertical = 2.dp),
        color = fg,
        fontSize = 9.sp,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.5.sp,
        maxLines = 1
    )
}

private fun tagColors(tag: String): Triple<Color, Color, Color> = when (tag) {
    "NEW", "ADDED", "FEATURE", "FEATURES" -> Triple(Crimson, Crimson.copy(alpha = 0.14f), Crimson.copy(alpha = 0.32f))
    "SPEED", "PERF", "PERFORMANCE", "OPTIMISED", "OPTIMIZED" -> Triple(Teal, Color(0xFF1C2627), Teal.copy(alpha = 0.22f))
    "FIX", "FIXED", "FIXES", "BUG", "BUGS" -> Triple(TextSubtle, Color(0xFF252830), Color(0xFF303541))
    else -> Triple(TextBody, Color(0xFF252A36), Color(0xFF343B4B))
}

@Composable
private fun PreferencesSection(
    autoDownload: Boolean,
    onAutoDownloadChange: (Boolean) -> Unit,
    channel: Int,
    onChannelClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        SectionHeader(stringResource(R.string.update_page_preferences))
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(CardSurface)
                .border(1.dp, CardBorder, RoundedCornerShape(16.dp))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 14.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(stringResource(R.string.update_page_auto_download), color = TextPrimary, fontSize = 13.sp, fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(stringResource(R.string.update_page_auto_download_desc), color = TextMuted, fontSize = 10.5.sp, lineHeight = 14.sp)
                }
                Spacer(modifier = Modifier.width(12.dp))
                Switch(
                    checked = autoDownload,
                    onCheckedChange = onAutoDownloadChange,
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = Crimson,
                        checkedBorderColor = Crimson,
                        uncheckedThumbColor = Color(0xFFB6BAC4),
                        uncheckedTrackColor = TrackColor,
                        uncheckedBorderColor = Color.Transparent
                    )
                )
            }
            HorizontalDivider(thickness = 1.dp, color = DividerColor)
            Row(
                modifier = Modifier.fillMaxWidth().clickable(onClick = onChannelClick).padding(horizontal = 14.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(stringResource(R.string.update_page_channel), color = TextPrimary, fontSize = 13.sp, fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        stringResource(if (channel == PRE_RELEASE) R.string.update_page_channel_beta else R.string.update_page_channel_stable),
                        color = TextMuted, fontSize = 10.5.sp, lineHeight = 14.sp
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    stringResource(if (channel == PRE_RELEASE) R.string.update_page_channel_beta else R.string.update_page_channel_stable)
                        .substringBefore(" (").substringBefore(" build"),
                    color = TextSubtle, fontSize = 12.sp, fontFamily = FontFamily.Monospace
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(Icons.Outlined.ChevronRight, null, tint = TextMuted, modifier = Modifier.size(16.dp))
            }
        }
    }
}

@Composable
private fun ChannelDialog(current: Int, onDismiss: () -> Unit, onSelect: (Int) -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = CardSurface,
        titleContentColor = TextPrimary,
        textContentColor = TextBody,
        title = { Text(stringResource(R.string.update_page_channel), fontSize = 16.sp, fontWeight = FontWeight.SemiBold) },
        text = {
            Column {
                ChannelOption(stringResource(R.string.update_page_channel_stable), current != PRE_RELEASE) { onSelect(STABLE) }
                Spacer(modifier = Modifier.height(4.dp))
                ChannelOption(stringResource(R.string.update_page_channel_beta), current == PRE_RELEASE) { onSelect(PRE_RELEASE) }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) { Text(stringResource(R.string.cancel), color = TextMuted, fontSize = 13.sp) }
        }
    )
}

@Composable
private fun ChannelOption(label: String, selected: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(if (selected) Crimson.copy(alpha = 0.1f) else Color.Transparent)
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, modifier = Modifier.weight(1f), color = if (selected) TextPrimary else TextBody, fontSize = 13.sp, fontWeight = if (selected) FontWeight.Medium else FontWeight.Normal)
        if (selected) Icon(Icons.Rounded.Check, null, tint = Crimson, modifier = Modifier.size(16.dp))
    }
}

@Composable
private fun SectionHeader(text: String) {
    Text(text.uppercase(), color = TextSubtle, fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.1.sp)
}

@Composable
private fun Signature() {
    Text(
        text = stringResource(R.string.update_page_signature).uppercase(),
        modifier = Modifier.fillMaxWidth(),
        color = TextDim,
        fontSize = 9.sp,
        fontFamily = FontFamily.Monospace,
        letterSpacing = 2.2.sp,
        textAlign = TextAlign.Center
    )
}

private fun errorMessageRes(error: String): Int = when (error) {
    UpdateCoordinator.ERROR_INSTALL_CANCELLED -> R.string.update_modal_error_install
    UpdateCoordinator.ERROR_RELEASE_UNAVAILABLE -> R.string.update_modal_error_release
    UpdateCoordinator.ERROR_OFFLINE -> R.string.update_modal_error_offline
    else -> R.string.update_modal_error_generic
}

private val PageBackground = Color(0xFF14161A)
private val HeroTop = Color(0xFF1B1E26)
private val HeroBottom = Color(0xFF16181F)
private val HeroBorder = Color(0xFF282C38)
private val CardSurface = Color(0xFF181B22)
private val CardBorder = Color(0xFF242834)
private val CircleSurface = Color(0xFF1A1C23)
private val CircleBorder = Color(0xFF272B35)
private val ChipSurface = Color(0xFF202530)
private val ChipBorder = Color(0xFF2F3544)
private val DividerColor = Color(0xFF222632)
private val TrackColor = Color(0xFF252934)
private val DisabledSurface = Color(0xFF252A36)
private val Crimson = Color(0xFFEE4B4E)
private val Emerald = Color(0xFF34D399)
private val Teal = Color(0xFF2DD4BF)
private val Amber = Color(0xFFFBBF24)
private val TextPrimary = Color(0xFFF1F3F6)
private val TextSubtle = Color(0xFFA4A9B6)
private val TextBody = Color(0xFF9BA2B0)
private val TextMuted = Color(0xFF626875)
private val TextDim = Color(0xFF4E5462)
