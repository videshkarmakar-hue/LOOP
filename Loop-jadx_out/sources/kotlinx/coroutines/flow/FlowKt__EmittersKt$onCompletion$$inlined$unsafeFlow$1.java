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
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SafeCollector.common.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m195d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function3 $action$inlined;
    final /* synthetic */ Flow $this_onCompletion$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", m210f = "Emitters.kt", m211i = {0, 0, 1, 2}, m212l = {115, 122, 129}, m213m = "collect", m214n = {"this", "$this$onCompletion_u24lambda_u242", "e", "sc"}, m215s = {"L$0", "L$1", "L$0", "L$0"})
    public static final class C43401 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C43401(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x008e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x008f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) throws Throwable {
        C43401 c43401;
        FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
        FlowCollector<? super T> flowCollector2;
        SafeCollector sc;
        Throwable th;
        SafeCollector sc2;
        Object objInvoke;
        if (continuation instanceof C43401) {
            c43401 = (C43401) continuation;
            if ((c43401.label & Integer.MIN_VALUE) != 0) {
                c43401.label -= Integer.MIN_VALUE;
            } else {
                c43401 = new C43401(continuation);
            }
        } else {
            c43401 = new C43401(continuation);
        }
        C43401 c43402 = c43401;
        Object $result = c43402.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c43402.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                    flowCollector2 = flowCollector;
                    Flow flow = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$this_onCompletion$inlined;
                    c43402.L$0 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
                    c43402.L$1 = flowCollector2;
                    c43402.label = 1;
                    if (flow.collect(flowCollector2, c43402) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sc = new SafeCollector(flowCollector2, c43402.getContext());
                    try {
                        Function3 function3 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                        c43402.L$0 = sc;
                        c43402.L$1 = null;
                        c43402.label = 3;
                        InlineMarker.mark(6);
                        objInvoke = function3.invoke(sc, null, c43402);
                        InlineMarker.mark(7);
                        if (objInvoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sc2 = sc;
                        sc2.releaseIntercepted();
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        sc2 = sc;
                        sc2.releaseIntercepted();
                        throw th;
                    }
                case 1:
                    flowCollector2 = (FlowCollector) c43402.L$1;
                    flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) c43402.L$0;
                    ResultKt.throwOnFailure($result);
                    sc = new SafeCollector(flowCollector2, c43402.getContext());
                    Function3 function4 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                    c43402.L$0 = sc;
                    c43402.L$1 = null;
                    c43402.label = 3;
                    InlineMarker.mark(6);
                    objInvoke = function4.invoke(sc, null, c43402);
                    InlineMarker.mark(7);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sc2 = sc;
                    sc2.releaseIntercepted();
                    return Unit.INSTANCE;
                case 2:
                    Throwable e = (Throwable) c43402.L$0;
                    ResultKt.throwOnFailure($result);
                    throw e;
                case 3:
                    sc2 = (SafeCollector) c43402.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        sc2.releaseIntercepted();
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        sc2.releaseIntercepted();
                        throw th;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable e2) {
            ThrowingCollector throwingCollector = new ThrowingCollector(e2);
            Function3 function5 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
            c43402.L$0 = e2;
            c43402.L$1 = null;
            c43402.label = 2;
            if (FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(throwingCollector, function5, e2, c43402) == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw e2;
        }
    }

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.$this_onCompletion$inlined = flow;
        this.$action$inlined = function3;
    }
}
