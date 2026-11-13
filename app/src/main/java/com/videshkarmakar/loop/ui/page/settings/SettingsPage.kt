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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AudioFile
import androidx.compose.material.icons.rounded.CameraAlt
import androidx.compose.material.icons.rounded.EnergySavingsLeaf
import androidx.compose.material.icons.rounded.Facebook
import androidx.compose.material.icons.rounded.Folder
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Language
import androidx.compose.material.icons.rounded.MusicNote
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.SettingsApplications
import androidx.compose.material.icons.rounded.SignalCellular4Bar
import androidx.compose.material.icons.rounded.SignalWifi4Bar
import androidx.compose.material.icons.rounded.Terminal
import androidx.compose.material.icons.rounded.VideoFile
import androidx.compose.material.icons.rounded.ViewComfy
import androidx.compose.material.icons.rounded.VolunteerActivism
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.videshkarmakar.loop.App
import com.videshkarmakar.loop.R
import com.videshkarmakar.loop.ui.common.Route
import com.videshkarmakar.loop.ui.common.intState
import com.videshkarmakar.loop.ui.component.BackButton
import com.videshkarmakar.loop.ui.component.NavigationBarSpacer
import com.videshkarmakar.loop.ui.component.OtherProjectsSection
import com.videshkarmakar.loop.ui.component.PreferencesHintCard
import com.videshkarmakar.loop.ui.component.SettingsBadge
import com.videshkarmakar.loop.ui.component.SettingsGroupDivider
import com.videshkarmakar.loop.ui.component.SettingsNavRow
import com.videshkarmakar.loop.ui.component.SettingsProfileHeader
import com.videshkarmakar.loop.ui.component.SettingsSocialLink
import com.videshkarmakar.loop.ui.component.SettingsSocialRow
import com.videshkarmakar.loop.ui.component.SmallTopAppBar
import com.videshkarmakar.loop.ui.common.motion.emphasizeEasing
import com.videshkarmakar.loop.util.EXTRACT_AUDIO
import com.videshkarmakar.loop.util.PreferenceUtil.getBoolean
import com.videshkarmakar.loop.util.PreferenceUtil.updateInt
import com.videshkarmakar.loop.util.SHOW_SPONSOR_MSG

private const val DEVELOPER_PORTRAIT =
    "https://cdn.phototourl.com/member/2026-09-24-d3b8ff6f-f0d4-43e0-9082-9f39cc851774.png"

/**
 * Settings, laid out as a grouped navigation panel rather than a flat preference list.
 *
 * The panel is grouped by what the user is trying to change -- how a download runs, how it looks,
 * how it reaches the network, and what the app itself is -- rather than by screen. Each group is
 * separated by a hairline inset to the text edge, so the grouping is legible without a stack of
 * section headers competing with the rows for attention.
 *
 * The most recently opened section stays filled after the user backs out of it. On a panel whose
 * rows are otherwise identical, that is the only way to keep orientation on return, and it matches
 * the active row the user just tapped instead of resetting the panel to a blank slate.
 */
@SuppressLint("BatteryLife")
@OptIn(ExperimentalMaterial3Api::class)
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
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    val showSponsorMessage by SHOW_SPONSOR_MSG.intState
    // Survives the navigation that opens a section, so the panel can come back to it filled.
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

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            SmallTopAppBar(
                titleText = stringResource(id = R.string.settings),
                navigationIcon = { BackButton(onNavigateBack) },
                scrollBehavior = scrollBehavior
            )
        }) {
        LazyColumn(
            modifier = Modifier.padding(it)
        ) {
            item {
                SettingsProfileHeader(
                    portraitUrl = DEVELOPER_PORTRAIT,
                    name = stringResource(id = R.string.settings_developer_name),
                    subtitle = stringResource(id = R.string.settings_panel_role)
                )
            }

            item {
                SettingsSocialRow(
                    links = listOf(
                        SettingsSocialLink(
                            Icons.Rounded.Language, "Website",
                            "https://videshkarmakar.carrd.co/"
                        ),
                        SettingsSocialLink(
                            Icons.Rounded.MusicNote, "Spotify",
                            "https://open.spotify.com/artist/2eJEzi0mzJB60zVJf0OjWP"
                        ),
                        SettingsSocialLink(
                            Icons.Rounded.CameraAlt, "Instagram",
                            "https://www.instagram.com/code.red_videsh/"
                        ),
                        SettingsSocialLink(
                            Icons.Rounded.PlayArrow, "YouTube",
                            "https://www.youtube.com/@videshkarmakar2000"
                        ),
                        SettingsSocialLink(
                            Icons.Rounded.Facebook, "Facebook",
                            "https://www.facebook.com/gfx.videsh"
                        ),
                    )
                )
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
            ) {
                item {
                    AnimatedVisibility(
                        visible = showBatteryHint && isActivityAvailable,
                        // enter/ exit used to be asymmetric: a custom shrinkVertically on the way
                        // out but the default expandIn on the way in, so the card visibly jumped
                        // as it appeared. Both directions now use the same easing and duration.
                        enter = expandVertically(
                            animationSpec = tween(
                                durationMillis = 280,
                                easing = emphasizeEasing
                            )
                        ) + fadeIn(
                            animationSpec = tween(
                                durationMillis = 200,
                                easing = emphasizeEasing
                            )
                        ),
                        exit = shrinkVertically(
                            animationSpec = tween(
                                durationMillis = 240,
                                easing = emphasizeEasing
                            )
                        ) + fadeOut(
                            animationSpec = tween(
                                durationMillis = 160,
                                easing = emphasizeEasing
                            )
                        )
                    ) {
                        PreferencesHintCard(
                            title = stringResource(R.string.battery_configuration),
                            icon = Icons.Rounded.EnergySavingsLeaf,
                            description = stringResource(R.string.battery_configuration_desc),
                        ) {
                            launcher.launch(intent)
                            showBatteryHint =
                                !pm.isIgnoringBatteryOptimizations(context.packageName)
                        }
                    }
                }
            }
            if (!showBatteryHint && showSponsorMessage > 30)
                item {
                    PreferencesHintCard(
                        title = stringResource(id = R.string.sponsor),
                        icon = Icons.Rounded.VolunteerActivism,
                        description = stringResource(id = R.string.sponsor_desc)
                    ) {
                        uriHandler.openUri("https://github.com/sponsors/JunkFood02")
                    }
                }

            item {
                SettingsNavRow(
                    title = stringResource(id = R.string.general_settings),
                    icon = Icons.Rounded.SettingsApplications,
                    selected = lastVisited == Route.GENERAL_DOWNLOAD_PREFERENCES,
                    onClick = { open(Route.GENERAL_DOWNLOAD_PREFERENCES) }
                )
            }
            item {
                SettingsNavRow(
                    title = stringResource(id = R.string.download_directory),
                    icon = Icons.Rounded.Folder,
                    selected = lastVisited == Route.DOWNLOAD_DIRECTORY,
                    onClick = { open(Route.DOWNLOAD_DIRECTORY) }
                )
            }
            item {
                SettingsNavRow(
                    title = stringResource(id = R.string.format),
                    icon = if (extractAudio) Icons.Rounded.AudioFile else Icons.Rounded.VideoFile,
                    selected = lastVisited == Route.DOWNLOAD_FORMAT,
                    onClick = { open(Route.DOWNLOAD_FORMAT) },
                    badge = if (extractAudio) SettingsBadge(
                        label = stringResource(id = R.string.settings_badge_audio),
                        icon = Icons.Rounded.AudioFile
                    ) else null
                )
            }

            item { SettingsGroupDivider() }

            item {
                SettingsNavRow(
                    title = stringResource(id = R.string.interface_and_interaction),
                    icon = Icons.Rounded.ViewComfy,
                    selected = lastVisited == Route.INTERACTION,
                    onClick = { open(Route.INTERACTION) }
                )
            }

            item { SettingsGroupDivider() }

            item {
                SettingsNavRow(
                    title = stringResource(id = R.string.network),
                    icon = if (isMetered) Icons.Rounded.SignalCellular4Bar
                    else Icons.Rounded.SignalWifi4Bar,
                    selected = lastVisited == Route.NETWORK_PREFERENCES,
                    onClick = { open(Route.NETWORK_PREFERENCES) },
                    badge = if (isMetered) SettingsBadge(
                        label = stringResource(id = R.string.settings_badge_metered),
                        icon = Icons.Rounded.SignalCellular4Bar
                    ) else null
                )
            }
            item {
                SettingsNavRow(
                    title = stringResource(id = R.string.custom_command),
                    icon = Icons.Rounded.Terminal,
                    selected = lastVisited == Route.TEMPLATE,
                    onClick = { open(Route.TEMPLATE) }
                )
            }

            item { SettingsGroupDivider() }

            item {
                SettingsNavRow(
                    title = stringResource(id = R.string.about),
                    icon = Icons.Rounded.Info,
                    selected = lastVisited == Route.ABOUT,
                    onClick = { open(Route.ABOUT) }
                )
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
                OtherProjectsSection()
            }
            item { NavigationBarSpacer() }
            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}

