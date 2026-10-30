package androidx.compose.foundation.draganddrop;

import android.graphics.Picture;
import androidx.compose.p001ui.draw.CacheDrawScope;
import androidx.compose.p001ui.draw.DrawResult;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p001ui.graphics.Canvas;
import androidx.compose.p001ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawContext;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.layer.GraphicsLayer;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AndroidDragAndDropSource.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m195d2 = {"Landroidx/compose/foundation/draganddrop/CacheDrawScopeDragShadowCallback;", "", "()V", "cachedPicture", "Landroid/graphics/Picture;", "cachePicture", "Landroidx/compose/ui/draw/DrawResult;", "scope", "Landroidx/compose/ui/draw/CacheDrawScope;", "drawDragShadow", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class CacheDrawScopeDragShadowCallback {
    private Picture cachedPicture;

    public final void drawDragShadow(DrawScope drawScope) {
        Picture picture = this.cachedPicture;
        if (picture == null) {
            throw new IllegalArgumentException("No cached drag shadow. Check if Modifier.cacheDragShadow(painter) was called.");
        }
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        AndroidCanvas_androidKt.getNativeCanvas(canvas).drawPicture(picture);
    }

    public final DrawResult cachePicture(CacheDrawScope scope) {
        final Picture picture = new Picture();
        this.cachedPicture = picture;
        final int width = (int) Size.m4118getWidthimpl(scope.m3940getSizeNHjbRc());
        final int height = (int) Size.m4115getHeightimpl(scope.m3940getSizeNHjbRc());
        return scope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.draganddrop.CacheDrawScopeDragShadowCallback$cachePicture$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope $this$onDrawWithContent) {
                Canvas pictureCanvas = AndroidCanvas_androidKt.Canvas(picture.beginRecording(width, height));
                ContentDrawScope $this$draw_u2dymL40Pk_u24default$iv = $this$onDrawWithContent;
                LayoutDirection layoutDirection$iv = $this$onDrawWithContent.getLayoutDirection();
                long size$iv = $this$onDrawWithContent.mo4773getSizeNHjbRc();
                Density prevDensity$iv = $this$draw_u2dymL40Pk_u24default$iv.getDrawContext().getDensity();
                LayoutDirection prevLayoutDirection$iv = $this$draw_u2dymL40Pk_u24default$iv.getDrawContext().getLayoutDirection();
                Canvas prevCanvas$iv = $this$draw_u2dymL40Pk_u24default$iv.getDrawContext().getCanvas();
                long prevSize$iv = $this$draw_u2dymL40Pk_u24default$iv.getDrawContext().mo4779getSizeNHjbRc();
                GraphicsLayer prevLayer$iv = $this$draw_u2dymL40Pk_u24default$iv.getDrawContext().getGraphicsLayer();
                DrawContext $this$draw_ymL40Pk_u24lambda_u247$iv = $this$draw_u2dymL40Pk_u24default$iv.getDrawContext();
                $this$draw_ymL40Pk_u24lambda_u247$iv.setDensity($this$onDrawWithContent);
                $this$draw_ymL40Pk_u24lambda_u247$iv.setLayoutDirection(layoutDirection$iv);
                $this$draw_ymL40Pk_u24lambda_u247$iv.setCanvas(pictureCanvas);
                $this$draw_ymL40Pk_u24lambda_u247$iv.mo4780setSizeuvyYCjk(size$iv);
                $this$draw_ymL40Pk_u24lambda_u247$iv.setGraphicsLayer(null);
                pictureCanvas.save();
                try {
                    $this$onDrawWithContent.drawContent();
                    pictureCanvas.restore();
                    DrawContext $this$draw_ymL40Pk_u24lambda_u248$iv = $this$draw_u2dymL40Pk_u24default$iv.getDrawContext();
                    $this$draw_ymL40Pk_u24lambda_u248$iv.setDensity(prevDensity$iv);
                    $this$draw_ymL40Pk_u24lambda_u248$iv.setLayoutDirection(prevLayoutDirection$iv);
                    $this$draw_ymL40Pk_u24lambda_u248$iv.setCanvas(prevCanvas$iv);
                    $this$draw_ymL40Pk_u24lambda_u248$iv.mo4780setSizeuvyYCjk(prevSize$iv);
                    $this$draw_ymL40Pk_u24lambda_u248$iv.setGraphicsLayer(prevLayer$iv);
                    picture.endRecording();
                    ContentDrawScope $this$drawIntoCanvas$iv = $this$onDrawWithContent;
                    Picture picture2 = picture;
                    Canvas canvas = $this$drawIntoCanvas$iv.getDrawContext().getCanvas();
                    AndroidCanvas_androidKt.getNativeCanvas(canvas).drawPicture(picture2);
                } catch (Throwable th) {
                    pictureCanvas.restore();
                    DrawContext $this$draw_ymL40Pk_u24lambda_u248$iv2 = $this$draw_u2dymL40Pk_u24default$iv.getDrawContext();
                    $this$draw_ymL40Pk_u24lambda_u248$iv2.setDensity(prevDensity$iv);
                    $this$draw_ymL40Pk_u24lambda_u248$iv2.setLayoutDirection(prevLayoutDirection$iv);
                    $this$draw_ymL40Pk_u24lambda_u248$iv2.setCanvas(prevCanvas$iv);
                    $this$draw_ymL40Pk_u24lambda_u248$iv2.mo4780setSizeuvyYCjk(prevSize$iv);
                    $this$draw_ymL40Pk_u24lambda_u248$iv2.setGraphicsLayer(prevLayer$iv);
                    throw th;
                }
            }
        });
    }
}
