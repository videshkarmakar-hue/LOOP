package androidx.compose.foundation.lazy.layout;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LazyLayoutPrefetchState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001c\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0080\b¢\u0006\u0002\b\u0011J\u001c\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0080\b¢\u0006\u0002\b\u0014R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0015"}, m195d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "", "()V", "<set-?>", "", "averageCompositionTimeNanos", "getAverageCompositionTimeNanos", "()J", "averageMeasureTimeNanos", "getAverageMeasureTimeNanos", "calculateAverageTime", "new", "current", "recordCompositionTiming", "", "doComposition", "Lkotlin/Function0;", "recordCompositionTiming$foundation_release", "recordMeasureTiming", "doMeasure", "recordMeasureTiming$foundation_release", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PrefetchMetrics {
    public static final int $stable = 8;
    private long averageCompositionTimeNanos;
    private long averageMeasureTimeNanos;

    public final long getAverageCompositionTimeNanos() {
        return this.averageCompositionTimeNanos;
    }

    public final long getAverageMeasureTimeNanos() {
        return this.averageMeasureTimeNanos;
    }

    public final void recordCompositionTiming$foundation_release(Function0<Unit> doComposition) {
        long start$iv = System.nanoTime();
        doComposition.invoke();
        long executionTime = System.nanoTime() - start$iv;
        this.averageCompositionTimeNanos = calculateAverageTime(executionTime, getAverageCompositionTimeNanos());
    }

    public final void recordMeasureTiming$foundation_release(Function0<Unit> doMeasure) {
        long start$iv = System.nanoTime();
        doMeasure.invoke();
        long executionTime = System.nanoTime() - start$iv;
        this.averageMeasureTimeNanos = calculateAverageTime(executionTime, getAverageMeasureTimeNanos());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long calculateAverageTime(long j, long current) {
        if (current == 0) {
            return j;
        }
        long j2 = 4;
        return ((current / j2) * ((long) 3)) + (j / j2);
    }
}
