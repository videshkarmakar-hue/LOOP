package coil.util;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.RealImageLoader;
import coil.network.EmptyNetworkObserver;
import coil.network.NetworkObserver;
import coil.network.NetworkObserverKt;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SystemCallbacks.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0006\u0010!\u001a\u00020\u0019J\u0006\u0010\"\u001a\u00020\u0019J\u001d\u0010#\u001a\u00020\u00192\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190%H\u0082\bR\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00040\u00040\r8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, m195d2 = {"Lcoil/util/SystemCallbacks;", "Landroid/content/ComponentCallbacks2;", "Lcoil/network/NetworkObserver$Listener;", "imageLoader", "Lcoil/RealImageLoader;", "context", "Landroid/content/Context;", "isNetworkObserverEnabled", "", "(Lcoil/RealImageLoader;Landroid/content/Context;Z)V", "_isOnline", "_isShutdown", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getImageLoader$coil_base_release$annotations", "()V", "getImageLoader$coil_base_release", "()Ljava/lang/ref/WeakReference;", "isOnline", "()Z", "isShutdown", "networkObserver", "Lcoil/network/NetworkObserver;", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onConnectivityChange", "onLowMemory", "onTrimMemory", "level", "", "register", "shutdown", "withImageLoader", "block", "Lkotlin/Function1;", "Companion", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SystemCallbacks implements ComponentCallbacks2, NetworkObserver.Listener {
    private static final String OFFLINE = "OFFLINE";
    private static final String ONLINE = "ONLINE";
    private static final String TAG = "NetworkObserver";
    private volatile boolean _isOnline;
    private final AtomicBoolean _isShutdown;
    private final Context context;
    private final WeakReference<RealImageLoader> imageLoader;
    private final NetworkObserver networkObserver;

    public static /* synthetic */ void getImageLoader$coil_base_release$annotations() {
    }

    public SystemCallbacks(RealImageLoader imageLoader, Context context, boolean isNetworkObserverEnabled) {
        EmptyNetworkObserver emptyNetworkObserver;
        this.context = context;
        this.imageLoader = new WeakReference<>(imageLoader);
        if (isNetworkObserverEnabled) {
            emptyNetworkObserver = NetworkObserverKt.NetworkObserver(this.context, this, imageLoader.getLogger());
        } else {
            emptyNetworkObserver = new EmptyNetworkObserver();
        }
        this.networkObserver = emptyNetworkObserver;
        this._isOnline = this.networkObserver.isOnline();
        this._isShutdown = new AtomicBoolean(false);
    }

    public final WeakReference<RealImageLoader> getImageLoader$coil_base_release() {
        return this.imageLoader;
    }

    /* JADX INFO: renamed from: isOnline, reason: from getter */
    public final boolean get_isOnline() {
        return this._isOnline;
    }

    public final boolean isShutdown() {
        return this._isShutdown.get();
    }

    public final void register() {
        this.context.registerComponentCallbacks(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        if (this.imageLoader.get() == null) {
            shutdown();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        RealImageLoader imageLoader = this.imageLoader.get();
        Unit unit = null;
        if (imageLoader != null) {
            Logger $this$log$iv = imageLoader.getLogger();
            if ($this$log$iv != null && $this$log$iv.getLevel() <= 2) {
                $this$log$iv.log(TAG, 2, "trimMemory, level=" + level, null);
            }
            imageLoader.onTrimMemory$coil_base_release(level);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            shutdown();
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        onTrimMemory(80);
    }

    @Override // coil.network.NetworkObserver.Listener
    public void onConnectivityChange(boolean isOnline) {
        RealImageLoader imageLoader = this.imageLoader.get();
        Unit unit = null;
        if (imageLoader != null) {
            Logger $this$log$iv = imageLoader.getLogger();
            if ($this$log$iv != null && $this$log$iv.getLevel() <= 4) {
                $this$log$iv.log(TAG, 4, isOnline ? ONLINE : OFFLINE, null);
            }
            this._isOnline = isOnline;
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            shutdown();
        }
    }

    public final void shutdown() {
        if (this._isShutdown.getAndSet(true)) {
            return;
        }
        this.context.unregisterComponentCallbacks(this);
        this.networkObserver.shutdown();
    }

    private final void withImageLoader(Function1<? super RealImageLoader, Unit> block) {
        Unit unit;
        RealImageLoader realImageLoader = this.imageLoader.get();
        if (realImageLoader != null) {
            block.invoke(realImageLoader);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            shutdown();
        }
    }
}
