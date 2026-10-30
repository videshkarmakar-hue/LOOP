package com.google.accompanist.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PermissionsUtil.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u000f\u001a%\u0010\u0010\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u0013\u001a\u0014\u0010\u0014\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u0015H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005\"\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005¨\u0006\u001a"}, m195d2 = {"isGranted", "", "Lcom/google/accompanist/permissions/PermissionStatus;", "isGranted$annotations", "(Lcom/google/accompanist/permissions/PermissionStatus;)V", "(Lcom/google/accompanist/permissions/PermissionStatus;)Z", "shouldShowRationale", "getShouldShowRationale$annotations", "getShouldShowRationale", "PermissionLifecycleCheckerEffect", "", "permissionState", "Lcom/google/accompanist/permissions/MutablePermissionState;", "lifecycleEvent", "Landroidx/lifecycle/Lifecycle$Event;", "(Lcom/google/accompanist/permissions/MutablePermissionState;Landroidx/lifecycle/Lifecycle$Event;Landroidx/compose/runtime/Composer;II)V", "PermissionsLifecycleCheckerEffect", "permissions", "", "(Ljava/util/List;Landroidx/lifecycle/Lifecycle$Event;Landroidx/compose/runtime/Composer;II)V", "checkPermission", "Landroid/content/Context;", "permission", "", "findActivity", "Landroid/app/Activity;", "permissions_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PermissionsUtilKt {
    public static /* synthetic */ void getShouldShowRationale$annotations(PermissionStatus permissionStatus) {
    }

    public static /* synthetic */ void isGranted$annotations(PermissionStatus permissionStatus) {
    }

    public static final boolean isGranted(PermissionStatus $this$isGranted) {
        Intrinsics.checkNotNullParameter($this$isGranted, "<this>");
        return Intrinsics.areEqual($this$isGranted, PermissionStatus.Granted.INSTANCE);
    }

    public static final boolean getShouldShowRationale(PermissionStatus $this$shouldShowRationale) {
        Intrinsics.checkNotNullParameter($this$shouldShowRationale, "<this>");
        if (Intrinsics.areEqual($this$shouldShowRationale, PermissionStatus.Granted.INSTANCE)) {
            return false;
        }
        if ($this$shouldShowRationale instanceof PermissionStatus.Denied) {
            return ((PermissionStatus.Denied) $this$shouldShowRationale).getShouldShowRationale();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void PermissionLifecycleCheckerEffect(final MutablePermissionState permissionState, final Lifecycle.Event lifecycleEvent, Composer $composer, final int $changed, final int i) {
        Object value$iv;
        Intrinsics.checkNotNullParameter(permissionState, "permissionState");
        Composer $composer2 = $composer.startRestartGroup(-1770945943);
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(permissionState) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(lifecycleEvent) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                lifecycleEvent = Lifecycle.Event.ON_RESUME;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1770945943, $dirty, -1, "com.google.accompanist.permissions.PermissionLifecycleCheckerEffect (PermissionsUtil.kt:75)");
            }
            $composer2.startReplaceableGroup(-899069773);
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new LifecycleEventObserver() { // from class: com.google.accompanist.permissions.PermissionsUtilKt$$ExternalSyntheticLambda0
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                        PermissionsUtilKt.PermissionLifecycleCheckerEffect$lambda$1$lambda$0(lifecycleEvent, permissionState, lifecycleOwner, event);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final LifecycleEventObserver permissionCheckerObserver = (LifecycleEventObserver) value$iv;
            $composer2.endReplaceableGroup();
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Lifecycle lifecycle = ((LifecycleOwner) objConsume).getLifecycleRegistry();
            EffectsKt.DisposableEffect(lifecycle, permissionCheckerObserver, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.google.accompanist.permissions.PermissionsUtilKt.PermissionLifecycleCheckerEffect.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    lifecycle.addObserver(permissionCheckerObserver);
                    final Lifecycle lifecycle2 = lifecycle;
                    final LifecycleEventObserver lifecycleEventObserver = permissionCheckerObserver;
                    return new DisposableEffectResult() { // from class: com.google.accompanist.permissions.PermissionsUtilKt$PermissionLifecycleCheckerEffect$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            lifecycle2.removeObserver(lifecycleEventObserver);
                        }
                    };
                }
            }, $composer2, 72);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.permissions.PermissionsUtilKt.PermissionLifecycleCheckerEffect.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    PermissionsUtilKt.PermissionLifecycleCheckerEffect(permissionState, lifecycleEvent, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PermissionLifecycleCheckerEffect$lambda$1$lambda$0(Lifecycle.Event $lifecycleEvent, MutablePermissionState permissionState, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(permissionState, "$permissionState");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == $lifecycleEvent && !Intrinsics.areEqual(permissionState.getStatus(), PermissionStatus.Granted.INSTANCE)) {
            permissionState.refreshPermissionStatus$permissions_release();
        }
    }

    public static final void PermissionsLifecycleCheckerEffect(final List<MutablePermissionState> permissions, final Lifecycle.Event lifecycleEvent, Composer $composer, final int $changed, final int i) {
        Object value$iv;
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Composer $composer2 = $composer.startRestartGroup(1533427666);
        if ((i & 2) != 0) {
            lifecycleEvent = Lifecycle.Event.ON_RESUME;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1533427666, $changed, -1, "com.google.accompanist.permissions.PermissionsLifecycleCheckerEffect (PermissionsUtil.kt:105)");
        }
        $composer2.startReplaceableGroup(-1664752182);
        boolean invalid$iv = $composer2.changed(permissions);
        Object it$iv = $composer2.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new LifecycleEventObserver() { // from class: com.google.accompanist.permissions.PermissionsUtilKt$$ExternalSyntheticLambda1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    PermissionsUtilKt.PermissionsLifecycleCheckerEffect$lambda$3$lambda$2(lifecycleEvent, permissions, lifecycleOwner, event);
                }
            };
            $composer2.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        final LifecycleEventObserver permissionsCheckerObserver = (LifecycleEventObserver) value$iv;
        $composer2.endReplaceableGroup();
        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer2.consume(localLifecycleOwner);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        final Lifecycle lifecycle = ((LifecycleOwner) objConsume).getLifecycleRegistry();
        EffectsKt.DisposableEffect(lifecycle, permissionsCheckerObserver, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.google.accompanist.permissions.PermissionsUtilKt.PermissionsLifecycleCheckerEffect.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                lifecycle.addObserver(permissionsCheckerObserver);
                final Lifecycle lifecycle2 = lifecycle;
                final LifecycleEventObserver lifecycleEventObserver = permissionsCheckerObserver;
                return new DisposableEffectResult() { // from class: com.google.accompanist.permissions.PermissionsUtilKt$PermissionsLifecycleCheckerEffect$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        lifecycle2.removeObserver(lifecycleEventObserver);
                    }
                };
            }
        }, $composer2, 72);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.permissions.PermissionsUtilKt.PermissionsLifecycleCheckerEffect.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i2) {
                    PermissionsUtilKt.PermissionsLifecycleCheckerEffect(permissions, lifecycleEvent, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PermissionsLifecycleCheckerEffect$lambda$3$lambda$2(Lifecycle.Event $lifecycleEvent, List permissions, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(permissions, "$permissions");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == $lifecycleEvent) {
            Iterator it = permissions.iterator();
            while (it.hasNext()) {
                MutablePermissionState permission = (MutablePermissionState) it.next();
                if (!Intrinsics.areEqual(permission.getStatus(), PermissionStatus.Granted.INSTANCE)) {
                    permission.refreshPermissionStatus$permissions_release();
                }
            }
        }
    }

    public static final Activity findActivity(Context $this$findActivity) {
        Intrinsics.checkNotNullParameter($this$findActivity, "<this>");
        Context context = $this$findActivity;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
            context = baseContext;
        }
        throw new IllegalStateException("Permissions should be called in the context of an Activity");
    }

    public static final boolean checkPermission(Context $this$checkPermission, String permission) {
        Intrinsics.checkNotNullParameter($this$checkPermission, "<this>");
        Intrinsics.checkNotNullParameter(permission, "permission");
        return ContextCompat.checkSelfPermission($this$checkPermission, permission) == 0;
    }

    public static final boolean shouldShowRationale(Activity $this$shouldShowRationale, String permission) {
        Intrinsics.checkNotNullParameter($this$shouldShowRationale, "<this>");
        Intrinsics.checkNotNullParameter(permission, "permission");
        return ActivityCompat.shouldShowRequestPermissionRationale($this$shouldShowRationale, permission);
    }
}
