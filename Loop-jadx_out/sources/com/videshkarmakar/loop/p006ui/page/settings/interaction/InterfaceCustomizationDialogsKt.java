package com.videshkarmakar.loop.p006ui.page.settings.interaction;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.component.DialogItemsKt;
import com.videshkarmakar.loop.p006ui.component.DialogsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InterfaceCustomizationDialogs.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(m194d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aA\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\f¨\u0006\r"}, m195d2 = {"DownloadTypeCustomizationDialog", "", "modifier", "Landroidx/compose/ui/Modifier;", "onDismissRequest", "Lkotlin/Function0;", "selectedItem", "", "onSelect", "Lkotlin/Function1;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Preview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class InterfaceCustomizationDialogsKt {
    public static final void DownloadTypeCustomizationDialog(Modifier modifier, final Function0<Unit> onDismissRequest, final int selectedItem, final Function1<? super Integer, Unit> onSelect, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(onSelect, "onSelect");
        Composer $composer3 = $composer.startRestartGroup(519377253);
        ComposerKt.sourceInformation($composer3, "C(DownloadTypeCustomizationDialog)P(!2,3)29@1040L722,22@811L952:InterfaceCustomizationDialogs.kt#tb24dy");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(onDismissRequest) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(selectedItem) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changedInstance(onSelect) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            $composer2 = $composer3;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(519377253, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.interaction.DownloadTypeCustomizationDialog (InterfaceCustomizationDialogs.kt:21)");
            }
            $composer2 = $composer3;
            DialogsKt.m7298LoopDialogOix01E0(modifier3, onDismissRequest, null, null, null, ComposableSingletons$InterfaceCustomizationDialogsKt.INSTANCE.m7571getLambda1$app_debug(), ComposableLambdaKt.rememberComposableLambda(-2034154842, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.InterfaceCustomizationDialogsKt.DownloadTypeCustomizationDialog.1
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

                public final void invoke(Composer $composer4, int $changed2) {
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C30@1096L656,30@1054L698:InterfaceCustomizationDialogs.kt#tb24dy");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2034154842, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.interaction.DownloadTypeCustomizationDialog.<anonymous> (InterfaceCustomizationDialogs.kt:30)");
                    }
                    Modifier modifierM870paddingVpY3zN4$default = PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, 0.0f, 3, null);
                    $composer4.startReplaceGroup(-28373868);
                    ComposerKt.sourceInformation($composer4, "CC(remember):InterfaceCustomizationDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(selectedItem) | $composer4.changed(onSelect);
                    final int i3 = selectedItem;
                    final Function1<Integer, Unit> function1 = onSelect;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.InterfaceCustomizationDialogsKt$DownloadTypeCustomizationDialog$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                final int i4 = i3;
                                final Function1<Integer, Unit> function2 = function1;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1571745170, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.InterfaceCustomizationDialogsKt$DownloadTypeCustomizationDialog$1$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer5, int $changed3) {
                                        Object value$iv2;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C33@1196L52,35@1346L80,32@1141L285:InterfaceCustomizationDialogs.kt#tb24dy");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1571745170, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.interaction.DownloadTypeCustomizationDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InterfaceCustomizationDialogs.kt:32)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.use_previous_selection, $composer5, 0);
                                            boolean z = i4 == 1;
                                            $composer5.startReplaceGroup(1114087793);
                                            ComposerKt.sourceInformation($composer5, "CC(remember):InterfaceCustomizationDialogs.kt#9igjgp");
                                            boolean invalid$iv2 = $composer5.changed(function2);
                                            final Function1<Integer, Unit> function3 = function2;
                                            Object it$iv2 = $composer5.rememberedValue();
                                            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                                value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.InterfaceCustomizationDialogsKt$DownloadTypeCustomizationDialog$1$1$1$1$1$1
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
                                                        function3.invoke(1);
                                                    }
                                                };
                                                $composer5.updateRememberedValue(value$iv2);
                                            } else {
                                                value$iv2 = it$iv2;
                                            }
                                            $composer5.endReplaceGroup();
                                            DialogItemsKt.DialogSingleChoiceItem(null, strStringResource, z, (Function0) value$iv2, $composer5, 0, 1);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 3, null);
                                final int i5 = i3;
                                final Function1<Integer, Unit> function3 = function1;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(996965755, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.InterfaceCustomizationDialogsKt$DownloadTypeCustomizationDialog$1$1$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer5, int $changed3) {
                                        Object value$iv2;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C42@1544L34,44@1658L62,41@1489L231:InterfaceCustomizationDialogs.kt#tb24dy");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(996965755, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.interaction.DownloadTypeCustomizationDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InterfaceCustomizationDialogs.kt:41)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.none, $composer5, 0);
                                            boolean z = i5 == 0;
                                            $composer5.startReplaceGroup(1114088105);
                                            ComposerKt.sourceInformation($composer5, "CC(remember):InterfaceCustomizationDialogs.kt#9igjgp");
                                            boolean invalid$iv2 = $composer5.changed(function3);
                                            final Function1<Integer, Unit> function4 = function3;
                                            Object it$iv2 = $composer5.rememberedValue();
                                            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                                value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.InterfaceCustomizationDialogsKt$DownloadTypeCustomizationDialog$1$1$1$2$1$1
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
                                                        function4.invoke(0);
                                                    }
                                                };
                                                $composer5.updateRememberedValue(value$iv2);
                                            } else {
                                                value$iv2 = it$iv2;
                                            }
                                            $composer5.endReplaceGroup();
                                            DialogItemsKt.DialogSingleChoiceItem(null, strStringResource, z, (Function0) value$iv2, $composer5, 0, 1);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 3, null);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceGroup();
                    LazyDslKt.LazyColumn(modifierM870paddingVpY3zN4$default, null, null, false, null, null, null, false, (Function1) value$iv, $composer4, 6, 254);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, 1769856 | ($dirty2 & 14) | ($dirty2 & 112), 0, 16280);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.InterfaceCustomizationDialogsKt.DownloadTypeCustomizationDialog.2
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
                    InterfaceCustomizationDialogsKt.DownloadTypeCustomizationDialog(modifier4, onDismissRequest, selectedItem, onSelect, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Preview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1024147517);
        ComposerKt.sourceInformation($composer2, "C(Preview)55@1816L84:InterfaceCustomizationDialogs.kt#tb24dy");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1024147517, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.interaction.Preview (InterfaceCustomizationDialogs.kt:54)");
            }
            DownloadTypeCustomizationDialog(null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.InterfaceCustomizationDialogsKt.Preview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, 0, new Function1<Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.InterfaceCustomizationDialogsKt.Preview.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int it) {
                }
            }, $composer2, 3504, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.InterfaceCustomizationDialogsKt.Preview.3
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
                    InterfaceCustomizationDialogsKt.Preview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
