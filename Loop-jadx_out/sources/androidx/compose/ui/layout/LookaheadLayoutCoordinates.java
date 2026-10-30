package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LookaheadLayoutCoordinates.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0019H\u0096\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\nH\u0016J\"\u0010&\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u001a\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u001a\u0010.\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b/\u0010-J\u001a\u00100\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b1\u0010-J\u001a\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b4\u0010-J\"\u00105\u001a\u0002062\u0006\u0010$\u001a\u00020\u00012\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001a\u0010;\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u001a\u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b@\u0010-R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006A"}, d2 = {"Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "lookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "isAttached", "", "()Z", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadOffset", "Landroidx/compose/ui/geometry/Offset;", "getLookaheadOffset-F1C5BW0", "()J", "parentCoordinates", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "get", "", "alignmentLine", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "clipBounds", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "(J)J", "localToScreen", "localToScreen-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "screenToLocal", "relativeToScreen", "screenToLocal-MK-Hz9U", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LookaheadLayoutCoordinates implements LayoutCoordinates {
    public static final int $stable = 0;
    private final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinates(LookaheadDelegate lookaheadDelegate) {
        this.lookaheadDelegate = lookaheadDelegate;
    }

    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    public final NodeCoordinator getCoordinator() {
        return this.lookaheadDelegate.getCoordinator();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public long mo5398getSizeYbymL2g() {
        LookaheadDelegate it = this.lookaheadDelegate;
        return IntSizeKt.IntSize(it.getWidth(), it.getHeight());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        return getCoordinator().getProvidedAlignmentLines();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public LayoutCoordinates getParentLayoutCoordinates() {
        LookaheadDelegate lookaheadDelegate;
        boolean value$iv = isAttached();
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException(NodeCoordinator.ExpectAttachedLayoutCoordinates);
        }
        NodeCoordinator it = getCoordinator().getLayoutNode().getOuterCoordinator$ui_release().getWrappedBy();
        if (it == null || (lookaheadDelegate = it.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate.getCoordinates();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public LayoutCoordinates getParentCoordinates() {
        LookaheadDelegate lookaheadDelegate;
        boolean value$iv = isAttached();
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException(NodeCoordinator.ExpectAttachedLayoutCoordinates);
        }
        NodeCoordinator wrappedBy = getCoordinator().getWrappedBy();
        if (wrappedBy == null || (lookaheadDelegate = wrappedBy.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate.getCoordinates();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getCoordinator().isAttached();
    }

    /* JADX INFO: renamed from: getLookaheadOffset-F1C5BW0, reason: not valid java name */
    private final long m5422getLookaheadOffsetF1C5BW0() {
        LookaheadDelegate it = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        return Offset.m3805minusMKHz9U(mo5399localPositionOfR5De75A(it.getCoordinates(), Offset.INSTANCE.m3817getZeroF1C5BW0()), getCoordinator().mo5399localPositionOfR5De75A(it.getCoordinator(), Offset.INSTANCE.m3817getZeroF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: screenToLocal-MK-Hz9U */
    public long mo5403screenToLocalMKHz9U(long relativeToScreen) {
        return Offset.m3806plusMKHz9U(getCoordinator().mo5403screenToLocalMKHz9U(relativeToScreen), m5422getLookaheadOffsetF1C5BW0());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToScreen-MK-Hz9U */
    public long mo5401localToScreenMKHz9U(long relativeToLocal) {
        return getCoordinator().mo5401localToScreenMKHz9U(Offset.m3806plusMKHz9U(relativeToLocal, m5422getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: windowToLocal-MK-Hz9U */
    public long mo5406windowToLocalMKHz9U(long relativeToWindow) {
        return Offset.m3806plusMKHz9U(getCoordinator().mo5406windowToLocalMKHz9U(relativeToWindow), m5422getLookaheadOffsetF1C5BW0());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToWindow-MK-Hz9U */
    public long mo5402localToWindowMKHz9U(long relativeToLocal) {
        return getCoordinator().mo5402localToWindowMKHz9U(Offset.m3806plusMKHz9U(relativeToLocal, m5422getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToRoot-MK-Hz9U */
    public long mo5400localToRootMKHz9U(long relativeToLocal) {
        return getCoordinator().mo5400localToRootMKHz9U(Offset.m3806plusMKHz9U(relativeToLocal, m5422getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-R5De75A */
    public long mo5399localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource) {
        if (!(sourceCoordinates instanceof LookaheadLayoutCoordinates)) {
            LookaheadDelegate rootDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
            return Offset.m3806plusMKHz9U(mo5399localPositionOfR5De75A(rootDelegate.getLookaheadLayoutCoordinates(), relativeToSource), rootDelegate.getCoordinator().getCoordinates().mo5399localPositionOfR5De75A(sourceCoordinates, Offset.INSTANCE.m3817getZeroF1C5BW0()));
        }
        LookaheadDelegate source = ((LookaheadLayoutCoordinates) sourceCoordinates).lookaheadDelegate;
        source.getCoordinator().onCoordinatesUsed$ui_release();
        NodeCoordinator commonAncestor = getCoordinator().findCommonAncestor$ui_release(source.getCoordinator());
        LookaheadDelegate ancestor = commonAncestor.getLookaheadDelegate();
        if (ancestor != null) {
            long arg0$iv = source.m5580positionInBjo55l4$ui_release(ancestor);
            float $this$fastRoundToInt$iv$iv = Offset.m3801getXimpl(relativeToSource);
            int iRound = Math.round($this$fastRoundToInt$iv$iv);
            float $this$fastRoundToInt$iv$iv2 = Offset.m3802getYimpl(relativeToSource);
            long $this$round_u2dk_u2d4lQ0M$iv = IntOffsetKt.IntOffset(iRound, Math.round($this$fastRoundToInt$iv$iv2));
            int $i$f$unpackInt2 = (int) ($this$round_u2dk_u2d4lQ0M$iv & 4294967295L);
            long arg0$iv2 = IntOffsetKt.IntOffset(((int) (arg0$iv >> 32)) + ((int) ($this$round_u2dk_u2d4lQ0M$iv >> 32)), ((int) (arg0$iv & 4294967295L)) + $i$f$unpackInt2);
            long other$iv = this.lookaheadDelegate.m5580positionInBjo55l4$ui_release(ancestor);
            long $this$toOffset_u2d_u2dgyyYBs$iv = IntOffsetKt.IntOffset(((int) (arg0$iv2 >> 32)) - ((int) (other$iv >> 32)), ((int) (arg0$iv2 & 4294967295L)) - ((int) (4294967295L & other$iv)));
            return OffsetKt.Offset(IntOffset.m6685getXimpl($this$toOffset_u2d_u2dgyyYBs$iv), IntOffset.m6686getYimpl($this$toOffset_u2d_u2dgyyYBs$iv));
        }
        LookaheadDelegate sourceRoot = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(source);
        long arg0$iv3 = source.m5580positionInBjo55l4$ui_release(sourceRoot);
        long other$iv2 = sourceRoot.getPosition();
        int $i$f$unpackInt1 = (int) (other$iv2 >> 32);
        int i = ((int) (arg0$iv3 >> 32)) + $i$f$unpackInt1;
        int $i$f$unpackInt3 = (int) (arg0$iv3 & 4294967295L);
        long arg0$iv4 = IntOffsetKt.IntOffset(i, $i$f$unpackInt3 + ((int) (other$iv2 & 4294967295L)));
        float $this$fastRoundToInt$iv$iv3 = Offset.m3801getXimpl(relativeToSource);
        int iRound2 = Math.round($this$fastRoundToInt$iv$iv3);
        float $this$fastRoundToInt$iv$iv4 = Offset.m3802getYimpl(relativeToSource);
        long $this$round_u2dk_u2d4lQ0M$iv2 = IntOffsetKt.IntOffset(iRound2, Math.round($this$fastRoundToInt$iv$iv4));
        int i2 = ((int) (arg0$iv4 >> 32)) + ((int) ($this$round_u2dk_u2d4lQ0M$iv2 >> 32));
        int i3 = (int) (arg0$iv4 & 4294967295L);
        int $i$f$unpackInt4 = (int) ($this$round_u2dk_u2d4lQ0M$iv2 & 4294967295L);
        long arg0$iv5 = IntOffsetKt.IntOffset(i2, i3 + $i$f$unpackInt4);
        LookaheadDelegate $this$localPositionOf_R5De75A_u24lambda_u247_u24lambda_u246 = this.lookaheadDelegate;
        long arg0$iv6 = $this$localPositionOf_R5De75A_u24lambda_u247_u24lambda_u246.m5580positionInBjo55l4$ui_release(LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate($this$localPositionOf_R5De75A_u24lambda_u247_u24lambda_u246));
        long other$iv3 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate($this$localPositionOf_R5De75A_u24lambda_u247_u24lambda_u246).getPosition();
        int $i$f$unpackInt5 = (int) (other$iv3 >> 32);
        int i4 = ((int) (arg0$iv6 >> 32)) + $i$f$unpackInt5;
        int $i$f$unpackInt6 = (int) (arg0$iv6 & 4294967295L);
        long other$iv4 = IntOffsetKt.IntOffset(i4, $i$f$unpackInt6 + ((int) (other$iv3 & 4294967295L)));
        long relativePosition = IntOffsetKt.IntOffset(((int) (arg0$iv5 >> 32)) - ((int) (other$iv4 >> 32)), ((int) (arg0$iv5 & 4294967295L)) - ((int) (4294967295L & other$iv4)));
        NodeCoordinator wrappedBy = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate).getCoordinator().getWrappedBy();
        Intrinsics.checkNotNull(wrappedBy);
        NodeCoordinator wrappedBy2 = sourceRoot.getCoordinator().getWrappedBy();
        Intrinsics.checkNotNull(wrappedBy2);
        return wrappedBy.mo5399localPositionOfR5De75A(wrappedBy2, OffsetKt.Offset(IntOffset.m6685getXimpl(relativePosition), IntOffset.m6686getYimpl(relativePosition)));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        return getCoordinator().localBoundingBoxOf(sourceCoordinates, clipBounds);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformFrom-EL8BTi8 */
    public void mo5404transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        getCoordinator().mo5404transformFromEL8BTi8(sourceCoordinates, matrix);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformToScreen-58bKbWc */
    public void mo5405transformToScreen58bKbWc(float[] matrix) {
        getCoordinator().mo5405transformToScreen58bKbWc(matrix);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public int get(AlignmentLine alignmentLine) {
        return this.lookaheadDelegate.get(alignmentLine);
    }
}
