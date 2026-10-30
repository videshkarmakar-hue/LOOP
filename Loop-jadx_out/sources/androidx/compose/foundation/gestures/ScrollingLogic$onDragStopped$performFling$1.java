package androidx.compose.foundation.gestures;

import androidx.compose.p001ui.unit.Velocity;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, m195d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "velocity"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1", m210f = "Scrollable.kt", m211i = {0, 1, 1, 2, 2}, m212l = {742, 745, 748}, m213m = "invokeSuspend", m214n = {"velocity", "velocity", "available", "velocity", "velocityLeft"}, m215s = {"J$0", "J$0", "J$1", "J$0", "J$1"})
final class ScrollingLogic$onDragStopped$performFling$1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
    /* synthetic */ long J$0;
    long J$1;
    int label;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollingLogic$onDragStopped$performFling$1(ScrollingLogic scrollingLogic, Continuation<? super ScrollingLogic$onDragStopped$performFling$1> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1 = new ScrollingLogic$onDragStopped$performFling$1(this.this$0, continuation);
        scrollingLogic$onDragStopped$performFling$1.J$0 = ((Velocity) obj).getPackedValue();
        return scrollingLogic$onDragStopped$performFling$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Velocity velocity, Continuation<? super Velocity> continuation) {
        return m687invokesFctU(velocity.getPackedValue(), continuation);
    }

    /* JADX INFO: renamed from: invoke-sF-c-tU, reason: not valid java name */
    public final Object m687invokesFctU(long j, Continuation<? super Velocity> continuation) {
        return ((ScrollingLogic$onDragStopped$performFling$1) create(Velocity.m7033boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0082 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:16:0x0083  */
    /* JADX WARN: Code duplicated, block: B:19:0x00ab A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x00ac  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1;
        Object $result2;
        Object $result3;
        long velocity;
        long available;
        Object objM675doFlingAnimationQWom1Mo;
        Object $result4;
        long velocityLeft;
        Object objM5391dispatchPostFlingRZ2iAVY;
        Object $result5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                scrollingLogic$onDragStopped$performFling$1 = this;
                long velocity2 = scrollingLogic$onDragStopped$performFling$1.J$0;
                scrollingLogic$onDragStopped$performFling$1.J$0 = velocity2;
                scrollingLogic$onDragStopped$performFling$1.label = 1;
                Object objM5393dispatchPreFlingQWom1Mo = scrollingLogic$onDragStopped$performFling$1.this$0.nestedScrollDispatcher.m5393dispatchPreFlingQWom1Mo(velocity2, scrollingLogic$onDragStopped$performFling$1);
                if (objM5393dispatchPreFlingQWom1Mo == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result3 = objM5393dispatchPreFlingQWom1Mo;
                velocity = velocity2;
                long preConsumedByParent = ((Velocity) $result3).getPackedValue();
                available = Velocity.m7045minusAH228Gc(velocity, preConsumedByParent);
                scrollingLogic$onDragStopped$performFling$1.J$0 = velocity;
                scrollingLogic$onDragStopped$performFling$1.J$1 = available;
                scrollingLogic$onDragStopped$performFling$1.label = 2;
                objM675doFlingAnimationQWom1Mo = scrollingLogic$onDragStopped$performFling$1.this$0.m675doFlingAnimationQWom1Mo(available, scrollingLogic$onDragStopped$performFling$1);
                if (objM675doFlingAnimationQWom1Mo == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result4 = objM675doFlingAnimationQWom1Mo;
                long velocityLeft2 = ((Velocity) $result4).getPackedValue();
                scrollingLogic$onDragStopped$performFling$1.J$0 = velocity;
                scrollingLogic$onDragStopped$performFling$1.J$1 = velocityLeft2;
                scrollingLogic$onDragStopped$performFling$1.label = 3;
                velocityLeft = velocityLeft2;
                objM5391dispatchPostFlingRZ2iAVY = scrollingLogic$onDragStopped$performFling$1.this$0.nestedScrollDispatcher.m5391dispatchPostFlingRZ2iAVY(Velocity.m7045minusAH228Gc(available, velocityLeft2), velocityLeft2, scrollingLogic$onDragStopped$performFling$1);
                if (objM5391dispatchPostFlingRZ2iAVY == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result5 = objM5391dispatchPostFlingRZ2iAVY;
                long consumedPost = ((Velocity) $result5).getPackedValue();
                long totalLeft = Velocity.m7045minusAH228Gc(velocityLeft, consumedPost);
                return Velocity.m7033boximpl(Velocity.m7045minusAH228Gc(velocity, totalLeft));
            case 1:
                scrollingLogic$onDragStopped$performFling$1 = this;
                $result3 = $result;
                long velocity3 = scrollingLogic$onDragStopped$performFling$1.J$0;
                ResultKt.throwOnFailure($result3);
                velocity = velocity3;
                $result2 = $result3;
                long preConsumedByParent2 = ((Velocity) $result3).getPackedValue();
                available = Velocity.m7045minusAH228Gc(velocity, preConsumedByParent2);
                scrollingLogic$onDragStopped$performFling$1.J$0 = velocity;
                scrollingLogic$onDragStopped$performFling$1.J$1 = available;
                scrollingLogic$onDragStopped$performFling$1.label = 2;
                objM675doFlingAnimationQWom1Mo = scrollingLogic$onDragStopped$performFling$1.this$0.m675doFlingAnimationQWom1Mo(available, scrollingLogic$onDragStopped$performFling$1);
                if (objM675doFlingAnimationQWom1Mo == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result4 = objM675doFlingAnimationQWom1Mo;
                long velocityLeft3 = ((Velocity) $result4).getPackedValue();
                scrollingLogic$onDragStopped$performFling$1.J$0 = velocity;
                scrollingLogic$onDragStopped$performFling$1.J$1 = velocityLeft3;
                scrollingLogic$onDragStopped$performFling$1.label = 3;
                velocityLeft = velocityLeft3;
                objM5391dispatchPostFlingRZ2iAVY = scrollingLogic$onDragStopped$performFling$1.this$0.nestedScrollDispatcher.m5391dispatchPostFlingRZ2iAVY(Velocity.m7045minusAH228Gc(available, velocityLeft3), velocityLeft3, scrollingLogic$onDragStopped$performFling$1);
                if (objM5391dispatchPostFlingRZ2iAVY == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result5 = objM5391dispatchPostFlingRZ2iAVY;
                long consumedPost2 = ((Velocity) $result5).getPackedValue();
                long totalLeft2 = Velocity.m7045minusAH228Gc(velocityLeft, consumedPost2);
                return Velocity.m7033boximpl(Velocity.m7045minusAH228Gc(velocity, totalLeft2));
            case 2:
                scrollingLogic$onDragStopped$performFling$1 = this;
                long available2 = scrollingLogic$onDragStopped$performFling$1.J$1;
                long velocity4 = scrollingLogic$onDragStopped$performFling$1.J$0;
                ResultKt.throwOnFailure($result);
                $result4 = $result;
                velocity = velocity4;
                available = available2;
                long velocityLeft4 = ((Velocity) $result4).getPackedValue();
                scrollingLogic$onDragStopped$performFling$1.J$0 = velocity;
                scrollingLogic$onDragStopped$performFling$1.J$1 = velocityLeft4;
                scrollingLogic$onDragStopped$performFling$1.label = 3;
                velocityLeft = velocityLeft4;
                objM5391dispatchPostFlingRZ2iAVY = scrollingLogic$onDragStopped$performFling$1.this$0.nestedScrollDispatcher.m5391dispatchPostFlingRZ2iAVY(Velocity.m7045minusAH228Gc(available, velocityLeft4), velocityLeft4, scrollingLogic$onDragStopped$performFling$1);
                if (objM5391dispatchPostFlingRZ2iAVY == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result5 = objM5391dispatchPostFlingRZ2iAVY;
                long consumedPost3 = ((Velocity) $result5).getPackedValue();
                long totalLeft3 = Velocity.m7045minusAH228Gc(velocityLeft, consumedPost3);
                return Velocity.m7033boximpl(Velocity.m7045minusAH228Gc(velocity, totalLeft3));
            case 3:
                $result5 = $result;
                long velocityLeft5 = this.J$1;
                velocity = this.J$0;
                ResultKt.throwOnFailure($result5);
                velocityLeft = velocityLeft5;
                long consumedPost4 = ((Velocity) $result5).getPackedValue();
                long totalLeft4 = Velocity.m7045minusAH228Gc(velocityLeft, consumedPost4);
                return Velocity.m7033boximpl(Velocity.m7045minusAH228Gc(velocity, totalLeft4));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
