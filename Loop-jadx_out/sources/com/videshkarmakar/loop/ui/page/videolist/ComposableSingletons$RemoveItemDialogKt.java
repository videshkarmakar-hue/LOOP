package com.videshkarmakar.loop.ui.page.videolist;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.DeleteKt;
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

/* JADX INFO: compiled from: RemoveItemDialog.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$RemoveItemDialogKt {
    public static final ComposableSingletons$RemoveItemDialogKt INSTANCE = new ComposableSingletons$RemoveItemDialogKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f437lambda1 = ComposableLambdaKt.composableLambdaInstance(-449040876, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$RemoveItemDialogKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C54@2040L32,54@2028L45:RemoveItemDialog.kt#861hqi");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-449040876, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$RemoveItemDialogKt.lambda-1.<anonymous> (RemoveItemDialog.kt:54)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.confirm, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f438lambda2 = ComposableLambdaKt.composableLambdaInstance(-1133271181, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$RemoveItemDialogKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C58@2198L32,58@2186L45:RemoveItemDialog.kt#861hqi");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1133271181, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$RemoveItemDialogKt.lambda-2.<anonymous> (RemoveItemDialog.kt:58)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.dismiss, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f439lambda3 = ComposableLambdaKt.composableLambdaInstance(-1903472529, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$RemoveItemDialogKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C31@1190L33:RemoveItemDialog.kt#861hqi");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1903472529, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$RemoveItemDialogKt.lambda-3.<anonymous> (RemoveItemDialog.kt:31)");
            }
            IconKt.m2044Iconww6aTOc(DeleteKt.getDelete(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f440lambda4 = ComposableLambdaKt.composableLambdaInstance(1707264462, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$RemoveItemDialogKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C30@1132L36,30@1120L49:RemoveItemDialog.kt#861hqi");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1707264462, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$RemoveItemDialogKt.lambda-4.<anonymous> (RemoveItemDialog.kt:30)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.delete_info, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7491getLambda1$app_debug() {
        return f437lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7492getLambda2$app_debug() {
        return f438lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7493getLambda3$app_debug() {
        return f439lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7494getLambda4$app_debug() {
        return f440lambda4;
    }
}
