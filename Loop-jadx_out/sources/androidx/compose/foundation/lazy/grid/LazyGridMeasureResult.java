package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.p001ui.layout.AlignmentLine;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.RulerScope;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyGridMeasureResult.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BÂ\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u00123\u0010\u0010\u001a/\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00170\u00160\u00150\u0011\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\b\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020\u0006\u0012\u0006\u0010!\u001a\u00020\u0006¢\u0006\u0002\u0010\"J\t\u0010W\u001a\u00020HH\u0096\u0001J\u000e\u0010X\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\u0006R\u0014\u0010 \u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001e\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00060&X\u0096\u0005¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010$R\u0011\u0010,\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010.\"\u0004\b0\u00101R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010$\"\u0004\b;\u0010<R\u0012\u0010=\u001a\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001a\u0004\b>\u0010$R\u0014\u0010!\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010$R\u0014\u0010\u001e\u001a\u00020\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR>\u0010\u0010\u001a/\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00170\u00160\u00150\u0011¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bD\u0010.R\u0014\u0010\u001d\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010.R'\u0010F\u001a\u0015\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020H\u0018\u00010\u0011¢\u0006\u0002\bI8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bJ\u0010CR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bK\u0010$R\u0014\u0010\u001c\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010$R\u0014\u0010\u001b\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010$R\u001a\u0010N\u001a\u00020O8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0014\u0010\u001a\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010$R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0012\u0010U\u001a\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001a\u0004\bV\u0010$\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, m195d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "firstVisibleLine", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "firstVisibleLineScrollOffset", "", "canScrollForward", "", "consumedScroll", "", "measureResult", "remeasureNeeded", "density", "Landroidx/compose/ui/unit/Density;", "slotsPerLine", "prefetchInfoRetriever", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "line", "", "Lkotlin/Pair;", "Landroidx/compose/ui/unit/Constraints;", "visibleItemsInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "viewportStartOffset", "viewportEndOffset", "totalItemsCount", "reverseLayout", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "afterContentPadding", "mainAxisItemSpacing", "(Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;IZFLandroidx/compose/ui/layout/MeasureResult;ZLandroidx/compose/ui/unit/Density;ILkotlin/jvm/functions/Function1;Ljava/util/List;IIIZLandroidx/compose/foundation/gestures/Orientation;II)V", "getAfterContentPadding", "()I", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "beforeContentPadding", "getBeforeContentPadding", "canScrollBackward", "getCanScrollBackward", "()Z", "getCanScrollForward", "setCanScrollForward", "(Z)V", "getConsumedScroll", "()F", "setConsumedScroll", "(F)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFirstVisibleLine", "()Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "getFirstVisibleLineScrollOffset", "setFirstVisibleLineScrollOffset", "(I)V", "height", "getHeight", "getMainAxisItemSpacing", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getPrefetchInfoRetriever", "()Lkotlin/jvm/functions/Function1;", "getRemeasureNeeded", "getReverseLayout", "rulers", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRulers", "getSlotsPerLine", "getTotalItemsCount", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "getViewportStartOffset", "getVisibleItemsInfo", "()Ljava/util/List;", "width", "getWidth", "placeChildren", "tryToApplyScrollWithoutRemeasure", "delta", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LazyGridMeasureResult implements LazyGridLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final /* synthetic */ MeasureResult $$delegate_0;
    private final int afterContentPadding;
    private boolean canScrollForward;
    private float consumedScroll;
    private final Density density;
    private final LazyGridMeasuredLine firstVisibleLine;
    private int firstVisibleLineScrollOffset;
    private final int mainAxisItemSpacing;
    private final Orientation orientation;
    private final Function1<Integer, List<Pair<Integer, Constraints>>> prefetchInfoRetriever;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final int slotsPerLine;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List<LazyGridMeasuredItem> visibleItemsInfo;

    @Override // androidx.compose.p001ui.layout.MeasureResult
    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    @Override // androidx.compose.p001ui.layout.MeasureResult
    /* JADX INFO: renamed from: getHeight */
    public int getF163$h() {
        return this.$$delegate_0.getF163$h();
    }

    @Override // androidx.compose.p001ui.layout.MeasureResult
    public Function1<RulerScope, Unit> getRulers() {
        return this.$$delegate_0.getRulers();
    }

    @Override // androidx.compose.p001ui.layout.MeasureResult
    /* JADX INFO: renamed from: getWidth */
    public int getF164$w() {
        return this.$$delegate_0.getF164$w();
    }

    @Override // androidx.compose.p001ui.layout.MeasureResult
    public void placeChildren() {
        this.$$delegate_0.placeChildren();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LazyGridMeasureResult(LazyGridMeasuredLine firstVisibleLine, int firstVisibleLineScrollOffset, boolean canScrollForward, float consumedScroll, MeasureResult measureResult, boolean remeasureNeeded, Density density, int slotsPerLine, Function1<? super Integer, ? extends List<Pair<Integer, Constraints>>> function1, List<LazyGridMeasuredItem> list, int viewportStartOffset, int viewportEndOffset, int totalItemsCount, boolean reverseLayout, Orientation orientation, int afterContentPadding, int mainAxisItemSpacing) {
        this.firstVisibleLine = firstVisibleLine;
        this.firstVisibleLineScrollOffset = firstVisibleLineScrollOffset;
        this.canScrollForward = canScrollForward;
        this.consumedScroll = consumedScroll;
        this.remeasureNeeded = remeasureNeeded;
        this.density = density;
        this.slotsPerLine = slotsPerLine;
        this.prefetchInfoRetriever = function1;
        this.visibleItemsInfo = list;
        this.viewportStartOffset = viewportStartOffset;
        this.viewportEndOffset = viewportEndOffset;
        this.totalItemsCount = totalItemsCount;
        this.reverseLayout = reverseLayout;
        this.orientation = orientation;
        this.afterContentPadding = afterContentPadding;
        this.mainAxisItemSpacing = mainAxisItemSpacing;
        this.$$delegate_0 = measureResult;
    }

    public final LazyGridMeasuredLine getFirstVisibleLine() {
        return this.firstVisibleLine;
    }

    public final int getFirstVisibleLineScrollOffset() {
        return this.firstVisibleLineScrollOffset;
    }

    public final void setFirstVisibleLineScrollOffset(int i) {
        this.firstVisibleLineScrollOffset = i;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final void setCanScrollForward(boolean z) {
        this.canScrollForward = z;
    }

    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    public final void setConsumedScroll(float f) {
        this.consumedScroll = f;
    }

    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final int getSlotsPerLine() {
        return this.slotsPerLine;
    }

    public final Function1<Integer, List<Pair<Integer, Constraints>>> getPrefetchInfoRetriever() {
        return this.prefetchInfoRetriever;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public List<LazyGridMeasuredItem> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    public final boolean getCanScrollBackward() {
        LazyGridMeasuredLine lazyGridMeasuredLine = this.firstVisibleLine;
        return ((lazyGridMeasuredLine != null ? lazyGridMeasuredLine.getIndex() : 0) == 0 && this.firstVisibleLineScrollOffset == 0) ? false : true;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    /* JADX INFO: renamed from: getViewportSize-YbymL2g */
    public long mo1002getViewportSizeYbymL2g() {
        return IntSizeKt.IntSize(getF164$w(), getF163$h());
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }

    public final boolean tryToApplyScrollWithoutRemeasure(int delta) {
        int deltaToFirstItemChange;
        if (!this.remeasureNeeded && !getVisibleItemsInfo().isEmpty() && this.firstVisibleLine != null) {
            int mainAxisSizeWithSpacings = this.firstVisibleLine.getMainAxisSizeWithSpacings();
            int i = this.firstVisibleLineScrollOffset - delta;
            if (i >= 0 && i < mainAxisSizeWithSpacings) {
                LazyGridMeasuredItem first = (LazyGridMeasuredItem) CollectionsKt.first((List) getVisibleItemsInfo());
                LazyGridMeasuredItem last = (LazyGridMeasuredItem) CollectionsKt.last((List) getVisibleItemsInfo());
                if (first.getNonScrollableItem() || last.getNonScrollableItem()) {
                    return false;
                }
                if (delta < 0) {
                    int deltaToFirstItemChange2 = (LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(first, getOrientation()) + first.getMainAxisSizeWithSpacings()) - getViewportStartOffset();
                    int deltaToLastItemChange = (LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(last, getOrientation()) + last.getMainAxisSizeWithSpacings()) - getViewportEndOffset();
                    deltaToFirstItemChange = Math.min(deltaToFirstItemChange2, deltaToLastItemChange) > (-delta) ? 1 : 0;
                } else {
                    int deltaToFirstItemChange3 = getViewportStartOffset() - LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(first, getOrientation());
                    int deltaToLastItemChange2 = getViewportEndOffset() - LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(last, getOrientation());
                    deltaToFirstItemChange = Math.min(deltaToFirstItemChange3, deltaToLastItemChange2) > delta ? 1 : 0;
                }
                if (deltaToFirstItemChange == 0) {
                    return false;
                }
                this.firstVisibleLineScrollOffset -= delta;
                List<LazyGridMeasuredItem> visibleItemsInfo = getVisibleItemsInfo();
                int size = visibleItemsInfo.size();
                for (int index$iv = 0; index$iv < size; index$iv++) {
                    Object item$iv = visibleItemsInfo.get(index$iv);
                    LazyGridMeasuredItem it = (LazyGridMeasuredItem) item$iv;
                    it.applyScrollDelta(delta);
                }
                this.consumedScroll = delta;
                if (!this.canScrollForward && delta > 0) {
                    this.canScrollForward = true;
                }
                return true;
            }
        }
        return false;
    }
}
