package com.google.accompanist.web;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebView.kt */
/* JADX INFO: loaded from: classes18.dex */
@Deprecated(message = "\naccompanist/web is deprecated and the API is no longer maintained. \nWe recommend forking the implementation and customising it to your needs. \nFor more information please visit https://google.github.io/accompanist/web\n")
@Metadata(m194d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R+\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R/\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00148F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R+\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u000b\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R/\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u0005\u001a\u0004\u0018\u00010\"8F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\u000b\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R/\u0010)\u001a\u0004\u0018\u00010\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00148F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010\u000b\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R(\u0010.\u001a\u0004\u0018\u00010-2\b\u0010\u0005\u001a\u0004\u0018\u00010-@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R/\u00104\u001a\u0004\u0018\u0001032\b\u0010\u0005\u001a\u0004\u0018\u0001038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010\u000b\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006:"}, m195d2 = {"Lcom/google/accompanist/web/WebViewState;", "", "webContent", "Lcom/google/accompanist/web/WebContent;", "(Lcom/google/accompanist/web/WebContent;)V", "<set-?>", "content", "getContent", "()Lcom/google/accompanist/web/WebContent;", "setContent", "content$delegate", "Landroidx/compose/runtime/MutableState;", "errorsForCurrentRequest", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lcom/google/accompanist/web/WebViewError;", "getErrorsForCurrentRequest", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "isLoading", "", "()Z", "", "lastLoadedUrl", "getLastLoadedUrl", "()Ljava/lang/String;", "setLastLoadedUrl$web_release", "(Ljava/lang/String;)V", "lastLoadedUrl$delegate", "Lcom/google/accompanist/web/LoadingState;", "loadingState", "getLoadingState", "()Lcom/google/accompanist/web/LoadingState;", "setLoadingState$web_release", "(Lcom/google/accompanist/web/LoadingState;)V", "loadingState$delegate", "Landroid/graphics/Bitmap;", "pageIcon", "getPageIcon", "()Landroid/graphics/Bitmap;", "setPageIcon$web_release", "(Landroid/graphics/Bitmap;)V", "pageIcon$delegate", "pageTitle", "getPageTitle", "setPageTitle$web_release", "pageTitle$delegate", "Landroid/os/Bundle;", "viewState", "getViewState", "()Landroid/os/Bundle;", "setViewState$web_release", "(Landroid/os/Bundle;)V", "Landroid/webkit/WebView;", "webView", "getWebView$web_release", "()Landroid/webkit/WebView;", "setWebView$web_release", "(Landroid/webkit/WebView;)V", "webView$delegate", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class WebViewState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: content$delegate, reason: from kotlin metadata */
    private final MutableState content;
    private final SnapshotStateList<WebViewError> errorsForCurrentRequest;

    /* JADX INFO: renamed from: lastLoadedUrl$delegate, reason: from kotlin metadata */
    private final MutableState lastLoadedUrl;

    /* JADX INFO: renamed from: loadingState$delegate, reason: from kotlin metadata */
    private final MutableState loadingState;

    /* JADX INFO: renamed from: pageIcon$delegate, reason: from kotlin metadata */
    private final MutableState pageIcon;

    /* JADX INFO: renamed from: pageTitle$delegate, reason: from kotlin metadata */
    private final MutableState pageTitle;
    private Bundle viewState;

    /* JADX INFO: renamed from: webView$delegate, reason: from kotlin metadata */
    private final MutableState webView;

    public WebViewState(WebContent webContent) {
        Intrinsics.checkNotNullParameter(webContent, "webContent");
        this.lastLoadedUrl = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.content = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(webContent, null, 2, null);
        this.loadingState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(LoadingState.Initializing.INSTANCE, null, 2, null);
        this.pageTitle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.pageIcon = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.errorsForCurrentRequest = SnapshotStateKt.mutableStateListOf();
        this.webView = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    public final String getLastLoadedUrl() {
        State $this$getValue$iv = this.lastLoadedUrl;
        return (String) $this$getValue$iv.getValue();
    }

    public final void setLastLoadedUrl$web_release(String str) {
        MutableState $this$setValue$iv = this.lastLoadedUrl;
        $this$setValue$iv.setValue(str);
    }

    public final WebContent getContent() {
        State $this$getValue$iv = this.content;
        return (WebContent) $this$getValue$iv.getValue();
    }

    public final void setContent(WebContent webContent) {
        Intrinsics.checkNotNullParameter(webContent, "<set-?>");
        MutableState $this$setValue$iv = this.content;
        $this$setValue$iv.setValue(webContent);
    }

    public final LoadingState getLoadingState() {
        State $this$getValue$iv = this.loadingState;
        return (LoadingState) $this$getValue$iv.getValue();
    }

    public final void setLoadingState$web_release(LoadingState loadingState) {
        Intrinsics.checkNotNullParameter(loadingState, "<set-?>");
        MutableState $this$setValue$iv = this.loadingState;
        $this$setValue$iv.setValue(loadingState);
    }

    public final boolean isLoading() {
        return !(getLoadingState() instanceof LoadingState.Finished);
    }

    public final String getPageTitle() {
        State $this$getValue$iv = this.pageTitle;
        return (String) $this$getValue$iv.getValue();
    }

    public final void setPageTitle$web_release(String str) {
        MutableState $this$setValue$iv = this.pageTitle;
        $this$setValue$iv.setValue(str);
    }

    public final Bitmap getPageIcon() {
        State $this$getValue$iv = this.pageIcon;
        return (Bitmap) $this$getValue$iv.getValue();
    }

    public final void setPageIcon$web_release(Bitmap bitmap) {
        MutableState $this$setValue$iv = this.pageIcon;
        $this$setValue$iv.setValue(bitmap);
    }

    public final SnapshotStateList<WebViewError> getErrorsForCurrentRequest() {
        return this.errorsForCurrentRequest;
    }

    public final Bundle getViewState() {
        return this.viewState;
    }

    public final void setViewState$web_release(Bundle bundle) {
        this.viewState = bundle;
    }

    public final WebView getWebView$web_release() {
        State $this$getValue$iv = this.webView;
        return (WebView) $this$getValue$iv.getValue();
    }

    public final void setWebView$web_release(WebView webView) {
        MutableState $this$setValue$iv = this.webView;
        $this$setValue$iv.setValue(webView);
    }
}
