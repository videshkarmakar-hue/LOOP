package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: LazyStaggeredGridAnimateScrollScope.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J7\u0010\u0014\u001a\u00020\u00152'\u0010\u0016\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0017¢\u0006\u0002\b\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\u00020\u0015*\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\b¨\u0006 "}, m195d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridAnimateScrollScope;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;)V", "firstVisibleItemIndex", "", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "itemCount", "getItemCount", "lastVisibleItemIndex", "getLastVisibleItemIndex", "visibleItemsAverageSize", "getVisibleItemsAverageSize", "calculateDistanceTo", "", "targetIndex", "scroll", "", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapToItem", "index", "scrollOffset", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LazyStaggeredGridAnimateScrollScope implements LazyLayoutAnimateScrollScope {
    public static final int $stable = 8;
    private final LazyStaggeredGridState state;

    public LazyStaggeredGridAnimateScrollScope(LazyStaggeredGridState state) {
        this.state = state;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public int getFirstVisibleItemIndex() {
        return this.state.getFirstVisibleItemIndex();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public int getFirstVisibleItemScrollOffset() {
        return this.state.getFirstVisibleItemScrollOffset();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public int getLastVisibleItemIndex() {
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo = (LazyStaggeredGridItemInfo) CollectionsKt.lastOrNull((List) this.state.getLayoutInfo().getVisibleItemsInfo());
        if (lazyStaggeredGridItemInfo != null) {
            return lazyStaggeredGridItemInfo.getIndex();
        }
        return 0;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public int getItemCount() {
        return this.state.getLayoutInfo().getTotalItemsCount();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public void snapToItem(ScrollScope $this$snapToItem, int index, int scrollOffset) {
        LazyStaggeredGridState $this$snapToItem_u24lambda_u240 = this.state;
        $this$snapToItem_u24lambda_u240.snapToItemInternal$foundation_release($this$snapToItem, index, scrollOffset);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public float calculateDistanceTo(int targetIndex) {
        Object it$iv;
        int iM6933getXimpl;
        List<LazyStaggeredGridItemInfo> visibleItemsInfo = this.state.getLayoutInfo().getVisibleItemsInfo();
        int index$iv$iv = 0;
        int size = visibleItemsInfo.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = visibleItemsInfo.get(index$iv$iv);
                it$iv = item$iv$iv;
                LazyStaggeredGridItemInfo it = (LazyStaggeredGridItemInfo) it$iv;
                if (it.getIndex() == targetIndex) {
                    break;
                }
                index$iv$iv++;
            } else {
                it$iv = null;
                break;
            }
        }
        LazyStaggeredGridItemInfo visibleItem = (LazyStaggeredGridItemInfo) it$iv;
        if (visibleItem == null) {
            int averageMainAxisItemSize = getVisibleItemsAverageSize();
            int laneCount = this.state.getLaneCount$foundation_release();
            int lineDiff = (targetIndex / laneCount) - (getFirstVisibleItemIndex() / laneCount);
            return (averageMainAxisItemSize * lineDiff) - getFirstVisibleItemScrollOffset();
        }
        if (this.state.getLayoutInfo().getOrientation() == Orientation.Vertical) {
            iM6933getXimpl = IntOffset.m6934getYimpl(visibleItem.getOffset());
        } else {
            iM6933getXimpl = IntOffset.m6933getXimpl(visibleItem.getOffset());
        }
        return iM6933getXimpl;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public Object scroll(Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objScroll$default = ScrollableState.CC.scroll$default(this.state, null, function2, continuation, 1, null);
        return objScroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll$default : Unit.INSTANCE;
    }

    private final int getVisibleItemsAverageSize() {
        int iM6975getWidthimpl;
        LazyStaggeredGridLayoutInfo layoutInfo = this.state.getLayoutInfo();
        List<LazyStaggeredGridItemInfo> visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
        int sum$iv = 0;
        int size = visibleItemsInfo.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            Object item$iv$iv = visibleItemsInfo.get(index$iv$iv);
            LazyStaggeredGridItemInfo it = (LazyStaggeredGridItemInfo) item$iv$iv;
            if (layoutInfo.getOrientation() == Orientation.Vertical) {
                iM6975getWidthimpl = IntSize.m6974getHeightimpl(it.getSize());
            } else {
                iM6975getWidthimpl = IntSize.m6975getWidthimpl(it.getSize());
            }
            sum$iv += iM6975getWidthimpl;
        }
        int itemSizeSum = sum$iv;
        return (itemSizeSum / visibleItemsInfo.size()) + layoutInfo.getMainAxisItemSpacing();
    }
}
