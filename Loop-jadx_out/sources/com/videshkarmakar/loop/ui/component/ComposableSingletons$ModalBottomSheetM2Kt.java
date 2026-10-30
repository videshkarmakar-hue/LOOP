package com.videshkarmakar.loop.ui.component;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModalBottomSheetM2.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$ModalBottomSheetM2Kt {
    public static final ComposableSingletons$ModalBottomSheetM2Kt INSTANCE = new ComposableSingletons$ModalBottomSheetM2Kt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<ColumnScope, Composer, Integer, Unit> f128lambda1 = ComposableLambdaKt.composableLambdaInstance(-1620559174, false, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$ModalBottomSheetM2Kt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
            invoke(columnScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ColumnScope $this$null, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter($this$null, "$this$null");
            ComposerKt.sourceInformation($composer, "C:ModalBottomSheetM2.kt#g7nzpb");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1620559174, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$ModalBottomSheetM2Kt.lambda-1.<anonymous> (ModalBottomSheetM2.kt:37)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f129lambda2 = ComposableLambdaKt.composableLambdaInstance(1812567691, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$ModalBottomSheetM2Kt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C:ModalBottomSheetM2.kt#g7nzpb");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1812567691, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$ModalBottomSheetM2Kt.lambda-2.<anonymous> (ModalBottomSheetM2.kt:91)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function3<ColumnScope, Composer, Integer, Unit> m7145getLambda1$app_debug() {
        return f128lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7146getLambda2$app_debug() {
        return f129lambda2;
    }
}
