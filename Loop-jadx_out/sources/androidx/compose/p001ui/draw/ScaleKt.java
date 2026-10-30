package androidx.compose.p001ui.draw;

import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.GraphicsLayerModifierKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: Scale.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007¨\u0006\u0005"}, m195d2 = {"scale", "Landroidx/compose/ui/Modifier;", "", "scaleX", "scaleY", "ui_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ScaleKt {
    public static final Modifier scale(Modifier $this$scale, float scaleX, float scaleY) {
        if (scaleX == 1.0f) {
            if (scaleY == 1.0f) {
                return $this$scale;
            }
        }
        return GraphicsLayerModifierKt.m4452graphicsLayerAp8cVGQ$default($this$scale, scaleX, scaleY, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131068, null);
    }

    public static final Modifier scale(Modifier $this$scale, float scale) {
        return scale($this$scale, scale, scale);
    }
}
