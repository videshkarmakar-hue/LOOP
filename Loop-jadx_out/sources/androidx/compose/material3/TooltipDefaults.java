package androidx.compose.material3;

import androidx.compose.material3.tokens.PlainTooltipTokens;
import androidx.compose.material3.tokens.RichTooltipTokens;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.p001ui.unit.IntRect;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.p001ui.window.PopupPositionProvider;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: Tooltip.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001c\u0010\u001e\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001dJ\r\u0010 \u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010!J:\u0010 \u001a\u00020\u00142\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\b8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u00020\b8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\u0013\u001a\u00020\u0014*\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, m195d2 = {"Landroidx/compose/material3/TooltipDefaults;", "", "()V", "caretProperties", "Landroidx/compose/material3/CaretProperties;", "getCaretProperties", "()Landroidx/compose/material3/CaretProperties;", "plainTooltipContainerColor", "Landroidx/compose/ui/graphics/Color;", "getPlainTooltipContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "plainTooltipContainerShape", "Landroidx/compose/ui/graphics/Shape;", "getPlainTooltipContainerShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "plainTooltipContentColor", "getPlainTooltipContentColor", "richTooltipContainerShape", "getRichTooltipContainerShape", "defaultRichTooltipColors", "Landroidx/compose/material3/RichTooltipColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultRichTooltipColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/RichTooltipColors;", "rememberPlainTooltipPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "spacingBetweenTooltipAndAnchor", "Landroidx/compose/ui/unit/Dp;", "rememberPlainTooltipPositionProvider-kHDZbjc", "(FLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/window/PopupPositionProvider;", "rememberRichTooltipPositionProvider", "rememberRichTooltipPositionProvider-kHDZbjc", "richTooltipColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/RichTooltipColors;", "containerColor", "contentColor", "titleContentColor", "actionContentColor", "richTooltipColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/RichTooltipColors;", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TooltipDefaults {
    public static final int $stable = 0;
    public static final TooltipDefaults INSTANCE = new TooltipDefaults();
    private static final CaretProperties caretProperties = new CaretProperties(C1979Dp.m6801constructorimpl(8), C1979Dp.m6801constructorimpl(16), null);

    private TooltipDefaults() {
    }

    public final Shape getPlainTooltipContainerShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 49570325, "C259@10469L5:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(49570325, $changed, -1, "androidx.compose.material3.TooltipDefaults.<get-plainTooltipContainerShape> (Tooltip.kt:259)");
        }
        Shape value = ShapesKt.getValue(PlainTooltipTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final long getPlainTooltipContainerColor(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 102696215, "C265@10657L5:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(102696215, $changed, -1, "androidx.compose.material3.TooltipDefaults.<get-plainTooltipContainerColor> (Tooltip.kt:265)");
        }
        long value = ColorSchemeKt.getValue(PlainTooltipTokens.INSTANCE.getContainerColor(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final long getPlainTooltipContentColor(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1982928937, "C271@10857L5:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1982928937, $changed, -1, "androidx.compose.material3.TooltipDefaults.<get-plainTooltipContentColor> (Tooltip.kt:271)");
        }
        long value = ColorSchemeKt.getValue(PlainTooltipTokens.INSTANCE.getSupportingTextColor(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final Shape getRichTooltipContainerShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1138709783, "C277@11042L5:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1138709783, $changed, -1, "androidx.compose.material3.TooltipDefaults.<get-richTooltipContainerShape> (Tooltip.kt:277)");
        }
        Shape value = ShapesKt.getValue(RichTooltipTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final CaretProperties getCaretProperties() {
        return caretProperties;
    }

    public final RichTooltipColors richTooltipColors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1622312141, "C(richTooltipColors)290@11400L11:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1622312141, $changed, -1, "androidx.compose.material3.TooltipDefaults.richTooltipColors (Tooltip.kt:290)");
        }
        RichTooltipColors defaultRichTooltipColors$material3_release = getDefaultRichTooltipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultRichTooltipColors$material3_release;
    }

    /* JADX INFO: renamed from: richTooltipColors-ro_MJ88, reason: not valid java name */
    public final RichTooltipColors m2959richTooltipColorsro_MJ88(long containerColor, long contentColor, long titleContentColor, long actionContentColor, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 1498555081, "C(richTooltipColors)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color)302@11874L11:Tooltip.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : containerColor;
        long contentColor2 = (i & 2) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : contentColor;
        long titleContentColor2 = (i & 4) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : titleContentColor;
        long actionContentColor2 = (i & 8) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : actionContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1498555081, $changed, -1, "androidx.compose.material3.TooltipDefaults.richTooltipColors (Tooltip.kt:302)");
        }
        RichTooltipColors richTooltipColorsM2519copyjRlVdoo = getDefaultRichTooltipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6)).m2519copyjRlVdoo(containerColor2, contentColor2, titleContentColor2, actionContentColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return richTooltipColorsM2519copyjRlVdoo;
    }

    public final RichTooltipColors getDefaultRichTooltipColors$material3_release(ColorScheme $this$defaultRichTooltipColors) {
        RichTooltipColors defaultRichTooltipColorsCached = $this$defaultRichTooltipColors.getDefaultRichTooltipColorsCached();
        if (defaultRichTooltipColorsCached == null) {
            RichTooltipColors it = new RichTooltipColors(ColorSchemeKt.fromToken($this$defaultRichTooltipColors, RichTooltipTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken($this$defaultRichTooltipColors, RichTooltipTokens.INSTANCE.getSupportingTextColor()), ColorSchemeKt.fromToken($this$defaultRichTooltipColors, RichTooltipTokens.INSTANCE.getSubheadColor()), ColorSchemeKt.fromToken($this$defaultRichTooltipColors, RichTooltipTokens.INSTANCE.getActionLabelTextColor()), null);
            $this$defaultRichTooltipColors.setDefaultRichTooltipColorsCached$material3_release(it);
            return it;
        }
        return defaultRichTooltipColorsCached;
    }

    /* JADX INFO: renamed from: rememberPlainTooltipPositionProvider-kHDZbjc, reason: not valid java name */
    public final PopupPositionProvider m2957rememberPlainTooltipPositionProviderkHDZbjc(float spacingBetweenTooltipAndAnchor, Composer $composer, int $changed, int i) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, 1047866909, "C(rememberPlainTooltipPositionProvider)P(0:c#ui.unit.Dp)*331@13176L7,334@13267L921:Tooltip.kt#uh7d8r");
        if ((i & 1) != 0) {
            spacingBetweenTooltipAndAnchor = TooltipKt.getSpacingBetweenTooltipAndAnchor();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1047866909, $changed, -1, "androidx.compose.material3.TooltipDefaults.rememberPlainTooltipPositionProvider (Tooltip.kt:330)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density $this$rememberPlainTooltipPositionProvider_kHDZbjc_u24lambda_u241 = (Density) objConsume;
        final int tooltipAnchorSpacing = $this$rememberPlainTooltipPositionProvider_kHDZbjc_u24lambda_u241.mo561roundToPx0680j_4(spacingBetweenTooltipAndAnchor);
        ComposerKt.sourceInformationMarkerStart($composer, -2013871689, "CC(remember):Tooltip.kt#9igjgp");
        boolean invalid$iv = $composer.changed(tooltipAnchorSpacing);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new PopupPositionProvider() { // from class: androidx.compose.material3.TooltipDefaults$rememberPlainTooltipPositionProvider$1$1
                @Override // androidx.compose.p001ui.window.PopupPositionProvider
                /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
                public long mo1463calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
                    int x = anchorBounds.getLeft() + ((anchorBounds.getWidth() - IntSize.m6975getWidthimpl(popupContentSize)) / 2);
                    int y = (anchorBounds.getTop() - IntSize.m6974getHeightimpl(popupContentSize)) - tooltipAnchorSpacing;
                    if (y < 0) {
                        y = anchorBounds.getBottom() + tooltipAnchorSpacing;
                    }
                    return IntOffsetKt.IntOffset(x, y);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        TooltipDefaults$rememberPlainTooltipPositionProvider$1$1 tooltipDefaults$rememberPlainTooltipPositionProvider$1$1 = (TooltipDefaults$rememberPlainTooltipPositionProvider$1$1) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return tooltipDefaults$rememberPlainTooltipPositionProvider$1$1;
    }

    /* JADX INFO: renamed from: rememberRichTooltipPositionProvider-kHDZbjc, reason: not valid java name */
    public final PopupPositionProvider m2958rememberRichTooltipPositionProviderkHDZbjc(float spacingBetweenTooltipAndAnchor, Composer $composer, int $changed, int i) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -1538806795, "C(rememberRichTooltipPositionProvider)P(0:c#ui.unit.Dp)*366@14688L7,369@14779L1445:Tooltip.kt#uh7d8r");
        if ((i & 1) != 0) {
            spacingBetweenTooltipAndAnchor = TooltipKt.getSpacingBetweenTooltipAndAnchor();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1538806795, $changed, -1, "androidx.compose.material3.TooltipDefaults.rememberRichTooltipPositionProvider (Tooltip.kt:365)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density $this$rememberRichTooltipPositionProvider_kHDZbjc_u24lambda_u243 = (Density) objConsume;
        final int tooltipAnchorSpacing = $this$rememberRichTooltipPositionProvider_kHDZbjc_u24lambda_u243.mo561roundToPx0680j_4(spacingBetweenTooltipAndAnchor);
        ComposerKt.sourceInformationMarkerStart($composer, 1605212259, "CC(remember):Tooltip.kt#9igjgp");
        boolean invalid$iv = $composer.changed(tooltipAnchorSpacing);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new PopupPositionProvider() { // from class: androidx.compose.material3.TooltipDefaults$rememberRichTooltipPositionProvider$1$1
                @Override // androidx.compose.p001ui.window.PopupPositionProvider
                /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
                public long mo1463calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
                    int x = anchorBounds.getLeft();
                    if (IntSize.m6975getWidthimpl(popupContentSize) + x > IntSize.m6975getWidthimpl(windowSize) && (x = anchorBounds.getRight() - IntSize.m6975getWidthimpl(popupContentSize)) < 0) {
                        x = anchorBounds.getLeft() + ((anchorBounds.getWidth() - IntSize.m6975getWidthimpl(popupContentSize)) / 2);
                    }
                    int y = (anchorBounds.getTop() - IntSize.m6974getHeightimpl(popupContentSize)) - tooltipAnchorSpacing;
                    if (y < 0) {
                        y = anchorBounds.getBottom() + tooltipAnchorSpacing;
                    }
                    return IntOffsetKt.IntOffset(x, y);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        TooltipDefaults$rememberRichTooltipPositionProvider$1$1 tooltipDefaults$rememberRichTooltipPositionProvider$1$1 = (TooltipDefaults$rememberRichTooltipPositionProvider$1$1) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return tooltipDefaults$rememberRichTooltipPositionProvider$1$1;
    }
}
