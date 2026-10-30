package androidx.compose.p001ui.layout;

import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.node.NodeMeasuringIntrinsics;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.DpRect;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LookaheadScope.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001eBH\u0012A\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u001a\u001a\u00020\f*\u00020\u001b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u000f\u001a\b\u0018\u00010\u0010R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000RU\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, m195d2 = {"Landroidx/compose/ui/layout/IntermediateLayoutModifierNodeImpl;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "measureBlock", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/IntermediateMeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Lkotlin/ParameterName;", "name", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)V", "intermediateMeasureScope", "Landroidx/compose/ui/layout/IntermediateLayoutModifierNodeImpl$IntermediateMeasureScopeImpl;", "getMeasureBlock", "()Lkotlin/jvm/functions/Function3;", "setMeasureBlock", "isMeasurementApproachComplete", "", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "isMeasurementApproachComplete-ozmzZPI", "(J)Z", "approachMeasure", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "IntermediateMeasureScopeImpl", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class IntermediateLayoutModifierNodeImpl extends Modifier.Node implements ApproachLayoutModifierNode {
    private IntermediateMeasureScopeImpl intermediateMeasureScope;
    private Function3<? super IntermediateMeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> measureBlock;

    @Override // androidx.compose.p001ui.layout.ApproachLayoutModifierNode
    public /* synthetic */ boolean isPlacementApproachComplete(Placeable.PlacementScope placementScope, LayoutCoordinates layoutCoordinates) {
        return ApproachLayoutModifierNode.CC.$default$isPlacementApproachComplete(this, placementScope, layoutCoordinates);
    }

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

    public final Function3<IntermediateMeasureScope, Measurable, Constraints, MeasureResult> getMeasureBlock() {
        return this.measureBlock;
    }

    public final void setMeasureBlock(Function3<? super IntermediateMeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> function3) {
        this.measureBlock = function3;
    }

    public IntermediateLayoutModifierNodeImpl(Function3<? super IntermediateMeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> function3) {
        this.measureBlock = function3;
    }

    /* JADX INFO: compiled from: LookaheadScope.kt */
    @Metadata(m194d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007Ja\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020*0-2\u0019\u0010/\u001a\u0015\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000202\u0018\u000100¢\u0006\u0002\b32\u0017\u00104\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020200¢\u0006\u0002\b3H\u0096\u0001JF\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020*0-2\u0017\u00104\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020200¢\u0006\u0002\b3H\u0096\u0001J\"\u00105\u001a\u000206*\u00020#2\u0006\u00107\u001a\u00020#H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020**\u00020;H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u0017\u0010:\u001a\u00020**\u00020>H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020;*\u00020>H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\u001a\u0010A\u001a\u00020;*\u00020\u000fH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u001a\u0010A\u001a\u00020;*\u00020*H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010FJ\u0017\u0010G\u001a\u00020H*\u00020IH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ\r\u0010L\u001a\u00020#*\u00020#H\u0097\u0001J\u0017\u0010M\u001a\u00020\u000f*\u00020;H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010EJ\u0017\u0010M\u001a\u00020\u000f*\u00020>H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010CJ\r\u0010P\u001a\u00020Q*\u00020RH\u0097\u0001J\u0017\u0010S\u001a\u00020I*\u00020HH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010KJ\u0017\u0010U\u001a\u00020>*\u00020;H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\u001a\u0010U\u001a\u00020>*\u00020\u000fH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010WJ\u001a\u0010U\u001a\u00020>*\u00020*H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010YR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u00020\u001cX\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u00020 X\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b!\u0010\u001eR\u0018\u0010\"\u001a\u00020#*\u00020$8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, m195d2 = {"Landroidx/compose/ui/layout/IntermediateLayoutModifierNodeImpl$IntermediateMeasureScopeImpl;", "Landroidx/compose/ui/layout/IntermediateMeasureScope;", "Landroidx/compose/ui/layout/LookaheadScope;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "Lkotlinx/coroutines/CoroutineScope;", "approachScope", "Landroidx/compose/ui/layout/ApproachMeasureScopeImpl;", "(Landroidx/compose/ui/layout/IntermediateLayoutModifierNodeImpl;Landroidx/compose/ui/layout/ApproachMeasureScopeImpl;)V", "getApproachScope", "()Landroidx/compose/ui/layout/ApproachMeasureScopeImpl;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLookaheadConstraints-msEJaDk", "()J", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "getLookaheadSize-YbymL2g", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "placementBlock", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "coordinates", "localLookaheadPositionOf-dBAh8RU", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;)J", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toLookaheadCoordinates", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private final class IntermediateMeasureScopeImpl implements IntermediateMeasureScope, LookaheadScope, ApproachMeasureScope, CoroutineScope {
        private final ApproachMeasureScopeImpl approachScope;

        @Override // androidx.compose.p001ui.unit.Density
        public float getDensity() {
            return this.approachScope.getDensity();
        }

        @Override // androidx.compose.p001ui.unit.FontScaling
        public float getFontScale() {
            return this.approachScope.getFontScale();
        }

        @Override // androidx.compose.p001ui.layout.IntrinsicMeasureScope
        public LayoutDirection getLayoutDirection() {
            return this.approachScope.getLayoutDirection();
        }

        @Override // androidx.compose.p001ui.layout.ApproachIntrinsicMeasureScope
        /* JADX INFO: renamed from: getLookaheadConstraints-msEJaDk */
        public long mo5614getLookaheadConstraintsmsEJaDk() {
            return this.approachScope.mo5614getLookaheadConstraintsmsEJaDk();
        }

        @Override // androidx.compose.p001ui.layout.LookaheadScope
        public LayoutCoordinates getLookaheadScopeCoordinates(Placeable.PlacementScope placementScope) {
            return this.approachScope.getLookaheadScopeCoordinates(placementScope);
        }

        @Override // androidx.compose.p001ui.layout.ApproachIntrinsicMeasureScope
        /* JADX INFO: renamed from: getLookaheadSize-YbymL2g */
        public long mo5615getLookaheadSizeYbymL2g() {
            return this.approachScope.mo5615getLookaheadSizeYbymL2g();
        }

        @Override // androidx.compose.p001ui.layout.IntrinsicMeasureScope
        public boolean isLookingAhead() {
            return this.approachScope.isLookingAhead();
        }

        @Override // androidx.compose.p001ui.layout.MeasureScope
        public MeasureResult layout(int width, int height, Map<AlignmentLine, Integer> alignmentLines, Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
            return this.approachScope.layout(width, height, alignmentLines, placementBlock);
        }

        @Override // androidx.compose.p001ui.layout.MeasureScope
        public MeasureResult layout(int width, int height, Map<AlignmentLine, Integer> alignmentLines, Function1<? super RulerScope, Unit> rulers, Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
            return this.approachScope.layout(width, height, alignmentLines, rulers, placementBlock);
        }

        @Override // androidx.compose.p001ui.layout.LookaheadScope
        /* JADX INFO: renamed from: localLookaheadPositionOf-dBAh8RU */
        public long mo5620localLookaheadPositionOfdBAh8RU(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2) {
            return this.approachScope.mo5620localLookaheadPositionOfdBAh8RU(layoutCoordinates, layoutCoordinates2);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: roundToPx--R2X_6o */
        public int mo560roundToPxR2X_6o(long j) {
            return this.approachScope.mo560roundToPxR2X_6o(j);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: roundToPx-0680j_4 */
        public int mo561roundToPx0680j_4(float f) {
            return this.approachScope.mo561roundToPx0680j_4(f);
        }

        @Override // androidx.compose.p001ui.unit.FontScaling
        /* JADX INFO: renamed from: toDp-GaN1DYA */
        public float mo562toDpGaN1DYA(long j) {
            return this.approachScope.mo562toDpGaN1DYA(j);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public float mo563toDpu2uoSUM(float f) {
            return this.approachScope.mo563toDpu2uoSUM(f);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public float mo564toDpu2uoSUM(int i) {
            return this.approachScope.mo564toDpu2uoSUM(i);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toDpSize-k-rfVVM */
        public long mo565toDpSizekrfVVM(long j) {
            return this.approachScope.mo565toDpSizekrfVVM(j);
        }

        @Override // androidx.compose.p001ui.layout.LookaheadScope
        public LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates layoutCoordinates) {
            return this.approachScope.toLookaheadCoordinates(layoutCoordinates);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toPx--R2X_6o */
        public float mo566toPxR2X_6o(long j) {
            return this.approachScope.mo566toPxR2X_6o(j);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toPx-0680j_4 */
        public float mo567toPx0680j_4(float f) {
            return this.approachScope.mo567toPx0680j_4(f);
        }

        @Override // androidx.compose.p001ui.unit.Density
        public Rect toRect(DpRect dpRect) {
            return this.approachScope.toRect(dpRect);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toSize-XkaWNTQ */
        public long mo568toSizeXkaWNTQ(long j) {
            return this.approachScope.mo568toSizeXkaWNTQ(j);
        }

        @Override // androidx.compose.p001ui.unit.FontScaling
        /* JADX INFO: renamed from: toSp-0xMU5do */
        public long mo569toSp0xMU5do(float f) {
            return this.approachScope.mo569toSp0xMU5do(f);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public long mo570toSpkPz2Gy4(float f) {
            return this.approachScope.mo570toSpkPz2Gy4(f);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public long mo571toSpkPz2Gy4(int i) {
            return this.approachScope.mo571toSpkPz2Gy4(i);
        }

        public IntermediateMeasureScopeImpl(ApproachMeasureScopeImpl approachScope) {
            this.approachScope = approachScope;
        }

        public final ApproachMeasureScopeImpl getApproachScope() {
            return this.approachScope;
        }

        @Override // kotlinx.coroutines.CoroutineScope
        public CoroutineContext getCoroutineContext() {
            return IntermediateLayoutModifierNodeImpl.this.getCoroutineScope().getCoroutineContext();
        }
    }

    @Override // androidx.compose.p001ui.layout.ApproachLayoutModifierNode
    /* JADX INFO: renamed from: isMeasurementApproachComplete-ozmzZPI */
    public boolean mo5617isMeasurementApproachCompleteozmzZPI(long lookaheadSize) {
        return false;
    }

    @Override // androidx.compose.p001ui.layout.ApproachLayoutModifierNode
    /* JADX INFO: renamed from: approachMeasure-3p2s80s */
    public MeasureResult mo5616approachMeasure3p2s80s(ApproachMeasureScope $this$approachMeasure_u2d3p2s80s, Measurable measurable, long constraints) {
        IntermediateMeasureScopeImpl newScope;
        IntermediateMeasureScopeImpl scope = this.intermediateMeasureScope;
        if (!Intrinsics.areEqual(scope != null ? scope.getApproachScope() : null, $this$approachMeasure_u2d3p2s80s)) {
            Intrinsics.checkNotNull($this$approachMeasure_u2d3p2s80s, "null cannot be cast to non-null type androidx.compose.ui.layout.ApproachMeasureScopeImpl");
            newScope = new IntermediateMeasureScopeImpl((ApproachMeasureScopeImpl) $this$approachMeasure_u2d3p2s80s);
        } else {
            newScope = scope;
        }
        this.intermediateMeasureScope = newScope;
        IntermediateMeasureScopeImpl $this$approachMeasure_3p2s80s_u24lambda_u240 = newScope;
        return this.measureBlock.invoke($this$approachMeasure_3p2s80s_u24lambda_u240, measurable, Constraints.m6732boximpl(constraints));
    }
}
