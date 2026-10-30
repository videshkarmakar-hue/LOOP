package com.videshkarmakar.loop.p006ui.page.settings;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.rounded.AudioFileKt;
import androidx.compose.material.icons.rounded.EnergySavingsLeafKt;
import androidx.compose.material.icons.rounded.FolderKt;
import androidx.compose.material.icons.rounded.InfoKt;
import androidx.compose.material.icons.rounded.SettingsApplicationsKt;
import androidx.compose.material.icons.rounded.SignalCellular4BarKt;
import androidx.compose.material.icons.rounded.SignalWifi4BarKt;
import androidx.compose.material.icons.rounded.TerminalKt;
import androidx.compose.material.icons.rounded.VideoFileKt;
import androidx.compose.material.icons.rounded.ViewComfyKt;
import androidx.compose.material.icons.rounded.VolunteerActivismKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.vector.ImageVector;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.platform.UriHandler;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.App;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.common.Route;
import com.videshkarmakar.loop.p006ui.common.motion.AnimationSpecsKt;
import com.videshkarmakar.loop.p006ui.component.IconButtonsKt;
import com.videshkarmakar.loop.p006ui.component.PreferenceItemsKt;
import com.videshkarmakar.loop.p006ui.component.SettingsBadge;
import com.videshkarmakar.loop.p006ui.component.SettingsPanelKt;
import com.videshkarmakar.loop.p006ui.component.TopAppBarKt;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.p013io.FileUtils;

/* JADX INFO: compiled from: SettingsPage.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u001a/\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0007H\u0007¢\u0006\u0002\u0010\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002²\u0006\f\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u008a\u008e\u0002"}, m195d2 = {"DEVELOPER_PORTRAIT", "", "SettingsPage", "", "onNavigateBack", "Lkotlin/Function0;", "onNavigateTo", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_debug", "showBatteryHint", "", "showSponsorMessage", "", "lastVisited"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SettingsPageKt {
    private static final String DEVELOPER_PORTRAIT = "https://cdn.phototourl.com/member/2026-09-24-d3b8ff6f-f0d4-43e0-9082-9f39cc851774.png";

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void SettingsPage(final Function0<Unit> onNavigateBack, final Function1<? super String, Unit> onNavigateTo, Composer $composer, final int $changed) {
        Object value$iv;
        Intent $this$SettingsPage_u24lambda_u243;
        final boolean isActivityAvailable;
        Object it$iv$iv;
        Object value$iv$iv;
        Object value$iv2;
        Object value$iv3;
        SettingsPageKt$SettingsPage$1$1 value$iv4;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onNavigateBack, "onNavigateBack");
        Intrinsics.checkNotNullParameter(onNavigateTo, "onNavigateTo");
        Composer $composer3 = $composer.startRestartGroup(-2025527651);
        ComposerKt.sourceInformation($composer3, "C(SettingsPage)97@4853L7,98@4898L7,100@5010L245,128@5950L265,133@6259L22,135@6330L8,137@6456L42,139@6533L72,144@6632L66,144@6611L87,154@6953L234,160@7189L7534,151@6822L7901:SettingsPage.kt#y7hb8m");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onNavigateBack) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(onNavigateTo) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2025527651, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.SettingsPage (SettingsPage.kt:96)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Context context = (Context) objConsume;
            ProvidableCompositionLocal<UriHandler> localUriHandler = CompositionLocalsKt.getLocalUriHandler();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localUriHandler);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final UriHandler uriHandler = (UriHandler) objConsume2;
            Object systemService = context.getSystemService("power");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            final PowerManager pm = (PowerManager) systemService;
            $composer3.startReplaceGroup(-357914984);
            ComposerKt.sourceInformation($composer3, "CC(remember):SettingsPage.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                boolean z = Build.VERSION.SDK_INT >= 23 && !pm.isIgnoringBatteryOptimizations(context.getPackageName());
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState showBatteryHint$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            if (Build.VERSION.SDK_INT >= 23) {
                $this$SettingsPage_u24lambda_u243 = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                $this$SettingsPage_u24lambda_u243.setData(Uri.parse("package:" + context.getPackageName()));
            } else {
                $this$SettingsPage_u24lambda_u243 = new Intent();
            }
            final Intent intent = $this$SettingsPage_u24lambda_u243;
            if (Build.VERSION.SDK_INT < 23) {
                isActivityAvailable = false;
            } else if (Build.VERSION.SDK_INT < 33) {
                List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 131072);
                Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
                isActivityAvailable = !listQueryIntentActivities.isEmpty();
            } else {
                List<ResolveInfo> listQueryIntentActivities2 = context.getPackageManager().queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(FileUtils.ONE_MB));
                Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities2, "queryIntentActivities(...)");
                isActivityAvailable = !listQueryIntentActivities2.isEmpty();
            }
            final ManagedActivityResultLauncher launcher = ActivityResultRegistryKt.rememberLauncherForActivityResult(new ActivityResultContracts.StartActivityForResult(), new Function1<ActivityResult, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt$SettingsPage$launcher$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ActivityResult activityResult) {
                    invoke2(activityResult);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ActivityResult it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (Build.VERSION.SDK_INT >= 23) {
                        SettingsPageKt.SettingsPage$lambda$2(showBatteryHint$delegate, !pm.isIgnoringBatteryOptimizations(context.getPackageName()));
                    }
                }
            }, $composer3, 8);
            final TopAppBarScrollBehavior scrollBehavior = TopAppBarDefaults.INSTANCE.pinnedScrollBehavior(null, null, $composer3, TopAppBarDefaults.$stable << 6, 3);
            $composer3.startReplaceGroup(1963460724);
            ComposerKt.sourceInformation($composer3, "CC19@677L57:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(302245525);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv2 = $composer3.rememberedValue();
            if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                it$iv$iv = null;
                value$iv$iv = SnapshotIntStateKt.mutableIntStateOf(PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.SHOW_SPONSOR_MSG, 0, 1, null));
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                it$iv$iv = null;
                value$iv$iv = it$iv$iv2;
            }
            final MutableIntState showSponsorMessage$delegate = (MutableIntState) value$iv$iv;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-357913538);
            ComposerKt.sourceInformation($composer3, "CC(remember):SettingsPage.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableState lastVisited$delegate = (MutableState) value$iv2;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-357913461);
            ComposerKt.sourceInformation($composer3, "CC(remember):SettingsPage.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 112) == 32;
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt$SettingsPage$open$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String route) {
                        Intrinsics.checkNotNullParameter(route, "route");
                        lastVisited$delegate.setValue(route);
                        onNavigateTo.invoke(route);
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final Function1 open = (Function1) value$iv3;
            $composer3.endReplaceGroup();
            Unit unit = Unit.INSTANCE;
            $composer3.startReplaceGroup(-357913362);
            ComposerKt.sourceInformation($composer3, "CC(remember):SettingsPage.kt#9igjgp");
            boolean invalid$iv2 = $composer3.changed(showSponsorMessage$delegate);
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = new SettingsPageKt$SettingsPage$1$1(showSponsorMessage$delegate, null);
                $composer3.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            $composer3.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer3, 70);
            final boolean extractAudio = PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.EXTRACT_AUDIO, false, 1, null);
            final boolean isMetered = App.INSTANCE.getConnectivityManager().isActiveNetworkMetered();
            $composer2 = $composer3;
            ScaffoldKt.m2530ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollBehavior.getNestedScrollConnection(), null, 2, null), ComposableLambdaKt.rememberComposableLambda(457123425, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt.SettingsPage.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C156@7011L38,157@7084L30,155@6967L210:SettingsPage.kt#y7hb8m");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(457123425, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.SettingsPage.<anonymous> (SettingsPage.kt:155)");
                        }
                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.settings, $composer4, 0);
                        TopAppBarScrollBehavior topAppBarScrollBehavior = scrollBehavior;
                        final Function0<Unit> function0 = onNavigateBack;
                        TopAppBarKt.SmallTopAppBar(null, strStringResource, topAppBarScrollBehavior, null, ComposableLambdaKt.rememberComposableLambda(840007378, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt.SettingsPage.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C157@7086L26:SettingsPage.kt#y7hb8m");
                                if (($changed3 & 11) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(840007378, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.SettingsPage.<anonymous>.<anonymous> (SettingsPage.kt:157)");
                                }
                                IconButtonsKt.BackButton(function0, $composer5, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), null, $composer4, CpioConstants.C_ISBLK, 41);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(2042965868, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt.SettingsPage.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
                    invoke(paddingValues, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues it, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer4, "C161@7199L7518:SettingsPage.kt#y7hb8m");
                    int $dirty3 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty3 |= $composer4.changed(it) ? 4 : 2;
                    }
                    int $dirty4 = $dirty3;
                    if (($dirty4 & 91) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2042965868, $dirty4, -1, "com.videshkarmakar.loop.ui.page.settings.SettingsPage.<anonymous> (SettingsPage.kt:161)");
                        }
                        Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, it);
                        final boolean z2 = isActivityAvailable;
                        final MutableState<Boolean> mutableState = showBatteryHint$delegate;
                        final ManagedActivityResultLauncher<Intent, ActivityResult> managedActivityResultLauncher = launcher;
                        final Intent intent2 = intent;
                        final PowerManager powerManager = pm;
                        final Context context2 = context;
                        final MutableIntState mutableIntState = showSponsorMessage$delegate;
                        final UriHandler uriHandler2 = uriHandler;
                        final Function1<String, Unit> function1 = open;
                        final MutableState<String> mutableState2 = lastVisited$delegate;
                        final boolean z3 = extractAudio;
                        final boolean z4 = isMetered;
                        LazyDslKt.LazyColumn(modifierPadding, null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt.SettingsPage.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$SettingsPageKt.INSTANCE.m7426getLambda1$app_debug(), 3, null);
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$SettingsPageKt.INSTANCE.m7427getLambda2$app_debug(), 3, null);
                                if (Build.VERSION.SDK_INT >= 23) {
                                    final boolean z5 = z2;
                                    final MutableState<Boolean> mutableState3 = mutableState;
                                    final ManagedActivityResultLauncher<Intent, ActivityResult> managedActivityResultLauncher2 = managedActivityResultLauncher;
                                    final Intent intent3 = intent2;
                                    final PowerManager powerManager2 = powerManager;
                                    final Context context3 = context2;
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(24252893, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt.SettingsPage.3.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                            invoke(lazyItemScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope item, Composer $composer5, int $changed3) {
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer5, "C229@10282L555,202@8879L1958:SettingsPage.kt#y7hb8m");
                                            if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(24252893, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.SettingsPage.<anonymous>.<anonymous>.<anonymous> (SettingsPage.kt:202)");
                                                }
                                                boolean z6 = SettingsPageKt.SettingsPage$lambda$1(mutableState3) && z5;
                                                EnterTransition enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.tween$default(280, 0, AnimationSpecsKt.getEmphasizeEasing(), 2, null), null, false, null, 14, null).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(200, 0, AnimationSpecsKt.getEmphasizeEasing(), 2, null), 0.0f, 2, null));
                                                ExitTransition exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(240, 0, AnimationSpecsKt.getEmphasizeEasing(), 2, null), null, false, null, 14, null).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(160, 0, AnimationSpecsKt.getEmphasizeEasing(), 2, null), 0.0f, 2, null));
                                                final ManagedActivityResultLauncher<Intent, ActivityResult> managedActivityResultLauncher3 = managedActivityResultLauncher2;
                                                final Intent intent4 = intent3;
                                                final PowerManager powerManager3 = powerManager2;
                                                final Context context4 = context3;
                                                final MutableState<Boolean> mutableState4 = mutableState3;
                                                AnimatedVisibilityKt.AnimatedVisibility(z6, (Modifier) null, enterTransitionPlus, exitTransitionPlus, (String) null, ComposableLambdaKt.rememberComposableLambda(-359067643, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt.SettingsPage.3.1.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                                        invoke(animatedVisibilityScope, composer, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer6, int $changed4) {
                                                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                                        ComposerKt.sourceInformation($composer6, "C231@10365L46,233@10523L51,230@10308L507:SettingsPage.kt#y7hb8m");
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-359067643, $changed4, -1, "com.videshkarmakar.loop.ui.page.settings.SettingsPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsPage.kt:230)");
                                                        }
                                                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.battery_configuration, $composer6, 0);
                                                        ImageVector energySavingsLeaf = EnergySavingsLeafKt.getEnergySavingsLeaf(Icons.Rounded.INSTANCE);
                                                        String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.battery_configuration_desc, $composer6, 0);
                                                        final ManagedActivityResultLauncher<Intent, ActivityResult> managedActivityResultLauncher4 = managedActivityResultLauncher3;
                                                        final Intent intent5 = intent4;
                                                        final PowerManager powerManager4 = powerManager3;
                                                        final Context context5 = context4;
                                                        final MutableState<Boolean> mutableState5 = mutableState4;
                                                        PreferenceItemsKt.m7313PreferencesHintCardjB83MbM(strStringResource, strStringResource2, energySavingsLeaf, 0L, 0L, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt.SettingsPage.3.1.1.1.1
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
                                                                managedActivityResultLauncher4.launch(intent5);
                                                                SettingsPageKt.SettingsPage$lambda$2(mutableState5, !powerManager4.isIgnoringBatteryOptimizations(context5.getPackageName()));
                                                            }
                                                        }, $composer6, 0, 24);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, $composer5, 54), $composer5, 200064, 18);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer5.skipToGroupEnd();
                                        }
                                    }), 3, null);
                                }
                                if (!SettingsPageKt.SettingsPage$lambda$1(mutableState) && SettingsPageKt.SettingsPage$lambda$4(mutableIntState) > 30) {
                                    final UriHandler uriHandler3 = uriHandler2;
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1181470918, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt.SettingsPage.3.1.2
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                            invoke(lazyItemScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope item, Composer $composer5, int $changed3) {
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer5, "C245@11027L37,247@11168L42,244@10974L367:SettingsPage.kt#y7hb8m");
                                            if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1181470918, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.SettingsPage.<anonymous>.<anonymous>.<anonymous> (SettingsPage.kt:244)");
                                                }
                                                String strStringResource = StringResources_androidKt.stringResource(C3070R.string.sponsor, $composer5, 0);
                                                ImageVector volunteerActivism = VolunteerActivismKt.getVolunteerActivism(Icons.Rounded.INSTANCE);
                                                String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.sponsor_desc, $composer5, 0);
                                                final UriHandler uriHandler4 = uriHandler3;
                                                PreferenceItemsKt.m7313PreferencesHintCardjB83MbM(strStringResource, strStringResource2, volunteerActivism, 0L, 0L, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt.SettingsPage.3.1.2.1
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
                                                        uriHandler4.openUri("https://github.com/sponsors/JunkFood02");
                                                    }
                                                }, $composer5, 0, 24);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer5.skipToGroupEnd();
                                        }
                                    }), 3, null);
                                }
                                final Function1<String, Unit> function2 = function1;
                                final MutableState<String> mutableState4 = mutableState2;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1955904800, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt.SettingsPage.3.1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer5, int $changed3) {
                                        Object value$iv5;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C255@11440L46,258@11663L44,254@11396L329:SettingsPage.kt#y7hb8m");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1955904800, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.SettingsPage.<anonymous>.<anonymous>.<anonymous> (SettingsPage.kt:254)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.general_settings, $composer5, 0);
                                            ImageVector settingsApplications = SettingsApplicationsKt.getSettingsApplications(Icons.Rounded.INSTANCE);
                                            boolean zAreEqual = Intrinsics.areEqual(SettingsPageKt.SettingsPage$lambda$6(mutableState4), Route.GENERAL_DOWNLOAD_PREFERENCES);
                                            $composer5.startReplaceGroup(490078072);
                                            ComposerKt.sourceInformation($composer5, "CC(remember):SettingsPage.kt#9igjgp");
                                            boolean invalid$iv3 = $composer5.changed(function2);
                                            final Function1<String, Unit> function3 = function2;
                                            Object it$iv5 = $composer5.rememberedValue();
                                            if (invalid$iv3 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                                value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt$SettingsPage$3$1$3$1$1
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
                                                        function3.invoke(Route.GENERAL_DOWNLOAD_PREFERENCES);
                                                    }
                                                };
                                                $composer5.updateRememberedValue(value$iv5);
                                            } else {
                                                value$iv5 = it$iv5;
                                            }
                                            $composer5.endReplaceGroup();
                                            SettingsPanelKt.SettingsNavRow(strStringResource, settingsApplications, zAreEqual, (Function0) value$iv5, null, null, $composer5, 0, 48);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 3, null);
                                final Function1<String, Unit> function3 = function1;
                                final MutableState<String> mutableState5 = mutableState2;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1044643649, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt.SettingsPage.3.1.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer5, int $changed3) {
                                        Object value$iv5;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C263@11819L48,266@12020L34,262@11775L297:SettingsPage.kt#y7hb8m");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1044643649, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.SettingsPage.<anonymous>.<anonymous>.<anonymous> (SettingsPage.kt:262)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.download_directory, $composer5, 0);
                                            ImageVector folder = FolderKt.getFolder(Icons.Rounded.INSTANCE);
                                            boolean zAreEqual = Intrinsics.areEqual(SettingsPageKt.SettingsPage$lambda$6(mutableState5), Route.DOWNLOAD_DIRECTORY);
                                            $composer5.startReplaceGroup(490078429);
                                            ComposerKt.sourceInformation($composer5, "CC(remember):SettingsPage.kt#9igjgp");
                                            boolean invalid$iv3 = $composer5.changed(function3);
                                            final Function1<String, Unit> function4 = function3;
                                            Object it$iv5 = $composer5.rememberedValue();
                                            if (invalid$iv3 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                                value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt$SettingsPage$3$1$4$1$1
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
                                                        function4.invoke(Route.DOWNLOAD_DIRECTORY);
                                                    }
                                                };
                                                $composer5.updateRememberedValue(value$iv5);
                                            } else {
                                                value$iv5 = it$iv5;
                                            }
                                            $composer5.endReplaceGroup();
                                            SettingsPanelKt.SettingsNavRow(strStringResource, folder, zAreEqual, (Function0) value$iv5, null, null, $composer5, 0, 48);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 3, null);
                                final boolean z6 = z3;
                                final Function1<String, Unit> function4 = function1;
                                final MutableState<String> mutableState6 = mutableState2;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(249775198, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt.SettingsPage.3.1.5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer5, int $changed3) {
                                        Object value$iv5;
                                        SettingsBadge settingsBadge;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C271@12166L36,274@12402L31,270@12122L562:SettingsPage.kt#y7hb8m");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(249775198, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.SettingsPage.<anonymous>.<anonymous>.<anonymous> (SettingsPage.kt:270)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.format, $composer5, 0);
                                            ImageVector audioFile = z6 ? AudioFileKt.getAudioFile(Icons.Rounded.INSTANCE) : VideoFileKt.getVideoFile(Icons.Rounded.INSTANCE);
                                            boolean zAreEqual = Intrinsics.areEqual(SettingsPageKt.SettingsPage$lambda$6(mutableState6), Route.DOWNLOAD_FORMAT);
                                            $composer5.startReplaceGroup(490078811);
                                            ComposerKt.sourceInformation($composer5, "CC(remember):SettingsPage.kt#9igjgp");
                                            boolean invalid$iv3 = $composer5.changed(function4);
                                            final Function1<String, Unit> function5 = function4;
                                            Object it$iv5 = $composer5.rememberedValue();
                                            if (invalid$iv3 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                                value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt$SettingsPage$3$1$5$1$1
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
                                                        function5.invoke(Route.DOWNLOAD_FORMAT);
                                                    }
                                                };
                                                $composer5.updateRememberedValue(value$iv5);
                                            } else {
                                                value$iv5 = it$iv5;
                                            }
                                            Function0 function0 = (Function0) value$iv5;
                                            $composer5.endReplaceGroup();
                                            $composer5.startReplaceGroup(490078872);
                                            ComposerKt.sourceInformation($composer5, "276@12528L50");
                                            if (z6) {
                                                settingsBadge = new SettingsBadge(StringResources_androidKt.stringResource(C3070R.string.settings_badge_audio, $composer5, 0), AudioFileKt.getAudioFile(Icons.Rounded.INSTANCE));
                                            } else {
                                                settingsBadge = null;
                                            }
                                            $composer5.endReplaceGroup();
                                            SettingsPanelKt.SettingsNavRow(strStringResource, audioFile, zAreEqual, function0, null, settingsBadge, $composer5, 0, 16);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 3, null);
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$SettingsPageKt.INSTANCE.m7428getLambda3$app_debug(), 3, null);
                                final Function1<String, Unit> function5 = function1;
                                final MutableState<String> mutableState7 = mutableState2;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1456354404, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt.SettingsPage.3.1.6
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer5, int $changed3) {
                                        Object value$iv5;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C286@12824L55,289@13028L27,285@12780L293:SettingsPage.kt#y7hb8m");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1456354404, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.SettingsPage.<anonymous>.<anonymous>.<anonymous> (SettingsPage.kt:285)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.interface_and_interaction, $composer5, 0);
                                            ImageVector viewComfy = ViewComfyKt.getViewComfy(Icons.Rounded.INSTANCE);
                                            boolean zAreEqual = Intrinsics.areEqual(SettingsPageKt.SettingsPage$lambda$6(mutableState7), Route.INTERACTION);
                                            $composer5.startReplaceGroup(490079437);
                                            ComposerKt.sourceInformation($composer5, "CC(remember):SettingsPage.kt#9igjgp");
                                            boolean invalid$iv3 = $composer5.changed(function5);
                                            final Function1<String, Unit> function6 = function5;
                                            Object it$iv5 = $composer5.rememberedValue();
                                            if (invalid$iv3 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                                value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt$SettingsPage$3$1$6$1$1
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
                                                        function6.invoke(Route.INTERACTION);
                                                    }
                                                };
                                                $composer5.updateRememberedValue(value$iv5);
                                            } else {
                                                value$iv5 = it$iv5;
                                            }
                                            $composer5.endReplaceGroup();
                                            SettingsPanelKt.SettingsNavRow(strStringResource, viewComfy, zAreEqual, (Function0) value$iv5, null, null, $composer5, 0, 48);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 3, null);
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$SettingsPageKt.INSTANCE.m7429getLambda4$app_debug(), 3, null);
                                final boolean z7 = z4;
                                final Function1<String, Unit> function6 = function1;
                                final MutableState<String> mutableState8 = mutableState2;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1132483290, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt.SettingsPage.3.1.7
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer5, int $changed3) {
                                        Object value$iv5;
                                        SettingsBadge settingsBadge;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C297@13213L37,301@13485L35,296@13169L610:SettingsPage.kt#y7hb8m");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1132483290, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.SettingsPage.<anonymous>.<anonymous>.<anonymous> (SettingsPage.kt:296)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.network, $composer5, 0);
                                            ImageVector signalCellular4Bar = z7 ? SignalCellular4BarKt.getSignalCellular4Bar(Icons.Rounded.INSTANCE) : SignalWifi4BarKt.getSignalWifi4Bar(Icons.Rounded.INSTANCE);
                                            boolean zAreEqual = Intrinsics.areEqual(SettingsPageKt.SettingsPage$lambda$6(mutableState8), Route.NETWORK_PREFERENCES);
                                            $composer5.startReplaceGroup(490079894);
                                            ComposerKt.sourceInformation($composer5, "CC(remember):SettingsPage.kt#9igjgp");
                                            boolean invalid$iv3 = $composer5.changed(function6);
                                            final Function1<String, Unit> function7 = function6;
                                            Object it$iv5 = $composer5.rememberedValue();
                                            if (invalid$iv3 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                                value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt$SettingsPage$3$1$7$1$1
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
                                                        function7.invoke(Route.NETWORK_PREFERENCES);
                                                    }
                                                };
                                                $composer5.updateRememberedValue(value$iv5);
                                            } else {
                                                value$iv5 = it$iv5;
                                            }
                                            Function0 function0 = (Function0) value$iv5;
                                            $composer5.endReplaceGroup();
                                            $composer5.startReplaceGroup(490079959);
                                            ComposerKt.sourceInformation($composer5, "303@13612L52");
                                            if (z7) {
                                                settingsBadge = new SettingsBadge(StringResources_androidKt.stringResource(C3070R.string.settings_badge_metered, $composer5, 0), SignalCellular4BarKt.getSignalCellular4Bar(Icons.Rounded.INSTANCE));
                                            } else {
                                                settingsBadge = null;
                                            }
                                            $composer5.endReplaceGroup();
                                            SettingsPanelKt.SettingsNavRow(strStringResource, signalCellular4Bar, zAreEqual, function0, null, settingsBadge, $composer5, 0, 16);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 3, null);
                                final Function1<String, Unit> function7 = function1;
                                final MutableState<String> mutableState9 = mutableState2;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1868065159, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt.SettingsPage.3.1.8
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer5, int $changed3) {
                                        Object value$iv5;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C310@13873L44,313@14062L24,309@13829L275:SettingsPage.kt#y7hb8m");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1868065159, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.SettingsPage.<anonymous>.<anonymous>.<anonymous> (SettingsPage.kt:309)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.custom_command, $composer5, 0);
                                            ImageVector terminal = TerminalKt.getTerminal(Icons.Rounded.INSTANCE);
                                            boolean zAreEqual = Intrinsics.areEqual(SettingsPageKt.SettingsPage$lambda$6(mutableState9), Route.TEMPLATE);
                                            $composer5.startReplaceGroup(490080471);
                                            ComposerKt.sourceInformation($composer5, "CC(remember):SettingsPage.kt#9igjgp");
                                            boolean invalid$iv3 = $composer5.changed(function7);
                                            final Function1<String, Unit> function8 = function7;
                                            Object it$iv5 = $composer5.rememberedValue();
                                            if (invalid$iv3 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                                value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt$SettingsPage$3$1$8$1$1
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
                                                        function8.invoke(Route.TEMPLATE);
                                                    }
                                                };
                                                $composer5.updateRememberedValue(value$iv5);
                                            } else {
                                                value$iv5 = it$iv5;
                                            }
                                            $composer5.endReplaceGroup();
                                            SettingsPanelKt.SettingsNavRow(strStringResource, terminal, zAreEqual, (Function0) value$iv5, null, null, $composer5, 0, 48);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 3, null);
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$SettingsPageKt.INSTANCE.m7430getLambda5$app_debug(), 3, null);
                                final Function1<String, Unit> function8 = function1;
                                final MutableState<String> mutableState10 = mutableState2;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(73209630, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt.SettingsPage.3.1.9
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer5, int $changed3) {
                                        Object value$iv5;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C321@14244L35,324@14417L21,320@14200L256:SettingsPage.kt#y7hb8m");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(73209630, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.SettingsPage.<anonymous>.<anonymous>.<anonymous> (SettingsPage.kt:320)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.about, $composer5, 0);
                                            ImageVector info = InfoKt.getInfo(Icons.Rounded.INSTANCE);
                                            boolean zAreEqual = Intrinsics.areEqual(SettingsPageKt.SettingsPage$lambda$6(mutableState10), Route.ABOUT);
                                            $composer5.startReplaceGroup(490080826);
                                            ComposerKt.sourceInformation($composer5, "CC(remember):SettingsPage.kt#9igjgp");
                                            boolean invalid$iv3 = $composer5.changed(function8);
                                            final Function1<String, Unit> function9 = function8;
                                            Object it$iv5 = $composer5.rememberedValue();
                                            if (invalid$iv3 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                                value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt$SettingsPage$3$1$9$1$1
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
                                                        function9.invoke(Route.ABOUT);
                                                    }
                                                };
                                                $composer5.updateRememberedValue(value$iv5);
                                            } else {
                                                value$iv5 = it$iv5;
                                            }
                                            $composer5.endReplaceGroup();
                                            SettingsPanelKt.SettingsNavRow(strStringResource, info, zAreEqual, (Function0) value$iv5, null, null, $composer5, 0, 48);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 3, null);
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$SettingsPageKt.INSTANCE.m7431getLambda6$app_debug(), 3, null);
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$SettingsPageKt.INSTANCE.m7432getLambda7$app_debug(), 3, null);
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$SettingsPageKt.INSTANCE.m7433getLambda8$app_debug(), 3, null);
                            }
                        }, $composer4, 0, 254);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer2, 805306416, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.SettingsPageKt.SettingsPage.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    SettingsPageKt.SettingsPage(onNavigateBack, onNavigateTo, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SettingsPage$lambda$1(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsPage$lambda$2(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int SettingsPage$lambda$4(MutableIntState $showSponsorMessage$delegate) {
        MutableIntState $this$getValue$iv = $showSponsorMessage$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SettingsPage$lambda$6(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }
}
