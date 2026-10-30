package org.apache.commons.p013io.output;

import androidx.compose.p001ui.geometry.InlineClassHelperKt;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes18.dex */
public class CountingOutputStream extends ProxyOutputStream {
    private long count;

    public CountingOutputStream(OutputStream out) {
        super(out);
        this.count = 0L;
    }

    @Override // org.apache.commons.p013io.output.ProxyOutputStream
    protected synchronized void beforeWrite(int n) {
        this.count += (long) n;
    }

    public int getCount() {
        long result = getByteCount();
        if (result > InlineClassHelperKt.FloatNonFiniteMask) {
            throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        }
        return (int) result;
    }

    public int resetCount() {
        long result = resetByteCount();
        if (result > InlineClassHelperKt.FloatNonFiniteMask) {
            throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        }
        return (int) result;
    }

    public synchronized long getByteCount() {
        return this.count;
    }

    public synchronized long resetByteCount() {
        long tmp;
        tmp = this.count;
        this.count = 0L;
        return tmp;
    }
}
