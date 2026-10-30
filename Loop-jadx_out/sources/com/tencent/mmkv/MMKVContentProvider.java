package com.tencent.mmkv;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes18.dex */
public class MMKVContentProvider extends ContentProvider {
    protected static final String FUNCTION_NAME = "mmkvFromAshmemID";
    protected static final String KEY = "KEY";
    protected static final String KEY_CRYPT = "KEY_CRYPT";
    protected static final String KEY_MODE = "KEY_MODE";
    protected static final String KEY_SIZE = "KEY_SIZE";
    private static Uri gUri;

    protected static Uri contentUri(Context context) {
        String authority;
        if (gUri != null) {
            return gUri;
        }
        if (context == null || (authority = queryAuthority(context)) == null) {
            return null;
        }
        gUri = Uri.parse("content://" + authority);
        return gUri;
    }

    private Bundle mmkvFromAshmemID(String ashmemID, int size, int mode, String cryptKey) throws RuntimeException {
        MMKV mmkv = MMKV.mmkvWithAshmemID(getContext(), ashmemID, size, mode, cryptKey);
        ParcelableMMKV parcelableMMKV = new ParcelableMMKV(mmkv);
        Log.i("MMKV", ashmemID + " fd = " + mmkv.ashmemFD() + ", meta fd = " + mmkv.ashmemMetaFD());
        Bundle result = new Bundle();
        result.putParcelable(KEY, parcelableMMKV);
        return result;
    }

    private static String queryAuthority(Context context) {
        ProviderInfo providerInfo;
        try {
            ComponentName componentName = new ComponentName(context, MMKVContentProvider.class.getName());
            PackageManager mgr = context.getPackageManager();
            if (mgr != null && (providerInfo = mgr.getProviderInfo(componentName, 0)) != null) {
                return providerInfo.authority;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        return true;
    }

    protected static String getProcessNameByPID(Context context, int pid) {
        ActivityManager manager = (ActivityManager) context.getSystemService("activity");
        if (manager != null) {
            for (ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
                if (processInfo.pid == pid) {
                    return processInfo.processName;
                }
            }
            return "";
        }
        return "";
    }

    @Override // android.content.ContentProvider
    public Bundle call(String method, String mmapID, Bundle extras) {
        if (!method.equals(FUNCTION_NAME) || extras == null) {
            return null;
        }
        int size = extras.getInt(KEY_SIZE);
        int mode = extras.getInt(KEY_MODE);
        String cryptKey = extras.getString(KEY_CRYPT);
        try {
            return mmkvFromAshmemID(mmapID, size, mode, cryptKey);
        } catch (Exception e) {
            Log.e("MMKV", e.getMessage());
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }
}
