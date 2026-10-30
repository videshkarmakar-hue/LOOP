package androidx.compose.p001ui.draw;

import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.BlurEffect;
import androidx.compose.p001ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p001ui.graphics.GraphicsLayerScope;
import androidx.compose.p001ui.graphics.RectangleShapeKt;
import androidx.compose.p001ui.graphics.RenderEffectKt;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.graphics.TileMode;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Blur.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, m195d2 = {"blur", "Landroidx/compose/ui/Modifier;", "radius", "Landroidx/compose/ui/unit/Dp;", "edgeTreatment", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "blur-F8QBwvs", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "radiusX", "radiusY", "blur-1fqS-gw", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "ui_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BlurKt {
    /* JADX INFO: renamed from: blur-1fqS-gw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m3925blur1fqSgw$default(Modifier modifier, float f, float f2, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 4) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m3928boximpl(BlurredEdgeTreatment.INSTANCE.m3935getRectangleGoahg());
        }
        return m3924blur1fqSgw(modifier, f, f2, blurredEdgeTreatment.m3934unboximpl());
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x0041  */
    /* JADX INFO: renamed from: blur-1fqS-gw, reason: not valid java name */
    public static final Modifier m3924blur1fqSgw(Modifier $this$blur_u2d1fqS_u2dgw, final float radiusX, final float radiusY, final Shape edgeTreatment) {
        boolean clip;
        int tileMode;
        if (edgeTreatment != null) {
            clip = true;
            tileMode = TileMode.INSTANCE.m4672getClamp3opZhB0();
        } else {
            clip = false;
            tileMode = TileMode.INSTANCE.m4673getDecal3opZhB0();
        }
        int $this$dp$iv = C1979Dp.m6800compareTo0680j_4(radiusX, C1979Dp.m6801constructorimpl(0));
        if ($this$dp$iv > 0) {
            int $this$dp$iv2 = C1979Dp.m6800compareTo0680j_4(radiusY, C1979Dp.m6801constructorimpl(0));
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
                BlurEffect blurEffectM4607BlurEffect3YTHUZs;
                float horizontalBlurPixels = $this$graphicsLayer.mo567toPx0680j_4(radiusX);
                float verticalBlurPixels = $this$graphicsLayer.mo567toPx0680j_4(radiusY);
                if (horizontalBlurPixels > 0.0f && verticalBlurPixels > 0.0f) {
                    blurEffectM4607BlurEffect3YTHUZs = RenderEffectKt.m4607BlurEffect3YTHUZs(horizontalBlurPixels, verticalBlurPixels, i);
                } else {
                    blurEffectM4607BlurEffect3YTHUZs = null;
                }
                $this$graphicsLayer.setRenderEffect(blurEffectM4607BlurEffect3YTHUZs);
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
    public static /* synthetic */ Modifier m3927blurF8QBwvs$default(Modifier modifier, float f, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m3928boximpl(BlurredEdgeTreatment.INSTANCE.m3935getRectangleGoahg());
        }
        return m3926blurF8QBwvs(modifier, f, blurredEdgeTreatment.m3934unboximpl());
    }

    /* JADX INFO: renamed from: blur-F8QBwvs, reason: not valid java name */
    public static final Modifier m3926blurF8QBwvs(Modifier $this$blur_u2dF8QBwvs, float radius, Shape edgeTreatment) {
        return m3924blur1fqSgw($this$blur_u2dF8QBwvs, radius, radius, edgeTreatment);
    }
}
