package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BlurEffect;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffectKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Blur.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"blur", "Landroidx/compose/ui/Modifier;", "radius", "Landroidx/compose/ui/unit/Dp;", "edgeTreatment", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "blur-F8QBwvs", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "radiusX", "radiusY", "blur-1fqS-gw", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BlurKt {
    /* JADX INFO: renamed from: blur-1fqS-gw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m3677blur1fqSgw$default(Modifier modifier, float f, float f2, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 4) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m3680boximpl(BlurredEdgeTreatment.INSTANCE.m3687getRectangleGoahg());
        }
        return m3676blur1fqSgw(modifier, f, f2, blurredEdgeTreatment.m3686unboximpl());
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x0041  */
    /* JADX INFO: renamed from: blur-1fqS-gw, reason: not valid java name */
    public static final Modifier m3676blur1fqSgw(Modifier $this$blur_u2d1fqS_u2dgw, final float radiusX, final float radiusY, final Shape edgeTreatment) {
        boolean clip;
        int tileMode;
        if (edgeTreatment != null) {
            clip = true;
            tileMode = TileMode.INSTANCE.m4424getClamp3opZhB0();
        } else {
            clip = false;
            tileMode = TileMode.INSTANCE.m4425getDecal3opZhB0();
        }
        int $this$dp$iv = Dp.m6552compareTo0680j_4(radiusX, Dp.m6553constructorimpl(0));
        if ($this$dp$iv > 0) {
            int $this$dp$iv2 = Dp.m6552compareTo0680j_4(radiusY, Dp.m6553constructorimpl(0));
            if ($this$dp$iv2 <= 0) {
                if (!clip) {
                    return $this$blur_u2d1fqS_u2dgw;
                }
            }
        } else if (!clip) {
            return $this$blur_u2d1fqS_u2dgw;
        }
        final int i = tileMode;
        final boolean z = clip;
        return GraphicsLayerModifierKt.graphicsLayer($this$blur_u2d1fqS_u2dgw, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.draw.BlurKt$blur$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GraphicsLayerScope $this$graphicsLayer) {
                BlurEffect blurEffectM4359BlurEffect3YTHUZs;
                float horizontalBlurPixels = $this$graphicsLayer.mo319toPx0680j_4(radiusX);
                float verticalBlurPixels = $this$graphicsLayer.mo319toPx0680j_4(radiusY);
                if (horizontalBlurPixels > 0.0f && verticalBlurPixels > 0.0f) {
                    blurEffectM4359BlurEffect3YTHUZs = RenderEffectKt.m4359BlurEffect3YTHUZs(horizontalBlurPixels, verticalBlurPixels, i);
                } else {
                    blurEffectM4359BlurEffect3YTHUZs = null;
                }
                $this$graphicsLayer.setRenderEffect(blurEffectM4359BlurEffect3YTHUZs);
                Shape rectangleShape = edgeTreatment;
                if (rectangleShape == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                $this$graphicsLayer.setShape(rectangleShape);
                $this$graphicsLayer.setClip(z);
            }
        });
    }

    /* JADX INFO: renamed from: blur-F8QBwvs$default, reason: not valid java name */
    public static /* synthetic */ Modifier m3679blurF8QBwvs$default(Modifier modifier, float f, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m3680boximpl(BlurredEdgeTreatment.INSTANCE.m3687getRectangleGoahg());
        }
        return m3678blurF8QBwvs(modifier, f, blurredEdgeTreatment.m3686unboximpl());
    }

    /* JADX INFO: renamed from: blur-F8QBwvs, reason: not valid java name */
    public static final Modifier m3678blurF8QBwvs(Modifier $this$blur_u2dF8QBwvs, float radius, Shape edgeTreatment) {
        return m3676blur1fqSgw($this$blur_u2dF8QBwvs, radius, radius, edgeTreatment);
    }
}
