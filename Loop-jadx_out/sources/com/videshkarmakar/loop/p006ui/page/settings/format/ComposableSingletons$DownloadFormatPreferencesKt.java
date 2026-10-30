package com.videshkarmakar.loop.p006ui.page.settings.format;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ContentCutKt;
import androidx.compose.material.icons.outlined.SpatialAudioOffKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.component.PreferenceItemsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DownloadFormatPreferences.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$DownloadFormatPreferencesKt {
    public static final ComposableSingletons$DownloadFormatPreferencesKt INSTANCE = new ComposableSingletons$DownloadFormatPreferencesKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f901lambda1 = ComposableLambdaKt.composableLambdaInstance(-91259176, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C117@6006L36,115@5932L129:DownloadFormatPreferences.kt#5yb39d");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-91259176, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt.lambda-1.<anonymous> (DownloadFormatPreferences.kt:115)");
                }
                TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.format, $composer, 0), (Modifier) Modifier.INSTANCE, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 48, 0, 131068);
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
    public static Function3<LazyItemScope, Composer, Integer, Unit> f905lambda2 = ComposableLambdaKt.composableLambdaInstance(587098229, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C134@6589L57,134@6567L80:DownloadFormatPreferences.kt#5yb39d");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(587098229, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt.lambda-2.<anonymous> (DownloadFormatPreferences.kt:134)");
            }
            PreferenceItemsKt.PreferenceInfo(null, StringResources_androidKt.stringResource(C3070R.string.custom_command_enabled_hint, $composer, 0), null, false, $composer, 0, 13);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f906lambda3 = ComposableLambdaKt.composableLambdaInstance(-2029623206, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C137@6735L35,137@6709L62:DownloadFormatPreferences.kt#5yb39d");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2029623206, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt.lambda-3.<anonymous> (DownloadFormatPreferences.kt:137)");
            }
            PreferenceItemsKt.m7312PreferenceSubtitleww6aTOc(null, null, StringResources_androidKt.stringResource(C3070R.string.audio, $composer, 0), 0L, $composer, 0, 11);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f907lambda4 = ComposableLambdaKt.composableLambdaInstance(-1185607977, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C206@10277L35,206@10251L62:DownloadFormatPreferences.kt#5yb39d");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1185607977, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt.lambda-4.<anonymous> (DownloadFormatPreferences.kt:206)");
            }
            PreferenceItemsKt.m7312PreferenceSubtitleww6aTOc(null, null, StringResources_androidKt.stringResource(C3070R.string.video, $composer, 0), 0L, $composer, 0, 11);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f908lambda5 = ComposableLambdaKt.composableLambdaInstance(1453189804, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C255@13034L53,255@13012L76:DownloadFormatPreferences.kt#5yb39d");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1453189804, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt.lambda-5.<anonymous> (DownloadFormatPreferences.kt:255)");
            }
            PreferenceItemsKt.PreferenceInfo(null, StringResources_androidKt.stringResource(C3070R.string.embed_subtitles_mkv_msg, $composer, 0), null, false, $composer, 0, 13);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-6, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f909lambda6 = ComposableLambdaKt.composableLambdaInstance(-1923559596, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C260@13199L47,260@13173L74:DownloadFormatPreferences.kt#5yb39d");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1923559596, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt.lambda-6.<anonymous> (DownloadFormatPreferences.kt:260)");
            }
            PreferenceItemsKt.m7312PreferenceSubtitleww6aTOc(null, null, StringResources_androidKt.stringResource(C3070R.string.advanced_settings, $composer, 0), 0L, $composer, 0, 11);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-7, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f910lambda7 = ComposableLambdaKt.composableLambdaInstance(848073289, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C373@18212L37:DownloadFormatPreferences.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(848073289, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt.lambda-7.<anonymous> (DownloadFormatPreferences.kt:373)");
            }
            IconKt.m2292Iconww6aTOc(ContentCutKt.getContentCut(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-8, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f911lambda8 = ComposableLambdaKt.composableLambdaInstance(-975113974, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C391@18810L57,390@18784L151:DownloadFormatPreferences.kt#5yb39d");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-975113974, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt.lambda-8.<anonymous> (DownloadFormatPreferences.kt:390)");
                }
                TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.enable_experimental_feature, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6651boximpl(TextAlign.INSTANCE.m6658getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 130558);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-9, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f912lambda9 = ComposableLambdaKt.composableLambdaInstance(1496666059, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C387@18678L51,387@18673L57:DownloadFormatPreferences.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1496666059, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt.lambda-9.<anonymous> (DownloadFormatPreferences.kt:387)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.clip_video_dialog_msg, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-10, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f902lambda10 = ComposableLambdaKt.composableLambdaInstance(-1569625112, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt$lambda-10$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C398@19083L42:DownloadFormatPreferences.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1569625112, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt.lambda-10.<anonymous> (DownloadFormatPreferences.kt:398)");
            }
            IconKt.m2292Iconww6aTOc(SpatialAudioOffKt.getSpatialAudioOff(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-11, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f903lambda11 = ComposableLambdaKt.composableLambdaInstance(902154921, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt$lambda-11$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C416@19701L57,415@19675L151:DownloadFormatPreferences.kt#5yb39d");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(902154921, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt.lambda-11.<anonymous> (DownloadFormatPreferences.kt:415)");
                }
                TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.enable_experimental_feature, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6651boximpl(TextAlign.INSTANCE.m6658getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 130558);
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
    public static Function2<Composer, Integer, Unit> f904lambda12 = ComposableLambdaKt.composableLambdaInstance(-921032342, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt$lambda-12$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C412@19568L52,412@19563L58:DownloadFormatPreferences.kt#5yb39d");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-921032342, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.ComposableSingletons$DownloadFormatPreferencesKt.lambda-12.<anonymous> (DownloadFormatPreferences.kt:412)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.merge_audiostream_desc, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7487getLambda1$app_debug() {
        return f901lambda1;
    }

    /* JADX INFO: renamed from: getLambda-10$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7488getLambda10$app_debug() {
        return f902lambda10;
    }

    /* JADX INFO: renamed from: getLambda-11$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7489getLambda11$app_debug() {
        return f903lambda11;
    }

    /* JADX INFO: renamed from: getLambda-12$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7490getLambda12$app_debug() {
        return f904lambda12;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7491getLambda2$app_debug() {
        return f905lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7492getLambda3$app_debug() {
        return f906lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7493getLambda4$app_debug() {
        return f907lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7494getLambda5$app_debug() {
        return f908lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7495getLambda6$app_debug() {
        return f909lambda6;
    }

    /* JADX INFO: renamed from: getLambda-7$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7496getLambda7$app_debug() {
        return f910lambda7;
    }

    /* JADX INFO: renamed from: getLambda-8$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7497getLambda8$app_debug() {
        return f911lambda8;
    }

    /* JADX INFO: renamed from: getLambda-9$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7498getLambda9$app_debug() {
        return f912lambda9;
    }
}
