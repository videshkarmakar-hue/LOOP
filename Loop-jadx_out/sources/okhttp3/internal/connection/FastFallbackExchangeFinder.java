package okhttp3.internal.connection;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;

/* JADX INFO: compiled from: FastFallbackExchangeFinder.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m195d2 = {"Lokhttp3/internal/connection/FastFallbackExchangeFinder;", "Lokhttp3/internal/connection/ExchangeFinder;", "routePlanner", "Lokhttp3/internal/connection/RoutePlanner;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "(Lokhttp3/internal/connection/RoutePlanner;Lokhttp3/internal/concurrent/TaskRunner;)V", "connectDelayNanos", "", "connectResults", "Ljava/util/concurrent/BlockingQueue;", "Lokhttp3/internal/connection/RoutePlanner$ConnectResult;", "kotlin.jvm.PlatformType", "nextTcpConnectAtNanos", "getRoutePlanner", "()Lokhttp3/internal/connection/RoutePlanner;", "tcpConnectsInFlight", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lokhttp3/internal/connection/RoutePlanner$Plan;", "awaitTcpConnect", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "cancelInFlightConnects", "", "find", "Lokhttp3/internal/connection/RealConnection;", "launchTcpConnect", "okhttp"}, m196k = 1, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FastFallbackExchangeFinder implements ExchangeFinder {
    private final long connectDelayNanos;
    private final BlockingQueue<RoutePlanner.ConnectResult> connectResults;
    private long nextTcpConnectAtNanos;
    private final RoutePlanner routePlanner;
    private final TaskRunner taskRunner;
    private final CopyOnWriteArrayList<RoutePlanner.Plan> tcpConnectsInFlight;

    public FastFallbackExchangeFinder(RoutePlanner routePlanner, TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter(routePlanner, "routePlanner");
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        this.routePlanner = routePlanner;
        this.taskRunner = taskRunner;
        this.connectDelayNanos = TimeUnit.MILLISECONDS.toNanos(250L);
        this.nextTcpConnectAtNanos = Long.MIN_VALUE;
        this.tcpConnectsInFlight = new CopyOnWriteArrayList<>();
        this.connectResults = this.taskRunner.getBackend().decorate(new LinkedBlockingDeque());
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public RealConnection find() throws IOException {
        IOException firstException = null;
        while (true) {
            try {
                if ((!this.tcpConnectsInFlight.isEmpty()) || RoutePlanner.CC.hasNext$default(getRoutePlanner(), null, 1, null)) {
                    if (getRoutePlanner().isCanceled()) {
                        throw new IOException("Canceled");
                    }
                    long now = this.taskRunner.getBackend().nanoTime();
                    long awaitTimeoutNanos = this.nextTcpConnectAtNanos - now;
                    RoutePlanner.ConnectResult connectResult = null;
                    if (this.tcpConnectsInFlight.isEmpty() || awaitTimeoutNanos <= 0) {
                        connectResult = launchTcpConnect();
                        this.nextTcpConnectAtNanos = this.connectDelayNanos + now;
                        awaitTimeoutNanos = this.connectDelayNanos;
                    }
                    if (connectResult == null) {
                        RoutePlanner.ConnectResult connectResultAwaitTcpConnect = awaitTcpConnect(awaitTimeoutNanos, TimeUnit.NANOSECONDS);
                        if (connectResultAwaitTcpConnect != null) {
                            connectResult = connectResultAwaitTcpConnect;
                        }
                    }
                    if (connectResult.isSuccess()) {
                        cancelInFlightConnects();
                        if (!connectResult.getPlan().getIsReady()) {
                            connectResult = connectResult.getPlan().mo9451connectTlsEtc();
                        }
                        if (connectResult.isSuccess()) {
                            RealConnection realConnectionMo9447handleSuccess = connectResult.getPlan().mo9447handleSuccess();
                            cancelInFlightConnects();
                            return realConnectionMo9447handleSuccess;
                        }
                    }
                    Throwable throwable = connectResult.getThrowable();
                    if (throwable != null) {
                        if (!(throwable instanceof IOException)) {
                            throw throwable;
                        }
                        if (firstException == null) {
                            firstException = (IOException) throwable;
                        } else {
                            ExceptionsKt.addSuppressed(firstException, throwable);
                        }
                    }
                    RoutePlanner.Plan nextPlan = connectResult.getNextPlan();
                    if (nextPlan != null) {
                        getRoutePlanner().getDeferredPlans().addFirst(nextPlan);
                    }
                } else {
                    cancelInFlightConnects();
                    Intrinsics.checkNotNull(firstException);
                    throw firstException;
                }
            } catch (Throwable th) {
                cancelInFlightConnects();
                throw th;
            }
        }
    }

    private final RoutePlanner.ConnectResult launchTcpConnect() {
        final RoutePlanner.Plan plan;
        if (!RoutePlanner.CC.hasNext$default(getRoutePlanner(), null, 1, null)) {
            return null;
        }
        try {
            plan = getRoutePlanner().plan();
        } catch (Throwable e) {
            plan = new FailedPlan(e);
        }
        if (plan.getIsReady()) {
            return new RoutePlanner.ConnectResult(plan, null, null, 6, null);
        }
        if (plan instanceof FailedPlan) {
            return ((FailedPlan) plan).getResult();
        }
        this.tcpConnectsInFlight.add(plan);
        String taskName = _UtilJvmKt.okHttpName + " connect " + getRoutePlanner().getAddress().url().redact();
        TaskQueue.schedule$default(this.taskRunner.newQueue(), new Task(taskName) { // from class: okhttp3.internal.connection.FastFallbackExchangeFinder.launchTcpConnect.1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() throws InterruptedException {
                RoutePlanner.ConnectResult connectResult;
                try {
                    connectResult = plan.getResult();
                } catch (Throwable e2) {
                    connectResult = new RoutePlanner.ConnectResult(plan, null, e2, 2, null);
                }
                if (this.tcpConnectsInFlight.contains(plan)) {
                    this.connectResults.put(connectResult);
                    return -1L;
                }
                return -1L;
            }
        }, 0L, 2, null);
        return null;
    }

    private final RoutePlanner.ConnectResult awaitTcpConnect(long timeout, TimeUnit unit) {
        RoutePlanner.ConnectResult result;
        if (this.tcpConnectsInFlight.isEmpty() || (result = this.connectResults.poll(timeout, unit)) == null) {
            return null;
        }
        this.tcpConnectsInFlight.remove(result.getPlan());
        return result;
    }

    private final void cancelInFlightConnects() {
        for (RoutePlanner.Plan plan : this.tcpConnectsInFlight) {
            plan.mo9446cancel();
            RoutePlanner.Plan retry = plan.mo9448retry();
            if (retry != null) {
                getRoutePlanner().getDeferredPlans().addLast(retry);
            }
        }
        this.tcpConnectsInFlight.clear();
    }
}
