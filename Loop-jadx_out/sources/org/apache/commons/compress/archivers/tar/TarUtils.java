package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;

/* JADX INFO: loaded from: classes18.dex */
public class TarUtils {
    private static final int BYTE_MASK = 255;
    static final ZipEncoding DEFAULT_ENCODING = ZipEncodingHelper.getZipEncoding(null);
    static final ZipEncoding FALLBACK_ENCODING = new ZipEncoding() { // from class: org.apache.commons.compress.archivers.tar.TarUtils.1
        @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
        public boolean canEncode(String name) {
            return true;
        }

        @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
        public ByteBuffer encode(String name) {
            int length = name.length();
            byte[] buf = new byte[length];
            for (int i = 0; i < length; i++) {
                buf[i] = (byte) name.charAt(i);
            }
            return ByteBuffer.wrap(buf);
        }

        @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
        public String decode(byte[] buffer) {
            int length = buffer.length;
            StringBuilder result = new StringBuilder(length);
            for (byte b : buffer) {
                if (b == 0) {
                    break;
                }
                result.append((char) (b & UByte.MAX_VALUE));
            }
            return result.toString();
        }
    };

    private TarUtils() {
    }

    public static long parseOctal(byte[] buffer, int offset, int length) {
        long result = 0;
        int end = offset + length;
        int start = offset;
        if (length < 2) {
            throw new IllegalArgumentException("Length " + length + " must be at least 2");
        }
        if (buffer[start] == 0) {
            return 0L;
        }
        while (start < end && buffer[start] == 32) {
            start++;
        }
        byte trailer = buffer[end - 1];
        while (start < end && (trailer == 0 || trailer == 32)) {
            end--;
            trailer = buffer[end - 1];
        }
        while (start < end) {
            byte currentByte = buffer[start];
            if (currentByte < 48 || currentByte > 55) {
                throw new IllegalArgumentException(exceptionMessage(buffer, offset, length, start, currentByte));
            }
            result = (result << 3) + ((long) (currentByte - 48));
            start++;
        }
        return result;
    }

    public static long parseOctalOrBinary(byte[] buffer, int offset, int length) {
        if ((buffer[offset] & ByteCompanionObject.MIN_VALUE) == 0) {
            return parseOctal(buffer, offset, length);
        }
        boolean negative = buffer[offset] == -1;
        if (length < 9) {
            return parseBinaryLong(buffer, offset, length, negative);
        }
        return parseBinaryBigInteger(buffer, offset, length, negative);
    }

    private static long parseBinaryLong(byte[] buffer, int offset, int length, boolean negative) {
        if (length >= 9) {
            throw new IllegalArgumentException("At offset " + offset + ", " + length + " byte binary number exceeds maximum signed long value");
        }
        long val = 0;
        for (int i = 1; i < length; i++) {
            val = (val << 8) + ((long) (buffer[offset + i] & UByte.MAX_VALUE));
        }
        if (negative) {
            val = (val - 1) ^ (((long) Math.pow(2.0d, (length - 1) * 8)) - 1);
        }
        return negative ? -val : val;
    }

    private static long parseBinaryBigInteger(byte[] buffer, int offset, int length, boolean negative) {
        byte[] remainder = new byte[length - 1];
        System.arraycopy(buffer, offset + 1, remainder, 0, length - 1);
        BigInteger val = new BigInteger(remainder);
        if (negative) {
            val = val.add(BigInteger.valueOf(-1L)).not();
        }
        if (val.bitLength() > 63) {
            throw new IllegalArgumentException("At offset " + offset + ", " + length + " byte binary number exceeds maximum signed long value");
        }
        long jLongValue = val.longValue();
        return negative ? -jLongValue : jLongValue;
    }

    public static boolean parseBoolean(byte[] buffer, int offset) {
        return buffer[offset] == 1;
    }

    private static String exceptionMessage(byte[] buffer, int offset, int length, int current, byte currentByte) {
        String string = new String(buffer, offset, length);
        String s = "Invalid byte " + ((int) currentByte) + " at offset " + (current - offset) + " in '" + string.replaceAll("\u0000", "{NUL}") + "' len=" + length;
        return s;
    }

    public static String parseName(byte[] buffer, int offset, int length) {
        try {
            return parseName(buffer, offset, length, DEFAULT_ENCODING);
        } catch (IOException e) {
            try {
                return parseName(buffer, offset, length, FALLBACK_ENCODING);
            } catch (IOException ex2) {
                throw new RuntimeException(ex2);
            }
        }
    }

    public static String parseName(byte[] buffer, int offset, int length, ZipEncoding encoding) throws IOException {
        int len = length;
        while (len > 0 && buffer[(offset + len) - 1] == 0) {
            len--;
        }
        if (len > 0) {
            byte[] b = new byte[len];
            System.arraycopy(buffer, offset, b, 0, len);
            return encoding.decode(b);
        }
        return "";
    }

    public static int formatNameBytes(String name, byte[] buf, int offset, int length) {
        try {
            return formatNameBytes(name, buf, offset, length, DEFAULT_ENCODING);
        } catch (IOException e) {
            try {
                return formatNameBytes(name, buf, offset, length, FALLBACK_ENCODING);
            } catch (IOException ex2) {
                throw new RuntimeException(ex2);
            }
        }
    }

    public static int formatNameBytes(String name, byte[] buf, int offset, int length, ZipEncoding encoding) throws IOException {
        int len = name.length();
        ByteBuffer b = encoding.encode(name);
        while (b.limit() > length && len > 0) {
            len--;
            b = encoding.encode(name.substring(0, len));
        }
        int limit = b.limit() - b.position();
        System.arraycopy(b.array(), b.arrayOffset(), buf, offset, limit);
        for (int i = limit; i < length; i++) {
            buf[offset + i] = 0;
        }
        return offset + length;
    }

    public static void formatUnsignedOctalString(long value, byte[] buffer, int offset, int length) {
        int remaining;
        int remaining2 = length - 1;
        if (value == 0) {
            remaining = remaining2 - 1;
            buffer[remaining2 + offset] = TarConstants.LF_NORMAL;
        } else {
            long val = value;
            while (remaining2 >= 0 && val != 0) {
                buffer[offset + remaining2] = (byte) (((byte) (7 & val)) + TarConstants.LF_NORMAL);
                val >>>= 3;
                remaining2--;
            }
            if (val != 0) {
                throw new IllegalArgumentException(value + "=" + Long.toOctalString(value) + " will not fit in octal number buffer of length " + length);
            }
            remaining = remaining2;
        }
        while (remaining >= 0) {
            buffer[offset + remaining] = TarConstants.LF_NORMAL;
            remaining--;
        }
    }

    public static int formatOctalBytes(long value, byte[] buf, int offset, int length) {
        int idx = length - 2;
        formatUnsignedOctalString(value, buf, offset, idx);
        buf[idx + offset] = 32;
        buf[offset + idx + 1] = 0;
        return offset + length;
    }

    public static int formatLongOctalBytes(long value, byte[] buf, int offset, int length) {
        int idx = length - 1;
        formatUnsignedOctalString(value, buf, offset, idx);
        buf[offset + idx] = 32;
        return offset + length;
    }

    public static int formatLongOctalOrBinaryBytes(long value, byte[] buf, int offset, int length) {
        long maxAsOctalChar = length == 8 ? TarConstants.MAXID : TarConstants.MAXSIZE;
        boolean negative = value < 0;
        if (!negative && value <= maxAsOctalChar) {
            return formatLongOctalBytes(value, buf, offset, length);
        }
        if (length < 9) {
            formatLongBinary(value, buf, offset, length, negative);
        }
        formatBigIntegerBinary(value, buf, offset, length, negative);
        buf[offset] = (byte) (negative ? 255 : 128);
        return offset + length;
    }

    private static void formatLongBinary(long value, byte[] buf, int offset, int length, boolean negative) {
        int bits = (length - 1) * 8;
        long max = 1 << bits;
        long val = Math.abs(value);
        if (val >= max) {
            throw new IllegalArgumentException("Value " + value + " is too large for " + length + " byte field.");
        }
        if (negative) {
            val = ((val ^ (max - 1)) | ((long) (255 << bits))) + 1;
        }
        for (int i = (offset + length) - 1; i >= offset; i--) {
            buf[i] = (byte) val;
            val >>= 8;
        }
    }

    private static void formatBigIntegerBinary(long value, byte[] buf, int offset, int length, boolean negative) {
        BigInteger val = BigInteger.valueOf(value);
        byte[] b = val.toByteArray();
        int len = b.length;
        int off = (offset + length) - len;
        System.arraycopy(b, 0, buf, off, len);
        byte fill = (byte) (negative ? 255 : 0);
        for (int i = offset + 1; i < off; i++) {
            buf[i] = fill;
        }
    }

    public static int formatCheckSumOctalBytes(long value, byte[] buf, int offset, int length) {
        int idx = length - 2;
        formatUnsignedOctalString(value, buf, offset, idx);
        buf[idx + offset] = 0;
        buf[offset + idx + 1] = 32;
        return offset + length;
    }

    public static long computeCheckSum(byte[] buf) {
        long sum = 0;
        for (byte element : buf) {
            sum += (long) (element & UByte.MAX_VALUE);
        }
        return sum;
    }

    public static boolean verifyCheckSum(byte[] header) {
        long storedSum = parseOctal(header, TarConstants.CHKSUM_OFFSET, 8);
        long unsignedSum = 0;
        long signedSum = 0;
        for (int i = 0; i < header.length; i++) {
            byte b = header[i];
            if (148 <= i && i < 156) {
                b = 32;
            }
            unsignedSum += (long) (b & UByte.MAX_VALUE);
            signedSum += (long) b;
        }
        return storedSum == unsignedSum || storedSum == signedSum;
    }
}
