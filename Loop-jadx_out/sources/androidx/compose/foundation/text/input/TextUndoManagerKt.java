package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.UndoManagerKt;
import androidx.compose.foundation.text.input.internal.undo.TextDeleteType;
import androidx.compose.foundation.text.input.internal.undo.TextEditType;
import androidx.compose.foundation.text.input.internal.undo.TextUndoOperation;
import androidx.compose.p001ui.text.TextRange;
import androidx.compose.p001ui.text.TextRangeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.p013io.IOUtils;

/* JADX INFO: compiled from: TextUndoManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0000\u001a.\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0011"}, m195d2 = {"TEXT_UNDO_CAPACITY", "", "isNewLineInsert", "", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "(Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;)Z", "merge", "next", "recordChanges", "", "Landroidx/compose/foundation/text/input/TextUndoManager;", "pre", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "post", "changes", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "allowMerge", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextUndoManagerKt {
    private static final int TEXT_UNDO_CAPACITY = 100;

    public static final TextUndoOperation merge(TextUndoOperation $this$merge, TextUndoOperation next) {
        if (!$this$merge.getCanMerge() || !next.getCanMerge() || next.getTimeInMillis() < $this$merge.getTimeInMillis() || next.getTimeInMillis() - $this$merge.getTimeInMillis() >= UndoManagerKt.getSNAPSHOTS_INTERVAL_MILLIS() || isNewLineInsert($this$merge) || isNewLineInsert(next) || $this$merge.getTextEditType() != next.getTextEditType()) {
            return null;
        }
        if ($this$merge.getTextEditType() == TextEditType.Insert && $this$merge.getIndex() + $this$merge.getPostText().length() == next.getIndex()) {
            return new TextUndoOperation($this$merge.getIndex(), "", $this$merge.getPostText() + next.getPostText(), $this$merge.getPreSelection(), next.getPostSelection(), $this$merge.getTimeInMillis(), false, 64, null);
        }
        if ($this$merge.getTextEditType() == TextEditType.Delete && $this$merge.getDeletionType() == next.getDeletionType() && ($this$merge.getDeletionType() == TextDeleteType.Start || $this$merge.getDeletionType() == TextDeleteType.End)) {
            if ($this$merge.getIndex() == next.getIndex() + next.getPreText().length()) {
                return new TextUndoOperation(next.getIndex(), next.getPreText() + $this$merge.getPreText(), "", $this$merge.getPreSelection(), next.getPostSelection(), $this$merge.getTimeInMillis(), false, 64, null);
            }
            if ($this$merge.getIndex() == next.getIndex()) {
                return new TextUndoOperation($this$merge.getIndex(), $this$merge.getPreText() + next.getPreText(), "", $this$merge.getPreSelection(), next.getPostSelection(), $this$merge.getTimeInMillis(), false, 64, null);
            }
        }
        return null;
    }

    public static /* synthetic */ void recordChanges$default(TextUndoManager textUndoManager, TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, TextFieldBuffer.ChangeList changeList, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        recordChanges(textUndoManager, textFieldCharSequence, textFieldCharSequence2, changeList, z);
    }

    public static final void recordChanges(TextUndoManager $this$recordChanges, TextFieldCharSequence pre, TextFieldCharSequence post, TextFieldBuffer.ChangeList changes, boolean allowMerge) {
        if (changes.getChangeCount() > 1) {
            $this$recordChanges.record(new TextUndoOperation(0, pre.toString(), post.toString(), pre.getSelection(), post.getSelection(), 0L, false, 32, null));
            return;
        }
        if (changes.getChangeCount() == 1) {
            long preRange = changes.mo1273getOriginalRangejx7JFs(0);
            long postRange = changes.mo1274getRangejx7JFs(0);
            if (!TextRange.m6245getCollapsedimpl(preRange) || !TextRange.m6245getCollapsedimpl(postRange)) {
                $this$recordChanges.record(new TextUndoOperation(TextRange.m6249getMinimpl(preRange), TextRangeKt.m6258substringFDrldGo(pre, preRange), TextRangeKt.m6258substringFDrldGo(post, postRange), pre.getSelection(), post.getSelection(), 0L, allowMerge, 32, null));
            }
        }
    }

    private static final boolean isNewLineInsert(TextUndoOperation $this$isNewLineInsert) {
        return Intrinsics.areEqual($this$isNewLineInsert.getPostText(), IOUtils.LINE_SEPARATOR_UNIX) || Intrinsics.areEqual($this$isNewLineInsert.getPostText(), IOUtils.LINE_SEPARATOR_WINDOWS);
    }
}
