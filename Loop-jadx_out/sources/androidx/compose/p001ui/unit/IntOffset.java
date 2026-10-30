package androidx.compose.p001ui.unit;

import androidx.collection.FloatFloatPair$$ExternalSyntheticBackport0;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IntOffset.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 32\u00020\u0001:\u00013B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0011\u0010\fJ\u0010\u0010\u0012\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0013\u0010\fJ'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\"\u0010\fJ\u001b\u0010#\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\u0087\nø\u0001\u0001¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\u0087\nø\u0001\u0001¢\u0006\u0004\b'\u0010%J\u001e\u0010(\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J\u001e\u0010+\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010\u001bJ\u000f\u0010-\u001a\u00020.H\u0017¢\u0006\u0004\b/\u00100J\u0016\u00101\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\f\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00064"}, m195d2 = {"Landroidx/compose/ui/unit/IntOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "x", "", "getX$annotations", "getX-impl", "(J)I", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-iSbpLlY", "(JII)J", "div", "operand", "", "div-Bjo55l4", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "minus", "minus-qkQi6aY", "(JJ)J", "plus", "plus-qkQi6aY", "rem", "rem-Bjo55l4", "(JI)J", "times", "times-Bjo55l4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-nOcc-ac", "Companion", "ui-unit_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
public final class IntOffset {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = IntOffsetKt.IntOffset(0, 0);
    private final long packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntOffset m6924boximpl(long j) {
        return new IntOffset(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m6927constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6931equalsimpl(long j, Object obj) {
        return (obj instanceof IntOffset) && j == ((IntOffset) obj).getPackedValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6932equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    public static /* synthetic */ void getX$annotations() {
    }

    public static /* synthetic */ void getY$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6935hashCodeimpl(long j) {
        return FloatFloatPair$$ExternalSyntheticBackport0.m4m(j);
    }

    public boolean equals(Object obj) {
        return m6931equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m6935hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ IntOffset(long packedValue) {
        this.packedValue = packedValue;
    }

    /* JADX INFO: renamed from: getX-impl, reason: not valid java name */
    public static final int m6933getXimpl(long arg0) {
        return (int) (arg0 >> 32);
    }

    /* JADX INFO: renamed from: getY-impl, reason: not valid java name */
    public static final int m6934getYimpl(long arg0) {
        return (int) (4294967295L & arg0);
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final int m6925component1impl(long arg0) {
        return m6933getXimpl(arg0);
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final int m6926component2impl(long arg0) {
        return m6934getYimpl(arg0);
    }

    /* JADX INFO: renamed from: copy-iSbpLlY, reason: not valid java name */
    public static final long m6928copyiSbpLlY(long arg0, int x, int y) {
        return IntOffsetKt.IntOffset(x, y);
    }

    /* JADX INFO: renamed from: copy-iSbpLlY$default, reason: not valid java name */
    public static /* synthetic */ long m6929copyiSbpLlY$default(long value$iv, int $i$f$unpackInt1, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            $i$f$unpackInt1 = (int) (value$iv >> 32);
        }
        if ((i2 & 2) != 0) {
            i = (int) (4294967295L & value$iv);
        }
        return m6928copyiSbpLlY(value$iv, $i$f$unpackInt1, i);
    }

    /* JADX INFO: renamed from: minus-qkQi6aY, reason: not valid java name */
    public static final long m6936minusqkQi6aY(long arg0, long other) {
        return IntOffsetKt.IntOffset(((int) (arg0 >> 32)) - ((int) (other >> 32)), ((int) (arg0 & 4294967295L)) - ((int) (4294967295L & other)));
    }

    /* JADX INFO: renamed from: plus-qkQi6aY, reason: not valid java name */
    public static final long m6937plusqkQi6aY(long arg0, long other) {
        return IntOffsetKt.IntOffset(((int) (arg0 >> 32)) + ((int) (other >> 32)), ((int) (arg0 & 4294967295L)) + ((int) (4294967295L & other)));
    }

    /* JADX INFO: renamed from: unaryMinus-nOcc-ac, reason: not valid java name */
    public static final long m6941unaryMinusnOccac(long arg0) {
        return IntOffsetKt.IntOffset(-((int) (arg0 >> 32)), -((int) (4294967295L & arg0)));
    }

    /* JADX INFO: renamed from: times-Bjo55l4, reason: not valid java name */
    public static final long m6939timesBjo55l4(long arg0, float operand) {
        float $this$fastRoundToInt$iv = ((int) (arg0 >> 32)) * operand;
        float $this$fastRoundToInt$iv2 = ((int) (4294967295L & arg0)) * operand;
        return IntOffsetKt.IntOffset(Math.round($this$fastRoundToInt$iv), Math.round($this$fastRoundToInt$iv2));
    }

    /* JADX INFO: renamed from: div-Bjo55l4, reason: not valid java name */
    public static final long m6930divBjo55l4(long arg0, float operand) {
        float $this$fastRoundToInt$iv = ((int) (arg0 >> 32)) / operand;
        float $this$fastRoundToInt$iv2 = ((int) (4294967295L & arg0)) / operand;
        return IntOffsetKt.IntOffset(Math.round($this$fastRoundToInt$iv), Math.round($this$fastRoundToInt$iv2));
    }

    /* JADX INFO: renamed from: rem-Bjo55l4, reason: not valid java name */
    public static final long m6938remBjo55l4(long arg0, int operand) {
        return IntOffsetKt.IntOffset(((int) (arg0 >> 32)) % operand, ((int) (4294967295L & arg0)) % operand);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6940toStringimpl(long arg0) {
        return '(' + m6933getXimpl(arg0) + ", " + m6934getYimpl(arg0) + ')';
    }

    public String toString() {
        return m6940toStringimpl(this.packedValue);
    }

    /* JADX INFO: compiled from: IntOffset.kt */
    @Metadata(m194d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, m195d2 = {"Landroidx/compose/ui/unit/IntOffset$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/unit/IntOffset;", "getZero-nOcc-ac", "()J", "J", "ui-unit_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZero-nOcc-ac, reason: not valid java name */
        public final long m6943getZeronOccac() {
            return IntOffset.Zero;
        }
    }
}
