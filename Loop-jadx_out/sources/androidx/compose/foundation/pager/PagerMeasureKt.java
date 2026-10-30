package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.gestures.snapping.SnapPositionKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PagerMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002\u001aH\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0015H\u0002\u001a@\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0015H\u0002\u001a\u0017\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0082\b\u001a\u008c\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e*\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0002\u001aj\u0010\u0014\u001a\u00020\u0004*\u00020\u001f2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010(\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\u0006\u0010*\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001aé\u0001\u0010?\u001a\u00020@*\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u00103\u001a\u0002042\u0006\u0010A\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u0002022\u0006\u0010(\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010:2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u0010*\u001a\u00020+2\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010E\u001a\u00020F2/\u0010G\u001a+\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u00190\u0015¢\u0006\u0002\bJ\u0012\u0004\u0012\u00020K0HH\u0000ø\u0001\u0000¢\u0006\u0004\bL\u0010M\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006N"}, m195d2 = {"MaxPageOffset", "", "MinPageOffset", "calculateNewCurrentPage", "Landroidx/compose/foundation/pager/MeasuredPage;", "viewportSize", "", "visiblePagesInfo", "", "beforeContentPadding", "afterContentPadding", "itemSize", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageCount", "createPagesAfterList", "currentLastPage", "pagesCount", "beyondViewportPageCount", "pinnedPages", "getAndMeasure", "Lkotlin/Function1;", "createPagesBeforeList", "currentFirstPage", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "calculatePagesOffsets", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "", "density", "Landroidx/compose/ui/unit/Density;", "spaceBetweenPages", "pageAvailableSize", "index", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "pagerItemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "visualPageOffset", "Landroidx/compose/ui/unit/IntOffset;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getAndMeasure-SGf7dI0", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZI)Landroidx/compose/foundation/pager/MeasuredPage;", "measurePager", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "mainAxisAvailableSize", "currentPage", "currentPageOffset", "constraints", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measurePager-_JDW0YA", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PagerMeasureKt {
    public static final float MaxPageOffset = 0.5f;
    public static final float MinPageOffset = -0.5f;

    /* JADX INFO: renamed from: measurePager-_JDW0YA, reason: not valid java name */
    public static final PagerMeasureResult m1106measurePager_JDW0YA(final LazyLayoutMeasureScope $this$measurePager_u2d_JDW0YA, int pageCount, final PagerLazyLayoutItemProvider pagerItemProvider, int mainAxisAvailableSize, int beforeContentPadding, int afterContentPadding, int spaceBetweenPages, int currentPage, int currentPageOffset, long constraints, final Orientation orientation, final Alignment.Vertical verticalAlignment, final Alignment.Horizontal horizontalAlignment, final boolean reverseLayout, final long visualPageOffset, final int pageAvailableSize, int beyondViewportPageCount, List<Integer> list, SnapPosition snapPosition, final MutableState<Unit> mutableState, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int iM6744getMaxWidthimpl;
        int iM6743getMaxHeightimpl;
        int currentFirstPageScrollOffset;
        int maxCrossAxis;
        int maxCrossAxis2;
        int currentFirstPageScrollOffset2;
        int currentMainAxisOffset;
        int pageSizeWithSpacing;
        int index;
        int currentFirstPageScrollOffset3;
        MeasuredPage firstPage;
        int i;
        int i2;
        List<MeasuredPage> list2;
        int maxOffset;
        List positionedPagesBefore;
        List positionedPagesAfter;
        int currentMainAxisOffset2;
        boolean z;
        int i3;
        if (!(beforeContentPadding >= 0)) {
            throw new IllegalArgumentException("negative beforeContentPadding".toString());
        }
        if (!(afterContentPadding >= 0)) {
            throw new IllegalArgumentException("negative afterContentPadding".toString());
        }
        int pageSizeWithSpacing2 = RangesKt.coerceAtLeast(pageAvailableSize + spaceBetweenPages, 0);
        if (pageCount <= 0) {
            return new PagerMeasureResult(CollectionsKt.emptyList(), pageAvailableSize, spaceBetweenPages, afterContentPadding, orientation, -beforeContentPadding, mainAxisAvailableSize + afterContentPadding, false, beyondViewportPageCount, null, null, 0.0f, 0, false, snapPosition, function3.invoke(Integer.valueOf(Constraints.m6746getMinWidthimpl(constraints)), Integer.valueOf(Constraints.m6745getMinHeightimpl(constraints)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope $this$invoke) {
                }
            }), false, null, null, 393216, null);
        }
        if (orientation == Orientation.Vertical) {
            iM6744getMaxWidthimpl = Constraints.m6744getMaxWidthimpl(constraints);
        } else {
            iM6744getMaxWidthimpl = pageAvailableSize;
        }
        if (orientation != Orientation.Vertical) {
            iM6743getMaxHeightimpl = Constraints.m6743getMaxHeightimpl(constraints);
        } else {
            iM6743getMaxHeightimpl = pageAvailableSize;
        }
        final long childConstraints = ConstraintsKt.Constraints$default(0, iM6744getMaxWidthimpl, 0, iM6743getMaxHeightimpl, 5, null);
        int firstVisiblePage = currentPage;
        int firstVisiblePageOffset = currentPageOffset;
        while (firstVisiblePage > 0 && firstVisiblePageOffset > 0) {
            firstVisiblePage--;
            firstVisiblePageOffset -= pageSizeWithSpacing2;
        }
        int firstVisiblePageScrollOffset = firstVisiblePageOffset * (-1);
        int currentFirstPage = firstVisiblePage;
        int currentFirstPageScrollOffset4 = firstVisiblePageScrollOffset;
        if (currentFirstPage >= pageCount) {
            currentFirstPage = pageCount - 1;
            currentFirstPageScrollOffset4 = 0;
        }
        ArrayDeque visiblePages = new ArrayDeque();
        int currentFirstPageScrollOffset5 = (spaceBetweenPages < 0 ? spaceBetweenPages : 0) + (-beforeContentPadding);
        int maxOffset2 = mainAxisAvailableSize;
        int maxCrossAxis3 = currentFirstPageScrollOffset4 + currentFirstPageScrollOffset5;
        int currentFirstPageScrollOffset6 = 0;
        while (maxCrossAxis3 < 0 && currentFirstPage > 0) {
            int previous = currentFirstPage - 1;
            int maxCrossAxis4 = currentFirstPageScrollOffset6;
            int currentFirstPageScrollOffset7 = maxCrossAxis3;
            int minOffset = currentFirstPageScrollOffset5;
            ArrayDeque visiblePages2 = visiblePages;
            MeasuredPage measuredPage = m1105getAndMeasureSGf7dI0($this$measurePager_u2d_JDW0YA, previous, childConstraints, pagerItemProvider, visualPageOffset, orientation, horizontalAlignment, verticalAlignment, $this$measurePager_u2d_JDW0YA.getLayoutDirection(), reverseLayout, pageAvailableSize);
            visiblePages2.add(0, measuredPage);
            currentFirstPage = previous;
            visiblePages = visiblePages2;
            currentFirstPageScrollOffset6 = Math.max(maxCrossAxis4, measuredPage.getCrossAxisSize());
            maxCrossAxis3 = currentFirstPageScrollOffset7 + pageSizeWithSpacing2;
            currentFirstPageScrollOffset5 = minOffset;
            maxOffset2 = maxOffset2;
        }
        int minOffset2 = currentFirstPageScrollOffset5;
        int maxOffset3 = maxOffset2;
        ArrayDeque visiblePages3 = visiblePages;
        int minOffset3 = currentFirstPageScrollOffset6;
        int maxOffset4 = maxCrossAxis3;
        int minOffset4 = minOffset2;
        if (maxOffset4 >= minOffset4) {
            currentFirstPageScrollOffset = maxOffset4;
        } else {
            currentFirstPageScrollOffset = minOffset4;
        }
        int currentFirstPageScrollOffset8 = currentFirstPageScrollOffset - minOffset4;
        int index2 = currentFirstPage;
        int currentFirstPage2 = currentFirstPage;
        int maxOffset5 = maxOffset3;
        int maxMainAxis = RangesKt.coerceAtLeast(maxOffset5 + afterContentPadding, 0);
        int currentMainAxisOffset3 = -currentFirstPageScrollOffset8;
        boolean remeasureNeeded = false;
        int indexInVisibleItems = 0;
        while (indexInVisibleItems < visiblePages3.size()) {
            if (currentMainAxisOffset3 >= maxMainAxis) {
                visiblePages3.remove(indexInVisibleItems);
                remeasureNeeded = true;
            } else {
                index2++;
                currentMainAxisOffset3 += pageSizeWithSpacing2;
                indexInVisibleItems++;
            }
        }
        int currentMainAxisOffset4 = currentMainAxisOffset3;
        int currentFirstPageScrollOffset9 = currentFirstPageScrollOffset8;
        int currentFirstPageScrollOffset10 = minOffset3;
        int index3 = currentFirstPage2;
        boolean remeasureNeeded2 = remeasureNeeded;
        int maxCrossAxis5 = index2;
        while (maxCrossAxis5 < pageCount && (currentMainAxisOffset4 < maxMainAxis || currentMainAxisOffset4 <= 0 || visiblePages3.isEmpty())) {
            int maxMainAxis2 = maxMainAxis;
            int maxCrossAxis6 = currentFirstPageScrollOffset10;
            int currentFirstPage3 = index3;
            int indexInVisibleItems2 = indexInVisibleItems;
            int currentFirstPage4 = maxCrossAxis5;
            int indexInVisibleItems3 = maxOffset5;
            int minOffset5 = minOffset4;
            MeasuredPage measuredPage2 = m1105getAndMeasureSGf7dI0($this$measurePager_u2d_JDW0YA, maxCrossAxis5, childConstraints, pagerItemProvider, visualPageOffset, orientation, horizontalAlignment, verticalAlignment, $this$measurePager_u2d_JDW0YA.getLayoutDirection(), reverseLayout, pageAvailableSize);
            int $i$f$debugLog = pageCount - 1;
            if (currentFirstPage4 == $i$f$debugLog) {
                i3 = pageAvailableSize;
            } else {
                i3 = pageSizeWithSpacing2;
            }
            currentMainAxisOffset4 += i3;
            if (currentMainAxisOffset4 <= minOffset5 && currentFirstPage4 != pageCount - 1) {
                currentFirstPageScrollOffset9 -= pageSizeWithSpacing2;
                remeasureNeeded2 = true;
                currentFirstPage3 = currentFirstPage4 + 1;
            } else {
                maxCrossAxis6 = Math.max(maxCrossAxis6, measuredPage2.getCrossAxisSize());
                visiblePages3.add(measuredPage2);
            }
            currentFirstPageScrollOffset10 = maxCrossAxis6;
            maxCrossAxis5 = currentFirstPage4 + 1;
            minOffset4 = minOffset5;
            maxOffset5 = indexInVisibleItems3;
            maxMainAxis = maxMainAxis2;
            indexInVisibleItems = indexInVisibleItems2;
            index3 = currentFirstPage3;
        }
        if (currentMainAxisOffset4 < maxOffset5) {
            int toScrollBack = maxOffset5 - currentMainAxisOffset4;
            int currentMainAxisOffset5 = currentMainAxisOffset4 + toScrollBack;
            int currentFirstPageScrollOffset11 = currentFirstPageScrollOffset9 - toScrollBack;
            while (currentFirstPageScrollOffset11 < beforeContentPadding && index3 > 0) {
                int previousIndex = index3 - 1;
                MeasuredPage measuredPage3 = m1105getAndMeasureSGf7dI0($this$measurePager_u2d_JDW0YA, previousIndex, childConstraints, pagerItemProvider, visualPageOffset, orientation, horizontalAlignment, verticalAlignment, $this$measurePager_u2d_JDW0YA.getLayoutDirection(), reverseLayout, pageAvailableSize);
                visiblePages3.add(0, measuredPage3);
                currentFirstPageScrollOffset10 = Math.max(currentFirstPageScrollOffset10, measuredPage3.getCrossAxisSize());
                index3 = previousIndex;
                currentFirstPageScrollOffset11 += pageSizeWithSpacing2;
            }
            if (currentFirstPageScrollOffset11 >= 0) {
                maxCrossAxis = currentFirstPageScrollOffset10;
                maxCrossAxis2 = currentMainAxisOffset5;
                currentMainAxisOffset = index3;
                currentFirstPageScrollOffset2 = currentFirstPageScrollOffset11;
            } else {
                maxCrossAxis = currentFirstPageScrollOffset10;
                maxCrossAxis2 = currentMainAxisOffset5 + currentFirstPageScrollOffset11;
                currentFirstPageScrollOffset2 = 0;
                currentMainAxisOffset = index3;
            }
        } else {
            maxCrossAxis = currentFirstPageScrollOffset10;
            maxCrossAxis2 = currentMainAxisOffset4;
            currentFirstPageScrollOffset2 = currentFirstPageScrollOffset9;
            currentMainAxisOffset = index3;
        }
        if (!(currentFirstPageScrollOffset2 >= 0)) {
            throw new IllegalArgumentException("invalid currentFirstPageScrollOffset".toString());
        }
        int visiblePagesScrollOffset = -currentFirstPageScrollOffset2;
        MeasuredPage firstPage2 = (MeasuredPage) visiblePages3.first();
        if (beforeContentPadding > 0 || spaceBetweenPages < 0) {
            int i4 = 0;
            int size = visiblePages3.size();
            while (true) {
                if (i4 >= size) {
                    pageSizeWithSpacing = pageSizeWithSpacing2;
                    index = maxCrossAxis5;
                    break;
                }
                int size2 = pageSizeWithSpacing2;
                if (currentFirstPageScrollOffset2 == 0) {
                    pageSizeWithSpacing = pageSizeWithSpacing2;
                    index = maxCrossAxis5;
                    break;
                }
                pageSizeWithSpacing = pageSizeWithSpacing2;
                if (size2 > currentFirstPageScrollOffset2) {
                    index = maxCrossAxis5;
                    break;
                }
                index = maxCrossAxis5;
                int index4 = CollectionsKt.getLastIndex(visiblePages3);
                if (i4 == index4) {
                    break;
                }
                currentFirstPageScrollOffset2 -= size2;
                firstPage2 = (MeasuredPage) visiblePages3.get(i4 + 1);
                i4++;
                pageSizeWithSpacing2 = pageSizeWithSpacing;
                maxCrossAxis5 = index;
            }
            currentFirstPageScrollOffset3 = currentFirstPageScrollOffset2;
            firstPage = firstPage2;
        } else {
            pageSizeWithSpacing = pageSizeWithSpacing2;
            index = maxCrossAxis5;
            currentFirstPageScrollOffset3 = currentFirstPageScrollOffset2;
            firstPage = firstPage2;
        }
        List<MeasuredPage> listCreatePagesBeforeList = createPagesBeforeList(currentMainAxisOffset, beyondViewportPageCount, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesBefore$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int it) {
                return PagerMeasureKt.m1105getAndMeasureSGf7dI0($this$measurePager_u2d_JDW0YA, it, childConstraints, pagerItemProvider, visualPageOffset, orientation, horizontalAlignment, verticalAlignment, $this$measurePager_u2d_JDW0YA.getLayoutDirection(), reverseLayout, pageAvailableSize);
            }
        });
        List<MeasuredPage> list3 = listCreatePagesBeforeList;
        int index$iv = 0;
        int size3 = list3.size();
        int maxCrossAxis7 = maxCrossAxis;
        while (index$iv < size3) {
            Object item$iv = list3.get(index$iv);
            maxCrossAxis7 = Math.max(maxCrossAxis7, ((MeasuredPage) item$iv).getCrossAxisSize());
            index$iv++;
            list3 = list3;
        }
        List<MeasuredPage> listCreatePagesAfterList = createPagesAfterList(((MeasuredPage) visiblePages3.last()).getIndex(), pageCount, beyondViewportPageCount, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesAfter$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int it) {
                return PagerMeasureKt.m1105getAndMeasureSGf7dI0($this$measurePager_u2d_JDW0YA, it, childConstraints, pagerItemProvider, visualPageOffset, orientation, horizontalAlignment, verticalAlignment, $this$measurePager_u2d_JDW0YA.getLayoutDirection(), reverseLayout, pageAvailableSize);
            }
        });
        List<MeasuredPage> list4 = listCreatePagesAfterList;
        int index$iv2 = 0;
        int size4 = list4.size();
        int maxCrossAxis8 = maxCrossAxis7;
        while (index$iv2 < size4) {
            Object item$iv2 = list4.get(index$iv2);
            maxCrossAxis8 = Math.max(maxCrossAxis8, ((MeasuredPage) item$iv2).getCrossAxisSize());
            index$iv2++;
            list4 = list4;
        }
        boolean noExtraPages = Intrinsics.areEqual(firstPage, visiblePages3.first()) && listCreatePagesBeforeList.isEmpty() && listCreatePagesAfterList.isEmpty();
        if (orientation == Orientation.Vertical) {
            i = maxCrossAxis8;
        } else {
            i = maxCrossAxis2;
        }
        int layoutWidth = ConstraintsKt.m6761constrainWidthK40F9xA(constraints, i);
        if (orientation == Orientation.Vertical) {
            i2 = maxCrossAxis2;
        } else {
            i2 = maxCrossAxis8;
        }
        int layoutHeight = ConstraintsKt.m6760constrainHeightK40F9xA(constraints, i2);
        final List<MeasuredPage> listCalculatePagesOffsets = calculatePagesOffsets($this$measurePager_u2d_JDW0YA, visiblePages3, listCreatePagesBeforeList, listCreatePagesAfterList, layoutWidth, layoutHeight, maxCrossAxis2, maxOffset5, visiblePagesScrollOffset, orientation, reverseLayout, $this$measurePager_u2d_JDW0YA, spaceBetweenPages, pageAvailableSize);
        if (noExtraPages) {
            list2 = listCalculatePagesOffsets;
        } else {
            ArrayList target$iv = new ArrayList(listCalculatePagesOffsets.size());
            List<MeasuredPage> list5 = listCalculatePagesOffsets;
            int size5 = list5.size();
            int index$iv$iv = 0;
            while (index$iv$iv < size5) {
                MeasuredPage measuredPage4 = list5.get(index$iv$iv);
                int i5 = size5;
                MeasuredPage it = measuredPage4;
                List<MeasuredPage> list6 = list5;
                if (it.getIndex() >= ((MeasuredPage) visiblePages3.first()).getIndex() && it.getIndex() <= ((MeasuredPage) visiblePages3.last()).getIndex()) {
                    target$iv.add(measuredPage4);
                }
                index$iv$iv++;
                size5 = i5;
                list5 = list6;
            }
            list2 = target$iv;
        }
        int $i$f$fastFilter = maxCrossAxis2;
        if (listCreatePagesBeforeList.isEmpty()) {
            positionedPagesBefore = CollectionsKt.emptyList();
            maxOffset = maxOffset5;
        } else {
            ArrayList target$iv2 = new ArrayList(listCalculatePagesOffsets.size());
            List<MeasuredPage> list7 = listCalculatePagesOffsets;
            int size6 = list7.size();
            int $i$f$fastFilter2 = 0;
            while ($i$f$fastFilter2 < size6) {
                MeasuredPage it2 = list7.get($i$f$fastFilter2);
                int i6 = size6;
                List<MeasuredPage> list8 = list7;
                int index5 = it2.getIndex();
                int maxOffset6 = maxOffset5;
                int maxOffset7 = ((MeasuredPage) visiblePages3.first()).getIndex();
                if (index5 < maxOffset7) {
                    target$iv2.add(it2);
                }
                $i$f$fastFilter2++;
                size6 = i6;
                list7 = list8;
                maxOffset5 = maxOffset6;
            }
            maxOffset = maxOffset5;
            positionedPagesBefore = target$iv2;
        }
        if (listCreatePagesAfterList.isEmpty()) {
            positionedPagesAfter = CollectionsKt.emptyList();
        } else {
            ArrayList target$iv3 = new ArrayList(listCalculatePagesOffsets.size());
            List<MeasuredPage> list9 = listCalculatePagesOffsets;
            int size7 = list9.size();
            int $i$f$fastFilter3 = 0;
            while ($i$f$fastFilter3 < size7) {
                MeasuredPage it3 = list9.get($i$f$fastFilter3);
                int i7 = size7;
                List<MeasuredPage> list10 = list9;
                ArrayDeque visiblePages4 = visiblePages3;
                if (it3.getIndex() > ((MeasuredPage) visiblePages3.last()).getIndex()) {
                    target$iv3.add(it3);
                }
                $i$f$fastFilter3++;
                size7 = i7;
                list9 = list10;
                visiblePages3 = visiblePages4;
            }
            positionedPagesAfter = target$iv3;
        }
        int pageSizeWithSpacing3 = pageSizeWithSpacing;
        MeasuredPage firstPage3 = firstPage;
        int index6 = index;
        MeasuredPage newCurrentPage = calculateNewCurrentPage(orientation == Orientation.Vertical ? layoutHeight : layoutWidth, list2, beforeContentPadding, afterContentPadding, pageSizeWithSpacing3, snapPosition, pageCount);
        int currentMainAxisOffset6 = maxOffset;
        List<MeasuredPage> list11 = list2;
        int snapOffset = snapPosition.position(mainAxisAvailableSize, pageAvailableSize, beforeContentPadding, afterContentPadding, newCurrentPage != null ? newCurrentPage.getIndex() : 0, pageCount);
        int currentPagePositionOffset = newCurrentPage != null ? newCurrentPage.getOffset() : 0;
        float currentPageOffsetFraction = pageSizeWithSpacing3 == 0 ? 0.0f : RangesKt.coerceIn((snapOffset - currentPagePositionOffset) / pageSizeWithSpacing3, -0.5f, 0.5f);
        MeasureResult measureResultInvoke = function3.invoke(Integer.valueOf(layoutWidth), Integer.valueOf(layoutHeight), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope $this$invoke) {
                List<MeasuredPage> list12 = listCalculatePagesOffsets;
                int size8 = list12.size();
                for (int index$iv3 = 0; index$iv3 < size8; index$iv3++) {
                    Object item$iv3 = list12.get(index$iv3);
                    MeasuredPage it4 = (MeasuredPage) item$iv3;
                    it4.place($this$invoke);
                }
                ObservableScopeInvalidator.m1042attachToScopeimpl(mutableState);
            }
        });
        int i8 = -beforeContentPadding;
        int i9 = currentMainAxisOffset6 + afterContentPadding;
        if (index6 >= pageCount) {
            currentMainAxisOffset2 = $i$f$fastFilter;
            if (currentMainAxisOffset2 <= currentMainAxisOffset6) {
                z = false;
            }
            return new PagerMeasureResult(list11, pageAvailableSize, spaceBetweenPages, afterContentPadding, orientation, i8, i9, reverseLayout, beyondViewportPageCount, firstPage3, newCurrentPage, currentPageOffsetFraction, currentFirstPageScrollOffset3, z, snapPosition, measureResultInvoke, remeasureNeeded2, positionedPagesBefore, positionedPagesAfter);
        }
        currentMainAxisOffset2 = $i$f$fastFilter;
        z = true;
        return new PagerMeasureResult(list11, pageAvailableSize, spaceBetweenPages, afterContentPadding, orientation, i8, i9, reverseLayout, beyondViewportPageCount, firstPage3, newCurrentPage, currentPageOffsetFraction, currentFirstPageScrollOffset3, z, snapPosition, measureResultInvoke, remeasureNeeded2, positionedPagesBefore, positionedPagesAfter);
    }

    private static final List<MeasuredPage> createPagesAfterList(int currentLastPage, int pagesCount, int beyondViewportPageCount, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        ArrayList arrayList = null;
        int end = Math.min(currentLastPage + beyondViewportPageCount, pagesCount - 1);
        int i = currentLastPage + 1;
        if (i <= end) {
            while (true) {
                if (arrayList == null) {
                    Object list2 = new ArrayList();
                    arrayList = (List) list2;
                }
                arrayList.add(function1.invoke(Integer.valueOf(i)));
                if (i == end) {
                    break;
                }
                i++;
            }
        }
        int size = list.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = list.get(index$iv);
            int pageIndex = ((Number) item$iv).intValue();
            boolean z = false;
            if (end + 1 <= pageIndex && pageIndex < pagesCount) {
                z = true;
            }
            if (z) {
                if (arrayList == null) {
                    Object list3 = new ArrayList();
                    arrayList = (List) list3;
                }
                arrayList.add(function1.invoke(Integer.valueOf(pageIndex)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<MeasuredPage> createPagesBeforeList(int currentFirstPage, int beyondViewportPageCount, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        ArrayList arrayList = null;
        int start = Math.max(0, currentFirstPage - beyondViewportPageCount);
        int i = currentFirstPage - 1;
        if (start <= i) {
            while (true) {
                if (arrayList == null) {
                    Object list2 = new ArrayList();
                    arrayList = (List) list2;
                }
                arrayList.add(function1.invoke(Integer.valueOf(i)));
                if (i == start) {
                    break;
                }
                i--;
            }
        }
        int size = list.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = list.get(index$iv);
            int pageIndex = ((Number) item$iv).intValue();
            if (pageIndex < start) {
                if (arrayList == null) {
                    Object list3 = new ArrayList();
                    arrayList = (List) list3;
                }
                arrayList.add(function1.invoke(Integer.valueOf(pageIndex)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final MeasuredPage calculateNewCurrentPage(int viewportSize, List<MeasuredPage> list, int beforeContentPadding, int afterContentPadding, int itemSize, SnapPosition snapPosition, int pageCount) {
        Object maxElem$iv;
        if (!list.isEmpty()) {
            maxElem$iv = list.get(0);
            MeasuredPage it = (MeasuredPage) maxElem$iv;
            float maxValue$iv = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(viewportSize, beforeContentPadding, afterContentPadding, itemSize, it.getOffset(), it.getIndex(), snapPosition, pageCount));
            int i$iv = 1;
            int lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
                while (true) {
                    Object e$iv = list.get(i$iv);
                    MeasuredPage it2 = (MeasuredPage) e$iv;
                    float v$iv = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(viewportSize, beforeContentPadding, afterContentPadding, itemSize, it2.getOffset(), it2.getIndex(), snapPosition, pageCount));
                    if (Float.compare(maxValue$iv, v$iv) < 0) {
                        maxElem$iv = e$iv;
                        maxValue$iv = v$iv;
                    }
                    if (i$iv == lastIndex) {
                        break;
                    }
                    i$iv++;
                }
            }
        } else {
            maxElem$iv = null;
        }
        return (MeasuredPage) maxElem$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getAndMeasure-SGf7dI0, reason: not valid java name */
    public static final MeasuredPage m1105getAndMeasureSGf7dI0(LazyLayoutMeasureScope $this$getAndMeasure_u2dSGf7dI0, int index, long childConstraints, PagerLazyLayoutItemProvider pagerItemProvider, long visualPageOffset, Orientation orientation, Alignment.Horizontal horizontalAlignment, Alignment.Vertical verticalAlignment, LayoutDirection layoutDirection, boolean reverseLayout, int pageAvailableSize) {
        Object key = pagerItemProvider.getKey(index);
        return new MeasuredPage(index, pageAvailableSize, $this$getAndMeasure_u2dSGf7dI0.mo1031measure0kLqBqw(index, childConstraints), visualPageOffset, key, orientation, horizontalAlignment, verticalAlignment, layoutDirection, reverseLayout, null);
    }

    private static final List<MeasuredPage> calculatePagesOffsets(LazyLayoutMeasureScope $this$calculatePagesOffsets, List<MeasuredPage> list, List<MeasuredPage> list2, List<MeasuredPage> list3, int layoutWidth, int layoutHeight, int finalMainAxisOffset, int maxOffset, int pagesScrollOffset, Orientation orientation, boolean reverseLayout, Density density, int spaceBetweenPages, int pageAvailableSize) {
        int[] offsets;
        int size;
        int pageSizeWithSpacing = pageAvailableSize + spaceBetweenPages;
        int mainAxisLayoutSize = orientation == Orientation.Vertical ? layoutHeight : layoutWidth;
        boolean hasSpareSpace = finalMainAxisOffset < Math.min(mainAxisLayoutSize, maxOffset);
        if (hasSpareSpace) {
            if (!(pagesScrollOffset == 0)) {
                throw new IllegalStateException(("non-zero pagesScrollOffset=" + pagesScrollOffset).toString());
            }
        }
        ArrayList positionedPages = new ArrayList(list.size() + list2.size() + list3.size());
        if (hasSpareSpace) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                throw new IllegalArgumentException("No extra pages".toString());
            }
            int pagesCount = list.size();
            int[] sizes = new int[pagesCount];
            for (int i = 0; i < pagesCount; i++) {
                sizes[i] = pageAvailableSize;
            }
            int[] offsets2 = new int[pagesCount];
            for (int i2 = 0; i2 < pagesCount; i2++) {
                offsets2[i2] = 0;
            }
            Arrangement.HorizontalOrVertical arrangement = Arrangement.Absolute.INSTANCE.m747spacedBy0680j_4($this$calculatePagesOffsets.mo564toDpu2uoSUM(spaceBetweenPages));
            if (orientation == Orientation.Vertical) {
                arrangement.arrange(density, mainAxisLayoutSize, sizes, offsets2);
                offsets = offsets2;
            } else {
                offsets = offsets2;
                arrangement.arrange(density, mainAxisLayoutSize, sizes, LayoutDirection.Ltr, offsets);
            }
            IntRange reverseAwareOffsetIndices = ArraysKt.getIndices(offsets);
            if (reverseLayout) {
                reverseAwareOffsetIndices = RangesKt.reversed(reverseAwareOffsetIndices);
            }
            int index = reverseAwareOffsetIndices.getFirst();
            int last = reverseAwareOffsetIndices.getLast();
            int step = reverseAwareOffsetIndices.getStep();
            if ((step > 0 && index <= last) || (step < 0 && last <= index)) {
                while (true) {
                    int absoluteOffset = offsets[index];
                    int pagesCount2 = pagesCount;
                    MeasuredPage page = list.get(calculatePagesOffsets$reverseAware(index, reverseLayout, pagesCount));
                    if (reverseLayout) {
                        size = (mainAxisLayoutSize - absoluteOffset) - page.getSize();
                    } else {
                        size = absoluteOffset;
                    }
                    int relativeOffset = size;
                    page.position(relativeOffset, layoutWidth, layoutHeight);
                    positionedPages.add(page);
                    if (index == last) {
                        break;
                    }
                    index += step;
                    pagesCount = pagesCount2;
                }
            }
        } else {
            positionedPages = positionedPages;
            int currentMainAxis = pagesScrollOffset;
            int size2 = list2.size();
            for (int index$iv = 0; index$iv < size2; index$iv++) {
                Object item$iv = list2.get(index$iv);
                MeasuredPage it = (MeasuredPage) item$iv;
                currentMainAxis -= pageSizeWithSpacing;
                it.position(currentMainAxis, layoutWidth, layoutHeight);
                positionedPages.add(it);
            }
            int currentMainAxis2 = pagesScrollOffset;
            int size3 = list.size();
            for (int index$iv2 = 0; index$iv2 < size3; index$iv2++) {
                Object item$iv2 = list.get(index$iv2);
                MeasuredPage it2 = (MeasuredPage) item$iv2;
                it2.position(currentMainAxis2, layoutWidth, layoutHeight);
                positionedPages.add(it2);
                currentMainAxis2 += pageSizeWithSpacing;
            }
            int size4 = list3.size();
            for (int index$iv3 = 0; index$iv3 < size4; index$iv3++) {
                Object item$iv3 = list3.get(index$iv3);
                MeasuredPage it3 = (MeasuredPage) item$iv3;
                it3.position(currentMainAxis2, layoutWidth, layoutHeight);
                positionedPages.add(it3);
                currentMainAxis2 += pageSizeWithSpacing;
            }
        }
        return positionedPages;
    }

    private static final int calculatePagesOffsets$reverseAware(int $this$calculatePagesOffsets_u24reverseAware, boolean $reverseLayout, int pagesCount) {
        return !$reverseLayout ? $this$calculatePagesOffsets_u24reverseAware : (pagesCount - $this$calculatePagesOffsets_u24reverseAware) - 1;
    }

    private static final void debugLog(Function0<String> function0) {
    }
}
