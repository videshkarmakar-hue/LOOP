package kotlinx.coroutines.flow;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: Count.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001aE\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, m195d2 = {"count", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m196k = 5, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE, m200xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__CountKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__CountKt$count$1 */
    /* JADX INFO: compiled from: Count.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "kotlinx.coroutines.flow.FlowKt__CountKt", m210f = "Count.kt", m211i = {0}, m212l = {17}, m213m = "count", m214n = {"i"}, m215s = {"L$0"})
    static final class C43301<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C43301(Continuation<? super C43301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.count(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__CountKt$count$3 */
    /* JADX INFO: compiled from: Count.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "kotlinx.coroutines.flow.FlowKt__CountKt", m210f = "Count.kt", m211i = {0}, m212l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS}, m213m = "count", m214n = {"i"}, m215s = {"L$0"})
    static final class C43323<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C43323(Continuation<? super C43323> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.count(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object count(Flow<? extends T> flow, Continuation<? super Integer> continuation) {
        C43301 c43301;
        Ref.IntRef i;
        if (continuation instanceof C43301) {
            c43301 = (C43301) continuation;
            if ((c43301.label & Integer.MIN_VALUE) != 0) {
                c43301.label -= Integer.MIN_VALUE;
            } else {
                c43301 = new C43301(continuation);
            }
        } else {
            c43301 = new C43301(continuation);
        }
        C43301 c43302 = c43301;
        Object $result = c43302.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c43302.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final Ref.IntRef i2 = new Ref.IntRef();
                FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__CountKt.count.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(T t, Continuation<? super Unit> continuation2) {
                        i2.element++;
                        int i3 = i2.element;
                        return Unit.INSTANCE;
                    }
                };
                c43302.L$0 = i2;
                c43302.label = 1;
                if (flow.collect(flowCollector, c43302) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = i2;
                break;
                break;
            case 1:
                i = (Ref.IntRef) c43302.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxInt(i.element);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object count(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Integer> continuation) {
        C43323 c43323;
        Ref.IntRef i;
        if (continuation instanceof C43323) {
            c43323 = (C43323) continuation;
            if ((c43323.label & Integer.MIN_VALUE) != 0) {
                c43323.label -= Integer.MIN_VALUE;
            } else {
                c43323 = new C43323(continuation);
            }
        } else {
            c43323 = new C43323(continuation);
        }
        C43323 c43324 = c43323;
        Object $result = c43324.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c43324.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Ref.IntRef i2 = new Ref.IntRef();
                FlowCollector<? super Object> c43334 = new C43334<>(function2, i2);
                c43324.L$0 = i2;
                c43324.label = 1;
                if (flow.collect(c43334, c43324) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = i2;
                break;
                break;
            case 1:
                i = (Ref.IntRef) c43324.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxInt(i.element);
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__CountKt$count$4 */
    /* JADX INFO: compiled from: Count.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, DownloadUtil.CookieScheme.VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class C43334<T> implements FlowCollector {

        /* JADX INFO: renamed from: $i */
        final /* synthetic */ Ref.IntRef f553$i;
        final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> $predicate;

        /* JADX WARN: Multi-variable type inference failed */
        C43334(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Ref.IntRef intRef) {
            this.$predicate = function2;
            this.f553$i = intRef;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            FlowKt__CountKt$count$4$emit$1 flowKt__CountKt$count$4$emit$1;
            C43334<T> c43334;
            Object value;
            if (continuation instanceof FlowKt__CountKt$count$4$emit$1) {
                flowKt__CountKt$count$4$emit$1 = (FlowKt__CountKt$count$4$emit$1) continuation;
                if ((flowKt__CountKt$count$4$emit$1.label & Integer.MIN_VALUE) != 0) {
                    flowKt__CountKt$count$4$emit$1.label -= Integer.MIN_VALUE;
                } else {
                    flowKt__CountKt$count$4$emit$1 = new FlowKt__CountKt$count$4$emit$1(this, continuation);
                }
            } else {
                flowKt__CountKt$count$4$emit$1 = new FlowKt__CountKt$count$4$emit$1(this, continuation);
            }
            FlowKt__CountKt$count$4$emit$1 flowKt__CountKt$count$4$emit$2 = flowKt__CountKt$count$4$emit$1;
            Object $result = flowKt__CountKt$count$4$emit$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (flowKt__CountKt$count$4$emit$2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c43334 = this;
                    Function2<T, Continuation<? super Boolean>, Object> function2 = c43334.$predicate;
                    flowKt__CountKt$count$4$emit$2.L$0 = c43334;
                    flowKt__CountKt$count$4$emit$2.label = 1;
                    value = function2.invoke(t, flowKt__CountKt$count$4$emit$2);
                    if (value == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    C43334<T> c43335 = (C43334) flowKt__CountKt$count$4$emit$2.L$0;
                    ResultKt.throwOnFailure($result);
                    c43334 = c43335;
                    value = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (((Boolean) value).booleanValue()) {
                c43334.f553$i.element++;
                int i = c43334.f553$i.element;
            }
            return Unit.INSTANCE;
        }
    }
}
