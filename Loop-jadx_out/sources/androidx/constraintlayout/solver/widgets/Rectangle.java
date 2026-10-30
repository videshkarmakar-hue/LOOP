package androidx.constraintlayout.solver.widgets;

/* JADX INFO: loaded from: classes17.dex */
public class Rectangle {
    public int height;
    public int width;

    /* JADX INFO: renamed from: x */
    public int f201x;

    /* JADX INFO: renamed from: y */
    public int f202y;

    public void setBounds(int x, int y, int width, int height) {
        this.f201x = x;
        this.f202y = y;
        this.width = width;
        this.height = height;
    }

    void grow(int w, int h) {
        this.f201x -= w;
        this.f202y -= h;
        this.width += w * 2;
        this.height += h * 2;
    }

    boolean intersects(Rectangle bounds) {
        return this.f201x >= bounds.f201x && this.f201x < bounds.f201x + bounds.width && this.f202y >= bounds.f202y && this.f202y < bounds.f202y + bounds.height;
    }

    public boolean contains(int x, int y) {
        return x >= this.f201x && x < this.f201x + this.width && y >= this.f202y && y < this.f202y + this.height;
    }

    public int getCenterX() {
        return (this.f201x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f202y + this.height) / 2;
    }
}
