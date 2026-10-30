package androidx.compose.foundation.gestures;

import androidx.collection.MutableObjectFloatMap;
import androidx.collection.ObjectFloatMap;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.input.pointer.PointerInputChange;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: AnchoredDraggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0000\u0010\u0007*\u00020\b2\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\n\u0012\u0004\u0012\u00020\u000b0\u0001¢\u0006\u0002\b\fH\u0007\u001a\u0017\u0010\r\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0082\b\u001a\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0012\"\u0004\b\u0000\u0010\u0007H\u0002\u001aF\u0010\u0013\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000f2\"\u0010\u0016\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0018\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0017H\u0082@¢\u0006\u0002\u0010\u0019\u001a^\u0010\u001a\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0007*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00070\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010&\u001a\u00020\u0003H\u0007\u001aR\u0010\u001a\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0007*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00070\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010&\u001a\u00020\u0003H\u0007\u001a&\u0010'\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u001d2\u0006\u0010(\u001a\u0002H\u0007H\u0087@¢\u0006\u0002\u0010)\u001aD\u0010'\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u001d2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00062\u0006\u0010/\u001a\u0002H\u0007H\u0082@¢\u0006\u0002\u00100\u001a.\u00101\u001a\u00020+\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u001d2\u0006\u0010(\u001a\u0002H\u00072\u0006\u0010*\u001a\u00020+H\u0087@¢\u0006\u0002\u00102\u001a\u0014\u00103\u001a\u00020+*\u00020+2\u0006\u00104\u001a\u00020+H\u0002\u001a\u0018\u00105\u001a\u00020+\"\u0004\b\u0000\u00106*\b\u0012\u0004\u0012\u0002H607H\u0002\u001a\u0018\u00108\u001a\u00020+\"\u0004\b\u0000\u00106*\b\u0012\u0004\u0012\u0002H607H\u0002\u001a&\u00109\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u001d2\u0006\u0010(\u001a\u0002H\u0007H\u0087@¢\u0006\u0002\u0010)\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006:"}, m195d2 = {"AlwaysDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "DEBUG", "DraggableAnchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", ExifInterface.GPS_DIRECTION_TRUE, "", "builder", "Landroidx/compose/foundation/gestures/DraggableAnchorsConfig;", "", "Lkotlin/ExtensionFunctionType;", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "emptyDraggableAnchors", "Landroidx/compose/foundation/gestures/MapDraggableAnchors;", "restartable", "I", "inputs", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anchoredDraggable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "startDragImmediately", "animateTo", "targetValue", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "velocity", "", "anchoredDragScope", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchors", "latestTarget", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;FLandroidx/compose/foundation/gestures/AnchoredDragScope;Landroidx/compose/foundation/gestures/DraggableAnchors;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToWithDecay", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coerceToTarget", "target", "maxValueOrNaN", "K", "Landroidx/collection/ObjectFloatMap;", "minValueOrNaN", "snapTo", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AnchoredDraggableKt {
    private static final Function1<PointerInputChange, Boolean> AlwaysDrag = new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$AlwaysDrag$1
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(PointerInputChange it) {
            return true;
        }
    };
    private static final boolean DEBUG = false;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$1 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.AnchoredDraggableKt", m210f = "AnchoredDraggable.kt", m211i = {0, 0}, m212l = {1173}, m213m = "animateToWithDecay", m214n = {"remainingVelocity", "velocity"}, m215s = {"L$0", "F$0"})
    static final class C03521<T> extends ContinuationImpl {
        float F$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C03521(Continuation<? super C03521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnchoredDraggableKt.animateToWithDecay(null, null, 0.0f, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$1 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.AnchoredDraggableKt", m210f = "AnchoredDraggable.kt", m211i = {}, m212l = {1240}, m213m = "restartable", m214n = {}, m215s = {})
    static final class C03541<I> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C03541(Continuation<? super C03541> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnchoredDraggableKt.restartable(null, null, this);
        }
    }

    public static final <T> Modifier anchoredDraggable(Modifier $this$anchoredDraggable, AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean enabled, boolean reverseDirection, MutableInteractionSource interactionSource, OverscrollEffect overscrollEffect, boolean startDragImmediately) {
        return $this$anchoredDraggable.then(new AnchoredDraggableOverscrollElement(anchoredDraggableState, orientation, enabled, reverseDirection, interactionSource, startDragImmediately, overscrollEffect));
    }

    public static final <T> Modifier anchoredDraggable(Modifier $this$anchoredDraggable, AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean enabled, boolean reverseDirection, MutableInteractionSource interactionSource, boolean startDragImmediately) {
        return $this$anchoredDraggable.then(new AnchoredDraggableElement(anchoredDraggableState, orientation, enabled, reverseDirection, interactionSource, startDragImmediately));
    }

    public static final <T> DraggableAnchors<T> DraggableAnchors(Function1<? super DraggableAnchorsConfig<T>, Unit> function1) {
        DraggableAnchorsConfig draggableAnchorsConfig = new DraggableAnchorsConfig();
        function1.invoke(draggableAnchorsConfig);
        return new MapDraggableAnchors(draggableAnchorsConfig.getAnchors$foundation_release());
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$snapTo$2 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m194d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "latestTarget"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$snapTo$2", m210f = "AnchoredDraggable.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C03562<T> extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        C03562(Continuation<? super C03562> continuation) {
            super(4, continuation);
        }

        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t, Continuation<? super Unit> continuation) {
            C03562 c03562 = new C03562(continuation);
            c03562.L$0 = anchoredDragScope;
            c03562.L$1 = draggableAnchors;
            c03562.L$2 = t;
            return c03562.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    AnchoredDragScope $this$anchoredDrag = (AnchoredDragScope) this.L$0;
                    DraggableAnchors draggableAnchors = (DraggableAnchors) this.L$1;
                    Object latestTarget = this.L$2;
                    float targetOffset = draggableAnchors.positionOf(latestTarget);
                    if (!Float.isNaN(targetOffset)) {
                        AnchoredDragScope.CC.dragTo$default($this$anchoredDrag, targetOffset, 0.0f, 2, null);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static final <T> Object snapTo(AnchoredDraggableState<T> anchoredDraggableState, T t, Continuation<? super Unit> continuation) {
        Object objAnchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t, null, new C03562(null), continuation, 2, null);
        return objAnchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnchoredDrag$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Object animateTo(AnchoredDraggableState<T> anchoredDraggableState, float velocity, final AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t, Continuation<? super Unit> continuation) {
        Object objAnimate;
        float targetOffset = draggableAnchors.positionOf(t);
        final Ref.FloatRef prev = new Ref.FloatRef();
        prev.element = Float.isNaN(anchoredDraggableState.getOffset()) ? 0.0f : anchoredDraggableState.getOffset();
        if (!Float.isNaN(targetOffset)) {
            if (!(prev.element == targetOffset) && (objAnimate = SuspendAnimationKt.animate(prev.element, targetOffset, velocity, anchoredDraggableState.getSnapAnimationSpec(), new Function2<Float, Float, Unit>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateTo$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Float f, Float f2) {
                    invoke(f.floatValue(), f2.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float value, float velocity2) {
                    anchoredDragScope.dragTo(value, velocity2);
                    prev.element = value;
                }
            }, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return objAnimate;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateTo$4 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m194d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "latestTarget"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$animateTo$4", m210f = "AnchoredDraggable.kt", m211i = {}, m212l = {1146}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C03514<T> extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnchoredDraggableState<T> $this_animateTo;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03514(AnchoredDraggableState<T> anchoredDraggableState, Continuation<? super C03514> continuation) {
            super(4, continuation);
            this.$this_animateTo = anchoredDraggableState;
        }

        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t, Continuation<? super Unit> continuation) {
            C03514 c03514 = new C03514(this.$this_animateTo, continuation);
            c03514.L$0 = anchoredDragScope;
            c03514.L$1 = draggableAnchors;
            c03514.L$2 = t;
            return c03514.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    AnchoredDragScope $this$anchoredDrag = (AnchoredDragScope) this.L$0;
                    DraggableAnchors anchors = (DraggableAnchors) this.L$1;
                    Object latestTarget = this.L$2;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 1;
                    if (AnchoredDraggableKt.animateTo(this.$this_animateTo, this.$this_animateTo.getLastVelocity(), $this$anchoredDrag, anchors, latestTarget, this) == coroutine_suspended) {
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

    public static final <T> Object animateTo(AnchoredDraggableState<T> anchoredDraggableState, T t, Continuation<? super Unit> continuation) {
        Object objAnchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t, null, new C03514(anchoredDraggableState, null), continuation, 2, null);
        return objAnchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnchoredDrag$default : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object animateToWithDecay(AnchoredDraggableState<T> anchoredDraggableState, T t, float velocity, Continuation<? super Float> continuation) {
        C03521 c03521;
        Ref.FloatRef remainingVelocity;
        float velocity2;
        if (continuation instanceof C03521) {
            c03521 = (C03521) continuation;
            if ((c03521.label & Integer.MIN_VALUE) != 0) {
                c03521.label -= Integer.MIN_VALUE;
            } else {
                c03521 = new C03521(continuation);
            }
        } else {
            c03521 = new C03521(continuation);
        }
        C03521 c03522 = c03521;
        Object $result = c03522.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03522.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                remainingVelocity = new Ref.FloatRef();
                remainingVelocity.element = velocity;
                C03532 c03532 = new C03532(anchoredDraggableState, velocity, remainingVelocity, null);
                c03522.L$0 = remainingVelocity;
                c03522.F$0 = velocity;
                c03522.label = 1;
                if (AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t, null, c03532, c03522, 2, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                velocity2 = velocity;
                break;
                break;
            case 1:
                velocity2 = c03522.F$0;
                remainingVelocity = (Ref.FloatRef) c03522.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxFloat(velocity2 - remainingVelocity.element);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m194d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "latestTarget"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2", m210f = "AnchoredDraggable.kt", m211i = {}, m212l = {1183, 1201, 1216}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C03532<T> extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.FloatRef $remainingVelocity;
        final /* synthetic */ AnchoredDraggableState<T> $this_animateToWithDecay;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03532(AnchoredDraggableState<T> anchoredDraggableState, float f, Ref.FloatRef floatRef, Continuation<? super C03532> continuation) {
            super(4, continuation);
            this.$this_animateToWithDecay = anchoredDraggableState;
            this.$velocity = f;
            this.$remainingVelocity = floatRef;
        }

        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t, Continuation<? super Unit> continuation) {
            C03532 c03532 = new C03532(this.$this_animateToWithDecay, this.$velocity, this.$remainingVelocity, continuation);
            c03532.L$0 = anchoredDragScope;
            c03532.L$1 = draggableAnchors;
            c03532.L$2 = t;
            return c03532.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C03532<T> c03532;
            Object $result2;
            C03532<T> c03533;
            Object $result3;
            C03532 c03534;
            Object $result4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final AnchoredDragScope $this$anchoredDrag = (AnchoredDragScope) this.L$0;
                    DraggableAnchors draggableAnchors = (DraggableAnchors) this.L$1;
                    Object latestTarget = this.L$2;
                    final float targetOffset = draggableAnchors.positionOf(latestTarget);
                    if (!Float.isNaN(targetOffset)) {
                        final Ref.FloatRef prev = new Ref.FloatRef();
                        prev.element = Float.isNaN(this.$this_animateToWithDecay.getOffset()) ? 0.0f : this.$this_animateToWithDecay.getOffset();
                        boolean z = false;
                        if (!(prev.element == targetOffset)) {
                            if (this.$velocity * (targetOffset - prev.element) >= 0.0f) {
                                if (!(this.$velocity == 0.0f)) {
                                    float projectedDecayOffset = DecayAnimationSpecKt.calculateTargetValue(this.$this_animateToWithDecay.getDecayAnimationSpec(), prev.element, this.$velocity);
                                    if (this.$velocity > 0.0f) {
                                        if (projectedDecayOffset >= targetOffset) {
                                            z = true;
                                        }
                                    } else if (projectedDecayOffset <= targetOffset) {
                                        z = true;
                                    }
                                    boolean canDecayToTarget = z;
                                    if (canDecayToTarget) {
                                        AnimationState animationStateAnimationState$default = AnimationStateKt.AnimationState$default(prev.element, this.$velocity, 0L, 0L, false, 28, null);
                                        DecayAnimationSpec<Float> decayAnimationSpec = this.$this_animateToWithDecay.getDecayAnimationSpec();
                                        final Ref.FloatRef floatRef = this.$remainingVelocity;
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.label = 2;
                                        if (SuspendAnimationKt.animateDecay$default(animationStateAnimationState$default, decayAnimationSpec, false, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt.animateToWithDecay.2.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                                invoke2(animationScope);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                                if (Math.abs(animationScope.getValue().floatValue()) >= Math.abs(targetOffset)) {
                                                    float finalValue = AnchoredDraggableKt.coerceToTarget(animationScope.getValue().floatValue(), targetOffset);
                                                    $this$anchoredDrag.dragTo(finalValue, animationScope.getVelocity().floatValue());
                                                    floatRef.element = Float.isNaN(animationScope.getVelocity().floatValue()) ? 0.0f : animationScope.getVelocity().floatValue();
                                                    prev.element = finalValue;
                                                    animationScope.cancelAnimation();
                                                    return;
                                                }
                                                $this$anchoredDrag.dragTo(animationScope.getValue().floatValue(), animationScope.getVelocity().floatValue());
                                                floatRef.element = animationScope.getVelocity().floatValue();
                                                prev.element = animationScope.getValue().floatValue();
                                            }
                                        }, this, 2, null) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        c03534 = this;
                                        $result4 = $result;
                                    } else {
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.label = 3;
                                        if (AnchoredDraggableKt.animateTo(this.$this_animateToWithDecay, this.$velocity, $this$anchoredDrag, draggableAnchors, latestTarget, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        c03533 = this;
                                        $result3 = $result;
                                        c03533.$remainingVelocity.element = 0.0f;
                                    }
                                }
                            }
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 1;
                            if (AnchoredDraggableKt.animateTo(this.$this_animateToWithDecay, this.$velocity, $this$anchoredDrag, draggableAnchors, latestTarget, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            c03532 = this;
                            $result2 = $result;
                            c03532.$remainingVelocity.element = 0.0f;
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    c03532 = this;
                    $result2 = $result;
                    ResultKt.throwOnFailure($result2);
                    c03532.$remainingVelocity.element = 0.0f;
                    return Unit.INSTANCE;
                case 2:
                    c03534 = this;
                    $result4 = $result;
                    ResultKt.throwOnFailure($result4);
                    return Unit.INSTANCE;
                case 3:
                    c03533 = this;
                    $result3 = $result;
                    ResultKt.throwOnFailure($result3);
                    c03533.$remainingVelocity.element = 0.0f;
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float coerceToTarget(float $this$coerceToTarget, float target) {
        if (target == 0.0f) {
            return 0.0f;
        }
        return target > 0.0f ? RangesKt.coerceAtMost($this$coerceToTarget, target) : RangesKt.coerceAtLeast($this$coerceToTarget, target);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <I> Object restartable(Function0<? extends I> function0, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        C03541 c03541;
        if (continuation instanceof C03541) {
            c03541 = (C03541) continuation;
            if ((c03541.label & Integer.MIN_VALUE) != 0) {
                c03541.label -= Integer.MIN_VALUE;
            } else {
                c03541 = new C03541(continuation);
            }
        } else {
            c03541 = new C03541(continuation);
        }
        C03541 c03542 = c03541;
        Object $result = c03542.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c03542.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    C03552 c03552 = new C03552(function0, function2, null);
                    c03542.label = 1;
                    if (CoroutineScopeKt.coroutineScope(c03552, c03542) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (AnchoredDragFinishedSignal e) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m194d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m195d2 = {"<anonymous>", "", "I", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2", m210f = "AnchoredDraggable.kt", m211i = {}, m212l = {1243}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C03552 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Function0<I> $inputs;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03552(Function0<? extends I> function0, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C03552> continuation) {
            super(2, continuation);
            this.$inputs = function0;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03552 c03552 = new C03552(this.$inputs, this.$block, continuation);
            c03552.L$0 = obj;
            return c03552;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03552) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    Ref.ObjectRef previousDrag = new Ref.ObjectRef();
                    this.label = 1;
                    if (SnapshotStateKt.snapshotFlow(this.$inputs).collect(new AnonymousClass1(previousDrag, $this$coroutineScope, this.$block), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: AnchoredDraggable.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m195d2 = {"<anonymous>", "", "I", "latestInputs", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
            final /* synthetic */ Ref.ObjectRef<Job> $previousDrag;

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Ref.ObjectRef<Job> objectRef, CoroutineScope coroutineScope, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2) {
                this.$previousDrag = objectRef;
                this.$$this$coroutineScope = coroutineScope;
                this.$block = function2;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(I i, Continuation<? super Unit> continuation) {
                AnchoredDraggableKt$restartable$2$1$emit$1 anchoredDraggableKt$restartable$2$1$emit$1;
                AnonymousClass1<T> anonymousClass1;
                Object obj;
                Object obj2;
                if (continuation instanceof AnchoredDraggableKt$restartable$2$1$emit$1) {
                    anchoredDraggableKt$restartable$2$1$emit$1 = (AnchoredDraggableKt$restartable$2$1$emit$1) continuation;
                    if ((anchoredDraggableKt$restartable$2$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                        anchoredDraggableKt$restartable$2$1$emit$1.label -= Integer.MIN_VALUE;
                    } else {
                        anchoredDraggableKt$restartable$2$1$emit$1 = new AnchoredDraggableKt$restartable$2$1$emit$1(this, continuation);
                    }
                } else {
                    anchoredDraggableKt$restartable$2$1$emit$1 = new AnchoredDraggableKt$restartable$2$1$emit$1(this, continuation);
                }
                AnchoredDraggableKt$restartable$2$1$emit$1 anchoredDraggableKt$restartable$2$1$emit$2 = anchoredDraggableKt$restartable$2$1$emit$1;
                Object obj3 = anchoredDraggableKt$restartable$2$1$emit$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (anchoredDraggableKt$restartable$2$1$emit$2.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj3);
                        anonymousClass1 = this;
                        Job job = anonymousClass1.$previousDrag.element;
                        obj2 = i;
                        if (job != null) {
                            job.cancel((CancellationException) new AnchoredDragFinishedSignal());
                            anchoredDraggableKt$restartable$2$1$emit$2.L$0 = anonymousClass1;
                            anchoredDraggableKt$restartable$2$1$emit$2.L$1 = i;
                            anchoredDraggableKt$restartable$2$1$emit$2.L$2 = job;
                            anchoredDraggableKt$restartable$2$1$emit$2.label = 1;
                            if (job.join(anchoredDraggableKt$restartable$2$1$emit$2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj = i;
                            obj2 = obj;
                        }
                        anonymousClass1.$previousDrag.element = (T) BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(anonymousClass1.$block, obj2, anonymousClass1.$$this$coroutineScope, null), 1, null);
                        return Unit.INSTANCE;
                    case 1:
                        Object obj4 = anchoredDraggableKt$restartable$2$1$emit$2.L$1;
                        anonymousClass1 = (AnonymousClass1) anchoredDraggableKt$restartable$2$1$emit$2.L$0;
                        ResultKt.throwOnFailure(obj3);
                        obj = obj4;
                        obj2 = obj;
                        anonymousClass1.$previousDrag.element = (T) BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(anonymousClass1.$block, obj2, anonymousClass1.$$this$coroutineScope, null), 1, null);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: AnchoredDraggable.kt */
            @Metadata(m194d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m195d2 = {"<anonymous>", "", "I", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$2", m210f = "AnchoredDraggable.kt", m211i = {}, m212l = {1249}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
                final /* synthetic */ I $latestInputs;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass2(Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2, I i, CoroutineScope coroutineScope, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$block = function2;
                    this.$latestInputs = i;
                    this.$$this$coroutineScope = coroutineScope;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.$block, this.$latestInputs, this.$$this$coroutineScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    AnonymousClass2 anonymousClass2;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Function2<I, Continuation<? super Unit>, Object> function2 = this.$block;
                            I i = this.$latestInputs;
                            this.label = 1;
                            if (function2.invoke(i, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            anonymousClass2 = this;
                            break;
                            break;
                        case 1:
                            anonymousClass2 = this;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    CoroutineScopeKt.cancel(anonymousClass2.$$this$coroutineScope, new AnchoredDragFinishedSignal());
                    return Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> MapDraggableAnchors<T> emptyDraggableAnchors() {
        return new MapDraggableAnchors<>(new MutableObjectFloatMap(0, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x006a A[DONT_INVERT, PHI: r0
  0x006a: PHI (r0v5 'minValue' float) = (r0v4 'minValue' float), (r0v6 'minValue' float) binds: [B:9:0x0030, B:22:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:24:0x006c A[LOOP:0: B:8:0x001c->B:24:0x006c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x0074 A[EDGE_INSN: B:30:0x0074->B:28:0x0074 BREAK  A[LOOP:0: B:8:0x001c->B:24:0x006c], SYNTHETIC] */
    public static final <K> float minValueOrNaN(ObjectFloatMap<K> objectFloatMap) {
        if (objectFloatMap.get_size() == 1) {
            return Float.NaN;
        }
        float minValue = Float.POSITIVE_INFINITY;
        ObjectFloatMap<K> objectFloatMap2 = objectFloatMap;
        float[] v$iv = objectFloatMap2.values;
        long[] m$iv$iv = objectFloatMap2.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 <= lastIndex$iv$iv) {
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                ObjectFloatMap<K> objectFloatMap3 = objectFloatMap2;
                if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i$iv$iv != lastIndex$iv$iv) {
                        break;
                        break;
                    }
                    i$iv$iv++;
                    objectFloatMap2 = objectFloatMap3;
                } else {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                        long value$iv$iv$iv = 255 & slot$iv$iv;
                        if (value$iv$iv$iv < 128) {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            float value = v$iv[index$iv$iv];
                            if (value <= minValue) {
                                minValue = value;
                            }
                        }
                        slot$iv$iv >>= 8;
                    }
                    if (bitCount$iv$iv != 8) {
                        break;
                    }
                    if (i$iv$iv != lastIndex$iv$iv) {
                        break;
                    }
                    i$iv$iv++;
                    objectFloatMap2 = objectFloatMap3;
                }
            }
        }
        return minValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x006a A[DONT_INVERT, PHI: r0
  0x006a: PHI (r0v5 'maxValue' float) = (r0v4 'maxValue' float), (r0v6 'maxValue' float) binds: [B:9:0x0030, B:22:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:24:0x006c A[LOOP:0: B:8:0x001c->B:24:0x006c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x0074 A[EDGE_INSN: B:30:0x0074->B:28:0x0074 BREAK  A[LOOP:0: B:8:0x001c->B:24:0x006c], SYNTHETIC] */
    public static final <K> float maxValueOrNaN(ObjectFloatMap<K> objectFloatMap) {
        if (objectFloatMap.get_size() == 1) {
            return Float.NaN;
        }
        float maxValue = Float.NEGATIVE_INFINITY;
        ObjectFloatMap<K> objectFloatMap2 = objectFloatMap;
        float[] v$iv = objectFloatMap2.values;
        long[] m$iv$iv = objectFloatMap2.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 <= lastIndex$iv$iv) {
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                ObjectFloatMap<K> objectFloatMap3 = objectFloatMap2;
                if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i$iv$iv != lastIndex$iv$iv) {
                        break;
                        break;
                    }
                    i$iv$iv++;
                    objectFloatMap2 = objectFloatMap3;
                } else {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                        long value$iv$iv$iv = 255 & slot$iv$iv;
                        if (value$iv$iv$iv < 128) {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            float value = v$iv[index$iv$iv];
                            if (value >= maxValue) {
                                maxValue = value;
                            }
                        }
                        slot$iv$iv >>= 8;
                    }
                    if (bitCount$iv$iv != 8) {
                        break;
                    }
                    if (i$iv$iv != lastIndex$iv$iv) {
                        break;
                    }
                    i$iv$iv++;
                    objectFloatMap2 = objectFloatMap3;
                }
            }
        }
        return maxValue;
    }

    private static final void debugLog(Function0<String> function0) {
    }
}
