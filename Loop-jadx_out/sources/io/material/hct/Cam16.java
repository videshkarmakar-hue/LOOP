package io.material.hct;

import androidx.constraintlayout.widget.ConstraintLayout;
import io.material.utils.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

/* JADX INFO: compiled from: Cam16.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m194d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"BO\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\u000e\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0000J\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010 \u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u0018R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, m195d2 = {"Lio/material/hct/Cam16;", "", "hue", "", "chroma", "j", "q", "m", "s", "jstar", "astar", "bstar", "(DDDDDDDDD)V", "getAstar", "()D", "getBstar", "getChroma", "getHue", "getJ", "getJstar", "getM", "getQ", "getS", "tempArray", "", "distance", "other", "toInt", "", "viewed", "viewingConditions", "Lio/material/hct/ViewingConditions;", "xyzInViewingConditions", "returnArray", "Companion", "color_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Cam16 {
    private final double astar;
    private final double bstar;
    private final double chroma;
    private final double hue;
    private final double j;
    private final double jstar;
    private final double m;
    private final double q;
    private final double s;
    private final double[] tempArray;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final double[][] XYZ_TO_CAM16RGB = {new double[]{0.401288d, 0.650173d, -0.051461d}, new double[]{-0.250268d, 1.204414d, 0.045854d}, new double[]{-0.002079d, 0.048952d, 0.953127d}};
    private static final double[][] CAM16RGB_TO_XYZ = {new double[]{1.8620678d, -1.0112547d, 0.14918678d}, new double[]{0.38752654d, 0.62144744d, -0.00897398d}, new double[]{-0.0158415d, -0.03412294d, 1.0499644d}};

    public /* synthetic */ Cam16(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, d2, d3, d4, d5, d6, d7, d8, d9);
    }

    private Cam16(double hue, double chroma, double j, double q, double m, double s, double jstar, double astar, double bstar) {
        this.hue = hue;
        this.chroma = chroma;
        this.j = j;
        this.q = q;
        this.m = m;
        this.s = s;
        this.jstar = jstar;
        this.astar = astar;
        this.bstar = bstar;
        this.tempArray = new double[]{0.0d, 0.0d, 0.0d};
    }

    public final double getHue() {
        return this.hue;
    }

    public final double getChroma() {
        return this.chroma;
    }

    public final double getJ() {
        return this.j;
    }

    public final double getQ() {
        return this.q;
    }

    public final double getM() {
        return this.m;
    }

    public final double getS() {
        return this.s;
    }

    public final double getJstar() {
        return this.jstar;
    }

    public final double getAstar() {
        return this.astar;
    }

    public final double getBstar() {
        return this.bstar;
    }

    public final double distance(Cam16 other) {
        Intrinsics.checkNotNullParameter(other, "other");
        double dJ = this.jstar - other.jstar;
        double dA = this.astar - other.astar;
        double dB = this.bstar - other.bstar;
        double dEPrime = Math.sqrt((dJ * dJ) + (dA * dA) + (dB * dB));
        return Math.pow(dEPrime, 0.63d) * 1.41d;
    }

    public final int toInt() {
        return viewed(ViewingConditions.INSTANCE.getDEFAULT());
    }

    public final int viewed(ViewingConditions viewingConditions) {
        Intrinsics.checkNotNullParameter(viewingConditions, "viewingConditions");
        double[] xyz = xyzInViewingConditions(viewingConditions, this.tempArray);
        return ColorUtils.INSTANCE.argbFromXyz(xyz[0], xyz[1], xyz[2]);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002f  */
    public final double[] xyzInViewingConditions(ViewingConditions viewingConditions, double[] returnArray) {
        double alpha;
        Intrinsics.checkNotNullParameter(viewingConditions, "viewingConditions");
        if (this.chroma == 0.0d) {
            alpha = 0.0d;
        } else {
            if (this.j == 0.0d) {
                alpha = 0.0d;
            } else {
                alpha = this.chroma / Math.sqrt(this.j / 100.0d);
            }
        }
        double t = Math.pow(alpha / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        Companion companion = INSTANCE;
        double $this$toRadians$iv = this.hue;
        double hRad = (3.141592653589793d * $this$toRadians$iv) / 180.0d;
        double eHue = (Math.cos(2.0d + hRad) + 3.8d) * 0.25d;
        double ac = viewingConditions.getAw() * Math.pow(this.j / 100.0d, (1.0d / viewingConditions.getC()) / viewingConditions.getZ());
        double p1 = 3846.153846153846d * eHue * viewingConditions.getNc() * viewingConditions.getNcb();
        double p2 = ac / viewingConditions.getNbb();
        double hSin = Math.sin(hRad);
        double hCos = Math.cos(hRad);
        double gamma = (((p2 + 0.305d) * 23.0d) * t) / (((23.0d * p1) + ((11.0d * t) * hCos)) + ((108.0d * t) * hSin));
        double a = gamma * hCos;
        double b = gamma * hSin;
        double rA = (((p2 * 460.0d) + (451.0d * a)) + (288.0d * b)) / 1403.0d;
        double gA = (((p2 * 460.0d) - (891.0d * a)) - (261.0d * b)) / 1403.0d;
        double bA = (((460.0d * p2) - (220.0d * a)) - (6300.0d * b)) / 1403.0d;
        double rCBase = Math.max(0.0d, (Math.abs(rA) * 27.13d) / (400.0d - Math.abs(rA)));
        double rC = Math.signum(rA) * (100.0d / viewingConditions.getFl()) * Math.pow(rCBase, 2.380952380952381d);
        double gCBase = Math.max(0.0d, (Math.abs(gA) * 27.13d) / (400.0d - Math.abs(gA)));
        double gC = Math.signum(gA) * (100.0d / viewingConditions.getFl()) * Math.pow(gCBase, 2.380952380952381d);
        double bCBase = Math.max(0.0d, (Math.abs(bA) * 27.13d) / (400.0d - Math.abs(bA)));
        double dSignum = Math.signum(bA) * (100.0d / viewingConditions.getFl());
        double gCBase2 = Math.pow(bCBase, 2.380952380952381d);
        double bC = dSignum * gCBase2;
        double rF = rC / viewingConditions.getRgbD()[0];
        double gF = gC / viewingConditions.getRgbD()[1];
        double bF = bC / viewingConditions.getRgbD()[2];
        double[][] matrix = CAM16RGB_TO_XYZ;
        double x = (matrix[0][0] * rF) + (matrix[0][1] * gF) + (matrix[0][2] * bF);
        double y = (matrix[1][0] * rF) + (matrix[1][1] * gF) + (matrix[1][2] * bF);
        double z = (matrix[2][0] * rF) + (matrix[2][1] * gF) + (matrix[2][2] * bF);
        if (returnArray == null) {
            return new double[]{x, y, z};
        }
        returnArray[0] = x;
        returnArray[1] = y;
        returnArray[2] = z;
        return returnArray;
    }

    /* JADX INFO: compiled from: Cam16.kt */
    @Metadata(m194d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0013\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014J(\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0014J&\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011J\r\u0010!\u001a\u00020\u0014*\u00020\u0014H\u0082\bJ\r\u0010\"\u001a\u00020\u0014*\u00020\u0014H\u0082\bR\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006#"}, m195d2 = {"Lio/material/hct/Cam16$Companion;", "", "()V", "CAM16RGB_TO_XYZ", "", "", "getCAM16RGB_TO_XYZ", "()[[D", "[[D", "XYZ_TO_CAM16RGB", "getXYZ_TO_CAM16RGB", "fromInt", "Lio/material/hct/Cam16;", "argb", "", "fromIntInViewingConditions", "viewingConditions", "Lio/material/hct/ViewingConditions;", "fromJch", "j", "", "c", "h", "fromJchInViewingConditions", "fromUcs", "jstar", "astar", "bstar", "fromUcsInViewingConditions", "fromXyzInViewingConditions", "x", "y", CompressorStreamFactory.f581Z, "toDegrees", "toRadians", "color_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final double[][] getXYZ_TO_CAM16RGB() {
            return Cam16.XYZ_TO_CAM16RGB;
        }

        public final double[][] getCAM16RGB_TO_XYZ() {
            return Cam16.CAM16RGB_TO_XYZ;
        }

        public final Cam16 fromInt(int argb) {
            return fromIntInViewingConditions(argb, ViewingConditions.INSTANCE.getDEFAULT());
        }

        public final Cam16 fromIntInViewingConditions(int argb, ViewingConditions viewingConditions) {
            Intrinsics.checkNotNullParameter(viewingConditions, "viewingConditions");
            int red = (16711680 & argb) >> 16;
            int green = (65280 & argb) >> 8;
            int blue = argb & 255;
            double redL = ColorUtils.INSTANCE.linearized(red);
            double greenL = ColorUtils.INSTANCE.linearized(green);
            double blueL = ColorUtils.INSTANCE.linearized(blue);
            double x = (0.41233895d * redL) + (0.35762064d * greenL) + (0.18051042d * blueL);
            double y = (0.2126d * redL) + (0.7152d * greenL) + (0.0722d * blueL);
            double z = (0.01932141d * redL) + (0.11916382d * greenL) + (0.95034478d * blueL);
            return fromXyzInViewingConditions(x, y, z, viewingConditions);
        }

        public final Cam16 fromXyzInViewingConditions(double x, double y, double z, ViewingConditions viewingConditions) {
            double $this$toRadians$iv;
            Intrinsics.checkNotNullParameter(viewingConditions, "viewingConditions");
            double[][] matrix = getXYZ_TO_CAM16RGB();
            double rT = (x * matrix[0][0]) + (matrix[0][1] * y) + (matrix[0][2] * z);
            double gT = (matrix[1][0] * x) + (matrix[1][1] * y) + (matrix[1][2] * z);
            double bT = (matrix[2][0] * x) + (matrix[2][1] * y) + (matrix[2][2] * z);
            double rD = viewingConditions.getRgbD()[0] * rT;
            double gD = viewingConditions.getRgbD()[1] * gT;
            double bD = viewingConditions.getRgbD()[2] * bT;
            double rAF = Math.pow((viewingConditions.getFl() * Math.abs(rD)) / 100.0d, 0.42d);
            double gAF = Math.pow((viewingConditions.getFl() * Math.abs(gD)) / 100.0d, 0.42d);
            double bAF = Math.pow((viewingConditions.getFl() * Math.abs(bD)) / 100.0d, 0.42d);
            double rA = ((Math.signum(rD) * 400.0d) * rAF) / (rAF + 27.13d);
            double gA = ((Math.signum(gD) * 400.0d) * gAF) / (gAF + 27.13d);
            double bA = ((Math.signum(bD) * 400.0d) * bAF) / (bAF + 27.13d);
            double rAF2 = (((rA * 11.0d) + ((-12.0d) * gA)) + bA) / 11.0d;
            double bAF2 = ((rA + gA) - (bA * 2.0d)) / 9.0d;
            double u = (((rA * 20.0d) + (gA * 20.0d)) + (21.0d * bA)) / 20.0d;
            double p2 = (((40.0d * rA) + (gA * 20.0d)) + bA) / 20.0d;
            double atan2 = Math.atan2(bAF2, rAF2);
            double atanDegrees = (atan2 * 180.0d) / 3.141592653589793d;
            if (atanDegrees < 0.0d) {
                $this$toRadians$iv = atanDegrees + 360.0d;
            } else {
                $this$toRadians$iv = atanDegrees >= 360.0d ? atanDegrees - 360.0d : atanDegrees;
            }
            double hue = $this$toRadians$iv;
            double hueRadians = ($this$toRadians$iv * 3.141592653589793d) / 180.0d;
            double ac = p2 * viewingConditions.getNbb();
            double j = Math.pow(ac / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ()) * 100.0d;
            double q = (4.0d / viewingConditions.getC()) * Math.sqrt(j / 100.0d) * (viewingConditions.getAw() + 4.0d) * viewingConditions.getFlRoot();
            double huePrime = hue < 20.14d ? hue + ((double) 360) : hue;
            double $this$toRadians$iv2 = huePrime;
            double eHue = (Math.cos(((3.141592653589793d * $this$toRadians$iv2) / 180.0d) + 2.0d) + 3.8d) * 0.25d;
            double p1 = 3846.153846153846d * eHue * viewingConditions.getNc() * viewingConditions.getNcb();
            double a = (Math.hypot(rAF2, bAF2) * p1) / (u + 0.305d);
            double huePrime2 = viewingConditions.getN();
            double alpha = Math.pow(1.64d - Math.pow(0.29d, huePrime2), 0.73d) * Math.pow(a, 0.9d);
            double c = Math.sqrt(j / 100.0d) * alpha;
            double m = viewingConditions.getFlRoot() * c;
            double s = Math.sqrt((viewingConditions.getC() * alpha) / (viewingConditions.getAw() + 4.0d)) * 50.0d;
            double jstar = (1.7000000000000002d * j) / ((0.007d * j) + 1.0d);
            double mstar = Math.log1p(0.0228d * m) * 43.859649122807014d;
            double astar = mstar * Math.cos(hueRadians);
            double bstar = mstar * Math.sin(hueRadians);
            return new Cam16(hue, c, j, q, m, s, jstar, astar, bstar, null);
        }

        public final Cam16 fromJch(double j, double c, double h) {
            return fromJchInViewingConditions(j, c, h, ViewingConditions.INSTANCE.getDEFAULT());
        }

        private final Cam16 fromJchInViewingConditions(double j, double c, double h, ViewingConditions viewingConditions) {
            double q = (4.0d / viewingConditions.getC()) * Math.sqrt(j / 100.0d) * (viewingConditions.getAw() + 4.0d) * viewingConditions.getFlRoot();
            double m = c * viewingConditions.getFlRoot();
            double alpha = c / Math.sqrt(j / 100.0d);
            double s = Math.sqrt((viewingConditions.getC() * alpha) / (viewingConditions.getAw() + 4.0d)) * 50.0d;
            double hueRadians = (3.141592653589793d * h) / 180.0d;
            double jstar = (1.7000000000000002d * j) / ((0.007d * j) + 1.0d);
            double mstar = Math.log1p(0.0228d * m) * 43.859649122807014d;
            double astar = mstar * Math.cos(hueRadians);
            double bstar = mstar * Math.sin(hueRadians);
            return new Cam16(h, c, j, q, m, s, jstar, astar, bstar, null);
        }

        public final Cam16 fromUcs(double jstar, double astar, double bstar) {
            return fromUcsInViewingConditions(jstar, astar, bstar, ViewingConditions.INSTANCE.getDEFAULT());
        }

        public final Cam16 fromUcsInViewingConditions(double jstar, double astar, double bstar, ViewingConditions viewingConditions) {
            double h;
            Intrinsics.checkNotNullParameter(viewingConditions, "viewingConditions");
            double m = Math.hypot(astar, bstar);
            double m2 = Math.expm1(m * 0.0228d) / 0.0228d;
            double c = m2 / viewingConditions.getFlRoot();
            double h2 = Math.atan2(bstar, astar) * 57.29577951308232d;
            if (h2 >= 0.0d) {
                h = h2;
            } else {
                h = h2 + 360.0d;
            }
            double j = jstar / (1.0d - ((jstar - 100.0d) * 0.007d));
            return fromJchInViewingConditions(j, c, h, viewingConditions);
        }

        private final double toRadians(double $this$toRadians) {
            return (3.141592653589793d * $this$toRadians) / 180.0d;
        }

        private final double toDegrees(double $this$toDegrees) {
            return (180.0d * $this$toDegrees) / 3.141592653589793d;
        }
    }
}
