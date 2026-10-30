package io.material.hct;

import androidx.constraintlayout.widget.ConstraintLayout;
import io.material.utils.ColorUtils;
import io.material.utils.MathUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

/* JADX INFO: compiled from: ViewingConditions.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m194d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0013\n\u0002\b\u0012\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bBW\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006\u001c"}, m195d2 = {"Lio/material/hct/ViewingConditions;", "", "n", "", "aw", "nbb", "ncb", "c", "nc", "rgbD", "", "fl", "flRoot", CompressorStreamFactory.f581Z, "(DDDDDD[DDDD)V", "getAw", "()D", "getC", "getFl", "getFlRoot", "getN", "getNbb", "getNc", "getNcb", "getRgbD", "()[D", "getZ", "Companion", "color_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ViewingConditions {
    private final double aw;
    private final double c;
    private final double fl;
    private final double flRoot;
    private final double n;
    private final double nbb;
    private final double nc;
    private final double ncb;
    private final double[] rgbD;
    private final double z;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final ViewingConditions DEFAULT = INSTANCE.defaultWithBackgroundLstar(50.0d);

    public /* synthetic */ ViewingConditions(double d, double d2, double d3, double d4, double d5, double d6, double[] dArr, double d7, double d8, double d9, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, d2, d3, d4, d5, d6, dArr, d7, d8, d9);
    }

    private ViewingConditions(double n, double aw, double nbb, double ncb, double c, double nc, double[] rgbD, double fl, double flRoot, double z) {
        this.n = n;
        this.aw = aw;
        this.nbb = nbb;
        this.ncb = ncb;
        this.c = c;
        this.nc = nc;
        this.rgbD = rgbD;
        this.fl = fl;
        this.flRoot = flRoot;
        this.z = z;
    }

    public final double getN() {
        return this.n;
    }

    public final double getAw() {
        return this.aw;
    }

    public final double getNbb() {
        return this.nbb;
    }

    public final double getNcb() {
        return this.ncb;
    }

    public final double getC() {
        return this.c;
    }

    public final double getNc() {
        return this.nc;
    }

    public final double[] getRgbD() {
        return this.rgbD;
    }

    public final double getFl() {
        return this.fl;
    }

    public final double getFlRoot() {
        return this.flRoot;
    }

    public final double getZ() {
        return this.z;
    }

    /* JADX INFO: compiled from: ViewingConditions.kt */
    @Metadata(m194d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ0\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, m195d2 = {"Lio/material/hct/ViewingConditions$Companion;", "", "()V", "DEFAULT", "Lio/material/hct/ViewingConditions;", "getDEFAULT", "()Lio/material/hct/ViewingConditions;", "defaultWithBackgroundLstar", "lstar", "", "make", "whitePoint", "", "adaptingLuminance", "backgroundLstar", "surround", "discountingIlluminant", "", "color_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewingConditions getDEFAULT() {
            return ViewingConditions.DEFAULT;
        }

        public final ViewingConditions make(double[] whitePoint, double adaptingLuminance, double backgroundLstar, double surround, boolean discountingIlluminant) {
            double c;
            double backgroundLstar2 = Math.max(0.1d, backgroundLstar);
            double[][] matrix = Cam16.INSTANCE.getXYZ_TO_CAM16RGB();
            Intrinsics.checkNotNull(whitePoint);
            double rW = (whitePoint[0] * matrix[0][0]) + (whitePoint[1] * matrix[0][1]) + (whitePoint[2] * matrix[0][2]);
            double gW = (whitePoint[0] * matrix[1][0]) + (whitePoint[1] * matrix[1][1]) + (whitePoint[2] * matrix[1][2]);
            double bW = (whitePoint[0] * matrix[2][0]) + (whitePoint[1] * matrix[2][1]) + (whitePoint[2] * matrix[2][2]);
            double f = (surround / 10.0d) + 0.8d;
            if (f < 0.9d) {
                c = MathUtils.INSTANCE.lerp(0.525d, 0.59d, (f - 0.8d) * 10.0d);
            } else {
                c = MathUtils.INSTANCE.lerp(0.59d, 0.69d, (f - 0.9d) * 10.0d);
            }
            double d = MathUtils.INSTANCE.clampDouble(0.0d, 1.0d, discountingIlluminant ? 1.0d : (1.0d - (Math.exp(((-adaptingLuminance) - 42.0d) / 92.0d) * 0.2777777777777778d)) * f);
            double[] rgbD = {(((100.0d / rW) * d) + 1.0d) - d, (((100.0d / gW) * d) + 1.0d) - d, (((100.0d / bW) * d) + 1.0d) - d};
            double k = 1.0d / ((adaptingLuminance * 5.0d) + 1.0d);
            double k4 = k * k * k * k;
            double k4F = 1.0d - k4;
            double fl = (k4 * adaptingLuminance) + (0.1d * k4F * k4F * Math.cbrt(5.0d * adaptingLuminance));
            double n = ColorUtils.INSTANCE.yFromLstar(backgroundLstar2) / whitePoint[1];
            double z = Math.sqrt(n) + 1.48d;
            double nbb = 0.725d / Math.pow(n, 0.2d);
            double dPow = Math.pow(((rgbD[0] * fl) * rW) / 100.0d, 0.42d);
            double dPow2 = Math.pow(((rgbD[1] * fl) * gW) / 100.0d, 0.42d);
            double backgroundLstar3 = ((rgbD[2] * fl) * bW) / 100.0d;
            double[] rgbAFactors = {dPow, dPow2, Math.pow(backgroundLstar3, 0.42d)};
            double[] rgbA = {(rgbAFactors[0] * 400.0d) / (rgbAFactors[0] + 27.13d), (rgbAFactors[1] * 400.0d) / (rgbAFactors[1] + 27.13d), (rgbAFactors[2] * 400.0d) / (rgbAFactors[2] + 27.13d)};
            double aw = ((rgbA[0] * 2.0d) + rgbA[1] + (rgbA[2] * 0.05d)) * nbb;
            return new ViewingConditions(n, aw, nbb, nbb, c, f, rgbD, fl, Math.pow(fl, 0.25d), z, null);
        }

        public final ViewingConditions defaultWithBackgroundLstar(double lstar) {
            return make(ColorUtils.INSTANCE.whitePointD65(), (ColorUtils.INSTANCE.yFromLstar(50.0d) * 63.66197723675813d) / ((double) 100.0f), lstar, 2.0d, false);
        }
    }
}
