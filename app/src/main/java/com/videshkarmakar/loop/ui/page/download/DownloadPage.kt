package com.videshkarmakar.loop.ui.page.download

import android.Manifest
import android.os.Build
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.ContentPaste
import androidx.compose.material.icons.outlined.Error
import androidx.compose.material.icons.outlined.FileDownload
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Subscriptions
import androidx.compose.material.icons.outlined.Terminal
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberTooltipState
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.videshkarmakar.loop.App
import com.videshkarmakar.loop.Downloader
import com.videshkarmakar.loop.R
import com.videshkarmakar.loop.ui.common.HapticFeedback.longPressHapticFeedback
import com.videshkarmakar.loop.ui.common.HapticFeedback.slightHapticFeedback
import com.videshkarmakar.loop.ui.common.LocalWindowWidthState
import com.videshkarmakar.loop.ui.component.ClearButton
import com.videshkarmakar.loop.ui.component.NavigationBarSpacer
import com.videshkarmakar.loop.ui.component.OutlinedButtonWithIcon
import com.videshkarmakar.loop.ui.component.VideoCard
import com.videshkarmakar.loop.ui.theme.LoopTheme
import com.videshkarmakar.loop.ui.theme.MilkerFontFamily
import com.videshkarmakar.loop.ui.theme.PreviewThemeLight
import com.videshkarmakar.loop.util.CELLULAR_DOWNLOAD
import com.videshkarmakar.loop.util.CONFIGURE
import com.videshkarmakar.loop.util.CUSTOM_COMMAND
import com.videshkarmakar.loop.util.DEBUG
import com.videshkarmakar.loop.util.DISABLE_PREVIEW
import com.videshkarmakar.loop.util.NOTIFICATION
import com.videshkarmakar.loop.util.PreferenceUtil
import com.videshkarmakar.loop.util.PreferenceUtil.getBoolean
import com.videshkarmakar.loop.util.PreferenceUtil.updateBoolean
import com.videshkarmakar.loop.util.ToastUtil
import com.videshkarmakar.loop.util.matchUrlFromClipboard
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(
    ExperimentalPermissionsApi::class,
    ExperimentalMaterial3Api::class,
)
@Composable
fun DownloadPage(
    navigateToSettings: () -> Unit = {},
    navigateToDownloads: () -> Unit = {},
    navigateToPlaylistPage: () -> Unit = {},
    navigateToFormatPage: () -> Unit = {},
    onNavigateToTaskList: () -> Unit = {},
    onNavigateToCookieGeneratorPage: (String) -> Unit = {},
    downloadViewModel: DownloadViewModel = hiltViewModel(),
) {

    val scope = rememberCoroutineScope()
    val downloaderState by Downloader.downloaderState.collectAsStateWithLifecycle()
    val taskState by Downloader.taskState.collectAsStateWithLifecycle()
    val viewState by downloadViewModel.viewStateFlow.collectAsStateWithLifecycle()
    val playlistInfo by Downloader.playlistResult.collectAsStateWithLifecycle()
    val videoInfo by downloadViewModel.videoInfoFlow.collectAsStateWithLifecycle()
    val errorState by Downloader.errorState.collectAsStateWithLifecycle()
    val processCount by Downloader.processCount.collectAsStateWithLifecycle()

    var showNotificationDialog by remember { mutableStateOf(false) }
    val notificationPermission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS) { isGranted: Boolean ->
            showNotificationDialog = false
            if (!isGranted) {
                ToastUtil.makeToast(R.string.permission_denied)
            }
        }
    } else null

    val clipboardManager = LocalClipboardManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val useDialog = LocalWindowWidthState.current != WindowWidthSizeClass.Compact
    val view = LocalView.current
    var showDownloadDialog by rememberSaveable { mutableStateOf(false) }
    var showMeteredNetworkDialog by remember { mutableStateOf(false) }

    val checkNetworkOrDownload = {
        if (!PreferenceUtil.isNetworkAvailableForDownload()) {
            showMeteredNetworkDialog = true
        } else {
            downloadViewModel.startDownloadVideo()
        }
    }

    val storagePermission = rememberPermissionState(
        permission = Manifest.permission.WRITE_EXTERNAL_STORAGE
    ) { b: Boolean ->
        if (b) {
            checkNetworkOrDownload()
        } else {
            ToastUtil.makeToast(R.string.permission_denied)
        }
    }

    val checkPermissionOrDownload = {
        if (Build.VERSION.SDK_INT > 29 || storagePermission.status == PermissionStatus.Granted) {
            checkNetworkOrDownload()
        } else {
            storagePermission.launchPermissionRequest()
        }
    }


    val downloadCallback: () -> Unit = {
        view.slightHapticFeedback()
        keyboardController?.hide()
        if (NOTIFICATION.getBoolean() && notificationPermission?.status?.isGranted == false) {
            showNotificationDialog = true
        }
        if (CONFIGURE.getBoolean()) {
            showDownloadDialog = true
        } else {
            checkPermissionOrDownload()
        }
    }

    if (showNotificationDialog) {
        NotificationPermissionDialog(onDismissRequest = {
            showNotificationDialog = false
            NOTIFICATION.updateBoolean(false)
        }, onPermissionGranted = {
            notificationPermission?.launchPermissionRequest()
        })
    }

    if (showMeteredNetworkDialog) {
        MeteredNetworkDialog(
            onDismissRequest = { showMeteredNetworkDialog = false },
            onAllowOnceConfirm = {
                downloadViewModel.startDownloadVideo()
                showMeteredNetworkDialog = false
            },
            onAllowAlwaysConfirm = {
                downloadViewModel.startDownloadVideo()
                CELLULAR_DOWNLOAD.updateBoolean(true)
                showMeteredNetworkDialog = false
            })
    }


    DisposableEffect(viewState.showPlaylistSelectionDialog) {
        if (!playlistInfo.entries.isNullOrEmpty() && viewState.showPlaylistSelectionDialog) navigateToPlaylistPage()
        onDispose { downloadViewModel.hidePlaylistDialog() }
    }

    DisposableEffect(viewState.showFormatSelectionPage) {
        if (viewState.showFormatSelectionPage) {
            if (!videoInfo.formats.isNullOrEmpty()) navigateToFormatPage()
        }
        onDispose { downloadViewModel.hideFormatPage() }
    }
    var showOutput by remember {
        mutableStateOf(DEBUG.getBoolean())
    }
    LaunchedEffect(downloaderState) {
        showOutput = PreferenceUtil.getValue(DEBUG) && downloaderState !is Downloader.State.Idle
    }
    if (viewState.isUrlSharingTriggered) {
        downloadViewModel.onShareIntentConsumed()
        downloadCallback()
    }

    val showVideoCard by remember(downloaderState) {
        mutableStateOf(
            !PreferenceUtil.getValue(DISABLE_PREVIEW)
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        DownloadPageImpl(downloaderState = downloaderState,
            taskState = taskState,
            viewState = viewState,
            errorState = errorState,
            downloadCallback = downloadCallback,
            navigateToSettings = navigateToSettings,
            navigateToDownloads = navigateToDownloads,
            onNavigateToTaskList = onNavigateToTaskList,
            processCount = processCount,
            showVideoCard = showVideoCard,
            showOutput = showOutput,
            showDownloadProgress = taskState.taskId.isNotEmpty(),
            pasteCallback = {
                matchUrlFromClipboard(
                    string = clipboardManager.getText().toString(),
                    isMatchingMultiLink = CUSTOM_COMMAND.getBoolean()
                )
                    .let { downloadViewModel.updateUrl(it) }
            },
            cancelCallback = {
                Downloader.cancelDownload()
            },
            onVideoCardClicked = { Downloader.openDownloadResult() },
            onUrlChanged = { url -> downloadViewModel.updateUrl(url) }) {}

        DownloadSettingDialog(useDialog = useDialog,
            showDialog = showDownloadDialog,
            onNavigateToCookieGeneratorPage = onNavigateToCookieGeneratorPage,
            onDownloadConfirm = { checkPermissionOrDownload() },
            onDismissRequest = {
                showDownloadDialog = false
            }
        )
    }


}

@OptIn(
    ExperimentalMaterial3Api::class
)
@Composable
fun DownloadPageImpl(
    downloaderState: Downloader.State,
    taskState: Downloader.DownloadTaskItem,
    viewState: DownloadViewModel.ViewState,
    errorState: Downloader.ErrorState,
    showVideoCard: Boolean = false,
    showOutput: Boolean = false,
    showDownloadProgress: Boolean = false,
    processCount: Int = 0,
    downloadCallback: () -> Unit = {},
    navigateToSettings: () -> Unit = {},
    navigateToDownloads: () -> Unit = {},
    onNavigateToTaskList: () -> Unit = {},
    pasteCallback: () -> Unit = {},
    cancelCallback: () -> Unit = {},
    onVideoCardClicked: () -> Unit = {},
    onUrlChanged: (String) -> Unit = {},
    isPreview: Boolean = false,
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    val clipboardManager = LocalClipboardManager.current

    val showCancelButton =
        downloaderState is Downloader.State.DownloadingPlaylist || downloaderState is Downloader.State.DownloadingVideo
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(title = {}, modifier = Modifier.padding(horizontal = 8.dp), navigationIcon = {
            TooltipBox(
                state = rememberTooltipState(),
                positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                tooltip = {
                    PlainTooltip {
                        Text(text = stringResource(id = R.string.settings))
                    }
                }) {
                IconButton(
                    onClick = {
                        view.slightHapticFeedback()
                        navigateToSettings()
                    },
                    modifier = Modifier
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Settings,
                        contentDescription = stringResource(id = R.string.settings)
                    )
                }
            }

        }, actions = {
            BadgedBox(badge = {
                if (processCount > 0)
                    Badge(
                        modifier = Modifier.offset(
                            x = (-16).dp,
                            y = (8).dp
                        )
                    ) { Text("$processCount") }
            }) {
                TooltipBox(state = rememberTooltipState(),
                    positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                    tooltip = {
                        PlainTooltip {
                            Text(text = stringResource(id = R.string.running_tasks))
                        }
                    }) {
                    IconButton(
                        onClick = {
                            view.slightHapticFeedback()
                            onNavigateToTaskList()
                        },
                        modifier = Modifier
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Terminal,
                            contentDescription = stringResource(id = R.string.running_tasks)
                        )
                    }
                }
            }
            TooltipBox(state = rememberTooltipState(),
                positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                tooltip = {
                    PlainTooltip {
                        Text(text = stringResource(id = R.string.downloads_history))
                    }
                }) {
                IconButton(
                    onClick = {
                        view.slightHapticFeedback()
                        navigateToDownloads()
                    },
                    modifier = Modifier
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Subscriptions,
                        contentDescription = stringResource(id = R.string.downloads_history)
                    )
                }
            }
        })
    }, floatingActionButton = {
        FloatingActionButton(
            onClick = downloadCallback,
            modifier = with(receiver = Modifier) { if (showDownloadProgress) this else this.imePadding() },
            shape = MaterialTheme.shapes.large,
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.ContentPaste,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = stringResource(id = R.string.paste_msg),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            TitleWithProgressIndicator(
                showProgressIndicator = downloaderState is Downloader.State.FetchingInfo,
                isDownloadingPlaylist = downloaderState is Downloader.State.DownloadingPlaylist,
                showDownloadText = showCancelButton,
                currentIndex = downloaderState.run { if (this is Downloader.State.DownloadingPlaylist) currentItem else 0 },
                downloadItemCount = downloaderState.run { if (this is Downloader.State.DownloadingPlaylist) itemCount else 0 },
                isCentered = true,
            )


            Column(
                Modifier
                    .padding(horizontal = 24.dp)
                    .padding(top = 32.dp)
            ) {
                // Search Bar / URL Input - Moved to middle section, more prominent
                InputUrl(
                    url = viewState.url,
                    progress = taskState.progress,
                    showDownloadProgress = showDownloadProgress && !showVideoCard,
                    error = errorState != Downloader.ErrorState.None,
                    showCancelButton = showCancelButton && !showVideoCard,
                    onCancel = cancelCallback,
                    onDone = downloadCallback,
                ) { url -> onUrlChanged(url) }

                with(taskState) {
                    AnimatedVisibility(
                        visible = showDownloadProgress && showVideoCard
                    ) {
                        Box() {
                            VideoCard(
                                modifier = Modifier,
                                title = title,
                                author = uploader,
                                thumbnailUrl = thumbnailUrl,
                                progress = progress,
                                showCancelButton = downloaderState is Downloader.State.DownloadingPlaylist || downloaderState is Downloader.State.DownloadingVideo,
                                onCancel = cancelCallback,
                                fileSizeApprox = fileSizeApprox,
                                duration = duration,
                                onClick = onVideoCardClicked,
                                isPreview = isPreview
                            )

                        }
                    }
                    AnimatedVisibility(
                        modifier = Modifier.fillMaxWidth(),
                        enter = expandVertically() + fadeIn(),
                        exit = shrinkVertically() + fadeOut(),
                        visible = progressText.isNotEmpty() && showOutput
                    ) {
                        Text(
                            modifier = Modifier.padding(bottom = 12.dp),
                            text = progressText,
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
                AnimatedVisibility(visible = errorState != Downloader.ErrorState.None) {
                    ErrorMessage(
                        title = errorState.title,
                        errorReport = errorState.report
                    ) {
                        view.longPressHapticFeedback()
                        clipboardManager.setText(AnnotatedString(App.getVersionReport() + "\nURL: ${errorState.url}\n${errorState.report}"))
                        ToastUtil.makeToast(R.string.error_copied)
                    }
                }
                content()
//                val output = Downloader.mutableProcessOutput
//                LazyRow() {
//                    items(output.toList()) { entry ->
//                        TextField(
//                            value = entry.second,
//                            label = { Text(entry.first) },
//                            onValueChange = {},
//                            readOnly = true,
//                            minLines = 10,
//                            maxLines = 10,
//                        )
//                    }
//                }
//                    PreviewFormat()
                FooterSignature()
                NavigationBarSpacer()
                Spacer(modifier = Modifier.height(160.dp))
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TitleWithProgressIndicator(
    showProgressIndicator: Boolean = true,
    showDownloadText: Boolean = true,
    isDownloadingPlaylist: Boolean = true,
    currentIndex: Int = 1,
    downloadItemCount: Int = 4,
    isCentered: Boolean = false,
) {
    val textAlign = if (isCentered) TextAlign.Center else TextAlign.Start
    val horizontalPadding = if (isCentered) 24.dp else 12.dp
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding)
            .padding(top = if (isCentered) 40.dp else 24.dp),
        horizontalAlignment = if (isCentered) Alignment.CenterHorizontally else Alignment.Start
    ) {
        // LOOP Brand Name - Much larger and centered when isCentered=true
        Text(
            text = stringResource(R.string.app_name),
            fontSize = if (isCentered) 72.sp else 36.sp,
            fontFamily = MilkerFontFamily,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            letterSpacing = if (isCentered) 2.sp else 0.sp,
            textAlign = textAlign,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        
        // Subtitle tagline
        Text(
            text = "Every Day, Every Download, Every Content.",
            fontSize = if (isCentered) 13.sp else 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontWeight = FontWeight.Medium,
            textAlign = textAlign,
            modifier = Modifier.padding(top = if (isCentered) 12.dp else 6.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        
        // Progress indicator when fetching info
        AnimatedVisibility(visible = showProgressIndicator) {
            Column(
                modifier = Modifier
                    .padding(top = if (isCentered) 24.dp else 12.dp)
                    .fillMaxWidth(),
                horizontalAlignment = if (isCentered) Alignment.CenterHorizontally else Alignment.Start
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    strokeWidth = 3.dp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
        
        // Download status text
        AnimatedVisibility(visible = showDownloadText && !isCentered) {
            Text(
                if (isDownloadingPlaylist) stringResource(R.string.playlist_indicator_text).format(
                    currentIndex,
                    downloadItemCount
                )
                else stringResource(R.string.downloading_indicator_text),
                modifier = Modifier.padding(top = 8.dp),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = textAlign
            )
        }
    }
}

@Composable
fun ErrorMessage(
    modifier: Modifier = Modifier,
    title: String,
    errorReport: String,
    onButtonClicked: () -> Unit = {}
) {
    val view = LocalView.current
    Surface(
        color = MaterialTheme.colorScheme.errorContainer,
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .padding(vertical = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .animateContentSize()
                .padding(horizontal = 12.dp, vertical = 16.dp)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.Error,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onErrorContainer
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onErrorContainer
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = errorReport,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onErrorContainer
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(
                    onClick = onButtonClicked,
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Text(text = stringResource(id = R.string.copy_log))
                }
                TextButton(
                    onClick = onButtonClicked,
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Text(text = stringResource(id = R.string.got_it))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun InputUrl(
    url: String,
    error: Boolean,
    showDownloadProgress: Boolean = false,
    progress: Float,
    onDone: () -> Unit,
    showCancelButton: Boolean,
    onCancel: () -> Unit,
    onValueChange: (String) -> Unit
) {
    val softwareKeyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        value = url,
        isError = error,
        onValueChange = onValueChange,
        label = { Text(stringResource(R.string.video_url)) },
        modifier = Modifier
            .padding(0f.dp, 16f.dp)
            .fillMaxWidth(),
        textStyle = MaterialTheme.typography.bodyLarge,
        maxLines = 3,
        colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            cursorColor = MaterialTheme.colorScheme.primary,
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
        ),
        trailingIcon = {
            if (url.isNotEmpty()) ClearButton { onValueChange("") }
        }, keyboardActions = KeyboardActions(onDone = { onDone() }),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
    )
    AnimatedVisibility(visible = showDownloadProgress) {
        Row(
            Modifier.padding(0.dp, 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val progressAnimationValue by animateFloatAsState(
                targetValue = progress / 100f,
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            )
            if (progressAnimationValue < 0) LinearProgressIndicator(
                modifier = Modifier
                    .weight(0.75f)
                    .clip(MaterialTheme.shapes.large),
            )
            else LinearProgressIndicator(
                progress = { progressAnimationValue },
                modifier = Modifier
                    .weight(0.75f)
                    .clip(MaterialTheme.shapes.large),
            )
            Text(
                text = if (progress < 0) "0%" else "$progress%",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(0.25f)
            )
        }
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        AnimatedVisibility(visible = showCancelButton) {
            OutlinedButtonWithIcon(
                onClick = onCancel,
                icon = Icons.Outlined.Cancel,
                text = stringResource(id = R.string.cancel),
                contentColor = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }

}

/**
 * Sign-off at the foot of Home.
 *
 * The credit is bracketed by two hairline rules that share the row's width. That is the whole
 * trick: without them a single line of grey text below the content looks like leftover copy,
 * with them it reads as an intentional signature and the list has somewhere to end. Emphasis
 * stays in tone and spacing -- no glow, no chip, no filled pill.
 */
@Composable
private fun FooterSignature(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 28.dp, end = 28.dp, top = 32.dp, bottom = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Hairline()
        Text(
            text = stringResource(id = R.string.home_footer_credit),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            letterSpacing = 1.4.sp,
            maxLines = 1
        )
        Hairline()
    }
}

@Composable
private fun RowScope.Hairline() {
    Box(
        modifier = Modifier
            .weight(1f)
            .height(1.dp)
            .background(MaterialTheme.colorScheme.outlineVariant)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewDownloadPage() {
    PreviewThemeLight {
        LoopTheme {
            DownloadPage()
        }
    }
}