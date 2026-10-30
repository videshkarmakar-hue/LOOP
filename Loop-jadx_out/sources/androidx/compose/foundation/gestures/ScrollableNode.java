package androidx.compose.foundation.gestures;

import android.view.KeyEvent;
import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.foundation.FocusedBoundsObserverNode;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.p001ui.focus.FocusProperties;
import androidx.compose.p001ui.focus.FocusPropertiesModifierNode;
import androidx.compose.p001ui.focus.FocusTargetModifierNodeKt;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.input.key.Key;
import androidx.compose.p001ui.input.key.KeyEventType;
import androidx.compose.p001ui.input.key.KeyEvent_androidKt;
import androidx.compose.p001ui.input.key.KeyInputModifierNode;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.p001ui.input.pointer.PointerEvent;
import androidx.compose.p001ui.input.pointer.PointerEventPass;
import androidx.compose.p001ui.input.pointer.PointerEventType;
import androidx.compose.p001ui.input.pointer.PointerInputChange;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.p001ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.p001ui.node.DelegatableNodeKt;
import androidx.compose.p001ui.node.ObserverModifierNode;
import androidx.compose.p001ui.node.ObserverModifierNodeKt;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005BK\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016JM\u0010,\u001a\u00020)2=\u0010-\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u001100¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020)0/\u0012\n\u0012\b\u0012\u0004\u0012\u00020)04\u0012\u0006\u0012\u0004\u0018\u0001050.H\u0096@¢\u0006\u0002\u00106J\b\u00107\u001a\u00020)H\u0016J\u001a\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020:H\u0016ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\b\u0010=\u001a\u00020)H\u0016J*\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0016ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ\u001a\u0010G\u001a\u00020\u000f2\u0006\u00109\u001a\u00020:H\u0016ø\u0001\u0000¢\u0006\u0004\bH\u0010<J\"\u0010I\u001a\u00020)2\u0006\u00109\u001a\u00020@2\u0006\u0010J\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\b\u0010M\u001a\u00020\u000fH\u0016JL\u0010N\u001a\u00020)2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010O\u001a\u00020)H\u0002J\u001f\u0010P\u001a\u00020)*\u00020Q2\u0006\u0010R\u001a\u00020SH\u0096@ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\u001f\u0010V\u001a\u00020)*\u00020Q2\u0006\u0010W\u001a\u00020XH\u0096@ø\u0001\u0000¢\u0006\u0004\bY\u0010UR\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Z"}, m195d2 = {"Landroidx/compose/foundation/gestures/ScrollableNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "contentInViewNode", "Landroidx/compose/foundation/gestures/ContentInViewNode;", "defaultFlingBehavior", "Landroidx/compose/foundation/gestures/DefaultFlingBehavior;", "nestedScrollConnection", "Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "pointerDirectionConfig", "Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "getPointerDirectionConfig", "()Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "scrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "scrollableContainerNode", "Landroidx/compose/foundation/gestures/ScrollableContainerNode;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "drag", "forEachDelta", "Lkotlin/Function2;", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAttach", "onKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onObservedReadsChanged", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "processMouseWheelEvent", "size", "processMouseWheelEvent-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)V", "startDragImmediately", "update", "updateDefaultFlingBehavior", "onDragStarted", "Lkotlinx/coroutines/CoroutineScope;", "startedPosition", "Landroidx/compose/ui/geometry/Offset;", "onDragStarted-d-4ec7I", "(Lkotlinx/coroutines/CoroutineScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-LuvzFrg", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class ScrollableNode extends DragGestureNode implements ObserverModifierNode, CompositionLocalConsumerModifierNode, FocusPropertiesModifierNode, KeyInputModifierNode {
    private final ContentInViewNode contentInViewNode;
    private final DefaultFlingBehavior defaultFlingBehavior;
    private FlingBehavior flingBehavior;
    private final ScrollableNestedScrollConnection nestedScrollConnection;
    private final NestedScrollDispatcher nestedScrollDispatcher;
    private OverscrollEffect overscrollEffect;
    private ScrollConfig scrollConfig;
    private final ScrollableContainerNode scrollableContainerNode;
    private final ScrollingLogic scrollingLogic;

    /* JADX WARN: Multi-variable type inference failed */
    public ScrollableNode(ScrollableState scrollableState, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec) {
        super(ScrollableKt.CanDragCalculation, z, mutableInteractionSource);
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = new NestedScrollDispatcher();
        this.scrollableContainerNode = (ScrollableContainerNode) delegate(new ScrollableContainerNode(z));
        this.defaultFlingBehavior = new DefaultFlingBehavior(SplineBasedDecayKt.splineBasedDecay(ScrollableKt.UnityDensity), null, 2, 0 == true ? 1 : 0);
        OverscrollEffect overscrollEffect2 = this.overscrollEffect;
        DefaultFlingBehavior defaultFlingBehavior = this.flingBehavior;
        this.scrollingLogic = new ScrollingLogic(scrollableState, overscrollEffect2, defaultFlingBehavior == null ? this.defaultFlingBehavior : defaultFlingBehavior, orientation, z2, this.nestedScrollDispatcher);
        this.nestedScrollConnection = new ScrollableNestedScrollConnection(this.scrollingLogic, z);
        this.contentInViewNode = (ContentInViewNode) delegate(new ContentInViewNode(orientation, scrollableState, z2, bringIntoViewSpec));
        delegate(NestedScrollNodeKt.nestedScrollModifierNode(this.nestedScrollConnection, this.nestedScrollDispatcher));
        delegate(FocusTargetModifierNodeKt.FocusTargetModifierNode());
        delegate(new BringIntoViewResponderNode(this.contentInViewNode));
        delegate(new FocusedBoundsObserverNode(new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.gestures.ScrollableNode.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates it) {
                ScrollableNode.this.contentInViewNode.onFocusBoundsChanged(it);
            }
        }));
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objDispatchDragEvents = this.scrollingLogic.dispatchDragEvents(function2, continuation);
        return objDispatchDragEvents == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDispatchDragEvents : Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public PointerDirectionConfig getPointerDirectionConfig() {
        return this.scrollingLogic.pointerDirectionConfig();
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStarted-d-4ec7I */
    public Object mo574onDragStartedd4ec7I(CoroutineScope $this$onDragStarted_u2dd_u2d4ec7I, long startedPosition, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStopped-LuvzFrg */
    public Object mo575onDragStoppedLuvzFrg(CoroutineScope $this$onDragStopped_u2dLuvzFrg, long velocity, Continuation<? super Unit> continuation) {
        BuildersKt__Builders_commonKt.launch$default(this.nestedScrollDispatcher.getCoroutineScope(), null, null, new ScrollableNode$onDragStopped$2(this, velocity, null), 3, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: startDragImmediately */
    public boolean getStartDragImmediately() {
        return this.scrollingLogic.shouldScrollImmediately();
    }

    public final void update(ScrollableState state, Orientation orientation, OverscrollEffect overscrollEffect, boolean enabled, boolean reverseDirection, FlingBehavior flingBehavior, MutableInteractionSource interactionSource, BringIntoViewSpec bringIntoViewSpec) {
        if (getEnabled() != enabled) {
            this.nestedScrollConnection.setEnabled(enabled);
            this.scrollableContainerNode.update(enabled);
        }
        FlingBehavior resolvedFlingBehavior = flingBehavior == null ? this.defaultFlingBehavior : flingBehavior;
        boolean resetPointerInputHandling = this.scrollingLogic.update(state, orientation, overscrollEffect, reverseDirection, resolvedFlingBehavior, this.nestedScrollDispatcher);
        this.contentInViewNode.update(orientation, state, reverseDirection, bringIntoViewSpec);
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        update(ScrollableKt.CanDragCalculation, enabled, interactionSource, resetPointerInputHandling);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateDefaultFlingBehavior();
        ObserverModifierNodeKt.observeReads(this, new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.ScrollableNode.onAttach.1
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
                CompositionLocalConsumerModifierNodeKt.currentValueOf(ScrollableNode.this, CompositionLocalsKt.getLocalDensity());
            }
        });
        this.scrollConfig = AndroidScrollable_androidKt.platformScrollConfig(this);
    }

    @Override // androidx.compose.p001ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        updateDefaultFlingBehavior();
    }

    private final void updateDefaultFlingBehavior() {
        Density density = (Density) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalDensity());
        this.defaultFlingBehavior.setFlingDecay(SplineBasedDecayKt.splineBasedDecay(density));
    }

    @Override // androidx.compose.p001ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setCanFocus(false);
    }

    @Override // androidx.compose.p001ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo */
    public boolean mo426onKeyEventZmokQxo(KeyEvent event) {
        float xAmount;
        long scrollAmount;
        float yAmount;
        if (getEnabled() && ((Key.m5061equalsimpl0(KeyEvent_androidKt.m5369getKeyZmokQxo(event), Key.INSTANCE.m5249getPageDownEK5gGoQ()) || Key.m5061equalsimpl0(KeyEvent_androidKt.m5369getKeyZmokQxo(event), Key.INSTANCE.m5250getPageUpEK5gGoQ())) && KeyEventType.m5362equalsimpl0(KeyEvent_androidKt.m5370getTypeZmokQxo(event), KeyEventType.INSTANCE.m5366getKeyDownCS__XNY()) && !KeyEvent_androidKt.m5373isCtrlPressedZmokQxo(event))) {
            if (this.scrollingLogic.isVertical()) {
                int viewportHeight = IntSize.m6974getHeightimpl(this.contentInViewNode.getViewportSize());
                if (Key.m5061equalsimpl0(KeyEvent_androidKt.m5369getKeyZmokQxo(event), Key.INSTANCE.m5250getPageUpEK5gGoQ())) {
                    yAmount = viewportHeight;
                } else {
                    yAmount = -viewportHeight;
                }
                scrollAmount = OffsetKt.Offset(0.0f, yAmount);
            } else {
                int viewportWidth = IntSize.m6975getWidthimpl(this.contentInViewNode.getViewportSize());
                if (Key.m5061equalsimpl0(KeyEvent_androidKt.m5369getKeyZmokQxo(event), Key.INSTANCE.m5250getPageUpEK5gGoQ())) {
                    xAmount = viewportWidth;
                } else {
                    xAmount = -viewportWidth;
                }
                scrollAmount = OffsetKt.Offset(xAmount, 0.0f);
            }
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new ScrollableNode$onKeyEvent$1(this, scrollAmount, null), 3, null);
            return true;
        }
        return false;
    }

    @Override // androidx.compose.p001ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo */
    public boolean mo428onPreKeyEventZmokQxo(KeyEvent event) {
        return false;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode, androidx.compose.p001ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo427onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        super.mo427onPointerEventH0pRuoY(pointerEvent, pass, bounds);
        if (pass == PointerEventPass.Main && PointerEventType.m5459equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m5468getScroll7fucELk())) {
            m671processMouseWheelEventO0kMr_c(pointerEvent, bounds);
        }
    }

    /* JADX INFO: renamed from: processMouseWheelEvent-O0kMr_c, reason: not valid java name */
    private final void m671processMouseWheelEventO0kMr_c(PointerEvent event, long size) {
        boolean z;
        List<PointerInputChange> changes = event.getChanges();
        int index$iv$iv = 0;
        int size2 = changes.size();
        while (true) {
            z = true;
            if (index$iv$iv >= size2) {
                break;
            }
            Object item$iv$iv = changes.get(index$iv$iv);
            PointerInputChange it = (PointerInputChange) item$iv$iv;
            if (!(true ^ it.isConsumed())) {
                z = false;
                break;
            }
            index$iv$iv++;
        }
        if (z) {
            ScrollConfig $this$processMouseWheelEvent_O0kMr_c_u24lambda_u242 = this.scrollConfig;
            Intrinsics.checkNotNull($this$processMouseWheelEvent_O0kMr_c_u24lambda_u242);
            long scrollAmount = $this$processMouseWheelEvent_O0kMr_c_u24lambda_u242.mo584calculateMouseWheelScroll8xgXZGE(DelegatableNodeKt.requireDensity(this), event, size);
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new ScrollableNode$processMouseWheelEvent$2$1(this, scrollAmount, null), 3, null);
            List<PointerInputChange> changes2 = event.getChanges();
            int size3 = changes2.size();
            for (int index$iv = 0; index$iv < size3; index$iv++) {
                Object item$iv = changes2.get(index$iv);
                PointerInputChange it2 = (PointerInputChange) item$iv;
                it2.consume();
            }
        }
    }
}
