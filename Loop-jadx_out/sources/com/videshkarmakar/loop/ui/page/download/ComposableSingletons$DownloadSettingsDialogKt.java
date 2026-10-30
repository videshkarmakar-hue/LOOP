package com.videshkarmakar.loop.ui.page.download;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.DoneAllKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DownloadSettingsDialog.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$DownloadSettingsDialogKt {
    public static final ComposableSingletons$DownloadSettingsDialogKt INSTANCE = new ComposableSingletons$DownloadSettingsDialogKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f183lambda1 = ComposableLambdaKt.composableLambdaInstance(1781001487, false, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$DownloadSettingsDialogKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
            invoke(animatedVisibilityScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
            ComposerKt.sourceInformation($composer, "C:DownloadSettingsDialog.kt#y3famj");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1781001487, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$DownloadSettingsDialogKt.lambda-1.<anonymous> (DownloadSettingsDialog.kt:399)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f184lambda2 = ComposableLambdaKt.composableLambdaInstance(-2103963817, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$DownloadSettingsDialogKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C429@19678L44,429@19666L57:DownloadSettingsDialog.kt#y3famj");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2103963817, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$DownloadSettingsDialogKt.lambda-2.<anonymous> (DownloadSettingsDialog.kt:429)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.format_sorting, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f185lambda3 = ComposableLambdaKt.composableLambdaInstance(-376425285, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$DownloadSettingsDialogKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C566@25229L39,566@25217L52:DownloadSettingsDialog.kt#y3famj");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-376425285, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$DownloadSettingsDialogKt.lambda-3.<anonymous> (DownloadSettingsDialog.kt:566)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.start_download, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f186lambda4 = ComposableLambdaKt.composableLambdaInstance(-654025151, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$DownloadSettingsDialogKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C569@25386L107:DownloadSettingsDialog.kt#y3famj");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-654025151, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$DownloadSettingsDialogKt.lambda-4.<anonymous> (DownloadSettingsDialog.kt:569)");
                }
                IconKt.m2044Iconww6aTOc(DoneAllKt.getDoneAll(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
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
    public static Function2<Composer, Integer, Unit> f187lambda5 = ComposableLambdaKt.composableLambdaInstance(631037378, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$DownloadSettingsDialogKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C574@25561L49,573@25535L143:DownloadSettingsDialog.kt#y3famj");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(631037378, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$DownloadSettingsDialogKt.lambda-5.<anonymous> (DownloadSettingsDialog.kt:573)");
                }
                TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.settings_before_download, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6403boximpl(TextAlign.INSTANCE.m6410getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 130558);
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
    public final Function3<AnimatedVisibilityScope, Composer, Integer, Unit> m7217getLambda1$app_debug() {
        return f183lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7218getLambda2$app_debug() {
        return f184lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7219getLambda3$app_debug() {
        return f185lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7220getLambda4$app_debug() {
        return f186lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7221getLambda5$app_debug() {
        return f187lambda5;
    }
}
