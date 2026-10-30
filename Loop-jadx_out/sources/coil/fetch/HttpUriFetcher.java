package coil.fetch;

import android.net.Uri;
import android.os.NetworkOnMainThreadException;
import android.webkit.MimeTypeMap;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.ImageSource;
import coil.decode.ImageSources;
import coil.disk.DiskCache;
import coil.network.CacheResponse;
import coil.network.CacheStrategy;
import coil.network.HttpException;
import coil.request.Options;
import coil.util.Calls;
import coil.util.Utils;
import java.io.Closeable;
import java.io.IOException;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

/* JADX INFO: compiled from: HttpUriFetcher.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 02\u00020\u0001:\u000201B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0011\u0010\u001a\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0001¢\u0006\u0002\b J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\n\u0010$\u001a\u0004\u0018\u00010%H\u0002J.\u0010&\u001a\u0004\u0018\u00010%2\b\u0010'\u001a\u0004\u0018\u00010%2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u000e\u0010*\u001a\u0004\u0018\u00010)*\u00020%H\u0002J\f\u0010+\u001a\u00020,*\u00020\u0016H\u0002J\f\u0010-\u001a\u00020.*\u00020%H\u0002J\f\u0010-\u001a\u00020.*\u00020/H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, m195d2 = {"Lcoil/fetch/HttpUriFetcher;", "Lcoil/fetch/Fetcher;", "url", "", "options", "Lcoil/request/Options;", "callFactory", "Lkotlin/Lazy;", "Lokhttp3/Call$Factory;", "diskCache", "Lcoil/disk/DiskCache;", "respectCacheHeaders", "", "(Ljava/lang/String;Lcoil/request/Options;Lkotlin/Lazy;Lkotlin/Lazy;Z)V", "diskCacheKey", "getDiskCacheKey", "()Ljava/lang/String;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "executeNetworkRequest", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "(Lokhttp3/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetch", "Lcoil/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMimeType", "contentType", "Lokhttp3/MediaType;", "getMimeType$coil_base_release", "isCacheable", "response", "newRequest", "readFromDiskCache", "Lcoil/disk/DiskCache$Snapshot;", "writeToDiskCache", "snapshot", "cacheResponse", "Lcoil/network/CacheResponse;", "toCacheResponse", "toDataSource", "Lcoil/decode/DataSource;", "toImageSource", "Lcoil/decode/ImageSource;", "Lokhttp3/ResponseBody;", "Companion", "Factory", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class HttpUriFetcher implements Fetcher {
    private static final String MIME_TYPE_TEXT_PLAIN = "text/plain";
    private final Lazy<Call.Factory> callFactory;
    private final Lazy<DiskCache> diskCache;
    private final Options options;
    private final boolean respectCacheHeaders;
    private final String url;
    private static final CacheControl CACHE_CONTROL_FORCE_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().noStore().build();
    private static final CacheControl CACHE_CONTROL_NO_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().onlyIfCached().build();

    /* JADX INFO: renamed from: coil.fetch.HttpUriFetcher$executeNetworkRequest$1 */
    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "coil.fetch.HttpUriFetcher", m210f = "HttpUriFetcher.kt", m211i = {}, m212l = {224}, m213m = "executeNetworkRequest", m214n = {}, m215s = {})
    static final class C25941 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C25941(Continuation<? super C25941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpUriFetcher.this.executeNetworkRequest(null, this);
        }
    }

    /* JADX INFO: renamed from: coil.fetch.HttpUriFetcher$fetch$1 */
    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "coil.fetch.HttpUriFetcher", m210f = "HttpUriFetcher.kt", m211i = {0, 0, 0, 1, 1, 1}, m212l = {77, 106}, m213m = "fetch", m214n = {"this", "snapshot", "cacheStrategy", "this", "snapshot", "response"}, m215s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class C25951 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C25951(Continuation<? super C25951> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpUriFetcher.this.fetch(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpUriFetcher(String url, Options options, Lazy<? extends Call.Factory> lazy, Lazy<? extends DiskCache> lazy2, boolean respectCacheHeaders) {
        this.url = url;
        this.options = options;
        this.callFactory = lazy;
        this.diskCache = lazy2;
        this.respectCacheHeaders = respectCacheHeaders;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x012f A[Catch: Exception -> 0x01a5, TryCatch #2 {Exception -> 0x01a5, blocks: (B:50:0x011f, B:52:0x012f, B:54:0x013d, B:55:0x0141, B:57:0x014b, B:59:0x0153, B:61:0x016b), top: B:78:0x011f }] */
    /* JADX WARN: Code duplicated, block: B:54:0x013d A[Catch: Exception -> 0x01a5, TryCatch #2 {Exception -> 0x01a5, blocks: (B:50:0x011f, B:52:0x012f, B:54:0x013d, B:55:0x0141, B:57:0x014b, B:59:0x0153, B:61:0x016b), top: B:78:0x011f }] */
    /* JADX WARN: Code duplicated, block: B:57:0x014b A[Catch: Exception -> 0x01a5, TryCatch #2 {Exception -> 0x01a5, blocks: (B:50:0x011f, B:52:0x012f, B:54:0x013d, B:55:0x0141, B:57:0x014b, B:59:0x0153, B:61:0x016b), top: B:78:0x011f }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0153 A[Catch: Exception -> 0x01a5, TryCatch #2 {Exception -> 0x01a5, blocks: (B:50:0x011f, B:52:0x012f, B:54:0x013d, B:55:0x0141, B:57:0x014b, B:59:0x0153, B:61:0x016b), top: B:78:0x011f }] */
    /* JADX WARN: Code duplicated, block: B:61:0x016b A[Catch: Exception -> 0x01a5, TRY_LEAVE, TryCatch #2 {Exception -> 0x01a5, blocks: (B:50:0x011f, B:52:0x012f, B:54:0x013d, B:55:0x0141, B:57:0x014b, B:59:0x0153, B:61:0x016b), top: B:78:0x011f }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0184 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:64:0x0185  */
    /* JADX WARN: Code duplicated, block: B:75:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    @Override // coil.fetch.Fetcher
    public Object fetch(Continuation<? super FetchResult> continuation) throws Exception {
        C25951 c25951;
        CacheStrategy cacheStrategy;
        Object objExecuteNetworkRequest;
        HttpUriFetcher httpUriFetcher;
        DiskCache.Snapshot snapshot;
        Response response;
        ResponseBody responseBody;
        Response response2;
        DiskCache.Snapshot snapshot2;
        Object objExecuteNetworkRequest2;
        if (continuation instanceof C25951) {
            c25951 = (C25951) continuation;
            if ((c25951.label & Integer.MIN_VALUE) != 0) {
                c25951.label -= Integer.MIN_VALUE;
            } else {
                c25951 = new C25951(continuation);
            }
        } else {
            c25951 = new C25951(continuation);
        }
        C25951 c25952 = c25951;
        Object $result = c25952.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = c25952.label;
        try {
            try {
                switch (r2) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        DiskCache.Snapshot snapshot3 = readFromDiskCache();
                        if (snapshot3 != null) {
                            Long size = getFileSystem().metadata(snapshot3.getMetadata()).getSize();
                            if (size != null && size.longValue() == 0) {
                                return new SourceResult(toImageSource(snapshot3), getMimeType$coil_base_release(this.url, null), DataSource.DISK);
                            }
                            if (!this.respectCacheHeaders) {
                                ImageSource imageSource = toImageSource(snapshot3);
                                String str = this.url;
                                CacheResponse cacheResponse = toCacheResponse(snapshot3);
                                return new SourceResult(imageSource, getMimeType$coil_base_release(str, cacheResponse != null ? cacheResponse.getContentType() : null), DataSource.DISK);
                            }
                            cacheStrategy = new CacheStrategy.Factory(newRequest(), toCacheResponse(snapshot3)).compute();
                            if (cacheStrategy.getNetworkRequest() == null && cacheStrategy.getCacheResponse() != null) {
                                return new SourceResult(toImageSource(snapshot3), getMimeType$coil_base_release(this.url, cacheStrategy.getCacheResponse().getContentType()), DataSource.DISK);
                            }
                        } else {
                            cacheStrategy = new CacheStrategy.Factory(newRequest(), null).compute();
                        }
                        Request networkRequest = cacheStrategy.getNetworkRequest();
                        Intrinsics.checkNotNull(networkRequest);
                        c25952.L$0 = this;
                        c25952.L$1 = snapshot3;
                        c25952.L$2 = cacheStrategy;
                        c25952.label = 1;
                        objExecuteNetworkRequest = executeNetworkRequest(networkRequest, c25952);
                        if (objExecuteNetworkRequest == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        httpUriFetcher = this;
                        snapshot = snapshot3;
                        response = (Response) objExecuteNetworkRequest;
                        responseBody = Utils.requireBody(response);
                        try {
                            snapshot2 = httpUriFetcher.writeToDiskCache(snapshot, cacheStrategy.getNetworkRequest(), response, cacheStrategy.getCacheResponse());
                            if (snapshot2 != null) {
                                ImageSource imageSource2 = httpUriFetcher.toImageSource(snapshot2);
                                String str2 = httpUriFetcher.url;
                                CacheResponse cacheResponse2 = httpUriFetcher.toCacheResponse(snapshot2);
                                return new SourceResult(imageSource2, httpUriFetcher.getMimeType$coil_base_release(str2, cacheResponse2 != null ? cacheResponse2.getContentType() : null), DataSource.NETWORK);
                            }
                            if (responseBody.getContentLength() > 0) {
                                return new SourceResult(httpUriFetcher.toImageSource(responseBody), httpUriFetcher.getMimeType$coil_base_release(httpUriFetcher.url, responseBody.getMediaType()), httpUriFetcher.toDataSource(response));
                            }
                            Utils.closeQuietly(response);
                            Request requestNewRequest = httpUriFetcher.newRequest();
                            c25952.L$0 = httpUriFetcher;
                            c25952.L$1 = snapshot2;
                            c25952.L$2 = response;
                            c25952.label = 2;
                            objExecuteNetworkRequest2 = httpUriFetcher.executeNetworkRequest(requestNewRequest, c25952);
                            if (objExecuteNetworkRequest2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            response2 = (Response) objExecuteNetworkRequest2;
                            ResponseBody responseBody2 = Utils.requireBody(response2);
                            return new SourceResult(httpUriFetcher.toImageSource(responseBody2), httpUriFetcher.getMimeType$coil_base_release(httpUriFetcher.url, responseBody2.getMediaType()), httpUriFetcher.toDataSource(response2));
                        } catch (Exception e) {
                            e = e;
                            response2 = response;
                            Utils.closeQuietly(response2);
                            throw e;
                        }
                    case 1:
                        CacheStrategy cacheStrategy2 = (CacheStrategy) c25952.L$2;
                        DiskCache.Snapshot snapshot4 = (DiskCache.Snapshot) c25952.L$1;
                        HttpUriFetcher httpUriFetcher2 = (HttpUriFetcher) c25952.L$0;
                        ResultKt.throwOnFailure($result);
                        objExecuteNetworkRequest = $result;
                        cacheStrategy = cacheStrategy2;
                        snapshot = snapshot4;
                        httpUriFetcher = httpUriFetcher2;
                        response = (Response) objExecuteNetworkRequest;
                        responseBody = Utils.requireBody(response);
                        snapshot2 = httpUriFetcher.writeToDiskCache(snapshot, cacheStrategy.getNetworkRequest(), response, cacheStrategy.getCacheResponse());
                        if (snapshot2 != null) {
                            ImageSource imageSource3 = httpUriFetcher.toImageSource(snapshot2);
                            String str3 = httpUriFetcher.url;
                            CacheResponse cacheResponse3 = httpUriFetcher.toCacheResponse(snapshot2);
                            return new SourceResult(imageSource3, httpUriFetcher.getMimeType$coil_base_release(str3, cacheResponse3 != null ? cacheResponse3.getContentType() : null), DataSource.NETWORK);
                        }
                        if (responseBody.getContentLength() > 0) {
                            return new SourceResult(httpUriFetcher.toImageSource(responseBody), httpUriFetcher.getMimeType$coil_base_release(httpUriFetcher.url, responseBody.getMediaType()), httpUriFetcher.toDataSource(response));
                        }
                        Utils.closeQuietly(response);
                        Request requestNewRequest2 = httpUriFetcher.newRequest();
                        c25952.L$0 = httpUriFetcher;
                        c25952.L$1 = snapshot2;
                        c25952.L$2 = response;
                        c25952.label = 2;
                        objExecuteNetworkRequest2 = httpUriFetcher.executeNetworkRequest(requestNewRequest2, c25952);
                        if (objExecuteNetworkRequest2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        response2 = (Response) objExecuteNetworkRequest2;
                        ResponseBody responseBody3 = Utils.requireBody(response2);
                        return new SourceResult(httpUriFetcher.toImageSource(responseBody3), httpUriFetcher.getMimeType$coil_base_release(httpUriFetcher.url, responseBody3.getMediaType()), httpUriFetcher.toDataSource(response2));
                    case 2:
                        response2 = (Response) c25952.L$2;
                        HttpUriFetcher httpUriFetcher3 = (HttpUriFetcher) c25952.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            httpUriFetcher = httpUriFetcher3;
                            objExecuteNetworkRequest2 = $result;
                            response2 = (Response) objExecuteNetworkRequest2;
                            ResponseBody responseBody4 = Utils.requireBody(response2);
                            return new SourceResult(httpUriFetcher.toImageSource(responseBody4), httpUriFetcher.getMimeType$coil_base_release(httpUriFetcher.url, responseBody4.getMediaType()), httpUriFetcher.toDataSource(response2));
                        } catch (Exception e2) {
                            e = e2;
                            Utils.closeQuietly(response2);
                            throw e;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e3) {
                e = e3;
                if (r2 != 0) {
                    Utils.closeQuietly((Closeable) r2);
                }
                throw e;
            }
        } catch (Exception e4) {
            e = e4;
            if (r2 != 0) {
                Utils.closeQuietly((Closeable) r2);
            }
            throw e;
        }
    }

    private final DiskCache.Snapshot readFromDiskCache() {
        DiskCache value;
        if (!this.options.getDiskCachePolicy().getReadEnabled() || (value = this.diskCache.getValue()) == null) {
            return null;
        }
        return value.openSnapshot(getDiskCacheKey());
    }

    private final DiskCache.Snapshot writeToDiskCache(DiskCache.Snapshot snapshot, Request request, Response response, CacheResponse cacheResponse) {
        DiskCache.Editor editorOpenEditor;
        if (!isCacheable(request, response)) {
            if (snapshot != null) {
                Utils.closeQuietly(snapshot);
            }
            return null;
        }
        if (snapshot != null) {
            editorOpenEditor = snapshot.closeAndOpenEditor();
        } else {
            DiskCache value = this.diskCache.getValue();
            editorOpenEditor = value != null ? value.openEditor(getDiskCacheKey()) : null;
        }
        DiskCache.Editor editor = editorOpenEditor;
        try {
            if (editor == null) {
                return null;
            }
            try {
                if (response.code() == 304 && cacheResponse != null) {
                    Response combinedResponse = response.newBuilder().headers(CacheStrategy.INSTANCE.combineHeaders(cacheResponse.getResponseHeaders(), response.headers())).build();
                    FileSystem $this$iv = getFileSystem();
                    Path file$iv = editor.getMetadata();
                    Closeable $this$use$iv$iv = Okio.buffer($this$iv.sink(file$iv, false));
                    Object result$iv$iv = null;
                    Throwable thrown$iv$iv = null;
                    try {
                        BufferedSink it$iv = (BufferedSink) $this$use$iv$iv;
                        new CacheResponse(combinedResponse).writeTo(it$iv);
                        result$iv$iv = Unit.INSTANCE;
                        if ($this$use$iv$iv != null) {
                            try {
                                $this$use$iv$iv.close();
                            } catch (Throwable t$iv$iv) {
                                thrown$iv$iv = t$iv$iv;
                            }
                        }
                    } catch (Throwable t$iv$iv2) {
                        thrown$iv$iv = t$iv$iv2;
                        if ($this$use$iv$iv != null) {
                            try {
                                $this$use$iv$iv.close();
                            } catch (Throwable t$iv$iv3) {
                                ExceptionsKt.addSuppressed(thrown$iv$iv, t$iv$iv3);
                            }
                        }
                    }
                    if (thrown$iv$iv != null) {
                        throw thrown$iv$iv;
                    }
                    Intrinsics.checkNotNull(result$iv$iv);
                } else {
                    FileSystem $this$iv2 = getFileSystem();
                    Path file$iv2 = editor.getMetadata();
                    Closeable $this$use$iv$iv2 = Okio.buffer($this$iv2.sink(file$iv2, false));
                    Object result$iv$iv2 = null;
                    Throwable thrown$iv$iv2 = null;
                    try {
                        BufferedSink it$iv2 = (BufferedSink) $this$use$iv$iv2;
                        new CacheResponse(response).writeTo(it$iv2);
                        result$iv$iv2 = Unit.INSTANCE;
                        if ($this$use$iv$iv2 != null) {
                            try {
                                $this$use$iv$iv2.close();
                            } catch (Throwable t$iv$iv4) {
                                thrown$iv$iv2 = t$iv$iv4;
                            }
                        }
                    } catch (Throwable t$iv$iv5) {
                        thrown$iv$iv2 = t$iv$iv5;
                        if ($this$use$iv$iv2 != null) {
                            try {
                                $this$use$iv$iv2.close();
                            } catch (Throwable t$iv$iv6) {
                                ExceptionsKt.addSuppressed(thrown$iv$iv2, t$iv$iv6);
                            }
                        }
                    }
                    if (thrown$iv$iv2 != null) {
                        throw thrown$iv$iv2;
                    }
                    Intrinsics.checkNotNull(result$iv$iv2);
                    FileSystem $this$iv3 = getFileSystem();
                    Path file$iv3 = editor.getData();
                    Closeable $this$use$iv$iv3 = Okio.buffer($this$iv3.sink(file$iv3, false));
                    Object result$iv$iv3 = null;
                    Throwable thrown$iv$iv3 = null;
                    try {
                        BufferedSink it$iv3 = (BufferedSink) $this$use$iv$iv3;
                        ResponseBody responseBodyBody = response.body();
                        Intrinsics.checkNotNull(responseBodyBody);
                        result$iv$iv3 = Long.valueOf(responseBodyBody.getSource().readAll(it$iv3));
                        if ($this$use$iv$iv3 != null) {
                            try {
                                $this$use$iv$iv3.close();
                            } catch (Throwable t$iv$iv7) {
                                thrown$iv$iv3 = t$iv$iv7;
                            }
                        }
                    } catch (Throwable t$iv$iv8) {
                        thrown$iv$iv3 = t$iv$iv8;
                        if ($this$use$iv$iv3 != null) {
                            try {
                                $this$use$iv$iv3.close();
                            } catch (Throwable t$iv$iv9) {
                                ExceptionsKt.addSuppressed(thrown$iv$iv3, t$iv$iv9);
                            }
                        }
                    }
                    if (thrown$iv$iv3 != null) {
                        throw thrown$iv$iv3;
                    }
                    Intrinsics.checkNotNull(result$iv$iv3);
                }
                DiskCache.Snapshot snapshotCommitAndOpenSnapshot = editor.commitAndOpenSnapshot();
                Utils.closeQuietly(response);
                return snapshotCommitAndOpenSnapshot;
            } catch (Exception e) {
                Utils.abortQuietly(editor);
                throw e;
            }
        } catch (Throwable th) {
            Utils.closeQuietly(response);
            throw th;
        }
    }

    private final Request newRequest() {
        Request.Builder request = new Request.Builder().url(this.url).headers(this.options.getHeaders());
        for (Map.Entry<Class<?>, Object> entry : this.options.getTags().asMap().entrySet()) {
            Class<?> key = entry.getKey();
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            request.tag((Class<? super Object>) key, entry.getValue());
        }
        boolean diskRead = this.options.getDiskCachePolicy().getReadEnabled();
        boolean networkRead = this.options.getNetworkCachePolicy().getReadEnabled();
        if (!networkRead && diskRead) {
            request.cacheControl(CacheControl.FORCE_CACHE);
        } else if (!networkRead || diskRead) {
            if (!networkRead && !diskRead) {
                request.cacheControl(CACHE_CONTROL_NO_NETWORK_NO_CACHE);
            }
        } else if (this.options.getDiskCachePolicy().getWriteEnabled()) {
            request.cacheControl(CacheControl.FORCE_NETWORK);
        } else {
            request.cacheControl(CACHE_CONTROL_FORCE_NETWORK_NO_CACHE);
        }
        return request.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object executeNetworkRequest(Request request, Continuation<? super Response> continuation) throws IOException {
        C25941 c25941;
        Object objAwait;
        Response response;
        if (continuation instanceof C25941) {
            c25941 = (C25941) continuation;
            if ((c25941.label & Integer.MIN_VALUE) != 0) {
                c25941.label -= Integer.MIN_VALUE;
            } else {
                c25941 = new C25941(continuation);
            }
        } else {
            c25941 = new C25941(continuation);
        }
        C25941 c25942 = c25941;
        Object $result = c25942.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c25942.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (Utils.isMainThread()) {
                    if (this.options.getNetworkCachePolicy().getReadEnabled()) {
                        throw new NetworkOnMainThreadException();
                    }
                    response = this.callFactory.getValue().newCall(request).execute();
                } else {
                    Call callNewCall = this.callFactory.getValue().newCall(request);
                    c25942.label = 1;
                    objAwait = Calls.await(callNewCall, c25942);
                    if (objAwait == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    response = (Response) objAwait;
                }
                if (response.getIsSuccessful() && response.code() != 304) {
                    ResponseBody responseBodyBody = response.body();
                    if (responseBodyBody != null) {
                        Utils.closeQuietly(responseBodyBody);
                    }
                    throw new HttpException(response);
                }
                return response;
            case 1:
                ResultKt.throwOnFailure($result);
                objAwait = $result;
                response = (Response) objAwait;
                if (response.getIsSuccessful()) {
                    break;
                }
                return response;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final String getMimeType$coil_base_release(String url, MediaType contentType) {
        String it;
        String rawContentType = contentType != null ? contentType.toString() : null;
        if ((rawContentType == null || StringsKt.startsWith$default(rawContentType, MIME_TYPE_TEXT_PLAIN, false, 2, (Object) null)) && (it = Utils.getMimeTypeFromUrl(MimeTypeMap.getSingleton(), url)) != null) {
            return it;
        }
        if (rawContentType != null) {
            return StringsKt.substringBefore$default(rawContentType, ';', (String) null, 2, (Object) null);
        }
        return null;
    }

    private final boolean isCacheable(Request request, Response response) {
        return this.options.getDiskCachePolicy().getWriteEnabled() && (!this.respectCacheHeaders || CacheStrategy.INSTANCE.isCacheable(request, response));
    }

    private final CacheResponse toCacheResponse(DiskCache.Snapshot $this$toCacheResponse) throws Throwable {
        try {
            FileSystem this_$iv = getFileSystem();
            Path file$iv = $this$toCacheResponse.getMetadata();
            Closeable $this$use$iv$iv = Okio.buffer(this_$iv.source(file$iv));
            CacheResponse cacheResponse = null;
            Throwable thrown$iv$iv = null;
            try {
                BufferedSource it$iv = (BufferedSource) $this$use$iv$iv;
                cacheResponse = new CacheResponse(it$iv);
                if ($this$use$iv$iv != null) {
                    try {
                        $this$use$iv$iv.close();
                    } catch (Throwable t$iv$iv) {
                        thrown$iv$iv = t$iv$iv;
                    }
                }
            } catch (Throwable t$iv$iv2) {
                thrown$iv$iv = t$iv$iv2;
                if ($this$use$iv$iv != null) {
                    try {
                        $this$use$iv$iv.close();
                    } catch (Throwable t$iv$iv3) {
                        ExceptionsKt.addSuppressed(thrown$iv$iv, t$iv$iv3);
                    }
                }
            }
            if (thrown$iv$iv != null) {
                throw thrown$iv$iv;
            }
            Intrinsics.checkNotNull(cacheResponse);
            return cacheResponse;
        } catch (IOException e) {
            return null;
        }
    }

    private final ImageSource toImageSource(DiskCache.Snapshot $this$toImageSource) {
        return ImageSources.create($this$toImageSource.getData(), getFileSystem(), getDiskCacheKey(), $this$toImageSource);
    }

    private final ImageSource toImageSource(ResponseBody $this$toImageSource) {
        return ImageSources.create($this$toImageSource.getSource(), this.options.getContext());
    }

    private final DataSource toDataSource(Response $this$toDataSource) {
        return $this$toDataSource.networkResponse() != null ? DataSource.NETWORK : DataSource.DISK;
    }

    private final String getDiskCacheKey() {
        String diskCacheKey = this.options.getDiskCacheKey();
        return diskCacheKey == null ? this.url : diskCacheKey;
    }

    private final FileSystem getFileSystem() {
        DiskCache value = this.diskCache.getValue();
        Intrinsics.checkNotNull(value);
        return value.getFileSystem();
    }

    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    @Metadata(m194d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m195d2 = {"Lcoil/fetch/HttpUriFetcher$Factory;", "Lcoil/fetch/Fetcher$Factory;", "Landroid/net/Uri;", "callFactory", "Lkotlin/Lazy;", "Lokhttp3/Call$Factory;", "diskCache", "Lcoil/disk/DiskCache;", "respectCacheHeaders", "", "(Lkotlin/Lazy;Lkotlin/Lazy;Z)V", "create", "Lcoil/fetch/Fetcher;", "data", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "isApplicable", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Factory implements Fetcher.Factory<Uri> {
        private final Lazy<Call.Factory> callFactory;
        private final Lazy<DiskCache> diskCache;
        private final boolean respectCacheHeaders;

        /* JADX WARN: Multi-variable type inference failed */
        public Factory(Lazy<? extends Call.Factory> lazy, Lazy<? extends DiskCache> lazy2, boolean respectCacheHeaders) {
            this.callFactory = lazy;
            this.diskCache = lazy2;
            this.respectCacheHeaders = respectCacheHeaders;
        }

        @Override // coil.fetch.Fetcher.Factory
        public Fetcher create(Uri data, Options options, ImageLoader imageLoader) {
            if (isApplicable(data)) {
                return new HttpUriFetcher(data.toString(), options, this.callFactory, this.diskCache, this.respectCacheHeaders);
            }
            return null;
        }

        private final boolean isApplicable(Uri data) {
            return Intrinsics.areEqual(data.getScheme(), "http") || Intrinsics.areEqual(data.getScheme(), "https");
        }
    }
}
