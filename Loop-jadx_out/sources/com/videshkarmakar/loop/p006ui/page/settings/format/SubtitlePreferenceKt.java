package com.videshkarmakar.loop.p006ui.page.settings.format;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ClosedCaptionKt;
import androidx.compose.material.icons.outlined.LanguageKt;
import androidx.compose.material.icons.outlined.SaveKt;
import androidx.compose.material.icons.outlined.SubtitlesKt;
import androidx.compose.material.icons.outlined.SyncKt;
import androidx.compose.material.icons.outlined.TranslateKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.vector.ImageVector;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.component.ButtonsKt;
import com.videshkarmakar.loop.p006ui.component.DividerKt;
import com.videshkarmakar.loop.p006ui.component.IconButtonsKt;
import com.videshkarmakar.loop.p006ui.component.PreferenceItemsKt;
import com.videshkarmakar.loop.p006ui.component.TopAppBarKt;
import com.videshkarmakar.loop.util.PreferenceStrings;
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

/* JADX INFO: compiled from: SubtitlePreference.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m194d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\b\u001a\u00020\u0007X\u008a\u0084\u0002²\u0006\n\u0010\t\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\n\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\u000b\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\f\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\r\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\u000e\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\u000f\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0007X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0007X\u008a\u008e\u0002"}, m195d2 = {"SubtitlePreference", "", "onNavigateBack", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_debug", "downloadSubtitle", "", "sponsorBlock", "embedSubtitle", "autoSubtitle", "autoTranslatedSubtitle", "showLanguageDialog", "showConversionDialog", "showEmbedSubtitleDialog", "showAutoTranslateDialog", "subtitleFormatText", "", "subtitleLang", "hint", "downloadAudio", "keepSubtitles"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SubtitlePreferenceKt {
    public static final void SubtitlePreference(final Function0<Unit> onNavigateBack, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Object value$iv$iv4;
        Object value$iv$iv5;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        Object value$iv5;
        Object value$iv6;
        final MutableState showLanguageDialog$delegate;
        String str;
        final MutableState showConversionDialog$delegate;
        Composer $composer2;
        Composer $composer3;
        final MutableState showAutoTranslateDialog$delegate;
        Object value$iv7;
        final MutableState showEmbedSubtitleDialog$delegate;
        Object value$iv8;
        Object value$iv9;
        Object value$iv10;
        Intrinsics.checkNotNullParameter(onNavigateBack, "onNavigateBack");
        Composer $composer4 = $composer.startRestartGroup(-1786018313);
        ComposerKt.sourceInformation($composer4, "C(SubtitlePreference)57@2851L24,56@2809L102,60@2949L12,61@2999L12,63@3115L12,64@3166L12,65@3239L12,67@3283L34,68@3350L34,69@3420L34,70@3490L34,72@3556L132,78@3714L78,79@3820L51,80@3900L48,83@3967L310,93@4318L12,100@4485L428,113@4925L4263,96@4337L4852,252@10374L35,254@10500L233,260@10751L117,251@10330L847:SubtitlePreference.kt#5yb39d");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer4.changedInstance(onNavigateBack) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 11) == 2 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            $composer3 = $composer4;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1786018313, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreference (SubtitlePreference.kt:55)");
            }
            final TopAppBarScrollBehavior scrollBehavior = TopAppBarDefaults.INSTANCE.exitUntilCollapsedScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, $composer4, 0, 7), new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$scrollBehavior$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return true;
                }
            }, null, null, $composer4, (TopAppBarDefaults.$stable << 12) | 48, 12);
            $composer4.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer4, "CC12@469L46:Ext.kt#x6o9ax");
            $composer4.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer4, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv = $composer4.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.SUBTITLE, false, 1, null)), null, 2, null);
                $composer4.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            final MutableState downloadSubtitle$delegate = (MutableState) value$iv$iv;
            $composer4.endReplaceGroup();
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer4, "CC12@469L46:Ext.kt#x6o9ax");
            $composer4.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer4, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv2 = $composer4.rememberedValue();
            if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.SPONSORBLOCK, false, 1, null)), null, 2, null);
                $composer4.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            final MutableState sponsorBlock$delegate = (MutableState) value$iv$iv2;
            $composer4.endReplaceGroup();
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer4, "CC12@469L46:Ext.kt#x6o9ax");
            $composer4.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer4, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv3 = $composer4.rememberedValue();
            if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.EMBED_SUBTITLE, false, 1, null)), null, 2, null);
                $composer4.updateRememberedValue(value$iv$iv3);
            } else {
                value$iv$iv3 = it$iv$iv3;
            }
            final MutableState embedSubtitle$delegate = (MutableState) value$iv$iv3;
            $composer4.endReplaceGroup();
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer4, "CC12@469L46:Ext.kt#x6o9ax");
            $composer4.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer4, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv4 = $composer4.rememberedValue();
            if (it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.AUTO_SUBTITLE, false, 1, null)), null, 2, null);
                $composer4.updateRememberedValue(value$iv$iv4);
            } else {
                value$iv$iv4 = it$iv$iv4;
            }
            final MutableState autoSubtitle$delegate = (MutableState) value$iv$iv4;
            $composer4.endReplaceGroup();
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer4, "CC12@469L46:Ext.kt#x6o9ax");
            $composer4.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer4, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv5 = $composer4.rememberedValue();
            if (it$iv$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.AUTO_TRANSLATED_SUBTITLES, false, 1, null)), null, 2, null);
                $composer4.updateRememberedValue(value$iv$iv5);
            } else {
                value$iv$iv5 = it$iv$iv5;
            }
            final MutableState autoTranslatedSubtitle$delegate = (MutableState) value$iv$iv5;
            $composer4.endReplaceGroup();
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(1824408657);
            ComposerKt.sourceInformation($composer4, "CC(remember):SubtitlePreference.kt#9igjgp");
            Object it$iv = $composer4.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer4.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState showLanguageDialog$delegate2 = (MutableState) value$iv;
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(1824408724);
            ComposerKt.sourceInformation($composer4, "CC(remember):SubtitlePreference.kt#9igjgp");
            Object it$iv2 = $composer4.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer4.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableState showConversionDialog$delegate2 = (MutableState) value$iv2;
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(1824408794);
            ComposerKt.sourceInformation($composer4, "CC(remember):SubtitlePreference.kt#9igjgp");
            Object value$iv11 = $composer4.rememberedValue();
            if (value$iv11 == Composer.INSTANCE.getEmpty()) {
                value$iv11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer4.updateRememberedValue(value$iv11);
            }
            final MutableState mutableState = (MutableState) value$iv11;
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(1824408864);
            ComposerKt.sourceInformation($composer4, "CC(remember):SubtitlePreference.kt#9igjgp");
            Object it$iv3 = $composer4.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer4.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final MutableState subtitleFormatText$delegate = (MutableState) value$iv3;
            $composer4.endReplaceGroup();
            boolean zSubtitlePreference$lambda$13 = SubtitlePreference$lambda$13(showConversionDialog$delegate2);
            $composer4.startReplaceGroup(1824408930);
            ComposerKt.sourceInformation($composer4, "CC(remember):SubtitlePreference.kt#9igjgp");
            boolean invalid$iv = $composer4.changed(zSubtitlePreference$lambda$13);
            Object it$iv4 = $composer4.rememberedValue();
            if (invalid$iv || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PreferenceStrings.getSubtitleConversionFormat$default(PreferenceStrings.INSTANCE, 0, 1, null), null, 2, null);
                $composer4.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            final MutableState subtitleFormatText$delegate2 = (MutableState) value$iv4;
            $composer4.endReplaceGroup();
            boolean zSubtitlePreference$lambda$10 = SubtitlePreference$lambda$10(showLanguageDialog$delegate2);
            $composer4.startReplaceGroup(1824409088);
            ComposerKt.sourceInformation($composer4, "CC(remember):SubtitlePreference.kt#9igjgp");
            boolean invalid$iv2 = $composer4.changed(zSubtitlePreference$lambda$10);
            Object it$iv5 = $composer4.rememberedValue();
            if (invalid$iv2 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.SUBTITLE_LANGUAGE, null, 1, null), null, 2, null);
                $composer4.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv5;
            }
            final MutableState subtitleLang$delegate = (MutableState) value$iv5;
            $composer4.endReplaceGroup();
            final String sponsorBlockText = StringResources_androidKt.stringResource(C3070R.string.subtitle_sponsorblock, $composer4, 0);
            final String embedSubtitleText = StringResources_androidKt.stringResource(C3070R.string.embed_subtitles_mkv_msg, $composer4, 0);
            boolean zSubtitlePreference$lambda$2 = SubtitlePreference$lambda$2(sponsorBlock$delegate);
            boolean zSubtitlePreference$lambda$3 = SubtitlePreference$lambda$3(embedSubtitle$delegate);
            $composer4.startReplaceGroup(1824409341);
            ComposerKt.sourceInformation($composer4, "CC(remember):SubtitlePreference.kt#9igjgp");
            boolean invalid$iv3 = $composer4.changed(zSubtitlePreference$lambda$2) | $composer4.changed(zSubtitlePreference$lambda$3);
            Object it$iv6 = $composer4.rememberedValue();
            if (invalid$iv3 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                value$iv6 = SnapshotStateKt.derivedStateOf(new Function0<String>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$hint$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder $this$invoke_u24lambda_u240 = new StringBuilder();
                        String str2 = sponsorBlockText;
                        String str3 = embedSubtitleText;
                        MutableState<Boolean> mutableState2 = sponsorBlock$delegate;
                        MutableState<Boolean> mutableState3 = embedSubtitle$delegate;
                        if (SubtitlePreferenceKt.SubtitlePreference$lambda$2(mutableState2)) {
                            $this$invoke_u24lambda_u240.append(str2);
                        }
                        if ($this$invoke_u24lambda_u240.length() > 0) {
                            $this$invoke_u24lambda_u240.append("\n\n");
                        }
                        if (SubtitlePreferenceKt.SubtitlePreference$lambda$3(mutableState3)) {
                            $this$invoke_u24lambda_u240.append(str3);
                        }
                        return $this$invoke_u24lambda_u240.toString();
                    }
                });
                $composer4.updateRememberedValue(value$iv6);
            } else {
                value$iv6 = it$iv6;
            }
            final State hint$delegate = (State) value$iv6;
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer4, "CC12@469L46:Ext.kt#x6o9ax");
            $composer4.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer4, "CC(remember):Ext.kt#9igjgp");
            Object value$iv$iv6 = $composer4.rememberedValue();
            if (value$iv$iv6 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.EXTRACT_AUDIO, false, 1, null)), null, 2, null);
                $composer4.updateRememberedValue(value$iv$iv6);
            }
            final MutableState downloadAudio$delegate = (MutableState) value$iv$iv6;
            $composer4.endReplaceGroup();
            $composer4.endReplaceGroup();
            ScaffoldKt.m2530ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollBehavior.getNestedScrollConnection(), null, 2, null), ComposableLambdaKt.rememberComposableLambda(-169688397, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt.SubtitlePreference.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer5, int $changed2) {
                    ComposerKt.sourceInformation($composer5, "C107@4741L115,101@4499L404:SubtitlePreference.kt#5yb39d");
                    if (($changed2 & 11) != 2 || !$composer5.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-169688397, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreference.<anonymous> (SubtitlePreference.kt:101)");
                        }
                        Function2<Composer, Integer, Unit> function2M7541getLambda1$app_debug = ComposableSingletons$SubtitlePreferenceKt.INSTANCE.m7541getLambda1$app_debug();
                        final Function0<Unit> function0 = onNavigateBack;
                        TopAppBarKt.LargeTopAppBar(function2M7541getLambda1$app_debug, null, ComposableLambdaKt.rememberComposableLambda(-207444264, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt.SubtitlePreference.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer6, int $changed3) {
                                Object value$iv12;
                                ComposerKt.sourceInformation($composer6, "C108@4774L64,108@4763L75:SubtitlePreference.kt#5yb39d");
                                if (($changed3 & 11) == 2 && $composer6.getSkipping()) {
                                    $composer6.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-207444264, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreference.<anonymous>.<anonymous> (SubtitlePreference.kt:108)");
                                }
                                $composer6.startReplaceGroup(2137918182);
                                ComposerKt.sourceInformation($composer6, "CC(remember):SubtitlePreference.kt#9igjgp");
                                boolean invalid$iv4 = $composer6.changed(function0);
                                final Function0<Unit> function1 = function0;
                                Object it$iv7 = $composer6.rememberedValue();
                                if (invalid$iv4 || it$iv7 == Composer.INSTANCE.getEmpty()) {
                                    value$iv12 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$1$1$1$1
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
                                    $composer6.updateRememberedValue(value$iv12);
                                } else {
                                    value$iv12 = it$iv7;
                                }
                                $composer6.endReplaceGroup();
                                IconButtonsKt.BackButton((Function0) value$iv12, $composer6, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer5, 54), null, scrollBehavior, $composer5, 390, 10);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer5.skipToGroupEnd();
                }
            }, $composer4, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1572948472, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt.SubtitlePreference.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
                    invoke(paddingValues, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues it, Composer $composer5, int $changed2) {
                    Object value$iv12;
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer5, "C114@4983L4195,114@4939L4239:SubtitlePreference.kt#5yb39d");
                    int $dirty3 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty3 |= $composer5.changed(it) ? 4 : 2;
                    }
                    int $dirty4 = $dirty3;
                    if (($dirty4 & 91) == 18 && $composer5.getSkipping()) {
                        $composer5.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1572948472, $dirty4, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreference.<anonymous> (SubtitlePreference.kt:114)");
                    }
                    Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, it);
                    $composer5.startReplaceGroup(-2087190506);
                    ComposerKt.sourceInformation($composer5, "CC(remember):SubtitlePreference.kt#9igjgp");
                    boolean invalid$iv4 = $composer5.changed(downloadSubtitle$delegate) | $composer5.changed(subtitleLang$delegate) | $composer5.changed(subtitleFormatText$delegate2) | $composer5.changed(autoSubtitle$delegate) | $composer5.changed(autoTranslatedSubtitle$delegate) | $composer5.changed(embedSubtitle$delegate) | $composer5.changed(downloadAudio$delegate) | $composer5.changed(hint$delegate);
                    final MutableState<Boolean> mutableState2 = downloadSubtitle$delegate;
                    final MutableState<String> mutableState3 = subtitleLang$delegate;
                    final MutableState<Boolean> mutableState4 = showLanguageDialog$delegate2;
                    final MutableState<String> mutableState5 = subtitleFormatText$delegate2;
                    final MutableState<Boolean> mutableState6 = showConversionDialog$delegate2;
                    final MutableState<Boolean> mutableState7 = autoSubtitle$delegate;
                    final MutableState<Boolean> mutableState8 = autoTranslatedSubtitle$delegate;
                    final MutableState<Boolean> mutableState9 = subtitleFormatText$delegate;
                    final MutableState<Boolean> mutableState10 = embedSubtitle$delegate;
                    final MutableState<Boolean> mutableState11 = downloadAudio$delegate;
                    final MutableState<Boolean> mutableState12 = mutableState;
                    final State<String> state = hint$delegate;
                    Object it$iv7 = $composer5.rememberedValue();
                    if (invalid$iv4 || it$iv7 == Composer.INSTANCE.getEmpty()) {
                        value$iv12 = new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$2$1$1
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
                                final MutableState<Boolean> mutableState13 = mutableState2;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(2032673180, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$2$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer6, int $changed3) {
                                        Object value$iv13;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer6, "C118@5092L48,120@5230L161,117@5029L397:SubtitlePreference.kt#5yb39d");
                                        if (($changed3 & 81) != 16 || !$composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2032673180, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreference.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SubtitlePreference.kt:117)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.download_subtitles, $composer6, 0);
                                            boolean zSubtitlePreference$lambda$0 = SubtitlePreferenceKt.SubtitlePreference$lambda$0(mutableState13);
                                            $composer6.startReplaceGroup(-1686624400);
                                            ComposerKt.sourceInformation($composer6, "CC(remember):SubtitlePreference.kt#9igjgp");
                                            boolean invalid$iv5 = $composer6.changed(mutableState13);
                                            final MutableState<Boolean> mutableState14 = mutableState13;
                                            Object it$iv8 = $composer6.rememberedValue();
                                            if (invalid$iv5 || it$iv8 == Composer.INSTANCE.getEmpty()) {
                                                value$iv13 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$2$1$1$1$1$1
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
                                                        SubtitlePreferenceKt.SubtitlePreference$lambda$1(mutableState14, !SubtitlePreferenceKt.SubtitlePreference$lambda$0(mutableState14));
                                                        PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.SUBTITLE, SubtitlePreferenceKt.SubtitlePreference$lambda$0(mutableState14));
                                                    }
                                                };
                                                $composer6.updateRememberedValue(value$iv13);
                                            } else {
                                                value$iv13 = it$iv8;
                                            }
                                            $composer6.endReplaceGroup();
                                            PreferenceItemsKt.PreferenceSwitchWithContainer(strStringResource, null, zSubtitlePreference$lambda$0, (Function0) value$iv13, $composer6, 48, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer6.skipToGroupEnd();
                                    }
                                }), 3, null);
                                final MutableState<String> mutableState14 = mutableState3;
                                final MutableState<Boolean> mutableState15 = mutableState4;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(374338451, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$2$1$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer6, int $changed3) {
                                        Object value$iv13;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer6, "C128@5536L47,131@5727L29,127@5488L290:SubtitlePreference.kt#5yb39d");
                                        if (($changed3 & 81) != 16 || !$composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(374338451, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreference.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SubtitlePreference.kt:127)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.subtitle_language, $composer6, 0);
                                            ImageVector language = LanguageKt.getLanguage(Icons.Outlined.INSTANCE);
                                            String strSubtitlePreference$lambda$24 = SubtitlePreferenceKt.SubtitlePreference$lambda$24(mutableState14);
                                            $composer6.startReplaceGroup(-1686623903);
                                            ComposerKt.sourceInformation($composer6, "CC(remember):SubtitlePreference.kt#9igjgp");
                                            final MutableState<Boolean> mutableState16 = mutableState15;
                                            Object it$iv8 = $composer6.rememberedValue();
                                            if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                                                value$iv13 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$2$1$1$2$1$1
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
                                                        SubtitlePreferenceKt.SubtitlePreference$lambda$11(mutableState16, true);
                                                    }
                                                };
                                                $composer6.updateRememberedValue(value$iv13);
                                            } else {
                                                value$iv13 = it$iv8;
                                            }
                                            $composer6.endReplaceGroup();
                                            PreferenceItemsKt.PreferenceItem(strStringResource, strSubtitlePreference$lambda$24, language, false, null, null, null, null, null, (Function0) value$iv13, $composer6, 805306368, 504);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer6.skipToGroupEnd();
                                    }
                                }), 3, null);
                                final MutableState<String> mutableState16 = mutableState5;
                                final MutableState<Boolean> mutableState17 = mutableState6;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1757326636, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$2$1$1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer6, int $changed3) {
                                        Object value$iv13;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer6, "C137@5889L46,140@6069L75,136@5841L303:SubtitlePreference.kt#5yb39d");
                                        if (($changed3 & 81) != 16 || !$composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1757326636, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreference.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SubtitlePreference.kt:136)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.convert_subtitle, $composer6, 0);
                                            String strSubtitlePreference$lambda$22 = SubtitlePreferenceKt.SubtitlePreference$lambda$22(mutableState16);
                                            ImageVector sync = SyncKt.getSync(Icons.Outlined.INSTANCE);
                                            $composer6.startReplaceGroup(-1686623561);
                                            ComposerKt.sourceInformation($composer6, "CC(remember):SubtitlePreference.kt#9igjgp");
                                            final MutableState<Boolean> mutableState18 = mutableState17;
                                            Object it$iv8 = $composer6.rememberedValue();
                                            if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                                                value$iv13 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$2$1$1$3$1$1
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
                                                        SubtitlePreferenceKt.SubtitlePreference$lambda$14(mutableState18, true);
                                                    }
                                                };
                                                $composer6.updateRememberedValue(value$iv13);
                                            } else {
                                                value$iv13 = it$iv8;
                                            }
                                            $composer6.endReplaceGroup();
                                            PreferenceItemsKt.PreferenceItem(strStringResource, strSubtitlePreference$lambda$22, sync, false, null, null, null, null, null, (Function0) value$iv13, $composer6, 805306368, 504);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer6.skipToGroupEnd();
                                    }
                                }), 3, null);
                                final MutableState<Boolean> mutableState18 = mutableState7;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(405975573, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$2$1$1.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer6, int $changed3) {
                                        Object value$iv13;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer6, "C147@6257L43,149@6401L102,151@6541L154,146@6207L510:SubtitlePreference.kt#5yb39d");
                                        if (($changed3 & 81) == 16 && $composer6.getSkipping()) {
                                            $composer6.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(405975573, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreference.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SubtitlePreference.kt:146)");
                                        }
                                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.auto_subtitle, $composer6, 0);
                                        ImageVector closedCaption = ClosedCaptionKt.getClosedCaption(Icons.Outlined.INSTANCE);
                                        String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.auto_subtitle_desc, $composer6, 0);
                                        boolean zSubtitlePreference$lambda$5 = SubtitlePreferenceKt.SubtitlePreference$lambda$5(mutableState18);
                                        $composer6.startReplaceGroup(-1686623089);
                                        ComposerKt.sourceInformation($composer6, "CC(remember):SubtitlePreference.kt#9igjgp");
                                        boolean invalid$iv5 = $composer6.changed(mutableState18);
                                        final MutableState<Boolean> mutableState19 = mutableState18;
                                        Object it$iv8 = $composer6.rememberedValue();
                                        if (invalid$iv5 || it$iv8 == Composer.INSTANCE.getEmpty()) {
                                            value$iv13 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$2$1$1$4$1$1
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
                                                    SubtitlePreferenceKt.SubtitlePreference$lambda$6(mutableState19, !SubtitlePreferenceKt.SubtitlePreference$lambda$5(mutableState19));
                                                    PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.AUTO_SUBTITLE, SubtitlePreferenceKt.SubtitlePreference$lambda$5(mutableState19));
                                                }
                                            };
                                            $composer6.updateRememberedValue(value$iv13);
                                        } else {
                                            value$iv13 = it$iv8;
                                        }
                                        $composer6.endReplaceGroup();
                                        PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, closedCaption, false, zSubtitlePreference$lambda$5, null, (Function0) value$iv13, $composer6, 0, 40);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), 3, null);
                                final MutableState<Boolean> mutableState19 = mutableState8;
                                final MutableState<Boolean> mutableState20 = mutableState7;
                                final MutableState<Boolean> mutableState21 = mutableState9;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1725689514, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$2$1$1.5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer6, int $changed3) {
                                        Object value$iv13;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer6, "C160@6830L55,164@7073L330,159@6780L623:SubtitlePreference.kt#5yb39d");
                                        if (($changed3 & 81) != 16 || !$composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1725689514, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreference.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SubtitlePreference.kt:159)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.auto_translated_subtitles, $composer6, 0);
                                            ImageVector translate = TranslateKt.getTranslate(Icons.Outlined.INSTANCE);
                                            boolean zSubtitlePreference$lambda$7 = SubtitlePreferenceKt.SubtitlePreference$lambda$7(mutableState19);
                                            boolean zSubtitlePreference$lambda$5 = SubtitlePreferenceKt.SubtitlePreference$lambda$5(mutableState20);
                                            $composer6.startReplaceGroup(-1686622557);
                                            ComposerKt.sourceInformation($composer6, "CC(remember):SubtitlePreference.kt#9igjgp");
                                            boolean invalid$iv5 = $composer6.changed(mutableState19);
                                            final MutableState<Boolean> mutableState22 = mutableState19;
                                            final MutableState<Boolean> mutableState23 = mutableState21;
                                            Object it$iv8 = $composer6.rememberedValue();
                                            if (invalid$iv5 || it$iv8 == Composer.INSTANCE.getEmpty()) {
                                                value$iv13 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$2$1$1$5$1$1
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
                                                        if (!SubtitlePreferenceKt.SubtitlePreference$lambda$7(mutableState22)) {
                                                            SubtitlePreferenceKt.SubtitlePreference$lambda$20(mutableState23, true);
                                                        } else {
                                                            SubtitlePreferenceKt.SubtitlePreference$lambda$8(mutableState22, false);
                                                            PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.AUTO_TRANSLATED_SUBTITLES, false);
                                                        }
                                                    }
                                                };
                                                $composer6.updateRememberedValue(value$iv13);
                                            } else {
                                                value$iv13 = it$iv8;
                                            }
                                            $composer6.endReplaceGroup();
                                            PreferenceItemsKt.PreferenceSwitch(strStringResource, null, translate, zSubtitlePreference$lambda$5, zSubtitlePreference$lambda$7, null, (Function0) value$iv13, $composer6, 0, 34);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer6.skipToGroupEnd();
                                    }
                                }), 3, null);
                                final MutableState<Boolean> mutableState22 = mutableState10;
                                final MutableState<Boolean> mutableState23 = mutableState11;
                                final MutableState<Boolean> mutableState24 = mutableState12;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(437612695, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$2$1$1.6
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer6, int $changed3) {
                                        Object value$iv13;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer6, "C175@7466L19,177@7556L45,178@7641L104,183@7882L328,176@7506L759:SubtitlePreference.kt#5yb39d");
                                        if (($changed3 & 81) != 16 || !$composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(437612695, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreference.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SubtitlePreference.kt:175)");
                                            }
                                            DividerKt.m7300HorizontalDivideriJQMabo(null, 0L, $composer6, 0, 3);
                                            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.embed_subtitles, $composer6, 0);
                                            String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.embed_subtitles_desc, $composer6, 0);
                                            boolean zSubtitlePreference$lambda$4 = SubtitlePreferenceKt.SubtitlePreference$lambda$3(mutableState22);
                                            boolean z = !SubtitlePreferenceKt.SubtitlePreference$lambda$27(mutableState23);
                                            ImageVector subtitles = SubtitlesKt.getSubtitles(Icons.Outlined.INSTANCE);
                                            $composer6.startReplaceGroup(-1686621748);
                                            ComposerKt.sourceInformation($composer6, "CC(remember):SubtitlePreference.kt#9igjgp");
                                            boolean invalid$iv5 = $composer6.changed(mutableState22);
                                            final MutableState<Boolean> mutableState25 = mutableState22;
                                            final MutableState<Boolean> mutableState26 = mutableState24;
                                            Object it$iv8 = $composer6.rememberedValue();
                                            if (invalid$iv5 || it$iv8 == Composer.INSTANCE.getEmpty()) {
                                                value$iv13 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$2$1$1$6$1$1
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
                                                        if (SubtitlePreferenceKt.SubtitlePreference$lambda$3(mutableState25)) {
                                                            SubtitlePreferenceKt.SubtitlePreference$lambda$4(mutableState25, false);
                                                            PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.EMBED_SUBTITLE, false);
                                                        } else {
                                                            SubtitlePreferenceKt.SubtitlePreference$lambda$17(mutableState26, true);
                                                        }
                                                    }
                                                };
                                                $composer6.updateRememberedValue(value$iv13);
                                            } else {
                                                value$iv13 = it$iv8;
                                            }
                                            $composer6.endReplaceGroup();
                                            PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, subtitles, z, zSubtitlePreference$lambda$4, null, (Function0) value$iv13, $composer6, 0, 32);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer6.skipToGroupEnd();
                                    }
                                }), 3, null);
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1694052392, true, new C38417(mutableState11, mutableState10)), 3, null);
                                final State<String> state2 = state;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(469249817, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$2$1$1.8
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer6, int $changed3) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer6, "C213@9118L27:SubtitlePreference.kt#5yb39d");
                                        if (($changed3 & 81) != 16 || !$composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(469249817, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreference.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SubtitlePreference.kt:212)");
                                            }
                                            String strSubtitlePreference$lambda$26 = SubtitlePreferenceKt.SubtitlePreference$lambda$26(state2);
                                            Intrinsics.checkNotNullExpressionValue(strSubtitlePreference$lambda$26, "access$SubtitlePreference$lambda$26(...)");
                                            if (strSubtitlePreference$lambda$26.length() > 0) {
                                                String strSubtitlePreference$lambda$27 = SubtitlePreferenceKt.SubtitlePreference$lambda$26(state2);
                                                Intrinsics.checkNotNullExpressionValue(strSubtitlePreference$lambda$27, "access$SubtitlePreference$lambda$26(...)");
                                                PreferenceItemsKt.PreferenceInfo(null, strSubtitlePreference$lambda$27, null, false, $composer6, 0, 13);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer6.skipToGroupEnd();
                                    }
                                }), 3, null);
                            }

                            /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$2$1$1$7 */
                            /* JADX INFO: compiled from: SubtitlePreference.kt */
                            @Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/LazyItemScope;", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;Landroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                            static final class C38417 extends Lambda implements Function3<LazyItemScope, Composer, Integer, Unit> {
                                final /* synthetic */ MutableState<Boolean> $downloadAudio$delegate;
                                final /* synthetic */ MutableState<Boolean> $embedSubtitle$delegate;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C38417(MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
                                    super(3);
                                    this.$downloadAudio$delegate = mutableState;
                                    this.$embedSubtitle$delegate = mutableState2;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
                                    Function0<ComposeUiNode> function0;
                                    Object value$iv;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer, "C196@8329L679:SubtitlePreference.kt#5yb39d");
                                    if (($changed & 81) != 16 || !$composer.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1694052392, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreference.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SubtitlePreference.kt:196)");
                                        }
                                        MutableState<Boolean> mutableState = this.$downloadAudio$delegate;
                                        MutableState<Boolean> mutableState2 = this.$embedSubtitle$delegate;
                                        ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                        Modifier modifier$iv = Modifier.INSTANCE;
                                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer);
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                        }
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                        int i = ($changed$iv$iv$iv >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                        int i2 = ((0 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer, 1995489997, "C197@8403L12,199@8494L49,203@8757L175,198@8440L546:SubtitlePreference.kt#5yb39d");
                                        $composer.startReplaceGroup(-2044908879);
                                        ComposerKt.sourceInformation($composer, "CC12@469L46:Ext.kt#x6o9ax");
                                        $composer.startReplaceGroup(-204592788);
                                        ComposerKt.sourceInformation($composer, "CC(remember):Ext.kt#9igjgp");
                                        Object value$iv$iv = $composer.rememberedValue();
                                        if (value$iv$iv == Composer.INSTANCE.getEmpty()) {
                                            value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.KEEP_SUBTITLE_FILES, false, 1, null)), null, 2, null);
                                            $composer.updateRememberedValue(value$iv$iv);
                                        }
                                        final MutableState keepSubtitles$delegate = (MutableState) value$iv$iv;
                                        $composer.endReplaceGroup();
                                        $composer.endReplaceGroup();
                                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.keep_subtitle_files, $composer, 0);
                                        boolean zInvoke$lambda$3$lambda$0 = invoke$lambda$3$lambda$0(keepSubtitles$delegate);
                                        boolean z = !SubtitlePreferenceKt.SubtitlePreference$lambda$27(mutableState) && SubtitlePreferenceKt.SubtitlePreference$lambda$3(mutableState2);
                                        ImageVector save = SaveKt.getSave(Icons.Outlined.INSTANCE);
                                        $composer.startReplaceGroup(1995490392);
                                        ComposerKt.sourceInformation($composer, "CC(remember):SubtitlePreference.kt#9igjgp");
                                        boolean invalid$iv = $composer.changed(keepSubtitles$delegate);
                                        Object it$iv = $composer.rememberedValue();
                                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                            value$iv = 
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01fa: CONSTRUCTOR (r8v10 'value$iv' java.lang.Object A[D('$i$a$-cache-SubtitlePreferenceKt$SubtitlePreference$2$1$1$7$1$1' int)]) = 
                                                  (r6v3 'keepSubtitles$delegate' androidx.compose.runtime.MutableState A[D('keepSubtitles$delegate' androidx.compose.runtime.MutableState), DONT_INLINE])
                                                 A[MD:(androidx.compose.runtime.MutableState<java.lang.Boolean>):void (m)] (LINE:198) call: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$2$1$1$7$1$1$1.<init>(androidx.compose.runtime.MutableState):void type: CONSTRUCTOR in method: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$2$1$1.7.invoke(androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, int):void, file: classes5.dex
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
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$2$1$1$7$1$1$1, state: NOT_LOADED
                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                	... 29 more
                                                */
                                            /*
                                                Method dump skipped, instruction units count: 566
                                                To view this dump add '--comments-level debug' option
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.videshkarmakar.loop.p006ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$2$1$1.C38417.invoke(androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, int):void");
                                        }

                                        /* JADX INFO: Access modifiers changed from: private */
                                        public static final boolean invoke$lambda$3$lambda$0(MutableState<Boolean> mutableState) {
                                            MutableState<Boolean> $this$getValue$iv = mutableState;
                                            return $this$getValue$iv.getValue().booleanValue();
                                        }

                                        /* JADX INFO: Access modifiers changed from: private */
                                        public static final void invoke$lambda$3$lambda$1(MutableState<Boolean> mutableState, boolean value) {
                                            mutableState.setValue(Boolean.valueOf(value));
                                        }
                                    }
                                };
                                $composer5.updateRememberedValue(value$iv12);
                            } else {
                                value$iv12 = it$iv7;
                            }
                            $composer5.endReplaceGroup();
                            LazyDslKt.LazyColumn(modifierPadding, null, null, false, null, null, null, false, (Function1) value$iv12, $composer5, 0, 254);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer4, 54), $composer4, 805306416, 508);
                    $composer4.startReplaceGroup(1824414568);
                    ComposerKt.sourceInformation($composer4, "219@9249L50,219@9226L73");
                    if (SubtitlePreference$lambda$10(showLanguageDialog$delegate2)) {
                        $composer4.startReplaceGroup(1824414623);
                        str = "CC(remember):SubtitlePreference.kt#9igjgp";
                        ComposerKt.sourceInformation($composer4, str);
                        Object it$iv7 = $composer4.rememberedValue();
                        if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                            showLanguageDialog$delegate = showLanguageDialog$delegate2;
                            value$iv10 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$3$1
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
                                    SubtitlePreferenceKt.SubtitlePreference$lambda$11(showLanguageDialog$delegate, false);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv10);
                        } else {
                            showLanguageDialog$delegate = showLanguageDialog$delegate2;
                            value$iv10 = it$iv7;
                        }
                        $composer4.endReplaceGroup();
                        FormatSettingDialogsKt.SubtitleLanguageDialog((Function0) value$iv10, $composer4, 6);
                    } else {
                        showLanguageDialog$delegate = showLanguageDialog$delegate2;
                        str = "CC(remember):SubtitlePreference.kt#9igjgp";
                    }
                    $composer4.endReplaceGroup();
                    $composer4.startReplaceGroup(1824414678);
                    ComposerKt.sourceInformation($composer4, "223@9363L52,223@9338L77");
                    if (SubtitlePreference$lambda$13(showConversionDialog$delegate2)) {
                        $composer4.startReplaceGroup(1824414737);
                        ComposerKt.sourceInformation($composer4, str);
                        Object it$iv8 = $composer4.rememberedValue();
                        if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                            showConversionDialog$delegate = showConversionDialog$delegate2;
                            value$iv9 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$4$1
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
                                    SubtitlePreferenceKt.SubtitlePreference$lambda$14(showConversionDialog$delegate, false);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv9);
                        } else {
                            showConversionDialog$delegate = showConversionDialog$delegate2;
                            value$iv9 = it$iv8;
                        }
                        $composer4.endReplaceGroup();
                        FormatSettingDialogsKt.SubtitleConversionDialog((Function0) value$iv9, $composer4, 6);
                    } else {
                        showConversionDialog$delegate = showConversionDialog$delegate2;
                    }
                    $composer4.endReplaceGroup();
                    $composer4.startReplaceGroup(1824414794);
                    ComposerKt.sourceInformation($composer4, "228@9503L35,230@9629L213,236@9860L117,227@9459L821");
                    if (SubtitlePreference$lambda$16(mutableState)) {
                        $composer4.startReplaceGroup(1824414877);
                        ComposerKt.sourceInformation($composer4, str);
                        Object it$iv9 = $composer4.rememberedValue();
                        if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                            showEmbedSubtitleDialog$delegate = mutableState;
                            value$iv8 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$5$1
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
                                    SubtitlePreferenceKt.SubtitlePreference$lambda$17(showEmbedSubtitleDialog$delegate, false);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv8);
                        } else {
                            showEmbedSubtitleDialog$delegate = mutableState;
                            value$iv8 = it$iv9;
                        }
                        $composer4.endReplaceGroup();
                        $composer2 = $composer4;
                        AndroidAlertDialog_androidKt.m1911AlertDialogOix01E0((Function0) value$iv8, ComposableLambdaKt.rememberComposableLambda(-712746804, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt.SubtitlePreference.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed2) {
                                Object value$iv12;
                                ComposerKt.sourceInformation($composer5, "C231@9661L167,231@9647L181:SubtitlePreference.kt#5yb39d");
                                if (($changed2 & 11) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-712746804, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreference.<anonymous> (SubtitlePreference.kt:231)");
                                }
                                $composer5.startReplaceGroup(-2087185828);
                                ComposerKt.sourceInformation($composer5, "CC(remember):SubtitlePreference.kt#9igjgp");
                                boolean invalid$iv4 = $composer5.changed(embedSubtitle$delegate);
                                final MutableState<Boolean> mutableState2 = embedSubtitle$delegate;
                                final MutableState<Boolean> mutableState3 = showEmbedSubtitleDialog$delegate;
                                Object it$iv10 = $composer5.rememberedValue();
                                if (invalid$iv4 || it$iv10 == Composer.INSTANCE.getEmpty()) {
                                    value$iv12 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$6$1$1
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
                                            SubtitlePreferenceKt.SubtitlePreference$lambda$4(mutableState2, true);
                                            PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.EMBED_SUBTITLE, true);
                                            SubtitlePreferenceKt.SubtitlePreference$lambda$17(mutableState3, false);
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv12);
                                } else {
                                    value$iv12 = it$iv10;
                                }
                                $composer5.endReplaceGroup();
                                ButtonsKt.ConfirmButton(null, false, (Function0) value$iv12, $composer5, 0, 3);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), null, ComposableLambdaKt.rememberComposableLambda(1218378830, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt.SubtitlePreference.7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed2) {
                                Object value$iv12;
                                ComposerKt.sourceInformation($composer5, "C237@9892L71,237@9878L85:SubtitlePreference.kt#5yb39d");
                                if (($changed2 & 11) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1218378830, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreference.<anonymous> (SubtitlePreference.kt:237)");
                                }
                                $composer5.startReplaceGroup(-2087185597);
                                ComposerKt.sourceInformation($composer5, "CC(remember):SubtitlePreference.kt#9igjgp");
                                final MutableState<Boolean> mutableState2 = showEmbedSubtitleDialog$delegate;
                                Object it$iv10 = $composer5.rememberedValue();
                                if (it$iv10 == Composer.INSTANCE.getEmpty()) {
                                    value$iv12 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$7$1$1
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
                                            SubtitlePreferenceKt.SubtitlePreference$lambda$17(mutableState2, false);
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv12);
                                } else {
                                    value$iv12 = it$iv10;
                                }
                                $composer5.endReplaceGroup();
                                ButtonsKt.DismissButton(null, (Function0) value$iv12, $composer5, 48, 1);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), ComposableSingletons$SubtitlePreferenceKt.INSTANCE.m7542getLambda2$app_debug(), ComposableSingletons$SubtitlePreferenceKt.INSTANCE.m7543getLambda3$app_debug(), ComposableSingletons$SubtitlePreferenceKt.INSTANCE.m7544getLambda4$app_debug(), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, 1797174, 0, 16260);
                    } else {
                        $composer2 = $composer4;
                    }
                    $composer2.endReplaceGroup();
                    if (SubtitlePreference$lambda$19(subtitleFormatText$delegate)) {
                        Composer $composer5 = $composer2;
                        $composer5.startReplaceGroup(1824415748);
                        ComposerKt.sourceInformation($composer5, str);
                        Object it$iv10 = $composer5.rememberedValue();
                        if (it$iv10 == Composer.INSTANCE.getEmpty()) {
                            showAutoTranslateDialog$delegate = subtitleFormatText$delegate;
                            value$iv7 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$8$1
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
                                    SubtitlePreferenceKt.SubtitlePreference$lambda$20(showAutoTranslateDialog$delegate, false);
                                }
                            };
                            $composer5.updateRememberedValue(value$iv7);
                        } else {
                            showAutoTranslateDialog$delegate = subtitleFormatText$delegate;
                            value$iv7 = it$iv10;
                        }
                        $composer5.endReplaceGroup();
                        $composer3 = $composer5;
                        AndroidAlertDialog_androidKt.m1911AlertDialogOix01E0((Function0) value$iv7, ComposableLambdaKt.rememberComposableLambda(513498987, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt.SubtitlePreference.9
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer6, int $changed2) {
                                Object value$iv12;
                                ComposerKt.sourceInformation($composer6, "C255@10532L187,255@10518L201:SubtitlePreference.kt#5yb39d");
                                if (($changed2 & 11) == 2 && $composer6.getSkipping()) {
                                    $composer6.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(513498987, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreference.<anonymous> (SubtitlePreference.kt:255)");
                                }
                                $composer6.startReplaceGroup(-2087184957);
                                ComposerKt.sourceInformation($composer6, "CC(remember):SubtitlePreference.kt#9igjgp");
                                boolean invalid$iv4 = $composer6.changed(autoTranslatedSubtitle$delegate);
                                final MutableState<Boolean> mutableState2 = autoTranslatedSubtitle$delegate;
                                final MutableState<Boolean> mutableState3 = showAutoTranslateDialog$delegate;
                                Object it$iv11 = $composer6.rememberedValue();
                                if (invalid$iv4 || it$iv11 == Composer.INSTANCE.getEmpty()) {
                                    value$iv12 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$9$1$1
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
                                            SubtitlePreferenceKt.SubtitlePreference$lambda$8(mutableState2, true);
                                            PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.AUTO_TRANSLATED_SUBTITLES, true);
                                            SubtitlePreferenceKt.SubtitlePreference$lambda$20(mutableState3, false);
                                        }
                                    };
                                    $composer6.updateRememberedValue(value$iv12);
                                } else {
                                    value$iv12 = it$iv11;
                                }
                                $composer6.endReplaceGroup();
                                ButtonsKt.ConfirmButton(null, false, (Function0) value$iv12, $composer6, 0, 3);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer5, 54), null, ComposableLambdaKt.rememberComposableLambda(-1850342675, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt.SubtitlePreference.10
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer6, int $changed2) {
                                Object value$iv12;
                                ComposerKt.sourceInformation($composer6, "C261@10783L71,261@10769L85:SubtitlePreference.kt#5yb39d");
                                if (($changed2 & 11) == 2 && $composer6.getSkipping()) {
                                    $composer6.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1850342675, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreference.<anonymous> (SubtitlePreference.kt:261)");
                                }
                                $composer6.startReplaceGroup(-2087184706);
                                ComposerKt.sourceInformation($composer6, "CC(remember):SubtitlePreference.kt#9igjgp");
                                final MutableState<Boolean> mutableState2 = showAutoTranslateDialog$delegate;
                                Object it$iv11 = $composer6.rememberedValue();
                                if (it$iv11 == Composer.INSTANCE.getEmpty()) {
                                    value$iv12 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt$SubtitlePreference$10$1$1
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
                                            SubtitlePreferenceKt.SubtitlePreference$lambda$20(mutableState2, false);
                                        }
                                    };
                                    $composer6.updateRememberedValue(value$iv12);
                                } else {
                                    value$iv12 = it$iv11;
                                }
                                $composer6.endReplaceGroup();
                                ButtonsKt.DismissButton(null, (Function0) value$iv12, $composer6, 48, 1);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer5, 54), ComposableSingletons$SubtitlePreferenceKt.INSTANCE.m7545getLambda5$app_debug(), ComposableSingletons$SubtitlePreferenceKt.INSTANCE.m7546getLambda6$app_debug(), ComposableSingletons$SubtitlePreferenceKt.INSTANCE.m7547getLambda7$app_debug(), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer3, 1797174, 0, 16260);
                    } else {
                        $composer3 = $composer2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.SubtitlePreferenceKt.SubtitlePreference.11
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
                            SubtitlePreferenceKt.SubtitlePreference(onNavigateBack, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                        }
                    });
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean SubtitlePreference$lambda$0(MutableState<Boolean> mutableState) {
                MutableState<Boolean> $this$getValue$iv = mutableState;
                return $this$getValue$iv.getValue().booleanValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void SubtitlePreference$lambda$1(MutableState<Boolean> mutableState, boolean value) {
                mutableState.setValue(Boolean.valueOf(value));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean SubtitlePreference$lambda$2(MutableState<Boolean> mutableState) {
                MutableState<Boolean> $this$getValue$iv = mutableState;
                return $this$getValue$iv.getValue().booleanValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean SubtitlePreference$lambda$3(MutableState<Boolean> mutableState) {
                MutableState<Boolean> $this$getValue$iv = mutableState;
                return $this$getValue$iv.getValue().booleanValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void SubtitlePreference$lambda$4(MutableState<Boolean> mutableState, boolean value) {
                mutableState.setValue(Boolean.valueOf(value));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean SubtitlePreference$lambda$5(MutableState<Boolean> mutableState) {
                MutableState<Boolean> $this$getValue$iv = mutableState;
                return $this$getValue$iv.getValue().booleanValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void SubtitlePreference$lambda$6(MutableState<Boolean> mutableState, boolean value) {
                mutableState.setValue(Boolean.valueOf(value));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean SubtitlePreference$lambda$7(MutableState<Boolean> mutableState) {
                MutableState<Boolean> $this$getValue$iv = mutableState;
                return $this$getValue$iv.getValue().booleanValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void SubtitlePreference$lambda$8(MutableState<Boolean> mutableState, boolean value) {
                mutableState.setValue(Boolean.valueOf(value));
            }

            private static final boolean SubtitlePreference$lambda$10(MutableState<Boolean> mutableState) {
                MutableState<Boolean> $this$getValue$iv = mutableState;
                return $this$getValue$iv.getValue().booleanValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void SubtitlePreference$lambda$11(MutableState<Boolean> mutableState, boolean value) {
                mutableState.setValue(Boolean.valueOf(value));
            }

            private static final boolean SubtitlePreference$lambda$13(MutableState<Boolean> mutableState) {
                MutableState<Boolean> $this$getValue$iv = mutableState;
                return $this$getValue$iv.getValue().booleanValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void SubtitlePreference$lambda$14(MutableState<Boolean> mutableState, boolean value) {
                mutableState.setValue(Boolean.valueOf(value));
            }

            private static final boolean SubtitlePreference$lambda$16(MutableState<Boolean> mutableState) {
                MutableState<Boolean> $this$getValue$iv = mutableState;
                return $this$getValue$iv.getValue().booleanValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void SubtitlePreference$lambda$17(MutableState<Boolean> mutableState, boolean value) {
                mutableState.setValue(Boolean.valueOf(value));
            }

            private static final boolean SubtitlePreference$lambda$19(MutableState<Boolean> mutableState) {
                MutableState<Boolean> $this$getValue$iv = mutableState;
                return $this$getValue$iv.getValue().booleanValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void SubtitlePreference$lambda$20(MutableState<Boolean> mutableState, boolean value) {
                mutableState.setValue(Boolean.valueOf(value));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final String SubtitlePreference$lambda$22(MutableState<String> mutableState) {
                MutableState<String> $this$getValue$iv = mutableState;
                return $this$getValue$iv.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final String SubtitlePreference$lambda$24(MutableState<String> mutableState) {
                MutableState<String> $this$getValue$iv = mutableState;
                return $this$getValue$iv.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final String SubtitlePreference$lambda$26(State<String> state) {
                Object thisObj$iv = state.getValue();
                return (String) thisObj$iv;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean SubtitlePreference$lambda$27(MutableState<Boolean> mutableState) {
                MutableState<Boolean> $this$getValue$iv = mutableState;
                return $this$getValue$iv.getValue().booleanValue();
            }
        }
