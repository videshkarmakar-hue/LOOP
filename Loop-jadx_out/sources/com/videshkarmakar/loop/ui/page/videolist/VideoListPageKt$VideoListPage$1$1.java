package com.videshkarmakar.loop.ui.page.videolist;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
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
import kotlinx.coroutines.DelayKt;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: VideoListPage.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$1$1", f = "VideoListPage.kt", i = {}, l = {HttpStatusCodesKt.HTTP_IM_USED}, m = "invokeSuspend", n = {}, s = {})
final class VideoListPageKt$VideoListPage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $isSelectEnabled$delegate;
    final /* synthetic */ SnapshotStateList<Integer> $selectedItemIds;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoListPageKt$VideoListPage$1$1(SnapshotStateList<Integer> snapshotStateList, MutableState<Boolean> mutableState, Continuation<? super VideoListPageKt$VideoListPage$1$1> continuation) {
        super(2, continuation);
        this.$selectedItemIds = snapshotStateList;
        this.$isSelectEnabled$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoListPageKt$VideoListPage$1$1(this.$selectedItemIds, this.$isSelectEnabled$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoListPageKt$VideoListPage$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        VideoListPageKt$VideoListPage$1$1 videoListPageKt$VideoListPage$1$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!VideoListPageKt.VideoListPage$lambda$10(this.$isSelectEnabled$delegate)) {
                    this.label = 1;
                    if (DelayKt.delay(200L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    videoListPageKt$VideoListPage$1$1 = this;
                    videoListPageKt$VideoListPage$1$1.$selectedItemIds.clear();
                }
                return Unit.INSTANCE;
            case 1:
                videoListPageKt$VideoListPage$1$1 = this;
                ResultKt.throwOnFailure($result);
                videoListPageKt$VideoListPage$1$1.$selectedItemIds.clear();
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
