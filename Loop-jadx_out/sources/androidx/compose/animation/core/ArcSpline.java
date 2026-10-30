package androidx.compose.animation.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: ArcSpline.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005R\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m195d2 = {"Landroidx/compose/animation/core/ArcSpline;", "", "arcModes", "", "timePoints", "", "y", "", "([I[F[[F)V", "arcs", "Landroidx/compose/animation/core/ArcSpline$Arc;", "[[Landroidx/compose/animation/core/ArcSpline$Arc;", "isExtrapolate", "", "getPos", "", "time", "", "v", "getSlope", "Arc", "Companion", "animation-core_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ArcSpline {
    public static final int ArcAbove = 5;
    public static final int ArcBelow = 4;
    public static final int ArcStartFlip = 3;
    public static final int ArcStartHorizontal = 2;
    public static final int ArcStartLinear = 0;
    public static final int ArcStartVertical = 1;
    private static final int DownArc = 4;
    private static final int StartHorizontal = 2;
    private static final int StartLinear = 3;
    private static final int StartVertical = 1;
    private static final int UpArc = 5;
    private final Arc[][] arcs;
    private final boolean isExtrapolate = true;
    public static final int $stable = 8;

    public ArcSpline(int[] arcModes, float[] timePoints, float[][] y) {
        int mode = 1;
        int last = 1;
        int length = timePoints.length - 1;
        Arc[][] arcArr = new Arc[length][];
        for (int i = 0; i < length; i++) {
            switch (arcModes[i]) {
                case 0:
                    mode = 3;
                    break;
                case 1:
                    mode = 1;
                    last = 1;
                    break;
                case 2:
                    mode = 2;
                    last = 2;
                    break;
                case 3:
                    mode = last == 1 ? 2 : 1;
                    last = mode;
                    break;
                case 4:
                    mode = 4;
                    break;
                case 5:
                    mode = 5;
                    break;
            }
            int dim = (y[i].length / 2) + (y[i].length % 2);
            Arc[] arcArr2 = new Arc[dim];
            int i2 = 0;
            while (i2 < dim) {
                int k = i2 * 2;
                int i3 = i + 1;
                int i4 = i2;
                arcArr2[i4] = new Arc(mode, timePoints[i], timePoints[i3], y[i][k], y[i][k + 1], y[i3][k], y[i3][k + 1]);
                i2 = i4 + 1;
            }
            arcArr[i] = arcArr2;
        }
        this.arcs = arcArr;
    }

    public final void getPos(float time, float[] v) {
        int p;
        float t0;
        float t = time;
        if (!this.isExtrapolate) {
            if (t < this.arcs[0][0].getTime1()) {
                t = this.arcs[0][0].getTime1();
            }
            if (t > this.arcs[this.arcs.length - 1][0].getTime2()) {
                t = this.arcs[this.arcs.length - 1][0].getTime2();
            }
        } else if (t < this.arcs[0][0].getTime1() || t > this.arcs[this.arcs.length - 1][0].getTime2()) {
            if (t > this.arcs[this.arcs.length - 1][0].getTime2()) {
                p = this.arcs.length - 1;
                t0 = this.arcs[this.arcs.length - 1][0].getTime2();
            } else {
                p = 0;
                t0 = this.arcs[0][0].getTime1();
            }
            float dt = t - t0;
            int i = 0;
            int j = 0;
            while (i < v.length) {
                if (this.arcs[p][j].getIsLinear()) {
                    v[i] = this.arcs[p][j].getLinearX(t0) + (this.arcs[p][j].getEllipseCenterX() * dt);
                    v[i + 1] = this.arcs[p][j].getLinearY(t0) + (this.arcs[p][j].getEllipseCenterY() * dt);
                } else {
                    this.arcs[p][j].setPoint(t0);
                    v[i] = this.arcs[p][j].calcX() + (this.arcs[p][j].calcDX() * dt);
                    v[i + 1] = this.arcs[p][j].calcY() + (this.arcs[p][j].calcDY() * dt);
                }
                i += 2;
                j++;
            }
            return;
        }
        boolean populated = false;
        int length = this.arcs.length;
        for (int i2 = 0; i2 < length; i2++) {
            int k = 0;
            int j2 = 0;
            while (j2 < v.length) {
                if (t <= this.arcs[i2][k].getTime2()) {
                    if (this.arcs[i2][k].getIsLinear()) {
                        v[j2] = this.arcs[i2][k].getLinearX(t);
                        v[j2 + 1] = this.arcs[i2][k].getLinearY(t);
                        populated = true;
                    } else {
                        this.arcs[i2][k].setPoint(t);
                        v[j2] = this.arcs[i2][k].calcX();
                        v[j2 + 1] = this.arcs[i2][k].calcY();
                        populated = true;
                    }
                }
                j2 += 2;
                k++;
            }
            if (populated) {
                return;
            }
        }
    }

    public final void getSlope(float time, float[] v) {
        float t = time;
        if (t < this.arcs[0][0].getTime1()) {
            t = this.arcs[0][0].getTime1();
        } else if (t > this.arcs[this.arcs.length - 1][0].getTime2()) {
            t = this.arcs[this.arcs.length - 1][0].getTime2();
        }
        boolean populated = false;
        int length = this.arcs.length;
        for (int i = 0; i < length; i++) {
            int j = 0;
            int k = 0;
            while (j < v.length) {
                if (t <= this.arcs[i][k].getTime2()) {
                    if (this.arcs[i][k].getIsLinear()) {
                        v[j] = this.arcs[i][k].getEllipseCenterX();
                        v[j + 1] = this.arcs[i][k].getEllipseCenterY();
                        populated = true;
                    } else {
                        this.arcs[i][k].setPoint(t);
                        v[j] = this.arcs[i][k].calcDX();
                        v[j + 1] = this.arcs[i][k].calcDY();
                        populated = true;
                    }
                }
                j += 2;
                k++;
            }
            if (populated) {
                return;
            }
        }
    }

    /* JADX INFO: compiled from: ArcSpline.kt */
    @Metadata(m194d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B?\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0005J\u000e\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u000e\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0002J\u000e\u0010+\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0005R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, m195d2 = {"Landroidx/compose/animation/core/ArcSpline$Arc;", "", "mode", "", "time1", "", "time2", "x1", "y1", "x2", "y2", "(IFFFFFF)V", "arcDistance", "arcVelocity", "ellipseA", "ellipseB", "ellipseCenterX", "ellipseCenterY", "isLinear", "", "()Z", "isVertical", "lut", "", "oneOverDeltaTime", "getTime1", "()F", "getTime2", "tmpCosAngle", "tmpSinAngle", "buildTable", "", "calcDX", "calcDY", "calcX", "calcY", "getLinearDX", "getLinearDY", "getLinearX", "time", "getLinearY", "lookup", "v", "setPoint", "Companion", "animation-core_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Arc {
        private static final float Epsilon = 0.001f;
        private static float[] _ourPercent;
        private float arcDistance;
        private final float arcVelocity;
        private final float ellipseA;
        private final float ellipseB;
        private final float ellipseCenterX;
        private final float ellipseCenterY;
        private final boolean isLinear;
        private final boolean isVertical;
        private final float[] lut;
        private final float oneOverDeltaTime;
        private final float time1;
        private final float time2;
        private float tmpCosAngle;
        private float tmpSinAngle;
        private final float x1;
        private final float x2;
        private final float y1;
        private final float y2;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        public Arc(int mode, float time1, float time2, float x1, float y1, float x2, float y2) {
            this.time1 = time1;
            this.time2 = time2;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            float dx = this.x2 - this.x1;
            float dy = this.y2 - this.y1;
            boolean z = false;
            switch (mode) {
                case 1:
                    z = true;
                    break;
                case 4:
                    if (dy > 0.0f) {
                        z = true;
                    }
                    break;
                case 5:
                    if (dy < 0.0f) {
                        z = true;
                    }
                    break;
            }
            this.isVertical = z;
            this.oneOverDeltaTime = 1 / (this.time2 - this.time1);
            boolean isLinear = 3 == mode;
            if (isLinear || Math.abs(dx) < Epsilon || Math.abs(dy) < Epsilon) {
                isLinear = true;
                this.arcDistance = (float) Math.hypot(dy, dx);
                this.arcVelocity = this.arcDistance * this.oneOverDeltaTime;
                this.ellipseCenterX = dx / (this.time2 - this.time1);
                this.ellipseCenterY = dy / (this.time2 - this.time1);
                this.lut = new float[HttpStatusCodesKt.HTTP_SWITCHING_PROTOCOLS];
                this.ellipseA = Float.NaN;
                this.ellipseB = Float.NaN;
            } else {
                this.lut = new float[HttpStatusCodesKt.HTTP_SWITCHING_PROTOCOLS];
                this.ellipseA = (this.isVertical ? -1 : 1) * dx;
                this.ellipseB = (this.isVertical ? 1 : -1) * dy;
                this.ellipseCenterX = this.isVertical ? this.x2 : this.x1;
                this.ellipseCenterY = this.isVertical ? this.y1 : this.y2;
                buildTable(this.x1, this.y1, this.x2, this.y2);
                this.arcVelocity = this.arcDistance * this.oneOverDeltaTime;
            }
            this.isLinear = isLinear;
        }

        public final float getTime1() {
            return this.time1;
        }

        public final float getTime2() {
            return this.time2;
        }

        /* JADX INFO: renamed from: isLinear, reason: from getter */
        public final boolean getIsLinear() {
            return this.isLinear;
        }

        public final void setPoint(float time) {
            float percent = (this.isVertical ? this.time2 - time : time - this.time1) * this.oneOverDeltaTime;
            float angle = lookup(percent) * 1.5707964f;
            this.tmpSinAngle = (float) Math.sin(angle);
            this.tmpCosAngle = (float) Math.cos(angle);
        }

        public final float calcX() {
            return this.ellipseCenterX + (this.ellipseA * this.tmpSinAngle);
        }

        public final float calcY() {
            return this.ellipseCenterY + (this.ellipseB * this.tmpCosAngle);
        }

        public final float calcDX() {
            float vx = this.ellipseA * this.tmpCosAngle;
            float vy = (-this.ellipseB) * this.tmpSinAngle;
            float norm = this.arcVelocity / ((float) Math.hypot(vx, vy));
            return this.isVertical ? (-vx) * norm : vx * norm;
        }

        public final float calcDY() {
            float vx = this.ellipseA * this.tmpCosAngle;
            float vy = (-this.ellipseB) * this.tmpSinAngle;
            float norm = this.arcVelocity / ((float) Math.hypot(vx, vy));
            return this.isVertical ? (-vy) * norm : vy * norm;
        }

        public final float getLinearX(float time) {
            float t = (time - this.time1) * this.oneOverDeltaTime;
            float t2 = this.x1;
            return t2 + ((this.x2 - this.x1) * t);
        }

        public final float getLinearY(float time) {
            float t = (time - this.time1) * this.oneOverDeltaTime;
            float t2 = this.y1;
            return t2 + ((this.y2 - this.y1) * t);
        }

        /* JADX INFO: renamed from: getLinearDX, reason: from getter */
        public final float getEllipseCenterX() {
            return this.ellipseCenterX;
        }

        /* JADX INFO: renamed from: getLinearDY, reason: from getter */
        public final float getEllipseCenterY() {
            return this.ellipseCenterY;
        }

        private final float lookup(float v) {
            if (v <= 0.0f) {
                return 0.0f;
            }
            if (v >= 1.0f) {
                return 1.0f;
            }
            float pos = (this.lut.length - 1) * v;
            int iv = (int) pos;
            float off = pos - ((int) pos);
            return this.lut[iv] + ((this.lut[iv + 1] - this.lut[iv]) * off);
        }

        private final void buildTable(float x1, float y1, float x2, float y2) {
            float a = x2 - x1;
            float b = y1 - y2;
            float lx = 0.0f;
            float ly = 0.0f;
            float dist = 0.0f;
            int i = 0;
            int length = INSTANCE.getOurPercent().length;
            while (i < length) {
                float angle = (float) Math.toRadians((((double) i) * 90.0d) / ((double) (INSTANCE.getOurPercent().length - 1)));
                float s = (float) Math.sin(angle);
                float c = (float) Math.cos(angle);
                float px = a * s;
                float py = b * c;
                if (i > 0) {
                    dist += (float) Math.hypot(px - lx, py - ly);
                    INSTANCE.getOurPercent()[i] = dist;
                }
                lx = px;
                ly = py;
                i++;
                a = a;
                b = b;
            }
            this.arcDistance = dist;
            int length2 = INSTANCE.getOurPercent().length;
            for (int i2 = 0; i2 < length2; i2++) {
                float[] ourPercent = INSTANCE.getOurPercent();
                ourPercent[i2] = ourPercent[i2] / dist;
            }
            int length3 = this.lut.length;
            for (int i3 = 0; i3 < length3; i3++) {
                float pos = i3 / (this.lut.length - 1);
                int index = ArraysKt.binarySearch$default(INSTANCE.getOurPercent(), pos, 0, 0, 6, (Object) null);
                if (index < 0) {
                    if (index == -1) {
                        this.lut[i3] = 0.0f;
                    } else {
                        int p1 = (-index) - 2;
                        int p2 = (-index) - 1;
                        float ans = (p1 + ((pos - INSTANCE.getOurPercent()[p1]) / (INSTANCE.getOurPercent()[p2] - INSTANCE.getOurPercent()[p1]))) / (INSTANCE.getOurPercent().length - 1);
                        this.lut[i3] = ans;
                    }
                } else {
                    this.lut[i3] = index / (INSTANCE.getOurPercent().length - 1);
                }
            }
        }

        /* JADX INFO: compiled from: ArcSpline.kt */
        @Metadata(m194d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m195d2 = {"Landroidx/compose/animation/core/ArcSpline$Arc$Companion;", "", "()V", "Epsilon", "", "_ourPercent", "", "ourPercent", "getOurPercent", "()[F", "animation-core_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final float[] getOurPercent() {
                if (Arc._ourPercent != null) {
                    float[] fArr = Arc._ourPercent;
                    Intrinsics.checkNotNull(fArr);
                    return fArr;
                }
                Arc._ourPercent = new float[91];
                float[] fArr2 = Arc._ourPercent;
                Intrinsics.checkNotNull(fArr2);
                return fArr2;
            }
        }
    }
}
