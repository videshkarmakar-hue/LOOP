package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: LazyLayoutPager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, m195d2 = {"Landroidx/compose/foundation/pager/PagerWrapperFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "originalFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "(Landroidx/compose/foundation/gestures/TargetedFlingBehavior;Landroidx/compose/foundation/pager/PagerState;)V", "getOriginalFlingBehavior", "()Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "getPagerState", "()Landroidx/compose/foundation/pager/PagerState;", "performFling", "", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class PagerWrapperFlingBehavior implements FlingBehavior {
    private final TargetedFlingBehavior originalFlingBehavior;
    private final PagerState pagerState;

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$1 */
    /* JADX INFO: compiled from: LazyLayoutPager.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.pager.PagerWrapperFlingBehavior", m210f = "LazyLayoutPager.kt", m211i = {}, m212l = {373}, m213m = "performFling", m214n = {}, m215s = {})
    static final class C06871 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06871(Continuation<? super C06871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PagerWrapperFlingBehavior.this.performFling(null, 0.0f, this);
        }
    }

    public PagerWrapperFlingBehavior(TargetedFlingBehavior originalFlingBehavior, PagerState pagerState) {
        this.originalFlingBehavior = originalFlingBehavior;
        this.pagerState = pagerState;
    }

    public final TargetedFlingBehavior getOriginalFlingBehavior() {
        return this.originalFlingBehavior;
    }

    public final PagerState getPagerState() {
        return this.pagerState;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public Object performFling(final ScrollScope $this$performFling, float initialVelocity, Continuation<? super Float> continuation) {
        C06871 c06871;
        Object objPerformFling;
        if (continuation instanceof C06871) {
            c06871 = (C06871) continuation;
            if ((c06871.label & Integer.MIN_VALUE) != 0) {
                c06871.label -= Integer.MIN_VALUE;
            } else {
                c06871 = new C06871(continuation);
            }
        } else {
            c06871 = new C06871(continuation);
        }
        C06871 c06872 = c06871;
        Object $result = c06872.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c06872.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                TargetedFlingBehavior $this$performFling_u24lambda_u240 = this.originalFlingBehavior;
                Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                        invoke(f.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float remainingScrollOffset) {
                        float flingPageDisplacement;
                        if (this.this$0.getPagerState().getPageSizeWithSpacing$foundation_release() != 0) {
                            flingPageDisplacement = remainingScrollOffset / this.this$0.getPagerState().getPageSizeWithSpacing$foundation_release();
                        } else {
                            flingPageDisplacement = 0.0f;
                        }
                        int targetPage = MathKt.roundToInt(flingPageDisplacement) + this.this$0.getPagerState().getCurrentPage();
                        PagerState $this$invoke_u24lambda_u240 = this.this$0.getPagerState();
                        $this$invoke_u24lambda_u240.updateTargetPage($this$performFling, targetPage);
                    }
                };
                c06872.label = 1;
                objPerformFling = $this$performFling_u24lambda_u240.performFling($this$performFling, initialVelocity, function1, c06872);
                if (objPerformFling == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objPerformFling = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxFloat(((Number) objPerformFling).floatValue());
    }
}
