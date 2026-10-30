package androidx.compose.foundation.gestures.snapping;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.p001ui.MotionDurationScale;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: compiled from: SnapFlingBehavior.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J:\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u001d*\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u00062\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"0!H\u0082@¢\u0006\u0002\u0010#J\f\u0010$\u001a\u00020\u0011*\u00020\u0006H\u0002J.\u0010%\u001a\u00020\u0006*\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u00062\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"0!H\u0096@¢\u0006\u0002\u0010#JQ\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u001d*\u00020\u001f2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062!\u0010)\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\"0!H\u0082@¢\u0006\u0002\u0010-JB\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0/*\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"0!H\u0082@¢\u0006\u0002\u0010-R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, m195d2 = {"Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "snapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "motionScaleDuration", "Landroidx/compose/ui/MotionDurationScale;", "getMotionScaleDuration$foundation_release", "()Landroidx/compose/ui/MotionDurationScale;", "setMotionScaleDuration$foundation_release", "(Landroidx/compose/ui/MotionDurationScale;)V", "equals", "", "other", "", "hashCode", "", "isDecayApproachPossible", "offset", "velocity", "resolveFinalApproachOffset", "initialOffset", "initialVelocity", "fling", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/foundation/gestures/ScrollScope;", "onRemainingScrollOffsetUpdate", "Lkotlin/Function1;", "", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isValidBound", "performFling", "onRemainingDistanceUpdated", "runApproach", "initialTargetOffset", "onAnimationStep", "Lkotlin/ParameterName;", "name", "delta", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryApproach", "Landroidx/compose/animation/core/AnimationState;", "updateRemainingScrollOffset", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SnapFlingBehavior implements TargetedFlingBehavior {
    public static final int $stable = 0;
    private final DecayAnimationSpec<Float> decayAnimationSpec;
    private MotionDurationScale motionScaleDuration = ScrollableKt.getDefaultScrollMotionDurationScale();
    private final AnimationSpec<Float> snapAnimationSpec;
    private final SnapLayoutInfoProvider snapLayoutInfoProvider;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1 */
    /* JADX INFO: compiled from: SnapFlingBehavior.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior", m210f = "SnapFlingBehavior.kt", m211i = {0}, m212l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY}, m213m = "fling", m214n = {"onRemainingScrollOffsetUpdate"}, m215s = {"L$0"})
    static final class C04341 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04341(Continuation<? super C04341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.fling(null, 0.0f, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1 */
    /* JADX INFO: compiled from: SnapFlingBehavior.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior", m210f = "SnapFlingBehavior.kt", m211i = {}, m212l = {93}, m213m = "performFling", m214n = {}, m215s = {})
    static final class C04361 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C04361(Continuation<? super C04361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.performFling(null, 0.0f, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$tryApproach$1 */
    /* JADX INFO: compiled from: SnapFlingBehavior.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior", m210f = "SnapFlingBehavior.kt", m211i = {}, m212l = {203}, m213m = "tryApproach", m214n = {}, m215s = {})
    static final class C04371 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C04371(Continuation<? super C04371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.tryApproach(null, 0.0f, 0.0f, null, this);
        }
    }

    @Override // androidx.compose.foundation.gestures.TargetedFlingBehavior, androidx.compose.foundation.gestures.FlingBehavior
    public /* synthetic */ Object performFling(ScrollScope scrollScope, float f, Continuation continuation) {
        return TargetedFlingBehavior.CC.performFling$suspendImpl(this, scrollScope, f, continuation);
    }

    public SnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec) {
        this.snapLayoutInfoProvider = snapLayoutInfoProvider;
        this.decayAnimationSpec = decayAnimationSpec;
        this.snapAnimationSpec = animationSpec;
    }

    /* JADX INFO: renamed from: getMotionScaleDuration$foundation_release, reason: from getter */
    public final MotionDurationScale getMotionScaleDuration() {
        return this.motionScaleDuration;
    }

    public final void setMotionScaleDuration$foundation_release(MotionDurationScale motionDurationScale) {
        this.motionScaleDuration = motionDurationScale;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.foundation.gestures.TargetedFlingBehavior
    public Object performFling(ScrollScope $this$performFling, float initialVelocity, Function1<? super Float, Unit> function1, Continuation<? super Float> continuation) throws Throwable {
        C04361 c04361;
        Object objFling;
        if (continuation instanceof C04361) {
            c04361 = (C04361) continuation;
            if ((c04361.label & Integer.MIN_VALUE) != 0) {
                c04361.label -= Integer.MIN_VALUE;
            } else {
                c04361 = new C04361(continuation);
            }
        } else {
            c04361 = new C04361(continuation);
        }
        C04361 c04362 = c04361;
        Object $result = c04362.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c04362.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c04362.label = 1;
                objFling = fling($this$performFling, initialVelocity, function1, c04362);
                if (objFling == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objFling = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AnimationResult animationResult = (AnimationResult) objFling;
        float remainingOffset = ((Number) animationResult.component1()).floatValue();
        AnimationState remainingState = animationResult.component2();
        return Boxing.boxFloat(remainingOffset == 0.0f ? 0.0f : ((Number) remainingState.getVelocity()).floatValue());
    }

    private final boolean isValidBound(float $this$isValidBound) {
        if (!($this$isValidBound == Float.NEGATIVE_INFINITY)) {
            if (!($this$isValidBound == Float.POSITIVE_INFINITY)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fling(ScrollScope $this$fling, float initialVelocity, Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) throws Throwable {
        C04341 c04341;
        Function1<? super Float, Unit> function2;
        Object objWithContext;
        if (continuation instanceof C04341) {
            c04341 = (C04341) continuation;
            if ((c04341.label & Integer.MIN_VALUE) != 0) {
                c04341.label -= Integer.MIN_VALUE;
            } else {
                c04341 = new C04341(continuation);
            }
        } else {
            c04341 = new C04341(continuation);
        }
        C04341 c04342 = c04341;
        Object $result = c04342.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c04342.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                function2 = function1;
                MotionDurationScale motionDurationScale = this.motionScaleDuration;
                SnapFlingBehavior$fling$result$1 snapFlingBehavior$fling$result$1 = new SnapFlingBehavior$fling$result$1(this, initialVelocity, function2, $this$fling, null);
                c04342.L$0 = function2;
                c04342.label = 1;
                objWithContext = BuildersKt.withContext(motionDurationScale, snapFlingBehavior$fling$result$1, c04342);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                function2 = (Function1) c04342.L$0;
                ResultKt.throwOnFailure($result);
                objWithContext = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AnimationResult result = (AnimationResult) objWithContext;
        function2.invoke(Boxing.boxFloat(0.0f));
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float resolveFinalApproachOffset(float initialOffset, float initialVelocity) {
        float boundsDistance;
        if (Float.isNaN(initialOffset)) {
            float nextBound = this.snapLayoutInfoProvider.calculateSnappingOffset(Float.POSITIVE_INFINITY);
            float previousBound = this.snapLayoutInfoProvider.calculateSnappingOffset(Float.NEGATIVE_INFINITY);
            if (isValidBound(nextBound) && isValidBound(previousBound)) {
                boundsDistance = nextBound - previousBound;
            } else if (isValidBound(nextBound)) {
                boundsDistance = nextBound;
            } else if (isValidBound(previousBound)) {
                boundsDistance = previousBound;
            } else {
                boundsDistance = 0.0f;
            }
            float decayOffset = DecayAnimationSpecKt.calculateTargetValue(this.decayAnimationSpec, 0.0f, initialVelocity);
            float resultingOffset = RangesKt.coerceAtLeast(Math.abs(decayOffset) - boundsDistance, 0.0f);
            if (resultingOffset == 0.0f) {
                return resultingOffset;
            }
            return resultingOffset * Math.signum(initialVelocity);
        }
        return Math.abs(initialOffset) * Math.signum(initialVelocity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object tryApproach(ScrollScope scrollScope, float offset, float velocity, Function1<? super Float, Unit> function1, Continuation<? super AnimationState<Float, AnimationVector1D>> continuation) {
        C04371 c04371;
        Object objRunApproach;
        if (continuation instanceof C04371) {
            C04371 c04372 = (C04371) continuation;
            if ((c04372.label & Integer.MIN_VALUE) != 0) {
                c04372.label -= Integer.MIN_VALUE;
                c04371 = c04372;
            } else {
                c04371 = new C04371(continuation);
            }
        } else {
            c04371 = new C04371(continuation);
        }
        Object $result = c04371.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c04371.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!(Math.abs(offset) == 0.0f)) {
                    if (!(Math.abs(velocity) == 0.0f)) {
                        c04371.label = 1;
                        objRunApproach = runApproach(scrollScope, offset, velocity, function1, c04371);
                        if (objRunApproach == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                return AnimationStateKt.AnimationState$default(offset, velocity, 0L, 0L, false, 28, null);
            case 1:
                ResultKt.throwOnFailure($result);
                objRunApproach = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return ((AnimationResult) objRunApproach).getCurrentAnimationState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object runApproach(ScrollScope $this$runApproach, float initialTargetOffset, float initialVelocity, Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        ApproachAnimation animation;
        if (isDecayApproachPossible(initialTargetOffset, initialVelocity)) {
            animation = new DecayApproachAnimation(this.decayAnimationSpec);
        } else {
            animation = new TargetApproachAnimation(this.snapAnimationSpec);
        }
        return SnapFlingBehaviorKt.approach($this$runApproach, initialTargetOffset, initialVelocity, animation, function1, continuation);
    }

    private final boolean isDecayApproachPossible(float offset, float velocity) {
        float decayOffset = DecayAnimationSpecKt.calculateTargetValue(this.decayAnimationSpec, 0.0f, velocity);
        return Math.abs(decayOffset) >= Math.abs(offset);
    }

    public boolean equals(Object other) {
        return (other instanceof SnapFlingBehavior) && Intrinsics.areEqual(((SnapFlingBehavior) other).snapAnimationSpec, this.snapAnimationSpec) && Intrinsics.areEqual(((SnapFlingBehavior) other).decayAnimationSpec, this.decayAnimationSpec) && Intrinsics.areEqual(((SnapFlingBehavior) other).snapLayoutInfoProvider, this.snapLayoutInfoProvider);
    }

    public int hashCode() {
        int it = (0 * 31) + this.snapAnimationSpec.hashCode();
        return (((it * 31) + this.decayAnimationSpec.hashCode()) * 31) + this.snapLayoutInfoProvider.hashCode();
    }
}
