package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.p001ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.p001ui.platform.PlatformTextInputSession;
import androidx.compose.p001ui.text.TextRange;
import androidx.compose.p001ui.text.input.ImeAction;
import androidx.compose.p001ui.text.input.ImeOptions;
import androidx.compose.p001ui.text.input.KeyboardType;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: compiled from: AndroidTextInputSession.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0002\u001ab\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\n\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001fH\u0081@¢\u0006\u0002\u0010 \u001a\\\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\n\u0018\u00010\u001a2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001fH\u0080@¢\u0006\u0002\u0010!\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, m195d2 = {"ALL_MIME_TYPES", "", "", "[Ljava/lang/String;", "TIA_DEBUG", "", "getTIA_DEBUG$annotations", "()V", "TIA_TAG", "logDebug", "", "tag", "content", "Lkotlin/Function0;", "platformSpecificTextInputSession", "", "Landroidx/compose/ui/platform/PlatformTextInputSession;", "state", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "layoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "receiveContentConfiguration", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "onImeAction", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/ImeAction;", "composeImm", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "stylusHandwritingTrigger", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "(Landroidx/compose/ui/platform/PlatformTextInputSession;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/compose/ui/platform/PlatformTextInputSession;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidTextInputSession_androidKt {
    private static final String[] ALL_MIME_TYPES = {"*/*"};
    public static final boolean TIA_DEBUG = false;
    private static final String TIA_TAG = "AndroidTextInputSession";

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1 */
    /* JADX INFO: compiled from: AndroidTextInputSession.android.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt", m210f = "AndroidTextInputSession.android.kt", m211i = {}, m212l = {50}, m213m = "platformSpecificTextInputSession", m214n = {}, m215s = {})
    static final class C07891 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07891(Continuation<? super C07891> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidTextInputSession_androidKt.platformSpecificTextInputSession(null, null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2 */
    /* JADX INFO: compiled from: AndroidTextInputSession.android.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt", m210f = "AndroidTextInputSession.android.kt", m211i = {}, m212l = {71}, m213m = "platformSpecificTextInputSession", m214n = {}, m215s = {})
    static final class C07902 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07902(Continuation<? super C07902> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidTextInputSession_androidKt.platformSpecificTextInputSession(null, null, null, null, null, null, null, null, this);
        }
    }

    public static /* synthetic */ void getTIA_DEBUG$annotations() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object platformSpecificTextInputSession(PlatformTextInputSession $this$platformSpecificTextInputSession, TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, ImeOptions imeOptions, ReceiveContentConfiguration receiveContentConfiguration, Function1<? super ImeAction, Unit> function1, MutableSharedFlow<Unit> mutableSharedFlow, Continuation<?> continuation) {
        C07891 c07891;
        if (continuation instanceof C07891) {
            c07891 = (C07891) continuation;
            if ((c07891.label & Integer.MIN_VALUE) != 0) {
                c07891.label -= Integer.MIN_VALUE;
            } else {
                c07891 = new C07891(continuation);
            }
        } else {
            c07891 = new C07891(continuation);
        }
        C07891 c07892 = c07891;
        Object $result = c07892.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c07892.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ComposeInputMethodManager ComposeInputMethodManager = ComposeInputMethodManager_androidKt.ComposeInputMethodManager($this$platformSpecificTextInputSession.getView());
                c07892.label = 1;
                if (platformSpecificTextInputSession($this$platformSpecificTextInputSession, transformedTextFieldState, textLayoutState, imeOptions, receiveContentConfiguration, function1, ComposeInputMethodManager, mutableSharedFlow, c07892) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Object platformSpecificTextInputSession$default(PlatformTextInputSession platformTextInputSession, TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, ImeOptions imeOptions, ReceiveContentConfiguration receiveContentConfiguration, Function1 function1, MutableSharedFlow mutableSharedFlow, Continuation continuation, int i, Object obj) {
        MutableSharedFlow mutableSharedFlow2;
        if ((i & 32) == 0) {
            mutableSharedFlow2 = mutableSharedFlow;
        } else {
            mutableSharedFlow2 = null;
        }
        return platformSpecificTextInputSession(platformTextInputSession, transformedTextFieldState, textLayoutState, imeOptions, receiveContentConfiguration, function1, mutableSharedFlow2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object platformSpecificTextInputSession(PlatformTextInputSession $this$platformSpecificTextInputSession, TransformedTextFieldState state, TextLayoutState layoutState, ImeOptions imeOptions, ReceiveContentConfiguration receiveContentConfiguration, Function1<? super ImeAction, Unit> function1, ComposeInputMethodManager composeImm, MutableSharedFlow<Unit> mutableSharedFlow, Continuation<?> continuation) {
        C07902 c07902;
        if (continuation instanceof C07902) {
            c07902 = (C07902) continuation;
            if ((c07902.label & Integer.MIN_VALUE) != 0) {
                c07902.label -= Integer.MIN_VALUE;
            } else {
                c07902 = new C07902(continuation);
            }
        } else {
            c07902 = new C07902(continuation);
        }
        C07902 c07903 = c07902;
        Object $result = c07903.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c07903.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                C07913 c07913 = new C07913(mutableSharedFlow, state, layoutState, composeImm, $this$platformSpecificTextInputSession, imeOptions, receiveContentConfiguration, function1, null);
                c07903.label = 1;
                if (CoroutineScopeKt.coroutineScope(c07913, c07903) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3 */
    /* JADX INFO: compiled from: AndroidTextInputSession.android.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3", m210f = "AndroidTextInputSession.android.kt", m211i = {}, m212l = {112}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C07913 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ ComposeInputMethodManager $composeImm;
        final /* synthetic */ ImeOptions $imeOptions;
        final /* synthetic */ TextLayoutState $layoutState;
        final /* synthetic */ Function1<ImeAction, Unit> $onImeAction;
        final /* synthetic */ ReceiveContentConfiguration $receiveContentConfiguration;
        final /* synthetic */ TransformedTextFieldState $state;
        final /* synthetic */ MutableSharedFlow<Unit> $stylusHandwritingTrigger;
        final /* synthetic */ PlatformTextInputSession $this_platformSpecificTextInputSession;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07913(MutableSharedFlow<Unit> mutableSharedFlow, TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, ComposeInputMethodManager composeInputMethodManager, PlatformTextInputSession platformTextInputSession, ImeOptions imeOptions, ReceiveContentConfiguration receiveContentConfiguration, Function1<? super ImeAction, Unit> function1, Continuation<? super C07913> continuation) {
            super(2, continuation);
            this.$stylusHandwritingTrigger = mutableSharedFlow;
            this.$state = transformedTextFieldState;
            this.$layoutState = textLayoutState;
            this.$composeImm = composeInputMethodManager;
            this.$this_platformSpecificTextInputSession = platformTextInputSession;
            this.$imeOptions = imeOptions;
            this.$receiveContentConfiguration = receiveContentConfiguration;
            this.$onImeAction = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07913 c07913 = new C07913(this.$stylusHandwritingTrigger, this.$state, this.$layoutState, this.$composeImm, this.$this_platformSpecificTextInputSession, this.$imeOptions, this.$receiveContentConfiguration, this.$onImeAction, continuation);
            c07913.L$0 = obj;
            return c07913;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            return ((C07913) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: AndroidTextInputSession.android.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$1", m210f = "AndroidTextInputSession.android.kt", m211i = {}, m212l = {73}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ComposeInputMethodManager $composeImm;
            final /* synthetic */ ImeOptions $imeOptions;
            final /* synthetic */ TransformedTextFieldState $state;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TransformedTextFieldState transformedTextFieldState, ComposeInputMethodManager composeInputMethodManager, ImeOptions imeOptions, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$state = transformedTextFieldState;
                this.$composeImm = composeInputMethodManager;
                this.$imeOptions = imeOptions;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$state, this.$composeImm, this.$imeOptions, continuation);
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
                        TransformedTextFieldState transformedTextFieldState = this.$state;
                        final ComposeInputMethodManager composeInputMethodManager = this.$composeImm;
                        final ImeOptions imeOptions = this.$imeOptions;
                        this.label = 1;
                        if (transformedTextFieldState.collectImeNotifications(new TextFieldState.NotifyImeListener() { // from class: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$1$$ExternalSyntheticLambda0
                            @Override // androidx.compose.foundation.text.input.TextFieldState.NotifyImeListener
                            public final void onChange(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z) {
                                AndroidTextInputSession_androidKt.C07913.AnonymousClass1.invokeSuspend$lambda$0(composeInputMethodManager, imeOptions, textFieldCharSequence, textFieldCharSequence2, z);
                            }
                        }, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                throw new KotlinNothingValueException();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invokeSuspend$lambda$0(ComposeInputMethodManager $composeImm, ImeOptions $imeOptions, TextFieldCharSequence oldValue, TextFieldCharSequence newValue, boolean restartImeIfContentChanges) {
                long oldSelection = oldValue.getSelection();
                long newSelection = newValue.getSelection();
                TextRange oldComposition = oldValue.getComposition();
                TextRange newComposition = newValue.getComposition();
                if (!TextRange.m6244equalsimpl0(oldSelection, newSelection) || !Intrinsics.areEqual(oldComposition, newComposition)) {
                    $composeImm.updateSelection(TextRange.m6249getMinimpl(newSelection), TextRange.m6248getMaximpl(newSelection), newComposition != null ? TextRange.m6249getMinimpl(newComposition.getPackedValue()) : -1, newComposition != null ? TextRange.m6248getMaximpl(newComposition.getPackedValue()) : -1);
                }
                if (restartImeIfContentChanges && !oldValue.contentEquals(newValue) && !KeyboardType.m6472equalsimpl0($imeOptions.getKeyboardType(), KeyboardType.INSTANCE.m6491getPasswordPjHm6EE())) {
                    $composeImm.restartInput();
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this.$state, this.$composeImm, this.$imeOptions, null), 1, null);
                    MutableSharedFlow<Unit> mutableSharedFlow = this.$stylusHandwritingTrigger;
                    if (mutableSharedFlow != null) {
                        BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new C0794x2b7eadeb(mutableSharedFlow, this.$composeImm, null), 1, null);
                    }
                    final CursorAnchorInfoController cursorUpdatesController = new CursorAnchorInfoController(this.$state, this.$layoutState, this.$composeImm, $this$coroutineScope);
                    PlatformTextInputSession platformTextInputSession = this.$this_platformSpecificTextInputSession;
                    final TransformedTextFieldState transformedTextFieldState = this.$state;
                    final ImeOptions imeOptions = this.$imeOptions;
                    final ReceiveContentConfiguration receiveContentConfiguration = this.$receiveContentConfiguration;
                    final ComposeInputMethodManager composeInputMethodManager = this.$composeImm;
                    final Function1<ImeAction, Unit> function1 = this.$onImeAction;
                    this.label = 1;
                    if (platformTextInputSession.startInputMethod(new PlatformTextInputMethodRequest() { // from class: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$$ExternalSyntheticLambda0
                        @Override // androidx.compose.p001ui.platform.PlatformTextInputMethodRequest
                        public final InputConnection createInputConnection(EditorInfo editorInfo) {
                            return AndroidTextInputSession_androidKt.C07913.invokeSuspend$lambda$2(transformedTextFieldState, imeOptions, receiveContentConfiguration, composeInputMethodManager, function1, cursorUpdatesController, editorInfo);
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            throw new KotlinNothingValueException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InputConnection invokeSuspend$lambda$2(final TransformedTextFieldState $state, ImeOptions $imeOptions, final ReceiveContentConfiguration $receiveContentConfiguration, final ComposeInputMethodManager $composeImm, final Function1 $onImeAction, final CursorAnchorInfoController $cursorUpdatesController, EditorInfo outAttrs) {
            AndroidTextInputSession_androidKt.logDebug$default(null, new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "createInputConnection(value=\"" + ((Object) $state.getVisualText()) + "\")";
                }
            }, 1, null);
            TextInputSession textInputSession = new TextInputSession() { // from class: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1
                @Override // androidx.compose.foundation.text.input.internal.TextInputSession
                public TextFieldCharSequence getText() {
                    return $state.getVisualText();
                }

                @Override // androidx.compose.foundation.text.input.internal.TextInputSession
                public void requestEdit(Function1<? super EditingBuffer, Unit> block) {
                    TransformedTextFieldState this_$iv = $state;
                    TextFieldState $this$iv$iv = this_$iv.textFieldState;
                    InputTransformation inputTransformation$iv$iv = this_$iv.inputTransformation;
                    TextFieldEditUndoBehavior undoBehavior$iv$iv = TextFieldEditUndoBehavior.MergeIfPossible;
                    TextFieldCharSequence previousValue$iv$iv = $this$iv$iv.getValue$foundation_release();
                    $this$iv$iv.getMainBuffer().getChangeTracker().clearChanges();
                    block.invoke($this$iv$iv.getMainBuffer());
                    if ($this$iv$iv.getMainBuffer().getChangeTracker().getChangeCount() != 0 || !TextRange.m6244equalsimpl0(previousValue$iv$iv.getSelection(), $this$iv$iv.getMainBuffer().m1308getSelectiond9O1mEE()) || !Intrinsics.areEqual(previousValue$iv$iv.getComposition(), $this$iv$iv.getMainBuffer().m1307getCompositionMzsxiRA())) {
                        $this$iv$iv.commitEditAsUser(previousValue$iv$iv, inputTransformation$iv$iv, false, undoBehavior$iv$iv);
                    }
                }

                @Override // androidx.compose.foundation.text.input.internal.TextInputSession
                public void sendKeyEvent(KeyEvent keyEvent) {
                    $composeImm.sendKeyEvent(keyEvent);
                }

                @Override // androidx.compose.foundation.text.input.internal.TextInputSession
                /* JADX INFO: renamed from: onImeAction-KlQnJC8, reason: not valid java name */
                public void mo1304onImeActionKlQnJC8(int imeAction) {
                    Function1<ImeAction, Unit> function1 = $onImeAction;
                    if (function1 != null) {
                        function1.invoke(ImeAction.m6416boximpl(imeAction));
                    }
                }

                @Override // androidx.compose.foundation.text.input.internal.TextInputSession
                public boolean onCommitContent(TransferableContent transferableContent) {
                    ReceiveContentConfiguration receiveContentConfiguration = $receiveContentConfiguration;
                    if (receiveContentConfiguration != null) {
                        return receiveContentConfiguration.onCommitContent(transferableContent);
                    }
                    return false;
                }

                @Override // androidx.compose.foundation.text.input.internal.TextInputSession
                public void requestCursorUpdates(int cursorUpdateMode) {
                    $cursorUpdatesController.requestUpdates(cursorUpdateMode);
                }
            };
            EditorInfo_androidKt.m1310updatepLxbY9I(outAttrs, $state.getVisualText(), $state.getVisualText().getSelection(), $imeOptions, $receiveContentConfiguration != null ? AndroidTextInputSession_androidKt.ALL_MIME_TYPES : null);
            return new StatelessInputConnection(textInputSession, outAttrs);
        }
    }

    static /* synthetic */ void logDebug$default(String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = TIA_TAG;
        }
        logDebug(str, function0);
    }

    private static final void logDebug(String tag, Function0<String> function0) {
    }
}
