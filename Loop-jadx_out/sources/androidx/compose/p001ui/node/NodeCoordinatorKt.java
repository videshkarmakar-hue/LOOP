package androidx.compose.p001ui.node;

import androidx.compose.p001ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.caverock.androidsvg.SVGParser;
import kotlin.Metadata;

/* JADX INFO: compiled from: NodeCoordinator.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\b"}, m195d2 = {"nextUntil", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", SVGParser.XML_STYLESHEET_ATTR_TYPE, "Landroidx/compose/ui/node/NodeKind;", "stopType", "nextUntil-hw7D004", "(Landroidx/compose/ui/node/DelegatableNode;II)Landroidx/compose/ui/Modifier$Node;", "ui_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NodeCoordinatorKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: nextUntil-hw7D004, reason: not valid java name */
    public static final Modifier.Node m5874nextUntilhw7D004(DelegatableNode $this$nextUntil_u2dhw7D004, int type, int stopType) {
        Modifier.Node child = $this$nextUntil_u2dhw7D004.getNode().getChild();
        if (child == null || (child.getAggregateChildKindSet() & type) == 0) {
            return null;
        }
        for (Modifier.Node next = child; next != null; next = next.getChild()) {
            int kindSet = next.getKindSet();
            if ((kindSet & stopType) != 0) {
                return null;
            }
            if ((kindSet & type) != 0) {
                return next;
            }
        }
        return null;
    }
}
