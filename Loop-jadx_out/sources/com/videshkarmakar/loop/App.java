package com.videshkarmakar.loop;

import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.google.android.material.color.DynamicColors;
import com.tencent.mmkv.MMKV;
import com.videshkarmakar.loop.p006ui.page.settings.directory.Directory;
import com.videshkarmakar.loop.util.DownloadUtil;
import com.videshkarmakar.loop.util.FileUtil;
import com.videshkarmakar.loop.util.NotificationUtil;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import com.videshkarmakar.loop.util.UpdateUtil;
import com.yausername.aria2c.Aria2c;
import com.yausername.ffmpeg.FFmpeg;
import com.yausername.youtubedl_android.YoutubeDL;
import dagger.hilt.android.HiltAndroidApp;
import java.io.File;
import java.util.Arrays;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.apache.commons.p013io.IOUtils;

/* JADX INFO: compiled from: App.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m194d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\t"}, m195d2 = {"Lcom/videshkarmakar/loop/App;", "Landroid/app/Application;", "()V", "onCreate", "", "startCrashReportActivity", "th", "", "Companion", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@HiltAndroidApp
public final class App extends Hilt_App {
    public static final int $stable = 0;
    public static CoroutineScope applicationScope;
    public static String audioDownloadDir;
    public static ClipboardManager clipboard;
    public static ConnectivityManager connectivityManager;
    public static Context context;
    private static boolean isServiceRunning;
    public static PackageInfo packageInfo;
    public static String videoDownloadDir;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final App$Companion$connection$1 connection = new ServiceConnection() { // from class: com.videshkarmakar.loop.App$Companion$connection$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName className, IBinder service) {
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(service, "service");
            App.INSTANCE.setServiceRunning(true);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName arg0) {
            Intrinsics.checkNotNullParameter(arg0, "arg0");
        }
    };

    @Override // com.videshkarmakar.loop.Hilt_App, android.app.Application
    public void onCreate() throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo2;
        super.onCreate();
        MMKV.initialize(this);
        Companion companion = INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        companion.setContext(applicationContext);
        Companion companion2 = INSTANCE;
        PackageManager $this$onCreate_u24lambda_u240 = getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            packageInfo2 = $this$onCreate_u24lambda_u240.getPackageInfo(getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        } else {
            packageInfo2 = $this$onCreate_u24lambda_u240.getPackageInfo(getPackageName(), 0);
        }
        Intrinsics.checkNotNullExpressionValue(packageInfo2, "run(...)");
        companion2.setPackageInfo(packageInfo2);
        INSTANCE.setApplicationScope(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        DynamicColors.applyToActivitiesIfAvailable(this);
        Companion companion3 = INSTANCE;
        App $this$getSystemService$iv = this;
        Object systemService = ContextCompat.getSystemService($this$getSystemService$iv, ClipboardManager.class);
        Intrinsics.checkNotNull(systemService);
        companion3.setClipboard((ClipboardManager) systemService);
        Companion companion4 = INSTANCE;
        App $this$getSystemService$iv2 = this;
        Object systemService2 = ContextCompat.getSystemService($this$getSystemService$iv2, ConnectivityManager.class);
        Intrinsics.checkNotNull(systemService2);
        companion4.setConnectivityManager((ConnectivityManager) systemService2);
        BuildersKt__Builders_commonKt.launch$default(INSTANCE.getApplicationScope(), Dispatchers.getIO(), null, new C30492(null), 2, null);
        Companion companion5 = INSTANCE;
        PreferenceUtil preferenceUtil = PreferenceUtil.INSTANCE;
        String absolutePath = FileUtil.INSTANCE.getExternalDownloadDirectory$app_debug().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        companion5.setVideoDownloadDir(preferenceUtil.getString(PreferenceUtilKt.VIDEO_DIRECTORY, absolutePath));
        Companion companion6 = INSTANCE;
        PreferenceUtil preferenceUtil2 = PreferenceUtil.INSTANCE;
        String absolutePath2 = new File(INSTANCE.getVideoDownloadDir(), "Audio").getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
        companion6.setAudioDownloadDir(preferenceUtil2.getString(PreferenceUtilKt.AUDIO_DIRECTORY, absolutePath2));
        if (!PreferenceUtil.INSTANCE.containsKey(PreferenceUtilKt.COMMAND_DIRECTORY)) {
            PreferenceUtil.INSTANCE.updateString(PreferenceUtilKt.COMMAND_DIRECTORY, INSTANCE.getVideoDownloadDir());
        }
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationUtil.INSTANCE.createNotificationChannel();
        }
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.videshkarmakar.loop.App$$ExternalSyntheticLambda0
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                App.onCreate$lambda$1(this.f$0, thread, th);
            }
        });
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.App$onCreate$2 */
    /* JADX INFO: compiled from: App.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.App$onCreate$2", m210f = "App.kt", m211i = {}, m212l = {72, 74}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C30492 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C30492(Continuation<? super C30492> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return App.this.new C30492(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C30492) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.videshkarmakar.loop.App$onCreate$2, int] */
        /* JADX WARN: Type inference failed for: r1v1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            ?? r0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r1 = this.label;
            try {
                switch (r1) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        YoutubeDL.INSTANCE.init(App.this);
                        FFmpeg.INSTANCE.init(App.this);
                        Aria2c.INSTANCE.init(App.this);
                        Object objM7674getCookiesContentFromDatabased1pmJ48 = DownloadUtil.INSTANCE.m7674getCookiesContentFromDatabased1pmJ48();
                        if (Result.m7699isFailureimpl(objM7674getCookiesContentFromDatabased1pmJ48)) {
                            objM7674getCookiesContentFromDatabased1pmJ48 = null;
                        }
                        String it = (String) objM7674getCookiesContentFromDatabased1pmJ48;
                        if (it != null) {
                            FileUtil.INSTANCE.writeContentToFile(it, FileUtil.INSTANCE.getCookiesFile(App.this));
                        }
                        this.label = 1;
                        if (UpdateUtil.m7681deleteOutdatedApkgIAlus$default(UpdateUtil.INSTANCE, null, this, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        ((Result) $result).getValue();
                        return Unit.INSTANCE;
                    case 2:
                        r0 = this;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th) {
                r1.label = 2;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(App.this, th, null), (Continuation) r1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                r0 = r1;
            }
        }

        /* JADX INFO: renamed from: com.videshkarmakar.loop.App$onCreate$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: App.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "com.videshkarmakar.loop.App$onCreate$2$2", m210f = "App.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Throwable $th;
            int label;
            final /* synthetic */ App this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(App app, Throwable th, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = app;
                this.$th = th;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$th, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        this.this$0.startCrashReportActivity(this.$th);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(App this$0, Thread thread, Throwable e) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(e);
        this$0.startCrashReportActivity(e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startCrashReportActivity(Throwable th) {
        th.printStackTrace();
        Intent $this$startCrashReportActivity_u24lambda_u242 = new Intent(this, (Class<?>) CrashReportActivity.class).setAction(getPackageName() + ".error_report");
        $this$startCrashReportActivity_u24lambda_u242.setFlags(268435456);
        $this$startCrashReportActivity_u24lambda_u242.putExtra("error_report", INSTANCE.getVersionReport() + IOUtils.LINE_SEPARATOR_UNIX + ExceptionsKt.stackTraceToString(th));
        startActivity($this$startCrashReportActivity_u24lambda_u242);
    }

    /* JADX INFO: compiled from: App.kt */
    @Metadata(m194d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u00104\u001a\u00020\nJ\u0006\u00105\u001a\u00020%J\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u000207J\u0016\u00109\u001a\u0002072\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b0\u0010\fR\u001a\u00101\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\f\"\u0004\b3\u0010\u000e¨\u0006>"}, m195d2 = {"Lcom/videshkarmakar/loop/App$Companion;", "", "()V", "applicationScope", "Lkotlinx/coroutines/CoroutineScope;", "getApplicationScope", "()Lkotlinx/coroutines/CoroutineScope;", "setApplicationScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "audioDownloadDir", "", "getAudioDownloadDir", "()Ljava/lang/String;", "setAudioDownloadDir", "(Ljava/lang/String;)V", "clipboard", "Landroid/content/ClipboardManager;", "getClipboard", "()Landroid/content/ClipboardManager;", "setClipboard", "(Landroid/content/ClipboardManager;)V", "connection", "com/videshkarmakar/loop/App$Companion$connection$1", "Lcom/videshkarmakar/loop/App$Companion$connection$1;", "connectivityManager", "Landroid/net/ConnectivityManager;", "getConnectivityManager", "()Landroid/net/ConnectivityManager;", "setConnectivityManager", "(Landroid/net/ConnectivityManager;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "isServiceRunning", "", "()Z", "setServiceRunning", "(Z)V", "packageInfo", "Landroid/content/pm/PackageInfo;", "getPackageInfo", "()Landroid/content/pm/PackageInfo;", "setPackageInfo", "(Landroid/content/pm/PackageInfo;)V", "privateDownloadDir", "getPrivateDownloadDir", "videoDownloadDir", "getVideoDownloadDir", "setVideoDownloadDir", "getVersionReport", "isFDroidBuild", "startService", "", "stopService", "updateDownloadDir", "uri", "Landroid/net/Uri;", "directoryType", "Lcom/videshkarmakar/loop/ui/page/settings/directory/Directory;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {

        /* JADX INFO: compiled from: App.kt */
        @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Directory.values().length];
                try {
                    iArr[Directory.AUDIO.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[Directory.VIDEO.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[Directory.CUSTOM_COMMAND.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[Directory.SDCARD.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ClipboardManager getClipboard() {
            ClipboardManager clipboardManager = App.clipboard;
            if (clipboardManager != null) {
                return clipboardManager;
            }
            Intrinsics.throwUninitializedPropertyAccessException("clipboard");
            return null;
        }

        public final void setClipboard(ClipboardManager clipboardManager) {
            Intrinsics.checkNotNullParameter(clipboardManager, "<set-?>");
            App.clipboard = clipboardManager;
        }

        public final String getVideoDownloadDir() {
            String str = App.videoDownloadDir;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("videoDownloadDir");
            return null;
        }

        public final void setVideoDownloadDir(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            App.videoDownloadDir = str;
        }

        public final String getAudioDownloadDir() {
            String str = App.audioDownloadDir;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("audioDownloadDir");
            return null;
        }

        public final void setAudioDownloadDir(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            App.audioDownloadDir = str;
        }

        public final CoroutineScope getApplicationScope() {
            CoroutineScope coroutineScope = App.applicationScope;
            if (coroutineScope != null) {
                return coroutineScope;
            }
            Intrinsics.throwUninitializedPropertyAccessException("applicationScope");
            return null;
        }

        public final void setApplicationScope(CoroutineScope coroutineScope) {
            Intrinsics.checkNotNullParameter(coroutineScope, "<set-?>");
            App.applicationScope = coroutineScope;
        }

        public final ConnectivityManager getConnectivityManager() {
            ConnectivityManager connectivityManager = App.connectivityManager;
            if (connectivityManager != null) {
                return connectivityManager;
            }
            Intrinsics.throwUninitializedPropertyAccessException("connectivityManager");
            return null;
        }

        public final void setConnectivityManager(ConnectivityManager connectivityManager) {
            Intrinsics.checkNotNullParameter(connectivityManager, "<set-?>");
            App.connectivityManager = connectivityManager;
        }

        public final PackageInfo getPackageInfo() {
            PackageInfo packageInfo = App.packageInfo;
            if (packageInfo != null) {
                return packageInfo;
            }
            Intrinsics.throwUninitializedPropertyAccessException("packageInfo");
            return null;
        }

        public final void setPackageInfo(PackageInfo packageInfo) {
            Intrinsics.checkNotNullParameter(packageInfo, "<set-?>");
            App.packageInfo = packageInfo;
        }

        public final boolean isServiceRunning() {
            return App.isServiceRunning;
        }

        public final void setServiceRunning(boolean z) {
            App.isServiceRunning = z;
        }

        public final void startService() {
            if (isServiceRunning()) {
                return;
            }
            Intent intent = new Intent(getContext().getApplicationContext(), (Class<?>) DownloadService.class);
            App.INSTANCE.getContext().getApplicationContext().bindService(intent, App.connection, 1);
        }

        public final void stopService() {
            if (isServiceRunning()) {
                try {
                    setServiceRunning(false);
                    Context $this$stopService_u24lambda_u241 = getContext().getApplicationContext();
                    $this$stopService_u24lambda_u241.unbindService(App.connection);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public final String getPrivateDownloadDir() {
            File $this$_get_privateDownloadDir__u24lambda_u242 = FileUtil.INSTANCE.getExternalPrivateDownloadDirectory$app_debug();
            FileUtil.INSTANCE.m7676createEmptyFilegIAlus($this$_get_privateDownloadDir__u24lambda_u242, ".nomedia");
            String absolutePath = $this$_get_privateDownloadDir__u24lambda_u242.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "run(...)");
            return absolutePath;
        }

        public final void updateDownloadDir(Uri uri, Directory directoryType) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(directoryType, "directoryType");
            switch (WhenMappings.$EnumSwitchMapping$0[directoryType.ordinal()]) {
                case 1:
                    String path = FileUtil.INSTANCE.getRealPath(uri);
                    setAudioDownloadDir(path);
                    PreferenceUtil.INSTANCE.encodeString(PreferenceUtilKt.AUDIO_DIRECTORY, path);
                    break;
                case 2:
                    String path2 = FileUtil.INSTANCE.getRealPath(uri);
                    setVideoDownloadDir(path2);
                    PreferenceUtil.INSTANCE.encodeString(PreferenceUtilKt.VIDEO_DIRECTORY, path2);
                    break;
                case 3:
                    FileUtil.INSTANCE.getRealPath(uri);
                    break;
                case 4:
                    ContentResolver contentResolver = getContext().getContentResolver();
                    if (contentResolver != null) {
                        contentResolver.takePersistableUriPermission(uri, 3);
                    }
                    PreferenceUtil preferenceUtil = PreferenceUtil.INSTANCE;
                    String string = uri.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    preferenceUtil.encodeString(PreferenceUtilKt.SDCARD_URI, string);
                    break;
            }
        }

        public final String getVersionReport() {
            long versionCode;
            String release;
            String versionName = getPackageInfo().versionName;
            if (Build.VERSION.SDK_INT >= 28) {
                versionCode = getPackageInfo().getLongVersionCode();
            } else {
                versionCode = getPackageInfo().versionCode;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                release = Build.VERSION.RELEASE_OR_CODENAME;
            } else {
                release = Build.VERSION.RELEASE;
            }
            StringBuilder sbAppend = new StringBuilder().append("App version: " + versionName + " (" + versionCode + ")\n").append("Device information: Android " + release + " (API " + Build.VERSION.SDK_INT + ")\n");
            String string = Arrays.toString(Build.SUPPORTED_ABIS);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            String string2 = sbAppend.append("Supported ABIs: " + string + IOUtils.LINE_SEPARATOR_UNIX).append("Yt-dlp version: " + PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.YT_DLP_VERSION, null, 1, null) + IOUtils.LINE_SEPARATOR_UNIX).toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            return string2;
        }

        public final boolean isFDroidBuild() {
            String versionName = getPackageInfo().versionName;
            Intrinsics.checkNotNullExpressionValue(versionName, "versionName");
            return StringsKt.contains$default((CharSequence) versionName, (CharSequence) "F-Droid", false, 2, (Object) null);
        }

        public final Context getContext() {
            Context context = App.context;
            if (context != null) {
                return context;
            }
            Intrinsics.throwUninitializedPropertyAccessException("context");
            return null;
        }

        public final void setContext(Context context) {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            App.context = context;
        }
    }
}
