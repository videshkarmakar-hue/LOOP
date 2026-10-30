package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p001ui.unit.Velocity;
import androidx.compose.p001ui.unit.VelocityKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJM\u0010\u001d\u001a\u00020\u001e2=\u0010\u001f\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110!¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u001e0\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0#\u0012\u0006\u0012\u0004\u0018\u00010\u00010 H\u0086@¢\u0006\u0002\u0010$J#\u0010%\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001b\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0086@ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0006\u0010.\u001a\u00020\u000bJ\u001b\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020*H\u0086@ø\u0001\u0000¢\u0006\u0004\b1\u0010-J\u0018\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u0016ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u00020\u000bJ8\u00109\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ&\u0010:\u001a\u00020\u0016*\u00020\u00102\u0006\u0010;\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u0014\u0010>\u001a\u00020\u0016*\u00020\u0016ø\u0001\u0000¢\u0006\u0004\b?\u00105J\n\u0010>\u001a\u00020@*\u00020@J\u0014\u0010A\u001a\u00020\u0016*\u00020\u0016ø\u0001\u0000¢\u0006\u0004\bB\u00105J\u0014\u0010C\u001a\u00020**\u00020*ø\u0001\u0000¢\u0006\u0004\bD\u00105J\u0014\u0010E\u001a\u00020@*\u00020\u0016ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u0014\u0010E\u001a\u00020@*\u00020*ø\u0001\u0000¢\u0006\u0004\bH\u0010GJ\u0017\u0010I\u001a\u00020\u0016*\u00020@ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ\u0017\u0010L\u001a\u00020**\u00020@ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010KJ\u001c\u00109\u001a\u00020**\u00020*2\u0006\u0010N\u001a\u00020@ø\u0001\u0000¢\u0006\u0004\bO\u0010PR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u00020\u0012X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Q"}, m195d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "latestScrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "latestScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "I", "performScroll", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "delta", "shouldDispatchOverscroll", "getShouldDispatchOverscroll", "()Z", "dispatchDragEvents", "", "forEachDelta", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "dragDelta", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchUserInputDelta", "source", "dispatchUserInputDelta-57p9yIk", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doFlingAnimation", "Landroidx/compose/ui/unit/Velocity;", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isVertical", "onDragStopped", "initialVelocity", "onDragStopped-sF-c-tU", "performRawScroll", "scroll", "performRawScroll-MK-Hz9U", "(J)J", "pointerDirectionConfig", "Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "shouldScrollImmediately", "update", "dispatchScroll", "initialAvailableDelta", "dispatchScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "", "singleAxisOffset", "singleAxisOffset-MK-Hz9U", "singleAxisVelocity", "singleAxisVelocity-AH228Gc", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "toVelocity", "toVelocity-adjELrA", "newValue", "update-QWom1Mo", "(JF)J", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class ScrollingLogic {
    private FlingBehavior flingBehavior;
    private NestedScrollDispatcher nestedScrollDispatcher;
    private Orientation orientation;
    private OverscrollEffect overscrollEffect;
    private boolean reverseDirection;
    private ScrollableState scrollableState;
    private ScrollScope latestScrollScope = ScrollableKt.NoOpScrollScope;
    private int latestScrollSource = NestedScrollSource.INSTANCE.m5403getDragWNlRxjI();
    private final Function1<Offset, Offset> performScroll = new Function1<Offset, Offset>() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$performScroll$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Offset invoke(Offset offset) {
            return Offset.m4038boximpl(m688invokeMKHz9U(offset.getPackedValue()));
        }

        /* JADX INFO: renamed from: invoke-MK-Hz9U, reason: not valid java name */
        public final long m688invokeMKHz9U(long delta) {
            long consumedByPreScroll = this.this$0.nestedScrollDispatcher.m5394dispatchPreScrollOzD1aCk(delta, this.this$0.latestScrollSource);
            long scrollAvailableAfterPreScroll = Offset.m4053minusMKHz9U(delta, consumedByPreScroll);
            float singleAxisDeltaForSelfScroll = this.this$0.m682toFloatk4lQ0M(this.this$0.m678reverseIfNeededMKHz9U(this.this$0.m679singleAxisOffsetMKHz9U(scrollAvailableAfterPreScroll)));
            ScrollScope $this$invoke_MK_Hz9U_u24lambda_u240 = this.this$0.latestScrollScope;
            ScrollingLogic scrollingLogic = this.this$0;
            long consumedBySelfScroll = scrollingLogic.m678reverseIfNeededMKHz9U(scrollingLogic.m683toOffsettuRUvjQ($this$invoke_MK_Hz9U_u24lambda_u240.scrollBy(singleAxisDeltaForSelfScroll)));
            long deltaAvailableAfterScroll = Offset.m4053minusMKHz9U(scrollAvailableAfterPreScroll, consumedBySelfScroll);
            long consumedByPostScroll = this.this$0.nestedScrollDispatcher.m5392dispatchPostScrollDzOQY0M(consumedBySelfScroll, deltaAvailableAfterScroll, this.this$0.latestScrollSource);
            return Offset.m4054plusMKHz9U(Offset.m4054plusMKHz9U(consumedByPreScroll, consumedBySelfScroll), consumedByPostScroll);
        }
    };

    public ScrollingLogic(ScrollableState scrollableState, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, Orientation orientation, boolean reverseDirection, NestedScrollDispatcher nestedScrollDispatcher) {
        this.scrollableState = scrollableState;
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        this.orientation = orientation;
        this.reverseDirection = reverseDirection;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
    }

    /* JADX INFO: renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m683toOffsettuRUvjQ(float $this$toOffset_u2dtuRUvjQ) {
        if ($this$toOffset_u2dtuRUvjQ == 0.0f) {
            return Offset.INSTANCE.m4065getZeroF1C5BW0();
        }
        if (this.orientation == Orientation.Horizontal) {
            return OffsetKt.Offset($this$toOffset_u2dtuRUvjQ, 0.0f);
        }
        return OffsetKt.Offset(0.0f, $this$toOffset_u2dtuRUvjQ);
    }

    /* JADX INFO: renamed from: singleAxisOffset-MK-Hz9U, reason: not valid java name */
    public final long m679singleAxisOffsetMKHz9U(long $this$singleAxisOffset_u2dMK_u2dHz9U) {
        return Offset.m4043copydBAh8RU$default($this$singleAxisOffset_u2dMK_u2dHz9U, 0.0f, 0.0f, this.orientation == Orientation.Horizontal ? 1 : 2, null);
    }

    /* JADX INFO: renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m682toFloatk4lQ0M(long $this$toFloat_u2dk_u2d4lQ0M) {
        return this.orientation == Orientation.Horizontal ? Offset.m4049getXimpl($this$toFloat_u2dk_u2d4lQ0M) : Offset.m4050getYimpl($this$toFloat_u2dk_u2d4lQ0M);
    }

    /* JADX INFO: renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m681toFloatTH1AsA0(long $this$toFloat_u2dTH1AsA0) {
        return this.orientation == Orientation.Horizontal ? Velocity.m7042getXimpl($this$toFloat_u2dTH1AsA0) : Velocity.m7043getYimpl($this$toFloat_u2dTH1AsA0);
    }

    /* JADX INFO: renamed from: singleAxisVelocity-AH228Gc, reason: not valid java name */
    public final long m680singleAxisVelocityAH228Gc(long $this$singleAxisVelocity_u2dAH228Gc) {
        return Velocity.m7038copyOhffZ5M$default($this$singleAxisVelocity_u2dAH228Gc, 0.0f, 0.0f, this.orientation == Orientation.Horizontal ? 1 : 2, null);
    }

    /* JADX INFO: renamed from: update-QWom1Mo, reason: not valid java name */
    public final long m685updateQWom1Mo(long $this$update_u2dQWom1Mo, float newValue) {
        int i;
        Object obj;
        float f;
        float f2;
        if (this.orientation == Orientation.Horizontal) {
            i = 2;
            obj = null;
            f2 = 0.0f;
            f = newValue;
        } else {
            i = 1;
            obj = null;
            f = 0.0f;
            f2 = newValue;
        }
        return Velocity.m7038copyOhffZ5M$default($this$update_u2dQWom1Mo, f, f2, i, obj);
    }

    public final float reverseIfNeeded(float $this$reverseIfNeeded) {
        return this.reverseDirection ? (-1) * $this$reverseIfNeeded : $this$reverseIfNeeded;
    }

    /* JADX INFO: renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m678reverseIfNeededMKHz9U(long $this$reverseIfNeeded_u2dMK_u2dHz9U) {
        return this.reverseDirection ? Offset.m4056timestuRUvjQ($this$reverseIfNeeded_u2dMK_u2dHz9U, -1.0f) : $this$reverseIfNeeded_u2dMK_u2dHz9U;
    }

    /* JADX INFO: renamed from: toVelocity-adjELrA, reason: not valid java name */
    public final long m684toVelocityadjELrA(float $this$toVelocity_u2dadjELrA) {
        return VelocityKt.Velocity(this.orientation == Orientation.Horizontal ? $this$toVelocity_u2dadjELrA : 0.0f, this.orientation == Orientation.Vertical ? $this$toVelocity_u2dadjELrA : 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: dispatchScroll-3eAAhYA, reason: not valid java name */
    public final long m673dispatchScroll3eAAhYA(ScrollScope $this$dispatchScroll_u2d3eAAhYA, long initialAvailableDelta, int source) {
        this.latestScrollSource = source;
        this.latestScrollScope = $this$dispatchScroll_u2d3eAAhYA;
        OverscrollEffect overscroll = this.overscrollEffect;
        if (NestedScrollSource.m5398equalsimpl0(source, NestedScrollSource.INSTANCE.m5406getWheelWNlRxjI())) {
            return this.performScroll.invoke(Offset.m4038boximpl(initialAvailableDelta)).getPackedValue();
        }
        if (overscroll != null && getShouldDispatchOverscroll()) {
            return overscroll.mo436applyToScrollRhakbz0(initialAvailableDelta, source, this.performScroll);
        }
        return this.performScroll.invoke(Offset.m4038boximpl(initialAvailableDelta)).getPackedValue();
    }

    private final boolean getShouldDispatchOverscroll() {
        return this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward();
    }

    /* JADX INFO: renamed from: performRawScroll-MK-Hz9U, reason: not valid java name */
    public final long m677performRawScrollMKHz9U(long scroll) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.INSTANCE.m4065getZeroF1C5BW0();
        }
        return m683toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m682toFloatk4lQ0M(scroll)))));
    }

    /* JADX INFO: renamed from: onDragStopped-sF-c-tU, reason: not valid java name */
    public final Object m676onDragStoppedsFctU(long initialVelocity, Continuation<? super Unit> continuation) {
        long availableVelocity = m680singleAxisVelocityAH228Gc(initialVelocity);
        Function2 performFling = new ScrollingLogic$onDragStopped$performFling$1(this, null);
        OverscrollEffect overscroll = this.overscrollEffect;
        if (overscroll != null && getShouldDispatchOverscroll()) {
            Object objMo435applyToFlingBMRW4eQ = overscroll.mo435applyToFlingBMRW4eQ(availableVelocity, performFling, continuation);
            return objMo435applyToFlingBMRW4eQ == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo435applyToFlingBMRW4eQ : Unit.INSTANCE;
        }
        Object objInvoke = performFling.invoke(Velocity.m7033boximpl(availableVelocity), continuation);
        return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: doFlingAnimation-QWom1Mo, reason: not valid java name */
    public final Object m675doFlingAnimationQWom1Mo(long available, Continuation<? super Velocity> continuation) {
        ScrollingLogic$doFlingAnimation$1 scrollingLogic$doFlingAnimation$1;
        Ref.LongRef result;
        if (continuation instanceof ScrollingLogic$doFlingAnimation$1) {
            scrollingLogic$doFlingAnimation$1 = (ScrollingLogic$doFlingAnimation$1) continuation;
            if ((scrollingLogic$doFlingAnimation$1.label & Integer.MIN_VALUE) != 0) {
                scrollingLogic$doFlingAnimation$1.label -= Integer.MIN_VALUE;
            } else {
                scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, continuation);
            }
        } else {
            scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, continuation);
        }
        ScrollingLogic$doFlingAnimation$1 scrollingLogic$doFlingAnimation$2 = scrollingLogic$doFlingAnimation$1;
        Object $result = scrollingLogic$doFlingAnimation$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (scrollingLogic$doFlingAnimation$2.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Ref.LongRef result2 = new Ref.LongRef();
                result2.element = available;
                ScrollableState scrollableState = this.scrollableState;
                ScrollingLogic$doFlingAnimation$2 scrollingLogic$doFlingAnimation$3 = new ScrollingLogic$doFlingAnimation$2(this, result2, available, null);
                scrollingLogic$doFlingAnimation$2.L$0 = result2;
                scrollingLogic$doFlingAnimation$2.label = 1;
                if (ScrollableState.CC.scroll$default(scrollableState, null, scrollingLogic$doFlingAnimation$3, scrollingLogic$doFlingAnimation$2, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                result = result2;
                break;
                break;
            case 1:
                result = (Ref.LongRef) scrollingLogic$doFlingAnimation$2.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Velocity.m7033boximpl(result.element);
    }

    public final boolean shouldScrollImmediately() {
        if (!this.scrollableState.isScrollInProgress()) {
            OverscrollEffect overscrollEffect = this.overscrollEffect;
            if (!(overscrollEffect != null ? overscrollEffect.isInProgress() : false)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: dispatchUserInputDelta-57p9yIk, reason: not valid java name */
    public final Object m674dispatchUserInputDelta57p9yIk(long delta, int source, Continuation<? super Unit> continuation) {
        Object objScroll = this.scrollableState.scroll(MutatePriority.UserInput, new ScrollingLogic$dispatchUserInputDelta$2(this, delta, source, null), continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollingLogic$dispatchDragEvents$2 */
    /* JADX INFO: compiled from: Scrollable.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.ScrollingLogic$dispatchDragEvents$2", m210f = "Scrollable.kt", m211i = {}, m212l = {802}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C04112 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> $forEachDelta;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ScrollingLogic this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C04112(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, ScrollingLogic scrollingLogic, Continuation<? super C04112> continuation) {
            super(2, continuation);
            this.$forEachDelta = function2;
            this.this$0 = scrollingLogic;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04112 c04112 = new C04112(this.$forEachDelta, this.this$0, continuation);
            c04112.L$0 = obj;
            return c04112;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((C04112) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final ScrollScope $this$scroll = (ScrollScope) this.L$0;
                    Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> function2 = this.$forEachDelta;
                    final ScrollingLogic scrollingLogic = this.this$0;
                    Function1<DragEvent.DragDelta, Unit> function1 = new Function1<DragEvent.DragDelta, Unit>() { // from class: androidx.compose.foundation.gestures.ScrollingLogic.dispatchDragEvents.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DragEvent.DragDelta dragDelta) {
                            invoke2(dragDelta);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DragEvent.DragDelta it) {
                            scrollingLogic.m673dispatchScroll3eAAhYA($this$scroll, scrollingLogic.m679singleAxisOffsetMKHz9U(it.getDelta()), NestedScrollSource.INSTANCE.m5403getDragWNlRxjI());
                        }
                    };
                    this.label = 1;
                    if (function2.invoke(function1, this) == coroutine_suspended) {
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

    public final Object dispatchDragEvents(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objScroll = this.scrollableState.scroll(MutatePriority.UserInput, new C04112(function2, this, null), continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }

    public final boolean update(ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean reverseDirection, FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher) {
        boolean resetPointerInputHandling = false;
        if (!Intrinsics.areEqual(this.scrollableState, scrollableState)) {
            this.scrollableState = scrollableState;
            resetPointerInputHandling = true;
        }
        this.overscrollEffect = overscrollEffect;
        if (this.orientation != orientation) {
            this.orientation = orientation;
            resetPointerInputHandling = true;
        }
        if (this.reverseDirection != reverseDirection) {
            this.reverseDirection = reverseDirection;
            resetPointerInputHandling = true;
        }
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        return resetPointerInputHandling;
    }

    public final PointerDirectionConfig pointerDirectionConfig() {
        return DragGestureDetectorKt.toPointerDirectionConfig(this.orientation);
    }

    public final boolean isVertical() {
        return this.orientation == Orientation.Vertical;
    }
}
