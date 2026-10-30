package org.apache.commons.compress.archivers.zip;

import androidx.compose.p001ui.geometry.InlineClassHelperKt;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes18.dex */
public class ZipFile implements Closeable {
    static final int BYTE_SHIFT = 8;
    private static final int CFD_LOCATOR_OFFSET = 16;
    private static final int CFH_LEN = 42;
    private static final long CFH_SIG = ZipLong.getValue(ZipArchiveOutputStream.CFH_SIG);
    private static final int HASH_SIZE = 509;
    private static final long LFH_OFFSET_FOR_FILENAME_LENGTH = 26;
    private static final int MAX_EOCD_SIZE = 65557;
    static final int MIN_EOCD_SIZE = 22;
    static final int NIBLET_MASK = 15;
    private static final int POS_0 = 0;
    private static final int POS_1 = 1;
    private static final int POS_2 = 2;
    private static final int POS_3 = 3;
    private static final int ZIP64_EOCDL_LENGTH = 20;
    private static final int ZIP64_EOCDL_LOCATOR_OFFSET = 8;
    private static final int ZIP64_EOCD_CFD_LOCATOR_OFFSET = 48;
    private final byte[] CFH_BUF;
    private final byte[] DWORD_BUF;
    private final Comparator<ZipArchiveEntry> OFFSET_COMPARATOR;
    private final byte[] SHORT_BUF;
    private final byte[] WORD_BUF;
    private final RandomAccessFile archive;
    private final String archiveName;
    private volatile boolean closed;
    private final String encoding;
    private final List<ZipArchiveEntry> entries;
    private final Map<String, LinkedList<ZipArchiveEntry>> nameMap;
    private final boolean useUnicodeExtraFields;
    private final ZipEncoding zipEncoding;

    private static final class OffsetEntry {
        private long dataOffset;
        private long headerOffset;

        private OffsetEntry() {
            this.headerOffset = -1L;
            this.dataOffset = -1L;
        }
    }

    public ZipFile(File f) throws IOException {
        this(f, "UTF8");
    }

    public ZipFile(String name) throws IOException {
        this(new File(name), "UTF8");
    }

    public ZipFile(String name, String encoding) throws IOException {
        this(new File(name), encoding, true);
    }

    public ZipFile(File f, String encoding) throws IOException {
        this(f, encoding, true);
    }

    public ZipFile(File f, String encoding, boolean useUnicodeExtraFields) throws IOException {
        this.entries = new LinkedList();
        this.nameMap = new HashMap(HASH_SIZE);
        this.closed = true;
        this.DWORD_BUF = new byte[8];
        this.WORD_BUF = new byte[4];
        this.CFH_BUF = new byte[42];
        this.SHORT_BUF = new byte[2];
        this.OFFSET_COMPARATOR = new Comparator<ZipArchiveEntry>() { // from class: org.apache.commons.compress.archivers.zip.ZipFile.2
            @Override // java.util.Comparator
            public int compare(ZipArchiveEntry e1, ZipArchiveEntry e2) {
                if (e1 == e2) {
                    return 0;
                }
                Entry ent1 = e1 instanceof Entry ? (Entry) e1 : null;
                Entry ent2 = e2 instanceof Entry ? (Entry) e2 : null;
                if (ent1 == null) {
                    return 1;
                }
                if (ent2 != null) {
                    long val = ent1.getOffsetEntry().headerOffset - ent2.getOffsetEntry().headerOffset;
                    if (val == 0) {
                        return 0;
                    }
                    return val < 0 ? -1 : 1;
                }
                return -1;
            }
        };
        this.archiveName = f.getAbsolutePath();
        this.encoding = encoding;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(encoding);
        this.useUnicodeExtraFields = useUnicodeExtraFields;
        this.archive = new RandomAccessFile(f, "r");
        boolean success = false;
        try {
            Map<ZipArchiveEntry, NameAndComment> entriesWithoutUTF8Flag = populateFromCentralDirectory();
            resolveLocalFileHeaderData(entriesWithoutUTF8Flag);
            success = true;
        } finally {
            this.closed = !success;
            if (!success) {
                IOUtils.closeQuietly(this.archive);
            }
        }
    }

    public String getEncoding() {
        return this.encoding;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        this.archive.close();
    }

    public static void closeQuietly(ZipFile zipfile) {
        IOUtils.closeQuietly(zipfile);
    }

    public Enumeration<ZipArchiveEntry> getEntries() {
        return Collections.enumeration(this.entries);
    }

    public Enumeration<ZipArchiveEntry> getEntriesInPhysicalOrder() {
        ZipArchiveEntry[] allEntries = (ZipArchiveEntry[]) this.entries.toArray(new ZipArchiveEntry[this.entries.size()]);
        Arrays.sort(allEntries, this.OFFSET_COMPARATOR);
        return Collections.enumeration(Arrays.asList(allEntries));
    }

    public ZipArchiveEntry getEntry(String name) {
        LinkedList<ZipArchiveEntry> entriesOfThatName = this.nameMap.get(name);
        if (entriesOfThatName != null) {
            return entriesOfThatName.getFirst();
        }
        return null;
    }

    public Iterable<ZipArchiveEntry> getEntries(String name) {
        List<ZipArchiveEntry> entriesOfThatName = this.nameMap.get(name);
        return entriesOfThatName != null ? entriesOfThatName : Collections.emptyList();
    }

    public Iterable<ZipArchiveEntry> getEntriesInPhysicalOrder(String name) {
        ZipArchiveEntry[] entriesOfThatName = new ZipArchiveEntry[0];
        if (this.nameMap.containsKey(name)) {
            entriesOfThatName = (ZipArchiveEntry[]) this.nameMap.get(name).toArray(entriesOfThatName);
            Arrays.sort(entriesOfThatName, this.OFFSET_COMPARATOR);
        }
        return Arrays.asList(entriesOfThatName);
    }

    public boolean canReadEntryData(ZipArchiveEntry ze) {
        return ZipUtil.canHandleEntryData(ze);
    }

    public InputStream getRawInputStream(ZipArchiveEntry ze) {
        if (!(ze instanceof Entry)) {
            return null;
        }
        OffsetEntry offsetEntry = ((Entry) ze).getOffsetEntry();
        long start = offsetEntry.dataOffset;
        return new BoundedInputStream(start, ze.getCompressedSize());
    }

    public void copyRawEntries(ZipArchiveOutputStream target, ZipArchiveEntryPredicate predicate) throws IOException {
        Enumeration<ZipArchiveEntry> src = getEntriesInPhysicalOrder();
        while (src.hasMoreElements()) {
            ZipArchiveEntry entry = src.nextElement();
            if (predicate.test(entry)) {
                target.addRawArchiveEntry(entry, getRawInputStream(entry));
            }
        }
    }

    public InputStream getInputStream(ZipArchiveEntry ze) throws IOException {
        if (!(ze instanceof Entry)) {
            return null;
        }
        OffsetEntry offsetEntry = ((Entry) ze).getOffsetEntry();
        ZipUtil.checkRequestedFeatures(ze);
        long start = offsetEntry.dataOffset;
        BoundedInputStream bis = new BoundedInputStream(start, ze.getCompressedSize());
        switch (ZipMethod.getMethodByCode(ze.getMethod())) {
            case STORED:
                return bis;
            case UNSHRINKING:
                return new UnshrinkingInputStream(bis);
            case IMPLODING:
                return new ExplodingInputStream(ze.getGeneralPurposeBit().getSlidingDictionarySize(), ze.getGeneralPurposeBit().getNumberOfShannonFanoTrees(), new BufferedInputStream(bis));
            case DEFLATED:
                bis.addDummy();
                final Inflater inflater = new Inflater(true);
                return new InflaterInputStream(bis, inflater) { // from class: org.apache.commons.compress.archivers.zip.ZipFile.1
                    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws IOException {
                        try {
                            super.close();
                        } finally {
                            inflater.end();
                        }
                    }
                };
            case BZIP2:
                return new BZip2CompressorInputStream(bis);
            default:
                throw new ZipException("Found unsupported compression method " + ze.getMethod());
        }
    }

    public String getUnixSymlink(ZipArchiveEntry entry) throws IOException {
        if (entry != null && entry.isUnixSymlink()) {
            InputStream in = null;
            try {
                in = getInputStream(entry);
                byte[] symlinkBytes = IOUtils.toByteArray(in);
                return this.zipEncoding.decode(symlinkBytes);
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        }
        return null;
    }

    protected void finalize() throws Throwable {
        try {
            if (!this.closed) {
                System.err.println("Cleaning up unclosed ZipFile for archive " + this.archiveName);
                close();
            }
        } finally {
            super.finalize();
        }
    }

    private Map<ZipArchiveEntry, NameAndComment> populateFromCentralDirectory() throws IOException {
        HashMap<ZipArchiveEntry, NameAndComment> noUTF8Flag = new HashMap<>();
        positionAtCentralDirectory();
        this.archive.readFully(this.WORD_BUF);
        long sig = ZipLong.getValue(this.WORD_BUF);
        if (sig != CFH_SIG && startsWithLocalFileHeader()) {
            throw new IOException("central directory is empty, can't expand corrupt archive.");
        }
        while (sig == CFH_SIG) {
            readCentralDirectoryEntry(noUTF8Flag);
            this.archive.readFully(this.WORD_BUF);
            sig = ZipLong.getValue(this.WORD_BUF);
        }
        return noUTF8Flag;
    }

    private void readCentralDirectoryEntry(Map<ZipArchiveEntry, NameAndComment> noUTF8Flag) throws IOException {
        this.archive.readFully(this.CFH_BUF);
        OffsetEntry offset = new OffsetEntry();
        Entry ze = new Entry(offset);
        int versionMadeBy = ZipShort.getValue(this.CFH_BUF, 0);
        int off = 0 + 2;
        ze.setVersionMadeBy(versionMadeBy);
        ze.setPlatform((versionMadeBy >> 8) & 15);
        ze.setVersionRequired(ZipShort.getValue(this.CFH_BUF, off));
        int off2 = off + 2;
        GeneralPurposeBit gpFlag = GeneralPurposeBit.parse(this.CFH_BUF, off2);
        boolean hasUTF8Flag = gpFlag.usesUTF8ForNames();
        ZipEncoding entryEncoding = hasUTF8Flag ? ZipEncodingHelper.UTF8_ZIP_ENCODING : this.zipEncoding;
        ze.setGeneralPurposeBit(gpFlag);
        ze.setRawFlag(ZipShort.getValue(this.CFH_BUF, off2));
        int off3 = off2 + 2;
        ze.setMethod(ZipShort.getValue(this.CFH_BUF, off3));
        int off4 = off3 + 2;
        long time = ZipUtil.dosToJavaTime(ZipLong.getValue(this.CFH_BUF, off4));
        ze.setTime(time);
        int off5 = off4 + 4;
        ze.setCrc(ZipLong.getValue(this.CFH_BUF, off5));
        int off6 = off5 + 4;
        ze.setCompressedSize(ZipLong.getValue(this.CFH_BUF, off6));
        int off7 = off6 + 4;
        ze.setSize(ZipLong.getValue(this.CFH_BUF, off7));
        int off8 = off7 + 4;
        int fileNameLen = ZipShort.getValue(this.CFH_BUF, off8);
        int off9 = off8 + 2;
        int extraLen = ZipShort.getValue(this.CFH_BUF, off9);
        int off10 = off9 + 2;
        int commentLen = ZipShort.getValue(this.CFH_BUF, off10);
        int off11 = off10 + 2;
        int diskStart = ZipShort.getValue(this.CFH_BUF, off11);
        int off12 = off11 + 2;
        ze.setInternalAttributes(ZipShort.getValue(this.CFH_BUF, off12));
        int off13 = off12 + 2;
        ze.setExternalAttributes(ZipLong.getValue(this.CFH_BUF, off13));
        byte[] fileName = new byte[fileNameLen];
        this.archive.readFully(fileName);
        ze.setName(entryEncoding.decode(fileName), fileName);
        offset.headerOffset = ZipLong.getValue(this.CFH_BUF, off13 + 4);
        this.entries.add(ze);
        byte[] cdExtraData = new byte[extraLen];
        this.archive.readFully(cdExtraData);
        ze.setCentralDirectoryExtra(cdExtraData);
        setSizesAndOffsetFromZip64Extra(ze, offset, diskStart);
        byte[] comment = new byte[commentLen];
        this.archive.readFully(comment);
        ze.setComment(entryEncoding.decode(comment));
        if (!hasUTF8Flag && this.useUnicodeExtraFields) {
            noUTF8Flag.put(ze, new NameAndComment(fileName, comment));
        }
    }

    private void setSizesAndOffsetFromZip64Extra(ZipArchiveEntry ze, OffsetEntry offset, int diskStart) throws IOException {
        Zip64ExtendedInformationExtraField z64 = (Zip64ExtendedInformationExtraField) ze.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        if (z64 != null) {
            boolean hasUncompressedSize = ze.getSize() == 4294967295L;
            boolean hasCompressedSize = ze.getCompressedSize() == 4294967295L;
            boolean hasRelativeHeaderOffset = offset.headerOffset == 4294967295L;
            z64.reparseCentralDirectoryData(hasUncompressedSize, hasCompressedSize, hasRelativeHeaderOffset, diskStart == 65535);
            if (hasUncompressedSize) {
                ze.setSize(z64.getSize().getLongValue());
            } else if (hasCompressedSize) {
                z64.setSize(new ZipEightByteInteger(ze.getSize()));
            }
            if (hasCompressedSize) {
                ze.setCompressedSize(z64.getCompressedSize().getLongValue());
            } else if (hasUncompressedSize) {
                z64.setCompressedSize(new ZipEightByteInteger(ze.getCompressedSize()));
            }
            if (hasRelativeHeaderOffset) {
                offset.headerOffset = z64.getRelativeHeaderOffset().getLongValue();
            }
        }
    }

    private void positionAtCentralDirectory() throws IOException {
        positionAtEndOfCentralDirectoryRecord();
        boolean found = false;
        boolean searchedForZip64EOCD = this.archive.getFilePointer() > 20;
        if (searchedForZip64EOCD) {
            this.archive.seek(this.archive.getFilePointer() - 20);
            this.archive.readFully(this.WORD_BUF);
            found = Arrays.equals(ZipArchiveOutputStream.ZIP64_EOCD_LOC_SIG, this.WORD_BUF);
        }
        if (!found) {
            if (searchedForZip64EOCD) {
                skipBytes(16);
            }
            positionAtCentralDirectory32();
            return;
        }
        positionAtCentralDirectory64();
    }

    private void positionAtCentralDirectory64() throws IOException {
        skipBytes(4);
        this.archive.readFully(this.DWORD_BUF);
        this.archive.seek(ZipEightByteInteger.getLongValue(this.DWORD_BUF));
        this.archive.readFully(this.WORD_BUF);
        if (!Arrays.equals(this.WORD_BUF, ZipArchiveOutputStream.ZIP64_EOCD_SIG)) {
            throw new ZipException("archive's ZIP64 end of central directory locator is corrupt.");
        }
        skipBytes(44);
        this.archive.readFully(this.DWORD_BUF);
        this.archive.seek(ZipEightByteInteger.getLongValue(this.DWORD_BUF));
    }

    private void positionAtCentralDirectory32() throws IOException {
        skipBytes(16);
        this.archive.readFully(this.WORD_BUF);
        this.archive.seek(ZipLong.getValue(this.WORD_BUF));
    }

    private void positionAtEndOfCentralDirectoryRecord() throws IOException {
        boolean found = tryToLocateSignature(22L, 65557L, ZipArchiveOutputStream.EOCD_SIG);
        if (!found) {
            throw new ZipException("archive is not a ZIP archive");
        }
    }

    private boolean tryToLocateSignature(long minDistanceFromEnd, long maxDistanceFromEnd, byte[] sig) throws IOException {
        boolean found = false;
        long off = this.archive.length() - minDistanceFromEnd;
        long stopSearching = Math.max(0L, this.archive.length() - maxDistanceFromEnd);
        if (off >= 0) {
            while (off >= stopSearching) {
                this.archive.seek(off);
                int curr = this.archive.read();
                if (curr == -1) {
                    break;
                }
                if (curr != sig[0] || this.archive.read() != sig[1] || this.archive.read() != sig[2] || this.archive.read() != sig[3]) {
                    off--;
                } else {
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            this.archive.seek(off);
        }
        return found;
    }

    private void skipBytes(int count) throws IOException {
        int totalSkipped = 0;
        while (totalSkipped < count) {
            int skippedNow = this.archive.skipBytes(count - totalSkipped);
            if (skippedNow <= 0) {
                throw new EOFException();
            }
            totalSkipped += skippedNow;
        }
    }

    private void resolveLocalFileHeaderData(Map<ZipArchiveEntry, NameAndComment> entriesWithoutUTF8Flag) throws IOException {
        for (ZipArchiveEntry zipArchiveEntry : this.entries) {
            Entry ze = (Entry) zipArchiveEntry;
            OffsetEntry offsetEntry = ze.getOffsetEntry();
            long offset = offsetEntry.headerOffset;
            this.archive.seek(offset + LFH_OFFSET_FOR_FILENAME_LENGTH);
            this.archive.readFully(this.SHORT_BUF);
            int fileNameLen = ZipShort.getValue(this.SHORT_BUF);
            this.archive.readFully(this.SHORT_BUF);
            int extraFieldLen = ZipShort.getValue(this.SHORT_BUF);
            int lenToSkip = fileNameLen;
            while (lenToSkip > 0) {
                int skipped = this.archive.skipBytes(lenToSkip);
                if (skipped <= 0) {
                    throw new IOException("failed to skip file name in local file header");
                }
                lenToSkip -= skipped;
            }
            byte[] localExtraData = new byte[extraFieldLen];
            this.archive.readFully(localExtraData);
            ze.setExtra(localExtraData);
            offsetEntry.dataOffset = LFH_OFFSET_FOR_FILENAME_LENGTH + offset + 2 + 2 + ((long) fileNameLen) + ((long) extraFieldLen);
            if (entriesWithoutUTF8Flag.containsKey(ze)) {
                NameAndComment nc = entriesWithoutUTF8Flag.get(ze);
                ZipUtil.setNameAndCommentFromExtraFields(ze, nc.name, nc.comment);
            }
            String name = ze.getName();
            LinkedList<ZipArchiveEntry> entriesOfThatName = this.nameMap.get(name);
            if (entriesOfThatName == null) {
                entriesOfThatName = new LinkedList<>();
                this.nameMap.put(name, entriesOfThatName);
            }
            entriesOfThatName.addLast(ze);
        }
    }

    private boolean startsWithLocalFileHeader() throws IOException {
        this.archive.seek(0L);
        this.archive.readFully(this.WORD_BUF);
        return Arrays.equals(this.WORD_BUF, ZipArchiveOutputStream.LFH_SIG);
    }

    private class BoundedInputStream extends InputStream {
        private boolean addDummyByte = false;
        private long loc;
        private long remaining;

        BoundedInputStream(long start, long remaining) {
            this.remaining = remaining;
            this.loc = start;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int i;
            long j = this.remaining;
            this.remaining = j - 1;
            if (j > 0) {
                synchronized (ZipFile.this.archive) {
                    RandomAccessFile randomAccessFile = ZipFile.this.archive;
                    long j2 = this.loc;
                    this.loc = 1 + j2;
                    randomAccessFile.seek(j2);
                    i = ZipFile.this.archive.read();
                }
                return i;
            }
            if (this.addDummyByte) {
                this.addDummyByte = false;
                return 0;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] b, int off, int len) throws IOException {
            int ret;
            if (this.remaining <= 0) {
                if (this.addDummyByte) {
                    this.addDummyByte = false;
                    b[off] = 0;
                    return 1;
                }
                return -1;
            }
            if (len <= 0) {
                return 0;
            }
            if (len > this.remaining) {
                len = (int) this.remaining;
            }
            synchronized (ZipFile.this.archive) {
                ZipFile.this.archive.seek(this.loc);
                ret = ZipFile.this.archive.read(b, off, len);
            }
            if (ret > 0) {
                this.loc += (long) ret;
                this.remaining -= (long) ret;
            }
            return ret;
        }

        void addDummy() {
            this.addDummyByte = true;
        }
    }

    private static final class NameAndComment {
        private final byte[] comment;
        private final byte[] name;

        private NameAndComment(byte[] name, byte[] comment) {
            this.name = name;
            this.comment = comment;
        }
    }

    private static class Entry extends ZipArchiveEntry {
        private final OffsetEntry offsetEntry;

        Entry(OffsetEntry offset) {
            this.offsetEntry = offset;
        }

        OffsetEntry getOffsetEntry() {
            return this.offsetEntry;
        }

        @Override // org.apache.commons.compress.archivers.zip.ZipArchiveEntry, java.util.zip.ZipEntry
        public int hashCode() {
            return (super.hashCode() * 3) + ((int) (this.offsetEntry.headerOffset % InlineClassHelperKt.FloatNonFiniteMask));
        }

        @Override // org.apache.commons.compress.archivers.zip.ZipArchiveEntry
        public boolean equals(Object other) {
            if (!super.equals(other)) {
                return false;
            }
            Entry otherEntry = (Entry) other;
            return this.offsetEntry.headerOffset == otherEntry.offsetEntry.headerOffset && this.offsetEntry.dataOffset == otherEntry.offsetEntry.dataOffset;
        }
    }
}
