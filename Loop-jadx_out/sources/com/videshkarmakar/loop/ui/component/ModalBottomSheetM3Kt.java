package com.videshkarmakar.loop.ui.component;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ModalBottomSheet_androidKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SheetValue;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: ModalBottomSheetM3.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001aY\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001e\b\u0002\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"DrawerSheetSubtitle", "", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "color", "Landroidx/compose/ui/graphics/Color;", "DrawerSheetSubtitle-FNF3uiM", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;JLandroidx/compose/runtime/Composer;II)V", "LoopModalBottomSheet", "sheetState", "Landroidx/compose/material3/SheetState;", "onDismissRequest", "Lkotlin/Function0;", "horizontalPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ModalBottomSheetM3Kt {
    public static final void LoopModalBottomSheet(Modifier modifier, SheetState sheetState, final Function0<Unit> onDismissRequest, PaddingValues horizontalPadding, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        SheetState sheetState2;
        PaddingValues horizontalPadding2;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function4;
        SheetState sheetState3;
        SheetState sheetState4;
        int $dirty;
        Modifier modifier3;
        final PaddingValues horizontalPadding3;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3M7147getLambda1$app_debug;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer $composer3 = $composer.startRestartGroup(-1419673684);
        ComposerKt.sourceInformation($composer3, "C(LoopModalBottomSheet)P(2,4,3,1)30@1226L7,42@1645L353,37@1453L545:ModalBottomSheetM3.kt#g7nzpb");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                sheetState2 = sheetState;
                int i3 = $composer3.changed(sheetState2) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                sheetState2 = sheetState;
            }
            $dirty2 |= i3;
        } else {
            sheetState2 = sheetState;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changedInstance(onDismissRequest) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            horizontalPadding2 = horizontalPadding;
        } else if (($changed & 7168) == 0) {
            horizontalPadding2 = horizontalPadding;
            $dirty2 |= $composer3.changed(horizontalPadding2) ? 2048 : 1024;
        } else {
            horizontalPadding2 = horizontalPadding;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            function4 = function3;
        } else if ((57344 & $changed) == 0) {
            function4 = function3;
            $dirty2 |= $composer3.changedInstance(function4) ? 16384 : 8192;
        } else {
            function4 = function3;
        }
        if ((46811 & $dirty2) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            sheetState4 = sheetState2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    sheetState3 = new SheetState(true, (Density) objConsume, SheetValue.Hidden, null, false, 24, null);
                    $dirty2 &= -113;
                } else {
                    sheetState3 = sheetState2;
                }
                if (i4 != 0) {
                    horizontalPadding2 = PaddingKt.m615PaddingValuesYgX7TsA$default(Dp.m6553constructorimpl(28), 0.0f, 2, null);
                }
                if (i5 != 0) {
                    sheetState4 = sheetState3;
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    function3M7147getLambda1$app_debug = ComposableSingletons$ModalBottomSheetM3Kt.INSTANCE.m7147getLambda1$app_debug();
                    horizontalPadding3 = horizontalPadding2;
                } else {
                    sheetState4 = sheetState3;
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    horizontalPadding3 = horizontalPadding2;
                    function3M7147getLambda1$app_debug = function4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty = $dirty2 & (-113);
                    modifier3 = modifier2;
                    sheetState4 = sheetState2;
                    horizontalPadding3 = horizontalPadding2;
                    function3M7147getLambda1$app_debug = function4;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    sheetState4 = sheetState2;
                    horizontalPadding3 = horizontalPadding2;
                    function3M7147getLambda1$app_debug = function4;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1419673684, $dirty, -1, "com.videshkarmakar.loop.ui.component.LoopModalBottomSheet (ModalBottomSheetM3.kt:36)");
            }
            Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function5 = function3M7147getLambda1$app_debug;
            $composer2 = $composer3;
            PaddingValues horizontalPadding4 = horizontalPadding3;
            ModalBottomSheet_androidKt.m2126ModalBottomSheetdYc4hso(onDismissRequest, modifier3, sheetState4, 0.0f, null, 0L, 0L, 0.0f, 0L, null, WindowInsetsKt.m689WindowInsetsa9UjIt4(Dp.m6553constructorimpl(0), Dp.m6553constructorimpl(0), Dp.m6553constructorimpl(0), Dp.m6553constructorimpl(0)), null, ComposableLambdaKt.rememberComposableLambda(1921291081, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ModalBottomSheetM3Kt.LoopModalBottomSheet.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope ModalBottomSheet, Composer $composer4, int $changed2) {
                    Function0<ComposeUiNode> function0;
                    Intrinsics.checkNotNullParameter(ModalBottomSheet, "$this$ModalBottomSheet");
                    ComposerKt.sourceInformation($composer4, "C43@1655L158,49@1917L11,47@1822L170:ModalBottomSheetM3.kt#g7nzpb");
                    if (($changed2 & 81) != 16 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1921291081, $changed2, -1, "com.videshkarmakar.loop.ui.component.LoopModalBottomSheet.<anonymous> (ModalBottomSheetM3.kt:43)");
                        }
                        Modifier modifier$iv = PaddingKt.padding(Modifier.INSTANCE, horizontalPadding3);
                        Function3<ColumnScope, Composer, Integer, Unit> function6 = function3M7147getLambda1$app_debug;
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function0 = constructor;
                            $composer4.createNode(function0);
                        } else {
                            function0 = constructor;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer4);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i6 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScope $this$invoke_u24lambda_u240 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1464110762, "C44@1740L9,45@1762L41:ModalBottomSheetM3.kt#g7nzpb");
                        function6.invoke($this$invoke_u24lambda_u240, $composer4, Integer.valueOf((((0 >> 6) & 112) | 6) & 14));
                        SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(28)), $composer4, 6);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        CommonComponentsKt.NavigationBarSpacer(SizeKt.fillMaxWidth$default(BackgroundKt.m206backgroundbw27NRU$default(Modifier.INSTANCE, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getSurfaceContainerHigh(), null, 2, null), 0.0f, 1, null), $composer4, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer2, (($dirty >> 6) & 14) | (($dirty << 3) & 112) | (($dirty << 3) & 896), 384, 3064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function4 = function5;
            horizontalPadding2 = horizontalPadding4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final SheetState sheetState5 = sheetState4;
            final PaddingValues paddingValues = horizontalPadding2;
            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function6 = function4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ModalBottomSheetM3Kt.LoopModalBottomSheet.2
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

                public final void invoke(Composer composer, int i6) {
                    ModalBottomSheetM3Kt.LoopModalBottomSheet(modifier5, sheetState5, onDismissRequest, paddingValues, function6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: DrawerSheetSubtitle-FNF3uiM, reason: not valid java name */
    public static final void m7173DrawerSheetSubtitleFNF3uiM(Modifier modifier, final String text, long color, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        int $dirty;
        Modifier modifier3;
        long color2;
        Modifier modifier4;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(116273271);
        ComposerKt.sourceInformation($composer3, "C(DrawerSheetSubtitle)P(1,2,0:c#ui.graphics.Color)59@2125L11,67@2354L10,61@2154L227:ModalBottomSheetM3.kt#g7nzpb");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changed(text) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                j = color;
                int i3 = $composer3.changed(j) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                j = color;
            }
            $dirty2 |= i3;
        } else {
            j = color;
        }
        if (($dirty2 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier2;
            color2 = j;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    $dirty = $dirty2 & (-897);
                    modifier3 = modifier5;
                    color2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary();
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier5;
                    color2 = j;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                color2 = j;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(116273271, $dirty, -1, "com.videshkarmakar.loop.ui.component.DrawerSheetSubtitle (ModalBottomSheetM3.kt:60)");
            }
            modifier4 = modifier3;
            $composer2 = $composer3;
            TextKt.m2569Text4IGK_g(text, PaddingKt.m624paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), Dp.m6553constructorimpl(4), Dp.m6553constructorimpl(16), 0.0f, Dp.m6553constructorimpl(8), 4, null), color2, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelLarge(), $composer2, (($dirty >> 3) & 14) | ($dirty & 896), 0, 65528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final long j2 = color2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ModalBottomSheetM3Kt$DrawerSheetSubtitle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i4) {
                    ModalBottomSheetM3Kt.m7173DrawerSheetSubtitleFNF3uiM(modifier6, text, j2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
