package com.videshkarmakar.loop.ui.page.download;

import android.text.TextUtils;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.disk.DiskLruCache;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.ui.component.ButtonsKt;
import com.videshkarmakar.loop.util.Entries;
import com.videshkarmakar.loop.util.PlaylistResult;
import com.videshkarmakar.loop.util.TextUtilKt;
import com.videshkarmakar.loop.util.ToastUtil;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: PlaylistSelectionDialog.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010\r\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u008e\u0002"}, d2 = {"PlaylistSelectionDialog", "", "playlistInfo", "Lcom/videshkarmakar/loop/util/PlaylistResult;", "onDismissRequest", "Lkotlin/Function0;", "onConfirm", "Lkotlin/Function1;", "Lkotlin/ranges/IntRange;", "(Lcom/videshkarmakar/loop/util/PlaylistResult;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_debug", "from", "", "to", "error", ""}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PlaylistSelectionDialogKt {
    public static final void PlaylistSelectionDialog(final PlaylistResult playlistInfo, Function0<Unit> function0, Function1<? super IntRange, Unit> function1, Composer $composer, final int $changed, final int i) {
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        int i2;
        Object value$iv5;
        Intrinsics.checkNotNullParameter(playlistInfo, "playlistInfo");
        Composer $composer2 = $composer.startRestartGroup(-1705618015);
        ComposerKt.sourceInformation($composer2, "C(PlaylistSelectionDialog)P(2,1)40@1594L41,41@1650L53,42@1721L34,43@1781L40,44@1851L328,54@2215L22,122@5150L55,117@5036L88,57@2390L2620,54@2184L3022:PlaylistSelectionDialog.kt#y3famj");
        final Function0<Unit> function2 = (i & 2) != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionDialogKt.PlaylistSelectionDialog.1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        } : function0;
        AnonymousClass2 anonymousClass2 = (i & 4) != 0 ? new Function1<IntRange, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionDialogKt.PlaylistSelectionDialog.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IntRange intRange) {
                invoke2(intRange);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IntRange it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }
        } : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1705618015, $changed, -1, "com.videshkarmakar.loop.ui.page.download.PlaylistSelectionDialog (PlaylistSelectionDialog.kt:38)");
        }
        List<Entries> entries = playlistInfo.getEntries();
        int playlistCount = entries != null ? entries.size() : 0;
        $composer2.startReplaceGroup(1492153051);
        ComposerKt.sourceInformation($composer2, "CC(remember):PlaylistSelectionDialog.kt#9igjgp");
        Object it$iv = $composer2.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DiskLruCache.VERSION, null, 2, null);
            $composer2.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        final MutableState from$delegate = (MutableState) value$iv;
        $composer2.endReplaceGroup();
        $composer2.startReplaceGroup(1492153107);
        ComposerKt.sourceInformation($composer2, "CC(remember):PlaylistSelectionDialog.kt#9igjgp");
        Object it$iv2 = $composer2.rememberedValue();
        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(String.valueOf(playlistCount), null, 2, null);
            $composer2.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        final MutableState to$delegate = (MutableState) value$iv2;
        $composer2.endReplaceGroup();
        $composer2.startReplaceGroup(1492153178);
        ComposerKt.sourceInformation($composer2, "CC(remember):PlaylistSelectionDialog.kt#9igjgp");
        Object it$iv3 = $composer2.rememberedValue();
        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
            value$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            $composer2.updateRememberedValue(value$iv3);
        } else {
            value$iv3 = it$iv3;
        }
        final MutableState error$delegate = (MutableState) value$iv3;
        $composer2.endReplaceGroup();
        $composer2.startReplaceGroup(1492153238);
        ComposerKt.sourceInformation($composer2, "CC(remember):PlaylistSelectionDialog.kt#9igjgp");
        Object it$iv4 = $composer2.rememberedValue();
        if (it$iv4 == Composer.INSTANCE.getEmpty()) {
            value$iv4 = FocusRequester.INSTANCE.createRefs();
            $composer2.updateRememberedValue(value$iv4);
        } else {
            value$iv4 = it$iv4;
        }
        FocusRequester.Companion.FocusRequesterFactory focusRequesterFactory = (FocusRequester.Companion.FocusRequesterFactory) value$iv4;
        $composer2.endReplaceGroup();
        final FocusRequester item1 = focusRequesterFactory.component1();
        final FocusRequester item2 = focusRequesterFactory.component2();
        $composer2.startReplaceGroup(1492153308);
        ComposerKt.sourceInformation($composer2, "CC(remember):PlaylistSelectionDialog.kt#9igjgp");
        boolean invalid$iv = $composer2.changed(playlistCount) | (((($changed & 896) ^ 384) > 256 && $composer2.changed(anonymousClass2)) || ($changed & 384) == 256) | (((($changed & 112) ^ 48) > 32 && $composer2.changed(function2)) || ($changed & 48) == 32);
        Object value$iv6 = $composer2.rememberedValue();
        if (invalid$iv || value$iv6 == Composer.INSTANCE.getEmpty()) {
            final int i3 = playlistCount;
            final Function1<? super IntRange, Unit> function3 = anonymousClass2;
            final Function0<Unit> function4 = function2;
            i2 = 32;
            value$iv6 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionDialogKt$PlaylistSelectionDialog$onDone$1$1
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
                    MutableState<Boolean> mutableState = error$delegate;
                    boolean z = true;
                    if (!((!TextUtilKt.isNumberInRange(PlaylistSelectionDialogKt.PlaylistSelectionDialog$lambda$1(from$delegate), 1, i3)) | (!TextUtilKt.isNumberInRange(PlaylistSelectionDialogKt.PlaylistSelectionDialog$lambda$4(to$delegate), 1, i3))) && Integer.parseInt(PlaylistSelectionDialogKt.PlaylistSelectionDialog$lambda$1(from$delegate)) <= Integer.parseInt(PlaylistSelectionDialogKt.PlaylistSelectionDialog$lambda$4(to$delegate))) {
                        z = false;
                    }
                    PlaylistSelectionDialogKt.PlaylistSelectionDialog$lambda$8(mutableState, z);
                    if (!PlaylistSelectionDialogKt.PlaylistSelectionDialog$lambda$7(error$delegate)) {
                        function3.invoke(new IntRange(Integer.parseInt(PlaylistSelectionDialogKt.PlaylistSelectionDialog$lambda$1(from$delegate)), Integer.parseInt(PlaylistSelectionDialogKt.PlaylistSelectionDialog$lambda$4(to$delegate))));
                        function4.invoke();
                    } else {
                        ToastUtil.INSTANCE.makeToast(R.string.invalid_index_range);
                    }
                }
            };
            $composer2.updateRememberedValue(value$iv6);
        } else {
            i2 = 32;
        }
        final Function0 onDone = (Function0) value$iv6;
        $composer2.endReplaceGroup();
        $composer2.startReplaceGroup(1492153672);
        ComposerKt.sourceInformation($composer2, "CC(remember):PlaylistSelectionDialog.kt#9igjgp");
        boolean invalid$iv2 = ((($changed & 112) ^ 48) > i2 && $composer2.changed(function2)) || ($changed & 48) == i2;
        Object it$iv5 = $composer2.rememberedValue();
        if (invalid$iv2 || it$iv5 == Composer.INSTANCE.getEmpty()) {
            value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionDialogKt$PlaylistSelectionDialog$4$1
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
            $composer2.updateRememberedValue(value$iv5);
        } else {
            value$iv5 = it$iv5;
        }
        $composer2.endReplaceGroup();
        final int i4 = playlistCount;
        final Function1<? super IntRange, Unit> function5 = anonymousClass2;
        AndroidAlertDialog_androidKt.m1663AlertDialogOix01E0((Function0) value$iv5, ComposableLambdaKt.rememberComposableLambda(948007401, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionDialogKt.PlaylistSelectionDialog.5
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
                ComposerKt.sourceInformation($composer3, "C123@5164L31:PlaylistSelectionDialog.kt#y3famj");
                if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                    $composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(948007401, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.PlaylistSelectionDialog.<anonymous> (PlaylistSelectionDialog.kt:123)");
                }
                ButtonsKt.ConfirmButton(null, false, onDone, $composer3, 0, 3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, $composer2, 54), null, ComposableLambdaKt.rememberComposableLambda(1446564203, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionDialogKt.PlaylistSelectionDialog.6
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
                Object value$iv7;
                ComposerKt.sourceInformation($composer3, "C118@5064L50,118@5050L64:PlaylistSelectionDialog.kt#y3famj");
                if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                    $composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1446564203, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.PlaylistSelectionDialog.<anonymous> (PlaylistSelectionDialog.kt:118)");
                }
                $composer3.startReplaceGroup(1896651018);
                ComposerKt.sourceInformation($composer3, "CC(remember):PlaylistSelectionDialog.kt#9igjgp");
                boolean invalid$iv3 = $composer3.changed(function2);
                final Function0<Unit> function6 = function2;
                Object it$iv6 = $composer3.rememberedValue();
                if (invalid$iv3 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                    value$iv7 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionDialogKt$PlaylistSelectionDialog$6$1$1
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
                            function6.invoke();
                        }
                    };
                    $composer3.updateRememberedValue(value$iv7);
                } else {
                    value$iv7 = it$iv6;
                }
                $composer3.endReplaceGroup();
                ButtonsKt.DismissButton(null, (Function0) value$iv7, $composer3, 0, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, $composer2, 54), ComposableSingletons$PlaylistSelectionDialogKt.INSTANCE.m7246getLambda1$app_debug(), ComposableSingletons$PlaylistSelectionDialogKt.INSTANCE.m7247getLambda2$app_debug(), ComposableLambdaKt.rememberComposableLambda(-2100567890, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionDialogKt.PlaylistSelectionDialog.7
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
                Function0<ComposeUiNode> function6;
                Function0<ComposeUiNode> function7;
                Function0<ComposeUiNode> function8;
                Function0<ComposeUiNode> function9;
                Object value$iv7;
                Object value$iv8;
                Object value$iv9;
                ComposerKt.sourceInformation($composer3, "C58@2404L2596:PlaylistSelectionDialog.kt#y3famj");
                if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                    $composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2100567890, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.PlaylistSelectionDialog.<anonymous> (PlaylistSelectionDialog.kt:58)");
                }
                int i5 = i4;
                PlaylistResult playlistResult = playlistInfo;
                final FocusRequester focusRequester = item2;
                final FocusRequester focusRequester2 = item1;
                final MutableState<String> mutableState = from$delegate;
                final MutableState<Boolean> mutableState2 = error$delegate;
                final Function0<Unit> function10 = onDone;
                final MutableState<String> mutableState3 = to$delegate;
                ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                Modifier modifier$iv = Modifier.INSTANCE;
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function6 = constructor;
                    $composer3.createNode(function6);
                } else {
                    function6 = constructor;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i6 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i7 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -2010399264, "C*60@2462L44,59@2429L235,66@2681L2305:PlaylistSelectionDialog.kt#y3famj");
                String str = String.format(StringResources_androidKt.stringResource(R.string.download_range_desc, $composer3, 0), Arrays.copyOf(new Object[]{1, Integer.valueOf(i5), playlistResult.getTitle()}, 3));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                TextKt.m2569Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                Modifier modifier$iv2 = PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(12), 0.0f, 0.0f, 13, null);
                ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                int $changed$iv$iv2 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function7 = constructor2;
                    $composer3.createNode(function7);
                } else {
                    function7 = constructor2;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer3);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                int i9 = ((6 >> 6) & 112) | 6;
                RowScope $this$invoke_u24lambda_u248_u24lambda_u247 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -1243593535, "C67@2749L1056,90@3826L1142:PlaylistSelectionDialog.kt#y3famj");
                Modifier modifier$iv3 = PaddingKt.m624paddingqDBjuR0$default(RowScope.CC.weight$default($this$invoke_u24lambda_u248_u24lambda_u247, Modifier.INSTANCE, 1.0f, false, 2, null), 0.0f, 0.0f, Dp.m6553constructorimpl(6), 0.0f, 11, null);
                ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv3 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function8 = constructor3;
                    $composer3.createNode(function8);
                } else {
                    function8 = constructor3;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer3);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                int i10 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                int i11 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 140272031, "C74@3062L16,77@3217L142,72@2938L845:PlaylistSelectionDialog.kt#y3famj");
                Modifier modifierFocusable$default = FocusableKt.focusable$default(Modifier.INSTANCE, false, null, 3, null);
                $composer3.startReplaceGroup(140272155);
                ComposerKt.sourceInformation($composer3, "CC(remember):PlaylistSelectionDialog.kt#9igjgp");
                boolean invalid$iv3 = $composer3.changed(focusRequester);
                Object value$iv10 = $composer3.rememberedValue();
                if (invalid$iv3 || value$iv10 == Composer.INSTANCE.getEmpty()) {
                    value$iv10 = (Function1) new Function1<FocusProperties, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionDialogKt$PlaylistSelectionDialog$7$1$1$1$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(FocusProperties focusProperties) {
                            invoke2(focusProperties);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(FocusProperties focusProperties) {
                            Intrinsics.checkNotNullParameter(focusProperties, "$this$focusProperties");
                            focusProperties.setNext(focusRequester);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv10);
                }
                $composer3.endReplaceGroup();
                Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(FocusPropertiesKt.focusProperties(modifierFocusable$default, (Function1) value$iv10), focusRequester2);
                String strPlaylistSelectionDialog$lambda$1 = PlaylistSelectionDialogKt.PlaylistSelectionDialog$lambda$1(mutableState);
                KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6187getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                boolean zPlaylistSelectionDialog$lambda$7 = PlaylistSelectionDialogKt.PlaylistSelectionDialog$lambda$7(mutableState2);
                $composer3.startReplaceGroup(140272310);
                ComposerKt.sourceInformation($composer3, "CC(remember):PlaylistSelectionDialog.kt#9igjgp");
                Object value$iv11 = $composer3.rememberedValue();
                if (value$iv11 == Composer.INSTANCE.getEmpty()) {
                    value$iv11 = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionDialogKt$PlaylistSelectionDialog$7$1$1$1$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                            invoke2(str2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            String $this$isDigitsOnly$iv = it;
                            if (TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                mutableState.setValue(it);
                            }
                            PlaylistSelectionDialogKt.PlaylistSelectionDialog$lambda$8(mutableState2, false);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv11);
                }
                $composer3.endReplaceGroup();
                OutlinedTextFieldKt.OutlinedTextField(strPlaylistSelectionDialog$lambda$1, (Function1<? super String, Unit>) value$iv11, modifierFocusRequester, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$PlaylistSelectionDialogKt.INSTANCE.m7248getLambda3$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, zPlaylistSelectionDialog$lambda$7, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer3, 1572912, 12779520, 0, 8216504);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv4 = PaddingKt.m624paddingqDBjuR0$default(RowScope.CC.weight$default($this$invoke_u24lambda_u248_u24lambda_u247, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m6553constructorimpl(6), 0.0f, 0.0f, 0.0f, 14, null);
                ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv3 = Alignment.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv4 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function9 = constructor4;
                    $composer3.createNode(function9);
                } else {
                    function9 = constructor4;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3547constructorimpl($composer3);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv4.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                    $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                    $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash4);
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                int i12 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                int i13 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 140273110, "C97@4141L20,109@4815L12,100@4298L140,95@4017L929:PlaylistSelectionDialog.kt#y3famj");
                Modifier modifierFocusable$default2 = FocusableKt.focusable$default(Modifier.INSTANCE, false, null, 3, null);
                $composer3.startReplaceGroup(140273234);
                ComposerKt.sourceInformation($composer3, "CC(remember):PlaylistSelectionDialog.kt#9igjgp");
                boolean invalid$iv4 = $composer3.changed(focusRequester2);
                Object it$iv6 = $composer3.rememberedValue();
                if (invalid$iv4 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                    value$iv7 = (Function1) new Function1<FocusProperties, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionDialogKt$PlaylistSelectionDialog$7$1$1$2$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(FocusProperties focusProperties) {
                            invoke2(focusProperties);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(FocusProperties focusProperties) {
                            Intrinsics.checkNotNullParameter(focusProperties, "$this$focusProperties");
                            focusProperties.setPrevious(focusRequester2);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv7);
                } else {
                    value$iv7 = it$iv6;
                }
                $composer3.endReplaceGroup();
                Modifier modifierFocusRequester2 = FocusRequesterModifierKt.focusRequester(FocusPropertiesKt.focusProperties(modifierFocusable$default2, (Function1) value$iv7), focusRequester);
                String strPlaylistSelectionDialog$lambda$4 = PlaylistSelectionDialogKt.PlaylistSelectionDialog$lambda$4(mutableState3);
                KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6185getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                $composer3.startReplaceGroup(140273908);
                ComposerKt.sourceInformation($composer3, "CC(remember):PlaylistSelectionDialog.kt#9igjgp");
                boolean invalid$iv5 = $composer3.changed(function10);
                Object it$iv7 = $composer3.rememberedValue();
                if (invalid$iv5 || it$iv7 == Composer.INSTANCE.getEmpty()) {
                    value$iv8 = new Function1<KeyboardActionScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionDialogKt$PlaylistSelectionDialog$7$1$1$2$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                            invoke2(keyboardActionScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(KeyboardActionScope $receiver) {
                            Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                            function10.invoke();
                        }
                    };
                    $composer3.updateRememberedValue(value$iv8);
                } else {
                    value$iv8 = it$iv7;
                }
                $composer3.endReplaceGroup();
                KeyboardActions keyboardActions = new KeyboardActions((Function1) value$iv8, null, null, null, null, null, 62, null);
                boolean zPlaylistSelectionDialog$lambda$8 = PlaylistSelectionDialogKt.PlaylistSelectionDialog$lambda$7(mutableState2);
                $composer3.startReplaceGroup(140273391);
                ComposerKt.sourceInformation($composer3, "CC(remember):PlaylistSelectionDialog.kt#9igjgp");
                Object it$iv8 = $composer3.rememberedValue();
                if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                    value$iv9 = new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionDialogKt$PlaylistSelectionDialog$7$1$1$2$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                            invoke2(str2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            String $this$isDigitsOnly$iv = it;
                            if (TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                mutableState3.setValue(it);
                            }
                            PlaylistSelectionDialogKt.PlaylistSelectionDialog$lambda$8(mutableState2, false);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv9);
                } else {
                    value$iv9 = it$iv8;
                }
                $composer3.endReplaceGroup();
                OutlinedTextFieldKt.OutlinedTextField(strPlaylistSelectionDialog$lambda$4, (Function1<? super String, Unit>) value$iv9, modifierFocusRequester2, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$PlaylistSelectionDialogKt.INSTANCE.m7249getLambda4$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, zPlaylistSelectionDialog$lambda$8, (VisualTransformation) null, keyboardOptions2, keyboardActions, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer3, 1572912, 12779520, 0, 8150968);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, 1797168, 0, 16260);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.PlaylistSelectionDialogKt.PlaylistSelectionDialog.8
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

                public final void invoke(Composer composer, int i5) {
                    PlaylistSelectionDialogKt.PlaylistSelectionDialog(playlistInfo, function2, function5, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String PlaylistSelectionDialog$lambda$1(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String PlaylistSelectionDialog$lambda$4(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PlaylistSelectionDialog$lambda$7(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PlaylistSelectionDialog$lambda$8(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }
}
