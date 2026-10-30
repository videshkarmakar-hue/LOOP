package androidx.compose.ui.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.math.MathKt;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: compiled from: MathHelpers.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a)\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\b\u001a)\u0010\b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\b\u001a\u001e\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001\u001a\u001e\u0010\t\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0001\u001a\u001e\u0010\t\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0001\u001a\u0015\u0010\u000f\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0086\b\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\u0012\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0086\b\u001a\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001H\u0086\b\u001a\u001d\u0010\u0014\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0086\b\u001a\u001d\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001H\u0086\b¨\u0006\u0015"}, d2 = {"fastCbrt", "", "x", "fastMaxOf", "a", "b", "c", "d", "fastMinOf", "lerp", "start", "stop", "fraction", "", "", "fastCoerceAtLeast", "", "minimumValue", "fastCoerceAtMost", "maximumValue", "fastCoerceIn", "ui-util_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MathHelpersKt {
    public static final float lerp(float start, float stop, float fraction) {
        return ((1 - fraction) * start) + (fraction * stop);
    }

    public static final int lerp(int start, int stop, float fraction) {
        double $this$fastRoundToInt$iv = ((double) (stop - start)) * ((double) fraction);
        return ((int) Math.round($this$fastRoundToInt$iv)) + start;
    }

    public static final long lerp(long start, long stop, float fraction) {
        return MathKt.roundToLong((stop - start) * ((double) fraction)) + start;
    }

    public static final float fastMinOf(float a, float b, float c, float d) {
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }

    public static final float fastMaxOf(float a, float b, float c, float d) {
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }

    public static final float fastCoerceIn(float $this$fastCoerceIn, float minimumValue, float maximumValue) {
        float $this$fastCoerceAtLeast$iv = $this$fastCoerceIn;
        if ($this$fastCoerceAtLeast$iv < minimumValue) {
            $this$fastCoerceAtLeast$iv = minimumValue;
        }
        return $this$fastCoerceAtLeast$iv > maximumValue ? maximumValue : $this$fastCoerceAtLeast$iv;
    }

    public static final float fastCoerceAtLeast(float $this$fastCoerceAtLeast, float minimumValue) {
        return $this$fastCoerceAtLeast < minimumValue ? minimumValue : $this$fastCoerceAtLeast;
    }

    public static final float fastCoerceAtMost(float $this$fastCoerceAtMost, float maximumValue) {
        return $this$fastCoerceAtMost > maximumValue ? maximumValue : $this$fastCoerceAtMost;
    }

    public static final double fastCoerceIn(double $this$fastCoerceIn, double minimumValue, double maximumValue) {
        double $this$fastCoerceAtLeast$iv = $this$fastCoerceIn;
        if ($this$fastCoerceAtLeast$iv < minimumValue) {
            $this$fastCoerceAtLeast$iv = minimumValue;
        }
        return $this$fastCoerceAtLeast$iv > maximumValue ? maximumValue : $this$fastCoerceAtLeast$iv;
    }

    public static final double fastCoerceAtLeast(double $this$fastCoerceAtLeast, double minimumValue) {
        return $this$fastCoerceAtLeast < minimumValue ? minimumValue : $this$fastCoerceAtLeast;
    }

    public static final double fastCoerceAtMost(double $this$fastCoerceAtMost, double maximumValue) {
        return $this$fastCoerceAtMost > maximumValue ? maximumValue : $this$fastCoerceAtMost;
    }

    public static final float fastCbrt(float x) {
        long v = ((long) Float.floatToRawIntBits(x)) & TarConstants.MAXSIZE;
        int bits$iv = ((int) (v / ((long) 3))) + 709952852;
        float estimate = Float.intBitsToFloat(bits$iv);
        float estimate2 = estimate - ((estimate - (x / (estimate * estimate))) * 0.33333334f);
        return estimate2 - ((estimate2 - (x / (estimate2 * estimate2))) * 0.33333334f);
    }
}
