package androidx.compose.foundation.lazy.grid;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: LazyGridSpan.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m195d2 = {"GridItemSpan", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "currentLineSpan", "", "(I)J", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LazyGridSpanKt {
    public static final long GridItemSpan(int currentLineSpan) {
        if (currentLineSpan > 0) {
            return GridItemSpan.m983constructorimpl(currentLineSpan);
        }
        throw new IllegalArgumentException("The span value should be higher than 0".toString());
    }
}
