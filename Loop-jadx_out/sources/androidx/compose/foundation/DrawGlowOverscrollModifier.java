package androidx.compose.foundation;

import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.DrawModifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p001ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.platform.InspectorInfo;
import androidx.compose.p001ui.platform.InspectorValueInfo;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: AndroidOverscroll.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B6\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u000eJ6\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\f\u0010\u001c\u001a\u00020\f*\u00020\u001dH\u0016J \u0010\u001e\u001a\u00020\u0010*\u00020\u001f2\u0006\u0010 \u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H\u0002J \u0010!\u001a\u00020\u0010*\u00020\u001f2\u0006\u0010\"\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H\u0002J \u0010#\u001a\u00020\u0010*\u00020\u001f2\u0006\u0010$\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H\u0002J \u0010%\u001a\u00020\u0010*\u00020\u001f2\u0006\u0010&\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, m195d2 = {"Landroidx/compose/foundation/DrawGlowOverscrollModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "overscrollEffect", "Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "overscrollConfig", "Landroidx/compose/foundation/OverscrollConfiguration;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;Landroidx/compose/foundation/EdgeEffectWrapper;Landroidx/compose/foundation/OverscrollConfiguration;Lkotlin/jvm/functions/Function1;)V", "drawWithRotationAndOffset", "", "rotationDegrees", "", "offset", "Landroidx/compose/ui/geometry/Offset;", "edgeEffect", "Landroid/widget/EdgeEffect;", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawWithRotationAndOffset-ubNVwUQ", "(FJLandroid/widget/EdgeEffect;Landroid/graphics/Canvas;)Z", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawBottomGlow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "bottom", "drawLeftGlow", "left", "drawRightGlow", "right", "drawTopGlow", "top", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class DrawGlowOverscrollModifier extends InspectorValueInfo implements DrawModifier {
    private final EdgeEffectWrapper edgeEffectWrapper;
    private final OverscrollConfiguration overscrollConfig;
    private final AndroidEdgeEffectOverscrollEffect overscrollEffect;

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p001ui.Modifier
    public /* synthetic */ boolean all(Function1 function1) {
        return Modifier.Element.CC.$default$all(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p001ui.Modifier
    public /* synthetic */ boolean any(Function1 function1) {
        return Modifier.Element.CC.$default$any(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p001ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return Modifier.Element.CC.$default$foldIn(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p001ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return Modifier.Element.CC.$default$foldOut(this, obj, function2);
    }

    @Override // androidx.compose.p001ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    public DrawGlowOverscrollModifier(AndroidEdgeEffectOverscrollEffect overscrollEffect, EdgeEffectWrapper edgeEffectWrapper, OverscrollConfiguration overscrollConfig, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.overscrollEffect = overscrollEffect;
        this.edgeEffectWrapper = edgeEffectWrapper;
        this.overscrollConfig = overscrollConfig;
    }

    @Override // androidx.compose.p001ui.draw.DrawModifier
    public void draw(ContentDrawScope $this$draw) {
        this.overscrollEffect.m438updateSizeuvyYCjk$foundation_release($this$draw.mo4773getSizeNHjbRc());
        if (Size.m4120isEmptyimpl($this$draw.mo4773getSizeNHjbRc())) {
            $this$draw.drawContent();
            return;
        }
        $this$draw.drawContent();
        this.overscrollEffect.getRedrawSignal$foundation_release().getValue();
        Canvas canvas = AndroidCanvas_androidKt.getNativeCanvas($this$draw.getDrawContext().getCanvas());
        boolean needsInvalidate = false;
        EdgeEffectWrapper $this$draw_u24lambda_u240 = this.edgeEffectWrapper;
        if ($this$draw_u24lambda_u240.isLeftAnimating()) {
            EdgeEffect leftEffect = $this$draw_u24lambda_u240.getOrCreateLeftEffect();
            needsInvalidate = drawLeftGlow($this$draw, leftEffect, canvas);
        }
        if ($this$draw_u24lambda_u240.isTopAnimating()) {
            EdgeEffect topEffect = $this$draw_u24lambda_u240.getOrCreateTopEffect();
            needsInvalidate = drawTopGlow($this$draw, topEffect, canvas) || needsInvalidate;
        }
        if ($this$draw_u24lambda_u240.isRightAnimating()) {
            EdgeEffect rightEffect = $this$draw_u24lambda_u240.getOrCreateRightEffect();
            needsInvalidate = drawRightGlow($this$draw, rightEffect, canvas) || needsInvalidate;
        }
        if ($this$draw_u24lambda_u240.isBottomAnimating()) {
            EdgeEffect bottomEffect = $this$draw_u24lambda_u240.getOrCreateBottomEffect();
            needsInvalidate = drawBottomGlow($this$draw, bottomEffect, canvas) || needsInvalidate;
        }
        if (needsInvalidate) {
            this.overscrollEffect.invalidateOverscroll$foundation_release();
        }
    }

    private final boolean drawLeftGlow(DrawScope $this$drawLeftGlow, EdgeEffect left, Canvas canvas) {
        long offset = OffsetKt.Offset(-Size.m4115getHeightimpl($this$drawLeftGlow.mo4773getSizeNHjbRc()), $this$drawLeftGlow.mo567toPx0680j_4(this.overscrollConfig.getDrawPadding().mo819calculateLeftPaddingu2uoSUM($this$drawLeftGlow.getLayoutDirection())));
        return m508drawWithRotationAndOffsetubNVwUQ(270.0f, offset, left, canvas);
    }

    private final boolean drawTopGlow(DrawScope $this$drawTopGlow, EdgeEffect top, Canvas canvas) {
        long offset = OffsetKt.Offset(0.0f, $this$drawTopGlow.mo567toPx0680j_4(this.overscrollConfig.getDrawPadding().getTop()));
        return m508drawWithRotationAndOffsetubNVwUQ(0.0f, offset, top, canvas);
    }

    private final boolean drawRightGlow(DrawScope $this$drawRightGlow, EdgeEffect right, Canvas canvas) {
        int width = MathKt.roundToInt(Size.m4118getWidthimpl($this$drawRightGlow.mo4773getSizeNHjbRc()));
        float rightPadding = this.overscrollConfig.getDrawPadding().mo820calculateRightPaddingu2uoSUM($this$drawRightGlow.getLayoutDirection());
        long offset = OffsetKt.Offset(0.0f, (-width) + $this$drawRightGlow.mo567toPx0680j_4(rightPadding));
        return m508drawWithRotationAndOffsetubNVwUQ(90.0f, offset, right, canvas);
    }

    private final boolean drawBottomGlow(DrawScope $this$drawBottomGlow, EdgeEffect bottom, Canvas canvas) {
        float bottomPadding = $this$drawBottomGlow.mo567toPx0680j_4(this.overscrollConfig.getDrawPadding().getBottom());
        long offset = OffsetKt.Offset(-Size.m4118getWidthimpl($this$drawBottomGlow.mo4773getSizeNHjbRc()), (-Size.m4115getHeightimpl($this$drawBottomGlow.mo4773getSizeNHjbRc())) + bottomPadding);
        return m508drawWithRotationAndOffsetubNVwUQ(180.0f, offset, bottom, canvas);
    }

    /* JADX INFO: renamed from: drawWithRotationAndOffset-ubNVwUQ, reason: not valid java name */
    private final boolean m508drawWithRotationAndOffsetubNVwUQ(float rotationDegrees, long offset, EdgeEffect edgeEffect, Canvas canvas) {
        int restore = canvas.save();
        canvas.rotate(rotationDegrees);
        canvas.translate(Offset.m4049getXimpl(offset), Offset.m4050getYimpl(offset));
        boolean needsInvalidate = edgeEffect.draw(canvas);
        canvas.restoreToCount(restore);
        return needsInvalidate;
    }
}
