package androidx.compose.p001ui.scrollcapture;

import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.CancellationSignal;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import androidx.compose.p001ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.ColorKt;
import androidx.compose.p001ui.graphics.RectHelper_androidKt;
import androidx.compose.p001ui.node.NodeCoordinator;
import androidx.compose.p001ui.semantics.SemanticsNode;
import androidx.compose.p001ui.unit.IntRect;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.internal.view.SupportMenu;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.NonCancellable;

/* JADX INFO: compiled from: ComposeScrollCaptureCallback.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J.\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0016J\u001e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0016J \u0010\u001a\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0016J\f\u0010\u001b\u001a\u00020\f*\u00020\u001cH\u0002J\f\u0010\u001d\u001a\u00020\f*\u00020\u001cH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m195d2 = {"Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback;", "Landroid/view/ScrollCaptureCallback;", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "viewportBoundsInWindow", "Landroidx/compose/ui/unit/IntRect;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroidx/compose/ui/unit/IntRect;Lkotlinx/coroutines/CoroutineScope;)V", "scrollTracker", "Landroidx/compose/ui/scrollcapture/RelativeScroller;", "onScrollCaptureEnd", "", "onReady", "Ljava/lang/Runnable;", "onScrollCaptureImageRequest", "session", "Landroid/view/ScrollCaptureSession;", "signal", "Landroid/os/CancellationSignal;", "captureArea", "Landroid/graphics/Rect;", "onComplete", "Ljava/util/function/Consumer;", "(Landroid/view/ScrollCaptureSession;Landroidx/compose/ui/unit/IntRect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onScrollCaptureSearch", "onScrollCaptureStart", "drawDebugBackground", "Landroid/graphics/Canvas;", "drawDebugOverlay", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposeScrollCaptureCallback implements ScrollCaptureCallback {
    public static final int $stable = 8;
    private final CoroutineScope coroutineScope;
    private final SemanticsNode node;
    private final RelativeScroller scrollTracker;
    private final IntRect viewportBoundsInWindow;

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2 */
    /* JADX INFO: compiled from: ComposeScrollCaptureCallback.android.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback", m210f = "ComposeScrollCaptureCallback.android.kt", m211i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, m212l = {112, 115}, m213m = "onScrollCaptureImageRequest", m214n = {"this", "session", "captureArea", "targetMin", "targetMax", "this", "session", "captureArea", "targetMin", "targetMax"}, m215s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
    static final class C19062 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C19062(Continuation<? super C19062> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ComposeScrollCaptureCallback.this.onScrollCaptureImageRequest(null, null, this);
        }
    }

    public ComposeScrollCaptureCallback(SemanticsNode node, IntRect viewportBoundsInWindow, CoroutineScope coroutineScope) {
        this.node = node;
        this.viewportBoundsInWindow = viewportBoundsInWindow;
        this.coroutineScope = CoroutineScopeKt.plus(coroutineScope, DisableAnimationMotionDurationScale.INSTANCE);
        this.scrollTracker = new RelativeScroller(this.viewportBoundsInWindow.getHeight(), new ComposeScrollCaptureCallback$scrollTracker$1(this, null));
    }

    @Override // android.view.ScrollCaptureCallback
    public void onScrollCaptureSearch(CancellationSignal signal, Consumer<Rect> onReady) {
        IntRect bounds = this.viewportBoundsInWindow;
        onReady.accept(RectHelper_androidKt.toAndroidRect(bounds));
    }

    @Override // android.view.ScrollCaptureCallback
    public void onScrollCaptureStart(ScrollCaptureSession session, CancellationSignal signal, Runnable onReady) {
        this.scrollTracker.reset();
        onReady.run();
    }

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$1 */
    /* JADX INFO: compiled from: ComposeScrollCaptureCallback.android.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$1", m210f = "ComposeScrollCaptureCallback.android.kt", m211i = {}, m212l = {100}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C19051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Rect $captureArea;
        final /* synthetic */ Consumer<Rect> $onComplete;
        final /* synthetic */ ScrollCaptureSession $session;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C19051(ScrollCaptureSession scrollCaptureSession, Rect rect, Consumer<Rect> consumer, Continuation<? super C19051> continuation) {
            super(2, continuation);
            this.$session = scrollCaptureSession;
            this.$captureArea = rect;
            this.$onComplete = consumer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ComposeScrollCaptureCallback.this.new C19051(this.$session, this.$captureArea, this.$onComplete, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C19051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C19051 c19051;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c19051 = this;
                    c19051.label = 1;
                    Object objOnScrollCaptureImageRequest = ComposeScrollCaptureCallback.this.onScrollCaptureImageRequest(c19051.$session, RectHelper_androidKt.toComposeIntRect(c19051.$captureArea), c19051);
                    if (objOnScrollCaptureImageRequest == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objOnScrollCaptureImageRequest;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    c19051 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            IntRect result = (IntRect) $result;
            c19051.$onComplete.accept(RectHelper_androidKt.toAndroidRect(result));
            return Unit.INSTANCE;
        }
    }

    @Override // android.view.ScrollCaptureCallback
    public void onScrollCaptureImageRequest(ScrollCaptureSession session, CancellationSignal signal, Rect captureArea, Consumer<Rect> onComplete) {
        ComposeScrollCaptureCallback_androidKt.launchWithCancellationSignal(this.coroutineScope, signal, new C19051(session, captureArea, onComplete, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x0096 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0097  */
    /* JADX WARN: Code duplicated, block: B:24:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:26:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:28:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:35:0x010f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object onScrollCaptureImageRequest(ScrollCaptureSession session, IntRect captureArea, Continuation<? super IntRect> continuation) {
        C19062 c19062;
        ScrollCaptureSession session2;
        int targetMax;
        ComposeScrollCaptureCallback composeScrollCaptureCallback;
        IntRect captureArea2;
        int targetMin;
        C19073 c19073;
        IntRect captureArea3;
        ScrollCaptureSession session3;
        ComposeScrollCaptureCallback composeScrollCaptureCallback2;
        int targetMin2;
        int targetMax2;
        IntRect viewportClippedRect;
        NodeCoordinator coordinator;
        Canvas androidCanvas;
        if (continuation instanceof C19062) {
            c19062 = (C19062) continuation;
            if ((c19062.label & Integer.MIN_VALUE) != 0) {
                c19062.label -= Integer.MIN_VALUE;
            } else {
                c19062 = new C19062(continuation);
            }
        } else {
            c19062 = new C19062(continuation);
        }
        C19062 c19063 = c19062;
        Object $result = c19063.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c19063.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                int targetMin3 = captureArea.getTop();
                int targetMax3 = captureArea.getBottom();
                RelativeScroller relativeScroller = this.scrollTracker;
                c19063.L$0 = this;
                c19063.L$1 = session;
                c19063.L$2 = captureArea;
                c19063.I$0 = targetMin3;
                c19063.I$1 = targetMax3;
                c19063.label = 1;
                if (relativeScroller.scrollRangeIntoView(targetMin3, targetMax3, c19063) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                session2 = session;
                targetMax = targetMax3;
                composeScrollCaptureCallback = this;
                captureArea2 = captureArea;
                targetMin = targetMin3;
                c19073 = new Function1<Long, Unit>() { // from class: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.onScrollCaptureImageRequest.3
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                        invoke(l.longValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(long it) {
                    }
                };
                c19063.L$0 = composeScrollCaptureCallback;
                c19063.L$1 = session2;
                c19063.L$2 = captureArea2;
                c19063.I$0 = targetMin;
                c19063.I$1 = targetMax;
                c19063.label = 2;
                if (MonotonicFrameClockKt.withFrameNanos(c19073, c19063) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                captureArea3 = captureArea2;
                session3 = session2;
                composeScrollCaptureCallback2 = composeScrollCaptureCallback;
                targetMin2 = composeScrollCaptureCallback2.scrollTracker.mapOffsetToViewport(targetMin);
                targetMax2 = composeScrollCaptureCallback2.scrollTracker.mapOffsetToViewport(targetMax);
                viewportClippedRect = IntRect.copy$default(captureArea3, 0, targetMin2, 0, targetMax2, 5, null);
                if (targetMin2 == targetMax2) {
                    return IntRect.INSTANCE.getZero();
                }
                coordinator = composeScrollCaptureCallback2.node.findCoordinatorToGetBounds$ui_release();
                if (coordinator == null) {
                    throw new IllegalStateException("Could not find coordinator for semantics node.".toString());
                }
                androidCanvas = session3.getSurface().lockHardwareCanvas();
                try {
                    androidCanvas.drawColor(0, BlendMode.CLEAR);
                    androidx.compose.p001ui.graphics.Canvas canvas = AndroidCanvas_androidKt.Canvas(androidCanvas);
                    canvas.translate(-viewportClippedRect.getLeft(), -viewportClippedRect.getTop());
                    coordinator.draw(canvas, null);
                    session3.getSurface().unlockCanvasAndPost(androidCanvas);
                    IntRect resultRect = viewportClippedRect.translate(0, MathKt.roundToInt(composeScrollCaptureCallback2.scrollTracker.getScrollAmount()));
                    return resultRect;
                } catch (Throwable th) {
                    session3.getSurface().unlockCanvasAndPost(androidCanvas);
                    throw th;
                }
            case 1:
                targetMax = c19063.I$1;
                targetMin = c19063.I$0;
                captureArea2 = (IntRect) c19063.L$2;
                session2 = (ScrollCaptureSession) c19063.L$1;
                composeScrollCaptureCallback = (ComposeScrollCaptureCallback) c19063.L$0;
                ResultKt.throwOnFailure($result);
                c19073 = new Function1<Long, Unit>() { // from class: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.onScrollCaptureImageRequest.3
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                        invoke(l.longValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(long it) {
                    }
                };
                c19063.L$0 = composeScrollCaptureCallback;
                c19063.L$1 = session2;
                c19063.L$2 = captureArea2;
                c19063.I$0 = targetMin;
                c19063.I$1 = targetMax;
                c19063.label = 2;
                if (MonotonicFrameClockKt.withFrameNanos(c19073, c19063) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                captureArea3 = captureArea2;
                session3 = session2;
                composeScrollCaptureCallback2 = composeScrollCaptureCallback;
                targetMin2 = composeScrollCaptureCallback2.scrollTracker.mapOffsetToViewport(targetMin);
                targetMax2 = composeScrollCaptureCallback2.scrollTracker.mapOffsetToViewport(targetMax);
                viewportClippedRect = IntRect.copy$default(captureArea3, 0, targetMin2, 0, targetMax2, 5, null);
                if (targetMin2 == targetMax2) {
                    return IntRect.INSTANCE.getZero();
                }
                coordinator = composeScrollCaptureCallback2.node.findCoordinatorToGetBounds$ui_release();
                if (coordinator == null) {
                    throw new IllegalStateException("Could not find coordinator for semantics node.".toString());
                }
                androidCanvas = session3.getSurface().lockHardwareCanvas();
                androidCanvas.drawColor(0, BlendMode.CLEAR);
                androidx.compose.p001ui.graphics.Canvas canvas2 = AndroidCanvas_androidKt.Canvas(androidCanvas);
                canvas2.translate(-viewportClippedRect.getLeft(), -viewportClippedRect.getTop());
                coordinator.draw(canvas2, null);
                session3.getSurface().unlockCanvasAndPost(androidCanvas);
                IntRect resultRect2 = viewportClippedRect.translate(0, MathKt.roundToInt(composeScrollCaptureCallback2.scrollTracker.getScrollAmount()));
                return resultRect2;
            case 2:
                targetMax = c19063.I$1;
                targetMin = c19063.I$0;
                captureArea3 = (IntRect) c19063.L$2;
                ScrollCaptureSession session4 = (ScrollCaptureSession) c19063.L$1;
                ComposeScrollCaptureCallback composeScrollCaptureCallback3 = (ComposeScrollCaptureCallback) c19063.L$0;
                ResultKt.throwOnFailure($result);
                session3 = session4;
                composeScrollCaptureCallback2 = composeScrollCaptureCallback3;
                targetMin2 = composeScrollCaptureCallback2.scrollTracker.mapOffsetToViewport(targetMin);
                targetMax2 = composeScrollCaptureCallback2.scrollTracker.mapOffsetToViewport(targetMax);
                viewportClippedRect = IntRect.copy$default(captureArea3, 0, targetMin2, 0, targetMax2, 5, null);
                if (targetMin2 == targetMax2) {
                    return IntRect.INSTANCE.getZero();
                }
                coordinator = composeScrollCaptureCallback2.node.findCoordinatorToGetBounds$ui_release();
                if (coordinator == null) {
                    throw new IllegalStateException("Could not find coordinator for semantics node.".toString());
                }
                androidCanvas = session3.getSurface().lockHardwareCanvas();
                androidCanvas.drawColor(0, BlendMode.CLEAR);
                androidx.compose.p001ui.graphics.Canvas canvas3 = AndroidCanvas_androidKt.Canvas(androidCanvas);
                canvas3.translate(-viewportClippedRect.getLeft(), -viewportClippedRect.getTop());
                coordinator.draw(canvas3, null);
                session3.getSurface().unlockCanvasAndPost(androidCanvas);
                IntRect resultRect3 = viewportClippedRect.translate(0, MathKt.roundToInt(composeScrollCaptureCallback2.scrollTracker.getScrollAmount()));
                return resultRect3;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureEnd$1 */
    /* JADX INFO: compiled from: ComposeScrollCaptureCallback.android.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureEnd$1", m210f = "ComposeScrollCaptureCallback.android.kt", m211i = {}, m212l = {171}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C19041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Runnable $onReady;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C19041(Runnable runnable, Continuation<? super C19041> continuation) {
            super(2, continuation);
            this.$onReady = runnable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ComposeScrollCaptureCallback.this.new C19041(this.$onReady, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C19041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C19041 c19041;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (ComposeScrollCaptureCallback.this.scrollTracker.scrollTo(0.0f, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c19041 = this;
                    break;
                    break;
                case 1:
                    c19041 = this;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c19041.$onReady.run();
            return Unit.INSTANCE;
        }
    }

    @Override // android.view.ScrollCaptureCallback
    public void onScrollCaptureEnd(Runnable onReady) {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, NonCancellable.INSTANCE, null, new C19041(onReady, null), 2, null);
    }

    private final void drawDebugBackground(Canvas $this$drawDebugBackground) {
        $this$drawDebugBackground.drawColor(ColorKt.m4345toArgb8_81llA(Color.Companion.m4315hslJlNiLsg$default(Color.INSTANCE, Random.INSTANCE.nextFloat() * 360.0f, 0.75f, 0.5f, 1.0f, null, 16, null)));
    }

    private final void drawDebugOverlay(Canvas $this$drawDebugOverlay) {
        Paint circlePaint = new Paint();
        circlePaint.setColor(SupportMenu.CATEGORY_MASK);
        $this$drawDebugOverlay.drawCircle(0.0f, 0.0f, 20.0f, circlePaint);
        $this$drawDebugOverlay.drawCircle($this$drawDebugOverlay.getWidth(), 0.0f, 20.0f, circlePaint);
        $this$drawDebugOverlay.drawCircle($this$drawDebugOverlay.getWidth(), $this$drawDebugOverlay.getHeight(), 20.0f, circlePaint);
        $this$drawDebugOverlay.drawCircle(0.0f, $this$drawDebugOverlay.getHeight(), 20.0f, circlePaint);
    }
}
