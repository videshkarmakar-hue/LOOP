package androidx.compose.foundation.text;

import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BasicText.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u0003¢\u0006\u0002\u0010\bJ,\u0010\t\u001a\u00020\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, m195d2 = {"Landroidx/compose/foundation/text/TextMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "shouldMeasureLinks", "Lkotlin/Function0;", "", "placements", "", "Landroidx/compose/ui/geometry/Rect;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class TextMeasurePolicy implements MeasurePolicy {
    private final Function0<List<Rect>> placements;
    private final Function0<Boolean> shouldMeasureLinks;

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

    /* JADX WARN: Multi-variable type inference failed */
    public TextMeasurePolicy(Function0<Boolean> function0, Function0<? extends List<Rect>> function1) {
        this.shouldMeasureLinks = function0;
        this.placements = function1;
    }

    @Override // androidx.compose.p001ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo285measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> list, long constraints) {
        ArrayList arrayList;
        Pair pair;
        List target$iv = new ArrayList(list.size());
        int size = list.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            Measurable measurable = list.get(index$iv$iv);
            Measurable it = measurable;
            if (!(it.getParentData() instanceof TextRangeLayoutModifier)) {
                target$iv.add(measurable);
            }
        }
        List inlineContentMeasurables = target$iv;
        List<Rect> listInvoke = this.placements.invoke();
        if (listInvoke != null) {
            ArrayList target$iv2 = new ArrayList(listInvoke.size());
            List<Rect> list2 = listInvoke;
            int $i$f$fastForEachIndexed = 0;
            int index$iv$iv2 = 0;
            int size2 = list2.size();
            while (index$iv$iv2 < size2) {
                Object item$iv$iv = list2.get(index$iv$iv2);
                int index$iv = index$iv$iv2;
                Rect rect = (Rect) item$iv$iv;
                if (rect != null) {
                    Placeable placeableMo5644measureBRTryo0 = ((Measurable) inlineContentMeasurables.get(index$iv)).mo5644measureBRTryo0(ConstraintsKt.Constraints$default(0, (int) Math.floor(rect.getWidth()), 0, (int) Math.floor(rect.getHeight()), 5, null));
                    float $this$fastRoundToInt$iv = rect.getLeft();
                    int iRound = Math.round($this$fastRoundToInt$iv);
                    float $this$fastRoundToInt$iv2 = rect.getTop();
                    pair = new Pair(placeableMo5644measureBRTryo0, IntOffset.m6924boximpl(IntOffsetKt.IntOffset(iRound, Math.round($this$fastRoundToInt$iv2))));
                } else {
                    pair = null;
                }
                if (pair != null) {
                    target$iv2.add(pair);
                }
                index$iv$iv2++;
                listInvoke = listInvoke;
                inlineContentMeasurables = inlineContentMeasurables;
                list2 = list2;
                $i$f$fastForEachIndexed = $i$f$fastForEachIndexed;
            }
            arrayList = target$iv2;
        } else {
            arrayList = null;
        }
        final List inlineContentToPlace = arrayList;
        List target$iv3 = new ArrayList(list.size());
        int size3 = list.size();
        for (int index$iv$iv3 = 0; index$iv$iv3 < size3; index$iv$iv3++) {
            Measurable measurable2 = list.get(index$iv$iv3);
            Measurable it2 = measurable2;
            if (it2.getParentData() instanceof TextRangeLayoutModifier) {
                target$iv3.add(measurable2);
            }
        }
        List linksMeasurables = target$iv3;
        final List linksToPlace = BasicTextKt.measureWithTextRangeMeasureConstraints(linksMeasurables, this.shouldMeasureLinks);
        return MeasureScope.CC.layout$default($this$measure_u2d3p2s80s, Constraints.m6744getMaxWidthimpl(constraints), Constraints.m6743getMaxHeightimpl(constraints), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.TextMeasurePolicy$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                List<Pair<Placeable, IntOffset>> list3 = inlineContentToPlace;
                if (list3 != null) {
                    int size4 = list3.size();
                    for (int index$iv2 = 0; index$iv2 < size4; index$iv2++) {
                        Object item$iv = list3.get(index$iv2);
                        Pair<Placeable, IntOffset> pair2 = (Pair) item$iv;
                        Placeable placeable = pair2.component1();
                        long position = pair2.component2().getPackedValue();
                        Placeable.PlacementScope.m5706place70tqf50$default($this$layout, placeable, position, 0.0f, 2, null);
                    }
                }
                List<Pair<Placeable, Function0<IntOffset>>> list4 = linksToPlace;
                if (list4 == null) {
                    return;
                }
                int size5 = list4.size();
                for (int index$iv3 = 0; index$iv3 < size5; index$iv3++) {
                    Object item$iv2 = list4.get(index$iv3);
                    Pair<Placeable, Function0<IntOffset>> pair3 = (Pair) item$iv2;
                    Placeable placeable2 = pair3.component1();
                    Function0<IntOffset> function0Component2 = pair3.component2();
                    Placeable.PlacementScope.m5706place70tqf50$default($this$layout, placeable2, function0Component2 != null ? function0Component2.invoke().getPackedValue() : IntOffset.INSTANCE.m6943getZeronOccac(), 0.0f, 2, null);
                }
            }
        }, 4, null);
    }
}
