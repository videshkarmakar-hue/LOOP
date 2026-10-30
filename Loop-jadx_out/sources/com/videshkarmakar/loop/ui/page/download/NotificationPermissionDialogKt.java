package com.videshkarmakar.loop.ui.page.download;

import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: NotificationPermissionDialog.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0000\u001a\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"NotificationPermissionDialog", "", "onDismissRequest", "Lkotlin/Function0;", "onPermissionGranted", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NotificationPermissionDialogKt {
    public static final void NotificationPermissionDialog(Function0<Unit> function0, Function0<Unit> function1, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function2;
        final Function0<Unit> function3;
        final Function0<Unit> function4;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-644357351);
        ComposerKt.sourceInformation($composer3, "C(NotificationPermissionDialog)32@1138L141,37@1305L149,20@694L766:NotificationPermissionDialog.kt#y3famj");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            function2 = function0;
        } else if (($changed & 14) == 0) {
            function2 = function0;
            $dirty |= $composer3.changedInstance(function2) ? 4 : 2;
        } else {
            function2 = function0;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            function3 = function1;
        } else if (($changed & 112) == 0) {
            function3 = function1;
            $dirty |= $composer3.changedInstance(function3) ? 32 : 16;
        } else {
            function3 = function1;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            function4 = function2;
        } else {
            final Function0<Unit> function5 = i2 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.NotificationPermissionDialogKt.NotificationPermissionDialog.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function2;
            final Function0<Unit> function6 = i3 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.NotificationPermissionDialogKt.NotificationPermissionDialog.2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-644357351, $dirty2, -1, "com.videshkarmakar.loop.ui.page.download.NotificationPermissionDialog (NotificationPermissionDialog.kt:19)");
            }
            function4 = function5;
            Function0<Unit> function7 = function6;
            $composer2 = $composer3;
            AndroidAlertDialog_androidKt.m1663AlertDialogOix01E0(function4, ComposableLambdaKt.rememberComposableLambda(1005468113, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.NotificationPermissionDialogKt.NotificationPermissionDialog.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C33@1152L117:NotificationPermissionDialog.kt#y3famj");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1005468113, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.NotificationPermissionDialog.<anonymous> (NotificationPermissionDialog.kt:33)");
                        }
                        ButtonKt.Button(function6, null, false, null, null, null, null, null, null, ComposableSingletons$NotificationPermissionDialogKt.INSTANCE.m7241getLambda1$app_debug(), $composer4, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), null, ComposableLambdaKt.rememberComposableLambda(-1189760753, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.NotificationPermissionDialogKt.NotificationPermissionDialog.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C38@1319L125:NotificationPermissionDialog.kt#y3famj");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1189760753, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.NotificationPermissionDialog.<anonymous> (NotificationPermissionDialog.kt:38)");
                        }
                        ButtonKt.OutlinedButton(function5, null, false, null, null, null, null, null, null, ComposableSingletons$NotificationPermissionDialogKt.INSTANCE.m7242getLambda2$app_debug(), $composer4, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), ComposableSingletons$NotificationPermissionDialogKt.INSTANCE.m7243getLambda3$app_debug(), ComposableSingletons$NotificationPermissionDialogKt.INSTANCE.m7244getLambda4$app_debug(), ComposableSingletons$NotificationPermissionDialogKt.INSTANCE.m7245getLambda5$app_debug(), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, ($dirty2 & 14) | 1797168, 0, 16260);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function7;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.NotificationPermissionDialogKt.NotificationPermissionDialog.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i4) {
                    NotificationPermissionDialogKt.NotificationPermissionDialog(function4, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
