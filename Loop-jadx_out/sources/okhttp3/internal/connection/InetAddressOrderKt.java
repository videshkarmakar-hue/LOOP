package okhttp3.internal.connection;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilCommonKt;

/* JADX INFO: compiled from: InetAddressOrder.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0004"}, m195d2 = {"reorderForHappyEyeballs", "", "Ljava/net/InetAddress;", "addresses", "okhttp"}, m196k = 2, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class InetAddressOrderKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final List<InetAddress> reorderForHappyEyeballs(List<? extends InetAddress> addresses) {
        Intrinsics.checkNotNullParameter(addresses, "addresses");
        if (addresses.size() < 2) {
            return addresses;
        }
        List<? extends InetAddress> $this$partition$iv = addresses;
        ArrayList first$iv = new ArrayList();
        ArrayList second$iv = new ArrayList();
        for (Object element$iv : $this$partition$iv) {
            InetAddress it = (InetAddress) element$iv;
            if (it instanceof Inet6Address) {
                first$iv.add(element$iv);
            } else {
                second$iv.add(element$iv);
            }
        }
        Pair pair = new Pair(first$iv, second$iv);
        List ipv6 = (List) pair.component1();
        List ipv4 = (List) pair.component2();
        if (ipv6.isEmpty() || ipv4.isEmpty()) {
            return addresses;
        }
        return _UtilCommonKt.interleave(ipv6, ipv4);
    }
}
