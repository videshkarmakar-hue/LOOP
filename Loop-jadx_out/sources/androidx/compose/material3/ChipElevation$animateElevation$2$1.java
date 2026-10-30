package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.material3.internal.ElevationKt;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.MutableState;
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

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.material3.ChipElevation$animateElevation$2$1", m210f = "Chip.kt", m211i = {}, m212l = {2159, 2161}, m213m = "invokeSuspend", m214n = {}, m215s = {})
final class ChipElevation$animateElevation$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<C1979Dp, AnimationVector1D> $animatable;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Interaction $interaction;
    final /* synthetic */ MutableState<Interaction> $lastInteraction$delegate;
    final /* synthetic */ float $target;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChipElevation$animateElevation$2$1(Animatable<C1979Dp, AnimationVector1D> animatable, float f, boolean z, Interaction interaction, MutableState<Interaction> mutableState, Continuation<? super ChipElevation$animateElevation$2$1> continuation) {
        super(2, continuation);
        this.$animatable = animatable;
        this.$target = f;
        this.$enabled = z;
        this.$interaction = interaction;
        this.$lastInteraction$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChipElevation$animateElevation$2$1(this.$animatable, this.$target, this.$enabled, this.$interaction, this.$lastInteraction$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChipElevation$animateElevation$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        ChipElevation$animateElevation$2$1 chipElevation$animateElevation$2$1;
        ChipElevation$animateElevation$2$1 chipElevation$animateElevation$2$2;
        ChipElevation$animateElevation$2$1 chipElevation$animateElevation$2$3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!C1979Dp.m6806equalsimpl0(this.$animatable.getTargetValue().m6815unboximpl(), this.$target)) {
                    if (this.$enabled) {
                        Interaction interactionAnimateElevation$lambda$2 = ChipElevation.animateElevation$lambda$2(this.$lastInteraction$delegate);
                        this.label = 2;
                        if (ElevationKt.m3013animateElevationrAjV9yQ(this.$animatable, this.$target, interactionAnimateElevation$lambda$2, this.$interaction, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        chipElevation$animateElevation$2$1 = this;
                        chipElevation$animateElevation$2$3 = chipElevation$animateElevation$2$1;
                        chipElevation$animateElevation$2$3.$lastInteraction$delegate.setValue(chipElevation$animateElevation$2$3.$interaction);
                    } else {
                        this.label = 1;
                        if (this.$animatable.snapTo(C1979Dp.m6799boximpl(this.$target), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        chipElevation$animateElevation$2$2 = this;
                        chipElevation$animateElevation$2$3 = chipElevation$animateElevation$2$2;
                        chipElevation$animateElevation$2$3.$lastInteraction$delegate.setValue(chipElevation$animateElevation$2$3.$interaction);
                    }
                }
                return Unit.INSTANCE;
            case 1:
                chipElevation$animateElevation$2$2 = this;
                ResultKt.throwOnFailure($result);
                chipElevation$animateElevation$2$3 = chipElevation$animateElevation$2$2;
                chipElevation$animateElevation$2$3.$lastInteraction$delegate.setValue(chipElevation$animateElevation$2$3.$interaction);
                return Unit.INSTANCE;
            case 2:
                chipElevation$animateElevation$2$1 = this;
                ResultKt.throwOnFailure($result);
                chipElevation$animateElevation$2$3 = chipElevation$animateElevation$2$1;
                chipElevation$animateElevation$2$3.$lastInteraction$delegate.setValue(chipElevation$animateElevation$2$3.$interaction);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
