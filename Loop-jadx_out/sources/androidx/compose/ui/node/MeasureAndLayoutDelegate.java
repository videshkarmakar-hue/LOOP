package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Constraints;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MeasureAndLayoutDelegate.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0000\u0018\u00002\u00020\u0001:\u0001QB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020(2\b\b\u0002\u0010*\u001a\u00020\bJ\"\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u00032\b\u0010-\u001a\u0004\u0018\u00010\u001dH\u0002ø\u0001\u0000¢\u0006\u0002\b.J\"\u0010/\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u00032\b\u0010-\u001a\u0004\u0018\u00010\u001dH\u0002ø\u0001\u0000¢\u0006\u0002\b0J\b\u00101\u001a\u00020(H\u0002J\u0010\u00102\u001a\u00020(2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0016\u00103\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00032\u0006\u00104\u001a\u00020\bJ\u0018\u00105\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00032\u0006\u00104\u001a\u00020\bH\u0002J\u0018\u00106\u001a\u00020\b2\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020(\u0018\u000108J \u00106\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u001dø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u0006\u0010;\u001a\u00020(J\u000e\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020\u0003J\u0018\u0010>\u001a\u00020(2\u0006\u0010=\u001a\u00020\u00032\u0006\u00104\u001a\u00020\bH\u0002J\u0017\u0010?\u001a\u00020(2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020(08H\u0082\bJ\u000e\u0010A\u001a\u00020(2\u0006\u0010B\u001a\u00020\u0015J$\u0010C\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u00032\b\b\u0002\u00104\u001a\u00020\b2\b\b\u0002\u0010D\u001a\u00020\bH\u0002J\u0010\u0010E\u001a\u00020(2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0018\u0010F\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00032\u0006\u00104\u001a\u00020\bH\u0002J\u0018\u0010G\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u00032\b\b\u0002\u0010H\u001a\u00020\bJ\u0018\u0010I\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u00032\b\b\u0002\u0010H\u001a\u00020\bJ\u000e\u0010J\u001a\u00020(2\u0006\u0010,\u001a\u00020\u0003J\u0018\u0010K\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u00032\b\b\u0002\u0010H\u001a\u00020\bJ\u0018\u0010L\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u00032\b\b\u0002\u0010H\u001a\u00020\bJ\u0018\u0010M\u001a\u00020(2\u0006\u0010-\u001a\u00020\u001dø\u0001\u0000¢\u0006\u0004\bN\u0010OJ\u0014\u0010P\u001a\u00020\b*\u00020\u00032\u0006\u00104\u001a\u00020\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0018\u0010\u001e\u001a\u00020\b*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u00020\b*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0018\u0010#\u001a\u00020\b*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010 R\u0018\u0010%\u001a\u00020\b*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010 \u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006R"}, d2 = {"Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "consistencyChecker", "Landroidx/compose/ui/node/LayoutTreeConsistencyChecker;", "duringMeasureLayout", "", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "hasPendingOnPositionedCallbacks", "getHasPendingOnPositionedCallbacks", "<set-?>", "", "measureIteration", "getMeasureIteration", "()J", "onLayoutCompletedListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "onPositionedDispatcher", "Landroidx/compose/ui/node/OnPositionedDispatcher;", "postponedMeasureRequests", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "relayoutNodes", "Landroidx/compose/ui/node/DepthSortedSetsForDifferentPasses;", "rootConstraints", "Landroidx/compose/ui/unit/Constraints;", "canAffectParent", "getCanAffectParent", "(Landroidx/compose/ui/node/LayoutNode;)Z", "canAffectParentInLookahead", "getCanAffectParentInLookahead", "measureAffectsParent", "getMeasureAffectsParent", "measureAffectsParentLookahead", "getMeasureAffectsParentLookahead", "callOnLayoutCompletedListeners", "", "dispatchOnPositionedCallbacks", "forceDispatch", "doLookaheadRemeasure", "layoutNode", "constraints", "doLookaheadRemeasure-sdFAvZA", "doRemeasure", "doRemeasure-sdFAvZA", "drainPostponedMeasureRequests", "ensureSubtreeLookaheadReplaced", "forceMeasureTheSubtree", "affectsLookahead", "forceMeasureTheSubtreeInternal", "measureAndLayout", "onLayout", "Lkotlin/Function0;", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "measureOnly", "onNodeDetached", "node", "onlyRemeasureIfScheduled", "performMeasureAndLayout", "block", "registerOnLayoutCompletedListener", "listener", "remeasureAndRelayoutIfNeeded", "relayoutNeeded", "remeasureLookaheadRootsInSubtree", "remeasureOnly", "requestLookaheadRelayout", "forced", "requestLookaheadRemeasure", "requestOnPositionedCallback", "requestRelayout", "requestRemeasure", "updateRootConstraints", "updateRootConstraints-BRTryo0", "(J)V", "measurePending", "PostponedRequest", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MeasureAndLayoutDelegate {
    public static final int $stable = 8;
    private final LayoutTreeConsistencyChecker consistencyChecker;
    private boolean duringMeasureLayout;
    private final LayoutNode root;
    private Constraints rootConstraints;
    private final DepthSortedSetsForDifferentPasses relayoutNodes = new DepthSortedSetsForDifferentPasses(Owner.INSTANCE.getEnableExtraAssertions());
    private final OnPositionedDispatcher onPositionedDispatcher = new OnPositionedDispatcher();
    private final MutableVector<Owner.OnLayoutCompletedListener> onLayoutCompletedListeners = new MutableVector<>(new Owner.OnLayoutCompletedListener[16], 0);
    private long measureIteration = 1;
    private final MutableVector<PostponedRequest> postponedMeasureRequests = new MutableVector<>(new PostponedRequest[16], 0);

    /* JADX INFO: compiled from: MeasureAndLayoutDelegate.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            try {
                iArr[LayoutNode.LayoutState.LookaheadMeasuring.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[LayoutNode.LayoutState.Idle.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MeasureAndLayoutDelegate(LayoutNode root) {
        LayoutTreeConsistencyChecker layoutTreeConsistencyChecker;
        this.root = root;
        if (Owner.INSTANCE.getEnableExtraAssertions()) {
            layoutTreeConsistencyChecker = new LayoutTreeConsistencyChecker(this.root, this.relayoutNodes, this.postponedMeasureRequests.asMutableList());
        } else {
            layoutTreeConsistencyChecker = null;
        }
        this.consistencyChecker = layoutTreeConsistencyChecker;
    }

    public final boolean getHasPendingMeasureOrLayout() {
        return this.relayoutNodes.isNotEmpty();
    }

    public final boolean getHasPendingOnPositionedCallbacks() {
        return this.onPositionedDispatcher.isNotEmpty();
    }

    public final long getMeasureIteration() {
        boolean value$iv = this.duringMeasureLayout;
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalArgumentException("measureIteration should be only used during the measure/layout pass");
        }
        return this.measureIteration;
    }

    /* JADX INFO: renamed from: updateRootConstraints-BRTryo0, reason: not valid java name */
    public final void m5585updateRootConstraintsBRTryo0(long constraints) {
        Constraints constraints2 = this.rootConstraints;
        if (!(constraints2 == null ? false : Constraints.m6489equalsimpl0(constraints2.getValue(), constraints))) {
            boolean value$iv = !this.duringMeasureLayout;
            if (!value$iv) {
                InlineClassHelperKt.throwIllegalArgumentException("updateRootConstraints called while measuring");
            }
            this.rootConstraints = Constraints.m6484boximpl(constraints);
            if (this.root.getLookaheadRoot() != null) {
                this.root.markLookaheadMeasurePending$ui_release();
            }
            this.root.markMeasurePending$ui_release();
            this.relayoutNodes.add(this.root, this.root.getLookaheadRoot() != null);
        }
    }

    public static /* synthetic */ boolean requestLookaheadRemeasure$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, z);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0071  */
    /* JADX WARN: Code duplicated, block: B:36:0x007d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0083  */
    /* JADX WARN: Code duplicated, block: B:41:0x008b  */
    /* JADX WARN: Code duplicated, block: B:43:0x008e  */
    public final boolean requestLookaheadRemeasure(LayoutNode layoutNode, boolean forced) {
        LayoutNode parent$ui_release;
        boolean z;
        boolean value$iv = layoutNode.getLookaheadRoot() != null;
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException("Error: requestLookaheadRemeasure cannot be called on a node outside LookaheadScope");
        }
        switch (WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()]) {
            case 1:
                return false;
            case 2:
            case 3:
            case 4:
                this.postponedMeasureRequests.add(new PostponedRequest(layoutNode, true, forced));
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
                return false;
            case 5:
                if (layoutNode.getLookaheadMeasurePending$ui_release() && !forced) {
                    return false;
                }
                layoutNode.markLookaheadMeasurePending$ui_release();
                layoutNode.markMeasurePending$ui_release();
                if (layoutNode.getIsDeactivated()) {
                    return false;
                }
                if (Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) true) || getCanAffectParentInLookahead(layoutNode)) {
                    LayoutNode parent$ui_release2 = layoutNode.getParent$ui_release();
                    if (!(parent$ui_release2 != null && parent$ui_release2.getLookaheadMeasurePending$ui_release())) {
                        this.relayoutNodes.add(layoutNode, true);
                    } else if (!layoutNode.isPlaced() || getCanAffectParent(layoutNode)) {
                        parent$ui_release = layoutNode.getParent$ui_release();
                        if (parent$ui_release == null && parent$ui_release.getMeasurePending$ui_release()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            this.relayoutNodes.add(layoutNode, false);
                        }
                    }
                } else if (!layoutNode.isPlaced()) {
                    parent$ui_release = layoutNode.getParent$ui_release();
                    if (parent$ui_release == null) {
                        z = false;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        this.relayoutNodes.add(layoutNode, false);
                    }
                } else {
                    parent$ui_release = layoutNode.getParent$ui_release();
                    if (parent$ui_release == null) {
                        z = false;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        this.relayoutNodes.add(layoutNode, false);
                    }
                }
                return !this.duringMeasureLayout;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ boolean requestRemeasure$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return measureAndLayoutDelegate.requestRemeasure(layoutNode, z);
    }

    public final boolean requestRemeasure(LayoutNode layoutNode, boolean forced) {
        switch (WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()]) {
            case 1:
            case 2:
                return false;
            case 3:
            case 4:
                this.postponedMeasureRequests.add(new PostponedRequest(layoutNode, false, forced));
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker == null) {
                    return false;
                }
                layoutTreeConsistencyChecker.assertConsistent();
                return false;
            case 5:
                if (layoutNode.getMeasurePending$ui_release() && !forced) {
                    return false;
                }
                layoutNode.markMeasurePending$ui_release();
                if (layoutNode.getIsDeactivated()) {
                    return false;
                }
                if (layoutNode.isPlaced() || getCanAffectParent(layoutNode)) {
                    LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                    if (!(parent$ui_release != null && parent$ui_release.getMeasurePending$ui_release())) {
                        this.relayoutNodes.add(layoutNode, false);
                    }
                }
                return !this.duringMeasureLayout;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ boolean requestLookaheadRelayout$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, z);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x006e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0074  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    /* JADX WARN: Code duplicated, block: B:39:0x007e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0081  */
    /* JADX WARN: Code duplicated, block: B:42:0x0083  */
    /* JADX WARN: Code duplicated, block: B:45:0x008b  */
    /* JADX WARN: Code duplicated, block: B:47:0x008e  */
    public final boolean requestLookaheadRelayout(LayoutNode layoutNode, boolean forced) {
        boolean z;
        boolean z2;
        switch (WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()]) {
            case 1:
            case 3:
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker == null) {
                    return false;
                }
                layoutTreeConsistencyChecker.assertConsistent();
                return false;
            case 2:
            case 4:
            case 5:
                if ((layoutNode.getLookaheadMeasurePending$ui_release() || layoutNode.getLookaheadLayoutPending$ui_release()) && !forced) {
                    LayoutTreeConsistencyChecker layoutTreeConsistencyChecker2 = this.consistencyChecker;
                    if (layoutTreeConsistencyChecker2 == null) {
                        return false;
                    }
                    layoutTreeConsistencyChecker2.assertConsistent();
                    return false;
                }
                layoutNode.markLookaheadLayoutPending$ui_release();
                layoutNode.markLayoutPending$ui_release();
                if (layoutNode.getIsDeactivated()) {
                    return false;
                }
                LayoutNode parent = layoutNode.getParent$ui_release();
                if (Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) true)) {
                    if (!(parent != null && parent.getLookaheadMeasurePending$ui_release())) {
                        if (!(parent != null && parent.getLookaheadLayoutPending$ui_release())) {
                            this.relayoutNodes.add(layoutNode, true);
                        } else if (layoutNode.isPlaced()) {
                            if (parent == null) {
                                z = false;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                if (parent == null) {
                                    z2 = false;
                                } else {
                                    z2 = false;
                                }
                                if (!z2) {
                                    this.relayoutNodes.add(layoutNode, false);
                                }
                            }
                        }
                    } else if (layoutNode.isPlaced()) {
                        if (parent == null) {
                            z = false;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            if (parent == null) {
                                z2 = false;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                this.relayoutNodes.add(layoutNode, false);
                            }
                        }
                    }
                } else if (layoutNode.isPlaced()) {
                    if (parent == null && parent.getLayoutPending$ui_release()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if (parent == null && parent.getMeasurePending$ui_release()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            this.relayoutNodes.add(layoutNode, false);
                        }
                    }
                }
                return !this.duringMeasureLayout;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ boolean requestRelayout$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return measureAndLayoutDelegate.requestRelayout(layoutNode, z);
    }

    public final boolean requestRelayout(LayoutNode layoutNode, boolean forced) {
        switch (WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker == null) {
                    return false;
                }
                layoutTreeConsistencyChecker.assertConsistent();
                return false;
            case 5:
                if (!forced && layoutNode.isPlaced() == layoutNode.isPlacedByParent() && (layoutNode.getMeasurePending$ui_release() || layoutNode.getLayoutPending$ui_release())) {
                    LayoutTreeConsistencyChecker layoutTreeConsistencyChecker2 = this.consistencyChecker;
                    if (layoutTreeConsistencyChecker2 == null) {
                        return false;
                    }
                    layoutTreeConsistencyChecker2.assertConsistent();
                    return false;
                }
                layoutNode.markLayoutPending$ui_release();
                if (layoutNode.getIsDeactivated()) {
                    return false;
                }
                if (layoutNode.isPlacedByParent()) {
                    LayoutNode parent = layoutNode.getParent$ui_release();
                    if (!(parent != null && parent.getLayoutPending$ui_release())) {
                        if (!(parent != null && parent.getMeasurePending$ui_release())) {
                            this.relayoutNodes.add(layoutNode, false);
                        }
                    }
                }
                return !this.duringMeasureLayout;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void requestOnPositionedCallback(LayoutNode layoutNode) {
        this.onPositionedDispatcher.onNodePositioned(layoutNode);
    }

    /* JADX INFO: renamed from: doLookaheadRemeasure-sdFAvZA, reason: not valid java name */
    private final boolean m5582doLookaheadRemeasuresdFAvZA(LayoutNode layoutNode, Constraints constraints) {
        boolean lookaheadSizeChanged;
        if (layoutNode.getLookaheadRoot() == null) {
            return false;
        }
        if (constraints == null) {
            lookaheadSizeChanged = LayoutNode.m5545lookaheadRemeasure_Sx5XlM$ui_release$default(layoutNode, null, 1, null);
        } else {
            lookaheadSizeChanged = layoutNode.m5549lookaheadRemeasure_Sx5XlM$ui_release(constraints);
        }
        LayoutNode parent = layoutNode.getParent$ui_release();
        if (lookaheadSizeChanged && parent != null) {
            if (parent.getLookaheadRoot() == null) {
                requestRemeasure$default(this, parent, false, 2, null);
            } else if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                requestLookaheadRemeasure$default(this, parent, false, 2, null);
            } else if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                requestLookaheadRelayout$default(this, parent, false, 2, null);
            }
        }
        return lookaheadSizeChanged;
    }

    /* JADX INFO: renamed from: doRemeasure-sdFAvZA, reason: not valid java name */
    private final boolean m5583doRemeasuresdFAvZA(LayoutNode layoutNode, Constraints constraints) {
        boolean sizeChanged;
        if (constraints == null) {
            sizeChanged = LayoutNode.m5546remeasure_Sx5XlM$ui_release$default(layoutNode, null, 1, null);
        } else {
            sizeChanged = layoutNode.m5550remeasure_Sx5XlM$ui_release(constraints);
        }
        LayoutNode parent = layoutNode.getParent$ui_release();
        if (sizeChanged && parent != null) {
            if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                requestRemeasure$default(this, parent, false, 2, null);
            } else if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                requestRelayout$default(this, parent, false, 2, null);
            }
        }
        return sizeChanged;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean measureAndLayout$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return measureAndLayoutDelegate.measureAndLayout(function0);
    }

    public final boolean measureAndLayout(Function0<Unit> onLayout) throws Throwable {
        boolean rootNodeResized = false;
        boolean value$iv$iv = this.root.isAttached();
        if (!value$iv$iv) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
        }
        boolean value$iv$iv2 = this.root.isPlaced();
        if (!value$iv$iv2) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
        }
        boolean value$iv$iv3 = this.duringMeasureLayout;
        if (!(!value$iv$iv3)) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
        }
        if (this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            try {
                if (this.relayoutNodes.isNotEmpty()) {
                    DepthSortedSetsForDifferentPasses this_$iv = this.relayoutNodes;
                    boolean rootNodeResized2 = false;
                    while (this_$iv.isNotEmpty()) {
                        try {
                            DepthSortedSet this_$iv$iv = this_$iv.lookaheadSet;
                            boolean affectsLookahead$iv = !this_$iv$iv.isEmpty();
                            LayoutNode node$iv = (affectsLookahead$iv ? this_$iv.lookaheadSet : this_$iv.set).pop();
                            boolean sizeChanged = remeasureAndRelayoutIfNeeded$default(this, node$iv, affectsLookahead$iv, false, 4, null);
                            if (node$iv == this.root && sizeChanged) {
                                rootNodeResized2 = true;
                            }
                        } catch (Throwable th) {
                            th = th;
                            this.duringMeasureLayout = false;
                            throw th;
                        }
                    }
                    if (onLayout != null) {
                        onLayout.invoke();
                    }
                    rootNodeResized = rootNodeResized2;
                }
                this.duringMeasureLayout = false;
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        callOnLayoutCompletedListeners();
        return rootNodeResized;
    }

    public final void measureOnly() {
        if (this.relayoutNodes.isNotEmpty()) {
            boolean value$iv$iv = this.root.isAttached();
            if (!value$iv$iv) {
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
            }
            boolean value$iv$iv2 = this.root.isPlaced();
            if (!value$iv$iv2) {
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
            }
            boolean value$iv$iv3 = this.duringMeasureLayout;
            if (!(!value$iv$iv3)) {
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
            }
            if (this.rootConstraints != null) {
                this.duringMeasureLayout = true;
                try {
                    if (!this.relayoutNodes.isEmpty(true)) {
                        if (this.root.getLookaheadRoot() != null) {
                            remeasureOnly(this.root, true);
                        } else {
                            remeasureLookaheadRootsInSubtree(this.root);
                        }
                    }
                    remeasureOnly(this.root, false);
                    this.duringMeasureLayout = false;
                    LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                    if (layoutTreeConsistencyChecker != null) {
                        layoutTreeConsistencyChecker.assertConsistent();
                    }
                } catch (Throwable th) {
                    this.duringMeasureLayout = false;
                    throw th;
                }
            }
        }
    }

    private final void remeasureLookaheadRootsInSubtree(LayoutNode layoutNode) {
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size$iv$iv = mutableVector.getSize();
        if (size$iv$iv <= 0) {
            return;
        }
        int i$iv$iv = 0;
        Object[] content$iv$iv = mutableVector.getContent();
        do {
            LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
            if (getMeasureAffectsParent(it)) {
                if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(it)) {
                    remeasureOnly(it, true);
                } else {
                    remeasureLookaheadRootsInSubtree(it);
                }
            }
            i$iv$iv++;
        } while (i$iv$iv < size$iv$iv);
    }

    /* JADX INFO: renamed from: measureAndLayout-0kLqBqw, reason: not valid java name */
    public final void m5584measureAndLayout0kLqBqw(LayoutNode layoutNode, long constraints) {
        if (layoutNode.getIsDeactivated()) {
            return;
        }
        boolean value$iv = !Intrinsics.areEqual(layoutNode, this.root);
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalArgumentException("measureAndLayout called on root");
        }
        boolean value$iv$iv = this.root.isAttached();
        if (!value$iv$iv) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
        }
        boolean value$iv$iv2 = this.root.isPlaced();
        if (!value$iv$iv2) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
        }
        boolean value$iv$iv3 = this.duringMeasureLayout;
        if (!(!value$iv$iv3)) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
        }
        if (this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            try {
                this.relayoutNodes.remove(layoutNode);
                boolean lookaheadSizeChanged = m5582doLookaheadRemeasuresdFAvZA(layoutNode, Constraints.m6484boximpl(constraints));
                if ((lookaheadSizeChanged || layoutNode.getLookaheadLayoutPending$ui_release()) && Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) true)) {
                    layoutNode.lookaheadReplace$ui_release();
                }
                ensureSubtreeLookaheadReplaced(layoutNode);
                m5583doRemeasuresdFAvZA(layoutNode, Constraints.m6484boximpl(constraints));
                if (layoutNode.getLayoutPending$ui_release() && layoutNode.isPlaced()) {
                    layoutNode.replace$ui_release();
                    this.onPositionedDispatcher.onNodePositioned(layoutNode);
                }
                drainPostponedMeasureRequests();
                this.duringMeasureLayout = false;
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            } catch (Throwable th) {
                this.duringMeasureLayout = false;
                throw th;
            }
        }
        callOnLayoutCompletedListeners();
    }

    private final void ensureSubtreeLookaheadReplaced(LayoutNode layoutNode) {
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size$iv$iv = mutableVector.getSize();
        if (size$iv$iv <= 0) {
            return;
        }
        int i$iv$iv = 0;
        Object[] content$iv$iv = mutableVector.getContent();
        do {
            LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
            if (Intrinsics.areEqual((Object) it.isPlacedInLookahead(), (Object) true) && !it.getIsDeactivated()) {
                if (this.relayoutNodes.contains(it, true)) {
                    it.lookaheadReplace$ui_release();
                }
                ensureSubtreeLookaheadReplaced(it);
            }
            i$iv$iv++;
        } while (i$iv$iv < size$iv$iv);
    }

    private final void performMeasureAndLayout(Function0<Unit> block) {
        boolean value$iv = this.root.isAttached();
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
        }
        boolean value$iv2 = this.root.isPlaced();
        if (!value$iv2) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
        }
        boolean value$iv3 = this.duringMeasureLayout;
        if (!(!value$iv3)) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
        }
        if (this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            try {
                block.invoke();
                InlineMarker.finallyStart(1);
                this.duringMeasureLayout = false;
                InlineMarker.finallyEnd(1);
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                this.duringMeasureLayout = false;
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
    }

    public final void registerOnLayoutCompletedListener(Owner.OnLayoutCompletedListener listener) {
        this.onLayoutCompletedListeners.add(listener);
    }

    private final void callOnLayoutCompletedListeners() {
        MutableVector<Owner.OnLayoutCompletedListener> mutableVector = this.onLayoutCompletedListeners;
        int size$iv = mutableVector.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = mutableVector.getContent();
            do {
                Owner.OnLayoutCompletedListener it = (Owner.OnLayoutCompletedListener) content$iv[i$iv];
                it.onLayoutComplete();
                i$iv++;
            } while (i$iv < size$iv);
        }
        this.onLayoutCompletedListeners.clear();
    }

    static /* synthetic */ boolean remeasureAndRelayoutIfNeeded$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return measureAndLayoutDelegate.remeasureAndRelayoutIfNeeded(layoutNode, z, z2);
    }

    private final boolean remeasureAndRelayoutIfNeeded(LayoutNode layoutNode, boolean affectsLookahead, boolean relayoutNeeded) {
        Constraints constraints;
        boolean sizeChanged = false;
        if (layoutNode.getIsDeactivated()) {
            return false;
        }
        boolean isPlacedByPlacedParent = true;
        if (layoutNode.isPlaced() || layoutNode.isPlacedByParent() || getCanAffectParent(layoutNode) || Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) true) || getCanAffectParentInLookahead(layoutNode) || layoutNode.getAlignmentLinesRequired$ui_release()) {
            if (layoutNode == this.root) {
                constraints = this.rootConstraints;
                Intrinsics.checkNotNull(constraints);
            } else {
                constraints = null;
            }
            if (affectsLookahead) {
                if (layoutNode.getLookaheadMeasurePending$ui_release()) {
                    sizeChanged = m5582doLookaheadRemeasuresdFAvZA(layoutNode, constraints);
                }
                if (relayoutNeeded && ((sizeChanged || layoutNode.getLookaheadLayoutPending$ui_release()) && Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) true))) {
                    layoutNode.lookaheadReplace$ui_release();
                }
            } else {
                if (layoutNode.getMeasurePending$ui_release()) {
                    sizeChanged = m5583doRemeasuresdFAvZA(layoutNode, constraints);
                }
                if (relayoutNeeded && layoutNode.getLayoutPending$ui_release()) {
                    if (layoutNode != this.root) {
                        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                        if (!(parent$ui_release != null && parent$ui_release.isPlaced()) || !layoutNode.isPlacedByParent()) {
                            isPlacedByPlacedParent = false;
                        }
                    }
                    if (isPlacedByPlacedParent) {
                        if (layoutNode == this.root) {
                            layoutNode.place$ui_release(0, 0);
                        } else {
                            layoutNode.replace$ui_release();
                        }
                        this.onPositionedDispatcher.onNodePositioned(layoutNode);
                        LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                        if (layoutTreeConsistencyChecker != null) {
                            layoutTreeConsistencyChecker.assertConsistent();
                        }
                    }
                }
            }
            drainPostponedMeasureRequests();
        }
        return sizeChanged;
    }

    private final void drainPostponedMeasureRequests() {
        if (this.postponedMeasureRequests.isNotEmpty()) {
            MutableVector<PostponedRequest> mutableVector = this.postponedMeasureRequests;
            int size$iv = mutableVector.getSize();
            if (size$iv > 0) {
                int i$iv = 0;
                Object[] content$iv = mutableVector.getContent();
                do {
                    PostponedRequest request = (PostponedRequest) content$iv[i$iv];
                    if (request.getNode().isAttached()) {
                        if (!request.getIsLookahead()) {
                            requestRemeasure(request.getNode(), request.getIsForced());
                        } else {
                            requestLookaheadRemeasure(request.getNode(), request.getIsForced());
                        }
                    }
                    i$iv++;
                } while (i$iv < size$iv);
            }
            this.postponedMeasureRequests.clear();
        }
    }

    private final void remeasureOnly(LayoutNode layoutNode, boolean affectsLookahead) {
        Constraints constraints;
        if (layoutNode.getIsDeactivated()) {
            return;
        }
        if (layoutNode == this.root) {
            constraints = this.rootConstraints;
            Intrinsics.checkNotNull(constraints);
        } else {
            constraints = null;
        }
        if (affectsLookahead) {
            m5582doLookaheadRemeasuresdFAvZA(layoutNode, constraints);
        } else {
            m5583doRemeasuresdFAvZA(layoutNode, constraints);
        }
    }

    public final void forceMeasureTheSubtree(LayoutNode layoutNode, boolean affectsLookahead) {
        if (this.relayoutNodes.isEmpty(affectsLookahead)) {
            return;
        }
        boolean value$iv = this.duringMeasureLayout;
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException("forceMeasureTheSubtree should be executed during the measureAndLayout pass");
        }
        boolean value$iv2 = measurePending(layoutNode, affectsLookahead);
        if (!(!value$iv2)) {
            InlineClassHelperKt.throwIllegalArgumentException("node not yet measured");
        }
        forceMeasureTheSubtreeInternal(layoutNode, affectsLookahead);
    }

    private final void onlyRemeasureIfScheduled(LayoutNode node, boolean affectsLookahead) {
        if (measurePending(node, affectsLookahead) && this.relayoutNodes.contains(node, affectsLookahead)) {
            remeasureAndRelayoutIfNeeded(node, affectsLookahead, false);
        }
    }

    private final void forceMeasureTheSubtreeInternal(LayoutNode layoutNode, boolean affectsLookahead) {
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size$iv$iv = mutableVector.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = mutableVector.getContent();
            do {
                LayoutNode child = (LayoutNode) content$iv$iv[i$iv$iv];
                if ((!affectsLookahead && getMeasureAffectsParent(child)) || (affectsLookahead && getMeasureAffectsParentLookahead(child))) {
                    if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(child) && !affectsLookahead) {
                        if (child.getLookaheadMeasurePending$ui_release() && this.relayoutNodes.contains(child, true)) {
                            remeasureAndRelayoutIfNeeded(child, true, false);
                        } else {
                            forceMeasureTheSubtree(child, true);
                        }
                    }
                    onlyRemeasureIfScheduled(child, affectsLookahead);
                    if (!measurePending(child, affectsLookahead)) {
                        forceMeasureTheSubtreeInternal(child, affectsLookahead);
                    }
                }
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
        onlyRemeasureIfScheduled(layoutNode, affectsLookahead);
    }

    public static /* synthetic */ void dispatchOnPositionedCallbacks$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z);
    }

    public final void dispatchOnPositionedCallbacks(boolean forceDispatch) {
        if (forceDispatch) {
            this.onPositionedDispatcher.onRootNodePositioned(this.root);
        }
        this.onPositionedDispatcher.dispatch();
    }

    public final void onNodeDetached(LayoutNode node) {
        this.relayoutNodes.remove(node);
        this.onPositionedDispatcher.remove(node);
    }

    private final boolean getMeasureAffectsParent(LayoutNode $this$measureAffectsParent) {
        return $this$measureAffectsParent.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock || $this$measureAffectsParent.getLayoutDelegate().getAlignmentLinesOwner$ui_release().getAlignmentLines().getRequired$ui_release();
    }

    private final boolean getCanAffectParent(LayoutNode $this$canAffectParent) {
        return $this$canAffectParent.getMeasurePending$ui_release() && getMeasureAffectsParent($this$canAffectParent);
    }

    private final boolean getCanAffectParentInLookahead(LayoutNode $this$canAffectParentInLookahead) {
        return $this$canAffectParentInLookahead.getLookaheadMeasurePending$ui_release() && getMeasureAffectsParentLookahead($this$canAffectParentInLookahead);
    }

    private final boolean getMeasureAffectsParentLookahead(LayoutNode $this$measureAffectsParentLookahead) {
        AlignmentLines alignmentLines;
        if ($this$measureAffectsParentLookahead.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
            return true;
        }
        AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = $this$measureAffectsParentLookahead.getLayoutDelegate().getLookaheadAlignmentLinesOwner$ui_release();
        return lookaheadAlignmentLinesOwner$ui_release != null && (alignmentLines = lookaheadAlignmentLinesOwner$ui_release.getAlignmentLines()) != null && alignmentLines.getRequired$ui_release();
    }

    private final boolean measurePending(LayoutNode $this$measurePending, boolean affectsLookahead) {
        return affectsLookahead ? $this$measurePending.getLookaheadMeasurePending$ui_release() : $this$measurePending.getMeasurePending$ui_release();
    }

    /* JADX INFO: compiled from: MeasureAndLayoutDelegate.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "", "node", "Landroidx/compose/ui/node/LayoutNode;", "isLookahead", "", "isForced", "(Landroidx/compose/ui/node/LayoutNode;ZZ)V", "()Z", "getNode", "()Landroidx/compose/ui/node/LayoutNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class PostponedRequest {
        public static final int $stable = 8;
        private final boolean isForced;
        private final boolean isLookahead;
        private final LayoutNode node;

        public PostponedRequest(LayoutNode node, boolean isLookahead, boolean isForced) {
            this.node = node;
            this.isLookahead = isLookahead;
            this.isForced = isForced;
        }

        public final LayoutNode getNode() {
            return this.node;
        }

        /* JADX INFO: renamed from: isForced, reason: from getter */
        public final boolean getIsForced() {
            return this.isForced;
        }

        /* JADX INFO: renamed from: isLookahead, reason: from getter */
        public final boolean getIsLookahead() {
            return this.isLookahead;
        }
    }
}
