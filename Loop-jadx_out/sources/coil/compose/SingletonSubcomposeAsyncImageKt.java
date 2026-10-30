package coil.compose;

import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.ColorFilter;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.layout.ContentScale;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: SingletonSubcomposeAsyncImage.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a³\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a§\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\b\u0002\u0010\u001c\u001a \u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001d¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u00192&\b\u0002\u0010\u001f\u001a \u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001d¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u00192&\b\u0002\u0010!\u001a \u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001d¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u00192\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006("}, m195d2 = {"SubcomposeAsyncImage", "", "model", "", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "transform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "onState", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "content", "Lcoil/compose/SubcomposeAsyncImageScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "SubcomposeAsyncImage-10Xjiaw", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "loading", "Lkotlin/Function2;", "Lcoil/compose/AsyncImagePainter$State$Loading;", "success", "Lcoil/compose/AsyncImagePainter$State$Success;", "error", "Lcoil/compose/AsyncImagePainter$State$Error;", "onLoading", "onSuccess", "onError", "SubcomposeAsyncImage-ylYTKUw", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V", "coil-compose-singleton_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SingletonSubcomposeAsyncImageKt {
    /* JADX INFO: renamed from: SubcomposeAsyncImage-ylYTKUw, reason: not valid java name */
    public static final void m7156SubcomposeAsyncImageylYTKUw(final Object model, final String contentDescription, Modifier modifier, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function5, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function6, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function2, Function1<? super AsyncImagePainter.State.Error, Unit> function3, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, int filterQuality, Composer $composer, final int $changed, final int $changed1, final int i) {
        int filterQuality2;
        int $dirty1;
        Composer $composer2 = $composer.startRestartGroup(1047090393);
        ComposerKt.sourceInformation($composer2, "C(SubcomposeAsyncImage)P(8,3,9,7,13,5,11,12,10!1,4!,6:c#ui.graphics.FilterQuality)");
        Modifier modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function7 = (i & 8) != 0 ? null : function4;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function8 = (i & 16) != 0 ? null : function5;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function9 = (i & 32) != 0 ? null : function6;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function10 = (i & 64) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function11 = (i & 128) != 0 ? null : function2;
        Function1<? super AsyncImagePainter.State.Error, Unit> function12 = (i & 256) != 0 ? null : function3;
        Alignment alignment2 = (i & 512) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale contentScale2 = (i & 1024) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float alpha2 = (i & 2048) != 0 ? 1.0f : alpha;
        ColorFilter colorFilter2 = (i & 4096) != 0 ? null : colorFilter;
        if ((i & 8192) != 0) {
            int filterQuality3 = DrawScope.INSTANCE.m4862getDefaultFilterQualityfv9h1I();
            int $dirty2 = $changed1 & (-7169);
            $dirty1 = $dirty2;
            filterQuality2 = filterQuality3;
        } else {
            filterQuality2 = filterQuality;
            $dirty1 = $changed1;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1047090393, $changed, $dirty1, "coil.compose.SubcomposeAsyncImage (SingletonSubcomposeAsyncImage.kt:58)");
        }
        SubcomposeAsyncImageKt.m7157SubcomposeAsyncImageQ4Kwu38(model, contentDescription, ImageLoaderProvidableCompositionLocal.getCurrent(LocalImageLoaderKt.getLocalImageLoader(), $composer2, 6), modifier2, function7, function8, function9, function10, function11, function12, alignment2, contentScale2, alpha2, colorFilter2, filterQuality2, $composer2, ($changed & 112) | 520 | (($changed << 3) & 7168) | (($changed << 3) & 57344) | (($changed << 3) & 458752) | (($changed << 3) & 3670016) | (($changed << 3) & 29360128) | (($changed << 3) & 234881024) | (($changed << 3) & 1879048192), (($changed >> 27) & 14) | (($dirty1 << 3) & 112) | (($dirty1 << 3) & 896) | (($dirty1 << 3) & 7168) | (($dirty1 << 3) & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = modifier2;
        final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function13 = function7;
        final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function14 = function8;
        final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function15 = function9;
        final Function1<? super AsyncImagePainter.State.Loading, Unit> function16 = function10;
        final Function1<? super AsyncImagePainter.State.Success, Unit> function17 = function11;
        final Function1<? super AsyncImagePainter.State.Error, Unit> function18 = function12;
        final Alignment alignment3 = alignment2;
        final ContentScale contentScale3 = contentScale2;
        final float f = alpha2;
        final ColorFilter colorFilter3 = colorFilter2;
        final int i2 = filterQuality2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i3) {
                SingletonSubcomposeAsyncImageKt.m7156SubcomposeAsyncImageylYTKUw(model, contentDescription, modifier3, function13, function14, function15, function16, function17, function18, alignment3, contentScale3, f, colorFilter3, i2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    /* JADX INFO: renamed from: SubcomposeAsyncImage-10Xjiaw, reason: not valid java name */
    public static final void m7155SubcomposeAsyncImage10Xjiaw(final Object model, final String contentDescription, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function2, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, int filterQuality, final Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform;
        int filterQuality2;
        int $dirty;
        Composer $composer2 = $composer.startRestartGroup(1571662781);
        ComposerKt.sourceInformation($composer2, "C(SubcomposeAsyncImage)P(7,4,8,10,9!1,5!2,6:c#ui.graphics.FilterQuality)");
        int $dirty2 = $changed;
        Modifier modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        if ((i & 8) != 0) {
            $dirty2 &= -7169;
            defaultTransform = AsyncImagePainter.INSTANCE.getDefaultTransform();
        } else {
            defaultTransform = function1;
        }
        Function1<? super AsyncImagePainter.State, Unit> function4 = (i & 16) != 0 ? null : function2;
        Alignment alignment2 = (i & 32) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale contentScale2 = (i & 64) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float alpha2 = (i & 128) != 0 ? 1.0f : alpha;
        ColorFilter colorFilter2 = (i & 256) != 0 ? null : colorFilter;
        if ((i & 512) != 0) {
            int filterQuality3 = DrawScope.INSTANCE.m4862getDefaultFilterQualityfv9h1I();
            $dirty = $dirty2 & (-1879048193);
            filterQuality2 = filterQuality3;
        } else {
            filterQuality2 = filterQuality;
            $dirty = $dirty2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1571662781, $dirty, $changed1, "coil.compose.SubcomposeAsyncImage (SingletonSubcomposeAsyncImage.kt:112)");
        }
        SubcomposeAsyncImageKt.m7158SubcomposeAsyncImagesKDTAoQ(model, contentDescription, ImageLoaderProvidableCompositionLocal.getCurrent(LocalImageLoaderKt.getLocalImageLoader(), $composer2, 6), modifier2, defaultTransform, function4, alignment2, contentScale2, alpha2, colorFilter2, filterQuality2, function3, $composer2, ($dirty & 112) | 520 | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (($dirty << 3) & 3670016) | (($dirty << 3) & 29360128) | (($dirty << 3) & 234881024) | (($dirty << 3) & 1879048192), (($dirty >> 27) & 14) | (($changed1 << 3) & 112), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = modifier2;
        final Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function5 = defaultTransform;
        final Function1<? super AsyncImagePainter.State, Unit> function6 = function4;
        final Alignment alignment3 = alignment2;
        final ContentScale contentScale3 = contentScale2;
        final float f = alpha2;
        final ColorFilter colorFilter3 = colorFilter2;
        final int i2 = filterQuality2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i3) {
                SingletonSubcomposeAsyncImageKt.m7155SubcomposeAsyncImage10Xjiaw(model, contentDescription, modifier3, function5, function6, alignment3, contentScale3, f, colorFilter3, i2, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }
}
