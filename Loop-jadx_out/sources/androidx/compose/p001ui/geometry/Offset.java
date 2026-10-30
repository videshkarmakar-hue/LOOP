package androidx.compose.p001ui.geometry;

import androidx.collection.FloatFloatPair$$ExternalSyntheticBackport0;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Offset.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 92\u00020\u0001:\u00019B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\b\u0012\u0010\u000bJ'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b \u0010\u000bJ\u000f\u0010!\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\"\u0010\u000bJ\u0010\u0010#\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u001bH\u0007¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b+\u0010,J\u001b\u0010-\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b.\u0010,J\u001e\u0010/\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u0010\u0019J\u001e\u00101\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u0010\u0019J\u000f\u00103\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u0016\u00107\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006:"}, m195d2 = {"Landroidx/compose/ui/geometry/Offset;", "", "packedValue", "", "constructor-impl", "(J)J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-dBAh8RU", "(JFF)J", "div", "operand", "div-tuRUvjQ", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "getDistance", "getDistance-impl", "getDistanceSquared", "getDistanceSquared-impl", "hashCode", "", "hashCode-impl", "(J)I", "isValid", "isValid-impl", "(J)Z", "minus", "minus-MK-Hz9U", "(JJ)J", "plus", "plus-MK-Hz9U", "rem", "rem-tuRUvjQ", "times", "times-tuRUvjQ", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-F1C5BW0", "Companion", "ui-geometry_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
public final class Offset {
    private final long packedValue;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = OffsetKt.Offset(0.0f, 0.0f);
    private static final long Infinite = OffsetKt.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    private static final long Unspecified = OffsetKt.Offset(Float.NaN, Float.NaN);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Offset m4038boximpl(long j) {
        return new Offset(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m4041constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4045equalsimpl(long j, Object obj) {
        return (obj instanceof Offset) && j == ((Offset) obj).getPackedValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4046equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getX$annotations() {
    }

    public static /* synthetic */ void getY$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4051hashCodeimpl(long j) {
        return FloatFloatPair$$ExternalSyntheticBackport0.m4m(j);
    }

    public boolean equals(Object obj) {
        return m4045equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m4051hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ Offset(long packedValue) {
        this.packedValue = packedValue;
    }

    /* JADX INFO: renamed from: getX-impl, reason: not valid java name */
    public static final float m4049getXimpl(long arg0) {
        boolean value$iv = arg0 != 9205357640488583168L;
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException("Offset is unspecified");
        }
        int bits$iv$iv = (int) (arg0 >> 32);
        return Float.intBitsToFloat(bits$iv$iv);
    }

    /* JADX INFO: renamed from: getY-impl, reason: not valid java name */
    public static final float m4050getYimpl(long arg0) {
        boolean value$iv = arg0 != 9205357640488583168L;
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException("Offset is unspecified");
        }
        int bits$iv$iv = (int) (4294967295L & arg0);
        return Float.intBitsToFloat(bits$iv$iv);
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m4039component1impl(long arg0) {
        return m4049getXimpl(arg0);
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m4040component2impl(long arg0) {
        return m4050getYimpl(arg0);
    }

    /* JADX INFO: renamed from: copy-dBAh8RU$default, reason: not valid java name */
    public static /* synthetic */ long m4043copydBAh8RU$default(long value$iv, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            int bits$iv$iv = (int) (value$iv >> 32);
            f = Float.intBitsToFloat(bits$iv$iv);
        }
        if ((i & 2) != 0) {
            int bits$iv$iv2 = (int) (4294967295L & value$iv);
            f2 = Float.intBitsToFloat(bits$iv$iv2);
        }
        return m4042copydBAh8RU(value$iv, f, f2);
    }

    /* JADX INFO: renamed from: copy-dBAh8RU, reason: not valid java name */
    public static final long m4042copydBAh8RU(long arg0, float x, float y) {
        return OffsetKt.Offset(x, y);
    }

    /* JADX INFO: compiled from: Offset.kt */
    @Metadata(m194d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R$\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, m195d2 = {"Landroidx/compose/ui/geometry/Offset$Companion;", "", "()V", "Infinite", "Landroidx/compose/ui/geometry/Offset;", "getInfinite-F1C5BW0$annotations", "getInfinite-F1C5BW0", "()J", "J", "Unspecified", "getUnspecified-F1C5BW0$annotations", "getUnspecified-F1C5BW0", "Zero", "getZero-F1C5BW0$annotations", "getZero-F1C5BW0", "ui-geometry_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getInfinite-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m4060getInfiniteF1C5BW0$annotations() {
        }

        /* JADX INFO: renamed from: getUnspecified-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m4061getUnspecifiedF1C5BW0$annotations() {
        }

        /* JADX INFO: renamed from: getZero-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m4062getZeroF1C5BW0$annotations() {
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZero-F1C5BW0, reason: not valid java name */
        public final long m4065getZeroF1C5BW0() {
            return Offset.Zero;
        }

        /* JADX INFO: renamed from: getInfinite-F1C5BW0, reason: not valid java name */
        public final long m4063getInfiniteF1C5BW0() {
            return Offset.Infinite;
        }

        /* JADX INFO: renamed from: getUnspecified-F1C5BW0, reason: not valid java name */
        public final long m4064getUnspecifiedF1C5BW0() {
            return Offset.Unspecified;
        }
    }

    /* JADX INFO: renamed from: isValid-impl, reason: not valid java name */
    public static final boolean m4052isValidimpl(long arg0) {
        long convertX = (arg0 >> 32) & InlineClassHelperKt.FloatNonFiniteMask;
        long convertY = InlineClassHelperKt.FloatNonFiniteMask & arg0;
        return convertX <= InlineClassHelperKt.FloatInfinityBase && convertY <= InlineClassHelperKt.FloatInfinityBase;
    }

    /* JADX INFO: renamed from: getDistance-impl, reason: not valid java name */
    public static final float m4047getDistanceimpl(long arg0) {
        boolean value$iv = arg0 != 9205357640488583168L;
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException("Offset is unspecified");
        }
        int bits$iv$iv = (int) (arg0 >> 32);
        float x = Float.intBitsToFloat(bits$iv$iv);
        int bits$iv$iv2 = (int) (4294967295L & arg0);
        float y = Float.intBitsToFloat(bits$iv$iv2);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: renamed from: getDistanceSquared-impl, reason: not valid java name */
    public static final float m4048getDistanceSquaredimpl(long arg0) {
        boolean value$iv = arg0 != 9205357640488583168L;
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException("Offset is unspecified");
        }
        int bits$iv$iv = (int) (arg0 >> 32);
        float x = Float.intBitsToFloat(bits$iv$iv);
        int bits$iv$iv2 = (int) (4294967295L & arg0);
        float y = Float.intBitsToFloat(bits$iv$iv2);
        return (x * x) + (y * y);
    }

    /* JADX INFO: renamed from: unaryMinus-F1C5BW0, reason: not valid java name */
    public static final long m4058unaryMinusF1C5BW0(long arg0) {
        boolean value$iv = arg0 != 9205357640488583168L;
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException("Offset is unspecified");
        }
        int bits$iv$iv = (int) (arg0 >> 32);
        int bits$iv$iv2 = (int) (4294967295L & arg0);
        return OffsetKt.Offset(-Float.intBitsToFloat(bits$iv$iv), -Float.intBitsToFloat(bits$iv$iv2));
    }

    /* JADX INFO: renamed from: minus-MK-Hz9U, reason: not valid java name */
    public static final long m4053minusMKHz9U(long arg0, long other) {
        boolean value$iv = (arg0 == 9205357640488583168L || other == 9205357640488583168L) ? false : true;
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException("Offset is unspecified");
        }
        int bits$iv$iv = (int) (arg0 >> 32);
        int bits$iv$iv2 = (int) (other >> 32);
        float fIntBitsToFloat = Float.intBitsToFloat(bits$iv$iv) - Float.intBitsToFloat(bits$iv$iv2);
        int bits$iv$iv3 = (int) (arg0 & 4294967295L);
        int bits$iv$iv4 = (int) (4294967295L & other);
        return OffsetKt.Offset(fIntBitsToFloat, Float.intBitsToFloat(bits$iv$iv3) - Float.intBitsToFloat(bits$iv$iv4));
    }

    /* JADX INFO: renamed from: plus-MK-Hz9U, reason: not valid java name */
    public static final long m4054plusMKHz9U(long arg0, long other) {
        boolean value$iv = (arg0 == 9205357640488583168L || other == 9205357640488583168L) ? false : true;
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException("Offset is unspecified");
        }
        int bits$iv$iv = (int) (arg0 >> 32);
        int bits$iv$iv2 = (int) (other >> 32);
        float fIntBitsToFloat = Float.intBitsToFloat(bits$iv$iv) + Float.intBitsToFloat(bits$iv$iv2);
        int bits$iv$iv3 = (int) (arg0 & 4294967295L);
        int bits$iv$iv4 = (int) (4294967295L & other);
        return OffsetKt.Offset(fIntBitsToFloat, Float.intBitsToFloat(bits$iv$iv3) + Float.intBitsToFloat(bits$iv$iv4));
    }

    /* JADX INFO: renamed from: times-tuRUvjQ, reason: not valid java name */
    public static final long m4056timestuRUvjQ(long arg0, float operand) {
        boolean value$iv = arg0 != 9205357640488583168L;
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException("Offset is unspecified");
        }
        int bits$iv$iv = (int) (arg0 >> 32);
        int bits$iv$iv2 = (int) (4294967295L & arg0);
        return OffsetKt.Offset(Float.intBitsToFloat(bits$iv$iv) * operand, Float.intBitsToFloat(bits$iv$iv2) * operand);
    }

    /* JADX INFO: renamed from: div-tuRUvjQ, reason: not valid java name */
    public static final long m4044divtuRUvjQ(long arg0, float operand) {
        boolean value$iv = arg0 != 9205357640488583168L;
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException("Offset is unspecified");
        }
        int bits$iv$iv = (int) (arg0 >> 32);
        int bits$iv$iv2 = (int) (4294967295L & arg0);
        return OffsetKt.Offset(Float.intBitsToFloat(bits$iv$iv) / operand, Float.intBitsToFloat(bits$iv$iv2) / operand);
    }

    /* JADX INFO: renamed from: rem-tuRUvjQ, reason: not valid java name */
    public static final long m4055remtuRUvjQ(long arg0, float operand) {
        boolean value$iv = arg0 != 9205357640488583168L;
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException("Offset is unspecified");
        }
        int bits$iv$iv = (int) (arg0 >> 32);
        int bits$iv$iv2 = (int) (4294967295L & arg0);
        return OffsetKt.Offset(Float.intBitsToFloat(bits$iv$iv) % operand, Float.intBitsToFloat(bits$iv$iv2) % operand);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4057toStringimpl(long arg0) {
        if (OffsetKt.m4068isSpecifiedk4lQ0M(arg0)) {
            return "Offset(" + GeometryUtilsKt.toStringAsFixed(m4049getXimpl(arg0), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m4050getYimpl(arg0), 1) + ')';
        }
        return "Offset.Unspecified";
    }

    public String toString() {
        return m4057toStringimpl(this.packedValue);
    }
}
