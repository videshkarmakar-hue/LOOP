package okhttp3.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: compiled from: -RequestBodyCommon.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000,\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0002\u001a$\u0010\u0006\u001a\u00020\u0002*\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b\u001a\u0014\u0010\u0006\u001a\u00020\u0002*\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\u000e"}, m195d2 = {"commonContentLength", "", "Lokhttp3/RequestBody;", "commonIsDuplex", "", "commonIsOneShot", "commonToRequestBody", "", "contentType", "Lokhttp3/MediaType;", "offset", "", "byteCount", "Lokio/ByteString;", "okhttp"}, m196k = 2, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class _RequestBodyCommonKt {
    public static final RequestBody commonToRequestBody(final byte[] $this$commonToRequestBody, final MediaType contentType, final int offset, final int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonToRequestBody, "<this>");
        _UtilCommonKt.checkOffsetAndCount($this$commonToRequestBody.length, offset, byteCount);
        return new RequestBody() { // from class: okhttp3.internal._RequestBodyCommonKt.commonToRequestBody.1
            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: contentType, reason: from getter */
            public MediaType get$contentType() {
                return contentType;
            }

            @Override // okhttp3.RequestBody
            public long contentLength() {
                return byteCount;
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink sink) throws IOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                sink.write($this$commonToRequestBody, offset, byteCount);
            }
        };
    }

    public static final long commonContentLength(RequestBody $this$commonContentLength) {
        Intrinsics.checkNotNullParameter($this$commonContentLength, "<this>");
        return -1L;
    }

    public static final boolean commonIsDuplex(RequestBody $this$commonIsDuplex) {
        Intrinsics.checkNotNullParameter($this$commonIsDuplex, "<this>");
        return false;
    }

    public static final boolean commonIsOneShot(RequestBody $this$commonIsOneShot) {
        Intrinsics.checkNotNullParameter($this$commonIsOneShot, "<this>");
        return false;
    }

    public static final RequestBody commonToRequestBody(final ByteString $this$commonToRequestBody, final MediaType contentType) {
        Intrinsics.checkNotNullParameter($this$commonToRequestBody, "<this>");
        return new RequestBody() { // from class: okhttp3.internal._RequestBodyCommonKt.commonToRequestBody.2
            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: contentType, reason: from getter */
            public MediaType get$contentType() {
                return contentType;
            }

            @Override // okhttp3.RequestBody
            public long contentLength() {
                return $this$commonToRequestBody.size();
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink sink) throws IOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                sink.write($this$commonToRequestBody);
            }
        };
    }
}
