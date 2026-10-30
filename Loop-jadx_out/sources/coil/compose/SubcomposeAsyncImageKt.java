package coil.compose;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.ColorFilter;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.painter.Painter;
import androidx.compose.p001ui.layout.ContentScale;
import androidx.compose.p001ui.layout.LayoutKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.ImageLoader;
import coil.request.ImageRequest;
import coil.size.SizeResolver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubcomposeAsyncImage.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a»\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a¯\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2&\b\u0002\u0010\u001e\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2&\b\u0002\u0010!\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2&\b\u0002\u0010#\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001a\u0095\u0001\u0010*\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2$\u0010\u001e\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2$\u0010!\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2$\u0010#\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0003¢\u0006\u0002\u0010+\u001a[\u0010,\u001a\u00020\u0001*\u00020\u00192\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020.2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010/\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, m195d2 = {"SubcomposeAsyncImage", "", "model", "", "contentDescription", "", "imageLoader", "Lcoil/ImageLoader;", "modifier", "Landroidx/compose/ui/Modifier;", "transform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "onState", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "content", "Lcoil/compose/SubcomposeAsyncImageScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "SubcomposeAsyncImage-sKDTAoQ", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "loading", "Lkotlin/Function2;", "Lcoil/compose/AsyncImagePainter$State$Loading;", "success", "Lcoil/compose/AsyncImagePainter$State$Success;", "error", "Lcoil/compose/AsyncImagePainter$State$Error;", "onLoading", "onSuccess", "onError", "SubcomposeAsyncImage-Q4Kwu38", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V", "contentOf", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;)Lkotlin/jvm/functions/Function3;", "SubcomposeAsyncImageContent", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Lcoil/compose/SubcomposeAsyncImageScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "coil-compose-base_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SubcomposeAsyncImageKt {
    /* JADX INFO: renamed from: SubcomposeAsyncImage-Q4Kwu38, reason: not valid java name */
    public static final void m7157SubcomposeAsyncImageQ4Kwu38(final Object model, final String contentDescription, final ImageLoader imageLoader, Modifier modifier, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function5, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function6, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function2, Function1<? super AsyncImagePainter.State.Error, Unit> function3, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, int filterQuality, Composer $composer, final int $changed, final int $changed1, final int i) {
        int filterQuality2;
        int $dirty1;
        Composer $composer2 = $composer.startRestartGroup(934816934);
        ComposerKt.sourceInformation($composer2, "C(SubcomposeAsyncImage)P(9,3,7,10,8,14,5,12,13,11!1,4!,6:c#ui.graphics.FilterQuality)");
        Modifier modifier2 = (i & 8) != 0 ? Modifier.INSTANCE : modifier;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function7 = (i & 16) != 0 ? null : function4;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function8 = (i & 32) != 0 ? null : function5;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function9 = (i & 64) != 0 ? null : function6;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function10 = (i & 128) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function11 = (i & 256) != 0 ? null : function2;
        Function1<? super AsyncImagePainter.State.Error, Unit> function12 = (i & 512) != 0 ? null : function3;
        Alignment alignment2 = (i & 1024) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale contentScale2 = (i & 2048) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float alpha2 = (i & 4096) != 0 ? 1.0f : alpha;
        ColorFilter colorFilter2 = (i & 8192) != 0 ? null : colorFilter;
        if ((i & 16384) != 0) {
            int filterQuality3 = DrawScope.INSTANCE.m4862getDefaultFilterQualityfv9h1I();
            int $dirty2 = $changed1 & (-57345);
            $dirty1 = $dirty2;
            filterQuality2 = filterQuality3;
        } else {
            filterQuality2 = filterQuality;
            $dirty1 = $changed1;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(934816934, $changed, $dirty1, "coil.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:65)");
        }
        m7158SubcomposeAsyncImagesKDTAoQ(model, contentDescription, imageLoader, modifier2, null, UtilsKt.onStateOf(function10, function11, function12), alignment2, contentScale2, alpha2, colorFilter2, filterQuality2, contentOf(function7, function8, function9), $composer2, ($changed & 112) | 520 | ($changed & 7168) | (($dirty1 << 18) & 3670016) | (($dirty1 << 18) & 29360128) | (($dirty1 << 18) & 234881024) | (1879048192 & ($dirty1 << 18)), ($dirty1 >> 12) & 14, 16);
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
        final Function1<? super AsyncImagePainter.State.Error, Unit> function15 = function12;
        final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function16 = function9;
        final Function1<? super AsyncImagePainter.State.Success, Unit> function17 = function11;
        final Function1<? super AsyncImagePainter.State.Loading, Unit> function18 = function10;
        final Alignment alignment3 = alignment2;
        final ContentScale contentScale3 = contentScale2;
        final float f = alpha2;
        final ColorFilter colorFilter3 = colorFilter2;
        final int i2 = filterQuality2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$1
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
                SubcomposeAsyncImageKt.m7157SubcomposeAsyncImageQ4Kwu38(model, contentDescription, imageLoader, modifier3, function13, function14, function16, function18, function17, function15, alignment3, contentScale3, f, colorFilter3, i2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    /* JADX INFO: renamed from: SubcomposeAsyncImage-sKDTAoQ, reason: not valid java name */
    public static final void m7158SubcomposeAsyncImagesKDTAoQ(final Object model, final String contentDescription, final ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function2, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, int filterQuality, final Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform;
        Function1<? super AsyncImagePainter.State, Unit> function4;
        Alignment alignment2;
        ContentScale contentScale2;
        float alpha2;
        ColorFilter colorFilter2;
        int filterQuality2;
        int $dirty1;
        Alignment alignment3;
        Composer $composer2 = $composer.startRestartGroup(10937794);
        ComposerKt.sourceInformation($composer2, "C(SubcomposeAsyncImage)P(8,4,7,9,11,10!1,5!2,6:c#ui.graphics.FilterQuality)");
        if ((i & 8) != 0) {
            modifier2 = Modifier.INSTANCE;
        } else {
            modifier2 = modifier;
        }
        if ((i & 16) == 0) {
            defaultTransform = function1;
        } else {
            defaultTransform = AsyncImagePainter.INSTANCE.getDefaultTransform();
        }
        if ((i & 32) == 0) {
            function4 = function2;
        } else {
            function4 = null;
        }
        if ((i & 64) == 0) {
            alignment2 = alignment;
        } else {
            alignment2 = Alignment.INSTANCE.getCenter();
        }
        if ((i & 128) == 0) {
            contentScale2 = contentScale;
        } else {
            contentScale2 = ContentScale.INSTANCE.getFit();
        }
        if ((i & 256) == 0) {
            alpha2 = alpha;
        } else {
            alpha2 = 1.0f;
        }
        if ((i & 512) == 0) {
            colorFilter2 = colorFilter;
        } else {
            colorFilter2 = null;
        }
        if ((i & 1024) == 0) {
            filterQuality2 = filterQuality;
            $dirty1 = $changed1;
        } else {
            int filterQuality3 = DrawScope.INSTANCE.m4862getDefaultFilterQualityfv9h1I();
            int $dirty2 = $changed1 & (-15);
            $dirty1 = $dirty2;
            filterQuality2 = filterQuality3;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(10937794, $changed, $dirty1, "coil.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:117)");
        }
        ImageRequest request = AsyncImageKt.updateRequest(UtilsKt.requestOf(model, $composer2, 8), contentScale2, $composer2, 8 | (($changed >> 18) & 112));
        final AsyncImagePainter painter = AsyncImagePainterKt.m7133rememberAsyncImagePainter5jETZwI(request, imageLoader, defaultTransform, function4, contentScale2, filterQuality2, $composer2, (($changed >> 6) & 896) | 72 | (($changed >> 6) & 7168) | (($changed >> 9) & 57344) | (($dirty1 << 15) & 458752), 0);
        final SizeResolver sizeResolver = request.getSizeResolver();
        if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
            $composer2.startReplaceableGroup(-247979203);
            int $changed$iv = (($changed >> 9) & 14) | 384 | (($changed >> 15) & 112);
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(alignment2, true, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier2);
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i2 = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629358, "C71@3331L9:Box.kt#2w3rfo");
            int i3 = (($changed$iv >> 6) & 112) | 6;
            BoxScope $this$SubcomposeAsyncImage_sKDTAoQ_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            function3.invoke(new RealSubcomposeAsyncImageScope($this$SubcomposeAsyncImage_sKDTAoQ_u24lambda_u240, painter, contentDescription, alignment2, contentScale2, alpha2, colorFilter2), $composer2, Integer.valueOf($dirty1 & 112));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            alignment3 = alignment2;
        } else {
            $composer2.startReplaceableGroup(-247978567);
            final Alignment alignment4 = alignment2;
            final ContentScale contentScale3 = contentScale2;
            final int $dirty3 = $dirty1;
            final float f = alpha2;
            final ColorFilter colorFilter3 = colorFilter2;
            alignment3 = alignment2;
            BoxWithConstraintsKt.BoxWithConstraints(modifier2, alignment3, true, ComposableLambdaKt.composableLambda($composer2, -1964284792, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
                    invoke(boxWithConstraintsScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer3, int $changed2) {
                    int $dirty = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty |= $composer3.changed($this$BoxWithConstraints) ? 4 : 2;
                    }
                    if (($dirty & 91) != 18 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1964284792, $dirty, -1, "coil.compose.SubcomposeAsyncImage.<anonymous> (SubcomposeAsyncImage.kt:154)");
                        }
                        ((ConstraintsSizeResolver) sizeResolver).m7137setConstraintsBRTryo0($this$BoxWithConstraints.mo774getConstraintsmsEJaDk());
                        function3.invoke(new RealSubcomposeAsyncImageScope($this$BoxWithConstraints, painter, contentDescription, alignment4, contentScale3, f, colorFilter3), $composer3, Integer.valueOf($dirty3 & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, (($changed >> 9) & 14) | 3456 | (($changed >> 15) & 112), 0);
            $composer2.endReplaceableGroup();
        }
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
        final Alignment alignment5 = alignment3;
        final ContentScale contentScale4 = contentScale2;
        final float f2 = alpha2;
        final ColorFilter colorFilter4 = colorFilter2;
        final int i4 = filterQuality2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$4
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

            public final void invoke(Composer composer, int i5) {
                SubcomposeAsyncImageKt.m7158SubcomposeAsyncImagesKDTAoQ(model, contentDescription, imageLoader, modifier3, function5, function6, alignment5, contentScale4, f2, colorFilter4, i4, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    public static final void SubcomposeAsyncImageContent(final SubcomposeAsyncImageScope $this$SubcomposeAsyncImageContent, Modifier modifier, Painter painter, String contentDescription, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String contentDescription2;
        Alignment alignment2;
        ContentScale contentScale2;
        float alpha2;
        ColorFilter colorFilter2;
        AsyncImagePainter painter2;
        int $dirty;
        Alignment alignment3;
        ContentScale contentScale3;
        ColorFilter colorFilter3;
        float alpha3;
        Modifier modifier3;
        Painter painter3;
        String contentDescription3;
        String contentDescription4;
        Painter painter4;
        Modifier modifier4;
        Composer $composer2 = $composer.startRestartGroup(-263982313);
        ComposerKt.sourceInformation($composer2, "C(SubcomposeAsyncImageContent)P(5,6,3!1,4)");
        int $dirty2 = $changed;
        if ((i & Integer.MIN_VALUE) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed($this$SubcomposeAsyncImageContent) ? 4 : 2;
        }
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 128;
        }
        if (($changed & 7168) == 0) {
            if ((i & 4) == 0) {
                contentDescription2 = contentDescription;
                int i4 = $composer2.changed(contentDescription2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                contentDescription2 = contentDescription;
            }
            $dirty2 |= i4;
        } else {
            contentDescription2 = contentDescription;
        }
        if (($changed & 57344) == 0) {
            if ((i & 8) == 0) {
                alignment2 = alignment;
                int i5 = $composer2.changed(alignment2) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                alignment2 = alignment;
            }
            $dirty2 |= i5;
        } else {
            alignment2 = alignment;
        }
        if (($changed & 458752) == 0) {
            if ((i & 16) == 0) {
                contentScale2 = contentScale;
                int i6 = $composer2.changed(contentScale2) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                contentScale2 = contentScale;
            }
            $dirty2 |= i6;
        } else {
            contentScale2 = contentScale;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 32) == 0) {
                alpha2 = alpha;
                int i7 = $composer2.changed(alpha2) ? 1048576 : 524288;
                $dirty2 |= i7;
            } else {
                alpha2 = alpha;
            }
            $dirty2 |= i7;
        } else {
            alpha2 = alpha;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 64) == 0) {
                colorFilter2 = colorFilter;
                int i8 = $composer2.changed(colorFilter2) ? 8388608 : 4194304;
                $dirty2 |= i8;
            } else {
                colorFilter2 = colorFilter;
            }
            $dirty2 |= i8;
        } else {
            colorFilter2 = colorFilter;
        }
        if (i3 == 2 && (23967451 & $dirty2) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            contentDescription4 = contentDescription2;
            alignment3 = alignment2;
            contentScale3 = contentScale2;
            colorFilter3 = colorFilter2;
            alpha3 = alpha2;
            painter4 = painter;
            modifier4 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if (i3 != 0) {
                    painter2 = $this$SubcomposeAsyncImageContent.getPainter();
                    $dirty2 &= -897;
                } else {
                    painter2 = painter;
                }
                if ((i & 4) != 0) {
                    $dirty2 &= -7169;
                    contentDescription2 = $this$SubcomposeAsyncImageContent.getContentDescription();
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -57345;
                    alignment2 = $this$SubcomposeAsyncImageContent.getAlignment();
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -458753;
                    contentScale2 = $this$SubcomposeAsyncImageContent.getContentScale();
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -3670017;
                    alpha2 = $this$SubcomposeAsyncImageContent.getAlpha();
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-29360129);
                    painter3 = painter2;
                    colorFilter3 = $this$SubcomposeAsyncImageContent.getColorFilter();
                    alignment3 = alignment2;
                    contentScale3 = contentScale2;
                    alpha3 = alpha2;
                    modifier3 = modifier5;
                    contentDescription3 = contentDescription2;
                } else {
                    $dirty = $dirty2;
                    alignment3 = alignment2;
                    contentScale3 = contentScale2;
                    colorFilter3 = colorFilter2;
                    alpha3 = alpha2;
                    modifier3 = modifier5;
                    painter3 = painter2;
                    contentDescription3 = contentDescription2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if (i3 != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 4) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-29360129);
                    alignment3 = alignment2;
                    contentScale3 = contentScale2;
                    colorFilter3 = colorFilter2;
                    alpha3 = alpha2;
                    painter3 = painter;
                    modifier3 = modifier2;
                    contentDescription3 = contentDescription2;
                } else {
                    $dirty = $dirty2;
                    alignment3 = alignment2;
                    contentScale3 = contentScale2;
                    colorFilter3 = colorFilter2;
                    alpha3 = alpha2;
                    painter3 = painter;
                    modifier3 = modifier2;
                    contentDescription3 = contentDescription2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-263982313, $dirty, -1, "coil.compose.SubcomposeAsyncImageContent (SubcomposeAsyncImage.kt:210)");
            }
            AsyncImageKt.Content(modifier3, painter3, contentDescription3, alignment3, contentScale3, alpha3, colorFilter3, $composer2, (($dirty >> 3) & 14) | 64 | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 3) & 57344) | (($dirty >> 3) & 458752) | (($dirty >> 3) & 3670016));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentDescription4 = contentDescription3;
            painter4 = painter3;
            modifier4 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier4;
        final Painter painter5 = painter4;
        final String str = contentDescription4;
        final Alignment alignment4 = alignment3;
        final ContentScale contentScale4 = contentScale3;
        final float f = alpha3;
        final ColorFilter colorFilter4 = colorFilter3;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt.SubcomposeAsyncImageContent.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i9) {
                SubcomposeAsyncImageKt.SubcomposeAsyncImageContent($this$SubcomposeAsyncImageContent, modifier6, painter5, str, alignment4, contentScale4, f, colorFilter4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    private static final Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> contentOf(final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function5, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function6) {
        return (function4 == null && function5 == null && function6 == null) ? ComposableSingletons$SubcomposeAsyncImageKt.INSTANCE.m7136getLambda1$coil_compose_base_release() : ComposableLambdaKt.composableLambdaInstance(-1302781228, true, new Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt.contentOf.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, Integer num) {
                invoke(subcomposeAsyncImageScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, int i) {
                boolean z;
                int i2 = i;
                if ((i & 14) == 0) {
                    i2 |= composer.changed(subcomposeAsyncImageScope) ? 4 : 2;
                }
                int i3 = i2;
                if ((i3 & 91) != 18 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1302781228, i3, -1, "coil.compose.contentOf.<anonymous> (SubcomposeAsyncImage.kt:228)");
                    }
                    boolean z2 = true;
                    AsyncImagePainter.State state = subcomposeAsyncImageScope.getPainter().getState();
                    if (state instanceof AsyncImagePainter.State.Loading) {
                        composer.startReplaceableGroup(-418307549);
                        if (function4 != null) {
                            function4.invoke(subcomposeAsyncImageScope, (AsyncImagePainter.State.Loading) state, composer, Integer.valueOf((i3 & 14) | 64));
                            Unit unit = Unit.INSTANCE;
                            z2 = false;
                        }
                        composer.endReplaceableGroup();
                        z = z2;
                    } else if (state instanceof AsyncImagePainter.State.Success) {
                        composer.startReplaceableGroup(-418307455);
                        if (function5 != null) {
                            function5.invoke(subcomposeAsyncImageScope, (AsyncImagePainter.State.Success) state, composer, Integer.valueOf((i3 & 14) | 64));
                            Unit unit2 = Unit.INSTANCE;
                            z2 = false;
                        }
                        composer.endReplaceableGroup();
                        z = z2;
                    } else if (state instanceof AsyncImagePainter.State.Error) {
                        composer.startReplaceableGroup(-418307363);
                        if (function6 != null) {
                            function6.invoke(subcomposeAsyncImageScope, (AsyncImagePainter.State.Error) state, composer, Integer.valueOf((i3 & 14) | 64));
                            Unit unit3 = Unit.INSTANCE;
                            z2 = false;
                        }
                        composer.endReplaceableGroup();
                        z = z2;
                    } else {
                        if (state instanceof AsyncImagePainter.State.Empty) {
                            composer.startReplaceableGroup(-418307275);
                            composer.endReplaceableGroup();
                        } else {
                            composer.startReplaceableGroup(-418307215);
                            composer.endReplaceableGroup();
                        }
                        z = true;
                    }
                    if (z) {
                        SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(subcomposeAsyncImageScope, null, null, null, null, null, 0.0f, null, composer, i3 & 14, 127);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        });
    }
}
