package androidx.compose.p001ui.layout;

import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: IntrinsicMeasureScope.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, m195d2 = {"Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/unit/Density;", "isLookingAhead", "", "()Z", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface IntrinsicMeasureScope extends Density {
    LayoutDirection getLayoutDirection();

    boolean isLookingAhead();

    /* JADX INFO: renamed from: androidx.compose.ui.layout.IntrinsicMeasureScope$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: IntrinsicMeasureScope.kt */
    public final /* synthetic */ class CC {
        public static boolean $default$isLookingAhead(IntrinsicMeasureScope _this) {
            return false;
        }
    }
}
