package com.videshkarmakar.loop;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.material3.windowsizeclass.AndroidWindowSizeClass_androidKt;
import androidx.compose.material3.windowsizeclass.WindowSizeClass;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.videshkarmakar.loop.p006ui.common.CompositionLocalsKt;
import com.videshkarmakar.loop.p006ui.page.HomeEntryKt;
import com.videshkarmakar.loop.p006ui.page.download.DownloadViewModel;
import com.videshkarmakar.loop.p006ui.page.settings.network.CookiesViewModel;
import com.videshkarmakar.loop.p006ui.theme.ThemeKt;
import com.videshkarmakar.loop.util.DarkThemePreference;
import com.videshkarmakar.loop.util.LanguageSettingsKt;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import com.videshkarmakar.loop.util.TextUtilKt;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m194d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, m195d2 = {"Lcom/videshkarmakar/loop/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "downloadViewModel", "Lcom/videshkarmakar/loop/ui/page/download/DownloadViewModel;", "getDownloadViewModel", "()Lcom/videshkarmakar/loop/ui/page/download/DownloadViewModel;", "downloadViewModel$delegate", "Lkotlin/Lazy;", "handleShareIntent", "", "intent", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "Companion", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@AndroidEntryPoint
public final class MainActivity extends Hilt_MainActivity {
    private static final long SPLASH_HOLD_MILLIS = 1400;
    private static final String TAG = "MainActivity";

    /* JADX INFO: renamed from: downloadViewModel$delegate, reason: from kotlin metadata */
    private final Lazy downloadViewModel;
    public static final int $stable = 8;
    private static String sharedUrl = "";

    public MainActivity() {
        final MainActivity $this$viewModels_u24default$iv = this;
        final Function0 extrasProducer$iv = null;
        this.downloadViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DownloadViewModel.class), new Function0<ViewModelStore>() { // from class: com.videshkarmakar.loop.MainActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return $this$viewModels_u24default$iv.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.videshkarmakar.loop.MainActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return $this$viewModels_u24default$iv.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.videshkarmakar.loop.MainActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function0 = extrasProducer$iv;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$viewModels_u24default$iv.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DownloadViewModel getDownloadViewModel() {
        return (DownloadViewModel) this.downloadViewModel.getValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws InterruptedException {
        final Ref.BooleanRef holdSplash = new Ref.BooleanRef();
        holdSplash.element = !PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.HAS_SHOWN_WELCOME, false, 1, null);
        SplashScreen.INSTANCE.installSplashScreen(this).setKeepOnScreenCondition(new SplashScreen.KeepOnScreenCondition() { // from class: com.videshkarmakar.loop.MainActivity$$ExternalSyntheticLambda0
            @Override // androidx.core.splashscreen.SplashScreen.KeepOnScreenCondition
            public final boolean shouldKeepOnScreen() {
                return MainActivity.onCreate$lambda$0(holdSplash);
            }
        });
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView(), new OnApplyWindowInsetsListener() { // from class: com.videshkarmakar.loop.MainActivity$$ExternalSyntheticLambda1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return MainActivity.onCreate$lambda$1(view, windowInsetsCompat);
            }
        });
        BuildersKt__BuildersKt.runBlocking$default(null, new C30653(null), 1, null);
        App.Companion companion = App.INSTANCE;
        Context baseContext = getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
        companion.setContext(baseContext);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(1866961288, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.MainActivity.onCreate.4
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer, int $changed) {
                CreationExtras extras$iv;
                ComposerKt.sourceInformation($composer, "C60@2864L11,63@2965L16,64@3044L30,65@3159L562,65@3087L634:MainActivity.kt#rrbzdc");
                if (($changed & 11) != 2 || !$composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1866961288, $changed, -1, "com.videshkarmakar.loop.MainActivity.onCreate.<anonymous> (MainActivity.kt:60)");
                    }
                    $composer.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation($composer, "CC(viewModel)P(3,2,1)*54@2502L7,64@2877L63:ViewModel.kt#3tja67");
                    ViewModelStoreOwner viewModelStoreOwner$iv = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer, 6);
                    if (viewModelStoreOwner$iv == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    if (viewModelStoreOwner$iv instanceof HasDefaultViewModelProviderFactory) {
                        extras$iv = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner$iv).getDefaultViewModelCreationExtras();
                    } else {
                        extras$iv = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(CookiesViewModel.class), viewModelStoreOwner$iv, (String) null, (ViewModelProvider.Factory) null, extras$iv, $composer, ((0 << 3) & 112) | ((0 << 3) & 896) | ((0 << 3) & 7168) | (57344 & (0 << 3)), 0);
                    $composer.endReplaceableGroup();
                    final CookiesViewModel cookiesViewModel = (CookiesViewModel) viewModel;
                    final boolean isUrlSharingTriggered = ((DownloadViewModel.ViewState) SnapshotStateKt.collectAsState(MainActivity.this.getDownloadViewModel().getViewStateFlow(), null, $composer, 8, 1).getValue()).isUrlSharingTriggered();
                    WindowSizeClass windowSizeClass = AndroidWindowSizeClass_androidKt.calculateWindowSizeClass(MainActivity.this, $composer, 8);
                    int widthSizeClass = windowSizeClass.getWidthSizeClass();
                    final MainActivity mainActivity = MainActivity.this;
                    CompositionLocalsKt.m7235SettingsProviderwsnAAM8(widthSizeClass, ComposableLambdaKt.rememberComposableLambda(-1512339514, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.MainActivity.onCreate.4.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer2, int $changed2) {
                            ComposerKt.sourceInformation($composer2, "C67@3235L7,67@3243L13,68@3321L7,69@3424L7,70@3451L256,66@3177L530:MainActivity.kt#rrbzdc");
                            if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1512339514, $changed2, -1, "com.videshkarmakar.loop.MainActivity.onCreate.<anonymous>.<anonymous> (MainActivity.kt:66)");
                                }
                                ProvidableCompositionLocal<DarkThemePreference> localDarkTheme = CompositionLocalsKt.getLocalDarkTheme();
                                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume = $composer2.consume(localDarkTheme);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                boolean zIsDarkTheme = ((DarkThemePreference) objConsume).isDarkTheme($composer2, 0);
                                ProvidableCompositionLocal<DarkThemePreference> localDarkTheme2 = CompositionLocalsKt.getLocalDarkTheme();
                                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume2 = $composer2.consume(localDarkTheme2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                boolean zIsHighContrastModeEnabled = ((DarkThemePreference) objConsume2).isHighContrastModeEnabled();
                                ProvidableCompositionLocal<Boolean> localDynamicColorSwitch = CompositionLocalsKt.getLocalDynamicColorSwitch();
                                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume3 = $composer2.consume(localDynamicColorSwitch);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                boolean zBooleanValue = ((Boolean) objConsume3).booleanValue();
                                final MainActivity mainActivity2 = mainActivity;
                                final CookiesViewModel cookiesViewModel2 = cookiesViewModel;
                                final boolean z = isUrlSharingTriggered;
                                ThemeKt.LoopTheme(zIsDarkTheme, zIsHighContrastModeEnabled, zBooleanValue, ComposableLambdaKt.rememberComposableLambda(1647238767, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.MainActivity.onCreate.4.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer3, int $changed3) {
                                        ComposerKt.sourceInformation($composer3, "C71@3473L216:MainActivity.kt#rrbzdc");
                                        if (($changed3 & 11) != 2 || !$composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1647238767, $changed3, -1, "com.videshkarmakar.loop.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:71)");
                                            }
                                            HomeEntryKt.HomeEntry(mainActivity2.getDownloadViewModel(), cookiesViewModel2, z, $composer3, 72);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer3.skipToGroupEnd();
                                    }
                                }, $composer2, 54), $composer2, 3072, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer2.skipToGroupEnd();
                        }
                    }, $composer, 54), $composer, 48);
                    MainActivity mainActivity2 = MainActivity.this;
                    Intent intent = MainActivity.this.getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
                    mainActivity2.handleShareIntent(intent);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        }), 1, null);
        if (holdSplash.element) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C30675(holdSplash, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$0(Ref.BooleanRef holdSplash) {
        Intrinsics.checkNotNullParameter(holdSplash, "$holdSplash");
        return holdSplash.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreate$lambda$1(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        v.setPadding(0, 0, 0, 0);
        return insets;
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.MainActivity$onCreate$3 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.MainActivity$onCreate$3", m210f = "MainActivity.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C30653 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C30653(Continuation<? super C30653> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C30653(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C30653) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    if (Build.VERSION.SDK_INT < 33) {
                        LanguageSettingsKt.setLanguage(PreferenceUtil.INSTANCE.getLocaleFromPreference());
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.MainActivity$onCreate$5 */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.MainActivity$onCreate$5", m210f = "MainActivity.kt", m211i = {}, m212l = {87}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C30675 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.BooleanRef $holdSplash;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C30675(Ref.BooleanRef booleanRef, Continuation<? super C30675> continuation) {
            super(2, continuation);
            this.$holdSplash = booleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C30675(this.$holdSplash, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C30675) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C30675 c30675;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (DelayKt.delay(MainActivity.SPLASH_HOLD_MILLIS, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c30675 = this;
                    break;
                    break;
                case 1:
                    c30675 = this;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c30675.$holdSplash.element = false;
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        handleShareIntent(intent);
        super.onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void handleShareIntent(Intent intent) {
        String sharedContent;
        String it;
        Log.d(TAG, "handleShareIntent: " + intent);
        String action = intent.getAction();
        if (action != null) {
            switch (action.hashCode()) {
                case -1173264947:
                    if (action.equals("android.intent.action.SEND") && (sharedContent = intent.getStringExtra("android.intent.extra.TEXT")) != null) {
                        intent.removeExtra("android.intent.extra.TEXT");
                        String matchedUrl = TextUtilKt.matchUrlFromSharedText(sharedContent);
                        if (!Intrinsics.areEqual(sharedUrl, matchedUrl)) {
                            sharedUrl = matchedUrl;
                            getDownloadViewModel().updateUrl(sharedUrl, true);
                        }
                    }
                    break;
                case -1173171990:
                    if (action.equals("android.intent.action.VIEW") && (it = intent.getDataString()) != null) {
                        sharedUrl = it;
                        getDownloadViewModel().updateUrl(sharedUrl, true);
                    }
                    break;
            }
        }
    }
}
