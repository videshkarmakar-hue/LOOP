package com.videshkarmakar.loop.p006ui.page.settings.appearance;

import android.os.Build;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ContrastKt;
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
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.common.CompositionLocalsKt;
import com.videshkarmakar.loop.p006ui.component.IconButtonsKt;
import com.videshkarmakar.loop.p006ui.component.PreferenceItemsKt;
import com.videshkarmakar.loop.p006ui.component.TopAppBarKt;
import com.videshkarmakar.loop.util.DarkThemePreference;
import com.videshkarmakar.loop.util.PreferenceUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: DarkThemePreferences.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m195d2 = {"DarkThemePreferences", "", "onNavigateBack", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_debug"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DarkThemePreferencesKt {
    public static final void DarkThemePreferences(final Function0<Unit> onNavigateBack, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onNavigateBack, "onNavigateBack");
        Composer $composer3 = $composer.startRestartGroup(1691026474);
        ComposerKt.sourceInformation($composer3, "C(DarkThemePreferences)35@1639L24,34@1597L102,38@1745L7,44@1987L430,57@2429L1668,40@1839L2259:DarkThemePreferences.kt#n7ajos");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onNavigateBack) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 11) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1691026474, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferences (DarkThemePreferences.kt:33)");
            }
            final TopAppBarScrollBehavior scrollBehavior = TopAppBarDefaults.INSTANCE.exitUntilCollapsedScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, $composer3, 0, 7), new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferencesKt$DarkThemePreferences$scrollBehavior$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return true;
                }
            }, null, null, $composer3, (TopAppBarDefaults.$stable << 12) | 48, 12);
            ProvidableCompositionLocal<DarkThemePreference> localDarkTheme = CompositionLocalsKt.getLocalDarkTheme();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localDarkTheme);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final DarkThemePreference darkThemePreference = (DarkThemePreference) objConsume;
            final boolean isHighContrastModeEnabled = darkThemePreference.isHighContrastModeEnabled();
            $composer2 = $composer3;
            ScaffoldKt.m2530ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollBehavior.getNestedScrollConnection(), null, 2, null), ComposableLambdaKt.rememberComposableLambda(1785185510, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferencesKt.DarkThemePreferences.1
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
                    ComposerKt.sourceInformation($composer4, "C51@2245L115,45@2001L406:DarkThemePreferences.kt#n7ajos");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1785185510, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferences.<anonymous> (DarkThemePreferences.kt:45)");
                        }
                        Function2<Composer, Integer, Unit> function2M7446getLambda1$app_debug = ComposableSingletons$DarkThemePreferencesKt.INSTANCE.m7446getLambda1$app_debug();
                        final Function0<Unit> function0 = onNavigateBack;
                        TopAppBarKt.LargeTopAppBar(function2M7446getLambda1$app_debug, null, ComposableLambdaKt.rememberComposableLambda(-1712868341, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferencesKt.DarkThemePreferences.1.1
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
                                Object value$iv;
                                ComposerKt.sourceInformation($composer5, "C52@2278L64,52@2267L75:DarkThemePreferences.kt#n7ajos");
                                if (($changed3 & 11) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1712868341, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferences.<anonymous>.<anonymous> (DarkThemePreferences.kt:52)");
                                }
                                $composer5.startReplaceGroup(-1200558879);
                                ComposerKt.sourceInformation($composer5, "CC(remember):DarkThemePreferences.kt#9igjgp");
                                boolean invalid$iv = $composer5.changed(function0);
                                final Function0<Unit> function1 = function0;
                                Object it$iv = $composer5.rememberedValue();
                                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferencesKt$DarkThemePreferences$1$1$1$1
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
                                            function1.invoke();
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv);
                                } else {
                                    value$iv = it$iv;
                                }
                                $composer5.endReplaceGroup();
                                IconButtonsKt.BackButton((Function0) value$iv, $composer5, 0);
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
            }, $composer3, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1143368901, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferencesKt.DarkThemePreferences.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
                    invoke(paddingValues, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues it, Composer $composer4, int $changed2) {
                    Object value$iv;
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer4, "C58@2487L1600,58@2443L1644:DarkThemePreferences.kt#n7ajos");
                    int $dirty3 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty3 |= $composer4.changed(it) ? 4 : 2;
                    }
                    int $dirty4 = $dirty3;
                    if (($dirty4 & 91) == 18 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1143368901, $dirty4, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferences.<anonymous> (DarkThemePreferences.kt:58)");
                    }
                    Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, it);
                    $composer4.startReplaceGroup(-2002099567);
                    ComposerKt.sourceInformation($composer4, "CC(remember):DarkThemePreferences.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(darkThemePreference) | $composer4.changed(isHighContrastModeEnabled);
                    final DarkThemePreference darkThemePreference2 = darkThemePreference;
                    final boolean z = isHighContrastModeEnabled;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferencesKt$DarkThemePreferences$2$1$1
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
                                if (Build.VERSION.SDK_INT >= 29) {
                                    final DarkThemePreference darkThemePreference3 = darkThemePreference2;
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1884176150, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferencesKt$DarkThemePreferences$2$1$1.1
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
                                            ComposerKt.sourceInformation($composer5, "C62@2652L38,61@2589L279:DarkThemePreferences.kt#n7ajos");
                                            if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1884176150, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DarkThemePreferences.kt:61)");
                                                }
                                                PreferenceItemsKt.PreferenceSingleChoiceItem(null, StringResources_androidKt.stringResource(C3070R.string.follow_system, $composer5, 0), darkThemePreference3.getDarkThemeValue() == 1, null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferencesKt.DarkThemePreferences.2.1.1.1.1
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                                        invoke2();
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2() {
                                                        PreferenceUtil.modifyDarkThemePreference$default(PreferenceUtil.INSTANCE, 1, false, 2, null);
                                                    }
                                                }, $composer5, CpioConstants.C_ISBLK, 9);
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
                                final DarkThemePreference darkThemePreference4 = darkThemePreference2;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-340251953, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferencesKt$DarkThemePreferences$2$1$1.2
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
                                        ComposerKt.sourceInformation($composer5, "C68@2993L27,67@2934L234:DarkThemePreferences.kt#n7ajos");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-340251953, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DarkThemePreferences.kt:67)");
                                            }
                                            PreferenceItemsKt.PreferenceSingleChoiceItem(null, StringResources_androidKt.stringResource(C3070R.string.f457on, $composer5, 0), darkThemePreference4.getDarkThemeValue() == 2, null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferencesKt.DarkThemePreferences.2.1.1.2.1
                                                @Override // kotlin.jvm.functions.Function0
                                                public /* bridge */ /* synthetic */ Unit invoke() {
                                                    invoke2();
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2() {
                                                    PreferenceUtil.modifyDarkThemePreference$default(PreferenceUtil.INSTANCE, 2, false, 2, null);
                                                }
                                            }, $composer5, CpioConstants.C_ISBLK, 9);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 3, null);
                                final DarkThemePreference darkThemePreference5 = darkThemePreference2;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1585845702, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferencesKt$DarkThemePreferences$2$1$1.3
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
                                        ComposerKt.sourceInformation($composer5, "C74@3289L28,73@3230L237:DarkThemePreferences.kt#n7ajos");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1585845702, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DarkThemePreferences.kt:73)");
                                            }
                                            PreferenceItemsKt.PreferenceSingleChoiceItem(null, StringResources_androidKt.stringResource(C3070R.string.off, $composer5, 0), darkThemePreference5.getDarkThemeValue() == 3, null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferencesKt.DarkThemePreferences.2.1.1.3.1
                                                @Override // kotlin.jvm.functions.Function0
                                                public /* bridge */ /* synthetic */ Unit invoke() {
                                                    invoke2();
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2() {
                                                    PreferenceUtil.modifyDarkThemePreference$default(PreferenceUtil.INSTANCE, 3, false, 2, null);
                                                }
                                            }, $composer5, CpioConstants.C_ISBLK, 9);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 3, null);
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$DarkThemePreferencesKt.INSTANCE.m7447getLambda2$app_debug(), 3, null);
                                final boolean z2 = z;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1938502216, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferencesKt$DarkThemePreferences$2$1$1.4
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
                                        Object value$iv2;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C83@3712L38,85@3881L152,82@3662L393:DarkThemePreferences.kt#n7ajos");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1938502216, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DarkThemePreferences.kt:82)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.high_contrast, $composer5, 0);
                                            ImageVector contrast = ContrastKt.getContrast(Icons.Outlined.INSTANCE);
                                            boolean z3 = z2;
                                            $composer5.startReplaceGroup(1416776934);
                                            ComposerKt.sourceInformation($composer5, "CC(remember):DarkThemePreferences.kt#9igjgp");
                                            boolean invalid$iv2 = $composer5.changed(z2);
                                            final boolean z4 = z2;
                                            Object it$iv2 = $composer5.rememberedValue();
                                            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                                value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferencesKt$DarkThemePreferences$2$1$1$4$1$1
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
                                                        PreferenceUtil.modifyDarkThemePreference$default(PreferenceUtil.INSTANCE, 0, !z4, 1, null);
                                                    }
                                                };
                                                $composer5.updateRememberedValue(value$iv2);
                                            } else {
                                                value$iv2 = it$iv2;
                                            }
                                            $composer5.endReplaceGroup();
                                            PreferenceItemsKt.PreferenceSwitch(strStringResource, null, contrast, false, z3, null, (Function0) value$iv2, $composer5, 0, 42);
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
                        };
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceGroup();
                    LazyDslKt.LazyColumn(modifierPadding, null, null, false, null, null, null, false, (Function1) value$iv, $composer4, 0, 254);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), $composer3, 805306416, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.DarkThemePreferencesKt.DarkThemePreferences.3
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
                    DarkThemePreferencesKt.DarkThemePreferences(onNavigateBack, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
