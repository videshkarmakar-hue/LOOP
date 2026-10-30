package androidx.compose.p001ui.layout;

import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.node.NodeMeasuringIntrinsics;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: LookaheadScope.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B{\u0012A\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f\u0012\u001d\u0010\u0012\u001a\u0019\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u0016J\u001a\u0010\u000e\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J&\u0010$\u001a\u00020\f*\u00020\u00052\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u0014\u0010\u0012\u001a\u00020\u0011*\u00020\u00142\u0006\u0010'\u001a\u00020\u0015H\u0016R&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0017\"\u0004\b\u0018\u0010\u0019R1\u0010\u0012\u001a\u0019\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u001a\"\u0004\b\u001b\u0010\u001cRU\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, m195d2 = {"Landroidx/compose/ui/layout/ApproachLayoutModifierNodeImpl;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "measureBlock", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Lkotlin/ParameterName;", "name", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "isMeasurementApproachComplete", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "isPlacementApproachComplete", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "()Lkotlin/jvm/functions/Function1;", "setMeasurementApproachComplete", "(Lkotlin/jvm/functions/Function1;)V", "()Lkotlin/jvm/functions/Function2;", "setPlacementApproachComplete", "(Lkotlin/jvm/functions/Function2;)V", "getMeasureBlock", "()Lkotlin/jvm/functions/Function3;", "setMeasureBlock", "(Lkotlin/jvm/functions/Function3;)V", "lookaheadSize", "isMeasurementApproachComplete-ozmzZPI", "(J)Z", "approachMeasure", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "lookaheadCoordinates", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class ApproachLayoutModifierNodeImpl extends Modifier.Node implements ApproachLayoutModifierNode {
    private Function1<? super IntSize, Boolean> isMeasurementApproachComplete;
    private Function2<? super Placeable.PlacementScope, ? super LayoutCoordinates, Boolean> isPlacementApproachComplete;
    private Function3<? super ApproachMeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> measureBlock;

    @Override // androidx.compose.p001ui.layout.ApproachLayoutModifierNode
    public /* synthetic */ int maxApproachIntrinsicHeight(ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.maxHeight$ui_release(new NodeMeasuringIntrinsics.ApproachMeasureBlock() { // from class: androidx.compose.ui.layout.ApproachLayoutModifierNode.maxApproachIntrinsicHeight.1
            C17761() {
            }

            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.ApproachMeasureBlock
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo5619measure3p2s80s(ApproachMeasureScope $this$ApproachMeasureBlock, Measurable intrinsicMeasurable2, long constraints) {
                return ApproachLayoutModifierNode.this.mo5616approachMeasure3p2s80s($this$ApproachMeasureBlock, intrinsicMeasurable2, constraints);
            }
        }, approachIntrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p001ui.layout.ApproachLayoutModifierNode
    public /* synthetic */ int maxApproachIntrinsicWidth(ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.maxWidth$ui_release(new NodeMeasuringIntrinsics.ApproachMeasureBlock() { // from class: androidx.compose.ui.layout.ApproachLayoutModifierNode.maxApproachIntrinsicWidth.1
            C17771() {
            }

            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.ApproachMeasureBlock
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo5619measure3p2s80s(ApproachMeasureScope $this$ApproachMeasureBlock, Measurable intrinsicMeasurable2, long constraints) {
                return ApproachLayoutModifierNode.this.mo5616approachMeasure3p2s80s($this$ApproachMeasureBlock, intrinsicMeasurable2, constraints);
            }
        }, approachIntrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.maxHeight$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode.maxIntrinsicHeight.1
            /* JADX INFO: Access modifiers changed from: package-private */
            public C18111() {
            }

            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo5788measure3p2s80s(MeasureScope $this$maxHeight, Measurable intrinsicMeasurable2, long constraints) {
                return LayoutModifierNode.this.mo337measure3p2s80s($this$maxHeight, intrinsicMeasurable2, constraints);
            }
        }, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.maxWidth$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode.maxIntrinsicWidth.1
            /* JADX INFO: Access modifiers changed from: package-private */
            public C18121() {
            }

            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo5788measure3p2s80s(MeasureScope $this$maxWidth, Measurable intrinsicMeasurable2, long constraints) {
                return LayoutModifierNode.this.mo337measure3p2s80s($this$maxWidth, intrinsicMeasurable2, constraints);
            }
        }, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p001ui.layout.ApproachLayoutModifierNode, androidx.compose.p001ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public /* synthetic */ MeasureResult mo337measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        return ApproachLayoutModifierNode.CC.m5618$default$measure3p2s80s(this, measureScope, measurable, j);
    }

    @Override // androidx.compose.p001ui.layout.ApproachLayoutModifierNode
    public /* synthetic */ int minApproachIntrinsicHeight(ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.minHeight$ui_release(new NodeMeasuringIntrinsics.ApproachMeasureBlock() { // from class: androidx.compose.ui.layout.ApproachLayoutModifierNode.minApproachIntrinsicHeight.1
            C17781() {
            }

            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.ApproachMeasureBlock
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo5619measure3p2s80s(ApproachMeasureScope $this$ApproachMeasureBlock, Measurable intrinsicMeasurable2, long constraints) {
                return ApproachLayoutModifierNode.this.mo5616approachMeasure3p2s80s($this$ApproachMeasureBlock, intrinsicMeasurable2, constraints);
            }
        }, approachIntrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p001ui.layout.ApproachLayoutModifierNode
    public /* synthetic */ int minApproachIntrinsicWidth(ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.minWidth$ui_release(new NodeMeasuringIntrinsics.ApproachMeasureBlock() { // from class: androidx.compose.ui.layout.ApproachLayoutModifierNode.minApproachIntrinsicWidth.1
            C17791() {
            }

            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.ApproachMeasureBlock
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo5619measure3p2s80s(ApproachMeasureScope $this$ApproachMeasureBlock, Measurable intrinsicMeasurable2, long constraints) {
                return ApproachLayoutModifierNode.this.mo5616approachMeasure3p2s80s($this$ApproachMeasureBlock, intrinsicMeasurable2, constraints);
            }
        }, approachIntrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.minHeight$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode.minIntrinsicHeight.1
            /* JADX INFO: Access modifiers changed from: package-private */
            public C18131() {
            }

            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo5788measure3p2s80s(MeasureScope $this$minHeight, Measurable intrinsicMeasurable2, long constraints) {
                return LayoutModifierNode.this.mo337measure3p2s80s($this$minHeight, intrinsicMeasurable2, constraints);
            }
        }, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.minWidth$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode.minIntrinsicWidth.1
            /* JADX INFO: Access modifiers changed from: package-private */
            public C18141() {
            }

            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo5788measure3p2s80s(MeasureScope $this$minWidth, Measurable intrinsicMeasurable2, long constraints) {
                return LayoutModifierNode.this.mo337measure3p2s80s($this$minWidth, intrinsicMeasurable2, constraints);
            }
        }, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public final Function3<ApproachMeasureScope, Measurable, Constraints, MeasureResult> getMeasureBlock() {
        return this.measureBlock;
    }

    public final void setMeasureBlock(Function3<? super ApproachMeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> function3) {
        this.measureBlock = function3;
    }

    public final Function1<IntSize, Boolean> isMeasurementApproachComplete() {
        return this.isMeasurementApproachComplete;
    }

    public final void setMeasurementApproachComplete(Function1<? super IntSize, Boolean> function1) {
        this.isMeasurementApproachComplete = function1;
    }

    public final Function2<Placeable.PlacementScope, LayoutCoordinates, Boolean> isPlacementApproachComplete() {
        return this.isPlacementApproachComplete;
    }

    public final void setPlacementApproachComplete(Function2<? super Placeable.PlacementScope, ? super LayoutCoordinates, Boolean> function2) {
        this.isPlacementApproachComplete = function2;
    }

    public ApproachLayoutModifierNodeImpl(Function3<? super ApproachMeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> function3, Function1<? super IntSize, Boolean> function1, Function2<? super Placeable.PlacementScope, ? super LayoutCoordinates, Boolean> function2) {
        this.measureBlock = function3;
        this.isMeasurementApproachComplete = function1;
        this.isPlacementApproachComplete = function2;
    }

    @Override // androidx.compose.p001ui.layout.ApproachLayoutModifierNode
    /* JADX INFO: renamed from: isMeasurementApproachComplete-ozmzZPI */
    public boolean mo5617isMeasurementApproachCompleteozmzZPI(long lookaheadSize) {
        return this.isMeasurementApproachComplete.invoke(IntSize.m6967boximpl(lookaheadSize)).booleanValue();
    }

    @Override // androidx.compose.p001ui.layout.ApproachLayoutModifierNode
    public boolean isPlacementApproachComplete(Placeable.PlacementScope $this$isPlacementApproachComplete, LayoutCoordinates lookaheadCoordinates) {
        return this.isPlacementApproachComplete.invoke($this$isPlacementApproachComplete, lookaheadCoordinates).booleanValue();
    }

    @Override // androidx.compose.p001ui.layout.ApproachLayoutModifierNode
    /* JADX INFO: renamed from: approachMeasure-3p2s80s */
    public MeasureResult mo5616approachMeasure3p2s80s(ApproachMeasureScope $this$approachMeasure_u2d3p2s80s, Measurable measurable, long constraints) {
        return this.measureBlock.invoke($this$approachMeasure_u2d3p2s80s, measurable, Constraints.m6732boximpl(constraints));
    }
}
