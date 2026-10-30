package androidx.compose.foundation.layout;

import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.layout.AlignmentLine;
import androidx.compose.p001ui.layout.HorizontalAlignmentLine;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.platform.InspectableValueKt;
import androidx.compose.p001ui.platform.InspectorInfo;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.TextUnit;
import androidx.compose.p001ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: AlignmentLine.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a>\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0019\u001a\u00020\u0013*\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a*\u0010\u0019\u001a\u00020\u0013*\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, m195d2 = {"horizontal", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getHorizontal", "(Landroidx/compose/ui/layout/AlignmentLine;)Z", "alignmentLineOffsetMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "alignmentLine", "before", "Landroidx/compose/ui/unit/Dp;", "after", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "alignmentLineOffsetMeasure-tjqqzMA", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/AlignmentLine;FFLandroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "paddingFrom", "Landroidx/compose/ui/Modifier;", "paddingFrom-4j6BHR0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;FF)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/TextUnit;", "paddingFrom-Y_r0B1c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;JJ)Landroidx/compose/ui/Modifier;", "paddingFromBaseline", "top", "bottom", "paddingFromBaseline-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "paddingFromBaseline-wCyjxdI", "(Landroidx/compose/ui/Modifier;JJ)Landroidx/compose/ui/Modifier;", "foundation-layout_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AlignmentLineKt {
    /* JADX INFO: renamed from: paddingFrom-4j6BHR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m715paddingFrom4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f2 = C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM();
        }
        return m714paddingFrom4j6BHR0(modifier, alignmentLine, f, f2);
    }

    /* JADX INFO: renamed from: paddingFrom-4j6BHR0, reason: not valid java name */
    public static final Modifier m714paddingFrom4j6BHR0(Modifier $this$paddingFrom_u2d4j6BHR0, final AlignmentLine alignmentLine, final float before, final float after) {
        return $this$paddingFrom_u2d4j6BHR0.then(new AlignmentLineOffsetDpElement(alignmentLine, before, after, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-4j6BHR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                $this$null.setName("paddingFrom");
                $this$null.getProperties().set("alignmentLine", alignmentLine);
                $this$null.getProperties().set("before", C1979Dp.m6799boximpl(before));
                $this$null.getProperties().set("after", C1979Dp.m6799boximpl(after));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: paddingFrom-Y_r0B1c$default, reason: not valid java name */
    public static /* synthetic */ Modifier m717paddingFromY_r0B1c$default(Modifier modifier, AlignmentLine alignmentLine, long j, long j2, int i, Object obj) {
        long jM7009getUnspecifiedXSAIIZE;
        long jM7009getUnspecifiedXSAIIZE2;
        if ((i & 2) == 0) {
            jM7009getUnspecifiedXSAIIZE = j;
        } else {
            jM7009getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m7009getUnspecifiedXSAIIZE();
        }
        if ((i & 4) == 0) {
            jM7009getUnspecifiedXSAIIZE2 = j2;
        } else {
            jM7009getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m7009getUnspecifiedXSAIIZE();
        }
        return m716paddingFromY_r0B1c(modifier, alignmentLine, jM7009getUnspecifiedXSAIIZE, jM7009getUnspecifiedXSAIIZE2);
    }

    /* JADX INFO: renamed from: paddingFrom-Y_r0B1c, reason: not valid java name */
    public static final Modifier m716paddingFromY_r0B1c(Modifier $this$paddingFrom_u2dY_r0B1c, final AlignmentLine alignmentLine, final long before, final long after) {
        return $this$paddingFrom_u2dY_r0B1c.then(new AlignmentLineOffsetTextUnitElement(alignmentLine, before, after, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-Y_r0B1c$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                $this$null.setName("paddingFrom");
                $this$null.getProperties().set("alignmentLine", alignmentLine);
                $this$null.getProperties().set("before", TextUnit.m6988boximpl(before));
                $this$null.getProperties().set("after", TextUnit.m6988boximpl(after));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: paddingFromBaseline-VpY3zN4, reason: not valid java name */
    public static final Modifier m718paddingFromBaselineVpY3zN4(Modifier $this$paddingFromBaseline_u2dVpY3zN4, float top, float bottom) {
        Modifier.Companion companionM715paddingFrom4j6BHR0$default;
        Modifier.Companion companionM715paddingFrom4j6BHR0$default2;
        if (!C1979Dp.m6806equalsimpl0(top, C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM())) {
            companionM715paddingFrom4j6BHR0$default = m715paddingFrom4j6BHR0$default(Modifier.INSTANCE, androidx.compose.p001ui.layout.AlignmentLineKt.getFirstBaseline(), top, 0.0f, 4, null);
        } else {
            companionM715paddingFrom4j6BHR0$default = Modifier.INSTANCE;
        }
        Modifier modifierThen = $this$paddingFromBaseline_u2dVpY3zN4.then(companionM715paddingFrom4j6BHR0$default);
        if (!C1979Dp.m6806equalsimpl0(bottom, C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM())) {
            companionM715paddingFrom4j6BHR0$default2 = m715paddingFrom4j6BHR0$default(Modifier.INSTANCE, androidx.compose.p001ui.layout.AlignmentLineKt.getLastBaseline(), 0.0f, bottom, 2, null);
        } else {
            companionM715paddingFrom4j6BHR0$default2 = Modifier.INSTANCE;
        }
        return modifierThen.then(companionM715paddingFrom4j6BHR0$default2);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m719paddingFromBaselineVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM();
        }
        return m718paddingFromBaselineVpY3zN4(modifier, f, f2);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-wCyjxdI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m721paddingFromBaselinewCyjxdI$default(Modifier modifier, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = TextUnit.INSTANCE.m7009getUnspecifiedXSAIIZE();
        }
        if ((i & 2) != 0) {
            j2 = TextUnit.INSTANCE.m7009getUnspecifiedXSAIIZE();
        }
        return m720paddingFromBaselinewCyjxdI(modifier, j, j2);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-wCyjxdI, reason: not valid java name */
    public static final Modifier m720paddingFromBaselinewCyjxdI(Modifier $this$paddingFromBaseline_u2dwCyjxdI, long top, long bottom) {
        return $this$paddingFromBaseline_u2dwCyjxdI.then(!TextUnitKt.m7016isUnspecifiedR2X_6o(top) ? m717paddingFromY_r0B1c$default(Modifier.INSTANCE, androidx.compose.p001ui.layout.AlignmentLineKt.getFirstBaseline(), top, 0L, 4, null) : Modifier.INSTANCE).then(!TextUnitKt.m7016isUnspecifiedR2X_6o(bottom) ? m717paddingFromY_r0B1c$default(Modifier.INSTANCE, androidx.compose.p001ui.layout.AlignmentLineKt.getLastBaseline(), 0L, bottom, 2, null) : Modifier.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: alignmentLineOffsetMeasure-tjqqzMA, reason: not valid java name */
    public static final MeasureResult m713alignmentLineOffsetMeasuretjqqzMA(MeasureScope $this$alignmentLineOffsetMeasure_u2dtjqqzMA, final AlignmentLine alignmentLine, final float before, float after, Measurable measurable, long constraints) {
        final int width;
        final int height;
        final Placeable placeable = measurable.mo5644measureBRTryo0(getHorizontal(alignmentLine) ? Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0) : Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0));
        int it = placeable.get(alignmentLine);
        if (it == Integer.MIN_VALUE) {
            it = 0;
        }
        int linePosition = it;
        int axis = getHorizontal(alignmentLine) ? placeable.getHeight() : placeable.getWidth();
        int axisMax = getHorizontal(alignmentLine) ? Constraints.m6743getMaxHeightimpl(constraints) : Constraints.m6744getMaxWidthimpl(constraints);
        final int paddingBefore = RangesKt.coerceIn((!C1979Dp.m6806equalsimpl0(before, C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM()) ? $this$alignmentLineOffsetMeasure_u2dtjqqzMA.mo561roundToPx0680j_4(before) : 0) - linePosition, 0, axisMax - axis);
        final int paddingAfter = RangesKt.coerceIn(((!C1979Dp.m6806equalsimpl0(after, C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM()) ? $this$alignmentLineOffsetMeasure_u2dtjqqzMA.mo561roundToPx0680j_4(after) : 0) - axis) + linePosition, 0, (axisMax - axis) - paddingBefore);
        if (!getHorizontal(alignmentLine)) {
            width = Math.max(paddingBefore + placeable.getWidth() + paddingAfter, Constraints.m6746getMinWidthimpl(constraints));
        } else {
            width = placeable.getWidth();
        }
        if (getHorizontal(alignmentLine)) {
            height = Math.max(paddingBefore + placeable.getHeight() + paddingAfter, Constraints.m6745getMinHeightimpl(constraints));
        } else {
            height = placeable.getHeight();
        }
        return MeasureScope.CC.layout$default($this$alignmentLineOffsetMeasure_u2dtjqqzMA, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$alignmentLineOffsetMeasure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope $this$layout) {
                int x;
                int y;
                if (AlignmentLineKt.getHorizontal(alignmentLine)) {
                    x = 0;
                } else {
                    x = !C1979Dp.m6806equalsimpl0(before, C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM()) ? paddingBefore : (width - paddingAfter) - placeable.getWidth();
                }
                if (AlignmentLineKt.getHorizontal(alignmentLine)) {
                    y = !C1979Dp.m6806equalsimpl0(before, C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM()) ? paddingBefore : (height - paddingAfter) - placeable.getHeight();
                } else {
                    y = 0;
                }
                Placeable.PlacementScope.placeRelative$default($this$layout, placeable, x, y, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHorizontal(AlignmentLine $this$horizontal) {
        return $this$horizontal instanceof HorizontalAlignmentLine;
    }
}
