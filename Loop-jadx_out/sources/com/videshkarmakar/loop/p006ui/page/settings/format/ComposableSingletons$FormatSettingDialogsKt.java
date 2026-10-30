package com.videshkarmakar.loop.p006ui.page.settings.format;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.SortKt;
import androidx.compose.material.icons.outlined.AudioFileKt;
import androidx.compose.material.icons.outlined.HighQualityKt;
import androidx.compose.material.icons.outlined.LanguageKt;
import androidx.compose.material.icons.outlined.SyncKt;
import androidx.compose.material.icons.outlined.VideoFileKt;
import androidx.compose.material.icons.outlined.VideoSettingsKt;
import androidx.compose.material.icons.outlined._4kKt;
import androidx.compose.material3.AssistChipDefaults;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormatSettingDialogs.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$FormatSettingDialogsKt {
    public static final ComposableSingletons$FormatSettingDialogsKt INSTANCE = new ComposableSingletons$FormatSettingDialogsKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f913lambda1 = ComposableLambdaKt.composableLambdaInstance(-535817487, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C117@5726L43,117@5721L49:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-535817487, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-1.<anonymous> (FormatSettingDialogs.kt:117)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.audio_quality, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f924lambda2 = ComposableLambdaKt.composableLambdaInstance(-319777165, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C112@5439L38:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-319777165, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-2.<anonymous> (FormatSettingDialogs.kt:112)");
            }
            IconKt.m2292Iconww6aTOc(HighQualityKt.getHighQuality(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f935lambda3 = ComposableLambdaKt.composableLambdaInstance(1172238745, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C156@7396L53,156@7391L59:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1172238745, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-3.<anonymous> (FormatSettingDialogs.kt:156)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.audio_format_preference, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f946lambda4 = ComposableLambdaKt.composableLambdaInstance(486471127, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C151@7111L36:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(486471127, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-4.<anonymous> (FormatSettingDialogs.kt:151)");
            }
            IconKt.m2292Iconww6aTOc(AudioFileKt.getAudioFile(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f950lambda5 = ComposableLambdaKt.composableLambdaInstance(1107817650, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C178@8218L36:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1107817650, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-5.<anonymous> (FormatSettingDialogs.kt:178)");
            }
            IconKt.m2292Iconww6aTOc(AudioFileKt.getAudioFile(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-6, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f951lambda6 = ComposableLambdaKt.composableLambdaInstance(-826388749, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C181@8317L42,180@8288L85:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-826388749, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-6.<anonymous> (FormatSettingDialogs.kt:180)");
                }
                TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.audio_format, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-7, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f952lambda7 = ComposableLambdaKt.composableLambdaInstance(255104110, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C233@10140L46,233@10135L52:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(255104110, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-7.<anonymous> (FormatSettingDialogs.kt:233)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.video_resolution, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-8, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f953lambda8 = ComposableLambdaKt.composableLambdaInstance(-1843639892, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C228@9861L30:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1843639892, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-8.<anonymous> (FormatSettingDialogs.kt:228)");
            }
            IconKt.m2292Iconww6aTOc(_4kKt.get_4k(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-9, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f954lambda9 = ComposableLambdaKt.composableLambdaInstance(1061359609, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C272@11809L53,272@11804L59:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1061359609, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-9.<anonymous> (FormatSettingDialogs.kt:272)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.video_format_preference, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-10, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f914lambda10 = ComposableLambdaKt.composableLambdaInstance(375591991, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-10$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C267@11524L36:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(375591991, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-10.<anonymous> (FormatSettingDialogs.kt:267)");
            }
            IconKt.m2292Iconww6aTOc(VideoFileKt.getVideoFile(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-11, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f915lambda11 = ComposableLambdaKt.composableLambdaInstance(-1375296531, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-11$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C294@12672L36:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1375296531, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-11.<anonymous> (FormatSettingDialogs.kt:294)");
            }
            IconKt.m2292Iconww6aTOc(VideoFileKt.getVideoFile(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-12, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f916lambda12 = ComposableLambdaKt.composableLambdaInstance(985464366, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-12$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C297@12771L42,296@12742L85:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(985464366, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-12.<anonymous> (FormatSettingDialogs.kt:296)");
                }
                TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.video_format, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-13, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f917lambda13 = ComposableLambdaKt.composableLambdaInstance(2043635009, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-13$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C346@14302L32,346@14290L45:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2043635009, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-13.<anonymous> (FormatSettingDialogs.kt:346)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.confirm, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-14, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f918lambda14 = ComposableLambdaKt.composableLambdaInstance(-2058401086, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-14$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C334@13874L32,334@13869L38:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2058401086, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-14.<anonymous> (FormatSettingDialogs.kt:334)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.dismiss, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-15, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f919lambda15 = ComposableLambdaKt.composableLambdaInstance(-1813312186, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-15$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C337@13950L31:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1813312186, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-15.<anonymous> (FormatSettingDialogs.kt:337)");
            }
            IconKt.m2292Iconww6aTOc(SyncKt.getSync(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-16, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f920lambda16 = ComposableLambdaKt.composableLambdaInstance(-1620380985, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-16$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C339@14020L45,339@14015L51:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1620380985, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-16.<anonymous> (FormatSettingDialogs.kt:339)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.convert_audio_format, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-17, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f921lambda17 = ComposableLambdaKt.composableLambdaInstance(-1372549696, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-17$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C380@15581L31:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1372549696, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-17.<anonymous> (FormatSettingDialogs.kt:380)");
            }
            IconKt.m2292Iconww6aTOc(SyncKt.getSync(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-18, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f922lambda18 = ComposableLambdaKt.composableLambdaInstance(-1087413793, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-18$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C382@15651L45,382@15646L51:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1087413793, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-18.<anonymous> (FormatSettingDialogs.kt:382)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.convert_audio_format, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-19, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f923lambda19 = ComposableLambdaKt.composableLambdaInstance(219367083, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-19$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C446@17885L32,446@17873L45:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(219367083, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-19.<anonymous> (FormatSettingDialogs.kt:446)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.confirm, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-20, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f925lambda20 = ComposableLambdaKt.composableLambdaInstance(412298284, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-20$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C434@17508L32,434@17503L38:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(412298284, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-20.<anonymous> (FormatSettingDialogs.kt:434)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.dismiss, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-21, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f926lambda21 = ComposableLambdaKt.composableLambdaInstance(657387184, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-21$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C438@17578L36:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(657387184, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-21.<anonymous> (FormatSettingDialogs.kt:438)");
            }
            IconKt.m2292Iconww6aTOc(VideoFileKt.getVideoFile(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-22, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f927lambda22 = ComposableLambdaKt.composableLambdaInstance(850318385, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-22$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C440@17653L48,440@17648L54:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(850318385, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-22.<anonymous> (FormatSettingDialogs.kt:440)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.video_format_preference, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-23, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f928lambda23 = ComposableLambdaKt.composableLambdaInstance(-1776405353, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-23$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C477@18988L32,477@18983L38:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1776405353, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-23.<anonymous> (FormatSettingDialogs.kt:477)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.dismiss, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-24, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f929lambda24 = ComposableLambdaKt.composableLambdaInstance(1942941211, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-24$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C479@19056L36:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1942941211, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-24.<anonymous> (FormatSettingDialogs.kt:479)");
            }
            IconKt.m2292Iconww6aTOc(AudioFileKt.getAudioFile(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-25, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f930lambda25 = ComposableLambdaKt.composableLambdaInstance(494934364, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-25$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C481@19131L48,481@19126L54:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(494934364, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-25.<anonymous> (FormatSettingDialogs.kt:481)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.audio_format_preference, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-26, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f931lambda26 = ComposableLambdaKt.composableLambdaInstance(258201081, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-26$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C514@20393L38:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(258201081, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-26.<anonymous> (FormatSettingDialogs.kt:514)");
            }
            IconKt.m2292Iconww6aTOc(HighQualityKt.getHighQuality(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-27, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f932lambda27 = ComposableLambdaKt.composableLambdaInstance(-1680338216, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-27$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C516@20470L38,516@20465L44:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1680338216, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-27.<anonymous> (FormatSettingDialogs.kt:516)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.audio_quality, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-28, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f933lambda28 = ComposableLambdaKt.composableLambdaInstance(-2020809114, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-28$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C559@21987L44:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2020809114, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-28.<anonymous> (FormatSettingDialogs.kt:559)");
            }
            IconKt.m2292Iconww6aTOc(SortKt.getSort(Icons.AutoMirrored.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-29, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f934lambda29 = ComposableLambdaKt.composableLambdaInstance(2037540357, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-29$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C561@22070L39,561@22065L45:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2037540357, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-29.<anonymous> (FormatSettingDialogs.kt:561)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.format_sorting, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-30, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f936lambda30 = ComposableLambdaKt.composableLambdaInstance(-2111180778, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-30$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C583@23050L52:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2111180778, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-30.<anonymous> (FormatSettingDialogs.kt:583)");
            }
            TextKt.m2817Text4IGK_g("-S", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) FontFamily.INSTANCE.getMonospace(), 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131006);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-31, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f937lambda31 = ComposableLambdaKt.composableLambdaInstance(-1738416823, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-31$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C654@25647L32,654@25635L45:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1738416823, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-31.<anonymous> (FormatSettingDialogs.kt:654)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.confirm, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-32, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f938lambda32 = ComposableLambdaKt.composableLambdaInstance(-52516888, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-32$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C643@25267L32,643@25262L38:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-52516888, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-32.<anonymous> (FormatSettingDialogs.kt:643)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.dismiss, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-33, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f939lambda33 = ComposableLambdaKt.composableLambdaInstance(-1044695580, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-33$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C646@25343L38:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1044695580, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-33.<anonymous> (FormatSettingDialogs.kt:646)");
            }
            IconKt.m2292Iconww6aTOc(HighQualityKt.getHighQuality(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-34, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f940lambda34 = ComposableLambdaKt.composableLambdaInstance(641204355, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-34$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C648@25420L38,648@25415L44:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(641204355, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-34.<anonymous> (FormatSettingDialogs.kt:648)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.video_quality, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-35, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f941lambda35 = ComposableLambdaKt.composableLambdaInstance(1096147876, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-35$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C716@27822L35:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1096147876, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-35.<anonymous> (FormatSettingDialogs.kt:716)");
            }
            IconKt.m2292Iconww6aTOc(LanguageKt.getLanguage(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-36, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f942lambda36 = ComposableLambdaKt.composableLambdaInstance(-727039387, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-36$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C715@27753L47,715@27748L53:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-727039387, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-36.<anonymous> (FormatSettingDialogs.kt:715)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.subtitle_language, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-37, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f943lambda37 = ComposableLambdaKt.composableLambdaInstance(139992487, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-37$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C732@28611L47,732@28606L53:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(139992487, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-37.<anonymous> (FormatSettingDialogs.kt:732)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.subtitle_language, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-38, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f944lambda38 = ComposableLambdaKt.composableLambdaInstance(-1605248898, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-38$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C784@30503L112:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1605248898, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-38.<anonymous> (FormatSettingDialogs.kt:784)");
                }
                IconKt.m2292Iconww6aTOc(SyncKt.getSync(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-39, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f945lambda39 = ComposableLambdaKt.composableLambdaInstance(272019997, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-39$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C782@30423L46,782@30411L59:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(272019997, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-39.<anonymous> (FormatSettingDialogs.kt:782)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.convert_subtitle, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-40, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f947lambda40 = ComposableLambdaKt.composableLambdaInstance(-219158360, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-40$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C792@30741L51,796@30995L10,791@30704L333:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 81) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-219158360, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-40.<anonymous> (FormatSettingDialogs.kt:791)");
                }
                TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.convert_subtitle_desc, $composer, 0), PaddingKt.m872paddingqDBjuR0$default(PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(12), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyLarge(), $composer, 48, 0, 65532);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-41, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f948lambda41 = ComposableLambdaKt.composableLambdaInstance(-1246920856, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-41$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C830@31984L192:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1246920856, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-41.<anonymous> (FormatSettingDialogs.kt:830)");
                }
                IconKt.m2292Iconww6aTOc(VideoSettingsKt.getVideoSettings(Icons.Outlined.INSTANCE), (String) null, SizeKt.m913size3ABfNKs(Modifier.INSTANCE, AssistChipDefaults.INSTANCE.m1938getIconSizeD9Ej5fM()), 0L, $composer, 48, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-42, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f949lambda42 = ComposableLambdaKt.composableLambdaInstance(-1325897828, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt$lambda-42$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C855@32626L192:FormatSettingDialogs.kt#5yb39d");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1325897828, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$FormatSettingDialogsKt.lambda-42.<anonymous> (FormatSettingDialogs.kt:855)");
                }
                IconKt.m2292Iconww6aTOc(VideoSettingsKt.getVideoSettings(Icons.Outlined.INSTANCE), (String) null, SizeKt.m913size3ABfNKs(Modifier.INSTANCE, AssistChipDefaults.INSTANCE.m1938getIconSizeD9Ej5fM()), 0L, $composer, 48, 8);
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
    public final Function2<Composer, Integer, Unit> m7499getLambda1$app_debug() {
        return f913lambda1;
    }

    /* JADX INFO: renamed from: getLambda-10$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7500getLambda10$app_debug() {
        return f914lambda10;
    }

    /* JADX INFO: renamed from: getLambda-11$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7501getLambda11$app_debug() {
        return f915lambda11;
    }

    /* JADX INFO: renamed from: getLambda-12$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7502getLambda12$app_debug() {
        return f916lambda12;
    }

    /* JADX INFO: renamed from: getLambda-13$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7503getLambda13$app_debug() {
        return f917lambda13;
    }

    /* JADX INFO: renamed from: getLambda-14$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7504getLambda14$app_debug() {
        return f918lambda14;
    }

    /* JADX INFO: renamed from: getLambda-15$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7505getLambda15$app_debug() {
        return f919lambda15;
    }

    /* JADX INFO: renamed from: getLambda-16$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7506getLambda16$app_debug() {
        return f920lambda16;
    }

    /* JADX INFO: renamed from: getLambda-17$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7507getLambda17$app_debug() {
        return f921lambda17;
    }

    /* JADX INFO: renamed from: getLambda-18$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7508getLambda18$app_debug() {
        return f922lambda18;
    }

    /* JADX INFO: renamed from: getLambda-19$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7509getLambda19$app_debug() {
        return f923lambda19;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7510getLambda2$app_debug() {
        return f924lambda2;
    }

    /* JADX INFO: renamed from: getLambda-20$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7511getLambda20$app_debug() {
        return f925lambda20;
    }

    /* JADX INFO: renamed from: getLambda-21$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7512getLambda21$app_debug() {
        return f926lambda21;
    }

    /* JADX INFO: renamed from: getLambda-22$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7513getLambda22$app_debug() {
        return f927lambda22;
    }

    /* JADX INFO: renamed from: getLambda-23$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7514getLambda23$app_debug() {
        return f928lambda23;
    }

    /* JADX INFO: renamed from: getLambda-24$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7515getLambda24$app_debug() {
        return f929lambda24;
    }

    /* JADX INFO: renamed from: getLambda-25$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7516getLambda25$app_debug() {
        return f930lambda25;
    }

    /* JADX INFO: renamed from: getLambda-26$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7517getLambda26$app_debug() {
        return f931lambda26;
    }

    /* JADX INFO: renamed from: getLambda-27$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7518getLambda27$app_debug() {
        return f932lambda27;
    }

    /* JADX INFO: renamed from: getLambda-28$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7519getLambda28$app_debug() {
        return f933lambda28;
    }

    /* JADX INFO: renamed from: getLambda-29$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7520getLambda29$app_debug() {
        return f934lambda29;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7521getLambda3$app_debug() {
        return f935lambda3;
    }

    /* JADX INFO: renamed from: getLambda-30$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7522getLambda30$app_debug() {
        return f936lambda30;
    }

    /* JADX INFO: renamed from: getLambda-31$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7523getLambda31$app_debug() {
        return f937lambda31;
    }

    /* JADX INFO: renamed from: getLambda-32$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7524getLambda32$app_debug() {
        return f938lambda32;
    }

    /* JADX INFO: renamed from: getLambda-33$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7525getLambda33$app_debug() {
        return f939lambda33;
    }

    /* JADX INFO: renamed from: getLambda-34$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7526getLambda34$app_debug() {
        return f940lambda34;
    }

    /* JADX INFO: renamed from: getLambda-35$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7527getLambda35$app_debug() {
        return f941lambda35;
    }

    /* JADX INFO: renamed from: getLambda-36$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7528getLambda36$app_debug() {
        return f942lambda36;
    }

    /* JADX INFO: renamed from: getLambda-37$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7529getLambda37$app_debug() {
        return f943lambda37;
    }

    /* JADX INFO: renamed from: getLambda-38$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7530getLambda38$app_debug() {
        return f944lambda38;
    }

    /* JADX INFO: renamed from: getLambda-39$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7531getLambda39$app_debug() {
        return f945lambda39;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7532getLambda4$app_debug() {
        return f946lambda4;
    }

    /* JADX INFO: renamed from: getLambda-40$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7533getLambda40$app_debug() {
        return f947lambda40;
    }

    /* JADX INFO: renamed from: getLambda-41$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7534getLambda41$app_debug() {
        return f948lambda41;
    }

    /* JADX INFO: renamed from: getLambda-42$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7535getLambda42$app_debug() {
        return f949lambda42;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7536getLambda5$app_debug() {
        return f950lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7537getLambda6$app_debug() {
        return f951lambda6;
    }

    /* JADX INFO: renamed from: getLambda-7$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7538getLambda7$app_debug() {
        return f952lambda7;
    }

    /* JADX INFO: renamed from: getLambda-8$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7539getLambda8$app_debug() {
        return f953lambda8;
    }

    /* JADX INFO: renamed from: getLambda-9$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7540getLambda9$app_debug() {
        return f954lambda9;
    }
}
