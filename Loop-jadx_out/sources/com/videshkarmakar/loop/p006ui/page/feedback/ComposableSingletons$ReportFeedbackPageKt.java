package com.videshkarmakar.loop.p006ui.page.feedback;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ReportKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReportFeedbackPage.kt */
/* JADX INFO: loaded from: classes16.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$ReportFeedbackPageKt {
    public static final ComposableSingletons$ReportFeedbackPageKt INSTANCE = new ComposableSingletons$ReportFeedbackPageKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f837lambda1 = ComposableLambdaKt.composableLambdaInstance(-290232818, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.feedback.ComposableSingletons$ReportFeedbackPageKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            ComposerKt.sourceInformation($composer, "C124@5181L22:ReportFeedbackPage.kt#7bbn9k");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-290232818, $changed, -1, "com.videshkarmakar.loop.ui.page.feedback.ComposableSingletons$ReportFeedbackPageKt.lambda-1.<anonymous> (ReportFeedbackPage.kt:124)");
            }
            TextKt.m2817Text4IGK_g("Submit Another", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f838lambda2 = ComposableLambdaKt.composableLambdaInstance(155363, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.feedback.ComposableSingletons$ReportFeedbackPageKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C181@7706L39:ReportFeedbackPage.kt#7bbn9k");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(155363, $changed, -1, "com.videshkarmakar.loop.ui.page.feedback.ComposableSingletons$ReportFeedbackPageKt.lambda-2.<anonymous> (ReportFeedbackPage.kt:181)");
            }
            TextKt.m2817Text4IGK_g("Describe your issue or feedback", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f839lambda3 = ComposableLambdaKt.composableLambdaInstance(-557828700, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.feedback.ComposableSingletons$ReportFeedbackPageKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C182@7785L52:ReportFeedbackPage.kt#7bbn9k");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-557828700, $changed, -1, "com.videshkarmakar.loop.ui.page.feedback.ComposableSingletons$ReportFeedbackPageKt.lambda-3.<anonymous> (ReportFeedbackPage.kt:182)");
            }
            TextKt.m2817Text4IGK_g("Please provide as much detail as possible...", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f840lambda4 = ComposableLambdaKt.composableLambdaInstance(333339788, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.feedback.ComposableSingletons$ReportFeedbackPageKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C203@8636L22:ReportFeedbackPage.kt#7bbn9k");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(333339788, $changed, -1, "com.videshkarmakar.loop.ui.page.feedback.ComposableSingletons$ReportFeedbackPageKt.lambda-4.<anonymous> (ReportFeedbackPage.kt:203)");
            }
            TextKt.m2817Text4IGK_g("your@email.com", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f841lambda5 = ComposableLambdaKt.composableLambdaInstance(981567245, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.feedback.ComposableSingletons$ReportFeedbackPageKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C204@8698L36:ReportFeedbackPage.kt#7bbn9k");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(981567245, $changed, -1, "com.videshkarmakar.loop.ui.page.feedback.ComposableSingletons$ReportFeedbackPageKt.lambda-5.<anonymous> (ReportFeedbackPage.kt:204)");
            }
            TextKt.m2817Text4IGK_g("So we can follow up with you", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-6, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f842lambda6 = ComposableLambdaKt.composableLambdaInstance(1060877773, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.feedback.ComposableSingletons$ReportFeedbackPageKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            ComposerKt.sourceInformation($composer, "C227@9640L203,234@9964L10,232@9864L201:ReportFeedbackPage.kt#7bbn9k");
            if (($changed & 81) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1060877773, $changed, -1, "com.videshkarmakar.loop.ui.page.feedback.ComposableSingletons$ReportFeedbackPageKt.lambda-6.<anonymous> (ReportFeedbackPage.kt:227)");
                }
                IconKt.m2292Iconww6aTOc(ReportKt.getReport(Icons.Outlined.INSTANCE), (String) null, PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(8), 0.0f, 11, null), 0L, $composer, 432, 8);
                TextKt.m2817Text4IGK_g("Submit Report", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelLarge(), $composer, 196614, 0, 65502);
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
    public final Function3<RowScope, Composer, Integer, Unit> m7420getLambda1$app_debug() {
        return f837lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7421getLambda2$app_debug() {
        return f838lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7422getLambda3$app_debug() {
        return f839lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7423getLambda4$app_debug() {
        return f840lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7424getLambda5$app_debug() {
        return f841lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7425getLambda6$app_debug() {
        return f842lambda6;
    }
}
