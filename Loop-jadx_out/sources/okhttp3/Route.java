package okhttp3;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.internal._HostnamesJvmKt;

/* JADX INFO: compiled from: Route.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u0012J\u0006\u0010\u0013\u001a\u00020\u000eJ\r\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000b¨\u0006\u0017"}, m195d2 = {"Lokhttp3/Route;", "", "address", "Lokhttp3/Address;", PreferenceUtilKt.PROXY, "Ljava/net/Proxy;", "socketAddress", "Ljava/net/InetSocketAddress;", "(Lokhttp3/Address;Ljava/net/Proxy;Ljava/net/InetSocketAddress;)V", "()Lokhttp3/Address;", "()Ljava/net/Proxy;", "()Ljava/net/InetSocketAddress;", "-deprecated_address", "equals", "", "other", "hashCode", "", "-deprecated_proxy", "requiresTunnel", "-deprecated_socketAddress", "toString", "", "okhttp"}, m196k = 1, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Route {
    private final Address address;
    private final Proxy proxy;
    private final InetSocketAddress socketAddress;

    public Route(Address address, Proxy proxy, InetSocketAddress socketAddress) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(socketAddress, "socketAddress");
        this.address = address;
        this.proxy = proxy;
        this.socketAddress = socketAddress;
    }

    public final Address address() {
        return this.address;
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final InetSocketAddress socketAddress() {
        return this.socketAddress;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "address", imports = {}))
    /* JADX INFO: renamed from: -deprecated_address, reason: not valid java name and from getter */
    public final Address getAddress() {
        return this.address;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = PreferenceUtilKt.PROXY, imports = {}))
    /* JADX INFO: renamed from: -deprecated_proxy, reason: not valid java name and from getter */
    public final Proxy getProxy() {
        return this.proxy;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "socketAddress", imports = {}))
    /* JADX INFO: renamed from: -deprecated_socketAddress, reason: not valid java name and from getter */
    public final InetSocketAddress getSocketAddress() {
        return this.socketAddress;
    }

    public final boolean requiresTunnel() {
        if (this.proxy.type() != Proxy.Type.HTTP) {
            return false;
        }
        return this.address.sslSocketFactory() != null || this.address.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE);
    }

    public boolean equals(Object other) {
        return (other instanceof Route) && Intrinsics.areEqual(((Route) other).address, this.address) && Intrinsics.areEqual(((Route) other).proxy, this.proxy) && Intrinsics.areEqual(((Route) other).socketAddress, this.socketAddress);
    }

    public int hashCode() {
        int result = (17 * 31) + this.address.hashCode();
        return (((result * 31) + this.proxy.hashCode()) * 31) + this.socketAddress.hashCode();
    }

    public String toString() {
        String socketHostname;
        String hostAddress;
        StringBuilder $this$toString_u24lambda_u2d0 = new StringBuilder();
        String addressHostname = this.address.url().host();
        InetAddress address = this.socketAddress.getAddress();
        if (address == null || (hostAddress = address.getHostAddress()) == null) {
            socketHostname = null;
        } else {
            Intrinsics.checkNotNullExpressionValue(hostAddress, "hostAddress");
            socketHostname = _HostnamesJvmKt.toCanonicalHost(hostAddress);
        }
        if (StringsKt.contains$default((CharSequence) addressHostname, AbstractJsonLexerKt.COLON, false, 2, (Object) null)) {
            $this$toString_u24lambda_u2d0.append("[").append(addressHostname).append("]");
        } else {
            $this$toString_u24lambda_u2d0.append(addressHostname);
        }
        if (this.address.url().port() != this.socketAddress.getPort() || Intrinsics.areEqual(addressHostname, socketHostname)) {
            $this$toString_u24lambda_u2d0.append(":");
            $this$toString_u24lambda_u2d0.append(this.address.url().port());
        }
        if (!Intrinsics.areEqual(addressHostname, socketHostname)) {
            if (Intrinsics.areEqual(this.proxy, Proxy.NO_PROXY)) {
                $this$toString_u24lambda_u2d0.append(" at ");
            } else {
                $this$toString_u24lambda_u2d0.append(" via proxy ");
            }
            if (socketHostname == null) {
                $this$toString_u24lambda_u2d0.append("<unresolved>");
            } else if (StringsKt.contains$default((CharSequence) socketHostname, AbstractJsonLexerKt.COLON, false, 2, (Object) null)) {
                $this$toString_u24lambda_u2d0.append("[").append(socketHostname).append("]");
            } else {
                $this$toString_u24lambda_u2d0.append(socketHostname);
            }
            $this$toString_u24lambda_u2d0.append(":");
            $this$toString_u24lambda_u2d0.append(this.socketAddress.getPort());
        }
        String string = $this$toString_u24lambda_u2d0.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
