package com.videshkarmakar.loop.p006ui.page.download;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material.icons.outlined.EditKt;
import androidx.compose.material.icons.outlined.SubtitlesKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.p001ui.unit.TextUnitKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.component.FormatItemKt;
import com.videshkarmakar.loop.p006ui.component.PreferenceItemsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormatPage.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$FormatPageKt {
    public static final ComposableSingletons$FormatPageKt INSTANCE = new ComposableSingletons$FormatPageKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f790lambda1 = ComposableLambdaKt.composableLambdaInstance(1964189285, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C377@14771L41,378@14856L10,376@14738L181:FormatPage.kt#y3famj");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1964189285, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt.lambda-1.<anonymous> (FormatPage.kt:376)");
                }
                String strStringResource = StringResources_androidKt.stringResource(C3070R.string.format_selection, $composer, 0);
                TextStyle titleMedium = MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium();
                TextKt.m2817Text4IGK_g(strStringResource, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, titleMedium.m6277copyp1EtxEg((16777213 & 1) != 0 ? titleMedium.spanStyle.m6199getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? titleMedium.spanStyle.getFontSize() : TextUnitKt.getSp(18), (16777213 & 4) != 0 ? titleMedium.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? titleMedium.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? titleMedium.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? titleMedium.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? titleMedium.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? titleMedium.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? titleMedium.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? titleMedium.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? titleMedium.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? titleMedium.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? titleMedium.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? titleMedium.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? titleMedium.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? titleMedium.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? titleMedium.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? titleMedium.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? titleMedium.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? titleMedium.platformStyle : null, (16777213 & 1048576) != 0 ? titleMedium.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? titleMedium.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? titleMedium.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? titleMedium.paragraphStyle.getTextMotion() : null), $composer, 0, 0, 65534);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f799lambda2 = ComposableLambdaKt.composableLambdaInstance(-1402763546, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C382@15095L30,382@15068L58:FormatPage.kt#y3famj");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1402763546, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt.lambda-2.<anonymous> (FormatPage.kt:382)");
            }
            IconKt.m2292Iconww6aTOc(CloseKt.getClose(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(C3070R.string.close, $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f800lambda3 = ComposableLambdaKt.composableLambdaInstance(-754662185, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C394@15648L33,394@15636L46:FormatPage.kt#y3famj");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-754662185, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt.lambda-3.<anonymous> (FormatPage.kt:394)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.download, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function3<LazyGridItemScope, Composer, Integer, Unit> f801lambda4 = ComposableLambdaKt.composableLambdaInstance(2027038100, false, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
            invoke(lazyGridItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyGridItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C541@22697L346:FormatPage.kt#y3famj");
            if (($changed & 81) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2027038100, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt.lambda-4.<anonymous> (FormatPage.kt:541)");
                }
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                Modifier modifierM870paddingVpY3zN4$default = PaddingKt.m870paddingVpY3zN4$default(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, C1979Dp.m6801constructorimpl(12), 0.0f, C1979Dp.m6801constructorimpl(4), 5, null), C1979Dp.m6801constructorimpl(12), 0.0f, 2, null);
                ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, centerVertically, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv = (390 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifierM870paddingVpY3zN4$default);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    $composer.createNode(constructor);
                } else {
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                int i2 = ((390 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -733930123, "C546@22986L34,546@22964L57:FormatPage.kt#y3famj");
                FormatItemKt.m7303FormatSubtitleFNF3uiM(null, StringResources_androidKt.stringResource(C3070R.string.suggested, $composer, 0), 0L, $composer, 0, 5);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function3<LazyGridItemScope, Composer, Integer, Unit> f802lambda5 = ComposableLambdaKt.composableLambdaInstance(-1502582256, false, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
            invoke(lazyGridItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyGridItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C731@31194L33,729@31064L224:FormatPage.kt#y3famj");
            if (($changed & 81) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1502582256, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt.lambda-5.<anonymous> (FormatPage.kt:729)");
                }
                PreferenceItemsKt.PreferenceInfo(PaddingKt.m869paddingVpY3zN4(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(12), C1979Dp.m6801constructorimpl(12)), StringResources_androidKt.stringResource(C3070R.string.abs_hint, $composer, 0), null, false, $composer, 3078, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-6, reason: not valid java name */
    public static Function3<LazyGridItemScope, Composer, Integer, Unit> f803lambda6 = ComposableLambdaKt.composableLambdaInstance(-1584331761, false, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
            invoke(lazyGridItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyGridItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C736@31338L41:FormatPage.kt#y3famj");
            if (($changed & 81) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1584331761, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt.lambda-6.<anonymous> (FormatPage.kt:736)");
                }
                SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(32)), $composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-7, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f804lambda7 = ComposableLambdaKt.composableLambdaInstance(-741575578, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C781@32813L88:FormatPage.kt#y3famj");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-741575578, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt.lambda-7.<anonymous> (FormatPage.kt:781)");
                }
                IconKt.m2292Iconww6aTOc(EditKt.getEdit(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-8, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f805lambda8 = ComposableLambdaKt.composableLambdaInstance(1743488133, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C780@32755L36,780@32743L49:FormatPage.kt#y3famj");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1743488133, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt.lambda-8.<anonymous> (FormatPage.kt:780)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.rename, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-9, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f806lambda9 = ComposableLambdaKt.composableLambdaInstance(-1029341164, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C789@33137L35,789@33125L48:FormatPage.kt#y3famj");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1029341164, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt.lambda-9.<anonymous> (FormatPage.kt:789)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.title, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-10, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f791lambda10 = ComposableLambdaKt.composableLambdaInstance(-1721284115, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt$lambda-10$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C872@36157L71:FormatPage.kt#y3famj");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1721284115, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt.lambda-10.<anonymous> (FormatPage.kt:872)");
            }
            IconKt.m2292Iconww6aTOc(SubtitlesKt.getSubtitles(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-11, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f792lambda11 = ComposableLambdaKt.composableLambdaInstance(-755721298, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt$lambda-11$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C871@36088L47,871@36076L60:FormatPage.kt#y3famj");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-755721298, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt.lambda-11.<anonymous> (FormatPage.kt:871)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.subtitle_language, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-12, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f793lambda12 = ComposableLambdaKt.composableLambdaInstance(-1584069804, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt$lambda-12$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C887@36890L39,888@36985L10,889@37062L11,886@36845L364:FormatPage.kt#y3famj");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1584069804, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt.lambda-12.<anonymous> (FormatPage.kt:886)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.suggested, $composer, 0), PaddingKt.m869paddingVpY3zN4(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24), C1979Dp.m6801constructorimpl(4)), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleSmall(), $composer, 48, 0, 65528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-13, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f794lambda13 = ComposableLambdaKt.composableLambdaInstance(-1465382069, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt$lambda-13$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C913@38255L43,914@38354L10,915@38431L11,912@38210L475:FormatPage.kt#y3famj");
            if (($changed & 81) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1465382069, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt.lambda-13.<anonymous> (FormatPage.kt:912)");
                }
                TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.auto_subtitle, $composer, 0), PaddingKt.m869paddingVpY3zN4(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24), C1979Dp.m6801constructorimpl(12)), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleSmall(), $composer, 48, 0, 65528);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-14, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f795lambda14 = ComposableLambdaKt.composableLambdaInstance(659009371, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt$lambda-14$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            ComposerKt.sourceInformation($composer, "C1090@44195L34,1090@44183L47:FormatPage.kt#y3famj");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(659009371, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt.lambda-14.<anonymous> (FormatPage.kt:1090)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.okay, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-15, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f796lambda15 = ComposableLambdaKt.composableLambdaInstance(-876746145, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt$lambda-15$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope OutlinedButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
            ComposerKt.sourceInformation($composer, "C1095@44367L39,1095@44355L52:FormatPage.kt#y3famj");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-876746145, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt.lambda-15.<anonymous> (FormatPage.kt:1095)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.no_thanks, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-16, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f797lambda16 = ComposableLambdaKt.composableLambdaInstance(156985966, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt$lambda-16$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C1046@42440L115:FormatPage.kt#y3famj");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(156985966, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt.lambda-16.<anonymous> (FormatPage.kt:1046)");
                }
                IconKt.m2292Iconww6aTOc(androidx.compose.material.icons.filled.SubtitlesKt.getSubtitles(Icons.Filled.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-17, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f798lambda17 = ComposableLambdaKt.composableLambdaInstance(-545609873, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt$lambda-17$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C1041@42289L50,1040@42260L139:FormatPage.kt#y3famj");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-545609873, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$FormatPageKt.lambda-17.<anonymous> (FormatPage.kt:1040)");
                }
                TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.update_subtitle_languages, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6651boximpl(TextAlign.INSTANCE.m6658getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 130558);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7358getLambda1$app_debug() {
        return f790lambda1;
    }

    /* JADX INFO: renamed from: getLambda-10$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7359getLambda10$app_debug() {
        return f791lambda10;
    }

    /* JADX INFO: renamed from: getLambda-11$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7360getLambda11$app_debug() {
        return f792lambda11;
    }

    /* JADX INFO: renamed from: getLambda-12$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7361getLambda12$app_debug() {
        return f793lambda12;
    }

    /* JADX INFO: renamed from: getLambda-13$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7362getLambda13$app_debug() {
        return f794lambda13;
    }

    /* JADX INFO: renamed from: getLambda-14$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7363getLambda14$app_debug() {
        return f795lambda14;
    }

    /* JADX INFO: renamed from: getLambda-15$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7364getLambda15$app_debug() {
        return f796lambda15;
    }

    /* JADX INFO: renamed from: getLambda-16$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7365getLambda16$app_debug() {
        return f797lambda16;
    }

    /* JADX INFO: renamed from: getLambda-17$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7366getLambda17$app_debug() {
        return f798lambda17;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7367getLambda2$app_debug() {
        return f799lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7368getLambda3$app_debug() {
        return f800lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function3<LazyGridItemScope, Composer, Integer, Unit> m7369getLambda4$app_debug() {
        return f801lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function3<LazyGridItemScope, Composer, Integer, Unit> m7370getLambda5$app_debug() {
        return f802lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$app_debug, reason: not valid java name */
    public final Function3<LazyGridItemScope, Composer, Integer, Unit> m7371getLambda6$app_debug() {
        return f803lambda6;
    }

    /* JADX INFO: renamed from: getLambda-7$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7372getLambda7$app_debug() {
        return f804lambda7;
    }

    /* JADX INFO: renamed from: getLambda-8$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7373getLambda8$app_debug() {
        return f805lambda8;
    }

    /* JADX INFO: renamed from: getLambda-9$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7374getLambda9$app_debug() {
        return f806lambda9;
    }
}
