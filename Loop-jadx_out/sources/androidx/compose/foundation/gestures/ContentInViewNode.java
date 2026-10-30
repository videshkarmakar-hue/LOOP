package androidx.compose.foundation.gestures;

import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.node.DelegatableNodeKt;
import androidx.compose.p001ui.node.LayoutAwareModifierNode;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: ContentInViewNode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001AB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001e\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001eH\u0096@¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010!\u001a\u00020\"H\u0002J\"\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\n\u0010(\u001a\u0004\u0018\u00010\u0012H\u0002J\n\u0010)\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010*\u001a\u00020\u001cH\u0002J\u0010\u0010+\u001a\u00020\u001c2\b\u0010,\u001a\u0004\u0018\u00010\u0010J\u001a\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b/\u00100J\"\u00101\u001a\u0002022\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\b3\u00104J&\u00105\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001f\u00107\u001a\u000208*\u0002092\u0006\u0010:\u001a\u000209H\u0082\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u001f\u00107\u001a\u000208*\u00020\u00162\u0006\u0010:\u001a\u00020\u0016H\u0082\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010<J \u0010>\u001a\u00020\t*\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010@R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, m195d2 = {"Landroidx/compose/foundation/gestures/ContentInViewNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "scrollState", "Landroidx/compose/foundation/gestures/ScrollableState;", "reverseDirection", "", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "(Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/ScrollableState;ZLandroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "bringIntoViewRequests", "Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "focusedChild", "Landroidx/compose/ui/layout/LayoutCoordinates;", "focusedChildBoundsFromPreviousRemeasure", "Landroidx/compose/ui/geometry/Rect;", "isAnimationRunning", "trackingFocusedChild", "<set-?>", "Landroidx/compose/ui/unit/IntSize;", "viewportSize", "getViewportSize-YbymL2g$foundation_release", "()J", "J", "bringChildIntoView", "", "localRect", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateRectForParent", "calculateScrollDelta", "", "computeDestination", "childBounds", "containerSize", "computeDestination-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/Rect;", "findBringIntoViewRequest", "getFocusedChildBounds", "launchAnimation", "onFocusBoundsChanged", "newBounds", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "relocationOffset", "Landroidx/compose/ui/geometry/Offset;", "relocationOffset-BMxPBkI", "(Landroidx/compose/ui/geometry/Rect;J)J", "update", "state", "compareTo", "", "Landroidx/compose/ui/geometry/Size;", "other", "compareTo-iLBOSCw", "(JJ)I", "compareTo-TemP2vQ", "isMaxVisible", "isMaxVisible-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Z", "Request", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ContentInViewNode extends Modifier.Node implements BringIntoViewResponder, LayoutAwareModifierNode {
    public static final int $stable = 8;
    private BringIntoViewSpec bringIntoViewSpec;
    private LayoutCoordinates focusedChild;
    private Rect focusedChildBoundsFromPreviousRemeasure;
    private boolean isAnimationRunning;
    private Orientation orientation;
    private boolean reverseDirection;
    private ScrollableState scrollState;
    private boolean trackingFocusedChild;
    private final BringIntoViewRequestPriorityQueue bringIntoViewRequests = new BringIntoViewRequestPriorityQueue();
    private long viewportSize = IntSize.INSTANCE.m6980getZeroYbymL2g();

    /* JADX INFO: compiled from: ContentInViewNode.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // androidx.compose.p001ui.node.LayoutAwareModifierNode
    public /* synthetic */ void onPlaced(LayoutCoordinates layoutCoordinates) {
        LayoutAwareModifierNode.CC.$default$onPlaced(this, layoutCoordinates);
    }

    public ContentInViewNode(Orientation orientation, ScrollableState scrollState, boolean reverseDirection, BringIntoViewSpec bringIntoViewSpec) {
        this.orientation = orientation;
        this.scrollState = scrollState;
        this.reverseDirection = reverseDirection;
        this.bringIntoViewSpec = bringIntoViewSpec;
    }

    /* JADX INFO: renamed from: getViewportSize-YbymL2g$foundation_release, reason: not valid java name and from getter */
    public final long getViewportSize() {
        return this.viewportSize;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Rect calculateRectForParent(Rect localRect) {
        if (!(!IntSize.m6973equalsimpl0(this.viewportSize, IntSize.INSTANCE.m6980getZeroYbymL2g()))) {
            throw new IllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.".toString());
        }
        return m587computeDestinationO0kMr_c(localRect, this.viewportSize);
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Object bringChildIntoView(Function0<Rect> function0, Continuation<? super Unit> continuation) {
        Rect rectInvoke = function0.invoke();
        boolean z = false;
        if (rectInvoke != null && !m589isMaxVisibleO0kMr_c$default(this, rectInvoke, 0L, 1, null)) {
            z = true;
        }
        if (!z) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        CancellableContinuationImpl continuation2 = cancellable$iv;
        Request request = new Request(function0, continuation2);
        if (this.bringIntoViewRequests.enqueue(request) && !this.isAnimationRunning) {
            launchAnimation();
        }
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    public final void onFocusBoundsChanged(LayoutCoordinates newBounds) {
        this.focusedChild = newBounds;
    }

    @Override // androidx.compose.p001ui.node.LayoutAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public void mo557onRemeasuredozmzZPI(long size) {
        Rect focusedChild;
        long oldSize = this.viewportSize;
        this.viewportSize = size;
        if (m585compareToTemP2vQ(size, oldSize) < 0 && (focusedChild = getFocusedChildBounds()) != null) {
            Rect previousFocusedChildBounds = this.focusedChildBoundsFromPreviousRemeasure;
            if (previousFocusedChildBounds == null) {
                previousFocusedChildBounds = focusedChild;
            }
            if (!this.isAnimationRunning && !this.trackingFocusedChild && m588isMaxVisibleO0kMr_c(previousFocusedChildBounds, oldSize) && !m588isMaxVisibleO0kMr_c(focusedChild, size)) {
                this.trackingFocusedChild = true;
                launchAnimation();
            }
            this.focusedChildBoundsFromPreviousRemeasure = focusedChild;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect getFocusedChildBounds() {
        if (!getIsAttached()) {
            return null;
        }
        LayoutCoordinates coordinates = DelegatableNodeKt.requireLayoutCoordinates(this);
        LayoutCoordinates it = this.focusedChild;
        if (it != null) {
            if (!it.isAttached()) {
                it = null;
            }
            if (it != null) {
                LayoutCoordinates focusedChild = it;
                return coordinates.localBoundingBoxOf(focusedChild, false);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchAnimation() {
        if (!(!this.isAnimationRunning)) {
            throw new IllegalStateException("launchAnimation called when previous animation was running".toString());
        }
        UpdatableAnimationState animationState = new UpdatableAnimationState(this.bringIntoViewSpec.getScrollAnimationSpec());
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new C03672(animationState, null), 1, null);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2 */
    /* JADX INFO: compiled from: ContentInViewNode.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2", m210f = "ContentInViewNode.kt", m211i = {}, m212l = {184}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C03672 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UpdatableAnimationState $animationState;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03672(UpdatableAnimationState updatableAnimationState, Continuation<? super C03672> continuation) {
            super(2, continuation);
            this.$animationState = updatableAnimationState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03672 c03672 = ContentInViewNode.this.new C03672(this.$animationState, continuation);
            c03672.L$0 = obj;
            return c03672;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03672) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C03672 c03672;
            CancellationException cancellationException;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$launch = (CoroutineScope) this.L$0;
                    Job animationJob = JobKt.getJob($this$launch.getCoroutineContext());
                    try {
                        ContentInViewNode.this.isAnimationRunning = true;
                        this.label = 1;
                        if (ScrollableState.CC.scroll$default(ContentInViewNode.this.scrollState, null, new AnonymousClass1(this.$animationState, ContentInViewNode.this, animationJob, null), this, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c03672 = this;
                        cancellationException = null;
                        ContentInViewNode.this.bringIntoViewRequests.resumeAndRemoveAll();
                        ContentInViewNode.this.isAnimationRunning = false;
                        ContentInViewNode.this.bringIntoViewRequests.cancelAndRemoveAll(cancellationException);
                        ContentInViewNode.this.trackingFocusedChild = false;
                        return Unit.INSTANCE;
                    } catch (CancellationException e) {
                        e = e;
                        c03672 = this;
                        cancellationException = e;
                        throw e;
                    } catch (Throwable th) {
                        e = th;
                        c03672 = this;
                        cancellationException = null;
                        ContentInViewNode.this.isAnimationRunning = false;
                        ContentInViewNode.this.bringIntoViewRequests.cancelAndRemoveAll(cancellationException);
                        ContentInViewNode.this.trackingFocusedChild = false;
                        throw e;
                    }
                case 1:
                    c03672 = this;
                    cancellationException = null;
                    try {
                        try {
                            ResultKt.throwOnFailure($result);
                            ContentInViewNode.this.bringIntoViewRequests.resumeAndRemoveAll();
                            ContentInViewNode.this.isAnimationRunning = false;
                            ContentInViewNode.this.bringIntoViewRequests.cancelAndRemoveAll(cancellationException);
                            ContentInViewNode.this.trackingFocusedChild = false;
                            return Unit.INSTANCE;
                        } catch (CancellationException e2) {
                            e = e2;
                            cancellationException = e;
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        ContentInViewNode.this.isAnimationRunning = false;
                        ContentInViewNode.this.bringIntoViewRequests.cancelAndRemoveAll(cancellationException);
                        ContentInViewNode.this.trackingFocusedChild = false;
                        throw e;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ContentInViewNode.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1", m210f = "ContentInViewNode.kt", m211i = {}, m212l = {189}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Job $animationJob;
            final /* synthetic */ UpdatableAnimationState $animationState;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ContentInViewNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(UpdatableAnimationState updatableAnimationState, ContentInViewNode contentInViewNode, Job job, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$animationState = updatableAnimationState;
                this.this$0 = contentInViewNode;
                this.$animationJob = job;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$animationState, this.this$0, this.$animationJob, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        final ScrollScope $this$scroll = (ScrollScope) this.L$0;
                        this.$animationState.setValue(this.this$0.calculateScrollDelta());
                        UpdatableAnimationState updatableAnimationState = this.$animationState;
                        final ContentInViewNode contentInViewNode = this.this$0;
                        final UpdatableAnimationState updatableAnimationState2 = this.$animationState;
                        final Job job = this.$animationJob;
                        Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewNode.launchAnimation.2.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                                invoke(f.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float delta) {
                                float scrollMultiplier = contentInViewNode.reverseDirection ? 1.0f : -1.0f;
                                float adjustedDelta = scrollMultiplier * delta;
                                float consumedScroll = $this$scroll.scrollBy(adjustedDelta) * scrollMultiplier;
                                if (Math.abs(consumedScroll) < Math.abs(delta)) {
                                    JobKt__JobKt.cancel$default(job, "Scroll animation cancelled because scroll was not consumed (" + consumedScroll + " < " + delta + ')', null, 2, null);
                                }
                            }
                        };
                        final ContentInViewNode contentInViewNode2 = this.this$0;
                        final UpdatableAnimationState updatableAnimationState3 = this.$animationState;
                        this.label = 1;
                        if (updatableAnimationState.animateToZero(function1, new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewNode.launchAnimation.2.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                BringIntoViewRequestPriorityQueue this_$iv = contentInViewNode2.bringIntoViewRequests;
                                ContentInViewNode contentInViewNode3 = contentInViewNode2;
                                while (true) {
                                    if (!this_$iv.requests.isNotEmpty()) {
                                        break;
                                    }
                                    Rect bounds = ((Request) this_$iv.requests.last()).getCurrentBounds().invoke();
                                    if (!(bounds == null ? true : ContentInViewNode.m589isMaxVisibleO0kMr_c$default(contentInViewNode3, bounds, 0L, 1, null))) {
                                        break;
                                    }
                                    MutableVector mutableVector = this_$iv.requests;
                                    MutableVector this_$iv$iv = this_$iv.requests;
                                    CancellableContinuation<Unit> continuation = ((Request) mutableVector.removeAt(this_$iv$iv.getSize() - 1)).getContinuation();
                                    Unit unit = Unit.INSTANCE;
                                    Result.Companion companion = Result.INSTANCE;
                                    continuation.resumeWith(Result.m7693constructorimpl(unit));
                                }
                                if (contentInViewNode2.trackingFocusedChild) {
                                    Rect focusedChildBounds = contentInViewNode2.getFocusedChildBounds();
                                    if (focusedChildBounds != null && ContentInViewNode.m589isMaxVisibleO0kMr_c$default(contentInViewNode2, focusedChildBounds, 0L, 1, null)) {
                                        contentInViewNode2.trackingFocusedChild = false;
                                    }
                                }
                                updatableAnimationState3.setValue(contentInViewNode2.calculateScrollDelta());
                            }
                        }, this) == coroutine_suspended) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float calculateScrollDelta() {
        if (IntSize.m6973equalsimpl0(this.viewportSize, IntSize.INSTANCE.m6980getZeroYbymL2g())) {
            return 0.0f;
        }
        Rect rectangleToMakeVisible = findBringIntoViewRequest();
        if (rectangleToMakeVisible == null) {
            rectangleToMakeVisible = this.trackingFocusedChild ? getFocusedChildBounds() : null;
            if (rectangleToMakeVisible == null) {
                return 0.0f;
            }
        }
        long size = IntSizeKt.m6987toSizeozmzZPI(this.viewportSize);
        switch (WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()]) {
            case 1:
                return this.bringIntoViewSpec.calculateScrollDistance(rectangleToMakeVisible.getTop(), rectangleToMakeVisible.getBottom() - rectangleToMakeVisible.getTop(), Size.m4115getHeightimpl(size));
            case 2:
                return this.bringIntoViewSpec.calculateScrollDistance(rectangleToMakeVisible.getLeft(), rectangleToMakeVisible.getRight() - rectangleToMakeVisible.getLeft(), Size.m4118getWidthimpl(size));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final Rect findBringIntoViewRequest() {
        Rect rect = null;
        BringIntoViewRequestPriorityQueue this_$iv = this.bringIntoViewRequests;
        int $i$f$forEachFromSmallest = 0;
        MutableVector this_$iv$iv = this_$iv.requests;
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = size$iv$iv - 1;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            while (true) {
                Request it$iv = (Request) content$iv$iv[i$iv$iv];
                Rect bounds = it$iv.getCurrentBounds().invoke();
                if (bounds != null) {
                    if (m586compareToiLBOSCw(bounds.m4082getSizeNHjbRc(), IntSizeKt.m6987toSizeozmzZPI(this.viewportSize)) > 0) {
                        return rect == null ? bounds : rect;
                    }
                    rect = bounds;
                }
                i$iv$iv--;
                if (i$iv$iv < 0) {
                    break;
                }
                this_$iv = this_$iv;
                $i$f$forEachFromSmallest = $i$f$forEachFromSmallest;
            }
        }
        return rect;
    }

    /* JADX INFO: renamed from: computeDestination-O0kMr_c, reason: not valid java name */
    private final Rect m587computeDestinationO0kMr_c(Rect childBounds, long containerSize) {
        return childBounds.m4086translatek4lQ0M(Offset.m4058unaryMinusF1C5BW0(m590relocationOffsetBMxPBkI(childBounds, containerSize)));
    }

    /* JADX INFO: renamed from: isMaxVisible-O0kMr_c$default, reason: not valid java name */
    static /* synthetic */ boolean m589isMaxVisibleO0kMr_c$default(ContentInViewNode contentInViewNode, Rect rect, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = contentInViewNode.viewportSize;
        }
        return contentInViewNode.m588isMaxVisibleO0kMr_c(rect, j);
    }

    /* JADX INFO: renamed from: isMaxVisible-O0kMr_c, reason: not valid java name */
    private final boolean m588isMaxVisibleO0kMr_c(Rect $this$isMaxVisible_u2dO0kMr_c, long size) {
        long relocationOffset = m590relocationOffsetBMxPBkI($this$isMaxVisible_u2dO0kMr_c, size);
        return Math.abs(Offset.m4049getXimpl(relocationOffset)) <= 0.5f && Math.abs(Offset.m4050getYimpl(relocationOffset)) <= 0.5f;
    }

    /* JADX INFO: renamed from: relocationOffset-BMxPBkI, reason: not valid java name */
    private final long m590relocationOffsetBMxPBkI(Rect childBounds, long containerSize) {
        long size = IntSizeKt.m6987toSizeozmzZPI(containerSize);
        switch (WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()]) {
            case 1:
                return OffsetKt.Offset(0.0f, this.bringIntoViewSpec.calculateScrollDistance(childBounds.getTop(), childBounds.getBottom() - childBounds.getTop(), Size.m4115getHeightimpl(size)));
            case 2:
                return OffsetKt.Offset(this.bringIntoViewSpec.calculateScrollDistance(childBounds.getLeft(), childBounds.getRight() - childBounds.getLeft(), Size.m4118getWidthimpl(size)), 0.0f);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: compareTo-TemP2vQ, reason: not valid java name */
    private final int m585compareToTemP2vQ(long $this$compareTo_u2dTemP2vQ, long other) {
        switch (WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()]) {
            case 1:
                return Intrinsics.compare(IntSize.m6974getHeightimpl($this$compareTo_u2dTemP2vQ), IntSize.m6974getHeightimpl(other));
            case 2:
                return Intrinsics.compare(IntSize.m6975getWidthimpl($this$compareTo_u2dTemP2vQ), IntSize.m6975getWidthimpl(other));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: compareTo-iLBOSCw, reason: not valid java name */
    private final int m586compareToiLBOSCw(long $this$compareTo_u2diLBOSCw, long other) {
        switch (WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()]) {
            case 1:
                return Float.compare(Size.m4115getHeightimpl($this$compareTo_u2diLBOSCw), Size.m4115getHeightimpl(other));
            case 2:
                return Float.compare(Size.m4118getWidthimpl($this$compareTo_u2diLBOSCw), Size.m4118getWidthimpl(other));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void update(Orientation orientation, ScrollableState state, boolean reverseDirection, BringIntoViewSpec bringIntoViewSpec) {
        this.orientation = orientation;
        this.scrollState = state;
        this.reverseDirection = reverseDirection;
        this.bringIntoViewSpec = bringIntoViewSpec;
    }

    /* JADX INFO: compiled from: ContentInViewNode.kt */
    @Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, m195d2 = {"Landroidx/compose/foundation/gestures/ContentInViewNode$Request;", "", "currentBounds", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CancellableContinuation;)V", "getContinuation", "()Lkotlinx/coroutines/CancellableContinuation;", "getCurrentBounds", "()Lkotlin/jvm/functions/Function0;", "toString", "", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Request {
        public static final int $stable = 8;
        private final CancellableContinuation<Unit> continuation;
        private final Function0<Rect> currentBounds;

        /* JADX WARN: Multi-variable type inference failed */
        public Request(Function0<Rect> function0, CancellableContinuation<? super Unit> cancellableContinuation) {
            this.currentBounds = function0;
            this.continuation = cancellableContinuation;
        }

        public final Function0<Rect> getCurrentBounds() {
            return this.currentBounds;
        }

        public final CancellableContinuation<Unit> getContinuation() {
            return this.continuation;
        }

        /* JADX WARN: Code duplicated, block: B:10:0x005c  */
        public String toString() {
            String it;
            CoroutineName coroutineName = (CoroutineName) this.continuation.get$context().get(CoroutineName.INSTANCE);
            String name = coroutineName != null ? coroutineName.getName() : null;
            StringBuilder sbAppend = new StringBuilder().append("Request@");
            String string = Integer.toString(hashCode(), CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
            StringBuilder sbAppend2 = sbAppend.append(string);
            if (name != null) {
                String it2 = name;
                it = AbstractJsonLexerKt.BEGIN_LIST + it2 + "](";
                if (it == null) {
                    it = "(";
                }
            } else {
                it = "(";
            }
            return sbAppend2.append(it).append("currentBounds()=").append(this.currentBounds.invoke()).append(", continuation=").append(this.continuation).append(')').toString();
        }
    }
}
