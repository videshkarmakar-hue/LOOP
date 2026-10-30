package androidx.compose.p001ui.graphics;

import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.layout.PlacementScopeMarker;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.DpRect;
import androidx.compose.p001ui.unit.FontScaling;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: GraphicsLayerScope.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R \u0010\u0011\u001a\u00020\u00128fX¦\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001f\u001a\u0004\u0018\u00010 8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010&\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0005\"\u0004\b(\u0010\u0007R\u0018\u0010)\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0005\"\u0004\b+\u0010\u0007R\u0018\u0010,\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0005\"\u0004\b.\u0010\u0007R\u0018\u0010/\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0005\"\u0004\b1\u0010\u0007R\u0018\u00102\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b3\u0010\u0005\"\u0004\b4\u0010\u0007R\u0018\u00105\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b6\u0010\u0005\"\u0004\b7\u0010\u0007R\u0018\u00108\u001a\u000209X¦\u000e¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020?8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b@\u0010\u000bR*\u0010A\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bB\u0010\u000b\"\u0004\bC\u0010\rR\u001e\u0010D\u001a\u00020EX¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bF\u0010\u000b\"\u0004\bG\u0010\rR\u0018\u0010H\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bI\u0010\u0005\"\u0004\bJ\u0010\u0007R\u0018\u0010K\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bL\u0010\u0005\"\u0004\bM\u0010\u0007ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006NÀ\u0006\u0003"}, m195d2 = {"Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Landroidx/compose/ui/unit/Density;", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "", "getClip$annotations", "()V", "getClip", "()Z", "setClip", "(Z)V", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "getCompositingStrategy--NrFUSI", "()I", "setCompositingStrategy-aDBOjCE", "(I)V", "<anonymous parameter 0>", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "getTransformOrigin-SzJe1aQ", "setTransformOrigin-__ExYCQ", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@PlacementScopeMarker
public interface GraphicsLayerScope extends Density {
    float getAlpha();

    /* JADX INFO: renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    long mo4457getAmbientShadowColor0d7_KjU();

    float getCameraDistance();

    boolean getClip();

    /* JADX INFO: renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
    int mo4458getCompositingStrategyNrFUSI();

    RenderEffect getRenderEffect();

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    float getScaleX();

    float getScaleY();

    float getShadowElevation();

    Shape getShape();

    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    long mo4459getSizeNHjbRc();

    /* JADX INFO: renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    long mo4460getSpotShadowColor0d7_KjU();

    /* JADX INFO: renamed from: getTransformOrigin-SzJe1aQ, reason: not valid java name */
    long mo4461getTransformOriginSzJe1aQ();

    float getTranslationX();

    float getTranslationY();

    void setAlpha(float f);

    /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    void mo4462setAmbientShadowColor8_81llA(long j);

    void setCameraDistance(float f);

    void setClip(boolean z);

    /* JADX INFO: renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
    void mo4463setCompositingStrategyaDBOjCE(int i);

    void setRenderEffect(RenderEffect renderEffect);

    void setRotationX(float f);

    void setRotationY(float f);

    void setRotationZ(float f);

    void setScaleX(float f);

    void setScaleY(float f);

    void setShadowElevation(float f);

    void setShape(Shape shape);

    /* JADX INFO: renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    void mo4464setSpotShadowColor8_81llA(long j);

    /* JADX INFO: renamed from: setTransformOrigin-__ExYCQ, reason: not valid java name */
    void mo4465setTransformOrigin__ExYCQ(long j);

    void setTranslationX(float f);

    void setTranslationY(float f);

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.GraphicsLayerScope$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: GraphicsLayerScope.kt */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: $default$getAmbientShadowColor-0d7_KjU, reason: not valid java name */
        public static long m4466$default$getAmbientShadowColor0d7_KjU(GraphicsLayerScope _this) {
            return GraphicsLayerScopeKt.getDefaultShadowColor();
        }

        /* JADX INFO: renamed from: $default$setAmbientShadowColor-8_81llA, reason: not valid java name */
        public static void m4470$default$setAmbientShadowColor8_81llA(GraphicsLayerScope _this, long ambientShadowColor) {
        }

        /* JADX INFO: renamed from: $default$getSpotShadowColor-0d7_KjU, reason: not valid java name */
        public static long m4469$default$getSpotShadowColor0d7_KjU(GraphicsLayerScope _this) {
            return GraphicsLayerScopeKt.getDefaultShadowColor();
        }

        /* JADX INFO: renamed from: $default$setSpotShadowColor-8_81llA, reason: not valid java name */
        public static void m4472$default$setSpotShadowColor8_81llA(GraphicsLayerScope _this, long spotShadowColor) {
        }

        public static RenderEffect $default$getRenderEffect(GraphicsLayerScope _this) {
            return null;
        }

        public static void $default$setRenderEffect(GraphicsLayerScope _this, RenderEffect renderEffect) {
        }

        /* JADX INFO: renamed from: $default$getCompositingStrategy--NrFUSI, reason: not valid java name */
        public static int m4467$default$getCompositingStrategyNrFUSI(GraphicsLayerScope _this) {
            return CompositingStrategy.INSTANCE.m4380getAutoNrFUSI();
        }

        /* JADX INFO: renamed from: $default$setCompositingStrategy-aDBOjCE, reason: not valid java name */
        public static void m4471$default$setCompositingStrategyaDBOjCE(GraphicsLayerScope _this, int compositingStrategy) {
        }

        /* JADX INFO: renamed from: $default$getSize-NH-jbRc, reason: not valid java name */
        public static long m4468$default$getSizeNHjbRc(GraphicsLayerScope _this) {
            return Size.INSTANCE.m4126getUnspecifiedNHjbRc();
        }
    }

    /* JADX INFO: compiled from: GraphicsLayerScope.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        public static /* synthetic */ void getClip$annotations() {
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m4496roundToPxR2X_6o(GraphicsLayerScope $this, long $receiver) {
            return Density.CC.m6765$default$roundToPxR2X_6o($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m4497roundToPx0680j_4(GraphicsLayerScope $this, float $receiver) {
            return Density.CC.m6766$default$roundToPx0680j_4($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m4501toDpGaN1DYA(GraphicsLayerScope $this, long $receiver) {
            return FontScaling.CC.m6910$default$toDpGaN1DYA($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4502toDpu2uoSUM(GraphicsLayerScope $this, float $receiver) {
            return Density.CC.m6767$default$toDpu2uoSUM($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4503toDpu2uoSUM(GraphicsLayerScope $this, int $receiver) {
            return Density.CC.m6768$default$toDpu2uoSUM((Density) $this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m4504toDpSizekrfVVM(GraphicsLayerScope $this, long $receiver) {
            return Density.CC.m6769$default$toDpSizekrfVVM($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m4505toPxR2X_6o(GraphicsLayerScope $this, long $receiver) {
            return Density.CC.m6770$default$toPxR2X_6o($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m4506toPx0680j_4(GraphicsLayerScope $this, float $receiver) {
            return Density.CC.m6771$default$toPx0680j_4($this, $receiver);
        }

        @Deprecated
        public static Rect toRect(GraphicsLayerScope $this, DpRect $receiver) {
            return Density.CC.$default$toRect($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m4507toSizeXkaWNTQ(GraphicsLayerScope $this, long $receiver) {
            return Density.CC.m6772$default$toSizeXkaWNTQ($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m4508toSp0xMU5do(GraphicsLayerScope $this, float $receiver) {
            return FontScaling.CC.m6911$default$toSp0xMU5do($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4509toSpkPz2Gy4(GraphicsLayerScope $this, float $receiver) {
            return Density.CC.m6773$default$toSpkPz2Gy4($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4510toSpkPz2Gy4(GraphicsLayerScope $this, int $receiver) {
            return Density.CC.m6774$default$toSpkPz2Gy4((Density) $this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
        public static long m4492getAmbientShadowColor0d7_KjU(GraphicsLayerScope $this) {
            return CC.m4466$default$getAmbientShadowColor0d7_KjU($this);
        }

        @Deprecated
        /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
        public static void m4498setAmbientShadowColor8_81llA(GraphicsLayerScope $this, long ambientShadowColor) {
            CC.m4470$default$setAmbientShadowColor8_81llA($this, ambientShadowColor);
        }

        @Deprecated
        /* JADX INFO: renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
        public static long m4495getSpotShadowColor0d7_KjU(GraphicsLayerScope $this) {
            return CC.m4469$default$getSpotShadowColor0d7_KjU($this);
        }

        @Deprecated
        /* JADX INFO: renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
        public static void m4500setSpotShadowColor8_81llA(GraphicsLayerScope $this, long spotShadowColor) {
            CC.m4472$default$setSpotShadowColor8_81llA($this, spotShadowColor);
        }

        @Deprecated
        public static RenderEffect getRenderEffect(GraphicsLayerScope $this) {
            return CC.$default$getRenderEffect($this);
        }

        @Deprecated
        public static void setRenderEffect(GraphicsLayerScope $this, RenderEffect renderEffect) {
            CC.$default$setRenderEffect($this, renderEffect);
        }

        @Deprecated
        /* JADX INFO: renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
        public static int m4493getCompositingStrategyNrFUSI(GraphicsLayerScope $this) {
            return CC.m4467$default$getCompositingStrategyNrFUSI($this);
        }

        @Deprecated
        /* JADX INFO: renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
        public static void m4499setCompositingStrategyaDBOjCE(GraphicsLayerScope $this, int compositingStrategy) {
            CC.m4471$default$setCompositingStrategyaDBOjCE($this, compositingStrategy);
        }

        @Deprecated
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m4494getSizeNHjbRc(GraphicsLayerScope $this) {
            return CC.m4468$default$getSizeNHjbRc($this);
        }
    }
}
