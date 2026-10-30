package coil;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import coil.decode.BitmapFactoryDecoder;
import coil.decode.DataSource;
import coil.disk.DiskCache;
import coil.fetch.AssetUriFetcher;
import coil.fetch.BitmapFetcher;
import coil.fetch.ByteBufferFetcher;
import coil.fetch.ContentUriFetcher;
import coil.fetch.DrawableFetcher;
import coil.fetch.FileFetcher;
import coil.fetch.HttpUriFetcher;
import coil.fetch.ResourceUriFetcher;
import coil.intercept.EngineInterceptor;
import coil.intercept.Interceptor;
import coil.key.FileKeyer;
import coil.key.UriKeyer;
import coil.map.ByteArrayMapper;
import coil.map.FileUriMapper;
import coil.map.HttpUrlMapper;
import coil.map.ResourceIntMapper;
import coil.map.ResourceUriMapper;
import coil.map.StringMapper;
import coil.memory.MemoryCache;
import coil.request.DefaultRequestOptions;
import coil.request.Disposable;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.NullRequestData;
import coil.request.NullRequestDataException;
import coil.request.OneShotDisposable;
import coil.request.RequestDelegate;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.size.Size;
import coil.size.SizeResolver;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.transition.NoneTransition;
import coil.transition.Transition;
import coil.transition.TransitionTarget;
import coil.util.ImageLoaderOptions;
import coil.util.Lifecycles;
import coil.util.Logger;
import coil.util.SystemCallbacks;
import coil.util.Utils;
import com.caverock.androidsvg.SVGParser;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.Call;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: RealImageLoader.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 [2\u00020\u0001:\u0001[Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J\u0019\u0010@\u001a\u00020A2\u0006\u0010>\u001a\u00020?H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010BJ!\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020?2\u0006\u0010E\u001a\u00020FH\u0083@ø\u0001\u0000¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u00020IH\u0016J\u0018\u0010J\u001a\u00020K2\u0006\u0010>\u001a\u00020?2\u0006\u0010L\u001a\u00020MH\u0002J\"\u0010N\u001a\u00020K2\u0006\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010L\u001a\u00020MH\u0002J\"\u0010S\u001a\u00020K2\u0006\u0010O\u001a\u00020T2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010L\u001a\u00020MH\u0002J\u0015\u0010U\u001a\u00020K2\u0006\u0010V\u001a\u00020FH\u0000¢\u0006\u0002\bWJ\b\u00108\u001a\u00020KH\u0016J1\u0010X\u001a\u00020K2\u0006\u0010O\u001a\u00020A2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010L\u001a\u00020M2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020K0ZH\u0082\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010 \u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b#\u0010$*\u0004\b!\u0010\"R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001d\u0010-\u001a\u0004\u0018\u00010\b8VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b/\u00100*\u0004\b.\u0010\"R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\\"}, m195d2 = {"Lcoil/RealImageLoader;", "Lcoil/ImageLoader;", "context", "Landroid/content/Context;", "defaults", "Lcoil/request/DefaultRequestOptions;", "memoryCacheLazy", "Lkotlin/Lazy;", "Lcoil/memory/MemoryCache;", "diskCacheLazy", "Lcoil/disk/DiskCache;", "callFactoryLazy", "Lokhttp3/Call$Factory;", "eventListenerFactory", "Lcoil/EventListener$Factory;", "componentRegistry", "Lcoil/ComponentRegistry;", "options", "Lcoil/util/ImageLoaderOptions;", "logger", "Lcoil/util/Logger;", "(Landroid/content/Context;Lcoil/request/DefaultRequestOptions;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil/EventListener$Factory;Lcoil/ComponentRegistry;Lcoil/util/ImageLoaderOptions;Lcoil/util/Logger;)V", "getCallFactoryLazy", "()Lkotlin/Lazy;", "getComponentRegistry", "()Lcoil/ComponentRegistry;", "components", "getComponents", "getContext", "()Landroid/content/Context;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "diskCache", "getDiskCache$delegate", "(Lcoil/RealImageLoader;)Ljava/lang/Object;", "getDiskCache", "()Lcoil/disk/DiskCache;", "getDiskCacheLazy", "getEventListenerFactory", "()Lcoil/EventListener$Factory;", "interceptors", "", "Lcoil/intercept/Interceptor;", "getLogger", "()Lcoil/util/Logger;", "memoryCache", "getMemoryCache$delegate", "getMemoryCache", "()Lcoil/memory/MemoryCache;", "getMemoryCacheLazy", "getOptions", "()Lcoil/util/ImageLoaderOptions;", "requestService", "Lcoil/request/RequestService;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "shutdown", "Ljava/util/concurrent/atomic/AtomicBoolean;", "systemCallbacks", "Lcoil/util/SystemCallbacks;", "enqueue", "Lcoil/request/Disposable;", "request", "Lcoil/request/ImageRequest;", "execute", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeMain", "initialRequest", SVGParser.XML_STYLESHEET_ATTR_TYPE, "", "(Lcoil/request/ImageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newBuilder", "Lcoil/ImageLoader$Builder;", "onCancel", "", "eventListener", "Lcoil/EventListener;", "onError", "result", "Lcoil/request/ErrorResult;", "target", "Lcoil/target/Target;", "onSuccess", "Lcoil/request/SuccessResult;", "onTrimMemory", "level", "onTrimMemory$coil_base_release", "transition", "setDrawable", "Lkotlin/Function0;", "Companion", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class RealImageLoader implements ImageLoader {
    private static final int REQUEST_TYPE_ENQUEUE = 0;
    private static final int REQUEST_TYPE_EXECUTE = 1;
    private static final String TAG = "RealImageLoader";
    private final Lazy<Call.Factory> callFactoryLazy;
    private final ComponentRegistry componentRegistry;
    private final ComponentRegistry components;
    private final Context context;
    private final DefaultRequestOptions defaults;
    private final Lazy<DiskCache> diskCacheLazy;
    private final EventListener.Factory eventListenerFactory;
    private final List<Interceptor> interceptors;
    private final Logger logger;
    private final Lazy<MemoryCache> memoryCacheLazy;
    private final ImageLoaderOptions options;
    private final RequestService requestService;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()).plus(new RealImageLoader$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this)));
    private final AtomicBoolean shutdown;
    private final SystemCallbacks systemCallbacks;

    /* JADX INFO: renamed from: coil.RealImageLoader$executeMain$1 */
    /* JADX INFO: compiled from: RealImageLoader.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "coil.RealImageLoader", m210f = "RealImageLoader.kt", m211i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2}, m212l = {166, 178, 182}, m213m = "executeMain", m214n = {"this", "requestDelegate", "request", "eventListener", "this", "requestDelegate", "request", "eventListener", "placeholderBitmap", "this", "requestDelegate", "request", "eventListener"}, m215s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"})
    static final class C25771 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C25771(Continuation<? super C25771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RealImageLoader.this.executeMain(null, 0, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RealImageLoader(Context context, DefaultRequestOptions defaults, Lazy<? extends MemoryCache> lazy, Lazy<? extends DiskCache> lazy2, Lazy<? extends Call.Factory> lazy3, EventListener.Factory eventListenerFactory, ComponentRegistry componentRegistry, ImageLoaderOptions options, Logger logger) {
        this.context = context;
        this.defaults = defaults;
        this.memoryCacheLazy = lazy;
        this.diskCacheLazy = lazy2;
        this.callFactoryLazy = lazy3;
        this.eventListenerFactory = eventListenerFactory;
        this.componentRegistry = componentRegistry;
        this.options = options;
        this.logger = logger;
        this.systemCallbacks = new SystemCallbacks(this, this.context, this.options.getNetworkObserverEnabled());
        this.requestService = new RequestService(this, this.systemCallbacks, this.logger);
        ComponentRegistry.Builder this_$iv = this.componentRegistry.newBuilder();
        this.components = this_$iv.add(new HttpUrlMapper(), HttpUrl.class).add(new StringMapper(), String.class).add(new FileUriMapper(), Uri.class).add(new ResourceUriMapper(), Uri.class).add(new ResourceIntMapper(), Integer.class).add(new ByteArrayMapper(), byte[].class).add(new UriKeyer(), Uri.class).add(new FileKeyer(this.options.getAddLastModifiedToFileCacheKey()), File.class).add(new HttpUriFetcher.Factory(this.callFactoryLazy, this.diskCacheLazy, this.options.getRespectCacheHeaders()), Uri.class).add(new FileFetcher.Factory(), File.class).add(new AssetUriFetcher.Factory(), Uri.class).add(new ContentUriFetcher.Factory(), Uri.class).add(new ResourceUriFetcher.Factory(), Uri.class).add(new DrawableFetcher.Factory(), Drawable.class).add(new BitmapFetcher.Factory(), Bitmap.class).add(new ByteBufferFetcher.Factory(), ByteBuffer.class).add(new BitmapFactoryDecoder.Factory(this.options.getBitmapFactoryMaxParallelism(), this.options.getBitmapFactoryExifOrientationPolicy())).build();
        this.interceptors = CollectionsKt.plus((Collection<? extends EngineInterceptor>) getComponents().getInterceptors(), new EngineInterceptor(this, this.requestService, this.logger));
        this.shutdown = new AtomicBoolean(false);
        this.systemCallbacks.register();
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // coil.ImageLoader
    public DefaultRequestOptions getDefaults() {
        return this.defaults;
    }

    public final Lazy<MemoryCache> getMemoryCacheLazy() {
        return this.memoryCacheLazy;
    }

    public final Lazy<DiskCache> getDiskCacheLazy() {
        return this.diskCacheLazy;
    }

    public final Lazy<Call.Factory> getCallFactoryLazy() {
        return this.callFactoryLazy;
    }

    public final EventListener.Factory getEventListenerFactory() {
        return this.eventListenerFactory;
    }

    public final ComponentRegistry getComponentRegistry() {
        return this.componentRegistry;
    }

    public final ImageLoaderOptions getOptions() {
        return this.options;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    @Override // coil.ImageLoader
    public MemoryCache getMemoryCache() {
        return this.memoryCacheLazy.getValue();
    }

    @Override // coil.ImageLoader
    public DiskCache getDiskCache() {
        return this.diskCacheLazy.getValue();
    }

    @Override // coil.ImageLoader
    public ComponentRegistry getComponents() {
        return this.components;
    }

    @Override // coil.ImageLoader
    public Disposable enqueue(ImageRequest request) {
        Deferred<? extends ImageResult> deferredAsync$default = BuildersKt__Builders_commonKt.async$default(this.scope, null, null, new RealImageLoader$enqueue$job$1(this, request, null), 3, null);
        if (request.getTarget() instanceof ViewTarget) {
            return Utils.getRequestManager(((ViewTarget) request.getTarget()).getView()).getDisposable(deferredAsync$default);
        }
        return new OneShotDisposable(deferredAsync$default);
    }

    /* JADX INFO: renamed from: coil.RealImageLoader$execute$2 */
    /* JADX INFO: compiled from: RealImageLoader.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "Lcoil/request/ImageResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "coil.RealImageLoader$execute$2", m210f = "RealImageLoader.kt", m211i = {}, m212l = {140}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C25762 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageResult>, Object> {
        final /* synthetic */ ImageRequest $request;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RealImageLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C25762(ImageRequest imageRequest, RealImageLoader realImageLoader, Continuation<? super C25762> continuation) {
            super(2, continuation);
            this.$request = imageRequest;
            this.this$0 = realImageLoader;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C25762 c25762 = new C25762(this.$request, this.this$0, continuation);
            c25762.L$0 = obj;
            return c25762;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImageResult> continuation) {
            return ((C25762) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    Deferred<? extends ImageResult> deferredAsync$default = BuildersKt__Builders_commonKt.async$default($this$coroutineScope, Dispatchers.getMain().getImmediate(), null, new RealImageLoader$execute$2$job$1(this.this$0, this.$request, null), 2, null);
                    if (this.$request.getTarget() instanceof ViewTarget) {
                        Utils.getRequestManager(((ViewTarget) this.$request.getTarget()).getView()).getDisposable(deferredAsync$default);
                    }
                    this.label = 1;
                    Object objAwait = deferredAsync$default.await(this);
                    return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Override // coil.ImageLoader
    public Object execute(ImageRequest request, Continuation<? super ImageResult> continuation) {
        return CoroutineScopeKt.coroutineScope(new C25762(request, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x00ff A[Catch: all -> 0x008f, TryCatch #3 {all -> 0x008f, blocks: (B:59:0x0161, B:23:0x008b, B:38:0x00f9, B:40:0x00ff, B:42:0x0106, B:45:0x010f, B:48:0x0117, B:50:0x0130, B:52:0x0136, B:53:0x013a, B:55:0x0143, B:56:0x0146, B:49:0x012c), top: B:89:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0106 A[Catch: all -> 0x008f, TryCatch #3 {all -> 0x008f, blocks: (B:59:0x0161, B:23:0x008b, B:38:0x00f9, B:40:0x00ff, B:42:0x0106, B:45:0x010f, B:48:0x0117, B:50:0x0130, B:52:0x0136, B:53:0x013a, B:55:0x0143, B:56:0x0146, B:49:0x012c), top: B:89:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:43:0x010c  */
    /* JADX WARN: Code duplicated, block: B:45:0x010f A[Catch: all -> 0x008f, TryCatch #3 {all -> 0x008f, blocks: (B:59:0x0161, B:23:0x008b, B:38:0x00f9, B:40:0x00ff, B:42:0x0106, B:45:0x010f, B:48:0x0117, B:50:0x0130, B:52:0x0136, B:53:0x013a, B:55:0x0143, B:56:0x0146, B:49:0x012c), top: B:89:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0114  */
    /* JADX WARN: Code duplicated, block: B:48:0x0117 A[Catch: all -> 0x008f, TryCatch #3 {all -> 0x008f, blocks: (B:59:0x0161, B:23:0x008b, B:38:0x00f9, B:40:0x00ff, B:42:0x0106, B:45:0x010f, B:48:0x0117, B:50:0x0130, B:52:0x0136, B:53:0x013a, B:55:0x0143, B:56:0x0146, B:49:0x012c), top: B:89:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:49:0x012c A[Catch: all -> 0x008f, TryCatch #3 {all -> 0x008f, blocks: (B:59:0x0161, B:23:0x008b, B:38:0x00f9, B:40:0x00ff, B:42:0x0106, B:45:0x010f, B:48:0x0117, B:50:0x0130, B:52:0x0136, B:53:0x013a, B:55:0x0143, B:56:0x0146, B:49:0x012c), top: B:89:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0136 A[Catch: all -> 0x008f, TryCatch #3 {all -> 0x008f, blocks: (B:59:0x0161, B:23:0x008b, B:38:0x00f9, B:40:0x00ff, B:42:0x0106, B:45:0x010f, B:48:0x0117, B:50:0x0130, B:52:0x0136, B:53:0x013a, B:55:0x0143, B:56:0x0146, B:49:0x012c), top: B:89:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0143 A[Catch: all -> 0x008f, TryCatch #3 {all -> 0x008f, blocks: (B:59:0x0161, B:23:0x008b, B:38:0x00f9, B:40:0x00ff, B:42:0x0106, B:45:0x010f, B:48:0x0117, B:50:0x0130, B:52:0x0136, B:53:0x013a, B:55:0x0143, B:56:0x0146, B:49:0x012c), top: B:89:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0160 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:61:0x0194 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x0195  */
    /* JADX WARN: Code duplicated, block: B:65:0x01a0 A[Catch: all -> 0x004f, TryCatch #4 {all -> 0x004f, blocks: (B:13:0x0049, B:63:0x0198, B:65:0x01a0, B:66:0x01ab, B:68:0x01af), top: B:91:0x0049 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x01ab A[Catch: all -> 0x004f, TryCatch #4 {all -> 0x004f, blocks: (B:13:0x0049, B:63:0x0198, B:65:0x01a0, B:66:0x01ab, B:68:0x01af), top: B:91:0x0049 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x01af A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #4 {all -> 0x004f, blocks: (B:13:0x0049, B:63:0x0198, B:65:0x01a0, B:66:0x01ab, B:68:0x01af), top: B:91:0x0049 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01cc A[Catch: all -> 0x01e3, TRY_LEAVE, TryCatch #0 {all -> 0x01e3, blocks: (B:75:0x01c8, B:77:0x01cc, B:80:0x01de, B:81:0x01e2), top: B:85:0x01c8 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:80:0x01de A[Catch: all -> 0x01e3, TRY_ENTER, TryCatch #0 {all -> 0x01e3, blocks: (B:75:0x01c8, B:77:0x01cc, B:80:0x01de, B:81:0x01e2), top: B:85:0x01c8 }] */
    public final Object executeMain(ImageRequest initialRequest, int type, Continuation<? super ImageResult> continuation) {
        C25771 c25771;
        RealImageLoader realImageLoader;
        ImageRequest request;
        ImageRequest request2;
        RequestDelegate requestDelegate;
        EventListener eventListener;
        RealImageLoader realImageLoader2;
        RequestDelegate requestDelegate2;
        MemoryCache $this$get$iv;
        Bitmap placeholderBitmap;
        BitmapDrawable placeholder;
        Target target;
        ImageRequest.Listener listener;
        Object size;
        MemoryCache.Key key$iv;
        MemoryCache.Value value;
        Object objWithContext;
        ImageResult result;
        if (continuation instanceof C25771) {
            c25771 = (C25771) continuation;
            if ((c25771.label & Integer.MIN_VALUE) != 0) {
                c25771.label -= Integer.MIN_VALUE;
            } else {
                c25771 = new C25771(continuation);
            }
        } else {
            c25771 = new C25771(continuation);
        }
        Object $result = c25771.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c25771.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                realImageLoader = this;
                RequestDelegate requestDelegate3 = realImageLoader.requestService.requestDelegate(initialRequest, JobKt.getJob(c25771.getContext()));
                requestDelegate3.assertActive();
                request = ImageRequest.newBuilder$default(initialRequest, null, 1, null).defaults(realImageLoader.getDefaults()).build();
                EventListener eventListener2 = realImageLoader.eventListenerFactory.create(request);
                try {
                    if (request.getData() == NullRequestData.INSTANCE) {
                        throw new NullRequestDataException();
                    }
                    requestDelegate3.start();
                    if (type == 0) {
                        Lifecycle lifecycle = request.getLifecycle();
                        c25771.L$0 = realImageLoader;
                        c25771.L$1 = requestDelegate3;
                        c25771.L$2 = request;
                        c25771.L$3 = eventListener2;
                        c25771.label = 1;
                        if (Lifecycles.awaitStarted(lifecycle, c25771) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        eventListener = eventListener2;
                        realImageLoader2 = realImageLoader;
                        requestDelegate2 = requestDelegate3;
                    } else {
                        eventListener = eventListener2;
                        realImageLoader2 = realImageLoader;
                        requestDelegate2 = requestDelegate3;
                    }
                    $this$get$iv = realImageLoader2.getMemoryCache();
                    if ($this$get$iv == null) {
                        placeholderBitmap = null;
                    } else {
                        key$iv = request.getPlaceholderMemoryCacheKey();
                        if (key$iv != null) {
                            value = $this$get$iv.get(key$iv);
                        } else {
                            value = null;
                        }
                        if (value != null) {
                            placeholderBitmap = value.getBitmap();
                        } else {
                            placeholderBitmap = null;
                        }
                    }
                    if (placeholderBitmap != null) {
                        Context context$iv = request.getContext();
                        Bitmap $this$toDrawable$iv = placeholderBitmap;
                        Resources resources$iv$iv = context$iv.getResources();
                        placeholder = new BitmapDrawable(resources$iv$iv, $this$toDrawable$iv);
                    } else {
                        placeholder = request.getPlaceholder();
                    }
                    target = request.getTarget();
                    if (target != null) {
                        target.onStart(placeholder);
                    }
                    eventListener.onStart(request);
                    listener = request.getListener();
                    if (listener != null) {
                        listener.onStart(request);
                    }
                    eventListener.resolveSizeStart(request);
                    SizeResolver sizeResolver = request.getSizeResolver();
                    c25771.L$0 = realImageLoader2;
                    c25771.L$1 = requestDelegate2;
                    c25771.L$2 = request;
                    c25771.L$3 = eventListener;
                    c25771.L$4 = placeholderBitmap;
                    c25771.label = 2;
                    size = sizeResolver.size(c25771);
                    if (size == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Size size2 = (Size) size;
                    eventListener.resolveSizeEnd(request, size2);
                    CoroutineDispatcher interceptorDispatcher = request.getInterceptorDispatcher();
                    RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$1 = new RealImageLoader$executeMain$result$1(request, realImageLoader2, size2, eventListener, placeholderBitmap, null);
                    c25771.L$0 = realImageLoader2;
                    c25771.L$1 = requestDelegate2;
                    c25771.L$2 = request;
                    c25771.L$3 = eventListener;
                    c25771.L$4 = null;
                    c25771.label = 3;
                    objWithContext = BuildersKt.withContext(interceptorDispatcher, realImageLoader$executeMain$result$1, c25771);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    request2 = request;
                    requestDelegate = requestDelegate2;
                    realImageLoader = realImageLoader2;
                    result = (ImageResult) objWithContext;
                    if (result instanceof SuccessResult) {
                        realImageLoader.onSuccess((SuccessResult) result, request2.getTarget(), eventListener);
                    } else if (result instanceof ErrorResult) {
                        realImageLoader.onError((ErrorResult) result, request2.getTarget(), eventListener);
                    }
                    requestDelegate.complete();
                    return result;
                } catch (Throwable th) {
                    throwable = th;
                    request2 = request;
                    requestDelegate = requestDelegate3;
                    eventListener = eventListener2;
                    try {
                        if (!(throwable instanceof CancellationException)) {
                            realImageLoader.onCancel(request2, eventListener);
                            throw throwable;
                        }
                        ErrorResult result2 = realImageLoader.requestService.errorResult(request2, throwable);
                        realImageLoader.onError(result2, request2.getTarget(), eventListener);
                        requestDelegate.complete();
                        return result2;
                    } catch (Throwable throwable) {
                        requestDelegate.complete();
                        throw throwable;
                    }
                }
            case 1:
                eventListener = (EventListener) c25771.L$3;
                request = (ImageRequest) c25771.L$2;
                requestDelegate2 = (RequestDelegate) c25771.L$1;
                realImageLoader2 = (RealImageLoader) c25771.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    $this$get$iv = realImageLoader2.getMemoryCache();
                    if ($this$get$iv == null) {
                        placeholderBitmap = null;
                    } else {
                        key$iv = request.getPlaceholderMemoryCacheKey();
                        if (key$iv != null) {
                            value = $this$get$iv.get(key$iv);
                        } else {
                            value = null;
                        }
                        if (value != null) {
                            placeholderBitmap = value.getBitmap();
                        } else {
                            placeholderBitmap = null;
                        }
                    }
                    if (placeholderBitmap != null) {
                        Context context$iv2 = request.getContext();
                        Bitmap $this$toDrawable$iv2 = placeholderBitmap;
                        Resources resources$iv$iv2 = context$iv2.getResources();
                        placeholder = new BitmapDrawable(resources$iv$iv2, $this$toDrawable$iv2);
                    } else {
                        placeholder = request.getPlaceholder();
                    }
                    target = request.getTarget();
                    if (target != null) {
                        target.onStart(placeholder);
                    }
                    eventListener.onStart(request);
                    listener = request.getListener();
                    if (listener != null) {
                        listener.onStart(request);
                    }
                    eventListener.resolveSizeStart(request);
                    SizeResolver sizeResolver2 = request.getSizeResolver();
                    c25771.L$0 = realImageLoader2;
                    c25771.L$1 = requestDelegate2;
                    c25771.L$2 = request;
                    c25771.L$3 = eventListener;
                    c25771.L$4 = placeholderBitmap;
                    c25771.label = 2;
                    size = sizeResolver2.size(c25771);
                    if (size == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Size size3 = (Size) size;
                    eventListener.resolveSizeEnd(request, size3);
                    CoroutineDispatcher interceptorDispatcher2 = request.getInterceptorDispatcher();
                    RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$2 = new RealImageLoader$executeMain$result$1(request, realImageLoader2, size3, eventListener, placeholderBitmap, null);
                    c25771.L$0 = realImageLoader2;
                    c25771.L$1 = requestDelegate2;
                    c25771.L$2 = request;
                    c25771.L$3 = eventListener;
                    c25771.L$4 = null;
                    c25771.label = 3;
                    objWithContext = BuildersKt.withContext(interceptorDispatcher2, realImageLoader$executeMain$result$2, c25771);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    request2 = request;
                    requestDelegate = requestDelegate2;
                    realImageLoader = realImageLoader2;
                    result = (ImageResult) objWithContext;
                    if (result instanceof SuccessResult) {
                        realImageLoader.onSuccess((SuccessResult) result, request2.getTarget(), eventListener);
                    } else if (result instanceof ErrorResult) {
                        realImageLoader.onError((ErrorResult) result, request2.getTarget(), eventListener);
                    }
                    requestDelegate.complete();
                    return result;
                } catch (Throwable th2) {
                    throwable = th2;
                    request2 = request;
                    requestDelegate = requestDelegate2;
                    realImageLoader = realImageLoader2;
                    if (!(throwable instanceof CancellationException)) {
                        realImageLoader.onCancel(request2, eventListener);
                        throw throwable;
                    }
                    ErrorResult result3 = realImageLoader.requestService.errorResult(request2, throwable);
                    realImageLoader.onError(result3, request2.getTarget(), eventListener);
                    requestDelegate.complete();
                    return result3;
                }
            case 2:
                Bitmap placeholderBitmap2 = (Bitmap) c25771.L$4;
                EventListener eventListener3 = (EventListener) c25771.L$3;
                ImageRequest request3 = (ImageRequest) c25771.L$2;
                RequestDelegate requestDelegate4 = (RequestDelegate) c25771.L$1;
                RealImageLoader realImageLoader3 = (RealImageLoader) c25771.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    size = $result;
                    placeholderBitmap = placeholderBitmap2;
                    eventListener = eventListener3;
                    request = request3;
                    requestDelegate2 = requestDelegate4;
                    realImageLoader2 = realImageLoader3;
                    Size size4 = (Size) size;
                    eventListener.resolveSizeEnd(request, size4);
                    CoroutineDispatcher interceptorDispatcher3 = request.getInterceptorDispatcher();
                    RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$3 = new RealImageLoader$executeMain$result$1(request, realImageLoader2, size4, eventListener, placeholderBitmap, null);
                    c25771.L$0 = realImageLoader2;
                    c25771.L$1 = requestDelegate2;
                    c25771.L$2 = request;
                    c25771.L$3 = eventListener;
                    c25771.L$4 = null;
                    c25771.label = 3;
                    objWithContext = BuildersKt.withContext(interceptorDispatcher3, realImageLoader$executeMain$result$3, c25771);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    request2 = request;
                    requestDelegate = requestDelegate2;
                    realImageLoader = realImageLoader2;
                    result = (ImageResult) objWithContext;
                    if (result instanceof SuccessResult) {
                        realImageLoader.onSuccess((SuccessResult) result, request2.getTarget(), eventListener);
                    } else if (result instanceof ErrorResult) {
                        realImageLoader.onError((ErrorResult) result, request2.getTarget(), eventListener);
                    }
                    requestDelegate.complete();
                    return result;
                } catch (Throwable th3) {
                    throwable = th3;
                    eventListener = eventListener3;
                    request2 = request3;
                    requestDelegate = requestDelegate4;
                    realImageLoader = realImageLoader3;
                    if (!(throwable instanceof CancellationException)) {
                        realImageLoader.onCancel(request2, eventListener);
                        throw throwable;
                    }
                    ErrorResult result4 = realImageLoader.requestService.errorResult(request2, throwable);
                    realImageLoader.onError(result4, request2.getTarget(), eventListener);
                    requestDelegate.complete();
                    return result4;
                }
            case 3:
                eventListener = (EventListener) c25771.L$3;
                request2 = (ImageRequest) c25771.L$2;
                requestDelegate = (RequestDelegate) c25771.L$1;
                realImageLoader = (RealImageLoader) c25771.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    objWithContext = $result;
                    result = (ImageResult) objWithContext;
                    if (result instanceof SuccessResult) {
                        realImageLoader.onSuccess((SuccessResult) result, request2.getTarget(), eventListener);
                    } else if (result instanceof ErrorResult) {
                        realImageLoader.onError((ErrorResult) result, request2.getTarget(), eventListener);
                    }
                    requestDelegate.complete();
                    return result;
                } catch (Throwable th4) {
                    throwable = th4;
                    if (!(throwable instanceof CancellationException)) {
                        realImageLoader.onCancel(request2, eventListener);
                        throw throwable;
                    }
                    ErrorResult result5 = realImageLoader.requestService.errorResult(request2, throwable);
                    realImageLoader.onError(result5, request2.getTarget(), eventListener);
                    requestDelegate.complete();
                    return result5;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void onTrimMemory$coil_base_release(int level) {
        MemoryCache value;
        Lazy<MemoryCache> lazy = this.memoryCacheLazy;
        if (lazy == null || (value = lazy.getValue()) == null) {
            return;
        }
        value.trimMemory(level);
    }

    @Override // coil.ImageLoader
    public void shutdown() {
        if (this.shutdown.getAndSet(true)) {
            return;
        }
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        this.systemCallbacks.shutdown();
        MemoryCache memoryCache = getMemoryCache();
        if (memoryCache != null) {
            memoryCache.clear();
        }
    }

    @Override // coil.ImageLoader
    public ImageLoader.Builder newBuilder() {
        return new ImageLoader.Builder(this);
    }

    private final void onSuccess(SuccessResult result, Target target, EventListener eventListener) {
        ImageRequest request = result.getRequest();
        DataSource dataSource = result.getDataSource();
        Logger $this$log$iv = this.logger;
        if ($this$log$iv != null && $this$log$iv.getLevel() <= 4) {
            $this$log$iv.log(TAG, 4, Utils.getEmoji(dataSource) + " Successful (" + dataSource.name() + ") - " + request.getData(), null);
        }
        if (!(target instanceof TransitionTarget)) {
            if (target != null) {
                target.onSuccess(result.getDrawable());
            }
        } else {
            Transition transition$iv = result.getRequest().getTransitionFactory().create((TransitionTarget) target, result);
            if (transition$iv instanceof NoneTransition) {
                target.onSuccess(result.getDrawable());
            } else {
                eventListener.transitionStart(result.getRequest(), transition$iv);
                transition$iv.transition();
                eventListener.transitionEnd(result.getRequest(), transition$iv);
            }
        }
        eventListener.onSuccess(request, result);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onSuccess(request, result);
        }
    }

    private final void onError(ErrorResult result, Target target, EventListener eventListener) {
        ImageRequest request = result.getRequest();
        Logger $this$log$iv = this.logger;
        if ($this$log$iv != null && $this$log$iv.getLevel() <= 4) {
            $this$log$iv.log(TAG, 4, "🚨 Failed - " + request.getData() + " - " + result.getThrowable(), null);
        }
        if (!(target instanceof TransitionTarget)) {
            if (target != null) {
                target.onError(result.getDrawable());
            }
        } else {
            Transition transition$iv = result.getRequest().getTransitionFactory().create((TransitionTarget) target, result);
            if (transition$iv instanceof NoneTransition) {
                target.onError(result.getDrawable());
            } else {
                eventListener.transitionStart(result.getRequest(), transition$iv);
                transition$iv.transition();
                eventListener.transitionEnd(result.getRequest(), transition$iv);
            }
        }
        eventListener.onError(request, result);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onError(request, result);
        }
    }

    private final void onCancel(ImageRequest request, EventListener eventListener) {
        Logger $this$log$iv = this.logger;
        if ($this$log$iv != null && $this$log$iv.getLevel() <= 4) {
            $this$log$iv.log(TAG, 4, "🏗  Cancelled - " + request.getData(), null);
        }
        eventListener.onCancel(request);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onCancel(request);
        }
    }

    private final void transition(ImageResult result, Target target, EventListener eventListener, Function0<Unit> setDrawable) {
        if (!(target instanceof TransitionTarget)) {
            setDrawable.invoke();
            return;
        }
        Transition transition = result.getRequest().getTransitionFactory().create((TransitionTarget) target, result);
        if (transition instanceof NoneTransition) {
            setDrawable.invoke();
            return;
        }
        eventListener.transitionStart(result.getRequest(), transition);
        transition.transition();
        eventListener.transitionEnd(result.getRequest(), transition);
    }
}
