package com.videshkarmakar.loop.ui.page.videolist;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.platform.SoftwareKeyboardController;
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

/* JADX INFO: compiled from: VideoListPage.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$3$1", f = "VideoListPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VideoListPageKt$VideoListPage$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $isSelectEnabled$delegate;
    final /* synthetic */ MutableState<Boolean> $showBottomSheet$delegate;
    final /* synthetic */ SoftwareKeyboardController $softKeyboardController;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoListPageKt$VideoListPage$3$1(SoftwareKeyboardController softwareKeyboardController, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super VideoListPageKt$VideoListPage$3$1> continuation) {
        super(2, continuation);
        this.$softKeyboardController = softwareKeyboardController;
        this.$showBottomSheet$delegate = mutableState;
        this.$isSelectEnabled$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoListPageKt$VideoListPage$3$1(this.$softKeyboardController, this.$showBottomSheet$delegate, this.$isSelectEnabled$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoListPageKt$VideoListPage$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SoftwareKeyboardController softwareKeyboardController;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if ((VideoListPageKt.VideoListPage$lambda$39(this.$showBottomSheet$delegate) || VideoListPageKt.VideoListPage$lambda$10(this.$isSelectEnabled$delegate)) && (softwareKeyboardController = this.$softKeyboardController) != null) {
                    softwareKeyboardController.hide();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
