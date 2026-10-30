package androidx.compose.p001ui.text.android.selection;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: WordBoundary.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0005"}, m195d2 = {"getWordEnd", "", "Landroidx/compose/ui/text/android/selection/WordIterator;", "offset", "getWordStart", "ui-text_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class WordBoundary_androidKt {
    public static final int getWordStart(WordIterator $this$getWordStart, int offset) {
        int prevWordBeginningOnTwoWordsBoundary;
        if ($this$getWordStart.isOnPunctuation($this$getWordStart.prevBoundary(offset))) {
            prevWordBeginningOnTwoWordsBoundary = $this$getWordStart.getPunctuationBeginning(offset);
        } else {
            prevWordBeginningOnTwoWordsBoundary = $this$getWordStart.getPrevWordBeginningOnTwoWordsBoundary(offset);
        }
        int retOffset = prevWordBeginningOnTwoWordsBoundary;
        if (retOffset == -1) {
            return offset;
        }
        return retOffset;
    }

    public static final int getWordEnd(WordIterator $this$getWordEnd, int offset) {
        int nextWordEndOnTwoWordBoundary;
        if ($this$getWordEnd.isAfterPunctuation($this$getWordEnd.nextBoundary(offset))) {
            nextWordEndOnTwoWordBoundary = $this$getWordEnd.getPunctuationEnd(offset);
        } else {
            nextWordEndOnTwoWordBoundary = $this$getWordEnd.getNextWordEndOnTwoWordBoundary(offset);
        }
        int retOffset = nextWordEndOnTwoWordBoundary;
        if (retOffset == -1) {
            return offset;
        }
        return retOffset;
    }
}
