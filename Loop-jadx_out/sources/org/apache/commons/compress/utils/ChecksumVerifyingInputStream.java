package org.apache.commons.compress.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes18.dex */
public class ChecksumVerifyingInputStream extends InputStream {
    private long bytesRemaining;
    private final Checksum checksum;
    private final long expectedChecksum;

    /* JADX INFO: renamed from: in */
    private final InputStream f596in;

    public ChecksumVerifyingInputStream(Checksum checksum, InputStream in, long size, long expectedChecksum) {
        this.checksum = checksum;
        this.f596in = in;
        this.expectedChecksum = expectedChecksum;
        this.bytesRemaining = size;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.bytesRemaining <= 0) {
            return -1;
        }
        int ret = this.f596in.read();
        if (ret >= 0) {
            this.checksum.update(ret);
            this.bytesRemaining--;
        }
        if (this.bytesRemaining == 0 && this.expectedChecksum != this.checksum.getValue()) {
            throw new IOException("Checksum verification failed");
        }
        return ret;
    }

    @Override // java.io.InputStream
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        int ret = this.f596in.read(b, off, len);
        if (ret >= 0) {
            this.checksum.update(b, off, ret);
            this.bytesRemaining -= (long) ret;
        }
        if (this.bytesRemaining <= 0 && this.expectedChecksum != this.checksum.getValue()) {
            throw new IOException("Checksum verification failed");
        }
        return ret;
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        if (read() >= 0) {
            return 1L;
        }
        return 0L;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f596in.close();
    }
}
