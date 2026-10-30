package androidx.compose.material3;

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
import androidx.compose.material3.tokens.ProgressIndicatorTokens;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.StrokeCap;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.drawscope.Stroke;
import androidx.compose.p001ui.layout.LayoutModifierKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.semantics.ProgressBarRangeInfo;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
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
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: ProgressIndicator.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0013\u001aR\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\\\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a0\u0010%\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001aD\u0010%\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a8\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001aL\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010;\u001aH\u0010<\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001ao\u0010<\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020\u00052\u001b\b\u0002\u0010?\u001a\u0015\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020&\u0018\u00010@¢\u0006\u0002\bBH\u0007ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a0\u0010<\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+H\u0007ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a:\u0010<\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\bG\u0010H\u001aD\u0010<\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u001a8\u0010<\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+H\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001aB\u0010<\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b=\u0010M\u001a6\u0010N\u001a\u00020&*\u00020A2\u0006\u0010O\u001a\u00020\u00012\u0006\u0010P\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010Q\u001a\u00020RH\u0002ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a&\u0010U\u001a\u00020&*\u00020A2\u0006\u0010*\u001a\u00020+2\u0006\u0010Q\u001a\u00020RH\u0002ø\u0001\u0000¢\u0006\u0004\bV\u0010W\u001a6\u0010X\u001a\u00020&*\u00020A2\u0006\u0010O\u001a\u00020\u00012\u0006\u0010P\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010Q\u001a\u00020RH\u0002ø\u0001\u0000¢\u0006\u0004\bY\u0010T\u001a>\u0010Z\u001a\u00020&*\u00020A2\u0006\u0010O\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010Q\u001a\u00020RH\u0002ø\u0001\u0000¢\u0006\u0004\b[\u0010\\\u001a>\u0010]\u001a\u00020&*\u00020A2\u0006\u0010^\u001a\u00020\u00012\u0006\u0010_\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\b`\u0010a\u001a,\u0010?\u001a\u00020&*\u00020A2\u0006\u0010b\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\u0006\u0010.\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\bc\u0010d\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0016\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0007\"\u0016\u0010\u0018\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0019\u0010\u0007\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010#\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u000e\u0010$\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006e"}, m195d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "getCircularIndicatorDiameter", "()F", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "IncreaseSemanticsBounds", "Landroidx/compose/ui/Modifier;", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "getLinearIndicatorHeight", "LinearIndicatorWidth", "getLinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "SemanticsBoundsPadding", "StartAngleOffset", "CircularProgressIndicator", "", NotificationCompat.CATEGORY_PROGRESS, "Lkotlin/Function0;", "modifier", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "trackColor", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "CircularProgressIndicator-DUhRLBM", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "gapSize", "CircularProgressIndicator-IyT6zlY", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JFJIFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "LinearProgressIndicator-_5eSR-E", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "drawStopIndicator", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "LinearProgressIndicator-GJbTh5U", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJIFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-rIrjwxo", "(Landroidx/compose/ui/Modifier;JJIFLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorTrack", "drawCircularIndicatorTrack-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "stopSize", "drawStopIndicator-EgI2THU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJI)V", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    private static final CubicBezierEasing CircularEasing;
    private static final float CircularIndicatorDiameter;
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    private static final CubicBezierEasing FirstLineHeadEasing;
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    private static final CubicBezierEasing FirstLineTailEasing;
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    private static final CubicBezierEasing SecondLineHeadEasing;
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    private static final CubicBezierEasing SecondLineTailEasing;
    private static final float StartAngleOffset = -90.0f;
    private static final float SemanticsBoundsPadding = C1979Dp.m6801constructorimpl(10);
    private static final Modifier IncreaseSemanticsBounds = PaddingKt.m870paddingVpY3zN4$default(SemanticsModifierKt.semantics(LayoutModifierKt.layout(Modifier.INSTANCE, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ProgressIndicatorKt$IncreaseSemanticsBounds$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
            return m2509invoke3p2s80s(measureScope, measurable, constraints.getValue());
        }

        /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
        public final MeasureResult m2509invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
            final int paddingPx = $this$layout.mo561roundToPx0680j_4(ProgressIndicatorKt.SemanticsBoundsPadding);
            long newConstraint = ConstraintsKt.m6763offsetNN6EwU(constraints, 0, paddingPx * 2);
            final Placeable placeable = measurable.mo5644measureBRTryo0(newConstraint);
            int height = placeable.getHeight() - (paddingPx * 2);
            int width = placeable.getWidth();
            return MeasureScope.CC.layout$default($this$layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$IncreaseSemanticsBounds$1.1
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
    }), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$IncreaseSemanticsBounds$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            invoke2(semanticsPropertyReceiver);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
        }
    }), 0.0f, SemanticsBoundsPadding, 1, null);
    private static final float LinearIndicatorWidth = C1979Dp.m6801constructorimpl(240);
    private static final float LinearIndicatorHeight = ProgressIndicatorTokens.INSTANCE.m3568getTrackThicknessD9Ej5fM();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize` and `drawStopIndicator`, see `LegacyLinearProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(expression = "LinearProgressIndicator(progress, modifier, color, trackColor, strokeCap, gapSize, drawStopIndicator)", imports = {}))
    /* JADX INFO: renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    public static final /* synthetic */ void m2495LinearProgressIndicator_5eSRE(final Function0 progress, Modifier modifier, long color, long trackColor, int strokeCap, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long trackColor2;
        int i2;
        Modifier.Companion modifier3;
        long color2;
        int strokeCap2;
        Modifier modifier4;
        long color3;
        int strokeCap3;
        long trackColor3;
        Composer $composer2 = $composer.startRestartGroup(-1796992155);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)91@4260L11,92@4323L16,95@4419L192:ProgressIndicator.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(progress) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
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
                int i4 = $composer2.changed(j) ? 256 : 128;
                $dirty |= i4;
            } else {
                j = color;
            }
            $dirty |= i4;
        } else {
            j = color;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                trackColor2 = trackColor;
                int i5 = $composer2.changed(trackColor2) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                trackColor2 = trackColor;
            }
            $dirty |= i5;
        } else {
            trackColor2 = trackColor;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            i2 = strokeCap;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            i2 = strokeCap;
            $dirty |= $composer2.changed(i2) ? 16384 : 8192;
        } else {
            i2 = strokeCap;
        }
        if (($dirty & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            trackColor3 = trackColor2;
            strokeCap3 = i2;
            color3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    color2 = ProgressIndicatorDefaults.INSTANCE.getLinearColor($composer2, 6);
                    $dirty &= -897;
                } else {
                    color2 = j;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    trackColor2 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor($composer2, 6);
                }
                strokeCap2 = i6 != 0 ? ProgressIndicatorDefaults.INSTANCE.m2483getLinearStrokeCapKaPHkGw() : i2;
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
                strokeCap2 = i2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1796992155, $dirty, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:94)");
            }
            m2492LinearProgressIndicatorGJbTh5U(progress, modifier3, color2, trackColor2, strokeCap2, ProgressIndicatorDefaults.INSTANCE.m2482getLinearIndicatorTrackGapSizeD9Ej5fM(), null, $composer2, ($dirty & 14) | ProfileVerifier.CompilationStatus.f245xf2722a21 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            color3 = color2;
            strokeCap3 = strokeCap2;
            trackColor3 = trackColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final long j2 = color3;
            final long j3 = trackColor3;
            final int i7 = strokeCap3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$1
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
                    ProgressIndicatorKt.m2495LinearProgressIndicator_5eSRE(progress, modifier5, j2, j3, i7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: LinearProgressIndicator-GJbTh5U, reason: not valid java name */
    public static final void m2492LinearProgressIndicatorGJbTh5U(final Function0<Float> function0, Modifier modifier, long color, long trackColor, int strokeCap, float gapSize, Function1<? super DrawScope, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final long color2;
        long trackColor2;
        final int strokeCap2;
        float gapSize2;
        Function1<? super DrawScope, Unit> function2;
        Function1<? super DrawScope, Unit> function3;
        float gapSize3;
        Object value$iv;
        Modifier modifier3;
        Object value$iv2;
        Function1<? super DrawScope, Unit> function4;
        float gapSize4;
        int strokeCap3;
        long trackColor3;
        long color3;
        Composer $composer2 = $composer.startRestartGroup(-339970038);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(4,3,0:c#ui.graphics.Color,6:c#ui.graphics.Color,5:c#ui.graphics.StrokeCap,2:c#ui.unit.Dp)133@6289L11,134@6352L16,137@6562L184,145@6778L31,149@6930L102,153@7102L838,146@6814L1126:ProgressIndicator.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
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
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                trackColor2 = trackColor;
                int i4 = $composer2.changed(trackColor2) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                trackColor2 = trackColor;
            }
            $dirty |= i4;
        } else {
            trackColor2 = trackColor;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            strokeCap2 = strokeCap;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            strokeCap2 = strokeCap;
            $dirty |= $composer2.changed(strokeCap2) ? 16384 : 8192;
        } else {
            strokeCap2 = strokeCap;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            gapSize2 = gapSize;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            gapSize2 = gapSize;
            $dirty |= $composer2.changed(gapSize2) ? 131072 : 65536;
        } else {
            gapSize2 = gapSize;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0) {
                function2 = function1;
                int i7 = $composer2.changedInstance(function2) ? 1048576 : 524288;
                $dirty |= i7;
            } else {
                function2 = function1;
            }
            $dirty |= i7;
        } else {
            function2 = function1;
        }
        if (($dirty & 599187) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function4 = function2;
            gapSize4 = gapSize2;
            modifier3 = modifier2;
            color3 = color2;
            strokeCap3 = strokeCap2;
            trackColor3 = trackColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    color2 = ProgressIndicatorDefaults.INSTANCE.getLinearColor($composer2, 6);
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    trackColor2 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor($composer2, 6);
                    $dirty &= -7169;
                }
                if (i5 != 0) {
                    strokeCap2 = ProgressIndicatorDefaults.INSTANCE.m2483getLinearStrokeCapKaPHkGw();
                }
                float gapSize5 = i6 != 0 ? ProgressIndicatorDefaults.INSTANCE.m2482getLinearIndicatorTrackGapSizeD9Ej5fM() : gapSize2;
                if ((i & 64) != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -1348538264, "CC(remember):ProgressIndicator.kt#9igjgp");
                    boolean invalid$iv = (((($dirty & 896) ^ 384) > 256 && $composer2.changed(color2)) || ($dirty & 384) == 256) | ((57344 & $dirty) == 16384);
                    Object value$iv3 = $composer2.rememberedValue();
                    if (invalid$iv) {
                        gapSize3 = gapSize5;
                    } else {
                        gapSize3 = gapSize5;
                        if (value$iv3 == Composer.INSTANCE.getEmpty()) {
                        }
                        function3 = (Function1) value$iv3;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $dirty &= -3670017;
                        gapSize2 = gapSize3;
                    }
                    value$iv3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$2$1
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
                        public final void invoke2(DrawScope $this$null) {
                            ProgressIndicatorKt.m2508drawStopIndicatorEgI2THU($this$null, ProgressIndicatorDefaults.INSTANCE.m2484getLinearTrackStopIndicatorSizeD9Ej5fM(), color2, strokeCap2);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    function3 = (Function1) value$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $dirty &= -3670017;
                    gapSize2 = gapSize3;
                } else {
                    gapSize2 = gapSize5;
                    function3 = function1;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                }
                function3 = function1;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-339970038, $dirty, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:144)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1348538048, "CC(remember):ProgressIndicator.kt#9igjgp");
            boolean invalid$iv2 = ($dirty & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(RangesKt.coerceIn(function0.invoke().floatValue(), 0.0f, 1.0f));
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final Function0 coercedProgress = (Function0) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierThen = modifier2.then(IncreaseSemanticsBounds);
            ComposerKt.sourceInformationMarkerStart($composer2, -1348537896, "CC(remember):ProgressIndicator.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changed(coercedProgress);
            modifier3 = modifier2;
            Object value$iv4 = $composer2.rememberedValue();
            if (invalid$iv3 || value$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                        SemanticsPropertiesKt.setProgressBarRangeInfo($this$semantics, new ProgressBarRangeInfo(coercedProgress.invoke().floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0, 4, null));
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierM915sizeVpY3zN4 = SizeKt.m915sizeVpY3zN4(SemanticsModifierKt.semantics(modifierThen, true, (Function1) value$iv4), LinearIndicatorWidth, LinearIndicatorHeight);
            ComposerKt.sourceInformationMarkerStart($composer2, -1348537724, "CC(remember):ProgressIndicator.kt#9igjgp");
            boolean invalid$iv4 = ((57344 & $dirty) == 16384) | ((458752 & $dirty) == 131072) | $composer2.changed(coercedProgress) | (((($dirty & 7168) ^ 3072) > 2048 && $composer2.changed(trackColor2)) || ($dirty & 3072) == 2048) | (((($dirty & 896) ^ 384) > 256 && $composer2.changed(color2)) || ($dirty & 384) == 256) | ((((3670016 & $dirty) ^ 1572864) > 1048576 && $composer2.changed(function3)) || ($dirty & 1572864) == 1048576);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv4 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                final int i8 = strokeCap2;
                final float f = gapSize2;
                final long j = trackColor2;
                final long j2 = color2;
                final Function1<? super DrawScope, Unit> function5 = function3;
                value$iv2 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$4$1
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
                        float fM6801constructorimpl;
                        float strokeWidth = Size.m4115getHeightimpl($this$Canvas.mo4773getSizeNHjbRc());
                        if (StrokeCap.m4648equalsimpl0(i8, StrokeCap.INSTANCE.m4652getButtKaPHkGw()) || Size.m4115getHeightimpl($this$Canvas.mo4773getSizeNHjbRc()) > Size.m4118getWidthimpl($this$Canvas.mo4773getSizeNHjbRc())) {
                            fM6801constructorimpl = f;
                        } else {
                            float arg0$iv = f;
                            float other$iv = $this$Canvas.mo563toDpu2uoSUM(strokeWidth);
                            fM6801constructorimpl = C1979Dp.m6801constructorimpl(arg0$iv + other$iv);
                        }
                        float adjustedGapSize = fM6801constructorimpl;
                        float other$iv2 = $this$Canvas.mo563toDpu2uoSUM(Size.m4118getWidthimpl($this$Canvas.mo4773getSizeNHjbRc()));
                        float currentCoercedProgress = coercedProgress.invoke().floatValue();
                        float trackStartFraction = Math.min(currentCoercedProgress, adjustedGapSize / other$iv2) + currentCoercedProgress;
                        if (trackStartFraction <= 1.0f) {
                            ProgressIndicatorKt.m2507drawLinearIndicatorqYKTg0g($this$Canvas, trackStartFraction, 1.0f, j, strokeWidth, i8);
                        }
                        ProgressIndicatorKt.m2507drawLinearIndicatorqYKTg0g($this$Canvas, 0.0f, currentCoercedProgress, j2, strokeWidth, i8);
                        Function1<DrawScope, Unit> function6 = function5;
                        if (function6 != null) {
                            function6.invoke($this$Canvas);
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifierM915sizeVpY3zN4, (Function1) value$iv2, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function4 = function3;
            gapSize4 = gapSize2;
            strokeCap3 = strokeCap2;
            trackColor3 = trackColor2;
            color3 = color2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final long j3 = color3;
            final long j4 = trackColor3;
            final int i9 = strokeCap3;
            final float f2 = gapSize4;
            final Function1<? super DrawScope, Unit> function6 = function4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$5
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

                public final void invoke(Composer composer, int i10) {
                    ProgressIndicatorKt.m2492LinearProgressIndicatorGJbTh5U(function0, modifier4, j3, j4, i9, f2, function6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: drawStopIndicator-EgI2THU, reason: not valid java name */
    public static final void m2508drawStopIndicatorEgI2THU(DrawScope $this$drawStopIndicator_u2dEgI2THU, float stopSize, long color, int strokeCap) {
        float adjustedStopSize = Math.min($this$drawStopIndicator_u2dEgI2THU.mo567toPx0680j_4(stopSize), Size.m4115getHeightimpl($this$drawStopIndicator_u2dEgI2THU.mo4773getSizeNHjbRc()));
        float stopOffset = (Size.m4115getHeightimpl($this$drawStopIndicator_u2dEgI2THU.mo4773getSizeNHjbRc()) - adjustedStopSize) / 2;
        if (StrokeCap.m4648equalsimpl0(strokeCap, StrokeCap.INSTANCE.m4653getRoundKaPHkGw())) {
            DrawScope.CC.m4845drawCircleVaOC9Bg$default($this$drawStopIndicator_u2dEgI2THU, color, adjustedStopSize / 2.0f, OffsetKt.Offset((Size.m4118getWidthimpl($this$drawStopIndicator_u2dEgI2THU.mo4773getSizeNHjbRc()) - (adjustedStopSize / 2.0f)) - stopOffset, Size.m4115getHeightimpl($this$drawStopIndicator_u2dEgI2THU.mo4773getSizeNHjbRc()) / 2.0f), 0.0f, null, null, 0, 120, null);
        } else {
            DrawScope.CC.m4858drawRectnJ9OG0$default($this$drawStopIndicator_u2dEgI2THU, color, OffsetKt.Offset((Size.m4118getWidthimpl($this$drawStopIndicator_u2dEgI2THU.mo4773getSizeNHjbRc()) - adjustedStopSize) - stopOffset, (Size.m4115getHeightimpl($this$drawStopIndicator_u2dEgI2THU.mo4773getSizeNHjbRc()) - adjustedStopSize) / 2.0f), androidx.compose.p001ui.geometry.SizeKt.Size(adjustedStopSize, adjustedStopSize), 0.0f, null, null, 0, 120, null);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize`, see `LegacyIndeterminateLinearProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(expression = "LinearProgressIndicator(modifier, color, trackColor, strokeCap, gapSize)", imports = {}))
    /* JADX INFO: renamed from: LinearProgressIndicator-2cYBFYY, reason: not valid java name */
    public static final /* synthetic */ void m2491LinearProgressIndicator2cYBFYY(Modifier modifier, long color, long trackColor, int strokeCap, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long j2;
        int i2;
        Modifier.Companion modifier3;
        long color2;
        long trackColor2;
        int strokeCap2;
        Modifier modifier4;
        long color3;
        long trackColor3;
        int strokeCap3;
        Composer $composer2 = $composer.startRestartGroup(-476865359);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(1,0:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.StrokeCap)242@10518L11,243@10581L16,246@10677L175:ProgressIndicator.kt#uh7d8r");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
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
                int i4 = $composer2.changed(j) ? 32 : 16;
                $dirty |= i4;
            } else {
                j = color;
            }
            $dirty |= i4;
        } else {
            j = color;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                j2 = trackColor;
                int i5 = $composer2.changed(j2) ? 256 : 128;
                $dirty |= i5;
            } else {
                j2 = trackColor;
            }
            $dirty |= i5;
        } else {
            j2 = trackColor;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
            i2 = strokeCap;
        } else if (($changed & 3072) == 0) {
            i2 = strokeCap;
            $dirty |= $composer2.changed(i2) ? 2048 : 1024;
        } else {
            i2 = strokeCap;
        }
        if (($dirty & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            trackColor3 = j2;
            strokeCap3 = i2;
            color3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    color2 = ProgressIndicatorDefaults.INSTANCE.getLinearColor($composer2, 6);
                    $dirty &= -113;
                } else {
                    color2 = j;
                }
                if ((i & 4) != 0) {
                    trackColor2 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor($composer2, 6);
                    $dirty &= -897;
                } else {
                    trackColor2 = j2;
                }
                strokeCap2 = i6 != 0 ? ProgressIndicatorDefaults.INSTANCE.m2483getLinearStrokeCapKaPHkGw() : i2;
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
                trackColor2 = j2;
                strokeCap2 = i2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-476865359, $dirty, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:245)");
            }
            m2497LinearProgressIndicatorrIrjwxo(modifier3, color2, trackColor2, strokeCap2, ProgressIndicatorDefaults.INSTANCE.m2482getLinearIndicatorTrackGapSizeD9Ej5fM(), $composer2, ($dirty & 14) | CpioConstants.C_ISBLK | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            color3 = color2;
            trackColor3 = trackColor2;
            strokeCap3 = strokeCap2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final long j3 = color3;
            final long j4 = trackColor3;
            final int i7 = strokeCap3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$6
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
                    ProgressIndicatorKt.m2491LinearProgressIndicator2cYBFYY(modifier5, j3, j4, i7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: LinearProgressIndicator-rIrjwxo, reason: not valid java name */
    public static final void m2497LinearProgressIndicatorrIrjwxo(Modifier modifier, long color, long trackColor, int strokeCap, float gapSize, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long color2;
        long trackColor2;
        int strokeCap2;
        float gapSize2;
        Modifier.Companion modifier3;
        Object value$iv;
        Modifier modifier4;
        float gapSize3;
        int $dirty;
        long trackColor3;
        long trackColor4;
        Composer $composer2 = $composer.startRestartGroup(567589233);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(2,0:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap,1:c#ui.unit.Dp)275@12013L11,276@12076L16,280@12270L28,284@12552L320,295@12916L320,306@13281L324,317@13650L324,333@14149L1901,328@13979L2071:ProgressIndicator.kt#uh7d8r");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
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
                color2 = color;
                int i3 = $composer2.changed(color2) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                color2 = color;
            }
            $dirty2 |= i3;
        } else {
            color2 = color;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                trackColor2 = trackColor;
                int i4 = $composer2.changed(trackColor2) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                trackColor2 = trackColor;
            }
            $dirty2 |= i4;
        } else {
            trackColor2 = trackColor;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            strokeCap2 = strokeCap;
        } else if (($changed & 3072) == 0) {
            strokeCap2 = strokeCap;
            $dirty2 |= $composer2.changed(strokeCap2) ? 2048 : 1024;
        } else {
            strokeCap2 = strokeCap;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            gapSize2 = gapSize;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            gapSize2 = gapSize;
            $dirty2 |= $composer2.changed(gapSize2) ? 16384 : 8192;
        } else {
            gapSize2 = gapSize;
        }
        if (($dirty2 & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            gapSize3 = gapSize2;
            $dirty = strokeCap2;
            trackColor3 = trackColor2;
            trackColor4 = color2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    color2 = ProgressIndicatorDefaults.INSTANCE.getLinearColor($composer2, 6);
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    trackColor2 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor($composer2, 6);
                    $dirty2 &= -897;
                }
                if (i5 != 0) {
                    strokeCap2 = ProgressIndicatorDefaults.INSTANCE.m2483getLinearStrokeCapKaPHkGw();
                }
                if (i6 != 0) {
                    gapSize2 = ProgressIndicatorDefaults.INSTANCE.m2482getLinearIndicatorTrackGapSizeD9Ej5fM();
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                modifier3 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(567589233, $dirty2, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:279)");
            }
            InfiniteTransition infiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(null, $composer2, 0, 1);
            final State<Float> stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m374infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$1
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
            final State<Float> stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m374infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$1
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
            final State<Float> stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m374infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1
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
            final State<Float> stateAnimateFloat4 = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m374infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1
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
            Modifier modifier5 = modifier3;
            Modifier modifierM915sizeVpY3zN4 = SizeKt.m915sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(modifier3.then(IncreaseSemanticsBounds)), LinearIndicatorWidth, LinearIndicatorHeight);
            ComposerKt.sourceInformationMarkerStart($composer2, -1348530677, "CC(remember):ProgressIndicator.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 7168) == 2048) | ((57344 & $dirty2) == 16384) | $composer2.changed(stateAnimateFloat) | (((($dirty2 & 896) ^ 384) > 256 && $composer2.changed(trackColor2)) || ($dirty2 & 384) == 256) | $composer2.changed(stateAnimateFloat2) | (((($dirty2 & 112) ^ 48) > 32 && $composer2.changed(color2)) || ($dirty2 & 48) == 32) | $composer2.changed(stateAnimateFloat3) | $composer2.changed(stateAnimateFloat4);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                final int i7 = strokeCap2;
                final float f = gapSize2;
                final long j = trackColor2;
                final long j2 = color2;
                value$iv = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$7$1
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
                        float fM6801constructorimpl;
                        float strokeWidth = Size.m4115getHeightimpl($this$Canvas.mo4773getSizeNHjbRc());
                        if (StrokeCap.m4648equalsimpl0(i7, StrokeCap.INSTANCE.m4652getButtKaPHkGw()) || Size.m4115getHeightimpl($this$Canvas.mo4773getSizeNHjbRc()) > Size.m4118getWidthimpl($this$Canvas.mo4773getSizeNHjbRc())) {
                            fM6801constructorimpl = f;
                        } else {
                            float arg0$iv = f;
                            fM6801constructorimpl = C1979Dp.m6801constructorimpl(arg0$iv + $this$Canvas.mo563toDpu2uoSUM(strokeWidth));
                        }
                        float adjustedGapSize = fM6801constructorimpl;
                        float other$iv = adjustedGapSize / $this$Canvas.mo563toDpu2uoSUM(Size.m4118getWidthimpl($this$Canvas.mo4773getSizeNHjbRc()));
                        if (stateAnimateFloat.getValue().floatValue() < 1.0f - other$iv) {
                            float start = stateAnimateFloat.getValue().floatValue() > 0.0f ? stateAnimateFloat.getValue().floatValue() + other$iv : 0.0f;
                            ProgressIndicatorKt.m2507drawLinearIndicatorqYKTg0g($this$Canvas, start, 1.0f, j, strokeWidth, i7);
                        }
                        if (stateAnimateFloat.getValue().floatValue() - stateAnimateFloat2.getValue().floatValue() > 0.0f) {
                            ProgressIndicatorKt.m2507drawLinearIndicatorqYKTg0g($this$Canvas, stateAnimateFloat.getValue().floatValue(), stateAnimateFloat2.getValue().floatValue(), j2, strokeWidth, i7);
                        }
                        if (stateAnimateFloat2.getValue().floatValue() > other$iv) {
                            float start2 = stateAnimateFloat3.getValue().floatValue() > 0.0f ? stateAnimateFloat3.getValue().floatValue() + other$iv : 0.0f;
                            float end = stateAnimateFloat2.getValue().floatValue() < 1.0f ? stateAnimateFloat2.getValue().floatValue() - other$iv : 1.0f;
                            ProgressIndicatorKt.m2507drawLinearIndicatorqYKTg0g($this$Canvas, start2, end, j, strokeWidth, i7);
                        }
                        if (stateAnimateFloat3.getValue().floatValue() - stateAnimateFloat4.getValue().floatValue() > 0.0f) {
                            ProgressIndicatorKt.m2507drawLinearIndicatorqYKTg0g($this$Canvas, stateAnimateFloat3.getValue().floatValue(), stateAnimateFloat4.getValue().floatValue(), j2, strokeWidth, i7);
                        }
                        if (stateAnimateFloat4.getValue().floatValue() > other$iv) {
                            float end2 = stateAnimateFloat4.getValue().floatValue() < 1.0f ? stateAnimateFloat4.getValue().floatValue() - other$iv : 1.0f;
                            ProgressIndicatorKt.m2507drawLinearIndicatorqYKTg0g($this$Canvas, 0.0f, end2, j, strokeWidth, i7);
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifierM915sizeVpY3zN4, (Function1) value$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier5;
            gapSize3 = gapSize2;
            $dirty = strokeCap2;
            trackColor3 = trackColor2;
            trackColor4 = color2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final long j3 = trackColor4;
            final long j4 = trackColor3;
            final int i8 = $dirty;
            final float f2 = gapSize3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$8
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
                    ProgressIndicatorKt.m2497LinearProgressIndicatorrIrjwxo(modifier6, j3, j4, i8, f2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @ReplaceWith(expression = "LinearProgressIndicator(\nprogress = { progress },\nmodifier = modifier,\ncolor = color,\ntrackColor = trackColor,\nstrokeCap = strokeCap,\n)", imports = {}))
    /* JADX INFO: renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    public static final void m2494LinearProgressIndicator_5eSRE(final float progress, Modifier modifier, long color, long trackColor, int strokeCap, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long j2;
        int i2;
        Modifier.Companion modifier3;
        long color2;
        long trackColor2;
        int strokeCap2;
        Object value$iv;
        Modifier modifier4;
        long color3;
        long trackColor3;
        int strokeCap3;
        Composer $composer2 = $composer.startRestartGroup(905419617);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)407@16570L11,408@16633L16,411@16765L12,410@16725L155:ProgressIndicator.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(progress) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
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
                int i4 = $composer2.changed(j) ? 256 : 128;
                $dirty |= i4;
            } else {
                j = color;
            }
            $dirty |= i4;
        } else {
            j = color;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                j2 = trackColor;
                int i5 = $composer2.changed(j2) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                j2 = trackColor;
            }
            $dirty |= i5;
        } else {
            j2 = trackColor;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            i2 = strokeCap;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            i2 = strokeCap;
            $dirty |= $composer2.changed(i2) ? 16384 : 8192;
        } else {
            i2 = strokeCap;
        }
        if (($dirty & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            trackColor3 = j2;
            strokeCap3 = i2;
            color3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    color2 = ProgressIndicatorDefaults.INSTANCE.getLinearColor($composer2, 6);
                    $dirty &= -897;
                } else {
                    color2 = j;
                }
                if ((i & 8) != 0) {
                    trackColor2 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor($composer2, 6);
                    $dirty &= -7169;
                } else {
                    trackColor2 = j2;
                }
                strokeCap2 = i6 != 0 ? ProgressIndicatorDefaults.INSTANCE.m2483getLinearStrokeCapKaPHkGw() : i2;
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
                trackColor2 = j2;
                strokeCap2 = i2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(905419617, $dirty, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:410)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1348528061, "CC(remember):ProgressIndicator.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$9$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(progress);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            m2492LinearProgressIndicatorGJbTh5U((Function0) value$iv, modifier3, color2, trackColor2, strokeCap2, 0.0f, null, $composer2, ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty), 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            color3 = color2;
            trackColor3 = trackColor2;
            strokeCap3 = strokeCap2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final long j3 = color3;
            final long j4 = trackColor3;
            final int i7 = strokeCap3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$10
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
                    ProgressIndicatorKt.m2494LinearProgressIndicator_5eSRE(progress, modifier5, j3, j4, i7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: LinearProgressIndicator-eaDK9VM, reason: not valid java name */
    public static final /* synthetic */ void m2496LinearProgressIndicatoreaDK9VM(final float progress, Modifier modifier, long color, long trackColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long j2;
        Modifier.Companion modifier3;
        long color2;
        long trackColor2;
        Modifier modifier4;
        long color3;
        long trackColor3;
        Composer $composer2 = $composer.startRestartGroup(-372717133);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.graphics.Color)424@17133L11,425@17196L16,426@17218L140:ProgressIndicator.kt#uh7d8r");
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
                j2 = trackColor;
                int i4 = $composer2.changed(j2) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                j2 = trackColor;
            }
            $dirty |= i4;
        } else {
            j2 = trackColor;
        }
        if (($dirty & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            trackColor3 = j2;
            modifier4 = modifier2;
            color3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    color2 = ProgressIndicatorDefaults.INSTANCE.getLinearColor($composer2, 6);
                    $dirty &= -897;
                } else {
                    color2 = j;
                }
                if ((i & 8) != 0) {
                    trackColor2 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor($composer2, 6);
                    $dirty &= -7169;
                } else {
                    trackColor2 = j2;
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
                trackColor2 = j2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-372717133, $dirty, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:426)");
            }
            m2494LinearProgressIndicator_5eSRE(progress, modifier3, color2, trackColor2, ProgressIndicatorDefaults.INSTANCE.m2483getLinearStrokeCapKaPHkGw(), $composer2, ($dirty & 14) | CpioConstants.C_ISBLK | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            color3 = color2;
            trackColor3 = trackColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final long j3 = color3;
            final long j4 = trackColor3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$11
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
                    ProgressIndicatorKt.m2496LinearProgressIndicatoreaDK9VM(progress, modifier5, j3, j4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: LinearProgressIndicator-RIQooxk, reason: not valid java name */
    public static final /* synthetic */ void m2493LinearProgressIndicatorRIQooxk(Modifier modifier, long color, long trackColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long j2;
        Modifier.Companion modifier3;
        long color2;
        long trackColor2;
        Modifier modifier4;
        long color3;
        long trackColor3;
        Composer $composer2 = $composer.startRestartGroup(585576195);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.graphics.Color)438@17565L11,439@17628L16,440@17650L126:ProgressIndicator.kt#uh7d8r");
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
                j2 = trackColor;
                int i4 = $composer2.changed(j2) ? 256 : 128;
                $dirty |= i4;
            } else {
                j2 = trackColor;
            }
            $dirty |= i4;
        } else {
            j2 = trackColor;
        }
        if (($dirty & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            trackColor3 = j2;
            modifier4 = modifier2;
            color3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    color2 = ProgressIndicatorDefaults.INSTANCE.getLinearColor($composer2, 6);
                    $dirty &= -113;
                } else {
                    color2 = j;
                }
                if ((i & 4) != 0) {
                    trackColor2 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor($composer2, 6);
                    $dirty &= -897;
                } else {
                    trackColor2 = j2;
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
                trackColor2 = j2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(585576195, $dirty, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:440)");
            }
            m2497LinearProgressIndicatorrIrjwxo(modifier3, color2, trackColor2, ProgressIndicatorDefaults.INSTANCE.m2483getLinearStrokeCapKaPHkGw(), 0.0f, $composer2, ($dirty & 14) | 3072 | ($dirty & 112) | ($dirty & 896), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            color3 = color2;
            trackColor3 = trackColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final long j3 = color3;
            final long j4 = trackColor3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$12
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
                    ProgressIndicatorKt.m2493LinearProgressIndicatorRIQooxk(modifier5, j3, j4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawLinearIndicator-qYKTg0g, reason: not valid java name */
    public static final void m2507drawLinearIndicatorqYKTg0g(DrawScope $this$drawLinearIndicator_u2dqYKTg0g, float startFraction, float endFraction, long color, float strokeWidth, int strokeCap) {
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

    static {
        float arg0$iv = ProgressIndicatorTokens.INSTANCE.m3565getSizeD9Ej5fM();
        float arg0$iv2 = ProgressIndicatorTokens.INSTANCE.m3568getTrackThicknessD9Ej5fM();
        CircularIndicatorDiameter = C1979Dp.m6801constructorimpl(arg0$iv - C1979Dp.m6801constructorimpl(2 * arg0$iv2));
        FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);
        FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
        SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);
        SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);
        CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize`, see `LegacyCircularProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(expression = "CircularProgressIndicator(progress, modifier, color, strokeWidth, trackColor, strokeCap, gapSize)", imports = {}))
    /* JADX INFO: renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    public static final /* synthetic */ void m2486CircularProgressIndicatorDUhRLBM(final Function0 progress, Modifier modifier, long color, float strokeWidth, long trackColor, int strokeCap, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long color2;
        float strokeWidth2;
        long trackColor2;
        int i2;
        Modifier.Companion modifier3;
        int $dirty;
        long trackColor3;
        int strokeCap2;
        Modifier modifier4;
        long trackColor4;
        int strokeCap3;
        long color3;
        float strokeWidth3;
        Composer $composer2 = $composer.startRestartGroup(-761680467);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.unit.Dp,5:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)546@22269L13,548@22403L29,551@22525L217:ProgressIndicator.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(progress) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
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
                color2 = color;
                int i4 = $composer2.changed(color2) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                color2 = color;
            }
            $dirty2 |= i4;
        } else {
            color2 = color;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            strokeWidth2 = strokeWidth;
        } else if (($changed & 3072) == 0) {
            strokeWidth2 = strokeWidth;
            $dirty2 |= $composer2.changed(strokeWidth2) ? 2048 : 1024;
        } else {
            strokeWidth2 = strokeWidth;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                trackColor2 = trackColor;
                int i6 = $composer2.changed(trackColor2) ? 16384 : 8192;
                $dirty2 |= i6;
            } else {
                trackColor2 = trackColor;
            }
            $dirty2 |= i6;
        } else {
            trackColor2 = trackColor;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            i2 = strokeCap;
        } else if ((196608 & $changed) == 0) {
            i2 = strokeCap;
            $dirty2 |= $composer2.changed(i2) ? 131072 : 65536;
        } else {
            i2 = strokeCap;
        }
        if ((74899 & $dirty2) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            strokeWidth3 = strokeWidth2;
            trackColor4 = trackColor2;
            strokeCap3 = i2;
            modifier4 = modifier2;
            color3 = color2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    color2 = ProgressIndicatorDefaults.INSTANCE.getCircularColor($composer2, 6);
                    $dirty2 &= -897;
                }
                if (i5 != 0) {
                    strokeWidth2 = ProgressIndicatorDefaults.INSTANCE.m2481getCircularStrokeWidthD9Ej5fM();
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    trackColor2 = ProgressIndicatorDefaults.INSTANCE.getCircularDeterminateTrackColor($composer2, 6);
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    strokeCap2 = ProgressIndicatorDefaults.INSTANCE.m2478getCircularDeterminateStrokeCapKaPHkGw();
                    trackColor3 = trackColor2;
                } else {
                    $dirty = $dirty2;
                    trackColor3 = trackColor2;
                    strokeCap2 = i2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 16) != 0) {
                    $dirty = $dirty2 & (-57345);
                    modifier3 = modifier2;
                    trackColor3 = trackColor2;
                    strokeCap2 = i2;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    trackColor3 = trackColor2;
                    strokeCap2 = i2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-761680467, $dirty, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:550)");
            }
            m2487CircularProgressIndicatorIyT6zlY(progress, modifier3, color2, strokeWidth2, trackColor3, strokeCap2, ProgressIndicatorDefaults.INSTANCE.m2480getCircularIndicatorTrackGapSizeD9Ej5fM(), $composer2, ($dirty & 14) | 1572864 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            trackColor4 = trackColor3;
            strokeCap3 = strokeCap2;
            color3 = color2;
            strokeWidth3 = strokeWidth2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final long j = color3;
            final float f = strokeWidth3;
            final long j2 = trackColor4;
            final int i8 = strokeCap3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$1
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
                    ProgressIndicatorKt.m2486CircularProgressIndicatorDUhRLBM(progress, modifier5, j, f, j2, i8, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:173:0x02ee  */
    /* JADX INFO: renamed from: CircularProgressIndicator-IyT6zlY, reason: not valid java name */
    public static final void m2487CircularProgressIndicatorIyT6zlY(final Function0<Float> function0, Modifier modifier, long color, float strokeWidth, long trackColor, int strokeCap, float gapSize, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float strokeWidth2;
        long trackColor2;
        int strokeCap2;
        float gapSize2;
        long color2;
        int $dirty;
        long color3;
        Object value$iv;
        Object value$iv2;
        Modifier modifier3;
        Object value$iv3;
        long color4;
        float gapSize3;
        int strokeCap3;
        long trackColor3;
        float strokeWidth3;
        Composer $composer2 = $composer.startRestartGroup(-1798883595);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(3,2,0:c#ui.graphics.Color,5:c#ui.unit.Dp,6:c#ui.graphics.Color,4:c#ui.graphics.StrokeCap,1:c#ui.unit.Dp)590@24408L13,592@24542L29,596@24761L31,*597@24828L7,602@24982L102,606@25136L689,600@24909L916:ProgressIndicator.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 4 : 2;
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
            $dirty2 |= ((i & 4) == 0 && $composer2.changed(color)) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            strokeWidth2 = strokeWidth;
        } else if (($changed & 3072) == 0) {
            strokeWidth2 = strokeWidth;
            $dirty2 |= $composer2.changed(strokeWidth2) ? 2048 : 1024;
        } else {
            strokeWidth2 = strokeWidth;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                trackColor2 = trackColor;
                int i4 = $composer2.changed(trackColor2) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                trackColor2 = trackColor;
            }
            $dirty2 |= i4;
        } else {
            trackColor2 = trackColor;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            strokeCap2 = strokeCap;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            strokeCap2 = strokeCap;
            $dirty2 |= $composer2.changed(strokeCap2) ? 131072 : 65536;
        } else {
            strokeCap2 = strokeCap;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
            gapSize2 = gapSize;
        } else if (($changed & 1572864) == 0) {
            gapSize2 = gapSize;
            $dirty2 |= $composer2.changed(gapSize2) ? 1048576 : 524288;
        } else {
            gapSize2 = gapSize;
        }
        if (($dirty2 & 599187) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            color4 = color;
            modifier3 = modifier2;
            trackColor3 = trackColor2;
            gapSize3 = gapSize2;
            strokeCap3 = strokeCap2;
            strokeWidth3 = strokeWidth2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    color2 = ProgressIndicatorDefaults.INSTANCE.getCircularColor($composer2, 6);
                    $dirty2 &= -897;
                } else {
                    color2 = color;
                }
                if (i3 != 0) {
                    strokeWidth2 = ProgressIndicatorDefaults.INSTANCE.m2481getCircularStrokeWidthD9Ej5fM();
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    trackColor2 = ProgressIndicatorDefaults.INSTANCE.getCircularDeterminateTrackColor($composer2, 6);
                }
                if (i5 != 0) {
                    strokeCap2 = ProgressIndicatorDefaults.INSTANCE.m2478getCircularDeterminateStrokeCapKaPHkGw();
                }
                if (i6 != 0) {
                    $dirty = $dirty2;
                    gapSize2 = ProgressIndicatorDefaults.INSTANCE.m2480getCircularIndicatorTrackGapSizeD9Ej5fM();
                    color3 = color2;
                } else {
                    $dirty = $dirty2;
                    color3 = color2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                $dirty = $dirty2;
                color3 = color;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1798883595, $dirty, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:595)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 821876665, "CC(remember):ProgressIndicator.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$coercedProgress$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(RangesKt.coerceIn(function0.invoke().floatValue(), 0.0f, 1.0f));
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final Function0 coercedProgress = (Function0) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$CircularProgressIndicator_IyT6zlY_u24lambda_u247 = (Density) objConsume;
            final Stroke stroke = new Stroke($this$CircularProgressIndicator_IyT6zlY_u24lambda_u247.mo567toPx0680j_4(strokeWidth2), 0.0f, strokeCap2, 0, null, 26, null);
            ComposerKt.sourceInformationMarkerStart($composer2, 821876886, "CC(remember):ProgressIndicator.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(coercedProgress);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                        SemanticsPropertiesKt.setProgressBarRangeInfo($this$semantics, new ProgressBarRangeInfo(coercedProgress.invoke().floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0, 4, null));
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierM913size3ABfNKs = SizeKt.m913size3ABfNKs(SemanticsModifierKt.semantics(modifier2, true, (Function1) value$iv2), CircularIndicatorDiameter);
            ComposerKt.sourceInformationMarkerStart($composer2, 821877040, "CC(remember):ProgressIndicator.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changed(coercedProgress) | ((458752 & $dirty) == 131072) | ((3670016 & $dirty) == 1048576) | (($dirty & 7168) == 2048) | ((((57344 & $dirty) ^ CpioConstants.C_ISBLK) > 16384 && $composer2.changed(trackColor2)) || ($dirty & CpioConstants.C_ISBLK) == 16384) | $composer2.changedInstance(stroke) | (((($dirty & 896) ^ 384) > 256 && $composer2.changed(color3)) || ($dirty & 384) == 256);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv3) {
                modifier3 = modifier2;
            } else {
                modifier3 = modifier2;
                if (it$iv3 != Composer.INSTANCE.getEmpty()) {
                    value$iv3 = it$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                CanvasKt.Canvas(modifierM913size3ABfNKs, (Function1) value$iv3, $composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                color4 = color3;
                gapSize3 = gapSize2;
                strokeCap3 = strokeCap2;
                trackColor3 = trackColor2;
                strokeWidth3 = strokeWidth2;
            }
            final int i7 = strokeCap2;
            final float f = gapSize2;
            final float f2 = strokeWidth2;
            final long j = trackColor2;
            final long j2 = color3;
            value$iv3 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$3$1
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
                    float fM6801constructorimpl;
                    float sweep = coercedProgress.invoke().floatValue() * 360.0f;
                    if (StrokeCap.m4648equalsimpl0(i7, StrokeCap.INSTANCE.m4652getButtKaPHkGw()) || Size.m4115getHeightimpl($this$Canvas.mo4773getSizeNHjbRc()) > Size.m4118getWidthimpl($this$Canvas.mo4773getSizeNHjbRc())) {
                        fM6801constructorimpl = f;
                    } else {
                        float arg0$iv = f;
                        float other$iv = f2;
                        fM6801constructorimpl = C1979Dp.m6801constructorimpl(arg0$iv + other$iv);
                    }
                    float adjustedGapSize = fM6801constructorimpl;
                    float gapSizeSweep = (adjustedGapSize / ((float) (((double) ProgressIndicatorKt.getCircularIndicatorDiameter()) * 3.141592653589793d))) * 360.0f;
                    ProgressIndicatorKt.m2503drawCircularIndicator42QJj7c($this$Canvas, 270.0f + sweep + Math.min(sweep, gapSizeSweep), (360.0f - sweep) - (Math.min(sweep, gapSizeSweep) * 2), j, stroke);
                    ProgressIndicatorKt.m2505drawDeterminateCircularIndicator42QJj7c($this$Canvas, 270.0f, sweep, j2, stroke);
                }
            };
            $composer2.updateRememberedValue(value$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifierM913size3ABfNKs, (Function1) value$iv3, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            color4 = color3;
            gapSize3 = gapSize2;
            strokeCap3 = strokeCap2;
            trackColor3 = trackColor2;
            strokeWidth3 = strokeWidth2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final long j3 = color4;
            final float f3 = strokeWidth3;
            final long j4 = trackColor3;
            final int i8 = strokeCap3;
            final float f4 = gapSize3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$4
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
                    ProgressIndicatorKt.m2487CircularProgressIndicatorIyT6zlY(function0, modifier4, j3, f3, j4, i8, f4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02d8 A[PHI: r8
  0x02d8: PHI (r8v20 'trackColor' long) = (r8v18 'trackColor' long), (r8v21 'trackColor' long) binds: [B:100:0x02d6, B:96:0x02cd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:105:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:106:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:125:0x0363  */
    /* JADX INFO: renamed from: CircularProgressIndicator-LxG7B9w, reason: not valid java name */
    public static final void m2488CircularProgressIndicatorLxG7B9w(Modifier modifier, long color, float strokeWidth, long trackColor, int strokeCap, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        float strokeWidth2;
        long trackColor2;
        int i2;
        long color2;
        int $dirty;
        long color3;
        int strokeCap2;
        Modifier modifier3;
        float strokeWidth3;
        long trackColor3;
        final float strokeWidth4;
        long trackColor4;
        boolean z;
        boolean z2;
        boolean invalid$iv;
        Object value$iv;
        int strokeCap3;
        long trackColor5;
        Composer $composer2 = $composer.startRestartGroup(-115871647);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,3:c#ui.unit.Dp,4:c#ui.graphics.Color,2:c#ui.graphics.StrokeCap)647@26937L13,649@27071L31,*652@27228L7,656@27327L28,658@27484L278,670@27876L230,681@28223L346,692@28602L355,707@29071L628,703@28962L737:ProgressIndicator.kt#uh7d8r");
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
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty2 |= 384;
            strokeWidth2 = strokeWidth;
        } else if (($changed & 384) == 0) {
            strokeWidth2 = strokeWidth;
            $dirty2 |= $composer2.changed(strokeWidth2) ? 256 : 128;
        } else {
            strokeWidth2 = strokeWidth;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                trackColor2 = trackColor;
                int i6 = $composer2.changed(trackColor2) ? 2048 : 1024;
                $dirty2 |= i6;
            } else {
                trackColor2 = trackColor;
            }
            $dirty2 |= i6;
        } else {
            trackColor2 = trackColor;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            i2 = strokeCap;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            i2 = strokeCap;
            $dirty2 |= $composer2.changed(i2) ? 16384 : 8192;
        } else {
            i2 = strokeCap;
        }
        if (($dirty2 & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            color3 = j;
            strokeWidth4 = strokeWidth2;
            trackColor5 = trackColor2;
            strokeCap3 = i2;
            modifier3 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    color2 = ProgressIndicatorDefaults.INSTANCE.getCircularColor($composer2, 6);
                    $dirty2 &= -113;
                } else {
                    color2 = j;
                }
                if (i5 != 0) {
                    strokeWidth2 = ProgressIndicatorDefaults.INSTANCE.m2481getCircularStrokeWidthD9Ej5fM();
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    trackColor2 = ProgressIndicatorDefaults.INSTANCE.getCircularIndeterminateTrackColor($composer2, 6);
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    color3 = color2;
                    strokeCap2 = ProgressIndicatorDefaults.INSTANCE.m2479getCircularIndeterminateStrokeCapKaPHkGw();
                    strokeWidth3 = strokeWidth2;
                    trackColor3 = trackColor2;
                } else {
                    $dirty = $dirty2;
                    color3 = color2;
                    strokeCap2 = i2;
                    modifier3 = modifier4;
                    strokeWidth3 = strokeWidth2;
                    trackColor3 = trackColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                $dirty = $dirty2;
                color3 = j;
                strokeCap2 = i2;
                modifier3 = modifier2;
                strokeWidth3 = strokeWidth2;
                trackColor3 = trackColor2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-115871647, $dirty, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:651)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$CircularProgressIndicator_LxG7B9w_u24lambda_u2410 = (Density) objConsume;
            final Stroke stroke = new Stroke($this$CircularProgressIndicator_LxG7B9w_u24lambda_u2410.mo567toPx0680j_4(strokeWidth3), 0.0f, strokeCap2, 0, null, 26, null);
            InfiniteTransition transition = InfiniteTransitionKt.rememberInfiniteTransition(null, $composer2, 0, 1);
            boolean z3 = true;
            int $dirty3 = $dirty;
            long trackColor6 = trackColor3;
            strokeWidth4 = strokeWidth3;
            final State currentRotation = InfiniteTransitionKt.animateValue(transition, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m374infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 12), 16);
            final State<Float> stateAnimateFloat = InfiniteTransitionKt.animateFloat(transition, 0.0f, BaseRotationAngle, AnimationSpecKt.m374infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            final State<Float> stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(transition, 0.0f, JumpRotationAngle, AnimationSpecKt.m374infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$endAngle$1
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
            final State<Float> stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(transition, 0.0f, JumpRotationAngle, AnimationSpecKt.m374infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$startAngle$1
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
            ComposerKt.sourceInformationMarkerStart($composer2, 821880975, "CC(remember):ProgressIndicator.kt#9igjgp");
            if ((($dirty3 & 7168) ^ 3072) > 2048) {
                trackColor4 = trackColor6;
                if ($composer2.changed(trackColor4)) {
                    z = true;
                }
                boolean zChangedInstance = z | $composer2.changedInstance(stroke) | $composer2.changed(currentRotation) | $composer2.changed(stateAnimateFloat2) | $composer2.changed(stateAnimateFloat3) | $composer2.changed(stateAnimateFloat);
                if (($dirty3 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z4 = zChangedInstance | z2;
                if (((($dirty3 & 112) ^ 48) > 32 || !$composer2.changed(color3)) && ($dirty3 & 48) != 32) {
                }
                invalid$iv = z4 | z3;
                Object it$iv = $composer2.rememberedValue();
                if (!invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    final long j2 = trackColor4;
                    final long j3 = color3;
                    value$iv = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$5$1
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
                            ProgressIndicatorKt.m2504drawCircularIndicatorTrackbw27NRU($this$Canvas, j2, stroke);
                            float currentRotationAngleOffset = (currentRotation.getValue().floatValue() * 216.0f) % 360.0f;
                            float sweep = Math.abs(stateAnimateFloat2.getValue().floatValue() - stateAnimateFloat3.getValue().floatValue());
                            float offset = (-90.0f) + currentRotationAngleOffset + stateAnimateFloat.getValue().floatValue();
                            ProgressIndicatorKt.m2506drawIndeterminateCircularIndicatorhrjfTZI($this$Canvas, stateAnimateFloat3.getValue().floatValue() + offset, strokeWidth4, sweep, j3, stroke);
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
                trackColor5 = trackColor4;
            } else {
                trackColor4 = trackColor6;
            }
            if (($dirty3 & 3072) == 2048) {
                z = true;
            } else {
                z = false;
            }
            boolean zChangedInstance2 = z | $composer2.changedInstance(stroke) | $composer2.changed(currentRotation) | $composer2.changed(stateAnimateFloat2) | $composer2.changed(stateAnimateFloat3) | $composer2.changed(stateAnimateFloat);
            if (($dirty3 & 896) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z5 = zChangedInstance2 | z2;
            z3 = (($dirty3 & 112) ^ 48) > 32 ? false : false;
            invalid$iv = z5 | z3;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            final long j4 = trackColor4;
            final long j5 = color3;
            value$iv = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$5$1
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
                    ProgressIndicatorKt.m2504drawCircularIndicatorTrackbw27NRU($this$Canvas, j4, stroke);
                    float currentRotationAngleOffset = (currentRotation.getValue().floatValue() * 216.0f) % 360.0f;
                    float sweep = Math.abs(stateAnimateFloat2.getValue().floatValue() - stateAnimateFloat3.getValue().floatValue());
                    float offset = (-90.0f) + currentRotationAngleOffset + stateAnimateFloat.getValue().floatValue();
                    ProgressIndicatorKt.m2506drawIndeterminateCircularIndicatorhrjfTZI($this$Canvas, stateAnimateFloat3.getValue().floatValue() + offset, strokeWidth4, sweep, j5, stroke);
                }
            };
            $composer2.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifierM913size3ABfNKs, (Function1) value$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            strokeCap3 = strokeCap2;
            trackColor5 = trackColor4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final long j6 = color3;
            final float f = strokeWidth4;
            final long j7 = trackColor5;
            final int i8 = strokeCap3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$6
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
                    ProgressIndicatorKt.m2488CircularProgressIndicatorLxG7B9w(modifier5, j6, f, j7, i8, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @ReplaceWith(expression = "CircularProgressIndicator(\nprogress = { progress },\nmodifier = modifier,\ncolor = color,\nstrokeWidth = strokeWidth,\ntrackColor = trackColor,\nstrokeCap = strokeCap,\n)", imports = {}))
    /* JADX INFO: renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    public static final void m2485CircularProgressIndicatorDUhRLBM(final float progress, Modifier modifier, long color, float strokeWidth, long trackColor, int strokeCap, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long color2;
        float strokeWidth2;
        long trackColor2;
        int i2;
        Modifier.Companion modifier3;
        int $dirty;
        long trackColor3;
        int strokeCap2;
        Object value$iv;
        Modifier modifier4;
        long trackColor4;
        int strokeCap3;
        long color3;
        float strokeWidth3;
        Composer $composer2 = $composer.startRestartGroup(-1472321743);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.unit.Dp,5:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)745@30293L13,747@30427L18,750@30576L12,749@30534L188:ProgressIndicator.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(progress) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
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
                color2 = color;
                int i4 = $composer2.changed(color2) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                color2 = color;
            }
            $dirty2 |= i4;
        } else {
            color2 = color;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            strokeWidth2 = strokeWidth;
        } else if (($changed & 3072) == 0) {
            strokeWidth2 = strokeWidth;
            $dirty2 |= $composer2.changed(strokeWidth2) ? 2048 : 1024;
        } else {
            strokeWidth2 = strokeWidth;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                trackColor2 = trackColor;
                int i6 = $composer2.changed(trackColor2) ? 16384 : 8192;
                $dirty2 |= i6;
            } else {
                trackColor2 = trackColor;
            }
            $dirty2 |= i6;
        } else {
            trackColor2 = trackColor;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            i2 = strokeCap;
        } else if ((196608 & $changed) == 0) {
            i2 = strokeCap;
            $dirty2 |= $composer2.changed(i2) ? 131072 : 65536;
        } else {
            i2 = strokeCap;
        }
        if (($dirty2 & 74899) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            strokeWidth3 = strokeWidth2;
            trackColor4 = trackColor2;
            strokeCap3 = i2;
            modifier4 = modifier2;
            color3 = color2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    color2 = ProgressIndicatorDefaults.INSTANCE.getCircularColor($composer2, 6);
                    $dirty2 &= -897;
                }
                if (i5 != 0) {
                    strokeWidth2 = ProgressIndicatorDefaults.INSTANCE.m2481getCircularStrokeWidthD9Ej5fM();
                }
                if ((i & 16) != 0) {
                    trackColor2 = ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor($composer2, 6);
                    $dirty2 &= -57345;
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    strokeCap2 = ProgressIndicatorDefaults.INSTANCE.m2478getCircularDeterminateStrokeCapKaPHkGw();
                    trackColor3 = trackColor2;
                } else {
                    $dirty = $dirty2;
                    trackColor3 = trackColor2;
                    strokeCap2 = i2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 16) != 0) {
                    int i8 = $dirty2 & (-57345);
                    trackColor3 = trackColor2;
                    strokeCap2 = i2;
                    Modifier modifier5 = modifier2;
                    $dirty = i8;
                    modifier3 = modifier5;
                } else {
                    modifier3 = modifier2;
                    strokeCap2 = i2;
                    $dirty = $dirty2;
                    trackColor3 = trackColor2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1472321743, $dirty, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:749)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 821882480, "CC(remember):ProgressIndicator.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$7$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(progress);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            m2487CircularProgressIndicatorIyT6zlY((Function0) value$iv, modifier3, color2, strokeWidth2, trackColor3, strokeCap2, 0.0f, $composer2, ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            trackColor4 = trackColor3;
            strokeCap3 = strokeCap2;
            color3 = color2;
            strokeWidth3 = strokeWidth2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final long j = color3;
            final float f = strokeWidth3;
            final long j2 = trackColor4;
            final int i9 = strokeCap3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i10) {
                    ProgressIndicatorKt.m2485CircularProgressIndicatorDUhRLBM(progress, modifier6, j, f, j2, i9, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: CircularProgressIndicator-MBs18nI, reason: not valid java name */
    public static final /* synthetic */ void m2489CircularProgressIndicatorMBs18nI(final float progress, Modifier modifier, long color, float strokeWidth, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        float f;
        Modifier.Companion modifier3;
        long color2;
        float strokeWidth2;
        Modifier modifier4;
        long color3;
        float strokeWidth3;
        Composer $composer2 = $composer.startRestartGroup(402841196);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.unit.Dp)764@30977L13,771@31190L18,766@31064L219:ProgressIndicator.kt#uh7d8r");
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
                    color2 = ProgressIndicatorDefaults.INSTANCE.getCircularColor($composer2, 6);
                    $dirty &= -897;
                } else {
                    color2 = j;
                }
                strokeWidth2 = i4 != 0 ? ProgressIndicatorDefaults.INSTANCE.m2481getCircularStrokeWidthD9Ej5fM() : f;
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
                ComposerKt.traceEventStart(402841196, $dirty, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:766)");
            }
            m2485CircularProgressIndicatorDUhRLBM(progress, modifier3, color2, strokeWidth2, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor($composer2, 6), ProgressIndicatorDefaults.INSTANCE.m2478getCircularDeterminateStrokeCapKaPHkGw(), $composer2, ($dirty & 14) | ProfileVerifier.CompilationStatus.f245xf2722a21 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168), 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$9
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
                    ProgressIndicatorKt.m2489CircularProgressIndicatorMBs18nI(progress, modifier5, j2, f2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: CircularProgressIndicator-aM-cp0Q, reason: not valid java name */
    public static final /* synthetic */ void m2490CircularProgressIndicatoraMcp0Q(Modifier modifier, long color, float strokeWidth, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        float f;
        Modifier.Companion modifier3;
        long color2;
        float strokeWidth2;
        Modifier modifier4;
        long color3;
        float strokeWidth3;
        Composer $composer2 = $composer.startRestartGroup(947193756);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.unit.Dp)780@31517L13,786@31716L18,782@31604L207:ProgressIndicator.kt#uh7d8r");
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
                    color2 = ProgressIndicatorDefaults.INSTANCE.getCircularColor($composer2, 6);
                    $dirty &= -113;
                } else {
                    color2 = j;
                }
                strokeWidth2 = i4 != 0 ? ProgressIndicatorDefaults.INSTANCE.m2481getCircularStrokeWidthD9Ej5fM() : f;
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
                ComposerKt.traceEventStart(947193756, $dirty, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:782)");
            }
            m2488CircularProgressIndicatorLxG7B9w(modifier3, color2, strokeWidth2, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor($composer2, 6), ProgressIndicatorDefaults.INSTANCE.m2479getCircularIndeterminateStrokeCapKaPHkGw(), $composer2, ($dirty & 14) | CpioConstants.C_ISBLK | ($dirty & 112) | ($dirty & 896), 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$10
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
                    ProgressIndicatorKt.m2490CircularProgressIndicatoraMcp0Q(modifier5, j2, f2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    public static final void m2503drawCircularIndicator42QJj7c(DrawScope $this$drawCircularIndicator_u2d42QJj7c, float startAngle, float sweep, long color, Stroke stroke) {
        float f = 2;
        float diameterOffset = stroke.getWidth() / f;
        float arcDimen = Size.m4118getWidthimpl($this$drawCircularIndicator_u2d42QJj7c.mo4773getSizeNHjbRc()) - (f * diameterOffset);
        DrawScope.CC.m4843drawArcyD3GUKo$default($this$drawCircularIndicator_u2d42QJj7c, color, startAngle, sweep, false, OffsetKt.Offset(diameterOffset, diameterOffset), androidx.compose.p001ui.geometry.SizeKt.Size(arcDimen, arcDimen), 0.0f, stroke, null, 0, 832, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawCircularIndicatorTrack-bw27NRU, reason: not valid java name */
    public static final void m2504drawCircularIndicatorTrackbw27NRU(DrawScope $this$drawCircularIndicatorTrack_u2dbw27NRU, long color, Stroke stroke) {
        m2503drawCircularIndicator42QJj7c($this$drawCircularIndicatorTrack_u2dbw27NRU, 0.0f, 360.0f, color, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawDeterminateCircularIndicator-42QJj7c, reason: not valid java name */
    public static final void m2505drawDeterminateCircularIndicator42QJj7c(DrawScope $this$drawDeterminateCircularIndicator_u2d42QJj7c, float startAngle, float sweep, long color, Stroke stroke) {
        m2503drawCircularIndicator42QJj7c($this$drawDeterminateCircularIndicator_u2d42QJj7c, startAngle, sweep, color, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawIndeterminateCircularIndicator-hrjfTZI, reason: not valid java name */
    public static final void m2506drawIndeterminateCircularIndicatorhrjfTZI(DrawScope $this$drawIndeterminateCircularIndicator_u2dhrjfTZI, float startAngle, float strokeWidth, float sweep, long color, Stroke stroke) {
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
        m2503drawCircularIndicator42QJj7c($this$drawIndeterminateCircularIndicator_u2dhrjfTZI, adjustedStartAngle, adjustedSweep, color, stroke);
    }

    public static final float getLinearIndicatorWidth() {
        return LinearIndicatorWidth;
    }

    public static final float getLinearIndicatorHeight() {
        return LinearIndicatorHeight;
    }

    public static final float getCircularIndicatorDiameter() {
        return CircularIndicatorDiameter;
    }
}
