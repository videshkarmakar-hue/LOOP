package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.p001ui.input.key.KeyEventType;
import androidx.compose.p001ui.input.key.KeyEvent_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: KeyEventHelpers.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0007"}, m195d2 = {"showCharacterPalette", "", "cancelsTextSelection", "", "Landroidx/compose/ui/input/key/KeyEvent;", "cancelsTextSelection-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class KeyEventHelpers_androidKt {
    /* JADX INFO: renamed from: cancelsTextSelection-ZmokQxo, reason: not valid java name */
    public static final boolean m1177cancelsTextSelectionZmokQxo(KeyEvent $this$cancelsTextSelection_u2dZmokQxo) {
        return $this$cancelsTextSelection_u2dZmokQxo.getKeyCode() == 4 && KeyEventType.m5362equalsimpl0(KeyEvent_androidKt.m5370getTypeZmokQxo($this$cancelsTextSelection_u2dZmokQxo), KeyEventType.INSTANCE.m5367getKeyUpCS__XNY());
    }

    public static final void showCharacterPalette() {
    }
}
