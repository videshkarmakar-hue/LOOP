package com.videshkarmakar.loop.p006ui.component;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ContentCutKt;
import androidx.compose.material.icons.outlined.EditKt;
import androidx.compose.material.icons.outlined.ImageKt;
import androidx.compose.material.icons.outlined.MoreVertKt;
import androidx.compose.material.icons.outlined.VerticalSplitKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormatItem.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$FormatItemKt {
    public static final ComposableSingletons$FormatItemKt INSTANCE = new ComposableSingletons$FormatItemKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f710lambda1 = ComposableLambdaKt.composableLambdaInstance(1766506173, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C159@6542L47,157@6457L203:FormatItem.kt#g7nzpb");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1766506173, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt.lambda-1.<anonymous> (FormatItem.kt:157)");
                }
                IconKt.m2292Iconww6aTOc(MoreVertKt.getMoreVert(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(C3070R.string.show_more_actions, $composer, 0), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(18)), 0L, $composer, 384, 8);
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
    public static Function2<Composer, Integer, Unit> f718lambda2 = ComposableLambdaKt.composableLambdaInstance(1007380149, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C172@7088L36,172@7076L49:FormatItem.kt#g7nzpb");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1007380149, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt.lambda-2.<anonymous> (FormatItem.kt:172)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.rename, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f719lambda3 = ComposableLambdaKt.composableLambdaInstance(-238926766, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C171@6998L45:FormatItem.kt#g7nzpb");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-238926766, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt.lambda-3.<anonymous> (FormatItem.kt:171)");
            }
            IconKt.m2292Iconww6aTOc(EditKt.getEdit(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f720lambda4 = ComposableLambdaKt.composableLambdaInstance(-1153534178, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C179@7421L39,179@7409L52:FormatItem.kt#g7nzpb");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1153534178, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt.lambda-4.<anonymous> (FormatItem.kt:179)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.thumbnail, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f721lambda5 = ComposableLambdaKt.composableLambdaInstance(-558603909, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C178@7330L46:FormatItem.kt#g7nzpb");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-558603909, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt.lambda-5.<anonymous> (FormatItem.kt:178)");
            }
            IconKt.m2292Iconww6aTOc(ImageKt.getImage(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-6, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f722lambda6 = ComposableLambdaKt.composableLambdaInstance(-1377575814, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C187@7851L40,187@7839L53:FormatItem.kt#g7nzpb");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1377575814, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt.lambda-6.<anonymous> (FormatItem.kt:187)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.clip_video, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-7, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f723lambda7 = ComposableLambdaKt.composableLambdaInstance(-156493353, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C186@7765L37:FormatItem.kt#g7nzpb");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-156493353, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt.lambda-7.<anonymous> (FormatItem.kt:186)");
            }
            IconKt.m2292Iconww6aTOc(ContentCutKt.getContentCut(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-8, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f724lambda8 = ComposableLambdaKt.composableLambdaInstance(416321443, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C196@8327L41,196@8315L54:FormatItem.kt#g7nzpb");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(416321443, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt.lambda-8.<anonymous> (FormatItem.kt:196)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.split_video, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-9, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f725lambda9 = ComposableLambdaKt.composableLambdaInstance(1350494656, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C195@8238L40:FormatItem.kt#g7nzpb");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1350494656, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt.lambda-9.<anonymous> (FormatItem.kt:195)");
            }
            IconKt.m2292Iconww6aTOc(VerticalSplitKt.getVerticalSplit(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-10, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f711lambda10 = ComposableLambdaKt.composableLambdaInstance(1444798032, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt$lambda-10$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C214@8675L559:FormatItem.kt#g7nzpb");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1444798032, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt.lambda-10.<anonymous> (FormatItem.kt:214)");
                }
                ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                Modifier modifier$iv = Modifier.INSTANCE;
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
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
                ComposerKt.sourceInformationMarkerStart($composer, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i2 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 865043698, "C216@8748L53,217@8832L101,215@8700L520:FormatItem.kt#g7nzpb");
                FormatItemKt.FormatVideoPreview(null, StringResources_androidKt.stringResource(C3070R.string.video_title_sample_text, $composer, 0), StringResources_androidKt.stringResource(C3070R.string.video_creator_sample_text, $composer, 0), "", 7890, false, false, true, true, null, null, null, null, $composer, 115043328, 0, 7681);
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

    /* JADX INFO: renamed from: lambda-11, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f712lambda11 = ComposableLambdaKt.composableLambdaInstance(660507701, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt$lambda-11$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C213@8653L591:FormatItem.kt#g7nzpb");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(660507701, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt.lambda-11.<anonymous> (FormatItem.kt:213)");
                }
                SurfaceKt.m2666SurfaceT9BRK9s(null, null, 0L, 0L, 0.0f, 0.0f, null, ComposableSingletons$FormatItemKt.INSTANCE.m7262getLambda10$app_debug(), $composer, 12582912, 127);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-12, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f713lambda12 = ComposableLambdaKt.composableLambdaInstance(308099940, false, ComposableSingletons$FormatItemKt$lambda12$1.INSTANCE);

    /* JADX INFO: renamed from: lambda-13, reason: not valid java name */
    public static Function3<LazyGridItemScope, Composer, Integer, Unit> f714lambda13 = ComposableLambdaKt.composableLambdaInstance(1484518277, false, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt$lambda-13$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
            invoke(lazyGridItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyGridItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C477@17527L175:FormatItem.kt#g7nzpb");
            if (($changed & 81) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1484518277, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt.lambda-13.<anonymous> (FormatItem.kt:477)");
                }
                FormatItemKt.m7303FormatSubtitleFNF3uiM(PaddingKt.m870paddingVpY3zN4$default(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, C1979Dp.m6801constructorimpl(12), 0.0f, C1979Dp.m6801constructorimpl(4), 5, null), C1979Dp.m6801constructorimpl(12), 0.0f, 2, null), "Suggested", 0L, $composer, 54, 4);
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
    public static Function3<LazyGridItemScope, Composer, Integer, Unit> f715lambda14 = ComposableLambdaKt.composableLambdaInstance(1710950909, false, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt$lambda-14$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
            invoke(lazyGridItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyGridItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C495@18123L30,496@18189L11,494@18088L262:FormatItem.kt#g7nzpb");
            if (($changed & 81) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1710950909, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt.lambda-14.<anonymous> (FormatItem.kt:494)");
                }
                FormatItemKt.m7303FormatSubtitleFNF3uiM(PaddingKt.m870paddingVpY3zN4$default(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, C1979Dp.m6801constructorimpl(12), 0.0f, C1979Dp.m6801constructorimpl(4), 5, null), C1979Dp.m6801constructorimpl(12), 0.0f, 2, null), StringResources_androidKt.stringResource(C3070R.string.audio, $composer, 0), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getTertiary(), $composer, 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-15, reason: not valid java name */
    public static Function3<LazyGridItemScope, Composer, Integer, Unit> f716lambda15 = ComposableLambdaKt.composableLambdaInstance(428778623, false, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt$lambda-15$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
            invoke(lazyGridItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyGridItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C528@19289L35,527@19254L199:FormatItem.kt#g7nzpb");
            if (($changed & 81) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(428778623, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt.lambda-15.<anonymous> (FormatItem.kt:527)");
                }
                FormatItemKt.m7303FormatSubtitleFNF3uiM(PaddingKt.m870paddingVpY3zN4$default(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, C1979Dp.m6801constructorimpl(12), 0.0f, C1979Dp.m6801constructorimpl(4), 5, null), C1979Dp.m6801constructorimpl(12), 0.0f, 2, null), StringResources_androidKt.stringResource(C3070R.string.video_only, $composer, 0), 0L, $composer, 6, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-16, reason: not valid java name */
    public static Function3<LazyGridItemScope, Composer, Integer, Unit> f717lambda16 = ComposableLambdaKt.composableLambdaInstance(-212307520, false, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt$lambda-16$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
            invoke(lazyGridItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyGridItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C546@19876L30,547@19942L11,545@19841L251:FormatItem.kt#g7nzpb");
            if (($changed & 81) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-212307520, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt.lambda-16.<anonymous> (FormatItem.kt:545)");
                }
                FormatItemKt.m7303FormatSubtitleFNF3uiM(PaddingKt.m870paddingVpY3zN4$default(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, C1979Dp.m6801constructorimpl(12), 0.0f, C1979Dp.m6801constructorimpl(4), 5, null), C1979Dp.m6801constructorimpl(12), 0.0f, 2, null), StringResources_androidKt.stringResource(C3070R.string.video, $composer, 0), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSecondary(), $composer, 6, 0);
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
    public final Function2<Composer, Integer, Unit> m7261getLambda1$app_debug() {
        return f710lambda1;
    }

    /* JADX INFO: renamed from: getLambda-10$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7262getLambda10$app_debug() {
        return f711lambda10;
    }

    /* JADX INFO: renamed from: getLambda-11$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7263getLambda11$app_debug() {
        return f712lambda11;
    }

    /* JADX INFO: renamed from: getLambda-12$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7264getLambda12$app_debug() {
        return f713lambda12;
    }

    /* JADX INFO: renamed from: getLambda-13$app_debug, reason: not valid java name */
    public final Function3<LazyGridItemScope, Composer, Integer, Unit> m7265getLambda13$app_debug() {
        return f714lambda13;
    }

    /* JADX INFO: renamed from: getLambda-14$app_debug, reason: not valid java name */
    public final Function3<LazyGridItemScope, Composer, Integer, Unit> m7266getLambda14$app_debug() {
        return f715lambda14;
    }

    /* JADX INFO: renamed from: getLambda-15$app_debug, reason: not valid java name */
    public final Function3<LazyGridItemScope, Composer, Integer, Unit> m7267getLambda15$app_debug() {
        return f716lambda15;
    }

    /* JADX INFO: renamed from: getLambda-16$app_debug, reason: not valid java name */
    public final Function3<LazyGridItemScope, Composer, Integer, Unit> m7268getLambda16$app_debug() {
        return f717lambda16;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7269getLambda2$app_debug() {
        return f718lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7270getLambda3$app_debug() {
        return f719lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7271getLambda4$app_debug() {
        return f720lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7272getLambda5$app_debug() {
        return f721lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7273getLambda6$app_debug() {
        return f722lambda6;
    }

    /* JADX INFO: renamed from: getLambda-7$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7274getLambda7$app_debug() {
        return f723lambda7;
    }

    /* JADX INFO: renamed from: getLambda-8$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7275getLambda8$app_debug() {
        return f724lambda8;
    }

    /* JADX INFO: renamed from: getLambda-9$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7276getLambda9$app_debug() {
        return f725lambda9;
    }
}
