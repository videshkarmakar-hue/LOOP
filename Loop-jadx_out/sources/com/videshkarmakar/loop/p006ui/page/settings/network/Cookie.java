package com.videshkarmakar.loop.p006ui.page.settings.network;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import com.videshkarmakar.loop.util.TextUtilKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewPage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m194d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006BK\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\rHÆ\u0003JO\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\u0006\u0010%\u001a\u00020\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010¨\u0006'"}, m195d2 = {"Lcom/videshkarmakar/loop/ui/page/settings/network/Cookie;", "", "url", "", "name", DownloadUtil.CookieScheme.VALUE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "domain", "includeSubdomains", "", DownloadUtil.CookieScheme.PATH, "secure", "expiry", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZJ)V", "getDomain", "()Ljava/lang/String;", "getExpiry", "()J", "getIncludeSubdomains", "()Z", "getName", "getPath", "getSecure", "getValue", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toNetscapeCookieString", "toString", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class Cookie {
    public static final int $stable = 0;
    private final String domain;
    private final long expiry;
    private final boolean includeSubdomains;
    private final String name;
    private final String path;
    private final boolean secure;
    private final String value;

    public Cookie() {
        this(null, null, null, false, null, false, 0L, 127, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIncludeSubdomains() {
        return this.includeSubdomains;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getSecure() {
        return this.secure;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getExpiry() {
        return this.expiry;
    }

    public final Cookie copy(String domain, String name, String value, boolean includeSubdomains, String path, boolean secure, long expiry) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(path, "path");
        return new Cookie(domain, name, value, includeSubdomains, path, secure, expiry);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) other;
        return Intrinsics.areEqual(this.domain, cookie.domain) && Intrinsics.areEqual(this.name, cookie.name) && Intrinsics.areEqual(this.value, cookie.value) && this.includeSubdomains == cookie.includeSubdomains && Intrinsics.areEqual(this.path, cookie.path) && this.secure == cookie.secure && this.expiry == cookie.expiry;
    }

    public int hashCode() {
        return (((((((((((this.domain.hashCode() * 31) + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + Cookie$$ExternalSyntheticBackport0.m188m(this.includeSubdomains)) * 31) + this.path.hashCode()) * 31) + Cookie$$ExternalSyntheticBackport0.m188m(this.secure)) * 31) + Cookie$$ExternalSyntheticBackport1.m189m(this.expiry);
    }

    public String toString() {
        return "Cookie(domain=" + this.domain + ", name=" + this.name + ", value=" + this.value + ", includeSubdomains=" + this.includeSubdomains + ", path=" + this.path + ", secure=" + this.secure + ", expiry=" + this.expiry + ")";
    }

    public Cookie(String domain, String name, String value, boolean includeSubdomains, String path, boolean secure, long expiry) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(path, "path");
        this.domain = domain;
        this.name = name;
        this.value = value;
        this.includeSubdomains = includeSubdomains;
        this.path = path;
        this.secure = secure;
        this.expiry = expiry;
    }

    public /* synthetic */ Cookie(String str, String str2, String str3, boolean z, String str4, boolean z2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) == 0 ? str3 : "", (i & 8) != 0 ? true : z, (i & 16) != 0 ? "/" : str4, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? 0L : j);
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public final boolean getIncludeSubdomains() {
        return this.includeSubdomains;
    }

    public final String getPath() {
        return this.path;
    }

    public final boolean getSecure() {
        return this.secure;
    }

    public final long getExpiry() {
        return this.expiry;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Cookie(String url, String name, String value) {
        this(WebViewPageKt.toDomain(url), name, value, false, null, false, 0L, 120, null);
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    public final String toNetscapeCookieString() {
        String str = this.domain;
        String upperCase = String.valueOf(this.includeSubdomains).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String str2 = this.path;
        String upperCase2 = String.valueOf(this.secure).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
        return TextUtilKt.connectWithDelimiter(new String[]{str, upperCase, str2, upperCase2, String.valueOf(this.expiry), this.name, this.value}, "\t");
    }
}
