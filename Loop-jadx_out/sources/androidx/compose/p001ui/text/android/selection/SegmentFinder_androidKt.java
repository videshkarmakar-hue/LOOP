package androidx.compose.p001ui.text.android.selection;

import android.os.Build;
import android.text.TextPaint;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: SegmentFinder.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m195d2 = {"createGraphemeClusterSegmentFinder", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "text", "", "textPaint", "Landroid/text/TextPaint;", "ui-text_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SegmentFinder_androidKt {
    public static final SegmentFinder createGraphemeClusterSegmentFinder(CharSequence text, TextPaint textPaint) {
        if (Build.VERSION.SDK_INT >= 29) {
            return new GraphemeClusterSegmentFinderApi29(text, textPaint);
        }
        return new GraphemeClusterSegmentFinderUnderApi29(text);
    }
}
