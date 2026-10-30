package androidx.compose.foundation;

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
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: Clickable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.foundation.AbstractClickableNode$handlePressInteraction$2$1", m210f = "Clickable.kt", m211i = {0, 1, 2}, m212l = {1129, 1131, 1138, 1139, 1148}, m213m = "invokeSuspend", m214n = {"delayJob", "success", "release"}, m215s = {"L$0", "Z$0", "L$0"})
final class AbstractClickableNode$handlePressInteraction$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $offset;
    final /* synthetic */ PressGestureScope $this_handlePressInteraction;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ AbstractClickableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AbstractClickableNode$handlePressInteraction$2$1(PressGestureScope pressGestureScope, long j, MutableInteractionSource mutableInteractionSource, AbstractClickableNode abstractClickableNode, Continuation<? super AbstractClickableNode$handlePressInteraction$2$1> continuation) {
        super(2, continuation);
        this.$this_handlePressInteraction = pressGestureScope;
        this.$offset = j;
        this.$interactionSource = mutableInteractionSource;
        this.this$0 = abstractClickableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AbstractClickableNode$handlePressInteraction$2$1 abstractClickableNode$handlePressInteraction$2$1 = new AbstractClickableNode$handlePressInteraction$2$1(this.$this_handlePressInteraction, this.$offset, this.$interactionSource, this.this$0, continuation);
        abstractClickableNode$handlePressInteraction$2$1.L$0 = obj;
        return abstractClickableNode$handlePressInteraction$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AbstractClickableNode$handlePressInteraction$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0080  */
    /* JADX WARN: Code duplicated, block: B:19:0x0090 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0091  */
    /* JADX WARN: Code duplicated, block: B:22:0x0097  */
    /* JADX WARN: Code duplicated, block: B:24:0x00b6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:28:0x00cb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:31:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:32:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:34:0x00db  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ff A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x0100  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Job delayJob;
        AbstractClickableNode$handlePressInteraction$2$1 abstractClickableNode$handlePressInteraction$2$1;
        boolean success;
        PressInteraction.Press pressInteraction;
        MutableInteractionSource mutableInteractionSource;
        PressInteraction endInteraction;
        AbstractClickableNode$handlePressInteraction$2$1 abstractClickableNode$handlePressInteraction$2$2;
        boolean success2;
        AbstractClickableNode$handlePressInteraction$2$1 abstractClickableNode$handlePressInteraction$2$3;
        PressInteraction.Press press;
        PressInteraction.Release release;
        PressInteraction.Release release2;
        AbstractClickableNode$handlePressInteraction$2$1 abstractClickableNode$handlePressInteraction$2$4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                Job delayJob2 = BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, null, new AbstractClickableNode$handlePressInteraction$2$1$delayJob$1(this.this$0, this.$offset, this.$interactionSource, null), 3, null);
                this.L$0 = delayJob2;
                this.label = 1;
                Object objTryAwaitRelease = this.$this_handlePressInteraction.tryAwaitRelease(this);
                if (objTryAwaitRelease == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result = objTryAwaitRelease;
                delayJob = delayJob2;
                abstractClickableNode$handlePressInteraction$2$1 = this;
                success = ((Boolean) $result).booleanValue();
                if (delayJob.isActive()) {
                    abstractClickableNode$handlePressInteraction$2$1.L$0 = null;
                    abstractClickableNode$handlePressInteraction$2$1.Z$0 = success;
                    abstractClickableNode$handlePressInteraction$2$1.label = 2;
                    if (JobKt.cancelAndJoin(delayJob, abstractClickableNode$handlePressInteraction$2$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    AbstractClickableNode$handlePressInteraction$2$1 abstractClickableNode$handlePressInteraction$2$5 = abstractClickableNode$handlePressInteraction$2$1;
                    success2 = success;
                    abstractClickableNode$handlePressInteraction$2$3 = abstractClickableNode$handlePressInteraction$2$5;
                    if (success2) {
                        $result = $result;
                        press = new PressInteraction.Press(abstractClickableNode$handlePressInteraction$2$3.$offset, null);
                        release = new PressInteraction.Release(press);
                        abstractClickableNode$handlePressInteraction$2$3.L$0 = release;
                        abstractClickableNode$handlePressInteraction$2$3.label = 3;
                        if (abstractClickableNode$handlePressInteraction$2$3.$interactionSource.emit(press, abstractClickableNode$handlePressInteraction$2$3) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        release2 = release;
                        abstractClickableNode$handlePressInteraction$2$3.L$0 = null;
                        abstractClickableNode$handlePressInteraction$2$3.label = 4;
                        if (abstractClickableNode$handlePressInteraction$2$3.$interactionSource.emit(release2, abstractClickableNode$handlePressInteraction$2$3) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        abstractClickableNode$handlePressInteraction$2$4 = abstractClickableNode$handlePressInteraction$2$3;
                        abstractClickableNode$handlePressInteraction$2$1 = abstractClickableNode$handlePressInteraction$2$4;
                    } else {
                        $result = $result;
                        abstractClickableNode$handlePressInteraction$2$1 = abstractClickableNode$handlePressInteraction$2$3;
                    }
                } else {
                    pressInteraction = abstractClickableNode$handlePressInteraction$2$1.this$0.pressInteraction;
                    if (pressInteraction != null) {
                        mutableInteractionSource = abstractClickableNode$handlePressInteraction$2$1.$interactionSource;
                        if (success) {
                            endInteraction = new PressInteraction.Release(pressInteraction);
                        } else {
                            endInteraction = new PressInteraction.Cancel(pressInteraction);
                        }
                        abstractClickableNode$handlePressInteraction$2$1.L$0 = null;
                        abstractClickableNode$handlePressInteraction$2$1.label = 5;
                        if (mutableInteractionSource.emit(endInteraction, abstractClickableNode$handlePressInteraction$2$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = $result;
                        abstractClickableNode$handlePressInteraction$2$2 = abstractClickableNode$handlePressInteraction$2$1;
                        abstractClickableNode$handlePressInteraction$2$1 = abstractClickableNode$handlePressInteraction$2$2;
                    }
                }
                abstractClickableNode$handlePressInteraction$2$1.this$0.pressInteraction = null;
                return Unit.INSTANCE;
            case 1:
                Job delayJob3 = (Job) this.L$0;
                ResultKt.throwOnFailure($result);
                delayJob = delayJob3;
                abstractClickableNode$handlePressInteraction$2$1 = this;
                success = ((Boolean) $result).booleanValue();
                if (delayJob.isActive()) {
                    abstractClickableNode$handlePressInteraction$2$1.L$0 = null;
                    abstractClickableNode$handlePressInteraction$2$1.Z$0 = success;
                    abstractClickableNode$handlePressInteraction$2$1.label = 2;
                    if (JobKt.cancelAndJoin(delayJob, abstractClickableNode$handlePressInteraction$2$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    AbstractClickableNode$handlePressInteraction$2$1 abstractClickableNode$handlePressInteraction$2$6 = abstractClickableNode$handlePressInteraction$2$1;
                    success2 = success;
                    abstractClickableNode$handlePressInteraction$2$3 = abstractClickableNode$handlePressInteraction$2$6;
                    if (success2) {
                        $result = $result;
                        press = new PressInteraction.Press(abstractClickableNode$handlePressInteraction$2$3.$offset, null);
                        release = new PressInteraction.Release(press);
                        abstractClickableNode$handlePressInteraction$2$3.L$0 = release;
                        abstractClickableNode$handlePressInteraction$2$3.label = 3;
                        if (abstractClickableNode$handlePressInteraction$2$3.$interactionSource.emit(press, abstractClickableNode$handlePressInteraction$2$3) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        release2 = release;
                        abstractClickableNode$handlePressInteraction$2$3.L$0 = null;
                        abstractClickableNode$handlePressInteraction$2$3.label = 4;
                        if (abstractClickableNode$handlePressInteraction$2$3.$interactionSource.emit(release2, abstractClickableNode$handlePressInteraction$2$3) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        abstractClickableNode$handlePressInteraction$2$4 = abstractClickableNode$handlePressInteraction$2$3;
                        abstractClickableNode$handlePressInteraction$2$1 = abstractClickableNode$handlePressInteraction$2$4;
                    } else {
                        $result = $result;
                        abstractClickableNode$handlePressInteraction$2$1 = abstractClickableNode$handlePressInteraction$2$3;
                    }
                } else {
                    pressInteraction = abstractClickableNode$handlePressInteraction$2$1.this$0.pressInteraction;
                    if (pressInteraction != null) {
                        mutableInteractionSource = abstractClickableNode$handlePressInteraction$2$1.$interactionSource;
                        if (success) {
                            endInteraction = new PressInteraction.Release(pressInteraction);
                        } else {
                            endInteraction = new PressInteraction.Cancel(pressInteraction);
                        }
                        abstractClickableNode$handlePressInteraction$2$1.L$0 = null;
                        abstractClickableNode$handlePressInteraction$2$1.label = 5;
                        if (mutableInteractionSource.emit(endInteraction, abstractClickableNode$handlePressInteraction$2$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = $result;
                        abstractClickableNode$handlePressInteraction$2$2 = abstractClickableNode$handlePressInteraction$2$1;
                        abstractClickableNode$handlePressInteraction$2$1 = abstractClickableNode$handlePressInteraction$2$2;
                    }
                }
                abstractClickableNode$handlePressInteraction$2$1.this$0.pressInteraction = null;
                return Unit.INSTANCE;
            case 2:
                abstractClickableNode$handlePressInteraction$2$3 = this;
                success2 = abstractClickableNode$handlePressInteraction$2$3.Z$0;
                ResultKt.throwOnFailure($result);
                if (success2) {
                    $result = $result;
                    press = new PressInteraction.Press(abstractClickableNode$handlePressInteraction$2$3.$offset, null);
                    release = new PressInteraction.Release(press);
                    abstractClickableNode$handlePressInteraction$2$3.L$0 = release;
                    abstractClickableNode$handlePressInteraction$2$3.label = 3;
                    if (abstractClickableNode$handlePressInteraction$2$3.$interactionSource.emit(press, abstractClickableNode$handlePressInteraction$2$3) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    release2 = release;
                    abstractClickableNode$handlePressInteraction$2$3.L$0 = null;
                    abstractClickableNode$handlePressInteraction$2$3.label = 4;
                    if (abstractClickableNode$handlePressInteraction$2$3.$interactionSource.emit(release2, abstractClickableNode$handlePressInteraction$2$3) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    abstractClickableNode$handlePressInteraction$2$4 = abstractClickableNode$handlePressInteraction$2$3;
                    abstractClickableNode$handlePressInteraction$2$1 = abstractClickableNode$handlePressInteraction$2$4;
                } else {
                    $result = $result;
                    abstractClickableNode$handlePressInteraction$2$1 = abstractClickableNode$handlePressInteraction$2$3;
                }
                abstractClickableNode$handlePressInteraction$2$1.this$0.pressInteraction = null;
                return Unit.INSTANCE;
            case 3:
                abstractClickableNode$handlePressInteraction$2$3 = this;
                release2 = (PressInteraction.Release) abstractClickableNode$handlePressInteraction$2$3.L$0;
                ResultKt.throwOnFailure($result);
                abstractClickableNode$handlePressInteraction$2$3.L$0 = null;
                abstractClickableNode$handlePressInteraction$2$3.label = 4;
                if (abstractClickableNode$handlePressInteraction$2$3.$interactionSource.emit(release2, abstractClickableNode$handlePressInteraction$2$3) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                abstractClickableNode$handlePressInteraction$2$4 = abstractClickableNode$handlePressInteraction$2$3;
                abstractClickableNode$handlePressInteraction$2$1 = abstractClickableNode$handlePressInteraction$2$4;
                abstractClickableNode$handlePressInteraction$2$1.this$0.pressInteraction = null;
                return Unit.INSTANCE;
            case 4:
                abstractClickableNode$handlePressInteraction$2$4 = this;
                ResultKt.throwOnFailure($result);
                abstractClickableNode$handlePressInteraction$2$1 = abstractClickableNode$handlePressInteraction$2$4;
                abstractClickableNode$handlePressInteraction$2$1.this$0.pressInteraction = null;
                return Unit.INSTANCE;
            case 5:
                abstractClickableNode$handlePressInteraction$2$2 = this;
                ResultKt.throwOnFailure($result);
                abstractClickableNode$handlePressInteraction$2$1 = abstractClickableNode$handlePressInteraction$2$2;
                abstractClickableNode$handlePressInteraction$2$1.this$0.pressInteraction = null;
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
