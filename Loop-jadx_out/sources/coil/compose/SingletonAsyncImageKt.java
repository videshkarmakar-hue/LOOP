package coil.compose;

import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.ColorFilter;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.painter.Painter;
import androidx.compose.p001ui.layout.ContentScale;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SingletonAsyncImage.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0095\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001aÓ\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006$"}, m195d2 = {"AsyncImage", "", "model", "", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "transform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "onState", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "AsyncImage-3HmZ8SU", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;II)V", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lcoil/compose/AsyncImagePainter$State$Loading;", "onSuccess", "Lcoil/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil/compose/AsyncImagePainter$State$Error;", "AsyncImage-ylYTKUw", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V", "coil-compose-singleton_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SingletonAsyncImageKt {
    /* JADX INFO: renamed from: AsyncImage-ylYTKUw, reason: not valid java name */
    public static final void m7152AsyncImageylYTKUw(Object model, String contentDescription, Modifier modifier, Painter placeholder, Painter error, Painter fallback, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function2, Function1<? super AsyncImagePainter.State.Error, Unit> function3, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, int filterQuality, Composer $composer, int $changed, int $changed1, int i) {
        $composer.startReplaceableGroup(2027616330);
        ComposerKt.sourceInformation($composer, "C(AsyncImage)P(8,3,9,13,5,6,11,12,10!1,4!,7:c#ui.graphics.FilterQuality)");
        Modifier modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        Painter placeholder2 = (i & 8) != 0 ? null : placeholder;
        Painter error2 = (i & 16) != 0 ? null : error;
        Painter fallback2 = (i & 32) != 0 ? error2 : fallback;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function4 = (i & 64) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function5 = (i & 128) != 0 ? null : function2;
        Function1<? super AsyncImagePainter.State.Error, Unit> function6 = (i & 256) != 0 ? null : function3;
        Alignment alignment2 = (i & 512) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale contentScale2 = (i & 1024) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float alpha2 = (i & 2048) != 0 ? 1.0f : alpha;
        ColorFilter colorFilter2 = (i & 4096) != 0 ? null : colorFilter;
        int filterQuality2 = (i & 8192) != 0 ? DrawScope.INSTANCE.m4862getDefaultFilterQualityfv9h1I() : filterQuality;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2027616330, $changed, $changed1, "coil.compose.AsyncImage (SingletonAsyncImage.kt:60)");
        }
        AsyncImageKt.m7125AsyncImageQ4Kwu38(model, contentDescription, ImageLoaderProvidableCompositionLocal.getCurrent(LocalImageLoaderKt.getLocalImageLoader(), $composer, 6), modifier2, placeholder2, error2, fallback2, function4, function5, function6, alignment2, contentScale2, alpha2, colorFilter2, filterQuality2, $composer, ($changed & 112) | 2392584 | (($changed << 3) & 7168) | (($changed << 3) & 29360128) | (($changed << 3) & 234881024) | (($changed << 3) & 1879048192), (($changed >> 27) & 14) | (($changed1 << 3) & 112) | (($changed1 << 3) & 896) | (($changed1 << 3) & 7168) | (57344 & ($changed1 << 3)), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    /* JADX INFO: renamed from: AsyncImage-3HmZ8SU, reason: not valid java name */
    public static final void m7151AsyncImage3HmZ8SU(Object model, String contentDescription, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function2, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, int filterQuality, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(-941517612);
        ComposerKt.sourceInformation($composer, "C(AsyncImage)P(6,3,7,9,8!1,4!,5:c#ui.graphics.FilterQuality)");
        Modifier modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i & 8) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function1<? super AsyncImagePainter.State, Unit> function3 = (i & 16) != 0 ? null : function2;
        Alignment alignment2 = (i & 32) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale contentScale2 = (i & 64) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float alpha2 = (i & 128) != 0 ? 1.0f : alpha;
        ColorFilter colorFilter2 = (i & 256) != 0 ? null : colorFilter;
        int filterQuality2 = (i & 512) != 0 ? DrawScope.INSTANCE.m4862getDefaultFilterQualityfv9h1I() : filterQuality;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-941517612, $changed, -1, "coil.compose.AsyncImage (SingletonAsyncImage.kt:113)");
        }
        AsyncImageKt.m7124AsyncImageMvsnxeU(model, contentDescription, ImageLoaderProvidableCompositionLocal.getCurrent(LocalImageLoaderKt.getLocalImageLoader(), $composer, 6), modifier2, defaultTransform, function3, alignment2, contentScale2, alpha2, colorFilter2, filterQuality2, $composer, ($changed & 112) | 520 | (($changed << 3) & 7168) | (($changed << 3) & 57344) | (($changed << 3) & 458752) | (($changed << 3) & 3670016) | (($changed << 3) & 29360128) | (($changed << 3) & 234881024) | (1879048192 & ($changed << 3)), ($changed >> 27) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }
}
