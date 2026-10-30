package com.videshkarmakar.loop.ui.theme;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NeuMorphism.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a:\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aF\u0010\r\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a0\u0010\u0012\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a:\u0010\u0015\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a6\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"STEPS", "", "neuInset", "Landroidx/compose/ui/Modifier;", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "depth", "fill", "Landroidx/compose/ui/graphics/Color;", "drawFill", "", "neuInset-FgKr3fQ", "(Landroidx/compose/ui/Modifier;FFJZ)Landroidx/compose/ui/Modifier;", "neuMaterial", "lightTone", "darkTone", "neuMaterial-ullzO4E", "(Landroidx/compose/ui/Modifier;FFJJJZ)Landroidx/compose/ui/Modifier;", "neuPressed", "neuPressed-B2jEHPA", "(Landroidx/compose/ui/Modifier;FFJ)Landroidx/compose/ui/Modifier;", "neuRaised", "pressed", "neuRaised-wkf6fSU", "(Landroidx/compose/ui/Modifier;FFZJ)Landroidx/compose/ui/Modifier;", "softEdge", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "radius", "", "spread", "direction", "Landroidx/compose/ui/geometry/Offset;", "color", "softEdge-uMChDws", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJJ)V", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NeuMorphismKt {
    private static final int STEPS = 8;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: softEdge-uMChDws, reason: not valid java name */
    public static final void m7528softEdgeuMChDws(DrawScope $this$softEdge_u2duMChDws, float radius, float spread, long direction, long color) {
        for (int i = 8; i > 0; i--) {
            float t = i / 8;
            float grow = spread * t;
            float alpha = Color.m4045getAlphaimpl(color) * (1.0f - t) * 0.34f;
            if (alpha > 0.002f) {
                long off = Offset.m3808timestuRUvjQ(direction, grow);
                DrawScope.CC.m4612drawRoundRectuAw5IA$default($this$softEdge_u2duMChDws, Color.m4041copywmQWz5c(color, (14 & 1) != 0 ? Color.m4045getAlphaimpl(color) : alpha, (14 & 2) != 0 ? Color.m4049getRedimpl(color) : 0.0f, (14 & 4) != 0 ? Color.m4048getGreenimpl(color) : 0.0f, (14 & 8) != 0 ? Color.m4046getBlueimpl(color) : 0.0f), OffsetKt.Offset((-grow) + Offset.m3801getXimpl(off), (-grow) + Offset.m3802getYimpl(off)), SizeKt.Size(Size.m3870getWidthimpl($this$softEdge_u2duMChDws.mo4525getSizeNHjbRc()) + (grow * 2.0f), Size.m3867getHeightimpl($this$softEdge_u2duMChDws.mo4525getSizeNHjbRc()) + (2.0f * grow)), CornerRadiusKt.CornerRadius(radius + grow, radius + grow), null, 0.0f, null, 0, 240, null);
            }
        }
    }

    /* JADX INFO: renamed from: neuMaterial-ullzO4E, reason: not valid java name */
    private static final Modifier m7523neuMaterialullzO4E(Modifier $this$neuMaterial_u2dullzO4E, final float cornerRadius, final float depth, final long fill, final long lightTone, final long darkTone, final boolean drawFill) {
        return DrawModifierKt.drawBehind($this$neuMaterial_u2dullzO4E, new Function1<DrawScope, Unit>() { // from class: com.videshkarmakar.loop.ui.theme.NeuMorphismKt$neuMaterial$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawBehind) {
                Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
                float r = drawBehind.mo319toPx0680j_4(cornerRadius);
                float d = drawBehind.mo319toPx0680j_4(depth);
                if (d > 0.0f) {
                    NeuMorphismKt.m7528softEdgeuMChDws(drawBehind, r, d, Neu.INSTANCE.m7515getLightSourceF1C5BW0(), lightTone);
                    NeuMorphismKt.m7528softEdgeuMChDws(drawBehind, r, d, Neu.INSTANCE.m7518getShadeDirectionF1C5BW0(), darkTone);
                }
                if (drawFill) {
                    DrawScope.CC.m4612drawRoundRectuAw5IA$default(drawBehind, fill, 0L, 0L, CornerRadiusKt.CornerRadius(r, r), null, 0.0f, null, 0, 246, null);
                }
            }
        });
    }

    /* JADX INFO: renamed from: neuRaised-wkf6fSU, reason: not valid java name */
    public static final Modifier m7526neuRaisedwkf6fSU(Modifier neuRaised, float cornerRadius, float depth, boolean pressed, long fill) {
        Intrinsics.checkNotNullParameter(neuRaised, "$this$neuRaised");
        long jM7516getPressedHighlight0d7_KjU = pressed ? Neu.INSTANCE.m7516getPressedHighlight0d7_KjU() : fill;
        Neu neu = Neu.INSTANCE;
        long jM7516getPressedHighlight0d7_KjU2 = pressed ? neu.m7516getPressedHighlight0d7_KjU() : neu.m7513getHighlight0d7_KjU();
        Neu neu2 = Neu.INSTANCE;
        return m7523neuMaterialullzO4E(neuRaised, cornerRadius, depth, jM7516getPressedHighlight0d7_KjU, jM7516getPressedHighlight0d7_KjU2, pressed ? neu2.m7517getPressedShadow0d7_KjU() : neu2.m7519getShadow0d7_KjU(), true);
    }

    /* JADX INFO: renamed from: neuPressed-B2jEHPA$default, reason: not valid java name */
    public static /* synthetic */ Modifier m7525neuPressedB2jEHPA$default(Modifier modifier, float f, float f2, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = Dp.m6553constructorimpl(8);
        }
        if ((i & 4) != 0) {
            j = Neu.INSTANCE.m7514getInsetFill0d7_KjU();
        }
        return m7524neuPressedB2jEHPA(modifier, f, f2, j);
    }

    /* JADX INFO: renamed from: neuPressed-B2jEHPA, reason: not valid java name */
    public static final Modifier m7524neuPressedB2jEHPA(Modifier neuPressed, float cornerRadius, float depth, long fill) {
        Intrinsics.checkNotNullParameter(neuPressed, "$this$neuPressed");
        return m7523neuMaterialullzO4E(neuPressed, cornerRadius, depth, fill, Neu.INSTANCE.m7516getPressedHighlight0d7_KjU(), Neu.INSTANCE.m7517getPressedShadow0d7_KjU(), true);
    }

    /* JADX INFO: renamed from: neuInset-FgKr3fQ, reason: not valid java name */
    public static final Modifier m7521neuInsetFgKr3fQ(Modifier neuInset, float cornerRadius, float depth, long fill, boolean drawFill) {
        Intrinsics.checkNotNullParameter(neuInset, "$this$neuInset");
        return m7523neuMaterialullzO4E(neuInset, cornerRadius, depth, fill, Neu.INSTANCE.m7519getShadow0d7_KjU(), Neu.INSTANCE.m7513getHighlight0d7_KjU(), drawFill);
    }
}
