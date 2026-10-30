package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.p006ui.common.Route;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.p007io.encoding.Base64;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TextFieldPressGestureFilter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1", m210f = "TextFieldPressGestureFilter.kt", m211i = {}, m212l = {54}, m213m = "invokeSuspend", m214n = {}, m215s = {})
final class TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ State<Function1<Offset, Unit>> $onTapState;
    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
    final /* synthetic */ CoroutineScope $scope;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1(CoroutineScope coroutineScope, MutableState<PressInteraction.Press> mutableState, MutableInteractionSource mutableInteractionSource, State<? extends Function1<? super Offset, Unit>> state, Continuation<? super TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1> continuation) {
        super(2, continuation);
        this.$scope = coroutineScope;
        this.$pressedInteraction = mutableState;
        this.$interactionSource = mutableInteractionSource;
        this.$onTapState = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1 textFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1 = new TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1(this.$scope, this.$pressedInteraction, this.$interactionSource, this.$onTapState, continuation);
        textFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1.L$0 = obj;
        return textFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                C07731 c07731 = new C07731(this.$scope, this.$pressedInteraction, this.$interactionSource, null);
                final State<Function1<Offset, Unit>> state = this.$onTapState;
                this.label = 1;
                if (TapGestureDetectorKt.detectTapAndPress($this$pointerInput, c07731, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                        m1255invokek4lQ0M(offset.getPackedValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                    public final void m1255invokek4lQ0M(long it) {
                        state.getValue().invoke(Offset.m4038boximpl(it));
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1 */
    /* JADX INFO: compiled from: TextFieldPressGestureFilter.kt */
    @Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1", m210f = "TextFieldPressGestureFilter.kt", m211i = {}, m212l = {67}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C07731 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
        final /* synthetic */ CoroutineScope $scope;
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07731(CoroutineScope coroutineScope, MutableState<PressInteraction.Press> mutableState, MutableInteractionSource mutableInteractionSource, Continuation<? super C07731> continuation) {
            super(3, continuation);
            this.$scope = coroutineScope;
            this.$pressedInteraction = mutableState;
            this.$interactionSource = mutableInteractionSource;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
            return m1254invoked4ec7I(pressGestureScope, offset.getPackedValue(), continuation);
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m1254invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
            C07731 c07731 = new C07731(this.$scope, this.$pressedInteraction, this.$interactionSource, continuation);
            c07731.L$0 = pressGestureScope;
            c07731.J$0 = j;
            return c07731.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldPressGestureFilter.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1$1", m210f = "TextFieldPressGestureFilter.kt", m211i = {1}, m212l = {60, 64}, m213m = "invokeSuspend", m214n = {Route.INTERACTION}, m215s = {"L$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ MutableInteractionSource $interactionSource;
            final /* synthetic */ long $it;
            final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
            Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MutableState<PressInteraction.Press> mutableState, long j, MutableInteractionSource mutableInteractionSource, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$pressedInteraction = mutableState;
                this.$it = j;
                this.$interactionSource = mutableInteractionSource;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$pressedInteraction, this.$it, this.$interactionSource, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:20:0x0066  */
            /* JADX WARN: Code duplicated, block: B:22:0x0077 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:23:0x0078  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                AnonymousClass1 anonymousClass1;
                MutableState<PressInteraction.Press> mutableState;
                MutableState<PressInteraction.Press> mutableState2;
                int i;
                PressInteraction.Press interaction;
                MutableInteractionSource mutableInteractionSource;
                AnonymousClass1 anonymousClass2;
                PressInteraction.Press interaction2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        anonymousClass1 = this;
                        PressInteraction.Press oldValue = anonymousClass1.$pressedInteraction.getValue();
                        if (oldValue != null) {
                            MutableInteractionSource mutableInteractionSource2 = anonymousClass1.$interactionSource;
                            mutableState = anonymousClass1.$pressedInteraction;
                            PressInteraction.Cancel interaction3 = new PressInteraction.Cancel(oldValue);
                            if (mutableInteractionSource2 != null) {
                                anonymousClass1.L$0 = mutableState;
                                anonymousClass1.label = 1;
                                if (mutableInteractionSource2.emit(interaction3, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                mutableState2 = mutableState;
                                i = 0;
                                mutableState = mutableState2;
                            }
                            mutableState.setValue(null);
                            interaction = new PressInteraction.Press(anonymousClass1.$it, null);
                            mutableInteractionSource = anonymousClass1.$interactionSource;
                            if (mutableInteractionSource != null) {
                                anonymousClass1.L$0 = interaction;
                                anonymousClass1.label = 2;
                                if (mutableInteractionSource.emit(interaction, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                anonymousClass2 = anonymousClass1;
                                interaction2 = interaction;
                                interaction = interaction2;
                                anonymousClass1 = anonymousClass2;
                            }
                        } else {
                            interaction = new PressInteraction.Press(anonymousClass1.$it, null);
                            mutableInteractionSource = anonymousClass1.$interactionSource;
                            if (mutableInteractionSource != null) {
                                anonymousClass1.L$0 = interaction;
                                anonymousClass1.label = 2;
                                if (mutableInteractionSource.emit(interaction, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                anonymousClass2 = anonymousClass1;
                                interaction2 = interaction;
                                interaction = interaction2;
                                anonymousClass1 = anonymousClass2;
                            }
                        }
                        anonymousClass1.$pressedInteraction.setValue(interaction);
                        return Unit.INSTANCE;
                    case 1:
                        anonymousClass1 = this;
                        i = 0;
                        mutableState2 = (MutableState) anonymousClass1.L$0;
                        ResultKt.throwOnFailure($result);
                        mutableState = mutableState2;
                        mutableState.setValue(null);
                        interaction = new PressInteraction.Press(anonymousClass1.$it, null);
                        mutableInteractionSource = anonymousClass1.$interactionSource;
                        if (mutableInteractionSource != null) {
                            anonymousClass1.L$0 = interaction;
                            anonymousClass1.label = 2;
                            if (mutableInteractionSource.emit(interaction, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            anonymousClass2 = anonymousClass1;
                            interaction2 = interaction;
                            interaction = interaction2;
                            anonymousClass1 = anonymousClass2;
                        }
                        anonymousClass1.$pressedInteraction.setValue(interaction);
                        return Unit.INSTANCE;
                    case 2:
                        anonymousClass2 = this;
                        interaction2 = (PressInteraction.Press) anonymousClass2.L$0;
                        ResultKt.throwOnFailure($result);
                        interaction = interaction2;
                        anonymousClass1 = anonymousClass2;
                        anonymousClass1.$pressedInteraction.setValue(interaction);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C07731 c07731;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c07731 = this;
                    PressGestureScope $this$detectTapAndPress = (PressGestureScope) c07731.L$0;
                    long it = c07731.J$0;
                    BuildersKt__Builders_commonKt.launch$default(c07731.$scope, null, null, new AnonymousClass1(c07731.$pressedInteraction, it, c07731.$interactionSource, null), 3, null);
                    c07731.label = 1;
                    Object objTryAwaitRelease = $this$detectTapAndPress.tryAwaitRelease(c07731);
                    if (objTryAwaitRelease == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objTryAwaitRelease;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    c07731 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean success = ((Boolean) $result).booleanValue();
            BuildersKt__Builders_commonKt.launch$default(c07731.$scope, null, null, new AnonymousClass2(c07731.$pressedInteraction, success, c07731.$interactionSource, null), 3, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldPressGestureFilter.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1$2", m210f = "TextFieldPressGestureFilter.kt", m211i = {}, m212l = {Base64.mimeLineLength}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ MutableInteractionSource $interactionSource;
            final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
            final /* synthetic */ boolean $success;
            Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(MutableState<PressInteraction.Press> mutableState, boolean z, MutableInteractionSource mutableInteractionSource, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$pressedInteraction = mutableState;
                this.$success = z;
                this.$interactionSource = mutableInteractionSource;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$pressedInteraction, this.$success, this.$interactionSource, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                MutableState<PressInteraction.Press> mutableState;
                PressInteraction cancel;
                AnonymousClass2 anonymousClass2;
                MutableState<PressInteraction.Press> mutableState2;
                AnonymousClass2 anonymousClass3;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        PressInteraction.Press oldValue = this.$pressedInteraction.getValue();
                        if (oldValue != null) {
                            boolean z = this.$success;
                            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                            mutableState = this.$pressedInteraction;
                            if (z) {
                                cancel = new PressInteraction.Release(oldValue);
                            } else {
                                cancel = new PressInteraction.Cancel(oldValue);
                            }
                            PressInteraction interaction = cancel;
                            if (mutableInteractionSource != null) {
                                this.L$0 = mutableState;
                                this.label = 1;
                                if (mutableInteractionSource.emit(interaction, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                anonymousClass2 = this;
                                mutableState2 = mutableState;
                                anonymousClass3 = null;
                                mutableState = mutableState2;
                            }
                            mutableState.setValue(null);
                        }
                        return Unit.INSTANCE;
                    case 1:
                        anonymousClass2 = this;
                        anonymousClass3 = null;
                        mutableState2 = (MutableState) anonymousClass2.L$0;
                        ResultKt.throwOnFailure($result);
                        mutableState = mutableState2;
                        mutableState.setValue(null);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }
}
