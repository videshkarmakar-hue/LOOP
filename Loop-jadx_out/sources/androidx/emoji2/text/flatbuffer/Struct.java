package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes17.dex */
public class Struct {

    /* JADX INFO: renamed from: bb */
    protected ByteBuffer f235bb;
    protected int bb_pos;

    protected void __reset(int _i, ByteBuffer _bb) {
        this.f235bb = _bb;
        if (this.f235bb != null) {
            this.bb_pos = _i;
        } else {
            this.bb_pos = 0;
        }
    }

    public void __reset() {
        __reset(0, null);
    }
}
