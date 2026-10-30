package org.apache.commons.compress.compressors;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.apache.commons.compress.compressors.deflate.DeflateCompressorInputStream;
import org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.compress.compressors.lzma.LZMACompressorInputStream;
import org.apache.commons.compress.compressors.lzma.LZMAUtils;
import org.apache.commons.compress.compressors.p011xz.XZCompressorInputStream;
import org.apache.commons.compress.compressors.p011xz.XZCompressorOutputStream;
import org.apache.commons.compress.compressors.p011xz.XZUtils;
import org.apache.commons.compress.compressors.p012z.ZCompressorInputStream;
import org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream;
import org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream;
import org.apache.commons.compress.compressors.snappy.FramedSnappyCompressorInputStream;
import org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes18.dex */
public class CompressorStreamFactory {
    public static final String BZIP2 = "bzip2";
    public static final String DEFLATE = "deflate";
    public static final String GZIP = "gz";
    public static final String LZMA = "lzma";
    public static final String PACK200 = "pack200";
    public static final String SNAPPY_FRAMED = "snappy-framed";
    public static final String SNAPPY_RAW = "snappy-raw";

    /* JADX INFO: renamed from: XZ */
    public static final String f580XZ = "xz";

    /* JADX INFO: renamed from: Z */
    public static final String f581Z = "z";
    private volatile boolean decompressConcatenated;
    private final Boolean decompressUntilEOF;

    public CompressorStreamFactory() {
        this.decompressConcatenated = false;
        this.decompressUntilEOF = null;
    }

    public CompressorStreamFactory(boolean decompressUntilEOF) {
        this.decompressConcatenated = false;
        this.decompressUntilEOF = Boolean.valueOf(decompressUntilEOF);
        this.decompressConcatenated = decompressUntilEOF;
    }

    @Deprecated
    public void setDecompressConcatenated(boolean decompressConcatenated) {
        if (this.decompressUntilEOF != null) {
            throw new IllegalStateException("Cannot override the setting defined by the constructor");
        }
        this.decompressConcatenated = decompressConcatenated;
    }

    public CompressorInputStream createCompressorInputStream(InputStream in) throws CompressorException {
        if (in == null) {
            throw new IllegalArgumentException("Stream must not be null.");
        }
        if (!in.markSupported()) {
            throw new IllegalArgumentException("Mark is not supported.");
        }
        byte[] signature = new byte[12];
        in.mark(signature.length);
        try {
            int signatureLength = IOUtils.readFully(in, signature);
            in.reset();
            if (BZip2CompressorInputStream.matches(signature, signatureLength)) {
                return new BZip2CompressorInputStream(in, this.decompressConcatenated);
            }
            if (GzipCompressorInputStream.matches(signature, signatureLength)) {
                return new GzipCompressorInputStream(in, this.decompressConcatenated);
            }
            if (Pack200CompressorInputStream.matches(signature, signatureLength)) {
                return new Pack200CompressorInputStream(in);
            }
            if (FramedSnappyCompressorInputStream.matches(signature, signatureLength)) {
                return new FramedSnappyCompressorInputStream(in);
            }
            if (ZCompressorInputStream.matches(signature, signatureLength)) {
                return new ZCompressorInputStream(in);
            }
            if (DeflateCompressorInputStream.matches(signature, signatureLength)) {
                return new DeflateCompressorInputStream(in);
            }
            if (XZUtils.matches(signature, signatureLength) && XZUtils.isXZCompressionAvailable()) {
                return new XZCompressorInputStream(in, this.decompressConcatenated);
            }
            if (LZMAUtils.matches(signature, signatureLength) && LZMAUtils.isLZMACompressionAvailable()) {
                return new LZMACompressorInputStream(in);
            }
            throw new CompressorException("No Compressor found for the stream signature.");
        } catch (IOException e) {
            throw new CompressorException("Failed to detect Compressor from InputStream.", e);
        }
    }

    public CompressorInputStream createCompressorInputStream(String name, InputStream in) throws CompressorException {
        if (name == null || in == null) {
            throw new IllegalArgumentException("Compressor name and stream must not be null.");
        }
        try {
            if (GZIP.equalsIgnoreCase(name)) {
                return new GzipCompressorInputStream(in, this.decompressConcatenated);
            }
            if (BZIP2.equalsIgnoreCase(name)) {
                return new BZip2CompressorInputStream(in, this.decompressConcatenated);
            }
            if (f580XZ.equalsIgnoreCase(name)) {
                return new XZCompressorInputStream(in, this.decompressConcatenated);
            }
            if (LZMA.equalsIgnoreCase(name)) {
                return new LZMACompressorInputStream(in);
            }
            if (PACK200.equalsIgnoreCase(name)) {
                return new Pack200CompressorInputStream(in);
            }
            if (SNAPPY_RAW.equalsIgnoreCase(name)) {
                return new SnappyCompressorInputStream(in);
            }
            if (SNAPPY_FRAMED.equalsIgnoreCase(name)) {
                return new FramedSnappyCompressorInputStream(in);
            }
            if (f581Z.equalsIgnoreCase(name)) {
                return new ZCompressorInputStream(in);
            }
            if (DEFLATE.equalsIgnoreCase(name)) {
                return new DeflateCompressorInputStream(in);
            }
            throw new CompressorException("Compressor: " + name + " not found.");
        } catch (IOException e) {
            throw new CompressorException("Could not create CompressorInputStream.", e);
        }
    }

    public CompressorOutputStream createCompressorOutputStream(String name, OutputStream out) throws CompressorException {
        if (name == null || out == null) {
            throw new IllegalArgumentException("Compressor name and stream must not be null.");
        }
        try {
            if (GZIP.equalsIgnoreCase(name)) {
                return new GzipCompressorOutputStream(out);
            }
            if (BZIP2.equalsIgnoreCase(name)) {
                return new BZip2CompressorOutputStream(out);
            }
            if (f580XZ.equalsIgnoreCase(name)) {
                return new XZCompressorOutputStream(out);
            }
            if (PACK200.equalsIgnoreCase(name)) {
                return new Pack200CompressorOutputStream(out);
            }
            if (DEFLATE.equalsIgnoreCase(name)) {
                return new DeflateCompressorOutputStream(out);
            }
            throw new CompressorException("Compressor: " + name + " not found.");
        } catch (IOException e) {
            throw new CompressorException("Could not create CompressorOutputStream", e);
        }
    }

    boolean getDecompressConcatenated() {
        return this.decompressConcatenated;
    }
}
