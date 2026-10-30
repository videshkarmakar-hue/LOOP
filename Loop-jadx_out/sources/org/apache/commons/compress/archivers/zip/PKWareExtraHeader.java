package org.apache.commons.compress.archivers.zip;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public abstract class PKWareExtraHeader implements ZipExtraField {
    private byte[] centralData;
    private final ZipShort headerId;
    private byte[] localData;

    protected PKWareExtraHeader(ZipShort headerId) {
        this.headerId = headerId;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return this.headerId;
    }

    public void setLocalFileDataData(byte[] data) {
        this.localData = ZipUtil.copy(data);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return new ZipShort(this.localData != null ? this.localData.length : 0);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return ZipUtil.copy(this.localData);
    }

    public void setCentralDirectoryData(byte[] data) {
        this.centralData = ZipUtil.copy(data);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        if (this.centralData != null) {
            return new ZipShort(this.centralData.length);
        }
        return getLocalFileDataLength();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        if (this.centralData != null) {
            return ZipUtil.copy(this.centralData);
        }
        return getLocalFileDataData();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] data, int offset, int length) {
        byte[] tmp = new byte[length];
        System.arraycopy(data, offset, tmp, 0, length);
        setLocalFileDataData(tmp);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] data, int offset, int length) {
        byte[] tmp = new byte[length];
        System.arraycopy(data, offset, tmp, 0, length);
        setCentralDirectoryData(tmp);
        if (this.localData == null) {
            setLocalFileDataData(tmp);
        }
    }

    public enum EncryptionAlgorithm {
        DES(26113),
        RC2pre52(26114),
        TripleDES168(26115),
        TripleDES192(26121),
        AES128(26126),
        AES192(26127),
        AES256(26128),
        RC2(26370),
        RC4(26625),
        UNKNOWN(65535);

        private static final Map<Integer, EncryptionAlgorithm> codeToEnum;
        private final int code;

        static {
            Map<Integer, EncryptionAlgorithm> cte = new HashMap<>();
            EncryptionAlgorithm[] arr$ = values();
            for (EncryptionAlgorithm method : arr$) {
                cte.put(Integer.valueOf(method.getCode()), method);
            }
            codeToEnum = Collections.unmodifiableMap(cte);
        }

        EncryptionAlgorithm(int code) {
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }

        public static EncryptionAlgorithm getAlgorithmByCode(int code) {
            return codeToEnum.get(Integer.valueOf(code));
        }
    }

    public enum HashAlgorithm {
        NONE(0),
        CRC32(1),
        MD5(32771),
        SHA1(32772),
        RIPEND160(32775),
        SHA256(32780),
        SHA384(32781),
        SHA512(32782);

        private static final Map<Integer, HashAlgorithm> codeToEnum;
        private final int code;

        static {
            Map<Integer, HashAlgorithm> cte = new HashMap<>();
            HashAlgorithm[] arr$ = values();
            for (HashAlgorithm method : arr$) {
                cte.put(Integer.valueOf(method.getCode()), method);
            }
            codeToEnum = Collections.unmodifiableMap(cte);
        }

        HashAlgorithm(int code) {
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }

        public static HashAlgorithm getAlgorithmByCode(int code) {
            return codeToEnum.get(Integer.valueOf(code));
        }
    }
}
