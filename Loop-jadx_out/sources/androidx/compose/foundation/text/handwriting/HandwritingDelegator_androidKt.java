package androidx.compose.foundation.text.handwriting;

import androidx.compose.p001ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: HandwritingDelegator.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, m195d2 = {"handwritingDelegator", "Landroidx/compose/ui/Modifier;", "callback", "Lkotlin/Function0;", "", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class HandwritingDelegator_androidKt {
    public static final Modifier handwritingDelegator(Modifier $this$handwritingDelegator, Function0<Unit> function0) {
        return StylusHandwriting_androidKt.isStylusHandwritingSupported() ? $this$handwritingDelegator.then(new HandwritingDelegatorElement(function0)) : $this$handwritingDelegator;
    }
}
