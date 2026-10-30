package coil;

import android.graphics.Bitmap;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.decode.DecodeResult;
import coil.decode.Decoder;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.request.SuccessResult;
import coil.size.Size;
import coil.transition.Transition;
import kotlin.Metadata;

/* JADX INFO: compiled from: EventListener.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 +2\u00020\u0001:\u0002+,J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0017J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017J*\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0010H\u0017J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0017J\u001a\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0017J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0017H\u0017J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u001cH\u0017J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u001fH\u0017J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0017J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020%H\u0017J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020%H\u0017J\u0018\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0017J\u0018\u0010*\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006-À\u0006\u0003"}, m195d2 = {"Lcoil/EventListener;", "Lcoil/request/ImageRequest$Listener;", "decodeEnd", "", "request", "Lcoil/request/ImageRequest;", "decoder", "Lcoil/decode/Decoder;", "options", "Lcoil/request/Options;", "result", "Lcoil/decode/DecodeResult;", "decodeStart", "fetchEnd", "fetcher", "Lcoil/fetch/Fetcher;", "Lcoil/fetch/FetchResult;", "fetchStart", "keyEnd", "output", "", "keyStart", "input", "", "mapEnd", "mapStart", "onCancel", "onError", "Lcoil/request/ErrorResult;", "onStart", "onSuccess", "Lcoil/request/SuccessResult;", "resolveSizeEnd", "size", "Lcoil/size/Size;", "resolveSizeStart", "transformEnd", "Landroid/graphics/Bitmap;", "transformStart", "transitionEnd", "transition", "Lcoil/transition/Transition;", "transitionStart", "Companion", "Factory", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface EventListener extends ImageRequest.Listener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final EventListener NONE = new EventListener() { // from class: coil.EventListener$Companion$NONE$1
        @Override // coil.EventListener
        public /* synthetic */ void decodeEnd(ImageRequest imageRequest, Decoder decoder, Options options, DecodeResult decodeResult) {
            EventListener.CC.$default$decodeEnd(this, imageRequest, decoder, options, decodeResult);
        }

        @Override // coil.EventListener
        public /* synthetic */ void decodeStart(ImageRequest imageRequest, Decoder decoder, Options options) {
            EventListener.CC.$default$decodeStart(this, imageRequest, decoder, options);
        }

        @Override // coil.EventListener
        public /* synthetic */ void fetchEnd(ImageRequest imageRequest, Fetcher fetcher, Options options, FetchResult fetchResult) {
            EventListener.CC.$default$fetchEnd(this, imageRequest, fetcher, options, fetchResult);
        }

        @Override // coil.EventListener
        public /* synthetic */ void fetchStart(ImageRequest imageRequest, Fetcher fetcher, Options options) {
            EventListener.CC.$default$fetchStart(this, imageRequest, fetcher, options);
        }

        @Override // coil.EventListener
        public /* synthetic */ void keyEnd(ImageRequest imageRequest, String str) {
            EventListener.CC.$default$keyEnd(this, imageRequest, str);
        }

        @Override // coil.EventListener
        public /* synthetic */ void keyStart(ImageRequest imageRequest, Object obj) {
            EventListener.CC.$default$keyStart(this, imageRequest, obj);
        }

        @Override // coil.EventListener
        public /* synthetic */ void mapEnd(ImageRequest imageRequest, Object obj) {
            EventListener.CC.$default$mapEnd(this, imageRequest, obj);
        }

        @Override // coil.EventListener
        public /* synthetic */ void mapStart(ImageRequest imageRequest, Object obj) {
            EventListener.CC.$default$mapStart(this, imageRequest, obj);
        }

        @Override // coil.EventListener, coil.request.ImageRequest.Listener
        public /* synthetic */ void onCancel(ImageRequest imageRequest) {
            EventListener.CC.$default$onCancel(this, imageRequest);
        }

        @Override // coil.EventListener, coil.request.ImageRequest.Listener
        public /* synthetic */ void onError(ImageRequest imageRequest, ErrorResult errorResult) {
            EventListener.CC.$default$onError(this, imageRequest, errorResult);
        }

        @Override // coil.EventListener, coil.request.ImageRequest.Listener
        public /* synthetic */ void onStart(ImageRequest imageRequest) {
            EventListener.CC.$default$onStart(this, imageRequest);
        }

        @Override // coil.EventListener, coil.request.ImageRequest.Listener
        public /* synthetic */ void onSuccess(ImageRequest imageRequest, SuccessResult successResult) {
            EventListener.CC.$default$onSuccess(this, imageRequest, successResult);
        }

        @Override // coil.EventListener
        public /* synthetic */ void resolveSizeEnd(ImageRequest imageRequest, Size size) {
            EventListener.CC.$default$resolveSizeEnd(this, imageRequest, size);
        }

        @Override // coil.EventListener
        public /* synthetic */ void resolveSizeStart(ImageRequest imageRequest) {
            EventListener.CC.$default$resolveSizeStart(this, imageRequest);
        }

        @Override // coil.EventListener
        public /* synthetic */ void transformEnd(ImageRequest imageRequest, Bitmap bitmap) {
            EventListener.CC.$default$transformEnd(this, imageRequest, bitmap);
        }

        @Override // coil.EventListener
        public /* synthetic */ void transformStart(ImageRequest imageRequest, Bitmap bitmap) {
            EventListener.CC.$default$transformStart(this, imageRequest, bitmap);
        }

        @Override // coil.EventListener
        public /* synthetic */ void transitionEnd(ImageRequest imageRequest, Transition transition) {
            EventListener.CC.$default$transitionEnd(this, imageRequest, transition);
        }

        @Override // coil.EventListener
        public /* synthetic */ void transitionStart(ImageRequest imageRequest, Transition transition) {
            EventListener.CC.$default$transitionStart(this, imageRequest, transition);
        }
    };

    void decodeEnd(ImageRequest request, Decoder decoder, Options options, DecodeResult result);

    void decodeStart(ImageRequest request, Decoder decoder, Options options);

    void fetchEnd(ImageRequest request, Fetcher fetcher, Options options, FetchResult result);

    void fetchStart(ImageRequest request, Fetcher fetcher, Options options);

    void keyEnd(ImageRequest request, String output);

    void keyStart(ImageRequest request, Object input);

    void mapEnd(ImageRequest request, Object output);

    void mapStart(ImageRequest request, Object input);

    @Override // coil.request.ImageRequest.Listener
    void onCancel(ImageRequest request);

    @Override // coil.request.ImageRequest.Listener
    void onError(ImageRequest request, ErrorResult result);

    @Override // coil.request.ImageRequest.Listener
    void onStart(ImageRequest request);

    @Override // coil.request.ImageRequest.Listener
    void onSuccess(ImageRequest request, SuccessResult result);

    void resolveSizeEnd(ImageRequest request, Size size);

    void resolveSizeStart(ImageRequest request);

    void transformEnd(ImageRequest request, Bitmap output);

    void transformStart(ImageRequest request, Bitmap input);

    void transitionEnd(ImageRequest request, Transition transition);

    void transitionStart(ImageRequest request, Transition transition);

    /* JADX INFO: renamed from: coil.EventListener$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: EventListener.kt */
    public final /* synthetic */ class CC {
        static {
            Companion companion = EventListener.INSTANCE;
        }

        public static void $default$onStart(EventListener _this, ImageRequest request) {
        }

        public static void $default$resolveSizeStart(EventListener _this, ImageRequest request) {
        }

        public static void $default$resolveSizeEnd(EventListener _this, ImageRequest request, Size size) {
        }

        public static void $default$mapStart(EventListener _this, ImageRequest request, Object input) {
        }

        public static void $default$mapEnd(EventListener _this, ImageRequest request, Object output) {
        }

        public static void $default$keyStart(EventListener _this, ImageRequest request, Object input) {
        }

        public static void $default$keyEnd(EventListener _this, ImageRequest request, String output) {
        }

        public static void $default$fetchStart(EventListener _this, ImageRequest request, Fetcher fetcher, Options options) {
        }

        public static void $default$fetchEnd(EventListener _this, ImageRequest request, Fetcher fetcher, Options options, FetchResult result) {
        }

        public static void $default$decodeStart(EventListener _this, ImageRequest request, Decoder decoder, Options options) {
        }

        public static void $default$decodeEnd(EventListener _this, ImageRequest request, Decoder decoder, Options options, DecodeResult result) {
        }

        public static void $default$transformStart(EventListener _this, ImageRequest request, Bitmap input) {
        }

        public static void $default$transformEnd(EventListener _this, ImageRequest request, Bitmap output) {
        }

        public static void $default$transitionStart(EventListener _this, ImageRequest request, Transition transition) {
        }

        public static void $default$transitionEnd(EventListener _this, ImageRequest request, Transition transition) {
        }

        public static void $default$onCancel(EventListener _this, ImageRequest request) {
        }

        public static void $default$onError(EventListener _this, ImageRequest request, ErrorResult result) {
        }

        public static void $default$onSuccess(EventListener _this, ImageRequest request, SuccessResult result) {
        }
    }

    /* JADX INFO: compiled from: EventListener.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        @Deprecated
        public static void onStart(EventListener $this, ImageRequest request) {
            CC.$default$onStart($this, request);
        }

        @Deprecated
        public static void resolveSizeStart(EventListener $this, ImageRequest request) {
            CC.$default$resolveSizeStart($this, request);
        }

        @Deprecated
        public static void resolveSizeEnd(EventListener $this, ImageRequest request, Size size) {
            CC.$default$resolveSizeEnd($this, request, size);
        }

        @Deprecated
        public static void mapStart(EventListener $this, ImageRequest request, Object input) {
            CC.$default$mapStart($this, request, input);
        }

        @Deprecated
        public static void mapEnd(EventListener $this, ImageRequest request, Object output) {
            CC.$default$mapEnd($this, request, output);
        }

        @Deprecated
        public static void keyStart(EventListener $this, ImageRequest request, Object input) {
            CC.$default$keyStart($this, request, input);
        }

        @Deprecated
        public static void keyEnd(EventListener $this, ImageRequest request, String output) {
            CC.$default$keyEnd($this, request, output);
        }

        @Deprecated
        public static void fetchStart(EventListener $this, ImageRequest request, Fetcher fetcher, Options options) {
            CC.$default$fetchStart($this, request, fetcher, options);
        }

        @Deprecated
        public static void fetchEnd(EventListener $this, ImageRequest request, Fetcher fetcher, Options options, FetchResult result) {
            CC.$default$fetchEnd($this, request, fetcher, options, result);
        }

        @Deprecated
        public static void decodeStart(EventListener $this, ImageRequest request, Decoder decoder, Options options) {
            CC.$default$decodeStart($this, request, decoder, options);
        }

        @Deprecated
        public static void decodeEnd(EventListener $this, ImageRequest request, Decoder decoder, Options options, DecodeResult result) {
            CC.$default$decodeEnd($this, request, decoder, options, result);
        }

        @Deprecated
        public static void transformStart(EventListener $this, ImageRequest request, Bitmap input) {
            CC.$default$transformStart($this, request, input);
        }

        @Deprecated
        public static void transformEnd(EventListener $this, ImageRequest request, Bitmap output) {
            CC.$default$transformEnd($this, request, output);
        }

        @Deprecated
        public static void transitionStart(EventListener $this, ImageRequest request, Transition transition) {
            CC.$default$transitionStart($this, request, transition);
        }

        @Deprecated
        public static void transitionEnd(EventListener $this, ImageRequest request, Transition transition) {
            CC.$default$transitionEnd($this, request, transition);
        }

        @Deprecated
        public static void onCancel(EventListener $this, ImageRequest request) {
            CC.$default$onCancel($this, request);
        }

        @Deprecated
        public static void onError(EventListener $this, ImageRequest request, ErrorResult result) {
            CC.$default$onError($this, request, result);
        }

        @Deprecated
        public static void onSuccess(EventListener $this, ImageRequest request, SuccessResult result) {
            CC.$default$onSuccess($this, request, result);
        }
    }

    /* JADX INFO: compiled from: EventListener.kt */
    @Metadata(m194d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, m195d2 = {"Lcoil/EventListener$Factory;", "", "create", "Lcoil/EventListener;", "request", "Lcoil/request/ImageRequest;", "Companion", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public interface Factory {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final Factory NONE = new Factory() { // from class: coil.EventListener$Factory$$ExternalSyntheticLambda0
            @Override // coil.EventListener.Factory
            public final EventListener create(ImageRequest imageRequest) {
                return EventListener.NONE;
            }
        };

        EventListener create(ImageRequest request);

        /* JADX INFO: compiled from: EventListener.kt */
        @Metadata(m194d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0005"}, m195d2 = {"Lcoil/EventListener$Factory$Companion;", "", "()V", "NONE", "Lcoil/EventListener$Factory;", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }
        }

        /* JADX INFO: renamed from: coil.EventListener$Factory$-CC, reason: invalid class name */
        /* JADX INFO: compiled from: EventListener.kt */
        public final /* synthetic */ class CC {
            static {
                Companion companion = Factory.INSTANCE;
            }
        }
    }

    /* JADX INFO: compiled from: EventListener.kt */
    @Metadata(m194d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0005"}, m195d2 = {"Lcoil/EventListener$Companion;", "", "()V", "NONE", "Lcoil/EventListener;", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
