package androidx.compose.foundation.relocation;

import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.node.DelegatableNode;
import androidx.compose.p001ui.node.TraversableNodeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: BringIntoViewResponder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0000\u001a!\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0002\b\f¨\u0006\r"}, m195d2 = {"bringIntoViewResponder", "Landroidx/compose/ui/Modifier;", "responder", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "findBringIntoViewParent", "Landroidx/compose/foundation/relocation/BringIntoViewParent;", "Landroidx/compose/ui/node/DelegatableNode;", "localRectOf", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "sourceCoordinates", "rect", "localRectOf$BringIntoViewRequesterKt__BringIntoViewResponderKt", "foundation_release"}, m196k = 5, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE, m200xs = "androidx/compose/foundation/relocation/BringIntoViewRequesterKt")
final /* synthetic */ class BringIntoViewRequesterKt__BringIntoViewResponderKt {
    public static final Modifier bringIntoViewResponder(Modifier $this$bringIntoViewResponder, BringIntoViewResponder responder) {
        return $this$bringIntoViewResponder.then(new BringIntoViewResponderElement(responder));
    }

    public static final BringIntoViewParent findBringIntoViewParent(DelegatableNode $this$findBringIntoViewParent) {
        if (!$this$findBringIntoViewParent.getNode().getIsAttached()) {
            return null;
        }
        BringIntoViewParent bringIntoViewParent = (BringIntoViewParent) TraversableNodeKt.findNearestAncestor($this$findBringIntoViewParent, BringIntoViewResponderNode.TraverseKey);
        if (bringIntoViewParent != null) {
            return bringIntoViewParent;
        }
        return BringIntoViewResponder_androidKt.defaultBringIntoViewParent($this$findBringIntoViewParent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect localRectOf$BringIntoViewRequesterKt__BringIntoViewResponderKt(LayoutCoordinates $this$localRectOf, LayoutCoordinates sourceCoordinates, Rect rect) {
        Rect localRect = $this$localRectOf.localBoundingBoxOf(sourceCoordinates, false);
        return rect.m4086translatek4lQ0M(localRect.m4084getTopLeftF1C5BW0());
    }
}
