package org.apache.commons.compress.archivers.zip;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes18.dex */
public class ExtraFieldUtils {
    private static final int WORD = 4;
    private static final Map<ZipShort, Class<?>> implementations = new ConcurrentHashMap();

    static {
        register(AsiExtraField.class);
        register(X5455_ExtendedTimestamp.class);
        register(X7875_NewUnix.class);
        register(JarMarker.class);
        register(UnicodePathExtraField.class);
        register(UnicodeCommentExtraField.class);
        register(Zip64ExtendedInformationExtraField.class);
        register(X000A_NTFS.class);
        register(X0014_X509Certificates.class);
        register(X0015_CertificateIdForFile.class);
        register(X0016_CertificateIdForCentralDirectory.class);
        register(X0017_StrongEncryptionHeader.class);
        register(X0019_EncryptionRecipientCertificateList.class);
    }

    public static void register(Class<?> c) {
        try {
            ZipExtraField ze = (ZipExtraField) c.newInstance();
            implementations.put(ze.getHeaderId(), c);
        } catch (ClassCastException e) {
            throw new RuntimeException(c + " doesn't implement ZipExtraField");
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(c + "'s no-arg constructor is not public");
        } catch (InstantiationException e3) {
            throw new RuntimeException(c + " is not a concrete class");
        }
    }

    public static ZipExtraField createExtraField(ZipShort headerId) throws IllegalAccessException, InstantiationException {
        Class<?> c = implementations.get(headerId);
        if (c != null) {
            return (ZipExtraField) c.newInstance();
        }
        UnrecognizedExtraField u = new UnrecognizedExtraField();
        u.setHeaderId(headerId);
        return u;
    }

    public static ZipExtraField[] parse(byte[] data) throws ZipException {
        return parse(data, true, UnparseableExtraField.THROW);
    }

    public static ZipExtraField[] parse(byte[] data, boolean local) throws ZipException {
        return parse(data, local, UnparseableExtraField.THROW);
    }

    public static ZipExtraField[] parse(byte[] data, boolean local, UnparseableExtraField onUnparseableData) throws ZipException {
        List<ZipExtraField> v = new ArrayList<>();
        int start = 0;
        while (start <= data.length - 4) {
            ZipShort headerId = new ZipShort(data, start);
            int length = new ZipShort(data, start + 2).getValue();
            if (start + 4 + length > data.length) {
                switch (onUnparseableData.getKey()) {
                    case 0:
                        throw new ZipException("bad extra field starting at " + start + ".  Block length of " + length + " bytes exceeds remaining data of " + ((data.length - start) - 4) + " bytes.");
                    case 1:
                        break;
                    case 2:
                        UnparseableExtraFieldData field = new UnparseableExtraFieldData();
                        if (local) {
                            field.parseFromLocalFileData(data, start, data.length - start);
                        } else {
                            field.parseFromCentralDirectoryData(data, start, data.length - start);
                        }
                        v.add(field);
                        break;
                    default:
                        throw new ZipException("unknown UnparseableExtraField key: " + onUnparseableData.getKey());
                }
                ZipExtraField[] result = new ZipExtraField[v.size()];
                return (ZipExtraField[]) v.toArray(result);
            }
            try {
                ZipExtraField ze = createExtraField(headerId);
                if (local) {
                    ze.parseFromLocalFileData(data, start + 4, length);
                } else {
                    ze.parseFromCentralDirectoryData(data, start + 4, length);
                }
                v.add(ze);
                start += length + 4;
            } catch (IllegalAccessException iae) {
                throw ((ZipException) new ZipException(iae.getMessage()).initCause(iae));
            } catch (InstantiationException ie) {
                throw ((ZipException) new ZipException(ie.getMessage()).initCause(ie));
            }
        }
        ZipExtraField[] result2 = new ZipExtraField[v.size()];
        return (ZipExtraField[]) v.toArray(result2);
    }

    public static byte[] mergeLocalFileDataData(ZipExtraField[] data) {
        byte[] local;
        boolean lastIsUnparseableHolder = data.length > 0 && (data[data.length - 1] instanceof UnparseableExtraFieldData);
        int regularExtraFieldCount = data.length;
        if (lastIsUnparseableHolder) {
            regularExtraFieldCount--;
        }
        int sum = regularExtraFieldCount * 4;
        for (ZipExtraField element : data) {
            sum += element.getLocalFileDataLength().getValue();
        }
        byte[] result = new byte[sum];
        int start = 0;
        for (int i = 0; i < regularExtraFieldCount; i++) {
            System.arraycopy(data[i].getHeaderId().getBytes(), 0, result, start, 2);
            System.arraycopy(data[i].getLocalFileDataLength().getBytes(), 0, result, start + 2, 2);
            start += 4;
            byte[] local2 = data[i].getLocalFileDataData();
            if (local2 != null) {
                System.arraycopy(local2, 0, result, start, local2.length);
                start += local2.length;
            }
        }
        if (lastIsUnparseableHolder && (local = data[data.length - 1].getLocalFileDataData()) != null) {
            System.arraycopy(local, 0, result, start, local.length);
        }
        return result;
    }

    public static byte[] mergeCentralDirectoryData(ZipExtraField[] data) {
        byte[] local;
        boolean lastIsUnparseableHolder = data.length > 0 && (data[data.length - 1] instanceof UnparseableExtraFieldData);
        int regularExtraFieldCount = data.length;
        if (lastIsUnparseableHolder) {
            regularExtraFieldCount--;
        }
        int sum = regularExtraFieldCount * 4;
        for (ZipExtraField element : data) {
            sum += element.getCentralDirectoryLength().getValue();
        }
        byte[] result = new byte[sum];
        int start = 0;
        for (int i = 0; i < regularExtraFieldCount; i++) {
            System.arraycopy(data[i].getHeaderId().getBytes(), 0, result, start, 2);
            System.arraycopy(data[i].getCentralDirectoryLength().getBytes(), 0, result, start + 2, 2);
            start += 4;
            byte[] local2 = data[i].getCentralDirectoryData();
            if (local2 != null) {
                System.arraycopy(local2, 0, result, start, local2.length);
                start += local2.length;
            }
        }
        if (lastIsUnparseableHolder && (local = data[data.length - 1].getCentralDirectoryData()) != null) {
            System.arraycopy(local, 0, result, start, local.length);
        }
        return result;
    }

    public static final class UnparseableExtraField {
        public static final int READ_KEY = 2;
        public static final int SKIP_KEY = 1;
        public static final int THROW_KEY = 0;
        private final int key;
        public static final UnparseableExtraField THROW = new UnparseableExtraField(0);
        public static final UnparseableExtraField SKIP = new UnparseableExtraField(1);
        public static final UnparseableExtraField READ = new UnparseableExtraField(2);

        private UnparseableExtraField(int k) {
            this.key = k;
        }

        public int getKey() {
            return this.key;
        }
    }
}
