package org.apache.commons.compress.compressors.deflate;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;

/* JADX INFO: loaded from: classes18.dex */
public class DeflateCompressorInputStream extends CompressorInputStream {
    private static final int MAGIC_1 = 120;
    private static final int MAGIC_2a = 1;
    private static final int MAGIC_2b = 94;
    private static final int MAGIC_2c = 156;
    private static final int MAGIC_2d = 218;

    /* JADX INFO: renamed from: in */
    private final InputStream f584in;
    private final Inflater inflater;

    public DeflateCompressorInputStream(InputStream inputStream) {
        this(inputStream, new DeflateParameters());
    }

    public DeflateCompressorInputStream(InputStream inputStream, DeflateParameters parameters) {
        this.inflater = new Inflater(!parameters.withZlibHeader());
        this.f584in = new InflaterInputStream(inputStream, this.inflater);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int ret = this.f584in.read();
        count(ret == -1 ? 0 : 1);
        return ret;
    }

    @Override // java.io.InputStream
    public int read(byte[] buf, int off, int len) throws IOException {
        int ret = this.f584in.read(buf, off, len);
        count(ret);
        return ret;
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        return this.f584in.skip(n);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f584in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.f584in.close();
        } finally {
            this.inflater.end();
        }
    }

    public static boolean matches(byte[] signature, int length) {
        if (length <= 3 || signature[0] != 120) {
            return false;
        }
        return signature[1] == 1 || signature[1] == MAGIC_2b || signature[1] == -100 || signature[1] == -38;
    }
}
