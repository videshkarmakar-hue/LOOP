package com.google.accompanist.permissions;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PermissionState.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, m195d2 = {"rememberPermissionState", "Lcom/google/accompanist/permissions/PermissionState;", "permission", "", "onPermissionResult", "Lkotlin/Function1;", "", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Lcom/google/accompanist/permissions/PermissionState;", "permissions_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PermissionStateKt {
    public static final PermissionState rememberPermissionState(String permission, Function1<? super Boolean, Unit> function1, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        $composer.startReplaceableGroup(923020361);
        if ((i & 2) != 0) {
            Function1 onPermissionResult = new Function1<Boolean, Unit>() { // from class: com.google.accompanist.permissions.PermissionStateKt.rememberPermissionState.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean it) {
                }
            };
            function1 = onPermissionResult;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(923020361, $changed, -1, "com.google.accompanist.permissions.rememberPermissionState (PermissionState.kt:36)");
        }
        MutablePermissionState mutablePermissionStateRememberMutablePermissionState = MutablePermissionStateKt.rememberMutablePermissionState(permission, function1, $composer, ($changed & 14) | ($changed & 112), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return mutablePermissionStateRememberMutablePermissionState;
    }
}
