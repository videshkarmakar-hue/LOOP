package okhttp3.internal.connection;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SequentialExchangeFinder.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m195d2 = {"Lokhttp3/internal/connection/SequentialExchangeFinder;", "Lokhttp3/internal/connection/ExchangeFinder;", "routePlanner", "Lokhttp3/internal/connection/RoutePlanner;", "(Lokhttp3/internal/connection/RoutePlanner;)V", "getRoutePlanner", "()Lokhttp3/internal/connection/RoutePlanner;", "find", "Lokhttp3/internal/connection/RealConnection;", "okhttp"}, m196k = 1, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SequentialExchangeFinder implements ExchangeFinder {
    private final RoutePlanner routePlanner;

    public SequentialExchangeFinder(RoutePlanner routePlanner) {
        Intrinsics.checkNotNullParameter(routePlanner, "routePlanner");
        this.routePlanner = routePlanner;
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public RealConnection find() throws Throwable {
        IOException firstException = null;
        while (!getRoutePlanner().isCanceled()) {
            try {
                RoutePlanner.Plan plan = getRoutePlanner().plan();
                if (!plan.getIsReady()) {
                    RoutePlanner.ConnectResult tcpConnectResult = plan.getResult();
                    RoutePlanner.ConnectResult connectResult = tcpConnectResult.isSuccess() ? plan.mo9451connectTlsEtc() : tcpConnectResult;
                    RoutePlanner.Plan nextPlan = connectResult.getNextPlan();
                    Throwable failure = connectResult.getThrowable();
                    if (failure != null) {
                        throw failure;
                    }
                    if (nextPlan != null) {
                        getRoutePlanner().getDeferredPlans().addFirst(nextPlan);
                    }
                }
                return plan.mo9447handleSuccess();
            } catch (IOException e) {
                if (firstException == null) {
                    firstException = e;
                } else {
                    ExceptionsKt.addSuppressed(firstException, e);
                }
                if (!RoutePlanner.CC.hasNext$default(getRoutePlanner(), null, 1, null)) {
                    throw firstException;
                }
            }
        }
        throw new IOException("Canceled");
    }
}
