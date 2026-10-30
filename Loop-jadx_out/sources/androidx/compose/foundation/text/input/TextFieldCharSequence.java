package androidx.compose.foundation.text.input;

import androidx.compose.p001ui.text.TextRange;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextFieldCharSequence.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001H&J\u0013\u0010\u000f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0010H¦\u0002J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038&X§\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u00020\u00038&X§\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0001\u0015ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, m195d2 = {"Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "", "composition", "Landroidx/compose/ui/text/TextRange;", "getComposition-MzsxiRA$annotations", "()V", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "selection", "getSelection-d9O1mEE$annotations", "getSelection-d9O1mEE", "()J", "contentEquals", "", "other", "equals", "", "hashCode", "", "toString", "", "Landroidx/compose/foundation/text/input/TextFieldCharSequenceWrapper;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface TextFieldCharSequence extends CharSequence {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.TextFieldCharSequence$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldCharSequence.kt */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: getComposition-MzsxiRA$annotations, reason: not valid java name */
        public static /* synthetic */ void m1283getCompositionMzsxiRA$annotations() {
        }

        /* JADX INFO: renamed from: getSelection-d9O1mEE$annotations, reason: not valid java name */
        public static /* synthetic */ void m1284getSelectiond9O1mEE$annotations() {
        }
    }

    boolean contentEquals(CharSequence other);

    boolean equals(Object other);

    /* JADX INFO: renamed from: getComposition-MzsxiRA, reason: not valid java name */
    TextRange mo1281getCompositionMzsxiRA();

    /* JADX INFO: renamed from: getSelection-d9O1mEE, reason: not valid java name */
    long mo1282getSelectiond9O1mEE();

    int hashCode();

    @Override // java.lang.CharSequence
    String toString();
}
