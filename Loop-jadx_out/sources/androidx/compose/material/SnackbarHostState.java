package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: SnackbarHost.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015R/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m195d2 = {"Landroidx/compose/material/SnackbarHostState;", "", "()V", "<set-?>", "Landroidx/compose/material/SnackbarData;", "currentSnackbarData", "getCurrentSnackbarData", "()Landroidx/compose/material/SnackbarData;", "setCurrentSnackbarData", "(Landroidx/compose/material/SnackbarData;)V", "currentSnackbarData$delegate", "Landroidx/compose/runtime/MutableState;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "showSnackbar", "Landroidx/compose/material/SnackbarResult;", "message", "", "actionLabel", "duration", "Landroidx/compose/material/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/material/SnackbarDuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SnackbarDataImpl", "material_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SnackbarHostState {
    public static final int $stable = 0;
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    /* JADX INFO: renamed from: currentSnackbarData$delegate, reason: from kotlin metadata */
    private final MutableState currentSnackbarData = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarHostState$showSnackbar$1 */
    /* JADX INFO: compiled from: SnackbarHost.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.material.SnackbarHostState", m210f = "SnackbarHost.kt", m211i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, m212l = {387, 390}, m213m = "showSnackbar", m214n = {"this", "message", "actionLabel", "duration", "$this$withLock_u24default$iv", "this", "message", "actionLabel", "duration", "$this$withLock_u24default$iv", "$completion$iv"}, m215s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    static final class C11081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C11081(Continuation<? super C11081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnackbarHostState.this.showSnackbar(null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentSnackbarData(SnackbarData snackbarData) {
        MutableState $this$setValue$iv = this.currentSnackbarData;
        $this$setValue$iv.setValue(snackbarData);
    }

    public final SnackbarData getCurrentSnackbarData() {
        State $this$getValue$iv = this.currentSnackbarData;
        return (SnackbarData) $this$getValue$iv.getValue();
    }

    public static /* synthetic */ Object showSnackbar$default(SnackbarHostState snackbarHostState, String str, String str2, SnackbarDuration snackbarDuration, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            snackbarDuration = SnackbarDuration.Short;
        }
        return snackbarHostState.showSnackbar(str, str2, snackbarDuration, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00f8 A[Catch: all -> 0x0111, TRY_LEAVE, TryCatch #0 {all -> 0x0111, blocks: (B:27:0x00e2, B:29:0x00f8), top: B:52:0x00e2 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0100 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x0101  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object showSnackbar(String message, String actionLabel, SnackbarDuration snackbarDuration, Continuation<? super SnackbarResult> continuation) throws Throwable {
        C11081 c11081;
        SnackbarDuration duration;
        Mutex $this$withLock_u24default$iv;
        SnackbarHostState snackbarHostState;
        String message2;
        String message3;
        Object owner$iv;
        Continuation $completion$iv;
        Object owner$iv2;
        Object result;
        Mutex $this$withLock_u24default$iv2;
        Object owner$iv3;
        if (continuation instanceof C11081) {
            c11081 = (C11081) continuation;
            if ((c11081.label & Integer.MIN_VALUE) != 0) {
                c11081.label -= Integer.MIN_VALUE;
            } else {
                c11081 = new C11081(continuation);
            }
        } else {
            c11081 = new C11081(continuation);
        }
        Object $result = c11081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c11081.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                duration = snackbarDuration;
                $this$withLock_u24default$iv = this.mutex;
                c11081.L$0 = this;
                c11081.L$1 = message;
                c11081.L$2 = actionLabel;
                c11081.L$3 = duration;
                c11081.L$4 = $this$withLock_u24default$iv;
                c11081.label = 1;
                if ($this$withLock_u24default$iv.lock(null, c11081) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                snackbarHostState = this;
                message2 = message;
                message3 = actionLabel;
                owner$iv = null;
                $completion$iv = c11081;
                try {
                    c11081.L$0 = snackbarHostState;
                    c11081.L$1 = message2;
                    c11081.L$2 = message3;
                    c11081.L$3 = duration;
                    c11081.L$4 = $this$withLock_u24default$iv;
                    c11081.L$5 = $completion$iv;
                    c11081.label = 2;
                    Continuation uCont$iv = $completion$iv;
                    try {
                        Continuation $continuation = IntrinsicsKt.intercepted(uCont$iv);
                        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl($continuation, 1);
                        cancellable$iv.initCancellability();
                        CancellableContinuationImpl continuation2 = cancellable$iv;
                        try {
                            snackbarHostState.setCurrentSnackbarData(new SnackbarDataImpl(message2, message3, duration, continuation2));
                            result = cancellable$iv.getResult();
                            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                DebugProbesKt.probeCoroutineSuspended($completion$iv);
                            }
                            if (result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            try {
                                snackbarHostState.setCurrentSnackbarData(null);
                                $this$withLock_u24default$iv.unlock(owner$iv);
                                return result;
                            } catch (Throwable th) {
                                th = th;
                                owner$iv3 = owner$iv;
                                $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                                $this$withLock_u24default$iv2.unlock(owner$iv3);
                                throw th;
                            }
                            break;
                        } catch (Throwable th2) {
                            th = th2;
                            owner$iv2 = owner$iv;
                            try {
                                snackbarHostState.setCurrentSnackbarData(null);
                                throw th;
                            } catch (Throwable th3) {
                                th = th3;
                                $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                                owner$iv3 = owner$iv2;
                                $this$withLock_u24default$iv2.unlock(owner$iv3);
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        owner$iv2 = owner$iv;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    owner$iv2 = owner$iv;
                }
                break;
            case 1:
                Mutex $this$withLock_u24default$iv3 = (Mutex) c11081.L$4;
                duration = (SnackbarDuration) c11081.L$3;
                String actionLabel2 = (String) c11081.L$2;
                String message4 = (String) c11081.L$1;
                SnackbarHostState snackbarHostState2 = (SnackbarHostState) c11081.L$0;
                ResultKt.throwOnFailure($result);
                owner$iv = null;
                $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                snackbarHostState = snackbarHostState2;
                message2 = message4;
                message3 = actionLabel2;
                $completion$iv = c11081;
                c11081.L$0 = snackbarHostState;
                c11081.L$1 = message2;
                c11081.L$2 = message3;
                c11081.L$3 = duration;
                c11081.L$4 = $this$withLock_u24default$iv;
                c11081.L$5 = $completion$iv;
                c11081.label = 2;
                Continuation uCont$iv2 = $completion$iv;
                Continuation $continuation2 = IntrinsicsKt.intercepted(uCont$iv2);
                CancellableContinuationImpl cancellable$iv2 = new CancellableContinuationImpl($continuation2, 1);
                cancellable$iv2.initCancellability();
                CancellableContinuationImpl continuation3 = cancellable$iv2;
                snackbarHostState.setCurrentSnackbarData(new SnackbarDataImpl(message2, message3, duration, continuation3));
                result = cancellable$iv2.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended($completion$iv);
                    break;
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                snackbarHostState.setCurrentSnackbarData(null);
                $this$withLock_u24default$iv.unlock(owner$iv);
                return result;
            case 2:
                $this$withLock_u24default$iv = (Mutex) c11081.L$4;
                snackbarHostState = (SnackbarHostState) c11081.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    result = $result;
                    owner$iv = null;
                    snackbarHostState.setCurrentSnackbarData(null);
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    return result;
                } catch (Throwable th6) {
                    th = th6;
                    owner$iv2 = null;
                    snackbarHostState.setCurrentSnackbarData(null);
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: SnackbarHost.kt */
    @Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, m195d2 = {"Landroidx/compose/material/SnackbarHostState$SnackbarDataImpl;", "Landroidx/compose/material/SnackbarData;", "message", "", "actionLabel", "duration", "Landroidx/compose/material/SnackbarDuration;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/compose/material/SnackbarResult;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/material/SnackbarDuration;Lkotlinx/coroutines/CancellableContinuation;)V", "getActionLabel", "()Ljava/lang/String;", "getDuration", "()Landroidx/compose/material/SnackbarDuration;", "getMessage", "dismiss", "", "performAction", "material_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class SnackbarDataImpl implements SnackbarData {
        private final String actionLabel;
        private final CancellableContinuation<SnackbarResult> continuation;
        private final SnackbarDuration duration;
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public SnackbarDataImpl(String message, String actionLabel, SnackbarDuration duration, CancellableContinuation<? super SnackbarResult> cancellableContinuation) {
            this.message = message;
            this.actionLabel = actionLabel;
            this.duration = duration;
            this.continuation = cancellableContinuation;
        }

        @Override // androidx.compose.material.SnackbarData
        public String getMessage() {
            return this.message;
        }

        @Override // androidx.compose.material.SnackbarData
        public String getActionLabel() {
            return this.actionLabel;
        }

        @Override // androidx.compose.material.SnackbarData
        public SnackbarDuration getDuration() {
            return this.duration;
        }

        @Override // androidx.compose.material.SnackbarData
        public void performAction() {
            if (this.continuation.isActive()) {
                CancellableContinuation<SnackbarResult> cancellableContinuation = this.continuation;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m7693constructorimpl(SnackbarResult.ActionPerformed));
            }
        }

        @Override // androidx.compose.material.SnackbarData
        public void dismiss() {
            if (this.continuation.isActive()) {
                CancellableContinuation<SnackbarResult> cancellableContinuation = this.continuation;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m7693constructorimpl(SnackbarResult.Dismissed));
            }
        }
    }
}
