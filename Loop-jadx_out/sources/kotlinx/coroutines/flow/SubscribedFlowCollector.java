package kotlinx.coroutines.flow;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.SafeCollector;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: Share.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BE\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R:\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, m195d2 = {"Lkotlinx/coroutines/flow/SubscribedFlowCollector;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "emit", DownloadUtil.CookieScheme.VALUE, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSubscription", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SubscribedFlowCollector<T> implements FlowCollector<T> {
    private final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> action;
    private final FlowCollector<T> collector;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 */
    /* JADX INFO: compiled from: Share.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "kotlinx.coroutines.flow.SubscribedFlowCollector", m210f = "Share.kt", m211i = {0, 0}, m212l = {HttpStatusCodesKt.HTTP_INSUFFICIENT_SPACE_ON_RESOURCE, HttpStatusCodesKt.HTTP_LOCKED}, m213m = "onSubscription", m214n = {"this", "safeCollector"}, m215s = {"L$0", "L$1"})
    static final class C44191 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SubscribedFlowCollector<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C44191(SubscribedFlowCollector<T> subscribedFlowCollector, Continuation<? super C44191> continuation) {
            super(continuation);
            this.this$0 = subscribedFlowCollector;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onSubscription(this);
        }
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        return this.collector.emit(t, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubscribedFlowCollector(FlowCollector<? super T> flowCollector, Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.collector = flowCollector;
        this.action = function2;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0068  */
    /* JADX WARN: Code duplicated, block: B:24:0x007a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r2v5, types: [boolean] */
    public final Object onSubscription(Continuation<? super Unit> continuation) {
        C44191 c44191;
        SubscribedFlowCollector<T> subscribedFlowCollector;
        SafeCollector safeCollector;
        SubscribedFlowCollector subscribedFlowCollector2;
        if (continuation instanceof C44191) {
            c44191 = (C44191) continuation;
            if ((c44191.label & Integer.MIN_VALUE) != 0) {
                c44191.label -= Integer.MIN_VALUE;
            } else {
                c44191 = new C44191(this, continuation);
            }
        } else {
            c44191 = new C44191(this, continuation);
        }
        C44191 c44192 = c44191;
        Object $result = c44192.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = c44192.label;
        try {
            switch (r2) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    subscribedFlowCollector = this;
                    safeCollector = new SafeCollector(subscribedFlowCollector.collector, c44192.get$context());
                    Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> function2 = subscribedFlowCollector.action;
                    c44192.L$0 = subscribedFlowCollector;
                    c44192.L$1 = safeCollector;
                    c44192.label = 1;
                    if (function2.invoke(safeCollector, c44192) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    safeCollector.releaseIntercepted();
                    r2 = subscribedFlowCollector.collector instanceof SubscribedFlowCollector;
                    if (r2 != 0) {
                        subscribedFlowCollector2 = (SubscribedFlowCollector) subscribedFlowCollector.collector;
                        c44192.L$0 = null;
                        c44192.L$1 = null;
                        c44192.label = 2;
                        if (subscribedFlowCollector2.onSubscription(c44192) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    safeCollector = (SafeCollector) c44192.L$1;
                    subscribedFlowCollector = (SubscribedFlowCollector) c44192.L$0;
                    ResultKt.throwOnFailure($result);
                    safeCollector.releaseIntercepted();
                    r2 = subscribedFlowCollector.collector instanceof SubscribedFlowCollector;
                    if (r2 != 0) {
                        subscribedFlowCollector2 = (SubscribedFlowCollector) subscribedFlowCollector.collector;
                        c44192.L$0 = null;
                        c44192.L$1 = null;
                        c44192.label = 2;
                        if (subscribedFlowCollector2.onSubscription(c44192) == coroutine_suspended) {
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
        } catch (Throwable th) {
            r2.releaseIntercepted();
            throw th;
        }
    }
}
