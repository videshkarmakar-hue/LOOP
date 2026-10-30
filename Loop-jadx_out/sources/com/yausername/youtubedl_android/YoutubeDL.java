package com.yausername.youtubedl_android;

import android.content.Context;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yausername.youtubedl_android.mapper.VideoInfo;
import com.yausername.youtubedl_common.SharedPrefsHelper;
import com.yausername.youtubedl_common.utils.ZipUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.p013io.FileUtils;

/* JADX INFO: compiled from: YoutubeDL.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003EFGB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010#\u001a\u00020$H\u0002J\u000e\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0004J@\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00042\"\b\u0002\u0010,\u001a\u001c\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020$\u0018\u00010-H\u0007J\u000e\u00100\u001a\u0002012\u0006\u0010)\u001a\u00020*J\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0004J\b\u00103\u001a\u00020\u0000H\u0007J\u0018\u00104\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*2\u0006\u00105\u001a\u00020\u0004H\u0002J\u000e\u00106\u001a\u00020$2\u0006\u00107\u001a\u000208J\u0016\u00109\u001a\u00020$2\u0006\u00107\u001a\u0002082\u0006\u0010:\u001a\u00020\u000bJ\u0016\u0010;\u001a\u00020$2\u0006\u00107\u001a\u0002082\u0006\u0010<\u001a\u00020\u000bJ\u0018\u0010=\u001a\u00020\u00152\u0006\u00107\u001a\u0002082\u0006\u0010>\u001a\u00020\u0004H\u0002J\u0018\u0010?\u001a\u00020$2\u0006\u00107\u001a\u0002082\u0006\u0010>\u001a\u00020\u0004H\u0002J\u001a\u0010@\u001a\u0004\u0018\u00010A2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010B\u001a\u00020CJ\u0012\u0010>\u001a\u0004\u0018\u00010\u00042\b\u00107\u001a\u0004\u0018\u000108J\u0012\u0010D\u001a\u0004\u0018\u00010\u00042\b\u00107\u001a\u0004\u0018\u000108R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000RN\u0010\u000f\u001aB\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00120\u0012 \u0011* \u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00120\u0012\u0018\u00010\u00130\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, m195d2 = {"Lcom/yausername/youtubedl_android/YoutubeDL;", "", "()V", "ENV_LD_LIBRARY_PATH", "", "ENV_PYTHONHOME", "ENV_SSL_CERT_FILE", "TMPDIR", "aria2cDirName", "baseName", "binDir", "Ljava/io/File;", "ffmpegBinName", "ffmpegDirName", "ffmpegPath", "idProcessMap", "", "kotlin.jvm.PlatformType", "Ljava/lang/Process;", "", "initialized", "", "objectMapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "getObjectMapper", "()Lcom/fasterxml/jackson/databind/ObjectMapper;", "packagesRoot", "pythonBinName", "pythonDirName", "pythonLibName", YoutubeDL.pythonLibVersion, "pythonPath", "ytdlpBin", "ytdlpDirName", "ytdlpPath", "assertInit", "", "destroyProcessById", "id", "execute", "Lcom/yausername/youtubedl_android/YoutubeDLResponse;", "request", "Lcom/yausername/youtubedl_android/YoutubeDLRequest;", "processId", "callback", "Lkotlin/Function3;", "", "", "getInfo", "Lcom/yausername/youtubedl_android/mapper/VideoInfo;", "url", "getInstance", "ignoreErrors", "out", "init", "appContext", "Landroid/content/Context;", "initPython", "pythonDir", "init_ytdlp", "ytdlpDir", "shouldUpdatePython", "version", "updatePython", "updateYoutubeDL", "Lcom/yausername/youtubedl_android/YoutubeDL$UpdateStatus;", "updateChannel", "Lcom/yausername/youtubedl_android/YoutubeDL$UpdateChannel;", "versionName", "CanceledException", "UpdateChannel", "UpdateStatus", "library_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class YoutubeDL {
    private static String ENV_LD_LIBRARY_PATH = null;
    private static String ENV_PYTHONHOME = null;
    private static String ENV_SSL_CERT_FILE = null;
    private static final String aria2cDirName = "aria2c";
    public static final String baseName = "youtubedl-android";
    private static File binDir = null;
    private static final String ffmpegBinName = "libffmpeg.so";
    private static final String ffmpegDirName = "ffmpeg";
    private static File ffmpegPath = null;
    private static boolean initialized = false;
    private static final String packagesRoot = "packages";
    private static final String pythonBinName = "libpython.so";
    private static final String pythonDirName = "python";
    private static final String pythonLibName = "libpython.zip.so";
    private static final String pythonLibVersion = "pythonLibVersion";
    private static File pythonPath = null;
    public static final String ytdlpBin = "yt-dlp";
    public static final String ytdlpDirName = "yt-dlp";
    private static File ytdlpPath;
    public static final YoutubeDL INSTANCE = new YoutubeDL();
    private static String TMPDIR = "";
    private static final Map<String, Process> idProcessMap = Collections.synchronizedMap(new HashMap());
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /* JADX INFO: compiled from: YoutubeDL.kt */
    @Metadata(m194d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m195d2 = {"Lcom/yausername/youtubedl_android/YoutubeDL$CanceledException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "library_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class CanceledException extends Exception {
    }

    /* JADX INFO: compiled from: YoutubeDL.kt */
    @Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m195d2 = {"Lcom/yausername/youtubedl_android/YoutubeDL$UpdateStatus;", "", "(Ljava/lang/String;I)V", "DONE", "ALREADY_UP_TO_DATE", "library_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public enum UpdateStatus {
        DONE,
        ALREADY_UP_TO_DATE
    }

    public final YoutubeDLResponse execute(YoutubeDLRequest request) throws CanceledException, InterruptedException, YoutubeDLException {
        Intrinsics.checkNotNullParameter(request, "request");
        return execute$default(this, request, null, null, 6, null);
    }

    public final YoutubeDLResponse execute(YoutubeDLRequest request, String str) throws CanceledException, InterruptedException, YoutubeDLException {
        Intrinsics.checkNotNullParameter(request, "request");
        return execute$default(this, request, str, null, 4, null);
    }

    private YoutubeDL() {
    }

    public final synchronized void init(Context appContext) throws YoutubeDLException {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        if (initialized) {
            return;
        }
        File baseDir = new File(appContext.getNoBackupFilesDir(), baseName);
        if (!baseDir.exists()) {
            baseDir.mkdir();
        }
        File packagesDir = new File(baseDir, packagesRoot);
        binDir = new File(appContext.getApplicationInfo().nativeLibraryDir);
        pythonPath = new File(binDir, pythonBinName);
        ffmpegPath = new File(binDir, ffmpegBinName);
        File pythonDir = new File(packagesDir, pythonDirName);
        File ffmpegDir = new File(packagesDir, ffmpegDirName);
        File aria2cDir = new File(packagesDir, "aria2c");
        File ytdlpDir = new File(baseDir, "yt-dlp");
        ytdlpPath = new File(ytdlpDir, "yt-dlp");
        ENV_LD_LIBRARY_PATH = pythonDir.getAbsolutePath() + "/usr/lib:" + ffmpegDir.getAbsolutePath() + "/usr/lib:" + aria2cDir.getAbsolutePath() + "/usr/lib";
        ENV_SSL_CERT_FILE = pythonDir.getAbsolutePath() + "/usr/etc/tls/cert.pem";
        ENV_PYTHONHOME = pythonDir.getAbsolutePath() + "/usr";
        String absolutePath = appContext.getCacheDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "appContext.cacheDir.absolutePath");
        TMPDIR = absolutePath;
        initPython(appContext, pythonDir);
        init_ytdlp(appContext, ytdlpDir);
        initialized = true;
    }

    public final void init_ytdlp(Context appContext, File ytdlpDir) throws YoutubeDLException {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(ytdlpDir, "ytdlpDir");
        if (!ytdlpDir.exists()) {
            ytdlpDir.mkdirs();
        }
        File ytdlpBinary = new File(ytdlpDir, "yt-dlp");
        if (!ytdlpBinary.exists()) {
            try {
                InputStream inputStream = appContext.getResources().openRawResource(C4061R.raw.ytdlp);
                Intrinsics.checkNotNullExpressionValue(inputStream, "appContext.resources.openRawResource(R.raw.ytdlp)");
                FileUtils.copyInputStreamToFile(inputStream, ytdlpBinary);
            } catch (Exception e) {
                FileUtils.deleteQuietly(ytdlpDir);
                throw new YoutubeDLException("failed to initialize", e);
            }
        }
    }

    public final void initPython(Context appContext, File pythonDir) throws YoutubeDLException {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(pythonDir, "pythonDir");
        File pythonLib = new File(binDir, pythonLibName);
        String pythonSize = String.valueOf(pythonLib.length());
        if (!pythonDir.exists() || shouldUpdatePython(appContext, pythonSize)) {
            FileUtils.deleteQuietly(pythonDir);
            pythonDir.mkdirs();
            try {
                ZipUtils.INSTANCE.unzip(pythonLib, pythonDir);
                updatePython(appContext, pythonSize);
            } catch (Exception e) {
                FileUtils.deleteQuietly(pythonDir);
                throw new YoutubeDLException("failed to initialize", e);
            }
        }
    }

    private final boolean shouldUpdatePython(Context appContext, String version) {
        return !Intrinsics.areEqual(version, SharedPrefsHelper.get(appContext, pythonLibVersion));
    }

    private final void updatePython(Context appContext, String version) {
        SharedPrefsHelper.update(appContext, pythonLibVersion, version);
    }

    private final void assertInit() {
        if (!initialized) {
            throw new IllegalStateException("instance not initialized".toString());
        }
    }

    public final VideoInfo getInfo(String url) throws CanceledException, InterruptedException, YoutubeDLException {
        Intrinsics.checkNotNullParameter(url, "url");
        YoutubeDLRequest request = new YoutubeDLRequest(url);
        return getInfo(request);
    }

    public final VideoInfo getInfo(YoutubeDLRequest request) throws CanceledException, InterruptedException, YoutubeDLException {
        Intrinsics.checkNotNullParameter(request, "request");
        request.addOption("--dump-json");
        YoutubeDLResponse response = execute(request, null, null);
        try {
            VideoInfo videoInfo = (VideoInfo) objectMapper.readValue(response.getOut(), VideoInfo.class);
            if (videoInfo == null) {
                throw new YoutubeDLException("Failed to fetch video information");
            }
            return videoInfo;
        } catch (IOException e) {
            throw new YoutubeDLException("Unable to parse video information", e);
        }
    }

    private final boolean ignoreErrors(YoutubeDLRequest request, String out) {
        if (request.hasOption("--dump-json")) {
            return !(out.length() == 0) && request.hasOption("--ignore-errors");
        }
        return false;
    }

    public final boolean destroyProcessById(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        if (idProcessMap.containsKey(id)) {
            Process p = idProcessMap.get(id);
            boolean alive = true;
            if (Build.VERSION.SDK_INT >= 26) {
                Intrinsics.checkNotNull(p);
                alive = p.isAlive();
            }
            if (alive) {
                Intrinsics.checkNotNull(p);
                p.destroy();
                idProcessMap.remove(id);
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ YoutubeDLResponse execute$default(YoutubeDL youtubeDL, YoutubeDLRequest youtubeDLRequest, String str, Function3 function3, int i, Object obj) throws CanceledException, InterruptedException, YoutubeDLException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        return youtubeDL.execute(youtubeDLRequest, str, function3);
    }

    public final YoutubeDLResponse execute(YoutubeDLRequest request, String processId, Function3<? super Float, ? super Long, ? super String, Unit> callback) throws CanceledException, InterruptedException, YoutubeDLException {
        Intrinsics.checkNotNullParameter(request, "request");
        assertInit();
        if (processId != null && idProcessMap.containsKey(processId)) {
            throw new YoutubeDLException("Process ID already exists");
        }
        if (!request.hasOption("--cache-dir") || request.getOption("--cache-dir") == null) {
            request.addOption("--no-cache-dir");
        }
        if (request.buildCommand().contains("libaria2c.so")) {
            request.addOption("--external-downloader-args", "aria2c:--summary-interval=1").addOption("--external-downloader-args", "aria2c:--ca-certificate=" + ENV_SSL_CERT_FILE);
        }
        File file = ffmpegPath;
        Intrinsics.checkNotNull(file);
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "ffmpegPath!!.absolutePath");
        request.addOption("--ffmpeg-location", absolutePath);
        StringBuffer outBuffer = new StringBuffer();
        StringBuffer errBuffer = new StringBuffer();
        long startTime = System.currentTimeMillis();
        List<String> listBuildCommand = request.buildCommand();
        List command = new ArrayList();
        File file2 = pythonPath;
        Intrinsics.checkNotNull(file2);
        String absolutePath2 = file2.getAbsolutePath();
        File file3 = ytdlpPath;
        Intrinsics.checkNotNull(file3);
        command.addAll(CollectionsKt.listOf((Object[]) new String[]{absolutePath2, file3.getAbsolutePath()}));
        command.addAll(listBuildCommand);
        ProcessBuilder processBuilder = new ProcessBuilder((List<String>) command);
        Map<String, String> mapEnvironment = processBuilder.environment();
        Intrinsics.checkNotNullExpressionValue(mapEnvironment, "this");
        mapEnvironment.put("LD_LIBRARY_PATH", ENV_LD_LIBRARY_PATH);
        mapEnvironment.put("SSL_CERT_FILE", ENV_SSL_CERT_FILE);
        StringBuilder sbAppend = new StringBuilder().append(System.getenv("PATH")).append(AbstractJsonLexerKt.COLON);
        File file4 = binDir;
        Intrinsics.checkNotNull(file4);
        mapEnvironment.put("PATH", sbAppend.append(file4.getAbsolutePath()).toString());
        mapEnvironment.put("PYTHONHOME", ENV_PYTHONHOME);
        mapEnvironment.put("HOME", ENV_PYTHONHOME);
        mapEnvironment.put("TMPDIR", TMPDIR);
        try {
            Process process = processBuilder.start();
            Intrinsics.checkNotNullExpressionValue(process, "{\n            processBuilder.start()\n        }");
            if (processId != null) {
                Map<String, Process> idProcessMap2 = idProcessMap;
                Intrinsics.checkNotNullExpressionValue(idProcessMap2, "idProcessMap");
                idProcessMap2.put(processId, process);
            }
            InputStream outStream = process.getInputStream();
            InputStream errStream = process.getErrorStream();
            Intrinsics.checkNotNullExpressionValue(outStream, "outStream");
            StreamProcessExtractor stdOutProcessor = new StreamProcessExtractor(outBuffer, outStream, callback);
            Intrinsics.checkNotNullExpressionValue(errStream, "errStream");
            StreamGobbler stdErrProcessor = new StreamGobbler(errBuffer, errStream);
            try {
                stdOutProcessor.join();
                stdErrProcessor.join();
                int exitCode = process.waitFor();
                String out = outBuffer.toString();
                Intrinsics.checkNotNullExpressionValue(out, "outBuffer.toString()");
                String err = errBuffer.toString();
                Intrinsics.checkNotNullExpressionValue(err, "errBuffer.toString()");
                if (exitCode > 0) {
                    if (processId != null && !idProcessMap.containsKey(processId)) {
                        throw new CanceledException();
                    }
                    if (!ignoreErrors(request, out)) {
                        idProcessMap.remove(processId);
                        throw new YoutubeDLException(err);
                    }
                }
                idProcessMap.remove(processId);
                long elapsedTime = System.currentTimeMillis() - startTime;
                YoutubeDLResponse youtubeDLResponse = new YoutubeDLResponse(command, exitCode, elapsedTime, out, err);
                return youtubeDLResponse;
            } catch (InterruptedException e) {
                process.destroy();
                if (processId != null) {
                    idProcessMap.remove(processId);
                }
                throw e;
            }
        } catch (IOException e2) {
            throw new YoutubeDLException(e2);
        }
    }

    public static /* synthetic */ UpdateStatus updateYoutubeDL$default(YoutubeDL youtubeDL, Context context, UpdateChannel updateChannel, int i, Object obj) throws YoutubeDLException {
        if ((i & 2) != 0) {
            updateChannel = UpdateChannel.STABLE.INSTANCE;
        }
        return youtubeDL.updateYoutubeDL(context, updateChannel);
    }

    public final synchronized UpdateStatus updateYoutubeDL(Context appContext, UpdateChannel updateChannel) throws YoutubeDLException {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(updateChannel, "updateChannel");
        assertInit();
        try {
        } catch (IOException e) {
            throw new YoutubeDLException("failed to update youtube-dl", e);
        }
        return YoutubeDLUpdater.INSTANCE.update$library_release(appContext, updateChannel);
    }

    public final String version(Context appContext) {
        return YoutubeDLUpdater.INSTANCE.version(appContext);
    }

    public final String versionName(Context appContext) {
        return YoutubeDLUpdater.INSTANCE.versionName(appContext);
    }

    /* JADX INFO: compiled from: YoutubeDL.kt */
    @Metadata(m194d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u0000 \u00072\u00020\u0001:\u0004\u0007\b\t\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, m195d2 = {"Lcom/yausername/youtubedl_android/YoutubeDL$UpdateChannel;", "", "apiUrl", "", "(Ljava/lang/String;)V", "getApiUrl", "()Ljava/lang/String;", "Companion", "MASTER", "NIGHTLY", "STABLE", "library_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static class UpdateChannel {
        private final String apiUrl;
        public static final STABLE _STABLE = STABLE.INSTANCE;
        public static final NIGHTLY _NIGHTLY = NIGHTLY.INSTANCE;
        public static final MASTER _MASTER = MASTER.INSTANCE;

        /* JADX INFO: compiled from: YoutubeDL.kt */
        @Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m195d2 = {"Lcom/yausername/youtubedl_android/YoutubeDL$UpdateChannel$STABLE;", "Lcom/yausername/youtubedl_android/YoutubeDL$UpdateChannel;", "()V", "library_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class STABLE extends UpdateChannel {
            public static final STABLE INSTANCE = new STABLE();

            private STABLE() {
                super("https://api.github.com/repos/yt-dlp/yt-dlp/releases/latest");
            }
        }

        public UpdateChannel(String apiUrl) {
            Intrinsics.checkNotNullParameter(apiUrl, "apiUrl");
            this.apiUrl = apiUrl;
        }

        public final String getApiUrl() {
            return this.apiUrl;
        }

        /* JADX INFO: compiled from: YoutubeDL.kt */
        @Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m195d2 = {"Lcom/yausername/youtubedl_android/YoutubeDL$UpdateChannel$NIGHTLY;", "Lcom/yausername/youtubedl_android/YoutubeDL$UpdateChannel;", "()V", "library_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class NIGHTLY extends UpdateChannel {
            public static final NIGHTLY INSTANCE = new NIGHTLY();

            private NIGHTLY() {
                super("https://api.github.com/repos/yt-dlp/yt-dlp-nightly-builds/releases/latest");
            }
        }

        /* JADX INFO: compiled from: YoutubeDL.kt */
        @Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m195d2 = {"Lcom/yausername/youtubedl_android/YoutubeDL$UpdateChannel$MASTER;", "Lcom/yausername/youtubedl_android/YoutubeDL$UpdateChannel;", "()V", "library_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class MASTER extends UpdateChannel {
            public static final MASTER INSTANCE = new MASTER();

            private MASTER() {
                super("https://api.github.com/repos/yt-dlp/yt-dlp-master-builds/releases/latest");
            }
        }
    }

    public final ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    @JvmStatic
    public static final YoutubeDL getInstance() {
        return INSTANCE;
    }
}
