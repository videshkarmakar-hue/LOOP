package org.apache.commons.compress.compressors.bzip2;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import kotlin.UByte;
import org.apache.commons.compress.compressors.CompressorInputStream;

/* JADX INFO: loaded from: classes18.dex */
public class BZip2CompressorInputStream extends CompressorInputStream implements BZip2Constants {
    private static final int EOF = 0;
    private static final int NO_RAND_PART_A_STATE = 5;
    private static final int NO_RAND_PART_B_STATE = 6;
    private static final int NO_RAND_PART_C_STATE = 7;
    private static final int RAND_PART_A_STATE = 2;
    private static final int RAND_PART_B_STATE = 3;
    private static final int RAND_PART_C_STATE = 4;
    private static final int START_BLOCK_STATE = 1;
    private boolean blockRandomised;
    private int blockSize100k;
    private int bsBuff;
    private int bsLive;
    private int computedBlockCRC;
    private int computedCombinedCRC;
    private final CRC crc;
    private int currentState;
    private Data data;
    private final boolean decompressConcatenated;

    /* JADX INFO: renamed from: in */
    private InputStream f582in;
    private int last;
    private int nInUse;
    private int origPtr;
    private int storedBlockCRC;
    private int storedCombinedCRC;
    private int su_ch2;
    private int su_chPrev;
    private int su_count;
    private int su_i2;
    private int su_j2;
    private int su_rNToGo;
    private int su_rTPos;
    private int su_tPos;
    private char su_z;

    public BZip2CompressorInputStream(InputStream in) throws IOException {
        this(in, false);
    }

    public BZip2CompressorInputStream(InputStream in, boolean decompressConcatenated) throws IOException {
        this.crc = new CRC();
        this.currentState = 1;
        this.f582in = in;
        this.decompressConcatenated = decompressConcatenated;
        init(true);
        initBlock();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f582in != null) {
            int r = read0();
            count(r < 0 ? -1 : 1);
            return r;
        }
        throw new IOException("stream closed");
    }

    @Override // java.io.InputStream
    public int read(byte[] dest, int offs, int len) throws IOException {
        if (offs < 0) {
            throw new IndexOutOfBoundsException("offs(" + offs + ") < 0.");
        }
        if (len < 0) {
            throw new IndexOutOfBoundsException("len(" + len + ") < 0.");
        }
        if (offs + len > dest.length) {
            throw new IndexOutOfBoundsException("offs(" + offs + ") + len(" + len + ") > dest.length(" + dest.length + ").");
        }
        if (this.f582in == null) {
            throw new IOException("stream closed");
        }
        if (len == 0) {
            return 0;
        }
        int hi = offs + len;
        int destOffs = offs;
        while (destOffs < hi) {
            int b = read0();
            if (b < 0) {
                break;
            }
            dest[destOffs] = (byte) b;
            count(1);
            destOffs++;
        }
        if (destOffs == offs) {
            return -1;
        }
        int c = destOffs - offs;
        return c;
    }

    private void makeMaps() {
        boolean[] inUse = this.data.inUse;
        byte[] seqToUnseq = this.data.seqToUnseq;
        int nInUseShadow = 0;
        for (int i = 0; i < 256; i++) {
            if (inUse[i]) {
                seqToUnseq[nInUseShadow] = (byte) i;
                nInUseShadow++;
            }
        }
        this.nInUse = nInUseShadow;
    }

    private int read0() throws IOException {
        switch (this.currentState) {
            case 0:
                return -1;
            case 1:
                return setupBlock();
            case 2:
                throw new IllegalStateException();
            case 3:
                return setupRandPartB();
            case 4:
                return setupRandPartC();
            case 5:
                throw new IllegalStateException();
            case 6:
                return setupNoRandPartB();
            case 7:
                return setupNoRandPartC();
            default:
                throw new IllegalStateException();
        }
    }

    private boolean init(boolean isFirstStream) throws IOException {
        if (this.f582in == null) {
            throw new IOException("No InputStream");
        }
        int magic0 = this.f582in.read();
        if (magic0 == -1 && !isFirstStream) {
            return false;
        }
        int magic1 = this.f582in.read();
        int magic2 = this.f582in.read();
        if (magic0 != 66 || magic1 != 90 || magic2 != 104) {
            throw new IOException(isFirstStream ? "Stream is not in the BZip2 format" : "Garbage after a valid BZip2 stream");
        }
        int blockSize = this.f582in.read();
        if (blockSize < 49 || blockSize > 57) {
            throw new IOException("BZip2 block size is invalid");
        }
        this.blockSize100k = blockSize - 48;
        this.bsLive = 0;
        this.computedCombinedCRC = 0;
        return true;
    }

    private void initBlock() throws IOException {
        do {
            char magic0 = bsGetUByte();
            char magic1 = bsGetUByte();
            char magic2 = bsGetUByte();
            char magic3 = bsGetUByte();
            char magic4 = bsGetUByte();
            char magic5 = bsGetUByte();
            if (magic0 != 23 || magic1 != 'r' || magic2 != 'E' || magic3 != '8' || magic4 != 'P' || magic5 != 144) {
                if (magic0 != '1' || magic1 != 'A' || magic2 != 'Y' || magic3 != '&' || magic4 != 'S' || magic5 != 'Y') {
                    this.currentState = 0;
                    throw new IOException("bad block header");
                }
                this.storedBlockCRC = bsGetInt();
                this.blockRandomised = bsR(1) == 1;
                if (this.data == null) {
                    this.data = new Data(this.blockSize100k);
                }
                getAndMoveToFrontDecode();
                this.crc.initialiseCRC();
                this.currentState = 1;
                return;
            }
        } while (!complete());
    }

    private void endBlock() throws IOException {
        this.computedBlockCRC = this.crc.getFinalCRC();
        if (this.storedBlockCRC != this.computedBlockCRC) {
            this.computedCombinedCRC = (this.storedCombinedCRC << 1) | (this.storedCombinedCRC >>> 31);
            this.computedCombinedCRC ^= this.storedBlockCRC;
            throw new IOException("BZip2 CRC error");
        }
        this.computedCombinedCRC = (this.computedCombinedCRC << 1) | (this.computedCombinedCRC >>> 31);
        this.computedCombinedCRC ^= this.computedBlockCRC;
    }

    private boolean complete() throws IOException {
        this.storedCombinedCRC = bsGetInt();
        this.currentState = 0;
        this.data = null;
        if (this.storedCombinedCRC == this.computedCombinedCRC) {
            return (this.decompressConcatenated && init(false)) ? false : true;
        }
        throw new IOException("BZip2 CRC error");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f582in;
        if (inputStream != null) {
            try {
                if (inputStream != System.in) {
                    inputStream.close();
                }
            } finally {
                this.data = null;
                this.f582in = null;
            }
        }
    }

    private int bsR(int n) throws IOException {
        int bsLiveShadow = this.bsLive;
        int bsBuffShadow = this.bsBuff;
        if (bsLiveShadow < n) {
            InputStream inShadow = this.f582in;
            do {
                int thech = inShadow.read();
                if (thech < 0) {
                    throw new IOException("unexpected end of stream");
                }
                bsBuffShadow = (bsBuffShadow << 8) | thech;
                bsLiveShadow += 8;
            } while (bsLiveShadow < n);
            this.bsBuff = bsBuffShadow;
        }
        this.bsLive = bsLiveShadow - n;
        return (bsBuffShadow >> (bsLiveShadow - n)) & ((1 << n) - 1);
    }

    private boolean bsGetBit() throws IOException {
        return bsR(1) != 0;
    }

    private char bsGetUByte() throws IOException {
        return (char) bsR(8);
    }

    private int bsGetInt() throws IOException {
        return bsR(8) | (((((bsR(8) << 8) | bsR(8)) << 8) | bsR(8)) << 8);
    }

    private static void hbCreateDecodeTables(int[] limit, int[] base, int[] perm, char[] length, int minLen, int maxLen, int alphaSize) {
        int pp = 0;
        for (int i = minLen; i <= maxLen; i++) {
            for (int j = 0; j < alphaSize; j++) {
                if (length[j] == i) {
                    perm[pp] = j;
                    pp++;
                }
            }
        }
        int i2 = 23;
        while (true) {
            i2--;
            if (i2 <= 0) {
                break;
            }
            base[i2] = 0;
            limit[i2] = 0;
        }
        for (int i3 = 0; i3 < alphaSize; i3++) {
            int i4 = length[i3] + 1;
            base[i4] = base[i4] + 1;
        }
        int b = base[0];
        for (int i5 = 1; i5 < 23; i5++) {
            b += base[i5];
            base[i5] = b;
        }
        int i6 = minLen;
        int vec = 0;
        int b2 = base[i6];
        while (i6 <= maxLen) {
            int nb = base[i6 + 1];
            int vec2 = vec + (nb - b2);
            b2 = nb;
            limit[i6] = vec2 - 1;
            vec = vec2 << 1;
            i6++;
        }
        for (int i7 = minLen + 1; i7 <= maxLen; i7++) {
            base[i7] = ((limit[i7 - 1] + 1) << 1) - base[i7];
        }
    }

    private void recvDecodingTables() throws IOException {
        Data dataShadow = this.data;
        boolean[] inUse = dataShadow.inUse;
        byte[] pos = dataShadow.recvDecodingTables_pos;
        byte[] selector = dataShadow.selector;
        byte[] selectorMtf = dataShadow.selectorMtf;
        int inUse16 = 0;
        for (int i = 0; i < 16; i++) {
            if (bsGetBit()) {
                inUse16 |= 1 << i;
            }
        }
        int i2 = 256;
        while (true) {
            i2--;
            if (i2 < 0) {
                break;
            } else {
                inUse[i2] = false;
            }
        }
        for (int i3 = 0; i3 < 16; i3++) {
            if (((1 << i3) & inUse16) != 0) {
                int i16 = i3 << 4;
                for (int j = 0; j < 16; j++) {
                    if (bsGetBit()) {
                        inUse[i16 + j] = true;
                    }
                }
            }
        }
        makeMaps();
        int alphaSize = this.nInUse + 2;
        int nGroups = bsR(3);
        int nSelectors = bsR(15);
        for (int i4 = 0; i4 < nSelectors; i4++) {
            int j2 = 0;
            while (bsGetBit()) {
                j2++;
            }
            selectorMtf[i4] = (byte) j2;
        }
        int v = nGroups;
        while (true) {
            v--;
            if (v < 0) {
                break;
            } else {
                pos[v] = (byte) v;
            }
        }
        for (int i5 = 0; i5 < nSelectors; i5++) {
            int v2 = selectorMtf[i5] & UByte.MAX_VALUE;
            byte tmp = pos[v2];
            while (v2 > 0) {
                pos[v2] = pos[v2 - 1];
                v2--;
            }
            pos[0] = tmp;
            selector[i5] = tmp;
        }
        char[][] len = dataShadow.temp_charArray2d;
        for (int t = 0; t < nGroups; t++) {
            int curr = bsR(5);
            char[] len_t = len[t];
            for (int i6 = 0; i6 < alphaSize; i6++) {
                while (bsGetBit()) {
                    curr += bsGetBit() ? -1 : 1;
                }
                len_t[i6] = (char) curr;
            }
        }
        createHuffmanDecodingTables(alphaSize, nGroups);
    }

    private void createHuffmanDecodingTables(int alphaSize, int nGroups) {
        Data dataShadow = this.data;
        char[][] len = dataShadow.temp_charArray2d;
        int[] minLens = dataShadow.minLens;
        int[][] limit = dataShadow.limit;
        int[][] base = dataShadow.base;
        int[][] perm = dataShadow.perm;
        for (int t = 0; t < nGroups; t++) {
            int minLen = 32;
            int maxLen = 0;
            char[] len_t = len[t];
            int i = alphaSize;
            while (true) {
                i--;
                if (i >= 0) {
                    char lent = len_t[i];
                    if (lent > maxLen) {
                        maxLen = lent;
                    }
                    if (lent < minLen) {
                        minLen = lent;
                    }
                }
            }
            hbCreateDecodeTables(limit[t], base[t], perm[t], len[t], minLen, maxLen, alphaSize);
            minLens[t] = minLen;
        }
    }

    private void getAndMoveToFrontDecode() throws IOException {
        int lastShadow;
        int s;
        byte[] selector;
        int zn;
        int lastShadow2;
        this.origPtr = bsR(24);
        recvDecodingTables();
        InputStream inShadow = this.f582in;
        Data dataShadow = this.data;
        byte[] ll8 = dataShadow.ll8;
        int[] unzftab = dataShadow.unzftab;
        byte[] selector2 = dataShadow.selector;
        byte[] seqToUnseq = dataShadow.seqToUnseq;
        char[] yy = dataShadow.getAndMoveToFrontDecode_yy;
        int[] minLens = dataShadow.minLens;
        int[][] limit = dataShadow.limit;
        int[][] base = dataShadow.base;
        int[][] perm = dataShadow.perm;
        int limitLast = this.blockSize100k * 100000;
        int i = 256;
        while (true) {
            i--;
            if (i < 0) {
                break;
            }
            yy[i] = (char) i;
            unzftab[i] = 0;
        }
        int eob = this.nInUse + 1;
        int nextSym = getAndMoveToFrontDecode0(0);
        int bsBuffShadow = this.bsBuff;
        int bsBuffShadow2 = this.bsLive;
        int bsLiveShadow = selector2[0];
        int zt = bsLiveShadow & 255;
        int[] base_zt = base[zt];
        int[] limit_zt = limit[zt];
        int[] perm_zt = perm[zt];
        int minLens_zt = minLens[zt];
        int lastShadow3 = zt;
        int zt2 = bsBuffShadow2;
        int bsBuffShadow3 = bsBuffShadow;
        int bsBuffShadow4 = 49;
        int groupPos = nextSym;
        int groupNo = 0;
        int groupNo2 = -1;
        while (groupPos != eob) {
            eob = eob;
            int bsLiveShadow2 = zt2;
            if (groupPos == 0 || groupPos == 1) {
                int s2 = -1;
                int minLens_zt2 = minLens_zt;
                int[] perm_zt2 = perm_zt;
                int[] limit_zt2 = limit_zt;
                int[] base_zt2 = base_zt;
                int bsBuffShadow5 = bsBuffShadow3;
                int zt3 = lastShadow3;
                int groupPos2 = bsBuffShadow4;
                int groupNo3 = groupNo;
                int groupNo4 = 1;
                groupPos = groupPos;
                while (true) {
                    if (groupPos == 0) {
                        s = s2 + groupNo4;
                        lastShadow = groupNo2;
                    } else {
                        lastShadow = groupNo2;
                        if (groupPos != 1) {
                            byte[] selector3 = selector2;
                            byte ch = seqToUnseq[yy[0]];
                            int i2 = ch & UByte.MAX_VALUE;
                            unzftab[i2] = unzftab[i2] + s2 + 1;
                            groupNo2 = lastShadow;
                            while (true) {
                                int s3 = s2 - 1;
                                if (s2 < 0) {
                                    break;
                                }
                                groupNo2++;
                                ll8[groupNo2] = ch;
                                s2 = s3;
                            }
                            if (groupNo2 >= limitLast) {
                                throw new IOException("block overrun");
                            }
                            groupNo = groupNo3;
                            bsBuffShadow4 = groupPos2;
                            lastShadow3 = zt3;
                            bsBuffShadow3 = bsBuffShadow5;
                            base_zt = base_zt2;
                            limit_zt = limit_zt2;
                            perm_zt = perm_zt2;
                            zt2 = bsLiveShadow2;
                            minLens_zt = minLens_zt2;
                            selector2 = selector3;
                            break;
                        }
                        s = s2 + (groupNo4 << 1);
                    }
                    if (groupPos2 == 0) {
                        groupNo3++;
                        int s4 = selector2[groupNo3];
                        int zt4 = s4 & 255;
                        base_zt2 = base[zt4];
                        limit_zt2 = limit[zt4];
                        perm_zt2 = perm[zt4];
                        minLens_zt2 = minLens[zt4];
                        zt3 = zt4;
                        groupPos2 = 49;
                    } else {
                        groupPos2--;
                    }
                    int zn2 = minLens_zt2;
                    int bsLiveShadow3 = bsLiveShadow2;
                    while (bsLiveShadow3 < zn2) {
                        int thech = inShadow.read();
                        if (thech >= 0) {
                            bsBuffShadow5 = (bsBuffShadow5 << 8) | thech;
                            bsLiveShadow3 += 8;
                        } else {
                            throw new IOException("unexpected end of stream");
                        }
                    }
                    int thech2 = bsLiveShadow3 - zn2;
                    int zvec = (bsBuffShadow5 >> thech2) & ((1 << zn2) - 1);
                    bsLiveShadow2 = bsLiveShadow3 - zn2;
                    int zvec2 = zvec;
                    while (true) {
                        selector = selector2;
                        if (zvec2 > limit_zt2[zn2]) {
                            int thech3 = zn2 + 1;
                            int bsLiveShadow4 = bsLiveShadow2;
                            while (true) {
                                zn = thech3;
                                if (bsLiveShadow4 < 1) {
                                    int thech4 = inShadow.read();
                                    if (thech4 >= 0) {
                                        bsBuffShadow5 = (bsBuffShadow5 << 8) | thech4;
                                        bsLiveShadow4 += 8;
                                        thech3 = zn;
                                    } else {
                                        throw new IOException("unexpected end of stream");
                                    }
                                }
                            }
                            bsLiveShadow2 = bsLiveShadow4 - 1;
                            zvec2 = (zvec2 << 1) | ((bsBuffShadow5 >> bsLiveShadow2) & 1);
                            selector2 = selector;
                            zn2 = zn;
                        }
                    }
                    groupPos = perm_zt2[zvec2 - base_zt2[zn2]];
                    groupNo4 <<= 1;
                    s2 = s;
                    groupNo2 = lastShadow;
                    selector2 = selector;
                }
            } else {
                int lastShadow4 = groupNo2 + 1;
                if (lastShadow4 >= limitLast) {
                    throw new IOException("block overrun");
                }
                char tmp = yy[groupPos - 1];
                int i3 = seqToUnseq[tmp] & UByte.MAX_VALUE;
                unzftab[i3] = unzftab[i3] + 1;
                ll8[lastShadow4] = seqToUnseq[tmp];
                if (groupPos <= 16) {
                    int j = groupPos - 1;
                    while (j > 0) {
                        int j2 = j - 1;
                        yy[j] = yy[j2];
                        j = j2;
                    }
                    lastShadow2 = 0;
                } else {
                    lastShadow2 = 0;
                    System.arraycopy(yy, 0, yy, 1, groupPos - 1);
                }
                yy[lastShadow2] = tmp;
                if (bsBuffShadow4 == 0) {
                    groupNo++;
                    int zt5 = selector2[groupNo] & 255;
                    int[] base_zt3 = base[zt5];
                    int[] limit_zt3 = limit[zt5];
                    int[] perm_zt3 = perm[zt5];
                    limit_zt = limit_zt3;
                    perm_zt = perm_zt3;
                    minLens_zt = minLens[zt5];
                    bsBuffShadow4 = 49;
                    lastShadow3 = zt5;
                    base_zt = base_zt3;
                } else {
                    bsBuffShadow4--;
                }
                int zn3 = minLens_zt;
                int bsLiveShadow5 = bsLiveShadow2;
                while (bsLiveShadow5 < zn3) {
                    int thech5 = inShadow.read();
                    if (thech5 < 0) {
                        throw new IOException("unexpected end of stream");
                    }
                    bsBuffShadow3 = (bsBuffShadow3 << 8) | thech5;
                    bsLiveShadow5 += 8;
                }
                int zvec3 = (bsBuffShadow3 >> (bsLiveShadow5 - zn3)) & ((1 << zn3) - 1);
                int bsLiveShadow6 = bsLiveShadow5 - zn3;
                while (zvec3 > limit_zt[zn3]) {
                    int zn4 = zn3 + 1;
                    while (bsLiveShadow6 < 1) {
                        int thech6 = inShadow.read();
                        if (thech6 < 0) {
                            throw new IOException("unexpected end of stream");
                        }
                        bsBuffShadow3 = (bsBuffShadow3 << 8) | thech6;
                        bsLiveShadow6 += 8;
                    }
                    bsLiveShadow6--;
                    zvec3 = (zvec3 << 1) | ((bsBuffShadow3 >> bsLiveShadow6) & 1);
                    zn3 = zn4;
                }
                groupPos = perm_zt[zvec3 - base_zt[zn3]];
                zt2 = bsLiveShadow6;
                groupNo2 = lastShadow4;
            }
        }
        int bsLiveShadow7 = zt2;
        this.last = groupNo2;
        this.bsLive = bsLiveShadow7;
        this.bsBuff = bsBuffShadow3;
    }

    private int getAndMoveToFrontDecode0(int groupNo) throws IOException {
        InputStream inShadow = this.f582in;
        Data dataShadow = this.data;
        int zt = dataShadow.selector[groupNo] & 255;
        int[] limit_zt = dataShadow.limit[zt];
        int zn = dataShadow.minLens[zt];
        int zvec = bsR(zn);
        int bsLiveShadow = this.bsLive;
        int bsBuffShadow = this.bsBuff;
        while (zvec > limit_zt[zn]) {
            zn++;
            while (bsLiveShadow < 1) {
                int thech = inShadow.read();
                if (thech >= 0) {
                    bsBuffShadow = (bsBuffShadow << 8) | thech;
                    bsLiveShadow += 8;
                } else {
                    throw new IOException("unexpected end of stream");
                }
            }
            bsLiveShadow--;
            zvec = (zvec << 1) | (1 & (bsBuffShadow >> bsLiveShadow));
        }
        this.bsLive = bsLiveShadow;
        this.bsBuff = bsBuffShadow;
        return dataShadow.perm[zt][zvec - dataShadow.base[zt][zn]];
    }

    private int setupBlock() throws IOException {
        if (this.currentState == 0 || this.data == null) {
            return -1;
        }
        int[] cftab = this.data.cftab;
        int[] tt = this.data.initTT(this.last + 1);
        byte[] ll8 = this.data.ll8;
        cftab[0] = 0;
        System.arraycopy(this.data.unzftab, 0, cftab, 1, 256);
        int c = cftab[0];
        for (int i = 1; i <= 256; i++) {
            c += cftab[i];
            cftab[i] = c;
        }
        int lastShadow = this.last;
        for (int i2 = 0; i2 <= lastShadow; i2++) {
            int i3 = ll8[i2] & UByte.MAX_VALUE;
            int i4 = cftab[i3];
            cftab[i3] = i4 + 1;
            tt[i4] = i2;
        }
        int i5 = this.origPtr;
        if (i5 < 0 || this.origPtr >= tt.length) {
            throw new IOException("stream corrupted");
        }
        this.su_tPos = tt[this.origPtr];
        this.su_count = 0;
        this.su_i2 = 0;
        this.su_ch2 = 256;
        if (this.blockRandomised) {
            this.su_rNToGo = 0;
            this.su_rTPos = 0;
            return setupRandPartA();
        }
        return setupNoRandPartA();
    }

    private int setupRandPartA() throws IOException {
        if (this.su_i2 <= this.last) {
            this.su_chPrev = this.su_ch2;
            int su_ch2Shadow = this.data.ll8[this.su_tPos] & UByte.MAX_VALUE;
            this.su_tPos = this.data.f583tt[this.su_tPos];
            if (this.su_rNToGo == 0) {
                this.su_rNToGo = Rand.rNums(this.su_rTPos) - 1;
                int i = this.su_rTPos + 1;
                this.su_rTPos = i;
                if (i == 512) {
                    this.su_rTPos = 0;
                }
            } else {
                this.su_rNToGo--;
            }
            int su_ch2Shadow2 = su_ch2Shadow ^ (this.su_rNToGo == 1 ? 1 : 0);
            this.su_ch2 = su_ch2Shadow2;
            this.su_i2++;
            this.currentState = 3;
            this.crc.updateCRC(su_ch2Shadow2);
            return su_ch2Shadow2;
        }
        endBlock();
        initBlock();
        return setupBlock();
    }

    private int setupNoRandPartA() throws IOException {
        if (this.su_i2 <= this.last) {
            this.su_chPrev = this.su_ch2;
            int su_ch2Shadow = this.data.ll8[this.su_tPos] & UByte.MAX_VALUE;
            this.su_ch2 = su_ch2Shadow;
            this.su_tPos = this.data.f583tt[this.su_tPos];
            this.su_i2++;
            this.currentState = 6;
            this.crc.updateCRC(su_ch2Shadow);
            return su_ch2Shadow;
        }
        this.currentState = 5;
        endBlock();
        initBlock();
        return setupBlock();
    }

    private int setupRandPartB() throws IOException {
        if (this.su_ch2 != this.su_chPrev) {
            this.currentState = 2;
            this.su_count = 1;
            return setupRandPartA();
        }
        int i = this.su_count + 1;
        this.su_count = i;
        if (i >= 4) {
            this.su_z = (char) (this.data.ll8[this.su_tPos] & UByte.MAX_VALUE);
            this.su_tPos = this.data.f583tt[this.su_tPos];
            if (this.su_rNToGo == 0) {
                this.su_rNToGo = Rand.rNums(this.su_rTPos) - 1;
                int i2 = this.su_rTPos + 1;
                this.su_rTPos = i2;
                if (i2 == 512) {
                    this.su_rTPos = 0;
                }
            } else {
                this.su_rNToGo--;
            }
            this.su_j2 = 0;
            this.currentState = 4;
            if (this.su_rNToGo == 1) {
                this.su_z = (char) (this.su_z ^ 1);
            }
            return setupRandPartC();
        }
        this.currentState = 2;
        return setupRandPartA();
    }

    private int setupRandPartC() throws IOException {
        if (this.su_j2 < this.su_z) {
            this.crc.updateCRC(this.su_ch2);
            this.su_j2++;
            return this.su_ch2;
        }
        this.currentState = 2;
        this.su_i2++;
        this.su_count = 0;
        return setupRandPartA();
    }

    private int setupNoRandPartB() throws IOException {
        if (this.su_ch2 != this.su_chPrev) {
            this.su_count = 1;
            return setupNoRandPartA();
        }
        int i = this.su_count + 1;
        this.su_count = i;
        if (i >= 4) {
            this.su_z = (char) (this.data.ll8[this.su_tPos] & UByte.MAX_VALUE);
            this.su_tPos = this.data.f583tt[this.su_tPos];
            this.su_j2 = 0;
            return setupNoRandPartC();
        }
        return setupNoRandPartA();
    }

    private int setupNoRandPartC() throws IOException {
        if (this.su_j2 < this.su_z) {
            int su_ch2Shadow = this.su_ch2;
            this.crc.updateCRC(su_ch2Shadow);
            this.su_j2++;
            this.currentState = 7;
            return su_ch2Shadow;
        }
        this.su_i2++;
        this.su_count = 0;
        return setupNoRandPartA();
    }

    private static final class Data {
        byte[] ll8;

        /* JADX INFO: renamed from: tt */
        int[] f583tt;
        final boolean[] inUse = new boolean[256];
        final byte[] seqToUnseq = new byte[256];
        final byte[] selector = new byte[BZip2Constants.MAX_SELECTORS];
        final byte[] selectorMtf = new byte[BZip2Constants.MAX_SELECTORS];
        final int[] unzftab = new int[256];
        final int[][] limit = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, BZip2Constants.MAX_ALPHA_SIZE);
        final int[][] base = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, BZip2Constants.MAX_ALPHA_SIZE);
        final int[][] perm = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, BZip2Constants.MAX_ALPHA_SIZE);
        final int[] minLens = new int[6];
        final int[] cftab = new int[257];
        final char[] getAndMoveToFrontDecode_yy = new char[256];
        final char[][] temp_charArray2d = (char[][]) Array.newInstance((Class<?>) Character.TYPE, 6, BZip2Constants.MAX_ALPHA_SIZE);
        final byte[] recvDecodingTables_pos = new byte[6];

        Data(int blockSize100k) {
            this.ll8 = new byte[100000 * blockSize100k];
        }

        int[] initTT(int length) {
            int[] ttShadow = this.f583tt;
            if (ttShadow == null || ttShadow.length < length) {
                int[] ttShadow2 = new int[length];
                this.f583tt = ttShadow2;
                return ttShadow2;
            }
            return ttShadow;
        }
    }

    public static boolean matches(byte[] signature, int length) {
        return length >= 3 && signature[0] == 66 && signature[1] == 90 && signature[2] == 104;
    }
}
