package org.apache.commons.compress.compressors.lzma;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.tukaani.xz.LZMAInputStream;

/* JADX INFO: loaded from: classes18.dex */
public class LZMACompressorInputStream extends CompressorInputStream {

    /* JADX INFO: renamed from: in */
    private final InputStream f586in;

    public LZMACompressorInputStream(InputStream inputStream) throws IOException {
        this.f586in = new LZMAInputStream(inputStream);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int ret = this.f586in.read();
        count(ret == -1 ? 0 : 1);
        return ret;
    }

    @Override // java.io.InputStream
    public int read(byte[] buf, int off, int len) throws IOException {
        int ret = this.f586in.read(buf, off, len);
        count(ret);
        return ret;
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        return this.f586in.skip(n);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f586in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f586in.close();
    }

    public static boolean matches(byte[] signature, int length) {
        if (signature == null || length < 3 || signature[0] != 93 || signature[1] != 0 || signature[2] != 0) {
            return false;
        }
        return true;
    }
}
