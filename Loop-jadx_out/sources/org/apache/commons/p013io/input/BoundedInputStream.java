package org.apache.commons.p013io.input;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes18.dex */
public class BoundedInputStream extends InputStream {

    /* JADX INFO: renamed from: in */
    private final InputStream f600in;
    private long mark;
    private final long max;
    private long pos;
    private boolean propagateClose;

    public BoundedInputStream(InputStream in, long size) {
        this.pos = 0L;
        this.mark = -1L;
        this.propagateClose = true;
        this.max = size;
        this.f600in = in;
    }

    public BoundedInputStream(InputStream in) {
        this(in, -1L);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.max >= 0 && this.pos >= this.max) {
            return -1;
        }
        int result = this.f600in.read();
        this.pos++;
        return result;
    }

    @Override // java.io.InputStream
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        if (this.max >= 0 && this.pos >= this.max) {
            return -1;
        }
        long maxRead = len;
        if (this.max >= 0) {
            maxRead = Math.min(maxRead, this.max - this.pos);
        }
        int bytesRead = this.f600in.read(b, off, (int) maxRead);
        if (bytesRead == -1) {
            return -1;
        }
        this.pos += (long) bytesRead;
        return bytesRead;
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        long toSkip = this.max >= 0 ? Math.min(n, this.max - this.pos) : n;
        long skippedBytes = this.f600in.skip(toSkip);
        this.pos += skippedBytes;
        return skippedBytes;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.max >= 0 && this.pos >= this.max) {
            return 0;
        }
        return this.f600in.available();
    }

    public String toString() {
        return this.f600in.toString();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.propagateClose) {
            this.f600in.close();
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f600in.reset();
        this.pos = this.mark;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int readlimit) {
        this.f600in.mark(readlimit);
        this.mark = this.pos;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f600in.markSupported();
    }

    public boolean isPropagateClose() {
        return this.propagateClose;
    }

    public void setPropagateClose(boolean propagateClose) {
        this.propagateClose = propagateClose;
    }
}
