package com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes18.dex */
public class ByteBufferBackedOutputStream extends OutputStream {

    /* JADX INFO: renamed from: _b */
    protected final ByteBuffer f370_b;

    public ByteBufferBackedOutputStream(ByteBuffer buf) {
        this.f370_b = buf;
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        this.f370_b.put((byte) b);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bytes, int off, int len) throws IOException {
        this.f370_b.put(bytes, off, len);
    }
}
