package com.google.accompanist.web;

import android.webkit.WebView;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: WebView.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "com.google.accompanist.web.WebViewKt$WebView$12$2", m210f = "WebView.kt", m211i = {}, m212l = {196}, m213m = "invokeSuspend", m214n = {}, m215s = {})
final class WebViewKt$WebView$12$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WebViewState $state;
    final /* synthetic */ WebView $wv;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WebViewKt$WebView$12$2(WebViewState webViewState, WebView webView, Continuation<? super WebViewKt$WebView$12$2> continuation) {
        super(2, continuation);
        this.$state = webViewState;
        this.$wv = webView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewKt$WebView$12$2(this.$state, this.$wv, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewKt$WebView$12$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final WebViewState webViewState = this.$state;
                Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<WebContent>() { // from class: com.google.accompanist.web.WebViewKt$WebView$12$2.1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final WebContent invoke() {
                        return webViewState.getContent();
                    }
                });
                final WebView webView = this.$wv;
                this.label = 1;
                if (flowSnapshotFlow.collect(new FlowCollector() { // from class: com.google.accompanist.web.WebViewKt$WebView$12$2.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((WebContent) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(WebContent content, Continuation<? super Unit> continuation) {
                        if (content instanceof WebContent.Url) {
                            webView.loadUrl(((WebContent.Url) content).getUrl(), ((WebContent.Url) content).getAdditionalHttpHeaders());
                        } else if (content instanceof WebContent.Data) {
                            webView.loadDataWithBaseURL(((WebContent.Data) content).getBaseUrl(), ((WebContent.Data) content).getData(), ((WebContent.Data) content).getMimeType(), ((WebContent.Data) content).getEncoding(), ((WebContent.Data) content).getHistoryUrl());
                        } else if (content instanceof WebContent.Post) {
                            webView.postUrl(((WebContent.Post) content).getUrl(), ((WebContent.Post) content).getPostData());
                        } else {
                            boolean z = content instanceof WebContent.NavigatorOnly;
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
        return Unit.INSTANCE;
    }
}
