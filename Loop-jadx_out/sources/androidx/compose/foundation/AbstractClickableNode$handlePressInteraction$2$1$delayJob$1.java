package androidx.compose.foundation;

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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: Clickable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.foundation.AbstractClickableNode$handlePressInteraction$2$1$delayJob$1", m210f = "Clickable.kt", m211i = {1}, m212l = {1123, 1126}, m213m = "invokeSuspend", m214n = {"press"}, m215s = {"L$0"})
final class AbstractClickableNode$handlePressInteraction$2$1$delayJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $offset;
    Object L$0;
    int label;
    final /* synthetic */ AbstractClickableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AbstractClickableNode$handlePressInteraction$2$1$delayJob$1(AbstractClickableNode abstractClickableNode, long j, MutableInteractionSource mutableInteractionSource, Continuation<? super AbstractClickableNode$handlePressInteraction$2$1$delayJob$1> continuation) {
        super(2, continuation);
        this.this$0 = abstractClickableNode;
        this.$offset = j;
        this.$interactionSource = mutableInteractionSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AbstractClickableNode$handlePressInteraction$2$1$delayJob$1(this.this$0, this.$offset, this.$interactionSource, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AbstractClickableNode$handlePressInteraction$2$1$delayJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0059 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:17:0x005a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        AbstractClickableNode$handlePressInteraction$2$1$delayJob$1 abstractClickableNode$handlePressInteraction$2$1$delayJob$1;
        PressInteraction.Press press;
        AbstractClickableNode$handlePressInteraction$2$1$delayJob$1 abstractClickableNode$handlePressInteraction$2$1$delayJob$2;
        PressInteraction.Press press2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                abstractClickableNode$handlePressInteraction$2$1$delayJob$1 = this;
                if (abstractClickableNode$handlePressInteraction$2$1$delayJob$1.this$0.delayPressInteraction()) {
                    abstractClickableNode$handlePressInteraction$2$1$delayJob$1.label = 1;
                    if (DelayKt.delay(Clickable_androidKt.getTapIndicationDelay(), abstractClickableNode$handlePressInteraction$2$1$delayJob$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                press = new PressInteraction.Press(abstractClickableNode$handlePressInteraction$2$1$delayJob$1.$offset, null);
                abstractClickableNode$handlePressInteraction$2$1$delayJob$1.L$0 = press;
                abstractClickableNode$handlePressInteraction$2$1$delayJob$1.label = 2;
                if (abstractClickableNode$handlePressInteraction$2$1$delayJob$1.$interactionSource.emit(press, abstractClickableNode$handlePressInteraction$2$1$delayJob$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                abstractClickableNode$handlePressInteraction$2$1$delayJob$2 = abstractClickableNode$handlePressInteraction$2$1$delayJob$1;
                press2 = press;
                abstractClickableNode$handlePressInteraction$2$1$delayJob$2.this$0.pressInteraction = press2;
                return Unit.INSTANCE;
            case 1:
                abstractClickableNode$handlePressInteraction$2$1$delayJob$1 = this;
                ResultKt.throwOnFailure($result);
                press = new PressInteraction.Press(abstractClickableNode$handlePressInteraction$2$1$delayJob$1.$offset, null);
                abstractClickableNode$handlePressInteraction$2$1$delayJob$1.L$0 = press;
                abstractClickableNode$handlePressInteraction$2$1$delayJob$1.label = 2;
                if (abstractClickableNode$handlePressInteraction$2$1$delayJob$1.$interactionSource.emit(press, abstractClickableNode$handlePressInteraction$2$1$delayJob$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                abstractClickableNode$handlePressInteraction$2$1$delayJob$2 = abstractClickableNode$handlePressInteraction$2$1$delayJob$1;
                press2 = press;
                abstractClickableNode$handlePressInteraction$2$1$delayJob$2.this$0.pressInteraction = press2;
                return Unit.INSTANCE;
            case 2:
                abstractClickableNode$handlePressInteraction$2$1$delayJob$2 = this;
                press2 = (PressInteraction.Press) abstractClickableNode$handlePressInteraction$2$1$delayJob$2.L$0;
                ResultKt.throwOnFailure($result);
                abstractClickableNode$handlePressInteraction$2$1$delayJob$2.this$0.pressInteraction = press2;
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
