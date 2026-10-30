package androidx.compose.foundation.relocation;

import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.geometry.SizeKt;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.node.DelegatableNode;
import androidx.compose.p001ui.node.DelegatableNodeKt;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: ScrollIntoViewRequester.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m195d2 = {"scrollIntoView", "", "Landroidx/compose/ui/node/DelegatableNode;", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m196k = 5, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE, m200xs = "androidx/compose/foundation/relocation/ScrollIntoView")
public final /* synthetic */ class ScrollIntoView__ScrollIntoViewRequesterKt {
    public static /* synthetic */ Object scrollIntoView$default(DelegatableNode delegatableNode, Rect rect, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = null;
        }
        return ScrollIntoView.scrollIntoView(delegatableNode, rect, continuation);
    }

    public static final Object scrollIntoView(DelegatableNode $this$scrollIntoView, final Rect rect, Continuation<? super Unit> continuation) {
        Object objBringChildIntoView;
        if (!$this$scrollIntoView.getNode().getIsAttached()) {
            return Unit.INSTANCE;
        }
        final LayoutCoordinates layoutCoordinates = DelegatableNodeKt.requireLayoutCoordinates($this$scrollIntoView);
        BringIntoViewParent parent = BringIntoViewRequesterKt.findBringIntoViewParent($this$scrollIntoView);
        return (parent != null && (objBringChildIntoView = parent.bringChildIntoView(layoutCoordinates, new Function0<Rect>() { // from class: androidx.compose.foundation.relocation.ScrollIntoView__ScrollIntoViewRequesterKt.scrollIntoView.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Rect invoke() {
                Rect rect2 = rect;
                if (rect2 != null) {
                    return rect2;
                }
                LayoutCoordinates it = layoutCoordinates;
                if (!it.isAttached()) {
                    it = null;
                }
                if (it != null) {
                    return SizeKt.m4139toRectuvyYCjk(IntSizeKt.m6987toSizeozmzZPI(it.mo5646getSizeYbymL2g()));
                }
                return null;
            }
        }, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objBringChildIntoView : Unit.INSTANCE;
    }
}
