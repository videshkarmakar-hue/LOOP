package com.fasterxml.jackson.core.sym;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class NameN extends Name {

    /* JADX INFO: renamed from: q */
    private final int[] f359q;

    /* JADX INFO: renamed from: q1 */
    private final int f360q1;

    /* JADX INFO: renamed from: q2 */
    private final int f361q2;

    /* JADX INFO: renamed from: q3 */
    private final int f362q3;

    /* JADX INFO: renamed from: q4 */
    private final int f363q4;
    private final int qlen;

    NameN(String name, int hash, int q1, int q2, int q3, int q4, int[] quads, int quadLen) {
        super(name, hash);
        this.f360q1 = q1;
        this.f361q2 = q2;
        this.f362q3 = q3;
        this.f363q4 = q4;
        this.f359q = quads;
        this.qlen = quadLen;
    }

    public static NameN construct(String name, int hash, int[] q, int qlen) {
        int[] buf;
        if (qlen >= 4) {
            int q1 = q[0];
            int q2 = q[1];
            int q3 = q[2];
            int q4 = q[3];
            int rem = qlen - 4;
            if (rem > 0) {
                buf = Arrays.copyOfRange(q, 4, qlen);
            } else {
                buf = null;
            }
            return new NameN(name, hash, q1, q2, q3, q4, buf, qlen);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int quad) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int quad1, int quad2) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int quad1, int quad2, int quad3) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] quads, int len) {
        if (len != this.qlen || quads[0] != this.f360q1 || quads[1] != this.f361q2 || quads[2] != this.f362q3 || quads[3] != this.f363q4) {
            return false;
        }
        switch (len) {
            case 8:
                if (quads[7] != this.f359q[3]) {
                    return false;
                }
            case 7:
                if (quads[6] != this.f359q[2]) {
                    return false;
                }
            case 6:
                if (quads[5] != this.f359q[1]) {
                    return false;
                }
            case 5:
                if (quads[4] != this.f359q[0]) {
                    return false;
                }
            case 4:
                return true;
            default:
                return _equals2(quads);
        }
    }

    private final boolean _equals2(int[] quads) {
        int end = this.qlen - 4;
        for (int i = 0; i < end; i++) {
            if (quads[i + 4] != this.f359q[i]) {
                return false;
            }
        }
        return true;
    }
}
