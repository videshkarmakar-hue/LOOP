package com.videshkarmakar.loop.p006ui.page.feedback;

import android.content.Context;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.FeedbackKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.input.VisualTransformation;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.unit.C1979Dp;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReportFeedbackPage.kt */
/* JADX INFO: loaded from: classes16.dex */
@Metadata(m194d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\b\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\t\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u008e\u0002"}, m195d2 = {"ReportFeedbackPage", "", "onNavigateBack", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_debug", "selectedCategory", "", "description", "contactEmail", "submitted", ""}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ReportFeedbackPageKt {
    public static final void ReportFeedbackPage(final Function0<Unit> onNavigateBack, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onNavigateBack, "onNavigateBack");
        Composer $composer3 = $composer.startRestartGroup(1396981244);
        ComposerKt.sourceInformation($composer3, "C(ReportFeedbackPage)39@1653L7,40@1689L31,41@1744L31,42@1800L31,43@1853L34,56@2159L11,57@2188L7980,54@2077L8091:ReportFeedbackPage.kt#7bbn9k");
        if (($changed & 1) == 0 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1396981244, $changed, -1, "com.videshkarmakar.loop.ui.page.feedback.ReportFeedbackPage (ReportFeedbackPage.kt:38)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.startReplaceGroup(65363723);
            ComposerKt.sourceInformation($composer3, "CC(remember):ReportFeedbackPage.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState selectedCategory$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(65363778);
            ComposerKt.sourceInformation($composer3, "CC(remember):ReportFeedbackPage.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableState description$delegate = (MutableState) value$iv2;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(65363834);
            ComposerKt.sourceInformation($composer3, "CC(remember):ReportFeedbackPage.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                $composer3.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final MutableState contactEmail$delegate = (MutableState) value$iv3;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(65363887);
            ComposerKt.sourceInformation($composer3, "CC(remember):ReportFeedbackPage.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            final MutableState submitted$delegate = (MutableState) value$iv4;
            $composer3.endReplaceGroup();
            final List categories = CollectionsKt.listOf((Object[]) new String[]{"Bug Report", "Feature Request", "Download Issue", "Performance Problem", "UI/UX Feedback", "Other"});
            $composer2 = $composer3;
            SurfaceKt.m2666SurfaceT9BRK9s(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getBackground(), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(163539863, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.feedback.ReportFeedbackPageKt.ReportFeedbackPage.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code duplicated, block: B:64:0x06f6  */
                public final void invoke(Composer $composer4, int $changed2) {
                    Function0<ComposeUiNode> function0;
                    Object value$iv5;
                    Object value$iv6;
                    boolean z;
                    Object value$iv7;
                    long j;
                    Object value$iv8;
                    ComposerKt.sourceInformation($composer4, "C61@2301L21,58@2198L7964:ReportFeedbackPage.kt#7bbn9k");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(163539863, $changed2, -1, "com.videshkarmakar.loop.ui.page.feedback.ReportFeedbackPage.<anonymous> (ReportFeedbackPage.kt:58)");
                        }
                        Modifier modifier$iv = PaddingKt.m868padding3ABfNKs(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, null, false, 14, null), C1979Dp.m6801constructorimpl(16));
                        Iterable iterable = categories;
                        final MutableState<Boolean> mutableState = submitted$delegate;
                        final MutableState<String> mutableState2 = selectedCategory$delegate;
                        final MutableState<String> mutableState3 = description$delegate;
                        final MutableState<String> mutableState4 = contactEmail$delegate;
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
                        int $changed3 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -650213738, "C67@2490L10,69@2600L11,65@2402L231,72@2647L40,76@2852L10,77@2913L11,74@2701L254,80@2969L41,240@10111L41:ReportFeedbackPage.kt#7bbn9k");
                        TextKt.m2817Text4IGK_g("Report / Feedback", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getHeadlineSmall(), $composer4, 196614, 0, 65498);
                        SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8)), $composer4, 6);
                        TextKt.m2817Text4IGK_g("Tell us about any issues, suggestions, or feedback you have. We're here to help!", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyMedium(), $composer4, 6, 0, 65530);
                        SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), $composer4, 6);
                        if (ReportFeedbackPageKt.ReportFeedbackPage$lambda$10(mutableState)) {
                            $composer4.startReplaceGroup(-650213050);
                            ComposerKt.sourceInformation($composer4, "87@3261L11,86@3194L136,90@3404L1865,84@3090L2179");
                            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            CardDefaults cardDefaults = CardDefaults.INSTANCE;
                            long primaryContainer = MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimaryContainer();
                            CardKt.Card(modifierFillMaxWidth$default, RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(16)), cardDefaults.m1979cardColorsro_MJ88(Color.m4289copywmQWz5c(primaryContainer, (14 & 1) != 0 ? Color.m4293getAlphaimpl(primaryContainer) : 0.3f, (14 & 2) != 0 ? Color.m4297getRedimpl(primaryContainer) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(primaryContainer) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(primaryContainer) : 0.0f), 0L, 0L, 0L, $composer4, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(252375476, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.feedback.ReportFeedbackPageKt$ReportFeedbackPage$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                                    invoke(columnScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ColumnScope Card, Composer $composer5, int $changed4) {
                                    Function0<ComposeUiNode> function1;
                                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                                    ComposerKt.sourceInformation($composer5, "C91@3426L1825:ReportFeedbackPage.kt#7bbn9k");
                                    if (($changed4 & 81) != 16 || !$composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(252375476, $changed4, -1, "com.videshkarmakar.loop.ui.page.feedback.ReportFeedbackPage.<anonymous>.<anonymous>.<anonymous> (ReportFeedbackPage.kt:91)");
                                        }
                                        Modifier modifier$iv2 = PaddingKt.m868padding3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24));
                                        Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getCenterHorizontally();
                                        final MutableState<Boolean> mutableState5 = mutableState;
                                        final MutableState<String> mutableState6 = mutableState2;
                                        final MutableState<String> mutableState7 = mutableState3;
                                        final MutableState<String> mutableState8 = mutableState4;
                                        ComposerKt.sourceInformationMarkerStart($composer5, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                        Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer5, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                                        int $changed$iv$iv2 = (390 << 3) & 112;
                                        ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                        CompositionLocalMap localMap$iv$iv2 = $composer5.getCurrentCompositionLocalMap();
                                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer5, modifier$iv2);
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                        if (!($composer5.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer5.startReusableNode();
                                        if ($composer5.getInserting()) {
                                            function1 = constructor2;
                                            $composer5.createNode(function1);
                                        } else {
                                            function1 = constructor2;
                                            $composer5.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer5);
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                        }
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                        int i2 = ($changed$iv$iv$iv2 >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer5, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                        int i3 = ((390 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer5, 1795557911, "C98@3794L11,95@3617L295,103@4042L10,105@4173L11,101@3937L286,107@4248L40,110@4499L10,111@4572L11,108@4313L313,113@4651L41,115@4763L234,114@4717L512:ReportFeedbackPage.kt#7bbn9k");
                                        IconKt.m2292Iconww6aTOc(FeedbackKt.getFeedback(Icons.Outlined.INSTANCE), (String) null, PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(12), 7, null), MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getPrimary(), $composer5, 432, 0);
                                        TextKt.m2817Text4IGK_g("Thank You!", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getOnBackground(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getTitleLarge(), $composer5, 196614, 0, 65498);
                                        SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8)), $composer5, 6);
                                        TextKt.m2817Text4IGK_g("Your report has been submitted successfully. We'll review it and get back to you if needed.", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getBodyMedium(), $composer5, 6, 0, 65530);
                                        SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(16)), $composer5, 6);
                                        $composer5.startReplaceGroup(1795559057);
                                        ComposerKt.sourceInformation($composer5, "CC(remember):ReportFeedbackPage.kt#9igjgp");
                                        Object value$iv9 = $composer5.rememberedValue();
                                        if (value$iv9 == Composer.INSTANCE.getEmpty()) {
                                            value$iv9 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.feedback.ReportFeedbackPageKt$ReportFeedbackPage$1$1$1$1$1$1
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
                                                    ReportFeedbackPageKt.ReportFeedbackPage$lambda$11(mutableState5, false);
                                                    mutableState6.setValue("");
                                                    mutableState7.setValue("");
                                                    mutableState8.setValue("");
                                                }
                                            };
                                            $composer5.updateRememberedValue(value$iv9);
                                        }
                                        $composer5.endReplaceGroup();
                                        ButtonKt.Button((Function0) value$iv9, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(12)), null, null, null, null, null, ComposableSingletons$ReportFeedbackPageKt.INSTANCE.m7420getLambda1$app_debug(), $composer5, 805306422, 500);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        $composer5.endNode();
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer5.skipToGroupEnd();
                                }
                            }, $composer4, 54), $composer4, 196614, 24);
                            $composer4.endReplaceGroup();
                        } else {
                            $composer4.startReplaceGroup(-650210771);
                            ComposerKt.sourceInformation($composer4, "133@5456L10,135@5576L11,131@5369L249,137@5635L40,166@7085L41,171@7265L10,173@7385L11,169@7175L252,175@7444L40,179@7598L20,177@7502L478,188@7998L41,193@8193L10,195@8313L11,191@8090L265,197@8372L40,201@8527L21,199@8430L418,209@8866L41,223@9469L11,222@9400L110,213@8996L183,212@8958L1125");
                            TextKt.m2817Text4IGK_g("Category", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnBackground(), 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getTitleMedium(), $composer4, 196614, 0, 65498);
                            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8)), $composer4, 6);
                            $composer4.startReplaceGroup(-650210436);
                            ComposerKt.sourceInformation($composer4, "*144@5941L335,151@6371L31,152@6425L624,140@5746L1303");
                            Iterable $this$forEach$iv = iterable;
                            int $i$f$forEach = 0;
                            Iterator it = $this$forEach$iv.iterator();
                            while (true) {
                                Iterable $this$forEach$iv2 = $this$forEach$iv;
                                if (!it.hasNext()) {
                                    break;
                                }
                                Object element$iv = it.next();
                                int $i$f$forEach2 = $i$f$forEach;
                                final String category = (String) element$iv;
                                Iterator it2 = it;
                                MeasurePolicy measurePolicy$iv2 = measurePolicy$iv;
                                int compositeKeyHash$iv$iv2 = compositeKeyHash$iv$iv;
                                int $changed4 = $changed3;
                                Modifier modifierM870paddingVpY3zN4$default = PaddingKt.m870paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, C1979Dp.m6801constructorimpl(4), 1, null);
                                CardDefaults cardDefaults2 = CardDefaults.INSTANCE;
                                if (Intrinsics.areEqual(ReportFeedbackPageKt.ReportFeedbackPage$lambda$1(mutableState2), category)) {
                                    $composer4.startReplaceGroup(301951280);
                                    ComposerKt.sourceInformation($composer4, "146@6078L11");
                                    long primaryContainer2 = MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimaryContainer();
                                    long jM4289copywmQWz5c = Color.m4289copywmQWz5c(primaryContainer2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(primaryContainer2) : 0.5f, (14 & 2) != 0 ? Color.m4297getRedimpl(primaryContainer2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(primaryContainer2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(primaryContainer2) : 0.0f);
                                    $composer4.endReplaceGroup();
                                    j = jM4289copywmQWz5c;
                                } else {
                                    $composer4.startReplaceGroup(301951405);
                                    ComposerKt.sourceInformation($composer4, "148@6205L11");
                                    long surfaceVariant = MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getSurfaceVariant();
                                    long jM4289copywmQWz5c2 = Color.m4289copywmQWz5c(surfaceVariant, (14 & 1) != 0 ? Color.m4293getAlphaimpl(surfaceVariant) : 0.3f, (14 & 2) != 0 ? Color.m4297getRedimpl(surfaceVariant) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(surfaceVariant) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(surfaceVariant) : 0.0f);
                                    $composer4.endReplaceGroup();
                                    j = jM4289copywmQWz5c2;
                                }
                                CardColors cardColorsM1979cardColorsro_MJ88 = cardDefaults2.m1979cardColorsro_MJ88(j, 0L, 0L, 0L, $composer4, CardDefaults.$stable << 12, 14);
                                RoundedCornerShape roundedCornerShapeM1146RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(12));
                                $composer4.startReplaceGroup(301951544);
                                ComposerKt.sourceInformation($composer4, "CC(remember):ReportFeedbackPage.kt#9igjgp");
                                boolean invalid$iv = $composer4.changed(category);
                                Object it$iv5 = $composer4.rememberedValue();
                                if (invalid$iv || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                    value$iv8 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.feedback.ReportFeedbackPageKt$ReportFeedbackPage$1$1$2$1$1
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
                                            mutableState2.setValue(category);
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv8);
                                } else {
                                    value$iv8 = it$iv5;
                                }
                                $composer4.endReplaceGroup();
                                CardKt.Card((Function0) value$iv8, modifierM870paddingVpY3zN4$default, false, roundedCornerShapeM1146RoundedCornerShape0680j_4, cardColorsM1979cardColorsro_MJ88, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1253181854, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.feedback.ReportFeedbackPageKt$ReportFeedbackPage$1$1$2$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                                        invoke(columnScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ColumnScope Card, Composer $composer5, int $changed5) {
                                        long j2;
                                        Intrinsics.checkNotNullParameter(Card, "$this$Card");
                                        ComposerKt.sourceInformation($composer5, "C156@6616L10,153@6451L576:ReportFeedbackPage.kt#7bbn9k");
                                        if (($changed5 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1253181854, $changed5, -1, "com.videshkarmakar.loop.ui.page.feedback.ReportFeedbackPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ReportFeedbackPage.kt:153)");
                                            }
                                            Modifier modifierM868padding3ABfNKs = PaddingKt.m868padding3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(16));
                                            TextStyle bodyMedium = MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getBodyMedium();
                                            FontWeight semiBold = Intrinsics.areEqual(ReportFeedbackPageKt.ReportFeedbackPage$lambda$1(mutableState2), category) ? FontWeight.INSTANCE.getSemiBold() : FontWeight.INSTANCE.getNormal();
                                            if (Intrinsics.areEqual(ReportFeedbackPageKt.ReportFeedbackPage$lambda$1(mutableState2), category)) {
                                                $composer5.startReplaceGroup(1795561180);
                                                ComposerKt.sourceInformation($composer5, "159@6874L11");
                                                long primary = MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getPrimary();
                                                $composer5.endReplaceGroup();
                                                j2 = primary;
                                            } else {
                                                $composer5.startReplaceGroup(1795561279);
                                                ComposerKt.sourceInformation($composer5, "161@6973L11");
                                                long onSurfaceVariant = MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getOnSurfaceVariant();
                                                $composer5.endReplaceGroup();
                                                j2 = onSurfaceVariant;
                                            }
                                            TextKt.m2817Text4IGK_g(category, modifierM868padding3ABfNKs, j2, 0L, (FontStyle) null, semiBold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, bodyMedium, $composer5, 48, 0, 65496);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }, $composer4, 54), $composer4, 100663344, 228);
                                $this$forEach$iv = $this$forEach$iv2;
                                $i$f$forEach = $i$f$forEach2;
                                it = it2;
                                measurePolicy$iv = measurePolicy$iv2;
                                compositeKeyHash$iv$iv = compositeKeyHash$iv$iv2;
                                $changed3 = $changed4;
                            }
                            $composer4.endReplaceGroup();
                            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(20)), $composer4, 6);
                            TextKt.m2817Text4IGK_g("Description", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnBackground(), 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getTitleMedium(), $composer4, 196614, 0, 65498);
                            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8)), $composer4, 6);
                            String strReportFeedbackPage$lambda$4 = ReportFeedbackPageKt.ReportFeedbackPage$lambda$4(mutableState3);
                            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            RoundedCornerShape roundedCornerShapeM1146RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(12));
                            $composer4.startReplaceGroup(-650208542);
                            ComposerKt.sourceInformation($composer4, "CC(remember):ReportFeedbackPage.kt#9igjgp");
                            Object it$iv6 = $composer4.rememberedValue();
                            if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                                value$iv5 = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.feedback.ReportFeedbackPageKt$ReportFeedbackPage$1$1$3$1
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
                                    public final void invoke2(String it3) {
                                        Intrinsics.checkNotNullParameter(it3, "it");
                                        mutableState3.setValue(it3);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv5);
                            } else {
                                value$iv5 = it$iv6;
                            }
                            $composer4.endReplaceGroup();
                            OutlinedTextFieldKt.OutlinedTextField(strReportFeedbackPage$lambda$4, (Function1<? super String, Unit>) value$iv5, modifierFillMaxWidth$default2, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ReportFeedbackPageKt.INSTANCE.m7421getLambda2$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ReportFeedbackPageKt.INSTANCE.m7422getLambda3$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 8, 4, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1146RoundedCornerShape0680j_5, (TextFieldColors) null, $composer4, 14156208, 905969664, 0, 5504824);
                            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(16)), $composer4, 6);
                            TextKt.m2817Text4IGK_g("Contact Email (Optional)", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnBackground(), 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getTitleMedium(), $composer4, 196614, 0, 65498);
                            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8)), $composer4, 6);
                            String strReportFeedbackPage$lambda$7 = ReportFeedbackPageKt.ReportFeedbackPage$lambda$7(mutableState4);
                            $composer4.startReplaceGroup(-650207613);
                            ComposerKt.sourceInformation($composer4, "CC(remember):ReportFeedbackPage.kt#9igjgp");
                            Object it$iv7 = $composer4.rememberedValue();
                            if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                                value$iv6 = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.feedback.ReportFeedbackPageKt$ReportFeedbackPage$1$1$4$1
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
                                    public final void invoke2(String it3) {
                                        Intrinsics.checkNotNullParameter(it3, "it");
                                        mutableState4.setValue(it3);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv6);
                            } else {
                                value$iv6 = it$iv7;
                            }
                            $composer4.endReplaceGroup();
                            OutlinedTextFieldKt.OutlinedTextField(strReportFeedbackPage$lambda$7, (Function1<? super String, Unit>) value$iv6, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ReportFeedbackPageKt.INSTANCE.m7423getLambda4$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ReportFeedbackPageKt.INSTANCE.m7424getLambda5$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(12)), (TextFieldColors) null, $composer4, 14156208, 12582912, 0, 6160184);
                            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), $composer4, 6);
                            Modifier modifierM899height3ABfNKs = SizeKt.m899height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(52));
                            RoundedCornerShape roundedCornerShapeM1146RoundedCornerShape0680j_6 = RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(12));
                            ButtonColors buttonColorsM1959buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1959buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, $composer4, ButtonDefaults.$stable << 12, 14);
                            if (ReportFeedbackPageKt.ReportFeedbackPage$lambda$1(mutableState2).length() > 0) {
                                if (ReportFeedbackPageKt.ReportFeedbackPage$lambda$4(mutableState3).length() > 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            } else {
                                z = false;
                            }
                            $composer4.startReplaceGroup(-650207144);
                            ComposerKt.sourceInformation($composer4, "CC(remember):ReportFeedbackPage.kt#9igjgp");
                            Object it$iv8 = $composer4.rememberedValue();
                            if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                                value$iv7 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.feedback.ReportFeedbackPageKt$ReportFeedbackPage$1$1$5$1
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
                                        if (ReportFeedbackPageKt.ReportFeedbackPage$lambda$1(mutableState2).length() > 0) {
                                            if (ReportFeedbackPageKt.ReportFeedbackPage$lambda$4(mutableState3).length() > 0) {
                                                ReportFeedbackPageKt.ReportFeedbackPage$lambda$11(mutableState, true);
                                            }
                                        }
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv7);
                            } else {
                                value$iv7 = it$iv8;
                            }
                            $composer4.endReplaceGroup();
                            ButtonKt.Button((Function0) value$iv7, modifierM899height3ABfNKs, z, roundedCornerShapeM1146RoundedCornerShape0680j_6, buttonColorsM1959buttonColorsro_MJ88, null, null, null, null, ComposableSingletons$ReportFeedbackPageKt.INSTANCE.m7425getLambda6$app_debug(), $composer4, 805306422, 480);
                            $composer4.endReplaceGroup();
                        }
                        SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(32)), $composer4, 6);
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
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.feedback.ReportFeedbackPageKt.ReportFeedbackPage.2
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
                    ReportFeedbackPageKt.ReportFeedbackPage(onNavigateBack, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ReportFeedbackPage$lambda$1(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ReportFeedbackPage$lambda$4(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ReportFeedbackPage$lambda$7(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ReportFeedbackPage$lambda$10(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReportFeedbackPage$lambda$11(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }
}
