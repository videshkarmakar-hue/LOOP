package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes17.dex */
public final class FloatVector extends BaseVector {
    public FloatVector __assign(int _vector, ByteBuffer _bb) {
        __reset(_vector, 4, _bb);
        return this;
    }

    public float get(int j) {
        return this.f230bb.getFloat(__element(j));
    }
}
