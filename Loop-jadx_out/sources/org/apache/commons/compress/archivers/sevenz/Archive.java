package org.apache.commons.compress.archivers.sevenz;

import java.util.BitSet;

/* JADX INFO: loaded from: classes18.dex */
class Archive {
    SevenZArchiveEntry[] files;
    Folder[] folders;
    long[] packCrcs;
    BitSet packCrcsDefined;
    long packPos;
    long[] packSizes;
    StreamMap streamMap;
    SubStreamsInfo subStreamsInfo;

    Archive() {
    }

    public String toString() {
        return "Archive with packed streams starting at offset " + this.packPos + ", " + lengthOf(this.packSizes) + " pack sizes, " + lengthOf(this.packCrcs) + " CRCs, " + lengthOf(this.folders) + " folders, " + lengthOf(this.files) + " files and " + this.streamMap;
    }

    private static String lengthOf(long[] a) {
        return a == null ? "(null)" : String.valueOf(a.length);
    }

    private static String lengthOf(Object[] a) {
        return a == null ? "(null)" : String.valueOf(a.length);
    }
}
