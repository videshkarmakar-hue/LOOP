package androidx.compose.p001ui.graphics;

import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.DensityKt;
import androidx.compose.p001ui.unit.DpRect;
import androidx.compose.p001ui.unit.FontScaling;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GraphicsLayerScope.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010^\u001a\u00020_R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0014@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R,\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u001a@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0007R\u0014\u0010#\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0007R\u001a\u0010%\u001a\u00020&X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR(\u00100\u001a\u0004\u0018\u00010/2\b\u0010\u0003\u001a\u0004\u0018\u00010/@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0007\"\u0004\b7\u0010\tR$\u00108\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0007\"\u0004\b:\u0010\tR$\u0010;\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0007\"\u0004\b=\u0010\tR$\u0010>\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0007\"\u0004\b@\u0010\tR$\u0010A\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0007\"\u0004\bC\u0010\tR$\u0010D\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0007\"\u0004\bF\u0010\tR$\u0010H\u001a\u00020G2\u0006\u0010\u0003\u001a\u00020G@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010M\u001a\u00020NX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\bO\u0010\r\"\u0004\bP\u0010\u000fR,\u0010Q\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\bR\u0010\r\"\u0004\bS\u0010\u000fR,\u0010U\u001a\u00020T2\u0006\u0010\u0003\u001a\u00020T@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\bV\u0010\r\"\u0004\bW\u0010\u000fR$\u0010X\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0007\"\u0004\bZ\u0010\tR$\u0010[\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0007\"\u0004\b]\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006`"}, m195d2 = {"Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "()V", DownloadUtil.CookieScheme.VALUE, "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "J", "cameraDistance", "getCameraDistance", "setCameraDistance", "", "clip", "getClip", "()Z", "setClip", "(Z)V", "Landroidx/compose/ui/graphics/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy--NrFUSI", "()I", "setCompositingStrategy-aDBOjCE", "(I)V", "I", "density", "getDensity", "fontScale", "getFontScale", "graphicsDensity", "Landroidx/compose/ui/unit/Density;", "getGraphicsDensity$ui_release", "()Landroidx/compose/ui/unit/Density;", "setGraphicsDensity$ui_release", "(Landroidx/compose/ui/unit/Density;)V", "mutatedFields", "", "getMutatedFields$ui_release", "setMutatedFields$ui_release", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "Landroidx/compose/ui/graphics/Shape;", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "setSize-uvyYCjk", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "Landroidx/compose/ui/graphics/TransformOrigin;", "transformOrigin", "getTransformOrigin-SzJe1aQ", "setTransformOrigin-__ExYCQ", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "reset", "", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ReusableGraphicsLayerScope implements GraphicsLayerScope {
    public static final int $stable = 0;
    private boolean clip;
    private int mutatedFields;
    private RenderEffect renderEffect;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float shadowElevation;
    private float translationX;
    private float translationY;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float alpha = 1.0f;
    private long ambientShadowColor = GraphicsLayerScopeKt.getDefaultShadowColor();
    private long spotShadowColor = GraphicsLayerScopeKt.getDefaultShadowColor();
    private float cameraDistance = 8.0f;
    private long transformOrigin = TransformOrigin.INSTANCE.m4690getCenterSzJe1aQ();
    private Shape shape = RectangleShapeKt.getRectangleShape();
    private int compositingStrategy = CompositingStrategy.INSTANCE.m4380getAutoNrFUSI();
    private long size = Size.INSTANCE.m4126getUnspecifiedNHjbRc();
    private Density graphicsDensity = DensityKt.Density$default(1.0f, 0.0f, 2, null);

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public /* synthetic */ int mo560roundToPxR2X_6o(long j) {
        return Density.CC.m6765$default$roundToPxR2X_6o(this, j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public /* synthetic */ int mo561roundToPx0680j_4(float f) {
        return Density.CC.m6766$default$roundToPx0680j_4(this, f);
    }

    @Override // androidx.compose.p001ui.unit.FontScaling
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public /* synthetic */ float mo562toDpGaN1DYA(long j) {
        return FontScaling.CC.m6910$default$toDpGaN1DYA(this, j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo563toDpu2uoSUM(float f) {
        return Density.CC.m6767$default$toDpu2uoSUM(this, f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo564toDpu2uoSUM(int i) {
        return Density.CC.m6768$default$toDpu2uoSUM((Density) this, i);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public /* synthetic */ long mo565toDpSizekrfVVM(long j) {
        return Density.CC.m6769$default$toDpSizekrfVVM(this, j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public /* synthetic */ float mo566toPxR2X_6o(long j) {
        return Density.CC.m6770$default$toPxR2X_6o(this, j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public /* synthetic */ float mo567toPx0680j_4(float f) {
        return Density.CC.m6771$default$toPx0680j_4(this, f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return Density.CC.$default$toRect(this, dpRect);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public /* synthetic */ long mo568toSizeXkaWNTQ(long j) {
        return Density.CC.m6772$default$toSizeXkaWNTQ(this, j);
    }

    @Override // androidx.compose.p001ui.unit.FontScaling
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public /* synthetic */ long mo569toSp0xMU5do(float f) {
        return FontScaling.CC.m6911$default$toSp0xMU5do(this, f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo570toSpkPz2Gy4(float f) {
        return Density.CC.m6773$default$toSpkPz2Gy4(this, f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo571toSpkPz2Gy4(int i) {
        return Density.CC.m6774$default$toSpkPz2Gy4((Density) this, i);
    }

    /* JADX INFO: renamed from: getMutatedFields$ui_release, reason: from getter */
    public final int getMutatedFields() {
        return this.mutatedFields;
    }

    public final void setMutatedFields$ui_release(int i) {
        this.mutatedFields = i;
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public float getScaleX() {
        return this.scaleX;
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public void setScaleX(float value) {
        if (!(this.scaleX == value)) {
            this.mutatedFields |= 1;
            this.scaleX = value;
        }
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public float getScaleY() {
        return this.scaleY;
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public void setScaleY(float value) {
        if (!(this.scaleY == value)) {
            this.mutatedFields |= 2;
            this.scaleY = value;
        }
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public void setAlpha(float value) {
        if (!(this.alpha == value)) {
            this.mutatedFields |= 4;
            this.alpha = value;
        }
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public float getTranslationX() {
        return this.translationX;
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public void setTranslationX(float value) {
        if (!(this.translationX == value)) {
            this.mutatedFields |= 8;
            this.translationX = value;
        }
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public float getTranslationY() {
        return this.translationY;
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public void setTranslationY(float value) {
        if (!(this.translationY == value)) {
            this.mutatedFields |= 16;
            this.translationY = value;
        }
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public float getShadowElevation() {
        return this.shadowElevation;
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public void setShadowElevation(float value) {
        if (!(this.shadowElevation == value)) {
            this.mutatedFields |= 32;
            this.shadowElevation = value;
        }
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    /* JADX INFO: renamed from: getAmbientShadowColor-0d7_KjU, reason: from getter */
    public long getAmbientShadowColor() {
        return this.ambientShadowColor;
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA */
    public void mo4462setAmbientShadowColor8_81llA(long value) {
        if (!Color.m4292equalsimpl0(this.ambientShadowColor, value)) {
            this.mutatedFields |= 64;
            this.ambientShadowColor = value;
        }
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    /* JADX INFO: renamed from: getSpotShadowColor-0d7_KjU, reason: from getter */
    public long getSpotShadowColor() {
        return this.spotShadowColor;
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    /* JADX INFO: renamed from: setSpotShadowColor-8_81llA */
    public void mo4464setSpotShadowColor8_81llA(long value) {
        if (!Color.m4292equalsimpl0(this.spotShadowColor, value)) {
            this.mutatedFields |= 128;
            this.spotShadowColor = value;
        }
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public float getRotationX() {
        return this.rotationX;
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public void setRotationX(float value) {
        if (!(this.rotationX == value)) {
            this.mutatedFields |= 256;
            this.rotationX = value;
        }
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public float getRotationY() {
        return this.rotationY;
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public void setRotationY(float value) {
        if (!(this.rotationY == value)) {
            this.mutatedFields |= 512;
            this.rotationY = value;
        }
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public float getRotationZ() {
        return this.rotationZ;
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public void setRotationZ(float value) {
        if (!(this.rotationZ == value)) {
            this.mutatedFields |= 1024;
            this.rotationZ = value;
        }
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public float getCameraDistance() {
        return this.cameraDistance;
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public void setCameraDistance(float value) {
        if (!(this.cameraDistance == value)) {
            this.mutatedFields |= 2048;
            this.cameraDistance = value;
        }
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    /* JADX INFO: renamed from: getTransformOrigin-SzJe1aQ, reason: from getter */
    public long getTransformOrigin() {
        return this.transformOrigin;
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    /* JADX INFO: renamed from: setTransformOrigin-__ExYCQ */
    public void mo4465setTransformOrigin__ExYCQ(long value) {
        if (!TransformOrigin.m4684equalsimpl0(this.transformOrigin, value)) {
            this.mutatedFields |= 4096;
            this.transformOrigin = value;
        }
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public Shape getShape() {
        return this.shape;
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public void setShape(Shape value) {
        if (!Intrinsics.areEqual(this.shape, value)) {
            this.mutatedFields |= 8192;
            this.shape = value;
        }
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public boolean getClip() {
        return this.clip;
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public void setClip(boolean value) {
        if (this.clip != value) {
            this.mutatedFields |= 16384;
            this.clip = value;
        }
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    /* JADX INFO: renamed from: getCompositingStrategy--NrFUSI, reason: from getter */
    public int getCompositingStrategy() {
        return this.compositingStrategy;
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    /* JADX INFO: renamed from: setCompositingStrategy-aDBOjCE */
    public void mo4463setCompositingStrategyaDBOjCE(int value) {
        if (!CompositingStrategy.m4376equalsimpl0(this.compositingStrategy, value)) {
            this.mutatedFields |= 32768;
            this.compositingStrategy = value;
        }
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: from getter */
    public long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
    public void m4611setSizeuvyYCjk(long j) {
        this.size = j;
    }

    /* JADX INFO: renamed from: getGraphicsDensity$ui_release, reason: from getter */
    public final Density getGraphicsDensity() {
        return this.graphicsDensity;
    }

    public final void setGraphicsDensity$ui_release(Density density) {
        this.graphicsDensity = density;
    }

    @Override // androidx.compose.p001ui.unit.Density
    public float getDensity() {
        return this.graphicsDensity.getDensity();
    }

    @Override // androidx.compose.p001ui.unit.FontScaling
    public float getFontScale() {
        return this.graphicsDensity.getFontScale();
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    @Override // androidx.compose.p001ui.graphics.GraphicsLayerScope
    public void setRenderEffect(RenderEffect value) {
        if (!Intrinsics.areEqual(this.renderEffect, value)) {
            this.mutatedFields |= 131072;
            this.renderEffect = value;
        }
    }

    public final void reset() {
        setScaleX(1.0f);
        setScaleY(1.0f);
        setAlpha(1.0f);
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        setShadowElevation(0.0f);
        mo4462setAmbientShadowColor8_81llA(GraphicsLayerScopeKt.getDefaultShadowColor());
        mo4464setSpotShadowColor8_81llA(GraphicsLayerScopeKt.getDefaultShadowColor());
        setRotationX(0.0f);
        setRotationY(0.0f);
        setRotationZ(0.0f);
        setCameraDistance(8.0f);
        mo4465setTransformOrigin__ExYCQ(TransformOrigin.INSTANCE.m4690getCenterSzJe1aQ());
        setShape(RectangleShapeKt.getRectangleShape());
        setClip(false);
        setRenderEffect(null);
        mo4463setCompositingStrategyaDBOjCE(CompositingStrategy.INSTANCE.m4380getAutoNrFUSI());
        m4611setSizeuvyYCjk(Size.INSTANCE.m4126getUnspecifiedNHjbRc());
        this.mutatedFields = 0;
    }
}
