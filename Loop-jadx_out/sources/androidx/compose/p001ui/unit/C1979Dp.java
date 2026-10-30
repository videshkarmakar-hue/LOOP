package androidx.compose.p001ui.unit;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: androidx.compose.ui.unit.Dp */
/* JADX INFO: compiled from: Dp.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000H\u0097\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000fJ\u001e\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000fJ\u001b\u0010\u001c\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u000fJ\u001e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u000fJ\u001e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0011J\u000f\u0010 \u001a\u00020!H\u0017¢\u0006\u0004\b\"\u0010#J\u0016\u0010$\u001a\u00020\u0000H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, m195d2 = {"Landroidx/compose/ui/unit/Dp;", "", DownloadUtil.CookieScheme.VALUE, "", "constructor-impl", "(F)F", "getValue", "()F", "compareTo", "", "other", "compareTo-0680j_4", "(FF)I", "div", "div-0680j_4", "(FF)F", "div-u2uoSUM", "(FI)F", "equals", "", "", "equals-impl", "(FLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(F)I", "minus", "minus-5rwHm24", "plus", "plus-5rwHm24", "times", "times-u2uoSUM", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "unaryMinus", "unaryMinus-D9Ej5fM", "Companion", "ui-unit_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
public final class C1979Dp implements Comparable<C1979Dp> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float Hairline = m6801constructorimpl(0.0f);
    private static final float Infinity = m6801constructorimpl(Float.POSITIVE_INFINITY);
    private static final float Unspecified = m6801constructorimpl(Float.NaN);
    private final float value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ C1979Dp m6799boximpl(float f) {
        return new C1979Dp(f);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float m6801constructorimpl(float f) {
        return f;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6805equalsimpl(float f, Object obj) {
        return (obj instanceof C1979Dp) && Float.compare(f, ((C1979Dp) obj).m6815unboximpl()) == 0;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6806equalsimpl0(float f, float f2) {
        return Float.compare(f, f2) == 0;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6807hashCodeimpl(float f) {
        return Float.floatToIntBits(f);
    }

    public boolean equals(Object obj) {
        return m6805equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6807hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float m6815unboximpl() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(C1979Dp c1979Dp) {
        return m6814compareTo0680j_4(c1979Dp.m6815unboximpl());
    }

    private /* synthetic */ C1979Dp(float value) {
        this.value = value;
    }

    public final float getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: plus-5rwHm24, reason: not valid java name */
    public static final float m6809plus5rwHm24(float arg0, float other) {
        return m6801constructorimpl(arg0 + other);
    }

    /* JADX INFO: renamed from: minus-5rwHm24, reason: not valid java name */
    public static final float m6808minus5rwHm24(float arg0, float other) {
        return m6801constructorimpl(arg0 - other);
    }

    /* JADX INFO: renamed from: unaryMinus-D9Ej5fM, reason: not valid java name */
    public static final float m6813unaryMinusD9Ej5fM(float arg0) {
        return m6801constructorimpl(-arg0);
    }

    /* JADX INFO: renamed from: div-u2uoSUM, reason: not valid java name */
    public static final float m6803divu2uoSUM(float arg0, float other) {
        return m6801constructorimpl(arg0 / other);
    }

    /* JADX INFO: renamed from: div-u2uoSUM, reason: not valid java name */
    public static final float m6804divu2uoSUM(float arg0, int other) {
        return m6801constructorimpl(arg0 / other);
    }

    /* JADX INFO: renamed from: div-0680j_4, reason: not valid java name */
    public static final float m6802div0680j_4(float arg0, float other) {
        return arg0 / other;
    }

    /* JADX INFO: renamed from: times-u2uoSUM, reason: not valid java name */
    public static final float m6810timesu2uoSUM(float arg0, float other) {
        return m6801constructorimpl(arg0 * other);
    }

    /* JADX INFO: renamed from: times-u2uoSUM, reason: not valid java name */
    public static final float m6811timesu2uoSUM(float arg0, int other) {
        return m6801constructorimpl(other * arg0);
    }

    /* JADX INFO: renamed from: compareTo-0680j_4, reason: not valid java name */
    public static int m6800compareTo0680j_4(float arg0, float other) {
        return Float.compare(arg0, other);
    }

    /* JADX INFO: renamed from: compareTo-0680j_4, reason: not valid java name */
    public int m6814compareTo0680j_4(float other) {
        return m6800compareTo0680j_4(this.value, other);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6812toStringimpl(float arg0) {
        return Float.isNaN(arg0) ? "Dp.Unspecified" : arg0 + ".dp";
    }

    public String toString() {
        return m6812toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: androidx.compose.ui.unit.Dp$Companion, reason: from kotlin metadata */
    /* JADX INFO: compiled from: Dp.kt */
    @Metadata(m194d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R$\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, m195d2 = {"Landroidx/compose/ui/unit/Dp$Companion;", "", "()V", "Hairline", "Landroidx/compose/ui/unit/Dp;", "getHairline-D9Ej5fM$annotations", "getHairline-D9Ej5fM", "()F", "F", "Infinity", "getInfinity-D9Ej5fM$annotations", "getInfinity-D9Ej5fM", "Unspecified", "getUnspecified-D9Ej5fM$annotations", "getUnspecified-D9Ej5fM", "ui-unit_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getHairline-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m6816getHairlineD9Ej5fM$annotations() {
        }

        /* JADX INFO: renamed from: getInfinity-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m6817getInfinityD9Ej5fM$annotations() {
        }

        /* JADX INFO: renamed from: getUnspecified-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m6818getUnspecifiedD9Ej5fM$annotations() {
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getHairline-D9Ej5fM, reason: not valid java name */
        public final float m6819getHairlineD9Ej5fM() {
            return C1979Dp.Hairline;
        }

        /* JADX INFO: renamed from: getInfinity-D9Ej5fM, reason: not valid java name */
        public final float m6820getInfinityD9Ej5fM() {
            return C1979Dp.Infinity;
        }

        /* JADX INFO: renamed from: getUnspecified-D9Ej5fM, reason: not valid java name */
        public final float m6821getUnspecifiedD9Ej5fM() {
            return C1979Dp.Unspecified;
        }
    }
}
