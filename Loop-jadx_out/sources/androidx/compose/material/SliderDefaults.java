package androidx.compose.material;

import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.ColorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jv\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, m195d2 = {"Landroidx/compose/material/SliderDefaults;", "", "()V", "DisabledActiveTrackAlpha", "", "DisabledInactiveTrackAlpha", "DisabledTickAlpha", "InactiveTrackAlpha", "TickAlpha", "colors", "Landroidx/compose/material/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "disabledThumbColor", "activeTrackColor", "inactiveTrackColor", "disabledActiveTrackColor", "disabledInactiveTrackColor", "activeTickColor", "inactiveTickColor", "disabledActiveTickColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material/SliderColors;", "material_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final float DisabledActiveTrackAlpha = 0.32f;
    public static final float DisabledInactiveTrackAlpha = 0.12f;
    public static final float DisabledTickAlpha = 0.12f;
    public static final SliderDefaults INSTANCE = new SliderDefaults();
    public static final float InactiveTrackAlpha = 0.24f;
    public static final float TickAlpha = 0.54f;

    private SliderDefaults() {
    }

    /* JADX INFO: renamed from: colors-q0g_0yA, reason: not valid java name */
    public final SliderColors m1785colorsq0g_0yA(long thumbColor, long disabledThumbColor, long activeTrackColor, long inactiveTrackColor, long disabledActiveTrackColor, long disabledInactiveTrackColor, long activeTickColor, long inactiveTickColor, long disabledActiveTickColor, long disabledInactiveTickColor, Composer $composer, int $changed, int $changed1, int i) {
        long disabledThumbColor2;
        long inactiveTrackColor2;
        long disabledActiveTrackColor2;
        long disabledInactiveTrackColor2;
        long activeTickColor2;
        long inactiveTickColor2;
        long disabledActiveTickColor2;
        long disabledInactiveTickColor2;
        ComposerKt.sourceInformationMarkerStart($composer, 436017687, "C(colors)P(9:c#ui.graphics.Color,6:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,7:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color)485@21049L6,486@21115L6,487@21171L8,488@21222L6,489@21287L6,492@21458L6,495@21671L33:Slider.kt#jmzs0o");
        long thumbColor2 = (i & 1) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1627getPrimary0d7_KjU() : thumbColor;
        if ((i & 2) != 0) {
            long jM1626getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1626getOnSurface0d7_KjU();
            disabledThumbColor2 = ColorKt.m4336compositeOverOWjLjI(Color.m4289copywmQWz5c(jM1626getOnSurface0d7_KjU, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM1626getOnSurface0d7_KjU) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(jM1626getOnSurface0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM1626getOnSurface0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM1626getOnSurface0d7_KjU) : 0.0f), MaterialTheme.INSTANCE.getColors($composer, 6).m1631getSurface0d7_KjU());
        } else {
            disabledThumbColor2 = disabledThumbColor;
        }
        long activeTrackColor2 = (i & 4) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1627getPrimary0d7_KjU() : activeTrackColor;
        if ((i & 8) != 0) {
            long j = activeTrackColor2;
            inactiveTrackColor2 = Color.m4289copywmQWz5c(j, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j) : 0.24f, (14 & 2) != 0 ? Color.m4297getRedimpl(j) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j) : 0.0f);
        } else {
            inactiveTrackColor2 = inactiveTrackColor;
        }
        if ((i & 16) != 0) {
            long jM1626getOnSurface0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1626getOnSurface0d7_KjU();
            disabledActiveTrackColor2 = Color.m4289copywmQWz5c(jM1626getOnSurface0d7_KjU2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM1626getOnSurface0d7_KjU2) : 0.32f, (14 & 2) != 0 ? Color.m4297getRedimpl(jM1626getOnSurface0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM1626getOnSurface0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM1626getOnSurface0d7_KjU2) : 0.0f);
        } else {
            disabledActiveTrackColor2 = disabledActiveTrackColor;
        }
        if ((i & 32) != 0) {
            long j2 = disabledActiveTrackColor2;
            disabledInactiveTrackColor2 = Color.m4289copywmQWz5c(j2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j2) : 0.12f, (14 & 2) != 0 ? Color.m4297getRedimpl(j2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j2) : 0.0f);
        } else {
            disabledInactiveTrackColor2 = disabledInactiveTrackColor;
        }
        if ((i & 64) != 0) {
            long jM1645contentColorForek8zF_U = ColorsKt.m1645contentColorForek8zF_U(activeTrackColor2, $composer, ($changed >> 6) & 14);
            activeTickColor2 = Color.m4289copywmQWz5c(jM1645contentColorForek8zF_U, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM1645contentColorForek8zF_U) : 0.54f, (14 & 2) != 0 ? Color.m4297getRedimpl(jM1645contentColorForek8zF_U) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM1645contentColorForek8zF_U) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM1645contentColorForek8zF_U) : 0.0f);
        } else {
            activeTickColor2 = activeTickColor;
        }
        if ((i & 128) != 0) {
            long j3 = activeTrackColor2;
            inactiveTickColor2 = Color.m4289copywmQWz5c(j3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j3) : 0.54f, (14 & 2) != 0 ? Color.m4297getRedimpl(j3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j3) : 0.0f);
        } else {
            inactiveTickColor2 = inactiveTickColor;
        }
        if ((i & 256) != 0) {
            long j4 = activeTickColor2;
            disabledActiveTickColor2 = Color.m4289copywmQWz5c(j4, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j4) : 0.12f, (14 & 2) != 0 ? Color.m4297getRedimpl(j4) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j4) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j4) : 0.0f);
        } else {
            disabledActiveTickColor2 = disabledActiveTickColor;
        }
        if ((i & 512) != 0) {
            long j5 = disabledInactiveTrackColor2;
            disabledInactiveTickColor2 = Color.m4289copywmQWz5c(j5, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j5) : 0.12f, (14 & 2) != 0 ? Color.m4297getRedimpl(j5) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j5) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j5) : 0.0f);
        } else {
            disabledInactiveTickColor2 = disabledInactiveTickColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(436017687, $changed, $changed1, "androidx.compose.material.SliderDefaults.colors (Slider.kt:500)");
        }
        DefaultSliderColors defaultSliderColors = new DefaultSliderColors(thumbColor2, disabledThumbColor2, activeTrackColor2, inactiveTrackColor2, disabledActiveTrackColor2, disabledInactiveTrackColor2, activeTickColor2, inactiveTickColor2, disabledActiveTickColor2, disabledInactiveTickColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultSliderColors;
    }
}
