package com.videshkarmakar.loop.ui.page.settings.general;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.EditKt;
import androidx.compose.material.icons.outlined.SettingsKt;
import androidx.compose.material.icons.outlined.SyncAltKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.ui.component.PreferenceItemsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GeneralDownloadPreferences.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$GeneralDownloadPreferencesKt {
    public static final ComposableSingletons$GeneralDownloadPreferencesKt INSTANCE = new ComposableSingletons$GeneralDownloadPreferencesKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f363lambda1 = ComposableLambdaKt.composableLambdaInstance(1720618325, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C185@8855L46,185@8843L59:GeneralDownloadPreferences.kt#wlpkv4");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1720618325, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt.lambda-1.<anonymous> (GeneralDownloadPreferences.kt:185)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.general_settings, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f371lambda2 = ComposableLambdaKt.composableLambdaInstance(-1450024296, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C206@9622L57,206@9600L80:GeneralDownloadPreferences.kt#wlpkv4");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1450024296, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt.lambda-2.<anonymous> (GeneralDownloadPreferences.kt:206)");
            }
            PreferenceItemsKt.PreferenceInfo(null, StringResources_androidKt.stringResource(R.string.custom_command_enabled_hint, $composer, 0), null, false, $composer, 0, 13);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f372lambda3 = ComposableLambdaKt.composableLambdaInstance(-223613485, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C248@12050L121,246@11912L293:GeneralDownloadPreferences.kt#wlpkv4");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-223613485, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt.lambda-3.<anonymous> (GeneralDownloadPreferences.kt:246)");
                }
                IconKt.m2044Iconww6aTOc(SettingsKt.getSettings(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.open_settings, $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f373lambda4 = ComposableLambdaKt.composableLambdaInstance(-219682725, false, ComposableSingletons$GeneralDownloadPreferencesKt$lambda4$1.INSTANCE);

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f374lambda5 = ComposableLambdaKt.composableLambdaInstance(1755465912, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C330@16201L37,330@16175L64:GeneralDownloadPreferences.kt#wlpkv4");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1755465912, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt.lambda-5.<anonymous> (GeneralDownloadPreferences.kt:330)");
            }
            PreferenceItemsKt.m7176PreferenceSubtitleww6aTOc(null, null, StringResources_androidKt.stringResource(R.string.privacy, $composer, 0), 0L, $composer, 0, 11);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-6, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f375lambda6 = ComposableLambdaKt.composableLambdaInstance(-564352747, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C367@17941L42,367@17915L69:GeneralDownloadPreferences.kt#wlpkv4");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-564352747, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt.lambda-6.<anonymous> (GeneralDownloadPreferences.kt:367)");
            }
            PreferenceItemsKt.m7176PreferenceSubtitleww6aTOc(null, null, StringResources_androidKt.stringResource(R.string.advanced_settings, $composer, 0), 0L, $composer, 0, 11);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-7, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f376lambda7 = ComposableLambdaKt.composableLambdaInstance(415539457, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C423@20619L51,423@20597L74:GeneralDownloadPreferences.kt#wlpkv4");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(415539457, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt.lambda-7.<anonymous> (GeneralDownloadPreferences.kt:423)");
            }
            PreferenceItemsKt.PreferenceInfo(null, StringResources_androidKt.stringResource(R.string.subtitle_sponsorblock, $composer, 0), null, false, $composer, 0, 13);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-8, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f377lambda8 = ComposableLambdaKt.composableLambdaInstance(-1060723001, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C453@21755L34:GeneralDownloadPreferences.kt#wlpkv4");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1060723001, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt.lambda-8.<anonymous> (GeneralDownloadPreferences.kt:453)");
            }
            IconKt.m2044Iconww6aTOc(SyncAltKt.getSyncAlt(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-9, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f378lambda9 = ComposableLambdaKt.composableLambdaInstance(-797025976, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C452@21693L36,452@21681L49:GeneralDownloadPreferences.kt#wlpkv4");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-797025976, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt.lambda-9.<anonymous> (GeneralDownloadPreferences.kt:452)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.update, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-10, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f364lambda10 = ComposableLambdaKt.composableLambdaInstance(-162459299, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt$lambda-10$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C458@21937L44,463@22260L11,464@22331L10,457@21896L482:GeneralDownloadPreferences.kt#wlpkv4");
            if (($changed & 81) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-162459299, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt.lambda-10.<anonymous> (GeneralDownloadPreferences.kt:457)");
                }
                TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.update_channel, $composer, 0), PaddingKt.m624paddingqDBjuR0$default(PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6553constructorimpl(24), 0.0f, 2, null), 0.0f, Dp.m6553constructorimpl(16), 0.0f, Dp.m6553constructorimpl(8), 5, null), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelLarge(), $composer, 48, 0, 65528);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-11, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f365lambda11 = ComposableLambdaKt.composableLambdaInstance(2040963670, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt$lambda-11$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C488@23357L49,493@23686L11,494@23757L10,487@23316L488:GeneralDownloadPreferences.kt#wlpkv4");
            if (($changed & 81) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2040963670, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt.lambda-11.<anonymous> (GeneralDownloadPreferences.kt:487)");
                }
                TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.additional_settings, $composer, 0), PaddingKt.m624paddingqDBjuR0$default(PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6553constructorimpl(24), 0.0f, 2, null), 0.0f, Dp.m6553constructorimpl(16), 0.0f, Dp.m6553constructorimpl(16), 5, null), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelLarge(), $composer, 48, 0, 65528);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-12, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f366lambda12 = ComposableLambdaKt.composableLambdaInstance(-1004093881, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt$lambda-12$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C508@24502L41,508@24490L54:GeneralDownloadPreferences.kt#wlpkv4");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1004093881, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt.lambda-12.<anonymous> (GeneralDownloadPreferences.kt:508)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.auto_update, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-13, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f367lambda13 = ComposableLambdaKt.composableLambdaInstance(-1598468518, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt$lambda-13$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C523@25428L38,523@25423L44:GeneralDownloadPreferences.kt#wlpkv4");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1598468518, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt.lambda-13.<anonymous> (GeneralDownloadPreferences.kt:523)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.disabled, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-14, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f368lambda14 = ComposableLambdaKt.composableLambdaInstance(-714132759, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt$lambda-14$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C675@30039L112:GeneralDownloadPreferences.kt#wlpkv4");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-714132759, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt.lambda-14.<anonymous> (GeneralDownloadPreferences.kt:675)");
                }
                IconKt.m2044Iconww6aTOc(EditKt.getEdit(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-15, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f369lambda15 = ComposableLambdaKt.composableLambdaInstance(-464854358, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt$lambda-15$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C680@30193L39,680@30181L52:GeneralDownloadPreferences.kt#wlpkv4");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-464854358, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt.lambda-15.<anonymous> (GeneralDownloadPreferences.kt:680)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.edit_file, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-16, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f370lambda16 = ComposableLambdaKt.composableLambdaInstance(-826616581, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt$lambda-16$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C689@30548L26:GeneralDownloadPreferences.kt#wlpkv4");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-826616581, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt.lambda-16.<anonymous> (GeneralDownloadPreferences.kt:689)");
            }
            TextKt.m2569Text4IGK_g("archive.txt", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7415getLambda1$app_debug() {
        return f363lambda1;
    }

    /* JADX INFO: renamed from: getLambda-10$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7416getLambda10$app_debug() {
        return f364lambda10;
    }

    /* JADX INFO: renamed from: getLambda-11$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7417getLambda11$app_debug() {
        return f365lambda11;
    }

    /* JADX INFO: renamed from: getLambda-12$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7418getLambda12$app_debug() {
        return f366lambda12;
    }

    /* JADX INFO: renamed from: getLambda-13$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7419getLambda13$app_debug() {
        return f367lambda13;
    }

    /* JADX INFO: renamed from: getLambda-14$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7420getLambda14$app_debug() {
        return f368lambda14;
    }

    /* JADX INFO: renamed from: getLambda-15$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7421getLambda15$app_debug() {
        return f369lambda15;
    }

    /* JADX INFO: renamed from: getLambda-16$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7422getLambda16$app_debug() {
        return f370lambda16;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7423getLambda2$app_debug() {
        return f371lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7424getLambda3$app_debug() {
        return f372lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7425getLambda4$app_debug() {
        return f373lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7426getLambda5$app_debug() {
        return f374lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7427getLambda6$app_debug() {
        return f375lambda6;
    }

    /* JADX INFO: renamed from: getLambda-7$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7428getLambda7$app_debug() {
        return f376lambda7;
    }

    /* JADX INFO: renamed from: getLambda-8$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7429getLambda8$app_debug() {
        return f377lambda8;
    }

    /* JADX INFO: renamed from: getLambda-9$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7430getLambda9$app_debug() {
        return f378lambda9;
    }
}
