package androidx.compose.p001ui.platform;

import android.view.View;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.Recomposer;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: androidx.compose.ui.platform.WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1 */
/* JADX INFO: compiled from: WindowRecomposer.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.ui.platform.WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1", m210f = "WindowRecomposer.android.kt", m211i = {}, m212l = {235}, m213m = "invokeSuspend", m214n = {}, m215s = {})
final class C1896xbfd085b3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Recomposer $newRecomposer;
    final /* synthetic */ View $rootView;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1896xbfd085b3(Recomposer recomposer, View view, Continuation<? super C1896xbfd085b3> continuation) {
        super(2, continuation);
        this.$newRecomposer = recomposer;
        this.$rootView = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C1896xbfd085b3(this.$newRecomposer, this.$rootView, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C1896xbfd085b3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0038  */
    /* JADX WARN: Code duplicated, block: B:25:0x004f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) throws Throwable {
        Throwable th;
        C1896xbfd085b3 c1896xbfd085b3;
        CompositionContext viewTagRecomposer;
        CompositionContext viewTagRecomposer2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    this.label = 1;
                    if (this.$newRecomposer.join(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c1896xbfd085b3 = this;
                    viewTagRecomposer2 = WindowRecomposer_androidKt.getCompositionContext(c1896xbfd085b3.$rootView);
                    if (viewTagRecomposer2 == c1896xbfd085b3.$newRecomposer) {
                        WindowRecomposer_androidKt.setCompositionContext(c1896xbfd085b3.$rootView, null);
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    c1896xbfd085b3 = this;
                    viewTagRecomposer = WindowRecomposer_androidKt.getCompositionContext(c1896xbfd085b3.$rootView);
                    if (viewTagRecomposer == c1896xbfd085b3.$newRecomposer) {
                        WindowRecomposer_androidKt.setCompositionContext(c1896xbfd085b3.$rootView, null);
                    }
                    throw th;
                }
            case 1:
                c1896xbfd085b3 = this;
                try {
                    ResultKt.throwOnFailure($result);
                    viewTagRecomposer2 = WindowRecomposer_androidKt.getCompositionContext(c1896xbfd085b3.$rootView);
                    if (viewTagRecomposer2 == c1896xbfd085b3.$newRecomposer) {
                        WindowRecomposer_androidKt.setCompositionContext(c1896xbfd085b3.$rootView, null);
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    viewTagRecomposer = WindowRecomposer_androidKt.getCompositionContext(c1896xbfd085b3.$rootView);
                    if (viewTagRecomposer == c1896xbfd085b3.$newRecomposer) {
                        WindowRecomposer_androidKt.setCompositionContext(c1896xbfd085b3.$rootView, null);
                    }
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
