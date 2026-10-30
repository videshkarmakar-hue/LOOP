package com.google.android.material.color.utilities;

/* JADX INFO: loaded from: classes18.dex */
public final class ViewingConditions {
    public static final ViewingConditions DEFAULT = defaultWithBackgroundLstar(50.0d);

    /* JADX INFO: renamed from: aw */
    private final double f420aw;

    /* JADX INFO: renamed from: c */
    private final double f421c;

    /* JADX INFO: renamed from: fl */
    private final double f422fl;
    private final double flRoot;

    /* JADX INFO: renamed from: n */
    private final double f423n;
    private final double nbb;

    /* JADX INFO: renamed from: nc */
    private final double f424nc;
    private final double ncb;
    private final double[] rgbD;

    /* JADX INFO: renamed from: z */
    private final double f425z;

    public double getAw() {
        return this.f420aw;
    }

    public double getN() {
        return this.f423n;
    }

    public double getNbb() {
        return this.nbb;
    }

    double getNcb() {
        return this.ncb;
    }

    double getC() {
        return this.f421c;
    }

    double getNc() {
        return this.f424nc;
    }

    public double[] getRgbD() {
        return this.rgbD;
    }

    double getFl() {
        return this.f422fl;
    }

    public double getFlRoot() {
        return this.flRoot;
    }

    double getZ() {
        return this.f425z;
    }

    public static ViewingConditions make(double[] whitePoint, double adaptingLuminance, double backgroundLstar, double surround, boolean discountingIlluminant) {
        double d;
        double backgroundLstar2 = Math.max(0.1d, backgroundLstar);
        double[][] matrix = Cam16.XYZ_TO_CAM16RGB;
        double rW = (whitePoint[0] * matrix[0][0]) + (whitePoint[1] * matrix[0][1]) + (whitePoint[2] * matrix[0][2]);
        double gW = (whitePoint[0] * matrix[1][0]) + (whitePoint[1] * matrix[1][1]) + (whitePoint[2] * matrix[1][2]);
        double bW = (whitePoint[0] * matrix[2][0]) + (whitePoint[1] * matrix[2][1]) + (whitePoint[2] * matrix[2][2]);
        double f = (surround / 10.0d) + 0.8d;
        double c = f >= 0.9d ? MathUtils.lerp(0.59d, 0.69d, (f - 0.9d) * 10.0d) : MathUtils.lerp(0.525d, 0.59d, (f - 0.8d) * 10.0d);
        if (!discountingIlluminant) {
            d = (1.0d - (Math.exp(((-adaptingLuminance) - 42.0d) / 92.0d) * 0.2777777777777778d)) * f;
        } else {
            d = 1.0d;
        }
        double d2 = MathUtils.clampDouble(0.0d, 1.0d, d);
        double[] rgbD = {(((100.0d / rW) * d2) + 1.0d) - d2, (((100.0d / gW) * d2) + 1.0d) - d2, (((100.0d / bW) * d2) + 1.0d) - d2};
        double k = 1.0d / ((adaptingLuminance * 5.0d) + 1.0d);
        double k4 = k * k * k * k;
        double k4F = 1.0d - k4;
        double fl = (k4 * adaptingLuminance) + (0.1d * k4F * k4F * Math.cbrt(5.0d * adaptingLuminance));
        double n = ColorUtils.yFromLstar(backgroundLstar2) / whitePoint[1];
        double z = Math.sqrt(n) + 1.48d;
        double nbb = 0.725d / Math.pow(n, 0.2d);
        double[] rgbAFactors = {Math.pow(((rgbD[0] * fl) * rW) / 100.0d, 0.42d), Math.pow(((rgbD[1] * fl) * gW) / 100.0d, 0.42d), Math.pow(((rgbD[2] * fl) * bW) / 100.0d, 0.42d)};
        double[] rgbA = {(rgbAFactors[0] * 400.0d) / (rgbAFactors[0] + 27.13d), (rgbAFactors[1] * 400.0d) / (rgbAFactors[1] + 27.13d), (rgbAFactors[2] * 400.0d) / (rgbAFactors[2] + 27.13d)};
        double aw = ((rgbA[0] * 2.0d) + rgbA[1] + (rgbA[2] * 0.05d)) * nbb;
        return new ViewingConditions(n, aw, nbb, nbb, c, f, rgbD, fl, Math.pow(fl, 0.25d), z);
    }

    public static ViewingConditions defaultWithBackgroundLstar(double lstar) {
        return make(ColorUtils.whitePointD65(), (ColorUtils.yFromLstar(50.0d) * 63.66197723675813d) / 100.0d, lstar, 2.0d, false);
    }

    private ViewingConditions(double n, double aw, double nbb, double ncb, double c, double nc, double[] rgbD, double fl, double flRoot, double z) {
        this.f423n = n;
        this.f420aw = aw;
        this.nbb = nbb;
        this.ncb = ncb;
        this.f421c = c;
        this.f424nc = nc;
        this.rgbD = rgbD;
        this.f422fl = fl;
        this.flRoot = flRoot;
        this.f425z = z;
    }
}
