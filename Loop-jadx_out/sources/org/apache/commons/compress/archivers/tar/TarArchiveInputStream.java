package org.apache.commons.compress.archivers.tar;

import androidx.compose.p001ui.geometry.InlineClassHelperKt;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.CharsetNames;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes18.dex */
public class TarArchiveInputStream extends ArchiveInputStream {
    private static final int SMALL_BUFFER_SIZE = 256;
    private final byte[] SMALL_BUF;
    private final int blockSize;
    private TarArchiveEntry currEntry;
    final String encoding;
    private long entryOffset;
    private long entrySize;
    private Map<String, String> globalPaxHeaders;
    private boolean hasHitEOF;

    /* JADX INFO: renamed from: is */
    private final InputStream f568is;
    private final int recordSize;
    private final ZipEncoding zipEncoding;

    public TarArchiveInputStream(InputStream is) {
        this(is, TarConstants.DEFAULT_BLKSIZE, 512);
    }

    public TarArchiveInputStream(InputStream is, String encoding) {
        this(is, TarConstants.DEFAULT_BLKSIZE, 512, encoding);
    }

    public TarArchiveInputStream(InputStream is, int blockSize) {
        this(is, blockSize, 512);
    }

    public TarArchiveInputStream(InputStream is, int blockSize, String encoding) {
        this(is, blockSize, 512, encoding);
    }

    public TarArchiveInputStream(InputStream is, int blockSize, int recordSize) {
        this(is, blockSize, recordSize, null);
    }

    public TarArchiveInputStream(InputStream is, int blockSize, int recordSize, String encoding) {
        this.SMALL_BUF = new byte[256];
        this.globalPaxHeaders = new HashMap();
        this.f568is = is;
        this.hasHitEOF = false;
        this.encoding = encoding;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(encoding);
        this.recordSize = recordSize;
        this.blockSize = blockSize;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f568is.close();
    }

    public int getRecordSize() {
        return this.recordSize;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (isDirectory()) {
            return 0;
        }
        if (this.entrySize - this.entryOffset > InlineClassHelperKt.FloatNonFiniteMask) {
            return Integer.MAX_VALUE;
        }
        return (int) (this.entrySize - this.entryOffset);
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        if (n <= 0 || isDirectory()) {
            return 0L;
        }
        long available = this.entrySize - this.entryOffset;
        long skipped = this.f568is.skip(Math.min(n, available));
        count(skipped);
        this.entryOffset += skipped;
        return skipped;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public void mark(int markLimit) {
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
    }

    public TarArchiveEntry getNextTarEntry() throws IOException {
        if (this.hasHitEOF) {
            return null;
        }
        if (this.currEntry != null) {
            IOUtils.skip(this, Long.MAX_VALUE);
            skipRecordPadding();
        }
        byte[] headerBuf = getRecord();
        if (headerBuf == null) {
            this.currEntry = null;
            return null;
        }
        try {
            this.currEntry = new TarArchiveEntry(headerBuf, this.zipEncoding);
            this.entryOffset = 0L;
            this.entrySize = this.currEntry.getSize();
            if (this.currEntry.isGNULongLinkEntry()) {
                byte[] longLinkData = getLongNameData();
                if (longLinkData == null) {
                    return null;
                }
                this.currEntry.setLinkName(this.zipEncoding.decode(longLinkData));
            }
            if (this.currEntry.isGNULongNameEntry()) {
                byte[] longNameData = getLongNameData();
                if (longNameData == null) {
                    return null;
                }
                this.currEntry.setName(this.zipEncoding.decode(longNameData));
            }
            if (this.currEntry.isGlobalPaxHeader()) {
                readGlobalPaxHeaders();
            }
            if (this.currEntry.isPaxHeader()) {
                paxHeaders();
            } else if (!this.globalPaxHeaders.isEmpty()) {
                applyPaxHeadersToCurrentEntry(this.globalPaxHeaders);
            }
            if (this.currEntry.isOldGNUSparse()) {
                readOldGNUSparse();
            }
            this.entrySize = this.currEntry.getSize();
            return this.currEntry;
        } catch (IllegalArgumentException e) {
            throw new IOException("Error detected parsing the header", e);
        }
    }

    private void skipRecordPadding() throws IOException {
        if (!isDirectory() && this.entrySize > 0 && this.entrySize % ((long) this.recordSize) != 0) {
            long numRecords = (this.entrySize / ((long) this.recordSize)) + 1;
            long padding = (((long) this.recordSize) * numRecords) - this.entrySize;
            long skipped = IOUtils.skip(this.f568is, padding);
            count(skipped);
        }
    }

    protected byte[] getLongNameData() throws IOException {
        ByteArrayOutputStream longName = new ByteArrayOutputStream();
        while (true) {
            int length = read(this.SMALL_BUF);
            if (length < 0) {
                break;
            }
            longName.write(this.SMALL_BUF, 0, length);
        }
        getNextEntry();
        if (this.currEntry == null) {
            return null;
        }
        byte[] longNameData = longName.toByteArray();
        int length2 = longNameData.length;
        while (length2 > 0 && longNameData[length2 - 1] == 0) {
            length2--;
        }
        if (length2 != longNameData.length) {
            byte[] l = new byte[length2];
            System.arraycopy(longNameData, 0, l, 0, length2);
            return l;
        }
        return longNameData;
    }

    private byte[] getRecord() throws IOException {
        byte[] headerBuf = readRecord();
        this.hasHitEOF = isEOFRecord(headerBuf);
        if (this.hasHitEOF && headerBuf != null) {
            tryToConsumeSecondEOFRecord();
            consumeRemainderOfLastBlock();
            return null;
        }
        return headerBuf;
    }

    protected boolean isEOFRecord(byte[] record) {
        return record == null || ArchiveUtils.isArrayZero(record, this.recordSize);
    }

    protected byte[] readRecord() throws IOException {
        byte[] record = new byte[this.recordSize];
        int readNow = IOUtils.readFully(this.f568is, record);
        count(readNow);
        if (readNow != this.recordSize) {
            return null;
        }
        return record;
    }

    private void readGlobalPaxHeaders() throws IOException {
        this.globalPaxHeaders = parsePaxHeaders(this);
        getNextEntry();
    }

    private void paxHeaders() throws IOException {
        Map<String, String> headers = parsePaxHeaders(this);
        getNextEntry();
        applyPaxHeadersToCurrentEntry(headers);
    }

    Map<String, String> parsePaxHeaders(InputStream i) throws IOException {
        int ch;
        Map<String, String> headers = new HashMap<>(this.globalPaxHeaders);
        do {
            int len = 0;
            int read = 0;
            while (true) {
                int i2 = i.read();
                ch = i2;
                if (i2 == -1) {
                    break;
                }
                read++;
                if (ch == 10) {
                    break;
                }
                if (ch == 32) {
                    ByteArrayOutputStream coll = new ByteArrayOutputStream();
                    while (true) {
                        int i3 = i.read();
                        ch = i3;
                        if (i3 == -1) {
                            break;
                        }
                        read++;
                        if (ch == 61) {
                            String keyword = coll.toString(CharsetNames.UTF_8);
                            int restLen = len - read;
                            if (restLen == 1) {
                                headers.remove(keyword);
                                break;
                            }
                            byte[] rest = new byte[restLen];
                            int got = IOUtils.readFully(i, rest);
                            if (got != restLen) {
                                throw new IOException("Failed to read Paxheader. Expected " + restLen + " bytes, read " + got);
                            }
                            String value = new String(rest, 0, restLen - 1, CharsetNames.UTF_8);
                            headers.put(keyword, value);
                            break;
                        }
                        coll.write((byte) ch);
                    }
                } else {
                    len = (len * 10) + (ch - 48);
                }
            }
        } while (ch != -1);
        return headers;
    }

    private void applyPaxHeadersToCurrentEntry(Map<String, String> headers) {
        for (Map.Entry<String, String> ent : headers.entrySet()) {
            String key = ent.getKey();
            String val = ent.getValue();
            if (DownloadUtil.CookieScheme.PATH.equals(key)) {
                this.currEntry.setName(val);
            } else if ("linkpath".equals(key)) {
                this.currEntry.setLinkName(val);
            } else if ("gid".equals(key)) {
                this.currEntry.setGroupId(Long.parseLong(val));
            } else if ("gname".equals(key)) {
                this.currEntry.setGroupName(val);
            } else if ("uid".equals(key)) {
                this.currEntry.setUserId(Long.parseLong(val));
            } else if ("uname".equals(key)) {
                this.currEntry.setUserName(val);
            } else if ("size".equals(key)) {
                this.currEntry.setSize(Long.parseLong(val));
            } else if ("mtime".equals(key)) {
                this.currEntry.setModTime((long) (Double.parseDouble(val) * 1000.0d));
            } else if ("SCHILY.devminor".equals(key)) {
                this.currEntry.setDevMinor(Integer.parseInt(val));
            } else if ("SCHILY.devmajor".equals(key)) {
                this.currEntry.setDevMajor(Integer.parseInt(val));
            } else if ("GNU.sparse.size".equals(key)) {
                this.currEntry.fillGNUSparse0xData(headers);
            } else if ("GNU.sparse.realsize".equals(key)) {
                this.currEntry.fillGNUSparse1xData(headers);
            } else if ("SCHILY.filetype".equals(key) && "sparse".equals(val)) {
                this.currEntry.fillStarSparseData(headers);
            }
        }
    }

    private void readOldGNUSparse() throws IOException {
        TarArchiveSparseEntry entry;
        if (this.currEntry.isExtended()) {
            do {
                byte[] headerBuf = getRecord();
                if (headerBuf == null) {
                    this.currEntry = null;
                    return;
                }
                entry = new TarArchiveSparseEntry(headerBuf);
            } while (entry.isExtended());
        }
    }

    private boolean isDirectory() {
        return this.currEntry != null && this.currEntry.isDirectory();
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public ArchiveEntry getNextEntry() throws IOException {
        return getNextTarEntry();
    }

    private void tryToConsumeSecondEOFRecord() throws IOException {
        boolean shouldReset = true;
        boolean marked = this.f568is.markSupported();
        if (marked) {
            this.f568is.mark(this.recordSize);
        }
        try {
            shouldReset = !isEOFRecord(readRecord());
        } finally {
            if (shouldReset && marked) {
                pushedBackBytes(this.recordSize);
                this.f568is.reset();
            }
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] buf, int offset, int numToRead) throws IOException {
        if (this.hasHitEOF || isDirectory() || this.entryOffset >= this.entrySize) {
            return -1;
        }
        if (this.currEntry == null) {
            throw new IllegalStateException("No current tar entry");
        }
        int numToRead2 = Math.min(numToRead, available());
        int totalRead = this.f568is.read(buf, offset, numToRead2);
        if (totalRead == -1) {
            if (numToRead2 > 0) {
                throw new IOException("Truncated TAR archive");
            }
            this.hasHitEOF = true;
        } else {
            count(totalRead);
            this.entryOffset += (long) totalRead;
        }
        return totalRead;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public boolean canReadEntryData(ArchiveEntry ae) {
        if (ae instanceof TarArchiveEntry) {
            TarArchiveEntry te = (TarArchiveEntry) ae;
            return !te.isSparse();
        }
        return false;
    }

    public TarArchiveEntry getCurrentEntry() {
        return this.currEntry;
    }

    protected final void setCurrentEntry(TarArchiveEntry e) {
        this.currEntry = e;
    }

    protected final boolean isAtEOF() {
        return this.hasHitEOF;
    }

    protected final void setAtEOF(boolean b) {
        this.hasHitEOF = b;
    }

    private void consumeRemainderOfLastBlock() throws IOException {
        long bytesReadOfLastBlock = getBytesRead() % ((long) this.blockSize);
        if (bytesReadOfLastBlock > 0) {
            long skipped = IOUtils.skip(this.f568is, ((long) this.blockSize) - bytesReadOfLastBlock);
            count(skipped);
        }
    }

    public static boolean matches(byte[] signature, int length) {
        if (length < 265) {
            return false;
        }
        if (ArchiveUtils.matchAsciiBuffer("ustar\u0000", signature, 257, 6) && ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_POSIX, signature, 263, 2)) {
            return true;
        }
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_GNU, signature, 257, 6) && (ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_GNU_SPACE, signature, 263, 2) || ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_GNU_ZERO, signature, 263, 2))) {
            return true;
        }
        return ArchiveUtils.matchAsciiBuffer("ustar\u0000", signature, 257, 6) && ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_ANT, signature, 263, 2);
    }
}
