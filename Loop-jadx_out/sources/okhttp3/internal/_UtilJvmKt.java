package okhttp3.internal;

import androidx.compose.p001ui.geometry.InlineClassHelperKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.videshkarmakar.loop.p006ui.common.Route;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;

/* JADX INFO: compiled from: -UtilJvm.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000º\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000\u001a'\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016¢\u0006\u0002\u0010\u0017\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0019\"\u0004\b\u0000\u0010\u001a2\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u001a0\u0015\"\u0002H\u001aH\u0007¢\u0006\u0002\u0010\u001c\u001a3\u0010\u001d\u001a\u0004\u0018\u0001H\u001a\"\u0004\b\u0000\u0010\u001a2\u0006\u0010\u001e\u001a\u00020\u00162\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001a0 2\u0006\u0010!\u001a\u00020\u000bH\u0000¢\u0006\u0002\u0010\"\u001a\u0016\u0010#\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\t\u001a\"\u0010&\u001a\u00020'2\u0006\u0010\u000e\u001a\u00020\u000b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0)H\u0080\bø\u0001\u0000\u001a\f\u0010*\u001a\u00020+*\u00020,H\u0000\u001a\r\u0010-\u001a\u00020'*\u00020\u0016H\u0080\b\u001a\r\u0010.\u001a\u00020'*\u00020\u0016H\u0080\b\u001a\u0014\u0010/\u001a\u00020\t*\u0002002\u0006\u00101\u001a\u000200H\u0000\u001a\n\u00102\u001a\u00020'*\u000203\u001a\f\u00102\u001a\u00020'*\u000204H\u0000\u001a\u001c\u00105\u001a\u00020\t*\u0002062\u0006\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\u0012H\u0000\u001a\f\u00109\u001a\u00020\u0010*\u00020:H\u0000\u001a\u0014\u0010;\u001a\u00020\t*\u0002042\u0006\u0010<\u001a\u00020=H\u0000\u001a\r\u0010>\u001a\u00020\u000b*\u00020\u000bH\u0086\b\u001a\u0012\u0010>\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010?\u001a\u00020@\u001a\r\u0010A\u001a\u00020'*\u00020\u0016H\u0080\b\u001a\r\u0010B\u001a\u00020'*\u00020\u0016H\u0080\b\u001a\n\u0010C\u001a\u00020\u000b*\u000204\u001a\u0014\u0010D\u001a\u00020E*\u00020=2\u0006\u0010F\u001a\u00020EH\u0000\u001a\u001c\u0010G\u001a\u00020\t*\u0002062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u00108\u001a\u00020\u0012H\u0000\u001a\u0012\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\u0019*\u00020\u0001H\u0000\u001a\u0012\u0010J\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020I0\u0019H\u0000\u001a\f\u0010K\u001a\u00020\u000b*\u00020\rH\u0000\u001a\f\u0010K\u001a\u00020\u000b*\u00020\u0010H\u0000\u001a\u0016\u0010L\u001a\u00020\u000b*\u0002002\b\b\u0002\u0010M\u001a\u00020\tH\u0000\u001a\u001c\u0010N\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0019\"\u0004\b\u0000\u0010\u001a*\b\u0012\u0004\u0012\u0002H\u001a0\u0019\u001a\r\u0010O\u001a\u00020\u000b*\u00020\u000bH\u0086\b\u001a\u0012\u0010O\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010?\u001a\u00020@\u001a\r\u0010P\u001a\u00020'*\u00020\u0016H\u0080\b\"\u0010\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u00020\u000b8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000*\n\u0010Q\"\u0002002\u000200\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006R"}, m195d2 = {"EMPTY_HEADERS", "Lokhttp3/Headers;", "EMPTY_REQUEST", "Lokhttp3/RequestBody;", "EMPTY_RESPONSE", "Lokhttp3/ResponseBody;", "UTC", "Ljava/util/TimeZone;", "assertionsEnabled", "", "okHttpName", "", "checkDuration", "", "name", "duration", "", "unit", "Ljava/util/concurrent/TimeUnit;", Route.FORMAT_SELECTION, "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "immutableListOf", "", ExifInterface.GPS_DIRECTION_TRUE, "elements", "([Ljava/lang/Object;)Ljava/util/List;", "readFieldOrNull", "instance", "fieldType", "Ljava/lang/Class;", "fieldName", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "daemon", "threadName", "", "block", "Lkotlin/Function0;", "asFactory", "Lokhttp3/EventListener$Factory;", "Lokhttp3/EventListener;", "assertThreadDoesntHoldLock", "assertThreadHoldsLock", "canReuseConnectionFor", "Lokhttp3/HttpUrl;", "other", "closeQuietly", "Ljava/net/ServerSocket;", "Ljava/net/Socket;", "discard", "Lokio/Source;", "timeout", "timeUnit", "headersContentLength", "Lokhttp3/Response;", "isHealthy", "source", "Lokio/BufferedSource;", "lowercase", "locale", "Ljava/util/Locale;", "notify", "notifyAll", "peerName", "readBomAsCharset", "Ljava/nio/charset/Charset;", "default", "skipAll", "toHeaderList", "Lokhttp3/internal/http2/Header;", "toHeaders", "toHexString", "toHostHeader", "includeDefaultPort", "toImmutableList", "uppercase", "wait", "HttpUrlRepresentation", "okhttp"}, m196k = 2, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class _UtilJvmKt {
    public static final Headers EMPTY_HEADERS = _UtilCommonKt.getCommonEmptyHeaders();
    public static final RequestBody EMPTY_REQUEST = _UtilCommonKt.getCommonEmptyRequestBody();
    public static final ResponseBody EMPTY_RESPONSE = _UtilCommonKt.getCommonEmptyResponse();
    public static final TimeZone UTC;
    public static final boolean assertionsEnabled;
    public static final String okHttpName;

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Intrinsics.checkNotNull(timeZone);
        UTC = timeZone;
        assertionsEnabled = false;
        String name = OkHttpClient.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "OkHttpClient::class.java.name");
        okHttpName = StringsKt.removeSuffix(StringsKt.removePrefix(name, (CharSequence) "okhttp3."), (CharSequence) "Client");
    }

    public static final ThreadFactory threadFactory(final String name, final boolean daemon) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ThreadFactory() { // from class: okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return _UtilJvmKt.m9445threadFactory$lambda1(name, daemon, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: threadFactory$lambda-1, reason: not valid java name */
    public static final Thread m9445threadFactory$lambda1(String name, boolean $daemon, Runnable runnable) {
        Intrinsics.checkNotNullParameter(name, "$name");
        Thread $this$threadFactory_u24lambda_u2d1_u24lambda_u2d0 = new Thread(runnable, name);
        $this$threadFactory_u24lambda_u2d1_u24lambda_u2d0.setDaemon($daemon);
        return $this$threadFactory_u24lambda_u2d1_u24lambda_u2d0;
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toHostHeader(httpUrl, z);
    }

    public static final String toHostHeader(HttpUrl $this$toHostHeader, boolean includeDefaultPort) {
        String host;
        Intrinsics.checkNotNullParameter($this$toHostHeader, "<this>");
        if (StringsKt.contains$default((CharSequence) $this$toHostHeader.host(), (CharSequence) ":", false, 2, (Object) null)) {
            host = AbstractJsonLexerKt.BEGIN_LIST + $this$toHostHeader.host() + AbstractJsonLexerKt.END_LIST;
        } else {
            host = $this$toHostHeader.host();
        }
        if (includeDefaultPort || $this$toHostHeader.port() != HttpUrl.INSTANCE.defaultPort($this$toHostHeader.scheme())) {
            return host + AbstractJsonLexerKt.COLON + $this$toHostHeader.port();
        }
        return host;
    }

    public static final String format(String format, Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
        String str = String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        return str;
    }

    public static final Charset readBomAsCharset(BufferedSource $this$readBomAsCharset, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter($this$readBomAsCharset, "<this>");
        Intrinsics.checkNotNullParameter(charset, "default");
        switch ($this$readBomAsCharset.select(_UtilCommonKt.getUNICODE_BOMS())) {
            case -1:
                return charset;
            case 0:
                return Charsets.UTF_8;
            case 1:
                return Charsets.UTF_16BE;
            case 2:
                return Charsets.UTF_16LE;
            case 3:
                return Charsets.INSTANCE.UTF32_BE();
            case 4:
                return Charsets.INSTANCE.UTF32_LE();
            default:
                throw new AssertionError();
        }
    }

    public static final int checkDuration(String name, long duration, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(name, "name");
        boolean z = true;
        if (!(duration >= 0)) {
            throw new IllegalStateException((name + " < 0").toString());
        }
        if (!(unit != null)) {
            throw new IllegalStateException("unit == null".toString());
        }
        long millis = unit.toMillis(duration);
        if (!(millis <= InlineClassHelperKt.FloatNonFiniteMask)) {
            throw new IllegalArgumentException((name + " too large.").toString());
        }
        if (millis == 0 && duration > 0) {
            z = false;
        }
        if (z) {
            return (int) millis;
        }
        throw new IllegalArgumentException((name + " too small.").toString());
    }

    public static final Headers toHeaders(List<Header> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            ByteString name = header.getName();
            ByteString value = header.getValue();
            builder.addLenient$okhttp(name.utf8(), value.utf8());
        }
        return builder.build();
    }

    public static final List<Header> toHeaderList(Headers $this$toHeaderList) {
        Intrinsics.checkNotNullParameter($this$toHeaderList, "<this>");
        Iterable $this$map$iv = RangesKt.until(0, $this$toHeaderList.size());
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        Iterator<Integer> it = $this$map$iv.iterator();
        while (it.hasNext()) {
            int item$iv$iv = ((IntIterator) it).nextInt();
            destination$iv$iv.add(new Header($this$toHeaderList.name(item$iv$iv), $this$toHeaderList.value(item$iv$iv)));
        }
        return (List) destination$iv$iv;
    }

    public static final boolean canReuseConnectionFor(HttpUrl $this$canReuseConnectionFor, HttpUrl other) {
        Intrinsics.checkNotNullParameter($this$canReuseConnectionFor, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.areEqual($this$canReuseConnectionFor.host(), other.host()) && $this$canReuseConnectionFor.port() == other.port() && Intrinsics.areEqual($this$canReuseConnectionFor.scheme(), other.scheme());
    }

    public static final EventListener.Factory asFactory(final EventListener $this$asFactory) {
        Intrinsics.checkNotNullParameter($this$asFactory, "<this>");
        return new EventListener.Factory() { // from class: okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0
            @Override // okhttp3.EventListener.Factory
            public final EventListener create(Call call) {
                return _UtilJvmKt.m9444asFactory$lambda7($this$asFactory, call);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: asFactory$lambda-7, reason: not valid java name */
    public static final EventListener m9444asFactory$lambda7(EventListener this_asFactory, Call it) {
        Intrinsics.checkNotNullParameter(this_asFactory, "$this_asFactory");
        Intrinsics.checkNotNullParameter(it, "it");
        return this_asFactory;
    }

    public static final boolean skipAll(Source $this$skipAll, int duration, TimeUnit timeUnit) throws IOException {
        long originalDurationNs;
        Intrinsics.checkNotNullParameter($this$skipAll, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        long nowNs = System.nanoTime();
        if ($this$skipAll.timeout().getHasDeadline()) {
            originalDurationNs = $this$skipAll.timeout().deadlineNanoTime() - nowNs;
        } else {
            originalDurationNs = Long.MAX_VALUE;
        }
        $this$skipAll.timeout().deadlineNanoTime(Math.min(originalDurationNs, timeUnit.toNanos(duration)) + nowNs);
        try {
            Buffer skipBuffer = new Buffer();
            while ($this$skipAll.read(skipBuffer, 8192L) != -1) {
                skipBuffer.clear();
            }
            if (originalDurationNs == Long.MAX_VALUE) {
                $this$skipAll.timeout().clearDeadline();
            } else {
                $this$skipAll.timeout().deadlineNanoTime(nowNs + originalDurationNs);
            }
            return true;
        } catch (InterruptedIOException e) {
            if (originalDurationNs == Long.MAX_VALUE) {
                $this$skipAll.timeout().clearDeadline();
            } else {
                $this$skipAll.timeout().deadlineNanoTime(nowNs + originalDurationNs);
            }
            return false;
        } catch (Throwable th) {
            if (originalDurationNs == Long.MAX_VALUE) {
                $this$skipAll.timeout().clearDeadline();
            } else {
                $this$skipAll.timeout().deadlineNanoTime(nowNs + originalDurationNs);
            }
            throw th;
        }
    }

    public static final boolean discard(Source $this$discard, int timeout, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter($this$discard, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        try {
            return skipAll($this$discard, timeout, timeUnit);
        } catch (IOException e) {
            return false;
        }
    }

    public static final String peerName(Socket $this$peerName) {
        Intrinsics.checkNotNullParameter($this$peerName, "<this>");
        SocketAddress address = $this$peerName.getRemoteSocketAddress();
        if (!(address instanceof InetSocketAddress)) {
            return address.toString();
        }
        String hostName = ((InetSocketAddress) address).getHostName();
        Intrinsics.checkNotNullExpressionValue(hostName, "address.hostName");
        return hostName;
    }

    public static final boolean isHealthy(Socket $this$isHealthy, BufferedSource source) {
        Intrinsics.checkNotNullParameter($this$isHealthy, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            int readTimeout = $this$isHealthy.getSoTimeout();
            try {
                $this$isHealthy.setSoTimeout(1);
                return !source.exhausted();
            } finally {
                $this$isHealthy.setSoTimeout(readTimeout);
            }
        } catch (SocketTimeoutException e) {
            return true;
        } catch (IOException e2) {
            return false;
        }
    }

    public static final void threadName(String name, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        Thread currentThread = Thread.currentThread();
        String oldName = currentThread.getName();
        currentThread.setName(name);
        try {
            block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            currentThread.setName(oldName);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final long headersContentLength(Response $this$headersContentLength) {
        Intrinsics.checkNotNullParameter($this$headersContentLength, "<this>");
        String str = $this$headersContentLength.headers().get("Content-Length");
        if (str != null) {
            return _UtilCommonKt.toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<T> listUnmodifiableList = Collections.unmodifiableList(CollectionsKt.toMutableList((Collection) list));
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List<T> listUnmodifiableList = Collections.unmodifiableList(CollectionsKt.listOf(Arrays.copyOf(objArr, objArr.length)));
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final void closeQuietly(Socket $this$closeQuietly) {
        Intrinsics.checkNotNullParameter($this$closeQuietly, "<this>");
        try {
            $this$closeQuietly.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException rethrown) {
            if (Intrinsics.areEqual(rethrown.getMessage(), "bio == null")) {
            } else {
                throw rethrown;
            }
        } catch (Exception e2) {
        }
    }

    public static final void closeQuietly(ServerSocket $this$closeQuietly) {
        Intrinsics.checkNotNullParameter($this$closeQuietly, "<this>");
        try {
            $this$closeQuietly.close();
        } catch (RuntimeException rethrown) {
            throw rethrown;
        } catch (Exception e) {
        }
    }

    public static final String toHexString(long $this$toHexString) {
        String hexString = Long.toHexString($this$toHexString);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(this)");
        return hexString;
    }

    public static final String toHexString(int $this$toHexString) {
        String hexString = Integer.toHexString($this$toHexString);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(this)");
        return hexString;
    }

    public static final void wait(Object $this$wait) throws InterruptedException {
        Intrinsics.checkNotNullParameter($this$wait, "<this>");
        $this$wait.wait();
    }

    public static final void notify(Object $this$notify) {
        Intrinsics.checkNotNullParameter($this$notify, "<this>");
        $this$notify.notify();
    }

    public static final void notifyAll(Object $this$notifyAll) {
        Intrinsics.checkNotNullParameter($this$notifyAll, "<this>");
        $this$notifyAll.notifyAll();
    }

    public static final <T> T readFieldOrNull(Object instance, Class<T> fieldType, String fieldName) {
        Object fieldOrNull;
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(fieldType, "fieldType");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Class<?> cls = instance.getClass();
        while (true) {
            T tCast = null;
            if (!Intrinsics.areEqual(cls, Object.class)) {
                try {
                    Field declaredField = cls.getDeclaredField(fieldName);
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(instance);
                    if (fieldType.isInstance(obj)) {
                        tCast = fieldType.cast(obj);
                    }
                    return tCast;
                } catch (NoSuchFieldException e) {
                    Class<? super Object> superclass = cls.getSuperclass();
                    Intrinsics.checkNotNullExpressionValue(superclass, "c.superclass");
                    cls = superclass;
                }
            } else {
                if (Intrinsics.areEqual(fieldName, "delegate") || (fieldOrNull = readFieldOrNull(instance, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) readFieldOrNull(fieldOrNull, fieldType, fieldName);
            }
        }
    }

    public static final void assertThreadHoldsLock(Object $this$assertThreadHoldsLock) {
        Intrinsics.checkNotNullParameter($this$assertThreadHoldsLock, "<this>");
        if (assertionsEnabled && !Thread.holdsLock($this$assertThreadHoldsLock)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertThreadHoldsLock);
        }
    }

    public static final void assertThreadDoesntHoldLock(Object $this$assertThreadDoesntHoldLock) {
        Intrinsics.checkNotNullParameter($this$assertThreadDoesntHoldLock, "<this>");
        if (assertionsEnabled && Thread.holdsLock($this$assertThreadDoesntHoldLock)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertThreadDoesntHoldLock);
        }
    }

    public static final String lowercase(String $this$lowercase) {
        Intrinsics.checkNotNullParameter($this$lowercase, "<this>");
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = $this$lowercase.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public static final String uppercase(String $this$uppercase) {
        Intrinsics.checkNotNullParameter($this$uppercase, "<this>");
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String upperCase = $this$uppercase.toUpperCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    public static final String lowercase(String $this$lowercase, Locale locale) {
        Intrinsics.checkNotNullParameter($this$lowercase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String lowerCase = $this$lowercase.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public static final String uppercase(String $this$uppercase, Locale locale) {
        Intrinsics.checkNotNullParameter($this$uppercase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String upperCase = $this$uppercase.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }
}
