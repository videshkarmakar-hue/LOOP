package androidx.compose.foundation.gestures;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AnchoredDraggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.foundation.gestures.AnchoredDraggableOverscrollNode", m210f = "AnchoredDraggable.kt", m211i = {}, m212l = {221, 223}, m213m = "onDragStopped-LuvzFrg", m214n = {}, m215s = {})
final class AnchoredDraggableOverscrollNode$onDragStopped$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AnchoredDraggableOverscrollNode<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnchoredDraggableOverscrollNode$onDragStopped$1(AnchoredDraggableOverscrollNode<T> anchoredDraggableOverscrollNode, Continuation<? super AnchoredDraggableOverscrollNode$onDragStopped$1> continuation) {
        super(continuation);
        this.this$0 = anchoredDraggableOverscrollNode;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo575onDragStoppedLuvzFrg(null, 0L, this);
    }
}
