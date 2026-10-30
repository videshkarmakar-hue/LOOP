package org.apache.commons.compress.archivers.dump;

import androidx.core.view.MotionEventCompat;
import java.io.IOException;
import kotlin.UByte;
import org.apache.commons.compress.archivers.zip.ZipEncoding;

/* JADX INFO: loaded from: classes18.dex */
class DumpArchiveUtil {
    private DumpArchiveUtil() {
    }

    public static int calculateChecksum(byte[] buffer) {
        int calc = 0;
        for (int i = 0; i < 256; i++) {
            calc += convert32(buffer, i * 4);
        }
        return DumpArchiveConstants.CHECKSUM - (calc - convert32(buffer, 28));
    }

    public static final boolean verify(byte[] buffer) {
        int magic = convert32(buffer, 24);
        if (magic != 60012) {
            return false;
        }
        int checksum = convert32(buffer, 28);
        return checksum == calculateChecksum(buffer);
    }

    public static final int getIno(byte[] buffer) {
        return convert32(buffer, 20);
    }

    public static final long convert64(byte[] buffer, int offset) {
        long i = 0 + (((long) buffer[offset + 7]) << 56);
        return i + ((((long) buffer[offset + 6]) << 48) & 71776119061217280L) + ((((long) buffer[offset + 5]) << 40) & 280375465082880L) + ((((long) buffer[offset + 4]) << 32) & 1095216660480L) + ((((long) buffer[offset + 3]) << 24) & 4278190080L) + ((((long) buffer[offset + 2]) << 16) & 16711680) + ((((long) buffer[offset + 1]) << 8) & 65280) + (((long) buffer[offset]) & 255);
    }

    public static final int convert32(byte[] buffer, int offset) {
        int i = buffer[offset + 3] << 24;
        return i + ((buffer[offset + 2] << 16) & 16711680) + ((buffer[offset + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (buffer[offset] & UByte.MAX_VALUE);
    }

    public static final int convert16(byte[] buffer, int offset) {
        int i = 0 + ((buffer[offset + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
        return i + (buffer[offset] & UByte.MAX_VALUE);
    }

    static String decode(ZipEncoding encoding, byte[] b, int offset, int len) throws IOException {
        byte[] copy = new byte[len];
        System.arraycopy(b, offset, copy, 0, len);
        return encoding.decode(copy);
    }
}
