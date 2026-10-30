package coil.network;

import androidx.constraintlayout.widget.ConstraintLayout;
import coil.disk.DiskLruCache;
import coil.util.Time;
import coil.util.Utils;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: CacheStrategy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, m195d2 = {"Lcoil/network/CacheStrategy;", "", "networkRequest", "Lokhttp3/Request;", "cacheResponse", "Lcoil/network/CacheResponse;", "(Lokhttp3/Request;Lcoil/network/CacheResponse;)V", "getCacheResponse", "()Lcoil/network/CacheResponse;", "getNetworkRequest", "()Lokhttp3/Request;", "Companion", "Factory", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CacheStrategy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CacheResponse cacheResponse;
    private final Request networkRequest;

    public /* synthetic */ CacheStrategy(Request request, CacheResponse cacheResponse, DefaultConstructorMarker defaultConstructorMarker) {
        this(request, cacheResponse);
    }

    private CacheStrategy(Request networkRequest, CacheResponse cacheResponse) {
        this.networkRequest = networkRequest;
        this.cacheResponse = cacheResponse;
    }

    public final Request getNetworkRequest() {
        return this.networkRequest;
    }

    public final CacheResponse getCacheResponse() {
        return this.cacheResponse;
    }

    /* JADX INFO: compiled from: CacheStrategy.kt */
    @Metadata(m194d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m195d2 = {"Lcoil/network/CacheStrategy$Factory;", "", "request", "Lokhttp3/Request;", "cacheResponse", "Lcoil/network/CacheResponse;", "(Lokhttp3/Request;Lcoil/network/CacheResponse;)V", "ageSeconds", "", "etag", "", "expires", "Ljava/util/Date;", "lastModified", "lastModifiedString", "receivedResponseMillis", "", "sentRequestMillis", "servedDate", "servedDateString", "cacheResponseAge", "compute", "Lcoil/network/CacheStrategy;", "computeFreshnessLifetime", "hasConditions", "", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Factory {
        private int ageSeconds;
        private final CacheResponse cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        private long receivedResponseMillis;
        private final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(Request request, CacheResponse cacheResponse) {
            this.request = request;
            this.cacheResponse = cacheResponse;
            this.ageSeconds = -1;
            if (this.cacheResponse == null) {
                return;
            }
            this.sentRequestMillis = this.cacheResponse.getSentRequestAtMillis();
            this.receivedResponseMillis = this.cacheResponse.getReceivedResponseAtMillis();
            Headers headers = this.cacheResponse.getResponseHeaders();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                if (StringsKt.equals(name, "Date", true)) {
                    this.servedDate = headers.getDate("Date");
                    this.servedDateString = headers.value(i);
                } else if (StringsKt.equals(name, "Expires", true)) {
                    this.expires = headers.getDate("Expires");
                } else if (StringsKt.equals(name, "Last-Modified", true)) {
                    this.lastModified = headers.getDate("Last-Modified");
                    this.lastModifiedString = headers.value(i);
                } else if (StringsKt.equals(name, "ETag", true)) {
                    this.etag = headers.value(i);
                } else if (StringsKt.equals(name, "Age", true)) {
                    this.ageSeconds = Utils.toNonNegativeInt(headers.value(i), -1);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final CacheStrategy compute() {
            String str;
            String str2;
            CacheResponse cacheResponse = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            Object[] objArr5 = 0;
            Object[] objArr6 = 0;
            Object[] objArr7 = 0;
            Object[] objArr8 = 0;
            Object[] objArr9 = 0;
            Object[] objArr10 = 0;
            Object[] objArr11 = 0;
            Object[] objArr12 = 0;
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, cacheResponse, objArr12 == true ? 1 : 0);
            }
            if (this.request.isHttps() && !this.cacheResponse.getIsTls()) {
                return new CacheStrategy(this.request, objArr11 == true ? 1 : 0, objArr10 == true ? 1 : 0);
            }
            CacheControl cacheControl = this.cacheResponse.getCacheControl();
            if (!CacheStrategy.INSTANCE.isCacheable(this.request, this.cacheResponse)) {
                return new CacheStrategy(this.request, objArr9 == true ? 1 : 0, objArr8 == true ? 1 : 0);
            }
            CacheControl cacheControl2 = this.request.cacheControl();
            if (cacheControl2.noCache() || hasConditions(this.request)) {
                return new CacheStrategy(this.request, objArr7 == true ? 1 : 0, objArr6 == true ? 1 : 0);
            }
            long jCacheResponseAge = cacheResponseAge();
            long jComputeFreshnessLifetime = computeFreshnessLifetime();
            if (cacheControl2.maxAgeSeconds() != -1) {
                jComputeFreshnessLifetime = Math.min(jComputeFreshnessLifetime, TimeUnit.SECONDS.toMillis(cacheControl2.maxAgeSeconds()));
            }
            long millis = 0;
            if (cacheControl2.minFreshSeconds() != -1) {
                millis = TimeUnit.SECONDS.toMillis(cacheControl2.minFreshSeconds());
            }
            long millis2 = 0;
            if (!cacheControl.mustRevalidate() && cacheControl2.maxStaleSeconds() != -1) {
                millis2 = TimeUnit.SECONDS.toMillis(cacheControl2.maxStaleSeconds());
            }
            if (!cacheControl.noCache() && jCacheResponseAge + millis < jComputeFreshnessLifetime + millis2) {
                return new CacheStrategy(objArr5 == true ? 1 : 0, this.cacheResponse, objArr4 == true ? 1 : 0);
            }
            if (this.etag != null) {
                str = "If-None-Match";
                String str3 = this.etag;
                Intrinsics.checkNotNull(str3);
                str2 = str3;
            } else if (this.lastModified != null) {
                str = "If-Modified-Since";
                String str4 = this.lastModifiedString;
                Intrinsics.checkNotNull(str4);
                str2 = str4;
            } else {
                if (this.servedDate == null) {
                    return new CacheStrategy(this.request, objArr2 == true ? 1 : 0, objArr == true ? 1 : 0);
                }
                str = "If-Modified-Since";
                String str5 = this.servedDateString;
                Intrinsics.checkNotNull(str5);
                str2 = str5;
            }
            return new CacheStrategy(this.request.newBuilder().addHeader(str, str2).build(), this.cacheResponse, objArr3 == true ? 1 : 0);
        }

        private final long computeFreshnessLifetime() {
            CacheResponse cacheResponse = this.cacheResponse;
            Intrinsics.checkNotNull(cacheResponse);
            CacheControl responseCaching = cacheResponse.getCacheControl();
            if (responseCaching.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(responseCaching.maxAgeSeconds());
            }
            Date expires = this.expires;
            if (expires != null) {
                Date date = this.servedDate;
                long servedMillis = date != null ? date.getTime() : this.receivedResponseMillis;
                long delta = expires.getTime() - servedMillis;
                if (delta > 0) {
                    return delta;
                }
                return 0L;
            }
            if (this.lastModified == null || this.request.url().query() != null) {
                return 0L;
            }
            Date date2 = this.servedDate;
            long servedMillis2 = date2 != null ? date2.getTime() : this.sentRequestMillis;
            Date date3 = this.lastModified;
            Intrinsics.checkNotNull(date3);
            long delta2 = servedMillis2 - date3.getTime();
            if (delta2 > 0) {
                return delta2 / ((long) 10);
            }
            return 0L;
        }

        private final long cacheResponseAge() {
            long receivedAge;
            Date servedDate = this.servedDate;
            long apparentReceivedAge = servedDate != null ? Math.max(0L, this.receivedResponseMillis - servedDate.getTime()) : 0L;
            if (this.ageSeconds != -1) {
                receivedAge = Math.max(apparentReceivedAge, TimeUnit.SECONDS.toMillis(this.ageSeconds));
            } else {
                receivedAge = apparentReceivedAge;
            }
            long responseDuration = this.receivedResponseMillis - this.sentRequestMillis;
            long residentDuration = Time.INSTANCE.currentMillis() - this.receivedResponseMillis;
            return receivedAge + responseDuration + residentDuration;
        }

        private final boolean hasConditions(Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }
    }

    /* JADX INFO: compiled from: CacheStrategy.kt */
    @Metadata(m194d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0012"}, m195d2 = {"Lcoil/network/CacheStrategy$Companion;", "", "()V", "combineHeaders", "Lokhttp3/Headers;", "cachedHeaders", "networkHeaders", "isCacheable", "", "request", "Lokhttp3/Request;", "response", "Lcoil/network/CacheResponse;", "Lokhttp3/Response;", "isContentSpecificHeader", "name", "", "isEndToEnd", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isCacheable(Request request, Response response) {
            return (request.cacheControl().noStore() || response.cacheControl().noStore() || Intrinsics.areEqual(response.headers().get("Vary"), "*")) ? false : true;
        }

        public final boolean isCacheable(Request request, CacheResponse response) {
            return (request.cacheControl().noStore() || response.getCacheControl().noStore() || Intrinsics.areEqual(response.getResponseHeaders().get("Vary"), "*")) ? false : true;
        }

        public final Headers combineHeaders(Headers cachedHeaders, Headers networkHeaders) {
            Headers.Builder result = new Headers.Builder();
            int size = cachedHeaders.size();
            for (int index = 0; index < size; index++) {
                String name = cachedHeaders.name(index);
                String value = cachedHeaders.value(index);
                if ((!StringsKt.equals("Warning", name, true) || !StringsKt.startsWith$default(value, DiskLruCache.VERSION, false, 2, (Object) null)) && (isContentSpecificHeader(name) || !isEndToEnd(name) || networkHeaders.get(name) == null)) {
                    result.addUnsafeNonAscii(name, value);
                }
            }
            int size2 = networkHeaders.size();
            for (int index2 = 0; index2 < size2; index2++) {
                String fieldName = networkHeaders.name(index2);
                if (!isContentSpecificHeader(fieldName) && isEndToEnd(fieldName)) {
                    result.addUnsafeNonAscii(fieldName, networkHeaders.value(index2));
                }
            }
            return result.build();
        }

        private final boolean isEndToEnd(String name) {
            return (StringsKt.equals("Connection", name, true) || StringsKt.equals("Keep-Alive", name, true) || StringsKt.equals("Proxy-Authenticate", name, true) || StringsKt.equals("Proxy-Authorization", name, true) || StringsKt.equals("TE", name, true) || StringsKt.equals("Trailers", name, true) || StringsKt.equals("Transfer-Encoding", name, true) || StringsKt.equals("Upgrade", name, true)) ? false : true;
        }

        private final boolean isContentSpecificHeader(String name) {
            return StringsKt.equals("Content-Length", name, true) || StringsKt.equals("Content-Encoding", name, true) || StringsKt.equals("Content-Type", name, true);
        }
    }
}
