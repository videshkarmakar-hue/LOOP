package org.apache.commons.compress.compressors.snappy;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Arrays;
import kotlin.UByte;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes18.dex */
public class FramedSnappyCompressorInputStream extends CompressorInputStream {
    private static final int COMPRESSED_CHUNK_TYPE = 0;
    static final long MASK_OFFSET = 2726488792L;
    private static final int MAX_SKIPPABLE_TYPE = 253;
    private static final int MAX_UNSKIPPABLE_TYPE = 127;
    private static final int MIN_UNSKIPPABLE_TYPE = 2;
    private static final int PADDING_CHUNK_TYPE = 254;
    private static final int STREAM_IDENTIFIER_TYPE = 255;
    private static final byte[] SZ_SIGNATURE = {-1, 6, 0, 0, 115, 78, 97, 80, 112, 89};
    private static final int UNCOMPRESSED_CHUNK_TYPE = 1;
    private final PureJavaCrc32C checksum;
    private SnappyCompressorInputStream currentCompressedChunk;
    private final FramedSnappyDialect dialect;
    private boolean endReached;
    private long expectedChecksum;

    /* JADX INFO: renamed from: in */
    private final PushbackInputStream f589in;
    private boolean inUncompressedChunk;
    private final byte[] oneByte;
    private int uncompressedBytesRemaining;

    public FramedSnappyCompressorInputStream(InputStream in) throws IOException {
        this(in, FramedSnappyDialect.STANDARD);
    }

    public FramedSnappyCompressorInputStream(InputStream in, FramedSnappyDialect dialect) throws IOException {
        this.oneByte = new byte[1];
        this.expectedChecksum = -1L;
        this.checksum = new PureJavaCrc32C();
        this.f589in = new PushbackInputStream(in, 1);
        this.dialect = dialect;
        if (dialect.hasStreamIdentifier()) {
            readStreamIdentifier();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.oneByte, 0, 1) == -1) {
            return -1;
        }
        return this.oneByte[0] & UByte.MAX_VALUE;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.currentCompressedChunk != null) {
            this.currentCompressedChunk.close();
            this.currentCompressedChunk = null;
        }
        this.f589in.close();
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        int read = readOnce(b, off, len);
        if (read == -1) {
            readNextBlock();
            if (this.endReached) {
                return -1;
            }
            return readOnce(b, off, len);
        }
        return read;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.inUncompressedChunk) {
            return Math.min(this.uncompressedBytesRemaining, this.f589in.available());
        }
        if (this.currentCompressedChunk != null) {
            return this.currentCompressedChunk.available();
        }
        return 0;
    }

    private int readOnce(byte[] b, int off, int len) throws IOException {
        int read = -1;
        if (this.inUncompressedChunk) {
            int amount = Math.min(this.uncompressedBytesRemaining, len);
            if (amount == 0) {
                return -1;
            }
            read = this.f589in.read(b, off, amount);
            if (read != -1) {
                this.uncompressedBytesRemaining -= read;
                count(read);
            }
        } else if (this.currentCompressedChunk != null) {
            long before = this.currentCompressedChunk.getBytesRead();
            read = this.currentCompressedChunk.read(b, off, len);
            if (read == -1) {
                this.currentCompressedChunk.close();
                this.currentCompressedChunk = null;
            } else {
                count(this.currentCompressedChunk.getBytesRead() - before);
            }
        }
        if (read > 0) {
            this.checksum.update(b, off, read);
        }
        return read;
    }

    private void readNextBlock() throws IOException {
        verifyLastChecksumAndReset();
        this.inUncompressedChunk = false;
        int type = readOneByte();
        if (type == -1) {
            this.endReached = true;
            return;
        }
        if (type == 255) {
            this.f589in.unread(type);
            pushedBackBytes(1L);
            readStreamIdentifier();
            readNextBlock();
            return;
        }
        if (type == PADDING_CHUNK_TYPE || (type > 127 && type <= MAX_SKIPPABLE_TYPE)) {
            skipBlock();
            readNextBlock();
            return;
        }
        if (type >= 2 && type <= 127) {
            throw new IOException("unskippable chunk with type " + type + " (hex " + Integer.toHexString(type) + ") detected.");
        }
        if (type == 1) {
            this.inUncompressedChunk = true;
            this.uncompressedBytesRemaining = readSize() - 4;
            this.expectedChecksum = unmask(readCrc());
        } else {
            if (type == 0) {
                boolean expectChecksum = this.dialect.usesChecksumWithCompressedChunks();
                long size = readSize() - (expectChecksum ? 4 : 0);
                if (expectChecksum) {
                    this.expectedChecksum = unmask(readCrc());
                } else {
                    this.expectedChecksum = -1L;
                }
                this.currentCompressedChunk = new SnappyCompressorInputStream(new BoundedInputStream(this.f589in, size));
                count(this.currentCompressedChunk.getBytesRead());
                return;
            }
            throw new IOException("unknown chunk type " + type + " detected.");
        }
    }

    private long readCrc() throws IOException {
        byte[] b = new byte[4];
        int read = IOUtils.readFully(this.f589in, b);
        count(read);
        if (read != 4) {
            throw new IOException("premature end of stream");
        }
        long crc = 0;
        for (int i = 0; i < 4; i++) {
            crc |= (((long) b[i]) & 255) << (i * 8);
        }
        return crc;
    }

    static long unmask(long x) {
        long x2 = (x - MASK_OFFSET) & 4294967295L;
        return 4294967295L & ((x2 >> 17) | (x2 << 15));
    }

    private int readSize() throws IOException {
        int sz = 0;
        for (int i = 0; i < 3; i++) {
            int b = readOneByte();
            if (b == -1) {
                throw new IOException("premature end of stream");
            }
            sz |= b << (i * 8);
        }
        return sz;
    }

    private void skipBlock() throws IOException {
        int size = readSize();
        long read = IOUtils.skip(this.f589in, size);
        count(read);
        if (read != size) {
            throw new IOException("premature end of stream");
        }
    }

    private void readStreamIdentifier() throws IOException {
        byte[] b = new byte[10];
        int read = IOUtils.readFully(this.f589in, b);
        count(read);
        if (10 != read || !matches(b, 10)) {
            throw new IOException("Not a framed Snappy stream");
        }
    }

    private int readOneByte() throws IOException {
        int b = this.f589in.read();
        if (b == -1) {
            return -1;
        }
        count(1);
        return b & 255;
    }

    private void verifyLastChecksumAndReset() throws IOException {
        if (this.expectedChecksum >= 0 && this.expectedChecksum != this.checksum.getValue()) {
            throw new IOException("Checksum verification failed");
        }
        this.expectedChecksum = -1L;
        this.checksum.reset();
    }

    public static boolean matches(byte[] signature, int length) {
        if (length < SZ_SIGNATURE.length) {
            return false;
        }
        byte[] shortenedSig = signature;
        if (signature.length > SZ_SIGNATURE.length) {
            shortenedSig = new byte[SZ_SIGNATURE.length];
            System.arraycopy(signature, 0, shortenedSig, 0, SZ_SIGNATURE.length);
        }
        return Arrays.equals(shortenedSig, SZ_SIGNATURE);
    }
}
