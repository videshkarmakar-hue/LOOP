package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import kotlin.UByte;

/* JADX INFO: loaded from: classes18.dex */
public final class ZipLong implements Cloneable, Serializable {
    private static final int BYTE_1 = 1;
    private static final int BYTE_1_MASK = 65280;
    private static final int BYTE_1_SHIFT = 8;
    private static final int BYTE_2 = 2;
    private static final int BYTE_2_MASK = 16711680;
    private static final int BYTE_2_SHIFT = 16;
    private static final int BYTE_3 = 3;
    private static final long BYTE_3_MASK = 4278190080L;
    private static final int BYTE_3_SHIFT = 24;
    private static final long serialVersionUID = 1;
    private final long value;
    public static final ZipLong CFH_SIG = new ZipLong(33639248);
    public static final ZipLong LFH_SIG = new ZipLong(67324752);
    public static final ZipLong DD_SIG = new ZipLong(134695760);
    static final ZipLong ZIP64_MAGIC = new ZipLong(4294967295L);
    public static final ZipLong SINGLE_SEGMENT_SPLIT_MARKER = new ZipLong(808471376);
    public static final ZipLong AED_SIG = new ZipLong(134630224);

    public ZipLong(long value) {
        this.value = value;
    }

    public ZipLong(byte[] bytes) {
        this(bytes, 0);
    }

    public ZipLong(byte[] bytes, int offset) {
        this.value = getValue(bytes, offset);
    }

    public byte[] getBytes() {
        return getBytes(this.value);
    }

    public long getValue() {
        return this.value;
    }

    public static byte[] getBytes(long value) {
        byte[] result = new byte[4];
        putLong(value, result, 0);
        return result;
    }

    public static void putLong(long value, byte[] buf, int offset) {
        int offset2 = offset + 1;
        buf[offset] = (byte) (255 & value);
        int offset3 = offset2 + 1;
        buf[offset2] = (byte) ((65280 & value) >> 8);
        buf[offset3] = (byte) ((16711680 & value) >> 16);
        buf[offset3 + 1] = (byte) ((BYTE_3_MASK & value) >> 24);
    }

    public void putLong(byte[] buf, int offset) {
        putLong(this.value, buf, offset);
    }

    public static long getValue(byte[] bytes, int offset) {
        long value = ((long) (bytes[offset + 3] << 24)) & BYTE_3_MASK;
        return value + ((long) ((bytes[offset + 2] << 16) & BYTE_2_MASK)) + ((long) ((bytes[offset + 1] << 8) & 65280)) + ((long) (bytes[offset] & UByte.MAX_VALUE));
    }

    public static long getValue(byte[] bytes) {
        return getValue(bytes, 0);
    }

    public boolean equals(Object o) {
        return o != null && (o instanceof ZipLong) && this.value == ((ZipLong) o).getValue();
    }

    public int hashCode() {
        return (int) this.value;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException cnfe) {
            throw new RuntimeException(cnfe);
        }
    }

    public String toString() {
        return "ZipLong value: " + this.value;
    }
}
