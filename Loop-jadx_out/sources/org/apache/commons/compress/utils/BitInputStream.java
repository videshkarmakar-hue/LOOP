package org.apache.commons.compress.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes18.dex */
public class BitInputStream implements Closeable {
    private static final long[] MASKS = new long[64];
    private static final int MAXIMUM_CACHE_SIZE = 63;
    private long bitsCached = 0;
    private int bitsCachedSize = 0;
    private final ByteOrder byteOrder;

    /* JADX INFO: renamed from: in */
    private final InputStream f594in;

    static {
        for (int i = 1; i <= 63; i++) {
            MASKS[i] = (MASKS[i - 1] << 1) + 1;
        }
    }

    public BitInputStream(InputStream in, ByteOrder byteOrder) {
        this.f594in = in;
        this.byteOrder = byteOrder;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f594in.close();
    }

    public void clearBitCache() {
        this.bitsCached = 0L;
        this.bitsCachedSize = 0;
    }

    public long readBits(int count) throws IOException {
        long bitsOut;
        if (count < 0 || count > 63) {
            throw new IllegalArgumentException("count must not be negative or greater than 63");
        }
        while (this.bitsCachedSize < count) {
            long nextByte = this.f594in.read();
            if (nextByte < 0) {
                return nextByte;
            }
            if (this.byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.bitsCached |= nextByte << this.bitsCachedSize;
            } else {
                this.bitsCached <<= 8;
                this.bitsCached |= nextByte;
            }
            this.bitsCachedSize += 8;
        }
        if (this.byteOrder == ByteOrder.LITTLE_ENDIAN) {
            bitsOut = this.bitsCached & MASKS[count];
            this.bitsCached >>>= count;
        } else {
            long bitsOut2 = this.bitsCached;
            bitsOut = (bitsOut2 >> (this.bitsCachedSize - count)) & MASKS[count];
        }
        this.bitsCachedSize -= count;
        return bitsOut;
    }
}
