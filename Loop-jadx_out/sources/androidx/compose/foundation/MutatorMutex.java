package androidx.compose.foundation;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
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
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: MutatorMutex.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J<\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eH\u0086@¢\u0006\u0002\u0010\u0010JU\u0010\u0011\u001a\u0002H\n\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\n2\u0006\u0010\u0013\u001a\u0002H\u00122\b\b\u0002\u0010\u000b\u001a\u00020\f2'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014¢\u0006\u0002\b\u0015H\u0086@¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0001J\u0017\u0010\u0019\u001a\u00020\u00182\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0086\bJ\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0001R\"\u0010\u0003\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m195d2 = {"Landroidx/compose/foundation/MutatorMutex;", "", "()V", "currentMutator", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/foundation/MutatorMutex$Mutator;", "Landroidx/compose/foundation/AtomicReference;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "mutate", "R", "priority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mutateWith", ExifInterface.GPS_DIRECTION_TRUE, "receiver", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryLock", "", "tryMutate", "Lkotlin/Function0;", "", "tryMutateOrCancel", "mutator", "unlock", "Mutator", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MutatorMutex {
    public static final int $stable = 0;
    private final AtomicReference<Mutator> currentMutator = new AtomicReference<>(null);
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    /* JADX INFO: compiled from: MutatorMutex.kt */
    @Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0000J\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, m195d2 = {"Landroidx/compose/foundation/MutatorMutex$Mutator;", "", "priority", "Landroidx/compose/foundation/MutatePriority;", "job", "Lkotlinx/coroutines/Job;", "(Landroidx/compose/foundation/MutatePriority;Lkotlinx/coroutines/Job;)V", "getJob", "()Lkotlinx/coroutines/Job;", "getPriority", "()Landroidx/compose/foundation/MutatePriority;", "canInterrupt", "", "other", "cancel", "", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
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
            this.job.cancel((CancellationException) new MutationInterruptedException());
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

    public static /* synthetic */ Object mutate$default(MutatorMutex mutatorMutex, MutatePriority mutatePriority, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return mutatorMutex.mutate(mutatePriority, function1, continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.foundation.MutatorMutex$mutate$2 */
    /* JADX INFO: compiled from: MutatorMutex.kt */
    @Metadata(m194d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.MutatorMutex$mutate$2", m210f = "MutatorMutex.kt", m211i = {0, 0, 1, 1}, m212l = {220, 132}, m213m = "invokeSuspend", m214n = {"mutator", "$this$withLock_u24default$iv", "mutator", "$this$withLock_u24default$iv"}, m215s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C03332<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
        final /* synthetic */ MutatePriority $priority;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ MutatorMutex this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03332(MutatePriority mutatePriority, MutatorMutex mutatorMutex, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super C03332> continuation) {
            super(2, continuation);
            this.$priority = mutatePriority;
            this.this$0 = mutatorMutex;
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03332 c03332 = new C03332(this.$priority, this.this$0, this.$block, continuation);
            c03332.L$0 = obj;
            return c03332;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
            return ((C03332) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x00a9 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:20:0x00aa  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C03332<R> c03332;
            Function1<Continuation<? super R>, Object> function1;
            Mutator mutator;
            Mutator mutator2;
            Mutex $this$withLock_u24default$iv;
            MutatorMutex mutatorMutex;
            Object owner$iv;
            Object owner$iv2;
            Mutex $this$withLock_u24default$iv2;
            Mutator mutator3;
            Throwable th;
            C03332<R> c03333;
            Mutator mutator4;
            Object objInvoke;
            Throwable th2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c03332 = this;
                    CoroutineScope $this$coroutineScope = (CoroutineScope) c03332.L$0;
                    MutatePriority mutatePriority = c03332.$priority;
                    CoroutineContext.Element element = $this$coroutineScope.getCoroutineContext().get(Job.INSTANCE);
                    Intrinsics.checkNotNull(element);
                    Mutator mutator5 = new Mutator(mutatePriority, (Job) element);
                    c03332.this$0.tryMutateOrCancel(mutator5);
                    Mutex $this$withLock_u24default$iv3 = c03332.this$0.mutex;
                    function1 = c03332.$block;
                    MutatorMutex mutatorMutex2 = c03332.this$0;
                    c03332.L$0 = mutator5;
                    c03332.L$1 = $this$withLock_u24default$iv3;
                    c03332.L$2 = function1;
                    c03332.L$3 = mutatorMutex2;
                    c03332.label = 1;
                    if ($this$withLock_u24default$iv3.lock(null, c03332) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutator = mutator5;
                    mutator2 = null;
                    $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                    mutatorMutex = mutatorMutex2;
                    owner$iv = null;
                    try {
                        c03332.L$0 = mutator;
                        c03332.L$1 = $this$withLock_u24default$iv;
                        c03332.L$2 = mutatorMutex;
                        c03332.L$3 = null;
                        c03332.label = 2;
                        objInvoke = function1.invoke(c03332);
                        if (objInvoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = objInvoke;
                        owner$iv2 = owner$iv;
                        $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                        mutator3 = mutator;
                        try {
                            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(mutatorMutex.currentMutator, mutator3, null);
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
                        c03333 = c03332;
                        mutator4 = mutator2;
                        try {
                            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(mutatorMutex.currentMutator, mutator3, null);
                            throw th;
                        } catch (Throwable th5) {
                            th2 = th5;
                            $this$withLock_u24default$iv2.unlock(owner$iv2);
                            throw th2;
                        }
                    }
                case 1:
                    c03332 = this;
                    mutator2 = null;
                    mutatorMutex = (MutatorMutex) c03332.L$3;
                    function1 = (Function1) c03332.L$2;
                    owner$iv = null;
                    $this$withLock_u24default$iv = (Mutex) c03332.L$1;
                    mutator = (Mutator) c03332.L$0;
                    ResultKt.throwOnFailure($result);
                    c03332.L$0 = mutator;
                    c03332.L$1 = $this$withLock_u24default$iv;
                    c03332.L$2 = mutatorMutex;
                    c03332.L$3 = null;
                    c03332.label = 2;
                    objInvoke = function1.invoke(c03332);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objInvoke;
                    owner$iv2 = owner$iv;
                    $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                    mutator3 = mutator;
                    MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(mutatorMutex.currentMutator, mutator3, null);
                    $this$withLock_u24default$iv2.unlock(owner$iv2);
                    return $result;
                case 2:
                    c03333 = this;
                    mutator4 = null;
                    mutatorMutex = (MutatorMutex) c03333.L$2;
                    owner$iv2 = null;
                    $this$withLock_u24default$iv2 = (Mutex) c03333.L$1;
                    mutator3 = (Mutator) c03333.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(mutatorMutex.currentMutator, mutator3, null);
                        $this$withLock_u24default$iv2.unlock(owner$iv2);
                        return $result;
                    } catch (Throwable th6) {
                        th = th6;
                        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(mutatorMutex.currentMutator, mutator3, null);
                        throw th;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final <R> Object mutate(MutatePriority priority, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        return CoroutineScopeKt.coroutineScope(new C03332(priority, this, function1, null), continuation);
    }

    public static /* synthetic */ Object mutateWith$default(MutatorMutex mutatorMutex, Object obj, MutatePriority mutatePriority, Function2 function2, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return mutatorMutex.mutateWith(obj, mutatePriority, function2, continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.foundation.MutatorMutex$mutateWith$2 */
    /* JADX INFO: compiled from: MutatorMutex.kt */
    @Metadata(m194d1 = {"\u0000\b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u00020\u0003H\u008a@"}, m195d2 = {"<anonymous>", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.MutatorMutex$mutateWith$2", m210f = "MutatorMutex.kt", m211i = {0, 0, 1, 1}, m212l = {220, 173}, m213m = "invokeSuspend", m214n = {"mutator", "$this$withLock_u24default$iv", "mutator", "$this$withLock_u24default$iv"}, m215s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C03342<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function2<T, Continuation<? super R>, Object> $block;
        final /* synthetic */ MutatePriority $priority;
        final /* synthetic */ T $receiver;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ MutatorMutex this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03342(MutatePriority mutatePriority, MutatorMutex mutatorMutex, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, T t, Continuation<? super C03342> continuation) {
            super(2, continuation);
            this.$priority = mutatePriority;
            this.this$0 = mutatorMutex;
            this.$block = function2;
            this.$receiver = t;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03342 c03342 = new C03342(this.$priority, this.this$0, this.$block, this.$receiver, continuation);
            c03342.L$0 = obj;
            return c03342;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
            return ((C03342) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x00b1 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:20:0x00b2  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C03342<R> c03342;
            Function2 function2;
            Object obj;
            Object mutator;
            Mutator mutator2;
            Mutex $this$withLock_u24default$iv;
            MutatorMutex mutatorMutex;
            Object owner$iv;
            Object owner$iv2;
            Mutex $this$withLock_u24default$iv2;
            Object owner$iv3;
            Throwable th;
            C03342<R> c03343;
            Mutator mutator3;
            Object objInvoke;
            Throwable th2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c03342 = this;
                    CoroutineScope $this$coroutineScope = (CoroutineScope) c03342.L$0;
                    MutatePriority mutatePriority = c03342.$priority;
                    CoroutineContext.Element element = $this$coroutineScope.getCoroutineContext().get(Job.INSTANCE);
                    Intrinsics.checkNotNull(element);
                    Mutator mutator4 = new Mutator(mutatePriority, (Job) element);
                    c03342.this$0.tryMutateOrCancel(mutator4);
                    Mutex $this$withLock_u24default$iv3 = c03342.this$0.mutex;
                    function2 = c03342.$block;
                    obj = c03342.$receiver;
                    MutatorMutex mutatorMutex2 = c03342.this$0;
                    c03342.L$0 = mutator4;
                    c03342.L$1 = $this$withLock_u24default$iv3;
                    c03342.L$2 = function2;
                    c03342.L$3 = obj;
                    c03342.L$4 = mutatorMutex2;
                    c03342.label = 1;
                    if ($this$withLock_u24default$iv3.lock(null, c03342) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutator = mutator4;
                    mutator2 = null;
                    $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                    mutatorMutex = mutatorMutex2;
                    owner$iv = null;
                    try {
                        c03342.L$0 = mutator;
                        c03342.L$1 = $this$withLock_u24default$iv;
                        c03342.L$2 = mutatorMutex;
                        c03342.L$3 = null;
                        c03342.L$4 = null;
                        c03342.label = 2;
                        objInvoke = function2.invoke(obj, c03342);
                        if (objInvoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = objInvoke;
                        owner$iv2 = owner$iv;
                        $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                        owner$iv3 = mutator;
                        try {
                            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(mutatorMutex.currentMutator, owner$iv3, null);
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
                        c03343 = c03342;
                        mutator3 = mutator2;
                        try {
                            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(mutatorMutex.currentMutator, owner$iv3, null);
                            throw th;
                        } catch (Throwable th5) {
                            th2 = th5;
                            $this$withLock_u24default$iv2.unlock(owner$iv2);
                            throw th2;
                        }
                    }
                case 1:
                    c03342 = this;
                    mutator2 = null;
                    mutatorMutex = (MutatorMutex) c03342.L$4;
                    obj = c03342.L$3;
                    function2 = (Function2) c03342.L$2;
                    owner$iv = null;
                    $this$withLock_u24default$iv = (Mutex) c03342.L$1;
                    mutator = (Mutator) c03342.L$0;
                    ResultKt.throwOnFailure($result);
                    c03342.L$0 = mutator;
                    c03342.L$1 = $this$withLock_u24default$iv;
                    c03342.L$2 = mutatorMutex;
                    c03342.L$3 = null;
                    c03342.L$4 = null;
                    c03342.label = 2;
                    objInvoke = function2.invoke(obj, c03342);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objInvoke;
                    owner$iv2 = owner$iv;
                    $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                    owner$iv3 = mutator;
                    MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(mutatorMutex.currentMutator, owner$iv3, null);
                    $this$withLock_u24default$iv2.unlock(owner$iv2);
                    return $result;
                case 2:
                    c03343 = this;
                    mutator3 = null;
                    mutatorMutex = (MutatorMutex) c03343.L$2;
                    owner$iv2 = null;
                    $this$withLock_u24default$iv2 = (Mutex) c03343.L$1;
                    owner$iv3 = (Mutator) c03343.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(mutatorMutex.currentMutator, owner$iv3, null);
                        $this$withLock_u24default$iv2.unlock(owner$iv2);
                        return $result;
                    } catch (Throwable th6) {
                        th = th6;
                        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(mutatorMutex.currentMutator, owner$iv3, null);
                        throw th;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final <T, R> Object mutateWith(T t, MutatePriority priority, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        return CoroutineScopeKt.coroutineScope(new C03342(priority, this, function2, t, null), continuation);
    }

    public final boolean tryMutate(Function0<Unit> block) {
        boolean didLock = tryLock();
        if (didLock) {
            try {
                block.invoke();
            } finally {
                InlineMarker.finallyStart(1);
                unlock();
                InlineMarker.finallyEnd(1);
            }
        }
        return didLock;
    }

    public final boolean tryLock() {
        return Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null);
    }

    public final void unlock() {
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
    }
}
