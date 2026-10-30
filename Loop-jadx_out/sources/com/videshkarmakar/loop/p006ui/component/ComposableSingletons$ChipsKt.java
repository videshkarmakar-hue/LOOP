package com.videshkarmakar.loop.p006ui.component;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ClearKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.InputChipDefaults;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Chips.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$ChipsKt {
    public static final ComposableSingletons$ChipsKt INSTANCE = new ComposableSingletons$ChipsKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f692lambda1 = ComposableLambdaKt.composableLambdaInstance(-1346421259, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$ChipsKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C185@6041L36,186@6124L11,183@5930L322:Chips.kt#g7nzpb");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1346421259, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$ChipsKt.lambda-1.<anonymous> (Chips.kt:183)");
                }
                IconKt.m2292Iconww6aTOc(ClearKt.getClear(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(C3070R.string.remove, $composer, 0), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, InputChipDefaults.INSTANCE.m2305getIconSizeD9Ej5fM()), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).m2058getOnSurfaceVariant0d7_KjU(), $composer, 0, 0);
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
    public static Function2<Composer, Integer, Unit> f693lambda2 = ComposableLambdaKt.composableLambdaInstance(1031630823, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$ChipsKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C:Chips.kt#g7nzpb");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1031630823, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$ChipsKt.lambda-2.<anonymous> (Chips.kt:222)");
                }
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
    public final Function2<Composer, Integer, Unit> m7243getLambda1$app_debug() {
        return f692lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7244getLambda2$app_debug() {
        return f693lambda2;
    }
}
