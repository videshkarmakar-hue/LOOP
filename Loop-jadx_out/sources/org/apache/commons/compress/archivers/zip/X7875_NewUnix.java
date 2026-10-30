package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes18.dex */
public class X7875_NewUnix implements ZipExtraField, Cloneable, Serializable {
    private static final long serialVersionUID = 1;
    private BigInteger gid;
    private BigInteger uid;
    private int version = 1;
    private static final ZipShort HEADER_ID = new ZipShort(30837);
    private static final ZipShort ZERO = new ZipShort(0);
    private static final BigInteger ONE_THOUSAND = BigInteger.valueOf(1000);

    public X7875_NewUnix() {
        reset();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public long getUID() {
        return ZipUtil.bigToLong(this.uid);
    }

    public long getGID() {
        return ZipUtil.bigToLong(this.gid);
    }

    public void setUID(long l) {
        this.uid = ZipUtil.longToBig(l);
    }

    public void setGID(long l) {
        this.gid = ZipUtil.longToBig(l);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        int uidSize = trimLeadingZeroesForceMinLength(this.uid.toByteArray()).length;
        int gidSize = trimLeadingZeroesForceMinLength(this.gid.toByteArray()).length;
        return new ZipShort(uidSize + 3 + gidSize);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return ZERO;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        byte[] uidBytes = this.uid.toByteArray();
        byte[] gidBytes = this.gid.toByteArray();
        byte[] uidBytes2 = trimLeadingZeroesForceMinLength(uidBytes);
        byte[] gidBytes2 = trimLeadingZeroesForceMinLength(gidBytes);
        byte[] data = new byte[uidBytes2.length + 3 + gidBytes2.length];
        ZipUtil.reverse(uidBytes2);
        ZipUtil.reverse(gidBytes2);
        int pos = 0 + 1;
        data[0] = ZipUtil.unsignedIntToSignedByte(this.version);
        int pos2 = pos + 1;
        data[pos] = ZipUtil.unsignedIntToSignedByte(uidBytes2.length);
        System.arraycopy(uidBytes2, 0, data, pos2, uidBytes2.length);
        int pos3 = pos2 + uidBytes2.length;
        data[pos3] = ZipUtil.unsignedIntToSignedByte(gidBytes2.length);
        System.arraycopy(gidBytes2, 0, data, pos3 + 1, gidBytes2.length);
        return data;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        return new byte[0];
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] data, int offset, int length) throws ZipException {
        reset();
        int offset2 = offset + 1;
        this.version = ZipUtil.signedByteToUnsignedInt(data[offset]);
        int offset3 = offset2 + 1;
        int uidSize = ZipUtil.signedByteToUnsignedInt(data[offset2]);
        byte[] uidBytes = new byte[uidSize];
        System.arraycopy(data, offset3, uidBytes, 0, uidSize);
        int offset4 = offset3 + uidSize;
        this.uid = new BigInteger(1, ZipUtil.reverse(uidBytes));
        int offset5 = offset4 + 1;
        int gidSize = ZipUtil.signedByteToUnsignedInt(data[offset4]);
        byte[] gidBytes = new byte[gidSize];
        System.arraycopy(data, offset5, gidBytes, 0, gidSize);
        this.gid = new BigInteger(1, ZipUtil.reverse(gidBytes));
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] buffer, int offset, int length) throws ZipException {
    }

    private void reset() {
        this.uid = ONE_THOUSAND;
        this.gid = ONE_THOUSAND;
    }

    public String toString() {
        return "0x7875 Zip Extra Field: UID=" + this.uid + " GID=" + this.gid;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object o) {
        if (!(o instanceof X7875_NewUnix)) {
            return false;
        }
        X7875_NewUnix xf = (X7875_NewUnix) o;
        return this.version == xf.version && this.uid.equals(xf.uid) && this.gid.equals(xf.gid);
    }

    public int hashCode() {
        int hc = this.version * (-1234567);
        return (Integer.rotateLeft(this.uid.hashCode(), 16) ^ hc) ^ this.gid.hashCode();
    }

    static byte[] trimLeadingZeroesForceMinLength(byte[] array) {
        if (array == null) {
            return array;
        }
        int pos = 0;
        for (byte b : array) {
            if (b != 0) {
                break;
            }
            pos++;
        }
        byte[] trimmedArray = new byte[Math.max(1, array.length - pos)];
        int startPos = trimmedArray.length - (array.length - pos);
        System.arraycopy(array, pos, trimmedArray, startPos, trimmedArray.length - startPos);
        return trimmedArray;
    }
}
