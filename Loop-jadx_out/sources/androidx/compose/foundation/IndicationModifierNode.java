package androidx.compose.foundation;

import androidx.compose.p001ui.node.DelegatableNode;
import androidx.compose.p001ui.node.DelegatingNode;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: Indication.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m195d2 = {"Landroidx/compose/foundation/IndicationModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "indicationNode", "Landroidx/compose/ui/node/DelegatableNode;", "(Landroidx/compose/ui/node/DelegatableNode;)V", "update", "", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class IndicationModifierNode extends DelegatingNode {
    private DelegatableNode indicationNode;

    public IndicationModifierNode(DelegatableNode indicationNode) {
        this.indicationNode = indicationNode;
        delegate(this.indicationNode);
    }

    public final void update(DelegatableNode indicationNode) {
        undelegate(this.indicationNode);
        this.indicationNode = indicationNode;
        delegate(indicationNode);
    }
}
