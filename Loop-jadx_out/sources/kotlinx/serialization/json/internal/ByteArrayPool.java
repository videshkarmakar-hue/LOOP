package kotlinx.serialization.json.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ArrayPools.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, m195d2 = {"Lkotlinx/serialization/json/internal/ByteArrayPool;", "Lkotlinx/serialization/json/internal/ByteArrayPoolBase;", "()V", "release", "", "array", "", "take", "kotlinx-serialization-json"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ByteArrayPool extends ByteArrayPoolBase {
    public static final ByteArrayPool INSTANCE = new ByteArrayPool();

    private ByteArrayPool() {
    }

    public final byte[] take() {
        return super.take(512);
    }

    public final void release(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        releaseImpl(array);
    }
}
