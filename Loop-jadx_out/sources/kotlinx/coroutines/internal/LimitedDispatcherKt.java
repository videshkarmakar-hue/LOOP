package kotlinx.coroutines.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: LimitedDispatcher.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, m195d2 = {"checkParallelism", "", "", "kotlinx-coroutines-core"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LimitedDispatcherKt {
    public static final void checkParallelism(int $this$checkParallelism) {
        if (!($this$checkParallelism >= 1)) {
            throw new IllegalArgumentException(("Expected positive parallelism level, but got " + $this$checkParallelism).toString());
        }
    }
}
