package org.apache.commons.p013io.output;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes18.dex */
public class ClosedOutputStream extends OutputStream {
    public static final ClosedOutputStream CLOSED_OUTPUT_STREAM = new ClosedOutputStream();

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        throw new IOException("write(" + b + ") failed: stream is closed");
    }
}
