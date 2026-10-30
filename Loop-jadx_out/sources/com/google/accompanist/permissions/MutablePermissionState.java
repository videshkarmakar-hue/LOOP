package com.google.accompanist.permissions;

import android.app.Activity;
import android.content.Context;
import androidx.activity.result.ActivityResultLauncher;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MutablePermissionState.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001a\u001a\u00020\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\r\u0010\u001d\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, m195d2 = {"Lcom/google/accompanist/permissions/MutablePermissionState;", "Lcom/google/accompanist/permissions/PermissionState;", "permission", "", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "(Ljava/lang/String;Landroid/content/Context;Landroid/app/Activity;)V", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "getLauncher$permissions_release", "()Landroidx/activity/result/ActivityResultLauncher;", "setLauncher$permissions_release", "(Landroidx/activity/result/ActivityResultLauncher;)V", "getPermission", "()Ljava/lang/String;", "<set-?>", "Lcom/google/accompanist/permissions/PermissionStatus;", NotificationCompat.CATEGORY_STATUS, "getStatus", "()Lcom/google/accompanist/permissions/PermissionStatus;", "setStatus", "(Lcom/google/accompanist/permissions/PermissionStatus;)V", "status$delegate", "Landroidx/compose/runtime/MutableState;", "getPermissionStatus", "launchPermissionRequest", "", "refreshPermissionStatus", "refreshPermissionStatus$permissions_release", "permissions_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MutablePermissionState implements PermissionState {
    public static final int $stable = 0;
    private final Activity activity;
    private final Context context;
    private ActivityResultLauncher<String> launcher;
    private final String permission;

    /* JADX INFO: renamed from: status$delegate, reason: from kotlin metadata */
    private final MutableState status;

    public MutablePermissionState(String permission, Context context, Activity activity) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.permission = permission;
        this.context = context;
        this.activity = activity;
        this.status = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getPermissionStatus(), null, 2, null);
    }

    @Override // com.google.accompanist.permissions.PermissionState
    public String getPermission() {
        return this.permission;
    }

    @Override // com.google.accompanist.permissions.PermissionState
    public PermissionStatus getStatus() {
        State $this$getValue$iv = this.status;
        return (PermissionStatus) $this$getValue$iv.getValue();
    }

    public void setStatus(PermissionStatus permissionStatus) {
        Intrinsics.checkNotNullParameter(permissionStatus, "<set-?>");
        MutableState $this$setValue$iv = this.status;
        $this$setValue$iv.setValue(permissionStatus);
    }

    @Override // com.google.accompanist.permissions.PermissionState
    public void launchPermissionRequest() {
        Unit unit;
        ActivityResultLauncher<String> activityResultLauncher = this.launcher;
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(getPermission());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IllegalStateException("ActivityResultLauncher cannot be null");
        }
    }

    public final ActivityResultLauncher<String> getLauncher$permissions_release() {
        return this.launcher;
    }

    public final void setLauncher$permissions_release(ActivityResultLauncher<String> activityResultLauncher) {
        this.launcher = activityResultLauncher;
    }

    public final void refreshPermissionStatus$permissions_release() {
        setStatus(getPermissionStatus());
    }

    private final PermissionStatus getPermissionStatus() {
        boolean hasPermission = PermissionsUtilKt.checkPermission(this.context, getPermission());
        if (hasPermission) {
            return PermissionStatus.Granted.INSTANCE;
        }
        return new PermissionStatus.Denied(PermissionsUtilKt.shouldShowRationale(this.activity, getPermission()));
    }
}
