package com.yausername.aria2c;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.yausername.youtubedl_android.YoutubeDLException;
import com.yausername.youtubedl_common.SharedPrefsHelper;
import com.yausername.youtubedl_common.utils.ZipUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.p013io.FileUtils;

/* JADX INFO: compiled from: Aria2c.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u0000H\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m195d2 = {"Lcom/yausername/aria2c/Aria2c;", "", "()V", "aria2cDirName", "", "aria2cLibName", Aria2c.aria2cLibVersion, "baseName", "binDir", "Ljava/io/File;", "initialized", "", "packagesRoot", "getInstance", "init", "", "appContext", "Landroid/content/Context;", "initAria2c", "aria2cDir", "shouldUpdateAria2c", "version", "updateAria2c", "aria2c_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Aria2c {
    public static final Aria2c INSTANCE = new Aria2c();
    private static final String aria2cDirName = "aria2c";
    private static final String aria2cLibName = "libaria2c.zip.so";
    private static final String aria2cLibVersion = "aria2cLibVersion";
    private static final String baseName = "youtubedl-android";
    private static File binDir = null;
    private static boolean initialized = false;
    private static final String packagesRoot = "packages";

    private Aria2c() {
    }

    public final synchronized void init(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        if (initialized) {
            return;
        }
        File baseDir = new File(appContext.getNoBackupFilesDir(), "youtubedl-android");
        if (!baseDir.exists()) {
            baseDir.mkdir();
        }
        binDir = new File(appContext.getApplicationInfo().nativeLibraryDir);
        File packagesDir = new File(baseDir, packagesRoot);
        File aria2cDir = new File(packagesDir, "aria2c");
        initAria2c(appContext, aria2cDir);
        initialized = true;
    }

    private final void initAria2c(Context appContext, File aria2cDir) throws YoutubeDLException {
        File aria2cLib = new File(binDir, aria2cLibName);
        if (!aria2cLib.exists()) {
            return;
        }
        String aria2cSize = String.valueOf(aria2cLib.length());
        if (!aria2cDir.exists() || shouldUpdateAria2c(appContext, aria2cSize)) {
            FileUtils.deleteQuietly(aria2cDir);
            aria2cDir.mkdirs();
            try {
                ZipUtils.INSTANCE.unzip(aria2cLib, aria2cDir);
                updateAria2c(appContext, aria2cSize);
            } catch (Exception e) {
                FileUtils.deleteQuietly(aria2cDir);
                throw new YoutubeDLException("failed to initialize", e);
            }
        }
    }

    private final boolean shouldUpdateAria2c(Context appContext, String version) {
        return !Intrinsics.areEqual(version, SharedPrefsHelper.get(appContext, aria2cLibVersion));
    }

    private final void updateAria2c(Context appContext, String version) {
        SharedPrefsHelper.update(appContext, aria2cLibVersion, version);
    }

    @JvmStatic
    public static final Aria2c getInstance() {
        return INSTANCE;
    }
}
