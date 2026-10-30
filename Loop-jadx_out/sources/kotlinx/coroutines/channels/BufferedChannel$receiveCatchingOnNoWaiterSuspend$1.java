package kotlinx.coroutines.channels;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: BufferedChannel.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "kotlinx.coroutines.channels.BufferedChannel", m210f = "BufferedChannel.kt", m211i = {0, 0, 0, 0}, m212l = {3056}, m213m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk", m214n = {"this", "segment", "index", "r"}, m215s = {"L$0", "L$1", "I$0", "J$0"})
final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel<E> bufferedChannel, Continuation<? super BufferedChannel$receiveCatchingOnNoWaiterSuspend$1> continuation) {
        super(continuation);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM9198receiveCatchingOnNoWaiterSuspendGKJJFZk = this.this$0.m9198receiveCatchingOnNoWaiterSuspendGKJJFZk(null, 0, 0L, this);
        return objM9198receiveCatchingOnNoWaiterSuspendGKJJFZk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM9198receiveCatchingOnNoWaiterSuspendGKJJFZk : ChannelResult.m9205boximpl(objM9198receiveCatchingOnNoWaiterSuspendGKJJFZk);
    }
}
