package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.PrefetchExecutor;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: LazyListPrefetchStrategy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0014\u0010\u0010\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m195d2 = {"Landroidx/compose/foundation/lazy/DefaultLazyListPrefetchStrategy;", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "()V", "currentPrefetchHandle", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "indexToPrefetch", "", "wasScrollingForward", "", "onScroll", "", "Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "delta", "", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "onVisibleItemsUpdated", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DefaultLazyListPrefetchStrategy implements LazyListPrefetchStrategy {
    public static final int $stable = 0;
    private LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;
    private int indexToPrefetch = -1;
    private boolean wasScrollingForward;

    @Override // androidx.compose.foundation.lazy.LazyListPrefetchStrategy
    public /* synthetic */ PrefetchExecutor getPrefetchExecutor() {
        return LazyListPrefetchStrategy.CC.$default$getPrefetchExecutor(this);
    }

    @Override // androidx.compose.foundation.lazy.LazyListPrefetchStrategy
    public void onScroll(LazyListPrefetchScope $this$onScroll, float delta, LazyListLayoutInfo layoutInfo) {
        int indexToPrefetch;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle;
        if (!layoutInfo.getVisibleItemsInfo().isEmpty()) {
            boolean scrollingForward = delta < 0.0f;
            if (scrollingForward) {
                indexToPrefetch = ((LazyListItemInfo) CollectionsKt.last((List) layoutInfo.getVisibleItemsInfo())).getIndex() + 1;
            } else {
                indexToPrefetch = ((LazyListItemInfo) CollectionsKt.first((List) layoutInfo.getVisibleItemsInfo())).getIndex() - 1;
            }
            if (indexToPrefetch != this.indexToPrefetch) {
                if (indexToPrefetch >= 0 && indexToPrefetch < layoutInfo.getTotalItemsCount()) {
                    if (this.wasScrollingForward != scrollingForward && (prefetchHandle = this.currentPrefetchHandle) != null) {
                        prefetchHandle.cancel();
                    }
                    this.wasScrollingForward = scrollingForward;
                    this.indexToPrefetch = indexToPrefetch;
                    this.currentPrefetchHandle = $this$onScroll.schedulePrefetch(indexToPrefetch);
                }
            }
        }
    }

    @Override // androidx.compose.foundation.lazy.LazyListPrefetchStrategy
    public void onVisibleItemsUpdated(LazyListPrefetchScope $this$onVisibleItemsUpdated, LazyListLayoutInfo layoutInfo) {
        int expectedPrefetchIndex;
        if (this.indexToPrefetch != -1 && (!layoutInfo.getVisibleItemsInfo().isEmpty())) {
            if (this.wasScrollingForward) {
                expectedPrefetchIndex = ((LazyListItemInfo) CollectionsKt.last((List) layoutInfo.getVisibleItemsInfo())).getIndex() + 1;
            } else {
                expectedPrefetchIndex = ((LazyListItemInfo) CollectionsKt.first((List) layoutInfo.getVisibleItemsInfo())).getIndex() - 1;
            }
            if (this.indexToPrefetch != expectedPrefetchIndex) {
                this.indexToPrefetch = -1;
                LazyLayoutPrefetchState.PrefetchHandle prefetchHandle = this.currentPrefetchHandle;
                if (prefetchHandle != null) {
                    prefetchHandle.cancel();
                }
                this.currentPrefetchHandle = null;
            }
        }
    }
}
