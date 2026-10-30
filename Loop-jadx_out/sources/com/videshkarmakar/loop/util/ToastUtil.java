package com.videshkarmakar.loop.util;

import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.App;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: TextUtil.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, m195d2 = {"Lcom/videshkarmakar/loop/util/ToastUtil;", "", "()V", "makeToast", "", "stringId", "", "text", "", "makeToastSuspend", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ToastUtil {
    public static final int $stable = 0;
    public static final ToastUtil INSTANCE = new ToastUtil();

    private ToastUtil() {
    }

    public final void makeToast(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Toast.makeText(App.INSTANCE.getContext().getApplicationContext(), text, 0).show();
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.util.ToastUtil$makeToastSuspend$1 */
    /* JADX INFO: compiled from: TextUtil.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.util.ToastUtil$makeToastSuspend$1", m210f = "TextUtil.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C40541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $text;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C40541(String str, Continuation<? super C40541> continuation) {
            super(2, continuation);
            this.$text = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C40541(this.$text, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C40541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    ToastUtil.INSTANCE.makeToast(this.$text);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void makeToastSuspend(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        BuildersKt__Builders_commonKt.launch$default(App.INSTANCE.getApplicationScope(), Dispatchers.getMain(), null, new C40541(text, null), 2, null);
    }

    public final void makeToast(int stringId) {
        Toast.makeText(App.INSTANCE.getContext().getApplicationContext(), App.INSTANCE.getContext().getString(stringId), 0).show();
    }
}
