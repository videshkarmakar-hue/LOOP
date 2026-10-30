package com.videshkarmakar.loop.p006ui.component;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TopAppBar.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$TopAppBarKt {
    public static final ComposableSingletons$TopAppBarKt INSTANCE = new ComposableSingletons$TopAppBarKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f737lambda1 = ComposableLambdaKt.composableLambdaInstance(-450854979, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$TopAppBarKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C:TopAppBar.kt#g7nzpb");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-450854979, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$TopAppBarKt.lambda-1.<anonymous> (TopAppBar.kt:23)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f738lambda2 = ComposableLambdaKt.composableLambdaInstance(-320212069, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$TopAppBarKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope $this$null, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter($this$null, "$this$null");
            ComposerKt.sourceInformation($composer, "C:TopAppBar.kt#g7nzpb");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-320212069, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$TopAppBarKt.lambda-2.<anonymous> (TopAppBar.kt:24)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f739lambda3 = ComposableLambdaKt.composableLambdaInstance(206496614, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$TopAppBarKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C:TopAppBar.kt#g7nzpb");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(206496614, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$TopAppBarKt.lambda-3.<anonymous> (TopAppBar.kt:59)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f740lambda4 = ComposableLambdaKt.composableLambdaInstance(-1663895096, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$TopAppBarKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope $this$null, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter($this$null, "$this$null");
            ComposerKt.sourceInformation($composer, "C:TopAppBar.kt#g7nzpb");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1663895096, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$TopAppBarKt.lambda-4.<anonymous> (TopAppBar.kt:60)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7288getLambda1$app_debug() {
        return f737lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7289getLambda2$app_debug() {
        return f738lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7290getLambda3$app_debug() {
        return f739lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7291getLambda4$app_debug() {
        return f740lambda4;
    }
}
