package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GraphicsLayerOwnerLayer.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\u0010\rJ\b\u0010)\u001a\u00020\nH\u0016J\u001a\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u0004H\u0016J\u001f\u0010-\u001a\u00020\u001d2\b\b\u0002\u0010.\u001a\u00020\u0011H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100J\b\u00101\u001a\u00020\nH\u0016J\u001a\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u001a\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u0018\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020=2\u0006\u0010.\u001a\u00020\u0011H\u0016J\"\u0010>\u001a\u0002082\u0006\u0010?\u001a\u0002082\u0006\u0010.\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u001a\u0010B\u001a\u00020\n2\u0006\u00107\u001a\u00020CH\u0016ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u001a\u0010F\u001a\u00020\n2\u0006\u0010#\u001a\u00020$H\u0016ø\u0001\u0000¢\u0006\u0004\bG\u0010EJ*\u0010H\u001a\u00020\n2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0016J\u001a\u0010I\u001a\u00020\n2\u0006\u00103\u001a\u00020\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\bJ\u00105J\b\u0010K\u001a\u00020\nH\u0016J \u0010L\u001a\u00020\n2\u0006\u0010!\u001a\u00020M2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010N\u001a\u00020\nH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\u00020\u001dX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0019R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\u00020$X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006O"}, d2 = {"Landroidx/compose/ui/platform/GraphicsLayerOwnerLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "density", "Landroidx/compose/ui/unit/Density;", "isDestroyed", "", DownloadUtil.CookieScheme.VALUE, "isDirty", "setDirty", "(Z)V", "layerId", "", "getLayerId", "()J", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "matrixCache", "Landroidx/compose/ui/graphics/Matrix;", "[F", "ownerViewId", "getOwnerViewId", "scope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "tmpOpPath", "Landroidx/compose/ui/graphics/Path;", "tmpTouchPointPath", "destroy", "drawLayer", "canvas", "parentLayer", "getMatrix", "inverse", "getMatrix-GrdbGEg", "(Z)[F", "invalidate", "inverseTransform", "matrix", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "resize-ozmzZPI", "reuseLayer", "transform", "transform-58bKbWc", "updateDisplayList", "updateLayerProperties", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "updateMatrix", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class GraphicsLayerOwnerLayer implements OwnedLayer, GraphicLayerInfo {
    public static final int $stable = 8;
    private Function1<? super Canvas, Unit> drawBlock;
    private final GraphicsLayer graphicsLayer;
    private Function0<Unit> invalidateParentLayer;
    private boolean isDestroyed;
    private final AndroidComposeView ownerView;
    private Path tmpOpPath;
    private Path tmpTouchPointPath;
    private long size = IntSize.INSTANCE.m6732getZeroYbymL2g();
    private final float[] matrixCache = Matrix.m4281constructorimpl$default(null, 1, null);
    private boolean isDirty = true;
    private Density density = DensityKt.Density$default(1.0f, 0.0f, 2, null);
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private final CanvasDrawScope scope = new CanvasDrawScope();

    public GraphicsLayerOwnerLayer(GraphicsLayer graphicsLayer, AndroidComposeView ownerView, Function1<? super Canvas, Unit> function1, Function0<Unit> function0) {
        this.graphicsLayer = graphicsLayer;
        this.ownerView = ownerView;
        this.drawBlock = function1;
        this.invalidateParentLayer = function0;
    }

    private final void setDirty(boolean value) {
        if (value != this.isDirty) {
            this.isDirty = value;
            this.ownerView.notifyLayerIsDirty$ui_release(this, value);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateLayerProperties(ReusableGraphicsLayerScope scope, LayoutDirection layoutDirection, Density density) {
        InlineClassHelperKt.throwIllegalStateException("Current apis doesn't allow for both GraphicsLayer and GraphicsLayerScope to be used together");
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: isInLayer-k-4lQ0M */
    public boolean mo5676isInLayerk4lQ0M(long position) {
        float x = Offset.m3801getXimpl(position);
        float y = Offset.m3802getYimpl(position);
        if (this.graphicsLayer.getClip()) {
            Outline outline = this.graphicsLayer.getOutline();
            return ShapeContainingUtilKt.isInOutline(outline, x, y, this.tmpTouchPointPath, this.tmpOpPath);
        }
        return true;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: move--gyyYBs */
    public void mo5678movegyyYBs(long position) {
        this.graphicsLayer.m4714setTopLeftgyyYBs(position);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: resize-ozmzZPI */
    public void mo5679resizeozmzZPI(long size) {
        if (!IntSize.m6725equalsimpl0(size, this.size)) {
            this.size = size;
            invalidate();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void drawLayer(Canvas canvas, GraphicsLayer parentLayer) {
        updateDisplayList();
        DrawScope $this$draw_u2dymL40Pk$iv = this.scope;
        Density density$iv = this.density;
        LayoutDirection layoutDirection$iv = this.layoutDirection;
        long size$iv = IntSizeKt.m6739toSizeozmzZPI(this.size);
        Density prevDensity$iv = $this$draw_u2dymL40Pk$iv.getDrawContext().getDensity();
        LayoutDirection prevLayoutDirection$iv = $this$draw_u2dymL40Pk$iv.getDrawContext().getLayoutDirection();
        Canvas prevCanvas$iv = $this$draw_u2dymL40Pk$iv.getDrawContext().getCanvas();
        long prevSize$iv = $this$draw_u2dymL40Pk$iv.getDrawContext().mo4531getSizeNHjbRc();
        GraphicsLayer prevLayer$iv = $this$draw_u2dymL40Pk$iv.getDrawContext().getGraphicsLayer();
        DrawContext $this$draw_ymL40Pk_u24lambda_u247$iv = $this$draw_u2dymL40Pk$iv.getDrawContext();
        $this$draw_ymL40Pk_u24lambda_u247$iv.setDensity(density$iv);
        $this$draw_ymL40Pk_u24lambda_u247$iv.setLayoutDirection(layoutDirection$iv);
        $this$draw_ymL40Pk_u24lambda_u247$iv.setCanvas(canvas);
        $this$draw_ymL40Pk_u24lambda_u247$iv.mo4532setSizeuvyYCjk(size$iv);
        $this$draw_ymL40Pk_u24lambda_u247$iv.setGraphicsLayer(parentLayer);
        canvas.save();
        try {
            GraphicsLayerKt.drawLayer($this$draw_u2dymL40Pk$iv, this.graphicsLayer);
        } finally {
            canvas.restore();
            DrawContext $this$draw_ymL40Pk_u24lambda_u248$iv = $this$draw_u2dymL40Pk$iv.getDrawContext();
            $this$draw_ymL40Pk_u24lambda_u248$iv.setDensity(prevDensity$iv);
            $this$draw_ymL40Pk_u24lambda_u248$iv.setLayoutDirection(prevLayoutDirection$iv);
            $this$draw_ymL40Pk_u24lambda_u248$iv.setCanvas(prevCanvas$iv);
            $this$draw_ymL40Pk_u24lambda_u248$iv.mo4532setSizeuvyYCjk(prevSize$iv);
            $this$draw_ymL40Pk_u24lambda_u248$iv.setGraphicsLayer(prevLayer$iv);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateDisplayList() {
        if (this.isDirty) {
            this.graphicsLayer.m4698buildLayermLhObY(this.density, this.layoutDirection, this.size, new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.platform.GraphicsLayerOwnerLayer.updateDisplayList.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope $this$buildLayer) {
                    GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = GraphicsLayerOwnerLayer.this;
                    Canvas canvas = $this$buildLayer.getDrawContext().getCanvas();
                    Function1 it = graphicsLayerOwnerLayer.drawBlock;
                    if (it != null) {
                        it.invoke(canvas);
                    }
                }
            });
            setDirty(false);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        if (!this.isDirty && !this.isDestroyed) {
            this.ownerView.invalidate();
            setDirty(true);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: mapOffset-8S9VItk */
    public long mo5677mapOffset8S9VItk(long point, boolean inverse) {
        return Matrix.m4287mapMKHz9U(m5756getMatrixGrdbGEg(inverse), point);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void mapBounds(MutableRect rect, boolean inverse) {
        Matrix.m4289mapimpl(m5756getMatrixGrdbGEg(inverse), rect);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void reuseLayer(Function1<? super Canvas, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        InlineClassHelperKt.throwIllegalStateException("reuseLayer is not supported yet");
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: transform-58bKbWc */
    public void mo5680transform58bKbWc(float[] matrix) {
        Matrix.m4298timesAssign58bKbWc(matrix, m5756getMatrixGrdbGEg(false));
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: inverseTransform-58bKbWc */
    public void mo5675inverseTransform58bKbWc(float[] matrix) {
        Matrix.m4298timesAssign58bKbWc(matrix, m5756getMatrixGrdbGEg(true));
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getLayerId() {
        return this.graphicsLayer.getLayerId();
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getOwnerViewId() {
        return this.graphicsLayer.getOwnerViewId();
    }

    /* JADX INFO: renamed from: getMatrix-GrdbGEg$default, reason: not valid java name */
    static /* synthetic */ float[] m5757getMatrixGrdbGEg$default(GraphicsLayerOwnerLayer graphicsLayerOwnerLayer, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return graphicsLayerOwnerLayer.m5756getMatrixGrdbGEg(z);
    }

    /* JADX INFO: renamed from: getMatrix-GrdbGEg, reason: not valid java name */
    private final float[] m5756getMatrixGrdbGEg(boolean inverse) {
        updateMatrix();
        if (inverse) {
            Matrix.m4286invertimpl(this.matrixCache);
        }
        return this.matrixCache;
    }

    private final void updateMatrix() {
        long $this$toOffset_u2d_u2dgyyYBs$iv;
        GraphicsLayer $this$updateMatrix_u24lambda_u244 = this.graphicsLayer;
        if (!OffsetKt.m3822isUnspecifiedk4lQ0M($this$updateMatrix_u24lambda_u244.getPivotOffset())) {
            $this$toOffset_u2d_u2dgyyYBs$iv = $this$updateMatrix_u24lambda_u244.getPivotOffset();
        } else {
            long $this$toOffset_u2d_u2dgyyYBs$iv2 = IntSizeKt.m6733getCenterozmzZPI($this$updateMatrix_u24lambda_u244.getSize());
            $this$toOffset_u2d_u2dgyyYBs$iv = OffsetKt.Offset(IntOffset.m6685getXimpl($this$toOffset_u2d_u2dgyyYBs$iv2), IntOffset.m6686getYimpl($this$toOffset_u2d_u2dgyyYBs$iv2));
        }
        Matrix.m4290resetimpl(this.matrixCache);
        float[] fArr = this.matrixCache;
        float[] $this$updateMatrix_u24lambda_u244_u24lambda_u241 = Matrix.m4281constructorimpl$default(null, 1, null);
        Matrix.m4301translateimpl$default($this$updateMatrix_u24lambda_u244_u24lambda_u241, -Offset.m3801getXimpl($this$toOffset_u2d_u2dgyyYBs$iv), -Offset.m3802getYimpl($this$toOffset_u2d_u2dgyyYBs$iv), 0.0f, 4, null);
        Matrix.m4298timesAssign58bKbWc(fArr, $this$updateMatrix_u24lambda_u244_u24lambda_u241);
        float[] fArr2 = this.matrixCache;
        float[] $this$updateMatrix_u24lambda_u244_u24lambda_u242 = Matrix.m4281constructorimpl$default(null, 1, null);
        Matrix.m4301translateimpl$default($this$updateMatrix_u24lambda_u244_u24lambda_u242, $this$updateMatrix_u24lambda_u244.getTranslationX(), $this$updateMatrix_u24lambda_u244.getTranslationY(), 0.0f, 4, null);
        Matrix.m4291rotateXimpl($this$updateMatrix_u24lambda_u244_u24lambda_u242, $this$updateMatrix_u24lambda_u244.getRotationX());
        Matrix.m4292rotateYimpl($this$updateMatrix_u24lambda_u244_u24lambda_u242, $this$updateMatrix_u24lambda_u244.getRotationY());
        Matrix.m4293rotateZimpl($this$updateMatrix_u24lambda_u244_u24lambda_u242, $this$updateMatrix_u24lambda_u244.getRotationZ());
        Matrix.m4295scaleimpl$default($this$updateMatrix_u24lambda_u244_u24lambda_u242, $this$updateMatrix_u24lambda_u244.getScaleX(), $this$updateMatrix_u24lambda_u244.getScaleY(), 0.0f, 4, null);
        Matrix.m4298timesAssign58bKbWc(fArr2, $this$updateMatrix_u24lambda_u244_u24lambda_u242);
        float[] fArr3 = this.matrixCache;
        float[] $this$updateMatrix_u24lambda_u244_u24lambda_u243 = Matrix.m4281constructorimpl$default(null, 1, null);
        Matrix.m4301translateimpl$default($this$updateMatrix_u24lambda_u244_u24lambda_u243, Offset.m3801getXimpl($this$toOffset_u2d_u2dgyyYBs$iv), Offset.m3802getYimpl($this$toOffset_u2d_u2dgyyYBs$iv), 0.0f, 4, null);
        Matrix.m4298timesAssign58bKbWc(fArr3, $this$updateMatrix_u24lambda_u244_u24lambda_u243);
    }
}
