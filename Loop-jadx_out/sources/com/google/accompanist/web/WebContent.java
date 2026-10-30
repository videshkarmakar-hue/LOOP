package com.google.accompanist.web;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebView.kt */
/* JADX INFO: loaded from: classes18.dex */
@Deprecated(message = "\naccompanist/web is deprecated and the API is no longer maintained. \nWe recommend forking the implementation and customising it to your needs. \nFor more information please visit https://google.github.io/accompanist/web\n")
@Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007\u0082\u0001\u0004\t\n\u000b\f¨\u0006\r"}, m195d2 = {"Lcom/google/accompanist/web/WebContent;", "", "()V", "getCurrentUrl", "", "Data", "NavigatorOnly", "Post", "Url", "Lcom/google/accompanist/web/WebContent$Data;", "Lcom/google/accompanist/web/WebContent$NavigatorOnly;", "Lcom/google/accompanist/web/WebContent$Post;", "Lcom/google/accompanist/web/WebContent$Url;", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class WebContent {
    public static final int $stable = 0;

    public /* synthetic */ WebContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private WebContent() {
    }

    /* JADX INFO: compiled from: WebView.kt */
    @Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J)\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m195d2 = {"Lcom/google/accompanist/web/WebContent$Url;", "Lcom/google/accompanist/web/WebContent;", "url", "", "additionalHttpHeaders", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getAdditionalHttpHeaders", "()Ljava/util/Map;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class Url extends WebContent {
        public static final int $stable = 8;
        private final Map<String, String> additionalHttpHeaders;
        private final String url;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Url copy$default(Url url, String str, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = url.url;
            }
            if ((i & 2) != 0) {
                map = url.additionalHttpHeaders;
            }
            return url.copy(str, map);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final Map<String, String> component2() {
            return this.additionalHttpHeaders;
        }

        public final Url copy(String url, Map<String, String> additionalHttpHeaders) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(additionalHttpHeaders, "additionalHttpHeaders");
            return new Url(url, additionalHttpHeaders);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Url)) {
                return false;
            }
            Url url = (Url) other;
            return Intrinsics.areEqual(this.url, url.url) && Intrinsics.areEqual(this.additionalHttpHeaders, url.additionalHttpHeaders);
        }

        public int hashCode() {
            return (this.url.hashCode() * 31) + this.additionalHttpHeaders.hashCode();
        }

        public String toString() {
            return "Url(url=" + this.url + ", additionalHttpHeaders=" + this.additionalHttpHeaders + ')';
        }

        public /* synthetic */ Url(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? MapsKt.emptyMap() : map);
        }

        public final String getUrl() {
            return this.url;
        }

        public final Map<String, String> getAdditionalHttpHeaders() {
            return this.additionalHttpHeaders;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Url(String url, Map<String, String> additionalHttpHeaders) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(additionalHttpHeaders, "additionalHttpHeaders");
            this.url = url;
            this.additionalHttpHeaders = additionalHttpHeaders;
        }
    }

    /* JADX INFO: compiled from: WebView.kt */
    @Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, m195d2 = {"Lcom/google/accompanist/web/WebContent$Data;", "Lcom/google/accompanist/web/WebContent;", "data", "", "baseUrl", "encoding", "mimeType", "historyUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "getData", "getEncoding", "getHistoryUrl", "getMimeType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class Data extends WebContent {
        public static final int $stable = 0;
        private final String baseUrl;
        private final String data;
        private final String encoding;
        private final String historyUrl;
        private final String mimeType;

        public static /* synthetic */ Data copy$default(Data data, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = data.data;
            }
            if ((i & 2) != 0) {
                str2 = data.baseUrl;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = data.encoding;
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                str4 = data.mimeType;
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str5 = data.historyUrl;
            }
            return data.copy(str, str6, str7, str8, str5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getData() {
            return this.data;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getBaseUrl() {
            return this.baseUrl;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getEncoding() {
            return this.encoding;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getHistoryUrl() {
            return this.historyUrl;
        }

        public final Data copy(String data, String baseUrl, String encoding, String mimeType, String historyUrl) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(encoding, "encoding");
            return new Data(data, baseUrl, encoding, mimeType, historyUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return Intrinsics.areEqual(this.data, data.data) && Intrinsics.areEqual(this.baseUrl, data.baseUrl) && Intrinsics.areEqual(this.encoding, data.encoding) && Intrinsics.areEqual(this.mimeType, data.mimeType) && Intrinsics.areEqual(this.historyUrl, data.historyUrl);
        }

        public int hashCode() {
            return (((((((this.data.hashCode() * 31) + (this.baseUrl == null ? 0 : this.baseUrl.hashCode())) * 31) + this.encoding.hashCode()) * 31) + (this.mimeType == null ? 0 : this.mimeType.hashCode())) * 31) + (this.historyUrl != null ? this.historyUrl.hashCode() : 0);
        }

        public String toString() {
            return "Data(data=" + this.data + ", baseUrl=" + this.baseUrl + ", encoding=" + this.encoding + ", mimeType=" + this.mimeType + ", historyUrl=" + this.historyUrl + ')';
        }

        public /* synthetic */ Data(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? "utf-8" : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
        }

        public final String getData() {
            return this.data;
        }

        public final String getBaseUrl() {
            return this.baseUrl;
        }

        public final String getEncoding() {
            return this.encoding;
        }

        public final String getMimeType() {
            return this.mimeType;
        }

        public final String getHistoryUrl() {
            return this.historyUrl;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Data(String data, String baseUrl, String encoding, String mimeType, String historyUrl) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(encoding, "encoding");
            this.data = data;
            this.baseUrl = baseUrl;
            this.encoding = encoding;
            this.mimeType = mimeType;
            this.historyUrl = historyUrl;
        }
    }

    /* JADX INFO: compiled from: WebView.kt */
    @Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m195d2 = {"Lcom/google/accompanist/web/WebContent$Post;", "Lcom/google/accompanist/web/WebContent;", "url", "", "postData", "", "(Ljava/lang/String;[B)V", "getPostData", "()[B", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class Post extends WebContent {
        public static final int $stable = 8;
        private final byte[] postData;
        private final String url;

        public static /* synthetic */ Post copy$default(Post post, String str, byte[] bArr, int i, Object obj) {
            if ((i & 1) != 0) {
                str = post.url;
            }
            if ((i & 2) != 0) {
                bArr = post.postData;
            }
            return post.copy(str, bArr);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final byte[] getPostData() {
            return this.postData;
        }

        public final Post copy(String url, byte[] postData) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(postData, "postData");
            return new Post(url, postData);
        }

        public String toString() {
            return "Post(url=" + this.url + ", postData=" + Arrays.toString(this.postData) + ')';
        }

        public final String getUrl() {
            return this.url;
        }

        public final byte[] getPostData() {
            return this.postData;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Post(String url, byte[] postData) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(postData, "postData");
            this.url = url;
            this.postData = postData;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.google.accompanist.web.WebContent.Post");
            return Intrinsics.areEqual(this.url, ((Post) other).url) && Arrays.equals(this.postData, ((Post) other).postData);
        }

        public int hashCode() {
            int result = this.url.hashCode();
            return (result * 31) + Arrays.hashCode(this.postData);
        }
    }

    @Deprecated(message = "Use state.lastLoadedUrl instead")
    public final String getCurrentUrl() {
        if (this instanceof Url) {
            return ((Url) this).getUrl();
        }
        if (this instanceof Data) {
            return ((Data) this).getBaseUrl();
        }
        if (this instanceof Post) {
            return ((Post) this).getUrl();
        }
        if (this instanceof NavigatorOnly) {
            throw new IllegalStateException("Unsupported");
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: compiled from: WebView.kt */
    @Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m195d2 = {"Lcom/google/accompanist/web/WebContent$NavigatorOnly;", "Lcom/google/accompanist/web/WebContent;", "()V", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class NavigatorOnly extends WebContent {
        public static final int $stable = 0;
        public static final NavigatorOnly INSTANCE = new NavigatorOnly();

        private NavigatorOnly() {
            super(null);
        }
    }
}
