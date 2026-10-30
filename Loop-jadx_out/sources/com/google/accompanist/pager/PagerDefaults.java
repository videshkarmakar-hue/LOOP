package com.google.accompanist.pager;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import dev.chrisbanes.snapper.LazyListKt;
import dev.chrisbanes.snapper.SnapOffsets;
import dev.chrisbanes.snapper.SnapperFlingBehavior;
import dev.chrisbanes.snapper.SnapperFlingBehaviorDefaults;
import dev.chrisbanes.snapper.SnapperLayoutInfo;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Pager.kt */
/* JADX INFO: loaded from: classes18.dex */
@Deprecated(message = "\naccompanist/pager is deprecated.\nThe androidx.compose equivalent of Pager is androidx.compose.foundation.pager.Pager.\nFor more migration information, please visit https://google.github.io/accompanist/pager/#migration\n")
@Metadata(m194d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JZ\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b2\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 JD\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0082\u0001\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2<\u0010#\u001a8\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f0\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%R(\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tRR\u0010\n\u001a8\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, m195d2 = {"Lcom/google/accompanist/pager/PagerDefaults;", "", "()V", "singlePageFlingDistance", "Lkotlin/Function1;", "Ldev/chrisbanes/snapper/SnapperLayoutInfo;", "", "getSinglePageFlingDistance$annotations", "getSinglePageFlingDistance", "()Lkotlin/jvm/functions/Function1;", "singlePageSnapIndex", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "startIndex", "targetIndex", "getSinglePageSnapIndex$annotations", "getSinglePageSnapIndex", "()Lkotlin/jvm/functions/Function3;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "state", "Lcom/google/accompanist/pager/PagerState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "maximumFlingDistance", "endContentPadding", "Landroidx/compose/ui/unit/Dp;", "flingBehavior-FJfuzF0", "(Lcom/google/accompanist/pager/PagerState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;FLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "flingBehavior--jt2gSs", "(Lcom/google/accompanist/pager/PagerState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;FLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "snapIndex", "flingBehavior-hGBTI10", "(Lcom/google/accompanist/pager/PagerState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;FLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "pager_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PagerDefaults {
    public static final int $stable = 0;
    public static final PagerDefaults INSTANCE = new PagerDefaults();
    private static final Function1<SnapperLayoutInfo, Float> singlePageFlingDistance = new Function1<SnapperLayoutInfo, Float>() { // from class: com.google.accompanist.pager.PagerDefaults$singlePageFlingDistance$1
        @Override // kotlin.jvm.functions.Function1
        public final Float invoke(SnapperLayoutInfo layoutInfo) {
            Intrinsics.checkNotNullParameter(layoutInfo, "layoutInfo");
            return Float.valueOf(layoutInfo.getEndScrollOffset() - layoutInfo.getStartScrollOffset());
        }
    };
    private static final Function3<SnapperLayoutInfo, Integer, Integer, Integer> singlePageSnapIndex = new Function3<SnapperLayoutInfo, Integer, Integer, Integer>() { // from class: com.google.accompanist.pager.PagerDefaults$singlePageSnapIndex$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Integer invoke(SnapperLayoutInfo snapperLayoutInfo, Integer num, Integer num2) {
            return invoke(snapperLayoutInfo, num.intValue(), num2.intValue());
        }

        public final Integer invoke(SnapperLayoutInfo layoutInfo, int startIndex, int targetIndex) {
            Intrinsics.checkNotNullParameter(layoutInfo, "layoutInfo");
            return Integer.valueOf(RangesKt.coerceIn(RangesKt.coerceIn(targetIndex, startIndex - 1, startIndex + 1), 0, layoutInfo.getTotalItemsCount() - 1));
        }
    };

    @Deprecated(message = "MaximumFlingDistance has been deprecated in Snapper")
    public static /* synthetic */ void getSinglePageFlingDistance$annotations() {
    }

    public static /* synthetic */ void getSinglePageSnapIndex$annotations() {
    }

    private PagerDefaults() {
    }

    public final Function1<SnapperLayoutInfo, Float> getSinglePageFlingDistance() {
        return singlePageFlingDistance;
    }

    public final Function3<SnapperLayoutInfo, Integer, Integer, Integer> getSinglePageSnapIndex() {
        return singlePageSnapIndex;
    }

    @Deprecated(message = "\n            accompanist/pager is deprecated.\n            The androidx.compose equivalent of Pager is androidx.compose.foundation.pager.Pager.\n            For more migration information, please visit https://google.github.io/accompanist/pager/#migration\n    ")
    /* JADX INFO: renamed from: flingBehavior-FJfuzF0, reason: not valid java name */
    public final FlingBehavior m7177flingBehaviorFJfuzF0(PagerState state, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Function1<? super SnapperLayoutInfo, Float> function1, float endContentPadding, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(state, "state");
        $composer.startReplaceableGroup(1345971532);
        DecayAnimationSpec<Float> decayAnimationSpecRememberSplineBasedDecay = (i & 2) != 0 ? SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay($composer, 0) : decayAnimationSpec;
        AnimationSpec<Float> springAnimationSpec = (i & 4) != 0 ? SnapperFlingBehaviorDefaults.INSTANCE.getSpringAnimationSpec() : animationSpec;
        Function1<? super SnapperLayoutInfo, Float> function2 = (i & 8) != 0 ? singlePageFlingDistance : function1;
        float endContentPadding2 = (i & 16) != 0 ? C1979Dp.m6801constructorimpl(0) : endContentPadding;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1345971532, $changed, -1, "com.google.accompanist.pager.PagerDefaults.flingBehavior (Pager.kt:139)");
        }
        SnapperFlingBehavior snapperFlingBehaviorM7687rememberSnapperFlingBehaviorosbwsH8 = LazyListKt.m7687rememberSnapperFlingBehaviorosbwsH8(state.getLazyListState(), SnapOffsets.INSTANCE.getStart(), endContentPadding2, decayAnimationSpecRememberSplineBasedDecay, springAnimationSpec, function2, $composer, (($changed >> 6) & 896) | CpioConstants.C_ISNWK | (458752 & ($changed << 6)), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return snapperFlingBehaviorM7687rememberSnapperFlingBehaviorosbwsH8;
    }

    @Deprecated(message = "\naccompanist/pager is deprecated.\nThe androidx.compose equivalent of Pager is androidx.compose.foundation.pager.Pager\nFor more migration information, please visit https://google.github.io/accompanist/pager/#migration\n")
    /* JADX INFO: renamed from: flingBehavior-hGBTI10, reason: not valid java name */
    public final FlingBehavior m7178flingBehaviorhGBTI10(PagerState state, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, float endContentPadding, Function3<? super SnapperLayoutInfo, ? super Integer, ? super Integer, Integer> snapIndex, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(snapIndex, "snapIndex");
        $composer.startReplaceableGroup(-776119664);
        DecayAnimationSpec<Float> decayAnimationSpecRememberSplineBasedDecay = (i & 2) != 0 ? SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay($composer, 0) : decayAnimationSpec;
        AnimationSpec<Float> springAnimationSpec = (i & 4) != 0 ? SnapperFlingBehaviorDefaults.INSTANCE.getSpringAnimationSpec() : animationSpec;
        float endContentPadding2 = (i & 8) != 0 ? C1979Dp.m6801constructorimpl(0) : endContentPadding;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-776119664, $changed, -1, "com.google.accompanist.pager.PagerDefaults.flingBehavior (Pager.kt:181)");
        }
        SnapperFlingBehavior snapperFlingBehaviorM7688rememberSnapperFlingBehaviorosbwsH8 = LazyListKt.m7688rememberSnapperFlingBehaviorosbwsH8(state.getLazyListState(), SnapOffsets.INSTANCE.getStart(), endContentPadding2, decayAnimationSpecRememberSplineBasedDecay, springAnimationSpec, snapIndex, $composer, (($changed >> 3) & 896) | CpioConstants.C_ISNWK | (458752 & ($changed << 3)), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return snapperFlingBehaviorM7688rememberSnapperFlingBehaviorosbwsH8;
    }

    @Deprecated(message = "\naccompanist/pager is deprecated.\nFor more migration information, please visit https://google.github.io/accompanist/pager/#migration\n", replaceWith = @ReplaceWith(expression = "androidx.compose.foundation.pager.PagerDefaults.flingBehavior(state = state)", imports = {"androidx.compose.foundation.pager.PagerDefaults"}))
    /* JADX INFO: renamed from: flingBehavior--jt2gSs, reason: not valid java name */
    public final FlingBehavior m7176flingBehaviorjt2gSs(PagerState state, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, float endContentPadding, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(state, "state");
        $composer.startReplaceableGroup(132228799);
        DecayAnimationSpec<Float> decayAnimationSpecRememberSplineBasedDecay = (i & 2) != 0 ? SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay($composer, 0) : decayAnimationSpec;
        AnimationSpec<Float> springAnimationSpec = (i & 4) != 0 ? SnapperFlingBehaviorDefaults.INSTANCE.getSpringAnimationSpec() : animationSpec;
        float endContentPadding2 = (i & 8) != 0 ? C1979Dp.m6801constructorimpl(0) : endContentPadding;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(132228799, $changed, -1, "com.google.accompanist.pager.PagerDefaults.flingBehavior (Pager.kt:220)");
        }
        FlingBehavior flingBehaviorM7178flingBehaviorhGBTI10 = m7178flingBehaviorhGBTI10(state, decayAnimationSpecRememberSplineBasedDecay, springAnimationSpec, endContentPadding2, singlePageSnapIndex, $composer, ($changed & 14) | 576 | ($changed & 7168) | (($changed << 3) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return flingBehaviorM7178flingBehaviorhGBTI10;
    }
}
