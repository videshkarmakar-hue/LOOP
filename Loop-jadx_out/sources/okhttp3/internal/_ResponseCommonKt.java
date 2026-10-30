package okhttp3.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpStatusCodesKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;

/* JADX INFO: compiled from: -ResponseCommon.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0002\u001a\u001a\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e\u001a\u0012\u0010\u0013\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0014\u0010\u0016\u001a\u00020\u0011*\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u001a\n\u0010\u0018\u001a\u00020\f*\u00020\u0002\u001a\u0012\u0010\u0019\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b\u001a \u0010\u001c\u001a\u0004\u0018\u00010\u000e*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0007\u001a\u001a\u0010\u001c\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e\u001a\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001f*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u001e\u001a\u00020\u0011*\u00020\u00112\u0006\u0010 \u001a\u00020!\u001a\u0012\u0010\"\u001a\u00020\u0011*\u00020\u00112\u0006\u0010#\u001a\u00020\u000e\u001a\u0014\u0010$\u001a\u00020\u0011*\u00020\u00112\b\u0010%\u001a\u0004\u0018\u00010\u0002\u001a\n\u0010&\u001a\u00020\u0011*\u00020\u0002\u001a\u0012\u0010'\u001a\u00020\u0015*\u00020\u00022\u0006\u0010(\u001a\u00020)\u001a\u0014\u0010*\u001a\u00020\u0011*\u00020\u00112\b\u0010+\u001a\u0004\u0018\u00010\u0002\u001a\u0012\u0010,\u001a\u00020\u0011*\u00020\u00112\u0006\u0010-\u001a\u00020.\u001a\u0012\u0010/\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u00100\u001a\u00020\u0011*\u00020\u00112\u0006\u00101\u001a\u000202\u001a\n\u00103\u001a\u00020\u000e*\u00020\u0002\u001a\u0018\u00104\u001a\u00020\u0011*\u00020\u00112\f\u00105\u001a\b\u0012\u0004\u0012\u00020!06\u001a\n\u00107\u001a\u00020\u0002*\u00020\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u00068"}, m195d2 = {"commonCacheControl", "Lokhttp3/CacheControl;", "Lokhttp3/Response;", "getCommonCacheControl", "(Lokhttp3/Response;)Lokhttp3/CacheControl;", "commonIsRedirect", "", "getCommonIsRedirect", "(Lokhttp3/Response;)Z", "commonIsSuccessful", "getCommonIsSuccessful", "checkSupportResponse", "", "name", "", "response", "commonAddHeader", "Lokhttp3/Response$Builder;", DownloadUtil.CookieScheme.VALUE, "commonBody", "body", "Lokhttp3/ResponseBody;", "commonCacheResponse", "cacheResponse", "commonClose", "commonCode", "code", "", "commonHeader", "defaultValue", "commonHeaders", "", "headers", "Lokhttp3/Headers;", "commonMessage", "message", "commonNetworkResponse", "networkResponse", "commonNewBuilder", "commonPeekBody", "byteCount", "", "commonPriorResponse", "priorResponse", "commonProtocol", "protocol", "Lokhttp3/Protocol;", "commonRemoveHeader", "commonRequest", "request", "Lokhttp3/Request;", "commonToString", "commonTrailers", "trailersFn", "Lkotlin/Function0;", "stripBody", "okhttp"}, m196k = 2, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class _ResponseCommonKt {
    public static final Response stripBody(Response $this$stripBody) {
        Intrinsics.checkNotNullParameter($this$stripBody, "<this>");
        return $this$stripBody.newBuilder().body(new UnreadableResponseBody($this$stripBody.body().getMediaType(), $this$stripBody.body().getContentLength())).build();
    }

    public static final boolean getCommonIsSuccessful(Response $this$commonIsSuccessful) {
        Intrinsics.checkNotNullParameter($this$commonIsSuccessful, "<this>");
        int iCode = $this$commonIsSuccessful.code();
        return 200 <= iCode && iCode < 300;
    }

    public static final List<String> commonHeaders(Response $this$commonHeaders, String name) {
        Intrinsics.checkNotNullParameter($this$commonHeaders, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return $this$commonHeaders.headers().values(name);
    }

    public static final String commonHeader(Response $this$commonHeader, String name, String defaultValue) {
        Intrinsics.checkNotNullParameter($this$commonHeader, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        String str = $this$commonHeader.headers().get(name);
        return str == null ? defaultValue : str;
    }

    public static final ResponseBody commonPeekBody(Response $this$commonPeekBody, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonPeekBody, "<this>");
        BufferedSource peeked = $this$commonPeekBody.body().getSource().peek();
        Buffer buffer = new Buffer();
        peeked.request(byteCount);
        buffer.write((Source) peeked, Math.min(byteCount, peeked.getBuffer().size()));
        return ResponseBody.INSTANCE.create(buffer, $this$commonPeekBody.body().getMediaType(), buffer.size());
    }

    public static final Response.Builder commonNewBuilder(Response $this$commonNewBuilder) {
        Intrinsics.checkNotNullParameter($this$commonNewBuilder, "<this>");
        return new Response.Builder($this$commonNewBuilder);
    }

    public static final boolean getCommonIsRedirect(Response $this$commonIsRedirect) {
        Intrinsics.checkNotNullParameter($this$commonIsRedirect, "<this>");
        switch ($this$commonIsRedirect.code()) {
            case 300:
            case HttpStatusCodesKt.HTTP_MOVED_PERM /* 301 */:
            case HttpStatusCodesKt.HTTP_MOVED_TEMP /* 302 */:
            case HttpStatusCodesKt.HTTP_SEE_OTHER /* 303 */:
            case HttpStatusCodesKt.HTTP_TEMP_REDIRECT /* 307 */:
            case HttpStatusCodesKt.HTTP_PERM_REDIRECT /* 308 */:
                return true;
            case HttpStatusCodesKt.HTTP_NOT_MODIFIED /* 304 */:
            case HttpStatusCodesKt.HTTP_USE_PROXY /* 305 */:
            case 306:
            default:
                return false;
        }
    }

    public static final CacheControl getCommonCacheControl(Response $this$commonCacheControl) {
        Intrinsics.checkNotNullParameter($this$commonCacheControl, "<this>");
        CacheControl result = $this$commonCacheControl.getLazyCacheControl();
        if (result == null) {
            CacheControl result2 = CacheControl.INSTANCE.parse($this$commonCacheControl.headers());
            $this$commonCacheControl.setLazyCacheControl$okhttp(result2);
            return result2;
        }
        return result;
    }

    public static final void commonClose(Response $this$commonClose) {
        Intrinsics.checkNotNullParameter($this$commonClose, "<this>");
        $this$commonClose.body().close();
    }

    public static final String commonToString(Response $this$commonToString) {
        Intrinsics.checkNotNullParameter($this$commonToString, "<this>");
        return "Response{protocol=" + $this$commonToString.protocol() + ", code=" + $this$commonToString.code() + ", message=" + $this$commonToString.message() + ", url=" + $this$commonToString.request().url() + AbstractJsonLexerKt.END_OBJ;
    }

    public static final Response.Builder commonRequest(Response.Builder $this$commonRequest, Request request) {
        Intrinsics.checkNotNullParameter($this$commonRequest, "<this>");
        Intrinsics.checkNotNullParameter(request, "request");
        $this$commonRequest.setRequest$okhttp(request);
        return $this$commonRequest;
    }

    public static final Response.Builder commonProtocol(Response.Builder $this$commonProtocol, Protocol protocol) {
        Intrinsics.checkNotNullParameter($this$commonProtocol, "<this>");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        $this$commonProtocol.setProtocol$okhttp(protocol);
        return $this$commonProtocol;
    }

    public static final Response.Builder commonCode(Response.Builder $this$commonCode, int code) {
        Intrinsics.checkNotNullParameter($this$commonCode, "<this>");
        $this$commonCode.setCode$okhttp(code);
        return $this$commonCode;
    }

    public static final Response.Builder commonMessage(Response.Builder $this$commonMessage, String message) {
        Intrinsics.checkNotNullParameter($this$commonMessage, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        $this$commonMessage.setMessage$okhttp(message);
        return $this$commonMessage;
    }

    public static final Response.Builder commonHeader(Response.Builder $this$commonHeader, String name, String value) {
        Intrinsics.checkNotNullParameter($this$commonHeader, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        $this$commonHeader.getHeaders().set(name, value);
        return $this$commonHeader;
    }

    public static final Response.Builder commonAddHeader(Response.Builder $this$commonAddHeader, String name, String value) {
        Intrinsics.checkNotNullParameter($this$commonAddHeader, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        $this$commonAddHeader.getHeaders().add(name, value);
        return $this$commonAddHeader;
    }

    public static final Response.Builder commonRemoveHeader(Response.Builder $this$commonRemoveHeader, String name) {
        Intrinsics.checkNotNullParameter($this$commonRemoveHeader, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        $this$commonRemoveHeader.getHeaders().removeAll(name);
        return $this$commonRemoveHeader;
    }

    public static final Response.Builder commonHeaders(Response.Builder $this$commonHeaders, Headers headers) {
        Intrinsics.checkNotNullParameter($this$commonHeaders, "<this>");
        Intrinsics.checkNotNullParameter(headers, "headers");
        $this$commonHeaders.setHeaders$okhttp(headers.newBuilder());
        return $this$commonHeaders;
    }

    public static final Response.Builder commonTrailers(Response.Builder $this$commonTrailers, Function0<Headers> trailersFn) {
        Intrinsics.checkNotNullParameter($this$commonTrailers, "<this>");
        Intrinsics.checkNotNullParameter(trailersFn, "trailersFn");
        $this$commonTrailers.setTrailersFn$okhttp(trailersFn);
        return $this$commonTrailers;
    }

    public static final Response.Builder commonBody(Response.Builder $this$commonBody, ResponseBody body) {
        Intrinsics.checkNotNullParameter($this$commonBody, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        $this$commonBody.setBody$okhttp(body);
        return $this$commonBody;
    }

    public static final Response.Builder commonNetworkResponse(Response.Builder $this$commonNetworkResponse, Response networkResponse) {
        Intrinsics.checkNotNullParameter($this$commonNetworkResponse, "<this>");
        checkSupportResponse("networkResponse", networkResponse);
        $this$commonNetworkResponse.setNetworkResponse$okhttp(networkResponse);
        return $this$commonNetworkResponse;
    }

    public static final Response.Builder commonCacheResponse(Response.Builder $this$commonCacheResponse, Response cacheResponse) {
        Intrinsics.checkNotNullParameter($this$commonCacheResponse, "<this>");
        checkSupportResponse("cacheResponse", cacheResponse);
        $this$commonCacheResponse.setCacheResponse$okhttp(cacheResponse);
        return $this$commonCacheResponse;
    }

    private static final void checkSupportResponse(String name, Response response) {
        if (response != null) {
            if (!(response.networkResponse() == null)) {
                throw new IllegalArgumentException((name + ".networkResponse != null").toString());
            }
            if (!(response.cacheResponse() == null)) {
                throw new IllegalArgumentException((name + ".cacheResponse != null").toString());
            }
            if (!(response.priorResponse() == null)) {
                throw new IllegalArgumentException((name + ".priorResponse != null").toString());
            }
        }
    }

    public static final Response.Builder commonPriorResponse(Response.Builder $this$commonPriorResponse, Response priorResponse) {
        Intrinsics.checkNotNullParameter($this$commonPriorResponse, "<this>");
        $this$commonPriorResponse.setPriorResponse$okhttp(priorResponse);
        return $this$commonPriorResponse;
    }
}
