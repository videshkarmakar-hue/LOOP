package com.videshkarmakar.loop.ui.page.videolist;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.database.objects.DownloadedVideoInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: VideoListViewModel.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/videshkarmakar/loop/database/objects/DownloadedVideoInfo;", "list", "state", "Lcom/videshkarmakar/loop/ui/page/videolist/VideoListViewModel$VideoListViewState;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$searchedVideoListFlow$1", f = "VideoListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VideoListViewModel$searchedVideoListFlow$1 extends SuspendLambda implements Function3<List<? extends DownloadedVideoInfo>, VideoListViewModel.VideoListViewState, Continuation<? super List<? extends DownloadedVideoInfo>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    VideoListViewModel$searchedVideoListFlow$1(Continuation<? super VideoListViewModel$searchedVideoListFlow$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(List<? extends DownloadedVideoInfo> list, VideoListViewModel.VideoListViewState videoListViewState, Continuation<? super List<? extends DownloadedVideoInfo>> continuation) {
        return invoke2((List<DownloadedVideoInfo>) list, videoListViewState, (Continuation<? super List<DownloadedVideoInfo>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<DownloadedVideoInfo> list, VideoListViewModel.VideoListViewState videoListViewState, Continuation<? super List<DownloadedVideoInfo>> continuation) {
        VideoListViewModel$searchedVideoListFlow$1 videoListViewModel$searchedVideoListFlow$1 = new VideoListViewModel$searchedVideoListFlow$1(continuation);
        videoListViewModel$searchedVideoListFlow$1.L$0 = list;
        videoListViewModel$searchedVideoListFlow$1.L$1 = videoListViewState;
        return videoListViewModel$searchedVideoListFlow$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Iterable list = (List) this.L$0;
                VideoListViewModel.VideoListViewState state = (VideoListViewModel.VideoListViewState) this.L$1;
                if (!state.isSearching() || StringsKt.isBlank(state.getSearchText())) {
                    return list;
                }
                Iterable $this$filterTo$iv$iv = list;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filterTo$iv$iv) {
                    DownloadedVideoInfo $this$invokeSuspend_u24lambda_u242_u24lambda_u241_u24lambda_u240 = (DownloadedVideoInfo) element$iv$iv;
                    String text = state.getSearchText();
                    boolean z = true;
                    if (!StringsKt.contains((CharSequence) $this$invokeSuspend_u24lambda_u242_u24lambda_u241_u24lambda_u240.getVideoTitle(), (CharSequence) text, true) && !StringsKt.contains((CharSequence) $this$invokeSuspend_u24lambda_u242_u24lambda_u241_u24lambda_u240.getVideoAuthor(), (CharSequence) text, true) && !StringsKt.contains((CharSequence) $this$invokeSuspend_u24lambda_u242_u24lambda_u241_u24lambda_u240.getExtractor(), (CharSequence) text, true) && !StringsKt.contains((CharSequence) $this$invokeSuspend_u24lambda_u242_u24lambda_u241_u24lambda_u240.getVideoPath(), (CharSequence) text, true)) {
                        z = false;
                    }
                    if (z) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                return (List) destination$iv$iv;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
