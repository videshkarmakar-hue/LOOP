package com.videshkarmakar.loop.ui.page.command;

import android.view.View;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.AddKt;
import androidx.compose.material.icons.outlined.CancelKt;
import androidx.compose.material.icons.outlined.CodeKt;
import androidx.compose.material.icons.outlined.DownloadDoneKt;
import androidx.compose.material.icons.outlined.EditKt;
import androidx.compose.material.icons.outlined.NewLabelKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.Downloader;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.database.objects.CommandTemplate;
import com.videshkarmakar.loop.ui.common.HapticFeedback;
import com.videshkarmakar.loop.ui.common.Route;
import com.videshkarmakar.loop.ui.component.ButtonsKt;
import com.videshkarmakar.loop.ui.component.ChipsKt;
import com.videshkarmakar.loop.ui.component.DialogsKt;
import com.videshkarmakar.loop.ui.component.DividerKt;
import com.videshkarmakar.loop.ui.component.DownloadQueueItemKt;
import com.videshkarmakar.loop.ui.component.IconButtonsKt;
import com.videshkarmakar.loop.ui.component.ModalBottomSheetM2Kt;
import com.videshkarmakar.loop.ui.component.TaskStatus;
import com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.TextUtilKt;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: TaskListPage.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\b\u001a\u00020\u00012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\n\u001a=\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0014\u001ag\u0010\u0015\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000f2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u001e\u001a\f\u0010\u001f\u001a\u00020 *\u00020!H\u0002¨\u0006\"²\u0006\n\u0010#\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010$\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010%\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010&\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\u0010\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001a0(X\u008a\u0084\u0002²\u0006\n\u0010)\u001a\u00020\u0006X\u008a\u008e\u0002"}, d2 = {"TaskListPage", "", "onNavigateBack", "Lkotlin/Function0;", "onNavigateToDetail", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "TemplatePickerDialog", "onDismissRequest", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "TemplateSingleChoiceItem", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "supportingText", "selected", "", "onClick", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "TaskCreatorDialogContent", "Landroidx/compose/foundation/layout/ColumnScope;", "url", "onValueChange", Route.TEMPLATE, "Lcom/videshkarmakar/loop/database/objects/CommandTemplate;", "onTemplateSelectionClicked", "onNewTemplateClicked", "onEditClicked", "(Landroidx/compose/foundation/layout/ColumnScope;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lcom/videshkarmakar/loop/database/objects/CommandTemplate;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "toStatus", "Lcom/videshkarmakar/loop/ui/component/TaskStatus;", "Lcom/videshkarmakar/loop/Downloader$CustomCommandTask$State;", "app_debug", "showBottomSheet", "showTemplateSelectionDialog", "showTemplateCreatorDialog", "showTemplateEditorDialog", "templateList", "", "selectedId"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TaskListPageKt {
    public static final void TaskListPage(final Function0<Unit> onNavigateBack, final Function1<? super Integer, Unit> onNavigateToDetail, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Object value$iv;
        Composer $composer2;
        Object value$iv2;
        Intrinsics.checkNotNullParameter(onNavigateBack, "onNavigateBack");
        Intrinsics.checkNotNullParameter(onNavigateToDetail, "onNavigateToDetail");
        Composer $composer3 = $composer.startRestartGroup(491260571);
        ComposerKt.sourceInformation($composer3, "C(TaskListPage)90@4475L24,91@4525L7,93@4577L22,94@4627L34,95@4709L121,103@4967L395,114@5395L394,124@5791L1442,100@4836L2397,163@7405L34,163@7376L63,169@7546L3183,167@7466L3264:TaskListPage.kt#klscgo");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onNavigateBack) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(onNavigateToDetail) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(491260571, $dirty2, -1, "com.videshkarmakar.loop.ui.page.command.TaskListPage (TaskListPage.kt:89)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, -723523240, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final CoroutineScope scope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localView);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            View view = (View) objConsume;
            final TopAppBarScrollBehavior scrollBehavior = TopAppBarDefaults.INSTANCE.pinnedScrollBehavior(null, null, $composer3, TopAppBarDefaults.$stable << 6, 3);
            $composer3.startReplaceGroup(846652603);
            ComposerKt.sourceInformation($composer3, "CC(remember):TaskListPage.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState showBottomSheet$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            final ModalBottomSheetState sheetState = ModalBottomSheetKt.rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, null, null, true, $composer3, 3078, 6);
            ScaffoldKt.m2282ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollBehavior.getNestedScrollConnection(), null, 2, null), ComposableLambdaKt.rememberComposableLambda(2095366743, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TaskListPage.1
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
                    ComposerKt.sourceInformation($composer4, "C109@5228L63,104@4981L371:TaskListPage.kt#klscgo");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2095366743, $changed2, -1, "com.videshkarmakar.loop.ui.page.command.TaskListPage.<anonymous> (TaskListPage.kt:104)");
                        }
                        Function2<Composer, Integer, Unit> function2M7185getLambda1$app_debug = ComposableSingletons$TaskListPageKt.INSTANCE.m7185getLambda1$app_debug();
                        final Function0<Unit> function0 = onNavigateBack;
                        AppBarKt.m1675TopAppBarGHTll3U(function2M7185getLambda1$app_debug, null, ComposableLambdaKt.rememberComposableLambda(866017053, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TaskListPage.1.1
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
                                Object value$iv3;
                                ComposerKt.sourceInformation($composer5, "C110@5257L20,110@5246L31:TaskListPage.kt#klscgo");
                                if (($changed3 & 11) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(866017053, $changed3, -1, "com.videshkarmakar.loop.ui.page.command.TaskListPage.<anonymous>.<anonymous> (TaskListPage.kt:110)");
                                }
                                $composer5.startReplaceGroup(-1951249933);
                                ComposerKt.sourceInformation($composer5, "CC(remember):TaskListPage.kt#9igjgp");
                                boolean invalid$iv = $composer5.changed(function0);
                                final Function0<Unit> function1 = function0;
                                Object it$iv2 = $composer5.rememberedValue();
                                if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$1$1$1$1
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
                                    $composer5.updateRememberedValue(value$iv3);
                                } else {
                                    value$iv3 = it$iv2;
                                }
                                $composer5.endReplaceGroup();
                                IconButtonsKt.BackButton((Function0) value$iv3, $composer5, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), ComposableSingletons$TaskListPageKt.INSTANCE.m7186getLambda2$app_debug(), 0.0f, null, null, scrollBehavior, $composer4, 3462, 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), null, null, ComposableLambdaKt.rememberComposableLambda(1167237044, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TaskListPage.2
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
                    ComposerKt.sourceInformation($composer4, "C115@5409L370:TaskListPage.kt#klscgo");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1167237044, $changed2, -1, "com.videshkarmakar.loop.ui.page.command.TaskListPage.<anonymous> (TaskListPage.kt:115)");
                        }
                        final CoroutineScope coroutineScope = scope;
                        final ModalBottomSheetState modalBottomSheetState = sheetState;
                        final MutableState<Boolean> mutableState = showBottomSheet$delegate;
                        FloatingActionButtonKt.m2019FloatingActionButtonXz6DiA(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TaskListPage.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$2$1$1, reason: invalid class name and collision with other inner class name */
                            /* JADX INFO: compiled from: TaskListPage.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                            @DebugMetadata(c = "com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$2$1$1", f = "TaskListPage.kt", i = {}, l = {119, 120}, m = "invokeSuspend", n = {}, s = {})
                            static final class C01821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ ModalBottomSheetState $sheetState;
                                final /* synthetic */ MutableState<Boolean> $showBottomSheet$delegate;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C01821(ModalBottomSheetState modalBottomSheetState, MutableState<Boolean> mutableState, Continuation<? super C01821> continuation) {
                                    super(2, continuation);
                                    this.$sheetState = modalBottomSheetState;
                                    this.$showBottomSheet$delegate = mutableState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C01821(this.$sheetState, this.$showBottomSheet$delegate, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((C01821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                /* JADX WARN: Code duplicated, block: B:13:0x0041 A[RETURN] */
                                /* JADX WARN: Code duplicated, block: B:14:0x0042  */
                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object $result) {
                                    C01821 c01821;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result);
                                            c01821 = this;
                                            TaskListPageKt.TaskListPage$lambda$2(c01821.$showBottomSheet$delegate, true);
                                            c01821.label = 1;
                                            if (DelayKt.delay(50L, c01821) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            c01821.label = 2;
                                            if (c01821.$sheetState.show(c01821) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            return Unit.INSTANCE;
                                        case 1:
                                            c01821 = this;
                                            ResultKt.throwOnFailure($result);
                                            c01821.label = 2;
                                            if (c01821.$sheetState.show(c01821) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            return Unit.INSTANCE;
                                        case 2:
                                            ResultKt.throwOnFailure($result);
                                            return Unit.INSTANCE;
                                        default:
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C01821(modalBottomSheetState, mutableState, null), 3, null);
                            }
                        }, PaddingKt.m621paddingVpY3zN4(Modifier.INSTANCE, Dp.m6553constructorimpl(6), Dp.m6553constructorimpl(18)), null, 0L, 0L, null, null, ComposableSingletons$TaskListPageKt.INSTANCE.m7187getLambda3$app_debug(), $composer4, 12582912, 124);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-901518356, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TaskListPage.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
                    invoke(paddingValues, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues paddings, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(paddings, "paddings");
                    ComposerKt.sourceInformation($composer4, "C125@5858L7,126@5874L1353:TaskListPage.kt#klscgo");
                    int $dirty3 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty3 |= $composer4.changed(paddings) ? 4 : 2;
                    }
                    int $dirty4 = $dirty3;
                    if (($dirty4 & 91) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-901518356, $dirty4, -1, "com.videshkarmakar.loop.ui.page.command.TaskListPage.<anonymous> (TaskListPage.kt:125)");
                        }
                        ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = $composer4.consume(localClipboardManager);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        final ClipboardManager clipboardManager = (ClipboardManager) objConsume2;
                        Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, paddings);
                        PaddingValues paddingValuesM613PaddingValues0680j_4 = PaddingKt.m613PaddingValues0680j_4(Dp.m6553constructorimpl(24));
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM496spacedBy0680j_4 = Arrangement.INSTANCE.m496spacedBy0680j_4(Dp.m6553constructorimpl(12));
                        final Function1<Integer, Unit> function1 = onNavigateToDetail;
                        LazyDslKt.LazyColumn(modifierPadding, null, paddingValuesM613PaddingValues0680j_4, false, horizontalOrVerticalM496spacedBy0680j_4, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TaskListPage.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                Iterable $this$sortedBy$iv = CollectionsKt.toList(Downloader.INSTANCE.getMutableTaskList().values());
                                final List items$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$3$1$invoke$$inlined$sortedBy$1
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // java.util.Comparator
                                    public final int compare(T t, T t2) {
                                        Downloader.CustomCommandTask it = (Downloader.CustomCommandTask) t;
                                        Downloader.CustomCommandTask it2 = (Downloader.CustomCommandTask) t2;
                                        return ComparisonsKt.compareValues(TaskListPageKt.toStatus(it.getState()), TaskListPageKt.toStatus(it2.getState()));
                                    }
                                });
                                final Function1 key$iv = new Function1<Downloader.CustomCommandTask, Object>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TaskListPage.3.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Downloader.CustomCommandTask it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        return it.toKey();
                                    }
                                };
                                final Function1<Integer, Unit> function2 = function1;
                                final ClipboardManager clipboardManager2 = clipboardManager;
                                final Function1 contentType$iv = new Function1() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$3$1$invoke$$inlined$items$default$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                        return invoke((Downloader.CustomCommandTask) p1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Void invoke(Downloader.CustomCommandTask customCommandTask) {
                                        return null;
                                    }
                                };
                                LazyColumn.items(items$iv.size(), key$iv != null ? new Function1<Integer, Object>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$3$1$invoke$$inlined$items$default$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                        return invoke(num.intValue());
                                    }

                                    public final Object invoke(int index) {
                                        return key$iv.invoke(items$iv.get(index));
                                    }
                                } : null, new Function1<Integer, Object>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$3$1$invoke$$inlined$items$default$3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                        return invoke(num.intValue());
                                    }

                                    public final Object invoke(int index) {
                                        return contentType$iv.invoke(items$iv.get(index));
                                    }
                                }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$3$1$invoke$$inlined$items$default$4
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
                                        Object value$iv3;
                                        Object value$iv4;
                                        Object value$iv5;
                                        ComposerKt.sourceInformation($composer5, "C152@7074L22:LazyDsl.kt#428nma");
                                        int $dirty5 = $changed3;
                                        if (($changed3 & 6) == 0) {
                                            $dirty5 |= $composer5.changed($this$items) ? 4 : 2;
                                        }
                                        if (($changed3 & 48) == 0) {
                                            $dirty5 |= $composer5.changed(it) ? 32 : 16;
                                        }
                                        if (($dirty5 & 147) == 146 && $composer5.getSkipping()) {
                                            $composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-632812321, $dirty5, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                                        }
                                        int i = $dirty5 & 14;
                                        final Downloader.CustomCommandTask it2 = (Downloader.CustomCommandTask) items$iv.get(it);
                                        $composer5.startReplaceGroup(742555856);
                                        ComposerKt.sourceInformation($composer5, "C*144@6792L67,150@7018L86,140@6615L14,134@6242L943:TaskListPage.kt#klscgo");
                                        TaskStatus status = TaskListPageKt.toStatus(it2.getState());
                                        float progress = it2.getState() instanceof Downloader.CustomCommandTask.State.Running ? ((Downloader.CustomCommandTask.State.Running) it2.getState()).getProgress() / 100.0f : 0.0f;
                                        String currentLine = it2.getCurrentLine();
                                        String url = it2.getUrl();
                                        String name = it2.getTemplate().getName();
                                        Modifier modifierAnimateItem$default = LazyItemScope.CC.animateItem$default($this$items, Modifier.INSTANCE, null, null, null, 7, null);
                                        final ClipboardManager clipboardManager3 = clipboardManager2;
                                        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$3$1$3$1$1
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
                                                it2.onCopyLog(clipboardManager3);
                                            }
                                        };
                                        final ClipboardManager clipboardManager4 = clipboardManager2;
                                        Function0<Unit> function3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$3$1$3$1$2
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
                                                it2.onCopyError(clipboardManager4);
                                            }
                                        };
                                        $composer5.startReplaceGroup(1308757172);
                                        ComposerKt.sourceInformation($composer5, "CC(remember):TaskListPage.kt#9igjgp");
                                        boolean invalid$iv = $composer5.changed(it2);
                                        Object it$iv2 = $composer5.rememberedValue();
                                        if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                            value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$3$1$3$1$3$1
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
                                                    it2.onRestart();
                                                }
                                            };
                                            $composer5.updateRememberedValue(value$iv3);
                                        } else {
                                            value$iv3 = it$iv2;
                                        }
                                        Function0 function4 = (Function0) value$iv3;
                                        $composer5.endReplaceGroup();
                                        $composer5.startReplaceGroup(1308757398);
                                        ComposerKt.sourceInformation($composer5, "CC(remember):TaskListPage.kt#9igjgp");
                                        boolean invalid$iv2 = $composer5.changed(function2) | $composer5.changed(it2);
                                        Object it$iv3 = $composer5.rememberedValue();
                                        if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                            final Function1 function5 = function2;
                                            value$iv4 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$3$1$3$1$4$1
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
                                                    function5.invoke(Integer.valueOf(it2.hashCode()));
                                                }
                                            };
                                            $composer5.updateRememberedValue(value$iv4);
                                        } else {
                                            value$iv4 = it$iv3;
                                        }
                                        Function0 function6 = (Function0) value$iv4;
                                        $composer5.endReplaceGroup();
                                        $composer5.startReplaceGroup(1308756995);
                                        ComposerKt.sourceInformation($composer5, "CC(remember):TaskListPage.kt#9igjgp");
                                        boolean invalid$iv3 = $composer5.changed(it2);
                                        Object it$iv4 = $composer5.rememberedValue();
                                        if (invalid$iv3 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                            value$iv5 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$3$1$3$1$5$1
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
                                                    it2.onCancel();
                                                }
                                            };
                                            $composer5.updateRememberedValue(value$iv5);
                                        } else {
                                            value$iv5 = it$iv4;
                                        }
                                        $composer5.endReplaceGroup();
                                        DownloadQueueItemKt.CustomCommandTaskItem(modifierAnimateItem$default, status, progress, url, name, currentLine, function0, function3, function4, function6, (Function0) value$iv5, $composer5, 0, 0, 0);
                                        $composer5.endReplaceGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                            }
                        }, $composer4, 24960, 234);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer3, 805330992, 492);
            final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$onDismissRequest$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$onDismissRequest$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: TaskListPage.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(c = "com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$onDismissRequest$1$1", f = "TaskListPage.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ ModalBottomSheetState $sheetState;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$sheetState = modalBottomSheetState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$sheetState, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                this.label = 1;
                                if (this.$sheetState.hide(this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                break;
                            case 1:
                                ResultKt.throwOnFailure($result);
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(sheetState, null), 3, null);
                    final MutableState<Boolean> mutableState = showBottomSheet$delegate;
                    jobLaunch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$onDismissRequest$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable it) {
                            TaskListPageKt.TaskListPage$lambda$2(mutableState, false);
                        }
                    });
                }
            };
            boolean zTaskListPage$lambda$1 = TaskListPage$lambda$1(showBottomSheet$delegate);
            $composer2 = $composer3;
            $composer2.startReplaceGroup(846655381);
            ComposerKt.sourceInformation($composer2, "CC(remember):TaskListPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(function0);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$4$1
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
                        function0.invoke();
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            $composer2.endReplaceGroup();
            BackHandlerKt.BackHandler(zTaskListPage$lambda$1, (Function0) value$iv2, $composer2, 0, 0);
            if (TaskListPage$lambda$1(showBottomSheet$delegate)) {
                ModalBottomSheetM2Kt.LoopModalBottomSheetM2(null, sheetState, ComposableLambdaKt.rememberComposableLambda(-840276271, true, new C08915(sheetState, function0, view, scope), $composer2, 54), null, $composer2, (ModalBottomSheetState.$stable << 3) | 384, 9);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TaskListPage.6
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

                public final void invoke(Composer composer, int i) {
                    TaskListPageKt.TaskListPage(onNavigateBack, onNavigateToDetail, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final boolean TaskListPage$lambda$1(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TaskListPage$lambda$2(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TaskListPage.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/ColumnScope;", "invoke", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class C08915 extends Lambda implements Function3<ColumnScope, Composer, Integer, Unit> {
        final /* synthetic */ Function0<Unit> $onDismissRequest;
        final /* synthetic */ CoroutineScope $scope;
        final /* synthetic */ ModalBottomSheetState $sheetState;
        final /* synthetic */ View $view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08915(ModalBottomSheetState modalBottomSheetState, Function0<Unit> function0, View view, CoroutineScope coroutineScope) {
            super(3);
            this.$sheetState = modalBottomSheetState;
            this.$onDismissRequest = function0;
            this.$view = view;
            this.$scope = coroutineScope;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
            invoke(columnScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ColumnScope LoopModalBottomSheetM2, Composer $composer, int $changed) {
            Object value$iv;
            Object value$iv2;
            Object value$iv3;
            Object value$iv4;
            Object value$iv5;
            Function0<ComposeUiNode> function0;
            Object value$iv6;
            Object value$iv7;
            Object value$iv8;
            Intrinsics.checkNotNullParameter(LoopModalBottomSheetM2, "$this$LoopModalBottomSheetM2");
            ComposerKt.sourceInformation($composer, "C170@7605L7,172@7661L34,173@7741L34,174@7820L34,176@7884L197,182@8106L31,184@8151L229,190@8394L1642,241@10668L36,240@10579L126:TaskListPage.kt#klscgo");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-840276271, $changed, -1, "com.videshkarmakar.loop.ui.page.command.TaskListPage.<anonymous> (TaskListPage.kt:170)");
            }
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localClipboardManager);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ClipboardManager clipboardManager = (ClipboardManager) objConsume;
            $composer.startReplaceGroup(-339790154);
            ComposerKt.sourceInformation($composer, "CC(remember):TaskListPage.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState showTemplateSelectionDialog$delegate = (MutableState) value$iv;
            $composer.endReplaceGroup();
            $composer.startReplaceGroup(-339790074);
            ComposerKt.sourceInformation($composer, "CC(remember):TaskListPage.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableState showTemplateCreatorDialog$delegate = (MutableState) value$iv2;
            $composer.endReplaceGroup();
            $composer.startReplaceGroup(-339789995);
            ComposerKt.sourceInformation($composer, "CC(remember):TaskListPage.kt#9igjgp");
            Object it$iv3 = $composer.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final MutableState showTemplateEditorDialog$delegate = (MutableState) value$iv3;
            $composer.endReplaceGroup();
            boolean zInvoke$lambda$4 = invoke$lambda$4(showTemplateCreatorDialog$delegate);
            boolean zInvoke$lambda$1 = invoke$lambda$1(showTemplateSelectionDialog$delegate);
            boolean zInvoke$lambda$7 = invoke$lambda$7(showTemplateEditorDialog$delegate);
            $composer.startReplaceGroup(-339789931);
            ComposerKt.sourceInformation($composer, "CC(remember):TaskListPage.kt#9igjgp");
            boolean invalid$iv = $composer.changed(zInvoke$lambda$4) | $composer.changed(zInvoke$lambda$1) | $composer.changed(zInvoke$lambda$7);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PreferenceUtil.INSTANCE.getTemplate(), null, 2, null);
                $composer.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            MutableState template$delegate = (MutableState) value$iv4;
            $composer.endReplaceGroup();
            $composer.startReplaceGroup(-339789709);
            ComposerKt.sourceInformation($composer, "CC(remember):TaskListPage.kt#9igjgp");
            Object it$iv5 = $composer.rememberedValue();
            if (it$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                $composer.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv5;
            }
            final MutableState url$delegate = (MutableState) value$iv5;
            $composer.endReplaceGroup();
            EffectsKt.LaunchedEffect(this.$sheetState.getTargetValue(), new AnonymousClass1(this.$sheetState, clipboardManager, url$delegate, null), $composer, 64);
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            final Function0<Unit> function1 = this.$onDismissRequest;
            final View view = this.$view;
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
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
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            int $changed2 = ((6 >> 6) & 112) | 6;
            ColumnScope $this$invoke_u24lambda_u2418 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -1951246716, "C194@8546L56,198@8694L38,199@8777L36,200@8851L35,193@8474L413,201@8904L1118:TaskListPage.kt#klscgo");
            String strInvoke$lambda$12 = invoke$lambda$12(url$delegate);
            $composer.startReplaceGroup(-1951246644);
            ComposerKt.sourceInformation($composer, "CC(remember):TaskListPage.kt#9igjgp");
            Object value$iv9 = $composer.rememberedValue();
            if (value$iv9 == Composer.INSTANCE.getEmpty()) {
                value$iv9 = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$5$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        TaskListPageKt.C08915.invoke$lambda$13(url$delegate, it);
                    }
                };
                $composer.updateRememberedValue(value$iv9);
            }
            Function1 function2 = (Function1) value$iv9;
            $composer.endReplaceGroup();
            CommandTemplate commandTemplateInvoke$lambda$10 = invoke$lambda$10(template$delegate);
            $composer.startReplaceGroup(-1951246496);
            ComposerKt.sourceInformation($composer, "CC(remember):TaskListPage.kt#9igjgp");
            Object value$iv10 = $composer.rememberedValue();
            if (value$iv10 == Composer.INSTANCE.getEmpty()) {
                value$iv10 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$5$2$2$1
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
                        TaskListPageKt.C08915.invoke$lambda$2(showTemplateSelectionDialog$delegate, true);
                    }
                };
                $composer.updateRememberedValue(value$iv10);
            }
            Function0 function3 = (Function0) value$iv10;
            $composer.endReplaceGroup();
            $composer.startReplaceGroup(-1951246413);
            ComposerKt.sourceInformation($composer, "CC(remember):TaskListPage.kt#9igjgp");
            Object value$iv11 = $composer.rememberedValue();
            if (value$iv11 == Composer.INSTANCE.getEmpty()) {
                value$iv11 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$5$2$3$1
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
                        TaskListPageKt.C08915.invoke$lambda$5(showTemplateCreatorDialog$delegate, true);
                    }
                };
                $composer.updateRememberedValue(value$iv11);
            }
            Function0 function4 = (Function0) value$iv11;
            $composer.endReplaceGroup();
            $composer.startReplaceGroup(-1951246339);
            ComposerKt.sourceInformation($composer, "CC(remember):TaskListPage.kt#9igjgp");
            Object value$iv12 = $composer.rememberedValue();
            if (value$iv12 == Composer.INSTANCE.getEmpty()) {
                value$iv12 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$5$2$4$1
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
                        TaskListPageKt.C08915.invoke$lambda$8(showTemplateEditorDialog$delegate, true);
                    }
                };
                $composer.updateRememberedValue(value$iv12);
            }
            $composer.endReplaceGroup();
            TaskListPageKt.TaskCreatorDialogContent($this$invoke_u24lambda_u2418, strInvoke$lambda$12, function2, commandTemplateInvoke$lambda$10, function3, function4, (Function0) value$iv12, $composer, ($changed2 & 14) | 1794432, 0);
            LazyDslKt.LazyRow(PaddingKt.m624paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6553constructorimpl(24), 0.0f, 0.0f, 13, null), null, null, false, Arrangement.INSTANCE.getEnd(), null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$5$2$5
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
                public final void invoke2(LazyListScope LazyRow) {
                    Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                    final Function0<Unit> function5 = function1;
                    LazyListScope.CC.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(463887549, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$5$2$5.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                            invoke(lazyItemScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LazyItemScope item, Composer $composer2, int $changed3) {
                            Intrinsics.checkNotNullParameter(item, "$this$item");
                            ComposerKt.sourceInformation($composer2, "C212@9422L31,208@9172L307:TaskListPage.kt#klscgo");
                            if (($changed3 & 81) != 16 || !$composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(463887549, $changed3, -1, "com.videshkarmakar.loop.ui.page.command.TaskListPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TaskListPage.kt:208)");
                                }
                                ButtonsKt.m7103OutlinedButtonWithIconyrwZFoE(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(12), 0.0f, 2, null), function5, CancelKt.getCancel(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.cancel, $composer2, 0), 0L, $composer2, 6, 16);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer2.skipToGroupEnd();
                        }
                    }), 3, null);
                    final View view2 = view;
                    final Function0<Unit> function6 = function1;
                    final MutableState<String> mutableState = url$delegate;
                    LazyListScope.CC.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(1224673396, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$5$2$5.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                            invoke(lazyItemScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LazyItemScope item, Composer $composer2, int $changed3) {
                            Intrinsics.checkNotNullParameter(item, "$this$item");
                            ComposerKt.sourceInformation($composer2, "C223@9926L30,216@9553L429:TaskListPage.kt#klscgo");
                            if (($changed3 & 81) != 16 || !$composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1224673396, $changed3, -1, "com.videshkarmakar.loop.ui.page.command.TaskListPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TaskListPage.kt:216)");
                                }
                                ImageVector downloadDone = DownloadDoneKt.getDownloadDone(Icons.Outlined.INSTANCE);
                                String strStringResource = StringResources_androidKt.stringResource(R.string.start, $composer2, 0);
                                final View view3 = view2;
                                final Function0<Unit> function7 = function6;
                                final MutableState<String> mutableState2 = mutableState;
                                ButtonsKt.FilledButtonWithIcon(null, downloadDone, strStringResource, false, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TaskListPage.5.2.5.2.1
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
                                        HapticFeedback.INSTANCE.slightHapticFeedback(view3);
                                        Downloader.INSTANCE.executeCommandWithUrl(TaskListPageKt.C08915.invoke$lambda$12(mutableState2));
                                        function7.invoke();
                                    }
                                }, $composer2, 0, 9);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer2.skipToGroupEnd();
                        }
                    }), 3, null);
                }
            }, $composer, 24582, 238);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.startReplaceGroup(-339787766);
            ComposerKt.sourceInformation($composer, "229@10123L39,229@10100L62");
            if (invoke$lambda$1(showTemplateSelectionDialog$delegate)) {
                $composer.startReplaceGroup(-339787692);
                ComposerKt.sourceInformation($composer, "CC(remember):TaskListPage.kt#9igjgp");
                Object it$iv6 = $composer.rememberedValue();
                if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                    value$iv8 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$5$3$1
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
                            TaskListPageKt.C08915.invoke$lambda$2(showTemplateSelectionDialog$delegate, false);
                        }
                    };
                    $composer.updateRememberedValue(value$iv8);
                } else {
                    value$iv8 = it$iv6;
                }
                $composer.endReplaceGroup();
                TaskListPageKt.TemplatePickerDialog((Function0) value$iv8, $composer, 6, 0);
            }
            $composer.endReplaceGroup();
            $composer.startReplaceGroup(-339787626);
            ComposerKt.sourceInformation($composer, "232@10279L37,232@10238L266");
            if (invoke$lambda$4(showTemplateCreatorDialog$delegate)) {
                $composer.startReplaceGroup(-339787536);
                ComposerKt.sourceInformation($composer, "CC(remember):TaskListPage.kt#9igjgp");
                Object it$iv7 = $composer.rememberedValue();
                if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                    value$iv7 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$5$4$1
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
                            TaskListPageKt.C08915.invoke$lambda$5(showTemplateCreatorDialog$delegate, false);
                        }
                    };
                    $composer.updateRememberedValue(value$iv7);
                } else {
                    value$iv7 = it$iv7;
                }
                $composer.endReplaceGroup();
                final CoroutineScope coroutineScope = this.$scope;
                CommandTemplateDialogKt.CommandTemplateDialog(null, false, (Function0) value$iv7, new Function1<Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TaskListPage.5.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$5$5$1, reason: invalid class name */
                    /* JADX INFO: compiled from: TaskListPage.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(c = "com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$5$5$1", f = "TaskListPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ int $it;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(int i, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$it = i;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$it, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure(obj);
                                    PreferenceUtil.INSTANCE.updateInt("template_id", this.$it);
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }

                    public final void invoke(int it) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(it, null), 3, null);
                    }
                }, $composer, 384, 3);
            }
            $composer.endReplaceGroup();
            if (invoke$lambda$7(showTemplateEditorDialog$delegate)) {
                CommandTemplate commandTemplateInvoke$lambda$11 = invoke$lambda$10(template$delegate);
                $composer.startReplaceGroup(-339787147);
                ComposerKt.sourceInformation($composer, "CC(remember):TaskListPage.kt#9igjgp");
                Object it$iv8 = $composer.rememberedValue();
                if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                    value$iv6 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$5$6$1
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
                            TaskListPageKt.C08915.invoke$lambda$8(showTemplateEditorDialog$delegate, false);
                        }
                    };
                    $composer.updateRememberedValue(value$iv6);
                } else {
                    value$iv6 = it$iv8;
                }
                $composer.endReplaceGroup();
                CommandTemplateDialogKt.CommandTemplateDialog(commandTemplateInvoke$lambda$11, false, (Function0) value$iv6, null, $composer, 384, 10);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        private static final boolean invoke$lambda$1(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2(MutableState<Boolean> mutableState, boolean value) {
            mutableState.setValue(Boolean.valueOf(value));
        }

        private static final boolean invoke$lambda$4(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$5(MutableState<Boolean> mutableState, boolean value) {
            mutableState.setValue(Boolean.valueOf(value));
        }

        private static final boolean invoke$lambda$7(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$8(MutableState<Boolean> mutableState, boolean value) {
            mutableState.setValue(Boolean.valueOf(value));
        }

        private static final CommandTemplate invoke$lambda$10(MutableState<CommandTemplate> mutableState) {
            MutableState<CommandTemplate> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invoke$lambda$12(MutableState<String> mutableState) {
            MutableState<String> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$13(MutableState<String> mutableState, String value) {
            mutableState.setValue(value);
        }

        /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: TaskListPage.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(c = "com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskListPage$5$1", f = "TaskListPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ClipboardManager $clipboardManager;
            final /* synthetic */ ModalBottomSheetState $sheetState;
            final /* synthetic */ MutableState<String> $url$delegate;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ModalBottomSheetState modalBottomSheetState, ClipboardManager clipboardManager, MutableState<String> mutableState, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$sheetState = modalBottomSheetState;
                this.$clipboardManager = clipboardManager;
                this.$url$delegate = mutableState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$sheetState, this.$clipboardManager, this.$url$delegate, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        if (this.$sheetState.getTargetValue() == ModalBottomSheetValue.Expanded) {
                            MutableState<String> mutableState = this.$url$delegate;
                            AnnotatedString text = this.$clipboardManager.getText();
                            C08915.invoke$lambda$13(mutableState, TextUtilKt.matchUrlFromString(String.valueOf(text != null ? text.getText() : null), true));
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TaskStatus toStatus(Downloader.CustomCommandTask.State $this$toStatus) {
        if (Intrinsics.areEqual($this$toStatus, Downloader.CustomCommandTask.State.Canceled.INSTANCE)) {
            return TaskStatus.CANCELED;
        }
        if (Intrinsics.areEqual($this$toStatus, Downloader.CustomCommandTask.State.Completed.INSTANCE)) {
            return TaskStatus.FINISHED;
        }
        if ($this$toStatus instanceof Downloader.CustomCommandTask.State.Error) {
            return TaskStatus.ERROR;
        }
        if ($this$toStatus instanceof Downloader.CustomCommandTask.State.Running) {
            return TaskStatus.RUNNING;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void TaskCreatorDialogContent(final ColumnScope $this$TaskCreatorDialogContent, final String url, Function1<? super String, Unit> function1, final CommandTemplate template, Function0<Unit> function0, Function0<Unit> function2, Function0<Unit> function3, Composer $composer, final int $changed, final int i) {
        Function1<? super String, Unit> function4;
        Function0<Unit> function5;
        Function0<Unit> function6;
        Function0<Unit> function7;
        Object value$iv;
        Function1<? super String, Unit> function8;
        Function0<Unit> function9;
        Intrinsics.checkNotNullParameter($this$TaskCreatorDialogContent, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(template, "template");
        Composer $composer2 = $composer.startRestartGroup(1472224633);
        ComposerKt.sourceInformation($composer2, "C(TaskCreatorDialogContent)P(5,3,4,2,1)264@11388L152,270@11566L38,271@11636L10,269@11545L340,280@11911L44,281@11987L10,282@12040L11,279@11890L337,303@12732L7,296@12497L198,289@12233L553,309@12909L687,307@12793L803:TaskListPage.kt#klscgo");
        int $dirty = $changed;
        if ((i & Integer.MIN_VALUE) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed($this$TaskCreatorDialogContent) ? 4 : 2;
        }
        if ((i & 1) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(url) ? 32 : 16;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 384;
            function4 = function1;
        } else if (($changed & 896) == 0) {
            function4 = function1;
            $dirty |= $composer2.changedInstance(function4) ? 256 : 128;
        } else {
            function4 = function1;
        }
        if ((i & 4) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(template) ? 2048 : 1024;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            function5 = function0;
        } else if (($changed & 57344) == 0) {
            function5 = function0;
            $dirty |= $composer2.changedInstance(function5) ? 16384 : 8192;
        } else {
            function5 = function0;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function6 = function2;
        } else if (($changed & 458752) == 0) {
            function6 = function2;
            $dirty |= $composer2.changedInstance(function6) ? 131072 : 65536;
        } else {
            function6 = function2;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= 1572864;
            function7 = function3;
        } else if (($changed & 3670016) == 0) {
            function7 = function3;
            $dirty |= $composer2.changedInstance(function7) ? 1048576 : 524288;
        } else {
            function7 = function3;
        }
        if (($dirty & 2995931) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function9 = function5;
            function8 = function4;
        } else {
            final AnonymousClass1 anonymousClass1 = i2 != 0 ? new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TaskCreatorDialogContent.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            } : function4;
            final AnonymousClass2 anonymousClass2 = i3 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TaskCreatorDialogContent.2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function5;
            final AnonymousClass3 anonymousClass3 = i4 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TaskCreatorDialogContent.3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function6;
            final AnonymousClass4 anonymousClass4 = i5 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TaskCreatorDialogContent.4
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function7;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1472224633, $dirty, -1, "com.videshkarmakar.loop.ui.page.command.TaskCreatorDialogContent (TaskListPage.kt:263)");
            }
            IconKt.m2044Iconww6aTOc(AddKt.getAdd(Icons.Outlined.INSTANCE), (String) null, $this$TaskCreatorDialogContent.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally()), 0L, $composer2, 48, 8);
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.new_task, $composer2, 0), PaddingKt.m622paddingVpY3zN4$default($this$TaskCreatorDialogContent.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally()), 0.0f, Dp.m6553constructorimpl(16), 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6403boximpl(TextAlign.INSTANCE.m6410getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getHeadlineSmall(), $composer2, 0, 3120, 54780);
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.custom_command_desc, $composer2, 0), PaddingKt.m624paddingqDBjuR0$default($this$TaskCreatorDialogContent.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally()), 0.0f, 0.0f, 0.0f, Dp.m6553constructorimpl(24), 7, null), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6403boximpl(TextAlign.INSTANCE.m6410getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getBodyMedium(), $composer2, 0, 0, 65016);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localTextStyle);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            OutlinedTextFieldKt.OutlinedTextField(url, anonymousClass1, modifierFillMaxWidth$default, false, false, ((TextStyle) objConsume).m6048mergedA7vx0o((16609105 & 1) != 0 ? Color.INSTANCE.m4079getUnspecified0d7_KjU() : 0L, (16609105 & 2) != 0 ? TextUnit.INSTANCE.m6761getUnspecifiedXSAIIZE() : 0L, (16609105 & 4) != 0 ? null : null, (16609105 & 8) != 0 ? null : null, (16609105 & 16) != 0 ? null : null, (16609105 & 32) != 0 ? null : FontFamily.INSTANCE.getMonospace(), (16609105 & 64) != 0 ? null : null, (16609105 & 128) != 0 ? TextUnit.INSTANCE.m6761getUnspecifiedXSAIIZE() : 0L, (16609105 & 256) != 0 ? null : null, (16609105 & 512) != 0 ? null : null, (16609105 & 1024) != 0 ? null : null, (16609105 & 2048) != 0 ? Color.INSTANCE.m4079getUnspecified0d7_KjU() : 0L, (16609105 & 4096) != 0 ? null : null, (16609105 & 8192) != 0 ? null : null, (16609105 & 16384) != 0 ? null : null, (16609105 & 32768) != 0 ? TextAlign.INSTANCE.m6416getUnspecifiede0LSkKk() : 0, (16609105 & 65536) != 0 ? TextDirection.INSTANCE.m6429getUnspecifieds_7Xco() : 0, (16609105 & 131072) != 0 ? TextUnit.INSTANCE.m6761getUnspecifiedXSAIIZE() : 0L, (16609105 & 262144) != 0 ? null : null, (16609105 & 524288) != 0 ? null : null, (16609105 & 1048576) != 0 ? LineBreak.INSTANCE.m6343getUnspecifiedrAG3T2k() : 0, (16609105 & 2097152) != 0 ? Hyphens.INSTANCE.m6322getUnspecifiedvmbZdU8() : 0, (16609105 & 4194304) != 0 ? null : null, (16609105 & 8388608) != 0 ? null : null), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$TaskListPageKt.INSTANCE.m7188getLambda4$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(897910896, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TaskCreatorDialogContent.5
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

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer3, "C:TaskListPage.kt#klscgo");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(897910896, $changed2, -1, "com.videshkarmakar.loop.ui.page.command.TaskCreatorDialogContent.<anonymous> (TaskListPage.kt:297)");
                        }
                        if (url.length() > 0) {
                            $composer3.startReplaceGroup(1376708696);
                            ComposerKt.sourceInformation($composer3, "298@12563L21,298@12551L33");
                            $composer3.startReplaceGroup(1376708708);
                            ComposerKt.sourceInformation($composer3, "CC(remember):TaskListPage.kt#9igjgp");
                            boolean invalid$iv = $composer3.changed(anonymousClass1);
                            final Function1<String, Unit> function10 = anonymousClass1;
                            Object it$iv = $composer3.rememberedValue();
                            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskCreatorDialogContent$5$1$1
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
                                        function10.invoke("");
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv2);
                            } else {
                                value$iv2 = it$iv;
                            }
                            $composer3.endReplaceGroup();
                            IconButtonsKt.ClearButton((Function0) value$iv2, $composer3, 0);
                            $composer3.endReplaceGroup();
                        } else {
                            $composer3.startReplaceGroup(1376708767);
                            ComposerKt.sourceInformation($composer3, "300@12622L49");
                            IconButtonsKt.PasteFromClipBoardButton(anonymousClass1, $composer3, 0, 0);
                            $composer3.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 3, 3, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer2, (($dirty >> 3) & 14) | 806879616 | (($dirty >> 3) & 112), 905969664, 0, 7601560);
            Modifier modifierM624paddingqDBjuR0$default = PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(12), 0.0f, 0.0f, 13, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM496spacedBy0680j_4 = Arrangement.INSTANCE.m496spacedBy0680j_4(Dp.m6553constructorimpl(8));
            $composer2.startReplaceGroup(-2137378915);
            ComposerKt.sourceInformation($composer2, "CC(remember):TaskListPage.kt#9igjgp");
            boolean invalid$iv = (($dirty & 458752) == 131072) | (($dirty & 7168) == 2048) | (($dirty & 57344) == 16384) | (($dirty & 3670016) == 1048576);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskCreatorDialogContent$6$1
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
                    public final void invoke2(LazyListScope LazyRow) {
                        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                        final CommandTemplate commandTemplate = template;
                        final Function0<Unit> function10 = anonymousClass2;
                        LazyListScope.CC.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(-980446313, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskCreatorDialogContent$6$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                invoke(lazyItemScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(LazyItemScope item, Composer $composer3, int $changed2) {
                                Intrinsics.checkNotNullParameter(item, "$this$item");
                                ComposerKt.sourceInformation($composer3, "C311@12938L169:TaskListPage.kt#klscgo");
                                if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-980446313, $changed2, -1, "com.videshkarmakar.loop.ui.page.command.TaskCreatorDialogContent.<anonymous>.<anonymous>.<anonymous> (TaskListPage.kt:311)");
                                    }
                                    ChipsKt.OutlinedButtonChip(null, CodeKt.getCode(Icons.Outlined.INSTANCE), commandTemplate.getName(), null, function10, $composer3, 0, 9);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer3.skipToGroupEnd();
                            }
                        }), 3, null);
                        final CommandTemplate commandTemplate2 = template;
                        final Function0<Unit> function11 = anonymousClass4;
                        LazyListScope.CC.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(767174336, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskCreatorDialogContent$6$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                invoke(lazyItemScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(LazyItemScope item, Composer $composer3, int $changed2) {
                                Intrinsics.checkNotNullParameter(item, "$this$item");
                                ComposerKt.sourceInformation($composer3, "C320@13233L58,318@13145L201:TaskListPage.kt#klscgo");
                                if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(767174336, $changed2, -1, "com.videshkarmakar.loop.ui.page.command.TaskCreatorDialogContent.<anonymous>.<anonymous>.<anonymous> (TaskListPage.kt:318)");
                                    }
                                    ChipsKt.OutlinedButtonChip(null, EditKt.getEdit(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.edit_template, new Object[]{commandTemplate2.getName()}, $composer3, 64), null, function11, $composer3, 0, 9);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer3.skipToGroupEnd();
                            }
                        }), 3, null);
                        final Function0<Unit> function12 = anonymousClass3;
                        LazyListScope.CC.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(1668242271, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TaskCreatorDialogContent$6$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                invoke(lazyItemScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(LazyItemScope item, Composer $composer3, int $changed2) {
                                Intrinsics.checkNotNullParameter(item, "$this$item");
                                ComposerKt.sourceInformation($composer3, "C327@13476L42,325@13384L196:TaskListPage.kt#klscgo");
                                if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1668242271, $changed2, -1, "com.videshkarmakar.loop.ui.page.command.TaskCreatorDialogContent.<anonymous>.<anonymous>.<anonymous> (TaskListPage.kt:325)");
                                    }
                                    ChipsKt.OutlinedButtonChip(null, NewLabelKt.getNewLabel(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.new_template, $composer3, 0), null, function12, $composer3, 0, 9);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer3.skipToGroupEnd();
                            }
                        }), 3, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer2.endReplaceGroup();
            LazyDslKt.LazyRow(modifierM624paddingqDBjuR0$default, null, null, false, horizontalOrVerticalM496spacedBy0680j_4, null, null, false, (Function1) value$iv, $composer2, 24582, 238);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function8 = anonymousClass1;
            function9 = anonymousClass2;
            function6 = anonymousClass3;
            function7 = anonymousClass4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function1<? super String, Unit> function10 = function8;
            final Function0<Unit> function11 = function9;
            final Function0<Unit> function12 = function6;
            final Function0<Unit> function13 = function7;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TaskCreatorDialogContent.7
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

                public final void invoke(Composer composer, int i6) {
                    TaskListPageKt.TaskCreatorDialogContent($this$TaskCreatorDialogContent, url, function10, template, function11, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void TemplatePickerDialog(Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        final Function0<Unit> function1;
        Object value$iv$iv;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(1063163372);
        ComposerKt.sourceInformation($composer3, "C(TemplatePickerDialog)337@13736L29,338@13800L8,340@13839L180,345@14089L57,349@14321L814,345@14025L1111:TaskListPage.kt#klscgo");
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
            final Function0<Unit> function2 = i2 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TemplatePickerDialog.1
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
                ComposerKt.traceEventStart(1063163372, $dirty2, -1, "com.videshkarmakar.loop.ui.page.command.TemplatePickerDialog (TaskListPage.kt:336)");
            }
            final State templateList$delegate = FlowExtKt.collectAsStateWithLifecycle(PreferenceUtil.INSTANCE.getTemplateListStateFlow(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer3, 8, 7);
            $composer3.startReplaceGroup(1963460724);
            ComposerKt.sourceInformation($composer3, "CC19@677L57:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(302245525);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotIntStateKt.mutableIntStateOf(PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, "template_id", 0, 1, null));
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            final MutableIntState selectedId$delegate = (MutableIntState) value$iv$iv;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            int index$iv = 0;
            Iterator<CommandTemplate> it = TemplatePickerDialog$lambda$5(templateList$delegate).iterator();
            while (true) {
                if (it.hasNext()) {
                    Object item$iv = it.next();
                    CommandTemplate it2 = (CommandTemplate) item$iv;
                    if (it2.getId() == TemplatePickerDialog$lambda$6(selectedId$delegate)) {
                        break;
                    } else {
                        index$iv++;
                    }
                } else {
                    index$iv = -1;
                    break;
                }
            }
            int $this$TemplatePickerDialog_u24lambda_u249 = index$iv;
            if ($this$TemplatePickerDialog_u24lambda_u249 == -1) {
                $this$TemplatePickerDialog_u24lambda_u249 = 0;
            }
            final LazyListState scrollState = LazyListStateKt.rememberLazyListState($this$TemplatePickerDialog_u24lambda_u249, 0, $composer3, 0, 2);
            Function0<Unit> function3 = function2;
            $composer2 = $composer3;
            DialogsKt.m7162LoopDialogOix01E0(null, function3, ComposableLambdaKt.rememberComposableLambda(809685681, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TemplatePickerDialog.2
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
                    ComposerKt.sourceInformation($composer4, "C346@14099L41:TaskListPage.kt#klscgo");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(809685681, $changed2, -1, "com.videshkarmakar.loop.ui.page.command.TemplatePickerDialog.<anonymous> (TaskListPage.kt:346)");
                    }
                    ButtonsKt.DismissButton(null, function2, $composer4, 0, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), null, ComposableSingletons$TaskListPageKt.INSTANCE.m7189getLambda5$app_debug(), ComposableSingletons$TaskListPageKt.INSTANCE.m7190getLambda6$app_debug(), ComposableLambdaKt.rememberComposableLambda(1003835181, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TemplatePickerDialog.3
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

                public final void invoke(Composer $composer4, int $changed2) {
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C350@14331L798:TaskListPage.kt#klscgo");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1003835181, $changed2, -1, "com.videshkarmakar.loop.ui.page.command.TemplatePickerDialog.<anonymous> (TaskListPage.kt:350)");
                        }
                        Modifier modifier$iv = SizeKt.m653heightInVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(450), 1, null);
                        LazyListState lazyListState = scrollState;
                        final State<List<CommandTemplate>> state = templateList$delegate;
                        final MutableIntState mutableIntState = selectedId$delegate;
                        final Function0<Unit> function4 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (6 << 3) & 112;
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
                            $composer4.createNode(constructor);
                        } else {
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer4);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i3 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        int i4 = ((6 >> 6) & 112) | 6;
                        BoxScope $this$invoke_u24lambda_u241 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, 329643333, "C351@14393L65,352@14503L535,352@14471L567,365@15051L68:TaskListPage.kt#klscgo");
                        DividerKt.m7164HorizontalDivideriJQMabo($this$invoke_u24lambda_u241.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), 0L, $composer4, 0, 2);
                        $composer4.startReplaceGroup(329643443);
                        ComposerKt.sourceInformation($composer4, "CC(remember):TaskListPage.kt#9igjgp");
                        boolean invalid$iv = $composer4.changed(state) | $composer4.changed(mutableIntState) | $composer4.changed(function4);
                        Object it$iv = $composer4.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = (Function1) new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TemplatePickerDialog$3$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
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
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$TaskListPageKt.INSTANCE.m7191getLambda7$app_debug(), 3, null);
                                    final List items$iv = TaskListPageKt.TemplatePickerDialog$lambda$5(state);
                                    final MutableIntState mutableIntState2 = mutableIntState;
                                    final Function0<Unit> function5 = function4;
                                    final Function1 contentType$iv = new Function1() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TemplatePickerDialog$3$1$1$1$invoke$$inlined$items$default$1
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                            return invoke((CommandTemplate) p1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Void invoke(CommandTemplate commandTemplate) {
                                            return null;
                                        }
                                    };
                                    LazyColumn.items(items$iv.size(), null, new Function1<Integer, Object>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TemplatePickerDialog$3$1$1$1$invoke$$inlined$items$default$3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                            return invoke(num.intValue());
                                        }

                                        public final Object invoke(int index) {
                                            return contentType$iv.invoke(items$iv.get(index));
                                        }
                                    }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TemplatePickerDialog$3$1$1$1$invoke$$inlined$items$default$4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope $this$items, int it3, Composer $composer5, int $changed3) {
                                            Object value$iv2;
                                            ComposerKt.sourceInformation($composer5, "C152@7074L22:LazyDsl.kt#428nma");
                                            int $dirty3 = $changed3;
                                            if (($changed3 & 6) == 0) {
                                                $dirty3 |= $composer5.changed($this$items) ? 4 : 2;
                                            }
                                            if (($changed3 & 48) == 0) {
                                                $dirty3 |= $composer5.changed(it3) ? 32 : 16;
                                            }
                                            if (($dirty3 & 147) == 146 && $composer5.getSkipping()) {
                                                $composer5.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-632812321, $dirty3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                                            }
                                            int $changed4 = $dirty3 & 14;
                                            final CommandTemplate it4 = (CommandTemplate) items$iv.get(it3);
                                            $composer5.startReplaceGroup(-1554830828);
                                            ComposerKt.sourceInformation($composer5, "C*357@14778L162,355@14629L311:TaskListPage.kt#klscgo");
                                            String name = it4.getName();
                                            String template = it4.getTemplate();
                                            boolean z = it4.getId() == TaskListPageKt.TemplatePickerDialog$lambda$6(mutableIntState2);
                                            $composer5.startReplaceGroup(-1554830679);
                                            ComposerKt.sourceInformation($composer5, "CC(remember):TaskListPage.kt#9igjgp");
                                            boolean invalid$iv2 = $composer5.changed(mutableIntState2) | (((($changed4 & 112) ^ 48) > 32 && $composer5.changed(it4)) || ($changed4 & 48) == 32) | $composer5.changed(function5);
                                            Object it$iv2 = $composer5.rememberedValue();
                                            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                                final Function0 function6 = function5;
                                                final MutableIntState mutableIntState3 = mutableIntState2;
                                                value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TemplatePickerDialog$3$1$1$1$1$1$1
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
                                                        mutableIntState3.setIntValue(it4.getId());
                                                        PreferenceUtil.INSTANCE.updateInt("template_id", it4.getId());
                                                        function6.invoke();
                                                    }
                                                };
                                                $composer5.updateRememberedValue(value$iv2);
                                            } else {
                                                value$iv2 = it$iv2;
                                            }
                                            $composer5.endReplaceGroup();
                                            TaskListPageKt.TemplateSingleChoiceItem(null, name, template, z, (Function0) value$iv2, $composer5, 0, 1);
                                            $composer5.endReplaceGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }));
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$TaskListPageKt.INSTANCE.m7192getLambda8$app_debug(), 3, null);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        $composer4.endReplaceGroup();
                        LazyDslKt.LazyColumn(null, lazyListState, null, false, null, null, null, false, (Function1) value$iv, $composer4, 0, 253);
                        DividerKt.m7164HorizontalDivideriJQMabo($this$invoke_u24lambda_u241.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter()), 0L, $composer4, 0, 2);
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
            }, $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty2 << 3) & 112) | 1794432, 0, 16265);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TemplatePickerDialog.4
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
                    TaskListPageKt.TemplatePickerDialog(function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<CommandTemplate> TemplatePickerDialog$lambda$5(State<? extends List<CommandTemplate>> state) {
        Object thisObj$iv = state.getValue();
        return (List) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int TemplatePickerDialog$lambda$6(MutableIntState $selectedId$delegate) {
        MutableIntState $this$getValue$iv = $selectedId$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX WARN: Code duplicated, block: B:97:0x0436  */
    public static final void TemplateSingleChoiceItem(Modifier modifier, final String text, final String supportingText, final boolean selected, final Function0<Unit> onClick, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        CompositionLocalMap localMap$iv$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(supportingText, "supportingText");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer3 = $composer.startRestartGroup(752502721);
        ComposerKt.sourceInformation($composer3, "C(TemplateSingleChoiceItem)P(!1,4,3,2)378@15318L1029:TaskListPage.kt#klscgo");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(text) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(supportingText) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changed(selected) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if ((57344 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onClick) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if ((46811 & $dirty2) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            $composer2 = $composer3;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(752502721, $dirty2, -1, "com.videshkarmakar.loop.ui.page.command.TemplateSingleChoiceItem (TaskListPage.kt:377)");
            }
            Modifier modifierM622paddingVpY3zN4$default = PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(SelectableKt.m869selectableXHw0xAI$default(modifier3, selected, true, null, onClick, 4, null), 0.0f, 1, null), Dp.m6553constructorimpl(12), 0.0f, 2, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(start, centerVertically, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifierM622paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i4 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 594466603, "C390@15686L197,397@15892L449:TaskListPage.kt#klscgo");
            RadioButtonKt.RadioButton(selected, onClick, SemanticsModifierKt.clearAndSetSemantics(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(8), 0.0f, 11, null), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt$TemplateSingleChoiceItem$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                    Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                }
            }), false, null, null, $composer3, (($dirty2 >> 9) & 14) | (($dirty2 >> 9) & 112), 56);
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.INSTANCE;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor2);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer3);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                localMap$iv$iv = localMap$iv$iv3;
            } else {
                localMap$iv$iv = localMap$iv$iv3;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i6 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -780326225, "C400@15986L10,398@15913L189,406@16217L10,404@16115L216:TaskListPage.kt#klscgo");
                $composer2 = $composer3;
                TextKt.m2569Text4IGK_g(text, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleMedium(), $composer3, ($dirty2 >> 3) & 14, 3120, 55294);
                TextKt.m2569Text4IGK_g(StringsKt.replace$default(supportingText, IOUtils.LINE_SEPARATOR_UNIX, " ", false, 4, (Object) null), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall(), $composer3, 0, 3120, 55294);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
            int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -780326225, "C400@15986L10,398@15913L189,406@16217L10,404@16115L216:TaskListPage.kt#klscgo");
            $composer2 = $composer3;
            TextKt.m2569Text4IGK_g(text, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleMedium(), $composer3, ($dirty2 >> 3) & 14, 3120, 55294);
            TextKt.m2569Text4IGK_g(StringsKt.replace$default(supportingText, IOUtils.LINE_SEPARATOR_UNIX, " ", false, 4, (Object) null), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall(), $composer3, 0, 3120, 55294);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.command.TaskListPageKt.TemplateSingleChoiceItem.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) {
                    TaskListPageKt.TemplateSingleChoiceItem(modifier4, text, supportingText, selected, onClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
