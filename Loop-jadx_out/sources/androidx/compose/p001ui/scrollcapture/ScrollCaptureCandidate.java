package androidx.compose.p001ui.scrollcapture;

import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.semantics.SemanticsNode;
import androidx.compose.p001ui.unit.IntRect;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: ScrollCapture.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, m195d2 = {"Landroidx/compose/ui/scrollcapture/ScrollCaptureCandidate;", "", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "depth", "", "viewportBoundsInWindow", "Landroidx/compose/ui/unit/IntRect;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Landroidx/compose/ui/semantics/SemanticsNode;ILandroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/layout/LayoutCoordinates;)V", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "getDepth", "()I", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getViewportBoundsInWindow", "()Landroidx/compose/ui/unit/IntRect;", "toString", "", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class ScrollCaptureCandidate {
    private final LayoutCoordinates coordinates;
    private final int depth;
    private final SemanticsNode node;
    private final IntRect viewportBoundsInWindow;

    public ScrollCaptureCandidate(SemanticsNode node, int depth, IntRect viewportBoundsInWindow, LayoutCoordinates coordinates) {
        this.node = node;
        this.depth = depth;
        this.viewportBoundsInWindow = viewportBoundsInWindow;
        this.coordinates = coordinates;
    }

    public final SemanticsNode getNode() {
        return this.node;
    }

    public final int getDepth() {
        return this.depth;
    }

    public final IntRect getViewportBoundsInWindow() {
        return this.viewportBoundsInWindow;
    }

    public final LayoutCoordinates getCoordinates() {
        return this.coordinates;
    }

    public String toString() {
        return "ScrollCaptureCandidate(node=" + this.node + ", depth=" + this.depth + ", viewportBoundsInWindow=" + this.viewportBoundsInWindow + ", coordinates=" + this.coordinates + ')';
    }
}
