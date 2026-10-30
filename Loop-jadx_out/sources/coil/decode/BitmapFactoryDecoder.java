package coil.decode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.ImageLoader;
import coil.fetch.SourceResult;
import coil.request.Options;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import coil.util.Bitmaps;
import coil.util.Utils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.p007io.CloseableKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.InterruptibleKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: compiled from: BitmapFactoryDecoder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0003\u0016\u0017\u0018B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0014\u0010\u0015\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\f\u0010\r\u001a\u00020\u000e*\u00020\u0012H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, m195d2 = {"Lcoil/decode/BitmapFactoryDecoder;", "Lcoil/decode/Decoder;", "source", "Lcoil/decode/ImageSource;", "options", "Lcoil/request/Options;", "(Lcoil/decode/ImageSource;Lcoil/request/Options;)V", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "(Lcoil/decode/ImageSource;Lcoil/request/Options;Lkotlinx/coroutines/sync/Semaphore;)V", "exifOrientationPolicy", "Lcoil/decode/ExifOrientationPolicy;", "(Lcoil/decode/ImageSource;Lcoil/request/Options;Lkotlinx/coroutines/sync/Semaphore;Lcoil/decode/ExifOrientationPolicy;)V", "decode", "Lcoil/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureConfig", "", "Landroid/graphics/BitmapFactory$Options;", "exifData", "Lcoil/decode/ExifData;", "configureScale", "Companion", "ExceptionCatchingSource", "Factory", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BitmapFactoryDecoder implements Decoder {
    public static final int DEFAULT_MAX_PARALLELISM = 4;
    private final ExifOrientationPolicy exifOrientationPolicy;
    private final Options options;
    private final Semaphore parallelismLock;
    private final ImageSource source;

    /* JADX INFO: renamed from: coil.decode.BitmapFactoryDecoder$decode$1 */
    /* JADX INFO: compiled from: BitmapFactoryDecoder.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "coil.decode.BitmapFactoryDecoder", m210f = "BitmapFactoryDecoder.kt", m211i = {0, 0, 1}, m212l = {232, 46}, m213m = "decode", m214n = {"this", "$this$withPermit$iv", "$this$withPermit$iv"}, m215s = {"L$0", "L$1", "L$0"})
    static final class C25921 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C25921(Continuation<? super C25921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BitmapFactoryDecoder.this.decode(this);
        }
    }

    public BitmapFactoryDecoder(ImageSource source, Options options, Semaphore parallelismLock, ExifOrientationPolicy exifOrientationPolicy) {
        this.source = source;
        this.options = options;
        this.parallelismLock = parallelismLock;
        this.exifOrientationPolicy = exifOrientationPolicy;
    }

    public /* synthetic */ BitmapFactoryDecoder(ImageSource imageSource, Options options, Semaphore semaphore, ExifOrientationPolicy exifOrientationPolicy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, options, (i & 4) != 0 ? SemaphoreKt.Semaphore$default(Integer.MAX_VALUE, 0, 2, null) : semaphore, (i & 8) != 0 ? ExifOrientationPolicy.RESPECT_PERFORMANCE : exifOrientationPolicy);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    public /* synthetic */ BitmapFactoryDecoder(ImageSource source, Options options) {
        this(source, options, null, null, 12, null);
    }

    public /* synthetic */ BitmapFactoryDecoder(ImageSource imageSource, Options options, Semaphore semaphore, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, options, (i & 4) != 0 ? SemaphoreKt.Semaphore$default(Integer.MAX_VALUE, 0, 2, null) : semaphore);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    public /* synthetic */ BitmapFactoryDecoder(ImageSource source, Options options, Semaphore parallelismLock) {
        this(source, options, parallelismLock, null, 8, null);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0079 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x007a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // coil.decode.Decoder
    public Object decode(Continuation<? super DecodeResult> continuation) throws Throwable {
        C25921 c25921;
        final BitmapFactoryDecoder bitmapFactoryDecoder;
        Semaphore $this$withPermit$iv;
        Semaphore $this$withPermit$iv2;
        Semaphore $this$withPermit$iv3;
        Throwable th;
        Object objRunInterruptible$default;
        if (continuation instanceof C25921) {
            c25921 = (C25921) continuation;
            if ((c25921.label & Integer.MIN_VALUE) != 0) {
                c25921.label -= Integer.MIN_VALUE;
            } else {
                c25921 = new C25921(continuation);
            }
        } else {
            c25921 = new C25921(continuation);
        }
        C25921 c25922 = c25921;
        Object $result = c25922.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c25922.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                bitmapFactoryDecoder = this;
                Semaphore $this$withPermit$iv4 = bitmapFactoryDecoder.parallelismLock;
                c25922.L$0 = bitmapFactoryDecoder;
                c25922.L$1 = $this$withPermit$iv4;
                c25922.label = 1;
                if ($this$withPermit$iv4.acquire(c25922) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$withPermit$iv = $this$withPermit$iv4;
                $this$withPermit$iv2 = null;
                try {
                    Function0<DecodeResult> function0 = new Function0<DecodeResult>() { // from class: coil.decode.BitmapFactoryDecoder$decode$2$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final DecodeResult invoke() {
                            return this.this$0.decode(new BitmapFactory.Options());
                        }
                    };
                    c25922.L$0 = $this$withPermit$iv;
                    c25922.L$1 = null;
                    c25922.label = 2;
                    objRunInterruptible$default = InterruptibleKt.runInterruptible$default(null, function0, c25922, 1, null);
                    if (objRunInterruptible$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    try {
                        DecodeResult decodeResult = (DecodeResult) objRunInterruptible$default;
                        $this$withPermit$iv.release();
                        return decodeResult;
                    } catch (Throwable th2) {
                        th = th2;
                        $this$withPermit$iv3 = $this$withPermit$iv;
                        $this$withPermit$iv3.release();
                        throw th;
                    }
                } catch (Throwable th3) {
                    $this$withPermit$iv3 = $this$withPermit$iv;
                    th = th3;
                    $this$withPermit$iv3.release();
                    throw th;
                }
            case 1:
                $this$withPermit$iv2 = null;
                $this$withPermit$iv = (Semaphore) c25922.L$1;
                bitmapFactoryDecoder = (BitmapFactoryDecoder) c25922.L$0;
                ResultKt.throwOnFailure($result);
                Function0<DecodeResult> function1 = new Function0<DecodeResult>() { // from class: coil.decode.BitmapFactoryDecoder$decode$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final DecodeResult invoke() {
                        return this.this$0.decode(new BitmapFactory.Options());
                    }
                };
                c25922.L$0 = $this$withPermit$iv;
                c25922.L$1 = null;
                c25922.label = 2;
                objRunInterruptible$default = InterruptibleKt.runInterruptible$default(null, function1, c25922, 1, null);
                if (objRunInterruptible$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                DecodeResult decodeResult2 = (DecodeResult) objRunInterruptible$default;
                $this$withPermit$iv.release();
                return decodeResult2;
            case 2:
                $this$withPermit$iv3 = (Semaphore) c25922.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    $this$withPermit$iv = $this$withPermit$iv3;
                    objRunInterruptible$default = $result;
                    DecodeResult decodeResult3 = (DecodeResult) objRunInterruptible$default;
                    $this$withPermit$iv.release();
                    return decodeResult3;
                } catch (Throwable th4) {
                    th = th4;
                    $this$withPermit$iv3.release();
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DecodeResult decode(BitmapFactory.Options $this$decode) throws Exception {
        ExceptionCatchingSource safeSource = new ExceptionCatchingSource(this.source.source());
        BufferedSource safeBufferedSource = Okio.buffer(safeSource);
        boolean z = true;
        $this$decode.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(safeBufferedSource.peek().inputStream(), null, $this$decode);
        Exception exception = safeSource.getException();
        if (exception != null) {
            throw exception;
        }
        $this$decode.inJustDecodeBounds = false;
        ExifData exifData = ExifUtils.INSTANCE.getExifData($this$decode.outMimeType, safeBufferedSource, this.exifOrientationPolicy);
        Exception it = safeSource.getException();
        if (it != null) {
            throw it;
        }
        $this$decode.inMutable = false;
        if (Build.VERSION.SDK_INT >= 26 && this.options.getColorSpace() != null) {
            $this$decode.inPreferredColorSpace = this.options.getColorSpace();
        }
        $this$decode.inPremultiplied = this.options.getPremultipliedAlpha();
        configureConfig($this$decode, exifData);
        configureScale($this$decode, exifData);
        BufferedSource it2 = safeBufferedSource;
        try {
            Bitmap outBitmap = BitmapFactory.decodeStream(it2.inputStream(), null, $this$decode);
            CloseableKt.closeFinally(it2, null);
            Exception it3 = safeSource.getException();
            if (it3 != null) {
                throw it3;
            }
            if (outBitmap == null) {
                throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format.".toString());
            }
            outBitmap.setDensity(this.options.getContext().getResources().getDisplayMetrics().densityDpi);
            Bitmap bitmap = ExifUtils.INSTANCE.reverseTransformations(outBitmap, exifData);
            Context context$iv = this.options.getContext();
            Resources resources$iv$iv = context$iv.getResources();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resources$iv$iv, bitmap);
            if ($this$decode.inSampleSize <= 1 && !$this$decode.inScaled) {
                z = false;
            }
            return new DecodeResult(bitmapDrawable, z);
        } catch (Throwable it4) {
            try {
                throw it4;
            } catch (Throwable th) {
                CloseableKt.closeFinally(it2, it4);
                throw th;
            }
        }
    }

    private final void configureConfig(BitmapFactory.Options $this$configureConfig, ExifData exifData) {
        Bitmap.Config config = this.options.getConfig();
        if (exifData.getIsFlipped() || ExifUtilsKt.isRotated(exifData)) {
            config = Bitmaps.toSoftware(config);
        }
        if (this.options.getAllowRgb565() && config == Bitmap.Config.ARGB_8888 && Intrinsics.areEqual($this$configureConfig.outMimeType, Utils.MIME_TYPE_JPEG)) {
            config = Bitmap.Config.RGB_565;
        }
        if (Build.VERSION.SDK_INT >= 26 && $this$configureConfig.outConfig == Bitmap.Config.RGBA_F16 && config != Bitmap.Config.HARDWARE) {
            config = Bitmap.Config.RGBA_F16;
        }
        $this$configureConfig.inPreferredConfig = config;
    }

    private final void configureScale(BitmapFactory.Options $this$configureScale, ExifData exifData) {
        ImageSource.Metadata metadata = this.source.getMetadata();
        if ((metadata instanceof ResourceMetadata) && Sizes.isOriginal(this.options.getSize())) {
            $this$configureScale.inSampleSize = 1;
            $this$configureScale.inScaled = true;
            $this$configureScale.inDensity = ((ResourceMetadata) metadata).getDensity();
            $this$configureScale.inTargetDensity = this.options.getContext().getResources().getDisplayMetrics().densityDpi;
            return;
        }
        if ($this$configureScale.outWidth <= 0 || $this$configureScale.outHeight <= 0) {
            $this$configureScale.inSampleSize = 1;
            $this$configureScale.inScaled = false;
            return;
        }
        int srcWidth = ExifUtilsKt.isSwapped(exifData) ? $this$configureScale.outHeight : $this$configureScale.outWidth;
        int srcHeight = ExifUtilsKt.isSwapped(exifData) ? $this$configureScale.outWidth : $this$configureScale.outHeight;
        Size $this$widthPx$iv = this.options.getSize();
        Scale scale$iv = this.options.getScale();
        int dstWidth = Sizes.isOriginal($this$widthPx$iv) ? srcWidth : Utils.toPx($this$widthPx$iv.getWidth(), scale$iv);
        Size $this$heightPx$iv = this.options.getSize();
        Scale scale$iv2 = this.options.getScale();
        int dstHeight = Sizes.isOriginal($this$heightPx$iv) ? srcHeight : Utils.toPx($this$heightPx$iv.getHeight(), scale$iv2);
        $this$configureScale.inSampleSize = DecodeUtils.calculateInSampleSize(srcWidth, srcHeight, dstWidth, dstHeight, this.options.getScale());
        double scale = DecodeUtils.computeSizeMultiplier(((double) srcWidth) / ((double) $this$configureScale.inSampleSize), ((double) srcHeight) / ((double) $this$configureScale.inSampleSize), dstWidth, dstHeight, this.options.getScale());
        if (this.options.getAllowInexactSize()) {
            scale = RangesKt.coerceAtMost(scale, 1.0d);
        }
        $this$configureScale.inScaled = true ^ (scale == 1.0d);
        if ($this$configureScale.inScaled) {
            if (scale > 1.0d) {
                $this$configureScale.inDensity = MathKt.roundToInt(((double) Integer.MAX_VALUE) / scale);
                $this$configureScale.inTargetDensity = Integer.MAX_VALUE;
            } else {
                $this$configureScale.inDensity = Integer.MAX_VALUE;
                $this$configureScale.inTargetDensity = MathKt.roundToInt(((double) Integer.MAX_VALUE) * scale);
            }
        }
    }

    /* JADX INFO: compiled from: BitmapFactoryDecoder.kt */
    @Metadata(m194d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0017¢\u0006\u0002\u0010\u0002B\u0011\b\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m195d2 = {"Lcoil/decode/BitmapFactoryDecoder$Factory;", "Lcoil/decode/Decoder$Factory;", "()V", "maxParallelism", "", "(I)V", "exifOrientationPolicy", "Lcoil/decode/ExifOrientationPolicy;", "(ILcoil/decode/ExifOrientationPolicy;)V", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "create", "Lcoil/decode/Decoder;", "result", "Lcoil/fetch/SourceResult;", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "equals", "", "other", "", "hashCode", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Factory implements Decoder.Factory {
        private final ExifOrientationPolicy exifOrientationPolicy;
        private final Semaphore parallelismLock;

        public Factory(int maxParallelism, ExifOrientationPolicy exifOrientationPolicy) {
            this.exifOrientationPolicy = exifOrientationPolicy;
            this.parallelismLock = SemaphoreKt.Semaphore$default(maxParallelism, 0, 2, null);
        }

        public /* synthetic */ Factory(int i, ExifOrientationPolicy exifOrientationPolicy, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 4 : i, (i2 & 2) != 0 ? ExifOrientationPolicy.RESPECT_PERFORMANCE : exifOrientationPolicy);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Factory() {
            this(0, null, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
        public /* synthetic */ Factory(int i) {
            this(i, null, 2, 0 == true ? 1 : 0);
        }

        public /* synthetic */ Factory(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 4 : i);
        }

        @Override // coil.decode.Decoder.Factory
        public Decoder create(SourceResult result, Options options, ImageLoader imageLoader) {
            return new BitmapFactoryDecoder(result.getSource(), options, this.parallelismLock, this.exifOrientationPolicy);
        }

        public boolean equals(Object other) {
            return other instanceof Factory;
        }

        public int hashCode() {
            return getClass().hashCode();
        }
    }

    /* JADX INFO: compiled from: BitmapFactoryDecoder.kt */
    @Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016R.\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, m195d2 = {"Lcoil/decode/BitmapFactoryDecoder$ExceptionCatchingSource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "(Lokio/Source;)V", "<set-?>", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "getException", "()Ljava/lang/Exception;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class ExceptionCatchingSource extends ForwardingSource {
        private Exception exception;

        public ExceptionCatchingSource(Source delegate) {
            super(delegate);
        }

        public final Exception getException() {
            return this.exception;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer sink, long byteCount) throws Exception {
            try {
                return super.read(sink, byteCount);
            } catch (Exception e) {
                this.exception = e;
                throw e;
            }
        }
    }
}
