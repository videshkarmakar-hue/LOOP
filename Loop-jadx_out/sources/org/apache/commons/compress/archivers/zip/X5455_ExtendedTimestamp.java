package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import java.util.Date;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes18.dex */
public class X5455_ExtendedTimestamp implements ZipExtraField, Cloneable, Serializable {
    public static final byte ACCESS_TIME_BIT = 2;
    public static final byte CREATE_TIME_BIT = 4;
    private static final ZipShort HEADER_ID = new ZipShort(21589);
    public static final byte MODIFY_TIME_BIT = 1;
    private static final long serialVersionUID = 1;
    private ZipLong accessTime;
    private boolean bit0_modifyTimePresent;
    private boolean bit1_accessTimePresent;
    private boolean bit2_createTimePresent;
    private ZipLong createTime;
    private byte flags;
    private ZipLong modifyTime;

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return new ZipShort((this.bit0_modifyTimePresent ? 4 : 0) + 1 + ((!this.bit1_accessTimePresent || this.accessTime == null) ? 0 : 4) + ((!this.bit2_createTimePresent || this.createTime == null) ? 0 : 4));
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return new ZipShort((this.bit0_modifyTimePresent ? 4 : 0) + 1);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        byte[] data = new byte[getLocalFileDataLength().getValue()];
        int pos = 0 + 1;
        data[0] = 0;
        if (this.bit0_modifyTimePresent) {
            data[0] = (byte) (data[0] | 1);
            System.arraycopy(this.modifyTime.getBytes(), 0, data, pos, 4);
            pos += 4;
        }
        if (this.bit1_accessTimePresent && this.accessTime != null) {
            data[0] = (byte) (data[0] | 2);
            System.arraycopy(this.accessTime.getBytes(), 0, data, pos, 4);
            pos += 4;
        }
        if (this.bit2_createTimePresent && this.createTime != null) {
            data[0] = (byte) (data[0] | 4);
            System.arraycopy(this.createTime.getBytes(), 0, data, pos, 4);
            int i = pos + 4;
        }
        return data;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        byte[] centralData = new byte[getCentralDirectoryLength().getValue()];
        byte[] localData = getLocalFileDataData();
        System.arraycopy(localData, 0, centralData, 0, centralData.length);
        return centralData;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] data, int offset, int length) throws ZipException {
        reset();
        int len = offset + length;
        int offset2 = offset + 1;
        setFlags(data[offset]);
        if (this.bit0_modifyTimePresent) {
            this.modifyTime = new ZipLong(data, offset2);
            offset2 += 4;
        }
        if (this.bit1_accessTimePresent && offset2 + 4 <= len) {
            this.accessTime = new ZipLong(data, offset2);
            offset2 += 4;
        }
        if (this.bit2_createTimePresent && offset2 + 4 <= len) {
            this.createTime = new ZipLong(data, offset2);
            int i = offset2 + 4;
        }
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] buffer, int offset, int length) throws ZipException {
        reset();
        parseFromLocalFileData(buffer, offset, length);
    }

    private void reset() {
        setFlags((byte) 0);
        this.modifyTime = null;
        this.accessTime = null;
        this.createTime = null;
    }

    public void setFlags(byte flags) {
        this.flags = flags;
        this.bit0_modifyTimePresent = (flags & 1) == 1;
        this.bit1_accessTimePresent = (flags & 2) == 2;
        this.bit2_createTimePresent = (flags & 4) == 4;
    }

    public byte getFlags() {
        return this.flags;
    }

    public boolean isBit0_modifyTimePresent() {
        return this.bit0_modifyTimePresent;
    }

    public boolean isBit1_accessTimePresent() {
        return this.bit1_accessTimePresent;
    }

    public boolean isBit2_createTimePresent() {
        return this.bit2_createTimePresent;
    }

    public ZipLong getModifyTime() {
        return this.modifyTime;
    }

    public ZipLong getAccessTime() {
        return this.accessTime;
    }

    public ZipLong getCreateTime() {
        return this.createTime;
    }

    public Date getModifyJavaTime() {
        if (this.modifyTime != null) {
            return new Date(this.modifyTime.getValue() * 1000);
        }
        return null;
    }

    public Date getAccessJavaTime() {
        if (this.accessTime != null) {
            return new Date(this.accessTime.getValue() * 1000);
        }
        return null;
    }

    public Date getCreateJavaTime() {
        if (this.createTime != null) {
            return new Date(this.createTime.getValue() * 1000);
        }
        return null;
    }

    public void setModifyTime(ZipLong l) {
        this.bit0_modifyTimePresent = l != null;
        this.flags = (byte) (l != null ? 1 | this.flags : this.flags & (-2));
        this.modifyTime = l;
    }

    public void setAccessTime(ZipLong l) {
        this.bit1_accessTimePresent = l != null;
        byte b = this.flags;
        this.flags = (byte) (l != null ? b | 2 : b & (-3));
        this.accessTime = l;
    }

    public void setCreateTime(ZipLong l) {
        this.bit2_createTimePresent = l != null;
        byte b = this.flags;
        this.flags = (byte) (l != null ? b | 4 : b & (-5));
        this.createTime = l;
    }

    public void setModifyJavaTime(Date d) {
        setModifyTime(dateToZipLong(d));
    }

    public void setAccessJavaTime(Date d) {
        setAccessTime(dateToZipLong(d));
    }

    public void setCreateJavaTime(Date d) {
        setCreateTime(dateToZipLong(d));
    }

    private static ZipLong dateToZipLong(Date d) {
        if (d == null) {
            return null;
        }
        long l = d.getTime() / 1000;
        if (l >= 4294967296L) {
            throw new IllegalArgumentException("Cannot set an X5455 timestamp larger than 2^32: " + l);
        }
        return new ZipLong(l);
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("0x5455 Zip Extra Field: Flags=");
        buf.append(Integer.toBinaryString(ZipUtil.unsignedIntToSignedByte(this.flags))).append(" ");
        if (this.bit0_modifyTimePresent && this.modifyTime != null) {
            Date m = getModifyJavaTime();
            buf.append(" Modify:[").append(m).append("] ");
        }
        if (this.bit1_accessTimePresent && this.accessTime != null) {
            Date a = getAccessJavaTime();
            buf.append(" Access:[").append(a).append("] ");
        }
        if (this.bit2_createTimePresent && this.createTime != null) {
            Date c = getCreateJavaTime();
            buf.append(" Create:[").append(c).append("] ");
        }
        return buf.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object o) {
        if (!(o instanceof X5455_ExtendedTimestamp)) {
            return false;
        }
        X5455_ExtendedTimestamp xf = (X5455_ExtendedTimestamp) o;
        if ((this.flags & 7) != (xf.flags & 7)) {
            return false;
        }
        if (this.modifyTime != xf.modifyTime && (this.modifyTime == null || !this.modifyTime.equals(xf.modifyTime))) {
            return false;
        }
        if (this.accessTime == xf.accessTime || (this.accessTime != null && this.accessTime.equals(xf.accessTime))) {
            return this.createTime == xf.createTime || (this.createTime != null && this.createTime.equals(xf.createTime));
        }
        return false;
    }

    public int hashCode() {
        int hc = (this.flags & 7) * (-123);
        if (this.modifyTime != null) {
            hc ^= this.modifyTime.hashCode();
        }
        if (this.accessTime != null) {
            hc ^= Integer.rotateLeft(this.accessTime.hashCode(), 11);
        }
        if (this.createTime != null) {
            return hc ^ Integer.rotateLeft(this.createTime.hashCode(), 22);
        }
        return hc;
    }
}
