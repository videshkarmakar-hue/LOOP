package com.videshkarmakar.loop.p006ui.page.videolist;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.database.objects.DownloadedVideoInfo;
import com.videshkarmakar.loop.p006ui.component.DialogItemsKt;
import com.videshkarmakar.loop.p006ui.component.DialogsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: RemoveItemDialog.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(m194d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a[\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m195d2 = {"RemoveItemDialog", "", "deleteFile", "", "onDeleteFileToggled", "Lkotlin/Function1;", "info", "Lcom/videshkarmakar/loop/database/objects/DownloadedVideoInfo;", "onRemoveConfirm", "onDismissRequest", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function1;Lcom/videshkarmakar/loop/database/objects/DownloadedVideoInfo;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_debug"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class RemoveItemDialogKt {
    public static final void RemoveItemDialog(boolean deleteFile, Function1<? super Boolean, Unit> function1, final DownloadedVideoInfo info, Function1<? super Boolean, Unit> function2, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        boolean z;
        Function1<? super Boolean, Unit> function3;
        Function1<? super Boolean, Unit> function4;
        Function0<Unit> function5;
        boolean deleteFile2;
        Function1<? super Boolean, Unit> function6;
        Function1<? super Boolean, Unit> function7;
        Function0<Unit> function8;
        Intrinsics.checkNotNullParameter(info, "info");
        Composer $composer2 = $composer.startRestartGroup(-617530324);
        ComposerKt.sourceInformation($composer2, "C(RemoveItemDialog)P(!1,2!1,4)49@1879L218,56@2115L140,32@1242L619,28@1042L1214:RemoveItemDialog.kt#861hqi");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            z = deleteFile;
        } else if (($changed & 14) == 0) {
            z = deleteFile;
            $dirty |= $composer2.changed(z) ? 4 : 2;
        } else {
            z = deleteFile;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            function3 = function1;
        } else if (($changed & 112) == 0) {
            function3 = function1;
            $dirty |= $composer2.changedInstance(function3) ? 32 : 16;
        } else {
            function3 = function1;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(info) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            function4 = function2;
        } else if (($changed & 7168) == 0) {
            function4 = function2;
            $dirty |= $composer2.changedInstance(function4) ? 2048 : 1024;
        } else {
            function4 = function2;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            function5 = function0;
        } else if ((57344 & $changed) == 0) {
            function5 = function0;
            $dirty |= $composer2.changedInstance(function5) ? 16384 : 8192;
        } else {
            function5 = function0;
        }
        if ((46811 & $dirty) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function6 = function3;
            function8 = function5;
            function7 = function4;
            deleteFile2 = z;
        } else {
            final boolean deleteFile3 = i2 != 0 ? false : z;
            final C39941 c39941 = i3 != 0 ? new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.RemoveItemDialogKt.RemoveItemDialog.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean it) {
                }
            } : function3;
            final C39952 c39952 = i4 != 0 ? new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.RemoveItemDialogKt.RemoveItemDialog.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean it) {
                }
            } : function4;
            final C39963 c39963 = i5 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.RemoveItemDialogKt.RemoveItemDialog.3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-617530324, $dirty, -1, "com.videshkarmakar.loop.ui.page.videolist.RemoveItemDialog (RemoveItemDialog.kt:27)");
            }
            DialogsKt.m7298LoopDialogOix01E0(null, c39963, ComposableLambdaKt.rememberComposableLambda(-535011919, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.RemoveItemDialogKt.RemoveItemDialog.4
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
                    ComposerKt.sourceInformation($composer3, "C50@1914L94,50@1893L194:RemoveItemDialog.kt#861hqi");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-535011919, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.RemoveItemDialog.<anonymous> (RemoveItemDialog.kt:50)");
                    }
                    $composer3.startReplaceGroup(2035531780);
                    ComposerKt.sourceInformation($composer3, "CC(remember):RemoveItemDialog.kt#9igjgp");
                    boolean invalid$iv = $composer3.changed(c39963) | $composer3.changed(c39952) | $composer3.changed(deleteFile3);
                    final Function0<Unit> function9 = c39963;
                    final Function1<Boolean, Unit> function10 = c39952;
                    final boolean z2 = deleteFile3;
                    Object it$iv = $composer3.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.RemoveItemDialogKt$RemoveItemDialog$4$1$1
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
                                function9.invoke();
                                function10.invoke(Boolean.valueOf(z2));
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer3.endReplaceGroup();
                    ButtonKt.TextButton((Function0) value$iv, null, false, null, null, null, null, null, null, ComposableSingletons$RemoveItemDialogKt.INSTANCE.m7627getLambda1$app_debug(), $composer3, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(-1219242224, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.RemoveItemDialogKt.RemoveItemDialog.5
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
                    ComposerKt.sourceInformation($composer3, "C57@2129L116:RemoveItemDialog.kt#861hqi");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1219242224, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.RemoveItemDialog.<anonymous> (RemoveItemDialog.kt:57)");
                        }
                        ButtonKt.TextButton(c39963, null, false, null, null, null, null, null, null, ComposableSingletons$RemoveItemDialogKt.INSTANCE.m7628getLambda2$app_debug(), $composer3, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), ComposableSingletons$RemoveItemDialogKt.INSTANCE.m7629getLambda3$app_debug(), ComposableSingletons$RemoveItemDialogKt.INSTANCE.m7630getLambda4$app_debug(), ComposableLambdaKt.rememberComposableLambda(1023034157, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.RemoveItemDialogKt.RemoveItemDialog.6
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
                    Function0<ComposeUiNode> function9;
                    ComposerKt.sourceInformation($composer3, "C33@1256L594:RemoveItemDialog.kt#861hqi");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1023034157, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.RemoveItemDialog.<anonymous> (RemoveItemDialog.kt:33)");
                        }
                        DownloadedVideoInfo downloadedVideoInfo = info;
                        boolean z2 = deleteFile3;
                        Function1<Boolean, Unit> function10 = c39941;
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
                            function9 = constructor;
                            $composer3.createNode(function9);
                        } else {
                            function9 = constructor;
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
                        ComposerKt.sourceInformationMarkerStart($composer3, -1927790420, "C*38@1448L40,34@1281L275,43@1683L36,41@1573L263:RemoveItemDialog.kt#861hqi");
                        Modifier modifierM870paddingVpY3zN4$default = PaddingKt.m870paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(24), 0.0f, 2, null);
                        String str = String.format(StringResources_androidKt.stringResource(C3070R.string.delete_info_msg, $composer3, 0), Arrays.copyOf(new Object[]{downloadedVideoInfo.getVideoTitle()}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        TextKt.m2817Text4IGK_g(str, modifierM870paddingVpY3zN4$default, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 48, 0, 131068);
                        Modifier materialized$iv$iv2 = PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(12), 0.0f, 2, null);
                        DialogItemsKt.CheckBoxItem(materialized$iv$iv2, StringResources_androidKt.stringResource(C3070R.string.delete_file, $composer3, 0), z2, function10, $composer3, 6, 0);
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
            }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty >> 9) & 112) | 1797504, 0, 16257);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            deleteFile2 = deleteFile3;
            function6 = c39941;
            function7 = c39952;
            function8 = c39963;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z2 = deleteFile2;
            final Function1<? super Boolean, Unit> function9 = function6;
            final Function1<? super Boolean, Unit> function10 = function7;
            final Function0<Unit> function11 = function8;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.RemoveItemDialogKt.RemoveItemDialog.7
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
                    RemoveItemDialogKt.RemoveItemDialog(z2, function9, info, function10, function11, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
