package androidx.compose.p001ui.node;

import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.layout.LayoutCoordinatesKt;
import androidx.compose.p001ui.semantics.SemanticsActions;
import androidx.compose.p001ui.semantics.SemanticsConfiguration;
import androidx.compose.p001ui.semantics.SemanticsConfigurationKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: SemanticsModifierNode.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\u0014\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u0000\u001a\u00020\u0001H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, m195d2 = {"useMinimumTouchTarget", "", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getUseMinimumTouchTarget", "(Landroidx/compose/ui/semantics/SemanticsConfiguration;)Z", "invalidateSemantics", "", "Landroidx/compose/ui/node/SemanticsModifierNode;", "touchBoundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/Modifier$Node;", "ui_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SemanticsModifierNodeKt {
    public static final void invalidateSemantics(SemanticsModifierNode $this$invalidateSemantics) {
        DelegatableNodeKt.requireLayoutNode($this$invalidateSemantics).invalidateSemantics$ui_release();
    }

    public static final boolean getUseMinimumTouchTarget(SemanticsConfiguration $this$useMinimumTouchTarget) {
        return SemanticsConfigurationKt.getOrNull($this$useMinimumTouchTarget, SemanticsActions.INSTANCE.getOnClick()) != null;
    }

    public static final Rect touchBoundsInRoot(Modifier.Node $this$touchBoundsInRoot, boolean useMinimumTouchTarget) {
        if (!$this$touchBoundsInRoot.getNode().getIsAttached()) {
            return Rect.INSTANCE.getZero();
        }
        if (!useMinimumTouchTarget) {
            return LayoutCoordinatesKt.boundsInRoot(DelegatableNodeKt.m5765requireCoordinator64DMado($this$touchBoundsInRoot, NodeKind.m5876constructorimpl(8)));
        }
        return DelegatableNodeKt.m5765requireCoordinator64DMado($this$touchBoundsInRoot, NodeKind.m5876constructorimpl(8)).touchBoundsInRoot();
    }
}
