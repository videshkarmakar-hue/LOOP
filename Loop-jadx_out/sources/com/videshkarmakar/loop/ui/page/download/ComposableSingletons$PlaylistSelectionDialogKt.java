package com.videshkarmakar.loop.ui.page.download;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.PlaylistAddKt;
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

/* JADX INFO: compiled from: PlaylistSelectionDialog.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$PlaylistSelectionDialogKt {
    public static final ComposableSingletons$PlaylistSelectionDialogKt INSTANCE = new ComposableSingletons$PlaylistSelectionDialogKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f212lambda1 = ComposableLambdaKt.composableLambdaInstance(1695842604, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$PlaylistSelectionDialogKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C55@2256L38:PlaylistSelectionDialog.kt#y3famj");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1695842604, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$PlaylistSelectionDialogKt.lambda-1.<anonymous> (PlaylistSelectionDialog.kt:55)");
            }
            IconKt.m2044Iconww6aTOc(PlaylistAddKt.getPlaylistAdd(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f213lambda2 = ComposableLambdaKt.composableLambdaInstance(1945121005, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$PlaylistSelectionDialogKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C56@2321L49,56@2316L55:PlaylistSelectionDialog.kt#y3famj");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1945121005, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$PlaylistSelectionDialogKt.lambda-2.<anonymous> (PlaylistSelectionDialog.kt:56)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.download_range_selection, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f214lambda3 = ComposableLambdaKt.composableLambdaInstance(-151080424, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$PlaylistSelectionDialogKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C81@3404L29,81@3399L35:PlaylistSelectionDialog.kt#y3famj");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-151080424, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$PlaylistSelectionDialogKt.lambda-3.<anonymous> (PlaylistSelectionDialog.kt:81)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.from, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f215lambda4 = ComposableLambdaKt.composableLambdaInstance(-698838641, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$PlaylistSelectionDialogKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C104@4483L27,104@4478L33:PlaylistSelectionDialog.kt#y3famj");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-698838641, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$PlaylistSelectionDialogKt.lambda-4.<anonymous> (PlaylistSelectionDialog.kt:104)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.to, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7246getLambda1$app_debug() {
        return f212lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7247getLambda2$app_debug() {
        return f213lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7248getLambda3$app_debug() {
        return f214lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7249getLambda4$app_debug() {
        return f215lambda4;
    }
}
