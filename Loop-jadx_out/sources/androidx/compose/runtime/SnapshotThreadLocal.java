package androidx.compose.runtime;

import androidx.compose.runtime.internal.ThreadMap;
import androidx.compose.runtime.internal.ThreadMap_jvmKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: compiled from: ActualJvm.jvm.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\r\u0010\u000b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0010R\u0012\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m195d2 = {"Landroidx/compose/runtime/SnapshotThreadLocal;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "mainThreadValue", "Ljava/lang/Object;", "map", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/internal/ThreadMap;", "Landroidx/compose/runtime/AtomicReference;", "writeMutex", "get", "()Ljava/lang/Object;", "set", "", DownloadUtil.CookieScheme.VALUE, "(Ljava/lang/Object;)V", "runtime_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SnapshotThreadLocal<T> {
    public static final int $stable = 8;
    private T mainThreadValue;
    private final AtomicReference<ThreadMap> map = new AtomicReference<>(ThreadMap_jvmKt.getEmptyThreadMap());
    private final Object writeMutex = new Object();

    public final T get() {
        long id = Thread.currentThread().getId();
        if (id == ActualAndroid_androidKt.getMainThreadId()) {
            return this.mainThreadValue;
        }
        return (T) this.map.get().get(id);
    }

    public final void set(T value) {
        long key = Thread.currentThread().getId();
        if (key == ActualAndroid_androidKt.getMainThreadId()) {
            this.mainThreadValue = value;
            return;
        }
        Object lock$iv = this.writeMutex;
        synchronized (lock$iv) {
            ThreadMap current = this.map.get();
            if (current.trySet(key, value)) {
                return;
            }
            this.map.set(current.newWith(key, value));
            Unit unit = Unit.INSTANCE;
        }
    }
}
