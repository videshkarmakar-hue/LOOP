package com.videshkarmakar.loop.p006ui.page;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ContentPasteKt;
import androidx.compose.material.icons.outlined.DownloadingKt;
import androidx.compose.material.icons.outlined.FileDownloadKt;
import androidx.compose.material.icons.outlined.SettingsSuggestKt;
import androidx.compose.material.icons.outlined.SubscriptionsKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.vector.ImageVector;
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
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.component.DialogItemsKt;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: WelcomeDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m194d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\u001a'\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u008e\u0002"}, m195d2 = {"IconDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "description", "", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "WelcomeDialog", "onClick", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_debug", "showWelcomeDialog", "", "disableDialog", ""}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class WelcomeDialogKt {
    public static final void WelcomeDialog(final Function0<Unit> onClick, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer3 = $composer.startRestartGroup(911416043);
        ComposerKt.sourceInformation($composer3, "C(WelcomeDialog)37@1673L72,40@1771L34,41@1833L169,53@2256L199,49@2107L131,60@2519L1301,49@2042L1779:WelcomeDialog.kt#hmxj0r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onClick) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(911416043, $dirty2, -1, "com.videshkarmakar.loop.ui.page.WelcomeDialog (WelcomeDialog.kt:36)");
            }
            final MutableState showWelcomeDialog$delegate = (MutableState) RememberSaveableKt.m3889rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<MutableState<Integer>>() { // from class: com.videshkarmakar.loop.ui.page.WelcomeDialogKt$WelcomeDialog$showWelcomeDialog$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final MutableState<Integer> invoke() {
                    return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.WELCOME_DIALOG, 0, 1, null)), null, 2, null);
                }
            }, $composer3, 3080, 6);
            $composer3.startReplaceGroup(1743864004);
            ComposerKt.sourceInformation($composer3, "CC(remember):WelcomeDialog.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState disableDialog$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(1743864066);
            ComposerKt.sourceInformation($composer3, "CC(remember):WelcomeDialog.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(showWelcomeDialog$delegate);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.WelcomeDialogKt$WelcomeDialog$onDismissRequest$1$1
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
                        PreferenceUtil.INSTANCE.encodeInt(PreferenceUtilKt.WELCOME_DIALOG, WelcomeDialogKt.WelcomeDialog$lambda$3(disableDialog$delegate) ? 0 : WelcomeDialogKt.WelcomeDialog$lambda$0(showWelcomeDialog$delegate) + 1);
                        WelcomeDialogKt.WelcomeDialog$lambda$1(showWelcomeDialog$delegate, 0);
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final Function0 onDismissRequest = (Function0) value$iv2;
            $composer3.endReplaceGroup();
            if (WelcomeDialog$lambda$0(showWelcomeDialog$delegate) > 0) {
                $composer2 = $composer3;
                AndroidAlertDialog_androidKt.m1911AlertDialogOix01E0(onDismissRequest, ComposableLambdaKt.rememberComposableLambda(271529912, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.WelcomeDialogKt.WelcomeDialog.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer4, int $changed2) {
                        Object value$iv3;
                        ComposerKt.sourceInformation($composer4, "C54@2291L76,54@2270L175:WelcomeDialog.kt#hmxj0r");
                        if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(271529912, $changed2, -1, "com.videshkarmakar.loop.ui.page.WelcomeDialog.<anonymous> (WelcomeDialog.kt:54)");
                        }
                        $composer4.startReplaceGroup(418072429);
                        ComposerKt.sourceInformation($composer4, "CC(remember):WelcomeDialog.kt#9igjgp");
                        boolean invalid$iv2 = $composer4.changed(onClick) | $composer4.changed(onDismissRequest);
                        final Function0<Unit> function0 = onClick;
                        final Function0<Unit> function1 = onDismissRequest;
                        Object it$iv3 = $composer4.rememberedValue();
                        if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.WelcomeDialogKt$WelcomeDialog$1$1$1
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
                                    function0.invoke();
                                    function1.invoke();
                                }
                            };
                            $composer4.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = it$iv3;
                        }
                        $composer4.endReplaceGroup();
                        ButtonKt.TextButton((Function0) value$iv3, null, false, null, null, null, null, null, null, ComposableSingletons$WelcomeDialogKt.INSTANCE.m7318getLambda1$app_debug(), $composer4, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer3, 54), null, ComposableLambdaKt.rememberComposableLambda(-1010642374, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.WelcomeDialogKt.WelcomeDialog.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer4, int $changed2) {
                        ComposerKt.sourceInformation($composer4, "C50@2121L107:WelcomeDialog.kt#hmxj0r");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1010642374, $changed2, -1, "com.videshkarmakar.loop.ui.page.WelcomeDialog.<anonymous> (WelcomeDialog.kt:50)");
                            }
                            ButtonKt.TextButton(onDismissRequest, null, false, null, null, null, null, null, null, ComposableSingletons$WelcomeDialogKt.INSTANCE.m7319getLambda2$app_debug(), $composer4, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer3, 54), null, ComposableSingletons$WelcomeDialogKt.INSTANCE.m7320getLambda3$app_debug(), ComposableLambdaKt.rememberComposableLambda(1361066493, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.WelcomeDialogKt.WelcomeDialog.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer4, int $changed2) {
                        Function0<ComposeUiNode> function0;
                        ComposerKt.sourceInformation($composer4, "C61@2575L21,61@2533L1277:WelcomeDialog.kt#hmxj0r");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1361066493, $changed2, -1, "com.videshkarmakar.loop.ui.page.WelcomeDialog.<anonymous> (WelcomeDialog.kt:61)");
                            }
                            Modifier modifier$iv = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, null, false, 14, null);
                            MutableState<Integer> mutableState = showWelcomeDialog$delegate;
                            final MutableState<Boolean> mutableState2 = disableDialog$delegate;
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
                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                            }
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                            int i = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            int i2 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, 795239380, "C64@2724L35,62@2617L160,68@2901L38,66@2794L163,72@3082L46,70@2974L172,76@3269L46,74@3163L170,80@3460L53,78@3350L181:WelcomeDialog.kt#hmxj0r");
                            WelcomeDialogKt.IconDescription(null, ContentPasteKt.getContentPaste(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(C3070R.string.paste_desc, $composer4, 0), $composer4, 0, 1);
                            WelcomeDialogKt.IconDescription(null, FileDownloadKt.getFileDownload(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(C3070R.string.download_desc, $composer4, 0), $composer4, 0, 1);
                            WelcomeDialogKt.IconDescription(null, SubscriptionsKt.getSubscriptions(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(C3070R.string.download_history_desc, $composer4, 0), $composer4, 0, 1);
                            WelcomeDialogKt.IconDescription(null, DownloadingKt.getDownloading(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(C3070R.string.battery_settings_desc, $composer4, 0), $composer4, 0, 1);
                            WelcomeDialogKt.IconDescription(null, SettingsSuggestKt.getSettingsSuggest(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(C3070R.string.check_download_settings_desc, $composer4, 0), $composer4, 0, 1);
                            $composer4.startReplaceGroup(418073686);
                            ComposerKt.sourceInformation($composer4, "84@3642L52,85@3761L34,83@3597L199");
                            if (WelcomeDialogKt.WelcomeDialog$lambda$0(mutableState) > 1) {
                                String strStringResource = StringResources_androidKt.stringResource(C3070R.string.close_never_show_again, $composer4, 0);
                                boolean zWelcomeDialog$lambda$3 = WelcomeDialogKt.WelcomeDialog$lambda$3(mutableState2);
                                $composer4.startReplaceGroup(795240524);
                                ComposerKt.sourceInformation($composer4, "CC(remember):WelcomeDialog.kt#9igjgp");
                                Object value$iv3 = $composer4.rememberedValue();
                                if (value$iv3 == Composer.INSTANCE.getEmpty()) {
                                    value$iv3 = (Function1) new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.WelcomeDialogKt$WelcomeDialog$3$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                            invoke(bool.booleanValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(boolean it) {
                                            WelcomeDialogKt.WelcomeDialog$lambda$4(mutableState2, !WelcomeDialogKt.WelcomeDialog$lambda$3(mutableState2));
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv3);
                                }
                                $composer4.endReplaceGroup();
                                DialogItemsKt.CheckBoxItem(null, strStringResource, zWelcomeDialog$lambda$3, (Function1) value$iv3, $composer4, 3072, 1);
                            }
                            $composer4.endReplaceGroup();
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
                }, $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, 1772592, 0, 16276);
            } else {
                $composer2 = $composer3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.WelcomeDialogKt.WelcomeDialog.4
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
                    WelcomeDialogKt.WelcomeDialog(onClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int WelcomeDialog$lambda$0(MutableState<Integer> mutableState) {
        MutableState<Integer> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void WelcomeDialog$lambda$1(MutableState<Integer> mutableState, int value) {
        mutableState.setValue(Integer.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean WelcomeDialog$lambda$3(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void WelcomeDialog$lambda$4(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX WARN: Code duplicated, block: B:62:0x025b  */
    public static final void IconDescription(Modifier modifier, final ImageVector icon, final String description, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0<ComposeUiNode> function0;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(description, "description");
        Composer $composer3 = $composer.startRestartGroup(284344822);
        ComposerKt.sourceInformation($composer3, "C(IconDescription)P(2,1)92@3934L389:WelcomeDialog.kt#hmxj0r");
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
            $dirty |= $composer3.changed(icon) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(description) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer3.getSkipping()) {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(284344822, $dirty2, -1, "com.videshkarmakar.loop.ui.page.IconDescription (WelcomeDialog.kt:91)");
            }
            Modifier modifier$iv = PaddingKt.m872paddingqDBjuR0$default(modifier3, 0.0f, C1979Dp.m6801constructorimpl(12), 0.0f, C1979Dp.m6801constructorimpl(9), 5, null);
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
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
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                function0 = constructor;
            } else {
                function0 = constructor;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                int i4 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 1016227788, "C96@4075L130,101@4214L103:WelcomeDialog.kt#hmxj0r");
                IconKt.m2292Iconww6aTOc(icon, (String) null, SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), 0L, $composer3, (($dirty2 >> 3) & 14) | 432, 8);
                $composer2 = $composer3;
                TextKt.m2817Text4IGK_g(description, PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, (($dirty2 >> 6) & 14) | 48, 0, 131068);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            int i6 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1016227788, "C96@4075L130,101@4214L103:WelcomeDialog.kt#hmxj0r");
            IconKt.m2292Iconww6aTOc(icon, (String) null, SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), 0L, $composer3, (($dirty2 >> 3) & 14) | 432, 8);
            $composer2 = $composer3;
            TextKt.m2817Text4IGK_g(description, PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, (($dirty2 >> 6) & 14) | 48, 0, 131068);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.WelcomeDialogKt.IconDescription.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i7) {
                    WelcomeDialogKt.IconDescription(modifier4, icon, description, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
