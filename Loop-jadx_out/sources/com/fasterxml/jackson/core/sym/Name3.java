package com.fasterxml.jackson.core.sym;

/* JADX INFO: loaded from: classes.dex */
public final class Name3 extends Name {

    /* JADX INFO: renamed from: q1 */
    private final int f356q1;

    /* JADX INFO: renamed from: q2 */
    private final int f357q2;

    /* JADX INFO: renamed from: q3 */
    private final int f358q3;

    Name3(String name, int hash, int i1, int i2, int i3) {
        super(name, hash);
        this.f356q1 = i1;
        this.f357q2 = i2;
        this.f358q3 = i3;
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
        return this.f356q1 == quad1 && this.f357q2 == quad2 && this.f358q3 == quad3;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] quads, int qlen) {
        return qlen == 3 && quads[0] == this.f356q1 && quads[1] == this.f357q2 && quads[2] == this.f358q3;
    }
}
