package androidx.compose.foundation.text.selection;

import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.p001ui.unit.IntRect;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.p001ui.window.PopupPositionProvider;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: SelectionHandles.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J2\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, m195d2 = {"Landroidx/compose/foundation/text/selection/HandlePositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "handleReferencePoint", "Landroidx/compose/ui/Alignment;", "positionProvider", "Landroidx/compose/foundation/text/selection/OffsetProvider;", "(Landroidx/compose/ui/Alignment;Landroidx/compose/foundation/text/selection/OffsetProvider;)V", "prevPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class HandlePositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final Alignment handleReferencePoint;
    private final OffsetProvider positionProvider;
    private long prevPosition = Offset.INSTANCE.m4065getZeroF1C5BW0();

    public HandlePositionProvider(Alignment handleReferencePoint, OffsetProvider positionProvider) {
        this.handleReferencePoint = handleReferencePoint;
        this.positionProvider = positionProvider;
    }

    @Override // androidx.compose.p001ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4, reason: not valid java name */
    public long mo1463calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        long $this$takeOrElse_u2d3MmeM6k$iv = this.positionProvider.mo1150provideF1C5BW0();
        if (!OffsetKt.m4068isSpecifiedk4lQ0M($this$takeOrElse_u2d3MmeM6k$iv)) {
            $this$takeOrElse_u2d3MmeM6k$iv = this.prevPosition;
        }
        this.prevPosition = $this$takeOrElse_u2d3MmeM6k$iv;
        long adjustment = this.handleReferencePoint.mo3908alignKFBX0sM(popupContentSize, IntSize.INSTANCE.m6980getZeroYbymL2g(), layoutDirection);
        long arg0$iv = anchorBounds.m6961getTopLeftnOccac();
        long $this$round_u2dk_u2d4lQ0M$iv = $this$takeOrElse_u2d3MmeM6k$iv;
        float $this$fastRoundToInt$iv$iv = Offset.m4049getXimpl($this$round_u2dk_u2d4lQ0M$iv);
        int iRound = Math.round($this$fastRoundToInt$iv$iv);
        float $this$fastRoundToInt$iv$iv2 = Offset.m4050getYimpl($this$round_u2dk_u2d4lQ0M$iv);
        long $this$round_u2dk_u2d4lQ0M$iv2 = IntOffsetKt.IntOffset(iRound, Math.round($this$fastRoundToInt$iv$iv2));
        long arg0$iv2 = IntOffsetKt.IntOffset(((int) (arg0$iv >> 32)) + ((int) ($this$round_u2dk_u2d4lQ0M$iv2 >> 32)), ((int) (arg0$iv & 4294967295L)) + ((int) ($this$round_u2dk_u2d4lQ0M$iv2 & 4294967295L)));
        return IntOffsetKt.IntOffset(((int) (arg0$iv2 >> 32)) + ((int) (adjustment >> 32)), ((int) (arg0$iv2 & 4294967295L)) + ((int) (adjustment & 4294967295L)));
    }
}
