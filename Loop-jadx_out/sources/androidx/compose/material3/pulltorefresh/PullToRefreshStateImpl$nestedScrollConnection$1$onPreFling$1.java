package androidx.compose.material3.pulltorefresh;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: PullToRefresh.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl$nestedScrollConnection$1", m210f = "PullToRefresh.kt", m211i = {}, m212l = {341}, m213m = "onPreFling-QWom1Mo", m214n = {}, m215s = {})
final class PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1 extends ContinuationImpl {
    float F$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PullToRefreshStateImpl$nestedScrollConnection$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1(PullToRefreshStateImpl$nestedScrollConnection$1 pullToRefreshStateImpl$nestedScrollConnection$1, Continuation<? super PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1> continuation) {
        super(continuation);
        this.this$0 = pullToRefreshStateImpl$nestedScrollConnection$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo669onPreFlingQWom1Mo(0L, this);
    }
}
