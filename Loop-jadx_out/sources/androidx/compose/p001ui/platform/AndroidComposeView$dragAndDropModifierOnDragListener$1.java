package androidx.compose.p001ui.platform;

import androidx.compose.p001ui.draganddrop.DragAndDropTransferData;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: AndroidComposeView.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* synthetic */ class AndroidComposeView$dragAndDropModifierOnDragListener$1 extends FunctionReferenceImpl implements Function3<DragAndDropTransferData, Size, Function1<? super DrawScope, ? extends Unit>, Boolean> {
    AndroidComposeView$dragAndDropModifierOnDragListener$1(Object obj) {
        super(3, obj, AndroidComposeView.class, "startDrag", "startDrag-12SF9DM(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Boolean invoke(DragAndDropTransferData dragAndDropTransferData, Size size, Function1<? super DrawScope, ? extends Unit> function1) {
        return m5966invoke12SF9DM(dragAndDropTransferData, size.getPackedValue(), function1);
    }

    /* JADX INFO: renamed from: invoke-12SF9DM, reason: not valid java name */
    public final Boolean m5966invoke12SF9DM(DragAndDropTransferData p0, long p1, Function1<? super DrawScope, Unit> function1) {
        return Boolean.valueOf(((AndroidComposeView) this.receiver).m5964startDrag12SF9DM(p0, p1, function1));
    }
}
