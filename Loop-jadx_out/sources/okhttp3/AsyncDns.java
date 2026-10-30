package okhttp3;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.caverock.androidsvg.SVGParser;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AsyncDns.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \t2\u00020\u0001:\u0003\b\t\nJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, m195d2 = {"Lokhttp3/AsyncDns;", "", "query", "", "hostname", "", "callback", "Lokhttp3/AsyncDns$Callback;", "Callback", "Companion", "DnsClass", "okhttp"}, m196k = 1, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface AsyncDns {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int TYPE_A = 1;
    public static final int TYPE_AAAA = 28;

    /* JADX INFO: compiled from: AsyncDns.kt */
    @Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH&J\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, m195d2 = {"Lokhttp3/AsyncDns$Callback;", "", "onFailure", "", "hostname", "", "e", "Ljava/io/IOException;", "Lokio/IOException;", "onResponse", "addresses", "", "Ljava/net/InetAddress;", "okhttp"}, m196k = 1, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public interface Callback {
        void onFailure(String hostname, IOException e);

        void onResponse(String hostname, List<? extends InetAddress> addresses);
    }

    void query(String hostname, Callback callback);

    /* JADX INFO: compiled from: AsyncDns.kt */
    @Metadata(m194d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m195d2 = {"Lokhttp3/AsyncDns$DnsClass;", "", SVGParser.XML_STYLESHEET_ATTR_TYPE, "", "(Ljava/lang/String;II)V", "getType", "()I", "IPV4", "IPV6", "okhttp"}, m196k = 1, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public enum DnsClass {
        IPV4(1),
        IPV6(28);

        private final int type;

        DnsClass(int type) {
            this.type = type;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: AsyncDns.kt */
    @Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, m195d2 = {"Lokhttp3/AsyncDns$Companion;", "", "()V", "TYPE_A", "", "TYPE_AAAA", "toDns", "Lokhttp3/Dns;", "asyncDns", "", "Lokhttp3/AsyncDns;", "([Lokhttp3/AsyncDns;)Lokhttp3/Dns;", "okhttp"}, m196k = 1, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int TYPE_A = 1;
        public static final int TYPE_AAAA = 28;

        private Companion() {
        }

        public final Dns toDns(final AsyncDns... asyncDns) {
            Intrinsics.checkNotNullParameter(asyncDns, "asyncDns");
            return new Dns() { // from class: okhttp3.AsyncDns$Companion$$ExternalSyntheticLambda0
                @Override // okhttp3.Dns
                public final List lookup(String str) {
                    return AsyncDns.Companion.m9318toDns$lambda2(asyncDns, str);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: toDns$lambda-2, reason: not valid java name */
        public static final List m9318toDns$lambda2(AsyncDns[] asyncDns, String hostname) throws InterruptedException, IOException {
            Intrinsics.checkNotNullParameter(asyncDns, "$asyncDns");
            Intrinsics.checkNotNullParameter(hostname, "hostname");
            final List allAddresses = new ArrayList();
            final List allExceptions = new ArrayList();
            final CountDownLatch latch = new CountDownLatch(asyncDns.length);
            for (AsyncDns asyncDns2 : asyncDns) {
                asyncDns2.query(hostname, new Callback() { // from class: okhttp3.AsyncDns$Companion$toDns$1$1$1
                    @Override // okhttp3.AsyncDns.Callback
                    public void onResponse(String hostname2, List<? extends InetAddress> addresses) {
                        Intrinsics.checkNotNullParameter(hostname2, "hostname");
                        Intrinsics.checkNotNullParameter(addresses, "addresses");
                        List<InetAddress> list = allAddresses;
                        List<InetAddress> list2 = allAddresses;
                        synchronized (list) {
                            list2.addAll(addresses);
                        }
                        latch.countDown();
                    }

                    @Override // okhttp3.AsyncDns.Callback
                    public void onFailure(String hostname2, IOException e) {
                        Intrinsics.checkNotNullParameter(hostname2, "hostname");
                        Intrinsics.checkNotNullParameter(e, "e");
                        List<IOException> list = allExceptions;
                        List<IOException> list2 = allExceptions;
                        synchronized (list) {
                            list2.add(e);
                        }
                        latch.countDown();
                    }
                });
            }
            latch.await();
            if (allAddresses.isEmpty()) {
                UnknownHostException first = (IOException) CollectionsKt.firstOrNull(allExceptions);
                if (first == null) {
                    first = new UnknownHostException("No results for " + hostname);
                }
                Iterable $this$forEach$iv = CollectionsKt.drop(allExceptions, 1);
                for (Object element$iv : $this$forEach$iv) {
                    IOException it = (IOException) element$iv;
                    ExceptionsKt.addSuppressed(first, it);
                }
                throw first;
            }
            return allAddresses;
        }
    }
}
