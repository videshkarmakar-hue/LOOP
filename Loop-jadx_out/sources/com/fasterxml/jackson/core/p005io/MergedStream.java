package com.fasterxml.jackson.core.p005io;

import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class MergedStream extends InputStream {

    /* JADX INFO: renamed from: _b */
    private byte[] f351_b;
    private final IOContext _ctxt;
    private final int _end;
    private final InputStream _in;
    private int _ptr;

    public MergedStream(IOContext ctxt, InputStream in, byte[] buf, int start, int end) {
        this._ctxt = ctxt;
        this._in = in;
        this.f351_b = buf;
        this._ptr = start;
        this._end = end;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.f351_b != null) {
            return this._end - this._ptr;
        }
        return this._in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        _free();
        this._in.close();
    }

    @Override // java.io.InputStream
    public void mark(int readlimit) {
        if (this.f351_b == null) {
            this._in.mark(readlimit);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f351_b == null && this._in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f351_b != null) {
            byte[] bArr = this.f351_b;
            int i = this._ptr;
            this._ptr = i + 1;
            int c = bArr[i] & UByte.MAX_VALUE;
            if (this._ptr >= this._end) {
                _free();
            }
            return c;
        }
        return this._in.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        if (this.f351_b != null) {
            int avail = this._end - this._ptr;
            if (len > avail) {
                len = avail;
            }
            System.arraycopy(this.f351_b, this._ptr, b, off, len);
            this._ptr += len;
            if (this._ptr >= this._end) {
                _free();
            }
            return len;
        }
        return this._in.read(b, off, len);
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        if (this.f351_b == null) {
            this._in.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        long count = 0;
        if (this.f351_b != null) {
            int amount = this._end - this._ptr;
            if (amount > n) {
                this._ptr += (int) n;
                return n;
            }
            _free();
            count = 0 + ((long) amount);
            n -= (long) amount;
        }
        return n > 0 ? count + this._in.skip(n) : count;
    }

    private void _free() {
        byte[] buf = this.f351_b;
        if (buf != null) {
            this.f351_b = null;
            if (this._ctxt != null) {
                this._ctxt.releaseReadIOBuffer(buf);
            }
        }
    }
}
