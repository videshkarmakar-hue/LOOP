package androidx.compose.p001ui.node;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: DrawModifierNode.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m195d2 = {"invalidateDraw", "", "Landroidx/compose/ui/node/DrawModifierNode;", "ui_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DrawModifierNodeKt {
    public static final void invalidateDraw(DrawModifierNode $this$invalidateDraw) {
        if ($this$invalidateDraw.getNode().getIsAttached()) {
            DelegatableNodeKt.m5765requireCoordinator64DMado($this$invalidateDraw, NodeKind.m5876constructorimpl(1)).invalidateLayer();
        }
    }
}
