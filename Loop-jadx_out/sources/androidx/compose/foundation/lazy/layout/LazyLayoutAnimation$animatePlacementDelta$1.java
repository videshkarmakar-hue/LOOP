package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyLayoutAnimation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animatePlacementDelta$1", m210f = "LazyLayoutAnimation.kt", m211i = {0}, m212l = {146, 153}, m213m = "invokeSuspend", m214n = {"finalSpec"}, m215s = {"L$0"})
final class LazyLayoutAnimation$animatePlacementDelta$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FiniteAnimationSpec<IntOffset> $spec;
    final /* synthetic */ long $totalDelta;
    Object L$0;
    int label;
    final /* synthetic */ LazyLayoutAnimation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyLayoutAnimation$animatePlacementDelta$1(LazyLayoutAnimation lazyLayoutAnimation, FiniteAnimationSpec<IntOffset> finiteAnimationSpec, long j, Continuation<? super LazyLayoutAnimation$animatePlacementDelta$1> continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutAnimation;
        this.$spec = finiteAnimationSpec;
        this.$totalDelta = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutAnimation$animatePlacementDelta$1(this.this$0, this.$spec, this.$totalDelta, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyLayoutAnimation$animatePlacementDelta$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00e8 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        LazyLayoutAnimation$animatePlacementDelta$1 lazyLayoutAnimation$animatePlacementDelta$1;
        SpringSpec springSpec;
        final long animationTarget;
        Animatable animatable;
        Function1<Animatable<IntOffset, AnimationVector2D>, Unit> function1;
        LazyLayoutAnimation$animatePlacementDelta$1 lazyLayoutAnimation$animatePlacementDelta$2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    lazyLayoutAnimation$animatePlacementDelta$1 = this;
                    if (lazyLayoutAnimation$animatePlacementDelta$1.this$0.placementDeltaAnimation.isRunning()) {
                        springSpec = lazyLayoutAnimation$animatePlacementDelta$1.$spec instanceof SpringSpec ? (SpringSpec) lazyLayoutAnimation$animatePlacementDelta$1.$spec : LazyLayoutAnimationKt.InterruptionSpec;
                    } else {
                        springSpec = lazyLayoutAnimation$animatePlacementDelta$1.$spec;
                    }
                    if (!lazyLayoutAnimation$animatePlacementDelta$1.this$0.placementDeltaAnimation.isRunning()) {
                        lazyLayoutAnimation$animatePlacementDelta$1.L$0 = springSpec;
                        lazyLayoutAnimation$animatePlacementDelta$1.label = 1;
                        if (lazyLayoutAnimation$animatePlacementDelta$1.this$0.placementDeltaAnimation.snapTo(IntOffset.m6924boximpl(lazyLayoutAnimation$animatePlacementDelta$1.$totalDelta), lazyLayoutAnimation$animatePlacementDelta$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        lazyLayoutAnimation$animatePlacementDelta$1.this$0.onLayerPropertyChanged.invoke();
                    }
                    long arg0$iv = ((IntOffset) lazyLayoutAnimation$animatePlacementDelta$1.this$0.placementDeltaAnimation.getValue()).getPackedValue();
                    long other$iv = lazyLayoutAnimation$animatePlacementDelta$1.$totalDelta;
                    int i = ((int) (arg0$iv >> 32)) - ((int) (other$iv >> 32));
                    int i2 = (int) (arg0$iv & 4294967295L);
                    int $i$f$unpackInt2 = (int) (other$iv & 4294967295L);
                    animationTarget = IntOffsetKt.IntOffset(i, i2 - $i$f$unpackInt2);
                    animatable = lazyLayoutAnimation$animatePlacementDelta$1.this$0.placementDeltaAnimation;
                    final LazyLayoutAnimation lazyLayoutAnimation = lazyLayoutAnimation$animatePlacementDelta$1.this$0;
                    function1 = new Function1<Animatable<IntOffset, AnimationVector2D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animatePlacementDelta$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Animatable<IntOffset, AnimationVector2D> animatable2) {
                            invoke2(animatable2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Animatable<IntOffset, AnimationVector2D> animatable2) {
                            LazyLayoutAnimation lazyLayoutAnimation2 = lazyLayoutAnimation;
                            long arg0$iv2 = animatable2.getValue().getPackedValue();
                            long other$iv2 = animationTarget;
                            lazyLayoutAnimation2.m1012setPlacementDeltagyyYBs(IntOffsetKt.IntOffset(((int) (arg0$iv2 >> 32)) - ((int) (other$iv2 >> 32)), ((int) (arg0$iv2 & 4294967295L)) - ((int) (4294967295L & other$iv2))));
                            lazyLayoutAnimation.onLayerPropertyChanged.invoke();
                        }
                    };
                    lazyLayoutAnimation$animatePlacementDelta$2 = lazyLayoutAnimation$animatePlacementDelta$1;
                    lazyLayoutAnimation$animatePlacementDelta$1.L$0 = null;
                    lazyLayoutAnimation$animatePlacementDelta$1.label = 2;
                    if (animatable.animateTo(IntOffset.m6924boximpl(animationTarget), (4 & 2) != 0 ? animatable.defaultSpringSpec : springSpec, (4 & 4) != 0 ? animatable.getVelocity() : null, (4 & 8) != 0 ? null : function1, lazyLayoutAnimation$animatePlacementDelta$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    lazyLayoutAnimation$animatePlacementDelta$1.this$0.setPlacementAnimationInProgress(false);
                    return Unit.INSTANCE;
                case 1:
                    lazyLayoutAnimation$animatePlacementDelta$1 = this;
                    springSpec = (FiniteAnimationSpec) lazyLayoutAnimation$animatePlacementDelta$1.L$0;
                    ResultKt.throwOnFailure($result);
                    lazyLayoutAnimation$animatePlacementDelta$1.this$0.onLayerPropertyChanged.invoke();
                    long arg0$iv2 = ((IntOffset) lazyLayoutAnimation$animatePlacementDelta$1.this$0.placementDeltaAnimation.getValue()).getPackedValue();
                    long other$iv2 = lazyLayoutAnimation$animatePlacementDelta$1.$totalDelta;
                    int i3 = ((int) (arg0$iv2 >> 32)) - ((int) (other$iv2 >> 32));
                    int i4 = (int) (arg0$iv2 & 4294967295L);
                    int $i$f$unpackInt3 = (int) (other$iv2 & 4294967295L);
                    animationTarget = IntOffsetKt.IntOffset(i3, i4 - $i$f$unpackInt3);
                    animatable = lazyLayoutAnimation$animatePlacementDelta$1.this$0.placementDeltaAnimation;
                    final LazyLayoutAnimation lazyLayoutAnimation2 = lazyLayoutAnimation$animatePlacementDelta$1.this$0;
                    function1 = new Function1<Animatable<IntOffset, AnimationVector2D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animatePlacementDelta$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Animatable<IntOffset, AnimationVector2D> animatable2) {
                            invoke2(animatable2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Animatable<IntOffset, AnimationVector2D> animatable2) {
                            LazyLayoutAnimation lazyLayoutAnimation3 = lazyLayoutAnimation2;
                            long arg0$iv3 = animatable2.getValue().getPackedValue();
                            long other$iv3 = animationTarget;
                            lazyLayoutAnimation3.m1012setPlacementDeltagyyYBs(IntOffsetKt.IntOffset(((int) (arg0$iv3 >> 32)) - ((int) (other$iv3 >> 32)), ((int) (arg0$iv3 & 4294967295L)) - ((int) (4294967295L & other$iv3))));
                            lazyLayoutAnimation2.onLayerPropertyChanged.invoke();
                        }
                    };
                    lazyLayoutAnimation$animatePlacementDelta$2 = lazyLayoutAnimation$animatePlacementDelta$1;
                    lazyLayoutAnimation$animatePlacementDelta$1.L$0 = null;
                    lazyLayoutAnimation$animatePlacementDelta$1.label = 2;
                    if (animatable.animateTo(IntOffset.m6924boximpl(animationTarget), (4 & 2) != 0 ? animatable.defaultSpringSpec : springSpec, (4 & 4) != 0 ? animatable.getVelocity() : null, (4 & 8) != 0 ? null : function1, lazyLayoutAnimation$animatePlacementDelta$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    lazyLayoutAnimation$animatePlacementDelta$1.this$0.setPlacementAnimationInProgress(false);
                    return Unit.INSTANCE;
                case 2:
                    lazyLayoutAnimation$animatePlacementDelta$1 = this;
                    ResultKt.throwOnFailure($result);
                    lazyLayoutAnimation$animatePlacementDelta$1.this$0.setPlacementAnimationInProgress(false);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (CancellationException e) {
        }
    }
}
