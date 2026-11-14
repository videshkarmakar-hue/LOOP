package com.videshkarmakar.loop.ui.theme

import androidx.compose.ui.graphics.Color

/**
 * Matte-stone palette used by the Home screen.
 *
 * The Home reference is a fixed dark composition -- sun, wordmark and horizon are lit for one
 * background tone -- so these tones are deliberately not routed through the Material color scheme
 * and do not react to dynamic color or the light/dark toggle. Everything else in the app keeps
 * following the theme.
 */
object Matte {
    /** Canvas. */
    val Background = Color(0xFF16181A)

    /** Raised field / input surface. */
    val Surface = Color(0xFF1B1D1F)

    /** Secondary raised surface, e.g. the clipboard pill. */
    val SurfaceHigh = Color(0xFF23262A)

    /** Hairline and field borders. */
    val Outline = Color(0xFF2E3238)

    /** Dimmer dividers. */
    val OutlineSoft = Color(0xFF3D4249)

    /** Secondary text, icon resting tone. */
    val TextMuted = Color(0xFF8E9298)

    /** Tertiary text, slightly brighter than [TextMuted]. */
    val TextSubtle = Color(0xFFA6ABB2)

    /** Primary text. */
    val Chalk = Color(0xFFF2F4F7)

    val Coral = Color(0xFFF75254)
    val CoralBright = Color(0xFFFF6466)
    val CoralDeep = Color(0xFFDE4547)
}
