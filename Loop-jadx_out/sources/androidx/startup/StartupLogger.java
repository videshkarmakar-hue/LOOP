package androidx.startup;

import android.util.Log;

/* JADX INFO: loaded from: classes17.dex */
public final class StartupLogger {
    static final boolean DEBUG = false;
    private static final String TAG = "StartupLogger";

    private StartupLogger() {
    }

    /* JADX INFO: renamed from: i */
    public static void m74i(String message) {
        Log.i(TAG, message);
    }

    /* JADX INFO: renamed from: w */
    public static void m75w(String message) {
        Log.w(TAG, message);
    }

    /* JADX INFO: renamed from: e */
    public static void m73e(String message, Throwable throwable) {
        Log.e(TAG, message, throwable);
    }
}
