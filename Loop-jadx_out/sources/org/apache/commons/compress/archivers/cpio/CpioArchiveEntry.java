package org.apache.commons.compress.archivers.cpio;

import java.io.File;
import java.util.Date;
import okhttp3.internal.http2.Http2Stream;
import org.apache.commons.compress.archivers.ArchiveEntry;

/* JADX INFO: loaded from: classes18.dex */
public class CpioArchiveEntry implements CpioConstants, ArchiveEntry {
    private final int alignmentBoundary;
    private long chksum;
    private final short fileFormat;
    private long filesize;
    private long gid;
    private final int headerSize;
    private long inode;
    private long maj;
    private long min;
    private long mode;
    private long mtime;
    private String name;
    private long nlink;
    private long rmaj;
    private long rmin;
    private long uid;

    public CpioArchiveEntry(short format) {
        this.chksum = 0L;
        this.filesize = 0L;
        this.gid = 0L;
        this.inode = 0L;
        this.maj = 0L;
        this.min = 0L;
        this.mode = 0L;
        this.mtime = 0L;
        this.nlink = 0L;
        this.rmaj = 0L;
        this.rmin = 0L;
        this.uid = 0L;
        switch (format) {
            case 1:
                this.headerSize = 110;
                this.alignmentBoundary = 4;
                break;
            case 2:
                this.headerSize = 110;
                this.alignmentBoundary = 4;
                break;
            case 4:
                this.headerSize = 76;
                this.alignmentBoundary = 0;
                break;
            case 8:
                this.headerSize = 26;
                this.alignmentBoundary = 2;
                break;
            default:
                throw new IllegalArgumentException("Unknown header type");
        }
        this.fileFormat = format;
    }

    public CpioArchiveEntry(String name) {
        this((short) 1, name);
    }

    public CpioArchiveEntry(short format, String name) {
        this(format);
        this.name = name;
    }

    public CpioArchiveEntry(String name, long size) {
        this(name);
        setSize(size);
    }

    public CpioArchiveEntry(short format, String name, long size) {
        this(format, name);
        setSize(size);
    }

    public CpioArchiveEntry(File inputFile, String entryName) {
        this((short) 1, inputFile, entryName);
    }

    public CpioArchiveEntry(short format, File inputFile, String entryName) {
        this(format, entryName, inputFile.isFile() ? inputFile.length() : 0L);
        if (inputFile.isDirectory()) {
            setMode(Http2Stream.EMIT_BUFFER_SIZE);
        } else if (inputFile.isFile()) {
            setMode(32768L);
        } else {
            throw new IllegalArgumentException("Cannot determine type of file " + inputFile.getName());
        }
        setTime(inputFile.lastModified() / 1000);
    }

    private void checkNewFormat() {
        if ((this.fileFormat & 3) == 0) {
            throw new UnsupportedOperationException();
        }
    }

    private void checkOldFormat() {
        if ((this.fileFormat & 12) == 0) {
            throw new UnsupportedOperationException();
        }
    }

    public long getChksum() {
        checkNewFormat();
        return this.chksum;
    }

    public long getDevice() {
        checkOldFormat();
        return this.min;
    }

    public long getDeviceMaj() {
        checkNewFormat();
        return this.maj;
    }

    public long getDeviceMin() {
        checkNewFormat();
        return this.min;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public long getSize() {
        return this.filesize;
    }

    public short getFormat() {
        return this.fileFormat;
    }

    public long getGID() {
        return this.gid;
    }

    public int getHeaderSize() {
        return this.headerSize;
    }

    public int getAlignmentBoundary() {
        return this.alignmentBoundary;
    }

    public int getHeaderPadCount() {
        if (this.alignmentBoundary == 0) {
            return 0;
        }
        int size = this.headerSize + 1;
        if (this.name != null) {
            size += this.name.length();
        }
        int remain = size % this.alignmentBoundary;
        if (remain > 0) {
            return this.alignmentBoundary - remain;
        }
        return 0;
    }

    public int getDataPadCount() {
        if (this.alignmentBoundary == 0) {
            return 0;
        }
        long size = this.filesize;
        int remain = (int) (size % ((long) this.alignmentBoundary));
        if (remain > 0) {
            return this.alignmentBoundary - remain;
        }
        return 0;
    }

    public long getInode() {
        return this.inode;
    }

    public long getMode() {
        if (this.mode != 0 || CpioConstants.CPIO_TRAILER.equals(this.name)) {
            return this.mode;
        }
        return 32768L;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public String getName() {
        return this.name;
    }

    public long getNumberOfLinks() {
        if (this.nlink == 0) {
            return isDirectory() ? 2L : 1L;
        }
        return this.nlink;
    }

    public long getRemoteDevice() {
        checkOldFormat();
        return this.rmin;
    }

    public long getRemoteDeviceMaj() {
        checkNewFormat();
        return this.rmaj;
    }

    public long getRemoteDeviceMin() {
        checkNewFormat();
        return this.rmin;
    }

    public long getTime() {
        return this.mtime;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public Date getLastModifiedDate() {
        return new Date(getTime() * 1000);
    }

    public long getUID() {
        return this.uid;
    }

    public boolean isBlockDevice() {
        return CpioUtil.fileType(this.mode) == 24576;
    }

    public boolean isCharacterDevice() {
        return CpioUtil.fileType(this.mode) == 8192;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public boolean isDirectory() {
        return CpioUtil.fileType(this.mode) == Http2Stream.EMIT_BUFFER_SIZE;
    }

    public boolean isNetwork() {
        return CpioUtil.fileType(this.mode) == 36864;
    }

    public boolean isPipe() {
        return CpioUtil.fileType(this.mode) == 4096;
    }

    public boolean isRegularFile() {
        return CpioUtil.fileType(this.mode) == 32768;
    }

    public boolean isSocket() {
        return CpioUtil.fileType(this.mode) == 49152;
    }

    public boolean isSymbolicLink() {
        return CpioUtil.fileType(this.mode) == 40960;
    }

    public void setChksum(long chksum) {
        checkNewFormat();
        this.chksum = chksum;
    }

    public void setDevice(long device) {
        checkOldFormat();
        this.min = device;
    }

    public void setDeviceMaj(long maj) {
        checkNewFormat();
        this.maj = maj;
    }

    public void setDeviceMin(long min) {
        checkNewFormat();
        this.min = min;
    }

    public void setSize(long size) {
        if (size < 0 || size > 4294967295L) {
            throw new IllegalArgumentException("invalid entry size <" + size + ">");
        }
        this.filesize = size;
    }

    public void setGID(long gid) {
        this.gid = gid;
    }

    public void setInode(long inode) {
        this.inode = inode;
    }

    public void setMode(long mode) {
        long maskedMode = 61440 & mode;
        switch ((int) maskedMode) {
            case 4096:
            case 8192:
            case 16384:
            case CpioConstants.C_ISBLK /* 24576 */:
            case 32768:
            case CpioConstants.C_ISNWK /* 36864 */:
            case 40960:
            case CpioConstants.C_ISSOCK /* 49152 */:
                this.mode = mode;
                return;
            default:
                throw new IllegalArgumentException("Unknown mode. Full: " + Long.toHexString(mode) + " Masked: " + Long.toHexString(maskedMode));
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfLinks(long nlink) {
        this.nlink = nlink;
    }

    public void setRemoteDevice(long device) {
        checkOldFormat();
        this.rmin = device;
    }

    public void setRemoteDeviceMaj(long rmaj) {
        checkNewFormat();
        this.rmaj = rmaj;
    }

    public void setRemoteDeviceMin(long rmin) {
        checkNewFormat();
        this.rmin = rmin;
    }

    public void setTime(long time) {
        this.mtime = time;
    }

    public void setUID(long uid) {
        this.uid = uid;
    }

    public int hashCode() {
        int result = (1 * 31) + (this.name == null ? 0 : this.name.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CpioArchiveEntry other = (CpioArchiveEntry) obj;
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        return true;
    }
}
