package androidx.compose.runtime;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;

/* JADX INFO: compiled from: SnapshotIntState.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0012\u0010\u0003\u001a\u00020\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00028WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0003"}, m195d2 = {"Landroidx/compose/runtime/IntState;", "Landroidx/compose/runtime/State;", "", "intValue", "getIntValue", "()I", DownloadUtil.CookieScheme.VALUE, "getValue", "()Ljava/lang/Integer;", "runtime_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface IntState extends State<Integer> {
    int getIntValue();

    @Override // androidx.compose.runtime.State
    Integer getValue();

    /* JADX INFO: renamed from: androidx.compose.runtime.IntState$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: SnapshotIntState.kt */
    public final /* synthetic */ class CC {
        public static /* synthetic */ int access$getValue$jd(IntState $this) {
            return $default$getValue($this).intValue();
        }

        public static Integer $default$getValue(IntState _this) {
            return Integer.valueOf(_this.getIntValue());
        }
    }

    /* JADX INFO: compiled from: SnapshotIntState.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        @Deprecated
        public static Integer getValue(IntState $this) {
            return Integer.valueOf(CC.access$getValue$jd($this));
        }
    }
}
