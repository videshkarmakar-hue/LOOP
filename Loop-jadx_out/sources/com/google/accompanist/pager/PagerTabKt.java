package com.google.accompanist.pager;

import androidx.compose.material.TabPosition;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.layout.LayoutModifierKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.compose.p001ui.unit.DpKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PagerTab.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0007\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0007\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0002¨\u0006\f"}, m195d2 = {"pagerTabIndicatorOffset", "Landroidx/compose/ui/Modifier;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "tabPositions", "", "Landroidx/compose/material/TabPosition;", "pageIndexMapping", "Lkotlin/Function1;", "", "Lcom/google/accompanist/pager/PagerState;", "Lcom/google/accompanist/pager/PagerStateBridge;", "pager-indicators_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PagerTabKt {
    public static /* synthetic */ Modifier pagerTabIndicatorOffset$default(Modifier modifier, PagerState pagerState, List list, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: com.google.accompanist.pager.PagerTabKt.pagerTabIndicatorOffset.1
                public final Integer invoke(int it) {
                    return Integer.valueOf(it);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return pagerTabIndicatorOffset(modifier, pagerState, (List<TabPosition>) list, (Function1<? super Integer, Integer>) function1);
    }

    @Deprecated(message = "\n   pagerTabIndicatorOffset for accompanist Pagers are deprecated, please use the version that takes \n   androidx.compose.foundation.pager.PagerState instead\nFor more migration information, please visit https://google.github.io/accompanist/pager/#migration\n")
    public static final Modifier pagerTabIndicatorOffset(Modifier $this$pagerTabIndicatorOffset, final PagerState pagerState, List<TabPosition> tabPositions, Function1<? super Integer, Integer> pageIndexMapping) {
        Intrinsics.checkNotNullParameter($this$pagerTabIndicatorOffset, "<this>");
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Intrinsics.checkNotNullParameter(tabPositions, "tabPositions");
        Intrinsics.checkNotNullParameter(pageIndexMapping, "pageIndexMapping");
        return pagerTabIndicatorOffset($this$pagerTabIndicatorOffset, new PagerStateBridge() { // from class: com.google.accompanist.pager.PagerTabKt$pagerTabIndicatorOffset$stateBridge$1
            @Override // com.google.accompanist.pager.PagerStateBridge
            public int getCurrentPage() {
                return pagerState.getCurrentPage();
            }

            @Override // com.google.accompanist.pager.PagerStateBridge
            public float getCurrentPageOffset() {
                return pagerState.getCurrentPageOffset();
            }
        }, tabPositions, pageIndexMapping);
    }

    public static /* synthetic */ Modifier pagerTabIndicatorOffset$default(Modifier modifier, androidx.compose.foundation.pager.PagerState pagerState, List list, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: com.google.accompanist.pager.PagerTabKt.pagerTabIndicatorOffset.2
                public final Integer invoke(int it) {
                    return Integer.valueOf(it);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return pagerTabIndicatorOffset(modifier, pagerState, (List<TabPosition>) list, (Function1<? super Integer, Integer>) function1);
    }

    @Deprecated(message = "\n   pagerTabIndicatorOffset for accompanist Pagers are deprecated, please use the version that takes \n   androidx.compose.foundation.pager.PagerState instead\nFor more migration information, please visit https://google.github.io/accompanist/pager/#migration\n")
    public static final Modifier pagerTabIndicatorOffset(Modifier $this$pagerTabIndicatorOffset, final androidx.compose.foundation.pager.PagerState pagerState, List<TabPosition> tabPositions, Function1<? super Integer, Integer> pageIndexMapping) {
        Intrinsics.checkNotNullParameter($this$pagerTabIndicatorOffset, "<this>");
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Intrinsics.checkNotNullParameter(tabPositions, "tabPositions");
        Intrinsics.checkNotNullParameter(pageIndexMapping, "pageIndexMapping");
        return pagerTabIndicatorOffset($this$pagerTabIndicatorOffset, new PagerStateBridge() { // from class: com.google.accompanist.pager.PagerTabKt$pagerTabIndicatorOffset$stateBridge$2
            @Override // com.google.accompanist.pager.PagerStateBridge
            public int getCurrentPage() {
                return pagerState.getCurrentPage();
            }

            @Override // com.google.accompanist.pager.PagerStateBridge
            public float getCurrentPageOffset() {
                return pagerState.getCurrentPageOffsetFraction();
            }
        }, tabPositions, pageIndexMapping);
    }

    static /* synthetic */ Modifier pagerTabIndicatorOffset$default(Modifier modifier, PagerStateBridge pagerStateBridge, List list, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: com.google.accompanist.pager.PagerTabKt.pagerTabIndicatorOffset.3
                public final Integer invoke(int it) {
                    return Integer.valueOf(it);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return pagerTabIndicatorOffset(modifier, pagerStateBridge, (List<TabPosition>) list, (Function1<? super Integer, Integer>) function1);
    }

    private static final Modifier pagerTabIndicatorOffset(Modifier $this$pagerTabIndicatorOffset, final PagerStateBridge pagerState, final List<TabPosition> list, final Function1<? super Integer, Integer> function1) {
        return LayoutModifierKt.layout($this$pagerTabIndicatorOffset, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: com.google.accompanist.pager.PagerTabKt.pagerTabIndicatorOffset.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m7189invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m7189invoke3p2s80s(MeasureScope layout, Measurable measurable, final long constraints) {
                int i;
                int i2;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Intrinsics.checkNotNullParameter(measurable, "measurable");
                if (list.isEmpty()) {
                    return MeasureScope.CC.layout$default(layout, Constraints.m6744getMaxWidthimpl(constraints), 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.google.accompanist.pager.PagerTabKt.pagerTabIndicatorOffset.4.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope layout2) {
                            Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                        }
                    }, 4, null);
                }
                int currentPage = Math.min(CollectionsKt.getLastIndex(list), function1.invoke(Integer.valueOf(pagerState.getCurrentPage())).intValue());
                TabPosition currentTab = list.get(currentPage);
                TabPosition previousTab = (TabPosition) CollectionsKt.getOrNull(list, currentPage - 1);
                TabPosition nextTab = (TabPosition) CollectionsKt.getOrNull(list, currentPage + 1);
                float fraction = pagerState.getCurrentPageOffset();
                if (fraction > 0.0f && nextTab != null) {
                    i = layout.mo561roundToPx0680j_4(DpKt.m6844lerpMdfbLM(currentTab.getWidth(), nextTab.getWidth(), fraction));
                } else if (fraction < 0.0f && previousTab != null) {
                    i = layout.mo561roundToPx0680j_4(DpKt.m6844lerpMdfbLM(currentTab.getWidth(), previousTab.getWidth(), -fraction));
                } else {
                    i = layout.mo561roundToPx0680j_4(currentTab.getWidth());
                }
                int indicatorWidth = i;
                if (fraction > 0.0f && nextTab != null) {
                    i2 = layout.mo561roundToPx0680j_4(DpKt.m6844lerpMdfbLM(currentTab.getLeft(), nextTab.getLeft(), fraction));
                } else if (fraction < 0.0f && previousTab != null) {
                    i2 = layout.mo561roundToPx0680j_4(DpKt.m6844lerpMdfbLM(currentTab.getLeft(), previousTab.getLeft(), -fraction));
                } else {
                    i2 = layout.mo561roundToPx0680j_4(currentTab.getLeft());
                }
                final int indicatorOffset = i2;
                final Placeable placeable = measurable.mo5644measureBRTryo0(ConstraintsKt.Constraints(indicatorWidth, indicatorWidth, 0, Constraints.m6743getMaxHeightimpl(constraints)));
                return MeasureScope.CC.layout$default(layout, Constraints.m6744getMaxWidthimpl(constraints), Math.max(placeable.getHeight(), Constraints.m6745getMinHeightimpl(constraints)), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.google.accompanist.pager.PagerTabKt.pagerTabIndicatorOffset.4.2
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
                    public final void invoke2(Placeable.PlacementScope layout2) {
                        Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                        Placeable.PlacementScope.placeRelative$default(layout2, placeable, indicatorOffset, Math.max(Constraints.m6745getMinHeightimpl(constraints) - placeable.getHeight(), 0), 0.0f, 4, null);
                    }
                }, 4, null);
            }
        });
    }
}
