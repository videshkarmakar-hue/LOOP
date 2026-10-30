package androidx.compose.ui.layout;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LookaheadScope.kt */
/* JADX INFO: loaded from: classes17.dex */
@Deprecated(message = "IntermediateMeasureScope has been renamed to ApproachMeasureScope", replaceWith = @ReplaceWith(expression = "ApproachMeasureScope", imports = {}))
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/IntermediateMeasureScope;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/layout/LookaheadScope;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface IntermediateMeasureScope extends ApproachMeasureScope, CoroutineScope, LookaheadScope {
}
