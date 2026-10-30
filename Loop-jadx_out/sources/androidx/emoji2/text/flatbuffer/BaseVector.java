package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes17.dex */
public class BaseVector {

    /* JADX INFO: renamed from: bb */
    protected ByteBuffer f230bb;
    private int element_size;
    private int length;
    private int vector;

    protected int __vector() {
        return this.vector;
    }

    protected int __element(int j) {
        return this.vector + (this.element_size * j);
    }

    protected void __reset(int _vector, int _element_size, ByteBuffer _bb) {
        this.f230bb = _bb;
        if (this.f230bb != null) {
            this.vector = _vector;
            this.length = this.f230bb.getInt(_vector - 4);
            this.element_size = _element_size;
        } else {
            this.vector = 0;
            this.length = 0;
            this.element_size = 0;
        }
    }

    public void reset() {
        __reset(0, 0, null);
    }

    public int length() {
        return this.length;
    }
}
