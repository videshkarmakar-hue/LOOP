package com.videshkarmakar.loop

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.collectAsState
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.videshkarmakar.loop.App.Companion.context
import com.videshkarmakar.loop.ui.common.LocalDarkTheme
import com.videshkarmakar.loop.ui.common.LocalDynamicColorSwitch
import com.videshkarmakar.loop.ui.common.SettingsProvider
import com.videshkarmakar.loop.ui.page.HomeEntry
import com.videshkarmakar.loop.ui.page.download.DownloadViewModel
import com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel
import com.videshkarmakar.loop.ui.theme.LoopTheme
import com.videshkarmakar.loop.util.HAS_SHOWN_WELCOME
import com.videshkarmakar.loop.util.PreferenceUtil
import com.videshkarmakar.loop.util.PreferenceUtil.getBoolean
import com.videshkarmakar.loop.util.matchUrlFromSharedText
import com.videshkarmakar.loop.util.setLanguage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val downloadViewModel: DownloadViewModel by viewModels()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        // The system splash cannot be suppressed on Android 12+, but it can be released
        // immediately. Holding it only while HAS_SHOWN_WELCOME is unset gives the requested
        // behaviour: a deliberate branded splash on the first launch after install, and a
        // straight pass-through into the app on every launch after that.
        var holdSplash = !HAS_SHOWN_WELCOME.getBoolean()
        installSplashScreen().setKeepOnScreenCondition { holdSplash }
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { v, insets ->
            v.setPadding(0, 0, 0, 0)
            insets
        }
        runBlocking {
            if (Build.VERSION.SDK_INT < 33) {
                setLanguage(PreferenceUtil.getLocaleFromPreference())
            }
        }
        context = this.baseContext
        setContent {
            val cookiesViewModel: CookiesViewModel = viewModel()

            val isUrlSharingTriggered =
                downloadViewModel.viewStateFlow.collectAsState().value.isUrlSharingTriggered
            val windowSizeClass = calculateWindowSizeClass(this)
            SettingsProvider(windowWidthSizeClass = windowSizeClass.widthSizeClass) {
                LoopTheme(
                    darkTheme = LocalDarkTheme.current.isDarkTheme(),
                    isHighContrastModeEnabled = LocalDarkTheme.current.isHighContrastModeEnabled,
                    isDynamicColorEnabled = LocalDynamicColorSwitch.current,
                ) {
                    HomeEntry(
                        downloadViewModel = downloadViewModel,
                        cookiesViewModel = cookiesViewModel,
                        isUrlShared = isUrlSharingTriggered
                    )
                }
            }

            handleShareIntent(intent)
        }

        // Release the hold once the branding has had a beat to land. On later launches this
        // branch is skipped entirely and the splash is released before the first frame.
        if (holdSplash) {
            lifecycleScope.launch {
                delay(SPLASH_HOLD_MILLIS)
                holdSplash = false
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        handleShareIntent(intent)
        super.onNewIntent(intent)
    }

    private fun handleShareIntent(intent: Intent) {
        Log.d(TAG, "handleShareIntent: $intent")

        when (intent.action) {
            Intent.ACTION_VIEW -> {
                intent.dataString?.let {
                    sharedUrl = it
                    downloadViewModel.updateUrl(sharedUrl, true)
                }
            }

            Intent.ACTION_SEND -> {
                intent.getStringExtra(Intent.EXTRA_TEXT)
                    ?.let { sharedContent ->
                        intent.removeExtra(Intent.EXTRA_TEXT)
                        matchUrlFromSharedText(sharedContent)
                            .let { matchedUrl ->
                                if (sharedUrl != matchedUrl) {
                                    sharedUrl = matchedUrl
                                    downloadViewModel.updateUrl(sharedUrl, true)
                                }
                            }
                    }
            }
        }
    }

    companion object {
        private const val TAG = "MainActivity"

        /** How long the splash is held on the first launch after install. */
        private const val SPLASH_HOLD_MILLIS = 1400L
        private var sharedUrl = ""

    }

}








