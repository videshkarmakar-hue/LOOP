package com.yausername.youtubedl_android;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.yausername.youtubedl_common.SharedPrefsHelper;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.p013io.FileUtils;

/* JADX INFO: compiled from: YoutubeDLUpdater.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0002J!\u0010\u0018\u001a\u00020\u00192\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u001aJ \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0012\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, m195d2 = {"Lcom/yausername/youtubedl_android/YoutubeDLUpdater;", "", "()V", "dlpBinaryName", "", "dlpVersionKey", "dlpVersionNameKey", "youtubeDLMasterChannelUrl", "youtubeDLNightlyChannelUrl", "youtubeDLStableChannelUrl", "checkForUpdate", "Lcom/fasterxml/jackson/databind/JsonNode;", "appContext", "Landroid/content/Context;", "youtubeDLChannel", "Lcom/yausername/youtubedl_android/YoutubeDL$UpdateChannel;", "download", "Ljava/io/File;", "url", "getDownloadUrl", "json", "getName", "getTag", "getYoutubeDLDir", "update", "Lcom/yausername/youtubedl_android/YoutubeDL$UpdateStatus;", "update$library_release", "updateSharedPrefs", "", "tag", "name", "version", "versionName", "library_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class YoutubeDLUpdater {
    public static final YoutubeDLUpdater INSTANCE = new YoutubeDLUpdater();
    private static final String dlpBinaryName = "yt-dlp";
    private static final String dlpVersionKey = "dlpVersion";
    private static final String dlpVersionNameKey = "dlpVersionName";
    private static final String youtubeDLMasterChannelUrl = "https://api.github.com/repos/yt-dlp/yt-dlp-master-builds/releases/latest";
    private static final String youtubeDLNightlyChannelUrl = "https://api.github.com/repos/yt-dlp/yt-dlp-nightly-builds/releases/latest";
    private static final String youtubeDLStableChannelUrl = "https://api.github.com/repos/yt-dlp/yt-dlp/releases/latest";

    private YoutubeDLUpdater() {
    }

    public static /* synthetic */ YoutubeDL.UpdateStatus update$library_release$default(YoutubeDLUpdater youtubeDLUpdater, Context context, YoutubeDL.UpdateChannel updateChannel, int i, Object obj) throws IOException, YoutubeDLException {
        if ((i & 2) != 0) {
            updateChannel = YoutubeDL.UpdateChannel.STABLE.INSTANCE;
        }
        return youtubeDLUpdater.update$library_release(context, updateChannel);
    }

    public final YoutubeDL.UpdateStatus update$library_release(Context appContext, YoutubeDL.UpdateChannel youtubeDLChannel) throws IOException, YoutubeDLException {
        Intrinsics.checkNotNullParameter(youtubeDLChannel, "youtubeDLChannel");
        Intrinsics.checkNotNull(appContext);
        JsonNode json = checkForUpdate(appContext, youtubeDLChannel);
        if (json == null) {
            return YoutubeDL.UpdateStatus.ALREADY_UP_TO_DATE;
        }
        String downloadUrl = getDownloadUrl(json);
        File file = download(appContext, downloadUrl);
        File ytdlpDir = getYoutubeDLDir(appContext);
        File binary = new File(ytdlpDir, "yt-dlp");
        try {
            try {
                if (ytdlpDir.exists()) {
                    FileUtils.deleteDirectory(ytdlpDir);
                }
                ytdlpDir.mkdirs();
                FileUtils.copyFile(file, binary);
                file.delete();
                updateSharedPrefs(appContext, getTag(json), getName(json));
                return YoutubeDL.UpdateStatus.DONE;
            } catch (Exception e) {
                FileUtils.deleteQuietly(ytdlpDir);
                YoutubeDL.getInstance().init_ytdlp(appContext, ytdlpDir);
                throw new YoutubeDLException(e);
            }
        } catch (Throwable th) {
            file.delete();
            throw th;
        }
    }

    private final void updateSharedPrefs(Context appContext, String tag, String name) {
        SharedPrefsHelper.update(appContext, dlpVersionKey, tag);
        SharedPrefsHelper.update(appContext, dlpVersionNameKey, name);
    }

    private final JsonNode checkForUpdate(Context appContext, YoutubeDL.UpdateChannel youtubeDLChannel) throws IOException {
        URL url = new URL(youtubeDLChannel.getApiUrl());
        JsonNode json = YoutubeDL.INSTANCE.getObjectMapper().readTree(url);
        Intrinsics.checkNotNullExpressionValue(json, "json");
        String newVersion = getTag(json);
        String oldVersion = SharedPrefsHelper.get(appContext, dlpVersionKey);
        if (Intrinsics.areEqual(newVersion, oldVersion)) {
            return null;
        }
        return json;
    }

    private final String getTag(JsonNode json) {
        String strAsText = json.get("tag_name").asText();
        Intrinsics.checkNotNullExpressionValue(strAsText, "json[\"tag_name\"].asText()");
        return strAsText;
    }

    private final String getName(JsonNode json) {
        String strAsText = json.get("name").asText();
        Intrinsics.checkNotNullExpressionValue(strAsText, "json[\"name\"].asText()");
        return strAsText;
    }

    private final String getDownloadUrl(JsonNode json) throws YoutubeDLException {
        JsonNode jsonNode = json.get("assets");
        Intrinsics.checkNotNull(jsonNode, "null cannot be cast to non-null type com.fasterxml.jackson.databind.node.ArrayNode");
        ArrayNode assets = (ArrayNode) jsonNode;
        String downloadUrl = "";
        for (JsonNode asset : assets) {
            if (Intrinsics.areEqual("yt-dlp", asset.get("name").asText())) {
                String strAsText = asset.get("browser_download_url").asText();
                Intrinsics.checkNotNullExpressionValue(strAsText, "asset[\"browser_download_url\"].asText()");
                downloadUrl = strAsText;
                break;
            }
        }
        if (downloadUrl.length() == 0) {
            throw new YoutubeDLException("unable to get download url");
        }
        return downloadUrl;
    }

    private final File download(Context appContext, String url) throws IOException {
        URL downloadUrl = new URL(url);
        File file = File.createTempFile("yt-dlp", null, appContext.getCacheDir());
        FileUtils.copyURLToFile(downloadUrl, file, 5000, 10000);
        Intrinsics.checkNotNullExpressionValue(file, "file");
        return file;
    }

    private final File getYoutubeDLDir(Context appContext) {
        File baseDir = new File(appContext.getNoBackupFilesDir(), YoutubeDL.baseName);
        return new File(baseDir, "yt-dlp");
    }

    public final String version(Context appContext) {
        Intrinsics.checkNotNull(appContext);
        return SharedPrefsHelper.get(appContext, dlpVersionKey);
    }

    public final String versionName(Context appContext) {
        Intrinsics.checkNotNull(appContext);
        return SharedPrefsHelper.get(appContext, dlpVersionNameKey);
    }
}
