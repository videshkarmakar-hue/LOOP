package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p001ui.input.pointer.PointerEvent;
import androidx.compose.p001ui.input.pointer.PointerEventPass;
import androidx.compose.p001ui.input.pointer.PointerId;
import androidx.compose.p001ui.input.pointer.PointerInputChange;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.input.pointer.PointerType;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: compiled from: StylusHandwriting.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0004\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0080H¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m195d2 = {"detectStylusHandwriting", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onHandwritingSlopExceeded", "Lkotlin/Function0;", "", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class StylusHandwritingKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.handwriting.StylusHandwritingKt$detectStylusHandwriting$2 */
    /* JADX INFO: compiled from: StylusHandwriting.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = 176)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.handwriting.StylusHandwritingKt$detectStylusHandwriting$2", m210f = "StylusHandwriting.kt", m211i = {0, 1, 1, 2, 2}, m212l = {39, 50, 78}, m213m = "invokeSuspend", m214n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "firstDown", "$this$awaitEachGesture", "firstDown"}, m215s = {"L$0", "L$0", "L$1", "L$0", "L$1"})
    public static final class C07852 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Boolean> $onHandwritingSlopExceeded;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07852(Function0<Boolean> function0, Continuation<? super C07852> continuation) {
            super(2, continuation);
            this.$onHandwritingSlopExceeded = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07852 c07852 = new C07852(this.$onHandwritingSlopExceeded, continuation);
            c07852.L$0 = obj;
            return c07852;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C07852) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:33:0x00e2  */
        /* JADX WARN: Code duplicated, block: B:35:0x00f2  */
        /* JADX WARN: Code duplicated, block: B:42:0x0100 A[LOOP:1: B:30:0x00cd->B:42:0x0100, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:87:0x010b A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00b5 -> B:29:0x00bd). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0171 -> B:62:0x0176). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instruction units count: 508
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.handwriting.StylusHandwritingKt.C07852.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00a8 A[LOOP:1: B:15:0x0065->B:28:0x00a8, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:58:0x016a A[LOOP:3: B:45:0x0128->B:58:0x016a, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:72:0x00b4 A[EDGE_INSN: B:72:0x00b4->B:30:0x00b4 BREAK  A[LOOP:1: B:15:0x0065->B:28:0x00a8], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:75:0x0178 A[EDGE_INSN: B:75:0x0178->B:60:0x0178 BREAK  A[LOOP:3: B:45:0x0128->B:58:0x016a], SYNTHETIC] */
        public final Object invokeSuspend$$forInline(Object $result) {
            PointerInputChange exceedsTouchSlop;
            Object it$iv;
            PointerInputChange exceedsTouchSlop2;
            Object it$iv2;
            PointerEvent pointerEvent;
            int i;
            boolean z;
            boolean z2;
            AwaitPointerEventScope $this$awaitEachGesture = (AwaitPointerEventScope) this.L$0;
            int i2 = 0;
            InlineMarker.mark(0);
            int i3 = 1;
            Object objAwaitFirstDown = TapGestureDetectorKt.awaitFirstDown($this$awaitEachGesture, true, PointerEventPass.Initial, this);
            InlineMarker.mark(1);
            PointerInputChange firstDown = (PointerInputChange) objAwaitFirstDown;
            boolean isStylus = PointerType.m5583equalsimpl0(firstDown.getType(), PointerType.INSTANCE.m5589getStylusT8wyACA()) || PointerType.m5583equalsimpl0(firstDown.getType(), PointerType.INSTANCE.m5587getEraserT8wyACA());
            if (!isStylus) {
                return Unit.INSTANCE;
            }
            PointerInputChange exceedsTouchSlop3 = null;
            while (true) {
                InlineMarker.mark(i2);
                Object objAwaitPointerEvent = $this$awaitEachGesture.awaitPointerEvent(PointerEventPass.Main, this);
                InlineMarker.mark(i3);
                List<PointerInputChange> changes = ((PointerEvent) objAwaitPointerEvent).getChanges();
                int index$iv$iv = 0;
                int size = changes.size();
                while (true) {
                    if (index$iv$iv < size) {
                        Object item$iv$iv = changes.get(index$iv$iv);
                        it$iv = item$iv$iv;
                        PointerInputChange it = (PointerInputChange) it$iv;
                        if (it.isConsumed()) {
                            exceedsTouchSlop = exceedsTouchSlop3;
                        } else {
                            exceedsTouchSlop = exceedsTouchSlop3;
                            if (PointerId.m5492equalsimpl0(it.getId(), firstDown.getId()) && it.getPressed()) {
                                z2 = true;
                            }
                            if (Boolean.valueOf(z2).booleanValue()) {
                                break;
                            }
                            index$iv$iv++;
                            exceedsTouchSlop3 = exceedsTouchSlop;
                        }
                        z2 = false;
                        if (Boolean.valueOf(z2).booleanValue()) {
                            break;
                            break;
                        }
                        index$iv$iv++;
                        exceedsTouchSlop3 = exceedsTouchSlop;
                    } else {
                        exceedsTouchSlop = exceedsTouchSlop3;
                        it$iv = null;
                        break;
                    }
                }
                PointerInputChange change = (PointerInputChange) it$iv;
                if (change != null) {
                    long time = change.getUptimeMillis() - firstDown.getUptimeMillis();
                    if (time < $this$awaitEachGesture.getViewConfiguration().getLongPressTimeoutMillis()) {
                        long offset = Offset.m4053minusMKHz9U(change.getPosition(), firstDown.getPosition());
                        if (Offset.m4047getDistanceimpl(offset) > $this$awaitEachGesture.getViewConfiguration().getHandwritingSlop()) {
                            exceedsTouchSlop2 = change;
                            break;
                        }
                        exceedsTouchSlop3 = exceedsTouchSlop;
                        i2 = 0;
                        i3 = 1;
                    }
                }
                exceedsTouchSlop2 = exceedsTouchSlop;
                break;
            }
            if (exceedsTouchSlop2 == null || !this.$onHandwritingSlopExceeded.invoke().booleanValue()) {
                return Unit.INSTANCE;
            }
            exceedsTouchSlop2.consume();
            while (true) {
                InlineMarker.mark(i2);
                Object objAwaitPointerEvent2 = $this$awaitEachGesture.awaitPointerEvent(PointerEventPass.Initial, this);
                InlineMarker.mark(1);
                PointerEvent pointerEvent2 = (PointerEvent) objAwaitPointerEvent2;
                List<PointerInputChange> changes2 = pointerEvent2.getChanges();
                int index$iv$iv2 = 0;
                int size2 = changes2.size();
                while (true) {
                    if (index$iv$iv2 < size2) {
                        Object item$iv$iv2 = changes2.get(index$iv$iv2);
                        it$iv2 = item$iv$iv2;
                        PointerInputChange it2 = (PointerInputChange) it$iv2;
                        if (it2.isConsumed()) {
                            pointerEvent = pointerEvent2;
                            i = size2;
                        } else {
                            pointerEvent = pointerEvent2;
                            i = size2;
                            if (PointerId.m5492equalsimpl0(it2.getId(), firstDown.getId()) && it2.getPressed()) {
                                z = true;
                            }
                            if (Boolean.valueOf(z).booleanValue()) {
                                break;
                            }
                            index$iv$iv2++;
                            pointerEvent2 = pointerEvent;
                            size2 = i;
                        }
                        z = false;
                        if (Boolean.valueOf(z).booleanValue()) {
                            break;
                            break;
                        }
                        index$iv$iv2++;
                        pointerEvent2 = pointerEvent;
                        size2 = i;
                    } else {
                        it$iv2 = null;
                        break;
                    }
                }
                PointerInputChange pointerChange = (PointerInputChange) it$iv2;
                if (pointerChange == null) {
                    return Unit.INSTANCE;
                }
                pointerChange.consume();
                i2 = 0;
            }
        }
    }

    public static final Object detectStylusHandwriting(PointerInputScope $this$detectStylusHandwriting, Function0<Boolean> function0, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectStylusHandwriting, new C07852(function0, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    private static final Object detectStylusHandwriting$$forInline(PointerInputScope $this$detectStylusHandwriting, Function0<Boolean> function0, Continuation<? super Unit> continuation) {
        C07852 c07852 = new C07852(function0, null);
        InlineMarker.mark(0);
        ForEachGestureKt.awaitEachGesture($this$detectStylusHandwriting, c07852, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
