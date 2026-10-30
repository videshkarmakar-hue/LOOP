package androidx.compose.material.ripple;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.ClipOp;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.drawscope.DrawContext;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawTransform;
import androidx.compose.p001ui.util.MathHelpersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: RippleAnimation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010 \u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010!J\u000e\u0010#\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010!J\u0006\u0010$\u001a\u00020\u0018J\u001c\u0010%\u001a\u00020\u0018*\u00020&2\u0006\u0010'\u001a\u00020(ø\u0001\u0000¢\u0006\u0004\b)\u0010*R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, m195d2 = {"Landroidx/compose/material/ripple/RippleAnimation;", "", "origin", "Landroidx/compose/ui/geometry/Offset;", "radius", "", "bounded", "", "(Landroidx/compose/ui/geometry/Offset;FZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "animatedCenterPercent", "animatedRadiusPercent", "<set-?>", "finishRequested", "getFinishRequested", "()Z", "setFinishRequested", "(Z)V", "finishRequested$delegate", "Landroidx/compose/runtime/MutableState;", "finishSignalDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "finishedFadingIn", "getFinishedFadingIn", "setFinishedFadingIn", "finishedFadingIn$delegate", "startRadius", "Ljava/lang/Float;", "targetCenter", "animate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fadeIn", "fadeOut", "finish", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "color", "Landroidx/compose/ui/graphics/Color;", "draw-4WTKRHQ", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;J)V", "material-ripple_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class RippleAnimation {
    public static final int $stable = 8;
    private final Animatable<Float, AnimationVector1D> animatedAlpha;
    private final Animatable<Float, AnimationVector1D> animatedCenterPercent;
    private final Animatable<Float, AnimationVector1D> animatedRadiusPercent;
    private final boolean bounded;

    /* JADX INFO: renamed from: finishRequested$delegate, reason: from kotlin metadata */
    private final MutableState finishRequested;
    private final CompletableDeferred<Unit> finishSignalDeferred;

    /* JADX INFO: renamed from: finishedFadingIn$delegate, reason: from kotlin metadata */
    private final MutableState finishedFadingIn;
    private Offset origin;
    private final float radius;
    private Float startRadius;
    private Offset targetCenter;

    /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$animate$1 */
    /* JADX INFO: compiled from: RippleAnimation.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.material.ripple.RippleAnimation", m210f = "RippleAnimation.kt", m211i = {0, 1}, m212l = {77, 79, 80}, m213m = "animate", m214n = {"this", "this"}, m215s = {"L$0", "L$0"})
    static final class C11871 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C11871(Continuation<? super C11871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RippleAnimation.this.animate(this);
        }
    }

    public /* synthetic */ RippleAnimation(Offset offset, float f, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(offset, f, z);
    }

    private RippleAnimation(Offset origin, float radius, boolean bounded) {
        this.origin = origin;
        this.radius = radius;
        this.bounded = bounded;
        this.animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.animatedRadiusPercent = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.animatedCenterPercent = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.finishSignalDeferred = CompletableDeferredKt.CompletableDeferred((Job) null);
        this.finishedFadingIn = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.finishRequested = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    }

    private final boolean getFinishedFadingIn() {
        State $this$getValue$iv = this.finishedFadingIn;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private final void setFinishedFadingIn(boolean z) {
        MutableState $this$setValue$iv = this.finishedFadingIn;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    private final boolean getFinishRequested() {
        State $this$getValue$iv = this.finishRequested;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private final void setFinishRequested(boolean z) {
        MutableState $this$setValue$iv = this.finishRequested;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0062 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x006f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object animate(Continuation<? super Unit> continuation) {
        C11871 c11871;
        RippleAnimation rippleAnimation;
        CompletableDeferred<Unit> completableDeferred;
        if (continuation instanceof C11871) {
            c11871 = (C11871) continuation;
            if ((c11871.label & Integer.MIN_VALUE) != 0) {
                c11871.label -= Integer.MIN_VALUE;
            } else {
                c11871 = new C11871(continuation);
            }
        } else {
            c11871 = new C11871(continuation);
        }
        C11871 c11872 = c11871;
        Object $result = c11872.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c11872.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                rippleAnimation = this;
                c11872.L$0 = rippleAnimation;
                c11872.label = 1;
                if (rippleAnimation.fadeIn(c11872) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                rippleAnimation.setFinishedFadingIn(true);
                completableDeferred = rippleAnimation.finishSignalDeferred;
                c11872.L$0 = rippleAnimation;
                c11872.label = 2;
                if (completableDeferred.await(c11872) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                c11872.L$0 = null;
                c11872.label = 3;
                if (rippleAnimation.fadeOut(c11872) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                rippleAnimation = (RippleAnimation) c11872.L$0;
                ResultKt.throwOnFailure($result);
                rippleAnimation.setFinishedFadingIn(true);
                completableDeferred = rippleAnimation.finishSignalDeferred;
                c11872.L$0 = rippleAnimation;
                c11872.label = 2;
                if (completableDeferred.await(c11872) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                c11872.L$0 = null;
                c11872.label = 3;
                if (rippleAnimation.fadeOut(c11872) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 2:
                rippleAnimation = (RippleAnimation) c11872.L$0;
                ResultKt.throwOnFailure($result);
                c11872.L$0 = null;
                c11872.label = 3;
                if (rippleAnimation.fadeOut(c11872) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$fadeIn$2 */
    /* JADX INFO: compiled from: RippleAnimation.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.material.ripple.RippleAnimation$fadeIn$2", m210f = "RippleAnimation.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C11882 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C11882(Continuation<? super C11882> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11882 c11882 = RippleAnimation.this.new C11882(continuation);
            c11882.L$0 = obj;
            return c11882;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((C11882) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$fadeIn$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: RippleAnimation.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.material.ripple.RippleAnimation$fadeIn$2$1", m210f = "RippleAnimation.kt", m211i = {}, m212l = {86}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ RippleAnimation this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(RippleAnimation rippleAnimation, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = rippleAnimation;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Animatable animatable = this.this$0.animatedAlpha;
                        Float fBoxFloat = Boxing.boxFloat(1.0f);
                        TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(75, 0, EasingKt.getLinearEasing(), 2, null);
                        this.label = 1;
                        if (animatable.animateTo(fBoxFloat, (4 & 2) != 0 ? animatable.defaultSpringSpec : tweenSpecTween$default, (4 & 4) != 0 ? animatable.getVelocity() : null, (4 & 8) != 0 ? null : null, this) == coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, null, new AnonymousClass1(RippleAnimation.this, null), 3, null);
                    BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, null, new AnonymousClass2(RippleAnimation.this, null), 3, null);
                    return BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, null, new AnonymousClass3(RippleAnimation.this, null), 3, null);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$fadeIn$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: RippleAnimation.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.material.ripple.RippleAnimation$fadeIn$2$2", m210f = "RippleAnimation.kt", m211i = {}, m212l = {92}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ RippleAnimation this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(RippleAnimation rippleAnimation, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = rippleAnimation;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Animatable animatable = this.this$0.animatedRadiusPercent;
                        Float fBoxFloat = Boxing.boxFloat(1.0f);
                        TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(225, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
                        this.label = 1;
                        if (animatable.animateTo(fBoxFloat, (4 & 2) != 0 ? animatable.defaultSpringSpec : tweenSpecTween$default, (4 & 4) != 0 ? animatable.getVelocity() : null, (4 & 8) != 0 ? null : null, this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$fadeIn$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: RippleAnimation.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.material.ripple.RippleAnimation$fadeIn$2$3", m210f = "RippleAnimation.kt", m211i = {}, m212l = {98}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ RippleAnimation this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(RippleAnimation rippleAnimation, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = rippleAnimation;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Animatable animatable = this.this$0.animatedCenterPercent;
                        Float fBoxFloat = Boxing.boxFloat(1.0f);
                        TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(225, 0, EasingKt.getLinearEasing(), 2, null);
                        this.label = 1;
                        if (animatable.animateTo(fBoxFloat, (4 & 2) != 0 ? animatable.defaultSpringSpec : tweenSpecTween$default, (4 & 4) != 0 ? animatable.getVelocity() : null, (4 & 8) != 0 ? null : null, this) == coroutine_suspended) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fadeIn(Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C11882(null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$fadeOut$2 */
    /* JADX INFO: compiled from: RippleAnimation.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.material.ripple.RippleAnimation$fadeOut$2", m210f = "RippleAnimation.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C11892 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C11892(Continuation<? super C11892> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11892 c11892 = RippleAnimation.this.new C11892(continuation);
            c11892.L$0 = obj;
            return c11892;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((C11892) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleAnimation$fadeOut$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: RippleAnimation.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.material.ripple.RippleAnimation$fadeOut$2$1", m210f = "RippleAnimation.kt", m211i = {}, m212l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ RippleAnimation this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(RippleAnimation rippleAnimation, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = rippleAnimation;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Animatable animatable = this.this$0.animatedAlpha;
                        Float fBoxFloat = Boxing.boxFloat(0.0f);
                        TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, EasingKt.getLinearEasing(), 2, null);
                        this.label = 1;
                        if (animatable.animateTo(fBoxFloat, (4 & 2) != 0 ? animatable.defaultSpringSpec : tweenSpecTween$default, (4 & 4) != 0 ? animatable.getVelocity() : null, (4 & 8) != 0 ? null : null, this) == coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    return BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, null, new AnonymousClass1(RippleAnimation.this, null), 3, null);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fadeOut(Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C11892(null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    public final void finish() {
        setFinishRequested(true);
        this.finishSignalDeferred.complete(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: draw-4WTKRHQ, reason: not valid java name */
    public final void m1891draw4WTKRHQ(DrawScope $this$draw_u2d4WTKRHQ, long color) {
        if (this.startRadius == null) {
            this.startRadius = Float.valueOf(RippleAnimationKt.m1893getRippleStartRadiusuvyYCjk($this$draw_u2d4WTKRHQ.mo4773getSizeNHjbRc()));
        }
        if (this.origin == null) {
            this.origin = Offset.m4038boximpl($this$draw_u2d4WTKRHQ.mo4772getCenterF1C5BW0());
        }
        if (this.targetCenter == null) {
            this.targetCenter = Offset.m4038boximpl(OffsetKt.Offset(Size.m4118getWidthimpl($this$draw_u2d4WTKRHQ.mo4773getSizeNHjbRc()) / 2.0f, Size.m4115getHeightimpl($this$draw_u2d4WTKRHQ.mo4773getSizeNHjbRc()) / 2.0f));
        }
        float alpha = (!getFinishRequested() || getFinishedFadingIn()) ? this.animatedAlpha.getValue().floatValue() : 1.0f;
        Float f = this.startRadius;
        Intrinsics.checkNotNull(f);
        float radius = MathHelpersKt.lerp(f.floatValue(), this.radius, this.animatedRadiusPercent.getValue().floatValue());
        Offset offset = this.origin;
        Intrinsics.checkNotNull(offset);
        float fM4049getXimpl = Offset.m4049getXimpl(offset.getPackedValue());
        Offset offset2 = this.targetCenter;
        Intrinsics.checkNotNull(offset2);
        float fLerp = MathHelpersKt.lerp(fM4049getXimpl, Offset.m4049getXimpl(offset2.getPackedValue()), this.animatedCenterPercent.getValue().floatValue());
        Offset offset3 = this.origin;
        Intrinsics.checkNotNull(offset3);
        float fM4050getYimpl = Offset.m4050getYimpl(offset3.getPackedValue());
        Offset offset4 = this.targetCenter;
        Intrinsics.checkNotNull(offset4);
        long centerOffset = OffsetKt.Offset(fLerp, MathHelpersKt.lerp(fM4050getYimpl, Offset.m4050getYimpl(offset4.getPackedValue()), this.animatedCenterPercent.getValue().floatValue()));
        long modulatedColor = Color.m4289copywmQWz5c(color, (14 & 1) != 0 ? Color.m4293getAlphaimpl(color) : Color.m4293getAlphaimpl(color) * alpha, (14 & 2) != 0 ? Color.m4297getRedimpl(color) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(color) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(color) : 0.0f);
        if (!this.bounded) {
            DrawScope.CC.m4845drawCircleVaOC9Bg$default($this$draw_u2d4WTKRHQ, modulatedColor, radius, centerOffset, 0.0f, null, null, 0, 120, null);
            return;
        }
        float right$iv = Size.m4118getWidthimpl($this$draw_u2d4WTKRHQ.mo4773getSizeNHjbRc());
        float bottom$iv = Size.m4115getHeightimpl($this$draw_u2d4WTKRHQ.mo4773getSizeNHjbRc());
        int clipOp$iv = ClipOp.INSTANCE.m4280getIntersectrtfAjoo();
        DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$draw_u2d4WTKRHQ.getDrawContext();
        long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.mo4779getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
        DrawTransform $this$clipRect_rOu3jXo_u24lambda_u244$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
        $this$clipRect_rOu3jXo_u24lambda_u244$iv.mo4782clipRectN_I0leg(0.0f, 0.0f, right$iv, bottom$iv, clipOp$iv);
        DrawScope.CC.m4845drawCircleVaOC9Bg$default($this$draw_u2d4WTKRHQ, modulatedColor, radius, centerOffset, 0.0f, null, null, 0, 120, null);
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv$iv.mo4780setSizeuvyYCjk(previousSize$iv$iv);
    }
}
