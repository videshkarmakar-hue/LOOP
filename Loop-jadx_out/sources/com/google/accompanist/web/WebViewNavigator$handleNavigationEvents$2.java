package com.google.accompanist.web;

import android.webkit.WebView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: compiled from: WebView.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "com.google.accompanist.web.WebViewNavigator$handleNavigationEvents$2", m210f = "WebView.kt", m211i = {}, m212l = {567}, m213m = "invokeSuspend", m214n = {}, m215s = {})
final class WebViewNavigator$handleNavigationEvents$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ WebView $this_handleNavigationEvents;
    int label;
    final /* synthetic */ WebViewNavigator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WebViewNavigator$handleNavigationEvents$2(WebViewNavigator webViewNavigator, WebView webView, Continuation<? super WebViewNavigator$handleNavigationEvents$2> continuation) {
        super(2, continuation);
        this.this$0 = webViewNavigator;
        this.$this_handleNavigationEvents = webView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewNavigator$handleNavigationEvents$2(this.this$0, this.$this_handleNavigationEvents, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        return ((WebViewNavigator$handleNavigationEvents$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MutableSharedFlow mutableSharedFlow = this.this$0.navigationEvents;
                final WebView webView = this.$this_handleNavigationEvents;
                this.label = 1;
                if (mutableSharedFlow.collect(new FlowCollector() { // from class: com.google.accompanist.web.WebViewNavigator$handleNavigationEvents$2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((WebViewNavigator.NavigationEvent) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(WebViewNavigator.NavigationEvent event, Continuation<? super Unit> continuation) {
                        if (event instanceof WebViewNavigator.NavigationEvent.Back) {
                            webView.goBack();
                        } else if (event instanceof WebViewNavigator.NavigationEvent.Forward) {
                            webView.goForward();
                        } else if (event instanceof WebViewNavigator.NavigationEvent.Reload) {
                            webView.reload();
                        } else if (event instanceof WebViewNavigator.NavigationEvent.StopLoading) {
                            webView.stopLoading();
                        } else if (event instanceof WebViewNavigator.NavigationEvent.LoadHtml) {
                            webView.loadDataWithBaseURL(((WebViewNavigator.NavigationEvent.LoadHtml) event).getBaseUrl(), ((WebViewNavigator.NavigationEvent.LoadHtml) event).getHtml(), ((WebViewNavigator.NavigationEvent.LoadHtml) event).getMimeType(), ((WebViewNavigator.NavigationEvent.LoadHtml) event).getEncoding(), ((WebViewNavigator.NavigationEvent.LoadHtml) event).getHistoryUrl());
                        } else if (event instanceof WebViewNavigator.NavigationEvent.LoadUrl) {
                            webView.loadUrl(((WebViewNavigator.NavigationEvent.LoadUrl) event).getUrl(), ((WebViewNavigator.NavigationEvent.LoadUrl) event).getAdditionalHttpHeaders());
                        } else if (event instanceof WebViewNavigator.NavigationEvent.PostUrl) {
                            webView.postUrl(((WebViewNavigator.NavigationEvent.PostUrl) event).getUrl(), ((WebViewNavigator.NavigationEvent.PostUrl) event).getPostData());
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }
}
