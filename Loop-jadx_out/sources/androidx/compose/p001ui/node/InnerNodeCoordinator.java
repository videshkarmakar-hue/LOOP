package androidx.compose.p001ui.node;

import androidx.compose.p001ui.graphics.AndroidPaint_androidKt;
import androidx.compose.p001ui.graphics.Canvas;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.GraphicsLayerScope;
import androidx.compose.p001ui.graphics.Paint;
import androidx.compose.p001ui.graphics.PaintingStyle;
import androidx.compose.p001ui.graphics.layer.GraphicsLayer;
import androidx.compose.p001ui.layout.AlignmentLine;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InnerNodeCoordinator.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 C2\u00020\u0001:\u0002CDB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J:\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013H\u0016J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\u001a\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013H\u0016J\u0010\u0010/\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\b\u00100\u001a\u00020\u0017H\u0002J\u001a\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0016J=\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0019\u0010;\u001a\u0015\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u0017\u0018\u00010<¢\u0006\u0002\b>H\u0014ø\u0001\u0000¢\u0006\u0004\b?\u0010@J*\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010A\u001a\u000205H\u0014ø\u0001\u0000¢\u0006\u0004\b?\u0010BR(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006E"}, m195d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator;", "Landroidx/compose/ui/node/NodeCoordinator;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "<set-?>", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "tail", "Landroidx/compose/ui/node/TailModifierNode;", "getTail$annotations", "()V", "getTail", "()Landroidx/compose/ui/node/TailModifierNode;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "ensureLookaheadDelegateCreated", "", "hitTestChild", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "hitTestChild-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "onAfterPlaceAt", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "layer", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "Companion", "LookaheadDelegateImpl", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class InnerNodeCoordinator extends NodeCoordinator {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Paint innerBoundsPaint;
    private LookaheadDelegate lookaheadDelegate;
    private final TailModifierNode tail;

    public static /* synthetic */ void getTail$annotations() {
    }

    public InnerNodeCoordinator(LayoutNode layoutNode) {
        super(layoutNode);
        this.tail = new TailModifierNode();
        getTail().updateCoordinator$ui_release(this);
        this.lookaheadDelegate = layoutNode.getLookaheadRoot() != null ? new LookaheadDelegateImpl() : null;
    }

    @Override // androidx.compose.p001ui.node.NodeCoordinator
    public TailModifierNode getTail() {
        return this.tail;
    }

    @Override // androidx.compose.p001ui.node.NodeCoordinator
    public LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    @Override // androidx.compose.p001ui.node.NodeCoordinator
    protected void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate) {
        this.lookaheadDelegate = lookaheadDelegate;
    }

    /* JADX INFO: compiled from: InnerNodeCoordinator.kt */
    @Metadata(m194d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0014\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, m195d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator$LookaheadDelegateImpl;", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/InnerNodeCoordinator;)V", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "placeChildren", "", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private final class LookaheadDelegateImpl extends LookaheadDelegate {
        public LookaheadDelegateImpl() {
            super(InnerNodeCoordinator.this);
        }

        @Override // androidx.compose.p001ui.layout.Measurable
        /* JADX INFO: renamed from: measure-BRTryo0 */
        public Placeable mo5644measureBRTryo0(long constraints) {
            LookaheadDelegateImpl this_$iv = this;
            this_$iv.m5705setMeasurementConstraintsBRTryo0(constraints);
            MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
            int size$iv$iv = mutableVector.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = mutableVector.getContent();
                do {
                    LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                    LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = it.getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    lookaheadPassDelegate$ui_release.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
            MeasurePolicy $this$measure_BRTryo0_u24lambda_u242_u24lambda_u241 = getLayoutNode().getMeasurePolicy();
            MeasureResult measureResult = $this$measure_BRTryo0_u24lambda_u242_u24lambda_u241.mo285measure3p2s80s(this, getLayoutNode().getChildLookaheadMeasurables$ui_release(), constraints);
            this_$iv.set_measureResult(measureResult);
            return this_$iv;
        }

        @Override // androidx.compose.p001ui.node.LookaheadCapablePlaceable
        public int calculateAlignmentLine(AlignmentLine alignmentLine) {
            Integer num = getAlignmentLinesOwner().calculateAlignmentLines().get(alignmentLine);
            int iIntValue = num != null ? num.intValue() : Integer.MIN_VALUE;
            int it = iIntValue;
            getCachedAlignmentLinesMap().put(alignmentLine, Integer.valueOf(it));
            return iIntValue;
        }

        @Override // androidx.compose.p001ui.node.LookaheadDelegate
        protected void placeChildren() {
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLayoutNode().getLookaheadPassDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
            lookaheadPassDelegate$ui_release.onNodePlaced$ui_release();
        }

        @Override // androidx.compose.p001ui.node.LookaheadDelegate, androidx.compose.p001ui.layout.IntrinsicMeasurable
        public int minIntrinsicWidth(int height) {
            return getLayoutNode().minLookaheadIntrinsicWidth(height);
        }

        @Override // androidx.compose.p001ui.node.LookaheadDelegate, androidx.compose.p001ui.layout.IntrinsicMeasurable
        public int minIntrinsicHeight(int width) {
            return getLayoutNode().minLookaheadIntrinsicHeight(width);
        }

        @Override // androidx.compose.p001ui.node.LookaheadDelegate, androidx.compose.p001ui.layout.IntrinsicMeasurable
        public int maxIntrinsicWidth(int height) {
            return getLayoutNode().maxLookaheadIntrinsicWidth(height);
        }

        @Override // androidx.compose.p001ui.node.LookaheadDelegate, androidx.compose.p001ui.layout.IntrinsicMeasurable
        public int maxIntrinsicHeight(int width) {
            return getLayoutNode().maxLookaheadIntrinsicHeight(width);
        }
    }

    @Override // androidx.compose.p001ui.node.NodeCoordinator
    public void ensureLookaheadDelegateCreated() {
        if (getLookaheadDelegate() == null) {
            setLookaheadDelegate(new LookaheadDelegateImpl());
        }
    }

    @Override // androidx.compose.p001ui.layout.Measurable
    /* JADX INFO: renamed from: measure-BRTryo0 */
    public Placeable mo5644measureBRTryo0(long constraints) {
        long constraints2;
        if (getForceMeasureWithLookaheadConstraints()) {
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            constraints2 = lookaheadDelegate.m5824getConstraintsmsEJaDk$ui_release();
        } else {
            constraints2 = constraints;
        }
        InnerNodeCoordinator this_$iv = this;
        this_$iv.m5705setMeasurementConstraintsBRTryo0(constraints2);
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        int size$iv$iv = mutableVector.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = mutableVector.getContent();
            while (true) {
                LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                NodeCoordinator this_$iv2 = this_$iv;
                it.getMeasurePassDelegate$ui_release().setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                i$iv$iv++;
                if (i$iv$iv >= size$iv$iv) {
                    break;
                }
                this_$iv = this_$iv2;
            }
        }
        MeasurePolicy $this$measure_BRTryo0_u24lambda_u242_u24lambda_u241 = getLayoutNode().getMeasurePolicy();
        setMeasureResult$ui_release($this$measure_BRTryo0_u24lambda_u242_u24lambda_u241.mo285measure3p2s80s(this, getLayoutNode().getChildMeasurables$ui_release(), constraints2));
        onMeasured();
        return this;
    }

    @Override // androidx.compose.p001ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int height) {
        return getLayoutNode().minIntrinsicWidth(height);
    }

    @Override // androidx.compose.p001ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int width) {
        return getLayoutNode().minIntrinsicHeight(width);
    }

    @Override // androidx.compose.p001ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int height) {
        return getLayoutNode().maxIntrinsicWidth(height);
    }

    @Override // androidx.compose.p001ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int width) {
        return getLayoutNode().maxIntrinsicHeight(width);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.p001ui.node.NodeCoordinator, androidx.compose.p001ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public void mo5703placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) {
        super.mo5703placeAtf8xVGno(position, zIndex, layer);
        onAfterPlaceAt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.p001ui.node.NodeCoordinator, androidx.compose.p001ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public void mo5645placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        super.mo5645placeAtf8xVGno(position, zIndex, layerBlock);
        onAfterPlaceAt();
    }

    private final void onAfterPlaceAt() {
        if (getIsShallowPlacing()) {
            return;
        }
        onPlaced();
        getLayoutNode().getMeasurePassDelegate$ui_release().onNodePlaced$ui_release();
    }

    @Override // androidx.compose.p001ui.node.LookaheadCapablePlaceable
    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
        if (lookaheadDelegate != null) {
            return lookaheadDelegate.calculateAlignmentLine(alignmentLine);
        }
        Integer num = getAlignmentLinesOwner().calculateAlignmentLines().get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.compose.p001ui.node.NodeCoordinator
    public void performDraw(Canvas canvas, GraphicsLayer graphicsLayer) {
        Owner owner = LayoutNodeKt.requireOwner(getLayoutNode());
        MutableVector<LayoutNode> zSortedChildren = getLayoutNode().getZSortedChildren();
        int size$iv = zSortedChildren.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = zSortedChildren.getContent();
            do {
                LayoutNode child = (LayoutNode) content$iv[i$iv];
                if (child.isPlaced()) {
                    child.draw$ui_release(canvas, graphicsLayer);
                }
                i$iv++;
            } while (i$iv < size$iv);
        }
        if (owner.getShowLayoutBounds()) {
            drawBorder(canvas, innerBoundsPaint);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003f  */
    @Override // androidx.compose.p001ui.node.NodeCoordinator
    /* JADX INFO: renamed from: hitTestChild-YqVAtuI, reason: not valid java name */
    public void mo5786hitTestChildYqVAtuI(NodeCoordinator.HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        boolean inLayer;
        boolean hitTestChildren;
        int depth$iv;
        boolean wasHit;
        boolean continueHitTest;
        if (hitTestSource.shouldHitTestChildren(getLayoutNode())) {
            if (m5870withinLayerBoundsk4lQ0M(pointerPosition)) {
                inLayer = isInLayer;
                hitTestChildren = true;
            } else if (isTouchEvent) {
                float f = m5858distanceInMinimumTouchTargettz77jQw(pointerPosition, m5861getMinimumTouchTargetSizeNHjbRc());
                if ((Float.isInfinite(f) || Float.isNaN(f)) ? false : true) {
                    inLayer = false;
                    hitTestChildren = true;
                } else {
                    inLayer = isInLayer;
                    hitTestChildren = false;
                }
            } else {
                inLayer = isInLayer;
                hitTestChildren = false;
            }
        } else {
            inLayer = isInLayer;
            hitTestChildren = false;
        }
        if (hitTestChildren) {
            int depth$iv2 = hitTestResult.hitDepth;
            MutableVector<LayoutNode> zSortedChildren = getLayoutNode().getZSortedChildren();
            int size$iv = zSortedChildren.getSize();
            if (size$iv <= 0) {
                depth$iv = depth$iv2;
            } else {
                int i$iv = size$iv - 1;
                Object[] content$iv = zSortedChildren.getContent();
                int i$iv2 = i$iv;
                while (true) {
                    LayoutNode child = (LayoutNode) content$iv[i$iv2];
                    if (child.isPlaced()) {
                        depth$iv = depth$iv2;
                        hitTestSource.mo5871childHitTestYqVAtuI(child, pointerPosition, hitTestResult, isTouchEvent, inLayer);
                        boolean wasHit2 = hitTestResult.hasHit();
                        if (!wasHit2) {
                            continueHitTest = true;
                        } else if (child.getOuterCoordinator$ui_release().shouldSharePointerInputWithSiblings()) {
                            hitTestResult.acceptHits();
                            continueHitTest = true;
                        } else {
                            continueHitTest = false;
                        }
                        wasHit = !continueHitTest;
                    } else {
                        depth$iv = depth$iv2;
                        wasHit = false;
                    }
                    if (wasHit || (i$iv2 = i$iv2 - 1) < 0) {
                        break;
                    } else {
                        depth$iv2 = depth$iv;
                    }
                }
            }
            hitTestResult.hitDepth = depth$iv;
        }
    }

    /* JADX INFO: compiled from: InnerNodeCoordinator.kt */
    @Metadata(m194d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m195d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator$Companion;", "", "()V", "innerBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getInnerBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Paint getInnerBoundsPaint() {
            return InnerNodeCoordinator.innerBoundsPaint;
        }
    }

    static {
        Paint paint = AndroidPaint_androidKt.Paint();
        paint.mo4170setColor8_81llA(Color.INSTANCE.m4325getRed0d7_KjU());
        paint.setStrokeWidth(1.0f);
        paint.mo4174setStylek9PVt8s(PaintingStyle.INSTANCE.m4566getStrokeTiuSbCo());
        innerBoundsPaint = paint;
    }
}
