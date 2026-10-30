package androidx.compose.p001ui.layout;

import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.node.LookaheadDelegate;
import androidx.compose.p001ui.node.NodeCoordinator;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LookaheadScope.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\f\u0010\r\u001a\u00020\u0004*\u00020\u0004H\u0016R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0018\u0010\t\u001a\u00020\u0004*\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, m195d2 = {"Landroidx/compose/ui/layout/LookaheadScopeImpl;", "Landroidx/compose/ui/layout/LookaheadScope;", "scopeCoordinates", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Lkotlin/jvm/functions/Function0;)V", "getScopeCoordinates", "()Lkotlin/jvm/functions/Function0;", "setScopeCoordinates", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "toLookaheadCoordinates", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LookaheadScopeImpl implements LookaheadScope {
    public static final int $stable = 8;
    private Function0<? extends LayoutCoordinates> scopeCoordinates;

    /* JADX WARN: Multi-variable type inference failed */
    public LookaheadScopeImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // androidx.compose.p001ui.layout.LookaheadScope
    /* JADX INFO: renamed from: localLookaheadPositionOf-dBAh8RU */
    public /* synthetic */ long mo5620localLookaheadPositionOfdBAh8RU(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2) {
        return toLookaheadCoordinates(layoutCoordinates).mo5647localPositionOfR5De75A(toLookaheadCoordinates(layoutCoordinates2), Offset.INSTANCE.m4065getZeroF1C5BW0());
    }

    public LookaheadScopeImpl(Function0<? extends LayoutCoordinates> function0) {
        this.scopeCoordinates = function0;
    }

    public /* synthetic */ LookaheadScopeImpl(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function0);
    }

    public final Function0<LayoutCoordinates> getScopeCoordinates() {
        return this.scopeCoordinates;
    }

    public final void setScopeCoordinates(Function0<? extends LayoutCoordinates> function0) {
        this.scopeCoordinates = function0;
    }

    @Override // androidx.compose.p001ui.layout.LookaheadScope
    public LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates $this$toLookaheadCoordinates) {
        LookaheadLayoutCoordinates lookaheadLayoutCoordinates;
        LookaheadLayoutCoordinates lookaheadLayoutCoordinates2 = $this$toLookaheadCoordinates instanceof LookaheadLayoutCoordinates ? (LookaheadLayoutCoordinates) $this$toLookaheadCoordinates : null;
        if (lookaheadLayoutCoordinates2 != null) {
            return lookaheadLayoutCoordinates2;
        }
        Intrinsics.checkNotNull($this$toLookaheadCoordinates, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        NodeCoordinator it = (NodeCoordinator) $this$toLookaheadCoordinates;
        LookaheadDelegate lookaheadDelegate = it.getLookaheadDelegate();
        return (lookaheadDelegate == null || (lookaheadLayoutCoordinates = lookaheadDelegate.getLookaheadLayoutCoordinates()) == null) ? it : lookaheadLayoutCoordinates;
    }

    @Override // androidx.compose.p001ui.layout.LookaheadScope
    public LayoutCoordinates getLookaheadScopeCoordinates(Placeable.PlacementScope $this$lookaheadScopeCoordinates) {
        Function0<? extends LayoutCoordinates> function0 = this.scopeCoordinates;
        Intrinsics.checkNotNull(function0);
        return function0.invoke();
    }
}
