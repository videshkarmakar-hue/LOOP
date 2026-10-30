package com.videshkarmakar.loop;

import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import androidx.compose.foundation.text.modifiers.LayoutUtilsKt;
import androidx.compose.p001ui.platform.ClipboardManager;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.text.AnnotatedString;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.videshkarmakar.loop.database.objects.CommandTemplate;
import com.videshkarmakar.loop.p006ui.common.Route;
import com.videshkarmakar.loop.util.DownloadUtil;
import com.videshkarmakar.loop.util.Entries;
import com.videshkarmakar.loop.util.FileUtil;
import com.videshkarmakar.loop.util.Format;
import com.videshkarmakar.loop.util.NotificationUtil;
import com.videshkarmakar.loop.util.PlaylistResult;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import com.videshkarmakar.loop.util.TextUtilKt;
import com.videshkarmakar.loop.util.ToastUtil;
import com.videshkarmakar.loop.util.VideoClip;
import com.videshkarmakar.loop.util.VideoInfo;
import com.yausername.youtubedl_android.YoutubeDL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.apache.commons.p013io.IOUtils;

/* JADX INFO: compiled from: Downloader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m194d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004nopqB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\u0010\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-H\u0002J\u0018\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0004H\u0002JH\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\b2\b\b\u0002\u00102\u001a\u00020\u00192\b\b\u0002\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000207H\u0083@ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109J6\u0010:\u001a\u00020)2\u0006\u0010/\u001a\u00020\u00042\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00190\t2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\t2\b\b\u0002\u00106\u001a\u000207JH\u0010>\u001a\u00020)2\u0006\u00104\u001a\u0002052\f\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\t2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\t2\u0006\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00020\u00042\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040\tJ\u000e\u0010F\u001a\u00020)2\u0006\u0010G\u001a\u000205J\u000e\u0010H\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0004J\u0018\u0010I\u001a\u00020)2\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0004H\u0002J\b\u0010J\u001a\u00020)H\u0002J\u0018\u0010K\u001a\u00020)2\u0006\u0010/\u001a\u00020\u00042\b\b\u0002\u0010L\u001a\u000207J\u0006\u0010M\u001a\u00020-J\u0016\u0010N\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u0004JG\u0010P\u001a\u00020)2\u0006\u0010Q\u001a\u00020R2\b\u0010/\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00042\u0006\u0010T\u001a\u00020-2\b\b\u0002\u0010U\u001a\u00020-2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010WJ\u0010\u0010X\u001a\u0004\u0018\u00010\u001d2\u0006\u0010Y\u001a\u00020\u0004J\u0006\u0010Z\u001a\u00020)J\u0006\u0010[\u001a\u00020)J\"\u0010\\\u001a\u00020)2\u0006\u0010]\u001a\u00020^2\u0006\u0010/\u001a\u00020\u00042\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0004J\u001e\u0010`\u001a\u00020)2\u0006\u00100\u001a\u00020\u00042\u0006\u0010]\u001a\u00020^2\u0006\u0010/\u001a\u00020\u0004J\u0018\u0010a\u001a\u0004\u0018\u00010\u001d2\u0006\u0010]\u001a\u00020^2\u0006\u0010/\u001a\u00020\u0004J\u0006\u0010b\u001a\u00020)J\u0018\u0010c\u001a\u00020)2\u0006\u0010/\u001a\u00020\u00042\b\b\u0002\u0010L\u001a\u000207J\u0010\u0010d\u001a\u00020)2\b\b\u0002\u0010\"\u001a\u00020\u0017J\u000e\u0010e\u001a\u00020)2\u0006\u0010f\u001a\u00020\rJ&\u0010g\u001a\u00020)2\u0006\u0010]\u001a\u00020^2\u0006\u0010/\u001a\u00020\u00042\u0006\u0010h\u001a\u00020\u00042\u0006\u0010i\u001a\u00020jJ\n\u0010k\u001a\u00020\u0019*\u00020\u0004J\u001e\u0010l\u001a\u00020!*\u0002052\b\b\u0002\u00102\u001a\u00020\u00192\u0006\u0010m\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000fR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u000fR\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020!0\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006r"}, m195d2 = {"Lcom/videshkarmakar/loop/Downloader;", "", "()V", "TAG", "", "currentJob", "Lkotlinx/coroutines/Job;", "downloadResultTemp", "Lkotlin/Result;", "", "Ljava/lang/Object;", "downloaderState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/videshkarmakar/loop/Downloader$State;", "getDownloaderState", "()Lkotlinx/coroutines/flow/StateFlow;", "errorState", "Lcom/videshkarmakar/loop/Downloader$ErrorState;", "getErrorState", "mutableDownloaderState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "mutableErrorState", "mutablePlaylistResult", "Lcom/videshkarmakar/loop/util/PlaylistResult;", "mutableProcessCount", "", "mutableQuickDownloadCount", "mutableTaskList", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Lcom/videshkarmakar/loop/Downloader$CustomCommandTask;", "getMutableTaskList", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "mutableTaskState", "Lcom/videshkarmakar/loop/Downloader$DownloadTaskItem;", "playlistResult", "getPlaylistResult", "processCount", "getProcessCount", "taskState", "getTaskState", "cancelDownload", "", "clearErrorState", "clearProgressState", "isFinished", "", "downloadError", "url", "errorReport", "downloadVideo", "playlistIndex", "playlistUrl", "videoInfo", "Lcom/videshkarmakar/loop/util/VideoInfo;", "preferences", "Lcom/videshkarmakar/loop/util/DownloadUtil$DownloadPreferences;", "downloadVideo-yxL6bBk", "(ILjava/lang/String;Lcom/videshkarmakar/loop/util/VideoInfo;Lcom/videshkarmakar/loop/util/DownloadUtil$DownloadPreferences;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadVideoInPlaylistByIndexList", "indexList", "playlistItemList", "Lcom/videshkarmakar/loop/util/Entries;", "downloadVideoWithConfigurations", "formatList", "Lcom/videshkarmakar/loop/util/Format;", "videoClips", "Lcom/videshkarmakar/loop/util/VideoClip;", "splitByChapter", "newTitle", "selectedSubtitleCodes", "downloadVideoWithInfo", "info", "executeCommandWithUrl", "fetchInfoError", "finishProcessing", "getInfoAndDownload", "downloadPreferences", "isDownloaderAvailable", "makeKey", "templateName", "manageDownloadError", "th", "", "title", "isFetchingInfo", "isTaskAborted", "notificationId", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Integer;)V", "onProcessCanceled", "taskId", "onProcessEnded", "onProcessStarted", "onTaskEnded", Route.TEMPLATE, "Lcom/videshkarmakar/loop/database/objects/CommandTemplate;", "response", "onTaskError", "onTaskStarted", "openDownloadResult", "quickDownload", "updatePlaylistResult", "updateState", "state", "updateTaskOutput", "line", NotificationCompat.CATEGORY_PROGRESS, "", "toNotificationId", "toTask", "preferencesHash", "CustomCommandTask", "DownloadTaskItem", "ErrorState", "State", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Downloader {
    public static final int $stable;
    public static final Downloader INSTANCE = new Downloader();
    private static final String TAG = "Downloader";
    private static Job currentJob;
    private static Object downloadResultTemp;
    private static final StateFlow<State> downloaderState;
    private static final StateFlow<ErrorState> errorState;
    private static final MutableStateFlow<State> mutableDownloaderState;
    private static final MutableStateFlow<ErrorState> mutableErrorState;
    private static final MutableStateFlow<PlaylistResult> mutablePlaylistResult;
    private static final MutableStateFlow<Integer> mutableProcessCount;
    private static final MutableStateFlow<Integer> mutableQuickDownloadCount;
    private static final SnapshotStateMap<String, CustomCommandTask> mutableTaskList;
    private static final MutableStateFlow<DownloadTaskItem> mutableTaskState;
    private static final StateFlow<PlaylistResult> playlistResult;
    private static final StateFlow<Integer> processCount;
    private static final StateFlow<DownloadTaskItem> taskState;

    private Downloader() {
    }

    /* JADX INFO: compiled from: Downloader.kt */
    @Metadata(m194d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, m195d2 = {"Lcom/videshkarmakar/loop/Downloader$State;", "", "()V", "DownloadingPlaylist", "DownloadingVideo", "FetchingInfo", "Idle", "Updating", "Lcom/videshkarmakar/loop/Downloader$State$DownloadingPlaylist;", "Lcom/videshkarmakar/loop/Downloader$State$DownloadingVideo;", "Lcom/videshkarmakar/loop/Downloader$State$FetchingInfo;", "Lcom/videshkarmakar/loop/Downloader$State$Idle;", "Lcom/videshkarmakar/loop/Downloader$State$Updating;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static abstract class State {
        public static final int $stable = 0;

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: Downloader.kt */
        @Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m195d2 = {"Lcom/videshkarmakar/loop/Downloader$State$DownloadingPlaylist;", "Lcom/videshkarmakar/loop/Downloader$State;", "currentItem", "", "itemCount", "(II)V", "getCurrentItem", "()I", "getItemCount", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final /* data */ class DownloadingPlaylist extends State {
            public static final int $stable = 0;
            private final int currentItem;
            private final int itemCount;

            /* JADX WARN: Illegal instructions before constructor call */
            public DownloadingPlaylist() {
                int i = 0;
                this(i, i, 3, null);
            }

            public static /* synthetic */ DownloadingPlaylist copy$default(DownloadingPlaylist downloadingPlaylist, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = downloadingPlaylist.currentItem;
                }
                if ((i3 & 2) != 0) {
                    i2 = downloadingPlaylist.itemCount;
                }
                return downloadingPlaylist.copy(i, i2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getCurrentItem() {
                return this.currentItem;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getItemCount() {
                return this.itemCount;
            }

            public final DownloadingPlaylist copy(int currentItem, int itemCount) {
                return new DownloadingPlaylist(currentItem, itemCount);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DownloadingPlaylist)) {
                    return false;
                }
                DownloadingPlaylist downloadingPlaylist = (DownloadingPlaylist) other;
                return this.currentItem == downloadingPlaylist.currentItem && this.itemCount == downloadingPlaylist.itemCount;
            }

            public int hashCode() {
                return (this.currentItem * 31) + this.itemCount;
            }

            public String toString() {
                return "DownloadingPlaylist(currentItem=" + this.currentItem + ", itemCount=" + this.itemCount + ")";
            }

            public /* synthetic */ DownloadingPlaylist(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
            }

            public final int getCurrentItem() {
                return this.currentItem;
            }

            public final int getItemCount() {
                return this.itemCount;
            }

            public DownloadingPlaylist(int currentItem, int itemCount) {
                super(null);
                this.currentItem = currentItem;
                this.itemCount = itemCount;
            }
        }

        private State() {
        }

        /* JADX INFO: compiled from: Downloader.kt */
        @Metadata(m194d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m195d2 = {"Lcom/videshkarmakar/loop/Downloader$State$DownloadingVideo;", "Lcom/videshkarmakar/loop/Downloader$State;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final /* data */ class DownloadingVideo extends State {
            public static final int $stable = 0;
            public static final DownloadingVideo INSTANCE = new DownloadingVideo();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DownloadingVideo)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 349589849;
            }

            public String toString() {
                return "DownloadingVideo";
            }

            private DownloadingVideo() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: Downloader.kt */
        @Metadata(m194d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m195d2 = {"Lcom/videshkarmakar/loop/Downloader$State$FetchingInfo;", "Lcom/videshkarmakar/loop/Downloader$State;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final /* data */ class FetchingInfo extends State {
            public static final int $stable = 0;
            public static final FetchingInfo INSTANCE = new FetchingInfo();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FetchingInfo)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -48548146;
            }

            public String toString() {
                return "FetchingInfo";
            }

            private FetchingInfo() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: Downloader.kt */
        @Metadata(m194d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m195d2 = {"Lcom/videshkarmakar/loop/Downloader$State$Idle;", "Lcom/videshkarmakar/loop/Downloader$State;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final /* data */ class Idle extends State {
            public static final int $stable = 0;
            public static final Idle INSTANCE = new Idle();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Idle)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -80704788;
            }

            public String toString() {
                return "Idle";
            }

            private Idle() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: Downloader.kt */
        @Metadata(m194d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m195d2 = {"Lcom/videshkarmakar/loop/Downloader$State$Updating;", "Lcom/videshkarmakar/loop/Downloader$State;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final /* data */ class Updating extends State {
            public static final int $stable = 0;
            public static final Updating INSTANCE = new Updating();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Updating)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -729201058;
            }

            public String toString() {
                return "Updating";
            }

            private Updating() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: Downloader.kt */
    @Metadata(m194d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\f\r\u000eB\u001b\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007\u0082\u0001\u0003\u000f\u0010\u0011¨\u0006\u0012"}, m195d2 = {"Lcom/videshkarmakar/loop/Downloader$ErrorState;", "", "url", "", "report", "(Ljava/lang/String;Ljava/lang/String;)V", "getReport", "()Ljava/lang/String;", "title", "getTitle", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "getUrl", "DownloadError", "FetchInfoError", "None", "Lcom/videshkarmakar/loop/Downloader$ErrorState$DownloadError;", "Lcom/videshkarmakar/loop/Downloader$ErrorState$FetchInfoError;", "Lcom/videshkarmakar/loop/Downloader$ErrorState$None;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static abstract class ErrorState {
        public static final int $stable = 0;
        private final String report;
        private final String url;

        public /* synthetic */ ErrorState(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        private ErrorState(String url, String report) {
            this.url = url;
            this.report = report;
        }

        public /* synthetic */ ErrorState(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, null);
        }

        public String getUrl() {
            return this.url;
        }

        public String getReport() {
            return this.report;
        }

        /* JADX INFO: compiled from: Downloader.kt */
        @Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m195d2 = {"Lcom/videshkarmakar/loop/Downloader$ErrorState$DownloadError;", "Lcom/videshkarmakar/loop/Downloader$ErrorState;", "url", "", "report", "(Ljava/lang/String;Ljava/lang/String;)V", "getReport", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final /* data */ class DownloadError extends ErrorState {
            public static final int $stable = 0;
            private final String report;
            private final String url;

            public static /* synthetic */ DownloadError copy$default(DownloadError downloadError, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = downloadError.url;
                }
                if ((i & 2) != 0) {
                    str2 = downloadError.report;
                }
                return downloadError.copy(str, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getReport() {
                return this.report;
            }

            public final DownloadError copy(String url, String report) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(report, "report");
                return new DownloadError(url, report);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DownloadError)) {
                    return false;
                }
                DownloadError downloadError = (DownloadError) other;
                return Intrinsics.areEqual(this.url, downloadError.url) && Intrinsics.areEqual(this.report, downloadError.report);
            }

            public int hashCode() {
                return (this.url.hashCode() * 31) + this.report.hashCode();
            }

            public String toString() {
                return "DownloadError(url=" + this.url + ", report=" + this.report + ")";
            }

            @Override // com.videshkarmakar.loop.Downloader.ErrorState
            public String getReport() {
                return this.report;
            }

            @Override // com.videshkarmakar.loop.Downloader.ErrorState
            public String getUrl() {
                return this.url;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DownloadError(String url, String report) {
                super(url, report, null);
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(report, "report");
                this.url = url;
                this.report = report;
            }
        }

        /* JADX INFO: compiled from: Downloader.kt */
        @Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m195d2 = {"Lcom/videshkarmakar/loop/Downloader$ErrorState$FetchInfoError;", "Lcom/videshkarmakar/loop/Downloader$ErrorState;", "url", "", "report", "(Ljava/lang/String;Ljava/lang/String;)V", "getReport", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final /* data */ class FetchInfoError extends ErrorState {
            public static final int $stable = 0;
            private final String report;
            private final String url;

            public static /* synthetic */ FetchInfoError copy$default(FetchInfoError fetchInfoError, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = fetchInfoError.url;
                }
                if ((i & 2) != 0) {
                    str2 = fetchInfoError.report;
                }
                return fetchInfoError.copy(str, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getReport() {
                return this.report;
            }

            public final FetchInfoError copy(String url, String report) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(report, "report");
                return new FetchInfoError(url, report);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FetchInfoError)) {
                    return false;
                }
                FetchInfoError fetchInfoError = (FetchInfoError) other;
                return Intrinsics.areEqual(this.url, fetchInfoError.url) && Intrinsics.areEqual(this.report, fetchInfoError.report);
            }

            public int hashCode() {
                return (this.url.hashCode() * 31) + this.report.hashCode();
            }

            public String toString() {
                return "FetchInfoError(url=" + this.url + ", report=" + this.report + ")";
            }

            @Override // com.videshkarmakar.loop.Downloader.ErrorState
            public String getReport() {
                return this.report;
            }

            @Override // com.videshkarmakar.loop.Downloader.ErrorState
            public String getUrl() {
                return this.url;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FetchInfoError(String url, String report) {
                super(url, report, null);
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(report, "report");
                this.url = url;
                this.report = report;
            }
        }

        /* JADX INFO: compiled from: Downloader.kt */
        @Metadata(m194d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m195d2 = {"Lcom/videshkarmakar/loop/Downloader$ErrorState$None;", "Lcom/videshkarmakar/loop/Downloader$ErrorState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final /* data */ class None extends ErrorState {
            public static final int $stable = 0;
            public static final None INSTANCE = new None();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof None)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -859702302;
            }

            public String toString() {
                return "None";
            }

            /* JADX WARN: Multi-variable type inference failed */
            private None() {
                super(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            }
        }

        public final String getTitle(Composer $composer, int $changed) {
            String strStringResource;
            $composer.startReplaceGroup(553403557);
            ComposerKt.sourceInformation($composer, "C:Downloader.kt#rrbzdc");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(553403557, $changed, -1, "com.videshkarmakar.loop.Downloader.ErrorState.<get-title> (Downloader.kt:71)");
            }
            if (this instanceof DownloadError) {
                $composer.startReplaceGroup(1433742257);
                ComposerKt.sourceInformation($composer, "72@2688L48");
                strStringResource = StringResources_androidKt.stringResource(C3070R.string.download_error_msg, $composer, 0);
                $composer.endReplaceGroup();
            } else if (this instanceof FetchInfoError) {
                $composer.startReplaceGroup(1433742343);
                ComposerKt.sourceInformation($composer, "73@2774L50");
                strStringResource = StringResources_androidKt.stringResource(C3070R.string.fetch_info_error_msg, $composer, 0);
                $composer.endReplaceGroup();
            } else {
                if (!Intrinsics.areEqual(this, None.INSTANCE)) {
                    $composer.startReplaceGroup(1433739568);
                    $composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                $composer.startReplaceGroup(1496341998);
                $composer.endReplaceGroup();
                strStringResource = "";
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return strStringResource;
        }
    }

    /* JADX INFO: compiled from: Downloader.kt */
    @Metadata(m194d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001:\u0001'B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"J\u0006\u0010$\u001a\u00020\u001fJ\u0006\u0010%\u001a\u00020\u0005J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006("}, m195d2 = {"Lcom/videshkarmakar/loop/Downloader$CustomCommandTask;", "", Route.TEMPLATE, "Lcom/videshkarmakar/loop/database/objects/CommandTemplate;", "url", "", "output", "state", "Lcom/videshkarmakar/loop/Downloader$CustomCommandTask$State;", "currentLine", "(Lcom/videshkarmakar/loop/database/objects/CommandTemplate;Ljava/lang/String;Ljava/lang/String;Lcom/videshkarmakar/loop/Downloader$CustomCommandTask$State;Ljava/lang/String;)V", "getCurrentLine", "()Ljava/lang/String;", "getOutput", "getState", "()Lcom/videshkarmakar/loop/Downloader$CustomCommandTask$State;", "getTemplate", "()Lcom/videshkarmakar/loop/database/objects/CommandTemplate;", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "onCancel", "", "onCopyError", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "onCopyLog", "onRestart", "toKey", "toString", "State", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class CustomCommandTask {
        public static final int $stable = 0;
        private final String currentLine;
        private final String output;
        private final State state;
        private final CommandTemplate template;
        private final String url;

        public static /* synthetic */ CustomCommandTask copy$default(CustomCommandTask customCommandTask, CommandTemplate commandTemplate, String str, String str2, State state, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                commandTemplate = customCommandTask.template;
            }
            if ((i & 2) != 0) {
                str = customCommandTask.url;
            }
            String str4 = str;
            if ((i & 4) != 0) {
                str2 = customCommandTask.output;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                state = customCommandTask.state;
            }
            State state2 = state;
            if ((i & 16) != 0) {
                str3 = customCommandTask.currentLine;
            }
            return customCommandTask.copy(commandTemplate, str4, str5, state2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CommandTemplate getTemplate() {
            return this.template;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getOutput() {
            return this.output;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final State getState() {
            return this.state;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getCurrentLine() {
            return this.currentLine;
        }

        public final CustomCommandTask copy(CommandTemplate template, String url, String output, State state, String currentLine) {
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(currentLine, "currentLine");
            return new CustomCommandTask(template, url, output, state, currentLine);
        }

        public String toString() {
            return "CustomCommandTask(template=" + this.template + ", url=" + this.url + ", output=" + this.output + ", state=" + this.state + ", currentLine=" + this.currentLine + ")";
        }

        public CustomCommandTask(CommandTemplate template, String url, String output, State state, String currentLine) {
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(currentLine, "currentLine");
            this.template = template;
            this.url = url;
            this.output = output;
            this.state = state;
            this.currentLine = currentLine;
        }

        public final CommandTemplate getTemplate() {
            return this.template;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getOutput() {
            return this.output;
        }

        public final State getState() {
            return this.state;
        }

        public final String getCurrentLine() {
            return this.currentLine;
        }

        /* JADX INFO: compiled from: Downloader.kt */
        @Metadata(m194d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, m195d2 = {"Lcom/videshkarmakar/loop/Downloader$CustomCommandTask$State;", "", "()V", "Canceled", "Completed", "Error", "Running", "Lcom/videshkarmakar/loop/Downloader$CustomCommandTask$State$Canceled;", "Lcom/videshkarmakar/loop/Downloader$CustomCommandTask$State$Completed;", "Lcom/videshkarmakar/loop/Downloader$CustomCommandTask$State$Error;", "Lcom/videshkarmakar/loop/Downloader$CustomCommandTask$State$Running;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static abstract class State {
            public static final int $stable = 0;

            public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: compiled from: Downloader.kt */
            @Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m195d2 = {"Lcom/videshkarmakar/loop/Downloader$CustomCommandTask$State$Error;", "Lcom/videshkarmakar/loop/Downloader$CustomCommandTask$State;", "errorReport", "", "(Ljava/lang/String;)V", "getErrorReport", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public static final /* data */ class Error extends State {
                public static final int $stable = 0;
                private final String errorReport;

                public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = error.errorReport;
                    }
                    return error.copy(str);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final String getErrorReport() {
                    return this.errorReport;
                }

                public final Error copy(String errorReport) {
                    Intrinsics.checkNotNullParameter(errorReport, "errorReport");
                    return new Error(errorReport);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof Error) && Intrinsics.areEqual(this.errorReport, ((Error) other).errorReport);
                }

                public int hashCode() {
                    return this.errorReport.hashCode();
                }

                public String toString() {
                    return "Error(errorReport=" + this.errorReport + ")";
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Error(String errorReport) {
                    super(null);
                    Intrinsics.checkNotNullParameter(errorReport, "errorReport");
                    this.errorReport = errorReport;
                }

                public final String getErrorReport() {
                    return this.errorReport;
                }
            }

            private State() {
            }

            /* JADX INFO: compiled from: Downloader.kt */
            @Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m195d2 = {"Lcom/videshkarmakar/loop/Downloader$CustomCommandTask$State$Completed;", "Lcom/videshkarmakar/loop/Downloader$CustomCommandTask$State;", "()V", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public static final class Completed extends State {
                public static final int $stable = 0;
                public static final Completed INSTANCE = new Completed();

                private Completed() {
                    super(null);
                }
            }

            /* JADX INFO: compiled from: Downloader.kt */
            @Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m195d2 = {"Lcom/videshkarmakar/loop/Downloader$CustomCommandTask$State$Canceled;", "Lcom/videshkarmakar/loop/Downloader$CustomCommandTask$State;", "()V", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public static final class Canceled extends State {
                public static final int $stable = 0;
                public static final Canceled INSTANCE = new Canceled();

                private Canceled() {
                    super(null);
                }
            }

            /* JADX INFO: compiled from: Downloader.kt */
            @Metadata(m194d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m195d2 = {"Lcom/videshkarmakar/loop/Downloader$CustomCommandTask$State$Running;", "Lcom/videshkarmakar/loop/Downloader$CustomCommandTask$State;", NotificationCompat.CATEGORY_PROGRESS, "", "(F)V", "getProgress", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public static final /* data */ class Running extends State {
                public static final int $stable = 0;
                private final float progress;

                public static /* synthetic */ Running copy$default(Running running, float f, int i, Object obj) {
                    if ((i & 1) != 0) {
                        f = running.progress;
                    }
                    return running.copy(f);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final float getProgress() {
                    return this.progress;
                }

                public final Running copy(float progress) {
                    return new Running(progress);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof Running) && Float.compare(this.progress, ((Running) other).progress) == 0;
                }

                public int hashCode() {
                    return Float.floatToIntBits(this.progress);
                }

                public String toString() {
                    return "Running(progress=" + this.progress + ")";
                }

                public Running(float progress) {
                    super(null);
                    this.progress = progress;
                }

                public final float getProgress() {
                    return this.progress;
                }
            }
        }

        public final String toKey() {
            return Downloader.INSTANCE.makeKey(this.url, this.template.getName());
        }

        public int hashCode() {
            return (this.url + this.template.getName() + this.template.getTemplate()).hashCode();
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.videshkarmakar.loop.Downloader.CustomCommandTask");
            return Intrinsics.areEqual(this.template, ((CustomCommandTask) other).template) && Intrinsics.areEqual(this.url, ((CustomCommandTask) other).url) && Intrinsics.areEqual(this.output, ((CustomCommandTask) other).output) && Intrinsics.areEqual(this.state, ((CustomCommandTask) other).state) && Intrinsics.areEqual(this.currentLine, ((CustomCommandTask) other).currentLine);
        }

        public final void onCopyLog(ClipboardManager clipboardManager) {
            Intrinsics.checkNotNullParameter(clipboardManager, "clipboardManager");
            clipboardManager.setText(new AnnotatedString(this.output, null, null, 6, null));
        }

        public final void onRestart() {
            BuildersKt__Builders_commonKt.launch$default(App.INSTANCE.getApplicationScope(), Dispatchers.getIO(), null, new Downloader$CustomCommandTask$onRestart$1(this, null), 2, null);
        }

        public final void onCopyError(ClipboardManager clipboardManager) {
            Intrinsics.checkNotNullParameter(clipboardManager, "clipboardManager");
            clipboardManager.setText(new AnnotatedString(this.currentLine, null, null, 6, null));
            ToastUtil.INSTANCE.makeToast(C3070R.string.error_copied);
        }

        public final void onCancel() {
            String $this$onCancel_u24lambda_u240 = toKey();
            YoutubeDL.INSTANCE.destroyProcessById($this$onCancel_u24lambda_u240);
            Downloader.INSTANCE.onProcessCanceled($this$onCancel_u24lambda_u240);
        }
    }

    /* JADX INFO: compiled from: Downloader.kt */
    @Metadata(m194d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003Jm\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0007HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019¨\u0006/"}, m195d2 = {"Lcom/videshkarmakar/loop/Downloader$DownloadTaskItem;", "", "webpageUrl", "", "title", "uploader", "duration", "", "fileSizeApprox", "", NotificationCompat.CATEGORY_PROGRESS, "", "progressText", "thumbnailUrl", "taskId", "playlistIndex", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getDuration", "()I", "getFileSizeApprox", "()D", "getPlaylistIndex", "getProgress", "()F", "getProgressText", "()Ljava/lang/String;", "getTaskId", "getThumbnailUrl", "getTitle", "getUploader", "getWebpageUrl", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class DownloadTaskItem {
        public static final int $stable = 0;
        private final int duration;
        private final double fileSizeApprox;
        private final int playlistIndex;
        private final float progress;
        private final String progressText;
        private final String taskId;
        private final String thumbnailUrl;
        private final String title;
        private final String uploader;
        private final String webpageUrl;

        public DownloadTaskItem() {
            this(null, null, null, 0, 0.0d, 0.0f, null, null, null, 0, 1023, null);
        }

        public static /* synthetic */ DownloadTaskItem copy$default(DownloadTaskItem downloadTaskItem, String str, String str2, String str3, int i, double d, float f, String str4, String str5, String str6, int i2, int i3, Object obj) {
            return downloadTaskItem.copy((i3 & 1) != 0 ? downloadTaskItem.webpageUrl : str, (i3 & 2) != 0 ? downloadTaskItem.title : str2, (i3 & 4) != 0 ? downloadTaskItem.uploader : str3, (i3 & 8) != 0 ? downloadTaskItem.duration : i, (i3 & 16) != 0 ? downloadTaskItem.fileSizeApprox : d, (i3 & 32) != 0 ? downloadTaskItem.progress : f, (i3 & 64) != 0 ? downloadTaskItem.progressText : str4, (i3 & 128) != 0 ? downloadTaskItem.thumbnailUrl : str5, (i3 & 256) != 0 ? downloadTaskItem.taskId : str6, (i3 & 512) != 0 ? downloadTaskItem.playlistIndex : i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getWebpageUrl() {
            return this.webpageUrl;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final int getPlaylistIndex() {
            return this.playlistIndex;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getUploader() {
            return this.uploader;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getDuration() {
            return this.duration;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final double getFileSizeApprox() {
            return this.fileSizeApprox;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final float getProgress() {
            return this.progress;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getProgressText() {
            return this.progressText;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getThumbnailUrl() {
            return this.thumbnailUrl;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        public final DownloadTaskItem copy(String webpageUrl, String title, String uploader, int duration, double fileSizeApprox, float progress, String progressText, String thumbnailUrl, String taskId, int playlistIndex) {
            Intrinsics.checkNotNullParameter(webpageUrl, "webpageUrl");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(uploader, "uploader");
            Intrinsics.checkNotNullParameter(progressText, "progressText");
            Intrinsics.checkNotNullParameter(thumbnailUrl, "thumbnailUrl");
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            return new DownloadTaskItem(webpageUrl, title, uploader, duration, fileSizeApprox, progress, progressText, thumbnailUrl, taskId, playlistIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DownloadTaskItem)) {
                return false;
            }
            DownloadTaskItem downloadTaskItem = (DownloadTaskItem) other;
            return Intrinsics.areEqual(this.webpageUrl, downloadTaskItem.webpageUrl) && Intrinsics.areEqual(this.title, downloadTaskItem.title) && Intrinsics.areEqual(this.uploader, downloadTaskItem.uploader) && this.duration == downloadTaskItem.duration && Double.compare(this.fileSizeApprox, downloadTaskItem.fileSizeApprox) == 0 && Float.compare(this.progress, downloadTaskItem.progress) == 0 && Intrinsics.areEqual(this.progressText, downloadTaskItem.progressText) && Intrinsics.areEqual(this.thumbnailUrl, downloadTaskItem.thumbnailUrl) && Intrinsics.areEqual(this.taskId, downloadTaskItem.taskId) && this.playlistIndex == downloadTaskItem.playlistIndex;
        }

        public int hashCode() {
            return (((((((((((((((((this.webpageUrl.hashCode() * 31) + this.title.hashCode()) * 31) + this.uploader.hashCode()) * 31) + this.duration) * 31) + Downloader$DownloadTaskItem$$ExternalSyntheticBackport0.m181m(this.fileSizeApprox)) * 31) + Float.floatToIntBits(this.progress)) * 31) + this.progressText.hashCode()) * 31) + this.thumbnailUrl.hashCode()) * 31) + this.taskId.hashCode()) * 31) + this.playlistIndex;
        }

        public String toString() {
            return "DownloadTaskItem(webpageUrl=" + this.webpageUrl + ", title=" + this.title + ", uploader=" + this.uploader + ", duration=" + this.duration + ", fileSizeApprox=" + this.fileSizeApprox + ", progress=" + this.progress + ", progressText=" + this.progressText + ", thumbnailUrl=" + this.thumbnailUrl + ", taskId=" + this.taskId + ", playlistIndex=" + this.playlistIndex + ")";
        }

        public DownloadTaskItem(String webpageUrl, String title, String uploader, int duration, double fileSizeApprox, float progress, String progressText, String thumbnailUrl, String taskId, int playlistIndex) {
            Intrinsics.checkNotNullParameter(webpageUrl, "webpageUrl");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(uploader, "uploader");
            Intrinsics.checkNotNullParameter(progressText, "progressText");
            Intrinsics.checkNotNullParameter(thumbnailUrl, "thumbnailUrl");
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            this.webpageUrl = webpageUrl;
            this.title = title;
            this.uploader = uploader;
            this.duration = duration;
            this.fileSizeApprox = fileSizeApprox;
            this.progress = progress;
            this.progressText = progressText;
            this.thumbnailUrl = thumbnailUrl;
            this.taskId = taskId;
            this.playlistIndex = playlistIndex;
        }

        public /* synthetic */ DownloadTaskItem(String str, String str2, String str3, int i, double d, float f, String str4, String str5, String str6, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0.0d : d, (i3 & 32) != 0 ? 0.0f : f, (i3 & 64) != 0 ? "" : str4, (i3 & 128) != 0 ? "" : str5, (i3 & 256) == 0 ? str6 : "", (i3 & 512) == 0 ? i2 : 0);
        }

        public final String getWebpageUrl() {
            return this.webpageUrl;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUploader() {
            return this.uploader;
        }

        public final int getDuration() {
            return this.duration;
        }

        public final double getFileSizeApprox() {
            return this.fileSizeApprox;
        }

        public final float getProgress() {
            return this.progress;
        }

        public final String getProgressText() {
            return this.progressText;
        }

        public final String getThumbnailUrl() {
            return this.thumbnailUrl;
        }

        public final String getTaskId() {
            return this.taskId;
        }

        public final int getPlaylistIndex() {
            return this.playlistIndex;
        }
    }

    static {
        Result.Companion companion = Result.INSTANCE;
        downloadResultTemp = Result.m7693constructorimpl(ResultKt.createFailure(new Exception()));
        mutableDownloaderState = StateFlowKt.MutableStateFlow(State.Idle.INSTANCE);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        mutableTaskState = StateFlowKt.MutableStateFlow(new DownloadTaskItem(str, str2, str3, 0, 0.0d, 0.0f, str4, str5, str6, 0, 1023, null));
        mutablePlaylistResult = StateFlowKt.MutableStateFlow(new PlaylistResult(str, str2, str3, (String) null, (String) null, (String) null, (List) null, str4, str5, str6, 1023, (DefaultConstructorMarker) null));
        mutableErrorState = StateFlowKt.MutableStateFlow(ErrorState.None.INSTANCE);
        mutableProcessCount = StateFlowKt.MutableStateFlow(0);
        mutableQuickDownloadCount = StateFlowKt.MutableStateFlow(0);
        mutableTaskList = SnapshotStateKt.mutableStateMapOf();
        taskState = FlowKt.asStateFlow(mutableTaskState);
        downloaderState = FlowKt.asStateFlow(mutableDownloaderState);
        playlistResult = FlowKt.asStateFlow(mutablePlaylistResult);
        errorState = FlowKt.asStateFlow(mutableErrorState);
        processCount = FlowKt.asStateFlow(mutableProcessCount);
        BuildersKt__Builders_commonKt.launch$default(App.INSTANCE.getApplicationScope(), null, null, new C30551(null), 3, null);
        $stable = 8;
    }

    public final SnapshotStateMap<String, CustomCommandTask> getMutableTaskList() {
        return mutableTaskList;
    }

    public final StateFlow<DownloadTaskItem> getTaskState() {
        return taskState;
    }

    public final StateFlow<State> getDownloaderState() {
        return downloaderState;
    }

    public final StateFlow<PlaylistResult> getPlaylistResult() {
        return playlistResult;
    }

    public final StateFlow<ErrorState> getErrorState() {
        return errorState;
    }

    public final StateFlow<Integer> getProcessCount() {
        return processCount;
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.Downloader$1 */
    /* JADX INFO: compiled from: Downloader.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.Downloader$1", m210f = "Downloader.kt", m211i = {}, m212l = {182}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C30551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C30551(Continuation<? super C30551> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C30551(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C30551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.videshkarmakar.loop.Downloader$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: Downloader.kt */
        @Metadata(m194d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, m195d2 = {"<anonymous>", "", "state", "Lcom/videshkarmakar/loop/Downloader$State;", "cnt", ""}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "com.videshkarmakar.loop.Downloader$1$1", m210f = "Downloader.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function3<State, Integer, Continuation<? super Boolean>, Object> {
            /* synthetic */ int I$0;
            /* synthetic */ Object L$0;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(3, continuation);
            }

            public final Object invoke(State state, int i, Continuation<? super Boolean> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.L$0 = state;
                anonymousClass1.I$0 = i;
                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(State state, Integer num, Continuation<? super Boolean> continuation) {
                return invoke(state, num.intValue(), continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        State state = (State) this.L$0;
                        int cnt = this.I$0;
                        boolean z = true;
                        if (cnt <= 0 && (state instanceof State.Idle)) {
                            z = false;
                        }
                        return Boxing.boxBoolean(z);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (FlowKt.flowCombine(FlowKt.flowCombine(Downloader.INSTANCE.getDownloaderState(), Downloader.INSTANCE.getProcessCount(), new AnonymousClass1(null)), Downloader.mutableQuickDownloadCount, new AnonymousClass2(null)).collect(new FlowCollector() { // from class: com.videshkarmakar.loop.Downloader.1.3
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit(((Boolean) value).booleanValue(), (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(boolean it, Continuation<? super Unit> continuation) {
                            if (it) {
                                App.INSTANCE.startService();
                            } else {
                                App.INSTANCE.stopService();
                            }
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.videshkarmakar.loop.Downloader$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: Downloader.kt */
        @Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m195d2 = {"<anonymous>", "", "isRunning", "cnt", ""}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "com.videshkarmakar.loop.Downloader$1$2", m210f = "Downloader.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function3<Boolean, Integer, Continuation<? super Boolean>, Object> {
            /* synthetic */ int I$0;
            /* synthetic */ boolean Z$0;
            int label;

            AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Integer num, Continuation<? super Boolean> continuation) {
                return invoke(bool.booleanValue(), num.intValue(), continuation);
            }

            public final Object invoke(boolean z, int i, Continuation<? super Boolean> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
                anonymousClass2.Z$0 = z;
                anonymousClass2.I$0 = i;
                return anonymousClass2.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        boolean isRunning = this.Z$0;
                        int cnt = this.I$0;
                        boolean z = true;
                        if (!isRunning && cnt <= 0) {
                            z = false;
                        }
                        return Boxing.boxBoolean(z);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    public final boolean isDownloaderAvailable() {
        if (!(downloaderState.getValue() instanceof State.Idle)) {
            ToastUtil toastUtil = ToastUtil.INSTANCE;
            String string = App.INSTANCE.getContext().getString(C3070R.string.task_running);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            toastUtil.makeToastSuspend(string);
            return false;
        }
        return true;
    }

    public final String makeKey(String url, String templateName) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(templateName, "templateName");
        return templateName + "_" + url;
    }

    public final CustomCommandTask onTaskStarted(CommandTemplate template, String url) {
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(url, "url");
        CustomCommandTask $this$onTaskStarted_u24lambda_u240 = new CustomCommandTask(template, url, "", new CustomCommandTask.State.Running(0.0f), "");
        return mutableTaskList.put($this$onTaskStarted_u24lambda_u240.toKey(), $this$onTaskStarted_u24lambda_u240);
    }

    public final void updateTaskOutput(CommandTemplate template, String url, String line, float progress) {
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(line, "line");
        String key = makeKey(url, template.getName());
        CustomCommandTask oldValue = mutableTaskList.get(key);
        if (oldValue == null) {
            return;
        }
        CustomCommandTask $this$updateTaskOutput_u24lambda_u241 = CustomCommandTask.copy$default(oldValue, null, null, oldValue.getOutput() + line + IOUtils.LINE_SEPARATOR_UNIX, new CustomCommandTask.State.Running(progress), line, 3, null);
        mutableTaskList.put(key, $this$updateTaskOutput_u24lambda_u241);
    }

    public static /* synthetic */ void onTaskEnded$default(Downloader downloader, CommandTemplate commandTemplate, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        downloader.onTaskEnded(commandTemplate, str, str2);
    }

    public final void onTaskEnded(CommandTemplate template, String url, String response) {
        CustomCommandTask customCommandTaskCopy$default;
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(url, "url");
        String key = makeKey(url, template.getName());
        NotificationUtil.finishNotification$default(NotificationUtil.INSTANCE, toNotificationId(key), key, App.INSTANCE.getContext().getString(C3070R.string.status_completed), null, 8, null);
        SnapshotStateMap<String, CustomCommandTask> snapshotStateMap = mutableTaskList;
        CustomCommandTask oldValue = snapshotStateMap.get(key);
        if (oldValue == null) {
            return;
        }
        CustomCommandTask $this$onTaskEnded_u24lambda_u244_u24lambda_u243 = CustomCommandTask.copy$default(oldValue, null, null, null, CustomCommandTask.State.Completed.INSTANCE, null, 23, null);
        if (response != null && (customCommandTaskCopy$default = CustomCommandTask.copy$default($this$onTaskEnded_u24lambda_u244_u24lambda_u243, null, null, response, null, null, 27, null)) != null) {
            $this$onTaskEnded_u24lambda_u244_u24lambda_u243 = customCommandTaskCopy$default;
        }
        snapshotStateMap.put(key, $this$onTaskEnded_u24lambda_u244_u24lambda_u243);
        FileUtil.INSTANCE.scanDownloadDirectoryToMediaLibrary(PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.COMMAND_DIRECTORY, null, 1, null));
    }

    public final void onProcessEnded() {
        Integer value;
        int it;
        MutableStateFlow<Integer> mutableStateFlow = mutableProcessCount;
        do {
            value = mutableStateFlow.getValue();
            it = value.intValue();
        } while (!mutableStateFlow.compareAndSet(value, Integer.valueOf(it - 1)));
    }

    public final CustomCommandTask onProcessCanceled(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        SnapshotStateMap<String, CustomCommandTask> snapshotStateMap = mutableTaskList;
        CustomCommandTask it = snapshotStateMap.get(taskId);
        if (it != null) {
            return snapshotStateMap.put(taskId, CustomCommandTask.copy$default(it, null, null, null, CustomCommandTask.State.Canceled.INSTANCE, null, 23, null));
        }
        return null;
    }

    public final void onTaskError(String errorReport, CommandTemplate template, String url) {
        Intrinsics.checkNotNullParameter(errorReport, "errorReport");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(url, "url");
        SnapshotStateMap<String, CustomCommandTask> snapshotStateMap = mutableTaskList;
        String key = INSTANCE.makeKey(url, template.getName());
        NotificationUtil.makeErrorReportNotification$default(NotificationUtil.INSTANCE, null, INSTANCE.toNotificationId(key), errorReport, 1, null);
        CustomCommandTask oldValue = mutableTaskList.get(key);
        if (oldValue == null) {
            return;
        }
        mutableTaskList.put(key, CustomCommandTask.copy$default(oldValue, null, null, oldValue.getOutput() + IOUtils.LINE_SEPARATOR_UNIX + errorReport, new CustomCommandTask.State.Error(errorReport), errorReport, 3, null));
    }

    static /* synthetic */ DownloadTaskItem toTask$default(Downloader downloader, VideoInfo videoInfo, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        return downloader.toTask(videoInfo, i, i2);
    }

    private final DownloadTaskItem toTask(VideoInfo $this$toTask, int playlistIndex, int preferencesHash) {
        String strValueOf = String.valueOf($this$toTask.getWebpageUrl());
        String title = $this$toTask.getTitle();
        String uploader = $this$toTask.getUploader();
        if (uploader == null && (uploader = $this$toTask.getChannel()) == null) {
            uploader = String.valueOf($this$toTask.getUploaderId());
        }
        String str = uploader;
        Double duration = $this$toTask.getDuration();
        int iRoundToInt = duration != null ? MathKt.roundToInt(duration.doubleValue()) : 0;
        String str2 = $this$toTask.getId() + preferencesHash;
        String httpsUrl = TextUtilKt.toHttpsUrl($this$toTask.getThumbnail());
        Double fileSize = $this$toTask.getFileSize();
        return new DownloadTaskItem(strValueOf, title, str, iRoundToInt, (fileSize == null && (fileSize = $this$toTask.getFileSizeApprox()) == null) ? 0.0d : fileSize.doubleValue(), 0.0f, null, httpsUrl, str2, playlistIndex, 96, null);
    }

    public final void updateState(State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        MutableStateFlow<State> mutableStateFlow = mutableDownloaderState;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), state)) {
        }
    }

    public final void clearErrorState() {
        MutableStateFlow<ErrorState> mutableStateFlow = mutableErrorState;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), ErrorState.None.INSTANCE)) {
        }
    }

    private final void fetchInfoError(String url, String errorReport) {
        MutableStateFlow<ErrorState> mutableStateFlow = mutableErrorState;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), new ErrorState.FetchInfoError(url, errorReport))) {
        }
    }

    private final void downloadError(String url, String errorReport) {
        MutableStateFlow<ErrorState> mutableStateFlow = mutableErrorState;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), new ErrorState.DownloadError(url, errorReport))) {
        }
    }

    private final void clearProgressState(boolean isFinished) {
        DownloadTaskItem value;
        DownloadTaskItem it;
        MutableStateFlow<DownloadTaskItem> mutableStateFlow = mutableTaskState;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, DownloadTaskItem.copy$default(it, null, null, null, 0, 0.0d, isFinished ? 100.0f : 0.0f, "", null, null, 0, 927, null)));
        if (!isFinished) {
            Result.Companion companion = Result.INSTANCE;
            downloadResultTemp = Result.m7693constructorimpl(ResultKt.createFailure(new Exception()));
        }
    }

    public static /* synthetic */ void updatePlaylistResult$default(Downloader downloader, PlaylistResult playlistResult2, int i, Object obj) {
        PlaylistResult playlistResult3;
        if ((i & 1) != 0) {
            playlistResult3 = new PlaylistResult((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, 1023, (DefaultConstructorMarker) null);
        } else {
            playlistResult3 = playlistResult2;
        }
        downloader.updatePlaylistResult(playlistResult3);
    }

    public final void updatePlaylistResult(PlaylistResult playlistResult2) {
        Intrinsics.checkNotNullParameter(playlistResult2, "playlistResult");
        MutableStateFlow<PlaylistResult> mutableStateFlow = mutablePlaylistResult;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), playlistResult2)) {
        }
    }

    public static /* synthetic */ void quickDownload$default(Downloader downloader, String str, DownloadUtil.DownloadPreferences downloadPreferences, int i, Object obj) {
        DownloadUtil.DownloadPreferences downloadPreferences2;
        if ((i & 2) == 0) {
            downloadPreferences2 = downloadPreferences;
        } else {
            downloadPreferences2 = new DownloadUtil.DownloadPreferences(false, false, false, false, false, null, false, false, false, null, false, false, 0, 0, false, null, false, false, 0, 0, false, false, null, 0, 0, null, 0, false, false, null, false, false, false, null, false, null, false, false, false, null, null, null, null, false, false, false, false, false, false, false, -1, LayoutUtilsKt.BigConstraintValue, null);
        }
        downloader.quickDownload(str, downloadPreferences2);
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.Downloader$quickDownload$1 */
    /* JADX INFO: compiled from: Downloader.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.Downloader$quickDownload$1", m210f = "Downloader.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C30621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DownloadUtil.DownloadPreferences $downloadPreferences;
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C30621(String str, DownloadUtil.DownloadPreferences downloadPreferences, Continuation<? super C30621> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$downloadPreferences = downloadPreferences;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C30621(this.$url, this.$downloadPreferences, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C30621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object prevValue$iv;
            Object prevValue$iv2;
            PendingIntent activity;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    MutableStateFlow $this$update$iv = Downloader.mutableQuickDownloadCount;
                    do {
                        prevValue$iv = $this$update$iv.getValue();
                    } while (!$this$update$iv.compareAndSet(prevValue$iv, Boxing.boxInt(((Number) prevValue$iv).intValue() + 1)));
                    Object objM7667fetchVideoInfoFromUrl0E7RQCE$default = DownloadUtil.m7667fetchVideoInfoFromUrl0E7RQCE$default(DownloadUtil.INSTANCE, this.$url, 0, this.$downloadPreferences, 2, null);
                    String str = this.$url;
                    Throwable it = Result.m7696exceptionOrNullimpl(objM7667fetchVideoInfoFromUrl0E7RQCE$default);
                    if (it != null) {
                        Downloader.manageDownloadError$default(Downloader.INSTANCE, it, str, str, true, true, null, 32, null);
                    }
                    DownloadUtil.DownloadPreferences downloadPreferences = this.$downloadPreferences;
                    if (Result.m7700isSuccessimpl(objM7667fetchVideoInfoFromUrl0E7RQCE$default)) {
                        final VideoInfo videoInfo = (VideoInfo) objM7667fetchVideoInfoFromUrl0E7RQCE$default;
                        final String taskId = videoInfo.getId() + downloadPreferences.hashCode();
                        final int notificationId = Downloader.INSTANCE.toNotificationId(taskId);
                        ToastUtil toastUtil = ToastUtil.INSTANCE;
                        String string = App.INSTANCE.getContext().getString(C3070R.string.download_start_msg);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        String str2 = String.format(string, Arrays.copyOf(new Object[]{videoInfo.getTitle()}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        toastUtil.makeToastSuspend(str2);
                        Object objM7666downloadVideohUnOzRk$default = DownloadUtil.m7666downloadVideohUnOzRk$default(DownloadUtil.INSTANCE, videoInfo, null, 0, taskId, downloadPreferences, new Function3<Float, Long, String, Unit>() { // from class: com.videshkarmakar.loop.Downloader$quickDownload$1$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f, Long l, String str3) {
                                invoke(f.floatValue(), l.longValue(), str3);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float progress, long j, String line) {
                                Intrinsics.checkNotNullParameter(line, "line");
                                NotificationUtil.INSTANCE.notifyProgress(videoInfo.getTitle(), notificationId, (int) progress, taskId, line);
                            }
                        }, 6, null);
                        Throwable it2 = Result.m7696exceptionOrNullimpl(objM7666downloadVideohUnOzRk$default);
                        if (it2 != null) {
                            NotificationUtil.INSTANCE.cancelNotification(notificationId);
                            if (!(it2 instanceof YoutubeDL.CanceledException)) {
                                NotificationUtil.INSTANCE.makeErrorReportNotification(videoInfo.getTitle(), notificationId, String.valueOf(it2.getMessage()));
                            }
                        }
                        if (Result.m7700isSuccessimpl(objM7666downloadVideohUnOzRk$default)) {
                            List it3 = (List) objM7666downloadVideohUnOzRk$default;
                            String string2 = App.INSTANCE.getContext().getString(it3.isEmpty() ? C3070R.string.status_completed : C3070R.string.download_finish_notification);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                            Intent $this$invokeSuspend_u24lambda_u245_u24lambda_u244_u24lambda_u243 = FileUtil.INSTANCE.createIntentForOpeningFile((String) CollectionsKt.firstOrNull(it3));
                            NotificationUtil notificationUtil = NotificationUtil.INSTANCE;
                            String title = videoInfo.getTitle();
                            if ($this$invokeSuspend_u24lambda_u245_u24lambda_u244_u24lambda_u243 != null) {
                                activity = PendingIntent.getActivity(App.INSTANCE.getContext(), 0, $this$invokeSuspend_u24lambda_u245_u24lambda_u244_u24lambda_u243, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
                            } else {
                                activity = null;
                            }
                            notificationUtil.finishNotification(notificationId, title, string2, activity);
                        }
                    }
                    MutableStateFlow $this$update$iv2 = Downloader.mutableQuickDownloadCount;
                    do {
                        prevValue$iv2 = $this$update$iv2.getValue();
                    } while (!$this$update$iv2.compareAndSet(prevValue$iv2, Boxing.boxInt(((Number) prevValue$iv2).intValue() - 1)));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void quickDownload(String url, DownloadUtil.DownloadPreferences downloadPreferences) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(downloadPreferences, "downloadPreferences");
        BuildersKt__Builders_commonKt.launch$default(App.INSTANCE.getApplicationScope(), Dispatchers.getIO(), null, new C30621(url, downloadPreferences, null), 2, null);
    }

    public static /* synthetic */ void getInfoAndDownload$default(Downloader downloader, String str, DownloadUtil.DownloadPreferences downloadPreferences, int i, Object obj) {
        DownloadUtil.DownloadPreferences downloadPreferences2;
        if ((i & 2) == 0) {
            downloadPreferences2 = downloadPreferences;
        } else {
            downloadPreferences2 = new DownloadUtil.DownloadPreferences(false, false, false, false, false, null, false, false, false, null, false, false, 0, 0, false, null, false, false, 0, 0, false, false, null, 0, 0, null, 0, false, false, null, false, false, false, null, false, null, false, false, false, null, null, null, null, false, false, false, false, false, false, false, -1, LayoutUtilsKt.BigConstraintValue, null);
        }
        downloader.getInfoAndDownload(str, downloadPreferences2);
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.Downloader$getInfoAndDownload$1 */
    /* JADX INFO: compiled from: Downloader.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.Downloader$getInfoAndDownload$1", m210f = "Downloader.kt", m211i = {}, m212l = {HttpStatusCodesKt.HTTP_PROXY_AUTH}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C30611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DownloadUtil.DownloadPreferences $downloadPreferences;
        final /* synthetic */ String $url;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C30611(String str, DownloadUtil.DownloadPreferences downloadPreferences, Continuation<? super C30611> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$downloadPreferences = downloadPreferences;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C30611(this.$url, this.$downloadPreferences, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C30611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object objM7216downloadVideoyxL6bBk$default;
            C30611 c30611;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Downloader.INSTANCE.updateState(State.FetchingInfo.INSTANCE);
                    Object objM7667fetchVideoInfoFromUrl0E7RQCE$default = DownloadUtil.m7667fetchVideoInfoFromUrl0E7RQCE$default(DownloadUtil.INSTANCE, this.$url, 0, this.$downloadPreferences, 2, null);
                    String str = this.$url;
                    Throwable it = Result.m7696exceptionOrNullimpl(objM7667fetchVideoInfoFromUrl0E7RQCE$default);
                    if (it != null) {
                        Downloader.manageDownloadError$default(Downloader.INSTANCE, it, str, null, true, true, null, 36, null);
                    }
                    DownloadUtil.DownloadPreferences downloadPreferences = this.$downloadPreferences;
                    if (Result.m7700isSuccessimpl(objM7667fetchVideoInfoFromUrl0E7RQCE$default)) {
                        Downloader downloader = Downloader.INSTANCE;
                        Downloader downloader2 = Downloader.INSTANCE;
                        this.L$0 = objM7667fetchVideoInfoFromUrl0E7RQCE$default;
                        this.label = 1;
                        objM7216downloadVideoyxL6bBk$default = Downloader.m7216downloadVideoyxL6bBk$default(downloader2, 0, null, (VideoInfo) objM7667fetchVideoInfoFromUrl0E7RQCE$default, downloadPreferences, this, 3, null);
                        if (objM7216downloadVideoyxL6bBk$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c30611 = this;
                        Downloader.downloadResultTemp = objM7216downloadVideoyxL6bBk$default;
                    }
                    return Unit.INSTANCE;
                case 1:
                    c30611 = this;
                    ResultKt.throwOnFailure($result);
                    objM7216downloadVideoyxL6bBk$default = ((Result) $result).getValue();
                    Downloader.downloadResultTemp = objM7216downloadVideoyxL6bBk$default;
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void getInfoAndDownload(String url, DownloadUtil.DownloadPreferences downloadPreferences) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(downloadPreferences, "downloadPreferences");
        currentJob = BuildersKt__Builders_commonKt.launch$default(App.INSTANCE.getApplicationScope(), Dispatchers.getIO(), null, new C30611(url, downloadPreferences, null), 2, null);
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.Downloader$downloadVideoWithConfigurations$1 */
    /* JADX INFO: compiled from: Downloader.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.Downloader$downloadVideoWithConfigurations$1", m210f = "Downloader.kt", m211i = {}, m212l = {466}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C30571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Format> $formatList;
        final /* synthetic */ String $newTitle;
        final /* synthetic */ List<String> $selectedSubtitleCodes;
        final /* synthetic */ boolean $splitByChapter;
        final /* synthetic */ List<VideoClip> $videoClips;
        final /* synthetic */ VideoInfo $videoInfo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C30571(List<Format> list, VideoInfo videoInfo, List<VideoClip> list2, boolean z, String str, List<String> list3, Continuation<? super C30571> continuation) {
            super(2, continuation);
            this.$formatList = list;
            this.$videoInfo = videoInfo;
            this.$videoClips = list2;
            this.$splitByChapter = z;
            this.$newTitle = str;
            this.$selectedSubtitleCodes = list3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C30571(this.$formatList, this.$videoInfo, this.$videoClips, this.$splitByChapter, this.$newTitle, this.$selectedSubtitleCodes, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C30571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:48:0x01ba  */
        /* JADX WARN: Code duplicated, block: B:97:0x03f1  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            boolean audioOnly;
            int count$iv;
            DownloadUtil.DownloadPreferences downloadPreferences;
            Object $result2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Iterable $this$fold$iv = this.$formatList;
                    double accumulator$iv = 0.0d;
                    Iterator it = $this$fold$iv.iterator();
                    while (true) {
                        double dDoubleValue = 0.0d;
                        if (!it.hasNext()) {
                            double fileSize = accumulator$iv;
                            VideoInfo $this$invokeSuspend_u24lambda_u241 = this.$videoInfo;
                            VideoInfo $this$invokeSuspend_u24lambda_u242 = !((fileSize > 0.0d ? 1 : (fileSize == 0.0d ? 0 : -1)) == 0) ? $this$invokeSuspend_u24lambda_u241.copy(((-1) & 1) != 0 ? $this$invokeSuspend_u24lambda_u241.id : null, ((-1) & 2) != 0 ? $this$invokeSuspend_u24lambda_u241.title : null, ((-1) & 4) != 0 ? $this$invokeSuspend_u24lambda_u241.formats : null, ((-1) & 8) != 0 ? $this$invokeSuspend_u24lambda_u241.thumbnail : null, ((-1) & 16) != 0 ? $this$invokeSuspend_u24lambda_u241.description : null, ((-1) & 32) != 0 ? $this$invokeSuspend_u24lambda_u241.uploader : null, ((-1) & 64) != 0 ? $this$invokeSuspend_u24lambda_u241.uploaderId : null, ((-1) & 128) != 0 ? $this$invokeSuspend_u24lambda_u241.subtitles : null, ((-1) & 256) != 0 ? $this$invokeSuspend_u24lambda_u241.automaticCaptions : null, ((-1) & 512) != 0 ? $this$invokeSuspend_u24lambda_u241.duration : null, ((-1) & 1024) != 0 ? $this$invokeSuspend_u24lambda_u241.viewCount : null, ((-1) & 2048) != 0 ? $this$invokeSuspend_u24lambda_u241.webpageUrl : null, ((-1) & 4096) != 0 ? $this$invokeSuspend_u24lambda_u241.tags : null, ((-1) & 8192) != 0 ? $this$invokeSuspend_u24lambda_u241.liveStatus : null, ((-1) & 16384) != 0 ? $this$invokeSuspend_u24lambda_u241.commentCount : null, ((-1) & 32768) != 0 ? $this$invokeSuspend_u24lambda_u241.chapters : null, ((-1) & 65536) != 0 ? $this$invokeSuspend_u24lambda_u241.likeCount : null, ((-1) & 131072) != 0 ? $this$invokeSuspend_u24lambda_u241.channel : null, ((-1) & 262144) != 0 ? $this$invokeSuspend_u24lambda_u241.uploadDate : null, ((-1) & 524288) != 0 ? $this$invokeSuspend_u24lambda_u241.availability : null, ((-1) & 1048576) != 0 ? $this$invokeSuspend_u24lambda_u241.originalUrl : null, ((-1) & 2097152) != 0 ? $this$invokeSuspend_u24lambda_u241.webpageUrlBasename : null, ((-1) & 4194304) != 0 ? $this$invokeSuspend_u24lambda_u241.webpageUrlDomain : null, ((-1) & 8388608) != 0 ? $this$invokeSuspend_u24lambda_u241.extractor : null, ((-1) & 16777216) != 0 ? $this$invokeSuspend_u24lambda_u241.extractorKey : null, ((-1) & 33554432) != 0 ? $this$invokeSuspend_u24lambda_u241.playlist : null, ((-1) & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? $this$invokeSuspend_u24lambda_u241.playlistIndex : null, ((-1) & 134217728) != 0 ? $this$invokeSuspend_u24lambda_u241.displayId : null, ((-1) & 268435456) != 0 ? $this$invokeSuspend_u24lambda_u241.fulltitle : null, ((-1) & 536870912) != 0 ? $this$invokeSuspend_u24lambda_u241.durationString : null, ((-1) & BasicMeasure.EXACTLY) != 0 ? $this$invokeSuspend_u24lambda_u241.releaseDate : null, ((-1) & Integer.MIN_VALUE) != 0 ? $this$invokeSuspend_u24lambda_u241.format : null, (4194271 & 1) != 0 ? $this$invokeSuspend_u24lambda_u241.formatId : null, (4194271 & 2) != 0 ? $this$invokeSuspend_u24lambda_u241.ext : null, (4194271 & 4) != 0 ? $this$invokeSuspend_u24lambda_u241.protocol : null, (4194271 & 8) != 0 ? $this$invokeSuspend_u24lambda_u241.formatNote : null, (4194271 & 16) != 0 ? $this$invokeSuspend_u24lambda_u241.fileSizeApprox : null, (4194271 & 32) != 0 ? $this$invokeSuspend_u24lambda_u241.fileSize : Boxing.boxDouble(fileSize), (4194271 & 64) != 0 ? $this$invokeSuspend_u24lambda_u241.tbr : null, (4194271 & 128) != 0 ? $this$invokeSuspend_u24lambda_u241.width : null, (4194271 & 256) != 0 ? $this$invokeSuspend_u24lambda_u241.height : null, (4194271 & 512) != 0 ? $this$invokeSuspend_u24lambda_u241.resolution : null, (4194271 & 1024) != 0 ? $this$invokeSuspend_u24lambda_u241.fps : null, (4194271 & 2048) != 0 ? $this$invokeSuspend_u24lambda_u241.dynamicRange : null, (4194271 & 4096) != 0 ? $this$invokeSuspend_u24lambda_u241.vcodec : null, (4194271 & 8192) != 0 ? $this$invokeSuspend_u24lambda_u241.vbr : null, (4194271 & 16384) != 0 ? $this$invokeSuspend_u24lambda_u241.acodec : null, (4194271 & 32768) != 0 ? $this$invokeSuspend_u24lambda_u241.abr : null, (4194271 & 65536) != 0 ? $this$invokeSuspend_u24lambda_u241.asr : null, (4194271 & 131072) != 0 ? $this$invokeSuspend_u24lambda_u241.epoch : null, (4194271 & 262144) != 0 ? $this$invokeSuspend_u24lambda_u241.requestedDownloads : null, (4194271 & 524288) != 0 ? $this$invokeSuspend_u24lambda_u241.requestedFormats : null, (4194271 & 1048576) != 0 ? $this$invokeSuspend_u24lambda_u241.filename : null, (4194271 & 2097152) != 0 ? $this$invokeSuspend_u24lambda_u241.type : null) : $this$invokeSuspend_u24lambda_u241;
                            String str = this.$newTitle;
                            VideoInfo info = str.length() > 0 ? $this$invokeSuspend_u24lambda_u242.copy(((-1) & 1) != 0 ? $this$invokeSuspend_u24lambda_u242.id : null, ((-1) & 2) != 0 ? $this$invokeSuspend_u24lambda_u242.title : str, ((-1) & 4) != 0 ? $this$invokeSuspend_u24lambda_u242.formats : null, ((-1) & 8) != 0 ? $this$invokeSuspend_u24lambda_u242.thumbnail : null, ((-1) & 16) != 0 ? $this$invokeSuspend_u24lambda_u242.description : null, ((-1) & 32) != 0 ? $this$invokeSuspend_u24lambda_u242.uploader : null, ((-1) & 64) != 0 ? $this$invokeSuspend_u24lambda_u242.uploaderId : null, ((-1) & 128) != 0 ? $this$invokeSuspend_u24lambda_u242.subtitles : null, ((-1) & 256) != 0 ? $this$invokeSuspend_u24lambda_u242.automaticCaptions : null, ((-1) & 512) != 0 ? $this$invokeSuspend_u24lambda_u242.duration : null, ((-1) & 1024) != 0 ? $this$invokeSuspend_u24lambda_u242.viewCount : null, ((-1) & 2048) != 0 ? $this$invokeSuspend_u24lambda_u242.webpageUrl : null, ((-1) & 4096) != 0 ? $this$invokeSuspend_u24lambda_u242.tags : null, ((-1) & 8192) != 0 ? $this$invokeSuspend_u24lambda_u242.liveStatus : null, ((-1) & 16384) != 0 ? $this$invokeSuspend_u24lambda_u242.commentCount : null, ((-1) & 32768) != 0 ? $this$invokeSuspend_u24lambda_u242.chapters : null, ((-1) & 65536) != 0 ? $this$invokeSuspend_u24lambda_u242.likeCount : null, ((-1) & 131072) != 0 ? $this$invokeSuspend_u24lambda_u242.channel : null, ((-1) & 262144) != 0 ? $this$invokeSuspend_u24lambda_u242.uploadDate : null, ((-1) & 524288) != 0 ? $this$invokeSuspend_u24lambda_u242.availability : null, ((-1) & 1048576) != 0 ? $this$invokeSuspend_u24lambda_u242.originalUrl : null, ((-1) & 2097152) != 0 ? $this$invokeSuspend_u24lambda_u242.webpageUrlBasename : null, ((-1) & 4194304) != 0 ? $this$invokeSuspend_u24lambda_u242.webpageUrlDomain : null, ((-1) & 8388608) != 0 ? $this$invokeSuspend_u24lambda_u242.extractor : null, ((-1) & 16777216) != 0 ? $this$invokeSuspend_u24lambda_u242.extractorKey : null, ((-1) & 33554432) != 0 ? $this$invokeSuspend_u24lambda_u242.playlist : null, ((-1) & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? $this$invokeSuspend_u24lambda_u242.playlistIndex : null, ((-1) & 134217728) != 0 ? $this$invokeSuspend_u24lambda_u242.displayId : null, ((-1) & 268435456) != 0 ? $this$invokeSuspend_u24lambda_u242.fulltitle : null, ((-1) & 536870912) != 0 ? $this$invokeSuspend_u24lambda_u242.durationString : null, ((-1) & BasicMeasure.EXACTLY) != 0 ? $this$invokeSuspend_u24lambda_u242.releaseDate : null, ((-1) & Integer.MIN_VALUE) != 0 ? $this$invokeSuspend_u24lambda_u242.format : null, (4194271 & 1) != 0 ? $this$invokeSuspend_u24lambda_u242.formatId : null, (4194271 & 2) != 0 ? $this$invokeSuspend_u24lambda_u242.ext : null, (4194271 & 4) != 0 ? $this$invokeSuspend_u24lambda_u242.protocol : null, (4194271 & 8) != 0 ? $this$invokeSuspend_u24lambda_u242.formatNote : null, (4194271 & 16) != 0 ? $this$invokeSuspend_u24lambda_u242.fileSizeApprox : null, (4194271 & 32) != 0 ? $this$invokeSuspend_u24lambda_u242.fileSize : null, (4194271 & 64) != 0 ? $this$invokeSuspend_u24lambda_u242.tbr : null, (4194271 & 128) != 0 ? $this$invokeSuspend_u24lambda_u242.width : null, (4194271 & 256) != 0 ? $this$invokeSuspend_u24lambda_u242.height : null, (4194271 & 512) != 0 ? $this$invokeSuspend_u24lambda_u242.resolution : null, (4194271 & 1024) != 0 ? $this$invokeSuspend_u24lambda_u242.fps : null, (4194271 & 2048) != 0 ? $this$invokeSuspend_u24lambda_u242.dynamicRange : null, (4194271 & 4096) != 0 ? $this$invokeSuspend_u24lambda_u242.vcodec : null, (4194271 & 8192) != 0 ? $this$invokeSuspend_u24lambda_u242.vbr : null, (4194271 & 16384) != 0 ? $this$invokeSuspend_u24lambda_u242.acodec : null, (4194271 & 32768) != 0 ? $this$invokeSuspend_u24lambda_u242.abr : null, (4194271 & 65536) != 0 ? $this$invokeSuspend_u24lambda_u242.asr : null, (4194271 & 131072) != 0 ? $this$invokeSuspend_u24lambda_u242.epoch : null, (4194271 & 262144) != 0 ? $this$invokeSuspend_u24lambda_u242.requestedDownloads : null, (4194271 & 524288) != 0 ? $this$invokeSuspend_u24lambda_u242.requestedFormats : null, (4194271 & 1048576) != 0 ? $this$invokeSuspend_u24lambda_u242.filename : null, (4194271 & 2097152) != 0 ? $this$invokeSuspend_u24lambda_u242.type : null) : $this$invokeSuspend_u24lambda_u242;
                            if (!this.$formatList.isEmpty()) {
                                Iterable $this$fold$iv2 = this.$formatList;
                                boolean accumulator$iv2 = true;
                                for (Object element$iv : $this$fold$iv2) {
                                    Format format = (Format) element$iv;
                                    boolean acc = accumulator$iv2;
                                    boolean acc2 = acc && Intrinsics.areEqual(format.getVcodec(), "none") && !Intrinsics.areEqual(format.getAcodec(), "none");
                                    accumulator$iv2 = acc2;
                                }
                                if (accumulator$iv2) {
                                    audioOnly = true;
                                } else {
                                    audioOnly = false;
                                }
                            } else {
                                audioOnly = false;
                            }
                            Iterable $this$count$iv = this.$formatList;
                            if (($this$count$iv instanceof Collection) && ((Collection) $this$count$iv).isEmpty()) {
                                count$iv = 0;
                            } else {
                                count$iv = 0;
                                for (Object element$iv2 : $this$count$iv) {
                                    Format format2 = (Format) element$iv2;
                                    if ((Intrinsics.areEqual(format2.getVcodec(), "none") && !Intrinsics.areEqual(format2.getAcodec(), "none")) && (count$iv = count$iv + 1) < 0) {
                                        CollectionsKt.throwCountOverflow();
                                    }
                                }
                            }
                            boolean mergeAudioStream = count$iv > 1;
                            DownloadUtil.DownloadPreferences $this$invokeSuspend_u24lambda_u245 = new DownloadUtil.DownloadPreferences(false, false, false, false, false, null, false, false, false, null, false, false, 0, 0, false, null, false, false, 0, 0, false, false, null, 0, 0, CollectionsKt.joinToString$default(this.$formatList, "+", null, null, 0, null, new Function1<Format, CharSequence>() { // from class: com.videshkarmakar.loop.Downloader$downloadVideoWithConfigurations$1$formatId$1
                                @Override // kotlin.jvm.functions.Function1
                                public final CharSequence invoke(Format it2) {
                                    Intrinsics.checkNotNullParameter(it2, "it");
                                    return String.valueOf(it2.getFormatId());
                                }
                            }, 30, null), 0, false, false, null, false, false, false, null, false, this.$videoClips, this.$splitByChapter, false, false, null, this.$newTitle, null, null, false, false, false, false, false, mergeAudioStream, false, -33554433, 196327, null);
                            DownloadUtil.DownloadPreferences $this$invokeSuspend_u24lambda_u248 = DownloadUtil.DownloadPreferences.copy$default($this$invokeSuspend_u24lambda_u245, $this$invokeSuspend_u24lambda_u245.getExtractAudio() || audioOnly, false, false, false, false, null, false, false, false, null, false, false, 0, 0, false, null, false, false, 0, 0, false, false, null, 0, 0, null, 0, false, false, null, false, false, false, null, false, null, false, false, false, null, null, null, null, false, false, false, false, false, false, false, -2, LayoutUtilsKt.BigConstraintValue, null);
                            List<String> list = this.$selectedSubtitleCodes;
                            if ((!list.isEmpty() ? list : null) != null) {
                                boolean autoSubtitle = !info.getSubtitles().keySet().containsAll(list);
                                DownloadUtil.DownloadPreferences downloadPreferencesCopy$default = DownloadUtil.DownloadPreferences.copy$default($this$invokeSuspend_u24lambda_u248, false, false, false, false, false, null, true, false, false, CollectionsKt.joinToString$default(list, ",", null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.videshkarmakar.loop.Downloader$downloadVideoWithConfigurations$1$downloadPreferences$2$2$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final CharSequence invoke(String it2) {
                                        Intrinsics.checkNotNullParameter(it2, "it");
                                        return it2;
                                    }
                                }, 30, null), autoSubtitle, false, 0, 0, false, null, false, false, 0, 0, false, false, null, 0, 0, null, 0, false, false, null, false, false, false, null, false, null, false, false, false, null, null, null, null, false, false, false, false, false, false, false, -1601, LayoutUtilsKt.BigConstraintValue, null);
                                if (downloadPreferencesCopy$default != null) {
                                    downloadPreferences = downloadPreferencesCopy$default;
                                } else {
                                    downloadPreferences = $this$invokeSuspend_u24lambda_u248;
                                }
                            } else {
                                downloadPreferences = $this$invokeSuspend_u24lambda_u248;
                            }
                            Downloader downloader = Downloader.INSTANCE;
                            this.label = 1;
                            Object objM7216downloadVideoyxL6bBk$default = Downloader.m7216downloadVideoyxL6bBk$default(Downloader.INSTANCE, 0, null, info, downloadPreferences, this, 3, null);
                            if (objM7216downloadVideoyxL6bBk$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result2 = objM7216downloadVideoyxL6bBk$default;
                        } else {
                            Object element$iv3 = it.next();
                            Format format3 = (Format) element$iv3;
                            double d = accumulator$iv;
                            Double fileSize2 = format3.getFileSize();
                            if (fileSize2 != null) {
                                dDoubleValue = fileSize2.doubleValue();
                            } else {
                                Double fileSizeApprox = format3.getFileSizeApprox();
                                if (fileSizeApprox != null) {
                                    dDoubleValue = fileSizeApprox.doubleValue();
                                }
                            }
                            accumulator$iv = d + dDoubleValue;
                        }
                        break;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    $result2 = ((Result) $result).getValue();
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Downloader.downloadResultTemp = $result2;
            return Unit.INSTANCE;
        }
    }

    public final void downloadVideoWithConfigurations(VideoInfo videoInfo, List<Format> formatList, List<VideoClip> videoClips, boolean splitByChapter, String newTitle, List<String> selectedSubtitleCodes) {
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        Intrinsics.checkNotNullParameter(formatList, "formatList");
        Intrinsics.checkNotNullParameter(videoClips, "videoClips");
        Intrinsics.checkNotNullParameter(newTitle, "newTitle");
        Intrinsics.checkNotNullParameter(selectedSubtitleCodes, "selectedSubtitleCodes");
        currentJob = BuildersKt__Builders_commonKt.launch$default(App.INSTANCE.getApplicationScope(), Dispatchers.getIO(), null, new C30571(formatList, videoInfo, videoClips, splitByChapter, newTitle, selectedSubtitleCodes, null), 2, null);
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.Downloader$downloadVideoWithInfo$1 */
    /* JADX INFO: compiled from: Downloader.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.Downloader$downloadVideoWithInfo$1", m210f = "Downloader.kt", m211i = {}, m212l = {475}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C30591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ VideoInfo $info;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C30591(VideoInfo videoInfo, Continuation<? super C30591> continuation) {
            super(2, continuation);
            this.$info = videoInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C30591(this.$info, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C30591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object objM7702unboximpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Downloader downloader = Downloader.INSTANCE;
                    this.label = 1;
                    Object objM7216downloadVideoyxL6bBk$default = Downloader.m7216downloadVideoyxL6bBk$default(Downloader.INSTANCE, 0, null, this.$info, null, this, 11, null);
                    if (objM7216downloadVideoyxL6bBk$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objM7702unboximpl = objM7216downloadVideoyxL6bBk$default;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objM7702unboximpl = ((Result) $result).getValue();
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Downloader.downloadResultTemp = objM7702unboximpl;
            return Unit.INSTANCE;
        }
    }

    public final void downloadVideoWithInfo(VideoInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        currentJob = BuildersKt__Builders_commonKt.launch$default(App.INSTANCE.getApplicationScope(), Dispatchers.getIO(), null, new C30591(info, null), 2, null);
    }

    /* JADX INFO: renamed from: downloadVideo-yxL6bBk$default, reason: not valid java name */
    static /* synthetic */ Object m7216downloadVideoyxL6bBk$default(Downloader downloader, int i, String str, VideoInfo videoInfo, DownloadUtil.DownloadPreferences downloadPreferences, Continuation continuation, int i2, Object obj) {
        DownloadUtil.DownloadPreferences downloadPreferences2;
        int i3 = (i2 & 1) != 0 ? 0 : i;
        String str2 = (i2 & 2) != 0 ? "" : str;
        if ((i2 & 8) != 0) {
            downloadPreferences2 = new DownloadUtil.DownloadPreferences(false, false, false, false, false, null, false, false, false, null, false, false, 0, 0, false, null, false, false, 0, 0, false, false, null, 0, 0, null, 0, false, false, null, false, false, false, null, false, null, false, false, false, null, null, null, null, false, false, false, false, false, false, false, -1, LayoutUtilsKt.BigConstraintValue, null);
        } else {
            downloadPreferences2 = downloadPreferences;
        }
        return downloader.m7215downloadVideoyxL6bBk(i3, str2, videoInfo, downloadPreferences2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: downloadVideo-yxL6bBk, reason: not valid java name */
    public final Object m7215downloadVideoyxL6bBk(int playlistIndex, String playlistUrl, final VideoInfo videoInfo, DownloadUtil.DownloadPreferences preferences, Continuation<? super Result<? extends List<String>>> continuation) {
        Log.d(TAG, preferences.getSubtitleLanguage());
        MutableStateFlow<DownloadTaskItem> mutableStateFlow = mutableTaskState;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), toTask$default(INSTANCE, videoInfo, 0, preferences.hashCode(), 1, null))) {
        }
        boolean isDownloadingPlaylist = downloaderState.getValue() instanceof State.DownloadingPlaylist;
        if (!isDownloadingPlaylist) {
            updateState(State.DownloadingVideo.INSTANCE);
        }
        String taskId = videoInfo.getId() + preferences.hashCode();
        final int notificationId = toNotificationId(taskId);
        Log.d(TAG, "downloadVideo: id=" + videoInfo.getId() + " " + videoInfo.getTitle());
        Log.d(TAG, "notificationId: " + notificationId);
        NotificationUtil.INSTANCE.notifyProgress(videoInfo.getTitle(), (28 & 2) != 0 ? 100 : notificationId, (28 & 4) != 0 ? 0 : 0, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null);
        Object objM7671downloadVideohUnOzRk = DownloadUtil.INSTANCE.m7671downloadVideohUnOzRk(videoInfo, playlistUrl, playlistIndex, videoInfo.getId() + preferences.hashCode(), preferences, new Function3<Float, Long, String, Unit>() { // from class: com.videshkarmakar.loop.Downloader$downloadVideo$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Float f, Long l, String str) {
                invoke(f.floatValue(), l.longValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(float progress, long j, String line) {
                Intrinsics.checkNotNullParameter(line, "line");
                Log.d("Downloader", line);
                MutableStateFlow $this$update$iv = Downloader.mutableTaskState;
                while (true) {
                    Object prevValue$iv = $this$update$iv.getValue();
                    Downloader.DownloadTaskItem it = (Downloader.DownloadTaskItem) prevValue$iv;
                    MutableStateFlow $this$update$iv2 = $this$update$iv;
                    if ($this$update$iv2.compareAndSet(prevValue$iv, Downloader.DownloadTaskItem.copy$default(it, null, null, null, 0, 0.0d, progress, line, null, null, 0, 927, null))) {
                        NotificationUtil.INSTANCE.notifyProgress(videoInfo.getTitle(), (28 & 2) != 0 ? 100 : notificationId, (28 & 4) != 0 ? 0 : (int) progress, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : line);
                        return;
                    }
                    $this$update$iv = $this$update$iv2;
                }
            }
        });
        Throwable it = Result.m7696exceptionOrNullimpl(objM7671downloadVideohUnOzRk);
        if (it != null) {
            INSTANCE.manageDownloadError(it, videoInfo.getOriginalUrl(), videoInfo.getTitle(), false, !isDownloadingPlaylist, Boxing.boxInt(notificationId));
        }
        if (Result.m7700isSuccessimpl(objM7671downloadVideohUnOzRk)) {
            List it2 = (List) objM7671downloadVideohUnOzRk;
            if (!isDownloadingPlaylist) {
                INSTANCE.finishProcessing();
            }
            String text = App.INSTANCE.getContext().getString(it2.isEmpty() ? C3070R.string.status_completed : C3070R.string.download_finish_notification);
            Intrinsics.checkNotNullExpressionValue(text, "getString(...)");
            Intent $this$downloadVideo_yxL6bBk_u24lambda_u2418_u24lambda_u2417 = FileUtil.INSTANCE.createIntentForOpeningFile((String) CollectionsKt.firstOrNull(it2));
            NotificationUtil.INSTANCE.finishNotification(notificationId, videoInfo.getTitle(), text, $this$downloadVideo_yxL6bBk_u24lambda_u2418_u24lambda_u2417 != null ? PendingIntent.getActivity(App.INSTANCE.getContext(), 0, $this$downloadVideo_yxL6bBk_u24lambda_u2418_u24lambda_u2417, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) : null);
        }
        return objM7671downloadVideohUnOzRk;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void downloadVideoInPlaylistByIndexList$default(Downloader downloader, String str, List list, List list2, DownloadUtil.DownloadPreferences downloadPreferences, int i, Object obj) {
        List listEmptyList;
        DownloadUtil.DownloadPreferences downloadPreferences2;
        if ((i & 4) == 0) {
            listEmptyList = list2;
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        if ((i & 8) == 0) {
            downloadPreferences2 = downloadPreferences;
        } else {
            downloadPreferences2 = new DownloadUtil.DownloadPreferences(false, false, false, false, false, null, false, false, false, null, false, false, 0, 0, false, null, false, false, 0, 0, false, false, null, 0, 0, null, 0, false, false, null, false, false, false, null, false, null, false, false, false, null, null, null, null, false, false, false, false, false, false, false, -1, LayoutUtilsKt.BigConstraintValue, null);
        }
        downloader.downloadVideoInPlaylistByIndexList(str, list, listEmptyList, downloadPreferences2);
    }

    public final void downloadVideoInPlaylistByIndexList(String url, List<Integer> indexList, List<Entries> playlistItemList, DownloadUtil.DownloadPreferences preferences) {
        int i;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(indexList, "indexList");
        Intrinsics.checkNotNullParameter(playlistItemList, "playlistItemList");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        int itemCount = indexList.size();
        if (isDownloaderAvailable()) {
            MutableStateFlow<State> mutableStateFlow = mutableDownloaderState;
            do {
                i = 0;
            } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), new State.DownloadingPlaylist(i, i, 3, null)));
            currentJob = BuildersKt__Builders_commonKt.launch$default(App.INSTANCE.getApplicationScope(), Dispatchers.getIO(), null, new C30562(indexList, itemCount, playlistItemList, url, preferences, null), 2, null);
        }
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.Downloader$downloadVideoInPlaylistByIndexList$2 */
    /* JADX INFO: compiled from: Downloader.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.Downloader$downloadVideoInPlaylistByIndexList$2", m210f = "Downloader.kt", m211i = {0, 0, 0, 0}, m212l = {596}, m213m = "invokeSuspend", m214n = {"playlistEntry", "title", "it", "i"}, m215s = {"L$0", "L$1", "L$3", "I$0"})
    static final class C30562 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Integer> $indexList;
        final /* synthetic */ int $itemCount;
        final /* synthetic */ List<Entries> $playlistItemList;
        final /* synthetic */ DownloadUtil.DownloadPreferences $preferences;
        final /* synthetic */ String $url;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C30562(List<Integer> list, int i, List<Entries> list2, String str, DownloadUtil.DownloadPreferences downloadPreferences, Continuation<? super C30562> continuation) {
            super(2, continuation);
            this.$indexList = list;
            this.$itemCount = i;
            this.$playlistItemList = list2;
            this.$url = str;
            this.$preferences = downloadPreferences;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C30562(this.$indexList, this.$itemCount, this.$playlistItemList, this.$url, this.$preferences, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C30562) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:12:0x005e  */
        /* JADX WARN: Code duplicated, block: B:16:0x0095  */
        /* JADX WARN: Code duplicated, block: B:17:0x009a  */
        /* JADX WARN: Code duplicated, block: B:20:0x00a6  */
        /* JADX WARN: Code duplicated, block: B:21:0x00ab  */
        /* JADX WARN: Code duplicated, block: B:24:0x00c2  */
        /* JADX WARN: Code duplicated, block: B:26:0x00d5  */
        /* JADX WARN: Code duplicated, block: B:28:0x00d8  */
        /* JADX WARN: Code duplicated, block: B:30:0x00f8 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x00f9  */
        /* JADX WARN: Code duplicated, block: B:34:0x010b  */
        /* JADX WARN: Code duplicated, block: B:36:0x0133  */
        /* JADX WARN: Code duplicated, block: B:39:0x013c  */
        /* JADX WARN: Code duplicated, block: B:41:0x0142  */
        /* JADX WARN: Code duplicated, block: B:42:0x0149  */
        /* JADX WARN: Code duplicated, block: B:49:0x0160 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:9:0x004a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00f9 -> B:32:0x0104). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0133 -> B:37:0x0135). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:39:0x013c
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                Method dump skipped, instruction units count: 372
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.videshkarmakar.loop.Downloader.C30562.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishProcessing() {
        DownloadTaskItem value;
        DownloadTaskItem it;
        if (downloaderState.getValue() instanceof State.Idle) {
            return;
        }
        MutableStateFlow<DownloadTaskItem> mutableStateFlow = mutableTaskState;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, DownloadTaskItem.copy$default(it, null, null, null, 0, 0.0d, 100.0f, "", null, null, 0, 927, null)));
        clearProgressState(true);
        updateState(State.Idle.INSTANCE);
        clearErrorState();
    }

    public static /* synthetic */ void manageDownloadError$default(Downloader downloader, Throwable th, String str, String str2, boolean z, boolean z2, Integer num, int i, Object obj) {
        downloader.manageDownloadError(th, str, (i & 4) != 0 ? null : str2, z, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? null : num);
    }

    public final void manageDownloadError(Throwable th, String url, String title, boolean isFetchingInfo, boolean isTaskAborted, Integer notificationId) {
        Intrinsics.checkNotNullParameter(th, "th");
        if (th instanceof YoutubeDL.CanceledException) {
            return;
        }
        th.printStackTrace();
        int resId = isFetchingInfo ? C3070R.string.fetch_info_error_msg : C3070R.string.download_error_msg;
        ToastUtil toastUtil = ToastUtil.INSTANCE;
        String string = App.INSTANCE.getContext().getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        toastUtil.makeToastSuspend(string);
        String notificationTitle = title == null ? url : title;
        if (isFetchingInfo) {
            fetchInfoError(String.valueOf(url), String.valueOf(th.getMessage()));
        } else {
            downloadError(String.valueOf(url), String.valueOf(th.getMessage()));
        }
        if (notificationId != null) {
            notificationId.intValue();
            NotificationUtil.finishNotification$default(NotificationUtil.INSTANCE, notificationId.intValue(), notificationTitle, App.INSTANCE.getContext().getString(C3070R.string.download_error_msg), null, 8, null);
        }
        if (isTaskAborted) {
            updateState(State.Idle.INSTANCE);
            clearProgressState(false);
        }
    }

    public final void cancelDownload() {
        ToastUtil toastUtil = ToastUtil.INSTANCE;
        String string = App.INSTANCE.getContext().getString(C3070R.string.task_canceled);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        toastUtil.makeToast(string);
        Job job = currentJob;
        if (job != null) {
            job.cancel(new CancellationException(App.INSTANCE.getContext().getString(C3070R.string.task_canceled)));
        }
        updateState(State.Idle.INSTANCE);
        clearProgressState(false);
        String $this$cancelDownload_u24lambda_u2422 = taskState.getValue().getTaskId();
        YoutubeDL.INSTANCE.destroyProcessById($this$cancelDownload_u24lambda_u2422);
        NotificationUtil.INSTANCE.cancelNotification(INSTANCE.toNotificationId($this$cancelDownload_u24lambda_u2422));
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.Downloader$executeCommandWithUrl$1 */
    /* JADX INFO: compiled from: Downloader.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.Downloader$executeCommandWithUrl$1", m210f = "Downloader.kt", m211i = {}, m212l = {686}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C30601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C30601(String str, Continuation<? super C30601> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C30601(this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C30601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (DownloadUtil.executeCommandInBackground$default(DownloadUtil.INSTANCE, this.$url, null, null, this, 6, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final Job executeCommandWithUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return BuildersKt__Builders_commonKt.launch$default(App.INSTANCE.getApplicationScope(), Dispatchers.getIO(), null, new C30601(url, null), 2, null);
    }

    public final void openDownloadResult() {
        if (taskState.getValue().getProgress() == 100.0f) {
            FileUtil.INSTANCE.openFileFromResult(downloadResultTemp);
        }
    }

    public final void onProcessStarted() {
        Integer value;
        int it;
        MutableStateFlow<Integer> mutableStateFlow = mutableProcessCount;
        do {
            value = mutableStateFlow.getValue();
            it = value.intValue();
        } while (!mutableStateFlow.compareAndSet(value, Integer.valueOf(it + 1)));
    }

    public final int toNotificationId(String $this$toNotificationId) {
        Intrinsics.checkNotNullParameter($this$toNotificationId, "<this>");
        return $this$toNotificationId.hashCode();
    }
}
