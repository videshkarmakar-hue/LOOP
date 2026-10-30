package com.videshkarmakar.loop.p006ui.component;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModalBottomSheetM3.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$ModalBottomSheetM3Kt {
    public static final ComposableSingletons$ModalBottomSheetM3Kt INSTANCE = new ComposableSingletons$ModalBottomSheetM3Kt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<ColumnScope, Composer, Integer, Unit> f732lambda1 = ComposableLambdaKt.composableLambdaInstance(1586147241, false, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$ModalBottomSheetM3Kt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
            invoke(columnScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ColumnScope $this$null, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter($this$null, "$this$null");
            ComposerKt.sourceInformation($composer, "C:ModalBottomSheetM3.kt#g7nzpb");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1586147241, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$ModalBottomSheetM3Kt.lambda-1.<anonymous> (ModalBottomSheetM3.kt:35)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function3<ColumnScope, Composer, Integer, Unit> m7283getLambda1$app_debug() {
        return f732lambda1;
    }
}
