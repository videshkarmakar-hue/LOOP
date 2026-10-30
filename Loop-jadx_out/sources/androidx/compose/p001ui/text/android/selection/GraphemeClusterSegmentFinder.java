package androidx.compose.p001ui.text.android.selection;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: SegmentFinder.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u000b"}, m195d2 = {"Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinder;", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "()V", "next", "", "offset", "nextEndBoundary", "nextStartBoundary", "previous", "previousEndBoundary", "previousStartBoundary", "ui-text_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class GraphemeClusterSegmentFinder implements SegmentFinder {
    public static final int $stable = 0;

    public abstract int next(int offset);

    public abstract int previous(int offset);

    @Override // androidx.compose.p001ui.text.android.selection.SegmentFinder
    public int previousStartBoundary(int offset) {
        return previous(offset);
    }

    @Override // androidx.compose.p001ui.text.android.selection.SegmentFinder
    public int previousEndBoundary(int offset) {
        int previousBoundary = previous(offset);
        if (previousBoundary == -1 || previous(previousBoundary) == -1) {
            return -1;
        }
        return previousBoundary;
    }

    @Override // androidx.compose.p001ui.text.android.selection.SegmentFinder
    public int nextStartBoundary(int offset) {
        int nextBoundary = next(offset);
        if (nextBoundary == -1 || next(nextBoundary) == -1) {
            return -1;
        }
        return nextBoundary;
    }

    @Override // androidx.compose.p001ui.text.android.selection.SegmentFinder
    public int nextEndBoundary(int offset) {
        return next(offset);
    }
}
