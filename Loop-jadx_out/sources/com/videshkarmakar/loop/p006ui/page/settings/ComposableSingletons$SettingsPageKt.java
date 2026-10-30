package com.videshkarmakar.loop.p006ui.page.settings;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.rounded.CameraAltKt;
import androidx.compose.material.icons.rounded.FacebookKt;
import androidx.compose.material.icons.rounded.LanguageKt;
import androidx.compose.material.icons.rounded.MusicNoteKt;
import androidx.compose.material.icons.rounded.PlayArrowKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.component.CommonComponentsKt;
import com.videshkarmakar.loop.p006ui.component.OtherProjectsCardKt;
import com.videshkarmakar.loop.p006ui.component.SettingsPanelKt;
import com.videshkarmakar.loop.p006ui.component.SettingsSocialLink;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsPage.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$SettingsPageKt {
    public static final ComposableSingletons$SettingsPageKt INSTANCE = new ComposableSingletons$SettingsPageKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f843lambda1 = ComposableLambdaKt.composableLambdaInstance(1185721688, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.ComposableSingletons$SettingsPageKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C167@7406L53,168@7492L49,165@7302L257:SettingsPage.kt#y7hb8m");
            if (($changed & 81) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1185721688, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.ComposableSingletons$SettingsPageKt.lambda-1.<anonymous> (SettingsPage.kt:165)");
                }
                SettingsPanelKt.SettingsProfileHeader("https://cdn.phototourl.com/member/2026-09-24-d3b8ff6f-f0d4-43e0-9082-9f39cc851774.png", StringResources_androidKt.stringResource(C3070R.string.settings_developer_name, $composer, 0), StringResources_androidKt.stringResource(C3070R.string.settings_panel_role, $composer, 0), null, $composer, 6, 8);
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
    public static Function3<LazyItemScope, Composer, Integer, Unit> f844lambda2 = ComposableLambdaKt.composableLambdaInstance(661485953, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.ComposableSingletons$SettingsPageKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C173@7610L1131:SettingsPage.kt#y7hb8m");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(661485953, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.ComposableSingletons$SettingsPageKt.lambda-2.<anonymous> (SettingsPage.kt:173)");
            }
            SettingsPanelKt.SettingsSocialRow(CollectionsKt.listOf((Object[]) new SettingsSocialLink[]{new SettingsSocialLink(LanguageKt.getLanguage(Icons.Rounded.INSTANCE), "Website", "https://videshkarmakar.carrd.co/"), new SettingsSocialLink(MusicNoteKt.getMusicNote(Icons.Rounded.INSTANCE), "Spotify", "https://open.spotify.com/artist/2eJEzi0mzJB60zVJf0OjWP"), new SettingsSocialLink(CameraAltKt.getCameraAlt(Icons.Rounded.INSTANCE), "Instagram", "https://www.instagram.com/code.red_videsh/"), new SettingsSocialLink(PlayArrowKt.getPlayArrow(Icons.Rounded.INSTANCE), "YouTube", "https://www.youtube.com/@videshkarmakar2000"), new SettingsSocialLink(FacebookKt.getFacebook(Icons.Rounded.INSTANCE), "Facebook", "https://www.facebook.com/gfx.videsh")}), null, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f845lambda3 = ComposableLambdaKt.composableLambdaInstance(1544194045, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.ComposableSingletons$SettingsPageKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C282@12719L22:SettingsPage.kt#y7hb8m");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1544194045, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.ComposableSingletons$SettingsPageKt.lambda-3.<anonymous> (SettingsPage.kt:282)");
            }
            SettingsPanelKt.SettingsGroupDivider(null, $composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f846lambda4 = ComposableLambdaKt.composableLambdaInstance(-161935557, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.ComposableSingletons$SettingsPageKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C293@13108L22:SettingsPage.kt#y7hb8m");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-161935557, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.ComposableSingletons$SettingsPageKt.lambda-4.<anonymous> (SettingsPage.kt:293)");
            }
            SettingsPanelKt.SettingsGroupDivider(null, $composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f847lambda5 = ComposableLambdaKt.composableLambdaInstance(-1221209217, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.ComposableSingletons$SettingsPageKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C317@14139L22:SettingsPage.kt#y7hb8m");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1221209217, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.ComposableSingletons$SettingsPageKt.lambda-5.<anonymous> (SettingsPage.kt:317)");
            }
            SettingsPanelKt.SettingsGroupDivider(null, $composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-6, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f848lambda6 = ComposableLambdaKt.composableLambdaInstance(1367628477, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.ComposableSingletons$SettingsPageKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C329@14507L41,330@14565L22:SettingsPage.kt#y7hb8m");
            if (($changed & 81) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1367628477, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.ComposableSingletons$SettingsPageKt.lambda-6.<anonymous> (SettingsPage.kt:329)");
                }
                SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(20)), $composer, 6);
                OtherProjectsCardKt.OtherProjectsSection(null, $composer, 0, 1);
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
    public static Function3<LazyItemScope, Composer, Integer, Unit> f849lambda7 = ComposableLambdaKt.composableLambdaInstance(-1632919972, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.ComposableSingletons$SettingsPageKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C332@14621L21:SettingsPage.kt#y7hb8m");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1632919972, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.ComposableSingletons$SettingsPageKt.lambda-7.<anonymous> (SettingsPage.kt:332)");
            }
            CommonComponentsKt.NavigationBarSpacer(null, $composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-8, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f850lambda8 = ComposableLambdaKt.composableLambdaInstance(-338501125, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.ComposableSingletons$SettingsPageKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C333@14664L41:SettingsPage.kt#y7hb8m");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-338501125, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.ComposableSingletons$SettingsPageKt.lambda-8.<anonymous> (SettingsPage.kt:333)");
            }
            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7426getLambda1$app_debug() {
        return f843lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7427getLambda2$app_debug() {
        return f844lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7428getLambda3$app_debug() {
        return f845lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7429getLambda4$app_debug() {
        return f846lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7430getLambda5$app_debug() {
        return f847lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7431getLambda6$app_debug() {
        return f848lambda6;
    }

    /* JADX INFO: renamed from: getLambda-7$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7432getLambda7$app_debug() {
        return f849lambda7;
    }

    /* JADX INFO: renamed from: getLambda-8$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7433getLambda8$app_debug() {
        return f850lambda8;
    }
}
