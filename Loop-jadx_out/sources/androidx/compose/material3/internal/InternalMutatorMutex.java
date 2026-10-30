package androidx.compose.material3.internal;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.foundation.MutatePriority;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: InternalMutatorMutex.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J<\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eH\u0086@¢\u0006\u0002\u0010\u0010JU\u0010\u0011\u001a\u0002H\n\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\n2\u0006\u0010\u0013\u001a\u0002H\u00122\b\b\u0002\u0010\u000b\u001a\u00020\f2'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014¢\u0006\u0002\b\u0015H\u0086@¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002R\"\u0010\u0003\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m195d2 = {"Landroidx/compose/material3/internal/InternalMutatorMutex;", "", "()V", "currentMutator", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/material3/internal/InternalMutatorMutex$Mutator;", "Landroidx/compose/material3/internal/InternalAtomicReference;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "mutate", "R", "priority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mutateWith", ExifInterface.GPS_DIRECTION_TRUE, "receiver", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryMutate", "", "Lkotlin/Function0;", "", "tryMutateOrCancel", "mutator", "Mutator", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class InternalMutatorMutex {
    public static final int $stable = 0;
    private final AtomicReference<Mutator> currentMutator = new AtomicReference<>(null);
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    /* JADX INFO: compiled from: InternalMutatorMutex.kt */
    @Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0000J\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, m195d2 = {"Landroidx/compose/material3/internal/InternalMutatorMutex$Mutator;", "", "priority", "Landroidx/compose/foundation/MutatePriority;", "job", "Lkotlinx/coroutines/Job;", "(Landroidx/compose/foundation/MutatePriority;Lkotlinx/coroutines/Job;)V", "getJob", "()Lkotlinx/coroutines/Job;", "getPriority", "()Landroidx/compose/foundation/MutatePriority;", "canInterrupt", "", "other", "cancel", "", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class Mutator {
        private final Job job;
        private final MutatePriority priority;

        public Mutator(MutatePriority priority, Job job) {
            this.priority = priority;
            this.job = job;
        }

        public final Job getJob() {
            return this.job;
        }

        public final MutatePriority getPriority() {
            return this.priority;
        }

        public final boolean canInterrupt(Mutator other) {
            return this.priority.compareTo(other.priority) >= 0;
        }

        public final void cancel() {
            Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryMutateOrCancel(Mutator mutator) {
        Mutator oldMutator;
        do {
            oldMutator = this.currentMutator.get();
            if (oldMutator != null && !mutator.canInterrupt(oldMutator)) {
                throw new CancellationException("Current mutation had a higher priority");
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(this.currentMutator, oldMutator, mutator));
        if (oldMutator != null) {
            oldMutator.cancel();
        }
    }

    public static /* synthetic */ Object mutate$default(InternalMutatorMutex internalMutatorMutex, MutatePriority mutatePriority, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return internalMutatorMutex.mutate(mutatePriority, function1, continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.material3.internal.InternalMutatorMutex$mutate$2 */
    /* JADX INFO: compiled from: InternalMutatorMutex.kt */
    @Metadata(m194d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.material3.internal.InternalMutatorMutex$mutate$2", m210f = "InternalMutatorMutex.kt", m211i = {0, 0, 1, 1}, m212l = {177, 99}, m213m = "invokeSuspend", m214n = {"mutator", "$this$withLock_u24default$iv", "mutator", "$this$withLock_u24default$iv"}, m215s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C16222<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
        final /* synthetic */ MutatePriority $priority;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ InternalMutatorMutex this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C16222(MutatePriority mutatePriority, InternalMutatorMutex internalMutatorMutex, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super C16222> continuation) {
            super(2, continuation);
            this.$priority = mutatePriority;
            this.this$0 = internalMutatorMutex;
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16222 c16222 = new C16222(this.$priority, this.this$0, this.$block, continuation);
            c16222.L$0 = obj;
            return c16222;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
            return ((C16222) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x00a8 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:20:0x00a9  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C16222<R> c16222;
            Function1<Continuation<? super R>, Object> function1;
            Mutator mutator;
            Mutator mutator2;
            Mutex $this$withLock_u24default$iv;
            InternalMutatorMutex internalMutatorMutex;
            Object owner$iv;
            Object owner$iv2;
            Mutex $this$withLock_u24default$iv2;
            Mutator mutator3;
            Throwable th;
            C16222<R> c16223;
            Mutator mutator4;
            Object objInvoke;
            Throwable th2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c16222 = this;
                    CoroutineScope $this$coroutineScope = (CoroutineScope) c16222.L$0;
                    MutatePriority mutatePriority = c16222.$priority;
                    CoroutineContext.Element element = $this$coroutineScope.getCoroutineContext().get(Job.INSTANCE);
                    Intrinsics.checkNotNull(element);
                    Mutator mutator5 = new Mutator(mutatePriority, (Job) element);
                    c16222.this$0.tryMutateOrCancel(mutator5);
                    Mutex $this$withLock_u24default$iv3 = c16222.this$0.mutex;
                    function1 = c16222.$block;
                    InternalMutatorMutex internalMutatorMutex2 = c16222.this$0;
                    c16222.L$0 = mutator5;
                    c16222.L$1 = $this$withLock_u24default$iv3;
                    c16222.L$2 = function1;
                    c16222.L$3 = internalMutatorMutex2;
                    c16222.label = 1;
                    if ($this$withLock_u24default$iv3.lock(null, c16222) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutator = mutator5;
                    mutator2 = null;
                    $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                    internalMutatorMutex = internalMutatorMutex2;
                    owner$iv = null;
                    try {
                        c16222.L$0 = mutator;
                        c16222.L$1 = $this$withLock_u24default$iv;
                        c16222.L$2 = internalMutatorMutex;
                        c16222.L$3 = null;
                        c16222.label = 2;
                        objInvoke = function1.invoke(c16222);
                        if (objInvoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = objInvoke;
                        owner$iv2 = owner$iv;
                        $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                        mutator3 = mutator;
                        try {
                            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(internalMutatorMutex.currentMutator, mutator3, null);
                            $this$withLock_u24default$iv2.unlock(owner$iv2);
                            return $result;
                        } catch (Throwable th3) {
                            th2 = th3;
                            $this$withLock_u24default$iv2.unlock(owner$iv2);
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        owner$iv2 = owner$iv;
                        $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                        mutator3 = mutator;
                        th = th4;
                        c16223 = c16222;
                        mutator4 = mutator2;
                        try {
                            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(internalMutatorMutex.currentMutator, mutator3, null);
                            throw th;
                        } catch (Throwable th5) {
                            th2 = th5;
                            $this$withLock_u24default$iv2.unlock(owner$iv2);
                            throw th2;
                        }
                    }
                case 1:
                    c16222 = this;
                    mutator2 = null;
                    internalMutatorMutex = (InternalMutatorMutex) c16222.L$3;
                    function1 = (Function1) c16222.L$2;
                    owner$iv = null;
                    $this$withLock_u24default$iv = (Mutex) c16222.L$1;
                    mutator = (Mutator) c16222.L$0;
                    ResultKt.throwOnFailure($result);
                    c16222.L$0 = mutator;
                    c16222.L$1 = $this$withLock_u24default$iv;
                    c16222.L$2 = internalMutatorMutex;
                    c16222.L$3 = null;
                    c16222.label = 2;
                    objInvoke = function1.invoke(c16222);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objInvoke;
                    owner$iv2 = owner$iv;
                    $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                    mutator3 = mutator;
                    MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(internalMutatorMutex.currentMutator, mutator3, null);
                    $this$withLock_u24default$iv2.unlock(owner$iv2);
                    return $result;
                case 2:
                    c16223 = this;
                    mutator4 = null;
                    internalMutatorMutex = (InternalMutatorMutex) c16223.L$2;
                    owner$iv2 = null;
                    $this$withLock_u24default$iv2 = (Mutex) c16223.L$1;
                    mutator3 = (Mutator) c16223.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(internalMutatorMutex.currentMutator, mutator3, null);
                        $this$withLock_u24default$iv2.unlock(owner$iv2);
                        return $result;
                    } catch (Throwable th6) {
                        th = th6;
                        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(internalMutatorMutex.currentMutator, mutator3, null);
                        throw th;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final <R> Object mutate(MutatePriority priority, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        return CoroutineScopeKt.coroutineScope(new C16222(priority, this, function1, null), continuation);
    }

    public static /* synthetic */ Object mutateWith$default(InternalMutatorMutex internalMutatorMutex, Object obj, MutatePriority mutatePriority, Function2 function2, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return internalMutatorMutex.mutateWith(obj, mutatePriority, function2, continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.material3.internal.InternalMutatorMutex$mutateWith$2 */
    /* JADX INFO: compiled from: InternalMutatorMutex.kt */
    @Metadata(m194d1 = {"\u0000\b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u00020\u0003H\u008a@"}, m195d2 = {"<anonymous>", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.material3.internal.InternalMutatorMutex$mutateWith$2", m210f = "InternalMutatorMutex.kt", m211i = {0, 0, 1, 1}, m212l = {177, 138}, m213m = "invokeSuspend", m214n = {"mutator", "$this$withLock_u24default$iv", "mutator", "$this$withLock_u24default$iv"}, m215s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C16232<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function2<T, Continuation<? super R>, Object> $block;
        final /* synthetic */ MutatePriority $priority;
        final /* synthetic */ T $receiver;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ InternalMutatorMutex this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C16232(MutatePriority mutatePriority, InternalMutatorMutex internalMutatorMutex, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, T t, Continuation<? super C16232> continuation) {
            super(2, continuation);
            this.$priority = mutatePriority;
            this.this$0 = internalMutatorMutex;
            this.$block = function2;
            this.$receiver = t;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16232 c16232 = new C16232(this.$priority, this.this$0, this.$block, this.$receiver, continuation);
            c16232.L$0 = obj;
            return c16232;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
            return ((C16232) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x00b0 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:20:0x00b1  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C16232<R> c16232;
            Function2 function2;
            Object obj;
            Object mutator;
            Mutator mutator2;
            Mutex $this$withLock_u24default$iv;
            InternalMutatorMutex internalMutatorMutex;
            Object owner$iv;
            Object owner$iv2;
            Mutex $this$withLock_u24default$iv2;
            Object owner$iv3;
            Throwable th;
            C16232<R> c16233;
            Mutator mutator3;
            Object objInvoke;
            Throwable th2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c16232 = this;
                    CoroutineScope $this$coroutineScope = (CoroutineScope) c16232.L$0;
                    MutatePriority mutatePriority = c16232.$priority;
                    CoroutineContext.Element element = $this$coroutineScope.getCoroutineContext().get(Job.INSTANCE);
                    Intrinsics.checkNotNull(element);
                    Mutator mutator4 = new Mutator(mutatePriority, (Job) element);
                    c16232.this$0.tryMutateOrCancel(mutator4);
                    Mutex $this$withLock_u24default$iv3 = c16232.this$0.mutex;
                    function2 = c16232.$block;
                    obj = c16232.$receiver;
                    InternalMutatorMutex internalMutatorMutex2 = c16232.this$0;
                    c16232.L$0 = mutator4;
                    c16232.L$1 = $this$withLock_u24default$iv3;
                    c16232.L$2 = function2;
                    c16232.L$3 = obj;
                    c16232.L$4 = internalMutatorMutex2;
                    c16232.label = 1;
                    if ($this$withLock_u24default$iv3.lock(null, c16232) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutator = mutator4;
                    mutator2 = null;
                    $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                    internalMutatorMutex = internalMutatorMutex2;
                    owner$iv = null;
                    try {
                        c16232.L$0 = mutator;
                        c16232.L$1 = $this$withLock_u24default$iv;
                        c16232.L$2 = internalMutatorMutex;
                        c16232.L$3 = null;
                        c16232.L$4 = null;
                        c16232.label = 2;
                        objInvoke = function2.invoke(obj, c16232);
                        if (objInvoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = objInvoke;
                        owner$iv2 = owner$iv;
                        $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                        owner$iv3 = mutator;
                        try {
                            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(internalMutatorMutex.currentMutator, owner$iv3, null);
                            $this$withLock_u24default$iv2.unlock(owner$iv2);
                            return $result;
                        } catch (Throwable th3) {
                            th2 = th3;
                            $this$withLock_u24default$iv2.unlock(owner$iv2);
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        owner$iv2 = owner$iv;
                        $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                        owner$iv3 = mutator;
                        th = th4;
                        c16233 = c16232;
                        mutator3 = mutator2;
                        try {
                            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(internalMutatorMutex.currentMutator, owner$iv3, null);
                            throw th;
                        } catch (Throwable th5) {
                            th2 = th5;
                            $this$withLock_u24default$iv2.unlock(owner$iv2);
                            throw th2;
                        }
                    }
                case 1:
                    c16232 = this;
                    mutator2 = null;
                    internalMutatorMutex = (InternalMutatorMutex) c16232.L$4;
                    obj = c16232.L$3;
                    function2 = (Function2) c16232.L$2;
                    owner$iv = null;
                    $this$withLock_u24default$iv = (Mutex) c16232.L$1;
                    mutator = (Mutator) c16232.L$0;
                    ResultKt.throwOnFailure($result);
                    c16232.L$0 = mutator;
                    c16232.L$1 = $this$withLock_u24default$iv;
                    c16232.L$2 = internalMutatorMutex;
                    c16232.L$3 = null;
                    c16232.L$4 = null;
                    c16232.label = 2;
                    objInvoke = function2.invoke(obj, c16232);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objInvoke;
                    owner$iv2 = owner$iv;
                    $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                    owner$iv3 = mutator;
                    MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(internalMutatorMutex.currentMutator, owner$iv3, null);
                    $this$withLock_u24default$iv2.unlock(owner$iv2);
                    return $result;
                case 2:
                    c16233 = this;
                    mutator3 = null;
                    internalMutatorMutex = (InternalMutatorMutex) c16233.L$2;
                    owner$iv2 = null;
                    $this$withLock_u24default$iv2 = (Mutex) c16233.L$1;
                    owner$iv3 = (Mutator) c16233.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(internalMutatorMutex.currentMutator, owner$iv3, null);
                        $this$withLock_u24default$iv2.unlock(owner$iv2);
                        return $result;
                    } catch (Throwable th6) {
                        th = th6;
                        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(internalMutatorMutex.currentMutator, owner$iv3, null);
                        throw th;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final <T, R> Object mutateWith(T t, MutatePriority priority, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        return CoroutineScopeKt.coroutineScope(new C16232(priority, this, function2, t, null), continuation);
    }

    public final boolean tryMutate(Function0<Unit> block) {
        boolean didLock = Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null);
        if (didLock) {
            try {
                block.invoke();
            } finally {
                Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
            }
        }
        return didLock;
    }
}
