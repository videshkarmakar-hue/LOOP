package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ClipKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.layout.SubcomposeLayoutKt;
import androidx.compose.p001ui.layout.SubcomposeMeasureScope;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a©\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000123\b\u0002\u0010\u0010\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u009f\u0001\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r23\b\u0002\u0010\u0010\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, m195d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "ScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "divider", "Lkotlin/Function0;", "tabs", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TabRow", "TabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = C1979Dp.m6801constructorimpl(90);
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    /* JADX INFO: renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    public static final void m1840TabRowpAZo6Ak(final int selectedTabIndex, Modifier modifier, long backgroundColor, long contentColor, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        long backgroundColor2;
        long contentColor2;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3RememberComposableLambda;
        Function2<? super Composer, ? super Integer, Unit> function5;
        Modifier modifier2;
        int $dirty;
        final Function2<? super Composer, ? super Integer, Unit> function2M1666getLambda1$material_release;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function6;
        long backgroundColor3;
        long contentColor3;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function7;
        Composer $composer2 = $composer.startRestartGroup(-249175289);
        ComposerKt.sourceInformation($composer2, "C(TabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)136@6719L6,137@6768L32,139@6907L139,154@7356L1387,150@7225L1518:TabRow.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(selectedTabIndex) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                backgroundColor2 = backgroundColor;
                int i3 = $composer2.changed(backgroundColor2) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty2 |= i3;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer2.changed(contentColor2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i4;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            function3RememberComposableLambda = function3;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            function3RememberComposableLambda = function3;
            $dirty2 |= $composer2.changedInstance(function3RememberComposableLambda) ? 16384 : 8192;
        } else {
            function3RememberComposableLambda = function3;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            function5 = function2;
        } else if ((196608 & $changed) == 0) {
            function5 = function2;
            $dirty2 |= $composer2.changedInstance(function5) ? 131072 : 65536;
        } else {
            function5 = function2;
        }
        if ((i & 64) != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changedInstance(function4) ? 1048576 : 524288;
        }
        if (($dirty2 & 599187) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            backgroundColor3 = backgroundColor2;
            contentColor3 = contentColor2;
            function7 = function3RememberComposableLambda;
            function6 = function5;
            modifier3 = modifier;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                    backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer2, 6));
                }
                if ((i & 8) != 0) {
                    long contentColor4 = ColorsKt.m1645contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 6) & 14);
                    $dirty2 &= -7169;
                    contentColor2 = contentColor4;
                }
                if (i5 != 0) {
                    function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-553782708, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer, Integer num) {
                            invoke((List<TabPosition>) list, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(List<TabPosition> list, Composer $composer3, int $changed2) {
                            ComposerKt.sourceInformation($composer3, "C140@6948L92:TabRow.kt#jmzs0o");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-553782708, $changed2, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:140)");
                            }
                            TabRowDefaults.INSTANCE.m1834Indicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(selectedTabIndex)), 0.0f, 0L, $composer3, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer2, 54);
                }
                if (i6 != 0) {
                    $dirty = $dirty2;
                    function2M1666getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1666getLambda1$material_release();
                    modifier2 = modifier4;
                } else {
                    modifier2 = modifier4;
                    $dirty = $dirty2;
                    function2M1666getLambda1$material_release = function5;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty = $dirty2 & (-7169);
                    function2M1666getLambda1$material_release = function5;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    $dirty = $dirty2;
                    function2M1666getLambda1$material_release = function5;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-249175289, $dirty, -1, "androidx.compose.material.TabRow (TabRow.kt:149)");
            }
            Modifier modifier5 = modifier2;
            SurfaceKt.m1809SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, backgroundColor2, contentColor2, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-1961746365, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv;
                    ComposerKt.sourceInformation($composer3, "C155@7408L1329,155@7366L1371:TabRow.kt#jmzs0o");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1961746365, $changed2, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:155)");
                    }
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart($composer3, -400687226, "CC(remember):TabRow.kt#9igjgp");
                    boolean invalid$iv = $composer3.changed(function4) | $composer3.changed(function2M1666getLambda1$material_release) | $composer3.changed(function3RememberComposableLambda);
                    final Function2<Composer, Integer, Unit> function8 = function4;
                    final Function2<Composer, Integer, Unit> function9 = function2M1666getLambda1$material_release;
                    final Function3<List<TabPosition>, Composer, Integer, Unit> function10 = function3RememberComposableLambda;
                    Object it$iv = $composer3.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                return m1842invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m1842invoke0kLqBqw(final SubcomposeMeasureScope $this$SubcomposeLayout, final long constraints) {
                                Object maxElem$iv;
                                final int tabRowWidth = Constraints.m6744getMaxWidthimpl(constraints);
                                List<Measurable> listSubcompose = $this$SubcomposeLayout.subcompose(TabSlots.Tabs, function8);
                                int tabCount = listSubcompose.size();
                                final int tabWidth = tabRowWidth / tabCount;
                                List target$iv = new ArrayList(listSubcompose.size());
                                int index$iv$iv = 0;
                                for (int size = listSubcompose.size(); index$iv$iv < size; size = size) {
                                    Object item$iv$iv = listSubcompose.get(index$iv$iv);
                                    Measurable it = (Measurable) item$iv$iv;
                                    target$iv.add(it.mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : tabWidth, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : tabWidth, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0)));
                                    index$iv$iv++;
                                }
                                final List tabPlaceables = target$iv;
                                if (!tabPlaceables.isEmpty()) {
                                    maxElem$iv = tabPlaceables.get(0);
                                    Placeable it2 = (Placeable) maxElem$iv;
                                    int maxValue$iv = it2.getHeight();
                                    int i$iv = 1;
                                    int lastIndex = CollectionsKt.getLastIndex(tabPlaceables);
                                    if (1 <= lastIndex) {
                                        while (true) {
                                            Object e$iv = tabPlaceables.get(i$iv);
                                            Placeable it3 = (Placeable) e$iv;
                                            int v$iv = it3.getHeight();
                                            if (maxValue$iv < v$iv) {
                                                maxElem$iv = e$iv;
                                                maxValue$iv = v$iv;
                                            }
                                            if (i$iv == lastIndex) {
                                                break;
                                            }
                                            i$iv++;
                                        }
                                    }
                                } else {
                                    maxElem$iv = null;
                                }
                                Placeable placeable = (Placeable) maxElem$iv;
                                final int tabRowHeight = placeable != null ? placeable.getHeight() : 0;
                                ArrayList arrayList = new ArrayList(tabCount);
                                for (int i7 = 0; i7 < tabCount; i7++) {
                                    int index = i7;
                                    float arg0$iv = $this$SubcomposeLayout.mo564toDpu2uoSUM(tabWidth);
                                    arrayList.add(new TabPosition(C1979Dp.m6801constructorimpl(index * arg0$iv), $this$SubcomposeLayout.mo564toDpu2uoSUM(tabWidth), null));
                                }
                                final ArrayList tabPositions = arrayList;
                                final Function2<Composer, Integer, Unit> function11 = function9;
                                final Function3<List<TabPosition>, Composer, Integer, Unit> function12 = function10;
                                return MeasureScope.CC.layout$default($this$SubcomposeLayout, tabRowWidth, tabRowHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1.1
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
                                        List<Placeable> list = tabPlaceables;
                                        int i8 = tabWidth;
                                        int size2 = list.size();
                                        for (int index$iv = 0; index$iv < size2; index$iv++) {
                                            Object item$iv = list.get(index$iv);
                                            int index2 = index$iv;
                                            Placeable.PlacementScope.placeRelative$default($this$layout, (Placeable) item$iv, index2 * i8, 0, 0.0f, 4, null);
                                        }
                                        List<Measurable> listSubcompose2 = $this$SubcomposeLayout.subcompose(TabSlots.Divider, function11);
                                        long j = constraints;
                                        int i9 = tabRowHeight;
                                        int size3 = listSubcompose2.size();
                                        int index$iv2 = 0;
                                        while (index$iv2 < size3) {
                                            Object item$iv2 = listSubcompose2.get(index$iv2);
                                            Measurable it4 = (Measurable) item$iv2;
                                            Placeable placeable2 = it4.mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(j, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(j) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(j) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(j) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(j) : 0));
                                            Placeable.PlacementScope.placeRelative$default($this$layout, placeable2, 0, i9 - placeable2.getHeight(), 0.0f, 4, null);
                                            index$iv2++;
                                            listSubcompose2 = listSubcompose2;
                                        }
                                        SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
                                        TabSlots tabSlots = TabSlots.Indicator;
                                        final Function3<List<TabPosition>, Composer, Integer, Unit> function13 = function12;
                                        final List<TabPosition> list2 = tabPositions;
                                        List<Measurable> listSubcompose3 = subcomposeMeasureScope.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-641946361, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.TabRow.2.1.1.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                invoke(composer, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer $composer4, int $changed3) {
                                                ComposerKt.sourceInformation($composer4, "C181@8543L23:TabRow.kt#jmzs0o");
                                                if (($changed3 & 3) == 2 && $composer4.getSkipping()) {
                                                    $composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-641946361, $changed3, -1, "androidx.compose.material.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:181)");
                                                }
                                                function13.invoke(list2, $composer4, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }));
                                        int i10 = tabRowWidth;
                                        int i11 = tabRowHeight;
                                        int size4 = listSubcompose3.size();
                                        for (int index$iv3 = 0; index$iv3 < size4; index$iv3++) {
                                            Object item$iv3 = listSubcompose3.get(index$iv3);
                                            Measurable it5 = (Measurable) item$iv3;
                                            Placeable.PlacementScope.placeRelative$default($this$layout, it5.mo5644measureBRTryo0(Constraints.INSTANCE.m6754fixedJhjzzOo(i10, i11)), 0, 0, 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    SubcomposeLayoutKt.SubcomposeLayout(modifierFillMaxWidth$default, (Function2) value$iv, $composer3, 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, ($dirty & 896) | 1572864 | ($dirty & 7168), 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            function6 = function2M1666getLambda1$material_release;
            backgroundColor3 = backgroundColor2;
            contentColor3 = contentColor2;
            function7 = function3RememberComposableLambda;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final long j = backgroundColor3;
            final long j2 = contentColor3;
            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function8 = function7;
            final Function2<? super Composer, ? super Integer, Unit> function9 = function6;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i7) {
                    TabRowKt.m1840TabRowpAZo6Ak(selectedTabIndex, modifier6, j, j2, function8, function9, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    public static final void m1839ScrollableTabRowsKfQg0A(final int selectedTabIndex, Modifier modifier, long backgroundColor, long contentColor, float edgePadding, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        long backgroundColor2;
        long contentColor2;
        float edgePadding2;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3RememberComposableLambda;
        Modifier.Companion modifier2;
        Function2<? super Composer, ? super Integer, Unit> function2M1667getLambda2$material_release;
        int $dirty;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function5;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function6;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function7;
        long backgroundColor3;
        long contentColor3;
        float edgePadding3;
        Composer $composer2 = $composer.startRestartGroup(-1473476840);
        ComposerKt.sourceInformation($composer2, "C(ScrollableTabRow)P(6,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)230@11351L6,231@11400L32,234@11601L139,249@12032L2913,245@11919L3026:TabRow.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(selectedTabIndex) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                backgroundColor2 = backgroundColor;
                int i3 = $composer2.changed(backgroundColor2) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty2 |= i3;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer2.changed(contentColor2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i4;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            edgePadding2 = edgePadding;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            edgePadding2 = edgePadding;
            $dirty2 |= $composer2.changed(edgePadding2) ? 16384 : 8192;
        } else {
            edgePadding2 = edgePadding;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            function3RememberComposableLambda = function3;
        } else if ((196608 & $changed) == 0) {
            function3RememberComposableLambda = function3;
            $dirty2 |= $composer2.changedInstance(function3RememberComposableLambda) ? 131072 : 65536;
        } else {
            function3RememberComposableLambda = function3;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changedInstance(function4) ? 8388608 : 4194304;
        }
        if (($dirty2 & 4793491) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function7 = function2;
            backgroundColor3 = backgroundColor2;
            contentColor3 = contentColor2;
            edgePadding3 = edgePadding2;
            function6 = function3RememberComposableLambda;
            modifier3 = modifier;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                    backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer2, 6));
                }
                if ((i & 8) != 0) {
                    long contentColor4 = ColorsKt.m1645contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 6) & 14);
                    $dirty2 &= -7169;
                    contentColor2 = contentColor4;
                }
                if (i5 != 0) {
                    edgePadding2 = TabRowDefaults.INSTANCE.m1837getScrollableTabRowPaddingD9Ej5fM();
                }
                if (i6 != 0) {
                    function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-655609869, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer, Integer num) {
                            invoke((List<TabPosition>) list, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(List<TabPosition> list, Composer $composer3, int $changed2) {
                            ComposerKt.sourceInformation($composer3, "C235@11642L92:TabRow.kt#jmzs0o");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-655609869, $changed2, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:235)");
                            }
                            TabRowDefaults.INSTANCE.m1834Indicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(selectedTabIndex)), 0.0f, 0L, $composer3, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer2, 54);
                }
                if (i7 != 0) {
                    function2M1667getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1667getLambda2$material_release();
                    $dirty = $dirty2;
                    function5 = function3RememberComposableLambda;
                } else {
                    function2M1667getLambda2$material_release = function2;
                    $dirty = $dirty2;
                    function5 = function3RememberComposableLambda;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    function2M1667getLambda2$material_release = function2;
                    $dirty = $dirty2 & (-7169);
                    function5 = function3RememberComposableLambda;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    function2M1667getLambda2$material_release = function2;
                    $dirty = $dirty2;
                    function5 = function3RememberComposableLambda;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1473476840, $dirty, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:244)");
            }
            final float f = edgePadding2;
            final Function2<? super Composer, ? super Integer, Unit> function8 = function2M1667getLambda2$material_release;
            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function9 = function5;
            Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function10 = function5;
            Function3 indicator = ComposableLambdaKt.rememberComposableLambda(1455860572, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv$iv;
                    Object value$iv;
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer3, "C250@12060L21,251@12111L24,252@12168L185,264@12604L2335,258@12362L2577:TabRow.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1455860572, $changed2, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:250)");
                        }
                        ScrollState scrollState = ScrollKt.rememberScrollState(0, $composer3, 0, 1);
                        ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart($composer3, -723523240, "CC(remember):Effects.kt#9igjgp");
                        Object it$iv$iv = $composer3.rememberedValue();
                        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                            $composer3.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                        }
                        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        CoroutineScope coroutineScope = wrapper$iv.getCoroutineScope();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1483971703, "CC(remember):TabRow.kt#9igjgp");
                        boolean invalid$iv = $composer3.changed(scrollState) | $composer3.changed(coroutineScope);
                        Object it$iv = $composer3.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new ScrollableTabData(scrollState, coroutineScope);
                            $composer3.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        final ScrollableTabData scrollableTabData = (ScrollableTabData) value$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifierClipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), scrollState, false, null, false, 14, null)));
                        ComposerKt.sourceInformationMarkerStart($composer3, 1483972139, "CC(remember):TabRow.kt#9igjgp");
                        boolean invalid$iv2 = $composer3.changed(f) | $composer3.changed(function4) | $composer3.changed(function8) | $composer3.changed(function9) | $composer3.changedInstance(scrollableTabData) | $composer3.changed(selectedTabIndex);
                        final float f2 = f;
                        final Function2<Composer, Integer, Unit> function11 = function4;
                        final Function2<Composer, Integer, Unit> function12 = function8;
                        final int i8 = selectedTabIndex;
                        final Function3<List<TabPosition>, Composer, Integer, Unit> function13 = function9;
                        Object it$iv2 = $composer3.rememberedValue();
                        if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                    return m1841invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                }

                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m1841invoke0kLqBqw(final SubcomposeMeasureScope $this$SubcomposeLayout, final long constraints) {
                                    int minTabWidth = $this$SubcomposeLayout.mo561roundToPx0680j_4(TabRowKt.ScrollableTabRowMinimumTabWidth);
                                    final int padding = $this$SubcomposeLayout.mo561roundToPx0680j_4(f2);
                                    long tabConstraints = Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : minTabWidth, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0);
                                    List<Measurable> listSubcompose = $this$SubcomposeLayout.subcompose(TabSlots.Tabs, function11);
                                    int $i$f$fastMap = 0;
                                    List target$iv = new ArrayList(listSubcompose.size());
                                    int index$iv$iv = 0;
                                    int size = listSubcompose.size();
                                    while (index$iv$iv < size) {
                                        Object item$iv$iv = listSubcompose.get(index$iv$iv);
                                        target$iv.add(((Measurable) item$iv$iv).mo5644measureBRTryo0(tabConstraints));
                                        index$iv$iv++;
                                        listSubcompose = listSubcompose;
                                        $i$f$fastMap = $i$f$fastMap;
                                    }
                                    final List tabPlaceables = target$iv;
                                    final Ref.IntRef layoutWidth = new Ref.IntRef();
                                    layoutWidth.element = padding * 2;
                                    final Ref.IntRef layoutHeight = new Ref.IntRef();
                                    List $this$fastForEach$iv = tabPlaceables;
                                    int $i$f$fastForEach = 0;
                                    int index$iv = 0;
                                    int size2 = $this$fastForEach$iv.size();
                                    while (index$iv < size2) {
                                        Object item$iv = $this$fastForEach$iv.get(index$iv);
                                        Placeable it = (Placeable) item$iv;
                                        List $this$fastForEach$iv2 = $this$fastForEach$iv;
                                        layoutWidth.element += it.getWidth();
                                        int i9 = layoutHeight.element;
                                        int $i$f$fastForEach2 = $i$f$fastForEach;
                                        int $i$f$fastForEach3 = it.getHeight();
                                        layoutHeight.element = Math.max(i9, $i$f$fastForEach3);
                                        index$iv++;
                                        $this$fastForEach$iv = $this$fastForEach$iv2;
                                        $i$f$fastForEach = $i$f$fastForEach2;
                                    }
                                    int i10 = layoutWidth.element;
                                    int i11 = layoutHeight.element;
                                    final Function2<Composer, Integer, Unit> function14 = function12;
                                    final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                    final int i12 = i8;
                                    final Function3<List<TabPosition>, Composer, Integer, Unit> function15 = function13;
                                    return MeasureScope.CC.layout$default($this$SubcomposeLayout, i10, i11, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2$1$1.2
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
                                            final List tabPositions = new ArrayList();
                                            int left = padding;
                                            List<Placeable> list = tabPlaceables;
                                            SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
                                            int size3 = list.size();
                                            for (int index$iv2 = 0; index$iv2 < size3; index$iv2++) {
                                                Object item$iv2 = list.get(index$iv2);
                                                Placeable it2 = (Placeable) item$iv2;
                                                Placeable.PlacementScope.placeRelative$default($this$layout, it2, left, 0, 0.0f, 4, null);
                                                tabPositions.add(new TabPosition(subcomposeMeasureScope.mo564toDpu2uoSUM(left), subcomposeMeasureScope.mo564toDpu2uoSUM(it2.getWidth()), null));
                                                left += it2.getWidth();
                                            }
                                            List<Measurable> listSubcompose2 = $this$SubcomposeLayout.subcompose(TabSlots.Divider, function14);
                                            long j = constraints;
                                            Ref.IntRef intRef = layoutWidth;
                                            Ref.IntRef intRef2 = layoutHeight;
                                            int index$iv3 = 0;
                                            for (int size4 = listSubcompose2.size(); index$iv3 < size4; size4 = size4) {
                                                Object item$iv3 = listSubcompose2.get(index$iv3);
                                                Measurable it3 = (Measurable) item$iv3;
                                                Placeable placeable = it3.mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(j, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(j) : intRef.element, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(j) : intRef.element, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(j) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(j) : 0));
                                                Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, intRef2.element - placeable.getHeight(), 0.0f, 4, null);
                                                index$iv3++;
                                            }
                                            SubcomposeMeasureScope subcomposeMeasureScope2 = $this$SubcomposeLayout;
                                            TabSlots tabSlots = TabSlots.Indicator;
                                            final Function3<List<TabPosition>, Composer, Integer, Unit> function16 = function15;
                                            List<Measurable> listSubcompose3 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-411868839, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.ScrollableTabRow.2.1.1.2.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                    invoke(composer, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer $composer4, int $changed3) {
                                                    ComposerKt.sourceInformation($composer4, "C306@14486L23:TabRow.kt#jmzs0o");
                                                    if (($changed3 & 3) == 2 && $composer4.getSkipping()) {
                                                        $composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-411868839, $changed3, -1, "androidx.compose.material.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:306)");
                                                    }
                                                    function16.invoke(tabPositions, $composer4, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }));
                                            Ref.IntRef intRef3 = layoutWidth;
                                            Ref.IntRef intRef4 = layoutHeight;
                                            int size5 = listSubcompose3.size();
                                            for (int index$iv4 = 0; index$iv4 < size5; index$iv4++) {
                                                Object item$iv4 = listSubcompose3.get(index$iv4);
                                                Measurable it4 = (Measurable) item$iv4;
                                                Placeable.PlacementScope.placeRelative$default($this$layout, it4.mo5644measureBRTryo0(Constraints.INSTANCE.m6754fixedJhjzzOo(intRef3.element, intRef4.element)), 0, 0, 0.0f, 4, null);
                                            }
                                            scrollableTabData2.onLaidOut($this$SubcomposeLayout, padding, tabPositions, i12);
                                        }
                                    }, 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        SubcomposeLayoutKt.SubcomposeLayout(modifierClipToBounds, (Function2) value$iv2, $composer3, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54);
            SurfaceKt.m1809SurfaceFjzlyU(modifier2, null, backgroundColor2, contentColor2, null, 0.0f, (Function2) indicator, $composer2, (($dirty >> 3) & 14) | 1572864 | ($dirty & 896) | ($dirty & 7168), 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = function10;
            modifier3 = modifier2;
            function7 = function2M1667getLambda2$material_release;
            backgroundColor3 = backgroundColor2;
            contentColor3 = contentColor2;
            edgePadding3 = edgePadding2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final long j = backgroundColor3;
            final long j2 = contentColor3;
            final float f2 = edgePadding3;
            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function11 = function6;
            final Function2<? super Composer, ? super Integer, Unit> function12 = function7;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i8) {
                    TabRowKt.m1839ScrollableTabRowsKfQg0A(selectedTabIndex, modifier4, j, j2, f2, function11, function12, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
