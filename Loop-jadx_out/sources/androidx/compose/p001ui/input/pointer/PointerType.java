package androidx.compose.p001ui.input.pointer;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PointerEvent.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, m195d2 = {"Landroidx/compose/ui/input/pointer/PointerType;", "", DownloadUtil.CookieScheme.VALUE, "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
public final class PointerType {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Unknown = m5581constructorimpl(0);
    private static final int Touch = m5581constructorimpl(1);
    private static final int Mouse = m5581constructorimpl(2);
    private static final int Stylus = m5581constructorimpl(3);
    private static final int Eraser = m5581constructorimpl(4);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointerType m5580boximpl(int i) {
        return new PointerType(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m5581constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5582equalsimpl(int i, Object obj) {
        return (obj instanceof PointerType) && i == ((PointerType) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5583equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5584hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m5582equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5584hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    private /* synthetic */ PointerType(int value) {
        this.value = value;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5585toStringimpl(int arg0) {
        switch (arg0) {
            case 1:
                return "Touch";
            case 2:
                return "Mouse";
            case 3:
                return "Stylus";
            case 4:
                return "Eraser";
            default:
                return "Unknown";
        }
    }

    public String toString() {
        return m5585toStringimpl(this.value);
    }

    /* JADX INFO: compiled from: PointerEvent.kt */
    @Metadata(m194d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, m195d2 = {"Landroidx/compose/ui/input/pointer/PointerType$Companion;", "", "()V", "Eraser", "Landroidx/compose/ui/input/pointer/PointerType;", "getEraser-T8wyACA", "()I", "I", "Mouse", "getMouse-T8wyACA", "Stylus", "getStylus-T8wyACA", "Touch", "getTouch-T8wyACA", "Unknown", "getUnknown-T8wyACA", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getUnknown-T8wyACA, reason: not valid java name */
        public final int m5591getUnknownT8wyACA() {
            return PointerType.Unknown;
        }

        /* JADX INFO: renamed from: getTouch-T8wyACA, reason: not valid java name */
        public final int m5590getTouchT8wyACA() {
            return PointerType.Touch;
        }

        /* JADX INFO: renamed from: getMouse-T8wyACA, reason: not valid java name */
        public final int m5588getMouseT8wyACA() {
            return PointerType.Mouse;
        }

        /* JADX INFO: renamed from: getStylus-T8wyACA, reason: not valid java name */
        public final int m5589getStylusT8wyACA() {
            return PointerType.Stylus;
        }

        /* JADX INFO: renamed from: getEraser-T8wyACA, reason: not valid java name */
        public final int m5587getEraserT8wyACA() {
            return PointerType.Eraser;
        }
    }
}
