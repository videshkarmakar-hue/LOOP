package org.apache.commons.compress.archivers.tar;

import java.io.IOException;

/* JADX INFO: loaded from: classes18.dex */
public class TarArchiveSparseEntry implements TarConstants {
    private final boolean isExtended;

    public TarArchiveSparseEntry(byte[] headerBuf) throws IOException {
        int offset = 0 + 504;
        this.isExtended = TarUtils.parseBoolean(headerBuf, offset);
    }

    public boolean isExtended() {
        return this.isExtended;
    }
}
