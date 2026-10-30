package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.internal.ToCharArray_androidKt;
import androidx.compose.p001ui.text.TextRange;
import androidx.compose.p001ui.text.TextRangeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TextFieldCharSequence.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0013\u0010\u0016\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J&\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bJ\b\u0010&\u001a\u00020'H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u00020\u0005X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, m195d2 = {"Landroidx/compose/foundation/text/input/TextFieldCharSequenceWrapper;", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "(Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "length", "", "getLength", "()I", "getSelection-d9O1mEE", "()J", "J", "getText", "()Ljava/lang/CharSequence;", "contentEquals", "", "other", "equals", "", "get", "", "index", "hashCode", "subSequence", "startIndex", "endIndex", "toCharArray", "", "destination", "", "destinationOffset", "sourceStartIndex", "sourceEndIndex", "toString", "", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class TextFieldCharSequenceWrapper implements TextFieldCharSequence {
    private final TextRange composition;
    private final long selection;
    private final CharSequence text;

    public /* synthetic */ TextFieldCharSequenceWrapper(CharSequence charSequence, long j, TextRange textRange, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, j, textRange);
    }

    private TextFieldCharSequenceWrapper(CharSequence text, long selection, TextRange composition) {
        CharSequence charSequence;
        if (text instanceof TextFieldCharSequenceWrapper) {
            charSequence = ((TextFieldCharSequenceWrapper) text).text;
        } else {
            charSequence = text;
        }
        this.text = charSequence;
        this.selection = TextRangeKt.m6257coerceIn8ffj60Q(selection, 0, text.length());
        this.composition = composition != null ? TextRange.m6239boximpl(TextRangeKt.m6257coerceIn8ffj60Q(composition.getPackedValue(), 0, text.length())) : null;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int index) {
        return get(index);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public final CharSequence getText() {
        return this.text;
    }

    public int getLength() {
        return this.text.length();
    }

    @Override // androidx.compose.foundation.text.input.TextFieldCharSequence
    /* JADX INFO: renamed from: getSelection-d9O1mEE, reason: from getter */
    public long getSelection() {
        return this.selection;
    }

    @Override // androidx.compose.foundation.text.input.TextFieldCharSequence
    /* JADX INFO: renamed from: getComposition-MzsxiRA, reason: from getter */
    public TextRange getComposition() {
        return this.composition;
    }

    public char get(int index) {
        return this.text.charAt(index);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int startIndex, int endIndex) {
        return this.text.subSequence(startIndex, endIndex);
    }

    @Override // androidx.compose.foundation.text.input.TextFieldCharSequence, java.lang.CharSequence
    public String toString() {
        return this.text.toString();
    }

    @Override // androidx.compose.foundation.text.input.TextFieldCharSequence
    public boolean contentEquals(CharSequence other) {
        return StringsKt.contentEquals(this.text, other);
    }

    public final void toCharArray(char[] destination, int destinationOffset, int sourceStartIndex, int sourceEndIndex) {
        ToCharArray_androidKt.toCharArray(this.text, destination, destinationOffset, sourceStartIndex, sourceEndIndex);
    }

    @Override // androidx.compose.foundation.text.input.TextFieldCharSequence
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        if (TextRange.m6244equalsimpl0(getSelection(), ((TextFieldCharSequenceWrapper) other).getSelection()) && Intrinsics.areEqual(getComposition(), ((TextFieldCharSequenceWrapper) other).getComposition()) && contentEquals(((TextFieldCharSequenceWrapper) other).text)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.foundation.text.input.TextFieldCharSequence
    public int hashCode() {
        int result = this.text.hashCode();
        int result2 = ((result * 31) + TextRange.m6252hashCodeimpl(getSelection())) * 31;
        TextRange composition = getComposition();
        return result2 + (composition != null ? TextRange.m6252hashCodeimpl(composition.getPackedValue()) : 0);
    }
}
