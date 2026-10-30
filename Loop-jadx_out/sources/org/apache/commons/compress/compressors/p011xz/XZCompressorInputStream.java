package org.apache.commons.compress.compressors.p011xz;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.tukaani.xz.SingleXZInputStream;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZInputStream;

/* JADX INFO: loaded from: classes18.dex */
public class XZCompressorInputStream extends CompressorInputStream {

    /* JADX INFO: renamed from: in */
    private final InputStream f592in;

    public static boolean matches(byte[] signature, int length) {
        if (length < XZ.HEADER_MAGIC.length) {
            return false;
        }
        for (int i = 0; i < XZ.HEADER_MAGIC.length; i++) {
            if (signature[i] != XZ.HEADER_MAGIC[i]) {
                return false;
            }
        }
        return true;
    }

    public XZCompressorInputStream(InputStream inputStream) throws IOException {
        this(inputStream, false);
    }

    public XZCompressorInputStream(InputStream inputStream, boolean decompressConcatenated) throws IOException {
        if (decompressConcatenated) {
            this.f592in = new XZInputStream(inputStream);
        } else {
            this.f592in = new SingleXZInputStream(inputStream);
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int ret = this.f592in.read();
        count(ret != -1 ? 1 : -1);
        return ret;
    }

    @Override // java.io.InputStream
    public int read(byte[] buf, int off, int len) throws IOException {
        int ret = this.f592in.read(buf, off, len);
        count(ret);
        return ret;
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        return this.f592in.skip(n);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f592in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f592in.close();
    }
}
