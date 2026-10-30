package com.google.accompanist.web;

import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebView.kt */
/* JADX INFO: loaded from: classes18.dex */
@Deprecated(message = "\naccompanist/web is deprecated and the API is no longer maintained. \nWe recommend forking the implementation and customising it to your needs. \nFor more information please visit https://google.github.io/accompanist/web\n")
@Metadata(m194d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J$\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@PX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@PX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006!"}, m195d2 = {"Lcom/google/accompanist/web/AccompanistWebViewClient;", "Landroid/webkit/WebViewClient;", "()V", "<set-?>", "Lcom/google/accompanist/web/WebViewNavigator;", "navigator", "getNavigator", "()Lcom/google/accompanist/web/WebViewNavigator;", "setNavigator$web_release", "(Lcom/google/accompanist/web/WebViewNavigator;)V", "Lcom/google/accompanist/web/WebViewState;", "state", "getState", "()Lcom/google/accompanist/web/WebViewState;", "setState$web_release", "(Lcom/google/accompanist/web/WebViewState;)V", "doUpdateVisitedHistory", "", "view", "Landroid/webkit/WebView;", "url", "", "isReload", "", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public class AccompanistWebViewClient extends WebViewClient {
    public static final int $stable = 8;
    public WebViewNavigator navigator;
    public WebViewState state;

    public WebViewState getState() {
        WebViewState webViewState = this.state;
        if (webViewState != null) {
            return webViewState;
        }
        Intrinsics.throwUninitializedPropertyAccessException("state");
        return null;
    }

    public void setState$web_release(WebViewState webViewState) {
        Intrinsics.checkNotNullParameter(webViewState, "<set-?>");
        this.state = webViewState;
    }

    public WebViewNavigator getNavigator() {
        WebViewNavigator webViewNavigator = this.navigator;
        if (webViewNavigator != null) {
            return webViewNavigator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigator");
        return null;
    }

    public void setNavigator$web_release(WebViewNavigator webViewNavigator) {
        Intrinsics.checkNotNullParameter(webViewNavigator, "<set-?>");
        this.navigator = webViewNavigator;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onPageStarted(view, url, favicon);
        getState().setLoadingState$web_release(new LoadingState.Loading(0.0f));
        getState().getErrorsForCurrentRequest().clear();
        getState().setPageTitle$web_release(null);
        getState().setPageIcon$web_release(null);
        getState().setLastLoadedUrl$web_release(url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onPageFinished(view, url);
        getState().setLoadingState$web_release(LoadingState.Finished.INSTANCE);
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.doUpdateVisitedHistory(view, url, isReload);
        getNavigator().setCanGoBack$web_release(view.canGoBack());
        getNavigator().setCanGoForward$web_release(view.canGoForward());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) throws Throwable {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onReceivedError(view, request, error);
        if (error != null) {
            getState().getErrorsForCurrentRequest().add(new WebViewError(request, error));
        }
    }
}
