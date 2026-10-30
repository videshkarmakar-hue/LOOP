package com.videshkarmakar.loop.p006ui.page.settings.appearance;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.TranslateKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.vector.ImageVector;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.platform.UriHandler;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.component.DividerKt;
import com.videshkarmakar.loop.p006ui.component.IconButtonsKt;
import com.videshkarmakar.loop.p006ui.component.PreferenceItemsKt;
import com.videshkarmakar.loop.p006ui.component.TopAppBarKt;
import com.videshkarmakar.loop.p006ui.theme.ThemeKt;
import com.videshkarmakar.loop.util.LanguageSettingsKt;
import com.videshkarmakar.loop.util.LinksKt;
import com.videshkarmakar.loop.util.PreferenceUtil;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.p009ws.WebSocketProtocol;

/* JADX INFO: compiled from: LanguagesPage.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m194d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001ac\u0010\u0005\u001a\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\f\u001a\u00020\b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0003¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0010\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0011¨\u0006\u0012²\u0006\u0012\u0010\f\u001a\n \u0013*\u0004\u0018\u00010\b0\bX\u008a\u0084\u0002²\u0006\u0012\u0010\u0014\u001a\n \u0013*\u0004\u0018\u00010\b0\bX\u008a\u008e\u0002"}, m195d2 = {"LanguagePage", "", "onNavigateBack", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "LanguagePageImpl", "localeSet", "", "Ljava/util/Locale;", "isSystemLocaleSettingsAvailable", "", "onNavigateToSystemLocaleSettings", "selectedLocale", "onLanguageSelected", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Ljava/util/Set;ZLkotlin/jvm/functions/Function0;Ljava/util/Locale;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LanguagePagePreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "kotlin.jvm.PlatformType", "language"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LanguagesPageKt {
    public static final void LanguagePage(Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function1;
        final Function0<Unit> function2;
        Object value$iv;
        Object value$iv$iv;
        Intent $this$LanguagePage_u24lambda_u242;
        boolean z;
        Composer $composer2 = $composer.startRestartGroup(-2128307565);
        ComposerKt.sourceInformation($composer2, "C(LanguagePage)60@2704L48,61@2769L24,62@2825L7,80@3409L475:LanguagesPage.kt#n7ajos");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            function1 = function0;
        } else if (($changed & 14) == 0) {
            function1 = function0;
            $dirty |= $composer2.changedInstance(function1) ? 4 : 2;
        } else {
            function1 = function0;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 11) != 2 || !$composer2.getSkipping()) {
            function2 = i2 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePage.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2128307565, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.LanguagePage (LanguagesPage.kt:59)");
            }
            $composer2.startReplaceGroup(-1701093369);
            ComposerKt.sourceInformation($composer2, "CC(remember):LanguagesPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Locale.getDefault(), null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MutableState selectedLocale$delegate = (MutableState) value$iv;
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
            wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Context context = (Context) objConsume;
            if (Build.VERSION.SDK_INT >= 33) {
                $this$LanguagePage_u24lambda_u242 = new Intent("android.settings.APP_LOCALE_SETTINGS");
                Uri uri = Uri.fromParts("package", context.getPackageName(), null);
                $this$LanguagePage_u24lambda_u242.setData(uri);
            } else {
                $this$LanguagePage_u24lambda_u242 = new Intent();
            }
            final Intent intent = $this$LanguagePage_u24lambda_u242;
            if (Build.VERSION.SDK_INT >= 33) {
                List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 131072);
                Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
                z = !listQueryIntentActivities.isEmpty();
            } else {
                z = false;
            }
            final boolean isSystemLocaleSettingsAvailable = z;
            Set<Locale> setKeySet = LanguageSettingsKt.getLocaleLanguageCodeMap().keySet();
            Function0<Unit> function3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePage.2
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
                    if (isSystemLocaleSettingsAvailable) {
                        context.startActivity(intent);
                    }
                }
            };
            Locale localeLanguagePage$lambda$1 = LanguagePage$lambda$1(selectedLocale$delegate);
            Intrinsics.checkNotNullExpressionValue(localeLanguagePage$lambda$1, "LanguagePage$lambda$1(...)");
            LanguagePageImpl(function2, setKeySet, isSystemLocaleSettingsAvailable, function3, localeLanguagePage$lambda$1, new Function1<Locale, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePage.3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Locale locale) {
                    invoke2(locale);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Locale it) {
                    PreferenceUtil.INSTANCE.saveLocalePreference(it);
                    LanguageSettingsKt.setLanguage(it);
                }
            }, $composer2, ($dirty2 & 14) | 229440, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            function2 = function1;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePage.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    LanguagesPageKt.LanguagePage(function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final Locale LanguagePage$lambda$1(MutableState<Locale> mutableState) {
        MutableState<Locale> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LanguagePageImpl(Function0<Unit> function0, final Set<Locale> set, boolean isSystemLocaleSettingsAvailable, final Function0<Unit> function1, final Locale selectedLocale, Function1<? super Locale, Unit> function2, Composer $composer, final int $changed, final int i) {
        final Function0<Unit> function3;
        boolean isSystemLocaleSettingsAvailable2;
        Function1<? super Locale, Unit> function4;
        Composer $composer2 = $composer.startRestartGroup(-1353834584);
        ComposerKt.sourceInformation($composer2, "C(LanguagePageImpl)P(3,1!1,4,5)107@4303L24,106@4261L102,110@4401L7,116@4562L428,129@5002L3268,112@4414L3857:LanguagesPage.kt#n7ajos");
        if ((i & 1) != 0) {
            function3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePageImpl.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            };
        } else {
            function3 = function0;
        }
        if ((i & 4) == 0) {
            isSystemLocaleSettingsAvailable2 = isSystemLocaleSettingsAvailable;
        } else {
            isSystemLocaleSettingsAvailable2 = false;
        }
        if ((i & 32) == 0) {
            function4 = function2;
        } else {
            function4 = new Function1<Locale, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePageImpl.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Locale locale) {
                    invoke2(locale);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Locale it) {
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1353834584, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.LanguagePageImpl (LanguagesPage.kt:105)");
        }
        final TopAppBarScrollBehavior scrollBehavior = TopAppBarDefaults.INSTANCE.exitUntilCollapsedScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, $composer2, 0, 7), new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt$LanguagePageImpl$scrollBehavior$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return true;
            }
        }, null, null, $composer2, (TopAppBarDefaults.$stable << 12) | 48, 12);
        ProvidableCompositionLocal<UriHandler> localUriHandler = CompositionLocalsKt.getLocalUriHandler();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer2.consume(localUriHandler);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        final UriHandler uriHandler = (UriHandler) objConsume;
        final boolean z = isSystemLocaleSettingsAvailable2;
        final Function1<? super Locale, Unit> function5 = function4;
        final Function0<Unit> function6 = function3;
        ScaffoldKt.m2530ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollBehavior.getNestedScrollConnection(), null, 2, null), ComposableLambdaKt.rememberComposableLambda(-1258901916, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePageImpl.3
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
                ComposerKt.sourceInformation($composer3, "C123@4818L115,117@4576L404:LanguagesPage.kt#n7ajos");
                if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1258901916, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.LanguagePageImpl.<anonymous> (LanguagesPage.kt:117)");
                    }
                    Function2<Composer, Integer, Unit> function2M7448getLambda1$app_debug = ComposableSingletons$LanguagesPageKt.INSTANCE.m7448getLambda1$app_debug();
                    final Function0<Unit> function7 = function3;
                    TopAppBarKt.LargeTopAppBar(function2M7448getLambda1$app_debug, null, ComposableLambdaKt.rememberComposableLambda(1322656777, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePageImpl.3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer4, int $changed3) {
                            Object value$iv;
                            ComposerKt.sourceInformation($composer4, "C124@4851L64,124@4840L75:LanguagesPage.kt#n7ajos");
                            if (($changed3 & 11) == 2 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1322656777, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.LanguagePageImpl.<anonymous>.<anonymous> (LanguagesPage.kt:124)");
                            }
                            $composer4.startReplaceGroup(1466608748);
                            ComposerKt.sourceInformation($composer4, "CC(remember):LanguagesPage.kt#9igjgp");
                            boolean invalid$iv = $composer4.changed(function7);
                            final Function0<Unit> function8 = function7;
                            Object it$iv = $composer4.rememberedValue();
                            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt$LanguagePageImpl$3$1$1$1
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
                                $composer4.updateRememberedValue(value$iv);
                            } else {
                                value$iv = it$iv;
                            }
                            $composer4.endReplaceGroup();
                            IconButtonsKt.BackButton((Function0) value$iv, $composer4, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer3, 54), null, scrollBehavior, $composer3, 390, 10);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer3.skipToGroupEnd();
            }
        }, $composer2, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1682856761, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePageImpl.4
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

            public final void invoke(PaddingValues it, Composer $composer3, int $changed2) {
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer3, "C130@5016L3244:LanguagesPage.kt#n7ajos");
                int $dirty = $changed2;
                if (($changed2 & 14) == 0) {
                    $dirty |= $composer3.changed(it) ? 4 : 2;
                }
                int $dirty2 = $dirty;
                if (($dirty2 & 91) != 18 || !$composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1682856761, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.LanguagePageImpl.<anonymous> (LanguagesPage.kt:130)");
                    }
                    Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, it);
                    final Set<Locale> set2 = set;
                    final boolean z2 = z;
                    final UriHandler uriHandler2 = uriHandler;
                    final Locale locale = selectedLocale;
                    final Function1<Locale, Unit> function7 = function5;
                    final Function0<Unit> function8 = function1;
                    LazyDslKt.LazyColumn(modifierPadding, null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePageImpl.4.1
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
                            final UriHandler uriHandler3 = uriHandler2;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1025805517, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePageImpl.4.1.1
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer4, int $changed3) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer4, "C136@5209L34,137@5283L39,135@5156L278:LanguagesPage.kt#n7ajos");
                                    if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1025805517, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.LanguagePageImpl.<anonymous>.<anonymous>.<anonymous> (LanguagesPage.kt:135)");
                                        }
                                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.translate, $composer4, 0);
                                        String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.translate_desc, $composer4, 0);
                                        ImageVector translate = TranslateKt.getTranslate(Icons.Outlined.INSTANCE);
                                        final UriHandler uriHandler4 = uriHandler3;
                                        PreferenceItemsKt.m7313PreferencesHintCardjB83MbM(strStringResource, strStringResource2, translate, 0L, 0L, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePageImpl.4.1.1.1
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
                                                uriHandler4.openUri(LinksKt.weblate);
                                            }
                                        }, $composer4, 0, 24);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer4.skipToGroupEnd();
                                }
                            }), 3, null);
                            final Set<Locale> set3 = set2;
                            final Locale locale2 = locale;
                            final Function1<Locale, Unit> function9 = function7;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1922764988, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePageImpl.4.1.2
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

                                public final void invoke(LazyItemScope item, Composer $composer4, int $changed3) {
                                    Object value$iv;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer4, "C145@5557L43,148@5789L28,144@5498L319:LanguagesPage.kt#n7ajos");
                                    if (($changed3 & 81) == 16 && $composer4.getSkipping()) {
                                        $composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1922764988, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.LanguagePageImpl.<anonymous>.<anonymous>.<anonymous> (LanguagesPage.kt:144)");
                                    }
                                    String strStringResource = StringResources_androidKt.stringResource(C3070R.string.follow_system, $composer4, 0);
                                    boolean z3 = !set3.contains(locale2);
                                    PaddingValues paddingValuesM862PaddingValuesYgX7TsA = PaddingKt.m862PaddingValuesYgX7TsA(C1979Dp.m6801constructorimpl(12), C1979Dp.m6801constructorimpl(18));
                                    $composer4.startReplaceGroup(1278362807);
                                    ComposerKt.sourceInformation($composer4, "CC(remember):LanguagesPage.kt#9igjgp");
                                    boolean invalid$iv = $composer4.changed(function9);
                                    final Function1<Locale, Unit> function10 = function9;
                                    Object it$iv = $composer4.rememberedValue();
                                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt$LanguagePageImpl$4$1$2$1$1
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
                                                function10.invoke(null);
                                            }
                                        };
                                        $composer4.updateRememberedValue(value$iv);
                                    } else {
                                        value$iv = it$iv;
                                    }
                                    $composer4.endReplaceGroup();
                                    PreferenceItemsKt.PreferenceSingleChoiceItem(null, strStringResource, z3, paddingValuesM862PaddingValuesYgX7TsA, (Function0) value$iv, $composer4, 3072, 1);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), 3, null);
                            for (final Locale locale3 : set2) {
                                final Locale locale4 = locale;
                                final Function1<Locale, Unit> function10 = function7;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-2139363857, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePageImpl.4.1.3
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

                                    public final void invoke(LazyItemScope item, Composer $composer4, int $changed3) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer4, "C154@6002L15,153@5932L305:LanguagesPage.kt#n7ajos");
                                        if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2139363857, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.LanguagePageImpl.<anonymous>.<anonymous>.<anonymous> (LanguagesPage.kt:153)");
                                            }
                                            String displayName = LanguageSettingsKt.toDisplayName(locale3, $composer4, 8);
                                            boolean zAreEqual = Intrinsics.areEqual(locale4, locale3);
                                            PaddingValues paddingValuesM862PaddingValuesYgX7TsA = PaddingKt.m862PaddingValuesYgX7TsA(C1979Dp.m6801constructorimpl(12), C1979Dp.m6801constructorimpl(18));
                                            final Function1<Locale, Unit> function11 = function10;
                                            final Locale locale5 = locale3;
                                            PreferenceItemsKt.PreferenceSingleChoiceItem(null, displayName, zAreEqual, paddingValuesM862PaddingValuesYgX7TsA, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePageImpl.4.1.3.1
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
                                                    function11.invoke(locale5);
                                                }
                                            }, $composer4, 3072, 1);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 3, null);
                            }
                            if (z2) {
                                final Function0<Unit> function11 = function8;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-856802200, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePageImpl.4.1.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer4, int $changed3) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer4, "C164@6386L19,165@6430L1776:LanguagesPage.kt#n7ajos");
                                        if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-856802200, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.LanguagePageImpl.<anonymous>.<anonymous>.<anonymous> (LanguagesPage.kt:164)");
                                            }
                                            DividerKt.m7300HorizontalDivideriJQMabo(null, 0L, $composer4, 0, 3);
                                            SurfaceKt.m2666SurfaceT9BRK9s(ClickableKt.m487clickableXHw0xAI$default(Modifier.INSTANCE, false, null, null, function11, 7, null), null, 0L, 0L, 0.0f, 0.0f, null, ComposableSingletons$LanguagesPageKt.INSTANCE.m7449getLambda2$app_debug(), $composer4, 12582912, WebSocketProtocol.PAYLOAD_SHORT);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 3, null);
                            }
                        }
                    }, $composer3, 0, 254);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer3.skipToGroupEnd();
            }
        }, $composer2, 54), $composer2, 805306416, 508);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z2 = isSystemLocaleSettingsAvailable2;
            final Function1<? super Locale, Unit> function7 = function4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePageImpl.5
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

                public final void invoke(Composer composer, int i2) {
                    LanguagesPageKt.LanguagePageImpl(function6, set, z2, function1, selectedLocale, function7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LanguagePagePreview(Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(79543779);
        ComposerKt.sourceInformation($composer2, "C(LanguagePagePreview)207@8352L56,211@8472L261,211@8462L271:LanguagesPage.kt#n7ajos");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(79543779, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.LanguagePagePreview (LanguagesPage.kt:206)");
            }
            $composer2.startReplaceGroup(377815201);
            ComposerKt.sourceInformation($composer2, "CC(remember):LanguagesPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Locale.JAPANESE, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState language$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            final Set map = SetsKt.setOf(Locale.forLanguageTag("zh"));
            ThemeKt.LoopTheme(false, false, false, ComposableLambdaKt.rememberComposableLambda(1511408218, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePagePreview.1
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
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer3, "C217@8690L37,212@8482L245:LanguagesPage.kt#n7ajos");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1511408218, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.LanguagePagePreview.<anonymous> (LanguagesPage.kt:212)");
                    }
                    Set<Locale> set = map;
                    AnonymousClass1 anonymousClass1 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePagePreview.1.1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }
                    };
                    Locale localeLanguagePagePreview$lambda$4 = LanguagesPageKt.LanguagePagePreview$lambda$4(language$delegate);
                    Intrinsics.checkNotNullExpressionValue(localeLanguagePagePreview$lambda$4, "access$LanguagePagePreview$lambda$4(...)");
                    $composer3.startReplaceGroup(-1112601964);
                    ComposerKt.sourceInformation($composer3, "CC(remember):LanguagesPage.kt#9igjgp");
                    final MutableState<Locale> mutableState = language$delegate;
                    Object it$iv2 = $composer3.rememberedValue();
                    if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function1<Locale, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt$LanguagePagePreview$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Locale locale) {
                                invoke2(locale);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Locale it) {
                                mutableState.setValue(it);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    $composer3.endReplaceGroup();
                    LanguagesPageKt.LanguagePageImpl(null, set, true, anonymousClass1, localeLanguagePagePreview$lambda$4, (Function1) value$iv2, $composer3, 232896, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.LanguagesPageKt.LanguagePagePreview.2
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
                    LanguagesPageKt.LanguagePagePreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale LanguagePagePreview$lambda$4(MutableState<Locale> mutableState) {
        MutableState<Locale> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }
}
