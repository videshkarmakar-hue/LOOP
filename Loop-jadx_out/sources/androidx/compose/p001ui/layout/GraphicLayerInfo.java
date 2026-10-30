package androidx.compose.p001ui.layout;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: GraphicLayerInfo.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0003"}, m195d2 = {"Landroidx/compose/ui/layout/GraphicLayerInfo;", "", "layerId", "", "getLayerId", "()J", "ownerViewId", "getOwnerViewId", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface GraphicLayerInfo {
    long getLayerId();

    long getOwnerViewId();

    /* JADX INFO: renamed from: androidx.compose.ui.layout.GraphicLayerInfo$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: GraphicLayerInfo.android.kt */
    public final /* synthetic */ class CC {
        public static long $default$getOwnerViewId(GraphicLayerInfo _this) {
            return 0L;
        }
    }

    /* JADX INFO: compiled from: GraphicLayerInfo.android.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        @Deprecated
        public static long getOwnerViewId(GraphicLayerInfo $this) {
            return CC.$default$getOwnerViewId($this);
        }
    }
}
