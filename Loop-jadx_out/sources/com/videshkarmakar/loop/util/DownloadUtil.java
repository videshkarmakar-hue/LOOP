package com.videshkarmakar.loop.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.util.Log;
import android.webkit.CookieManager;
import androidx.compose.foundation.text.modifiers.LayoutUtilsKt;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import coil.disk.DiskLruCache;
import com.videshkarmakar.loop.App;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.Downloader;
import com.videshkarmakar.loop.database.objects.CommandTemplate;
import com.videshkarmakar.loop.database.objects.DownloadedVideoInfo;
import com.videshkarmakar.loop.p006ui.common.Route;
import com.videshkarmakar.loop.p006ui.page.settings.network.Cookie;
import com.yausername.youtubedl_android.YoutubeDL;
import com.yausername.youtubedl_android.YoutubeDLException;
import com.yausername.youtubedl_android.YoutubeDLRequest;
import com.yausername.youtubedl_android.YoutubeDLResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p007io.FilesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import org.apache.commons.p013io.IOUtils;

/* JADX INFO: compiled from: DownloadUtil.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002YZB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002Js\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00160\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2 \u0010\u001f\u001a\u001c\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020#\u0018\u00010 H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%J*\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010*J7\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00180\u00152\u0006\u0010'\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010,\u001a\u00020\u001eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.J!\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u00160\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102J\u0019\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00102J-\u00105\u001a\b\u0012\u0004\u0012\u0002060\u00152\u0006\u00107\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00109J#\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00180\u00152\u0006\u0010;\u001a\u00020<H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b=\u0010>J$\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016H\u0002J$\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016H\u0002JA\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00160\u00152\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0004H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bE\u0010FJ$\u0010G\u001a\u00020<*\u00020<2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0014\u0010I\u001a\u00020<*\u00020<2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001c\u0010J\u001a\u00020\u0001*\u00020<2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010K\u001a\u00020\u0004H\u0002J\f\u0010L\u001a\u00020<*\u00020<H\u0002J\u0014\u0010M\u001a\u00020<*\u00020<2\u0006\u0010N\u001a\u00020\u0004H\u0002J\u0014\u0010O\u001a\u00020<*\u00020<2\u0006\u0010P\u001a\u00020\u0004H\u0002J\f\u0010Q\u001a\u00020\u0004*\u00020\u001eH\u0003J\u0010\u0010R\u001a\u00020\u0004*\b\u0012\u0004\u0012\u0002000\u0016J\u001e\u0010S\u001a\u00020T*\u00020\u00182\b\b\u0002\u0010H\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020\u0004H\u0002J\f\u0010V\u001a\u00020\u0004*\u00020\u001eH\u0007J\f\u0010W\u001a\u00020\u0004*\u00020\u001eH\u0003J\f\u0010X\u001a\u00020<*\u00020<H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006["}, m195d2 = {"Lcom/videshkarmakar/loop/util/DownloadUtil;", "", "()V", "BASENAME", "", "CLIP_TIMESTAMP", "CROP_ARTWORK_COMMAND", "EXTENSION", "ID", "OUTPUT_TEMPLATE_CHAPTERS", "OUTPUT_TEMPLATE_CLIPS", "OUTPUT_TEMPLATE_DEFAULT", "OUTPUT_TEMPLATE_ID", "OUTPUT_TEMPLATE_SPLIT", "PLAYLIST_TITLE_SUBDIRECTORY_PREFIX", "TAG", "jsonFormat", "Lkotlinx/serialization/json/Json;", "checkIfAv1HardwareAccelerated", "", "downloadVideo", "Lkotlin/Result;", "", "videoInfo", "Lcom/videshkarmakar/loop/util/VideoInfo;", "playlistUrl", "playlistItem", "", "taskId", "downloadPreferences", "Lcom/videshkarmakar/loop/util/DownloadUtil$DownloadPreferences;", "progressCallback", "Lkotlin/Function3;", "", "", "", "downloadVideo-hUnOzRk", "(Lcom/videshkarmakar/loop/util/VideoInfo;Ljava/lang/String;ILjava/lang/String;Lcom/videshkarmakar/loop/util/DownloadUtil$DownloadPreferences;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "executeCommandInBackground", "url", Route.TEMPLATE, "Lcom/videshkarmakar/loop/database/objects/CommandTemplate;", "(Ljava/lang/String;Lcom/videshkarmakar/loop/database/objects/CommandTemplate;Lcom/videshkarmakar/loop/util/DownloadUtil$DownloadPreferences;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchVideoInfoFromUrl", "preferences", "fetchVideoInfoFromUrl-0E7RQCE", "(Ljava/lang/String;ILcom/videshkarmakar/loop/util/DownloadUtil$DownloadPreferences;)Ljava/lang/Object;", "getCookieListFromDatabase", "Lcom/videshkarmakar/loop/ui/page/settings/network/Cookie;", "getCookieListFromDatabase-d1pmJ48", "()Ljava/lang/Object;", "getCookiesContentFromDatabase", "getCookiesContentFromDatabase-d1pmJ48", "getPlaylistOrVideoInfo", "Lcom/videshkarmakar/loop/util/YoutubeDLInfo;", "playlistURL", "getPlaylistOrVideoInfo-gIAlu-s", "(Ljava/lang/String;Lcom/videshkarmakar/loop/util/DownloadUtil$DownloadPreferences;)Ljava/lang/Object;", "getVideoInfo", "request", "Lcom/yausername/youtubedl_android/YoutubeDLRequest;", "getVideoInfo-IoAF18A", "(Lcom/yausername/youtubedl_android/YoutubeDLRequest;)Ljava/lang/Object;", "insertInfoIntoDownloadHistory", "filePaths", "insertSplitChapterIntoHistory", "onFinishDownloading", "downloadPath", "sdcardUri", "onFinishDownloading-BWLJW6A", "(Lcom/videshkarmakar/loop/util/DownloadUtil$DownloadPreferences;Lcom/videshkarmakar/loop/util/VideoInfo;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "addOptionsForAudioDownloads", "id", "addOptionsForVideoDownloads", "applyFormatSorter", "sorter", "enableAria2c", "enableCookies", "userAgentString", "enableProxy", "proxyUrl", "toAudioFormatSorter", "toCookiesFileContent", "toDownloadedVideoInfo", "Lcom/videshkarmakar/loop/database/objects/DownloadedVideoInfo;", "videoPath", "toFormatSorter", "toVideoFormatSorter", "useDownloadArchive", "CookieScheme", "DownloadPreferences", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DownloadUtil {
    public static final String BASENAME = "%(title).200B";
    private static final String CLIP_TIMESTAMP = "%(section_start)d-%(section_end)d";
    private static final String CROP_ARTWORK_COMMAND = "--ppa \"ffmpeg: -c:v mjpeg -vf crop=\\\"'if(gt(ih,iw),iw,ih)':'if(gt(iw,ih),ih,iw)'\\\"\"";
    public static final String EXTENSION = ".%(ext)s";
    private static final String ID = "[%(id)s]";
    private static final String OUTPUT_TEMPLATE_CHAPTERS = "chapter:%(title).200B/%(section_number)d - %(section_title).200B.%(ext)s";
    private static final String OUTPUT_TEMPLATE_CLIPS = "%(title).200B [%(section_start)d-%(section_end)d].%(ext)s";
    public static final String OUTPUT_TEMPLATE_DEFAULT = "%(title).200B.%(ext)s";
    public static final String OUTPUT_TEMPLATE_ID = "%(title).200B [%(id)s].%(ext)s";
    private static final String OUTPUT_TEMPLATE_SPLIT = "%(title).200B/%(title).200B.%(ext)s";
    private static final String PLAYLIST_TITLE_SUBDIRECTORY_PREFIX = "%(playlist)s/";
    private static final String TAG = "DownloadUtil";
    public static final DownloadUtil INSTANCE = new DownloadUtil();
    private static final Json jsonFormat = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.videshkarmakar.loop.util.DownloadUtil$jsonFormat$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            invoke2(jsonBuilder);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.setIgnoreUnknownKeys(true);
        }
    }, 1, null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.videshkarmakar.loop.util.DownloadUtil$executeCommandInBackground$1 */
    /* JADX INFO: compiled from: DownloadUtil.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.util.DownloadUtil", m210f = "DownloadUtil.kt", m211i = {0, 0, 0, 0, 0, 0}, m212l = {746}, m213m = "executeCommandInBackground", m214n = {"url", Route.TEMPLATE, "$this$executeCommandInBackground_u24lambda_u2445", "taskId", "request", "notificationId"}, m215s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
    static final class C40431 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C40431(Continuation<? super C40431> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadUtil.this.executeCommandInBackground(null, null, null, this);
        }
    }

    private DownloadUtil() {
    }

    /* JADX INFO: compiled from: DownloadUtil.kt */
    @Metadata(m194d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m195d2 = {"Lcom/videshkarmakar/loop/util/DownloadUtil$CookieScheme;", "", "()V", "EXPIRY", "", "HOST", "NAME", "PATH", "SECURE", "VALUE", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class CookieScheme {
        public static final int $stable = 0;
        public static final String EXPIRY = "expires_utc";
        public static final String HOST = "host_key";
        public static final CookieScheme INSTANCE = new CookieScheme();
        public static final String NAME = "name";
        public static final String PATH = "path";
        public static final String SECURE = "is_secure";
        public static final String VALUE = "value";

        private CookieScheme() {
        }
    }

    /* JADX INFO: renamed from: getPlaylistOrVideoInfo-gIAlu-s$default, reason: not valid java name */
    public static /* synthetic */ Object m7668getPlaylistOrVideoInfogIAlus$default(DownloadUtil downloadUtil, String str, DownloadPreferences downloadPreferences, int i, Object obj) {
        DownloadPreferences downloadPreferences2;
        if ((i & 2) == 0) {
            downloadPreferences2 = downloadPreferences;
        } else {
            downloadPreferences2 = new DownloadPreferences(false, false, false, false, false, null, false, false, false, null, false, false, 0, 0, false, null, false, false, 0, 0, false, false, null, 0, 0, null, 0, false, false, null, false, false, false, null, false, null, false, false, false, null, null, null, null, false, false, false, false, false, false, false, -1, LayoutUtilsKt.BigConstraintValue, null);
        }
        return downloadUtil.m7675getPlaylistOrVideoInfogIAlus(str, downloadPreferences2);
    }

    /* JADX INFO: renamed from: getPlaylistOrVideoInfo-gIAlu-s, reason: not valid java name */
    public final Object m7675getPlaylistOrVideoInfogIAlus(String playlistURL, DownloadPreferences downloadPreferences) {
        PlaylistResult playlistResult;
        Intrinsics.checkNotNullParameter(playlistURL, "playlistURL");
        Intrinsics.checkNotNullParameter(downloadPreferences, "downloadPreferences");
        YoutubeDL $this$getPlaylistOrVideoInfo_gIAlu_s_u24lambda_u243 = YoutubeDL.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            ToastUtil toastUtil = ToastUtil.INSTANCE;
            String string = App.INSTANCE.getContext().getString(C3070R.string.fetching_playlist_info);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            toastUtil.makeToastSuspend(string);
            YoutubeDLRequest request = new YoutubeDLRequest(playlistURL);
            request.addOption("--flat-playlist");
            request.addOption("--dump-single-json");
            request.addOption("-o", BASENAME);
            request.addOption("-R", DiskLruCache.VERSION);
            request.addOption("--socket-timeout", "5");
            if (downloadPreferences.getExtractAudio()) {
                request.addOption("-x");
            }
            INSTANCE.applyFormatSorter(request, downloadPreferences, INSTANCE.toFormatSorter(downloadPreferences));
            if (downloadPreferences.getProxy()) {
                INSTANCE.enableProxy(request, downloadPreferences.getProxyUrl());
            }
            if (downloadPreferences.getForceIpv4()) {
                request.addOption("-4");
            }
            if (downloadPreferences.getCookies()) {
                INSTANCE.enableCookies(request, downloadPreferences.getUserAgentString());
            }
            if (downloadPreferences.getRestrictFilenames()) {
                request.addOption("--restrict-filenames");
            }
            String $this$getPlaylistOrVideoInfo_gIAlu_s_u24lambda_u243_u24lambda_u242 = YoutubeDL.execute$default($this$getPlaylistOrVideoInfo_gIAlu_s_u24lambda_u243, request, playlistURL, null, 4, null).getOut();
            Json this_$iv = jsonFormat;
            this_$iv.getSerializersModule();
            PlaylistResult playlistInfo = (PlaylistResult) this_$iv.decodeFromString(PlaylistResult.INSTANCE.serializer(), $this$getPlaylistOrVideoInfo_gIAlu_s_u24lambda_u243_u24lambda_u242);
            if (!Intrinsics.areEqual(playlistInfo.getType(), "playlist")) {
                Json this_$iv2 = jsonFormat;
                this_$iv2.getSerializersModule();
                playlistResult = (YoutubeDLInfo) this_$iv2.decodeFromString(VideoInfo.INSTANCE.serializer(), $this$getPlaylistOrVideoInfo_gIAlu_s_u24lambda_u243_u24lambda_u242);
            } else {
                playlistResult = playlistInfo;
            }
            return Result.m7693constructorimpl(playlistResult);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7693constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: renamed from: getVideoInfo-IoAF18A, reason: not valid java name */
    private final Object m7669getVideoInfoIoAF18A(YoutubeDLRequest request) {
        try {
            Result.Companion companion = Result.INSTANCE;
            YoutubeDLResponse response = YoutubeDL.getInstance().execute(request, null, null);
            Json this_$iv = jsonFormat;
            String string$iv = response.getOut();
            this_$iv.getSerializersModule();
            return Result.m7693constructorimpl((VideoInfo) this_$iv.decodeFromString(VideoInfo.INSTANCE.serializer(), string$iv));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7693constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: renamed from: fetchVideoInfoFromUrl-0E7RQCE$default, reason: not valid java name */
    public static /* synthetic */ Object m7667fetchVideoInfoFromUrl0E7RQCE$default(DownloadUtil downloadUtil, String str, int i, DownloadPreferences downloadPreferences, int i2, Object obj) {
        int i3;
        DownloadPreferences downloadPreferences2;
        if ((i2 & 2) == 0) {
            i3 = i;
        } else {
            i3 = 0;
        }
        if ((i2 & 4) == 0) {
            downloadPreferences2 = downloadPreferences;
        } else {
            downloadPreferences2 = new DownloadPreferences(false, false, false, false, false, null, false, false, false, null, false, false, 0, 0, false, null, false, false, 0, 0, false, false, null, 0, 0, null, 0, false, false, null, false, false, false, null, false, null, false, false, false, null, null, null, null, false, false, false, false, false, false, false, -1, LayoutUtilsKt.BigConstraintValue, null);
        }
        return downloadUtil.m7672fetchVideoInfoFromUrl0E7RQCE(str, i3, downloadPreferences2);
    }

    /* JADX INFO: renamed from: fetchVideoInfoFromUrl-0E7RQCE, reason: not valid java name */
    public final Object m7672fetchVideoInfoFromUrl0E7RQCE(String url, int playlistItem, DownloadPreferences preferences) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        YoutubeDLRequest request = new YoutubeDLRequest(url);
        request.addOption("-o", BASENAME);
        if (preferences.getRestrictFilenames()) {
            request.addOption("--restrict-filenames");
        }
        if (preferences.getExtractAudio()) {
            request.addOption("-x");
        }
        INSTANCE.applyFormatSorter(request, preferences, INSTANCE.toFormatSorter(preferences));
        if (preferences.getCookies()) {
            INSTANCE.enableCookies(request, preferences.getUserAgentString());
        }
        if (preferences.getProxy()) {
            INSTANCE.enableProxy(request, preferences.getProxyUrl());
        }
        if (preferences.getForceIpv4()) {
            request.addOption("-4");
        }
        if (preferences.getAutoSubtitle()) {
            request.addOption("--write-auto-subs");
            if (!preferences.getAutoTranslatedSubtitles()) {
                request.addOption("--extractor-args", "youtube:skip=translated_subs");
            }
        }
        if (playlistItem != 0) {
            request.addOption("--playlist-items", Integer.valueOf(playlistItem));
            request.addOption("--dump-json");
        } else {
            request.addOption("--dump-single-json");
        }
        request.addOption("-R", DiskLruCache.VERSION);
        request.addOption("--no-playlist");
        request.addOption("--socket-timeout", "5");
        return INSTANCE.m7669getVideoInfoIoAF18A(request);
    }

    /* JADX INFO: compiled from: DownloadUtil.kt */
    @Metadata(m194d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b}\b\u0087\b\u0018\u00002\u00020\u0001Bÿ\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\t\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001e\u001a\u00020\t\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0011\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u0012\b\b\u0002\u0010#\u001a\u00020\u0003\u0012\b\b\u0002\u0010$\u001a\u00020\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\u0003\u0012\b\b\u0002\u0010&\u001a\u00020\t\u0012\b\b\u0002\u0010'\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)\u0012\b\b\u0002\u0010+\u001a\u00020\u0003\u0012\b\b\u0002\u0010,\u001a\u00020\u0003\u0012\b\b\u0002\u0010-\u001a\u00020\u0003\u0012\b\b\u0002\u0010.\u001a\u00020\t\u0012\b\b\u0002\u0010/\u001a\u00020\t\u0012\b\b\u0002\u00100\u001a\u00020\t\u0012\b\b\u0002\u00101\u001a\u00020\t\u0012\b\b\u0002\u00102\u001a\u00020\u0003\u0012\b\b\u0002\u00103\u001a\u00020\u0003\u0012\b\b\u0002\u00104\u001a\u00020\u0003\u0012\b\b\u0002\u00105\u001a\u00020\u0003\u0012\b\b\u0002\u00106\u001a\u00020\u0003\u0012\b\b\u0002\u00107\u001a\u00020\u0003\u0012\b\b\u0002\u00108\u001a\u00020\u0003¢\u0006\u0002\u00109J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\t\u0010q\u001a\u00020\tHÆ\u0003J\t\u0010r\u001a\u00020\u0003HÆ\u0003J\t\u0010s\u001a\u00020\u0003HÆ\u0003J\t\u0010t\u001a\u00020\u0011HÆ\u0003J\t\u0010u\u001a\u00020\u0011HÆ\u0003J\t\u0010v\u001a\u00020\u0003HÆ\u0003J\t\u0010w\u001a\u00020\tHÆ\u0003J\t\u0010x\u001a\u00020\u0003HÆ\u0003J\t\u0010y\u001a\u00020\u0003HÆ\u0003J\t\u0010z\u001a\u00020\u0011HÆ\u0003J\t\u0010{\u001a\u00020\u0003HÆ\u0003J\t\u0010|\u001a\u00020\u0011HÆ\u0003J\t\u0010}\u001a\u00020\u0003HÆ\u0003J\t\u0010~\u001a\u00020\u0003HÆ\u0003J\t\u0010\u007f\u001a\u00020\tHÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020*0)HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009e\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010 \u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\u0003HÆ\u0003J\u0084\u0004\u0010¢\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\t2\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\t2\b\b\u0002\u0010'\u001a\u00020\u00032\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\t2\b\b\u0002\u0010/\u001a\u00020\t2\b\b\u0002\u00100\u001a\u00020\t2\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u00102\u001a\u00020\u00032\b\b\u0002\u00103\u001a\u00020\u00032\b\b\u0002\u00104\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u00032\b\b\u0002\u00107\u001a\u00020\u00032\b\b\u0002\u00108\u001a\u00020\u0003HÆ\u0001J\u0015\u0010£\u0001\u001a\u00020\u00032\t\u0010¤\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010¥\u0001\u001a\u00020\u0011HÖ\u0001J\n\u0010¦\u0001\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u001c\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\u0017\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b>\u0010=R\u0011\u0010\u0018\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b?\u0010=R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010;R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010;R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010\u0012\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bD\u0010=R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u0010;R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bF\u0010=R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010;R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010;R\u0011\u0010$\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010;R\u0011\u0010,\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010;R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u0010;R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u0010;R\u0011\u00103\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bM\u0010;R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bN\u0010;R\u0011\u0010'\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u0010;R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u0010;R\u0011\u00106\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010;R\u0011\u0010\u001e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bR\u0010CR\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u0010;R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bT\u0010;R\u0011\u0010\"\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bU\u0010CR\u0011\u00107\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bV\u0010;R\u0011\u00108\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bW\u0010;R\u0011\u0010/\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bX\u0010CR\u0011\u00101\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bY\u0010CR\u0011\u0010#\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010;R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b[\u0010;R\u0011\u0010-\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010;R\u0011\u0010.\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b]\u0010CR\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b^\u0010;R\u0011\u00104\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b_\u0010;R\u0011\u0010%\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b`\u0010;R\u0011\u0010&\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\ba\u0010CR\u0011\u0010\u001b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bb\u0010CR\u0011\u0010+\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bc\u0010;R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bd\u0010;R\u0011\u0010\u0014\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\be\u0010CR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bf\u0010;R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bg\u0010;R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bh\u0010CR\u0011\u00105\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bi\u0010;R\u0011\u00102\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bj\u0010;R\u0011\u00100\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bk\u0010CR\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0011\u0010\u001d\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bn\u0010=R\u0011\u0010\u001f\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bo\u0010=¨\u0006§\u0001"}, m195d2 = {"Lcom/videshkarmakar/loop/util/DownloadUtil$DownloadPreferences;", "", "extractAudio", "", "createThumbnail", "downloadPlaylist", "subdirectoryExtractor", "subdirectoryPlaylistTitle", "commandDirectory", "", "downloadSubtitle", "embedSubtitle", "keepSubtitle", "subtitleLanguage", "autoSubtitle", "autoTranslatedSubtitles", "convertSubtitle", "", "concurrentFragments", "sponsorBlock", "sponsorBlockCategory", PreferenceUtilKt.COOKIES, PreferenceUtilKt.ARIA2C, "audioFormat", "audioQuality", "convertAudio", "formatSorting", "sortingFields", "audioConvertFormat", "videoFormat", "formatIdString", "videoResolution", "privateMode", "rateLimit", "maxDownloadRate", "privateDirectory", "cropArtwork", "sdcard", "sdcardUri", "embedThumbnail", "videoClips", "", "Lcom/videshkarmakar/loop/util/VideoClip;", "splitByChapter", PreferenceUtilKt.DEBUG, PreferenceUtilKt.PROXY, "proxyUrl", "newTitle", "userAgentString", "outputTemplate", "useDownloadArchive", "embedMetadata", "restrictFilenames", "supportAv1HardwareDecoding", "forceIpv4", "mergeAudioStream", "mergeToMkv", "(ZZZZZLjava/lang/String;ZZZLjava/lang/String;ZZIIZLjava/lang/String;ZZIIZZLjava/lang/String;IILjava/lang/String;IZZLjava/lang/String;ZZZLjava/lang/String;ZLjava/util/List;ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZZZ)V", "getAria2c", "()Z", "getAudioConvertFormat", "()I", "getAudioFormat", "getAudioQuality", "getAutoSubtitle", "getAutoTranslatedSubtitles", "getCommandDirectory", "()Ljava/lang/String;", "getConcurrentFragments", "getConvertAudio", "getConvertSubtitle", "getCookies", "getCreateThumbnail", "getCropArtwork", "getDebug", "getDownloadPlaylist", "getDownloadSubtitle", "getEmbedMetadata", "getEmbedSubtitle", "getEmbedThumbnail", "getExtractAudio", "getForceIpv4", "getFormatIdString", "getFormatSorting", "getKeepSubtitle", "getMaxDownloadRate", "getMergeAudioStream", "getMergeToMkv", "getNewTitle", "getOutputTemplate", "getPrivateDirectory", "getPrivateMode", "getProxy", "getProxyUrl", "getRateLimit", "getRestrictFilenames", "getSdcard", "getSdcardUri", "getSortingFields", "getSplitByChapter", "getSponsorBlock", "getSponsorBlockCategory", "getSubdirectoryExtractor", "getSubdirectoryPlaylistTitle", "getSubtitleLanguage", "getSupportAv1HardwareDecoding", "getUseDownloadArchive", "getUserAgentString", "getVideoClips", "()Ljava/util/List;", "getVideoFormat", "getVideoResolution", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class DownloadPreferences {
        public static final int $stable = 8;
        private final boolean aria2c;
        private final int audioConvertFormat;
        private final int audioFormat;
        private final int audioQuality;
        private final boolean autoSubtitle;
        private final boolean autoTranslatedSubtitles;
        private final String commandDirectory;
        private final int concurrentFragments;
        private final boolean convertAudio;
        private final int convertSubtitle;
        private final boolean cookies;
        private final boolean createThumbnail;
        private final boolean cropArtwork;
        private final boolean debug;
        private final boolean downloadPlaylist;
        private final boolean downloadSubtitle;
        private final boolean embedMetadata;
        private final boolean embedSubtitle;
        private final boolean embedThumbnail;
        private final boolean extractAudio;
        private final boolean forceIpv4;
        private final String formatIdString;
        private final boolean formatSorting;
        private final boolean keepSubtitle;
        private final String maxDownloadRate;
        private final boolean mergeAudioStream;
        private final boolean mergeToMkv;
        private final String newTitle;
        private final String outputTemplate;
        private final boolean privateDirectory;
        private final boolean privateMode;
        private final boolean proxy;
        private final String proxyUrl;
        private final boolean rateLimit;
        private final boolean restrictFilenames;
        private final boolean sdcard;
        private final String sdcardUri;
        private final String sortingFields;
        private final boolean splitByChapter;
        private final boolean sponsorBlock;
        private final String sponsorBlockCategory;
        private final boolean subdirectoryExtractor;
        private final boolean subdirectoryPlaylistTitle;
        private final String subtitleLanguage;
        private final boolean supportAv1HardwareDecoding;
        private final boolean useDownloadArchive;
        private final String userAgentString;
        private final List<VideoClip> videoClips;
        private final int videoFormat;
        private final int videoResolution;

        public DownloadPreferences() {
            this(false, false, false, false, false, null, false, false, false, null, false, false, 0, 0, false, null, false, false, 0, 0, false, false, null, 0, 0, null, 0, false, false, null, false, false, false, null, false, null, false, false, false, null, null, null, null, false, false, false, false, false, false, false, -1, LayoutUtilsKt.BigConstraintValue, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DownloadPreferences copy$default(DownloadPreferences downloadPreferences, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, boolean z6, boolean z7, boolean z8, String str2, boolean z9, boolean z10, int i, int i2, boolean z11, String str3, boolean z12, boolean z13, int i3, int i4, boolean z14, boolean z15, String str4, int i5, int i6, String str5, int i7, boolean z16, boolean z17, String str6, boolean z18, boolean z19, boolean z20, String str7, boolean z21, List list, boolean z22, boolean z23, boolean z24, String str8, String str9, String str10, String str11, boolean z25, boolean z26, boolean z27, boolean z28, boolean z29, boolean z30, boolean z31, int i8, int i9, Object obj) {
            return downloadPreferences.copy((i8 & 1) != 0 ? downloadPreferences.extractAudio : z, (i8 & 2) != 0 ? downloadPreferences.createThumbnail : z2, (i8 & 4) != 0 ? downloadPreferences.downloadPlaylist : z3, (i8 & 8) != 0 ? downloadPreferences.subdirectoryExtractor : z4, (i8 & 16) != 0 ? downloadPreferences.subdirectoryPlaylistTitle : z5, (i8 & 32) != 0 ? downloadPreferences.commandDirectory : str, (i8 & 64) != 0 ? downloadPreferences.downloadSubtitle : z6, (i8 & 128) != 0 ? downloadPreferences.embedSubtitle : z7, (i8 & 256) != 0 ? downloadPreferences.keepSubtitle : z8, (i8 & 512) != 0 ? downloadPreferences.subtitleLanguage : str2, (i8 & 1024) != 0 ? downloadPreferences.autoSubtitle : z9, (i8 & 2048) != 0 ? downloadPreferences.autoTranslatedSubtitles : z10, (i8 & 4096) != 0 ? downloadPreferences.convertSubtitle : i, (i8 & 8192) != 0 ? downloadPreferences.concurrentFragments : i2, (i8 & 16384) != 0 ? downloadPreferences.sponsorBlock : z11, (i8 & 32768) != 0 ? downloadPreferences.sponsorBlockCategory : str3, (i8 & 65536) != 0 ? downloadPreferences.cookies : z12, (i8 & 131072) != 0 ? downloadPreferences.aria2c : z13, (i8 & 262144) != 0 ? downloadPreferences.audioFormat : i3, (i8 & 524288) != 0 ? downloadPreferences.audioQuality : i4, (i8 & 1048576) != 0 ? downloadPreferences.convertAudio : z14, (i8 & 2097152) != 0 ? downloadPreferences.formatSorting : z15, (i8 & 4194304) != 0 ? downloadPreferences.sortingFields : str4, (i8 & 8388608) != 0 ? downloadPreferences.audioConvertFormat : i5, (i8 & 16777216) != 0 ? downloadPreferences.videoFormat : i6, (i8 & 33554432) != 0 ? downloadPreferences.formatIdString : str5, (i8 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? downloadPreferences.videoResolution : i7, (i8 & 134217728) != 0 ? downloadPreferences.privateMode : z16, (i8 & 268435456) != 0 ? downloadPreferences.rateLimit : z17, (i8 & 536870912) != 0 ? downloadPreferences.maxDownloadRate : str6, (i8 & BasicMeasure.EXACTLY) != 0 ? downloadPreferences.privateDirectory : z18, (i8 & Integer.MIN_VALUE) != 0 ? downloadPreferences.cropArtwork : z19, (i9 & 1) != 0 ? downloadPreferences.sdcard : z20, (i9 & 2) != 0 ? downloadPreferences.sdcardUri : str7, (i9 & 4) != 0 ? downloadPreferences.embedThumbnail : z21, (i9 & 8) != 0 ? downloadPreferences.videoClips : list, (i9 & 16) != 0 ? downloadPreferences.splitByChapter : z22, (i9 & 32) != 0 ? downloadPreferences.debug : z23, (i9 & 64) != 0 ? downloadPreferences.proxy : z24, (i9 & 128) != 0 ? downloadPreferences.proxyUrl : str8, (i9 & 256) != 0 ? downloadPreferences.newTitle : str9, (i9 & 512) != 0 ? downloadPreferences.userAgentString : str10, (i9 & 1024) != 0 ? downloadPreferences.outputTemplate : str11, (i9 & 2048) != 0 ? downloadPreferences.useDownloadArchive : z25, (i9 & 4096) != 0 ? downloadPreferences.embedMetadata : z26, (i9 & 8192) != 0 ? downloadPreferences.restrictFilenames : z27, (i9 & 16384) != 0 ? downloadPreferences.supportAv1HardwareDecoding : z28, (i9 & 32768) != 0 ? downloadPreferences.forceIpv4 : z29, (i9 & 65536) != 0 ? downloadPreferences.mergeAudioStream : z30, (i9 & 131072) != 0 ? downloadPreferences.mergeToMkv : z31);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getExtractAudio() {
            return this.extractAudio;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getSubtitleLanguage() {
            return this.subtitleLanguage;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getAutoSubtitle() {
            return this.autoSubtitle;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final boolean getAutoTranslatedSubtitles() {
            return this.autoTranslatedSubtitles;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final int getConvertSubtitle() {
            return this.convertSubtitle;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final int getConcurrentFragments() {
            return this.concurrentFragments;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final boolean getSponsorBlock() {
            return this.sponsorBlock;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final String getSponsorBlockCategory() {
            return this.sponsorBlockCategory;
        }

        /* JADX INFO: renamed from: component17, reason: from getter */
        public final boolean getCookies() {
            return this.cookies;
        }

        /* JADX INFO: renamed from: component18, reason: from getter */
        public final boolean getAria2c() {
            return this.aria2c;
        }

        /* JADX INFO: renamed from: component19, reason: from getter */
        public final int getAudioFormat() {
            return this.audioFormat;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getCreateThumbnail() {
            return this.createThumbnail;
        }

        /* JADX INFO: renamed from: component20, reason: from getter */
        public final int getAudioQuality() {
            return this.audioQuality;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final boolean getConvertAudio() {
            return this.convertAudio;
        }

        /* JADX INFO: renamed from: component22, reason: from getter */
        public final boolean getFormatSorting() {
            return this.formatSorting;
        }

        /* JADX INFO: renamed from: component23, reason: from getter */
        public final String getSortingFields() {
            return this.sortingFields;
        }

        /* JADX INFO: renamed from: component24, reason: from getter */
        public final int getAudioConvertFormat() {
            return this.audioConvertFormat;
        }

        /* JADX INFO: renamed from: component25, reason: from getter */
        public final int getVideoFormat() {
            return this.videoFormat;
        }

        /* JADX INFO: renamed from: component26, reason: from getter */
        public final String getFormatIdString() {
            return this.formatIdString;
        }

        /* JADX INFO: renamed from: component27, reason: from getter */
        public final int getVideoResolution() {
            return this.videoResolution;
        }

        /* JADX INFO: renamed from: component28, reason: from getter */
        public final boolean getPrivateMode() {
            return this.privateMode;
        }

        /* JADX INFO: renamed from: component29, reason: from getter */
        public final boolean getRateLimit() {
            return this.rateLimit;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getDownloadPlaylist() {
            return this.downloadPlaylist;
        }

        /* JADX INFO: renamed from: component30, reason: from getter */
        public final String getMaxDownloadRate() {
            return this.maxDownloadRate;
        }

        /* JADX INFO: renamed from: component31, reason: from getter */
        public final boolean getPrivateDirectory() {
            return this.privateDirectory;
        }

        /* JADX INFO: renamed from: component32, reason: from getter */
        public final boolean getCropArtwork() {
            return this.cropArtwork;
        }

        /* JADX INFO: renamed from: component33, reason: from getter */
        public final boolean getSdcard() {
            return this.sdcard;
        }

        /* JADX INFO: renamed from: component34, reason: from getter */
        public final String getSdcardUri() {
            return this.sdcardUri;
        }

        /* JADX INFO: renamed from: component35, reason: from getter */
        public final boolean getEmbedThumbnail() {
            return this.embedThumbnail;
        }

        public final List<VideoClip> component36() {
            return this.videoClips;
        }

        /* JADX INFO: renamed from: component37, reason: from getter */
        public final boolean getSplitByChapter() {
            return this.splitByChapter;
        }

        /* JADX INFO: renamed from: component38, reason: from getter */
        public final boolean getDebug() {
            return this.debug;
        }

        /* JADX INFO: renamed from: component39, reason: from getter */
        public final boolean getProxy() {
            return this.proxy;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getSubdirectoryExtractor() {
            return this.subdirectoryExtractor;
        }

        /* JADX INFO: renamed from: component40, reason: from getter */
        public final String getProxyUrl() {
            return this.proxyUrl;
        }

        /* JADX INFO: renamed from: component41, reason: from getter */
        public final String getNewTitle() {
            return this.newTitle;
        }

        /* JADX INFO: renamed from: component42, reason: from getter */
        public final String getUserAgentString() {
            return this.userAgentString;
        }

        /* JADX INFO: renamed from: component43, reason: from getter */
        public final String getOutputTemplate() {
            return this.outputTemplate;
        }

        /* JADX INFO: renamed from: component44, reason: from getter */
        public final boolean getUseDownloadArchive() {
            return this.useDownloadArchive;
        }

        /* JADX INFO: renamed from: component45, reason: from getter */
        public final boolean getEmbedMetadata() {
            return this.embedMetadata;
        }

        /* JADX INFO: renamed from: component46, reason: from getter */
        public final boolean getRestrictFilenames() {
            return this.restrictFilenames;
        }

        /* JADX INFO: renamed from: component47, reason: from getter */
        public final boolean getSupportAv1HardwareDecoding() {
            return this.supportAv1HardwareDecoding;
        }

        /* JADX INFO: renamed from: component48, reason: from getter */
        public final boolean getForceIpv4() {
            return this.forceIpv4;
        }

        /* JADX INFO: renamed from: component49, reason: from getter */
        public final boolean getMergeAudioStream() {
            return this.mergeAudioStream;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getSubdirectoryPlaylistTitle() {
            return this.subdirectoryPlaylistTitle;
        }

        /* JADX INFO: renamed from: component50, reason: from getter */
        public final boolean getMergeToMkv() {
            return this.mergeToMkv;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getCommandDirectory() {
            return this.commandDirectory;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getDownloadSubtitle() {
            return this.downloadSubtitle;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getEmbedSubtitle() {
            return this.embedSubtitle;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getKeepSubtitle() {
            return this.keepSubtitle;
        }

        public final DownloadPreferences copy(boolean extractAudio, boolean createThumbnail, boolean downloadPlaylist, boolean subdirectoryExtractor, boolean subdirectoryPlaylistTitle, String commandDirectory, boolean downloadSubtitle, boolean embedSubtitle, boolean keepSubtitle, String subtitleLanguage, boolean autoSubtitle, boolean autoTranslatedSubtitles, int convertSubtitle, int concurrentFragments, boolean sponsorBlock, String sponsorBlockCategory, boolean cookies, boolean aria2c, int audioFormat, int audioQuality, boolean convertAudio, boolean formatSorting, String sortingFields, int audioConvertFormat, int videoFormat, String formatIdString, int videoResolution, boolean privateMode, boolean rateLimit, String maxDownloadRate, boolean privateDirectory, boolean cropArtwork, boolean sdcard, String sdcardUri, boolean embedThumbnail, List<VideoClip> videoClips, boolean splitByChapter, boolean debug, boolean proxy, String proxyUrl, String newTitle, String userAgentString, String outputTemplate, boolean useDownloadArchive, boolean embedMetadata, boolean restrictFilenames, boolean supportAv1HardwareDecoding, boolean forceIpv4, boolean mergeAudioStream, boolean mergeToMkv) {
            Intrinsics.checkNotNullParameter(commandDirectory, "commandDirectory");
            Intrinsics.checkNotNullParameter(subtitleLanguage, "subtitleLanguage");
            Intrinsics.checkNotNullParameter(sponsorBlockCategory, "sponsorBlockCategory");
            Intrinsics.checkNotNullParameter(sortingFields, "sortingFields");
            Intrinsics.checkNotNullParameter(formatIdString, "formatIdString");
            Intrinsics.checkNotNullParameter(maxDownloadRate, "maxDownloadRate");
            Intrinsics.checkNotNullParameter(sdcardUri, "sdcardUri");
            Intrinsics.checkNotNullParameter(videoClips, "videoClips");
            Intrinsics.checkNotNullParameter(proxyUrl, "proxyUrl");
            Intrinsics.checkNotNullParameter(newTitle, "newTitle");
            Intrinsics.checkNotNullParameter(userAgentString, "userAgentString");
            Intrinsics.checkNotNullParameter(outputTemplate, "outputTemplate");
            return new DownloadPreferences(extractAudio, createThumbnail, downloadPlaylist, subdirectoryExtractor, subdirectoryPlaylistTitle, commandDirectory, downloadSubtitle, embedSubtitle, keepSubtitle, subtitleLanguage, autoSubtitle, autoTranslatedSubtitles, convertSubtitle, concurrentFragments, sponsorBlock, sponsorBlockCategory, cookies, aria2c, audioFormat, audioQuality, convertAudio, formatSorting, sortingFields, audioConvertFormat, videoFormat, formatIdString, videoResolution, privateMode, rateLimit, maxDownloadRate, privateDirectory, cropArtwork, sdcard, sdcardUri, embedThumbnail, videoClips, splitByChapter, debug, proxy, proxyUrl, newTitle, userAgentString, outputTemplate, useDownloadArchive, embedMetadata, restrictFilenames, supportAv1HardwareDecoding, forceIpv4, mergeAudioStream, mergeToMkv);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DownloadPreferences)) {
                return false;
            }
            DownloadPreferences downloadPreferences = (DownloadPreferences) other;
            return this.extractAudio == downloadPreferences.extractAudio && this.createThumbnail == downloadPreferences.createThumbnail && this.downloadPlaylist == downloadPreferences.downloadPlaylist && this.subdirectoryExtractor == downloadPreferences.subdirectoryExtractor && this.subdirectoryPlaylistTitle == downloadPreferences.subdirectoryPlaylistTitle && Intrinsics.areEqual(this.commandDirectory, downloadPreferences.commandDirectory) && this.downloadSubtitle == downloadPreferences.downloadSubtitle && this.embedSubtitle == downloadPreferences.embedSubtitle && this.keepSubtitle == downloadPreferences.keepSubtitle && Intrinsics.areEqual(this.subtitleLanguage, downloadPreferences.subtitleLanguage) && this.autoSubtitle == downloadPreferences.autoSubtitle && this.autoTranslatedSubtitles == downloadPreferences.autoTranslatedSubtitles && this.convertSubtitle == downloadPreferences.convertSubtitle && this.concurrentFragments == downloadPreferences.concurrentFragments && this.sponsorBlock == downloadPreferences.sponsorBlock && Intrinsics.areEqual(this.sponsorBlockCategory, downloadPreferences.sponsorBlockCategory) && this.cookies == downloadPreferences.cookies && this.aria2c == downloadPreferences.aria2c && this.audioFormat == downloadPreferences.audioFormat && this.audioQuality == downloadPreferences.audioQuality && this.convertAudio == downloadPreferences.convertAudio && this.formatSorting == downloadPreferences.formatSorting && Intrinsics.areEqual(this.sortingFields, downloadPreferences.sortingFields) && this.audioConvertFormat == downloadPreferences.audioConvertFormat && this.videoFormat == downloadPreferences.videoFormat && Intrinsics.areEqual(this.formatIdString, downloadPreferences.formatIdString) && this.videoResolution == downloadPreferences.videoResolution && this.privateMode == downloadPreferences.privateMode && this.rateLimit == downloadPreferences.rateLimit && Intrinsics.areEqual(this.maxDownloadRate, downloadPreferences.maxDownloadRate) && this.privateDirectory == downloadPreferences.privateDirectory && this.cropArtwork == downloadPreferences.cropArtwork && this.sdcard == downloadPreferences.sdcard && Intrinsics.areEqual(this.sdcardUri, downloadPreferences.sdcardUri) && this.embedThumbnail == downloadPreferences.embedThumbnail && Intrinsics.areEqual(this.videoClips, downloadPreferences.videoClips) && this.splitByChapter == downloadPreferences.splitByChapter && this.debug == downloadPreferences.debug && this.proxy == downloadPreferences.proxy && Intrinsics.areEqual(this.proxyUrl, downloadPreferences.proxyUrl) && Intrinsics.areEqual(this.newTitle, downloadPreferences.newTitle) && Intrinsics.areEqual(this.userAgentString, downloadPreferences.userAgentString) && Intrinsics.areEqual(this.outputTemplate, downloadPreferences.outputTemplate) && this.useDownloadArchive == downloadPreferences.useDownloadArchive && this.embedMetadata == downloadPreferences.embedMetadata && this.restrictFilenames == downloadPreferences.restrictFilenames && this.supportAv1HardwareDecoding == downloadPreferences.supportAv1HardwareDecoding && this.forceIpv4 == downloadPreferences.forceIpv4 && this.mergeAudioStream == downloadPreferences.mergeAudioStream && this.mergeToMkv == downloadPreferences.mergeToMkv;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.extractAudio) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.createThumbnail)) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.downloadPlaylist)) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.subdirectoryExtractor)) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.subdirectoryPlaylistTitle)) * 31) + this.commandDirectory.hashCode()) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.downloadSubtitle)) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.embedSubtitle)) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.keepSubtitle)) * 31) + this.subtitleLanguage.hashCode()) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.autoSubtitle)) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.autoTranslatedSubtitles)) * 31) + this.convertSubtitle) * 31) + this.concurrentFragments) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.sponsorBlock)) * 31) + this.sponsorBlockCategory.hashCode()) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.cookies)) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.aria2c)) * 31) + this.audioFormat) * 31) + this.audioQuality) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.convertAudio)) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.formatSorting)) * 31) + this.sortingFields.hashCode()) * 31) + this.audioConvertFormat) * 31) + this.videoFormat) * 31) + this.formatIdString.hashCode()) * 31) + this.videoResolution) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.privateMode)) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.rateLimit)) * 31) + this.maxDownloadRate.hashCode()) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.privateDirectory)) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.cropArtwork)) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.sdcard)) * 31) + this.sdcardUri.hashCode()) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.embedThumbnail)) * 31) + this.videoClips.hashCode()) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.splitByChapter)) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.debug)) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.proxy)) * 31) + this.proxyUrl.hashCode()) * 31) + this.newTitle.hashCode()) * 31) + this.userAgentString.hashCode()) * 31) + this.outputTemplate.hashCode()) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.useDownloadArchive)) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.embedMetadata)) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.restrictFilenames)) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.supportAv1HardwareDecoding)) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.forceIpv4)) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.mergeAudioStream)) * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.mergeToMkv);
        }

        public String toString() {
            return "DownloadPreferences(extractAudio=" + this.extractAudio + ", createThumbnail=" + this.createThumbnail + ", downloadPlaylist=" + this.downloadPlaylist + ", subdirectoryExtractor=" + this.subdirectoryExtractor + ", subdirectoryPlaylistTitle=" + this.subdirectoryPlaylistTitle + ", commandDirectory=" + this.commandDirectory + ", downloadSubtitle=" + this.downloadSubtitle + ", embedSubtitle=" + this.embedSubtitle + ", keepSubtitle=" + this.keepSubtitle + ", subtitleLanguage=" + this.subtitleLanguage + ", autoSubtitle=" + this.autoSubtitle + ", autoTranslatedSubtitles=" + this.autoTranslatedSubtitles + ", convertSubtitle=" + this.convertSubtitle + ", concurrentFragments=" + this.concurrentFragments + ", sponsorBlock=" + this.sponsorBlock + ", sponsorBlockCategory=" + this.sponsorBlockCategory + ", cookies=" + this.cookies + ", aria2c=" + this.aria2c + ", audioFormat=" + this.audioFormat + ", audioQuality=" + this.audioQuality + ", convertAudio=" + this.convertAudio + ", formatSorting=" + this.formatSorting + ", sortingFields=" + this.sortingFields + ", audioConvertFormat=" + this.audioConvertFormat + ", videoFormat=" + this.videoFormat + ", formatIdString=" + this.formatIdString + ", videoResolution=" + this.videoResolution + ", privateMode=" + this.privateMode + ", rateLimit=" + this.rateLimit + ", maxDownloadRate=" + this.maxDownloadRate + ", privateDirectory=" + this.privateDirectory + ", cropArtwork=" + this.cropArtwork + ", sdcard=" + this.sdcard + ", sdcardUri=" + this.sdcardUri + ", embedThumbnail=" + this.embedThumbnail + ", videoClips=" + this.videoClips + ", splitByChapter=" + this.splitByChapter + ", debug=" + this.debug + ", proxy=" + this.proxy + ", proxyUrl=" + this.proxyUrl + ", newTitle=" + this.newTitle + ", userAgentString=" + this.userAgentString + ", outputTemplate=" + this.outputTemplate + ", useDownloadArchive=" + this.useDownloadArchive + ", embedMetadata=" + this.embedMetadata + ", restrictFilenames=" + this.restrictFilenames + ", supportAv1HardwareDecoding=" + this.supportAv1HardwareDecoding + ", forceIpv4=" + this.forceIpv4 + ", mergeAudioStream=" + this.mergeAudioStream + ", mergeToMkv=" + this.mergeToMkv + ")";
        }

        public DownloadPreferences(boolean extractAudio, boolean createThumbnail, boolean downloadPlaylist, boolean subdirectoryExtractor, boolean subdirectoryPlaylistTitle, String commandDirectory, boolean downloadSubtitle, boolean embedSubtitle, boolean keepSubtitle, String subtitleLanguage, boolean autoSubtitle, boolean autoTranslatedSubtitles, int convertSubtitle, int concurrentFragments, boolean sponsorBlock, String sponsorBlockCategory, boolean cookies, boolean aria2c, int audioFormat, int audioQuality, boolean convertAudio, boolean formatSorting, String sortingFields, int audioConvertFormat, int videoFormat, String formatIdString, int videoResolution, boolean privateMode, boolean rateLimit, String maxDownloadRate, boolean privateDirectory, boolean cropArtwork, boolean sdcard, String sdcardUri, boolean embedThumbnail, List<VideoClip> videoClips, boolean splitByChapter, boolean debug, boolean proxy, String proxyUrl, String newTitle, String userAgentString, String outputTemplate, boolean useDownloadArchive, boolean embedMetadata, boolean restrictFilenames, boolean supportAv1HardwareDecoding, boolean forceIpv4, boolean mergeAudioStream, boolean mergeToMkv) {
            Intrinsics.checkNotNullParameter(commandDirectory, "commandDirectory");
            Intrinsics.checkNotNullParameter(subtitleLanguage, "subtitleLanguage");
            Intrinsics.checkNotNullParameter(sponsorBlockCategory, "sponsorBlockCategory");
            Intrinsics.checkNotNullParameter(sortingFields, "sortingFields");
            Intrinsics.checkNotNullParameter(formatIdString, "formatIdString");
            Intrinsics.checkNotNullParameter(maxDownloadRate, "maxDownloadRate");
            Intrinsics.checkNotNullParameter(sdcardUri, "sdcardUri");
            Intrinsics.checkNotNullParameter(videoClips, "videoClips");
            Intrinsics.checkNotNullParameter(proxyUrl, "proxyUrl");
            Intrinsics.checkNotNullParameter(newTitle, "newTitle");
            Intrinsics.checkNotNullParameter(userAgentString, "userAgentString");
            Intrinsics.checkNotNullParameter(outputTemplate, "outputTemplate");
            this.extractAudio = extractAudio;
            this.createThumbnail = createThumbnail;
            this.downloadPlaylist = downloadPlaylist;
            this.subdirectoryExtractor = subdirectoryExtractor;
            this.subdirectoryPlaylistTitle = subdirectoryPlaylistTitle;
            this.commandDirectory = commandDirectory;
            this.downloadSubtitle = downloadSubtitle;
            this.embedSubtitle = embedSubtitle;
            this.keepSubtitle = keepSubtitle;
            this.subtitleLanguage = subtitleLanguage;
            this.autoSubtitle = autoSubtitle;
            this.autoTranslatedSubtitles = autoTranslatedSubtitles;
            this.convertSubtitle = convertSubtitle;
            this.concurrentFragments = concurrentFragments;
            this.sponsorBlock = sponsorBlock;
            this.sponsorBlockCategory = sponsorBlockCategory;
            this.cookies = cookies;
            this.aria2c = aria2c;
            this.audioFormat = audioFormat;
            this.audioQuality = audioQuality;
            this.convertAudio = convertAudio;
            this.formatSorting = formatSorting;
            this.sortingFields = sortingFields;
            this.audioConvertFormat = audioConvertFormat;
            this.videoFormat = videoFormat;
            this.formatIdString = formatIdString;
            this.videoResolution = videoResolution;
            this.privateMode = privateMode;
            this.rateLimit = rateLimit;
            this.maxDownloadRate = maxDownloadRate;
            this.privateDirectory = privateDirectory;
            this.cropArtwork = cropArtwork;
            this.sdcard = sdcard;
            this.sdcardUri = sdcardUri;
            this.embedThumbnail = embedThumbnail;
            this.videoClips = videoClips;
            this.splitByChapter = splitByChapter;
            this.debug = debug;
            this.proxy = proxy;
            this.proxyUrl = proxyUrl;
            this.newTitle = newTitle;
            this.userAgentString = userAgentString;
            this.outputTemplate = outputTemplate;
            this.useDownloadArchive = useDownloadArchive;
            this.embedMetadata = embedMetadata;
            this.restrictFilenames = restrictFilenames;
            this.supportAv1HardwareDecoding = supportAv1HardwareDecoding;
            this.forceIpv4 = forceIpv4;
            this.mergeAudioStream = mergeAudioStream;
            this.mergeToMkv = mergeToMkv;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r14v10 */
        /* JADX WARN: Type inference failed for: r14v11, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r14v39 */
        public /* synthetic */ DownloadPreferences(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, boolean z6, boolean z7, boolean z8, String str2, boolean z9, boolean z10, int i, int i2, boolean z11, String str3, boolean z12, boolean z13, int i3, int i4, boolean z14, boolean z15, String str4, int i5, int i6, String str5, int i7, boolean z16, boolean z17, String str6, boolean z18, boolean z19, boolean z20, String str7, boolean z21, List list, boolean z22, boolean z23, boolean z24, String str8, String str9, String str10, String str11, boolean z25, boolean z26, boolean z27, boolean z28, boolean z29, boolean z30, boolean z31, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            int i10;
            boolean boolean$default;
            ?? r14;
            int int$default;
            Object obj;
            int i11;
            String string$default;
            int i12;
            String str12;
            boolean z32;
            boolean boolean$default2;
            String str13;
            boolean z33;
            String str14;
            boolean z34;
            Object obj2;
            int i13;
            String string$default2;
            boolean z35;
            boolean boolean$default3;
            boolean z36;
            boolean z37;
            boolean value = (i8 & 1) != 0 ? PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.EXTRACT_AUDIO) : z;
            boolean value2 = (i8 & 2) != 0 ? PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.THUMBNAIL) : z2;
            boolean value3 = (i8 & 4) != 0 ? PreferenceUtil.INSTANCE.getValue("playlist") : z3;
            boolean value4 = (i8 & 8) != 0 ? PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.SUBDIRECTORY_EXTRACTOR) : z4;
            boolean boolean$default4 = (i8 & 16) != 0 ? PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.SUBDIRECTORY_PLAYLIST_TITLE, false, 1, null) : z5;
            String string$default3 = (i8 & 32) != 0 ? PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.COMMAND_DIRECTORY, null, 1, null) : str;
            boolean value5 = (i8 & 64) != 0 ? PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.SUBTITLE) : z6;
            boolean boolean$default5 = (i8 & 128) != 0 ? PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.EMBED_SUBTITLE, false, 1, null) : z7;
            boolean boolean$default6 = (i8 & 256) != 0 ? PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.KEEP_SUBTITLE_FILES, false, 1, null) : z8;
            String string$default4 = (i8 & 512) != 0 ? PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.SUBTITLE_LANGUAGE, null, 1, null) : str2;
            boolean value6 = (i8 & 1024) != 0 ? PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.AUTO_SUBTITLE) : z9;
            if ((i8 & 2048) != 0) {
                i10 = 0;
                boolean$default = PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.AUTO_TRANSLATED_SUBTITLES, false, 1, null);
            } else {
                i10 = 0;
                boolean$default = z10;
            }
            int int$default2 = (i8 & 4096) != 0 ? PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.CONVERT_SUBTITLE, i10, 1, null) : i;
            int int$default3 = (i8 & 8192) != 0 ? PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.CONCURRENT, i10, 1, null) : i2;
            boolean value7 = (i8 & 16384) != 0 ? PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.SPONSORBLOCK) : z11;
            String sponsorBlockCategories = (i8 & 32768) != 0 ? PreferenceUtil.INSTANCE.getSponsorBlockCategories() : str3;
            boolean boolean$default7 = (i8 & 65536) != 0 ? PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.COOKIES, false, 1, null) : z12;
            boolean value8 = (i8 & 131072) != 0 ? PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.ARIA2C) : z13;
            if ((262144 & i8) != 0) {
                r14 = 0;
                int$default = PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.AUDIO_FORMAT, 0, 1, null);
            } else {
                r14 = 0;
                int$default = i3;
            }
            int int$default4 = (524288 & i8) != 0 ? PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.AUDIO_QUALITY, r14, 1, null) : i4;
            boolean boolean$default8 = (1048576 & i8) != 0 ? PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.AUDIO_CONVERT, r14, 1, null) : z14;
            boolean boolean$default9 = (2097152 & i8) != 0 ? PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.FORMAT_SORTING, r14, 1, null) : z15;
            String string$default5 = (4194304 & i8) != 0 ? PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.SORTING_FIELDS, null, 1, null) : str4;
            int audioConvertFormat = (8388608 & i8) != 0 ? PreferenceUtil.INSTANCE.getAudioConvertFormat() : i5;
            int videoFormat = (i8 & 16777216) != 0 ? PreferenceUtil.INSTANCE.getVideoFormat() : i6;
            String string$default6 = "";
            String str15 = (i8 & 33554432) != 0 ? "" : str5;
            int videoResolution = (i8 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? PreferenceUtil.INSTANCE.getVideoResolution() : i7;
            boolean value9 = (i8 & 134217728) != 0 ? PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.PRIVATE_MODE) : z16;
            boolean value10 = (268435456 & i8) != 0 ? PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.RATE_LIMIT) : z17;
            String maxDownloadRate = (536870912 & i8) != 0 ? PreferenceUtil.INSTANCE.getMaxDownloadRate() : str6;
            boolean value11 = (i8 & BasicMeasure.EXACTLY) != 0 ? PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.PRIVATE_DIRECTORY) : z18;
            boolean value12 = (i8 & Integer.MIN_VALUE) != 0 ? PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.CROP_ARTWORK) : z19;
            boolean value13 = (i9 & 1) != 0 ? PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.SDCARD_DOWNLOAD) : z20;
            if ((i9 & 2) != 0) {
                obj = null;
                i11 = 1;
                string$default = PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.SDCARD_URI, null, 1, null);
            } else {
                obj = null;
                i11 = 1;
                string$default = str7;
            }
            boolean boolean$default10 = (i9 & 4) != 0 ? PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.EMBED_THUMBNAIL, false, i11, obj) : z21;
            List listEmptyList = (i9 & 8) != 0 ? CollectionsKt.emptyList() : list;
            boolean z38 = (i9 & 16) != 0 ? false : z22;
            if ((i9 & 32) != 0) {
                i12 = 1;
                str12 = null;
                z32 = false;
                boolean$default2 = PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.DEBUG, false, 1, null);
            } else {
                i12 = 1;
                str12 = null;
                z32 = false;
                boolean$default2 = z23;
            }
            boolean boolean$default11 = (i9 & 64) != 0 ? PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.PROXY, z32, i12, str12) : z24;
            String string$default7 = (i9 & 128) != 0 ? PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.PROXY_URL, str12, i12, str12) : str8;
            String str16 = (i9 & 256) != 0 ? "" : str9;
            if ((i9 & 512) != 0) {
                str13 = str16;
                z33 = boolean$default9;
                str14 = string$default7;
                z34 = boolean$default11;
                if (PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.USER_AGENT, false, 1, null)) {
                    string$default6 = PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.USER_AGENT_STRING, null, 1, null);
                }
            } else {
                str13 = str16;
                z33 = boolean$default9;
                str14 = string$default7;
                z34 = boolean$default11;
                string$default6 = str10;
            }
            if ((i9 & 1024) != 0) {
                obj2 = null;
                i13 = 1;
                string$default2 = PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.OUTPUT_TEMPLATE, null, 1, null);
            } else {
                obj2 = null;
                i13 = 1;
                string$default2 = str11;
            }
            if ((i9 & 2048) != 0) {
                z35 = false;
                boolean$default3 = PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.DOWNLOAD_ARCHIVE, false, i13, obj2);
            } else {
                z35 = false;
                boolean$default3 = z25;
            }
            boolean boolean$default12 = (i9 & 4096) != 0 ? PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.EMBED_METADATA, z35, i13, obj2) : z26;
            boolean boolean$default13 = (i9 & 8192) != 0 ? PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.RESTRICT_FILENAMES, z35, i13, obj2) : z27;
            boolean zCheckIfAv1HardwareAccelerated = (i9 & 16384) != 0 ? DownloadUtil.INSTANCE.checkIfAv1HardwareAccelerated() : z28;
            boolean boolean$default14 = (32768 & i9) != 0 ? PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.FORCE_IPV4, false, 1, null) : z29;
            boolean z39 = (i9 & 65536) != 0 ? false : z30;
            if ((i9 & 131072) != 0) {
                if (value5 && boolean$default5) {
                    z36 = z39;
                } else {
                    z36 = z39;
                    z37 = false;
                    if (PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.MERGE_OUTPUT_MKV, false, 1, null)) {
                    }
                }
                z37 = true;
            } else {
                z36 = z39;
                z37 = z31;
            }
            this(value, value2, value3, value4, boolean$default4, string$default3, value5, boolean$default5, boolean$default6, string$default4, value6, boolean$default, int$default2, int$default3, value7, sponsorBlockCategories, boolean$default7, value8, int$default, int$default4, boolean$default8, z33, string$default5, audioConvertFormat, videoFormat, str15, videoResolution, value9, value10, maxDownloadRate, value11, value12, value13, string$default, boolean$default10, listEmptyList, z38, boolean$default2, z34, str14, str13, string$default6, string$default2, boolean$default3, boolean$default12, boolean$default13, zCheckIfAv1HardwareAccelerated, boolean$default14, z36, z37);
        }

        public final boolean getExtractAudio() {
            return this.extractAudio;
        }

        public final boolean getCreateThumbnail() {
            return this.createThumbnail;
        }

        public final boolean getDownloadPlaylist() {
            return this.downloadPlaylist;
        }

        public final boolean getSubdirectoryExtractor() {
            return this.subdirectoryExtractor;
        }

        public final boolean getSubdirectoryPlaylistTitle() {
            return this.subdirectoryPlaylistTitle;
        }

        public final String getCommandDirectory() {
            return this.commandDirectory;
        }

        public final boolean getDownloadSubtitle() {
            return this.downloadSubtitle;
        }

        public final boolean getEmbedSubtitle() {
            return this.embedSubtitle;
        }

        public final boolean getKeepSubtitle() {
            return this.keepSubtitle;
        }

        public final String getSubtitleLanguage() {
            return this.subtitleLanguage;
        }

        public final boolean getAutoSubtitle() {
            return this.autoSubtitle;
        }

        public final boolean getAutoTranslatedSubtitles() {
            return this.autoTranslatedSubtitles;
        }

        public final int getConvertSubtitle() {
            return this.convertSubtitle;
        }

        public final int getConcurrentFragments() {
            return this.concurrentFragments;
        }

        public final boolean getSponsorBlock() {
            return this.sponsorBlock;
        }

        public final String getSponsorBlockCategory() {
            return this.sponsorBlockCategory;
        }

        public final boolean getCookies() {
            return this.cookies;
        }

        public final boolean getAria2c() {
            return this.aria2c;
        }

        public final int getAudioFormat() {
            return this.audioFormat;
        }

        public final int getAudioQuality() {
            return this.audioQuality;
        }

        public final boolean getConvertAudio() {
            return this.convertAudio;
        }

        public final boolean getFormatSorting() {
            return this.formatSorting;
        }

        public final String getSortingFields() {
            return this.sortingFields;
        }

        public final int getAudioConvertFormat() {
            return this.audioConvertFormat;
        }

        public final int getVideoFormat() {
            return this.videoFormat;
        }

        public final String getFormatIdString() {
            return this.formatIdString;
        }

        public final int getVideoResolution() {
            return this.videoResolution;
        }

        public final boolean getPrivateMode() {
            return this.privateMode;
        }

        public final boolean getRateLimit() {
            return this.rateLimit;
        }

        public final String getMaxDownloadRate() {
            return this.maxDownloadRate;
        }

        public final boolean getPrivateDirectory() {
            return this.privateDirectory;
        }

        public final boolean getCropArtwork() {
            return this.cropArtwork;
        }

        public final boolean getSdcard() {
            return this.sdcard;
        }

        public final String getSdcardUri() {
            return this.sdcardUri;
        }

        public final boolean getEmbedThumbnail() {
            return this.embedThumbnail;
        }

        public final List<VideoClip> getVideoClips() {
            return this.videoClips;
        }

        public final boolean getSplitByChapter() {
            return this.splitByChapter;
        }

        public final boolean getDebug() {
            return this.debug;
        }

        public final boolean getProxy() {
            return this.proxy;
        }

        public final String getProxyUrl() {
            return this.proxyUrl;
        }

        public final String getNewTitle() {
            return this.newTitle;
        }

        public final String getUserAgentString() {
            return this.userAgentString;
        }

        public final String getOutputTemplate() {
            return this.outputTemplate;
        }

        public final boolean getUseDownloadArchive() {
            return this.useDownloadArchive;
        }

        public final boolean getEmbedMetadata() {
            return this.embedMetadata;
        }

        public final boolean getRestrictFilenames() {
            return this.restrictFilenames;
        }

        public final boolean getSupportAv1HardwareDecoding() {
            return this.supportAv1HardwareDecoding;
        }

        public final boolean getForceIpv4() {
            return this.forceIpv4;
        }

        public final boolean getMergeAudioStream() {
            return this.mergeAudioStream;
        }

        public final boolean getMergeToMkv() {
            return this.mergeToMkv;
        }
    }

    private final YoutubeDLRequest enableCookies(YoutubeDLRequest $this$enableCookies, String userAgentString) {
        String absolutePath = FileUtil.INSTANCE.getCookiesFile(App.INSTANCE.getContext()).getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        YoutubeDLRequest $this$enableCookies_u24lambda_u247 = $this$enableCookies.addOption("--cookies", absolutePath);
        if (userAgentString.length() > 0) {
            $this$enableCookies_u24lambda_u247.addOption("--add-header", "User-Agent:" + userAgentString);
        }
        return $this$enableCookies_u24lambda_u247;
    }

    private final YoutubeDLRequest enableProxy(YoutubeDLRequest $this$enableProxy, String proxyUrl) {
        return $this$enableProxy.addOption("--proxy", proxyUrl);
    }

    private final YoutubeDLRequest useDownloadArchive(YoutubeDLRequest $this$useDownloadArchive) {
        String absolutePath = FileUtil.INSTANCE.getArchiveFile(App.INSTANCE.getContext()).getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return $this$useDownloadArchive.addOption("--download-archive", absolutePath);
    }

    /* JADX INFO: renamed from: getCookieListFromDatabase-d1pmJ48, reason: not valid java name */
    public final Object m7673getCookieListFromDatabased1pmJ48() {
        try {
            Result.Companion companion = Result.INSTANCE;
            DownloadUtil downloadUtil = this;
            CookieManager $this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u248 = CookieManager.getInstance();
            if (!$this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u248.hasCookies()) {
                throw new Exception("There is no cookies in the database!");
            }
            $this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u248.flush();
            SQLiteDatabase $this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u2410 = SQLiteDatabase.openDatabase("/data/data/" + App.INSTANCE.getContext().getPackageName() + "/app_webview/Default/Cookies", null, 1);
            String[] projection = {CookieScheme.HOST, CookieScheme.EXPIRY, CookieScheme.PATH, "name", CookieScheme.VALUE, CookieScheme.SECURE};
            List cookieList = new ArrayList();
            Cursor $this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u2410_u24lambda_u249 = $this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u2410.query(PreferenceUtilKt.COOKIES, projection, null, null, null, null, null);
            while ($this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.moveToNext()) {
                long expiry = $this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getLong($this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getColumnIndexOrThrow(CookieScheme.EXPIRY));
                String name = $this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getString($this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getColumnIndexOrThrow("name"));
                String value = $this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getString($this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getColumnIndexOrThrow(CookieScheme.VALUE));
                String path = $this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getString($this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getColumnIndexOrThrow(CookieScheme.PATH));
                boolean secure = $this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getLong($this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getColumnIndexOrThrow(CookieScheme.SECURE)) == 1;
                String hostKey = $this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getString($this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getColumnIndexOrThrow(CookieScheme.HOST));
                String host = hostKey.charAt(0) != '.' ? "." + hostKey : hostKey;
                Intrinsics.checkNotNull(host);
                Intrinsics.checkNotNull(name);
                Intrinsics.checkNotNull(value);
                Intrinsics.checkNotNull(path);
                cookieList.add(new Cookie(host, name, value, false, path, secure, expiry, 8, null));
            }
            $this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.close();
            $this$getCookieListFromDatabase_d1pmJ48_u24lambda_u2411_u24lambda_u2410.close();
            return Result.m7693constructorimpl(cookieList);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7693constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final String toCookiesFileContent(List<Cookie> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<Cookie> $this$fold$iv = list;
        StringBuilder sb = new StringBuilder(PreferenceUtil.COOKIE_HEADER);
        for (Object element$iv : $this$fold$iv) {
            Cookie cookie = (Cookie) element$iv;
            StringBuilder acc = sb;
            StringBuilder sbAppend = acc.append(cookie.toNetscapeCookieString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
            sb = sbAppend;
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: renamed from: getCookiesContentFromDatabase-d1pmJ48, reason: not valid java name */
    public final Object m7674getCookiesContentFromDatabased1pmJ48() {
        Object objM7673getCookieListFromDatabased1pmJ48 = m7673getCookieListFromDatabased1pmJ48();
        if (!Result.m7700isSuccessimpl(objM7673getCookieListFromDatabased1pmJ48)) {
            return Result.m7693constructorimpl(objM7673getCookieListFromDatabased1pmJ48);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m7693constructorimpl(INSTANCE.toCookiesFileContent((List) objM7673getCookieListFromDatabased1pmJ48));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7693constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final YoutubeDLRequest enableAria2c(YoutubeDLRequest $this$enableAria2c) {
        return $this$enableAria2c.addOption("--downloader", "libaria2c.so").addOption("--external-downloader-args", "aria2c:\"--summary-interval=1\"");
    }

    private final YoutubeDLRequest addOptionsForVideoDownloads(YoutubeDLRequest $this$addOptionsForVideoDownloads, DownloadPreferences downloadPreferences) {
        $this$addOptionsForVideoDownloads.addOption("--add-metadata");
        $this$addOptionsForVideoDownloads.addOption("--no-embed-info-json");
        if (downloadPreferences.getFormatIdString().length() > 0) {
            $this$addOptionsForVideoDownloads.addOption("-f", downloadPreferences.getFormatIdString());
            if (downloadPreferences.getMergeAudioStream()) {
                $this$addOptionsForVideoDownloads.addOption("--audio-multistreams");
            }
        } else {
            INSTANCE.applyFormatSorter($this$addOptionsForVideoDownloads, downloadPreferences, INSTANCE.toFormatSorter(downloadPreferences));
        }
        if (downloadPreferences.getDownloadSubtitle()) {
            if (downloadPreferences.getAutoSubtitle()) {
                $this$addOptionsForVideoDownloads.addOption("--write-auto-subs");
                if (!downloadPreferences.getAutoTranslatedSubtitles()) {
                    $this$addOptionsForVideoDownloads.addOption("--extractor-args", "youtube:skip=translated_subs");
                }
            }
            String it = downloadPreferences.getSubtitleLanguage();
            if (!(it.length() > 0)) {
                it = null;
            }
            if (it != null) {
                $this$addOptionsForVideoDownloads.addOption("--sub-langs", it);
            }
            if (downloadPreferences.getEmbedSubtitle()) {
                $this$addOptionsForVideoDownloads.addOption("--embed-subs");
                if (downloadPreferences.getKeepSubtitle()) {
                    $this$addOptionsForVideoDownloads.addOption("--write-subs");
                }
            } else {
                $this$addOptionsForVideoDownloads.addOption("--write-subs");
            }
            switch (downloadPreferences.getConvertSubtitle()) {
                case 1:
                    $this$addOptionsForVideoDownloads.addOption("--convert-subs", "ass");
                    break;
                case 2:
                    $this$addOptionsForVideoDownloads.addOption("--convert-subs", "lrc");
                    break;
                case 3:
                    $this$addOptionsForVideoDownloads.addOption("--convert-subs", "srt");
                    break;
                case 4:
                    $this$addOptionsForVideoDownloads.addOption("--convert-subs", "vtt");
                    break;
            }
        }
        if (downloadPreferences.getMergeToMkv()) {
            $this$addOptionsForVideoDownloads.addOption("--remux-video", "mkv");
            $this$addOptionsForVideoDownloads.addOption("--merge-output-format", "mkv");
        }
        if (downloadPreferences.getEmbedThumbnail()) {
            $this$addOptionsForVideoDownloads.addOption("--embed-thumbnail");
        }
        if (downloadPreferences.getVideoClips().isEmpty()) {
            $this$addOptionsForVideoDownloads.addOption("--embed-chapters");
        }
        return $this$addOptionsForVideoDownloads;
    }

    private final String toAudioFormatSorter(DownloadPreferences $this$toAudioFormatSorter) {
        String format;
        String quality = "";
        switch ($this$toAudioFormatSorter.getAudioFormat()) {
            case 1:
                format = "acodec:opus";
                break;
            case 2:
                format = "acodec:aac";
                break;
            default:
                format = "";
                break;
        }
        switch ($this$toAudioFormatSorter.getAudioQuality()) {
            case 1:
                quality = "abr~192";
                break;
            case 2:
                quality = "abr~128";
                break;
            case 3:
                quality = "abr~64";
                break;
        }
        return TextUtilKt.connectWithDelimiter(new String[]{format, quality}, ",");
    }

    private final String toVideoFormatSorter(DownloadPreferences $this$toVideoFormatSorter) {
        String format;
        String res = "";
        switch ($this$toVideoFormatSorter.getVideoFormat()) {
            case 1:
                format = "proto,vcodec:h264,ext";
                break;
            case 2:
                if ($this$toVideoFormatSorter.getSupportAv1HardwareDecoding()) {
                    format = "vcodec:av01";
                } else {
                    format = "vcodec:vp9.2";
                }
                break;
            default:
                format = "";
                break;
        }
        switch ($this$toVideoFormatSorter.getVideoResolution()) {
            case 1:
                res = "res:2160";
                break;
            case 2:
                res = "res:1440";
                break;
            case 3:
                res = "res:1080";
                break;
            case 4:
                res = "res:720";
                break;
            case 5:
                res = "res:480";
                break;
            case 6:
                res = "res:360";
                break;
            case 7:
                res = "+res";
                break;
        }
        return TextUtilKt.connectWithDelimiter(new String[]{format, res}, ",");
    }

    private final Object applyFormatSorter(YoutubeDLRequest $this$applyFormatSorter, DownloadPreferences preferences, String sorter) {
        if (preferences.getFormatSorting()) {
            if (preferences.getSortingFields().length() > 0) {
                return $this$applyFormatSorter.addOption("-S", preferences.getSortingFields());
            }
        }
        return sorter.length() > 0 ? $this$applyFormatSorter.addOption("-S", sorter) : Unit.INSTANCE;
    }

    public final String toFormatSorter(DownloadPreferences $this$toFormatSorter) {
        Intrinsics.checkNotNullParameter($this$toFormatSorter, "<this>");
        return TextUtilKt.connectWithDelimiter(new String[]{toVideoFormatSorter($this$toFormatSorter), toAudioFormatSorter($this$toFormatSorter)}, ",");
    }

    private final YoutubeDLRequest addOptionsForAudioDownloads(YoutubeDLRequest $this$addOptionsForAudioDownloads, String id, DownloadPreferences preferences, String playlistUrl) {
        $this$addOptionsForAudioDownloads.addOption("-x");
        if (preferences.getDownloadSubtitle()) {
            $this$addOptionsForAudioDownloads.addOption("--write-subs");
            if (preferences.getAutoSubtitle()) {
                $this$addOptionsForAudioDownloads.addOption("--write-auto-subs");
                if (!preferences.getAutoTranslatedSubtitles()) {
                    $this$addOptionsForAudioDownloads.addOption("--extractor-args", "youtube:skip=translated_subs");
                }
            }
            String it = preferences.getSubtitleLanguage();
            if (!(it.length() > 0)) {
                it = null;
            }
            if (it != null) {
                $this$addOptionsForAudioDownloads.addOption("--sub-langs", it);
            }
            switch (preferences.getConvertSubtitle()) {
                case 1:
                    $this$addOptionsForAudioDownloads.addOption("--convert-subs", "ass");
                    break;
                case 2:
                    $this$addOptionsForAudioDownloads.addOption("--convert-subs", "lrc");
                    break;
                case 3:
                    $this$addOptionsForAudioDownloads.addOption("--convert-subs", "srt");
                    break;
                case 4:
                    $this$addOptionsForAudioDownloads.addOption("--convert-subs", "vtt");
                    break;
            }
        }
        if (preferences.getFormatIdString().length() > 0) {
            $this$addOptionsForAudioDownloads.addOption("-f", preferences.getFormatIdString());
            if (preferences.getMergeAudioStream()) {
                $this$addOptionsForAudioDownloads.addOption("--audio-multistreams");
            }
        } else if (preferences.getConvertAudio()) {
            switch (preferences.getAudioConvertFormat()) {
                case 0:
                    $this$addOptionsForAudioDownloads.addOption("--audio-format", "mp3");
                    break;
                case 1:
                    $this$addOptionsForAudioDownloads.addOption("--audio-format", "m4a");
                    break;
            }
        } else {
            INSTANCE.applyFormatSorter($this$addOptionsForAudioDownloads, preferences, INSTANCE.toAudioFormatSorter(preferences));
        }
        if (preferences.getEmbedMetadata()) {
            $this$addOptionsForAudioDownloads.addOption("--embed-metadata");
            $this$addOptionsForAudioDownloads.addOption("--embed-thumbnail");
            $this$addOptionsForAudioDownloads.addOption("--convert-thumbnails", "jpg");
            if (preferences.getCropArtwork()) {
                File configFile = FileUtil.INSTANCE.getConfigFile(App.INSTANCE.getContext(), id);
                FileUtil.INSTANCE.writeContentToFile(CROP_ARTWORK_COMMAND, configFile);
                String absolutePath = configFile.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                $this$addOptionsForAudioDownloads.addOption("--config", absolutePath);
            }
        }
        $this$addOptionsForAudioDownloads.addOption("--parse-metadata", "%(release_year,upload_date)s:%(meta_date)s");
        if (playlistUrl.length() > 0) {
            $this$addOptionsForAudioDownloads.addOption("--parse-metadata", "%(album,playlist,title)s:%(meta_album)s");
            $this$addOptionsForAudioDownloads.addOption("--parse-metadata", "%(track_number,playlist_index)d:%(meta_track)s");
        } else {
            $this$addOptionsForAudioDownloads.addOption("--parse-metadata", "%(album,title)s:%(meta_album)s");
        }
        return $this$addOptionsForAudioDownloads;
    }

    private final List<String> insertInfoIntoDownloadHistory(VideoInfo videoInfo, List<String> filePaths) {
        List<String> $this$onEach$iv = filePaths;
        for (Object element$iv : $this$onEach$iv) {
            String it = (String) element$iv;
            DatabaseUtil.INSTANCE.insertInfo(toDownloadedVideoInfo$default(INSTANCE, videoInfo, 0, it, 1, null));
        }
        return $this$onEach$iv;
    }

    static /* synthetic */ DownloadedVideoInfo toDownloadedVideoInfo$default(DownloadUtil downloadUtil, VideoInfo videoInfo, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return downloadUtil.toDownloadedVideoInfo(videoInfo, i, str);
    }

    private final DownloadedVideoInfo toDownloadedVideoInfo(VideoInfo $this$toDownloadedVideoInfo, int id, String videoPath) {
        String title = $this$toDownloadedVideoInfo.getTitle();
        String uploader = $this$toDownloadedVideoInfo.getUploader();
        if (uploader == null && (uploader = $this$toDownloadedVideoInfo.getChannel()) == null) {
            uploader = String.valueOf($this$toDownloadedVideoInfo.getUploaderId());
        }
        String str = uploader;
        String webpageUrl = $this$toDownloadedVideoInfo.getWebpageUrl();
        if (webpageUrl == null) {
            webpageUrl = String.valueOf($this$toDownloadedVideoInfo.getOriginalUrl());
        }
        return new DownloadedVideoInfo(id, title, str, webpageUrl, TextUtilKt.toHttpsUrl($this$toDownloadedVideoInfo.getThumbnail()), videoPath, $this$toDownloadedVideoInfo.getExtractorKey());
    }

    private final List<String> insertSplitChapterIntoHistory(VideoInfo videoInfo, List<String> filePaths) {
        List<String> $this$onEach$iv = filePaths;
        for (Object element$iv : $this$onEach$iv) {
            String it = (String) element$iv;
            DatabaseUtil.INSTANCE.insertInfo(DownloadedVideoInfo.copy$default(toDownloadedVideoInfo$default(INSTANCE, videoInfo, 0, it, 1, null), 0, FileUtil.INSTANCE.getFileName(it), null, null, null, null, null, 125, null));
        }
        return $this$onEach$iv;
    }

    /* JADX INFO: renamed from: downloadVideo-hUnOzRk$default, reason: not valid java name */
    public static /* synthetic */ Object m7666downloadVideohUnOzRk$default(DownloadUtil downloadUtil, VideoInfo videoInfo, String str, int i, String str2, DownloadPreferences downloadPreferences, Function3 function3, int i2, Object obj) {
        return downloadUtil.m7671downloadVideohUnOzRk((i2 & 1) != 0 ? null : videoInfo, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 0 : i, str2, downloadPreferences, function3);
    }

    /* JADX INFO: renamed from: downloadVideo-hUnOzRk, reason: not valid java name */
    public final Object m7671downloadVideohUnOzRk(VideoInfo videoInfo, String playlistUrl, int playlistItem, String taskId, DownloadPreferences downloadPreferences, Function3<? super Float, ? super Long, ? super String, Unit> progressCallback) {
        String output;
        Object objM7693constructorimpl;
        boolean z;
        Intrinsics.checkNotNullParameter(playlistUrl, "playlistUrl");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(downloadPreferences, "downloadPreferences");
        if (videoInfo == null) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m7693constructorimpl(ResultKt.createFailure(new Throwable(App.INSTANCE.getContext().getString(C3070R.string.fetch_info_error_msg))));
        }
        String str = playlistUrl;
        if (str.length() == 0) {
            String originalUrl = videoInfo.getOriginalUrl();
            if (originalUrl == null && (originalUrl = videoInfo.getWebpageUrl()) == null) {
                Result.Companion companion2 = Result.INSTANCE;
                return Result.m7693constructorimpl(ResultKt.createFailure(new Throwable(App.INSTANCE.getContext().getString(C3070R.string.fetch_info_error_msg))));
            }
            str = originalUrl;
        }
        String url = str;
        YoutubeDLRequest request = new YoutubeDLRequest(url);
        StringBuilder pathBuilder = new StringBuilder();
        StringBuilder outputBuilder = new StringBuilder();
        request.addOption("--no-mtime");
        if (downloadPreferences.getCookies()) {
            INSTANCE.enableCookies(request, downloadPreferences.getUserAgentString());
        }
        if (downloadPreferences.getRestrictFilenames()) {
            request.addOption("--restrict-filenames");
        }
        if (downloadPreferences.getProxy()) {
            INSTANCE.enableProxy(request, downloadPreferences.getProxyUrl());
        }
        if (downloadPreferences.getForceIpv4()) {
            request.addOption("-4");
        }
        if (downloadPreferences.getDebug()) {
            request.addOption("-v");
        }
        if (downloadPreferences.getUseDownloadArchive()) {
            File archiveFile = FileUtil.INSTANCE.getArchiveFile(App.INSTANCE.getContext());
            String archiveFileContent = FilesKt.readText$default(archiveFile, null, 1, null);
            if (!StringsKt.contains$default((CharSequence) archiveFileContent, (CharSequence) (videoInfo.getExtractor() + " " + videoInfo.getId()), false, 2, (Object) null)) {
                INSTANCE.useDownloadArchive(request);
            } else {
                Result.Companion companion3 = Result.INSTANCE;
                return Result.m7693constructorimpl(ResultKt.createFailure(new YoutubeDLException(App.INSTANCE.getContext().getString(C3070R.string.download_archive_error))));
            }
        }
        if (downloadPreferences.getRateLimit() && TextUtilKt.isNumberInRange(downloadPreferences.getMaxDownloadRate(), 1, DurationKt.NANOS_IN_MILLIS)) {
            request.addOption("-r", downloadPreferences.getMaxDownloadRate() + "K");
        }
        if (playlistItem == 0 || !downloadPreferences.getDownloadPlaylist()) {
            request.addOption("--no-playlist");
        } else {
            request.addOption("--playlist-items", Integer.valueOf(playlistItem));
            if (downloadPreferences.getSubdirectoryPlaylistTitle()) {
                String playlist = videoInfo.getPlaylist();
                if (!(playlist == null || playlist.length() == 0)) {
                    outputBuilder.append(PLAYLIST_TITLE_SUBDIRECTORY_PREFIX);
                }
            }
        }
        if (downloadPreferences.getAria2c()) {
            INSTANCE.enableAria2c(request);
        } else if (downloadPreferences.getConcurrentFragments() > 1) {
            request.addOption("--concurrent-fragments", Integer.valueOf(downloadPreferences.getConcurrentFragments()));
        }
        if (downloadPreferences.getExtractAudio() || Intrinsics.areEqual(videoInfo.getVcodec(), "none")) {
            if (downloadPreferences.getPrivateDirectory()) {
                pathBuilder.append(App.INSTANCE.getPrivateDownloadDir());
            } else {
                pathBuilder.append(App.INSTANCE.getAudioDownloadDir());
            }
            INSTANCE.addOptionsForAudioDownloads(request, videoInfo.getId(), downloadPreferences, playlistUrl);
        } else {
            if (downloadPreferences.getPrivateDirectory()) {
                pathBuilder.append(App.INSTANCE.getPrivateDownloadDir());
            } else {
                pathBuilder.append(App.INSTANCE.getVideoDownloadDir());
            }
            INSTANCE.addOptionsForVideoDownloads(request, downloadPreferences);
        }
        if (downloadPreferences.getSponsorBlock()) {
            request.addOption("--sponsorblock-remove", downloadPreferences.getSponsorBlockCategory());
        }
        if (downloadPreferences.getCreateThumbnail()) {
            request.addOption("--write-thumbnail");
            request.addOption("--convert-thumbnails", "png");
        }
        if (downloadPreferences.getSubdirectoryExtractor()) {
            pathBuilder.append("/" + videoInfo.getExtractorKey());
        }
        if (downloadPreferences.getSdcard()) {
            String absolutePath = FileUtil.INSTANCE.getSdcardTempDir(App.INSTANCE.getContext(), videoInfo.getId()).getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            request.addOption("-P", absolutePath);
        } else {
            String string = pathBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            request.addOption("-P", string);
        }
        Iterable $this$forEach$iv = downloadPreferences.getVideoClips();
        for (Object element$iv : $this$forEach$iv) {
            VideoClip it = (VideoClip) element$iv;
            String str2 = String.format(Locale.US, "*%d-%d", Arrays.copyOf(new Object[]{Integer.valueOf(it.getStart()), Integer.valueOf(it.getEnd())}, 2));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            request.addOption("--download-sections", str2);
            $this$forEach$iv = $this$forEach$iv;
        }
        if (downloadPreferences.getNewTitle().length() > 0) {
            request.addCommands(CollectionsKt.listOf((Object[]) new String[]{"--replace-in-metadata", "title", ".+", downloadPreferences.getNewTitle()}));
        }
        if (Build.VERSION.SDK_INT > 23 && !downloadPreferences.getSdcard()) {
            request.addOption("-P", "temp:" + FileUtil.INSTANCE.getExternalTempDir());
        }
        if (downloadPreferences.getSplitByChapter()) {
            request.addOption("-o", OUTPUT_TEMPLATE_CHAPTERS);
            request.addOption("--split-chapters");
        }
        if (downloadPreferences.getSplitByChapter()) {
            output = OUTPUT_TEMPLATE_SPLIT;
        } else if (downloadPreferences.getVideoClips().isEmpty()) {
            output = downloadPreferences.getOutputTemplate();
        } else {
            output = OUTPUT_TEMPLATE_CLIPS;
        }
        String string2 = outputBuilder.append(output).toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        request.addOption("-o", string2);
        for (String s : request.buildCommand()) {
            Log.d(TAG, s);
        }
        try {
            Result.Companion companion4 = Result.INSTANCE;
            try {
                objM7693constructorimpl = Result.m7693constructorimpl(YoutubeDL.getInstance().execute(request, taskId, progressCallback));
            } catch (Throwable th) {
                th = th;
                Result.Companion companion5 = Result.INSTANCE;
                objM7693constructorimpl = Result.m7693constructorimpl(ResultKt.createFailure(th));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        Throwable th3 = Result.m7696exceptionOrNullimpl(objM7693constructorimpl);
        if (th3 != null) {
            if (downloadPreferences.getSponsorBlock()) {
                String message = th3.getMessage();
                if (message != null) {
                    z = false;
                    if (StringsKt.contains$default((CharSequence) message, (CharSequence) "Unable to communicate with SponsorBlock API", false, 2, (Object) null)) {
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (z) {
                    th3.printStackTrace();
                    DownloadUtil downloadUtil = INSTANCE;
                    String string3 = pathBuilder.toString();
                    Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                    return downloadUtil.m7670onFinishDownloadingBWLJW6A(downloadPreferences, videoInfo, string3, downloadPreferences.getSdcardUri());
                }
            }
            Result.Companion companion6 = Result.INSTANCE;
            return Result.m7693constructorimpl(ResultKt.createFailure(th3));
        }
        DownloadUtil downloadUtil2 = INSTANCE;
        String string4 = pathBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
        return downloadUtil2.m7670onFinishDownloadingBWLJW6A(downloadPreferences, videoInfo, string4, downloadPreferences.getSdcardUri());
    }

    /* JADX INFO: renamed from: onFinishDownloading-BWLJW6A, reason: not valid java name */
    private final Object m7670onFinishDownloadingBWLJW6A(DownloadPreferences preferences, VideoInfo videoInfo, String downloadPath, String sdcardUri) {
        List<String> listInsertInfoIntoDownloadHistory;
        Object objM7693constructorimpl;
        RequestedDownload requestedDownload;
        String newTitle = preferences.getNewTitle();
        if (newTitle.length() == 0) {
            String filename = videoInfo.getFilename();
            if (filename == null) {
                List<RequestedDownload> requestedDownloads = videoInfo.getRequestedDownloads();
                filename = (requestedDownloads == null || (requestedDownload = (RequestedDownload) CollectionsKt.firstOrNull((List) requestedDownloads)) == null) ? null : requestedDownload.getFilename();
                if (filename == null) {
                    filename = videoInfo.getTitle();
                }
            }
            newTitle = filename;
        }
        String fileName = newTitle;
        Log.d(TAG, "onFinishDownloading: " + fileName);
        if (preferences.getSdcard()) {
            Object objM7678moveFilesToSdcardgIAlus = FileUtil.INSTANCE.m7678moveFilesToSdcardgIAlus(FileUtil.INSTANCE.getSdcardTempDir(App.INSTANCE.getContext(), videoInfo.getId()), sdcardUri);
            if (Result.m7700isSuccessimpl(objM7678moveFilesToSdcardgIAlus)) {
                List<String> list = (List) objM7678moveFilesToSdcardgIAlus;
                if (preferences.getPrivateMode()) {
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m7693constructorimpl(CollectionsKt.emptyList());
                }
                if (preferences.getSplitByChapter()) {
                    INSTANCE.insertSplitChapterIntoHistory(videoInfo, list);
                    return objM7678moveFilesToSdcardgIAlus;
                }
                INSTANCE.insertInfoIntoDownloadHistory(videoInfo, list);
                return objM7678moveFilesToSdcardgIAlus;
            }
            return objM7678moveFilesToSdcardgIAlus;
        }
        List<String> listScanFileToMediaLibraryPostDownload = FileUtil.INSTANCE.scanFileToMediaLibraryPostDownload(fileName, downloadPath);
        if (preferences.getPrivateMode()) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7693constructorimpl = Result.m7693constructorimpl(CollectionsKt.emptyList());
        } else {
            Result.Companion companion3 = Result.INSTANCE;
            if (preferences.getSplitByChapter()) {
                listInsertInfoIntoDownloadHistory = INSTANCE.insertSplitChapterIntoHistory(videoInfo, listScanFileToMediaLibraryPostDownload);
            } else {
                listInsertInfoIntoDownloadHistory = INSTANCE.insertInfoIntoDownloadHistory(videoInfo, listScanFileToMediaLibraryPostDownload);
            }
            objM7693constructorimpl = Result.m7693constructorimpl(listInsertInfoIntoDownloadHistory);
        }
        return objM7693constructorimpl;
    }

    public static /* synthetic */ Object executeCommandInBackground$default(DownloadUtil downloadUtil, String str, CommandTemplate commandTemplate, DownloadPreferences downloadPreferences, Continuation continuation, int i, Object obj) throws InterruptedException {
        CommandTemplate template;
        DownloadPreferences downloadPreferences2;
        if ((i & 2) == 0) {
            template = commandTemplate;
        } else {
            template = PreferenceUtil.INSTANCE.getTemplate();
        }
        if ((i & 4) == 0) {
            downloadPreferences2 = downloadPreferences;
        } else {
            downloadPreferences2 = new DownloadPreferences(false, false, false, false, false, null, false, false, false, null, false, false, 0, 0, false, null, false, false, 0, 0, false, false, null, 0, 0, null, 0, false, false, null, false, false, false, null, false, null, false, false, false, null, null, null, null, false, false, false, false, false, false, false, -1, LayoutUtilsKt.BigConstraintValue, null);
        }
        return downloadUtil.executeCommandInBackground(str, template, downloadPreferences2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object executeCommandInBackground(String url, CommandTemplate template, DownloadPreferences downloadPreferences, Continuation<? super Unit> continuation) {
        C40431 c40431;
        final String taskId;
        boolean z;
        final int notificationId;
        final CommandTemplate template2;
        final String url2;
        YoutubeDLRequest request;
        Object objM7693constructorimpl;
        if (continuation instanceof C40431) {
            c40431 = (C40431) continuation;
            if ((c40431.label & Integer.MIN_VALUE) != 0) {
                c40431.label -= Integer.MIN_VALUE;
            } else {
                c40431 = new C40431(continuation);
            }
        } else {
            c40431 = new C40431(continuation);
        }
        Object $result = c40431.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c40431.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                taskId = Downloader.INSTANCE.makeKey(url, template.getName());
                int notificationId2 = Downloader.INSTANCE.toNotificationId(taskId);
                Iterable $this$filterTo$iv$iv = new Regex("[\n ]").split(url, 0);
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filterTo$iv$iv) {
                    if (!StringsKt.isBlank((String) element$iv$iv)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                List urlList = (List) destination$iv$iv;
                ToastUtil toastUtil = ToastUtil.INSTANCE;
                String string = App.INSTANCE.getContext().getString(C3070R.string.start_execute);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                toastUtil.makeToastSuspend(string);
                YoutubeDLRequest $this$executeCommandInBackground_u24lambda_u2445_u24lambda_u2441 = new YoutubeDLRequest((List<String>) urlList);
                String it = downloadPreferences.getCommandDirectory();
                if (!(it.length() > 0)) {
                    it = null;
                }
                if (it != null) {
                    $this$executeCommandInBackground_u24lambda_u2445_u24lambda_u2441.addOption("-P", it);
                }
                $this$executeCommandInBackground_u24lambda_u2445_u24lambda_u2441.addOption("--newline");
                if (downloadPreferences.getAria2c()) {
                    INSTANCE.enableAria2c($this$executeCommandInBackground_u24lambda_u2445_u24lambda_u2441);
                }
                if (downloadPreferences.getUseDownloadArchive()) {
                    INSTANCE.useDownloadArchive($this$executeCommandInBackground_u24lambda_u2445_u24lambda_u2441);
                }
                if (downloadPreferences.getRestrictFilenames()) {
                    $this$executeCommandInBackground_u24lambda_u2445_u24lambda_u2441.addOption("--restrict-filenames");
                }
                String absolutePath = FileUtil.INSTANCE.writeContentToFile(template.getTemplate(), FileUtil.getConfigFile$default(FileUtil.INSTANCE, App.INSTANCE.getContext(), null, 1, null)).getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                $this$executeCommandInBackground_u24lambda_u2445_u24lambda_u2441.addOption("--config-locations", absolutePath);
                if (downloadPreferences.getCookies()) {
                    INSTANCE.enableCookies($this$executeCommandInBackground_u24lambda_u2445_u24lambda_u2441, downloadPreferences.getUserAgentString());
                }
                Downloader.INSTANCE.onProcessStarted();
                MainCoroutineDispatcher main = Dispatchers.getMain();
                DownloadUtil$executeCommandInBackground$2$1 downloadUtil$executeCommandInBackground$2$1 = new DownloadUtil$executeCommandInBackground$2$1(template, url, null);
                c40431.L$0 = url;
                c40431.L$1 = template;
                c40431.L$2 = downloadPreferences;
                c40431.L$3 = taskId;
                c40431.L$4 = $this$executeCommandInBackground_u24lambda_u2445_u24lambda_u2441;
                c40431.I$0 = notificationId2;
                z = true;
                c40431.label = 1;
                if (BuildersKt.withContext(main, downloadUtil$executeCommandInBackground$2$1, c40431) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                notificationId = notificationId2;
                template2 = template;
                url2 = url;
                request = $this$executeCommandInBackground_u24lambda_u2445_u24lambda_u2441;
                break;
                break;
            case 1:
                notificationId = c40431.I$0;
                request = (YoutubeDLRequest) c40431.L$4;
                taskId = (String) c40431.L$3;
                CommandTemplate template3 = (CommandTemplate) c40431.L$1;
                String url3 = (String) c40431.L$0;
                ResultKt.throwOnFailure($result);
                template2 = template3;
                url2 = url3;
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            YoutubeDLResponse response = YoutubeDL.getInstance().execute(request, taskId, new Function3<Float, Long, String, Unit>() { // from class: com.videshkarmakar.loop.util.DownloadUtil$executeCommandInBackground$2$2$response$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Float f, Long l, String str) {
                    invoke(f.floatValue(), l.longValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(float progress, long j, String text) {
                    Intrinsics.checkNotNullParameter(text, "text");
                    String name = template2.getName();
                    NotificationUtil.INSTANCE.makeNotificationForCustomCommand(notificationId, taskId, (int) progress, text, name, url2);
                    Downloader.INSTANCE.updateTaskOutput(template2, url2, text, progress);
                }
            });
            Downloader.INSTANCE.onTaskEnded(template2, url2, response.getOut() + IOUtils.LINE_SEPARATOR_UNIX + response.getErr());
            objM7693constructorimpl = Result.m7693constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7693constructorimpl = Result.m7693constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it2 = Result.m7696exceptionOrNullimpl(objM7693constructorimpl);
        if (it2 != null) {
            it2.printStackTrace();
            if (!(it2 instanceof YoutubeDL.CanceledException)) {
                String $this$executeCommandInBackground_u24lambda_u2445_u24lambda_u2444_u24lambda_u2443 = it2.getMessage();
                String str = $this$executeCommandInBackground_u24lambda_u2445_u24lambda_u2444_u24lambda_u2443;
                if (str != null && str.length() != 0) {
                    z = false;
                }
                if (z) {
                    Downloader.onTaskEnded$default(Downloader.INSTANCE, template2, url2, null, 4, null);
                } else {
                    Downloader.INSTANCE.onTaskError($this$executeCommandInBackground_u24lambda_u2445_u24lambda_u2444_u24lambda_u2443, template2, url2);
                }
            }
        }
        Downloader.INSTANCE.onProcessEnded();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkIfAv1HardwareAccelerated() {
        boolean z;
        boolean z2 = true;
        if (PreferenceUtil.INSTANCE.containsKey(PreferenceUtilKt.AV1_HARDWARE_ACCELERATED)) {
            return PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.AV1_HARDWARE_ACCELERATED, false, 1, null);
        }
        if (Build.VERSION.SDK_INT < 29) {
            z2 = false;
        } else {
            Object[] codecInfos = new MediaCodecList(0).getCodecInfos();
            Intrinsics.checkNotNullExpressionValue(codecInfos, "getCodecInfos(...)");
            Object[] $this$any$iv = codecInfos;
            for (Object element$iv : $this$any$iv) {
                MediaCodecInfo info = (MediaCodecInfo) element$iv;
                Object[] supportedTypes = info.getSupportedTypes();
                Intrinsics.checkNotNullExpressionValue(supportedTypes, "getSupportedTypes(...)");
                Object[] $this$any$iv2 = supportedTypes;
                int length = $this$any$iv2.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        Object element$iv2 = $this$any$iv2[i];
                        String it = (String) element$iv2;
                        if (StringsKt.equals(it, "video/av01", true)) {
                            z = true;
                            break;
                        }
                        i++;
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!(z && info.isHardwareAccelerated())) {
                }
            }
            z2 = false;
        }
        boolean res = z2;
        PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.AV1_HARDWARE_ACCELERATED, res);
        return res;
    }
}
