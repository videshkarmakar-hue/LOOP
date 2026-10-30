package com.yausername.ffmpeg;

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

/* JADX INFO: compiled from: FFmpeg.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u0000H\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m195d2 = {"Lcom/yausername/ffmpeg/FFmpeg;", "", "()V", "baseName", "", "binDir", "Ljava/io/File;", "ffmegDirName", "ffmpegLibName", FFmpeg.ffmpegLibVersion, "initialized", "", "packagesRoot", "getInstance", "init", "", "appContext", "Landroid/content/Context;", "initFFmpeg", "ffmpegDir", "shouldUpdateFFmpeg", "version", "updateFFmpeg", "ffmpeg_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FFmpeg {
    public static final FFmpeg INSTANCE = new FFmpeg();
    private static final String baseName = "youtubedl-android";
    private static File binDir = null;
    private static final String ffmegDirName = "ffmpeg";
    private static final String ffmpegLibName = "libffmpeg.zip.so";
    private static final String ffmpegLibVersion = "ffmpegLibVersion";
    private static boolean initialized = false;
    private static final String packagesRoot = "packages";

    private FFmpeg() {
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
        File ffmpegDir = new File(packagesDir, ffmegDirName);
        initFFmpeg(appContext, ffmpegDir);
        initialized = true;
    }

    private final void initFFmpeg(Context appContext, File ffmpegDir) throws YoutubeDLException {
        File ffmpegLib = new File(binDir, ffmpegLibName);
        String ffmpegSize = String.valueOf(ffmpegLib.length());
        if (!ffmpegDir.exists() || shouldUpdateFFmpeg(appContext, ffmpegSize)) {
            FileUtils.deleteQuietly(ffmpegDir);
            ffmpegDir.mkdirs();
            try {
                ZipUtils.INSTANCE.unzip(ffmpegLib, ffmpegDir);
                updateFFmpeg(appContext, ffmpegSize);
            } catch (Exception e) {
                FileUtils.deleteQuietly(ffmpegDir);
                throw new YoutubeDLException("failed to initialize", e);
            }
        }
    }

    private final boolean shouldUpdateFFmpeg(Context appContext, String version) {
        return !Intrinsics.areEqual(version, SharedPrefsHelper.get(appContext, ffmpegLibVersion));
    }

    private final void updateFFmpeg(Context appContext, String version) {
        SharedPrefsHelper.update(appContext, ffmpegLibVersion, version);
    }

    @JvmStatic
    public static final FFmpeg getInstance() {
        return INSTANCE;
    }
}
