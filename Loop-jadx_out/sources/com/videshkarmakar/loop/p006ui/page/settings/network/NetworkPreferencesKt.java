package com.videshkarmakar.loop.p006ui.page.settings.network;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.BoltKt;
import androidx.compose.material.icons.outlined.CookieKt;
import androidx.compose.material.icons.outlined.OfflineBoltKt;
import androidx.compose.material.icons.outlined.SettingsEthernetKt;
import androidx.compose.material.icons.outlined.SpeedKt;
import androidx.compose.material.icons.outlined.VpnKeyKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.vector.ImageVector;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.component.IconButtonsKt;
import com.videshkarmakar.loop.p006ui.component.PreferenceItemsKt;
import com.videshkarmakar.loop.p006ui.component.TopAppBarKt;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: NetworkPreferences.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m194d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u001a+\u0010\u0000\u001a\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006²\u0006\n\u0010\u0007\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\t\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\n\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\u000b\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\f\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\r\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\u000e\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\u000f\u001a\u00020\bX\u008a\u0084\u0002²\u0006\n\u0010\u0010\u001a\u00020\bX\u008a\u008e\u0002"}, m195d2 = {"NetworkPreferences", "", "navigateToCookieProfilePage", "Lkotlin/Function0;", "onNavigateBack", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_debug", "showConcurrentDownloadDialog", "", "showRateLimitDialog", "showProxyDialog", PreferenceUtilKt.ARIA2C, PreferenceUtilKt.PROXY, "isCookiesEnabled", "forceIpv4", "isCustomCommandEnabled", "isRateLimitEnabled"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NetworkPreferencesKt {
    public static final void NetworkPreferences(Function0<Unit> function0, final Function0<Unit> onNavigateBack, Composer $composer, final int $changed, final int i) {
        final Function0<Unit> function1;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Composer $composer2;
        String str;
        Object value$iv5;
        Object value$iv6;
        Object value$iv7;
        Intrinsics.checkNotNullParameter(onNavigateBack, "onNavigateBack");
        Composer $composer3 = $composer.startRestartGroup(1448705806);
        ComposerKt.sourceInformation($composer3, "C(NetworkPreferences)54@2635L24,53@2593L102,58@2737L34,59@2803L34,60@2865L34,61@2918L45,62@2987L12,63@3036L12,64@3081L12,70@3247L427,83@3686L5071,66@3099L5659,209@9074L47,209@9049L72:NetworkPreferences.kt#sffru");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            function1 = function0;
        } else if (($changed & 14) == 0) {
            function1 = function0;
            $dirty |= $composer3.changedInstance(function1) ? 4 : 2;
        } else {
            function1 = function0;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(onNavigateBack) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            Function0<Unit> function2 = i2 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt.NetworkPreferences.1
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
                ComposerKt.traceEventStart(1448705806, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferences (NetworkPreferences.kt:52)");
            }
            final TopAppBarScrollBehavior scrollBehavior = TopAppBarDefaults.INSTANCE.exitUntilCollapsedScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, $composer3, 0, 7), new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$scrollBehavior$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return true;
                }
            }, null, null, $composer3, (TopAppBarDefaults.$stable << 12) | 48, 12);
            $composer3.startReplaceGroup(-1158387617);
            ComposerKt.sourceInformation($composer3, "CC(remember):NetworkPreferences.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState showConcurrentDownloadDialog$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-1158387551);
            ComposerKt.sourceInformation($composer3, "CC(remember):NetworkPreferences.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableState showRateLimitDialog$delegate = (MutableState) value$iv2;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-1158387489);
            ComposerKt.sourceInformation($composer3, "CC(remember):NetworkPreferences.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final MutableState showProxyDialog$delegate = (MutableState) value$iv3;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-1158387436);
            ComposerKt.sourceInformation($composer3, "CC(remember):NetworkPreferences.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.ARIA2C)), null, 2, null);
                $composer3.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            MutableState aria2c$delegate = (MutableState) value$iv4;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer3, "CC12@469L46:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.PROXY, false, 1, null)), null, 2, null);
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            MutableState proxy$delegate = (MutableState) value$iv$iv;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer3, "CC12@469L46:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv2 = $composer3.rememberedValue();
            if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.COOKIES, false, 1, null)), null, 2, null);
                $composer3.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer3, "CC12@469L46:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv3 = $composer3.rememberedValue();
            if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.FORCE_IPV4, false, 1, null)), null, 2, null);
                $composer3.updateRememberedValue(value$iv$iv3);
            } else {
                value$iv$iv3 = it$iv$iv3;
            }
            MutableState forceIpv4$delegate = (MutableState) value$iv$iv3;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            ScaffoldKt.m2530ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollBehavior.getNestedScrollConnection(), null, 2, null), ComposableLambdaKt.rememberComposableLambda(1926902994, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt.NetworkPreferences.2
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
                    ComposerKt.sourceInformation($composer4, "C77@3502L115,71@3261L403:NetworkPreferences.kt#sffru");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1926902994, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferences.<anonymous> (NetworkPreferences.kt:71)");
                        }
                        Function2<Composer, Integer, Unit> function2M7591getLambda1$app_debug = ComposableSingletons$NetworkPreferencesKt.INSTANCE.m7591getLambda1$app_debug();
                        final Function0<Unit> function3 = onNavigateBack;
                        TopAppBarKt.LargeTopAppBar(function2M7591getLambda1$app_debug, null, ComposableLambdaKt.rememberComposableLambda(196130701, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt.NetworkPreferences.2.1
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
                                Object value$iv8;
                                ComposerKt.sourceInformation($composer5, "C78@3535L64,78@3524L75:NetworkPreferences.kt#sffru");
                                if (($changed3 & 11) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(196130701, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferences.<anonymous>.<anonymous> (NetworkPreferences.kt:78)");
                                }
                                $composer5.startReplaceGroup(2137151);
                                ComposerKt.sourceInformation($composer5, "CC(remember):NetworkPreferences.kt#9igjgp");
                                boolean invalid$iv = $composer5.changed(function3);
                                final Function0<Unit> function4 = function3;
                                Object it$iv5 = $composer5.rememberedValue();
                                if (invalid$iv || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                    value$iv8 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$2$1$1$1
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
                                            function4.invoke();
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv8);
                                } else {
                                    value$iv8 = it$iv5;
                                }
                                $composer5.endReplaceGroup();
                                IconButtonsKt.BackButton((Function0) value$iv8, $composer5, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), null, scrollBehavior, $composer4, 390, 10);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1033128541, true, new C39483(proxy$delegate, forceIpv4$delegate, function2, showRateLimitDialog$delegate, aria2c$delegate, showProxyDialog$delegate, showConcurrentDownloadDialog$delegate), $composer3, 54), $composer3, 805306416, 508);
            $composer2 = $composer3;
            $composer2.startReplaceGroup(-1158381590);
            ComposerKt.sourceInformation($composer2, "198@8833L60,198@8808L85");
            if (NetworkPreferences$lambda$1(showConcurrentDownloadDialog$delegate)) {
                $composer2.startReplaceGroup(-1158381521);
                str = "CC(remember):NetworkPreferences.kt#9igjgp";
                ComposerKt.sourceInformation($composer2, str);
                Object it$iv5 = $composer2.rememberedValue();
                if (it$iv5 == Composer.INSTANCE.getEmpty()) {
                    value$iv7 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$4$1
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
                            NetworkPreferencesKt.NetworkPreferences$lambda$2(showConcurrentDownloadDialog$delegate, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv7);
                } else {
                    value$iv7 = it$iv5;
                }
                $composer2.endReplaceGroup();
                NetworkSettingDialogsKt.ConcurrentDownloadDialog((Function0) value$iv7, $composer2, 6);
            } else {
                str = "CC(remember):NetworkPreferences.kt#9igjgp";
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(-1158381449);
            ComposerKt.sourceInformation($composer2, "204@8956L51,204@8940L67");
            if (NetworkPreferences$lambda$4(showRateLimitDialog$delegate)) {
                $composer2.startReplaceGroup(-1158381398);
                ComposerKt.sourceInformation($composer2, str);
                Object it$iv6 = $composer2.rememberedValue();
                if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                    value$iv6 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$5$1
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
                            NetworkPreferencesKt.NetworkPreferences$lambda$5(showRateLimitDialog$delegate, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv6);
                } else {
                    value$iv6 = it$iv6;
                }
                $composer2.endReplaceGroup();
                NetworkSettingDialogsKt.RateLimitDialog((Function0) value$iv6, $composer2, 6);
            }
            $composer2.endReplaceGroup();
            if (NetworkPreferences$lambda$7(showProxyDialog$delegate)) {
                $composer2.startReplaceGroup(-1158381280);
                ComposerKt.sourceInformation($composer2, str);
                Object it$iv7 = $composer2.rememberedValue();
                if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                    value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$6$1
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
                            NetworkPreferencesKt.NetworkPreferences$lambda$8(showProxyDialog$delegate, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv5);
                } else {
                    value$iv5 = it$iv7;
                }
                $composer2.endReplaceGroup();
                NetworkSettingDialogsKt.ProxyConfigurationDialog((Function0) value$iv5, $composer2, 6, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function1 = function2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt.NetworkPreferences.7
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
                    NetworkPreferencesKt.NetworkPreferences(function1, onNavigateBack, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final boolean NetworkPreferences$lambda$1(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NetworkPreferences$lambda$2(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean NetworkPreferences$lambda$4(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NetworkPreferences$lambda$5(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean NetworkPreferences$lambda$7(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NetworkPreferences$lambda$8(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean NetworkPreferences$lambda$10(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NetworkPreferences$lambda$11(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean NetworkPreferences$lambda$12(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NetworkPreferences$lambda$13(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean NetworkPreferences$lambda$14(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean NetworkPreferences$lambda$16(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NetworkPreferences$lambda$17(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$3 */
    /* JADX INFO: compiled from: NetworkPreferences.kt */
    @Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, m195d2 = {"<anonymous>", "", "it", "Landroidx/compose/foundation/layout/PaddingValues;", "invoke", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class C39483 extends Lambda implements Function3<PaddingValues, Composer, Integer, Unit> {
        final /* synthetic */ MutableState<Boolean> $aria2c$delegate;
        final /* synthetic */ MutableState<Boolean> $forceIpv4$delegate;
        final /* synthetic */ Function0<Unit> $navigateToCookieProfilePage;
        final /* synthetic */ MutableState<Boolean> $proxy$delegate;
        final /* synthetic */ MutableState<Boolean> $showConcurrentDownloadDialog$delegate;
        final /* synthetic */ MutableState<Boolean> $showProxyDialog$delegate;
        final /* synthetic */ MutableState<Boolean> $showRateLimitDialog$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C39483(MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Function0<Unit> function0, MutableState<Boolean> mutableState3, MutableState<Boolean> mutableState4, MutableState<Boolean> mutableState5, MutableState<Boolean> mutableState6) {
            super(3);
            this.$proxy$delegate = mutableState;
            this.$forceIpv4$delegate = mutableState2;
            this.$navigateToCookieProfilePage = function0;
            this.$showRateLimitDialog$delegate = mutableState3;
            this.$aria2c$delegate = mutableState4;
            this.$showProxyDialog$delegate = mutableState5;
            this.$showConcurrentDownloadDialog$delegate = mutableState6;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
            invoke(paddingValues, composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invoke$lambda$0(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        public final void invoke(PaddingValues it, Composer $composer, int $changed) {
            Object value$iv$iv;
            Object value$iv;
            Intrinsics.checkNotNullParameter(it, "it");
            ComposerKt.sourceInformation($composer, "C84@3745L12,86@3804L4943,86@3771L4976:NetworkPreferences.kt#sffru");
            int $dirty = $changed;
            if (($changed & 14) == 0) {
                $dirty |= $composer.changed(it) ? 4 : 2;
            }
            int $dirty2 = $dirty;
            if (($dirty2 & 91) != 18 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1033128541, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferences.<anonymous> (NetworkPreferences.kt:84)");
                }
                $composer.startReplaceGroup(-2044908879);
                ComposerKt.sourceInformation($composer, "CC12@469L46:Ext.kt#x6o9ax");
                $composer.startReplaceGroup(-204592788);
                ComposerKt.sourceInformation($composer, "CC(remember):Ext.kt#9igjgp");
                Object it$iv$iv = $composer.rememberedValue();
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.CUSTOM_COMMAND, false, 1, null)), null, 2, null);
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                final MutableState isCustomCommandEnabled$delegate = (MutableState) value$iv$iv;
                $composer.endReplaceGroup();
                $composer.endReplaceGroup();
                Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, it);
                $composer.startReplaceGroup(1549162923);
                ComposerKt.sourceInformation($composer, "CC(remember):NetworkPreferences.kt#9igjgp");
                boolean invalid$iv = $composer.changed(isCustomCommandEnabled$delegate) | $composer.changed(this.$proxy$delegate) | $composer.changed(this.$forceIpv4$delegate) | $composer.changed(this.$navigateToCookieProfilePage);
                final MutableState<Boolean> mutableState = this.$showRateLimitDialog$delegate;
                final MutableState<Boolean> mutableState2 = this.$aria2c$delegate;
                final MutableState<Boolean> mutableState3 = this.$proxy$delegate;
                final MutableState<Boolean> mutableState4 = this.$showProxyDialog$delegate;
                final MutableState<Boolean> mutableState5 = this.$showConcurrentDownloadDialog$delegate;
                final MutableState<Boolean> mutableState6 = this.$forceIpv4$delegate;
                final Function0<Unit> function0 = this.$navigateToCookieProfilePage;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$3$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            if (NetworkPreferencesKt.C39483.invoke$lambda$0(isCustomCommandEnabled$delegate)) {
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$NetworkPreferencesKt.INSTANCE.m7592getLambda2$app_debug(), 3, null);
                            }
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$NetworkPreferencesKt.INSTANCE.m7593getLambda3$app_debug(), 3, null);
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-960514062, true, new C39491(isCustomCommandEnabled$delegate, mutableState)), 3, null);
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$NetworkPreferencesKt.INSTANCE.m7594getLambda4$app_debug(), 3, null);
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$NetworkPreferencesKt.INSTANCE.m7595getLambda5$app_debug(), 3, null);
                            final MutableState<Boolean> mutableState7 = mutableState2;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-210210225, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$3$1$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv2;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C141@6319L30,143@6441L89,147@6610L128,140@6269L491:NetworkPreferences.kt#sffru");
                                    if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-210210225, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NetworkPreferences.kt:140)");
                                        }
                                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.aria2, $composer2, 0);
                                        ImageVector bolt = BoltKt.getBolt(Icons.Outlined.INSTANCE);
                                        String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.aria2_desc, $composer2, 0);
                                        boolean zNetworkPreferences$lambda$10 = NetworkPreferencesKt.NetworkPreferences$lambda$10(mutableState7);
                                        $composer2.startReplaceGroup(-1135135996);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):NetworkPreferences.kt#9igjgp");
                                        final MutableState<Boolean> mutableState8 = mutableState7;
                                        Object it$iv2 = $composer2.rememberedValue();
                                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                            value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$3$1$1$2$1$1
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
                                                    NetworkPreferencesKt.NetworkPreferences$lambda$11(mutableState8, !NetworkPreferencesKt.NetworkPreferences$lambda$10(mutableState8));
                                                    PreferenceUtil.INSTANCE.updateValue(PreferenceUtilKt.ARIA2C, NetworkPreferencesKt.NetworkPreferences$lambda$10(mutableState8));
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv2);
                                        } else {
                                            value$iv2 = it$iv2;
                                        }
                                        $composer2.endReplaceGroup();
                                        PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, bolt, false, zNetworkPreferences$lambda$10, null, (Function0) value$iv2, $composer2, 1572864, 40);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            }), 3, null);
                            final MutableState<Boolean> mutableState8 = mutableState3;
                            final MutableState<Boolean> mutableState9 = isCustomCommandEnabled$delegate;
                            final MutableState<Boolean> mutableState10 = mutableState4;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(39891054, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$3$1$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv2;
                                    Object value$iv3;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C155@6883L35,156@6958L40,163@7294L26,159@7133L125,154@6822L579:NetworkPreferences.kt#sffru");
                                    if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(39891054, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NetworkPreferences.kt:154)");
                                        }
                                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.proxy, $composer2, 0);
                                        String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.proxy_desc, $composer2, 0);
                                        ImageVector vpnKey = VpnKeyKt.getVpnKey(Icons.Outlined.INSTANCE);
                                        boolean zNetworkPreferences$lambda$12 = NetworkPreferencesKt.NetworkPreferences$lambda$12(mutableState8);
                                        boolean z = !NetworkPreferencesKt.C39483.invoke$lambda$0(mutableState9);
                                        $composer2.startReplaceGroup(-1135135312);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):NetworkPreferences.kt#9igjgp");
                                        final MutableState<Boolean> mutableState11 = mutableState10;
                                        Object it$iv2 = $composer2.rememberedValue();
                                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                            value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$3$1$1$3$1$1
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
                                                    NetworkPreferencesKt.NetworkPreferences$lambda$8(mutableState11, true);
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv2);
                                        } else {
                                            value$iv2 = it$iv2;
                                        }
                                        Function0 function1 = (Function0) value$iv2;
                                        $composer2.endReplaceGroup();
                                        $composer2.startReplaceGroup(-1135135473);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):NetworkPreferences.kt#9igjgp");
                                        boolean invalid$iv2 = $composer2.changed(mutableState8);
                                        final MutableState<Boolean> mutableState12 = mutableState8;
                                        Object it$iv3 = $composer2.rememberedValue();
                                        if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                            value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$3$1$1$3$2$1
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
                                                    NetworkPreferencesKt.NetworkPreferences$lambda$13(mutableState12, !NetworkPreferencesKt.NetworkPreferences$lambda$12(mutableState12));
                                                    PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.PROXY, NetworkPreferencesKt.NetworkPreferences$lambda$12(mutableState12));
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv3);
                                        } else {
                                            value$iv3 = it$iv3;
                                        }
                                        $composer2.endReplaceGroup();
                                        PreferenceItemsKt.PreferenceSwitchWithDivider(strStringResource, strStringResource2, vpnKey, z, false, zNetworkPreferences$lambda$12, null, function1, (Function0) value$iv3, $composer2, 12582912, 80);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            }), 3, null);
                            final MutableState<Boolean> mutableState11 = mutableState2;
                            final MutableState<Boolean> mutableState12 = isCustomCommandEnabled$delegate;
                            final MutableState<Boolean> mutableState13 = mutableState5;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(289992333, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$3$1$1.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv2;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C169@7511L49,170@7600L49,173@7802L39,168@7463L378:NetworkPreferences.kt#sffru");
                                    if (($changed2 & 81) == 16 && $composer2.getSkipping()) {
                                        $composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(289992333, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NetworkPreferences.kt:168)");
                                    }
                                    String strStringResource = StringResources_androidKt.stringResource(C3070R.string.concurrent_download, $composer2, 0);
                                    String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.concurrent_download_desc, $composer2, 0);
                                    ImageVector offlineBolt = OfflineBoltKt.getOfflineBolt(Icons.Outlined.INSTANCE);
                                    boolean z = (NetworkPreferencesKt.NetworkPreferences$lambda$10(mutableState11) || NetworkPreferencesKt.C39483.invoke$lambda$0(mutableState12)) ? false : true;
                                    $composer2.startReplaceGroup(-1135134804);
                                    ComposerKt.sourceInformation($composer2, "CC(remember):NetworkPreferences.kt#9igjgp");
                                    final MutableState<Boolean> mutableState14 = mutableState13;
                                    Object it$iv2 = $composer2.rememberedValue();
                                    if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                        value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$3$1$1$4$1$1
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
                                                NetworkPreferencesKt.NetworkPreferences$lambda$2(mutableState14, true);
                                            }
                                        };
                                        $composer2.updateRememberedValue(value$iv2);
                                    } else {
                                        value$iv2 = it$iv2;
                                    }
                                    $composer2.endReplaceGroup();
                                    PreferenceItemsKt.PreferenceItem(strStringResource, strStringResource2, offlineBolt, z, null, null, null, null, null, (Function0) value$iv2, $composer2, 805306368, 496);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), 3, null);
                            final MutableState<Boolean> mutableState14 = mutableState6;
                            final MutableState<Boolean> mutableState15 = isCustomCommandEnabled$delegate;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(540093612, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$3$1$1.5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv2;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C177@7953L35,178@8028L45,182@8266L130,176@7903L493:NetworkPreferences.kt#sffru");
                                    if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(540093612, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NetworkPreferences.kt:176)");
                                        }
                                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.force_ipv4, $composer2, 0);
                                        String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.force_ipv4_desc, $composer2, 0);
                                        ImageVector settingsEthernet = SettingsEthernetKt.getSettingsEthernet(Icons.Outlined.INSTANCE);
                                        boolean z = !NetworkPreferencesKt.C39483.invoke$lambda$0(mutableState15);
                                        boolean zNetworkPreferences$lambda$16 = NetworkPreferencesKt.NetworkPreferences$lambda$16(mutableState14);
                                        $composer2.startReplaceGroup(-1135134340);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):NetworkPreferences.kt#9igjgp");
                                        boolean invalid$iv2 = $composer2.changed(mutableState14);
                                        final MutableState<Boolean> mutableState16 = mutableState14;
                                        Object it$iv2 = $composer2.rememberedValue();
                                        if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                            value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$3$1$1$5$1$1
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
                                                    NetworkPreferencesKt.NetworkPreferences$lambda$17(mutableState16, !NetworkPreferencesKt.NetworkPreferences$lambda$16(mutableState16));
                                                    PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.FORCE_IPV4, NetworkPreferencesKt.NetworkPreferences$lambda$16(mutableState16));
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv2);
                                        } else {
                                            value$iv2 = it$iv2;
                                        }
                                        $composer2.endReplaceGroup();
                                        PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, settingsEthernet, z, zNetworkPreferences$lambda$16, null, (Function0) value$iv2, $composer2, 0, 32);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            }), 3, null);
                            final Function0<Unit> function1 = function0;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(790194891, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$3$1$1.6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv2;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C188@8481L32,189@8553L37,191@8680L33,188@8458L256:NetworkPreferences.kt#sffru");
                                    if (($changed2 & 81) == 16 && $composer2.getSkipping()) {
                                        $composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(790194891, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NetworkPreferences.kt:188)");
                                    }
                                    String strStringResource = StringResources_androidKt.stringResource(C3070R.string.cookies, $composer2, 0);
                                    String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.cookies_desc, $composer2, 0);
                                    ImageVector cookie = CookieKt.getCookie(Icons.Outlined.INSTANCE);
                                    $composer2.startReplaceGroup(-1135133926);
                                    ComposerKt.sourceInformation($composer2, "CC(remember):NetworkPreferences.kt#9igjgp");
                                    boolean invalid$iv2 = $composer2.changed(function1);
                                    final Function0<Unit> function2 = function1;
                                    Object it$iv2 = $composer2.rememberedValue();
                                    if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                        value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$3$1$1$6$1$1
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
                                        $composer2.updateRememberedValue(value$iv2);
                                    } else {
                                        value$iv2 = it$iv2;
                                    }
                                    $composer2.endReplaceGroup();
                                    PreferenceItemsKt.PreferenceItem(strStringResource, strStringResource2, cookie, false, null, null, null, null, null, (Function0) value$iv2, $composer2, 0, 504);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), 3, null);
                        }

                        /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$3$1$1$1 */
                        /* JADX INFO: compiled from: NetworkPreferences.kt */
                        @Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/LazyItemScope;", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;Landroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        static final class C39491 extends Lambda implements Function3<LazyItemScope, Composer, Integer, Unit> {
                            final /* synthetic */ MutableState<Boolean> $isCustomCommandEnabled$delegate;
                            final /* synthetic */ MutableState<Boolean> $showRateLimitDialog$delegate;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C39491(MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
                                super(3);
                                this.$isCustomCommandEnabled$delegate = mutableState;
                                this.$showRateLimitDialog$delegate = mutableState2;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                invoke(lazyItemScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final boolean invoke$lambda$1(MutableState<Boolean> mutableState) {
                                MutableState<Boolean> $this$getValue$iv = mutableState;
                                return $this$getValue$iv.getValue().booleanValue();
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final void invoke$lambda$2(MutableState<Boolean> mutableState, boolean value) {
                                mutableState.setValue(Boolean.valueOf(value));
                            }

                            public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
                                Object value$iv;
                                Object value$iv2;
                                Object value$iv3;
                                Intrinsics.checkNotNullParameter(item, "$this$item");
                                ComposerKt.sourceInformation($composer, "C95@4203L93,100@4379L35,101@4454L40,112@4998L30,105@4700L262,99@4318L732:NetworkPreferences.kt#sffru");
                                if (($changed & 81) != 16 || !$composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-960514062, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NetworkPreferences.kt:95)");
                                    }
                                    $composer.startReplaceGroup(-1135138403);
                                    ComposerKt.sourceInformation($composer, "CC(remember):NetworkPreferences.kt#9igjgp");
                                    Object it$iv = $composer.rememberedValue();
                                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                                        value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.RATE_LIMIT)), null, 2, null);
                                        $composer.updateRememberedValue(value$iv);
                                    } else {
                                        value$iv = it$iv;
                                    }
                                    final MutableState isRateLimitEnabled$delegate = (MutableState) value$iv;
                                    $composer.endReplaceGroup();
                                    String strStringResource = StringResources_androidKt.stringResource(C3070R.string.rate_limit, $composer, 0);
                                    String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.rate_limit_desc, $composer, 0);
                                    ImageVector speed = SpeedKt.getSpeed(Icons.Outlined.INSTANCE);
                                    boolean z = !NetworkPreferencesKt.C39483.invoke$lambda$0(this.$isCustomCommandEnabled$delegate);
                                    boolean zInvoke$lambda$1 = invoke$lambda$1(isRateLimitEnabled$delegate);
                                    $composer.startReplaceGroup(-1135137608);
                                    ComposerKt.sourceInformation($composer, "CC(remember):NetworkPreferences.kt#9igjgp");
                                    final MutableState<Boolean> mutableState = this.$showRateLimitDialog$delegate;
                                    Object it$iv2 = $composer.rememberedValue();
                                    if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                        value$iv2 = (Function0) 
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00b9: CHECK_CAST (r0v14 'value$iv2' java.lang.Object) = (kotlin.jvm.functions.Function0) (wrap java.lang.Object:0x00b6: CONSTRUCTOR (r8v1 'mutableState' androidx.compose.runtime.MutableState<java.lang.Boolean> A[DONT_INLINE]) A[MD:(androidx.compose.runtime.MutableState<java.lang.Boolean>):void (m), WRAPPED] call: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$3$1$1$1$1$1.<init>(androidx.compose.runtime.MutableState):void type: CONSTRUCTOR) in method: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$3$1$1.1.invoke(androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, int):void, file: classes9.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
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
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.videshkarmakar.loop.ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$3$1$1$1$1$1, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:345)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                            	... 29 more
                                            */
                                        /*
                                            Method dump skipped, instruction units count: 286
                                            To view this dump add '--comments-level debug' option
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.videshkarmakar.loop.p006ui.page.settings.network.NetworkPreferencesKt$NetworkPreferences$3$1$1.C39491.invoke(androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, int):void");
                                    }
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        $composer.endReplaceGroup();
                        LazyDslKt.LazyColumn(modifierPadding, null, null, false, null, null, null, false, (Function1) value$iv, $composer, 0, 254);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            }
        }
