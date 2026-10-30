package com.videshkarmakar.loop.p006ui.page;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.UpdateUtil;
import com.yausername.youtubedl_android.YoutubeDL;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HomeEntry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "Lcom/yausername/youtubedl_android/YoutubeDL$UpdateStatus;", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$3$1$1$1", m210f = "HomeEntry.kt", m211i = {}, m212l = {294}, m213m = "invokeSuspend", m214n = {}, m215s = {})
final class HomeEntryKt$HomeEntry$2$3$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super YoutubeDL.UpdateStatus>, Object> {
    int label;

    HomeEntryKt$HomeEntry$2$3$1$1$1(Continuation<? super HomeEntryKt$HomeEntry$2$3$1$1$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeEntryKt$HomeEntry$2$3$1$1$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super YoutubeDL.UpdateStatus> continuation) {
        return ((HomeEntryKt$HomeEntry$2$3$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object objUpdateYtDlp = UpdateUtil.INSTANCE.updateYtDlp(this);
                return objUpdateYtDlp == coroutine_suspended ? coroutine_suspended : objUpdateYtDlp;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
