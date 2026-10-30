package androidx.compose.p001ui.graphics.layer;

import androidx.compose.p001ui.geometry.CornerRadius;
import androidx.compose.p001ui.geometry.RoundRect;
import androidx.compose.p001ui.graphics.Canvas;
import androidx.compose.p001ui.graphics.Outline;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: GraphicsLayer.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\b\u001a\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m195d2 = {"DefaultCameraDistance", "", "drawLayer", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "setOutline", "outline", "Landroidx/compose/ui/graphics/Outline;", "ui-graphics_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class GraphicsLayerKt {
    public static final float DefaultCameraDistance = 8.0f;

    public static final void drawLayer(DrawScope $this$drawLayer, GraphicsLayer graphicsLayer) {
        Canvas canvas = $this$drawLayer.getDrawContext().getCanvas();
        graphicsLayer.draw$ui_graphics_release(canvas, $this$drawLayer.getDrawContext().getGraphicsLayer());
    }

    public static final void setOutline(GraphicsLayer $this$setOutline, Outline outline) {
        if (outline instanceof Outline.Rectangle) {
            float $this$fastRoundToInt$iv = ((Outline.Rectangle) outline).getRect().getLeft();
            int iRound = Math.round($this$fastRoundToInt$iv);
            float $this$fastRoundToInt$iv2 = ((Outline.Rectangle) outline).getRect().getTop();
            long jIntOffset = IntOffsetKt.IntOffset(iRound, Math.round($this$fastRoundToInt$iv2));
            float $this$fastRoundToInt$iv3 = ((Outline.Rectangle) outline).getRect().getWidth();
            int iRound2 = Math.round($this$fastRoundToInt$iv3);
            float $this$fastRoundToInt$iv4 = ((Outline.Rectangle) outline).getRect().getHeight();
            $this$setOutline.m4958setRectOutlineVbeCjmY(jIntOffset, IntSizeKt.IntSize(iRound2, Math.round($this$fastRoundToInt$iv4)));
            return;
        }
        if (!(outline instanceof Outline.Generic)) {
            if (outline instanceof Outline.Rounded) {
                if (((Outline.Rounded) outline).getRoundRectPath() != null) {
                    $this$setOutline.setPathOutline(((Outline.Rounded) outline).getRoundRectPath());
                    return;
                }
                RoundRect rr = ((Outline.Rounded) outline).getRoundRect();
                float $this$fastRoundToInt$iv5 = rr.getLeft();
                int iRound3 = Math.round($this$fastRoundToInt$iv5);
                float $this$fastRoundToInt$iv6 = rr.getTop();
                long jIntOffset2 = IntOffsetKt.IntOffset(iRound3, Math.round($this$fastRoundToInt$iv6));
                float $this$fastRoundToInt$iv7 = rr.getWidth();
                int iRound4 = Math.round($this$fastRoundToInt$iv7);
                float $this$fastRoundToInt$iv8 = rr.getHeight();
                $this$setOutline.m4959setRoundRectOutline1IyobKY(jIntOffset2, IntSizeKt.IntSize(iRound4, Math.round($this$fastRoundToInt$iv8)), CornerRadius.m4024getXimpl(rr.m4097getBottomLeftCornerRadiuskKHJgLs()));
                return;
            }
            return;
        }
        $this$setOutline.setPathOutline(((Outline.Generic) outline).getPath());
    }
}
