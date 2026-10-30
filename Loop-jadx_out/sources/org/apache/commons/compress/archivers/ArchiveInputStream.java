package org.apache.commons.compress.archivers;

import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes18.dex */
public abstract class ArchiveInputStream extends InputStream {
    private static final int BYTE_MASK = 255;
    private final byte[] SINGLE = new byte[1];
    private long bytesRead = 0;

    public abstract ArchiveEntry getNextEntry() throws IOException;

    @Override // java.io.InputStream
    public int read() throws IOException {
        int num = read(this.SINGLE, 0, 1);
        if (num == -1) {
            return -1;
        }
        return this.SINGLE[0] & UByte.MAX_VALUE;
    }

    protected void count(int read) {
        count(read);
    }

    protected void count(long read) {
        if (read != -1) {
            this.bytesRead += read;
        }
    }

    protected void pushedBackBytes(long pushedBack) {
        this.bytesRead -= pushedBack;
    }

    @Deprecated
    public int getCount() {
        return (int) this.bytesRead;
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        return true;
    }
}
