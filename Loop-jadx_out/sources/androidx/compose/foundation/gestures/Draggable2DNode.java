package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.input.pointer.PointerInputChange;
import androidx.compose.p001ui.unit.Velocity;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Draggable2D.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B¿\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012<\u0010\f\u001a8\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r¢\u0006\u0002\b\u0016\u0012<\u0010\u0017\u001a8\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r¢\u0006\u0002\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0002\u0010\u001bJM\u0010!\u001a\u00020\u00142=\u0010\"\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110$¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00140\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150#H\u0096@¢\u0006\u0002\u0010&J\b\u0010\u000b\u001a\u00020\u0007H\u0016JÅ\u0001\u0010'\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00072<\u0010\f\u001a8\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r¢\u0006\u0002\b\u00162<\u0010\u0017\u001a8\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r¢\u0006\u0002\b\u00162\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0002\u0010\u001bJ\u001f\u0010\f\u001a\u00020\u0014*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000fH\u0096@ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u001f\u0010\u0017\u001a\u00020\u0014*\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018H\u0096@ø\u0001\u0000¢\u0006\u0004\b*\u0010)J\u0016\u0010+\u001a\u00020\u000f*\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0016\u0010+\u001a\u00020\u0018*\u00020\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010-RF\u0010\f\u001a8\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r¢\u0006\u0002\b\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cRF\u0010\u0017\u001a8\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r¢\u0006\u0002\b\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006/"}, m195d2 = {"Landroidx/compose/foundation/gestures/Draggable2DNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "state", "Landroidx/compose/foundation/gestures/Draggable2DState;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "Landroidx/compose/ui/unit/Velocity;", "velocity", "reverseDirection", "(Landroidx/compose/foundation/gestures/Draggable2DState;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)V", "Lkotlin/jvm/functions/Function3;", "pointerDirectionConfig", "Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "getPointerDirectionConfig", "()Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "drag", "forEachDelta", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "dragDelta", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "onDragStarted-d-4ec7I", "(Lkotlinx/coroutines/CoroutineScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped-LuvzFrg", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "(J)J", "reverseIfNeeded-AH228Gc", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Draggable2DNode extends DragGestureNode {
    public static final int $stable = 8;
    private Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted;
    private Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> onDragStopped;
    private final PointerDirectionConfig pointerDirectionConfig;
    private boolean reverseDirection;
    private boolean startDragImmediately;
    private Draggable2DState state;

    public Draggable2DNode(Draggable2DState state, Function1<? super PointerInputChange, Boolean> function1, boolean enabled, MutableInteractionSource interactionSource, boolean startDragImmediately, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> function4, boolean reverseDirection) {
        super(function1, enabled, interactionSource);
        this.state = state;
        this.startDragImmediately = startDragImmediately;
        this.onDragStarted = function3;
        this.onDragStopped = function4;
        this.reverseDirection = reverseDirection;
        this.pointerDirectionConfig = DragGestureDetectorKt.getBidirectionalPointerDirectionConfig();
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.Draggable2DNode$drag$2 */
    /* JADX INFO: compiled from: Draggable2D.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/Drag2DScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.Draggable2DNode$drag$2", m210f = "Draggable2D.kt", m211i = {}, m212l = {279}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C03942 extends SuspendLambda implements Function2<Drag2DScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> $forEachDelta;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ Draggable2DNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03942(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Draggable2DNode draggable2DNode, Continuation<? super C03942> continuation) {
            super(2, continuation);
            this.$forEachDelta = function2;
            this.this$0 = draggable2DNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03942 c03942 = new C03942(this.$forEachDelta, this.this$0, continuation);
            c03942.L$0 = obj;
            return c03942;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Drag2DScope drag2DScope, Continuation<? super Unit> continuation) {
            return ((C03942) create(drag2DScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final Drag2DScope $this$drag = (Drag2DScope) this.L$0;
                    Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> function2 = this.$forEachDelta;
                    final Draggable2DNode draggable2DNode = this.this$0;
                    Function1<DragEvent.DragDelta, Unit> function1 = new Function1<DragEvent.DragDelta, Unit>() { // from class: androidx.compose.foundation.gestures.Draggable2DNode.drag.2.1
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
                        public final void invoke2(DragEvent.DragDelta dragDelta) {
                            $this$drag.mo593dragByk4lQ0M(draggable2DNode.m629reverseIfNeededMKHz9U(dragDelta.getDelta()));
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

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objDrag = this.state.drag(MutatePriority.UserInput, new C03942(function2, this, null), continuation);
        return objDrag == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDrag : Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public PointerDirectionConfig getPointerDirectionConfig() {
        return this.pointerDirectionConfig;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStarted-d-4ec7I */
    public Object mo574onDragStartedd4ec7I(CoroutineScope $this$onDragStarted_u2dd_u2d4ec7I, long startedPosition, Continuation<? super Unit> continuation) {
        Object objInvoke = this.onDragStarted.invoke($this$onDragStarted_u2dd_u2d4ec7I, Offset.m4038boximpl(startedPosition), continuation);
        return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStopped-LuvzFrg */
    public Object mo575onDragStoppedLuvzFrg(CoroutineScope $this$onDragStopped_u2dLuvzFrg, long velocity, Continuation<? super Unit> continuation) {
        Object objInvoke = this.onDragStopped.invoke($this$onDragStopped_u2dLuvzFrg, Velocity.m7033boximpl(m628reverseIfNeededAH228Gc(velocity)), continuation);
        return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: startDragImmediately, reason: from getter */
    public boolean getStartDragImmediately() {
        return this.startDragImmediately;
    }

    public final void update(Draggable2DState state, Function1<? super PointerInputChange, Boolean> canDrag, boolean enabled, MutableInteractionSource interactionSource, boolean startDragImmediately, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, boolean reverseDirection) {
        boolean resetPointerInputHandling = false;
        if (!Intrinsics.areEqual(this.state, state)) {
            this.state = state;
            resetPointerInputHandling = true;
        }
        if (this.reverseDirection != reverseDirection) {
            this.reverseDirection = reverseDirection;
            resetPointerInputHandling = true;
        }
        this.onDragStarted = onDragStarted;
        this.onDragStopped = onDragStopped;
        this.startDragImmediately = startDragImmediately;
        update(canDrag, enabled, interactionSource, resetPointerInputHandling);
    }

    /* JADX INFO: renamed from: reverseIfNeeded-AH228Gc, reason: not valid java name */
    private final long m628reverseIfNeededAH228Gc(long $this$reverseIfNeeded_u2dAH228Gc) {
        return Velocity.m7048timesadjELrA($this$reverseIfNeeded_u2dAH228Gc, this.reverseDirection ? -1.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m629reverseIfNeededMKHz9U(long $this$reverseIfNeeded_u2dMK_u2dHz9U) {
        return Offset.m4056timestuRUvjQ($this$reverseIfNeeded_u2dMK_u2dHz9U, this.reverseDirection ? -1.0f : 1.0f);
    }
}
