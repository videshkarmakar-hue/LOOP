package com.videshkarmakar.loop;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.videshkarmakar.loop.util.NotificationUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DownloadService.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m194d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, m195d2 = {"Lcom/videshkarmakar/loop/DownloadService;", "Landroid/app/Service;", "()V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onUnbind", "", "DownloadServiceBinder", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DownloadService extends Service {
    public static final int $stable = 0;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intent notificationIntent = new Intent(this, (Class<?>) MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        Intrinsics.checkNotNullExpressionValue(pendingIntent, "let(...)");
        Notification notification = NotificationUtil.makeServiceNotification$default(NotificationUtil.INSTANCE, pendingIntent, null, 2, null);
        startForeground(NotificationUtil.SERVICE_NOTIFICATION_ID, notification);
        return new DownloadServiceBinder();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Log.d("DownloadService", "onUnbind: ");
        if (Build.VERSION.SDK_INT >= 24) {
            stopForeground(1);
        } else {
            stopForeground(true);
        }
        stopSelf();
        return super.onUnbind(intent);
    }

    /* JADX INFO: compiled from: DownloadService.kt */
    @Metadata(m194d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m195d2 = {"Lcom/videshkarmakar/loop/DownloadService$DownloadServiceBinder;", "Landroid/os/Binder;", "(Lcom/videshkarmakar/loop/DownloadService;)V", "getService", "Lcom/videshkarmakar/loop/DownloadService;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public final class DownloadServiceBinder extends Binder {
        public DownloadServiceBinder() {
        }

        /* JADX INFO: renamed from: getService, reason: from getter */
        public final DownloadService getThis$0() {
            return DownloadService.this;
        }
    }
}
