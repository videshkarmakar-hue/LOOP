package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.p001ui.graphics.GraphicsContext;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntSize;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyListMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u008c\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\\\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002\u001a4\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010#\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0002\u001a\u009d\u0002\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00100\u001a\u0002012\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u00102\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u00103\u001a\u0004\u0018\u00010!2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092/\u0010:\u001a+\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>0<¢\u0006\u0002\b?\u0012\u0004\u0012\u00020@0;H\u0000ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C"}, m195d2 = {"calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "items", "", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "createItemsAfterList", "visibleItems", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "itemsCount", "beyondBoundsItemCount", "pinnedItems", "consumedScroll", "", "isLookingAhead", "lastPostLookaheadLayoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "createItemsBeforeList", "currentFirstItemIndex", "measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "constraints", "Landroidx/compose/ui/unit/Constraints;", "headerIndexes", "itemAnimator", "Landroidx/compose/foundation/lazy/LazyListItemAnimator;", "hasLookaheadPassOccurred", "postLookaheadLayoutInfo", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-x0Ok8Vo", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IIIIIIFJZLjava/util/List;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/LazyListItemAnimator;ILjava/util/List;ZZLandroidx/compose/foundation/lazy/LazyListLayoutInfo;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LazyListMeasureKt {
    /* JADX WARN: Code duplicated, block: B:151:0x0423  */
    /* JADX WARN: Code duplicated, block: B:166:0x047c  */
    /* JADX WARN: Code duplicated, block: B:167:0x0487  */
    /* JADX WARN: Code duplicated, block: B:169:0x04a4  */
    /* JADX WARN: Code duplicated, block: B:178:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:17:0x0076  */
    /* JADX WARN: Code duplicated, block: B:183:0x0508  */
    /* JADX WARN: Code duplicated, block: B:184:0x050b  */
    /* JADX WARN: Code duplicated, block: B:212:0x04e9 A[SYNTHETIC] */
    /* JADX INFO: renamed from: measureLazyList-x0Ok8Vo, reason: not valid java name */
    public static final LazyListMeasureResult m974measureLazyListx0Ok8Vo(int itemsCount, LazyListMeasuredItemProvider measuredItemProvider, int mainAxisAvailableSize, int beforeContentPadding, int afterContentPadding, int spaceBetweenItems, int firstVisibleItemIndex, int firstVisibleItemScrollOffset, float scrollToBeConsumed, long constraints, boolean isVertical, List<Integer> list, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, boolean reverseLayout, Density density, LazyListItemAnimator itemAnimator, int beyondBoundsItemCount, List<Integer> list2, boolean hasLookaheadPassOccurred, final boolean isLookingAhead, LazyListLayoutInfo postLookaheadLayoutInfo, CoroutineScope coroutineScope, final MutableState<Unit> mutableState, GraphicsContext graphicsContext, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int scrollDelta;
        int currentMainAxisOffset;
        int currentFirstItemIndex;
        int maxCrossAxis;
        int currentFirstItemScrollOffset;
        LazyListMeasuredItem firstItem;
        int layoutWidth;
        int layoutHeight;
        final LazyListMeasuredItem headerItem;
        int currentMainAxisOffset2;
        int maxOffset;
        boolean z;
        ArrayList target$iv;
        int size;
        int index;
        ArrayList arrayList;
        LazyListMeasuredItem lazyListMeasuredItem;
        LazyListMeasuredItem it;
        Orientation orientation;
        int i;
        int currentMainAxisOffset3;
        int layoutWidth2;
        int layoutHeight2;
        if (!(beforeContentPadding >= 0)) {
            throw new IllegalArgumentException("invalid beforeContentPadding".toString());
        }
        if (!(afterContentPadding >= 0)) {
            throw new IllegalArgumentException("invalid afterContentPadding".toString());
        }
        if (itemsCount <= 0) {
            int layoutWidth3 = Constraints.m6746getMinWidthimpl(constraints);
            int layoutHeight3 = Constraints.m6745getMinHeightimpl(constraints);
            itemAnimator.onMeasured(0, layoutWidth3, layoutHeight3, new ArrayList(), measuredItemProvider, isVertical, isLookingAhead, hasLookaheadPassOccurred, coroutineScope, graphicsContext);
            if (!isLookingAhead) {
                long disappearingItemsSize = itemAnimator.m968getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.m6973equalsimpl0(disappearingItemsSize, IntSize.INSTANCE.m6980getZeroYbymL2g())) {
                    int layoutWidth4 = ConstraintsKt.m6761constrainWidthK40F9xA(constraints, IntSize.m6975getWidthimpl(disappearingItemsSize));
                    int layoutHeight4 = ConstraintsKt.m6760constrainHeightK40F9xA(constraints, IntSize.m6974getHeightimpl(disappearingItemsSize));
                    layoutWidth2 = layoutWidth4;
                    layoutHeight2 = layoutHeight4;
                } else {
                    layoutWidth2 = layoutWidth3;
                    layoutHeight2 = layoutHeight3;
                }
            } else {
                layoutWidth2 = layoutWidth3;
                layoutHeight2 = layoutHeight3;
            }
            return new LazyListMeasureResult(null, 0, false, 0.0f, function3.invoke(Integer.valueOf(layoutWidth2), Integer.valueOf(layoutHeight2), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope $this$invoke) {
                }
            }), 0.0f, false, coroutineScope, density, measuredItemProvider.getChildConstraints(), CollectionsKt.emptyList(), -beforeContentPadding, mainAxisAvailableSize + afterContentPadding, 0, reverseLayout, isVertical ? Orientation.Vertical : Orientation.Horizontal, afterContentPadding, spaceBetweenItems, null);
        }
        int currentFirstItemIndex2 = firstVisibleItemIndex;
        int currentFirstItemScrollOffset2 = firstVisibleItemScrollOffset;
        if (currentFirstItemIndex2 >= itemsCount) {
            currentFirstItemIndex2 = itemsCount - 1;
            currentFirstItemScrollOffset2 = 0;
        }
        int scrollDelta2 = Math.round(scrollToBeConsumed);
        int currentFirstItemScrollOffset3 = currentFirstItemScrollOffset2 - scrollDelta2;
        if (currentFirstItemIndex2 == 0 && currentFirstItemScrollOffset3 < 0) {
            scrollDelta2 += currentFirstItemScrollOffset3;
            currentFirstItemScrollOffset3 = 0;
        }
        ArrayDeque visibleItems = new ArrayDeque();
        int minOffset = (-beforeContentPadding) + (spaceBetweenItems < 0 ? spaceBetweenItems : 0);
        int previousIndex = mainAxisAvailableSize;
        int currentFirstItemScrollOffset4 = currentFirstItemScrollOffset3 + minOffset;
        int maxCrossAxis2 = 0;
        boolean remeasureNeeded = false;
        while (currentFirstItemScrollOffset4 < 0 && currentFirstItemIndex2 > 0) {
            int previous = currentFirstItemIndex2 - 1;
            boolean remeasureNeeded2 = remeasureNeeded;
            LazyListMeasuredItem measuredItem = measuredItemProvider.getAndMeasure(previous);
            visibleItems.add(0, measuredItem);
            maxCrossAxis2 = Math.max(maxCrossAxis2, measuredItem.getCrossAxisSize());
            currentFirstItemScrollOffset4 += measuredItem.getSizeWithSpacings();
            currentFirstItemIndex2 = previous;
            remeasureNeeded = remeasureNeeded2;
        }
        boolean remeasureNeeded3 = remeasureNeeded;
        if (currentFirstItemScrollOffset4 < minOffset) {
            scrollDelta2 += currentFirstItemScrollOffset4;
            currentFirstItemScrollOffset4 = minOffset;
        }
        int currentFirstItemScrollOffset5 = currentFirstItemScrollOffset4 - minOffset;
        int index2 = currentFirstItemIndex2;
        int maxMainAxis = RangesKt.coerceAtLeast(previousIndex + afterContentPadding, 0);
        int currentMainAxisOffset4 = -currentFirstItemScrollOffset5;
        int indexInVisibleItems = 0;
        while (true) {
            currentFirstItemIndex2 = currentFirstItemIndex2;
            if (indexInVisibleItems >= visibleItems.size()) {
                break;
            }
            if (currentMainAxisOffset4 >= maxMainAxis) {
                visibleItems.remove(indexInVisibleItems);
                remeasureNeeded3 = true;
            } else {
                index2++;
                currentMainAxisOffset4 += ((LazyListMeasuredItem) visibleItems.get(indexInVisibleItems)).getSizeWithSpacings();
                indexInVisibleItems++;
            }
        }
        boolean remeasureNeeded4 = remeasureNeeded3;
        int currentFirstItemIndex3 = currentFirstItemIndex2;
        int i2 = currentMainAxisOffset4;
        int currentMainAxisOffset5 = index2;
        int index3 = i2;
        while (currentMainAxisOffset5 < itemsCount && (index3 < maxMainAxis || index3 <= 0 || visibleItems.isEmpty())) {
            int currentFirstItemIndex4 = currentFirstItemIndex3;
            LazyListMeasuredItem measuredItem2 = measuredItemProvider.getAndMeasure(currentMainAxisOffset5);
            int currentMainAxisOffset6 = index3 + measuredItem2.getSizeWithSpacings();
            if (currentMainAxisOffset6 <= minOffset) {
                currentMainAxisOffset3 = currentMainAxisOffset6;
                int currentMainAxisOffset7 = itemsCount - 1;
                if (currentMainAxisOffset5 != currentMainAxisOffset7) {
                    currentFirstItemScrollOffset5 -= measuredItem2.getSizeWithSpacings();
                    remeasureNeeded4 = true;
                    currentFirstItemIndex4 = currentMainAxisOffset5 + 1;
                }
                currentMainAxisOffset5++;
                currentFirstItemIndex3 = currentFirstItemIndex4;
                index3 = currentMainAxisOffset3;
            } else {
                currentMainAxisOffset3 = currentMainAxisOffset6;
            }
            int currentMainAxisOffset8 = measuredItem2.getCrossAxisSize();
            maxCrossAxis2 = Math.max(maxCrossAxis2, currentMainAxisOffset8);
            visibleItems.add(measuredItem2);
            currentMainAxisOffset5++;
            currentFirstItemIndex3 = currentFirstItemIndex4;
            index3 = currentMainAxisOffset3;
        }
        int currentFirstItemIndex5 = scrollDelta2;
        if (index3 >= previousIndex) {
            previousIndex = previousIndex;
            currentMainAxisOffset5 = currentMainAxisOffset5;
            maxMainAxis = maxMainAxis;
            scrollDelta = scrollDelta2;
            currentMainAxisOffset = index3;
            currentFirstItemIndex = currentFirstItemIndex3;
        } else {
            int toScrollBack = previousIndex - index3;
            currentFirstItemScrollOffset5 -= toScrollBack;
            int currentMainAxisOffset9 = index3 + toScrollBack;
            while (currentFirstItemScrollOffset5 < beforeContentPadding && currentFirstItemIndex3 > 0) {
                int maxOffset2 = previousIndex;
                int maxOffset3 = currentFirstItemIndex3 - 1;
                int index4 = currentMainAxisOffset5;
                LazyListMeasuredItem measuredItem3 = measuredItemProvider.getAndMeasure(maxOffset3);
                visibleItems.add(0, measuredItem3);
                maxCrossAxis2 = Math.max(maxCrossAxis2, measuredItem3.getCrossAxisSize());
                currentFirstItemScrollOffset5 += measuredItem3.getSizeWithSpacings();
                currentFirstItemIndex3 = maxOffset3;
                previousIndex = maxOffset2;
                currentMainAxisOffset5 = index4;
                maxMainAxis = maxMainAxis;
            }
            int scrollDelta3 = scrollDelta2 + toScrollBack;
            if (currentFirstItemScrollOffset5 >= 0) {
                scrollDelta = scrollDelta3;
                currentMainAxisOffset = currentMainAxisOffset9;
                currentFirstItemIndex = currentFirstItemIndex3;
            } else {
                int scrollDelta4 = scrollDelta3 + currentFirstItemScrollOffset5;
                int currentMainAxisOffset10 = currentMainAxisOffset9 + currentFirstItemScrollOffset5;
                currentFirstItemScrollOffset5 = 0;
                scrollDelta = scrollDelta4;
                currentMainAxisOffset = currentMainAxisOffset10;
                currentFirstItemIndex = currentFirstItemIndex3;
            }
        }
        float consumedScroll = (MathKt.getSign(Math.round(scrollToBeConsumed)) == MathKt.getSign(scrollDelta) && Math.abs(Math.round(scrollToBeConsumed)) >= Math.abs(scrollDelta)) ? scrollDelta : scrollToBeConsumed;
        float unconsumedScroll = scrollToBeConsumed - consumedScroll;
        float f = 0.0f;
        if (isLookingAhead && scrollDelta > currentFirstItemIndex5 && unconsumedScroll <= 0.0f) {
            f = (scrollDelta - currentFirstItemIndex5) + unconsumedScroll;
        }
        float scrollBackAmount = f;
        if (!(currentFirstItemScrollOffset5 >= 0)) {
            throw new IllegalArgumentException("negative currentFirstItemScrollOffset".toString());
        }
        int visibleItemsScrollOffset = -currentFirstItemScrollOffset5;
        LazyListMeasuredItem firstItem2 = (LazyListMeasuredItem) visibleItems.first();
        if (beforeContentPadding > 0 || spaceBetweenItems < 0) {
            int preScrollBackScrollDelta = visibleItems.size();
            int visibleItemsScrollOffset2 = 0;
            while (true) {
                if (visibleItemsScrollOffset2 >= preScrollBackScrollDelta) {
                    maxCrossAxis = maxCrossAxis2;
                    break;
                }
                int i3 = preScrollBackScrollDelta;
                int size2 = ((LazyListMeasuredItem) visibleItems.get(visibleItemsScrollOffset2)).getSizeWithSpacings();
                if (currentFirstItemScrollOffset5 == 0 || size2 > currentFirstItemScrollOffset5) {
                    maxCrossAxis = maxCrossAxis2;
                    break;
                }
                maxCrossAxis = maxCrossAxis2;
                int maxCrossAxis3 = CollectionsKt.getLastIndex(visibleItems);
                if (visibleItemsScrollOffset2 == maxCrossAxis3) {
                    break;
                }
                currentFirstItemScrollOffset5 -= size2;
                firstItem2 = (LazyListMeasuredItem) visibleItems.get(visibleItemsScrollOffset2 + 1);
                visibleItemsScrollOffset2++;
                preScrollBackScrollDelta = i3;
                maxCrossAxis2 = maxCrossAxis;
            }
            currentFirstItemScrollOffset = currentFirstItemScrollOffset5;
            firstItem = firstItem2;
        } else {
            currentFirstItemScrollOffset = currentFirstItemScrollOffset5;
            maxCrossAxis = maxCrossAxis2;
            firstItem = firstItem2;
        }
        List<LazyListMeasuredItem> listCreateItemsBeforeList = createItemsBeforeList(currentFirstItemIndex, measuredItemProvider, beyondBoundsItemCount, list2);
        List<LazyListMeasuredItem> list3 = listCreateItemsBeforeList;
        int size3 = list3.size();
        int index$iv = 0;
        int maxCrossAxis4 = maxCrossAxis;
        while (index$iv < size3) {
            Object item$iv = list3.get(index$iv);
            maxCrossAxis4 = Math.max(maxCrossAxis4, ((LazyListMeasuredItem) item$iv).getCrossAxisSize());
            index$iv++;
            list3 = list3;
        }
        LazyListMeasuredItem firstItem3 = firstItem;
        int currentMainAxisOffset11 = currentMainAxisOffset;
        int maxOffset4 = previousIndex;
        int index5 = currentMainAxisOffset5;
        List<LazyListMeasuredItem> listCreateItemsAfterList = createItemsAfterList(visibleItems, measuredItemProvider, itemsCount, beyondBoundsItemCount, list2, consumedScroll, isLookingAhead, postLookaheadLayoutInfo);
        int size4 = listCreateItemsAfterList.size();
        for (int index$iv2 = 0; index$iv2 < size4; index$iv2++) {
            Object item$iv2 = listCreateItemsAfterList.get(index$iv2);
            maxCrossAxis4 = Math.max(maxCrossAxis4, ((LazyListMeasuredItem) item$iv2).getCrossAxisSize());
        }
        boolean noExtraItems = Intrinsics.areEqual(firstItem3, visibleItems.first()) && listCreateItemsBeforeList.isEmpty() && listCreateItemsAfterList.isEmpty();
        int layoutWidth5 = ConstraintsKt.m6761constrainWidthK40F9xA(constraints, isVertical ? maxCrossAxis4 : currentMainAxisOffset11);
        int layoutHeight5 = ConstraintsKt.m6760constrainHeightK40F9xA(constraints, isVertical ? currentMainAxisOffset11 : maxCrossAxis4);
        final List<LazyListMeasuredItem> listCalculateItemsOffsets = calculateItemsOffsets(visibleItems, listCreateItemsBeforeList, listCreateItemsAfterList, layoutWidth5, layoutHeight5, currentMainAxisOffset11, maxOffset4, visibleItemsScrollOffset, isVertical, verticalArrangement, horizontalArrangement, reverseLayout, density);
        itemAnimator.onMeasured((int) consumedScroll, layoutWidth5, layoutHeight5, listCalculateItemsOffsets, measuredItemProvider, isVertical, isLookingAhead, hasLookaheadPassOccurred, coroutineScope, graphicsContext);
        if (!isLookingAhead) {
            long disappearingItemsSize2 = itemAnimator.m968getMinSizeToFitDisappearingItemsYbymL2g();
            if (!IntSize.m6973equalsimpl0(disappearingItemsSize2, IntSize.INSTANCE.m6980getZeroYbymL2g())) {
                if (!isVertical) {
                    i = layoutWidth5;
                } else {
                    i = layoutHeight5;
                }
                int oldMainAxisSize = i;
                layoutWidth = ConstraintsKt.m6761constrainWidthK40F9xA(constraints, Math.max(layoutWidth5, IntSize.m6975getWidthimpl(disappearingItemsSize2)));
                layoutHeight = ConstraintsKt.m6760constrainHeightK40F9xA(constraints, Math.max(layoutHeight5, IntSize.m6974getHeightimpl(disappearingItemsSize2)));
                int newMainAxisSize = isVertical ? layoutHeight : layoutWidth;
                if (newMainAxisSize != oldMainAxisSize) {
                    int size5 = listCalculateItemsOffsets.size();
                    for (int index$iv3 = 0; index$iv3 < size5; index$iv3++) {
                        Object item$iv3 = listCalculateItemsOffsets.get(index$iv3);
                        ((LazyListMeasuredItem) item$iv3).updateMainAxisLayoutSize(newMainAxisSize);
                    }
                }
            } else {
                layoutWidth = layoutWidth5;
                layoutHeight = layoutHeight5;
            }
        } else {
            layoutWidth = layoutWidth5;
            layoutHeight = layoutHeight5;
        }
        if (!list.isEmpty()) {
            headerItem = LazyListHeadersKt.findOrComposeLazyListHeader(listCalculateItemsOffsets, measuredItemProvider, list, beforeContentPadding, layoutWidth, layoutHeight);
        } else {
            headerItem = null;
        }
        if (index5 >= itemsCount) {
            currentMainAxisOffset2 = currentMainAxisOffset11;
            maxOffset = maxOffset4;
            if (currentMainAxisOffset2 <= maxOffset) {
                z = false;
            }
            MeasureResult measureResultInvoke = function3.invoke(Integer.valueOf(layoutWidth), Integer.valueOf(layoutHeight), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$8
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
                    List<LazyListMeasuredItem> list4 = listCalculateItemsOffsets;
                    LazyListMeasuredItem lazyListMeasuredItem2 = headerItem;
                    boolean z2 = isLookingAhead;
                    int size6 = list4.size();
                    for (int index$iv4 = 0; index$iv4 < size6; index$iv4++) {
                        Object item$iv4 = list4.get(index$iv4);
                        LazyListMeasuredItem it2 = (LazyListMeasuredItem) item$iv4;
                        if (it2 != lazyListMeasuredItem2) {
                            it2.place($this$invoke, z2);
                        }
                    }
                    LazyListMeasuredItem lazyListMeasuredItem3 = headerItem;
                    if (lazyListMeasuredItem3 != null) {
                        lazyListMeasuredItem3.place($this$invoke, isLookingAhead);
                    }
                    ObservableScopeInvalidator.m1042attachToScopeimpl(mutableState);
                }
            });
            if (noExtraItems) {
                arrayList = listCalculateItemsOffsets;
            } else {
                target$iv = new ArrayList(listCalculateItemsOffsets.size());
                size = listCalculateItemsOffsets.size();
                index = 0;
                while (index < size) {
                    lazyListMeasuredItem = listCalculateItemsOffsets.get(index);
                    int i4 = size;
                    int currentMainAxisOffset12 = currentMainAxisOffset2;
                    it = lazyListMeasuredItem;
                    int layoutHeight6 = layoutHeight;
                    int layoutWidth6 = layoutWidth;
                    if ((it.getIndex() < ((LazyListMeasuredItem) visibleItems.first()).getIndex() && it.getIndex() <= ((LazyListMeasuredItem) visibleItems.last()).getIndex()) || it == headerItem) {
                        target$iv.add(lazyListMeasuredItem);
                    }
                    index++;
                    size = i4;
                    currentMainAxisOffset2 = currentMainAxisOffset12;
                    layoutHeight = layoutHeight6;
                    layoutWidth = layoutWidth6;
                }
                arrayList = target$iv;
            }
            int i5 = -beforeContentPadding;
            int i6 = maxOffset + afterContentPadding;
            if (isVertical) {
                orientation = Orientation.Vertical;
            } else {
                orientation = Orientation.Horizontal;
            }
            return new LazyListMeasureResult(firstItem3, currentFirstItemScrollOffset, z, consumedScroll, measureResultInvoke, scrollBackAmount, remeasureNeeded4, coroutineScope, density, measuredItemProvider.getChildConstraints(), arrayList, i5, i6, itemsCount, reverseLayout, orientation, afterContentPadding, spaceBetweenItems, null);
        }
        currentMainAxisOffset2 = currentMainAxisOffset11;
        maxOffset = maxOffset4;
        z = true;
        MeasureResult measureResultInvoke2 = function3.invoke(Integer.valueOf(layoutWidth), Integer.valueOf(layoutHeight), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$8
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
                List<LazyListMeasuredItem> list4 = listCalculateItemsOffsets;
                LazyListMeasuredItem lazyListMeasuredItem2 = headerItem;
                boolean z2 = isLookingAhead;
                int size6 = list4.size();
                for (int index$iv4 = 0; index$iv4 < size6; index$iv4++) {
                    Object item$iv4 = list4.get(index$iv4);
                    LazyListMeasuredItem it2 = (LazyListMeasuredItem) item$iv4;
                    if (it2 != lazyListMeasuredItem2) {
                        it2.place($this$invoke, z2);
                    }
                }
                LazyListMeasuredItem lazyListMeasuredItem3 = headerItem;
                if (lazyListMeasuredItem3 != null) {
                    lazyListMeasuredItem3.place($this$invoke, isLookingAhead);
                }
                ObservableScopeInvalidator.m1042attachToScopeimpl(mutableState);
            }
        });
        if (noExtraItems) {
            arrayList = listCalculateItemsOffsets;
        } else {
            target$iv = new ArrayList(listCalculateItemsOffsets.size());
            size = listCalculateItemsOffsets.size();
            index = 0;
            while (index < size) {
                lazyListMeasuredItem = listCalculateItemsOffsets.get(index);
                int i7 = size;
                int currentMainAxisOffset13 = currentMainAxisOffset2;
                it = lazyListMeasuredItem;
                int layoutHeight7 = layoutHeight;
                int layoutWidth7 = layoutWidth;
                if ((it.getIndex() < ((LazyListMeasuredItem) visibleItems.first()).getIndex() && it.getIndex() <= ((LazyListMeasuredItem) visibleItems.last()).getIndex()) || it == headerItem) {
                    target$iv.add(lazyListMeasuredItem);
                }
                index++;
                size = i7;
                currentMainAxisOffset2 = currentMainAxisOffset13;
                layoutHeight = layoutHeight7;
                layoutWidth = layoutWidth7;
            }
            arrayList = target$iv;
        }
        int i8 = -beforeContentPadding;
        int i9 = maxOffset + afterContentPadding;
        if (isVertical) {
            orientation = Orientation.Vertical;
        } else {
            orientation = Orientation.Horizontal;
        }
        return new LazyListMeasureResult(firstItem3, currentFirstItemScrollOffset, z, consumedScroll, measureResultInvoke2, scrollBackAmount, remeasureNeeded4, coroutineScope, density, measuredItemProvider.getChildConstraints(), arrayList, i8, i9, itemsCount, reverseLayout, orientation, afterContentPadding, spaceBetweenItems, null);
    }

    private static final List<LazyListMeasuredItem> createItemsAfterList(List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider measuredItemProvider, int itemsCount, int beyondBoundsItemCount, List<Integer> list2, float consumedScroll, boolean isLookingAhead, LazyListLayoutInfo lastPostLookaheadLayoutInfo) {
        LazyListMeasuredItem lazyListMeasuredItem;
        Object it$iv;
        Object it$iv2;
        int i;
        int iMin;
        LazyListMeasuredItem lazyListMeasuredItem2;
        Object it$iv3;
        itemsCount = itemsCount;
        List list3 = null;
        int end = Math.min(((LazyListMeasuredItem) CollectionsKt.last((List) list)).getIndex() + beyondBoundsItemCount, itemsCount - 1);
        int i2 = ((LazyListMeasuredItem) CollectionsKt.last((List) list)).getIndex() + 1;
        if (i2 <= end) {
            while (true) {
                if (list3 == null) {
                    Object list4 = new ArrayList();
                    list3 = (List) list4;
                }
                list3.add(measuredItemProvider.getAndMeasure(i2));
                if (i2 == end) {
                    break;
                }
                i2++;
            }
        }
        if (isLookingAhead && lastPostLookaheadLayoutInfo != null && (!lastPostLookaheadLayoutInfo.getVisibleItemsInfo().isEmpty())) {
            List<LazyListItemInfo> visibleItemsInfo = lastPostLookaheadLayoutInfo.getVisibleItemsInfo();
            LazyListItemInfo found = null;
            for (int i3 = visibleItemsInfo.size() - 1; -1 < i3; i3--) {
                if (visibleItemsInfo.get(i3).getIndex() > end && (i3 == 0 || visibleItemsInfo.get(i3 - 1).getIndex() <= end)) {
                    LazyListItemInfo found2 = visibleItemsInfo.get(i3);
                    found = found2;
                    break;
                }
            }
            LazyListItemInfo firstItem = found;
            LazyListItemInfo lastVisibleItem = (LazyListItemInfo) CollectionsKt.last((List) lastPostLookaheadLayoutInfo.getVisibleItemsInfo());
            if (firstItem != null && (i = firstItem.getIndex()) <= (iMin = Math.min(lastVisibleItem.getIndex(), itemsCount - 1))) {
                while (true) {
                    if (list3 != null) {
                        List $this$fastFirstOrNull$iv = list3;
                        int index$iv$iv = 0;
                        int size = $this$fastFirstOrNull$iv.size();
                        while (true) {
                            if (index$iv$iv < size) {
                                Object item$iv$iv = $this$fastFirstOrNull$iv.get(index$iv$iv);
                                it$iv3 = item$iv$iv;
                                if (((LazyListMeasuredItem) it$iv3).getIndex() == i) {
                                    break;
                                }
                                index$iv$iv++;
                            } else {
                                it$iv3 = null;
                                break;
                            }
                        }
                        lazyListMeasuredItem2 = (LazyListMeasuredItem) it$iv3;
                    } else {
                        lazyListMeasuredItem2 = null;
                    }
                    if (lazyListMeasuredItem2 == null) {
                        if (list3 == null) {
                            Object list5 = new ArrayList();
                            list3 = (List) list5;
                        }
                        list3.add(measuredItemProvider.getAndMeasure(i));
                    }
                    if (i == iMin) {
                        break;
                    }
                    i++;
                }
            }
            float additionalOffset = ((lastPostLookaheadLayoutInfo.getViewportEndOffset() - lastVisibleItem.getOffset()) - lastVisibleItem.getSize()) - consumedScroll;
            if (additionalOffset > 0.0f) {
                int index = lastVisibleItem.getIndex() + 1;
                int totalOffset = 0;
                while (index < itemsCount && totalOffset < additionalOffset) {
                    if (index > end) {
                        if (list3 == null) {
                            lazyListMeasuredItem = null;
                        } else {
                            List $this$fastFirstOrNull$iv2 = list3;
                            int index$iv$iv2 = 0;
                            int size2 = $this$fastFirstOrNull$iv2.size();
                            while (true) {
                                if (index$iv$iv2 < size2) {
                                    Object item$iv$iv2 = $this$fastFirstOrNull$iv2.get(index$iv$iv2);
                                    it$iv = item$iv$iv2;
                                    if (((LazyListMeasuredItem) it$iv).getIndex() == index) {
                                        break;
                                    }
                                    index$iv$iv2++;
                                } else {
                                    it$iv = null;
                                    break;
                                }
                            }
                            lazyListMeasuredItem = (LazyListMeasuredItem) it$iv;
                        }
                    } else {
                        int index$iv$iv3 = 0;
                        int size3 = list.size();
                        while (true) {
                            if (index$iv$iv3 < size3) {
                                Object item$iv$iv3 = list.get(index$iv$iv3);
                                it$iv2 = item$iv$iv3;
                                if (((LazyListMeasuredItem) it$iv2).getIndex() == index) {
                                    break;
                                }
                                index$iv$iv3++;
                            } else {
                                it$iv2 = null;
                                break;
                            }
                        }
                        lazyListMeasuredItem = (LazyListMeasuredItem) it$iv2;
                    }
                    LazyListMeasuredItem item = lazyListMeasuredItem;
                    if (item != null) {
                        index++;
                        totalOffset += item.getSizeWithSpacings();
                    } else {
                        if (list3 == null) {
                            Object list6 = new ArrayList();
                            list3 = (List) list6;
                        }
                        list3.add(measuredItemProvider.getAndMeasure(index));
                        index++;
                        totalOffset += ((LazyListMeasuredItem) CollectionsKt.last(list3)).getSizeWithSpacings();
                    }
                }
            }
        }
        if (list3 != null) {
            List it = list3;
            if (((LazyListMeasuredItem) CollectionsKt.last(it)).getIndex() > end) {
                end = ((LazyListMeasuredItem) CollectionsKt.last(it)).getIndex();
            }
        }
        int size4 = list2.size();
        for (int index$iv = 0; index$iv < size4; index$iv++) {
            Object item$iv = list2.get(index$iv);
            int index2 = ((Number) item$iv).intValue();
            if (index2 > end) {
                if (list3 == null) {
                    List list7 = new ArrayList();
                    list3 = list7;
                }
                list3.add(measuredItemProvider.getAndMeasure(index2));
            }
        }
        return list3 == null ? CollectionsKt.emptyList() : list3;
    }

    private static final List<LazyListMeasuredItem> createItemsBeforeList(int currentFirstItemIndex, LazyListMeasuredItemProvider measuredItemProvider, int beyondBoundsItemCount, List<Integer> list) {
        ArrayList arrayList = null;
        int start = Math.max(0, currentFirstItemIndex - beyondBoundsItemCount);
        int i = currentFirstItemIndex - 1;
        if (start <= i) {
            while (true) {
                if (arrayList == null) {
                    Object list2 = new ArrayList();
                    arrayList = (List) list2;
                }
                arrayList.add(measuredItemProvider.getAndMeasure(i));
                if (i == start) {
                    break;
                }
                i--;
            }
        }
        int size = list.size() - 1;
        if (size >= 0) {
            do {
                int index$iv = size;
                size--;
                Object item$iv = list.get(index$iv);
                int index = ((Number) item$iv).intValue();
                if (index < start) {
                    if (arrayList == null) {
                        Object list3 = new ArrayList();
                        arrayList = (List) list3;
                    }
                    arrayList.add(measuredItemProvider.getAndMeasure(index));
                }
            } while (size >= 0);
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyListMeasuredItem> calculateItemsOffsets(List<LazyListMeasuredItem> list, List<LazyListMeasuredItem> list2, List<LazyListMeasuredItem> list3, int layoutWidth, int layoutHeight, int finalMainAxisOffset, int maxOffset, int itemsScrollOffset, boolean isVertical, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, boolean reverseLayout, Density density) {
        int[] offsets;
        int size;
        List<LazyListMeasuredItem> list4 = list;
        int mainAxisLayoutSize = isVertical ? layoutHeight : layoutWidth;
        boolean hasSpareSpace = finalMainAxisOffset < Math.min(mainAxisLayoutSize, maxOffset);
        if (hasSpareSpace) {
            if (!(itemsScrollOffset == 0)) {
                throw new IllegalStateException("non-zero itemsScrollOffset".toString());
            }
        }
        ArrayList positionedItems = new ArrayList(list.size() + list2.size() + list3.size());
        if (hasSpareSpace) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                throw new IllegalArgumentException("no extra items".toString());
            }
            int itemsCount = list.size();
            int[] sizes = new int[itemsCount];
            for (int i = 0; i < itemsCount; i++) {
                sizes[i] = list4.get(calculateItemsOffsets$reverseAware(i, reverseLayout, itemsCount)).getSize();
            }
            int[] offsets2 = new int[itemsCount];
            for (int i2 = 0; i2 < itemsCount; i2++) {
                offsets2[i2] = 0;
            }
            if (isVertical) {
                if (verticalArrangement != null) {
                    verticalArrangement.arrange(density, mainAxisLayoutSize, sizes, offsets2);
                    offsets = offsets2;
                } else {
                    throw new IllegalArgumentException("null verticalArrangement when isVertical == true".toString());
                }
            } else if (horizontalArrangement != null) {
                offsets = offsets2;
                horizontalArrangement.arrange(density, mainAxisLayoutSize, sizes, LayoutDirection.Ltr, offsets);
            } else {
                throw new IllegalArgumentException("null horizontalArrangement when isVertical == false".toString());
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
                    LazyListMeasuredItem item = list4.get(calculateItemsOffsets$reverseAware(index, reverseLayout, itemsCount));
                    if (reverseLayout) {
                        size = (mainAxisLayoutSize - absoluteOffset) - item.getSize();
                    } else {
                        size = absoluteOffset;
                    }
                    int relativeOffset = size;
                    item.position(relativeOffset, layoutWidth, layoutHeight);
                    positionedItems.add(item);
                    if (index == last) {
                        break;
                    }
                    index += step;
                    list4 = list;
                }
            }
        } else {
            int currentMainAxis = itemsScrollOffset;
            int size2 = list2.size();
            for (int index$iv = 0; index$iv < size2; index$iv++) {
                Object item$iv = list2.get(index$iv);
                LazyListMeasuredItem it = (LazyListMeasuredItem) item$iv;
                currentMainAxis -= it.getSizeWithSpacings();
                it.position(currentMainAxis, layoutWidth, layoutHeight);
                positionedItems.add(it);
            }
            int currentMainAxis2 = itemsScrollOffset;
            int size3 = list.size();
            for (int index$iv2 = 0; index$iv2 < size3; index$iv2++) {
                Object item$iv2 = list.get(index$iv2);
                LazyListMeasuredItem it2 = (LazyListMeasuredItem) item$iv2;
                it2.position(currentMainAxis2, layoutWidth, layoutHeight);
                positionedItems.add(it2);
                currentMainAxis2 += it2.getSizeWithSpacings();
            }
            int size4 = list3.size();
            for (int index$iv3 = 0; index$iv3 < size4; index$iv3++) {
                Object item$iv3 = list3.get(index$iv3);
                LazyListMeasuredItem it3 = (LazyListMeasuredItem) item$iv3;
                it3.position(currentMainAxis2, layoutWidth, layoutHeight);
                positionedItems.add(it3);
                currentMainAxis2 += it3.getSizeWithSpacings();
            }
        }
        return positionedItems;
    }

    private static final int calculateItemsOffsets$reverseAware(int $this$calculateItemsOffsets_u24reverseAware, boolean $reverseLayout, int itemsCount) {
        return !$reverseLayout ? $this$calculateItemsOffsets_u24reverseAware : (itemsCount - $this$calculateItemsOffsets_u24reverseAware) - 1;
    }
}
