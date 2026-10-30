package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes18.dex */
public class ZipArchiveOutputStream extends ArchiveOutputStream {
    static final int BUFFER_SIZE = 512;
    private static final int CFH_COMMENT_LENGTH_OFFSET = 32;
    private static final int CFH_COMPRESSED_SIZE_OFFSET = 20;
    private static final int CFH_CRC_OFFSET = 16;
    private static final int CFH_DISK_NUMBER_OFFSET = 34;
    private static final int CFH_EXTERNAL_ATTRIBUTES_OFFSET = 38;
    private static final int CFH_EXTRA_LENGTH_OFFSET = 30;
    private static final int CFH_FILENAME_LENGTH_OFFSET = 28;
    private static final int CFH_FILENAME_OFFSET = 46;
    private static final int CFH_GPB_OFFSET = 8;
    private static final int CFH_INTERNAL_ATTRIBUTES_OFFSET = 36;
    private static final int CFH_LFH_OFFSET = 42;
    private static final int CFH_METHOD_OFFSET = 10;
    private static final int CFH_ORIGINAL_SIZE_OFFSET = 24;
    private static final int CFH_SIG_OFFSET = 0;
    private static final int CFH_TIME_OFFSET = 12;
    private static final int CFH_VERSION_MADE_BY_OFFSET = 4;
    private static final int CFH_VERSION_NEEDED_OFFSET = 6;
    public static final int DEFAULT_COMPRESSION = -1;
    static final String DEFAULT_ENCODING = "UTF8";
    public static final int DEFLATED = 8;

    @Deprecated
    public static final int EFS_FLAG = 2048;
    private static final int LFH_COMPRESSED_SIZE_OFFSET = 18;
    private static final int LFH_CRC_OFFSET = 14;
    private static final int LFH_EXTRA_LENGTH_OFFSET = 28;
    private static final int LFH_FILENAME_LENGTH_OFFSET = 26;
    private static final int LFH_FILENAME_OFFSET = 30;
    private static final int LFH_GPB_OFFSET = 6;
    private static final int LFH_METHOD_OFFSET = 8;
    private static final int LFH_ORIGINAL_SIZE_OFFSET = 22;
    private static final int LFH_SIG_OFFSET = 0;
    private static final int LFH_TIME_OFFSET = 10;
    private static final int LFH_VERSION_NEEDED_OFFSET = 4;
    public static final int STORED = 0;
    private final Calendar calendarInstance;
    private long cdLength;
    private long cdOffset;
    private String comment;
    private final byte[] copyBuffer;
    private UnicodeExtraFieldPolicy createUnicodeExtraFields;
    protected final Deflater def;
    private String encoding;
    private final List<ZipArchiveEntry> entries;
    private CurrentEntry entry;
    private boolean fallbackToUTF8;
    protected boolean finished;
    private boolean hasCompressionLevelChanged;
    private boolean hasUsedZip64;
    private int level;
    private int method;
    private final Map<ZipArchiveEntry, Long> offsets;
    private final OutputStream out;
    private final RandomAccessFile raf;
    private final StreamCompressor streamCompressor;
    private boolean useUTF8Flag;
    private Zip64Mode zip64Mode;
    private ZipEncoding zipEncoding;
    private static final byte[] EMPTY = new byte[0];
    private static final byte[] ZERO = {0, 0};
    private static final byte[] LZERO = {0, 0, 0, 0};
    private static final byte[] ONE = ZipLong.getBytes(1);
    static final byte[] LFH_SIG = ZipLong.LFH_SIG.getBytes();
    static final byte[] DD_SIG = ZipLong.DD_SIG.getBytes();
    static final byte[] CFH_SIG = ZipLong.CFH_SIG.getBytes();
    static final byte[] EOCD_SIG = ZipLong.getBytes(101010256);
    static final byte[] ZIP64_EOCD_SIG = ZipLong.getBytes(101075792);
    static final byte[] ZIP64_EOCD_LOC_SIG = ZipLong.getBytes(117853008);

    public ZipArchiveOutputStream(OutputStream out) {
        this.finished = false;
        this.comment = "";
        this.level = -1;
        this.hasCompressionLevelChanged = false;
        this.method = 8;
        this.entries = new LinkedList();
        this.cdOffset = 0L;
        this.cdLength = 0L;
        this.offsets = new HashMap();
        this.encoding = DEFAULT_ENCODING;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(DEFAULT_ENCODING);
        this.useUTF8Flag = true;
        this.fallbackToUTF8 = false;
        this.createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
        this.hasUsedZip64 = false;
        this.zip64Mode = Zip64Mode.AsNeeded;
        this.copyBuffer = new byte[32768];
        this.calendarInstance = Calendar.getInstance();
        this.out = out;
        this.raf = null;
        this.def = new Deflater(this.level, true);
        this.streamCompressor = StreamCompressor.create(out, this.def);
    }

    public ZipArchiveOutputStream(File file) throws IOException {
        this.finished = false;
        this.comment = "";
        this.level = -1;
        this.hasCompressionLevelChanged = false;
        this.method = 8;
        this.entries = new LinkedList();
        this.cdOffset = 0L;
        this.cdLength = 0L;
        this.offsets = new HashMap();
        this.encoding = DEFAULT_ENCODING;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(DEFAULT_ENCODING);
        this.useUTF8Flag = true;
        this.fallbackToUTF8 = false;
        this.createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
        this.hasUsedZip64 = false;
        this.zip64Mode = Zip64Mode.AsNeeded;
        this.copyBuffer = new byte[32768];
        this.calendarInstance = Calendar.getInstance();
        OutputStream o = null;
        RandomAccessFile _raf = null;
        try {
            _raf = new RandomAccessFile(file, "rw");
            _raf.setLength(0L);
        } catch (IOException e) {
            IOUtils.closeQuietly(_raf);
            _raf = null;
            o = new FileOutputStream(file);
        }
        this.def = new Deflater(this.level, true);
        this.streamCompressor = StreamCompressor.create(_raf, this.def);
        this.out = o;
        this.raf = _raf;
    }

    public boolean isSeekable() {
        return this.raf != null;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(encoding);
        if (this.useUTF8Flag && !ZipEncodingHelper.isUTF8(encoding)) {
            this.useUTF8Flag = false;
        }
    }

    public String getEncoding() {
        return this.encoding;
    }

    public void setUseLanguageEncodingFlag(boolean b) {
        this.useUTF8Flag = b && ZipEncodingHelper.isUTF8(this.encoding);
    }

    public void setCreateUnicodeExtraFields(UnicodeExtraFieldPolicy b) {
        this.createUnicodeExtraFields = b;
    }

    public void setFallbackToUTF8(boolean b) {
        this.fallbackToUTF8 = b;
    }

    public void setUseZip64(Zip64Mode mode) {
        this.zip64Mode = mode;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void finish() throws IOException {
        if (this.finished) {
            throw new IOException("This archive has already been finished");
        }
        if (this.entry != null) {
            throw new IOException("This archive contains unclosed entries.");
        }
        this.cdOffset = this.streamCompressor.getTotalBytesWritten();
        writeCentralDirectoryInChunks();
        this.cdLength = this.streamCompressor.getTotalBytesWritten() - this.cdOffset;
        writeZip64CentralDirectory();
        writeCentralDirectoryEnd();
        this.offsets.clear();
        this.entries.clear();
        this.streamCompressor.close();
        this.finished = true;
    }

    private void writeCentralDirectoryInChunks() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(70000);
        int count = 0;
        for (ZipArchiveEntry ze : this.entries) {
            byteArrayOutputStream.write(createCentralFileHeader(ze));
            count++;
            if (count > 1000) {
                writeCounted(byteArrayOutputStream.toByteArray());
                byteArrayOutputStream.reset();
                count = 0;
            }
        }
        writeCounted(byteArrayOutputStream.toByteArray());
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void closeArchiveEntry() throws IOException {
        preClose();
        flushDeflater();
        long bytesWritten = this.streamCompressor.getTotalBytesWritten() - this.entry.dataStart;
        long realCrc = this.streamCompressor.getCrc32();
        this.entry.bytesRead = this.streamCompressor.getBytesRead();
        Zip64Mode effectiveMode = getEffectiveZip64Mode(this.entry.entry);
        boolean actuallyNeedsZip64 = handleSizesAndCrc(bytesWritten, realCrc, effectiveMode);
        closeEntry(actuallyNeedsZip64, false);
        this.streamCompressor.reset();
    }

    private void closeCopiedEntry(boolean phased) throws IOException {
        preClose();
        this.entry.bytesRead = this.entry.entry.getSize();
        Zip64Mode effectiveMode = getEffectiveZip64Mode(this.entry.entry);
        boolean actuallyNeedsZip64 = checkIfNeedsZip64(effectiveMode);
        closeEntry(actuallyNeedsZip64, phased);
    }

    private void closeEntry(boolean actuallyNeedsZip64, boolean phased) throws IOException {
        if (!phased && this.raf != null) {
            rewriteSizesAndCrc(actuallyNeedsZip64);
        }
        writeDataDescriptor(this.entry.entry);
        this.entry = null;
    }

    private void preClose() throws IOException {
        if (this.finished) {
            throw new IOException("Stream has already been finished");
        }
        if (this.entry == null) {
            throw new IOException("No current entry to close");
        }
        if (!this.entry.hasWritten) {
            write(EMPTY, 0, 0);
        }
    }

    public void addRawArchiveEntry(ZipArchiveEntry entry, InputStream rawStream) throws IOException {
        ZipArchiveEntry ae = new ZipArchiveEntry(entry);
        if (hasZip64Extra(ae)) {
            ae.removeExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        }
        boolean is2PhaseSource = (ae.getCrc() == -1 || ae.getSize() == -1 || ae.getCompressedSize() == -1) ? false : true;
        putArchiveEntry(ae, is2PhaseSource);
        copyFromZipInputStream(rawStream);
        closeCopiedEntry(is2PhaseSource);
    }

    private void flushDeflater() throws IOException {
        if (this.entry.entry.getMethod() == 8) {
            this.streamCompressor.flushDeflater();
        }
    }

    private boolean handleSizesAndCrc(long bytesWritten, long crc, Zip64Mode effectiveMode) throws ZipException {
        if (this.entry.entry.getMethod() != 8) {
            if (this.raf != null) {
                this.entry.entry.setSize(bytesWritten);
                this.entry.entry.setCompressedSize(bytesWritten);
                this.entry.entry.setCrc(crc);
            } else {
                if (this.entry.entry.getCrc() != crc) {
                    throw new ZipException("bad CRC checksum for entry " + this.entry.entry.getName() + ": " + Long.toHexString(this.entry.entry.getCrc()) + " instead of " + Long.toHexString(crc));
                }
                if (this.entry.entry.getSize() != bytesWritten) {
                    throw new ZipException("bad size for entry " + this.entry.entry.getName() + ": " + this.entry.entry.getSize() + " instead of " + bytesWritten);
                }
            }
        } else {
            this.entry.entry.setSize(this.entry.bytesRead);
            this.entry.entry.setCompressedSize(bytesWritten);
            this.entry.entry.setCrc(crc);
        }
        return checkIfNeedsZip64(effectiveMode);
    }

    private boolean checkIfNeedsZip64(Zip64Mode effectiveMode) throws ZipException {
        boolean actuallyNeedsZip64 = isZip64Required(this.entry.entry, effectiveMode);
        if (actuallyNeedsZip64 && effectiveMode == Zip64Mode.Never) {
            throw new Zip64RequiredException(Zip64RequiredException.getEntryTooBigMessage(this.entry.entry));
        }
        return actuallyNeedsZip64;
    }

    private boolean isZip64Required(ZipArchiveEntry entry1, Zip64Mode requestedMode) {
        return requestedMode == Zip64Mode.Always || isTooLageForZip32(entry1);
    }

    private boolean isTooLageForZip32(ZipArchiveEntry zipArchiveEntry) {
        return zipArchiveEntry.getSize() >= 4294967295L || zipArchiveEntry.getCompressedSize() >= 4294967295L;
    }

    private void rewriteSizesAndCrc(boolean actuallyNeedsZip64) throws IOException {
        long save = this.raf.getFilePointer();
        this.raf.seek(this.entry.localDataStart);
        writeOut(ZipLong.getBytes(this.entry.entry.getCrc()));
        if (hasZip64Extra(this.entry.entry) && actuallyNeedsZip64) {
            writeOut(ZipLong.ZIP64_MAGIC.getBytes());
            writeOut(ZipLong.ZIP64_MAGIC.getBytes());
        } else {
            writeOut(ZipLong.getBytes(this.entry.entry.getCompressedSize()));
            writeOut(ZipLong.getBytes(this.entry.entry.getSize()));
        }
        if (hasZip64Extra(this.entry.entry)) {
            ByteBuffer name = getName(this.entry.entry);
            int nameLen = name.limit() - name.position();
            this.raf.seek(this.entry.localDataStart + 12 + 4 + ((long) nameLen) + 4);
            writeOut(ZipEightByteInteger.getBytes(this.entry.entry.getSize()));
            writeOut(ZipEightByteInteger.getBytes(this.entry.entry.getCompressedSize()));
            if (!actuallyNeedsZip64) {
                this.raf.seek(this.entry.localDataStart - 10);
                writeOut(ZipShort.getBytes(10));
                this.entry.entry.removeExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
                this.entry.entry.setExtra();
                if (this.entry.causedUseOfZip64) {
                    this.hasUsedZip64 = false;
                }
            }
        }
        this.raf.seek(save);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void putArchiveEntry(ArchiveEntry archiveEntry) throws IOException {
        putArchiveEntry(archiveEntry, false);
    }

    private void putArchiveEntry(ArchiveEntry archiveEntry, boolean phased) throws IOException {
        if (this.finished) {
            throw new IOException("Stream has already been finished");
        }
        if (this.entry != null) {
            closeArchiveEntry();
        }
        this.entry = new CurrentEntry((ZipArchiveEntry) archiveEntry);
        this.entries.add(this.entry.entry);
        setDefaults(this.entry.entry);
        Zip64Mode effectiveMode = getEffectiveZip64Mode(this.entry.entry);
        validateSizeInformation(effectiveMode);
        if (shouldAddZip64Extra(this.entry.entry, effectiveMode)) {
            Zip64ExtendedInformationExtraField z64 = getZip64Extra(this.entry.entry);
            ZipEightByteInteger size = ZipEightByteInteger.ZERO;
            ZipEightByteInteger compressedSize = ZipEightByteInteger.ZERO;
            if (phased) {
                size = new ZipEightByteInteger(this.entry.entry.getSize());
                compressedSize = new ZipEightByteInteger(this.entry.entry.getCompressedSize());
            } else if (this.entry.entry.getMethod() == 0 && this.entry.entry.getSize() != -1) {
                size = new ZipEightByteInteger(this.entry.entry.getSize());
                compressedSize = size;
            }
            z64.setSize(size);
            z64.setCompressedSize(compressedSize);
            this.entry.entry.setExtra();
        }
        if (this.entry.entry.getMethod() == 8 && this.hasCompressionLevelChanged) {
            this.def.setLevel(this.level);
            this.hasCompressionLevelChanged = false;
        }
        writeLocalFileHeader((ZipArchiveEntry) archiveEntry, phased);
    }

    private void setDefaults(ZipArchiveEntry entry) {
        if (entry.getMethod() == -1) {
            entry.setMethod(this.method);
        }
        if (entry.getTime() == -1) {
            entry.setTime(System.currentTimeMillis());
        }
    }

    private void validateSizeInformation(Zip64Mode effectiveMode) throws ZipException {
        if (this.entry.entry.getMethod() == 0 && this.raf == null) {
            if (this.entry.entry.getSize() == -1) {
                throw new ZipException("uncompressed size is required for STORED method when not writing to a file");
            }
            if (this.entry.entry.getCrc() == -1) {
                throw new ZipException("crc checksum is required for STORED method when not writing to a file");
            }
            this.entry.entry.setCompressedSize(this.entry.entry.getSize());
        }
        if ((this.entry.entry.getSize() >= 4294967295L || this.entry.entry.getCompressedSize() >= 4294967295L) && effectiveMode == Zip64Mode.Never) {
            throw new Zip64RequiredException(Zip64RequiredException.getEntryTooBigMessage(this.entry.entry));
        }
    }

    private boolean shouldAddZip64Extra(ZipArchiveEntry entry, Zip64Mode mode) {
        return mode == Zip64Mode.Always || entry.getSize() >= 4294967295L || entry.getCompressedSize() >= 4294967295L || !(entry.getSize() != -1 || this.raf == null || mode == Zip64Mode.Never);
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setLevel(int level) {
        if (level < -1 || level > 9) {
            throw new IllegalArgumentException("Invalid compression level: " + level);
        }
        this.hasCompressionLevelChanged = this.level != level;
        this.level = level;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public boolean canWriteEntryData(ArchiveEntry ae) {
        if (!(ae instanceof ZipArchiveEntry)) {
            return false;
        }
        ZipArchiveEntry zae = (ZipArchiveEntry) ae;
        return (zae.getMethod() == ZipMethod.IMPLODING.getCode() || zae.getMethod() == ZipMethod.UNSHRINKING.getCode() || !ZipUtil.canHandleEntryData(zae)) ? false : true;
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int offset, int length) throws IOException {
        if (this.entry == null) {
            throw new IllegalStateException("No current entry");
        }
        ZipUtil.checkRequestedFeatures(this.entry.entry);
        long writtenThisTime = this.streamCompressor.write(b, offset, length, this.entry.entry.getMethod());
        count(writtenThisTime);
    }

    private void writeCounted(byte[] data) throws IOException {
        this.streamCompressor.writeCounted(data);
    }

    private void copyFromZipInputStream(InputStream src) throws IOException {
        if (this.entry == null) {
            throw new IllegalStateException("No current entry");
        }
        ZipUtil.checkRequestedFeatures(this.entry.entry);
        this.entry.hasWritten = true;
        while (true) {
            int length = src.read(this.copyBuffer);
            if (length >= 0) {
                this.streamCompressor.writeCounted(this.copyBuffer, 0, length);
                count(length);
            } else {
                return;
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.finished) {
            finish();
        }
        destroy();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.out != null) {
            this.out.flush();
        }
    }

    protected final void deflate() throws IOException {
        this.streamCompressor.deflate();
    }

    protected void writeLocalFileHeader(ZipArchiveEntry ze) throws IOException {
        writeLocalFileHeader(ze, false);
    }

    private void writeLocalFileHeader(ZipArchiveEntry ze, boolean phased) throws IOException {
        boolean encodable = this.zipEncoding.canEncode(ze.getName());
        ByteBuffer name = getName(ze);
        if (this.createUnicodeExtraFields != UnicodeExtraFieldPolicy.NEVER) {
            addUnicodeExtraFields(ze, encodable, name);
        }
        byte[] localHeader = createLocalFileHeader(ze, name, encodable, phased);
        long localHeaderStart = this.streamCompressor.getTotalBytesWritten();
        this.offsets.put(ze, Long.valueOf(localHeaderStart));
        this.entry.localDataStart = 14 + localHeaderStart;
        writeCounted(localHeader);
        this.entry.dataStart = this.streamCompressor.getTotalBytesWritten();
    }

    private byte[] createLocalFileHeader(ZipArchiveEntry ze, ByteBuffer name, boolean encodable, boolean phased) {
        byte[] extra = ze.getLocalFileDataExtra();
        int nameLen = name.limit() - name.position();
        int len = nameLen + 30 + extra.length;
        byte[] buf = new byte[len];
        System.arraycopy(LFH_SIG, 0, buf, 0, 4);
        int zipMethod = ze.getMethod();
        if (phased && !isZip64Required(this.entry.entry, this.zip64Mode)) {
            ZipShort.putShort(10, buf, 4);
        } else {
            ZipShort.putShort(versionNeededToExtract(zipMethod, hasZip64Extra(ze)), buf, 4);
        }
        GeneralPurposeBit generalPurposeBit = getGeneralPurposeBits(zipMethod, !encodable && this.fallbackToUTF8);
        generalPurposeBit.encode(buf, 6);
        ZipShort.putShort(zipMethod, buf, 8);
        ZipUtil.toDosTime(this.calendarInstance, ze.getTime(), buf, 10);
        if (phased) {
            ZipLong.putLong(ze.getCrc(), buf, 14);
        } else if (zipMethod == 8 || this.raf != null) {
            System.arraycopy(LZERO, 0, buf, 14, 4);
        } else {
            ZipLong.putLong(ze.getCrc(), buf, 14);
        }
        if (hasZip64Extra(this.entry.entry)) {
            ZipLong.ZIP64_MAGIC.putLong(buf, 18);
            ZipLong.ZIP64_MAGIC.putLong(buf, 22);
        } else if (phased) {
            ZipLong.putLong(ze.getCompressedSize(), buf, 18);
            ZipLong.putLong(ze.getSize(), buf, 22);
        } else if (zipMethod == 8 || this.raf != null) {
            System.arraycopy(LZERO, 0, buf, 18, 4);
            System.arraycopy(LZERO, 0, buf, 22, 4);
        } else {
            ZipLong.putLong(ze.getSize(), buf, 18);
            ZipLong.putLong(ze.getSize(), buf, 22);
        }
        ZipShort.putShort(nameLen, buf, 26);
        ZipShort.putShort(extra.length, buf, 28);
        System.arraycopy(name.array(), name.arrayOffset(), buf, 30, nameLen);
        System.arraycopy(extra, 0, buf, nameLen + 30, extra.length);
        return buf;
    }

    private void addUnicodeExtraFields(ZipArchiveEntry ze, boolean encodable, ByteBuffer name) throws IOException {
        if (this.createUnicodeExtraFields == UnicodeExtraFieldPolicy.ALWAYS || !encodable) {
            ze.addExtraField(new UnicodePathExtraField(ze.getName(), name.array(), name.arrayOffset(), name.limit() - name.position()));
        }
        String comm = ze.getComment();
        if (comm != null && !"".equals(comm)) {
            boolean commentEncodable = this.zipEncoding.canEncode(comm);
            if (this.createUnicodeExtraFields == UnicodeExtraFieldPolicy.ALWAYS || !commentEncodable) {
                ByteBuffer commentB = getEntryEncoding(ze).encode(comm);
                ze.addExtraField(new UnicodeCommentExtraField(comm, commentB.array(), commentB.arrayOffset(), commentB.limit() - commentB.position()));
            }
        }
    }

    protected void writeDataDescriptor(ZipArchiveEntry ze) throws IOException {
        if (ze.getMethod() != 8 || this.raf != null) {
            return;
        }
        writeCounted(DD_SIG);
        writeCounted(ZipLong.getBytes(ze.getCrc()));
        if (!hasZip64Extra(ze)) {
            writeCounted(ZipLong.getBytes(ze.getCompressedSize()));
            writeCounted(ZipLong.getBytes(ze.getSize()));
        } else {
            writeCounted(ZipEightByteInteger.getBytes(ze.getCompressedSize()));
            writeCounted(ZipEightByteInteger.getBytes(ze.getSize()));
        }
    }

    protected void writeCentralFileHeader(ZipArchiveEntry ze) throws IOException {
        byte[] centralFileHeader = createCentralFileHeader(ze);
        writeCounted(centralFileHeader);
    }

    private byte[] createCentralFileHeader(ZipArchiveEntry ze) throws IOException {
        long lfhOffset = this.offsets.get(ze).longValue();
        boolean needsZip64Extra = hasZip64Extra(ze) || ze.getCompressedSize() >= 4294967295L || ze.getSize() >= 4294967295L || lfhOffset >= 4294967295L || this.zip64Mode == Zip64Mode.Always;
        if (needsZip64Extra && this.zip64Mode == Zip64Mode.Never) {
            throw new Zip64RequiredException("archive's size exceeds the limit of 4GByte.");
        }
        handleZip64Extra(ze, lfhOffset, needsZip64Extra);
        return createCentralFileHeader(ze, getName(ze), lfhOffset, needsZip64Extra);
    }

    private byte[] createCentralFileHeader(ZipArchiveEntry ze, ByteBuffer name, long lfhOffset, boolean needsZip64Extra) throws IOException {
        byte[] extra = ze.getCentralDirectoryExtra();
        String comm = ze.getComment();
        if (comm == null) {
            comm = "";
        }
        ByteBuffer commentB = getEntryEncoding(ze).encode(comm);
        int nameLen = name.limit() - name.position();
        int commentLen = commentB.limit() - commentB.position();
        int len = nameLen + 46 + extra.length + commentLen;
        byte[] buf = new byte[len];
        System.arraycopy(CFH_SIG, 0, buf, 0, 4);
        ZipShort.putShort((ze.getPlatform() << 8) | (!this.hasUsedZip64 ? 20 : 45), buf, 4);
        int zipMethod = ze.getMethod();
        boolean encodable = this.zipEncoding.canEncode(ze.getName());
        ZipShort.putShort(versionNeededToExtract(zipMethod, needsZip64Extra), buf, 6);
        getGeneralPurposeBits(zipMethod, !encodable && this.fallbackToUTF8).encode(buf, 8);
        ZipShort.putShort(zipMethod, buf, 10);
        ZipUtil.toDosTime(this.calendarInstance, ze.getTime(), buf, 12);
        ZipLong.putLong(ze.getCrc(), buf, 16);
        if (ze.getCompressedSize() >= 4294967295L || ze.getSize() >= 4294967295L || this.zip64Mode == Zip64Mode.Always) {
            int i = 20;
            int i2 = 24;
            ZipLong.ZIP64_MAGIC.putLong(buf, i);
            ZipLong.ZIP64_MAGIC.putLong(buf, i2);
        } else {
            ZipLong.putLong(ze.getCompressedSize(), buf, 20);
            ZipLong.putLong(ze.getSize(), buf, 24);
        }
        ZipShort.putShort(nameLen, buf, 28);
        ZipShort.putShort(extra.length, buf, 30);
        ZipShort.putShort(commentLen, buf, 32);
        System.arraycopy(ZERO, 0, buf, 34, 2);
        ZipShort.putShort(ze.getInternalAttributes(), buf, 36);
        ZipLong.putLong(ze.getExternalAttributes(), buf, 38);
        if (lfhOffset >= 4294967295L || this.zip64Mode == Zip64Mode.Always) {
            int i3 = 42;
            ZipLong.putLong(4294967295L, buf, i3);
        } else {
            ZipLong.putLong(Math.min(lfhOffset, 4294967295L), buf, 42);
        }
        System.arraycopy(name.array(), name.arrayOffset(), buf, 46, nameLen);
        int extraStart = nameLen + 46;
        System.arraycopy(extra, 0, buf, extraStart, extra.length);
        int commentStart = extra.length + extraStart;
        System.arraycopy(commentB.array(), commentB.arrayOffset(), buf, commentStart, commentLen);
        return buf;
    }

    private void handleZip64Extra(ZipArchiveEntry ze, long lfhOffset, boolean needsZip64Extra) {
        if (needsZip64Extra) {
            Zip64ExtendedInformationExtraField z64 = getZip64Extra(ze);
            if (ze.getCompressedSize() >= 4294967295L || ze.getSize() >= 4294967295L || this.zip64Mode == Zip64Mode.Always) {
                z64.setCompressedSize(new ZipEightByteInteger(ze.getCompressedSize()));
                z64.setSize(new ZipEightByteInteger(ze.getSize()));
            } else {
                z64.setCompressedSize(null);
                z64.setSize(null);
            }
            if (lfhOffset >= 4294967295L || this.zip64Mode == Zip64Mode.Always) {
                z64.setRelativeHeaderOffset(new ZipEightByteInteger(lfhOffset));
            }
            ze.setExtra();
        }
    }

    protected void writeCentralDirectoryEnd() throws IOException {
        writeCounted(EOCD_SIG);
        writeCounted(ZERO);
        writeCounted(ZERO);
        int numberOfEntries = this.entries.size();
        if (numberOfEntries > 65535 && this.zip64Mode == Zip64Mode.Never) {
            throw new Zip64RequiredException("archive contains more than 65535 entries.");
        }
        if (this.cdOffset > 4294967295L && this.zip64Mode == Zip64Mode.Never) {
            throw new Zip64RequiredException("archive's size exceeds the limit of 4GByte.");
        }
        byte[] num = ZipShort.getBytes(Math.min(numberOfEntries, 65535));
        writeCounted(num);
        writeCounted(num);
        writeCounted(ZipLong.getBytes(Math.min(this.cdLength, 4294967295L)));
        writeCounted(ZipLong.getBytes(Math.min(this.cdOffset, 4294967295L)));
        ByteBuffer data = this.zipEncoding.encode(this.comment);
        int dataLen = data.limit() - data.position();
        writeCounted(ZipShort.getBytes(dataLen));
        this.streamCompressor.writeCounted(data.array(), data.arrayOffset(), dataLen);
    }

    protected void writeZip64CentralDirectory() throws IOException {
        if (this.zip64Mode == Zip64Mode.Never) {
            return;
        }
        if (!this.hasUsedZip64 && (this.cdOffset >= 4294967295L || this.cdLength >= 4294967295L || this.entries.size() >= 65535)) {
            this.hasUsedZip64 = true;
        }
        if (!this.hasUsedZip64) {
            return;
        }
        long offset = this.streamCompressor.getTotalBytesWritten();
        writeOut(ZIP64_EOCD_SIG);
        writeOut(ZipEightByteInteger.getBytes(44L));
        writeOut(ZipShort.getBytes(45));
        writeOut(ZipShort.getBytes(45));
        writeOut(LZERO);
        writeOut(LZERO);
        byte[] num = ZipEightByteInteger.getBytes(this.entries.size());
        writeOut(num);
        writeOut(num);
        writeOut(ZipEightByteInteger.getBytes(this.cdLength));
        writeOut(ZipEightByteInteger.getBytes(this.cdOffset));
        writeOut(ZIP64_EOCD_LOC_SIG);
        writeOut(LZERO);
        writeOut(ZipEightByteInteger.getBytes(offset));
        writeOut(ONE);
    }

    protected final void writeOut(byte[] data) throws IOException {
        this.streamCompressor.writeOut(data, 0, data.length);
    }

    protected final void writeOut(byte[] data, int offset, int length) throws IOException {
        this.streamCompressor.writeOut(data, offset, length);
    }

    private GeneralPurposeBit getGeneralPurposeBits(int zipMethod, boolean utfFallback) {
        GeneralPurposeBit b = new GeneralPurposeBit();
        b.useUTF8ForNames(this.useUTF8Flag || utfFallback);
        if (isDeflatedToOutputStream(zipMethod)) {
            b.useDataDescriptor(true);
        }
        return b;
    }

    private int versionNeededToExtract(int zipMethod, boolean zip64) {
        if (zip64) {
            return 45;
        }
        return isDeflatedToOutputStream(zipMethod) ? 20 : 10;
    }

    private boolean isDeflatedToOutputStream(int zipMethod) {
        return zipMethod == 8 && this.raf == null;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public ArchiveEntry createArchiveEntry(File inputFile, String entryName) throws IOException {
        if (this.finished) {
            throw new IOException("Stream has already been finished");
        }
        return new ZipArchiveEntry(inputFile, entryName);
    }

    private Zip64ExtendedInformationExtraField getZip64Extra(ZipArchiveEntry ze) {
        if (this.entry != null) {
            this.entry.causedUseOfZip64 = !this.hasUsedZip64;
        }
        this.hasUsedZip64 = true;
        Zip64ExtendedInformationExtraField z64 = (Zip64ExtendedInformationExtraField) ze.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        if (z64 == null) {
            z64 = new Zip64ExtendedInformationExtraField();
        }
        ze.addAsFirstExtraField(z64);
        return z64;
    }

    private boolean hasZip64Extra(ZipArchiveEntry ze) {
        return ze.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID) != null;
    }

    private Zip64Mode getEffectiveZip64Mode(ZipArchiveEntry ze) {
        if (this.zip64Mode != Zip64Mode.AsNeeded || this.raf != null || ze.getMethod() != 8 || ze.getSize() != -1) {
            return this.zip64Mode;
        }
        return Zip64Mode.Never;
    }

    private ZipEncoding getEntryEncoding(ZipArchiveEntry ze) {
        boolean encodable = this.zipEncoding.canEncode(ze.getName());
        return (encodable || !this.fallbackToUTF8) ? this.zipEncoding : ZipEncodingHelper.UTF8_ZIP_ENCODING;
    }

    private ByteBuffer getName(ZipArchiveEntry ze) throws IOException {
        return getEntryEncoding(ze).encode(ze.getName());
    }

    void destroy() throws IOException {
        if (this.raf != null) {
            this.raf.close();
        }
        if (this.out != null) {
            this.out.close();
        }
    }

    public static final class UnicodeExtraFieldPolicy {
        public static final UnicodeExtraFieldPolicy ALWAYS = new UnicodeExtraFieldPolicy("always");
        public static final UnicodeExtraFieldPolicy NEVER = new UnicodeExtraFieldPolicy("never");
        public static final UnicodeExtraFieldPolicy NOT_ENCODEABLE = new UnicodeExtraFieldPolicy("not encodeable");
        private final String name;

        private UnicodeExtraFieldPolicy(String n) {
            this.name = n;
        }

        public String toString() {
            return this.name;
        }
    }

    private static final class CurrentEntry {
        private long bytesRead;
        private boolean causedUseOfZip64;
        private long dataStart;
        private final ZipArchiveEntry entry;
        private boolean hasWritten;
        private long localDataStart;

        private CurrentEntry(ZipArchiveEntry entry) {
            this.localDataStart = 0L;
            this.dataStart = 0L;
            this.bytesRead = 0L;
            this.causedUseOfZip64 = false;
            this.entry = entry;
        }
    }
}
