package androidx.compose.p001ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import androidx.compose.p001ui.graphics.Canvas;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.ColorFilter;
import androidx.compose.p001ui.graphics.RenderEffect;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okhttp3.internal.p009ws.WebSocketProtocol;

/* JADX INFO: compiled from: AndroidGraphicsLayer.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u0000 o2\u00020\u0001:\u0001oJ9\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020Z2\u0017\u0010[\u001a\u0013\u0012\u0004\u0012\u00020]\u0012\u0004\u0012\u00020T0\\¢\u0006\u0002\b^H&J\b\u0010_\u001a\u00020`H&J\b\u0010a\u001a\u00020TH&J\u0010\u0010b\u001a\u00020T2\u0006\u0010c\u001a\u00020dH&J\u0018\u0010e\u001a\u00020T2\u0006\u0010f\u001a\u00020g2\u0006\u0010\u0017\u001a\u00020\u0018H&J\"\u0010h\u001a\u00020T2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020lH&ø\u0001\u0000¢\u0006\u0004\bm\u0010nR\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\tX¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000fX¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007R\u0018\u0010\u0017\u001a\u00020\u0018X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001eX¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013R\u0018\u0010'\u001a\u00020\u0018X¦\u000e¢\u0006\f\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u0012\u0010)\u001a\u00020*X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u000bR\u0012\u0010,\u001a\u00020*X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u000bR\u001e\u0010.\u001a\u00020/X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b0\u0010\u000b\"\u0004\b1\u0010\rR\u001a\u00102\u001a\u0004\u0018\u000103X¦\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0018\u00108\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b9\u0010\u0005\"\u0004\b:\u0010\u0007R\u0018\u0010;\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b<\u0010\u0005\"\u0004\b=\u0010\u0007R\u0018\u0010>\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b?\u0010\u0005\"\u0004\b@\u0010\u0007R\u0018\u0010A\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bB\u0010\u0005\"\u0004\bC\u0010\u0007R\u0018\u0010D\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bE\u0010\u0005\"\u0004\bF\u0010\u0007R\u0018\u0010G\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bH\u0010\u0005\"\u0004\bI\u0010\u0007R\u001e\u0010J\u001a\u00020\tX¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bK\u0010\u000b\"\u0004\bL\u0010\rR\u0018\u0010M\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bN\u0010\u0005\"\u0004\bO\u0010\u0007R\u0018\u0010P\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bQ\u0010\u0005\"\u0004\bR\u0010\u0007ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006pÀ\u0006\u0001"}, m195d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "", "getClip", "()Z", "setClip", "(Z)V", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "compositingStrategy", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "isInvalidated", "setInvalidated", "layerId", "", "getLayerId", "ownerId", "getOwnerId", "pivotOffset", "Landroidx/compose/ui/geometry/Offset;", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "buildLayer", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "calculateMatrix", "Landroid/graphics/Matrix;", "discardDisplayList", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "topLeft", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "setPosition-VbeCjmY", "(JJ)V", "Companion", "ui-graphics_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface GraphicsLayerImpl {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void buildLayer(Density density, LayoutDirection layoutDirection, GraphicsLayer layer, Function1<? super DrawScope, Unit> block);

    Matrix calculateMatrix();

    void discardDisplayList();

    void draw(Canvas canvas);

    float getAlpha();

    /* JADX INFO: renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    long getAmbientShadowColor();

    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    int getBlendMode();

    float getCameraDistance();

    boolean getClip();

    ColorFilter getColorFilter();

    /* JADX INFO: renamed from: getCompositingStrategy-ke2Ky5w, reason: not valid java name */
    int getCompositingStrategy();

    long getLayerId();

    long getOwnerId();

    /* JADX INFO: renamed from: getPivotOffset-F1C5BW0, reason: not valid java name */
    long getPivotOffset();

    RenderEffect getRenderEffect();

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    float getScaleX();

    float getScaleY();

    float getShadowElevation();

    /* JADX INFO: renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    long getSpotShadowColor();

    float getTranslationX();

    float getTranslationY();

    /* JADX INFO: renamed from: isInvalidated */
    boolean getIsInvalidated();

    void setAlpha(float f);

    /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    void mo4970setAmbientShadowColor8_81llA(long j);

    /* JADX INFO: renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    void mo4971setBlendModes9anfk8(int i);

    void setCameraDistance(float f);

    void setClip(boolean z);

    void setColorFilter(ColorFilter colorFilter);

    /* JADX INFO: renamed from: setCompositingStrategy-Wpw9cng, reason: not valid java name */
    void mo4972setCompositingStrategyWpw9cng(int i);

    void setInvalidated(boolean z);

    void setOutline(Outline outline, boolean clip);

    /* JADX INFO: renamed from: setPivotOffset-k-4lQ0M, reason: not valid java name */
    void mo4973setPivotOffsetk4lQ0M(long j);

    /* JADX INFO: renamed from: setPosition-VbeCjmY, reason: not valid java name */
    void mo4974setPositionVbeCjmY(long topLeft, long size);

    void setRenderEffect(RenderEffect renderEffect);

    void setRotationX(float f);

    void setRotationY(float f);

    void setRotationZ(float f);

    void setScaleX(float f);

    void setScaleY(float f);

    void setShadowElevation(float f);

    /* JADX INFO: renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    void mo4975setSpotShadowColor8_81llA(long j);

    void setTranslationX(float f);

    void setTranslationY(float f);

    /* JADX INFO: compiled from: AndroidGraphicsLayer.android.kt */
    @Metadata(m194d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m195d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl$Companion;", "", "()V", "DefaultDrawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "getDefaultDrawBlock", "()Lkotlin/jvm/functions/Function1;", "ui-graphics_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Function1<DrawScope, Unit> DefaultDrawBlock = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayerImpl$Companion$DefaultDrawBlock$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope $this$null) {
                DrawScope.CC.m4858drawRectnJ9OG0$default($this$null, Color.INSTANCE.m4326getTransparent0d7_KjU(), 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
            }
        };

        private Companion() {
        }

        public final Function1<DrawScope, Unit> getDefaultDrawBlock() {
            return DefaultDrawBlock;
        }
    }
}
