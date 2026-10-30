package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: AlertDialog.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a¦\u0001\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f¢\u0006\u0002\b\u00102\u0013\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f¢\u0006\u0002\b\u00102\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f¢\u0006\u0002\b\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a5\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00012\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\b\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, m195d2 = {"DialogMaxWidth", "Landroidx/compose/ui/unit/Dp;", "getDialogMaxWidth", "()F", "F", "DialogMinWidth", "getDialogMinWidth", "DialogPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "IconPadding", "TextPadding", "TitlePadding", "AlertDialogContent", "", "buttons", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "buttonContentColor", "iconContentColor", "titleContentColor", "textContentColor", "AlertDialogContent-4hvqGtA", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JFJJJJLandroidx/compose/runtime/Composer;III)V", "AlertDialogFlowRow", "mainAxisSpacing", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AlertDialogKt {
    private static final float DialogMinWidth = C1979Dp.m6801constructorimpl(280);
    private static final float DialogMaxWidth = C1979Dp.m6801constructorimpl(560);
    private static final PaddingValues DialogPadding = PaddingKt.m861PaddingValues0680j_4(C1979Dp.m6801constructorimpl(24));
    private static final PaddingValues IconPadding = PaddingKt.m865PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(16), 7, null);
    private static final PaddingValues TitlePadding = PaddingKt.m865PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(16), 7, null);
    private static final PaddingValues TextPadding = PaddingKt.m865PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(24), 7, null);

    /* JADX INFO: renamed from: AlertDialogContent-4hvqGtA, reason: not valid java name */
    public static final void m1909AlertDialogContent4hvqGtA(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final Shape shape, final long containerColor, final float tonalElevation, final long buttonContentColor, final long iconContentColor, final long titleContentColor, final long textContentColor, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(1522575799);
        ComposerKt.sourceInformation($composer3, "C(AlertDialogContent)P(1,5,3,9,7,6,2:c#ui.graphics.Color,11:c#ui.unit.Dp,0:c#ui.graphics.Color,4:c#ui.graphics.Color,10:c#ui.graphics.Color,8:c#ui.graphics.Color)59@2130L2305,54@1990L2445:AlertDialog.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function4) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer3.changedInstance(function5) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer3.changed(shape) ? 131072 : 65536;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changed(containerColor) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changed(tonalElevation) ? 8388608 : 4194304;
        }
        if ((i & 256) != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changed(buttonContentColor) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 512) != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changed(iconContentColor) ? 536870912 : 268435456;
        }
        int $dirty2 = $dirty;
        if ((i & 1024) != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changed(titleContentColor) ? 4 : 2;
        }
        if ((i & 2048) != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer3.changed(textContentColor) ? 32 : 16;
        }
        int $dirty3 = $dirty1;
        if ((306783379 & $dirty2) == 306783378 && ($dirty3 & 19) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            $composer2 = $composer3;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1522575799, $dirty2, $dirty3, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:53)");
            }
            $composer2 = $composer3;
            SurfaceKt.m2666SurfaceT9BRK9s(modifier3, shape, containerColor, 0L, tonalElevation, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-2126308228, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1
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

                /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r12v5 ??
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                    	at jadx.core.dex.visitors.ModVisitor.anonymousCallArgMod(ModVisitor.java:535)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:528)
                    	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:111)
                    	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                    */
                public final void invoke(androidx.compose.runtime.Composer r55, int r56) {
                    /*
                        Method dump skipped, instruction units count: 924
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }, $composer3, 54), $composer3, (($dirty2 >> 3) & 14) | 12582912 | (($dirty2 >> 12) & 112) | (($dirty2 >> 12) & 896) | (($dirty2 >> 9) & 57344), LocationRequestCompat.QUALITY_LOW_POWER);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$2
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

                public final void invoke(Composer composer, int i3) {
                    AlertDialogKt.m1909AlertDialogContent4hvqGtA(function2, modifier4, function3, function4, function5, shape, containerColor, tonalElevation, buttonContentColor, iconContentColor, titleContentColor, textContentColor, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    public static final void m1910AlertDialogFlowRowixp7dh8(final float mainAxisSpacing, final float crossAxisSpacing, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(586821353);
        ComposerKt.sourceInformation($composer2, "C(AlertDialogFlowRow)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp)131@4709L3306,131@4693L3322:AlertDialog.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(mainAxisSpacing) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(crossAxisSpacing) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(586821353, $dirty, -1, "androidx.compose.material3.AlertDialogFlowRow (AlertDialog.kt:130)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1133133510, "CC(remember):AlertDialog.kt#9igjgp");
            boolean invalid$iv = (($dirty & 14) == 4) | (($dirty & 112) == 32);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MeasurePolicy() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$1$1
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

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo285measure3p2s80s(final MeasureScope $this$Layout, List<? extends Measurable> list, long constraints) {
                        Ref.IntRef currentCrossAxisSize;
                        Ref.IntRef currentMainAxisSize;
                        Ref.IntRef currentMainAxisSize2;
                        final List sequences = new ArrayList();
                        List currentSequence = new ArrayList();
                        List crossAxisPositions = new ArrayList();
                        Ref.IntRef currentCrossAxisSize2 = new Ref.IntRef();
                        Ref.IntRef crossAxisSpace = new Ref.IntRef();
                        List currentSequence2 = new ArrayList();
                        Ref.IntRef currentMainAxisSize3 = new Ref.IntRef();
                        Ref.IntRef currentCrossAxisSize3 = new Ref.IntRef();
                        float f = mainAxisSpacing;
                        float f2 = crossAxisSpacing;
                        List<? extends Measurable> list2 = list;
                        int size = list2.size();
                        int index$iv = 0;
                        while (index$iv < size) {
                            Object item$iv = list2.get(index$iv);
                            Measurable measurable = (Measurable) item$iv;
                            List crossAxisPositions2 = crossAxisPositions;
                            Ref.IntRef mainAxisSpace = currentCrossAxisSize2;
                            Placeable placeable = measurable.mo5644measureBRTryo0(constraints);
                            int index$iv2 = index$iv;
                            int i = size;
                            float f3 = f2;
                            List<? extends Measurable> list3 = list2;
                            float f4 = f;
                            if (measure_3p2s80s$canAddToCurrentSequence(currentSequence2, currentMainAxisSize3, $this$Layout, f, constraints, placeable)) {
                                currentCrossAxisSize = currentCrossAxisSize3;
                                currentMainAxisSize = currentMainAxisSize3;
                            } else {
                                currentCrossAxisSize = currentCrossAxisSize3;
                                currentMainAxisSize = currentMainAxisSize3;
                                measure_3p2s80s$startNewSequence(sequences, crossAxisSpace, $this$Layout, f3, currentSequence2, currentSequence, currentCrossAxisSize, crossAxisPositions2, mainAxisSpace, currentMainAxisSize);
                            }
                            if (!currentSequence2.isEmpty()) {
                                currentMainAxisSize2 = currentMainAxisSize;
                                currentMainAxisSize2.element += $this$Layout.mo561roundToPx0680j_4(f4);
                            } else {
                                currentMainAxisSize2 = currentMainAxisSize;
                            }
                            currentSequence2.add(placeable);
                            currentMainAxisSize2.element += placeable.getWidth();
                            currentCrossAxisSize.element = Math.max(currentCrossAxisSize.element, placeable.getHeight());
                            index$iv = index$iv2 + 1;
                            currentMainAxisSize3 = currentMainAxisSize2;
                            currentSequence2 = currentSequence2;
                            f = f4;
                            currentCrossAxisSize3 = currentCrossAxisSize;
                            crossAxisPositions = crossAxisPositions2;
                            currentCrossAxisSize2 = mainAxisSpace;
                            size = i;
                            f2 = f3;
                            list2 = list3;
                            currentSequence = currentSequence;
                        }
                        List crossAxisSizes = currentSequence;
                        final List crossAxisPositions3 = crossAxisPositions;
                        Ref.IntRef mainAxisSpace2 = currentCrossAxisSize2;
                        Ref.IntRef mainAxisSpace3 = currentCrossAxisSize3;
                        List crossAxisSizes2 = currentSequence2;
                        Ref.IntRef currentMainAxisSize4 = currentMainAxisSize3;
                        if (!crossAxisSizes2.isEmpty()) {
                            measure_3p2s80s$startNewSequence(sequences, crossAxisSpace, $this$Layout, crossAxisSpacing, crossAxisSizes2, crossAxisSizes, mainAxisSpace3, crossAxisPositions3, mainAxisSpace2, currentMainAxisSize4);
                        }
                        final int mainAxisLayoutSize = Math.max(mainAxisSpace2.element, Constraints.m6746getMinWidthimpl(constraints));
                        int crossAxisLayoutSize = Math.max(crossAxisSpace.element, Constraints.m6745getMinHeightimpl(constraints));
                        final float f5 = mainAxisSpacing;
                        return MeasureScope.CC.layout$default($this$Layout, mainAxisLayoutSize, crossAxisLayoutSize, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$1$1.2
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
                                List<List<Placeable>> list4 = sequences;
                                MeasureScope measureScope = $this$Layout;
                                float f6 = f5;
                                int i2 = mainAxisLayoutSize;
                                List<Integer> list5 = crossAxisPositions3;
                                int size2 = list4.size();
                                for (int index$iv3 = 0; index$iv3 < size2; index$iv3++) {
                                    Object item$iv2 = list4.get(index$iv3);
                                    List<Placeable> list6 = (List) item$iv2;
                                    int i3 = index$iv3;
                                    int size3 = list6.size();
                                    int[] childrenMainAxisSizes = new int[size3];
                                    int i4 = 0;
                                    while (i4 < size3) {
                                        childrenMainAxisSizes[i4] = list6.get(i4).getWidth() + (i4 < CollectionsKt.getLastIndex(list6) ? measureScope.mo561roundToPx0680j_4(f6) : 0);
                                        i4++;
                                    }
                                    Arrangement.Horizontal arrangement = Arrangement.INSTANCE.getEnd();
                                    int length = childrenMainAxisSizes.length;
                                    int[] mainAxisPositions = new int[length];
                                    for (int i5 = 0; i5 < length; i5++) {
                                        mainAxisPositions[i5] = 0;
                                    }
                                    arrangement.arrange(measureScope, i2, childrenMainAxisSizes, measureScope.getLayoutDirection(), mainAxisPositions);
                                    int size4 = list6.size();
                                    for (int index$iv4 = 0; index$iv4 < size4; index$iv4++) {
                                        Object item$iv3 = list6.get(index$iv4);
                                        Placeable placeable2 = (Placeable) item$iv3;
                                        int j = index$iv4;
                                        Placeable.PlacementScope.place$default($this$layout, placeable2, mainAxisPositions[j], list5.get(i3).intValue(), 0.0f, 4, null);
                                    }
                                }
                            }
                        }, 4, null);
                    }

                    private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, Ref.IntRef currentMainAxisSize, MeasureScope $this_Layout, float $mainAxisSpacing, long $constraints, Placeable placeable) {
                        return list.isEmpty() || (currentMainAxisSize.element + $this_Layout.mo561roundToPx0680j_4($mainAxisSpacing)) + placeable.getWidth() <= Constraints.m6744getMaxWidthimpl($constraints);
                    }

                    private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> list, Ref.IntRef crossAxisSpace, MeasureScope $this_Layout, float $crossAxisSpacing, List<Placeable> list2, List<Integer> list3, Ref.IntRef currentCrossAxisSize, List<Integer> list4, Ref.IntRef mainAxisSpace, Ref.IntRef currentMainAxisSize) {
                        if (!list.isEmpty()) {
                            crossAxisSpace.element += $this_Layout.mo561roundToPx0680j_4($crossAxisSpacing);
                        }
                        list.add(0, CollectionsKt.toList(list2));
                        list3.add(Integer.valueOf(currentCrossAxisSize.element));
                        list4.add(Integer.valueOf(crossAxisSpace.element));
                        crossAxisSpace.element += currentCrossAxisSize.element;
                        mainAxisSpace.element = Math.max(mainAxisSpace.element, currentMainAxisSize.element);
                        list2.clear();
                        currentMainAxisSize.element = 0;
                        currentCrossAxisSize.element = 0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed$iv = ($dirty >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.INSTANCE;
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv = (($changed$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            function2.invoke($composer2, Integer.valueOf(($changed$iv$iv >> 6) & 14));
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$2
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

                public final void invoke(Composer composer, int i) {
                    AlertDialogKt.m1910AlertDialogFlowRowixp7dh8(mainAxisSpacing, crossAxisSpacing, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final float getDialogMinWidth() {
        return DialogMinWidth;
    }

    public static final float getDialogMaxWidth() {
        return DialogMaxWidth;
    }
}
