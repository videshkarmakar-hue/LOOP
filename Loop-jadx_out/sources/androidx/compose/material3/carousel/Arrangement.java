package androidx.compose.material3.carousel;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Arrangement.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u0003R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001a"}, m195d2 = {"Landroidx/compose/material3/carousel/Arrangement;", "", "priority", "", "smallSize", "", "smallCount", "mediumSize", "mediumCount", "largeSize", "largeCount", "(IFIFIFI)V", "getLargeCount", "()I", "getLargeSize", "()F", "getMediumCount", "getMediumSize", "getSmallCount", "getSmallSize", "cost", "targetLargeSize", "isValid", "", "itemCount", "Companion", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Arrangement {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float MediumItemFlexPercentage = 0.1f;
    private final int largeCount;
    private final float largeSize;
    private final int mediumCount;
    private final float mediumSize;
    private final int priority;
    private final int smallCount;
    private final float smallSize;

    public Arrangement(int priority, float smallSize, int smallCount, float mediumSize, int mediumCount, float largeSize, int largeCount) {
        this.priority = priority;
        this.smallSize = smallSize;
        this.smallCount = smallCount;
        this.mediumSize = mediumSize;
        this.mediumCount = mediumCount;
        this.largeSize = largeSize;
        this.largeCount = largeCount;
    }

    public final float getSmallSize() {
        return this.smallSize;
    }

    public final int getSmallCount() {
        return this.smallCount;
    }

    public final float getMediumSize() {
        return this.mediumSize;
    }

    public final int getMediumCount() {
        return this.mediumCount;
    }

    public final float getLargeSize() {
        return this.largeSize;
    }

    public final int getLargeCount() {
        return this.largeCount;
    }

    private final boolean isValid() {
        if (this.largeCount <= 0 || this.smallCount <= 0 || this.mediumCount <= 0) {
            return this.largeCount <= 0 || this.smallCount <= 0 || this.largeSize > this.smallSize;
        }
        return this.largeSize > this.mediumSize && this.mediumSize > this.smallSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float cost(float targetLargeSize) {
        if (!isValid()) {
            return Float.MAX_VALUE;
        }
        return Math.abs(targetLargeSize - this.largeSize) * this.priority;
    }

    public final int itemCount() {
        return this.largeCount + this.mediumCount + this.smallCount;
    }

    /* JADX INFO: compiled from: Arrangement.kt */
    @Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002JX\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0013J`\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m195d2 = {"Landroidx/compose/material3/carousel/Arrangement$Companion;", "", "()V", "MediumItemFlexPercentage", "", "calculateLargeSize", "availableSpace", "smallCount", "", "smallSize", "mediumCount", "largeCount", "findLowestCostArrangement", "Landroidx/compose/material3/carousel/Arrangement;", "itemSpacing", "targetSmallSize", "minSmallSize", "maxSmallSize", "smallCounts", "", "targetMediumSize", "mediumCounts", "targetLargeSize", "largeCounts", "fit", "priority", "mediumSize", "largeSize", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Arrangement findLowestCostArrangement(float availableSpace, float itemSpacing, float targetSmallSize, float minSmallSize, float maxSmallSize, int[] smallCounts, float targetMediumSize, int[] mediumCounts, float targetLargeSize, int[] largeCounts) {
            Arrangement lowestCostArrangement = null;
            int priority = 1;
            int length = largeCounts.length;
            int i = 0;
            while (i < length) {
                int largeCount = largeCounts[i];
                int length2 = mediumCounts.length;
                int i2 = 0;
                while (i2 < length2) {
                    int mediumCount = mediumCounts[i2];
                    int length3 = smallCounts.length;
                    Arrangement lowestCostArrangement2 = lowestCostArrangement;
                    int priority2 = priority;
                    int i3 = 0;
                    while (i3 < length3) {
                        int smallCount = smallCounts[i3];
                        int i4 = i3;
                        Arrangement lowestCostArrangement3 = lowestCostArrangement2;
                        int i5 = length3;
                        int i6 = i2;
                        int i7 = length2;
                        int i8 = i;
                        int i9 = length;
                        Arrangement arrangement = fit(priority2, availableSpace, itemSpacing, smallCount, targetSmallSize, minSmallSize, maxSmallSize, mediumCount, targetMediumSize, largeCount, targetLargeSize);
                        if (lowestCostArrangement3 == null || arrangement.cost(targetLargeSize) < lowestCostArrangement3.cost(targetLargeSize)) {
                            lowestCostArrangement3 = arrangement;
                            if (lowestCostArrangement3.cost(targetLargeSize) == 0.0f) {
                                return lowestCostArrangement3;
                            }
                        }
                        lowestCostArrangement2 = lowestCostArrangement3;
                        priority2++;
                        i3 = i4 + 1;
                        smallCounts = smallCounts;
                        length3 = i5;
                        i2 = i6;
                        length2 = i7;
                        i = i8;
                        length = i9;
                    }
                    i2++;
                    lowestCostArrangement = lowestCostArrangement2;
                    priority = priority2;
                    smallCounts = smallCounts;
                }
                i++;
            }
            return lowestCostArrangement;
        }

        /* JADX WARN: Code duplicated, block: B:25:0x00a9  */
        private final Arrangement fit(int priority, float availableSpace, float itemSpacing, int smallCount, float smallSize, float minSmallSize, float maxSmallSize, int mediumCount, float mediumSize, int largeCount, float largeSize) {
            float arrangedLargeSize;
            float arrangedMediumSize;
            int totalItemCount = largeCount + mediumCount + smallCount;
            float availableSpaceWithoutSpacing = availableSpace - ((totalItemCount - 1) * itemSpacing);
            float arrangedSmallSize = RangesKt.coerceIn(smallSize, minSmallSize, maxSmallSize);
            float totalSpaceTakenByArrangement = (largeCount * largeSize) + (mediumCount * mediumSize) + (smallCount * arrangedSmallSize);
            float delta = availableSpaceWithoutSpacing - totalSpaceTakenByArrangement;
            if (smallCount > 0 && delta > 0.0f) {
                arrangedSmallSize += Math.min(delta / smallCount, maxSmallSize - arrangedSmallSize);
            } else if (smallCount > 0 && delta < 0.0f) {
                arrangedSmallSize += Math.max(delta / smallCount, minSmallSize - arrangedSmallSize);
            }
            float arrangedSmallSize2 = smallCount > 0 ? arrangedSmallSize : 0.0f;
            float arrangedLargeSize2 = calculateLargeSize(availableSpaceWithoutSpacing, smallCount, arrangedSmallSize2, mediumCount, largeCount);
            float arrangedMediumSize2 = (arrangedLargeSize2 + arrangedSmallSize2) / 2.0f;
            if (mediumCount <= 0) {
                arrangedLargeSize = arrangedLargeSize2;
                arrangedMediumSize = arrangedMediumSize2;
            } else {
                if (!(arrangedLargeSize2 == largeSize)) {
                    float targetAdjustment = (largeSize - arrangedLargeSize2) * largeCount;
                    float availableMediumFlex = 0.1f * arrangedMediumSize2 * mediumCount;
                    float distribute = Math.min(Math.abs(targetAdjustment), availableMediumFlex);
                    if (targetAdjustment > 0.0f) {
                        arrangedLargeSize = arrangedLargeSize2 + (distribute / largeCount);
                        arrangedMediumSize = arrangedMediumSize2 - (distribute / mediumCount);
                    } else {
                        arrangedLargeSize = arrangedLargeSize2 - (distribute / largeCount);
                        arrangedMediumSize = arrangedMediumSize2 + (distribute / mediumCount);
                    }
                } else {
                    arrangedLargeSize = arrangedLargeSize2;
                    arrangedMediumSize = arrangedMediumSize2;
                }
            }
            return new Arrangement(priority, arrangedSmallSize2, smallCount, arrangedMediumSize, mediumCount, arrangedLargeSize, largeCount);
        }

        private final float calculateLargeSize(float availableSpace, int smallCount, float smallSize, int mediumCount, int largeCount) {
            return (availableSpace - ((smallCount + (mediumCount / 2.0f)) * smallSize)) / (largeCount + (mediumCount / 2.0f));
        }
    }
}
