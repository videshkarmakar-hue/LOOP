package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.unit.Velocity;
import androidx.compose.p001ui.unit.VelocityKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
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

/* JADX INFO: compiled from: AnchoredDraggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B=\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0002\u0010\rJM\u0010 \u001a\u00020!2=\u0010\"\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020!0$\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0)\u0012\u0006\u0012\u0004\u0018\u00010*0#H\u0096@¢\u0006\u0002\u0010+J\b\u0010\f\u001a\u00020\bH\u0016J>\u0010,\u001a\u00020!2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\bJQ\u0010-\u001a\u00020!*\u00020.2=\u0010\"\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020!0$\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0)\u0012\u0006\u0012\u0004\u0018\u00010*0#H\u0096@¢\u0006\u0002\u0010/J\u001f\u00100\u001a\u00020!*\u0002012\u0006\u00102\u001a\u000203H\u0096@ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u001f\u00106\u001a\u00020!*\u0002012\u0006\u00107\u001a\u000208H\u0096@ø\u0001\u0000¢\u0006\u0004\b9\u00105J\u0016\u0010:\u001a\u000203*\u000203H\u0004ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u0016\u0010:\u001a\u000208*\u000208H\u0004ø\u0001\u0000¢\u0006\u0004\b=\u0010<J\u0016\u0010>\u001a\u00020?*\u000203H\u0004ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u0016\u0010>\u001a\u00020?*\u000208H\u0004ø\u0001\u0000¢\u0006\u0004\bB\u0010AJ\u0019\u0010C\u001a\u000203*\u00020?H\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u000208*\u00020?H\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010ER\u001a\u0010\u0005\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\f\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006H"}, m195d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableNode;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/DragGestureNode;", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Z)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientation", "(Landroidx/compose/foundation/gestures/Orientation;)V", "pointerDirectionConfig", "Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "getPointerDirectionConfig", "()Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "getReverseDirection", "()Z", "setReverseDirection", "(Z)V", "getStartDragImmediately", "setStartDragImmediately", "getState", "()Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "setState", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;)V", "drag", "", "forEachDelta", "Lkotlin/Function2;", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "anchoredDrag", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "(Landroidx/compose/foundation/gestures/AnchoredDragScope;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "Lkotlinx/coroutines/CoroutineScope;", "startedPosition", "Landroidx/compose/ui/geometry/Offset;", "onDragStarted-d-4ec7I", "(Lkotlinx/coroutines/CoroutineScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-LuvzFrg", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "(J)J", "reverseIfNeeded-AH228Gc", "toFloat", "", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "toVelocity", "toVelocity-adjELrA", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
class AnchoredDraggableNode<T> extends DragGestureNode {
    private Orientation orientation;
    private boolean reverseDirection;
    private boolean startDragImmediately;
    private AnchoredDraggableState<T> state;

    public Object anchoredDrag(AnchoredDragScope anchoredDragScope, Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return anchoredDrag$suspendImpl(this, anchoredDragScope, function2, continuation);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return drag$suspendImpl(this, function2, continuation);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStarted-d-4ec7I, reason: not valid java name */
    public Object mo574onDragStartedd4ec7I(CoroutineScope coroutineScope, long j, Continuation<? super Unit> continuation) {
        return m572onDragStartedd4ec7I$suspendImpl(this, coroutineScope, j, continuation);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStopped-LuvzFrg, reason: not valid java name */
    public Object mo575onDragStoppedLuvzFrg(CoroutineScope coroutineScope, long j, Continuation<? super Unit> continuation) {
        return m573onDragStoppedLuvzFrg$suspendImpl(this, coroutineScope, j, continuation);
    }

    protected final AnchoredDraggableState<T> getState() {
        return this.state;
    }

    protected final void setState(AnchoredDraggableState<T> anchoredDraggableState) {
        this.state = anchoredDraggableState;
    }

    protected final Orientation getOrientation() {
        return this.orientation;
    }

    protected final void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    protected final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    protected final void setReverseDirection(boolean z) {
        this.reverseDirection = z;
    }

    protected final boolean getStartDragImmediately() {
        return this.startDragImmediately;
    }

    protected final void setStartDragImmediately(boolean z) {
        this.startDragImmediately = z;
    }

    public AnchoredDraggableNode(AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean enabled, boolean reverseDirection, MutableInteractionSource interactionSource, boolean startDragImmediately) {
        super(AnchoredDraggableKt.AlwaysDrag, enabled, interactionSource);
        this.state = anchoredDraggableState;
        this.orientation = orientation;
        this.reverseDirection = reverseDirection;
        this.startDragImmediately = startDragImmediately;
    }

    static /* synthetic */ <T> Object anchoredDrag$suspendImpl(final AnchoredDraggableNode<T> anchoredDraggableNode, final AnchoredDragScope $receiver, Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objInvoke = function2.invoke(new Function1<DragEvent.DragDelta, Unit>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableNode.anchoredDrag.2
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
                AnchoredDragScope.CC.dragTo$default($receiver, anchoredDraggableNode.getState().newOffsetForDelta$foundation_release(anchoredDraggableNode.m579toFloatk4lQ0M(anchoredDraggableNode.m577reverseIfNeededMKHz9U(dragDelta.getDelta()))), 0.0f, 2, null);
            }
        }, continuation);
        return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m194d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "it", "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2", m210f = "AnchoredDraggable.kt", m211i = {}, m212l = {389}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C03582 extends SuspendLambda implements Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> $forEachDelta;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03582(AnchoredDraggableNode<T> anchoredDraggableNode, Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C03582> continuation) {
            super(3, continuation);
            this.this$0 = anchoredDraggableNode;
            this.$forEachDelta = function2;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, Continuation<? super Unit> continuation) {
            C03582 c03582 = new C03582(this.this$0, this.$forEachDelta, continuation);
            c03582.L$0 = anchoredDragScope;
            return c03582.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    AnchoredDragScope $this$anchoredDrag = (AnchoredDragScope) this.L$0;
                    this.label = 1;
                    if (this.this$0.anchoredDrag($this$anchoredDrag, this.$forEachDelta, this) == coroutine_suspended) {
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

    static /* synthetic */ <T> Object drag$suspendImpl(AnchoredDraggableNode<T> anchoredDraggableNode, Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objAnchoredDrag = ((AnchoredDraggableNode) anchoredDraggableNode).state.anchoredDrag(MutatePriority.Default, new C03582(anchoredDraggableNode, function2, null), continuation);
        return objAnchoredDrag == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnchoredDrag : Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public PointerDirectionConfig getPointerDirectionConfig() {
        return DragGestureDetectorKt.toPointerDirectionConfig(this.orientation);
    }

    /* JADX INFO: renamed from: onDragStarted-d-4ec7I$suspendImpl, reason: not valid java name */
    static /* synthetic */ <T> Object m572onDragStartedd4ec7I$suspendImpl(AnchoredDraggableNode<T> anchoredDraggableNode, CoroutineScope $receiver, long startedPosition, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: onDragStopped-LuvzFrg$suspendImpl, reason: not valid java name */
    static /* synthetic */ <T> Object m573onDragStoppedLuvzFrg$suspendImpl(AnchoredDraggableNode<T> anchoredDraggableNode, CoroutineScope coroutineScope, long velocity, Continuation<? super Unit> continuation) {
        AnchoredDraggableNode$onDragStopped$1 anchoredDraggableNode$onDragStopped$1;
        Object obj;
        if (continuation instanceof AnchoredDraggableNode$onDragStopped$1) {
            anchoredDraggableNode$onDragStopped$1 = (AnchoredDraggableNode$onDragStopped$1) continuation;
            if ((anchoredDraggableNode$onDragStopped$1.label & Integer.MIN_VALUE) != 0) {
                anchoredDraggableNode$onDragStopped$1.label -= Integer.MIN_VALUE;
            } else {
                anchoredDraggableNode$onDragStopped$1 = new AnchoredDraggableNode$onDragStopped$1(anchoredDraggableNode, continuation);
            }
        } else {
            anchoredDraggableNode$onDragStopped$1 = new AnchoredDraggableNode$onDragStopped$1(anchoredDraggableNode, continuation);
        }
        Object $result = anchoredDraggableNode$onDragStopped$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anchoredDraggableNode$onDragStopped$1.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AnchoredDraggableState<T> anchoredDraggableState = ((AnchoredDraggableNode) anchoredDraggableNode).state;
                float fM578toFloatTH1AsA0 = anchoredDraggableNode.m578toFloatTH1AsA0(anchoredDraggableNode.m576reverseIfNeededAH228Gc(velocity));
                anchoredDraggableNode$onDragStopped$1.L$0 = anchoredDraggableNode;
                anchoredDraggableNode$onDragStopped$1.label = 1;
                obj = anchoredDraggableState.settle(fM578toFloatTH1AsA0, anchoredDraggableNode$onDragStopped$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                anchoredDraggableNode = (AnchoredDraggableNode) anchoredDraggableNode$onDragStopped$1.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        anchoredDraggableNode.m581toVelocityadjELrA(((Number) obj).floatValue());
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public boolean startDragImmediately() {
        return this.startDragImmediately;
    }

    public final void update(AnchoredDraggableState<T> state, Orientation orientation, boolean enabled, boolean reverseDirection, MutableInteractionSource interactionSource, boolean startDragImmediately) {
        boolean resetPointerInputHandling = false;
        if (!Intrinsics.areEqual(this.state, state)) {
            this.state = state;
            resetPointerInputHandling = true;
        }
        if (this.orientation != orientation) {
            this.orientation = orientation;
            resetPointerInputHandling = true;
        }
        if (this.reverseDirection != reverseDirection) {
            this.reverseDirection = reverseDirection;
            resetPointerInputHandling = true;
        }
        this.startDragImmediately = startDragImmediately;
        DragGestureNode.update$default(this, null, enabled, interactionSource, resetPointerInputHandling, 1, null);
    }

    /* JADX INFO: renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    protected final long m580toOffsettuRUvjQ(float $this$toOffset_u2dtuRUvjQ) {
        return OffsetKt.Offset(this.orientation == Orientation.Horizontal ? $this$toOffset_u2dtuRUvjQ : 0.0f, this.orientation == Orientation.Vertical ? $this$toOffset_u2dtuRUvjQ : 0.0f);
    }

    /* JADX INFO: renamed from: toVelocity-adjELrA, reason: not valid java name */
    protected final long m581toVelocityadjELrA(float $this$toVelocity_u2dadjELrA) {
        return VelocityKt.Velocity(this.orientation == Orientation.Horizontal ? $this$toVelocity_u2dadjELrA : 0.0f, this.orientation == Orientation.Vertical ? $this$toVelocity_u2dadjELrA : 0.0f);
    }

    /* JADX INFO: renamed from: toFloat-TH1AsA0, reason: not valid java name */
    protected final float m578toFloatTH1AsA0(long $this$toFloat_u2dTH1AsA0) {
        return this.orientation == Orientation.Vertical ? Velocity.m7043getYimpl($this$toFloat_u2dTH1AsA0) : Velocity.m7042getXimpl($this$toFloat_u2dTH1AsA0);
    }

    /* JADX INFO: renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    protected final float m579toFloatk4lQ0M(long $this$toFloat_u2dk_u2d4lQ0M) {
        return this.orientation == Orientation.Vertical ? Offset.m4050getYimpl($this$toFloat_u2dk_u2d4lQ0M) : Offset.m4049getXimpl($this$toFloat_u2dk_u2d4lQ0M);
    }

    /* JADX INFO: renamed from: reverseIfNeeded-AH228Gc, reason: not valid java name */
    protected final long m576reverseIfNeededAH228Gc(long $this$reverseIfNeeded_u2dAH228Gc) {
        return Velocity.m7048timesadjELrA($this$reverseIfNeeded_u2dAH228Gc, this.reverseDirection ? -1.0f : 1.0f);
    }

    /* JADX INFO: renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    protected final long m577reverseIfNeededMKHz9U(long $this$reverseIfNeeded_u2dMK_u2dHz9U) {
        return Offset.m4056timestuRUvjQ($this$reverseIfNeeded_u2dMK_u2dHz9U, this.reverseDirection ? -1.0f : 1.0f);
    }
}
