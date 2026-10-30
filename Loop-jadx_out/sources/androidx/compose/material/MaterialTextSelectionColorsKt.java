package androidx.compose.material;

import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.ColorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: MaterialTextSelectionColors.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\"\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a2\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a*\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, m195d2 = {"DefaultSelectionBackgroundAlpha", "", "DesiredContrastRatio", "MinimumSelectionBackgroundAlpha", "binarySearchForAccessibleSelectionColorAlpha", "selectionColor", "Landroidx/compose/ui/graphics/Color;", "textColor", "backgroundColor", "binarySearchForAccessibleSelectionColorAlpha-ysEtTa8", "(JJJ)F", "calculateContrastRatio", "foreground", "background", "calculateContrastRatio--OWjLjI", "(JJ)F", "selectionColorAlpha", "calculateContrastRatio-nb2GgbA", "(JFJJ)F", "calculateSelectionBackgroundColor", "calculateSelectionBackgroundColor-ysEtTa8", "(JJJ)J", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "colors", "Landroidx/compose/material/Colors;", "(Landroidx/compose/material/Colors;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "material_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MaterialTextSelectionColorsKt {
    private static final float DefaultSelectionBackgroundAlpha = 0.4f;
    private static final float DesiredContrastRatio = 4.5f;
    private static final float MinimumSelectionBackgroundAlpha = 0.2f;

    public static final SelectionColors rememberTextSelectionColors(Colors colors, Composer $composer, int $changed) {
        long jM4301unboximpl;
        ComposerKt.sourceInformationMarkerStart($composer, -721696685, "C(rememberTextSelectionColors)45@1902L6,47@1930L384:MaterialTextSelectionColors.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-721696685, $changed, -1, "androidx.compose.material.rememberTextSelectionColors (MaterialTextSelectionColors.kt:35)");
        }
        long primaryColor = colors.m1627getPrimary0d7_KjU();
        long backgroundColor = colors.m1620getBackground0d7_KjU();
        $composer.startReplaceGroup(35572910);
        ComposerKt.sourceInformation($composer, "*43@1845L7");
        long $this$takeOrElse_u2dDxMtmZc$iv = ColorsKt.m1644contentColorFor4WTKRHQ(colors, backgroundColor);
        if ($this$takeOrElse_u2dDxMtmZc$iv != 16) {
            jM4301unboximpl = $this$takeOrElse_u2dDxMtmZc$iv;
        } else {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            jM4301unboximpl = ((Color) objConsume).m4301unboximpl();
        }
        $composer.endReplaceGroup();
        long textColorWithLowestAlpha = Color.m4289copywmQWz5c(jM4301unboximpl, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM4301unboximpl) : ContentAlpha.INSTANCE.getMedium($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(jM4301unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM4301unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM4301unboximpl) : 0.0f);
        ComposerKt.sourceInformationMarkerStart($composer, 35573038, "CC(remember):MaterialTextSelectionColors.kt#9igjgp");
        boolean invalid$iv = $composer.changed(primaryColor) | $composer.changed(backgroundColor) | $composer.changed(textColorWithLowestAlpha);
        Object value$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new SelectionColors(colors.m1627getPrimary0d7_KjU(), m1727calculateSelectionBackgroundColorysEtTa8(primaryColor, textColorWithLowestAlpha, backgroundColor), null);
            $composer.updateRememberedValue(value$iv);
        }
        SelectionColors selectionColors = (SelectionColors) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return selectionColors;
    }

    /* JADX INFO: renamed from: calculateSelectionBackgroundColor-ysEtTa8, reason: not valid java name */
    public static final long m1727calculateSelectionBackgroundColorysEtTa8(long selectionColor, long textColor, long backgroundColor) {
        float alpha;
        float maximumContrastRatio = m1726calculateContrastRationb2GgbA(selectionColor, 0.4f, textColor, backgroundColor);
        float minimumContrastRatio = m1726calculateContrastRationb2GgbA(selectionColor, 0.2f, textColor, backgroundColor);
        if (maximumContrastRatio >= DesiredContrastRatio) {
            alpha = 0.4f;
        } else {
            alpha = minimumContrastRatio < DesiredContrastRatio ? 0.2f : m1724binarySearchForAccessibleSelectionColorAlphaysEtTa8(selectionColor, textColor, backgroundColor);
        }
        return Color.m4289copywmQWz5c(selectionColor, (14 & 1) != 0 ? Color.m4293getAlphaimpl(selectionColor) : alpha, (14 & 2) != 0 ? Color.m4297getRedimpl(selectionColor) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(selectionColor) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(selectionColor) : 0.0f);
    }

    /* JADX INFO: renamed from: binarySearchForAccessibleSelectionColorAlpha-ysEtTa8, reason: not valid java name */
    private static final float m1724binarySearchForAccessibleSelectionColorAlphaysEtTa8(long selectionColor, long textColor, long backgroundColor) {
        float lowAlpha = 0.2f;
        float alpha = 0.4f;
        float highAlpha = 0.4f;
        for (int attempts = 0; attempts < 7; attempts++) {
            float contrastRatio = m1726calculateContrastRationb2GgbA(selectionColor, alpha, textColor, backgroundColor);
            float percentageError = (contrastRatio / DesiredContrastRatio) - 1.0f;
            boolean z = false;
            if (0.0f <= percentageError && percentageError <= 0.01f) {
                z = true;
            }
            if (z) {
                break;
            }
            if (percentageError < 0.0f) {
                highAlpha = alpha;
            } else {
                lowAlpha = alpha;
            }
            alpha = (highAlpha + lowAlpha) / 2.0f;
        }
        return alpha;
    }

    /* JADX INFO: renamed from: calculateContrastRatio-nb2GgbA, reason: not valid java name */
    private static final float m1726calculateContrastRationb2GgbA(long selectionColor, float selectionColorAlpha, long textColor, long backgroundColor) {
        long compositeBackground = ColorKt.m4336compositeOverOWjLjI(Color.m4289copywmQWz5c(selectionColor, (14 & 1) != 0 ? Color.m4293getAlphaimpl(selectionColor) : selectionColorAlpha, (14 & 2) != 0 ? Color.m4297getRedimpl(selectionColor) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(selectionColor) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(selectionColor) : 0.0f), backgroundColor);
        long compositeTextColor = ColorKt.m4336compositeOverOWjLjI(textColor, compositeBackground);
        return m1725calculateContrastRatioOWjLjI(compositeTextColor, compositeBackground);
    }

    /* JADX INFO: renamed from: calculateContrastRatio--OWjLjI, reason: not valid java name */
    public static final float m1725calculateContrastRatioOWjLjI(long foreground, long background) {
        float foregroundLuminance = ColorKt.m4343luminance8_81llA(foreground) + 0.05f;
        float backgroundLuminance = ColorKt.m4343luminance8_81llA(background) + 0.05f;
        return Math.max(foregroundLuminance, backgroundLuminance) / Math.min(foregroundLuminance, backgroundLuminance);
    }
}
