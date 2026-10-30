package com.videshkarmakar.loop.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.videshkarmakar.loop.App;
import com.videshkarmakar.loop.C3070R;
import com.yausername.youtubedl_android.YoutubeDL;
import com.yausername.youtubedl_android.YoutubeDLException;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.p007io.CloseableKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: compiled from: UpdateUtil.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u00045678B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001cJ&\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u001cJ&\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010'J#\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\b\b\u0002\u0010\u001a\u001a\u00020\u001bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u0004\u0018\u00010,H\u0086@¢\u0006\u0002\u0010'J\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020#0\"*\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\f\u00101\u001a\u000202*\u00020\u001bH\u0002J\f\u00103\u001a\u000200*\u00020\u001bH\u0002J\f\u00104\u001a\u000202*\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00069"}, m195d2 = {"Lcom/videshkarmakar/loop/util/UpdateUtil;", "", "()V", "ARM32", "", "ARM64", "EMPTY_VERSION", "Lcom/videshkarmakar/loop/util/UpdateUtil$Version$Stable;", "OWNER", "REPO", "TAG", "X64", "X86", "client", "Lokhttp3/OkHttpClient;", "jsonFormat", "Lkotlinx/serialization/json/Json;", "pattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "requestForLatestRelease", "Lokhttp3/Request;", "requestForReleases", "ytdlpNightlyBuildRelease", "checkForUpdate", "Lcom/videshkarmakar/loop/util/UpdateUtil$LatestRelease;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOutdatedApk", "Lkotlin/Result;", "", "deleteOutdatedApk-gIAlu-s", "downloadApk", "Lkotlinx/coroutines/flow/Flow;", "Lcom/videshkarmakar/loop/util/UpdateUtil$DownloadStatus;", "latestRelease", "(Landroid/content/Context;Lcom/videshkarmakar/loop/util/UpdateUtil$LatestRelease;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestRelease", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "installLatestApk", "installLatestApk-IoAF18A", "(Landroid/content/Context;)Ljava/lang/Object;", "updateYtDlp", "Lcom/yausername/youtubedl_android/YoutubeDL$UpdateStatus;", "downloadFileWithProgress", "Lokhttp3/ResponseBody;", "saveFile", "Ljava/io/File;", "getCurrentVersion", "Lcom/videshkarmakar/loop/util/UpdateUtil$Version;", "getLatestApk", "toVersion", "AssetsItem", "DownloadStatus", "LatestRelease", "Version", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class UpdateUtil {
    private static final String ARM32 = "armeabi-v7a";
    private static final String ARM64 = "arm64-v8a";
    private static final String OWNER = "JunkFood02";
    private static final String REPO = "LOOP";
    private static final String TAG = "UpdateUtil";
    private static final String X64 = "x86_64";
    private static final String X86 = "x86";
    private static final String ytdlpNightlyBuildRelease = "https://api.github.com/repos/yt-dlp/yt-dlp-nightly-builds/releases/latest";
    public static final UpdateUtil INSTANCE = new UpdateUtil();
    private static final OkHttpClient client = new OkHttpClient();
    private static final Request requestForLatestRelease = new Request.Builder().url("https://api.github.com/repos/JunkFood02/LOOP/releases/latest").build();
    private static final Request requestForReleases = new Request.Builder().url("https://api.github.com/repos/JunkFood02/LOOP/releases").build();
    private static final Json jsonFormat = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.videshkarmakar.loop.util.UpdateUtil$jsonFormat$1
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
    private static final Pattern pattern = Pattern.compile("v?(\\d+)\\.(\\d+)\\.(\\d+)(-(\\w+)\\.(\\d+))?");
    private static final Version.Stable EMPTY_VERSION = new Version.Stable(0, 0, 0, 7, null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.videshkarmakar.loop.util.UpdateUtil$checkForUpdate$1 */
    /* JADX INFO: compiled from: UpdateUtil.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.util.UpdateUtil", m210f = "UpdateUtil.kt", m211i = {0, 0}, m212l = {TarConstants.SPARSELEN_GNU}, m213m = "checkForUpdate", m214n = {"this", "currentVersion"}, m215s = {"L$0", "L$1"})
    static final class C40551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C40551(Continuation<? super C40551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UpdateUtil.this.checkForUpdate(null, this);
        }
    }

    private UpdateUtil() {
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.util.UpdateUtil$updateYtDlp$2 */
    /* JADX INFO: compiled from: UpdateUtil.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "Lcom/yausername/youtubedl_android/YoutubeDL$UpdateStatus;", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.util.UpdateUtil$updateYtDlp$2", m210f = "UpdateUtil.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C40582 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super YoutubeDL.UpdateStatus>, Object> {
        int label;

        C40582(Continuation<? super C40582> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C40582(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super YoutubeDL.UpdateStatus> continuation) {
            return ((C40582) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws YoutubeDLException {
            String it;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    YoutubeDL.UpdateChannel.STABLE channel = PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.YT_DLP_UPDATE_CHANNEL, 0, 1, null) == 1 ? YoutubeDL.UpdateChannel.NIGHTLY.INSTANCE : YoutubeDL.UpdateChannel.STABLE.INSTANCE;
                    YoutubeDL.UpdateStatus it2 = YoutubeDL.getInstance().updateYoutubeDL(App.INSTANCE.getContext(), channel);
                    if (it2 == YoutubeDL.UpdateStatus.DONE && (it = YoutubeDL.getInstance().version(App.INSTANCE.getContext())) != null) {
                        Boxing.boxBoolean(PreferenceUtil.INSTANCE.encodeString(PreferenceUtilKt.YT_DLP_VERSION, it));
                    }
                    long now = System.currentTimeMillis();
                    PreferenceUtil.INSTANCE.updateLong(PreferenceUtilKt.YT_DLP_UPDATE_TIME, now);
                    return it2;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object updateYtDlp(Continuation<? super YoutubeDL.UpdateStatus> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C40582(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getLatestRelease(Continuation<? super LatestRelease> continuation) throws Exception {
        Object maxElem$iv;
        Response $this$getLatestRelease_u24lambda_u244 = client.newCall(requestForReleases).execute();
        int i = 0;
        Json this_$iv = jsonFormat;
        String string$iv = $this$getLatestRelease_u24lambda_u244.body().string();
        this_$iv.getSerializersModule();
        Iterable releaseList = (List) this_$iv.decodeFromString(new ArrayListSerializer(LatestRelease.INSTANCE.serializer()), string$iv);
        Iterable $this$filter$iv = releaseList;
        Collection destination$iv$iv = new ArrayList();
        Iterator it = $this$filter$iv.iterator();
        while (true) {
            maxElem$iv = null;
            if (!it.hasNext()) {
                break;
            }
            Object element$iv$iv = it.next();
            LatestRelease it2 = (LatestRelease) element$iv$iv;
            int i2 = i;
            if (PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.UPDATE_CHANNEL, 0, 1, null) == 0 ? INSTANCE.toVersion(it2.getName()) instanceof Version.Stable : true) {
                destination$iv$iv.add(element$iv$iv);
            }
            i = i2;
        }
        Iterable $this$maxByOrNull$iv = (List) destination$iv$iv;
        Iterator iterator$iv = $this$maxByOrNull$iv.iterator();
        if (iterator$iv.hasNext()) {
            maxElem$iv = iterator$iv.next();
            if (iterator$iv.hasNext()) {
                LatestRelease it3 = (LatestRelease) maxElem$iv;
                Comparable maxValue$iv = INSTANCE.toVersion(it3.getName());
                do {
                    Object e$iv = iterator$iv.next();
                    LatestRelease it4 = (LatestRelease) e$iv;
                    Version version = INSTANCE.toVersion(it4.getName());
                    if (maxValue$iv.compareTo(version) < 0) {
                        maxValue$iv = version;
                        maxElem$iv = e$iv;
                    }
                } while (iterator$iv.hasNext());
            }
        }
        Object maxElem$iv2 = (LatestRelease) maxElem$iv;
        if (maxElem$iv2 == null) {
            throw new Exception("null response");
        }
        Iterable $this$sortedBy$iv = releaseList;
        Iterable $this$forEach$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.videshkarmakar.loop.util.UpdateUtil$getLatestRelease$lambda$4$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                UpdateUtil.LatestRelease it5 = (UpdateUtil.LatestRelease) t;
                UpdateUtil.LatestRelease it6 = (UpdateUtil.LatestRelease) t2;
                return ComparisonsKt.compareValues(UpdateUtil.INSTANCE.toVersion(it5.getName()), UpdateUtil.INSTANCE.toVersion(it6.getName()));
            }
        });
        for (Object element$iv : $this$forEach$iv) {
            LatestRelease it5 = (LatestRelease) element$iv;
            Log.d(TAG, String.valueOf(it5.getTagName()));
        }
        $this$getLatestRelease_u24lambda_u244.body().close();
        return maxElem$iv2;
    }

    public static /* synthetic */ Object checkForUpdate$default(UpdateUtil updateUtil, Context context, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            context = App.INSTANCE.getContext();
        }
        return updateUtil.checkForUpdate(context, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object checkForUpdate(Context context, Continuation<? super LatestRelease> continuation) throws Exception {
        C40551 c40551;
        Version currentVersion;
        Object latestRelease;
        UpdateUtil updateUtil;
        if (continuation instanceof C40551) {
            c40551 = (C40551) continuation;
            if ((c40551.label & Integer.MIN_VALUE) != 0) {
                c40551.label -= Integer.MIN_VALUE;
            } else {
                c40551 = new C40551(continuation);
            }
        } else {
            c40551 = new C40551(continuation);
        }
        C40551 c40552 = c40551;
        Object $result = c40552.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c40552.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                currentVersion = getCurrentVersion(context);
                c40552.L$0 = this;
                c40552.L$1 = currentVersion;
                c40552.label = 1;
                latestRelease = getLatestRelease(c40552);
                if (latestRelease == coroutine_suspended) {
                    return coroutine_suspended;
                }
                updateUtil = this;
                break;
                break;
            case 1:
                currentVersion = (Version) c40552.L$1;
                updateUtil = (UpdateUtil) c40552.L$0;
                ResultKt.throwOnFailure($result);
                latestRelease = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LatestRelease latestRelease2 = (LatestRelease) latestRelease;
        Version latestVersion = updateUtil.toVersion(latestRelease2.getName());
        if (currentVersion.compareTo(latestVersion) < 0) {
            return latestRelease2;
        }
        return null;
    }

    private final Version getCurrentVersion(Context $this$getCurrentVersion) {
        if (Build.VERSION.SDK_INT >= 33) {
            return toVersion($this$getCurrentVersion.getPackageManager().getPackageInfo($this$getCurrentVersion.getPackageName(), PackageManager.PackageInfoFlags.of(0L)).versionName);
        }
        return toVersion($this$getCurrentVersion.getPackageManager().getPackageInfo($this$getCurrentVersion.getPackageName(), 0).versionName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getLatestApk(Context $this$getLatestApk) {
        return new File($this$getLatestApk.getExternalFilesDir("apk"), "latest.apk");
    }

    /* JADX INFO: renamed from: installLatestApk-IoAF18A$default, reason: not valid java name */
    public static /* synthetic */ Object m7682installLatestApkIoAF18A$default(UpdateUtil updateUtil, Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = App.INSTANCE.getContext();
        }
        return updateUtil.m7684installLatestApkIoAF18A(context);
    }

    /* JADX INFO: renamed from: installLatestApk-IoAF18A, reason: not valid java name */
    public final Object m7684installLatestApkIoAF18A(Context context) {
        Object objM7693constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            Uri contentUri = FileProvider.getUriForFile(context, FileUtil.INSTANCE.getFileProvider(context), INSTANCE.getLatestApk(context));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.addFlags(1);
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
            context.startActivity(intent);
            objM7693constructorimpl = Result.m7693constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7693constructorimpl = Result.m7693constructorimpl(ResultKt.createFailure(th));
        }
        Throwable throwable = Result.m7696exceptionOrNullimpl(objM7693constructorimpl);
        if (throwable != null) {
            throwable.printStackTrace();
            ToastUtil.INSTANCE.makeToast(C3070R.string.app_update_failed);
        }
        return objM7693constructorimpl;
    }

    /* JADX INFO: renamed from: deleteOutdatedApk-gIAlu-s$default, reason: not valid java name */
    public static /* synthetic */ Object m7681deleteOutdatedApkgIAlus$default(UpdateUtil updateUtil, Context context, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            context = App.INSTANCE.getContext();
        }
        return updateUtil.m7683deleteOutdatedApkgIAlus(context, continuation);
    }

    /* JADX INFO: renamed from: deleteOutdatedApk-gIAlu-s, reason: not valid java name */
    public final Object m7683deleteOutdatedApkgIAlus(Context context, Continuation<? super Result<Unit>> continuation) {
        try {
            Result.Companion companion = Result.INSTANCE;
            File apkFile = INSTANCE.getLatestApk(context);
            if (apkFile.exists()) {
                UpdateUtil updateUtil = INSTANCE;
                PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(apkFile.getAbsolutePath(), 0);
                Version apkVersion = updateUtil.toVersion(packageArchiveInfo != null ? packageArchiveInfo.versionName : null);
                if (apkVersion.compareTo(INSTANCE.getCurrentVersion(context)) <= 0) {
                    apkFile.delete();
                }
            }
            return Result.m7693constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7693constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static /* synthetic */ Object downloadApk$default(UpdateUtil updateUtil, Context context, LatestRelease latestRelease, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            context = App.INSTANCE.getContext();
        }
        return updateUtil.downloadApk(context, latestRelease, continuation);
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.util.UpdateUtil$downloadApk$2 */
    /* JADX INFO: compiled from: UpdateUtil.kt */
    @Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, m195d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "Lcom/videshkarmakar/loop/util/UpdateUtil$DownloadStatus;", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.util.UpdateUtil$downloadApk$2", m210f = "UpdateUtil.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C40562 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Flow<? extends DownloadStatus>>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ LatestRelease $latestRelease;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C40562(Context context, LatestRelease latestRelease, Continuation<? super C40562> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$latestRelease = latestRelease;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C40562(this.$context, this.$latestRelease, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Flow<? extends DownloadStatus>> continuation) {
            return ((C40562) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AssetsItem assetsItem;
            String targetUrl;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    UpdateUtil updateUtil = UpdateUtil.INSTANCE;
                    PackageInfo packageArchiveInfo = this.$context.getPackageManager().getPackageArchiveInfo(UpdateUtil.INSTANCE.getLatestApk(this.$context).getAbsolutePath(), 0);
                    Object obj2 = null;
                    Version apkVersion = updateUtil.toVersion(packageArchiveInfo != null ? packageArchiveInfo.versionName : null);
                    Log.d(UpdateUtil.TAG, apkVersion.toString());
                    if (apkVersion.compareTo(UpdateUtil.INSTANCE.toVersion(this.$latestRelease.getName())) >= 0) {
                        return FlowKt.flow(new AnonymousClass1(this.$context, null));
                    }
                    String[] abiList = Build.SUPPORTED_ABIS;
                    Intrinsics.checkNotNull(abiList);
                    String preferredArch = (String) ArraysKt.firstOrNull(abiList);
                    if (preferredArch == null) {
                        return FlowKt.emptyFlow();
                    }
                    List<AssetsItem> assets = this.$latestRelease.getAssets();
                    if (assets != null) {
                        for (Object obj3 : assets) {
                            AssetsItem it = (AssetsItem) obj3;
                            String name = it.getName();
                            if (name != null ? StringsKt.contains$default((CharSequence) name, (CharSequence) preferredArch, false, 2, (Object) null) : false) {
                                obj2 = obj3;
                                assetsItem = (AssetsItem) obj2;
                                if (assetsItem != null && (targetUrl = assetsItem.getBrowserDownloadUrl()) != null) {
                                    Request request = new Request.Builder().url(targetUrl).build();
                                    try {
                                        Response response = UpdateUtil.client.newCall(request).execute();
                                        ResponseBody responseBody = response.body();
                                        return UpdateUtil.INSTANCE.downloadFileWithProgress(responseBody, UpdateUtil.INSTANCE.getLatestApk(this.$context));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        return FlowKt.emptyFlow();
                                    }
                                }
                            }
                        }
                        assetsItem = (AssetsItem) obj2;
                        if (assetsItem != null) {
                            Request request2 = new Request.Builder().url(targetUrl).build();
                            Response response2 = UpdateUtil.client.newCall(request2).execute();
                            ResponseBody responseBody2 = response2.body();
                            return UpdateUtil.INSTANCE.downloadFileWithProgress(responseBody2, UpdateUtil.INSTANCE.getLatestApk(this.$context));
                        }
                    }
                    return FlowKt.emptyFlow();
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.videshkarmakar.loop.util.UpdateUtil$downloadApk$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: UpdateUtil.kt */
        @Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/videshkarmakar/loop/util/UpdateUtil$DownloadStatus;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "com.videshkarmakar.loop.util.UpdateUtil$downloadApk$2$1", m210f = "UpdateUtil.kt", m211i = {}, m212l = {159}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super DownloadStatus>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $context;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Context context, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$context = context;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(FlowCollector<? super DownloadStatus> flowCollector, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        FlowCollector $this$flow = (FlowCollector) this.L$0;
                        this.label = 1;
                        if ($this$flow.emit(new DownloadStatus.Finished(UpdateUtil.INSTANCE.getLatestApk(this.$context)), this) == coroutine_suspended) {
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
    }

    public final Object downloadApk(Context context, LatestRelease latestRelease, Continuation<? super Flow<? extends DownloadStatus>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C40562(context, latestRelease, null), continuation);
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.util.UpdateUtil$downloadFileWithProgress$1 */
    /* JADX INFO: compiled from: UpdateUtil.kt */
    @Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/videshkarmakar/loop/util/UpdateUtil$DownloadStatus;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.util.UpdateUtil$downloadFileWithProgress$1", m210f = "UpdateUtil.kt", m211i = {0, 1, 1, 1, 1, 1, 1, 1, 2}, m212l = {181, 202, 213}, m213m = "invokeSuspend", m214n = {"$this$flow", "$this$flow", "deleteFile", "inputStream", "outputStream", "data", "totalBytes", "progressBytes", "deleteFile"}, m215s = {"L$0", "L$0", "L$1", "L$3", "L$5", "L$6", "J$0", "J$1", "L$0"})
    static final class C40571 extends SuspendLambda implements Function2<FlowCollector<? super DownloadStatus>, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $saveFile;
        final /* synthetic */ ResponseBody $this_downloadFileWithProgress;
        long J$0;
        long J$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C40571(ResponseBody responseBody, File file, Continuation<? super C40571> continuation) {
            super(2, continuation);
            this.$this_downloadFileWithProgress = responseBody;
            this.$saveFile = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C40571 c40571 = new C40571(this.$this_downloadFileWithProgress, this.$saveFile, continuation);
            c40571.L$0 = obj;
            return c40571;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super DownloadStatus> flowCollector, Continuation<? super Unit> continuation) {
            return ((C40571) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:129:0x00df A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:130:0x0186 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:32:0x00e3  */
        /* JADX WARN: Code duplicated, block: B:34:0x00e7  */
        /* JADX WARN: Code duplicated, block: B:39:0x0118 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:40:0x0119  */
        /* JADX WARN: Code duplicated, block: B:43:0x011f  */
        /* JADX WARN: Code duplicated, block: B:50:0x0134 A[Catch: all -> 0x0144, TRY_ENTER, TryCatch #1 {all -> 0x0144, blocks: (B:35:0x00e8, B:50:0x0134, B:51:0x013b, B:52:0x013c, B:53:0x0143), top: B:100:0x00e1 }] */
        /* JADX WARN: Code duplicated, block: B:52:0x013c A[Catch: all -> 0x0144, TryCatch #1 {all -> 0x0144, blocks: (B:35:0x00e8, B:50:0x0134, B:51:0x013b, B:52:0x013c, B:53:0x0143), top: B:100:0x00e1 }] */
        /* JADX WARN: Code duplicated, block: B:56:0x014c  */
        /* JADX WARN: Code duplicated, block: B:64:0x0187 A[LOOP:0: B:113:0x00ce->B:64:0x0187, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:96:0x01de  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            FlowCollector $this$flow;
            C40571 c40571;
            Object $result2;
            Ref.BooleanRef deleteFile;
            Ref.BooleanRef deleteFile2;
            InputStream inputStreamByteStream;
            Throwable th;
            FileOutputStream fileOutputStream;
            Closeable closeable;
            Object $result3;
            Throwable th2;
            long progressBytes;
            FileOutputStream outputStream;
            InputStream inputStream;
            FileOutputStream outputStream2;
            Throwable th3;
            Throwable th4;
            FlowCollector $this$flow2;
            byte[] data;
            byte[] data2;
            long totalBytes;
            int bytes;
            Object $result4;
            FileOutputStream fileOutputStream2;
            Ref.BooleanRef deleteFile3;
            long progressBytes2;
            DownloadStatus.Progress progress;
            byte[] bArr;
            Throwable th5;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$flow = (FlowCollector) this.L$0;
                    this.L$0 = $this$flow;
                    this.label = 1;
                    if ($this$flow.emit(new DownloadStatus.Progress(0), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c40571 = this;
                    $result2 = $result;
                    deleteFile = new Ref.BooleanRef();
                    deleteFile.element = true;
                    try {
                        inputStreamByteStream = c40571.$this_downloadFileWithProgress.byteStream();
                        File file = c40571.$saveFile;
                        ResponseBody responseBody = c40571.$this_downloadFileWithProgress;
                        try {
                            InputStream inputStream2 = inputStreamByteStream;
                            fileOutputStream = new FileOutputStream(file);
                            try {
                                FileOutputStream outputStream3 = fileOutputStream;
                                long totalBytes2 = responseBody.getContentLength();
                                byte[] data3 = new byte[8192];
                                progressBytes = 0;
                                outputStream = outputStream3;
                                inputStream = inputStream2;
                                outputStream2 = null;
                                th3 = null;
                                th4 = null;
                                $result3 = $result2;
                                $this$flow2 = $this$flow;
                                deleteFile2 = deleteFile;
                                closeable = inputStreamByteStream;
                                data = data3;
                                data2 = null;
                                totalBytes = totalBytes2;
                                while (true) {
                                    try {
                                        bytes = inputStream.read(data);
                                        $result4 = $result3;
                                        fileOutputStream2 = outputStream2;
                                        if (bytes == -1) {
                                            try {
                                                if (progressBytes < totalBytes) {
                                                    throw new Exception("missing bytes");
                                                }
                                                if (progressBytes > totalBytes) {
                                                    throw new Exception("too many bytes");
                                                }
                                                deleteFile2.element = false;
                                                Unit unit = Unit.INSTANCE;
                                                try {
                                                    CloseableKt.closeFinally(fileOutputStream, th3);
                                                    Unit unit2 = Unit.INSTANCE;
                                                    try {
                                                        CloseableKt.closeFinally(closeable, th4);
                                                        c40571.L$0 = deleteFile2;
                                                        c40571.L$1 = null;
                                                        c40571.L$2 = null;
                                                        c40571.L$3 = null;
                                                        c40571.L$4 = null;
                                                        c40571.L$5 = null;
                                                        c40571.L$6 = null;
                                                        c40571.label = 3;
                                                        if ($this$flow2.emit(new DownloadStatus.Finished(c40571.$saveFile), c40571) == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        if (deleteFile2.element) {
                                                            c40571.$saveFile.delete();
                                                        }
                                                        throw th;
                                                    }
                                                } catch (Throwable th7) {
                                                    inputStreamByteStream = closeable;
                                                    $result2 = $result4;
                                                    th = th7;
                                                    try {
                                                        throw th;
                                                    } catch (Throwable th8) {
                                                        try {
                                                            CloseableKt.closeFinally(inputStreamByteStream, th);
                                                            throw th8;
                                                        } catch (Throwable th9) {
                                                            th = th9;
                                                            if (deleteFile2.element) {
                                                                c40571.$saveFile.delete();
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                }
                                            } catch (Throwable th10) {
                                                th2 = th10;
                                                $result3 = $result4;
                                                throw th2;
                                            }
                                        } else {
                                            try {
                                                outputStream.getChannel();
                                                outputStream.write(data, 0, bytes);
                                                deleteFile3 = deleteFile2;
                                                progressBytes2 = progressBytes + ((long) bytes);
                                                try {
                                                    bArr = data2;
                                                    th5 = th3;
                                                    progress = new DownloadStatus.Progress((int) ((((long) 100) * progressBytes2) / totalBytes));
                                                    c40571.L$0 = $this$flow2;
                                                    try {
                                                        c40571.L$1 = deleteFile3;
                                                        c40571.L$2 = closeable;
                                                        c40571.L$3 = inputStream;
                                                        c40571.L$4 = fileOutputStream;
                                                        c40571.L$5 = outputStream;
                                                        c40571.L$6 = data;
                                                        c40571.J$0 = totalBytes;
                                                        c40571.J$1 = progressBytes2;
                                                        c40571.label = 2;
                                                        if ($this$flow2.emit(progress, c40571) == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        th3 = th5;
                                                        outputStream2 = fileOutputStream2;
                                                        deleteFile2 = deleteFile3;
                                                        data2 = bArr;
                                                        $result3 = $result4;
                                                        progressBytes = progressBytes2;
                                                    } catch (Throwable th11) {
                                                        th2 = th11;
                                                        deleteFile2 = deleteFile3;
                                                        $result3 = $result4;
                                                    }
                                                } catch (Throwable th12) {
                                                    th2 = th12;
                                                    deleteFile2 = deleteFile3;
                                                    $result3 = $result4;
                                                }
                                            } catch (Throwable th13) {
                                                th2 = th13;
                                                $result3 = $result4;
                                            }
                                        }
                                    } catch (Throwable th14) {
                                        th2 = th14;
                                    }
                                    try {
                                        throw th2;
                                    } catch (Throwable th15) {
                                        try {
                                            CloseableKt.closeFinally(fileOutputStream, th2);
                                            throw th15;
                                        } catch (Throwable th16) {
                                            $result2 = $result3;
                                            inputStreamByteStream = closeable;
                                            th = th16;
                                            throw th;
                                        }
                                    }
                                }
                                if (deleteFile2.element) {
                                    c40571.$saveFile.delete();
                                }
                                return Unit.INSTANCE;
                            } catch (Throwable th17) {
                                deleteFile2 = deleteFile;
                                closeable = inputStreamByteStream;
                                $result3 = $result2;
                                th2 = th17;
                            }
                        } catch (Throwable th18) {
                            deleteFile2 = deleteFile;
                            th = th18;
                            throw th;
                        }
                    } catch (Throwable th19) {
                        th = th19;
                        deleteFile2 = deleteFile;
                        if (deleteFile2.element) {
                            c40571.$saveFile.delete();
                        }
                        throw th;
                    }
                    break;
                case 1:
                    $this$flow = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure($result);
                    c40571 = this;
                    $result2 = $result;
                    deleteFile = new Ref.BooleanRef();
                    deleteFile.element = true;
                    inputStreamByteStream = c40571.$this_downloadFileWithProgress.byteStream();
                    File file2 = c40571.$saveFile;
                    ResponseBody responseBody2 = c40571.$this_downloadFileWithProgress;
                    InputStream inputStream3 = inputStreamByteStream;
                    fileOutputStream = new FileOutputStream(file2);
                    FileOutputStream outputStream4 = fileOutputStream;
                    long totalBytes3 = responseBody2.getContentLength();
                    byte[] data4 = new byte[8192];
                    progressBytes = 0;
                    outputStream = outputStream4;
                    inputStream = inputStream3;
                    outputStream2 = null;
                    th3 = null;
                    th4 = null;
                    $result3 = $result2;
                    $this$flow2 = $this$flow;
                    deleteFile2 = deleteFile;
                    closeable = inputStreamByteStream;
                    data = data4;
                    data2 = null;
                    totalBytes = totalBytes3;
                    while (true) {
                        bytes = inputStream.read(data);
                        $result4 = $result3;
                        fileOutputStream2 = outputStream2;
                        if (bytes == -1) {
                            outputStream.getChannel();
                            outputStream.write(data, 0, bytes);
                            deleteFile3 = deleteFile2;
                            progressBytes2 = progressBytes + ((long) bytes);
                            bArr = data2;
                            th5 = th3;
                            progress = new DownloadStatus.Progress((int) ((((long) 100) * progressBytes2) / totalBytes));
                            c40571.L$0 = $this$flow2;
                            c40571.L$1 = deleteFile3;
                            c40571.L$2 = closeable;
                            c40571.L$3 = inputStream;
                            c40571.L$4 = fileOutputStream;
                            c40571.L$5 = outputStream;
                            c40571.L$6 = data;
                            c40571.J$0 = totalBytes;
                            c40571.J$1 = progressBytes2;
                            c40571.label = 2;
                            if ($this$flow2.emit(progress, c40571) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            th3 = th5;
                            outputStream2 = fileOutputStream2;
                            deleteFile2 = deleteFile3;
                            data2 = bArr;
                            $result3 = $result4;
                            progressBytes = progressBytes2;
                        } else {
                            if (progressBytes < totalBytes) {
                                throw new Exception("missing bytes");
                            }
                            if (progressBytes > totalBytes) {
                                throw new Exception("too many bytes");
                            }
                            deleteFile2.element = false;
                            Unit unit3 = Unit.INSTANCE;
                            CloseableKt.closeFinally(fileOutputStream, th3);
                            Unit unit4 = Unit.INSTANCE;
                            CloseableKt.closeFinally(closeable, th4);
                            c40571.L$0 = deleteFile2;
                            c40571.L$1 = null;
                            c40571.L$2 = null;
                            c40571.L$3 = null;
                            c40571.L$4 = null;
                            c40571.L$5 = null;
                            c40571.L$6 = null;
                            c40571.label = 3;
                            if ($this$flow2.emit(new DownloadStatus.Finished(c40571.$saveFile), c40571) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        throw th2;
                    }
                    if (deleteFile2.element) {
                        c40571.$saveFile.delete();
                    }
                    return Unit.INSTANCE;
                case 2:
                    c40571 = this;
                    $result3 = $result;
                    outputStream2 = null;
                    data2 = null;
                    long progressBytes3 = c40571.J$1;
                    totalBytes = c40571.J$0;
                    data = (byte[]) c40571.L$6;
                    outputStream = (FileOutputStream) c40571.L$5;
                    fileOutputStream = (Closeable) c40571.L$4;
                    inputStream = (InputStream) c40571.L$3;
                    closeable = (Closeable) c40571.L$2;
                    deleteFile2 = (Ref.BooleanRef) c40571.L$1;
                    $this$flow2 = (FlowCollector) c40571.L$0;
                    try {
                        ResultKt.throwOnFailure($result3);
                        progressBytes = progressBytes3;
                        th3 = null;
                        th4 = null;
                        while (true) {
                            bytes = inputStream.read(data);
                            $result4 = $result3;
                            fileOutputStream2 = outputStream2;
                            if (bytes == -1) {
                                outputStream.getChannel();
                                outputStream.write(data, 0, bytes);
                                deleteFile3 = deleteFile2;
                                progressBytes2 = progressBytes + ((long) bytes);
                                bArr = data2;
                                th5 = th3;
                                progress = new DownloadStatus.Progress((int) ((((long) 100) * progressBytes2) / totalBytes));
                                c40571.L$0 = $this$flow2;
                                c40571.L$1 = deleteFile3;
                                c40571.L$2 = closeable;
                                c40571.L$3 = inputStream;
                                c40571.L$4 = fileOutputStream;
                                c40571.L$5 = outputStream;
                                c40571.L$6 = data;
                                c40571.J$0 = totalBytes;
                                c40571.J$1 = progressBytes2;
                                c40571.label = 2;
                                if ($this$flow2.emit(progress, c40571) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                th3 = th5;
                                outputStream2 = fileOutputStream2;
                                deleteFile2 = deleteFile3;
                                data2 = bArr;
                                $result3 = $result4;
                                progressBytes = progressBytes2;
                            } else {
                                if (progressBytes < totalBytes) {
                                    throw new Exception("missing bytes");
                                }
                                if (progressBytes > totalBytes) {
                                    throw new Exception("too many bytes");
                                }
                                deleteFile2.element = false;
                                Unit unit5 = Unit.INSTANCE;
                                CloseableKt.closeFinally(fileOutputStream, th3);
                                Unit unit6 = Unit.INSTANCE;
                                CloseableKt.closeFinally(closeable, th4);
                                c40571.L$0 = deleteFile2;
                                c40571.L$1 = null;
                                c40571.L$2 = null;
                                c40571.L$3 = null;
                                c40571.L$4 = null;
                                c40571.L$5 = null;
                                c40571.L$6 = null;
                                c40571.label = 3;
                                if ($this$flow2.emit(new DownloadStatus.Finished(c40571.$saveFile), c40571) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            throw th2;
                        }
                        if (deleteFile2.element) {
                            c40571.$saveFile.delete();
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th20) {
                        th2 = th20;
                    }
                    break;
                case 3:
                    c40571 = this;
                    deleteFile2 = (Ref.BooleanRef) c40571.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        if (deleteFile2.element) {
                            c40571.$saveFile.delete();
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th21) {
                        th = th21;
                        if (deleteFile2.element) {
                            c40571.$saveFile.delete();
                        }
                        throw th;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<DownloadStatus> downloadFileWithProgress(ResponseBody $this$downloadFileWithProgress, File saveFile) {
        return FlowKt.distinctUntilChanged(FlowKt.flowOn(FlowKt.flow(new C40571($this$downloadFileWithProgress, saveFile, null)), Dispatchers.getIO()));
    }

    /* JADX INFO: compiled from: UpdateUtil.kt */
    @Metadata(m194d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 @2\u00020\u0001:\u0002?@B\u0083\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013Bw\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0014J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0080\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\t2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u0003HÖ\u0001J\t\u00106\u001a\u00020\u0005HÖ\u0001J&\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=HÁ\u0001¢\u0006\u0002\b>R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0018R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R \u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001e\u0012\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001dR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u0018R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001a\u001a\u0004\b'\u0010\u0018¨\u0006A"}, m195d2 = {"Lcom/videshkarmakar/loop/util/UpdateUtil$LatestRelease;", "", "seen1", "", "htmlUrl", "", "tagName", "name", "draft", "", "preRelease", "createdAt", "publishedAt", "assets", "", "Lcom/videshkarmakar/loop/util/UpdateUtil$AssetsItem;", "body", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getAssets", "()Ljava/util/List;", "getBody", "()Ljava/lang/String;", "getCreatedAt$annotations", "()V", "getCreatedAt", "getDraft", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHtmlUrl$annotations", "getHtmlUrl", "getName", "getPreRelease$annotations", "getPreRelease", "getPublishedAt$annotations", "getPublishedAt", "getTagName$annotations", "getTagName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/videshkarmakar/loop/util/UpdateUtil$LatestRelease;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @Serializable
    public static final /* data */ class LatestRelease {
        private final List<AssetsItem> assets;
        private final String body;
        private final String createdAt;
        private final Boolean draft;
        private final String htmlUrl;
        private final String name;
        private final Boolean preRelease;
        private final String publishedAt;
        private final String tagName;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, new ArrayListSerializer(UpdateUtil$AssetsItem$$serializer.INSTANCE), null};

        public LatestRelease() {
            this((String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (List) null, (String) null, 511, (DefaultConstructorMarker) null);
        }

        @SerialName("created_at")
        public static /* synthetic */ void getCreatedAt$annotations() {
        }

        @SerialName("html_url")
        public static /* synthetic */ void getHtmlUrl$annotations() {
        }

        @SerialName("prerelease")
        public static /* synthetic */ void getPreRelease$annotations() {
        }

        @SerialName("published_at")
        public static /* synthetic */ void getPublishedAt$annotations() {
        }

        @SerialName("tag_name")
        public static /* synthetic */ void getTagName$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getHtmlUrl() {
            return this.htmlUrl;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTagName() {
            return this.tagName;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getDraft() {
            return this.draft;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Boolean getPreRelease() {
            return this.preRelease;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getCreatedAt() {
            return this.createdAt;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getPublishedAt() {
            return this.publishedAt;
        }

        public final List<AssetsItem> component8() {
            return this.assets;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getBody() {
            return this.body;
        }

        public final LatestRelease copy(String htmlUrl, String tagName, String name, Boolean draft, Boolean preRelease, String createdAt, String publishedAt, List<AssetsItem> assets, String body) {
            return new LatestRelease(htmlUrl, tagName, name, draft, preRelease, createdAt, publishedAt, assets, body);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LatestRelease)) {
                return false;
            }
            LatestRelease latestRelease = (LatestRelease) other;
            return Intrinsics.areEqual(this.htmlUrl, latestRelease.htmlUrl) && Intrinsics.areEqual(this.tagName, latestRelease.tagName) && Intrinsics.areEqual(this.name, latestRelease.name) && Intrinsics.areEqual(this.draft, latestRelease.draft) && Intrinsics.areEqual(this.preRelease, latestRelease.preRelease) && Intrinsics.areEqual(this.createdAt, latestRelease.createdAt) && Intrinsics.areEqual(this.publishedAt, latestRelease.publishedAt) && Intrinsics.areEqual(this.assets, latestRelease.assets) && Intrinsics.areEqual(this.body, latestRelease.body);
        }

        public int hashCode() {
            return ((((((((((((((((this.htmlUrl == null ? 0 : this.htmlUrl.hashCode()) * 31) + (this.tagName == null ? 0 : this.tagName.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.draft == null ? 0 : this.draft.hashCode())) * 31) + (this.preRelease == null ? 0 : this.preRelease.hashCode())) * 31) + (this.createdAt == null ? 0 : this.createdAt.hashCode())) * 31) + (this.publishedAt == null ? 0 : this.publishedAt.hashCode())) * 31) + (this.assets == null ? 0 : this.assets.hashCode())) * 31) + (this.body != null ? this.body.hashCode() : 0);
        }

        public String toString() {
            return "LatestRelease(htmlUrl=" + this.htmlUrl + ", tagName=" + this.tagName + ", name=" + this.name + ", draft=" + this.draft + ", preRelease=" + this.preRelease + ", createdAt=" + this.createdAt + ", publishedAt=" + this.publishedAt + ", assets=" + this.assets + ", body=" + this.body + ")";
        }

        /* JADX INFO: compiled from: UpdateUtil.kt */
        @Metadata(m194d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m195d2 = {"Lcom/videshkarmakar/loop/util/UpdateUtil$LatestRelease$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/videshkarmakar/loop/util/UpdateUtil$LatestRelease;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<LatestRelease> serializer() {
                return new GeneratedSerializer<LatestRelease>() { // from class: com.videshkarmakar.loop.util.UpdateUtil$LatestRelease$$serializer
                    public static final int $stable = 0;
                    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

                    static {
                        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.videshkarmakar.loop.util.UpdateUtil.LatestRelease", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN 
                              (wrap com.videshkarmakar.loop.util.UpdateUtil$LatestRelease$$serializer:0x0002: SGET  A[WRAPPED] (LINE:221) com.videshkarmakar.loop.util.UpdateUtil$LatestRelease$$serializer.INSTANCE com.videshkarmakar.loop.util.UpdateUtil$LatestRelease$$serializer)
                             (LINE:221) in method: com.videshkarmakar.loop.util.UpdateUtil.LatestRelease.Companion.serializer():kotlinx.serialization.KSerializer<com.videshkarmakar.loop.util.UpdateUtil$LatestRelease>, file: classes10.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:348)
                            	... 5 more
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: CONSTRUCTOR (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.internal.PluginGeneratedSerialDescriptor) = 
                              ("com.videshkarmakar.loop.util.UpdateUtil.LatestRelease")
                              (wrap com.videshkarmakar.loop.util.UpdateUtil$LatestRelease$$serializer:0x0009: SGET  A[WRAPPED] com.videshkarmakar.loop.util.UpdateUtil$LatestRelease$$serializer.INSTANCE com.videshkarmakar.loop.util.UpdateUtil$LatestRelease$$serializer)
                              (9 int)
                             A[DECLARE_VAR, MD:(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer<?>, int):void (m)] (LINE:221) call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: com.videshkarmakar.loop.util.UpdateUtil$LatestRelease$$serializer.<clinit>():void, file: classes10.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                            	... 5 more
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: com.videshkarmakar.loop.util.UpdateUtil$LatestRelease$$serializer
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:813)
                            	at jadx.core.codegen.InsnGen.staticField(InsnGen.java:225)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:492)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:782)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                            	... 15 more
                            */
                        /*
                            this = this;
                            com.videshkarmakar.loop.util.UpdateUtil$LatestRelease$$serializer r0 = com.videshkarmakar.loop.util.UpdateUtil$LatestRelease$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.videshkarmakar.loop.util.UpdateUtil.LatestRelease.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
                public /* synthetic */ LatestRelease(int seen1, @SerialName("html_url") String htmlUrl, @SerialName("tag_name") String tagName, String name, Boolean draft, @SerialName("prerelease") Boolean preRelease, @SerialName("created_at") String createdAt, @SerialName("published_at") String publishedAt, List assets, String body, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen1 & 1) == 0) {
                        this.htmlUrl = null;
                    } else {
                        this.htmlUrl = htmlUrl;
                    }
                    if ((seen1 & 2) == 0) {
                        this.tagName = null;
                    } else {
                        this.tagName = tagName;
                    }
                    if ((seen1 & 4) == 0) {
                        this.name = null;
                    } else {
                        this.name = name;
                    }
                    if ((seen1 & 8) == 0) {
                        this.draft = null;
                    } else {
                        this.draft = draft;
                    }
                    if ((seen1 & 16) == 0) {
                        this.preRelease = null;
                    } else {
                        this.preRelease = preRelease;
                    }
                    if ((seen1 & 32) == 0) {
                        this.createdAt = null;
                    } else {
                        this.createdAt = createdAt;
                    }
                    if ((seen1 & 64) == 0) {
                        this.publishedAt = null;
                    } else {
                        this.publishedAt = publishedAt;
                    }
                    if ((seen1 & 128) == 0) {
                        this.assets = null;
                    } else {
                        this.assets = assets;
                    }
                    if ((seen1 & 256) == 0) {
                        this.body = null;
                    } else {
                        this.body = body;
                    }
                }

                public LatestRelease(String htmlUrl, String tagName, String name, Boolean draft, Boolean preRelease, String createdAt, String publishedAt, List<AssetsItem> list, String body) {
                    this.htmlUrl = htmlUrl;
                    this.tagName = tagName;
                    this.name = name;
                    this.draft = draft;
                    this.preRelease = preRelease;
                    this.createdAt = createdAt;
                    this.publishedAt = publishedAt;
                    this.assets = list;
                    this.body = body;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$app_debug(LatestRelease self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    KSerializer<Object>[] kSerializerArr = $childSerializers;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.htmlUrl != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.htmlUrl);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.tagName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.tagName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.name != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.name);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.draft != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.draft);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.preRelease != null) {
                        output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.preRelease);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.createdAt != null) {
                        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.createdAt);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 6) || self.publishedAt != null) {
                        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.publishedAt);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 7) || self.assets != null) {
                        output.encodeNullableSerializableElement(serialDesc, 7, kSerializerArr[7], self.assets);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 8) || self.body != null) {
                        output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.body);
                    }
                }

                public /* synthetic */ LatestRelease(String str, String str2, String str3, Boolean bool, Boolean bool2, String str4, String str5, List list, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : bool2, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : list, (i & 256) == 0 ? str6 : null);
                }

                public final String getHtmlUrl() {
                    return this.htmlUrl;
                }

                public final String getTagName() {
                    return this.tagName;
                }

                public final String getName() {
                    return this.name;
                }

                public final Boolean getDraft() {
                    return this.draft;
                }

                public final Boolean getPreRelease() {
                    return this.preRelease;
                }

                public final String getCreatedAt() {
                    return this.createdAt;
                }

                public final String getPublishedAt() {
                    return this.publishedAt;
                }

                public final List<AssetsItem> getAssets() {
                    return this.assets;
                }

                public final String getBody() {
                    return this.body;
                }
            }

            /* JADX INFO: compiled from: UpdateUtil.kt */
            @Metadata(m194d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 72\u00020\u0001:\u000267Bi\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eBY\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jb\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001J&\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204HÁ\u0001¢\u0006\u0002\b5R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001aR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013¨\u00068"}, m195d2 = {"Lcom/videshkarmakar/loop/util/UpdateUtil$AssetsItem;", "", "seen1", "", "name", "", "contentType", "size", "downloadCount", "createdAt", "updatedAt", "browserDownloadUrl", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrowserDownloadUrl$annotations", "()V", "getBrowserDownloadUrl", "()Ljava/lang/String;", "getContentType$annotations", "getContentType", "getCreatedAt$annotations", "getCreatedAt", "getDownloadCount$annotations", "getDownloadCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "getSize", "getUpdatedAt$annotations", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/videshkarmakar/loop/util/UpdateUtil$AssetsItem;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @Serializable
            public static final /* data */ class AssetsItem {
                public static final int $stable = 0;

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion(null);
                private final String browserDownloadUrl;
                private final String contentType;
                private final String createdAt;
                private final Integer downloadCount;
                private final String name;
                private final Integer size;
                private final String updatedAt;

                public AssetsItem() {
                    this((String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ AssetsItem copy$default(AssetsItem assetsItem, String str, String str2, Integer num, Integer num2, String str3, String str4, String str5, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = assetsItem.name;
                    }
                    if ((i & 2) != 0) {
                        str2 = assetsItem.contentType;
                    }
                    String str6 = str2;
                    if ((i & 4) != 0) {
                        num = assetsItem.size;
                    }
                    Integer num3 = num;
                    if ((i & 8) != 0) {
                        num2 = assetsItem.downloadCount;
                    }
                    Integer num4 = num2;
                    if ((i & 16) != 0) {
                        str3 = assetsItem.createdAt;
                    }
                    String str7 = str3;
                    if ((i & 32) != 0) {
                        str4 = assetsItem.updatedAt;
                    }
                    String str8 = str4;
                    if ((i & 64) != 0) {
                        str5 = assetsItem.browserDownloadUrl;
                    }
                    return assetsItem.copy(str, str6, num3, num4, str7, str8, str5);
                }

                @SerialName("browser_download_url")
                public static /* synthetic */ void getBrowserDownloadUrl$annotations() {
                }

                @SerialName("content_type")
                public static /* synthetic */ void getContentType$annotations() {
                }

                @SerialName("created_at")
                public static /* synthetic */ void getCreatedAt$annotations() {
                }

                @SerialName("download_count")
                public static /* synthetic */ void getDownloadCount$annotations() {
                }

                @SerialName("updated_at")
                public static /* synthetic */ void getUpdatedAt$annotations() {
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final String getName() {
                    return this.name;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final String getContentType() {
                    return this.contentType;
                }

                /* JADX INFO: renamed from: component3, reason: from getter */
                public final Integer getSize() {
                    return this.size;
                }

                /* JADX INFO: renamed from: component4, reason: from getter */
                public final Integer getDownloadCount() {
                    return this.downloadCount;
                }

                /* JADX INFO: renamed from: component5, reason: from getter */
                public final String getCreatedAt() {
                    return this.createdAt;
                }

                /* JADX INFO: renamed from: component6, reason: from getter */
                public final String getUpdatedAt() {
                    return this.updatedAt;
                }

                /* JADX INFO: renamed from: component7, reason: from getter */
                public final String getBrowserDownloadUrl() {
                    return this.browserDownloadUrl;
                }

                public final AssetsItem copy(String name, String contentType, Integer size, Integer downloadCount, String createdAt, String updatedAt, String browserDownloadUrl) {
                    return new AssetsItem(name, contentType, size, downloadCount, createdAt, updatedAt, browserDownloadUrl);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof AssetsItem)) {
                        return false;
                    }
                    AssetsItem assetsItem = (AssetsItem) other;
                    return Intrinsics.areEqual(this.name, assetsItem.name) && Intrinsics.areEqual(this.contentType, assetsItem.contentType) && Intrinsics.areEqual(this.size, assetsItem.size) && Intrinsics.areEqual(this.downloadCount, assetsItem.downloadCount) && Intrinsics.areEqual(this.createdAt, assetsItem.createdAt) && Intrinsics.areEqual(this.updatedAt, assetsItem.updatedAt) && Intrinsics.areEqual(this.browserDownloadUrl, assetsItem.browserDownloadUrl);
                }

                public int hashCode() {
                    return ((((((((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.contentType == null ? 0 : this.contentType.hashCode())) * 31) + (this.size == null ? 0 : this.size.hashCode())) * 31) + (this.downloadCount == null ? 0 : this.downloadCount.hashCode())) * 31) + (this.createdAt == null ? 0 : this.createdAt.hashCode())) * 31) + (this.updatedAt == null ? 0 : this.updatedAt.hashCode())) * 31) + (this.browserDownloadUrl != null ? this.browserDownloadUrl.hashCode() : 0);
                }

                public String toString() {
                    return "AssetsItem(name=" + this.name + ", contentType=" + this.contentType + ", size=" + this.size + ", downloadCount=" + this.downloadCount + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", browserDownloadUrl=" + this.browserDownloadUrl + ")";
                }

                /* JADX INFO: compiled from: UpdateUtil.kt */
                @Metadata(m194d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m195d2 = {"Lcom/videshkarmakar/loop/util/UpdateUtil$AssetsItem$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/videshkarmakar/loop/util/UpdateUtil$AssetsItem;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<AssetsItem> serializer() {
                        return UpdateUtil$AssetsItem$$serializer.INSTANCE;
                    }
                }

                @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
                public /* synthetic */ AssetsItem(int seen1, String name, @SerialName("content_type") String contentType, Integer size, @SerialName("download_count") Integer downloadCount, @SerialName("created_at") String createdAt, @SerialName("updated_at") String updatedAt, @SerialName("browser_download_url") String browserDownloadUrl, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen1 & 1) == 0) {
                        this.name = null;
                    } else {
                        this.name = name;
                    }
                    if ((seen1 & 2) == 0) {
                        this.contentType = null;
                    } else {
                        this.contentType = contentType;
                    }
                    if ((seen1 & 4) == 0) {
                        this.size = null;
                    } else {
                        this.size = size;
                    }
                    if ((seen1 & 8) == 0) {
                        this.downloadCount = null;
                    } else {
                        this.downloadCount = downloadCount;
                    }
                    if ((seen1 & 16) == 0) {
                        this.createdAt = null;
                    } else {
                        this.createdAt = createdAt;
                    }
                    if ((seen1 & 32) == 0) {
                        this.updatedAt = null;
                    } else {
                        this.updatedAt = updatedAt;
                    }
                    if ((seen1 & 64) == 0) {
                        this.browserDownloadUrl = null;
                    } else {
                        this.browserDownloadUrl = browserDownloadUrl;
                    }
                }

                public AssetsItem(String name, String contentType, Integer size, Integer downloadCount, String createdAt, String updatedAt, String browserDownloadUrl) {
                    this.name = name;
                    this.contentType = contentType;
                    this.size = size;
                    this.downloadCount = downloadCount;
                    this.createdAt = createdAt;
                    this.updatedAt = updatedAt;
                    this.browserDownloadUrl = browserDownloadUrl;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$app_debug(AssetsItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.name != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.name);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.contentType != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.contentType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.size != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.size);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.downloadCount != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.downloadCount);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.createdAt != null) {
                        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.createdAt);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.updatedAt != null) {
                        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.updatedAt);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 6) || self.browserDownloadUrl != null) {
                        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.browserDownloadUrl);
                    }
                }

                public /* synthetic */ AssetsItem(String str, String str2, Integer num, Integer num2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5);
                }

                public final String getName() {
                    return this.name;
                }

                public final String getContentType() {
                    return this.contentType;
                }

                public final Integer getSize() {
                    return this.size;
                }

                public final Integer getDownloadCount() {
                    return this.downloadCount;
                }

                public final String getCreatedAt() {
                    return this.createdAt;
                }

                public final String getUpdatedAt() {
                    return this.updatedAt;
                }

                public final String getBrowserDownloadUrl() {
                    return this.browserDownloadUrl;
                }
            }

            /* JADX INFO: compiled from: UpdateUtil.kt */
            @Metadata(m194d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m195d2 = {"Lcom/videshkarmakar/loop/util/UpdateUtil$DownloadStatus;", "", "()V", "Finished", "NotYet", "Progress", "Lcom/videshkarmakar/loop/util/UpdateUtil$DownloadStatus$Finished;", "Lcom/videshkarmakar/loop/util/UpdateUtil$DownloadStatus$NotYet;", "Lcom/videshkarmakar/loop/util/UpdateUtil$DownloadStatus$Progress;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public static abstract class DownloadStatus {
                public static final int $stable = 0;

                public /* synthetic */ DownloadStatus(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                /* JADX INFO: compiled from: UpdateUtil.kt */
                @Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m195d2 = {"Lcom/videshkarmakar/loop/util/UpdateUtil$DownloadStatus$NotYet;", "Lcom/videshkarmakar/loop/util/UpdateUtil$DownloadStatus;", "()V", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                public static final class NotYet extends DownloadStatus {
                    public static final int $stable = 0;
                    public static final NotYet INSTANCE = new NotYet();

                    private NotYet() {
                        super(null);
                    }
                }

                private DownloadStatus() {
                }

                /* JADX INFO: compiled from: UpdateUtil.kt */
                @Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m195d2 = {"Lcom/videshkarmakar/loop/util/UpdateUtil$DownloadStatus$Progress;", "Lcom/videshkarmakar/loop/util/UpdateUtil$DownloadStatus;", "percent", "", "(I)V", "getPercent", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                public static final /* data */ class Progress extends DownloadStatus {
                    public static final int $stable = 0;
                    private final int percent;

                    public static /* synthetic */ Progress copy$default(Progress progress, int i, int i2, Object obj) {
                        if ((i2 & 1) != 0) {
                            i = progress.percent;
                        }
                        return progress.copy(i);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final int getPercent() {
                        return this.percent;
                    }

                    public final Progress copy(int percent) {
                        return new Progress(percent);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        return (other instanceof Progress) && this.percent == ((Progress) other).percent;
                    }

                    public int hashCode() {
                        return this.percent;
                    }

                    public String toString() {
                        return "Progress(percent=" + this.percent + ")";
                    }

                    public Progress(int percent) {
                        super(null);
                        this.percent = percent;
                    }

                    public final int getPercent() {
                        return this.percent;
                    }
                }

                /* JADX INFO: compiled from: UpdateUtil.kt */
                @Metadata(m194d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m195d2 = {"Lcom/videshkarmakar/loop/util/UpdateUtil$DownloadStatus$Finished;", "Lcom/videshkarmakar/loop/util/UpdateUtil$DownloadStatus;", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                public static final /* data */ class Finished extends DownloadStatus {
                    public static final int $stable = 8;
                    private final File file;

                    public static /* synthetic */ Finished copy$default(Finished finished, File file, int i, Object obj) {
                        if ((i & 1) != 0) {
                            file = finished.file;
                        }
                        return finished.copy(file);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final File getFile() {
                        return this.file;
                    }

                    public final Finished copy(File file) {
                        Intrinsics.checkNotNullParameter(file, "file");
                        return new Finished(file);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        return (other instanceof Finished) && Intrinsics.areEqual(this.file, ((Finished) other).file);
                    }

                    public int hashCode() {
                        return this.file.hashCode();
                    }

                    public String toString() {
                        return "Finished(file=" + this.file + ")";
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public Finished(File file) {
                        super(null);
                        Intrinsics.checkNotNullParameter(file, "file");
                        this.file = file;
                    }

                    public final File getFile() {
                        return this.file;
                    }
                }
            }

            public final Version toVersion(String $this$toVersion) {
                Version.Stable releaseCandidate;
                int major;
                int minor;
                int patch;
                if ($this$toVersion != null) {
                    Matcher matcher = pattern.matcher($this$toVersion);
                    if (matcher.find()) {
                        String strGroup = matcher.group(1);
                        int buildNumber = 0;
                        if (strGroup != null) {
                            Intrinsics.checkNotNull(strGroup);
                            major = Integer.parseInt(strGroup);
                        } else {
                            major = 0;
                        }
                        String strGroup2 = matcher.group(2);
                        if (strGroup2 != null) {
                            Intrinsics.checkNotNull(strGroup2);
                            minor = Integer.parseInt(strGroup2);
                        } else {
                            minor = 0;
                        }
                        String strGroup3 = matcher.group(3);
                        if (strGroup3 != null) {
                            Intrinsics.checkNotNull(strGroup3);
                            patch = Integer.parseInt(strGroup3);
                        } else {
                            patch = 0;
                        }
                        String strGroup4 = matcher.group(6);
                        if (strGroup4 != null) {
                            Intrinsics.checkNotNull(strGroup4);
                            buildNumber = Integer.parseInt(strGroup4);
                        }
                        String strGroup5 = matcher.group(5);
                        if (Intrinsics.areEqual(strGroup5, "beta")) {
                            releaseCandidate = new Version.Beta(major, minor, patch, buildNumber);
                        } else {
                            releaseCandidate = Intrinsics.areEqual(strGroup5, "rc") ? new Version.ReleaseCandidate(major, minor, patch, buildNumber) : new Version.Stable(major, minor, patch);
                        }
                    } else {
                        releaseCandidate = EMPTY_VERSION;
                    }
                    if (releaseCandidate != null) {
                        return releaseCandidate;
                    }
                }
                return EMPTY_VERSION;
            }

            /* JADX INFO: compiled from: UpdateUtil.kt */
            @Metadata(m194d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0005\u0013\u0014\u0015\u0016\u0017B)\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u0082\u0001\u0004\u0018\u0019\u001a\u001b¨\u0006\u001c"}, m195d2 = {"Lcom/videshkarmakar/loop/util/UpdateUtil$Version;", "", "major", "", "minor", "patch", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "(IIII)V", "getBuild", "()I", "getMajor", "getMinor", "getPatch", "compareTo", "other", "toNumber", "", "toVersionName", "", "Alpha", "Beta", "Companion", "ReleaseCandidate", "Stable", "Lcom/videshkarmakar/loop/util/UpdateUtil$Version$Alpha;", "Lcom/videshkarmakar/loop/util/UpdateUtil$Version$Beta;", "Lcom/videshkarmakar/loop/util/UpdateUtil$Version$ReleaseCandidate;", "Lcom/videshkarmakar/loop/util/UpdateUtil$Version$Stable;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public static abstract class Version implements Comparable<Version> {
                public static final int $stable = 0;
                private static final long BUILD = 1;
                private static final long MAJOR = 1000000;
                private static final long MINOR = 10000;
                private static final long PATCH = 100;
                private final int build;
                private final int major;
                private final int minor;
                private final int patch;

                public /* synthetic */ Version(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
                    this(i, i2, i3, i4);
                }

                public abstract long toNumber();

                public abstract String toVersionName();

                private Version(int major, int minor, int patch, int build) {
                    this.major = major;
                    this.minor = minor;
                    this.patch = patch;
                    this.build = build;
                }

                public /* synthetic */ Version(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
                    this(i, i2, i3, (i5 & 8) != 0 ? 0 : i4, null);
                }

                public final int getMajor() {
                    return this.major;
                }

                public final int getMinor() {
                    return this.minor;
                }

                public final int getPatch() {
                    return this.patch;
                }

                public final int getBuild() {
                    return this.build;
                }

                /* JADX INFO: compiled from: UpdateUtil.kt */
                @Metadata(m194d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, m195d2 = {"Lcom/videshkarmakar/loop/util/UpdateUtil$Version$Beta;", "Lcom/videshkarmakar/loop/util/UpdateUtil$Version;", "versionMajor", "", "versionMinor", "versionPatch", "versionBuild", "(IIII)V", "toNumber", "", "toVersionName", "", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                public static final class Beta extends Version {
                    public static final int $stable = 0;

                    public Beta(int versionMajor, int versionMinor, int versionPatch, int versionBuild) {
                        super(versionMajor, versionMinor, versionPatch, versionBuild, null);
                    }

                    @Override // com.videshkarmakar.loop.util.UpdateUtil.Version
                    public String toVersionName() {
                        return getMajor() + "." + getMinor() + "." + getPatch() + "-beta." + getBuild();
                    }

                    @Override // com.videshkarmakar.loop.util.UpdateUtil.Version
                    public long toNumber() {
                        return (((long) getMajor()) * 1000000) + (((long) getMinor()) * Version.MINOR) + (((long) getPatch()) * Version.PATCH) + (((long) getBuild()) * 1);
                    }
                }

                /* JADX INFO: compiled from: UpdateUtil.kt */
                @Metadata(m194d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, m195d2 = {"Lcom/videshkarmakar/loop/util/UpdateUtil$Version$Stable;", "Lcom/videshkarmakar/loop/util/UpdateUtil$Version;", "versionMajor", "", "versionMinor", "versionPatch", "(III)V", "toNumber", "", "toVersionName", "", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                public static final class Stable extends Version {
                    public static final int $stable = 0;

                    public Stable() {
                        this(0, 0, 0, 7, null);
                    }

                    public /* synthetic */ Stable(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
                    }

                    public Stable(int versionMajor, int versionMinor, int versionPatch) {
                        super(versionMajor, versionMinor, versionPatch, 0, 8, null);
                    }

                    @Override // com.videshkarmakar.loop.util.UpdateUtil.Version
                    public String toVersionName() {
                        return getMajor() + "." + getMinor() + "." + getPatch();
                    }

                    @Override // com.videshkarmakar.loop.util.UpdateUtil.Version
                    public long toNumber() {
                        return (((long) getMajor()) * 1000000) + (((long) getMinor()) * Version.MINOR) + (((long) getPatch()) * Version.PATCH) + (((long) getBuild()) * 1) + ((long) 100);
                    }
                }

                /* JADX INFO: compiled from: UpdateUtil.kt */
                @Metadata(m194d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, m195d2 = {"Lcom/videshkarmakar/loop/util/UpdateUtil$Version$ReleaseCandidate;", "Lcom/videshkarmakar/loop/util/UpdateUtil$Version;", "versionMajor", "", "versionMinor", "versionPatch", "versionBuild", "(IIII)V", "toNumber", "", "toVersionName", "", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                public static final class ReleaseCandidate extends Version {
                    public static final int $stable = 0;

                    public ReleaseCandidate(int versionMajor, int versionMinor, int versionPatch, int versionBuild) {
                        super(versionMajor, versionMinor, versionPatch, versionBuild, null);
                    }

                    @Override // com.videshkarmakar.loop.util.UpdateUtil.Version
                    public String toVersionName() {
                        return getMajor() + "." + getMinor() + "." + getPatch() + "-rc." + getBuild();
                    }

                    @Override // com.videshkarmakar.loop.util.UpdateUtil.Version
                    public long toNumber() {
                        return (((long) getMajor()) * 1000000) + (((long) getMinor()) * Version.MINOR) + (((long) getPatch()) * Version.PATCH) + (((long) getBuild()) * 1) + ((long) 25);
                    }
                }

                /* JADX INFO: compiled from: UpdateUtil.kt */
                @Metadata(m194d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, m195d2 = {"Lcom/videshkarmakar/loop/util/UpdateUtil$Version$Alpha;", "Lcom/videshkarmakar/loop/util/UpdateUtil$Version;", "versionMajor", "", "versionMinor", "versionPatch", "(III)V", "toNumber", "", "toVersionName", "", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                public static final class Alpha extends Version {
                    public static final int $stable = 0;

                    public Alpha() {
                        this(0, 0, 0, 7, null);
                    }

                    public /* synthetic */ Alpha(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
                    }

                    public Alpha(int versionMajor, int versionMinor, int versionPatch) {
                        super(versionMajor, versionMinor, versionPatch, 0, 8, null);
                    }

                    @Override // com.videshkarmakar.loop.util.UpdateUtil.Version
                    public String toVersionName() {
                        return getMajor() + "." + getMinor() + "." + getPatch() + "-alpha." + getBuild();
                    }

                    @Override // com.videshkarmakar.loop.util.UpdateUtil.Version
                    public long toNumber() {
                        return (((long) getMajor()) * 1000000) + (((long) getMinor()) * Version.MINOR) + (((long) getPatch()) * Version.PATCH) + (((long) getBuild()) * 1) + ((long) 50);
                    }
                }

                @Override // java.lang.Comparable
                public int compareTo(Version other) {
                    Intrinsics.checkNotNullParameter(other, "other");
                    return Intrinsics.compare(toNumber(), other.toNumber());
                }
            }
        }
