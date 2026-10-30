package androidx.compose.p001ui.unit;

import androidx.collection.FloatFloatPair$$ExternalSyntheticBackport0;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.caverock.androidsvg.SVGParser;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TextUnit.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0014"}, m195d2 = {"Landroidx/compose/ui/unit/TextUnitType;", "", SVGParser.XML_STYLESHEET_ATTR_TYPE, "", "constructor-impl", "(J)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
public final class TextUnitType {
    private final long type;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Unspecified = m7024constructorimpl(0);

    /* JADX INFO: renamed from: Sp */
    private static final long f172Sp = m7024constructorimpl(4294967296L);

    /* JADX INFO: renamed from: Em */
    private static final long f171Em = m7024constructorimpl(8589934592L);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextUnitType m7023boximpl(long j) {
        return new TextUnitType(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m7024constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7025equalsimpl(long j, Object obj) {
        return (obj instanceof TextUnitType) && j == ((TextUnitType) obj).getType();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7026equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7027hashCodeimpl(long j) {
        return FloatFloatPair$$ExternalSyntheticBackport0.m4m(j);
    }

    public boolean equals(Object obj) {
        return m7025equalsimpl(this.type, obj);
    }

    public int hashCode() {
        return m7027hashCodeimpl(this.type);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getType() {
        return this.type;
    }

    private /* synthetic */ TextUnitType(long type) {
        this.type = type;
    }

    public String toString() {
        return m7028toStringimpl(this.type);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7028toStringimpl(long arg0) {
        if (m7026equalsimpl0(arg0, Unspecified)) {
            return "Unspecified";
        }
        if (m7026equalsimpl0(arg0, f172Sp)) {
            return "Sp";
        }
        return m7026equalsimpl0(arg0, f171Em) ? "Em" : "Invalid";
    }

    /* JADX INFO: compiled from: TextUnit.kt */
    @Metadata(m194d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, m195d2 = {"Landroidx/compose/ui/unit/TextUnitType$Companion;", "", "()V", "Em", "Landroidx/compose/ui/unit/TextUnitType;", "getEm-UIouoOA", "()J", "J", "Sp", "getSp-UIouoOA", "Unspecified", "getUnspecified-UIouoOA", "ui-unit_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getUnspecified-UIouoOA, reason: not valid java name */
        public final long m7032getUnspecifiedUIouoOA() {
            return TextUnitType.Unspecified;
        }

        /* JADX INFO: renamed from: getSp-UIouoOA, reason: not valid java name */
        public final long m7031getSpUIouoOA() {
            return TextUnitType.f172Sp;
        }

        /* JADX INFO: renamed from: getEm-UIouoOA, reason: not valid java name */
        public final long m7030getEmUIouoOA() {
            return TextUnitType.f171Em;
        }
    }
}
