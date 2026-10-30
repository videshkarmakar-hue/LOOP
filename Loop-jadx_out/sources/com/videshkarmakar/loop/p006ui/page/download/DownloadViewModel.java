package com.videshkarmakar.loop.p006ui.page.download;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.videshkarmakar.loop.App;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.Downloader;
import com.videshkarmakar.loop.util.DownloadUtil;
import com.videshkarmakar.loop.util.PlaylistResult;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import com.videshkarmakar.loop.util.ToastUtil;
import com.videshkarmakar.loop.util.VideoInfo;
import com.videshkarmakar.loop.util.YoutubeDLInfo;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: DownloadViewModel.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(m194d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000fJ\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u000fJ\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u001eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006!"}, m195d2 = {"Lcom/videshkarmakar/loop/ui/page/download/DownloadViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "mutableViewStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/videshkarmakar/loop/ui/page/download/DownloadViewModel$ViewState;", "videoInfoFlow", "Lcom/videshkarmakar/loop/util/VideoInfo;", "getVideoInfoFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "viewStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getViewStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "fetchInfoForFormatSelection", "", "url", "", "hideFormatPage", "hidePlaylistDialog", "onShareIntentConsumed", "parsePlaylistInfo", "showFormatSelectionPageOrDownload", "info", "showPlaylistPage", "playlistResult", "Lcom/videshkarmakar/loop/util/PlaylistResult;", "startDownloadVideo", "updateUrl", "isUrlSharingTriggered", "", "Companion", "ViewState", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DownloadViewModel extends ViewModel {
    private static final String TAG = "DownloadViewModel";
    private final MutableStateFlow<ViewState> mutableViewStateFlow;
    private final MutableStateFlow<VideoInfo> videoInfoFlow;
    private final StateFlow<ViewState> viewStateFlow;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public DownloadViewModel() {
        String str = null;
        this.mutableViewStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, str, false, false, 15, null));
        this.viewStateFlow = FlowKt.asStateFlow(this.mutableViewStateFlow);
        Object[] objArr = 0 == true ? 1 : 0;
        this.videoInfoFlow = StateFlowKt.MutableStateFlow(new VideoInfo(str, (String) null, (List) null, (String) null, (String) objArr, (String) null, (String) null, (Map) null, (Map) null, (Double) null, (Long) null, (String) null, (List) null, (String) null, (Integer) null, (List) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (String) null, (Double) null, (String) null, (String) null, (Double) null, (String) null, (Double) null, (Integer) null, (Integer) null, (List) null, (List) null, (String) null, (String) null, -1, 4194303, (DefaultConstructorMarker) null));
    }

    public final StateFlow<ViewState> getViewStateFlow() {
        return this.viewStateFlow;
    }

    public final MutableStateFlow<VideoInfo> getVideoInfoFlow() {
        return this.videoInfoFlow;
    }

    /* JADX INFO: compiled from: DownloadViewModel.kt */
    @Metadata(m194d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, m195d2 = {"Lcom/videshkarmakar/loop/ui/page/download/DownloadViewModel$ViewState;", "", "showPlaylistSelectionDialog", "", "url", "", "showFormatSelectionPage", "isUrlSharingTriggered", "(ZLjava/lang/String;ZZ)V", "()Z", "getShowFormatSelectionPage", "getShowPlaylistSelectionDialog", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class ViewState {
        public static final int $stable = 0;
        private final boolean isUrlSharingTriggered;
        private final boolean showFormatSelectionPage;
        private final boolean showPlaylistSelectionDialog;
        private final String url;

        public ViewState() {
            this(false, null, false, false, 15, null);
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z, String str, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z = viewState.showPlaylistSelectionDialog;
            }
            if ((i & 2) != 0) {
                str = viewState.url;
            }
            if ((i & 4) != 0) {
                z2 = viewState.showFormatSelectionPage;
            }
            if ((i & 8) != 0) {
                z3 = viewState.isUrlSharingTriggered;
            }
            return viewState.copy(z, str, z2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getShowPlaylistSelectionDialog() {
            return this.showPlaylistSelectionDialog;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getShowFormatSelectionPage() {
            return this.showFormatSelectionPage;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsUrlSharingTriggered() {
            return this.isUrlSharingTriggered;
        }

        public final ViewState copy(boolean showPlaylistSelectionDialog, String url, boolean showFormatSelectionPage, boolean isUrlSharingTriggered) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new ViewState(showPlaylistSelectionDialog, url, showFormatSelectionPage, isUrlSharingTriggered);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.showPlaylistSelectionDialog == viewState.showPlaylistSelectionDialog && Intrinsics.areEqual(this.url, viewState.url) && this.showFormatSelectionPage == viewState.showFormatSelectionPage && this.isUrlSharingTriggered == viewState.isUrlSharingTriggered;
        }

        public int hashCode() {
            return (((((DownloadViewModel$ViewState$$ExternalSyntheticBackport0.m185m(this.showPlaylistSelectionDialog) * 31) + this.url.hashCode()) * 31) + DownloadViewModel$ViewState$$ExternalSyntheticBackport0.m185m(this.showFormatSelectionPage)) * 31) + DownloadViewModel$ViewState$$ExternalSyntheticBackport0.m185m(this.isUrlSharingTriggered);
        }

        public String toString() {
            return "ViewState(showPlaylistSelectionDialog=" + this.showPlaylistSelectionDialog + ", url=" + this.url + ", showFormatSelectionPage=" + this.showFormatSelectionPage + ", isUrlSharingTriggered=" + this.isUrlSharingTriggered + ")";
        }

        public ViewState(boolean showPlaylistSelectionDialog, String url, boolean showFormatSelectionPage, boolean isUrlSharingTriggered) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.showPlaylistSelectionDialog = showPlaylistSelectionDialog;
            this.url = url;
            this.showFormatSelectionPage = showFormatSelectionPage;
            this.isUrlSharingTriggered = isUrlSharingTriggered;
        }

        public /* synthetic */ ViewState(boolean z, String str, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3);
        }

        public final boolean getShowPlaylistSelectionDialog() {
            return this.showPlaylistSelectionDialog;
        }

        public final String getUrl() {
            return this.url;
        }

        public final boolean getShowFormatSelectionPage() {
            return this.showFormatSelectionPage;
        }

        public final boolean isUrlSharingTriggered() {
            return this.isUrlSharingTriggered;
        }
    }

    public static /* synthetic */ void updateUrl$default(DownloadViewModel downloadViewModel, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        downloadViewModel.updateUrl(str, z);
    }

    public final void updateUrl(String url, boolean isUrlSharingTriggered) {
        ViewState value;
        ViewState it;
        Intrinsics.checkNotNullParameter(url, "url");
        MutableStateFlow<ViewState> mutableStateFlow = this.mutableViewStateFlow;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(it, false, url, false, isUrlSharingTriggered, 5, null)));
    }

    public final void startDownloadVideo() {
        String url = this.viewStateFlow.getValue().getUrl();
        Downloader.INSTANCE.clearErrorState();
        if (PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.CUSTOM_COMMAND, false, 1, null)) {
            BuildersKt__Builders_commonKt.launch$default(App.INSTANCE.getApplicationScope(), Dispatchers.getIO(), null, new C34631(url, null), 2, null);
            return;
        }
        if (!Downloader.INSTANCE.isDownloaderAvailable()) {
            return;
        }
        if (StringsKt.isBlank(url)) {
            ToastUtil toastUtil = ToastUtil.INSTANCE;
            String string = App.INSTANCE.getContext().getString(C3070R.string.url_empty);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            toastUtil.makeToast(string);
            return;
        }
        if (PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, "playlist", false, 1, null)) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C34642(url, null), 2, null);
        } else if (PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.FORMAT_SELECTION, false, 1, null)) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C34653(url, null), 2, null);
        } else {
            Downloader.getInfoAndDownload$default(Downloader.INSTANCE, url, null, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.download.DownloadViewModel$startDownloadVideo$1 */
    /* JADX INFO: compiled from: DownloadViewModel.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.download.DownloadViewModel$startDownloadVideo$1", m210f = "DownloadViewModel.kt", m211i = {}, m212l = {LockFreeTaskQueueCore.CLOSED_SHIFT}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C34631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C34631(String str, Continuation<? super C34631> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C34631(this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C34631) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (DownloadUtil.executeCommandInBackground$default(DownloadUtil.INSTANCE, this.$url, null, null, this, 6, null) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.download.DownloadViewModel$startDownloadVideo$2 */
    /* JADX INFO: compiled from: DownloadViewModel.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.download.DownloadViewModel$startDownloadVideo$2", m210f = "DownloadViewModel.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C34642 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C34642(String str, Continuation<? super C34642> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DownloadViewModel.this.new C34642(this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C34642) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    DownloadViewModel.this.parsePlaylistInfo(this.$url);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.download.DownloadViewModel$startDownloadVideo$3 */
    /* JADX INFO: compiled from: DownloadViewModel.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.download.DownloadViewModel$startDownloadVideo$3", m210f = "DownloadViewModel.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C34653 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C34653(String str, Continuation<? super C34653> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DownloadViewModel.this.new C34653(this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C34653) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    DownloadViewModel.this.fetchInfoForFormatSelection(this.$url);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchInfoForFormatSelection(String url) {
        Downloader.INSTANCE.updateState(Downloader.State.FetchingInfo.INSTANCE);
        Object objM7667fetchVideoInfoFromUrl0E7RQCE$default = DownloadUtil.m7667fetchVideoInfoFromUrl0E7RQCE$default(DownloadUtil.INSTANCE, url, 0, null, 6, null);
        if (Result.m7700isSuccessimpl(objM7667fetchVideoInfoFromUrl0E7RQCE$default)) {
            showFormatSelectionPageOrDownload((VideoInfo) objM7667fetchVideoInfoFromUrl0E7RQCE$default);
        }
        Throwable it = Result.m7696exceptionOrNullimpl(objM7667fetchVideoInfoFromUrl0E7RQCE$default);
        if (it != null) {
            Downloader.manageDownloadError$default(Downloader.INSTANCE, it, url, null, true, true, null, 36, null);
        }
        Downloader.INSTANCE.updateState(Downloader.State.Idle.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void parsePlaylistInfo(String url) {
        Downloader $this$parsePlaylistInfo_u24lambda_u245 = Downloader.INSTANCE;
        if ($this$parsePlaylistInfo_u24lambda_u245.isDownloaderAvailable()) {
            $this$parsePlaylistInfo_u24lambda_u245.clearErrorState();
            $this$parsePlaylistInfo_u24lambda_u245.updateState(Downloader.State.FetchingInfo.INSTANCE);
            Object objM7668getPlaylistOrVideoInfogIAlus$default = DownloadUtil.m7668getPlaylistOrVideoInfogIAlus$default(DownloadUtil.INSTANCE, url, null, 2, null);
            if (Result.m7700isSuccessimpl(objM7668getPlaylistOrVideoInfogIAlus$default)) {
                YoutubeDLInfo info = (YoutubeDLInfo) objM7668getPlaylistOrVideoInfogIAlus$default;
                $this$parsePlaylistInfo_u24lambda_u245.updateState(Downloader.State.Idle.INSTANCE);
                if (info instanceof PlaylistResult) {
                    showPlaylistPage((PlaylistResult) info);
                } else if (info instanceof VideoInfo) {
                    if (PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.FORMAT_SELECTION, false, 1, null)) {
                        showFormatSelectionPageOrDownload((VideoInfo) info);
                    } else if ($this$parsePlaylistInfo_u24lambda_u245.isDownloaderAvailable()) {
                        $this$parsePlaylistInfo_u24lambda_u245.downloadVideoWithInfo((VideoInfo) info);
                    }
                }
            }
            Throwable it = Result.m7696exceptionOrNullimpl(objM7668getPlaylistOrVideoInfogIAlus$default);
            if (it != null) {
                Downloader.manageDownloadError$default($this$parsePlaylistInfo_u24lambda_u245, it, url, null, true, true, null, 36, null);
            }
        }
    }

    private final void showPlaylistPage(PlaylistResult playlistResult) {
        ViewState value;
        ViewState it;
        Downloader.INSTANCE.updatePlaylistResult(playlistResult);
        MutableStateFlow<ViewState> mutableStateFlow = this.mutableViewStateFlow;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(it, true, null, false, false, 14, null)));
    }

    private final void showFormatSelectionPageOrDownload(VideoInfo info) {
        ViewState value;
        ViewState it;
        String format = info.getFormat();
        if (format == null || format.length() == 0) {
            Downloader.INSTANCE.downloadVideoWithInfo(info);
            return;
        }
        MutableStateFlow<VideoInfo> mutableStateFlow = this.videoInfoFlow;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), info)) {
        }
        MutableStateFlow<ViewState> mutableStateFlow2 = this.mutableViewStateFlow;
        do {
            value = mutableStateFlow2.getValue();
            it = value;
        } while (!mutableStateFlow2.compareAndSet(value, ViewState.copy$default(it, false, null, true, false, 11, null)));
    }

    public final void hidePlaylistDialog() {
        ViewState value;
        ViewState it;
        MutableStateFlow<ViewState> mutableStateFlow = this.mutableViewStateFlow;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(it, false, null, false, false, 14, null)));
    }

    public final void hideFormatPage() {
        ViewState value;
        ViewState it;
        MutableStateFlow<ViewState> mutableStateFlow = this.mutableViewStateFlow;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(it, false, null, false, false, 11, null)));
    }

    public final void onShareIntentConsumed() {
        ViewState value;
        ViewState it;
        MutableStateFlow<ViewState> mutableStateFlow = this.mutableViewStateFlow;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(it, false, null, false, false, 7, null)));
    }
}
