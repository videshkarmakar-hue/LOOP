package androidx.compose.foundation.layout;

import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: RowColumnMeasurePolicy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, m195d2 = {"measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "mainAxisMin", "", "crossAxisMin", "mainAxisMax", "crossAxisMax", "arrangementSpacingInt", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "startIndex", "endIndex", "crossAxisOffset", "", "currentLineIndex", "(Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;IIIIILandroidx/compose/ui/layout/MeasureScope;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;II[II)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class RowColumnMeasurePolicyKt {
    public static /* synthetic */ MeasureResult measure$default(RowColumnMeasurePolicy rowColumnMeasurePolicy, int i, int i2, int i3, int i4, int i5, MeasureScope measureScope, List list, Placeable[] placeableArr, int i6, int i7, int[] iArr, int i8, int i9, Object obj) {
        int[] iArr2;
        if ((i9 & 1024) == 0) {
            iArr2 = iArr;
        } else {
            iArr2 = null;
        }
        return measure(rowColumnMeasurePolicy, i, i2, i3, i4, i5, measureScope, list, placeableArr, i6, i7, iArr2, (i9 & 2048) != 0 ? 0 : i8);
    }

    public static final MeasureResult measure(RowColumnMeasurePolicy $this$measure, int mainAxisMin, int crossAxisMin, int mainAxisMax, int crossAxisMax, int arrangementSpacingInt, MeasureScope measureScope, List<? extends Measurable> list, Placeable[] placeables, int startIndex, int endIndex, int[] crossAxisOffset, int currentLineIndex) {
        int i;
        int[] childrenMainAxisSize;
        long arrangementSpacingPx;
        int crossAxisSpace;
        int fixedSpace;
        int fixedSpace2;
        Integer numValueOf;
        FlowLayoutData it;
        int i2;
        int i3;
        int[] childrenMainAxisSize2;
        FlowLayoutData it2;
        long arrangementSpacingPx2 = arrangementSpacingInt;
        int subSize = endIndex - startIndex;
        int[] childrenMainAxisSize3 = new int[subSize];
        int beforeCrossAxisAlignmentLine = 0;
        int afterCrossAxisAlignmentLine = 0;
        int fixedSpace3 = 0;
        int weightChildrenCount = 0;
        boolean anyAlignBy = false;
        int spaceAfterLastNoWeight = 0;
        int i4 = startIndex;
        float totalWeight = 0.0f;
        int spaceAfterLastNoWeight2 = 0;
        while (true) {
            Integer numValueOf2 = null;
            boolean z = true;
            if (i4 >= endIndex) {
                break;
            }
            Measurable child = list.get(i4);
            RowColumnParentData parentData = RowColumnImplKt.getRowColumnParentData(child);
            float weight = RowColumnImplKt.getWeight(parentData);
            if (!anyAlignBy && !RowColumnImplKt.isRelative(parentData)) {
                z = false;
            }
            anyAlignBy = z;
            if (weight > 0.0f) {
                totalWeight += weight;
                weightChildrenCount++;
                i4 = i4;
                subSize = subSize;
                childrenMainAxisSize2 = childrenMainAxisSize3;
            } else {
                if (crossAxisMax != Integer.MAX_VALUE && parentData != null && (it2 = parentData.getFlowLayoutData()) != null) {
                    float $this$fastRoundToInt$iv = it2.getFillCrossAxisFraction() * crossAxisMax;
                    int $i$f$fastRoundToInt = Math.round($this$fastRoundToInt$iv);
                    numValueOf2 = Integer.valueOf($i$f$fastRoundToInt);
                }
                Integer crossAxisDesiredSize = numValueOf2;
                int remaining = mainAxisMax - fixedSpace3;
                Placeable placeable = placeables[i4];
                if (placeable == null) {
                    int remaining2 = crossAxisDesiredSize != null ? crossAxisDesiredSize.intValue() : 0;
                    int iCoerceAtLeast = mainAxisMax == Integer.MAX_VALUE ? Integer.MAX_VALUE : RangesKt.coerceAtLeast(remaining, 0);
                    int i5 = crossAxisDesiredSize != null ? crossAxisDesiredSize.intValue() : crossAxisMax;
                    placeable = child.mo5644measureBRTryo0(RowColumnMeasurePolicy.CC.m893createConstraintsxF2OJ5Q$default($this$measure, 0, remaining2, iCoerceAtLeast, i5, false, 16, null));
                }
                int placeableMainAxisSize = $this$measure.mainAxisSize(placeable);
                int placeableCrossAxisSize = $this$measure.crossAxisSize(placeable);
                childrenMainAxisSize2 = childrenMainAxisSize3;
                childrenMainAxisSize2[i4 - startIndex] = placeableMainAxisSize;
                int spaceAfterLastNoWeight3 = Math.min(arrangementSpacingInt, RangesKt.coerceAtLeast(remaining - placeableMainAxisSize, 0));
                fixedSpace3 += placeableMainAxisSize + spaceAfterLastNoWeight3;
                int crossAxisSpace2 = spaceAfterLastNoWeight2;
                spaceAfterLastNoWeight2 = Math.max(crossAxisSpace2, placeableCrossAxisSize);
                placeables[i4] = placeable;
                spaceAfterLastNoWeight = spaceAfterLastNoWeight3;
            }
            i4++;
            childrenMainAxisSize3 = childrenMainAxisSize2;
            subSize = subSize;
        }
        int subSize2 = subSize;
        int[] childrenMainAxisSize4 = childrenMainAxisSize3;
        if (weightChildrenCount == 0) {
            childrenMainAxisSize = childrenMainAxisSize4;
            arrangementSpacingPx = arrangementSpacingPx2;
            fixedSpace = fixedSpace3 - spaceAfterLastNoWeight;
            fixedSpace2 = 0;
            crossAxisSpace = spaceAfterLastNoWeight2;
        } else {
            if (mainAxisMax != Integer.MAX_VALUE) {
                i = mainAxisMax;
            } else {
                i = mainAxisMin;
            }
            int targetSpace = i;
            long arrangementSpacingTotal = arrangementSpacingPx2 * ((long) (weightChildrenCount - 1));
            childrenMainAxisSize = childrenMainAxisSize4;
            long remainingToTarget = RangesKt.coerceAtLeast(((long) (targetSpace - fixedSpace3)) - arrangementSpacingTotal, 0L);
            float weightUnitSpace = remainingToTarget / totalWeight;
            long remainder = remainingToTarget;
            int i6 = startIndex;
            while (i6 < endIndex) {
                Measurable measurable = list.get(i6);
                float $this$fastRoundToInt$iv2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(measurable)) * weightUnitSpace;
                int crossAxisSpace3 = spaceAfterLastNoWeight2;
                remainder -= (long) Math.round($this$fastRoundToInt$iv2);
                i6++;
                remainingToTarget = remainingToTarget;
                spaceAfterLastNoWeight2 = crossAxisSpace3;
            }
            int weightedSpace = 0;
            int i7 = startIndex;
            while (i7 < endIndex) {
                if (placeables[i7] == null) {
                    Measurable child2 = list.get(i7);
                    RowColumnParentData parentData2 = RowColumnImplKt.getRowColumnParentData(child2);
                    float weight2 = RowColumnImplKt.getWeight(parentData2);
                    if (crossAxisMax == Integer.MAX_VALUE || parentData2 == null || (it = parentData2.getFlowLayoutData()) == null) {
                        numValueOf = null;
                    } else {
                        float $this$fastRoundToInt$iv3 = it.getFillCrossAxisFraction() * crossAxisMax;
                        int $i$f$fastRoundToInt2 = Math.round($this$fastRoundToInt$iv3);
                        numValueOf = Integer.valueOf($i$f$fastRoundToInt2);
                    }
                    Integer crossAxisDesiredSize2 = numValueOf;
                    if (!(weight2 > 0.0f)) {
                        throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                    }
                    int remainderUnit = MathKt.getSign(remainder);
                    int crossAxisSpace4 = spaceAfterLastNoWeight2;
                    long remainder2 = remainder - ((long) remainderUnit);
                    float $this$fastRoundToInt$iv4 = weightUnitSpace * weight2;
                    int childMainAxisSize = Math.max(0, Math.round($this$fastRoundToInt$iv4) + remainderUnit);
                    if (RowColumnImplKt.getFill(parentData2) && childMainAxisSize != Integer.MAX_VALUE) {
                        i2 = childMainAxisSize;
                    } else {
                        i2 = 0;
                    }
                    long childConstraints = $this$measure.mo782createConstraintsxF2OJ5Q(i2, crossAxisDesiredSize2 != null ? crossAxisDesiredSize2.intValue() : 0, childMainAxisSize, crossAxisDesiredSize2 != null ? crossAxisDesiredSize2.intValue() : crossAxisMax, true);
                    Placeable placeable2 = child2.mo5644measureBRTryo0(childConstraints);
                    int placeableMainAxisSize2 = $this$measure.mainAxisSize(placeable2);
                    int placeableCrossAxisSize2 = $this$measure.crossAxisSize(placeable2);
                    childrenMainAxisSize[i7 - startIndex] = placeableMainAxisSize2;
                    weightedSpace += placeableMainAxisSize2;
                    spaceAfterLastNoWeight2 = Math.max(crossAxisSpace4, placeableCrossAxisSize2);
                    placeables[i7] = placeable2;
                    remainder = remainder2;
                }
                i7++;
                arrangementSpacingPx2 = arrangementSpacingPx2;
            }
            arrangementSpacingPx = arrangementSpacingPx2;
            crossAxisSpace = spaceAfterLastNoWeight2;
            fixedSpace = fixedSpace3;
            fixedSpace2 = RangesKt.coerceIn((int) (((long) weightedSpace) + arrangementSpacingTotal), 0, mainAxisMax - fixedSpace3);
        }
        if (anyAlignBy) {
            int beforeCrossAxisAlignmentLine2 = 0;
            int afterCrossAxisAlignmentLine2 = 0;
            for (int i8 = startIndex; i8 < endIndex; i8++) {
                Placeable placeable3 = placeables[i8];
                Intrinsics.checkNotNull(placeable3);
                CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(RowColumnImplKt.getRowColumnParentData(placeable3));
                Integer alignmentLinePosition = crossAxisAlignment != null ? crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(placeable3) : null;
                if (alignmentLinePosition != null) {
                    int it3 = alignmentLinePosition.intValue();
                    int placeableCrossAxisSize3 = $this$measure.crossAxisSize(placeable3);
                    beforeCrossAxisAlignmentLine2 = Math.max(beforeCrossAxisAlignmentLine2, it3 != Integer.MIN_VALUE ? alignmentLinePosition.intValue() : 0);
                    if (it3 != Integer.MIN_VALUE) {
                        i3 = it3;
                    } else {
                        i3 = placeableCrossAxisSize3;
                    }
                    afterCrossAxisAlignmentLine2 = Math.max(afterCrossAxisAlignmentLine2, placeableCrossAxisSize3 - i3);
                }
            }
            beforeCrossAxisAlignmentLine = beforeCrossAxisAlignmentLine2;
            afterCrossAxisAlignmentLine = afterCrossAxisAlignmentLine2;
        }
        int mainAxisLayoutSize = Math.max(RangesKt.coerceAtLeast(fixedSpace + fixedSpace2, 0), mainAxisMin);
        int crossAxisLayoutSize = Math.max(crossAxisSpace, Math.max(crossAxisMin, beforeCrossAxisAlignmentLine + afterCrossAxisAlignmentLine));
        int[] mainAxisPositions = new int[subSize2];
        for (int i9 = 0; i9 < subSize2; i9++) {
            mainAxisPositions[i9] = 0;
        }
        $this$measure.populateMainAxisPositions(mainAxisLayoutSize, childrenMainAxisSize, mainAxisPositions, measureScope);
        return $this$measure.placeHelper(placeables, measureScope, beforeCrossAxisAlignmentLine, mainAxisPositions, mainAxisLayoutSize, crossAxisLayoutSize, crossAxisOffset, currentLineIndex, startIndex, endIndex);
    }
}
