package androidx.compose.foundation.gestures;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.foundation.gestures.ScrollingLogic$dispatchUserInputDelta$2", m210f = "Scrollable.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
final class ScrollingLogic$dispatchUserInputDelta$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delta;
    final /* synthetic */ int $source;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollingLogic$dispatchUserInputDelta$2(ScrollingLogic scrollingLogic, long j, int i, Continuation<? super ScrollingLogic$dispatchUserInputDelta$2> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
        this.$delta = j;
        this.$source = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic$dispatchUserInputDelta$2 scrollingLogic$dispatchUserInputDelta$2 = new ScrollingLogic$dispatchUserInputDelta$2(this.this$0, this.$delta, this.$source, continuation);
        scrollingLogic$dispatchUserInputDelta$2.L$0 = obj;
        return scrollingLogic$dispatchUserInputDelta$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((ScrollingLogic$dispatchUserInputDelta$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                ScrollScope $this$scroll = (ScrollScope) this.L$0;
                this.this$0.m673dispatchScroll3eAAhYA($this$scroll, this.$delta, this.$source);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
