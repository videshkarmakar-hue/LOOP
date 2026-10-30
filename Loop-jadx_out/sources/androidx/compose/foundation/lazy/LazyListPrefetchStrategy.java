package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.PrefetchExecutor;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: LazyListPrefetchStrategy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0014\u0010\r\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH&R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, m195d2 = {"Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "", "prefetchExecutor", "Landroidx/compose/foundation/lazy/layout/PrefetchExecutor;", "getPrefetchExecutor", "()Landroidx/compose/foundation/lazy/layout/PrefetchExecutor;", "onScroll", "", "Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "delta", "", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "onVisibleItemsUpdated", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface LazyListPrefetchStrategy {
    PrefetchExecutor getPrefetchExecutor();

    void onScroll(LazyListPrefetchScope lazyListPrefetchScope, float f, LazyListLayoutInfo lazyListLayoutInfo);

    void onVisibleItemsUpdated(LazyListPrefetchScope lazyListPrefetchScope, LazyListLayoutInfo lazyListLayoutInfo);

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListPrefetchStrategy$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: LazyListPrefetchStrategy.kt */
    public final /* synthetic */ class CC {
        public static PrefetchExecutor $default$getPrefetchExecutor(LazyListPrefetchStrategy _this) {
            return null;
        }
    }
}
