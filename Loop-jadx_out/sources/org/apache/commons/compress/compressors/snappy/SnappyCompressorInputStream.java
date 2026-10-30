package org.apache.commons.compress.compressors.snappy;

import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes18.dex */
public class SnappyCompressorInputStream extends CompressorInputStream {
    public static final int DEFAULT_BLOCK_SIZE = 32768;
    private static final int TAG_MASK = 3;
    private final int blockSize;
    private final byte[] decompressBuf;
    private boolean endReached;

    /* JADX INFO: renamed from: in */
    private final InputStream f591in;
    private final byte[] oneByte;
    private int readIndex;
    private final int size;
    private int uncompressedBytesRemaining;
    private int writeIndex;

    public SnappyCompressorInputStream(InputStream is) throws IOException {
        this(is, 32768);
    }

    public SnappyCompressorInputStream(InputStream is, int blockSize) throws IOException {
        this.oneByte = new byte[1];
        this.endReached = false;
        this.f591in = is;
        this.blockSize = blockSize;
        this.decompressBuf = new byte[blockSize * 3];
        this.readIndex = 0;
        this.writeIndex = 0;
        int size = (int) readSize();
        this.size = size;
        this.uncompressedBytesRemaining = size;
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
        this.f591in.close();
    }

    @Override // java.io.InputStream
    public int available() {
        return this.writeIndex - this.readIndex;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        if (this.endReached) {
            return -1;
        }
        int avail = available();
        if (len > avail) {
            fill(len - avail);
        }
        int readable = Math.min(len, available());
        if (readable == 0 && len > 0) {
            return -1;
        }
        System.arraycopy(this.decompressBuf, this.readIndex, b, off, readable);
        this.readIndex += readable;
        if (this.readIndex > this.blockSize) {
            slideBuffer();
        }
        return readable;
    }

    private void fill(int len) throws IOException {
        if (this.uncompressedBytesRemaining == 0) {
            this.endReached = true;
        }
        int readNow = Math.min(len, this.uncompressedBytesRemaining);
        while (readNow > 0) {
            int b = readOneByte();
            int length = 0;
            switch (b & 3) {
                case 0:
                    length = readLiteralLength(b);
                    if (expandLiteral(length)) {
                        return;
                    }
                    break;
                case 1:
                    length = ((b >> 2) & 7) + 4;
                    long offset = (b & 224) << 3;
                    if (expandCopy(offset | ((long) readOneByte()), length)) {
                        return;
                    }
                    break;
                case 2:
                    length = (b >> 2) + 1;
                    long offset2 = readOneByte();
                    if (expandCopy(offset2 | ((long) (readOneByte() << 8)), length)) {
                        return;
                    }
                    break;
                case 3:
                    length = (b >> 2) + 1;
                    long offset3 = readOneByte();
                    if (expandCopy(offset3 | ((long) (readOneByte() << 8)) | ((long) (readOneByte() << 16)) | (((long) readOneByte()) << 24), length)) {
                        return;
                    }
                    break;
            }
            readNow -= length;
            this.uncompressedBytesRemaining -= length;
        }
    }

    private void slideBuffer() {
        System.arraycopy(this.decompressBuf, this.blockSize, this.decompressBuf, 0, this.blockSize * 2);
        this.writeIndex -= this.blockSize;
        this.readIndex -= this.blockSize;
    }

    private int readLiteralLength(int b) throws IOException {
        int length;
        switch (b >> 2) {
            case 60:
                length = readOneByte();
                break;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                int length2 = readOneByte();
                length = length2 | (readOneByte() << 8);
                break;
            case 62:
                int length3 = readOneByte();
                length = length3 | (readOneByte() << 8) | (readOneByte() << 16);
                break;
            case 63:
                int length4 = readOneByte();
                length = (int) (((long) (length4 | (readOneByte() << 8) | (readOneByte() << 16))) | (((long) readOneByte()) << 24));
                break;
            default:
                length = b >> 2;
                break;
        }
        return length + 1;
    }

    private boolean expandLiteral(int length) throws IOException {
        int bytesRead = IOUtils.readFully(this.f591in, this.decompressBuf, this.writeIndex, length);
        count(bytesRead);
        if (length != bytesRead) {
            throw new IOException("Premature end of stream");
        }
        this.writeIndex += length;
        return this.writeIndex >= this.blockSize * 2;
    }

    private boolean expandCopy(long off, int length) throws IOException {
        if (off > this.blockSize) {
            throw new IOException("Offset is larger than block size");
        }
        int offset = (int) off;
        if (offset == 1) {
            byte lastChar = this.decompressBuf[this.writeIndex - 1];
            for (int i = 0; i < length; i++) {
                byte[] bArr = this.decompressBuf;
                int i2 = this.writeIndex;
                this.writeIndex = i2 + 1;
                bArr[i2] = lastChar;
            }
        } else if (length < offset) {
            System.arraycopy(this.decompressBuf, this.writeIndex - offset, this.decompressBuf, this.writeIndex, length);
            this.writeIndex += length;
        } else {
            int fullRotations = length / offset;
            int pad = length - (offset * fullRotations);
            while (true) {
                int fullRotations2 = fullRotations - 1;
                if (fullRotations == 0) {
                    break;
                }
                System.arraycopy(this.decompressBuf, this.writeIndex - offset, this.decompressBuf, this.writeIndex, offset);
                this.writeIndex += offset;
                fullRotations = fullRotations2;
            }
            if (pad > 0) {
                System.arraycopy(this.decompressBuf, this.writeIndex - offset, this.decompressBuf, this.writeIndex, pad);
                this.writeIndex += pad;
            }
        }
        return this.writeIndex >= this.blockSize * 2;
    }

    private int readOneByte() throws IOException {
        int b = this.f591in.read();
        if (b == -1) {
            throw new IOException("Premature end of stream");
        }
        count(1);
        return b & 255;
    }

    private long readSize() throws IOException {
        int index = 0;
        long sz = 0;
        while (true) {
            int b = readOneByte();
            int index2 = index + 1;
            sz |= (long) ((b & 127) << (index * 7));
            if ((b & 128) != 0) {
                index = index2;
            } else {
                return sz;
            }
        }
    }

    public int getSize() {
        return this.size;
    }
}
