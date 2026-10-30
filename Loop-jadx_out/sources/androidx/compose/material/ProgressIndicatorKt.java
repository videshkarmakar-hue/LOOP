package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.StrokeCap;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.drawscope.Stroke;
import androidx.compose.p001ui.layout.LayoutModifierKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: ProgressIndicator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a0\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001aD\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020#2\b\b\u0002\u0010(\u001a\u00020)H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a8\u0010\u001e\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001aN\u0010\u001e\u001a\u00020\u001f2\b\b\u0001\u0010,\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020#2\b\b\u0002\u0010(\u001a\u00020)H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a0\u00101\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010'\u001a\u00020#H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a:\u00101\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010'\u001a\u00020#2\b\b\u0002\u0010(\u001a\u00020)H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a8\u00101\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010'\u001a\u00020#H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001aD\u00101\u001a\u00020\u001f2\b\b\u0001\u0010,\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010'\u001a\u00020#2\b\b\u0002\u0010(\u001a\u00020)H\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a6\u0010:\u001a\u00020\u001f*\u00020;2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a&\u0010B\u001a\u00020\u001f*\u00020;2\u0006\u0010\"\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a6\u0010E\u001a\u00020\u001f*\u00020;2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0000¢\u0006\u0004\bF\u0010A\u001a>\u0010G\u001a\u00020\u001f*\u00020;2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001a>\u0010J\u001a\u00020\u001f*\u00020;2\u0006\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010(\u001a\u00020)H\u0002ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a.\u0010O\u001a\u00020\u001f*\u00020;2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010(\u001a\u00020)H\u0002ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a\f\u0010R\u001a\u00020!*\u00020!H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0012\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0013\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006S²\u0006\n\u0010T\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010U\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010V\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010W\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010X\u001a\u00020\bX\u008a\u0084\u0002²\u0006\n\u0010Y\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010Z\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010<\u001a\u00020\u0001X\u008a\u0084\u0002"}, m195d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "LinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "StartAngleOffset", "CircularProgressIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "backgroundColor", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", NotificationCompat.CATEGORY_PROGRESS, "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-DUhRLBM", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-_5eSR-E", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorBackground", "drawCircularIndicatorBackground-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "drawLinearIndicatorBackground", "drawLinearIndicatorBackground-AZGd3zU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFI)V", "increaseSemanticsBounds", "material_release", "firstLineHead", "firstLineTail", "secondLineHead", "secondLineTail", "currentRotation", "baseRotation", "endAngle"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    private static final float StartAngleOffset = -90.0f;
    private static final float LinearIndicatorHeight = ProgressIndicatorDefaults.INSTANCE.m1750getStrokeWidthD9Ej5fM();
    private static final float LinearIndicatorWidth = C1979Dp.m6801constructorimpl(240);
    private static final float CircularIndicatorDiameter = C1979Dp.m6801constructorimpl(40);
    private static final CubicBezierEasing FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);
    private static final CubicBezierEasing FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
    private static final CubicBezierEasing SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);
    private static final CubicBezierEasing SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);
    private static final CubicBezierEasing CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);

    public static final Modifier increaseSemanticsBounds(Modifier $this$increaseSemanticsBounds) {
        final float padding = C1979Dp.m6801constructorimpl(10);
        return PaddingKt.m870paddingVpY3zN4$default(SemanticsModifierKt.semantics(LayoutModifierKt.layout($this$increaseSemanticsBounds, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material.ProgressIndicatorKt.increaseSemanticsBounds.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m1770invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m1770invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                final int paddingPx = $this$layout.mo561roundToPx0680j_4(padding);
                long newConstraint = ConstraintsKt.m6763offsetNN6EwU(constraints, 0, paddingPx * 2);
                final Placeable placeable = measurable.mo5644measureBRTryo0(newConstraint);
                int height = placeable.getHeight() - (paddingPx * 2);
                int width = placeable.getWidth();
                return MeasureScope.CC.layout$default($this$layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt.increaseSemanticsBounds.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope $this$layout2) {
                        Placeable.PlacementScope.place$default($this$layout2, placeable, 0, -paddingPx, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        }), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt.increaseSemanticsBounds.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
            }
        }), 0.0f, padding, 1, null);
    }

    /* JADX INFO: renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    public static final void m1757LinearProgressIndicator_5eSRE(final float progress, Modifier modifier, long color, long backgroundColor, int strokeCap, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long color2;
        long backgroundColor2;
        int i2;
        Modifier.Companion modifier3;
        int $dirty;
        int $dirty2;
        long backgroundColor3;
        int $dirty3;
        Modifier modifier4;
        int strokeCap2;
        long backgroundColor4;
        long color3;
        Composer $composer2 = $composer.startRestartGroup(-531984864);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(3,2,1:c#ui.graphics.Color,0:c#ui.graphics.Color,4:c#ui.graphics.StrokeCap)107@5008L6,117@5389L204,112@5208L385:ProgressIndicator.kt#jmzs0o");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty4 |= $composer2.changed(progress) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty4 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                color2 = color;
                int i4 = $composer2.changed(color2) ? 256 : 128;
                $dirty4 |= i4;
            } else {
                color2 = color;
            }
            $dirty4 |= i4;
        } else {
            color2 = color;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                backgroundColor2 = backgroundColor;
                int i5 = $composer2.changed(backgroundColor2) ? 2048 : 1024;
                $dirty4 |= i5;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty4 |= i5;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                i2 = strokeCap;
                int i6 = $composer2.changed(i2) ? 16384 : 8192;
                $dirty4 |= i6;
            } else {
                i2 = strokeCap;
            }
            $dirty4 |= i6;
        } else {
            i2 = strokeCap;
        }
        if (($dirty4 & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            strokeCap2 = i2;
            backgroundColor4 = backgroundColor2;
            modifier4 = modifier2;
            color3 = color2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    $dirty4 &= -897;
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1627getPrimary0d7_KjU();
                }
                if ((i & 8) != 0) {
                    long j = color2;
                    backgroundColor2 = Color.m4289copywmQWz5c(j, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j) : 0.24f, (14 & 2) != 0 ? Color.m4297getRedimpl(j) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j) : 0.0f);
                    $dirty4 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty = $dirty4 & (-57345);
                    $dirty2 = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
                    backgroundColor3 = backgroundColor2;
                } else {
                    $dirty = $dirty4;
                    $dirty2 = i2;
                    backgroundColor3 = backgroundColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty4 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty4 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty = $dirty4 & (-57345);
                    modifier3 = modifier2;
                    $dirty2 = i2;
                    backgroundColor3 = backgroundColor2;
                } else {
                    $dirty = $dirty4;
                    modifier3 = modifier2;
                    $dirty2 = i2;
                    backgroundColor3 = backgroundColor2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-531984864, $dirty, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:110)");
            }
            float $this$fastCoerceAtLeast$iv$iv = progress;
            if ($this$fastCoerceAtLeast$iv$iv < 0.0f) {
                $this$fastCoerceAtLeast$iv$iv = 0.0f;
            }
            if ($this$fastCoerceAtLeast$iv$iv > 1.0f) {
                $this$fastCoerceAtLeast$iv$iv = 1.0f;
            }
            final float minimumValue$iv = $this$fastCoerceAtLeast$iv$iv;
            Modifier modifierM915sizeVpY3zN4 = SizeKt.m915sizeVpY3zN4(ProgressSemanticsKt.progressSemantics$default(increaseSemanticsBounds(modifier3), minimumValue$iv, null, 0, 6, null), LinearIndicatorWidth, LinearIndicatorHeight);
            ComposerKt.sourceInformationMarkerStart($composer2, 96020694, "CC(remember):ProgressIndicator.kt#9igjgp");
            boolean z = true;
            boolean zChanged = (((($dirty & 7168) ^ 3072) > 2048 && $composer2.changed(backgroundColor3)) || ($dirty & 3072) == 2048) | ((((57344 & $dirty) ^ CpioConstants.C_ISBLK) > 16384 && $composer2.changed($dirty2)) || ($dirty & CpioConstants.C_ISBLK) == 16384) | $composer2.changed(minimumValue$iv);
            if (((($dirty & 896) ^ 384) <= 256 || !$composer2.changed(color2)) && ($dirty & 384) != 256) {
                z = false;
            }
            boolean invalid$iv = zChanged | z;
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                $dirty3 = 0;
                final long j2 = backgroundColor3;
                final int i7 = $dirty2;
                final long j3 = color2;
                value$iv = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$1$1
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
                        float strokeWidth = Size.m4115getHeightimpl($this$Canvas.mo4773getSizeNHjbRc());
                        ProgressIndicatorKt.m1769drawLinearIndicatorBackgroundAZGd3zU($this$Canvas, j2, strokeWidth, i7);
                        ProgressIndicatorKt.m1768drawLinearIndicatorqYKTg0g($this$Canvas, 0.0f, minimumValue$iv, j3, strokeWidth, i7);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                $dirty3 = 0;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifierM915sizeVpY3zN4, (Function1) value$iv, $composer2, $dirty3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            strokeCap2 = $dirty2;
            backgroundColor4 = backgroundColor3;
            color3 = color2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final long j4 = color3;
            final long j5 = backgroundColor4;
            final int i8 = strokeCap2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) {
                    ProgressIndicatorKt.m1757LinearProgressIndicator_5eSRE(progress, modifier5, j4, j5, i8, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:105:0x027c  */
    /* JADX WARN: Code duplicated, block: B:108:0x0285  */
    /* JADX WARN: Code duplicated, block: B:109:0x0288  */
    /* JADX WARN: Code duplicated, block: B:113:0x0293  */
    /* JADX WARN: Code duplicated, block: B:116:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:120:0x02bd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:124:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:93:0x024f A[PHI: r5
  0x024f: PHI (r5v15 'backgroundColor' long) = (r5v13 'backgroundColor' long), (r5v16 'backgroundColor' long) binds: [B:92:0x024d, B:88:0x0246] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: LinearProgressIndicator-2cYBFYY, reason: not valid java name */
    public static final void m1755LinearProgressIndicator2cYBFYY(Modifier modifier, long color, long backgroundColor, int strokeCap, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long j2;
        int i2;
        long color2;
        long backgroundColor2;
        Modifier modifier3;
        int strokeCap2;
        long color3;
        int $dirty;
        long backgroundColor3;
        boolean z;
        long color4;
        boolean invalid$iv;
        final int strokeCap3;
        Object value$iv;
        long backgroundColor4;
        Composer $composer2 = $composer.startRestartGroup(1501635280);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(2,1:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)140@6509L6,144@6678L28,148@6960L320,159@7325L320,170@7691L324,181@8061L324,197@8556L624,192@8390L790:ProgressIndicator.kt#jmzs0o");
        int $dirty2 = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                j = color;
                int i4 = $composer2.changed(j) ? 32 : 16;
                $dirty2 |= i4;
            } else {
                j = color;
            }
            $dirty2 |= i4;
        } else {
            j = color;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                j2 = backgroundColor;
                int i5 = $composer2.changed(j2) ? 256 : 128;
                $dirty2 |= i5;
            } else {
                j2 = backgroundColor;
            }
            $dirty2 |= i5;
        } else {
            j2 = backgroundColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                i2 = strokeCap;
                int i6 = $composer2.changed(i2) ? 2048 : 1024;
                $dirty2 |= i6;
            } else {
                i2 = strokeCap;
            }
            $dirty2 |= i6;
        } else {
            i2 = strokeCap;
        }
        if (($dirty2 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            color4 = j;
            backgroundColor4 = j2;
            strokeCap3 = i2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1627getPrimary0d7_KjU();
                    $dirty2 &= -113;
                } else {
                    color2 = j;
                }
                if ((i & 4) != 0) {
                    long j3 = color2;
                    backgroundColor2 = Color.m4289copywmQWz5c(j3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j3) : 0.24f, (14 & 2) != 0 ? Color.m4297getRedimpl(j3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j3) : 0.0f);
                    $dirty2 &= -897;
                } else {
                    backgroundColor2 = j2;
                }
                if ((i & 8) != 0) {
                    modifier3 = modifier4;
                    strokeCap2 = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
                    color3 = color2;
                    $dirty = $dirty2 & (-7169);
                } else {
                    modifier3 = modifier4;
                    strokeCap2 = i2;
                    color3 = color2;
                    $dirty = $dirty2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                modifier3 = modifier2;
                strokeCap2 = i2;
                long j4 = j;
                $dirty = $dirty2;
                backgroundColor2 = j2;
                color3 = j4;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1501635280, $dirty, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:143)");
            }
            InfiniteTransition infiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(null, $composer2, 0, 1);
            boolean z2 = true;
            int $dirty3 = $dirty;
            long backgroundColor5 = backgroundColor2;
            long color5 = color3;
            final State<Float> stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m374infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    keyframesSpecConfig.setDurationMillis(1800);
                    keyframesSpecConfig.using(keyframesSpecConfig.mo11at(Float.valueOf(0.0f), 0), ProgressIndicatorKt.FirstLineHeadEasing);
                    keyframesSpecConfig.mo11at(Float.valueOf(1.0f), 750);
                }
            }), null, 0L, 6, null), null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            final State<Float> stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m374infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    keyframesSpecConfig.setDurationMillis(1800);
                    keyframesSpecConfig.using(keyframesSpecConfig.mo11at(Float.valueOf(0.0f), 333), ProgressIndicatorKt.FirstLineTailEasing);
                    keyframesSpecConfig.mo11at(Float.valueOf(1.0f), 1183);
                }
            }), null, 0L, 6, null), null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            final State<Float> stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m374infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    keyframesSpecConfig.setDurationMillis(1800);
                    keyframesSpecConfig.using(keyframesSpecConfig.mo11at(Float.valueOf(0.0f), 1000), ProgressIndicatorKt.SecondLineHeadEasing);
                    keyframesSpecConfig.mo11at(Float.valueOf(1.0f), 1567);
                }
            }), null, 0L, 6, null), null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            final State<Float> stateAnimateFloat4 = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m374infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    keyframesSpecConfig.setDurationMillis(1800);
                    keyframesSpecConfig.using(keyframesSpecConfig.mo11at(Float.valueOf(0.0f), 1267), ProgressIndicatorKt.SecondLineTailEasing);
                    keyframesSpecConfig.mo11at(Float.valueOf(1.0f), 1800);
                }
            }), null, 0L, 6, null), null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            Modifier modifierM915sizeVpY3zN4 = SizeKt.m915sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(increaseSemanticsBounds(modifier3)), LinearIndicatorWidth, LinearIndicatorHeight);
            ComposerKt.sourceInformationMarkerStart($composer2, 96023861, "CC(remember):ProgressIndicator.kt#9igjgp");
            if ((($dirty3 & 896) ^ 384) > 256) {
                backgroundColor3 = backgroundColor5;
                if ($composer2.changed(backgroundColor3)) {
                    z = true;
                }
                boolean zChanged = z | (((($dirty3 & 7168) ^ 3072) <= 2048 && $composer2.changed(strokeCap2)) || ($dirty3 & 3072) == 2048) | $composer2.changed(stateAnimateFloat) | $composer2.changed(stateAnimateFloat2);
                if ((($dirty3 & 112) ^ 48) > 32) {
                    color4 = color5;
                    if (!$composer2.changed(color4)) {
                    }
                    invalid$iv = zChanged | z2 | $composer2.changed(stateAnimateFloat3) | $composer2.changed(stateAnimateFloat4);
                    Object it$iv = $composer2.rememberedValue();
                    if (!invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        strokeCap3 = strokeCap2;
                        final long j5 = backgroundColor3;
                        final long j6 = color4;
                        value$iv = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$3$1
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
                                float strokeWidth = Size.m4115getHeightimpl($this$Canvas.mo4773getSizeNHjbRc());
                                ProgressIndicatorKt.m1769drawLinearIndicatorBackgroundAZGd3zU($this$Canvas, j5, strokeWidth, strokeCap3);
                                if (ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$1(stateAnimateFloat) - ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$2(stateAnimateFloat2) > 0.0f) {
                                    ProgressIndicatorKt.m1768drawLinearIndicatorqYKTg0g($this$Canvas, ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$1(stateAnimateFloat), ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$2(stateAnimateFloat2), j6, strokeWidth, strokeCap3);
                                }
                                if (ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$3(stateAnimateFloat3) - ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$4(stateAnimateFloat4) > 0.0f) {
                                    ProgressIndicatorKt.m1768drawLinearIndicatorqYKTg0g($this$Canvas, ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$3(stateAnimateFloat3), ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$4(stateAnimateFloat4), j6, strokeWidth, strokeCap3);
                                }
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                        strokeCap3 = strokeCap2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    CanvasKt.Canvas(modifierM915sizeVpY3zN4, (Function1) value$iv, $composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    backgroundColor4 = backgroundColor3;
                } else {
                    color4 = color5;
                }
                if (($dirty3 & 48) != 32) {
                    z2 = false;
                }
                invalid$iv = zChanged | z2 | $composer2.changed(stateAnimateFloat3) | $composer2.changed(stateAnimateFloat4);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                strokeCap3 = strokeCap2;
                final long j7 = backgroundColor3;
                final long j8 = color4;
                value$iv = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$3$1
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
                        float strokeWidth = Size.m4115getHeightimpl($this$Canvas.mo4773getSizeNHjbRc());
                        ProgressIndicatorKt.m1769drawLinearIndicatorBackgroundAZGd3zU($this$Canvas, j7, strokeWidth, strokeCap3);
                        if (ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$1(stateAnimateFloat) - ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$2(stateAnimateFloat2) > 0.0f) {
                            ProgressIndicatorKt.m1768drawLinearIndicatorqYKTg0g($this$Canvas, ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$1(stateAnimateFloat), ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$2(stateAnimateFloat2), j8, strokeWidth, strokeCap3);
                        }
                        if (ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$3(stateAnimateFloat3) - ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$4(stateAnimateFloat4) > 0.0f) {
                            ProgressIndicatorKt.m1768drawLinearIndicatorqYKTg0g($this$Canvas, ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$3(stateAnimateFloat3), ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$4(stateAnimateFloat4), j8, strokeWidth, strokeCap3);
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                CanvasKt.Canvas(modifierM915sizeVpY3zN4, (Function1) value$iv, $composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                backgroundColor4 = backgroundColor3;
            } else {
                backgroundColor3 = backgroundColor5;
            }
            if (($dirty3 & 384) == 256) {
                z = true;
            } else {
                z = false;
            }
            boolean zChanged2 = z | (((($dirty3 & 7168) ^ 3072) <= 2048 && $composer2.changed(strokeCap2)) || ($dirty3 & 3072) == 2048) | $composer2.changed(stateAnimateFloat) | $composer2.changed(stateAnimateFloat2);
            if ((($dirty3 & 112) ^ 48) > 32) {
                color4 = color5;
                if (!$composer2.changed(color4)) {
                }
                invalid$iv = zChanged2 | z2 | $composer2.changed(stateAnimateFloat3) | $composer2.changed(stateAnimateFloat4);
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                strokeCap3 = strokeCap2;
                final long j9 = backgroundColor3;
                final long j10 = color4;
                value$iv = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$3$1
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
                        float strokeWidth = Size.m4115getHeightimpl($this$Canvas.mo4773getSizeNHjbRc());
                        ProgressIndicatorKt.m1769drawLinearIndicatorBackgroundAZGd3zU($this$Canvas, j9, strokeWidth, strokeCap3);
                        if (ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$1(stateAnimateFloat) - ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$2(stateAnimateFloat2) > 0.0f) {
                            ProgressIndicatorKt.m1768drawLinearIndicatorqYKTg0g($this$Canvas, ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$1(stateAnimateFloat), ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$2(stateAnimateFloat2), j10, strokeWidth, strokeCap3);
                        }
                        if (ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$3(stateAnimateFloat3) - ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$4(stateAnimateFloat4) > 0.0f) {
                            ProgressIndicatorKt.m1768drawLinearIndicatorqYKTg0g($this$Canvas, ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$3(stateAnimateFloat3), ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$4(stateAnimateFloat4), j10, strokeWidth, strokeCap3);
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                CanvasKt.Canvas(modifierM915sizeVpY3zN4, (Function1) value$iv, $composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                backgroundColor4 = backgroundColor3;
            } else {
                color4 = color5;
            }
            if (($dirty3 & 48) != 32) {
                z2 = false;
            }
            invalid$iv = zChanged2 | z2 | $composer2.changed(stateAnimateFloat3) | $composer2.changed(stateAnimateFloat4);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            strokeCap3 = strokeCap2;
            final long j11 = backgroundColor3;
            final long j12 = color4;
            value$iv = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$3$1
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
                    float strokeWidth = Size.m4115getHeightimpl($this$Canvas.mo4773getSizeNHjbRc());
                    ProgressIndicatorKt.m1769drawLinearIndicatorBackgroundAZGd3zU($this$Canvas, j11, strokeWidth, strokeCap3);
                    if (ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$1(stateAnimateFloat) - ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$2(stateAnimateFloat2) > 0.0f) {
                        ProgressIndicatorKt.m1768drawLinearIndicatorqYKTg0g($this$Canvas, ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$1(stateAnimateFloat), ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$2(stateAnimateFloat2), j12, strokeWidth, strokeCap3);
                    }
                    if (ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$3(stateAnimateFloat3) - ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$4(stateAnimateFloat4) > 0.0f) {
                        ProgressIndicatorKt.m1768drawLinearIndicatorqYKTg0g($this$Canvas, ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$3(stateAnimateFloat3), ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$4(stateAnimateFloat4), j12, strokeWidth, strokeCap3);
                    }
                }
            };
            $composer2.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifierM915sizeVpY3zN4, (Function1) value$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            backgroundColor4 = backgroundColor3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final long j13 = color4;
            final long j14 = backgroundColor4;
            final int i7 = strokeCap3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i8) {
                    ProgressIndicatorKt.m1755LinearProgressIndicator2cYBFYY(modifier5, j13, j14, i7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearProgressIndicator_2cYBFYY$lambda$1(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearProgressIndicator_2cYBFYY$lambda$2(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearProgressIndicator_2cYBFYY$lambda$3(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearProgressIndicator_2cYBFYY$lambda$4(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: LinearProgressIndicator-eaDK9VM, reason: not valid java name */
    public static final /* synthetic */ void m1758LinearProgressIndicatoreaDK9VM(final float progress, Modifier modifier, long color, long backgroundColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long j2;
        Modifier.Companion modifier3;
        long color2;
        long backgroundColor2;
        Modifier modifier4;
        long color3;
        long backgroundColor3;
        Composer $composer2 = $composer.startRestartGroup(-850309746);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(3,2,1:c#ui.graphics.Color,0:c#ui.graphics.Color)226@9398L6,228@9494L118:ProgressIndicator.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(progress) ? 4 : 2;
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
                j = color;
                int i3 = $composer2.changed(j) ? 256 : 128;
                $dirty |= i3;
            } else {
                j = color;
            }
            $dirty |= i3;
        } else {
            j = color;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                j2 = backgroundColor;
                int i4 = $composer2.changed(j2) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                j2 = backgroundColor;
            }
            $dirty |= i4;
        } else {
            j2 = backgroundColor;
        }
        if (($dirty & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            backgroundColor3 = j2;
            modifier4 = modifier2;
            color3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1627getPrimary0d7_KjU();
                    $dirty &= -897;
                } else {
                    color2 = j;
                }
                if ((i & 8) != 0) {
                    long j3 = color2;
                    backgroundColor2 = Color.m4289copywmQWz5c(j3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j3) : 0.24f, (14 & 2) != 0 ? Color.m4297getRedimpl(j3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j3) : 0.0f);
                    $dirty &= -7169;
                } else {
                    backgroundColor2 = j2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                modifier3 = modifier2;
                color2 = j;
                backgroundColor2 = j2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-850309746, $dirty, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:228)");
            }
            m1757LinearProgressIndicator_5eSRE(progress, modifier3, color2, backgroundColor2, StrokeCap.INSTANCE.m4652getButtKaPHkGw(), $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            color3 = color2;
            backgroundColor3 = backgroundColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final long j4 = color3;
            final long j5 = backgroundColor3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$5
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
                    ProgressIndicatorKt.m1758LinearProgressIndicatoreaDK9VM(progress, modifier5, j4, j5, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: LinearProgressIndicator-RIQooxk, reason: not valid java name */
    public static final /* synthetic */ void m1756LinearProgressIndicatorRIQooxk(Modifier modifier, long color, long backgroundColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long j2;
        Modifier.Companion modifier3;
        long color2;
        long backgroundColor2;
        Modifier modifier4;
        long color3;
        long backgroundColor3;
        Composer $composer2 = $composer.startRestartGroup(-819397058);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(2,1:c#ui.graphics.Color,0:c#ui.graphics.Color)240@9807L6,242@9903L104:ProgressIndicator.kt#jmzs0o");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                j = color;
                int i3 = $composer2.changed(j) ? 32 : 16;
                $dirty |= i3;
            } else {
                j = color;
            }
            $dirty |= i3;
        } else {
            j = color;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                j2 = backgroundColor;
                int i4 = $composer2.changed(j2) ? 256 : 128;
                $dirty |= i4;
            } else {
                j2 = backgroundColor;
            }
            $dirty |= i4;
        } else {
            j2 = backgroundColor;
        }
        if (($dirty & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            backgroundColor3 = j2;
            modifier4 = modifier2;
            color3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1627getPrimary0d7_KjU();
                    $dirty &= -113;
                } else {
                    color2 = j;
                }
                if ((i & 4) != 0) {
                    long j3 = color2;
                    backgroundColor2 = Color.m4289copywmQWz5c(j3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j3) : 0.24f, (14 & 2) != 0 ? Color.m4297getRedimpl(j3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j3) : 0.0f);
                    $dirty &= -897;
                } else {
                    backgroundColor2 = j2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier3 = modifier2;
                color2 = j;
                backgroundColor2 = j2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-819397058, $dirty, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:242)");
            }
            m1755LinearProgressIndicator2cYBFYY(modifier3, color2, backgroundColor2, StrokeCap.INSTANCE.m4652getButtKaPHkGw(), $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            color3 = color2;
            backgroundColor3 = backgroundColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final long j4 = color3;
            final long j5 = backgroundColor3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$6
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
                    ProgressIndicatorKt.m1756LinearProgressIndicatorRIQooxk(modifier5, j4, j5, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawLinearIndicator-qYKTg0g, reason: not valid java name */
    public static final void m1768drawLinearIndicatorqYKTg0g(DrawScope $this$drawLinearIndicator_u2dqYKTg0g, float startFraction, float endFraction, long color, float strokeWidth, int strokeCap) {
        float width = Size.m4118getWidthimpl($this$drawLinearIndicator_u2dqYKTg0g.mo4773getSizeNHjbRc());
        float height = Size.m4115getHeightimpl($this$drawLinearIndicator_u2dqYKTg0g.mo4773getSizeNHjbRc());
        float f = 2;
        float yOffset = height / f;
        boolean isLtr = $this$drawLinearIndicator_u2dqYKTg0g.getLayoutDirection() == LayoutDirection.Ltr;
        float barStart = (isLtr ? startFraction : 1.0f - endFraction) * width;
        float barEnd = (isLtr ? endFraction : 1.0f - startFraction) * width;
        if (StrokeCap.m4648equalsimpl0(strokeCap, StrokeCap.INSTANCE.m4652getButtKaPHkGw()) || height > width) {
            DrawScope.CC.m4850drawLineNGM6Ib0$default($this$drawLinearIndicator_u2dqYKTg0g, color, OffsetKt.Offset(barStart, yOffset), OffsetKt.Offset(barEnd, yOffset), strokeWidth, 0, null, 0.0f, null, 0, 496, null);
            return;
        }
        float strokeCapOffset = strokeWidth / f;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo = RangesKt.rangeTo(strokeCapOffset, width - strokeCapOffset);
        float adjustedBarStart = ((Number) RangesKt.coerceIn(Float.valueOf(barStart), closedFloatingPointRangeRangeTo)).floatValue();
        float adjustedBarEnd = ((Number) RangesKt.coerceIn(Float.valueOf(barEnd), closedFloatingPointRangeRangeTo)).floatValue();
        if (Math.abs(endFraction - startFraction) > 0.0f) {
            DrawScope.CC.m4850drawLineNGM6Ib0$default($this$drawLinearIndicator_u2dqYKTg0g, color, OffsetKt.Offset(adjustedBarStart, yOffset), OffsetKt.Offset(adjustedBarEnd, yOffset), strokeWidth, strokeCap, null, 0.0f, null, 0, 480, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawLinearIndicatorBackground-AZGd3zU, reason: not valid java name */
    public static final void m1769drawLinearIndicatorBackgroundAZGd3zU(DrawScope $this$drawLinearIndicatorBackground_u2dAZGd3zU, long color, float strokeWidth, int strokeCap) {
        m1768drawLinearIndicatorqYKTg0g($this$drawLinearIndicatorBackground_u2dAZGd3zU, 0.0f, 1.0f, color, strokeWidth, strokeCap);
    }

    /* JADX INFO: renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    public static final void m1751CircularProgressIndicatorDUhRLBM(final float progress, Modifier modifier, long color, float strokeWidth, long backgroundColor, int strokeCap, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long color2;
        float strokeWidth2;
        long backgroundColor2;
        int strokeCap2;
        Modifier.Companion modifier3;
        Modifier modifier4;
        Object value$iv;
        int strokeCap3;
        long backgroundColor3;
        long backgroundColor4;
        float strokeWidth3;
        Composer $composer2 = $composer.startRestartGroup(1746618448);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(3,2,1:c#ui.graphics.Color,5:c#ui.unit.Dp,0:c#ui.graphics.Color,4:c#ui.graphics.StrokeCap)322@13149L6,*328@13412L7,335@13617L251,331@13493L375:ProgressIndicator.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(progress) ? 4 : 2;
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
                color2 = color;
                int i3 = $composer2.changed(color2) ? 256 : 128;
                $dirty |= i3;
            } else {
                color2 = color;
            }
            $dirty |= i3;
        } else {
            color2 = color;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            strokeWidth2 = strokeWidth;
        } else if (($changed & 3072) == 0) {
            strokeWidth2 = strokeWidth;
            $dirty |= $composer2.changed(strokeWidth2) ? 2048 : 1024;
        } else {
            strokeWidth2 = strokeWidth;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            backgroundColor2 = backgroundColor;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            backgroundColor2 = backgroundColor;
            $dirty |= $composer2.changed(backgroundColor2) ? 16384 : 8192;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            if ((i & 32) == 0) {
                strokeCap2 = strokeCap;
                int i6 = $composer2.changed(strokeCap2) ? 131072 : 65536;
                $dirty |= i6;
            } else {
                strokeCap2 = strokeCap;
            }
            $dirty |= i6;
        } else {
            strokeCap2 = strokeCap;
        }
        if (($dirty & 74899) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            strokeCap3 = strokeCap2;
            strokeWidth3 = strokeWidth2;
            backgroundColor3 = backgroundColor2;
            backgroundColor4 = color2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1627getPrimary0d7_KjU();
                }
                if (i4 != 0) {
                    strokeWidth2 = ProgressIndicatorDefaults.INSTANCE.m1750getStrokeWidthD9Ej5fM();
                }
                if (i5 != 0) {
                    backgroundColor2 = Color.INSTANCE.m4326getTransparent0d7_KjU();
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    strokeCap2 = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    modifier3 = modifier2;
                } else {
                    modifier3 = modifier2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1746618448, $dirty, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:326)");
            }
            float $this$fastCoerceAtLeast$iv$iv = progress;
            if ($this$fastCoerceAtLeast$iv$iv < 0.0f) {
                $this$fastCoerceAtLeast$iv$iv = 0.0f;
            }
            if ($this$fastCoerceAtLeast$iv$iv > 1.0f) {
                $this$fastCoerceAtLeast$iv$iv = 1.0f;
            }
            final float minimumValue$iv = $this$fastCoerceAtLeast$iv$iv;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$CircularProgressIndicator_DUhRLBM_u24lambda_u246 = (Density) objConsume;
            final Stroke stroke = new Stroke($this$CircularProgressIndicator_DUhRLBM_u24lambda_u246.mo567toPx0680j_4(strokeWidth2), 0.0f, strokeCap2, 0, null, 26, null);
            Modifier modifierM913size3ABfNKs = SizeKt.m913size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier3, minimumValue$iv, null, 0, 6, null), CircularIndicatorDiameter);
            ComposerKt.sourceInformationMarkerStart($composer2, 1769714804, "CC(remember):ProgressIndicator.kt#9igjgp");
            modifier4 = modifier3;
            boolean z = true;
            boolean zChanged = ((57344 & $dirty) == 16384) | $composer2.changed(minimumValue$iv) | $composer2.changedInstance(stroke);
            if (((($dirty & 896) ^ 384) <= 256 || !$composer2.changed(color2)) && ($dirty & 384) != 256) {
                z = false;
            }
            boolean invalid$iv = zChanged | z;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                final long j = backgroundColor2;
                final long j2 = color2;
                value$iv = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1
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
                        float sweep = minimumValue$iv * 360.0f;
                        ProgressIndicatorKt.m1765drawCircularIndicatorBackgroundbw27NRU($this$Canvas, j, stroke);
                        ProgressIndicatorKt.m1766drawDeterminateCircularIndicator42QJj7c($this$Canvas, 270.0f, sweep, j2, stroke);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifierM913size3ABfNKs, (Function1) value$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            strokeCap3 = strokeCap2;
            backgroundColor3 = backgroundColor2;
            backgroundColor4 = color2;
            strokeWidth3 = strokeWidth2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final long j3 = backgroundColor4;
            final float f = strokeWidth3;
            final long j4 = backgroundColor3;
            final int i7 = strokeCap3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i8) {
                    ProgressIndicatorKt.m1751CircularProgressIndicatorDUhRLBM(progress, modifier5, j3, f, j4, i7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: CircularProgressIndicator-LxG7B9w, reason: not valid java name */
    public static final void m1752CircularProgressIndicatorLxG7B9w(Modifier modifier, long color, float strokeWidth, long backgroundColor, int strokeCap, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        float strokeWidth2;
        long backgroundColor2;
        int i2;
        long color2;
        Modifier modifier3;
        float strokeWidth3;
        int strokeCap2;
        long backgroundColor3;
        int $dirty;
        long color3;
        int $dirty2;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1119119072);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(2,1:c#ui.graphics.Color,4:c#ui.unit.Dp,0:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)361@14861L6,*366@15070L7,370@15169L28,372@15327L278,384@15720L230,395@16068L346,407@16449L355,422@16918L538,418@16809L647:ProgressIndicator.kt#jmzs0o");
        int $dirty3 = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty3 |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                j = color;
                int i4 = $composer2.changed(j) ? 32 : 16;
                $dirty3 |= i4;
            } else {
                j = color;
            }
            $dirty3 |= i4;
        } else {
            j = color;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty3 |= 384;
            strokeWidth2 = strokeWidth;
        } else if (($changed & 384) == 0) {
            strokeWidth2 = strokeWidth;
            $dirty3 |= $composer2.changed(strokeWidth2) ? 256 : 128;
        } else {
            strokeWidth2 = strokeWidth;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty3 |= 3072;
            backgroundColor2 = backgroundColor;
        } else if (($changed & 3072) == 0) {
            backgroundColor2 = backgroundColor;
            $dirty3 |= $composer2.changed(backgroundColor2) ? 2048 : 1024;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                i2 = strokeCap;
                int i7 = $composer2.changed(i2) ? 16384 : 8192;
                $dirty3 |= i7;
            } else {
                i2 = strokeCap;
            }
            $dirty3 |= i7;
        } else {
            i2 = strokeCap;
        }
        if (($dirty3 & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            $dirty2 = $dirty3;
            modifier3 = modifier2;
            strokeWidth3 = strokeWidth2;
            strokeCap2 = i2;
            backgroundColor3 = backgroundColor2;
            color3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1627getPrimary0d7_KjU();
                    $dirty3 &= -113;
                } else {
                    color2 = j;
                }
                if (i5 != 0) {
                    strokeWidth2 = ProgressIndicatorDefaults.INSTANCE.m1750getStrokeWidthD9Ej5fM();
                }
                if (i6 != 0) {
                    backgroundColor2 = Color.INSTANCE.m4326getTransparent0d7_KjU();
                }
                if ((i & 16) != 0) {
                    $dirty = $dirty3 & (-57345);
                    modifier3 = modifier4;
                    strokeCap2 = StrokeCap.INSTANCE.m4654getSquareKaPHkGw();
                    strokeWidth3 = strokeWidth2;
                    backgroundColor3 = backgroundColor2;
                    color3 = color2;
                } else {
                    modifier3 = modifier4;
                    strokeWidth3 = strokeWidth2;
                    strokeCap2 = i2;
                    backgroundColor3 = backgroundColor2;
                    $dirty = $dirty3;
                    color3 = color2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty3 &= -113;
                }
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                modifier3 = modifier2;
                strokeWidth3 = strokeWidth2;
                strokeCap2 = i2;
                backgroundColor3 = backgroundColor2;
                $dirty = $dirty3;
                color3 = j;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1119119072, $dirty, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:365)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$CircularProgressIndicator_LxG7B9w_u24lambda_u248 = (Density) objConsume;
            final Stroke stroke = new Stroke($this$CircularProgressIndicator_LxG7B9w_u24lambda_u248.mo567toPx0680j_4(strokeWidth3), 0.0f, strokeCap2, 0, null, 26, null);
            InfiniteTransition transition = InfiniteTransitionKt.rememberInfiniteTransition(null, $composer2, 0, 1);
            boolean z = true;
            $dirty2 = $dirty;
            final State currentRotation$delegate = InfiniteTransitionKt.animateValue(transition, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m374infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 12), 16);
            final State<Float> stateAnimateFloat = InfiniteTransitionKt.animateFloat(transition, 0.0f, BaseRotationAngle, AnimationSpecKt.m374infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            final State<Float> stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(transition, 0.0f, JumpRotationAngle, AnimationSpecKt.m374infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$endAngle$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    keyframesSpecConfig.setDurationMillis(1332);
                    keyframesSpecConfig.using(keyframesSpecConfig.mo11at(Float.valueOf(0.0f), 0), ProgressIndicatorKt.CircularEasing);
                    keyframesSpecConfig.mo11at(Float.valueOf(290.0f), 666);
                }
            }), null, 0L, 6, null), null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            final State<Float> stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(transition, 0.0f, JumpRotationAngle, AnimationSpecKt.m374infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$startAngle$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    keyframesSpecConfig.setDurationMillis(1332);
                    keyframesSpecConfig.using(keyframesSpecConfig.mo11at(Float.valueOf(0.0f), 666), ProgressIndicatorKt.CircularEasing);
                    keyframesSpecConfig.mo11at(Float.valueOf(290.0f), keyframesSpecConfig.getDurationMillis());
                }
            }), null, 0L, 6, null), null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            Modifier modifierM913size3ABfNKs = SizeKt.m913size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), CircularIndicatorDiameter);
            ComposerKt.sourceInformationMarkerStart($composer2, 1769718105, "CC(remember):ProgressIndicator.kt#9igjgp");
            boolean zChangedInstance = (($dirty2 & 7168) == 2048) | $composer2.changedInstance(stroke) | $composer2.changed(currentRotation$delegate) | $composer2.changed(stateAnimateFloat2) | $composer2.changed(stateAnimateFloat3) | $composer2.changed(stateAnimateFloat) | (($dirty2 & 896) == 256);
            if (((($dirty2 & 112) ^ 48) <= 32 || !$composer2.changed(color3)) && ($dirty2 & 48) != 32) {
                z = false;
            }
            boolean invalid$iv = zChangedInstance | z;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                final long j2 = backgroundColor3;
                final float f = strokeWidth3;
                final long j3 = color3;
                value$iv = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1
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
                        ProgressIndicatorKt.m1765drawCircularIndicatorBackgroundbw27NRU($this$Canvas, j2, stroke);
                        float currentRotationAngleOffset = (ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$9(currentRotation$delegate) * 216.0f) % 360.0f;
                        float sweep = Math.abs(ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$11(stateAnimateFloat2) - ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$12(stateAnimateFloat3));
                        float offset = (-90.0f) + currentRotationAngleOffset + ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$10(stateAnimateFloat);
                        ProgressIndicatorKt.m1767drawIndeterminateCircularIndicatorhrjfTZI($this$Canvas, ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$12(stateAnimateFloat3) + offset, f, sweep, j3, stroke);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifierM913size3ABfNKs, (Function1) value$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final long j4 = color3;
            final float f2 = strokeWidth3;
            final long j5 = backgroundColor3;
            final int i8 = strokeCap2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) {
                    ProgressIndicatorKt.m1752CircularProgressIndicatorLxG7B9w(modifier5, j4, f2, j5, i8, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int CircularProgressIndicator_LxG7B9w$lambda$9(State<Integer> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircularProgressIndicator_LxG7B9w$lambda$10(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircularProgressIndicator_LxG7B9w$lambda$11(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircularProgressIndicator_LxG7B9w$lambda$12(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: CircularProgressIndicator-MBs18nI, reason: not valid java name */
    public static final /* synthetic */ void m1753CircularProgressIndicatorMBs18nI(final float progress, Modifier modifier, long color, float strokeWidth, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        float f;
        Modifier.Companion modifier3;
        long color2;
        float strokeWidth2;
        Modifier modifier4;
        long color3;
        float strokeWidth3;
        Composer $composer2 = $composer.startRestartGroup(-409649739);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.unit.Dp)441@17676L6,443@17756L157:ProgressIndicator.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(progress) ? 4 : 2;
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
                j = color;
                int i3 = $composer2.changed(j) ? 256 : 128;
                $dirty |= i3;
            } else {
                j = color;
            }
            $dirty |= i3;
        } else {
            j = color;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            f = strokeWidth;
        } else if (($changed & 3072) == 0) {
            f = strokeWidth;
            $dirty |= $composer2.changed(f) ? 2048 : 1024;
        } else {
            f = strokeWidth;
        }
        if (($dirty & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            strokeWidth3 = f;
            color3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1627getPrimary0d7_KjU();
                    $dirty &= -897;
                } else {
                    color2 = j;
                }
                strokeWidth2 = i4 != 0 ? ProgressIndicatorDefaults.INSTANCE.m1750getStrokeWidthD9Ej5fM() : f;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier3 = modifier2;
                color2 = j;
                strokeWidth2 = f;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-409649739, $dirty, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:443)");
            }
            m1751CircularProgressIndicatorDUhRLBM(progress, modifier3, color2, strokeWidth2, Color.INSTANCE.m4326getTransparent0d7_KjU(), StrokeCap.INSTANCE.m4652getButtKaPHkGw(), $composer2, ($dirty & 14) | CpioConstants.C_ISBLK | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            color3 = color2;
            strokeWidth3 = strokeWidth2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final long j2 = color3;
            final float f2 = strokeWidth3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$5
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
                    ProgressIndicatorKt.m1753CircularProgressIndicatorMBs18nI(progress, modifier5, j2, f2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: CircularProgressIndicator-aM-cp0Q, reason: not valid java name */
    public static final /* synthetic */ void m1754CircularProgressIndicatoraMcp0Q(Modifier modifier, long color, float strokeWidth, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        float f;
        Modifier.Companion modifier3;
        long color2;
        float strokeWidth2;
        Modifier modifier4;
        long color3;
        float strokeWidth3;
        Composer $composer2 = $composer.startRestartGroup(-392089979);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.unit.Dp)456@18110L6,458@18190L145:ProgressIndicator.kt#jmzs0o");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                j = color;
                int i3 = $composer2.changed(j) ? 32 : 16;
                $dirty |= i3;
            } else {
                j = color;
            }
            $dirty |= i3;
        } else {
            j = color;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            f = strokeWidth;
        } else if (($changed & 384) == 0) {
            f = strokeWidth;
            $dirty |= $composer2.changed(f) ? 256 : 128;
        } else {
            f = strokeWidth;
        }
        if (($dirty & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            strokeWidth3 = f;
            color3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1627getPrimary0d7_KjU();
                    $dirty &= -113;
                } else {
                    color2 = j;
                }
                strokeWidth2 = i4 != 0 ? ProgressIndicatorDefaults.INSTANCE.m1750getStrokeWidthD9Ej5fM() : f;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                modifier3 = modifier2;
                color2 = j;
                strokeWidth2 = f;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-392089979, $dirty, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:458)");
            }
            m1752CircularProgressIndicatorLxG7B9w(modifier3, color2, strokeWidth2, Color.INSTANCE.m4326getTransparent0d7_KjU(), StrokeCap.INSTANCE.m4654getSquareKaPHkGw(), $composer2, ($dirty & 14) | 3072 | ($dirty & 112) | ($dirty & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            color3 = color2;
            strokeWidth3 = strokeWidth2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final long j2 = color3;
            final float f2 = strokeWidth3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$6
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
                    ProgressIndicatorKt.m1754CircularProgressIndicatoraMcp0Q(modifier5, j2, f2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m1764drawCircularIndicator42QJj7c(DrawScope $this$drawCircularIndicator_u2d42QJj7c, float startAngle, float sweep, long color, Stroke stroke) {
        float f = 2;
        float diameterOffset = stroke.getWidth() / f;
        float arcDimen = Size.m4118getWidthimpl($this$drawCircularIndicator_u2d42QJj7c.mo4773getSizeNHjbRc()) - (f * diameterOffset);
        DrawScope.CC.m4843drawArcyD3GUKo$default($this$drawCircularIndicator_u2d42QJj7c, color, startAngle, sweep, false, OffsetKt.Offset(diameterOffset, diameterOffset), androidx.compose.p001ui.geometry.SizeKt.Size(arcDimen, arcDimen), 0.0f, stroke, null, 0, 832, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawCircularIndicatorBackground-bw27NRU, reason: not valid java name */
    public static final void m1765drawCircularIndicatorBackgroundbw27NRU(DrawScope $this$drawCircularIndicatorBackground_u2dbw27NRU, long color, Stroke stroke) {
        m1764drawCircularIndicator42QJj7c($this$drawCircularIndicatorBackground_u2dbw27NRU, 0.0f, 360.0f, color, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawDeterminateCircularIndicator-42QJj7c, reason: not valid java name */
    public static final void m1766drawDeterminateCircularIndicator42QJj7c(DrawScope $this$drawDeterminateCircularIndicator_u2d42QJj7c, float startAngle, float sweep, long color, Stroke stroke) {
        m1764drawCircularIndicator42QJj7c($this$drawDeterminateCircularIndicator_u2d42QJj7c, startAngle, sweep, color, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawIndeterminateCircularIndicator-hrjfTZI, reason: not valid java name */
    public static final void m1767drawIndeterminateCircularIndicatorhrjfTZI(DrawScope $this$drawIndeterminateCircularIndicator_u2dhrjfTZI, float startAngle, float strokeWidth, float sweep, long color, Stroke stroke) {
        float strokeCapOffset;
        if (StrokeCap.m4648equalsimpl0(stroke.getCap(), StrokeCap.INSTANCE.m4652getButtKaPHkGw())) {
            strokeCapOffset = 0.0f;
        } else {
            float arg0$iv = CircularIndicatorDiameter;
            float other$iv = strokeWidth / C1979Dp.m6801constructorimpl(arg0$iv / 2);
            strokeCapOffset = (other$iv * 57.29578f) / 2.0f;
        }
        float adjustedStartAngle = startAngle + strokeCapOffset;
        float adjustedSweep = Math.max(sweep, 0.1f);
        m1764drawCircularIndicator42QJj7c($this$drawIndeterminateCircularIndicator_u2dhrjfTZI, adjustedStartAngle, adjustedSweep, color, stroke);
    }
}
