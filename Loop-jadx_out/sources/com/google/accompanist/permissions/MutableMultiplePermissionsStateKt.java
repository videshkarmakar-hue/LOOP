package com.google.accompanist.permissions;

import android.app.Activity;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MutableMultiplePermissionsState.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032 \b\u0002\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006H\u0001¢\u0006\u0002\u0010\n\u001a!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0003¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m195d2 = {"rememberMutableMultiplePermissionsState", "Lcom/google/accompanist/permissions/MultiplePermissionsState;", "permissions", "", "", "onPermissionsResult", "Lkotlin/Function1;", "", "", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Lcom/google/accompanist/permissions/MultiplePermissionsState;", "rememberMutablePermissionsState", "Lcom/google/accompanist/permissions/MutablePermissionState;", "(Ljava/util/List;Landroidx/compose/runtime/Composer;I)Ljava/util/List;", "permissions_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MutableMultiplePermissionsStateKt {
    public static final MultiplePermissionsState rememberMutableMultiplePermissionsState(List<String> permissions, final Function1<? super Map<String, Boolean>, Unit> function1, Composer $composer, int $changed, int i) {
        Object value$iv;
        Object value$iv2;
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        $composer.startReplaceableGroup(-2044770427);
        if ((i & 2) != 0) {
            Function1 onPermissionsResult = new Function1<Map<String, ? extends Boolean>, Unit>() { // from class: com.google.accompanist.permissions.MutableMultiplePermissionsStateKt.rememberMutableMultiplePermissionsState.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends Boolean> map) {
                    invoke2((Map<String, Boolean>) map);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Map<String, Boolean> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            };
            function1 = onPermissionsResult;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2044770427, $changed, -1, "com.google.accompanist.permissions.rememberMutableMultiplePermissionsState (MutableMultiplePermissionsState.kt:45)");
        }
        List<MutablePermissionState> listRememberMutablePermissionsState = rememberMutablePermissionsState(permissions, $composer, 8);
        PermissionsUtilKt.PermissionsLifecycleCheckerEffect(listRememberMutablePermissionsState, null, $composer, 8, 2);
        $composer.startReplaceableGroup(-1585748799);
        boolean invalid$iv = $composer.changed(permissions);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new MutableMultiplePermissionsState(listRememberMutablePermissionsState);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        final MutableMultiplePermissionsState multiplePermissionsState = (MutableMultiplePermissionsState) value$iv;
        $composer.endReplaceableGroup();
        ActivityResultContracts.RequestMultiplePermissions requestMultiplePermissions = new ActivityResultContracts.RequestMultiplePermissions();
        $composer.startReplaceableGroup(-1585748493);
        boolean invalid$iv2 = $composer.changed(multiplePermissionsState) | (((($changed & 112) ^ 48) > 32 && $composer.changedInstance(function1)) || ($changed & 48) == 32);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = new Function1<Map<String, Boolean>, Unit>() { // from class: com.google.accompanist.permissions.MutableMultiplePermissionsStateKt$rememberMutableMultiplePermissionsState$launcher$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Map<String, Boolean> map) {
                    invoke2(map);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Map<String, Boolean> permissionsResult) {
                    Intrinsics.checkNotNullParameter(permissionsResult, "permissionsResult");
                    multiplePermissionsState.updatePermissionsStatus$permissions_release(permissionsResult);
                    function1.invoke(permissionsResult);
                }
            };
            $composer.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        $composer.endReplaceableGroup();
        final ManagedActivityResultLauncher launcher = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestMultiplePermissions, (Function1) value$iv2, $composer, 8);
        EffectsKt.DisposableEffect(multiplePermissionsState, launcher, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.google.accompanist.permissions.MutableMultiplePermissionsStateKt.rememberMutableMultiplePermissionsState.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                multiplePermissionsState.setLauncher$permissions_release(launcher);
                final MutableMultiplePermissionsState mutableMultiplePermissionsState = multiplePermissionsState;
                return new DisposableEffectResult() { // from class: com.google.accompanist.permissions.MutableMultiplePermissionsStateKt$rememberMutableMultiplePermissionsState$2$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        mutableMultiplePermissionsState.setLauncher$permissions_release(null);
                    }
                };
            }
        }, $composer, ManagedActivityResultLauncher.$stable << 3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return multiplePermissionsState;
    }

    private static final List<MutablePermissionState> rememberMutablePermissionsState(List<String> list, Composer $composer, int $changed) {
        Object value$iv;
        Object value$iv2;
        $composer.startReplaceableGroup(992349447);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(992349447, $changed, -1, "com.google.accompanist.permissions.rememberMutablePermissionsState (MutableMultiplePermissionsState.kt:76)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Context context = (Context) objConsume;
        Activity activity = PermissionsUtilKt.findActivity(context);
        $composer.startReplaceableGroup(-1458104306);
        boolean invalid$iv = $composer.changed(list);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            List<String> $this$map$iv = list;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it = (String) item$iv$iv;
                destination$iv$iv.add(new MutablePermissionState(it, context, activity));
                invalid$iv = invalid$iv;
            }
            value$iv = (List) destination$iv$iv;
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        List<MutablePermissionState> list2 = (List) value$iv;
        $composer.endReplaceableGroup();
        for (final MutablePermissionState permissionState : list2) {
            $composer.startMovableGroup(-1458104076, permissionState.getPermission());
            ActivityResultContracts.RequestPermission requestPermission = new ActivityResultContracts.RequestPermission();
            $composer.startReplaceableGroup(-1458103836);
            boolean invalid$iv2 = $composer.changed(permissionState);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function1<Boolean, Unit>() { // from class: com.google.accompanist.permissions.MutableMultiplePermissionsStateKt$rememberMutablePermissionsState$launcher$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean it2) {
                        permissionState.refreshPermissionStatus$permissions_release();
                    }
                };
                $composer.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            $composer.endReplaceableGroup();
            final ManagedActivityResultLauncher launcher = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestPermission, (Function1) value$iv2, $composer, 8);
            EffectsKt.DisposableEffect(launcher, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.google.accompanist.permissions.MutableMultiplePermissionsStateKt.rememberMutablePermissionsState.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    permissionState.setLauncher$permissions_release(launcher);
                    final MutablePermissionState mutablePermissionState = permissionState;
                    return new DisposableEffectResult() { // from class: com.google.accompanist.permissions.MutableMultiplePermissionsStateKt$rememberMutablePermissionsState$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            mutablePermissionState.setLauncher$permissions_release(null);
                        }
                    };
                }
            }, $composer, ManagedActivityResultLauncher.$stable);
            $composer.endMovableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return list2;
    }
}
