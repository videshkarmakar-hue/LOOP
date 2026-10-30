package com.videshkarmakar.loop;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.BugReportKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
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
import com.videshkarmakar.loop.p006ui.component.ButtonsKt;
import com.videshkarmakar.loop.p006ui.component.DividerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: CrashReportActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m194d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m195d2 = {"CrashReportPage", "", "errorMessage", "", "onClick", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_debug"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CrashReportActivityKt {
    public static final void CrashReportPage(String errorMessage, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        final String errorMessage2;
        Function0<Unit> function1;
        final Function0<Unit> function2;
        Composer $composer2 = $composer.startRestartGroup(947102835);
        ComposerKt.sourceInformation($composer2, "C(CrashReportPage)72@3059L378,84@3439L793,72@3003L1229:CrashReportActivity.kt#rrbzdc");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            errorMessage2 = errorMessage;
        } else if (($changed & 14) == 0) {
            errorMessage2 = errorMessage;
            $dirty |= $composer2.changed(errorMessage2) ? 4 : 2;
        } else {
            errorMessage2 = errorMessage;
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
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer2.getSkipping()) {
            final String errorMessage3 = i2 != 0 ? "ERROR_EXAMPLE" : errorMessage2;
            final Function0<Unit> function3 = i3 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.CrashReportActivityKt.CrashReportPage.1
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
                ComposerKt.traceEventStart(947102835, $dirty2, -1, "com.videshkarmakar.loop.CrashReportPage (CrashReportActivity.kt:71)");
            }
            function2 = function3;
            String errorMessage4 = errorMessage3;
            ScaffoldKt.m2530ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, ComposableLambdaKt.rememberComposableLambda(75176760, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.CrashReportActivityKt.CrashReportPage.2
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
                    ComposerKt.sourceInformation($composer3, "C73@3069L19,82@3383L38,75@3098L333:CrashReportActivity.kt#rrbzdc");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(75176760, $changed2, -1, "com.videshkarmakar.loop.CrashReportPage.<anonymous> (CrashReportActivity.kt:73)");
                    }
                    DividerKt.m7300HorizontalDivideriJQMabo(null, 0L, $composer3, 0, 3);
                    ButtonsKt.FilledButtonWithIcon(PaddingKt.m869paddingVpY3zN4(WindowInsetsPadding_androidKt.navigationBarsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null)), C1979Dp.m6801constructorimpl(16), C1979Dp.m6801constructorimpl(8)), BugReportKt.getBugReport(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(C3070R.string.copy_and_exit, $composer3, 0), false, function3, $composer3, 0, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-786246654, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.CrashReportActivityKt.CrashReportPage.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
                    invoke(paddingValues, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues it, Composer $composer3, int $changed2) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer3, "C88@3550L21,85@3449L777:CrashReportActivity.kt#rrbzdc");
                    int $dirty3 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty3 |= $composer3.changed(it) ? 4 : 2;
                    }
                    if (($dirty3 & 91) == 18 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-786246654, $dirty3, -1, "com.videshkarmakar.loop.CrashReportPage.<anonymous> (CrashReportActivity.kt:85)");
                    }
                    Modifier modifier$iv = ScrollKt.verticalScroll$default(PaddingKt.padding(Modifier.INSTANCE, it), ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null);
                    String str = errorMessage3;
                    ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
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
                        $composer3.createNode(constructor);
                    } else {
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
                    ComposerKt.sourceInformationMarkerStart($composer3, -1865707357, "C91@3626L44,92@3710L10,90@3597L273,98@3964L10,99@4065L11,96@3883L333:CrashReportActivity.kt#rrbzdc");
                    TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.unknown_error_title, $composer3, 0), PaddingKt.m871paddingqDBjuR0(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(16), C1979Dp.m6801constructorimpl(60), C1979Dp.m6801constructorimpl(16), C1979Dp.m6801constructorimpl(12)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getDisplaySmall(), $composer3, 0, 0, 65532);
                    TextStyle bodyMedium = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium();
                    TextKt.m2817Text4IGK_g(str, SizeKt.fillMaxWidth$default(PaddingKt.m868padding3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(16)), 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, bodyMedium.m6277copyp1EtxEg((16777213 & 1) != 0 ? bodyMedium.spanStyle.m6199getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? bodyMedium.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? bodyMedium.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? bodyMedium.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? bodyMedium.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? bodyMedium.spanStyle.getFontFamily() : FontFamily.INSTANCE.getMonospace(), (16777213 & 64) != 0 ? bodyMedium.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? bodyMedium.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? bodyMedium.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? bodyMedium.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? bodyMedium.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? bodyMedium.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? bodyMedium.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? bodyMedium.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? bodyMedium.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? bodyMedium.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? bodyMedium.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? bodyMedium.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? bodyMedium.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? bodyMedium.platformStyle : null, (16777213 & 1048576) != 0 ? bodyMedium.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? bodyMedium.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? bodyMedium.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? bodyMedium.paragraphStyle.getTextMotion() : null), $composer3, 48, 0, 65528);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, 805306758, HttpStatusCodesKt.HTTP_VARIANT_ALSO_NEGOTIATES);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            errorMessage2 = errorMessage4;
        } else {
            $composer2.skipToGroupEnd();
            function2 = function1;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.CrashReportActivityKt.CrashReportPage.4
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
                    CrashReportActivityKt.CrashReportPage(errorMessage2, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
