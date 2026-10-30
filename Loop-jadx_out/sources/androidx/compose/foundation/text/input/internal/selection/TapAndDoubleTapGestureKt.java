package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.PressGestureScopeImpl;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p001ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.p001ui.input.pointer.PointerInputChange;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: compiled from: TapAndDoubleTapGesture.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0082@¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u0007\u001aY\u0010\b\u001a\u00020\u0006*\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2-\u0010\r\u001a)\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000e¢\u0006\u0002\b\u0013H\u0080@¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, m195d2 = {"awaitSecondDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "firstUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeUntilUp", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapAndDoubleTap", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onTap", "Landroidx/compose/foundation/text/input/internal/selection/TapOnPosition;", "onDoubleTap", "onPress", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/input/internal/selection/TapOnPosition;Landroidx/compose/foundation/text/input/internal/selection/TapOnPosition;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TapAndDoubleTapGestureKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$consumeUntilUp$1 */
    /* JADX INFO: compiled from: TapAndDoubleTapGesture.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt", m210f = "TapAndDoubleTapGesture.kt", m211i = {0}, m212l = {TarConstants.CHKSUM_OFFSET}, m213m = "consumeUntilUp", m214n = {"$this$consumeUntilUp"}, m215s = {"L$0"})
    static final class C08401 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08401(Continuation<? super C08401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapAndDoubleTapGestureKt.consumeUntilUp(null, this);
        }
    }

    public static /* synthetic */ Object detectTapAndDoubleTap$default(PointerInputScope pointerInputScope, TapOnPosition tapOnPosition, TapOnPosition tapOnPosition2, Function3 function3, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            tapOnPosition = null;
        }
        if ((i & 2) != 0) {
            tapOnPosition2 = null;
        }
        return detectTapAndDoubleTap(pointerInputScope, tapOnPosition, tapOnPosition2, function3, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2 */
    /* JADX INFO: compiled from: TapAndDoubleTapGesture.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2", m210f = "TapAndDoubleTapGesture.kt", m211i = {}, m212l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C08412 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TapOnPosition $onDoubleTap;
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ TapOnPosition $onTap;
        final /* synthetic */ PointerInputScope $this_detectTapAndDoubleTap;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08412(PointerInputScope pointerInputScope, TapOnPosition tapOnPosition, TapOnPosition tapOnPosition2, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super C08412> continuation) {
            super(2, continuation);
            this.$this_detectTapAndDoubleTap = pointerInputScope;
            this.$onTap = tapOnPosition;
            this.$onDoubleTap = tapOnPosition2;
            this.$onPress = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08412 c08412 = new C08412(this.$this_detectTapAndDoubleTap, this.$onTap, this.$onDoubleTap, this.$onPress, continuation);
            c08412.L$0 = obj;
            return c08412;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08412) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    PressGestureScopeImpl pressScope = new PressGestureScopeImpl(this.$this_detectTapAndDoubleTap);
                    this.label = 1;
                    if (ForEachGestureKt.awaitEachGesture(this.$this_detectTapAndDoubleTap, new AnonymousClass1($this$coroutineScope, this.$onTap, this.$onDoubleTap, pressScope, this.$onPress, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TapAndDoubleTapGesture.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1", m210f = "TapAndDoubleTapGesture.kt", m211i = {0, 1, 1, 2, 2, 2, 3, 3, 4}, m212l = {52, 63, 77, 90, 99, 114}, m213m = "invokeSuspend", m214n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "longPressTimeout", "$this$awaitEachGesture", "upOrCancel", "longPressTimeout", "$this$awaitEachGesture", "longPressTimeout", "$this$awaitEachGesture"}, m215s = {"L$0", "L$0", "J$0", "L$0", "L$1", "J$0", "L$0", "J$0", "L$0"})
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ TapOnPosition $onDoubleTap;
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ TapOnPosition $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            long J$0;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(CoroutineScope coroutineScope, TapOnPosition tapOnPosition, TapOnPosition tapOnPosition2, PressGestureScopeImpl pressGestureScopeImpl, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.$onTap = tapOnPosition;
                this.$onDoubleTap = tapOnPosition2;
                this.$pressScope = pressGestureScopeImpl;
                this.$onPress = function3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.$onTap, this.$onDoubleTap, this.$pressScope, this.$onPress, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:27:0x00e8 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:31:0x00ee A[Catch: PointerEventTimeoutCancellationException -> 0x012b, TRY_ENTER, TryCatch #0 {PointerEventTimeoutCancellationException -> 0x012b, blocks: (B:31:0x00ee, B:32:0x0103, B:25:0x00d1), top: B:70:0x00d1 }] */
            /* JADX WARN: Code duplicated, block: B:32:0x0103 A[Catch: PointerEventTimeoutCancellationException -> 0x012b, TRY_LEAVE, TryCatch #0 {PointerEventTimeoutCancellationException -> 0x012b, blocks: (B:31:0x00ee, B:32:0x0103, B:25:0x00d1), top: B:70:0x00d1 }] */
            /* JADX WARN: Code duplicated, block: B:40:0x0142 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:43:0x015d  */
            /* JADX WARN: Code duplicated, block: B:45:0x0164  */
            /* JADX WARN: Code duplicated, block: B:48:0x016f  */
            /* JADX WARN: Code duplicated, block: B:50:0x0181 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:51:0x0182  */
            /* JADX WARN: Code duplicated, block: B:54:0x018b  */
            /* JADX WARN: Code duplicated, block: B:57:0x01d6 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:58:0x01d7  */
            /* JADX WARN: Code duplicated, block: B:64:0x01ee A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:65:0x01ef  */
            /* JADX WARN: Code duplicated, block: B:67:0x0205  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                AwaitPointerEventScope $this$awaitEachGesture;
                AnonymousClass1 anonymousClass1;
                Object $result2;
                Object $result3;
                long longPressTimeout;
                PointerInputChange upOrCancel;
                PointerInputChange upOrCancel2;
                AnonymousClass1 anonymousClass2;
                Object $result4;
                long longPressTimeout2;
                Object objWithTimeout;
                PointerInputChange upOrCancel3;
                Object $result5;
                TapOnPosition tapOnPosition;
                Object $result6;
                AwaitPointerEventScope $this$awaitEachGesture2;
                Object $result7;
                long longPressTimeout3;
                AnonymousClass1 anonymousClass3;
                PointerInputChange secondDown;
                AnonymousClass1 anonymousClass4;
                AwaitPointerEventScope $this$awaitEachGesture3;
                AnonymousClass1 anonymousClass5;
                Object $result8;
                Object $result9;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        AwaitPointerEventScope $this$awaitEachGesture4 = (AwaitPointerEventScope) this.L$0;
                        this.L$0 = $this$awaitEachGesture4;
                        this.label = 1;
                        Object objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default($this$awaitEachGesture4, false, null, this, 3, null);
                        if (objAwaitFirstDown$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$awaitEachGesture = $this$awaitEachGesture4;
                        anonymousClass1 = this;
                        $result2 = $result;
                        $result3 = objAwaitFirstDown$default;
                        PointerInputChange down = (PointerInputChange) $result3;
                        down.consume();
                        BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, null, new C45571(anonymousClass1.$pressScope, anonymousClass1.$onPress, down, null), 3, null);
                        longPressTimeout = $this$awaitEachGesture.getViewConfiguration().getLongPressTimeoutMillis();
                        upOrCancel = null;
                        try {
                            anonymousClass1.L$0 = $this$awaitEachGesture;
                            anonymousClass1.J$0 = longPressTimeout;
                            anonymousClass1.label = 2;
                            objWithTimeout = $this$awaitEachGesture.withTimeout(longPressTimeout, new AnonymousClass2(null), anonymousClass1);
                            if (objWithTimeout == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            try {
                                upOrCancel3 = (PointerInputChange) objWithTimeout;
                                if (upOrCancel3 == null) {
                                    BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, null, new AnonymousClass3(anonymousClass1.$pressScope, null), 3, null);
                                } else {
                                    upOrCancel3.consume();
                                    BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, null, new AnonymousClass4(anonymousClass1.$pressScope, null), 3, null);
                                }
                                anonymousClass2 = anonymousClass1;
                                $result5 = $result2;
                                longPressTimeout2 = longPressTimeout;
                            } catch (PointerEventTimeoutCancellationException e) {
                                upOrCancel2 = upOrCancel;
                                anonymousClass2 = anonymousClass1;
                                $result4 = $result2;
                                longPressTimeout2 = longPressTimeout;
                                anonymousClass2.L$0 = $this$awaitEachGesture;
                                anonymousClass2.L$1 = upOrCancel2;
                                anonymousClass2.J$0 = longPressTimeout2;
                                anonymousClass2.label = 3;
                                if (TapAndDoubleTapGestureKt.consumeUntilUp($this$awaitEachGesture, anonymousClass2) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                BuildersKt__Builders_commonKt.launch$default(anonymousClass2.$$this$coroutineScope, null, null, new AnonymousClass5(anonymousClass2.$pressScope, null), 3, null);
                                PointerInputChange pointerInputChange = upOrCancel2;
                                $result5 = $result4;
                                upOrCancel3 = pointerInputChange;
                            }
                        } catch (PointerEventTimeoutCancellationException e2) {
                            upOrCancel2 = null;
                            anonymousClass2 = anonymousClass1;
                            $result4 = $result2;
                            longPressTimeout2 = longPressTimeout;
                            anonymousClass2.L$0 = $this$awaitEachGesture;
                            anonymousClass2.L$1 = upOrCancel2;
                            anonymousClass2.J$0 = longPressTimeout2;
                            anonymousClass2.label = 3;
                            if (TapAndDoubleTapGestureKt.consumeUntilUp($this$awaitEachGesture, anonymousClass2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass2.$$this$coroutineScope, null, null, new AnonymousClass5(anonymousClass2.$pressScope, null), 3, null);
                            PointerInputChange pointerInputChange2 = upOrCancel2;
                            $result5 = $result4;
                            upOrCancel3 = pointerInputChange2;
                            if (upOrCancel3 != null) {
                                upOrCancel3.consume();
                                tapOnPosition = anonymousClass2.$onTap;
                                if (tapOnPosition != null) {
                                    tapOnPosition.mo1375onEventk4lQ0M(upOrCancel3.getPosition());
                                }
                                if (anonymousClass2.$onDoubleTap != null) {
                                    anonymousClass2.L$0 = $this$awaitEachGesture;
                                    anonymousClass2.L$1 = null;
                                    anonymousClass2.J$0 = longPressTimeout2;
                                    anonymousClass2.label = 4;
                                    $result6 = TapAndDoubleTapGestureKt.awaitSecondDown($this$awaitEachGesture, upOrCancel3, anonymousClass2);
                                    if ($result6 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $this$awaitEachGesture2 = $this$awaitEachGesture;
                                    $result7 = $result5;
                                    longPressTimeout3 = longPressTimeout2;
                                    anonymousClass3 = anonymousClass2;
                                    secondDown = (PointerInputChange) $result6;
                                    if (secondDown != null) {
                                        BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass6(anonymousClass3.$pressScope, null), 3, null);
                                        BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass7(anonymousClass3.$onPress, anonymousClass3.$pressScope, secondDown, null), 3, null);
                                        try {
                                            anonymousClass3.L$0 = $this$awaitEachGesture2;
                                            anonymousClass3.label = 5;
                                            if ($this$awaitEachGesture2.withTimeout(longPressTimeout3, new AnonymousClass8(anonymousClass3.$$this$coroutineScope, anonymousClass3.$onDoubleTap, anonymousClass3.$pressScope, null), anonymousClass3) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            anonymousClass5 = anonymousClass3;
                                            $result8 = $result7;
                                        } catch (PointerEventTimeoutCancellationException e3) {
                                            anonymousClass4 = anonymousClass3;
                                            $this$awaitEachGesture3 = $this$awaitEachGesture2;
                                            anonymousClass4.L$0 = null;
                                            anonymousClass4.label = 6;
                                            if (TapAndDoubleTapGestureKt.consumeUntilUp($this$awaitEachGesture3, anonymousClass4) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            $result9 = $result7;
                                            BuildersKt__Builders_commonKt.launch$default(anonymousClass4.$$this$coroutineScope, null, null, new AnonymousClass9(anonymousClass4.$pressScope, null), 3, null);
                                        }
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        if (upOrCancel3 != null) {
                            upOrCancel3.consume();
                            tapOnPosition = anonymousClass2.$onTap;
                            if (tapOnPosition != null) {
                                tapOnPosition.mo1375onEventk4lQ0M(upOrCancel3.getPosition());
                            }
                            if (anonymousClass2.$onDoubleTap != null) {
                                anonymousClass2.L$0 = $this$awaitEachGesture;
                                anonymousClass2.L$1 = null;
                                anonymousClass2.J$0 = longPressTimeout2;
                                anonymousClass2.label = 4;
                                $result6 = TapAndDoubleTapGestureKt.awaitSecondDown($this$awaitEachGesture, upOrCancel3, anonymousClass2);
                                if ($result6 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $this$awaitEachGesture2 = $this$awaitEachGesture;
                                $result7 = $result5;
                                longPressTimeout3 = longPressTimeout2;
                                anonymousClass3 = anonymousClass2;
                                secondDown = (PointerInputChange) $result6;
                                if (secondDown != null) {
                                    BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass6(anonymousClass3.$pressScope, null), 3, null);
                                    BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass7(anonymousClass3.$onPress, anonymousClass3.$pressScope, secondDown, null), 3, null);
                                    anonymousClass3.L$0 = $this$awaitEachGesture2;
                                    anonymousClass3.label = 5;
                                    if ($this$awaitEachGesture2.withTimeout(longPressTimeout3, new AnonymousClass8(anonymousClass3.$$this$coroutineScope, anonymousClass3.$onDoubleTap, anonymousClass3.$pressScope, null), anonymousClass3) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    anonymousClass5 = anonymousClass3;
                                    $result8 = $result7;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        $result3 = $result;
                        AwaitPointerEventScope $this$awaitEachGesture5 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure($result3);
                        $result2 = $result3;
                        $this$awaitEachGesture = $this$awaitEachGesture5;
                        anonymousClass1 = this;
                        PointerInputChange down2 = (PointerInputChange) $result3;
                        down2.consume();
                        BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, null, new C45571(anonymousClass1.$pressScope, anonymousClass1.$onPress, down2, null), 3, null);
                        longPressTimeout = $this$awaitEachGesture.getViewConfiguration().getLongPressTimeoutMillis();
                        upOrCancel = null;
                        anonymousClass1.L$0 = $this$awaitEachGesture;
                        anonymousClass1.J$0 = longPressTimeout;
                        anonymousClass1.label = 2;
                        objWithTimeout = $this$awaitEachGesture.withTimeout(longPressTimeout, new AnonymousClass2(null), anonymousClass1);
                        if (objWithTimeout == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        upOrCancel3 = (PointerInputChange) objWithTimeout;
                        if (upOrCancel3 == null) {
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, null, new AnonymousClass3(anonymousClass1.$pressScope, null), 3, null);
                        } else {
                            upOrCancel3.consume();
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, null, new AnonymousClass4(anonymousClass1.$pressScope, null), 3, null);
                        }
                        anonymousClass2 = anonymousClass1;
                        $result5 = $result2;
                        longPressTimeout2 = longPressTimeout;
                        if (upOrCancel3 != null) {
                            upOrCancel3.consume();
                            tapOnPosition = anonymousClass2.$onTap;
                            if (tapOnPosition != null) {
                                tapOnPosition.mo1375onEventk4lQ0M(upOrCancel3.getPosition());
                            }
                            if (anonymousClass2.$onDoubleTap != null) {
                                anonymousClass2.L$0 = $this$awaitEachGesture;
                                anonymousClass2.L$1 = null;
                                anonymousClass2.J$0 = longPressTimeout2;
                                anonymousClass2.label = 4;
                                $result6 = TapAndDoubleTapGestureKt.awaitSecondDown($this$awaitEachGesture, upOrCancel3, anonymousClass2);
                                if ($result6 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $this$awaitEachGesture2 = $this$awaitEachGesture;
                                $result7 = $result5;
                                longPressTimeout3 = longPressTimeout2;
                                anonymousClass3 = anonymousClass2;
                                secondDown = (PointerInputChange) $result6;
                                if (secondDown != null) {
                                    BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass6(anonymousClass3.$pressScope, null), 3, null);
                                    BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass7(anonymousClass3.$onPress, anonymousClass3.$pressScope, secondDown, null), 3, null);
                                    anonymousClass3.L$0 = $this$awaitEachGesture2;
                                    anonymousClass3.label = 5;
                                    if ($this$awaitEachGesture2.withTimeout(longPressTimeout3, new AnonymousClass8(anonymousClass3.$$this$coroutineScope, anonymousClass3.$onDoubleTap, anonymousClass3.$pressScope, null), anonymousClass3) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    anonymousClass5 = anonymousClass3;
                                    $result8 = $result7;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 2:
                        long longPressTimeout4 = this.J$0;
                        $this$awaitEachGesture = (AwaitPointerEventScope) this.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            objWithTimeout = $result;
                            longPressTimeout = longPressTimeout4;
                            anonymousClass1 = this;
                            $result2 = objWithTimeout;
                            upOrCancel = null;
                            upOrCancel3 = (PointerInputChange) objWithTimeout;
                            if (upOrCancel3 == null) {
                                BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, null, new AnonymousClass3(anonymousClass1.$pressScope, null), 3, null);
                            } else {
                                upOrCancel3.consume();
                                BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, null, new AnonymousClass4(anonymousClass1.$pressScope, null), 3, null);
                            }
                            anonymousClass2 = anonymousClass1;
                            $result5 = $result2;
                            longPressTimeout2 = longPressTimeout;
                        } catch (PointerEventTimeoutCancellationException e4) {
                            upOrCancel2 = null;
                            anonymousClass2 = this;
                            $result4 = $result;
                            longPressTimeout2 = longPressTimeout4;
                            anonymousClass2.L$0 = $this$awaitEachGesture;
                            anonymousClass2.L$1 = upOrCancel2;
                            anonymousClass2.J$0 = longPressTimeout2;
                            anonymousClass2.label = 3;
                            if (TapAndDoubleTapGestureKt.consumeUntilUp($this$awaitEachGesture, anonymousClass2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass2.$$this$coroutineScope, null, null, new AnonymousClass5(anonymousClass2.$pressScope, null), 3, null);
                            PointerInputChange pointerInputChange3 = upOrCancel2;
                            $result5 = $result4;
                            upOrCancel3 = pointerInputChange3;
                            if (upOrCancel3 != null) {
                                upOrCancel3.consume();
                                tapOnPosition = anonymousClass2.$onTap;
                                if (tapOnPosition != null) {
                                    tapOnPosition.mo1375onEventk4lQ0M(upOrCancel3.getPosition());
                                }
                                if (anonymousClass2.$onDoubleTap != null) {
                                    anonymousClass2.L$0 = $this$awaitEachGesture;
                                    anonymousClass2.L$1 = null;
                                    anonymousClass2.J$0 = longPressTimeout2;
                                    anonymousClass2.label = 4;
                                    $result6 = TapAndDoubleTapGestureKt.awaitSecondDown($this$awaitEachGesture, upOrCancel3, anonymousClass2);
                                    if ($result6 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $this$awaitEachGesture2 = $this$awaitEachGesture;
                                    $result7 = $result5;
                                    longPressTimeout3 = longPressTimeout2;
                                    anonymousClass3 = anonymousClass2;
                                    secondDown = (PointerInputChange) $result6;
                                    if (secondDown != null) {
                                        BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass6(anonymousClass3.$pressScope, null), 3, null);
                                        BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass7(anonymousClass3.$onPress, anonymousClass3.$pressScope, secondDown, null), 3, null);
                                        anonymousClass3.L$0 = $this$awaitEachGesture2;
                                        anonymousClass3.label = 5;
                                        if ($this$awaitEachGesture2.withTimeout(longPressTimeout3, new AnonymousClass8(anonymousClass3.$$this$coroutineScope, anonymousClass3.$onDoubleTap, anonymousClass3.$pressScope, null), anonymousClass3) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        anonymousClass5 = anonymousClass3;
                                        $result8 = $result7;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        if (upOrCancel3 != null) {
                            upOrCancel3.consume();
                            tapOnPosition = anonymousClass2.$onTap;
                            if (tapOnPosition != null) {
                                tapOnPosition.mo1375onEventk4lQ0M(upOrCancel3.getPosition());
                            }
                            if (anonymousClass2.$onDoubleTap != null) {
                                anonymousClass2.L$0 = $this$awaitEachGesture;
                                anonymousClass2.L$1 = null;
                                anonymousClass2.J$0 = longPressTimeout2;
                                anonymousClass2.label = 4;
                                $result6 = TapAndDoubleTapGestureKt.awaitSecondDown($this$awaitEachGesture, upOrCancel3, anonymousClass2);
                                if ($result6 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $this$awaitEachGesture2 = $this$awaitEachGesture;
                                $result7 = $result5;
                                longPressTimeout3 = longPressTimeout2;
                                anonymousClass3 = anonymousClass2;
                                secondDown = (PointerInputChange) $result6;
                                if (secondDown != null) {
                                    BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass6(anonymousClass3.$pressScope, null), 3, null);
                                    BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass7(anonymousClass3.$onPress, anonymousClass3.$pressScope, secondDown, null), 3, null);
                                    anonymousClass3.L$0 = $this$awaitEachGesture2;
                                    anonymousClass3.label = 5;
                                    if ($this$awaitEachGesture2.withTimeout(longPressTimeout3, new AnonymousClass8(anonymousClass3.$$this$coroutineScope, anonymousClass3.$onDoubleTap, anonymousClass3.$pressScope, null), anonymousClass3) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    anonymousClass5 = anonymousClass3;
                                    $result8 = $result7;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 3:
                        anonymousClass2 = this;
                        $result4 = $result;
                        longPressTimeout2 = anonymousClass2.J$0;
                        upOrCancel2 = (PointerInputChange) anonymousClass2.L$1;
                        $this$awaitEachGesture = (AwaitPointerEventScope) anonymousClass2.L$0;
                        ResultKt.throwOnFailure($result4);
                        BuildersKt__Builders_commonKt.launch$default(anonymousClass2.$$this$coroutineScope, null, null, new AnonymousClass5(anonymousClass2.$pressScope, null), 3, null);
                        PointerInputChange pointerInputChange4 = upOrCancel2;
                        $result5 = $result4;
                        upOrCancel3 = pointerInputChange4;
                        if (upOrCancel3 != null) {
                            upOrCancel3.consume();
                            tapOnPosition = anonymousClass2.$onTap;
                            if (tapOnPosition != null) {
                                tapOnPosition.mo1375onEventk4lQ0M(upOrCancel3.getPosition());
                            }
                            if (anonymousClass2.$onDoubleTap != null) {
                                anonymousClass2.L$0 = $this$awaitEachGesture;
                                anonymousClass2.L$1 = null;
                                anonymousClass2.J$0 = longPressTimeout2;
                                anonymousClass2.label = 4;
                                $result6 = TapAndDoubleTapGestureKt.awaitSecondDown($this$awaitEachGesture, upOrCancel3, anonymousClass2);
                                if ($result6 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $this$awaitEachGesture2 = $this$awaitEachGesture;
                                $result7 = $result5;
                                longPressTimeout3 = longPressTimeout2;
                                anonymousClass3 = anonymousClass2;
                                secondDown = (PointerInputChange) $result6;
                                if (secondDown != null) {
                                    BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass6(anonymousClass3.$pressScope, null), 3, null);
                                    BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass7(anonymousClass3.$onPress, anonymousClass3.$pressScope, secondDown, null), 3, null);
                                    anonymousClass3.L$0 = $this$awaitEachGesture2;
                                    anonymousClass3.label = 5;
                                    if ($this$awaitEachGesture2.withTimeout(longPressTimeout3, new AnonymousClass8(anonymousClass3.$$this$coroutineScope, anonymousClass3.$onDoubleTap, anonymousClass3.$pressScope, null), anonymousClass3) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    anonymousClass5 = anonymousClass3;
                                    $result8 = $result7;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 4:
                        $result6 = $result;
                        long longPressTimeout5 = this.J$0;
                        AwaitPointerEventScope $this$awaitEachGesture6 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure($result6);
                        $result7 = $result6;
                        $this$awaitEachGesture2 = $this$awaitEachGesture6;
                        longPressTimeout3 = longPressTimeout5;
                        anonymousClass3 = this;
                        secondDown = (PointerInputChange) $result6;
                        if (secondDown != null) {
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass6(anonymousClass3.$pressScope, null), 3, null);
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass7(anonymousClass3.$onPress, anonymousClass3.$pressScope, secondDown, null), 3, null);
                            anonymousClass3.L$0 = $this$awaitEachGesture2;
                            anonymousClass3.label = 5;
                            if ($this$awaitEachGesture2.withTimeout(longPressTimeout3, new AnonymousClass8(anonymousClass3.$$this$coroutineScope, anonymousClass3.$onDoubleTap, anonymousClass3.$pressScope, null), anonymousClass3) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            anonymousClass5 = anonymousClass3;
                            $result8 = $result7;
                        }
                        return Unit.INSTANCE;
                    case 5:
                        anonymousClass5 = this;
                        $result8 = $result;
                        $this$awaitEachGesture3 = (AwaitPointerEventScope) anonymousClass5.L$0;
                        try {
                            ResultKt.throwOnFailure($result8);
                        } catch (PointerEventTimeoutCancellationException e5) {
                            anonymousClass4 = anonymousClass5;
                            $result7 = $result8;
                            anonymousClass4.L$0 = null;
                            anonymousClass4.label = 6;
                            if (TapAndDoubleTapGestureKt.consumeUntilUp($this$awaitEachGesture3, anonymousClass4) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result9 = $result7;
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass4.$$this$coroutineScope, null, null, new AnonymousClass9(anonymousClass4.$pressScope, null), 3, null);
                        }
                        return Unit.INSTANCE;
                    case 6:
                        anonymousClass4 = this;
                        $result9 = $result;
                        ResultKt.throwOnFailure($result9);
                        BuildersKt__Builders_commonKt.launch$default(anonymousClass4.$$this$coroutineScope, null, null, new AnonymousClass9(anonymousClass4.$pressScope, null), 3, null);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: TapAndDoubleTapGesture.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$1", m210f = "TapAndDoubleTapGesture.kt", m211i = {}, m212l = {55, 56}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class C45571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PointerInputChange $down;
                final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C45571(PressGestureScopeImpl pressGestureScopeImpl, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PointerInputChange pointerInputChange, Continuation<? super C45571> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                    this.$onPress = function3;
                    this.$down = pointerInputChange;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C45571(this.$pressScope, this.$onPress, this.$down, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C45571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code duplicated, block: B:13:0x0046 A[RETURN] */
                /* JADX WARN: Code duplicated, block: B:14:0x0047  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    C45571 c45571;
                    Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3;
                    PressGestureScopeImpl pressGestureScopeImpl;
                    Offset offsetM4038boximpl;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            c45571 = this;
                            c45571.label = 1;
                            if (c45571.$pressScope.reset(c45571) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function3 = c45571.$onPress;
                            pressGestureScopeImpl = c45571.$pressScope;
                            offsetM4038boximpl = Offset.m4038boximpl(c45571.$down.getPosition());
                            c45571.label = 2;
                            if (function3.invoke(pressGestureScopeImpl, offsetM4038boximpl, c45571) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        case 1:
                            c45571 = this;
                            ResultKt.throwOnFailure($result);
                            function3 = c45571.$onPress;
                            pressGestureScopeImpl = c45571.$pressScope;
                            offsetM4038boximpl = Offset.m4038boximpl(c45571.$down.getPosition());
                            c45571.label = 2;
                            if (function3.invoke(pressGestureScopeImpl, offsetM4038boximpl, c45571) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        case 2:
                            ResultKt.throwOnFailure($result);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: TapAndDoubleTapGesture.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$2", m210f = "TapAndDoubleTapGesture.kt", m211i = {}, m212l = {64}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
                private /* synthetic */ Object L$0;
                int label;

                AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
                    return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            AwaitPointerEventScope $this$withTimeout = (AwaitPointerEventScope) this.L$0;
                            this.label = 1;
                            Object objWaitForUpOrCancellation$default = TapGestureDetectorKt.waitForUpOrCancellation$default($this$withTimeout, null, this, 1, null);
                            return objWaitForUpOrCancellation$default == coroutine_suspended ? coroutine_suspended : objWaitForUpOrCancellation$default;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            return $result;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: TapAndDoubleTapGesture.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$3", m210f = "TapAndDoubleTapGesture.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass3(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass3(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            this.$pressScope.cancel();
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$4, reason: invalid class name */
            /* JADX INFO: compiled from: TapAndDoubleTapGesture.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$4", m210f = "TapAndDoubleTapGesture.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass4(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass4> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass4(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            this.$pressScope.release();
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$5, reason: invalid class name */
            /* JADX INFO: compiled from: TapAndDoubleTapGesture.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$5", m210f = "TapAndDoubleTapGesture.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass5(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass5> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass5(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            this.$pressScope.release();
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$6, reason: invalid class name */
            /* JADX INFO: compiled from: TapAndDoubleTapGesture.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$6", m210f = "TapAndDoubleTapGesture.kt", m211i = {}, m212l = {94}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass6(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass6> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass6(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            this.label = 1;
                            if (this.$pressScope.reset(this) == coroutine_suspended) {
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

            /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$7, reason: invalid class name */
            /* JADX INFO: compiled from: TapAndDoubleTapGesture.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$7", m210f = "TapAndDoubleTapGesture.kt", m211i = {}, m212l = {TarConstants.SPARSELEN_GNU}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                final /* synthetic */ PointerInputChange $secondDown;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass7(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super AnonymousClass7> continuation) {
                    super(2, continuation);
                    this.$onPress = function3;
                    this.$pressScope = pressGestureScopeImpl;
                    this.$secondDown = pointerInputChange;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass7(this.$onPress, this.$pressScope, this.$secondDown, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                            PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                            Offset offsetM4038boximpl = Offset.m4038boximpl(this.$secondDown.getPosition());
                            this.label = 1;
                            if (function3.invoke(pressGestureScopeImpl, offsetM4038boximpl, this) == coroutine_suspended) {
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

            /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$8, reason: invalid class name */
            /* JADX INFO: compiled from: TapAndDoubleTapGesture.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$8", m210f = "TapAndDoubleTapGesture.kt", m211i = {}, m212l = {100}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class AnonymousClass8 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Object>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ TapOnPosition $onDoubleTap;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass8(CoroutineScope coroutineScope, TapOnPosition tapOnPosition, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass8> continuation) {
                    super(2, continuation);
                    this.$$this$coroutineScope = coroutineScope;
                    this.$onDoubleTap = tapOnPosition;
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass8 anonymousClass8 = new AnonymousClass8(this.$$this$coroutineScope, this.$onDoubleTap, this.$pressScope, continuation);
                    anonymousClass8.L$0 = obj;
                    return anonymousClass8;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(AwaitPointerEventScope awaitPointerEventScope, Continuation<Object> continuation) {
                    return ((AnonymousClass8) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Object> continuation) {
                    return invoke2(awaitPointerEventScope, (Continuation<Object>) continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    AnonymousClass8 anonymousClass8;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            anonymousClass8 = this;
                            AwaitPointerEventScope $this$withTimeout = (AwaitPointerEventScope) anonymousClass8.L$0;
                            anonymousClass8.label = 1;
                            Object objWaitForUpOrCancellation$default = TapGestureDetectorKt.waitForUpOrCancellation$default($this$withTimeout, null, anonymousClass8, 1, null);
                            if (objWaitForUpOrCancellation$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result = objWaitForUpOrCancellation$default;
                            break;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            anonymousClass8 = this;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    PointerInputChange secondUp = (PointerInputChange) $result;
                    if (secondUp == null) {
                        return BuildersKt__Builders_commonKt.launch$default(anonymousClass8.$$this$coroutineScope, null, null, new AnonymousClass2(anonymousClass8.$pressScope, null), 3, null);
                    }
                    secondUp.consume();
                    BuildersKt__Builders_commonKt.launch$default(anonymousClass8.$$this$coroutineScope, null, null, new C45581(anonymousClass8.$pressScope, null), 3, null);
                    anonymousClass8.$onDoubleTap.mo1375onEventk4lQ0M(secondUp.getPosition());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$8$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: TapAndDoubleTapGesture.kt */
                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$8$1", m210f = "TapAndDoubleTapGesture.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                static final class C45581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ PressGestureScopeImpl $pressScope;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C45581(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C45581> continuation) {
                        super(2, continuation);
                        this.$pressScope = pressGestureScopeImpl;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C45581(this.$pressScope, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C45581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure(obj);
                                this.$pressScope.release();
                                return Unit.INSTANCE;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }

                /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$8$2, reason: invalid class name */
                /* JADX INFO: compiled from: TapAndDoubleTapGesture.kt */
                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$8$2", m210f = "TapAndDoubleTapGesture.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ PressGestureScopeImpl $pressScope;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.$pressScope = pressGestureScopeImpl;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass2(this.$pressScope, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure(obj);
                                this.$pressScope.cancel();
                                return Unit.INSTANCE;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$9, reason: invalid class name */
            /* JADX INFO: compiled from: TapAndDoubleTapGesture.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$9", m210f = "TapAndDoubleTapGesture.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass9(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass9> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass9(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass9) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            this.$pressScope.release();
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
        }
    }

    public static final Object detectTapAndDoubleTap(PointerInputScope $this$detectTapAndDoubleTap, TapOnPosition onTap, TapOnPosition onDoubleTap, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C08412($this$detectTapAndDoubleTap, onTap, onDoubleTap, function3, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$awaitSecondDown$2 */
    /* JADX INFO: compiled from: TapAndDoubleTapGesture.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$awaitSecondDown$2", m210f = "TapAndDoubleTapGesture.kt", m211i = {0, 0}, m212l = {137}, m213m = "invokeSuspend", m214n = {"$this$withTimeoutOrNull", "minUptime"}, m215s = {"L$0", "J$0"})
    static final class C08392 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
        final /* synthetic */ PointerInputChange $firstUp;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08392(PointerInputChange pointerInputChange, Continuation<? super C08392> continuation) {
            super(2, continuation);
            this.$firstUp = pointerInputChange;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08392 c08392 = new C08392(this.$firstUp, continuation);
            c08392.L$0 = obj;
            return c08392;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
            return ((C08392) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0050 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:11:0x0051  */
        /* JADX WARN: Code duplicated, block: B:14:0x0061 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:15:0x0062  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0051 -> B:12:0x0057). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.label
                switch(r1) {
                    case 0: goto L22;
                    case 1: goto L12;
                    default: goto L9;
                }
            L9:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L12:
                r1 = r12
                long r2 = r1.J$0
                java.lang.Object r4 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.p001ui.input.pointer.AwaitPointerEventScope) r4
                kotlin.ResultKt.throwOnFailure(r13)
                r10 = r4
                r3 = r2
                r2 = r1
                r1 = r0
                r0 = r13
                goto L57
            L22:
                kotlin.ResultKt.throwOnFailure(r13)
                r1 = r12
                java.lang.Object r2 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.p001ui.input.pointer.AwaitPointerEventScope) r2
                androidx.compose.ui.input.pointer.PointerInputChange r3 = r1.$firstUp
                long r3 = r3.getUptimeMillis()
                androidx.compose.ui.platform.ViewConfiguration r5 = r2.getViewConfiguration()
                long r5 = r5.getDoubleTapMinTimeMillis()
                long r3 = r3 + r5
                r10 = r2
                r2 = r3
            L3b:
                r7 = r1
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r1.L$0 = r10
                r1.J$0 = r2
                r4 = 1
                r1.label = r4
                r5 = 0
                r6 = 0
                r8 = 3
                r9 = 0
                r4 = r10
                java.lang.Object r4 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r4, r5, r6, r7, r8, r9)
                if (r4 != r0) goto L51
                return r0
            L51:
                r11 = r0
                r0 = r13
                r13 = r4
                r3 = r2
                r2 = r1
                r1 = r11
            L57:
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.p001ui.input.pointer.PointerInputChange) r13
                long r5 = r13.getUptimeMillis()
                int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r7 < 0) goto L62
                return r13
            L62:
                r13 = r0
                r0 = r1
                r1 = r2
                r2 = r3
                goto L3b
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt.C08392.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object awaitSecondDown(AwaitPointerEventScope $this$awaitSecondDown, PointerInputChange firstUp, Continuation<? super PointerInputChange> continuation) {
        return $this$awaitSecondDown.withTimeoutOrNull($this$awaitSecondDown.getViewConfiguration().getDoubleTapTimeoutMillis(), new C08392(firstUp, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x007b  */
    /* JADX WARN: Code duplicated, block: B:26:0x008d A[LOOP:1: B:22:0x0079->B:26:0x008d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x008b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0048 -> B:18:0x004c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object consumeUntilUp(androidx.compose.p001ui.input.pointer.AwaitPointerEventScope r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            boolean r0 = r15 instanceof androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt.C08401
            if (r0 == 0) goto L14
            r0 = r15
            androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$consumeUntilUp$1 r0 = (androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt.C08401) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L19
        L14:
            androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$consumeUntilUp$1 r0 = new androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt$consumeUntilUp$1
            r0.<init>(r15)
        L19:
            r15 = r0
            java.lang.Object r0 = r15.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r15.label
            r3 = 1
            switch(r2) {
                case 0: goto L39;
                case 1: goto L2f;
                default: goto L26;
            }
        L26:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L2f:
            java.lang.Object r14 = r15.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.p001ui.input.pointer.AwaitPointerEventScope) r14
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r1
            r1 = r0
            goto L4c
        L39:
            kotlin.ResultKt.throwOnFailure(r0)
        L3c:
            r15.L$0 = r14
            r15.label = r3
            r2 = 0
            java.lang.Object r2 = androidx.compose.p001ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r14, r2, r15, r3, r2)
            if (r2 != r1) goto L48
            return r1
        L48:
            r13 = r1
            r1 = r0
            r0 = r2
            r2 = r13
        L4c:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.p001ui.input.pointer.PointerEvent) r0
            java.util.List r4 = r0.getChanges()
            r5 = 0
            r6 = 0
            int r7 = r4.size()
        L59:
            if (r6 >= r7) goto L6a
            java.lang.Object r8 = r4.get(r6)
            r9 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.p001ui.input.pointer.PointerInputChange) r9
            r10 = 0
            r9.consume()
            int r6 = r6 + 1
            goto L59
        L6a:
            java.util.List r0 = r0.getChanges()
            r4 = 0
            r5 = 0
            r6 = 0
            int r7 = r0.size()
        L79:
            if (r6 >= r7) goto L91
            java.lang.Object r8 = r0.get(r6)
            r9 = r8
            r10 = 0
            r11 = r9
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.p001ui.input.pointer.PointerInputChange) r11
            r12 = 0
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L8d
            r0 = 1
            goto L93
        L8d:
            int r6 = r6 + 1
            goto L79
        L91:
            r0 = 0
        L93:
            if (r0 != 0) goto L98
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L98:
            r0 = r1
            r1 = r2
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TapAndDoubleTapGestureKt.consumeUntilUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
