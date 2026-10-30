package androidx.compose.foundation.text.selection;

import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.Rect;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SelectionMode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ*\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\f*\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014j\u0002\b\u0015j\u0002\b\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, m195d2 = {"Landroidx/compose/foundation/text/selection/SelectionMode;", "", "(Ljava/lang/String;I)V", "compare", "", "position", "Landroidx/compose/ui/geometry/Offset;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "compare-3MmeM6k$foundation_release", "(JLandroidx/compose/ui/geometry/Rect;)I", "isSelected", "", "start", "end", "isSelected-2x9bVx0$foundation_release", "(Landroidx/compose/ui/geometry/Rect;JJ)Z", "containsInclusive", "offset", "containsInclusive-Uv8p0NA", "(Landroidx/compose/ui/geometry/Rect;J)Z", "Vertical", "Horizontal", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public enum SelectionMode {
    Vertical { // from class: androidx.compose.foundation.text.selection.SelectionMode.Vertical
        @Override // androidx.compose.foundation.text.selection.SelectionMode
        /* JADX INFO: renamed from: compare-3MmeM6k$foundation_release */
        public int mo1523compare3MmeM6k$foundation_release(long position, Rect bounds) {
            if (SelectionManagerKt.m1516containsInclusiveUv8p0NA(bounds, position)) {
                return 0;
            }
            if (Offset.m4050getYimpl(position) < bounds.getTop()) {
                return -1;
            }
            return (Offset.m4049getXimpl(position) >= bounds.getLeft() || Offset.m4050getYimpl(position) >= bounds.getBottom()) ? 1 : -1;
        }
    },
    Horizontal { // from class: androidx.compose.foundation.text.selection.SelectionMode.Horizontal
        @Override // androidx.compose.foundation.text.selection.SelectionMode
        /* JADX INFO: renamed from: compare-3MmeM6k$foundation_release */
        public int mo1523compare3MmeM6k$foundation_release(long position, Rect bounds) {
            if (SelectionManagerKt.m1516containsInclusiveUv8p0NA(bounds, position)) {
                return 0;
            }
            if (Offset.m4049getXimpl(position) < bounds.getLeft()) {
                return -1;
            }
            return (Offset.m4050getYimpl(position) >= bounds.getTop() || Offset.m4049getXimpl(position) >= bounds.getRight()) ? 1 : -1;
        }
    };

    /* synthetic */ SelectionMode(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: renamed from: compare-3MmeM6k$foundation_release, reason: not valid java name */
    public abstract int mo1523compare3MmeM6k$foundation_release(long position, Rect bounds);

    /* JADX INFO: renamed from: isSelected-2x9bVx0$foundation_release, reason: not valid java name */
    public final boolean m1524isSelected2x9bVx0$foundation_release(Rect bounds, long start, long end) {
        if (m1522containsInclusiveUv8p0NA(bounds, start) || m1522containsInclusiveUv8p0NA(bounds, end)) {
            return true;
        }
        int compareStart = mo1523compare3MmeM6k$foundation_release(start, bounds);
        int compareEnd = mo1523compare3MmeM6k$foundation_release(end, bounds);
        return (compareEnd > 0) ^ (compareStart > 0);
    }

    /* JADX INFO: renamed from: containsInclusive-Uv8p0NA, reason: not valid java name */
    private final boolean m1522containsInclusiveUv8p0NA(Rect $this$containsInclusive_u2dUv8p0NA, long offset) {
        float left = $this$containsInclusive_u2dUv8p0NA.getLeft();
        float right = $this$containsInclusive_u2dUv8p0NA.getRight();
        float fM4049getXimpl = Offset.m4049getXimpl(offset);
        if (left <= fM4049getXimpl && fM4049getXimpl <= right) {
            float top = $this$containsInclusive_u2dUv8p0NA.getTop();
            float bottom = $this$containsInclusive_u2dUv8p0NA.getBottom();
            float fM4050getYimpl = Offset.m4050getYimpl(offset);
            if (top <= fM4050getYimpl && fM4050getYimpl <= bottom) {
                return true;
            }
        }
        return false;
    }
}
