package androidx.compose.p001ui.unit;

import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.geometry.SizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: IntSize.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001d\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000b\u001a\u0016\u0010\f\u001a\u00020\u0002*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0006\u001a\u001f\u0010\u000f\u001a\u00020\u0002*\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0002H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0016\u0010\u0013\u001a\u00020\u0014*\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0016\u0010\u0017\u001a\u00020\u0002*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0006\u001a\u0016\u0010\u0019\u001a\u00020\r*\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0006\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, m195d2 = {"center", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/ui/unit/IntSize;", "getCenter-ozmzZPI$annotations", "(J)V", "getCenter-ozmzZPI", "(J)J", "IntSize", "width", "", "height", "(II)J", "roundToIntSize", "Landroidx/compose/ui/geometry/Size;", "roundToIntSize-uvyYCjk", "times", "size", "times-O0kMr_c", "(IJ)J", "toIntRect", "Landroidx/compose/ui/unit/IntRect;", "toIntRect-ozmzZPI", "(J)Landroidx/compose/ui/unit/IntRect;", "toIntSize", "toIntSize-uvyYCjk", "toSize", "toSize-ozmzZPI", "ui-unit_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class IntSizeKt {
    /* JADX INFO: renamed from: getCenter-ozmzZPI$annotations, reason: not valid java name */
    public static /* synthetic */ void m6982getCenterozmzZPI$annotations(long j) {
    }

    public static final long IntSize(int width, int height) {
        return IntSize.m6970constructorimpl((((long) width) << 32) | (((long) height) & 4294967295L));
    }

    /* JADX INFO: renamed from: times-O0kMr_c, reason: not valid java name */
    public static final long m6984timesO0kMr_c(int $this$times_u2dO0kMr_c, long size) {
        return IntSize.m6977timesYEO4UFw(size, $this$times_u2dO0kMr_c);
    }

    /* JADX INFO: renamed from: toIntRect-ozmzZPI, reason: not valid java name */
    public static final IntRect m6985toIntRectozmzZPI(long $this$toIntRect_u2dozmzZPI) {
        return IntRectKt.m6965IntRectVbeCjmY(IntOffset.INSTANCE.m6943getZeronOccac(), $this$toIntRect_u2dozmzZPI);
    }

    /* JADX INFO: renamed from: getCenter-ozmzZPI, reason: not valid java name */
    public static final long m6981getCenterozmzZPI(long $this$center) {
        return IntOffsetKt.IntOffset(IntSize.m6975getWidthimpl($this$center) / 2, IntSize.m6974getHeightimpl($this$center) / 2);
    }

    /* JADX INFO: renamed from: toSize-ozmzZPI, reason: not valid java name */
    public static final long m6987toSizeozmzZPI(long $this$toSize_u2dozmzZPI) {
        return SizeKt.Size(IntSize.m6975getWidthimpl($this$toSize_u2dozmzZPI), IntSize.m6974getHeightimpl($this$toSize_u2dozmzZPI));
    }

    /* JADX INFO: renamed from: toIntSize-uvyYCjk, reason: not valid java name */
    public static final long m6986toIntSizeuvyYCjk(long $this$toIntSize_u2duvyYCjk) {
        return IntSize((int) Size.m4118getWidthimpl($this$toIntSize_u2duvyYCjk), (int) Size.m4115getHeightimpl($this$toIntSize_u2duvyYCjk));
    }

    /* JADX INFO: renamed from: roundToIntSize-uvyYCjk, reason: not valid java name */
    public static final long m6983roundToIntSizeuvyYCjk(long $this$roundToIntSize_u2duvyYCjk) {
        float $this$fastRoundToInt$iv = Size.m4118getWidthimpl($this$roundToIntSize_u2duvyYCjk);
        int iRound = Math.round($this$fastRoundToInt$iv);
        float $this$fastRoundToInt$iv2 = Size.m4115getHeightimpl($this$roundToIntSize_u2duvyYCjk);
        return IntSize(iRound, Math.round($this$fastRoundToInt$iv2));
    }
}
