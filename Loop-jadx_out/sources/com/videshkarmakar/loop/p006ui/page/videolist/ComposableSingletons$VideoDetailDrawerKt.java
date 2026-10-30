package com.videshkarmakar.loop.p006ui.page.videolist;

import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: VideoDetailDrawer.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$VideoDetailDrawerKt {
    public static final ComposableSingletons$VideoDetailDrawerKt INSTANCE = new ComposableSingletons$VideoDetailDrawerKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1043lambda1 = ComposableLambdaKt.composableLambdaInstance(-963699545, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoDetailDrawerKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C119@4792L7,118@4667L174:VideoDetailDrawer.kt#861hqi");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-963699545, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoDetailDrawerKt.lambda-1.<anonymous> (VideoDetailDrawer.kt:118)");
                }
                ModalBottomSheetValue modalBottomSheetValue = ModalBottomSheetValue.Expanded;
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer);
                VideoDetailDrawerKt.VideoDetailDrawerImpl(new ModalBottomSheetState(modalBottomSheetValue, (Density) objConsume, null, null, false, 28, null), null, null, null, null, false, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoDetailDrawerKt$lambda-1$1.1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                }, null, null, null, $composer, ModalBottomSheetState.$stable | 1572864, 958);
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
    public final Function2<Composer, Integer, Unit> m7631getLambda1$app_debug() {
        return f1043lambda1;
    }
}
