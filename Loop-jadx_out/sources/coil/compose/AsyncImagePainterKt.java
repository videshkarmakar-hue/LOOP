package coil.compose;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.ImageBitmap;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.painter.Painter;
import androidx.compose.p001ui.graphics.vector.ImageVector;
import androidx.compose.p001ui.layout.ContentScale;
import androidx.compose.p001ui.platform.InspectionModeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.ImageLoader;
import coil.request.ImageRequest;
import coil.size.Dimension;
import coil.size.Dimensions;
import coil.target.Target;
import coil.transition.TransitionTarget;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: AsyncImagePainter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000}\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0001\u001ai\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a§\u0001\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020(H\u0002\u001a\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0002\u001a\u001b\u0010-\u001a\u0004\u0018\u00010.*\u00020\u0005H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001b\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00061"}, m195d2 = {"fakeTransitionTarget", "coil/compose/AsyncImagePainterKt$fakeTransitionTarget$1", "Lcoil/compose/AsyncImagePainterKt$fakeTransitionTarget$1;", "isPositive", "", "Landroidx/compose/ui/geometry/Size;", "isPositive-uvyYCjk", "(J)Z", "rememberAsyncImagePainter", "Lcoil/compose/AsyncImagePainter;", "model", "", "imageLoader", "Lcoil/ImageLoader;", "transform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "onState", "", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "rememberAsyncImagePainter-5jETZwI", "(Ljava/lang/Object;Lcoil/ImageLoader;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lcoil/compose/AsyncImagePainter$State$Loading;", "onSuccess", "Lcoil/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil/compose/AsyncImagePainter$State$Error;", "rememberAsyncImagePainter-3HmZ8SU", "(Ljava/lang/Object;Lcoil/ImageLoader;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "unsupportedData", "", "name", "", "description", "validateRequest", "request", "Lcoil/request/ImageRequest;", "toSizeOrNull", "Lcoil/size/Size;", "toSizeOrNull-uvyYCjk", "(J)Lcoil/size/Size;", "coil-compose-base_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AsyncImagePainterKt {
    private static final AsyncImagePainterKt$fakeTransitionTarget$1 fakeTransitionTarget = new TransitionTarget() { // from class: coil.compose.AsyncImagePainterKt$fakeTransitionTarget$1
        @Override // coil.target.Target
        public /* synthetic */ void onError(Drawable drawable) {
            Target.CC.$default$onError(this, drawable);
        }

        @Override // coil.target.Target
        public /* synthetic */ void onStart(Drawable drawable) {
            Target.CC.$default$onStart(this, drawable);
        }

        @Override // coil.target.Target
        public /* synthetic */ void onSuccess(Drawable drawable) {
            Target.CC.$default$onSuccess(this, drawable);
        }

        @Override // coil.transition.TransitionTarget
        public /* bridge */ /* synthetic */ View getView() {
            return (View) m7135getView();
        }

        /* JADX INFO: renamed from: getView, reason: collision with other method in class */
        public Void m7135getView() {
            throw new UnsupportedOperationException();
        }

        @Override // coil.transition.TransitionTarget
        public Drawable getDrawable() {
            return null;
        }
    };

    /* JADX INFO: renamed from: rememberAsyncImagePainter-3HmZ8SU, reason: not valid java name */
    public static final AsyncImagePainter m7132rememberAsyncImagePainter3HmZ8SU(Object model, ImageLoader imageLoader, Painter placeholder, Painter error, Painter fallback, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function2, Function1<? super AsyncImagePainter.State.Error, Unit> function3, ContentScale contentScale, int filterQuality, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(2140758544);
        ComposerKt.sourceInformation($composer, "C(rememberAsyncImagePainter)P(5,4,9,1,2,7,8,6!,3:c#ui.graphics.FilterQuality)");
        Painter placeholder2 = (i & 4) != 0 ? null : placeholder;
        Painter error2 = (i & 8) != 0 ? null : error;
        Painter fallback2 = (i & 16) != 0 ? error2 : fallback;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function4 = (i & 32) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function5 = (i & 64) != 0 ? null : function2;
        Function1<? super AsyncImagePainter.State.Error, Unit> function6 = (i & 128) != 0 ? null : function3;
        ContentScale contentScale2 = (i & 256) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        int filterQuality2 = (i & 512) != 0 ? DrawScope.INSTANCE.m4862getDefaultFilterQualityfv9h1I() : filterQuality;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2140758544, $changed, -1, "coil.compose.rememberAsyncImagePainter (AsyncImagePainter.kt:95)");
        }
        AsyncImagePainter asyncImagePainterM7133rememberAsyncImagePainter5jETZwI = m7133rememberAsyncImagePainter5jETZwI(model, imageLoader, UtilsKt.transformOf(placeholder2, error2, fallback2), UtilsKt.onStateOf(function4, function5, function6), contentScale2, filterQuality2, $composer, (($changed >> 12) & 57344) | 72 | (458752 & ($changed >> 12)), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return asyncImagePainterM7133rememberAsyncImagePainter5jETZwI;
    }

    /* JADX INFO: renamed from: rememberAsyncImagePainter-5jETZwI, reason: not valid java name */
    public static final AsyncImagePainter m7133rememberAsyncImagePainter5jETZwI(Object model, ImageLoader imageLoader, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function2, ContentScale contentScale, int filterQuality, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(-2020614074);
        ComposerKt.sourceInformation($composer, "C(rememberAsyncImagePainter)P(3,2,5,4!,1:c#ui.graphics.FilterQuality)");
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i & 4) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function1<? super AsyncImagePainter.State, Unit> function3 = (i & 8) != 0 ? null : function2;
        ContentScale contentScale2 = (i & 16) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        int filterQuality2 = (i & 32) != 0 ? DrawScope.INSTANCE.m4862getDefaultFilterQualityfv9h1I() : filterQuality;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2020614074, $changed, -1, "coil.compose.rememberAsyncImagePainter (AsyncImagePainter.kt:136)");
        }
        ImageRequest request = UtilsKt.requestOf(model, $composer, 8);
        validateRequest(request);
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new AsyncImagePainter(request, imageLoader);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        AsyncImagePainter painter = (AsyncImagePainter) value$iv$iv;
        painter.setTransform$coil_compose_base_release(defaultTransform);
        painter.setOnState$coil_compose_base_release(function3);
        painter.setContentScale$coil_compose_base_release(contentScale2);
        painter.m7129setFilterQualityvDHp3xo$coil_compose_base_release(filterQuality2);
        ProvidableCompositionLocal<Boolean> localInspectionMode = InspectionModeKt.getLocalInspectionMode();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localInspectionMode);
        ComposerKt.sourceInformationMarkerEnd($composer);
        painter.setPreview$coil_compose_base_release(((Boolean) objConsume).booleanValue());
        painter.setImageLoader$coil_compose_base_release(imageLoader);
        painter.setRequest$coil_compose_base_release(request);
        painter.onRemembered();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return painter;
    }

    private static final void validateRequest(ImageRequest request) {
        Object data = request.getData();
        if (data instanceof ImageRequest.Builder) {
            unsupportedData("ImageRequest.Builder", "Did you forget to call ImageRequest.Builder.build()?");
            throw new KotlinNothingValueException();
        }
        if (data instanceof ImageBitmap) {
            unsupportedData$default("ImageBitmap", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (data instanceof ImageVector) {
            unsupportedData$default("ImageVector", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (data instanceof Painter) {
            unsupportedData$default("Painter", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (!(request.getTarget() == null)) {
            throw new IllegalArgumentException("request.target must be null.".toString());
        }
    }

    static /* synthetic */ Void unsupportedData$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "If you wish to display this " + str + ", use androidx.compose.foundation.Image.";
        }
        return unsupportedData(str, str2);
    }

    private static final Void unsupportedData(String name, String description) {
        throw new IllegalArgumentException("Unsupported type: " + name + ". " + description);
    }

    /* JADX INFO: renamed from: isPositive-uvyYCjk, reason: not valid java name */
    private static final boolean m7131isPositiveuvyYCjk(long $this$isPositive) {
        return ((double) Size.m4118getWidthimpl($this$isPositive)) >= 0.5d && ((double) Size.m4115getHeightimpl($this$isPositive)) >= 0.5d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toSizeOrNull-uvyYCjk, reason: not valid java name */
    public static final coil.size.Size m7134toSizeOrNulluvyYCjk(long $this$toSizeOrNull_u2duvyYCjk) {
        if ($this$toSizeOrNull_u2duvyYCjk == Size.INSTANCE.m4126getUnspecifiedNHjbRc()) {
            return coil.size.Size.ORIGINAL;
        }
        if (m7131isPositiveuvyYCjk($this$toSizeOrNull_u2duvyYCjk)) {
            float fM4118getWidthimpl = Size.m4118getWidthimpl($this$toSizeOrNull_u2duvyYCjk);
            Dimension Dimension = !Float.isInfinite(fM4118getWidthimpl) && !Float.isNaN(fM4118getWidthimpl) ? Dimensions.Dimension(MathKt.roundToInt(Size.m4118getWidthimpl($this$toSizeOrNull_u2duvyYCjk))) : Dimension.Undefined.INSTANCE;
            float fM4115getHeightimpl = Size.m4115getHeightimpl($this$toSizeOrNull_u2duvyYCjk);
            return new coil.size.Size(Dimension, (Float.isInfinite(fM4115getHeightimpl) || Float.isNaN(fM4115getHeightimpl)) ? false : true ? Dimensions.Dimension(MathKt.roundToInt(Size.m4115getHeightimpl($this$toSizeOrNull_u2duvyYCjk))) : Dimension.Undefined.INSTANCE);
        }
        return null;
    }
}
