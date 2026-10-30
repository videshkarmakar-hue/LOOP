package okhttp3.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.Dispatcher;
import okhttp3.Response;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: compiled from: NativeImageTestsAccessors.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016\u001a\u0016\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\n\u0010\u001a\u001a\u00060\u001bR\u00020\u001c\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"(\u0010\u000b\u001a\u00020\n*\u00020\u00012\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, m195d2 = {"connectionAccessor", "Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/connection/Exchange;", "getConnectionAccessor", "(Lokhttp3/internal/connection/Exchange;)Lokhttp3/internal/connection/RealConnection;", "exchangeAccessor", "Lokhttp3/Response;", "getExchangeAccessor", "(Lokhttp3/Response;)Lokhttp3/internal/connection/Exchange;", DownloadUtil.CookieScheme.VALUE, "", "idleAtNsAccessor", "getIdleAtNsAccessor", "(Lokhttp3/internal/connection/RealConnection;)J", "setIdleAtNsAccessor", "(Lokhttp3/internal/connection/RealConnection;J)V", "buildCache", "Lokhttp3/Cache;", "file", "Lokio/Path;", "maxSize", "fileSystem", "Lokio/FileSystem;", "finishedAccessor", "", "Lokhttp3/Dispatcher;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/internal/connection/RealCall$AsyncCall;", "Lokhttp3/internal/connection/RealCall;", "okhttp"}, m196k = 2, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NativeImageTestsAccessorsKt {
    public static final Cache buildCache(Path file, long maxSize, FileSystem fileSystem) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        return new Cache(file, maxSize, fileSystem);
    }

    public static final long getIdleAtNsAccessor(RealConnection $this$idleAtNsAccessor) {
        Intrinsics.checkNotNullParameter($this$idleAtNsAccessor, "<this>");
        return $this$idleAtNsAccessor.getIdleAtNs();
    }

    public static final void setIdleAtNsAccessor(RealConnection $this$idleAtNsAccessor, long value) {
        Intrinsics.checkNotNullParameter($this$idleAtNsAccessor, "<this>");
        $this$idleAtNsAccessor.setIdleAtNs(value);
    }

    public static final Exchange getExchangeAccessor(Response $this$exchangeAccessor) {
        Intrinsics.checkNotNullParameter($this$exchangeAccessor, "<this>");
        return $this$exchangeAccessor.getExchange();
    }

    public static final RealConnection getConnectionAccessor(Exchange $this$connectionAccessor) {
        Intrinsics.checkNotNullParameter($this$connectionAccessor, "<this>");
        return $this$connectionAccessor.getConnection$okhttp();
    }

    public static final void finishedAccessor(Dispatcher $this$finishedAccessor, RealCall.AsyncCall call) {
        Intrinsics.checkNotNullParameter($this$finishedAccessor, "<this>");
        Intrinsics.checkNotNullParameter(call, "call");
        $this$finishedAccessor.finished$okhttp(call);
    }
}
