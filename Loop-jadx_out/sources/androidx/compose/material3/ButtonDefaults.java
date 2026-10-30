package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.ElevatedButtonTokens;
import androidx.compose.material3.tokens.FilledButtonTokens;
import androidx.compose.material3.tokens.FilledTonalButtonTokens;
import androidx.compose.material3.tokens.OutlinedButtonTokens;
import androidx.compose.material3.tokens.TextButtonTokens;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010:\u001a\u00020.H\u0007¢\u0006\u0002\u0010;J:\u0010:\u001a\u00020.2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020=H\u0007ø\u0001\u0000¢\u0006\u0004\bA\u0010BJD\u0010C\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020\u00042\b\b\u0002\u0010F\u001a\u00020\u00042\b\b\u0002\u0010G\u001a\u00020\u00042\b\b\u0002\u0010H\u001a\u00020\u00042\b\b\u0002\u0010I\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ\r\u0010L\u001a\u00020.H\u0007¢\u0006\u0002\u0010;J:\u0010L\u001a\u00020.2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020=H\u0007ø\u0001\u0000¢\u0006\u0004\bM\u0010BJD\u0010N\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020\u00042\b\b\u0002\u0010F\u001a\u00020\u00042\b\b\u0002\u0010G\u001a\u00020\u00042\b\b\u0002\u0010H\u001a\u00020\u00042\b\b\u0002\u0010I\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\bO\u0010KJ\r\u0010P\u001a\u00020.H\u0007¢\u0006\u0002\u0010;J:\u0010P\u001a\u00020.2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020=H\u0007ø\u0001\u0000¢\u0006\u0004\bQ\u0010BJD\u0010R\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020\u00042\b\b\u0002\u0010F\u001a\u00020\u00042\b\b\u0002\u0010G\u001a\u00020\u00042\b\b\u0002\u0010H\u001a\u00020\u00042\b\b\u0002\u0010I\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\bS\u0010KJ\r\u0010T\u001a\u00020.H\u0007¢\u0006\u0002\u0010;J:\u0010T\u001a\u00020.2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020=H\u0007ø\u0001\u0000¢\u0006\u0004\bU\u0010BJ\r\u0010V\u001a\u00020.H\u0007¢\u0006\u0002\u0010;J:\u0010V\u001a\u00020.2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020=H\u0007ø\u0001\u0000¢\u0006\u0004\bW\u0010BR\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\u0010R\u0019\u0010\u0013\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0014\u0010\u0010R\u0019\u0010\u0015\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0016\u0010\u0019\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u001a\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\nR\u0016\u0010\u001c\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u001d\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0011\u0010#\u001a\u00020$8G¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b(\u0010 R\u0011\u0010)\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b*\u0010 R\u0011\u0010+\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b,\u0010 R\u0018\u0010-\u001a\u00020.*\u00020/8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0018\u00102\u001a\u00020.*\u00020/8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b3\u00101R\u0018\u00104\u001a\u00020.*\u00020/8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u00101R\u0018\u00106\u001a\u00020.*\u00020/8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b7\u00101R\u0018\u00108\u001a\u00020.*\u00020/8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b9\u00101\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006X"}, m195d2 = {"Landroidx/compose/material3/ButtonDefaults;", "", "()V", "ButtonHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonVerticalPadding", "ButtonWithIconContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getButtonWithIconContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "ButtonWithIconHorizontalStartPadding", "ContentPadding", "getContentPadding", "IconSize", "getIconSize-D9Ej5fM", "()F", "IconSpacing", "getIconSpacing-D9Ej5fM", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "TextButtonContentPadding", "getTextButtonContentPadding", "TextButtonHorizontalPadding", "TextButtonWithIconContentPadding", "getTextButtonWithIconContentPadding", "TextButtonWithIconHorizontalEndPadding", "elevatedShape", "Landroidx/compose/ui/graphics/Shape;", "getElevatedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "filledTonalShape", "getFilledTonalShape", "outlinedButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedButtonBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedShape", "getOutlinedShape", "shape", "getShape", "textShape", "getTextShape", "defaultButtonColors", "Landroidx/compose/material3/ButtonColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultButtonColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ButtonColors;", "defaultElevatedButtonColors", "getDefaultElevatedButtonColors$material3_release", "defaultFilledTonalButtonColors", "getDefaultFilledTonalButtonColors$material3_release", "defaultOutlinedButtonColors", "getDefaultOutlinedButtonColors$material3_release", "defaultTextButtonColors", "getDefaultTextButtonColors$material3_release", "buttonColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonColors;", "buttonElevation", "Landroidx/compose/material3/ButtonElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "buttonElevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonElevation;", "elevatedButtonColors", "elevatedButtonColors-ro_MJ88", "elevatedButtonElevation", "elevatedButtonElevation-R_JCAzs", "filledTonalButtonColors", "filledTonalButtonColors-ro_MJ88", "filledTonalButtonElevation", "filledTonalButtonElevation-R_JCAzs", "outlinedButtonColors", "outlinedButtonColors-ro_MJ88", "textButtonColors", "textButtonColors-ro_MJ88", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ButtonDefaults {
    public static final int $stable = 0;
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float ButtonHorizontalPadding = C1979Dp.m6801constructorimpl(24);
    private static final float ButtonVerticalPadding = C1979Dp.m6801constructorimpl(8);
    private static final PaddingValues ContentPadding = PaddingKt.m864PaddingValuesa9UjIt4(ButtonHorizontalPadding, ButtonVerticalPadding, ButtonHorizontalPadding, ButtonVerticalPadding);
    private static final float ButtonWithIconHorizontalStartPadding = C1979Dp.m6801constructorimpl(16);
    private static final PaddingValues ButtonWithIconContentPadding = PaddingKt.m864PaddingValuesa9UjIt4(ButtonWithIconHorizontalStartPadding, ButtonVerticalPadding, ButtonHorizontalPadding, ButtonVerticalPadding);
    private static final float TextButtonHorizontalPadding = C1979Dp.m6801constructorimpl(12);
    private static final PaddingValues TextButtonContentPadding = PaddingKt.m864PaddingValuesa9UjIt4(TextButtonHorizontalPadding, ContentPadding.getTop(), TextButtonHorizontalPadding, ContentPadding.getBottom());
    private static final float TextButtonWithIconHorizontalEndPadding = C1979Dp.m6801constructorimpl(16);
    private static final PaddingValues TextButtonWithIconContentPadding = PaddingKt.m864PaddingValuesa9UjIt4(TextButtonHorizontalPadding, ContentPadding.getTop(), TextButtonWithIconHorizontalEndPadding, ContentPadding.getBottom());
    private static final float MinWidth = C1979Dp.m6801constructorimpl(58);
    private static final float MinHeight = C1979Dp.m6801constructorimpl(40);
    private static final float IconSize = FilledButtonTokens.INSTANCE.m3345getIconSizeD9Ej5fM();
    private static final float IconSpacing = C1979Dp.m6801constructorimpl(8);

    private ButtonDefaults() {
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    public final PaddingValues getButtonWithIconContentPadding() {
        return ButtonWithIconContentPadding;
    }

    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    public final PaddingValues getTextButtonWithIconContentPadding() {
        return TextButtonWithIconContentPadding;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m1968getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1967getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1965getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* JADX INFO: renamed from: getIconSpacing-D9Ej5fM, reason: not valid java name */
    public final float m1966getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1234923021, "C533@25320L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1234923021, $changed, -1, "androidx.compose.material3.ButtonDefaults.<get-shape> (Button.kt:533)");
        }
        Shape value = ShapesKt.getValue(FilledButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final Shape getElevatedShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 2143958791, "C536@25461L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2143958791, $changed, -1, "androidx.compose.material3.ButtonDefaults.<get-elevatedShape> (Button.kt:536)");
        }
        Shape value = ShapesKt.getValue(ElevatedButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final Shape getFilledTonalShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -886584987, "C539@25611L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-886584987, $changed, -1, "androidx.compose.material3.ButtonDefaults.<get-filledTonalShape> (Button.kt:539)");
        }
        Shape value = ShapesKt.getValue(FilledTonalButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final Shape getOutlinedShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -2045213065, "C542@25752L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2045213065, $changed, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedShape> (Button.kt:542)");
        }
        Shape value = ShapesKt.getValue(OutlinedButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final Shape getTextShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -349121587, "C545@25880L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-349121587, $changed, -1, "androidx.compose.material3.ButtonDefaults.<get-textShape> (Button.kt:545)");
        }
        Shape value = ShapesKt.getValue(TextButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final ButtonColors buttonColors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1449248637, "C(buttonColors)552@26074L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1449248637, $changed, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:552)");
        }
        ButtonColors defaultButtonColors$material3_release = getDefaultButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultButtonColors$material3_release;
    }

    /* JADX INFO: renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m1959buttonColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -339300779, "C(buttonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)569@26872L11:Button.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : containerColor;
        long contentColor2 = (i & 2) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : contentColor;
        long disabledContainerColor2 = (i & 4) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContainerColor;
        long disabledContentColor2 = (i & 8) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-339300779, $changed, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:569)");
        }
        ButtonColors buttonColorsM1954copyjRlVdoo = getDefaultButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6)).m1954copyjRlVdoo(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return buttonColorsM1954copyjRlVdoo;
    }

    public final ButtonColors getDefaultButtonColors$material3_release(ColorScheme $this$defaultButtonColors) {
        ButtonColors defaultButtonColorsCached = $this$defaultButtonColors.getDefaultButtonColorsCached();
        if (defaultButtonColorsCached == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultButtonColors, FilledButtonTokens.INSTANCE.getContainerColor());
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultButtonColors, FilledButtonTokens.INSTANCE.getLabelTextColor());
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultButtonColors, FilledButtonTokens.INSTANCE.getDisabledContainerColor());
            long jM4289copywmQWz5c = Color.m4289copywmQWz5c(jFromToken3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken3) : 0.12f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken3) : 0.0f);
            long jFromToken4 = ColorSchemeKt.fromToken($this$defaultButtonColors, FilledButtonTokens.INSTANCE.getDisabledLabelTextColor());
            ButtonColors it = new ButtonColors(jFromToken, jFromToken2, jM4289copywmQWz5c, Color.m4289copywmQWz5c(jFromToken4, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken4) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken4) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken4) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken4) : 0.0f), null);
            $this$defaultButtonColors.setDefaultButtonColorsCached$material3_release(it);
            return it;
        }
        return defaultButtonColorsCached;
    }

    public final ButtonColors elevatedButtonColors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 2025043443, "C(elevatedButtonColors)595@28043L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2025043443, $changed, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonColors (Button.kt:595)");
        }
        ButtonColors defaultElevatedButtonColors$material3_release = getDefaultElevatedButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultElevatedButtonColors$material3_release;
    }

    /* JADX INFO: renamed from: elevatedButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m1961elevatedButtonColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 1507908383, "C(elevatedButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)612@28890L11:Button.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : containerColor;
        long contentColor2 = (i & 2) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : contentColor;
        long disabledContainerColor2 = (i & 4) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContainerColor;
        long disabledContentColor2 = (i & 8) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1507908383, $changed, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonColors (Button.kt:612)");
        }
        ButtonColors buttonColorsM1954copyjRlVdoo = getDefaultElevatedButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6)).m1954copyjRlVdoo(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return buttonColorsM1954copyjRlVdoo;
    }

    public final ButtonColors getDefaultElevatedButtonColors$material3_release(ColorScheme $this$defaultElevatedButtonColors) {
        ButtonColors defaultElevatedButtonColorsCached = $this$defaultElevatedButtonColors.getDefaultElevatedButtonColorsCached();
        if (defaultElevatedButtonColorsCached == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultElevatedButtonColors, ElevatedButtonTokens.INSTANCE.getContainerColor());
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultElevatedButtonColors, ElevatedButtonTokens.INSTANCE.getLabelTextColor());
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultElevatedButtonColors, ElevatedButtonTokens.INSTANCE.getDisabledContainerColor());
            long jM4289copywmQWz5c = Color.m4289copywmQWz5c(jFromToken3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken3) : ElevatedButtonTokens.INSTANCE.getDisabledContainerOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken3) : 0.0f);
            long jFromToken4 = ColorSchemeKt.fromToken($this$defaultElevatedButtonColors, ElevatedButtonTokens.INSTANCE.getDisabledLabelTextColor());
            ButtonColors it = new ButtonColors(jFromToken, jFromToken2, jM4289copywmQWz5c, Color.m4289copywmQWz5c(jFromToken4, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken4) : ElevatedButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken4) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken4) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken4) : 0.0f), null);
            $this$defaultElevatedButtonColors.setDefaultElevatedButtonColorsCached$material3_release(it);
            return it;
        }
        return defaultElevatedButtonColorsCached;
    }

    public final ButtonColors filledTonalButtonColors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 824987837, "C(filledTonalButtonColors)638@30111L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(824987837, $changed, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonColors (Button.kt:638)");
        }
        ButtonColors defaultFilledTonalButtonColors$material3_release = getDefaultFilledTonalButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultFilledTonalButtonColors$material3_release;
    }

    /* JADX INFO: renamed from: filledTonalButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m1963filledTonalButtonColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 1670757653, "C(filledTonalButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)655@30983L11:Button.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : containerColor;
        long contentColor2 = (i & 2) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : contentColor;
        long disabledContainerColor2 = (i & 4) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContainerColor;
        long disabledContentColor2 = (i & 8) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1670757653, $changed, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonColors (Button.kt:655)");
        }
        ButtonColors buttonColorsM1954copyjRlVdoo = getDefaultFilledTonalButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6)).m1954copyjRlVdoo(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return buttonColorsM1954copyjRlVdoo;
    }

    public final ButtonColors getDefaultFilledTonalButtonColors$material3_release(ColorScheme $this$defaultFilledTonalButtonColors) {
        ButtonColors defaultFilledTonalButtonColorsCached = $this$defaultFilledTonalButtonColors.getDefaultFilledTonalButtonColorsCached();
        if (defaultFilledTonalButtonColorsCached == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultFilledTonalButtonColors, FilledTonalButtonTokens.INSTANCE.getContainerColor());
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultFilledTonalButtonColors, FilledTonalButtonTokens.INSTANCE.getLabelTextColor());
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultFilledTonalButtonColors, FilledTonalButtonTokens.INSTANCE.getDisabledContainerColor());
            long jM4289copywmQWz5c = Color.m4289copywmQWz5c(jFromToken3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken3) : 0.12f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken3) : 0.0f);
            long jFromToken4 = ColorSchemeKt.fromToken($this$defaultFilledTonalButtonColors, FilledTonalButtonTokens.INSTANCE.getDisabledLabelTextColor());
            ButtonColors it = new ButtonColors(jFromToken, jFromToken2, jM4289copywmQWz5c, Color.m4289copywmQWz5c(jFromToken4, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken4) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken4) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken4) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken4) : 0.0f), null);
            $this$defaultFilledTonalButtonColors.setDefaultFilledTonalButtonColorsCached$material3_release(it);
            return it;
        }
        return defaultFilledTonalButtonColorsCached;
    }

    public final ButtonColors outlinedButtonColors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1344886725, "C(outlinedButtonColors)681@32228L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1344886725, $changed, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonColors (Button.kt:681)");
        }
        ButtonColors defaultOutlinedButtonColors$material3_release = getDefaultOutlinedButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultOutlinedButtonColors$material3_release;
    }

    /* JADX INFO: renamed from: outlinedButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m1969outlinedButtonColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -1778526249, "C(outlinedButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)698@33079L11:Button.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : containerColor;
        long contentColor2 = (i & 2) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : contentColor;
        long disabledContainerColor2 = (i & 4) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContainerColor;
        long disabledContentColor2 = (i & 8) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1778526249, $changed, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonColors (Button.kt:698)");
        }
        ButtonColors buttonColorsM1954copyjRlVdoo = getDefaultOutlinedButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6)).m1954copyjRlVdoo(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return buttonColorsM1954copyjRlVdoo;
    }

    public final ButtonColors getDefaultOutlinedButtonColors$material3_release(ColorScheme $this$defaultOutlinedButtonColors) {
        ButtonColors defaultOutlinedButtonColorsCached = $this$defaultOutlinedButtonColors.getDefaultOutlinedButtonColorsCached();
        if (defaultOutlinedButtonColorsCached != null) {
            return defaultOutlinedButtonColorsCached;
        }
        long jM4326getTransparent0d7_KjU = Color.INSTANCE.m4326getTransparent0d7_KjU();
        long jFromToken = ColorSchemeKt.fromToken($this$defaultOutlinedButtonColors, OutlinedButtonTokens.INSTANCE.getLabelTextColor());
        long jM4326getTransparent0d7_KjU2 = Color.INSTANCE.m4326getTransparent0d7_KjU();
        long jFromToken2 = ColorSchemeKt.fromToken($this$defaultOutlinedButtonColors, OutlinedButtonTokens.INSTANCE.getDisabledLabelTextColor());
        ButtonColors it = new ButtonColors(jM4326getTransparent0d7_KjU, jFromToken, jM4326getTransparent0d7_KjU2, Color.m4289copywmQWz5c(jFromToken2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken2) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken2) : 0.0f), null);
        $this$defaultOutlinedButtonColors.setDefaultOutlinedButtonColorsCached$material3_release(it);
        return it;
    }

    public final ButtonColors textButtonColors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1880341584, "C(textButtonColors)723@34138L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1880341584, $changed, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:723)");
        }
        ButtonColors defaultTextButtonColors$material3_release = getDefaultTextButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultTextButtonColors$material3_release;
    }

    /* JADX INFO: renamed from: textButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m1970textButtonColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -1402274782, "C(textButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)740@34956L11:Button.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : containerColor;
        long contentColor2 = (i & 2) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : contentColor;
        long disabledContainerColor2 = (i & 4) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContainerColor;
        long disabledContentColor2 = (i & 8) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1402274782, $changed, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:740)");
        }
        ButtonColors buttonColorsM1954copyjRlVdoo = getDefaultTextButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6)).m1954copyjRlVdoo(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return buttonColorsM1954copyjRlVdoo;
    }

    public final ButtonColors getDefaultTextButtonColors$material3_release(ColorScheme $this$defaultTextButtonColors) {
        ButtonColors defaultTextButtonColorsCached = $this$defaultTextButtonColors.getDefaultTextButtonColorsCached();
        if (defaultTextButtonColorsCached != null) {
            return defaultTextButtonColorsCached;
        }
        long jM4326getTransparent0d7_KjU = Color.INSTANCE.m4326getTransparent0d7_KjU();
        long jFromToken = ColorSchemeKt.fromToken($this$defaultTextButtonColors, TextButtonTokens.INSTANCE.getLabelTextColor());
        long jM4326getTransparent0d7_KjU2 = Color.INSTANCE.m4326getTransparent0d7_KjU();
        long jFromToken2 = ColorSchemeKt.fromToken($this$defaultTextButtonColors, TextButtonTokens.INSTANCE.getDisabledLabelTextColor());
        ButtonColors it = new ButtonColors(jM4326getTransparent0d7_KjU, jFromToken, jM4326getTransparent0d7_KjU2, Color.m4289copywmQWz5c(jFromToken2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken2) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken2) : 0.0f), null);
        $this$defaultTextButtonColors.setDefaultTextButtonColorsCached$material3_release(it);
        return it;
    }

    /* JADX INFO: renamed from: buttonElevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m1960buttonElevationR_JCAzs(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 1827791191, "C(buttonElevation)P(0:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,3:c#ui.unit.Dp,1:c#ui.unit.Dp):Button.kt#uh7d8r");
        float defaultElevation2 = (i & 1) != 0 ? FilledButtonTokens.INSTANCE.m3340getContainerElevationD9Ej5fM() : defaultElevation;
        float pressedElevation2 = (i & 2) != 0 ? FilledButtonTokens.INSTANCE.m3346getPressedContainerElevationD9Ej5fM() : pressedElevation;
        float focusedElevation2 = (i & 4) != 0 ? FilledButtonTokens.INSTANCE.m3343getFocusContainerElevationD9Ej5fM() : focusedElevation;
        float hoveredElevation2 = (i & 8) != 0 ? FilledButtonTokens.INSTANCE.m3344getHoverContainerElevationD9Ej5fM() : hoveredElevation;
        float disabledElevation2 = (i & 16) != 0 ? FilledButtonTokens.INSTANCE.m3342getDisabledContainerElevationD9Ej5fM() : disabledElevation;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1827791191, $changed, -1, "androidx.compose.material3.ButtonDefaults.buttonElevation (Button.kt:778)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(defaultElevation2, pressedElevation2, focusedElevation2, hoveredElevation2, disabledElevation2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return buttonElevation;
    }

    /* JADX INFO: renamed from: elevatedButtonElevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m1962elevatedButtonElevationR_JCAzs(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 1065482445, "C(elevatedButtonElevation)P(0:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,3:c#ui.unit.Dp,1:c#ui.unit.Dp):Button.kt#uh7d8r");
        float defaultElevation2 = (i & 1) != 0 ? ElevatedButtonTokens.INSTANCE.m3259getContainerElevationD9Ej5fM() : defaultElevation;
        float pressedElevation2 = (i & 2) != 0 ? ElevatedButtonTokens.INSTANCE.m3265getPressedContainerElevationD9Ej5fM() : pressedElevation;
        float focusedElevation2 = (i & 4) != 0 ? ElevatedButtonTokens.INSTANCE.m3262getFocusContainerElevationD9Ej5fM() : focusedElevation;
        float hoveredElevation2 = (i & 8) != 0 ? ElevatedButtonTokens.INSTANCE.m3263getHoverContainerElevationD9Ej5fM() : hoveredElevation;
        float disabledElevation2 = (i & 16) != 0 ? ElevatedButtonTokens.INSTANCE.m3261getDisabledContainerElevationD9Ej5fM() : disabledElevation;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1065482445, $changed, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonElevation (Button.kt:804)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(defaultElevation2, pressedElevation2, focusedElevation2, hoveredElevation2, disabledElevation2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return buttonElevation;
    }

    /* JADX INFO: renamed from: filledTonalButtonElevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m1964filledTonalButtonElevationR_JCAzs(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 5982871, "C(filledTonalButtonElevation)P(0:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,3:c#ui.unit.Dp,1:c#ui.unit.Dp):Button.kt#uh7d8r");
        float defaultElevation2 = (i & 1) != 0 ? FilledTonalButtonTokens.INSTANCE.m3363getContainerElevationD9Ej5fM() : defaultElevation;
        float pressedElevation2 = (i & 2) != 0 ? FilledTonalButtonTokens.INSTANCE.m3369getPressedContainerElevationD9Ej5fM() : pressedElevation;
        float focusedElevation2 = (i & 4) != 0 ? FilledTonalButtonTokens.INSTANCE.m3366getFocusContainerElevationD9Ej5fM() : focusedElevation;
        float hoveredElevation2 = (i & 8) != 0 ? FilledTonalButtonTokens.INSTANCE.m3367getHoverContainerElevationD9Ej5fM() : hoveredElevation;
        float disabledElevation2 = (i & 16) != 0 ? C1979Dp.m6801constructorimpl(0) : disabledElevation;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(5982871, $changed, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonElevation (Button.kt:831)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(defaultElevation2, pressedElevation2, focusedElevation2, hoveredElevation2, disabledElevation2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return buttonElevation;
    }

    public final BorderStroke getOutlinedButtonBorder(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -563957672, "C844@40209L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-563957672, $changed, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedButtonBorder> (Button.kt:842)");
        }
        BorderStroke borderStrokeM481BorderStrokecXLIe8U = BorderStrokeKt.m481BorderStrokecXLIe8U(OutlinedButtonTokens.INSTANCE.m3445getOutlineWidthD9Ej5fM(), ColorSchemeKt.getValue(OutlinedButtonTokens.INSTANCE.getOutlineColor(), $composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return borderStrokeM481BorderStrokecXLIe8U;
    }
}
