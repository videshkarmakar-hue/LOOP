package androidx.compose.foundation.lazy.grid;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyGridItemPlacementAnimator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0004J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\tH\u0002JL\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\u001bJ\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006-"}, m195d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "", "()V", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/lazy/grid/ItemInfo;", "movingAwayKeys", "Landroidx/collection/MutableScatterSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;)Z", "getAnimation", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "key", "placeableIndex", "initializeAnimation", "", "item", "mainAxisOffset", "itemInfo", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "isVertical", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "reset", "startAnimationsIfNeeded", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LazyGridItemPlacementAnimator {
    public static final int $stable = 8;
    private int firstVisibleIndex;
    private final MutableScatterMap<Object, ItemInfo> keyToItemInfoMap = ScatterMapKt.mutableScatterMapOf();
    private LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
    private final MutableScatterSet<Object> movingAwayKeys = ScatterSetKt.mutableScatterSetOf();
    private final List<LazyGridMeasuredItem> movingInFromStartBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingAwayToEndBound = new ArrayList();

    /* JADX WARN: Code duplicated, block: B:139:0x0449 A[LOOP:9: B:129:0x0429->B:139:0x0449, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:217:0x0447 A[SYNTHETIC] */
    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, List<LazyGridMeasuredItem> positionedItems, LazyGridMeasuredItemProvider itemProvider, LazyGridSpanLayoutProvider spanLayoutProvider, boolean isVertical, CoroutineScope coroutineScope) {
        boolean z;
        long jIntOffset;
        int $i$f$forEach;
        Object[] k$iv;
        ScatterSet this_$iv$iv;
        int $i$f$forEachIndex;
        int $i$f$forEach2;
        Object[] k$iv2;
        int $i$f$forEachIndex2;
        boolean inProgress;
        int i;
        LazyLayoutAnimation[] lazyLayoutAnimationArr;
        boolean z2;
        int previousLineMainAxisSize;
        int previousLineMainAxisSize2;
        List<LazyGridMeasuredItem> list;
        int $i$f$fastForEach;
        int i2;
        int mainAxisLayoutSize;
        long scrollOffset;
        int i3;
        Object item$iv;
        Object[] k$iv3;
        int index$iv$iv = 0;
        int size = positionedItems.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = positionedItems.get(index$iv$iv);
                if (getHasAnimations((LazyGridMeasuredItem) item$iv$iv)) {
                    z = true;
                    break;
                }
                index$iv$iv++;
            } else {
                z = false;
                break;
            }
        }
        if (!z && this.keyToItemInfoMap.isEmpty()) {
            reset();
            return;
        }
        int previousFirstVisibleIndex = this.firstVisibleIndex;
        LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) CollectionsKt.firstOrNull((List) positionedItems);
        this.firstVisibleIndex = lazyGridMeasuredItem != null ? lazyGridMeasuredItem.getIndex() : 0;
        final LazyLayoutKeyIndexMap previousKeyToIndexMap = this.keyIndexMap;
        this.keyIndexMap = itemProvider.getKeyIndexMap();
        int mainAxisLayoutSize2 = isVertical ? layoutHeight : layoutWidth;
        if (isVertical) {
            jIntOffset = IntOffsetKt.IntOffset(0, consumedScroll);
        } else {
            jIntOffset = IntOffsetKt.IntOffset(consumedScroll, 0);
        }
        long scrollOffset2 = jIntOffset;
        ScatterMap this_$iv = this.keyToItemInfoMap;
        int $i$f$forEachKey = 0;
        Object[] k$iv4 = this_$iv.keys;
        long[] m$iv$iv = this_$iv.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 <= lastIndex$iv$iv) {
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                long[] m$iv$iv2 = m$iv$iv;
                ScatterMap this_$iv2 = this_$iv;
                int $i$f$forEachKey2 = $i$f$forEachKey;
                if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) == -9187201950435737472L) {
                    k$iv3 = k$iv4;
                } else {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    int j$iv$iv = 0;
                    while (j$iv$iv < bitCount$iv$iv) {
                        long value$iv$iv$iv = slot$iv$iv & 255;
                        int $i$f$isFull = value$iv$iv$iv < 128 ? 1 : 0;
                        if ($i$f$isFull != 0) {
                            int index$iv$iv2 = (i$iv$iv << 3) + j$iv$iv;
                            this.movingAwayKeys.add(k$iv4[index$iv$iv2]);
                        }
                        slot$iv$iv >>= 8;
                        j$iv$iv++;
                        k$iv4 = k$iv4;
                    }
                    k$iv3 = k$iv4;
                    if (bitCount$iv$iv != 8) {
                        break;
                    }
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    break;
                }
                i$iv$iv++;
                this_$iv = this_$iv2;
                $i$f$forEachKey = $i$f$forEachKey2;
                m$iv$iv = m$iv$iv2;
                k$iv4 = k$iv3;
            }
        }
        List<LazyGridMeasuredItem> list2 = positionedItems;
        int $i$f$fastForEach2 = 0;
        int index$iv = 0;
        int size2 = list2.size();
        while (index$iv < size2) {
            Object item$iv2 = list2.get(index$iv);
            LazyGridMeasuredItem item = (LazyGridMeasuredItem) item$iv2;
            this.movingAwayKeys.remove(item.getKey());
            if (getHasAnimations(item)) {
                ItemInfo itemInfo = this.keyToItemInfoMap.get(item.getKey());
                if (itemInfo == null) {
                    list = list2;
                    int crossAxisSize = item.getCrossAxisSize();
                    $i$f$fastForEach = $i$f$fastForEach2;
                    int $i$f$fastForEach3 = item.getCrossAxisOffset();
                    ItemInfo newItemInfo = new ItemInfo(crossAxisSize, $i$f$fastForEach3);
                    newItemInfo.updateAnimation(item, coroutineScope);
                    i2 = size2;
                    this.keyToItemInfoMap.set(item.getKey(), newItemInfo);
                    int previousIndex = previousKeyToIndexMap.getIndex(item.getKey());
                    if (previousIndex != -1 && item.getIndex() != previousIndex) {
                        if (previousIndex < previousFirstVisibleIndex) {
                            this.movingInFromStartBound.add(item);
                            mainAxisLayoutSize = mainAxisLayoutSize2;
                            scrollOffset = scrollOffset2;
                        } else {
                            this.movingInFromEndBound.add(item);
                            mainAxisLayoutSize = mainAxisLayoutSize2;
                            scrollOffset = scrollOffset2;
                        }
                    } else {
                        long it = item.getOffset();
                        initializeAnimation(item, item.getIsVertical() ? IntOffset.m6934getYimpl(it) : IntOffset.m6933getXimpl(it), newItemInfo);
                        mainAxisLayoutSize = mainAxisLayoutSize2;
                        scrollOffset = scrollOffset2;
                    }
                } else {
                    list = list2;
                    $i$f$fastForEach = $i$f$fastForEach2;
                    i2 = size2;
                    LazyLayoutAnimation[] animations = itemInfo.getAnimations();
                    int length = animations.length;
                    int $i$f$forEach3 = 0;
                    while ($i$f$forEach3 < length) {
                        LazyLayoutAnimation lazyLayoutAnimation = animations[$i$f$forEach3];
                        LazyLayoutAnimation[] lazyLayoutAnimationArr2 = animations;
                        if (lazyLayoutAnimation == null) {
                            i3 = length;
                            item$iv = item$iv2;
                        } else {
                            i3 = length;
                            item$iv = item$iv2;
                            if (!IntOffset.m6932equalsimpl0(lazyLayoutAnimation.getRawOffset(), LazyLayoutAnimation.INSTANCE.m1021getNotInitializednOccac())) {
                                long arg0$iv = lazyLayoutAnimation.getRawOffset();
                                int i4 = (int) (arg0$iv >> 32);
                                long value$iv$iv = scrollOffset2;
                                int $i$f$unpackInt1 = (int) (value$iv$iv >> 32);
                                int i5 = (int) (arg0$iv & 4294967295L);
                                long value$iv$iv2 = scrollOffset2;
                                int $i$f$unpackInt2 = (int) (value$iv$iv2 & 4294967295L);
                                lazyLayoutAnimation.m1020setRawOffsetgyyYBs(IntOffsetKt.IntOffset(i4 + $i$f$unpackInt1, i5 + $i$f$unpackInt2));
                            }
                        }
                        $i$f$forEach3++;
                        mainAxisLayoutSize2 = mainAxisLayoutSize2;
                        item$iv2 = item$iv;
                        animations = lazyLayoutAnimationArr2;
                        length = i3;
                        scrollOffset2 = scrollOffset2;
                    }
                    mainAxisLayoutSize = mainAxisLayoutSize2;
                    scrollOffset = scrollOffset2;
                    itemInfo.setCrossAxisSize(item.getCrossAxisSize());
                    itemInfo.setCrossAxisOffset(item.getCrossAxisOffset());
                    startAnimationsIfNeeded(item);
                }
            } else {
                list = list2;
                $i$f$fastForEach = $i$f$fastForEach2;
                i2 = size2;
                mainAxisLayoutSize = mainAxisLayoutSize2;
                scrollOffset = scrollOffset2;
                this.keyToItemInfoMap.remove(item.getKey());
            }
            index$iv++;
            mainAxisLayoutSize2 = mainAxisLayoutSize;
            list2 = list;
            $i$f$fastForEach2 = $i$f$fastForEach;
            size2 = i2;
            scrollOffset2 = scrollOffset;
        }
        int mainAxisLayoutSize3 = mainAxisLayoutSize2;
        int accumulatedOffset = 0;
        int previousLine = -1;
        int previousLineMainAxisSize3 = 0;
        List<LazyGridMeasuredItem> list3 = this.movingInFromStartBound;
        if (list3.size() > 1) {
            CollectionsKt.sortWith(list3, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    LazyGridMeasuredItem it2 = (LazyGridMeasuredItem) t2;
                    LazyGridMeasuredItem it3 = (LazyGridMeasuredItem) t;
                    return ComparisonsKt.compareValues(Integer.valueOf(previousKeyToIndexMap.getIndex(it2.getKey())), Integer.valueOf(previousKeyToIndexMap.getIndex(it3.getKey())));
                }
            });
        }
        List<LazyGridMeasuredItem> list4 = this.movingInFromStartBound;
        int size3 = list4.size();
        int index$iv2 = 0;
        while (index$iv2 < size3) {
            Object item$iv3 = list4.get(index$iv2);
            LazyGridMeasuredItem item2 = (LazyGridMeasuredItem) item$iv3;
            int line = isVertical ? item2.getRow() : item2.getColumn();
            if (line != -1 && line == previousLine) {
                previousLineMainAxisSize2 = Math.max(previousLineMainAxisSize3, item2.getMainAxisSize());
            } else {
                accumulatedOffset += previousLineMainAxisSize3;
                previousLineMainAxisSize2 = item2.getMainAxisSize();
                previousLine = line;
            }
            int accumulatedOffset2 = accumulatedOffset;
            int mainAxisOffset = (0 - accumulatedOffset2) - item2.getMainAxisSize();
            initializeAnimation$default(this, item2, mainAxisOffset, null, 4, null);
            startAnimationsIfNeeded(item2);
            index$iv2++;
            accumulatedOffset = accumulatedOffset2;
            previousLine = previousLine;
            previousLineMainAxisSize3 = previousLineMainAxisSize2;
        }
        int accumulatedOffset3 = 0;
        int previousLine2 = -1;
        int previousLineMainAxisSize4 = 0;
        List<LazyGridMeasuredItem> list5 = this.movingInFromEndBound;
        if (list5.size() > 1) {
            CollectionsKt.sortWith(list5, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    LazyGridMeasuredItem it2 = (LazyGridMeasuredItem) t;
                    LazyGridMeasuredItem it3 = (LazyGridMeasuredItem) t2;
                    return ComparisonsKt.compareValues(Integer.valueOf(previousKeyToIndexMap.getIndex(it2.getKey())), Integer.valueOf(previousKeyToIndexMap.getIndex(it3.getKey())));
                }
            });
        }
        List<LazyGridMeasuredItem> list6 = this.movingInFromEndBound;
        int size4 = list6.size();
        int index$iv3 = 0;
        while (index$iv3 < size4) {
            Object item$iv4 = list6.get(index$iv3);
            LazyGridMeasuredItem item3 = (LazyGridMeasuredItem) item$iv4;
            int line2 = isVertical ? item3.getRow() : item3.getColumn();
            if (line2 != -1 && line2 == previousLine2) {
                previousLineMainAxisSize = Math.max(previousLineMainAxisSize4, item3.getMainAxisSize());
            } else {
                accumulatedOffset3 += previousLineMainAxisSize4;
                previousLineMainAxisSize = item3.getMainAxisSize();
                previousLine2 = line2;
            }
            int accumulatedOffset4 = accumulatedOffset3;
            int mainAxisOffset2 = mainAxisLayoutSize3 + accumulatedOffset4;
            initializeAnimation$default(this, item3, mainAxisOffset2, null, 4, null);
            startAnimationsIfNeeded(item3);
            index$iv3++;
            accumulatedOffset3 = accumulatedOffset4;
            previousLine2 = previousLine2;
            previousLineMainAxisSize4 = previousLineMainAxisSize;
        }
        ScatterSet this_$iv3 = this.movingAwayKeys;
        int $i$f$forEach4 = 0;
        Object[] k$iv5 = this_$iv3.elements;
        ScatterSet this_$iv$iv2 = this_$iv3;
        int $i$f$forEachIndex3 = 0;
        long[] m$iv$iv3 = this_$iv$iv2.metadata;
        int lastIndex$iv$iv2 = m$iv$iv3.length - 2;
        int i$iv$iv2 = 0;
        if (0 <= lastIndex$iv$iv2) {
            while (true) {
                long slot$iv$iv2 = m$iv$iv3[i$iv$iv2];
                int accumulatedOffset5 = accumulatedOffset3;
                int previousLine3 = previousLine2;
                int previousLineMainAxisSize5 = previousLineMainAxisSize4;
                ScatterSet this_$iv4 = this_$iv3;
                long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv2) << 7) & slot$iv$iv2 & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                    $i$f$forEach = $i$f$forEach4;
                    k$iv = k$iv5;
                    this_$iv$iv = this_$iv$iv2;
                    $i$f$forEachIndex = $i$f$forEachIndex3;
                } else {
                    int i6 = 8;
                    int bitCount$iv$iv2 = 8 - ((~(i$iv$iv2 - lastIndex$iv$iv2)) >>> 31);
                    int j$iv$iv2 = 0;
                    while (j$iv$iv2 < bitCount$iv$iv2) {
                        long value$iv$iv$iv2 = slot$iv$iv2 & 255;
                        int $i$f$isFull2 = value$iv$iv$iv2 < 128 ? 1 : 0;
                        if ($i$f$isFull2 == 0) {
                            $i$f$forEach2 = $i$f$forEach4;
                            k$iv2 = k$iv5;
                            this_$iv$iv2 = this_$iv$iv2;
                            $i$f$forEachIndex2 = $i$f$forEachIndex3;
                        } else {
                            int index$iv$iv3 = (i$iv$iv2 << 3) + j$iv$iv2;
                            Object key = k$iv5[index$iv$iv3];
                            ItemInfo itemInfo2 = this.keyToItemInfoMap.get(key);
                            Intrinsics.checkNotNull(itemInfo2);
                            ItemInfo itemInfo3 = itemInfo2;
                            $i$f$forEach2 = $i$f$forEach4;
                            int newIndex = this.keyIndexMap.getIndex(key);
                            k$iv2 = k$iv5;
                            if (newIndex == -1) {
                                this.keyToItemInfoMap.remove(key);
                                this_$iv$iv2 = this_$iv$iv2;
                                $i$f$forEachIndex2 = $i$f$forEachIndex3;
                            } else {
                                LazyGridMeasuredItem item4 = LazyGridMeasuredItemProvider.m1006getAndMeasure3p2s80s$default(itemProvider, newIndex, 0, isVertical ? Constraints.INSTANCE.m6756fixedWidthOenEA2s(itemInfo3.getCrossAxisSize()) : Constraints.INSTANCE.m6755fixedHeightOenEA2s(itemInfo3.getCrossAxisSize()), 2, null);
                                item4.setNonScrollableItem(true);
                                LazyLayoutAnimation[] animations2 = itemInfo3.getAnimations();
                                int length2 = animations2.length;
                                $i$f$forEachIndex2 = $i$f$forEachIndex3;
                                int $i$f$forEachIndex4 = 0;
                                while (true) {
                                    if ($i$f$forEachIndex4 >= length2) {
                                        inProgress = false;
                                        break;
                                    }
                                    LazyLayoutAnimation lazyLayoutAnimation2 = animations2[$i$f$forEachIndex4];
                                    if (lazyLayoutAnimation2 != null) {
                                        i = length2;
                                        lazyLayoutAnimationArr = animations2;
                                        z2 = lazyLayoutAnimation2.isPlacementAnimationInProgress();
                                        if (z2) {
                                            inProgress = true;
                                            break;
                                        } else {
                                            $i$f$forEachIndex4++;
                                            length2 = i;
                                            animations2 = lazyLayoutAnimationArr;
                                        }
                                    } else {
                                        i = length2;
                                        lazyLayoutAnimationArr = animations2;
                                    }
                                    if (z2) {
                                        inProgress = true;
                                        break;
                                    } else {
                                        $i$f$forEachIndex4++;
                                        length2 = i;
                                        animations2 = lazyLayoutAnimationArr;
                                    }
                                }
                                if (!inProgress && newIndex == previousKeyToIndexMap.getIndex(key)) {
                                    this.keyToItemInfoMap.remove(key);
                                } else if (newIndex < this.firstVisibleIndex) {
                                    this.movingAwayToStartBound.add(item4);
                                } else {
                                    this.movingAwayToEndBound.add(item4);
                                }
                            }
                        }
                        i6 = 8;
                        slot$iv$iv2 >>= 8;
                        j$iv$iv2++;
                        $i$f$forEach4 = $i$f$forEach2;
                        $i$f$forEachIndex3 = $i$f$forEachIndex2;
                        k$iv5 = k$iv2;
                        this_$iv$iv2 = this_$iv$iv2;
                    }
                    $i$f$forEach = $i$f$forEach4;
                    k$iv = k$iv5;
                    this_$iv$iv = this_$iv$iv2;
                    $i$f$forEachIndex = $i$f$forEachIndex3;
                    if (bitCount$iv$iv2 != i6) {
                        break;
                    }
                }
                if (i$iv$iv2 == lastIndex$iv$iv2) {
                    break;
                }
                i$iv$iv2++;
                previousLineMainAxisSize4 = previousLineMainAxisSize5;
                this_$iv3 = this_$iv4;
                accumulatedOffset3 = accumulatedOffset5;
                previousLine2 = previousLine3;
                $i$f$forEach4 = $i$f$forEach;
                $i$f$forEachIndex3 = $i$f$forEachIndex;
                k$iv5 = k$iv;
                this_$iv$iv2 = this_$iv$iv;
            }
        }
        int accumulatedOffset6 = 0;
        int previousLine4 = -1;
        int previousLineMainAxisSize6 = 0;
        List<LazyGridMeasuredItem> list7 = this.movingAwayToStartBound;
        if (list7.size() > 1) {
            CollectionsKt.sortWith(list7, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    LazyGridMeasuredItem it2 = (LazyGridMeasuredItem) t2;
                    LazyGridMeasuredItem it3 = (LazyGridMeasuredItem) t;
                    return ComparisonsKt.compareValues(Integer.valueOf(this.this$0.keyIndexMap.getIndex(it2.getKey())), Integer.valueOf(this.this$0.keyIndexMap.getIndex(it3.getKey())));
                }
            });
        }
        List<LazyGridMeasuredItem> list8 = this.movingAwayToStartBound;
        int index$iv4 = 0;
        int size5 = list8.size();
        while (index$iv4 < size5) {
            Object item$iv5 = list8.get(index$iv4);
            LazyGridMeasuredItem item5 = (LazyGridMeasuredItem) item$iv5;
            int line3 = spanLayoutProvider.getLineIndexOfItem(item5.getIndex());
            List<LazyGridMeasuredItem> list9 = list8;
            if (line3 != -1 && line3 == previousLine4) {
                previousLineMainAxisSize6 = Math.max(previousLineMainAxisSize6, item5.getMainAxisSize());
            } else {
                accumulatedOffset6 += previousLineMainAxisSize6;
                previousLineMainAxisSize6 = item5.getMainAxisSize();
                previousLine4 = line3;
            }
            int mainAxisOffset3 = (0 - accumulatedOffset6) - item5.getMainAxisSize();
            int accumulatedOffset7 = accumulatedOffset6;
            ItemInfo itemInfo4 = this.keyToItemInfoMap.get(item5.getKey());
            Intrinsics.checkNotNull(itemInfo4);
            ItemInfo itemInfo5 = itemInfo4;
            LazyGridMeasuredItem.position$default(item5, mainAxisOffset3, itemInfo5.getCrossAxisOffset(), layoutWidth, layoutHeight, 0, 0, 48, null);
            positionedItems.add(item5);
            startAnimationsIfNeeded(item5);
            index$iv4++;
            list8 = list9;
            accumulatedOffset6 = accumulatedOffset7;
            previousLine4 = previousLine4;
        }
        int accumulatedOffset8 = 0;
        int previousLine5 = -1;
        int previousLineMainAxisSize7 = 0;
        List<LazyGridMeasuredItem> list10 = this.movingAwayToEndBound;
        if (list10.size() > 1) {
            CollectionsKt.sortWith(list10, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    LazyGridMeasuredItem it2 = (LazyGridMeasuredItem) t;
                    LazyGridMeasuredItem it3 = (LazyGridMeasuredItem) t2;
                    return ComparisonsKt.compareValues(Integer.valueOf(this.this$0.keyIndexMap.getIndex(it2.getKey())), Integer.valueOf(this.this$0.keyIndexMap.getIndex(it3.getKey())));
                }
            });
        }
        List<LazyGridMeasuredItem> list11 = this.movingAwayToEndBound;
        int $i$f$fastForEach4 = 0;
        int index$iv5 = 0;
        int size6 = list11.size();
        while (index$iv5 < size6) {
            Object item$iv6 = list11.get(index$iv5);
            LazyGridMeasuredItem item6 = (LazyGridMeasuredItem) item$iv6;
            List<LazyGridMeasuredItem> list12 = list11;
            int line4 = spanLayoutProvider.getLineIndexOfItem(item6.getIndex());
            int $i$f$fastForEach5 = $i$f$fastForEach4;
            if (line4 != -1 && line4 == previousLine5) {
                previousLineMainAxisSize7 = Math.max(previousLineMainAxisSize7, item6.getMainAxisSize());
            } else {
                accumulatedOffset8 += previousLineMainAxisSize7;
                previousLineMainAxisSize7 = item6.getMainAxisSize();
                previousLine5 = line4;
            }
            int mainAxisOffset4 = mainAxisLayoutSize3 + accumulatedOffset8;
            int accumulatedOffset9 = accumulatedOffset8;
            ItemInfo itemInfo6 = this.keyToItemInfoMap.get(item6.getKey());
            Intrinsics.checkNotNull(itemInfo6);
            ItemInfo itemInfo7 = itemInfo6;
            LazyGridMeasuredItem.position$default(item6, mainAxisOffset4, itemInfo7.getCrossAxisOffset(), layoutWidth, layoutHeight, 0, 0, 48, null);
            positionedItems.add(item6);
            startAnimationsIfNeeded(item6);
            index$iv5++;
            list11 = list12;
            $i$f$fastForEach4 = $i$f$fastForEach5;
            accumulatedOffset8 = accumulatedOffset9;
            previousLine5 = previousLine5;
        }
        this.movingInFromStartBound.clear();
        this.movingInFromEndBound.clear();
        this.movingAwayToStartBound.clear();
        this.movingAwayToEndBound.clear();
        this.movingAwayKeys.clear();
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
        this.firstVisibleIndex = -1;
    }

    static /* synthetic */ void initializeAnimation$default(LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, LazyGridMeasuredItem lazyGridMeasuredItem, int i, ItemInfo itemInfo, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            ItemInfo itemInfo2 = lazyGridItemPlacementAnimator.keyToItemInfoMap.get(lazyGridMeasuredItem.getKey());
            Intrinsics.checkNotNull(itemInfo2);
            itemInfo = itemInfo2;
        }
        lazyGridItemPlacementAnimator.initializeAnimation(lazyGridMeasuredItem, i, itemInfo);
    }

    private final void initializeAnimation(LazyGridMeasuredItem item, int mainAxisOffset, ItemInfo itemInfo) {
        long targetFirstPlaceableOffset;
        long firstPlaceableOffset = item.getOffset();
        if (item.getIsVertical()) {
            targetFirstPlaceableOffset = IntOffset.m6929copyiSbpLlY$default(firstPlaceableOffset, 0, mainAxisOffset, 1, null);
        } else {
            targetFirstPlaceableOffset = IntOffset.m6929copyiSbpLlY$default(firstPlaceableOffset, mainAxisOffset, 0, 2, null);
        }
        LazyLayoutAnimation[] animations = itemInfo.getAnimations();
        int $i$f$forEach = 0;
        int length = animations.length;
        int i = 0;
        while (i < length) {
            LazyLayoutAnimation lazyLayoutAnimation = animations[i];
            if (lazyLayoutAnimation != null) {
                long arg0$iv = item.getOffset();
                int $i$f$unpackInt1 = (int) (firstPlaceableOffset >> 32);
                int i2 = ((int) (arg0$iv >> 32)) - $i$f$unpackInt1;
                int $i$f$unpackInt2 = (int) (arg0$iv & 4294967295L);
                long diffToFirstPlaceableOffset = IntOffsetKt.IntOffset(i2, $i$f$unpackInt2 - ((int) (firstPlaceableOffset & 4294967295L)));
                long value$iv$iv = targetFirstPlaceableOffset;
                int $i$f$unpackInt3 = (int) (value$iv$iv >> 32);
                long value$iv$iv2 = targetFirstPlaceableOffset;
                long targetFirstPlaceableOffset2 = value$iv$iv2 & 4294967295L;
                int i3 = (int) targetFirstPlaceableOffset2;
                int $i$f$unpackInt4 = (int) (diffToFirstPlaceableOffset & 4294967295L);
                lazyLayoutAnimation.m1020setRawOffsetgyyYBs(IntOffsetKt.IntOffset($i$f$unpackInt3 + ((int) (diffToFirstPlaceableOffset >> 32)), i3 + $i$f$unpackInt4));
            }
            i++;
            length = length;
            animations = animations;
            $i$f$forEach = $i$f$forEach;
            targetFirstPlaceableOffset = targetFirstPlaceableOffset;
        }
    }

    private final void startAnimationsIfNeeded(LazyGridMeasuredItem item) {
        ItemInfo itemInfo = this.keyToItemInfoMap.get(item.getKey());
        Intrinsics.checkNotNull(itemInfo);
        ItemInfo itemInfo2 = itemInfo;
        LazyLayoutAnimation[] animations = itemInfo2.getAnimations();
        int $i$f$forEach = 0;
        int length = animations.length;
        int i = 0;
        while (i < length) {
            LazyLayoutAnimation lazyLayoutAnimation = animations[i];
            if (lazyLayoutAnimation == null) {
                itemInfo2 = itemInfo2;
                animations = animations;
                $i$f$forEach = $i$f$forEach;
                length = length;
                i = i;
            } else {
                long newTarget = item.getOffset();
                long currentTarget = lazyLayoutAnimation.getRawOffset();
                if (!IntOffset.m6932equalsimpl0(currentTarget, LazyLayoutAnimation.INSTANCE.m1021getNotInitializednOccac()) && !IntOffset.m6932equalsimpl0(currentTarget, newTarget)) {
                    int $i$f$unpackInt1 = (int) (currentTarget >> 32);
                    int i2 = ((int) (newTarget >> 32)) - $i$f$unpackInt1;
                    int $i$f$unpackInt2 = (int) (newTarget & 4294967295L);
                    lazyLayoutAnimation.m1013animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(i2, $i$f$unpackInt2 - ((int) (4294967295L & currentTarget))));
                }
                lazyLayoutAnimation.m1020setRawOffsetgyyYBs(newTarget);
            }
            i++;
            animations = animations;
            length = length;
            itemInfo2 = itemInfo2;
            $i$f$forEach = $i$f$forEach;
        }
    }

    public final LazyLayoutAnimation getAnimation(Object key, int placeableIndex) {
        ItemInfo itemInfo;
        LazyLayoutAnimation[] animations;
        if (this.keyToItemInfoMap.isEmpty() || (itemInfo = this.keyToItemInfoMap.get(key)) == null || (animations = itemInfo.getAnimations()) == null) {
            return null;
        }
        return animations[placeableIndex];
    }

    private final boolean getHasAnimations(LazyGridMeasuredItem $this$hasAnimations) {
        int placeablesCount = $this$hasAnimations.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            int index = i;
            if (LazyGridItemPlacementAnimatorKt.getSpecs($this$hasAnimations.getParentData(index)) != null) {
                return true;
            }
        }
        return false;
    }
}
