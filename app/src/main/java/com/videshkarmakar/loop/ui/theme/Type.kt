@file:OptIn(ExperimentalTextApi::class, ExperimentalTextApi::class, ExperimentalTextApi::class)

package com.videshkarmakar.loop.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.sp
import com.videshkarmakar.loop.R


val Typography =
    Typography().run {
        copy(
            bodyLarge = bodyLarge.applyLinebreak().applyTextDirection(),
            bodyMedium = bodyMedium.applyLinebreak().applyTextDirection(),
            bodySmall = bodySmall.applyLinebreak().applyTextDirection(),
            titleLarge = titleLarge.applyTextDirection(),
            titleMedium = titleMedium.applyTextDirection(),
            titleSmall = titleSmall.applyTextDirection(),
            headlineSmall = headlineSmall.applyTextDirection(),
            headlineMedium = headlineMedium.applyTextDirection(),
            headlineLarge = headlineLarge.applyTextDirection(),
            displaySmall = displaySmall.applyTextDirection(),
            displayMedium = displayMedium.applyTextDirection(),
            displayLarge = displayLarge.applyTextDirection(),
            labelLarge = labelLarge.applyTextDirection(),
            labelMedium = labelMedium.applyTextDirection(),
            labelSmall = labelSmall.applyTextDirection(),
        )
    }

private fun TextStyle.applyLinebreak(): TextStyle = this.copy(lineBreak = LineBreak.Paragraph)
private fun TextStyle.applyTextDirection(): TextStyle =
    this.copy(textDirection = TextDirection.Content)


val preferenceTitle = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 20.sp, lineHeight = 24.sp,
    lineBreak = LineBreak.Paragraph,
)

/**
 * Display face reserved for the "LOOP" wordmark.
 *
 * Deliberately not part of [Typography]: Milker is a decorative face with a single weight and a
 * tight, stylised silhouette. Rolling it out across headings or body copy would fight the plain
 * system face used everywhere else, so it is opted into per Text instead.
 */
val MilkerFontFamily = FontFamily(
    Font(R.font.milker, weight = FontWeight.Normal)
)



