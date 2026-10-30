package com.videshkarmakar.loop.p006ui.page.download;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CaretScope;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TooltipDefaults;
import androidx.compose.material3.TooltipKt;
import androidx.compose.material3.TooltipState;
import androidx.compose.material3.Tooltip_androidKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.TextUnitKt;
import androidx.compose.p001ui.window.PopupPositionProvider;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.Downloader;
import com.videshkarmakar.loop.p006ui.component.DownloadQueueItemKt;
import com.videshkarmakar.loop.util.Entries;
import com.videshkarmakar.loop.util.PlaylistResult;
import com.videshkarmakar.loop.util.Thumbnail;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: PlaylistSelectionPage.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(m194d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u008a\u0084\u0002²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u008e\u0002"}, m195d2 = {"PlaylistSelectionPage", "", "onNavigateBack", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_debug", "playlistInfo", "Lcom/videshkarmakar/loop/util/PlaylistResult;", "showDialog", ""}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PlaylistSelectionPageKt {
    public static final void PlaylistSelectionPage(Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        final Function0<Unit> function1;
        Object value$iv;
        Object value$iv2;
        Composer $composer2;
        Object value$iv3;
        Composer $composer3 = $composer.startRestartGroup(-224683063);
        ComposerKt.sourceInformation($composer3, "C(PlaylistSelectionPage)55@2565L32,58@2648L29,59@2702L310,71@3056L22,72@3101L34,80@3370L1455,110@4847L2190,156@7039L1738,77@3239L5538,197@8892L22,196@8808L227:PlaylistSelectionPage.kt#y3famj");
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
        int $dirty2 = $dirty;
        if (($dirty2 & 11) != 2 || !$composer3.getSkipping()) {
            final Function0<Unit> function2 = i2 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt.PlaylistSelectionPage.1
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
                ComposerKt.traceEventStart(-224683063, $dirty2, -1, "com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPage (PlaylistSelectionPage.kt:54)");
            }
            $composer3.startReplaceGroup(-2030051201);
            ComposerKt.sourceInformation($composer3, "CC(remember):PlaylistSelectionPage.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 14) == 4;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt$PlaylistSelectionPage$onDismissRequest$1$1
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
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final Function0 onDismissRequest = (Function0) value$iv;
            $composer3.endReplaceGroup();
            Function0<Unit> function3 = function2;
            final State playlistInfo$delegate = FlowExtKt.collectAsStateWithLifecycle(Downloader.INSTANCE.getPlaylistResult(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer3, 8, 7);
            final List selectedItems = (List) RememberSaveableKt.m3889rememberSaveable(new Object[0], ListSaverKt.listSaver(new Function2<SaverScope, List<Integer>, List<? extends Integer>>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt$PlaylistSelectionPage$selectedItems$1
                @Override // kotlin.jvm.functions.Function2
                public final List<Integer> invoke(SaverScope listSaver, List<Integer> it) {
                    Intrinsics.checkNotNullParameter(listSaver, "$this$listSaver");
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (!it.isEmpty()) {
                        return CollectionsKt.toList(it);
                    }
                    return CollectionsKt.emptyList();
                }
            }, new Function1<List<? extends Integer>, List<Integer>>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt$PlaylistSelectionPage$selectedItems$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ List<Integer> invoke(List<? extends Integer> list) {
                    return invoke2((List<Integer>) list);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final List<Integer> invoke2(List<Integer> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return SnapshotStateKt.toMutableStateList(it);
                }
            }), (String) null, (Function0) new Function0<List<Integer>>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt$PlaylistSelectionPage$selectedItems$3
                @Override // kotlin.jvm.functions.Function0
                public final List<Integer> invoke() {
                    return SnapshotStateKt.mutableStateListOf();
                }
            }, $composer3, 3144, 4);
            final TopAppBarScrollBehavior scrollBehavior = TopAppBarDefaults.INSTANCE.pinnedScrollBehavior(null, null, $composer3, TopAppBarDefaults.$stable << 6, 3);
            $composer3.startReplaceGroup(-2030050665);
            ComposerKt.sourceInformation($composer3, "CC(remember):PlaylistSelectionPage.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableState showDialog$delegate = (MutableState) value$iv2;
            $composer3.endReplaceGroup();
            List<Entries> entries = PlaylistSelectionPage$lambda$1(playlistInfo$delegate).getEntries();
            final int playlistCount = entries != null ? entries.size() : 0;
            ScaffoldKt.m2530ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollBehavior.getNestedScrollConnection(), null, 2, null), ComposableLambdaKt.rememberComposableLambda(1212929933, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt.PlaylistSelectionPage.2
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
                    ComposerKt.sourceInformation($composer4, "C81@3402L376,88@3797L175,92@3984L784,81@3384L1431:PlaylistSelectionPage.kt#y3famj");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1212929933, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPage.<anonymous> (PlaylistSelectionPage.kt:81)");
                        }
                        final List<Integer> list = selectedItems;
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-185467319, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt.PlaylistSelectionPage.2.1
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
                                String str;
                                ComposerKt.sourceInformation($composer5, "C86@3701L10,82@3420L344:PlaylistSelectionPage.kt#y3famj");
                                if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-185467319, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPage.<anonymous>.<anonymous> (PlaylistSelectionPage.kt:82)");
                                    }
                                    if (list.isEmpty()) {
                                        $composer5.startReplaceGroup(364998870);
                                        ComposerKt.sourceInformation($composer5, "83@3482L47");
                                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.download_playlist, $composer5, 0);
                                        $composer5.endReplaceGroup();
                                        str = strStringResource;
                                    } else {
                                        $composer5.startReplaceGroup(364999019);
                                        ComposerKt.sourceInformation($composer5, "*83@3535L95");
                                        String str2 = String.format(StringResources_androidKt.stringResource(C3070R.string.selected_item_count, $composer5, 0), Arrays.copyOf(new Object[]{Integer.valueOf(list.size())}, 1));
                                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                                        $composer5.endReplaceGroup();
                                        str = str2;
                                    }
                                    TextStyle titleMedium = MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getTitleMedium();
                                    TextKt.m2817Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, titleMedium.m6277copyp1EtxEg((16777213 & 1) != 0 ? titleMedium.spanStyle.m6199getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? titleMedium.spanStyle.getFontSize() : TextUnitKt.getSp(18), (16777213 & 4) != 0 ? titleMedium.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? titleMedium.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? titleMedium.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? titleMedium.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? titleMedium.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? titleMedium.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? titleMedium.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? titleMedium.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? titleMedium.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? titleMedium.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? titleMedium.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? titleMedium.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? titleMedium.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? titleMedium.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? titleMedium.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? titleMedium.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? titleMedium.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? titleMedium.platformStyle : null, (16777213 & 1048576) != 0 ? titleMedium.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? titleMedium.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? titleMedium.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? titleMedium.paragraphStyle.getTextMotion() : null), $composer5, 0, 0, 65534);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54);
                        final Function0<Unit> function4 = onDismissRequest;
                        ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1016120953, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt.PlaylistSelectionPage.2.2
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
                                Object value$iv4;
                                ComposerKt.sourceInformation($composer5, "C89@3836L22,89@3815L143:PlaylistSelectionPage.kt#y3famj");
                                if (($changed3 & 11) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1016120953, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPage.<anonymous>.<anonymous> (PlaylistSelectionPage.kt:89)");
                                }
                                $composer5.startReplaceGroup(364999224);
                                ComposerKt.sourceInformation($composer5, "CC(remember):PlaylistSelectionPage.kt#9igjgp");
                                boolean invalid$iv2 = $composer5.changed(function4);
                                final Function0<Unit> function5 = function4;
                                Object it$iv3 = $composer5.rememberedValue();
                                if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                    value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt$PlaylistSelectionPage$2$2$1$1
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
                                            function5.invoke();
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv4);
                                } else {
                                    value$iv4 = it$iv3;
                                }
                                $composer5.endReplaceGroup();
                                IconButtonKt.IconButton((Function0) value$iv4, null, false, null, null, ComposableSingletons$PlaylistSelectionPageKt.INSTANCE.m7386getLambda1$app_debug(), $composer5, ProfileVerifier.CompilationStatus.f245xf2722a21, 30);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54);
                        final List<Integer> list2 = selectedItems;
                        final Function0<Unit> function5 = onDismissRequest;
                        final State<PlaylistResult> state = playlistInfo$delegate;
                        AppBarKt.m1923TopAppBarGHTll3U(composableLambdaRememberComposableLambda, null, composableLambdaRememberComposableLambda2, ComposableLambdaKt.rememberComposableLambda(-2114392962, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt.PlaylistSelectionPage.2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                                invoke(rowScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope TopAppBar, Composer $composer5, int $changed3) {
                                Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
                                ComposerKt.sourceInformation($composer5, "C93@4002L752:PlaylistSelectionPage.kt#y3famj");
                                if (($changed3 & 81) == 16 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2114392962, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPage.<anonymous>.<anonymous> (PlaylistSelectionPage.kt:93)");
                                }
                                Modifier modifierM872paddingqDBjuR0$default = PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(8), 0.0f, 11, null);
                                boolean z = !list2.isEmpty();
                                final List<Integer> list3 = list2;
                                final Function0<Unit> function6 = function5;
                                final State<PlaylistResult> state2 = state;
                                ButtonKt.TextButton(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt.PlaylistSelectionPage.2.3.1
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
                                        List listEmptyList;
                                        Downloader downloader = Downloader.INSTANCE;
                                        String originalUrl = PlaylistSelectionPageKt.PlaylistSelectionPage$lambda$1(state2).getOriginalUrl();
                                        if (originalUrl == null) {
                                            originalUrl = String.valueOf(PlaylistSelectionPageKt.PlaylistSelectionPage$lambda$1(state2).getWebpageUrl());
                                        }
                                        List<Integer> list4 = list3;
                                        Iterable entries2 = PlaylistSelectionPageKt.PlaylistSelectionPage$lambda$1(state2).getEntries();
                                        if (entries2 != null) {
                                            Iterable $this$filterIndexed$iv = entries2;
                                            List<Integer> list5 = list3;
                                            int $i$f$filterIndexed = 0;
                                            Collection destination$iv$iv = new ArrayList();
                                            int index$iv$iv = 0;
                                            for (Object item$iv$iv$iv : $this$filterIndexed$iv) {
                                                int index$iv$iv$iv = index$iv$iv + 1;
                                                if (index$iv$iv < 0) {
                                                    CollectionsKt.throwIndexOverflow();
                                                }
                                                Iterable $this$filterIndexed$iv2 = $this$filterIndexed$iv;
                                                int index = index$iv$iv;
                                                int $i$f$filterIndexed2 = $i$f$filterIndexed;
                                                if (list5.contains(Integer.valueOf(index))) {
                                                    destination$iv$iv.add(item$iv$iv$iv);
                                                }
                                                index$iv$iv = index$iv$iv$iv;
                                                $this$filterIndexed$iv = $this$filterIndexed$iv2;
                                                $i$f$filterIndexed = $i$f$filterIndexed2;
                                            }
                                            listEmptyList = (List) destination$iv$iv;
                                        } else {
                                            listEmptyList = CollectionsKt.emptyList();
                                        }
                                        Downloader.downloadVideoInPlaylistByIndexList$default(downloader, originalUrl, list4, listEmptyList, null, 8, null);
                                        function6.invoke();
                                    }
                                }, modifierM872paddingqDBjuR0$default, z, null, null, null, null, null, null, ComposableSingletons$PlaylistSelectionPageKt.INSTANCE.m7387getLambda2$app_debug(), $composer5, 805306416, 504);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), 0.0f, null, null, scrollBehavior, $composer4, 3462, 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(940493646, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt.PlaylistSelectionPage.3
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
                    Function0<ComposeUiNode> function4;
                    Function0<ComposeUiNode> function5;
                    Object value$iv4;
                    Function0<ComposeUiNode> function6;
                    Object value$iv5;
                    ComposerKt.sourceInformation($composer4, "C111@4861L2165:PlaylistSelectionPage.kt#y3famj");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(940493646, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPage.<anonymous> (PlaylistSelectionPage.kt:111)");
                        }
                        Modifier modifier$iv = WindowInsetsPadding_androidKt.navigationBarsPadding(PaddingKt.m872paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(4), 7, null));
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
                        final List<Integer> list = selectedItems;
                        final int i3 = playlistCount;
                        final MutableState<Boolean> mutableState = showDialog$delegate;
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                        int $changed$iv$iv = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function4 = constructor;
                            $composer4.createNode(function4);
                        } else {
                            function4 = constructor;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i4 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i5 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 365000508, "C118@5120L43,119@5180L1832:PlaylistSelectionPage.kt#y3famj");
                        DividerKt.m2222Divider9IZ8Weo(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0L, $composer4, 6, 6);
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Modifier modifier$iv2 = Modifier.INSTANCE;
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        int $i$f$Column = ((384 >> 3) & 14) | ((384 >> 3) & 112);
                        MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, $i$f$Column);
                        int $changed$iv$iv2 = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function5 = constructor2;
                            $composer4.createNode(function5);
                        } else {
                            function5 = constructor2;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer4);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        int i7 = ((384 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u244_u24lambda_u243 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, -948863005, "C123@5484L99,120@5254L1241,143@6516L38,145@6661L21,144@6575L419:PlaylistSelectionPage.kt#y3famj");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        boolean z = list.size() == i3 && list.size() != 0;
                        $composer4.startReplaceGroup(-948862775);
                        ComposerKt.sourceInformation($composer4, "CC(remember):PlaylistSelectionPage.kt#9igjgp");
                        Object it$iv3 = $composer4.rememberedValue();
                        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv4 = InteractionSourceKt.MutableInteractionSource();
                            $composer4.updateRememberedValue(value$iv4);
                        } else {
                            value$iv4 = it$iv3;
                        }
                        $composer4.endReplaceGroup();
                        Modifier modifier$iv3 = SelectableKt.m1115selectableO2vRcR0$default(companion, z, (MutableInteractionSource) value$iv4, null, false, null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt$PlaylistSelectionPage$3$1$1$2
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
                                if (list.size() != i3) {
                                    list.clear();
                                    CollectionsKt.addAll(list, new IntRange(1, i3));
                                } else {
                                    list.clear();
                                }
                            }
                        }, 24, null);
                        Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv3 = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function6 = constructor3;
                            $composer4.createNode(function6);
                        } else {
                            function6 = constructor3;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer4);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                        int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i9 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1211720067, "C133@6021L252,139@6339L35,140@6426L10,138@6298L175:PlaylistSelectionPage.kt#y3famj");
                        CheckboxKt.Checkbox(list.size() == i3 && list.size() != 0, null, PaddingKt.m868padding3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(16)), false, null, null, $composer4, 432, 56);
                        TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.select_all, $composer4, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelLarge(), $composer4, 0, 0, 65534);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        SpacerKt.Spacer(RowScope.CC.weight$default($this$invoke_u24lambda_u244_u24lambda_u243, Modifier.INSTANCE, 1.0f, false, 2, null), $composer4, 0);
                        Modifier modifierM872paddingqDBjuR0$default = PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(4), 0.0f, 11, null);
                        $composer4.startReplaceGroup(-948861598);
                        ComposerKt.sourceInformation($composer4, "CC(remember):PlaylistSelectionPage.kt#9igjgp");
                        Object it$iv4 = $composer4.rememberedValue();
                        if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                            value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt$PlaylistSelectionPage$3$1$1$4$1
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
                                    PlaylistSelectionPageKt.PlaylistSelectionPage$lambda$4(mutableState, true);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv5);
                        } else {
                            value$iv5 = it$iv4;
                        }
                        $composer4.endReplaceGroup();
                        IconButtonKt.IconButton((Function0) value$iv5, modifierM872paddingqDBjuR0$default, false, null, null, ComposableSingletons$PlaylistSelectionPageKt.INSTANCE.m7388getLambda3$app_debug(), $composer4, 196662, 28);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-2018925160, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt.PlaylistSelectionPage.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
                    invoke(paddingValues, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues paddings, Composer $composer4, int $changed2) {
                    Function0<ComposeUiNode> function4;
                    Intrinsics.checkNotNullParameter(paddings, "paddings");
                    ComposerKt.sourceInformation($composer4, "C157@7061L1710:PlaylistSelectionPage.kt#y3famj");
                    int $dirty3 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty3 |= $composer4.changed(paddings) ? 4 : 2;
                    }
                    if (($dirty3 & 91) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2018925160, $dirty3, -1, "com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPage.<anonymous> (PlaylistSelectionPage.kt:157)");
                        }
                        Modifier modifier$iv = PaddingKt.padding(Modifier.INSTANCE, paddings);
                        final State<PlaylistResult> state = playlistInfo$delegate;
                        final List<Integer> list = selectedItems;
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function4 = constructor;
                            $composer4.createNode(function4);
                        } else {
                            function4 = constructor;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i3 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i4 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 365002531, "C160@7143L1618:PlaylistSelectionPage.kt#y3famj");
                        LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt$PlaylistSelectionPage$4$1$1
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
                                final State<PlaylistResult> state2 = state;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1406919986, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt$PlaylistSelectionPage$4$1$1.1
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
                                        ComposerKt.sourceInformation($composer5, "C*164@7296L48,165@7419L10,162@7199L262:PlaylistSelectionPage.kt#y3famj");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1406919986, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PlaylistSelectionPage.kt:162)");
                                            }
                                            Modifier modifierM868padding3ABfNKs = PaddingKt.m868padding3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(16));
                                            String str = String.format(StringResources_androidKt.stringResource(C3070R.string.download_selection_desc, $composer5, 0), Arrays.copyOf(new Object[]{PlaylistSelectionPageKt.PlaylistSelectionPage$lambda$1(state2).getTitle()}, 1));
                                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                                            TextKt.m2817Text4IGK_g(str, modifierM868padding3ABfNKs, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getBodySmall(), $composer5, 48, 0, 65532);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 3, null);
                                final List<Entries> entries2 = PlaylistSelectionPageKt.PlaylistSelectionPage$lambda$1(state).getEntries();
                                if (entries2 == null) {
                                    entries2 = CollectionsKt.emptyList();
                                }
                                final List<Integer> list2 = list;
                                final State<PlaylistResult> state3 = state;
                                LazyColumn.items(entries2.size(), null, new Function1<Integer, Object>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt$PlaylistSelectionPage$4$1$1$invoke$$inlined$itemsIndexed$default$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                        return invoke(num.intValue());
                                    }

                                    public final Object invoke(int index) {
                                        entries2.get(index);
                                        return null;
                                    }
                                }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt$PlaylistSelectionPage$4$1$1$invoke$$inlined$itemsIndexed$default$3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope $this$items, int it, Composer $composer5, int $changed3) {
                                        ComposerKt.sourceInformation($composer5, "C188@8866L26:LazyDsl.kt#428nma");
                                        int $dirty4 = $changed3;
                                        if (($changed3 & 6) == 0) {
                                            $dirty4 |= $composer5.changed($this$items) ? 4 : 2;
                                        }
                                        if (($changed3 & 48) == 0) {
                                            $dirty4 |= $composer5.changed(it) ? 32 : 16;
                                        }
                                        if (($dirty4 & 147) == 146 && $composer5.getSkipping()) {
                                            $composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1091073711, $dirty4, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:188)");
                                        }
                                        int i5 = ($dirty4 & 14) | ($dirty4 & 112);
                                        final Entries entry = (Entries) entries2.get(it);
                                        $composer5.startReplaceGroup(1211721640);
                                        ComposerKt.sourceInformation($composer5, "C*171@7656L22,172@7739L38,173@7813L177,177@7992L736,171@7637L1091:PlaylistSelectionPage.kt#y3famj");
                                        final int index = it + 1;
                                        TooltipState tooltipStateRememberTooltipState = TooltipKt.rememberTooltipState(false, false, null, $composer5, 0, 7);
                                        PopupPositionProvider popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc = TooltipDefaults.INSTANCE.m2957rememberPlainTooltipPositionProviderkHDZbjc(0.0f, $composer5, TooltipDefaults.$stable << 3, 1);
                                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1313367553, true, new Function3<CaretScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt$PlaylistSelectionPage$4$1$1$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(CaretScope caretScope, Composer composer, Integer num) {
                                                invoke(caretScope, composer, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(CaretScope TooltipBox, Composer $composer6, int $changed4) {
                                                Intrinsics.checkNotNullParameter(TooltipBox, "$this$TooltipBox");
                                                ComposerKt.sourceInformation($composer6, "C174@7856L108,174@7843L121:PlaylistSelectionPage.kt#y3famj");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1313367553, $changed4, -1, "com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPage.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PlaylistSelectionPage.kt:174)");
                                                }
                                                final Entries entries3 = entry;
                                                final int i6 = index;
                                                Tooltip_androidKt.m2960PlainTooltipFg7CxbU(TooltipBox, null, null, null, 0L, 0L, 0.0f, 0.0f, ComposableLambdaKt.rememberComposableLambda(-2091432270, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt$PlaylistSelectionPage$4$1$1$2$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                        invoke(composer, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer $composer7, int $changed5) {
                                                        ComposerKt.sourceInformation($composer7, "C175@7890L44:PlaylistSelectionPage.kt#y3famj");
                                                        if (($changed5 & 11) == 2 && $composer7.getSkipping()) {
                                                            $composer7.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-2091432270, $changed5, -1, "com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPage.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PlaylistSelectionPage.kt:175)");
                                                        }
                                                        String title = entries3.getTitle();
                                                        if (title == null) {
                                                            title = String.valueOf(i6);
                                                        }
                                                        TextKt.m2817Text4IGK_g(title, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer7, 0, 0, 131070);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, $composer6, 54), $composer6, 100663304, 127);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, $composer5, 54);
                                        final List list3 = list2;
                                        final State state4 = state3;
                                        TooltipKt.TooltipBox(popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc, composableLambdaRememberComposableLambda, tooltipStateRememberTooltipState, null, false, false, ComposableLambdaKt.rememberComposableLambda(828145381, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt$PlaylistSelectionPage$4$1$1$2$2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                invoke(composer, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer $composer6, int $changed4) {
                                                String url;
                                                String uploader;
                                                Thumbnail thumbnail;
                                                ComposerKt.sourceInformation($composer6, "C178@8018L688:PlaylistSelectionPage.kt#y3famj");
                                                if (($changed4 & 11) != 2 || !$composer6.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(828145381, $changed4, -1, "com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPage.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PlaylistSelectionPage.kt:178)");
                                                    }
                                                    Modifier modifierM870paddingVpY3zN4$default = PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(12), 0.0f, 2, null);
                                                    List<Thumbnail> thumbnails = entry.getThumbnails();
                                                    if (thumbnails == null || (thumbnail = (Thumbnail) CollectionsKt.lastOrNull((List) thumbnails)) == null || (url = thumbnail.getUrl()) == null) {
                                                        url = "";
                                                    }
                                                    String str = url;
                                                    String title = entry.getTitle();
                                                    if (title == null) {
                                                        title = String.valueOf(index);
                                                    }
                                                    String str2 = title;
                                                    String channel = entry.getChannel();
                                                    if (channel == null && (channel = entry.getUploader()) == null && (channel = PlaylistSelectionPageKt.PlaylistSelectionPage$lambda$1(state4).getChannel()) == null) {
                                                        uploader = PlaylistSelectionPageKt.PlaylistSelectionPage$lambda$1(state4).getUploader();
                                                    } else {
                                                        uploader = channel;
                                                    }
                                                    boolean zContains = list3.contains(Integer.valueOf(index));
                                                    final List<Integer> list4 = list3;
                                                    final int i6 = index;
                                                    DownloadQueueItemKt.PlaylistItem(modifierM870paddingVpY3zN4$default, zContains, str, str2, uploader, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt$PlaylistSelectionPage$4$1$1$2$2.1
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
                                                            if (!list4.contains(Integer.valueOf(i6))) {
                                                                list4.add(Integer.valueOf(i6));
                                                            } else {
                                                                list4.remove(Integer.valueOf(i6));
                                                            }
                                                        }
                                                    }, $composer6, 6, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer6.skipToGroupEnd();
                                            }
                                        }, $composer5, 54), $composer5, 1572912, 56);
                                        $composer5.endReplaceGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                            }
                        }, $composer4, 0, 255);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer3, 805306800, 504);
            if (PlaylistSelectionPage$lambda$3(showDialog$delegate)) {
                PlaylistResult playlistResultPlaylistSelectionPage$lambda$1 = PlaylistSelectionPage$lambda$1(playlistInfo$delegate);
                $composer2 = $composer3;
                $composer2.startReplaceGroup(-2030044874);
                ComposerKt.sourceInformation($composer2, "CC(remember):PlaylistSelectionPage.kt#9igjgp");
                Object it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt$PlaylistSelectionPage$5$1
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
                            PlaylistSelectionPageKt.PlaylistSelectionPage$lambda$4(showDialog$delegate, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv3;
                }
                $composer2.endReplaceGroup();
                PlaylistSelectionDialogKt.PlaylistSelectionDialog(playlistResultPlaylistSelectionPage$lambda$1, (Function0) value$iv3, new Function1<IntRange, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt.PlaylistSelectionPage.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(IntRange intRange) {
                        invoke2(intRange);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(IntRange it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        selectedItems.clear();
                        CollectionsKt.addAll(selectedItems, it);
                    }
                }, $composer2, 56, 0);
            } else {
                $composer2 = $composer3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function1 = function3;
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionPageKt.PlaylistSelectionPage.7
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
                    PlaylistSelectionPageKt.PlaylistSelectionPage(function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlaylistResult PlaylistSelectionPage$lambda$1(State<PlaylistResult> state) {
        Object thisObj$iv = state.getValue();
        return (PlaylistResult) thisObj$iv;
    }

    private static final boolean PlaylistSelectionPage$lambda$3(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PlaylistSelectionPage$lambda$4(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }
}
