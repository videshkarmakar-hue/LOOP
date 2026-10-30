package androidx.compose.p001ui.graphics;

import androidx.compose.p001ui.graphics.layer.GraphicsLayer;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: GraphicsContext.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, m195d2 = {"Landroidx/compose/ui/graphics/GraphicsContext;", "", "createGraphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "releaseGraphicsLayer", "", "layer", "ui-graphics_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface GraphicsContext {
    GraphicsLayer createGraphicsLayer();

    void releaseGraphicsLayer(GraphicsLayer layer);
}
