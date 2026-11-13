package com.videshkarmakar.loop.ui.page

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.webkit.CookieManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.videshkarmakar.loop.Downloader
import com.videshkarmakar.loop.R
import com.videshkarmakar.loop.ui.common.LocalWindowWidthState
import com.videshkarmakar.loop.ui.common.Route
import com.videshkarmakar.loop.ui.common.animatedComposable
import com.videshkarmakar.loop.ui.common.animatedComposableVariant
import com.videshkarmakar.loop.ui.common.arg
import com.videshkarmakar.loop.ui.common.id
import com.videshkarmakar.loop.ui.common.slideInVerticallyComposable
import com.videshkarmakar.loop.ui.page.command.TaskListPage
import com.videshkarmakar.loop.ui.page.command.TaskLogPage
import com.videshkarmakar.loop.ui.page.download.DownloadPage
import com.videshkarmakar.loop.ui.page.download.DownloadViewModel
import com.videshkarmakar.loop.ui.page.download.FormatPage
import com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPage
import com.videshkarmakar.loop.ui.page.settings.SettingsPage
import com.videshkarmakar.loop.ui.page.settings.about.AboutPage
import com.videshkarmakar.loop.ui.page.settings.about.DeveloperCreditsPage
import com.videshkarmakar.loop.ui.page.WelcomeScreen
import com.videshkarmakar.loop.ui.page.creator.CreatorPage
import com.videshkarmakar.loop.ui.page.feedback.ReportFeedbackPage
import com.videshkarmakar.loop.util.HAS_SHOWN_WELCOME

import com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferences
import com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferences
import com.videshkarmakar.loop.ui.page.settings.appearance.LanguagePage
import com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPage
import com.videshkarmakar.loop.ui.page.settings.command.TemplateListPage
import com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences
import com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences
import com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreference
import com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences
import com.videshkarmakar.loop.ui.page.settings.interaction.InteractionPreferencePage
import com.videshkarmakar.loop.ui.page.settings.network.CookieProfilePage
import com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel
import com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferences
import com.videshkarmakar.loop.ui.page.settings.network.WebViewPage
import com.videshkarmakar.loop.ui.page.videolist.VideoListPage
import com.videshkarmakar.loop.ui.page.live.LivePage
import com.videshkarmakar.loop.ui.page.playlist.PlaylistPage
import com.videshkarmakar.loop.ui.component.LoopBottomNavigation

import com.videshkarmakar.loop.util.PreferenceUtil
import com.videshkarmakar.loop.util.PreferenceUtil.getBoolean
import com.videshkarmakar.loop.util.PreferenceUtil.getInt
import com.videshkarmakar.loop.util.PreferenceUtil.getLong
import com.videshkarmakar.loop.util.PreferenceUtil.getString
import com.videshkarmakar.loop.util.PreferenceUtil.updateBoolean
import com.videshkarmakar.loop.util.ToastUtil
import com.videshkarmakar.loop.util.UpdateUtil
import com.videshkarmakar.loop.util.YT_DLP_AUTO_UPDATE
import com.videshkarmakar.loop.util.YT_DLP_UPDATE_INTERVAL
import com.videshkarmakar.loop.util.YT_DLP_UPDATE_TIME
import com.videshkarmakar.loop.util.YT_DLP_VERSION
import com.yausername.youtubedl_android.YoutubeDL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val TAG = "HomeEntry"

@Composable
fun HomeEntry(
    downloadViewModel: DownloadViewModel,
    cookiesViewModel: CookiesViewModel,
    isUrlShared: Boolean
) {
    val navController = rememberNavController()
    val context = LocalContext.current
    var showUpdateDialog by rememberSaveable { mutableStateOf(false) }
    var currentDownloadStatus by remember { mutableStateOf(UpdateUtil.DownloadStatus.NotYet as UpdateUtil.DownloadStatus) }
    val scope = rememberCoroutineScope()
    var updateJob: Job? = null
    var latestRelease by remember { mutableStateOf(UpdateUtil.LatestRelease()) }
    val settings =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            UpdateUtil.installLatestApk()
        }
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { result ->
        if (result) {
            UpdateUtil.installLatestApk()
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                if (!context.packageManager.canRequestPackageInstalls())
                    settings.launch(
                        Intent(
                            Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,
                            Uri.parse("package:${context.packageName}"),
                        )
                    )
                else
                    UpdateUtil.installLatestApk()
            }
        }
    }

    val onNavigateBack: () -> Unit = {
        with(navController) {
            if (currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
                popBackStack()
            }
        }
    }

    if (isUrlShared) {
        if (navController.currentDestination?.route != Route.HOME) {
            navController.popBackStack(route = Route.HOME, inclusive = false, saveState = true)
        }
    }
    val startRoute = if (HAS_SHOWN_WELCOME.getBoolean()) Route.HOME else Route.WELCOME
    val mainRoutes = listOf("home", "creator", "report_feedback", "settings")
    // Must go through currentBackStackEntryAsState(): NavController.currentBackStackEntry reads
    // a StateFlow's value, which is not a snapshot read, so the bottom bar never recomposed on
    // navigation and the selection pill stayed parked on whichever tab was current at start.
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: startRoute
    val showBottomBar = currentRoute in mainRoutes

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        bottomBar = {
            if (showBottomBar) {
                LoopBottomNavigation(
                    onNavigate = { route ->
                        navController.navigate(route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
        ) {
            NavHost(
                modifier = Modifier
                    .fillMaxWidth(
                        when (LocalWindowWidthState.current) {
                            WindowWidthSizeClass.Compact -> 1f
                            WindowWidthSizeClass.Expanded -> 0.5f
                            else -> 0.8f
                        }
                    )
                    .align(Alignment.Center),
                navController = navController,
                startDestination = startRoute
            ) {
                animatedComposable(Route.WELCOME) {
                    WelcomeScreen(
                        onContinue = {
                            HAS_SHOWN_WELCOME.updateBoolean(true)
                            navController.navigate(Route.HOME) {
                                popUpTo(Route.WELCOME) { inclusive = true }
                            }
                        }
                    )
                }
                animatedComposable(Route.CREATOR) {
                    CreatorPage(onNavigateBack = onNavigateBack)
                }
                animatedComposable(Route.REPORT_FEEDBACK) {
                    ReportFeedbackPage(onNavigateBack = onNavigateBack)
                }
                animatedComposable(Route.HOME) {
                    DownloadPage(
                        navigateToDownloads = { navController.navigate(Route.DOWNLOADS) },
                        navigateToSettings = {
                            navController.navigate(Route.SETTINGS) {
                                launchSingleTop = true
                            }
                        },
                        navigateToPlaylistPage = { navController.navigate(Route.PLAYLIST) },
                        navigateToFormatPage = { navController.navigate(Route.FORMAT_SELECTION) },
                        onNavigateToTaskList = { navController.navigate(Route.TASK_LIST) },
                        onNavigateToCookieGeneratorPage = {
                            cookiesViewModel.updateUrl(it)
                            navController.navigate(Route.COOKIE_GENERATOR_WEBVIEW)
                        },
                        downloadViewModel = downloadViewModel
                    )
                }
                animatedComposable(Route.DOWNLOADS) { VideoListPage { onNavigateBack() } }
                animatedComposableVariant(Route.TASK_LIST) {
                    TaskListPage(
                        onNavigateBack = onNavigateBack,
                        onNavigateToDetail = { navController.navigate(Route.TASK_LOG id it) }
                    )
                }
                slideInVerticallyComposable(
                    Route.TASK_LOG arg Route.TASK_HASHCODE,
                    arguments = listOf(navArgument(Route.TASK_HASHCODE) { type = NavType.IntType })
                ) {
                    TaskLogPage(
                        onNavigateBack = onNavigateBack,
                        taskHashCode = it.arguments?.getInt(Route.TASK_HASHCODE) ?: -1
                    )
                }

                animatedComposable(Route.PLAYLIST) { PlaylistPage() }
                animatedComposable(Route.LIVE) { LivePage() }
                animatedComposable(Route.VIDEOS) { VideoListPage { onNavigateBack() } }
                slideInVerticallyComposable(Route.FORMAT_SELECTION) { FormatPage(downloadViewModel) { onNavigateBack() } }
                settingsGraph(
                    cookiesViewModel = cookiesViewModel,
                    onNavigateBack = onNavigateBack,
                    onNavigateTo = { route ->
                        navController.navigate(route = route) {
                            launchSingleTop = true
                        }
                    }
                )

            }
        }

        WelcomeDialog {
            navController.navigate(Route.SETTINGS)
        }

        val downloaderState by Downloader.downloaderState.collectAsStateWithLifecycle()

        LaunchedEffect(Unit) {
            if (downloaderState !is Downloader.State.Idle) return@LaunchedEffect

            if (!YT_DLP_AUTO_UPDATE.getBoolean() && YT_DLP_VERSION.getString()
                    .isNotEmpty()
            ) return@LaunchedEffect

            if (!PreferenceUtil.isNetworkAvailableForDownload()) {
                return@LaunchedEffect
            }

            val lastUpdateTime = YT_DLP_UPDATE_TIME.getLong()
            val currentTime = System.currentTimeMillis()

            if (currentTime < lastUpdateTime + YT_DLP_UPDATE_INTERVAL.getLong()) {
                return@LaunchedEffect
            }

            runCatching {
                Downloader.updateState(state = Downloader.State.Updating)
                withContext(Dispatchers.IO) {
                    UpdateUtil.updateYtDlp()
                }
            }.onFailure {
                it.printStackTrace()
            }
            Downloader.updateState(state = Downloader.State.Idle)
        }

        LaunchedEffect(Unit) {
            if (!PreferenceUtil.isNetworkAvailableForDownload() || !PreferenceUtil.isAutoUpdateEnabled()
            )
                return@LaunchedEffect
            launch(Dispatchers.IO) {
                runCatching {
                    UpdateUtil.checkForUpdate()?.let {
                        latestRelease = it
                        showUpdateDialog = true
                    }
                }.onFailure {
                    it.printStackTrace()
                }
            }
        }

        if (showUpdateDialog) {
            UpdateDialogImpl(
                onDismissRequest = {
                    showUpdateDialog = false
                    updateJob?.cancel()
                },
                title = latestRelease.name.toString(),
                onConfirmUpdate = {
                    updateJob = scope.launch(Dispatchers.IO) {
                        runCatching {
                            UpdateUtil.downloadApk(latestRelease = latestRelease)
                                .collect { downloadStatus ->
                                    currentDownloadStatus = downloadStatus
                                    if (downloadStatus is UpdateUtil.DownloadStatus.Finished) {
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                            launcher.launch(Manifest.permission.REQUEST_INSTALL_PACKAGES)
                                        }
                                    }
                                }
                        }.onFailure {
                            it.printStackTrace()
                            currentDownloadStatus = UpdateUtil.DownloadStatus.NotYet
                            ToastUtil.makeToastSuspend(context.getString(R.string.app_update_failed))
                            return@launch
                        }
                    }
                },
                releaseNote = latestRelease.body.toString(),
                downloadStatus = currentDownloadStatus
            )
        }
    }
}

fun NavGraphBuilder.settingsGraph(
    cookiesViewModel: CookiesViewModel,
    onNavigateBack: () -> Unit,
    onNavigateTo: (route: String) -> Unit
) {
    navigation(startDestination = Route.SETTINGS_PAGE, route = Route.SETTINGS) {
        animatedComposable(Route.DOWNLOAD_DIRECTORY) {
            DownloadDirectoryPreferences(onNavigateBack)
        }
        animatedComposable(Route.SETTINGS_PAGE) {
            SettingsPage(
                onNavigateBack = onNavigateBack,
                onNavigateTo = onNavigateTo
            )
        }
        animatedComposable(Route.GENERAL_DOWNLOAD_PREFERENCES) {
            GeneralDownloadPreferences(
                onNavigateBack = { onNavigateBack() },
            ) { onNavigateTo(Route.TEMPLATE) }
        }
        animatedComposable(Route.DOWNLOAD_FORMAT) {
            DownloadFormatPreferences(onNavigateBack = onNavigateBack) {
                onNavigateTo(Route.SUBTITLE_PREFERENCES)
            }
        }
        animatedComposable(Route.SUBTITLE_PREFERENCES) { SubtitlePreference { onNavigateBack() } }
        animatedComposable(Route.ABOUT) {
            AboutPage(
                onNavigateBack = onNavigateBack,
                onNavigateToCredits = { onNavigateTo(Route.DEVELOPER_CREDITS) }
            )
        }
        animatedComposable(Route.DEVELOPER_CREDITS) { DeveloperCreditsPage(onNavigateBack) }

        animatedComposable(Route.APPEARANCE) {
            AppearancePreferences(
                onNavigateBack = onNavigateBack,
                onNavigateTo = onNavigateTo
            )
        }
        animatedComposable(Route.INTERACTION) { InteractionPreferencePage(onBack = onNavigateBack) }
        animatedComposable(Route.LANGUAGES) { LanguagePage { onNavigateBack() } }
        animatedComposable(Route.DOWNLOAD_DIRECTORY) {
            DownloadDirectoryPreferences { onNavigateBack() }
        }
        animatedComposable(Route.TEMPLATE) {
            TemplateListPage(onNavigateBack = onNavigateBack) {
                onNavigateTo(Route.TEMPLATE_EDIT id it)
            }
        }
        animatedComposable(
            Route.TEMPLATE_EDIT arg Route.TEMPLATE_ID,
            arguments = listOf(navArgument(Route.TEMPLATE_ID) { type = NavType.IntType })
        ) {
            TemplateEditPage(onNavigateBack, it.arguments?.getInt(Route.TEMPLATE_ID) ?: -1)
        }
        animatedComposable(Route.DARK_THEME) { DarkThemePreferences { onNavigateBack() } }
        animatedComposable(Route.NETWORK_PREFERENCES) {
            NetworkPreferences(navigateToCookieProfilePage = {
                onNavigateTo(Route.COOKIE_PROFILE)
            }) { onNavigateBack() }
        }
        animatedComposable(Route.COOKIE_PROFILE) {
            CookieProfilePage(
                cookiesViewModel = cookiesViewModel,
                navigateToCookieGeneratorPage = { onNavigateTo(Route.COOKIE_GENERATOR_WEBVIEW) },
            ) { onNavigateBack() }
        }
        animatedComposable(
            Route.COOKIE_GENERATOR_WEBVIEW
        ) {
            WebViewPage(cookiesViewModel) {
                onNavigateBack()
                CookieManager.getInstance().flush()
            }
        }
    }
}




