package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.RotateKt;
import androidx.compose.p001ui.geometry.CornerRadiusKt;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.geometry.RectKt;
import androidx.compose.p001ui.geometry.RoundRect;
import androidx.compose.p001ui.geometry.RoundRectKt;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.AndroidPath_androidKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.ColorKt;
import androidx.compose.p001ui.graphics.Path;
import androidx.compose.p001ui.graphics.PointMode;
import androidx.compose.p001ui.graphics.StrokeCap;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.DpSize;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0014\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J3\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u001cJo\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0012\u001a\u00020\b2!\b\u0002\u0010\u001d\u001a\u001b\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r\u0018\u00010\u001e¢\u0006\u0002\b!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&J3\u0010\u0019\u001a\u00020\r2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010)J3\u0010\u0019\u001a\u00020\r2\u0006\u0010*\u001a\u00020+2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010,Jo\u0010\u0019\u001a\u00020\r2\u0006\u0010*\u001a\u00020+2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0012\u001a\u00020\b2!\b\u0002\u0010\u001d\u001a\u001b\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r\u0018\u00010\u001e¢\u0006\u0002\b!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010-J4\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020 2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u00020\u0014H\u0002ø\u0001\u0000¢\u0006\u0004\b5\u00106J\r\u0010\u0012\u001a\u00020\bH\u0007¢\u0006\u0002\u00107Jv\u0010\u0012\u001a\u00020\b2\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u0002092\b\b\u0002\u0010;\u001a\u0002092\b\b\u0002\u0010<\u001a\u0002092\b\b\u0002\u0010=\u001a\u0002092\b\b\u0002\u0010>\u001a\u0002092\b\b\u0002\u0010?\u001a\u0002092\b\b\u0002\u0010@\u001a\u0002092\b\b\u0002\u0010A\u001a\u0002092\b\b\u0002\u0010B\u001a\u000209H\u0007ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ.\u0010\u001d\u001a\u00020\r*\u00020\u001f2\u0006\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020#2\u0006\u0010E\u001a\u000209H\u0002ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u0097\u0001\u0010H\u001a\u00020\r*\u00020\u001f2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u0002032\u0006\u0010L\u001a\u0002032\u0006\u0010<\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010=\u001a\u0002092\u0006\u0010;\u001a\u0002092\u0006\u0010M\u001a\u00020#2\u0006\u0010N\u001a\u00020#2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u001f\u0010\u001d\u001a\u001b\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r\u0018\u00010\u001e¢\u0006\u0002\b!2\u0006\u0010O\u001a\u00020\u0014H\u0002ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ>\u0010R\u001a\u00020\r*\u00020\u001f2\u0006\u0010/\u001a\u00020 2\u0006\u00100\u001a\u0002012\u0006\u0010E\u001a\u0002092\u0006\u0010S\u001a\u0002032\u0006\u0010T\u001a\u000203H\u0002ø\u0001\u0000¢\u0006\u0004\bU\u0010VR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\u00020\b*\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006W"}, m195d2 = {"Landroidx/compose/material3/SliderDefaults;", "", "()V", "cornerPath", "Landroidx/compose/ui/graphics/Path;", "halfRectPath", "trackPath", "defaultSliderColors", "Landroidx/compose/material3/SliderColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSliderColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SliderColors;", "Thumb", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "enabled", "", "thumbSize", "Landroidx/compose/ui/unit/DpSize;", "Thumb-9LiSoMs", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "Track", "rangeSliderState", "Landroidx/compose/material3/RangeSliderState;", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "drawStopIndicator", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "thumbTrackGapSize", "Landroidx/compose/ui/unit/Dp;", "trackInsideCornerSize", "Track-nbWgWpA", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;FFLandroidx/compose/runtime/Composer;II)V", "sliderPositions", "Landroidx/compose/material3/SliderPositions;", "(Landroidx/compose/material3/SliderPositions;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "sliderState", "Landroidx/compose/material3/SliderState;", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;FFLandroidx/compose/runtime/Composer;II)V", "buildCorner", "offset", "size", "Landroidx/compose/ui/geometry/Size;", "cornerRadius", "", "isStart", "buildCorner-fk0IrS8", "(JJFZ)V", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SliderColors;", "color", "drawStopIndicator-x3O1jOs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFJ)V", "drawTrack", "tickFractions", "", "activeRangeStart", "activeRangeEnd", "height", "thumbWidth", "isRangeSlider", "drawTrack-GmkxZDg", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;[FFFJJJJFFFFLkotlin/jvm/functions/Function2;Z)V", "drawTrackPath", "startCornerRadius", "endCornerRadius", "drawTrackPath-Cx2C_VA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJJFF)V", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final SliderDefaults INSTANCE = new SliderDefaults();
    private static final Path trackPath = AndroidPath_androidKt.Path();
    private static final Path cornerPath = AndroidPath_androidKt.Path();
    private static final Path halfRectPath = AndroidPath_androidKt.Path();

    private SliderDefaults() {
    }

    public final SliderColors colors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1376295968, "C(colors)895@36738L11:Slider.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1376295968, $changed, -1, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:895)");
        }
        SliderColors defaultSliderColors$material3_release = getDefaultSliderColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultSliderColors$material3_release;
    }

    /* JADX INFO: renamed from: colors-q0g_0yA, reason: not valid java name */
    public final SliderColors m2625colorsq0g_0yA(long thumbColor, long activeTrackColor, long activeTickColor, long inactiveTrackColor, long inactiveTickColor, long disabledThumbColor, long disabledActiveTrackColor, long disabledActiveTickColor, long disabledInactiveTrackColor, long disabledInactiveTickColor, Composer $composer, int $changed, int $changed1, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 885588574, "C(colors)P(9:c#ui.graphics.Color,1:c#ui.graphics.Color,0:c#ui.graphics.Color,8:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color)936@39037L11:Slider.kt#uh7d8r");
        long thumbColor2 = (i & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : thumbColor;
        long activeTrackColor2 = (i & 2) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : activeTrackColor;
        long activeTickColor2 = (i & 4) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : activeTickColor;
        long inactiveTrackColor2 = (i & 8) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : inactiveTrackColor;
        long inactiveTickColor2 = (i & 16) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : inactiveTickColor;
        long disabledThumbColor2 = (i & 32) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledThumbColor;
        long disabledActiveTrackColor2 = (i & 64) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledActiveTrackColor;
        long disabledActiveTickColor2 = (i & 128) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledActiveTickColor;
        long disabledInactiveTrackColor2 = (i & 256) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledInactiveTrackColor;
        long disabledInactiveTickColor2 = (i & 512) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledInactiveTickColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(885588574, $changed, $changed1, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:936)");
        }
        SliderColors sliderColorsM2601copyK518z4 = getDefaultSliderColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6)).m2601copyK518z4(thumbColor2, activeTrackColor2, activeTickColor2, inactiveTrackColor2, inactiveTickColor2, disabledThumbColor2, disabledActiveTrackColor2, disabledActiveTickColor2, disabledInactiveTrackColor2, disabledInactiveTickColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return sliderColorsM2601copyK518z4;
    }

    public final SliderColors getDefaultSliderColors$material3_release(ColorScheme $this$defaultSliderColors) {
        SliderColors defaultSliderColorsCached = $this$defaultSliderColors.getDefaultSliderColorsCached();
        if (defaultSliderColorsCached == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getHandleColor());
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getActiveTrackColor());
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getInactiveTrackColor());
            long jFromToken4 = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getInactiveTrackColor());
            long jFromToken5 = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getActiveTrackColor());
            long jFromToken6 = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getDisabledHandleColor());
            long jM4336compositeOverOWjLjI = ColorKt.m4336compositeOverOWjLjI(Color.m4289copywmQWz5c(jFromToken6, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken6) : SliderTokens.INSTANCE.getDisabledHandleOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken6) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken6) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken6) : 0.0f), $this$defaultSliderColors.getSurface());
            long jFromToken7 = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getDisabledActiveTrackColor());
            long jM4289copywmQWz5c = Color.m4289copywmQWz5c(jFromToken7, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken7) : SliderTokens.INSTANCE.getDisabledActiveTrackOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken7) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken7) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken7) : 0.0f);
            long jFromToken8 = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getDisabledInactiveTrackColor());
            long jM4289copywmQWz5c2 = Color.m4289copywmQWz5c(jFromToken8, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken8) : SliderTokens.INSTANCE.getDisabledInactiveTrackOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken8) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken8) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken8) : 0.0f);
            long jFromToken9 = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getDisabledInactiveTrackColor());
            long jM4289copywmQWz5c3 = Color.m4289copywmQWz5c(jFromToken9, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken9) : SliderTokens.INSTANCE.getDisabledInactiveTrackOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken9) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken9) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken9) : 0.0f);
            long jFromToken10 = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getDisabledActiveTrackColor());
            SliderColors it = new SliderColors(jFromToken, jFromToken2, jFromToken3, jFromToken4, jFromToken5, jM4336compositeOverOWjLjI, jM4289copywmQWz5c, jM4289copywmQWz5c2, jM4289copywmQWz5c3, Color.m4289copywmQWz5c(jFromToken10, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken10) : SliderTokens.INSTANCE.getDisabledActiveTrackOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken10) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken10) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken10) : 0.0f), null);
            $this$defaultSliderColors.setDefaultSliderColorsCached$material3_release(it);
            return it;
        }
        return defaultSliderColorsCached;
    }

    /* JADX INFO: renamed from: Thumb-9LiSoMs, reason: not valid java name */
    public final void m2622Thumb9LiSoMs(final MutableInteractionSource interactionSource, Modifier modifier, SliderColors colors, boolean enabled, long thumbSize, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        SliderColors colors2;
        boolean enabled2;
        long thumbSize2;
        Modifier.Companion modifier3;
        Object value$iv;
        SliderDefaults$Thumb$1$1 value$iv2;
        long size;
        Modifier modifier4;
        long thumbSize3;
        SliderColors colors3;
        boolean enabled3;
        Composer $composer2 = $composer.startRestartGroup(-290277409);
        ComposerKt.sourceInformation($composer2, "C(Thumb)P(2,3!,4:c#ui.unit.DpSize)991@42006L8,995@42122L46,996@42211L658,996@42177L692,1018@43240L5,1014@43036L220:Slider.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                colors2 = colors;
                int i3 = $composer2.changed(colors2) ? 256 : 128;
                $dirty |= i3;
            } else {
                colors2 = colors;
            }
            $dirty |= i3;
        } else {
            colors2 = colors;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty |= $composer2.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            thumbSize2 = thumbSize;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            thumbSize2 = thumbSize;
            $dirty |= $composer2.changed(thumbSize2) ? 16384 : 8192;
        } else {
            thumbSize2 = thumbSize;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changed(this) ? 131072 : 65536;
        }
        if (($dirty & 74899) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            thumbSize3 = thumbSize2;
            colors3 = colors2;
            enabled3 = enabled2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    SliderColors colors4 = colors($composer2, ($dirty >> 15) & 14);
                    $dirty &= -897;
                    colors2 = colors4;
                }
                if (i4 != 0) {
                    enabled2 = true;
                }
                if (i5 != 0) {
                    thumbSize2 = SliderKt.ThumbSize;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier3 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-290277409, $dirty, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:994)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1142852724, "CC(remember):Slider.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt.mutableStateListOf();
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            SnapshotStateList interactions = (SnapshotStateList) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1142852635, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new SliderDefaults$Thumb$1$1(interactionSource, interactions, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer2, $dirty & 14);
            if (!interactions.isEmpty()) {
                float arg0$iv = DpSize.m6899getWidthD9Ej5fM(thumbSize2);
                size = DpSize.m6892copyDwJknco$default(thumbSize2, C1979Dp.m6801constructorimpl(arg0$iv / 2), 0.0f, 2, null);
            } else {
                size = thumbSize2;
            }
            SpacerKt.Spacer(BackgroundKt.m453backgroundbw27NRU(HoverableKt.hoverable$default(SizeKt.m914size6HolHcs(modifier3, size), interactionSource, false, 2, null), colors2.m2612thumbColorvNxB06k$material3_release(enabled2), ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), $composer2, 6)), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            thumbSize3 = thumbSize2;
            colors3 = colors2;
            enabled3 = enabled2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final SliderColors sliderColors = colors3;
            final boolean z = enabled3;
            final long j = thumbSize3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Thumb$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i6) {
                    this.$tmp2_rcvr.m2622Thumb9LiSoMs(interactionSource, modifier5, sliderColors, z, j, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(message = "Use version that supports slider state")
    public final void Track(final SliderPositions sliderPositions, Modifier modifier, SliderColors colors, boolean enabled, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        SliderColors sliderColors;
        boolean enabled2;
        Modifier.Companion modifier3;
        SliderColors colors2;
        boolean enabled3;
        Modifier modifier4;
        SliderColors colors3;
        Composer $composer2 = $composer.startRestartGroup(-1546713545);
        ComposerKt.sourceInformation($composer2, "C(Track)P(3,2)1040@44163L8,1051@44624L1830,1047@44516L1938:Slider.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(sliderPositions) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                sliderColors = colors;
                int i3 = $composer2.changed(sliderColors) ? 256 : 128;
                $dirty |= i3;
            } else {
                sliderColors = colors;
            }
            $dirty |= i3;
        } else {
            sliderColors = colors;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty |= $composer2.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(this) ? 16384 : 8192;
        }
        if (($dirty & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            colors3 = sliderColors;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    colors2 = colors($composer2, ($dirty >> 12) & 14);
                    $dirty &= -897;
                } else {
                    colors2 = sliderColors;
                }
                enabled3 = i4 != 0 ? true : enabled2;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier3 = modifier2;
                colors2 = sliderColors;
                enabled3 = enabled2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1546713545, $dirty, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1042)");
            }
            final long inactiveTrackColor = colors2.m2614trackColorWaAFU9c$material3_release(enabled3, false);
            final long activeTrackColor = colors2.m2614trackColorWaAFU9c$material3_release(enabled3, true);
            final long inactiveTickColor = colors2.m2613tickColorWaAFU9c$material3_release(enabled3, false);
            final long activeTickColor = colors2.m2613tickColorWaAFU9c$material3_release(enabled3, true);
            Modifier modifierM899height3ABfNKs = SizeKt.m899height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), SliderKt.getTrackHeight());
            ComposerKt.sourceInformationMarkerStart($composer2, -1134220163, "CC(remember):Slider.kt#9igjgp");
            modifier4 = modifier3;
            boolean invalid$iv = (($dirty & 14) == 4) | $composer2.changed(inactiveTrackColor) | $composer2.changed(activeTrackColor) | $composer2.changed(inactiveTickColor) | $composer2.changed(activeTickColor);
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope $this$Canvas) {
                        Object answer$iv$iv$iv;
                        boolean isRtl = $this$Canvas.getLayoutDirection() == LayoutDirection.Rtl;
                        long sliderLeft = OffsetKt.Offset(0.0f, Offset.m4050getYimpl($this$Canvas.mo4772getCenterF1C5BW0()));
                        long sliderRight = OffsetKt.Offset(Size.m4118getWidthimpl($this$Canvas.mo4773getSizeNHjbRc()), Offset.m4050getYimpl($this$Canvas.mo4772getCenterF1C5BW0()));
                        long sliderStart = isRtl ? sliderRight : sliderLeft;
                        long sliderEnd = isRtl ? sliderLeft : sliderRight;
                        float tickSize = $this$Canvas.mo567toPx0680j_4(SliderKt.TickSize);
                        float trackStrokeWidth = $this$Canvas.mo567toPx0680j_4(SliderKt.getTrackHeight());
                        long sliderEnd2 = sliderEnd;
                        long sliderStart2 = sliderStart;
                        DrawScope.CC.m4850drawLineNGM6Ib0$default($this$Canvas, inactiveTrackColor, sliderStart, sliderEnd, trackStrokeWidth, StrokeCap.INSTANCE.m4653getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                        long sliderValueEnd = OffsetKt.Offset(Offset.m4049getXimpl(sliderStart2) + ((Offset.m4049getXimpl(sliderEnd2) - Offset.m4049getXimpl(sliderStart2)) * sliderPositions.getActiveRange().getEndInclusive().floatValue()), Offset.m4050getYimpl($this$Canvas.mo4772getCenterF1C5BW0()));
                        long sliderValueStart = OffsetKt.Offset(Offset.m4049getXimpl(sliderStart2) + ((Offset.m4049getXimpl(sliderEnd2) - Offset.m4049getXimpl(sliderStart2)) * sliderPositions.getActiveRange().getStart().floatValue()), Offset.m4050getYimpl($this$Canvas.mo4772getCenterF1C5BW0()));
                        DrawScope.CC.m4850drawLineNGM6Ib0$default($this$Canvas, activeTrackColor, sliderValueStart, sliderValueEnd, trackStrokeWidth, StrokeCap.INSTANCE.m4653getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                        float[] $this$groupBy$iv = sliderPositions.getTickFractions();
                        SliderPositions sliderPositions2 = sliderPositions;
                        Map destination$iv$iv = new LinkedHashMap();
                        int length = $this$groupBy$iv.length;
                        for (int i5 = 0; i5 < length; i5++) {
                            float element$iv$iv = $this$groupBy$iv[i5];
                            Boolean boolValueOf = Boolean.valueOf(element$iv$iv > sliderPositions2.getActiveRange().getEndInclusive().floatValue() || element$iv$iv < sliderPositions2.getActiveRange().getStart().floatValue());
                            Object value$iv$iv$iv = destination$iv$iv.get(boolValueOf);
                            if (value$iv$iv$iv == null) {
                                answer$iv$iv$iv = new ArrayList();
                                destination$iv$iv.put(boolValueOf, answer$iv$iv$iv);
                            } else {
                                answer$iv$iv$iv = value$iv$iv$iv;
                            }
                            List list$iv$iv = (List) answer$iv$iv$iv;
                            list$iv$iv.add(Float.valueOf(element$iv$iv));
                        }
                        long sliderStart3 = inactiveTickColor;
                        long j = activeTickColor;
                        for (Map.Entry element$iv : destination$iv$iv.entrySet()) {
                            boolean outsideFraction = ((Boolean) element$iv.getKey()).booleanValue();
                            List list = (List) element$iv.getValue();
                            List $this$fastMap$iv = list;
                            ArrayList target$iv = new ArrayList($this$fastMap$iv.size());
                            int index$iv$iv = 0;
                            int size = $this$fastMap$iv.size();
                            while (index$iv$iv < size) {
                                Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
                                float it = ((Number) item$iv$iv).floatValue();
                                long sliderStart4 = sliderStart2;
                                long sliderEnd3 = sliderEnd2;
                                target$iv.add(Offset.m4038boximpl(OffsetKt.Offset(Offset.m4049getXimpl(OffsetKt.m4072lerpWko1d7g(sliderStart4, sliderEnd3, it)), Offset.m4050getYimpl($this$Canvas.mo4772getCenterF1C5BW0()))));
                                index$iv$iv++;
                                sliderStart2 = sliderStart4;
                                $this$fastMap$iv = $this$fastMap$iv;
                                sliderStart3 = sliderStart3;
                                j = j;
                                sliderEnd2 = sliderEnd3;
                            }
                            long j2 = j;
                            long j3 = sliderStart3;
                            long sliderStart5 = sliderStart2;
                            sliderEnd2 = sliderEnd2;
                            DrawScope.CC.m4855drawPointsF8ZwMP8$default($this$Canvas, target$iv, PointMode.INSTANCE.m4605getPointsr_lszbg(), outsideFraction ? j3 : j2, tickSize, StrokeCap.INSTANCE.m4653getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                            j = j2;
                            sliderStart2 = sliderStart5;
                            sliderStart3 = j3;
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifierM899height3ABfNKs, (Function1) value$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors3 = colors2;
            enabled2 = enabled3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final SliderColors sliderColors2 = colors3;
            final boolean z = enabled2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderDefaults.Track.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    SliderDefaults.this.Track(sliderPositions, modifier5, sliderColors2, z, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `drawStopIndicator`, `thumbTrackGapSize` and `trackInsideCornerSize`, see `LegacySliderSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(expression = "Track(sliderState, modifier, enabled, colors, drawStopIndicator, thumbTrackGapSize, trackInsideCornerSize)", imports = {}))
    public final /* synthetic */ void Track(final SliderState sliderState, Modifier modifier, SliderColors colors, boolean enabled, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        SliderColors sliderColors;
        boolean z;
        SliderColors colors2;
        int $dirty;
        Modifier modifier3;
        SliderColors colors3;
        boolean enabled2;
        Composer $composer2 = $composer.startRestartGroup(593554206);
        ComposerKt.sourceInformation($composer2, "C(Track)P(3,2)1128@47683L8,1131@47741L213:Slider.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(sliderState) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                sliderColors = colors;
                int i3 = $composer2.changed(sliderColors) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                sliderColors = colors;
            }
            $dirty2 |= i3;
        } else {
            sliderColors = colors;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            z = enabled;
        } else if (($changed & 3072) == 0) {
            z = enabled;
            $dirty2 |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        if ((i & 16) != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer2.changed(this) ? 16384 : 8192;
        }
        if (($dirty2 & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            colors3 = sliderColors;
            enabled2 = z;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    colors2 = colors($composer2, ($dirty2 >> 12) & 14);
                    $dirty2 &= -897;
                } else {
                    colors2 = sliderColors;
                }
                if (i4 != 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    colors3 = colors2;
                    enabled2 = true;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    colors3 = colors2;
                    enabled2 = z;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                colors3 = sliderColors;
                enabled2 = z;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(593554206, $dirty, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1130)");
            }
            m2624TracknbWgWpA(sliderState, modifier3, enabled2, colors3, (Function2<? super DrawScope, ? super Offset, Unit>) null, SliderKt.ThumbTrackGapSize, SliderKt.TrackInsideCornerSize, $composer2, ($dirty & 14) | 1769472 | ($dirty & 112) | (($dirty >> 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 9) & 29360128), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final SliderColors sliderColors2 = colors3;
            final boolean z2 = enabled2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderDefaults.Track.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    SliderDefaults.this.Track(sliderState, modifier5, sliderColors2, z2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:172:0x02df  */
    /* JADX INFO: renamed from: Track-nbWgWpA, reason: not valid java name */
    public final void m2624TracknbWgWpA(final SliderState sliderState, Modifier modifier, boolean enabled, SliderColors colors, Function2<? super DrawScope, ? super Offset, Unit> function2, float thumbTrackGapSize, float trackInsideCornerSize, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean enabled2;
        final SliderColors colors2;
        Function2<? super DrawScope, ? super Offset, Unit> function3;
        float thumbTrackGapSize2;
        Modifier modifier3;
        float trackInsideCornerSize2;
        int $dirty;
        Function2<? super DrawScope, ? super Offset, Unit> function4;
        float thumbTrackGapSize3;
        Object value$iv;
        int $dirty2;
        int i2;
        float thumbTrackGapSize4;
        float trackInsideCornerSize3;
        boolean enabled3;
        SliderColors colors3;
        Modifier modifier4;
        Function2<? super DrawScope, ? super Offset, Unit> function5;
        Composer $composer2 = $composer.startRestartGroup(-1638206476);
        ComposerKt.sourceInformation($composer2, "C(Track)P(4,3,2!2,5:c#ui.unit.Dp,6:c#ui.unit.Dp)1162@49039L8,1163@49108L180,1181@49856L7,1182@49912L543,1177@49709L746:Slider.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changedInstance(sliderState) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty3 |= 384;
            enabled2 = enabled;
        } else if (($changed & 384) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer2.changed(enabled2) ? 256 : 128;
        } else {
            enabled2 = enabled;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                colors2 = colors;
                int i5 = $composer2.changed(colors2) ? 2048 : 1024;
                $dirty3 |= i5;
            } else {
                colors2 = colors;
            }
            $dirty3 |= i5;
        } else {
            colors2 = colors;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                function3 = function2;
                int i6 = $composer2.changedInstance(function3) ? 16384 : 8192;
                $dirty3 |= i6;
            } else {
                function3 = function2;
            }
            $dirty3 |= i6;
        } else {
            function3 = function2;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            thumbTrackGapSize2 = thumbTrackGapSize;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            thumbTrackGapSize2 = thumbTrackGapSize;
            $dirty3 |= $composer2.changed(thumbTrackGapSize2) ? 131072 : 65536;
        } else {
            thumbTrackGapSize2 = thumbTrackGapSize;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer2.changed(trackInsideCornerSize) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer2.changed(this) ? 8388608 : 4194304;
        }
        if ((4793491 & $dirty3) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            trackInsideCornerSize3 = trackInsideCornerSize;
            modifier4 = modifier2;
            enabled3 = enabled2;
            thumbTrackGapSize4 = thumbTrackGapSize2;
            function5 = function3;
            colors3 = colors2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if (i4 != 0) {
                    enabled2 = true;
                }
                if ((i & 8) != 0) {
                    SliderColors colors4 = colors($composer2, ($dirty3 >> 21) & 14);
                    $dirty3 &= -7169;
                    colors2 = colors4;
                }
                if ((i & 16) != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -1134215679, "CC(remember):Slider.kt#9igjgp");
                    boolean invalid$iv = ((($dirty3 & 7168) ^ 3072) > 2048 && $composer2.changed(colors2)) || ($dirty3 & 3072) == 2048;
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv) {
                        modifier3 = modifier5;
                    } else {
                        modifier3 = modifier5;
                        if (it$iv != Composer.INSTANCE.getEmpty()) {
                            value$iv = it$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $dirty3 &= -57345;
                        function3 = (Function2) value$iv;
                    }
                    value$iv = (Function2) new Function2<DrawScope, Offset, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$4$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset) {
                            m2626invokeUv8p0NA(drawScope, offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
                        public final void m2626invokeUv8p0NA(DrawScope $this$null, long it) {
                            SliderDefaults.INSTANCE.m2619drawStopIndicatorx3O1jOs($this$null, it, SliderKt.TrackStopIndicatorSize, colors2.getActiveTrackColor());
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $dirty3 &= -57345;
                    function3 = (Function2) value$iv;
                } else {
                    modifier3 = modifier5;
                }
                if (i7 != 0) {
                    thumbTrackGapSize2 = SliderKt.ThumbTrackGapSize;
                }
                if (i8 != 0) {
                    modifier2 = modifier3;
                    trackInsideCornerSize2 = SliderKt.TrackInsideCornerSize;
                    $dirty = $dirty3;
                    function4 = function3;
                    thumbTrackGapSize3 = thumbTrackGapSize2;
                } else {
                    modifier2 = modifier3;
                    trackInsideCornerSize2 = trackInsideCornerSize;
                    $dirty = $dirty3;
                    function4 = function3;
                    thumbTrackGapSize3 = thumbTrackGapSize2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty3 &= -7169;
                }
                if ((i & 16) != 0) {
                    trackInsideCornerSize2 = trackInsideCornerSize;
                    $dirty = (-57345) & $dirty3;
                    function4 = function3;
                    thumbTrackGapSize3 = thumbTrackGapSize2;
                } else {
                    trackInsideCornerSize2 = trackInsideCornerSize;
                    $dirty = $dirty3;
                    function4 = function3;
                    thumbTrackGapSize3 = thumbTrackGapSize2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1638206476, $dirty, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1172)");
            }
            final long inactiveTrackColor = colors2.m2614trackColorWaAFU9c$material3_release(enabled2, false);
            final long activeTrackColor = colors2.m2614trackColorWaAFU9c$material3_release(enabled2, true);
            final float thumbTrackGapSize5 = thumbTrackGapSize3;
            final float trackInsideCornerSize4 = trackInsideCornerSize2;
            final long inactiveTickColor = colors2.m2613tickColorWaAFU9c$material3_release(enabled2, false);
            final long activeTickColor = colors2.m2613tickColorWaAFU9c$material3_release(enabled2, true);
            boolean enabled4 = enabled2;
            SliderColors colors5 = colors2;
            Modifier modifierM899height3ABfNKs = SizeKt.m899height3ABfNKs(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, null), SliderKt.getTrackHeight());
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            Modifier modifier6 = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierRotate = RotateKt.rotate(modifierM899height3ABfNKs, objConsume == LayoutDirection.Rtl ? 180.0f : 0.0f);
            ComposerKt.sourceInformationMarkerStart($composer2, -1134214875, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(sliderState) | $composer2.changed(inactiveTrackColor) | $composer2.changed(activeTrackColor) | $composer2.changed(inactiveTickColor) | $composer2.changed(activeTickColor) | ((458752 & $dirty) == 131072) | ((3670016 & $dirty) == 1048576) | ((((57344 & $dirty) ^ CpioConstants.C_ISBLK) > 16384 && $composer2.changed(function4)) || ($dirty & CpioConstants.C_ISBLK) == 16384);
            Object value$iv2 = $composer2.rememberedValue();
            if (invalid$iv2) {
                $dirty2 = $dirty;
            } else {
                $dirty2 = $dirty;
                if (value$iv2 != Composer.INSTANCE.getEmpty()) {
                    i2 = 0;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                CanvasKt.Canvas(modifierRotate, (Function1) value$iv2, $composer2, i2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                thumbTrackGapSize4 = thumbTrackGapSize5;
                trackInsideCornerSize3 = trackInsideCornerSize4;
                enabled3 = enabled4;
                colors3 = colors5;
                modifier4 = modifier6;
                function5 = function4;
            }
            i2 = 0;
            final Function2<? super DrawScope, ? super Offset, Unit> function6 = function4;
            value$iv2 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$5$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope $this$Canvas) {
                    SliderDefaults.INSTANCE.m2620drawTrackGmkxZDg($this$Canvas, sliderState.getTickFractions(), 0.0f, sliderState.getCoercedValueAsFraction$material3_release(), inactiveTrackColor, activeTrackColor, inactiveTickColor, activeTickColor, $this$Canvas.mo563toDpu2uoSUM(sliderState.getTrackHeight$material3_release()), $this$Canvas.mo563toDpu2uoSUM(sliderState.getThumbWidth$material3_release()), thumbTrackGapSize5, trackInsideCornerSize4, function6, false);
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifierRotate, (Function1) value$iv2, $composer2, i2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            thumbTrackGapSize4 = thumbTrackGapSize5;
            trackInsideCornerSize3 = trackInsideCornerSize4;
            enabled3 = enabled4;
            colors3 = colors5;
            modifier4 = modifier6;
            function5 = function4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier7 = modifier4;
            final boolean z = enabled3;
            final SliderColors sliderColors = colors3;
            final Function2<? super DrawScope, ? super Offset, Unit> function7 = function5;
            final float f = thumbTrackGapSize4;
            final float f2 = trackInsideCornerSize3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderDefaults.Track.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) {
                    SliderDefaults.this.m2624TracknbWgWpA(sliderState, modifier7, z, sliderColors, function7, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `drawStopIndicator`, `thumbTrackGapSize` and `trackInsideCornerSize`, see `LegacyRangeSliderSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(expression = "Track(rangeSliderState, modifier, colors, enabled, drawStopIndicator, thumbTrackGapSize, trackInsideCornerSize)", imports = {}))
    public final /* synthetic */ void Track(final RangeSliderState rangeSliderState, Modifier modifier, SliderColors colors, boolean enabled, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        SliderColors sliderColors;
        boolean z;
        SliderColors colors2;
        int $dirty;
        Modifier modifier3;
        SliderColors colors3;
        boolean enabled2;
        Composer $composer2 = $composer.startRestartGroup(-1617869097);
        ComposerKt.sourceInformation($composer2, "C(Track)P(3,2)1227@51733L8,1230@51791L218:Slider.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(rangeSliderState) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                sliderColors = colors;
                int i3 = $composer2.changed(sliderColors) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                sliderColors = colors;
            }
            $dirty2 |= i3;
        } else {
            sliderColors = colors;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            z = enabled;
        } else if (($changed & 3072) == 0) {
            z = enabled;
            $dirty2 |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        if ((i & 16) != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer2.changed(this) ? 16384 : 8192;
        }
        if (($dirty2 & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            colors3 = sliderColors;
            enabled2 = z;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    colors2 = colors($composer2, ($dirty2 >> 12) & 14);
                    $dirty2 &= -897;
                } else {
                    colors2 = sliderColors;
                }
                if (i4 != 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    colors3 = colors2;
                    enabled2 = true;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    colors3 = colors2;
                    enabled2 = z;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                colors3 = sliderColors;
                enabled2 = z;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1617869097, $dirty, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1229)");
            }
            m2623TracknbWgWpA(rangeSliderState, modifier3, enabled2, colors3, (Function2<? super DrawScope, ? super Offset, Unit>) null, SliderKt.ThumbTrackGapSize, SliderKt.TrackInsideCornerSize, $composer2, ($dirty & 14) | 1769472 | ($dirty & 112) | (($dirty >> 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 9) & 29360128), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final SliderColors sliderColors2 = colors3;
            final boolean z2 = enabled2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderDefaults.Track.7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    SliderDefaults.this.Track(rangeSliderState, modifier5, sliderColors2, z2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:172:0x02df  */
    /* JADX INFO: renamed from: Track-nbWgWpA, reason: not valid java name */
    public final void m2623TracknbWgWpA(final RangeSliderState rangeSliderState, Modifier modifier, boolean enabled, SliderColors colors, Function2<? super DrawScope, ? super Offset, Unit> function2, float thumbTrackGapSize, float trackInsideCornerSize, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean enabled2;
        final SliderColors colors2;
        Function2<? super DrawScope, ? super Offset, Unit> function3;
        float thumbTrackGapSize2;
        Modifier modifier3;
        float trackInsideCornerSize2;
        int $dirty;
        Function2<? super DrawScope, ? super Offset, Unit> function4;
        float thumbTrackGapSize3;
        Object value$iv;
        int $dirty2;
        int i2;
        float thumbTrackGapSize4;
        float trackInsideCornerSize3;
        boolean enabled3;
        SliderColors colors3;
        Modifier modifier4;
        Function2<? super DrawScope, ? super Offset, Unit> function5;
        Composer $composer2 = $composer.startRestartGroup(1731640749);
        ComposerKt.sourceInformation($composer2, "C(Track)P(4,3,2!2,5:c#ui.unit.Dp,6:c#ui.unit.Dp)1261@53141L8,1262@53210L180,1280@53958L7,1281@54014L625,1276@53811L828:Slider.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changedInstance(rangeSliderState) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty3 |= 384;
            enabled2 = enabled;
        } else if (($changed & 384) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer2.changed(enabled2) ? 256 : 128;
        } else {
            enabled2 = enabled;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                colors2 = colors;
                int i5 = $composer2.changed(colors2) ? 2048 : 1024;
                $dirty3 |= i5;
            } else {
                colors2 = colors;
            }
            $dirty3 |= i5;
        } else {
            colors2 = colors;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                function3 = function2;
                int i6 = $composer2.changedInstance(function3) ? 16384 : 8192;
                $dirty3 |= i6;
            } else {
                function3 = function2;
            }
            $dirty3 |= i6;
        } else {
            function3 = function2;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            thumbTrackGapSize2 = thumbTrackGapSize;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            thumbTrackGapSize2 = thumbTrackGapSize;
            $dirty3 |= $composer2.changed(thumbTrackGapSize2) ? 131072 : 65536;
        } else {
            thumbTrackGapSize2 = thumbTrackGapSize;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer2.changed(trackInsideCornerSize) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer2.changed(this) ? 8388608 : 4194304;
        }
        if ((4793491 & $dirty3) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            trackInsideCornerSize3 = trackInsideCornerSize;
            modifier4 = modifier2;
            enabled3 = enabled2;
            thumbTrackGapSize4 = thumbTrackGapSize2;
            function5 = function3;
            colors3 = colors2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if (i4 != 0) {
                    enabled2 = true;
                }
                if ((i & 8) != 0) {
                    SliderColors colors4 = colors($composer2, ($dirty3 >> 21) & 14);
                    $dirty3 &= -7169;
                    colors2 = colors4;
                }
                if ((i & 16) != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -1134211577, "CC(remember):Slider.kt#9igjgp");
                    boolean invalid$iv = ((($dirty3 & 7168) ^ 3072) > 2048 && $composer2.changed(colors2)) || ($dirty3 & 3072) == 2048;
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv) {
                        modifier3 = modifier5;
                    } else {
                        modifier3 = modifier5;
                        if (it$iv != Composer.INSTANCE.getEmpty()) {
                            value$iv = it$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $dirty3 &= -57345;
                        function3 = (Function2) value$iv;
                    }
                    value$iv = (Function2) new Function2<DrawScope, Offset, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$8$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Offset offset) {
                            m2627invokeUv8p0NA(drawScope, offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
                        public final void m2627invokeUv8p0NA(DrawScope $this$null, long it) {
                            SliderDefaults.INSTANCE.m2619drawStopIndicatorx3O1jOs($this$null, it, SliderKt.TrackStopIndicatorSize, colors2.getActiveTrackColor());
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $dirty3 &= -57345;
                    function3 = (Function2) value$iv;
                } else {
                    modifier3 = modifier5;
                }
                if (i7 != 0) {
                    thumbTrackGapSize2 = SliderKt.ThumbTrackGapSize;
                }
                if (i8 != 0) {
                    modifier2 = modifier3;
                    trackInsideCornerSize2 = SliderKt.TrackInsideCornerSize;
                    $dirty = $dirty3;
                    function4 = function3;
                    thumbTrackGapSize3 = thumbTrackGapSize2;
                } else {
                    modifier2 = modifier3;
                    trackInsideCornerSize2 = trackInsideCornerSize;
                    $dirty = $dirty3;
                    function4 = function3;
                    thumbTrackGapSize3 = thumbTrackGapSize2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty3 &= -7169;
                }
                if ((i & 16) != 0) {
                    trackInsideCornerSize2 = trackInsideCornerSize;
                    $dirty = (-57345) & $dirty3;
                    function4 = function3;
                    thumbTrackGapSize3 = thumbTrackGapSize2;
                } else {
                    trackInsideCornerSize2 = trackInsideCornerSize;
                    $dirty = $dirty3;
                    function4 = function3;
                    thumbTrackGapSize3 = thumbTrackGapSize2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1731640749, $dirty, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1271)");
            }
            final long inactiveTrackColor = colors2.m2614trackColorWaAFU9c$material3_release(enabled2, false);
            final long activeTrackColor = colors2.m2614trackColorWaAFU9c$material3_release(enabled2, true);
            final float thumbTrackGapSize5 = thumbTrackGapSize3;
            final float trackInsideCornerSize4 = trackInsideCornerSize2;
            final long inactiveTickColor = colors2.m2613tickColorWaAFU9c$material3_release(enabled2, false);
            final long activeTickColor = colors2.m2613tickColorWaAFU9c$material3_release(enabled2, true);
            boolean enabled4 = enabled2;
            SliderColors colors5 = colors2;
            Modifier modifierM899height3ABfNKs = SizeKt.m899height3ABfNKs(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, null), SliderKt.getTrackHeight());
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            Modifier modifier6 = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierRotate = RotateKt.rotate(modifierM899height3ABfNKs, objConsume == LayoutDirection.Rtl ? 180.0f : 0.0f);
            ComposerKt.sourceInformationMarkerStart($composer2, -1134210773, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(rangeSliderState) | $composer2.changed(inactiveTrackColor) | $composer2.changed(activeTrackColor) | $composer2.changed(inactiveTickColor) | $composer2.changed(activeTickColor) | ((458752 & $dirty) == 131072) | ((3670016 & $dirty) == 1048576) | ((((57344 & $dirty) ^ CpioConstants.C_ISBLK) > 16384 && $composer2.changed(function4)) || ($dirty & CpioConstants.C_ISBLK) == 16384);
            Object value$iv2 = $composer2.rememberedValue();
            if (invalid$iv2) {
                $dirty2 = $dirty;
            } else {
                $dirty2 = $dirty;
                if (value$iv2 != Composer.INSTANCE.getEmpty()) {
                    i2 = 0;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                CanvasKt.Canvas(modifierRotate, (Function1) value$iv2, $composer2, i2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                thumbTrackGapSize4 = thumbTrackGapSize5;
                trackInsideCornerSize3 = trackInsideCornerSize4;
                enabled3 = enabled4;
                colors3 = colors5;
                modifier4 = modifier6;
                function5 = function4;
            }
            i2 = 0;
            final Function2<? super DrawScope, ? super Offset, Unit> function6 = function4;
            value$iv2 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$9$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope $this$Canvas) {
                    SliderDefaults.INSTANCE.m2620drawTrackGmkxZDg($this$Canvas, rangeSliderState.getTickFractions(), rangeSliderState.getCoercedActiveRangeStartAsFraction$material3_release(), rangeSliderState.getCoercedActiveRangeEndAsFraction$material3_release(), inactiveTrackColor, activeTrackColor, inactiveTickColor, activeTickColor, $this$Canvas.mo563toDpu2uoSUM(rangeSliderState.getTrackHeight$material3_release()), $this$Canvas.mo563toDpu2uoSUM(rangeSliderState.getStartThumbWidth$material3_release()), thumbTrackGapSize5, trackInsideCornerSize4, function6, true);
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifierRotate, (Function1) value$iv2, $composer2, i2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            thumbTrackGapSize4 = thumbTrackGapSize5;
            trackInsideCornerSize3 = trackInsideCornerSize4;
            enabled3 = enabled4;
            colors3 = colors5;
            modifier4 = modifier6;
            function5 = function4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier7 = modifier4;
            final boolean z = enabled3;
            final SliderColors sliderColors = colors3;
            final Function2<? super DrawScope, ? super Offset, Unit> function7 = function5;
            final float f = thumbTrackGapSize4;
            final float f2 = trackInsideCornerSize3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderDefaults.Track.10
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) {
                    SliderDefaults.this.m2623TracknbWgWpA(rangeSliderState, modifier7, z, sliderColors, function7, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawTrack-GmkxZDg, reason: not valid java name */
    public final void m2620drawTrackGmkxZDg(DrawScope $this$drawTrack_u2dGmkxZDg, float[] tickFractions, float activeRangeStart, float activeRangeEnd, long inactiveTrackColor, long activeTrackColor, long inactiveTickColor, long activeTickColor, float height, float thumbWidth, float thumbTrackGapSize, float trackInsideCornerSize, Function2<? super DrawScope, ? super Offset, Unit> function2, boolean isRangeSlider) {
        float trackStrokeWidth;
        float trackStrokeWidth2;
        long sliderStart = OffsetKt.Offset(0.0f, Offset.m4050getYimpl($this$drawTrack_u2dGmkxZDg.mo4772getCenterF1C5BW0()));
        long sliderEnd = OffsetKt.Offset(Size.m4118getWidthimpl($this$drawTrack_u2dGmkxZDg.mo4773getSizeNHjbRc()), Offset.m4050getYimpl($this$drawTrack_u2dGmkxZDg.mo4772getCenterF1C5BW0()));
        float tickSize = $this$drawTrack_u2dGmkxZDg.mo567toPx0680j_4(SliderKt.TickSize);
        float trackStrokeWidth3 = $this$drawTrack_u2dGmkxZDg.mo567toPx0680j_4(height);
        long sliderValueEnd = OffsetKt.Offset(Offset.m4049getXimpl(sliderStart) + ((Offset.m4049getXimpl(sliderEnd) - Offset.m4049getXimpl(sliderStart)) * activeRangeEnd), Offset.m4050getYimpl($this$drawTrack_u2dGmkxZDg.mo4772getCenterF1C5BW0()));
        long sliderValueStart = OffsetKt.Offset(Offset.m4049getXimpl(sliderStart) + ((Offset.m4049getXimpl(sliderEnd) - Offset.m4049getXimpl(sliderStart)) * activeRangeStart), Offset.m4050getYimpl($this$drawTrack_u2dGmkxZDg.mo4772getCenterF1C5BW0()));
        float f = 2;
        float cornerSize = trackStrokeWidth3 / f;
        float insideCornerSize = $this$drawTrack_u2dGmkxZDg.mo567toPx0680j_4(trackInsideCornerSize);
        int $this$dp$iv = C1979Dp.m6800compareTo0680j_4(thumbTrackGapSize, C1979Dp.m6801constructorimpl(0));
        float gap = $this$dp$iv > 0 ? ($this$drawTrack_u2dGmkxZDg.mo567toPx0680j_4(thumbWidth) / f) + $this$drawTrack_u2dGmkxZDg.mo567toPx0680j_4(thumbTrackGapSize) : 0.0f;
        if (!isRangeSlider || Offset.m4049getXimpl(sliderValueStart) <= Offset.m4049getXimpl(sliderStart) + gap + cornerSize) {
            trackStrokeWidth = trackStrokeWidth3;
        } else {
            float start = Offset.m4049getXimpl(sliderStart);
            float end = Offset.m4049getXimpl(sliderValueStart) - gap;
            trackStrokeWidth = trackStrokeWidth3;
            m2621drawTrackPathCx2C_VA($this$drawTrack_u2dGmkxZDg, Offset.INSTANCE.m4065getZeroF1C5BW0(), androidx.compose.p001ui.geometry.SizeKt.Size(end - start, trackStrokeWidth3), inactiveTrackColor, cornerSize, insideCornerSize);
            if (function2 != null) {
                function2.invoke($this$drawTrack_u2dGmkxZDg, Offset.m4038boximpl(OffsetKt.Offset(start + cornerSize, Offset.m4050getYimpl($this$drawTrack_u2dGmkxZDg.mo4772getCenterF1C5BW0()))));
            }
        }
        if (Offset.m4049getXimpl(sliderValueEnd) < (Offset.m4049getXimpl(sliderEnd) - gap) - cornerSize) {
            float start2 = Offset.m4049getXimpl(sliderValueEnd) + gap;
            float end2 = Offset.m4049getXimpl(sliderEnd);
            m2621drawTrackPathCx2C_VA($this$drawTrack_u2dGmkxZDg, OffsetKt.Offset(start2, 0.0f), androidx.compose.p001ui.geometry.SizeKt.Size(end2 - start2, trackStrokeWidth), inactiveTrackColor, insideCornerSize, cornerSize);
            if (function2 != null) {
                function2.invoke($this$drawTrack_u2dGmkxZDg, Offset.m4038boximpl(OffsetKt.Offset(end2 - cornerSize, Offset.m4050getYimpl($this$drawTrack_u2dGmkxZDg.mo4772getCenterF1C5BW0()))));
            }
        }
        float activeTrackStart = isRangeSlider ? Offset.m4049getXimpl(sliderValueStart) + gap : 0.0f;
        float activeTrackEnd = Offset.m4049getXimpl(sliderValueEnd) - gap;
        float startCornerRadius = isRangeSlider ? insideCornerSize : cornerSize;
        if (activeTrackEnd - activeTrackStart > startCornerRadius) {
            m2621drawTrackPathCx2C_VA($this$drawTrack_u2dGmkxZDg, OffsetKt.Offset(activeTrackStart, 0.0f), androidx.compose.p001ui.geometry.SizeKt.Size(activeTrackEnd - activeTrackStart, trackStrokeWidth), activeTrackColor, startCornerRadius, insideCornerSize);
        }
        float[] $this$forEachIndexed$iv = tickFractions;
        int index$iv = 0;
        int length = $this$forEachIndexed$iv.length;
        int i = 0;
        while (i < length) {
            float item$iv = $this$forEachIndexed$iv[i];
            int index$iv2 = index$iv + 1;
            int index = index$iv;
            boolean z = true;
            if (function2 == null || !((isRangeSlider && index == 0) || index == tickFractions.length - 1)) {
                if (item$iv <= activeRangeEnd && item$iv >= activeRangeStart) {
                    z = false;
                }
                boolean outsideFraction = z;
                long start3 = OffsetKt.Offset(Offset.m4049getXimpl(sliderStart) + gap, Offset.m4050getYimpl(sliderStart));
                float trackStrokeWidth4 = trackStrokeWidth;
                long end3 = OffsetKt.Offset(Offset.m4049getXimpl(sliderEnd) - gap, Offset.m4050getYimpl(sliderEnd));
                long j = outsideFraction ? inactiveTickColor : activeTickColor;
                long jOffset = OffsetKt.Offset(Offset.m4049getXimpl(OffsetKt.m4072lerpWko1d7g(start3, end3, item$iv)), Offset.m4050getYimpl($this$drawTrack_u2dGmkxZDg.mo4772getCenterF1C5BW0()));
                long start4 = j;
                trackStrokeWidth2 = trackStrokeWidth4;
                DrawScope.CC.m4845drawCircleVaOC9Bg$default($this$drawTrack_u2dGmkxZDg, start4, tickSize / 2.0f, jOffset, 0.0f, null, null, 0, 120, null);
            } else {
                trackStrokeWidth2 = trackStrokeWidth;
            }
            i++;
            trackStrokeWidth = trackStrokeWidth2;
            index$iv = index$iv2;
            length = length;
            $this$forEachIndexed$iv = $this$forEachIndexed$iv;
        }
    }

    /* JADX INFO: renamed from: drawTrackPath-Cx2C_VA, reason: not valid java name */
    private final void m2621drawTrackPathCx2C_VA(DrawScope $this$drawTrackPath_u2dCx2C_VA, long offset, long size, long color, float startCornerRadius, float endCornerRadius) {
        trackPath.rewind();
        Rect track = RectKt.m4089Recttz77jQw(OffsetKt.Offset(Offset.m4049getXimpl(offset) + startCornerRadius, 0.0f), androidx.compose.p001ui.geometry.SizeKt.Size((Size.m4118getWidthimpl(size) - startCornerRadius) - endCornerRadius, Size.m4115getHeightimpl(size)));
        Path.CC.addRect$default(trackPath, track, null, 2, null);
        m2617buildCornerfk0IrS8(offset, size, startCornerRadius, true);
        m2618buildCornerfk0IrS8$default(this, OffsetKt.Offset(track.getRight() - endCornerRadius, 0.0f), size, endCornerRadius, false, 8, null);
        DrawScope.CC.m4854drawPathLG529CI$default($this$drawTrackPath_u2dCx2C_VA, trackPath, color, 0.0f, null, null, 0, 60, null);
        trackPath.rewind();
    }

    /* JADX INFO: renamed from: buildCorner-fk0IrS8$default, reason: not valid java name */
    static /* synthetic */ void m2618buildCornerfk0IrS8$default(SliderDefaults sliderDefaults, long j, long j2, float f, boolean z, int i, Object obj) {
        sliderDefaults.m2617buildCornerfk0IrS8(j, j2, f, (i & 8) != 0 ? false : z);
    }

    /* JADX INFO: renamed from: buildCorner-fk0IrS8, reason: not valid java name */
    private final void m2617buildCornerfk0IrS8(long offset, long size, float cornerRadius, boolean isStart) {
        cornerPath.rewind();
        halfRectPath.rewind();
        RoundRect corner = RoundRectKt.m4104RoundRectsniSvfs(RectKt.m4089Recttz77jQw(offset, androidx.compose.p001ui.geometry.SizeKt.Size(2 * cornerRadius, Size.m4115getHeightimpl(size))), CornerRadiusKt.CornerRadius$default(cornerRadius, 0.0f, 2, null));
        Path.CC.addRoundRect$default(cornerPath, corner, null, 2, null);
        Path.CC.addRect$default(halfRectPath, RectKt.m4089Recttz77jQw(OffsetKt.Offset(corner.getLeft() + (isStart ? cornerRadius : 0.0f), 0.0f), androidx.compose.p001ui.geometry.SizeKt.Size(cornerRadius, Size.m4115getHeightimpl(size))), null, 2, null);
        Path.CC.m4569addPathUv8p0NA$default(trackPath, cornerPath.minus(halfRectPath), 0L, 2, null);
        cornerPath.rewind();
        halfRectPath.rewind();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawStopIndicator-x3O1jOs, reason: not valid java name */
    public final void m2619drawStopIndicatorx3O1jOs(DrawScope $this$drawStopIndicator_u2dx3O1jOs, long offset, float size, long color) {
        DrawScope.CC.m4845drawCircleVaOC9Bg$default($this$drawStopIndicator_u2dx3O1jOs, color, $this$drawStopIndicator_u2dx3O1jOs.mo567toPx0680j_4(size) / 2.0f, offset, 0.0f, null, null, 0, 120, null);
    }
}
