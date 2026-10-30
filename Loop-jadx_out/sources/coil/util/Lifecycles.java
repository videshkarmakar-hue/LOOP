package coil.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: renamed from: coil.util.-Lifecycles, reason: invalid class name */
/* JADX INFO: compiled from: Lifecycles.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, m195d2 = {"awaitStarted", "", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAndAddObserver", "observer", "Landroidx/lifecycle/LifecycleObserver;", "coil-base_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Lifecycles {

    /* JADX INFO: renamed from: coil.util.-Lifecycles$awaitStarted$1 */
    /* JADX INFO: compiled from: Lifecycles.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "coil.util.-Lifecycles", m210f = "Lifecycles.kt", m211i = {0, 0}, m212l = {44}, m213m = "awaitStarted", m214n = {"$this$awaitStarted", "observer"}, m215s = {"L$0", "L$1"})
    static final class C26041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C26041(Continuation<? super C26041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Lifecycles.awaitStarted(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r9v0, types: [T, coil.util.-Lifecycles$awaitStarted$2$1] */
    public static final Object awaitStarted(Lifecycle lifecycle, Continuation<? super Unit> continuation) throws Throwable {
        C26041 c26041;
        Lifecycle $this$awaitStarted;
        Ref.ObjectRef observer;
        Throwable th;
        LifecycleObserver p0;
        LifecycleObserver p1;
        if (continuation instanceof C26041) {
            c26041 = (C26041) continuation;
            if ((c26041.label & Integer.MIN_VALUE) != 0) {
                c26041.label -= Integer.MIN_VALUE;
            } else {
                c26041 = new C26041(continuation);
            }
        } else {
            c26041 = new C26041(continuation);
        }
        C26041 c26042 = c26041;
        Object $result = c26042.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c26042.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$awaitStarted = lifecycle;
                if ($this$awaitStarted.getState().isAtLeast(Lifecycle.State.STARTED)) {
                    return Unit.INSTANCE;
                }
                Ref.ObjectRef observer2 = new Ref.ObjectRef();
                try {
                    c26042.L$0 = $this$awaitStarted;
                    c26042.L$1 = observer2;
                    c26042.label = 1;
                    C26041 uCont$iv = c26042;
                    CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                    cancellable$iv.initCancellability();
                    final CancellableContinuationImpl continuation2 = cancellable$iv;
                    observer2.element = new DefaultLifecycleObserver() { // from class: coil.util.-Lifecycles$awaitStarted$2$1
                        @Override // androidx.lifecycle.DefaultLifecycleObserver
                        public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
                            Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
                        }

                        @Override // androidx.lifecycle.DefaultLifecycleObserver
                        public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
                            Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
                        }

                        @Override // androidx.lifecycle.DefaultLifecycleObserver
                        public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                            Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
                        }

                        @Override // androidx.lifecycle.DefaultLifecycleObserver
                        public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
                            Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
                        }

                        @Override // androidx.lifecycle.DefaultLifecycleObserver
                        public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                            Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
                        }

                        @Override // androidx.lifecycle.DefaultLifecycleObserver
                        public void onStart(LifecycleOwner owner) {
                            CancellableContinuation<Unit> cancellableContinuation = continuation2;
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m7693constructorimpl(Unit.INSTANCE));
                        }
                    };
                    T t = observer2.element;
                    Intrinsics.checkNotNull(t);
                    $this$awaitStarted.addObserver((LifecycleObserver) t);
                    Object result = cancellable$iv.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(c26042);
                        break;
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    observer = observer2;
                    p1 = (LifecycleObserver) observer.element;
                    if (p1 != null) {
                        $this$awaitStarted.removeObserver(p1);
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    observer = observer2;
                    th = th2;
                    p0 = (LifecycleObserver) observer.element;
                    if (p0 != null) {
                        $this$awaitStarted.removeObserver(p0);
                    }
                    throw th;
                }
            case 1:
                observer = (Ref.ObjectRef) c26042.L$1;
                $this$awaitStarted = (Lifecycle) c26042.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    p1 = (LifecycleObserver) observer.element;
                    if (p1 != null) {
                        $this$awaitStarted.removeObserver(p1);
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    p0 = (LifecycleObserver) observer.element;
                    if (p0 != null) {
                        $this$awaitStarted.removeObserver(p0);
                    }
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final void removeAndAddObserver(Lifecycle $this$removeAndAddObserver, LifecycleObserver observer) {
        $this$removeAndAddObserver.removeObserver(observer);
        $this$removeAndAddObserver.addObserver(observer);
    }
}
