package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimationSpecsNode;
import androidx.compose.p001ui.node.ModifierNodeElement;
import androidx.compose.p001ui.platform.InspectorInfo;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LazyItemScopeImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J?\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\f\u0010\u001e\u001a\u00020\u001c*\u00020\u001fH\u0016R\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006 "}, m195d2 = {"Landroidx/compose/foundation/lazy/AnimateItemElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimationSpecsNode;", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "placementSpec", "Landroidx/compose/ui/unit/IntOffset;", "fadeOutSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "getFadeInSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "getFadeOutSpec", "getPlacementSpec", "component1", "component2", "component3", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final /* data */ class AnimateItemElement extends ModifierNodeElement<LazyLayoutAnimationSpecsNode> {
    private final FiniteAnimationSpec<Float> fadeInSpec;
    private final FiniteAnimationSpec<Float> fadeOutSpec;
    private final FiniteAnimationSpec<IntOffset> placementSpec;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnimateItemElement copy$default(AnimateItemElement animateItemElement, FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2, FiniteAnimationSpec finiteAnimationSpec3, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = animateItemElement.fadeInSpec;
        }
        if ((i & 2) != 0) {
            finiteAnimationSpec2 = animateItemElement.placementSpec;
        }
        if ((i & 4) != 0) {
            finiteAnimationSpec3 = animateItemElement.fadeOutSpec;
        }
        return animateItemElement.copy(finiteAnimationSpec, finiteAnimationSpec2, finiteAnimationSpec3);
    }

    public final FiniteAnimationSpec<Float> component1() {
        return this.fadeInSpec;
    }

    public final FiniteAnimationSpec<IntOffset> component2() {
        return this.placementSpec;
    }

    public final FiniteAnimationSpec<Float> component3() {
        return this.fadeOutSpec;
    }

    public final AnimateItemElement copy(FiniteAnimationSpec<Float> fadeInSpec, FiniteAnimationSpec<IntOffset> placementSpec, FiniteAnimationSpec<Float> fadeOutSpec) {
        return new AnimateItemElement(fadeInSpec, placementSpec, fadeOutSpec);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimateItemElement)) {
            return false;
        }
        AnimateItemElement animateItemElement = (AnimateItemElement) other;
        return Intrinsics.areEqual(this.fadeInSpec, animateItemElement.fadeInSpec) && Intrinsics.areEqual(this.placementSpec, animateItemElement.placementSpec) && Intrinsics.areEqual(this.fadeOutSpec, animateItemElement.fadeOutSpec);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public int hashCode() {
        return ((((this.fadeInSpec == null ? 0 : this.fadeInSpec.hashCode()) * 31) + (this.placementSpec == null ? 0 : this.placementSpec.hashCode())) * 31) + (this.fadeOutSpec != null ? this.fadeOutSpec.hashCode() : 0);
    }

    public String toString() {
        return "AnimateItemElement(fadeInSpec=" + this.fadeInSpec + ", placementSpec=" + this.placementSpec + ", fadeOutSpec=" + this.fadeOutSpec + ')';
    }

    public final FiniteAnimationSpec<Float> getFadeInSpec() {
        return this.fadeInSpec;
    }

    public final FiniteAnimationSpec<IntOffset> getPlacementSpec() {
        return this.placementSpec;
    }

    public final FiniteAnimationSpec<Float> getFadeOutSpec() {
        return this.fadeOutSpec;
    }

    public AnimateItemElement(FiniteAnimationSpec<Float> finiteAnimationSpec, FiniteAnimationSpec<IntOffset> finiteAnimationSpec2, FiniteAnimationSpec<Float> finiteAnimationSpec3) {
        this.fadeInSpec = finiteAnimationSpec;
        this.placementSpec = finiteAnimationSpec2;
        this.fadeOutSpec = finiteAnimationSpec3;
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public LazyLayoutAnimationSpecsNode create() {
        return new LazyLayoutAnimationSpecsNode(this.fadeInSpec, this.placementSpec, this.fadeOutSpec);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public void update(LazyLayoutAnimationSpecsNode node) {
        node.setFadeInSpec(this.fadeInSpec);
        node.setPlacementSpec(this.placementSpec);
        node.setFadeOutSpec(this.fadeOutSpec);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("animateItem");
        $this$inspectableProperties.getProperties().set("fadeInSpec", this.fadeInSpec);
        $this$inspectableProperties.getProperties().set("placementSpec", this.placementSpec);
        $this$inspectableProperties.getProperties().set("fadeOutSpec", this.fadeOutSpec);
    }
}
