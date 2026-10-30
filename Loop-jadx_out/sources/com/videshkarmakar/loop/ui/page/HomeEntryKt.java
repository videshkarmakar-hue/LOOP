package com.videshkarmakar.loop.ui.page;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.CookieManager;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.NavType;
import androidx.navigation.Navigator;
import androidx.navigation.PopUpToBuilder;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.videshkarmakar.loop.Downloader;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.ui.common.AnimatedComposableKt;
import com.videshkarmakar.loop.ui.common.CompositionLocalsKt;
import com.videshkarmakar.loop.ui.common.Route;
import com.videshkarmakar.loop.ui.common.RouteKt;
import com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt;
import com.videshkarmakar.loop.ui.page.command.TaskListPageKt;
import com.videshkarmakar.loop.ui.page.command.TaskLogPageKt;
import com.videshkarmakar.loop.ui.page.creator.CreatorPageKt;
import com.videshkarmakar.loop.ui.page.download.DownloadPageKt;
import com.videshkarmakar.loop.ui.page.download.DownloadViewModel;
import com.videshkarmakar.loop.ui.page.download.FormatPageKt;
import com.videshkarmakar.loop.ui.page.feedback.ReportFeedbackPageKt;
import com.videshkarmakar.loop.ui.page.settings.SettingsPageKt;
import com.videshkarmakar.loop.ui.page.settings.about.AboutPageKt;
import com.videshkarmakar.loop.ui.page.settings.about.DeveloperCreditsPageKt;
import com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt;
import com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferencesKt;
import com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt;
import com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt;
import com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt;
import com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt;
import com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt;
import com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt;
import com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt;
import com.videshkarmakar.loop.ui.page.settings.interaction.InteractionPreferencePageKt;
import com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt;
import com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel;
import com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt;
import com.videshkarmakar.loop.ui.page.settings.network.WebViewPageKt;
import com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import com.videshkarmakar.loop.util.ToastUtil;
import com.videshkarmakar.loop.util.UpdateUtil;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: HomeEntry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u001a%\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001aC\u0010\u000b\u001a\u00020\u0003*\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00030\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014²\u0006\n\u0010\u0015\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0017X\u008a\u008e\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\f\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u008a\u0084\u0002²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u0084\u0002"}, d2 = {"TAG", "", HomeEntryKt.TAG, "", "downloadViewModel", "Lcom/videshkarmakar/loop/ui/page/download/DownloadViewModel;", "cookiesViewModel", "Lcom/videshkarmakar/loop/ui/page/settings/network/CookiesViewModel;", "isUrlShared", "", "(Lcom/videshkarmakar/loop/ui/page/download/DownloadViewModel;Lcom/videshkarmakar/loop/ui/page/settings/network/CookiesViewModel;ZLandroidx/compose/runtime/Composer;I)V", "settingsGraph", "Landroidx/navigation/NavGraphBuilder;", "onNavigateBack", "Lkotlin/Function0;", "onNavigateTo", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "route", "app_debug", "showUpdateDialog", "currentDownloadStatus", "Lcom/videshkarmakar/loop/util/UpdateUtil$DownloadStatus;", "latestRelease", "Lcom/videshkarmakar/loop/util/UpdateUtil$LatestRelease;", "navBackStackEntry", "Landroidx/navigation/NavBackStackEntry;", "downloaderState", "Lcom/videshkarmakar/loop/Downloader$State;"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class HomeEntryKt {
    private static final String TAG = "HomeEntry";

    public static final void HomeEntry(final DownloadViewModel downloadViewModel, final CookiesViewModel cookiesViewModel, final boolean isUrlShared, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv$iv;
        Object value$iv2;
        boolean z;
        String route;
        NavDestination destination;
        Intrinsics.checkNotNullParameter(downloadViewModel, "downloadViewModel");
        Intrinsics.checkNotNullParameter(cookiesViewModel, "cookiesViewModel");
        Composer $composer2 = $composer.startRestartGroup(1128637162);
        ComposerKt.sourceInformation($composer2, "C(HomeEntry)P(1)106@5328L23,107@5383L7,108@5419L42,109@5495L90,110@5602L24,112@5683L55,114@5766L137,117@5923L687,155@7535L30,162@7800L11,163@7845L518,178@8370L7294,159@7697L7967:HomeEntry.kt#hmxj0r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1128637162, $changed, -1, "com.videshkarmakar.loop.ui.page.HomeEntry (HomeEntry.kt:105)");
        }
        final NavHostController navController = NavHostControllerKt.rememberNavController(new Navigator[0], $composer2, 8);
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer2.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        final Context context = (Context) objConsume;
        MutableState showUpdateDialog$delegate = (MutableState) RememberSaveableKt.m3641rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<MutableState<Boolean>>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$showUpdateDialog$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MutableState<Boolean> invoke() {
                return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
            }
        }, $composer2, 3080, 6);
        $composer2.startReplaceGroup(1664730727);
        ComposerKt.sourceInformation($composer2, "CC(remember):HomeEntry.kt#9igjgp");
        Object it$iv = $composer2.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            UpdateUtil.DownloadStatus.NotYet notYet = UpdateUtil.DownloadStatus.NotYet.INSTANCE;
            Intrinsics.checkNotNull(notYet, "null cannot be cast to non-null type com.videshkarmakar.loop.util.UpdateUtil.DownloadStatus");
            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(notYet, null, 2, null);
            $composer2.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        MutableState currentDownloadStatus$delegate = (MutableState) value$iv;
        $composer2.endReplaceGroup();
        ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart($composer2, -723523240, "CC(remember):Effects.kt#9igjgp");
        Object it$iv$iv = $composer2.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2));
            $composer2.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
        ComposerKt.sourceInformationMarkerEnd($composer2);
        CoroutineScope scope = wrapper$iv.getCoroutineScope();
        ComposerKt.sourceInformationMarkerEnd($composer2);
        Ref.ObjectRef updateJob = new Ref.ObjectRef();
        $composer2.startReplaceGroup(1664730915);
        ComposerKt.sourceInformation($composer2, "CC(remember):HomeEntry.kt#9igjgp");
        Object it$iv2 = $composer2.rememberedValue();
        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new UpdateUtil.LatestRelease((String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (List) null, (String) null, 511, (DefaultConstructorMarker) null), null, 2, null);
            $composer2.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        MutableState latestRelease$delegate = (MutableState) value$iv2;
        $composer2.endReplaceGroup();
        final ManagedActivityResultLauncher settings = ActivityResultRegistryKt.rememberLauncherForActivityResult(new ActivityResultContracts.StartActivityForResult(), new Function1<ActivityResult, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$settings$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ActivityResult activityResult) {
                invoke2(activityResult);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ActivityResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                UpdateUtil.m7546installLatestApkIoAF18A$default(UpdateUtil.INSTANCE, null, 1, null);
            }
        }, $composer2, 56);
        ManagedActivityResultLauncher launcher = ActivityResultRegistryKt.rememberLauncherForActivityResult(new ActivityResultContracts.RequestPermission(), new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$launcher$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean result) {
                if (result) {
                    UpdateUtil.m7546installLatestApkIoAF18A$default(UpdateUtil.INSTANCE, null, 1, null);
                    return;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    if (context.getPackageManager().canRequestPackageInstalls()) {
                        UpdateUtil.m7546installLatestApkIoAF18A$default(UpdateUtil.INSTANCE, null, 1, null);
                        return;
                    }
                    settings.launch(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + context.getPackageName())));
                }
            }
        }, $composer2, 8);
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$onNavigateBack$1
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
                Lifecycle lifecycleRegistry;
                NavHostController $this$invoke_u24lambda_u240 = navController;
                NavBackStackEntry currentBackStackEntry = $this$invoke_u24lambda_u240.getCurrentBackStackEntry();
                if (((currentBackStackEntry == null || (lifecycleRegistry = currentBackStackEntry.getLifecycleRegistry()) == null) ? null : lifecycleRegistry.getState()) == Lifecycle.State.RESUMED) {
                    $this$invoke_u24lambda_u240.popBackStack();
                }
            }
        };
        if (!isUrlShared) {
            z = false;
        } else {
            NavDestination currentDestination = navController.getCurrentDestination();
            if (Intrinsics.areEqual(currentDestination != null ? currentDestination.getRoute() : null, Route.HOME)) {
                z = false;
            } else {
                z = false;
                navController.popBackStack(Route.HOME, false, true);
            }
        }
        String startRoute = PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.HAS_SHOWN_WELCOME, z, 1, null) ? Route.HOME : Route.WELCOME;
        List mainRoutes = CollectionsKt.listOf((Object[]) new String[]{Route.HOME, Route.CREATOR, Route.REPORT_FEEDBACK, Route.SETTINGS});
        NavBackStackEntry navBackStackEntryHomeEntry$lambda$8 = HomeEntry$lambda$8(NavHostControllerKt.currentBackStackEntryAsState(navController, $composer2, 8));
        if (navBackStackEntryHomeEntry$lambda$8 == null || (destination = navBackStackEntryHomeEntry$lambda$8.getDestination()) == null || (route = destination.getRoute()) == null) {
            route = startRoute;
        }
        String currentRoute = route;
        final boolean showBottomBar = mainRoutes.contains(currentRoute);
        ScaffoldKt.m2282ScaffoldTvnljyQ(BackgroundKt.m206backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getBackground(), null, 2, null), null, ComposableLambdaKt.rememberComposableLambda(-2001153425, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer3, int $changed2) {
                ComposerKt.sourceInformation($composer3, "C165@7896L443:HomeEntry.kt#hmxj0r");
                if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2001153425, $changed2, -1, "com.videshkarmakar.loop.ui.page.HomeEntry.<anonymous> (HomeEntry.kt:164)");
                    }
                    if (showBottomBar) {
                        final NavHostController navHostController = navController;
                        FoXinBottomNavigationKt.LoopBottomNavigation(new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                invoke2(str);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String route2) {
                                Intrinsics.checkNotNullParameter(route2, "route");
                                NavHostController navHostController2 = navHostController;
                                final NavHostController navHostController3 = navHostController;
                                navHostController2.navigate(route2, new Function1<NavOptionsBuilder, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                                        invoke2(navOptionsBuilder);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(NavOptionsBuilder navigate) {
                                        Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
                                        navigate.popUpTo(navHostController3.getGraph().getStartDestId(), new Function1<PopUpToBuilder, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.1.1.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(PopUpToBuilder popUpToBuilder) {
                                                invoke2(popUpToBuilder);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(PopUpToBuilder popUpTo) {
                                                Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
                                                popUpTo.setSaveState(true);
                                            }
                                        });
                                        navigate.setLaunchSingleTop(true);
                                        navigate.setRestoreState(true);
                                    }
                                });
                            }
                        }, null, $composer3, 0, 2);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer3.skipToGroupEnd();
            }
        }, $composer2, 54), null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-665604935, true, new AnonymousClass2(showUpdateDialog$delegate, navController, startRoute, cookiesViewModel, function0, downloadViewModel, latestRelease$delegate, updateJob, scope, launcher, currentDownloadStatus$delegate, context), $composer2, 54), $composer2, 805306752, HttpStatusCodesKt.HTTP_VARIANT_ALSO_NEGOTIATES);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    HomeEntryKt.HomeEntry(downloadViewModel, cookiesViewModel, isUrlShared, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean HomeEntry$lambda$0(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HomeEntry$lambda$1(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UpdateUtil.DownloadStatus HomeEntry$lambda$3(MutableState<UpdateUtil.DownloadStatus> mutableState) {
        MutableState<UpdateUtil.DownloadStatus> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HomeEntry$lambda$4(MutableState<UpdateUtil.DownloadStatus> mutableState, UpdateUtil.DownloadStatus value) {
        mutableState.setValue(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UpdateUtil.LatestRelease HomeEntry$lambda$6(MutableState<UpdateUtil.LatestRelease> mutableState) {
        MutableState<UpdateUtil.LatestRelease> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    private static final NavBackStackEntry HomeEntry$lambda$8(State<NavBackStackEntry> state) {
        Object thisObj$iv = state.getValue();
        return (NavBackStackEntry) thisObj$iv;
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2, reason: invalid class name */
    /* JADX INFO: compiled from: HomeEntry.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "invoke", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class AnonymousClass2 extends Lambda implements Function3<PaddingValues, Composer, Integer, Unit> {
        final /* synthetic */ Context $context;
        final /* synthetic */ CookiesViewModel $cookiesViewModel;
        final /* synthetic */ MutableState<UpdateUtil.DownloadStatus> $currentDownloadStatus$delegate;
        final /* synthetic */ DownloadViewModel $downloadViewModel;
        final /* synthetic */ MutableState<UpdateUtil.LatestRelease> $latestRelease$delegate;
        final /* synthetic */ ManagedActivityResultLauncher<String, Boolean> $launcher;
        final /* synthetic */ NavHostController $navController;
        final /* synthetic */ Function0<Unit> $onNavigateBack;
        final /* synthetic */ CoroutineScope $scope;
        final /* synthetic */ MutableState<Boolean> $showUpdateDialog$delegate;
        final /* synthetic */ String $startRoute;
        final /* synthetic */ Ref.ObjectRef<Job> $updateJob;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MutableState<Boolean> mutableState, NavHostController navHostController, String str, CookiesViewModel cookiesViewModel, Function0<Unit> function0, DownloadViewModel downloadViewModel, MutableState<UpdateUtil.LatestRelease> mutableState2, Ref.ObjectRef<Job> objectRef, CoroutineScope coroutineScope, ManagedActivityResultLauncher<String, Boolean> managedActivityResultLauncher, MutableState<UpdateUtil.DownloadStatus> mutableState3, Context context) {
            super(3);
            this.$showUpdateDialog$delegate = mutableState;
            this.$navController = navHostController;
            this.$startRoute = str;
            this.$cookiesViewModel = cookiesViewModel;
            this.$onNavigateBack = function0;
            this.$downloadViewModel = downloadViewModel;
            this.$latestRelease$delegate = mutableState2;
            this.$updateJob = objectRef;
            this.$scope = coroutineScope;
            this.$launcher = managedActivityResultLauncher;
            this.$currentDownloadStatus$delegate = mutableState3;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
            invoke(paddingValues, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(PaddingValues paddingValues, Composer $composer, int $changed) {
            Function0<ComposeUiNode> function0;
            float f;
            Object value$iv;
            Object value$iv2;
            Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
            ComposerKt.sourceInformation($composer, "C183@8547L11,179@8397L4000,266@12407L76,270@12543L29,272@12603L971,272@12582L992,301@13605L506,301@13584L527,318@14157L1491:HomeEntry.kt#hmxj0r");
            int $dirty = $changed;
            if (($changed & 14) == 0) {
                $dirty |= $composer.changed(paddingValues) ? 4 : 2;
            }
            int $dirty2 = $dirty;
            if (($dirty2 & 91) != 18 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-665604935, $dirty2, -1, "com.videshkarmakar.loop.ui.page.HomeEntry.<anonymous> (HomeEntry.kt:179)");
                }
                Modifier modifier$iv = BackgroundKt.m206backgroundbw27NRU$default(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getBackground(), null, 2, null);
                final NavHostController navHostController = this.$navController;
                String str = this.$startRoute;
                final CookiesViewModel cookiesViewModel = this.$cookiesViewModel;
                final Function0<Unit> function1 = this.$onNavigateBack;
                final DownloadViewModel downloadViewModel = this.$downloadViewModel;
                ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function0 = constructor;
                    $composer.createNode(function0);
                } else {
                    function0 = constructor;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                int i2 = ((0 >> 6) & 112) | 6;
                BoxScope $this$invoke_u24lambda_u240 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 651222341, "C188@8727L7,185@8595L3792:HomeEntry.kt#hmxj0r");
                Modifier.Companion companion = Modifier.INSTANCE;
                ProvidableCompositionLocal<WindowWidthSizeClass> localWindowWidthState = CompositionLocalsKt.getLocalWindowWidthState();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer.consume(localWindowWidthState);
                ComposerKt.sourceInformationMarkerEnd($composer);
                int value = ((WindowWidthSizeClass) objConsume).getValue();
                if (WindowWidthSizeClass.m3491equalsimpl0(value, WindowWidthSizeClass.INSTANCE.m3499getCompactY0FxcvE())) {
                    f = 1.0f;
                } else {
                    f = WindowWidthSizeClass.m3491equalsimpl0(value, WindowWidthSizeClass.INSTANCE.m3500getExpandedY0FxcvE()) ? 0.5f : 0.8f;
                }
                NavHostKt.NavHost(navHostController, str, $this$invoke_u24lambda_u240.align(SizeKt.fillMaxWidth(companion, f), Alignment.INSTANCE.getCenter()), null, null, null, null, null, null, new Function1<NavGraphBuilder, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavGraphBuilder navGraphBuilder) {
                        invoke2(navGraphBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavGraphBuilder NavHost) {
                        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
                        final NavHostController navHostController2 = navHostController;
                        AnimatedComposableKt.animatedComposable$default(NavHost, Route.WELCOME, null, null, ComposableLambdaKt.composableLambdaInstance(1394139503, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$1$1.1
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer2, int $changed2) {
                                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                                Intrinsics.checkNotNullParameter(it, "it");
                                ComposerKt.sourceInformation($composer2, "C199@9183L338:HomeEntry.kt#hmxj0r");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1394139503, $changed2, -1, "com.videshkarmakar.loop.ui.page.HomeEntry.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HomeEntry.kt:199)");
                                }
                                final NavHostController navHostController3 = navHostController2;
                                WelcomeScreenKt.WelcomeScreen(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.2.1.1.1.1
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
                                        PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.HAS_SHOWN_WELCOME, true);
                                        navHostController3.navigate(Route.HOME, new Function1<NavOptionsBuilder, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.2.1.1.1.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                                                invoke2(navOptionsBuilder);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(NavOptionsBuilder navigate) {
                                                Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
                                                navigate.popUpTo(Route.WELCOME, new Function1<PopUpToBuilder, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.2.1.1.1.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(PopUpToBuilder popUpToBuilder) {
                                                        invoke2(popUpToBuilder);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(PopUpToBuilder popUpTo) {
                                                        Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
                                                        popUpTo.setInclusive(true);
                                                    }
                                                });
                                            }
                                        });
                                    }
                                }, $composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), 6, null);
                        final Function0<Unit> function2 = function1;
                        AnimatedComposableKt.animatedComposable$default(NavHost, Route.CREATOR, null, null, ComposableLambdaKt.composableLambdaInstance(-2071813914, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer2, int $changed2) {
                                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                                Intrinsics.checkNotNullParameter(it, "it");
                                ComposerKt.sourceInformation($composer2, "C209@9612L44:HomeEntry.kt#hmxj0r");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2071813914, $changed2, -1, "com.videshkarmakar.loop.ui.page.HomeEntry.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HomeEntry.kt:209)");
                                }
                                CreatorPageKt.CreatorPage(function2, $composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), 6, null);
                        final Function0<Unit> function3 = function1;
                        AnimatedComposableKt.animatedComposable$default(NavHost, Route.REPORT_FEEDBACK, null, null, ComposableLambdaKt.composableLambdaInstance(183689895, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$1$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer2, int $changed2) {
                                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                                Intrinsics.checkNotNullParameter(it, "it");
                                ComposerKt.sourceInformation($composer2, "C212@9755L51:HomeEntry.kt#hmxj0r");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(183689895, $changed2, -1, "com.videshkarmakar.loop.ui.page.HomeEntry.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HomeEntry.kt:212)");
                                }
                                ReportFeedbackPageKt.ReportFeedbackPage(function3, $composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), 6, null);
                        final DownloadViewModel downloadViewModel2 = downloadViewModel;
                        final NavHostController navHostController3 = navHostController;
                        final CookiesViewModel cookiesViewModel2 = cookiesViewModel;
                        AnimatedComposableKt.animatedComposable$default(NavHost, Route.HOME, null, null, ComposableLambdaKt.composableLambdaInstance(-1855773592, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$1$1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer2, int $changed2) {
                                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                                Intrinsics.checkNotNullParameter(it, "it");
                                ComposerKt.sourceInformation($composer2, "C215@9894L929:HomeEntry.kt#hmxj0r");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1855773592, $changed2, -1, "com.videshkarmakar.loop.ui.page.HomeEntry.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HomeEntry.kt:215)");
                                }
                                final NavHostController navHostController4 = navHostController3;
                                Function0<Unit> function4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.2.1.1.4.1
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
                                        navHostController4.navigate(Route.SETTINGS, new Function1<NavOptionsBuilder, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.2.1.1.4.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                                                invoke2(navOptionsBuilder);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(NavOptionsBuilder navigate) {
                                                Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
                                                navigate.setLaunchSingleTop(true);
                                            }
                                        });
                                    }
                                };
                                final NavHostController navHostController5 = navHostController3;
                                Function0<Unit> function5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.2.1.1.4.2
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
                                        NavController.navigate$default(navHostController5, Route.DOWNLOADS, null, null, 6, null);
                                    }
                                };
                                final NavHostController navHostController6 = navHostController3;
                                Function0<Unit> function6 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.2.1.1.4.3
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
                                        NavController.navigate$default(navHostController6, "playlist", null, null, 6, null);
                                    }
                                };
                                final NavHostController navHostController7 = navHostController3;
                                Function0<Unit> function7 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.2.1.1.4.4
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
                                        NavController.navigate$default(navHostController7, Route.FORMAT_SELECTION, null, null, 6, null);
                                    }
                                };
                                final NavHostController navHostController8 = navHostController3;
                                Function0<Unit> function8 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.2.1.1.4.5
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
                                        NavController.navigate$default(navHostController8, Route.TASK_LIST, null, null, 6, null);
                                    }
                                };
                                final CookiesViewModel cookiesViewModel3 = cookiesViewModel2;
                                final NavHostController navHostController9 = navHostController3;
                                DownloadPageKt.DownloadPage(function4, function5, function6, function7, function8, new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.2.1.1.4.6
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                                        invoke2(str2);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(String it2) {
                                        Intrinsics.checkNotNullParameter(it2, "it");
                                        cookiesViewModel3.updateUrl(it2);
                                        NavController.navigate$default(navHostController9, Route.COOKIE_GENERATOR_WEBVIEW, null, null, 6, null);
                                    }
                                }, downloadViewModel2, $composer2, 2097152, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), 6, null);
                        final Function0<Unit> function4 = function1;
                        AnimatedComposableKt.animatedComposable$default(NavHost, Route.DOWNLOADS, null, null, ComposableLambdaKt.composableLambdaInstance(399730217, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$1$1.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer2, int $changed2) {
                                Object value$iv3;
                                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                                Intrinsics.checkNotNullParameter(it, "it");
                                ComposerKt.sourceInformation($composer2, "C232@10910L20,232@10896L34:HomeEntry.kt#hmxj0r");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(399730217, $changed2, -1, "com.videshkarmakar.loop.ui.page.HomeEntry.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HomeEntry.kt:232)");
                                }
                                $composer2.startReplaceGroup(1694780178);
                                ComposerKt.sourceInformation($composer2, "CC(remember):HomeEntry.kt#9igjgp");
                                boolean invalid$iv = $composer2.changed(function4);
                                final Function0<Unit> function5 = function4;
                                Object it$iv = $composer2.rememberedValue();
                                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$1$1$5$1$1
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
                                            function5.invoke();
                                        }
                                    };
                                    $composer2.updateRememberedValue(value$iv3);
                                } else {
                                    value$iv3 = it$iv;
                                }
                                $composer2.endReplaceGroup();
                                VideoListPageKt.VideoListPage(null, (Function0) value$iv3, $composer2, 0, 1);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), 6, null);
                        final Function0<Unit> function5 = function1;
                        final NavHostController navHostController4 = navHostController;
                        AnimatedComposableKt.animatedComposableVariant$default(NavHost, Route.TASK_LIST, null, null, ComposableLambdaKt.composableLambdaInstance(628059476, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$1$1.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope animatedComposableVariant, NavBackStackEntry it, Composer $composer2, int $changed2) {
                                Intrinsics.checkNotNullParameter(animatedComposableVariant, "$this$animatedComposableVariant");
                                Intrinsics.checkNotNullParameter(it, "it");
                                ComposerKt.sourceInformation($composer2, "C234@11014L186:HomeEntry.kt#hmxj0r");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(628059476, $changed2, -1, "com.videshkarmakar.loop.ui.page.HomeEntry.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HomeEntry.kt:234)");
                                }
                                Function0<Unit> function6 = function5;
                                final NavHostController navHostController5 = navHostController4;
                                TaskListPageKt.TaskListPage(function6, new Function1<Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.2.1.1.6.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                        invoke(num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(int it2) {
                                        NavController.navigate$default(navHostController5, RouteKt.id(Route.TASK_LOG, it2), null, null, 6, null);
                                    }
                                }, $composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), 6, null);
                        String strArg = RouteKt.arg(Route.TASK_LOG, Route.TASK_HASHCODE);
                        List listListOf = CollectionsKt.listOf(NamedNavArgumentKt.navArgument(Route.TASK_HASHCODE, new Function1<NavArgumentBuilder, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$1$1.7
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(NavArgumentBuilder navArgumentBuilder) {
                                invoke2(navArgumentBuilder);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(NavArgumentBuilder navArgument) {
                                Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
                                navArgument.setType(NavType.IntType);
                            }
                        }));
                        final Function0<Unit> function6 = function1;
                        AnimatedComposableKt.slideInVerticallyComposable$default(NavHost, strArg, listListOf, null, ComposableLambdaKt.composableLambdaInstance(415377541, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$1$1.8
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope slideInVerticallyComposable, NavBackStackEntry it, Composer $composer2, int $changed2) {
                                Intrinsics.checkNotNullParameter(slideInVerticallyComposable, "$this$slideInVerticallyComposable");
                                Intrinsics.checkNotNullParameter(it, "it");
                                ComposerKt.sourceInformation($composer2, "C243@11464L178:HomeEntry.kt#hmxj0r");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(415377541, $changed2, -1, "com.videshkarmakar.loop.ui.page.HomeEntry.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HomeEntry.kt:243)");
                                }
                                Function0<Unit> function7 = function6;
                                Bundle arguments = it.getArguments();
                                TaskLogPageKt.TaskLogPage(function7, arguments != null ? arguments.getInt(Route.TASK_HASHCODE) : -1, $composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), 4, null);
                        AnimatedComposableKt.animatedComposable$default(NavHost, "playlist", null, null, ComposableSingletons$HomeEntryKt.INSTANCE.m7178getLambda1$app_debug(), 6, null);
                        AnimatedComposableKt.animatedComposable$default(NavHost, Route.LIVE, null, null, ComposableSingletons$HomeEntryKt.INSTANCE.m7179getLambda2$app_debug(), 6, null);
                        final Function0<Unit> function7 = function1;
                        AnimatedComposableKt.animatedComposable$default(NavHost, Route.VIDEOS, null, null, ComposableLambdaKt.composableLambdaInstance(-1423692948, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$1$1.9
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer2, int $changed2) {
                                Object value$iv3;
                                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                                Intrinsics.checkNotNullParameter(it, "it");
                                ComposerKt.sourceInformation($composer2, "C251@11859L20,251@11845L34:HomeEntry.kt#hmxj0r");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1423692948, $changed2, -1, "com.videshkarmakar.loop.ui.page.HomeEntry.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HomeEntry.kt:251)");
                                }
                                $composer2.startReplaceGroup(1694781127);
                                ComposerKt.sourceInformation($composer2, "CC(remember):HomeEntry.kt#9igjgp");
                                boolean invalid$iv = $composer2.changed(function7);
                                final Function0<Unit> function8 = function7;
                                Object it$iv = $composer2.rememberedValue();
                                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$1$1$9$1$1
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
                                            function8.invoke();
                                        }
                                    };
                                    $composer2.updateRememberedValue(value$iv3);
                                } else {
                                    value$iv3 = it$iv;
                                }
                                $composer2.endReplaceGroup();
                                VideoListPageKt.VideoListPage(null, (Function0) value$iv3, $composer2, 0, 1);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), 6, null);
                        final DownloadViewModel downloadViewModel3 = downloadViewModel;
                        final Function0<Unit> function8 = function1;
                        AnimatedComposableKt.slideInVerticallyComposable$default(NavHost, Route.FORMAT_SELECTION, null, null, ComposableLambdaKt.composableLambdaInstance(-2064221572, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$1$1.10
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope slideInVerticallyComposable, NavBackStackEntry it, Composer $composer2, int $changed2) {
                                Object value$iv3;
                                Intrinsics.checkNotNullParameter(slideInVerticallyComposable, "$this$slideInVerticallyComposable");
                                Intrinsics.checkNotNullParameter(it, "it");
                                ComposerKt.sourceInformation($composer2, "C252@11982L20,252@11952L50:HomeEntry.kt#hmxj0r");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2064221572, $changed2, -1, "com.videshkarmakar.loop.ui.page.HomeEntry.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HomeEntry.kt:252)");
                                }
                                DownloadViewModel downloadViewModel4 = downloadViewModel3;
                                $composer2.startReplaceGroup(1694781250);
                                ComposerKt.sourceInformation($composer2, "CC(remember):HomeEntry.kt#9igjgp");
                                boolean invalid$iv = $composer2.changed(function8);
                                final Function0<Unit> function9 = function8;
                                Object it$iv = $composer2.rememberedValue();
                                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$1$1$10$1$1
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
                                            function9.invoke();
                                        }
                                    };
                                    $composer2.updateRememberedValue(value$iv3);
                                } else {
                                    value$iv3 = it$iv;
                                }
                                $composer2.endReplaceGroup();
                                FormatPageKt.FormatPage(downloadViewModel4, (Function0) value$iv3, $composer2, 8, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), 6, null);
                        CookiesViewModel cookiesViewModel3 = cookiesViewModel;
                        Function0<Unit> function9 = function1;
                        final NavHostController navHostController5 = navHostController;
                        HomeEntryKt.settingsGraph(NavHost, cookiesViewModel3, function9, new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$1$1.11
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                                invoke2(str2);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String route) {
                                Intrinsics.checkNotNullParameter(route, "route");
                                navHostController5.navigate(route, new Function1<NavOptionsBuilder, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.2.1.1.11.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                                        invoke2(navOptionsBuilder);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(NavOptionsBuilder navigate) {
                                        Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
                                        navigate.setLaunchSingleTop(true);
                                    }
                                });
                            }
                        });
                    }
                }, $composer, 8, 504);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                final NavHostController navHostController2 = this.$navController;
                WelcomeDialogKt.WelcomeDialog(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.2.2
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
                        NavController.navigate$default(navHostController2, Route.SETTINGS, null, null, 6, null);
                    }
                }, $composer, 0);
                State downloaderState$delegate = FlowExtKt.collectAsStateWithLifecycle(Downloader.INSTANCE.getDownloaderState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer, 8, 7);
                Unit unit = Unit.INSTANCE;
                $composer.startReplaceGroup(-1107362740);
                ComposerKt.sourceInformation($composer, "CC(remember):HomeEntry.kt#9igjgp");
                boolean invalid$iv = $composer.changed(downloaderState$delegate);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new HomeEntryKt$HomeEntry$2$3$1(downloaderState$delegate, null);
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv, $composer, 70);
                Unit unit2 = Unit.INSTANCE;
                $composer.startReplaceGroup(-1107361738);
                ComposerKt.sourceInformation($composer, "CC(remember):HomeEntry.kt#9igjgp");
                boolean invalid$iv2 = $composer.changed(this.$showUpdateDialog$delegate);
                MutableState<UpdateUtil.LatestRelease> mutableState = this.$latestRelease$delegate;
                MutableState<Boolean> mutableState2 = this.$showUpdateDialog$delegate;
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new HomeEntryKt$HomeEntry$2$4$1(mutableState, mutableState2, null);
                    $composer.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                $composer.endReplaceGroup();
                EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer, 70);
                if (HomeEntryKt.HomeEntry$lambda$0(this.$showUpdateDialog$delegate)) {
                    final Ref.ObjectRef<Job> objectRef = this.$updateJob;
                    final MutableState<Boolean> mutableState3 = this.$showUpdateDialog$delegate;
                    Function0<Unit> function2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.2.5
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
                            HomeEntryKt.HomeEntry$lambda$1(mutableState3, false);
                            Job job = objectRef.element;
                            if (job != null) {
                                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                            }
                        }
                    };
                    String strValueOf = String.valueOf(HomeEntryKt.HomeEntry$lambda$6(this.$latestRelease$delegate).getName());
                    final Ref.ObjectRef<Job> objectRef2 = this.$updateJob;
                    final CoroutineScope coroutineScope = this.$scope;
                    final MutableState<UpdateUtil.LatestRelease> mutableState4 = this.$latestRelease$delegate;
                    final ManagedActivityResultLauncher<String, Boolean> managedActivityResultLauncher = this.$launcher;
                    final MutableState<UpdateUtil.DownloadStatus> mutableState5 = this.$currentDownloadStatus$delegate;
                    final Context context = this.$context;
                    UpdateDialogKt.UpdateDialogImpl(function2, strValueOf, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt.HomeEntry.2.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$6$1, reason: invalid class name */
                        /* JADX INFO: compiled from: HomeEntry.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        @DebugMetadata(c = "com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$6$1", f = "HomeEntry.kt", i = {}, l = {328, 329}, m = "invokeSuspend", n = {}, s = {})
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ Context $context;
                            final /* synthetic */ MutableState<UpdateUtil.DownloadStatus> $currentDownloadStatus$delegate;
                            final /* synthetic */ MutableState<UpdateUtil.LatestRelease> $latestRelease$delegate;
                            final /* synthetic */ ManagedActivityResultLauncher<String, Boolean> $launcher;
                            private /* synthetic */ Object L$0;
                            Object L$1;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(MutableState<UpdateUtil.LatestRelease> mutableState, ManagedActivityResultLauncher<String, Boolean> managedActivityResultLauncher, MutableState<UpdateUtil.DownloadStatus> mutableState2, Context context, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$latestRelease$delegate = mutableState;
                                this.$launcher = managedActivityResultLauncher;
                                this.$currentDownloadStatus$delegate = mutableState2;
                                this.$context = context;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$latestRelease$delegate, this.$launcher, this.$currentDownloadStatus$delegate, this.$context, continuation);
                                anonymousClass1.L$0 = obj;
                                return anonymousClass1;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            /* JADX WARN: Code duplicated, block: B:21:0x0072 A[RETURN] */
                            /* JADX WARN: Code duplicated, block: B:22:0x0073  */
                            /* JADX WARN: Code duplicated, block: B:32:0x009b  */
                            /* JADX WARN: Code duplicated, block: B:34:0x00b9  */
                            /* JADX WARN: Multi-variable type inference failed */
                            /* JADX WARN: Type inference failed for: r0v10 */
                            /* JADX WARN: Type inference failed for: r0v11 */
                            /* JADX WARN: Type inference failed for: r0v12 */
                            /* JADX WARN: Type inference failed for: r0v2 */
                            /* JADX WARN: Type inference failed for: r0v3 */
                            /* JADX WARN: Type inference failed for: r0v4, types: [com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$6$1] */
                            /* JADX WARN: Type inference failed for: r0v5 */
                            /* JADX WARN: Type inference failed for: r0v6 */
                            /* JADX WARN: Type inference failed for: r0v7 */
                            /* JADX WARN: Type inference failed for: r0v8 */
                            /* JADX WARN: Type inference failed for: r0v9 */
                            /* JADX WARN: Type inference failed for: r11v0 */
                            /* JADX WARN: Type inference failed for: r1v0, types: [int] */
                            /* JADX WARN: Type inference failed for: r1v1 */
                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Throwable th;
                                ?? r0;
                                Object objM7557constructorimpl;
                                ?? r1;
                                Context context;
                                MutableState<UpdateUtil.DownloadStatus> mutableState;
                                Throwable thM7560exceptionOrNullimpl;
                                int i;
                                final ManagedActivityResultLauncher<String, Boolean> managedActivityResultLauncher;
                                final MutableState<UpdateUtil.DownloadStatus> mutableState2;
                                Object obj2;
                                AnonymousClass1 anonymousClass1;
                                FlowCollector flowCollector;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                obj = this.label;
                                try {
                                    switch (obj) {
                                        case 0:
                                            ResultKt.throwOnFailure(obj);
                                            MutableState<UpdateUtil.LatestRelease> mutableState3 = this.$latestRelease$delegate;
                                            ManagedActivityResultLauncher<String, Boolean> managedActivityResultLauncher2 = this.$launcher;
                                            MutableState<UpdateUtil.DownloadStatus> mutableState4 = this.$currentDownloadStatus$delegate;
                                            Result.Companion companion = Result.INSTANCE;
                                            i = 0;
                                            UpdateUtil updateUtil = UpdateUtil.INSTANCE;
                                            UpdateUtil.LatestRelease latestReleaseHomeEntry$lambda$6 = HomeEntryKt.HomeEntry$lambda$6(mutableState3);
                                            this.L$0 = managedActivityResultLauncher2;
                                            this.L$1 = mutableState4;
                                            this.label = 1;
                                            Object objDownloadApk$default = UpdateUtil.downloadApk$default(updateUtil, null, latestReleaseHomeEntry$lambda$6, this, 1, null);
                                            if (objDownloadApk$default == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            managedActivityResultLauncher = managedActivityResultLauncher2;
                                            mutableState2 = mutableState4;
                                            obj2 = objDownloadApk$default;
                                            anonymousClass1 = this;
                                            try {
                                                flowCollector = new FlowCollector() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$6$1$1$1
                                                    @Override // kotlinx.coroutines.flow.FlowCollector
                                                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                                        return emit((UpdateUtil.DownloadStatus) value, (Continuation<? super Unit>) $completion);
                                                    }

                                                    public final Object emit(UpdateUtil.DownloadStatus downloadStatus, Continuation<? super Unit> continuation) {
                                                        HomeEntryKt.HomeEntry$lambda$4(mutableState2, downloadStatus);
                                                        if ((downloadStatus instanceof UpdateUtil.DownloadStatus.Finished) && Build.VERSION.SDK_INT >= 23) {
                                                            managedActivityResultLauncher.launch("android.permission.REQUEST_INSTALL_PACKAGES");
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                anonymousClass1.L$0 = null;
                                                anonymousClass1.L$1 = null;
                                                anonymousClass1.label = 2;
                                                if (((Flow) obj2).collect(flowCollector, anonymousClass1) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                r0 = anonymousClass1;
                                                objM7557constructorimpl = Result.m7557constructorimpl(Unit.INSTANCE);
                                                r1 = r0;
                                                context = r1.$context;
                                                mutableState = r1.$currentDownloadStatus$delegate;
                                                thM7560exceptionOrNullimpl = Result.m7560exceptionOrNullimpl(objM7557constructorimpl);
                                                if (thM7560exceptionOrNullimpl == null) {
                                                    return Unit.INSTANCE;
                                                }
                                                thM7560exceptionOrNullimpl.printStackTrace();
                                                HomeEntryKt.HomeEntry$lambda$4(mutableState, UpdateUtil.DownloadStatus.NotYet.INSTANCE);
                                                ToastUtil toastUtil = ToastUtil.INSTANCE;
                                                String string = context.getString(R.string.app_update_failed);
                                                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                                toastUtil.makeToastSuspend(string);
                                                return Unit.INSTANCE;
                                            } catch (Throwable th2) {
                                                r0 = anonymousClass1;
                                                th = th2;
                                                Result.Companion companion2 = Result.INSTANCE;
                                                objM7557constructorimpl = Result.m7557constructorimpl(ResultKt.createFailure(th));
                                                r1 = r0;
                                            }
                                            break;
                                        case 1:
                                            mutableState2 = (MutableState) this.L$1;
                                            managedActivityResultLauncher = (ManagedActivityResultLauncher) this.L$0;
                                            ResultKt.throwOnFailure(obj);
                                            i = 0;
                                            anonymousClass1 = this;
                                            obj2 = obj;
                                            flowCollector = new FlowCollector() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$6$1$1$1
                                                @Override // kotlinx.coroutines.flow.FlowCollector
                                                public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                                    return emit((UpdateUtil.DownloadStatus) value, (Continuation<? super Unit>) $completion);
                                                }

                                                public final Object emit(UpdateUtil.DownloadStatus downloadStatus, Continuation<? super Unit> continuation) {
                                                    HomeEntryKt.HomeEntry$lambda$4(mutableState2, downloadStatus);
                                                    if ((downloadStatus instanceof UpdateUtil.DownloadStatus.Finished) && Build.VERSION.SDK_INT >= 23) {
                                                        managedActivityResultLauncher.launch("android.permission.REQUEST_INSTALL_PACKAGES");
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            anonymousClass1.L$0 = null;
                                            anonymousClass1.L$1 = null;
                                            anonymousClass1.label = 2;
                                            if (((Flow) obj2).collect(flowCollector, anonymousClass1) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            r0 = anonymousClass1;
                                            objM7557constructorimpl = Result.m7557constructorimpl(Unit.INSTANCE);
                                            r1 = r0;
                                            context = r1.$context;
                                            mutableState = r1.$currentDownloadStatus$delegate;
                                            thM7560exceptionOrNullimpl = Result.m7560exceptionOrNullimpl(objM7557constructorimpl);
                                            if (thM7560exceptionOrNullimpl == null) {
                                                return Unit.INSTANCE;
                                            }
                                            thM7560exceptionOrNullimpl.printStackTrace();
                                            HomeEntryKt.HomeEntry$lambda$4(mutableState, UpdateUtil.DownloadStatus.NotYet.INSTANCE);
                                            ToastUtil toastUtil2 = ToastUtil.INSTANCE;
                                            String string2 = context.getString(R.string.app_update_failed);
                                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                            toastUtil2.makeToastSuspend(string2);
                                            return Unit.INSTANCE;
                                        case 2:
                                            r0 = this;
                                            try {
                                                ResultKt.throwOnFailure(obj);
                                                r0 = r0;
                                                objM7557constructorimpl = Result.m7557constructorimpl(Unit.INSTANCE);
                                                r1 = r0;
                                                break;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                Result.Companion companion3 = Result.INSTANCE;
                                                objM7557constructorimpl = Result.m7557constructorimpl(ResultKt.createFailure(th));
                                                r1 = r0;
                                            }
                                            context = r1.$context;
                                            mutableState = r1.$currentDownloadStatus$delegate;
                                            thM7560exceptionOrNullimpl = Result.m7560exceptionOrNullimpl(objM7557constructorimpl);
                                            if (thM7560exceptionOrNullimpl == null) {
                                                return Unit.INSTANCE;
                                            }
                                            thM7560exceptionOrNullimpl.printStackTrace();
                                            HomeEntryKt.HomeEntry$lambda$4(mutableState, UpdateUtil.DownloadStatus.NotYet.INSTANCE);
                                            ToastUtil toastUtil3 = ToastUtil.INSTANCE;
                                            String string3 = context.getString(R.string.app_update_failed);
                                            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                                            toastUtil3.makeToastSuspend(string3);
                                            return Unit.INSTANCE;
                                        default:
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                } catch (Throwable th4) {
                                    ?? r11 = obj;
                                    th = th4;
                                    r0 = r11;
                                }
                            }
                        }

                        /* JADX WARN: Type inference failed for: r1v1, types: [T, kotlinx.coroutines.Job] */
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            objectRef2.element = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new AnonymousClass1(mutableState4, managedActivityResultLauncher, mutableState5, context, null), 2, null);
                        }
                    }, String.valueOf(HomeEntryKt.HomeEntry$lambda$6(this.$latestRelease$delegate).getBody()), HomeEntryKt.HomeEntry$lambda$3(this.$currentDownloadStatus$delegate), $composer, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Downloader.State invoke$lambda$1(State<? extends Downloader.State> state) {
            Object thisObj$iv = state.getValue();
            return (Downloader.State) thisObj$iv;
        }
    }

    public static final void settingsGraph(NavGraphBuilder $this$settingsGraph, final CookiesViewModel cookiesViewModel, final Function0<Unit> onNavigateBack, final Function1<? super String, Unit> onNavigateTo) {
        Intrinsics.checkNotNullParameter($this$settingsGraph, "<this>");
        Intrinsics.checkNotNullParameter(cookiesViewModel, "cookiesViewModel");
        Intrinsics.checkNotNullParameter(onNavigateBack, "onNavigateBack");
        Intrinsics.checkNotNullParameter(onNavigateTo, "onNavigateTo");
        NavGraphBuilder $this$settingsGraph_u24lambda_u249 = new NavGraphBuilder($this$settingsGraph.getProvider(), Route.SETTINGS_PAGE, Route.SETTINGS);
        AnimatedComposableKt.animatedComposable$default($this$settingsGraph_u24lambda_u249, Route.DOWNLOAD_DIRECTORY, null, null, ComposableLambdaKt.composableLambdaInstance(69110861, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C358@15969L44:HomeEntry.kt#hmxj0r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(69110861, $changed, -1, "com.videshkarmakar.loop.ui.page.settingsGraph.<anonymous>.<anonymous> (HomeEntry.kt:358)");
                }
                DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences(onNavigateBack, $composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
        AnimatedComposableKt.animatedComposable$default($this$settingsGraph_u24lambda_u249, Route.SETTINGS_PAGE, null, null, ComposableLambdaKt.composableLambdaInstance(707175748, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C361@16086L120:HomeEntry.kt#hmxj0r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(707175748, $changed, -1, "com.videshkarmakar.loop.ui.page.settingsGraph.<anonymous>.<anonymous> (HomeEntry.kt:361)");
                }
                SettingsPageKt.SettingsPage(onNavigateBack, onNavigateTo, $composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
        AnimatedComposableKt.animatedComposable$default($this$settingsGraph_u24lambda_u249, Route.UPDATE, null, null, ComposableLambdaKt.composableLambdaInstance(2100000000, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() {
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
                Object value$iv;
                Object value$iv2;
                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C368@16355L20,369@16391L32,367@16294L129:HomeEntry.kt#hmxj0r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2100000000, $changed, -1, "com.videshkarmakar.loop.ui.page.settingsGraph.<anonymous>.<anonymous> (HomeEntry.kt:367)");
                }
                $composer.startReplaceGroup(-896330531);
                ComposerKt.sourceInformation($composer, "CC(remember):HomeEntry.kt#9igjgp");
                boolean invalid$iv = $composer.changed(onNavigateBack);
                final Function0<Unit> function0 = onNavigateBack;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0<Unit>() {
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
                            function0.invoke();
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                Function0 function1 = (Function0) value$iv;
                $composer.endReplaceGroup();
                $composer.startReplaceGroup(-896330495);
                ComposerKt.sourceInformation($composer, "CC(remember):HomeEntry.kt#9igjgp");
                boolean invalid$iv2 = $composer.changed(onNavigateTo);
                final Function1<String, Unit> function2 = onNavigateTo;
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new Function0<Unit>() {
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
                            function2.invoke(Route.HOME);
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                Function0 function3 = (Function0) value$iv2;
                $composer.endReplaceGroup();
                // Trigger update check when navigating to Update page or at app startup
                EffectsKt.LaunchedEffect(unit, new Function4<CoroutineScope, NavBackStackEntry, Composer, Integer, Unit>() {
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public final Unit invoke(CoroutineScope scope, NavBackStackEntry entry, Composer composer, Integer num) {
                        // Always trigger update check on app startup and when navigating to Update settings
                        UpdateUtil.checkForUpdate$default(UpdateUtil.INSTANCE, null, (Continuation<? super UpdateUtil.LatestRelease>) new Continuation<UpdateUtil.LatestRelease>() {
                            @Override // kotlin.coroutines.Continuation
                            public Object invokeSuspend(Object $result) {
                                if ($result instanceof UpdateUtil.LatestRelease latest) {
                                    if (latest != null) {
                                        Flow<UpdateUtil.DownloadStatus> flow = UpdateUtil.INSTANCE.downloadApk($composer.getLocalContext(), latest, (Continuation<? super Flow<? extends UpdateUtil.DownloadStatus>>) null);
                                        return flow;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }, 1, null);
                        return Unit.INSTANCE;
                    }
                }, $composer, 64);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return;
            }
        }), 6, null);
            }
        }), 6, null);
        AnimatedComposableKt.animatedComposable$default($this$settingsGraph_u24lambda_u249, Route.GENERAL_DOWNLOAD_PREFERENCES, null, null, ComposableLambdaKt.composableLambdaInstance(1961957765, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
                Object value$iv;
                Object value$iv2;
                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C368@16355L20,369@16391L32,367@16294L129:HomeEntry.kt#hmxj0r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1961957765, $changed, -1, "com.videshkarmakar.loop.ui.page.settingsGraph.<anonymous>.<anonymous> (HomeEntry.kt:367)");
                }
                $composer.startReplaceGroup(-896330531);
                ComposerKt.sourceInformation($composer, "CC(remember):HomeEntry.kt#9igjgp");
                boolean invalid$iv = $composer.changed(onNavigateBack);
                final Function0<Unit> function0 = onNavigateBack;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$3$1$1
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
                            function0.invoke();
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                Function0 function1 = (Function0) value$iv;
                $composer.endReplaceGroup();
                $composer.startReplaceGroup(-896330495);
                ComposerKt.sourceInformation($composer, "CC(remember):HomeEntry.kt#9igjgp");
                boolean invalid$iv2 = $composer.changed(onNavigateTo);
                final Function1<String, Unit> function2 = onNavigateTo;
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$3$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
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
                            function2.invoke(Route.TEMPLATE);
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                $composer.endReplaceGroup();
                GeneralDownloadPreferencesKt.GeneralDownloadPreferences(function1, (Function0) value$iv2, $composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
        AnimatedComposableKt.animatedComposable$default($this$settingsGraph_u24lambda_u249, Route.DOWNLOAD_FORMAT, null, null, ComposableLambdaKt.composableLambdaInstance(-1078227514, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
                Object value$iv;
                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C372@16557L72,372@16498L131:HomeEntry.kt#hmxj0r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1078227514, $changed, -1, "com.videshkarmakar.loop.ui.page.settingsGraph.<anonymous>.<anonymous> (HomeEntry.kt:372)");
                }
                Function0<Unit> function0 = onNavigateBack;
                $composer.startReplaceGroup(-896330329);
                ComposerKt.sourceInformation($composer, "CC(remember):HomeEntry.kt#9igjgp");
                boolean invalid$iv = $composer.changed(onNavigateTo);
                final Function1<String, Unit> function1 = onNavigateTo;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$4$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
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
                            function1.invoke(Route.SUBTITLE_PREFERENCES);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                DownloadFormatPreferencesKt.DownloadFormatPreferences(function0, (Function0) value$iv, $composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
        AnimatedComposableKt.animatedComposable$default($this$settingsGraph_u24lambda_u249, Route.SUBTITLE_PREFERENCES, null, null, ComposableLambdaKt.composableLambdaInstance(176554503, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
                Object value$iv;
                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C376@16716L20,376@16697L39:HomeEntry.kt#hmxj0r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(176554503, $changed, -1, "com.videshkarmakar.loop.ui.page.settingsGraph.<anonymous>.<anonymous> (HomeEntry.kt:376)");
                }
                $composer.startReplaceGroup(-896330170);
                ComposerKt.sourceInformation($composer, "CC(remember):HomeEntry.kt#9igjgp");
                boolean invalid$iv = $composer.changed(onNavigateBack);
                final Function0<Unit> function0 = onNavigateBack;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$5$1$1
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
                            function0.invoke();
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                SubtitlePreferenceKt.SubtitlePreference((Function0) value$iv, $composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
        AnimatedComposableKt.animatedComposable$default($this$settingsGraph_u24lambda_u249, Route.ABOUT, null, null, ComposableLambdaKt.composableLambdaInstance(1431336520, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
                Object value$iv;
                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C380@16891L41,378@16793L153:HomeEntry.kt#hmxj0r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1431336520, $changed, -1, "com.videshkarmakar.loop.ui.page.settingsGraph.<anonymous>.<anonymous> (HomeEntry.kt:378)");
                }
                Function0<Unit> function0 = onNavigateBack;
                $composer.startReplaceGroup(-896329995);
                ComposerKt.sourceInformation($composer, "CC(remember):HomeEntry.kt#9igjgp");
                boolean invalid$iv = $composer.changed(onNavigateTo);
                final Function1<String, Unit> function1 = onNavigateTo;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$6$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
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
                            function1.invoke(Route.DEVELOPER_CREDITS);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                AboutPageKt.AboutPage(function0, (Function0) value$iv, $composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
        AnimatedComposableKt.animatedComposable$default($this$settingsGraph_u24lambda_u249, Route.DEVELOPER_CREDITS, null, null, ComposableLambdaKt.composableLambdaInstance(-1608848759, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C383@17011L36:HomeEntry.kt#hmxj0r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1608848759, $changed, -1, "com.videshkarmakar.loop.ui.page.settingsGraph.<anonymous>.<anonymous> (HomeEntry.kt:383)");
                }
                DeveloperCreditsPageKt.DeveloperCreditsPage(onNavigateBack, $composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
        AnimatedComposableKt.animatedComposable$default($this$settingsGraph_u24lambda_u249, Route.APPEARANCE, null, null, ComposableLambdaKt.composableLambdaInstance(-354066742, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C386@17110L129:HomeEntry.kt#hmxj0r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-354066742, $changed, -1, "com.videshkarmakar.loop.ui.page.settingsGraph.<anonymous>.<anonymous> (HomeEntry.kt:386)");
                }
                AppearancePreferencesKt.AppearancePreferences(onNavigateBack, onNavigateTo, $composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
        AnimatedComposableKt.animatedComposable$default($this$settingsGraph_u24lambda_u249, Route.INTERACTION, null, null, ComposableLambdaKt.composableLambdaInstance(900715275, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C391@17298L50:HomeEntry.kt#hmxj0r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(900715275, $changed, -1, "com.videshkarmakar.loop.ui.page.settingsGraph.<anonymous>.<anonymous> (HomeEntry.kt:391)");
                }
                InteractionPreferencePageKt.InteractionPreferencePage(null, onNavigateBack, $composer, 0, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
        AnimatedComposableKt.animatedComposable$default($this$settingsGraph_u24lambda_u249, Route.LANGUAGES, null, null, ComposableLambdaKt.composableLambdaInstance(-2139470004, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
                Object value$iv;
                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C392@17410L20,392@17397L33:HomeEntry.kt#hmxj0r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2139470004, $changed, -1, "com.videshkarmakar.loop.ui.page.settingsGraph.<anonymous>.<anonymous> (HomeEntry.kt:392)");
                }
                $composer.startReplaceGroup(-896329476);
                ComposerKt.sourceInformation($composer, "CC(remember):HomeEntry.kt#9igjgp");
                boolean invalid$iv = $composer.changed(onNavigateBack);
                final Function0<Unit> function0 = onNavigateBack;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$10$1$1
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
                            function0.invoke();
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                LanguagesPageKt.LanguagePage((Function0) value$iv, $composer, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
        AnimatedComposableKt.animatedComposable$default($this$settingsGraph_u24lambda_u249, Route.DOWNLOAD_DIRECTORY, null, null, ComposableLambdaKt.composableLambdaInstance(2037004582, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
                Object value$iv;
                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C394@17529L20,394@17500L49:HomeEntry.kt#hmxj0r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2037004582, $changed, -1, "com.videshkarmakar.loop.ui.page.settingsGraph.<anonymous>.<anonymous> (HomeEntry.kt:394)");
                }
                $composer.startReplaceGroup(-896329357);
                ComposerKt.sourceInformation($composer, "CC(remember):HomeEntry.kt#9igjgp");
                boolean invalid$iv = $composer.changed(onNavigateBack);
                final Function0<Unit> function0 = onNavigateBack;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$11$1$1
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
                            function0.invoke();
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences((Function0) value$iv, $composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
        AnimatedComposableKt.animatedComposable$default($this$settingsGraph_u24lambda_u249, Route.TEMPLATE, null, null, ComposableLambdaKt.composableLambdaInstance(-1003180697, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
                Object value$iv;
                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C397@17667L71,397@17617L121:HomeEntry.kt#hmxj0r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1003180697, $changed, -1, "com.videshkarmakar.loop.ui.page.settingsGraph.<anonymous>.<anonymous> (HomeEntry.kt:397)");
                }
                Function0<Unit> function0 = onNavigateBack;
                $composer.startReplaceGroup(-896329219);
                ComposerKt.sourceInformation($composer, "CC(remember):HomeEntry.kt#9igjgp");
                boolean invalid$iv = $composer.changed(onNavigateTo);
                final Function1<String, Unit> function1 = onNavigateTo;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function1<Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$12$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int it2) {
                            function1.invoke(RouteKt.id(Route.TEMPLATE_EDIT, it2));
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                TemplateListPageKt.TemplateListPage(function0, (Function1) value$iv, $composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
        AnimatedComposableKt.animatedComposable$default($this$settingsGraph_u24lambda_u249, RouteKt.arg(Route.TEMPLATE_EDIT, "template_id"), CollectionsKt.listOf(NamedNavArgumentKt.navArgument("template_id", new Function1<NavArgumentBuilder, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$13
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavArgumentBuilder navArgumentBuilder) {
                invoke2(navArgumentBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavArgumentBuilder navArgument) {
                Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
                navArgument.setType(NavType.IntType);
            }
        })), null, ComposableLambdaKt.composableLambdaInstance(251601320, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C405@17946L79:HomeEntry.kt#hmxj0r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(251601320, $changed, -1, "com.videshkarmakar.loop.ui.page.settingsGraph.<anonymous>.<anonymous> (HomeEntry.kt:405)");
                }
                Function0<Unit> function0 = onNavigateBack;
                Bundle arguments = it.getArguments();
                TemplateEditPageKt.TemplateEditPage(function0, arguments != null ? arguments.getInt("template_id") : -1, $composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 4, null);
        AnimatedComposableKt.animatedComposable$default($this$settingsGraph_u24lambda_u249, Route.DARK_THEME, null, null, ComposableLambdaKt.composableLambdaInstance(1506383337, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$15
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
                Object value$iv;
                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C407@18104L20,407@18083L41:HomeEntry.kt#hmxj0r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1506383337, $changed, -1, "com.videshkarmakar.loop.ui.page.settingsGraph.<anonymous>.<anonymous> (HomeEntry.kt:407)");
                }
                $composer.startReplaceGroup(-896328782);
                ComposerKt.sourceInformation($composer, "CC(remember):HomeEntry.kt#9igjgp");
                boolean invalid$iv = $composer.changed(onNavigateBack);
                final Function0<Unit> function0 = onNavigateBack;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$15$1$1
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
                            function0.invoke();
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                DarkThemePreferencesKt.DarkThemePreferences((Function0) value$iv, $composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
        AnimatedComposableKt.animatedComposable$default($this$settingsGraph_u24lambda_u249, Route.NETWORK_PREFERENCES, null, null, ComposableLambdaKt.composableLambdaInstance(-1533801942, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$16
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
                Object value$iv;
                Object value$iv2;
                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C409@18244L66,411@18312L20,409@18195L137:HomeEntry.kt#hmxj0r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1533801942, $changed, -1, "com.videshkarmakar.loop.ui.page.settingsGraph.<anonymous>.<anonymous> (HomeEntry.kt:409)");
                }
                $composer.startReplaceGroup(-896328642);
                ComposerKt.sourceInformation($composer, "CC(remember):HomeEntry.kt#9igjgp");
                boolean invalid$iv = $composer.changed(onNavigateTo);
                final Function1<String, Unit> function1 = onNavigateTo;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$16$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
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
                            function1.invoke(Route.COOKIE_PROFILE);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                Function0 function0 = (Function0) value$iv;
                $composer.endReplaceGroup();
                $composer.startReplaceGroup(-896328574);
                ComposerKt.sourceInformation($composer, "CC(remember):HomeEntry.kt#9igjgp");
                boolean invalid$iv2 = $composer.changed(onNavigateBack);
                final Function0<Unit> function2 = onNavigateBack;
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$16$2$1
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
                            function2.invoke();
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                $composer.endReplaceGroup();
                NetworkPreferencesKt.NetworkPreferences(function0, (Function0) value$iv2, $composer, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
        AnimatedComposableKt.animatedComposable$default($this$settingsGraph_u24lambda_u249, Route.COOKIE_PROFILE, null, null, ComposableLambdaKt.composableLambdaInstance(-279019925, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$17
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
                Object value$iv;
                Object value$iv2;
                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C416@18526L48,417@18590L20,414@18406L204:HomeEntry.kt#hmxj0r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-279019925, $changed, -1, "com.videshkarmakar.loop.ui.page.settingsGraph.<anonymous>.<anonymous> (HomeEntry.kt:414)");
                }
                CookiesViewModel cookiesViewModel2 = cookiesViewModel;
                $composer.startReplaceGroup(-896328360);
                ComposerKt.sourceInformation($composer, "CC(remember):HomeEntry.kt#9igjgp");
                boolean invalid$iv = $composer.changed(onNavigateTo);
                final Function1<String, Unit> function1 = onNavigateTo;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$17$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
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
                            function1.invoke(Route.COOKIE_GENERATOR_WEBVIEW);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                Function0 function0 = (Function0) value$iv;
                $composer.endReplaceGroup();
                $composer.startReplaceGroup(-896328296);
                ComposerKt.sourceInformation($composer, "CC(remember):HomeEntry.kt#9igjgp");
                boolean invalid$iv2 = $composer.changed(onNavigateBack);
                final Function0<Unit> function2 = onNavigateBack;
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$17$2$1
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
                            function2.invoke();
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                $composer.endReplaceGroup();
                CookieProfilesPageKt.CookieProfilePage(cookiesViewModel2, function0, (Function0) value$iv2, $composer, 8, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
        AnimatedComposableKt.animatedComposable$default($this$settingsGraph_u24lambda_u249, Route.COOKIE_GENERATOR_WEBVIEW, null, null, ComposableLambdaKt.composableLambdaInstance(975762092, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$18
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(animatedVisibilityScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope animatedComposable, NavBackStackEntry it, Composer $composer, int $changed) {
                Object value$iv;
                Intrinsics.checkNotNullParameter(animatedComposable, "$this$animatedComposable");
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C422@18746L100,422@18716L130:HomeEntry.kt#hmxj0r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(975762092, $changed, -1, "com.videshkarmakar.loop.ui.page.settingsGraph.<anonymous>.<anonymous> (HomeEntry.kt:422)");
                }
                CookiesViewModel cookiesViewModel2 = cookiesViewModel;
                $composer.startReplaceGroup(-896328140);
                ComposerKt.sourceInformation($composer, "CC(remember):HomeEntry.kt#9igjgp");
                boolean invalid$iv = $composer.changed(onNavigateBack);
                final Function0<Unit> function0 = onNavigateBack;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.HomeEntryKt$settingsGraph$1$18$1$1
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
                            function0.invoke();
                            CookieManager.getInstance().flush();
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                WebViewPageKt.WebViewPage(cookiesViewModel2, (Function0) value$iv, $composer, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
        $this$settingsGraph.destination($this$settingsGraph_u24lambda_u249);
    }
}
