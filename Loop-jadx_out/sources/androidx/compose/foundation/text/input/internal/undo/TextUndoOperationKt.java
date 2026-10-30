package androidx.compose.foundation.text.input.internal.undo;

import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.EditingBuffer;
import androidx.compose.p001ui.text.TextRange;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextUndoOperation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0006"}, m195d2 = {"redo", "", "Landroidx/compose/foundation/text/input/TextFieldState;", "op", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "undo", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextUndoOperationKt {
    public static final void undo(TextFieldState $this$undo, TextUndoOperation op) {
        TextFieldCharSequence previousValue$iv = $this$undo.getValue$foundation_release();
        $this$undo.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer $this$undo_u24lambda_u240 = $this$undo.getMainBuffer();
        $this$undo_u24lambda_u240.replace(op.getIndex(), op.getIndex() + op.getPostText().length(), op.getPreText());
        $this$undo_u24lambda_u240.setSelection(TextRange.m6251getStartimpl(op.getPreSelection()), TextRange.m6246getEndimpl(op.getPreSelection()));
        TextFieldCharSequence afterEditValue$iv = TextFieldCharSequenceKt.m1285TextFieldCharSequence3r_uNRQ($this$undo.getMainBuffer().toString(), $this$undo.getMainBuffer().m1308getSelectiond9O1mEE(), $this$undo.getMainBuffer().m1307getCompositionMzsxiRA());
        $this$undo.setValue(afterEditValue$iv);
        $this$undo.sendChangesToIme(previousValue$iv, afterEditValue$iv, true);
    }

    public static final void redo(TextFieldState $this$redo, TextUndoOperation op) {
        TextFieldCharSequence previousValue$iv = $this$redo.getValue$foundation_release();
        $this$redo.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer $this$redo_u24lambda_u241 = $this$redo.getMainBuffer();
        $this$redo_u24lambda_u241.replace(op.getIndex(), op.getIndex() + op.getPreText().length(), op.getPostText());
        $this$redo_u24lambda_u241.setSelection(TextRange.m6251getStartimpl(op.getPostSelection()), TextRange.m6246getEndimpl(op.getPostSelection()));
        TextFieldCharSequence afterEditValue$iv = TextFieldCharSequenceKt.m1285TextFieldCharSequence3r_uNRQ($this$redo.getMainBuffer().toString(), $this$redo.getMainBuffer().m1308getSelectiond9O1mEE(), $this$redo.getMainBuffer().m1307getCompositionMzsxiRA());
        $this$redo.setValue(afterEditValue$iv);
        $this$redo.sendChangesToIme(previousValue$iv, afterEditValue$iv, true);
    }
}
