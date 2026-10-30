package com.videshkarmakar.loop.p006ui.page.download;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.NotificationsActiveKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationPermissionDialog.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$NotificationPermissionDialogKt {
    public static final ComposableSingletons$NotificationPermissionDialogKt INSTANCE = new ComposableSingletons$NotificationPermissionDialogKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f809lambda1 = ComposableLambdaKt.composableLambdaInstance(1261712353, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$NotificationPermissionDialogKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            ComposerKt.sourceInformation($composer, "C34@1220L34,34@1208L47:NotificationPermissionDialog.kt#y3famj");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1261712353, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$NotificationPermissionDialogKt.lambda-1.<anonymous> (NotificationPermissionDialog.kt:34)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.okay, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f810lambda2 = ComposableLambdaKt.composableLambdaInstance(-1254212771, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$NotificationPermissionDialogKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope OutlinedButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
            ComposerKt.sourceInformation($composer, "C39@1392L37,39@1380L50:NotificationPermissionDialog.kt#y3famj");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1254212771, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$NotificationPermissionDialogKt.lambda-2.<anonymous> (NotificationPermissionDialog.kt:39)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.disable, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f811lambda3 = ComposableLambdaKt.composableLambdaInstance(-139891538, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$NotificationPermissionDialogKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C23@781L127:NotificationPermissionDialog.kt#y3famj");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-139891538, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$NotificationPermissionDialogKt.lambda-3.<anonymous> (NotificationPermissionDialog.kt:23)");
                }
                IconKt.m2292Iconww6aTOc(NotificationsActiveKt.getNotificationsActive(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f812lambda4 = ComposableLambdaKt.composableLambdaInstance(909977677, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$NotificationPermissionDialogKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C31@1059L50,31@1047L63:NotificationPermissionDialog.kt#y3famj");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(909977677, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$NotificationPermissionDialogKt.lambda-4.<anonymous> (NotificationPermissionDialog.kt:31)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.enable_notifications, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f813lambda5 = ComposableLambdaKt.composableLambdaInstance(1959846892, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$NotificationPermissionDialogKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C29@961L55,29@949L68:NotificationPermissionDialog.kt#y3famj");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1959846892, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$NotificationPermissionDialogKt.lambda-5.<anonymous> (NotificationPermissionDialog.kt:29)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.enable_notifications_desc, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7377getLambda1$app_debug() {
        return f809lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7378getLambda2$app_debug() {
        return f810lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7379getLambda3$app_debug() {
        return f811lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7380getLambda4$app_debug() {
        return f812lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7381getLambda5$app_debug() {
        return f813lambda5;
    }
}
