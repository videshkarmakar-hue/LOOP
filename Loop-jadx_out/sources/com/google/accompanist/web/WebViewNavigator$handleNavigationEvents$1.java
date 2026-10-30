package com.google.accompanist.web;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: WebView.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "com.google.accompanist.web.WebViewNavigator", m210f = "WebView.kt", m211i = {}, m212l = {566}, m213m = "handleNavigationEvents$web_release", m214n = {}, m215s = {})
final class WebViewNavigator$handleNavigationEvents$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WebViewNavigator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WebViewNavigator$handleNavigationEvents$1(WebViewNavigator webViewNavigator, Continuation<? super WebViewNavigator$handleNavigationEvents$1> continuation) {
        super(continuation);
        this.this$0 = webViewNavigator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handleNavigationEvents$web_release(null, this);
    }
}
