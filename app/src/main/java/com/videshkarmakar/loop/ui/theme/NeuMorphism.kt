package com.videshkarmakar.loop.ui.theme

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Dark neumorphic tokens, sampled from the reference.
 *
 * Real soft-UI is built from a *pair* of shadows cast by one consistent light source, which is
 * why it cannot be reproduced with a glow. A single blurred coloured copy reads as "AI slop"
 * because it has no opposing shadow and therefore no physical origin.
 *
 * Light is assumed to come from the top-left, matching the light-side tone (#2B2B2B) sitting
 * above the base and the dark-side tone (#0B0B0B) below it in the reference histogram.
 */
object Neu {

    /** Canvas tone. 39.9% of the reference frame. */
    val base = Color(0xFF181818)

    /** Light-side tone for raised surfaces. */
    val highlight = Color(0xFF2B2B2B)

    /** Dark-side tone for raised surfaces. */
    val shadow = Color(0xFF0B0B0B)

    /** Deepest inset. 12% of the reference frame. */
    val deepShadow = Color(0xFF000000)

    /** Recessed panel fill. 11% of the reference frame. */
    val insetFill = Color(0xFF101010)

    /** Pressed state swaps which side is light. */
    val pressedHighlight = Color(0xFF101010)
    val pressedShadow = Color(0xFF242424)

    /** Direction of the light source, top-left. */
    val lightSource = Offset(-1f, -1f)
    val shadeDirection = Offset(1f, 1f)
}

private const val STEPS = 8

/**
 * Expands the shape outward in [direction] and fades alpha toward the edge, approximating a true
 * Gaussian falloff. Drawn as concentric translucent rings rather than a BlurMaskFilter so it
 * renders identically on every supported API level and stays on the hardware canvas.
 */
private fun DrawScope.softEdge(radius: Float, spread: Float, direction: Offset, color: Color) {
    for (i in STEPS downTo 1) {
        val t = i.toFloat() / STEPS
        val grow = spread * t
        val alpha = color.alpha * (1f - t) * 0.34f
        if (alpha <= 0.002f) continue
        val off = direction * grow
        drawRoundRect(
            color = color.copy(alpha = alpha),
            topLeft = Offset(-grow + off.x, -grow + off.y),
            size = Size(size.width + grow * 2f, size.height + grow * 2f),
            cornerRadius = CornerRadius(radius + grow, radius + grow)
        )
    }
}

private fun Modifier.neuMaterial(
    cornerRadius: Dp,
    depth: Dp,
    fill: Color,
    lightTone: Color,
    darkTone: Color,
    drawFill: Boolean,
): Modifier = drawBehind {
    val r = cornerRadius.toPx()
    val d = depth.toPx()
    if (d > 0f) {
        softEdge(radius = r, spread = d, direction = Neu.lightSource, color = lightTone)
        softEdge(radius = r, spread = d, direction = Neu.shadeDirection, color = darkTone)
    }
    if (drawFill) {
        drawRoundRect(
            color = fill,
            cornerRadius = CornerRadius(r, r)
        )
    }
}

/**
 * Raised surface: light above-left, shade below-right.
 * Use for cards, tiles, buttons and anything that should read as physically lifted off the canvas.
 */
fun Modifier.neuRaised(
    cornerRadius: Dp,
    depth: Dp = 8.dp,
    pressed: Boolean = false,
    fill: Color = Neu.base,
): Modifier = neuMaterial(
    cornerRadius = cornerRadius,
    depth = depth,
    fill = if (pressed) Neu.pressedHighlight else fill,
    lightTone = if (pressed) Neu.pressedHighlight else Neu.highlight,
    darkTone = if (pressed) Neu.pressedShadow else Neu.shadow,
    drawFill = true
)

/**
 * Pressed / recessed state: the two tones swap sides, so the surface reads as pushed into the
 * canvas. This is the same geometry as [neuRaised] with the light and shade directions inverted.
 */
fun Modifier.neuPressed(
    cornerRadius: Dp,
    depth: Dp = 8.dp,
    fill: Color = Neu.insetFill,
): Modifier = neuMaterial(
    cornerRadius = cornerRadius,
    depth = depth,
    fill = fill,
    lightTone = Neu.pressedHighlight,
    darkTone = Neu.pressedShadow,
    drawFill = true
)

/**
 * Recessed surface, used for text fields, wells, tracks and progress bars.
 * Pass [drawFill] = false to leave the interior transparent.
 */
fun Modifier.neuInset(
    cornerRadius: Dp,
    depth: Dp = 6.dp,
    fill: Color = Neu.insetFill,
    drawFill: Boolean = true,
): Modifier = neuMaterial(
    cornerRadius = cornerRadius,
    depth = depth,
    fill = fill,
    lightTone = Neu.shadow,
    darkTone = Neu.highlight,
    drawFill = drawFill
)


