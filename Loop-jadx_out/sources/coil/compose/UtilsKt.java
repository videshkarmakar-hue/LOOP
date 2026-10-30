package coil.compose;

import android.content.Context;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.painter.Painter;
import androidx.compose.p001ui.layout.ContentScale;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.request.ImageRequest;
import coil.request.NullRequestDataException;
import coil.size.Scale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aX\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0001\u001a\u0017\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0001¢\u0006\u0002\u0010\u0013\u001a2\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0001\u001a!\u0010\u0019\u001a\u00020\u001a*\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001aH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a!\u0010\u001e\u001a\u00020\u001a*\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u001aH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u001d\u001a\u001b\u0010!\u001a\u00020\u001a*\u00020\u001a2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0#H\u0080\b\u001a\u0019\u0010$\u001a\u00020%*\u00020&H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\f\u0010)\u001a\u00020**\u00020+H\u0001\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006,"}, m195d2 = {"ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "onStateOf", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "", "onLoading", "Lcoil/compose/AsyncImagePainter$State$Loading;", "onSuccess", "Lcoil/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil/compose/AsyncImagePainter$State$Error;", "requestOf", "Lcoil/request/ImageRequest;", "model", "", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Lcoil/request/ImageRequest;", "transformOf", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "constrainHeight", "", "height", "constrainHeight-K40F9xA", "(JF)F", "constrainWidth", "width", "constrainWidth-K40F9xA", "takeOrElse", "block", "Lkotlin/Function0;", "toIntSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/geometry/Size;", "toIntSize-uvyYCjk", "(J)J", "toScale", "Lcoil/size/Scale;", "Landroidx/compose/ui/layout/ContentScale;", "coil-compose-base_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class UtilsKt {
    private static final long ZeroConstraints = Constraints.INSTANCE.m6754fixedJhjzzOo(0, 0);

    public static final ImageRequest requestOf(Object model, Composer $composer, int $changed) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1151830858, $changed, -1, "coil.compose.requestOf (Utils.kt:21)");
        }
        if (model instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) model;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return imageRequest;
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ImageRequest imageRequestBuild = new ImageRequest.Builder((Context) objConsume).data(model).build();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return imageRequestBuild;
    }

    public static final Function1<AsyncImagePainter.State, AsyncImagePainter.State> transformOf(final Painter placeholder, final Painter error, final Painter fallback) {
        if (placeholder != null || error != null || fallback != null) {
            return new Function1<AsyncImagePainter.State, AsyncImagePainter.State>() { // from class: coil.compose.UtilsKt.transformOf.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final AsyncImagePainter.State invoke(AsyncImagePainter.State state) {
                    AsyncImagePainter.State.Error errorCopy$default;
                    if (state instanceof AsyncImagePainter.State.Loading) {
                        return placeholder != null ? ((AsyncImagePainter.State.Loading) state).copy(placeholder) : (AsyncImagePainter.State.Loading) state;
                    }
                    if (!(state instanceof AsyncImagePainter.State.Error)) {
                        return state;
                    }
                    if (((AsyncImagePainter.State.Error) state).getResult().getThrowable() instanceof NullRequestDataException) {
                        errorCopy$default = fallback != null ? AsyncImagePainter.State.Error.copy$default((AsyncImagePainter.State.Error) state, fallback, null, 2, null) : (AsyncImagePainter.State.Error) state;
                    } else {
                        errorCopy$default = error != null ? AsyncImagePainter.State.Error.copy$default((AsyncImagePainter.State.Error) state, error, null, 2, null) : (AsyncImagePainter.State.Error) state;
                    }
                    return errorCopy$default;
                }
            };
        }
        return AsyncImagePainter.INSTANCE.getDefaultTransform();
    }

    public static final Function1<AsyncImagePainter.State, Unit> onStateOf(final Function1<? super AsyncImagePainter.State.Loading, Unit> function1, final Function1<? super AsyncImagePainter.State.Success, Unit> function2, final Function1<? super AsyncImagePainter.State.Error, Unit> function3) {
        if (function1 != null || function2 != null || function3 != null) {
            return new Function1<AsyncImagePainter.State, Unit>() { // from class: coil.compose.UtilsKt.onStateOf.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AsyncImagePainter.State state) {
                    invoke2(state);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AsyncImagePainter.State state) {
                    if (state instanceof AsyncImagePainter.State.Loading) {
                        Function1<AsyncImagePainter.State.Loading, Unit> function4 = function1;
                        if (function4 != null) {
                            function4.invoke(state);
                            return;
                        }
                        return;
                    }
                    if (state instanceof AsyncImagePainter.State.Success) {
                        Function1<AsyncImagePainter.State.Success, Unit> function5 = function2;
                        if (function5 != null) {
                            function5.invoke(state);
                            return;
                        }
                        return;
                    }
                    if (!(state instanceof AsyncImagePainter.State.Error)) {
                        boolean z = state instanceof AsyncImagePainter.State.Empty;
                        return;
                    }
                    Function1<AsyncImagePainter.State.Error, Unit> function6 = function3;
                    if (function6 != null) {
                        function6.invoke(state);
                    }
                }
            };
        }
        return null;
    }

    public static final Scale toScale(ContentScale $this$toScale) {
        return Intrinsics.areEqual($this$toScale, ContentScale.INSTANCE.getFit()) ? true : Intrinsics.areEqual($this$toScale, ContentScale.INSTANCE.getInside()) ? Scale.FIT : Scale.FILL;
    }

    /* JADX INFO: renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final float m7160constrainWidthK40F9xA(long $this$constrainWidth_u2dK40F9xA, float width) {
        return RangesKt.coerceIn(width, Constraints.m6746getMinWidthimpl($this$constrainWidth_u2dK40F9xA), Constraints.m6744getMaxWidthimpl($this$constrainWidth_u2dK40F9xA));
    }

    /* JADX INFO: renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final float m7159constrainHeightK40F9xA(long $this$constrainHeight_u2dK40F9xA, float height) {
        return RangesKt.coerceIn(height, Constraints.m6745getMinHeightimpl($this$constrainHeight_u2dK40F9xA), Constraints.m6743getMaxHeightimpl($this$constrainHeight_u2dK40F9xA));
    }

    public static final float takeOrElse(float $this$takeOrElse, Function0<Float> function0) {
        return !Float.isInfinite($this$takeOrElse) && !Float.isNaN($this$takeOrElse) ? $this$takeOrElse : function0.invoke().floatValue();
    }

    /* JADX INFO: renamed from: toIntSize-uvyYCjk, reason: not valid java name */
    public static final long m7161toIntSizeuvyYCjk(long $this$toIntSize_u2duvyYCjk) {
        return IntSizeKt.IntSize(MathKt.roundToInt(Size.m4118getWidthimpl($this$toIntSize_u2duvyYCjk)), MathKt.roundToInt(Size.m4115getHeightimpl($this$toIntSize_u2duvyYCjk)));
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }
}
