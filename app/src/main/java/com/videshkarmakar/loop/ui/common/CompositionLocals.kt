package com.videshkarmakar.loop.ui.common

import android.os.Build
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.videshkarmakar.loop.ui.theme.LoopColorScheme
import com.videshkarmakar.loop.ui.theme.Primary
import com.videshkarmakar.loop.util.DarkThemePreference
import com.videshkarmakar.loop.util.PreferenceUtil
import com.videshkarmakar.loop.util.paletteStyles
import com.kyant.monet.PaletteStyle

val LocalDarkTheme = compositionLocalOf { DarkThemePreference() }
val LocalSeedColor = compositionLocalOf { 0xFFD7263D.toLong() }
val LocalWindowWidthState = staticCompositionLocalOf { WindowWidthSizeClass.Compact }
val LocalDynamicColorSwitch = compositionLocalOf { false }
val LocalPaletteStyleIndex = compositionLocalOf { 0 }

@Composable
fun SettingsProvider(windowWidthSizeClass: WindowWidthSizeClass, content: @Composable () -> Unit) {
    PreferenceUtil.AppSettingsStateFlow.collectAsState().value.run {
        CompositionLocalProvider(
            LocalDarkTheme provides darkTheme,
            LocalSeedColor provides seedColor.toLong(),
            LocalPaletteStyleIndex provides paletteStyleIndex,
            LocalWindowWidthState provides windowWidthSizeClass,
            LocalDynamicColorSwitch provides isDynamicColorEnabled,
            content = content
        )
    }
}


