package com.videshkarmakar.loop.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.google.android.material.color.MaterialColors
import com.videshkarmakar.loop.ui.common.LocalDarkTheme
import io.material.hct.Hct

/**
 * Neutral seed: the reference surface is fully achromatic (measured R-G = 0, B-G = 0 across
 * every luma band), so dynamic color must resolve to grey rather than to a hue.
 */
const val DEFAULT_SEED_COLOR = 0x7A7A7A

@Composable
fun Color.harmonizeWithPrimary(): Color =
    Color(MaterialColors.harmonize(this.toArgb(), MaterialTheme.colorScheme.primary.toArgb()))

@Composable
fun Color.harmonizeWith(other: Color): Color =
    Color(MaterialColors.harmonize(this.toArgb(), other.toArgb()))

@Composable
fun Int.generateLabelColor(): Color =
    Color(
        Hct.from(
            hue = (this % 360).toDouble(),
            chroma = 36.0,
            tone = 80.0
        ).toInt()
    ).harmonizeWithPrimary()

// ---------------------------------------------------------------------------
// Palette sampled from the reference image (share of UI pixels in brackets).
// Dark bands account for 53.6% of the frame, the light ramp for the remainder.
// ---------------------------------------------------------------------------

// Core surfaces
val Background = Color(0xFF181818) // 39.9% - dominant tone
val OnBackground = Color(0xFFCED2D2) // 2.3% - primary text
val Surface = Color(0xFF181818) // neumorphism keeps canvas and surface identical
val OnSurface = Color(0xFFCED2D2)
val SurfaceVariant = Color(0xFF101010) // 11.0% - recessed panel
val OnSurfaceVariant = Color(0xFF949696) // 1.2% - secondary text
val SurfaceContainer = Color(0xFF1F1F1F)
val SurfaceContainerHigh = Color(0xFF242424)
val SurfaceContainerHighest = Color(0xFF303030) // 9.8% - raised surface
val SurfaceContainerLow = Color(0xFF141414)
val SurfaceContainerLowest = Color(0xFF0A0A0A)

// Emphasis is carried by tone, not hue
val Primary = Color(0xFFCED2D2)
val OnPrimary = Color(0xFF181818)
val PrimaryContainer = Color(0xFF303030)
val OnPrimaryContainer = Color(0xFFCED2D2)

val Secondary = Color(0xFF949696)
val OnSecondary = Color(0xFF181818)
val SecondaryContainer = Color(0xFF242424)
val OnSecondaryContainer = Color(0xFFCED2D2)

val Tertiary = Color(0xFF717271) // 1.3% - disabled / de-emphasised
val OnTertiary = Color(0xFFCED2D2)
val TertiaryContainer = Color(0xFF1F1F1F)
val OnTertiaryContainer = Color(0xFFACAEAD)

// Error relies on maximum tonal contrast plus iconography, since no hue is available
val Error = Color(0xFFF2F2F2)
val OnError = Color(0xFF181818)
val ErrorContainer = Color(0xFF303030)
val OnErrorContainer = Color(0xFFF2F2F2)

val Outline = Color(0xFF4D4D4D) // 2.6% - mid tone
val OutlineVariant = Color(0xFF242424)

val InverseSurface = Color(0xFFCED2D2)
val InverseOnSurface = Color(0xFF181818)
val InversePrimary = Color(0xFF181818)
val Scrim = Color(0xFF000000) // 12.0% - deepest inset

val LoopColorScheme = darkColorScheme(
    primary = Primary,
    primaryContainer = PrimaryContainer,
    onPrimary = OnPrimary,
    onPrimaryContainer = OnPrimaryContainer,
    inversePrimary = InversePrimary,
    secondary = Secondary,
    secondaryContainer = SecondaryContainer,
    onSecondary = OnSecondary,
    onSecondaryContainer = OnSecondaryContainer,
    tertiary = Tertiary,
    tertiaryContainer = TertiaryContainer,
    onTertiary = OnTertiary,
    onTertiaryContainer = OnTertiaryContainer,
    background = Background,
    onBackground = OnBackground,
    surface = Surface,
    onSurface = OnSurface,
    surfaceVariant = SurfaceVariant,
    onSurfaceVariant = OnSurfaceVariant,
    surfaceContainerLowest = SurfaceContainerLowest,
    surfaceContainerLow = SurfaceContainerLow,
    surfaceContainer = SurfaceContainer,
    surfaceContainerHigh = SurfaceContainerHigh,
    surfaceContainerHighest = SurfaceContainerHighest,
    error = Error,
    onError = OnError,
    errorContainer = ErrorContainer,
    onErrorContainer = OnErrorContainer,
    outline = Outline,
    outlineVariant = OutlineVariant,
    inverseSurface = InverseSurface,
    inverseOnSurface = InverseOnSurface,
    scrim = Scrim,
)

object FixedAccentColors {
    val primaryFixed: Color
        @Composable get() = PrimaryContainer
    val primaryFixedDim: Color
        @Composable get() = Primary
    val onPrimaryFixed: Color
        @Composable get() = OnPrimaryContainer
    val onPrimaryFixedVariant: Color
        @Composable get() = OnPrimary
    val secondaryFixed: Color
        @Composable get() = SecondaryContainer
    val secondaryFixedDim: Color
        @Composable get() = Secondary
    val onSecondaryFixed: Color
        @Composable get() = OnSecondaryContainer
    val onSecondaryFixedVariant: Color
        @Composable get() = OnSecondary
    val tertiaryFixed: Color
        @Composable get() = TertiaryContainer
    val tertiaryFixedDim: Color
        @Composable get() = Tertiary
    val onTertiaryFixed: Color
        @Composable get() = OnTertiaryContainer
    val onTertiaryFixedVariant: Color
        @Composable get() = OnTertiary
}

@Composable
fun Number.autoDark(isDarkTheme: Boolean = LocalDarkTheme.current.isDarkTheme()): Double =
    if (!isDarkTheme) this.toDouble()
    else when (this.toDouble()) {
        6.0 -> 98.0
        10.0 -> 99.0
        20.0 -> 95.0
        25.0 -> 90.0
        30.0 -> 90.0
        40.0 -> 80.0
        50.0 -> 60.0
        60.0 -> 50.0
        70.0 -> 40.0
        80.0 -> 40.0
        90.0 -> 30.0
        95.0 -> 20.0
        98.0 -> 10.0
        99.0 -> 10.0
        100.0 -> 20.0
        else -> this.toDouble()
    }


