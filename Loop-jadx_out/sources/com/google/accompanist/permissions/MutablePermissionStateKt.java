package com.google.accompanist.permissions;

import android.content.Context;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MutablePermissionState.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, m195d2 = {"rememberMutablePermissionState", "Lcom/google/accompanist/permissions/MutablePermissionState;", "permission", "", "onPermissionResult", "Lkotlin/Function1;", "", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Lcom/google/accompanist/permissions/MutablePermissionState;", "permissions_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MutablePermissionStateKt {
    public static final MutablePermissionState rememberMutablePermissionState(String permission, final Function1<? super Boolean, Unit> function1, Composer $composer, int $changed, int i) {
        Object value$iv;
        Object value$iv2;
        Intrinsics.checkNotNullParameter(permission, "permission");
        $composer.startReplaceableGroup(1424240517);
        if ((i & 2) != 0) {
            Function1 onPermissionResult = new Function1<Boolean, Unit>() { // from class: com.google.accompanist.permissions.MutablePermissionStateKt.rememberMutablePermissionState.1
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
            ComposerKt.traceEventStart(1424240517, $changed, -1, "com.google.accompanist.permissions.rememberMutablePermissionState (MutablePermissionState.kt:47)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Context context = (Context) objConsume;
        $composer.startReplaceableGroup(-1903070007);
        boolean z = true;
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(permission)) || ($changed & 6) == 4;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new MutablePermissionState(permission, context, PermissionsUtilKt.findActivity(context));
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        final MutablePermissionState permissionState = (MutablePermissionState) value$iv;
        $composer.endReplaceableGroup();
        PermissionsUtilKt.PermissionLifecycleCheckerEffect(permissionState, null, $composer, 0, 2);
        ActivityResultContracts.RequestPermission requestPermission = new ActivityResultContracts.RequestPermission();
        $composer.startReplaceableGroup(-1903069605);
        boolean zChanged = $composer.changed(permissionState);
        if (((($changed & 112) ^ 48) <= 32 || !$composer.changedInstance(function1)) && ($changed & 48) != 32) {
            z = false;
        }
        boolean invalid$iv2 = z | zChanged;
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = new Function1<Boolean, Unit>() { // from class: com.google.accompanist.permissions.MutablePermissionStateKt$rememberMutablePermissionState$launcher$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean it) {
                    permissionState.refreshPermissionStatus$permissions_release();
                    function1.invoke(Boolean.valueOf(it));
                }
            };
            $composer.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        $composer.endReplaceableGroup();
        final ManagedActivityResultLauncher launcher = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestPermission, (Function1) value$iv2, $composer, 8);
        EffectsKt.DisposableEffect(permissionState, launcher, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.google.accompanist.permissions.MutablePermissionStateKt.rememberMutablePermissionState.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                permissionState.setLauncher$permissions_release(launcher);
                final MutablePermissionState mutablePermissionState = permissionState;
                return new DisposableEffectResult() { // from class: com.google.accompanist.permissions.MutablePermissionStateKt$rememberMutablePermissionState$2$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        mutablePermissionState.setLauncher$permissions_release(null);
                    }
                };
            }
        }, $composer, ManagedActivityResultLauncher.$stable << 3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return permissionState;
    }
}
