package org.apache.commons.compress.archivers.sevenz;

import java.util.Arrays;

/* JADX INFO: loaded from: classes18.dex */
public enum SevenZMethod {
    COPY(new byte[]{0}),
    LZMA(new byte[]{3, 1, 1}),
    LZMA2(new byte[]{33}),
    DEFLATE(new byte[]{4, 1, 8}),
    BZIP2(new byte[]{4, 2, 2}),
    AES256SHA256(new byte[]{6, -15, 7, 1}),
    BCJ_X86_FILTER(new byte[]{3, 3, 1, 3}),
    BCJ_PPC_FILTER(new byte[]{3, 3, 2, 5}),
    BCJ_IA64_FILTER(new byte[]{3, 3, 4, 1}),
    BCJ_ARM_FILTER(new byte[]{3, 3, 5, 1}),
    BCJ_ARM_THUMB_FILTER(new byte[]{3, 3, 7, 1}),
    BCJ_SPARC_FILTER(new byte[]{3, 3, 8, 5}),
    DELTA_FILTER(new byte[]{3});


    /* JADX INFO: renamed from: id */
    private final byte[] f567id;

    SevenZMethod(byte[] id) {
        this.f567id = id;
    }

    byte[] getId() {
        byte[] copy = new byte[this.f567id.length];
        System.arraycopy(this.f567id, 0, copy, 0, this.f567id.length);
        return copy;
    }

    static SevenZMethod byId(byte[] id) {
        SevenZMethod[] arr$ = (SevenZMethod[]) SevenZMethod.class.getEnumConstants();
        for (SevenZMethod m : arr$) {
            if (Arrays.equals(m.f567id, id)) {
                return m;
            }
        }
        return null;
    }
}
