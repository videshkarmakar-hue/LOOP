package androidx.compose.foundation.lazy.layout;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LazyLayoutPrefetchState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, m195d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "", "prefetchExecutor", "Landroidx/compose/foundation/lazy/layout/PrefetchExecutor;", "(Landroidx/compose/foundation/lazy/layout/PrefetchExecutor;)V", "getPrefetchExecutor$foundation_release", "()Landroidx/compose/foundation/lazy/layout/PrefetchExecutor;", "prefetchHandleProvider", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "getPrefetchHandleProvider$foundation_release", "()Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "setPrefetchHandleProvider$foundation_release", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;)V", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "schedulePrefetch", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "schedulePrefetch-0kLqBqw", "(IJ)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "PrefetchHandle", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LazyLayoutPrefetchState {
    public static final int $stable = 0;
    private final PrefetchExecutor prefetchExecutor;
    private PrefetchHandleProvider prefetchHandleProvider;
    private final PrefetchMetrics prefetchMetrics;

    /* JADX INFO: compiled from: LazyLayoutPrefetchState.kt */
    @Metadata(m194d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, m195d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "", "cancel", "", "Landroidx/compose/foundation/lazy/layout/DummyHandle;", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public interface PrefetchHandle {
        void cancel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LazyLayoutPrefetchState() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public LazyLayoutPrefetchState(PrefetchExecutor prefetchExecutor) {
        this.prefetchExecutor = prefetchExecutor;
        this.prefetchMetrics = new PrefetchMetrics();
    }

    public /* synthetic */ LazyLayoutPrefetchState(PrefetchExecutor prefetchExecutor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : prefetchExecutor);
    }

    /* JADX INFO: renamed from: getPrefetchExecutor$foundation_release, reason: from getter */
    public final PrefetchExecutor getPrefetchExecutor() {
        return this.prefetchExecutor;
    }

    /* JADX INFO: renamed from: getPrefetchHandleProvider$foundation_release, reason: from getter */
    public final PrefetchHandleProvider getPrefetchHandleProvider() {
        return this.prefetchHandleProvider;
    }

    public final void setPrefetchHandleProvider$foundation_release(PrefetchHandleProvider prefetchHandleProvider) {
        this.prefetchHandleProvider = prefetchHandleProvider;
    }

    /* JADX INFO: renamed from: schedulePrefetch-0kLqBqw, reason: not valid java name */
    public final PrefetchHandle m1040schedulePrefetch0kLqBqw(int index, long constraints) {
        PrefetchHandle prefetchHandleM1052schedulePrefetchVKLhPVY;
        PrefetchHandleProvider prefetchHandleProvider = this.prefetchHandleProvider;
        if (prefetchHandleProvider != null && (prefetchHandleM1052schedulePrefetchVKLhPVY = prefetchHandleProvider.m1052schedulePrefetchVKLhPVY(index, constraints, this.prefetchMetrics)) != null) {
            return prefetchHandleM1052schedulePrefetchVKLhPVY;
        }
        return DummyHandle.INSTANCE;
    }
}
