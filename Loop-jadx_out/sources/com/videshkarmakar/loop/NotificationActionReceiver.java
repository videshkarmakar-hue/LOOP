package com.videshkarmakar.loop;

import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.NotificationUtil;
import com.videshkarmakar.loop.util.ToastUtil;
import com.yausername.youtubedl_android.YoutubeDL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationActionReceiver.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m194d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0011"}, m195d2 = {"Lcom/videshkarmakar/loop/NotificationActionReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "cancelTask", "", "taskId", "", "notificationId", "", "copyErrorReport", "error", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NotificationActionReceiver extends BroadcastReceiver {
    public static final int $stable = 0;
    public static final int ACTION_CANCEL_TASK = 0;
    public static final int ACTION_ERROR_REPORT = 1;
    public static final String ACTION_KEY = "com.videshkarmakar.loop.action";
    public static final String ERROR_REPORT_KEY = "com.videshkarmakar.loop.error_report";
    public static final String NOTIFICATION_ID_KEY = "com.videshkarmakar.loop.notificationId";
    private static final String PACKAGE_NAME_PREFIX = "com.videshkarmakar.loop.";
    private static final String TAG = "CancelReceiver";
    public static final String TASK_ID_KEY = "com.videshkarmakar.loop.taskId";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
        }
        int notificationId = intent.getIntExtra(NOTIFICATION_ID_KEY, 0);
        int action = intent.getIntExtra(ACTION_KEY, 0);
        Log.d(TAG, "onReceive: " + action);
        switch (action) {
            case 0:
                String taskId = intent.getStringExtra(TASK_ID_KEY);
                cancelTask(taskId, notificationId);
                break;
            case 1:
                String errorReport = intent.getStringExtra(ERROR_REPORT_KEY);
                String str = errorReport;
                if (!(str == null || str.length() == 0)) {
                    copyErrorReport(errorReport, notificationId);
                }
                break;
        }
    }

    private final void cancelTask(String taskId, int notificationId) {
        String str = taskId;
        if (str == null || str.length() == 0) {
            return;
        }
        NotificationUtil.INSTANCE.cancelNotification(notificationId);
        boolean result = YoutubeDL.getInstance().destroyProcessById(taskId);
        NotificationUtil.INSTANCE.cancelNotification(notificationId);
        if (result) {
            Log.d(TAG, "Task (id:" + taskId + ") was killed.");
            Downloader.INSTANCE.onProcessCanceled(taskId);
        }
    }

    private final void copyErrorReport(String error, int notificationId) {
        App.INSTANCE.getClipboard().setPrimaryClip(ClipData.newPlainText(null, error));
        Context it = App.INSTANCE.getContext();
        ToastUtil toastUtil = ToastUtil.INSTANCE;
        String string = it.getString(C3070R.string.error_copied);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        toastUtil.makeToastSuspend(string);
        NotificationUtil.INSTANCE.cancelNotification(notificationId);
    }
}
