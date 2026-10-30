package androidx.compose.p001ui.input.pointer;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: renamed from: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1 */
/* JADX INFO: compiled from: SuspendingPointerInputFilter.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1", m210f = "SuspendingPointerInputFilter.kt", m211i = {}, m212l = {735, 736}, m213m = "invokeSuspend", m214n = {}, m215s = {})
final class C1772xf3489d20 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $timeMillis;
    int label;
    final /* synthetic */ SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine<R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1772xf3489d20(long j, SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine<R> pointerEventHandlerCoroutine, Continuation<? super C1772xf3489d20> continuation) {
        super(2, continuation);
        this.$timeMillis = j;
        this.this$0 = pointerEventHandlerCoroutine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C1772xf3489d20(this.$timeMillis, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C1772xf3489d20) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x003e  */
    /* JADX WARN: Code duplicated, block: B:17:0x0047  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        C1772xf3489d20 c1772xf3489d20;
        C1772xf3489d20 c1772xf3489d21;
        CancellableContinuation cancellableContinuation;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c1772xf3489d20 = this;
                c1772xf3489d20.label = 1;
                if (DelayKt.delay(c1772xf3489d20.$timeMillis - 1, c1772xf3489d20) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                c1772xf3489d20.label = 2;
                if (DelayKt.delay(1L, c1772xf3489d20) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                c1772xf3489d21 = c1772xf3489d20;
                cancellableContinuation = ((SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) c1772xf3489d21.this$0).pointerAwaiter;
                if (cancellableContinuation != null) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7693constructorimpl(ResultKt.createFailure(new PointerEventTimeoutCancellationException(c1772xf3489d21.$timeMillis))));
                }
                return Unit.INSTANCE;
            case 1:
                c1772xf3489d20 = this;
                ResultKt.throwOnFailure($result);
                c1772xf3489d20.label = 2;
                if (DelayKt.delay(1L, c1772xf3489d20) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                c1772xf3489d21 = c1772xf3489d20;
                cancellableContinuation = ((SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) c1772xf3489d21.this$0).pointerAwaiter;
                if (cancellableContinuation != null) {
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7693constructorimpl(ResultKt.createFailure(new PointerEventTimeoutCancellationException(c1772xf3489d21.$timeMillis))));
                }
                return Unit.INSTANCE;
            case 2:
                c1772xf3489d21 = this;
                ResultKt.throwOnFailure($result);
                cancellableContinuation = ((SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) c1772xf3489d21.this$0).pointerAwaiter;
                if (cancellableContinuation != null) {
                    Result.Companion companion3 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7693constructorimpl(ResultKt.createFailure(new PointerEventTimeoutCancellationException(c1772xf3489d21.$timeMillis))));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
