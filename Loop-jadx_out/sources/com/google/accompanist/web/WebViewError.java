package com.google.accompanist.web;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebView.kt */
/* JADX INFO: loaded from: classes18.dex */
@Deprecated(message = "\naccompanist/web is deprecated and the API is no longer maintained. \nWe recommend forking the implementation and customising it to your needs. \nFor more information please visit https://google.github.io/accompanist/web\n")
@Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m195d2 = {"Lcom/google/accompanist/web/WebViewError;", "", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "(Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V", "getError", "()Landroid/webkit/WebResourceError;", "getRequest", "()Landroid/webkit/WebResourceRequest;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class WebViewError {
    public static final int $stable = 0;
    private final WebResourceError error;
    private final WebResourceRequest request;

    public static /* synthetic */ WebViewError copy$default(WebViewError webViewError, WebResourceRequest webResourceRequest, WebResourceError webResourceError, int i, Object obj) {
        if ((i & 1) != 0) {
            webResourceRequest = webViewError.request;
        }
        if ((i & 2) != 0) {
            webResourceError = webViewError.error;
        }
        return webViewError.copy(webResourceRequest, webResourceError);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WebResourceRequest getRequest() {
        return this.request;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final WebResourceError getError() {
        return this.error;
    }

    public final WebViewError copy(WebResourceRequest request, WebResourceError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return new WebViewError(request, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebViewError)) {
            return false;
        }
        WebViewError webViewError = (WebViewError) other;
        return Intrinsics.areEqual(this.request, webViewError.request) && Intrinsics.areEqual(this.error, webViewError.error);
    }

    public int hashCode() {
        return ((this.request == null ? 0 : this.request.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "WebViewError(request=" + this.request + ", error=" + this.error + ')';
    }

    public WebViewError(WebResourceRequest request, WebResourceError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.request = request;
        this.error = error;
    }

    public final WebResourceRequest getRequest() {
        return this.request;
    }

    public final WebResourceError getError() {
        return this.error;
    }
}
