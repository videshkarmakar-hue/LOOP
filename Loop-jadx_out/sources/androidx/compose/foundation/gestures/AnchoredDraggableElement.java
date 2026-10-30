package androidx.compose.foundation.gestures;

import androidx.compose.animation.C0176x19daea59;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p001ui.node.ModifierNodeElement;
import androidx.compose.p001ui.platform.InspectorInfo;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnchoredDraggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B=\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0013\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\f\u0010\u0018\u001a\u00020\u0016*\u00020\u0019H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m195d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableElement;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/AnchoredDraggableNode;", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Z)V", "create", "equals", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class AnchoredDraggableElement<T> extends ModifierNodeElement<AnchoredDraggableNode<T>> {
    private final boolean enabled;
    private final MutableInteractionSource interactionSource;
    private final Orientation orientation;
    private final boolean reverseDirection;
    private final boolean startDragImmediately;
    private final AnchoredDraggableState<T> state;

    public AnchoredDraggableElement(AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean enabled, boolean reverseDirection, MutableInteractionSource interactionSource, boolean startDragImmediately) {
        this.state = anchoredDraggableState;
        this.orientation = orientation;
        this.enabled = enabled;
        this.reverseDirection = reverseDirection;
        this.interactionSource = interactionSource;
        this.startDragImmediately = startDragImmediately;
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public AnchoredDraggableNode<T> create() {
        return new AnchoredDraggableNode<>(this.state, this.orientation, this.enabled, this.reverseDirection, this.interactionSource, this.startDragImmediately);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public void update(AnchoredDraggableNode<T> node) {
        node.update(this.state, this.orientation, this.enabled, this.reverseDirection, this.interactionSource, this.startDragImmediately);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public int hashCode() {
        int result = this.state.hashCode();
        int result2 = ((((((result * 31) + this.orientation.hashCode()) * 31) + C0176x19daea59.m9m(this.enabled)) * 31) + C0176x19daea59.m9m(this.reverseDirection)) * 31;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        return ((result2 + (mutableInteractionSource != null ? mutableInteractionSource.hashCode() : 0)) * 31) + C0176x19daea59.m9m(this.startDragImmediately);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AnchoredDraggableElement) && Intrinsics.areEqual(this.state, ((AnchoredDraggableElement) other).state) && this.orientation == ((AnchoredDraggableElement) other).orientation && this.enabled == ((AnchoredDraggableElement) other).enabled && this.reverseDirection == ((AnchoredDraggableElement) other).reverseDirection && Intrinsics.areEqual(this.interactionSource, ((AnchoredDraggableElement) other).interactionSource) && this.startDragImmediately == ((AnchoredDraggableElement) other).startDragImmediately;
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("anchoredDraggable");
        $this$inspectableProperties.getProperties().set("state", this.state);
        $this$inspectableProperties.getProperties().set("orientation", this.orientation);
        $this$inspectableProperties.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        $this$inspectableProperties.getProperties().set("reverseDirection", Boolean.valueOf(this.reverseDirection));
        $this$inspectableProperties.getProperties().set("interactionSource", this.interactionSource);
        $this$inspectableProperties.getProperties().set("startDragImmediately", Boolean.valueOf(this.startDragImmediately));
    }
}
