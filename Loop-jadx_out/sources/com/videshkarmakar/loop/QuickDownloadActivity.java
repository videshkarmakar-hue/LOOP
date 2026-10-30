package com.videshkarmakar.loop;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.material3.windowsizeclass.AndroidWindowSizeClass_androidKt;
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.videshkarmakar.loop.p006ui.common.CompositionLocalsKt;
import com.videshkarmakar.loop.p006ui.page.download.DownloadSettingsDialogKt;
import com.videshkarmakar.loop.p006ui.theme.ThemeKt;
import com.videshkarmakar.loop.util.DarkThemePreference;
import com.videshkarmakar.loop.util.LanguageSettingsKt;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import com.videshkarmakar.loop.util.TextUtilKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: QuickDownloadActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m194d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u000eX\u008a\u008e\u0002"}, m195d2 = {"Lcom/videshkarmakar/loop/QuickDownloadActivity;", "Landroidx/activity/ComponentActivity;", "()V", "url", "", "handleShareIntent", "", "intent", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDownloadStarted", "customCommand", "", "onNewIntent", "app_debug", "showDialog"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class QuickDownloadActivity extends ComponentActivity {
    public static final int $stable = 8;
    private String url = "";

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void handleShareIntent(Intent intent) {
        String sharedContent;
        String it;
        Log.d("ShareActivity", "handleShareIntent: " + intent);
        String action = intent.getAction();
        if (action != null) {
            switch (action.hashCode()) {
                case -1173264947:
                    if (action.equals("android.intent.action.SEND") && (sharedContent = intent.getStringExtra("android.intent.extra.TEXT")) != null) {
                        intent.removeExtra("android.intent.extra.TEXT");
                        String matchedUrl = TextUtilKt.matchUrlFromSharedText(sharedContent);
                        this.url = matchedUrl;
                    }
                    break;
                case -1173171990:
                    if (action.equals("android.intent.action.VIEW") && (it = intent.getDataString()) != null) {
                        this.url = it;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDownloadStarted(boolean customCommand) {
        if (customCommand) {
            Downloader.INSTANCE.executeCommandWithUrl(this.url);
        } else {
            Downloader.quickDownload$default(Downloader.INSTANCE, this.url, null, 2, null);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws InterruptedException {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView(), new OnApplyWindowInsetsListener() { // from class: com.videshkarmakar.loop.QuickDownloadActivity$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return QuickDownloadActivity.onCreate$lambda$3(view, windowInsetsCompat);
            }
        });
        Window $this$onCreate_u24lambda_u244 = getWindow();
        $this$onCreate_u24lambda_u244.setBackgroundDrawable(new ColorDrawable(0));
        $this$onCreate_u24lambda_u244.setLayout(-1, -1);
        if (Build.VERSION.SDK_INT >= 26) {
            $this$onCreate_u24lambda_u244.setType(2038);
        } else {
            $this$onCreate_u24lambda_u244.setType(2003);
        }
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        handleShareIntent(intent);
        BuildersKt__BuildersKt.runBlocking$default(null, new C30683(null), 1, null);
        boolean isDialogEnabled = PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.CONFIGURE, false, 1, null);
        if (this.url.length() == 0) {
            finish();
        }
        if (!isDialogEnabled) {
            onDownloadStarted(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.CUSTOM_COMMAND, false, 1, null));
            finish();
        }
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(648621276, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.QuickDownloadActivity.onCreate.4
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer, int $changed) {
                Object value$iv$iv;
                ComposerKt.sourceInformation($composer, "C110@4054L24,112@4148L30,113@4208L1050,111@4091L1167:QuickDownloadActivity.kt#rrbzdc");
                if (($changed & 11) != 2 || !$composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(648621276, $changed, -1, "com.videshkarmakar.loop.QuickDownloadActivity.onCreate.<anonymous> (QuickDownloadActivity.kt:110)");
                    }
                    ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart($composer, -723523240, "CC(remember):Effects.kt#9igjgp");
                    Object it$iv$iv = $composer.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
                        $composer.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    wrapper$iv.getCoroutineScope();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    int widthSizeClass = AndroidWindowSizeClass_androidKt.calculateWindowSizeClass(QuickDownloadActivity.this, $composer, 8).getWidthSizeClass();
                    final QuickDownloadActivity quickDownloadActivity = QuickDownloadActivity.this;
                    CompositionLocalsKt.m7235SettingsProviderwsnAAM8(widthSizeClass, ComposableLambdaKt.rememberComposableLambda(-2018553958, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.QuickDownloadActivity.onCreate.4.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer2, int $changed2) {
                            ComposerKt.sourceInformation($composer2, "C115@4284L7,115@4292L13,116@4370L7,117@4473L7,118@4500L744,114@4226L1018:QuickDownloadActivity.kt#rrbzdc");
                            if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2018553958, $changed2, -1, "com.videshkarmakar.loop.QuickDownloadActivity.onCreate.<anonymous>.<anonymous> (QuickDownloadActivity.kt:114)");
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
                                final QuickDownloadActivity quickDownloadActivity2 = quickDownloadActivity;
                                ThemeKt.LoopTheme(zIsDarkTheme, zIsHighContrastModeEnabled, zBooleanValue, ComposableLambdaKt.rememberComposableLambda(-141316605, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.QuickDownloadActivity.onCreate.4.1.1
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    private static final boolean invoke$lambda$1(MutableState<Boolean> mutableState) {
                                        MutableState<Boolean> $this$getValue$iv = mutableState;
                                        return $this$getValue$iv.getValue().booleanValue();
                                    }

                                    /* JADX INFO: Access modifiers changed from: private */
                                    public static final void invoke$lambda$2(MutableState<Boolean> mutableState, boolean value) {
                                        mutableState.setValue(Boolean.valueOf(value));
                                    }

                                    public final void invoke(Composer $composer3, int $changed3) {
                                        Object value$iv;
                                        ComposerKt.sourceInformation($composer3, "C121@4542L33,123@4635L7,124@4695L531:QuickDownloadActivity.kt#rrbzdc");
                                        if (($changed3 & 11) == 2 && $composer3.getSkipping()) {
                                            $composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-141316605, $changed3, -1, "com.videshkarmakar.loop.QuickDownloadActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (QuickDownloadActivity.kt:121)");
                                        }
                                        $composer3.startReplaceGroup(2097149918);
                                        ComposerKt.sourceInformation($composer3, "CC(remember):QuickDownloadActivity.kt#9igjgp");
                                        Object it$iv = $composer3.rememberedValue();
                                        if (it$iv == Composer.INSTANCE.getEmpty()) {
                                            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                                            $composer3.updateRememberedValue(value$iv);
                                        } else {
                                            value$iv = it$iv;
                                        }
                                        final MutableState showDialog$delegate = (MutableState) value$iv;
                                        $composer3.endReplaceGroup();
                                        ProvidableCompositionLocal<WindowWidthSizeClass> localWindowWidthState = CompositionLocalsKt.getLocalWindowWidthState();
                                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object objConsume4 = $composer3.consume(localWindowWidthState);
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        boolean useDialog = !WindowWidthSizeClass.m3739equalsimpl0(((WindowWidthSizeClass) objConsume4).getValue(), WindowWidthSizeClass.INSTANCE.m3747getCompactY0FxcvE());
                                        boolean zInvoke$lambda$1 = invoke$lambda$1(showDialog$delegate);
                                        final QuickDownloadActivity quickDownloadActivity3 = quickDownloadActivity2;
                                        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.QuickDownloadActivity.onCreate.4.1.1.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public /* bridge */ /* synthetic */ Unit invoke() {
                                                invoke2();
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2() {
                                                quickDownloadActivity3.onDownloadStarted(PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.CUSTOM_COMMAND));
                                            }
                                        };
                                        final QuickDownloadActivity quickDownloadActivity4 = quickDownloadActivity2;
                                        DownloadSettingsDialogKt.DownloadSettingDialog(useDialog, zInvoke$lambda$1, true, null, function0, new Function0<Unit>() { // from class: com.videshkarmakar.loop.QuickDownloadActivity.onCreate.4.1.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public /* bridge */ /* synthetic */ Unit invoke() {
                                                invoke2();
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2() {
                                                C45811.invoke$lambda$2(showDialog$delegate, false);
                                                quickDownloadActivity4.finish();
                                            }
                                        }, $composer3, 384, 8);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
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
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        }), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreate$lambda$3(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        v.setPadding(0, 0, 0, 0);
        return insets;
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.QuickDownloadActivity$onCreate$3 */
    /* JADX INFO: compiled from: QuickDownloadActivity.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.QuickDownloadActivity$onCreate$3", m210f = "QuickDownloadActivity.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C30683 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C30683(Continuation<? super C30683> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C30683(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C30683) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            handleShareIntent(intent);
        }
        super.onNewIntent(intent);
    }
}
