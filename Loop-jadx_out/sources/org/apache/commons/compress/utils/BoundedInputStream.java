package org.apache.commons.compress.utils;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes18.dex */
public class BoundedInputStream extends InputStream {
    private long bytesRemaining;

    /* JADX INFO: renamed from: in */
    private final InputStream f595in;

    public BoundedInputStream(InputStream in, long size) {
        this.f595in = in;
        this.bytesRemaining = size;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.bytesRemaining > 0) {
            this.bytesRemaining--;
            return this.f595in.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        if (this.bytesRemaining == 0) {
            return -1;
        }
        int bytesToRead = len;
        if (bytesToRead > this.bytesRemaining) {
            bytesToRead = (int) this.bytesRemaining;
        }
        int bytesRead = this.f595in.read(b, off, bytesToRead);
        if (bytesRead >= 0) {
            this.bytesRemaining -= (long) bytesRead;
        }
        return bytesRead;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
