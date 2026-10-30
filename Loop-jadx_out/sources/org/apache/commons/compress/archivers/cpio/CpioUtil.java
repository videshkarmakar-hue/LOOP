package org.apache.commons.compress.archivers.cpio;

import kotlin.UByte;

/* JADX INFO: loaded from: classes18.dex */
class CpioUtil {
    CpioUtil() {
    }

    static long fileType(long mode) {
        return 61440 & mode;
    }

    static long byteArray2long(byte[] number, boolean swapHalfWord) {
        if (number.length % 2 != 0) {
            throw new UnsupportedOperationException();
        }
        byte[] tmp_number = new byte[number.length];
        System.arraycopy(number, 0, tmp_number, 0, number.length);
        if (!swapHalfWord) {
            int pos = 0;
            while (pos < tmp_number.length) {
                byte tmp = tmp_number[pos];
                int pos2 = pos + 1;
                tmp_number[pos] = tmp_number[pos2];
                tmp_number[pos2] = tmp;
                pos = pos2 + 1;
            }
        }
        byte tmp2 = tmp_number[0];
        long ret = tmp2 & UByte.MAX_VALUE;
        for (int pos3 = 1; pos3 < tmp_number.length; pos3++) {
            ret = (ret << 8) | ((long) (tmp_number[pos3] & UByte.MAX_VALUE));
        }
        return ret;
    }

    static byte[] long2byteArray(long number, int length, boolean swapHalfWord) {
        byte[] ret = new byte[length];
        if (length % 2 != 0 || length < 2) {
            throw new UnsupportedOperationException();
        }
        long tmp_number = number;
        for (int pos = length - 1; pos >= 0; pos--) {
            ret[pos] = (byte) (255 & tmp_number);
            tmp_number >>= 8;
        }
        if (!swapHalfWord) {
            int pos2 = 0;
            while (pos2 < length) {
                byte tmp = ret[pos2];
                int pos3 = pos2 + 1;
                ret[pos2] = ret[pos3];
                ret[pos3] = tmp;
                pos2 = pos3 + 1;
            }
        }
        return ret;
    }
}
