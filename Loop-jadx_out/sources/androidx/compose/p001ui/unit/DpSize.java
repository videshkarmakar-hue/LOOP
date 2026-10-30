package androidx.compose.p001ui.unit;

import androidx.collection.FloatFloatPair$$ExternalSyntheticBackport0;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Dp.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 02\u00020\u0001:\u00010B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0010\u001a\u00020\u0007H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000bJ\u0016\u0010\u0012\u001a\u00020\u0007H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u000bJ$\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u001cH\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b#\u0010$J\u001b\u0010%\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b)\u0010'J\u001e\u0010*\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010\u001bJ\u001e\u0010*\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u001cH\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010\u001dJ\u000f\u0010,\u001a\u00020-H\u0017¢\u0006\u0004\b.\u0010/R \u0010\u0006\u001a\u00020\u00078FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\tR \u0010\r\u001a\u00020\u00078FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00061"}, m195d2 = {"Landroidx/compose/ui/unit/DpSize;", "", "packedValue", "", "constructor-impl", "(J)J", "height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM$annotations", "()V", "getHeight-D9Ej5fM", "(J)F", "getPackedValue$annotations", "width", "getWidth-D9Ej5fM$annotations", "getWidth-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "copy", "copy-DwJknco", "(JFF)J", "div", "other", "", "div-Gh9hcWk", "(JF)J", "", "(JI)J", "equals", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(J)I", "minus", "minus-e_xh8Ic", "(JJ)J", "plus", "plus-e_xh8Ic", "times", "times-Gh9hcWk", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
public final class DpSize {
    private final long packedValue;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = DpKt.m6823DpSizeYgX7TsA(C1979Dp.m6801constructorimpl(0), C1979Dp.m6801constructorimpl(0));
    private static final long Unspecified = DpKt.m6823DpSizeYgX7TsA(C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM(), C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM());

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpSize m6887boximpl(long j) {
        return new DpSize(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m6890constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6895equalsimpl(long j, Object obj) {
        return (obj instanceof DpSize) && j == ((DpSize) obj).getPackedValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6896equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m6898getHeightD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m6900getWidthD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6901hashCodeimpl(long j) {
        return FloatFloatPair$$ExternalSyntheticBackport0.m4m(j);
    }

    public boolean equals(Object obj) {
        return m6895equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m6901hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ DpSize(long packedValue) {
        this.packedValue = packedValue;
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public static final float m6899getWidthD9Ej5fM(long arg0) {
        boolean value$iv = arg0 != 9205357640488583168L;
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException("DpSize is unspecified");
        }
        int bits$iv$iv = (int) (arg0 >> 32);
        float $this$dp$iv = Float.intBitsToFloat(bits$iv$iv);
        return C1979Dp.m6801constructorimpl($this$dp$iv);
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public static final float m6897getHeightD9Ej5fM(long arg0) {
        boolean value$iv = arg0 != 9205357640488583168L;
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException("DpSize is unspecified");
        }
        int bits$iv$iv = (int) (4294967295L & arg0);
        float $this$dp$iv = Float.intBitsToFloat(bits$iv$iv);
        return C1979Dp.m6801constructorimpl($this$dp$iv);
    }

    /* JADX INFO: renamed from: copy-DwJknco, reason: not valid java name */
    public static final long m6891copyDwJknco(long arg0, float width, float height) {
        return DpKt.m6823DpSizeYgX7TsA(width, height);
    }

    /* JADX INFO: renamed from: copy-DwJknco$default, reason: not valid java name */
    public static /* synthetic */ long m6892copyDwJknco$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m6899getWidthD9Ej5fM(j);
        }
        if ((i & 2) != 0) {
            f2 = m6897getHeightD9Ej5fM(j);
        }
        return m6891copyDwJknco(j, f, f2);
    }

    /* JADX INFO: renamed from: minus-e_xh8Ic, reason: not valid java name */
    public static final long m6902minuse_xh8Ic(long arg0, long other) {
        float arg0$iv = m6899getWidthD9Ej5fM(arg0);
        float other$iv = m6899getWidthD9Ej5fM(other);
        float arg0$iv2 = C1979Dp.m6801constructorimpl(arg0$iv - other$iv);
        float arg0$iv3 = m6897getHeightD9Ej5fM(arg0);
        float other$iv2 = m6897getHeightD9Ej5fM(other);
        return DpKt.m6823DpSizeYgX7TsA(arg0$iv2, C1979Dp.m6801constructorimpl(arg0$iv3 - other$iv2));
    }

    /* JADX INFO: renamed from: plus-e_xh8Ic, reason: not valid java name */
    public static final long m6903pluse_xh8Ic(long arg0, long other) {
        float arg0$iv = m6899getWidthD9Ej5fM(arg0);
        float other$iv = m6899getWidthD9Ej5fM(other);
        float arg0$iv2 = C1979Dp.m6801constructorimpl(arg0$iv + other$iv);
        float arg0$iv3 = m6897getHeightD9Ej5fM(arg0);
        float other$iv2 = m6897getHeightD9Ej5fM(other);
        return DpKt.m6823DpSizeYgX7TsA(arg0$iv2, C1979Dp.m6801constructorimpl(arg0$iv3 + other$iv2));
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
    public static final float m6888component1D9Ej5fM(long arg0) {
        return m6899getWidthD9Ej5fM(arg0);
    }

    /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name */
    public static final float m6889component2D9Ej5fM(long arg0) {
        return m6897getHeightD9Ej5fM(arg0);
    }

    /* JADX INFO: renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m6905timesGh9hcWk(long arg0, int other) {
        float arg0$iv = m6899getWidthD9Ej5fM(arg0);
        float arg0$iv2 = C1979Dp.m6801constructorimpl(other * arg0$iv);
        float arg0$iv3 = m6897getHeightD9Ej5fM(arg0);
        return DpKt.m6823DpSizeYgX7TsA(arg0$iv2, C1979Dp.m6801constructorimpl(other * arg0$iv3));
    }

    /* JADX INFO: renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m6904timesGh9hcWk(long arg0, float other) {
        float arg0$iv = m6899getWidthD9Ej5fM(arg0);
        float arg0$iv2 = C1979Dp.m6801constructorimpl(arg0$iv * other);
        float arg0$iv3 = m6897getHeightD9Ej5fM(arg0);
        return DpKt.m6823DpSizeYgX7TsA(arg0$iv2, C1979Dp.m6801constructorimpl(arg0$iv3 * other));
    }

    /* JADX INFO: renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m6894divGh9hcWk(long arg0, int other) {
        float arg0$iv = m6899getWidthD9Ej5fM(arg0);
        float arg0$iv2 = C1979Dp.m6801constructorimpl(arg0$iv / other);
        float arg0$iv3 = m6897getHeightD9Ej5fM(arg0);
        return DpKt.m6823DpSizeYgX7TsA(arg0$iv2, C1979Dp.m6801constructorimpl(arg0$iv3 / other));
    }

    /* JADX INFO: renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m6893divGh9hcWk(long arg0, float other) {
        float arg0$iv = m6899getWidthD9Ej5fM(arg0);
        float arg0$iv2 = C1979Dp.m6801constructorimpl(arg0$iv / other);
        float arg0$iv3 = m6897getHeightD9Ej5fM(arg0);
        return DpKt.m6823DpSizeYgX7TsA(arg0$iv2, C1979Dp.m6801constructorimpl(arg0$iv3 / other));
    }

    public String toString() {
        return m6906toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6906toStringimpl(long arg0) {
        if (arg0 != 9205357640488583168L) {
            return ((Object) C1979Dp.m6812toStringimpl(m6899getWidthD9Ej5fM(arg0))) + " x " + ((Object) C1979Dp.m6812toStringimpl(m6897getHeightD9Ej5fM(arg0)));
        }
        return "DpSize.Unspecified";
    }

    /* JADX INFO: compiled from: Dp.kt */
    @Metadata(m194d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, m195d2 = {"Landroidx/compose/ui/unit/DpSize$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/unit/DpSize;", "getUnspecified-MYxV2XQ", "()J", "J", "Zero", "getZero-MYxV2XQ", "ui-unit_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZero-MYxV2XQ, reason: not valid java name */
        public final long m6909getZeroMYxV2XQ() {
            return DpSize.Zero;
        }

        /* JADX INFO: renamed from: getUnspecified-MYxV2XQ, reason: not valid java name */
        public final long m6908getUnspecifiedMYxV2XQ() {
            return DpSize.Unspecified;
        }
    }
}
