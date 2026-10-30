package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TextFieldSelectionState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$4$1$1", m210f = "TextFieldSelectionState.kt", m211i = {}, m212l = {491, 498}, m213m = "invokeSuspend", m214n = {}, m215s = {})
final class TextFieldSelectionState$detectTextFieldTapGestures$4$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PressGestureScope $$this$detectTapAndDoubleTap;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $offset;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$detectTextFieldTapGestures$4$1$1(PressGestureScope pressGestureScope, TextFieldSelectionState textFieldSelectionState, long j, MutableInteractionSource mutableInteractionSource, Continuation<? super TextFieldSelectionState$detectTextFieldTapGestures$4$1$1> continuation) {
        super(2, continuation);
        this.$$this$detectTapAndDoubleTap = pressGestureScope;
        this.this$0 = textFieldSelectionState;
        this.$offset = j;
        this.$interactionSource = mutableInteractionSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TextFieldSelectionState$detectTextFieldTapGestures$4$1$1 textFieldSelectionState$detectTextFieldTapGestures$4$1$1 = new TextFieldSelectionState$detectTextFieldTapGestures$4$1$1(this.$$this$detectTapAndDoubleTap, this.this$0, this.$offset, this.$interactionSource, continuation);
        textFieldSelectionState$detectTextFieldTapGestures$4$1$1.L$0 = obj;
        return textFieldSelectionState$detectTextFieldTapGestures$4$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TextFieldSelectionState$detectTextFieldTapGestures$4$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$4$1$1$1 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$4$1$1$1", m210f = "TextFieldSelectionState.kt", m211i = {1}, m212l = {483, 488}, m213m = "invokeSuspend", m214n = {"press"}, m215s = {"L$0"})
    static final class C08621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ long $offset;
        Object L$0;
        int label;
        final /* synthetic */ TextFieldSelectionState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08621(TextFieldSelectionState textFieldSelectionState, long j, MutableInteractionSource mutableInteractionSource, Continuation<? super C08621> continuation) {
            super(2, continuation);
            this.this$0 = textFieldSelectionState;
            this.$offset = j;
            this.$interactionSource = mutableInteractionSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08621(this.this$0, this.$offset, this.$interactionSource, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x006e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:18:0x006f  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C08621 c08621;
            TextFieldSelectionState textFieldSelectionState;
            PressInteraction.Press press;
            C08621 c08622;
            PressInteraction.Press press2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c08621 = this;
                    PressInteraction.Press oldValue = c08621.this$0.pressInteraction;
                    if (oldValue != null) {
                        MutableInteractionSource mutableInteractionSource = c08621.$interactionSource;
                        TextFieldSelectionState textFieldSelectionState2 = c08621.this$0;
                        PressInteraction.Cancel interaction = new PressInteraction.Cancel(oldValue);
                        c08621.L$0 = textFieldSelectionState2;
                        c08621.label = 1;
                        if (mutableInteractionSource.emit(interaction, c08621) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        textFieldSelectionState = textFieldSelectionState2;
                        textFieldSelectionState.pressInteraction = null;
                    }
                    press = new PressInteraction.Press(c08621.$offset, null);
                    c08621.L$0 = press;
                    c08621.label = 2;
                    if (c08621.$interactionSource.emit(press, c08621) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c08622 = c08621;
                    press2 = press;
                    c08622.this$0.pressInteraction = press2;
                    return Unit.INSTANCE;
                case 1:
                    c08621 = this;
                    textFieldSelectionState = (TextFieldSelectionState) c08621.L$0;
                    ResultKt.throwOnFailure($result);
                    textFieldSelectionState.pressInteraction = null;
                    press = new PressInteraction.Press(c08621.$offset, null);
                    c08621.L$0 = press;
                    c08621.label = 2;
                    if (c08621.$interactionSource.emit(press, c08621) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c08622 = c08621;
                    press2 = press;
                    c08622.this$0.pressInteraction = press2;
                    return Unit.INSTANCE;
                case 2:
                    c08622 = this;
                    press2 = (PressInteraction.Press) c08622.L$0;
                    ResultKt.throwOnFailure($result);
                    c08622.this$0.pressInteraction = press2;
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0060  */
    /* JADX WARN: Code duplicated, block: B:16:0x0066  */
    /* JADX WARN: Code duplicated, block: B:17:0x006e  */
    /* JADX WARN: Code duplicated, block: B:20:0x0082 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0083  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        TextFieldSelectionState$detectTextFieldTapGestures$4$1$1 textFieldSelectionState$detectTextFieldTapGestures$4$1$1;
        boolean success;
        PressInteraction.Press pressInteraction;
        MutableInteractionSource mutableInteractionSource;
        PressInteraction endInteraction;
        TextFieldSelectionState$detectTextFieldTapGestures$4$1$1 textFieldSelectionState$detectTextFieldTapGestures$4$1$2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, null, new C08621(this.this$0, this.$offset, this.$interactionSource, null), 3, null);
                this.label = 1;
                Object objTryAwaitRelease = this.$$this$detectTapAndDoubleTap.tryAwaitRelease(this);
                if (objTryAwaitRelease == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result = objTryAwaitRelease;
                textFieldSelectionState$detectTextFieldTapGestures$4$1$1 = this;
                success = ((Boolean) $result).booleanValue();
                pressInteraction = textFieldSelectionState$detectTextFieldTapGestures$4$1$1.this$0.pressInteraction;
                if (pressInteraction != null) {
                    mutableInteractionSource = textFieldSelectionState$detectTextFieldTapGestures$4$1$1.$interactionSource;
                    if (success) {
                        endInteraction = new PressInteraction.Release(pressInteraction);
                    } else {
                        endInteraction = new PressInteraction.Cancel(pressInteraction);
                    }
                    textFieldSelectionState$detectTextFieldTapGestures$4$1$1.label = 2;
                    if (mutableInteractionSource.emit(endInteraction, textFieldSelectionState$detectTextFieldTapGestures$4$1$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = $result;
                    textFieldSelectionState$detectTextFieldTapGestures$4$1$2 = textFieldSelectionState$detectTextFieldTapGestures$4$1$1;
                    textFieldSelectionState$detectTextFieldTapGestures$4$1$1 = textFieldSelectionState$detectTextFieldTapGestures$4$1$2;
                }
                textFieldSelectionState$detectTextFieldTapGestures$4$1$1.this$0.pressInteraction = null;
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                textFieldSelectionState$detectTextFieldTapGestures$4$1$1 = this;
                success = ((Boolean) $result).booleanValue();
                pressInteraction = textFieldSelectionState$detectTextFieldTapGestures$4$1$1.this$0.pressInteraction;
                if (pressInteraction != null) {
                    mutableInteractionSource = textFieldSelectionState$detectTextFieldTapGestures$4$1$1.$interactionSource;
                    if (success) {
                        endInteraction = new PressInteraction.Release(pressInteraction);
                    } else {
                        endInteraction = new PressInteraction.Cancel(pressInteraction);
                    }
                    textFieldSelectionState$detectTextFieldTapGestures$4$1$1.label = 2;
                    if (mutableInteractionSource.emit(endInteraction, textFieldSelectionState$detectTextFieldTapGestures$4$1$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = $result;
                    textFieldSelectionState$detectTextFieldTapGestures$4$1$2 = textFieldSelectionState$detectTextFieldTapGestures$4$1$1;
                    textFieldSelectionState$detectTextFieldTapGestures$4$1$1 = textFieldSelectionState$detectTextFieldTapGestures$4$1$2;
                }
                textFieldSelectionState$detectTextFieldTapGestures$4$1$1.this$0.pressInteraction = null;
                return Unit.INSTANCE;
            case 2:
                textFieldSelectionState$detectTextFieldTapGestures$4$1$2 = this;
                ResultKt.throwOnFailure($result);
                textFieldSelectionState$detectTextFieldTapGestures$4$1$1 = textFieldSelectionState$detectTextFieldTapGestures$4$1$2;
                textFieldSelectionState$detectTextFieldTapGestures$4$1$1.this$0.pressInteraction = null;
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
