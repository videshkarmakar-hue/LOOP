package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import androidx.compose.p001ui.layout.SubcomposeLayoutState;
import androidx.compose.p001ui.unit.Constraints;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LazyLayoutPrefetchState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, m195d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "subcomposeLayoutState", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "executor", "Landroidx/compose/foundation/lazy/layout/PrefetchExecutor;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/foundation/lazy/layout/PrefetchExecutor;)V", "schedulePrefetch", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "schedulePrefetch-VKLhPVY", "(IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "HandleAndRequestImpl", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PrefetchHandleProvider {
    public static final int $stable = 8;
    private final PrefetchExecutor executor;
    private final LazyLayoutItemContentFactory itemContentFactory;
    private final SubcomposeLayoutState subcomposeLayoutState;

    public PrefetchHandleProvider(LazyLayoutItemContentFactory itemContentFactory, SubcomposeLayoutState subcomposeLayoutState, PrefetchExecutor executor) {
        this.itemContentFactory = itemContentFactory;
        this.subcomposeLayoutState = subcomposeLayoutState;
        this.executor = executor;
    }

    /* JADX INFO: renamed from: schedulePrefetch-VKLhPVY, reason: not valid java name */
    public final LazyLayoutPrefetchState.PrefetchHandle m1052schedulePrefetchVKLhPVY(int index, long constraints, PrefetchMetrics prefetchMetrics) {
        HandleAndRequestImpl it = new HandleAndRequestImpl(this, index, constraints, prefetchMetrics, null);
        this.executor.requestPrefetch(it);
        return it;
    }

    /* JADX INFO: compiled from: LazyLayoutPrefetchState.kt */
    @Metadata(m194d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0083\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\f\u0010\u0019\u001a\u00020\f*\u00020\u001aH\u0016R\u0016\u0010\u0005\u001a\u00020\u0006X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, m195d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "isCanceled", "", "isComposed", "()Z", "isMeasured", "isValid", "precomposeHandle", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "cancel", "", "performComposition", "performMeasure", "toString", "", "execute", "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private final class HandleAndRequestImpl implements LazyLayoutPrefetchState.PrefetchHandle, PrefetchRequest {
        private final long constraints;
        private final int index;
        private boolean isCanceled;
        private boolean isMeasured;
        private SubcomposeLayoutState.PrecomposedSlotHandle precomposeHandle;
        private final PrefetchMetrics prefetchMetrics;

        public /* synthetic */ HandleAndRequestImpl(PrefetchHandleProvider prefetchHandleProvider, int i, long j, PrefetchMetrics prefetchMetrics, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, j, prefetchMetrics);
        }

        private HandleAndRequestImpl(int index, long constraints, PrefetchMetrics prefetchMetrics) {
            this.index = index;
            this.constraints = constraints;
            this.prefetchMetrics = prefetchMetrics;
        }

        private final boolean isComposed() {
            return this.precomposeHandle != null;
        }

        private final boolean isValid() {
            if (this.isCanceled) {
                return false;
            }
            int itemCount = PrefetchHandleProvider.this.itemContentFactory.getItemProvider().invoke().getItemCount();
            int i = this.index;
            return i >= 0 && i < itemCount;
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle
        public void cancel() {
            if (!this.isCanceled) {
                this.isCanceled = true;
                SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
                if (precomposedSlotHandle != null) {
                    precomposedSlotHandle.dispose();
                }
                this.precomposeHandle = null;
            }
        }

        @Override // androidx.compose.foundation.lazy.layout.PrefetchRequest
        public boolean execute(PrefetchRequestScope $this$execute) {
            if (!isValid()) {
                return false;
            }
            if (!isComposed()) {
                if (this.prefetchMetrics.getAverageCompositionTimeNanos() >= $this$execute.getAvailableTimeNanos()) {
                    return true;
                }
                PrefetchMetrics this_$iv = this.prefetchMetrics;
                long start$iv$iv = System.nanoTime();
                Trace.beginSection("compose:lazy:prefetch:compose");
                try {
                    performComposition();
                    Unit unit = Unit.INSTANCE;
                    Trace.endSection();
                    long executionTime$iv = System.nanoTime() - start$iv$iv;
                    this_$iv.averageCompositionTimeNanos = this_$iv.calculateAverageTime(executionTime$iv, this_$iv.getAverageCompositionTimeNanos());
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            if (!this.isMeasured) {
                if (this.prefetchMetrics.getAverageMeasureTimeNanos() >= $this$execute.getAvailableTimeNanos()) {
                    return true;
                }
                PrefetchMetrics this_$iv2 = this.prefetchMetrics;
                long start$iv$iv2 = System.nanoTime();
                Trace.beginSection("compose:lazy:prefetch:measure");
                try {
                    performMeasure();
                    Unit unit2 = Unit.INSTANCE;
                    Trace.endSection();
                    long executionTime$iv2 = System.nanoTime() - start$iv$iv2;
                    this_$iv2.averageMeasureTimeNanos = this_$iv2.calculateAverageTime(executionTime$iv2, this_$iv2.getAverageMeasureTimeNanos());
                } catch (Throwable th2) {
                    Trace.endSection();
                    throw th2;
                }
            }
            return false;
        }

        private final void performComposition() {
            if (!isValid()) {
                throw new IllegalArgumentException("Callers should check whether the request is still valid before calling performComposition()".toString());
            }
            if (!(this.precomposeHandle == null)) {
                throw new IllegalArgumentException("Request was already composed!".toString());
            }
            LazyLayoutItemProvider itemProvider = PrefetchHandleProvider.this.itemContentFactory.getItemProvider().invoke();
            Object key = itemProvider.getKey(this.index);
            Object contentType = itemProvider.getContentType(this.index);
            this.precomposeHandle = PrefetchHandleProvider.this.subcomposeLayoutState.precompose(key, PrefetchHandleProvider.this.itemContentFactory.getContent(this.index, key, contentType));
        }

        private final void performMeasure() {
            if (!(!this.isCanceled)) {
                throw new IllegalArgumentException("Callers should check whether the request is still valid before calling performMeasure()".toString());
            }
            if (!(!this.isMeasured)) {
                throw new IllegalArgumentException("Request was already measured!".toString());
            }
            this.isMeasured = true;
            SubcomposeLayoutState.PrecomposedSlotHandle handle = this.precomposeHandle;
            if (handle == null) {
                throw new IllegalArgumentException("performComposition() must be called before performMeasure()".toString());
            }
            int placeablesCount = handle.getPlaceablesCount();
            for (int i = 0; i < placeablesCount; i++) {
                int placeableIndex = i;
                handle.mo5669premeasure0kLqBqw(placeableIndex, this.constraints);
            }
        }

        public String toString() {
            return "HandleAndRequestImpl { index = " + this.index + ", constraints = " + ((Object) Constraints.m6749toStringimpl(this.constraints)) + ", isComposed = " + isComposed() + ", isMeasured = " + this.isMeasured + ", isCanceled = " + this.isCanceled + " }";
        }
    }
}
