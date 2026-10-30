package androidx.compose.p001ui.platform;

import android.graphics.Rect;
import androidx.compose.p001ui.semantics.SemanticsNode;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: SemanticsUtils.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m195d2 = {"Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "adjustedBounds", "Landroid/graphics/Rect;", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroid/graphics/Rect;)V", "getAdjustedBounds", "()Landroid/graphics/Rect;", "getSemanticsNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SemanticsNodeWithAdjustedBounds {
    public static final int $stable = 8;
    private final Rect adjustedBounds;
    private final SemanticsNode semanticsNode;

    public SemanticsNodeWithAdjustedBounds(SemanticsNode semanticsNode, Rect adjustedBounds) {
        this.semanticsNode = semanticsNode;
        this.adjustedBounds = adjustedBounds;
    }

    public final SemanticsNode getSemanticsNode() {
        return this.semanticsNode;
    }

    public final Rect getAdjustedBounds() {
        return this.adjustedBounds;
    }
}
