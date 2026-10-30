package androidx.compose.p001ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import android.view.View;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.p001ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p001ui.graphics.AndroidColorFilter_androidKt;
import androidx.compose.p001ui.graphics.BlendMode;
import androidx.compose.p001ui.graphics.CanvasHolder;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.ColorFilter;
import androidx.compose.p001ui.graphics.ColorKt;
import androidx.compose.p001ui.graphics.RenderEffect;
import androidx.compose.p001ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawContext;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GraphicsLayerV23.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \u0085\u00012\u00020\u0001:\u0002\u0085\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010e\u001a\u00020f2\u0006\u00100\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\bg\u0010\u001eJ9\u0010h\u001a\u00020f2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020n2\u0017\u0010o\u001a\u0013\u0012\u0004\u0012\u00020q\u0012\u0004\u0012\u00020f0p¢\u0006\u0002\brH\u0016J\b\u0010s\u001a\u00020:H\u0016J\b\u0010t\u001a\u00020fH\u0016J\b\u0010u\u001a\u00020fH\u0002J\u0010\u0010v\u001a\u00020f2\u0006\u0010w\u001a\u00020xH\u0016J\b\u0010y\u001a\u000208H\u0002J\b\u0010z\u001a\u00020#H\u0002J\u0018\u0010{\u001a\u00020f2\u0006\u0010|\u001a\u00020}2\u0006\u0010$\u001a\u00020#H\u0016J%\u0010~\u001a\u00020f2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\u0006\u0010Z\u001a\u00020[H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\t\u0010\u0083\u0001\u001a\u00020fH\u0002J\u0011\u0010\u0084\u0001\u001a\u00020f2\u0006\u0010F\u001a\u00020GH\u0002R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R,\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0012@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R,\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u0019@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020#@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R(\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\u000b\u001a\u0004\u0018\u00010)@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R,\u00100\u001a\u00020/2\u0006\u0010\u000b\u001a\u00020/@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001eR\u001a\u00103\u001a\u00020#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R\u0014\u00105\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0015R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0015R,\u0010=\u001a\u00020<2\u0006\u0010\u000b\u001a\u00020<@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b>\u0010\u0015\"\u0004\b?\u0010\u0017R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u000e\u0010F\u001a\u00020GX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010H\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u000f\"\u0004\bJ\u0010\u0011R$\u0010K\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u000f\"\u0004\bM\u0010\u0011R$\u0010N\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u000f\"\u0004\bP\u0010\u0011R$\u0010Q\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u000f\"\u0004\bS\u0010\u0011R$\u0010T\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u000f\"\u0004\bV\u0010\u0011R$\u0010W\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u000f\"\u0004\bY\u0010\u0011R\u0016\u0010Z\u001a\u00020[X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R,\u0010\\\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0012@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b]\u0010\u0015\"\u0004\b^\u0010\u0017R$\u0010_\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u000f\"\u0004\ba\u0010\u0011R$\u0010b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u000f\"\u0004\bd\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0086\u0001"}, m195d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerV23;", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "ownerView", "Landroid/view/View;", "ownerId", "", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(Landroid/view/View;JLandroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", DownloadUtil.CookieScheme.VALUE, "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "J", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "I", "cameraDistance", "getCameraDistance", "setCameraDistance", "", "clip", "getClip", "()Z", "setClip", "(Z)V", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "isInvalidated", "setInvalidated", "layerId", "getLayerId", "layerPaint", "Landroid/graphics/Paint;", "matrix", "Landroid/graphics/Matrix;", "getOwnerId", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderNode", "Landroid/view/RenderNode;", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "size", "Landroidx/compose/ui/unit/IntSize;", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "applyCompositingStrategy", "", "applyCompositingStrategy-Wpw9cng", "buildLayer", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "calculateMatrix", "discardDisplayList", "discardDisplayListInternal", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "obtainLayerPaint", "requiresCompositingLayer", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "topLeft", "Landroidx/compose/ui/unit/IntOffset;", "setPosition-VbeCjmY", "(JJ)V", "updateLayerProperties", "verifyShadowColorProperties", "Companion", "ui-graphics_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class GraphicsLayerV23 implements GraphicsLayerImpl {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicBoolean needToValidateAccess = new AtomicBoolean(true);
    private static boolean testFailCreateRenderNode;
    private float alpha;
    private long ambientShadowColor;
    private int blendMode;
    private float cameraDistance;
    private final CanvasDrawScope canvasDrawScope;
    private final CanvasHolder canvasHolder;
    private boolean clip;
    private ColorFilter colorFilter;
    private int compositingStrategy;
    private boolean isInvalidated;
    private final long layerId;
    private Paint layerPaint;
    private Matrix matrix;
    private final long ownerId;
    private long pivotOffset;
    private RenderEffect renderEffect;
    private final RenderNode renderNode;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private float shadowElevation;
    private long size;
    private long spotShadowColor;
    private float translationX;
    private float translationY;

    public GraphicsLayerV23(View ownerView, long ownerId, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        this.ownerId = ownerId;
        this.canvasHolder = canvasHolder;
        this.canvasDrawScope = canvasDrawScope;
        this.renderNode = RenderNode.create("Compose", ownerView);
        this.size = IntSize.INSTANCE.m6980getZeroYbymL2g();
        if (needToValidateAccess.getAndSet(false)) {
            this.renderNode.setScaleX(this.renderNode.getScaleX());
            this.renderNode.setScaleY(this.renderNode.getScaleY());
            this.renderNode.setTranslationX(this.renderNode.getTranslationX());
            this.renderNode.setTranslationY(this.renderNode.getTranslationY());
            this.renderNode.setElevation(this.renderNode.getElevation());
            this.renderNode.setRotation(this.renderNode.getRotation());
            this.renderNode.setRotationX(this.renderNode.getRotationX());
            this.renderNode.setRotationY(this.renderNode.getRotationY());
            this.renderNode.setCameraDistance(this.renderNode.getCameraDistance());
            this.renderNode.setPivotX(this.renderNode.getPivotX());
            this.renderNode.setPivotY(this.renderNode.getPivotY());
            this.renderNode.setClipToOutline(this.renderNode.getClipToOutline());
            this.renderNode.setClipToBounds(false);
            this.renderNode.setAlpha(this.renderNode.getAlpha());
            this.renderNode.isValid();
            this.renderNode.setLeftTopRightBottom(0, 0, 0, 0);
            this.renderNode.offsetLeftAndRight(0);
            this.renderNode.offsetTopAndBottom(0);
            verifyShadowColorProperties(this.renderNode);
            discardDisplayListInternal();
            this.renderNode.setLayerType(0);
            this.renderNode.setHasOverlappingRendering(this.renderNode.hasOverlappingRendering());
        }
        if (testFailCreateRenderNode) {
            throw new NoClassDefFoundError();
        }
        this.renderNode.setClipToBounds(false);
        m4976applyCompositingStrategyWpw9cng(CompositingStrategy.INSTANCE.m4940getAutoke2Ky5w());
        this.compositingStrategy = CompositingStrategy.INSTANCE.m4940getAutoke2Ky5w();
        this.blendMode = BlendMode.INSTANCE.m4233getSrcOver0nO6VwU();
        this.alpha = 1.0f;
        this.pivotOffset = Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.ambientShadowColor = Color.INSTANCE.m4317getBlack0d7_KjU();
        this.spotShadowColor = Color.INSTANCE.m4317getBlack0d7_KjU();
        this.cameraDistance = 8.0f;
        this.isInvalidated = true;
    }

    public /* synthetic */ GraphicsLayerV23(View view, long j, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
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
        this(view, j, canvasHolder2, canvasDrawScope2);
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public long getOwnerId() {
        return this.ownerId;
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

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: getCompositingStrategy-ke2Ky5w, reason: from getter */
    public int getCompositingStrategy() {
        return this.compositingStrategy;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setCompositingStrategy-Wpw9cng */
    public void mo4972setCompositingStrategyWpw9cng(int value) {
        this.compositingStrategy = value;
        updateLayerProperties();
    }

    /* JADX INFO: renamed from: applyCompositingStrategy-Wpw9cng, reason: not valid java name */
    private final void m4976applyCompositingStrategyWpw9cng(int compositingStrategy) {
        RenderNode $this$applyCompositingStrategy_Wpw9cng_u24lambda_u241 = this.renderNode;
        if (CompositingStrategy.m4936equalsimpl0(compositingStrategy, CompositingStrategy.INSTANCE.m4942getOffscreenke2Ky5w())) {
            $this$applyCompositingStrategy_Wpw9cng_u24lambda_u241.setLayerType(2);
            $this$applyCompositingStrategy_Wpw9cng_u24lambda_u241.setLayerPaint(this.layerPaint);
            $this$applyCompositingStrategy_Wpw9cng_u24lambda_u241.setHasOverlappingRendering(true);
        } else if (CompositingStrategy.m4936equalsimpl0(compositingStrategy, CompositingStrategy.INSTANCE.m4941getModulateAlphake2Ky5w())) {
            $this$applyCompositingStrategy_Wpw9cng_u24lambda_u241.setLayerType(0);
            $this$applyCompositingStrategy_Wpw9cng_u24lambda_u241.setLayerPaint(this.layerPaint);
            $this$applyCompositingStrategy_Wpw9cng_u24lambda_u241.setHasOverlappingRendering(false);
        } else {
            $this$applyCompositingStrategy_Wpw9cng_u24lambda_u241.setLayerType(0);
            $this$applyCompositingStrategy_Wpw9cng_u24lambda_u241.setLayerPaint(this.layerPaint);
            $this$applyCompositingStrategy_Wpw9cng_u24lambda_u241.setHasOverlappingRendering(true);
        }
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: from getter */
    public int getBlendMode() {
        return this.blendMode;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setBlendMode-s9anfk8 */
    public void mo4971setBlendModes9anfk8(int value) {
        if (!BlendMode.m4202equalsimpl0(this.blendMode, value)) {
            this.blendMode = value;
            Paint $this$setBlendMode_s9anfk8_u24lambda_u242 = obtainLayerPaint();
            $this$setBlendMode_s9anfk8_u24lambda_u242.setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m4142toPorterDuffModes9anfk8(value)));
            updateLayerProperties();
        }
    }

    private final boolean requiresCompositingLayer() {
        return (!CompositingStrategy.m4936equalsimpl0(getCompositingStrategy(), CompositingStrategy.INSTANCE.m4942getOffscreenke2Ky5w()) && BlendMode.m4202equalsimpl0(getBlendMode(), BlendMode.INSTANCE.m4233getSrcOver0nO6VwU()) && getColorFilter() == null) ? false : true;
    }

    private final void updateLayerProperties() {
        if (requiresCompositingLayer()) {
            m4976applyCompositingStrategyWpw9cng(CompositingStrategy.INSTANCE.m4942getOffscreenke2Ky5w());
        } else {
            m4976applyCompositingStrategyWpw9cng(getCompositingStrategy());
        }
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public void setColorFilter(ColorFilter value) {
        this.colorFilter = value;
        if (value != null) {
            m4976applyCompositingStrategyWpw9cng(CompositingStrategy.INSTANCE.m4942getOffscreenke2Ky5w());
            RenderNode renderNode = this.renderNode;
            Paint $this$_set_colorFilter__u24lambda_u243 = obtainLayerPaint();
            $this$_set_colorFilter__u24lambda_u243.setColorFilter(AndroidColorFilter_androidKt.asAndroidColorFilter(value));
            renderNode.setLayerPaint($this$_set_colorFilter__u24lambda_u243);
            return;
        }
        updateLayerProperties();
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public void setAlpha(float value) {
        this.alpha = value;
        this.renderNode.setAlpha(value);
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: getPivotOffset-F1C5BW0, reason: from getter */
    public long getPivotOffset() {
        return this.pivotOffset;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setPivotOffset-k-4lQ0M */
    public void mo4973setPivotOffsetk4lQ0M(long value) {
        this.pivotOffset = value;
        this.renderNode.setPivotX(Offset.m4049getXimpl(value));
        this.renderNode.setPivotY(Offset.m4050getYimpl(value));
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public float getScaleX() {
        return this.scaleX;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public void setScaleX(float value) {
        this.scaleX = value;
        this.renderNode.setScaleX(value);
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public float getScaleY() {
        return this.scaleY;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public void setScaleY(float value) {
        this.scaleY = value;
        this.renderNode.setScaleY(value);
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public float getTranslationX() {
        return this.translationX;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationX(float value) {
        this.translationX = value;
        this.renderNode.setTranslationX(value);
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public float getTranslationY() {
        return this.translationY;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationY(float value) {
        this.translationY = value;
        this.renderNode.setTranslationY(value);
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public float getShadowElevation() {
        return this.shadowElevation;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public void setShadowElevation(float value) {
        this.shadowElevation = value;
        this.renderNode.setElevation(value);
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: getAmbientShadowColor-0d7_KjU, reason: from getter */
    public long getAmbientShadowColor() {
        return this.ambientShadowColor;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA */
    public void mo4970setAmbientShadowColor8_81llA(long value) {
        this.ambientShadowColor = value;
        this.renderNode.setAmbientShadowColor(ColorKt.m4345toArgb8_81llA(value));
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: getSpotShadowColor-0d7_KjU, reason: from getter */
    public long getSpotShadowColor() {
        return this.spotShadowColor;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setSpotShadowColor-8_81llA */
    public void mo4975setSpotShadowColor8_81llA(long value) {
        this.spotShadowColor = value;
        this.renderNode.setSpotShadowColor(ColorKt.m4345toArgb8_81llA(value));
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public float getRotationX() {
        return this.rotationX;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public void setRotationX(float value) {
        this.rotationX = value;
        this.renderNode.setRotationX(value);
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public float getRotationY() {
        return this.rotationY;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public void setRotationY(float value) {
        this.rotationY = value;
        this.renderNode.setRotationY(value);
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public float getRotationZ() {
        return this.rotationZ;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public void setRotationZ(float value) {
        this.rotationZ = value;
        this.renderNode.setRotation(value);
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public float getCameraDistance() {
        return this.cameraDistance;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public void setCameraDistance(float value) {
        this.cameraDistance = value;
        this.renderNode.setCameraDistance(-value);
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public boolean getClip() {
        return this.clip;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public void setClip(boolean value) {
        this.clip = value;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public void setRenderEffect(RenderEffect renderEffect) {
        this.renderEffect = renderEffect;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: setPosition-VbeCjmY */
    public void mo4974setPositionVbeCjmY(long topLeft, long size) {
        this.renderNode.setLeftTopRightBottom(IntOffset.m6933getXimpl(topLeft), IntOffset.m6934getYimpl(topLeft), IntOffset.m6933getXimpl(topLeft) + IntSize.m6975getWidthimpl(size), IntOffset.m6934getYimpl(topLeft) + IntSize.m6974getHeightimpl(size));
        this.size = size;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public void setOutline(Outline outline, boolean clip) {
        this.renderNode.setOutline(outline);
        this.renderNode.setClipToOutline(clip);
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    /* JADX INFO: renamed from: isInvalidated, reason: from getter */
    public boolean getIsInvalidated() {
        return this.isInvalidated;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public void setInvalidated(boolean z) {
        this.isInvalidated = z;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public void buildLayer(Density density, LayoutDirection layoutDirection, GraphicsLayer layer, Function1<? super DrawScope, Unit> block) {
        Canvas canvasStart = this.renderNode.start(IntSize.m6975getWidthimpl(this.size), IntSize.m6974getHeightimpl(this.size));
        CanvasHolder this_$iv = this.canvasHolder;
        Canvas previousCanvas$iv = this_$iv.getAndroidCanvas().getInternalCanvas();
        this_$iv.getAndroidCanvas().setInternalCanvas(canvasStart);
        androidx.compose.p001ui.graphics.Canvas $this$buildLayer_u24lambda_u244 = this_$iv.getAndroidCanvas();
        DrawScope $this$draw_u2dymL40Pk$iv = this.canvasDrawScope;
        long size$iv = IntSizeKt.m6987toSizeozmzZPI(this.size);
        Density prevDensity$iv = $this$draw_u2dymL40Pk$iv.getDrawContext().getDensity();
        LayoutDirection prevLayoutDirection$iv = $this$draw_u2dymL40Pk$iv.getDrawContext().getLayoutDirection();
        androidx.compose.p001ui.graphics.Canvas prevCanvas$iv = $this$draw_u2dymL40Pk$iv.getDrawContext().getCanvas();
        long prevSize$iv = $this$draw_u2dymL40Pk$iv.getDrawContext().mo4779getSizeNHjbRc();
        GraphicsLayer prevLayer$iv = $this$draw_u2dymL40Pk$iv.getDrawContext().getGraphicsLayer();
        DrawContext $this$draw_ymL40Pk_u24lambda_u247$iv = $this$draw_u2dymL40Pk$iv.getDrawContext();
        $this$draw_ymL40Pk_u24lambda_u247$iv.setDensity(density);
        $this$draw_ymL40Pk_u24lambda_u247$iv.setLayoutDirection(layoutDirection);
        $this$draw_ymL40Pk_u24lambda_u247$iv.setCanvas($this$buildLayer_u24lambda_u244);
        $this$draw_ymL40Pk_u24lambda_u247$iv.mo4780setSizeuvyYCjk(size$iv);
        $this$draw_ymL40Pk_u24lambda_u247$iv.setGraphicsLayer(layer);
        $this$buildLayer_u24lambda_u244.save();
        try {
            block.invoke($this$draw_u2dymL40Pk$iv);
            $this$buildLayer_u24lambda_u244.restore();
            DrawContext $this$draw_ymL40Pk_u24lambda_u248$iv = $this$draw_u2dymL40Pk$iv.getDrawContext();
            $this$draw_ymL40Pk_u24lambda_u248$iv.setDensity(prevDensity$iv);
            $this$draw_ymL40Pk_u24lambda_u248$iv.setLayoutDirection(prevLayoutDirection$iv);
            $this$draw_ymL40Pk_u24lambda_u248$iv.setCanvas(prevCanvas$iv);
            $this$draw_ymL40Pk_u24lambda_u248$iv.mo4780setSizeuvyYCjk(prevSize$iv);
            $this$draw_ymL40Pk_u24lambda_u248$iv.setGraphicsLayer(prevLayer$iv);
            this_$iv.getAndroidCanvas().setInternalCanvas(previousCanvas$iv);
            this.renderNode.end(canvasStart);
            setInvalidated(false);
        } catch (Throwable th) {
            $this$buildLayer_u24lambda_u244.restore();
            DrawContext $this$draw_ymL40Pk_u24lambda_u248$iv2 = $this$draw_u2dymL40Pk$iv.getDrawContext();
            $this$draw_ymL40Pk_u24lambda_u248$iv2.setDensity(prevDensity$iv);
            $this$draw_ymL40Pk_u24lambda_u248$iv2.setLayoutDirection(prevLayoutDirection$iv);
            $this$draw_ymL40Pk_u24lambda_u248$iv2.setCanvas(prevCanvas$iv);
            $this$draw_ymL40Pk_u24lambda_u248$iv2.mo4780setSizeuvyYCjk(prevSize$iv);
            $this$draw_ymL40Pk_u24lambda_u248$iv2.setGraphicsLayer(prevLayer$iv);
            throw th;
        }
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public void draw(androidx.compose.p001ui.graphics.Canvas canvas) {
        DisplayListCanvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        Intrinsics.checkNotNull(nativeCanvas, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        nativeCanvas.drawRenderNode(this.renderNode);
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public Matrix calculateMatrix() {
        Matrix it = this.matrix;
        if (it == null) {
            it = new Matrix();
            this.matrix = it;
        }
        this.renderNode.getMatrix(it);
        return it;
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public void discardDisplayList() {
        discardDisplayListInternal();
    }

    @Override // androidx.compose.p001ui.graphics.layer.GraphicsLayerImpl
    public long getLayerId() {
        return this.layerId;
    }

    private final void verifyShadowColorProperties(RenderNode renderNode) {
        if (Build.VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(renderNode, RenderNodeVerificationHelper28.INSTANCE.getAmbientShadowColor(renderNode));
            RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(renderNode, RenderNodeVerificationHelper28.INSTANCE.getSpotShadowColor(renderNode));
        }
    }

    private final void discardDisplayListInternal() {
        if (Build.VERSION.SDK_INT >= 24) {
            RenderNodeVerificationHelper24.INSTANCE.discardDisplayList(this.renderNode);
        } else {
            RenderNodeVerificationHelper23.INSTANCE.destroyDisplayListData(this.renderNode);
        }
    }

    /* JADX INFO: compiled from: GraphicsLayerV23.android.kt */
    @Metadata(m194d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, m195d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerV23$Companion;", "", "()V", "needToValidateAccess", "Ljava/util/concurrent/atomic/AtomicBoolean;", "testFailCreateRenderNode", "", "getTestFailCreateRenderNode$ui_graphics_release", "()Z", "setTestFailCreateRenderNode$ui_graphics_release", "(Z)V", "ui-graphics_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getTestFailCreateRenderNode$ui_graphics_release() {
            return GraphicsLayerV23.testFailCreateRenderNode;
        }

        public final void setTestFailCreateRenderNode$ui_graphics_release(boolean z) {
            GraphicsLayerV23.testFailCreateRenderNode = z;
        }
    }
}
