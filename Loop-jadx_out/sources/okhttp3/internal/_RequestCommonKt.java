package okhttp3.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.caverock.androidsvg.SVGParser;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;

/* JADX INFO: compiled from: -RequestCommon.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u001a\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t\u001a\u0012\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\n\u001a\u00020\b\u001a\u0014\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r\u001a\n\u0010\u000e\u001a\u00020\u0004*\u00020\u0004\u001a\n\u0010\u000f\u001a\u00020\u0004*\u00020\u0004\u001a\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u001a\u0010\u0010\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u0012\u0010\u0011\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014\u001a\u001c\u0010\u0015\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r\u001a\n\u0010\u0017\u001a\u00020\u0004*\u00020\t\u001a\u0012\u0010\u0018\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u0019\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001a\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001\u001a1\u0010\u001c\u001a\u00020\u0004\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u00020\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001d0 2\b\u0010!\u001a\u0004\u0018\u0001H\u001d¢\u0006\u0002\u0010\"¨\u0006#"}, m195d2 = {"canonicalUrl", "", "url", "commonAddHeader", "Lokhttp3/Request$Builder;", "name", DownloadUtil.CookieScheme.VALUE, "commonCacheControl", "Lokhttp3/CacheControl;", "Lokhttp3/Request;", "cacheControl", "commonDelete", "body", "Lokhttp3/RequestBody;", "commonGet", "commonHead", "commonHeader", "commonHeaders", "", "headers", "Lokhttp3/Headers;", "commonMethod", "method", "commonNewBuilder", "commonPatch", "commonPost", "commonPut", "commonRemoveHeader", "commonTag", ExifInterface.GPS_DIRECTION_TRUE, "", SVGParser.XML_STYLESHEET_ATTR_TYPE, "Lkotlin/reflect/KClass;", "tag", "(Lokhttp3/Request$Builder;Lkotlin/reflect/KClass;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "okhttp"}, m196k = 2, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class _RequestCommonKt {
    public static final String commonHeader(Request $this$commonHeader, String name) {
        Intrinsics.checkNotNullParameter($this$commonHeader, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return $this$commonHeader.headers().get(name);
    }

    public static final List<String> commonHeaders(Request $this$commonHeaders, String name) {
        Intrinsics.checkNotNullParameter($this$commonHeaders, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return $this$commonHeaders.headers().values(name);
    }

    public static final Request.Builder commonNewBuilder(Request $this$commonNewBuilder) {
        Intrinsics.checkNotNullParameter($this$commonNewBuilder, "<this>");
        return new Request.Builder($this$commonNewBuilder);
    }

    public static final CacheControl commonCacheControl(Request $this$commonCacheControl) {
        Intrinsics.checkNotNullParameter($this$commonCacheControl, "<this>");
        CacheControl result = $this$commonCacheControl.getLazyCacheControl();
        if (result == null) {
            CacheControl result2 = CacheControl.INSTANCE.parse($this$commonCacheControl.headers());
            $this$commonCacheControl.setLazyCacheControl$okhttp(result2);
            return result2;
        }
        return result;
    }

    public static final String canonicalUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (StringsKt.startsWith(url, "ws:", true)) {
            StringBuilder sbAppend = new StringBuilder().append("http:");
            String strSubstring = url.substring(3);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            return sbAppend.append(strSubstring).toString();
        }
        if (StringsKt.startsWith(url, "wss:", true)) {
            StringBuilder sbAppend2 = new StringBuilder().append("https:");
            String strSubstring2 = url.substring(4);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            return sbAppend2.append(strSubstring2).toString();
        }
        return url;
    }

    public static final Request.Builder commonHeader(Request.Builder $this$commonHeader, String name, String value) {
        Intrinsics.checkNotNullParameter($this$commonHeader, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        $this$commonHeader.getHeaders().set(name, value);
        return $this$commonHeader;
    }

    public static final Request.Builder commonAddHeader(Request.Builder $this$commonAddHeader, String name, String value) {
        Intrinsics.checkNotNullParameter($this$commonAddHeader, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        $this$commonAddHeader.getHeaders().add(name, value);
        return $this$commonAddHeader;
    }

    public static final Request.Builder commonRemoveHeader(Request.Builder $this$commonRemoveHeader, String name) {
        Intrinsics.checkNotNullParameter($this$commonRemoveHeader, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        $this$commonRemoveHeader.getHeaders().removeAll(name);
        return $this$commonRemoveHeader;
    }

    public static final Request.Builder commonHeaders(Request.Builder $this$commonHeaders, Headers headers) {
        Intrinsics.checkNotNullParameter($this$commonHeaders, "<this>");
        Intrinsics.checkNotNullParameter(headers, "headers");
        $this$commonHeaders.setHeaders$okhttp(headers.newBuilder());
        return $this$commonHeaders;
    }

    public static final Request.Builder commonCacheControl(Request.Builder $this$commonCacheControl, CacheControl cacheControl) {
        Intrinsics.checkNotNullParameter($this$commonCacheControl, "<this>");
        Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
        String value = cacheControl.toString();
        return value.length() == 0 ? $this$commonCacheControl.removeHeader("Cache-Control") : $this$commonCacheControl.header("Cache-Control", value);
    }

    public static final Request.Builder commonGet(Request.Builder $this$commonGet) {
        Intrinsics.checkNotNullParameter($this$commonGet, "<this>");
        return $this$commonGet.method("GET", null);
    }

    public static final Request.Builder commonHead(Request.Builder $this$commonHead) {
        Intrinsics.checkNotNullParameter($this$commonHead, "<this>");
        return $this$commonHead.method("HEAD", null);
    }

    public static final Request.Builder commonPost(Request.Builder $this$commonPost, RequestBody body) {
        Intrinsics.checkNotNullParameter($this$commonPost, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        return $this$commonPost.method("POST", body);
    }

    public static final Request.Builder commonDelete(Request.Builder $this$commonDelete, RequestBody body) {
        Intrinsics.checkNotNullParameter($this$commonDelete, "<this>");
        return $this$commonDelete.method("DELETE", body);
    }

    public static final Request.Builder commonPut(Request.Builder $this$commonPut, RequestBody body) {
        Intrinsics.checkNotNullParameter($this$commonPut, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        return $this$commonPut.method("PUT", body);
    }

    public static final Request.Builder commonPatch(Request.Builder $this$commonPatch, RequestBody body) {
        Intrinsics.checkNotNullParameter($this$commonPatch, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        return $this$commonPatch.method("PATCH", body);
    }

    public static final Request.Builder commonMethod(Request.Builder $this$commonMethod, String method, RequestBody body) {
        Intrinsics.checkNotNullParameter($this$commonMethod, "<this>");
        Intrinsics.checkNotNullParameter(method, "method");
        if (!(method.length() > 0)) {
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        }
        if (body == null) {
            if (!(true ^ HttpMethod.requiresRequestBody(method))) {
                throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
            }
        } else if (!HttpMethod.permitsRequestBody(method)) {
            throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
        }
        $this$commonMethod.setMethod$okhttp(method);
        $this$commonMethod.setBody$okhttp(body);
        return $this$commonMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Request.Builder commonTag(Request.Builder $this$commonTag, KClass<T> type, T t) {
        LinkedHashMap linkedHashMapAsMutableMap;
        Intrinsics.checkNotNullParameter($this$commonTag, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        if (t == 0) {
            if (!$this$commonTag.getTags$okhttp().isEmpty()) {
                TypeIntrinsics.asMutableMap($this$commonTag.getTags$okhttp()).remove(type);
            }
        } else {
            if ($this$commonTag.getTags$okhttp().isEmpty()) {
                linkedHashMapAsMutableMap = new LinkedHashMap();
                $this$commonTag.setTags$okhttp(linkedHashMapAsMutableMap);
            } else {
                linkedHashMapAsMutableMap = TypeIntrinsics.asMutableMap($this$commonTag.getTags$okhttp());
            }
            linkedHashMapAsMutableMap.put(type, t);
        }
        return $this$commonTag;
    }
}
