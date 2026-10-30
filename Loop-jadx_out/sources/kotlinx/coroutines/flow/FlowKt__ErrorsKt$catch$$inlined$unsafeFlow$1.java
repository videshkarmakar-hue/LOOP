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

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SafeCollector.common.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m195d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function3 $action$inlined;
    final /* synthetic */ Flow $this_catch$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1 */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1", m210f = "Errors.kt", m211i = {0, 0}, m212l = {114, 115}, m213m = "collect", m214n = {"this", "$this$catch_u24lambda_u240"}, m215s = {"L$0", "L$1"})
    public static final class C43451 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C43451(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005d  */
    /* JADX WARN: Code duplicated, block: B:21:0x0075 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        C43451 c43451;
        FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1<T> flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
        FlowCollector<? super T> flowCollector2;
        Object objCatchImpl;
        Throwable exception;
        Object objInvoke;
        if (continuation instanceof C43451) {
            c43451 = (C43451) continuation;
            if ((c43451.label & Integer.MIN_VALUE) != 0) {
                c43451.label -= Integer.MIN_VALUE;
            } else {
                c43451 = new C43451(continuation);
            }
        } else {
            c43451 = new C43451(continuation);
        }
        C43451 c43452 = c43451;
        Object $result = c43452.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c43452.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 = this;
                flowCollector2 = flowCollector;
                Flow flow = flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.$this_catch$inlined;
                c43452.L$0 = flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
                c43452.L$1 = flowCollector2;
                c43452.label = 1;
                objCatchImpl = FlowKt.catchImpl(flow, flowCollector2, c43452);
                if (objCatchImpl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                exception = (Throwable) objCatchImpl;
                if (exception != null) {
                    Function3 function3 = flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.$action$inlined;
                    c43452.L$0 = null;
                    c43452.L$1 = null;
                    c43452.label = 2;
                    InlineMarker.mark(6);
                    objInvoke = function3.invoke(flowCollector2, exception, c43452);
                    InlineMarker.mark(7);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                flowCollector2 = (FlowCollector) c43452.L$1;
                flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 = (FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1) c43452.L$0;
                ResultKt.throwOnFailure($result);
                objCatchImpl = $result;
                exception = (Throwable) objCatchImpl;
                if (exception != null) {
                    Function3 function4 = flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.$action$inlined;
                    c43452.L$0 = null;
                    c43452.L$1 = null;
                    c43452.label = 2;
                    InlineMarker.mark(6);
                    objInvoke = function4.invoke(flowCollector2, exception, c43452);
                    InlineMarker.mark(7);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.$this_catch$inlined = flow;
        this.$action$inlined = function3;
    }
}
