package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollSource;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AnchoredDraggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BG\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJH\u0010\u0010\u001a\u00020\u00112\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\bJQ\u0010\u0012\u001a\u00020\u0011*\u00020\u00132=\u0010\u0014\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00110\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0015H\u0096@¢\u0006\u0002\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\u0011*\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0096@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, m195d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableOverscrollNode;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDraggableNode;", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLandroidx/compose/foundation/OverscrollEffect;)V", "update", "", "anchoredDrag", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "forEachDelta", "Lkotlin/Function2;", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/compose/foundation/gestures/AnchoredDragScope;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped", "Lkotlinx/coroutines/CoroutineScope;", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-LuvzFrg", "(Lkotlinx/coroutines/CoroutineScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class AnchoredDraggableOverscrollNode<T> extends AnchoredDraggableNode<T> {
    private OverscrollEffect overscrollEffect;

    public AnchoredDraggableOverscrollNode(AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean enabled, boolean reverseDirection, MutableInteractionSource interactionSource, boolean startDragImmediately, OverscrollEffect overscrollEffect) {
        super(anchoredDraggableState, orientation, enabled, reverseDirection, interactionSource, startDragImmediately);
        this.overscrollEffect = overscrollEffect;
    }

    @Override // androidx.compose.foundation.gestures.AnchoredDraggableNode
    public Object anchoredDrag(final AnchoredDragScope $this$anchoredDrag, Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objInvoke = function2.invoke(new Function1<DragEvent.DragDelta, Unit>(this) { // from class: androidx.compose.foundation.gestures.AnchoredDraggableOverscrollNode.anchoredDrag.2
            final /* synthetic */ AnchoredDraggableOverscrollNode<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DragEvent.DragDelta dragDelta) {
                invoke2(dragDelta);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DragEvent.DragDelta dragDelta) {
                if (((AnchoredDraggableOverscrollNode) this.this$0).overscrollEffect != null) {
                    OverscrollEffect overscrollEffect = ((AnchoredDraggableOverscrollNode) this.this$0).overscrollEffect;
                    Intrinsics.checkNotNull(overscrollEffect);
                    long j = this.this$0.m577reverseIfNeededMKHz9U(dragDelta.getDelta());
                    int iM5403getDragWNlRxjI = NestedScrollSource.INSTANCE.m5403getDragWNlRxjI();
                    final AnchoredDraggableOverscrollNode<T> anchoredDraggableOverscrollNode = this.this$0;
                    final AnchoredDragScope anchoredDragScope = $this$anchoredDrag;
                    overscrollEffect.mo436applyToScrollRhakbz0(j, iM5403getDragWNlRxjI, new Function1<Offset, Offset>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableOverscrollNode.anchoredDrag.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Offset invoke(Offset offset) {
                            return Offset.m4038boximpl(m582invokeMKHz9U(offset.getPackedValue()));
                        }

                        /* JADX INFO: renamed from: invoke-MK-Hz9U, reason: not valid java name */
                        public final long m582invokeMKHz9U(long deltaForDrag) {
                            float dragOffset = anchoredDraggableOverscrollNode.getState().newOffsetForDelta$foundation_release(anchoredDraggableOverscrollNode.m579toFloatk4lQ0M(deltaForDrag));
                            long consumedDelta = anchoredDraggableOverscrollNode.m580toOffsettuRUvjQ(dragOffset - anchoredDraggableOverscrollNode.getState().requireOffset());
                            AnchoredDragScope.CC.dragTo$default(anchoredDragScope, dragOffset, 0.0f, 2, null);
                            return consumedDelta;
                        }
                    });
                    return;
                }
                AnchoredDragScope.CC.dragTo$default($this$anchoredDrag, this.this$0.getState().newOffsetForDelta$foundation_release(this.this$0.m579toFloatk4lQ0M(this.this$0.m577reverseIfNeededMKHz9U(dragDelta.getDelta()))), 0.0f, 2, null);
            }
        }, continuation);
        return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.foundation.gestures.AnchoredDraggableNode, androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStopped-LuvzFrg */
    public Object mo575onDragStoppedLuvzFrg(CoroutineScope coroutineScope, long velocity, Continuation<? super Unit> continuation) {
        AnchoredDraggableOverscrollNode$onDragStopped$1 anchoredDraggableOverscrollNode$onDragStopped$1;
        Object obj;
        AnchoredDraggableOverscrollNode<T> anchoredDraggableOverscrollNode;
        if (continuation instanceof AnchoredDraggableOverscrollNode$onDragStopped$1) {
            anchoredDraggableOverscrollNode$onDragStopped$1 = (AnchoredDraggableOverscrollNode$onDragStopped$1) continuation;
            if ((anchoredDraggableOverscrollNode$onDragStopped$1.label & Integer.MIN_VALUE) != 0) {
                anchoredDraggableOverscrollNode$onDragStopped$1.label -= Integer.MIN_VALUE;
            } else {
                anchoredDraggableOverscrollNode$onDragStopped$1 = new AnchoredDraggableOverscrollNode$onDragStopped$1(this, continuation);
            }
        } else {
            anchoredDraggableOverscrollNode$onDragStopped$1 = new AnchoredDraggableOverscrollNode$onDragStopped$1(this, continuation);
        }
        Object $result = anchoredDraggableOverscrollNode$onDragStopped$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anchoredDraggableOverscrollNode$onDragStopped$1.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.overscrollEffect == null) {
                    AnchoredDraggableState<T> state = getState();
                    float f = m578toFloatTH1AsA0(m576reverseIfNeededAH228Gc(velocity));
                    anchoredDraggableOverscrollNode$onDragStopped$1.L$0 = this;
                    anchoredDraggableOverscrollNode$onDragStopped$1.label = 1;
                    Object obj2 = state.settle(f, anchoredDraggableOverscrollNode$onDragStopped$1);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = obj2;
                    anchoredDraggableOverscrollNode = this;
                    anchoredDraggableOverscrollNode.m581toVelocityadjELrA(((Number) obj).floatValue());
                } else {
                    OverscrollEffect overscrollEffect = this.overscrollEffect;
                    Intrinsics.checkNotNull(overscrollEffect);
                    long velocity2 = m576reverseIfNeededAH228Gc(velocity);
                    AnchoredDraggableOverscrollNode$onDragStopped$2 anchoredDraggableOverscrollNode$onDragStopped$2 = new AnchoredDraggableOverscrollNode$onDragStopped$2(this, null);
                    anchoredDraggableOverscrollNode$onDragStopped$1.label = 2;
                    if (overscrollEffect.mo435applyToFlingBMRW4eQ(velocity2, anchoredDraggableOverscrollNode$onDragStopped$2, anchoredDraggableOverscrollNode$onDragStopped$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                anchoredDraggableOverscrollNode = (AnchoredDraggableOverscrollNode) anchoredDraggableOverscrollNode$onDragStopped$1.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                anchoredDraggableOverscrollNode.m581toVelocityadjELrA(((Number) obj).floatValue());
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void update(AnchoredDraggableState<T> state, Orientation orientation, boolean enabled, boolean reverseDirection, MutableInteractionSource interactionSource, OverscrollEffect overscrollEffect, boolean startDragImmediately) {
        this.overscrollEffect = overscrollEffect;
        update(state, orientation, enabled, reverseDirection, interactionSource, startDragImmediately);
    }
}
