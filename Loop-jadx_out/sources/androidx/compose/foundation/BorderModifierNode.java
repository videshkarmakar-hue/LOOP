package androidx.compose.foundation;

import androidx.compose.p001ui.draw.CacheDrawModifierNode;
import androidx.compose.p001ui.draw.CacheDrawScope;
import androidx.compose.p001ui.draw.DrawModifierKt;
import androidx.compose.p001ui.draw.DrawResult;
import androidx.compose.p001ui.geometry.CornerRadius;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.geometry.RoundRectKt;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.geometry.SizeKt;
import androidx.compose.p001ui.graphics.BlendMode;
import androidx.compose.p001ui.graphics.Brush;
import androidx.compose.p001ui.graphics.Canvas;
import androidx.compose.p001ui.graphics.ClipOp;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.ColorFilter;
import androidx.compose.p001ui.graphics.ImageBitmap;
import androidx.compose.p001ui.graphics.ImageBitmapConfig;
import androidx.compose.p001ui.graphics.ImageBitmapKt;
import androidx.compose.p001ui.graphics.Outline;
import androidx.compose.p001ui.graphics.Path;
import androidx.compose.p001ui.graphics.PathOperation;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.graphics.SolidColor;
import androidx.compose.p001ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.p001ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawContext;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawTransform;
import androidx.compose.p001ui.graphics.drawscope.Stroke;
import androidx.compose.p001ui.node.DelegatingNode;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: Border.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ,\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002JF\u0010'\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010.R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R,\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006/"}, m195d2 = {"Landroidx/compose/foundation/BorderModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "widthParameter", "Landroidx/compose/ui/unit/Dp;", "brushParameter", "Landroidx/compose/ui/graphics/Brush;", "shapeParameter", "Landroidx/compose/ui/graphics/Shape;", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "borderCache", "Landroidx/compose/foundation/BorderCache;", DownloadUtil.CookieScheme.VALUE, "brush", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "width", "getWidth-D9Ej5fM", "()F", "setWidth-0680j_4", "(F)V", "F", "drawGenericBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "fillArea", "", "strokeWidth", "", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "drawRoundRectBorder-JqoCqck", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BorderModifierNode extends DelegatingNode {
    public static final int $stable = 8;
    private BorderCache borderCache;
    private Brush brush;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private Shape shape;
    private float width;

    public /* synthetic */ BorderModifierNode(float f, Brush brush, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, brush, shape);
    }

    private BorderModifierNode(float widthParameter, Brush brushParameter, Shape shapeParameter) {
        this.width = widthParameter;
        this.brush = brushParameter;
        this.shape = shapeParameter;
        this.drawWithCacheModifierNode = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.BorderModifierNode$drawWithCacheModifierNode$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DrawResult invoke(CacheDrawScope $this$CacheDrawModifierNode) {
                boolean hasValidBorderParams = $this$CacheDrawModifierNode.mo567toPx0680j_4(this.this$0.getWidth()) >= 0.0f && Size.m4117getMinDimensionimpl($this$CacheDrawModifierNode.m3940getSizeNHjbRc()) > 0.0f;
                if (!hasValidBorderParams) {
                    return BorderKt.drawContentWithoutBorder($this$CacheDrawModifierNode);
                }
                float f = 2;
                float strokeWidthPx = Math.min(C1979Dp.m6806equalsimpl0(this.this$0.getWidth(), C1979Dp.INSTANCE.m6819getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil($this$CacheDrawModifierNode.mo567toPx0680j_4(this.this$0.getWidth())), (float) Math.ceil(Size.m4117getMinDimensionimpl($this$CacheDrawModifierNode.m3940getSizeNHjbRc()) / f));
                float halfStroke = strokeWidthPx / f;
                long topLeft = OffsetKt.Offset(halfStroke, halfStroke);
                long borderSize = SizeKt.Size(Size.m4118getWidthimpl($this$CacheDrawModifierNode.m3940getSizeNHjbRc()) - strokeWidthPx, Size.m4115getHeightimpl($this$CacheDrawModifierNode.m3940getSizeNHjbRc()) - strokeWidthPx);
                boolean fillArea = f * strokeWidthPx > Size.m4117getMinDimensionimpl($this$CacheDrawModifierNode.m3940getSizeNHjbRc());
                Outline outline = this.this$0.getShape().mo502createOutlinePq9zytI($this$CacheDrawModifierNode.m3940getSizeNHjbRc(), $this$CacheDrawModifierNode.getLayoutDirection(), $this$CacheDrawModifierNode);
                if (outline instanceof Outline.Generic) {
                    return this.this$0.drawGenericBorder($this$CacheDrawModifierNode, this.this$0.getBrush(), (Outline.Generic) outline, fillArea, strokeWidthPx);
                }
                if (outline instanceof Outline.Rounded) {
                    return this.this$0.m471drawRoundRectBorderJqoCqck($this$CacheDrawModifierNode, this.this$0.getBrush(), (Outline.Rounded) outline, topLeft, borderSize, fillArea, strokeWidthPx);
                }
                if (outline instanceof Outline.Rectangle) {
                    return BorderKt.m468drawRectBorderNsqcLGU($this$CacheDrawModifierNode, this.this$0.getBrush(), topLeft, borderSize, fillArea, strokeWidthPx);
                }
                throw new NoWhenBranchMatchedException();
            }
        }));
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: setWidth-0680j_4, reason: not valid java name */
    public final void m473setWidth0680j_4(float value) {
        if (!C1979Dp.m6806equalsimpl0(this.width, value)) {
            this.width = value;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final void setBrush(Brush value) {
        if (!Intrinsics.areEqual(this.brush, value)) {
            this.brush = value;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final void setShape(Shape value) {
        if (!Intrinsics.areEqual(this.shape, value)) {
            this.shape = value;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x00eb  */
    /* JADX WARN: Type inference failed for: r19v1, types: [T, androidx.compose.ui.graphics.ImageBitmap] */
    public final DrawResult drawGenericBorder(CacheDrawScope $this$drawGenericBorder, final Brush brush, final Outline.Generic outline, boolean fillArea, float strokeWidth) throws Throwable {
        int config;
        ColorFilter colorFilter;
        boolean z;
        BorderCache this_$iv;
        ImageBitmap targetImageBitmap$iv;
        Canvas targetCanvas$iv;
        float left$iv;
        float scaleY$iv;
        if (fillArea) {
            return $this$drawGenericBorder.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode.drawGenericBorder.1
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
                    $this$onDrawWithContent.drawContent();
                    DrawScope.CC.m4853drawPathGBMwjPU$default($this$onDrawWithContent, outline.getPath(), brush, 0.0f, null, null, 0, 60, null);
                }
            });
        }
        if (brush instanceof SolidColor) {
            int config2 = ImageBitmapConfig.INSTANCE.m4518getAlpha8_sVssgQ();
            ColorFilter colorFilter2 = ColorFilter.Companion.m4332tintxETnrds$default(ColorFilter.INSTANCE, ((SolidColor) brush).getValue(), 0, 2, null);
            config = config2;
            colorFilter = colorFilter2;
        } else {
            int config3 = ImageBitmapConfig.INSTANCE.m4519getArgb8888_sVssgQ();
            config = config3;
            colorFilter = null;
        }
        final Rect pathBounds = outline.getPath().getBounds();
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.borderCache;
        Intrinsics.checkNotNull(borderCache);
        Path maskPath = borderCache.obtainPath();
        maskPath.reset();
        Path.CC.addRect$default(maskPath, pathBounds, null, 2, null);
        maskPath.mo4183opN5in7k0(maskPath, outline.getPath(), PathOperation.INSTANCE.m4591getDifferenceb3I0S0c());
        final Ref.ObjectRef cacheImageBitmap = new Ref.ObjectRef();
        final long pathBoundsSize = IntSizeKt.IntSize((int) Math.ceil(pathBounds.getWidth()), (int) Math.ceil(pathBounds.getHeight()));
        BorderCache $this$drawGenericBorder_u24lambda_u244 = this.borderCache;
        Intrinsics.checkNotNull($this$drawGenericBorder_u24lambda_u244);
        ImageBitmap targetImageBitmap$iv2 = $this$drawGenericBorder_u24lambda_u244.imageBitmap;
        Canvas targetCanvas$iv2 = $this$drawGenericBorder_u24lambda_u244.canvas;
        ImageBitmapConfig imageBitmapConfigM4511boximpl = targetImageBitmap$iv2 != null ? ImageBitmapConfig.m4511boximpl(targetImageBitmap$iv2.mo4158getConfig_sVssgQ()) : null;
        if (!(imageBitmapConfigM4511boximpl == null ? false : ImageBitmapConfig.m4514equalsimpl0(imageBitmapConfigM4511boximpl.m4517unboximpl(), ImageBitmapConfig.INSTANCE.m4519getArgb8888_sVssgQ()))) {
            z = ImageBitmapConfig.m4513equalsimpl(config, targetImageBitmap$iv2 != null ? ImageBitmapConfig.m4511boximpl(targetImageBitmap$iv2.mo4158getConfig_sVssgQ()) : null);
        }
        boolean compatibleConfig$iv = z;
        if (targetImageBitmap$iv2 == null || targetCanvas$iv2 == null || Size.m4118getWidthimpl($this$drawGenericBorder.m3940getSizeNHjbRc()) > targetImageBitmap$iv2.getWidth() || Size.m4115getHeightimpl($this$drawGenericBorder.m3940getSizeNHjbRc()) > targetImageBitmap$iv2.getHeight() || !compatibleConfig$iv) {
            this_$iv = $this$drawGenericBorder_u24lambda_u244;
            ImageBitmap targetImageBitmap$iv3 = ImageBitmapKt.m4524ImageBitmapx__hDU$default(IntSize.m6975getWidthimpl(pathBoundsSize), IntSize.m6974getHeightimpl(pathBoundsSize), config, false, null, 24, null);
            this_$iv.imageBitmap = targetImageBitmap$iv3;
            Canvas it$iv = androidx.compose.p001ui.graphics.CanvasKt.Canvas(targetImageBitmap$iv3);
            this_$iv.canvas = it$iv;
            targetImageBitmap$iv = targetImageBitmap$iv3;
            targetCanvas$iv = it$iv;
        } else {
            targetImageBitmap$iv = targetImageBitmap$iv2;
            this_$iv = $this$drawGenericBorder_u24lambda_u244;
            targetCanvas$iv = targetCanvas$iv2;
        }
        CanvasDrawScope it$iv2 = this_$iv.canvasDrawScope;
        if (it$iv2 == null) {
            it$iv2 = new CanvasDrawScope();
            this_$iv.canvasDrawScope = it$iv2;
        }
        CanvasDrawScope targetDrawScope$iv = it$iv2;
        long drawSize$iv = IntSizeKt.m6987toSizeozmzZPI(pathBoundsSize);
        LayoutDirection layoutDirection$iv$iv = $this$drawGenericBorder.getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams = targetDrawScope$iv.getDrawParams();
        Density prevDensity$iv$iv = drawParams.getDensity();
        LayoutDirection prevLayoutDirection$iv$iv = drawParams.getLayoutDirection();
        Canvas prevCanvas$iv$iv = drawParams.getCanvas();
        ?? r19 = targetImageBitmap$iv;
        long prevSize$iv$iv = drawParams.getSize();
        CanvasDrawScope.DrawParams $this$draw_yzxVdVo_u24lambda_u240$iv$iv = targetDrawScope$iv.getDrawParams();
        $this$draw_yzxVdVo_u24lambda_u240$iv$iv.setDensity($this$drawGenericBorder);
        $this$draw_yzxVdVo_u24lambda_u240$iv$iv.setLayoutDirection(layoutDirection$iv$iv);
        $this$draw_yzxVdVo_u24lambda_u240$iv$iv.setCanvas(targetCanvas$iv);
        $this$draw_yzxVdVo_u24lambda_u240$iv$iv.m4778setSizeuvyYCjk(drawSize$iv);
        targetCanvas$iv.save();
        CanvasDrawScope $this$drawBorderCache_EMwLDEs_u24lambda_u243$iv = targetDrawScope$iv;
        DrawScope.CC.m4858drawRectnJ9OG0$default($this$drawBorderCache_EMwLDEs_u24lambda_u243$iv, Color.INSTANCE.m4317getBlack0d7_KjU(), 0L, drawSize$iv, 0.0f, null, null, BlendMode.INSTANCE.m4206getClear0nO6VwU(), 58, null);
        float left$iv2 = -pathBounds.getLeft();
        float top$iv = -pathBounds.getTop();
        $this$drawBorderCache_EMwLDEs_u24lambda_u243$iv.getDrawContext().getTransform().translate(left$iv2, top$iv);
        try {
            left$iv = left$iv2;
            Canvas targetCanvas$iv3 = targetCanvas$iv;
            try {
                DrawScope.CC.m4853drawPathGBMwjPU$default($this$drawBorderCache_EMwLDEs_u24lambda_u243$iv, outline.getPath(), brush, 0.0f, new Stroke(strokeWidth * 2, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
                float f = 1;
                float scaleX$iv = (Size.m4118getWidthimpl($this$drawBorderCache_EMwLDEs_u24lambda_u243$iv.mo4773getSizeNHjbRc()) + f) / Size.m4118getWidthimpl($this$drawBorderCache_EMwLDEs_u24lambda_u243$iv.mo4773getSizeNHjbRc());
                float scaleY$iv2 = (Size.m4115getHeightimpl($this$drawBorderCache_EMwLDEs_u24lambda_u243$iv.mo4773getSizeNHjbRc()) + f) / Size.m4115getHeightimpl($this$drawBorderCache_EMwLDEs_u24lambda_u243$iv.mo4773getSizeNHjbRc());
                long pivot$iv = $this$drawBorderCache_EMwLDEs_u24lambda_u243$iv.mo4772getCenterF1C5BW0();
                DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$drawBorderCache_EMwLDEs_u24lambda_u243$iv.getDrawContext();
                long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.mo4779getSizeNHjbRc();
                $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
                try {
                    DrawTransform $this$scale_Fgt4K4Q_u24lambda_u242$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
                    $this$scale_Fgt4K4Q_u24lambda_u242$iv.mo4786scale0AR0LA0(scaleX$iv, scaleY$iv2, pivot$iv);
                    try {
                        scaleY$iv = top$iv;
                        try {
                            DrawScope.CC.m4853drawPathGBMwjPU$default($this$drawBorderCache_EMwLDEs_u24lambda_u243$iv, maskPath, brush, 0.0f, null, null, BlendMode.INSTANCE.m4206getClear0nO6VwU(), 28, null);
                            try {
                                $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                                $this$withTransform_u24lambda_u246$iv$iv.mo4780setSizeuvyYCjk(previousSize$iv$iv);
                                $this$drawBorderCache_EMwLDEs_u24lambda_u243$iv.getDrawContext().getTransform().translate(-left$iv, -scaleY$iv);
                                targetCanvas$iv3.restore();
                                CanvasDrawScope.DrawParams $this$draw_yzxVdVo_u24lambda_u241$iv$iv = targetDrawScope$iv.getDrawParams();
                                $this$draw_yzxVdVo_u24lambda_u241$iv$iv.setDensity(prevDensity$iv$iv);
                                $this$draw_yzxVdVo_u24lambda_u241$iv$iv.setLayoutDirection(prevLayoutDirection$iv$iv);
                                $this$draw_yzxVdVo_u24lambda_u241$iv$iv.setCanvas(prevCanvas$iv$iv);
                                $this$draw_yzxVdVo_u24lambda_u241$iv$iv.m4778setSizeuvyYCjk(prevSize$iv$iv);
                                r19.prepareToDraw();
                                cacheImageBitmap.element = r19;
                                final ColorFilter colorFilter3 = colorFilter;
                                return $this$drawGenericBorder.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode.drawGenericBorder.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) throws Throwable {
                                        invoke2(contentDrawScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(ContentDrawScope $this$onDrawWithContent) throws Throwable {
                                        float top$iv2;
                                        float left$iv3;
                                        $this$onDrawWithContent.drawContent();
                                        ContentDrawScope $this$translate$iv = $this$onDrawWithContent;
                                        float left$iv4 = pathBounds.getLeft();
                                        float top$iv3 = pathBounds.getTop();
                                        Ref.ObjectRef<ImageBitmap> objectRef = cacheImageBitmap;
                                        long j = pathBoundsSize;
                                        ColorFilter colorFilter4 = colorFilter3;
                                        $this$translate$iv.getDrawContext().getTransform().translate(left$iv4, top$iv3);
                                        try {
                                            left$iv3 = left$iv4;
                                            try {
                                                DrawScope.CC.m4847drawImageAZ2fEMs$default($this$translate$iv, objectRef.element, 0L, j, 0L, 0L, 0.0f, null, colorFilter4, 0, 0, 890, null);
                                                $this$translate$iv.getDrawContext().getTransform().translate(-left$iv3, -top$iv3);
                                            } catch (Throwable th) {
                                                th = th;
                                                top$iv2 = top$iv3;
                                                $this$translate$iv.getDrawContext().getTransform().translate(-left$iv3, -top$iv2);
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            top$iv2 = top$iv3;
                                            left$iv3 = left$iv4;
                                        }
                                    }
                                });
                            } catch (Throwable th) {
                                th = th;
                                left$iv = left$iv;
                                $this$drawBorderCache_EMwLDEs_u24lambda_u243$iv.getDrawContext().getTransform().translate(-left$iv, -scaleY$iv);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                r29.getCanvas().restore();
                                $this$withTransform_u24lambda_u246$iv$iv.mo4780setSizeuvyYCjk(previousSize$iv$iv);
                                throw th;
                            } catch (Throwable th3) {
                                th = th3;
                                $this$drawBorderCache_EMwLDEs_u24lambda_u243$iv.getDrawContext().getTransform().translate(-left$iv, -scaleY$iv);
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        scaleY$iv = top$iv;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    scaleY$iv = top$iv;
                }
            } catch (Throwable th6) {
                th = th6;
                scaleY$iv = top$iv;
                left$iv = left$iv;
            }
        } catch (Throwable th7) {
            th = th7;
            left$iv = left$iv2;
            scaleY$iv = top$iv;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawRoundRectBorder-JqoCqck, reason: not valid java name */
    public final DrawResult m471drawRoundRectBorderJqoCqck(CacheDrawScope $this$drawRoundRectBorder_u2dJqoCqck, final Brush brush, Outline.Rounded outline, final long topLeft, final long borderSize, final boolean fillArea, final float strokeWidth) {
        if (RoundRectKt.isSimple(outline.getRoundRect())) {
            final long cornerRadius = outline.getRoundRect().m4099getTopLeftCornerRadiuskKHJgLs();
            final float halfStroke = strokeWidth / 2;
            final Stroke borderStroke = new Stroke(strokeWidth, 0.0f, 0, 0, null, 30, null);
            return $this$drawRoundRectBorder_u2dJqoCqck.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) throws Throwable {
                    invoke2(contentDrawScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ContentDrawScope $this$onDrawWithContent) throws Throwable {
                    long previousSize$iv$iv;
                    DrawContext $this$withTransform_u24lambda_u246$iv$iv;
                    $this$onDrawWithContent.drawContent();
                    if (fillArea) {
                        DrawScope.CC.m4859drawRoundRectZuiqVtQ$default($this$onDrawWithContent, brush, 0L, 0L, cornerRadius, 0.0f, null, null, 0, 246, null);
                        return;
                    }
                    if (CornerRadius.m4024getXimpl(cornerRadius) < halfStroke) {
                        ContentDrawScope $this$clipRect_u2drOu3jXo$iv = $this$onDrawWithContent;
                        float left$iv = strokeWidth;
                        float top$iv = strokeWidth;
                        float right$iv = Size.m4118getWidthimpl($this$onDrawWithContent.mo4773getSizeNHjbRc()) - strokeWidth;
                        float bottom$iv = Size.m4115getHeightimpl($this$onDrawWithContent.mo4773getSizeNHjbRc()) - strokeWidth;
                        int clipOp$iv = ClipOp.INSTANCE.m4279getDifferencertfAjoo();
                        Brush brush2 = brush;
                        long j = cornerRadius;
                        DrawContext $this$withTransform_u24lambda_u246$iv$iv2 = $this$clipRect_u2drOu3jXo$iv.getDrawContext();
                        long previousSize$iv$iv2 = $this$withTransform_u24lambda_u246$iv$iv2.mo4779getSizeNHjbRc();
                        $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().save();
                        try {
                            DrawTransform $this$clipRect_rOu3jXo_u24lambda_u244$iv = $this$withTransform_u24lambda_u246$iv$iv2.getTransform();
                            $this$clipRect_rOu3jXo_u24lambda_u244$iv.mo4782clipRectN_I0leg(left$iv, top$iv, right$iv, bottom$iv, clipOp$iv);
                            try {
                                DrawScope.CC.m4859drawRoundRectZuiqVtQ$default($this$clipRect_u2drOu3jXo$iv, brush2, 0L, 0L, j, 0.0f, null, null, 0, 246, null);
                                $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().restore();
                                $this$withTransform_u24lambda_u246$iv$iv2.mo4780setSizeuvyYCjk(previousSize$iv$iv2);
                            } catch (Throwable th) {
                                th = th;
                                previousSize$iv$iv = previousSize$iv$iv2;
                                $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
                                $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                                $this$withTransform_u24lambda_u246$iv$iv.mo4780setSizeuvyYCjk(previousSize$iv$iv);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            previousSize$iv$iv = previousSize$iv$iv2;
                            $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
                        }
                    } else {
                        DrawScope.CC.m4859drawRoundRectZuiqVtQ$default($this$onDrawWithContent, brush, topLeft, borderSize, BorderKt.m469shrinkKibmq7A(cornerRadius, halfStroke), 0.0f, borderStroke, null, 0, HttpStatusCodesKt.HTTP_ALREADY_REPORTED, null);
                    }
                }
            });
        }
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.borderCache;
        Intrinsics.checkNotNull(borderCache);
        Path path = borderCache.obtainPath();
        final Path roundedRectPath = BorderKt.createRoundRectPath(path, outline.getRoundRect(), strokeWidth, fillArea);
        return $this$drawRoundRectBorder_u2dJqoCqck.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$2
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
                $this$onDrawWithContent.drawContent();
                DrawScope.CC.m4853drawPathGBMwjPU$default($this$onDrawWithContent, roundedRectPath, brush, 0.0f, null, null, 0, 60, null);
            }
        });
    }
}
