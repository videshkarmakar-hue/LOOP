package androidx.compose.foundation.lazy.layout;

import android.view.Choreographer;
import android.view.Display;
import android.view.View;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: PrefetchExecutor.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0001\u0018\u0000 \u001b2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u001b\u001cB\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m195d2 = {"Landroidx/compose/foundation/lazy/layout/AndroidPrefetchExecutor;", "Landroidx/compose/foundation/lazy/layout/PrefetchExecutor;", "Landroidx/compose/runtime/RememberObserver;", "Ljava/lang/Runnable;", "Landroid/view/Choreographer$FrameCallback;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "choreographer", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "isActive", "", "prefetchRequests", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "prefetchScheduled", "doFrame", "", "frameTimeNanos", "", "onAbandoned", "onForgotten", "onRemembered", "requestPrefetch", "prefetchRequest", "run", "Companion", "PrefetchRequestScopeImpl", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidPrefetchExecutor implements PrefetchExecutor, RememberObserver, Runnable, Choreographer.FrameCallback {
    private static long frameIntervalNs;
    private boolean isActive;
    private boolean prefetchScheduled;
    private final View view;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final MutableVector<PrefetchRequest> prefetchRequests = new MutableVector<>(new PrefetchRequest[16], 0);
    private final Choreographer choreographer = Choreographer.getInstance();

    public AndroidPrefetchExecutor(View view) {
        this.view = view;
        INSTANCE.calculateFrameIntervalIfNeeded(this.view);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.prefetchRequests.isEmpty() || !this.prefetchScheduled || !this.isActive || this.view.getWindowVisibility() != 0) {
            this.prefetchScheduled = false;
            return;
        }
        long latestFrameVsyncNs = TimeUnit.MILLISECONDS.toNanos(this.view.getDrawingTime());
        long nextFrameNs = frameIntervalNs + latestFrameVsyncNs;
        boolean oneOverTimeTaskAllowed = System.nanoTime() > nextFrameNs;
        PrefetchRequestScopeImpl scope = new PrefetchRequestScopeImpl(nextFrameNs, oneOverTimeTaskAllowed);
        boolean scheduleForNextFrame = false;
        while (this.prefetchRequests.isNotEmpty() && !scheduleForNextFrame) {
            PrefetchRequest request = this.prefetchRequests.getContent()[0];
            boolean hasMoreWorkToDo = request.execute(scope);
            if (hasMoreWorkToDo) {
                scheduleForNextFrame = true;
            } else {
                this.prefetchRequests.removeAt(0);
            }
        }
        if (scheduleForNextFrame) {
            this.choreographer.postFrameCallback(this);
        } else {
            this.prefetchScheduled = false;
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long frameTimeNanos) {
        if (this.isActive) {
            this.view.post(this);
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.PrefetchExecutor
    public void requestPrefetch(PrefetchRequest prefetchRequest) {
        this.prefetchRequests.add(prefetchRequest);
        if (!this.prefetchScheduled) {
            this.prefetchScheduled = true;
            this.view.post(this);
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        this.isActive = true;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        this.isActive = false;
        this.view.removeCallbacks(this);
        this.choreographer.removeFrameCallback(this);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
    }

    /* JADX INFO: compiled from: PrefetchExecutor.android.kt */
    @Metadata(m194d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m195d2 = {"Landroidx/compose/foundation/lazy/layout/AndroidPrefetchExecutor$PrefetchRequestScopeImpl;", "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "nextFrameTimeNs", "", "isOneOverTimeTaskAllowed", "", "(JZ)V", "availableTimeNanos", "getAvailableTimeNanos", "()J", "canDoOverTimeTask", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class PrefetchRequestScopeImpl implements PrefetchRequestScope {
        public static final int $stable = 8;
        private boolean canDoOverTimeTask;
        private final long nextFrameTimeNs;

        public PrefetchRequestScopeImpl(long nextFrameTimeNs, boolean isOneOverTimeTaskAllowed) {
            this.nextFrameTimeNs = nextFrameTimeNs;
            this.canDoOverTimeTask = isOneOverTimeTaskAllowed;
        }

        @Override // androidx.compose.foundation.lazy.layout.PrefetchRequestScope
        public long getAvailableTimeNanos() {
            if (this.canDoOverTimeTask) {
                this.canDoOverTimeTask = false;
                return Long.MAX_VALUE;
            }
            return Math.max(0L, this.nextFrameTimeNs - System.nanoTime());
        }
    }

    /* JADX INFO: compiled from: PrefetchExecutor.android.kt */
    @Metadata(m194d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, m195d2 = {"Landroidx/compose/foundation/lazy/layout/AndroidPrefetchExecutor$Companion;", "", "()V", "frameIntervalNs", "", "calculateFrameIntervalIfNeeded", "", "view", "Landroid/view/View;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void calculateFrameIntervalIfNeeded(View view) {
            if (AndroidPrefetchExecutor.frameIntervalNs == 0) {
                Display display = view.getDisplay();
                float refreshRate = 60.0f;
                if (!view.isInEditMode() && display != null) {
                    float displayRefreshRate = display.getRefreshRate();
                    if (displayRefreshRate >= 30.0f) {
                        refreshRate = displayRefreshRate;
                    }
                }
                AndroidPrefetchExecutor.frameIntervalNs = (long) (Http2Connection.DEGRADED_PONG_TIMEOUT_NS / refreshRate);
            }
        }
    }
}
