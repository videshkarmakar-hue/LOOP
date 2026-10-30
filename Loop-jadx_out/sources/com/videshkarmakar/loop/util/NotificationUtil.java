package com.videshkarmakar.loop.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.videshkarmakar.loop.App;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.NotificationActionReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationUtil.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0006J\b\u0010\u0018\u001a\u00020\u0015H\u0007J4\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ(\u0010\u001e\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004J \u0010\u001f\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0004J:\u0010!\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004J\u001a\u0010&\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004J:\u0010'\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004J\u0016\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000¨\u0006+"}, m195d2 = {"Lcom/videshkarmakar/loop/util/NotificationUtil;", "", "()V", "CHANNEL_ID", "", "DEFAULT_NOTIFICATION_ID", "", "NOTIFICATION_GROUP_ID", "PROGRESS_INITIAL", "PROGRESS_MAX", "SERVICE_CHANNEL_ID", "SERVICE_NOTIFICATION_ID", "commandNotificationBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "notificationManager", "Landroid/app/NotificationManager;", "serviceNotification", "Landroid/app/Notification;", "areNotificationsEnabled", "", "cancelAllNotifications", "", "cancelNotification", "notificationId", "createNotificationChannel", "finishNotification", "title", "text", "intent", "Landroid/app/PendingIntent;", "finishNotificationForCustomCommands", "makeErrorReportNotification", "error", "makeNotificationForCustomCommand", "taskId", NotificationCompat.CATEGORY_PROGRESS, "templateName", "taskUrl", "makeServiceNotification", "notifyProgress", "updateServiceNotificationForPlaylist", "index", "itemCount", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NotificationUtil {
    public static final int $stable;
    private static final String CHANNEL_ID = "download_notification";
    private static final int DEFAULT_NOTIFICATION_ID = 100;
    public static final NotificationUtil INSTANCE = new NotificationUtil();
    private static final String NOTIFICATION_GROUP_ID = "foxin.download.notification";
    private static final int PROGRESS_INITIAL = 0;
    private static final int PROGRESS_MAX = 100;
    private static final String SERVICE_CHANNEL_ID = "download_service";
    public static final int SERVICE_NOTIFICATION_ID = 123;
    private static final NotificationCompat.Builder commandNotificationBuilder;
    private static final NotificationManager notificationManager;
    private static Notification serviceNotification;

    private NotificationUtil() {
    }

    static {
        Object systemService = App.INSTANCE.getContext().getSystemService(PreferenceUtilKt.NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        notificationManager = (NotificationManager) systemService;
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(App.INSTANCE.getContext(), CHANNEL_ID).setSmallIcon(C3070R.drawable.ic_stat_foxin);
        Intrinsics.checkNotNullExpressionValue(smallIcon, "setSmallIcon(...)");
        commandNotificationBuilder = smallIcon;
        $stable = 8;
    }

    public final void createNotificationChannel() {
        String name = App.INSTANCE.getContext().getString(C3070R.string.channel_name);
        Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
        String descriptionText = App.INSTANCE.getContext().getString(C3070R.string.channel_description);
        Intrinsics.checkNotNullExpressionValue(descriptionText, "getString(...)");
        NotificationChannelGroup channelGroup = new NotificationChannelGroup(NOTIFICATION_GROUP_ID, App.INSTANCE.getContext().getString(C3070R.string.download));
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, 2);
        channel.setDescription(descriptionText);
        channel.setGroup(NOTIFICATION_GROUP_ID);
        NotificationChannel $this$createNotificationChannel_u24lambda_u241 = new NotificationChannel(SERVICE_CHANNEL_ID, name, 2);
        $this$createNotificationChannel_u24lambda_u241.setDescription(App.INSTANCE.getContext().getString(C3070R.string.service_title));
        $this$createNotificationChannel_u24lambda_u241.setGroup(NOTIFICATION_GROUP_ID);
        notificationManager.createNotificationChannelGroup(channelGroup);
        notificationManager.createNotificationChannel(channel);
        notificationManager.createNotificationChannel($this$createNotificationChannel_u24lambda_u241);
    }

    public final void notifyProgress(String title, int notificationId, int progress, String taskId, String text) {
        PendingIntent broadcast;
        Intrinsics.checkNotNullParameter(title, "title");
        if (PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.NOTIFICATION)) {
            if (taskId != null) {
                Intent $this$notifyProgress_u24lambda_u243_u24lambda_u242 = new Intent(App.INSTANCE.getContext().getApplicationContext(), (Class<?>) NotificationActionReceiver.class).putExtra(NotificationActionReceiver.TASK_ID_KEY, taskId).putExtra(NotificationActionReceiver.NOTIFICATION_ID_KEY, notificationId).putExtra(NotificationActionReceiver.ACTION_KEY, 0);
                broadcast = PendingIntent.getBroadcast(App.INSTANCE.getContext().getApplicationContext(), notificationId, $this$notifyProgress_u24lambda_u243_u24lambda_u242, 1140850688);
            } else {
                broadcast = null;
            }
            PendingIntent pendingIntent = broadcast;
            NotificationCompat.Builder $this$notifyProgress_u24lambda_u245 = new NotificationCompat.Builder(App.INSTANCE.getContext(), CHANNEL_ID).setSmallIcon(C3070R.drawable.ic_stat_foxin).setContentTitle(title).setProgress(100, progress, progress <= 0).setOngoing(true).setOnlyAlertOnce(true).setStyle(new NotificationCompat.BigTextStyle().bigText(text));
            if (pendingIntent != null) {
                $this$notifyProgress_u24lambda_u245.addAction(C3070R.drawable.outline_cancel_24, App.INSTANCE.getContext().getString(C3070R.string.cancel), pendingIntent);
            }
            notificationManager.notify(notificationId, $this$notifyProgress_u24lambda_u245.build());
        }
    }

    public static /* synthetic */ void finishNotification$default(NotificationUtil notificationUtil, int i, String str, String str2, PendingIntent pendingIntent, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 100;
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        if ((i2 & 8) != 0) {
            pendingIntent = null;
        }
        notificationUtil.finishNotification(i, str, str2, pendingIntent);
    }

    public final void finishNotification(int notificationId, String title, String text, PendingIntent intent) {
        Log.d("NotificationUtil", "finishNotification: ");
        notificationManager.cancel(notificationId);
        if (PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.NOTIFICATION)) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(App.INSTANCE.getContext(), CHANNEL_ID).setSmallIcon(C3070R.drawable.ic_stat_foxin).setContentText(text).setOngoing(false).setAutoCancel(true);
            Intrinsics.checkNotNullExpressionValue(builder, "setAutoCancel(...)");
            if (title != null) {
                builder.setContentTitle(title);
            }
            if (intent != null) {
                builder.setContentIntent(intent);
            }
            notificationManager.notify(notificationId, builder.build());
        }
    }

    public static /* synthetic */ void finishNotificationForCustomCommands$default(NotificationUtil notificationUtil, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 100;
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        notificationUtil.finishNotificationForCustomCommands(i, str, str2);
    }

    public final void finishNotificationForCustomCommands(int notificationId, String title, String text) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(App.INSTANCE.getContext(), CHANNEL_ID).setSmallIcon(C3070R.drawable.ic_stat_foxin).setContentText(text).setProgress(0, 0, false).setAutoCancel(true).setOngoing(false).setStyle(null);
        Intrinsics.checkNotNullExpressionValue(builder, "setStyle(...)");
        if (title != null) {
            builder.setContentTitle(title);
        }
        notificationManager.notify(notificationId, builder.build());
    }

    public static /* synthetic */ Notification makeServiceNotification$default(NotificationUtil notificationUtil, PendingIntent pendingIntent, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return notificationUtil.makeServiceNotification(pendingIntent, str);
    }

    public final Notification makeServiceNotification(PendingIntent intent, String text) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Notification notificationBuild = new NotificationCompat.Builder(App.INSTANCE.getContext(), SERVICE_CHANNEL_ID).setSmallIcon(C3070R.drawable.ic_stat_foxin).setContentTitle(App.INSTANCE.getContext().getString(C3070R.string.service_title)).setContentText(text).setOngoing(true).setContentIntent(intent).setForegroundServiceBehavior(1).build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        serviceNotification = notificationBuild;
        Notification notification = serviceNotification;
        if (notification != null) {
            return notification;
        }
        Intrinsics.throwUninitializedPropertyAccessException("serviceNotification");
        return null;
    }

    public final void updateServiceNotificationForPlaylist(int index, int itemCount) {
        Context context = App.INSTANCE.getContext();
        Notification notification = serviceNotification;
        Notification notification2 = null;
        if (notification == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceNotification");
            notification = null;
        }
        Notification notificationBuild = new NotificationCompat.Builder(context, notification).setContentTitle(App.INSTANCE.getContext().getString(C3070R.string.service_title) + " (" + index + "/" + itemCount + ")").build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        serviceNotification = notificationBuild;
        NotificationManager notificationManager2 = notificationManager;
        Notification notification3 = serviceNotification;
        if (notification3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceNotification");
        } else {
            notification2 = notification3;
        }
        notificationManager2.notify(SERVICE_NOTIFICATION_ID, notification2);
    }

    public final void cancelNotification(int notificationId) {
        notificationManager.cancel(notificationId);
    }

    public static /* synthetic */ void makeErrorReportNotification$default(NotificationUtil notificationUtil, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = App.INSTANCE.getContext().getString(C3070R.string.download_error_msg);
            Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
        }
        notificationUtil.makeErrorReportNotification(str, i, str2);
    }

    public final void makeErrorReportNotification(String title, int notificationId, String error) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(error, "error");
        if (PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.NOTIFICATION)) {
            Intent intent = new Intent().setClass(App.INSTANCE.getContext(), NotificationActionReceiver.class).putExtra(NotificationActionReceiver.NOTIFICATION_ID_KEY, notificationId).putExtra(NotificationActionReceiver.ERROR_REPORT_KEY, error).putExtra(NotificationActionReceiver.ACTION_KEY, 1);
            Intrinsics.checkNotNullExpressionValue(intent, "putExtra(...)");
            PendingIntent pendingIntent = PendingIntent.getBroadcast(App.INSTANCE.getContext(), notificationId, intent, 1275068416);
            NotificationCompat.Builder $this$makeErrorReportNotification_u24lambda_u249 = new NotificationCompat.Builder(App.INSTANCE.getContext(), CHANNEL_ID).setSmallIcon(C3070R.drawable.ic_stat_foxin).setContentTitle(title).setContentText(error).setOngoing(false).addAction(C3070R.drawable.outline_content_copy_24, App.INSTANCE.getContext().getString(C3070R.string.copy_error_report), pendingIntent);
            notificationManager.cancel(notificationId);
            notificationManager.notify(notificationId, $this$makeErrorReportNotification_u24lambda_u249.build());
        }
    }

    public static /* synthetic */ void makeNotificationForCustomCommand$default(NotificationUtil notificationUtil, int i, String str, int i2, String str2, String str3, String str4, int i3, Object obj) {
        String str5;
        if ((i3 & 8) == 0) {
            str5 = str2;
        } else {
            str5 = null;
        }
        notificationUtil.makeNotificationForCustomCommand(i, str, i2, str5, str3, str4);
    }

    public final void makeNotificationForCustomCommand(int notificationId, String taskId, int progress, String text, String templateName, String taskUrl) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(templateName, "templateName");
        Intrinsics.checkNotNullParameter(taskUrl, "taskUrl");
        if (PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.NOTIFICATION)) {
            Intent intent = new Intent(App.INSTANCE.getContext().getApplicationContext(), (Class<?>) NotificationActionReceiver.class).putExtra(NotificationActionReceiver.TASK_ID_KEY, taskId).putExtra(NotificationActionReceiver.NOTIFICATION_ID_KEY, notificationId).putExtra(NotificationActionReceiver.ACTION_KEY, 0);
            Intrinsics.checkNotNullExpressionValue(intent, "putExtra(...)");
            PendingIntent pendingIntent = PendingIntent.getBroadcast(App.INSTANCE.getContext().getApplicationContext(), notificationId, intent, 1140850688);
            NotificationCompat.Builder $this$makeNotificationForCustomCommand_u24lambda_u2410 = new NotificationCompat.Builder(App.INSTANCE.getContext(), CHANNEL_ID).setSmallIcon(C3070R.drawable.ic_stat_foxin).setContentTitle("[" + templateName + "_" + taskUrl + "] " + App.INSTANCE.getContext().getString(C3070R.string.execute_command_notification)).setContentText(text).setOngoing(true).setProgress(100, progress, progress == -1).addAction(C3070R.drawable.outline_cancel_24, App.INSTANCE.getContext().getString(C3070R.string.cancel), pendingIntent);
            notificationManager.notify(notificationId, $this$makeNotificationForCustomCommand_u24lambda_u2410.build());
        }
    }

    public final void cancelAllNotifications() {
        notificationManager.cancelAll();
    }

    public final boolean areNotificationsEnabled() {
        if (Build.VERSION.SDK_INT <= 24) {
            return true;
        }
        return notificationManager.areNotificationsEnabled();
    }
}
