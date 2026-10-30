package okhttp3.internal.http;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal._ResponseCommonKt;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http2.ConnectionShutdownException;
import okio.BufferedSink;
import okio.Okio;

/* JADX INFO: compiled from: CallServerInterceptor.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m195d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "forWebSocket", "", "(Z)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, m196k = 1, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean forWebSocket) {
        this.forWebSocket = forWebSocket;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response responseBuild;
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realChain = (RealInterceptorChain) chain;
        Exchange exchange = realChain.getExchange();
        Intrinsics.checkNotNull(exchange);
        Request request = realChain.getRequest();
        RequestBody requestBody = request.body();
        long sentRequestMillis = System.currentTimeMillis();
        boolean invokeStartEvent = true;
        Response.Builder responseBuilder = null;
        IOException sendRequestException = null;
        try {
            exchange.writeRequestHeaders(request);
            if (HttpMethod.permitsRequestBody(request.method()) && requestBody != null) {
                if (StringsKt.equals("100-continue", request.header("Expect"), true)) {
                    exchange.flushRequest();
                    responseBuilder = exchange.readResponseHeaders(true);
                    exchange.responseHeadersStart();
                    invokeStartEvent = false;
                }
                if (responseBuilder == null) {
                    if (requestBody.isDuplex()) {
                        exchange.flushRequest();
                        requestBody.writeTo(Okio.buffer(exchange.createRequestBody(request, true)));
                    } else {
                        BufferedSink bufferedRequestBody = Okio.buffer(exchange.createRequestBody(request, false));
                        requestBody.writeTo(bufferedRequestBody);
                        bufferedRequestBody.close();
                    }
                } else {
                    exchange.noRequestBody();
                    if (!exchange.getConnection$okhttp().isMultiplexed$okhttp()) {
                        exchange.noNewExchangesOnConnection();
                    }
                }
            } else {
                exchange.noRequestBody();
            }
            if (requestBody == null || !requestBody.isDuplex()) {
                exchange.finishRequest();
            }
        } catch (IOException e) {
            if ((e instanceof ConnectionShutdownException) || !exchange.getHasFailure()) {
                throw e;
            }
            sendRequestException = e;
        }
        if (responseBuilder == null) {
            try {
                Response.Builder responseHeaders = exchange.readResponseHeaders(false);
                Intrinsics.checkNotNull(responseHeaders);
                responseBuilder = responseHeaders;
                if (invokeStartEvent) {
                    exchange.responseHeadersStart();
                    invokeStartEvent = false;
                }
            } catch (IOException e2) {
                if (sendRequestException != null) {
                    ExceptionsKt.addSuppressed(sendRequestException, e2);
                    throw sendRequestException;
                }
                throw e2;
            }
        }
        Response response = responseBuilder.request(request).handshake(exchange.getConnection$okhttp().getHandshake()).sentRequestAtMillis(sentRequestMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int code = response.code();
        if (code == 100) {
            Response.Builder responseBuilder2 = exchange.readResponseHeaders(false);
            Intrinsics.checkNotNull(responseBuilder2);
            if (invokeStartEvent) {
                exchange.responseHeadersStart();
            }
            response = responseBuilder2.request(request).handshake(exchange.getConnection$okhttp().getHandshake()).sentRequestAtMillis(sentRequestMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            code = response.code();
        }
        exchange.responseHeadersEnd(response);
        if (this.forWebSocket && code == 101) {
            responseBuild = _ResponseCommonKt.stripBody(response);
        } else {
            responseBuild = response.newBuilder().body(exchange.openResponseBody(response)).build();
        }
        Response response2 = responseBuild;
        if (StringsKt.equals("close", response2.request().header("Connection"), true) || StringsKt.equals("close", Response.header$default(response2, "Connection", null, 2, null), true)) {
            exchange.noNewExchangesOnConnection();
        }
        if ((code == 204 || code == 205) && response2.body().getContentLength() > 0) {
            throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + response2.body().getContentLength());
        }
        return response2;
    }
}
