package okhttp3.internal.connection;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpStatusCodesKt;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: compiled from: ConnectPlan.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001MBW\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\b\u00102\u001a\u000203H\u0016J\u0006\u00104\u001a\u000203J\b\u00105\u001a\u000203H\u0002J\b\u00106\u001a\u000207H\u0016J\u0018\u00108\u001a\u0002032\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u000207H\u0016J\r\u0010>\u001a\u000207H\u0000¢\u0006\u0002\b?J2\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0002J\n\u0010A\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010B\u001a\u00020\u0017H\u0016J%\u0010C\u001a\u0004\u0018\u00010\u00002\f\u0010D\u001a\b\u0012\u0004\u0012\u00020<0\f2\u0006\u00109\u001a\u00020:H\u0000¢\u0006\u0002\bEJ\b\u0010F\u001a\u000203H\u0016J#\u0010G\u001a\u00020\u00002\f\u0010D\u001a\b\u0012\u0004\u0012\u00020<0\f2\u0006\u00109\u001a\u00020:H\u0000¢\u0006\u0002\bHJ\b\u0010I\u001a\u00020\u0001H\u0016J\u001a\u0010J\u001a\u0002032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010K\u001a\u0004\u0018\u00010LH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0004\u0018\u00010$X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, m195d2 = {"Lokhttp3/internal/connection/ConnectPlan;", "Lokhttp3/internal/connection/RoutePlanner$Plan;", "Lokhttp3/internal/http/ExchangeCodec$Carrier;", "client", "Lokhttp3/OkHttpClient;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/internal/connection/RealCall;", "routePlanner", "Lokhttp3/internal/connection/RealRoutePlanner;", "route", "Lokhttp3/Route;", "routes", "", "attempt", "", "tunnelRequest", "Lokhttp3/Request;", "connectionSpecIndex", "isTlsFallback", "", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealCall;Lokhttp3/internal/connection/RealRoutePlanner;Lokhttp3/Route;Ljava/util/List;ILokhttp3/Request;IZ)V", "canceled", "connection", "Lokhttp3/internal/connection/RealConnection;", "getConnectionSpecIndex$okhttp", "()I", "eventListener", "Lokhttp3/EventListener;", "handshake", "Lokhttp3/Handshake;", "isReady", "()Z", "isTlsFallback$okhttp", "protocol", "Lokhttp3/Protocol;", "rawSocket", "Ljava/net/Socket;", "getRoute", "()Lokhttp3/Route;", "getRoutes$okhttp", "()Ljava/util/List;", "sink", "Lokio/BufferedSink;", "socket", "getSocket$okhttp", "()Ljava/net/Socket;", "setSocket$okhttp", "(Ljava/net/Socket;)V", "source", "Lokio/BufferedSource;", "cancel", "", "closeQuietly", "connectSocket", "connectTcp", "Lokhttp3/internal/connection/RoutePlanner$ConnectResult;", "connectTls", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "connectionSpec", "Lokhttp3/ConnectionSpec;", "connectTlsEtc", "connectTunnel", "connectTunnel$okhttp", "copy", "createTunnel", "handleSuccess", "nextConnectionSpec", "connectionSpecs", "nextConnectionSpec$okhttp", "noNewExchanges", "planWithCurrentOrInitialConnectionSpec", "planWithCurrentOrInitialConnectionSpec$okhttp", "retry", "trackFailure", "e", "Ljava/io/IOException;", "Companion", "okhttp"}, m196k = 1, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ConnectPlan implements RoutePlanner.Plan, ExchangeCodec.Carrier {
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private final int attempt;
    private final RealCall call;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private RealConnection connection;
    private final int connectionSpecIndex;
    private final EventListener eventListener;
    private Handshake handshake;
    private final boolean isTlsFallback;
    private Protocol protocol;
    private Socket rawSocket;
    private final Route route;
    private final RealRoutePlanner routePlanner;
    private final List<Route> routes;
    private BufferedSink sink;
    private Socket socket;
    private BufferedSource source;
    private final Request tunnelRequest;

    /* JADX INFO: compiled from: ConnectPlan.kt */
    @Metadata(m196k = 3, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            iArr[Proxy.Type.HTTP.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ConnectPlan(OkHttpClient client, RealCall call, RealRoutePlanner routePlanner, Route route, List<Route> list, int attempt, Request tunnelRequest, int connectionSpecIndex, boolean isTlsFallback) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(routePlanner, "routePlanner");
        Intrinsics.checkNotNullParameter(route, "route");
        this.client = client;
        this.call = call;
        this.routePlanner = routePlanner;
        this.route = route;
        this.routes = list;
        this.attempt = attempt;
        this.tunnelRequest = tunnelRequest;
        this.connectionSpecIndex = connectionSpecIndex;
        this.isTlsFallback = isTlsFallback;
        this.eventListener = this.call.getEventListener();
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public Route getRoute() {
        return this.route;
    }

    public final List<Route> getRoutes$okhttp() {
        return this.routes;
    }

    /* JADX INFO: renamed from: getConnectionSpecIndex$okhttp, reason: from getter */
    public final int getConnectionSpecIndex() {
        return this.connectionSpecIndex;
    }

    /* JADX INFO: renamed from: isTlsFallback$okhttp, reason: from getter */
    public final boolean getIsTlsFallback() {
        return this.isTlsFallback;
    }

    /* JADX INFO: renamed from: getSocket$okhttp, reason: from getter */
    public final Socket getSocket() {
        return this.socket;
    }

    public final void setSocket$okhttp(Socket socket) {
        this.socket = socket;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* JADX INFO: renamed from: isReady */
    public boolean getIsReady() {
        return this.protocol != null;
    }

    static /* synthetic */ ConnectPlan copy$default(ConnectPlan connectPlan, int i, Request request, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = connectPlan.attempt;
        }
        if ((i3 & 2) != 0) {
            request = connectPlan.tunnelRequest;
        }
        if ((i3 & 4) != 0) {
            i2 = connectPlan.connectionSpecIndex;
        }
        if ((i3 & 8) != 0) {
            z = connectPlan.isTlsFallback;
        }
        return connectPlan.copy(i, request, i2, z);
    }

    private final ConnectPlan copy(int attempt, Request tunnelRequest, int connectionSpecIndex, boolean isTlsFallback) {
        return new ConnectPlan(this.client, this.call, this.routePlanner, getRoute(), this.routes, attempt, tunnelRequest, connectionSpecIndex, isTlsFallback);
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* JADX INFO: renamed from: connectTcp */
    public RoutePlanner.ConnectResult getResult() {
        Socket socket;
        Socket socket2;
        if (!(this.rawSocket == null)) {
            throw new IllegalStateException("TCP already connected".toString());
        }
        boolean success = false;
        this.call.getPlansToCancel$okhttp().add(this);
        try {
            try {
                this.eventListener.connectStart(this.call, getRoute().socketAddress(), getRoute().proxy());
                connectSocket();
                success = true;
                RoutePlanner.ConnectResult connectResult = new RoutePlanner.ConnectResult(this, null, null, 6, null);
                this.call.getPlansToCancel$okhttp().remove(this);
                return connectResult;
            } catch (IOException e) {
                this.eventListener.connectFailed(this.call, getRoute().socketAddress(), getRoute().proxy(), null, e);
                RoutePlanner.ConnectResult connectResult2 = new RoutePlanner.ConnectResult(this, null, e, 2, null);
                this.call.getPlansToCancel$okhttp().remove(this);
                if (!success && (socket2 = this.rawSocket) != null) {
                    _UtilJvmKt.closeQuietly(socket2);
                }
                return connectResult2;
            }
        } catch (Throwable th) {
            this.call.getPlansToCancel$okhttp().remove(this);
            if (!success && (socket = this.rawSocket) != null) {
                _UtilJvmKt.closeQuietly(socket);
            }
            throw th;
        }
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* JADX INFO: renamed from: connectTlsEtc */
    public RoutePlanner.ConnectResult mo9451connectTlsEtc() {
        Buffer buffer;
        Buffer buffer2;
        boolean z = false;
        if (!(this.rawSocket != null)) {
            throw new IllegalStateException("TCP not connected".toString());
        }
        if (!(!getIsReady())) {
            throw new IllegalStateException("already connected".toString());
        }
        List<ConnectionSpec> listConnectionSpecs = getRoute().address().connectionSpecs();
        this.call.getPlansToCancel$okhttp().add(this);
        try {
            try {
                if (this.tunnelRequest != null) {
                    RoutePlanner.ConnectResult tunnelResult = connectTunnel$okhttp();
                    if (tunnelResult.getNextPlan() != null || tunnelResult.getThrowable() != null) {
                        this.call.getPlansToCancel$okhttp().remove(this);
                        Socket socket = this.socket;
                        if (socket != null) {
                            _UtilJvmKt.closeQuietly(socket);
                        }
                        Socket socket2 = this.rawSocket;
                        if (socket2 != null) {
                            _UtilJvmKt.closeQuietly(socket2);
                        }
                        return tunnelResult;
                    }
                }
                if (getRoute().address().sslSocketFactory() != null) {
                    BufferedSource bufferedSource = this.source;
                    if (!((bufferedSource == null || (buffer2 = bufferedSource.getBuffer()) == null || buffer2.exhausted()) ? false : true)) {
                        BufferedSink bufferedSink = this.sink;
                        if (bufferedSink != null && (buffer = bufferedSink.getBuffer()) != null && !buffer.exhausted()) {
                            z = true;
                        }
                        if (!z) {
                            this.eventListener.secureConnectStart(this.call);
                            Socket socketCreateSocket = getRoute().address().sslSocketFactory().createSocket(this.rawSocket, getRoute().address().url().host(), getRoute().address().url().port(), true);
                            if (socketCreateSocket == null) {
                                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
                            }
                            SSLSocket sslSocket = (SSLSocket) socketCreateSocket;
                            ConnectPlan tlsEquipPlan = planWithCurrentOrInitialConnectionSpec$okhttp(listConnectionSpecs, sslSocket);
                            ConnectionSpec connectionSpec = listConnectionSpecs.get(tlsEquipPlan.connectionSpecIndex);
                            tlsEquipPlan.nextConnectionSpec$okhttp(listConnectionSpecs, sslSocket);
                            connectionSpec.apply$okhttp(sslSocket, tlsEquipPlan.isTlsFallback);
                            connectTls(sslSocket, connectionSpec);
                            this.eventListener.secureConnectEnd(this.call, this.handshake);
                        }
                    }
                    throw new IOException("TLS tunnel buffered too many bytes!");
                }
                this.socket = this.rawSocket;
                this.protocol = getRoute().address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE) ? Protocol.H2_PRIOR_KNOWLEDGE : Protocol.HTTP_1_1;
                RealConnection connection = new RealConnection(this.client.getTaskRunner(), this.client.connectionPool().getDelegate(), getRoute(), this.rawSocket, this.socket, this.handshake, this.protocol, this.source, this.sink, this.client.pingIntervalMillis());
                this.connection = connection;
                connection.start();
                this.eventListener.connectEnd(this.call, getRoute().socketAddress(), getRoute().proxy(), this.protocol);
                RoutePlanner.ConnectResult connectResult = new RoutePlanner.ConnectResult(this, null, null, 6, null);
                this.call.getPlansToCancel$okhttp().remove(this);
                return connectResult;
            } catch (IOException e) {
                this.eventListener.connectFailed(this.call, getRoute().socketAddress(), getRoute().proxy(), null, e);
                ConnectPlan retryTlsConnection = (this.client.retryOnConnectionFailure() && TlsHandshakeKt.retryTlsHandshake(e)) ? null : null;
                RoutePlanner.ConnectResult connectResult2 = new RoutePlanner.ConnectResult(this, retryTlsConnection, e);
                this.call.getPlansToCancel$okhttp().remove(this);
                if (0 == 0) {
                    Socket socket3 = this.socket;
                    if (socket3 != null) {
                        _UtilJvmKt.closeQuietly(socket3);
                    }
                    Socket socket4 = this.rawSocket;
                    if (socket4 != null) {
                        _UtilJvmKt.closeQuietly(socket4);
                    }
                }
                return connectResult2;
            }
        } catch (Throwable th) {
            this.call.getPlansToCancel$okhttp().remove(this);
            if (0 == 0) {
                Socket socket5 = this.socket;
                if (socket5 != null) {
                    _UtilJvmKt.closeQuietly(socket5);
                }
                Socket socket6 = this.rawSocket;
                if (socket6 != null) {
                    _UtilJvmKt.closeQuietly(socket6);
                }
            }
            throw th;
        }
    }

    private final void connectSocket() throws IOException {
        Socket rawSocket;
        Proxy.Type type = getRoute().proxy().type();
        switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
            case 2:
                rawSocket = getRoute().address().socketFactory().createSocket();
                Intrinsics.checkNotNull(rawSocket);
                break;
            default:
                rawSocket = new Socket(getRoute().proxy());
                break;
        }
        this.rawSocket = rawSocket;
        if (this.canceled) {
            throw new IOException("canceled");
        }
        rawSocket.setSoTimeout(this.client.readTimeoutMillis());
        try {
            Platform.INSTANCE.get().connectSocket(rawSocket, getRoute().socketAddress(), this.client.connectTimeoutMillis());
            try {
                this.source = Okio.buffer(Okio.source(rawSocket));
                this.sink = Okio.buffer(Okio.sink(rawSocket));
            } catch (NullPointerException npe) {
                if (Intrinsics.areEqual(npe.getMessage(), NPE_THROW_WITH_NULL)) {
                    throw new IOException(npe);
                }
            }
        } catch (ConnectException e) {
            ConnectException $this$connectSocket_u24lambda_u2d3 = new ConnectException("Failed to connect to " + getRoute().socketAddress());
            $this$connectSocket_u24lambda_u2d3.initCause(e);
            throw $this$connectSocket_u24lambda_u2d3;
        }
    }

    public final RoutePlanner.ConnectResult connectTunnel$okhttp() throws IOException {
        Request nextTunnelRequest = createTunnel();
        if (nextTunnelRequest == null) {
            return new RoutePlanner.ConnectResult(this, null, null, 6, null);
        }
        Socket socket = this.rawSocket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
        int nextAttempt = this.attempt + 1;
        if (nextAttempt < 21) {
            this.eventListener.connectEnd(this.call, getRoute().socketAddress(), getRoute().proxy(), null);
            return new RoutePlanner.ConnectResult(this, copy$default(this, nextAttempt, nextTunnelRequest, 0, false, 12, null), null, 4, null);
        }
        ProtocolException failure = new ProtocolException("Too many tunnel connections attempted: 21");
        this.eventListener.connectFailed(this.call, getRoute().socketAddress(), getRoute().proxy(), null, failure);
        return new RoutePlanner.ConnectResult(this, null, failure, 2, null);
    }

    private final void connectTls(SSLSocket sslSocket, ConnectionSpec connectionSpec) throws IOException {
        final Address address = getRoute().address();
        try {
            if (connectionSpec.supportsTlsExtensions()) {
                Platform.INSTANCE.get().configureTlsExtensions(sslSocket, address.url().host(), address.protocols());
            }
            sslSocket.startHandshake();
            SSLSession sslSocketSession = sslSocket.getSession();
            Handshake.Companion companion = Handshake.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(sslSocketSession, "sslSocketSession");
            final Handshake unverifiedHandshake = companion.get(sslSocketSession);
            HostnameVerifier hostnameVerifier = address.hostnameVerifier();
            Intrinsics.checkNotNull(hostnameVerifier);
            String maybeProtocol = null;
            if (!hostnameVerifier.verify(address.url().host(), sslSocketSession)) {
                List<Certificate> listPeerCertificates = unverifiedHandshake.peerCertificates();
                if (!(!listPeerCertificates.isEmpty())) {
                    throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified (no certificates)");
                }
                X509Certificate cert = (X509Certificate) listPeerCertificates.get(0);
                throw new SSLPeerUnverifiedException(StringsKt.trimMargin$default("\n            |Hostname " + address.url().host() + " not verified:\n            |    certificate: " + CertificatePinner.INSTANCE.pin(cert) + "\n            |    DN: " + cert.getSubjectDN().getName() + "\n            |    subjectAltNames: " + OkHostnameVerifier.INSTANCE.allSubjectAltNames(cert) + "\n            ", null, 1, null));
            }
            final CertificatePinner certificatePinner = address.certificatePinner();
            Intrinsics.checkNotNull(certificatePinner);
            final Handshake handshake = new Handshake(unverifiedHandshake.tlsVersion(), unverifiedHandshake.cipherSuite(), unverifiedHandshake.localCertificates(), new Function0<List<? extends Certificate>>() { // from class: okhttp3.internal.connection.ConnectPlan$connectTls$handshake$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends Certificate> invoke() {
                    CertificateChainCleaner certificateChainCleaner = certificatePinner.getCertificateChainCleaner();
                    Intrinsics.checkNotNull(certificateChainCleaner);
                    return certificateChainCleaner.clean(unverifiedHandshake.peerCertificates(), address.url().host());
                }
            });
            this.handshake = handshake;
            certificatePinner.check$okhttp(address.url().host(), new Function0<List<? extends X509Certificate>>() { // from class: okhttp3.internal.connection.ConnectPlan.connectTls.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends X509Certificate> invoke() {
                    Iterable $this$map$iv = handshake.peerCertificates();
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        Certificate it = (Certificate) item$iv$iv;
                        destination$iv$iv.add((X509Certificate) it);
                    }
                    return (List) destination$iv$iv;
                }
            });
            if (connectionSpec.supportsTlsExtensions()) {
                maybeProtocol = Platform.INSTANCE.get().getSelectedProtocol(sslSocket);
            }
            this.socket = sslSocket;
            this.source = Okio.buffer(Okio.source(sslSocket));
            this.sink = Okio.buffer(Okio.sink(sslSocket));
            this.protocol = maybeProtocol != null ? Protocol.INSTANCE.get(maybeProtocol) : Protocol.HTTP_1_1;
            Platform.INSTANCE.get().afterHandshake(sslSocket);
        } catch (Throwable th) {
            Platform.INSTANCE.get().afterHandshake(sslSocket);
            _UtilJvmKt.closeQuietly(sslSocket);
            throw th;
        }
    }

    /* JADX WARN: Switch 'out' block B:3:0x002f for B:4:0x0088 already processed. Defaulting to fallback option. */
    private final Request createTunnel() throws IOException {
        Response response;
        Request nextRequest = this.tunnelRequest;
        Intrinsics.checkNotNull(nextRequest);
        HttpUrl url = getRoute().address().url();
        String requestLine = "CONNECT " + _UtilJvmKt.toHostHeader(url, true) + " HTTP/1.1";
        do {
            BufferedSource source = this.source;
            Intrinsics.checkNotNull(source);
            BufferedSink sink = this.sink;
            Intrinsics.checkNotNull(sink);
            Http1ExchangeCodec tunnelCodec = new Http1ExchangeCodec(null, this, source, sink);
            source.getTimeout().timeout(this.client.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            sink.getTimeout().timeout(this.client.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
            tunnelCodec.writeRequest(nextRequest.headers(), requestLine);
            tunnelCodec.finishRequest();
            Response.Builder responseHeaders = tunnelCodec.readResponseHeaders(false);
            Intrinsics.checkNotNull(responseHeaders);
            response = responseHeaders.request(nextRequest).build();
            tunnelCodec.skipConnectBody(response);
            switch (response.code()) {
                case 200:
                    return null;
                case HttpStatusCodesKt.HTTP_PROXY_AUTH /* 407 */:
                    Request requestAuthenticate = getRoute().address().proxyAuthenticator().authenticate(getRoute(), response);
                    if (requestAuthenticate == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                    nextRequest = requestAuthenticate;
                    break;
                    break;
                default:
                    throw new IOException("Unexpected response code for CONNECT: " + response.code());
            }
        } while (!StringsKt.equals("close", Response.header$default(response, "Connection", null, 2, null), true));
        return nextRequest;
    }

    public final ConnectPlan planWithCurrentOrInitialConnectionSpec$okhttp(List<ConnectionSpec> connectionSpecs, SSLSocket sslSocket) throws IOException {
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        if (this.connectionSpecIndex != -1) {
            return this;
        }
        ConnectPlan connectPlanNextConnectionSpec$okhttp = nextConnectionSpec$okhttp(connectionSpecs, sslSocket);
        if (connectPlanNextConnectionSpec$okhttp != null) {
            return connectPlanNextConnectionSpec$okhttp;
        }
        StringBuilder sbAppend = new StringBuilder().append("Unable to find acceptable protocols. isFallback=").append(this.isTlsFallback).append(", modes=").append(connectionSpecs).append(", supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        Intrinsics.checkNotNull(enabledProtocols);
        String string = Arrays.toString(enabledProtocols);
        Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
        throw new UnknownServiceException(sbAppend.append(string).toString());
    }

    public final ConnectPlan nextConnectionSpec$okhttp(List<ConnectionSpec> connectionSpecs, SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        int size = connectionSpecs.size();
        for (int i = this.connectionSpecIndex + 1; i < size; i++) {
            if (connectionSpecs.get(i).isCompatible(sslSocket)) {
                return copy$default(this, 0, null, i, this.connectionSpecIndex != -1, 3, null);
            }
        }
        return null;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* JADX INFO: renamed from: handleSuccess */
    public RealConnection mo9447handleSuccess() {
        this.call.getClient().getRouteDatabase().connected(getRoute());
        ReusePlan pooled3 = this.routePlanner.planReusePooledConnection$okhttp(this, this.routes);
        if (pooled3 != null) {
            return pooled3.getConnection();
        }
        RealConnection connection = this.connection;
        Intrinsics.checkNotNull(connection);
        synchronized (connection) {
            this.client.connectionPool().getDelegate().put(connection);
            this.call.acquireConnectionNoEvents(connection);
            Unit unit = Unit.INSTANCE;
        }
        this.eventListener.connectionAcquired(this.call, connection);
        return connection;
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public void trackFailure(RealCall call, IOException e) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public void noNewExchanges() {
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan, okhttp3.internal.http.ExchangeCodec.Carrier
    /* JADX INFO: renamed from: cancel */
    public void mo9446cancel() {
        this.canceled = true;
        Socket socket = this.rawSocket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* JADX INFO: renamed from: retry */
    public RoutePlanner.Plan mo9448retry() {
        return new ConnectPlan(this.client, this.call, this.routePlanner, getRoute(), this.routes, this.attempt, this.tunnelRequest, this.connectionSpecIndex, this.isTlsFallback);
    }

    public final void closeQuietly() {
        Socket socket = this.socket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
    }
}
