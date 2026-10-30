package androidx.compose.foundation.text.input;

import androidx.compose.p001ui.text.TextRange;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextFieldCharSequence.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0004\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a$\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\f\u0010\f\u001a\u00020\u0003*\u00020\u0001H\u0000\u001a\f\u0010\r\u001a\u00020\u0003*\u00020\u0001H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0014\u0010\u0011\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a,\u0010\u0012\u001a\u00020\u0013*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010H\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, m195d2 = {"TextFieldCharSequence", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "TextFieldCharSequence-3r_uNRQ", "(Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "", "TextFieldCharSequence-FDrldGo", "(Ljava/lang/String;J)Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getBackingCharSequence", "getSelectedText", "getTextAfterSelection", "maxChars", "", "getTextBeforeSelection", "toCharArray", "", "destination", "", "destinationOffset", "sourceStartIndex", "sourceEndIndex", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextFieldCharSequenceKt {
    /* JADX INFO: renamed from: TextFieldCharSequence-FDrldGo$default, reason: not valid java name */
    public static /* synthetic */ TextFieldCharSequence m1288TextFieldCharSequenceFDrldGo$default(String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            j = TextRange.INSTANCE.m6256getZerod9O1mEE();
        }
        return m1287TextFieldCharSequenceFDrldGo(str, j);
    }

    /* JADX INFO: renamed from: TextFieldCharSequence-FDrldGo, reason: not valid java name */
    public static final TextFieldCharSequence m1287TextFieldCharSequenceFDrldGo(String text, long selection) {
        return new TextFieldCharSequenceWrapper(text, selection, null, null);
    }

    /* JADX INFO: renamed from: TextFieldCharSequence-3r_uNRQ$default, reason: not valid java name */
    public static /* synthetic */ TextFieldCharSequence m1286TextFieldCharSequence3r_uNRQ$default(CharSequence charSequence, long j, TextRange textRange, int i, Object obj) {
        if ((i & 4) != 0) {
            textRange = null;
        }
        return m1285TextFieldCharSequence3r_uNRQ(charSequence, j, textRange);
    }

    /* JADX INFO: renamed from: TextFieldCharSequence-3r_uNRQ, reason: not valid java name */
    public static final TextFieldCharSequence m1285TextFieldCharSequence3r_uNRQ(CharSequence text, long selection, TextRange composition) {
        return new TextFieldCharSequenceWrapper(text, selection, composition, null);
    }

    public static final CharSequence getBackingCharSequence(TextFieldCharSequence $this$getBackingCharSequence) {
        if ($this$getBackingCharSequence instanceof TextFieldCharSequenceWrapper) {
            return ((TextFieldCharSequenceWrapper) $this$getBackingCharSequence).getText();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void toCharArray(TextFieldCharSequence $this$toCharArray, char[] destination, int destinationOffset, int sourceStartIndex, int sourceEndIndex) {
        Intrinsics.checkNotNull($this$toCharArray, "null cannot be cast to non-null type androidx.compose.foundation.text.input.TextFieldCharSequenceWrapper");
        ((TextFieldCharSequenceWrapper) $this$toCharArray).toCharArray(destination, destinationOffset, sourceStartIndex, sourceEndIndex);
    }

    public static final CharSequence getTextBeforeSelection(TextFieldCharSequence $this$getTextBeforeSelection, int maxChars) {
        return $this$getTextBeforeSelection.subSequence(Math.max(0, TextRange.m6249getMinimpl($this$getTextBeforeSelection.getSelection()) - maxChars), TextRange.m6249getMinimpl($this$getTextBeforeSelection.getSelection()));
    }

    public static final CharSequence getTextAfterSelection(TextFieldCharSequence $this$getTextAfterSelection, int maxChars) {
        return $this$getTextAfterSelection.subSequence(TextRange.m6248getMaximpl($this$getTextAfterSelection.getSelection()), Math.min(TextRange.m6248getMaximpl($this$getTextAfterSelection.getSelection()) + maxChars, $this$getTextAfterSelection.length()));
    }

    public static final CharSequence getSelectedText(TextFieldCharSequence $this$getSelectedText) {
        return $this$getSelectedText.subSequence(TextRange.m6249getMinimpl($this$getSelectedText.getSelection()), TextRange.m6248getMaximpl($this$getSelectedText.getSelection()));
    }
}
