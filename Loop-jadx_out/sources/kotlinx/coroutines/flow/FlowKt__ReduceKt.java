package kotlinx.coroutines.flow;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: compiled from: Reduce.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a!\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001aE\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a#\u0010\n\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001aG\u0010\n\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001ay\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\r\u001a\u0002H\f2H\b\u0004\u0010\u000e\u001aB\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a!\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a#\u0010\u0016\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001as\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u0018\"\b\b\u0001\u0010\u0001*\u0002H\u0018*\b\u0012\u0004\u0012\u0002H\u00010\u00022F\u0010\u000e\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a!\u0010\u001b\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a#\u0010\u001c\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, m195d2 = {"first", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstOrNull", "fold", "R", "initial", "operation", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "acc", DownloadUtil.CookieScheme.VALUE, "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "last", "lastOrNull", "reduce", ExifInterface.LATITUDE_SOUTH, "accumulator", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "single", "singleOrNull", "kotlinx-coroutines-core"}, m196k = 5, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE, m200xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__ReduceKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m210f = "Reduce.kt", m211i = {0, 0}, m212l = {183}, m213m = "first", m214n = {"result", "collector$iv"}, m215s = {"L$0", "L$1"})
    static final class C43661<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C43661(Continuation<? super C43661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.first(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3 */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m210f = "Reduce.kt", m211i = {0, 0, 0}, m212l = {183}, m213m = "first", m214n = {"predicate", "result", "collector$iv"}, m215s = {"L$0", "L$1", "L$2"})
    static final class C43673<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C43673(Continuation<? super C43673> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.first(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1 */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m210f = "Reduce.kt", m211i = {0, 0}, m212l = {183}, m213m = "firstOrNull", m214n = {"result", "collector$iv"}, m215s = {"L$0", "L$1"})
    static final class C43691<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C43691(Continuation<? super C43691> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.firstOrNull(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3 */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m210f = "Reduce.kt", m211i = {0, 0}, m212l = {183}, m213m = "firstOrNull", m214n = {"result", "collector$iv"}, m215s = {"L$0", "L$1"})
    static final class C43703<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C43703(Continuation<? super C43703> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.firstOrNull(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1 */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = 176)
    @DebugMetadata(m209c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m210f = "Reduce.kt", m211i = {0}, m212l = {44}, m213m = "fold", m214n = {"accumulator"}, m215s = {"L$0"})
    static final class C43711<T, R> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C43711(Continuation<? super C43711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ReduceKt.fold(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1 */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m210f = "Reduce.kt", m211i = {0}, m212l = {TarConstants.PREFIXLEN}, m213m = "last", m214n = {"result"}, m215s = {"L$0"})
    static final class C43731<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C43731(Continuation<? super C43731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.last(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1 */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m210f = "Reduce.kt", m211i = {0}, m212l = {167}, m213m = "lastOrNull", m214n = {"result"}, m215s = {"L$0"})
    static final class C43751<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C43751(Continuation<? super C43751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.lastOrNull(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1 */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m210f = "Reduce.kt", m211i = {0}, m212l = {22}, m213m = "reduce", m214n = {"accumulator"}, m215s = {"L$0"})
    static final class C43771<S, T extends S> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C43771(Continuation<? super C43771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.reduce(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1 */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m210f = "Reduce.kt", m211i = {0}, m212l = {57}, m213m = "single", m214n = {"result"}, m215s = {"L$0"})
    static final class C43791<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C43791(Continuation<? super C43791> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.single(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1 */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m210f = "Reduce.kt", m211i = {0, 0}, m212l = {183}, m213m = "singleOrNull", m214n = {"result", "collector$iv"}, m215s = {"L$0", "L$1"})
    static final class C43811<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C43811(Continuation<? super C43811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.singleOrNull(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, kotlinx.coroutines.internal.Symbol] */
    public static final <S, T extends S> Object reduce(Flow<? extends T> flow, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3, Continuation<? super S> continuation) {
        C43771 c43771;
        Ref.ObjectRef accumulator;
        if (continuation instanceof C43771) {
            c43771 = (C43771) continuation;
            if ((c43771.label & Integer.MIN_VALUE) != 0) {
                c43771.label -= Integer.MIN_VALUE;
            } else {
                c43771 = new C43771(continuation);
            }
        } else {
            c43771 = new C43771(continuation);
        }
        C43771 c43772 = c43771;
        Object $result = c43772.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c43772.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Ref.ObjectRef accumulator2 = new Ref.ObjectRef();
                accumulator2.element = NullSurrogateKt.NULL;
                FlowCollector<? super Object> c43782 = new C43782<>(accumulator2, function3);
                c43772.L$0 = accumulator2;
                c43772.label = 1;
                if (flow.collect(c43782, c43772) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                accumulator = accumulator2;
                break;
                break;
            case 1:
                accumulator = (Ref.ObjectRef) c43772.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (accumulator.element == NullSurrogateKt.NULL) {
            throw new NoSuchElementException("Empty flow can't be reduced");
        }
        return accumulator.element;
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2 */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, m195d2 = {"<anonymous>", "", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, DownloadUtil.CookieScheme.VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class C43782<T> implements FlowCollector {
        final /* synthetic */ Ref.ObjectRef<Object> $accumulator;
        final /* synthetic */ Function3<S, T, Continuation<? super S>, Object> $operation;

        /* JADX WARN: Multi-variable type inference failed */
        C43782(Ref.ObjectRef<Object> objectRef, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3) {
            this.$accumulator = objectRef;
            this.$operation = function3;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            FlowKt__ReduceKt$reduce$2$emit$1 flowKt__ReduceKt$reduce$2$emit$1;
            Ref.ObjectRef<Object> objectRef;
            Object obj;
            Ref.ObjectRef<Object> objectRef2;
            if (continuation instanceof FlowKt__ReduceKt$reduce$2$emit$1) {
                flowKt__ReduceKt$reduce$2$emit$1 = (FlowKt__ReduceKt$reduce$2$emit$1) continuation;
                if ((flowKt__ReduceKt$reduce$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                    flowKt__ReduceKt$reduce$2$emit$1.label -= Integer.MIN_VALUE;
                } else {
                    flowKt__ReduceKt$reduce$2$emit$1 = new FlowKt__ReduceKt$reduce$2$emit$1(this, continuation);
                }
            } else {
                flowKt__ReduceKt$reduce$2$emit$1 = new FlowKt__ReduceKt$reduce$2$emit$1(this, continuation);
            }
            FlowKt__ReduceKt$reduce$2$emit$1 flowKt__ReduceKt$reduce$2$emit$2 = flowKt__ReduceKt$reduce$2$emit$1;
            Object obj2 = flowKt__ReduceKt$reduce$2$emit$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (flowKt__ReduceKt$reduce$2$emit$2.label) {
                case 0:
                    ResultKt.throwOnFailure(obj2);
                    objectRef = this.$accumulator;
                    if (this.$accumulator.element != NullSurrogateKt.NULL) {
                        Function3<S, T, Continuation<? super S>, Object> function3 = this.$operation;
                        Object obj3 = this.$accumulator.element;
                        flowKt__ReduceKt$reduce$2$emit$2.L$0 = objectRef;
                        flowKt__ReduceKt$reduce$2$emit$2.label = 1;
                        Object objInvoke = function3.invoke((S) obj3, t, flowKt__ReduceKt$reduce$2$emit$2);
                        if (objInvoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = objInvoke;
                        objectRef2 = objectRef;
                        objectRef = objectRef2;
                        t = (T) obj;
                    }
                    objectRef.element = t;
                    return Unit.INSTANCE;
                case 1:
                    objectRef2 = (Ref.ObjectRef) flowKt__ReduceKt$reduce$2$emit$2.L$0;
                    ResultKt.throwOnFailure(obj2);
                    obj = obj2;
                    objectRef = objectRef2;
                    t = (T) obj;
                    objectRef.element = t;
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> Object fold(Flow<? extends T> flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) {
        C43711 c43711;
        Ref.ObjectRef accumulator;
        if (continuation instanceof C43711) {
            c43711 = (C43711) continuation;
            if ((c43711.label & Integer.MIN_VALUE) != 0) {
                c43711.label -= Integer.MIN_VALUE;
            } else {
                c43711 = new C43711(continuation);
            }
        } else {
            c43711 = new C43711(continuation);
        }
        C43711 c43712 = c43711;
        Object $result = c43712.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c43712.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Ref.ObjectRef accumulator2 = new Ref.ObjectRef();
                accumulator2.element = r;
                FlowCollector<? super Object> c43722 = new C43722<>(accumulator2, function3);
                c43712.L$0 = accumulator2;
                c43712.label = 1;
                if (flow.collect(c43722, c43712) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                accumulator = accumulator2;
                break;
            case 1:
                accumulator = (Ref.ObjectRef) c43712.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return accumulator.element;
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2 */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", DownloadUtil.CookieScheme.VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = 176)
    public static final class C43722<T> implements FlowCollector {
        final /* synthetic */ Ref.ObjectRef<R> $accumulator;
        final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> $operation;

        /* JADX WARN: Multi-variable type inference failed */
        public C43722(Ref.ObjectRef<R> objectRef, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
            this.$accumulator = objectRef;
            this.$operation = function3;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            FlowKt__ReduceKt$fold$2$emit$1 flowKt__ReduceKt$fold$2$emit$1;
            T t2;
            Ref.ObjectRef objectRef;
            if (continuation instanceof FlowKt__ReduceKt$fold$2$emit$1) {
                flowKt__ReduceKt$fold$2$emit$1 = (FlowKt__ReduceKt$fold$2$emit$1) continuation;
                if ((flowKt__ReduceKt$fold$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                    flowKt__ReduceKt$fold$2$emit$1.label -= Integer.MIN_VALUE;
                } else {
                    flowKt__ReduceKt$fold$2$emit$1 = new FlowKt__ReduceKt$fold$2$emit$1(this, continuation);
                }
            } else {
                flowKt__ReduceKt$fold$2$emit$1 = new FlowKt__ReduceKt$fold$2$emit$1(this, continuation);
            }
            FlowKt__ReduceKt$fold$2$emit$1 flowKt__ReduceKt$fold$2$emit$2 = flowKt__ReduceKt$fold$2$emit$1;
            Object obj = flowKt__ReduceKt$fold$2$emit$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (flowKt__ReduceKt$fold$2$emit$2.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = this.$accumulator;
                    Function3<R, T, Continuation<? super R>, Object> function3 = this.$operation;
                    T t3 = this.$accumulator.element;
                    flowKt__ReduceKt$fold$2$emit$2.L$0 = objectRef2;
                    flowKt__ReduceKt$fold$2$emit$2.label = 1;
                    Object objInvoke = function3.invoke((R) t3, t, flowKt__ReduceKt$fold$2$emit$2);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    t2 = (T) objInvoke;
                    objectRef = objectRef2;
                    break;
                    break;
                case 1:
                    objectRef = (Ref.ObjectRef) flowKt__ReduceKt$fold$2$emit$2.L$0;
                    ResultKt.throwOnFailure(obj);
                    t2 = (T) obj;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef.element = t2;
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object emit$$forInline(T t, Continuation<? super Unit> continuation) {
            InlineMarker.mark(4);
            new FlowKt__ReduceKt$fold$2$emit$1(this, continuation);
            InlineMarker.mark(5);
            this.$accumulator.element = (T) this.$operation.invoke((R) this.$accumulator.element, t, (Continuation<? super R>) continuation);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T, R> Object fold$$forInline(Flow<? extends T> flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) {
        Ref.ObjectRef accumulator = new Ref.ObjectRef();
        accumulator.element = r;
        C43722 c43722 = new C43722(accumulator, function3);
        InlineMarker.mark(0);
        flow.collect(c43722, continuation);
        InlineMarker.mark(1);
        return accumulator.element;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object single(Flow<? extends T> flow, Continuation<? super T> continuation) {
        C43791 c43791;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C43791) {
            c43791 = (C43791) continuation;
            if ((c43791.label & Integer.MIN_VALUE) != 0) {
                c43791.label -= Integer.MIN_VALUE;
            } else {
                c43791 = new C43791(continuation);
            }
        } else {
            c43791 = new C43791(continuation);
        }
        C43791 c43792 = c43791;
        Object obj = c43792.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c43792.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = (T) NullSurrogateKt.NULL;
                FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt.single.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(T t, Continuation<? super Unit> continuation2) {
                        if (!(objectRef2.element == NullSurrogateKt.NULL)) {
                            throw new IllegalArgumentException("Flow has more than one element".toString());
                        }
                        objectRef2.element = t;
                        return Unit.INSTANCE;
                    }
                };
                c43792.L$0 = objectRef2;
                c43792.label = 1;
                if (flow.collect(flowCollector, c43792) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
                break;
                break;
            case 1:
                objectRef = (Ref.ObjectRef) c43792.L$0;
                ResultKt.throwOnFailure(obj);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (objectRef.element == NullSurrogateKt.NULL) {
            throw new NoSuchElementException("Flow is empty");
        }
        return objectRef.element;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0076 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0078  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object singleOrNull(Flow<? extends T> flow, Continuation<? super T> continuation) {
        C43811 c43811;
        final Ref.ObjectRef objectRef;
        FlowCollector<T> flowCollector;
        AbortFlowException e;
        if (continuation instanceof C43811) {
            c43811 = (C43811) continuation;
            if ((c43811.label & Integer.MIN_VALUE) != 0) {
                c43811.label -= Integer.MIN_VALUE;
            } else {
                c43811 = new C43811(continuation);
            }
        } else {
            c43811 = new C43811(continuation);
        }
        C43811 c43812 = c43811;
        Object obj = c43812.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c43812.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                objectRef = new Ref.ObjectRef();
                objectRef.element = (T) NullSurrogateKt.NULL;
                FlowCollector<T> flowCollector2 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(T t, Continuation<? super Unit> continuation2) {
                        boolean z;
                        if (objectRef.element == NullSurrogateKt.NULL) {
                            objectRef.element = t;
                            z = true;
                        } else {
                            objectRef.element = (T) NullSurrogateKt.NULL;
                            z = false;
                        }
                        if (!z) {
                            throw new AbortFlowException(this);
                        }
                        return Unit.INSTANCE;
                    }
                };
                try {
                    c43812.L$0 = objectRef;
                    c43812.L$1 = flowCollector2;
                    c43812.label = 1;
                    if (flow.collect(flowCollector2, c43812) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (objectRef.element == NullSurrogateKt.NULL) {
                        return null;
                    }
                    return objectRef.element;
                } catch (AbortFlowException e2) {
                    flowCollector = flowCollector2;
                    e = e2;
                    FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                }
                break;
            case 1:
                flowCollector = (FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1) c43812.L$1;
                objectRef = (Ref.ObjectRef) c43812.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    break;
                } catch (AbortFlowException e3) {
                    e = e3;
                    FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                }
                if (objectRef.element == NullSurrogateKt.NULL) {
                    return null;
                }
                return objectRef.element;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0076  */
    /* JADX WARN: Code duplicated, block: B:30:0x0079  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object first(Flow<? extends T> flow, Continuation<? super T> continuation) {
        C43661 c43661;
        final Ref.ObjectRef objectRef;
        FlowCollector<T> flowCollector;
        AbortFlowException e;
        if (continuation instanceof C43661) {
            c43661 = (C43661) continuation;
            if ((c43661.label & Integer.MIN_VALUE) != 0) {
                c43661.label -= Integer.MIN_VALUE;
            } else {
                c43661 = new C43661(continuation);
            }
        } else {
            c43661 = new C43661(continuation);
        }
        C43661 c43662 = c43661;
        Object obj = c43662.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c43662.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                objectRef = new Ref.ObjectRef();
                objectRef.element = (T) NullSurrogateKt.NULL;
                FlowCollector<T> flowCollector2 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(T t, Continuation<? super Unit> continuation2) {
                        objectRef.element = t;
                        throw new AbortFlowException(this);
                    }
                };
                try {
                    c43662.L$0 = objectRef;
                    c43662.L$1 = flowCollector2;
                    c43662.label = 1;
                    if (flow.collect(flowCollector2, c43662) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (objectRef.element != NullSurrogateKt.NULL) {
                        throw new NoSuchElementException("Expected at least one element");
                    }
                    return objectRef.element;
                } catch (AbortFlowException e2) {
                    flowCollector = flowCollector2;
                    e = e2;
                    FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                }
                break;
            case 1:
                flowCollector = (FlowKt__ReduceKt$first$$inlined$collectWhile$1) c43662.L$1;
                objectRef = (Ref.ObjectRef) c43662.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    break;
                } catch (AbortFlowException e3) {
                    e = e3;
                    FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                }
                if (objectRef.element != NullSurrogateKt.NULL) {
                    throw new NoSuchElementException("Expected at least one element");
                }
                return objectRef.element;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x007f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0082  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object first(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super T> continuation) {
        C43673 c43673;
        Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function3;
        Ref.ObjectRef objectRef;
        FlowCollector<? super Object> flowCollector;
        AbortFlowException e;
        if (continuation instanceof C43673) {
            c43673 = (C43673) continuation;
            if ((c43673.label & Integer.MIN_VALUE) != 0) {
                c43673.label -= Integer.MIN_VALUE;
            } else {
                c43673 = new C43673(continuation);
            }
        } else {
            c43673 = new C43673(continuation);
        }
        C43673 c43674 = c43673;
        Object obj = c43674.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c43674.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                function3 = function2;
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = (T) NullSurrogateKt.NULL;
                FlowCollector<? super Object> flowKt__ReduceKt$first$$inlined$collectWhile$2 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2<>(function3, objectRef2);
                try {
                    c43674.L$0 = function3;
                    c43674.L$1 = objectRef2;
                    c43674.L$2 = flowKt__ReduceKt$first$$inlined$collectWhile$2;
                    c43674.label = 1;
                    if (flow.collect(flowKt__ReduceKt$first$$inlined$collectWhile$2, c43674) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                    if (objectRef.element != NullSurrogateKt.NULL) {
                        throw new NoSuchElementException("Expected at least one element matching the predicate " + function3);
                    }
                    return objectRef.element;
                } catch (AbortFlowException e2) {
                    objectRef = objectRef2;
                    flowCollector = flowKt__ReduceKt$first$$inlined$collectWhile$2;
                    e = e2;
                    FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                }
                break;
            case 1:
                flowCollector = (FlowKt__ReduceKt$first$$inlined$collectWhile$2) c43674.L$2;
                objectRef = (Ref.ObjectRef) c43674.L$1;
                function3 = (Function2) c43674.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    break;
                } catch (AbortFlowException e3) {
                    e = e3;
                    FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                }
                if (objectRef.element != NullSurrogateKt.NULL) {
                    throw new NoSuchElementException("Expected at least one element matching the predicate " + function3);
                }
                return objectRef.element;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object firstOrNull(Flow<? extends T> flow, Continuation<? super T> continuation) {
        C43691 c43691;
        final Ref.ObjectRef result;
        FlowCollector<T> flowCollector;
        AbortFlowException e$iv;
        if (continuation instanceof C43691) {
            c43691 = (C43691) continuation;
            if ((c43691.label & Integer.MIN_VALUE) != 0) {
                c43691.label -= Integer.MIN_VALUE;
            } else {
                c43691 = new C43691(continuation);
            }
        } else {
            c43691 = new C43691(continuation);
        }
        C43691 c43692 = c43691;
        Object $result = c43692.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c43692.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                result = new Ref.ObjectRef();
                FlowCollector<T> flowCollector2 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(T t, Continuation<? super Unit> continuation2) {
                        result.element = t;
                        throw new AbortFlowException(this);
                    }
                };
                try {
                    c43692.L$0 = result;
                    c43692.L$1 = flowCollector2;
                    c43692.label = 1;
                    if (flow.collect(flowCollector2, c43692) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return result.element;
                } catch (AbortFlowException e) {
                    flowCollector = flowCollector2;
                    e$iv = e;
                    FlowExceptions_commonKt.checkOwnership(e$iv, flowCollector);
                }
                break;
            case 1:
                flowCollector = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1) c43692.L$1;
                result = (Ref.ObjectRef) c43692.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    break;
                } catch (AbortFlowException e2) {
                    e$iv = e2;
                    FlowExceptions_commonKt.checkOwnership(e$iv, flowCollector);
                }
                return result.element;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object firstOrNull(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super T> continuation) {
        C43703 c43703;
        Ref.ObjectRef result;
        FlowCollector<? super Object> collector$iv;
        AbortFlowException e$iv;
        if (continuation instanceof C43703) {
            c43703 = (C43703) continuation;
            if ((c43703.label & Integer.MIN_VALUE) != 0) {
                c43703.label -= Integer.MIN_VALUE;
            } else {
                c43703 = new C43703(continuation);
            }
        } else {
            c43703 = new C43703(continuation);
        }
        C43703 c43704 = c43703;
        Object $result = c43704.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c43704.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Ref.ObjectRef result2 = new Ref.ObjectRef();
                FlowCollector<? super Object> collector$iv2 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2<>(function2, result2);
                try {
                    c43704.L$0 = result2;
                    c43704.L$1 = collector$iv2;
                    c43704.label = 1;
                    if (flow.collect(collector$iv2, c43704) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    result = result2;
                    return result.element;
                } catch (AbortFlowException e) {
                    result = result2;
                    collector$iv = collector$iv2;
                    e$iv = e;
                    FlowExceptions_commonKt.checkOwnership(e$iv, collector$iv);
                }
                break;
            case 1:
                collector$iv = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) c43704.L$1;
                result = (Ref.ObjectRef) c43704.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    break;
                } catch (AbortFlowException e2) {
                    e$iv = e2;
                    FlowExceptions_commonKt.checkOwnership(e$iv, collector$iv);
                }
                return result.element;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object last(Flow<? extends T> flow, Continuation<? super T> continuation) {
        C43731 c43731;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C43731) {
            c43731 = (C43731) continuation;
            if ((c43731.label & Integer.MIN_VALUE) != 0) {
                c43731.label -= Integer.MIN_VALUE;
            } else {
                c43731 = new C43731(continuation);
            }
        } else {
            c43731 = new C43731(continuation);
        }
        C43731 c43732 = c43731;
        Object obj = c43732.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c43732.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = (T) NullSurrogateKt.NULL;
                FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt.last.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(T t, Continuation<? super Unit> continuation2) {
                        objectRef2.element = t;
                        return Unit.INSTANCE;
                    }
                };
                c43732.L$0 = objectRef2;
                c43732.label = 1;
                if (flow.collect(flowCollector, c43732) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
                break;
                break;
            case 1:
                objectRef = (Ref.ObjectRef) c43732.L$0;
                ResultKt.throwOnFailure(obj);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (objectRef.element == NullSurrogateKt.NULL) {
            throw new NoSuchElementException("Expected at least one element");
        }
        return objectRef.element;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object lastOrNull(Flow<? extends T> flow, Continuation<? super T> continuation) {
        C43751 c43751;
        Ref.ObjectRef result;
        if (continuation instanceof C43751) {
            c43751 = (C43751) continuation;
            if ((c43751.label & Integer.MIN_VALUE) != 0) {
                c43751.label -= Integer.MIN_VALUE;
            } else {
                c43751 = new C43751(continuation);
            }
        } else {
            c43751 = new C43751(continuation);
        }
        C43751 c43752 = c43751;
        Object $result = c43752.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c43752.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final Ref.ObjectRef result2 = new Ref.ObjectRef();
                FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt.lastOrNull.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(T t, Continuation<? super Unit> continuation2) {
                        result2.element = t;
                        return Unit.INSTANCE;
                    }
                };
                c43752.L$0 = result2;
                c43752.label = 1;
                if (flow.collect(flowCollector, c43752) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                result = result2;
                break;
                break;
            case 1:
                result = (Ref.ObjectRef) c43752.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return result.element;
    }
}
