package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: LayoutNodeDrawScope.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"nextDrawNode", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LayoutNodeDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier.Node nextDrawNode(DelegatableNode $this$nextDrawNode) {
        int iM5628constructorimpl = NodeKind.m5628constructorimpl(4);
        int iM5628constructorimpl2 = NodeKind.m5628constructorimpl(2);
        Modifier.Node child = $this$nextDrawNode.getNode().getChild();
        if (child == null || (child.getAggregateChildKindSet() & iM5628constructorimpl) == 0) {
            return null;
        }
        for (Modifier.Node next = child; next != null && (next.getKindSet() & iM5628constructorimpl2) == 0; next = next.getChild()) {
            if ((next.getKindSet() & iM5628constructorimpl) != 0) {
                return next;
            }
        }
        return null;
    }
}
