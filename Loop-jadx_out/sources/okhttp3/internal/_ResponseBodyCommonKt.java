package okhttp3.internal;

import androidx.compose.p001ui.geometry.InlineClassHelperKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import java.io.Closeable;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: -ResponseBodyCommon.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0000\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0001H\u0000\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0001H\u0000\u001aG\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f*\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u000e0\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020\u00130\u0011H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u0016\u0010\u0015\u001a\u00020\u0001*\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0016\u0010\u0015\u001a\u00020\u0001*\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, m195d2 = {"commonAsResponseBody", "Lokhttp3/ResponseBody;", "Lokio/BufferedSource;", "contentType", "Lokhttp3/MediaType;", "contentLength", "", "commonByteString", "Lokio/ByteString;", "commonBytes", "", "commonClose", "", "commonConsumeSource", ExifInterface.GPS_DIRECTION_TRUE, "", "consumer", "Lkotlin/Function1;", "sizeMapper", "", "(Lokhttp3/ResponseBody;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "commonToResponseBody", "okhttp"}, m196k = 2, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class _ResponseBodyCommonKt {
    public static final byte[] commonBytes(ResponseBody $this$commonBytes) throws Throwable {
        Intrinsics.checkNotNullParameter($this$commonBytes, "<this>");
        long contentLength$iv = $this$commonBytes.getContentLength();
        if (contentLength$iv > InlineClassHelperKt.FloatNonFiniteMask) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength$iv);
        }
        Closeable $this$use$iv$iv = $this$commonBytes.getSource();
        byte[] byteArray = null;
        Throwable thrown$iv$iv = null;
        try {
            BufferedSource p0 = (BufferedSource) $this$use$iv$iv;
            byteArray = p0.readByteArray();
        } catch (Throwable t$iv$iv) {
            thrown$iv$iv = t$iv$iv;
        }
        if ($this$use$iv$iv != null) {
            try {
                $this$use$iv$iv.close();
            } catch (Throwable t$iv$iv2) {
                if (thrown$iv$iv == null) {
                    thrown$iv$iv = t$iv$iv2;
                } else {
                    ExceptionsKt.addSuppressed(thrown$iv$iv, t$iv$iv2);
                }
            }
        }
        if (thrown$iv$iv != null) {
            throw thrown$iv$iv;
        }
        Intrinsics.checkNotNull(byteArray);
        byte[] bArr = byteArray;
        int size$iv = bArr.length;
        if (contentLength$iv == -1 || contentLength$iv == size$iv) {
            return bArr;
        }
        throw new IOException("Content-Length (" + contentLength$iv + ") and stream length (" + size$iv + ") disagree");
    }

    public static final ByteString commonByteString(ResponseBody $this$commonByteString) throws Throwable {
        Intrinsics.checkNotNullParameter($this$commonByteString, "<this>");
        long contentLength$iv = $this$commonByteString.getContentLength();
        if (contentLength$iv > InlineClassHelperKt.FloatNonFiniteMask) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength$iv);
        }
        Closeable $this$use$iv$iv = $this$commonByteString.getSource();
        ByteString byteString = null;
        Throwable thrown$iv$iv = null;
        try {
            BufferedSource p0 = (BufferedSource) $this$use$iv$iv;
            byteString = p0.readByteString();
        } catch (Throwable t$iv$iv) {
            thrown$iv$iv = t$iv$iv;
        }
        if ($this$use$iv$iv != null) {
            try {
                $this$use$iv$iv.close();
            } catch (Throwable t$iv$iv2) {
                if (thrown$iv$iv == null) {
                    thrown$iv$iv = t$iv$iv2;
                } else {
                    ExceptionsKt.addSuppressed(thrown$iv$iv, t$iv$iv2);
                }
            }
        }
        if (thrown$iv$iv != null) {
            throw thrown$iv$iv;
        }
        Intrinsics.checkNotNull(byteString);
        ByteString byteString2 = byteString;
        int size$iv = byteString2.size();
        if (contentLength$iv == -1 || contentLength$iv == size$iv) {
            return byteString2;
        }
        throw new IOException("Content-Length (" + contentLength$iv + ") and stream length (" + size$iv + ") disagree");
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.Object] */
    public static final <T> T commonConsumeSource(ResponseBody responseBody, Function1<? super BufferedSource, ? extends T> consumer, Function1<? super T, Integer> sizeMapper) throws Throwable {
        Intrinsics.checkNotNullParameter(responseBody, "<this>");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(sizeMapper, "sizeMapper");
        long j = responseBody.getContentLength();
        if (j > InlineClassHelperKt.FloatNonFiniteMask) {
            throw new IOException("Cannot buffer entire body for content length: " + j);
        }
        BufferedSource bufferedSource = responseBody.getSource();
        Object objInvoke = null;
        Throwable th = null;
        try {
            objInvoke = consumer.invoke(bufferedSource);
        } catch (Throwable th2) {
            th = th2;
        }
        if (bufferedSource != null) {
            try {
                bufferedSource.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    ExceptionsKt.addSuppressed(th, th3);
                }
            }
        }
        if (th != null) {
            throw th;
        }
        Intrinsics.checkNotNull(objInvoke);
        ?? r3 = (Object) objInvoke;
        int iIntValue = sizeMapper.invoke(r3).intValue();
        if (j != -1 && j != iIntValue) {
            throw new IOException("Content-Length (" + j + ") and stream length (" + iIntValue + ") disagree");
        }
        return r3;
    }

    public static final void commonClose(ResponseBody $this$commonClose) {
        Intrinsics.checkNotNullParameter($this$commonClose, "<this>");
        _UtilCommonKt.closeQuietly($this$commonClose.getSource());
    }

    public static final ResponseBody commonToResponseBody(byte[] $this$commonToResponseBody, MediaType contentType) {
        Intrinsics.checkNotNullParameter($this$commonToResponseBody, "<this>");
        return ResponseBody.INSTANCE.create(new Buffer().write($this$commonToResponseBody), contentType, $this$commonToResponseBody.length);
    }

    public static final ResponseBody commonToResponseBody(ByteString $this$commonToResponseBody, MediaType contentType) {
        Intrinsics.checkNotNullParameter($this$commonToResponseBody, "<this>");
        return ResponseBody.INSTANCE.create(new Buffer().write($this$commonToResponseBody), contentType, $this$commonToResponseBody.size());
    }

    public static final ResponseBody commonAsResponseBody(final BufferedSource $this$commonAsResponseBody, final MediaType contentType, final long contentLength) {
        Intrinsics.checkNotNullParameter($this$commonAsResponseBody, "<this>");
        return new ResponseBody() { // from class: okhttp3.internal._ResponseBodyCommonKt.commonAsResponseBody.1
            @Override // okhttp3.ResponseBody
            /* JADX INFO: renamed from: contentType, reason: from getter */
            public MediaType getMediaType() {
                return contentType;
            }

            @Override // okhttp3.ResponseBody
            /* JADX INFO: renamed from: contentLength, reason: from getter */
            public long getContentLength() {
                return contentLength;
            }

            @Override // okhttp3.ResponseBody
            /* JADX INFO: renamed from: source, reason: from getter */
            public BufferedSource getSource() {
                return $this$commonAsResponseBody;
            }
        };
    }
}
