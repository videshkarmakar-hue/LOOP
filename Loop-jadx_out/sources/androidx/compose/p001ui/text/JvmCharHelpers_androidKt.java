package androidx.compose.p001ui.text;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.text.BreakIterator;
import kotlin.Metadata;

/* JADX INFO: compiled from: JvmCharHelpers.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0005"}, m195d2 = {"findFollowingBreak", "", "", "index", "findPrecedingBreak", "ui-text_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class JvmCharHelpers_androidKt {
    public static final int findPrecedingBreak(String $this$findPrecedingBreak, int index) {
        BreakIterator it = BreakIterator.getCharacterInstance();
        it.setText($this$findPrecedingBreak);
        return it.preceding(index);
    }

    public static final int findFollowingBreak(String $this$findFollowingBreak, int index) {
        BreakIterator it = BreakIterator.getCharacterInstance();
        it.setText($this$findFollowingBreak);
        return it.following(index);
    }
}
