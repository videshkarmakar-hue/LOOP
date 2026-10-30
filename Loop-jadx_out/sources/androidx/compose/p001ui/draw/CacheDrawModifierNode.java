package androidx.compose.p001ui.draw;

import androidx.compose.p001ui.node.DrawModifierNode;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: DrawModifier.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u0082\u0001\u0001\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, m195d2 = {"Landroidx/compose/ui/draw/CacheDrawModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "invalidateDrawCache", "", "Landroidx/compose/ui/draw/CacheDrawModifierNodeImpl;", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface CacheDrawModifierNode extends DrawModifierNode {
    void invalidateDrawCache();
}
