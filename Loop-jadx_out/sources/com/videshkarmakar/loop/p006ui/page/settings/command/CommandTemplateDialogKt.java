package com.videshkarmakar.loop.p006ui.page.settings.command;

import android.content.Context;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.AddKt;
import androidx.compose.material.icons.outlined.EditNoteKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.focus.FocusDirection;
import androidx.compose.p001ui.focus.FocusManager;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.platform.ClipboardManager;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.platform.SoftwareKeyboardController;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.input.ImeAction;
import androidx.compose.p001ui.text.input.PlatformImeOptions;
import androidx.compose.p001ui.text.input.VisualTransformation;
import androidx.compose.p001ui.text.intl.LocaleList;
import androidx.compose.p001ui.text.style.Hyphens;
import androidx.compose.p001ui.text.style.LineBreak;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.text.style.TextDirection;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.TextUnit;
import androidx.compose.p001ui.window.DialogProperties;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.accompanist.flowlayout.FlowKt;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.database.objects.CommandTemplate;
import com.videshkarmakar.loop.database.objects.OptionShortcut;
import com.videshkarmakar.loop.p006ui.component.ButtonsKt;
import com.videshkarmakar.loop.p006ui.component.ChipsKt;
import com.videshkarmakar.loop.p006ui.component.DialogsKt;
import com.videshkarmakar.loop.p006ui.component.IconButtonsKt;
import com.videshkarmakar.loop.p006ui.component.TextFieldKt;
import com.videshkarmakar.loop.util.DatabaseUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import okhttp3.internal.http.HttpStatusCodesKt;
import okhttp3.internal.p009ws.WebSocketProtocol;

/* JADX INFO: compiled from: CommandTemplateDialog.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(m194d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001aG\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\u000b\u001a\u001d\u0010\f\u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\u0010\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0010X\u008a\u008e\u0002"}, m195d2 = {"CommandTemplateDialog", "", "commandTemplate", "Lcom/videshkarmakar/loop/database/objects/CommandTemplate;", "newTemplate", "", "onDismissRequest", "Lkotlin/Function0;", "confirmationCallback", "Lkotlin/Function1;", "", "(Lcom/videshkarmakar/loop/database/objects/CommandTemplate;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "OptionChipsDialog", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_debug", "templateText", "", "templateName", "isError", "shortcuts", "", "Lcom/videshkarmakar/loop/database/objects/OptionShortcut;", "text"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CommandTemplateDialogKt {
    public static final void CommandTemplateDialog(CommandTemplate commandTemplate, boolean newTemplate, Function0<Unit> function0, Function1<? super Integer, Unit> function1, Composer $composer, final int $changed, final int i) {
        CommandTemplate commandTemplate2;
        final boolean newTemplate2;
        Function0<Unit> function2;
        Function1<? super Integer, Unit> function3;
        int $dirty;
        final Function0<Unit> function4;
        C36202 c36202;
        Object value$iv$iv;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        CommandTemplate commandTemplate3;
        boolean newTemplate3;
        Composer $composer2 = $composer.startRestartGroup(151951363);
        ComposerKt.sourceInformation($composer2, "C(CommandTemplateDialog)P(!1,2,3)69@3294L7,70@3351L7,71@3375L24,72@3424L53,73@3502L49,74@3571L34,82@3898L22,84@4043L941,109@5010L133,76@3638L80,77@3736L133,114@5160L2016,75@3610L3567:CommandTemplateDialog.kt#fk5gu5");
        int $dirty2 = $changed;
        if (($changed & 14) == 0) {
            if ((i & 1) == 0) {
                commandTemplate2 = commandTemplate;
                int i2 = $composer2.changed(commandTemplate2) ? 4 : 2;
                $dirty2 |= i2;
            } else {
                commandTemplate2 = commandTemplate;
            }
            $dirty2 |= i2;
        } else {
            commandTemplate2 = commandTemplate;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                newTemplate2 = newTemplate;
                int i3 = $composer2.changed(newTemplate2) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                newTemplate2 = newTemplate;
            }
            $dirty2 |= i3;
        } else {
            newTemplate2 = newTemplate;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            function2 = function0;
        } else if (($changed & 896) == 0) {
            function2 = function0;
            $dirty2 |= $composer2.changedInstance(function2) ? 256 : 128;
        } else {
            function2 = function0;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            function3 = function1;
        } else if (($changed & 7168) == 0) {
            function3 = function1;
            $dirty2 |= $composer2.changedInstance(function3) ? 2048 : 1024;
        } else {
            function3 = function1;
        }
        if (($dirty2 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            commandTemplate3 = commandTemplate2;
            newTemplate3 = newTemplate2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i & 1) != 0) {
                    commandTemplate2 = new CommandTemplate(0, "", "");
                    $dirty2 &= -15;
                }
                if ((i & 2) != 0) {
                    newTemplate2 = commandTemplate2.getId() == 0;
                    $dirty2 &= -113;
                }
                if (i4 != 0) {
                    function2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt.CommandTemplateDialog.1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }
                    };
                }
                if (i5 != 0) {
                    c36202 = new Function1<Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt.CommandTemplateDialog.2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int it) {
                        }
                    };
                    $dirty = $dirty2;
                    function4 = function2;
                } else {
                    $dirty = $dirty2;
                    function4 = function2;
                    c36202 = function3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 1) != 0) {
                    $dirty2 &= -15;
                }
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                $dirty = $dirty2;
                function4 = function2;
                c36202 = function3;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(151951363, $dirty, -1, "com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialog (CommandTemplateDialog.kt:68)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localClipboardManager);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, -723523240, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2));
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final CoroutineScope scope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.startReplaceGroup(715024222);
            ComposerKt.sourceInformation($composer2, "CC(remember):CommandTemplateDialog.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(commandTemplate2.getTemplate(), null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState templateText$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(715024300);
            ComposerKt.sourceInformation($composer2, "CC(remember):CommandTemplateDialog.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(commandTemplate2.getName(), null, 2, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableState templateName$delegate = (MutableState) value$iv2;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(715024369);
            ComposerKt.sourceInformation($composer2, "CC(remember):CommandTemplateDialog.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final MutableState isError$delegate = (MutableState) value$iv3;
            $composer2.endReplaceGroup();
            DialogProperties dialogProperties = new DialogProperties(true, false, false, 4, (DefaultConstructorMarker) null);
            $composer2.startReplaceGroup(715024696);
            ComposerKt.sourceInformation($composer2, "CC(remember):CommandTemplateDialog.kt#9igjgp");
            boolean invalid$iv = ($dirty & 896) == 256;
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$CommandTemplateDialog$3$1
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
                        function4.invoke();
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            $composer2.endReplaceGroup();
            final boolean z = newTemplate2;
            final CommandTemplate commandTemplate4 = commandTemplate2;
            final Function1<? super Integer, Unit> function5 = c36202;
            final Function0<Unit> function6 = function4;
            Function0<Unit> function7 = function4;
            CommandTemplate commandTemplate5 = commandTemplate2;
            AndroidAlertDialog_androidKt.m1911AlertDialogOix01E0((Function0) value$iv4, ComposableLambdaKt.rememberComposableLambda(-785272645, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt.CommandTemplateDialog.4
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
                    ComposerKt.sourceInformation($composer3, "C85@4057L917:CommandTemplateDialog.kt#fk5gu5");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-785272645, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialog.<anonymous> (CommandTemplateDialog.kt:85)");
                        }
                        final CoroutineScope coroutineScope = scope;
                        final MutableState<String> mutableState = templateName$delegate;
                        final MutableState<Boolean> mutableState2 = isError$delegate;
                        final boolean z2 = z;
                        final CommandTemplate commandTemplate6 = commandTemplate4;
                        final Function1<Integer, Unit> function8 = function5;
                        final Function0<Unit> function9 = function6;
                        final MutableState<String> mutableState3 = templateText$delegate;
                        ButtonsKt.ConfirmButton(null, false, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt.CommandTemplateDialog.4.1
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
                                if (!StringsKt.isBlank(CommandTemplateDialogKt.CommandTemplateDialog$lambda$4(mutableState))) {
                                    if (!(CommandTemplateDialogKt.CommandTemplateDialog$lambda$4(mutableState).length() == 0)) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C46051(z2, commandTemplate6, function8, function9, mutableState, mutableState3, null), 3, null);
                                        return;
                                    }
                                }
                                CommandTemplateDialogKt.CommandTemplateDialog$lambda$8(mutableState2, true);
                            }

                            /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$CommandTemplateDialog$4$1$1, reason: invalid class name and collision with other inner class name */
                            /* JADX INFO: compiled from: CommandTemplateDialog.kt */
                            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                            @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$CommandTemplateDialog$4$1$1", m210f = "CommandTemplateDialog.kt", m211i = {}, m212l = {92, 97}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                            static final class C46051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ CommandTemplate $commandTemplate;
                                final /* synthetic */ Function1<Integer, Unit> $confirmationCallback;
                                final /* synthetic */ boolean $newTemplate;
                                final /* synthetic */ Function0<Unit> $onDismissRequest;
                                final /* synthetic */ MutableState<String> $templateName$delegate;
                                final /* synthetic */ MutableState<String> $templateText$delegate;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                C46051(boolean z, CommandTemplate commandTemplate, Function1<? super Integer, Unit> function1, Function0<Unit> function0, MutableState<String> mutableState, MutableState<String> mutableState2, Continuation<? super C46051> continuation) {
                                    super(2, continuation);
                                    this.$newTemplate = z;
                                    this.$commandTemplate = commandTemplate;
                                    this.$confirmationCallback = function1;
                                    this.$onDismissRequest = function0;
                                    this.$templateName$delegate = mutableState;
                                    this.$templateText$delegate = mutableState2;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C46051(this.$newTemplate, this.$commandTemplate, this.$confirmationCallback, this.$onDismissRequest, this.$templateName$delegate, this.$templateText$delegate, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((C46051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object $result) {
                                    C46051 c46051;
                                    C46051 c46052;
                                    int id;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result);
                                            c46051 = this;
                                            if (c46051.$newTemplate) {
                                                c46051.label = 1;
                                                Object objInsertTemplate = DatabaseUtil.INSTANCE.insertTemplate(new CommandTemplate(0, CommandTemplateDialogKt.CommandTemplateDialog$lambda$4(c46051.$templateName$delegate), CommandTemplateDialogKt.CommandTemplateDialog$lambda$1(c46051.$templateText$delegate)), c46051);
                                                if (objInsertTemplate == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                $result = objInsertTemplate;
                                                id = (int) ((Number) $result).longValue();
                                                c46051.$confirmationCallback.invoke(Boxing.boxInt(id));
                                                c46051.$onDismissRequest.invoke();
                                                return Unit.INSTANCE;
                                            }
                                            c46051.label = 2;
                                            if (DatabaseUtil.INSTANCE.updateTemplate(CommandTemplate.copy$default(c46051.$commandTemplate, 0, CommandTemplateDialogKt.CommandTemplateDialog$lambda$4(c46051.$templateName$delegate), CommandTemplateDialogKt.CommandTemplateDialog$lambda$1(c46051.$templateText$delegate), 1, null), c46051) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            c46052 = c46051;
                                            id = c46052.$commandTemplate.getId();
                                            c46051 = c46052;
                                            c46051.$confirmationCallback.invoke(Boxing.boxInt(id));
                                            c46051.$onDismissRequest.invoke();
                                            return Unit.INSTANCE;
                                        case 1:
                                            ResultKt.throwOnFailure($result);
                                            c46051 = this;
                                            id = (int) ((Number) $result).longValue();
                                            c46051.$confirmationCallback.invoke(Boxing.boxInt(id));
                                            c46051.$onDismissRequest.invoke();
                                            return Unit.INSTANCE;
                                        case 2:
                                            c46052 = this;
                                            ResultKt.throwOnFailure($result);
                                            id = c46052.$commandTemplate.getId();
                                            c46051 = c46052;
                                            c46051.$confirmationCallback.invoke(Boxing.boxInt(id));
                                            c46051.$onDismissRequest.invoke();
                                            return Unit.INSTANCE;
                                        default:
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                }
                            }
                        }, $composer3, 0, 3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), null, ComposableLambdaKt.rememberComposableLambda(-179497863, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt.CommandTemplateDialog.5
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
                    ComposerKt.sourceInformation($composer3, "C110@5024L109:CommandTemplateDialog.kt#fk5gu5");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-179497863, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialog.<anonymous> (CommandTemplateDialog.kt:110)");
                        }
                        ButtonKt.TextButton(function4, null, false, null, null, null, null, null, null, ComposableSingletons$CommandTemplateDialogKt.INSTANCE.m7450getLambda1$app_debug(), $composer3, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(123389528, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt.CommandTemplateDialog.6
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
                    ComposerKt.sourceInformation($composer3, "C76@3640L76:CommandTemplateDialog.kt#fk5gu5");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(123389528, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialog.<anonymous> (CommandTemplateDialog.kt:76)");
                    }
                    IconKt.m2292Iconww6aTOc(newTemplate2 ? AddKt.getAdd(Icons.Outlined.INSTANCE) : EditNoteKt.getEditNote(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer3, 48, 12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(426276919, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt.CommandTemplateDialog.7
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
                    ComposerKt.sourceInformation($composer3, "C79@3772L73,78@3750L109:CommandTemplateDialog.kt#fk5gu5");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(426276919, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialog.<anonymous> (CommandTemplateDialog.kt:78)");
                        }
                        TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(newTemplate2 ? C3070R.string.new_template : C3070R.string.edit, $composer3, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(729164310, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt.CommandTemplateDialog.8
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
                    Function0<ComposeUiNode> function8;
                    Object value$iv5;
                    ComposerKt.sourceInformation($composer3, "C115@5211L7,116@5296L7,120@5432L21,117@5316L1850:CommandTemplateDialog.kt#fk5gu5");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(729164310, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialog.<anonymous> (CommandTemplateDialog.kt:115)");
                        }
                        ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume3 = $composer3.consume(localFocusManager);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume4 = $composer3.consume(localSoftwareKeyboardController);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier$iv = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null);
                        final MutableState<String> mutableState = templateName$delegate;
                        final MutableState<Boolean> mutableState2 = isError$delegate;
                        final MutableState<String> mutableState3 = templateText$delegate;
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
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
                            function8 = constructor;
                            $composer3.createNode(function8);
                        } else {
                            function8 = constructor;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i6 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i7 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 531542063, "C123@5520L43,124@5607L10,122@5487L158,131@5886L105,126@5662L582,140@6301L7,140@6351L772,140@6261L862,157@7140L12:CommandTemplateDialog.kt#fk5gu5");
                        TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.edit_template_desc, $composer3, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyLarge(), $composer3, 0, 0, 65534);
                        Modifier modifierM872paddingqDBjuR0$default = PaddingKt.m872paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, C1979Dp.m6801constructorimpl(16), 0.0f, 0.0f, 13, null);
                        String strCommandTemplateDialog$lambda$4 = CommandTemplateDialogKt.CommandTemplateDialog$lambda$4(mutableState);
                        boolean zCommandTemplateDialog$lambda$7 = CommandTemplateDialogKt.CommandTemplateDialog$lambda$7(mutableState2);
                        KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6433getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                        $composer3.startReplaceGroup(531542462);
                        ComposerKt.sourceInformation($composer3, "CC(remember):CommandTemplateDialog.kt#9igjgp");
                        Object it$iv5 = $composer3.rememberedValue();
                        if (it$iv5 == Composer.INSTANCE.getEmpty()) {
                            value$iv5 = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$CommandTemplateDialog$8$1$1$1
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
                                    mutableState.setValue(it);
                                    CommandTemplateDialogKt.CommandTemplateDialog$lambda$8(mutableState2, false);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv5);
                        } else {
                            value$iv5 = it$iv5;
                        }
                        $composer3.endReplaceGroup();
                        OutlinedTextFieldKt.OutlinedTextField(strCommandTemplateDialog$lambda$4, (Function1<? super String, Unit>) value$iv5, modifierM872paddingqDBjuR0$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$CommandTemplateDialogKt.INSTANCE.m7451getLambda2$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, zCommandTemplateDialog$lambda$7, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer3, 1573296, 100859904, 0, 8085432);
                        ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume5 = $composer3.consume(localTextStyle);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        TextKt.ProvideTextStyle(((TextStyle) objConsume5).m6296mergedA7vx0o((16609105 & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : 0L, (16609105 & 2) != 0 ? TextUnit.INSTANCE.m7009getUnspecifiedXSAIIZE() : 0L, (16609105 & 4) != 0 ? null : null, (16609105 & 8) != 0 ? null : null, (16609105 & 16) != 0 ? null : null, (16609105 & 32) != 0 ? null : FontFamily.INSTANCE.getMonospace(), (16609105 & 64) != 0 ? null : null, (16609105 & 128) != 0 ? TextUnit.INSTANCE.m7009getUnspecifiedXSAIIZE() : 0L, (16609105 & 256) != 0 ? null : null, (16609105 & 512) != 0 ? null : null, (16609105 & 1024) != 0 ? null : null, (16609105 & 2048) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : 0L, (16609105 & 4096) != 0 ? null : null, (16609105 & 8192) != 0 ? null : null, (16609105 & 16384) != 0 ? null : null, (16609105 & 32768) != 0 ? TextAlign.INSTANCE.m6664getUnspecifiede0LSkKk() : 0, (16609105 & 65536) != 0 ? TextDirection.INSTANCE.m6677getUnspecifieds_7Xco() : 0, (16609105 & 131072) != 0 ? TextUnit.INSTANCE.m7009getUnspecifiedXSAIIZE() : 0L, (16609105 & 262144) != 0 ? null : null, (16609105 & 524288) != 0 ? null : null, (16609105 & 1048576) != 0 ? LineBreak.INSTANCE.m6591getUnspecifiedrAG3T2k() : 0, (16609105 & 2097152) != 0 ? Hyphens.INSTANCE.m6570getUnspecifiedvmbZdU8() : 0, (16609105 & 4194304) != 0 ? null : null, (16609105 & 8388608) != 0 ? null : null), ComposableLambdaKt.rememberComposableLambda(236510607, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$CommandTemplateDialog$8$1$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer4, int $changed3) {
                                Object value$iv6;
                                ComposerKt.sourceInformation($composer4, "C146@6622L21,147@6684L229,141@6373L732:CommandTemplateDialog.kt#fk5gu5");
                                if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(236510607, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialog.<anonymous>.<anonymous>.<anonymous> (CommandTemplateDialog.kt:141)");
                                    }
                                    Modifier modifierM870paddingVpY3zN4$default = PaddingKt.m870paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, C1979Dp.m6801constructorimpl(12), 1, null);
                                    String strCommandTemplateDialog$lambda$1 = CommandTemplateDialogKt.CommandTemplateDialog$lambda$1(mutableState3);
                                    $composer4.startReplaceGroup(2010355391);
                                    ComposerKt.sourceInformation($composer4, "CC(remember):CommandTemplateDialog.kt#9igjgp");
                                    final MutableState<String> mutableState4 = mutableState3;
                                    Object it$iv6 = $composer4.rememberedValue();
                                    if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                                        value$iv6 = new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$CommandTemplateDialog$8$1$2$1$1
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
                                                mutableState4.setValue(it);
                                            }
                                        };
                                        $composer4.updateRememberedValue(value$iv6);
                                    } else {
                                        value$iv6 = it$iv6;
                                    }
                                    $composer4.endReplaceGroup();
                                    Function2<Composer, Integer, Unit> function2M7452getLambda3$app_debug = ComposableSingletons$CommandTemplateDialogKt.INSTANCE.m7452getLambda3$app_debug();
                                    final MutableState<String> mutableState5 = mutableState3;
                                    OutlinedTextFieldKt.OutlinedTextField(strCommandTemplateDialog$lambda$1, (Function1<? super String, Unit>) value$iv6, modifierM870paddingVpY3zN4$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) function2M7452getLambda3$app_debug, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-37180616, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$CommandTemplateDialog$8$1$2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                            invoke(composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer $composer5, int $changed4) {
                                            Object value$iv7;
                                            Object value$iv8;
                                            ComposerKt.sourceInformation($composer5, "C:CommandTemplateDialog.kt#fk5gu5");
                                            if (($changed4 & 11) == 2 && $composer5.getSkipping()) {
                                                $composer5.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-37180616, $changed4, -1, "com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CommandTemplateDialog.kt:148)");
                                            }
                                            if (CommandTemplateDialogKt.CommandTemplateDialog$lambda$1(mutableState5).length() == 0) {
                                                $composer5.startReplaceGroup(614027256);
                                                ComposerKt.sourceInformation($composer5, "149@6799L21,149@6774L46");
                                                $composer5.startReplaceGroup(614027281);
                                                ComposerKt.sourceInformation($composer5, "CC(remember):CommandTemplateDialog.kt#9igjgp");
                                                final MutableState<String> mutableState6 = mutableState5;
                                                Object it$iv7 = $composer5.rememberedValue();
                                                if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                                                    value$iv8 = new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$CommandTemplateDialog$8$1$2$2$1$1
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
                                                            mutableState6.setValue(it);
                                                        }
                                                    };
                                                    $composer5.updateRememberedValue(value$iv8);
                                                } else {
                                                    value$iv8 = it$iv7;
                                                }
                                                $composer5.endReplaceGroup();
                                                IconButtonsKt.PasteFromClipBoardButton((Function1) value$iv8, $composer5, 6, 0);
                                                $composer5.endReplaceGroup();
                                            } else {
                                                $composer5.startReplaceGroup(614027336);
                                                ComposerKt.sourceInformation($composer5, "150@6866L21,150@6854L33");
                                                $composer5.startReplaceGroup(614027348);
                                                ComposerKt.sourceInformation($composer5, "CC(remember):CommandTemplateDialog.kt#9igjgp");
                                                final MutableState<String> mutableState7 = mutableState5;
                                                Object it$iv8 = $composer5.rememberedValue();
                                                if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                                                    value$iv7 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$CommandTemplateDialog$8$1$2$2$2$1
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
                                                            mutableState7.setValue("");
                                                        }
                                                    };
                                                    $composer5.updateRememberedValue(value$iv7);
                                                } else {
                                                    value$iv7 = it$iv8;
                                                }
                                                $composer5.endReplaceGroup();
                                                IconButtonsKt.ClearButton((Function0) value$iv7, $composer5, 6);
                                                $composer5.endReplaceGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, $composer4, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 12, 3, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer4, 806879664, 905969664, 0, 7601592);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), $composer3, 48);
                        ButtonsKt.LinkButton(null, null, null, null, $composer3, 0, 15);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, dialogProperties, $composer2, 1797168, 3072, 8068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            commandTemplate3 = commandTemplate5;
            newTemplate3 = newTemplate2;
            function3 = c36202;
            function2 = function7;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final CommandTemplate commandTemplate6 = commandTemplate3;
            final boolean z2 = newTemplate3;
            final Function0<Unit> function8 = function2;
            final Function1<? super Integer, Unit> function9 = function3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt.CommandTemplateDialog.9
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
                    CommandTemplateDialogKt.CommandTemplateDialog(commandTemplate6, z2, function8, function9, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CommandTemplateDialog$lambda$1(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CommandTemplateDialog$lambda$4(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CommandTemplateDialog$lambda$7(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CommandTemplateDialog$lambda$8(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    public static final void OptionChipsDialog(Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        final Function0<Unit> function1;
        Object value$iv$iv;
        Object value$iv;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(1940021902);
        ComposerKt.sourceInformation($composer3, "C(OptionChipsDialog)165@7308L24,166@7382L27,167@7426L31,231@10190L177,180@7947L2225,177@7752L2616:CommandTemplateDialog.kt#fk5gu5");
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
            final Function0<Unit> function2 = i2 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt.OptionChipsDialog.1
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
                ComposerKt.traceEventStart(1940021902, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.command.OptionChipsDialog (CommandTemplateDialog.kt:164)");
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
            final State shortcuts$delegate = SnapshotStateKt.collectAsState(DatabaseUtil.INSTANCE.getShortcuts(), CollectionsKt.emptyList(), null, $composer3, 56, 2);
            $composer3.startReplaceGroup(516758163);
            ComposerKt.sourceInformation($composer3, "CC(remember):CommandTemplateDialog.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState text$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            final Function0<Job> function3 = new Function0<Job>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$OptionChipsDialog$addShortCuts$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$OptionChipsDialog$addShortCuts$1$1 */
                /* JADX INFO: compiled from: CommandTemplateDialog.kt */
                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$OptionChipsDialog$addShortCuts$1$1", m210f = "CommandTemplateDialog.kt", m211i = {}, m212l = {173}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                static final class C36331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ State<List<OptionShortcut>> $shortcuts$delegate;
                    final /* synthetic */ MutableState<String> $text$delegate;
                    Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C36331(MutableState<String> mutableState, State<? extends List<OptionShortcut>> state, Continuation<? super C36331> continuation) {
                        super(2, continuation);
                        this.$text$delegate = mutableState;
                        this.$shortcuts$delegate = state;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C36331(this.$text$delegate, this.$shortcuts$delegate, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C36331) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Code duplicated, block: B:15:0x0058  */
                    /* JADX WARN: Code duplicated, block: B:17:0x0070 A[RETURN] */
                    /* JADX WARN: Code duplicated, block: B:18:0x0071  */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) {
                        MutableState<String> mutableState;
                        Object next;
                        DatabaseUtil databaseUtil;
                        OptionShortcut optionShortcut;
                        C36331 c36331;
                        MutableState<String> mutableState2;
                        C36331 c36332;
                        OptionShortcut it;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                String $this$invokeSuspend_u24lambda_u241 = StringsKt.removeSuffix(CommandTemplateDialogKt.OptionChipsDialog$lambda$12(this.$text$delegate), (CharSequence) " ");
                                State<List<OptionShortcut>> state = this.$shortcuts$delegate;
                                mutableState = this.$text$delegate;
                                Iterator it2 = CommandTemplateDialogKt.OptionChipsDialog$lambda$10(state).iterator();
                                do {
                                    if (it2.hasNext()) {
                                        next = it2.next();
                                        it = (OptionShortcut) next;
                                    } else {
                                        next = null;
                                    }
                                    if (next == null) {
                                        databaseUtil = DatabaseUtil.INSTANCE;
                                        optionShortcut = new OptionShortcut(0L, $this$invokeSuspend_u24lambda_u241, 1, (DefaultConstructorMarker) null);
                                        this.L$0 = mutableState;
                                        this.label = 1;
                                        if (databaseUtil.insertShortcut(optionShortcut, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        c36331 = this;
                                        mutableState2 = mutableState;
                                        c36332 = null;
                                        mutableState = mutableState2;
                                    }
                                    mutableState.setValue("");
                                    return Unit.INSTANCE;
                                } while (!Intrinsics.areEqual(it.getOption(), $this$invokeSuspend_u24lambda_u241));
                                if (next == null) {
                                    databaseUtil = DatabaseUtil.INSTANCE;
                                    optionShortcut = new OptionShortcut(0L, $this$invokeSuspend_u24lambda_u241, 1, (DefaultConstructorMarker) null);
                                    this.L$0 = mutableState;
                                    this.label = 1;
                                    if (databaseUtil.insertShortcut(optionShortcut, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    c36331 = this;
                                    mutableState2 = mutableState;
                                    c36332 = null;
                                    mutableState = mutableState2;
                                }
                                mutableState.setValue("");
                                return Unit.INSTANCE;
                            case 1:
                                c36331 = this;
                                c36332 = null;
                                mutableState2 = (MutableState) c36331.L$0;
                                ResultKt.throwOnFailure($result);
                                mutableState = mutableState2;
                                mutableState.setValue("");
                                return Unit.INSTANCE;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public final Job invoke() {
                    return BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C36331(text$delegate, shortcuts$delegate, null), 3, null);
                }
            };
            Function0<Unit> function4 = function2;
            $composer2 = $composer3;
            DialogsKt.m7298LoopDialogOix01E0(null, function4, ComposableLambdaKt.rememberComposableLambda(-478256343, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt.OptionChipsDialog.2
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
                    ComposerKt.sourceInformation($composer4, "C232@10204L153:CommandTemplateDialog.kt#fk5gu5");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-478256343, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.command.OptionChipsDialog.<anonymous> (CommandTemplateDialog.kt:232)");
                        }
                        ButtonKt.TextButton(function2, null, false, null, null, null, null, null, null, ComposableSingletons$CommandTemplateDialogKt.INSTANCE.m7453getLambda4$app_debug(), $composer4, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), null, ComposableSingletons$CommandTemplateDialogKt.INSTANCE.m7454getLambda5$app_debug(), ComposableSingletons$CommandTemplateDialogKt.INSTANCE.m7455getLambda6$app_debug(), ComposableLambdaKt.rememberComposableLambda(-338960595, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt.OptionChipsDialog.3
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
                    Function0<ComposeUiNode> function5;
                    Function0<ComposeUiNode> function6;
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer4, "C181@7961L2200:CommandTemplateDialog.kt#fk5gu5");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-338960595, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.command.OptionChipsDialog.<anonymous> (CommandTemplateDialog.kt:181)");
                        }
                        final State<List<OptionShortcut>> state = shortcuts$delegate;
                        final CoroutineScope coroutineScope = scope;
                        final MutableState<String> mutableState = text$delegate;
                        final Function0<Job> function7 = function3;
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
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
                            function5 = constructor;
                            $composer4.createNode(function5);
                        } else {
                            function5 = constructor;
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
                        ComposerKt.sourceInformationMarkerStart($composer4, -1834969979, "C183@8019L44,184@8107L10,182@7986L303,193@8497L21,194@8560L21,189@8306L816,208@9176L7,209@9265L7,227@10090L39,216@9509L13,217@9559L116,211@9290L857:CommandTemplateDialog.kt#fk5gu5");
                        TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.edit_shortcuts_desc, $composer4, 0), PaddingKt.m870paddingVpY3zN4$default(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(12), 7, null), C1979Dp.m6801constructorimpl(24), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyMedium(), $composer4, 48, 0, 65532);
                        Modifier modifier$iv2 = ScrollKt.verticalScroll$default(ScrollKt.horizontalScroll$default(SizeKt.m902requiredHeight3ABfNKs(PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(16), 0.0f, 2, null), C1979Dp.m6801constructorimpl(400)), ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, null, false, 14, null), ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, null, false, 14, null);
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                            function6 = constructor2;
                            $composer4.createNode(function6);
                        } else {
                            function6 = constructor2;
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
                        int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                        int i6 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1844759389, "C196@8666L438,196@8623L481:CommandTemplateDialog.kt#fk5gu5");
                        FlowKt.m7167FlowRow07r0xoM(SizeKt.m918width3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(400)), null, null, 0.0f, null, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-379457773, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$OptionChipsDialog$3$1$1$1
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

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C*198@8748L308:CommandTemplateDialog.kt#fk5gu5");
                                if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-379457773, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.command.OptionChipsDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CommandTemplateDialog.kt:197)");
                                    }
                                    Iterable $this$forEach$iv = CommandTemplateDialogKt.OptionChipsDialog$lambda$10(state);
                                    final CoroutineScope coroutineScope2 = coroutineScope;
                                    for (Object element$iv : $this$forEach$iv) {
                                        final OptionShortcut item = (OptionShortcut) element$iv;
                                        ChipsKt.ShortcutChip(null, item.getOption(), null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$OptionChipsDialog$3$1$1$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public /* bridge */ /* synthetic */ Unit invoke() {
                                                invoke2();
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$OptionChipsDialog$3$1$1$1$1$1$1 */
                                            /* JADX INFO: compiled from: CommandTemplateDialog.kt */
                                            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                            @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$OptionChipsDialog$3$1$1$1$1$1$1", m210f = "CommandTemplateDialog.kt", m211i = {}, m212l = {203}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                            static final class C36311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ OptionShortcut $item;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                C36311(OptionShortcut optionShortcut, Continuation<? super C36311> continuation) {
                                                    super(2, continuation);
                                                    this.$item = optionShortcut;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new C36311(this.$item, continuation);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                    return ((C36311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object $result) {
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    switch (this.label) {
                                                        case 0:
                                                            ResultKt.throwOnFailure($result);
                                                            this.label = 1;
                                                            if (DatabaseUtil.INSTANCE.deleteShortcut(this.$item, this) == coroutine_suspended) {
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

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2() {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C36311(item, null), 3, null);
                                            }
                                        }, $composer5, 0, 5);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54), $composer4, 12582918, WebSocketProtocol.PAYLOAD_SHORT);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume = $composer4.consume(localFocusManager);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        final FocusManager focusManager = (FocusManager) objConsume;
                        ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = $composer4.consume(localSoftwareKeyboardController);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        final SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) objConsume2;
                        Modifier modifierM870paddingVpY3zN4$default = PaddingKt.m870paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(24), 0.0f, 2, null);
                        String strOptionChipsDialog$lambda$12 = CommandTemplateDialogKt.OptionChipsDialog$lambda$12(mutableState);
                        KeyboardActions keyboardActions = new KeyboardActions(new Function1<KeyboardActionScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$OptionChipsDialog$3$1$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                function7.invoke();
                                SoftwareKeyboardController softwareKeyboardController2 = softwareKeyboardController;
                                if (softwareKeyboardController2 != null) {
                                    softwareKeyboardController2.hide();
                                }
                                focusManager.mo3976moveFocus3ESFkO8(FocusDirection.INSTANCE.m3967getDowndhqQ8s());
                            }
                        }, null, null, null, null, null, 62, null);
                        KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6433getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.shortcuts, $composer4, 0);
                        $composer4.startReplaceGroup(-1834968456);
                        ComposerKt.sourceInformation($composer4, "CC(remember):CommandTemplateDialog.kt#9igjgp");
                        Object it$iv2 = $composer4.rememberedValue();
                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$OptionChipsDialog$3$1$3$1
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
                                    mutableState.setValue(it);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        $composer4.endReplaceGroup();
                        TextFieldKt.LoopTextField(strOptionChipsDialog$lambda$12, (Function1) value$iv2, modifierM870paddingVpY3zN4$default, false, false, null, strStringResource, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1893294646, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$OptionChipsDialog$3$1$4
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

                            public final void invoke(Composer $composer5, int $changed3) {
                                Object value$iv3;
                                ComposerKt.sourceInformation($composer5, "C218@9605L18,218@9585L68:CommandTemplateDialog.kt#fk5gu5");
                                if (($changed3 & 11) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1893294646, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.command.OptionChipsDialog.<anonymous>.<anonymous>.<anonymous> (CommandTemplateDialog.kt:218)");
                                }
                                $composer5.startReplaceGroup(-1844758407);
                                ComposerKt.sourceInformation($composer5, "CC(remember):CommandTemplateDialog.kt#9igjgp");
                                boolean invalid$iv = $composer5.changed(function7);
                                final Function0<Job> function8 = function7;
                                Object it$iv3 = $composer5.rememberedValue();
                                if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt$OptionChipsDialog$3$1$4$1$1
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
                                            function8.invoke();
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv3);
                                } else {
                                    value$iv3 = it$iv3;
                                }
                                Function0 function9 = (Function0) value$iv3;
                                $composer5.endReplaceGroup();
                                IconButtonsKt.AddButton(function9, CommandTemplateDialogKt.OptionChipsDialog$lambda$12(mutableState).length() > 0, $composer5, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), null, null, null, false, null, keyboardOptions, keyboardActions, false, 2, 0, null, null, null, $composer4, 432, 806879238, 0, 16055224);
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
            function1 = function4;
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.CommandTemplateDialogKt.OptionChipsDialog.4
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
                    CommandTemplateDialogKt.OptionChipsDialog(function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<OptionShortcut> OptionChipsDialog$lambda$10(State<? extends List<OptionShortcut>> state) {
        Object thisObj$iv = state.getValue();
        return (List) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String OptionChipsDialog$lambda$12(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }
}
