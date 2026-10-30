package androidx.compose.foundation;

import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.input.pointer.PointerEvent;
import androidx.compose.p001ui.input.pointer.PointerEventPass;
import androidx.compose.p001ui.input.pointer.PointerEventType;
import androidx.compose.p001ui.node.PointerInputModifierNode;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.p006ui.common.Route;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: compiled from: Hoverable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\nJ\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J*\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001a\u00020\tH\u0002J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, m195d2 = {"Landroidx/compose/foundation/HoverableNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "hoverInteraction", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "emitEnter", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitExit", "onCancelPointerInput", "onDetach", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "tryEmitExit", "updateInteractionSource", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class HoverableNode extends Modifier.Node implements PointerInputModifierNode {
    private HoverInteraction.Enter hoverInteraction;
    private MutableInteractionSource interactionSource;

    /* JADX INFO: renamed from: androidx.compose.foundation.HoverableNode$emitEnter$1 */
    /* JADX INFO: compiled from: Hoverable.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.HoverableNode", m210f = "Hoverable.kt", m211i = {0, 0}, m212l = {111}, m213m = "emitEnter", m214n = {"this", Route.INTERACTION}, m215s = {"L$0", "L$1"})
    static final class C03231 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C03231(Continuation<? super C03231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HoverableNode.this.emitEnter(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.HoverableNode$emitExit$1 */
    /* JADX INFO: compiled from: Hoverable.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.HoverableNode", m210f = "Hoverable.kt", m211i = {0}, m212l = {119}, m213m = "emitExit", m214n = {"this"}, m215s = {"L$0"})
    static final class C03241 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C03241(Continuation<? super C03241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HoverableNode.this.emitExit(this);
        }
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    public /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    public /* synthetic */ void onDensityChange() {
        onCancelPointerInput();
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    public /* synthetic */ void onViewConfigurationChange() {
        onCancelPointerInput();
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    public /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.CC.$default$sharePointerInputWithSiblings(this);
    }

    public HoverableNode(MutableInteractionSource interactionSource) {
        this.interactionSource = interactionSource;
    }

    public final void updateInteractionSource(MutableInteractionSource interactionSource) {
        if (!Intrinsics.areEqual(this.interactionSource, interactionSource)) {
            tryEmitExit();
            this.interactionSource = interactionSource;
        }
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo427onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        if (pass == PointerEventPass.Main) {
            int type = pointerEvent.getType();
            if (PointerEventType.m5459equalsimpl0(type, PointerEventType.INSTANCE.m5463getEnter7fucELk())) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new HoverableNode$onPointerEvent$1(this, null), 3, null);
            } else if (PointerEventType.m5459equalsimpl0(type, PointerEventType.INSTANCE.m5464getExit7fucELk())) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new HoverableNode$onPointerEvent$2(this, null), 3, null);
            }
        }
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        tryEmitExit();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        tryEmitExit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object emitEnter(Continuation<? super Unit> continuation) {
        C03231 c03231;
        HoverableNode hoverableNode;
        HoverInteraction.Enter interaction;
        if (continuation instanceof C03231) {
            c03231 = (C03231) continuation;
            if ((c03231.label & Integer.MIN_VALUE) != 0) {
                c03231.label -= Integer.MIN_VALUE;
            } else {
                c03231 = new C03231(continuation);
            }
        } else {
            c03231 = new C03231(continuation);
        }
        C03231 c03232 = c03231;
        Object $result = c03232.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03232.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                hoverableNode = this;
                if (hoverableNode.hoverInteraction == null) {
                    HoverInteraction.Enter interaction2 = new HoverInteraction.Enter();
                    c03232.L$0 = hoverableNode;
                    c03232.L$1 = interaction2;
                    c03232.label = 1;
                    if (hoverableNode.interactionSource.emit(interaction2, c03232) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    interaction = interaction2;
                    hoverableNode.hoverInteraction = interaction;
                }
                return Unit.INSTANCE;
            case 1:
                interaction = (HoverInteraction.Enter) c03232.L$1;
                hoverableNode = (HoverableNode) c03232.L$0;
                ResultKt.throwOnFailure($result);
                hoverableNode.hoverInteraction = interaction;
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object emitExit(Continuation<? super Unit> continuation) {
        C03241 c03241;
        HoverableNode hoverableNode;
        if (continuation instanceof C03241) {
            c03241 = (C03241) continuation;
            if ((c03241.label & Integer.MIN_VALUE) != 0) {
                c03241.label -= Integer.MIN_VALUE;
            } else {
                c03241 = new C03241(continuation);
            }
        } else {
            c03241 = new C03241(continuation);
        }
        C03241 c03242 = c03241;
        Object $result = c03242.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03242.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                hoverableNode = this;
                HoverInteraction.Enter oldValue = hoverableNode.hoverInteraction;
                if (oldValue != null) {
                    HoverInteraction.Exit interaction = new HoverInteraction.Exit(oldValue);
                    c03242.L$0 = hoverableNode;
                    c03242.label = 1;
                    if (hoverableNode.interactionSource.emit(interaction, c03242) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    hoverableNode.hoverInteraction = null;
                }
                return Unit.INSTANCE;
            case 1:
                hoverableNode = (HoverableNode) c03242.L$0;
                ResultKt.throwOnFailure($result);
                hoverableNode.hoverInteraction = null;
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void tryEmitExit() {
        HoverInteraction.Enter oldValue = this.hoverInteraction;
        if (oldValue != null) {
            HoverInteraction.Exit interaction = new HoverInteraction.Exit(oldValue);
            this.interactionSource.tryEmit(interaction);
            this.hoverInteraction = null;
        }
    }
}
