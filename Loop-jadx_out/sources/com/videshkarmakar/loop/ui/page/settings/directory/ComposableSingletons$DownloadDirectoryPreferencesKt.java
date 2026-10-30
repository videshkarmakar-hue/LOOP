package com.videshkarmakar.loop.ui.page.settings.directory;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.FolderDeleteKt;
import androidx.compose.material.icons.outlined.FolderKt;
import androidx.compose.material.icons.outlined.FolderSpecialKt;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.ui.component.PreferenceItemsKt;
import com.videshkarmakar.loop.util.FileUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DownloadDirectoryPreferences.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$DownloadDirectoryPreferencesKt {
    public static final ComposableSingletons$DownloadDirectoryPreferencesKt INSTANCE = new ComposableSingletons$DownloadDirectoryPreferencesKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f283lambda1 = ComposableLambdaKt.composableLambdaInstance(1060333926, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C244@10648L48,242@10566L153:DownloadDirectoryPreferences.kt#rl3ivv");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1060333926, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt.lambda-1.<anonymous> (DownloadDirectoryPreferences.kt:242)");
                }
                TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.download_directory, $composer, 0), (Modifier) Modifier.INSTANCE, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 48, 0, 131068);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f291lambda2 = ComposableLambdaKt.composableLambdaInstance(-995993559, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C257@11092L57,257@11070L80:DownloadDirectoryPreferences.kt#rl3ivv");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-995993559, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt.lambda-2.<anonymous> (DownloadDirectoryPreferences.kt:257)");
            }
            PreferenceItemsKt.PreferenceInfo(null, StringResources_androidKt.stringResource(R.string.custom_command_enabled_hint, $composer, 0), null, false, $composer, 0, 13);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f292lambda3 = ComposableLambdaKt.composableLambdaInstance(-1218951260, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C278@12172L41,278@12146L68:DownloadDirectoryPreferences.kt#rl3ivv");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1218951260, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt.lambda-3.<anonymous> (DownloadDirectoryPreferences.kt:278)");
            }
            PreferenceItemsKt.m7176PreferenceSubtitleww6aTOc(null, null, StringResources_androidKt.stringResource(R.string.general_settings, $composer, 0), 0L, $composer, 0, 11);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f293lambda4 = ComposableLambdaKt.composableLambdaInstance(1518421674, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C343@15146L32,343@15120L59:DownloadDirectoryPreferences.kt#rl3ivv");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1518421674, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt.lambda-4.<anonymous> (DownloadDirectoryPreferences.kt:343)");
            }
            PreferenceItemsKt.m7176PreferenceSubtitleww6aTOc(null, null, StringResources_androidKt.stringResource(R.string.privacy, $composer, 0), 0L, $composer, 0, 11);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f294lambda5 = ComposableLambdaKt.composableLambdaInstance(2066961896, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C361@15989L42,361@15963L69:DownloadDirectoryPreferences.kt#rl3ivv");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2066961896, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt.lambda-5.<anonymous> (DownloadDirectoryPreferences.kt:361)");
            }
            PreferenceItemsKt.m7176PreferenceSubtitleww6aTOc(null, null, StringResources_androidKt.stringResource(R.string.advanced_settings, $composer, 0), 0L, $composer, 0, 11);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-6, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f295lambda6 = ComposableLambdaKt.composableLambdaInstance(-1679465178, false, ComposableSingletons$DownloadDirectoryPreferencesKt$lambda6$1.INSTANCE);

    /* JADX INFO: renamed from: lambda-7, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f296lambda7 = ComposableLambdaKt.composableLambdaInstance(1794021977, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C400@17597L39:DownloadDirectoryPreferences.kt#rl3ivv");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1794021977, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt.lambda-7.<anonymous> (DownloadDirectoryPreferences.kt:400)");
            }
            IconKt.m2044Iconww6aTOc(FolderDeleteKt.getFolderDelete(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-8, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f297lambda8 = ComposableLambdaKt.composableLambdaInstance(1449106232, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C401@17667L46,401@17662L52:DownloadDirectoryPreferences.kt#rl3ivv");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1449106232, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt.lambda-8.<anonymous> (DownloadDirectoryPreferences.kt:401)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.clear_temp_files, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-9, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f298lambda9 = ComposableLambdaKt.composableLambdaInstance(1104190487, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C407@17888L151,411@18083L10,406@17862L259:DownloadDirectoryPreferences.kt#rl3ivv");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1104190487, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt.lambda-9.<anonymous> (DownloadDirectoryPreferences.kt:406)");
                }
                int i = R.string.clear_temp_files_info;
                String absolutePath = FileUtil.INSTANCE.getExternalTempDir().getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(i, new Object[]{absolutePath}, $composer, 64), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyLarge(), $composer, 0, 0, 65534);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-10, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f284lambda10 = ComposableLambdaKt.composableLambdaInstance(1125501393, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt$lambda-10$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C455@19878L68:DownloadDirectoryPreferences.kt#rl3ivv");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1125501393, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt.lambda-10.<anonymous> (DownloadDirectoryPreferences.kt:455)");
            }
            IconKt.m2044Iconww6aTOc(FolderKt.getFolder(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-11, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f285lambda11 = ComposableLambdaKt.composableLambdaInstance(373952240, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt$lambda-11$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C458@20021L54,457@19988L155:DownloadDirectoryPreferences.kt#rl3ivv");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(373952240, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt.lambda-11.<anonymous> (DownloadDirectoryPreferences.kt:457)");
                }
                TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.custom_command_directory, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6403boximpl(TextAlign.INSTANCE.m6410getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 130558);
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
    public static Function2<Composer, Integer, Unit> f286lambda12 = ComposableLambdaKt.composableLambdaInstance(-1636529279, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt$lambda-12$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C483@21155L52:DownloadDirectoryPreferences.kt#rl3ivv");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1636529279, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt.lambda-12.<anonymous> (DownloadDirectoryPreferences.kt:483)");
            }
            TextKt.m2569Text4IGK_g("-P", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) FontFamily.INSTANCE.getMonospace(), 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131006);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-13, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f287lambda13 = ComposableLambdaKt.composableLambdaInstance(158664712, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt$lambda-13$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C566@24281L75:DownloadDirectoryPreferences.kt#rl3ivv");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(158664712, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt.lambda-13.<anonymous> (DownloadDirectoryPreferences.kt:566)");
            }
            IconKt.m2044Iconww6aTOc(FolderSpecialKt.getFolderSpecial(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-14, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f288lambda14 = ComposableLambdaKt.composableLambdaInstance(422361737, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt$lambda-14$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C565@24214L45,565@24202L58:DownloadDirectoryPreferences.kt#rl3ivv");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(422361737, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt.lambda-14.<anonymous> (DownloadDirectoryPreferences.kt:565)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.output_template, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-15, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f289lambda15 = ComposableLambdaKt.composableLambdaInstance(1237877172, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt$lambda-15$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C628@27370L36,628@27358L49:DownloadDirectoryPreferences.kt#rl3ivv");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1237877172, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt.lambda-15.<anonymous> (DownloadDirectoryPreferences.kt:628)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.custom, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-16, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f290lambda16 = ComposableLambdaKt.composableLambdaInstance(158108929, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt$lambda-16$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C623@27058L222:DownloadDirectoryPreferences.kt#rl3ivv");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(158108929, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.directory.ComposableSingletons$DownloadDirectoryPreferencesKt.lambda-16.<anonymous> (DownloadDirectoryPreferences.kt:623)");
                }
                TextKt.m2569Text4IGK_g("Required: %(title).200B, .%(ext)s", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) FontFamily.INSTANCE.getMonospace(), 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131006);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7335getLambda1$app_debug() {
        return f283lambda1;
    }

    /* JADX INFO: renamed from: getLambda-10$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7336getLambda10$app_debug() {
        return f284lambda10;
    }

    /* JADX INFO: renamed from: getLambda-11$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7337getLambda11$app_debug() {
        return f285lambda11;
    }

    /* JADX INFO: renamed from: getLambda-12$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7338getLambda12$app_debug() {
        return f286lambda12;
    }

    /* JADX INFO: renamed from: getLambda-13$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7339getLambda13$app_debug() {
        return f287lambda13;
    }

    /* JADX INFO: renamed from: getLambda-14$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7340getLambda14$app_debug() {
        return f288lambda14;
    }

    /* JADX INFO: renamed from: getLambda-15$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7341getLambda15$app_debug() {
        return f289lambda15;
    }

    /* JADX INFO: renamed from: getLambda-16$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7342getLambda16$app_debug() {
        return f290lambda16;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7343getLambda2$app_debug() {
        return f291lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7344getLambda3$app_debug() {
        return f292lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7345getLambda4$app_debug() {
        return f293lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7346getLambda5$app_debug() {
        return f294lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7347getLambda6$app_debug() {
        return f295lambda6;
    }

    /* JADX INFO: renamed from: getLambda-7$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7348getLambda7$app_debug() {
        return f296lambda7;
    }

    /* JADX INFO: renamed from: getLambda-8$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7349getLambda8$app_debug() {
        return f297lambda8;
    }

    /* JADX INFO: renamed from: getLambda-9$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7350getLambda9$app_debug() {
        return f298lambda9;
    }
}
