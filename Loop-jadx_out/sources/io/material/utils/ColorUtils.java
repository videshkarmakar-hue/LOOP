package io.material.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

/* JADX INFO: compiled from: ColorUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m194d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0013\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u001e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J\u0010\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0013J\u001e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fJ\u001e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0013J\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u0013J\u000e\u0010%\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010&\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0013J\u000e\u0010*\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0013J\u000e\u0010-\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u000fJ\u000e\u0010.\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010/\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0013J\u000e\u00100\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u00101\u001a\u00020\u0005J\u0010\u00102\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u00103\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\r\u0010\u0007¨\u00064"}, m195d2 = {"Lio/material/utils/ColorUtils;", "", "()V", "SRGB_TO_XYZ", "", "", "getSRGB_TO_XYZ", "()[[D", "[[D", "WHITE_POINT_D65", "getWHITE_POINT_D65", "()[D", "XYZ_TO_SRGB", "getXYZ_TO_SRGB", "alphaFromArgb", "", "argb", "argbFromLab", "l", "", "a", "b", "argbFromLinrgb", "linrgb", "argbFromLstar", "lstar", "argbFromRgb", "red", "green", "blue", "argbFromXyz", "x", "y", CompressorStreamFactory.f581Z, "blueFromArgb", "delinearized", "rgbComponent", "greenFromArgb", "isOpaque", "", "labF", "t", "labFromArgb", "labInvf", "ft", "linearized", "lstarFromArgb", "lstarFromY", "redFromArgb", "whitePointD65", "xyzFromArgb", "yFromLstar", "color_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ColorUtils {
    public static final ColorUtils INSTANCE = new ColorUtils();
    private static final double[][] SRGB_TO_XYZ = {new double[]{0.41233895d, 0.35762064d, 0.18051042d}, new double[]{0.2126d, 0.7152d, 0.0722d}, new double[]{0.01932141d, 0.11916382d, 0.95034478d}};
    private static final double[][] XYZ_TO_SRGB = {new double[]{3.2413774792388685d, -1.5376652402851851d, -0.49885366846268053d}, new double[]{-0.9691452513005321d, 1.8758853451067872d, 0.04156585616912061d}, new double[]{0.05562093689691305d, -0.20395524564742123d, 1.0571799111220335d}};
    private static final double[] WHITE_POINT_D65 = {95.047d, 100.0d, 108.883d};
    public static final int $stable = 8;

    private ColorUtils() {
    }

    public final double[][] getSRGB_TO_XYZ() {
        return SRGB_TO_XYZ;
    }

    public final double[][] getXYZ_TO_SRGB() {
        return XYZ_TO_SRGB;
    }

    public final double[] getWHITE_POINT_D65() {
        return WHITE_POINT_D65;
    }

    public final int argbFromRgb(int red, int green, int blue) {
        return ((red & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((green & 255) << 8) | (blue & 255);
    }

    public final int argbFromLinrgb(double[] linrgb) {
        Intrinsics.checkNotNull(linrgb);
        int r = delinearized(linrgb[0]);
        int g = delinearized(linrgb[1]);
        int b = delinearized(linrgb[2]);
        return argbFromRgb(r, g, b);
    }

    public final int alphaFromArgb(int argb) {
        return (argb >> 24) & 255;
    }

    public final int redFromArgb(int argb) {
        return (argb >> 16) & 255;
    }

    public final int greenFromArgb(int argb) {
        return (argb >> 8) & 255;
    }

    public final int blueFromArgb(int argb) {
        return argb & 255;
    }

    public final boolean isOpaque(int argb) {
        return alphaFromArgb(argb) >= 255;
    }

    public final int argbFromXyz(double x, double y, double z) {
        double[][] matrix = XYZ_TO_SRGB;
        double linearR = (matrix[0][0] * x) + (matrix[0][1] * y) + (matrix[0][2] * z);
        double linearG = (matrix[1][0] * x) + (matrix[1][1] * y) + (matrix[1][2] * z);
        double linearB = (matrix[2][0] * x) + (matrix[2][1] * y) + (matrix[2][2] * z);
        int r = delinearized(linearR);
        int g = delinearized(linearG);
        int b = delinearized(linearB);
        return argbFromRgb(r, g, b);
    }

    public final double[] xyzFromArgb(int argb) {
        double r = linearized(redFromArgb(argb));
        double g = linearized(greenFromArgb(argb));
        double b = linearized(blueFromArgb(argb));
        return MathUtils.INSTANCE.matrixMultiply(new double[]{r, g, b}, SRGB_TO_XYZ);
    }

    public final int argbFromLab(double l, double a, double b) {
        double[] whitePoint = WHITE_POINT_D65;
        double fy = (l + 16.0d) / 116.0d;
        double fx = (a / 500.0d) + fy;
        double fz = fy - (b / 200.0d);
        double xNormalized = labInvf(fx);
        double yNormalized = labInvf(fy);
        double zNormalized = labInvf(fz);
        double x = xNormalized * whitePoint[0];
        double y = yNormalized * whitePoint[1];
        double z = zNormalized * whitePoint[2];
        return argbFromXyz(x, y, z);
    }

    public final double[] labFromArgb(int argb) {
        double linearR = linearized(redFromArgb(argb));
        double linearG = linearized(greenFromArgb(argb));
        double linearB = linearized(blueFromArgb(argb));
        double[][] matrix = SRGB_TO_XYZ;
        double x = (matrix[0][0] * linearR) + (matrix[0][1] * linearG) + (matrix[0][2] * linearB);
        double y = (matrix[1][0] * linearR) + (matrix[1][1] * linearG) + (matrix[1][2] * linearB);
        double z = (matrix[2][0] * linearR) + (matrix[2][1] * linearG) + (matrix[2][2] * linearB);
        double[] whitePoint = WHITE_POINT_D65;
        double xNormalized = x / whitePoint[0];
        double yNormalized = y / whitePoint[1];
        double zNormalized = z / whitePoint[2];
        double fx = labF(xNormalized);
        double fy = labF(yNormalized);
        double fz = labF(zNormalized);
        double l = (116.0d * fy) - ((double) 16);
        double a = (fx - fy) * 500.0d;
        double b = (fy - fz) * 200.0d;
        return new double[]{l, a, b};
    }

    public final int argbFromLstar(double lstar) {
        double y = yFromLstar(lstar);
        int component = delinearized(y);
        return argbFromRgb(component, component, component);
    }

    public final double lstarFromArgb(int argb) {
        double[] dArrXyzFromArgb = xyzFromArgb(argb);
        Intrinsics.checkNotNull(dArrXyzFromArgb);
        double y = dArrXyzFromArgb[1];
        return (labF(y / 100.0d) * 116.0d) - 16.0d;
    }

    public final double yFromLstar(double lstar) {
        return labInvf((16.0d + lstar) / 116.0d) * 100.0d;
    }

    public final double lstarFromY(double y) {
        return (labF(y / 100.0d) * 116.0d) - 16.0d;
    }

    public final double linearized(int rgbComponent) {
        double normalized = ((double) rgbComponent) / 255.0d;
        if (normalized <= 0.040449936d) {
            return (normalized / 12.92d) * 100.0d;
        }
        return Math.pow((0.055d + normalized) / 1.055d, 2.4d) * 100.0d;
    }

    public final int delinearized(double rgbComponent) {
        double dPow;
        double normalized = rgbComponent / 100.0d;
        if (normalized <= 0.0031308d) {
            dPow = 12.92d * normalized;
        } else {
            dPow = (Math.pow(normalized, 0.4166666666666667d) * 1.055d) - 0.055d;
        }
        double delinearized = dPow;
        return MathUtils.INSTANCE.clampInt(0, 255, (int) MathKt.roundToLong(255.0d * delinearized));
    }

    public final double[] whitePointD65() {
        return WHITE_POINT_D65;
    }

    public final double labF(double t) {
        if (t > 0.008856451679035631d) {
            return Math.pow(t, 0.3333333333333333d);
        }
        return ((903.2962962962963d * t) + ((double) 16)) / ((double) 116);
    }

    public final double labInvf(double ft) {
        double ft3 = ft * ft * ft;
        if (ft3 <= 0.008856451679035631d) {
            return ((((double) 116) * ft) - ((double) 16)) / 903.2962962962963d;
        }
        return ft3;
    }
}
