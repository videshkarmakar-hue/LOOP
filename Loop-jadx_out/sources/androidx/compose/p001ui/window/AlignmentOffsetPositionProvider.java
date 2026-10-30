package androidx.compose.p001ui.window;

import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.p001ui.unit.IntRect;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Popup.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J2\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, m195d2 = {"Landroidx/compose/ui/window/AlignmentOffsetPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "alignment", "Landroidx/compose/ui/Alignment;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getOffset-nOcc-ac", "()J", "J", "calculatePosition", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AlignmentOffsetPositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final Alignment alignment;
    private final long offset;

    public /* synthetic */ AlignmentOffsetPositionProvider(Alignment alignment, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignment, j);
    }

    private AlignmentOffsetPositionProvider(Alignment alignment, long offset) {
        this.alignment = alignment;
        this.offset = offset;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    /* JADX INFO: renamed from: getOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getOffset() {
        return this.offset;
    }

    @Override // androidx.compose.p001ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public long mo1463calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        long anchorAlignmentPoint = this.alignment.mo3908alignKFBX0sM(IntSize.INSTANCE.m6980getZeroYbymL2g(), anchorBounds.m6959getSizeYbymL2g(), layoutDirection);
        long arg0$iv = this.alignment.mo3908alignKFBX0sM(IntSize.INSTANCE.m6980getZeroYbymL2g(), popupContentSize, layoutDirection);
        long arg0$iv2 = IntOffsetKt.IntOffset(-((int) (arg0$iv >> 32)), -((int) (arg0$iv & 4294967295L)));
        long resolvedUserOffset = IntOffsetKt.IntOffset(IntOffset.m6933getXimpl(this.offset) * (layoutDirection == LayoutDirection.Ltr ? 1 : -1), IntOffset.m6934getYimpl(this.offset));
        long arg0$iv3 = anchorBounds.m6961getTopLeftnOccac();
        int $i$f$unpackInt1 = (int) (arg0$iv3 >> 32);
        long arg0$iv4 = IntOffsetKt.IntOffset($i$f$unpackInt1 + ((int) (anchorAlignmentPoint >> 32)), ((int) (arg0$iv3 & 4294967295L)) + ((int) (anchorAlignmentPoint & 4294967295L)));
        int $i$f$unpackInt2 = (int) (arg0$iv4 >> 32);
        int i = $i$f$unpackInt2 + ((int) (arg0$iv2 >> 32));
        long popupAlignmentPoint = arg0$iv2 & 4294967295L;
        long arg0$iv5 = IntOffsetKt.IntOffset(i, ((int) (arg0$iv4 & 4294967295L)) + ((int) popupAlignmentPoint));
        int $i$f$unpackInt3 = (int) (resolvedUserOffset >> 32);
        int i2 = ((int) (arg0$iv5 >> 32)) + $i$f$unpackInt3;
        int $i$f$unpackInt4 = (int) (arg0$iv5 & 4294967295L);
        return IntOffsetKt.IntOffset(i2, $i$f$unpackInt4 + ((int) (4294967295L & resolvedUserOffset)));
    }
}
