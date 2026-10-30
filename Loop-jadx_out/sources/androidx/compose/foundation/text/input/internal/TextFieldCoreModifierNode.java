package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.internal.selection.AndroidTextFieldMagnifier_androidKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.graphics.Brush;
import androidx.compose.p001ui.graphics.Canvas;
import androidx.compose.p001ui.graphics.Path;
import androidx.compose.p001ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.layout.IntrinsicMeasurable;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.p001ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.p001ui.node.DelegatingNode;
import androidx.compose.p001ui.node.DrawModifierNode;
import androidx.compose.p001ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.p001ui.node.LayoutModifierNode;
import androidx.compose.p001ui.node.LayoutModifierNodeKt;
import androidx.compose.p001ui.node.NodeMeasuringIntrinsics;
import androidx.compose.p001ui.node.SemanticsModifierNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.platform.WindowInfo;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextPainter;
import androidx.compose.p001ui.text.TextRange;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: TextFieldCoreModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006BM\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\b\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020+H\u0002JN\u00100\u001a\u00020+2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\f\u00101\u001a\u00020+*\u000202H\u0016J\f\u00103\u001a\u00020+*\u000204H\u0016J\f\u00105\u001a\u00020+*\u000206H\u0002J&\u00107\u001a\u00020+*\u0002062\u0006\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020:H\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u0014\u0010=\u001a\u00020+*\u0002062\u0006\u00109\u001a\u00020:H\u0002J&\u0010>\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0016ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ&\u0010G\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\bH\u0010FJ&\u0010I\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\bJ\u0010FJ,\u0010K\u001a\u00020+*\u00020L2\u0006\u0010M\u001a\u00020&2\u0006\u0010N\u001a\u00020&2\u0006\u0010O\u001a\u00020&2\u0006\u0010P\u001a\u00020QH\u0002R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006R"}, m195d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "isFocused", "", "isDragHovered", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "writeable", "scrollState", "Landroidx/compose/foundation/ScrollState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(ZZLandroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/graphics/Brush;ZLandroidx/compose/foundation/ScrollState;Landroidx/compose/foundation/gestures/Orientation;)V", "changeObserverJob", "Lkotlinx/coroutines/Job;", "cursorAnimation", "Landroidx/compose/foundation/text/input/internal/CursorAnimationState;", "previousCursorRect", "Landroidx/compose/ui/geometry/Rect;", "previousSelection", "Landroidx/compose/ui/text/TextRange;", "showCursor", "getShowCursor", "()Z", "textFieldMagnifierNode", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNode;", "calculateOffsetToFollow", "", "currSelection", "calculateOffsetToFollow-5zc-tL8", "(J)I", "onAttach", "", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "startCursorJob", "updateNode", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawCursor", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawSelection", "selection", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "drawSelection-Sb-Bc2M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/text/TextLayoutResult;)V", "drawText", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measureHorizontalScroll", "measureHorizontalScroll-3p2s80s", "measureVerticalScroll", "measureVerticalScroll-3p2s80s", "updateScrollState", "Landroidx/compose/ui/unit/Density;", "offsetToFollow", "containerSize", "textFieldSize", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextFieldCoreModifierNode extends DelegatingNode implements LayoutModifierNode, DrawModifierNode, CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private Job changeObserverJob;
    private Brush cursorBrush;
    private boolean isDragHovered;
    private boolean isFocused;
    private Orientation orientation;
    private TextRange previousSelection;
    private ScrollState scrollState;
    private final TextFieldMagnifierNode textFieldMagnifierNode;
    private TextFieldSelectionState textFieldSelectionState;
    private TransformedTextFieldState textFieldState;
    private TextLayoutState textLayoutState;
    private boolean writeable;
    private final CursorAnimationState cursorAnimation = new CursorAnimationState();
    private Rect previousCursorRect = new Rect(-1.0f, -1.0f, -1.0f, -1.0f);

    @Override // androidx.compose.p001ui.node.SemanticsModifierNode
    /* JADX INFO: renamed from: getShouldClearDescendantSemantics */
    public /* synthetic */ boolean getIsClearingSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldClearDescendantSemantics(this);
    }

    @Override // androidx.compose.p001ui.node.SemanticsModifierNode
    public /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldMergeDescendantSemantics(this);
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

    @Override // androidx.compose.p001ui.node.DrawModifierNode
    public /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.CC.$default$onMeasureResultChanged(this);
    }

    public TextFieldCoreModifierNode(boolean isFocused, boolean isDragHovered, TextLayoutState textLayoutState, TransformedTextFieldState textFieldState, TextFieldSelectionState textFieldSelectionState, Brush cursorBrush, boolean writeable, ScrollState scrollState, Orientation orientation) {
        this.isFocused = isFocused;
        this.isDragHovered = isDragHovered;
        this.textLayoutState = textLayoutState;
        this.textFieldState = textFieldState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.cursorBrush = cursorBrush;
        this.writeable = writeable;
        this.scrollState = scrollState;
        this.orientation = orientation;
        this.textFieldMagnifierNode = (TextFieldMagnifierNode) delegate(AndroidTextFieldMagnifier_androidKt.textFieldMagnifierNode(this.textFieldState, this.textFieldSelectionState, this.textLayoutState, this.isFocused || this.isDragHovered));
    }

    private final boolean getShowCursor() {
        return this.writeable && (this.isFocused || this.isDragHovered) && TextFieldCoreModifierKt.isSpecified(this.cursorBrush);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        if (this.isFocused && getShowCursor()) {
            startCursorJob();
        }
    }

    public final void updateNode(boolean isFocused, boolean isDragHovered, TextLayoutState textLayoutState, TransformedTextFieldState textFieldState, TextFieldSelectionState textFieldSelectionState, Brush cursorBrush, boolean writeable, ScrollState scrollState, Orientation orientation) {
        boolean previousShowCursor = getShowCursor();
        boolean wasFocused = this.isFocused;
        TransformedTextFieldState previousTextFieldState = this.textFieldState;
        TextLayoutState previousTextLayoutState = this.textLayoutState;
        TextFieldSelectionState previousTextFieldSelectionState = this.textFieldSelectionState;
        ScrollState previousScrollState = this.scrollState;
        this.isFocused = isFocused;
        this.isDragHovered = isDragHovered;
        this.textLayoutState = textLayoutState;
        this.textFieldState = textFieldState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.cursorBrush = cursorBrush;
        this.writeable = writeable;
        this.scrollState = scrollState;
        this.orientation = orientation;
        this.textFieldMagnifierNode.update(textFieldState, textFieldSelectionState, textLayoutState, isFocused || isDragHovered);
        if (!getShowCursor()) {
            Job job = this.changeObserverJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.changeObserverJob = null;
            this.cursorAnimation.cancelAndHide();
        } else if (!wasFocused || !Intrinsics.areEqual(previousTextFieldState, textFieldState) || !previousShowCursor) {
            startCursorJob();
        }
        if (!Intrinsics.areEqual(previousTextFieldState, textFieldState) || !Intrinsics.areEqual(previousTextLayoutState, textLayoutState) || !Intrinsics.areEqual(previousTextFieldSelectionState, textFieldSelectionState) || !Intrinsics.areEqual(previousScrollState, scrollState)) {
            LayoutModifierNodeKt.invalidateMeasurement(this);
        }
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo337measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        if (this.orientation == Orientation.Vertical) {
            return m1337measureVerticalScroll3p2s80s($this$measure_u2d3p2s80s, measurable, constraints);
        }
        return m1336measureHorizontalScroll3p2s80s($this$measure_u2d3p2s80s, measurable, constraints);
    }

    @Override // androidx.compose.p001ui.node.DrawModifierNode
    public void draw(ContentDrawScope $this$draw) {
        $this$draw.drawContent();
        TextFieldCharSequence value = this.textFieldState.getVisualText();
        TextLayoutResult textLayoutResult = this.textLayoutState.getLayoutResult();
        if (textLayoutResult == null) {
            return;
        }
        if (TextRange.m6245getCollapsedimpl(value.getSelection())) {
            drawText($this$draw, textLayoutResult);
            drawCursor($this$draw);
        } else {
            m1335drawSelectionSbBc2M($this$draw, value.getSelection(), textLayoutResult);
            drawText($this$draw, textLayoutResult);
        }
        TextFieldMagnifierNode $this$draw_u24lambda_u240 = this.textFieldMagnifierNode;
        $this$draw_u24lambda_u240.draw($this$draw);
    }

    /* JADX INFO: renamed from: measureVerticalScroll-3p2s80s, reason: not valid java name */
    private final MeasureResult m1337measureVerticalScroll3p2s80s(final MeasureScope $this$measureVerticalScroll_u2d3p2s80s, Measurable measurable, long constraints) {
        long childConstraints = Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : Integer.MAX_VALUE);
        final Placeable placeable = measurable.mo5644measureBRTryo0(childConstraints);
        final int height = Math.min(placeable.getHeight(), Constraints.m6743getMaxHeightimpl(constraints));
        return MeasureScope.CC.layout$default($this$measureVerticalScroll_u2d3p2s80s, placeable.getWidth(), height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$measureVerticalScroll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope $this$layout) {
                long currSelection = this.this$0.textFieldState.getVisualText().getSelection();
                int offsetToFollow = this.this$0.m1334calculateOffsetToFollow5zctL8(currSelection);
                this.this$0.updateScrollState($this$measureVerticalScroll_u2d3p2s80s, offsetToFollow, height, placeable.getHeight(), $this$measureVerticalScroll_u2d3p2s80s.getLayoutDirection());
                if (this.this$0.isFocused) {
                    this.this$0.previousSelection = TextRange.m6239boximpl(currSelection);
                }
                Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, -this.this$0.scrollState.getValue(), 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: renamed from: measureHorizontalScroll-3p2s80s, reason: not valid java name */
    private final MeasureResult m1336measureHorizontalScroll3p2s80s(final MeasureScope $this$measureHorizontalScroll_u2d3p2s80s, Measurable measurable, long constraints) {
        final Placeable placeable = measurable.mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : Integer.MAX_VALUE, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0));
        final int width = Math.min(placeable.getWidth(), Constraints.m6744getMaxWidthimpl(constraints));
        return MeasureScope.CC.layout$default($this$measureHorizontalScroll_u2d3p2s80s, width, placeable.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$measureHorizontalScroll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope $this$layout) {
                long currSelection = this.this$0.textFieldState.getVisualText().getSelection();
                int offsetToFollow = this.this$0.m1334calculateOffsetToFollow5zctL8(currSelection);
                this.this$0.updateScrollState($this$measureHorizontalScroll_u2d3p2s80s, offsetToFollow, width, placeable.getWidth(), $this$measureHorizontalScroll_u2d3p2s80s.getLayoutDirection());
                if (this.this$0.isFocused) {
                    this.this$0.previousSelection = TextRange.m6239boximpl(currSelection);
                }
                Placeable.PlacementScope.placeRelative$default($this$layout, placeable, -this.this$0.scrollState.getValue(), 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateOffsetToFollow-5zc-tL8, reason: not valid java name */
    public final int m1334calculateOffsetToFollow5zctL8(long currSelection) {
        TextRange textRange = this.previousSelection;
        if (!(textRange != null && TextRange.m6246getEndimpl(currSelection) == TextRange.m6246getEndimpl(textRange.getPackedValue()))) {
            return TextRange.m6246getEndimpl(currSelection);
        }
        TextRange textRange2 = this.previousSelection;
        if (textRange2 != null && TextRange.m6251getStartimpl(currSelection) == TextRange.m6251getStartimpl(textRange2.getPackedValue())) {
            return -1;
        }
        return TextRange.m6251getStartimpl(currSelection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateScrollState(Density $this$updateScrollState, int offsetToFollow, int containerSize, int textFieldSize, LayoutDirection layoutDirection) {
        Rect cursorRect;
        float f;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return;
        }
        Rect rawCursorRect = layoutResult.getCursorRect(RangesKt.coerceIn(offsetToFollow, (ClosedRange<Integer>) new IntRange(0, layoutResult.getLayoutInput().getText().length())));
        if (offsetToFollow >= 0) {
            cursorRect = TextFieldCoreModifierKt.getCursorRectInScroller($this$updateScrollState, rawCursorRect, layoutDirection == LayoutDirection.Rtl, textFieldSize);
        } else {
            cursorRect = null;
        }
        int difference = textFieldSize - containerSize;
        this.scrollState.setMaxValue$foundation_release(difference);
        if (!getShowCursor() || cursorRect == null) {
            return;
        }
        if (cursorRect.getLeft() == this.previousCursorRect.getLeft()) {
            if (cursorRect.getTop() == this.previousCursorRect.getTop()) {
                return;
            }
        }
        boolean vertical = this.orientation == Orientation.Vertical;
        float cursorStart = vertical ? cursorRect.getTop() : cursorRect.getLeft();
        float cursorEnd = vertical ? cursorRect.getBottom() : cursorRect.getRight();
        int startVisibleBound = this.scrollState.getValue();
        int endVisibleBound = startVisibleBound + containerSize;
        if (cursorEnd > endVisibleBound) {
            f = cursorEnd - endVisibleBound;
        } else if (cursorStart < startVisibleBound && cursorEnd - cursorStart > containerSize) {
            f = cursorEnd - endVisibleBound;
        } else if (cursorStart < startVisibleBound && cursorEnd - cursorStart <= containerSize) {
            f = cursorStart - startVisibleBound;
        } else {
            f = 0.0f;
        }
        float offsetDifference = f;
        this.previousCursorRect = cursorRect;
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new C08131(offsetDifference, rawCursorRect, null), 1, null);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$updateScrollState$1 */
    /* JADX INFO: compiled from: TextFieldCoreModifier.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$updateScrollState$1", m210f = "TextFieldCoreModifier.kt", m211i = {}, m212l = {440, 443}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C08131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $offsetDifference;
        final /* synthetic */ Rect $rawCursorRect;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08131(float f, Rect rect, Continuation<? super C08131> continuation) {
            super(2, continuation);
            this.$offsetDifference = f;
            this.$rawCursorRect = rect;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TextFieldCoreModifierNode.this.new C08131(this.$offsetDifference, this.$rawCursorRect, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0053 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x0054  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C08131 c08131;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c08131 = this;
                    c08131.label = 1;
                    if (ScrollExtensionsKt.scrollBy(TextFieldCoreModifierNode.this.scrollState, TextFieldCoreModifierKt.roundToNext(c08131.$offsetDifference), c08131) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c08131.label = 2;
                    if (TextFieldCoreModifierNode.this.textLayoutState.getBringIntoViewRequester().bringIntoView(c08131.$rawCursorRect, c08131) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    c08131 = this;
                    ResultKt.throwOnFailure($result);
                    c08131.label = 2;
                    if (TextFieldCoreModifierNode.this.textLayoutState.getBringIntoViewRequester().bringIntoView(c08131.$rawCursorRect, c08131) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: drawSelection-Sb-Bc2M, reason: not valid java name */
    private final void m1335drawSelectionSbBc2M(DrawScope $this$drawSelection_u2dSb_u2dBc2M, long selection, TextLayoutResult textLayoutResult) {
        int start = TextRange.m6249getMinimpl(selection);
        int end = TextRange.m6248getMaximpl(selection);
        if (start != end) {
            long selectionBackgroundColor = ((SelectionColors) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, TextSelectionColorsKt.getLocalTextSelectionColors())).getSelectionBackgroundColor();
            Path selectionPath = textLayoutResult.getPathForRange(start, end);
            DrawScope.CC.m4854drawPathLG529CI$default($this$drawSelection_u2dSb_u2dBc2M, selectionPath, selectionBackgroundColor, 0.0f, null, null, 0, 60, null);
        }
    }

    private final void drawText(DrawScope $this$drawText, TextLayoutResult textLayoutResult) {
        Canvas canvas = $this$drawText.getDrawContext().getCanvas();
        TextPainter.INSTANCE.paint(canvas, textLayoutResult);
    }

    private final void drawCursor(DrawScope $this$drawCursor) {
        float cursorAlphaValue = this.cursorAnimation.getCursorAlpha();
        if ((cursorAlphaValue == 0.0f) || !getShowCursor()) {
            return;
        }
        Rect cursorRect = this.textFieldSelectionState.getCursorRect();
        DrawScope.CC.m4849drawLine1RTmtNc$default($this$drawCursor, this.cursorBrush, cursorRect.m4083getTopCenterF1C5BW0(), cursorRect.m4076getBottomCenterF1C5BW0(), cursorRect.getWidth(), 0, null, cursorAlphaValue, null, 0, 432, null);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1 */
    /* JADX INFO: compiled from: TextFieldCoreModifier.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1", m210f = "TextFieldCoreModifier.kt", m211i = {}, m212l = {522}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C08121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08121(Continuation<? super C08121> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TextFieldCoreModifierNode.this.new C08121(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final Ref.IntRef sign = new Ref.IntRef();
                    sign.element = 1;
                    final TextFieldCoreModifierNode textFieldCoreModifierNode = TextFieldCoreModifierNode.this;
                    this.label = 1;
                    if (FlowKt.collectLatest(SnapshotStateKt.snapshotFlow(new Function0<Integer>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode.startCursorJob.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Integer invoke() {
                            textFieldCoreModifierNode.textFieldState.getVisualText();
                            boolean isWindowFocused = ((WindowInfo) CompositionLocalConsumerModifierNodeKt.currentValueOf(textFieldCoreModifierNode, CompositionLocalsKt.getLocalWindowInfo())).isWindowFocused();
                            Integer numValueOf = Integer.valueOf((isWindowFocused ? 1 : 2) * sign.element);
                            Ref.IntRef intRef = sign;
                            numValueOf.intValue();
                            intRef.element *= -1;
                            return numValueOf;
                        }
                    }), new AnonymousClass2(TextFieldCoreModifierNode.this, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldCoreModifier.kt */
        @Metadata(m194d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m195d2 = {"<anonymous>", "", "isWindowFocused", ""}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1$2", m210f = "TextFieldCoreModifier.kt", m211i = {}, m212l = {524}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
            /* synthetic */ int I$0;
            int label;
            final /* synthetic */ TextFieldCoreModifierNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(TextFieldCoreModifierNode textFieldCoreModifierNode, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = textFieldCoreModifierNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.I$0 = ((Number) obj).intValue();
                return anonymousClass2;
            }

            public final Object invoke(int i, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Unit> continuation) {
                return invoke(num.intValue(), continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                AnonymousClass2 anonymousClass2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        int isWindowFocused = this.I$0;
                        if (Math.abs(isWindowFocused) == 1) {
                            this.label = 1;
                            if (this.this$0.cursorAnimation.snapToVisibleAndAnimate(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            anonymousClass2 = this;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        anonymousClass2 = this;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    private final void startCursorJob() {
        this.changeObserverJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C08121(null), 3, null);
    }

    @Override // androidx.compose.p001ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        this.textLayoutState.setCoreNodeCoordinates(coordinates);
        this.textFieldMagnifierNode.onGloballyPositioned(coordinates);
    }

    @Override // androidx.compose.p001ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        TextFieldMagnifierNode $this$applySemantics_u24lambda_u242 = this.textFieldMagnifierNode;
        $this$applySemantics_u24lambda_u242.applySemantics($this$applySemantics);
    }
}
