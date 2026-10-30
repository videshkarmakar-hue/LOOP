package androidx.compose.foundation.gestures;

import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p001ui.input.pointer.PointerEventPass;
import androidx.compose.p001ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.p001ui.input.pointer.PointerInputChange;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.time.DurationKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: compiled from: TapGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0087@¢\u0006\u0002\u0010\u000e\u001a&\u0010\t\u001a\u00020\n*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011\u001a\u001c\u0010\u0012\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010\u0014\u001a\u0012\u0010\u0015\u001a\u00020\u0005*\u00020\u000bH\u0082@¢\u0006\u0002\u0010\u0016\u001a[\u0010\u0017\u001a\u00020\u0005*\u00020\u00182/\b\u0002\u0010\u0019\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001bH\u0080@¢\u0006\u0002\u0010\u001c\u001a\u008b\u0001\u0010\u001d\u001a\u00020\u0005*\u00020\u00182\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2/\b\u0002\u0010\u0019\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001bH\u0086@¢\u0006\u0002\u0010 \u001a\u0014\u0010!\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0087@¢\u0006\u0002\u0010\u0016\u001a\u001e\u0010!\u001a\u0004\u0018\u00010\n*\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\"\"7\u0010\u0000\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006#"}, m195d2 = {"NoPressGesture", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "awaitFirstDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "requireUnconsumed", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLandroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSecondDown", "firstUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeUntilUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapAndPress", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onPress", "onTap", "Lkotlin/Function1;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapGestures", "onDoubleTap", "onLongPress", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForUpOrCancellation", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TapGestureDetectorKt {
    private static final Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> NoPressGesture = new TapGestureDetectorKt$NoPressGesture$1(null);

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", m210f = "TapGestureDetector.kt", m211i = {0, 0, 0}, m212l = {279}, m213m = "awaitFirstDown", m214n = {"$this$awaitFirstDown", "pass", "requireUnconsumed"}, m215s = {"L$0", "L$1", "Z$0"})
    static final class C04122 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C04122(Continuation<? super C04122> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.awaitFirstDown(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", m210f = "TapGestureDetector.kt", m211i = {0}, m212l = {195}, m213m = "consumeUntilUp", m214n = {"$this$consumeUntilUp"}, m215s = {"L$0"})
    static final class C04141 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04141(Continuation<? super C04141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.consumeUntilUp(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", m210f = "TapGestureDetector.kt", m211i = {0, 0, 1, 1}, m212l = {HttpStatusCodesKt.HTTP_USE_PROXY, 320}, m213m = "waitForUpOrCancellation", m214n = {"$this$waitForUpOrCancellation", "pass", "$this$waitForUpOrCancellation", "pass"}, m215s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C04172 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C04172(Continuation<? super C04172> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.waitForUpOrCancellation(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2", m210f = "TapGestureDetector.kt", m211i = {}, m212l = {99}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C04162 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
        final /* synthetic */ Function1<Offset, Unit> $onLongPress;
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ Function1<Offset, Unit> $onTap;
        final /* synthetic */ PointerInputScope $this_detectTapGestures;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C04162(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function2, Function1<? super Offset, Unit> function4, Continuation<? super C04162> continuation) {
            super(2, continuation);
            this.$this_detectTapGestures = pointerInputScope;
            this.$onPress = function3;
            this.$onLongPress = function1;
            this.$onDoubleTap = function2;
            this.$onTap = function4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04162 c04162 = new C04162(this.$this_detectTapGestures, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, continuation);
            c04162.L$0 = obj;
            return c04162;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04162) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    PressGestureScopeImpl pressScope = new PressGestureScopeImpl(this.$this_detectTapGestures);
                    this.label = 1;
                    if (ForEachGestureKt.awaitEachGesture(this.$this_detectTapGestures, new AnonymousClass1($this$coroutineScope, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, pressScope, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TapGestureDetector.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1", m210f = "TapGestureDetector.kt", m211i = {0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}, m212l = {100, 114, 129, 141, 156, 178}, m213m = "invokeSuspend", m214n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down", "upOrCancel", "longPressTimeout", "$this$awaitEachGesture", "upOrCancel", "longPressTimeout", "$this$awaitEachGesture", "upOrCancel", "longPressTimeout", "$this$awaitEachGesture", "upOrCancel", "secondDown"}, m215s = {"L$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2"})
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
            final /* synthetic */ Function1<Offset, Unit> $onLongPress;
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ Function1<Offset, Unit> $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            long J$0;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(CoroutineScope coroutineScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function2, Function1<? super Offset, Unit> function4, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.$onPress = function3;
                this.$onLongPress = function1;
                this.$onDoubleTap = function2;
                this.$onTap = function4;
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, this.$pressScope, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:26:0x00e6  */
            /* JADX WARN: Code duplicated, block: B:29:0x0100  */
            /* JADX WARN: Code duplicated, block: B:30:0x010a  */
            /* JADX WARN: Code duplicated, block: B:34:0x0134 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:35:0x0135  */
            /* JADX WARN: Code duplicated, block: B:38:0x0141 A[Catch: PointerEventTimeoutCancellationException -> 0x0176, TryCatch #2 {PointerEventTimeoutCancellationException -> 0x0176, blocks: (B:36:0x013b, B:38:0x0141, B:39:0x0157), top: B:102:0x013b }] */
            /* JADX WARN: Code duplicated, block: B:39:0x0157 A[Catch: PointerEventTimeoutCancellationException -> 0x0176, TRY_LEAVE, TryCatch #2 {PointerEventTimeoutCancellationException -> 0x0176, blocks: (B:36:0x013b, B:38:0x0141, B:39:0x0157), top: B:102:0x013b }] */
            /* JADX WARN: Code duplicated, block: B:47:0x018b  */
            /* JADX WARN: Code duplicated, block: B:50:0x01ad A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:54:0x01cc  */
            /* JADX WARN: Code duplicated, block: B:56:0x01d0  */
            /* JADX WARN: Code duplicated, block: B:58:0x01d4  */
            /* JADX WARN: Code duplicated, block: B:60:0x01e7  */
            /* JADX WARN: Code duplicated, block: B:62:0x0201 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:63:0x0202  */
            /* JADX WARN: Code duplicated, block: B:66:0x020f  */
            /* JADX WARN: Code duplicated, block: B:68:0x0213  */
            /* JADX WARN: Code duplicated, block: B:70:0x0227  */
            /* JADX WARN: Code duplicated, block: B:72:0x0249  */
            /* JADX WARN: Code duplicated, block: B:78:0x0293 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:79:0x0294  */
            /* JADX WARN: Code duplicated, block: B:87:0x02aa  */
            /* JADX WARN: Code duplicated, block: B:90:0x02be  */
            /* JADX WARN: Code duplicated, block: B:93:0x02dd A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:94:0x02de  */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                AwaitPointerEventScope awaitPointerEventScope;
                AnonymousClass1 anonymousClass1;
                Object obj2;
                Object obj3;
                PointerInputChange pointerInputChange;
                long longPressTimeoutMillis;
                Ref.ObjectRef objectRef;
                AnonymousClass1 anonymousClass2;
                Ref.ObjectRef objectRef2;
                Object obj4;
                long j;
                AwaitPointerEventScope awaitPointerEventScope2;
                Object objWithTimeout;
                AwaitPointerEventScope awaitPointerEventScope3;
                PointerInputChange pointerInputChange2;
                Ref.ObjectRef objectRef3;
                AnonymousClass1 anonymousClass3;
                T t;
                Ref.ObjectRef objectRef4;
                Function1<Offset, Unit> function1;
                Object obj5;
                Object obj6;
                Object objAwaitSecondDown;
                Object obj7;
                Ref.ObjectRef objectRef5;
                AwaitPointerEventScope awaitPointerEventScope4;
                AnonymousClass1 anonymousClass4;
                Object obj8;
                long j2;
                Function1<Offset, Unit> function2;
                Object obj9;
                PointerInputChange pointerInputChange3;
                AwaitPointerEventScope awaitPointerEventScope5;
                Ref.ObjectRef objectRef6;
                PointerInputChange pointerInputChange4;
                AnonymousClass1 anonymousClass5;
                Ref.ObjectRef objectRef7;
                Object obj10;
                Function1<Offset, Unit> function3;
                Object obj11;
                Function1<Offset, Unit> function4;
                Function1<Offset, Unit> function5;
                Object obj12;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        AwaitPointerEventScope awaitPointerEventScope6 = (AwaitPointerEventScope) this.L$0;
                        this.L$0 = awaitPointerEventScope6;
                        this.label = 1;
                        Object objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope6, false, null, this, 3, null);
                        if (objAwaitFirstDown$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        awaitPointerEventScope = awaitPointerEventScope6;
                        anonymousClass1 = this;
                        obj2 = obj;
                        obj3 = objAwaitFirstDown$default;
                        pointerInputChange = (PointerInputChange) obj3;
                        pointerInputChange.consume();
                        BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, null, new C45481(anonymousClass1.$pressScope, null), 3, null);
                        if (anonymousClass1.$onPress != TapGestureDetectorKt.NoPressGesture) {
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, null, new AnonymousClass2(anonymousClass1.$onPress, anonymousClass1.$pressScope, pointerInputChange, null), 3, null);
                        }
                        if (anonymousClass1.$onLongPress != null) {
                            longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
                        } else {
                            longPressTimeoutMillis = DurationKt.MAX_MILLIS;
                        }
                        objectRef = new Ref.ObjectRef();
                        try {
                            anonymousClass1.L$0 = awaitPointerEventScope;
                            anonymousClass1.L$1 = pointerInputChange;
                            anonymousClass1.L$2 = objectRef;
                            anonymousClass1.L$3 = objectRef;
                            anonymousClass1.J$0 = longPressTimeoutMillis;
                            anonymousClass1.label = 2;
                            objWithTimeout = awaitPointerEventScope.withTimeout(longPressTimeoutMillis, new AnonymousClass3(null), anonymousClass1);
                            if (objWithTimeout == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            awaitPointerEventScope3 = awaitPointerEventScope;
                            pointerInputChange2 = pointerInputChange;
                            objectRef3 = objectRef;
                            anonymousClass3 = anonymousClass1;
                            t = objWithTimeout;
                            objectRef4 = objectRef3;
                            obj5 = obj2;
                            try {
                                objectRef4.element = t;
                                if (objectRef3.element == 0) {
                                    BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass4(anonymousClass3.$pressScope, null), 3, null);
                                } else {
                                    ((PointerInputChange) objectRef3.element).consume();
                                    BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass5(anonymousClass3.$pressScope, null), 3, null);
                                }
                                obj6 = obj5;
                                j = longPressTimeoutMillis;
                            } catch (PointerEventTimeoutCancellationException e) {
                                anonymousClass2 = anonymousClass3;
                                obj4 = obj5;
                                j = longPressTimeoutMillis;
                                objectRef2 = objectRef3;
                                pointerInputChange = pointerInputChange2;
                                awaitPointerEventScope2 = awaitPointerEventScope3;
                                function1 = anonymousClass2.$onLongPress;
                                if (function1 != null) {
                                    function1.invoke(Offset.m4038boximpl(pointerInputChange.getPosition()));
                                }
                                anonymousClass2.L$0 = awaitPointerEventScope2;
                                anonymousClass2.L$1 = objectRef2;
                                anonymousClass2.L$2 = null;
                                anonymousClass2.L$3 = null;
                                anonymousClass2.J$0 = j;
                                anonymousClass2.label = 3;
                                obj9 = obj4;
                                if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope2, anonymousClass2) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                BuildersKt__Builders_commonKt.launch$default(anonymousClass2.$$this$coroutineScope, null, null, new AnonymousClass6(anonymousClass2.$pressScope, null), 3, null);
                                objectRef3 = objectRef2;
                                awaitPointerEventScope3 = awaitPointerEventScope2;
                                Object obj13 = obj9;
                                anonymousClass3 = anonymousClass2;
                                obj6 = obj13;
                            }
                            if (objectRef3.element != 0) {
                                if (anonymousClass3.$onDoubleTap == null) {
                                    function2 = anonymousClass3.$onTap;
                                    if (function2 != null) {
                                        function2.invoke(Offset.m4038boximpl(((PointerInputChange) objectRef3.element).getPosition()));
                                    }
                                } else {
                                    anonymousClass3.L$0 = awaitPointerEventScope3;
                                    anonymousClass3.L$1 = objectRef3;
                                    anonymousClass3.L$2 = null;
                                    anonymousClass3.L$3 = null;
                                    anonymousClass3.J$0 = j;
                                    anonymousClass3.label = 4;
                                    objAwaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope3, (PointerInputChange) objectRef3.element, anonymousClass3);
                                    if (objAwaitSecondDown == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj7 = obj6;
                                    objectRef5 = objectRef3;
                                    awaitPointerEventScope4 = awaitPointerEventScope3;
                                    long j3 = j;
                                    anonymousClass4 = anonymousClass3;
                                    obj8 = objAwaitSecondDown;
                                    j2 = j3;
                                    pointerInputChange3 = (PointerInputChange) obj8;
                                    if (pointerInputChange3 == null) {
                                        function3 = anonymousClass4.$onTap;
                                        if (function3 != null) {
                                            function3.invoke(Offset.m4038boximpl(((PointerInputChange) objectRef5.element).getPosition()));
                                        }
                                    } else {
                                        BuildersKt__Builders_commonKt.launch$default(anonymousClass4.$$this$coroutineScope, null, null, new AnonymousClass7(anonymousClass4.$pressScope, null), 3, null);
                                        if (anonymousClass4.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                            BuildersKt__Builders_commonKt.launch$default(anonymousClass4.$$this$coroutineScope, null, null, new AnonymousClass8(anonymousClass4.$onPress, anonymousClass4.$pressScope, pointerInputChange3, null), 3, null);
                                        }
                                        try {
                                            awaitPointerEventScope5 = awaitPointerEventScope4;
                                            objectRef7 = objectRef5;
                                            try {
                                                anonymousClass4.L$0 = awaitPointerEventScope5;
                                                anonymousClass4.L$1 = objectRef7;
                                                anonymousClass4.L$2 = pointerInputChange3;
                                                anonymousClass4.label = 5;
                                                if (awaitPointerEventScope5.withTimeout(j2, new AnonymousClass9(anonymousClass4.$$this$coroutineScope, anonymousClass4.$onDoubleTap, anonymousClass4.$onTap, objectRef5, anonymousClass4.$pressScope, null), anonymousClass4) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                obj10 = obj7;
                                            } catch (PointerEventTimeoutCancellationException e2) {
                                                objectRef6 = objectRef7;
                                                pointerInputChange4 = pointerInputChange3;
                                                anonymousClass5 = anonymousClass4;
                                                obj11 = obj7;
                                                function4 = anonymousClass5.$onTap;
                                                if (function4 != null) {
                                                    function4.invoke(Offset.m4038boximpl(((PointerInputChange) objectRef6.element).getPosition()));
                                                }
                                                function5 = anonymousClass5.$onLongPress;
                                                if (function5 != null) {
                                                    function5.invoke(Offset.m4038boximpl(pointerInputChange4.getPosition()));
                                                }
                                                anonymousClass5.L$0 = null;
                                                anonymousClass5.L$1 = null;
                                                anonymousClass5.L$2 = null;
                                                anonymousClass5.label = 6;
                                                if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope5, anonymousClass5) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                obj12 = obj11;
                                                BuildersKt__Builders_commonKt.launch$default(anonymousClass5.$$this$coroutineScope, null, null, new AnonymousClass10(anonymousClass5.$pressScope, null), 3, null);
                                            }
                                        } catch (PointerEventTimeoutCancellationException e3) {
                                            awaitPointerEventScope5 = awaitPointerEventScope4;
                                            objectRef6 = objectRef5;
                                            pointerInputChange4 = pointerInputChange3;
                                            anonymousClass5 = anonymousClass4;
                                            obj11 = obj7;
                                        }
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        } catch (PointerEventTimeoutCancellationException e4) {
                            anonymousClass2 = anonymousClass1;
                            long j4 = longPressTimeoutMillis;
                            objectRef2 = objectRef;
                            obj4 = obj2;
                            j = j4;
                            awaitPointerEventScope2 = awaitPointerEventScope;
                            function1 = anonymousClass2.$onLongPress;
                            if (function1 != null) {
                                function1.invoke(Offset.m4038boximpl(pointerInputChange.getPosition()));
                            }
                            anonymousClass2.L$0 = awaitPointerEventScope2;
                            anonymousClass2.L$1 = objectRef2;
                            anonymousClass2.L$2 = null;
                            anonymousClass2.L$3 = null;
                            anonymousClass2.J$0 = j;
                            anonymousClass2.label = 3;
                            obj9 = obj4;
                            if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope2, anonymousClass2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass2.$$this$coroutineScope, null, null, new AnonymousClass6(anonymousClass2.$pressScope, null), 3, null);
                            objectRef3 = objectRef2;
                            awaitPointerEventScope3 = awaitPointerEventScope2;
                            Object obj14 = obj9;
                            anonymousClass3 = anonymousClass2;
                            obj6 = obj14;
                            if (objectRef3.element != 0) {
                                if (anonymousClass3.$onDoubleTap == null) {
                                    function2 = anonymousClass3.$onTap;
                                    if (function2 != null) {
                                        function2.invoke(Offset.m4038boximpl(((PointerInputChange) objectRef3.element).getPosition()));
                                    }
                                } else {
                                    anonymousClass3.L$0 = awaitPointerEventScope3;
                                    anonymousClass3.L$1 = objectRef3;
                                    anonymousClass3.L$2 = null;
                                    anonymousClass3.L$3 = null;
                                    anonymousClass3.J$0 = j;
                                    anonymousClass3.label = 4;
                                    objAwaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope3, (PointerInputChange) objectRef3.element, anonymousClass3);
                                    if (objAwaitSecondDown == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj7 = obj6;
                                    objectRef5 = objectRef3;
                                    awaitPointerEventScope4 = awaitPointerEventScope3;
                                    long j5 = j;
                                    anonymousClass4 = anonymousClass3;
                                    obj8 = objAwaitSecondDown;
                                    j2 = j5;
                                    pointerInputChange3 = (PointerInputChange) obj8;
                                    if (pointerInputChange3 == null) {
                                        function3 = anonymousClass4.$onTap;
                                        if (function3 != null) {
                                            function3.invoke(Offset.m4038boximpl(((PointerInputChange) objectRef5.element).getPosition()));
                                        }
                                    } else {
                                        BuildersKt__Builders_commonKt.launch$default(anonymousClass4.$$this$coroutineScope, null, null, new AnonymousClass7(anonymousClass4.$pressScope, null), 3, null);
                                        if (anonymousClass4.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                            BuildersKt__Builders_commonKt.launch$default(anonymousClass4.$$this$coroutineScope, null, null, new AnonymousClass8(anonymousClass4.$onPress, anonymousClass4.$pressScope, pointerInputChange3, null), 3, null);
                                        }
                                        awaitPointerEventScope5 = awaitPointerEventScope4;
                                        objectRef7 = objectRef5;
                                        anonymousClass4.L$0 = awaitPointerEventScope5;
                                        anonymousClass4.L$1 = objectRef7;
                                        anonymousClass4.L$2 = pointerInputChange3;
                                        anonymousClass4.label = 5;
                                        if (awaitPointerEventScope5.withTimeout(j2, new AnonymousClass9(anonymousClass4.$$this$coroutineScope, anonymousClass4.$onDoubleTap, anonymousClass4.$onTap, objectRef5, anonymousClass4.$pressScope, null), anonymousClass4) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        obj10 = obj7;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    case 1:
                        obj3 = obj;
                        AwaitPointerEventScope awaitPointerEventScope7 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj3);
                        obj2 = obj3;
                        awaitPointerEventScope = awaitPointerEventScope7;
                        anonymousClass1 = this;
                        pointerInputChange = (PointerInputChange) obj3;
                        pointerInputChange.consume();
                        BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, null, new C45481(anonymousClass1.$pressScope, null), 3, null);
                        if (anonymousClass1.$onPress != TapGestureDetectorKt.NoPressGesture) {
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, null, new AnonymousClass2(anonymousClass1.$onPress, anonymousClass1.$pressScope, pointerInputChange, null), 3, null);
                        }
                        if (anonymousClass1.$onLongPress != null) {
                            longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
                        } else {
                            longPressTimeoutMillis = DurationKt.MAX_MILLIS;
                        }
                        objectRef = new Ref.ObjectRef();
                        anonymousClass1.L$0 = awaitPointerEventScope;
                        anonymousClass1.L$1 = pointerInputChange;
                        anonymousClass1.L$2 = objectRef;
                        anonymousClass1.L$3 = objectRef;
                        anonymousClass1.J$0 = longPressTimeoutMillis;
                        anonymousClass1.label = 2;
                        objWithTimeout = awaitPointerEventScope.withTimeout(longPressTimeoutMillis, new AnonymousClass3(null), anonymousClass1);
                        if (objWithTimeout == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        awaitPointerEventScope3 = awaitPointerEventScope;
                        pointerInputChange2 = pointerInputChange;
                        objectRef3 = objectRef;
                        anonymousClass3 = anonymousClass1;
                        t = objWithTimeout;
                        objectRef4 = objectRef3;
                        obj5 = obj2;
                        objectRef4.element = t;
                        if (objectRef3.element == 0) {
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass4(anonymousClass3.$pressScope, null), 3, null);
                        } else {
                            ((PointerInputChange) objectRef3.element).consume();
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass5(anonymousClass3.$pressScope, null), 3, null);
                        }
                        obj6 = obj5;
                        j = longPressTimeoutMillis;
                        if (objectRef3.element != 0) {
                            if (anonymousClass3.$onDoubleTap == null) {
                                function2 = anonymousClass3.$onTap;
                                if (function2 != null) {
                                    function2.invoke(Offset.m4038boximpl(((PointerInputChange) objectRef3.element).getPosition()));
                                }
                            } else {
                                anonymousClass3.L$0 = awaitPointerEventScope3;
                                anonymousClass3.L$1 = objectRef3;
                                anonymousClass3.L$2 = null;
                                anonymousClass3.L$3 = null;
                                anonymousClass3.J$0 = j;
                                anonymousClass3.label = 4;
                                objAwaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope3, (PointerInputChange) objectRef3.element, anonymousClass3);
                                if (objAwaitSecondDown == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj7 = obj6;
                                objectRef5 = objectRef3;
                                awaitPointerEventScope4 = awaitPointerEventScope3;
                                long j6 = j;
                                anonymousClass4 = anonymousClass3;
                                obj8 = objAwaitSecondDown;
                                j2 = j6;
                                pointerInputChange3 = (PointerInputChange) obj8;
                                if (pointerInputChange3 == null) {
                                    function3 = anonymousClass4.$onTap;
                                    if (function3 != null) {
                                        function3.invoke(Offset.m4038boximpl(((PointerInputChange) objectRef5.element).getPosition()));
                                    }
                                } else {
                                    BuildersKt__Builders_commonKt.launch$default(anonymousClass4.$$this$coroutineScope, null, null, new AnonymousClass7(anonymousClass4.$pressScope, null), 3, null);
                                    if (anonymousClass4.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                        BuildersKt__Builders_commonKt.launch$default(anonymousClass4.$$this$coroutineScope, null, null, new AnonymousClass8(anonymousClass4.$onPress, anonymousClass4.$pressScope, pointerInputChange3, null), 3, null);
                                    }
                                    awaitPointerEventScope5 = awaitPointerEventScope4;
                                    objectRef7 = objectRef5;
                                    anonymousClass4.L$0 = awaitPointerEventScope5;
                                    anonymousClass4.L$1 = objectRef7;
                                    anonymousClass4.L$2 = pointerInputChange3;
                                    anonymousClass4.label = 5;
                                    if (awaitPointerEventScope5.withTimeout(j2, new AnonymousClass9(anonymousClass4.$$this$coroutineScope, anonymousClass4.$onDoubleTap, anonymousClass4.$onTap, objectRef5, anonymousClass4.$pressScope, null), anonymousClass4) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj10 = obj7;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 2:
                        anonymousClass3 = this;
                        Object obj15 = obj;
                        long j7 = anonymousClass3.J$0;
                        objectRef4 = (Ref.ObjectRef) anonymousClass3.L$3;
                        Ref.ObjectRef objectRef8 = (Ref.ObjectRef) anonymousClass3.L$2;
                        pointerInputChange = (PointerInputChange) anonymousClass3.L$1;
                        AwaitPointerEventScope awaitPointerEventScope8 = (AwaitPointerEventScope) anonymousClass3.L$0;
                        try {
                            ResultKt.throwOnFailure(obj15);
                            awaitPointerEventScope3 = awaitPointerEventScope8;
                            pointerInputChange2 = pointerInputChange;
                            objectRef3 = objectRef8;
                            longPressTimeoutMillis = j7;
                            obj5 = obj15;
                            t = obj15;
                            objectRef4.element = t;
                            if (objectRef3.element == 0) {
                                BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass4(anonymousClass3.$pressScope, null), 3, null);
                            } else {
                                ((PointerInputChange) objectRef3.element).consume();
                                BuildersKt__Builders_commonKt.launch$default(anonymousClass3.$$this$coroutineScope, null, null, new AnonymousClass5(anonymousClass3.$pressScope, null), 3, null);
                            }
                            obj6 = obj5;
                            j = longPressTimeoutMillis;
                        } catch (PointerEventTimeoutCancellationException e5) {
                            anonymousClass2 = anonymousClass3;
                            obj4 = obj15;
                            j = j7;
                            objectRef2 = objectRef8;
                            awaitPointerEventScope2 = awaitPointerEventScope8;
                            function1 = anonymousClass2.$onLongPress;
                            if (function1 != null) {
                                function1.invoke(Offset.m4038boximpl(pointerInputChange.getPosition()));
                            }
                            anonymousClass2.L$0 = awaitPointerEventScope2;
                            anonymousClass2.L$1 = objectRef2;
                            anonymousClass2.L$2 = null;
                            anonymousClass2.L$3 = null;
                            anonymousClass2.J$0 = j;
                            anonymousClass2.label = 3;
                            obj9 = obj4;
                            if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope2, anonymousClass2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass2.$$this$coroutineScope, null, null, new AnonymousClass6(anonymousClass2.$pressScope, null), 3, null);
                            objectRef3 = objectRef2;
                            awaitPointerEventScope3 = awaitPointerEventScope2;
                            Object obj16 = obj9;
                            anonymousClass3 = anonymousClass2;
                            obj6 = obj16;
                            if (objectRef3.element != 0) {
                                if (anonymousClass3.$onDoubleTap == null) {
                                    function2 = anonymousClass3.$onTap;
                                    if (function2 != null) {
                                        function2.invoke(Offset.m4038boximpl(((PointerInputChange) objectRef3.element).getPosition()));
                                    }
                                } else {
                                    anonymousClass3.L$0 = awaitPointerEventScope3;
                                    anonymousClass3.L$1 = objectRef3;
                                    anonymousClass3.L$2 = null;
                                    anonymousClass3.L$3 = null;
                                    anonymousClass3.J$0 = j;
                                    anonymousClass3.label = 4;
                                    objAwaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope3, (PointerInputChange) objectRef3.element, anonymousClass3);
                                    if (objAwaitSecondDown == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj7 = obj6;
                                    objectRef5 = objectRef3;
                                    awaitPointerEventScope4 = awaitPointerEventScope3;
                                    long j8 = j;
                                    anonymousClass4 = anonymousClass3;
                                    obj8 = objAwaitSecondDown;
                                    j2 = j8;
                                    pointerInputChange3 = (PointerInputChange) obj8;
                                    if (pointerInputChange3 == null) {
                                        function3 = anonymousClass4.$onTap;
                                        if (function3 != null) {
                                            function3.invoke(Offset.m4038boximpl(((PointerInputChange) objectRef5.element).getPosition()));
                                        }
                                    } else {
                                        BuildersKt__Builders_commonKt.launch$default(anonymousClass4.$$this$coroutineScope, null, null, new AnonymousClass7(anonymousClass4.$pressScope, null), 3, null);
                                        if (anonymousClass4.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                            BuildersKt__Builders_commonKt.launch$default(anonymousClass4.$$this$coroutineScope, null, null, new AnonymousClass8(anonymousClass4.$onPress, anonymousClass4.$pressScope, pointerInputChange3, null), 3, null);
                                        }
                                        awaitPointerEventScope5 = awaitPointerEventScope4;
                                        objectRef7 = objectRef5;
                                        anonymousClass4.L$0 = awaitPointerEventScope5;
                                        anonymousClass4.L$1 = objectRef7;
                                        anonymousClass4.L$2 = pointerInputChange3;
                                        anonymousClass4.label = 5;
                                        if (awaitPointerEventScope5.withTimeout(j2, new AnonymousClass9(anonymousClass4.$$this$coroutineScope, anonymousClass4.$onDoubleTap, anonymousClass4.$onTap, objectRef5, anonymousClass4.$pressScope, null), anonymousClass4) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        obj10 = obj7;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        if (objectRef3.element != 0) {
                            if (anonymousClass3.$onDoubleTap == null) {
                                function2 = anonymousClass3.$onTap;
                                if (function2 != null) {
                                    function2.invoke(Offset.m4038boximpl(((PointerInputChange) objectRef3.element).getPosition()));
                                }
                            } else {
                                anonymousClass3.L$0 = awaitPointerEventScope3;
                                anonymousClass3.L$1 = objectRef3;
                                anonymousClass3.L$2 = null;
                                anonymousClass3.L$3 = null;
                                anonymousClass3.J$0 = j;
                                anonymousClass3.label = 4;
                                objAwaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope3, (PointerInputChange) objectRef3.element, anonymousClass3);
                                if (objAwaitSecondDown == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj7 = obj6;
                                objectRef5 = objectRef3;
                                awaitPointerEventScope4 = awaitPointerEventScope3;
                                long j9 = j;
                                anonymousClass4 = anonymousClass3;
                                obj8 = objAwaitSecondDown;
                                j2 = j9;
                                pointerInputChange3 = (PointerInputChange) obj8;
                                if (pointerInputChange3 == null) {
                                    function3 = anonymousClass4.$onTap;
                                    if (function3 != null) {
                                        function3.invoke(Offset.m4038boximpl(((PointerInputChange) objectRef5.element).getPosition()));
                                    }
                                } else {
                                    BuildersKt__Builders_commonKt.launch$default(anonymousClass4.$$this$coroutineScope, null, null, new AnonymousClass7(anonymousClass4.$pressScope, null), 3, null);
                                    if (anonymousClass4.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                        BuildersKt__Builders_commonKt.launch$default(anonymousClass4.$$this$coroutineScope, null, null, new AnonymousClass8(anonymousClass4.$onPress, anonymousClass4.$pressScope, pointerInputChange3, null), 3, null);
                                    }
                                    awaitPointerEventScope5 = awaitPointerEventScope4;
                                    objectRef7 = objectRef5;
                                    anonymousClass4.L$0 = awaitPointerEventScope5;
                                    anonymousClass4.L$1 = objectRef7;
                                    anonymousClass4.L$2 = pointerInputChange3;
                                    anonymousClass4.label = 5;
                                    if (awaitPointerEventScope5.withTimeout(j2, new AnonymousClass9(anonymousClass4.$$this$coroutineScope, anonymousClass4.$onDoubleTap, anonymousClass4.$onTap, objectRef5, anonymousClass4.$pressScope, null), anonymousClass4) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj10 = obj7;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 3:
                        anonymousClass2 = this;
                        Object obj17 = obj;
                        j = anonymousClass2.J$0;
                        objectRef2 = (Ref.ObjectRef) anonymousClass2.L$1;
                        awaitPointerEventScope2 = (AwaitPointerEventScope) anonymousClass2.L$0;
                        ResultKt.throwOnFailure(obj17);
                        obj9 = obj17;
                        BuildersKt__Builders_commonKt.launch$default(anonymousClass2.$$this$coroutineScope, null, null, new AnonymousClass6(anonymousClass2.$pressScope, null), 3, null);
                        objectRef3 = objectRef2;
                        awaitPointerEventScope3 = awaitPointerEventScope2;
                        Object obj18 = obj9;
                        anonymousClass3 = anonymousClass2;
                        obj6 = obj18;
                        if (objectRef3.element != 0) {
                            if (anonymousClass3.$onDoubleTap == null) {
                                function2 = anonymousClass3.$onTap;
                                if (function2 != null) {
                                    function2.invoke(Offset.m4038boximpl(((PointerInputChange) objectRef3.element).getPosition()));
                                }
                            } else {
                                anonymousClass3.L$0 = awaitPointerEventScope3;
                                anonymousClass3.L$1 = objectRef3;
                                anonymousClass3.L$2 = null;
                                anonymousClass3.L$3 = null;
                                anonymousClass3.J$0 = j;
                                anonymousClass3.label = 4;
                                objAwaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope3, (PointerInputChange) objectRef3.element, anonymousClass3);
                                if (objAwaitSecondDown == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj7 = obj6;
                                objectRef5 = objectRef3;
                                awaitPointerEventScope4 = awaitPointerEventScope3;
                                long j10 = j;
                                anonymousClass4 = anonymousClass3;
                                obj8 = objAwaitSecondDown;
                                j2 = j10;
                                pointerInputChange3 = (PointerInputChange) obj8;
                                if (pointerInputChange3 == null) {
                                    function3 = anonymousClass4.$onTap;
                                    if (function3 != null) {
                                        function3.invoke(Offset.m4038boximpl(((PointerInputChange) objectRef5.element).getPosition()));
                                    }
                                } else {
                                    BuildersKt__Builders_commonKt.launch$default(anonymousClass4.$$this$coroutineScope, null, null, new AnonymousClass7(anonymousClass4.$pressScope, null), 3, null);
                                    if (anonymousClass4.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                        BuildersKt__Builders_commonKt.launch$default(anonymousClass4.$$this$coroutineScope, null, null, new AnonymousClass8(anonymousClass4.$onPress, anonymousClass4.$pressScope, pointerInputChange3, null), 3, null);
                                    }
                                    awaitPointerEventScope5 = awaitPointerEventScope4;
                                    objectRef7 = objectRef5;
                                    anonymousClass4.L$0 = awaitPointerEventScope5;
                                    anonymousClass4.L$1 = objectRef7;
                                    anonymousClass4.L$2 = pointerInputChange3;
                                    anonymousClass4.label = 5;
                                    if (awaitPointerEventScope5.withTimeout(j2, new AnonymousClass9(anonymousClass4.$$this$coroutineScope, anonymousClass4.$onDoubleTap, anonymousClass4.$onTap, objectRef5, anonymousClass4.$pressScope, null), anonymousClass4) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj10 = obj7;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 4:
                        obj8 = obj;
                        long j11 = this.J$0;
                        Ref.ObjectRef objectRef9 = (Ref.ObjectRef) this.L$1;
                        AwaitPointerEventScope awaitPointerEventScope9 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj8);
                        objectRef5 = objectRef9;
                        awaitPointerEventScope4 = awaitPointerEventScope9;
                        obj7 = obj8;
                        j2 = j11;
                        anonymousClass4 = this;
                        pointerInputChange3 = (PointerInputChange) obj8;
                        if (pointerInputChange3 == null) {
                            function3 = anonymousClass4.$onTap;
                            if (function3 != null) {
                                function3.invoke(Offset.m4038boximpl(((PointerInputChange) objectRef5.element).getPosition()));
                            }
                        } else {
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass4.$$this$coroutineScope, null, null, new AnonymousClass7(anonymousClass4.$pressScope, null), 3, null);
                            if (anonymousClass4.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                BuildersKt__Builders_commonKt.launch$default(anonymousClass4.$$this$coroutineScope, null, null, new AnonymousClass8(anonymousClass4.$onPress, anonymousClass4.$pressScope, pointerInputChange3, null), 3, null);
                            }
                            awaitPointerEventScope5 = awaitPointerEventScope4;
                            objectRef7 = objectRef5;
                            anonymousClass4.L$0 = awaitPointerEventScope5;
                            anonymousClass4.L$1 = objectRef7;
                            anonymousClass4.L$2 = pointerInputChange3;
                            anonymousClass4.label = 5;
                            if (awaitPointerEventScope5.withTimeout(j2, new AnonymousClass9(anonymousClass4.$$this$coroutineScope, anonymousClass4.$onDoubleTap, anonymousClass4.$onTap, objectRef5, anonymousClass4.$pressScope, null), anonymousClass4) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj10 = obj7;
                        }
                        return Unit.INSTANCE;
                    case 5:
                        Object obj19 = obj;
                        pointerInputChange4 = (PointerInputChange) this.L$2;
                        objectRef6 = (Ref.ObjectRef) this.L$1;
                        AwaitPointerEventScope awaitPointerEventScope10 = (AwaitPointerEventScope) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj19);
                            obj10 = obj19;
                        } catch (PointerEventTimeoutCancellationException e6) {
                            anonymousClass5 = this;
                            awaitPointerEventScope5 = awaitPointerEventScope10;
                            obj11 = obj19;
                            function4 = anonymousClass5.$onTap;
                            if (function4 != null) {
                                function4.invoke(Offset.m4038boximpl(((PointerInputChange) objectRef6.element).getPosition()));
                            }
                            function5 = anonymousClass5.$onLongPress;
                            if (function5 != null) {
                                function5.invoke(Offset.m4038boximpl(pointerInputChange4.getPosition()));
                            }
                            anonymousClass5.L$0 = null;
                            anonymousClass5.L$1 = null;
                            anonymousClass5.L$2 = null;
                            anonymousClass5.label = 6;
                            if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope5, anonymousClass5) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj12 = obj11;
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass5.$$this$coroutineScope, null, null, new AnonymousClass10(anonymousClass5.$pressScope, null), 3, null);
                        }
                        return Unit.INSTANCE;
                    case 6:
                        anonymousClass5 = this;
                        Object obj20 = obj;
                        ResultKt.throwOnFailure(obj20);
                        obj12 = obj20;
                        BuildersKt__Builders_commonKt.launch$default(anonymousClass5.$$this$coroutineScope, null, null, new AnonymousClass10(anonymousClass5.$pressScope, null), 3, null);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1", m210f = "TapGestureDetector.kt", m211i = {}, m212l = {HttpStatusCodesKt.HTTP_EARLY_HINTS}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class C45481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C45481(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C45481> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C45481(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C45481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2", m210f = "TapGestureDetector.kt", m211i = {}, m212l = {106}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PointerInputChange $down;
                final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass2(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$onPress = function3;
                    this.$pressScope = pressGestureScopeImpl;
                    this.$down = pointerInputChange;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.$onPress, this.$pressScope, this.$down, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                            PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                            Offset offsetM4038boximpl = Offset.m4038boximpl(this.$down.getPosition());
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3", m210f = "TapGestureDetector.kt", m211i = {}, m212l = {115}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class AnonymousClass3 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
                private /* synthetic */ Object L$0;
                int label;

                AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                    anonymousClass3.L$0 = obj;
                    return anonymousClass3;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
                    return ((AnonymousClass3) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4", m210f = "TapGestureDetector.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
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
                            this.$pressScope.cancel();
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5", m210f = "TapGestureDetector.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6", m210f = "TapGestureDetector.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7", m210f = "TapGestureDetector.kt", m211i = {}, m212l = {TarConstants.CHKSUM_OFFSET}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass7(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass7> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass7(this.$pressScope, continuation);
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8", m210f = "TapGestureDetector.kt", m211i = {}, m212l = {151}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                final /* synthetic */ PointerInputChange $secondDown;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass8(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super AnonymousClass8> continuation) {
                    super(2, continuation);
                    this.$onPress = function3;
                    this.$pressScope = pressGestureScopeImpl;
                    this.$secondDown = pointerInputChange;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass8(this.$onPress, this.$pressScope, this.$secondDown, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9", m210f = "TapGestureDetector.kt", m211i = {}, m212l = {157}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class AnonymousClass9 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
                final /* synthetic */ Function1<Offset, Unit> $onTap;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                final /* synthetic */ Ref.ObjectRef<PointerInputChange> $upOrCancel;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass9(CoroutineScope coroutineScope, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function2, Ref.ObjectRef<PointerInputChange> objectRef, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass9> continuation) {
                    super(2, continuation);
                    this.$$this$coroutineScope = coroutineScope;
                    this.$onDoubleTap = function1;
                    this.$onTap = function2;
                    this.$upOrCancel = objectRef;
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass9 anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, this.$upOrCancel, this.$pressScope, continuation);
                    anonymousClass9.L$0 = obj;
                    return anonymousClass9;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass9) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    AnonymousClass9 anonymousClass9;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            anonymousClass9 = this;
                            AwaitPointerEventScope $this$withTimeout = (AwaitPointerEventScope) anonymousClass9.L$0;
                            anonymousClass9.label = 1;
                            Object objWaitForUpOrCancellation$default = TapGestureDetectorKt.waitForUpOrCancellation$default($this$withTimeout, null, anonymousClass9, 1, null);
                            if (objWaitForUpOrCancellation$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result = objWaitForUpOrCancellation$default;
                            break;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            anonymousClass9 = this;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    PointerInputChange secondUp = (PointerInputChange) $result;
                    if (secondUp == null) {
                        BuildersKt__Builders_commonKt.launch$default(anonymousClass9.$$this$coroutineScope, null, null, new AnonymousClass2(anonymousClass9.$pressScope, null), 3, null);
                        Function1<Offset, Unit> function1 = anonymousClass9.$onTap;
                        if (function1 == null) {
                            return null;
                        }
                        function1.invoke(Offset.m4038boximpl(anonymousClass9.$upOrCancel.element.getPosition()));
                        return Unit.INSTANCE;
                    }
                    secondUp.consume();
                    BuildersKt__Builders_commonKt.launch$default(anonymousClass9.$$this$coroutineScope, null, null, new C45491(anonymousClass9.$pressScope, null), 3, null);
                    anonymousClass9.$onDoubleTap.invoke(Offset.m4038boximpl(secondUp.getPosition()));
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: TapGestureDetector.kt */
                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$1", m210f = "TapGestureDetector.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                static final class C45491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ PressGestureScopeImpl $pressScope;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C45491(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C45491> continuation) {
                        super(2, continuation);
                        this.$pressScope = pressGestureScopeImpl;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C45491(this.$pressScope, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C45491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

                /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$2, reason: invalid class name */
                /* JADX INFO: compiled from: TapGestureDetector.kt */
                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$2", m210f = "TapGestureDetector.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$10, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$10", m210f = "TapGestureDetector.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class AnonymousClass10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass10(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass10> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass10(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass10) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

    public static final Object detectTapGestures(PointerInputScope $this$detectTapGestures, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function2, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function4, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C04162($this$detectTapGestures, function3, function2, function1, function4, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
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
            boolean r0 = r15 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.C04141
            if (r0 == 0) goto L14
            r0 = r15
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.C04141) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L19
        L14:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2", m210f = "TapGestureDetector.kt", m211i = {0, 0}, m212l = {212}, m213m = "invokeSuspend", m214n = {"$this$withTimeoutOrNull", "minUptime"}, m215s = {"L$0", "J$0"})
    static final class C04132 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
        final /* synthetic */ PointerInputChange $firstUp;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04132(PointerInputChange pointerInputChange, Continuation<? super C04132> continuation) {
            super(2, continuation);
            this.$firstUp = pointerInputChange;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04132 c04132 = new C04132(this.$firstUp, continuation);
            c04132.L$0 = obj;
            return c04132;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
            return ((C04132) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.C04132.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object awaitSecondDown(AwaitPointerEventScope $this$awaitSecondDown, PointerInputChange firstUp, Continuation<? super PointerInputChange> continuation) {
        return $this$awaitSecondDown.withTimeoutOrNull($this$awaitSecondDown.getViewConfiguration().getDoubleTapTimeoutMillis(), new C04132(firstUp, null), continuation);
    }

    public static /* synthetic */ Object detectTapAndPress$default(PointerInputScope pointerInputScope, Function3 function3, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function3 = NoPressGesture;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        return detectTapAndPress(pointerInputScope, function3, function1, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2", m210f = "TapGestureDetector.kt", m211i = {}, m212l = {232}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C04152 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ Function1<Offset, Unit> $onTap;
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        final /* synthetic */ PointerInputScope $this_detectTapAndPress;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C04152(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C04152> continuation) {
            super(2, continuation);
            this.$this_detectTapAndPress = pointerInputScope;
            this.$onPress = function3;
            this.$onTap = function1;
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04152 c04152 = new C04152(this.$this_detectTapAndPress, this.$onPress, this.$onTap, this.$pressScope, continuation);
            c04152.L$0 = obj;
            return c04152;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04152) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TapGestureDetector.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1", m210f = "TapGestureDetector.kt", m211i = {0}, m212l = {237, 245}, m213m = "invokeSuspend", m214n = {"$this$awaitEachGesture"}, m215s = {"L$0"})
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ Function1<Offset, Unit> $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(CoroutineScope coroutineScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.$onPress = function3;
                this.$onTap = function1;
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.$onPress, this.$onTap, this.$pressScope, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1", m210f = "TapGestureDetector.kt", m211i = {}, m212l = {234}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class C45471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C45471(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C45471> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C45471(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C45471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

            /* JADX WARN: Code duplicated, block: B:13:0x006c  */
            /* JADX WARN: Code duplicated, block: B:16:0x008f A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:17:0x0090  */
            /* JADX WARN: Code duplicated, block: B:20:0x0096  */
            /* JADX WARN: Code duplicated, block: B:21:0x00aa  */
            /* JADX WARN: Code duplicated, block: B:23:0x00c6  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                AnonymousClass1 anonymousClass1;
                AwaitPointerEventScope $this$awaitEachGesture;
                Object objAwaitFirstDown$default;
                PointerInputChange down;
                Object objWaitForUpOrCancellation$default;
                AnonymousClass1 anonymousClass2;
                Object $result2;
                PointerInputChange up;
                Function1<Offset, Unit> function1;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        anonymousClass1 = this;
                        $this$awaitEachGesture = (AwaitPointerEventScope) anonymousClass1.L$0;
                        BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, null, new C45471(anonymousClass1.$pressScope, null), 3, null);
                        anonymousClass1.L$0 = $this$awaitEachGesture;
                        anonymousClass1.label = 1;
                        objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default($this$awaitEachGesture, false, null, anonymousClass1, 3, null);
                        if (objAwaitFirstDown$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        PointerInputChange it = (PointerInputChange) objAwaitFirstDown$default;
                        it.consume();
                        down = (PointerInputChange) objAwaitFirstDown$default;
                        if (anonymousClass1.$onPress != TapGestureDetectorKt.NoPressGesture) {
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, null, new AnonymousClass2(anonymousClass1.$onPress, anonymousClass1.$pressScope, down, null), 3, null);
                        }
                        anonymousClass1.L$0 = null;
                        anonymousClass1.label = 2;
                        objWaitForUpOrCancellation$default = TapGestureDetectorKt.waitForUpOrCancellation$default($this$awaitEachGesture, null, anonymousClass1, 1, null);
                        if (objWaitForUpOrCancellation$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        anonymousClass2 = anonymousClass1;
                        $result2 = objWaitForUpOrCancellation$default;
                        up = (PointerInputChange) $result2;
                        if (up == null) {
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass2.$$this$coroutineScope, null, null, new AnonymousClass3(anonymousClass2.$pressScope, null), 3, null);
                        } else {
                            up.consume();
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass2.$$this$coroutineScope, null, null, new AnonymousClass4(anonymousClass2.$pressScope, null), 3, null);
                            function1 = anonymousClass2.$onTap;
                            if (function1 != null) {
                                function1.invoke(Offset.m4038boximpl(up.getPosition()));
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        anonymousClass1 = this;
                        $this$awaitEachGesture = (AwaitPointerEventScope) anonymousClass1.L$0;
                        ResultKt.throwOnFailure($result);
                        objAwaitFirstDown$default = $result;
                        PointerInputChange it2 = (PointerInputChange) objAwaitFirstDown$default;
                        it2.consume();
                        down = (PointerInputChange) objAwaitFirstDown$default;
                        if (anonymousClass1.$onPress != TapGestureDetectorKt.NoPressGesture) {
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, null, new AnonymousClass2(anonymousClass1.$onPress, anonymousClass1.$pressScope, down, null), 3, null);
                        }
                        anonymousClass1.L$0 = null;
                        anonymousClass1.label = 2;
                        objWaitForUpOrCancellation$default = TapGestureDetectorKt.waitForUpOrCancellation$default($this$awaitEachGesture, null, anonymousClass1, 1, null);
                        if (objWaitForUpOrCancellation$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        anonymousClass2 = anonymousClass1;
                        $result2 = objWaitForUpOrCancellation$default;
                        up = (PointerInputChange) $result2;
                        if (up == null) {
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass2.$$this$coroutineScope, null, null, new AnonymousClass3(anonymousClass2.$pressScope, null), 3, null);
                        } else {
                            up.consume();
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass2.$$this$coroutineScope, null, null, new AnonymousClass4(anonymousClass2.$pressScope, null), 3, null);
                            function1 = anonymousClass2.$onTap;
                            if (function1 != null) {
                                function1.invoke(Offset.m4038boximpl(up.getPosition()));
                            }
                        }
                        return Unit.INSTANCE;
                    case 2:
                        anonymousClass2 = this;
                        $result2 = $result;
                        ResultKt.throwOnFailure($result2);
                        up = (PointerInputChange) $result2;
                        if (up == null) {
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass2.$$this$coroutineScope, null, null, new AnonymousClass3(anonymousClass2.$pressScope, null), 3, null);
                        } else {
                            up.consume();
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass2.$$this$coroutineScope, null, null, new AnonymousClass4(anonymousClass2.$pressScope, null), 3, null);
                            function1 = anonymousClass2.$onTap;
                            if (function1 != null) {
                                function1.invoke(Offset.m4038boximpl(up.getPosition()));
                            }
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2", m210f = "TapGestureDetector.kt", m211i = {}, m212l = {241}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PointerInputChange $down;
                final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass2(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$onPress = function3;
                    this.$pressScope = pressGestureScopeImpl;
                    this.$down = pointerInputChange;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.$onPress, this.$pressScope, this.$down, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                            PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                            Offset offsetM4038boximpl = Offset.m4038boximpl(this.$down.getPosition());
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3", m210f = "TapGestureDetector.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$4, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$4", m210f = "TapGestureDetector.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
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
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    this.label = 1;
                    if (ForEachGestureKt.awaitEachGesture(this.$this_detectTapAndPress, new AnonymousClass1($this$coroutineScope, this.$onPress, this.$onTap, this.$pressScope, null), this) == coroutine_suspended) {
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

    public static final Object detectTapAndPress(PointerInputScope $this$detectTapAndPress, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Continuation<? super Unit> continuation) {
        PressGestureScopeImpl pressScope = new PressGestureScopeImpl($this$detectTapAndPress);
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C04152($this$detectTapAndPress, function3, function1, pressScope, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return awaitFirstDown(awaitPointerEventScope, z, continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with PointerEventPass instead.")
    public static final /* synthetic */ Object awaitFirstDown(AwaitPointerEventScope $this$awaitFirstDown, boolean requireUnconsumed, Continuation $completion) {
        return awaitFirstDown($this$awaitFirstDown, requireUnconsumed, PointerEventPass.Main, $completion);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x007d  */
    /* JADX WARN: Code duplicated, block: B:23:0x0089  */
    /* JADX WARN: Code duplicated, block: B:24:0x008e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0096 A[LOOP:0: B:19:0x007a->B:27:0x0096, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0061 -> B:18:0x006a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object awaitFirstDown(androidx.compose.p001ui.input.pointer.AwaitPointerEventScope r19, boolean r20, androidx.compose.p001ui.input.pointer.PointerEventPass r21, kotlin.coroutines.Continuation<? super androidx.compose.p001ui.input.pointer.PointerInputChange> r22) {
        /*
            r0 = r22
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.C04122
            if (r1 == 0) goto L16
            r1 = r0
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r1 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.C04122) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L1b
        L16:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r1 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2
            r1.<init>(r0)
        L1b:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 1
            switch(r3) {
                case 0: goto L44;
                case 1: goto L31;
                default: goto L28;
            }
        L28:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L31:
            boolean r3 = r0.Z$0
            java.lang.Object r5 = r0.L$1
            androidx.compose.ui.input.pointer.PointerEventPass r5 = (androidx.compose.p001ui.input.pointer.PointerEventPass) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.p001ui.input.pointer.AwaitPointerEventScope) r6
            kotlin.ResultKt.throwOnFailure(r1)
            r7 = r6
            r6 = r5
            r5 = r3
            r3 = r2
            r2 = r1
            goto L6a
        L44:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r19
            r5 = r21
            r6 = r20
            r18 = r6
            r6 = r3
            r3 = r18
        L52:
            r0.L$0 = r6
            r0.L$1 = r5
            r0.Z$0 = r3
            r0.label = r4
            java.lang.Object r7 = r6.awaitPointerEvent(r5, r0)
            if (r7 != r2) goto L61
            return r2
        L61:
            r18 = r2
            r2 = r1
            r1 = r7
            r7 = r6
            r6 = r5
            r5 = r3
            r3 = r18
        L6a:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.p001ui.input.pointer.PointerEvent) r1
            java.util.List r8 = r1.getChanges()
            r9 = 0
            r10 = 0
            r11 = 0
            int r12 = r8.size()
        L7a:
            r13 = 0
            if (r11 >= r12) goto L9a
            java.lang.Object r14 = r8.get(r11)
            r15 = 0
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.p001ui.input.pointer.PointerInputChange) r14
            r16 = 0
            if (r5 == 0) goto L8e
            boolean r17 = androidx.compose.p001ui.input.pointer.PointerEventKt.changedToDown(r14)
            goto L92
        L8e:
            boolean r17 = androidx.compose.p001ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r14)
        L92:
            if (r17 != 0) goto L96
            r8 = 0
            goto L9c
        L96:
            int r11 = r11 + 1
            goto L7a
        L9a:
            r8 = 1
        L9c:
            if (r8 == 0) goto La7
            java.util.List r3 = r1.getChanges()
            java.lang.Object r3 = r3.get(r13)
            return r3
        La7:
            r1 = r2
            r2 = r3
            r3 = r5
            r5 = r6
            r6 = r7
            goto L52
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return awaitFirstDown(awaitPointerEventScope, z, pointerEventPass, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0081  */
    /* JADX WARN: Code duplicated, block: B:24:0x0096 A[LOOP:1: B:20:0x007f->B:24:0x0096, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:62:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0107 -> B:49:0x010b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object waitForUpOrCancellation(androidx.compose.p001ui.input.pointer.AwaitPointerEventScope r20, androidx.compose.p001ui.input.pointer.PointerEventPass r21, kotlin.coroutines.Continuation<? super androidx.compose.p001ui.input.pointer.PointerInputChange> r22) {
        /*
            Method dump skipped, instruction units count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object waitForUpOrCancellation$default(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return waitForUpOrCancellation(awaitPointerEventScope, pointerEventPass, continuation);
    }
}
