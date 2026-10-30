package androidx.compose.p001ui.text.style;

import androidx.compose.p001ui.util.MathHelpersKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: BaselineShift.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\b"}, m195d2 = {"lerp", "Landroidx/compose/ui/text/style/BaselineShift;", "start", "stop", "fraction", "", "lerp-jWV1Mfo", "(FFF)F", "ui-text_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BaselineShiftKt {
    /* JADX INFO: renamed from: lerp-jWV1Mfo, reason: not valid java name */
    public static final float m6555lerpjWV1Mfo(float start, float stop, float fraction) {
        return BaselineShift.m6543constructorimpl(MathHelpersKt.lerp(start, stop, fraction));
    }
}
