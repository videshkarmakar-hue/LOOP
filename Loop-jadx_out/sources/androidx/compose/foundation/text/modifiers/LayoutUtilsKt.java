package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.p001ui.text.style.TextOverflow;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LayoutUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a2\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a*\u0010\u0010\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a2\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a!\u0010\u0017\u001a\u00020\u0006*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u001b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, m195d2 = {"BigConstraintValue", "", "MediumConstraintValue", "SmallConstraintValue", "TinyConstraintValue", "finalConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxIntrinsicWidth", "", "finalConstraints-tfFHcEY", "(JZIF)J", "finalMaxLines", "maxLinesIn", "finalMaxLines-xdlQI24", "(ZII)I", "finalMaxWidth", "finalMaxWidth-tfFHcEY", "(JZIF)I", "fixedCoerceHeightAndWidthForBits", "Landroidx/compose/ui/unit/Constraints$Companion;", "width", "height", "(Landroidx/compose/ui/unit/Constraints$Companion;II)J", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LayoutUtilsKt {
    public static final int BigConstraintValue = 262143;
    public static final int MediumConstraintValue = 65535;
    public static final int SmallConstraintValue = 32767;
    public static final int TinyConstraintValue = 8191;

    /* JADX INFO: renamed from: finalConstraints-tfFHcEY, reason: not valid java name */
    public static final long m1430finalConstraintstfFHcEY(long constraints, boolean softWrap, int overflow, float maxIntrinsicWidth) {
        return ConstraintsKt.Constraints$default(0, m1432finalMaxWidthtfFHcEY(constraints, softWrap, overflow, maxIntrinsicWidth), 0, Constraints.m6743getMaxHeightimpl(constraints), 5, null);
    }

    /* JADX INFO: renamed from: finalMaxWidth-tfFHcEY, reason: not valid java name */
    public static final int m1432finalMaxWidthtfFHcEY(long constraints, boolean softWrap, int overflow, float maxIntrinsicWidth) {
        int maxWidth;
        boolean widthMatters = softWrap || TextOverflow.m6700equalsimpl0(overflow, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8());
        if (widthMatters && Constraints.m6740getHasBoundedWidthimpl(constraints)) {
            maxWidth = Constraints.m6744getMaxWidthimpl(constraints);
        } else {
            maxWidth = Integer.MAX_VALUE;
        }
        if (Constraints.m6746getMinWidthimpl(constraints) == maxWidth) {
            return maxWidth;
        }
        return RangesKt.coerceIn(TextDelegateKt.ceilToIntPx(maxIntrinsicWidth), Constraints.m6746getMinWidthimpl(constraints), maxWidth);
    }

    /* JADX INFO: renamed from: finalMaxLines-xdlQI24, reason: not valid java name */
    public static final int m1431finalMaxLinesxdlQI24(boolean softWrap, int overflow, int maxLinesIn) {
        boolean overwriteMaxLines = !softWrap && TextOverflow.m6700equalsimpl0(overflow, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8());
        if (overwriteMaxLines) {
            return 1;
        }
        return RangesKt.coerceAtLeast(maxLinesIn, 1);
    }

    public static final long fixedCoerceHeightAndWidthForBits(Constraints.Companion $this$fixedCoerceHeightAndWidthForBits, int width, int height) {
        int safeHeight;
        int safeWidth = Math.min(width, 262142);
        if (safeWidth < 8191) {
            safeHeight = Math.min(height, 262142);
        } else if (safeWidth < 32767) {
            safeHeight = Math.min(height, 65534);
        } else {
            safeHeight = safeWidth < 65535 ? Math.min(height, 32766) : Math.min(height, 8190);
        }
        return $this$fixedCoerceHeightAndWidthForBits.m6754fixedJhjzzOo(safeWidth, safeHeight);
    }
}
