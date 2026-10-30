package com.videshkarmakar.loop.ui.page.videolist;

import android.content.Context;
import androidx.compose.material3.SnackbarHostState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: VideoListPage.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$20$1$1$1", f = "VideoListPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VideoListPageKt$VideoListPage$20$1$1$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ SnackbarHostState $hostState;
    final /* synthetic */ VideoListViewModel $viewModel;
    /* synthetic */ int I$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoListPageKt$VideoListPage$20$1$1$1(VideoListViewModel videoListViewModel, SnackbarHostState snackbarHostState, Context context, Continuation<? super VideoListPageKt$VideoListPage$20$1$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = videoListViewModel;
        this.$hostState = snackbarHostState;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        VideoListPageKt$VideoListPage$20$1$1$1 videoListPageKt$VideoListPage$20$1$1$1 = new VideoListPageKt$VideoListPage$20$1$1$1(this.$viewModel, this.$hostState, this.$context, continuation);
        videoListPageKt$VideoListPage$20$1$1$1.I$0 = ((Number) obj).intValue();
        return videoListPageKt$VideoListPage$20$1$1$1;
    }

    public final Object invoke(int i, Continuation<? super Unit> continuation) {
        return ((VideoListPageKt$VideoListPage$20$1$1$1) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Unit> continuation) {
        return invoke(num.intValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                int it = this.I$0;
                this.$viewModel.showImportedSnackbar(this.$hostState, this.$context, it);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
