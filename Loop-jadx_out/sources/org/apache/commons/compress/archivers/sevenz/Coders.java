package org.apache.commons.compress.archivers.sevenz;

import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.tukaani.xz.ARMOptions;
import org.tukaani.xz.ARMThumbOptions;
import org.tukaani.xz.FilterOptions;
import org.tukaani.xz.FinishableOutputStream;
import org.tukaani.xz.FinishableWrapperOutputStream;
import org.tukaani.xz.IA64Options;
import org.tukaani.xz.LZMAInputStream;
import org.tukaani.xz.PowerPCOptions;
import org.tukaani.xz.SPARCOptions;
import org.tukaani.xz.X86Options;

/* JADX INFO: loaded from: classes18.dex */
class Coders {
    private static final Map<SevenZMethod, CoderBase> CODER_MAP = new HashMap<SevenZMethod, CoderBase>() { // from class: org.apache.commons.compress.archivers.sevenz.Coders.1
        private static final long serialVersionUID = 1664829131806520867L;

        {
            put(SevenZMethod.COPY, new CopyDecoder());
            put(SevenZMethod.LZMA, new LZMADecoder());
            put(SevenZMethod.LZMA2, new LZMA2Decoder());
            put(SevenZMethod.DEFLATE, new DeflateDecoder());
            put(SevenZMethod.BZIP2, new BZIP2Decoder());
            put(SevenZMethod.AES256SHA256, new AES256SHA256Decoder());
            put(SevenZMethod.BCJ_X86_FILTER, new BCJDecoder(new X86Options()));
            put(SevenZMethod.BCJ_PPC_FILTER, new BCJDecoder(new PowerPCOptions()));
            put(SevenZMethod.BCJ_IA64_FILTER, new BCJDecoder(new IA64Options()));
            put(SevenZMethod.BCJ_ARM_FILTER, new BCJDecoder(new ARMOptions()));
            put(SevenZMethod.BCJ_ARM_THUMB_FILTER, new BCJDecoder(new ARMThumbOptions()));
            put(SevenZMethod.BCJ_SPARC_FILTER, new BCJDecoder(new SPARCOptions()));
            put(SevenZMethod.DELTA_FILTER, new DeltaDecoder());
        }
    };

    Coders() {
    }

    static CoderBase findByMethod(SevenZMethod method) {
        return CODER_MAP.get(method);
    }

    static InputStream addDecoder(String archiveName, InputStream is, long uncompressedLength, Coder coder, byte[] password) throws IOException {
        CoderBase cb = findByMethod(SevenZMethod.byId(coder.decompressionMethodId));
        if (cb == null) {
            throw new IOException("Unsupported compression method " + Arrays.toString(coder.decompressionMethodId) + " used in " + archiveName);
        }
        return cb.decode(archiveName, is, uncompressedLength, coder, password);
    }

    static OutputStream addEncoder(OutputStream out, SevenZMethod method, Object options) throws IOException {
        CoderBase cb = findByMethod(method);
        if (cb == null) {
            throw new IOException("Unsupported compression method " + method);
        }
        return cb.encode(out, options);
    }

    static class CopyDecoder extends CoderBase {
        CopyDecoder() {
            super(new Class[0]);
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        InputStream decode(String archiveName, InputStream in, long uncompressedLength, Coder coder, byte[] password) throws IOException {
            return in;
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        OutputStream encode(OutputStream out, Object options) {
            return out;
        }
    }

    static class LZMADecoder extends CoderBase {
        LZMADecoder() {
            super(new Class[0]);
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        InputStream decode(String archiveName, InputStream in, long uncompressedLength, Coder coder, byte[] password) throws IOException {
            byte propsByte = coder.properties[0];
            long dictSize = coder.properties[1];
            long dictSize2 = dictSize;
            for (int i = 1; i < 4; i++) {
                dictSize2 |= (((long) coder.properties[i + 1]) & 255) << (i * 8);
            }
            if (dictSize2 > 2147483632) {
                throw new IOException("Dictionary larger than 4GiB maximum size used in " + archiveName);
            }
            return new LZMAInputStream(in, uncompressedLength, propsByte, (int) dictSize2);
        }
    }

    static class BCJDecoder extends CoderBase {
        private final FilterOptions opts;

        BCJDecoder(FilterOptions opts) {
            super(new Class[0]);
            this.opts = opts;
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        InputStream decode(String archiveName, InputStream in, long uncompressedLength, Coder coder, byte[] password) throws IOException {
            try {
                return this.opts.getInputStream(in);
            } catch (AssertionError e) {
                throw new IOException("BCJ filter used in " + archiveName + " needs XZ for Java > 1.4 - see http://commons.apache.org/proper/commons-compress/limitations.html#7Z", e);
            }
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        OutputStream encode(OutputStream out, Object options) {
            FinishableOutputStream fo = this.opts.getOutputStream(new FinishableWrapperOutputStream(out));
            return new FilterOutputStream(fo) { // from class: org.apache.commons.compress.archivers.sevenz.Coders.BCJDecoder.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
                public void flush() {
                }
            };
        }
    }

    static class DeflateDecoder extends CoderBase {
        DeflateDecoder() {
            super(Number.class);
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        InputStream decode(String archiveName, InputStream in, long uncompressedLength, Coder coder, byte[] password) throws IOException {
            final Inflater inflater = new Inflater(true);
            final InflaterInputStream inflaterInputStream = new InflaterInputStream(new DummyByteAddingInputStream(in), inflater);
            return new InputStream() { // from class: org.apache.commons.compress.archivers.sevenz.Coders.DeflateDecoder.1
                @Override // java.io.InputStream
                public int read() throws IOException {
                    return inflaterInputStream.read();
                }

                @Override // java.io.InputStream
                public int read(byte[] b, int off, int len) throws IOException {
                    return inflaterInputStream.read(b, off, len);
                }

                @Override // java.io.InputStream
                public int read(byte[] b) throws IOException {
                    return inflaterInputStream.read(b);
                }

                @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    try {
                        inflaterInputStream.close();
                    } finally {
                        inflater.end();
                    }
                }
            };
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        OutputStream encode(OutputStream out, Object options) {
            int level = numberOptionOrDefault(options, 9);
            final Deflater deflater = new Deflater(level, true);
            final DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(out, deflater);
            return new OutputStream() { // from class: org.apache.commons.compress.archivers.sevenz.Coders.DeflateDecoder.2
                @Override // java.io.OutputStream
                public void write(int b) throws IOException {
                    deflaterOutputStream.write(b);
                }

                @Override // java.io.OutputStream
                public void write(byte[] b) throws IOException {
                    deflaterOutputStream.write(b);
                }

                @Override // java.io.OutputStream
                public void write(byte[] b, int off, int len) throws IOException {
                    deflaterOutputStream.write(b, off, len);
                }

                @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    try {
                        deflaterOutputStream.close();
                    } finally {
                        deflater.end();
                    }
                }
            };
        }
    }

    static class BZIP2Decoder extends CoderBase {
        BZIP2Decoder() {
            super(Number.class);
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        InputStream decode(String archiveName, InputStream in, long uncompressedLength, Coder coder, byte[] password) throws IOException {
            return new BZip2CompressorInputStream(in);
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        OutputStream encode(OutputStream out, Object options) throws IOException {
            int blockSize = numberOptionOrDefault(options, 9);
            return new BZip2CompressorOutputStream(out, blockSize);
        }
    }

    private static class DummyByteAddingInputStream extends FilterInputStream {
        private boolean addDummyByte;

        private DummyByteAddingInputStream(InputStream in) {
            super(in);
            this.addDummyByte = true;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int result = super.read();
            if (result == -1 && this.addDummyByte) {
                this.addDummyByte = false;
                return 0;
            }
            return result;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] b, int off, int len) throws IOException {
            int result = super.read(b, off, len);
            if (result == -1 && this.addDummyByte) {
                this.addDummyByte = false;
                b[off] = 0;
                return 1;
            }
            return result;
        }
    }
}
