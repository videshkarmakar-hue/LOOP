package androidx.compose.material3.carousel;

import androidx.compose.p001ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Keylines.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001aF\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u0001H\u0000\u001a*\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0000¨\u0006\u0017"}, m195d2 = {"calculateMediumChildSize", "", "minimumMediumSize", "largeItemSize", "remainingSpace", "createLeftAlignedKeylineList", "Landroidx/compose/material3/carousel/KeylineList;", "carouselMainAxisSize", "itemSpacing", "leftAnchorSize", "rightAnchorSize", "arrangement", "Landroidx/compose/material3/carousel/Arrangement;", "multiBrowseKeylineList", "density", "Landroidx/compose/ui/unit/Density;", "preferredItemSize", "itemCount", "", "minSmallItemSize", "maxSmallItemSize", "uncontainedKeylineList", "itemSize", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class KeylinesKt {
    public static /* synthetic */ KeylineList multiBrowseKeylineList$default(Density $this$multiBrowseKeylineList_u24lambda_u240, float f, float f2, float f3, int i, float f4, float f5, int i2, Object obj) {
        float fMo567toPx0680j_4;
        float fMo567toPx0680j_5;
        if ((i2 & 32) == 0) {
            fMo567toPx0680j_4 = f4;
        } else {
            fMo567toPx0680j_4 = $this$multiBrowseKeylineList_u24lambda_u240.mo567toPx0680j_4(CarouselDefaults.INSTANCE.m2996getMinSmallItemSizeD9Ej5fM$material3_release());
        }
        if ((i2 & 64) == 0) {
            fMo567toPx0680j_5 = f5;
        } else {
            fMo567toPx0680j_5 = $this$multiBrowseKeylineList_u24lambda_u240.mo567toPx0680j_4(CarouselDefaults.INSTANCE.m2995getMaxSmallItemSizeD9Ej5fM$material3_release());
        }
        return multiBrowseKeylineList($this$multiBrowseKeylineList_u24lambda_u240, f, f2, f3, i, fMo567toPx0680j_4, fMo567toPx0680j_5);
    }

    public static final KeylineList multiBrowseKeylineList(Density density, float carouselMainAxisSize, float preferredItemSize, float itemSpacing, int itemCount, float minSmallItemSize, float maxSmallItemSize) {
        int[] smallCounts;
        if (!(carouselMainAxisSize == 0.0f)) {
            if (!(preferredItemSize == 0.0f)) {
                int[] smallCounts2 = {1};
                int[] mediumCounts = {1, 0};
                float targetLargeSize = Math.min(preferredItemSize, carouselMainAxisSize);
                float targetSmallSize = RangesKt.coerceIn(targetLargeSize / 3.0f, minSmallItemSize, maxSmallItemSize);
                float targetMediumSize = (targetLargeSize + targetSmallSize) / 2.0f;
                if (carouselMainAxisSize >= 2 * minSmallItemSize) {
                    smallCounts = smallCounts2;
                } else {
                    int[] smallCounts3 = {0};
                    smallCounts = smallCounts3;
                }
                float minAvailableLargeSpace = (carouselMainAxisSize - (ArraysKt.maxOrThrow(mediumCounts) * targetMediumSize)) - (ArraysKt.maxOrThrow(smallCounts) * maxSmallItemSize);
                int minLargeCount = Math.max(1, (int) Math.floor(minAvailableLargeSpace / targetLargeSize));
                int maxLargeCount = (int) Math.ceil(carouselMainAxisSize / targetLargeSize);
                int i = (maxLargeCount - minLargeCount) + 1;
                int[] largeCounts = new int[i];
                for (int i2 = 0; i2 < i; i2++) {
                    largeCounts[i2] = maxLargeCount - i2;
                }
                float anchorSize = density.mo567toPx0680j_4(CarouselDefaults.INSTANCE.m2994getAnchorSizeD9Ej5fM$material3_release());
                Arrangement arrangement = Arrangement.INSTANCE.findLowestCostArrangement(carouselMainAxisSize, itemSpacing, targetSmallSize, minSmallItemSize, maxSmallItemSize, smallCounts, targetMediumSize, mediumCounts, targetLargeSize, largeCounts);
                if (arrangement != null && arrangement.itemCount() > itemCount) {
                    int smallCount = arrangement.getSmallCount();
                    int mediumCount = arrangement.getMediumCount();
                    for (int keylineSurplus = arrangement.itemCount() - itemCount; keylineSurplus > 0; keylineSurplus--) {
                        if (smallCount > 0) {
                            smallCount--;
                        } else if (mediumCount > 1) {
                            mediumCount--;
                        }
                    }
                    arrangement = Arrangement.INSTANCE.findLowestCostArrangement(carouselMainAxisSize, itemSpacing, targetSmallSize, minSmallItemSize, maxSmallItemSize, new int[]{smallCount}, targetMediumSize, new int[]{mediumCount}, targetLargeSize, largeCounts);
                }
                if (arrangement == null) {
                    return null;
                }
                return createLeftAlignedKeylineList(carouselMainAxisSize, itemSpacing, anchorSize, anchorSize, arrangement);
            }
        }
        return null;
    }

    public static final KeylineList createLeftAlignedKeylineList(float carouselMainAxisSize, float itemSpacing, final float leftAnchorSize, final float rightAnchorSize, final Arrangement arrangement) {
        return KeylineListKt.m3001keylineListOfWNYm7Xg(carouselMainAxisSize, itemSpacing, CarouselAlignment.INSTANCE.m2993getStartNUL3oTo(), new Function1<KeylineListScope, Unit>() { // from class: androidx.compose.material3.carousel.KeylinesKt.createLeftAlignedKeylineList.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeylineListScope keylineListScope) {
                invoke2(keylineListScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeylineListScope $this$keylineListOf) {
                $this$keylineListOf.add(leftAnchorSize, true);
                int largeCount = arrangement.getLargeCount();
                Arrangement arrangement2 = arrangement;
                for (int i = 0; i < largeCount; i++) {
                    KeylineListScope.CC.add$default($this$keylineListOf, arrangement2.getLargeSize(), false, 2, null);
                }
                int mediumCount = arrangement.getMediumCount();
                Arrangement arrangement3 = arrangement;
                for (int i2 = 0; i2 < mediumCount; i2++) {
                    KeylineListScope.CC.add$default($this$keylineListOf, arrangement3.getMediumSize(), false, 2, null);
                }
                int smallCount = arrangement.getSmallCount();
                Arrangement arrangement4 = arrangement;
                for (int i3 = 0; i3 < smallCount; i3++) {
                    KeylineListScope.CC.add$default($this$keylineListOf, arrangement4.getSmallSize(), false, 2, null);
                }
                $this$keylineListOf.add(rightAnchorSize, true);
            }
        });
    }

    public static final KeylineList uncontainedKeylineList(Density density, float carouselMainAxisSize, float itemSize, float itemSpacing) {
        if (carouselMainAxisSize == 0.0f) {
            return null;
        }
        if (!(itemSize == 0.0f)) {
            float largeItemSize = Math.min(itemSize + itemSpacing, carouselMainAxisSize);
            int largeCount = Math.max(1, (int) Math.floor(carouselMainAxisSize / largeItemSize));
            float remainingSpace = carouselMainAxisSize - (largeCount * largeItemSize);
            int mediumCount = remainingSpace > 0.0f ? 1 : 0;
            float defaultAnchorSize = density.mo567toPx0680j_4(CarouselDefaults.INSTANCE.m2994getAnchorSizeD9Ej5fM$material3_release());
            float mediumItemSize = calculateMediumChildSize(defaultAnchorSize, largeItemSize, remainingSpace);
            Arrangement arrangement = new Arrangement(0, 0.0f, 0, mediumItemSize, mediumCount, largeItemSize, largeCount);
            float xSmallSize = Math.min(defaultAnchorSize, itemSize);
            float leftAnchorSize = Math.max(xSmallSize, 0.5f * mediumItemSize);
            return createLeftAlignedKeylineList(carouselMainAxisSize, itemSpacing, leftAnchorSize, defaultAnchorSize, arrangement);
        }
        return null;
    }

    private static final float calculateMediumChildSize(float minimumMediumSize, float largeItemSize, float remainingSpace) {
        float sizeWithThirdCutOff = 1.5f * remainingSpace;
        float mediumItemSize = Math.max(sizeWithThirdCutOff, minimumMediumSize);
        float largeItemThreshold = 0.85f * largeItemSize;
        if (mediumItemSize > largeItemThreshold) {
            float sizeWithFifthCutOff = 1.2f * remainingSpace;
            return Math.max(largeItemThreshold, sizeWithFifthCutOff);
        }
        return mediumItemSize;
    }
}
