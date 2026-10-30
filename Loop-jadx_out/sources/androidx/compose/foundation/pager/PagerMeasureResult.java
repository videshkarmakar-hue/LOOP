package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.p001ui.layout.AlignmentLine;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.RulerScope;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PagerMeasureResult.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B·\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u001dJ\t\u0010U\u001a\u00020FH\u0096\u0001J\u000e\u0010V\u001a\u00020\u000f2\u0006\u0010W\u001a\u00020\u0007R\u0014\u0010\t\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00070!X\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001fR\u0014\u0010\u0010\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0011\u0010(\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u001a\u0010\u0016\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010*\"\u0004\b,\u0010-R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00105R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010/R\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001f\"\u0004\b9\u0010:R\u0012\u0010;\u001a\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b<\u0010\u001fR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u001fR\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u001fR\u0011\u0010\u001a\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\bA\u0010*R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010*R'\u0010C\u001a\u0015\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020F\u0018\u00010D¢\u0006\u0002\bG8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0014\u0010\r\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u001fR\u001a\u0010M\u001a\u00020N8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010\f\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u001fR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u00105R\u0012\u0010S\u001a\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\bT\u0010\u001f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006X"}, m195d2 = {"Landroidx/compose/foundation/pager/PagerMeasureResult;", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "visiblePagesInfo", "", "Landroidx/compose/foundation/pager/MeasuredPage;", "pageSize", "", "pageSpacing", "afterContentPadding", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "viewportStartOffset", "viewportEndOffset", "reverseLayout", "", "beyondViewportPageCount", "firstVisiblePage", "currentPage", "currentPageOffsetFraction", "", "firstVisiblePageScrollOffset", "canScrollForward", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "measureResult", "remeasureNeeded", "extraPagesBefore", "extraPagesAfter", "(Ljava/util/List;IIILandroidx/compose/foundation/gestures/Orientation;IIZILandroidx/compose/foundation/pager/MeasuredPage;Landroidx/compose/foundation/pager/MeasuredPage;FIZLandroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/ui/layout/MeasureResult;ZLjava/util/List;Ljava/util/List;)V", "getAfterContentPadding", "()I", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "beforeContentPadding", "getBeforeContentPadding", "getBeyondViewportPageCount", "canScrollBackward", "getCanScrollBackward", "()Z", "getCanScrollForward", "setCanScrollForward", "(Z)V", "getCurrentPage", "()Landroidx/compose/foundation/pager/MeasuredPage;", "getCurrentPageOffsetFraction", "()F", "setCurrentPageOffsetFraction", "(F)V", "getExtraPagesAfter", "()Ljava/util/List;", "getExtraPagesBefore", "getFirstVisiblePage", "getFirstVisiblePageScrollOffset", "setFirstVisiblePageScrollOffset", "(I)V", "height", "getHeight", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getPageSize", "getPageSpacing", "getRemeasureNeeded", "getReverseLayout", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "getSnapPosition", "()Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "getViewportStartOffset", "getVisiblePagesInfo", "width", "getWidth", "placeChildren", "tryToApplyScrollWithoutRemeasure", "delta", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PagerMeasureResult implements PagerLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final /* synthetic */ MeasureResult $$delegate_0;
    private final int afterContentPadding;
    private final int beyondViewportPageCount;
    private boolean canScrollForward;
    private final MeasuredPage currentPage;
    private float currentPageOffsetFraction;
    private final List<MeasuredPage> extraPagesAfter;
    private final List<MeasuredPage> extraPagesBefore;
    private final MeasuredPage firstVisiblePage;
    private int firstVisiblePageScrollOffset;
    private final Orientation orientation;
    private final int pageSize;
    private final int pageSpacing;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final SnapPosition snapPosition;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List<MeasuredPage> visiblePagesInfo;

    @Override // androidx.compose.p001ui.layout.MeasureResult
    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    @Override // androidx.compose.p001ui.layout.MeasureResult
    public int getHeight() {
        return this.$$delegate_0.getHeight();
    }

    @Override // androidx.compose.p001ui.layout.MeasureResult
    public Function1<RulerScope, Unit> getRulers() {
        return this.$$delegate_0.getRulers();
    }

    @Override // androidx.compose.p001ui.layout.MeasureResult
    public int getWidth() {
        return this.$$delegate_0.getWidth();
    }

    @Override // androidx.compose.p001ui.layout.MeasureResult
    public void placeChildren() {
        this.$$delegate_0.placeChildren();
    }

    public PagerMeasureResult(List<MeasuredPage> list, int pageSize, int pageSpacing, int afterContentPadding, Orientation orientation, int viewportStartOffset, int viewportEndOffset, boolean reverseLayout, int beyondViewportPageCount, MeasuredPage firstVisiblePage, MeasuredPage currentPage, float currentPageOffsetFraction, int firstVisiblePageScrollOffset, boolean canScrollForward, SnapPosition snapPosition, MeasureResult measureResult, boolean remeasureNeeded, List<MeasuredPage> list2, List<MeasuredPage> list3) {
        this.visiblePagesInfo = list;
        this.pageSize = pageSize;
        this.pageSpacing = pageSpacing;
        this.afterContentPadding = afterContentPadding;
        this.orientation = orientation;
        this.viewportStartOffset = viewportStartOffset;
        this.viewportEndOffset = viewportEndOffset;
        this.reverseLayout = reverseLayout;
        this.beyondViewportPageCount = beyondViewportPageCount;
        this.firstVisiblePage = firstVisiblePage;
        this.currentPage = currentPage;
        this.currentPageOffsetFraction = currentPageOffsetFraction;
        this.firstVisiblePageScrollOffset = firstVisiblePageScrollOffset;
        this.canScrollForward = canScrollForward;
        this.snapPosition = snapPosition;
        this.remeasureNeeded = remeasureNeeded;
        this.extraPagesBefore = list2;
        this.extraPagesAfter = list3;
        this.$$delegate_0 = measureResult;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PagerMeasureResult(List list, int i, int i2, int i3, Orientation orientation, int i4, int i5, boolean z, int i6, MeasuredPage measuredPage, MeasuredPage measuredPage2, float f, int i7, boolean z2, SnapPosition snapPosition, MeasureResult measureResult, boolean z3, List list2, List list3, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        List listEmptyList;
        List listEmptyList2;
        if ((i8 & 131072) == 0) {
            listEmptyList = list2;
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        if ((i8 & 262144) == 0) {
            listEmptyList2 = list3;
        } else {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        this(list, i, i2, i3, orientation, i4, i5, z, i6, measuredPage, measuredPage2, f, i7, z2, snapPosition, measureResult, z3, listEmptyList, listEmptyList2);
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public List<MeasuredPage> getVisiblePagesInfo() {
        return this.visiblePagesInfo;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getPageSize() {
        return this.pageSize;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getPageSpacing() {
        return this.pageSpacing;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getBeyondViewportPageCount() {
        return this.beyondViewportPageCount;
    }

    public final MeasuredPage getFirstVisiblePage() {
        return this.firstVisiblePage;
    }

    public final MeasuredPage getCurrentPage() {
        return this.currentPage;
    }

    public final float getCurrentPageOffsetFraction() {
        return this.currentPageOffsetFraction;
    }

    public final void setCurrentPageOffsetFraction(float f) {
        this.currentPageOffsetFraction = f;
    }

    public final int getFirstVisiblePageScrollOffset() {
        return this.firstVisiblePageScrollOffset;
    }

    public final void setFirstVisiblePageScrollOffset(int i) {
        this.firstVisiblePageScrollOffset = i;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final void setCanScrollForward(boolean z) {
        this.canScrollForward = z;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public SnapPosition getSnapPosition() {
        return this.snapPosition;
    }

    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    public final List<MeasuredPage> getExtraPagesBefore() {
        return this.extraPagesBefore;
    }

    public final List<MeasuredPage> getExtraPagesAfter() {
        return this.extraPagesAfter;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    /* JADX INFO: renamed from: getViewportSize-YbymL2g */
    public long mo1103getViewportSizeYbymL2g() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }

    public final boolean getCanScrollBackward() {
        MeasuredPage measuredPage = this.firstVisiblePage;
        return ((measuredPage != null ? measuredPage.getIndex() : 0) == 0 && this.firstVisiblePageScrollOffset == 0) ? false : true;
    }

    public final boolean tryToApplyScrollWithoutRemeasure(int delta) {
        float deltaFraction;
        int deltaToFirstItemChange;
        int pageSizeWithSpacing = getPageSize() + getPageSpacing();
        if (!this.remeasureNeeded && !getVisiblePagesInfo().isEmpty() && this.firstVisiblePage != null) {
            int i = this.firstVisiblePageScrollOffset - delta;
            if (i >= 0 && i < pageSizeWithSpacing) {
                if (pageSizeWithSpacing != 0) {
                    deltaFraction = delta / pageSizeWithSpacing;
                } else {
                    deltaFraction = 0.0f;
                }
                float newCurrentPageOffsetFraction = this.currentPageOffsetFraction - deltaFraction;
                if (this.currentPage == null || newCurrentPageOffsetFraction >= 0.5f || newCurrentPageOffsetFraction <= -0.5f) {
                    return false;
                }
                MeasuredPage first = (MeasuredPage) CollectionsKt.first((List) getVisiblePagesInfo());
                MeasuredPage last = (MeasuredPage) CollectionsKt.last((List) getVisiblePagesInfo());
                if (delta < 0) {
                    int deltaToFirstItemChange2 = (first.getOffset() + pageSizeWithSpacing) - getViewportStartOffset();
                    int deltaToLastItemChange = (last.getOffset() + pageSizeWithSpacing) - getViewportEndOffset();
                    deltaToFirstItemChange = Math.min(deltaToFirstItemChange2, deltaToLastItemChange) > (-delta) ? 1 : 0;
                } else {
                    int deltaToFirstItemChange3 = getViewportStartOffset() - first.getOffset();
                    int deltaToLastItemChange2 = getViewportEndOffset() - last.getOffset();
                    deltaToFirstItemChange = Math.min(deltaToFirstItemChange3, deltaToLastItemChange2) > delta ? 1 : 0;
                }
                if (deltaToFirstItemChange == 0) {
                    return false;
                }
                this.currentPageOffsetFraction -= deltaFraction;
                this.firstVisiblePageScrollOffset -= delta;
                List<MeasuredPage> visiblePagesInfo = getVisiblePagesInfo();
                int size = visiblePagesInfo.size();
                for (int index$iv = 0; index$iv < size; index$iv++) {
                    Object item$iv = visiblePagesInfo.get(index$iv);
                    MeasuredPage it = (MeasuredPage) item$iv;
                    it.applyScrollDelta(delta);
                }
                List<MeasuredPage> list = this.extraPagesBefore;
                int size2 = list.size();
                for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                    Object item$iv2 = list.get(index$iv2);
                    MeasuredPage it2 = (MeasuredPage) item$iv2;
                    it2.applyScrollDelta(delta);
                }
                List<MeasuredPage> list2 = this.extraPagesAfter;
                int size3 = list2.size();
                for (int index$iv3 = 0; index$iv3 < size3; index$iv3++) {
                    Object item$iv3 = list2.get(index$iv3);
                    MeasuredPage it3 = (MeasuredPage) item$iv3;
                    it3.applyScrollDelta(delta);
                }
                if (!this.canScrollForward && delta > 0) {
                    this.canScrollForward = true;
                }
                return true;
            }
        }
        return false;
    }
}
