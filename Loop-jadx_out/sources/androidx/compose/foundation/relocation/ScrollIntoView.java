package androidx.compose.foundation.relocation;

import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.node.DelegatableNode;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ScrollIntoViewRequester.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"androidx/compose/foundation/relocation/ScrollIntoView__ScrollIntoViewRequesterKt"}, m196k = 4, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ScrollIntoView {
    public static final Object scrollIntoView(DelegatableNode $this$scrollIntoView, Rect rect, Continuation<? super Unit> continuation) {
        return ScrollIntoView__ScrollIntoViewRequesterKt.scrollIntoView($this$scrollIntoView, rect, continuation);
    }
}
