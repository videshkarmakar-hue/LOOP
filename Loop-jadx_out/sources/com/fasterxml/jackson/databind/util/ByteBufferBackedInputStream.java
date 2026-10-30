package com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: loaded from: classes18.dex */
public class ByteBufferBackedInputStream extends InputStream {

    /* JADX INFO: renamed from: _b */
    protected final ByteBuffer f369_b;

    public ByteBufferBackedInputStream(ByteBuffer buf) {
        this.f369_b = buf;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f369_b.remaining();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f369_b.hasRemaining()) {
            return this.f369_b.get() & UByte.MAX_VALUE;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bytes, int off, int len) throws IOException {
        if (!this.f369_b.hasRemaining()) {
            return -1;
        }
        int len2 = Math.min(len, this.f369_b.remaining());
        this.f369_b.get(bytes, off, len2);
        return len2;
    }
}
