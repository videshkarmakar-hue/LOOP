package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p001ui.input.pointer.PointerEvent;
import androidx.compose.p001ui.input.pointer.PointerEventPass;
import androidx.compose.p001ui.input.pointer.PointerInputChange;
import androidx.compose.p001ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p001ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.p001ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.p001ui.node.DelegatingNode;
import androidx.compose.p001ui.node.PointerInputModifierNode;
import androidx.compose.p001ui.unit.Velocity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.videshkarmakar.loop.p006ui.common.Route;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B+\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010 \u001a\u00020!JM\u0010\"\u001a\u00020!2=\u0010#\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020!0\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0)\u0012\u0006\u0012\u0004\u0018\u00010*0$H¦@¢\u0006\u0002\u0010+J\b\u0010,\u001a\u00020!H\u0016J\b\u0010-\u001a\u00020!H\u0016J*\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016ø\u0001\u0000¢\u0006\u0004\b5\u00106J\b\u00107\u001a\u00020\u0007H&J\b\u00108\u001a\u00020!H\u0002J<\u00109\u001a\u00020!2\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010:\u001a\u00020\u0007J\u001f\u0010;\u001a\u00020!*\u00020<2\u0006\u0010=\u001a\u00020>H¦@ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u001f\u0010A\u001a\u00020!*\u00020<2\u0006\u0010B\u001a\u00020CH¦@ø\u0001\u0000¢\u0006\u0004\bD\u0010@J\u0012\u0010E\u001a\u00020!*\u00020<H\u0082@¢\u0006\u0002\u0010FJ\u001a\u0010G\u001a\u00020!*\u00020<2\u0006\u0010H\u001a\u00020IH\u0082@¢\u0006\u0002\u0010JJ\u001a\u0010K\u001a\u00020!*\u00020<2\u0006\u0010H\u001a\u00020LH\u0082@¢\u0006\u0002\u0010MR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006N"}, m195d2 = {"Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function1;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;)V", "_canDrag", "<set-?>", "getCanDrag", "()Lkotlin/jvm/functions/Function1;", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/DragEvent;", "dragInteraction", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "getEnabled", "()Z", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isListeningForEvents", "pointerDirectionConfig", "Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "getPointerDirectionConfig", "()Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "disposeInteractionSource", "", "drag", "forEachDelta", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCancelPointerInput", "onDetach", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "startDragImmediately", "startListeningForEvents", "update", "isResetPointerInputHandling", "onDragStarted", "Lkotlinx/coroutines/CoroutineScope;", "startedPosition", "Landroidx/compose/ui/geometry/Offset;", "onDragStarted-d-4ec7I", "(Lkotlinx/coroutines/CoroutineScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-LuvzFrg", "processDragCancel", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStart", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/DragEvent$DragStarted;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStop", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/DragEvent$DragStopped;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class DragGestureNode extends DelegatingNode implements PointerInputModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private Function1<? super PointerInputChange, Boolean> canDrag;
    private Channel<DragEvent> channel;
    private DragInteraction.Start dragInteraction;
    private boolean enabled;
    private MutableInteractionSource interactionSource;
    private boolean isListeningForEvents;
    private final Function1<PointerInputChange, Boolean> _canDrag = new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$_canDrag$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(PointerInputChange it) {
            return this.this$0.getCanDrag().invoke(it);
        }
    };
    private final SuspendingPointerInputModifierNode pointerInputNode = (SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new DragGestureNode$pointerInputNode$1(this, null)));

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1 */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.DragGestureNode", m210f = "Draggable.kt", m211i = {0, 0}, m212l = {561, 564}, m213m = "processDragCancel", m214n = {"this", "$this$processDragCancel"}, m215s = {"L$0", "L$1"})
    static final class C03901 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C03901(Continuation<? super C03901> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragCancel(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1 */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.DragGestureNode", m210f = "Draggable.kt", m211i = {0, 0, 0, 1, 1, 1, 1}, m212l = {543, 546, 548}, m213m = "processDragStart", m214n = {"this", "$this$processDragStart", NotificationCompat.CATEGORY_EVENT, "this", "$this$processDragStart", NotificationCompat.CATEGORY_EVENT, Route.INTERACTION}, m215s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    static final class C03911 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C03911(Continuation<? super C03911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragStart(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1 */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.DragGestureNode", m210f = "Draggable.kt", m211i = {0, 0, 0}, m212l = {553, 556}, m213m = "processDragStop", m214n = {"this", "$this$processDragStop", NotificationCompat.CATEGORY_EVENT}, m215s = {"L$0", "L$1", "L$2"})
    static final class C03921 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C03921(Continuation<? super C03921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragStop(null, null, this);
        }
    }

    public abstract Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation);

    public abstract PointerDirectionConfig getPointerDirectionConfig();

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    public /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    public /* synthetic */ void onDensityChange() {
        onCancelPointerInput();
    }

    /* JADX INFO: renamed from: onDragStarted-d-4ec7I */
    public abstract Object mo574onDragStartedd4ec7I(CoroutineScope coroutineScope, long j, Continuation<? super Unit> continuation);

    /* JADX INFO: renamed from: onDragStopped-LuvzFrg */
    public abstract Object mo575onDragStoppedLuvzFrg(CoroutineScope coroutineScope, long j, Continuation<? super Unit> continuation);

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    public /* synthetic */ void onViewConfigurationChange() {
        onCancelPointerInput();
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    public /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.CC.$default$sharePointerInputWithSiblings(this);
    }

    /* JADX INFO: renamed from: startDragImmediately */
    public abstract boolean getStartDragImmediately();

    public DragGestureNode(Function1<? super PointerInputChange, Boolean> function1, boolean enabled, MutableInteractionSource interactionSource) {
        this.canDrag = function1;
        this.enabled = enabled;
        this.interactionSource = interactionSource;
    }

    protected final Function1<PointerInputChange, Boolean> getCanDrag() {
        return this.canDrag;
    }

    protected final boolean getEnabled() {
        return this.enabled;
    }

    protected final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startListeningForEvents() {
        this.isListeningForEvents = true;
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C03931(null), 3, null);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1 */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1", m210f = "Draggable.kt", m211i = {0, 0, 1, 1, 2, 2, 3, 4, 5}, m212l = {436, 438, 440, 447, 449, 452}, m213m = "invokeSuspend", m214n = {"$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", "$this$launch", "$this$launch"}, m215s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$0"})
    static final class C03931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        C03931(Continuation<? super C03931> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03931 c03931 = DragGestureNode.this.new C03931(continuation);
            c03931.L$0 = obj;
            return c03931;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03931) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x007e  */
        /* JADX WARN: Code duplicated, block: B:27:0x008b  */
        /* JADX WARN: Code duplicated, block: B:29:0x009d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:30:0x009e  */
        /* JADX WARN: Code duplicated, block: B:32:0x00a8  */
        /* JADX WARN: Code duplicated, block: B:35:0x00b7  */
        /* JADX WARN: Code duplicated, block: B:37:0x00cf A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:38:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:42:0x00f1 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:43:0x00f2  */
        /* JADX WARN: Code duplicated, block: B:46:0x00f9 A[Catch: CancellationException -> 0x0133, TryCatch #0 {CancellationException -> 0x0133, blocks: (B:44:0x00f3, B:46:0x00f9, B:50:0x0118, B:52:0x011e), top: B:66:0x00f3 }] */
        /* JADX WARN: Code duplicated, block: B:48:0x0115 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:49:0x0116  */
        /* JADX WARN: Code duplicated, block: B:50:0x0118 A[Catch: CancellationException -> 0x0133, TryCatch #0 {CancellationException -> 0x0133, blocks: (B:44:0x00f3, B:46:0x00f9, B:50:0x0118, B:52:0x011e), top: B:66:0x00f3 }] */
        /* JADX WARN: Code duplicated, block: B:52:0x011e A[Catch: CancellationException -> 0x0133, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x0133, blocks: (B:44:0x00f3, B:46:0x00f9, B:50:0x0118, B:52:0x011e), top: B:66:0x00f3 }] */
        /* JADX WARN: Code duplicated, block: B:54:0x0130 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:63:0x014b  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v15 */
        /* JADX WARN: Type inference failed for: r10v18 */
        /* JADX WARN: Type inference failed for: r10v5, types: [T] */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v12, types: [androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1] */
        /* JADX WARN: Type inference failed for: r1v16, types: [androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1] */
        /* JADX WARN: Type inference failed for: r1v17, types: [androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1] */
        /* JADX WARN: Type inference failed for: r1v18, types: [androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1] */
        /* JADX WARN: Type inference failed for: r1v19, types: [androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1] */
        /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1] */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v3, types: [androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1] */
        /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v9, types: [androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1] */
        /* JADX WARN: Type inference failed for: r3v13, types: [androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1] */
        /* JADX WARN: Type inference failed for: r3v15 */
        /* JADX WARN: Type inference failed for: r3v18 */
        /* JADX WARN: Type inference failed for: r3v19 */
        /* JADX WARN: Type inference failed for: r3v24 */
        /* JADX WARN: Type inference failed for: r3v35 */
        /* JADX WARN: Type inference failed for: r3v9 */
        /* JADX WARN: Type inference failed for: r4v8 */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r6v9 */
        /* JADX WARN: Type inference failed for: r7v2 */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x011c -> B:23:0x0078). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x012e -> B:23:0x0078). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0148 -> B:23:0x0078). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x014b -> B:23:0x0078). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:38:0x00d0
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                Method dump skipped, instruction units count: 358
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.C03931.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: Draggable.kt */
        @Metadata(m194d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0003H\u008a@"}, m195d2 = {"<anonymous>", "", "processDelta", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1", m210f = "Draggable.kt", m211i = {0}, m212l = {443}, m213m = "invokeSuspend", m214n = {"processDelta"}, m215s = {"L$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Function1<? super DragEvent.DragDelta, ? extends Unit>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<DragEvent> $event;
            /* synthetic */ Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ DragGestureNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Ref.ObjectRef<DragEvent> objectRef, DragGestureNode dragGestureNode, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$event = objectRef;
                this.this$0 = dragGestureNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$event, this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Function1<? super DragEvent.DragDelta, ? extends Unit> function1, Continuation<? super Unit> continuation) {
                return invoke2((Function1<? super DragEvent.DragDelta, Unit>) function1, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Function1<? super DragEvent.DragDelta, Unit> function1, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(function1, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0035  */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0057 -> B:25:0x0079). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006a -> B:24:0x0071). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                AnonymousClass1 anonymousClass1;
                Function1 function1;
                T t;
                Ref.ObjectRef<DragEvent> objectRef;
                Object obj2;
                Function1 function2;
                Ref.ObjectRef<DragEvent> objectRef2;
                AnonymousClass1 anonymousClass2;
                Object obj3;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        anonymousClass1 = this;
                        function1 = (Function1) anonymousClass1.L$0;
                        if ((anonymousClass1.$event.element instanceof DragEvent.DragStopped) && !(anonymousClass1.$event.element instanceof DragEvent.DragCancelled)) {
                            DragEvent dragEvent = anonymousClass1.$event.element;
                            t = 0;
                            DragEvent.DragDelta dragDelta = dragEvent instanceof DragEvent.DragDelta ? (DragEvent.DragDelta) dragEvent : null;
                            if (dragDelta != null) {
                                function1.invoke(dragDelta);
                            }
                            objectRef = anonymousClass1.$event;
                            Channel channel = anonymousClass1.this$0.channel;
                            if (channel != null) {
                                anonymousClass1.L$0 = function1;
                                anonymousClass1.L$1 = objectRef;
                                anonymousClass1.label = 1;
                                Object objReceive = channel.receive(anonymousClass1);
                                if (objReceive == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                Object obj4 = coroutine_suspended;
                                obj2 = obj;
                                obj = objReceive;
                                function2 = function1;
                                objectRef2 = objectRef;
                                anonymousClass2 = anonymousClass1;
                                obj3 = obj4;
                                DragEvent dragEvent2 = (DragEvent) obj;
                                obj = obj2;
                                coroutine_suspended = obj3;
                                anonymousClass1 = anonymousClass2;
                                objectRef = objectRef2;
                                function1 = function2;
                                t = dragEvent2;
                            }
                            objectRef.element = t;
                            if (anonymousClass1.$event.element instanceof DragEvent.DragStopped) {
                            }
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        Ref.ObjectRef<DragEvent> objectRef3 = (Ref.ObjectRef) this.L$1;
                        Function1 function3 = (Function1) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        function2 = function3;
                        objectRef2 = objectRef3;
                        anonymousClass2 = this;
                        obj3 = coroutine_suspended;
                        obj2 = obj;
                        DragEvent dragEvent3 = (DragEvent) obj;
                        obj = obj2;
                        coroutine_suspended = obj3;
                        anonymousClass1 = anonymousClass2;
                        objectRef = objectRef2;
                        function1 = function2;
                        t = dragEvent3;
                        objectRef.element = t;
                        if (anonymousClass1.$event.element instanceof DragEvent.DragStopped) {
                            break;
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.isListeningForEvents = false;
        disposeInteractionSource();
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo427onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        this.pointerInputNode.mo427onPointerEventH0pRuoY(pointerEvent, pass, bounds);
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x008a  */
    /* JADX WARN: Code duplicated, block: B:28:0x009e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x00ba A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object processDragStart(CoroutineScope coroutineScope, DragEvent.DragStarted event, Continuation<? super Unit> continuation) {
        C03911 c03911;
        DragGestureNode dragGestureNode;
        CoroutineScope $this$processDragStart;
        MutableInteractionSource mutableInteractionSource;
        DragInteraction.Start interaction;
        MutableInteractionSource mutableInteractionSource2;
        CoroutineScope $this$processDragStart_u24lambda_u241;
        long startPoint;
        if (continuation instanceof C03911) {
            c03911 = (C03911) continuation;
            if ((c03911.label & Integer.MIN_VALUE) != 0) {
                c03911.label -= Integer.MIN_VALUE;
            } else {
                c03911 = new C03911(continuation);
            }
        } else {
            c03911 = new C03911(continuation);
        }
        C03911 c03912 = c03911;
        Object $result = c03912.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03912.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                dragGestureNode = this;
                $this$processDragStart = coroutineScope;
                DragInteraction.Start oldInteraction = dragGestureNode.dragInteraction;
                if (oldInteraction != null && (mutableInteractionSource = dragGestureNode.interactionSource) != null) {
                    DragInteraction.Cancel cancel = new DragInteraction.Cancel(oldInteraction);
                    c03912.L$0 = dragGestureNode;
                    c03912.L$1 = $this$processDragStart;
                    c03912.L$2 = event;
                    c03912.label = 1;
                    if (mutableInteractionSource.emit(cancel, c03912) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                interaction = new DragInteraction.Start();
                mutableInteractionSource2 = dragGestureNode.interactionSource;
                if (mutableInteractionSource2 != null) {
                    c03912.L$0 = dragGestureNode;
                    c03912.L$1 = $this$processDragStart;
                    c03912.L$2 = event;
                    c03912.L$3 = interaction;
                    c03912.label = 2;
                    if (mutableInteractionSource2.emit(interaction, c03912) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                dragGestureNode.dragInteraction = interaction;
                $this$processDragStart_u24lambda_u241 = $this$processDragStart;
                startPoint = event.getStartPoint();
                c03912.L$0 = null;
                c03912.L$1 = null;
                c03912.L$2 = null;
                c03912.L$3 = null;
                c03912.label = 3;
                if (dragGestureNode.mo574onDragStartedd4ec7I($this$processDragStart_u24lambda_u241, startPoint, c03912) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                event = (DragEvent.DragStarted) c03912.L$2;
                $this$processDragStart = (CoroutineScope) c03912.L$1;
                dragGestureNode = (DragGestureNode) c03912.L$0;
                ResultKt.throwOnFailure($result);
                interaction = new DragInteraction.Start();
                mutableInteractionSource2 = dragGestureNode.interactionSource;
                if (mutableInteractionSource2 != null) {
                    c03912.L$0 = dragGestureNode;
                    c03912.L$1 = $this$processDragStart;
                    c03912.L$2 = event;
                    c03912.L$3 = interaction;
                    c03912.label = 2;
                    if (mutableInteractionSource2.emit(interaction, c03912) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                dragGestureNode.dragInteraction = interaction;
                $this$processDragStart_u24lambda_u241 = $this$processDragStart;
                startPoint = event.getStartPoint();
                c03912.L$0 = null;
                c03912.L$1 = null;
                c03912.L$2 = null;
                c03912.L$3 = null;
                c03912.label = 3;
                if (dragGestureNode.mo574onDragStartedd4ec7I($this$processDragStart_u24lambda_u241, startPoint, c03912) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 2:
                interaction = (DragInteraction.Start) c03912.L$3;
                event = (DragEvent.DragStarted) c03912.L$2;
                $this$processDragStart = (CoroutineScope) c03912.L$1;
                dragGestureNode = (DragGestureNode) c03912.L$0;
                ResultKt.throwOnFailure($result);
                dragGestureNode.dragInteraction = interaction;
                $this$processDragStart_u24lambda_u241 = $this$processDragStart;
                startPoint = event.getStartPoint();
                c03912.L$0 = null;
                c03912.L$1 = null;
                c03912.L$2 = null;
                c03912.L$3 = null;
                c03912.label = 3;
                if (dragGestureNode.mo574onDragStartedd4ec7I($this$processDragStart_u24lambda_u241, startPoint, c03912) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x0086 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x0087  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object processDragStop(CoroutineScope coroutineScope, DragEvent.DragStopped event, Continuation<? super Unit> continuation) {
        C03921 c03921;
        DragGestureNode dragGestureNode;
        CoroutineScope $this$processDragStop;
        int i;
        CoroutineScope $this$processDragStop_u24lambda_u243;
        long velocity;
        if (continuation instanceof C03921) {
            c03921 = (C03921) continuation;
            if ((c03921.label & Integer.MIN_VALUE) != 0) {
                c03921.label -= Integer.MIN_VALUE;
            } else {
                c03921 = new C03921(continuation);
            }
        } else {
            c03921 = new C03921(continuation);
        }
        C03921 c03922 = c03921;
        Object $result = c03922.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03922.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                dragGestureNode = this;
                $this$processDragStop = coroutineScope;
                DragInteraction.Start interaction = dragGestureNode.dragInteraction;
                if (interaction != null) {
                    MutableInteractionSource mutableInteractionSource = dragGestureNode.interactionSource;
                    if (mutableInteractionSource != null) {
                        DragInteraction.Stop stop = new DragInteraction.Stop(interaction);
                        c03922.L$0 = dragGestureNode;
                        c03922.L$1 = $this$processDragStop;
                        c03922.L$2 = event;
                        c03922.label = 1;
                        if (mutableInteractionSource.emit(stop, c03922) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i = 0;
                    }
                    dragGestureNode.dragInteraction = null;
                }
                $this$processDragStop_u24lambda_u243 = $this$processDragStop;
                velocity = event.getVelocity();
                c03922.L$0 = null;
                c03922.L$1 = null;
                c03922.L$2 = null;
                c03922.label = 2;
                if (dragGestureNode.mo575onDragStoppedLuvzFrg($this$processDragStop_u24lambda_u243, velocity, c03922) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                i = 0;
                event = (DragEvent.DragStopped) c03922.L$2;
                $this$processDragStop = (CoroutineScope) c03922.L$1;
                dragGestureNode = (DragGestureNode) c03922.L$0;
                ResultKt.throwOnFailure($result);
                dragGestureNode.dragInteraction = null;
                $this$processDragStop_u24lambda_u243 = $this$processDragStop;
                velocity = event.getVelocity();
                c03922.L$0 = null;
                c03922.L$1 = null;
                c03922.L$2 = null;
                c03922.label = 2;
                if (dragGestureNode.mo575onDragStoppedLuvzFrg($this$processDragStop_u24lambda_u243, velocity, c03922) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x0080 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x0081  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object processDragCancel(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        C03901 c03901;
        DragGestureNode dragGestureNode;
        CoroutineScope $this$processDragCancel;
        int i;
        CoroutineScope $this$processDragCancel_u24lambda_u245;
        long jM7053getZero9UxMQ8M;
        if (continuation instanceof C03901) {
            c03901 = (C03901) continuation;
            if ((c03901.label & Integer.MIN_VALUE) != 0) {
                c03901.label -= Integer.MIN_VALUE;
            } else {
                c03901 = new C03901(continuation);
            }
        } else {
            c03901 = new C03901(continuation);
        }
        C03901 c03902 = c03901;
        Object $result = c03902.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03902.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                dragGestureNode = this;
                $this$processDragCancel = coroutineScope;
                DragInteraction.Start interaction = dragGestureNode.dragInteraction;
                if (interaction != null) {
                    MutableInteractionSource mutableInteractionSource = dragGestureNode.interactionSource;
                    if (mutableInteractionSource != null) {
                        DragInteraction.Cancel cancel = new DragInteraction.Cancel(interaction);
                        c03902.L$0 = dragGestureNode;
                        c03902.L$1 = $this$processDragCancel;
                        c03902.label = 1;
                        if (mutableInteractionSource.emit(cancel, c03902) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i = 0;
                    }
                    dragGestureNode.dragInteraction = null;
                }
                $this$processDragCancel_u24lambda_u245 = $this$processDragCancel;
                jM7053getZero9UxMQ8M = Velocity.INSTANCE.m7053getZero9UxMQ8M();
                c03902.L$0 = null;
                c03902.L$1 = null;
                c03902.label = 2;
                if (dragGestureNode.mo575onDragStoppedLuvzFrg($this$processDragCancel_u24lambda_u245, jM7053getZero9UxMQ8M, c03902) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                i = 0;
                $this$processDragCancel = (CoroutineScope) c03902.L$1;
                dragGestureNode = (DragGestureNode) c03902.L$0;
                ResultKt.throwOnFailure($result);
                dragGestureNode.dragInteraction = null;
                $this$processDragCancel_u24lambda_u245 = $this$processDragCancel;
                jM7053getZero9UxMQ8M = Velocity.INSTANCE.m7053getZero9UxMQ8M();
                c03902.L$0 = null;
                c03902.L$1 = null;
                c03902.label = 2;
                if (dragGestureNode.mo575onDragStoppedLuvzFrg($this$processDragCancel_u24lambda_u245, jM7053getZero9UxMQ8M, c03902) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void disposeInteractionSource() {
        DragInteraction.Start interaction = this.dragInteraction;
        if (interaction != null) {
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                mutableInteractionSource.tryEmit(new DragInteraction.Cancel(interaction));
            }
            this.dragInteraction = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void update$default(DragGestureNode dragGestureNode, Function1 function1, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
        }
        if ((i & 1) != 0) {
            function1 = dragGestureNode.canDrag;
        }
        if ((i & 2) != 0) {
            z = dragGestureNode.enabled;
        }
        if ((i & 4) != 0) {
            mutableInteractionSource = dragGestureNode.interactionSource;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        dragGestureNode.update(function1, z, mutableInteractionSource, z2);
    }

    public final void update(Function1<? super PointerInputChange, Boolean> canDrag, boolean enabled, MutableInteractionSource interactionSource, boolean isResetPointerInputHandling) {
        boolean resetPointerInputHandling = isResetPointerInputHandling;
        this.canDrag = canDrag;
        if (this.enabled != enabled) {
            this.enabled = enabled;
            if (!enabled) {
                disposeInteractionSource();
            }
            resetPointerInputHandling = true;
        }
        if (!Intrinsics.areEqual(this.interactionSource, interactionSource)) {
            disposeInteractionSource();
            this.interactionSource = interactionSource;
        }
        if (resetPointerInputHandling) {
            this.pointerInputNode.resetPointerInputHandler();
        }
    }
}
