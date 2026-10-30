package androidx.compose.foundation.text.handwriting;

import androidx.compose.p001ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: HandwritingDelegate.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, m195d2 = {"handwritingDelegate", "Landroidx/compose/ui/Modifier;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class HandwritingDelegate_androidKt {
    public static final Modifier handwritingDelegate(Modifier $this$handwritingDelegate) {
        return StylusHandwriting_androidKt.isStylusHandwritingSupported() ? $this$handwritingDelegate.then(new HandwritingDelegateElement()) : $this$handwritingDelegate;
    }
}
