package androidx.compose.foundation.gestures;

import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p001ui.input.pointer.PointerEvent;
import androidx.compose.p001ui.input.pointer.PointerEventKt;
import androidx.compose.p001ui.input.pointer.PointerEventPass;
import androidx.compose.p001ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.p001ui.input.pointer.PointerId;
import androidx.compose.p001ui.input.pointer.PointerInputChange;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.input.pointer.PointerType;
import androidx.compose.p001ui.platform.ViewConfiguration;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: DragGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a5\u0010\u0015\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00180\u0017H\u0082Hø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a!\u0010\u001b\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0014\u001aa\u0010\u001d\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f26\u0010 \u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0!H\u0080@ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001aY\u0010)\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001226\u0010*\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0!H\u0086@ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a!\u0010-\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0004\b.\u0010\u0014\u001aK\u0010/\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u00012\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020&0!H\u0080Hø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aY\u00104\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001226\u0010*\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0!H\u0086@ø\u0001\u0000¢\u0006\u0004\b5\u0010,\u001a!\u00106\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0004\b7\u0010\u0014\u001aa\u00108\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f26\u0010*\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0!H\u0080@ø\u0001\u0000¢\u0006\u0004\b9\u0010(\u001aY\u0010:\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001226\u0010*\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0!H\u0086@ø\u0001\u0000¢\u0006\u0004\b;\u0010,\u001a\u0080\u0001\u0010<\u001a\u00020&*\u00020=2\u0014\b\u0002\u0010>\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020&0\u00172\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020&0@2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020&0@26\u0010B\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020&0!H\u0086@¢\u0006\u0002\u0010D\u001a\u0080\u0001\u0010E\u001a\u00020&*\u00020=2\u0014\b\u0002\u0010>\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020&0\u00172\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020&0@2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020&0@26\u0010B\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020&0!H\u0086@¢\u0006\u0002\u0010D\u001a\u0080\u0001\u0010F\u001a\u00020&*\u00020=2\u0014\b\u0002\u0010>\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020&0\u00172\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020&0@2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020&0@26\u0010G\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020&0!H\u0086@¢\u0006\u0002\u0010D\u001a\u0080\u0001\u0010H\u001a\u00020&*\u00020=2\u0014\b\u0002\u0010>\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020&0\u00172\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020&0@2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020&0@26\u0010I\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020&0!H\u0086@¢\u0006\u0002\u0010D\u001a3\u0010J\u001a\u00020\u0018*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020&0\u0017H\u0086@ø\u0001\u0000¢\u0006\u0004\bK\u0010\u001a\u001a]\u0010J\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020&0\u00172\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00180\u00172\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00180\u0017H\u0080Hø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a3\u0010O\u001a\u00020\u0018*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020&0\u0017H\u0086@ø\u0001\u0000¢\u0006\u0004\bP\u0010\u001a\u001a\u001e\u0010Q\u001a\u00020\u0018*\u00020R2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u001e\u0010U\u001a\u00020\r*\u00020V2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000ø\u0001\u0000¢\u0006\u0004\bW\u0010X\u001a\f\u0010Y\u001a\u00020\u0001*\u00020ZH\u0000\u001a3\u0010[\u001a\u00020\u0018*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020&0\u0017H\u0086@ø\u0001\u0000¢\u0006\u0004\b\\\u0010\u001a\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n\"\u0010\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006]"}, m195d2 = {"BidirectionalPointerDirectionConfig", "Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "getBidirectionalPointerDirectionConfig", "()Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "HorizontalPointerDirectionConfig", "getHorizontalPointerDirectionConfig", "VerticalPointerDirectionConfig", "getVerticalPointerDirectionConfig", "defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitDragOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrUp", "hasDragged", "Lkotlin/Function1;", "", "awaitDragOrUp-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalDragOrCancellation", "awaitHorizontalDragOrCancellation-rnUCldI", "awaitHorizontalPointerSlopOrCancellation", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalTouchSlopOrCancellation", "onTouchSlopReached", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation", "awaitLongPressOrCancellation-rnUCldI", "awaitPointerSlopOrCancellation", "pointerDirectionConfig", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILandroidx/compose/foundation/gestures/PointerDirectionConfig;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitTouchSlopOrCancellation", "awaitTouchSlopOrCancellation-jO51t88", "awaitVerticalDragOrCancellation", "awaitVerticalDragOrCancellation-rnUCldI", "awaitVerticalPointerSlopOrCancellation", "awaitVerticalPointerSlopOrCancellation-gDDlDlE", "awaitVerticalTouchSlopOrCancellation", "awaitVerticalTouchSlopOrCancellation-jO51t88", "detectDragGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "onDrag", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "detectHorizontalDragGestures", "onHorizontalDrag", "detectVerticalDragGestures", "onVerticalDrag", "drag", "drag-jO51t88", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "horizontalDrag", "horizontalDrag-jO51t88", "isPointerUp", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "toPointerDirectionConfig", "Landroidx/compose/foundation/gestures/Orientation;", "verticalDrag", "verticalDrag-jO51t88", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DragGestureDetectorKt {
    private static final float mouseToTouchSlopRatio;
    private static final PointerDirectionConfig HorizontalPointerDirectionConfig = new PointerDirectionConfig() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$HorizontalPointerDirectionConfig$1
        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* JADX INFO: renamed from: calculateDeltaChange-k-4lQ0M */
        public float mo618calculateDeltaChangek4lQ0M(long offset) {
            return Math.abs(Offset.m4049getXimpl(offset));
        }

        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* JADX INFO: renamed from: calculatePostSlopOffset-8S9VItk */
        public long mo619calculatePostSlopOffset8S9VItk(long totalPositionChange, float touchSlop) {
            float finalMainPositionChange = Offset.m4049getXimpl(totalPositionChange) - (Math.signum(Offset.m4049getXimpl(totalPositionChange)) * touchSlop);
            return OffsetKt.Offset(finalMainPositionChange, Offset.m4050getYimpl(totalPositionChange));
        }
    };
    private static final PointerDirectionConfig VerticalPointerDirectionConfig = new PointerDirectionConfig() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$VerticalPointerDirectionConfig$1
        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* JADX INFO: renamed from: calculateDeltaChange-k-4lQ0M */
        public float mo618calculateDeltaChangek4lQ0M(long offset) {
            return Math.abs(Offset.m4050getYimpl(offset));
        }

        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* JADX INFO: renamed from: calculatePostSlopOffset-8S9VItk */
        public long mo619calculatePostSlopOffset8S9VItk(long totalPositionChange, float touchSlop) {
            float finalMainPositionChange = Offset.m4050getYimpl(totalPositionChange) - (Math.signum(Offset.m4050getYimpl(totalPositionChange)) * touchSlop);
            return OffsetKt.Offset(Offset.m4049getXimpl(totalPositionChange), finalMainPositionChange);
        }
    };
    private static final PointerDirectionConfig BidirectionalPointerDirectionConfig = new PointerDirectionConfig() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$BidirectionalPointerDirectionConfig$1
        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* JADX INFO: renamed from: calculateDeltaChange-k-4lQ0M, reason: not valid java name */
        public float mo618calculateDeltaChangek4lQ0M(long offset) {
            return Offset.m4047getDistanceimpl(offset);
        }

        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* JADX INFO: renamed from: calculatePostSlopOffset-8S9VItk, reason: not valid java name */
        public long mo619calculatePostSlopOffset8S9VItk(long totalPositionChange, float touchSlop) {
            long touchSlopOffset = Offset.m4056timestuRUvjQ(Offset.m4044divtuRUvjQ(totalPositionChange, mo618calculateDeltaChangek4lQ0M(totalPositionChange)), touchSlop);
            return Offset.m4053minusMKHz9U(totalPositionChange, touchSlopOffset);
        }
    };
    private static final float mouseSlop = C1979Dp.m6801constructorimpl((float) 0.125d);
    private static final float defaultTouchSlop = C1979Dp.m6801constructorimpl(18);

    /* JADX WARN: Code duplicated, block: B:24:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:27:0x010b A[LOOP:0: B:23:0x00e6->B:27:0x010b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:64:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0170 -> B:18:0x00ae). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x01b7 -> B:54:0x01c0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x01e8 -> B:18:0x00ae). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    public static final java.lang.Object m607awaitTouchSlopOrCancellationjO51t88(androidx.compose.p001ui.input.pointer.AwaitPointerEventScope r24, long r25, kotlin.jvm.functions.Function2<? super androidx.compose.p001ui.input.pointer.PointerInputChange, ? super androidx.compose.p001ui.geometry.Offset, kotlin.Unit> r27, kotlin.coroutines.Continuation<? super androidx.compose.p001ui.input.pointer.PointerInputChange> r28) {
        /*
            Method dump skipped, instruction units count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m607awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:17:0x0050  */
    /* JADX WARN: Code duplicated, block: B:22:0x005d  */
    /* JADX WARN: Code duplicated, block: B:24:0x0064  */
    /* JADX WARN: Code duplicated, block: B:26:0x0069  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0050 -> B:18:0x0053). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: drag-jO51t88, reason: not valid java name */
    public static final java.lang.Object m613dragjO51t88(androidx.compose.p001ui.input.pointer.AwaitPointerEventScope r7, long r8, kotlin.jvm.functions.Function1<? super androidx.compose.p001ui.input.pointer.PointerInputChange, kotlin.Unit> r10, kotlin.coroutines.Continuation<? super java.lang.Boolean> r11) {
        /*
            boolean r0 = r11 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            if (r0 == 0) goto L14
            r0 = r11
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            r0.<init>(r11)
        L19:
            r11 = r0
            java.lang.Object r0 = r11.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r11.label
            r3 = 1
            switch(r2) {
                case 0: goto L3c;
                case 1: goto L2f;
                default: goto L26;
            }
        L26:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L2f:
            java.lang.Object r7 = r11.L$1
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r8 = r11.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.p001ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r0)
            r9 = r0
            goto L53
        L3c:
            kotlin.ResultKt.throwOnFailure(r0)
            r4 = r8
            r8 = r7
            r7 = r10
        L42:
            r11.L$0 = r8
            r11.L$1 = r7
            r11.label = r3
            java.lang.Object r9 = m599awaitDragOrCancellationrnUCldI(r8, r4, r11)
            if (r9 != r1) goto L50
            return r1
        L50:
            r6 = r0
            r0 = r9
            r9 = r6
        L53:
            androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.p001ui.input.pointer.PointerInputChange) r0
            if (r0 != 0) goto L5d
            r10 = 0
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            return r10
        L5d:
            r10 = r0
            boolean r0 = androidx.compose.p001ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r10)
            if (r0 == 0) goto L69
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r0
        L69:
            r7.invoke(r10)
            long r4 = r10.getId()
            r0 = r9
            goto L42
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m613dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x008b  */
    /* JADX WARN: Code duplicated, block: B:26:0x00a9 A[LOOP:0: B:22:0x0089->B:26:0x00a9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:58:0x00b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0070 -> B:21:0x0079). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitDragOrCancellation-rnUCldI, reason: not valid java name */
    public static final java.lang.Object m599awaitDragOrCancellationrnUCldI(androidx.compose.p001ui.input.pointer.AwaitPointerEventScope r20, long r21, kotlin.coroutines.Continuation<? super androidx.compose.p001ui.input.pointer.PointerInputChange> r23) {
        /*
            Method dump skipped, instruction units count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m599awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5 */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5", m210f = "DragGestureDetector.kt", m211i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, m212l = {175, 884, 926, 192}, m213m = "invokeSuspend", m214n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv", "pointerDirectionConfig$iv", "pointer$iv", "touchSlop$iv", "totalPositionChange$iv", "$this$awaitEachGesture", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv", "pointerDirectionConfig$iv", "pointer$iv", "dragEvent$iv", "touchSlop$iv", "totalPositionChange$iv"}, m215s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "F$0", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "F$0", "J$0"})
    static final class C03765 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        float F$0;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03765(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function0, Function0<Unit> function3, Continuation<? super C03765> continuation) {
            super(2, continuation);
            this.$onDragStart = function1;
            this.$onDrag = function2;
            this.$onDragCancel = function0;
            this.$onDragEnd = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03765 c03765 = new C03765(this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
            c03765.L$0 = obj;
            return c03765;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C03765) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0144  */
        /* JADX WARN: Code duplicated, block: B:28:0x0169 A[LOOP:0: B:24:0x0142->B:28:0x0169, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:82:0x0166 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00ee -> B:62:0x0271). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0181 -> B:62:0x0271). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0190 -> B:62:0x0271). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x01ce -> B:62:0x0271). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x01d6 -> B:19:0x0106). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x022b -> B:55:0x0236). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0269 -> B:62:0x0271). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x02dd -> B:19:0x0106). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r32) {
            /*
                Method dump skipped, instruction units count: 768
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.C03765.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Object detectDragGestures(PointerInputScope $this$detectDragGestures, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function2, Function2<? super PointerInputChange, ? super Offset, Unit> function3, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectDragGestures, new C03765(function1, function3, function2, function0, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5", m210f = "DragGestureDetector.kt", m211i = {0, 1, 2}, m212l = {234, 235, 240}, m213m = "invokeSuspend", m214n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "$this$awaitEachGesture"}, m215s = {"L$0", "L$0", "L$0"})
    static final class C03805 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03805(Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function2, Function2<? super PointerInputChange, ? super Offset, Unit> function3, Continuation<? super C03805> continuation) {
            super(2, continuation);
            this.$onDragStart = function1;
            this.$onDragEnd = function0;
            this.$onDragCancel = function2;
            this.$onDrag = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03805 c03805 = new C03805(this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$onDrag, continuation);
            c03805.L$0 = obj;
            return c03805;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C03805) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x006f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:25:0x0070  */
        /* JADX WARN: Code duplicated, block: B:28:0x0075 A[Catch: CancellationException -> 0x00e7, TRY_LEAVE, TryCatch #3 {CancellationException -> 0x00e7, blocks: (B:26:0x0071, B:28:0x0075, B:22:0x005b), top: B:57:0x005b }] */
        /* JADX WARN: Code duplicated, block: B:30:0x009e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x009f  */
        /* JADX WARN: Code duplicated, block: B:34:0x00a9 A[Catch: CancellationException -> 0x00df, TryCatch #0 {CancellationException -> 0x00df, blocks: (B:32:0x00a1, B:34:0x00a9, B:36:0x00ba, B:38:0x00c9, B:39:0x00cc, B:40:0x00d1, B:41:0x00d8), top: B:53:0x00a1 }] */
        /* JADX WARN: Code duplicated, block: B:36:0x00ba A[Catch: CancellationException -> 0x00df, TryCatch #0 {CancellationException -> 0x00df, blocks: (B:32:0x00a1, B:34:0x00a9, B:36:0x00ba, B:38:0x00c9, B:39:0x00cc, B:40:0x00d1, B:41:0x00d8), top: B:53:0x00a1 }] */
        /* JADX WARN: Code duplicated, block: B:38:0x00c9 A[Catch: CancellationException -> 0x00df, TryCatch #0 {CancellationException -> 0x00df, blocks: (B:32:0x00a1, B:34:0x00a9, B:36:0x00ba, B:38:0x00c9, B:39:0x00cc, B:40:0x00d1, B:41:0x00d8), top: B:53:0x00a1 }] */
        /* JADX WARN: Code duplicated, block: B:41:0x00d8 A[Catch: CancellationException -> 0x00df, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x00df, blocks: (B:32:0x00a1, B:34:0x00a9, B:36:0x00ba, B:38:0x00c9, B:39:0x00cc, B:40:0x00d1, B:41:0x00d8), top: B:53:0x00a1 }] */
        /* JADX WARN: Code duplicated, block: B:61:0x00cc A[SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CancellationException e;
            C03805 c03805;
            AwaitPointerEventScope awaitPointerEventScope;
            C03805 c03806;
            Object objM604awaitLongPressOrCancellationrnUCldI;
            PointerInputChange pointerInputChange;
            Object objM613dragjO51t88;
            List<PointerInputChange> changes;
            int i;
            int size;
            PointerInputChange pointerInputChange2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r1 = this.label;
            try {
                switch (r1) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        this.L$0 = awaitPointerEventScope2;
                        this.label = 1;
                        Object objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, null, this, 2, null);
                        if (objAwaitFirstDown$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = objAwaitFirstDown$default;
                        awaitPointerEventScope = awaitPointerEventScope2;
                        c03806 = this;
                        try {
                            c03806.L$0 = awaitPointerEventScope;
                            c03806.label = 2;
                            objM604awaitLongPressOrCancellationrnUCldI = DragGestureDetectorKt.m604awaitLongPressOrCancellationrnUCldI(awaitPointerEventScope, ((PointerInputChange) obj).getId(), c03806);
                            if (objM604awaitLongPressOrCancellationrnUCldI == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj = objM604awaitLongPressOrCancellationrnUCldI;
                            pointerInputChange = (PointerInputChange) obj;
                            if (pointerInputChange != null) {
                                c03806.$onDragStart.invoke(Offset.m4038boximpl(pointerInputChange.getPosition()));
                                long id = pointerInputChange.getId();
                                final Function2<PointerInputChange, Offset, Unit> function2 = c03806.$onDrag;
                                c03806.L$0 = awaitPointerEventScope;
                                c03806.label = 3;
                                objM613dragjO51t88 = DragGestureDetectorKt.m613dragjO51t88(awaitPointerEventScope, id, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGesturesAfterLongPress.5.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange3) {
                                        invoke2(pointerInputChange3);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(PointerInputChange it) {
                                        function2.invoke(it, Offset.m4038boximpl(PointerEventKt.positionChange(it)));
                                        it.consume();
                                    }
                                }, c03806);
                                if (objM613dragjO51t88 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                c03805 = c03806;
                                obj = objM613dragjO51t88;
                                try {
                                    if (((Boolean) obj).booleanValue()) {
                                        changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                                        size = changes.size();
                                        for (i = 0; i < size; i++) {
                                            pointerInputChange2 = changes.get(i);
                                            if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                                pointerInputChange2.consume();
                                            }
                                        }
                                        c03805.$onDragEnd.invoke();
                                    } else {
                                        c03805.$onDragCancel.invoke();
                                    }
                                } catch (CancellationException e2) {
                                    e = e2;
                                    c03805.$onDragCancel.invoke();
                                    throw e;
                                }
                            }
                            return Unit.INSTANCE;
                        } catch (CancellationException e3) {
                            c03805 = c03806;
                            e = e3;
                            c03805.$onDragCancel.invoke();
                            throw e;
                        }
                    case 1:
                        AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        awaitPointerEventScope = awaitPointerEventScope3;
                        c03806 = this;
                        c03806.L$0 = awaitPointerEventScope;
                        c03806.label = 2;
                        objM604awaitLongPressOrCancellationrnUCldI = DragGestureDetectorKt.m604awaitLongPressOrCancellationrnUCldI(awaitPointerEventScope, ((PointerInputChange) obj).getId(), c03806);
                        if (objM604awaitLongPressOrCancellationrnUCldI == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = objM604awaitLongPressOrCancellationrnUCldI;
                        pointerInputChange = (PointerInputChange) obj;
                        if (pointerInputChange != null) {
                            c03806.$onDragStart.invoke(Offset.m4038boximpl(pointerInputChange.getPosition()));
                            long id2 = pointerInputChange.getId();
                            final Function2<? super PointerInputChange, ? super Offset, Unit> function3 = c03806.$onDrag;
                            c03806.L$0 = awaitPointerEventScope;
                            c03806.label = 3;
                            objM613dragjO51t88 = DragGestureDetectorKt.m613dragjO51t88(awaitPointerEventScope, id2, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGesturesAfterLongPress.5.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange3) {
                                    invoke2(pointerInputChange3);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(PointerInputChange it) {
                                    function3.invoke(it, Offset.m4038boximpl(PointerEventKt.positionChange(it)));
                                    it.consume();
                                }
                            }, c03806);
                            if (objM613dragjO51t88 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            c03805 = c03806;
                            obj = objM613dragjO51t88;
                            if (((Boolean) obj).booleanValue()) {
                                changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                                size = changes.size();
                                while (i < size) {
                                    pointerInputChange2 = changes.get(i);
                                    if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                        pointerInputChange2.consume();
                                    }
                                }
                                c03805.$onDragEnd.invoke();
                            } else {
                                c03805.$onDragCancel.invoke();
                            }
                        }
                        return Unit.INSTANCE;
                    case 2:
                        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        awaitPointerEventScope = awaitPointerEventScope4;
                        c03806 = this;
                        obj = obj;
                        pointerInputChange = (PointerInputChange) obj;
                        if (pointerInputChange != null) {
                            c03806.$onDragStart.invoke(Offset.m4038boximpl(pointerInputChange.getPosition()));
                            long id3 = pointerInputChange.getId();
                            final Function2<? super PointerInputChange, ? super Offset, Unit> function4 = c03806.$onDrag;
                            c03806.L$0 = awaitPointerEventScope;
                            c03806.label = 3;
                            objM613dragjO51t88 = DragGestureDetectorKt.m613dragjO51t88(awaitPointerEventScope, id3, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGesturesAfterLongPress.5.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange3) {
                                    invoke2(pointerInputChange3);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(PointerInputChange it) {
                                    function4.invoke(it, Offset.m4038boximpl(PointerEventKt.positionChange(it)));
                                    it.consume();
                                }
                            }, c03806);
                            if (objM613dragjO51t88 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            c03805 = c03806;
                            obj = objM613dragjO51t88;
                            if (((Boolean) obj).booleanValue()) {
                                changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                                size = changes.size();
                                while (i < size) {
                                    pointerInputChange2 = changes.get(i);
                                    if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                        pointerInputChange2.consume();
                                    }
                                }
                                c03805.$onDragEnd.invoke();
                            } else {
                                c03805.$onDragCancel.invoke();
                            }
                        }
                        return Unit.INSTANCE;
                    case 3:
                        c03805 = this;
                        AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) c03805.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            awaitPointerEventScope = awaitPointerEventScope5;
                            obj = obj;
                            c03805 = c03805;
                            if (((Boolean) obj).booleanValue()) {
                                changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                                size = changes.size();
                                while (i < size) {
                                    pointerInputChange2 = changes.get(i);
                                    if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                        pointerInputChange2.consume();
                                    }
                                }
                                c03805.$onDragEnd.invoke();
                            } else {
                                c03805.$onDragCancel.invoke();
                            }
                            return Unit.INSTANCE;
                        } catch (CancellationException e4) {
                            e = e4;
                            c03805.$onDragCancel.invoke();
                            throw e;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (CancellationException e5) {
                e = e5;
                c03805 = r1;
            }
        }
    }

    public static final Object detectDragGesturesAfterLongPress(PointerInputScope $this$detectDragGesturesAfterLongPress, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function2, Function2<? super PointerInputChange, ? super Offset, Unit> function3, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectDragGesturesAfterLongPress, new C03805(function1, function0, function2, function3, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:27:0x010b A[LOOP:0: B:23:0x00e6->B:27:0x010b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:64:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0170 -> B:18:0x00ae). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x01b7 -> B:54:0x01c0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x01f1 -> B:18:0x00ae). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitVerticalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    public static final java.lang.Object m610awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.p001ui.input.pointer.AwaitPointerEventScope r24, long r25, kotlin.jvm.functions.Function2<? super androidx.compose.p001ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r27, kotlin.coroutines.Continuation<? super androidx.compose.p001ui.input.pointer.PointerInputChange> r28) {
        /*
            Method dump skipped, instruction units count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m610awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:27:0x0109 A[LOOP:0: B:23:0x00e4->B:27:0x0109, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:64:0x011e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x016e -> B:18:0x00ac). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x01b5 -> B:54:0x01c2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x01f3 -> B:18:0x00ac). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    public static final java.lang.Object m609awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.p001ui.input.pointer.AwaitPointerEventScope r23, long r24, int r26, kotlin.jvm.functions.Function2<? super androidx.compose.p001ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r27, kotlin.coroutines.Continuation<? super androidx.compose.p001ui.input.pointer.PointerInputChange> r28) {
        /*
            Method dump skipped, instruction units count: 530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m609awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00af  */
    /* JADX WARN: Code duplicated, block: B:27:0x00d0 A[LOOP:0: B:23:0x00ad->B:27:0x00d0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x008e -> B:22:0x009a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: verticalDrag-jO51t88, reason: not valid java name */
    public static final java.lang.Object m617verticalDragjO51t88(androidx.compose.p001ui.input.pointer.AwaitPointerEventScope r22, long r23, kotlin.jvm.functions.Function1<? super androidx.compose.p001ui.input.pointer.PointerInputChange, kotlin.Unit> r25, kotlin.coroutines.Continuation<? super java.lang.Boolean> r26) {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m617verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x008b  */
    /* JADX WARN: Code duplicated, block: B:26:0x00ab A[LOOP:0: B:22:0x0089->B:26:0x00ab, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:62:0x00be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0070 -> B:21:0x0079). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitVerticalDragOrCancellation-rnUCldI, reason: not valid java name */
    public static final java.lang.Object m608awaitVerticalDragOrCancellationrnUCldI(androidx.compose.p001ui.input.pointer.AwaitPointerEventScope r20, long r21, kotlin.coroutines.Continuation<? super androidx.compose.p001ui.input.pointer.PointerInputChange> r23) {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m608awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5 */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5", m210f = "DragGestureDetector.kt", m211i = {0, 1, 1}, m212l = {390, 392, 400}, m213m = "invokeSuspend", m214n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "overSlop"}, m215s = {"L$0", "L$0", "L$1"})
    static final class C03885 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        final /* synthetic */ Function2<PointerInputChange, Float, Unit> $onVerticalDrag;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03885(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function0<Unit> function0, Function0<Unit> function3, Continuation<? super C03885> continuation) {
            super(2, continuation);
            this.$onDragStart = function1;
            this.$onVerticalDrag = function2;
            this.$onDragEnd = function0;
            this.$onDragCancel = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03885 c03885 = new C03885(this.$onDragStart, this.$onVerticalDrag, this.$onDragEnd, this.$onDragCancel, continuation);
            c03885.L$0 = obj;
            return c03885;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C03885) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x007e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:16:0x007f  */
        /* JADX WARN: Code duplicated, block: B:19:0x0084  */
        /* JADX WARN: Code duplicated, block: B:21:0x00bb A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:22:0x00bc  */
        /* JADX WARN: Code duplicated, block: B:25:0x00c5  */
        /* JADX WARN: Code duplicated, block: B:26:0x00cb  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            AwaitPointerEventScope $this$awaitEachGesture;
            C03885 c03885;
            final Ref.FloatRef overSlop;
            AwaitPointerEventScope $this$awaitEachGesture2;
            PointerInputChange drag;
            C03885 c03886;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    AwaitPointerEventScope $this$awaitEachGesture3 = (AwaitPointerEventScope) this.L$0;
                    this.L$0 = $this$awaitEachGesture3;
                    this.label = 1;
                    Object objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default($this$awaitEachGesture3, false, null, this, 2, null);
                    if (objAwaitFirstDown$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$awaitEachGesture = $this$awaitEachGesture3;
                    c03885 = this;
                    $result = objAwaitFirstDown$default;
                    PointerInputChange down = (PointerInputChange) $result;
                    overSlop = new Ref.FloatRef();
                    c03885.L$0 = $this$awaitEachGesture;
                    c03885.L$1 = overSlop;
                    c03885.label = 2;
                    $result = DragGestureDetectorKt.m609awaitVerticalPointerSlopOrCancellationgDDlDlE($this$awaitEachGesture, down.getId(), down.getType(), new Function2<PointerInputChange, Float, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$drag$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Float f) {
                            invoke(pointerInputChange, f.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PointerInputChange change, float over) {
                            change.consume();
                            overSlop.element = over;
                        }
                    }, c03885);
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$awaitEachGesture2 = $this$awaitEachGesture;
                    drag = (PointerInputChange) $result;
                    if (drag != null) {
                        c03885.$onDragStart.invoke(Offset.m4038boximpl(drag.getPosition()));
                        c03885.$onVerticalDrag.invoke(drag, Boxing.boxFloat(overSlop.element));
                        long id = drag.getId();
                        final Function2<PointerInputChange, Float, Unit> function2 = c03885.$onVerticalDrag;
                        c03885.L$0 = null;
                        c03885.L$1 = null;
                        c03885.label = 3;
                        $result = DragGestureDetectorKt.m617verticalDragjO51t88($this$awaitEachGesture2, id, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectVerticalDragGestures.5.1
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
                            public final void invoke2(PointerInputChange it) {
                                function2.invoke(it, Float.valueOf(Offset.m4050getYimpl(PointerEventKt.positionChange(it))));
                                it.consume();
                            }
                        }, c03885);
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c03886 = c03885;
                        if (((Boolean) $result).booleanValue()) {
                            c03886.$onDragEnd.invoke();
                        } else {
                            c03886.$onDragCancel.invoke();
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    AwaitPointerEventScope $this$awaitEachGesture4 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $this$awaitEachGesture = $this$awaitEachGesture4;
                    c03885 = this;
                    PointerInputChange down2 = (PointerInputChange) $result;
                    overSlop = new Ref.FloatRef();
                    c03885.L$0 = $this$awaitEachGesture;
                    c03885.L$1 = overSlop;
                    c03885.label = 2;
                    $result = DragGestureDetectorKt.m609awaitVerticalPointerSlopOrCancellationgDDlDlE($this$awaitEachGesture, down2.getId(), down2.getType(), new Function2<PointerInputChange, Float, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$drag$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Float f) {
                            invoke(pointerInputChange, f.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PointerInputChange change, float over) {
                            change.consume();
                            overSlop.element = over;
                        }
                    }, c03885);
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$awaitEachGesture2 = $this$awaitEachGesture;
                    drag = (PointerInputChange) $result;
                    if (drag != null) {
                        c03885.$onDragStart.invoke(Offset.m4038boximpl(drag.getPosition()));
                        c03885.$onVerticalDrag.invoke(drag, Boxing.boxFloat(overSlop.element));
                        long id2 = drag.getId();
                        final Function2<? super PointerInputChange, ? super Float, Unit> function3 = c03885.$onVerticalDrag;
                        c03885.L$0 = null;
                        c03885.L$1 = null;
                        c03885.label = 3;
                        $result = DragGestureDetectorKt.m617verticalDragjO51t88($this$awaitEachGesture2, id2, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectVerticalDragGestures.5.1
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
                            public final void invoke2(PointerInputChange it) {
                                function3.invoke(it, Float.valueOf(Offset.m4050getYimpl(PointerEventKt.positionChange(it))));
                                it.consume();
                            }
                        }, c03885);
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c03886 = c03885;
                        if (((Boolean) $result).booleanValue()) {
                            c03886.$onDragEnd.invoke();
                        } else {
                            c03886.$onDragCancel.invoke();
                        }
                    }
                    return Unit.INSTANCE;
                case 2:
                    Ref.FloatRef overSlop2 = (Ref.FloatRef) this.L$1;
                    $this$awaitEachGesture2 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    overSlop = overSlop2;
                    c03885 = this;
                    drag = (PointerInputChange) $result;
                    if (drag != null) {
                        c03885.$onDragStart.invoke(Offset.m4038boximpl(drag.getPosition()));
                        c03885.$onVerticalDrag.invoke(drag, Boxing.boxFloat(overSlop.element));
                        long id3 = drag.getId();
                        final Function2<? super PointerInputChange, ? super Float, Unit> function4 = c03885.$onVerticalDrag;
                        c03885.L$0 = null;
                        c03885.L$1 = null;
                        c03885.label = 3;
                        $result = DragGestureDetectorKt.m617verticalDragjO51t88($this$awaitEachGesture2, id3, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectVerticalDragGestures.5.1
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
                            public final void invoke2(PointerInputChange it) {
                                function4.invoke(it, Float.valueOf(Offset.m4050getYimpl(PointerEventKt.positionChange(it))));
                                it.consume();
                            }
                        }, c03885);
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c03886 = c03885;
                        if (((Boolean) $result).booleanValue()) {
                            c03886.$onDragEnd.invoke();
                        } else {
                            c03886.$onDragCancel.invoke();
                        }
                    }
                    return Unit.INSTANCE;
                case 3:
                    c03886 = this;
                    ResultKt.throwOnFailure($result);
                    if (((Boolean) $result).booleanValue()) {
                        c03886.$onDragEnd.invoke();
                    } else {
                        c03886.$onDragCancel.invoke();
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static final Object detectVerticalDragGestures(PointerInputScope $this$detectVerticalDragGestures, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function2, Function2<? super PointerInputChange, ? super Float, Unit> function3, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectVerticalDragGestures, new C03885(function1, function3, function0, function2, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:27:0x010b A[LOOP:0: B:23:0x00e6->B:27:0x010b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:64:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0170 -> B:18:0x00ae). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x01b7 -> B:54:0x01c0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x01f1 -> B:18:0x00ae). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    public static final java.lang.Object m603awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.p001ui.input.pointer.AwaitPointerEventScope r24, long r25, kotlin.jvm.functions.Function2<? super androidx.compose.p001ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r27, kotlin.coroutines.Continuation<? super androidx.compose.p001ui.input.pointer.PointerInputChange> r28) {
        /*
            Method dump skipped, instruction units count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m603awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:27:0x0109 A[LOOP:0: B:23:0x00e4->B:27:0x0109, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:64:0x011e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x016e -> B:18:0x00ac). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x01b5 -> B:54:0x01c2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x01f3 -> B:18:0x00ac). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    public static final java.lang.Object m602awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.p001ui.input.pointer.AwaitPointerEventScope r23, long r24, int r26, kotlin.jvm.functions.Function2<? super androidx.compose.p001ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r27, kotlin.coroutines.Continuation<? super androidx.compose.p001ui.input.pointer.PointerInputChange> r28) {
        /*
            Method dump skipped, instruction units count: 530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m602awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00af  */
    /* JADX WARN: Code duplicated, block: B:27:0x00d0 A[LOOP:0: B:23:0x00ad->B:27:0x00d0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x008e -> B:22:0x009a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: horizontalDrag-jO51t88, reason: not valid java name */
    public static final java.lang.Object m614horizontalDragjO51t88(androidx.compose.p001ui.input.pointer.AwaitPointerEventScope r22, long r23, kotlin.jvm.functions.Function1<? super androidx.compose.p001ui.input.pointer.PointerInputChange, kotlin.Unit> r25, kotlin.coroutines.Continuation<? super java.lang.Boolean> r26) {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m614horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x008b  */
    /* JADX WARN: Code duplicated, block: B:26:0x00ab A[LOOP:0: B:22:0x0089->B:26:0x00ab, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:62:0x00be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0070 -> B:21:0x0079). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitHorizontalDragOrCancellation-rnUCldI, reason: not valid java name */
    public static final java.lang.Object m601awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.p001ui.input.pointer.AwaitPointerEventScope r20, long r21, kotlin.coroutines.Continuation<? super androidx.compose.p001ui.input.pointer.PointerInputChange> r23) {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m601awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5 */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5", m210f = "DragGestureDetector.kt", m211i = {0, 1, 1}, m212l = {538, 540, 551}, m213m = "invokeSuspend", m214n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "overSlop"}, m215s = {"L$0", "L$0", "L$1"})
    static final class C03845 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        final /* synthetic */ Function2<PointerInputChange, Float, Unit> $onHorizontalDrag;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03845(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function0<Unit> function0, Function0<Unit> function3, Continuation<? super C03845> continuation) {
            super(2, continuation);
            this.$onDragStart = function1;
            this.$onHorizontalDrag = function2;
            this.$onDragEnd = function0;
            this.$onDragCancel = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03845 c03845 = new C03845(this.$onDragStart, this.$onHorizontalDrag, this.$onDragEnd, this.$onDragCancel, continuation);
            c03845.L$0 = obj;
            return c03845;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C03845) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x007f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:16:0x0080  */
        /* JADX WARN: Code duplicated, block: B:19:0x0085  */
        /* JADX WARN: Code duplicated, block: B:21:0x00bc A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:22:0x00bd  */
        /* JADX WARN: Code duplicated, block: B:25:0x00c6  */
        /* JADX WARN: Code duplicated, block: B:26:0x00cc  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            AwaitPointerEventScope $this$awaitEachGesture;
            C03845 c03845;
            final Ref.FloatRef overSlop;
            AwaitPointerEventScope $this$awaitEachGesture2;
            PointerInputChange drag;
            C03845 c03846;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    AwaitPointerEventScope $this$awaitEachGesture3 = (AwaitPointerEventScope) this.L$0;
                    this.L$0 = $this$awaitEachGesture3;
                    this.label = 1;
                    Object objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default($this$awaitEachGesture3, false, null, this, 2, null);
                    if (objAwaitFirstDown$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$awaitEachGesture = $this$awaitEachGesture3;
                    c03845 = this;
                    $result = objAwaitFirstDown$default;
                    PointerInputChange down = (PointerInputChange) $result;
                    overSlop = new Ref.FloatRef();
                    c03845.L$0 = $this$awaitEachGesture;
                    c03845.L$1 = overSlop;
                    c03845.label = 2;
                    $result = DragGestureDetectorKt.m602awaitHorizontalPointerSlopOrCancellationgDDlDlE($this$awaitEachGesture, down.getId(), down.getType(), new Function2<PointerInputChange, Float, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$drag$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Float f) {
                            invoke(pointerInputChange, f.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PointerInputChange change, float over) {
                            change.consume();
                            overSlop.element = over;
                        }
                    }, c03845);
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$awaitEachGesture2 = $this$awaitEachGesture;
                    drag = (PointerInputChange) $result;
                    if (drag != null) {
                        c03845.$onDragStart.invoke(Offset.m4038boximpl(drag.getPosition()));
                        c03845.$onHorizontalDrag.invoke(drag, Boxing.boxFloat(overSlop.element));
                        long id = drag.getId();
                        final Function2<PointerInputChange, Float, Unit> function2 = c03845.$onHorizontalDrag;
                        c03845.L$0 = null;
                        c03845.L$1 = null;
                        c03845.label = 3;
                        $result = DragGestureDetectorKt.m614horizontalDragjO51t88($this$awaitEachGesture2, id, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectHorizontalDragGestures.5.1
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
                            public final void invoke2(PointerInputChange it) {
                                function2.invoke(it, Float.valueOf(Offset.m4049getXimpl(PointerEventKt.positionChange(it))));
                                it.consume();
                            }
                        }, c03845);
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c03846 = c03845;
                        if (((Boolean) $result).booleanValue()) {
                            c03846.$onDragEnd.invoke();
                        } else {
                            c03846.$onDragCancel.invoke();
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    AwaitPointerEventScope $this$awaitEachGesture4 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $this$awaitEachGesture = $this$awaitEachGesture4;
                    c03845 = this;
                    PointerInputChange down2 = (PointerInputChange) $result;
                    overSlop = new Ref.FloatRef();
                    c03845.L$0 = $this$awaitEachGesture;
                    c03845.L$1 = overSlop;
                    c03845.label = 2;
                    $result = DragGestureDetectorKt.m602awaitHorizontalPointerSlopOrCancellationgDDlDlE($this$awaitEachGesture, down2.getId(), down2.getType(), new Function2<PointerInputChange, Float, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$drag$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Float f) {
                            invoke(pointerInputChange, f.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PointerInputChange change, float over) {
                            change.consume();
                            overSlop.element = over;
                        }
                    }, c03845);
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$awaitEachGesture2 = $this$awaitEachGesture;
                    drag = (PointerInputChange) $result;
                    if (drag != null) {
                        c03845.$onDragStart.invoke(Offset.m4038boximpl(drag.getPosition()));
                        c03845.$onHorizontalDrag.invoke(drag, Boxing.boxFloat(overSlop.element));
                        long id2 = drag.getId();
                        final Function2<? super PointerInputChange, ? super Float, Unit> function3 = c03845.$onHorizontalDrag;
                        c03845.L$0 = null;
                        c03845.L$1 = null;
                        c03845.label = 3;
                        $result = DragGestureDetectorKt.m614horizontalDragjO51t88($this$awaitEachGesture2, id2, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectHorizontalDragGestures.5.1
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
                            public final void invoke2(PointerInputChange it) {
                                function3.invoke(it, Float.valueOf(Offset.m4049getXimpl(PointerEventKt.positionChange(it))));
                                it.consume();
                            }
                        }, c03845);
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c03846 = c03845;
                        if (((Boolean) $result).booleanValue()) {
                            c03846.$onDragEnd.invoke();
                        } else {
                            c03846.$onDragCancel.invoke();
                        }
                    }
                    return Unit.INSTANCE;
                case 2:
                    Ref.FloatRef overSlop2 = (Ref.FloatRef) this.L$1;
                    $this$awaitEachGesture2 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    overSlop = overSlop2;
                    c03845 = this;
                    drag = (PointerInputChange) $result;
                    if (drag != null) {
                        c03845.$onDragStart.invoke(Offset.m4038boximpl(drag.getPosition()));
                        c03845.$onHorizontalDrag.invoke(drag, Boxing.boxFloat(overSlop.element));
                        long id3 = drag.getId();
                        final Function2<? super PointerInputChange, ? super Float, Unit> function4 = c03845.$onHorizontalDrag;
                        c03845.L$0 = null;
                        c03845.L$1 = null;
                        c03845.label = 3;
                        $result = DragGestureDetectorKt.m614horizontalDragjO51t88($this$awaitEachGesture2, id3, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectHorizontalDragGestures.5.1
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
                            public final void invoke2(PointerInputChange it) {
                                function4.invoke(it, Float.valueOf(Offset.m4049getXimpl(PointerEventKt.positionChange(it))));
                                it.consume();
                            }
                        }, c03845);
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c03846 = c03845;
                        if (((Boolean) $result).booleanValue()) {
                            c03846.$onDragEnd.invoke();
                        } else {
                            c03846.$onDragCancel.invoke();
                        }
                    }
                    return Unit.INSTANCE;
                case 3:
                    c03846 = this;
                    ResultKt.throwOnFailure($result);
                    if (((Boolean) $result).booleanValue()) {
                        c03846.$onDragEnd.invoke();
                    } else {
                        c03846.$onDragCancel.invoke();
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope $this$detectHorizontalDragGestures, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function2, Function2<? super PointerInputChange, ? super Float, Unit> function3, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectHorizontalDragGestures, new C03845(function1, function3, function0, function2, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:27:0x00e5 A[LOOP:0: B:23:0x00c0->B:27:0x00e5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:60:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x009d -> B:22:0x00ab). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: drag-VnAYq1g, reason: not valid java name */
    public static final java.lang.Object m611dragVnAYq1g(androidx.compose.p001ui.input.pointer.AwaitPointerEventScope r22, long r23, kotlin.jvm.functions.Function1<? super androidx.compose.p001ui.input.pointer.PointerInputChange, kotlin.Unit> r25, kotlin.jvm.functions.Function1<? super androidx.compose.p001ui.input.pointer.PointerInputChange, java.lang.Boolean> r26, kotlin.jvm.functions.Function1<? super androidx.compose.p001ui.input.pointer.PointerInputChange, java.lang.Boolean> r27, kotlin.coroutines.Continuation<? super androidx.compose.p001ui.input.pointer.PointerInputChange> r28) {
        /*
            Method dump skipped, instruction units count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m611dragVnAYq1g(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: drag-VnAYq1g$$forInline, reason: not valid java name */
    private static final Object m612dragVnAYq1g$$forInline(AwaitPointerEventScope $this$drag_u2dVnAYq1g, long pointerId, Function1<? super PointerInputChange, Unit> function1, Function1<? super PointerInputChange, Boolean> function2, Function1<? super PointerInputChange, Boolean> function3, Continuation<? super PointerInputChange> continuation) {
        int i;
        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv;
        Object it$iv$iv;
        PointerInputChange dragEvent$iv;
        Object it$iv$iv2;
        int i2 = 0;
        PointerEventPass pointerEventPass = null;
        if (m615isPointerUpDmW0f2w($this$drag_u2dVnAYq1g.getCurrentEvent(), pointerId)) {
            return null;
        }
        long pointer = pointerId;
        while (true) {
            AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv2 = $this$drag_u2dVnAYq1g;
            Ref.LongRef pointer$iv = new Ref.LongRef();
            pointer$iv.element = pointer;
            while (true) {
                InlineMarker.mark(0);
                Object objAwaitPointerEvent$default = AwaitPointerEventScope.CC.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88$iv2, pointerEventPass, continuation, 1, pointerEventPass);
                InlineMarker.mark(1);
                PointerEvent event$iv = (PointerEvent) objAwaitPointerEvent$default;
                List<PointerInputChange> changes = event$iv.getChanges();
                int index$iv$iv$iv = 0;
                int size = changes.size();
                while (true) {
                    if (index$iv$iv$iv >= size) {
                        i = i2;
                        $this$awaitDragOrUp_u2djO51t88$iv = $this$awaitDragOrUp_u2djO51t88$iv2;
                        it$iv$iv = null;
                        break;
                    }
                    Object item$iv$iv$iv = changes.get(index$iv$iv$iv);
                    it$iv$iv = item$iv$iv$iv;
                    PointerInputChange it$iv = (PointerInputChange) it$iv$iv;
                    i = i2;
                    $this$awaitDragOrUp_u2djO51t88$iv = $this$awaitDragOrUp_u2djO51t88$iv2;
                    if (Boolean.valueOf(PointerId.m5492equalsimpl0(it$iv.getId(), pointer$iv.element)).booleanValue()) {
                        break;
                    }
                    index$iv$iv$iv++;
                    i2 = i;
                    $this$awaitDragOrUp_u2djO51t88$iv2 = $this$awaitDragOrUp_u2djO51t88$iv;
                }
                PointerInputChange pointerInputChange = (PointerInputChange) it$iv$iv;
                if (pointerInputChange == null) {
                    dragEvent$iv = null;
                    break;
                }
                dragEvent$iv = pointerInputChange;
                if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                    List<PointerInputChange> changes2 = event$iv.getChanges();
                    int index$iv$iv$iv2 = 0;
                    int size2 = changes2.size();
                    while (true) {
                        if (index$iv$iv$iv2 >= size2) {
                            it$iv$iv2 = null;
                            break;
                        }
                        Object item$iv$iv$iv2 = changes2.get(index$iv$iv$iv2);
                        it$iv$iv2 = item$iv$iv$iv2;
                        PointerInputChange it$iv2 = (PointerInputChange) it$iv$iv2;
                        if (Boolean.valueOf(it$iv2.getPressed()).booleanValue()) {
                            break;
                        }
                        index$iv$iv$iv2++;
                    }
                    PointerInputChange otherDown$iv = (PointerInputChange) it$iv$iv2;
                    if (otherDown$iv == null) {
                        break;
                    }
                    pointer$iv.element = otherDown$iv.getId();
                    i2 = i;
                    $this$awaitDragOrUp_u2djO51t88$iv2 = $this$awaitDragOrUp_u2djO51t88$iv;
                    pointerEventPass = null;
                } else {
                    if (function2.invoke(dragEvent$iv).booleanValue()) {
                        break;
                    }
                    i2 = i;
                    $this$awaitDragOrUp_u2djO51t88$iv2 = $this$awaitDragOrUp_u2djO51t88$iv;
                    pointerEventPass = null;
                }
            }
            if (dragEvent$iv == null || function3.invoke(dragEvent$iv).booleanValue()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                return dragEvent$iv;
            }
            function1.invoke(dragEvent$iv);
            pointer = dragEvent$iv.getId();
            i2 = i;
            pointerEventPass = null;
        }
    }

    /* JADX INFO: renamed from: awaitDragOrUp-jO51t88, reason: not valid java name */
    private static final Object m600awaitDragOrUpjO51t88(AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88, long pointerId, Function1<? super PointerInputChange, Boolean> function1, Continuation<? super PointerInputChange> continuation) {
        PointerEvent event;
        Object it$iv;
        Object obj;
        Ref.LongRef pointer = new Ref.LongRef();
        pointer.element = pointerId;
        while (true) {
            InlineMarker.mark(0);
            Object objAwaitPointerEvent$default = AwaitPointerEventScope.CC.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88, null, continuation, 1, null);
            InlineMarker.mark(1);
            PointerEvent event2 = (PointerEvent) objAwaitPointerEvent$default;
            List<PointerInputChange> changes = event2.getChanges();
            int index$iv$iv = 0;
            int size = changes.size();
            while (true) {
                if (index$iv$iv >= size) {
                    event = event2;
                    it$iv = null;
                    break;
                }
                it$iv = changes.get(index$iv$iv);
                PointerInputChange it = (PointerInputChange) it$iv;
                event = event2;
                if (Boolean.valueOf(PointerId.m5492equalsimpl0(it.getId(), pointer.element)).booleanValue()) {
                    break;
                }
                index$iv$iv++;
                event2 = event;
            }
            PointerInputChange dragEvent = (PointerInputChange) it$iv;
            if (dragEvent == null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent)) {
                List<PointerInputChange> changes2 = event.getChanges();
                int index$iv$iv2 = 0;
                int size2 = changes2.size();
                while (true) {
                    if (index$iv$iv2 >= size2) {
                        obj = null;
                        break;
                    }
                    Object item$iv$iv = changes2.get(index$iv$iv2);
                    PointerInputChange it2 = (PointerInputChange) item$iv$iv;
                    if (Boolean.valueOf(it2.getPressed()).booleanValue()) {
                        obj = item$iv$iv;
                        break;
                    }
                    index$iv$iv2++;
                }
                PointerInputChange otherDown = (PointerInputChange) obj;
                if (otherDown == null) {
                    return dragEvent;
                }
                pointer.element = otherDown.getId();
            } else if (function1.invoke(dragEvent).booleanValue()) {
                return dragEvent;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:27:0x00ff A[LOOP:0: B:23:0x00da->B:27:0x00ff, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x0114 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x015b -> B:18:0x00a4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x01a0 -> B:56:0x01ab). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x01d2 -> B:18:0x00a4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-pn7EDYM, reason: not valid java name */
    public static final java.lang.Object m605awaitPointerSlopOrCancellationpn7EDYM(androidx.compose.p001ui.input.pointer.AwaitPointerEventScope r23, long r24, int r26, androidx.compose.foundation.gestures.PointerDirectionConfig r27, kotlin.jvm.functions.Function2<? super androidx.compose.p001ui.input.pointer.PointerInputChange, ? super androidx.compose.p001ui.geometry.Offset, kotlin.Unit> r28, kotlin.coroutines.Continuation<? super androidx.compose.p001ui.input.pointer.PointerInputChange> r29) {
        /*
            Method dump skipped, instruction units count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m605awaitPointerSlopOrCancellationpn7EDYM(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, androidx.compose.foundation.gestures.PointerDirectionConfig, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-pn7EDYM$$forInline, reason: not valid java name */
    private static final Object m606awaitPointerSlopOrCancellationpn7EDYM$$forInline(AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dpn7EDYM, long pointerId, int pointerType, PointerDirectionConfig pointerDirectionConfig, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        Object it$iv;
        Object it$iv2;
        PointerEventPass pointerEventPass = null;
        if (m615isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dpn7EDYM.getCurrentEvent(), pointerId)) {
            return null;
        }
        float touchSlop = m616pointerSlopE8SPZFQ($this$awaitPointerSlopOrCancellation_u2dpn7EDYM.getViewConfiguration(), pointerType);
        Ref.LongRef pointer = new Ref.LongRef();
        pointer.element = pointerId;
        long totalPositionChange = Offset.INSTANCE.m4065getZeroF1C5BW0();
        while (true) {
            InlineMarker.mark(0);
            Object objAwaitPointerEvent$default = AwaitPointerEventScope.CC.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dpn7EDYM, pointerEventPass, continuation, 1, pointerEventPass);
            InlineMarker.mark(1);
            PointerEvent event = (PointerEvent) objAwaitPointerEvent$default;
            List<PointerInputChange> changes = event.getChanges();
            int size = changes.size();
            int index$iv$iv = 0;
            while (true) {
                if (index$iv$iv >= size) {
                    it$iv = null;
                    break;
                }
                List<PointerInputChange> list = changes;
                Object item$iv$iv = list.get(index$iv$iv);
                it$iv = item$iv$iv;
                PointerInputChange it = (PointerInputChange) it$iv;
                if (Boolean.valueOf(PointerId.m5492equalsimpl0(it.getId(), pointer.element)).booleanValue()) {
                    break;
                }
                index$iv$iv++;
                changes = list;
            }
            PointerInputChange dragEvent = (PointerInputChange) it$iv;
            if (dragEvent == null || dragEvent.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent)) {
                List<PointerInputChange> changes2 = event.getChanges();
                int index$iv$iv2 = 0;
                int size2 = changes2.size();
                while (true) {
                    if (index$iv$iv2 >= size2) {
                        it$iv2 = null;
                        break;
                    }
                    Object item$iv$iv2 = changes2.get(index$iv$iv2);
                    it$iv2 = item$iv$iv2;
                    PointerInputChange it2 = (PointerInputChange) it$iv2;
                    if (Boolean.valueOf(it2.getPressed()).booleanValue()) {
                        break;
                    }
                    index$iv$iv2++;
                }
                PointerInputChange otherDown = (PointerInputChange) it$iv2;
                if (otherDown == null) {
                    return null;
                }
                pointer.element = otherDown.getId();
            } else {
                long currentPosition = dragEvent.getPosition();
                long previousPosition = dragEvent.getPreviousPosition();
                long positionChange = Offset.m4053minusMKHz9U(currentPosition, previousPosition);
                totalPositionChange = Offset.m4054plusMKHz9U(totalPositionChange, positionChange);
                float inDirection = pointerDirectionConfig.mo618calculateDeltaChangek4lQ0M(totalPositionChange);
                if (inDirection < touchSlop) {
                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                    InlineMarker.mark(0);
                    $this$awaitPointerSlopOrCancellation_u2dpn7EDYM.awaitPointerEvent(pointerEventPass2, continuation);
                    InlineMarker.mark(1);
                    if (dragEvent.isConsumed()) {
                        return null;
                    }
                } else {
                    long postSlopOffset = pointerDirectionConfig.mo619calculatePostSlopOffset8S9VItk(totalPositionChange, touchSlop);
                    function2.invoke(dragEvent, Offset.m4038boximpl(postSlopOffset));
                    if (dragEvent.isConsumed()) {
                        return dragEvent;
                    }
                    totalPositionChange = Offset.INSTANCE.m4065getZeroF1C5BW0();
                }
            }
            pointerEventPass = null;
        }
    }

    static {
        float arg0$iv = mouseSlop;
        float other$iv = defaultTouchSlop;
        mouseToTouchSlopRatio = arg0$iv / other$iv;
    }

    public static final PointerDirectionConfig getHorizontalPointerDirectionConfig() {
        return HorizontalPointerDirectionConfig;
    }

    public static final PointerDirectionConfig getVerticalPointerDirectionConfig() {
        return VerticalPointerDirectionConfig;
    }

    public static final PointerDirectionConfig getBidirectionalPointerDirectionConfig() {
        return BidirectionalPointerDirectionConfig;
    }

    public static final PointerDirectionConfig toPointerDirectionConfig(Orientation $this$toPointerDirectionConfig) {
        return $this$toPointerDirectionConfig == Orientation.Vertical ? VerticalPointerDirectionConfig : HorizontalPointerDirectionConfig;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [androidx.compose.ui.input.pointer.PointerInputChange] */
    /* JADX INFO: renamed from: awaitLongPressOrCancellation-rnUCldI, reason: not valid java name */
    public static final Object m604awaitLongPressOrCancellationrnUCldI(AwaitPointerEventScope $this$awaitLongPressOrCancellation_u2drnUCldI, long pointerId, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$1 dragGestureDetectorKt$awaitLongPressOrCancellation$1;
        Object it$iv;
        ?? r5;
        Ref.ObjectRef longPress;
        if (continuation instanceof DragGestureDetectorKt$awaitLongPressOrCancellation$1) {
            dragGestureDetectorKt$awaitLongPressOrCancellation$1 = (DragGestureDetectorKt$awaitLongPressOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitLongPressOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitLongPressOrCancellation$1 = new DragGestureDetectorKt$awaitLongPressOrCancellation$1(continuation);
            }
        } else {
            dragGestureDetectorKt$awaitLongPressOrCancellation$1 = new DragGestureDetectorKt$awaitLongPressOrCancellation$1(continuation);
        }
        Object $result = dragGestureDetectorKt$awaitLongPressOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dragGestureDetectorKt$awaitLongPressOrCancellation$1.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (m615isPointerUpDmW0f2w($this$awaitLongPressOrCancellation_u2drnUCldI.getCurrentEvent(), pointerId)) {
                    return null;
                }
                List<PointerInputChange> changes = $this$awaitLongPressOrCancellation_u2drnUCldI.getCurrentEvent().getChanges();
                int $i$f$fastFirstOrNull = 0;
                int index$iv$iv = 0;
                int size = changes.size();
                while (true) {
                    if (index$iv$iv < size) {
                        Object item$iv$iv = changes.get(index$iv$iv);
                        it$iv = item$iv$iv;
                        PointerInputChange it = (PointerInputChange) it$iv;
                        List<PointerInputChange> list = changes;
                        int $i$f$fastFirstOrNull2 = $i$f$fastFirstOrNull;
                        if (!PointerId.m5492equalsimpl0(it.getId(), pointerId)) {
                            index$iv$iv++;
                            $i$f$fastFirstOrNull = $i$f$fastFirstOrNull2;
                            changes = list;
                        }
                    } else {
                        it$iv = null;
                    }
                }
                PointerInputChange pointerInputChange = (PointerInputChange) it$iv;
                if (pointerInputChange == null) {
                    return null;
                }
                r5 = pointerInputChange;
                Ref.ObjectRef longPress2 = new Ref.ObjectRef();
                Ref.ObjectRef currentDown = new Ref.ObjectRef();
                currentDown.element = r5;
                long longPressTimeout = $this$awaitLongPressOrCancellation_u2drnUCldI.getViewConfiguration().getLongPressTimeoutMillis();
                try {
                    DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(currentDown, longPress2, null);
                    dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0 = r5;
                    dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1 = longPress2;
                    dragGestureDetectorKt$awaitLongPressOrCancellation$1.label = 1;
                    if ($this$awaitLongPressOrCancellation_u2drnUCldI.withTimeout(longPressTimeout, dragGestureDetectorKt$awaitLongPressOrCancellation$2, dragGestureDetectorKt$awaitLongPressOrCancellation$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return null;
                } catch (PointerEventTimeoutCancellationException e) {
                    longPress = longPress2;
                }
                break;
            case 1:
                longPress = (Ref.ObjectRef) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1;
                r5 = (PointerInputChange) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    return null;
                } catch (PointerEventTimeoutCancellationException e2) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PointerInputChange pointerInputChange2 = (PointerInputChange) longPress.element;
        return pointerInputChange2 == null ? r5 : pointerInputChange2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    public static final boolean m615isPointerUpDmW0f2w(PointerEvent $this$isPointerUp_u2dDmW0f2w, long pointerId) {
        Object it$iv;
        List<PointerInputChange> changes = $this$isPointerUp_u2dDmW0f2w.getChanges();
        int index$iv$iv = 0;
        int size = changes.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = changes.get(index$iv$iv);
                it$iv = item$iv$iv;
                PointerInputChange it = (PointerInputChange) it$iv;
                if (PointerId.m5492equalsimpl0(it.getId(), pointerId)) {
                    break;
                }
                index$iv$iv++;
            } else {
                it$iv = null;
                break;
            }
        }
        PointerInputChange pointerInputChange = (PointerInputChange) it$iv;
        boolean z = false;
        if (pointerInputChange != null && pointerInputChange.getPressed()) {
            z = true;
        }
        return !z;
    }

    /* JADX INFO: renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m616pointerSlopE8SPZFQ(ViewConfiguration $this$pointerSlop_u2dE8SPZFQ, int pointerType) {
        return PointerType.m5583equalsimpl0(pointerType, PointerType.INSTANCE.m5588getMouseT8wyACA()) ? $this$pointerSlop_u2dE8SPZFQ.getTouchSlop() * mouseToTouchSlopRatio : $this$pointerSlop_u2dE8SPZFQ.getTouchSlop();
    }
}
