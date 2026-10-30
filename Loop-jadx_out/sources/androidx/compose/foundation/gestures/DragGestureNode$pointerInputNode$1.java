package androidx.compose.foundation.gestures;

import androidx.compose.p001ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.input.pointer.util.VelocityTracker;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.foundation.gestures.DragGestureNode$pointerInputNode$1", m210f = "Draggable.kt", m211i = {}, m212l = {464}, m213m = "invokeSuspend", m214n = {}, m215s = {})
final class DragGestureNode$pointerInputNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DragGestureNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DragGestureNode$pointerInputNode$1(DragGestureNode dragGestureNode, Continuation<? super DragGestureNode$pointerInputNode$1> continuation) {
        super(2, continuation);
        this.this$0 = dragGestureNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureNode$pointerInputNode$1 dragGestureNode$pointerInputNode$1 = new DragGestureNode$pointerInputNode$1(this.this$0, continuation);
        dragGestureNode$pointerInputNode$1.L$0 = obj;
        return dragGestureNode$pointerInputNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((DragGestureNode$pointerInputNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$SuspendingPointerInputModifierNode = (PointerInputScope) this.L$0;
                if (!this.this$0.getEnabled()) {
                    return Unit.INSTANCE;
                }
                VelocityTracker velocityTracker = new VelocityTracker();
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(new C03891($this$SuspendingPointerInputModifierNode, this.this$0, velocityTracker, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$pointerInputNode$1$1 */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.DragGestureNode$pointerInputNode$1$1", m210f = "Draggable.kt", m211i = {0}, m212l = {466}, m213m = "invokeSuspend", m214n = {"$this$coroutineScope"}, m215s = {"L$0"})
    static final class C03891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputScope $$this$SuspendingPointerInputModifierNode;
        final /* synthetic */ VelocityTracker $velocityTracker;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DragGestureNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03891(PointerInputScope pointerInputScope, DragGestureNode dragGestureNode, VelocityTracker velocityTracker, Continuation<? super C03891> continuation) {
            super(2, continuation);
            this.$$this$SuspendingPointerInputModifierNode = pointerInputScope;
            this.this$0 = dragGestureNode;
            this.$velocityTracker = velocityTracker;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03891 c03891 = new C03891(this.$$this$SuspendingPointerInputModifierNode, this.this$0, this.$velocityTracker, continuation);
            c03891.L$0 = obj;
            return c03891;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03891) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0054  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            CancellationException exception;
            CoroutineScope $this$coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$coroutineScope2 = (CoroutineScope) this.L$0;
                    try {
                        this.L$0 = $this$coroutineScope2;
                        this.label = 1;
                        if (this.$$this$SuspendingPointerInputModifierNode.awaitPointerEventScope(new AnonymousClass1($this$coroutineScope2, this.this$0, this.$velocityTracker, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    } catch (CancellationException e) {
                        exception = e;
                        $this$coroutineScope = $this$coroutineScope2;
                        if (!CoroutineScopeKt.isActive($this$coroutineScope)) {
                            throw exception;
                        }
                    }
                case 1:
                    $this$coroutineScope = (CoroutineScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        break;
                    } catch (CancellationException e2) {
                        exception = e2;
                        if (!CoroutineScopeKt.isActive($this$coroutineScope)) {
                            throw exception;
                        }
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$pointerInputNode$1$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: Draggable.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.gestures.DragGestureNode$pointerInputNode$1$1$1", m210f = "Draggable.kt", m211i = {0, 1, 1}, m212l = {468, 486}, m213m = "invokeSuspend", m214n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "isDragSuccessful"}, m215s = {"L$0", "L$0", "I$0"})
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ VelocityTracker $velocityTracker;
            int I$0;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            final /* synthetic */ DragGestureNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(CoroutineScope coroutineScope, DragGestureNode dragGestureNode, VelocityTracker velocityTracker, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.this$0 = dragGestureNode;
                this.$velocityTracker = velocityTracker;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.this$0, this.$velocityTracker, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:17:0x0069  */
            /* JADX WARN: Code duplicated, block: B:19:0x0096 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:20:0x0097  */
            /* JADX WARN: Code duplicated, block: B:23:0x009f  */
            /* JADX WARN: Code duplicated, block: B:25:0x00ad  */
            /* JADX WARN: Code duplicated, block: B:27:0x00b3  */
            /* JADX WARN: Code duplicated, block: B:32:0x00ff A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:33:0x0100  */
            /* JADX WARN: Code duplicated, block: B:37:0x0129  */
            /* JADX WARN: Code duplicated, block: B:38:0x013c  */
            /* JADX WARN: Code duplicated, block: B:41:0x0147  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0100 -> B:74:0x010c). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x01ec -> B:15:0x005f). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final java.lang.Object invokeSuspend(java.lang.Object r23) {
                /*
                    Method dump skipped, instruction units count: 510
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode$pointerInputNode$1.C03891.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$pointerInputNode$1$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Draggable.kt */
            @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* synthetic */ class C45461 extends FunctionReferenceImpl implements Function0<Boolean> {
                C45461(Object obj) {
                    super(0, obj, DragGestureNode.class, "startDragImmediately", "startDragImmediately()Z", 0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(((DragGestureNode) this.receiver).getStartDragImmediately());
                }
            }
        }
    }
}
