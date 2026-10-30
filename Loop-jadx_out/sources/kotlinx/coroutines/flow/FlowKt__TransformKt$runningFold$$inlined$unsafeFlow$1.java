package kotlinx.coroutines.flow;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: SafeCollector.common.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m195d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1<R> implements Flow<R> {
    final /* synthetic */ Object $initial$inlined;
    final /* synthetic */ Function3 $operation$inlined;
    final /* synthetic */ Flow $this_runningFold$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1 */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1", m210f = "Transform.kt", m211i = {0, 0, 0}, m212l = {115, 116}, m213m = "collect", m214n = {"this", "$this$runningFold_u24lambda_u249", "accumulator"}, m215s = {"L$0", "L$1", "L$2"})
    public static final class C43981 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C43981(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0082 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r5v0, types: [T, java.lang.Object] */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
        C43981 c43981;
        FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1<R> flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1;
        FlowCollector $this$runningFold_u24lambda_u249;
        Ref.ObjectRef accumulator;
        Flow flow;
        FlowKt__TransformKt$runningFold$1$1 flowKt__TransformKt$runningFold$1$1;
        if (continuation instanceof C43981) {
            c43981 = (C43981) continuation;
            if ((c43981.label & Integer.MIN_VALUE) != 0) {
                c43981.label -= Integer.MIN_VALUE;
            } else {
                c43981 = new C43981(continuation);
            }
        } else {
            c43981 = new C43981(continuation);
        }
        C43981 c43982 = c43981;
        Object $result = c43982.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c43982.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 = this;
                $this$runningFold_u24lambda_u249 = flowCollector;
                accumulator = new Ref.ObjectRef();
                accumulator.element = flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.$initial$inlined;
                T t = accumulator.element;
                c43982.L$0 = flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1;
                c43982.L$1 = $this$runningFold_u24lambda_u249;
                c43982.L$2 = accumulator;
                c43982.label = 1;
                if ($this$runningFold_u24lambda_u249.emit(t, c43982) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                flow = flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.$this_runningFold$inlined;
                flowKt__TransformKt$runningFold$1$1 = new FlowKt__TransformKt$runningFold$1$1(accumulator, flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.$operation$inlined, $this$runningFold_u24lambda_u249);
                c43982.L$0 = null;
                c43982.L$1 = null;
                c43982.L$2 = null;
                c43982.label = 2;
                if (flow.collect(flowKt__TransformKt$runningFold$1$1, c43982) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                accumulator = (Ref.ObjectRef) c43982.L$2;
                $this$runningFold_u24lambda_u249 = (FlowCollector) c43982.L$1;
                flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 = (FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1) c43982.L$0;
                ResultKt.throwOnFailure($result);
                flow = flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.$this_runningFold$inlined;
                flowKt__TransformKt$runningFold$1$1 = new FlowKt__TransformKt$runningFold$1$1(accumulator, flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.$operation$inlined, $this$runningFold_u24lambda_u249);
                c43982.L$0 = null;
                c43982.L$1 = null;
                c43982.L$2 = null;
                c43982.label = 2;
                if (flow.collect(flowKt__TransformKt$runningFold$1$1, c43982) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1(Object obj, Flow flow, Function3 function3) {
        this.$initial$inlined = obj;
        this.$this_runningFold$inlined = flow;
        this.$operation$inlined = function3;
    }
}
