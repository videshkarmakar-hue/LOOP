package com.videshkarmakar.loop.ui.page;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavBackStackEntry;
import com.videshkarmakar.loop.ui.page.live.LivePageKt;
import com.videshkarmakar.loop.ui.page.playlist.PlaylistPageKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeEntry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$HomeEntryKt {
    public static final ComposableSingletons$HomeEntryKt INSTANCE = new ComposableSingletons$HomeEntryKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit> f144lambda1 = ComposableLambdaKt.composableLambdaInstance(-1639733270, false, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.ComposableSingletons$HomeEntryKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
            invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
            Intrinsics.checkNotNullParameter(it, "it");
            ComposerKt.sourceInformation($composer, "C249@11715L14:HomeEntry.kt#hmxj0r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1639733270, $changed, -1, "com.videshkarmakar.loop.ui.page.ComposableSingletons$HomeEntryKt.lambda-1.<anonymous> (HomeEntry.kt:249)");
            }
            PlaylistPageKt.PlaylistPage(null, $composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit> f145lambda2 = ComposableLambdaKt.composableLambdaInstance(615770539, false, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.ComposableSingletons$HomeEntryKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
            invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
            Intrinsics.checkNotNullParameter(it, "it");
            ComposerKt.sourceInformation($composer, "C250@11781L10:HomeEntry.kt#hmxj0r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(615770539, $changed, -1, "com.videshkarmakar.loop.ui.page.ComposableSingletons$HomeEntryKt.lambda-2.<anonymous> (HomeEntry.kt:250)");
            }
            LivePageKt.LivePage(null, $composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit> m7178getLambda1$app_debug() {
        return f144lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit> m7179getLambda2$app_debug() {
        return f145lambda2;
    }
}
