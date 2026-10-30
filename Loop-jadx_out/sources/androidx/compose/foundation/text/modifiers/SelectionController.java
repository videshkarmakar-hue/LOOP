package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextPointerIcon_androidKt;
import androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate;
import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.ClipOp;
import androidx.compose.p001ui.graphics.Path;
import androidx.compose.p001ui.graphics.drawscope.DrawContext;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawTransform;
import androidx.compose.p001ui.input.pointer.PointerIconKt;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.runtime.RememberObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SelectionController.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eR\u0016\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, m195d2 = {"Landroidx/compose/foundation/text/modifiers/SelectionController;", "Landroidx/compose/runtime/RememberObserver;", "selectableId", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "backgroundSelectionColor", "Landroidx/compose/ui/graphics/Color;", "params", "Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;", "(JLandroidx/compose/foundation/text/selection/SelectionRegistrar;JLandroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "selectable", "Landroidx/compose/foundation/text/selection/Selectable;", "draw", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "onAbandoned", "onForgotten", "onRemembered", "updateGlobalPosition", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "updateTextLayout", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SelectionController implements RememberObserver {
    public static final int $stable = 8;
    private final long backgroundSelectionColor;
    private final Modifier modifier;
    private StaticTextSelectionParams params;
    private Selectable selectable;
    private final long selectableId;
    private final SelectionRegistrar selectionRegistrar;

    public /* synthetic */ SelectionController(long j, SelectionRegistrar selectionRegistrar, long j2, StaticTextSelectionParams staticTextSelectionParams, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, selectionRegistrar, j2, staticTextSelectionParams);
    }

    private SelectionController(long selectableId, SelectionRegistrar selectionRegistrar, long backgroundSelectionColor, StaticTextSelectionParams params) {
        this.selectableId = selectableId;
        this.selectionRegistrar = selectionRegistrar;
        this.backgroundSelectionColor = backgroundSelectionColor;
        this.params = params;
        this.modifier = PointerIconKt.pointerHoverIcon$default(SelectionControllerKt.makeSelectionModifier(this.selectionRegistrar, this.selectableId, new Function0<LayoutCoordinates>() { // from class: androidx.compose.foundation.text.modifiers.SelectionController$modifier$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LayoutCoordinates invoke() {
                return this.this$0.params.getLayoutCoordinates();
            }
        }), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SelectionController(long j, SelectionRegistrar selectionRegistrar, long j2, StaticTextSelectionParams staticTextSelectionParams, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StaticTextSelectionParams empty;
        if ((i & 8) == 0) {
            empty = staticTextSelectionParams;
        } else {
            empty = StaticTextSelectionParams.INSTANCE.getEmpty();
        }
        this(j, selectionRegistrar, j2, empty, null);
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        this.selectable = this.selectionRegistrar.subscribe(new MultiWidgetSelectionDelegate(this.selectableId, new Function0<LayoutCoordinates>() { // from class: androidx.compose.foundation.text.modifiers.SelectionController.onRemembered.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LayoutCoordinates invoke() {
                return SelectionController.this.params.getLayoutCoordinates();
            }
        }, new Function0<TextLayoutResult>() { // from class: androidx.compose.foundation.text.modifiers.SelectionController.onRemembered.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextLayoutResult invoke() {
                return SelectionController.this.params.getTextLayoutResult();
            }
        }));
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        Selectable localSelectable = this.selectable;
        if (localSelectable != null) {
            this.selectionRegistrar.unsubscribe(localSelectable);
            this.selectable = null;
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        Selectable localSelectable = this.selectable;
        if (localSelectable != null) {
            this.selectionRegistrar.unsubscribe(localSelectable);
            this.selectable = null;
        }
    }

    public final void updateTextLayout(TextLayoutResult textLayoutResult) {
        TextLayoutResult prevTextLayoutResult = this.params.getTextLayoutResult();
        if (prevTextLayoutResult != null && !Intrinsics.areEqual(prevTextLayoutResult.getLayoutInput().getText(), textLayoutResult.getLayoutInput().getText())) {
            this.selectionRegistrar.notifySelectableChange(this.selectableId);
        }
        this.params = StaticTextSelectionParams.copy$default(this.params, null, textLayoutResult, 1, null);
    }

    public final void updateGlobalPosition(LayoutCoordinates coordinates) {
        this.params = StaticTextSelectionParams.copy$default(this.params, coordinates, null, 2, null);
        this.selectionRegistrar.notifyPositionChange(this.selectableId);
    }

    public final void draw(DrawScope drawScope) throws Throwable {
        long previousSize$iv$iv;
        Selection selection = this.selectionRegistrar.getSubselections().get(Long.valueOf(this.selectableId));
        if (selection == null) {
            return;
        }
        int start = !selection.getHandlesCrossed() ? selection.getStart().getOffset() : selection.getEnd().getOffset();
        int end = !selection.getHandlesCrossed() ? selection.getEnd().getOffset() : selection.getStart().getOffset();
        if (start == end) {
            return;
        }
        Selectable selectable = this.selectable;
        int lastOffset = selectable != null ? selectable.getLastVisibleOffset() : 0;
        int clippedStart = RangesKt.coerceAtMost(start, lastOffset);
        int clippedEnd = RangesKt.coerceAtMost(end, lastOffset);
        Path selectionPath = this.params.getPathForRange(clippedStart, clippedEnd);
        if (selectionPath == null) {
            return;
        }
        if (!this.params.getShouldClip()) {
            DrawScope.CC.m4854drawPathLG529CI$default(drawScope, selectionPath, this.backgroundSelectionColor, 0.0f, null, null, 0, 60, null);
            return;
        }
        float right$iv = Size.m4118getWidthimpl(drawScope.mo4773getSizeNHjbRc());
        float bottom$iv = Size.m4115getHeightimpl(drawScope.mo4773getSizeNHjbRc());
        int clipOp$iv = ClipOp.INSTANCE.m4280getIntersectrtfAjoo();
        DrawContext $this$withTransform_u24lambda_u246$iv$iv = drawScope.getDrawContext();
        long previousSize$iv$iv2 = $this$withTransform_u24lambda_u246$iv$iv.mo4779getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
        try {
            DrawTransform $this$clipRect_rOu3jXo_u24lambda_u244$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
            previousSize$iv$iv = previousSize$iv$iv2;
            try {
                $this$clipRect_rOu3jXo_u24lambda_u244$iv.mo4782clipRectN_I0leg(0.0f, 0.0f, right$iv, bottom$iv, clipOp$iv);
                try {
                    try {
                        DrawScope.CC.m4854drawPathLG529CI$default(drawScope, selectionPath, this.backgroundSelectionColor, 0.0f, null, null, 0, 60, null);
                        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                        $this$withTransform_u24lambda_u246$iv$iv.mo4780setSizeuvyYCjk(previousSize$iv$iv);
                    } catch (Throwable th) {
                        th = th;
                        $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv;
                        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                        $this$withTransform_u24lambda_u246$iv$iv.mo4780setSizeuvyYCjk(previousSize$iv$iv);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            previousSize$iv$iv = previousSize$iv$iv2;
        }
    }
}
