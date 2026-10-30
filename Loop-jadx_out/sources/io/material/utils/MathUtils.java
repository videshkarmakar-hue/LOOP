package io.material.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MathUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u001e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004J!\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0015¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tJ\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0004¨\u0006\u001f"}, m195d2 = {"Lio/material/utils/MathUtils;", "", "()V", "clampDouble", "", "min", "max", "input", "clampInt", "", "differenceDegrees", "a", "b", "lerp", "start", "stop", "amount", "matrixMultiply", "", "row", "matrix", "", "([D[[D)[D", "rotationDirection", "from", "to", "sanitizeDegreesDouble", "degrees", "sanitizeDegreesInt", "signum", "num", "color_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MathUtils {
    public static final int $stable = 0;
    public static final MathUtils INSTANCE = new MathUtils();

    private MathUtils() {
    }

    public final int signum(double num) {
        if (num < 0.0d) {
            return -1;
        }
        if (num == 0.0d) {
            return 0;
        }
        return 1;
    }

    public final double lerp(double start, double stop, double amount) {
        return ((1.0d - amount) * start) + (amount * stop);
    }

    public final int clampInt(int min, int max, int input) {
        if (input < min) {
            return min;
        }
        if (input > max) {
            return max;
        }
        return input;
    }

    public final double clampDouble(double min, double max, double input) {
        if (input < min) {
            return min;
        }
        if (input > max) {
            return max;
        }
        return input;
    }

    public final int sanitizeDegreesInt(int degrees) {
        int degrees2 = degrees % 360;
        if (degrees2 < 0) {
            return degrees2 + 360;
        }
        return degrees2;
    }

    public final double sanitizeDegreesDouble(double degrees) {
        double degrees2 = degrees % 360.0d;
        if (degrees2 < 0.0d) {
            return degrees2 + 360.0d;
        }
        return degrees2;
    }

    public final double rotationDirection(double from, double to) {
        double increasingDifference = sanitizeDegreesDouble(to - from);
        return increasingDifference <= 180.0d ? 1.0d : -1.0d;
    }

    public final double differenceDegrees(double a, double b) {
        return 180.0d - Math.abs(Math.abs(a - b) - 180.0d);
    }

    public final double[] matrixMultiply(double[] row, double[][] matrix) {
        Intrinsics.checkNotNullParameter(row, "row");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        double a = (row[0] * matrix[0][0]) + (row[1] * matrix[0][1]) + (row[2] * matrix[0][2]);
        double b = (row[0] * matrix[1][0]) + (row[1] * matrix[1][1]) + (row[2] * matrix[1][2]);
        double c = (row[0] * matrix[2][0]) + (row[1] * matrix[2][1]) + (row[2] * matrix[2][2]);
        return new double[]{a, b, c};
    }
}
