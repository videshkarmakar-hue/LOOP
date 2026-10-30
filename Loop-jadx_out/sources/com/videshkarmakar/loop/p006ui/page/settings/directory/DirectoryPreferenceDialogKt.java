package com.videshkarmakar.loop.p006ui.page.settings.directory;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.component.ButtonsKt;
import com.videshkarmakar.loop.p006ui.component.DialogsKt;
import com.videshkarmakar.loop.p006ui.component.DividerKt;
import com.videshkarmakar.loop.p006ui.page.settings.general.GeneralDownloadPreferencesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.p013io.IOUtils;

/* JADX INFO: compiled from: DirectoryPreferenceDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m194d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001ag\u0010\u0000\u001a\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000528\b\u0002\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010\u0010\u001a\u00020\u0005X\u008a\u008e\u0002"}, m195d2 = {"DirectoryPreferenceDialog", "", "onDismissRequest", "Lkotlin/Function0;", "isWebsiteSelected", "", "isPlaylistTitleSelected", "onConfirm", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function0;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DirectoryPreferenceDialogPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "website", "playlistTitle"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DirectoryPreferenceDialogKt {
    public static final void DirectoryPreferenceDialog(Function0<Unit> function0, final boolean isWebsiteSelected, final boolean isPlaylistTitleSelected, Function2<? super Boolean, ? super Boolean, Unit> function2, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function1;
        Function2<? super Boolean, ? super Boolean, Unit> function3;
        Object value$iv;
        Object value$iv2;
        Function0<Unit> function4;
        Composer $composer2 = $composer.startRestartGroup(-837373623);
        ComposerKt.sourceInformation($composer2, "C(DirectoryPreferenceDialog)P(3,1)34@1495L58,37@1579L64,43@1730L138,49@1894L88,62@2260L1632,41@1649L2244:DirectoryPreferenceDialog.kt#rl3ivv");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            function1 = function0;
        } else if (($changed & 14) == 0) {
            function1 = function0;
            $dirty |= $composer2.changedInstance(function1) ? 4 : 2;
        } else {
            function1 = function0;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(isWebsiteSelected) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(isPlaylistTitleSelected) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            function3 = function2;
        } else if (($changed & 7168) == 0) {
            function3 = function2;
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        } else {
            function3 = function2;
        }
        if (($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function4 = function1;
        } else {
            final C36601 c36601 = i2 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DirectoryPreferenceDialogKt.DirectoryPreferenceDialog.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function1;
            final C36612 c36612 = i3 != 0 ? new Function2<Boolean, Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DirectoryPreferenceDialogKt.DirectoryPreferenceDialog.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                    invoke(bool.booleanValue(), bool2.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z, boolean z2) {
                }
            } : function3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-837373623, $dirty, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DirectoryPreferenceDialog (DirectoryPreferenceDialog.kt:33)");
            }
            $composer2.startReplaceGroup(-1314423728);
            ComposerKt.sourceInformation($composer2, "CC(remember):DirectoryPreferenceDialog.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(isWebsiteSelected), null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState website$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(-1314423644);
            ComposerKt.sourceInformation($composer2, "CC(remember):DirectoryPreferenceDialog.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(isPlaylistTitleSelected), null, 2, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableState playlistTitle$delegate = (MutableState) value$iv2;
            $composer2.endReplaceGroup();
            DialogsKt.m7298LoopDialogOix01E0(null, c36601, ComposableLambdaKt.rememberComposableLambda(1458354916, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DirectoryPreferenceDialogKt.DirectoryPreferenceDialog.3
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
                    Object value$iv3;
                    ComposerKt.sourceInformation($composer3, "C44@1758L100,44@1744L114:DirectoryPreferenceDialog.kt#rl3ivv");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1458354916, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DirectoryPreferenceDialog.<anonymous> (DirectoryPreferenceDialog.kt:44)");
                    }
                    $composer3.startReplaceGroup(1225495032);
                    ComposerKt.sourceInformation($composer3, "CC(remember):DirectoryPreferenceDialog.kt#9igjgp");
                    boolean invalid$iv = $composer3.changed(c36612) | $composer3.changed(c36601);
                    final Function2<Boolean, Boolean, Unit> function5 = c36612;
                    final Function0<Unit> function6 = c36601;
                    final MutableState<Boolean> mutableState = website$delegate;
                    final MutableState<Boolean> mutableState2 = playlistTitle$delegate;
                    Object it$iv3 = $composer3.rememberedValue();
                    if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DirectoryPreferenceDialogKt$DirectoryPreferenceDialog$3$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function5.invoke(Boolean.valueOf(DirectoryPreferenceDialogKt.DirectoryPreferenceDialog$lambda$1(mutableState)), Boolean.valueOf(DirectoryPreferenceDialogKt.DirectoryPreferenceDialog$lambda$4(mutableState2)));
                                function6.invoke();
                            }
                        };
                        $composer3.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv3;
                    }
                    $composer3.endReplaceGroup();
                    ButtonsKt.ConfirmButton(null, false, (Function0) value$iv3, $composer3, 0, 3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(-2037037851, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DirectoryPreferenceDialogKt.DirectoryPreferenceDialog.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv3;
                    ComposerKt.sourceInformation($composer3, "C50@1922L50,50@1908L64:DirectoryPreferenceDialog.kt#rl3ivv");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2037037851, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DirectoryPreferenceDialog.<anonymous> (DirectoryPreferenceDialog.kt:50)");
                    }
                    $composer3.startReplaceGroup(1225495196);
                    ComposerKt.sourceInformation($composer3, "CC(remember):DirectoryPreferenceDialog.kt#9igjgp");
                    boolean invalid$iv = $composer3.changed(c36601);
                    final Function0<Unit> function5 = c36601;
                    Object it$iv3 = $composer3.rememberedValue();
                    if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DirectoryPreferenceDialogKt$DirectoryPreferenceDialog$4$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function5.invoke();
                            }
                        };
                        $composer3.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv3;
                    }
                    $composer3.endReplaceGroup();
                    ButtonsKt.DismissButton(null, (Function0) value$iv3, $composer3, 0, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableSingletons$DirectoryPreferenceDialogKt.INSTANCE.m7469getLambda1$app_debug(), ComposableSingletons$DirectoryPreferenceDialogKt.INSTANCE.m7470getLambda2$app_debug(), ComposableLambdaKt.rememberComposableLambda(361685736, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DirectoryPreferenceDialogKt.DirectoryPreferenceDialog.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function5;
                    Object value$iv3;
                    Object value$iv4;
                    ComposerKt.sourceInformation($composer3, "C63@2274L1608:DirectoryPreferenceDialog.kt#rl3ivv");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(361685736, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DirectoryPreferenceDialog.<anonymous> (DirectoryPreferenceDialog.kt:63)");
                        }
                        final MutableState<Boolean> mutableState = website$delegate;
                        final MutableState<Boolean> mutableState2 = playlistTitle$delegate;
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
                            function5 = constructor;
                            $composer3.createNode(function5);
                        } else {
                            function5 = constructor;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i4 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i5 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 660127542, "C65@2332L47,64@2299L233,69@2549L40,70@2606L83,72@2753L37,74@2848L58,71@2706L200,78@2970L44,80@3078L70,77@2923L225,83@3165L83,84@3265L40,93@3589L42,92@3556L312:DirectoryPreferenceDialog.kt#rl3ivv");
                        TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.subdirectory_desc, $composer3, 0), PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 48, 0, 131068);
                        SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8)), $composer3, 6);
                        DividerKt.m7300HorizontalDivideriJQMabo(PaddingKt.m869paddingVpY3zN4(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24), C1979Dp.m6801constructorimpl(4)), 0L, $composer3, 6, 2);
                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.website, $composer3, 0);
                        boolean zDirectoryPreferenceDialog$lambda$1 = DirectoryPreferenceDialogKt.DirectoryPreferenceDialog$lambda$1(mutableState);
                        $composer3.startReplaceGroup(660128091);
                        ComposerKt.sourceInformation($composer3, "CC(remember):DirectoryPreferenceDialog.kt#9igjgp");
                        Object it$iv3 = $composer3.rememberedValue();
                        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DirectoryPreferenceDialogKt$DirectoryPreferenceDialog$5$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    DirectoryPreferenceDialogKt.DirectoryPreferenceDialog$lambda$2(mutableState, !DirectoryPreferenceDialogKt.DirectoryPreferenceDialog$lambda$1(mutableState));
                                }
                            };
                            $composer3.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = it$iv3;
                        }
                        $composer3.endReplaceGroup();
                        GeneralDownloadPreferencesKt.DialogCheckBoxItem(null, strStringResource, zDirectoryPreferenceDialog$lambda$1, (Function0) value$iv3, $composer3, 3072, 1);
                        String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.playlist_title, $composer3, 0);
                        boolean zDirectoryPreferenceDialog$lambda$4 = DirectoryPreferenceDialogKt.DirectoryPreferenceDialog$lambda$4(mutableState2);
                        $composer3.startReplaceGroup(660128321);
                        ComposerKt.sourceInformation($composer3, "CC(remember):DirectoryPreferenceDialog.kt#9igjgp");
                        Object it$iv4 = $composer3.rememberedValue();
                        if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                            value$iv4 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DirectoryPreferenceDialogKt$DirectoryPreferenceDialog$5$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    DirectoryPreferenceDialogKt.DirectoryPreferenceDialog$lambda$5(mutableState2, !DirectoryPreferenceDialogKt.DirectoryPreferenceDialog$lambda$4(mutableState2));
                                }
                            };
                            $composer3.updateRememberedValue(value$iv4);
                        } else {
                            value$iv4 = it$iv4;
                        }
                        $composer3.endReplaceGroup();
                        GeneralDownloadPreferencesKt.DialogCheckBoxItem(null, strStringResource2, zDirectoryPreferenceDialog$lambda$4, (Function0) value$iv4, $composer3, 3072, 1);
                        DividerKt.m7300HorizontalDivideriJQMabo(PaddingKt.m869paddingVpY3zN4(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24), C1979Dp.m6801constructorimpl(4)), 0L, $composer3, 6, 2);
                        SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(4)), $composer3, 6);
                        StringBuilder $this$invoke_u24lambda_u243_u24lambda_u242 = new StringBuilder(".../");
                        if (DirectoryPreferenceDialogKt.DirectoryPreferenceDialog$lambda$1(mutableState)) {
                            $this$invoke_u24lambda_u243_u24lambda_u242.append("website/");
                        }
                        if (DirectoryPreferenceDialogKt.DirectoryPreferenceDialog$lambda$4(mutableState2)) {
                            $this$invoke_u24lambda_u243_u24lambda_u242.append("playlist_title/");
                        }
                        TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.subdirectory_hint, $composer3, 0) + IOUtils.LINE_SEPARATOR_UNIX + ((Object) $this$invoke_u24lambda_u243_u24lambda_u242.append("file_name")), PaddingKt.m870paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(24), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 48, 0, 131068);
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
            }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty << 3) & 112) | 1797504, 0, 16257);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function4 = c36601;
            function3 = c36612;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function0<Unit> function5 = function4;
            final Function2<? super Boolean, ? super Boolean, Unit> function6 = function3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DirectoryPreferenceDialogKt.DirectoryPreferenceDialog.6
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

                public final void invoke(Composer composer, int i4) {
                    DirectoryPreferenceDialogKt.DirectoryPreferenceDialog(function5, isWebsiteSelected, isPlaylistTitleSelected, function6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DirectoryPreferenceDialog$lambda$1(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DirectoryPreferenceDialog$lambda$2(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DirectoryPreferenceDialog$lambda$4(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DirectoryPreferenceDialog$lambda$5(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DirectoryPreferenceDialogPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(173543667);
        ComposerKt.sourceInformation($composer2, "C(DirectoryPreferenceDialogPreview)106@3971L138:DirectoryPreferenceDialog.kt#rl3ivv");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(173543667, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DirectoryPreferenceDialogPreview (DirectoryPreferenceDialog.kt:105)");
            }
            DirectoryPreferenceDialog(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DirectoryPreferenceDialogKt.DirectoryPreferenceDialogPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, false, false, null, $composer2, 438, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DirectoryPreferenceDialogKt.DirectoryPreferenceDialogPreview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    DirectoryPreferenceDialogKt.DirectoryPreferenceDialogPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
