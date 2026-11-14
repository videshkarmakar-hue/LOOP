package com.videshkarmakar.loop.ui.page.settings

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.PowerManager
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
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
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.AudioFile
import androidx.compose.material.icons.rounded.CameraAlt
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material.icons.rounded.Folder
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Language
import androidx.compose.material.icons.rounded.MusicNote
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.SignalCellular4Bar
import androidx.compose.material.icons.rounded.Sync
import androidx.compose.material.icons.rounded.Terminal
import androidx.compose.material.icons.rounded.Tune
import androidx.compose.material.icons.rounded.VideoFile
import androidx.compose.material.icons.rounded.VolunteerActivism
import androidx.compose.material.icons.rounded.Wifi
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.videshkarmakar.loop.App
import com.videshkarmakar.loop.R
import com.videshkarmakar.loop.ui.common.Route
import com.videshkarmakar.loop.ui.common.intState
import com.videshkarmakar.loop.ui.common.motion.emphasizeEasing
import com.videshkarmakar.loop.ui.component.NavigationBarSpacer
import com.videshkarmakar.loop.ui.component.OtherProjectsSection
import com.videshkarmakar.loop.util.EXTRACT_AUDIO
import com.videshkarmakar.loop.util.PreferenceUtil.getBoolean
import com.videshkarmakar.loop.util.PreferenceUtil.updateInt
import com.videshkarmakar.loop.util.SHOW_SPONSOR_MSG

private const val DEVELOPER_PORTRAIT =
    "https://cdn.phototourl.com/member/2026-09-24-d3b8ff6f-f0d4-43e0-9082-9f39cc851774.png"

private val Bg = Color(0xFF121316)
private val CardBg = Color(0xFF1B1D22)
private val PillBg = Color(0xFF24272E)
private val Border = Color(0xFF262930)
private val Divider = Color(0xFF202228)
private val TextPrimary = Color(0xFFF2F3F5)
private val TextMuted = Color(0xFF7E838F)
private val TextSubtle = Color(0xFF9AA0AD)

@SuppressLint("BatteryLife")
@Composable
fun SettingsPage(
    onNavigateBack: () -> Unit, onNavigateTo: (String) -> Unit
) {
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current
    val pm = context.getSystemService(Context.POWER_SERVICE) as PowerManager
    var showBatteryHint by remember {
        mutableStateOf(
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                !pm.isIgnoringBatteryOptimizations(context.packageName)
            } else {
                false
            }
        )
    }
    val intent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS).apply {
            data = Uri.parse("package:${context.packageName}")
        }
    } else {
        Intent()
    }
    val isActivityAvailable: Boolean = if (Build.VERSION.SDK_INT < 23) false
    else if (Build.VERSION.SDK_INT < 33) context.packageManager.queryIntentActivities(
        intent,
        PackageManager.MATCH_ALL
    ).isNotEmpty()
    else context.packageManager.queryIntentActivities(
        intent,
        PackageManager.ResolveInfoFlags.of(PackageManager.MATCH_SYSTEM_ONLY.toLong())
    ).isNotEmpty()

    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                showBatteryHint = !pm.isIgnoringBatteryOptimizations(context.packageName)
            }
        }

    val showSponsorMessage by SHOW_SPONSOR_MSG.intState
    var lastVisited by remember { mutableStateOf<String?>(null) }

    val open: (String) -> Unit = { route ->
        lastVisited = route
        onNavigateTo(route)
    }

    LaunchedEffect(Unit) {
        SHOW_SPONSOR_MSG.updateInt(showSponsorMessage + 1)
    }

    val extractAudio = EXTRACT_AUDIO.getBoolean()
    val isMetered = App.connectivityManager.isActiveNetworkMetered

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Bg
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
                .padding(top = 12.dp, bottom = 8.dp)
        ) {
            // Top back action
            Box(modifier = Modifier.padding(bottom = 16.dp)) {
                IconButton(
                    onClick = onNavigateBack,
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                        contentDescription = stringResource(R.string.back),
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            // Profile header
            Row(
                modifier = Modifier.padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = DEVELOPER_PORTRAIT,
                    contentDescription = stringResource(id = R.string.settings_developer_name),
                    modifier = Modifier
                        .size(58.dp)
                        .clip(CircleShape)
                        .border(1.dp, Color.White.copy(alpha = 0.1f), CircleShape)
                        .background(Color(0xFF262626)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = stringResource(id = R.string.settings_developer_name),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = stringResource(id = R.string.settings_panel_role),
                        fontSize = 14.sp,
                        color = TextMuted
                    )
                }
            }

            // Social pills
            Row(
                modifier = Modifier.padding(top = 4.dp, bottom = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                SocialPill(Icons.Rounded.Language, "Website") {
                    uriHandler.openUri("https://videshkarmakar.carrd.co/")
                }
                SocialPill(Icons.Rounded.MusicNote, "Spotify") {
                    uriHandler.openUri("https://open.spotify.com/artist/2eJEzi0mzJB60zVJf0OjWP")
                }
                SocialPill(Icons.Rounded.CameraAlt, "Instagram") {
                    uriHandler.openUri("https://www.instagram.com/code.red_videsh/")
                }
                SocialPill(Icons.Rounded.PlayArrow, "YouTube") {
                    uriHandler.openUri("https://www.youtube.com/@videshkarmakar2000")
                }
                SocialPill(Icons.Rounded.Language, "Facebook") {
                    uriHandler.openUri("https://www.facebook.com/gfx.videsh")
                }
            }

            // Battery configuration banner
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                AnimatedVisibility(
                    visible = showBatteryHint && isActivityAvailable,
                    enter = expandVertically(
                        animationSpec = tween(durationMillis = 280, easing = emphasizeEasing)
                    ) + fadeIn(
                        animationSpec = tween(durationMillis = 200, easing = emphasizeEasing)
                    ),
                    exit = shrinkVertically(
                        animationSpec = tween(durationMillis = 240, easing = emphasizeEasing)
                    ) + fadeOut(
                        animationSpec = tween(durationMillis = 160, easing = emphasizeEasing)
                    )
                ) {
                    BannerCard(
                        icon = Icons.Rounded.Sync,
                        title = stringResource(R.string.battery_configuration),
                        description = stringResource(R.string.battery_configuration_desc),
                        onClick = {
                            launcher.launch(intent)
                            showBatteryHint =
                                !pm.isIgnoringBatteryOptimizations(context.packageName)
                        }
                    )
                }
            }

            // Sponsor hint (kept functional)
            if (!showBatteryHint && showSponsorMessage > 30) {
                BannerCard(
                    icon = Icons.Rounded.VolunteerActivism,
                    title = stringResource(id = R.string.sponsor),
                    description = stringResource(id = R.string.sponsor_desc),
                    onClick = {
                        uriHandler.openUri("https://github.com/sponsors/JunkFood02")
                    }
                )
            }

            Spacer(modifier = Modifier.height(if ((showBatteryHint && isActivityAvailable) || (!showBatteryHint && showSponsorMessage > 30)) 8.dp else 0.dp))

            // Settings menu
            Column(modifier = Modifier.fillMaxWidth()) {
                SettingsMenuItem(
                    title = stringResource(id = R.string.general_settings),
                    icon = Icons.Rounded.Settings,
                    selected = lastVisited == Route.GENERAL_DOWNLOAD_PREFERENCES,
                    onClick = { open(Route.GENERAL_DOWNLOAD_PREFERENCES) }
                )
                MenuDivider()
                SettingsMenuItem(
                    title = stringResource(id = R.string.download_directory),
                    icon = Icons.Rounded.Folder,
                    selected = lastVisited == Route.DOWNLOAD_DIRECTORY,
                    onClick = { open(Route.DOWNLOAD_DIRECTORY) }
                )
                MenuDivider()
                SettingsMenuItem(
                    title = stringResource(id = R.string.format),
                    icon = if (extractAudio) Icons.Rounded.AudioFile else Icons.Rounded.VideoFile,
                    selected = lastVisited == Route.DOWNLOAD_FORMAT,
                    badge = if (extractAudio) stringResource(id = R.string.settings_badge_audio) else null,
                    onClick = { open(Route.DOWNLOAD_FORMAT) }
                )
                MenuDivider()
                SettingsMenuItem(
                    title = stringResource(id = R.string.interface_and_interaction),
                    icon = Icons.Rounded.Tune,
                    selected = lastVisited == Route.INTERACTION,
                    onClick = { open(Route.INTERACTION) }
                )
                MenuDivider()
                SettingsMenuItem(
                    title = stringResource(id = R.string.network),
                    icon = if (isMetered) Icons.Rounded.SignalCellular4Bar else Icons.Rounded.Wifi,
                    selected = lastVisited == Route.NETWORK_PREFERENCES,
                    badge = if (isMetered) stringResource(id = R.string.settings_badge_metered) else null,
                    onClick = { open(Route.NETWORK_PREFERENCES) }
                )
                MenuDivider()
                SettingsMenuItem(
                    title = stringResource(id = R.string.custom_command),
                    icon = Icons.Rounded.Terminal,
                    selected = lastVisited == Route.TEMPLATE,
                    onClick = { open(Route.TEMPLATE) }
                )
                MenuDivider()
                SettingsMenuItem(
                    title = stringResource(id = R.string.about),
                    icon = Icons.Rounded.Info,
                    selected = lastVisited == Route.ABOUT,
                    onClick = { open(Route.ABOUT) }
                )
                MenuDivider()
                SettingsMenuItem(
                    title = stringResource(id = R.string.update_section),
                    icon = Icons.Rounded.Sync,
                    selected = lastVisited == Route.UPDATE,
                    onClick = { open(Route.UPDATE) }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            OtherProjectsSection()
            NavigationBarSpacer()
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun SocialPill(icon: ImageVector, label: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(PillBg)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = Color(0xFFD4D4D8),
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
private fun BannerCard(
    icon: ImageVector,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
            .clip(RoundedCornerShape(22.dp))
            .background(CardBg)
            .border(1.dp, Border.copy(alpha = 0.4f), RoundedCornerShape(22.dp))
            .clickable(onClick = onClick)
            .padding(20.dp),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(PillBg),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(0xFFE4E4E7),
                modifier = Modifier.size(18.dp)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                letterSpacing = (-0.2).sp
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = description,
                fontSize = 13.5.sp,
                lineHeight = 20.sp,
                color = TextSubtle
            )
        }
    }
}

@Composable
private fun SettingsMenuItem(
    title: String,
    icon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit,
    badge: String? = null
) {
    val contentColor = if (selected) Color.White else Color(0xFFF4F4F5)
    val iconColor = if (selected) Color.White else Color(0xFFA1A1AA)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .then(if (selected) Modifier.background(Color.White.copy(alpha = 0.04f)) else Modifier)
            .clickable(onClick = onClick)
            .padding(horizontal = 4.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.width(32.dp), contentAlignment = Alignment.CenterStart) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            fontSize = 15.5.sp,
            fontWeight = if (selected) FontWeight.Medium else FontWeight.Normal,
            color = contentColor,
            modifier = Modifier.weight(1f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        if (!badge.isNullOrBlank()) {
            Text(
                text = badge,
                fontSize = 11.sp,
                color = TextSubtle,
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(PillBg)
                    .padding(horizontal = 8.dp, vertical = 3.dp)
            )
        }
    }
}

@Composable
private fun MenuDivider() {
    HorizontalDivider(
        thickness = 1.dp,
        color = Divider.copy(alpha = 0.5f)
    )
}
