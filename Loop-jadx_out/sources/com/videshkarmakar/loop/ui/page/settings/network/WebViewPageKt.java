package com.videshkarmakar.loop.ui.page.settings.network;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import com.google.accompanist.web.AccompanistWebChromeClient;
import com.google.accompanist.web.AccompanistWebViewClient;
import com.google.accompanist.web.WebViewKt;
import com.google.accompanist.web.WebViewState;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: WebViewPage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u001a#\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0007¢\u0006\u0002\u0010\n\u001a\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\f\u0010\u000f\u001a\u00020\u0001*\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002"}, d2 = {"TAG", "", "domainRegex", "Lkotlin/text/Regex;", WebViewPageKt.TAG, "", "cookiesViewModel", "Lcom/videshkarmakar/loop/ui/page/settings/network/CookiesViewModel;", "onDismissRequest", "Lkotlin/Function0;", "(Lcom/videshkarmakar/loop/ui/page/settings/network/CookiesViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "makeCookie", "Lcom/videshkarmakar/loop/ui/page/settings/network/Cookie;", "url", "cookieString", "toDomain", "app_debug", "state", "Lcom/videshkarmakar/loop/ui/page/settings/network/CookiesViewModel$ViewState;"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class WebViewPageKt {
    private static final String TAG = "WebViewPage";
    private static final Regex domainRegex = new Regex("http(s)?://(\\w*(www|m|account|sso))?|/.*");

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toDomain(String $this$toDomain) {
        return domainRegex.replace($this$toDomain, "");
    }

    private static final Cookie makeCookie(String url, String cookieString) {
        List $this$makeCookie_u24lambda_u240 = StringsKt.split$default((CharSequence) cookieString, new String[]{"="}, false, 0, 6, (Object) null);
        return new Cookie(url, (String) CollectionsKt.first($this$makeCookie_u24lambda_u240), (String) CollectionsKt.last($this$makeCookie_u24lambda_u240));
    }

    public static final void WebViewPage(final CookiesViewModel cookiesViewModel, final Function0<Unit> onDismissRequest, Composer $composer, final int $changed) {
        Object value$iv;
        Intrinsics.checkNotNullParameter(cookiesViewModel, "cookiesViewModel");
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer $composer2 = $composer.startRestartGroup(-1313058551);
        ComposerKt.sourceInformation($composer2, "C(WebViewPage)85@2775L29,90@2926L35,92@3037L32,94@3128L650,111@3780L1554,94@3075L2259:WebViewPage.kt#sffru");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1313058551, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.network.WebViewPage (WebViewPage.kt:83)");
        }
        State state$delegate = FlowExtKt.collectAsStateWithLifecycle(cookiesViewModel.getStateFlow(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 8, 7);
        Log.d(TAG, WebViewPage$lambda$1(state$delegate).getEditingCookieProfile().getUrl());
        final CookieManager cookieManager = CookieManager.getInstance();
        $composer2.startReplaceGroup(184725710);
        ComposerKt.sourceInformation($composer2, "CC(remember):WebViewPage.kt#9igjgp");
        Object it$iv = $composer2.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new LinkedHashSet();
            $composer2.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        $composer2.endReplaceGroup();
        String websiteUrl = WebViewPage$lambda$1(state$delegate).getEditingCookieProfile().getUrl();
        final WebViewState webViewState = WebViewKt.rememberWebViewState(websiteUrl, null, $composer2, 0, 2);
        ScaffoldKt.m2282ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), ComposableLambdaKt.rememberComposableLambda(1718538181, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.WebViewPageKt.WebViewPage.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer3, int $changed2) {
                ComposerKt.sourceInformation($composer3, "C96@3169L57,97@3257L319,105@3588L174,95@3138L634:WebViewPage.kt#sffru");
                if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1718538181, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.WebViewPage.<anonymous> (WebViewPage.kt:95)");
                    }
                    final WebViewState webViewState2 = webViewState;
                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-897614199, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.WebViewPageKt.WebViewPage.1.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer4, int $changed3) {
                            ComposerKt.sourceInformation($composer4, "C96@3171L53:WebViewPage.kt#sffru");
                            if (($changed3 & 11) == 2 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-897614199, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.network.WebViewPage.<anonymous>.<anonymous> (WebViewPage.kt:96)");
                            }
                            TextKt.m2569Text4IGK_g(String.valueOf(webViewState2.getPageTitle()), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 3072, 122878);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer3, 54);
                    final Function0<Unit> function0 = onDismissRequest;
                    ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1713661429, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.WebViewPageKt.WebViewPage.1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer4, int $changed3) {
                            Object value$iv2;
                            ComposerKt.sourceInformation($composer4, "C99@3317L22,98@3275L287:WebViewPage.kt#sffru");
                            if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1713661429, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.network.WebViewPage.<anonymous>.<anonymous> (WebViewPage.kt:98)");
                                }
                                $composer4.startReplaceGroup(-719360745);
                                ComposerKt.sourceInformation($composer4, "CC(remember):WebViewPage.kt#9igjgp");
                                boolean invalid$iv = $composer4.changed(function0);
                                final Function0<Unit> function1 = function0;
                                Object it$iv2 = $composer4.rememberedValue();
                                if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                    value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.WebViewPageKt$WebViewPage$1$2$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                            function1.invoke();
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv2);
                                } else {
                                    value$iv2 = it$iv2;
                                }
                                $composer4.endReplaceGroup();
                                IconButtonKt.IconButton((Function0) value$iv2, null, false, null, null, ComposableSingletons$WebViewPageKt.INSTANCE.m7471getLambda1$app_debug(), $composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer4.skipToGroupEnd();
                        }
                    }, $composer3, 54);
                    final Function0<Unit> function1 = onDismissRequest;
                    AppBarKt.m1675TopAppBarGHTll3U(composableLambdaRememberComposableLambda, null, composableLambdaRememberComposableLambda2, ComposableLambdaKt.rememberComposableLambda(-317838988, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.WebViewPageKt.WebViewPage.1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                            invoke(rowScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope TopAppBar, Composer $composer4, int $changed3) {
                            Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
                            ComposerKt.sourceInformation($composer4, "C106@3606L142:WebViewPage.kt#sffru");
                            if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-317838988, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.network.WebViewPage.<anonymous>.<anonymous> (WebViewPage.kt:106)");
                                }
                                ButtonKt.TextButton(function1, null, false, null, null, null, null, null, null, ComposableSingletons$WebViewPageKt.INSTANCE.m7472getLambda2$app_debug(), $composer4, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer4.skipToGroupEnd();
                        }
                    }, $composer3, 54), 0.0f, null, null, null, $composer3, 3462, 242);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer3.skipToGroupEnd();
            }
        }, $composer2, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-767094630, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.WebViewPageKt.WebViewPage.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
                invoke(paddingValues, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PaddingValues paddingValues, Composer $composer3, int $changed2) {
                Object value$iv2;
                Object value$iv3;
                Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                ComposerKt.sourceInformation($composer3, "C112@3827L649,130@4511L86,134@4606L720:WebViewPage.kt#sffru");
                int $dirty = $changed2;
                if (($changed2 & 14) == 0) {
                    $dirty |= $composer3.changed(paddingValues) ? 4 : 2;
                }
                int $dirty2 = $dirty;
                if (($dirty2 & 91) != 18 || !$composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-767094630, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.network.WebViewPage.<anonymous> (WebViewPage.kt:112)");
                    }
                    $composer3.startReplaceGroup(894215796);
                    ComposerKt.sourceInformation($composer3, "CC(remember):WebViewPage.kt#9igjgp");
                    Object it$iv2 = $composer3.rememberedValue();
                    if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new AccompanistWebViewClient() { // from class: com.videshkarmakar.loop.ui.page.settings.network.WebViewPageKt$WebViewPage$2$webViewClient$1$1
                            @Override // com.google.accompanist.web.AccompanistWebViewClient, android.webkit.WebViewClient
                            public void onPageFinished(WebView view, String url) {
                                Intrinsics.checkNotNullParameter(view, "view");
                                super.onPageFinished(view, url);
                                String str = url;
                                if (str != null) {
                                    str.length();
                                }
                            }

                            @Override // android.webkit.WebViewClient
                            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                                Uri url;
                                String scheme;
                                boolean z = false;
                                if (request != null && (url = request.getUrl()) != null && (scheme = url.getScheme()) != null && StringsKt.contains$default((CharSequence) scheme, (CharSequence) "http", false, 2, (Object) null)) {
                                    z = true;
                                }
                                if (!z) {
                                    return true;
                                }
                                return super.shouldOverrideUrlLoading(view, request);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    WebViewPageKt$WebViewPage$2$webViewClient$1$1 webViewClient = (WebViewPageKt$WebViewPage$2$webViewClient$1$1) value$iv2;
                    $composer3.endReplaceGroup();
                    $composer3.startReplaceGroup(894216480);
                    ComposerKt.sourceInformation($composer3, "CC(remember):WebViewPage.kt#9igjgp");
                    Object it$iv3 = $composer3.rememberedValue();
                    if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = new AccompanistWebChromeClient() { // from class: com.videshkarmakar.loop.ui.page.settings.network.WebViewPageKt$WebViewPage$2$webViewChromeClient$1$1
                        };
                        $composer3.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv3;
                    }
                    WebViewPageKt$WebViewPage$2$webViewChromeClient$1$1 webViewChromeClient = (WebViewPageKt$WebViewPage$2$webViewChromeClient$1$1) value$iv3;
                    $composer3.endReplaceGroup();
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.INSTANCE, paddingValues), 0.0f, 1, null);
                    final CookieManager cookieManager2 = cookieManager;
                    WebViewKt.WebView(webViewState, modifierFillMaxSize$default, true, null, null, null, webViewClient, webViewChromeClient, new Function1<Context, WebView>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.WebViewPageKt.WebViewPage.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final WebView invoke(Context context) {
                            Intrinsics.checkNotNullParameter(context, "context");
                            WebView $this$invoke_u24lambda_u241 = new WebView(context);
                            CookieManager cookieManager3 = cookieManager2;
                            WebSettings $this$invoke_u24lambda_u241_u24lambda_u240 = $this$invoke_u24lambda_u241.getSettings();
                            $this$invoke_u24lambda_u241_u24lambda_u240.setJavaScriptCanOpenWindowsAutomatically(true);
                            $this$invoke_u24lambda_u241_u24lambda_u240.setJavaScriptEnabled(true);
                            $this$invoke_u24lambda_u241_u24lambda_u240.setDomStorageEnabled(true);
                            PreferenceUtil preferenceUtil = PreferenceUtil.INSTANCE;
                            String userAgentString = $this$invoke_u24lambda_u241_u24lambda_u240.getUserAgentString();
                            Intrinsics.checkNotNullExpressionValue(userAgentString, "getUserAgentString(...)");
                            preferenceUtil.updateString(PreferenceUtilKt.USER_AGENT_STRING, userAgentString);
                            cookieManager3.setAcceptThirdPartyCookies($this$invoke_u24lambda_u241, true);
                            return $this$invoke_u24lambda_u241;
                        }
                    }, $composer3, 14156160, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer3.skipToGroupEnd();
            }
        }, $composer2, 54), $composer2, 805306422, 508);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.WebViewPageKt.WebViewPage.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    WebViewPageKt.WebViewPage(cookiesViewModel, onDismissRequest, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final CookiesViewModel.ViewState WebViewPage$lambda$1(State<CookiesViewModel.ViewState> state) {
        Object thisObj$iv = state.getValue();
        return (CookiesViewModel.ViewState) thisObj$iv;
    }
}
