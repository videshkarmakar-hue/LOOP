package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.p006ui.common.Route;
import com.videshkarmakar.loop.util.NotificationUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: Label.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.material3.LabelKt$HandleInteractions$1$1", m210f = "Label.kt", m211i = {}, m212l = {NotificationUtil.SERVICE_NOTIFICATION_ID}, m213m = "invokeSuspend", m214n = {}, m215s = {})
final class LabelKt$HandleInteractions$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ BasicTooltipState $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LabelKt$HandleInteractions$1$1(MutableInteractionSource mutableInteractionSource, BasicTooltipState basicTooltipState, Continuation<? super LabelKt$HandleInteractions$1$1> continuation) {
        super(2, continuation);
        this.$interactionSource = mutableInteractionSource;
        this.$state = basicTooltipState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LabelKt$HandleInteractions$1$1(this.$interactionSource, this.$state, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LabelKt$HandleInteractions$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: androidx.compose.material3.LabelKt$HandleInteractions$1$1$1 */
    /* JADX INFO: compiled from: Label.kt */
    @Metadata(m194d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m195d2 = {"<anonymous>", "", Route.INTERACTION, "Landroidx/compose/foundation/interaction/Interaction;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.material3.LabelKt$HandleInteractions$1$1$1", m210f = "Label.kt", m211i = {}, m212l = {127}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C13811 extends SuspendLambda implements Function2<Interaction, Continuation<? super Unit>, Object> {
        final /* synthetic */ BasicTooltipState $state;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13811(BasicTooltipState basicTooltipState, Continuation<? super C13811> continuation) {
            super(2, continuation);
            this.$state = basicTooltipState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13811 c13811 = new C13811(this.$state, continuation);
            c13811.L$0 = obj;
            return c13811;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Interaction interaction, Continuation<? super Unit> continuation) {
            return ((C13811) create(interaction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C13811 c13811;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Interaction interaction = (Interaction) this.L$0;
                    if (interaction instanceof PressInteraction.Press ? true : interaction instanceof DragInteraction.Start ? true : interaction instanceof HoverInteraction.Enter) {
                        this.label = 1;
                        if (this.$state.show(MutatePriority.UserInput, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c13811 = this;
                    } else {
                        if (interaction instanceof PressInteraction.Release ? true : interaction instanceof DragInteraction.Stop ? true : interaction instanceof HoverInteraction.Exit) {
                            this.$state.dismiss();
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    c13811 = this;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (FlowKt.collectLatest(this.$interactionSource.getInteractions(), new C13811(this.$state, null), this) == coroutine_suspended) {
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
