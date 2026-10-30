package androidx.compose.foundation.text;

import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Rect;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextLayoutResultProxy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, m195d2 = {"coerceIn", "Landroidx/compose/ui/geometry/Offset;", "rect", "Landroidx/compose/ui/geometry/Rect;", "coerceIn-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)J", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextLayoutResultProxyKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: coerceIn-3MmeM6k, reason: not valid java name */
    public static final long m1270coerceIn3MmeM6k(long $this$coerceIn_u2d3MmeM6k, Rect rect) {
        float xOffset;
        float yOffset;
        if (Offset.m4049getXimpl($this$coerceIn_u2d3MmeM6k) < rect.getLeft()) {
            xOffset = rect.getLeft();
        } else {
            xOffset = Offset.m4049getXimpl($this$coerceIn_u2d3MmeM6k) > rect.getRight() ? rect.getRight() : Offset.m4049getXimpl($this$coerceIn_u2d3MmeM6k);
        }
        if (Offset.m4050getYimpl($this$coerceIn_u2d3MmeM6k) < rect.getTop()) {
            yOffset = rect.getTop();
        } else {
            yOffset = Offset.m4050getYimpl($this$coerceIn_u2d3MmeM6k) > rect.getBottom() ? rect.getBottom() : Offset.m4050getYimpl($this$coerceIn_u2d3MmeM6k);
        }
        return OffsetKt.Offset(xOffset, yOffset);
    }
}
