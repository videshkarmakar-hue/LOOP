package com.videshkarmakar.loop.ui.page;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.NewReleasesKt;
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

/* JADX INFO: compiled from: UpdateDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$UpdateDialogKt {
    public static final ComposableSingletons$UpdateDialogKt INSTANCE = new ComposableSingletons$UpdateDialogKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f146lambda1 = ComposableLambdaKt.composableLambdaInstance(-565344701, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.ComposableSingletons$UpdateDialogKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope OutlinedButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
            ComposerKt.sourceInformation($composer, "C97@3881L37,97@3869L50:UpdateDialog.kt#hmxj0r");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-565344701, $changed, -1, "com.videshkarmakar.loop.ui.page.ComposableSingletons$UpdateDialogKt.lambda-1.<anonymous> (UpdateDialog.kt:97)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.dismiss, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f147lambda2 = ComposableLambdaKt.composableLambdaInstance(-1119643500, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.ComposableSingletons$UpdateDialogKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C84@3246L38:UpdateDialog.kt#hmxj0r");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1119643500, $changed, -1, "com.videshkarmakar.loop.ui.page.ComposableSingletons$UpdateDialogKt.lambda-2.<anonymous> (UpdateDialog.kt:84)");
            }
            IconKt.m2044Iconww6aTOc(NewReleasesKt.getNewReleases(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7180getLambda1$app_debug() {
        return f146lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7181getLambda2$app_debug() {
        return f147lambda2;
    }
}
