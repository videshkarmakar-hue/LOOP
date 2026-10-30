package com.videshkarmakar.loop.ui.component;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ModalBottomSheetDefaults;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModalBottomSheetM2.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001e\b\u0002\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"LoopModalBottomSheetM2", "", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material/ModalBottomSheetState;", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "horizontalPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ModalBottomSheetState;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ModalBottomSheetM2Kt {
    public static final void LoopModalBottomSheetM2(Modifier modifier, ModalBottomSheetState sheetState, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, PaddingValues horizontalPadding, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ModalBottomSheetState modalBottomSheetState;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function4;
        PaddingValues horizontalPadding2;
        final Modifier.Companion modifier3;
        ModalBottomSheetState sheetState2;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3M7145getLambda1$app_debug;
        final PaddingValues horizontalPadding3;
        Modifier modifier4;
        ModalBottomSheetState sheetState3;
        Composer $composer2 = $composer.startRestartGroup(-233753326);
        ComposerKt.sourceInformation($composer2, "C(LoopModalBottomSheetM2)P(1,3,2)34@1479L73,49@2031L11,51@2181L1713,40@1721L2182:ModalBottomSheetM2.kt#g7nzpb");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                modalBottomSheetState = sheetState;
                int i3 = $composer2.changed(modalBottomSheetState) ? 32 : 16;
                $dirty |= i3;
            } else {
                modalBottomSheetState = sheetState;
            }
            $dirty |= i3;
        } else {
            modalBottomSheetState = sheetState;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            function4 = function3;
        } else if (($changed & 896) == 0) {
            function4 = function3;
            $dirty |= $composer2.changedInstance(function4) ? 256 : 128;
        } else {
            function4 = function3;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            horizontalPadding2 = horizontalPadding;
        } else if (($changed & 7168) == 0) {
            horizontalPadding2 = horizontalPadding;
            $dirty |= $composer2.changed(horizontalPadding2) ? 2048 : 1024;
        } else {
            horizontalPadding2 = horizontalPadding;
        }
        if (($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            sheetState3 = modalBottomSheetState;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    sheetState2 = ModalBottomSheetKt.rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, null, null, false, $composer2, 6, 14);
                    $dirty &= -113;
                } else {
                    sheetState2 = modalBottomSheetState;
                }
                function3M7145getLambda1$app_debug = i4 != 0 ? ComposableSingletons$ModalBottomSheetM2Kt.INSTANCE.m7145getLambda1$app_debug() : function3;
                horizontalPadding3 = i5 != 0 ? PaddingKt.m615PaddingValuesYgX7TsA$default(Dp.m6553constructorimpl(28), 0.0f, 2, null) : horizontalPadding;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                modifier3 = modifier2;
                sheetState2 = modalBottomSheetState;
                horizontalPadding3 = horizontalPadding2;
                function3M7145getLambda1$app_debug = function4;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-233753326, $dirty, -1, "com.videshkarmakar.loop.ui.component.LoopModalBottomSheetM2 (ModalBottomSheetM2.kt:39)");
            }
            ModalBottomSheetKt.m1482ModalBottomSheetLayoutGs3lGvM(ComposableLambdaKt.rememberComposableLambda(250182436, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ModalBottomSheetM2Kt.LoopModalBottomSheetM2.1
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

                public final void invoke(ColumnScope ModalBottomSheetLayout, Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function0;
                    Intrinsics.checkNotNullParameter(ModalBottomSheetLayout, "$this$ModalBottomSheetLayout");
                    ComposerKt.sourceInformation($composer3, "C52@2195L1689:ModalBottomSheetM2.kt#g7nzpb");
                    if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(250182436, $changed2, -1, "com.videshkarmakar.loop.ui.component.LoopModalBottomSheetM2.<anonymous> (ModalBottomSheetM2.kt:52)");
                        }
                        final PaddingValues paddingValues = horizontalPadding3;
                        final Modifier modifier5 = modifier3;
                        final Function3<ColumnScope, Composer, Integer, Unit> function5 = function3M7145getLambda1$app_debug;
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function0 = constructor;
                            $composer3.createNode(function0);
                        } else {
                            function0 = constructor;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i6 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i7 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1649744047, "C54@2271L11,56@2362L1289,53@2220L1431,86@3779L11,84@3668L202:ModalBottomSheetM2.kt#g7nzpb");
                        SurfaceKt.m2418SurfaceT9BRK9s(null, null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurfaceContainer(), 0L, Dp.m6553constructorimpl(6), 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1200571059, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ModalBottomSheetM2Kt$LoopModalBottomSheetM2$1$1$1
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
                                Function0<ComposeUiNode> function1;
                                Function0<ComposeUiNode> function2;
                                Function0<ComposeUiNode> function6;
                                Function0<ComposeUiNode> function7;
                                ComposerKt.sourceInformation($composer4, "C57@2384L1249:ModalBottomSheetM2.kt#g7nzpb");
                                if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1200571059, $changed3, -1, "com.videshkarmakar.loop.ui.component.LoopModalBottomSheetM2.<anonymous>.<anonymous>.<anonymous> (ModalBottomSheetM2.kt:57)");
                                    }
                                    Modifier modifier$iv2 = PaddingKt.padding(Modifier.INSTANCE, paddingValues);
                                    Modifier modifier6 = modifier5;
                                    Function3<ColumnScope, Composer, Integer, Unit> function8 = function5;
                                    ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                    MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                    int $changed$iv$iv2 = (0 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                    CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer4.startReusableNode();
                                    if ($composer4.getInserting()) {
                                        function1 = constructor2;
                                        $composer4.createNode(function1);
                                    } else {
                                        function1 = constructor2;
                                        $composer4.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer4);
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                    }
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    int i9 = ((0 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, 1374774277, "C58@2462L907,77@3394L217:ModalBottomSheetM2.kt#g7nzpb");
                                    Modifier modifier$iv3 = SizeKt.fillMaxWidth$default(PaddingKt.m624paddingqDBjuR0$default(modifier6, 0.0f, Dp.m6553constructorimpl(8), 0.0f, 0.0f, 13, null), 0.0f, 1, null);
                                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
                                    Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                                    ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                                    int $changed$iv$iv3 = (432 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                    CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer4.startReusableNode();
                                    if ($composer4.getInserting()) {
                                        function2 = constructor3;
                                        $composer4.createNode(function2);
                                    } else {
                                        function2 = constructor3;
                                        $composer4.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer4);
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                        $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                        $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                                    }
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i10 = ($changed$iv$iv$iv3 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    int i11 = ((432 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1335294707, "C70@3091L11,65@2821L522:ModalBottomSheetM2.kt#g7nzpb");
                                    Modifier modifierClip = ClipKt.clip(SizeKt.m667sizeVpY3zN4(modifier6, Dp.m6553constructorimpl(32), Dp.m6553constructorimpl(4)), RoundedCornerShapeKt.getCircleShape());
                                    long onSurfaceVariant = MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant();
                                    Modifier modifier$iv4 = ZIndexModifierKt.zIndex(BackgroundKt.m206backgroundbw27NRU$default(modifierClip, Color.m4041copywmQWz5c(onSurfaceVariant, (14 & 1) != 0 ? Color.m4045getAlphaimpl(onSurfaceVariant) : 0.4f, (14 & 2) != 0 ? Color.m4049getRedimpl(onSurfaceVariant) : 0.0f, (14 & 4) != 0 ? Color.m4048getGreenimpl(onSurfaceVariant) : 0.0f, (14 & 8) != 0 ? Color.m4046getBlueimpl(onSurfaceVariant) : 0.0f), null, 2, null), 1.0f);
                                    ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                    Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                                    Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
                                    MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                    int $changed$iv$iv4 = (0 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                    CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
                                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer4.startReusableNode();
                                    if ($composer4.getInserting()) {
                                        function6 = constructor4;
                                        $composer4.createNode(function6);
                                    } else {
                                        function6 = constructor4;
                                        $composer4.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3547constructorimpl($composer4);
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv4.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                                        $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                                        $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash4);
                                    }
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i12 = ($changed$iv$iv$iv4 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                    int i13 = ((0 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, 1976646967, "C:ModalBottomSheetM2.kt#g7nzpb");
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    $composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    $composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                    Modifier modifier$iv5 = Modifier.INSTANCE;
                                    Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                                    Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                                    MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                    int $changed$iv$iv5 = (0 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv5 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                    CompositionLocalMap localMap$iv$iv5 = $composer4.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer4, modifier$iv5);
                                    Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                                    int $i$f$Column = $changed$iv$iv5 << 6;
                                    int $changed$iv$iv$iv5 = ($i$f$Column & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer4.startReusableNode();
                                    if ($composer4.getInserting()) {
                                        function7 = constructor5;
                                        $composer4.createNode(function7);
                                    } else {
                                        function7 = constructor5;
                                        $composer4.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.m3547constructorimpl($composer4);
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv5.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv5.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv5))) {
                                        $this$Layout_u24lambda_u240$iv$iv5.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv5));
                                        $this$Layout_u24lambda_u240$iv$iv5.apply(Integer.valueOf(compositeKeyHash$iv$iv5), setCompositeKeyHash5);
                                    }
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i14 = ($changed$iv$iv$iv5 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                    ColumnScope $this$invoke_u24lambda_u243_u24lambda_u242 = ColumnScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1335294097, "C78@3431L41,79@3501L14,80@3544L41:ModalBottomSheetM2.kt#g7nzpb");
                                    SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(40)), $composer4, 6);
                                    function8.invoke($this$invoke_u24lambda_u243_u24lambda_u242, $composer4, Integer.valueOf((((0 >> 6) & 112) | 6) & 14));
                                    SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(28)), $composer4, 6);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    $composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    $composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), $composer3, 12607488, 107);
                        CommonComponentsKt.NavigationBarSpacer(SizeKt.fillMaxWidth$default(BackgroundKt.m206backgroundbw27NRU$default(Modifier.INSTANCE, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurfaceContainerHigh(), null, 2, null), 0.0f, 1, null), $composer3, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), modifier3, sheetState2, false, RoundedCornerShapeKt.m899RoundedCornerShapea9UjIt4(Dp.m6553constructorimpl((float) 28.0d), Dp.m6553constructorimpl((float) 28.0d), Dp.m6553constructorimpl((float) 0.0d), Dp.m6553constructorimpl((float) 0.0d)), sheetState2.isVisible() ? ModalBottomSheetDefaults.INSTANCE.m1481getElevationD9Ej5fM() : Dp.m6553constructorimpl(0), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceContainer(), 0L, 0L, ComposableSingletons$ModalBottomSheetM2Kt.INSTANCE.m7146getLambda2$app_debug(), $composer2, (($dirty << 3) & 112) | 805306374 | (ModalBottomSheetState.$stable << 6) | (($dirty << 3) & 896), 392);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            horizontalPadding2 = horizontalPadding3;
            sheetState3 = sheetState2;
            function4 = function3M7145getLambda1$app_debug;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final ModalBottomSheetState modalBottomSheetState2 = sheetState3;
            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function5 = function4;
            final PaddingValues paddingValues = horizontalPadding2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ModalBottomSheetM2Kt.LoopModalBottomSheetM2.2
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
                    ModalBottomSheetM2Kt.LoopModalBottomSheetM2(modifier5, modalBottomSheetState2, function5, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
