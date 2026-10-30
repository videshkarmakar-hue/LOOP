package androidx.room;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadContextElement;
import kotlinx.coroutines.ThreadContextElementKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: RoomDatabaseExt.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a9\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006*\u00020\u00022\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\n\"\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\r\u001aL\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00012'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0012¢\u0006\u0002\b\u0016H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a9\u0010\u0018\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f*\u00020\u00022\u001c\u0010\u0019\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u001aH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, m195d2 = {"createTransactionContext", "Lkotlin/coroutines/CoroutineContext;", "Landroidx/room/RoomDatabase;", "dispatcher", "Lkotlin/coroutines/ContinuationInterceptor;", "invalidationTrackerFlow", "Lkotlinx/coroutines/flow/Flow;", "", "", "tables", "", "emitInitialState", "", "(Landroidx/room/RoomDatabase;[Ljava/lang/String;Z)Lkotlinx/coroutines/flow/Flow;", "startTransactionCoroutine", "R", "context", "transactionBlock", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/room/RoomDatabase;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTransaction", "block", "Lkotlin/Function1;", "(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-ktx_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class RoomDatabaseKt {
    public static final <R> Object withTransaction(RoomDatabase $this$withTransaction, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        Function2 transactionBlock = new RoomDatabaseKt$withTransaction$transactionBlock$1($this$withTransaction, function1, null);
        TransactionElement transactionElement = (TransactionElement) continuation.get$context().get(TransactionElement.INSTANCE);
        ContinuationInterceptor transactionDispatcher = transactionElement != null ? transactionElement.getTransactionDispatcher() : null;
        if (transactionDispatcher != null) {
            return BuildersKt.withContext(transactionDispatcher, transactionBlock, continuation);
        }
        return startTransactionCoroutine($this$withTransaction, continuation.get$context(), transactionBlock, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <R> Object startTransactionCoroutine(final RoomDatabase $this$startTransactionCoroutine, final CoroutineContext context, final Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        final CancellableContinuationImpl continuation2 = cancellable$iv;
        try {
            $this$startTransactionCoroutine.getTransactionExecutor().execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        BuildersKt.runBlocking(context.minusKey(ContinuationInterceptor.INSTANCE), new C24751($this$startTransactionCoroutine, continuation2, function2, null));
                    } catch (Throwable ex) {
                        continuation2.cancel(ex);
                    }
                }

                /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1$1 */
                /* JADX INFO: compiled from: RoomDatabaseExt.kt */
                @Metadata(m194d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m195d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(m209c = "androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1$1", m210f = "RoomDatabaseExt.kt", m211i = {}, m212l = {HttpStatusCodesKt.HTTP_EARLY_HINTS}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                static final class C24751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CancellableContinuation<R> $continuation;
                    final /* synthetic */ RoomDatabase $this_startTransactionCoroutine;
                    final /* synthetic */ Function2<CoroutineScope, Continuation<? super R>, Object> $transactionBlock;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C24751(RoomDatabase roomDatabase, CancellableContinuation<? super R> cancellableContinuation, Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super C24751> continuation) {
                        super(2, continuation);
                        this.$this_startTransactionCoroutine = roomDatabase;
                        this.$continuation = cancellableContinuation;
                        this.$transactionBlock = function2;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C24751 c24751 = new C24751(this.$this_startTransactionCoroutine, this.$continuation, this.$transactionBlock, continuation);
                        c24751.L$0 = obj;
                        return c24751;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C24751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) throws Throwable {
                        Continuation continuation;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                CoroutineScope $this$runBlocking = (CoroutineScope) this.L$0;
                                CoroutineContext.Element element = $this$runBlocking.getCoroutineContext().get(ContinuationInterceptor.INSTANCE);
                                Intrinsics.checkNotNull(element);
                                ContinuationInterceptor dispatcher = (ContinuationInterceptor) element;
                                CoroutineContext transactionContext = RoomDatabaseKt.createTransactionContext(this.$this_startTransactionCoroutine, dispatcher);
                                continuation = this.$continuation;
                                Result.Companion companion = Result.INSTANCE;
                                this.L$0 = continuation;
                                this.label = 1;
                                Object objWithContext = BuildersKt.withContext(transactionContext, this.$transactionBlock, this);
                                if (objWithContext == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result = objWithContext;
                                break;
                            case 1:
                                Continuation continuation2 = (Continuation) this.L$0;
                                ResultKt.throwOnFailure($result);
                                continuation = continuation2;
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        continuation.resumeWith(Result.m7693constructorimpl($result));
                        return Unit.INSTANCE;
                    }
                }
            });
        } catch (RejectedExecutionException ex) {
            continuation2.cancel(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", ex));
        }
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineContext createTransactionContext(RoomDatabase $this$createTransactionContext, ContinuationInterceptor dispatcher) {
        TransactionElement transactionElement = new TransactionElement(dispatcher);
        ThreadContextElement threadLocalElement = ThreadContextElementKt.asContextElement($this$createTransactionContext.getSuspendingTransactionId(), Integer.valueOf(System.identityHashCode(transactionElement)));
        return dispatcher.plus(transactionElement).plus(threadLocalElement);
    }

    public static /* synthetic */ Flow invalidationTrackerFlow$default(RoomDatabase roomDatabase, String[] strArr, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return invalidationTrackerFlow(roomDatabase, strArr, z);
    }

    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$invalidationTrackerFlow$1 */
    /* JADX INFO: compiled from: RoomDatabaseExt.kt */
    @Metadata(m194d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "", ""}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.room.RoomDatabaseKt$invalidationTrackerFlow$1", m210f = "RoomDatabaseExt.kt", m211i = {}, m212l = {235}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C24741 extends SuspendLambda implements Function2<ProducerScope<? super Set<? extends String>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $emitInitialState;
        final /* synthetic */ String[] $tables;
        final /* synthetic */ RoomDatabase $this_invalidationTrackerFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C24741(boolean z, RoomDatabase roomDatabase, String[] strArr, Continuation<? super C24741> continuation) {
            super(2, continuation);
            this.$emitInitialState = z;
            this.$this_invalidationTrackerFlow = roomDatabase;
            this.$tables = strArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C24741 c24741 = new C24741(this.$emitInitialState, this.$this_invalidationTrackerFlow, this.$tables, continuation);
            c24741.L$0 = obj;
            return c24741;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Set<? extends String>> producerScope, Continuation<? super Unit> continuation) {
            return invoke2((ProducerScope<? super Set<String>>) producerScope, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ProducerScope<? super Set<String>> producerScope, Continuation<? super Unit> continuation) {
            return ((C24741) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r7v0, types: [androidx.room.RoomDatabaseKt$invalidationTrackerFlow$1$observer$1] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            CoroutineDispatcher queryDispatcher;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final ProducerScope $this$callbackFlow = (ProducerScope) this.L$0;
                    final AtomicBoolean ignoreInvalidation = new AtomicBoolean(this.$emitInitialState);
                    final String[] strArr = this.$tables;
                    ?? r7 = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.RoomDatabaseKt$invalidationTrackerFlow$1$observer$1
                        @Override // androidx.room.InvalidationTracker.Observer
                        public void onInvalidated(Set<String> tables) {
                            if (ignoreInvalidation.get()) {
                                return;
                            }
                            $this$callbackFlow.mo9195trySendJP2dKIU(tables);
                        }
                    };
                    TransactionElement transactionElement = (TransactionElement) $this$callbackFlow.getCoroutineContext().get(TransactionElement.INSTANCE);
                    if (transactionElement == null || (queryDispatcher = transactionElement.getTransactionDispatcher()) == null) {
                        queryDispatcher = CoroutinesRoomKt.getQueryDispatcher(this.$this_invalidationTrackerFlow);
                    }
                    ContinuationInterceptor queryContext = queryDispatcher;
                    final Job job = BuildersKt__Builders_commonKt.launch$default($this$callbackFlow, queryContext, null, new RoomDatabaseKt$invalidationTrackerFlow$1$job$1(this.$this_invalidationTrackerFlow, r7, this.$emitInitialState, $this$callbackFlow, this.$tables, ignoreInvalidation, null), 2, null);
                    this.label = 1;
                    if (ProduceKt.awaitClose($this$callbackFlow, new Function0<Unit>() { // from class: androidx.room.RoomDatabaseKt.invalidationTrackerFlow.1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public static final Flow<Set<String>> invalidationTrackerFlow(RoomDatabase $this$invalidationTrackerFlow, String[] tables, boolean emitInitialState) {
        return FlowKt.callbackFlow(new C24741(emitInitialState, $this$invalidationTrackerFlow, tables, null));
    }
}
