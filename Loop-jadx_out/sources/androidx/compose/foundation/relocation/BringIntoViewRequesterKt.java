package androidx.compose.foundation.relocation;

import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.node.DelegatableNode;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"androidx/compose/foundation/relocation/BringIntoViewRequesterKt__BringIntoViewRequesterKt", "androidx/compose/foundation/relocation/BringIntoViewRequesterKt__BringIntoViewResponderKt"}, m196k = 4, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BringIntoViewRequesterKt {
    public static final BringIntoViewRequester BringIntoViewRequester() {
        return BringIntoViewRequesterKt__BringIntoViewRequesterKt.BringIntoViewRequester();
    }

    public static final Modifier bringIntoViewRequester(Modifier $this$bringIntoViewRequester, BringIntoViewRequester bringIntoViewRequester) {
        return BringIntoViewRequesterKt__BringIntoViewRequesterKt.bringIntoViewRequester($this$bringIntoViewRequester, bringIntoViewRequester);
    }

    public static final Modifier bringIntoViewResponder(Modifier $this$bringIntoViewResponder, BringIntoViewResponder responder) {
        return BringIntoViewRequesterKt__BringIntoViewResponderKt.bringIntoViewResponder($this$bringIntoViewResponder, responder);
    }

    public static final BringIntoViewParent findBringIntoViewParent(DelegatableNode $this$findBringIntoViewParent) {
        return BringIntoViewRequesterKt__BringIntoViewResponderKt.findBringIntoViewParent($this$findBringIntoViewParent);
    }
}
