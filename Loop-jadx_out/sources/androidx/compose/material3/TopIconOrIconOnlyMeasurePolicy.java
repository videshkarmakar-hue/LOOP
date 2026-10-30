package androidx.compose.material3;

import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.LayoutIdKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: NavigationItem.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ,\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\n\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\t\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, m195d2 = {"Landroidx/compose/material3/TopIconOrIconOnlyMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "hasLabel", "", "animationProgress", "Lkotlin/Function0;", "", "indicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "indicatorVerticalPadding", "indicatorToLabelVerticalPadding", "(ZLkotlin/jvm/functions/Function0;FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnimationProgress", "()Lkotlin/jvm/functions/Function0;", "getHasLabel", "()Z", "getIndicatorHorizontalPadding-D9Ej5fM", "()F", "F", "getIndicatorToLabelVerticalPadding-D9Ej5fM", "getIndicatorVerticalPadding-D9Ej5fM", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class TopIconOrIconOnlyMeasurePolicy implements MeasurePolicy {
    private final Function0<Float> animationProgress;
    private final boolean hasLabel;
    private final float indicatorHorizontalPadding;
    private final float indicatorToLabelVerticalPadding;
    private final float indicatorVerticalPadding;

    public /* synthetic */ TopIconOrIconOnlyMeasurePolicy(boolean z, Function0 function0, float f, float f2, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, function0, f, f2, f3);
    }

    @Override // androidx.compose.p001ui.layout.MeasurePolicy
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.p001ui.layout.MeasurePolicy
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.p001ui.layout.MeasurePolicy
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.p001ui.layout.MeasurePolicy
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    private TopIconOrIconOnlyMeasurePolicy(boolean hasLabel, Function0<Float> function0, float indicatorHorizontalPadding, float indicatorVerticalPadding, float indicatorToLabelVerticalPadding) {
        this.hasLabel = hasLabel;
        this.animationProgress = function0;
        this.indicatorHorizontalPadding = indicatorHorizontalPadding;
        this.indicatorVerticalPadding = indicatorVerticalPadding;
        this.indicatorToLabelVerticalPadding = indicatorToLabelVerticalPadding;
    }

    public final boolean getHasLabel() {
        return this.hasLabel;
    }

    public final Function0<Float> getAnimationProgress() {
        return this.animationProgress;
    }

    /* JADX INFO: renamed from: getIndicatorHorizontalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getIndicatorHorizontalPadding() {
        return this.indicatorHorizontalPadding;
    }

    /* JADX INFO: renamed from: getIndicatorVerticalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getIndicatorVerticalPadding() {
        return this.indicatorVerticalPadding;
    }

    /* JADX INFO: renamed from: getIndicatorToLabelVerticalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getIndicatorToLabelVerticalPadding() {
        return this.indicatorToLabelVerticalPadding;
    }

    @Override // androidx.compose.p001ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo285measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> list, long constraints) {
        float animationProgress = this.animationProgress.invoke().floatValue();
        long looseConstraints = Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0);
        List<? extends Measurable> list2 = list;
        int $i$f$fastFirst = 0;
        int index$iv$iv = 0;
        int size = list2.size();
        while (index$iv$iv < size) {
            Object item$iv$iv = list2.get(index$iv$iv);
            Measurable it = (Measurable) item$iv$iv;
            List<? extends Measurable> list3 = list2;
            int $i$f$fastFirst2 = $i$f$fastFirst;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it), "icon")) {
                float arg0$iv = this.indicatorHorizontalPadding;
                int i = -$this$measure_u2d3p2s80s.mo561roundToPx0680j_4(C1979Dp.m6801constructorimpl(2 * arg0$iv));
                float arg0$iv2 = this.indicatorVerticalPadding;
                Placeable iconPlaceable = ((Measurable) item$iv$iv).mo5644measureBRTryo0(ConstraintsKt.m6763offsetNN6EwU(looseConstraints, i, -$this$measure_u2d3p2s80s.mo561roundToPx0680j_4(C1979Dp.m6801constructorimpl(2 * arg0$iv2))));
                int width = iconPlaceable.getWidth();
                float arg0$iv3 = this.indicatorHorizontalPadding;
                int totalIndicatorWidth = width + $this$measure_u2d3p2s80s.mo561roundToPx0680j_4(C1979Dp.m6801constructorimpl(2 * arg0$iv3));
                int height = iconPlaceable.getHeight();
                float arg0$iv4 = this.indicatorVerticalPadding;
                int indicatorHeight = height + $this$measure_u2d3p2s80s.mo561roundToPx0680j_4(C1979Dp.m6801constructorimpl(2 * arg0$iv4));
                int animatedIndicatorWidth = MathKt.roundToInt(totalIndicatorWidth * animationProgress);
                List<? extends Measurable> list4 = list;
                int $i$f$fastFirst3 = 0;
                int index$iv$iv2 = 0;
                int size2 = list4.size();
                while (index$iv$iv2 < size2) {
                    Object item$iv$iv2 = list4.get(index$iv$iv2);
                    Measurable it2 = (Measurable) item$iv$iv2;
                    List<? extends Measurable> list5 = list4;
                    int $i$f$fastFirst4 = $i$f$fastFirst3;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it2), "indicatorRipple")) {
                        Placeable indicatorRipplePlaceable = ((Measurable) item$iv$iv2).mo5644measureBRTryo0(ConstraintsKt.m6759constrainN9IONVI(looseConstraints, Constraints.INSTANCE.m6754fixedJhjzzOo(totalIndicatorWidth, indicatorHeight)));
                        int $i$f$fastFirst5 = 0;
                        int index$iv$iv3 = 0;
                        int size3 = list.size();
                        while (index$iv$iv3 < size3) {
                            Object item$iv$iv3 = list.get(index$iv$iv3);
                            Measurable it3 = (Measurable) item$iv$iv3;
                            int i2 = size3;
                            int $i$f$fastFirst6 = $i$f$fastFirst5;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it3), "indicator")) {
                                Placeable indicatorPlaceable = ((Measurable) item$iv$iv3).mo5644measureBRTryo0(ConstraintsKt.m6759constrainN9IONVI(looseConstraints, Constraints.INSTANCE.m6754fixedJhjzzOo(animatedIndicatorWidth, indicatorHeight)));
                                if (!this.hasLabel) {
                                    return NavigationItemKt.m2439placeIconX9ElhV4($this$measure_u2d3p2s80s, iconPlaceable, indicatorRipplePlaceable, indicatorPlaceable, constraints);
                                }
                                int size4 = list.size();
                                int $i$f$fastFirst7 = 0;
                                while ($i$f$fastFirst7 < size4) {
                                    Object item$iv$iv4 = list.get($i$f$fastFirst7);
                                    Measurable it4 = (Measurable) item$iv$iv4;
                                    int i3 = size4;
                                    int animatedIndicatorWidth2 = animatedIndicatorWidth;
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it4), "label")) {
                                        Placeable labelPlaceable = ((Measurable) item$iv$iv4).mo5644measureBRTryo0(ConstraintsKt.m6764offsetNN6EwU$default(looseConstraints, 0, -(indicatorPlaceable.getHeight() + $this$measure_u2d3p2s80s.mo561roundToPx0680j_4(this.indicatorToLabelVerticalPadding)), 1, null));
                                        return NavigationItemKt.m2441placeLabelAndTopIconzz1l4Y($this$measure_u2d3p2s80s, labelPlaceable, iconPlaceable, indicatorRipplePlaceable, indicatorPlaceable, constraints, this.indicatorToLabelVerticalPadding, this.indicatorVerticalPadding);
                                    }
                                    $i$f$fastFirst7++;
                                    size4 = i3;
                                    animatedIndicatorWidth = animatedIndicatorWidth2;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            index$iv$iv3++;
                            size3 = i2;
                            $i$f$fastFirst5 = $i$f$fastFirst6;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    index$iv$iv2++;
                    list4 = list5;
                    $i$f$fastFirst3 = $i$f$fastFirst4;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            index$iv$iv++;
            list2 = list3;
            $i$f$fastFirst = $i$f$fastFirst2;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
