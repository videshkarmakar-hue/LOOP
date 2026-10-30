package androidx.compose.runtime.snapshots;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;

/* JADX INFO: compiled from: SnapshotIdSet.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0004"}, m195d2 = {"binarySearch", "", "", DownloadUtil.CookieScheme.VALUE, "runtime_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SnapshotIdSetKt {
    public static final int binarySearch(int[] $this$binarySearch, int value) {
        int low = 0;
        int high = $this$binarySearch.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = $this$binarySearch[mid];
            if (value > midVal) {
                low = mid + 1;
            } else if (value < midVal) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }
}
