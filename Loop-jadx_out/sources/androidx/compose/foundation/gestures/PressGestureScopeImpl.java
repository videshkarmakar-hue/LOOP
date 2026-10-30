package androidx.compose.foundation.gestures;

import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.DpRect;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: TapGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0015\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\u0017*\u00020\u0018H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0016\u001a\u00020\u0017*\u00020\u001bH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u0018*\u00020\u001bH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\u001e\u001a\u00020\u0018*\u00020\u0005H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001a\u0010\u001e\u001a\u00020\u0018*\u00020\u0017H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010#J\u0017\u0010$\u001a\u00020%*\u00020&H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u0005*\u00020\u0018H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010\"J\u0017\u0010)\u001a\u00020\u0005*\u00020\u001bH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010 J\r\u0010,\u001a\u00020-*\u00020.H\u0097\u0001J\u0017\u0010/\u001a\u00020&*\u00020%H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010(J\u0017\u00101\u001a\u00020\u001b*\u00020\u0018H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103J\u001a\u00101\u001a\u00020\u001b*\u00020\u0005H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00103J\u001a\u00101\u001a\u00020\u001b*\u00020\u0017H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105R\u0014\u0010\u0003\u001a\u00020\u00058\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, m195d2 = {"Landroidx/compose/foundation/gestures/PressGestureScopeImpl;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "density", "(Landroidx/compose/ui/unit/Density;)V", "", "getDensity", "()F", "fontScale", "getFontScale", "isCanceled", "", "isReleased", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "release", "reset", "tryAwaitRelease", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PressGestureScopeImpl implements PressGestureScope, Density {
    public static final int $stable = 0;
    private final /* synthetic */ Density $$delegate_0;
    private boolean isCanceled;
    private boolean isReleased;
    private final Mutex mutex = MutexKt.Mutex(false);

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScopeImpl$awaitRelease$1 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.PressGestureScopeImpl", m210f = "TapGestureDetector.kt", m211i = {}, m212l = {363}, m213m = "awaitRelease", m214n = {}, m215s = {})
    static final class C04011 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C04011(Continuation<? super C04011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PressGestureScopeImpl.this.awaitRelease(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.PressGestureScopeImpl", m210f = "TapGestureDetector.kt", m211i = {0}, m212l = {357}, m213m = "reset", m214n = {"this"}, m215s = {"L$0"})
    static final class C04021 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04021(Continuation<? super C04021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PressGestureScopeImpl.this.reset(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.PressGestureScopeImpl", m210f = "TapGestureDetector.kt", m211i = {0}, m212l = {370}, m213m = "tryAwaitRelease", m214n = {"this"}, m215s = {"L$0"})
    static final class C04031 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04031(Continuation<? super C04031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PressGestureScopeImpl.this.tryAwaitRelease(this);
        }
    }

    @Override // androidx.compose.p001ui.unit.Density
    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.p001ui.unit.FontScaling
    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public int mo560roundToPxR2X_6o(long j) {
        return this.$$delegate_0.mo560roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public int mo561roundToPx0680j_4(float f) {
        return this.$$delegate_0.mo561roundToPx0680j_4(f);
    }

    @Override // androidx.compose.p001ui.unit.FontScaling
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public float mo562toDpGaN1DYA(long j) {
        return this.$$delegate_0.mo562toDpGaN1DYA(j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo563toDpu2uoSUM(float f) {
        return this.$$delegate_0.mo563toDpu2uoSUM(f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo564toDpu2uoSUM(int i) {
        return this.$$delegate_0.mo564toDpu2uoSUM(i);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public long mo565toDpSizekrfVVM(long j) {
        return this.$$delegate_0.mo565toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public float mo566toPxR2X_6o(long j) {
        return this.$$delegate_0.mo566toPxR2X_6o(j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public float mo567toPx0680j_4(float f) {
        return this.$$delegate_0.mo567toPx0680j_4(f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    public Rect toRect(DpRect dpRect) {
        return this.$$delegate_0.toRect(dpRect);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public long mo568toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.mo568toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.p001ui.unit.FontScaling
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public long mo569toSp0xMU5do(float f) {
        return this.$$delegate_0.mo569toSp0xMU5do(f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo570toSpkPz2Gy4(float f) {
        return this.$$delegate_0.mo570toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo571toSpkPz2Gy4(int i) {
        return this.$$delegate_0.mo571toSpkPz2Gy4(i);
    }

    public PressGestureScopeImpl(Density density) {
        this.$$delegate_0 = density;
    }

    public final void cancel() {
        this.isCanceled = true;
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
    }

    public final void release() {
        this.isReleased = true;
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object reset(Continuation<? super Unit> continuation) {
        C04021 c04021;
        PressGestureScopeImpl pressGestureScopeImpl;
        if (continuation instanceof C04021) {
            c04021 = (C04021) continuation;
            if ((c04021.label & Integer.MIN_VALUE) != 0) {
                c04021.label -= Integer.MIN_VALUE;
            } else {
                c04021 = new C04021(continuation);
            }
        } else {
            c04021 = new C04021(continuation);
        }
        C04021 c04022 = c04021;
        Object $result = c04022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c04022.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Mutex mutex = this.mutex;
                c04022.L$0 = this;
                c04022.label = 1;
                if (Mutex.DefaultImpls.lock$default(mutex, null, c04022, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pressGestureScopeImpl = this;
                break;
                break;
            case 1:
                pressGestureScopeImpl = (PressGestureScopeImpl) c04022.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        pressGestureScopeImpl.isReleased = false;
        pressGestureScopeImpl.isCanceled = false;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public Object awaitRelease(Continuation<? super Unit> continuation) {
        C04011 c04011;
        Object objTryAwaitRelease;
        if (continuation instanceof C04011) {
            c04011 = (C04011) continuation;
            if ((c04011.label & Integer.MIN_VALUE) != 0) {
                c04011.label -= Integer.MIN_VALUE;
            } else {
                c04011 = new C04011(continuation);
            }
        } else {
            c04011 = new C04011(continuation);
        }
        C04011 c04012 = c04011;
        Object $result = c04012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c04012.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c04012.label = 1;
                objTryAwaitRelease = tryAwaitRelease(c04012);
                if (objTryAwaitRelease == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objTryAwaitRelease = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!((Boolean) objTryAwaitRelease).booleanValue()) {
            throw new GestureCancellationException("The press gesture was canceled.");
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public Object tryAwaitRelease(Continuation<? super Boolean> continuation) {
        C04031 c04031;
        PressGestureScopeImpl pressGestureScopeImpl;
        PressGestureScopeImpl pressGestureScopeImpl2;
        if (continuation instanceof C04031) {
            c04031 = (C04031) continuation;
            if ((c04031.label & Integer.MIN_VALUE) != 0) {
                c04031.label -= Integer.MIN_VALUE;
            } else {
                c04031 = new C04031(continuation);
            }
        } else {
            c04031 = new C04031(continuation);
        }
        C04031 c04032 = c04031;
        Object $result = c04032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c04032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                pressGestureScopeImpl = this;
                if (!pressGestureScopeImpl.isReleased && !pressGestureScopeImpl.isCanceled) {
                    Mutex mutex = pressGestureScopeImpl.mutex;
                    c04032.L$0 = pressGestureScopeImpl;
                    c04032.label = 1;
                    if (Mutex.DefaultImpls.lock$default(mutex, null, c04032, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pressGestureScopeImpl2 = pressGestureScopeImpl;
                    Mutex.DefaultImpls.unlock$default(pressGestureScopeImpl2.mutex, null, 1, null);
                    pressGestureScopeImpl = pressGestureScopeImpl2;
                }
                return Boxing.boxBoolean(pressGestureScopeImpl.isReleased);
            case 1:
                pressGestureScopeImpl2 = (PressGestureScopeImpl) c04032.L$0;
                ResultKt.throwOnFailure($result);
                Mutex.DefaultImpls.unlock$default(pressGestureScopeImpl2.mutex, null, 1, null);
                pressGestureScopeImpl = pressGestureScopeImpl2;
                return Boxing.boxBoolean(pressGestureScopeImpl.isReleased);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
