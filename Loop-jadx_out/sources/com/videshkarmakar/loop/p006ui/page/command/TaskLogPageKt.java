package com.videshkarmakar.loop.p006ui.page.command;

import android.util.Log;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.text.selection.SelectionContainerKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CancelKt;
import androidx.compose.material.icons.outlined.ContentCopyKt;
import androidx.compose.material.icons.outlined.ErrorOutlineKt;
import androidx.compose.material.icons.outlined.RestartAltKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ChipColors;
import androidx.compose.material3.ChipElevation;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.graphics.vector.ImageVector;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.ClipboardManager;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.Downloader;
import com.videshkarmakar.loop.p006ui.component.ChipsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TaskLogPage.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m194d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\u001a#\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u008e\u0002"}, m195d2 = {"TAG", "", TaskLogPageKt.TAG, "", "onNavigateBack", "Lkotlin/Function0;", "taskHashCode", "", "(Lkotlin/jvm/functions/Function0;ILandroidx/compose/runtime/Composer;I)V", "app_debug", "expandLog", ""}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TaskLogPageKt {
    private static final String TAG = "TaskLogPage";

    public static final void TaskLogPage(final Function0<Unit> onNavigateBack, final int taskHashCode, Composer $composer, final int $changed) {
        Object next;
        Object value$iv;
        Composer $composer2;
        Downloader.CustomCommandTask it;
        Intrinsics.checkNotNullParameter(onNavigateBack, "onNavigateBack");
        Composer $composer3 = $composer.startRestartGroup(426819773);
        ComposerKt.sourceInformation($composer3, "C(TaskLogPage)58@2620L22,60@2790L7,61@2819L34,65@2989L509,78@3512L3277,146@6791L926,62@2858L4859:TaskLogPage.kt#klscgo");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onNavigateBack) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(taskHashCode) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(426819773, $dirty2, -1, "com.videshkarmakar.loop.ui.page.command.TaskLogPage (TaskLogPage.kt:56)");
            }
            Log.d(TAG, "TaskLogPage: " + taskHashCode);
            final TopAppBarScrollBehavior scrollBehavior = TopAppBarDefaults.INSTANCE.pinnedScrollBehavior(null, null, $composer3, TopAppBarDefaults.$stable << 6, 3);
            Iterator<T> it2 = Downloader.INSTANCE.getMutableTaskList().values().iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    it = (Downloader.CustomCommandTask) next;
                }
            } while (!(it.hashCode() == taskHashCode));
            final Downloader.CustomCommandTask task = (Downloader.CustomCommandTask) next;
            if (task == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskLogPageKt$TaskLogPage$task$2
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
                            TaskLogPageKt.TaskLogPage(onNavigateBack, taskHashCode, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                        }
                    });
                    return;
                }
                return;
            }
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localClipboardManager);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final ClipboardManager clipboardManager = (ClipboardManager) objConsume;
            $composer3.startReplaceGroup(-427294341);
            ComposerKt.sourceInformation($composer3, "CC(remember):TaskLogPage.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState expandLog$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            ScaffoldKt.m2530ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollBehavior.getNestedScrollConnection(), null, 2, null), ComposableLambdaKt.rememberComposableLambda(313455737, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskLogPageKt.TaskLogPage.1
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
                    ComposerKt.sourceInformation($composer4, "C71@3241L173,66@3003L485:TaskLogPage.kt#klscgo");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(313455737, $changed2, -1, "com.videshkarmakar.loop.ui.page.command.TaskLogPage.<anonymous> (TaskLogPage.kt:66)");
                        }
                        Function2<Composer, Integer, Unit> function2M7329getLambda1$app_debug = ComposableSingletons$TaskLogPageKt.INSTANCE.m7329getLambda1$app_debug();
                        final Function0<Unit> function0 = onNavigateBack;
                        AppBarKt.m1923TopAppBarGHTll3U(function2M7329getLambda1$app_debug, null, ComposableLambdaKt.rememberComposableLambda(1029486399, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskLogPageKt.TaskLogPage.1.1
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
                                Object value$iv2;
                                ComposerKt.sourceInformation($composer5, "C72@3280L20,72@3259L141:TaskLogPage.kt#klscgo");
                                if (($changed3 & 11) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1029486399, $changed3, -1, "com.videshkarmakar.loop.ui.page.command.TaskLogPage.<anonymous>.<anonymous> (TaskLogPage.kt:72)");
                                }
                                $composer5.startReplaceGroup(1586034186);
                                ComposerKt.sourceInformation($composer5, "CC(remember):TaskLogPage.kt#9igjgp");
                                boolean invalid$iv = $composer5.changed(function0);
                                final Function0<Unit> function1 = function0;
                                Object it$iv2 = $composer5.rememberedValue();
                                if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                    value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskLogPageKt$TaskLogPage$1$1$1$1
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
                                    $composer5.updateRememberedValue(value$iv2);
                                } else {
                                    value$iv2 = it$iv2;
                                }
                                $composer5.endReplaceGroup();
                                IconButtonKt.IconButton((Function0) value$iv2, null, false, null, null, ComposableSingletons$TaskLogPageKt.INSTANCE.m7330getLambda2$app_debug(), $composer5, ProfileVerifier.CompilationStatus.f245xf2722a21, 30);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), ComposableSingletons$TaskLogPageKt.INSTANCE.m7331getLambda3$app_debug(), 0.0f, null, null, scrollBehavior, $composer4, 3462, 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(-833084776, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskLogPageKt.TaskLogPage.2
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
                    Function0<ComposeUiNode> function0;
                    Function0<ComposeUiNode> function1;
                    Object value$iv2;
                    Object value$iv3;
                    Object value$iv4;
                    ComposerKt.sourceInformation($composer4, "C79@3526L3253:TaskLogPage.kt#klscgo");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-833084776, $changed2, -1, "com.videshkarmakar.loop.ui.page.command.TaskLogPage.<anonymous> (TaskLogPage.kt:79)");
                        }
                        Modifier modifier$iv = WindowInsetsPadding_androidKt.navigationBarsPadding(PaddingKt.m872paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(4), 7, null));
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
                        final Downloader.CustomCommandTask $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243 = task;
                        final ClipboardManager clipboardManager2 = clipboardManager;
                        final MutableState<Boolean> mutableState = expandLog$delegate;
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
                            function0 = constructor;
                            $composer4.createNode(function0);
                        } else {
                            function0 = constructor;
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
                        int i = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i2 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1586034691, "C86@3785L43,90@3961L21,87@3845L2920:TaskLogPage.kt#klscgo");
                        DividerKt.m2222Divider9IZ8Weo(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0L, $composer4, 6, 6);
                        Modifier modifier$iv2 = PaddingKt.m870paddingVpY3zN4$default(ScrollKt.horizontalScroll$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, null, false, 14, null), C1979Dp.m6801constructorimpl(16), 0.0f, 2, null);
                        ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                        int $i$f$Row = ((0 >> 3) & 14) | ((0 >> 3) & 112);
                        MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, $i$f$Row);
                        int $changed$iv$iv2 = (0 << 3) & 112;
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
                            function1 = constructor2;
                            $composer4.createNode(function1);
                        } else {
                            function1 = constructor2;
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
                        int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i4 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -702942136, "C:TaskLogPage.kt#klscgo");
                        $composer4.startReplaceGroup(1586034988);
                        ComposerKt.sourceInformation($composer4, "*96@4223L38,94@4112L259");
                        ChipsKt.m7241ButtonChip3f6hBDE(null, StringResources_androidKt.stringResource(C3070R.string.copy_log, $composer4, 0), false, ContentCopyKt.getContentCopy(Icons.Outlined.INSTANCE), 0L, null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskLogPageKt$TaskLogPage$2$1$1$1$1
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
                                $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.onCopyLog(clipboardManager2);
                            }
                        }, $composer4, 0, 53);
                        $composer4.startReplaceGroup(-702941817);
                        ComposerKt.sourceInformation($composer4, "103@4599L47,104@4706L11,101@4479L369");
                        if ($this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getState() instanceof Downloader.CustomCommandTask.State.Error) {
                            ChipsKt.m7241ButtonChip3f6hBDE(null, StringResources_androidKt.stringResource(C3070R.string.copy_error_report, $composer4, 0), false, ErrorOutlineKt.getErrorOutline(Icons.Outlined.INSTANCE), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getError(), null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskLogPageKt$TaskLogPage$2$1$1$1$2
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
                                    $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.onCopyError(clipboardManager2);
                                }
                            }, $composer4, 0, 37);
                        }
                        $composer4.endReplaceGroup();
                        $composer4.startReplaceGroup(-702941340);
                        ComposerKt.sourceInformation($composer4, "111@5072L36,112@5168L11,113@5227L74,109@4958L343");
                        if ($this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getState() instanceof Downloader.CustomCommandTask.State.Running) {
                            ImageVector cancel = CancelKt.getCancel(Icons.Outlined.INSTANCE);
                            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.cancel, $composer4, 0);
                            long onSurfaceVariant = MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant();
                            $composer4.startReplaceGroup(-1410446745);
                            ComposerKt.sourceInformation($composer4, "CC(remember):TaskLogPage.kt#9igjgp");
                            boolean invalid$iv = $composer4.changed($this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243);
                            Object it$iv2 = $composer4.rememberedValue();
                            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                value$iv4 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskLogPageKt$TaskLogPage$2$1$1$1$3$1
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
                                        $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.onCancel();
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv4);
                            } else {
                                value$iv4 = it$iv2;
                            }
                            $composer4.endReplaceGroup();
                            ChipsKt.m7241ButtonChip3f6hBDE(null, strStringResource, false, cancel, onSurfaceVariant, null, (Function0) value$iv4, $composer4, 0, 37);
                        }
                        $composer4.endReplaceGroup();
                        $composer4.startReplaceGroup(-702940887);
                        ComposerKt.sourceInformation($composer4, "119@5583L37,120@5652L75,117@5465L262");
                        if (($this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getState() instanceof Downloader.CustomCommandTask.State.Canceled) || ($this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getState() instanceof Downloader.CustomCommandTask.State.Error)) {
                            ImageVector restartAlt = RestartAltKt.getRestartAlt(Icons.Outlined.INSTANCE);
                            String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.restart, $composer4, 0);
                            $composer4.startReplaceGroup(-1410446320);
                            ComposerKt.sourceInformation($composer4, "CC(remember):TaskLogPage.kt#9igjgp");
                            boolean invalid$iv2 = $composer4.changed($this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243);
                            Object it$iv3 = $composer4.rememberedValue();
                            if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskLogPageKt$TaskLogPage$2$1$1$1$4$1
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
                                        $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.onRestart();
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv2);
                            } else {
                                value$iv2 = it$iv3;
                            }
                            $composer4.endReplaceGroup();
                            ChipsKt.m7241ButtonChip3f6hBDE(null, strStringResource2, false, restartAlt, 0L, null, (Function0) value$iv2, $composer4, 0, 53);
                        }
                        $composer4.endReplaceGroup();
                        $composer4.startReplaceGroup(-702940461);
                        ComposerKt.sourceInformation($composer4, "126@5938L88,124@5796L928");
                        if (!TaskLogPageKt.TaskLogPage$lambda$2(mutableState)) {
                            Modifier modifierM870paddingVpY3zN4$default = PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(4), 0.0f, 2, null);
                            $composer4.startReplaceGroup(-1410446034);
                            ComposerKt.sourceInformation($composer4, "CC(remember):TaskLogPage.kt#9igjgp");
                            Object it$iv4 = $composer4.rememberedValue();
                            if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                                value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskLogPageKt$TaskLogPage$2$1$1$1$5$1
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
                                        TaskLogPageKt.TaskLogPage$lambda$3(mutableState, true);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv3);
                            } else {
                                value$iv3 = it$iv4;
                            }
                            $composer4.endReplaceGroup();
                            ChipKt.ElevatedAssistChip((Function0<Unit>) value$iv3, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$TaskLogPageKt.INSTANCE.m7332getLambda4$app_debug(), modifierM870paddingVpY3zN4$default, false, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$TaskLogPageKt.INSTANCE.m7333getLambda5$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Shape) null, (ChipColors) null, (ChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, $composer4, 25014, 0, 2024);
                        }
                        $composer4.endReplaceGroup();
                        Unit unit = Unit.INSTANCE;
                        $composer4.endReplaceGroup();
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
            }, $composer3, 54), null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1767406834, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskLogPageKt.TaskLogPage.3
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
                    Object value$iv2;
                    Function0<ComposeUiNode> function0;
                    Intrinsics.checkNotNullParameter(paddings, "paddings");
                    ComposerKt.sourceInformation($composer4, "C147@6831L21,148@6905L73,148@6861L117,152@6988L723:TaskLogPage.kt#klscgo");
                    int $dirty3 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty3 |= $composer4.changed(paddings) ? 4 : 2;
                    }
                    if (($dirty3 & 91) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1767406834, $dirty3, -1, "com.videshkarmakar.loop.ui.page.command.TaskLogPage.<anonymous> (TaskLogPage.kt:147)");
                        }
                        ScrollState scrollState = ScrollKt.rememberScrollState(0, $composer4, 0, 1);
                        Integer numValueOf = Integer.valueOf(scrollState.getMaxValue());
                        $composer4.startReplaceGroup(-1029103726);
                        ComposerKt.sourceInformation($composer4, "CC(remember):TaskLogPage.kt#9igjgp");
                        boolean invalid$iv = $composer4.changed(scrollState);
                        Object it$iv2 = $composer4.rememberedValue();
                        if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new TaskLogPageKt$TaskLogPage$3$1$1(scrollState, null);
                            $composer4.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        $composer4.endReplaceGroup();
                        EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer4, 64);
                        Modifier modifier$iv = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.INSTANCE, paddings), 0.0f, 1, null), scrollState, false, null, false, 14, null);
                        final Downloader.CustomCommandTask customCommandTask = task;
                        final MutableState<Boolean> mutableState = expandLog$delegate;
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
                            function0 = constructor;
                            $composer4.createNode(function0);
                        } else {
                            function0 = constructor;
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
                        int i = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i2 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1586038069, "C158@7184L517,158@7163L538:TaskLogPage.kt#klscgo");
                        SelectionContainerKt.SelectionContainer(null, ComposableLambdaKt.rememberComposableLambda(1632762151, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskLogPageKt$TaskLogPage$3$2$1
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
                                ComposerKt.sourceInformation($composer5, "C168@7608L10,159@7202L485:TaskLogPage.kt#klscgo");
                                if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1632762151, $changed3, -1, "com.videshkarmakar.loop.ui.page.command.TaskLogPage.<anonymous>.<anonymous>.<anonymous> (TaskLogPage.kt:159)");
                                    }
                                    $composer5.startReplaceGroup(-702938940);
                                    ComposerKt.sourceInformation($composer5, "");
                                    Modifier.Companion $this$invoke_u24lambda_u240 = Modifier.INSTANCE;
                                    MutableState<Boolean> mutableState2 = mutableState;
                                    $composer5.startReplaceGroup(-702938906);
                                    ComposerKt.sourceInformation($composer5, "162@7339L21");
                                    Modifier modifierHorizontalScroll$default = TaskLogPageKt.TaskLogPage$lambda$2(mutableState2) ? ScrollKt.horizontalScroll$default($this$invoke_u24lambda_u240, ScrollKt.rememberScrollState(0, $composer5, 0, 1), false, null, false, 14, null) : $this$invoke_u24lambda_u240;
                                    $composer5.endReplaceGroup();
                                    $composer5.endReplaceGroup();
                                    Modifier modifierM870paddingVpY3zN4$default = PaddingKt.m870paddingVpY3zN4$default(PaddingKt.m872paddingqDBjuR0$default(modifierHorizontalScroll$default, 0.0f, C1979Dp.m6801constructorimpl(12), 0.0f, 0.0f, 13, null), C1979Dp.m6801constructorimpl(20), 0.0f, 2, null);
                                    String output = customCommandTask.getOutput();
                                    TextStyle bodyMedium = MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getBodyMedium();
                                    TextKt.m2817Text4IGK_g(output, modifierM870paddingVpY3zN4$default, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, bodyMedium.m6277copyp1EtxEg((16777213 & 1) != 0 ? bodyMedium.spanStyle.m6199getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? bodyMedium.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? bodyMedium.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? bodyMedium.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? bodyMedium.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? bodyMedium.spanStyle.getFontFamily() : FontFamily.INSTANCE.getMonospace(), (16777213 & 64) != 0 ? bodyMedium.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? bodyMedium.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? bodyMedium.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? bodyMedium.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? bodyMedium.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? bodyMedium.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? bodyMedium.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? bodyMedium.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? bodyMedium.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? bodyMedium.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? bodyMedium.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? bodyMedium.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? bodyMedium.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? bodyMedium.platformStyle : null, (16777213 & 1048576) != 0 ? bodyMedium.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? bodyMedium.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? bodyMedium.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? bodyMedium.paragraphStyle.getTextMotion() : null), $composer5, 0, 0, 65532);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54), $composer4, 48, 1);
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
            }, $composer3, 54), $composer2, 805306800, 504);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskLogPageKt.TaskLogPage.4
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
                    TaskLogPageKt.TaskLogPage(onNavigateBack, taskHashCode, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TaskLogPage$lambda$2(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TaskLogPage$lambda$3(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }
}
