package androidx.compose.p001ui.focus;

import androidx.compose.p001ui.node.DelegatableNodeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: FocusPropertiesModifierNode.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m195d2 = {"invalidateFocusProperties", "", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "ui_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FocusPropertiesModifierNodeKt {
    public static final void invalidateFocusProperties(FocusPropertiesModifierNode $this$invalidateFocusProperties) {
        DelegatableNodeKt.requireOwner($this$invalidateFocusProperties).getFocusOwner().scheduleInvalidation($this$invalidateFocusProperties);
    }
}
