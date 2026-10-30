package com.videshkarmakar.loop;

import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass;
import androidx.compose.p001ui.platform.ClipboardManager;
import androidx.compose.p001ui.text.AnnotatedString;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.videshkarmakar.loop.p006ui.common.CompositionLocalsKt;
import com.videshkarmakar.loop.p006ui.theme.ThemeKt;
import com.videshkarmakar.loop.util.DarkThemePreference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CrashReportActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m194d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014¨\u0006\b"}, m195d2 = {"Lcom/videshkarmakar/loop/CrashReportActivity;", "Landroidx/activity/ComponentActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CrashReportActivity extends ComponentActivity {
    public static final int $stable = 0;

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView(), new OnApplyWindowInsetsListener() { // from class: com.videshkarmakar.loop.CrashReportActivity$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return CrashReportActivity.onCreate$lambda$0(view, windowInsetsCompat);
            }
        });
        final String errorMessage = String.valueOf(getIntent().getStringExtra("error_report"));
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(1102048284, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.CrashReportActivity.onCreate.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "C46@2150L613,46@2103L660:CrashReportActivity.kt#rrbzdc");
                if (($changed & 11) != 2 || !$composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1102048284, $changed, -1, "com.videshkarmakar.loop.CrashReportActivity.onCreate.<anonymous> (CrashReportActivity.kt:46)");
                    }
                    int iM3747getCompactY0FxcvE = WindowWidthSizeClass.INSTANCE.m3747getCompactY0FxcvE();
                    final String str = errorMessage;
                    final CrashReportActivity crashReportActivity = this;
                    CompositionLocalsKt.m7235SettingsProviderwsnAAM8(iM3747getCompactY0FxcvE, ComposableLambdaKt.rememberComposableLambda(-1774117414, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.CrashReportActivity.onCreate.2.1
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
                            ComposerKt.sourceInformation($composer2, "C48@2226L7,48@2234L13,49@2312L7,50@2415L7,51@2442L307,47@2168L581:CrashReportActivity.kt#rrbzdc");
                            if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1774117414, $changed2, -1, "com.videshkarmakar.loop.CrashReportActivity.onCreate.<anonymous>.<anonymous> (CrashReportActivity.kt:47)");
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
                                final String str2 = str;
                                final CrashReportActivity crashReportActivity2 = crashReportActivity;
                                ThemeKt.LoopTheme(zIsDarkTheme, zIsHighContrastModeEnabled, zBooleanValue, ComposableLambdaKt.rememberComposableLambda(-857794365, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.CrashReportActivity.onCreate.2.1.1
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
                                        ComposerKt.sourceInformation($composer3, "C52@2509L7,53@2537L194:CrashReportActivity.kt#rrbzdc");
                                        if (($changed3 & 11) != 2 || !$composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-857794365, $changed3, -1, "com.videshkarmakar.loop.CrashReportActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (CrashReportActivity.kt:52)");
                                            }
                                            ProvidableCompositionLocal<ClipboardManager> localClipboardManager = androidx.compose.p001ui.platform.CompositionLocalsKt.getLocalClipboardManager();
                                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                            Object objConsume4 = $composer3.consume(localClipboardManager);
                                            ComposerKt.sourceInformationMarkerEnd($composer3);
                                            final ClipboardManager clipboardManager = (ClipboardManager) objConsume4;
                                            String str3 = str2;
                                            final String str4 = str2;
                                            final CrashReportActivity crashReportActivity3 = crashReportActivity2;
                                            CrashReportActivityKt.CrashReportPage(str3, new Function0<Unit>() { // from class: com.videshkarmakar.loop.CrashReportActivity.onCreate.2.1.1.1
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
                                                    clipboardManager.setText(new AnnotatedString(str4, null, null, 6, null));
                                                    crashReportActivity3.finishAffinity();
                                                }
                                            }, $composer3, 0, 0);
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
    public static final WindowInsetsCompat onCreate$lambda$0(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        v.setPadding(0, 0, 0, 0);
        return insets;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            finishAffinity();
        }
    }
}
