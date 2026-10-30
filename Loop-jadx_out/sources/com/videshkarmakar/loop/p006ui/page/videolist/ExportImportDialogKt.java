package com.videshkarmakar.loop.p006ui.page.videolist;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.ButtonKt;
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
import com.caverock.androidsvg.SVGParser;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.database.backup.BackupUtil;
import com.videshkarmakar.loop.p006ui.component.ChipsKt;
import com.videshkarmakar.loop.p006ui.component.DialogsKt;
import com.videshkarmakar.loop.p006ui.theme.ThemeKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: ExportImportDialog.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(m194d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aK\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\f\u001a;\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0013\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0012¨\u0006\u0014²\u0006\n\u0010\u0015\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u0010\u0016\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010\u0016\u001a\u00020\u000bX\u008a\u008e\u0002"}, m195d2 = {"ExportDialog", "", "modifier", "Landroidx/compose/ui/Modifier;", "itemCount", "", "onDismissRequest", "Lkotlin/Function0;", "onExport", "Lkotlin/Function2;", "Lcom/videshkarmakar/loop/database/backup/BackupUtil$BackupType;", "Lcom/videshkarmakar/loop/database/backup/BackupUtil$BackupDestination;", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ImportDialog", "onImport", "Lkotlin/Function1;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "PreviewExport", "(Landroidx/compose/runtime/Composer;I)V", "PreviewImport", "app_debug", SVGParser.XML_STYLESHEET_ATTR_TYPE, "destination"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ExportImportDialogKt {
    public static final void ExportDialog(Modifier modifier, int itemCount, Function0<Unit> function0, final Function2<? super BackupUtil.BackupType, ? super BackupUtil.BackupDestination, Unit> onExport, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int itemCount2;
        Function0<Unit> function1;
        Object value$iv;
        Object value$iv2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(onExport, "onExport");
        Composer $composer2 = $composer.startRestartGroup(1816266259);
        ComposerKt.sourceInformation($composer2, "C(ExportDialog)P(1)43@1825L55,44@1904L51,47@2062L162,51@2242L148,65@2690L3451,45@1960L4187:ExportImportDialog.kt#861hqi");
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
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            itemCount2 = itemCount;
        } else if (($changed & 112) == 0) {
            itemCount2 = itemCount;
            $dirty |= $composer2.changed(itemCount2) ? 32 : 16;
        } else {
            itemCount2 = itemCount;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            function1 = function0;
        } else if (($changed & 896) == 0) {
            function1 = function0;
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        } else {
            function1 = function0;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(onExport) ? 2048 : 1024;
        }
        if (($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            final int itemCount3 = i3 != 0 ? 0 : itemCount2;
            final C39761 c39761 = i4 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt.ExportDialog.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1816266259, $dirty, -1, "com.videshkarmakar.loop.ui.page.videolist.ExportDialog (ExportImportDialog.kt:42)");
            }
            $composer2.startReplaceGroup(-1629801875);
            ComposerKt.sourceInformation($composer2, "CC(remember):ExportImportDialog.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(BackupUtil.BackupType.DownloadHistory, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState type$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(-1629801796);
            ComposerKt.sourceInformation($composer2, "CC(remember):ExportImportDialog.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(BackupUtil.BackupDestination.File, null, 2, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableState destination$delegate = (MutableState) value$iv2;
            $composer2.endReplaceGroup();
            DialogsKt.m7298LoopDialogOix01E0(modifier4, c39761, ComposableLambdaKt.rememberComposableLambda(93141934, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt.ExportDialog.2
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
                    ComposerKt.sourceInformation($composer3, "C48@2093L31,48@2076L138:ExportImportDialog.kt#861hqi");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(93141934, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.ExportDialog.<anonymous> (ExportImportDialog.kt:48)");
                    }
                    $composer3.startReplaceGroup(-1202740326);
                    ComposerKt.sourceInformation($composer3, "CC(remember):ExportImportDialog.kt#9igjgp");
                    boolean invalid$iv = $composer3.changed(onExport);
                    final Function2<BackupUtil.BackupType, BackupUtil.BackupDestination, Unit> function2 = onExport;
                    final MutableState<BackupUtil.BackupType> mutableState = type$delegate;
                    final MutableState<BackupUtil.BackupDestination> mutableState2 = destination$delegate;
                    Object it$iv3 = $composer3.rememberedValue();
                    if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt$ExportDialog$2$1$1
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
                                function2.invoke(ExportImportDialogKt.ExportDialog$lambda$1(mutableState), ExportImportDialogKt.ExportDialog$lambda$4(mutableState2));
                            }
                        };
                        $composer3.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv3;
                    }
                    $composer3.endReplaceGroup();
                    ButtonKt.Button((Function0) value$iv3, null, false, null, null, null, null, null, null, ComposableSingletons$ExportImportDialogKt.INSTANCE.m7609getLambda1$app_debug(), $composer3, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(1041631663, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt.ExportDialog.3
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
                    ComposerKt.sourceInformation($composer3, "C52@2256L124:ExportImportDialog.kt#861hqi");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1041631663, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.ExportDialog.<anonymous> (ExportImportDialog.kt:52)");
                        }
                        ButtonKt.OutlinedButton(c39761, null, false, null, null, null, null, null, null, ComposableSingletons$ExportImportDialogKt.INSTANCE.m7619getLambda2$app_debug(), $composer3, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), ComposableSingletons$ExportImportDialogKt.INSTANCE.m7620getLambda3$app_debug(), ComposableSingletons$ExportImportDialogKt.INSTANCE.m7621getLambda4$app_debug(), ComposableLambdaKt.rememberComposableLambda(-407866446, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt.ExportDialog.4
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
                    Function0<ComposeUiNode> function2;
                    Object value$iv3;
                    Object value$iv4;
                    ComposerKt.sourceInformation($composer3, "C66@2704L3427:ExportImportDialog.kt#861hqi");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-407866446, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.ExportDialog.<anonymous> (ExportImportDialog.kt:66)");
                        }
                        int i5 = itemCount3;
                        final MutableState<BackupUtil.BackupType> mutableState = type$delegate;
                        final MutableState<BackupUtil.BackupDestination> mutableState2 = destination$delegate;
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
                            function2 = constructor;
                            $composer3.createNode(function2);
                        } else {
                            function2 = constructor;
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
                        int i6 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i7 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1434447031, "C*69@2831L52,70@2916L66,67@2729L365,77@3195L41,75@3111L143,82@3441L1150,79@3271L1320,112@4692L39,110@4608L141,117@4936L1181,114@4766L1351:ExportImportDialog.kt#861hqi");
                        Modifier modifierM870paddingVpY3zN4$default = PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24), 0.0f, 2, null);
                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.export_download_history_msg, $composer3, 0);
                        String str = String.format(StringResources_androidKt.pluralStringResource(C3070R.plurals.item_count, i5, $composer3, 0), Arrays.copyOf(new Object[]{Integer.valueOf(i5)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        String str2 = String.format(strStringResource, Arrays.copyOf(new Object[]{str}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        TextKt.m2817Text4IGK_g(str2, modifierM870paddingVpY3zN4$default, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 48, 0, 131068);
                        DialogsKt.m7297DialogSubtitleFNF3uiM(Modifier.INSTANCE, StringResources_androidKt.stringResource(C3070R.string.backup_type, $composer3, 0), 0L, $composer3, 6, 4);
                        PaddingValues paddingValuesM863PaddingValuesYgX7TsA$default = PaddingKt.m863PaddingValuesYgX7TsA$default(C1979Dp.m6801constructorimpl(24), 0.0f, 2, null);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM744spacedBy0680j_4 = Arrangement.INSTANCE.m744spacedBy0680j_4(C1979Dp.m6801constructorimpl(8));
                        $composer3.startReplaceGroup(1434447743);
                        ComposerKt.sourceInformation($composer3, "CC(remember):ExportImportDialog.kt#9igjgp");
                        Object it$iv3 = $composer3.rememberedValue();
                        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv3 = (Function1) new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt$ExportDialog$4$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyRow) {
                                    Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                    final MutableState<BackupUtil.BackupType> mutableState3 = mutableState;
                                    LazyListScope.CC.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(1050627654, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt$ExportDialog$4$1$1$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                            invoke(lazyItemScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope item, Composer $composer4, int $changed3) {
                                            Object value$iv5;
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer4, "C86@3625L37,84@3494L531:ExportImportDialog.kt#861hqi");
                                            if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1050627654, $changed3, -1, "com.videshkarmakar.loop.ui.page.videolist.ExportDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ExportImportDialog.kt:84)");
                                                }
                                                boolean z = ExportImportDialogKt.ExportDialog$lambda$1(mutableState3) == BackupUtil.BackupType.DownloadHistory;
                                                $composer4.startReplaceGroup(-384939238);
                                                ComposerKt.sourceInformation($composer4, "CC(remember):ExportImportDialog.kt#9igjgp");
                                                final MutableState<BackupUtil.BackupType> mutableState4 = mutableState3;
                                                Object it$iv4 = $composer4.rememberedValue();
                                                if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                                                    value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt$ExportDialog$4$1$1$1$1$1$1
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
                                                            mutableState4.setValue(BackupUtil.BackupType.DownloadHistory);
                                                        }
                                                    };
                                                    $composer4.updateRememberedValue(value$iv5);
                                                } else {
                                                    value$iv5 = it$iv4;
                                                }
                                                $composer4.endReplaceGroup();
                                                ChipsKt.SingleSelectChip(z, (Function0) value$iv5, ComposableSingletons$ExportImportDialogKt.INSTANCE.m7622getLambda5$app_debug(), null, false, null, null, null, null, $composer4, 432, 504);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 3, null);
                                    final MutableState<BackupUtil.BackupType> mutableState4 = mutableState;
                                    LazyListScope.CC.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(1000793391, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt$ExportDialog$4$1$1$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                            invoke(lazyItemScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope item, Composer $composer4, int $changed3) {
                                            Object value$iv5;
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer4, "C100@4222L29,98@4099L452:ExportImportDialog.kt#861hqi");
                                            if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1000793391, $changed3, -1, "com.videshkarmakar.loop.ui.page.videolist.ExportDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ExportImportDialog.kt:98)");
                                                }
                                                boolean z = ExportImportDialogKt.ExportDialog$lambda$1(mutableState4) == BackupUtil.BackupType.URLList;
                                                $composer4.startReplaceGroup(-384938641);
                                                ComposerKt.sourceInformation($composer4, "CC(remember):ExportImportDialog.kt#9igjgp");
                                                final MutableState<BackupUtil.BackupType> mutableState5 = mutableState4;
                                                Object it$iv4 = $composer4.rememberedValue();
                                                if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                                                    value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt$ExportDialog$4$1$1$1$2$1$1
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
                                                            mutableState5.setValue(BackupUtil.BackupType.URLList);
                                                        }
                                                    };
                                                    $composer4.updateRememberedValue(value$iv5);
                                                } else {
                                                    value$iv5 = it$iv4;
                                                }
                                                $composer4.endReplaceGroup();
                                                ChipsKt.SingleSelectChip(z, (Function0) value$iv5, ComposableSingletons$ExportImportDialogKt.INSTANCE.m7623getLambda6$app_debug(), null, false, null, null, null, null, $composer4, 432, 504);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 3, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = it$iv3;
                        }
                        $composer3.endReplaceGroup();
                        LazyDslKt.LazyRow(null, null, paddingValuesM863PaddingValuesYgX7TsA$default, false, horizontalOrVerticalM744spacedBy0680j_4, null, null, false, (Function1) value$iv3, $composer3, 100688256, 235);
                        DialogsKt.m7297DialogSubtitleFNF3uiM(Modifier.INSTANCE, StringResources_androidKt.stringResource(C3070R.string.export_to, $composer3, 0), 0L, $composer3, 6, 4);
                        PaddingValues paddingValuesM863PaddingValuesYgX7TsA$default2 = PaddingKt.m863PaddingValuesYgX7TsA$default(C1979Dp.m6801constructorimpl(24), 0.0f, 2, null);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM744spacedBy0680j_5 = Arrangement.INSTANCE.m744spacedBy0680j_4(C1979Dp.m6801constructorimpl(8));
                        $composer3.startReplaceGroup(1434449238);
                        ComposerKt.sourceInformation($composer3, "CC(remember):ExportImportDialog.kt#9igjgp");
                        Object it$iv4 = $composer3.rememberedValue();
                        if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                            value$iv4 = new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt$ExportDialog$4$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyRow) {
                                    Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                    final MutableState<BackupUtil.BackupDestination> mutableState3 = mutableState2;
                                    LazyListScope.CC.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(1872468541, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt$ExportDialog$4$1$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                            invoke(lazyItemScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope item, Composer $composer4, int $changed3) {
                                            Object value$iv5;
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer4, "C121@5123L40,119@4989L530:ExportImportDialog.kt#861hqi");
                                            if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1872468541, $changed3, -1, "com.videshkarmakar.loop.ui.page.videolist.ExportDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ExportImportDialog.kt:119)");
                                                }
                                                boolean z = ExportImportDialogKt.ExportDialog$lambda$4(mutableState3) == BackupUtil.BackupDestination.File;
                                                $composer4.startReplaceGroup(-384937740);
                                                ComposerKt.sourceInformation($composer4, "CC(remember):ExportImportDialog.kt#9igjgp");
                                                final MutableState<BackupUtil.BackupDestination> mutableState4 = mutableState3;
                                                Object it$iv5 = $composer4.rememberedValue();
                                                if (it$iv5 == Composer.INSTANCE.getEmpty()) {
                                                    value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt$ExportDialog$4$1$2$1$1$1$1
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
                                                            mutableState4.setValue(BackupUtil.BackupDestination.File);
                                                        }
                                                    };
                                                    $composer4.updateRememberedValue(value$iv5);
                                                } else {
                                                    value$iv5 = it$iv5;
                                                }
                                                $composer4.endReplaceGroup();
                                                ChipsKt.SingleSelectChip(z, (Function0) value$iv5, ComposableSingletons$ExportImportDialogKt.INSTANCE.m7624getLambda7$app_debug(), null, false, null, null, null, null, $composer4, 432, 504);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 3, null);
                                    final MutableState<BackupUtil.BackupDestination> mutableState4 = mutableState2;
                                    LazyListScope.CC.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(1226382054, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt$ExportDialog$4$1$2$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                            invoke(lazyItemScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope item, Composer $composer4, int $changed3) {
                                            Object value$iv5;
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer4, "C135@5732L45,133@5593L484:ExportImportDialog.kt#861hqi");
                                            if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1226382054, $changed3, -1, "com.videshkarmakar.loop.ui.page.videolist.ExportDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ExportImportDialog.kt:133)");
                                                }
                                                boolean z = ExportImportDialogKt.ExportDialog$lambda$4(mutableState4) == BackupUtil.BackupDestination.Clipboard;
                                                $composer4.startReplaceGroup(-384937131);
                                                ComposerKt.sourceInformation($composer4, "CC(remember):ExportImportDialog.kt#9igjgp");
                                                final MutableState<BackupUtil.BackupDestination> mutableState5 = mutableState4;
                                                Object it$iv5 = $composer4.rememberedValue();
                                                if (it$iv5 == Composer.INSTANCE.getEmpty()) {
                                                    value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt$ExportDialog$4$1$2$1$2$1$1
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
                                                            mutableState5.setValue(BackupUtil.BackupDestination.Clipboard);
                                                        }
                                                    };
                                                    $composer4.updateRememberedValue(value$iv5);
                                                } else {
                                                    value$iv5 = it$iv5;
                                                }
                                                $composer4.endReplaceGroup();
                                                ChipsKt.SingleSelectChip(z, (Function0) value$iv5, ComposableSingletons$ExportImportDialogKt.INSTANCE.m7625getLambda8$app_debug(), null, false, null, null, null, null, $composer4, 432, 504);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 3, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv4);
                        } else {
                            value$iv4 = it$iv4;
                        }
                        $composer3.endReplaceGroup();
                        LazyDslKt.LazyRow(null, null, paddingValuesM863PaddingValuesYgX7TsA$default2, false, horizontalOrVerticalM744spacedBy0680j_5, null, null, false, (Function1) value$iv4, $composer3, 100688256, 235);
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
            }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, 1797504 | ($dirty & 14) | (($dirty >> 3) & 112), 0, 16256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            itemCount2 = itemCount3;
            function1 = c39761;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final int i5 = itemCount2;
            final Function0<Unit> function2 = function1;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt.ExportDialog.5
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
                    ExportImportDialogKt.ExportDialog(modifier5, i5, function2, onExport, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BackupUtil.BackupType ExportDialog$lambda$1(MutableState<BackupUtil.BackupType> mutableState) {
        MutableState<BackupUtil.BackupType> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BackupUtil.BackupDestination ExportDialog$lambda$4(MutableState<BackupUtil.BackupDestination> mutableState) {
        MutableState<BackupUtil.BackupDestination> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    public static final void ImportDialog(Modifier modifier, Function0<Unit> function0, final Function1<? super BackupUtil.BackupDestination, Unit> onImport, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0<Unit> function1;
        Object value$iv;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(onImport, "onImport");
        Composer $composer2 = $composer.startRestartGroup(323552030);
        ComposerKt.sourceInformation($composer2, "C(ImportDialog)156@6324L51,160@6483L156,164@6657L148,178@7086L2641,158@6381L3352:ExportImportDialog.kt#861hqi");
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
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            function1 = function0;
        } else if (($changed & 112) == 0) {
            function1 = function0;
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(onImport) ? 256 : 128;
        }
        if (($dirty & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            final C39851 c39851 = i3 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt.ImportDialog.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(323552030, $dirty, -1, "com.videshkarmakar.loop.ui.page.videolist.ImportDialog (ExportImportDialog.kt:155)");
            }
            $composer2.startReplaceGroup(71647983);
            ComposerKt.sourceInformation($composer2, "CC(remember):ExportImportDialog.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(BackupUtil.BackupDestination.File, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState destination$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            DialogsKt.m7298LoopDialogOix01E0(modifier4, c39851, ComposableLambdaKt.rememberComposableLambda(1034763833, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt.ImportDialog.2
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
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer3, "C161@6514L25,161@6497L132:ExportImportDialog.kt#861hqi");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1034763833, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.ImportDialog.<anonymous> (ExportImportDialog.kt:161)");
                    }
                    $composer3.startReplaceGroup(-184564402);
                    ComposerKt.sourceInformation($composer3, "CC(remember):ExportImportDialog.kt#9igjgp");
                    boolean invalid$iv = $composer3.changed(onImport);
                    final Function1<BackupUtil.BackupDestination, Unit> function2 = onImport;
                    final MutableState<BackupUtil.BackupDestination> mutableState = destination$delegate;
                    Object it$iv2 = $composer3.rememberedValue();
                    if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt$ImportDialog$2$1$1
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
                                function2.invoke(ExportImportDialogKt.ImportDialog$lambda$7(mutableState));
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    $composer3.endReplaceGroup();
                    ButtonKt.Button((Function0) value$iv2, null, false, null, null, null, null, null, null, ComposableSingletons$ExportImportDialogKt.INSTANCE.m7626getLambda9$app_debug(), $composer3, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(956773562, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt.ImportDialog.3
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
                    ComposerKt.sourceInformation($composer3, "C165@6671L124:ExportImportDialog.kt#861hqi");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(956773562, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.ImportDialog.<anonymous> (ExportImportDialog.kt:165)");
                        }
                        ButtonKt.OutlinedButton(c39851, null, false, null, null, null, null, null, null, ComposableSingletons$ExportImportDialogKt.INSTANCE.m7610getLambda10$app_debug(), $composer3, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), ComposableSingletons$ExportImportDialogKt.INSTANCE.m7611getLambda11$app_debug(), ComposableSingletons$ExportImportDialogKt.INSTANCE.m7612getLambda12$app_debug(), ComposableLambdaKt.rememberComposableLambda(722802749, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt.ImportDialog.4
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
                    Function0<ComposeUiNode> function2;
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer3, "C179@7100L2617:ExportImportDialog.kt#861hqi");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(722802749, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.ImportDialog.<anonymous> (ExportImportDialog.kt:179)");
                        }
                        final MutableState<BackupUtil.BackupDestination> mutableState = destination$delegate;
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
                            function2 = constructor;
                            $composer3.createNode(function2);
                        } else {
                            function2 = constructor;
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
                        ComposerKt.sourceInformationMarkerStart($composer3, -1519919150, "C182@7227L52,180@7125L172,186@7398L41,184@7314L143,188@7474L673,207@8248L41,205@8164L143,212@8494L1209,209@8324L1379:ExportImportDialog.kt#861hqi");
                        TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.import_download_history_msg, $composer3, 0), PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 48, 0, 131068);
                        DialogsKt.m7297DialogSubtitleFNF3uiM(Modifier.INSTANCE, StringResources_androidKt.stringResource(C3070R.string.backup_type, $composer3, 0), 0L, $composer3, 6, 4);
                        LazyDslKt.LazyRow(null, null, PaddingKt.m863PaddingValuesYgX7TsA$default(C1979Dp.m6801constructorimpl(24), 0.0f, 2, null), false, Arrangement.INSTANCE.m744spacedBy0680j_4(C1979Dp.m6801constructorimpl(8)), null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt$ImportDialog$4$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyRow) {
                                Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                LazyListScope.CC.item$default(LazyRow, null, null, ComposableSingletons$ExportImportDialogKt.INSTANCE.m7614getLambda14$app_debug(), 3, null);
                            }
                        }, $composer3, 100688256, 235);
                        DialogsKt.m7297DialogSubtitleFNF3uiM(Modifier.INSTANCE, StringResources_androidKt.stringResource(C3070R.string.import_from, $composer3, 0), 0L, $composer3, 6, 4);
                        PaddingValues paddingValuesM863PaddingValuesYgX7TsA$default = PaddingKt.m863PaddingValuesYgX7TsA$default(C1979Dp.m6801constructorimpl(24), 0.0f, 2, null);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM744spacedBy0680j_4 = Arrangement.INSTANCE.m744spacedBy0680j_4(C1979Dp.m6801constructorimpl(8));
                        $composer3.startReplaceGroup(-1519917781);
                        ComposerKt.sourceInformation($composer3, "CC(remember):ExportImportDialog.kt#9igjgp");
                        Object it$iv2 = $composer3.rememberedValue();
                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = (Function1) new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt$ImportDialog$4$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyRow) {
                                    Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                    final MutableState<BackupUtil.BackupDestination> mutableState2 = mutableState;
                                    LazyListScope.CC.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(135740488, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt$ImportDialog$4$1$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                            invoke(lazyItemScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope item, Composer $composer4, int $changed3) {
                                            Object value$iv3;
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer4, "C216@8681L40,214@8547L530:ExportImportDialog.kt#861hqi");
                                            if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(135740488, $changed3, -1, "com.videshkarmakar.loop.ui.page.videolist.ImportDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ExportImportDialog.kt:214)");
                                                }
                                                boolean z = ExportImportDialogKt.ImportDialog$lambda$7(mutableState2) == BackupUtil.BackupDestination.File;
                                                $composer4.startReplaceGroup(1812477257);
                                                ComposerKt.sourceInformation($composer4, "CC(remember):ExportImportDialog.kt#9igjgp");
                                                final MutableState<BackupUtil.BackupDestination> mutableState3 = mutableState2;
                                                Object it$iv3 = $composer4.rememberedValue();
                                                if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt$ImportDialog$4$1$2$1$1$1$1
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
                                                            mutableState3.setValue(BackupUtil.BackupDestination.File);
                                                        }
                                                    };
                                                    $composer4.updateRememberedValue(value$iv3);
                                                } else {
                                                    value$iv3 = it$iv3;
                                                }
                                                $composer4.endReplaceGroup();
                                                ChipsKt.SingleSelectChip(z, (Function0) value$iv3, ComposableSingletons$ExportImportDialogKt.INSTANCE.m7615getLambda15$app_debug(), null, false, null, null, null, null, $composer4, 432, 504);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 3, null);
                                    final MutableState<BackupUtil.BackupDestination> mutableState3 = mutableState;
                                    LazyListScope.CC.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(-1531348623, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt$ImportDialog$4$1$2$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                            invoke(lazyItemScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope item, Composer $composer4, int $changed3) {
                                            Object value$iv3;
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer4, "C230@9290L45,228@9151L512:ExportImportDialog.kt#861hqi");
                                            if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1531348623, $changed3, -1, "com.videshkarmakar.loop.ui.page.videolist.ImportDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ExportImportDialog.kt:228)");
                                                }
                                                boolean z = ExportImportDialogKt.ImportDialog$lambda$7(mutableState3) == BackupUtil.BackupDestination.Clipboard;
                                                $composer4.startReplaceGroup(1812477866);
                                                ComposerKt.sourceInformation($composer4, "CC(remember):ExportImportDialog.kt#9igjgp");
                                                final MutableState<BackupUtil.BackupDestination> mutableState4 = mutableState3;
                                                Object it$iv3 = $composer4.rememberedValue();
                                                if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt$ImportDialog$4$1$2$1$2$1$1
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
                                                            mutableState4.setValue(BackupUtil.BackupDestination.Clipboard);
                                                        }
                                                    };
                                                    $composer4.updateRememberedValue(value$iv3);
                                                } else {
                                                    value$iv3 = it$iv3;
                                                }
                                                $composer4.endReplaceGroup();
                                                ChipsKt.SingleSelectChip(z, (Function0) value$iv3, ComposableSingletons$ExportImportDialogKt.INSTANCE.m7616getLambda16$app_debug(), null, false, null, null, null, null, $composer4, 432, 504);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 3, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        $composer3.endReplaceGroup();
                        LazyDslKt.LazyRow(null, null, paddingValuesM863PaddingValuesYgX7TsA$default, false, horizontalOrVerticalM744spacedBy0680j_4, null, null, false, (Function1) value$iv2, $composer3, 100688256, 235);
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
            }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, 1797504 | ($dirty & 14) | ($dirty & 112), 0, 16256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            function1 = c39851;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function0<Unit> function2 = function1;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt.ImportDialog.5
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
                    ExportImportDialogKt.ImportDialog(modifier5, function2, onImport, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BackupUtil.BackupDestination ImportDialog$lambda$7(MutableState<BackupUtil.BackupDestination> mutableState) {
        MutableState<BackupUtil.BackupDestination> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PreviewExport(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(2015335931);
        ComposerKt.sourceInformation($composer2, "C(PreviewExport)250@9808L52:ExportImportDialog.kt#861hqi");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2015335931, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.PreviewExport (ExportImportDialog.kt:249)");
            }
            ThemeKt.LoopTheme(false, false, false, ComposableSingletons$ExportImportDialogKt.INSTANCE.m7617getLambda17$app_debug(), $composer2, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt.PreviewExport.1
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
                    ExportImportDialogKt.PreviewExport(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PreviewImport(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1071136234);
        ComposerKt.sourceInformation($composer2, "C(PreviewImport)259@9977L49:ExportImportDialog.kt#861hqi");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1071136234, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.PreviewImport (ExportImportDialog.kt:258)");
            }
            ThemeKt.LoopTheme(false, false, false, ComposableSingletons$ExportImportDialogKt.INSTANCE.m7618getLambda18$app_debug(), $composer2, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ExportImportDialogKt.PreviewImport.1
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
                    ExportImportDialogKt.PreviewImport(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
