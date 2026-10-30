package coil.compose;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.p001ui.graphics.ColorFilter;
import androidx.compose.p001ui.graphics.FilterQuality;
import androidx.compose.p001ui.graphics.ImageBitmap;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.painter.BitmapPainterKt;
import androidx.compose.p001ui.graphics.painter.Painter;
import androidx.compose.p001ui.layout.ContentScale;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import coil.ImageLoader;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import coil.size.Precision;
import coil.size.SizeResolver;
import coil.target.Target;
import coil.transition.CrossfadeTransition;
import coil.transition.Transition;
import com.google.accompanist.drawablepainter.DrawablePainter;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: AsyncImagePainter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0002mnB\u0017\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010Z\u001a\u00020:2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010[\u001a\u00020:2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\\\u001a\u00020AH\u0002J\u001a\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020\f2\u0006\u0010`\u001a\u00020\fH\u0002J\b\u0010a\u001a\u00020AH\u0016J\b\u0010b\u001a\u00020AH\u0016J\b\u0010c\u001a\u00020AH\u0016J\u0010\u0010d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010e\u001a\u00020A2\u0006\u0010f\u001a\u00020\fH\u0002J\f\u0010g\u001a\u00020A*\u00020hH\u0014J\f\u0010i\u001a\u00020\u0001*\u00020jH\u0002J\f\u0010k\u001a\u00020\f*\u00020lH\u0002R\"\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0001@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u000e\u0010\u000fR+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R/\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u00198B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010!\u001a\u00020\"X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R%\u0010*\u001a\u00020+X\u0080\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R+\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010 \u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001d\u00106\u001a\u00020)8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b7\u00108R\u001a\u00109\u001a\u00020:X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R(\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020A\u0018\u00010@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER/\u0010F\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bJ\u0010 \u001a\u0004\bG\u0010H\"\u0004\bI\u0010\u000bR\u0010\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00048F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bQ\u0010 \u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR+\u0010R\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bV\u0010 \u001a\u0004\bS\u0010T\"\u0004\bU\u0010\u000fR&\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010C\"\u0004\bY\u0010E\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006o"}, m195d2 = {"Lcoil/compose/AsyncImagePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/RememberObserver;", "request", "Lcoil/request/ImageRequest;", "imageLoader", "Lcoil/ImageLoader;", "(Lcoil/request/ImageRequest;Lcoil/ImageLoader;)V", DownloadUtil.CookieScheme.VALUE, "_painter", "set_painter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "Lcoil/compose/AsyncImagePainter$State;", "_state", "set_state", "(Lcoil/compose/AsyncImagePainter$State;)V", "<set-?>", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "alpha$delegate", "Landroidx/compose/runtime/MutableFloatState;", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter$delegate", "Landroidx/compose/runtime/MutableState;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "getContentScale$coil_compose_base_release", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale$coil_compose_base_release", "(Landroidx/compose/ui/layout/ContentScale;)V", "drawSize", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/ui/geometry/Size;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getFilterQuality-f-v9h1I$coil_compose_base_release", "()I", "setFilterQuality-vDHp3xo$coil_compose_base_release", "(I)V", "I", "getImageLoader", "()Lcoil/ImageLoader;", "setImageLoader$coil_compose_base_release", "(Lcoil/ImageLoader;)V", "imageLoader$delegate", "intrinsicSize", "getIntrinsicSize-NH-jbRc", "()J", "isPreview", "", "isPreview$coil_compose_base_release", "()Z", "setPreview$coil_compose_base_release", "(Z)V", "onState", "Lkotlin/Function1;", "", "getOnState$coil_compose_base_release", "()Lkotlin/jvm/functions/Function1;", "setOnState$coil_compose_base_release", "(Lkotlin/jvm/functions/Function1;)V", "painter", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "painter$delegate", "rememberScope", "Lkotlinx/coroutines/CoroutineScope;", "getRequest", "()Lcoil/request/ImageRequest;", "setRequest$coil_compose_base_release", "(Lcoil/request/ImageRequest;)V", "request$delegate", "state", "getState", "()Lcoil/compose/AsyncImagePainter$State;", "setState", "state$delegate", "transform", "getTransform$coil_compose_base_release", "setTransform$coil_compose_base_release", "applyAlpha", "applyColorFilter", "clear", "maybeNewCrossfadePainter", "Lcoil/compose/CrossfadePainter;", "previous", "current", "onAbandoned", "onForgotten", "onRemembered", "updateRequest", "updateState", "input", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "toPainter", "Landroid/graphics/drawable/Drawable;", "toState", "Lcoil/request/ImageResult;", "Companion", "State", "coil-compose-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AsyncImagePainter extends Painter implements RememberObserver {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function1<State, State> DefaultTransform = new Function1<State, State>() { // from class: coil.compose.AsyncImagePainter$Companion$DefaultTransform$1
        @Override // kotlin.jvm.functions.Function1
        public final AsyncImagePainter.State invoke(AsyncImagePainter.State it) {
            return it;
        }
    };
    private Painter _painter;

    /* JADX INFO: renamed from: imageLoader$delegate, reason: from kotlin metadata */
    private final MutableState imageLoader;
    private boolean isPreview;
    private Function1<? super State, Unit> onState;
    private CoroutineScope rememberScope;

    /* JADX INFO: renamed from: request$delegate, reason: from kotlin metadata */
    private final MutableState request;
    private final MutableStateFlow<Size> drawSize = StateFlowKt.MutableStateFlow(Size.m4106boximpl(Size.INSTANCE.m4127getZeroNHjbRc()));

    /* JADX INFO: renamed from: painter$delegate, reason: from kotlin metadata */
    private final MutableState painter = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* JADX INFO: renamed from: alpha$delegate, reason: from kotlin metadata */
    private final MutableFloatState alpha = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);

    /* JADX INFO: renamed from: colorFilter$delegate, reason: from kotlin metadata */
    private final MutableState colorFilter = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    private State _state = State.Empty.INSTANCE;
    private Function1<? super State, ? extends State> transform = DefaultTransform;
    private ContentScale contentScale = ContentScale.INSTANCE.getFit();
    private int filterQuality = DrawScope.INSTANCE.m4862getDefaultFilterQualityfv9h1I();

    /* JADX INFO: renamed from: state$delegate, reason: from kotlin metadata */
    private final MutableState state = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(State.Empty.INSTANCE, null, 2, null);

    public AsyncImagePainter(ImageRequest request, ImageLoader imageLoader) {
        this.request = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(request, null, 2, null);
        this.imageLoader = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(imageLoader, null, 2, null);
    }

    private final Painter getPainter() {
        androidx.compose.runtime.State $this$getValue$iv = this.painter;
        return (Painter) $this$getValue$iv.getValue();
    }

    private final void setPainter(Painter painter) {
        MutableState $this$setValue$iv = this.painter;
        $this$setValue$iv.setValue(painter);
    }

    private final float getAlpha() {
        FloatState $this$getValue$iv = this.alpha;
        return $this$getValue$iv.getFloatValue();
    }

    private final void setAlpha(float f) {
        MutableFloatState $this$setValue$iv = this.alpha;
        $this$setValue$iv.setFloatValue(f);
    }

    private final ColorFilter getColorFilter() {
        androidx.compose.runtime.State $this$getValue$iv = this.colorFilter;
        return (ColorFilter) $this$getValue$iv.getValue();
    }

    private final void setColorFilter(ColorFilter colorFilter) {
        MutableState $this$setValue$iv = this.colorFilter;
        $this$setValue$iv.setValue(colorFilter);
    }

    private final void set_state(State value) {
        this._state = value;
        setState(value);
    }

    private final void set_painter(Painter value) {
        this._painter = value;
        setPainter(value);
    }

    public final Function1<State, State> getTransform$coil_compose_base_release() {
        return this.transform;
    }

    public final void setTransform$coil_compose_base_release(Function1<? super State, ? extends State> function1) {
        this.transform = function1;
    }

    public final Function1<State, Unit> getOnState$coil_compose_base_release() {
        return this.onState;
    }

    public final void setOnState$coil_compose_base_release(Function1<? super State, Unit> function1) {
        this.onState = function1;
    }

    /* JADX INFO: renamed from: getContentScale$coil_compose_base_release, reason: from getter */
    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final void setContentScale$coil_compose_base_release(ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    /* JADX INFO: renamed from: getFilterQuality-f-v9h1I$coil_compose_base_release, reason: not valid java name and from getter */
    public final int getFilterQuality() {
        return this.filterQuality;
    }

    /* JADX INFO: renamed from: setFilterQuality-vDHp3xo$coil_compose_base_release, reason: not valid java name */
    public final void m7129setFilterQualityvDHp3xo$coil_compose_base_release(int i) {
        this.filterQuality = i;
    }

    /* JADX INFO: renamed from: isPreview$coil_compose_base_release, reason: from getter */
    public final boolean getIsPreview() {
        return this.isPreview;
    }

    public final void setPreview$coil_compose_base_release(boolean z) {
        this.isPreview = z;
    }

    private final void setState(State state) {
        MutableState $this$setValue$iv = this.state;
        $this$setValue$iv.setValue(state);
    }

    public final State getState() {
        androidx.compose.runtime.State $this$getValue$iv = this.state;
        return (State) $this$getValue$iv.getValue();
    }

    public final ImageRequest getRequest() {
        androidx.compose.runtime.State $this$getValue$iv = this.request;
        return (ImageRequest) $this$getValue$iv.getValue();
    }

    public final void setRequest$coil_compose_base_release(ImageRequest imageRequest) {
        MutableState $this$setValue$iv = this.request;
        $this$setValue$iv.setValue(imageRequest);
    }

    public final ImageLoader getImageLoader() {
        androidx.compose.runtime.State $this$getValue$iv = this.imageLoader;
        return (ImageLoader) $this$getValue$iv.getValue();
    }

    public final void setImageLoader$coil_compose_base_release(ImageLoader imageLoader) {
        MutableState $this$setValue$iv = this.imageLoader;
        $this$setValue$iv.setValue(imageLoader);
    }

    @Override // androidx.compose.p001ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long getIntrinsicSize() {
        Painter painter = getPainter();
        return painter != null ? painter.getIntrinsicSize() : Size.INSTANCE.m4126getUnspecifiedNHjbRc();
    }

    @Override // androidx.compose.p001ui.graphics.painter.Painter
    protected void onDraw(DrawScope $this$onDraw) {
        this.drawSize.setValue(Size.m4106boximpl($this$onDraw.mo4773getSizeNHjbRc()));
        Painter $this$onDraw_u24lambda_u240 = getPainter();
        if ($this$onDraw_u24lambda_u240 != null) {
            $this$onDraw_u24lambda_u240.m4987drawx_KDEd0($this$onDraw, $this$onDraw.mo4773getSizeNHjbRc(), getAlpha(), getColorFilter());
        }
    }

    @Override // androidx.compose.p001ui.graphics.painter.Painter
    protected boolean applyAlpha(float alpha) {
        setAlpha(alpha);
        return true;
    }

    @Override // androidx.compose.p001ui.graphics.painter.Painter
    protected boolean applyColorFilter(ColorFilter colorFilter) {
        setColorFilter(colorFilter);
        return true;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        if (this.rememberScope != null) {
            return;
        }
        CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        this.rememberScope = scope;
        Object obj = this._painter;
        RememberObserver rememberObserver = obj instanceof RememberObserver ? (RememberObserver) obj : null;
        if (rememberObserver != null) {
            rememberObserver.onRemembered();
        }
        if (!this.isPreview) {
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C25821(null), 3, null);
            return;
        }
        ImageRequest request = ImageRequest.newBuilder$default(getRequest(), null, 1, null).defaults(getImageLoader().getDefaults()).build();
        Drawable placeholder = request.getPlaceholder();
        updateState(new State.Loading(placeholder != null ? toPainter(placeholder) : null));
    }

    /* JADX INFO: renamed from: coil.compose.AsyncImagePainter$onRemembered$1 */
    /* JADX INFO: compiled from: AsyncImagePainter.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "coil.compose.AsyncImagePainter$onRemembered$1", m210f = "AsyncImagePainter.kt", m211i = {}, m212l = {244}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C25821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C25821(Continuation<? super C25821> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AsyncImagePainter.this.new C25821(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C25821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final AsyncImagePainter asyncImagePainter = AsyncImagePainter.this;
                    this.label = 1;
                    if (FlowKt.mapLatest(SnapshotStateKt.snapshotFlow(new Function0<ImageRequest>() { // from class: coil.compose.AsyncImagePainter.onRemembered.1.1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final ImageRequest invoke() {
                            return asyncImagePainter.getRequest();
                        }
                    }), new AnonymousClass2(AsyncImagePainter.this, null)).collect(new AnonymousClass3(AsyncImagePainter.this), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: coil.compose.AsyncImagePainter$onRemembered$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: AsyncImagePainter.kt */
        @Metadata(m194d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m195d2 = {"<anonymous>", "Lcoil/compose/AsyncImagePainter$State;", "it", "Lcoil/request/ImageRequest;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "coil.compose.AsyncImagePainter$onRemembered$1$2", m210f = "AsyncImagePainter.kt", m211i = {}, m212l = {243}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<ImageRequest, Continuation<? super State>, Object> {
            Object L$0;
            int label;
            final /* synthetic */ AsyncImagePainter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(AsyncImagePainter asyncImagePainter, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = asyncImagePainter;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(ImageRequest imageRequest, Continuation<? super State> continuation) {
                return ((AnonymousClass2) create(imageRequest, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                AsyncImagePainter asyncImagePainter;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        asyncImagePainter = this.this$0;
                        this.L$0 = asyncImagePainter;
                        this.label = 1;
                        Object objExecute = this.this$0.getImageLoader().execute(this.this$0.updateRequest(this.this$0.getRequest()), this);
                        if (objExecute == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = objExecute;
                        break;
                    case 1:
                        AsyncImagePainter asyncImagePainter2 = (AsyncImagePainter) this.L$0;
                        ResultKt.throwOnFailure($result);
                        asyncImagePainter = asyncImagePainter2;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return asyncImagePainter.toState((ImageResult) $result);
            }
        }

        /* JADX INFO: renamed from: coil.compose.AsyncImagePainter$onRemembered$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: AsyncImagePainter.kt */
        @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* synthetic */ class AnonymousClass3 implements FlowCollector, FunctionAdapter {
            final /* synthetic */ AsyncImagePainter $tmp0;

            AnonymousClass3(AsyncImagePainter asyncImagePainter) {
                this.$tmp0 = asyncImagePainter;
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                    return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
                }
                return false;
            }

            @Override // kotlin.jvm.internal.FunctionAdapter
            public final Function<?> getFunctionDelegate() {
                return new AdaptedFunctionReference(2, this.$tmp0, AsyncImagePainter.class, "updateState", "updateState(Lcoil/compose/AsyncImagePainter$State;)V", 4);
            }

            public final int hashCode() {
                return getFunctionDelegate().hashCode();
            }

            public final Object emit(State p0, Continuation<? super Unit> continuation) {
                Object objInvokeSuspend$updateState = C25821.invokeSuspend$updateState(this.$tmp0, p0, continuation);
                return objInvokeSuspend$updateState == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvokeSuspend$updateState : Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                return emit((State) value, (Continuation<? super Unit>) $completion);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ Object invokeSuspend$updateState(AsyncImagePainter $this$invokeSuspend_u24updateState, State p0, Continuation $completion) {
            $this$invokeSuspend_u24updateState.updateState(p0);
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        clear();
        Object obj = this._painter;
        RememberObserver rememberObserver = obj instanceof RememberObserver ? (RememberObserver) obj : null;
        if (rememberObserver != null) {
            rememberObserver.onForgotten();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        clear();
        Object obj = this._painter;
        RememberObserver rememberObserver = obj instanceof RememberObserver ? (RememberObserver) obj : null;
        if (rememberObserver != null) {
            rememberObserver.onAbandoned();
        }
    }

    private final void clear() {
        CoroutineScope coroutineScope = this.rememberScope;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
        }
        this.rememberScope = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageRequest updateRequest(ImageRequest request) {
        ImageRequest.Builder $this$iv = ImageRequest.newBuilder$default(request, null, 1, null);
        ImageRequest.Builder $this$updateRequest_u24lambda_u242 = $this$iv.target(new Target() { // from class: coil.compose.AsyncImagePainter$updateRequest$$inlined$target$default$1
            @Override // coil.target.Target
            public void onStart(Drawable placeholder) {
                this.this$0.updateState(new AsyncImagePainter.State.Loading(placeholder != null ? this.this$0.toPainter(placeholder) : null));
            }

            @Override // coil.target.Target
            public void onError(Drawable error) {
            }

            @Override // coil.target.Target
            public void onSuccess(Drawable result) {
            }
        });
        if (request.getDefined().getSizeResolver() == null) {
            $this$updateRequest_u24lambda_u242.size(new SizeResolver() { // from class: coil.compose.AsyncImagePainter$updateRequest$2$1
                @Override // coil.size.SizeResolver
                public final Object size(Continuation<? super coil.size.Size> continuation) {
                    final Flow $this$mapNotNull$iv = this.this$0.drawSize;
                    return FlowKt.first(new Flow<coil.size.Size>() { // from class: coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1

                        /* JADX INFO: renamed from: coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2 */
                        /* JADX INFO: compiled from: Emitters.kt */
                        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", DownloadUtil.CookieScheme.VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        public static final class C25832<T> implements FlowCollector {
                            final /* synthetic */ FlowCollector $this_unsafeFlow;

                            /* JADX INFO: renamed from: coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                            /* JADX INFO: compiled from: Emitters.kt */
                            @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                            @DebugMetadata(m209c = "coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2", m210f = "AsyncImagePainter.kt", m211i = {}, m212l = {225}, m213m = "emit", m214n = {}, m215s = {})
                            public static final class AnonymousClass1 extends ContinuationImpl {
                                Object L$0;
                                int label;
                                /* synthetic */ Object result;

                                public AnonymousClass1(Continuation continuation) {
                                    super(continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    this.result = obj;
                                    this.label |= Integer.MIN_VALUE;
                                    return C25832.this.emit(null, this);
                                }
                            }

                            public C25832(FlowCollector flowCollector) {
                                this.$this_unsafeFlow = flowCollector;
                            }

                            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            public final Object emit(Object value, Continuation continuation) {
                                AnonymousClass1 anonymousClass1;
                                if (continuation instanceof AnonymousClass1) {
                                    anonymousClass1 = (AnonymousClass1) continuation;
                                    if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                        anonymousClass1.label -= Integer.MIN_VALUE;
                                    } else {
                                        anonymousClass1 = new AnonymousClass1(continuation);
                                    }
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                                AnonymousClass1 anonymousClass2 = anonymousClass1;
                                Object $result = anonymousClass2.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (anonymousClass2.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        FlowCollector $this$mapNotNull_u24lambda_u246 = this.$this_unsafeFlow;
                                        long it = ((Size) value).getPackedValue();
                                        coil.size.Size sizeM7134toSizeOrNulluvyYCjk = AsyncImagePainterKt.m7134toSizeOrNulluvyYCjk(it);
                                        if (sizeM7134toSizeOrNulluvyYCjk != null) {
                                            anonymousClass2.label = 1;
                                            Object transformed = $this$mapNotNull_u24lambda_u246.emit(sizeM7134toSizeOrNulluvyYCjk, anonymousClass2);
                                            if (transformed == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        }
                                        break;
                                    case 1:
                                        ResultKt.throwOnFailure($result);
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // kotlinx.coroutines.flow.Flow
                        public Object collect(FlowCollector<? super coil.size.Size> flowCollector, Continuation $completion) {
                            Object objCollect = $this$mapNotNull$iv.collect(new C25832(flowCollector), $completion);
                            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                        }
                    }, continuation);
                }
            });
        }
        if (request.getDefined().getScale() == null) {
            $this$updateRequest_u24lambda_u242.scale(UtilsKt.toScale(this.contentScale));
        }
        if (request.getDefined().getPrecision() != Precision.EXACT) {
            $this$updateRequest_u24lambda_u242.precision(Precision.INEXACT);
        }
        return $this$updateRequest_u24lambda_u242.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateState(State input) {
        State previous = this._state;
        State current = this.transform.invoke(input);
        set_state(current);
        CrossfadePainter crossfadePainterMaybeNewCrossfadePainter = maybeNewCrossfadePainter(previous, current);
        set_painter(crossfadePainterMaybeNewCrossfadePainter != null ? crossfadePainterMaybeNewCrossfadePainter : current.getPainter());
        if (this.rememberScope != null && previous.getPainter() != current.getPainter()) {
            Object painter = previous.getPainter();
            RememberObserver rememberObserver = painter instanceof RememberObserver ? (RememberObserver) painter : null;
            if (rememberObserver != null) {
                rememberObserver.onForgotten();
            }
            Object painter2 = current.getPainter();
            RememberObserver rememberObserver2 = painter2 instanceof RememberObserver ? (RememberObserver) painter2 : null;
            if (rememberObserver2 != null) {
                rememberObserver2.onRemembered();
            }
        }
        Function1<? super State, Unit> function1 = this.onState;
        if (function1 != null) {
            function1.invoke(current);
        }
    }

    private final CrossfadePainter maybeNewCrossfadePainter(State previous, State current) {
        ErrorResult result;
        if (current instanceof State.Success) {
            result = ((State.Success) current).getResult();
        } else {
            if (!(current instanceof State.Error)) {
                return null;
            }
            result = ((State.Error) current).getResult();
        }
        Transition transition = result.getRequest().getTransitionFactory().create(AsyncImagePainterKt.fakeTransitionTarget, result);
        if (transition instanceof CrossfadeTransition) {
            return new CrossfadePainter(previous instanceof State.Loading ? previous.getPainter() : null, current.getPainter(), this.contentScale, ((CrossfadeTransition) transition).getDurationMillis(), ((result instanceof SuccessResult) && ((SuccessResult) result).getIsPlaceholderCached()) ? false : true, ((CrossfadeTransition) transition).getPreferExactIntrinsicSize());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final State toState(ImageResult $this$toState) {
        if ($this$toState instanceof SuccessResult) {
            return new State.Success(toPainter(((SuccessResult) $this$toState).getDrawable()), (SuccessResult) $this$toState);
        }
        if (!($this$toState instanceof ErrorResult)) {
            throw new NoWhenBranchMatchedException();
        }
        Drawable drawable = $this$toState.getDrawable();
        return new State.Error(drawable != null ? toPainter(drawable) : null, (ErrorResult) $this$toState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Painter toPainter(Drawable $this$toPainter) {
        if ($this$toPainter instanceof BitmapDrawable) {
            ImageBitmap imageBitmapAsImageBitmap = AndroidImageBitmap_androidKt.asImageBitmap(((BitmapDrawable) $this$toPainter).getBitmap());
            return BitmapPainterKt.m4983BitmapPainterQZhYCtY(imageBitmapAsImageBitmap, (6 & 2) != 0 ? IntOffset.INSTANCE.m6943getZeronOccac() : 0L, (6 & 4) != 0 ? IntSizeKt.IntSize(imageBitmapAsImageBitmap.getWidth(), imageBitmapAsImageBitmap.getHeight()) : 0L, (6 & 8) != 0 ? FilterQuality.INSTANCE.m4391getLowfv9h1I() : this.filterQuality);
        }
        return new DrawablePainter($this$toPainter.mutate());
    }

    /* JADX INFO: compiled from: AsyncImagePainter.kt */
    @Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, m195d2 = {"Lcoil/compose/AsyncImagePainter$State;", "", "()V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "Empty", "Error", "Loading", "Success", "Lcoil/compose/AsyncImagePainter$State$Empty;", "Lcoil/compose/AsyncImagePainter$State$Error;", "Lcoil/compose/AsyncImagePainter$State$Loading;", "Lcoil/compose/AsyncImagePainter$State$Success;", "coil-compose-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static abstract class State {
        public static final int $stable = 0;

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract Painter getPainter();

        private State() {
        }

        /* JADX INFO: compiled from: AsyncImagePainter.kt */
        @Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m195d2 = {"Lcoil/compose/AsyncImagePainter$State$Empty;", "Lcoil/compose/AsyncImagePainter$State;", "()V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final /* data */ class Empty extends State {
            public static final int $stable = 0;
            public static final Empty INSTANCE = new Empty();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Empty)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1515560141;
            }

            public String toString() {
                return "Empty";
            }

            private Empty() {
                super(null);
            }

            @Override // coil.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return null;
            }
        }

        /* JADX INFO: compiled from: AsyncImagePainter.kt */
        @Metadata(m194d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m195d2 = {"Lcoil/compose/AsyncImagePainter$State$Loading;", "Lcoil/compose/AsyncImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final /* data */ class Loading extends State {
            public static final int $stable = 8;
            private final Painter painter;

            public static /* synthetic */ Loading copy$default(Loading loading, Painter painter, int i, Object obj) {
                if ((i & 1) != 0) {
                    painter = loading.painter;
                }
                return loading.copy(painter);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Painter getPainter() {
                return this.painter;
            }

            public final Loading copy(Painter painter) {
                return new Loading(painter);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Loading) && Intrinsics.areEqual(this.painter, ((Loading) other).painter);
            }

            public int hashCode() {
                if (this.painter == null) {
                    return 0;
                }
                return this.painter.hashCode();
            }

            public String toString() {
                return "Loading(painter=" + this.painter + ')';
            }

            @Override // coil.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return this.painter;
            }

            public Loading(Painter painter) {
                super(null);
                this.painter = painter;
            }
        }

        /* JADX INFO: compiled from: AsyncImagePainter.kt */
        @Metadata(m194d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m195d2 = {"Lcoil/compose/AsyncImagePainter$State$Success;", "Lcoil/compose/AsyncImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "result", "Lcoil/request/SuccessResult;", "(Landroidx/compose/ui/graphics/painter/Painter;Lcoil/request/SuccessResult;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getResult", "()Lcoil/request/SuccessResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final /* data */ class Success extends State {
            public static final int $stable = 8;
            private final Painter painter;
            private final SuccessResult result;

            public static /* synthetic */ Success copy$default(Success success, Painter painter, SuccessResult successResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    painter = success.painter;
                }
                if ((i & 2) != 0) {
                    successResult = success.result;
                }
                return success.copy(painter, successResult);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Painter getPainter() {
                return this.painter;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final SuccessResult getResult() {
                return this.result;
            }

            public final Success copy(Painter painter, SuccessResult result) {
                return new Success(painter, result);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return Intrinsics.areEqual(this.painter, success.painter) && Intrinsics.areEqual(this.result, success.result);
            }

            public int hashCode() {
                return (this.painter.hashCode() * 31) + this.result.hashCode();
            }

            public String toString() {
                return "Success(painter=" + this.painter + ", result=" + this.result + ')';
            }

            @Override // coil.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return this.painter;
            }

            public final SuccessResult getResult() {
                return this.result;
            }

            public Success(Painter painter, SuccessResult result) {
                super(null);
                this.painter = painter;
                this.result = result;
            }
        }

        /* JADX INFO: compiled from: AsyncImagePainter.kt */
        @Metadata(m194d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m195d2 = {"Lcoil/compose/AsyncImagePainter$State$Error;", "Lcoil/compose/AsyncImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "result", "Lcoil/request/ErrorResult;", "(Landroidx/compose/ui/graphics/painter/Painter;Lcoil/request/ErrorResult;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getResult", "()Lcoil/request/ErrorResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final /* data */ class Error extends State {
            public static final int $stable = 8;
            private final Painter painter;
            private final ErrorResult result;

            public static /* synthetic */ Error copy$default(Error error, Painter painter, ErrorResult errorResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    painter = error.painter;
                }
                if ((i & 2) != 0) {
                    errorResult = error.result;
                }
                return error.copy(painter, errorResult);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Painter getPainter() {
                return this.painter;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ErrorResult getResult() {
                return this.result;
            }

            public final Error copy(Painter painter, ErrorResult result) {
                return new Error(painter, result);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                Error error = (Error) other;
                return Intrinsics.areEqual(this.painter, error.painter) && Intrinsics.areEqual(this.result, error.result);
            }

            public int hashCode() {
                return ((this.painter == null ? 0 : this.painter.hashCode()) * 31) + this.result.hashCode();
            }

            public String toString() {
                return "Error(painter=" + this.painter + ", result=" + this.result + ')';
            }

            @Override // coil.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return this.painter;
            }

            public final ErrorResult getResult() {
                return this.result;
            }

            public Error(Painter painter, ErrorResult result) {
                super(null);
                this.painter = painter;
                this.result = result;
            }
        }
    }

    /* JADX INFO: compiled from: AsyncImagePainter.kt */
    @Metadata(m194d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m195d2 = {"Lcoil/compose/AsyncImagePainter$Companion;", "", "()V", "DefaultTransform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "getDefaultTransform", "()Lkotlin/jvm/functions/Function1;", "coil-compose-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function1<State, State> getDefaultTransform() {
            return AsyncImagePainter.DefaultTransform;
        }
    }
}
