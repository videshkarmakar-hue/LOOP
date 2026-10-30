package com.google.accompanist.web;

import android.webkit.WebView;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: WebView.kt */
/* JADX INFO: loaded from: classes18.dex */
@Deprecated(message = "\naccompanist/web is deprecated and the API is no longer maintained. \nWe recommend forking the implementation and customising it to your needs. \nFor more information please visit https://google.github.io/accompanist/web\n")
@Metadata(m194d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001-B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J>\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0018J$\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00182\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180 J\u0006\u0010!\u001a\u00020\u0016J\u0006\u0010\"\u001a\u00020\u0016J\u0016\u0010#\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020\u0016J\u0006\u0010'\u001a\u00020\u0016J\u0014\u0010(\u001a\u00020)*\u00020*H\u0080@¢\u0006\u0004\b+\u0010,R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, m195d2 = {"Lcom/google/accompanist/web/WebViewNavigator;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "<set-?>", "", "canGoBack", "getCanGoBack", "()Z", "setCanGoBack$web_release", "(Z)V", "canGoBack$delegate", "Landroidx/compose/runtime/MutableState;", "canGoForward", "getCanGoForward", "setCanGoForward$web_release", "canGoForward$delegate", "navigationEvents", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent;", "loadHtml", "", "html", "", "baseUrl", "mimeType", "encoding", "historyUrl", "loadUrl", "url", "additionalHttpHeaders", "", "navigateBack", "navigateForward", "postUrl", "postData", "", "reload", "stopLoading", "handleNavigationEvents", "", "Landroid/webkit/WebView;", "handleNavigationEvents$web_release", "(Landroid/webkit/WebView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "NavigationEvent", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class WebViewNavigator {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: canGoBack$delegate, reason: from kotlin metadata */
    private final MutableState canGoBack;

    /* JADX INFO: renamed from: canGoForward$delegate, reason: from kotlin metadata */
    private final MutableState canGoForward;
    private final CoroutineScope coroutineScope;
    private final MutableSharedFlow<NavigationEvent> navigationEvents;

    public WebViewNavigator(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
        this.navigationEvents = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this.canGoBack = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.canGoForward = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: WebView.kt */
    @Metadata(m194d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0007\u0002\u0003\u0004\u0005\u0006\u0007\b\u0082\u0001\u0007\t\n\u000b\f\r\u000e\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, m195d2 = {"Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent;", "", "Back", "Forward", "LoadHtml", "LoadUrl", "PostUrl", "Reload", "StopLoading", "Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent$Back;", "Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent$Forward;", "Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent$LoadHtml;", "Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent$LoadUrl;", "Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent$PostUrl;", "Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent$Reload;", "Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent$StopLoading;", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    interface NavigationEvent {

        /* JADX INFO: compiled from: WebView.kt */
        @Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m195d2 = {"Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent$Back;", "Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent;", "()V", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Back implements NavigationEvent {
            public static final int $stable = 0;
            public static final Back INSTANCE = new Back();

            private Back() {
            }
        }

        /* JADX INFO: compiled from: WebView.kt */
        @Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m195d2 = {"Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent$Forward;", "Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent;", "()V", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Forward implements NavigationEvent {
            public static final int $stable = 0;
            public static final Forward INSTANCE = new Forward();

            private Forward() {
            }
        }

        /* JADX INFO: compiled from: WebView.kt */
        @Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m195d2 = {"Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent$Reload;", "Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent;", "()V", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Reload implements NavigationEvent {
            public static final int $stable = 0;
            public static final Reload INSTANCE = new Reload();

            private Reload() {
            }
        }

        /* JADX INFO: compiled from: WebView.kt */
        @Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m195d2 = {"Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent$StopLoading;", "Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent;", "()V", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class StopLoading implements NavigationEvent {
            public static final int $stable = 0;
            public static final StopLoading INSTANCE = new StopLoading();

            private StopLoading() {
            }
        }

        /* JADX INFO: compiled from: WebView.kt */
        @Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J)\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m195d2 = {"Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent$LoadUrl;", "Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent;", "url", "", "additionalHttpHeaders", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getAdditionalHttpHeaders", "()Ljava/util/Map;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final /* data */ class LoadUrl implements NavigationEvent {
            public static final int $stable = 8;
            private final Map<String, String> additionalHttpHeaders;
            private final String url;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ LoadUrl copy$default(LoadUrl loadUrl, String str, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = loadUrl.url;
                }
                if ((i & 2) != 0) {
                    map = loadUrl.additionalHttpHeaders;
                }
                return loadUrl.copy(str, map);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            public final Map<String, String> component2() {
                return this.additionalHttpHeaders;
            }

            public final LoadUrl copy(String url, Map<String, String> additionalHttpHeaders) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(additionalHttpHeaders, "additionalHttpHeaders");
                return new LoadUrl(url, additionalHttpHeaders);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadUrl)) {
                    return false;
                }
                LoadUrl loadUrl = (LoadUrl) other;
                return Intrinsics.areEqual(this.url, loadUrl.url) && Intrinsics.areEqual(this.additionalHttpHeaders, loadUrl.additionalHttpHeaders);
            }

            public int hashCode() {
                return (this.url.hashCode() * 31) + this.additionalHttpHeaders.hashCode();
            }

            public String toString() {
                return "LoadUrl(url=" + this.url + ", additionalHttpHeaders=" + this.additionalHttpHeaders + ')';
            }

            public LoadUrl(String url, Map<String, String> additionalHttpHeaders) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(additionalHttpHeaders, "additionalHttpHeaders");
                this.url = url;
                this.additionalHttpHeaders = additionalHttpHeaders;
            }

            public /* synthetic */ LoadUrl(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? MapsKt.emptyMap() : map);
            }

            public final String getUrl() {
                return this.url;
            }

            public final Map<String, String> getAdditionalHttpHeaders() {
                return this.additionalHttpHeaders;
            }
        }

        /* JADX INFO: compiled from: WebView.kt */
        @Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, m195d2 = {"Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent$LoadHtml;", "Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent;", "html", "", "baseUrl", "mimeType", "encoding", "historyUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "getEncoding", "getHistoryUrl", "getHtml", "getMimeType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final /* data */ class LoadHtml implements NavigationEvent {
            public static final int $stable = 0;
            private final String baseUrl;
            private final String encoding;
            private final String historyUrl;
            private final String html;
            private final String mimeType;

            public static /* synthetic */ LoadHtml copy$default(LoadHtml loadHtml, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = loadHtml.html;
                }
                if ((i & 2) != 0) {
                    str2 = loadHtml.baseUrl;
                }
                String str6 = str2;
                if ((i & 4) != 0) {
                    str3 = loadHtml.mimeType;
                }
                String str7 = str3;
                if ((i & 8) != 0) {
                    str4 = loadHtml.encoding;
                }
                String str8 = str4;
                if ((i & 16) != 0) {
                    str5 = loadHtml.historyUrl;
                }
                return loadHtml.copy(str, str6, str7, str8, str5);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getHtml() {
                return this.html;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getBaseUrl() {
                return this.baseUrl;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getMimeType() {
                return this.mimeType;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getEncoding() {
                return this.encoding;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getHistoryUrl() {
                return this.historyUrl;
            }

            public final LoadHtml copy(String html, String baseUrl, String mimeType, String encoding, String historyUrl) {
                Intrinsics.checkNotNullParameter(html, "html");
                return new LoadHtml(html, baseUrl, mimeType, encoding, historyUrl);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadHtml)) {
                    return false;
                }
                LoadHtml loadHtml = (LoadHtml) other;
                return Intrinsics.areEqual(this.html, loadHtml.html) && Intrinsics.areEqual(this.baseUrl, loadHtml.baseUrl) && Intrinsics.areEqual(this.mimeType, loadHtml.mimeType) && Intrinsics.areEqual(this.encoding, loadHtml.encoding) && Intrinsics.areEqual(this.historyUrl, loadHtml.historyUrl);
            }

            public int hashCode() {
                return (((((((this.html.hashCode() * 31) + (this.baseUrl == null ? 0 : this.baseUrl.hashCode())) * 31) + (this.mimeType == null ? 0 : this.mimeType.hashCode())) * 31) + (this.encoding == null ? 0 : this.encoding.hashCode())) * 31) + (this.historyUrl != null ? this.historyUrl.hashCode() : 0);
            }

            public String toString() {
                return "LoadHtml(html=" + this.html + ", baseUrl=" + this.baseUrl + ", mimeType=" + this.mimeType + ", encoding=" + this.encoding + ", historyUrl=" + this.historyUrl + ')';
            }

            public LoadHtml(String html, String baseUrl, String mimeType, String encoding, String historyUrl) {
                Intrinsics.checkNotNullParameter(html, "html");
                this.html = html;
                this.baseUrl = baseUrl;
                this.mimeType = mimeType;
                this.encoding = encoding;
                this.historyUrl = historyUrl;
            }

            public /* synthetic */ LoadHtml(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? "utf-8" : str4, (i & 16) != 0 ? null : str5);
            }

            public final String getHtml() {
                return this.html;
            }

            public final String getBaseUrl() {
                return this.baseUrl;
            }

            public final String getMimeType() {
                return this.mimeType;
            }

            public final String getEncoding() {
                return this.encoding;
            }

            public final String getHistoryUrl() {
                return this.historyUrl;
            }
        }

        /* JADX INFO: compiled from: WebView.kt */
        @Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m195d2 = {"Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent$PostUrl;", "Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent;", "url", "", "postData", "", "(Ljava/lang/String;[B)V", "getPostData", "()[B", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final /* data */ class PostUrl implements NavigationEvent {
            public static final int $stable = 8;
            private final byte[] postData;
            private final String url;

            public static /* synthetic */ PostUrl copy$default(PostUrl postUrl, String str, byte[] bArr, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = postUrl.url;
                }
                if ((i & 2) != 0) {
                    bArr = postUrl.postData;
                }
                return postUrl.copy(str, bArr);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final byte[] getPostData() {
                return this.postData;
            }

            public final PostUrl copy(String url, byte[] postData) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(postData, "postData");
                return new PostUrl(url, postData);
            }

            public String toString() {
                return "PostUrl(url=" + this.url + ", postData=" + Arrays.toString(this.postData) + ')';
            }

            public PostUrl(String url, byte[] postData) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(postData, "postData");
                this.url = url;
                this.postData = postData;
            }

            public final String getUrl() {
                return this.url;
            }

            public final byte[] getPostData() {
                return this.postData;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                    return false;
                }
                Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.google.accompanist.web.WebViewNavigator.NavigationEvent.PostUrl");
                return Intrinsics.areEqual(this.url, ((PostUrl) other).url) && Arrays.equals(this.postData, ((PostUrl) other).postData);
            }

            public int hashCode() {
                int result = this.url.hashCode();
                return (result * 31) + Arrays.hashCode(this.postData);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object handleNavigationEvents$web_release(WebView $this$handleNavigationEvents, Continuation<?> continuation) {
        WebViewNavigator$handleNavigationEvents$1 webViewNavigator$handleNavigationEvents$1;
        if (continuation instanceof WebViewNavigator$handleNavigationEvents$1) {
            webViewNavigator$handleNavigationEvents$1 = (WebViewNavigator$handleNavigationEvents$1) continuation;
            if ((webViewNavigator$handleNavigationEvents$1.label & Integer.MIN_VALUE) != 0) {
                webViewNavigator$handleNavigationEvents$1.label -= Integer.MIN_VALUE;
            } else {
                webViewNavigator$handleNavigationEvents$1 = new WebViewNavigator$handleNavigationEvents$1(this, continuation);
            }
        } else {
            webViewNavigator$handleNavigationEvents$1 = new WebViewNavigator$handleNavigationEvents$1(this, continuation);
        }
        WebViewNavigator$handleNavigationEvents$1 webViewNavigator$handleNavigationEvents$2 = webViewNavigator$handleNavigationEvents$1;
        Object $result = webViewNavigator$handleNavigationEvents$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (webViewNavigator$handleNavigationEvents$2.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MainCoroutineDispatcher main = Dispatchers.getMain();
                WebViewNavigator$handleNavigationEvents$2 webViewNavigator$handleNavigationEvents$3 = new WebViewNavigator$handleNavigationEvents$2(this, $this$handleNavigationEvents, null);
                webViewNavigator$handleNavigationEvents$2.label = 1;
                if (BuildersKt.withContext(main, webViewNavigator$handleNavigationEvents$3, webViewNavigator$handleNavigationEvents$2) == coroutine_suspended) {
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

    public final boolean getCanGoBack() {
        State $this$getValue$iv = this.canGoBack;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setCanGoBack$web_release(boolean z) {
        MutableState $this$setValue$iv = this.canGoBack;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    public final boolean getCanGoForward() {
        State $this$getValue$iv = this.canGoForward;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setCanGoForward$web_release(boolean z) {
        MutableState $this$setValue$iv = this.canGoForward;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: com.google.accompanist.web.WebViewNavigator$loadUrl$1 */
    /* JADX INFO: compiled from: WebView.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.google.accompanist.web.WebViewNavigator$loadUrl$1", m210f = "WebView.kt", m211i = {}, m212l = {606}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C27211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $additionalHttpHeaders;
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C27211(String str, Map<String, String> map, Continuation<? super C27211> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$additionalHttpHeaders = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebViewNavigator.this.new C27211(this.$url, this.$additionalHttpHeaders, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (WebViewNavigator.this.navigationEvents.emit(new NavigationEvent.LoadUrl(this.$url, this.$additionalHttpHeaders), this) == coroutine_suspended) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadUrl$default(WebViewNavigator webViewNavigator, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        webViewNavigator.loadUrl(str, map);
    }

    public final void loadUrl(String url, Map<String, String> additionalHttpHeaders) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(additionalHttpHeaders, "additionalHttpHeaders");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C27211(url, additionalHttpHeaders, null), 3, null);
    }

    /* JADX INFO: renamed from: com.google.accompanist.web.WebViewNavigator$loadHtml$1 */
    /* JADX INFO: compiled from: WebView.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.google.accompanist.web.WebViewNavigator$loadHtml$1", m210f = "WebView.kt", m211i = {}, m212l = {623}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C27201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $baseUrl;
        final /* synthetic */ String $encoding;
        final /* synthetic */ String $historyUrl;
        final /* synthetic */ String $html;
        final /* synthetic */ String $mimeType;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C27201(String str, String str2, String str3, String str4, String str5, Continuation<? super C27201> continuation) {
            super(2, continuation);
            this.$html = str;
            this.$baseUrl = str2;
            this.$mimeType = str3;
            this.$encoding = str4;
            this.$historyUrl = str5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebViewNavigator.this.new C27201(this.$html, this.$baseUrl, this.$mimeType, this.$encoding, this.$historyUrl, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (WebViewNavigator.this.navigationEvents.emit(new NavigationEvent.LoadHtml(this.$html, this.$baseUrl, this.$mimeType, this.$encoding, this.$historyUrl), this) == coroutine_suspended) {
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

    public final void loadHtml(String html, String baseUrl, String mimeType, String encoding, String historyUrl) {
        Intrinsics.checkNotNullParameter(html, "html");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C27201(html, baseUrl, mimeType, encoding, historyUrl, null), 3, null);
    }

    /* JADX INFO: renamed from: com.google.accompanist.web.WebViewNavigator$postUrl$1 */
    /* JADX INFO: compiled from: WebView.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.google.accompanist.web.WebViewNavigator$postUrl$1", m210f = "WebView.kt", m211i = {}, m212l = {640}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C27241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $postData;
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C27241(String str, byte[] bArr, Continuation<? super C27241> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$postData = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebViewNavigator.this.new C27241(this.$url, this.$postData, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (WebViewNavigator.this.navigationEvents.emit(new NavigationEvent.PostUrl(this.$url, this.$postData), this) == coroutine_suspended) {
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

    public final void postUrl(String url, byte[] postData) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(postData, "postData");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C27241(url, postData, null), 3, null);
    }

    /* JADX INFO: renamed from: com.google.accompanist.web.WebViewNavigator$navigateBack$1 */
    /* JADX INFO: compiled from: WebView.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.google.accompanist.web.WebViewNavigator$navigateBack$1", m210f = "WebView.kt", m211i = {}, m212l = {653}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C27221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C27221(Continuation<? super C27221> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebViewNavigator.this.new C27221(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27221) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (WebViewNavigator.this.navigationEvents.emit(NavigationEvent.Back.INSTANCE, this) == coroutine_suspended) {
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

    public final void navigateBack() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C27221(null), 3, null);
    }

    /* JADX INFO: renamed from: com.google.accompanist.web.WebViewNavigator$navigateForward$1 */
    /* JADX INFO: compiled from: WebView.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.google.accompanist.web.WebViewNavigator$navigateForward$1", m210f = "WebView.kt", m211i = {}, m212l = {660}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C27231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C27231(Continuation<? super C27231> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebViewNavigator.this.new C27231(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27231) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (WebViewNavigator.this.navigationEvents.emit(NavigationEvent.Forward.INSTANCE, this) == coroutine_suspended) {
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

    public final void navigateForward() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C27231(null), 3, null);
    }

    /* JADX INFO: renamed from: com.google.accompanist.web.WebViewNavigator$reload$1 */
    /* JADX INFO: compiled from: WebView.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.google.accompanist.web.WebViewNavigator$reload$1", m210f = "WebView.kt", m211i = {}, m212l = {667}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C27251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C27251(Continuation<? super C27251> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebViewNavigator.this.new C27251(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (WebViewNavigator.this.navigationEvents.emit(NavigationEvent.Reload.INSTANCE, this) == coroutine_suspended) {
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

    public final void reload() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C27251(null), 3, null);
    }

    /* JADX INFO: renamed from: com.google.accompanist.web.WebViewNavigator$stopLoading$1 */
    /* JADX INFO: compiled from: WebView.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.google.accompanist.web.WebViewNavigator$stopLoading$1", m210f = "WebView.kt", m211i = {}, m212l = {674}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C27261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C27261(Continuation<? super C27261> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebViewNavigator.this.new C27261(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27261) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (WebViewNavigator.this.navigationEvents.emit(NavigationEvent.StopLoading.INSTANCE, this) == coroutine_suspended) {
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

    public final void stopLoading() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C27261(null), 3, null);
    }
}
