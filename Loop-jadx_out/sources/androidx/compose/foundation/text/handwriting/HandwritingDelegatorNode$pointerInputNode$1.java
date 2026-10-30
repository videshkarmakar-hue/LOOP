package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: HandwritingDelegator.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.foundation.text.handwriting.HandwritingDelegatorNode$pointerInputNode$1", m210f = "HandwritingDelegator.android.kt", m211i = {}, m212l = {HttpStatusCodesKt.HTTP_EARLY_HINTS}, m213m = "invokeSuspend", m214n = {}, m215s = {})
final class HandwritingDelegatorNode$pointerInputNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HandwritingDelegatorNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandwritingDelegatorNode$pointerInputNode$1(HandwritingDelegatorNode handwritingDelegatorNode, Continuation<? super HandwritingDelegatorNode$pointerInputNode$1> continuation) {
        super(2, continuation);
        this.this$0 = handwritingDelegatorNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HandwritingDelegatorNode$pointerInputNode$1 handwritingDelegatorNode$pointerInputNode$1 = new HandwritingDelegatorNode$pointerInputNode$1(this.this$0, continuation);
        handwritingDelegatorNode$pointerInputNode$1.L$0 = obj;
        return handwritingDelegatorNode$pointerInputNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((HandwritingDelegatorNode$pointerInputNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$detectStylusHandwriting$iv = (PointerInputScope) this.L$0;
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture($this$detectStylusHandwriting$iv, new C0784x912dbd64(null, this.this$0), this) == coroutine_suspended) {
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
