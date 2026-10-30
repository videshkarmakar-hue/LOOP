package androidx.compose.p001ui.platform;

import android.view.View;
import androidx.compose.p001ui.SessionMutex;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PlatformTextInputModifierNode.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eR\u0012\u0010\u0002\u001a\u00020\u0003X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, m195d2 = {"androidx/compose/ui/platform/ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "startInputMethod", "", "request", "Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;", "(Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1 implements PlatformTextInputSessionScope {
    private final /* synthetic */ PlatformTextInputSessionScope $$delegate_0;
    final /* synthetic */ AtomicReference<SessionMutex.Session<T>> $inputMethodMutex;
    final /* synthetic */ PlatformTextInputSessionScope $parentSession;
    final /* synthetic */ ChainedPlatformTextInputInterceptor this$0;

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // androidx.compose.p001ui.platform.PlatformTextInputSession
    public View getView() {
        return this.$$delegate_0.getView();
    }

    ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1(PlatformTextInputSessionScope $parentSession, AtomicReference<SessionMutex.Session<T>> atomicReference, ChainedPlatformTextInputInterceptor $receiver) {
        this.$parentSession = $parentSession;
        this.$inputMethodMutex = atomicReference;
        this.this$0 = $receiver;
        this.$$delegate_0 = $parentSession;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.p001ui.platform.PlatformTextInputSession
    public Object startInputMethod(PlatformTextInputMethodRequest request, Continuation<?> continuation) {
        C1868x61f42b4d c1868x61f42b4d;
        if (continuation instanceof C1868x61f42b4d) {
            c1868x61f42b4d = (C1868x61f42b4d) continuation;
            if ((c1868x61f42b4d.label & Integer.MIN_VALUE) != 0) {
                c1868x61f42b4d.label -= Integer.MIN_VALUE;
            } else {
                c1868x61f42b4d = new C1868x61f42b4d(this, continuation);
            }
        } else {
            c1868x61f42b4d = new C1868x61f42b4d(this, continuation);
        }
        C1868x61f42b4d c1868x61f42b4d2 = c1868x61f42b4d;
        Object $result = c1868x61f42b4d2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c1868x61f42b4d2.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AtomicReference<SessionMutex.Session<T>> atomicReference = this.$inputMethodMutex;
                C1869x61f42b4e c1869x61f42b4e = new Function1<CoroutineScope, Unit>() { // from class: androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1$startInputMethod$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(CoroutineScope coroutineScope) {
                        invoke2(coroutineScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(CoroutineScope it) {
                    }
                };
                C1870x61f42b4f c1870x61f42b4f = new C1870x61f42b4f(this.this$0, request, this.$parentSession, null);
                c1868x61f42b4d2.label = 1;
                if (SessionMutex.m3918withSessionCancellingPreviousimpl(atomicReference, c1869x61f42b4e, c1870x61f42b4f, c1868x61f42b4d2) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }
}
