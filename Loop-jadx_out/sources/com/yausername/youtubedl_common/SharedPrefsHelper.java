package com.yausername.youtubedl_common;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedPrefsHelper.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0087\u0002J$\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, m195d2 = {"Lcom/yausername/youtubedl_common/SharedPrefsHelper;", "", "()V", "sharedPrefsName", "", "get", "appContext", "Landroid/content/Context;", "key", "update", "", DownloadUtil.CookieScheme.VALUE, "common_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SharedPrefsHelper {
    public static final SharedPrefsHelper INSTANCE = new SharedPrefsHelper();
    private static final String sharedPrefsName = "youtubedl-android";

    private SharedPrefsHelper() {
    }

    @JvmStatic
    public static final void update(Context appContext, String key, String value) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        SharedPreferences pref = appContext.getSharedPreferences("youtubedl-android", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    @JvmStatic
    public static final String get(Context appContext, String key) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        SharedPreferences pref = appContext.getSharedPreferences("youtubedl-android", 0);
        return pref.getString(key, null);
    }
}
