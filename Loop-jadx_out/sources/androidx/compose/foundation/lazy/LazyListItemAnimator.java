package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimationSpecsNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.GraphicsContext;
import androidx.compose.p001ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p001ui.graphics.layer.GraphicsLayer;
import androidx.compose.p001ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.p001ui.node.DrawModifierNode;
import androidx.compose.p001ui.node.DrawModifierNodeKt;
import androidx.compose.p001ui.node.ModifierNodeElement;
import androidx.compose.p001ui.platform.InspectorInfo;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyListItemAnimator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0003<=>B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\tJ&\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\t2\f\b\u0002\u0010*\u001a\u00060\u000eR\u00020\u0000H\u0002J\\\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00042\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020 2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208J\u0010\u00109\u001a\u00020'2\u0006\u0010$\u001a\u00020\u0001H\u0002J\u0006\u0010:\u001a\u00020'J\u0010\u0010;\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001bH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u00060\u000eR\u00020\u00000\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\u00020\u00108Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0018j\b\u0012\u0004\u0012\u00020\u0001`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\u00020 *\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006?"}, m195d2 = {"Landroidx/compose/foundation/lazy/LazyListItemAnimator;", "", "()V", "disappearingItems", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "displayingNode", "Landroidx/compose/ui/node/DrawModifierNode;", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/LazyListItemAnimator$ItemInfo;", "minSizeToFitDisappearingItems", "Landroidx/compose/ui/unit/IntSize;", "getMinSizeToFitDisappearingItems-YbymL2g", "()J", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "movingAwayKeys", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "movingAwayToEndBound", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/LazyListMeasuredItem;)Z", "getAnimation", "key", "placeableIndex", "initializeAnimation", "", "item", "mainAxisOffset", "itemInfo", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "isVertical", "isLookingAhead", "hasLookaheadOccurred", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "removeInfoForKey", "reset", "startPlacementAnimationsIfNeeded", "DisplayingDisappearingItemsElement", "DisplayingDisappearingItemsNode", "ItemInfo", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LazyListItemAnimator {
    public static final int $stable = 8;
    private DrawModifierNode displayingNode;
    private int firstVisibleIndex;
    private LazyLayoutKeyIndexMap keyIndexMap;
    private final Map<Object, ItemInfo> keyToItemInfoMap = new LinkedHashMap();
    private final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    private final List<LazyListMeasuredItem> movingInFromStartBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingAwayToEndBound = new ArrayList();
    private final List<LazyLayoutAnimation> disappearingItems = new ArrayList();
    private final Modifier modifier = new DisplayingDisappearingItemsElement(this);

    /* JADX WARN: Code duplicated, block: B:161:0x040f A[LOOP:9: B:151:0x03ef->B:161:0x040f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:172:0x0430  */
    /* JADX WARN: Code duplicated, block: B:174:0x0434  */
    /* JADX WARN: Code duplicated, block: B:175:0x043a  */
    /* JADX WARN: Code duplicated, block: B:241:0x040d A[SYNTHETIC] */
    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, List<LazyListMeasuredItem> positionedItems, LazyListMeasuredItemProvider itemProvider, boolean isVertical, boolean isLookingAhead, boolean hasLookaheadOccurred, CoroutineScope coroutineScope, GraphicsContext graphicsContext) {
        boolean z;
        long jIntOffset;
        final LazyLayoutKeyIndexMap previousKeyToIndexMap;
        int offset;
        int mainAxisOffset;
        int accumulatedOffset;
        Iterable $this$forEach$iv;
        int $i$f$forEach;
        Iterator it;
        boolean z2;
        boolean z3;
        Iterable $this$forEach$iv2;
        int $i$f$fastForEach;
        int i;
        int previousFirstVisibleIndex;
        LazyLayoutKeyIndexMap previousKeyToIndexMap2;
        LazyLayoutKeyIndexMap keyIndexMap;
        int $i$f$forEach2;
        int previousFirstVisibleIndex2;
        LazyLayoutKeyIndexMap previousKeyToIndexMap3 = this.keyIndexMap;
        LazyLayoutKeyIndexMap keyIndexMap2 = itemProvider.getKeyIndexMap();
        this.keyIndexMap = keyIndexMap2;
        int $i$f$fastForEach2 = 0;
        int index$iv$iv = 0;
        int size = positionedItems.size();
        while (true) {
            int $i$f$fastForEach3 = $i$f$fastForEach2;
            if (index$iv$iv < size) {
                Object item$iv$iv = positionedItems.get(index$iv$iv);
                if (getHasAnimations((LazyListMeasuredItem) item$iv$iv)) {
                    z = true;
                    break;
                } else {
                    index$iv$iv++;
                    $i$f$fastForEach2 = $i$f$fastForEach3;
                }
            } else {
                z = false;
                break;
            }
        }
        boolean hasAnimations = z;
        if (!hasAnimations && this.keyToItemInfoMap.isEmpty()) {
            reset();
            return;
        }
        int previousFirstVisibleIndex3 = this.firstVisibleIndex;
        LazyListMeasuredItem lazyListMeasuredItem = (LazyListMeasuredItem) CollectionsKt.firstOrNull((List) positionedItems);
        this.firstVisibleIndex = lazyListMeasuredItem != null ? lazyListMeasuredItem.getIndex() : 0;
        int mainAxisLayoutSize = isVertical ? layoutHeight : layoutWidth;
        if (isVertical) {
            jIntOffset = IntOffsetKt.IntOffset(0, consumedScroll);
        } else {
            jIntOffset = IntOffsetKt.IntOffset(consumedScroll, 0);
        }
        long scrollOffset = jIntOffset;
        boolean shouldSetupAnimation = isLookingAhead || !hasLookaheadOccurred;
        this.movingAwayKeys.addAll(this.keyToItemInfoMap.keySet());
        List<LazyListMeasuredItem> list = positionedItems;
        int $i$f$fastForEach4 = 0;
        int index$iv = 0;
        int size2 = list.size();
        while (index$iv < size2) {
            Object item$iv = list.get(index$iv);
            LazyListMeasuredItem item = (LazyListMeasuredItem) item$iv;
            List<LazyListMeasuredItem> list2 = list;
            this.movingAwayKeys.remove(item.getKey());
            if (getHasAnimations(item)) {
                ItemInfo itemInfo = this.keyToItemInfoMap.get(item.getKey());
                int previousIndex = previousKeyToIndexMap3 != null ? previousKeyToIndexMap3.getIndex(item.getKey()) : -1;
                $i$f$fastForEach = $i$f$fastForEach4;
                boolean shouldAnimateAppearance = previousIndex == -1 && previousKeyToIndexMap3 != null;
                if (itemInfo == null) {
                    i = size2;
                    ItemInfo newItemInfo = new ItemInfo();
                    newItemInfo.updateAnimation(item, coroutineScope, graphicsContext);
                    this.keyToItemInfoMap.put(item.getKey(), newItemInfo);
                    if (item.getIndex() != previousIndex && previousIndex != -1) {
                        if (previousIndex < previousFirstVisibleIndex3) {
                            this.movingInFromStartBound.add(item);
                            previousFirstVisibleIndex = previousFirstVisibleIndex3;
                            previousKeyToIndexMap2 = previousKeyToIndexMap3;
                            keyIndexMap = keyIndexMap2;
                        } else {
                            this.movingInFromEndBound.add(item);
                            previousFirstVisibleIndex = previousFirstVisibleIndex3;
                            previousKeyToIndexMap2 = previousKeyToIndexMap3;
                            keyIndexMap = keyIndexMap2;
                        }
                    } else {
                        long it2 = item.m978getOffsetBjo55l4(0);
                        initializeAnimation(item, item.getIsVertical() ? IntOffset.m6934getYimpl(it2) : IntOffset.m6933getXimpl(it2), newItemInfo);
                        if (shouldAnimateAppearance) {
                            for (LazyLayoutAnimation lazyLayoutAnimation : newItemInfo.getAnimations()) {
                                if (lazyLayoutAnimation != null) {
                                    lazyLayoutAnimation.animateAppearance();
                                    Unit unit = Unit.INSTANCE;
                                }
                            }
                            previousFirstVisibleIndex = previousFirstVisibleIndex3;
                            previousKeyToIndexMap2 = previousKeyToIndexMap3;
                            keyIndexMap = keyIndexMap2;
                        } else {
                            previousFirstVisibleIndex = previousFirstVisibleIndex3;
                            previousKeyToIndexMap2 = previousKeyToIndexMap3;
                            keyIndexMap = keyIndexMap2;
                        }
                    }
                } else {
                    i = size2;
                    if (!shouldSetupAnimation) {
                        previousFirstVisibleIndex = previousFirstVisibleIndex3;
                        previousKeyToIndexMap2 = previousKeyToIndexMap3;
                        keyIndexMap = keyIndexMap2;
                    } else {
                        itemInfo.updateAnimation(item, coroutineScope, graphicsContext);
                        LazyLayoutAnimation[] animations = itemInfo.getAnimations();
                        int $i$f$forEach3 = 0;
                        int i2 = 0;
                        for (int length = animations.length; i2 < length; length = length) {
                            LazyLayoutAnimation lazyLayoutAnimation2 = animations[i2];
                            LazyLayoutAnimation[] lazyLayoutAnimationArr = animations;
                            if (lazyLayoutAnimation2 == null) {
                                $i$f$forEach2 = $i$f$forEach3;
                                previousFirstVisibleIndex2 = previousFirstVisibleIndex3;
                            } else {
                                $i$f$forEach2 = $i$f$forEach3;
                                previousFirstVisibleIndex2 = previousFirstVisibleIndex3;
                                if (!IntOffset.m6932equalsimpl0(lazyLayoutAnimation2.getRawOffset(), LazyLayoutAnimation.INSTANCE.m1021getNotInitializednOccac())) {
                                    long arg0$iv = lazyLayoutAnimation2.getRawOffset();
                                    int i3 = ((int) (arg0$iv >> 32)) + ((int) (scrollOffset >> 32));
                                    int i4 = (int) (arg0$iv & 4294967295L);
                                    int $i$f$unpackInt2 = (int) (scrollOffset & 4294967295L);
                                    lazyLayoutAnimation2.m1020setRawOffsetgyyYBs(IntOffsetKt.IntOffset(i3, i4 + $i$f$unpackInt2));
                                }
                            }
                            i2++;
                            previousKeyToIndexMap3 = previousKeyToIndexMap3;
                            previousFirstVisibleIndex3 = previousFirstVisibleIndex2;
                            animations = lazyLayoutAnimationArr;
                            $i$f$forEach3 = $i$f$forEach2;
                            keyIndexMap2 = keyIndexMap2;
                        }
                        previousFirstVisibleIndex = previousFirstVisibleIndex3;
                        previousKeyToIndexMap2 = previousKeyToIndexMap3;
                        keyIndexMap = keyIndexMap2;
                        if (shouldAnimateAppearance) {
                            for (LazyLayoutAnimation lazyLayoutAnimation3 : itemInfo.getAnimations()) {
                                if (lazyLayoutAnimation3 != null) {
                                    if (lazyLayoutAnimation3.isDisappearanceAnimationInProgress()) {
                                        this.disappearingItems.remove(lazyLayoutAnimation3);
                                        DrawModifierNode drawModifierNode = this.displayingNode;
                                        if (drawModifierNode != null) {
                                            DrawModifierNodeKt.invalidateDraw(drawModifierNode);
                                            Unit unit2 = Unit.INSTANCE;
                                        }
                                    }
                                    lazyLayoutAnimation3.animateAppearance();
                                }
                            }
                        }
                        startPlacementAnimationsIfNeeded(item);
                    }
                }
            } else {
                $i$f$fastForEach = $i$f$fastForEach4;
                i = size2;
                previousFirstVisibleIndex = previousFirstVisibleIndex3;
                previousKeyToIndexMap2 = previousKeyToIndexMap3;
                keyIndexMap = keyIndexMap2;
                removeInfoForKey(item.getKey());
            }
            index$iv++;
            previousKeyToIndexMap3 = previousKeyToIndexMap2;
            list = list2;
            $i$f$fastForEach4 = $i$f$fastForEach;
            size2 = i;
            previousFirstVisibleIndex3 = previousFirstVisibleIndex;
            keyIndexMap2 = keyIndexMap;
        }
        LazyLayoutKeyIndexMap previousKeyToIndexMap4 = previousKeyToIndexMap3;
        LazyLayoutKeyIndexMap keyIndexMap3 = keyIndexMap2;
        int accumulatedOffset2 = 0;
        if (!shouldSetupAnimation || previousKeyToIndexMap4 == null) {
            previousKeyToIndexMap = previousKeyToIndexMap4;
        } else {
            List<LazyListMeasuredItem> list3 = this.movingInFromStartBound;
            if (list3.size() > 1) {
                previousKeyToIndexMap = previousKeyToIndexMap4;
                CollectionsKt.sortWith(list3, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        LazyListMeasuredItem it3 = (LazyListMeasuredItem) t2;
                        LazyListMeasuredItem it4 = (LazyListMeasuredItem) t;
                        return ComparisonsKt.compareValues(Integer.valueOf(previousKeyToIndexMap.getIndex(it3.getKey())), Integer.valueOf(previousKeyToIndexMap.getIndex(it4.getKey())));
                    }
                });
            } else {
                previousKeyToIndexMap = previousKeyToIndexMap4;
            }
            List<LazyListMeasuredItem> list4 = this.movingInFromStartBound;
            int size3 = list4.size();
            int index$iv2 = 0;
            while (index$iv2 < size3) {
                Object item$iv2 = list4.get(index$iv2);
                LazyListMeasuredItem item2 = (LazyListMeasuredItem) item$iv2;
                int accumulatedOffset3 = accumulatedOffset2 + item2.getSizeWithSpacings();
                int mainAxisOffset2 = 0 - accumulatedOffset3;
                initializeAnimation$default(this, item2, mainAxisOffset2, null, 4, null);
                startPlacementAnimationsIfNeeded(item2);
                index$iv2++;
                accumulatedOffset2 = accumulatedOffset3;
            }
            accumulatedOffset2 = 0;
            List<LazyListMeasuredItem> list5 = this.movingInFromEndBound;
            if (list5.size() > 1) {
                CollectionsKt.sortWith(list5, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        LazyListMeasuredItem it3 = (LazyListMeasuredItem) t;
                        LazyListMeasuredItem it4 = (LazyListMeasuredItem) t2;
                        return ComparisonsKt.compareValues(Integer.valueOf(previousKeyToIndexMap.getIndex(it3.getKey())), Integer.valueOf(previousKeyToIndexMap.getIndex(it4.getKey())));
                    }
                });
            }
            List<LazyListMeasuredItem> list6 = this.movingInFromEndBound;
            int size4 = list6.size();
            int index$iv3 = 0;
            while (index$iv3 < size4) {
                Object item$iv3 = list6.get(index$iv3);
                LazyListMeasuredItem item3 = (LazyListMeasuredItem) item$iv3;
                int mainAxisOffset3 = mainAxisLayoutSize + accumulatedOffset2;
                int accumulatedOffset4 = accumulatedOffset2 + item3.getSizeWithSpacings();
                initializeAnimation$default(this, item3, mainAxisOffset3, null, 4, null);
                startPlacementAnimationsIfNeeded(item3);
                index$iv3++;
                accumulatedOffset2 = accumulatedOffset4;
            }
        }
        Iterable $this$forEach$iv3 = this.movingAwayKeys;
        int $i$f$forEach4 = 0;
        Iterator it3 = $this$forEach$iv3.iterator();
        while (it3.hasNext()) {
            Object element$iv = it3.next();
            LazyLayoutKeyIndexMap keyIndexMap4 = keyIndexMap3;
            int newIndex = keyIndexMap4.getIndex(element$iv);
            if (newIndex == -1) {
                ItemInfo info = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, element$iv);
                LazyLayoutAnimation[] animations2 = info.getAnimations();
                int length2 = animations2.length;
                int index$iv4 = 0;
                int index$iv5 = 0;
                int i5 = 0;
                while (i5 < length2) {
                    LazyLayoutAnimation lazyLayoutAnimation4 = animations2[i5];
                    int index$iv6 = index$iv4 + 1;
                    int accumulatedOffset5 = accumulatedOffset2;
                    if (lazyLayoutAnimation4 == null) {
                        $this$forEach$iv2 = $this$forEach$iv3;
                    } else if (lazyLayoutAnimation4.isDisappearanceAnimationInProgress()) {
                        index$iv5 = 1;
                        $this$forEach$iv2 = $this$forEach$iv3;
                    } else if (lazyLayoutAnimation4.isDisappearanceAnimationFinished()) {
                        lazyLayoutAnimation4.release();
                        info.getAnimations()[index$iv4] = null;
                        $this$forEach$iv2 = $this$forEach$iv3;
                        this.disappearingItems.remove(lazyLayoutAnimation4);
                        DrawModifierNode drawModifierNode2 = this.displayingNode;
                        if (drawModifierNode2 != null) {
                            DrawModifierNodeKt.invalidateDraw(drawModifierNode2);
                            Unit unit3 = Unit.INSTANCE;
                        }
                    } else {
                        $this$forEach$iv2 = $this$forEach$iv3;
                        if (lazyLayoutAnimation4.getLayer() != null) {
                            lazyLayoutAnimation4.animateDisappearance();
                        }
                        if (lazyLayoutAnimation4.isDisappearanceAnimationInProgress()) {
                            this.disappearingItems.add(lazyLayoutAnimation4);
                            DrawModifierNode drawModifierNode3 = this.displayingNode;
                            if (drawModifierNode3 != null) {
                                DrawModifierNodeKt.invalidateDraw(drawModifierNode3);
                                Unit unit4 = Unit.INSTANCE;
                            }
                            index$iv5 = 1;
                        } else {
                            lazyLayoutAnimation4.release();
                            info.getAnimations()[index$iv4] = null;
                        }
                    }
                    i5++;
                    index$iv4 = index$iv6;
                    $this$forEach$iv3 = $this$forEach$iv2;
                    accumulatedOffset2 = accumulatedOffset5;
                }
                accumulatedOffset = accumulatedOffset2;
                $this$forEach$iv = $this$forEach$iv3;
                if (index$iv5 != 0) {
                    $i$f$forEach = $i$f$forEach4;
                    it = it3;
                } else {
                    removeInfoForKey(element$iv);
                    $i$f$forEach = $i$f$forEach4;
                    it = it3;
                }
            } else {
                accumulatedOffset = accumulatedOffset2;
                $this$forEach$iv = $this$forEach$iv3;
                LazyListMeasuredItem item4 = itemProvider.getAndMeasure(newIndex);
                item4.setNonScrollableItem(true);
                LazyLayoutAnimation[] animations3 = ((ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, element$iv)).getAnimations();
                int length3 = animations3.length;
                int i6 = 0;
                while (true) {
                    if (i6 < length3) {
                        LazyLayoutAnimation lazyLayoutAnimation5 = animations3[i6];
                        if (lazyLayoutAnimation5 != null) {
                            $i$f$forEach = $i$f$forEach4;
                            it = it3;
                            z3 = lazyLayoutAnimation5.isPlacementAnimationInProgress();
                            if (z3) {
                                z2 = true;
                                break;
                            } else {
                                i6++;
                                $i$f$forEach4 = $i$f$forEach;
                                it3 = it;
                            }
                        } else {
                            $i$f$forEach = $i$f$forEach4;
                            it = it3;
                        }
                        if (z3) {
                            z2 = true;
                            break;
                        } else {
                            i6++;
                            $i$f$forEach4 = $i$f$forEach;
                            it3 = it;
                        }
                    } else {
                        $i$f$forEach = $i$f$forEach4;
                        it = it3;
                        z2 = false;
                        break;
                    }
                }
                boolean inProgress = z2;
                if (!inProgress) {
                    if (previousKeyToIndexMap != null && newIndex == previousKeyToIndexMap.getIndex(element$iv)) {
                        removeInfoForKey(element$iv);
                    } else if (newIndex < this.firstVisibleIndex) {
                        this.movingAwayToStartBound.add(item4);
                    } else {
                        this.movingAwayToEndBound.add(item4);
                    }
                } else if (newIndex < this.firstVisibleIndex) {
                    this.movingAwayToStartBound.add(item4);
                } else {
                    this.movingAwayToEndBound.add(item4);
                }
            }
            keyIndexMap3 = keyIndexMap4;
            $i$f$forEach4 = $i$f$forEach;
            it3 = it;
            $this$forEach$iv3 = $this$forEach$iv;
            accumulatedOffset2 = accumulatedOffset;
        }
        final LazyLayoutKeyIndexMap keyIndexMap5 = keyIndexMap3;
        int accumulatedOffset6 = 0;
        List<LazyListMeasuredItem> list7 = this.movingAwayToStartBound;
        if (list7.size() > 1) {
            CollectionsKt.sortWith(list7, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    LazyListMeasuredItem it4 = (LazyListMeasuredItem) t2;
                    LazyListMeasuredItem it5 = (LazyListMeasuredItem) t;
                    return ComparisonsKt.compareValues(Integer.valueOf(keyIndexMap5.getIndex(it4.getKey())), Integer.valueOf(keyIndexMap5.getIndex(it5.getKey())));
                }
            });
        }
        List<LazyListMeasuredItem> list8 = this.movingAwayToStartBound;
        int size5 = list8.size();
        for (int index$iv7 = 0; index$iv7 < size5; index$iv7++) {
            Object item$iv4 = list8.get(index$iv7);
            LazyListMeasuredItem item5 = (LazyListMeasuredItem) item$iv4;
            accumulatedOffset6 += item5.getSizeWithSpacings();
            if (isLookingAhead) {
                mainAxisOffset = ((LazyListMeasuredItem) CollectionsKt.first((List) positionedItems)).getOffset() - accumulatedOffset6;
            } else {
                mainAxisOffset = 0 - accumulatedOffset6;
            }
            item5.position(mainAxisOffset, layoutWidth, layoutHeight);
            if (shouldSetupAnimation) {
                startPlacementAnimationsIfNeeded(item5);
            }
        }
        int accumulatedOffset7 = 0;
        List<LazyListMeasuredItem> list9 = this.movingAwayToEndBound;
        if (list9.size() > 1) {
            CollectionsKt.sortWith(list9, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    LazyListMeasuredItem it4 = (LazyListMeasuredItem) t;
                    LazyListMeasuredItem it5 = (LazyListMeasuredItem) t2;
                    return ComparisonsKt.compareValues(Integer.valueOf(keyIndexMap5.getIndex(it4.getKey())), Integer.valueOf(keyIndexMap5.getIndex(it5.getKey())));
                }
            });
        }
        List<LazyListMeasuredItem> list10 = this.movingAwayToEndBound;
        int size6 = list10.size();
        for (int index$iv8 = 0; index$iv8 < size6; index$iv8++) {
            Object item$iv5 = list10.get(index$iv8);
            LazyListMeasuredItem item6 = (LazyListMeasuredItem) item$iv5;
            if (isLookingAhead) {
                LazyListMeasuredItem it4 = (LazyListMeasuredItem) CollectionsKt.last((List) positionedItems);
                offset = it4.getOffset() + it4.getSizeWithSpacings() + accumulatedOffset7;
            } else {
                offset = mainAxisLayoutSize + accumulatedOffset7;
            }
            int mainAxisOffset4 = offset;
            accumulatedOffset7 += item6.getSizeWithSpacings();
            item6.position(mainAxisOffset4, layoutWidth, layoutHeight);
            if (shouldSetupAnimation) {
                startPlacementAnimationsIfNeeded(item6);
            }
        }
        List<LazyListMeasuredItem> list11 = this.movingAwayToStartBound;
        CollectionsKt.reverse(list11);
        Unit unit5 = Unit.INSTANCE;
        positionedItems.addAll(0, list11);
        positionedItems.addAll(this.movingAwayToEndBound);
        this.movingInFromStartBound.clear();
        this.movingInFromEndBound.clear();
        this.movingAwayToStartBound.clear();
        this.movingAwayToEndBound.clear();
        this.movingAwayKeys.clear();
    }

    private final void removeInfoForKey(Object key) {
        LazyLayoutAnimation[] animations;
        ItemInfo itemInfoRemove = this.keyToItemInfoMap.remove(key);
        if (itemInfoRemove == null || (animations = itemInfoRemove.getAnimations()) == null) {
            return;
        }
        for (LazyLayoutAnimation lazyLayoutAnimation : animations) {
            if (lazyLayoutAnimation != null) {
                lazyLayoutAnimation.release();
            }
        }
    }

    public final void reset() {
        if (!this.keyToItemInfoMap.isEmpty()) {
            Iterator<Map.Entry<Object, ItemInfo>> it = this.keyToItemInfoMap.entrySet().iterator();
            while (it.hasNext()) {
                for (LazyLayoutAnimation lazyLayoutAnimation : it.next().getValue().getAnimations()) {
                    if (lazyLayoutAnimation != null) {
                        lazyLayoutAnimation.release();
                    }
                }
            }
            this.keyToItemInfoMap.clear();
        }
        this.keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
        this.firstVisibleIndex = -1;
    }

    static /* synthetic */ void initializeAnimation$default(LazyListItemAnimator lazyListItemAnimator, LazyListMeasuredItem lazyListMeasuredItem, int i, ItemInfo itemInfo, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            itemInfo = (ItemInfo) MapsKt.getValue(lazyListItemAnimator.keyToItemInfoMap, lazyListMeasuredItem.getKey());
        }
        lazyListItemAnimator.initializeAnimation(lazyListMeasuredItem, i, itemInfo);
    }

    private final void initializeAnimation(LazyListMeasuredItem item, int mainAxisOffset, ItemInfo itemInfo) {
        long targetFirstPlaceableOffset;
        int i = 0;
        long firstPlaceableOffset = item.m978getOffsetBjo55l4(0);
        if (item.getIsVertical()) {
            targetFirstPlaceableOffset = IntOffset.m6929copyiSbpLlY$default(firstPlaceableOffset, 0, mainAxisOffset, 1, null);
        } else {
            targetFirstPlaceableOffset = IntOffset.m6929copyiSbpLlY$default(firstPlaceableOffset, mainAxisOffset, 0, 2, null);
        }
        LazyLayoutAnimation[] animations = itemInfo.getAnimations();
        int $i$f$forEachIndexed = 0;
        int index$iv = 0;
        int length = animations.length;
        while (i < length) {
            LazyLayoutAnimation lazyLayoutAnimation = animations[i];
            int i2 = index$iv + 1;
            if (lazyLayoutAnimation != null) {
                long arg0$iv = item.m978getOffsetBjo55l4(index$iv);
                long value$iv$iv = firstPlaceableOffset;
                int $i$f$unpackInt1 = (int) (value$iv$iv >> 32);
                int i3 = ((int) (arg0$iv >> 32)) - $i$f$unpackInt1;
                int $i$f$unpackInt2 = (int) (arg0$iv & 4294967295L);
                long value$iv$iv2 = firstPlaceableOffset;
                long diffToFirstPlaceableOffset = IntOffsetKt.IntOffset(i3, $i$f$unpackInt2 - ((int) (value$iv$iv2 & 4294967295L)));
                long value$iv$iv3 = targetFirstPlaceableOffset;
                long value$iv$iv4 = targetFirstPlaceableOffset;
                lazyLayoutAnimation.m1020setRawOffsetgyyYBs(IntOffsetKt.IntOffset(((int) (value$iv$iv3 >> 32)) + ((int) (diffToFirstPlaceableOffset >> 32)), ((int) (value$iv$iv4 & 4294967295L)) + ((int) (diffToFirstPlaceableOffset & 4294967295L))));
            }
            i++;
            length = length;
            animations = animations;
            $i$f$forEachIndexed = $i$f$forEachIndexed;
            index$iv = i2;
            firstPlaceableOffset = firstPlaceableOffset;
        }
    }

    private final void startPlacementAnimationsIfNeeded(LazyListMeasuredItem item) {
        ItemInfo itemInfo = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, item.getKey());
        LazyLayoutAnimation[] animations = itemInfo.getAnimations();
        int $i$f$forEachIndexed = 0;
        int index$iv = 0;
        int length = animations.length;
        int i = 0;
        while (i < length) {
            LazyLayoutAnimation lazyLayoutAnimation = animations[i];
            int index$iv2 = index$iv + 1;
            if (lazyLayoutAnimation != null) {
                long newTarget = item.m978getOffsetBjo55l4(index$iv);
                long currentTarget = lazyLayoutAnimation.getRawOffset();
                if (!IntOffset.m6932equalsimpl0(currentTarget, LazyLayoutAnimation.INSTANCE.m1021getNotInitializednOccac()) && !IntOffset.m6932equalsimpl0(currentTarget, newTarget)) {
                    int $i$f$unpackInt1 = (int) (currentTarget >> 32);
                    int i2 = ((int) (newTarget >> 32)) - $i$f$unpackInt1;
                    int $i$f$unpackInt2 = (int) (newTarget & 4294967295L);
                    lazyLayoutAnimation.m1013animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(i2, $i$f$unpackInt2 - ((int) (currentTarget & 4294967295L))));
                }
                lazyLayoutAnimation.m1020setRawOffsetgyyYBs(newTarget);
            } else {
                animations = animations;
                $i$f$forEachIndexed = $i$f$forEachIndexed;
                length = length;
            }
            i++;
            index$iv = index$iv2;
            length = length;
            itemInfo = itemInfo;
            animations = animations;
            $i$f$forEachIndexed = $i$f$forEachIndexed;
        }
    }

    public final LazyLayoutAnimation getAnimation(Object key, int placeableIndex) {
        LazyLayoutAnimation[] animations;
        ItemInfo itemInfo = this.keyToItemInfoMap.get(key);
        if (itemInfo == null || (animations = itemInfo.getAnimations()) == null) {
            return null;
        }
        return animations[placeableIndex];
    }

    /* JADX INFO: renamed from: getMinSizeToFitDisappearingItems-YbymL2g, reason: not valid java name */
    public final long m968getMinSizeToFitDisappearingItemsYbymL2g() {
        long size = IntSize.INSTANCE.m6980getZeroYbymL2g();
        List<LazyLayoutAnimation> list = this.disappearingItems;
        int size2 = list.size();
        for (int index$iv = 0; index$iv < size2; index$iv++) {
            Object item$iv = list.get(index$iv);
            LazyLayoutAnimation it = (LazyLayoutAnimation) item$iv;
            GraphicsLayer layer = it.getLayer();
            if (layer != null) {
                size = IntSizeKt.IntSize(Math.max(IntSize.m6975getWidthimpl(size), IntOffset.m6933getXimpl(it.getRawOffset()) + IntSize.m6975getWidthimpl(layer.getSize())), Math.max(IntSize.m6974getHeightimpl(size), IntOffset.m6934getYimpl(it.getRawOffset()) + IntSize.m6974getHeightimpl(layer.getSize())));
            }
        }
        return size;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    private final boolean getHasAnimations(LazyListMeasuredItem $this$hasAnimations) {
        int placeablesCount = $this$hasAnimations.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            int index = i;
            if (LazyListItemAnimatorKt.getSpecs($this$hasAnimations.getParentData(index)) != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: compiled from: LazyListItemAnimator.kt */
    @Metadata(m194d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R0\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, m195d2 = {"Landroidx/compose/foundation/lazy/LazyListItemAnimator$ItemInfo;", "", "(Landroidx/compose/foundation/lazy/LazyListItemAnimator;)V", "<set-?>", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "animations", "getAnimations", "()[Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "[Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "updateAnimation", "", "positionedItem", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private final class ItemInfo {
        private LazyLayoutAnimation[] animations = LazyListItemAnimatorKt.EmptyArray;

        public ItemInfo() {
        }

        public final LazyLayoutAnimation[] getAnimations() {
            return this.animations;
        }

        public final void updateAnimation(LazyListMeasuredItem positionedItem, CoroutineScope coroutineScope, GraphicsContext graphicsContext) {
            int length = this.animations.length;
            for (int i = positionedItem.getPlaceablesCount(); i < length; i++) {
                LazyLayoutAnimation lazyLayoutAnimation = this.animations[i];
                if (lazyLayoutAnimation != null) {
                    lazyLayoutAnimation.release();
                }
            }
            if (this.animations.length != positionedItem.getPlaceablesCount()) {
                Object[] objArrCopyOf = Arrays.copyOf(this.animations, positionedItem.getPlaceablesCount());
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
                this.animations = (LazyLayoutAnimation[]) objArrCopyOf;
            }
            int placeablesCount = positionedItem.getPlaceablesCount();
            final LazyListItemAnimator lazyListItemAnimator = LazyListItemAnimator.this;
            for (int i2 = 0; i2 < placeablesCount; i2++) {
                int index = i2;
                LazyLayoutAnimationSpecsNode specs = LazyListItemAnimatorKt.getSpecs(positionedItem.getParentData(index));
                if (specs == null) {
                    LazyLayoutAnimation lazyLayoutAnimation2 = this.animations[index];
                    if (lazyLayoutAnimation2 != null) {
                        lazyLayoutAnimation2.release();
                    }
                    this.animations[index] = null;
                } else {
                    LazyLayoutAnimation it = this.animations[index];
                    if (it == null) {
                        it = new LazyLayoutAnimation(coroutineScope, graphicsContext, new Function0<Unit>() { // from class: androidx.compose.foundation.lazy.LazyListItemAnimator$ItemInfo$updateAnimation$1$animation$1
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                DrawModifierNode drawModifierNode = lazyListItemAnimator.displayingNode;
                                if (drawModifierNode != null) {
                                    DrawModifierNodeKt.invalidateDraw(drawModifierNode);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }
                        });
                        this.animations[index] = it;
                    }
                    it.setFadeInSpec(specs.getFadeInSpec());
                    it.setPlacementSpec(specs.getPlacementSpec());
                    it.setFadeOutSpec(specs.getFadeOutSpec());
                }
            }
        }
    }

    /* JADX INFO: compiled from: LazyListItemAnimator.kt */
    @Metadata(m194d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0004HÂ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\f\u0010\u0014\u001a\u00020\u0012*\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m195d2 = {"Landroidx/compose/foundation/lazy/LazyListItemAnimator$DisplayingDisappearingItemsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/LazyListItemAnimator$DisplayingDisappearingItemsNode;", "animator", "Landroidx/compose/foundation/lazy/LazyListItemAnimator;", "(Landroidx/compose/foundation/lazy/LazyListItemAnimator;)V", "component1", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final /* data */ class DisplayingDisappearingItemsElement extends ModifierNodeElement<DisplayingDisappearingItemsNode> {
        private final LazyListItemAnimator animator;

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final LazyListItemAnimator getAnimator() {
            return this.animator;
        }

        public static /* synthetic */ DisplayingDisappearingItemsElement copy$default(DisplayingDisappearingItemsElement displayingDisappearingItemsElement, LazyListItemAnimator lazyListItemAnimator, int i, Object obj) {
            if ((i & 1) != 0) {
                lazyListItemAnimator = displayingDisappearingItemsElement.animator;
            }
            return displayingDisappearingItemsElement.copy(lazyListItemAnimator);
        }

        public final DisplayingDisappearingItemsElement copy(LazyListItemAnimator animator) {
            return new DisplayingDisappearingItemsElement(animator);
        }

        @Override // androidx.compose.p001ui.node.ModifierNodeElement
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DisplayingDisappearingItemsElement) && Intrinsics.areEqual(this.animator, ((DisplayingDisappearingItemsElement) other).animator);
        }

        @Override // androidx.compose.p001ui.node.ModifierNodeElement
        public int hashCode() {
            return this.animator.hashCode();
        }

        public String toString() {
            return "DisplayingDisappearingItemsElement(animator=" + this.animator + ')';
        }

        public DisplayingDisappearingItemsElement(LazyListItemAnimator animator) {
            this.animator = animator;
        }

        @Override // androidx.compose.p001ui.node.ModifierNodeElement
        public DisplayingDisappearingItemsNode create() {
            return new DisplayingDisappearingItemsNode(this.animator);
        }

        @Override // androidx.compose.p001ui.node.ModifierNodeElement
        public void update(DisplayingDisappearingItemsNode node) {
            node.setAnimator(this.animator);
        }

        @Override // androidx.compose.p001ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
            $this$inspectableProperties.setName("DisplayingDisappearingItemsElement");
        }
    }

    /* JADX INFO: compiled from: LazyListItemAnimator.kt */
    @Metadata(m194d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0004HÂ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\f\u0010\u0014\u001a\u00020\u000f*\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m195d2 = {"Landroidx/compose/foundation/lazy/LazyListItemAnimator$DisplayingDisappearingItemsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "animator", "Landroidx/compose/foundation/lazy/LazyListItemAnimator;", "(Landroidx/compose/foundation/lazy/LazyListItemAnimator;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "onAttach", "", "onDetach", "setAnimator", "toString", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final /* data */ class DisplayingDisappearingItemsNode extends Modifier.Node implements DrawModifierNode {
        private LazyListItemAnimator animator;

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final LazyListItemAnimator getAnimator() {
            return this.animator;
        }

        public static /* synthetic */ DisplayingDisappearingItemsNode copy$default(DisplayingDisappearingItemsNode displayingDisappearingItemsNode, LazyListItemAnimator lazyListItemAnimator, int i, Object obj) {
            if ((i & 1) != 0) {
                lazyListItemAnimator = displayingDisappearingItemsNode.animator;
            }
            return displayingDisappearingItemsNode.copy(lazyListItemAnimator);
        }

        public final DisplayingDisappearingItemsNode copy(LazyListItemAnimator animator) {
            return new DisplayingDisappearingItemsNode(animator);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DisplayingDisappearingItemsNode) && Intrinsics.areEqual(this.animator, ((DisplayingDisappearingItemsNode) other).animator);
        }

        public int hashCode() {
            return this.animator.hashCode();
        }

        @Override // androidx.compose.p001ui.node.DrawModifierNode
        public /* synthetic */ void onMeasureResultChanged() {
            DrawModifierNode.CC.$default$onMeasureResultChanged(this);
        }

        public String toString() {
            return "DisplayingDisappearingItemsNode(animator=" + this.animator + ')';
        }

        public DisplayingDisappearingItemsNode(LazyListItemAnimator animator) {
            this.animator = animator;
        }

        @Override // androidx.compose.p001ui.node.DrawModifierNode
        public void draw(ContentDrawScope $this$draw) {
            List $this$fastForEach$iv = this.animator.disappearingItems;
            int size = $this$fastForEach$iv.size();
            int index$iv = 0;
            while (index$iv < size) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                LazyLayoutAnimation it = (LazyLayoutAnimation) item$iv;
                GraphicsLayer layer = it.getLayer();
                if (layer != null) {
                    float x = IntOffset.m6933getXimpl(it.getFinalOffset());
                    float y = IntOffset.m6934getYimpl(it.getFinalOffset());
                    ContentDrawScope $this$translate$iv = $this$draw;
                    float left$iv = x - IntOffset.m6933getXimpl(layer.getTopLeft());
                    float top$iv = y - IntOffset.m6934getYimpl(layer.getTopLeft());
                    $this$translate$iv.getDrawContext().getTransform().translate(left$iv, top$iv);
                    try {
                        GraphicsLayerKt.drawLayer($this$translate$iv, layer);
                        $this$translate$iv.getDrawContext().getTransform().translate(-left$iv, -top$iv);
                    } catch (Throwable th) {
                        $this$translate$iv.getDrawContext().getTransform().translate(-left$iv, -top$iv);
                        throw th;
                    }
                }
                index$iv++;
                $this$fastForEach$iv = $this$fastForEach$iv;
            }
            $this$draw.drawContent();
        }

        @Override // androidx.compose.ui.Modifier.Node
        public void onAttach() {
            this.animator.displayingNode = this;
        }

        @Override // androidx.compose.ui.Modifier.Node
        public void onDetach() {
            this.animator.reset();
        }

        public final void setAnimator(LazyListItemAnimator animator) {
            if (!Intrinsics.areEqual(this.animator, animator) && getNode().getIsAttached()) {
                this.animator.reset();
                animator.displayingNode = this;
                this.animator = animator;
            }
        }
    }
}
