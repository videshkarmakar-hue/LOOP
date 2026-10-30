package com.videshkarmakar.loop.ui.page.settings.about;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AboutPage.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a)\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001a\u001d\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"AboutPage", "", "onNavigateBack", "Lkotlin/Function0;", "onNavigateToCredits", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DetailRow", "label", "", DownloadUtil.CookieScheme.VALUE, "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "FeatureItem", "text", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AboutPageKt {
    public static final void AboutPage(final Function0<Unit> onNavigateBack, final Function0<Unit> onNavigateToCredits, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onNavigateBack, "onNavigateBack");
        Intrinsics.checkNotNullParameter(onNavigateToCredits, "onNavigateToCredits");
        Composer $composer3 = $composer.startRestartGroup(430916911);
        ComposerKt.sourceInformation($composer3, "C(AboutPage)44@1850L7,48@1945L11,49@1974L7157,46@1863L7268:AboutPage.kt#frind1");
        int $dirty = $changed;
        if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(onNavigateToCredits) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 81) != 16 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(430916911, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.about.AboutPage (AboutPage.kt:43)");
            }
            ProvidableCompositionLocal<UriHandler> localUriHandler = CompositionLocalsKt.getLocalUriHandler();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localUriHandler);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            SurfaceKt.m2418SurfaceT9BRK9s(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getBackground(), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1421811082, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.about.AboutPageKt.AboutPage.1
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
                    ComposerKt.sourceInformation($composer4, "C53@2087L21,50@1984L7141:AboutPage.kt#frind1");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1421811082, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.about.AboutPage.<anonymous> (AboutPage.kt:50)");
                        }
                        Modifier modifier$iv = PaddingKt.m620padding3ABfNKs(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, null, false, 14, null), Dp.m6553constructorimpl(16));
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getCenterHorizontally();
                        Function0<Unit> function0 = onNavigateToCredits;
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv = (384 << 3) & 112;
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
                            $composer4.createNode(constructor);
                        } else {
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
                        int i = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i2 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 579614781, "C59@2287L50,58@2254L274,66@2542L41,71@2696L10,73@2807L11,69@2621L219,78@2950L10,79@3010L11,76@2854L198,82@3066L41,88@3312L11,87@3249L126,85@3153L1070,107@4237L41,113@4494L11,112@4431L126,110@4335L1054,135@5403L41,141@5650L11,140@5587L126,138@5491L1151,164@6656L41,169@6858L10,170@6918L11,167@6736L270,174@7020L40,179@7216L10,181@7325L11,177@7097L307,185@7418L41,191@7672L11,190@7609L128,188@7513L1547,224@9074L41:AboutPage.kt#frind1");
                        ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_about_app_icon, $composer4, 0), "LOOP app icon", ClipKt.clip(SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(80)), RoundedCornerShapeKt.m898RoundedCornerShape0680j_4(Dp.m6553constructorimpl(16))), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer4, 56, 120);
                        SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), $composer4, 6);
                        TextKt.m2569Text4IGK_g("LOOP", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getHeadlineMedium(), $composer4, 196614, 0, 65498);
                        TextKt.m2569Text4IGK_g("Cross-Platform Downloader", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyLarge(), $composer4, 6, 0, 65530);
                        SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(24)), $composer4, 6);
                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        CardDefaults cardDefaults = CardDefaults.INSTANCE;
                        long surfaceVariant = MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getSurfaceVariant();
                        CardKt.Card(modifierFillMaxWidth$default, RoundedCornerShapeKt.m898RoundedCornerShape0680j_4(Dp.m6553constructorimpl(16)), cardDefaults.m1731cardColorsro_MJ88(Color.m4041copywmQWz5c(surfaceVariant, (14 & 1) != 0 ? Color.m4045getAlphaimpl(surfaceVariant) : 0.5f, (14 & 2) != 0 ? Color.m4049getRedimpl(surfaceVariant) : 0.0f, (14 & 4) != 0 ? Color.m4048getGreenimpl(surfaceVariant) : 0.0f, (14 & 8) != 0 ? Color.m4046getBlueimpl(surfaceVariant) : 0.0f), 0L, 0L, 0L, $composer4, CardDefaults.$stable << 12, 14), null, null, ComposableSingletons$AboutPageKt.INSTANCE.m7298getLambda1$app_debug(), $composer4, 196614, 24);
                        SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), $composer4, 6);
                        Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        CardDefaults cardDefaults2 = CardDefaults.INSTANCE;
                        long surfaceVariant2 = MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getSurfaceVariant();
                        CardKt.Card(modifierFillMaxWidth$default2, RoundedCornerShapeKt.m898RoundedCornerShape0680j_4(Dp.m6553constructorimpl(16)), cardDefaults2.m1731cardColorsro_MJ88(Color.m4041copywmQWz5c(surfaceVariant2, (14 & 1) != 0 ? Color.m4045getAlphaimpl(surfaceVariant2) : 0.5f, (14 & 2) != 0 ? Color.m4049getRedimpl(surfaceVariant2) : 0.0f, (14 & 4) != 0 ? Color.m4048getGreenimpl(surfaceVariant2) : 0.0f, (14 & 8) != 0 ? Color.m4046getBlueimpl(surfaceVariant2) : 0.0f), 0L, 0L, 0L, $composer4, CardDefaults.$stable << 12, 14), null, null, ComposableSingletons$AboutPageKt.INSTANCE.m7299getLambda2$app_debug(), $composer4, 196614, 24);
                        SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), $composer4, 6);
                        Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        CardDefaults cardDefaults3 = CardDefaults.INSTANCE;
                        long surfaceVariant3 = MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getSurfaceVariant();
                        CardKt.Card(modifierFillMaxWidth$default3, RoundedCornerShapeKt.m898RoundedCornerShape0680j_4(Dp.m6553constructorimpl(16)), cardDefaults3.m1731cardColorsro_MJ88(Color.m4041copywmQWz5c(surfaceVariant3, (14 & 1) != 0 ? Color.m4045getAlphaimpl(surfaceVariant3) : 0.5f, (14 & 2) != 0 ? Color.m4049getRedimpl(surfaceVariant3) : 0.0f, (14 & 4) != 0 ? Color.m4048getGreenimpl(surfaceVariant3) : 0.0f, (14 & 8) != 0 ? Color.m4046getBlueimpl(surfaceVariant3) : 0.0f), 0L, 0L, 0L, $composer4, CardDefaults.$stable << 12, 14), null, null, ComposableSingletons$AboutPageKt.INSTANCE.m7300getLambda3$app_debug(), $composer4, 196614, 24);
                        SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), $composer4, 6);
                        TextKt.m2569Text4IGK_g("© 2026 LOOP - Videsh Karmakar. All rights reserved.", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6403boximpl(TextAlign.INSTANCE.m6410getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodySmall(), $composer4, 6, 0, 65018);
                        SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), $composer4, 6);
                        TextKt.m2569Text4IGK_g("LOOP - Every Day, Every Download, Every Content.", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6403boximpl(TextAlign.INSTANCE.m6410getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyMedium(), $composer4, 196614, 0, 64986);
                        SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(24)), $composer4, 6);
                        Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        CardDefaults cardDefaults4 = CardDefaults.INSTANCE;
                        long primaryContainer = MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimaryContainer();
                        CardKt.Card(function0, modifierFillMaxWidth$default4, false, RoundedCornerShapeKt.m898RoundedCornerShape0680j_4(Dp.m6553constructorimpl(16)), cardDefaults4.m1731cardColorsro_MJ88(Color.m4041copywmQWz5c(primaryContainer, (14 & 1) != 0 ? Color.m4045getAlphaimpl(primaryContainer) : 0.3f, (14 & 2) != 0 ? Color.m4049getRedimpl(primaryContainer) : 0.0f, (14 & 4) != 0 ? Color.m4048getGreenimpl(primaryContainer) : 0.0f, (14 & 8) != 0 ? Color.m4046getBlueimpl(primaryContainer) : 0.0f), 0L, 0L, 0L, $composer4, CardDefaults.$stable << 12, 14), null, null, null, ComposableSingletons$AboutPageKt.INSTANCE.m7301getLambda4$app_debug(), $composer4, 100663344, 228);
                        SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(32)), $composer4, 6);
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
            }, $composer3, 54), $composer3, 12582918, 122);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.about.AboutPageKt.AboutPage.2
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
                    AboutPageKt.AboutPage(onNavigateBack, onNavigateToCredits, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DetailRow(final String label, final String value, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(1603165444);
        ComposerKt.sourceInformation($composer3, "C(DetailRow)231@9205L499:AboutPage.kt#frind1");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(label) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(value) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1603165444, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.about.DetailRow (AboutPage.kt:230)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            int $changed$iv$iv = (54 << 3) & 112;
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
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i2 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1546583088, "C237@9393L10,238@9450L11,235@9327L161,242@9563L10,244@9664L11,240@9497L201:AboutPage.kt#frind1");
            $composer2 = $composer3;
            TextKt.m2569Text4IGK_g(label, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, $dirty2 & 14, 0, 65530);
            TextKt.m2569Text4IGK_g(value, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnBackground(), 0L, (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, (($dirty2 >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65498);
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
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.about.AboutPageKt.DetailRow.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    AboutPageKt.DetailRow(label, value, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FeatureItem(final String text, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-1365584893);
        ComposerKt.sourceInformation($composer3, "C(FeatureItem)251@9764L472:AboutPage.kt#frind1");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(text) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 11) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1365584893, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.about.FeatureItem (AboutPage.kt:250)");
            }
            Modifier modifier$iv = PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(4), 1, null);
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv = (390 << 3) & 112;
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
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i2 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -2051372953, "C257@9958L11,255@9894L123,260@10026L39,263@10139L10,264@10196L11,261@10074L156:AboutPage.kt#frind1");
            TextKt.m2569Text4IGK_g("●", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 3078, 0, 131058);
            SpacerKt.Spacer(SizeKt.m670width3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), $composer3, 6);
            $composer2 = $composer3;
            TextKt.m2569Text4IGK_g(text, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnBackground(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, $dirty2 & 14, 0, 65530);
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
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.about.AboutPageKt.FeatureItem.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    AboutPageKt.FeatureItem(text, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
