package androidx.compose.material3.carousel;

import androidx.collection.IntIntMap;
import androidx.collection.IntIntMapKt;
import androidx.collection.MutableIntIntMap;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: KeylineSnapPosition.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¨\u0006\t"}, m195d2 = {"KeylineSnapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "snapPositions", "Landroidx/collection/IntIntMap;", "calculateSnapPositions", "strategy", "Landroidx/compose/material3/carousel/Strategy;", "itemCount", "", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class KeylineSnapPositionKt {
    public static final IntIntMap calculateSnapPositions(Strategy strategy, int itemCount) {
        if (strategy == null || !strategy.isValid()) {
            return IntIntMapKt.emptyIntIntMap();
        }
        MutableIntIntMap map = IntIntMapKt.mutableIntIntMapOf();
        KeylineList defaultKeylines = strategy.getDefaultKeylines$material3_release();
        List<KeylineList> startKeylineSteps$material3_release = strategy.getStartKeylineSteps$material3_release();
        List<KeylineList> endKeylineSteps$material3_release = strategy.getEndKeylineSteps$material3_release();
        int numOfFocalKeylines = defaultKeylines.getLastFocalIndex() - defaultKeylines.getFirstFocalIndex();
        int startStepsSize = startKeylineSteps$material3_release.size() + numOfFocalKeylines;
        int endStepsSize = endKeylineSteps$material3_release.size() + numOfFocalKeylines;
        for (int itemIndex = 0; itemIndex < itemCount; itemIndex++) {
            map.set(itemIndex, MathKt.roundToInt(defaultKeylines.getFirstFocal().getUnadjustedOffset() - (strategy.getItemMainAxisSize$material3_release() / 2.0f)));
            if (itemIndex < startStepsSize) {
                int startIndex = Math.max(0, (startStepsSize - 1) - itemIndex);
                KeylineList startKeylines = startKeylineSteps$material3_release.get(Math.min(startKeylineSteps$material3_release.size() - 1, startIndex));
                map.set(itemIndex, MathKt.roundToInt(startKeylines.getFirstFocal().getUnadjustedOffset() - (strategy.getItemMainAxisSize$material3_release() / 2.0f)));
            }
            int startIndex2 = numOfFocalKeylines + 1;
            if (itemCount > startIndex2 && itemIndex >= itemCount - endStepsSize) {
                int endIndex = Math.max(0, (itemIndex - itemCount) + endStepsSize);
                KeylineList endKeylines = endKeylineSteps$material3_release.get(Math.min(endKeylineSteps$material3_release.size() - 1, endIndex));
                map.set(itemIndex, MathKt.roundToInt(endKeylines.getFirstFocal().getUnadjustedOffset() - (strategy.getItemMainAxisSize$material3_release() / 2.0f)));
            }
        }
        return map;
    }

    public static final SnapPosition KeylineSnapPosition(final IntIntMap snapPositions) {
        return new SnapPosition() { // from class: androidx.compose.material3.carousel.KeylineSnapPositionKt.KeylineSnapPosition.1
            @Override // androidx.compose.foundation.gestures.snapping.SnapPosition
            public int position(int layoutSize, int itemSize, int beforeContentPadding, int afterContentPadding, int itemIndex, int itemCount) {
                if (snapPositions.get_size() > 0) {
                    return snapPositions.get(itemIndex);
                }
                return 0;
            }
        };
    }
}
