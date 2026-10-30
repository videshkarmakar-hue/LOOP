package androidx.compose.foundation.text.selection;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p001ui.input.pointer.PointerEvent;
import androidx.compose.p001ui.input.pointer.PointerEventKt;
import androidx.compose.p001ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.p001ui.input.pointer.PointerInputChange;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.input.pointer.PointerType;
import androidx.compose.p001ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.NotificationUtil;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SelectionGestures.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\b\u001a\u00020\u0006*\u00020\tH\u0082@¢\u0006\u0002\u0010\n\u001a&\u0010\u000b\u001a\u00020\u0005*\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u0012*\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0018\u001a\u001c\u0010\u0019\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0000\u001a\"\u0010\u001e\u001a\u00020\u0012*\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u001f\u001a \u0010 \u001a\u00020\u001a*\u00020\u001a2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\"H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, m195d2 = {"ClicksSlop", "", "STATIC_KEY", "", "isPrecisePointer", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "awaitDown", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "distanceIsTolerable", "offset1", "Landroidx/compose/ui/geometry/Offset;", "offset2", "distanceIsTolerable-2x9bVx0", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JJ)Z", "mouseSelection", "", "observer", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "clicksCounter", "Landroidx/compose/foundation/text/selection/ClicksCounter;", "down", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/selection/ClicksCounter;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectionGestureInput", "Landroidx/compose/ui/Modifier;", "mouseSelectionObserver", "textDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "touchSelection", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/TextDragObserver;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSelectionTouchMode", "updateTouchMode", "Lkotlin/Function1;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SelectionGesturesKt {
    public static final double ClicksSlop = 100.0d;
    private static final int STATIC_KEY = 8675309;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 */
    /* JADX INFO: compiled from: SelectionGestures.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", m210f = "SelectionGestures.kt", m211i = {0}, m212l = {225}, m213m = "awaitDown", m214n = {"$this$awaitDown"}, m215s = {"L$0"})
    static final class C08991 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08991(Continuation<? super C08991> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.awaitDown(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$1 */
    /* JADX INFO: compiled from: SelectionGestures.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", m210f = "SelectionGestures.kt", m211i = {0, 0, 1, 1}, m212l = {153, 176}, m213m = "mouseSelection", m214n = {"$this$mouseSelection", "observer", "$this$mouseSelection", "observer"}, m215s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C09001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09001(Continuation<? super C09001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.mouseSelection(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1 */
    /* JADX INFO: compiled from: SelectionGestures.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", m210f = "SelectionGestures.kt", m211i = {0, 0, 0, 1, 1}, m212l = {119, NotificationUtil.SERVICE_NOTIFICATION_ID}, m213m = "touchSelection", m214n = {"$this$touchSelection", "observer", "firstDown", "$this$touchSelection", "observer"}, m215s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    static final class C09021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C09021(Continuation<? super C09021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.touchSelection(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1 */
    /* JADX INFO: compiled from: SelectionGestures.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1", m210f = "SelectionGestures.kt", m211i = {}, m212l = {86}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C09041 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $updateTouchMode;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09041(Function1<? super Boolean, Unit> function1, Continuation<? super C09041> continuation) {
            super(2, continuation);
            this.$updateTouchMode = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09041 c09041 = new C09041(this.$updateTouchMode, continuation);
            c09041.L$0 = obj;
            return c09041;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C09041) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: SelectionGestures.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1$1", m210f = "SelectionGestures.kt", m211i = {0}, m212l = {88}, m213m = "invokeSuspend", m214n = {"$this$awaitPointerEventScope"}, m215s = {"L$0"})
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Boolean, Unit> $updateTouchMode;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Function1<? super Boolean, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$updateTouchMode = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$updateTouchMode, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0038 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:11:0x0039  */
            /* JADX WARN: Code duplicated, block: B:14:0x0049  */
            /* JADX WARN: Code duplicated, block: B:15:0x004b  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0039 -> B:12:0x003f). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:15:0x004b
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
                    r2 = 1
                    switch(r1) {
                        case 0: goto L20;
                        case 1: goto L13;
                        default: goto La;
                    }
                La:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r0)
                    throw r9
                L13:
                    r1 = r8
                    java.lang.Object r3 = r1.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.p001ui.input.pointer.AwaitPointerEventScope) r3
                    kotlin.ResultKt.throwOnFailure(r9)
                    r4 = r3
                    r3 = r1
                    r1 = r0
                    r0 = r9
                    goto L3f
                L20:
                    kotlin.ResultKt.throwOnFailure(r9)
                    r1 = r8
                    java.lang.Object r3 = r1.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.p001ui.input.pointer.AwaitPointerEventScope) r3
                L28:
                    androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.p001ui.input.pointer.PointerEventPass.Initial
                    r5 = r1
                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                    r1.L$0 = r3
                    r1.label = r2
                    java.lang.Object r4 = r3.awaitPointerEvent(r4, r5)
                    if (r4 != r0) goto L39
                    return r0
                L39:
                    r7 = r0
                    r0 = r9
                    r9 = r4
                    r4 = r3
                    r3 = r1
                    r1 = r7
                L3f:
                    androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.p001ui.input.pointer.PointerEvent) r9
                    kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r5 = r3.$updateTouchMode
                    boolean r6 = androidx.compose.foundation.text.selection.SelectionGesturesKt.isPrecisePointer(r9)
                    if (r6 != 0) goto L4b
                    r9 = 1
                    goto L4c
                L4b:
                    r9 = 0
                L4c:
                    java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
                    r5.invoke(r9)
                    r9 = r0
                    r0 = r1
                    r1 = r3
                    r3 = r4
                    goto L28
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.C09041.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                    this.label = 1;
                    if ($this$pointerInput.awaitPointerEventScope(new AnonymousClass1(this.$updateTouchMode, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public static final Modifier updateSelectionTouchMode(Modifier $this$updateSelectionTouchMode, Function1<? super Boolean, Unit> function1) {
        return SuspendingPointerInputFilterKt.pointerInput($this$updateSelectionTouchMode, Integer.valueOf(STATIC_KEY), new C09041(function1, null));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1 */
    /* JADX INFO: compiled from: SelectionGestures.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1", m210f = "SelectionGestures.kt", m211i = {}, m212l = {99}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C09011 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MouseSelectionObserver $mouseSelectionObserver;
        final /* synthetic */ TextDragObserver $textDragObserver;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09011(MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super C09011> continuation) {
            super(2, continuation);
            this.$mouseSelectionObserver = mouseSelectionObserver;
            this.$textDragObserver = textDragObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09011 c09011 = new C09011(this.$mouseSelectionObserver, this.$textDragObserver, continuation);
            c09011.L$0 = obj;
            return c09011;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C09011) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                    ClicksCounter clicksCounter = new ClicksCounter($this$pointerInput.getViewConfiguration());
                    this.label = 1;
                    if (ForEachGestureKt.awaitEachGesture($this$pointerInput, new AnonymousClass1(this.$mouseSelectionObserver, clicksCounter, this.$textDragObserver, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: SelectionGestures.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1$1", m210f = "SelectionGestures.kt", m211i = {0}, m212l = {100, 106, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, m213m = "invokeSuspend", m214n = {"$this$awaitEachGesture"}, m215s = {"L$0"})
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ClicksCounter $clicksCounter;
            final /* synthetic */ MouseSelectionObserver $mouseSelectionObserver;
            final /* synthetic */ TextDragObserver $textDragObserver;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MouseSelectionObserver mouseSelectionObserver, ClicksCounter clicksCounter, TextDragObserver textDragObserver, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$mouseSelectionObserver = mouseSelectionObserver;
                this.$clicksCounter = clicksCounter;
                this.$textDragObserver = textDragObserver;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$mouseSelectionObserver, this.$clicksCounter, this.$textDragObserver, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:18:0x0071  */
            /* JADX WARN: Code duplicated, block: B:20:0x0082  */
            /* JADX WARN: Code duplicated, block: B:21:0x0084  */
            /* JADX WARN: Code duplicated, block: B:24:0x0089 A[LOOP:0: B:17:0x006f->B:24:0x0089, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:27:0x0091  */
            /* JADX WARN: Code duplicated, block: B:29:0x00a3 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:30:0x00a4  */
            /* JADX WARN: Code duplicated, block: B:34:0x00af  */
            /* JADX WARN: Code duplicated, block: B:36:0x00bf A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:37:0x00c0  */
            /* JADX WARN: Code duplicated, block: B:42:0x0087 A[SYNTHETIC] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                AnonymousClass1 anonymousClass1;
                Object $result;
                AwaitPointerEventScope $this$awaitEachGesture;
                Object objAwaitDown;
                PointerEvent down;
                AnonymousClass1 anonymousClass2;
                Object $result2;
                List<PointerInputChange> changes;
                int index$iv$iv;
                int size;
                AnonymousClass1 anonymousClass3;
                Object $result3;
                PointerInputChange it;
                boolean z;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z2 = true;
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        anonymousClass1 = this;
                        $result = obj;
                        $this$awaitEachGesture = (AwaitPointerEventScope) anonymousClass1.L$0;
                        anonymousClass1.L$0 = $this$awaitEachGesture;
                        anonymousClass1.label = 1;
                        objAwaitDown = SelectionGesturesKt.awaitDown($this$awaitEachGesture, anonymousClass1);
                        if (objAwaitDown == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        down = (PointerEvent) objAwaitDown;
                        if (SelectionGesturesKt.isPrecisePointer(down) && PointerEvent_androidKt.m5483isPrimaryPressedaHzCxE(down.getButtons())) {
                            changes = down.getChanges();
                            size = changes.size();
                            for (index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                                Object it$iv = changes.get(index$iv$iv);
                                it = (PointerInputChange) it$iv;
                                if (it.isConsumed()) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (!z) {
                                    z2 = false;
                                    if (z2) {
                                        anonymousClass1.L$0 = null;
                                        anonymousClass1.label = 2;
                                        if (SelectionGesturesKt.mouseSelection($this$awaitEachGesture, anonymousClass1.$mouseSelectionObserver, anonymousClass1.$clicksCounter, down, anonymousClass1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        anonymousClass3 = anonymousClass1;
                                        $result3 = $result;
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                            if (z2) {
                                anonymousClass1.L$0 = null;
                                anonymousClass1.label = 2;
                                if (SelectionGesturesKt.mouseSelection($this$awaitEachGesture, anonymousClass1.$mouseSelectionObserver, anonymousClass1.$clicksCounter, down, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                anonymousClass3 = anonymousClass1;
                                $result3 = $result;
                            }
                            return Unit.INSTANCE;
                        }
                        if (!SelectionGesturesKt.isPrecisePointer(down)) {
                            anonymousClass1.L$0 = null;
                            anonymousClass1.label = 3;
                            if (SelectionGesturesKt.touchSelection($this$awaitEachGesture, anonymousClass1.$textDragObserver, down, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            anonymousClass2 = anonymousClass1;
                            $result2 = $result;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        anonymousClass1 = this;
                        $result = obj;
                        $this$awaitEachGesture = (AwaitPointerEventScope) anonymousClass1.L$0;
                        ResultKt.throwOnFailure($result);
                        objAwaitDown = $result;
                        down = (PointerEvent) objAwaitDown;
                        if (SelectionGesturesKt.isPrecisePointer(down)) {
                            changes = down.getChanges();
                            size = changes.size();
                            while (index$iv$iv < size) {
                                Object it$iv2 = changes.get(index$iv$iv);
                                it = (PointerInputChange) it$iv2;
                                if (it.isConsumed()) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    z2 = false;
                                    if (z2) {
                                        anonymousClass1.L$0 = null;
                                        anonymousClass1.label = 2;
                                        if (SelectionGesturesKt.mouseSelection($this$awaitEachGesture, anonymousClass1.$mouseSelectionObserver, anonymousClass1.$clicksCounter, down, anonymousClass1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        anonymousClass3 = anonymousClass1;
                                        $result3 = $result;
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                            if (z2) {
                                anonymousClass1.L$0 = null;
                                anonymousClass1.label = 2;
                                if (SelectionGesturesKt.mouseSelection($this$awaitEachGesture, anonymousClass1.$mouseSelectionObserver, anonymousClass1.$clicksCounter, down, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                anonymousClass3 = anonymousClass1;
                                $result3 = $result;
                            }
                            return Unit.INSTANCE;
                        }
                        if (!SelectionGesturesKt.isPrecisePointer(down)) {
                            anonymousClass1.L$0 = null;
                            anonymousClass1.label = 3;
                            if (SelectionGesturesKt.touchSelection($this$awaitEachGesture, anonymousClass1.$textDragObserver, down, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            anonymousClass2 = anonymousClass1;
                            $result2 = $result;
                        }
                        return Unit.INSTANCE;
                    case 2:
                        anonymousClass3 = this;
                        $result3 = obj;
                        ResultKt.throwOnFailure($result3);
                        return Unit.INSTANCE;
                    case 3:
                        anonymousClass2 = this;
                        $result2 = obj;
                        ResultKt.throwOnFailure($result2);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    public static final Modifier selectionGestureInput(Modifier $this$selectionGestureInput, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver) {
        return SuspendingPointerInputFilterKt.pointerInput($this$selectionGestureInput, mouseSelectionObserver, textDragObserver, new C09011(mouseSelectionObserver, textDragObserver, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x00ad A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x00b6 A[Catch: CancellationException -> 0x00e9, TryCatch #1 {CancellationException -> 0x00e9, blocks: (B:32:0x00ae, B:34:0x00b6, B:36:0x00c7, B:38:0x00d6, B:39:0x00d9, B:40:0x00de, B:41:0x00e3, B:18:0x004d, B:25:0x0078, B:27:0x007c, B:29:0x008a, B:21:0x0056), top: B:50:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00c7 A[Catch: CancellationException -> 0x00e9, TryCatch #1 {CancellationException -> 0x00e9, blocks: (B:32:0x00ae, B:34:0x00b6, B:36:0x00c7, B:38:0x00d6, B:39:0x00d9, B:40:0x00de, B:41:0x00e3, B:18:0x004d, B:25:0x0078, B:27:0x007c, B:29:0x008a, B:21:0x0056), top: B:50:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00d6 A[Catch: CancellationException -> 0x00e9, TryCatch #1 {CancellationException -> 0x00e9, blocks: (B:32:0x00ae, B:34:0x00b6, B:36:0x00c7, B:38:0x00d6, B:39:0x00d9, B:40:0x00de, B:41:0x00e3, B:18:0x004d, B:25:0x0078, B:27:0x007c, B:29:0x008a, B:21:0x0056), top: B:50:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00e3 A[Catch: CancellationException -> 0x00e9, TRY_LEAVE, TryCatch #1 {CancellationException -> 0x00e9, blocks: (B:32:0x00ae, B:34:0x00b6, B:36:0x00c7, B:38:0x00d6, B:39:0x00d9, B:40:0x00de, B:41:0x00e3, B:18:0x004d, B:25:0x0078, B:27:0x007c, B:29:0x008a, B:21:0x0056), top: B:50:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object touchSelection(AwaitPointerEventScope $this$touchSelection, final TextDragObserver observer, PointerEvent down, Continuation<? super Unit> continuation) {
        C09021 c09021;
        CancellationException c;
        TextDragObserver observer2;
        Object objM604awaitLongPressOrCancellationrnUCldI;
        AwaitPointerEventScope $this$touchSelection2;
        PointerInputChange firstDown;
        PointerInputChange drag;
        Object objM613dragjO51t88;
        List<PointerInputChange> changes;
        int index$iv;
        int size;
        PointerInputChange it;
        if (continuation instanceof C09021) {
            c09021 = (C09021) continuation;
            if ((c09021.label & Integer.MIN_VALUE) != 0) {
                c09021.label -= Integer.MIN_VALUE;
            } else {
                c09021 = new C09021(continuation);
            }
        } else {
            c09021 = new C09021(continuation);
        }
        C09021 c09022 = c09021;
        Object $result = c09022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c09022.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PointerInputChange firstDown2 = (PointerInputChange) CollectionsKt.first((List) down.getChanges());
                    long id = firstDown2.getId();
                    c09022.L$0 = $this$touchSelection;
                    c09022.L$1 = observer;
                    c09022.L$2 = firstDown2;
                    c09022.label = 1;
                    objM604awaitLongPressOrCancellationrnUCldI = DragGestureDetectorKt.m604awaitLongPressOrCancellationrnUCldI($this$touchSelection, id, c09022);
                    if (objM604awaitLongPressOrCancellationrnUCldI == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$touchSelection2 = $this$touchSelection;
                    firstDown = firstDown2;
                    drag = (PointerInputChange) objM604awaitLongPressOrCancellationrnUCldI;
                    if (drag != null && m1474distanceIsTolerable2x9bVx0($this$touchSelection2, firstDown.getPosition(), drag.getPosition())) {
                        observer.mo1237onStartk4lQ0M(drag.getPosition());
                        long id2 = drag.getId();
                        Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelection.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange) {
                                invoke2(pointerInputChange);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PointerInputChange it2) {
                                observer.mo1236onDragk4lQ0M(PointerEventKt.positionChange(it2));
                                it2.consume();
                            }
                        };
                        c09022.L$0 = $this$touchSelection2;
                        c09022.L$1 = observer;
                        c09022.L$2 = null;
                        c09022.label = 2;
                        objM613dragjO51t88 = DragGestureDetectorKt.m613dragjO51t88($this$touchSelection2, id2, function1, c09022);
                        if (objM613dragjO51t88 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (((Boolean) objM613dragjO51t88).booleanValue()) {
                            changes = $this$touchSelection2.getCurrentEvent().getChanges();
                            size = changes.size();
                            for (index$iv = 0; index$iv < size; index$iv++) {
                                Object item$iv = changes.get(index$iv);
                                it = (PointerInputChange) item$iv;
                                if (PointerEventKt.changedToUp(it)) {
                                    it.consume();
                                }
                            }
                            observer.onStop();
                        } else {
                            observer.onCancel();
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    firstDown = (PointerInputChange) c09022.L$2;
                    observer = (TextDragObserver) c09022.L$1;
                    $this$touchSelection2 = (AwaitPointerEventScope) c09022.L$0;
                    ResultKt.throwOnFailure($result);
                    objM604awaitLongPressOrCancellationrnUCldI = $result;
                    drag = (PointerInputChange) objM604awaitLongPressOrCancellationrnUCldI;
                    if (drag != null) {
                        observer.mo1237onStartk4lQ0M(drag.getPosition());
                        long id3 = drag.getId();
                        Function1<PointerInputChange, Unit> function2 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelection.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange) {
                                invoke2(pointerInputChange);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PointerInputChange it2) {
                                observer.mo1236onDragk4lQ0M(PointerEventKt.positionChange(it2));
                                it2.consume();
                            }
                        };
                        c09022.L$0 = $this$touchSelection2;
                        c09022.L$1 = observer;
                        c09022.L$2 = null;
                        c09022.label = 2;
                        objM613dragjO51t88 = DragGestureDetectorKt.m613dragjO51t88($this$touchSelection2, id3, function2, c09022);
                        if (objM613dragjO51t88 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (((Boolean) objM613dragjO51t88).booleanValue()) {
                            changes = $this$touchSelection2.getCurrentEvent().getChanges();
                            size = changes.size();
                            while (index$iv < size) {
                                Object item$iv2 = changes.get(index$iv);
                                it = (PointerInputChange) item$iv2;
                                if (PointerEventKt.changedToUp(it)) {
                                    it.consume();
                                }
                            }
                            observer.onStop();
                        } else {
                            observer.onCancel();
                        }
                    }
                    return Unit.INSTANCE;
                case 2:
                    observer2 = (TextDragObserver) c09022.L$1;
                    AwaitPointerEventScope $this$touchSelection3 = (AwaitPointerEventScope) c09022.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        $this$touchSelection2 = $this$touchSelection3;
                        observer = observer2;
                        objM613dragjO51t88 = $result;
                        if (((Boolean) objM613dragjO51t88).booleanValue()) {
                            changes = $this$touchSelection2.getCurrentEvent().getChanges();
                            size = changes.size();
                            while (index$iv < size) {
                                Object item$iv3 = changes.get(index$iv);
                                it = (PointerInputChange) item$iv3;
                                if (PointerEventKt.changedToUp(it)) {
                                    it.consume();
                                }
                            }
                            observer.onStop();
                        } else {
                            observer.onCancel();
                        }
                        return Unit.INSTANCE;
                    } catch (CancellationException e) {
                        c = e;
                        observer2.onCancel();
                        throw c;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (CancellationException e2) {
            c = e2;
            observer2 = observer;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:24:0x008e  */
    /* JADX WARN: Code duplicated, block: B:26:0x009f  */
    /* JADX WARN: Code duplicated, block: B:28:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:45:0x0104  */
    /* JADX WARN: Code duplicated, block: B:47:0x0115  */
    /* JADX WARN: Code duplicated, block: B:49:0x0122  */
    /* JADX WARN: Code duplicated, block: B:57:0x0125 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x00af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object mouseSelection(AwaitPointerEventScope $this$mouseSelection, final MouseSelectionObserver observer, ClicksCounter clicksCounter, PointerEvent down, Continuation<? super Unit> continuation) {
        C09001 c09001;
        final SelectionAdjustment selectionAdjustment;
        Object objM613dragjO51t88;
        AwaitPointerEventScope $this$mouseSelection2;
        MouseSelectionObserver observer2;
        Object objM613dragjO51t89;
        AwaitPointerEventScope $this$mouseSelection3;
        MouseSelectionObserver observer3;
        boolean shouldConsumeUp;
        List<PointerInputChange> changes;
        int index$iv;
        int size;
        PointerInputChange it;
        boolean shouldConsumeUp2;
        List<PointerInputChange> changes2;
        int index$iv2;
        int size2;
        PointerInputChange it2;
        if (continuation instanceof C09001) {
            c09001 = (C09001) continuation;
            if ((c09001.label & Integer.MIN_VALUE) != 0) {
                c09001.label -= Integer.MIN_VALUE;
            } else {
                c09001 = new C09001(continuation);
            }
        } else {
            c09001 = new C09001(continuation);
        }
        C09001 c09002 = c09001;
        Object $result = c09002.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c09002.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                clicksCounter.update(down);
                PointerInputChange downChange = down.getChanges().get(0);
                if (TextFieldSelectionManager_androidKt.isShiftPressed(down)) {
                    boolean started = observer.mo1452onExtendk4lQ0M(downChange.getPosition());
                    if (started) {
                        long id = downChange.getId();
                        Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange) {
                                invoke2(pointerInputChange);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PointerInputChange it3) {
                                if (observer.mo1453onExtendDragk4lQ0M(it3.getPosition())) {
                                    it3.consume();
                                }
                            }
                        };
                        c09002.L$0 = $this$mouseSelection;
                        c09002.L$1 = observer;
                        c09002.label = 1;
                        objM613dragjO51t89 = DragGestureDetectorKt.m613dragjO51t88($this$mouseSelection, id, function1, c09002);
                        if (objM613dragjO51t89 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$mouseSelection3 = $this$mouseSelection;
                        observer3 = observer;
                        shouldConsumeUp = ((Boolean) objM613dragjO51t89).booleanValue();
                        if (shouldConsumeUp) {
                            changes = $this$mouseSelection3.getCurrentEvent().getChanges();
                            size = changes.size();
                            for (index$iv = 0; index$iv < size; index$iv++) {
                                Object item$iv = changes.get(index$iv);
                                it = (PointerInputChange) item$iv;
                                if (PointerEventKt.changedToUp(it)) {
                                    it.consume();
                                }
                            }
                        }
                        observer3.onDragDone();
                    }
                } else {
                    switch (clicksCounter.getClicks()) {
                        case 1:
                            selectionAdjustment = SelectionAdjustment.INSTANCE.getNone();
                            break;
                        case 2:
                            selectionAdjustment = SelectionAdjustment.INSTANCE.getWord();
                            break;
                        default:
                            selectionAdjustment = SelectionAdjustment.INSTANCE.getParagraph();
                            break;
                    }
                    boolean started2 = observer.mo1454onStart3MmeM6k(downChange.getPosition(), selectionAdjustment);
                    if (started2) {
                        long id2 = downChange.getId();
                        Function1<PointerInputChange, Unit> function2 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange) {
                                invoke2(pointerInputChange);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PointerInputChange it3) {
                                if (observer.mo1451onDrag3MmeM6k(it3.getPosition(), selectionAdjustment)) {
                                    it3.consume();
                                }
                            }
                        };
                        c09002.L$0 = $this$mouseSelection;
                        c09002.L$1 = observer;
                        c09002.label = 2;
                        objM613dragjO51t88 = DragGestureDetectorKt.m613dragjO51t88($this$mouseSelection, id2, function2, c09002);
                        if (objM613dragjO51t88 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$mouseSelection2 = $this$mouseSelection;
                        observer2 = observer;
                        shouldConsumeUp2 = ((Boolean) objM613dragjO51t88).booleanValue();
                        if (shouldConsumeUp2) {
                            changes2 = $this$mouseSelection2.getCurrentEvent().getChanges();
                            size2 = changes2.size();
                            for (index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                                Object item$iv2 = changes2.get(index$iv2);
                                it2 = (PointerInputChange) item$iv2;
                                if (PointerEventKt.changedToUp(it2)) {
                                    it2.consume();
                                }
                            }
                        }
                        observer2.onDragDone();
                    }
                }
                return Unit.INSTANCE;
            case 1:
                observer3 = (MouseSelectionObserver) c09002.L$1;
                $this$mouseSelection3 = (AwaitPointerEventScope) c09002.L$0;
                ResultKt.throwOnFailure($result);
                objM613dragjO51t89 = $result;
                shouldConsumeUp = ((Boolean) objM613dragjO51t89).booleanValue();
                if (shouldConsumeUp) {
                    changes = $this$mouseSelection3.getCurrentEvent().getChanges();
                    size = changes.size();
                    while (index$iv < size) {
                        Object item$iv3 = changes.get(index$iv);
                        it = (PointerInputChange) item$iv3;
                        if (PointerEventKt.changedToUp(it)) {
                            it.consume();
                        }
                    }
                }
                observer3.onDragDone();
                return Unit.INSTANCE;
            case 2:
                observer2 = (MouseSelectionObserver) c09002.L$1;
                $this$mouseSelection2 = (AwaitPointerEventScope) c09002.L$0;
                ResultKt.throwOnFailure($result);
                objM613dragjO51t88 = $result;
                shouldConsumeUp2 = ((Boolean) objM613dragjO51t88).booleanValue();
                if (shouldConsumeUp2) {
                    changes2 = $this$mouseSelection2.getCurrentEvent().getChanges();
                    size2 = changes2.size();
                    while (index$iv2 < size2) {
                        Object item$iv4 = changes2.get(index$iv2);
                        it2 = (PointerInputChange) item$iv4;
                        if (PointerEventKt.changedToUp(it2)) {
                            it2.consume();
                        }
                    }
                }
                observer2.onDragDone();
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x0068  */
    /* JADX WARN: Code duplicated, block: B:23:0x007a A[LOOP:0: B:19:0x0066->B:23:0x007a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:29:0x0078 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004f -> B:18:0x0056). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object awaitDown(androidx.compose.p001ui.input.pointer.AwaitPointerEventScope r17, kotlin.coroutines.Continuation<? super androidx.compose.p001ui.input.pointer.PointerEvent> r18) {
        /*
            r0 = r18
            boolean r1 = r0 instanceof androidx.compose.foundation.text.selection.SelectionGesturesKt.C08991
            if (r1 == 0) goto L16
            r1 = r0
            androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 r1 = (androidx.compose.foundation.text.selection.SelectionGesturesKt.C08991) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L1b
        L16:
            androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 r1 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1
            r1.<init>(r0)
        L1b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 1
            switch(r3) {
                case 0: goto L3c;
                case 1: goto L31;
                default: goto L28;
            }
        L28:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L31:
            java.lang.Object r3 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.p001ui.input.pointer.AwaitPointerEventScope) r3
            kotlin.ResultKt.throwOnFailure(r1)
            r5 = r3
            r3 = r2
            r2 = r1
            goto L56
        L3c:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r17
        L42:
            androidx.compose.ui.input.pointer.PointerEventPass r5 = androidx.compose.p001ui.input.pointer.PointerEventPass.Main
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r5 = r3.awaitPointerEvent(r5, r0)
            if (r5 != r2) goto L4f
            return r2
        L4f:
            r16 = r2
            r2 = r1
            r1 = r5
            r5 = r3
            r3 = r16
        L56:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.p001ui.input.pointer.PointerEvent) r1
            java.util.List r6 = r1.getChanges()
            r7 = 0
            r8 = 0
            r9 = 0
            int r10 = r6.size()
        L66:
            if (r9 >= r10) goto L7e
            java.lang.Object r11 = r6.get(r9)
            r12 = r11
            r13 = 0
            r14 = r12
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.p001ui.input.pointer.PointerInputChange) r14
            r15 = 0
            boolean r14 = androidx.compose.p001ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r14)
            if (r14 != 0) goto L7a
            r10 = 0
            goto L80
        L7a:
            int r9 = r9 + 1
            goto L66
        L7e:
            r10 = 1
        L80:
            if (r10 == 0) goto L83
            return r1
        L83:
            r1 = r2
            r2 = r3
            r3 = r5
            goto L42
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.awaitDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: distanceIsTolerable-2x9bVx0, reason: not valid java name */
    private static final boolean m1474distanceIsTolerable2x9bVx0(AwaitPointerEventScope $this$distanceIsTolerable_u2d2x9bVx0, long offset1, long offset2) {
        return Offset.m4047getDistanceimpl(Offset.m4053minusMKHz9U(offset1, offset2)) < $this$distanceIsTolerable_u2d2x9bVx0.getViewConfiguration().getTouchSlop();
    }

    public static final boolean isPrecisePointer(PointerEvent $this$isPrecisePointer) {
        List<PointerInputChange> changes = $this$isPrecisePointer.getChanges();
        int size = changes.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            Object item$iv$iv = changes.get(index$iv$iv);
            PointerInputChange it = (PointerInputChange) item$iv$iv;
            if (!PointerType.m5583equalsimpl0(it.getType(), PointerType.INSTANCE.m5588getMouseT8wyACA())) {
                return false;
            }
        }
        return true;
    }
}
