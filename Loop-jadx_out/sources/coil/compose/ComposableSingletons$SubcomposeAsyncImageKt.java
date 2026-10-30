package coil.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: SubcomposeAsyncImage.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$SubcomposeAsyncImageKt {
    public static final ComposableSingletons$SubcomposeAsyncImageKt INSTANCE = new ComposableSingletons$SubcomposeAsyncImageKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> f691lambda1 = ComposableLambdaKt.composableLambdaInstance(-1692951203, false, new Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit>() { // from class: coil.compose.ComposableSingletons$SubcomposeAsyncImageKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, Integer num) {
            invoke(subcomposeAsyncImageScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(SubcomposeAsyncImageScope $this$null, Composer $composer, int $changed) {
            int $dirty = $changed;
            if (($changed & 14) == 0) {
                $dirty |= $composer.changed($this$null) ? 4 : 2;
            }
            if (($dirty & 91) == 18 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1692951203, $dirty, -1, "coil.compose.ComposableSingletons$SubcomposeAsyncImageKt.lambda-1.<anonymous> (SubcomposeAsyncImage.kt:238)");
            }
            SubcomposeAsyncImageKt.SubcomposeAsyncImageContent($this$null, null, null, null, null, null, 0.0f, null, $composer, $dirty & 14, 127);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$coil_compose_base_release, reason: not valid java name */
    public final Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> m7136getLambda1$coil_compose_base_release() {
        return f691lambda1;
    }
}
