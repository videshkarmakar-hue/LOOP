package androidx.compose.p001ui.text.platform.extensions;

import android.text.style.TtsSpan;
import androidx.compose.p001ui.text.TtsAnnotation;
import androidx.compose.p001ui.text.VerbatimTtsAnnotation;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: TtsAnnotationExtensions.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003¨\u0006\u0004"}, m195d2 = {"toSpan", "Landroid/text/style/TtsSpan;", "Landroidx/compose/ui/text/TtsAnnotation;", "Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "ui-text_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TtsAnnotationExtensions_androidKt {
    public static final TtsSpan toSpan(TtsAnnotation $this$toSpan) {
        if ($this$toSpan instanceof VerbatimTtsAnnotation) {
            return toSpan((VerbatimTtsAnnotation) $this$toSpan);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final TtsSpan toSpan(VerbatimTtsAnnotation $this$toSpan) {
        TtsSpan.VerbatimBuilder builder = new TtsSpan.VerbatimBuilder($this$toSpan.getVerbatim());
        return builder.build();
    }
}
