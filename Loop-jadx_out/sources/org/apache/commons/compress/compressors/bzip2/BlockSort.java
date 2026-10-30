package org.apache.commons.compress.compressors.bzip2;

import java.util.BitSet;
import kotlin.UByte;

/* JADX INFO: loaded from: classes18.dex */
class BlockSort {
    private static final int CLEARMASK = -2097153;
    private static final int DEPTH_THRESH = 10;
    private static final int FALLBACK_QSORT_SMALL_THRESH = 10;
    private static final int FALLBACK_QSORT_STACK_SIZE = 100;
    private static final int[] INCS = {1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484};
    private static final int QSORT_STACK_SIZE = 1000;
    private static final int SETMASK = 2097152;
    private static final int SMALL_THRESH = 20;
    private static final int STACK_SIZE = 1000;
    private static final int WORK_FACTOR = 30;
    private int[] eclass;
    private boolean firstAttempt;
    private final char[] quadrant;
    private int workDone;
    private int workLimit;
    private final int[] stack_ll = new int[1000];
    private final int[] stack_hh = new int[1000];
    private final int[] stack_dd = new int[1000];
    private final int[] mainSort_runningOrder = new int[256];
    private final int[] mainSort_copy = new int[256];
    private final boolean[] mainSort_bigDone = new boolean[256];
    private final int[] ftab = new int[65537];

    BlockSort(BZip2CompressorOutputStream.Data data) {
        this.quadrant = data.sfmap;
    }

    void blockSort(BZip2CompressorOutputStream.Data data, int last) {
        this.workLimit = last * 30;
        this.workDone = 0;
        this.firstAttempt = true;
        if (last + 1 < 10000) {
            fallbackSort(data, last);
        } else {
            mainSort(data, last);
            if (this.firstAttempt && this.workDone > this.workLimit) {
                fallbackSort(data, last);
            }
        }
        int[] fmap = data.fmap;
        data.origPtr = -1;
        for (int i = 0; i <= last; i++) {
            if (fmap[i] == 0) {
                data.origPtr = i;
                return;
            }
        }
    }

    final void fallbackSort(BZip2CompressorOutputStream.Data data, int last) {
        data.block[0] = data.block[last + 1];
        fallbackSort(data.fmap, data.block, last + 1);
        for (int i = 0; i < last + 1; i++) {
            int[] iArr = data.fmap;
            iArr[i] = iArr[i] - 1;
        }
        for (int i2 = 0; i2 < last + 1; i2++) {
            if (data.fmap[i2] == -1) {
                data.fmap[i2] = last;
                return;
            }
        }
    }

    private void fallbackSimpleSort(int[] fmap, int[] eclass, int lo, int hi) {
        if (lo == hi) {
            return;
        }
        if (hi - lo > 3) {
            for (int i = hi - 4; i >= lo; i--) {
                int tmp = fmap[i];
                int ec_tmp = eclass[tmp];
                int j = i + 4;
                while (j <= hi && ec_tmp > eclass[fmap[j]]) {
                    fmap[j - 4] = fmap[j];
                    j += 4;
                }
                fmap[j - 4] = tmp;
            }
        }
        for (int i2 = hi - 1; i2 >= lo; i2--) {
            int tmp2 = fmap[i2];
            int ec_tmp2 = eclass[tmp2];
            int j2 = i2 + 1;
            while (j2 <= hi && ec_tmp2 > eclass[fmap[j2]]) {
                fmap[j2 - 1] = fmap[j2];
                j2++;
            }
            fmap[j2 - 1] = tmp2;
        }
    }

    private void fswap(int[] fmap, int zz1, int zz2) {
        int zztmp = fmap[zz1];
        fmap[zz1] = fmap[zz2];
        fmap[zz2] = zztmp;
    }

    private void fvswap(int[] fmap, int yyp1, int yyp2, int yyn) {
        while (yyn > 0) {
            fswap(fmap, yyp1, yyp2);
            yyp1++;
            yyp2++;
            yyn--;
        }
    }

    private int fmin(int a, int b) {
        return a < b ? a : b;
    }

    private void fpush(int sp, int lz, int hz) {
        this.stack_ll[sp] = lz;
        this.stack_hh[sp] = hz;
    }

    private int[] fpop(int sp) {
        return new int[]{this.stack_ll[sp], this.stack_hh[sp]};
    }

    private void fallbackQSort3(int[] fmap, int[] eclass, int loSt, int hiSt) {
        long med;
        int gtHi;
        int sp;
        eclass = eclass;
        long r = 0;
        int sp2 = 0 + 1;
        fpush(0, loSt, hiSt);
        while (sp2 > 0) {
            int sp3 = sp2 - 1;
            int[] s = fpop(sp3);
            int lo = s[0];
            int hi = s[1];
            if (hi - lo < 10) {
                fallbackSimpleSort(fmap, eclass, lo, hi);
                sp2 = sp3;
            } else {
                long r2 = ((7621 * r) + 1) % 32768;
                long r3 = r2 % 3;
                if (r3 == 0) {
                    med = eclass[fmap[lo]];
                } else if (r3 == 1) {
                    med = eclass[fmap[(lo + hi) >>> 1]];
                } else {
                    med = eclass[fmap[hi]];
                }
                int ltLo = lo;
                int unLo = lo;
                int gtHi2 = hi;
                int unHi = hi;
                while (true) {
                    if (unLo <= unHi) {
                        int n = eclass[fmap[unLo]] - ((int) med);
                        if (n == 0) {
                            fswap(fmap, unLo, ltLo);
                            ltLo++;
                            unLo++;
                        } else if (n <= 0) {
                            unLo++;
                            eclass = eclass;
                        }
                    }
                    gtHi = gtHi2;
                    while (unLo <= unHi) {
                        int n2 = eclass[fmap[unHi]] - ((int) med);
                        if (n2 == 0) {
                            fswap(fmap, unHi, gtHi);
                            gtHi--;
                            unHi--;
                        } else if (n2 < 0) {
                            break;
                        } else {
                            unHi--;
                        }
                    }
                    if (unLo > unHi) {
                        break;
                    }
                    fswap(fmap, unLo, unHi);
                    unLo++;
                    unHi--;
                    eclass = eclass;
                    gtHi2 = gtHi;
                }
                if (gtHi >= ltLo) {
                    int n3 = fmin(ltLo - lo, unLo - ltLo);
                    fvswap(fmap, lo, unLo - n3, n3);
                    int m = fmin(hi - gtHi, gtHi - unHi);
                    fvswap(fmap, unHi + 1, (hi - m) + 1, m);
                    int n4 = ((lo + unLo) - ltLo) - 1;
                    int m2 = (hi - (gtHi - unHi)) + 1;
                    int ltLo2 = hi - m2;
                    if (n4 - lo > ltLo2) {
                        int sp4 = sp3 + 1;
                        fpush(sp3, lo, n4);
                        sp = sp4 + 1;
                        fpush(sp4, m2, hi);
                    } else {
                        int sp5 = sp3 + 1;
                        fpush(sp3, m2, hi);
                        sp = sp5 + 1;
                        fpush(sp5, lo, n4);
                    }
                    sp2 = sp;
                    eclass = eclass;
                    r = r2;
                } else {
                    eclass = eclass;
                    sp2 = sp3;
                    r = r2;
                }
            }
        }
    }

    private int[] getEclass() {
        if (this.eclass != null) {
            return this.eclass;
        }
        int[] iArr = new int[this.quadrant.length / 2];
        this.eclass = iArr;
        return iArr;
    }

    final void fallbackSort(int[] fmap, byte[] block, int nblock) {
        int nNotDone;
        int[] ftab = new int[257];
        int[] eclass = getEclass();
        for (int i = 0; i < nblock; i++) {
            eclass[i] = 0;
        }
        for (int i2 = 0; i2 < nblock; i2++) {
            int i3 = block[i2] & UByte.MAX_VALUE;
            ftab[i3] = ftab[i3] + 1;
        }
        for (int i4 = 1; i4 < 257; i4++) {
            ftab[i4] = ftab[i4] + ftab[i4 - 1];
        }
        for (int i5 = 0; i5 < nblock; i5++) {
            int j = block[i5] & 255;
            int k = ftab[j] - 1;
            ftab[j] = k;
            fmap[k] = i5;
        }
        int j2 = nblock + 64;
        BitSet bhtab = new BitSet(j2);
        for (int i6 = 0; i6 < 256; i6++) {
            bhtab.set(ftab[i6]);
        }
        for (int i7 = 0; i7 < 32; i7++) {
            bhtab.set((i7 * 2) + nblock);
            bhtab.clear((i7 * 2) + nblock + 1);
        }
        int H = 1;
        do {
            int j3 = 0;
            for (int i8 = 0; i8 < nblock; i8++) {
                if (bhtab.get(i8)) {
                    j3 = i8;
                }
                int k2 = fmap[i8] - H;
                if (k2 < 0) {
                    k2 += nblock;
                }
                eclass[k2] = j3;
            }
            nNotDone = 0;
            int r = -1;
            while (true) {
                int k3 = bhtab.nextClearBit(r + 1);
                int l = k3 - 1;
                if (l >= nblock || (r = bhtab.nextSetBit(k3 + 1) - 1) >= nblock) {
                    break;
                }
                if (r > l) {
                    nNotDone += (r - l) + 1;
                    fallbackQSort3(fmap, eclass, l, r);
                    int cc = -1;
                    for (int i9 = l; i9 <= r; i9++) {
                        int cc1 = eclass[fmap[i9]];
                        if (cc != cc1) {
                            bhtab.set(i9);
                            cc = cc1;
                        }
                    }
                }
            }
            H *= 2;
            if (H > nblock) {
                return;
            }
        } while (nNotDone != 0);
    }

    private boolean mainSimpleSort(BZip2CompressorOutputStream.Data dataShadow, int lo, int hi, int d, int lastShadow) {
        int bigN;
        int i = 1;
        int bigN2 = (hi - lo) + 1;
        if (bigN2 < 2) {
            return this.firstAttempt && this.workDone > this.workLimit;
        }
        int hp = 0;
        while (INCS[hp] < bigN2) {
            hp++;
        }
        int[] fmap = dataShadow.fmap;
        char[] quadrant = this.quadrant;
        byte[] block = dataShadow.block;
        int lastPlus1 = lastShadow + 1;
        boolean firstAttemptShadow = this.firstAttempt;
        int workLimitShadow = this.workLimit;
        int workDoneShadow = this.workDone;
        loop1: while (true) {
            hp--;
            if (hp < 0) {
                break;
            }
            int h = INCS[hp];
            int mj = (lo + h) - i;
            int i2 = lo + h;
            while (i2 <= hi) {
                int k = 3;
                while (i2 <= hi) {
                    k--;
                    if (k < 0) {
                        break;
                    }
                    int v = fmap[i2];
                    int vd = v + d;
                    int j = i2;
                    boolean onceRunned = false;
                    int a = 0;
                    while (true) {
                        if (onceRunned) {
                            fmap[j] = a;
                            int i3 = j - h;
                            j = i3;
                            if (i3 <= mj) {
                                bigN = bigN2;
                                break;
                            }
                        } else {
                            onceRunned = true;
                        }
                        a = fmap[j - h];
                        int i1 = a + d;
                        bigN = bigN2;
                        if (block[i1 + 1] == block[vd + 1]) {
                            if (block[i1 + 2] == block[vd + 2]) {
                                if (block[i1 + 3] == block[vd + 3]) {
                                    if (block[i1 + 4] == block[vd + 4]) {
                                        if (block[i1 + 5] != block[vd + 5]) {
                                            if ((block[i1 + 5] & UByte.MAX_VALUE) <= (block[vd + 5] & UByte.MAX_VALUE)) {
                                                break;
                                            }
                                            bigN2 = bigN;
                                        } else {
                                            int i4 = i1 + 6;
                                            int i5 = vd + 6;
                                            if (block[i4] == block[i5]) {
                                                int x = lastShadow;
                                                while (true) {
                                                    if (x <= 0) {
                                                        break;
                                                    }
                                                    int x2 = x - 4;
                                                    int i6 = block[i4 + 1];
                                                    int x3 = block[i5 + 1];
                                                    if (i6 == x3) {
                                                        if (quadrant[i4] == quadrant[i5]) {
                                                            if (block[i4 + 2] == block[i5 + 2]) {
                                                                if (quadrant[i4 + 1] == quadrant[i5 + 1]) {
                                                                    if (block[i4 + 3] == block[i5 + 3]) {
                                                                        if (quadrant[i4 + 2] == quadrant[i5 + 2]) {
                                                                            if (block[i4 + 4] == block[i5 + 4]) {
                                                                                if (quadrant[i4 + 3] == quadrant[i5 + 3]) {
                                                                                    i4 += 4;
                                                                                    if (i4 >= lastPlus1) {
                                                                                        i4 -= lastPlus1;
                                                                                    }
                                                                                    int i7 = i5 + 4;
                                                                                    if (i7 >= lastPlus1) {
                                                                                        i7 -= lastPlus1;
                                                                                    }
                                                                                    i5 = i7;
                                                                                    workDoneShadow++;
                                                                                    x = x2;
                                                                                } else {
                                                                                    if (quadrant[i4 + 3] <= quadrant[i5 + 3]) {
                                                                                        break;
                                                                                    }
                                                                                    break;
                                                                                }
                                                                            } else {
                                                                                if ((block[i4 + 4] & UByte.MAX_VALUE) <= (block[i5 + 4] & UByte.MAX_VALUE)) {
                                                                                    break;
                                                                                }
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            if (quadrant[i4 + 2] <= quadrant[i5 + 2]) {
                                                                                break;
                                                                            }
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        if ((block[i4 + 3] & UByte.MAX_VALUE) <= (block[i5 + 3] & UByte.MAX_VALUE)) {
                                                                            break;
                                                                        }
                                                                        break;
                                                                    }
                                                                } else {
                                                                    if (quadrant[i4 + 1] <= quadrant[i5 + 1]) {
                                                                        break;
                                                                    }
                                                                    break;
                                                                }
                                                            } else {
                                                                if ((block[i4 + 2] & UByte.MAX_VALUE) <= (block[i5 + 2] & UByte.MAX_VALUE)) {
                                                                    break;
                                                                }
                                                                break;
                                                            }
                                                        } else {
                                                            if (quadrant[i4] <= quadrant[i5]) {
                                                                break;
                                                            }
                                                            break;
                                                        }
                                                    } else {
                                                        if ((block[i4 + 1] & UByte.MAX_VALUE) <= (block[i5 + 1] & UByte.MAX_VALUE)) {
                                                            break;
                                                        }
                                                        break;
                                                    }
                                                }
                                                bigN2 = bigN;
                                            } else {
                                                if ((block[i4] & UByte.MAX_VALUE) <= (block[i5] & UByte.MAX_VALUE)) {
                                                    break;
                                                }
                                                bigN2 = bigN;
                                            }
                                        }
                                    } else {
                                        if ((block[i1 + 4] & UByte.MAX_VALUE) <= (block[vd + 4] & UByte.MAX_VALUE)) {
                                            break;
                                        }
                                        bigN2 = bigN;
                                    }
                                } else {
                                    if ((block[i1 + 3] & UByte.MAX_VALUE) <= (block[vd + 3] & UByte.MAX_VALUE)) {
                                        break;
                                    }
                                    bigN2 = bigN;
                                }
                            } else {
                                if ((block[i1 + 2] & UByte.MAX_VALUE) <= (block[vd + 2] & UByte.MAX_VALUE)) {
                                    break;
                                }
                                bigN2 = bigN;
                            }
                        } else {
                            if ((block[i1 + 1] & UByte.MAX_VALUE) <= (block[vd + 1] & UByte.MAX_VALUE)) {
                                break;
                            }
                            bigN2 = bigN;
                        }
                    }
                    fmap[j] = v;
                    i2++;
                    bigN2 = bigN;
                }
                int bigN3 = bigN2;
                if (firstAttemptShadow && i2 <= hi && workDoneShadow > workLimitShadow) {
                    break loop1;
                }
                bigN2 = bigN3;
            }
            i = 1;
        }
        this.workDone = workDoneShadow;
        return firstAttemptShadow && workDoneShadow > workLimitShadow;
    }

    private static void vswap(int[] fmap, int p2, int p3, int n) {
        int n2 = n + p2;
        while (p2 < n2) {
            int t = fmap[p2];
            int p1 = p2 + 1;
            fmap[p2] = fmap[p3];
            fmap[p3] = t;
            p3++;
            p2 = p1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0011, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0005, code lost:
    
        if (r1 < r3) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000c, code lost:
    
        if (r1 > r3) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte med3(byte r1, byte r2, byte r3) {
        /*
            if (r1 >= r2) goto L8
            if (r2 >= r3) goto L5
            goto La
        L5:
            if (r1 >= r3) goto L10
            goto Le
        L8:
            if (r2 <= r3) goto Lc
        La:
            r0 = r2
            goto L11
        Lc:
            if (r1 <= r3) goto L10
        Le:
            r0 = r3
            goto L11
        L10:
            r0 = r1
        L11:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.bzip2.BlockSort.med3(byte, byte, byte):byte");
    }

    private void mainQSort3(BZip2CompressorOutputStream.Data dataShadow, int loSt, int hiSt, int dSt, int last) {
        int unHi;
        int gtHi;
        int gtHi2;
        int[] stack_ll = this.stack_ll;
        int[] stack_hh = this.stack_hh;
        int[] stack_dd = this.stack_dd;
        int[] fmap = dataShadow.fmap;
        byte[] block = dataShadow.block;
        stack_ll[0] = loSt;
        stack_hh[0] = hiSt;
        stack_dd[0] = dSt;
        int sp = 1;
        while (true) {
            int sp2 = sp - 1;
            if (sp2 >= 0) {
                int lo = stack_ll[sp2];
                int hi = stack_hh[sp2];
                int d = stack_dd[sp2];
                if (hi - lo < 20 || d > 10) {
                    if (mainSimpleSort(dataShadow, lo, hi, d, last)) {
                        return;
                    }
                } else {
                    int d1 = d + 1;
                    int med = med3(block[fmap[lo] + d1], block[fmap[hi] + d1], block[fmap[(lo + hi) >>> 1] + d1]) & UByte.MAX_VALUE;
                    int unLo = lo;
                    int n = hi;
                    int ltLo = lo;
                    int unLo2 = hi;
                    while (true) {
                        if (unLo > n) {
                            unHi = n;
                        } else {
                            unHi = n;
                            int unHi2 = block[fmap[unLo] + d1];
                            int n2 = (unHi2 & 255) - med;
                            if (n2 == 0) {
                                int temp = fmap[unLo];
                                fmap[unLo] = fmap[ltLo];
                                fmap[ltLo] = temp;
                                ltLo++;
                                unLo++;
                            } else if (n2 < 0) {
                                unLo++;
                            }
                            n = unHi;
                        }
                        gtHi = unLo2;
                        gtHi2 = unHi;
                        while (unLo <= gtHi2) {
                            int n3 = (block[fmap[gtHi2] + d1] & UByte.MAX_VALUE) - med;
                            if (n3 != 0) {
                                if (n3 <= 0) {
                                    break;
                                } else {
                                    gtHi2--;
                                }
                            } else {
                                int temp2 = fmap[gtHi2];
                                int unHi3 = gtHi2 - 1;
                                fmap[gtHi2] = fmap[gtHi];
                                fmap[gtHi] = temp2;
                                gtHi--;
                                gtHi2 = unHi3;
                            }
                        }
                        if (unLo > gtHi2) {
                            break;
                        }
                        int temp3 = fmap[unLo];
                        int unLo3 = unLo + 1;
                        fmap[unLo] = fmap[gtHi2];
                        int unHi4 = gtHi2 - 1;
                        fmap[gtHi2] = temp3;
                        n = unHi4;
                        unLo = unLo3;
                        unLo2 = gtHi;
                    }
                    if (gtHi < ltLo) {
                        stack_ll[sp2] = lo;
                        stack_hh[sp2] = hi;
                        stack_dd[sp2] = d1;
                        sp2++;
                    } else {
                        int n4 = ltLo - lo < unLo - ltLo ? ltLo - lo : unLo - ltLo;
                        vswap(fmap, lo, unLo - n4, n4);
                        int n5 = gtHi - gtHi2;
                        int m = hi - gtHi < n5 ? hi - gtHi : gtHi - gtHi2;
                        vswap(fmap, unLo, (hi - m) + 1, m);
                        int n6 = ((lo + unLo) - ltLo) - 1;
                        int n7 = gtHi - gtHi2;
                        int m2 = (hi - n7) + 1;
                        stack_ll[sp2] = lo;
                        stack_hh[sp2] = n6;
                        stack_dd[sp2] = d;
                        int sp3 = sp2 + 1;
                        stack_ll[sp3] = n6 + 1;
                        stack_hh[sp3] = m2 - 1;
                        stack_dd[sp3] = d1;
                        int sp4 = sp3 + 1;
                        stack_ll[sp4] = m2;
                        stack_hh[sp4] = hi;
                        stack_dd[sp4] = d;
                        sp2 = sp4 + 1;
                    }
                }
                sp = sp2;
            } else {
                return;
            }
        }
    }

    final void mainSort(BZip2CompressorOutputStream.Data dataShadow, int lastShadow) {
        int i;
        int j;
        int i2;
        int[] runningOrder;
        int workLimitShadow;
        int i3;
        int c1;
        int[] runningOrder2 = this.mainSort_runningOrder;
        int[] copy = this.mainSort_copy;
        boolean[] bigDone = this.mainSort_bigDone;
        int[] ftab = this.ftab;
        byte[] block = dataShadow.block;
        int[] fmap = dataShadow.fmap;
        char[] quadrant = this.quadrant;
        int workLimitShadow2 = this.workLimit;
        boolean firstAttemptShadow = this.firstAttempt;
        int i4 = 65537;
        while (true) {
            i4--;
            if (i4 < 0) {
                break;
            } else {
                ftab[i4] = 0;
            }
        }
        int i5 = 0;
        while (true) {
            i = 1;
            if (i5 >= 20) {
                break;
            }
            block[lastShadow + i5 + 2] = block[(i5 % (lastShadow + 1)) + 1];
            i5++;
        }
        int i6 = lastShadow + 20;
        int i7 = i6 + 1;
        while (true) {
            i7--;
            if (i7 < 0) {
                break;
            } else {
                quadrant[i7] = 0;
            }
        }
        int i8 = lastShadow + 1;
        block[0] = block[i8];
        int i9 = 255;
        int c2 = block[0] & UByte.MAX_VALUE;
        for (int i10 = 0; i10 <= lastShadow; i10++) {
            int c3 = block[i10 + 1] & UByte.MAX_VALUE;
            int i11 = (c2 << 8) + c3;
            ftab[i11] = ftab[i11] + 1;
            c2 = c3;
        }
        for (int i12 = 1; i12 <= 65536; i12++) {
            ftab[i12] = ftab[i12] + ftab[i12 - 1];
        }
        int i13 = block[1];
        int c4 = i13 & 255;
        for (int i14 = 0; i14 < lastShadow; i14++) {
            int c5 = block[i14 + 2] & UByte.MAX_VALUE;
            int i15 = (c4 << 8) + c5;
            int i16 = ftab[i15] - 1;
            ftab[i15] = i16;
            fmap[i16] = i14;
            c4 = c5;
        }
        int i17 = lastShadow + 1;
        int i18 = ((block[i17] & UByte.MAX_VALUE) << 8) + (block[1] & UByte.MAX_VALUE);
        int i19 = ftab[i18] - 1;
        ftab[i18] = i19;
        fmap[i19] = lastShadow;
        int i20 = 256;
        while (true) {
            i20--;
            if (i20 < 0) {
                break;
            }
            bigDone[i20] = false;
            runningOrder2[i20] = i20;
        }
        int h = 364;
        while (h != i) {
            h /= 3;
            int i21 = h;
            while (i21 <= i9) {
                int vv = runningOrder2[i21];
                int a = ftab[(vv + 1) << 8] - ftab[vv << 8];
                int b = h - 1;
                int j2 = i21;
                int ro = runningOrder2[j2 - h];
                while (true) {
                    c1 = c4;
                    int c6 = ftab[(ro + 1) << 8] - ftab[ro << 8];
                    if (c6 <= a) {
                        break;
                    }
                    runningOrder2[j2] = ro;
                    int j3 = j2 - h;
                    if (j3 > b) {
                        ro = runningOrder2[j3 - h];
                        j2 = j3;
                        c4 = c1;
                    } else {
                        j2 = j3;
                        break;
                    }
                }
                runningOrder2[j2] = vv;
                i21++;
                c4 = c1;
                i9 = 255;
            }
            i = 1;
            i9 = 255;
        }
        int i22 = 0;
        while (true) {
            if (i22 <= 255) {
                int ss = runningOrder2[i22];
                int j4 = 0;
                for (int i23 = 255; j4 <= i23; i23 = 255) {
                    int sb = (ss << 8) + j4;
                    int ftab_sb = ftab[sb];
                    if ((ftab_sb & 2097152) == 2097152) {
                        j = j4;
                        i2 = i22;
                        runningOrder = runningOrder2;
                        workLimitShadow = workLimitShadow2;
                    } else {
                        int lo = ftab_sb & CLEARMASK;
                        int hi = (ftab[sb + 1] & CLEARMASK) - 1;
                        if (hi > lo) {
                            i3 = 2097152;
                            j = j4;
                            i2 = i22;
                            runningOrder = runningOrder2;
                            workLimitShadow = workLimitShadow2;
                            mainQSort3(dataShadow, lo, hi, 2, lastShadow);
                            if (firstAttemptShadow && this.workDone > workLimitShadow) {
                                return;
                            }
                        } else {
                            j = j4;
                            i2 = i22;
                            runningOrder = runningOrder2;
                            i3 = 2097152;
                            workLimitShadow = workLimitShadow2;
                        }
                        ftab[sb] = ftab_sb | i3;
                    }
                    j4 = j + 1;
                    i22 = i2;
                    workLimitShadow2 = workLimitShadow;
                    runningOrder2 = runningOrder;
                }
                int i24 = i22;
                int[] runningOrder3 = runningOrder2;
                int workLimitShadow3 = workLimitShadow2;
                for (int j5 = 0; j5 <= 255; j5++) {
                    copy[j5] = ftab[(j5 << 8) + ss] & CLEARMASK;
                }
                int j6 = ss << 8;
                int hj = ftab[(ss + 1) << 8] & CLEARMASK;
                for (int j7 = ftab[j6] & CLEARMASK; j7 < hj; j7++) {
                    int fmap_j = fmap[j7];
                    int c7 = block[fmap_j] & 255;
                    if (!bigDone[c7]) {
                        fmap[copy[c7]] = fmap_j == 0 ? lastShadow : fmap_j - 1;
                        copy[c7] = copy[c7] + 1;
                    }
                }
                int j8 = 256;
                while (true) {
                    j8--;
                    if (j8 < 0) {
                        break;
                    }
                    int i25 = (j8 << 8) + ss;
                    ftab[i25] = ftab[i25] | 2097152;
                }
                bigDone[ss] = true;
                if (i24 < 255) {
                    int bbStart = ftab[ss << 8] & CLEARMASK;
                    int bbSize = (CLEARMASK & ftab[(ss + 1) << 8]) - bbStart;
                    int shifts = 0;
                    while ((bbSize >> shifts) > 65534) {
                        shifts++;
                    }
                    int j9 = 0;
                    while (j9 < bbSize) {
                        int a2update = fmap[bbStart + j9];
                        char qVal = (char) (j9 >> shifts);
                        quadrant[a2update] = qVal;
                        int bbSize2 = bbSize;
                        if (a2update < 20) {
                            quadrant[a2update + lastShadow + 1] = qVal;
                        }
                        j9++;
                        bbSize = bbSize2;
                    }
                }
                i22 = i24 + 1;
                workLimitShadow2 = workLimitShadow3;
                runningOrder2 = runningOrder3;
            } else {
                return;
            }
        }
    }
}
