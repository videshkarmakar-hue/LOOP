package androidx.compose.p001ui.window;

import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: AndroidPopup.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, m195d2 = {"Landroidx/compose/ui/window/PopupLayoutHelperImpl29;", "Landroidx/compose/ui/window/PopupLayoutHelperImpl;", "()V", "setGestureExclusionRects", "", "composeView", "Landroid/view/View;", "width", "", "height", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class PopupLayoutHelperImpl29 extends PopupLayoutHelperImpl {
    @Override // androidx.compose.p001ui.window.PopupLayoutHelperImpl, androidx.compose.p001ui.window.PopupLayoutHelper
    public void setGestureExclusionRects(View composeView, int width, int height) {
        composeView.setSystemGestureExclusionRects(CollectionsKt.mutableListOf(new Rect(0, 0, width, height)));
    }
}
