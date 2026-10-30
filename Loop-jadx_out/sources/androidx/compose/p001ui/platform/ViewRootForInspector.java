package androidx.compose.p001ui.platform;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: ViewRootForInspector.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0003"}, m195d2 = {"Landroidx/compose/ui/platform/ViewRootForInspector;", "", "subCompositionView", "Landroidx/compose/ui/platform/AbstractComposeView;", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "viewRoot", "Landroid/view/View;", "getViewRoot", "()Landroid/view/View;", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface ViewRootForInspector {
    AbstractComposeView getSubCompositionView();

    View getViewRoot();

    /* JADX INFO: renamed from: androidx.compose.ui.platform.ViewRootForInspector$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: ViewRootForInspector.android.kt */
    public final /* synthetic */ class CC {
        public static AbstractComposeView $default$getSubCompositionView(ViewRootForInspector _this) {
            return null;
        }

        public static View $default$getViewRoot(ViewRootForInspector _this) {
            return null;
        }
    }

    /* JADX INFO: compiled from: ViewRootForInspector.android.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        @Deprecated
        public static AbstractComposeView getSubCompositionView(ViewRootForInspector $this) {
            return CC.$default$getSubCompositionView($this);
        }

        @Deprecated
        public static View getViewRoot(ViewRootForInspector $this) {
            return CC.$default$getViewRoot($this);
        }
    }
}
