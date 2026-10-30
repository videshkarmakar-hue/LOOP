package androidx.compose.foundation.text.input.internal;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: CursorAnimationState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0013R\"\u0010\u0003\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, m195d2 = {"Landroidx/compose/foundation/text/input/internal/CursorAnimationState;", "", "()V", "animationJob", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/Job;", "Landroidx/compose/foundation/AtomicReference;", "<set-?>", "", "cursorAlpha", "getCursorAlpha", "()F", "setCursorAlpha", "(F)V", "cursorAlpha$delegate", "Landroidx/compose/runtime/MutableFloatState;", "cancelAndHide", "", "snapToVisibleAndAnimate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CursorAnimationState {
    public static final int $stable = 8;
    private AtomicReference<Job> animationJob = new AtomicReference<>(null);

    /* JADX INFO: renamed from: cursorAlpha$delegate, reason: from kotlin metadata */
    private final MutableFloatState cursorAlpha = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCursorAlpha(float f) {
        MutableFloatState $this$setValue$iv = this.cursorAlpha;
        $this$setValue$iv.setFloatValue(f);
    }

    public final float getCursorAlpha() {
        FloatState $this$getValue$iv = this.cursorAlpha;
        return $this$getValue$iv.getFloatValue();
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2 */
    /* JADX INFO: compiled from: CursorAnimationState.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2", m210f = "CursorAnimationState.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C07992 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C07992(Continuation<? super C07992> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07992 c07992 = CursorAnimationState.this.new C07992(continuation);
            c07992.L$0 = obj;
            return c07992;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C07992) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    Job oldJob = (Job) CursorAnimationState.this.animationJob.getAndSet(null);
                    return Boxing.boxBoolean(MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(CursorAnimationState.this.animationJob, null, BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, null, new AnonymousClass1(oldJob, CursorAnimationState.this, null), 3, null)));
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: CursorAnimationState.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1", m210f = "CursorAnimationState.kt", m211i = {}, m212l = {69, 77, 79}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Job $oldJob;
            int label;
            final /* synthetic */ CursorAnimationState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Job job, CursorAnimationState cursorAnimationState, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$oldJob = job;
                this.this$0 = cursorAnimationState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$oldJob, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:22:0x0051 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:25:0x0063 A[RETURN] */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1] */
            /* JADX WARN: Type inference failed for: r1v10 */
            /* JADX WARN: Type inference failed for: r1v11 */
            /* JADX WARN: Type inference failed for: r1v3 */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r1v5, types: [androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1] */
            /* JADX WARN: Type inference failed for: r1v6, types: [androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1] */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r1v8 */
            /* JADX WARN: Type inference failed for: r1v9 */
            /* JADX WARN: Type inference failed for: r5v3 */
            /* JADX WARN: Type inference failed for: r5v7 */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0061 -> B:20:0x003e). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:13:0x0026
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                /*
                    r8 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r8.label
                    r2 = 500(0x1f4, double:2.47E-321)
                    r4 = 0
                    switch(r1) {
                        case 0: goto L26;
                        case 1: goto L21;
                        case 2: goto L1a;
                        case 3: goto L15;
                        default: goto Lc;
                    }
                Lc:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r0)
                    throw r9
                L15:
                    r1 = r8
                    kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L1f
                    goto L64
                L1a:
                    r1 = r8
                    kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L1f
                    goto L52
                L1f:
                    r0 = move-exception
                    goto L65
                L21:
                    r1 = r8
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L3b
                L26:
                    kotlin.ResultKt.throwOnFailure(r9)
                    r1 = r8
                    kotlinx.coroutines.Job r5 = r1.$oldJob
                    if (r5 == 0) goto L3b
                    r6 = r1
                    kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                    r7 = 1
                    r1.label = r7
                    java.lang.Object r5 = kotlinx.coroutines.JobKt.cancelAndJoin(r5, r6)
                    if (r5 != r0) goto L3b
                    return r0
                L3b:
                L3d:
                    androidx.compose.foundation.text.input.internal.CursorAnimationState r5 = r1.this$0     // Catch: java.lang.Throwable -> L1f
                    r6 = 1065353216(0x3f800000, float:1.0)
                    androidx.compose.foundation.text.input.internal.CursorAnimationState.access$setCursorAlpha(r5, r6)     // Catch: java.lang.Throwable -> L1f
                    r5 = r1
                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Throwable -> L1f
                    r6 = 2
                    r1.label = r6     // Catch: java.lang.Throwable -> L1f
                    java.lang.Object r5 = kotlinx.coroutines.DelayKt.delay(r2, r5)     // Catch: java.lang.Throwable -> L1f
                    if (r5 != r0) goto L52
                    return r0
                L52:
                    androidx.compose.foundation.text.input.internal.CursorAnimationState r5 = r1.this$0     // Catch: java.lang.Throwable -> L1f
                    androidx.compose.foundation.text.input.internal.CursorAnimationState.access$setCursorAlpha(r5, r4)     // Catch: java.lang.Throwable -> L1f
                    r5 = r1
                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Throwable -> L1f
                    r6 = 3
                    r1.label = r6     // Catch: java.lang.Throwable -> L1f
                    java.lang.Object r5 = kotlinx.coroutines.DelayKt.delay(r2, r5)     // Catch: java.lang.Throwable -> L1f
                    if (r5 != r0) goto L64
                    return r0
                L64:
                    goto L3d
                L65:
                    androidx.compose.foundation.text.input.internal.CursorAnimationState r2 = r1.this$0
                    androidx.compose.foundation.text.input.internal.CursorAnimationState.access$setCursorAlpha(r2, r4)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.CursorAnimationState.C07992.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    public final Object snapToVisibleAndAnimate(Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C07992(null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    public final void cancelAndHide() {
        Job job = this.animationJob.getAndSet(null);
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }
}
