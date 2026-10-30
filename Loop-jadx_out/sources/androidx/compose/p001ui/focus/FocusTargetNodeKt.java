package androidx.compose.p001ui.focus;

import androidx.compose.p001ui.node.DelegatableNodeKt;
import androidx.compose.p001ui.node.LayoutNode;
import androidx.compose.p001ui.node.NodeCoordinator;
import androidx.compose.p001ui.node.Owner;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: FocusTargetNode.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0000\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, m195d2 = {"focusTransactionManager", "Landroidx/compose/ui/focus/FocusTransactionManager;", "Landroidx/compose/ui/focus/FocusTargetNode;", "getFocusTransactionManager", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusTransactionManager;", "invalidateFocusTarget", "", "requireTransactionManager", "ui_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FocusTargetNodeKt {
    public static final FocusTransactionManager requireTransactionManager(FocusTargetNode $this$requireTransactionManager) {
        return DelegatableNodeKt.requireOwner($this$requireTransactionManager).getFocusOwner().getFocusTransactionManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FocusTransactionManager getFocusTransactionManager(FocusTargetNode $this$focusTransactionManager) {
        LayoutNode layoutNode;
        Owner owner;
        FocusOwner focusOwner;
        NodeCoordinator coordinator = $this$focusTransactionManager.getNode().getCoordinator();
        if (coordinator == null || (layoutNode = coordinator.getLayoutNode()) == null || (owner = layoutNode.getOwner()) == null || (focusOwner = owner.getFocusOwner()) == null) {
            return null;
        }
        return focusOwner.getFocusTransactionManager();
    }

    public static final void invalidateFocusTarget(FocusTargetNode $this$invalidateFocusTarget) {
        DelegatableNodeKt.requireOwner($this$invalidateFocusTarget).getFocusOwner().scheduleInvalidation($this$invalidateFocusTarget);
    }
}
