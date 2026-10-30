package com.videshkarmakar.loop.p006ui.page.command;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material.icons.outlined.UnfoldMoreKt;
import androidx.compose.material3.AssistChipDefaults;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.RotateKt;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
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

/* JADX INFO: compiled from: TaskLogPage.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$TaskLogPageKt {
    public static final ComposableSingletons$TaskLogPageKt INSTANCE = new ComposableSingletons$TaskLogPageKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f761lambda1 = ComposableLambdaKt.composableLambdaInstance(684658237, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskLogPageKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C68@3072L29,69@3145L10,67@3039L169:TaskLogPage.kt#klscgo");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(684658237, $changed, -1, "com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskLogPageKt.lambda-1.<anonymous> (TaskLogPage.kt:67)");
                }
                String strStringResource = StringResources_androidKt.stringResource(C3070R.string.logs, $composer, 0);
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
    public static Function2<Composer, Integer, Unit> f762lambda2 = ComposableLambdaKt.composableLambdaInstance(-1867900964, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskLogPageKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C73@3351L30,73@3324L58:TaskLogPage.kt#klscgo");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1867900964, $changed, -1, "com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskLogPageKt.lambda-2.<anonymous> (TaskLogPage.kt:73)");
            }
            IconKt.m2292Iconww6aTOc(CloseKt.getClose(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(C3070R.string.close, $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f763lambda3 = ComposableLambdaKt.composableLambdaInstance(1966652264, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskLogPageKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TopAppBar, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
            ComposerKt.sourceInformation($composer, "C:TaskLogPage.kt#klscgo");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1966652264, $changed, -1, "com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskLogPageKt.lambda-3.<anonymous> (TaskLogPage.kt:76)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f764lambda4 = ComposableLambdaKt.composableLambdaInstance(-1087757328, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskLogPageKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C129@6075L36,129@6070L42:TaskLogPage.kt#klscgo");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1087757328, $changed, -1, "com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskLogPageKt.lambda-4.<anonymous> (TaskLogPage.kt:129)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.expand, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f765lambda5 = ComposableLambdaKt.composableLambdaInstance(-484031437, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskLogPageKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C131@6200L460:TaskLogPage.kt#klscgo");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-484031437, $changed, -1, "com.videshkarmakar.loop.ui.page.command.ComposableSingletons$TaskLogPageKt.lambda-5.<anonymous> (TaskLogPage.kt:131)");
                }
                IconKt.m2292Iconww6aTOc(UnfoldMoreKt.getUnfoldMore(Icons.Outlined.INSTANCE), (String) null, RotateKt.rotate(SizeKt.m913size3ABfNKs(Modifier.INSTANCE, AssistChipDefaults.INSTANCE.m1938getIconSizeD9Ej5fM()), 90.0f), 0L, $composer, 48, 8);
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
    public final Function2<Composer, Integer, Unit> m7329getLambda1$app_debug() {
        return f761lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7330getLambda2$app_debug() {
        return f762lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7331getLambda3$app_debug() {
        return f763lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7332getLambda4$app_debug() {
        return f764lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7333getLambda5$app_debug() {
        return f765lambda5;
    }
}
