package com.videshkarmakar.loop.ui.component;

import android.view.View;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.SearchKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.ui.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBar.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\t\u001a\r\u0010\n\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000b¨\u0006\f²\u0006\n\u0010\u0004\u001a\u00020\u0005X\u008a\u008e\u0002"}, d2 = {"LoopSearchBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "placeholderText", "onValueChange", "Lkotlin/Function1;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "SearchBarPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SearchBarKt {
    public static final void LoopSearchBar(Modifier modifier, final String text, final String placeholderText, final Function1<? super String, Unit> onValueChange, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(placeholderText, "placeholderText");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer2 = $composer.startRestartGroup(863219429);
        ComposerKt.sourceInformation($composer2, "C(LoopSearchBar)P(!1,3,2)37@1424L7,42@1542L6,43@1587L11,44@1623L1366,39@1437L1552:SearchBar.kt#g7nzpb");
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
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(text) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(placeholderText) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(onValueChange) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(863219429, $dirty2, -1, "com.videshkarmakar.loop.ui.component.LoopSearchBar (SearchBar.kt:36)");
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localView);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final View view = (View) objConsume;
            SurfaceKt.m2418SurfaceT9BRK9s(SizeKt.m671widthInVpY3zN4(modifier4, Dp.m6553constructorimpl(360), Dp.m6553constructorimpl(720)), MaterialTheme.INSTANCE.getShapes($composer2, MaterialTheme.$stable).getMedium(), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceContainer(), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(611043882, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SearchBarKt.LoopSearchBar.1
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
                    ComposerKt.sourceInformation($composer3, "C45@1633L1350:SearchBar.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(611043882, $changed2, -1, "com.videshkarmakar.loop.ui.component.LoopSearchBar.<anonymous> (SearchBar.kt:45)");
                        }
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        final String str = text;
                        final Function1<String, Unit> function1 = onValueChange;
                        final String str2 = placeholderText;
                        final View view2 = view;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
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
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i3 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        int i4 = ((384 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u240 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1533873771, "C46@1699L40,50@1891L11,47@1752L181,57@2196L36,55@2077L32,58@2265L694,52@1946L1027:SearchBar.kt#g7nzpb");
                        SpacerKt.Spacer(SizeKt.m670width3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), $composer3, 6);
                        IconKt.m2044Iconww6aTOc(SearchKt.getSearch(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), $composer3, 48, 4);
                        TextFieldKt.LoopAutoFocusTextField(str, function1, RowScope.CC.weight$default($this$invoke_u24lambda_u240, Modifier.INSTANCE, 1.0f, false, 2, null), false, false, null, StringResources_androidKt.stringResource(R.string.search, $composer3, 0), null, ComposableLambdaKt.rememberComposableLambda(1274368779, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SearchBarKt$LoopSearchBar$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer4, int $changed3) {
                                ComposerKt.sourceInformation($composer4, "C55@2079L28:SearchBar.kt#g7nzpb");
                                if (($changed3 & 11) == 2 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1274368779, $changed3, -1, "com.videshkarmakar.loop.ui.component.LoopSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.kt:55)");
                                }
                                TextKt.m2569Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer3, 54), null, ComposableLambdaKt.rememberComposableLambda(1373288474, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SearchBarKt$LoopSearchBar$1$1$2
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
                                ComposerKt.sourceInformation($composer4, "C60@2336L583:SearchBar.kt#g7nzpb");
                                if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1373288474, $changed3, -1, "com.videshkarmakar.loop.ui.component.LoopSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.kt:59)");
                                    }
                                    if (str.length() > 0) {
                                        final Function1<String, Unit> function2 = function1;
                                        final View view3 = view2;
                                        IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.SearchBarKt$LoopSearchBar$1$1$2.1
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
                                                function2.invoke("");
                                                view3.performHapticFeedback(4);
                                            }
                                        }, null, false, null, null, ComposableSingletons$SearchBarKt.INSTANCE.m7151getLambda1$app_debug(), $composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), null, null, null, false, null, false, 0, 0, null, null, null, null, $composer3, 100663296, 6, 0, 8387256);
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
            }, $composer2, 54), $composer2, 12582912, 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SearchBarKt.LoopSearchBar.2
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
                    SearchBarKt.LoopSearchBar(modifier5, text, placeholderText, onValueChange, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SearchBarPreview(Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(998322607);
        ComposerKt.sourceInformation($composer2, "C(SearchBarPreview)81@3063L31,82@3109L199,82@3099L209:SearchBar.kt#g7nzpb");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(998322607, $changed, -1, "com.videshkarmakar.loop.ui.component.SearchBarPreview (SearchBar.kt:80)");
            }
            $composer2.startReplaceGroup(-286732467);
            ComposerKt.sourceInformation($composer2, "CC(remember):SearchBar.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState text$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            ThemeKt.LoopTheme(false, false, false, ComposableLambdaKt.rememberComposableLambda(850946406, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SearchBarKt.SearchBarPreview.1
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
                    ComposerKt.sourceInformation($composer3, "C83@3127L174,83@3119L182:SearchBar.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(850946406, $changed2, -1, "com.videshkarmakar.loop.ui.component.SearchBarPreview.<anonymous> (SearchBar.kt:83)");
                        }
                        final MutableState<String> mutableState = text$delegate;
                        SurfaceKt.m2418SurfaceT9BRK9s(null, null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1846077419, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SearchBarKt.SearchBarPreview.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer4, int $changed3) {
                                Object value$iv2;
                                ComposerKt.sourceInformation($composer4, "C86@3219L44,87@3278L13,84@3141L150:SearchBar.kt#g7nzpb");
                                if (($changed3 & 11) == 2 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1846077419, $changed3, -1, "com.videshkarmakar.loop.ui.component.SearchBarPreview.<anonymous>.<anonymous> (SearchBar.kt:84)");
                                }
                                String strSearchBarPreview$lambda$1 = SearchBarKt.SearchBarPreview$lambda$1(mutableState);
                                String strStringResource = StringResources_androidKt.stringResource(R.string.search_in_downloads, $composer4, 0);
                                $composer4.startReplaceGroup(1713932518);
                                ComposerKt.sourceInformation($composer4, "CC(remember):SearchBar.kt#9igjgp");
                                final MutableState<String> mutableState2 = mutableState;
                                Object it$iv2 = $composer4.rememberedValue();
                                if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                    value$iv2 = new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SearchBarKt$SearchBarPreview$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                            invoke2(str);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(String it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            mutableState2.setValue(it);
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv2);
                                } else {
                                    value$iv2 = it$iv2;
                                }
                                $composer4.endReplaceGroup();
                                SearchBarKt.LoopSearchBar(null, strSearchBarPreview$lambda$1, strStringResource, (Function1) value$iv2, $composer4, 3072, 1);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer3, 54), $composer3, 12582912, 127);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SearchBarKt.SearchBarPreview.2
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
                    SearchBarKt.SearchBarPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SearchBarPreview$lambda$1(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }
}
