package androidx.compose.foundation.text.input.internal;

import androidx.compose.p001ui.text.TextRange;
import androidx.compose.p001ui.text.TextRangeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: EditingBuffer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, m195d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", "target", "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class EditingBufferKt {
    /* JADX INFO: renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m1309updateRangeAfterDeletepWDy79M(long target, long deleted) {
        int targetMin = TextRange.m6249getMinimpl(target);
        int targetMax = TextRange.m6248getMaximpl(target);
        if (TextRange.m6253intersects5zctL8(deleted, target)) {
            if (TextRange.m6241contains5zctL8(deleted, target)) {
                targetMin = TextRange.m6249getMinimpl(deleted);
                targetMax = targetMin;
            } else if (TextRange.m6241contains5zctL8(target, deleted)) {
                targetMax -= TextRange.m6247getLengthimpl(deleted);
            } else if (TextRange.m6242containsimpl(deleted, targetMin)) {
                targetMin = TextRange.m6249getMinimpl(deleted);
                targetMax -= TextRange.m6247getLengthimpl(deleted);
            } else {
                targetMax = TextRange.m6249getMinimpl(deleted);
            }
        } else if (targetMax > TextRange.m6249getMinimpl(deleted)) {
            targetMin -= TextRange.m6247getLengthimpl(deleted);
            targetMax -= TextRange.m6247getLengthimpl(deleted);
        }
        return TextRangeKt.TextRange(targetMin, targetMax);
    }
}
