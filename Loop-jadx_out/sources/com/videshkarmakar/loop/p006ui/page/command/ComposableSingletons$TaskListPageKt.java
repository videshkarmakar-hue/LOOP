package com.videshkarmakar.loop.p006ui.page.command;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.AddKt;
import androidx.compose.material.icons.outlined.CodeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.p001ui.Modifier;
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
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TaskListPage.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$TaskListPageKt {
    public static final ComposableSingletons$TaskListPageKt INSTANCE = new ComposableSingletons$TaskListPageKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f753lambda1 = ComposableLambdaKt.composableLambdaInstance(-1505699813, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskListPageKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C106@5050L38,107@5132L10,105@5017L178:TaskListPage.kt#klscgo");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1505699813, $changed, -1, "com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskListPageKt.lambda-1.<anonymous> (TaskListPage.kt:105)");
                }
                String strStringResource = StringResources_androidKt.stringResource(C3070R.string.running_tasks, $composer, 0);
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
    public static Function3<RowScope, Composer, Integer, Unit> f754lambda2 = ComposableLambdaKt.composableLambdaInstance(-1607718330, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskListPageKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TopAppBar, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
            ComposerKt.sourceInformation($composer, "C:TaskListPage.kt#klscgo");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1607718330, $changed, -1, "com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskListPageKt.lambda-2.<anonymous> (TaskListPage.kt:111)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f755lambda3 = ComposableLambdaKt.composableLambdaInstance(367466994, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskListPageKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C122@5726L38,122@5701L64:TaskListPage.kt#klscgo");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(367466994, $changed, -1, "com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskListPageKt.lambda-3.<anonymous> (TaskListPage.kt:122)");
            }
            IconKt.m2292Iconww6aTOc(AddKt.getAdd(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(C3070R.string.new_task, $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f756lambda4 = ComposableLambdaKt.composableLambdaInstance(1646179987, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskListPageKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C292@12342L39,292@12330L52:TaskListPage.kt#klscgo");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1646179987, $changed, -1, "com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskListPageKt.lambda-4.<anonymous> (TaskListPage.kt:292)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.video_url, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f757lambda5 = ComposableLambdaKt.composableLambdaInstance(-1240723217, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskListPageKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C349@14244L66:TaskListPage.kt#klscgo");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1240723217, $changed, -1, "com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskListPageKt.lambda-5.<anonymous> (TaskListPage.kt:349)");
            }
            IconKt.m2292Iconww6aTOc(CodeKt.getCode(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-6, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f758lambda6 = ComposableLambdaKt.composableLambdaInstance(-118444018, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskListPageKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C348@14178L48,348@14166L61:TaskListPage.kt#klscgo");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-118444018, $changed, -1, "com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskListPageKt.lambda-6.<anonymous> (TaskListPage.kt:348)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.template_selection, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-7, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f759lambda7 = ComposableLambdaKt.composableLambdaInstance(-1615838125, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskListPageKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C353@14528L40:TaskListPage.kt#klscgo");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1615838125, $changed, -1, "com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskListPageKt.lambda-7.<anonymous> (TaskListPage.kt:353)");
            }
            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(4)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-8, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f760lambda8 = ComposableLambdaKt.composableLambdaInstance(-1848759172, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskListPageKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C363@14982L40:TaskListPage.kt#klscgo");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1848759172, $changed, -1, "com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskListPageKt.lambda-8.<anonymous> (TaskListPage.kt:363)");
            }
            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(4)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7321getLambda1$app_debug() {
        return f753lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7322getLambda2$app_debug() {
        return f754lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7323getLambda3$app_debug() {
        return f755lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7324getLambda4$app_debug() {
        return f756lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7325getLambda5$app_debug() {
        return f757lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7326getLambda6$app_debug() {
        return f758lambda6;
    }

    /* JADX INFO: renamed from: getLambda-7$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7327getLambda7$app_debug() {
        return f759lambda7;
    }

    /* JADX INFO: renamed from: getLambda-8$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7328getLambda8$app_debug() {
        return f760lambda8;
    }
}
