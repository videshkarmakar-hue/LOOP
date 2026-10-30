package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: ScrollExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\b\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m195d2 = {"animateScrollBy", "", "Landroidx/compose/foundation/gestures/ScrollableState;", DownloadUtil.CookieScheme.VALUE, "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/ScrollableState;FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollBy", "(Landroidx/compose/foundation/gestures/ScrollableState;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopScroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ScrollExtensionsKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$1 */
    /* JADX INFO: compiled from: ScrollExtensions.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.ScrollExtensionsKt", m210f = "ScrollExtensions.kt", m211i = {0}, m212l = {40}, m213m = "animateScrollBy", m214n = {"previousValue"}, m215s = {"L$0"})
    static final class C04041 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04041(Continuation<? super C04041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScrollExtensionsKt.animateScrollBy(null, 0.0f, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$1 */
    /* JADX INFO: compiled from: ScrollExtensions.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.ScrollExtensionsKt", m210f = "ScrollExtensions.kt", m211i = {0}, m212l = {LockFreeTaskQueueCore.CLOSED_SHIFT}, m213m = "scrollBy", m214n = {"consumed"}, m215s = {"L$0"})
    static final class C04061 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04061(Continuation<? super C04061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScrollExtensionsKt.scrollBy(null, 0.0f, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object animateScrollBy(ScrollableState $this$animateScrollBy, float value, AnimationSpec<Float> animationSpec, Continuation<? super Float> continuation) {
        C04041 c04041;
        Ref.FloatRef previousValue;
        if (continuation instanceof C04041) {
            c04041 = (C04041) continuation;
            if ((c04041.label & Integer.MIN_VALUE) != 0) {
                c04041.label -= Integer.MIN_VALUE;
            } else {
                c04041 = new C04041(continuation);
            }
        } else {
            c04041 = new C04041(continuation);
        }
        C04041 c04042 = c04041;
        Object $result = c04042.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c04042.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Ref.FloatRef previousValue2 = new Ref.FloatRef();
                C04052 c04052 = new C04052(value, animationSpec, previousValue2, null);
                c04042.L$0 = previousValue2;
                c04042.label = 1;
                if (ScrollableState.CC.scroll$default($this$animateScrollBy, null, c04052, c04042, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                previousValue = previousValue2;
                break;
                break;
            case 1:
                previousValue = (Ref.FloatRef) c04042.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxFloat(previousValue.element);
    }

    public static /* synthetic */ Object animateScrollBy$default(ScrollableState scrollableState, float f, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return animateScrollBy(scrollableState, f, animationSpec, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$2 */
    /* JADX INFO: compiled from: ScrollExtensions.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$2", m210f = "ScrollExtensions.kt", m211i = {}, m212l = {41}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C04052 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ Ref.FloatRef $previousValue;
        final /* synthetic */ float $value;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04052(float f, AnimationSpec<Float> animationSpec, Ref.FloatRef floatRef, Continuation<? super C04052> continuation) {
            super(2, continuation);
            this.$value = f;
            this.$animationSpec = animationSpec;
            this.$previousValue = floatRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04052 c04052 = new C04052(this.$value, this.$animationSpec, this.$previousValue, continuation);
            c04052.L$0 = obj;
            return c04052;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((C04052) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final ScrollScope $this$scroll = (ScrollScope) this.L$0;
                    float f = this.$value;
                    AnimationSpec<Float> animationSpec = this.$animationSpec;
                    final Ref.FloatRef floatRef = this.$previousValue;
                    this.label = 1;
                    if (SuspendAnimationKt.animate$default(0.0f, f, 0.0f, animationSpec, new Function2<Float, Float, Unit>() { // from class: androidx.compose.foundation.gestures.ScrollExtensionsKt.animateScrollBy.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Float f2, Float f3) {
                            invoke(f2.floatValue(), f3.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float currentValue, float f2) {
                            floatRef.element += $this$scroll.scrollBy(currentValue - floatRef.element);
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

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object scrollBy(ScrollableState $this$scrollBy, float value, Continuation<? super Float> continuation) {
        C04061 c04061;
        Ref.FloatRef consumed;
        if (continuation instanceof C04061) {
            c04061 = (C04061) continuation;
            if ((c04061.label & Integer.MIN_VALUE) != 0) {
                c04061.label -= Integer.MIN_VALUE;
            } else {
                c04061 = new C04061(continuation);
            }
        } else {
            c04061 = new C04061(continuation);
        }
        C04061 c04062 = c04061;
        Object $result = c04062.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c04062.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Ref.FloatRef consumed2 = new Ref.FloatRef();
                C04072 c04072 = new C04072(consumed2, value, null);
                c04062.L$0 = consumed2;
                c04062.label = 1;
                if (ScrollableState.CC.scroll$default($this$scrollBy, null, c04072, c04062, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                consumed = consumed2;
                break;
                break;
            case 1:
                consumed = (Ref.FloatRef) c04062.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxFloat(consumed.element);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$2 */
    /* JADX INFO: compiled from: ScrollExtensions.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$2", m210f = "ScrollExtensions.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C04072 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.FloatRef $consumed;
        final /* synthetic */ float $value;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04072(Ref.FloatRef floatRef, float f, Continuation<? super C04072> continuation) {
            super(2, continuation);
            this.$consumed = floatRef;
            this.$value = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04072 c04072 = new C04072(this.$consumed, this.$value, continuation);
            c04072.L$0 = obj;
            return c04072;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((C04072) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    ScrollScope $this$scroll = (ScrollScope) this.L$0;
                    this.$consumed.element = $this$scroll.scrollBy(this.$value);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$stopScroll$2 */
    /* JADX INFO: compiled from: ScrollExtensions.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.ScrollExtensionsKt$stopScroll$2", m210f = "ScrollExtensions.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C04082 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        int label;

        C04082(Continuation<? super C04082> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04082(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((C04082) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static /* synthetic */ Object stopScroll$default(ScrollableState scrollableState, MutatePriority mutatePriority, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return stopScroll(scrollableState, mutatePriority, continuation);
    }

    public static final Object stopScroll(ScrollableState $this$stopScroll, MutatePriority scrollPriority, Continuation<? super Unit> continuation) {
        Object objScroll = $this$stopScroll.scroll(scrollPriority, new C04082(null), continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }
}
