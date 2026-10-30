package com.google.accompanist.web;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.viewinterop.AndroidView_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.MapSaverKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: WebView.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0093\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0\u00142\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0007¢\u0006\u0002\u0010\u001d\u001a\u008b\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0\u00142\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0007¢\u0006\u0002\u0010\u001e\u001a\r\u0010\u001f\u001a\u00020\u0002H\u0007¢\u0006\u0002\u0010 \u001a\u0017\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0002\u0010$\u001a\u001d\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0007¢\u0006\u0002\u0010*\u001a+\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'2\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0,H\u0007¢\u0006\u0002\u0010-\u001aC\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020'2\n\b\u0002\u00100\u001a\u0004\u0018\u00010'2\b\b\u0002\u00101\u001a\u00020'2\n\b\u0002\u00102\u001a\u0004\u0018\u00010'2\n\b\u0002\u00103\u001a\u0004\u0018\u00010'H\u0007¢\u0006\u0002\u00104\u001a\u0014\u00105\u001a\u000206*\u0002072\u0006\u0010&\u001a\u00020'H\u0000\"(\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00018\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u00068"}, m195d2 = {"WebStateSaver", "Landroidx/compose/runtime/saveable/Saver;", "Lcom/google/accompanist/web/WebViewState;", "", "getWebStateSaver$annotations", "()V", "getWebStateSaver", "()Landroidx/compose/runtime/saveable/Saver;", "WebView", "", "state", "layoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "modifier", "Landroidx/compose/ui/Modifier;", "captureBackPresses", "", "navigator", "Lcom/google/accompanist/web/WebViewNavigator;", "onCreated", "Lkotlin/Function1;", "Landroid/webkit/WebView;", "onDispose", "client", "Lcom/google/accompanist/web/AccompanistWebViewClient;", "chromeClient", "Lcom/google/accompanist/web/AccompanistWebChromeClient;", "factory", "Landroid/content/Context;", "(Lcom/google/accompanist/web/WebViewState;Landroid/widget/FrameLayout$LayoutParams;Landroidx/compose/ui/Modifier;ZLcom/google/accompanist/web/WebViewNavigator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/google/accompanist/web/AccompanistWebViewClient;Lcom/google/accompanist/web/AccompanistWebChromeClient;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Lcom/google/accompanist/web/WebViewState;Landroidx/compose/ui/Modifier;ZLcom/google/accompanist/web/WebViewNavigator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/google/accompanist/web/AccompanistWebViewClient;Lcom/google/accompanist/web/AccompanistWebChromeClient;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberSaveableWebViewState", "(Landroidx/compose/runtime/Composer;I)Lcom/google/accompanist/web/WebViewState;", "rememberWebViewNavigator", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/Composer;II)Lcom/google/accompanist/web/WebViewNavigator;", "rememberWebViewState", "url", "", "postData", "", "(Ljava/lang/String;[BLandroidx/compose/runtime/Composer;I)Lcom/google/accompanist/web/WebViewState;", "additionalHttpHeaders", "", "(Ljava/lang/String;Ljava/util/Map;Landroidx/compose/runtime/Composer;II)Lcom/google/accompanist/web/WebViewState;", "rememberWebViewStateWithHTMLData", "data", "baseUrl", "encoding", "mimeType", "historyUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Lcom/google/accompanist/web/WebViewState;", "withUrl", "Lcom/google/accompanist/web/WebContent$Url;", "Lcom/google/accompanist/web/WebContent;", "web_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class WebViewKt {
    private static final Saver<WebViewState, Object> WebStateSaver;

    @Deprecated(message = "\naccompanist/web is deprecated and the API is no longer maintained. \nWe recommend forking the implementation and customising it to your needs. \nFor more information please visit https://google.github.io/accompanist/web\n")
    public static /* synthetic */ void getWebStateSaver$annotations() {
    }

    @Deprecated(message = "\naccompanist/web is deprecated and the API is no longer maintained. \nWe recommend forking the implementation and customising it to your needs. \nFor more information please visit https://google.github.io/accompanist/web\n")
    public static final void WebView(final WebViewState state, Modifier modifier, boolean captureBackPresses, WebViewNavigator navigator, Function1<? super WebView, Unit> function1, Function1<? super WebView, Unit> function2, AccompanistWebViewClient client, AccompanistWebChromeClient chromeClient, Function1<? super Context, ? extends WebView> function3, Composer $composer, final int $changed, final int i) {
        Function1<? super WebView, Unit> function4;
        Function1<? super WebView, Unit> function5;
        boolean captureBackPresses2;
        WebViewNavigator navigator2;
        C27071 c27071;
        C27132 c27132;
        AccompanistWebViewClient client2;
        AccompanistWebChromeClient chromeClient2;
        Function1<? super Context, ? extends WebView> function6;
        int $dirty;
        AccompanistWebChromeClient chromeClient3;
        Modifier modifier2;
        Object value$iv;
        Object value$iv2;
        Modifier modifier3;
        AccompanistWebChromeClient chromeClient4;
        WebViewNavigator navigator3;
        Function1<? super Context, ? extends WebView> function7;
        boolean captureBackPresses3;
        Function1<? super WebView, Unit> function8;
        AccompanistWebViewClient client3;
        Function1<? super WebView, Unit> function9;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer2 = $composer.startRestartGroup(1473276617);
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changed(captureBackPresses) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty2 |= ((i & 8) == 0 && $composer2.changed(navigator)) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            function4 = function1;
        } else if ((57344 & $changed) == 0) {
            function4 = function1;
            $dirty2 |= $composer2.changedInstance(function4) ? 16384 : 8192;
        } else {
            function4 = function1;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            function5 = function2;
        } else if ((458752 & $changed) == 0) {
            function5 = function2;
            $dirty2 |= $composer2.changedInstance(function5) ? 131072 : 65536;
        } else {
            function5 = function2;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty2 |= 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 192) == 192 && (191739611 & $dirty2) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            captureBackPresses3 = captureBackPresses;
            navigator3 = navigator;
            client3 = client;
            chromeClient4 = chromeClient;
            function7 = function3;
            function8 = function4;
            function9 = function5;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                captureBackPresses2 = i3 != 0 ? true : captureBackPresses;
                if ((i & 8) != 0) {
                    navigator2 = rememberWebViewNavigator(null, $composer2, 0, 1);
                    $dirty2 &= -7169;
                } else {
                    navigator2 = navigator;
                }
                c27071 = i4 != 0 ? new Function1<WebView, Unit>() { // from class: com.google.accompanist.web.WebViewKt.WebView.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(WebView webView) {
                        invoke2(webView);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(WebView it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                } : function4;
                c27132 = i5 != 0 ? new Function1<WebView, Unit>() { // from class: com.google.accompanist.web.WebViewKt.WebView.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(WebView webView) {
                        invoke2(webView);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(WebView it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                } : function5;
                if (i6 != 0) {
                    $composer2.startReplaceableGroup(1370702801);
                    Object it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new AccompanistWebViewClient();
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv;
                    }
                    client2 = (AccompanistWebViewClient) value$iv2;
                    $composer2.endReplaceableGroup();
                    $dirty2 &= -3670017;
                } else {
                    client2 = client;
                }
                if (i7 != 0) {
                    $composer2.startReplaceableGroup(1370702889);
                    Object it$iv2 = $composer2.rememberedValue();
                    if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv = new AccompanistWebChromeClient();
                        $composer2.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv2;
                    }
                    chromeClient2 = (AccompanistWebChromeClient) value$iv;
                    $composer2.endReplaceableGroup();
                    $dirty2 &= -29360129;
                } else {
                    chromeClient2 = chromeClient;
                }
                if (i8 != 0) {
                    function6 = null;
                    $dirty = $dirty2;
                    chromeClient3 = chromeClient2;
                    modifier2 = modifier4;
                } else {
                    function6 = function3;
                    $dirty = $dirty2;
                    chromeClient3 = chromeClient2;
                    modifier2 = modifier4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if (i6 != 0) {
                    $dirty2 &= -3670017;
                }
                if (i7 != 0) {
                    int i9 = (-29360129) & $dirty2;
                    captureBackPresses2 = captureBackPresses;
                    navigator2 = navigator;
                    client2 = client;
                    chromeClient3 = chromeClient;
                    function6 = function3;
                    c27071 = function4;
                    c27132 = function5;
                    $dirty = i9;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    captureBackPresses2 = captureBackPresses;
                    navigator2 = navigator;
                    client2 = client;
                    function6 = function3;
                    c27071 = function4;
                    c27132 = function5;
                    $dirty = $dirty2;
                    chromeClient3 = chromeClient;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1473276617, $dirty, -1, "com.google.accompanist.web.WebView (WebView.kt:100)");
            }
            final boolean z = captureBackPresses2;
            final WebViewNavigator webViewNavigator = navigator2;
            final Function1<? super WebView, Unit> function10 = c27071;
            final Function1<? super WebView, Unit> function11 = c27132;
            final AccompanistWebViewClient accompanistWebViewClient = client2;
            final AccompanistWebChromeClient accompanistWebChromeClient = chromeClient3;
            final Function1<? super Context, ? extends WebView> function12 = function6;
            BoxWithConstraintsKt.BoxWithConstraints(modifier2, null, false, ComposableLambdaKt.composableLambda($composer2, -1606035789, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: com.google.accompanist.web.WebViewKt.WebView.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
                    invoke(boxWithConstraintsScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxWithConstraintsScope BoxWithConstraints, Composer $composer3, int $changed2) {
                    int i10;
                    Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                    int $dirty3 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty3 |= $composer3.changed(BoxWithConstraints) ? 4 : 2;
                    }
                    if (($dirty3 & 91) != 18 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1606035789, $dirty3, -1, "com.google.accompanist.web.WebView.<anonymous> (WebView.kt:105)");
                        }
                        if (Constraints.m6742getHasFixedWidthimpl(BoxWithConstraints.mo774getConstraintsmsEJaDk())) {
                            i10 = -1;
                        } else {
                            i10 = -2;
                        }
                        int width = i10;
                        int height = Constraints.m6741getHasFixedHeightimpl(BoxWithConstraints.mo774getConstraintsmsEJaDk()) ? -1 : -2;
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
                        WebViewKt.WebView(state, layoutParams, Modifier.INSTANCE, z, webViewNavigator, function10, function11, accompanistWebViewClient, accompanistWebChromeClient, function12, $composer3, 150995392, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, (($dirty >> 3) & 14) | 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            chromeClient4 = chromeClient3;
            navigator3 = navigator2;
            function7 = function6;
            captureBackPresses3 = captureBackPresses2;
            function8 = c27071;
            client3 = client2;
            function9 = c27132;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = captureBackPresses3;
            final WebViewNavigator webViewNavigator2 = navigator3;
            final Function1<? super WebView, Unit> function13 = function8;
            final Function1<? super WebView, Unit> function14 = function9;
            final AccompanistWebViewClient accompanistWebViewClient2 = client3;
            final AccompanistWebChromeClient accompanistWebChromeClient2 = chromeClient4;
            final Function1<? super Context, ? extends WebView> function15 = function7;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.web.WebViewKt.WebView.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i10) {
                    WebViewKt.WebView(state, modifier5, z2, webViewNavigator2, function13, function14, accompanistWebViewClient2, accompanistWebChromeClient2, function15, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(message = "\naccompanist/web is deprecated and the API is no longer maintained. \nWe recommend forking the implementation and customising it to your needs. \nFor more information please visit https://google.github.io/accompanist/web\n")
    public static final void WebView(final WebViewState state, final FrameLayout.LayoutParams layoutParams, Modifier modifier, boolean captureBackPresses, WebViewNavigator navigator, Function1<? super WebView, Unit> function1, Function1<? super WebView, Unit> function2, AccompanistWebViewClient client, AccompanistWebChromeClient chromeClient, Function1<? super Context, ? extends WebView> function3, Composer $composer, final int $changed, final int i) {
        WebViewNavigator navigator2;
        AccompanistWebViewClient client2;
        AccompanistWebChromeClient chromeClient2;
        int $dirty;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Composer $composer2 = $composer.startRestartGroup(-1401343589);
        int $dirty2 = $changed;
        Modifier modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        boolean captureBackPresses2 = (i & 8) != 0 ? true : captureBackPresses;
        if ((i & 16) != 0) {
            WebViewNavigator navigator3 = rememberWebViewNavigator(null, $composer2, 0, 1);
            $dirty2 &= -57345;
            navigator2 = navigator3;
        } else {
            navigator2 = navigator;
        }
        Function1<? super WebView, Unit> function4 = (i & 32) != 0 ? new Function1<WebView, Unit>() { // from class: com.google.accompanist.web.WebViewKt.WebView.7
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WebView webView) {
                invoke2(webView);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WebView it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }
        } : function1;
        final Function1<? super WebView, Unit> function5 = (i & 64) != 0 ? new Function1<WebView, Unit>() { // from class: com.google.accompanist.web.WebViewKt.WebView.8
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WebView webView) {
                invoke2(webView);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WebView it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }
        } : function2;
        if ((i & 128) != 0) {
            $composer2.startReplaceableGroup(1370705963);
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new AccompanistWebViewClient();
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv;
            }
            AccompanistWebViewClient client3 = (AccompanistWebViewClient) value$iv3;
            $composer2.endReplaceableGroup();
            $dirty2 &= -29360129;
            client2 = client3;
        } else {
            client2 = client;
        }
        if ((i & 256) != 0) {
            $composer2.startReplaceableGroup(1370706051);
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new AccompanistWebChromeClient();
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            AccompanistWebChromeClient chromeClient3 = (AccompanistWebChromeClient) value$iv2;
            $composer2.endReplaceableGroup();
            $dirty = $dirty2 & (-234881025);
            chromeClient2 = chromeClient3;
        } else {
            chromeClient2 = chromeClient;
            $dirty = $dirty2;
        }
        Function1<? super Context, ? extends WebView> function6 = (i & 512) != 0 ? null : function3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1401343589, $dirty, -1, "com.google.accompanist.web.WebView (WebView.kt:180)");
        }
        final WebView webView = state.getWebView$web_release();
        BackHandlerKt.BackHandler(captureBackPresses2 && navigator2.getCanGoBack(), new Function0<Unit>() { // from class: com.google.accompanist.web.WebViewKt.WebView.11
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
                WebView webView2 = webView;
                if (webView2 != null) {
                    webView2.goBack();
                }
            }
        }, $composer2, 0, 0);
        $composer2.startReplaceableGroup(1370706283);
        if (webView != null) {
            EffectsKt.LaunchedEffect(webView, navigator2, new WebViewKt$WebView$12$1(navigator2, webView, null), $composer2, (($dirty >> 9) & 112) | 520);
            EffectsKt.LaunchedEffect(webView, state, new WebViewKt$WebView$12$2(state, webView, null), $composer2, (($dirty << 3) & 112) | 520);
            Unit unit = Unit.INSTANCE;
        }
        $composer2.endReplaceableGroup();
        client2.setState$web_release(state);
        client2.setNavigator$web_release(navigator2);
        chromeClient2.setState$web_release(state);
        final Function1<? super Context, ? extends WebView> function7 = function6;
        final Function1<? super WebView, Unit> function8 = function4;
        final AccompanistWebChromeClient accompanistWebChromeClient = chromeClient2;
        final AccompanistWebViewClient accompanistWebViewClient = client2;
        Function1<Context, WebView> function9 = new Function1<Context, WebView>() { // from class: com.google.accompanist.web.WebViewKt.WebView.13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final WebView invoke(Context context) {
                WebView it;
                Intrinsics.checkNotNullParameter(context, "context");
                Function1<Context, WebView> function10 = function7;
                if (function10 == null || (it = function10.invoke(context)) == null) {
                    it = new WebView(context);
                }
                Function1<WebView, Unit> function11 = function8;
                FrameLayout.LayoutParams layoutParams2 = layoutParams;
                WebViewState webViewState = state;
                AccompanistWebChromeClient accompanistWebChromeClient2 = accompanistWebChromeClient;
                AccompanistWebViewClient accompanistWebViewClient2 = accompanistWebViewClient;
                WebView $this$invoke_u24lambda_u241 = it;
                function11.invoke($this$invoke_u24lambda_u241);
                $this$invoke_u24lambda_u241.setLayoutParams(layoutParams2);
                Bundle it2 = webViewState.getViewState();
                if (it2 != null) {
                    $this$invoke_u24lambda_u241.restoreState(it2);
                }
                $this$invoke_u24lambda_u241.setWebChromeClient(accompanistWebChromeClient2);
                $this$invoke_u24lambda_u241.setWebViewClient(accompanistWebViewClient2);
                state.setWebView$web_release(it);
                return it;
            }
        };
        $composer2.startReplaceableGroup(1370708191);
        boolean invalid$iv = ((($changed & 3670016) ^ 1572864) > 1048576 && $composer2.changedInstance(function5)) || ($changed & 1572864) == 1048576;
        Object it$iv3 = $composer2.rememberedValue();
        if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
            value$iv = (Function1) new Function1<WebView, Unit>() { // from class: com.google.accompanist.web.WebViewKt$WebView$14$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(WebView webView2) {
                    invoke2(webView2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(WebView it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    function5.invoke(it);
                }
            };
            $composer2.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv3;
        }
        $composer2.endReplaceableGroup();
        AndroidView_androidKt.AndroidView(function9, modifier2, null, (Function1) value$iv, null, $composer2, ($dirty >> 3) & 112, 20);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final boolean z = captureBackPresses2;
            final WebViewNavigator webViewNavigator = navigator2;
            final Function1<? super WebView, Unit> function10 = function4;
            final Function1<? super WebView, Unit> function11 = function5;
            final AccompanistWebChromeClient chromeClient4 = chromeClient2;
            final AccompanistWebViewClient accompanistWebViewClient2 = client2;
            final Function1<? super Context, ? extends WebView> function12 = function6;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.web.WebViewKt.WebView.15
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i2) {
                    WebViewKt.WebView(state, layoutParams, modifier3, z, webViewNavigator, function10, function11, accompanistWebViewClient2, chromeClient4, function12, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final WebContent.Url withUrl(WebContent $this$withUrl, String url) {
        Intrinsics.checkNotNullParameter($this$withUrl, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        return $this$withUrl instanceof WebContent.Url ? WebContent.Url.copy$default((WebContent.Url) $this$withUrl, url, null, 2, null) : new WebContent.Url(url, null, 2, null);
    }

    @Deprecated(message = "\naccompanist/web is deprecated and the API is no longer maintained. \nWe recommend forking the implementation and customising it to your needs. \nFor more information please visit https://google.github.io/accompanist/web\n")
    public static final WebViewNavigator rememberWebViewNavigator(CoroutineScope coroutineScope, Composer $composer, int $changed, int i) {
        CoroutineScope coroutineScope2;
        Object value$iv;
        Object value$iv$iv$iv;
        $composer.startReplaceableGroup(1602323198);
        if ((i & 1) != 0) {
            $composer.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation($composer, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv$iv = $composer.rememberedValue();
            if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
                $composer.updateRememberedValue(value$iv$iv$iv);
            } else {
                value$iv$iv$iv = it$iv$iv$iv;
            }
            $composer.endReplaceableGroup();
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
            coroutineScope2 = wrapper$iv.getCoroutineScope();
            $composer.endReplaceableGroup();
        } else {
            coroutineScope2 = coroutineScope;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1602323198, $changed, -1, "com.google.accompanist.web.rememberWebViewNavigator (WebView.kt:691)");
        }
        $composer.startReplaceableGroup(948350619);
        boolean invalid$iv = $composer.changed(coroutineScope2);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new WebViewNavigator(coroutineScope2);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        WebViewNavigator webViewNavigator = (WebViewNavigator) value$iv;
        $composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return webViewNavigator;
    }

    @Deprecated(message = "\naccompanist/web is deprecated and the API is no longer maintained. \nWe recommend forking the implementation and customising it to your needs. \nFor more information please visit https://google.github.io/accompanist/web\n")
    public static final WebViewState rememberWebViewState(String url, Map<String, String> map, Composer $composer, int $changed, int i) {
        Object value$iv;
        Intrinsics.checkNotNullParameter(url, "url");
        $composer.startReplaceableGroup(1238013775);
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1238013775, $changed, -1, "com.google.accompanist.web.rememberWebViewState (WebView.kt:736)");
        }
        $composer.startReplaceableGroup(400020825);
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new WebViewState(new WebContent.Url(url, map));
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        WebViewState $this$rememberWebViewState_u24lambda_u248 = (WebViewState) value$iv;
        $composer.endReplaceableGroup();
        $this$rememberWebViewState_u24lambda_u248.setContent(new WebContent.Url(url, map));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return $this$rememberWebViewState_u24lambda_u248;
    }

    @Deprecated(message = "\naccompanist/web is deprecated and the API is no longer maintained. \nWe recommend forking the implementation and customising it to your needs. \nFor more information please visit https://google.github.io/accompanist/web\n")
    public static final WebViewState rememberWebViewStateWithHTMLData(String data, String baseUrl, String encoding, String mimeType, String historyUrl, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        $composer.startReplaceableGroup(-1814294844);
        String baseUrl2 = (i & 2) != 0 ? null : baseUrl;
        String encoding2 = (i & 4) != 0 ? "utf-8" : encoding;
        String mimeType2 = (i & 8) != 0 ? null : mimeType;
        String historyUrl2 = (i & 16) != 0 ? null : historyUrl;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1814294844, $changed, -1, "com.google.accompanist.web.rememberWebViewStateWithHTMLData (WebView.kt:770)");
        }
        $composer.startReplaceableGroup(763872495);
        Object value$iv = $composer.rememberedValue();
        if (value$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new WebViewState(new WebContent.Data(data, baseUrl2, encoding2, mimeType2, historyUrl2));
            $composer.updateRememberedValue(value$iv);
        }
        WebViewState $this$rememberWebViewStateWithHTMLData_u24lambda_u2410 = (WebViewState) value$iv;
        $composer.endReplaceableGroup();
        $this$rememberWebViewStateWithHTMLData_u24lambda_u2410.setContent(new WebContent.Data(data, baseUrl2, encoding2, mimeType2, historyUrl2));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return $this$rememberWebViewStateWithHTMLData_u24lambda_u2410;
    }

    @Deprecated(message = "\naccompanist/web is deprecated and the API is no longer maintained. \nWe recommend forking the implementation and customising it to your needs. \nFor more information please visit https://google.github.io/accompanist/web\n")
    public static final WebViewState rememberWebViewState(String url, byte[] postData, Composer $composer, int $changed) {
        Object value$iv;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(postData, "postData");
        $composer.startReplaceableGroup(-710557916);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-710557916, $changed, -1, "com.google.accompanist.web.rememberWebViewState (WebView.kt:798)");
        }
        $composer.startReplaceableGroup(400022655);
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new WebViewState(new WebContent.Post(url, postData));
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        WebViewState $this$rememberWebViewState_u24lambda_u2412 = (WebViewState) value$iv;
        $composer.endReplaceableGroup();
        $this$rememberWebViewState_u24lambda_u2412.setContent(new WebContent.Post(url, postData));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return $this$rememberWebViewState_u24lambda_u2412;
    }

    @Deprecated(message = "\naccompanist/web is deprecated and the API is no longer maintained. \nWe recommend forking the implementation and customising it to your needs. \nFor more information please visit https://google.github.io/accompanist/web\n")
    public static final WebViewState rememberSaveableWebViewState(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(955189303);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(955189303, $changed, -1, "com.google.accompanist.web.rememberSaveableWebViewState (WebView.kt:830)");
        }
        WebViewState webViewState = (WebViewState) RememberSaveableKt.m3889rememberSaveable(new Object[0], (Saver) WebStateSaver, (String) null, (Function0) new Function0<WebViewState>() { // from class: com.google.accompanist.web.WebViewKt.rememberSaveableWebViewState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WebViewState invoke() {
                return new WebViewState(WebContent.NavigatorOnly.INSTANCE);
            }
        }, $composer, 3144, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return webViewState;
    }

    static {
        final String pageTitleKey = "pagetitle";
        final String lastLoadedUrlKey = "lastloaded";
        final String stateBundle = "bundle";
        WebStateSaver = MapSaverKt.mapSaver(new Function2<SaverScope, WebViewState, Map<String, ? extends Object>>() { // from class: com.google.accompanist.web.WebViewKt$WebStateSaver$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Map<String, Object> invoke(SaverScope mapSaver, WebViewState it) {
                Intrinsics.checkNotNullParameter(mapSaver, "$this$mapSaver");
                Intrinsics.checkNotNullParameter(it, "it");
                Bundle viewState = new Bundle();
                WebView webView$web_release = it.getWebView$web_release();
                if (webView$web_release != null) {
                    webView$web_release.saveState(viewState);
                }
                return MapsKt.mapOf(TuplesKt.m202to(pageTitleKey, it.getPageTitle()), TuplesKt.m202to(lastLoadedUrlKey, it.getLastLoadedUrl()), TuplesKt.m202to(stateBundle, viewState));
            }
        }, new Function1<Map<String, ? extends Object>, WebViewState>() { // from class: com.google.accompanist.web.WebViewKt$WebStateSaver$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final WebViewState invoke(Map<String, ? extends Object> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WebViewState $this$invoke_u24lambda_u240 = new WebViewState(WebContent.NavigatorOnly.INSTANCE);
                String str = pageTitleKey;
                String str2 = lastLoadedUrlKey;
                String str3 = stateBundle;
                $this$invoke_u24lambda_u240.setPageTitle$web_release((String) it.get(str));
                $this$invoke_u24lambda_u240.setLastLoadedUrl$web_release((String) it.get(str2));
                $this$invoke_u24lambda_u240.setViewState$web_release((Bundle) it.get(str3));
                return $this$invoke_u24lambda_u240;
            }
        });
    }

    public static final Saver<WebViewState, Object> getWebStateSaver() {
        return WebStateSaver;
    }
}
