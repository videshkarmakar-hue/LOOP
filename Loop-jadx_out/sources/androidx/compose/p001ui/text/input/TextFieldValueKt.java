package androidx.compose.p001ui.text.input;

import androidx.compose.p001ui.text.AnnotatedString;
import androidx.compose.p001ui.text.TextRange;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextFieldValue.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0007"}, m195d2 = {"getSelectedText", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/input/TextFieldValue;", "getTextAfterSelection", "maxChars", "", "getTextBeforeSelection", "ui-text_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextFieldValueKt {
    public static final AnnotatedString getTextBeforeSelection(TextFieldValue $this$getTextBeforeSelection, int maxChars) {
        return $this$getTextBeforeSelection.getText().subSequence(Math.max(0, TextRange.m6249getMinimpl($this$getTextBeforeSelection.getSelection()) - maxChars), TextRange.m6249getMinimpl($this$getTextBeforeSelection.getSelection()));
    }

    public static final AnnotatedString getTextAfterSelection(TextFieldValue $this$getTextAfterSelection, int maxChars) {
        return $this$getTextAfterSelection.getText().subSequence(TextRange.m6248getMaximpl($this$getTextAfterSelection.getSelection()), Math.min(TextRange.m6248getMaximpl($this$getTextAfterSelection.getSelection()) + maxChars, $this$getTextAfterSelection.getText().length()));
    }

    public static final AnnotatedString getSelectedText(TextFieldValue $this$getSelectedText) {
        return $this$getSelectedText.getText().m6101subSequence5zctL8($this$getSelectedText.getSelection());
    }
}
