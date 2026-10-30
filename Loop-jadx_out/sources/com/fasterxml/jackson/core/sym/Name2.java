package com.fasterxml.jackson.core.sym;

/* JADX INFO: loaded from: classes.dex */
public final class Name2 extends Name {

    /* JADX INFO: renamed from: q1 */
    private final int f354q1;

    /* JADX INFO: renamed from: q2 */
    private final int f355q2;

    Name2(String name, int hash, int quad1, int quad2) {
        super(name, hash);
        this.f354q1 = quad1;
        this.f355q2 = quad2;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int quad) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int quad1, int quad2) {
        return quad1 == this.f354q1 && quad2 == this.f355q2;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int quad1, int quad2, int q3) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] quads, int qlen) {
        return qlen == 2 && quads[0] == this.f354q1 && quads[1] == this.f355q2;
    }
}
