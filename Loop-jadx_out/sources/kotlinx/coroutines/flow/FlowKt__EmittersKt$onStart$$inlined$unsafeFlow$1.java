package kotlinx.coroutines.flow;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SafeCollector.common.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m195d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function2 $action$inlined;
    final /* synthetic */ Flow $this_onStart$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1", m210f = "Emitters.kt", m211i = {0, 0, 0}, m212l = {117, 121}, m213m = "collect", m214n = {"this", "$this$onStart_u24lambda_u241", "safeCollector"}, m215s = {"L$0", "L$1", "L$2"})
    public static final class C43421 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C43421(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0087 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        C43421 c43421;
        FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1<T> flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1;
        FlowCollector<? super T> flowCollector2;
        SafeCollector safeCollector;
        if (continuation instanceof C43421) {
            c43421 = (C43421) continuation;
            if ((c43421.label & Integer.MIN_VALUE) != 0) {
                c43421.label -= Integer.MIN_VALUE;
            } else {
                c43421 = new C43421(continuation);
            }
        } else {
            c43421 = new C43421(continuation);
        }
        C43421 c43422 = c43421;
        Object $result = c43422.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? Collect = c43422.label;
        try {
            switch (Collect) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 = this;
                    flowCollector2 = flowCollector;
                    safeCollector = new SafeCollector(flowCollector2, c43422.getContext());
                    Function2 function2 = flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.$action$inlined;
                    c43422.L$0 = flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1;
                    c43422.L$1 = flowCollector2;
                    c43422.L$2 = safeCollector;
                    c43422.label = 1;
                    InlineMarker.mark(6);
                    Object objInvoke = function2.invoke(safeCollector, c43422);
                    InlineMarker.mark(7);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    safeCollector.releaseIntercepted();
                    Flow flow = flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.$this_onStart$inlined;
                    c43422.L$0 = null;
                    c43422.L$1 = null;
                    c43422.L$2 = null;
                    c43422.label = 2;
                    Collect = flow.collect(flowCollector2, c43422);
                    if (Collect == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    safeCollector = (SafeCollector) c43422.L$2;
                    flowCollector2 = (FlowCollector) c43422.L$1;
                    flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 = (FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1) c43422.L$0;
                    ResultKt.throwOnFailure($result);
                    safeCollector.releaseIntercepted();
                    Flow flow2 = flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.$this_onStart$inlined;
                    c43422.L$0 = null;
                    c43422.L$1 = null;
                    c43422.L$2 = null;
                    c43422.label = 2;
                    Collect = flow2.collect(flowCollector2, c43422);
                    if (Collect == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th) {
            Collect.releaseIntercepted();
            throw th;
        }
    }

    public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(Function2 function2, Flow flow) {
        this.$action$inlined = function2;
        this.$this_onStart$inlined = flow;
    }
}
