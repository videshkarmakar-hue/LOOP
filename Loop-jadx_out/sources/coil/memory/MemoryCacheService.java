package coil.memory;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.EventListener;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.DecodeUtils;
import coil.intercept.EngineInterceptor;
import coil.intercept.Interceptor;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import coil.transform.Transformation;
import coil.util.Bitmaps;
import coil.util.Logger;
import coil.util.Requests;
import coil.util.Utils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MemoryCacheService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J5\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\b\u001cJ0\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010\u001e\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J&\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000bJ \u0010(\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010¨\u0006,"}, m195d2 = {"Lcoil/memory/MemoryCacheService;", "", "imageLoader", "Lcoil/ImageLoader;", "requestService", "Lcoil/request/RequestService;", "logger", "Lcoil/util/Logger;", "(Lcoil/ImageLoader;Lcoil/request/RequestService;Lcoil/util/Logger;)V", "diskCacheKey", "", "Lcoil/memory/MemoryCache$Value;", "getDiskCacheKey", "(Lcoil/memory/MemoryCache$Value;)Ljava/lang/String;", "isSampled", "", "(Lcoil/memory/MemoryCache$Value;)Z", "getCacheValue", "request", "Lcoil/request/ImageRequest;", "cacheKey", "Lcoil/memory/MemoryCache$Key;", "size", "Lcoil/size/Size;", "scale", "Lcoil/size/Scale;", "isCacheValueValid", "cacheValue", "isCacheValueValid$coil_base_release", "isSizeValid", "newCacheKey", "mappedData", "options", "Lcoil/request/Options;", "eventListener", "Lcoil/EventListener;", "newResult", "Lcoil/request/SuccessResult;", "chain", "Lcoil/intercept/Interceptor$Chain;", "setCacheValue", "result", "Lcoil/intercept/EngineInterceptor$ExecuteResult;", "Companion", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MemoryCacheService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_DISK_CACHE_KEY = "coil#disk_cache_key";
    public static final String EXTRA_IS_SAMPLED = "coil#is_sampled";
    public static final String EXTRA_TRANSFORMATION_INDEX = "coil#transformation_";
    public static final String EXTRA_TRANSFORMATION_SIZE = "coil#transformation_size";
    private static final String TAG = "MemoryCacheService";
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final RequestService requestService;

    public MemoryCacheService(ImageLoader imageLoader, RequestService requestService, Logger logger) {
        this.imageLoader = imageLoader;
        this.requestService = requestService;
        this.logger = logger;
    }

    public final MemoryCache.Key newCacheKey(ImageRequest request, Object mappedData, Options options, EventListener eventListener) {
        MemoryCache.Key it = request.getMemoryCacheKey();
        if (it != null) {
            return it;
        }
        eventListener.keyStart(request, mappedData);
        String base = this.imageLoader.getComponents().key(mappedData, options);
        eventListener.keyEnd(request, base);
        if (base == null) {
            return null;
        }
        List<Transformation> transformations = request.getTransformations();
        Map<String, String> mapMemoryCacheKeys = request.getParameters().memoryCacheKeys();
        if (transformations.isEmpty() && mapMemoryCacheKeys.isEmpty()) {
            return new MemoryCache.Key(base, null, 2, null);
        }
        Map extras = MapsKt.toMutableMap(mapMemoryCacheKeys);
        if (!transformations.isEmpty()) {
            List<Transformation> transformations2 = request.getTransformations();
            int size = transformations2.size();
            for (int i$iv = 0; i$iv < size; i$iv++) {
                Transformation transformation = transformations2.get(i$iv);
                int index = i$iv;
                extras.put(EXTRA_TRANSFORMATION_INDEX + index, transformation.getCacheKey());
            }
            extras.put(EXTRA_TRANSFORMATION_SIZE, options.getSize().toString());
        }
        return new MemoryCache.Key(base, extras);
    }

    public final MemoryCache.Value getCacheValue(ImageRequest request, MemoryCache.Key cacheKey, Size size, Scale scale) {
        if (!request.getMemoryCachePolicy().getReadEnabled()) {
            return null;
        }
        MemoryCache memoryCache = this.imageLoader.getMemoryCache();
        MemoryCache.Value cacheValue = memoryCache != null ? memoryCache.get(cacheKey) : null;
        if (cacheValue == null) {
            return null;
        }
        MemoryCache.Value it = cacheValue;
        if (isCacheValueValid$coil_base_release(request, cacheKey, it, size, scale)) {
            return cacheValue;
        }
        return null;
    }

    public final boolean isCacheValueValid$coil_base_release(ImageRequest request, MemoryCache.Key cacheKey, MemoryCache.Value cacheValue, Size size, Scale scale) {
        if (!this.requestService.isConfigValidForHardware(request, Bitmaps.getSafeConfig(cacheValue.getBitmap()))) {
            Logger $this$log$iv = this.logger;
            if ($this$log$iv == null || $this$log$iv.getLevel() > 3) {
                return false;
            }
            $this$log$iv.log(TAG, 3, request.getData() + ": Cached bitmap is hardware-backed, which is incompatible with the request.", null);
            return false;
        }
        return isSizeValid(request, cacheKey, cacheValue, size, scale);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:75:0x0200  */
    private final boolean isSizeValid(ImageRequest request, MemoryCache.Key cacheKey, MemoryCache.Value cacheValue, Size size, Scale scale) {
        boolean isSampled;
        int srcWidth;
        boolean isSampled2 = isSampled(cacheValue);
        if (Sizes.isOriginal(size)) {
            if (!isSampled2) {
                return true;
            }
            Logger $this$log$iv = this.logger;
            if ($this$log$iv != null && $this$log$iv.getLevel() <= 3) {
                $this$log$iv.log(TAG, 3, request.getData() + ": Requested original size, but cached image is sampled.", null);
            }
            return false;
        }
        String transformationSize = cacheKey.getExtras().get(EXTRA_TRANSFORMATION_SIZE);
        if (transformationSize != null) {
            return Intrinsics.areEqual(transformationSize, size.toString());
        }
        int srcWidth2 = cacheValue.getBitmap().getWidth();
        int srcHeight = cacheValue.getBitmap().getHeight();
        Dimension $this$pxOrElse$iv = size.getWidth();
        int i = Integer.MAX_VALUE;
        int dstWidth = $this$pxOrElse$iv instanceof Dimension.Pixels ? ((Dimension.Pixels) $this$pxOrElse$iv).px : Integer.MAX_VALUE;
        Dimension $this$pxOrElse$iv2 = size.getHeight();
        if ($this$pxOrElse$iv2 instanceof Dimension.Pixels) {
            i = ((Dimension.Pixels) $this$pxOrElse$iv2).px;
        }
        int dstHeight = i;
        double multiplier = DecodeUtils.computeSizeMultiplier(srcWidth2, srcHeight, dstWidth, dstHeight, scale);
        boolean allowInexactSize = Requests.getAllowInexactSize(request);
        if (allowInexactSize) {
            double downsampleMultiplier = RangesKt.coerceAtMost(multiplier, 1.0d);
            isSampled = isSampled2;
            if (Math.abs(((double) dstWidth) - (((double) srcWidth2) * downsampleMultiplier)) <= 1.0d) {
                return true;
            }
            srcWidth = srcWidth2;
            if (Math.abs(((double) dstHeight) - (((double) srcHeight) * downsampleMultiplier)) <= 1.0d) {
                return true;
            }
        } else {
            isSampled = isSampled2;
            srcWidth = srcWidth2;
            if (Utils.isMinOrMax(dstWidth)) {
                if (Utils.isMinOrMax(dstHeight)) {
                    return true;
                }
                if (Math.abs(dstHeight - srcHeight) <= 1) {
                    return true;
                }
            } else if (Math.abs(dstWidth - srcWidth) <= 1) {
                if (Utils.isMinOrMax(dstHeight)) {
                    return true;
                }
                if (Math.abs(dstHeight - srcHeight) <= 1) {
                    return true;
                }
            }
        }
        if (!(multiplier == 1.0d) && !allowInexactSize) {
            Logger $this$log$iv2 = this.logger;
            if ($this$log$iv2 != null && $this$log$iv2.getLevel() <= 3) {
                $this$log$iv2.log(TAG, 3, request.getData() + ": Cached image's request size (" + srcWidth + ", " + srcHeight + ") does not exactly match the requested size (" + size.getWidth() + ", " + size.getHeight() + ", " + scale + ").", null);
                return false;
            }
            return false;
        }
        int dstWidth2 = srcWidth;
        if (multiplier <= 1.0d || !isSampled) {
            return true;
        }
        Logger $this$log$iv3 = this.logger;
        if ($this$log$iv3 != null && $this$log$iv3.getLevel() <= 3) {
            $this$log$iv3.log(TAG, 3, request.getData() + ": Cached image's request size (" + dstWidth2 + ", " + srcHeight + ") is smaller than the requested size (" + size.getWidth() + ", " + size.getHeight() + ", " + scale + ").", null);
            return false;
        }
        return false;
    }

    public final boolean setCacheValue(MemoryCache.Key cacheKey, ImageRequest request, EngineInterceptor.ExecuteResult result) {
        MemoryCache memoryCache;
        Bitmap bitmap;
        if (!request.getMemoryCachePolicy().getWriteEnabled() || (memoryCache = this.imageLoader.getMemoryCache()) == null || cacheKey == null) {
            return false;
        }
        Drawable drawable = result.getDrawable();
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        if (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) {
            return false;
        }
        Map extras = new LinkedHashMap();
        extras.put(EXTRA_IS_SAMPLED, Boolean.valueOf(result.getIsSampled()));
        String it = result.getDiskCacheKey();
        if (it != null) {
            extras.put(EXTRA_DISK_CACHE_KEY, it);
        }
        memoryCache.set(cacheKey, new MemoryCache.Value(bitmap, extras));
        return true;
    }

    public final SuccessResult newResult(Interceptor.Chain chain, ImageRequest request, MemoryCache.Key cacheKey, MemoryCache.Value cacheValue) {
        Bitmap $this$toDrawable$iv = cacheValue.getBitmap();
        Context context$iv = request.getContext();
        Resources resources$iv$iv = context$iv.getResources();
        return new SuccessResult(new BitmapDrawable(resources$iv$iv, $this$toDrawable$iv), request, DataSource.MEMORY_CACHE, cacheKey, getDiskCacheKey(cacheValue), isSampled(cacheValue), Utils.isPlaceholderCached(chain));
    }

    private final boolean isSampled(MemoryCache.Value $this$isSampled) {
        Object obj = $this$isSampled.getExtras().get(EXTRA_IS_SAMPLED);
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final String getDiskCacheKey(MemoryCache.Value $this$diskCacheKey) {
        Object obj = $this$diskCacheKey.getExtras().get(EXTRA_DISK_CACHE_KEY);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    /* JADX INFO: compiled from: MemoryCacheService.kt */
    @Metadata(m194d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002R\u0016\u0010\n\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m195d2 = {"Lcoil/memory/MemoryCacheService$Companion;", "", "()V", "EXTRA_DISK_CACHE_KEY", "", "getEXTRA_DISK_CACHE_KEY$coil_base_release$annotations", "EXTRA_IS_SAMPLED", "getEXTRA_IS_SAMPLED$coil_base_release$annotations", "EXTRA_TRANSFORMATION_INDEX", "getEXTRA_TRANSFORMATION_INDEX$coil_base_release$annotations", "EXTRA_TRANSFORMATION_SIZE", "getEXTRA_TRANSFORMATION_SIZE$coil_base_release$annotations", "TAG", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getEXTRA_DISK_CACHE_KEY$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getEXTRA_IS_SAMPLED$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getEXTRA_TRANSFORMATION_INDEX$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getEXTRA_TRANSFORMATION_SIZE$coil_base_release$annotations() {
        }

        private Companion() {
        }
    }
}
