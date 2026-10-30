package androidx.compose.p001ui.layout;

import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.node.NodeCoordinator;
import androidx.compose.p001ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: LayoutCoordinates.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0002\u001a\u000f\u0010\u0006\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b\u001a\u000f\u0010\t\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b\u001a\u000f\u0010\n\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b\u001a\u000f\u0010\u000b\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b¨\u0006\f"}, m195d2 = {"boundsInParent", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsInRoot", "boundsInWindow", "findRootCoordinates", "positionInParent", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "positionInRoot", "positionInWindow", "positionOnScreen", "ui_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LayoutCoordinatesKt {
    public static final long positionInRoot(LayoutCoordinates $this$positionInRoot) {
        return $this$positionInRoot.mo5648localToRootMKHz9U(Offset.INSTANCE.m4065getZeroF1C5BW0());
    }

    public static final long positionInWindow(LayoutCoordinates $this$positionInWindow) {
        return $this$positionInWindow.mo5650localToWindowMKHz9U(Offset.INSTANCE.m4065getZeroF1C5BW0());
    }

    public static final long positionOnScreen(LayoutCoordinates $this$positionOnScreen) {
        return $this$positionOnScreen.mo5649localToScreenMKHz9U(Offset.INSTANCE.m4065getZeroF1C5BW0());
    }

    public static final Rect boundsInRoot(LayoutCoordinates $this$boundsInRoot) {
        return LayoutCoordinates.CC.localBoundingBoxOf$default(findRootCoordinates($this$boundsInRoot), $this$boundsInRoot, false, 2, null);
    }

    public static final Rect boundsInWindow(LayoutCoordinates $this$boundsInWindow) {
        LayoutCoordinates root = findRootCoordinates($this$boundsInWindow);
        float rootWidth = IntSize.m6975getWidthimpl(root.mo5646getSizeYbymL2g());
        float rootHeight = IntSize.m6974getHeightimpl(root.mo5646getSizeYbymL2g());
        Rect bounds = boundsInRoot($this$boundsInWindow);
        float $this$fastCoerceAtLeast$iv$iv = bounds.getLeft();
        if ($this$fastCoerceAtLeast$iv$iv < 0.0f) {
            $this$fastCoerceAtLeast$iv$iv = 0.0f;
        }
        if ($this$fastCoerceAtLeast$iv$iv > rootWidth) {
            $this$fastCoerceAtLeast$iv$iv = rootWidth;
        }
        float $this$fastCoerceIn$iv = $this$fastCoerceAtLeast$iv$iv;
        float $this$fastCoerceAtLeast$iv$iv2 = bounds.getTop();
        if ($this$fastCoerceAtLeast$iv$iv2 < 0.0f) {
            $this$fastCoerceAtLeast$iv$iv2 = 0.0f;
        }
        if ($this$fastCoerceAtLeast$iv$iv2 > rootHeight) {
            $this$fastCoerceAtLeast$iv$iv2 = rootHeight;
        }
        float $this$fastCoerceIn$iv2 = $this$fastCoerceAtLeast$iv$iv2;
        float $this$fastCoerceAtLeast$iv$iv3 = bounds.getRight();
        if ($this$fastCoerceAtLeast$iv$iv3 < 0.0f) {
            $this$fastCoerceAtLeast$iv$iv3 = 0.0f;
        }
        if ($this$fastCoerceAtLeast$iv$iv3 > rootWidth) {
            $this$fastCoerceAtLeast$iv$iv3 = rootWidth;
        }
        float $this$fastCoerceIn$iv3 = $this$fastCoerceAtLeast$iv$iv3;
        float $this$fastCoerceAtLeast$iv$iv4 = bounds.getBottom();
        if ($this$fastCoerceAtLeast$iv$iv4 < 0.0f) {
            $this$fastCoerceAtLeast$iv$iv4 = 0.0f;
        }
        if ($this$fastCoerceAtLeast$iv$iv4 > rootHeight) {
            $this$fastCoerceAtLeast$iv$iv4 = rootHeight;
        }
        float $this$fastCoerceIn$iv4 = $this$fastCoerceAtLeast$iv$iv4;
        if (!($this$fastCoerceIn$iv == $this$fastCoerceIn$iv3)) {
            if (!($this$fastCoerceIn$iv2 == $this$fastCoerceIn$iv4)) {
                long topLeft = root.mo5650localToWindowMKHz9U(OffsetKt.Offset($this$fastCoerceIn$iv, $this$fastCoerceIn$iv2));
                long topRight = root.mo5650localToWindowMKHz9U(OffsetKt.Offset($this$fastCoerceIn$iv3, $this$fastCoerceIn$iv2));
                long bottomRight = root.mo5650localToWindowMKHz9U(OffsetKt.Offset($this$fastCoerceIn$iv3, $this$fastCoerceIn$iv4));
                long bottomLeft = root.mo5650localToWindowMKHz9U(OffsetKt.Offset($this$fastCoerceIn$iv, $this$fastCoerceIn$iv4));
                float topLeftX = Offset.m4049getXimpl(topLeft);
                float topRightX = Offset.m4049getXimpl(topRight);
                float bottomLeftX = Offset.m4049getXimpl(bottomLeft);
                float bottomRightX = Offset.m4049getXimpl(bottomRight);
                float boundsLeft = Math.min(bottomLeftX, bottomRightX);
                float left = Math.min(topLeftX, Math.min(topRightX, boundsLeft));
                float boundsTop = Math.max(bottomLeftX, bottomRightX);
                float right = Math.max(topLeftX, Math.max(topRightX, boundsTop));
                float topLeftY = Offset.m4050getYimpl(topLeft);
                float topRightY = Offset.m4050getYimpl(topRight);
                float bottomLeftY = Offset.m4050getYimpl(bottomLeft);
                float bottomRightY = Offset.m4050getYimpl(bottomRight);
                float boundsRight = Math.min(bottomLeftY, bottomRightY);
                float top = Math.min(topLeftY, Math.min(topRightY, boundsRight));
                float boundsBottom = Math.max(bottomLeftY, bottomRightY);
                float bottom = Math.max(topLeftY, Math.max(topRightY, boundsBottom));
                return new Rect(left, top, right, bottom);
            }
        }
        return Rect.INSTANCE.getZero();
    }

    public static final long positionInParent(LayoutCoordinates $this$positionInParent) {
        LayoutCoordinates parentLayoutCoordinates = $this$positionInParent.getParentLayoutCoordinates();
        return parentLayoutCoordinates != null ? parentLayoutCoordinates.mo5647localPositionOfR5De75A($this$positionInParent, Offset.INSTANCE.m4065getZeroF1C5BW0()) : Offset.INSTANCE.m4065getZeroF1C5BW0();
    }

    public static final Rect boundsInParent(LayoutCoordinates $this$boundsInParent) {
        Rect rectLocalBoundingBoxOf$default;
        LayoutCoordinates parentLayoutCoordinates = $this$boundsInParent.getParentLayoutCoordinates();
        return (parentLayoutCoordinates == null || (rectLocalBoundingBoxOf$default = LayoutCoordinates.CC.localBoundingBoxOf$default(parentLayoutCoordinates, $this$boundsInParent, false, 2, null)) == null) ? new Rect(0.0f, 0.0f, IntSize.m6975getWidthimpl($this$boundsInParent.mo5646getSizeYbymL2g()), IntSize.m6974getHeightimpl($this$boundsInParent.mo5646getSizeYbymL2g())) : rectLocalBoundingBoxOf$default;
    }

    public static final LayoutCoordinates findRootCoordinates(LayoutCoordinates $this$findRootCoordinates) {
        LayoutCoordinates root = $this$findRootCoordinates;
        LayoutCoordinates parent = root.getParentLayoutCoordinates();
        while (parent != null) {
            root = parent;
            parent = root.getParentLayoutCoordinates();
        }
        NodeCoordinator rootCoordinator = root instanceof NodeCoordinator ? (NodeCoordinator) root : null;
        if (rootCoordinator == null) {
            return root;
        }
        for (NodeCoordinator parentCoordinator = rootCoordinator.getWrappedBy(); parentCoordinator != null; parentCoordinator = parentCoordinator.getWrappedBy()) {
            rootCoordinator = parentCoordinator;
        }
        return rootCoordinator;
    }
}
