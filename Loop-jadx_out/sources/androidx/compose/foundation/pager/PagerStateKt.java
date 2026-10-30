package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.layout.AlignmentLine;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.DpRect;
import androidx.compose.p001ui.unit.FontScaling;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PagerState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000m\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\r\u001a(\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0003\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015\u001a\u0017\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0015H\u0082\b\u001a/\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0003\u0010\u001c\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015H\u0007¢\u0006\u0002\u0010\u001d\u001aO\u0010\u001e\u001a\u00020\u0017*\u00020\u001f2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00132\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130#2\u001d\u0010$\u001a\u0019\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00170%¢\u0006\u0002\b'H\u0082@¢\u0006\u0002\u0010(\u001a\u0012\u0010)\u001a\u00020\u0017*\u00020\u0010H\u0080@¢\u0006\u0002\u0010*\u001a\u0012\u0010+\u001a\u00020\u0017*\u00020\u0010H\u0080@¢\u0006\u0002\u0010*\u001a\u0014\u0010,\u001a\u00020-*\u00020.2\u0006\u0010\u0014\u001a\u00020\nH\u0000\u001a\u0014\u0010/\u001a\u00020-*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\nH\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u00060"}, m195d2 = {"DefaultPositionThreshold", "Landroidx/compose/ui/unit/Dp;", "getDefaultPositionThreshold", "()F", "F", "EmptyLayoutInfo", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "getEmptyLayoutInfo", "()Landroidx/compose/foundation/pager/PagerMeasureResult;", "MaxPagesForAnimateScroll", "", "PagesToPrefetch", "UnitDensity", "androidx/compose/foundation/pager/PagerStateKt$UnitDensity$1", "Landroidx/compose/foundation/pager/PagerStateKt$UnitDensity$1;", "PagerState", "Landroidx/compose/foundation/pager/PagerState;", "currentPage", "currentPageOffsetFraction", "", "pageCount", "Lkotlin/Function0;", "debugLog", "", "generateMsg", "", "rememberPagerState", "initialPage", "initialPageOffsetFraction", "(IFLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/pager/PagerState;", "animateScrollToPage", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "targetPage", "targetPageOffsetToSnappedPosition", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "updateTargetPage", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;IFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToNextPage", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToPreviousPage", "calculateNewMaxScrollOffset", "", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "calculateNewMinScrollOffset", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PagerStateKt {
    private static final int MaxPagesForAnimateScroll = 3;
    public static final int PagesToPrefetch = 1;
    private static final float DefaultPositionThreshold = C1979Dp.m6801constructorimpl(56);
    private static final PagerMeasureResult EmptyLayoutInfo = new PagerMeasureResult(CollectionsKt.emptyList(), 0, 0, 0, Orientation.Horizontal, 0, 0, false, 0, null, null, 0.0f, 0, false, SnapPosition.Start.INSTANCE, new MeasureResult() { // from class: androidx.compose.foundation.pager.PagerStateKt$EmptyLayoutInfo$1
        private final Map<AlignmentLine, Integer> alignmentLines = MapsKt.emptyMap();
        private final int height;
        private final int width;

        public static /* synthetic */ void getAlignmentLines$annotations() {
        }

        @Override // androidx.compose.p001ui.layout.MeasureResult
        public /* synthetic */ Function1 getRulers() {
            return MeasureResult.CC.$default$getRulers(this);
        }

        @Override // androidx.compose.p001ui.layout.MeasureResult
        public int getWidth() {
            return this.width;
        }

        @Override // androidx.compose.p001ui.layout.MeasureResult
        public int getHeight() {
            return this.height;
        }

        @Override // androidx.compose.p001ui.layout.MeasureResult
        public Map<AlignmentLine, Integer> getAlignmentLines() {
            return this.alignmentLines;
        }

        @Override // androidx.compose.p001ui.layout.MeasureResult
        public void placeChildren() {
        }
    }, false, null, null, 393216, null);
    private static final PagerStateKt$UnitDensity$1 UnitDensity = new Density() { // from class: androidx.compose.foundation.pager.PagerStateKt$UnitDensity$1
        private final float density = 1.0f;
        private final float fontScale = 1.0f;

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: roundToPx--R2X_6o */
        public /* synthetic */ int mo560roundToPxR2X_6o(long j) {
            return Density.CC.m6765$default$roundToPxR2X_6o(this, j);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: roundToPx-0680j_4 */
        public /* synthetic */ int mo561roundToPx0680j_4(float f) {
            return Density.CC.m6766$default$roundToPx0680j_4(this, f);
        }

        @Override // androidx.compose.p001ui.unit.FontScaling
        /* JADX INFO: renamed from: toDp-GaN1DYA */
        public /* synthetic */ float mo562toDpGaN1DYA(long j) {
            return FontScaling.CC.m6910$default$toDpGaN1DYA(this, j);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public /* synthetic */ float mo563toDpu2uoSUM(float f) {
            return Density.CC.m6767$default$toDpu2uoSUM(this, f);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public /* synthetic */ float mo564toDpu2uoSUM(int i) {
            return Density.CC.m6768$default$toDpu2uoSUM((Density) this, i);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toDpSize-k-rfVVM */
        public /* synthetic */ long mo565toDpSizekrfVVM(long j) {
            return Density.CC.m6769$default$toDpSizekrfVVM(this, j);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toPx--R2X_6o */
        public /* synthetic */ float mo566toPxR2X_6o(long j) {
            return Density.CC.m6770$default$toPxR2X_6o(this, j);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toPx-0680j_4 */
        public /* synthetic */ float mo567toPx0680j_4(float f) {
            return Density.CC.m6771$default$toPx0680j_4(this, f);
        }

        @Override // androidx.compose.p001ui.unit.Density
        public /* synthetic */ Rect toRect(DpRect dpRect) {
            return Density.CC.$default$toRect(this, dpRect);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toSize-XkaWNTQ */
        public /* synthetic */ long mo568toSizeXkaWNTQ(long j) {
            return Density.CC.m6772$default$toSizeXkaWNTQ(this, j);
        }

        @Override // androidx.compose.p001ui.unit.FontScaling
        /* JADX INFO: renamed from: toSp-0xMU5do */
        public /* synthetic */ long mo569toSp0xMU5do(float f) {
            return FontScaling.CC.m6911$default$toSp0xMU5do(this, f);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public /* synthetic */ long mo570toSpkPz2Gy4(float f) {
            return Density.CC.m6773$default$toSpkPz2Gy4(this, f);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public /* synthetic */ long mo571toSpkPz2Gy4(int i) {
            return Density.CC.m6774$default$toSpkPz2Gy4((Density) this, i);
        }

        @Override // androidx.compose.p001ui.unit.Density
        public float getDensity() {
            return this.density;
        }

        @Override // androidx.compose.p001ui.unit.FontScaling
        public float getFontScale() {
            return this.fontScale;
        }
    };

    public static final PagerState rememberPagerState(final int initialPage, final float initialPageOffsetFraction, final Function0<Integer> function0, Composer $composer, int $changed, int i) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -1210768637, "C(rememberPagerState)*80@3650L130,80@3600L180:PagerState.kt#g6yjnt");
        if ((i & 1) != 0) {
            initialPage = 0;
        }
        if ((i & 2) != 0) {
            initialPageOffsetFraction = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1210768637, $changed, -1, "androidx.compose.foundation.pager.rememberPagerState (PagerState.kt:79)");
        }
        Object[] objArr = new Object[0];
        Saver<DefaultPagerState, ?> saver = DefaultPagerState.INSTANCE.getSaver();
        ComposerKt.sourceInformationMarkerStart($composer, -2077657790, "CC(remember):PagerState.kt#9igjgp");
        boolean invalid$iv = (((($changed & 896) ^ 384) > 256 && $composer.changed(function0)) || ($changed & 384) == 256) | (((($changed & 14) ^ 6) > 4 && $composer.changed(initialPage)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer.changed(initialPageOffsetFraction)) || ($changed & 48) == 32);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new Function0<DefaultPagerState>() { // from class: androidx.compose.foundation.pager.PagerStateKt$rememberPagerState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DefaultPagerState invoke() {
                    return new DefaultPagerState(initialPage, initialPageOffsetFraction, function0);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Object objM3889rememberSaveable = RememberSaveableKt.m3889rememberSaveable(objArr, saver, (String) null, (Function0<? extends Object>) value$iv, $composer, 0, 4);
        DefaultPagerState $this$rememberPagerState_u24lambda_u241 = (DefaultPagerState) objM3889rememberSaveable;
        $this$rememberPagerState_u24lambda_u241.getPageCountState().setValue(function0);
        DefaultPagerState defaultPagerState = (DefaultPagerState) objM3889rememberSaveable;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultPagerState;
    }

    public static /* synthetic */ PagerState PagerState$default(int i, float f, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        return PagerState(i, f, function0);
    }

    public static final PagerState PagerState(int currentPage, float currentPageOffsetFraction, Function0<Integer> function0) {
        return new DefaultPagerState(currentPage, currentPageOffsetFraction, function0);
    }

    public static final Object animateToNextPage(PagerState $this$animateToNextPage, Continuation<? super Unit> continuation) {
        Object objAnimateScrollToPage$default;
        return ($this$animateToNextPage.getCurrentPage() + 1 >= $this$animateToNextPage.getPageCount() || (objAnimateScrollToPage$default = PagerState.animateScrollToPage$default($this$animateToNextPage, $this$animateToNextPage.getCurrentPage() + 1, 0.0f, null, continuation, 6, null)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : objAnimateScrollToPage$default;
    }

    public static final Object animateToPreviousPage(PagerState $this$animateToPreviousPage, Continuation<? super Unit> continuation) {
        Object objAnimateScrollToPage$default;
        return ($this$animateToPreviousPage.getCurrentPage() + (-1) < 0 || (objAnimateScrollToPage$default = PagerState.animateScrollToPage$default($this$animateToPreviousPage, $this$animateToPreviousPage.getCurrentPage() + (-1), 0.0f, null, continuation, 6, null)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : objAnimateScrollToPage$default;
    }

    public static final float getDefaultPositionThreshold() {
        return DefaultPositionThreshold;
    }

    public static final PagerMeasureResult getEmptyLayoutInfo() {
        return EmptyLayoutInfo;
    }

    private static final void debugLog(Function0<String> function0) {
    }

    public static final long calculateNewMaxScrollOffset(PagerLayoutInfo $this$calculateNewMaxScrollOffset, int pageCount) {
        int pageSizeWithSpacing = $this$calculateNewMaxScrollOffset.getPageSpacing() + $this$calculateNewMaxScrollOffset.getPageSize();
        long maxScrollPossible = (((long) pageCount) * ((long) pageSizeWithSpacing)) + ((long) $this$calculateNewMaxScrollOffset.getBeforeContentPadding()) + ((long) $this$calculateNewMaxScrollOffset.getAfterContentPadding());
        int layoutSize = $this$calculateNewMaxScrollOffset.getOrientation() == Orientation.Horizontal ? IntSize.m6975getWidthimpl($this$calculateNewMaxScrollOffset.mo1103getViewportSizeYbymL2g()) : IntSize.m6974getHeightimpl($this$calculateNewMaxScrollOffset.mo1103getViewportSizeYbymL2g());
        int snapPositionDiscount = layoutSize - RangesKt.coerceIn($this$calculateNewMaxScrollOffset.getSnapPosition().position(layoutSize, $this$calculateNewMaxScrollOffset.getPageSize(), $this$calculateNewMaxScrollOffset.getBeforeContentPadding(), $this$calculateNewMaxScrollOffset.getAfterContentPadding(), pageCount - 1, pageCount), 0, layoutSize);
        return RangesKt.coerceAtLeast(maxScrollPossible - ((long) snapPositionDiscount), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long calculateNewMinScrollOffset(PagerMeasureResult $this$calculateNewMinScrollOffset, int pageCount) {
        int layoutSize = $this$calculateNewMinScrollOffset.getOrientation() == Orientation.Horizontal ? IntSize.m6975getWidthimpl($this$calculateNewMinScrollOffset.mo1103getViewportSizeYbymL2g()) : IntSize.m6974getHeightimpl($this$calculateNewMinScrollOffset.mo1103getViewportSizeYbymL2g());
        return RangesKt.coerceIn($this$calculateNewMinScrollOffset.getSnapPosition().position(layoutSize, $this$calculateNewMinScrollOffset.getPageSize(), $this$calculateNewMinScrollOffset.getBeforeContentPadding(), $this$calculateNewMinScrollOffset.getAfterContentPadding(), 0, pageCount), 0, layoutSize);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerStateKt$animateScrollToPage$2 */
    /* JADX INFO: compiled from: PagerState.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.pager.PagerStateKt$animateScrollToPage$2", m210f = "PagerState.kt", m211i = {}, m212l = {870}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C06862 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ int $targetPage;
        final /* synthetic */ float $targetPageOffsetToSnappedPosition;
        final /* synthetic */ LazyLayoutAnimateScrollScope $this_animateScrollToPage;
        final /* synthetic */ Function2<ScrollScope, Integer, Unit> $updateTargetPage;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C06862(Function2<? super ScrollScope, ? super Integer, Unit> function2, int i, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, float f, AnimationSpec<Float> animationSpec, Continuation<? super C06862> continuation) {
            super(2, continuation);
            this.$updateTargetPage = function2;
            this.$targetPage = i;
            this.$this_animateScrollToPage = lazyLayoutAnimateScrollScope;
            this.$targetPageOffsetToSnappedPosition = f;
            this.$animationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06862 c06862 = new C06862(this.$updateTargetPage, this.$targetPage, this.$this_animateScrollToPage, this.$targetPageOffsetToSnappedPosition, this.$animationSpec, continuation);
            c06862.L$0 = obj;
            return c06862;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((C06862) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            int preJumpPosition;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final ScrollScope $this$scroll = (ScrollScope) this.L$0;
                    this.$updateTargetPage.invoke($this$scroll, Boxing.boxInt(this.$targetPage));
                    boolean forward = this.$targetPage > this.$this_animateScrollToPage.getFirstVisibleItemIndex();
                    int visiblePages = (this.$this_animateScrollToPage.getLastVisibleItemIndex() - this.$this_animateScrollToPage.getFirstVisibleItemIndex()) + 1;
                    if (((forward && this.$targetPage > this.$this_animateScrollToPage.getLastVisibleItemIndex()) || (!forward && this.$targetPage < this.$this_animateScrollToPage.getFirstVisibleItemIndex())) && Math.abs(this.$targetPage - this.$this_animateScrollToPage.getFirstVisibleItemIndex()) >= 3) {
                        if (forward) {
                            preJumpPosition = RangesKt.coerceAtLeast(this.$targetPage - visiblePages, this.$this_animateScrollToPage.getFirstVisibleItemIndex());
                        } else {
                            preJumpPosition = RangesKt.coerceAtMost(this.$targetPage + visiblePages, this.$this_animateScrollToPage.getFirstVisibleItemIndex());
                        }
                        this.$this_animateScrollToPage.snapToItem($this$scroll, preJumpPosition, 0);
                    }
                    float displacement = this.$this_animateScrollToPage.calculateDistanceTo(this.$targetPage) + this.$targetPageOffsetToSnappedPosition;
                    final Ref.FloatRef previousValue = new Ref.FloatRef();
                    this.label = 1;
                    if (SuspendAnimationKt.animate$default(0.0f, displacement, 0.0f, this.$animationSpec, new Function2<Float, Float, Unit>() { // from class: androidx.compose.foundation.pager.PagerStateKt.animateScrollToPage.2.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Float f2) {
                            invoke(f.floatValue(), f2.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float currentValue, float f) {
                            float delta = currentValue - previousValue.element;
                            float consumed = $this$scroll.scrollBy(delta);
                            previousValue.element += consumed;
                        }
                    }, this, 4, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object animateScrollToPage(LazyLayoutAnimateScrollScope $this$animateScrollToPage, int targetPage, float targetPageOffsetToSnappedPosition, AnimationSpec<Float> animationSpec, Function2<? super ScrollScope, ? super Integer, Unit> function2, Continuation<? super Unit> continuation) {
        Object objScroll = $this$animateScrollToPage.scroll(new C06862(function2, targetPage, $this$animateScrollToPage, targetPageOffsetToSnappedPosition, animationSpec, null), continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }
}
