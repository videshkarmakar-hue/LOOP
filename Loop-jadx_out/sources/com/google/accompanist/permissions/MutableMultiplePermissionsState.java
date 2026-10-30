package com.google.accompanist.permissions;

import androidx.activity.result.ActivityResultLauncher;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MutableMultiplePermissionsState.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u001e\u001a\u00020\u001fH\u0016J!\u0010 \u001a\u00020\u001f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\"H\u0000¢\u0006\u0002\b#R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR(\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u00010\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0019\u0010\u0017R\u001b\u0010\u001b\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001c\u0010\t¨\u0006$"}, m195d2 = {"Lcom/google/accompanist/permissions/MutableMultiplePermissionsState;", "Lcom/google/accompanist/permissions/MultiplePermissionsState;", "mutablePermissions", "", "Lcom/google/accompanist/permissions/MutablePermissionState;", "(Ljava/util/List;)V", "allPermissionsGranted", "", "getAllPermissionsGranted", "()Z", "allPermissionsGranted$delegate", "Landroidx/compose/runtime/State;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "getLauncher$permissions_release", "()Landroidx/activity/result/ActivityResultLauncher;", "setLauncher$permissions_release", "(Landroidx/activity/result/ActivityResultLauncher;)V", "permissions", "Lcom/google/accompanist/permissions/PermissionState;", "getPermissions", "()Ljava/util/List;", "revokedPermissions", "getRevokedPermissions", "revokedPermissions$delegate", "shouldShowRationale", "getShouldShowRationale", "shouldShowRationale$delegate", "launchMultiplePermissionRequest", "", "updatePermissionsStatus", "permissionsStatus", "", "updatePermissionsStatus$permissions_release", "permissions_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MutableMultiplePermissionsState implements MultiplePermissionsState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: allPermissionsGranted$delegate, reason: from kotlin metadata */
    private final State allPermissionsGranted;
    private ActivityResultLauncher<String[]> launcher;
    private final List<MutablePermissionState> mutablePermissions;
    private final List<PermissionState> permissions;

    /* JADX INFO: renamed from: revokedPermissions$delegate, reason: from kotlin metadata */
    private final State revokedPermissions;

    /* JADX INFO: renamed from: shouldShowRationale$delegate, reason: from kotlin metadata */
    private final State shouldShowRationale;

    public MutableMultiplePermissionsState(List<MutablePermissionState> mutablePermissions) {
        Intrinsics.checkNotNullParameter(mutablePermissions, "mutablePermissions");
        this.mutablePermissions = mutablePermissions;
        this.permissions = this.mutablePermissions;
        this.revokedPermissions = SnapshotStateKt.derivedStateOf(new Function0<List<? extends PermissionState>>() { // from class: com.google.accompanist.permissions.MutableMultiplePermissionsState$revokedPermissions$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends PermissionState> invoke() {
                Iterable $this$filter$iv = this.this$0.getPermissions();
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    PermissionState it = (PermissionState) element$iv$iv;
                    if (!Intrinsics.areEqual(it.getStatus(), PermissionStatus.Granted.INSTANCE)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                return (List) destination$iv$iv;
            }
        });
        this.allPermissionsGranted = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.google.accompanist.permissions.MutableMultiplePermissionsState$allPermissionsGranted$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z;
                Iterable $this$all$iv = this.this$0.getPermissions();
                if (!($this$all$iv instanceof Collection) || !((Collection) $this$all$iv).isEmpty()) {
                    Iterator it = $this$all$iv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object element$iv = it.next();
                            PermissionState it2 = (PermissionState) element$iv;
                            if (!PermissionsUtilKt.isGranted(it2.getStatus())) {
                                z = false;
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                } else {
                    z = true;
                }
                return Boolean.valueOf(z || this.this$0.getRevokedPermissions().isEmpty());
            }
        });
        this.shouldShowRationale = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.google.accompanist.permissions.MutableMultiplePermissionsState$shouldShowRationale$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Iterable $this$any$iv = this.this$0.getPermissions();
                boolean z = false;
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    for (Object element$iv : $this$any$iv) {
                        PermissionState it = (PermissionState) element$iv;
                        if (PermissionsUtilKt.getShouldShowRationale(it.getStatus())) {
                            z = true;
                            break;
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
        });
    }

    @Override // com.google.accompanist.permissions.MultiplePermissionsState
    public List<PermissionState> getPermissions() {
        return this.permissions;
    }

    @Override // com.google.accompanist.permissions.MultiplePermissionsState
    public List<PermissionState> getRevokedPermissions() {
        State $this$getValue$iv = this.revokedPermissions;
        return (List) $this$getValue$iv.getValue();
    }

    @Override // com.google.accompanist.permissions.MultiplePermissionsState
    public boolean getAllPermissionsGranted() {
        State $this$getValue$iv = this.allPermissionsGranted;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    @Override // com.google.accompanist.permissions.MultiplePermissionsState
    public boolean getShouldShowRationale() {
        State $this$getValue$iv = this.shouldShowRationale;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.accompanist.permissions.MultiplePermissionsState
    public void launchMultiplePermissionRequest() {
        Unit unit;
        ActivityResultLauncher<String[]> activityResultLauncher = this.launcher;
        if (activityResultLauncher != 0) {
            Iterable $this$map$iv = getPermissions();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                PermissionState it = (PermissionState) item$iv$iv;
                destination$iv$iv.add(it.getPermission());
            }
            Collection thisCollection$iv = (List) destination$iv$iv;
            activityResultLauncher.launch(thisCollection$iv.toArray(new String[0]));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IllegalStateException("ActivityResultLauncher cannot be null");
        }
    }

    public final ActivityResultLauncher<String[]> getLauncher$permissions_release() {
        return this.launcher;
    }

    public final void setLauncher$permissions_release(ActivityResultLauncher<String[]> activityResultLauncher) {
        this.launcher = activityResultLauncher;
    }

    public final void updatePermissionsStatus$permissions_release(Map<String, Boolean> permissionsStatus) {
        Object element$iv;
        Boolean bool;
        MutablePermissionState it;
        Intrinsics.checkNotNullParameter(permissionsStatus, "permissionsStatus");
        for (String permission : permissionsStatus.keySet()) {
            Iterable $this$firstOrNull$iv = this.mutablePermissions;
            Iterator it2 = $this$firstOrNull$iv.iterator();
            do {
                if (!it2.hasNext()) {
                    element$iv = null;
                    break;
                } else {
                    element$iv = it2.next();
                    it = (MutablePermissionState) element$iv;
                }
            } while (!Intrinsics.areEqual(it.getPermission(), permission));
            MutablePermissionState $this$updatePermissionsStatus_u24lambda_u243 = (MutablePermissionState) element$iv;
            if ($this$updatePermissionsStatus_u24lambda_u243 != null && (bool = permissionsStatus.get(permission)) != null) {
                bool.booleanValue();
                $this$updatePermissionsStatus_u24lambda_u243.refreshPermissionStatus$permissions_release();
            }
        }
    }
}
