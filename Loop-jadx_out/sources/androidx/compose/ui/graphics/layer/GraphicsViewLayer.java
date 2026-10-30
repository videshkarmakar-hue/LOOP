package androidx.compose.ui.graphics.layer;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidColorFilter_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.graphics.layer.view.PlaceholderHardwareCanvas;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GraphicsViewLayer.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u0091\u00012\u00020\u0001:\u0002\u0091\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010q\u001a\u00020r2\u0006\u00105\u001a\u000204H\u0002ø\u0001\u0000¢\u0006\u0004\bs\u0010\u001eJ9\u0010t\u001a\u00020r2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020z2\u0017\u0010{\u001a\u0013\u0012\u0004\u0012\u00020}\u0012\u0004\u0012\u00020r0|¢\u0006\u0002\b~H\u0016J\t\u0010\u007f\u001a\u00030\u0080\u0001H\u0016J\t\u0010\u0081\u0001\u001a\u00020rH\u0016J\u0013\u0010\u0082\u0001\u001a\u00020r2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\t\u0010\u0085\u0001\u001a\u00020=H\u0002J\t\u0010\u0086\u0001\u001a\u00020rH\u0002J\t\u0010\u0087\u0001\u001a\u00020%H\u0002J\t\u0010\u0088\u0001\u001a\u00020%H\u0002J\u001b\u0010\u0089\u0001\u001a\u00020r2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0006\u0010&\u001a\u00020%H\u0016J%\u0010\u008c\u0001\u001a\u00020r2\u0006\u0010g\u001a\u00020h2\u0006\u0010b\u001a\u00020cH\u0016ø\u0001\u0000¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\t\u0010\u008f\u0001\u001a\u00020rH\u0002J\t\u0010\u0090\u0001\u001a\u00020rH\u0002R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R,\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0012@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R,\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u0019@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R$\u0010&\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020%@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010/\u001a\u0004\u0018\u00010.2\b\u0010\u000b\u001a\u0004\u0018\u00010.@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R,\u00105\u001a\u0002042\u0006\u0010\u000b\u001a\u000204@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b6\u0010\u001c\"\u0004\b7\u0010\u001eR\u001a\u00108\u001a\u00020%X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010(\"\u0004\b9\u0010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0015R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0015R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010D\u001a\u00020C2\u0006\u0010\u000b\u001a\u00020C@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\bE\u0010\u0015\"\u0004\bF\u0010\u0017R(\u0010H\u001a\u0004\u0018\u00010G2\b\u0010\u000b\u001a\u0004\u0018\u00010G@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0016\u0010M\u001a\n O*\u0004\u0018\u00010N0NX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010P\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u000f\"\u0004\bR\u0010\u0011R$\u0010S\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u000f\"\u0004\bU\u0010\u0011R$\u0010V\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u000f\"\u0004\bX\u0010\u0011R$\u0010Y\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u000f\"\u0004\b[\u0010\u0011R$\u0010\\\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u000f\"\u0004\b^\u0010\u0011R$\u0010_\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u000f\"\u0004\ba\u0010\u0011R\u0016\u0010b\u001a\u00020cX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R,\u0010d\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0012@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\be\u0010\u0015\"\u0004\bf\u0010\u0017R\u0016\u0010g\u001a\u00020hX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R$\u0010i\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u000f\"\u0004\bk\u0010\u0011R$\u0010l\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u000f\"\u0004\bn\u0010\u0011R\u000e\u0010o\u001a\u00020pX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0092\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsViewLayer;", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "layerContainer", "Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", "ownerId", "", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;JLandroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", DownloadUtil.CookieScheme.VALUE, "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "J", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "I", "cameraDistance", "getCameraDistance", "setCameraDistance", "getCanvasHolder", "()Landroidx/compose/ui/graphics/CanvasHolder;", "", "clip", "getClip", "()Z", "setClip", "(Z)V", "clipInvalidated", "clipRect", "Landroid/graphics/Rect;", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "isInvalidated", "setInvalidated", "layerId", "getLayerId", "layerPaint", "Landroid/graphics/Paint;", "getOwnerId", "picture", "Landroid/graphics/Picture;", "pictureCanvasHolder", "pictureDrawScope", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "resources", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "size", "Landroidx/compose/ui/unit/IntSize;", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "topLeft", "Landroidx/compose/ui/unit/IntOffset;", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "viewLayer", "Landroidx/compose/ui/graphics/layer/ViewLayer;", "applyCompositingLayer", "", "applyCompositingLayer-Wpw9cng", "buildLayer", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "calculateMatrix", "Landroid/graphics/Matrix;", "discardDisplayList", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "obtainLayerPaint", "recordDrawingOperations", "requiresCompositingLayer", "requiresLayerPaint", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "setPosition-VbeCjmY", "(JJ)V", "updateClip", "updateLayerProperties", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class GraphicsViewLayer implements GraphicsLayerImpl {
    private static final Canvas PlaceholderCanvas;
    private float alpha;
    private long ambientShadowColor;
    private int blendMode;
    private final CanvasHolder canvasHolder;
    private boolean clip;
    private boolean clipInvalidated;
    private final Rect clipRect;
    private ColorFilter colorFilter;
    private int compositingStrategy;
    private boolean isInvalidated;
    private final DrawChildContainer layerContainer;
    private final long layerId;
    private Paint layerPaint;
    private final long ownerId;
    private final Picture picture;
    private final CanvasHolder pictureCanvasHolder;
    private final CanvasDrawScope pictureDrawScope;
    private long pivotOffset;
    private RenderEffect renderEffect;
    private final Resources resources;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private float shadowElevation;
    private long size;
    private long spotShadowColor;
    private long topLeft;
    private float translationX;
    private float translationY;
    private final ViewLayer viewLayer;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean mayRenderInSoftware = !SurfaceUtils.INSTANCE.isLockHardwareCanvasAvailable();

    public GraphicsViewLayer(DrawChildContainer layerContainer, long ownerId, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        Picture picture;
        CanvasDrawScope canvasDrawScope2;
        CanvasHolder canvasHolder2;
        this.layerContainer = layerContainer;
        this.ownerId = ownerId;
        this.canvasHolder = canvasHolder;
        this.viewLayer = new ViewLayer(this.layerContainer, this.canvasHolder, canvasDrawScope);
        this.resources = this.layerContainer.getResources();
        this.clipRect = new Rect();
        if (mayRenderInSoftware) {
            picture = new Picture();
        } else {
            picture = null;
        }
        this.picture = picture;
        if (mayRenderInSoftware) {
            canvasDrawScope2 = new CanvasDrawScope();
        } else {
            canvasDrawScope2 = null;
        }
        this.pictureDrawScope = canvasDrawScope2;
        if (mayRenderInSoftware) {
            canvasHolder2 = new CanvasHolder();
        } else {
            canvasHolder2 = null;
        }
        this.pictureCanvasHolder = canvasHolder2;
        this.layerContainer.addView(this.viewLayer);
        this.viewLayer.setClipBounds(null);
        this.topLeft = IntOffset.INSTANCE.m6695getZeronOccac();
        this.size = IntSize.INSTANCE.m6732getZeroYbymL2g();
        this.isInvalidated = true;
        this.layerId = View.generateViewId();
        this.blendMode = BlendMode.INSTANCE.m3985getSrcOver0nO6VwU();
        this.compositingStrategy = CompositingStrategy.INSTANCE.m4692getAutoke2Ky5w();
        this.alpha = 1.0f;
        this.pivotOffset = Offset.INSTANCE.m3817getZeroF1C5BW0();
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.ambientShadowColor = Color.INSTANCE.m4069getBlack0d7_KjU();
        this.spotShadowColor = Color.INSTANCE.m4069getBlack0d7_KjU();
    }

    public /* synthetic */ GraphicsViewLayer(DrawChildContainer drawChildContainer, long j, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        CanvasHolder canvasHolder2;
        CanvasDrawScope canvasDrawScope2;
        if ((i & 4) == 0) {
            canvasHolder2 = canvasHolder;
        } else {
            canvasHolder2 = new CanvasHolder();
        }
        if ((i & 8) == 0) {
            canvasDrawScope2 = canvasDrawScope;
        } else {
            canvasDrawScope2 = new CanvasDrawScope();
        }
        this(drawChildContainer, j, canvasHolder2, canvasDrawScope2);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long getOwnerId() {
        return this.ownerId;
    }

    public final CanvasHolder getCanvasHolder() {
        return this.canvasHolder;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: isInvalidated, reason: from getter */
    public boolean getIsInvalidated() {
        return this.isInvalidated;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setInvalidated(boolean z) {
        this.isInvalidated = z;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long getLayerId() {
        return this.layerId;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: from getter */
    public int getBlendMode() {
        return this.blendMode;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setBlendMode-s9anfk8 */
    public void mo4723setBlendModes9anfk8(int value) {
        this.blendMode = value;
        Paint $this$setBlendMode_s9anfk8_u24lambda_u240 = obtainLayerPaint();
        $this$setBlendMode_s9anfk8_u24lambda_u240.setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m3894toPorterDuffModes9anfk8(value)));
        updateLayerProperties();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setColorFilter(ColorFilter value) {
        this.colorFilter = value;
        Paint $this$_set_colorFilter__u24lambda_u241 = obtainLayerPaint();
        $this$_set_colorFilter__u24lambda_u241.setColorFilter(value != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(value) : null);
        updateLayerProperties();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: getCompositingStrategy-ke2Ky5w, reason: from getter */
    public int getCompositingStrategy() {
        return this.compositingStrategy;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setCompositingStrategy-Wpw9cng */
    public void mo4724setCompositingStrategyWpw9cng(int value) {
        this.compositingStrategy = value;
        updateLayerProperties();
    }

    /* JADX INFO: renamed from: applyCompositingLayer-Wpw9cng, reason: not valid java name */
    private final void m4730applyCompositingLayerWpw9cng(int compositingStrategy) {
        ViewLayer viewLayer = this.viewLayer;
        boolean z = true;
        if (CompositingStrategy.m4688equalsimpl0(compositingStrategy, CompositingStrategy.INSTANCE.m4694getOffscreenke2Ky5w())) {
            this.viewLayer.setLayerType(2, this.layerPaint);
        } else if (CompositingStrategy.m4688equalsimpl0(compositingStrategy, CompositingStrategy.INSTANCE.m4693getModulateAlphake2Ky5w())) {
            this.viewLayer.setLayerType(0, this.layerPaint);
            z = false;
        } else {
            this.viewLayer.setLayerType(0, this.layerPaint);
        }
        viewLayer.setCanUseCompositingLayer$ui_graphics_release(z);
    }

    private final void updateLayerProperties() {
        if (requiresCompositingLayer()) {
            m4730applyCompositingLayerWpw9cng(CompositingStrategy.INSTANCE.m4694getOffscreenke2Ky5w());
        } else {
            m4730applyCompositingLayerWpw9cng(getCompositingStrategy());
        }
    }

    private final Paint obtainLayerPaint() {
        Paint paint = this.layerPaint;
        if (paint != null) {
            return paint;
        }
        Paint it = new Paint();
        this.layerPaint = it;
        return it;
    }

    private final boolean requiresCompositingLayer() {
        return CompositingStrategy.m4688equalsimpl0(getCompositingStrategy(), CompositingStrategy.INSTANCE.m4694getOffscreenke2Ky5w()) || requiresLayerPaint();
    }

    private final boolean requiresLayerPaint() {
        return (BlendMode.m3954equalsimpl0(getBlendMode(), BlendMode.INSTANCE.m3985getSrcOver0nO6VwU()) && getColorFilter() == null) ? false : true;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setAlpha(float value) {
        this.alpha = value;
        this.viewLayer.setAlpha(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: getPivotOffset-F1C5BW0, reason: from getter */
    public long getPivotOffset() {
        return this.pivotOffset;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setPivotOffset-k-4lQ0M */
    public void mo4725setPivotOffsetk4lQ0M(long value) {
        this.pivotOffset = value;
        this.viewLayer.setPivotX(Offset.m3801getXimpl(value));
        this.viewLayer.setPivotY(Offset.m3802getYimpl(value));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getScaleX() {
        return this.scaleX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setScaleX(float value) {
        this.scaleX = value;
        this.viewLayer.setScaleX(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getScaleY() {
        return this.scaleY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setScaleY(float value) {
        this.scaleY = value;
        this.viewLayer.setScaleY(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getTranslationX() {
        return this.translationX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationX(float value) {
        this.translationX = value;
        this.viewLayer.setTranslationX(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getTranslationY() {
        return this.translationY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationY(float value) {
        this.translationY = value;
        this.viewLayer.setTranslationY(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getShadowElevation() {
        return this.shadowElevation;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setShadowElevation(float value) {
        this.shadowElevation = value;
        this.viewLayer.setElevation(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: getAmbientShadowColor-0d7_KjU, reason: from getter */
    public long getAmbientShadowColor() {
        return this.ambientShadowColor;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA */
    public void mo4722setAmbientShadowColor8_81llA(long value) {
        this.ambientShadowColor = value;
        if (Build.VERSION.SDK_INT >= 28) {
            ViewLayerVerificationHelper28.INSTANCE.setOutlineAmbientShadowColor(this.viewLayer, ColorKt.m4097toArgb8_81llA(value));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: getSpotShadowColor-0d7_KjU, reason: from getter */
    public long getSpotShadowColor() {
        return this.spotShadowColor;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setSpotShadowColor-8_81llA */
    public void mo4727setSpotShadowColor8_81llA(long value) {
        this.spotShadowColor = value;
        if (Build.VERSION.SDK_INT >= 28) {
            ViewLayerVerificationHelper28.INSTANCE.setOutlineSpotShadowColor(this.viewLayer, ColorKt.m4097toArgb8_81llA(value));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getRotationX() {
        return this.rotationX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationX(float value) {
        this.rotationX = value;
        this.viewLayer.setRotationX(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getRotationY() {
        return this.rotationY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationY(float value) {
        this.rotationY = value;
        this.viewLayer.setRotationY(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getRotationZ() {
        return this.rotationZ;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationZ(float value) {
        this.rotationZ = value;
        this.viewLayer.setRotation(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getCameraDistance() {
        return this.viewLayer.getCameraDistance() / this.resources.getDisplayMetrics().densityDpi;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setCameraDistance(float value) {
        this.viewLayer.setCameraDistance(this.resources.getDisplayMetrics().densityDpi * value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean getClip() {
        return this.clip;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setClip(boolean value) {
        this.clip = value;
        this.clipInvalidated = true;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRenderEffect(RenderEffect value) {
        this.renderEffect = value;
        if (Build.VERSION.SDK_INT >= 31) {
            ViewLayerVerificationHelper31.INSTANCE.setRenderEffect(this.viewLayer, value);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setPosition-VbeCjmY */
    public void mo4726setPositionVbeCjmY(long topLeft, long size) {
        if (IntOffset.m6685getXimpl(this.topLeft) != IntOffset.m6685getXimpl(topLeft)) {
            this.viewLayer.offsetLeftAndRight(IntOffset.m6685getXimpl(topLeft) - IntOffset.m6685getXimpl(this.topLeft));
        }
        if (IntOffset.m6686getYimpl(this.topLeft) != IntOffset.m6686getYimpl(topLeft)) {
            this.viewLayer.offsetTopAndBottom(IntOffset.m6686getYimpl(topLeft) - IntOffset.m6686getYimpl(this.topLeft));
        }
        if (!IntSize.m6725equalsimpl0(this.size, size)) {
            if (getClip()) {
                this.clipInvalidated = true;
            }
            this.viewLayer.layout(IntOffset.m6685getXimpl(topLeft), IntOffset.m6686getYimpl(topLeft), IntOffset.m6685getXimpl(topLeft) + IntSize.m6727getWidthimpl(size), IntOffset.m6686getYimpl(topLeft) + IntSize.m6726getHeightimpl(size));
        }
        this.topLeft = topLeft;
        this.size = size;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setOutline(Outline outline, boolean clip) {
        boolean requiresRedraw = !this.viewLayer.setLayerOutline(outline);
        this.viewLayer.setClipToOutline(clip);
        if (requiresRedraw) {
            this.viewLayer.invalidate();
            recordDrawingOperations();
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void buildLayer(Density density, LayoutDirection layoutDirection, GraphicsLayer layer, Function1<? super DrawScope, Unit> block) {
        this.viewLayer.setDrawParams(density, layoutDirection, layer, block);
        recordDrawingOperations();
        Picture p = this.picture;
        if (p != null) {
            Canvas pictureCanvas = p.beginRecording(IntSize.m6727getWidthimpl(this.size), IntSize.m6726getHeightimpl(this.size));
            CanvasHolder this_$iv = this.pictureCanvasHolder;
            if (this_$iv != null) {
                Canvas previousCanvas$iv = this_$iv.getAndroidCanvas().getInternalCanvas();
                this_$iv.getAndroidCanvas().setInternalCanvas(pictureCanvas);
                androidx.compose.ui.graphics.Canvas $this$buildLayer_u24lambda_u244_u24lambda_u243 = this_$iv.getAndroidCanvas();
                CanvasDrawScope this_$iv2 = this.pictureDrawScope;
                if (this_$iv2 != null) {
                    long size$iv = IntSizeKt.m6739toSizeozmzZPI(this.size);
                    CanvasDrawScope.DrawParams drawParams = this_$iv2.getDrawParams();
                    Density prevDensity$iv = drawParams.getDensity();
                    LayoutDirection prevLayoutDirection$iv = drawParams.getLayoutDirection();
                    androidx.compose.ui.graphics.Canvas prevCanvas$iv = drawParams.getCanvas();
                    long prevSize$iv = drawParams.getSize();
                    CanvasDrawScope.DrawParams $this$draw_yzxVdVo_u24lambda_u240$iv = this_$iv2.getDrawParams();
                    $this$draw_yzxVdVo_u24lambda_u240$iv.setDensity(density);
                    $this$draw_yzxVdVo_u24lambda_u240$iv.setLayoutDirection(layoutDirection);
                    $this$draw_yzxVdVo_u24lambda_u240$iv.setCanvas($this$buildLayer_u24lambda_u244_u24lambda_u243);
                    $this$draw_yzxVdVo_u24lambda_u240$iv.m4530setSizeuvyYCjk(size$iv);
                    $this$buildLayer_u24lambda_u244_u24lambda_u243.save();
                    block.invoke(this_$iv2);
                    $this$buildLayer_u24lambda_u244_u24lambda_u243.restore();
                    CanvasDrawScope.DrawParams $this$draw_yzxVdVo_u24lambda_u241$iv = this_$iv2.getDrawParams();
                    $this$draw_yzxVdVo_u24lambda_u241$iv.setDensity(prevDensity$iv);
                    $this$draw_yzxVdVo_u24lambda_u241$iv.setLayoutDirection(prevLayoutDirection$iv);
                    $this$draw_yzxVdVo_u24lambda_u241$iv.setCanvas(prevCanvas$iv);
                    $this$draw_yzxVdVo_u24lambda_u241$iv.m4530setSizeuvyYCjk(prevSize$iv);
                }
                this_$iv.getAndroidCanvas().setInternalCanvas(previousCanvas$iv);
            }
            p.endRecording();
        }
    }

    private final void recordDrawingOperations() {
        try {
            CanvasHolder this_$iv = this.canvasHolder;
            Canvas targetCanvas$iv = PlaceholderCanvas;
            Canvas previousCanvas$iv = this_$iv.getAndroidCanvas().getInternalCanvas();
            this_$iv.getAndroidCanvas().setInternalCanvas(targetCanvas$iv);
            androidx.compose.ui.graphics.Canvas $this$recordDrawingOperations_u24lambda_u245 = this_$iv.getAndroidCanvas();
            this.layerContainer.drawChild$ui_graphics_release($this$recordDrawingOperations_u24lambda_u245, this.viewLayer, this.viewLayer.getDrawingTime());
            this_$iv.getAndroidCanvas().setInternalCanvas(previousCanvas$iv);
        } catch (Throwable th) {
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void draw(androidx.compose.ui.graphics.Canvas canvas) {
        updateClip();
        Canvas androidCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (androidCanvas.isHardwareAccelerated()) {
            this.layerContainer.drawChild$ui_graphics_release(canvas, this.viewLayer, this.viewLayer.getDrawingTime());
            return;
        }
        Picture it = this.picture;
        if (it != null) {
            androidCanvas.drawPicture(it);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public Matrix calculateMatrix() {
        return this.viewLayer.getMatrix();
    }

    private final void updateClip() {
        Rect $this$updateClip_u24lambda_u247;
        if (this.clipInvalidated) {
            ViewLayer viewLayer = this.viewLayer;
            if (getClip()) {
                $this$updateClip_u24lambda_u247 = this.clipRect;
                $this$updateClip_u24lambda_u247.left = 0;
                $this$updateClip_u24lambda_u247.top = 0;
                $this$updateClip_u24lambda_u247.right = this.viewLayer.getWidth();
                $this$updateClip_u24lambda_u247.bottom = this.viewLayer.getHeight();
            } else {
                $this$updateClip_u24lambda_u247 = null;
            }
            viewLayer.setClipBounds($this$updateClip_u24lambda_u247);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void discardDisplayList() {
        this.layerContainer.removeViewInLayout(this.viewLayer);
    }

    /* JADX INFO: compiled from: GraphicsViewLayer.android.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsViewLayer$Companion;", "", "()V", "PlaceholderCanvas", "Landroid/graphics/Canvas;", "getPlaceholderCanvas", "()Landroid/graphics/Canvas;", "mayRenderInSoftware", "", "getMayRenderInSoftware", "()Z", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getMayRenderInSoftware() {
            return GraphicsViewLayer.mayRenderInSoftware;
        }

        public final Canvas getPlaceholderCanvas() {
            return GraphicsViewLayer.PlaceholderCanvas;
        }
    }

    static {
        Canvas canvas;
        if (Build.VERSION.SDK_INT >= 23) {
            canvas = new Canvas() { // from class: androidx.compose.ui.graphics.layer.GraphicsViewLayer$Companion$PlaceholderCanvas$1
                @Override // android.graphics.Canvas
                public boolean isHardwareAccelerated() {
                    return true;
                }
            };
        } else {
            canvas = (Canvas) new PlaceholderHardwareCanvas();
        }
        PlaceholderCanvas = canvas;
    }
}
