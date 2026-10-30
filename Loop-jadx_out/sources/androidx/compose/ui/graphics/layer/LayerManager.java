package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.media.ImageReader;
import android.os.Build;
import android.view.Surface;
import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: LayerManager.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/layer/LayerManager;", "", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "(Landroidx/compose/ui/graphics/CanvasHolder;)V", "getCanvasHolder", "()Landroidx/compose/ui/graphics/CanvasHolder;", "imageReader", "Landroid/media/ImageReader;", "layerList", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "destroy", "", "persist", "layer", "persistLayers", "layers", "Landroidx/collection/ObjectList;", "release", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LayerManager {
    private final CanvasHolder canvasHolder;
    private ImageReader imageReader;
    private final MutableObjectList<GraphicsLayer> layerList = new MutableObjectList<>(0, 1, null);

    public LayerManager(CanvasHolder canvasHolder) {
        this.canvasHolder = canvasHolder;
    }

    public final CanvasHolder getCanvasHolder() {
        return this.canvasHolder;
    }

    public final void persist(GraphicsLayer layer) {
        if (!this.layerList.contains(layer)) {
            this.layerList.add(layer);
            persistLayers(this.layerList);
        }
    }

    public final void release(GraphicsLayer layer) {
        if (this.layerList.remove(layer)) {
            layer.discardDisplayList$ui_graphics_release();
        }
    }

    private final void persistLayers(ObjectList<GraphicsLayer> layers) {
        if (Build.VERSION.SDK_INT >= 23) {
            ImageReader it = this.imageReader;
            if (it == null) {
                it = ImageReader.newInstance(1, 1, 1, 1);
                this.imageReader = it;
            }
            Surface surface = it.getSurface();
            Canvas canvas = LockHardwareCanvasHelper.INSTANCE.lockHardwareCanvas(surface);
            CanvasHolder this_$iv = this.canvasHolder;
            Canvas previousCanvas$iv = this_$iv.getAndroidCanvas().getInternalCanvas();
            this_$iv.getAndroidCanvas().setInternalCanvas(canvas);
            androidx.compose.ui.graphics.Canvas $this$persistLayers_u24lambda_u242 = this_$iv.getAndroidCanvas();
            Object[] content$iv = layers.content;
            int i = layers._size;
            for (int i$iv = 0; i$iv < i; i$iv++) {
                GraphicsLayer layer = (GraphicsLayer) content$iv[i$iv];
                layer.draw$ui_graphics_release($this$persistLayers_u24lambda_u242, null);
            }
            this_$iv.getAndroidCanvas().setInternalCanvas(previousCanvas$iv);
            surface.unlockCanvasAndPost(canvas);
        }
    }

    public final void destroy() {
        ImageReader imageReader = this.imageReader;
        if (imageReader != null) {
            imageReader.close();
        }
        this.imageReader = null;
    }
}
