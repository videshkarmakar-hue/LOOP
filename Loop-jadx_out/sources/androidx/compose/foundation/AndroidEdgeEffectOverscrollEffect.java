package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.geometry.SizeKt;
import androidx.compose.p001ui.graphics.ColorKt;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p001ui.input.pointer.PointerId;
import androidx.compose.p001ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p001ui.platform.InspectableValueKt;
import androidx.compose.p001ui.platform.InspectorInfo;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.compose.p001ui.unit.Velocity;
import androidx.compose.p001ui.unit.VelocityKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: AndroidOverscroll.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010#\u001a\u00020\u001fH\u0002J?\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&2\"\u0010'\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020&\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0)\u0012\u0006\u0012\u0004\u0018\u00010*0(H\u0096@ø\u0001\u0000¢\u0006\u0004\b+\u0010,J6\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c02H\u0016ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\u001cH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107J\r\u00108\u001a\u00020\u001fH\u0000¢\u0006\u0002\b9J\u001a\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u001a\u0010?\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010>J\u001a\u0010A\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\bB\u0010>J\u001a\u0010C\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\bD\u0010>J\u001a\u0010E\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\b\u0010H\u001a\u00020\u0011H\u0002J\u001a\u0010I\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\bK\u0010LR\u0016\u0010\u0007\u001a\u00020\bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00118\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006M"}, m195d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "context", "Landroid/content/Context;", "overscrollConfig", "Landroidx/compose/foundation/OverscrollConfiguration;", "(Landroid/content/Context;Landroidx/compose/foundation/OverscrollConfiguration;)V", "containerSize", "Landroidx/compose/ui/geometry/Size;", "J", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "effectModifier", "Landroidx/compose/ui/Modifier;", "getEffectModifier", "()Landroidx/compose/ui/Modifier;", "invalidationEnabled", "", "getInvalidationEnabled$foundation_release$annotations", "()V", "getInvalidationEnabled$foundation_release", "()Z", "setInvalidationEnabled$foundation_release", "(Z)V", "isInProgress", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "redrawSignal", "Landroidx/compose/runtime/MutableState;", "", "getRedrawSignal$foundation_release", "()Landroidx/compose/runtime/MutableState;", "scrollCycleInProgress", "animateToRelease", "applyToFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyToScroll", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "Lkotlin/Function1;", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "displacement", "displacement-F1C5BW0$foundation_release", "()J", "invalidateOverscroll", "invalidateOverscroll$foundation_release", "pullBottom", "", "scroll", "pullBottom-k-4lQ0M", "(J)F", "pullLeft", "pullLeft-k-4lQ0M", "pullRight", "pullRight-k-4lQ0M", "pullTop", "pullTop-k-4lQ0M", "releaseOppositeOverscroll", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "stopOverscrollAnimation", "updateSize", "size", "updateSize-uvyYCjk$foundation_release", "(J)V", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    public static final int $stable = 0;
    private final EdgeEffectWrapper edgeEffectWrapper;
    private final Modifier effectModifier;
    private PointerId pointerId;
    private Offset pointerPosition;
    private boolean scrollCycleInProgress;
    private final MutableState<Unit> redrawSignal = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
    private boolean invalidationEnabled = true;
    private long containerSize = Size.INSTANCE.m4127getZeroNHjbRc();

    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }

    public AndroidEdgeEffectOverscrollEffect(Context context, OverscrollConfiguration overscrollConfig) {
        Modifier drawGlowOverscrollModifier;
        this.edgeEffectWrapper = new EdgeEffectWrapper(context, ColorKt.m4345toArgb8_81llA(overscrollConfig.getGlowColor()));
        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, Unit.INSTANCE, new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this, null));
        if (Build.VERSION.SDK_INT >= 31) {
            drawGlowOverscrollModifier = new DrawStretchOverscrollModifier(this, this.edgeEffectWrapper, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                    invoke2(inspectorInfo);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InspectorInfo $this$null) {
                    $this$null.setName("overscroll");
                    $this$null.setValue(this.this$0);
                }
            } : InspectableValueKt.getNoInspectorInfo());
        } else {
            drawGlowOverscrollModifier = new DrawGlowOverscrollModifier(this, this.edgeEffectWrapper, overscrollConfig, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                    invoke2(inspectorInfo);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InspectorInfo $this$null) {
                    $this$null.setName("overscroll");
                    $this$null.setValue(this.this$0);
                }
            } : InspectableValueKt.getNoInspectorInfo());
        }
        this.effectModifier = modifierPointerInput.then(drawGlowOverscrollModifier);
    }

    public final MutableState<Unit> getRedrawSignal$foundation_release() {
        return this.redrawSignal;
    }

    /* JADX INFO: renamed from: getInvalidationEnabled$foundation_release, reason: from getter */
    public final boolean getInvalidationEnabled() {
        return this.invalidationEnabled;
    }

    public final void setInvalidationEnabled$foundation_release(boolean z) {
        this.invalidationEnabled = z;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: applyToScroll-Rhakbz0, reason: not valid java name */
    public long mo436applyToScrollRhakbz0(long delta, int source, Function1<? super Offset, Offset> performScroll) {
        float consumedPixelsY;
        boolean appliedHorizontalOverscroll;
        boolean appliedVerticalOverscroll;
        if (Size.m4120isEmptyimpl(this.containerSize)) {
            return performScroll.invoke(Offset.m4038boximpl(delta)).getPackedValue();
        }
        if (!this.scrollCycleInProgress) {
            stopOverscrollAnimation();
            this.scrollCycleInProgress = true;
        }
        float consumedPixelsX = 0.0f;
        if (Offset.m4050getYimpl(delta) == 0.0f) {
            consumedPixelsY = 0.0f;
        } else if (this.edgeEffectWrapper.isTopStretched()) {
            consumedPixelsY = m433pullTopk4lQ0M(delta);
            if (!this.edgeEffectWrapper.isTopStretched()) {
                this.edgeEffectWrapper.getOrCreateTopEffect().onRelease();
            }
        } else if (this.edgeEffectWrapper.isBottomStretched()) {
            consumedPixelsY = m430pullBottomk4lQ0M(delta);
            if (!this.edgeEffectWrapper.isBottomStretched()) {
                this.edgeEffectWrapper.getOrCreateBottomEffect().onRelease();
            }
        } else {
            consumedPixelsY = 0.0f;
        }
        if (!(Offset.m4049getXimpl(delta) == 0.0f)) {
            if (this.edgeEffectWrapper.isLeftStretched()) {
                consumedPixelsX = m431pullLeftk4lQ0M(delta);
                if (!this.edgeEffectWrapper.isLeftStretched()) {
                    this.edgeEffectWrapper.getOrCreateLeftEffect().onRelease();
                }
            } else if (this.edgeEffectWrapper.isRightStretched()) {
                consumedPixelsX = m432pullRightk4lQ0M(delta);
                if (!this.edgeEffectWrapper.isRightStretched()) {
                    this.edgeEffectWrapper.getOrCreateRightEffect().onRelease();
                }
            }
        }
        long consumedOffset = OffsetKt.Offset(consumedPixelsX, consumedPixelsY);
        if (!Offset.m4046equalsimpl0(consumedOffset, Offset.INSTANCE.m4065getZeroF1C5BW0())) {
            invalidateOverscroll$foundation_release();
        }
        long leftForDelta = Offset.m4053minusMKHz9U(delta, consumedOffset);
        long consumedByDelta = performScroll.invoke(Offset.m4038boximpl(leftForDelta)).getPackedValue();
        long leftForOverscroll = Offset.m4053minusMKHz9U(leftForDelta, consumedByDelta);
        boolean needsInvalidation = false;
        if (NestedScrollSource.m5398equalsimpl0(source, NestedScrollSource.INSTANCE.m5403getDragWNlRxjI())) {
            if (Offset.m4049getXimpl(leftForOverscroll) > 0.5f) {
                m431pullLeftk4lQ0M(leftForOverscroll);
                appliedHorizontalOverscroll = true;
            } else if (Offset.m4049getXimpl(leftForOverscroll) < -0.5f) {
                m432pullRightk4lQ0M(leftForOverscroll);
                appliedHorizontalOverscroll = true;
            } else {
                appliedHorizontalOverscroll = false;
            }
            if (Offset.m4050getYimpl(leftForOverscroll) > 0.5f) {
                m433pullTopk4lQ0M(leftForOverscroll);
                appliedVerticalOverscroll = true;
            } else if (Offset.m4050getYimpl(leftForOverscroll) < -0.5f) {
                m430pullBottomk4lQ0M(leftForOverscroll);
                appliedVerticalOverscroll = true;
            } else {
                appliedVerticalOverscroll = false;
            }
            needsInvalidation = appliedHorizontalOverscroll || appliedVerticalOverscroll;
        }
        boolean appliedHorizontalOverscroll2 = m434releaseOppositeOverscrollk4lQ0M(delta);
        boolean needsInvalidation2 = appliedHorizontalOverscroll2 || needsInvalidation;
        if (needsInvalidation2) {
            invalidateOverscroll$foundation_release();
        }
        return Offset.m4054plusMKHz9U(consumedOffset, consumedByDelta);
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0141  */
    /* JADX WARN: Code duplicated, block: B:52:0x0155  */
    /* JADX WARN: Code duplicated, block: B:54:0x015d  */
    /* JADX WARN: Code duplicated, block: B:57:0x0179  */
    /* JADX WARN: Code duplicated, block: B:58:0x018d  */
    /* JADX WARN: Code duplicated, block: B:60:0x0195  */
    /* JADX WARN: Code duplicated, block: B:63:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: applyToFling-BMRW4eQ, reason: not valid java name */
    public Object mo435applyToFlingBMRW4eQ(long velocity, Function2<? super Velocity, ? super Continuation<? super Velocity>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        AndroidEdgeEffectOverscrollEffect$applyToFling$1 androidEdgeEffectOverscrollEffect$applyToFling$1;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect;
        float consumedX;
        float consumedY;
        long remainingVelocity;
        Object objInvoke;
        long remainingVelocity2;
        if (continuation instanceof AndroidEdgeEffectOverscrollEffect$applyToFling$1) {
            androidEdgeEffectOverscrollEffect$applyToFling$1 = (AndroidEdgeEffectOverscrollEffect$applyToFling$1) continuation;
            if ((androidEdgeEffectOverscrollEffect$applyToFling$1.label & Integer.MIN_VALUE) != 0) {
                androidEdgeEffectOverscrollEffect$applyToFling$1.label -= Integer.MIN_VALUE;
            } else {
                androidEdgeEffectOverscrollEffect$applyToFling$1 = new AndroidEdgeEffectOverscrollEffect$applyToFling$1(this, continuation);
            }
        } else {
            androidEdgeEffectOverscrollEffect$applyToFling$1 = new AndroidEdgeEffectOverscrollEffect$applyToFling$1(this, continuation);
        }
        AndroidEdgeEffectOverscrollEffect$applyToFling$1 androidEdgeEffectOverscrollEffect$applyToFling$2 = androidEdgeEffectOverscrollEffect$applyToFling$1;
        Object $result = androidEdgeEffectOverscrollEffect$applyToFling$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (androidEdgeEffectOverscrollEffect$applyToFling$2.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                androidEdgeEffectOverscrollEffect = this;
                if (Size.m4120isEmptyimpl(androidEdgeEffectOverscrollEffect.containerSize)) {
                    Velocity velocityM7033boximpl = Velocity.m7033boximpl(velocity);
                    androidEdgeEffectOverscrollEffect$applyToFling$2.label = 1;
                    if (function2.invoke(velocityM7033boximpl, androidEdgeEffectOverscrollEffect$applyToFling$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                if (Velocity.m7042getXimpl(velocity) > 0.0f && androidEdgeEffectOverscrollEffect.edgeEffectWrapper.isLeftStretched()) {
                    EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateLeftEffect(), MathKt.roundToInt(Velocity.m7042getXimpl(velocity)));
                    consumedX = Velocity.m7042getXimpl(velocity);
                } else if (Velocity.m7042getXimpl(velocity) < 0.0f && androidEdgeEffectOverscrollEffect.edgeEffectWrapper.isRightStretched()) {
                    EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateRightEffect(), -MathKt.roundToInt(Velocity.m7042getXimpl(velocity)));
                    consumedX = Velocity.m7042getXimpl(velocity);
                } else {
                    consumedX = 0.0f;
                }
                if (Velocity.m7043getYimpl(velocity) > 0.0f && androidEdgeEffectOverscrollEffect.edgeEffectWrapper.isTopStretched()) {
                    EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateTopEffect(), MathKt.roundToInt(Velocity.m7043getYimpl(velocity)));
                    consumedY = Velocity.m7043getYimpl(velocity);
                } else if (Velocity.m7043getYimpl(velocity) < 0.0f && androidEdgeEffectOverscrollEffect.edgeEffectWrapper.isBottomStretched()) {
                    EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateBottomEffect(), -MathKt.roundToInt(Velocity.m7043getYimpl(velocity)));
                    consumedY = Velocity.m7043getYimpl(velocity);
                } else {
                    consumedY = 0.0f;
                }
                long consumed = VelocityKt.Velocity(consumedX, consumedY);
                if (!Velocity.m7041equalsimpl0(consumed, Velocity.INSTANCE.m7053getZero9UxMQ8M())) {
                    androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation_release();
                }
                remainingVelocity = Velocity.m7045minusAH228Gc(velocity, consumed);
                Velocity velocityM7033boximpl2 = Velocity.m7033boximpl(remainingVelocity);
                androidEdgeEffectOverscrollEffect$applyToFling$2.L$0 = androidEdgeEffectOverscrollEffect;
                androidEdgeEffectOverscrollEffect$applyToFling$2.J$0 = remainingVelocity;
                androidEdgeEffectOverscrollEffect$applyToFling$2.label = 2;
                objInvoke = function2.invoke(velocityM7033boximpl2, androidEdgeEffectOverscrollEffect$applyToFling$2);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                long consumedByVelocity = ((Velocity) objInvoke).getPackedValue();
                remainingVelocity2 = Velocity.m7045minusAH228Gc(remainingVelocity, consumedByVelocity);
                androidEdgeEffectOverscrollEffect.scrollCycleInProgress = false;
                if (Velocity.m7042getXimpl(remainingVelocity2) > 0.0f) {
                    EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateLeftEffect(), MathKt.roundToInt(Velocity.m7042getXimpl(remainingVelocity2)));
                } else if (Velocity.m7042getXimpl(remainingVelocity2) < 0.0f) {
                    EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateRightEffect(), -MathKt.roundToInt(Velocity.m7042getXimpl(remainingVelocity2)));
                }
                if (Velocity.m7043getYimpl(remainingVelocity2) > 0.0f) {
                    EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateTopEffect(), MathKt.roundToInt(Velocity.m7043getYimpl(remainingVelocity2)));
                } else if (Velocity.m7043getYimpl(remainingVelocity2) < 0.0f) {
                    EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateBottomEffect(), -MathKt.roundToInt(Velocity.m7043getYimpl(remainingVelocity2)));
                }
                if (!Velocity.m7041equalsimpl0(remainingVelocity2, Velocity.INSTANCE.m7053getZero9UxMQ8M())) {
                    androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation_release();
                }
                androidEdgeEffectOverscrollEffect.animateToRelease();
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 2:
                remainingVelocity = androidEdgeEffectOverscrollEffect$applyToFling$2.J$0;
                AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect2 = (AndroidEdgeEffectOverscrollEffect) androidEdgeEffectOverscrollEffect$applyToFling$2.L$0;
                ResultKt.throwOnFailure($result);
                androidEdgeEffectOverscrollEffect = androidEdgeEffectOverscrollEffect2;
                objInvoke = $result;
                long consumedByVelocity2 = ((Velocity) objInvoke).getPackedValue();
                remainingVelocity2 = Velocity.m7045minusAH228Gc(remainingVelocity, consumedByVelocity2);
                androidEdgeEffectOverscrollEffect.scrollCycleInProgress = false;
                if (Velocity.m7042getXimpl(remainingVelocity2) > 0.0f) {
                    EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateLeftEffect(), MathKt.roundToInt(Velocity.m7042getXimpl(remainingVelocity2)));
                } else if (Velocity.m7042getXimpl(remainingVelocity2) < 0.0f) {
                    EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateRightEffect(), -MathKt.roundToInt(Velocity.m7042getXimpl(remainingVelocity2)));
                }
                if (Velocity.m7043getYimpl(remainingVelocity2) > 0.0f) {
                    EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateTopEffect(), MathKt.roundToInt(Velocity.m7043getYimpl(remainingVelocity2)));
                } else if (Velocity.m7043getYimpl(remainingVelocity2) < 0.0f) {
                    EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateBottomEffect(), -MathKt.roundToInt(Velocity.m7043getYimpl(remainingVelocity2)));
                }
                if (!Velocity.m7041equalsimpl0(remainingVelocity2, Velocity.INSTANCE.m7053getZero9UxMQ8M())) {
                    androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation_release();
                }
                androidEdgeEffectOverscrollEffect.animateToRelease();
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        EdgeEffectWrapper this_$iv = this.edgeEffectWrapper;
        EdgeEffect it = this_$iv.topEffect;
        if (it != null) {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(it) == 0.0f)) {
                return true;
            }
        }
        EdgeEffect it2 = this_$iv.bottomEffect;
        if (it2 != null) {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(it2) == 0.0f)) {
                return true;
            }
        }
        EdgeEffect it3 = this_$iv.leftEffect;
        if (it3 != null) {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(it3) == 0.0f)) {
                return true;
            }
        }
        EdgeEffect it4 = this_$iv.rightEffect;
        if (it4 != null) {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(it4) == 0.0f)) {
                return true;
            }
        }
        return false;
    }

    private final boolean stopOverscrollAnimation() {
        boolean stopped = false;
        if (this.edgeEffectWrapper.isLeftStretched()) {
            m431pullLeftk4lQ0M(Offset.INSTANCE.m4065getZeroF1C5BW0());
            stopped = true;
        }
        if (this.edgeEffectWrapper.isRightStretched()) {
            m432pullRightk4lQ0M(Offset.INSTANCE.m4065getZeroF1C5BW0());
            stopped = true;
        }
        if (this.edgeEffectWrapper.isTopStretched()) {
            m433pullTopk4lQ0M(Offset.INSTANCE.m4065getZeroF1C5BW0());
            stopped = true;
        }
        if (this.edgeEffectWrapper.isBottomStretched()) {
            m430pullBottomk4lQ0M(Offset.INSTANCE.m4065getZeroF1C5BW0());
            return true;
        }
        return stopped;
    }

    /* JADX INFO: renamed from: updateSize-uvyYCjk$foundation_release, reason: not valid java name */
    public final void m438updateSizeuvyYCjk$foundation_release(long size) {
        boolean initialSetSize = Size.m4114equalsimpl0(this.containerSize, Size.INSTANCE.m4127getZeroNHjbRc());
        boolean differentSize = !Size.m4114equalsimpl0(size, this.containerSize);
        this.containerSize = size;
        if (differentSize) {
            this.edgeEffectWrapper.m509setSizeozmzZPI(IntSizeKt.IntSize(MathKt.roundToInt(Size.m4118getWidthimpl(size)), MathKt.roundToInt(Size.m4115getHeightimpl(size))));
        }
        if (!initialSetSize && differentSize) {
            invalidateOverscroll$foundation_release();
            animateToRelease();
        }
    }

    /* JADX INFO: renamed from: displacement-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m437displacementF1C5BW0$foundation_release() {
        Offset offset = this.pointerPosition;
        long pointer = offset != null ? offset.getPackedValue() : SizeKt.m4128getCenteruvyYCjk(this.containerSize);
        float x = Offset.m4049getXimpl(pointer) / Size.m4118getWidthimpl(this.containerSize);
        float y = Offset.m4050getYimpl(pointer) / Size.m4115getHeightimpl(this.containerSize);
        return OffsetKt.Offset(x, y);
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    public final void invalidateOverscroll$foundation_release() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    private final void animateToRelease() {
        boolean needsInvalidation = false;
        EdgeEffectWrapper this_$iv = this.edgeEffectWrapper;
        EdgeEffect it = this_$iv.topEffect;
        if (it != null) {
            it.onRelease();
            needsInvalidation = it.isFinished();
        }
        EdgeEffect it2 = this_$iv.bottomEffect;
        if (it2 != null) {
            it2.onRelease();
            needsInvalidation = it2.isFinished() || needsInvalidation;
        }
        EdgeEffect it3 = this_$iv.leftEffect;
        if (it3 != null) {
            it3.onRelease();
            needsInvalidation = it3.isFinished() || needsInvalidation;
        }
        EdgeEffect it4 = this_$iv.rightEffect;
        if (it4 != null) {
            it4.onRelease();
            needsInvalidation = it4.isFinished() || needsInvalidation;
        }
        if (needsInvalidation) {
            invalidateOverscroll$foundation_release();
        }
    }

    /* JADX INFO: renamed from: releaseOppositeOverscroll-k-4lQ0M, reason: not valid java name */
    private final boolean m434releaseOppositeOverscrollk4lQ0M(long delta) {
        boolean needsInvalidation = false;
        boolean needsInvalidation2 = true;
        if (this.edgeEffectWrapper.isLeftAnimating() && Offset.m4049getXimpl(delta) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateLeftEffect(), Offset.m4049getXimpl(delta));
            needsInvalidation = !this.edgeEffectWrapper.isLeftAnimating();
        }
        if (this.edgeEffectWrapper.isRightAnimating() && Offset.m4049getXimpl(delta) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateRightEffect(), Offset.m4049getXimpl(delta));
            needsInvalidation = needsInvalidation || !this.edgeEffectWrapper.isRightAnimating();
        }
        if (this.edgeEffectWrapper.isTopAnimating() && Offset.m4050getYimpl(delta) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateTopEffect(), Offset.m4050getYimpl(delta));
            needsInvalidation = needsInvalidation || !this.edgeEffectWrapper.isTopAnimating();
        }
        if (this.edgeEffectWrapper.isBottomAnimating() && Offset.m4050getYimpl(delta) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateBottomEffect(), Offset.m4050getYimpl(delta));
            if (!needsInvalidation && this.edgeEffectWrapper.isBottomAnimating()) {
                needsInvalidation2 = false;
            }
            return needsInvalidation2;
        }
        return needsInvalidation;
    }

    /* JADX INFO: renamed from: pullTop-k-4lQ0M, reason: not valid java name */
    private final float m433pullTopk4lQ0M(long scroll) {
        float displacementX = Offset.m4049getXimpl(m437displacementF1C5BW0$foundation_release());
        float pullY = Offset.m4050getYimpl(scroll) / Size.m4115getHeightimpl(this.containerSize);
        EdgeEffect topEffect = this.edgeEffectWrapper.getOrCreateTopEffect();
        float consumed = EdgeEffectCompat.INSTANCE.onPullDistanceCompat(topEffect, pullY, displacementX) * Size.m4115getHeightimpl(this.containerSize);
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(topEffect) == 0.0f)) {
            return Offset.m4050getYimpl(scroll);
        }
        return consumed;
    }

    /* JADX INFO: renamed from: pullBottom-k-4lQ0M, reason: not valid java name */
    private final float m430pullBottomk4lQ0M(long scroll) {
        float displacementX = Offset.m4049getXimpl(m437displacementF1C5BW0$foundation_release());
        float pullY = Offset.m4050getYimpl(scroll) / Size.m4115getHeightimpl(this.containerSize);
        EdgeEffect bottomEffect = this.edgeEffectWrapper.getOrCreateBottomEffect();
        float consumed = (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(bottomEffect, -pullY, 1 - displacementX)) * Size.m4115getHeightimpl(this.containerSize);
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(bottomEffect) == 0.0f)) {
            return Offset.m4050getYimpl(scroll);
        }
        return consumed;
    }

    /* JADX INFO: renamed from: pullLeft-k-4lQ0M, reason: not valid java name */
    private final float m431pullLeftk4lQ0M(long scroll) {
        float displacementY = Offset.m4050getYimpl(m437displacementF1C5BW0$foundation_release());
        float pullX = Offset.m4049getXimpl(scroll) / Size.m4118getWidthimpl(this.containerSize);
        EdgeEffect leftEffect = this.edgeEffectWrapper.getOrCreateLeftEffect();
        float consumed = EdgeEffectCompat.INSTANCE.onPullDistanceCompat(leftEffect, pullX, 1 - displacementY) * Size.m4118getWidthimpl(this.containerSize);
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(leftEffect) == 0.0f)) {
            return Offset.m4049getXimpl(scroll);
        }
        return consumed;
    }

    /* JADX INFO: renamed from: pullRight-k-4lQ0M, reason: not valid java name */
    private final float m432pullRightk4lQ0M(long scroll) {
        float displacementY = Offset.m4050getYimpl(m437displacementF1C5BW0$foundation_release());
        float pullX = Offset.m4049getXimpl(scroll) / Size.m4118getWidthimpl(this.containerSize);
        EdgeEffect rightEffect = this.edgeEffectWrapper.getOrCreateRightEffect();
        float consumed = (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(rightEffect, -pullX, displacementY)) * Size.m4118getWidthimpl(this.containerSize);
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(rightEffect) == 0.0f)) {
            return Offset.m4049getXimpl(scroll);
        }
        return consumed;
    }
}
