package androidx.compose.foundation.gestures;

import androidx.compose.animation.C0176x19daea59;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p001ui.node.ModifierNodeElement;
import androidx.compose.p001ui.platform.InspectorInfo;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnchoredDraggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002BG\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0013\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\f\u0010\u001a\u001a\u00020\u0018*\u00020\u001bH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m195d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableOverscrollElement;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/AnchoredDraggableOverscrollNode;", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLandroidx/compose/foundation/OverscrollEffect;)V", "create", "equals", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class AnchoredDraggableOverscrollElement<T> extends ModifierNodeElement<AnchoredDraggableOverscrollNode<T>> {
    private final boolean enabled;
    private final MutableInteractionSource interactionSource;
    private final Orientation orientation;
    private final OverscrollEffect overscrollEffect;
    private final boolean reverseDirection;
    private final boolean startDragImmediately;
    private final AnchoredDraggableState<T> state;

    public AnchoredDraggableOverscrollElement(AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean enabled, boolean reverseDirection, MutableInteractionSource interactionSource, boolean startDragImmediately, OverscrollEffect overscrollEffect) {
        this.state = anchoredDraggableState;
        this.orientation = orientation;
        this.enabled = enabled;
        this.reverseDirection = reverseDirection;
        this.interactionSource = interactionSource;
        this.startDragImmediately = startDragImmediately;
        this.overscrollEffect = overscrollEffect;
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public AnchoredDraggableOverscrollNode<T> create() {
        return new AnchoredDraggableOverscrollNode<>(this.state, this.orientation, this.enabled, this.reverseDirection, this.interactionSource, this.startDragImmediately, this.overscrollEffect);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public void update(AnchoredDraggableOverscrollNode<T> node) {
        node.update(this.state, this.orientation, this.enabled, this.reverseDirection, this.interactionSource, this.overscrollEffect, this.startDragImmediately);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public int hashCode() {
        int result = this.state.hashCode();
        int result2 = ((((((result * 31) + this.orientation.hashCode()) * 31) + C0176x19daea59.m9m(this.enabled)) * 31) + C0176x19daea59.m9m(this.reverseDirection)) * 31;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        int result3 = (((result2 + (mutableInteractionSource != null ? mutableInteractionSource.hashCode() : 0)) * 31) + C0176x19daea59.m9m(this.startDragImmediately)) * 31;
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        return result3 + (overscrollEffect != null ? overscrollEffect.hashCode() : 0);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AnchoredDraggableOverscrollElement) && Intrinsics.areEqual(this.state, ((AnchoredDraggableOverscrollElement) other).state) && this.orientation == ((AnchoredDraggableOverscrollElement) other).orientation && this.enabled == ((AnchoredDraggableOverscrollElement) other).enabled && this.reverseDirection == ((AnchoredDraggableOverscrollElement) other).reverseDirection && Intrinsics.areEqual(this.interactionSource, ((AnchoredDraggableOverscrollElement) other).interactionSource) && this.startDragImmediately == ((AnchoredDraggableOverscrollElement) other).startDragImmediately && Intrinsics.areEqual(this.overscrollEffect, ((AnchoredDraggableOverscrollElement) other).overscrollEffect);
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
        $this$inspectableProperties.getProperties().set("overscrollEffect", this.overscrollEffect);
    }
}
