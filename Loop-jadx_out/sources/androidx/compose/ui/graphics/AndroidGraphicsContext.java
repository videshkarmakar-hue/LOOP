package androidx.compose.ui.graphics;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.graphics.layer.GraphicsLayerV23;
import androidx.compose.ui.graphics.layer.GraphicsLayerV29;
import androidx.compose.ui.graphics.layer.GraphicsViewLayer;
import androidx.compose.ui.graphics.layer.LayerManager;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.graphics.layer.view.ViewLayerContainer;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AndroidGraphicsContext.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/graphics/AndroidGraphicsContext;", "Landroidx/compose/ui/graphics/GraphicsContext;", "ownerView", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "layerManager", "Landroidx/compose/ui/graphics/layer/LayerManager;", "lock", "", "viewLayerContainer", "Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", "createGraphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "obtainViewLayerContainer", "releaseGraphicsLayer", "", "layer", "Companion", "UniqueDrawingIdApi29", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class AndroidGraphicsContext implements GraphicsContext {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean isRenderNodeCompatible = true;
    private final ViewGroup ownerView;
    private DrawChildContainer viewLayerContainer;
    private final Object lock = new Object();
    private final LayerManager layerManager = new LayerManager(new CanvasHolder());

    public AndroidGraphicsContext(ViewGroup ownerView) {
        this.ownerView = ownerView;
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public GraphicsLayer createGraphicsLayer() {
        GraphicsViewLayer layerImpl;
        GraphicsLayer layer;
        synchronized (this.lock) {
            long ownerId = getUniqueDrawingId(this.ownerView);
            if (Build.VERSION.SDK_INT >= 29) {
                layerImpl = new GraphicsLayerV29(ownerId, null, null, 6, null);
            } else if (isRenderNodeCompatible && Build.VERSION.SDK_INT >= 23) {
                try {
                    layerImpl = new GraphicsLayerV23(this.ownerView, ownerId, null, null, 12, null);
                } catch (Throwable th) {
                    isRenderNodeCompatible = false;
                    layerImpl = new GraphicsViewLayer(obtainViewLayerContainer(this.ownerView), ownerId, null, null, 12, null);
                }
            } else {
                layerImpl = new GraphicsViewLayer(obtainViewLayerContainer(this.ownerView), ownerId, null, null, 12, null);
            }
            layer = new GraphicsLayer(layerImpl, this.layerManager);
            if (Build.VERSION.SDK_INT < 28 && Build.VERSION.SDK_INT >= 23) {
                layer.m4698buildLayermLhObY(DrawContextKt.getDefaultDensity(), LayoutDirection.Ltr, IntSizeKt.IntSize(1, 1), GraphicsLayerImpl.INSTANCE.getDefaultDrawBlock());
            }
            this.layerManager.persist(layer);
            layer.m4712setSizeozmzZPI$ui_graphics_release(IntSize.INSTANCE.m6732getZeroYbymL2g());
        }
        return layer;
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public void releaseGraphicsLayer(GraphicsLayer layer) {
        synchronized (this.lock) {
            layer.release$ui_graphics_release();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final DrawChildContainer obtainViewLayerContainer(ViewGroup ownerView) {
        DrawChildContainer container = this.viewLayerContainer;
        if (container == null) {
            Context context = ownerView.getContext();
            DrawChildContainer container2 = new ViewLayerContainer(context);
            ownerView.addView(container2);
            this.viewLayerContainer = container2;
            return container2;
        }
        return container;
    }

    private final long getUniqueDrawingId(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(view);
        }
        return -1L;
    }

    /* JADX INFO: compiled from: AndroidGraphicsContext.android.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/graphics/AndroidGraphicsContext$Companion;", "", "()V", "isRenderNodeCompatible", "", "()Z", "setRenderNodeCompatible", "(Z)V", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isRenderNodeCompatible() {
            return AndroidGraphicsContext.isRenderNodeCompatible;
        }

        public final void setRenderNodeCompatible(boolean z) {
            AndroidGraphicsContext.isRenderNodeCompatible = z;
        }
    }

    /* JADX INFO: compiled from: AndroidGraphicsContext.android.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/graphics/AndroidGraphicsContext$UniqueDrawingIdApi29;", "", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class UniqueDrawingIdApi29 {
        public static final UniqueDrawingIdApi29 INSTANCE = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        @JvmStatic
        public static final long getUniqueDrawingId(View view) {
            return view.getUniqueDrawingId();
        }
    }
}
