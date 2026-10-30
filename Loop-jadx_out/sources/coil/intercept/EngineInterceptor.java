package coil.intercept;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.ComponentRegistry;
import coil.EventListener;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.Decoder;
import coil.decode.ImageSource;
import coil.fetch.DrawableResult;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.fetch.SourceResult;
import coil.memory.MemoryCache;
import coil.memory.MemoryCacheService;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.Options;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.size.Scale;
import coil.size.Size;
import coil.transform.Transformation;
import coil.util.Bitmaps;
import coil.util.DrawableUtils;
import coil.util.Logger;
import coil.util.Utils;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.p009ws.WebSocketProtocol;
import org.apache.commons.p013io.FilenameUtils;

/* JADX INFO: compiled from: EngineInterceptor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 02\u00020\u0001:\u000201B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002JA\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 J1\u0010!\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010#J9\u0010$\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010+J3\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0081@ø\u0001\u0000¢\u0006\u0004\b.\u0010/R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, m195d2 = {"Lcoil/intercept/EngineInterceptor;", "Lcoil/intercept/Interceptor;", "imageLoader", "Lcoil/ImageLoader;", "requestService", "Lcoil/request/RequestService;", "logger", "Lcoil/util/Logger;", "(Lcoil/ImageLoader;Lcoil/request/RequestService;Lcoil/util/Logger;)V", "memoryCacheService", "Lcoil/memory/MemoryCacheService;", "convertDrawableToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "options", "Lcoil/request/Options;", "transformations", "", "Lcoil/transform/Transformation;", "decode", "Lcoil/intercept/EngineInterceptor$ExecuteResult;", "fetchResult", "Lcoil/fetch/SourceResult;", "components", "Lcoil/ComponentRegistry;", "request", "Lcoil/request/ImageRequest;", "mappedData", "", "eventListener", "Lcoil/EventListener;", "(Lcoil/fetch/SourceResult;Lcoil/ComponentRegistry;Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "_options", "(Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetch", "Lcoil/fetch/FetchResult;", "(Lcoil/ComponentRegistry;Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intercept", "Lcoil/request/ImageResult;", "chain", "Lcoil/intercept/Interceptor$Chain;", "(Lcoil/intercept/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transform", "result", "transform$coil_base_release", "(Lcoil/intercept/EngineInterceptor$ExecuteResult;Lcoil/request/ImageRequest;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ExecuteResult", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class EngineInterceptor implements Interceptor {
    private static final String TAG = "EngineInterceptor";
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final MemoryCacheService memoryCacheService;
    private final RequestService requestService;

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$decode$1 */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "coil.intercept.EngineInterceptor", m210f = "EngineInterceptor.kt", m211i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, m212l = {199}, m213m = "decode", m214n = {"this", "fetchResult", "components", "request", "mappedData", "options", "eventListener", "decoder", "searchIndex"}, m215s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0"})
    static final class C25961 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C25961(Continuation<? super C25961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.decode(null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$execute$1 */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "coil.intercept.EngineInterceptor", m210f = "EngineInterceptor.kt", m211i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, m212l = {122, WebSocketProtocol.PAYLOAD_SHORT, 144}, m213m = "execute", m214n = {"this", "request", "mappedData", "eventListener", "options", "components", "fetchResult", "this", "request", "eventListener", "options", "fetchResult"}, m215s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C25971 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C25971(Continuation<? super C25971> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.execute(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$fetch$1 */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "coil.intercept.EngineInterceptor", m210f = "EngineInterceptor.kt", m211i = {0, 0, 0, 0, 0, 0, 0, 0}, m212l = {165}, m213m = "fetch", m214n = {"this", "components", "request", "mappedData", "options", "eventListener", "fetcher", "searchIndex"}, m215s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"})
    static final class C25981 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C25981(Continuation<? super C25981> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.fetch(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$intercept$1 */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "coil.intercept.EngineInterceptor", m210f = "EngineInterceptor.kt", m211i = {0, 0}, m212l = {73}, m213m = "intercept", m214n = {"this", "chain"}, m215s = {"L$0", "L$1"})
    static final class C25991 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C25991(Continuation<? super C25991> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.intercept(null, this);
        }
    }

    public EngineInterceptor(ImageLoader imageLoader, RequestService requestService, Logger logger) {
        this.imageLoader = imageLoader;
        this.requestService = requestService;
        this.logger = logger;
        this.memoryCacheService = new MemoryCacheService(this.imageLoader, this.requestService, this.logger);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00d3: IGET (r2 I:coil.request.RequestService) = (r5 I:coil.intercept.EngineInterceptor A[D('this' coil.intercept.EngineInterceptor)]) (LINE:95) coil.intercept.EngineInterceptor.requestService coil.request.RequestService, block:B:31:0x00d3 */
    /* JADX WARN: Type inference failed for: r4v0, types: [coil.intercept.Interceptor$Chain, int] */
    /* JADX WARN: Type inference failed for: r5v0, types: [coil.intercept.EngineInterceptor] */
    @Override // coil.intercept.Interceptor
    public Object intercept(Interceptor.Chain chain, Continuation<? super ImageResult> continuation) {
        C25991 c25991;
        ?? r5;
        if (continuation instanceof C25991) {
            c25991 = (C25991) continuation;
            if ((c25991.label & Integer.MIN_VALUE) != 0) {
                c25991.label -= Integer.MIN_VALUE;
            } else {
                c25991 = new C25991(continuation);
            }
        } else {
            c25991 = new C25991(continuation);
        }
        Object $result = c25991.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r4 = c25991.label;
        try {
            switch (r4) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    ImageRequest request = chain.getRequest();
                    Object data = request.getData();
                    Size size = chain.getSize();
                    EventListener eventListener = Utils.getEventListener(chain);
                    Options options = this.requestService.options(request, size);
                    Scale scale = options.getScale();
                    eventListener.mapStart(request, data);
                    Object mappedData = this.imageLoader.getComponents().map(data, options);
                    eventListener.mapEnd(request, mappedData);
                    MemoryCache.Key cacheKey = this.memoryCacheService.newCacheKey(request, mappedData, options, eventListener);
                    MemoryCache.Value cacheValue = cacheKey != null ? this.memoryCacheService.getCacheValue(request, cacheKey, size, scale) : null;
                    if (cacheValue != null) {
                        return this.memoryCacheService.newResult(chain, request, cacheKey, cacheValue);
                    }
                    CoroutineDispatcher fetcherDispatcher = request.getFetcherDispatcher();
                    C26002 c26002 = new C26002(request, mappedData, options, eventListener, cacheKey, chain, null);
                    c25991.L$0 = this;
                    c25991.L$1 = chain;
                    c25991.label = 1;
                    Object objWithContext = BuildersKt.withContext(fetcherDispatcher, c26002, c25991);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objWithContext;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable throwable) {
            if (throwable instanceof CancellationException) {
                throw throwable;
            }
            return r5.requestService.errorResult(r4.getRequest(), throwable);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$intercept$2 */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "Lcoil/request/SuccessResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "coil.intercept.EngineInterceptor$intercept$2", m210f = "EngineInterceptor.kt", m211i = {}, m212l = {75}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C26002 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SuccessResult>, Object> {
        final /* synthetic */ MemoryCache.Key $cacheKey;
        final /* synthetic */ Interceptor.Chain $chain;
        final /* synthetic */ EventListener $eventListener;
        final /* synthetic */ Object $mappedData;
        final /* synthetic */ Options $options;
        final /* synthetic */ ImageRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C26002(ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, MemoryCache.Key key, Interceptor.Chain chain, Continuation<? super C26002> continuation) {
            super(2, continuation);
            this.$request = imageRequest;
            this.$mappedData = obj;
            this.$options = options;
            this.$eventListener = eventListener;
            this.$cacheKey = key;
            this.$chain = chain;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EngineInterceptor.this.new C26002(this.$request, this.$mappedData, this.$options, this.$eventListener, this.$cacheKey, this.$chain, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SuccessResult> continuation) {
            return ((C26002) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C26002 c26002;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c26002 = this;
                    c26002.label = 1;
                    Object objExecute = EngineInterceptor.this.execute(c26002.$request, c26002.$mappedData, c26002.$options, c26002.$eventListener, c26002);
                    if (objExecute == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objExecute;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    c26002 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ExecuteResult result = (ExecuteResult) $result;
            boolean isCached = EngineInterceptor.this.memoryCacheService.setCacheValue(c26002.$cacheKey, c26002.$request, result);
            return new SuccessResult(result.getDrawable(), c26002.$request, result.getDataSource(), isCached ? c26002.$cacheKey : null, result.getDiskCacheKey(), result.getIsSampled(), Utils.isPlaceholderCached(c26002.$chain));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:102:0x025b  */
    /* JADX WARN: Code duplicated, block: B:103:0x025f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0175 A[Catch: all -> 0x0081, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0081, blocks: (B:19:0x0078, B:54:0x0175), top: B:111:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x01a9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:60:0x01ba A[Catch: all -> 0x0249, TRY_ENTER, TryCatch #4 {all -> 0x0249, blocks: (B:52:0x016b, B:60:0x01ba, B:62:0x01be), top: B:117:0x016b }] */
    /* JADX WARN: Code duplicated, block: B:62:0x01be A[Catch: all -> 0x0249, TRY_LEAVE, TryCatch #4 {all -> 0x0249, blocks: (B:52:0x016b, B:60:0x01ba, B:62:0x01be), top: B:117:0x016b }] */
    /* JADX WARN: Code duplicated, block: B:68:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:69:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:71:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:76:0x0220 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:79:0x022c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:80:0x0230  */
    /* JADX WARN: Code duplicated, block: B:82:0x0233  */
    /* JADX WARN: Code duplicated, block: B:88:0x0240  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, coil.ComponentRegistry] */
    /* JADX WARN: Type inference failed for: r3v10, types: [T, coil.request.Options] */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, coil.ComponentRegistry] */
    public final Object execute(ImageRequest request, Object mappedData, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) throws Throwable {
        C25971 c25971;
        SourceResult sourceResult;
        Ref.ObjectRef fetchResult;
        Ref.ObjectRef components;
        T t;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef fetchResult2;
        EngineInterceptor engineInterceptor;
        Object mappedData2;
        EventListener eventListener2;
        ImageRequest request2;
        Ref.ObjectRef options2;
        FetchResult fetchResult3;
        EngineInterceptor engineInterceptor2;
        ImageRequest request3;
        ExecuteResult executeResult;
        Ref.ObjectRef options3;
        EventListener eventListener3;
        Object objWithContext;
        Ref.ObjectRef fetchResult4;
        EventListener eventListener4;
        EngineInterceptor engineInterceptor3;
        ImageRequest request4;
        T t2;
        SourceResult sourceResult2;
        ImageSource source;
        T t3;
        SourceResult sourceResult3;
        BitmapDrawable bitmapDrawable;
        Object objTransform$coil_base_release;
        ImageSource source2;
        Drawable drawable;
        BitmapDrawable bitmapDrawable2;
        Bitmap bitmap;
        if (continuation instanceof C25971) {
            c25971 = (C25971) continuation;
            if ((c25971.label & Integer.MIN_VALUE) != 0) {
                c25971.label -= Integer.MIN_VALUE;
            } else {
                c25971 = new C25971(continuation);
            }
        } else {
            c25971 = new C25971(continuation);
        }
        Object $result = c25971.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c25971.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Ref.ObjectRef options4 = new Ref.ObjectRef();
                options4.element = options;
                Ref.ObjectRef components2 = new Ref.ObjectRef();
                components2.element = this.imageLoader.getComponents();
                Ref.ObjectRef fetchResult5 = new Ref.ObjectRef();
                try {
                    if (!this.requestService.allowHardwareWorkerThread((Options) options4.element)) {
                        try {
                            Options options5 = (Options) options4.element;
                            options4.element = options5.copy((32765 & 1) != 0 ? options5.context : null, (32765 & 2) != 0 ? options5.config : Bitmap.Config.ARGB_8888, (32765 & 4) != 0 ? options5.colorSpace : null, (32765 & 8) != 0 ? options5.size : null, (32765 & 16) != 0 ? options5.scale : null, (32765 & 32) != 0 ? options5.allowInexactSize : false, (32765 & 64) != 0 ? options5.allowRgb565 : false, (32765 & 128) != 0 ? options5.premultipliedAlpha : false, (32765 & 256) != 0 ? options5.diskCacheKey : null, (32765 & 512) != 0 ? options5.headers : null, (32765 & 1024) != 0 ? options5.tags : null, (32765 & 2048) != 0 ? options5.parameters : null, (32765 & 4096) != 0 ? options5.memoryCachePolicy : null, (32765 & 8192) != 0 ? options5.diskCachePolicy : null, (32765 & 16384) != 0 ? options5.networkCachePolicy : null);
                        } catch (Throwable th) {
                            th = th;
                            fetchResult = fetchResult5;
                            sourceResult = null;
                        }
                    }
                    if (request.getFetcherFactory() != null || request.getDecoderFactory() != null) {
                        ComponentRegistry.Builder $this$addFirst$iv = ((ComponentRegistry) components2.element).newBuilder();
                        Pair<Fetcher.Factory<?>, Class<?>> fetcherFactory = request.getFetcherFactory();
                        if (fetcherFactory != null) {
                            $this$addFirst$iv.getFetcherFactories$coil_base_release().add(0, fetcherFactory);
                        }
                        Decoder.Factory factory$iv = request.getDecoderFactory();
                        if (factory$iv != null) {
                            $this$addFirst$iv.getDecoderFactories$coil_base_release().add(0, factory$iv);
                            break;
                        }
                        components2.element = $this$addFirst$iv.build();
                    }
                    ComponentRegistry componentRegistry = (ComponentRegistry) components2.element;
                    Options options6 = (Options) options4.element;
                    c25971.L$0 = this;
                    c25971.L$1 = request;
                    c25971.L$2 = mappedData;
                    c25971.L$3 = eventListener;
                    c25971.L$4 = options4;
                    c25971.L$5 = components2;
                    c25971.L$6 = fetchResult5;
                    c25971.L$7 = fetchResult5;
                    c25971.label = 1;
                    try {
                        Object objFetch = fetch(componentRegistry, request, mappedData, options6, eventListener, c25971);
                        if (objFetch == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        components = components2;
                        t = objFetch;
                        objectRef = fetchResult5;
                        fetchResult2 = objectRef;
                        engineInterceptor = this;
                        mappedData2 = mappedData;
                        eventListener2 = eventListener;
                        request2 = request;
                        options2 = options4;
                        try {
                            objectRef.element = t;
                            fetchResult3 = (FetchResult) fetchResult2.element;
                            if (fetchResult3 instanceof SourceResult) {
                                if (!(fetchResult3 instanceof DrawableResult)) {
                                    try {
                                        fetchResult = fetchResult2;
                                        engineInterceptor2 = engineInterceptor;
                                        request3 = request2;
                                        executeResult = new ExecuteResult(((DrawableResult) fetchResult2.element).getDrawable(), ((DrawableResult) fetchResult2.element).getIsSampled(), ((DrawableResult) fetchResult2.element).getDataSource(), null);
                                        options3 = options2;
                                        eventListener3 = eventListener2;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        sourceResult = null;
                                    }
                                } else {
                                    sourceResult = null;
                                    try {
                                        throw new NoWhenBranchMatchedException();
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                }
                                fetchResult = fetchResult2;
                                t2 = fetchResult.element;
                                if (t2 instanceof SourceResult) {
                                    sourceResult2 = (SourceResult) t2;
                                } else {
                                    sourceResult2 = sourceResult;
                                }
                                if (sourceResult2 != null && (source = sourceResult2.getSource()) != null) {
                                    Utils.closeQuietly(source);
                                }
                                throw th;
                            }
                            CoroutineDispatcher decoderDispatcher = request2.getDecoderDispatcher();
                            EngineInterceptor$execute$executeResult$1 engineInterceptor$execute$executeResult$1 = new EngineInterceptor$execute$executeResult$1(engineInterceptor, fetchResult2, components, request2, mappedData2, options2, eventListener2, null);
                            c25971.L$0 = engineInterceptor;
                            c25971.L$1 = request2;
                            c25971.L$2 = eventListener2;
                            c25971.L$3 = options2;
                            c25971.L$4 = fetchResult2;
                            c25971.L$5 = null;
                            c25971.L$6 = null;
                            c25971.L$7 = null;
                            c25971.label = 2;
                            objWithContext = BuildersKt.withContext(decoderDispatcher, engineInterceptor$execute$executeResult$1, c25971);
                            if (objWithContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            fetchResult = fetchResult2;
                            fetchResult4 = options2;
                            eventListener4 = eventListener2;
                            engineInterceptor3 = engineInterceptor;
                            request4 = request2;
                            eventListener3 = eventListener4;
                            request3 = request4;
                            engineInterceptor2 = engineInterceptor3;
                            Ref.ObjectRef objectRef2 = fetchResult4;
                            executeResult = (ExecuteResult) objWithContext;
                            options3 = objectRef2;
                            t3 = fetchResult.element;
                            if (t3 instanceof SourceResult) {
                                sourceResult3 = (SourceResult) t3;
                            } else {
                                sourceResult3 = null;
                            }
                            if (sourceResult3 != null && (source2 = sourceResult3.getSource()) != null) {
                                Utils.closeQuietly(source2);
                            }
                            Options options7 = (Options) options3.element;
                            bitmapDrawable = null;
                            c25971.L$0 = null;
                            c25971.L$1 = null;
                            c25971.L$2 = null;
                            c25971.L$3 = null;
                            c25971.L$4 = null;
                            c25971.L$5 = null;
                            c25971.L$6 = null;
                            c25971.L$7 = null;
                            c25971.label = 3;
                            objTransform$coil_base_release = engineInterceptor2.transform$coil_base_release(executeResult, request3, options7, eventListener3, c25971);
                            if (objTransform$coil_base_release == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ExecuteResult finalResult = (ExecuteResult) objTransform$coil_base_release;
                            drawable = finalResult.getDrawable();
                            if (drawable instanceof BitmapDrawable) {
                                bitmapDrawable2 = (BitmapDrawable) drawable;
                            } else {
                                bitmapDrawable2 = bitmapDrawable;
                            }
                            if (bitmapDrawable2 != null && (bitmap = bitmapDrawable2.getBitmap()) != null) {
                                bitmap.prepareToDraw();
                            }
                            return finalResult;
                        } catch (Throwable th4) {
                            th = th4;
                            sourceResult = null;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        sourceResult = null;
                        fetchResult = fetchResult5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    sourceResult = null;
                    fetchResult = fetchResult5;
                }
                break;
            case 1:
                objectRef = (Ref.ObjectRef) c25971.L$7;
                fetchResult2 = (Ref.ObjectRef) c25971.L$6;
                components = (Ref.ObjectRef) c25971.L$5;
                options2 = (Ref.ObjectRef) c25971.L$4;
                eventListener2 = (EventListener) c25971.L$3;
                Object mappedData3 = c25971.L$2;
                request2 = (ImageRequest) c25971.L$1;
                EngineInterceptor engineInterceptor4 = (EngineInterceptor) c25971.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    mappedData2 = mappedData3;
                    t = $result;
                    engineInterceptor = engineInterceptor4;
                    objectRef.element = t;
                    fetchResult3 = (FetchResult) fetchResult2.element;
                    if (fetchResult3 instanceof SourceResult) {
                        if (!(fetchResult3 instanceof DrawableResult)) {
                            sourceResult = null;
                            throw new NoWhenBranchMatchedException();
                        }
                        fetchResult = fetchResult2;
                        engineInterceptor2 = engineInterceptor;
                        request3 = request2;
                        executeResult = new ExecuteResult(((DrawableResult) fetchResult2.element).getDrawable(), ((DrawableResult) fetchResult2.element).getIsSampled(), ((DrawableResult) fetchResult2.element).getDataSource(), null);
                        options3 = options2;
                        eventListener3 = eventListener2;
                        fetchResult = fetchResult2;
                        t2 = fetchResult.element;
                        if (t2 instanceof SourceResult) {
                            sourceResult2 = (SourceResult) t2;
                        } else {
                            sourceResult2 = sourceResult;
                        }
                        if (sourceResult2 != null) {
                            Utils.closeQuietly(source);
                        }
                        throw th;
                    }
                    CoroutineDispatcher decoderDispatcher2 = request2.getDecoderDispatcher();
                    EngineInterceptor$execute$executeResult$1 engineInterceptor$execute$executeResult$2 = new EngineInterceptor$execute$executeResult$1(engineInterceptor, fetchResult2, components, request2, mappedData2, options2, eventListener2, null);
                    c25971.L$0 = engineInterceptor;
                    c25971.L$1 = request2;
                    c25971.L$2 = eventListener2;
                    c25971.L$3 = options2;
                    c25971.L$4 = fetchResult2;
                    c25971.L$5 = null;
                    c25971.L$6 = null;
                    c25971.L$7 = null;
                    c25971.label = 2;
                    objWithContext = BuildersKt.withContext(decoderDispatcher2, engineInterceptor$execute$executeResult$2, c25971);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    fetchResult = fetchResult2;
                    fetchResult4 = options2;
                    eventListener4 = eventListener2;
                    engineInterceptor3 = engineInterceptor;
                    request4 = request2;
                    eventListener3 = eventListener4;
                    request3 = request4;
                    engineInterceptor2 = engineInterceptor3;
                    Ref.ObjectRef objectRef3 = fetchResult4;
                    executeResult = (ExecuteResult) objWithContext;
                    options3 = objectRef3;
                    t3 = fetchResult.element;
                    if (t3 instanceof SourceResult) {
                        sourceResult3 = (SourceResult) t3;
                    } else {
                        sourceResult3 = null;
                    }
                    if (sourceResult3 != null) {
                        Utils.closeQuietly(source2);
                    }
                    Options options8 = (Options) options3.element;
                    bitmapDrawable = null;
                    c25971.L$0 = null;
                    c25971.L$1 = null;
                    c25971.L$2 = null;
                    c25971.L$3 = null;
                    c25971.L$4 = null;
                    c25971.L$5 = null;
                    c25971.L$6 = null;
                    c25971.L$7 = null;
                    c25971.label = 3;
                    objTransform$coil_base_release = engineInterceptor2.transform$coil_base_release(executeResult, request3, options8, eventListener3, c25971);
                    if (objTransform$coil_base_release == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ExecuteResult finalResult2 = (ExecuteResult) objTransform$coil_base_release;
                    drawable = finalResult2.getDrawable();
                    if (drawable instanceof BitmapDrawable) {
                        bitmapDrawable2 = (BitmapDrawable) drawable;
                    } else {
                        bitmapDrawable2 = bitmapDrawable;
                    }
                    if (bitmapDrawable2 != null) {
                        bitmap.prepareToDraw();
                    }
                    return finalResult2;
                } catch (Throwable th7) {
                    th = th7;
                    fetchResult = fetchResult2;
                    sourceResult = null;
                }
                break;
            case 2:
                fetchResult = (Ref.ObjectRef) c25971.L$4;
                fetchResult4 = (Ref.ObjectRef) c25971.L$3;
                eventListener4 = (EventListener) c25971.L$2;
                request4 = (ImageRequest) c25971.L$1;
                engineInterceptor3 = (EngineInterceptor) c25971.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    objWithContext = $result;
                    eventListener3 = eventListener4;
                    request3 = request4;
                    engineInterceptor2 = engineInterceptor3;
                    Ref.ObjectRef objectRef4 = fetchResult4;
                    executeResult = (ExecuteResult) objWithContext;
                    options3 = objectRef4;
                    t3 = fetchResult.element;
                    if (t3 instanceof SourceResult) {
                        sourceResult3 = (SourceResult) t3;
                    } else {
                        sourceResult3 = null;
                    }
                    if (sourceResult3 != null) {
                        Utils.closeQuietly(source2);
                    }
                    Options options9 = (Options) options3.element;
                    bitmapDrawable = null;
                    c25971.L$0 = null;
                    c25971.L$1 = null;
                    c25971.L$2 = null;
                    c25971.L$3 = null;
                    c25971.L$4 = null;
                    c25971.L$5 = null;
                    c25971.L$6 = null;
                    c25971.L$7 = null;
                    c25971.label = 3;
                    objTransform$coil_base_release = engineInterceptor2.transform$coil_base_release(executeResult, request3, options9, eventListener3, c25971);
                    if (objTransform$coil_base_release == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ExecuteResult finalResult3 = (ExecuteResult) objTransform$coil_base_release;
                    drawable = finalResult3.getDrawable();
                    if (drawable instanceof BitmapDrawable) {
                        bitmapDrawable2 = (BitmapDrawable) drawable;
                    } else {
                        bitmapDrawable2 = bitmapDrawable;
                    }
                    if (bitmapDrawable2 != null) {
                        bitmap.prepareToDraw();
                    }
                    return finalResult3;
                } catch (Throwable th8) {
                    th = th8;
                    sourceResult = null;
                }
                break;
            case 3:
                ResultKt.throwOnFailure($result);
                objTransform$coil_base_release = $result;
                bitmapDrawable = null;
                ExecuteResult finalResult4 = (ExecuteResult) objTransform$coil_base_release;
                drawable = finalResult4.getDrawable();
                if (drawable instanceof BitmapDrawable) {
                    bitmapDrawable2 = (BitmapDrawable) drawable;
                } else {
                    bitmapDrawable2 = bitmapDrawable;
                }
                if (bitmapDrawable2 != null) {
                    bitmap.prepareToDraw();
                }
                return finalResult4;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x0079  */
    /* JADX WARN: Code duplicated, block: B:18:0x00a7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:23:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:25:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00a8 -> B:20:0x00ac). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object fetch(coil.ComponentRegistry r17, coil.request.ImageRequest r18, java.lang.Object r19, coil.request.Options r20, coil.EventListener r21, kotlin.coroutines.Continuation<? super coil.fetch.FetchResult> r22) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.fetch(coil.ComponentRegistry, coil.request.ImageRequest, java.lang.Object, coil.request.Options, coil.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x007e  */
    /* JADX WARN: Code duplicated, block: B:18:0x00ae A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x00af  */
    /* JADX WARN: Code duplicated, block: B:22:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:24:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:25:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:27:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:30:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00af -> B:20:0x00b6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object decode(coil.fetch.SourceResult r18, coil.ComponentRegistry r19, coil.request.ImageRequest r20, java.lang.Object r21, coil.request.Options r22, coil.EventListener r23, kotlin.coroutines.Continuation<? super coil.intercept.EngineInterceptor.ExecuteResult> r24) {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.decode(coil.fetch.SourceResult, coil.ComponentRegistry, coil.request.ImageRequest, java.lang.Object, coil.request.Options, coil.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object transform$coil_base_release(ExecuteResult result, ImageRequest request, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) {
        List<Transformation> transformations = request.getTransformations();
        if (transformations.isEmpty()) {
            return result;
        }
        if (!(result.getDrawable() instanceof BitmapDrawable) && !request.getAllowConversionToBitmap()) {
            Logger $this$log$iv = this.logger;
            if ($this$log$iv != null && $this$log$iv.getLevel() <= 4) {
                String type = result.getDrawable().getClass().getCanonicalName();
                $this$log$iv.log(TAG, 4, "allowConversionToBitmap=false, skipping transformations for type " + type + FilenameUtils.EXTENSION_SEPARATOR, null);
            }
            return result;
        }
        return BuildersKt.withContext(request.getTransformationDispatcher(), new EngineInterceptor$transform$3(this, result, options, transformations, eventListener, request, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap convertDrawableToBitmap(Drawable drawable, Options options, List<? extends Transformation> transformations) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap.Config config = Bitmaps.getSafeConfig(bitmap);
            if (ArraysKt.contains(Utils.getVALID_TRANSFORMATION_CONFIGS(), config)) {
                return bitmap;
            }
            Logger $this$log$iv = this.logger;
            if ($this$log$iv != null && $this$log$iv.getLevel() <= 4) {
                $this$log$iv.log(TAG, 4, "Converting bitmap with config " + config + " to apply transformations: " + transformations + FilenameUtils.EXTENSION_SEPARATOR, null);
            }
        } else {
            Logger $this$log$iv2 = this.logger;
            if ($this$log$iv2 != null && $this$log$iv2.getLevel() <= 4) {
                $this$log$iv2.log(TAG, 4, "Converting drawable of type " + drawable.getClass().getCanonicalName() + " to apply transformations: " + transformations + FilenameUtils.EXTENSION_SEPARATOR, null);
            }
        }
        return DrawableUtils.INSTANCE.convertToBitmap(drawable, options.getConfig(), options.getSize(), options.getScale(), options.getAllowInexactSize());
    }

    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(m194d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011¨\u0006\u0013"}, m195d2 = {"Lcoil/intercept/EngineInterceptor$ExecuteResult;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "isSampled", "", "dataSource", "Lcoil/decode/DataSource;", "diskCacheKey", "", "(Landroid/graphics/drawable/Drawable;ZLcoil/decode/DataSource;Ljava/lang/String;)V", "getDataSource", "()Lcoil/decode/DataSource;", "getDiskCacheKey", "()Ljava/lang/String;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "()Z", "copy", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class ExecuteResult {
        private final DataSource dataSource;
        private final String diskCacheKey;
        private final Drawable drawable;
        private final boolean isSampled;

        public ExecuteResult(Drawable drawable, boolean isSampled, DataSource dataSource, String diskCacheKey) {
            this.drawable = drawable;
            this.isSampled = isSampled;
            this.dataSource = dataSource;
            this.diskCacheKey = diskCacheKey;
        }

        public final Drawable getDrawable() {
            return this.drawable;
        }

        /* JADX INFO: renamed from: isSampled, reason: from getter */
        public final boolean getIsSampled() {
            return this.isSampled;
        }

        public final DataSource getDataSource() {
            return this.dataSource;
        }

        public final String getDiskCacheKey() {
            return this.diskCacheKey;
        }

        public static /* synthetic */ ExecuteResult copy$default(ExecuteResult executeResult, Drawable drawable, boolean z, DataSource dataSource, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                drawable = executeResult.drawable;
            }
            if ((i & 2) != 0) {
                z = executeResult.isSampled;
            }
            if ((i & 4) != 0) {
                dataSource = executeResult.dataSource;
            }
            if ((i & 8) != 0) {
                str = executeResult.diskCacheKey;
            }
            return executeResult.copy(drawable, z, dataSource, str);
        }

        public final ExecuteResult copy(Drawable drawable, boolean isSampled, DataSource dataSource, String diskCacheKey) {
            return new ExecuteResult(drawable, isSampled, dataSource, diskCacheKey);
        }
    }
}
