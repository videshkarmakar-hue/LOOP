package androidx.compose.ui.unit;

import androidx.collection.FloatFloatPair$$ExternalSyntheticBackport0;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Constraints.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 02\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J;\u0010#\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b+\u0010\tJ\u000f\u0010,\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/R\u0015\u0010\u0006\u001a\u00020\u00078Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\rR\u0011\u0010\u001a\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\tR\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\tR\u0011\u0010\u001e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\tR\u0011\u0010 \u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b!\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u0012\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"Landroidx/compose/ui/unit/Constraints;", "", DownloadUtil.CookieScheme.VALUE, "", "constructor-impl", "(J)J", "focusIndex", "", "getFocusIndex-impl", "(J)I", "hasBoundedHeight", "", "getHasBoundedHeight-impl", "(J)Z", "hasBoundedWidth", "getHasBoundedWidth-impl", "hasFixedHeight", "getHasFixedHeight$annotations", "()V", "getHasFixedHeight-impl", "hasFixedWidth", "getHasFixedWidth$annotations", "getHasFixedWidth-impl", "isZero", "isZero$annotations", "isZero-impl", "maxHeight", "getMaxHeight-impl", "maxWidth", "getMaxWidth-impl", "minHeight", "getMinHeight-impl", "minWidth", "getMinWidth-impl", "getValue$annotations", "copy", "copy-Zbe2FdA", "(JIIII)J", "equals", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
public final class Constraints {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int Infinity = Integer.MAX_VALUE;
    private final long value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Constraints m6484boximpl(long j) {
        return new Constraints(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m6485constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6488equalsimpl(long j, Object obj) {
        return (obj instanceof Constraints) && j == ((Constraints) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6489equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getHasFixedHeight$annotations() {
    }

    public static /* synthetic */ void getHasFixedWidth$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6499hashCodeimpl(long j) {
        return FloatFloatPair$$ExternalSyntheticBackport0.m(j);
    }

    public static /* synthetic */ void isZero$annotations() {
    }

    public boolean equals(Object obj) {
        return m6488equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6499hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getValue() {
        return this.value;
    }

    private /* synthetic */ Constraints(long value) {
        this.value = value;
    }

    /* JADX INFO: renamed from: getFocusIndex-impl, reason: not valid java name */
    private static final int m6490getFocusIndeximpl(long arg0) {
        return (int) (3 & arg0);
    }

    /* JADX INFO: renamed from: getMinWidth-impl, reason: not valid java name */
    public static final int m6498getMinWidthimpl(long arg0) {
        int i = (int) (3 & arg0);
        int bitOffset$iv = ((i & 1) << 1) + (((i & 2) >> 1) * 3);
        int mask = (1 << (bitOffset$iv + 13)) - 1;
        return ((int) (arg0 >> 2)) & mask;
    }

    /* JADX INFO: renamed from: getMaxWidth-impl, reason: not valid java name */
    public static final int m6496getMaxWidthimpl(long arg0) {
        int i = (int) (3 & arg0);
        int bitOffset$iv = ((i & 1) << 1) + (((i & 2) >> 1) * 3);
        int mask = (1 << (bitOffset$iv + 13)) - 1;
        int width = ((int) (arg0 >> 33)) & mask;
        if (width == 0) {
            return Integer.MAX_VALUE;
        }
        return width - 1;
    }

    /* JADX INFO: renamed from: getMinHeight-impl, reason: not valid java name */
    public static final int m6497getMinHeightimpl(long arg0) {
        int i = (int) (3 & arg0);
        int bitOffset = ((i & 1) << 1) + (((i & 2) >> 1) * 3);
        int mask = (1 << (18 - bitOffset)) - 1;
        int $i$f$minHeightOffsets = bitOffset + 15;
        return ((int) (arg0 >> $i$f$minHeightOffsets)) & mask;
    }

    /* JADX INFO: renamed from: getMaxHeight-impl, reason: not valid java name */
    public static final int m6495getMaxHeightimpl(long arg0) {
        int i = (int) (3 & arg0);
        int bitOffset = ((i & 1) << 1) + (((i & 2) >> 1) * 3);
        int mask = (1 << (18 - bitOffset)) - 1;
        int $i$f$minHeightOffsets = bitOffset + 15;
        int offset = $i$f$minHeightOffsets + 31;
        int height = ((int) (arg0 >> offset)) & mask;
        if (height == 0) {
            return Integer.MAX_VALUE;
        }
        return height - 1;
    }

    /* JADX INFO: renamed from: getHasBoundedWidth-impl, reason: not valid java name */
    public static final boolean m6492getHasBoundedWidthimpl(long arg0) {
        int i = (int) (3 & arg0);
        int bitOffset$iv = ((i & 1) << 1) + (((i & 2) >> 1) * 3);
        int mask = (1 << (bitOffset$iv + 13)) - 1;
        return (((int) (arg0 >> 33)) & mask) != 0;
    }

    /* JADX INFO: renamed from: getHasBoundedHeight-impl, reason: not valid java name */
    public static final boolean m6491getHasBoundedHeightimpl(long arg0) {
        int i = (int) (3 & arg0);
        int bitOffset = ((i & 1) << 1) + (((i & 2) >> 1) * 3);
        int mask = (1 << (18 - bitOffset)) - 1;
        int $i$f$minHeightOffsets = bitOffset + 15;
        int offset = $i$f$minHeightOffsets + 31;
        return (((int) (arg0 >> offset)) & mask) != 0;
    }

    /* JADX INFO: renamed from: getHasFixedWidth-impl, reason: not valid java name */
    public static final boolean m6494getHasFixedWidthimpl(long arg0) {
        int i = (int) (3 & arg0);
        int bitOffset$iv = ((i & 1) << 1) + (((i & 2) >> 1) * 3);
        int mask = (1 << (bitOffset$iv + 13)) - 1;
        int minWidth = ((int) (arg0 >> 2)) & mask;
        int it = ((int) (arg0 >> 33)) & mask;
        return minWidth == (it == 0 ? Integer.MAX_VALUE : it + (-1));
    }

    /* JADX INFO: renamed from: getHasFixedHeight-impl, reason: not valid java name */
    public static final boolean m6493getHasFixedHeightimpl(long arg0) {
        int i = (int) (3 & arg0);
        int bitOffset = ((i & 1) << 1) + (((i & 2) >> 1) * 3);
        int mask = (1 << (18 - bitOffset)) - 1;
        int $i$f$minHeightOffsets = bitOffset + 15;
        int minHeight = ((int) (arg0 >> $i$f$minHeightOffsets)) & mask;
        int it = ((int) (arg0 >> ($i$f$minHeightOffsets + 31))) & mask;
        return minHeight == (it == 0 ? Integer.MAX_VALUE : it + (-1));
    }

    /* JADX INFO: renamed from: isZero-impl, reason: not valid java name */
    public static final boolean m6500isZeroimpl(long arg0) {
        int i = (int) (3 & arg0);
        int bitOffset = ((i & 1) << 1) + (((i & 2) >> 1) * 3);
        int $i$f$widthMask = ((int) (arg0 >> 33)) & ((1 << (bitOffset + 13)) - 1);
        int maxWidth = $i$f$widthMask - 1;
        if (maxWidth == 0) {
            return true;
        }
        int $i$f$minHeightOffsets = bitOffset + 15;
        int offset = $i$f$minHeightOffsets + 31;
        int $i$f$heightMask = ((int) (arg0 >> offset)) & ((1 << (18 - bitOffset)) - 1);
        int maxHeight = $i$f$heightMask - 1;
        return maxHeight == 0;
    }

    /* JADX INFO: renamed from: copy-Zbe2FdA, reason: not valid java name */
    public static final long m6486copyZbe2FdA(long arg0, int minWidth, int maxWidth, int minHeight, int maxHeight) {
        boolean value$iv = minHeight >= 0 && minWidth >= 0;
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalArgumentException("minHeight(" + minHeight + ") and minWidth(" + minWidth + ") must be >= 0");
        }
        boolean value$iv2 = maxWidth >= minWidth;
        if (!value$iv2) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth(" + maxWidth + ") must be >= minWidth(" + minWidth + ')');
        }
        boolean value$iv3 = maxHeight >= minHeight;
        if (!value$iv3) {
            InlineClassHelperKt.throwIllegalArgumentException("maxHeight(" + maxHeight + ") must be >= minHeight(" + minHeight + ')');
        }
        return ConstraintsKt.createConstraints(minWidth, maxWidth, minHeight, maxHeight);
    }

    public String toString() {
        return m6501toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6501toStringimpl(long arg0) {
        int maxWidth = m6496getMaxWidthimpl(arg0);
        String maxWidthStr = maxWidth == Integer.MAX_VALUE ? "Infinity" : String.valueOf(maxWidth);
        int maxHeight = m6495getMaxHeightimpl(arg0);
        String maxHeightStr = maxHeight != Integer.MAX_VALUE ? String.valueOf(maxHeight) : "Infinity";
        return "Constraints(minWidth = " + m6498getMinWidthimpl(arg0) + ", maxWidth = " + maxWidthStr + ", minHeight = " + m6497getMinHeightimpl(arg0) + ", maxHeight = " + maxHeightStr + ')';
    }

    /* JADX INFO: compiled from: Constraints.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ5\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\fJ%\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0016J?\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/unit/Constraints$Companion;", "", "()V", "Infinity", "", "fitPrioritizingHeight", "Landroidx/compose/ui/unit/Constraints;", "minWidth", "maxWidth", "minHeight", "maxHeight", "fitPrioritizingHeight-Zbe2FdA", "(IIII)J", "fitPrioritizingWidth", "fitPrioritizingWidth-Zbe2FdA", "fixed", "width", "height", "fixed-JhjzzOo", "(II)J", "fixedHeight", "fixedHeight-OenEA2s", "(I)J", "fixedWidth", "fixedWidth-OenEA2s", "restrictConstraints", "prioritizeWidth", "", "restrictConstraints-xF2OJ5Q", "(IIIIZ)J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: fixed-JhjzzOo, reason: not valid java name */
        public final long m6506fixedJhjzzOo(int width, int height) {
            boolean value$iv = width >= 0 && height >= 0;
            if (!value$iv) {
                InlineClassHelperKt.throwIllegalArgumentException("width(" + width + ") and height(" + height + ") must be >= 0");
            }
            return ConstraintsKt.createConstraints(width, width, height, height);
        }

        /* JADX INFO: renamed from: fixedWidth-OenEA2s, reason: not valid java name */
        public final long m6508fixedWidthOenEA2s(int width) {
            boolean value$iv = width >= 0;
            if (!value$iv) {
                InlineClassHelperKt.throwIllegalArgumentException("width(" + width + ") must be >= 0");
            }
            return ConstraintsKt.createConstraints(width, width, 0, Integer.MAX_VALUE);
        }

        /* JADX INFO: renamed from: fixedHeight-OenEA2s, reason: not valid java name */
        public final long m6507fixedHeightOenEA2s(int height) {
            boolean value$iv = height >= 0;
            if (!value$iv) {
                InlineClassHelperKt.throwIllegalArgumentException("height(" + height + ") must be >= 0");
            }
            return ConstraintsKt.createConstraints(0, Integer.MAX_VALUE, height, height);
        }

        @Deprecated(message = "Replace with fitPrioritizingWidth", replaceWith = @ReplaceWith(expression = "Constraints.fitPrioritizingWidth(minWidth, maxWidth, minHeight, maxHeight)", imports = {}))
        /* JADX INFO: renamed from: restrictConstraints-xF2OJ5Q, reason: not valid java name */
        public final long m6509restrictConstraintsxF2OJ5Q(int minWidth, int maxWidth, int minHeight, int maxHeight, boolean prioritizeWidth) {
            if (prioritizeWidth) {
                return m6505fitPrioritizingWidthZbe2FdA(minWidth, maxWidth, minHeight, maxHeight);
            }
            return m6504fitPrioritizingHeightZbe2FdA(minWidth, maxWidth, minHeight, maxHeight);
        }

        /* JADX INFO: renamed from: fitPrioritizingWidth-Zbe2FdA, reason: not valid java name */
        public final long m6505fitPrioritizingWidthZbe2FdA(int minWidth, int maxWidth, int minHeight, int maxHeight) {
            int maxW;
            int minW = Math.min(minWidth, 262142);
            if (maxWidth == Integer.MAX_VALUE) {
                maxW = Integer.MAX_VALUE;
            } else {
                maxW = Math.min(maxWidth, 262142);
            }
            int consumed = maxW == Integer.MAX_VALUE ? minW : maxW;
            int maxAllowed = ConstraintsKt.maxAllowedForSize(consumed);
            int maxH = maxHeight != Integer.MAX_VALUE ? Math.min(maxAllowed, maxHeight) : Integer.MAX_VALUE;
            int minH = Math.min(maxAllowed, minHeight);
            return ConstraintsKt.Constraints(minW, maxW, minH, maxH);
        }

        /* JADX INFO: renamed from: fitPrioritizingHeight-Zbe2FdA, reason: not valid java name */
        public final long m6504fitPrioritizingHeightZbe2FdA(int minWidth, int maxWidth, int minHeight, int maxHeight) {
            int maxH;
            int minH = Math.min(minHeight, 262142);
            if (maxHeight == Integer.MAX_VALUE) {
                maxH = Integer.MAX_VALUE;
            } else {
                maxH = Math.min(maxHeight, 262142);
            }
            int consumed = maxH == Integer.MAX_VALUE ? minH : maxH;
            int maxAllowed = ConstraintsKt.maxAllowedForSize(consumed);
            int maxW = maxWidth != Integer.MAX_VALUE ? Math.min(maxAllowed, maxWidth) : Integer.MAX_VALUE;
            int minW = Math.min(maxAllowed, minWidth);
            return ConstraintsKt.Constraints(minW, maxW, minH, maxH);
        }
    }
}
