package androidx.compose.p001ui.node;

import android.view.View;
import androidx.compose.p001ui.internal.InlineClassHelperKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DelegatableNode.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m195d2 = {"requireView", "Landroid/view/View;", "Landroidx/compose/ui/node/DelegatableNode;", "ui_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DelegatableNode_androidKt {
    public static final View requireView(DelegatableNode $this$requireView) {
        boolean value$iv = $this$requireView.getNode().getIsAttached();
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException("Cannot get View because the Modifier node is not currently attached.");
        }
        Object objRequireOwner = LayoutNodeKt.requireOwner(DelegatableNodeKt.requireLayoutNode($this$requireView));
        Intrinsics.checkNotNull(objRequireOwner, "null cannot be cast to non-null type android.view.View");
        return (View) objRequireOwner;
    }
}
