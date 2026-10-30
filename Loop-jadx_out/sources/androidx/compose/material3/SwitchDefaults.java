package androidx.compose.material3;

import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.ColorKt;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: Switch.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\r\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000eJ²\u0001\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u00102\b\b\u0002\u0010\u001d\u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u00020\t*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, m195d2 = {"Landroidx/compose/material3/SwitchDefaults;", "", "()V", "IconSize", "Landroidx/compose/ui/unit/Dp;", "getIconSize-D9Ej5fM", "()F", "F", "defaultSwitchColors", "Landroidx/compose/material3/SwitchColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSwitchColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SwitchColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "colors-V1nXRL4", "(JJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SwitchColors;", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SwitchDefaults {
    public static final int $stable = 0;
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();
    private static final float IconSize = C1979Dp.m6801constructorimpl(16);

    private SwitchDefaults() {
    }

    public final SwitchColors colors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 435552781, "C(colors)271@10250L11:Switch.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(435552781, $changed, -1, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:271)");
        }
        SwitchColors defaultSwitchColors$material3_release = getDefaultSwitchColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultSwitchColors$material3_release;
    }

    /* JADX INFO: renamed from: colors-V1nXRL4, reason: not valid java name */
    public final SwitchColors m2698colorsV1nXRL4(long checkedThumbColor, long checkedTrackColor, long checkedBorderColor, long checkedIconColor, long uncheckedThumbColor, long uncheckedTrackColor, long uncheckedBorderColor, long uncheckedIconColor, long disabledCheckedThumbColor, long disabledCheckedTrackColor, long disabledCheckedBorderColor, long disabledCheckedIconColor, long disabledUncheckedThumbColor, long disabledUncheckedTrackColor, long disabledUncheckedBorderColor, long disabledUncheckedIconColor, Composer $composer, int $changed, int $changed1, int i) {
        long disabledCheckedThumbColor2;
        long disabledCheckedTrackColor2;
        long disabledCheckedIconColor2;
        long disabledUncheckedThumbColor2;
        long disabledUncheckedTrackColor2;
        long disabledUncheckedBorderColor2;
        long disabledUncheckedIconColor2;
        ComposerKt.sourceInformationMarkerStart($composer, 1937926421, "C(colors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,14:c#ui.graphics.Color,15:c#ui.graphics.Color,12:c#ui.graphics.Color,13:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color,8:c#ui.graphics.Color,9:c#ui.graphics.Color)296@12002L5,297@12076L5,299@12203L5,300@12282L5,301@12360L5,302@12451L5,303@12527L5,304@12618L5,306@12735L11,307@12840L5,309@12948L11,311@13114L5,313@13229L11,314@13339L5,316@13458L11,317@13567L5,319@13675L11,321@13804L5,323@13920L11,324@14027L5,326@14144L11:Switch.kt#uh7d8r");
        long checkedThumbColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedHandleColor(), $composer, 6) : checkedThumbColor;
        long checkedTrackColor2 = (i & 2) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedTrackColor(), $composer, 6) : checkedTrackColor;
        long checkedBorderColor2 = (i & 4) != 0 ? Color.INSTANCE.m4326getTransparent0d7_KjU() : checkedBorderColor;
        long checkedIconColor2 = (i & 8) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedIconColor(), $composer, 6) : checkedIconColor;
        long uncheckedThumbColor2 = (i & 16) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedHandleColor(), $composer, 6) : uncheckedThumbColor;
        long uncheckedTrackColor2 = (i & 32) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedTrackColor(), $composer, 6) : uncheckedTrackColor;
        long uncheckedBorderColor2 = (i & 64) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor(), $composer, 6) : uncheckedBorderColor;
        long uncheckedIconColor2 = (i & 128) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedIconColor(), $composer, 6) : uncheckedIconColor;
        if ((i & 256) != 0) {
            long value = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedHandleColor(), $composer, 6);
            disabledCheckedThumbColor2 = ColorKt.m4336compositeOverOWjLjI(Color.m4289copywmQWz5c(value, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value) : SwitchTokens.INSTANCE.getDisabledSelectedHandleOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value) : 0.0f), MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface());
        } else {
            disabledCheckedThumbColor2 = disabledCheckedThumbColor;
        }
        if ((i & 512) != 0) {
            long value2 = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedTrackColor(), $composer, 6);
            disabledCheckedTrackColor2 = ColorKt.m4336compositeOverOWjLjI(Color.m4289copywmQWz5c(value2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value2) : SwitchTokens.INSTANCE.getDisabledTrackOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value2) : 0.0f), MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface());
        } else {
            disabledCheckedTrackColor2 = disabledCheckedTrackColor;
        }
        long disabledCheckedBorderColor2 = (i & 1024) != 0 ? Color.INSTANCE.m4326getTransparent0d7_KjU() : disabledCheckedBorderColor;
        if ((i & 2048) != 0) {
            long value3 = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedIconColor(), $composer, 6);
            disabledCheckedIconColor2 = ColorKt.m4336compositeOverOWjLjI(Color.m4289copywmQWz5c(value3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value3) : SwitchTokens.INSTANCE.getDisabledSelectedIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value3) : 0.0f), MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface());
        } else {
            disabledCheckedIconColor2 = disabledCheckedIconColor;
        }
        if ((i & 4096) != 0) {
            long value4 = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedHandleColor(), $composer, 6);
            disabledUncheckedThumbColor2 = ColorKt.m4336compositeOverOWjLjI(Color.m4289copywmQWz5c(value4, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value4) : SwitchTokens.INSTANCE.getDisabledUnselectedHandleOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value4) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value4) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value4) : 0.0f), MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface());
        } else {
            disabledUncheckedThumbColor2 = disabledUncheckedThumbColor;
        }
        if ((i & 8192) != 0) {
            long value5 = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedTrackColor(), $composer, 6);
            disabledUncheckedTrackColor2 = ColorKt.m4336compositeOverOWjLjI(Color.m4289copywmQWz5c(value5, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value5) : SwitchTokens.INSTANCE.getDisabledTrackOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value5) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value5) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value5) : 0.0f), MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface());
        } else {
            disabledUncheckedTrackColor2 = disabledUncheckedTrackColor;
        }
        if ((i & 16384) != 0) {
            long value6 = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedTrackOutlineColor(), $composer, 6);
            disabledUncheckedBorderColor2 = ColorKt.m4336compositeOverOWjLjI(Color.m4289copywmQWz5c(value6, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value6) : SwitchTokens.INSTANCE.getDisabledTrackOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value6) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value6) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value6) : 0.0f), MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface());
        } else {
            disabledUncheckedBorderColor2 = disabledUncheckedBorderColor;
        }
        if ((i & 32768) != 0) {
            long value7 = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedIconColor(), $composer, 6);
            disabledUncheckedIconColor2 = ColorKt.m4336compositeOverOWjLjI(Color.m4289copywmQWz5c(value7, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value7) : SwitchTokens.INSTANCE.getDisabledUnselectedIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value7) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value7) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value7) : 0.0f), MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface());
        } else {
            disabledUncheckedIconColor2 = disabledUncheckedIconColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1937926421, $changed, $changed1, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:327)");
        }
        SwitchColors switchColors = new SwitchColors(checkedThumbColor2, checkedTrackColor2, checkedBorderColor2, checkedIconColor2, uncheckedThumbColor2, uncheckedTrackColor2, uncheckedBorderColor2, uncheckedIconColor2, disabledCheckedThumbColor2, disabledCheckedTrackColor2, disabledCheckedBorderColor2, disabledCheckedIconColor2, disabledUncheckedThumbColor2, disabledUncheckedTrackColor2, disabledUncheckedBorderColor2, disabledUncheckedIconColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return switchColors;
    }

    public final SwitchColors getDefaultSwitchColors$material3_release(ColorScheme $this$defaultSwitchColors) {
        SwitchColors defaultSwitchColorsCached = $this$defaultSwitchColors.getDefaultSwitchColorsCached();
        if (defaultSwitchColorsCached == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getSelectedHandleColor());
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getSelectedTrackColor());
            long jM4326getTransparent0d7_KjU = Color.INSTANCE.m4326getTransparent0d7_KjU();
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getSelectedIconColor());
            long jFromToken4 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getUnselectedHandleColor());
            long jFromToken5 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getUnselectedTrackColor());
            long jFromToken6 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor());
            long jFromToken7 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getUnselectedIconColor());
            long jFromToken8 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getDisabledSelectedHandleColor());
            long jM4336compositeOverOWjLjI = ColorKt.m4336compositeOverOWjLjI(Color.m4289copywmQWz5c(jFromToken8, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken8) : SwitchTokens.INSTANCE.getDisabledSelectedHandleOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken8) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken8) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken8) : 0.0f), $this$defaultSwitchColors.getSurface());
            long jFromToken9 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getDisabledSelectedTrackColor());
            long jM4336compositeOverOWjLjI2 = ColorKt.m4336compositeOverOWjLjI(Color.m4289copywmQWz5c(jFromToken9, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken9) : SwitchTokens.INSTANCE.getDisabledTrackOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken9) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken9) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken9) : 0.0f), $this$defaultSwitchColors.getSurface());
            long jM4326getTransparent0d7_KjU2 = Color.INSTANCE.m4326getTransparent0d7_KjU();
            long jFromToken10 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getDisabledSelectedIconColor());
            long jM4336compositeOverOWjLjI3 = ColorKt.m4336compositeOverOWjLjI(Color.m4289copywmQWz5c(jFromToken10, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken10) : SwitchTokens.INSTANCE.getDisabledSelectedIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken10) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken10) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken10) : 0.0f), $this$defaultSwitchColors.getSurface());
            long jFromToken11 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getDisabledUnselectedHandleColor());
            long jM4336compositeOverOWjLjI4 = ColorKt.m4336compositeOverOWjLjI(Color.m4289copywmQWz5c(jFromToken11, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken11) : SwitchTokens.INSTANCE.getDisabledUnselectedHandleOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken11) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken11) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken11) : 0.0f), $this$defaultSwitchColors.getSurface());
            long jFromToken12 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getDisabledUnselectedTrackColor());
            long jM4336compositeOverOWjLjI5 = ColorKt.m4336compositeOverOWjLjI(Color.m4289copywmQWz5c(jFromToken12, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken12) : SwitchTokens.INSTANCE.getDisabledTrackOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken12) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken12) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken12) : 0.0f), $this$defaultSwitchColors.getSurface());
            long jFromToken13 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getDisabledUnselectedTrackOutlineColor());
            long jM4336compositeOverOWjLjI6 = ColorKt.m4336compositeOverOWjLjI(Color.m4289copywmQWz5c(jFromToken13, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken13) : SwitchTokens.INSTANCE.getDisabledTrackOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken13) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken13) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken13) : 0.0f), $this$defaultSwitchColors.getSurface());
            long jFromToken14 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getDisabledUnselectedIconColor());
            SwitchColors it = new SwitchColors(jFromToken, jFromToken2, jM4326getTransparent0d7_KjU, jFromToken3, jFromToken4, jFromToken5, jFromToken6, jFromToken7, jM4336compositeOverOWjLjI, jM4336compositeOverOWjLjI2, jM4326getTransparent0d7_KjU2, jM4336compositeOverOWjLjI3, jM4336compositeOverOWjLjI4, jM4336compositeOverOWjLjI5, jM4336compositeOverOWjLjI6, ColorKt.m4336compositeOverOWjLjI(Color.m4289copywmQWz5c(jFromToken14, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken14) : SwitchTokens.INSTANCE.getDisabledUnselectedIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken14) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken14) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken14) : 0.0f), $this$defaultSwitchColors.getSurface()), null);
            $this$defaultSwitchColors.setDefaultSwitchColorsCached$material3_release(it);
            return it;
        }
        return defaultSwitchColorsCached;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2699getIconSizeD9Ej5fM() {
        return IconSize;
    }
}
