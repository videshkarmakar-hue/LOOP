package androidx.compose.p001ui.node;

import android.view.KeyEvent;
import androidx.compose.p001ui.semantics.SemanticsOwner;
import androidx.compose.p001ui.text.input.TextInputService;
import androidx.compose.p001ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: compiled from: RootForTest.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0010\u001a\u00020\u0011H'J\b\u0010\u0012\u001a\u00020\u0011H\u0017J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH'R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u001cÀ\u0006\u0001"}, m195d2 = {"Landroidx/compose/ui/node/RootForTest;", "", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService$annotations", "()V", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "forceAccessibilityForTesting", "", "measureAndLayoutForTest", "sendKeyEvent", "", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "setAccessibilityEventBatchIntervalMillis", "accessibilityInterval", "", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface RootForTest {
    void forceAccessibilityForTesting();

    Density getDensity();

    SemanticsOwner getSemanticsOwner();

    TextInputService getTextInputService();

    void measureAndLayoutForTest();

    /* JADX INFO: renamed from: sendKeyEvent-ZmokQxo, reason: not valid java name */
    boolean mo5933sendKeyEventZmokQxo(KeyEvent keyEvent);

    void setAccessibilityEventBatchIntervalMillis(long accessibilityInterval);

    /* JADX INFO: renamed from: androidx.compose.ui.node.RootForTest$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: RootForTest.kt */
    public final /* synthetic */ class CC {
        @Deprecated(message = "Use PlatformTextInputModifierNode instead.")
        public static /* synthetic */ void getTextInputService$annotations() {
        }

        public static void $default$measureAndLayoutForTest(RootForTest _this) {
        }
    }
}
