package org.apache.commons.compress.archivers.cpio;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import kotlin.UByte;
import okhttp3.internal.p009ws.WebSocketProtocol;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.CharsetNames;

/* JADX INFO: loaded from: classes18.dex */
public class CpioArchiveOutputStream extends ArchiveOutputStream implements CpioConstants {
    private final int blockSize;
    private boolean closed;
    private long crc;
    final String encoding;
    private CpioArchiveEntry entry;
    private final short entryFormat;
    private boolean finished;
    private final HashMap<String, CpioArchiveEntry> names;
    private long nextArtificalDeviceAndInode;
    private final OutputStream out;
    private long written;
    private final ZipEncoding zipEncoding;

    public CpioArchiveOutputStream(OutputStream out, short format) {
        this(out, format, 512, CharsetNames.US_ASCII);
    }

    public CpioArchiveOutputStream(OutputStream out, short format, int blockSize) {
        this(out, format, blockSize, CharsetNames.US_ASCII);
    }

    public CpioArchiveOutputStream(OutputStream out, short format, int blockSize, String encoding) {
        this.closed = false;
        this.names = new HashMap<>();
        this.crc = 0L;
        this.nextArtificalDeviceAndInode = 1L;
        this.out = out;
        switch (format) {
            case 1:
            case 2:
            case 4:
            case 8:
                this.entryFormat = format;
                this.blockSize = blockSize;
                this.encoding = encoding;
                this.zipEncoding = ZipEncodingHelper.getZipEncoding(encoding);
                return;
            default:
                throw new IllegalArgumentException("Unknown format: " + ((int) format));
        }
    }

    public CpioArchiveOutputStream(OutputStream out) {
        this(out, (short) 1);
    }

    public CpioArchiveOutputStream(OutputStream out, String encoding) {
        this(out, (short) 1, 512, encoding);
    }

    private void ensureOpen() throws IOException {
        if (this.closed) {
            throw new IOException("Stream closed");
        }
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void putArchiveEntry(ArchiveEntry entry) throws IOException {
        if (this.finished) {
            throw new IOException("Stream has already been finished");
        }
        CpioArchiveEntry e = (CpioArchiveEntry) entry;
        ensureOpen();
        if (this.entry != null) {
            closeArchiveEntry();
        }
        if (e.getTime() == -1) {
            e.setTime(System.currentTimeMillis() / 1000);
        }
        short format = e.getFormat();
        if (format != this.entryFormat) {
            throw new IOException("Header format: " + ((int) format) + " does not match existing format: " + ((int) this.entryFormat));
        }
        if (this.names.put(e.getName(), e) != null) {
            throw new IOException("duplicate entry: " + e.getName());
        }
        writeHeader(e);
        this.entry = e;
        this.written = 0L;
    }

    private void writeHeader(CpioArchiveEntry e) throws IOException {
        switch (e.getFormat()) {
            case 1:
                this.out.write(ArchiveUtils.toAsciiBytes(CpioConstants.MAGIC_NEW));
                count(6);
                writeNewEntry(e);
                return;
            case 2:
                this.out.write(ArchiveUtils.toAsciiBytes(CpioConstants.MAGIC_NEW_CRC));
                count(6);
                writeNewEntry(e);
                return;
            case 4:
                this.out.write(ArchiveUtils.toAsciiBytes(CpioConstants.MAGIC_OLD_ASCII));
                count(6);
                writeOldAsciiEntry(e);
                return;
            case 8:
                writeBinaryLong(29127L, 2, true);
                writeOldBinaryEntry(e, true);
                return;
            default:
                throw new IOException("unknown format " + ((int) e.getFormat()));
        }
    }

    private void writeNewEntry(CpioArchiveEntry entry) throws IOException {
        long inode = entry.getInode();
        long devMin = entry.getDeviceMin();
        if (CpioConstants.CPIO_TRAILER.equals(entry.getName())) {
            devMin = 0;
            inode = 0;
        } else if (inode != 0 || devMin != 0) {
            this.nextArtificalDeviceAndInode = Math.max(this.nextArtificalDeviceAndInode, (4294967296L * devMin) + inode) + 1;
        } else {
            inode = this.nextArtificalDeviceAndInode & (-1);
            long j = this.nextArtificalDeviceAndInode;
            this.nextArtificalDeviceAndInode = 1 + j;
            devMin = (j >> 32) & (-1);
        }
        writeAsciiLong(inode, 8, 16);
        writeAsciiLong(entry.getMode(), 8, 16);
        writeAsciiLong(entry.getUID(), 8, 16);
        writeAsciiLong(entry.getGID(), 8, 16);
        writeAsciiLong(entry.getNumberOfLinks(), 8, 16);
        writeAsciiLong(entry.getTime(), 8, 16);
        writeAsciiLong(entry.getSize(), 8, 16);
        writeAsciiLong(entry.getDeviceMaj(), 8, 16);
        writeAsciiLong(devMin, 8, 16);
        writeAsciiLong(entry.getRemoteDeviceMaj(), 8, 16);
        writeAsciiLong(entry.getRemoteDeviceMin(), 8, 16);
        writeAsciiLong(entry.getName().length() + 1, 8, 16);
        writeAsciiLong(entry.getChksum(), 8, 16);
        writeCString(entry.getName());
        pad(entry.getHeaderPadCount());
    }

    private void writeOldAsciiEntry(CpioArchiveEntry entry) throws IOException {
        long inode = entry.getInode();
        long device = entry.getDevice();
        if (CpioConstants.CPIO_TRAILER.equals(entry.getName())) {
            device = 0;
            inode = 0;
        } else if (inode != 0 || device != 0) {
            this.nextArtificalDeviceAndInode = Math.max(this.nextArtificalDeviceAndInode, (262144 * device) + inode) + 1;
        } else {
            inode = this.nextArtificalDeviceAndInode & 262143;
            long j = this.nextArtificalDeviceAndInode;
            this.nextArtificalDeviceAndInode = 1 + j;
            device = (j >> 18) & 262143;
        }
        writeAsciiLong(device, 6, 8);
        writeAsciiLong(inode, 6, 8);
        writeAsciiLong(entry.getMode(), 6, 8);
        writeAsciiLong(entry.getUID(), 6, 8);
        writeAsciiLong(entry.getGID(), 6, 8);
        writeAsciiLong(entry.getNumberOfLinks(), 6, 8);
        writeAsciiLong(entry.getRemoteDevice(), 6, 8);
        writeAsciiLong(entry.getTime(), 11, 8);
        writeAsciiLong(entry.getName().length() + 1, 6, 8);
        writeAsciiLong(entry.getSize(), 11, 8);
        writeCString(entry.getName());
    }

    private void writeOldBinaryEntry(CpioArchiveEntry entry, boolean swapHalfWord) throws IOException {
        long inode = entry.getInode();
        long device = entry.getDevice();
        if (CpioConstants.CPIO_TRAILER.equals(entry.getName())) {
            device = 0;
            inode = 0;
        } else if (inode != 0 || device != 0) {
            this.nextArtificalDeviceAndInode = Math.max(this.nextArtificalDeviceAndInode, (65536 * device) + inode) + 1;
        } else {
            inode = this.nextArtificalDeviceAndInode & WebSocketProtocol.PAYLOAD_SHORT_MAX;
            long j = this.nextArtificalDeviceAndInode;
            this.nextArtificalDeviceAndInode = 1 + j;
            device = (j >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        }
        writeBinaryLong(device, 2, swapHalfWord);
        writeBinaryLong(inode, 2, swapHalfWord);
        writeBinaryLong(entry.getMode(), 2, swapHalfWord);
        writeBinaryLong(entry.getUID(), 2, swapHalfWord);
        writeBinaryLong(entry.getGID(), 2, swapHalfWord);
        writeBinaryLong(entry.getNumberOfLinks(), 2, swapHalfWord);
        writeBinaryLong(entry.getRemoteDevice(), 2, swapHalfWord);
        writeBinaryLong(entry.getTime(), 4, swapHalfWord);
        writeBinaryLong(entry.getName().length() + 1, 2, swapHalfWord);
        writeBinaryLong(entry.getSize(), 4, swapHalfWord);
        writeCString(entry.getName());
        pad(entry.getHeaderPadCount());
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void closeArchiveEntry() throws IOException {
        if (this.finished) {
            throw new IOException("Stream has already been finished");
        }
        ensureOpen();
        if (this.entry == null) {
            throw new IOException("Trying to close non-existent entry");
        }
        if (this.entry.getSize() != this.written) {
            throw new IOException("invalid entry size (expected " + this.entry.getSize() + " but got " + this.written + " bytes)");
        }
        pad(this.entry.getDataPadCount());
        if (this.entry.getFormat() == 2 && this.crc != this.entry.getChksum()) {
            throw new IOException("CRC Error");
        }
        this.entry = null;
        this.crc = 0L;
        this.written = 0L;
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int off, int len) throws IOException {
        ensureOpen();
        if (off < 0 || len < 0 || off > b.length - len) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return;
        }
        if (this.entry == null) {
            throw new IOException("no current CPIO entry");
        }
        if (this.written + ((long) len) > this.entry.getSize()) {
            throw new IOException("attempt to write past end of STORED entry");
        }
        this.out.write(b, off, len);
        this.written += (long) len;
        if (this.entry.getFormat() == 2) {
            for (int pos = 0; pos < len; pos++) {
                this.crc += (long) (b[pos] & UByte.MAX_VALUE);
            }
        }
        count(len);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void finish() throws IOException {
        ensureOpen();
        if (this.finished) {
            throw new IOException("This archive has already been finished");
        }
        if (this.entry != null) {
            throw new IOException("This archive contains unclosed entries.");
        }
        this.entry = new CpioArchiveEntry(this.entryFormat);
        this.entry.setName(CpioConstants.CPIO_TRAILER);
        this.entry.setNumberOfLinks(1L);
        writeHeader(this.entry);
        closeArchiveEntry();
        int lengthOfLastBlock = (int) (getBytesWritten() % ((long) this.blockSize));
        if (lengthOfLastBlock != 0) {
            pad(this.blockSize - lengthOfLastBlock);
        }
        this.finished = true;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.finished) {
            finish();
        }
        if (!this.closed) {
            this.out.close();
            this.closed = true;
        }
    }

    private void pad(int count) throws IOException {
        if (count > 0) {
            byte[] buff = new byte[count];
            this.out.write(buff);
            count(count);
        }
    }

    private void writeBinaryLong(long number, int length, boolean swapHalfWord) throws IOException {
        byte[] tmp = CpioUtil.long2byteArray(number, length, swapHalfWord);
        this.out.write(tmp);
        count(tmp.length);
    }

    private void writeAsciiLong(long number, int length, int radix) throws IOException {
        String tmpStr;
        StringBuilder tmp = new StringBuilder();
        if (radix == 16) {
            tmp.append(Long.toHexString(number));
        } else if (radix == 8) {
            tmp.append(Long.toOctalString(number));
        } else {
            tmp.append(Long.toString(number));
        }
        if (tmp.length() <= length) {
            long insertLength = length - tmp.length();
            for (int pos = 0; pos < insertLength; pos++) {
                tmp.insert(0, "0");
            }
            tmpStr = tmp.toString();
        } else {
            tmpStr = tmp.substring(tmp.length() - length);
        }
        byte[] b = ArchiveUtils.toAsciiBytes(tmpStr);
        this.out.write(b);
        count(b.length);
    }

    private void writeCString(String str) throws IOException {
        ByteBuffer buf = this.zipEncoding.encode(str);
        int len = buf.limit() - buf.position();
        this.out.write(buf.array(), buf.arrayOffset(), len);
        this.out.write(0);
        count(len + 1);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public ArchiveEntry createArchiveEntry(File inputFile, String entryName) throws IOException {
        if (this.finished) {
            throw new IOException("Stream has already been finished");
        }
        return new CpioArchiveEntry(inputFile, entryName);
    }
}
