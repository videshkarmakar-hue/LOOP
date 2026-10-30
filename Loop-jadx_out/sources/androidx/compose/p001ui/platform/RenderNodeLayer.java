package androidx.compose.p001ui.platform;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import androidx.compose.p001ui.geometry.MutableRect;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.SizeKt;
import androidx.compose.p001ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p001ui.graphics.AndroidPaint_androidKt;
import androidx.compose.p001ui.graphics.Canvas;
import androidx.compose.p001ui.graphics.CanvasHolder;
import androidx.compose.p001ui.graphics.ColorKt;
import androidx.compose.p001ui.graphics.Fields;
import androidx.compose.p001ui.graphics.Paint;
import androidx.compose.p001ui.graphics.Path;
import androidx.compose.p001ui.graphics.RectangleShapeKt;
import androidx.compose.p001ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.p001ui.graphics.TransformOrigin;
import androidx.compose.p001ui.graphics.layer.GraphicsLayer;
import androidx.compose.p001ui.layout.GraphicLayerInfo;
import androidx.compose.p001ui.node.OwnedLayer;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: RenderNodeLayer.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0002WXB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0007H\u0002J\b\u0010,\u001a\u00020\bH\u0016J\u001a\u0010-\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\bH\u0016J\u001a\u00101\u001a\u00020\b2\u0006\u00102\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u001a\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u0018\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u000fH\u0016J\"\u0010?\u001a\u0002082\u0006\u0010@\u001a\u0002082\u0006\u0010>\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u001a\u0010C\u001a\u00020\b2\u0006\u00107\u001a\u00020DH\u0016ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ\u001a\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020IH\u0016ø\u0001\u0000¢\u0006\u0004\bJ\u0010FJ*\u0010K\u001a\u00020\b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016J\u001a\u0010L\u001a\u00020\b2\u0006\u00102\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\bM\u00105J\b\u0010N\u001a\u00020\bH\u0002J\b\u0010O\u001a\u00020\bH\u0016J \u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0018R\u000e\u0010$\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\u00020(X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010)\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Y"}, m195d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "drawnWithZ", "", "isDestroyed", DownloadUtil.CookieScheme.VALUE, "isDirty", "setDirty", "(Z)V", "layerId", "", "getLayerId", "()J", "matrixCache", "Landroidx/compose/ui/platform/LayerMatrixCache;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "mutatedFields", "", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "ownerViewId", "getOwnerViewId", "renderNode", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "clipRenderNode", "canvas", "destroy", "drawLayer", "parentLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "invalidate", "inverseTransform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "reuseLayer", "transform", "transform-58bKbWc", "triggerRepaint", "updateDisplayList", "updateLayerProperties", "scope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "Companion", "UniqueDrawingIdApi29", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class RenderNodeLayer implements OwnedLayer, GraphicLayerInfo {
    private final CanvasHolder canvasHolder;
    private Function1<? super Canvas, Unit> drawBlock;
    private boolean drawnWithZ;
    private Function0<Unit> invalidateParentLayer;
    private boolean isDestroyed;
    private boolean isDirty;
    private final LayerMatrixCache<DeviceRenderNode> matrixCache;
    private int mutatedFields;
    private final OutlineResolver outlineResolver;
    private final AndroidComposeView ownerView;
    private final DeviceRenderNode renderNode;
    private Paint softwareLayerPaint;
    private long transformOrigin;
    public static final int $stable = 8;
    private static final Function2<DeviceRenderNode, Matrix, Unit> getMatrix = new Function2<DeviceRenderNode, Matrix, Unit>() { // from class: androidx.compose.ui.platform.RenderNodeLayer$Companion$getMatrix$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(DeviceRenderNode deviceRenderNode, Matrix matrix) {
            invoke2(deviceRenderNode, matrix);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DeviceRenderNode rn, Matrix matrix) {
            rn.getMatrix(matrix);
        }
    };

    public RenderNodeLayer(AndroidComposeView ownerView, Function1<? super Canvas, Unit> function1, Function0<Unit> function0) {
        RenderNodeApi23 renderNodeApi23;
        this.ownerView = ownerView;
        this.drawBlock = function1;
        this.invalidateParentLayer = function0;
        Snapshot.Companion this_$iv = Snapshot.INSTANCE;
        Snapshot previousSnapshot$iv = this_$iv.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = previousSnapshot$iv != null ? previousSnapshot$iv.getReadObserver() : null;
        Snapshot newSnapshot$iv = this_$iv.makeCurrentNonObservable(previousSnapshot$iv);
        try {
            OutlineResolver outlineResolver = new OutlineResolver(this.ownerView.getDensity());
            this_$iv.restoreNonObservable(previousSnapshot$iv, newSnapshot$iv, readObserver);
            this.outlineResolver = outlineResolver;
            this.matrixCache = new LayerMatrixCache<>(getMatrix);
            this.canvasHolder = new CanvasHolder();
            this.transformOrigin = TransformOrigin.INSTANCE.m4690getCenterSzJe1aQ();
            if (Build.VERSION.SDK_INT >= 29) {
                renderNodeApi23 = new RenderNodeApi29(this.ownerView);
            } else {
                renderNodeApi23 = new RenderNodeApi23(this.ownerView);
            }
            DeviceRenderNode $this$renderNode_u24lambda_u241 = renderNodeApi23;
            $this$renderNode_u24lambda_u241.setHasOverlappingRendering(true);
            $this$renderNode_u24lambda_u241.setClipToBounds(false);
            this.renderNode = renderNodeApi23;
        } catch (Throwable th) {
            this_$iv.restoreNonObservable(previousSnapshot$iv, newSnapshot$iv, readObserver);
            throw th;
        }
    }

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    private final void setDirty(boolean value) {
        if (value != this.isDirty) {
            this.isDirty = value;
            this.ownerView.notifyLayerIsDirty$ui_release(this, value);
        }
    }

    @Override // androidx.compose.p001ui.layout.GraphicLayerInfo
    public long getLayerId() {
        return this.renderNode.getUniqueId();
    }

    @Override // androidx.compose.p001ui.layout.GraphicLayerInfo
    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(this.ownerView);
        }
        return -1L;
    }

    /* JADX INFO: compiled from: RenderNodeLayer.android.kt */
    @Metadata(m194d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m195d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer$UniqueDrawingIdApi29;", "", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class UniqueDrawingIdApi29 {
        public static final UniqueDrawingIdApi29 INSTANCE = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        @JvmStatic
        public static final long getUniqueDrawingId(View view) {
            return view.getUniqueDrawingId();
        }
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    public void updateLayerProperties(ReusableGraphicsLayerScope scope, LayoutDirection layoutDirection, Density density) {
        Function0<Unit> function0;
        int maybeChangedFields = scope.getMutatedFields() | this.mutatedFields;
        if ((maybeChangedFields & 4096) != 0) {
            this.transformOrigin = scope.getTransformOrigin();
        }
        boolean isClippingManually = false;
        boolean wasClippingManually = this.renderNode.getClipToOutline() && !this.outlineResolver.getOutlineClipSupported();
        if ((maybeChangedFields & 1) != 0) {
            this.renderNode.setScaleX(scope.getScaleX());
        }
        if ((maybeChangedFields & 2) != 0) {
            this.renderNode.setScaleY(scope.getScaleY());
        }
        if ((maybeChangedFields & 4) != 0) {
            this.renderNode.setAlpha(scope.getAlpha());
        }
        if ((maybeChangedFields & 8) != 0) {
            this.renderNode.setTranslationX(scope.getTranslationX());
        }
        if ((maybeChangedFields & 16) != 0) {
            this.renderNode.setTranslationY(scope.getTranslationY());
        }
        if ((maybeChangedFields & 32) != 0) {
            this.renderNode.setElevation(scope.getShadowElevation());
        }
        if ((maybeChangedFields & 64) != 0) {
            this.renderNode.setAmbientShadowColor(ColorKt.m4345toArgb8_81llA(scope.getAmbientShadowColor()));
        }
        if ((maybeChangedFields & 128) != 0) {
            this.renderNode.setSpotShadowColor(ColorKt.m4345toArgb8_81llA(scope.getSpotShadowColor()));
        }
        if ((maybeChangedFields & 1024) != 0) {
            this.renderNode.setRotationZ(scope.getRotationZ());
        }
        if ((maybeChangedFields & 256) != 0) {
            this.renderNode.setRotationX(scope.getRotationX());
        }
        if ((maybeChangedFields & 512) != 0) {
            this.renderNode.setRotationY(scope.getRotationY());
        }
        if ((maybeChangedFields & 2048) != 0) {
            this.renderNode.setCameraDistance(scope.getCameraDistance());
        }
        if ((maybeChangedFields & 4096) != 0) {
            this.renderNode.setPivotX(TransformOrigin.m4685getPivotFractionXimpl(this.transformOrigin) * this.renderNode.getWidth());
            this.renderNode.setPivotY(TransformOrigin.m4686getPivotFractionYimpl(this.transformOrigin) * this.renderNode.getHeight());
        }
        boolean clipToOutline = scope.getClip() && scope.getShape() != RectangleShapeKt.getRectangleShape();
        if ((maybeChangedFields & CpioConstants.C_ISBLK) != 0) {
            this.renderNode.setClipToOutline(clipToOutline);
            this.renderNode.setClipToBounds(scope.getClip() && scope.getShape() == RectangleShapeKt.getRectangleShape());
        }
        if ((131072 & maybeChangedFields) != 0) {
            this.renderNode.setRenderEffect(scope.getRenderEffect());
        }
        if ((32768 & maybeChangedFields) != 0) {
            this.renderNode.mo5992setCompositingStrategyaDBOjCE(scope.getCompositingStrategy());
        }
        boolean shapeChanged = this.outlineResolver.update(scope.getShape(), scope.getAlpha(), clipToOutline, scope.getShadowElevation(), layoutDirection, density);
        if (this.outlineResolver.getCacheIsDirty()) {
            this.renderNode.setOutline(this.outlineResolver.getOutline());
        }
        if (clipToOutline && !this.outlineResolver.getOutlineClipSupported()) {
            isClippingManually = true;
        }
        if (wasClippingManually != isClippingManually || (isClippingManually && shapeChanged)) {
            invalidate();
        } else {
            triggerRepaint();
        }
        if (!this.drawnWithZ && this.renderNode.getElevation() > 0.0f && (function0 = this.invalidateParentLayer) != null) {
            function0.invoke();
        }
        if ((maybeChangedFields & Fields.MatrixAffectingFields) != 0) {
            this.matrixCache.invalidate();
        }
        this.mutatedFields = scope.getMutatedFields();
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    /* JADX INFO: renamed from: isInLayer-k-4lQ0M */
    public boolean mo5924isInLayerk4lQ0M(long position) {
        float x = Offset.m4049getXimpl(position);
        float y = Offset.m4050getYimpl(position);
        if (this.renderNode.getClipToBounds()) {
            return 0.0f <= x && x < ((float) this.renderNode.getWidth()) && 0.0f <= y && y < ((float) this.renderNode.getHeight());
        }
        if (this.renderNode.getClipToOutline()) {
            return this.outlineResolver.m6031isInOutlinek4lQ0M(position);
        }
        return true;
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    /* JADX INFO: renamed from: resize-ozmzZPI */
    public void mo5927resizeozmzZPI(long size) {
        int width = IntSize.m6975getWidthimpl(size);
        int height = IntSize.m6974getHeightimpl(size);
        this.renderNode.setPivotX(TransformOrigin.m4685getPivotFractionXimpl(this.transformOrigin) * width);
        this.renderNode.setPivotY(TransformOrigin.m4686getPivotFractionYimpl(this.transformOrigin) * height);
        if (this.renderNode.setPosition(this.renderNode.getLeft(), this.renderNode.getTop(), this.renderNode.getLeft() + width, this.renderNode.getTop() + height)) {
            this.outlineResolver.m6032updateuvyYCjk(SizeKt.Size(width, height));
            this.renderNode.setOutline(this.outlineResolver.getOutline());
            invalidate();
            this.matrixCache.invalidate();
        }
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    /* JADX INFO: renamed from: move--gyyYBs */
    public void mo5926movegyyYBs(long position) {
        int oldLeft = this.renderNode.getLeft();
        int oldTop = this.renderNode.getTop();
        int newLeft = IntOffset.m6933getXimpl(position);
        int newTop = IntOffset.m6934getYimpl(position);
        if (oldLeft != newLeft || oldTop != newTop) {
            if (oldLeft != newLeft) {
                this.renderNode.offsetLeftAndRight(newLeft - oldLeft);
            }
            if (oldTop != newTop) {
                this.renderNode.offsetTopAndBottom(newTop - oldTop);
            }
            triggerRepaint();
            this.matrixCache.invalidate();
        }
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    public void invalidate() {
        if (!this.isDirty && !this.isDestroyed) {
            this.ownerView.invalidate();
            setDirty(true);
        }
    }

    private final void triggerRepaint() {
        if (Build.VERSION.SDK_INT >= 26) {
            WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
        } else {
            this.ownerView.invalidate();
        }
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    public void drawLayer(Canvas canvas, GraphicsLayer parentLayer) {
        android.graphics.Canvas androidCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (androidCanvas.isHardwareAccelerated()) {
            updateDisplayList();
            this.drawnWithZ = this.renderNode.getElevation() > 0.0f;
            if (this.drawnWithZ) {
                canvas.enableZ();
            }
            this.renderNode.drawInto(androidCanvas);
            if (this.drawnWithZ) {
                canvas.disableZ();
                return;
            }
            return;
        }
        float left = this.renderNode.getLeft();
        float top = this.renderNode.getTop();
        float right = this.renderNode.getRight();
        float bottom = this.renderNode.getBottom();
        if (this.renderNode.getAlpha() < 1.0f) {
            Paint it = this.softwareLayerPaint;
            if (it == null) {
                it = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = it;
            }
            it.setAlpha(this.renderNode.getAlpha());
            Paint paint = it;
            androidCanvas.saveLayer(left, top, right, bottom, paint.getInternalPaint());
        } else {
            canvas.save();
        }
        canvas.translate(left, top);
        canvas.mo4146concat58bKbWc(this.matrixCache.m6009calculateMatrixGrdbGEg(this.renderNode));
        clipRenderNode(canvas);
        Function1<? super Canvas, Unit> function1 = this.drawBlock;
        if (function1 != null) {
            function1.invoke(canvas);
        }
        canvas.restore();
        setDirty(false);
    }

    private final void clipRenderNode(Canvas canvas) {
        if (this.renderNode.getClipToOutline() || this.renderNode.getClipToBounds()) {
            this.outlineResolver.clipToOutline(canvas);
        }
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    public void updateDisplayList() {
        Path clipPath;
        if (this.isDirty || !this.renderNode.getHasDisplayList()) {
            if (this.renderNode.getClipToOutline() && !this.outlineResolver.getOutlineClipSupported()) {
                clipPath = this.outlineResolver.getClipPath();
            } else {
                clipPath = null;
            }
            Function1<? super Canvas, Unit> function1 = this.drawBlock;
            if (function1 != null) {
                this.renderNode.record(this.canvasHolder, clipPath, function1);
            }
            setDirty(false);
        }
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    public void destroy() {
        if (this.renderNode.getHasDisplayList()) {
            this.renderNode.discardDisplayList();
        }
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        this.ownerView.requestClearInvalidObservations();
        this.ownerView.recycle$ui_release(this);
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    /* JADX INFO: renamed from: mapOffset-8S9VItk */
    public long mo5925mapOffset8S9VItk(long point, boolean inverse) {
        if (inverse) {
            float[] fArrM6008calculateInverseMatrixbWbORWo = this.matrixCache.m6008calculateInverseMatrixbWbORWo(this.renderNode);
            return fArrM6008calculateInverseMatrixbWbORWo != null ? androidx.compose.p001ui.graphics.Matrix.m4535mapMKHz9U(fArrM6008calculateInverseMatrixbWbORWo, point) : Offset.INSTANCE.m4063getInfiniteF1C5BW0();
        }
        return androidx.compose.p001ui.graphics.Matrix.m4535mapMKHz9U(this.matrixCache.m6009calculateMatrixGrdbGEg(this.renderNode), point);
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    public void mapBounds(MutableRect rect, boolean inverse) {
        if (inverse) {
            float[] matrix = this.matrixCache.m6008calculateInverseMatrixbWbORWo(this.renderNode);
            if (matrix == null) {
                rect.set(0.0f, 0.0f, 0.0f, 0.0f);
                return;
            } else {
                androidx.compose.p001ui.graphics.Matrix.m4537mapimpl(matrix, rect);
                return;
            }
        }
        androidx.compose.p001ui.graphics.Matrix.m4537mapimpl(this.matrixCache.m6009calculateMatrixGrdbGEg(this.renderNode), rect);
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    public void reuseLayer(Function1<? super Canvas, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        setDirty(false);
        this.isDestroyed = false;
        this.drawnWithZ = false;
        this.transformOrigin = TransformOrigin.INSTANCE.m4690getCenterSzJe1aQ();
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    /* JADX INFO: renamed from: transform-58bKbWc */
    public void mo5928transform58bKbWc(float[] matrix) {
        androidx.compose.p001ui.graphics.Matrix.m4546timesAssign58bKbWc(matrix, this.matrixCache.m6009calculateMatrixGrdbGEg(this.renderNode));
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    /* JADX INFO: renamed from: inverseTransform-58bKbWc */
    public void mo5923inverseTransform58bKbWc(float[] matrix) {
        float[] inverse = this.matrixCache.m6008calculateInverseMatrixbWbORWo(this.renderNode);
        if (inverse != null) {
            androidx.compose.p001ui.graphics.Matrix.m4546timesAssign58bKbWc(matrix, inverse);
        }
    }
}
