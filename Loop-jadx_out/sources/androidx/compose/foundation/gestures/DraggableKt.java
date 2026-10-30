package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p001ui.input.pointer.PointerEventKt;
import androidx.compose.p001ui.input.pointer.PointerInputChange;
import androidx.compose.p001ui.input.pointer.util.VelocityTracker;
import androidx.compose.p001ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.p001ui.unit.Velocity;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u009c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0012\u001a!\u0010\u0013\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0012H\u0007¢\u0006\u0002\u0010\u0014\u001aR\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016*\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001a0\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u0010!\u001aS\u0010\"\u001a\u00020\u001a*\u00020\u00182\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001a0\u0012H\u0082@ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aË\u0001\u0010+\u001a\u00020,*\u00020,2\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020\u001a2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u0010\u001b\u001a\u00020\u001a2>\b\u0002\u00103\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001¢\u0006\u0002\b\n2>\b\u0002\u00104\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001¢\u0006\u0002\b\n2\b\b\u0002\u00105\u001a\u00020\u001aH\u0007¢\u0006\u0002\u00106\u001aG\u00107\u001a\u00020\u001a*\u00020\u00182\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001a0\u00122\u0006\u00108\u001a\u0002092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\b0\u0012H\u0082@ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a\u001e\u0010=\u001a\u00020\r*\u00020\u00032\u0006\u0010.\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a\u001e\u0010=\u001a\u00020\r*\u00020@2\u0006\u0010.\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010?\"F\u0010\u0000\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b\"F\u0010\f\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006B"}, m195d2 = {"NoOpOnDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "NoOpOnDragStopped", "", "velocity", "DraggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "onDelta", "Lkotlin/Function1;", "rememberDraggableState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/DraggableState;", "awaitDownAndSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "canDrag", "", "startDragImmediately", "Lkotlin/Function0;", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "pointerDirectionConfig", "Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/input/pointer/util/VelocityTracker;Landroidx/compose/foundation/gestures/PointerDirectionConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDrag", "startEvent", "initialDelta", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "Landroidx/compose/foundation/gestures/DragEvent;", "hasDragged", "awaitDrag-JHbHoSQ", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;JLandroidx/compose/ui/input/pointer/util/VelocityTracker;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "draggable", "Landroidx/compose/ui/Modifier;", "state", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "onDragStarted", "onDragStopped", "reverseDirection", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/DraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "onDragOrUp", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "onDrag", "onDragOrUp-Axegvzg", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/jvm/functions/Function1;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toFloat", "toFloat-3MmeM6k", "(JLandroidx/compose/foundation/gestures/Orientation;)F", "Landroidx/compose/ui/unit/Velocity;", "toFloat-sF-c-tU", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DraggableKt {
    private static final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> NoOpOnDragStarted = new DraggableKt$NoOpOnDragStarted$1(null);
    private static final Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> NoOpOnDragStopped = new DraggableKt$NoOpOnDragStopped$1(null);

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$1 */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.DraggableKt", m210f = "Draggable.kt", m211i = {0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, m212l = {607, 616, 723, 765}, m213m = "awaitDownAndSlop", m214n = {"$this$awaitDownAndSlop", "canDrag", "startDragImmediately", "velocityTracker", "pointerDirectionConfig", "$this$awaitDownAndSlop", "velocityTracker", "pointerDirectionConfig", "pointerDirectionConfig", "initialDelta", "postPointerSlop", "$this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv", "pointer$iv", "touchSlop$iv", "totalPositionChange$iv", "pointerDirectionConfig", "initialDelta", "postPointerSlop", "$this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv", "pointer$iv", "dragEvent$iv", "touchSlop$iv", "totalPositionChange$iv"}, m215s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "F$0", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "F$0", "J$0"})
    static final class C03951 extends ContinuationImpl {
        float F$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C03951(Continuation<? super C03951> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DraggableKt.awaitDownAndSlop(null, null, null, null, null, this);
        }
    }

    public static final DraggableState DraggableState(Function1<? super Float, Unit> function1) {
        return new DefaultDraggableState(function1);
    }

    public static final DraggableState rememberDraggableState(Function1<? super Float, Unit> function1, Composer $composer, int $changed) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -183245213, "C(rememberDraggableState)143@6248L29,144@6289L61:Draggable.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-183245213, $changed, -1, "androidx.compose.foundation.gestures.rememberDraggableState (Draggable.kt:142)");
        }
        final State onDeltaState = SnapshotStateKt.rememberUpdatedState(function1, $composer, $changed & 14);
        ComposerKt.sourceInformationMarkerStart($composer, -1066219498, "CC(remember):Draggable.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = DraggableState(new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.DraggableKt$rememberDraggableState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                    invoke(f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float it) {
                    onDeltaState.getValue().invoke(Float.valueOf(it));
                }
            });
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        DraggableState draggableState = (DraggableState) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return draggableState;
    }

    public static final Modifier draggable(Modifier $this$draggable, DraggableState state, Orientation orientation, boolean enabled, MutableInteractionSource interactionSource, boolean startDragImmediately, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> function4, boolean reverseDirection) {
        return $this$draggable.then(new DraggableElement(state, orientation, enabled, interactionSource, startDragImmediately, function3, function4, reverseDirection));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:39:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:42:0x01de A[LOOP:0: B:38:0x01b9->B:42:0x01de, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code duplicated, block: B:83:0x01f5 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x024a -> B:33:0x0181). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x029a -> B:69:0x02a3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x02df -> B:33:0x0181). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object awaitDownAndSlop(androidx.compose.p001ui.input.pointer.AwaitPointerEventScope r28, kotlin.jvm.functions.Function1<? super androidx.compose.p001ui.input.pointer.PointerInputChange, java.lang.Boolean> r29, kotlin.jvm.functions.Function0<java.lang.Boolean> r30, androidx.compose.p001ui.input.pointer.util.VelocityTracker r31, androidx.compose.foundation.gestures.PointerDirectionConfig r32, kotlin.coroutines.Continuation<? super kotlin.Pair<androidx.compose.p001ui.input.pointer.PointerInputChange, androidx.compose.p001ui.geometry.Offset>> r33) {
        /*
            Method dump skipped, instruction units count: 766
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.awaitDownAndSlop(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.ui.input.pointer.util.VelocityTracker, androidx.compose.foundation.gestures.PointerDirectionConfig, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: awaitDrag-JHbHoSQ, reason: not valid java name */
    public static final Object m634awaitDragJHbHoSQ(AwaitPointerEventScope $this$awaitDrag_u2dJHbHoSQ, PointerInputChange startEvent, long initialDelta, final VelocityTracker velocityTracker, final SendChannel<? super DragEvent> sendChannel, Function1<? super PointerInputChange, Boolean> function1, Continuation<? super Boolean> continuation) {
        float xSign = Math.signum(Offset.m4049getXimpl(startEvent.getPosition()));
        float ySign = Math.signum(Offset.m4050getYimpl(startEvent.getPosition()));
        long adjustedStart = Offset.m4053minusMKHz9U(startEvent.getPosition(), OffsetKt.Offset(Offset.m4049getXimpl(initialDelta) * xSign, Offset.m4050getYimpl(initialDelta) * ySign));
        if (sendChannel != null) {
            ChannelResult.m9205boximpl(sendChannel.mo9195trySendJP2dKIU(new DragEvent.DragStarted(adjustedStart, null)));
        }
        if (sendChannel != null) {
            ChannelResult.m9205boximpl(sendChannel.mo9195trySendJP2dKIU(new DragEvent.DragDelta(initialDelta, null)));
        }
        return m635onDragOrUpAxegvzg($this$awaitDrag_u2dJHbHoSQ, function1, startEvent.getId(), new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DraggableKt$awaitDrag$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange) {
                invoke2(pointerInputChange);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PointerInputChange event) {
                VelocityTrackerKt.addPointerInputChange(velocityTracker, event);
                if (!PointerEventKt.changedToUpIgnoreConsumed(event)) {
                    long delta = PointerEventKt.positionChange(event);
                    event.consume();
                    SendChannel<DragEvent> sendChannel2 = sendChannel;
                    if (sendChannel2 != null) {
                        ChannelResult.m9205boximpl(sendChannel2.mo9195trySendJP2dKIU(new DragEvent.DragDelta(delta, null)));
                    }
                }
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:24:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:27:0x00dd A[LOOP:0: B:23:0x00b8->B:27:0x00dd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0098 -> B:22:0x00a5). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: onDragOrUp-Axegvzg, reason: not valid java name */
    public static final java.lang.Object m635onDragOrUpAxegvzg(androidx.compose.p001ui.input.pointer.AwaitPointerEventScope r22, kotlin.jvm.functions.Function1<? super androidx.compose.p001ui.input.pointer.PointerInputChange, java.lang.Boolean> r23, long r24, kotlin.jvm.functions.Function1<? super androidx.compose.p001ui.input.pointer.PointerInputChange, kotlin.Unit> r26, kotlin.coroutines.Continuation<? super java.lang.Boolean> r27) {
        /*
            Method dump skipped, instruction units count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.m635onDragOrUpAxegvzg(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.jvm.functions.Function1, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toFloat-3MmeM6k, reason: not valid java name */
    public static final float m636toFloat3MmeM6k(long $this$toFloat_u2d3MmeM6k, Orientation orientation) {
        return orientation == Orientation.Vertical ? Offset.m4050getYimpl($this$toFloat_u2d3MmeM6k) : Offset.m4049getXimpl($this$toFloat_u2d3MmeM6k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toFloat-sF-c-tU, reason: not valid java name */
    public static final float m637toFloatsFctU(long $this$toFloat_u2dsF_u2dc_u2dtU, Orientation orientation) {
        return orientation == Orientation.Vertical ? Velocity.m7043getYimpl($this$toFloat_u2dsF_u2dc_u2dtU) : Velocity.m7042getXimpl($this$toFloat_u2dsF_u2dc_u2dtU);
    }
}
