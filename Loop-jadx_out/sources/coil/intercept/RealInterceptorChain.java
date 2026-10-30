package coil.intercept;

import androidx.constraintlayout.widget.ConstraintLayout;
import coil.EventListener;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.NullRequestData;
import coil.size.Size;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: RealInterceptorChain.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J&\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0002J\u0019\u0010!\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010%\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0019R\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, m195d2 = {"Lcoil/intercept/RealInterceptorChain;", "Lcoil/intercept/Interceptor$Chain;", "initialRequest", "Lcoil/request/ImageRequest;", "interceptors", "", "Lcoil/intercept/Interceptor;", "index", "", "request", "size", "Lcoil/size/Size;", "eventListener", "Lcoil/EventListener;", "isPlaceholderCached", "", "(Lcoil/request/ImageRequest;Ljava/util/List;ILcoil/request/ImageRequest;Lcoil/size/Size;Lcoil/EventListener;Z)V", "getEventListener", "()Lcoil/EventListener;", "getIndex", "()I", "getInitialRequest", "()Lcoil/request/ImageRequest;", "getInterceptors", "()Ljava/util/List;", "()Z", "getRequest", "getSize", "()Lcoil/size/Size;", "checkRequest", "", "interceptor", "copy", "proceed", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withRequest", "withSize", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class RealInterceptorChain implements Interceptor.Chain {
    private final EventListener eventListener;
    private final int index;
    private final ImageRequest initialRequest;
    private final List<Interceptor> interceptors;
    private final boolean isPlaceholderCached;
    private final ImageRequest request;
    private final Size size;

    /* JADX INFO: renamed from: coil.intercept.RealInterceptorChain$proceed$1 */
    /* JADX INFO: compiled from: RealInterceptorChain.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "coil.intercept.RealInterceptorChain", m210f = "RealInterceptorChain.kt", m211i = {0, 0}, m212l = {32}, m213m = "proceed", m214n = {"this", "interceptor"}, m215s = {"L$0", "L$1"})
    static final class C26011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C26011(Continuation<? super C26011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RealInterceptorChain.this.proceed(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(ImageRequest initialRequest, List<? extends Interceptor> list, int index, ImageRequest request, Size size, EventListener eventListener, boolean isPlaceholderCached) {
        this.initialRequest = initialRequest;
        this.interceptors = list;
        this.index = index;
        this.request = request;
        this.size = size;
        this.eventListener = eventListener;
        this.isPlaceholderCached = isPlaceholderCached;
    }

    public final ImageRequest getInitialRequest() {
        return this.initialRequest;
    }

    public final List<Interceptor> getInterceptors() {
        return this.interceptors;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // coil.intercept.Interceptor.Chain
    public ImageRequest getRequest() {
        return this.request;
    }

    @Override // coil.intercept.Interceptor.Chain
    public Size getSize() {
        return this.size;
    }

    public final EventListener getEventListener() {
        return this.eventListener;
    }

    /* JADX INFO: renamed from: isPlaceholderCached, reason: from getter */
    public final boolean getIsPlaceholderCached() {
        return this.isPlaceholderCached;
    }

    @Override // coil.intercept.Interceptor.Chain
    public Interceptor.Chain withRequest(ImageRequest request) {
        if (this.index > 0) {
            checkRequest(request, this.interceptors.get(this.index - 1));
        }
        return copy$default(this, 0, request, null, 5, null);
    }

    @Override // coil.intercept.Interceptor.Chain
    public Interceptor.Chain withSize(Size size) {
        return copy$default(this, 0, null, size, 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // coil.intercept.Interceptor.Chain
    public Object proceed(ImageRequest request, Continuation<? super ImageResult> continuation) {
        C26011 c26011;
        Interceptor interceptor;
        Object objIntercept;
        RealInterceptorChain realInterceptorChain;
        if (continuation instanceof C26011) {
            c26011 = (C26011) continuation;
            if ((c26011.label & Integer.MIN_VALUE) != 0) {
                c26011.label -= Integer.MIN_VALUE;
            } else {
                c26011 = new C26011(continuation);
            }
        } else {
            c26011 = new C26011(continuation);
        }
        C26011 c26012 = c26011;
        Object $result = c26012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c26012.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.index > 0) {
                    checkRequest(request, this.interceptors.get(this.index - 1));
                }
                interceptor = this.interceptors.get(this.index);
                RealInterceptorChain next = copy$default(this, this.index + 1, request, null, 4, null);
                c26012.L$0 = this;
                c26012.L$1 = interceptor;
                c26012.label = 1;
                objIntercept = interceptor.intercept(next, c26012);
                if (objIntercept == coroutine_suspended) {
                    return coroutine_suspended;
                }
                realInterceptorChain = this;
                break;
                break;
            case 1:
                Interceptor interceptor2 = (Interceptor) c26012.L$1;
                realInterceptorChain = (RealInterceptorChain) c26012.L$0;
                ResultKt.throwOnFailure($result);
                interceptor = interceptor2;
                objIntercept = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ImageResult result = (ImageResult) objIntercept;
        realInterceptorChain.checkRequest(result.getRequest(), interceptor);
        return result;
    }

    private final void checkRequest(ImageRequest request, Interceptor interceptor) {
        if (!(request.getContext() == this.initialRequest.getContext())) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's context.").toString());
        }
        if (!(request.getData() != NullRequestData.INSTANCE)) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot set the request's data to null.").toString());
        }
        if (!(request.getTarget() == this.initialRequest.getTarget())) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's target.").toString());
        }
        if (!(request.getLifecycle() == this.initialRequest.getLifecycle())) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's lifecycle.").toString());
        }
        if (!(request.getSizeResolver() == this.initialRequest.getSizeResolver())) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
        }
    }

    static /* synthetic */ RealInterceptorChain copy$default(RealInterceptorChain realInterceptorChain, int i, ImageRequest imageRequest, Size size, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = realInterceptorChain.index;
        }
        if ((i2 & 2) != 0) {
            imageRequest = realInterceptorChain.getRequest();
        }
        if ((i2 & 4) != 0) {
            size = realInterceptorChain.getSize();
        }
        return realInterceptorChain.copy(i, imageRequest, size);
    }

    private final RealInterceptorChain copy(int index, ImageRequest request, Size size) {
        return new RealInterceptorChain(this.initialRequest, this.interceptors, index, request, size, this.eventListener, this.isPlaceholderCached);
    }
}
