package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: LazyStaggeredGridMeasurePolicy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aw\u0010\u0000\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a)\u0010\u001a\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010\u001d\u001a)\u0010\u001e\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010\u001d\u001a!\u0010\u001f\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010 \u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, m195d2 = {"rememberStaggeredGridMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "rememberStaggeredGridMeasurePolicy-1tP8Re8", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;FFLkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "afterPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/unit/LayoutDirection;)F", "beforePadding", "startPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/unit/LayoutDirection;)F", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LazyStaggeredGridMeasurePolicyKt {

    /* JADX INFO: compiled from: LazyStaggeredGridMeasurePolicy.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0040  */
    /* JADX WARN: Code duplicated, block: B:23:0x005b  */
    /* JADX WARN: Code duplicated, block: B:33:0x0076  */
    /* JADX WARN: Code duplicated, block: B:43:0x0093  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ea  */
    /* JADX INFO: renamed from: rememberStaggeredGridMeasurePolicy-1tP8Re8, reason: not valid java name */
    public static final Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> m1077rememberStaggeredGridMeasurePolicy1tP8Re8(final LazyStaggeredGridState state, final Function0<? extends LazyStaggeredGridItemProvider> function0, final PaddingValues contentPadding, final boolean reverseLayout, final Orientation orientation, final float mainAxisSpacing, float crossAxisSpacing, final CoroutineScope coroutineScope, final LazyGridStaggeredGridSlotsProvider slots, Composer $composer, int $changed) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        ComposerKt.sourceInformationMarkerStart($composer, -72951591, "C(rememberStaggeredGridMeasurePolicy)P(8,3!1,6,5,4:c#ui.unit.Dp,2:c#ui.unit.Dp)49@2134L2769:LazyStaggeredGridMeasurePolicy.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-72951591, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridMeasurePolicy (LazyStaggeredGridMeasurePolicy.kt:49)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 639488847, "CC(remember):LazyStaggeredGridMeasurePolicy.kt#9igjgp");
        boolean zChanged = $composer.changed(state);
        if ((($changed & 112) ^ 48) > 32 && $composer.changed(function0)) {
            z = true;
        } else if (($changed & 48) == 32) {
            z = true;
        } else {
            z = false;
        }
        boolean z8 = zChanged | z;
        if ((($changed & 896) ^ 384) > 256 && $composer.changed(contentPadding)) {
            z2 = true;
        } else if (($changed & 384) == 256) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean z9 = z8 | z2;
        if ((($changed & 7168) ^ 3072) > 2048 && $composer.changed(reverseLayout)) {
            z3 = true;
        } else if (($changed & 3072) == 2048) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z10 = z9 | z3;
        if (((57344 & $changed) ^ CpioConstants.C_ISBLK) > 16384 && $composer.changed(orientation)) {
            z4 = true;
        } else if (($changed & CpioConstants.C_ISBLK) == 16384) {
            z4 = true;
        } else {
            z4 = false;
        }
        boolean z11 = z10 | z4;
        if (((458752 & $changed) ^ ProfileVerifier.CompilationStatus.f245xf2722a21) > 131072 && $composer.changed(mainAxisSpacing)) {
            z5 = true;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 131072) {
            z5 = true;
        } else {
            z5 = false;
        }
        boolean z12 = z11 | z5;
        if (((3670016 & $changed) ^ 1572864) > 1048576 && $composer.changed(crossAxisSpacing)) {
            z6 = true;
        } else if (($changed & 1572864) == 1048576) {
            z6 = true;
        } else {
            z6 = false;
        }
        boolean z13 = z12 | z6;
        if (((234881024 & $changed) ^ 100663296) <= 67108864 || !$composer.changed(slots)) {
            z7 = ($changed & 100663296) == 67108864;
        }
        boolean invalid$iv = z13 | z7;
        Object value$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyStaggeredGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m1078invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyStaggeredGridMeasureResult m1078invoke0kLqBqw(LazyLayoutMeasureScope $this$null, long constraints) throws Throwable {
                    Snapshot this_$iv$iv;
                    CheckScrollableContainerConstraintsKt.m482checkScrollableContainerConstraintsK40F9xA(constraints, orientation);
                    LazyStaggeredGridSlots resolvedSlots = slots.mo1060invoke0kLqBqw($this$null, constraints);
                    boolean isVertical = orientation == Orientation.Vertical;
                    LazyStaggeredGridItemProvider itemProvider = function0.invoke();
                    int beforeContentPadding = $this$null.mo561roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.beforePadding(contentPadding, orientation, reverseLayout, $this$null.getLayoutDirection()));
                    int afterContentPadding = $this$null.mo561roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.afterPadding(contentPadding, orientation, reverseLayout, $this$null.getLayoutDirection()));
                    int startContentPadding = $this$null.mo561roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.startPadding(contentPadding, orientation, $this$null.getLayoutDirection()));
                    int maxMainAxisSize = isVertical ? Constraints.m6743getMaxHeightimpl(constraints) : Constraints.m6744getMaxWidthimpl(constraints);
                    int mainAxisAvailableSize = (maxMainAxisSize - beforeContentPadding) - afterContentPadding;
                    long contentOffset = isVertical ? IntOffsetKt.IntOffset(startContentPadding, beforeContentPadding) : IntOffsetKt.IntOffset(beforeContentPadding, startContentPadding);
                    PaddingValues $this$invoke_0kLqBqw_u24lambda_u240 = contentPadding;
                    float arg0$iv = PaddingKt.calculateStartPadding($this$invoke_0kLqBqw_u24lambda_u240, $this$null.getLayoutDirection());
                    float other$iv = PaddingKt.calculateEndPadding($this$invoke_0kLqBqw_u24lambda_u240, $this$null.getLayoutDirection());
                    int horizontalPadding = $this$null.mo561roundToPx0680j_4(C1979Dp.m6801constructorimpl(arg0$iv + other$iv));
                    PaddingValues $this$invoke_0kLqBqw_u24lambda_u241 = contentPadding;
                    float arg0$iv2 = $this$invoke_0kLqBqw_u24lambda_u241.getTop();
                    float other$iv2 = $this$invoke_0kLqBqw_u24lambda_u241.getBottom();
                    int verticalPadding = $this$null.mo561roundToPx0680j_4(C1979Dp.m6801constructorimpl(arg0$iv2 + other$iv2));
                    List<Integer> listCalculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(itemProvider, state.getPinnedItems(), state.getBeyondBoundsInfo());
                    Snapshot.Companion this_$iv = Snapshot.INSTANCE;
                    float f = mainAxisSpacing;
                    LazyStaggeredGridState lazyStaggeredGridState = state;
                    boolean z14 = reverseLayout;
                    CoroutineScope coroutineScope2 = coroutineScope;
                    MutableSnapshot $this$withMutableSnapshot_u24lambda_u242$iv = Snapshot.Companion.takeMutableSnapshot$default(this_$iv, null, null, 3, null);
                    try {
                        MutableSnapshot this_$iv$iv2 = $this$withMutableSnapshot_u24lambda_u242$iv;
                        Snapshot previous$iv$iv = this_$iv$iv2.makeCurrent();
                        try {
                            int iM6761constrainWidthK40F9xA = ConstraintsKt.m6761constrainWidthK40F9xA(constraints, horizontalPadding);
                            int horizontalPadding2 = ConstraintsKt.m6760constrainHeightK40F9xA(constraints, verticalPadding);
                            try {
                                try {
                                    LazyStaggeredGridMeasureResult measureResult = LazyStaggeredGridMeasureKt.m1076measureStaggeredGridsdzDtKU($this$null, lazyStaggeredGridState, listCalculateLazyLayoutPinnedIndices, itemProvider, resolvedSlots, Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : iM6761constrainWidthK40F9xA, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : horizontalPadding2, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0), isVertical, z14, contentOffset, mainAxisAvailableSize, $this$null.mo561roundToPx0680j_4(f), beforeContentPadding, afterContentPadding, coroutineScope2);
                                    try {
                                        this_$iv$iv2.restoreCurrent(previous$iv$iv);
                                        $this$withMutableSnapshot_u24lambda_u242$iv.apply().check();
                                        $this$withMutableSnapshot_u24lambda_u242$iv.dispose();
                                        LazyStaggeredGridState.applyMeasureResult$foundation_release$default(state, measureResult, false, 2, null);
                                        return measureResult;
                                    } catch (Throwable th) {
                                        th = th;
                                        $this$withMutableSnapshot_u24lambda_u242$iv.dispose();
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    this_$iv$iv = this_$iv$iv2;
                                    try {
                                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                                        throw th;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        $this$withMutableSnapshot_u24lambda_u242$iv.dispose();
                                        throw th;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                this_$iv$iv = this_$iv$iv2;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            this_$iv$iv = this_$iv$iv2;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                }
            };
            $composer.updateRememberedValue(value$iv);
        }
        Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> function2 = (Function2) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float startPadding(PaddingValues $this$startPadding, Orientation orientation, LayoutDirection layoutDirection) {
        switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
                return PaddingKt.calculateStartPadding($this$startPadding, layoutDirection);
            case 2:
                return $this$startPadding.getTop();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float beforePadding(PaddingValues $this$beforePadding, Orientation orientation, boolean reverseLayout, LayoutDirection layoutDirection) {
        switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
                return reverseLayout ? $this$beforePadding.getBottom() : $this$beforePadding.getTop();
            case 2:
                if (reverseLayout) {
                    return PaddingKt.calculateEndPadding($this$beforePadding, layoutDirection);
                }
                return PaddingKt.calculateStartPadding($this$beforePadding, layoutDirection);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float afterPadding(PaddingValues $this$afterPadding, Orientation orientation, boolean reverseLayout, LayoutDirection layoutDirection) {
        switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
                return reverseLayout ? $this$afterPadding.getTop() : $this$afterPadding.getBottom();
            case 2:
                if (reverseLayout) {
                    return PaddingKt.calculateStartPadding($this$afterPadding, layoutDirection);
                }
                return PaddingKt.calculateEndPadding($this$afterPadding, layoutDirection);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
