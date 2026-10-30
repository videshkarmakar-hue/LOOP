package coil.compose;

import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ClipKt;
import androidx.compose.p001ui.graphics.ColorFilter;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.painter.Painter;
import androidx.compose.p001ui.layout.ContentScale;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.semantics.Role;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.ImageLoader;
import coil.request.ImageRequest;
import coil.size.Dimension;
import coil.size.Dimensions;
import coil.size.Size;
import coil.size.SizeResolver;
import coil.size.SizeResolvers;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AsyncImage.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u009d\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001aÛ\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u001aI\u0010&\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u001b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0002\u0010(\u001a\u001d\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010\u0010\u001a\u00020\u0011H\u0001¢\u0006\u0002\u0010,\u001a\u0016\u0010\u0004\u001a\u00020\t*\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0003\u001a\u001b\u0010-\u001a\u0004\u0018\u00010.*\u00020/H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00062"}, m195d2 = {"AsyncImage", "", "model", "", "contentDescription", "", "imageLoader", "Lcoil/ImageLoader;", "modifier", "Landroidx/compose/ui/Modifier;", "transform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "onState", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "AsyncImage-MvsnxeU", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lcoil/compose/AsyncImagePainter$State$Loading;", "onSuccess", "Lcoil/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil/compose/AsyncImagePainter$State$Error;", "AsyncImage-Q4Kwu38", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V", "Content", "painter", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;I)V", "updateRequest", "Lcoil/request/ImageRequest;", "request", "(Lcoil/request/ImageRequest;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/runtime/Composer;I)Lcoil/request/ImageRequest;", "toSizeOrNull", "Lcoil/size/Size;", "Landroidx/compose/ui/unit/Constraints;", "toSizeOrNull-BRTryo0", "(J)Lcoil/size/Size;", "coil-compose-base_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AsyncImageKt {
    /* JADX INFO: renamed from: AsyncImage-Q4Kwu38, reason: not valid java name */
    public static final void m7125AsyncImageQ4Kwu38(Object model, String contentDescription, ImageLoader imageLoader, Modifier modifier, Painter placeholder, Painter error, Painter fallback, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function2, Function1<? super AsyncImagePainter.State.Error, Unit> function3, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, int filterQuality, Composer $composer, int $changed, int $changed1, int i) {
        $composer.startReplaceableGroup(-245964807);
        ComposerKt.sourceInformation($composer, "C(AsyncImage)P(9,3,8,10,14,5,6,12,13,11!1,4!,7:c#ui.graphics.FilterQuality)");
        Modifier modifier2 = (i & 8) != 0 ? Modifier.INSTANCE : modifier;
        Painter placeholder2 = (i & 16) != 0 ? null : placeholder;
        Painter error2 = (i & 32) != 0 ? null : error;
        Painter fallback2 = (i & 64) != 0 ? error2 : fallback;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function4 = (i & 128) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function5 = (i & 256) != 0 ? null : function2;
        Function1<? super AsyncImagePainter.State.Error, Unit> function6 = (i & 512) != 0 ? null : function3;
        Alignment alignment2 = (i & 1024) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale contentScale2 = (i & 2048) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float alpha2 = (i & 4096) != 0 ? 1.0f : alpha;
        ColorFilter colorFilter2 = (i & 8192) != 0 ? null : colorFilter;
        int filterQuality2 = (i & 16384) != 0 ? DrawScope.INSTANCE.m4862getDefaultFilterQualityfv9h1I() : filterQuality;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-245964807, $changed, $changed1, "coil.compose.AsyncImage (AsyncImage.kt:80)");
        }
        m7124AsyncImageMvsnxeU(model, contentDescription, imageLoader, modifier2, UtilsKt.transformOf(placeholder2, error2, fallback2), UtilsKt.onStateOf(function4, function5, function6), alignment2, contentScale2, alpha2, colorFilter2, filterQuality2, $composer, ($changed & 112) | 520 | ($changed & 7168) | (($changed1 << 18) & 3670016) | (($changed1 << 18) & 29360128) | (($changed1 << 18) & 234881024) | (1879048192 & ($changed1 << 18)), ($changed1 >> 12) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    /* JADX INFO: renamed from: AsyncImage-MvsnxeU, reason: not valid java name */
    public static final void m7124AsyncImageMvsnxeU(final Object model, final String contentDescription, final ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function2, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, int filterQuality, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform;
        Function1<? super AsyncImagePainter.State, Unit> function3;
        Alignment alignment2;
        ContentScale contentScale2;
        float alpha2;
        ColorFilter colorFilter2;
        int filterQuality2;
        int $dirty1;
        Modifier modifierThen;
        Composer $composer2 = $composer.startRestartGroup(-2030202961);
        ComposerKt.sourceInformation($composer2, "C(AsyncImage)P(7,3,6,8,10,9!1,4!,5:c#ui.graphics.FilterQuality)");
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
            function3 = function2;
        } else {
            function3 = null;
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
            ComposerKt.traceEventStart(-2030202961, $changed, $dirty1, "coil.compose.AsyncImage (AsyncImage.kt:130)");
        }
        ImageRequest request = updateRequest(UtilsKt.requestOf(model, $composer2, 8), contentScale2, $composer2, 8 | (($changed >> 18) & 112));
        AsyncImagePainter painter = AsyncImagePainterKt.m7133rememberAsyncImagePainter5jETZwI(request, imageLoader, defaultTransform, function3, contentScale2, filterQuality2, $composer2, (($changed >> 6) & 896) | 72 | (($changed >> 6) & 7168) | (($changed >> 9) & 57344) | (($dirty1 << 15) & 458752), 0);
        SizeResolver sizeResolver = request.getSizeResolver();
        if (sizeResolver instanceof ConstraintsSizeResolver) {
            modifierThen = modifier2.then((Modifier) sizeResolver);
        } else {
            modifierThen = modifier2;
        }
        Content(modifierThen, painter, contentDescription, alignment2, contentScale2, alpha2, colorFilter2, $composer2, (57344 & ($changed >> 9)) | (($changed << 3) & 896) | (($changed >> 9) & 7168) | (458752 & ($changed >> 9)) | (3670016 & ($changed >> 9)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = modifier2;
        final Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function4 = defaultTransform;
        final Function1<? super AsyncImagePainter.State, Unit> function5 = function3;
        final Alignment alignment3 = alignment2;
        final ContentScale contentScale3 = contentScale2;
        final float f = alpha2;
        final ColorFilter colorFilter3 = colorFilter2;
        final int i2 = filterQuality2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.AsyncImageKt$AsyncImage$1
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
                AsyncImageKt.m7124AsyncImageMvsnxeU(model, contentDescription, imageLoader, modifier3, function4, function5, alignment3, contentScale3, f, colorFilter3, i2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    public static final void Content(final Modifier modifier, final Painter painter, final String contentDescription, final Alignment alignment, final ContentScale contentScale, final float alpha, final ColorFilter colorFilter, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(10290533);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(10290533, $changed, -1, "coil.compose.Content (AsyncImage.kt:164)");
        }
        Modifier modifier$iv = ClipKt.clipToBounds(contentDescription(modifier, contentDescription)).then(new ContentPainterModifier(painter, alignment, contentScale, alpha, colorFilter));
        MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: coil.compose.AsyncImageKt.Content.1
            @Override // androidx.compose.p001ui.layout.MeasurePolicy
            public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
            }

            @Override // androidx.compose.p001ui.layout.MeasurePolicy
            public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
            }

            @Override // androidx.compose.p001ui.layout.MeasurePolicy
            public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
            }

            @Override // androidx.compose.p001ui.layout.MeasurePolicy
            public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
            }

            @Override // androidx.compose.p001ui.layout.MeasurePolicy
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo285measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, long constraints) {
                return MeasureScope.CC.layout$default($this$Layout, Constraints.m6746getMinWidthimpl(constraints), Constraints.m6745getMinHeightimpl(constraints), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: coil.compose.AsyncImageKt.Content.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope $this$layout) {
                    }
                }, 4, null);
            }
        };
        $composer2.startReplaceableGroup(544976794);
        ComposerKt.sourceInformation($composer2, "CC(Layout)P(1)122@4734L23,125@4885L385:Layout.kt#80mrfh");
        int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
        Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
        CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
        final Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        $composer2.startReplaceableGroup(1405779621);
        ComposerKt.sourceInformation($composer2, "CC(ReusableComposeNode):Composables.kt#9igjgp");
        if (!($composer2.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer2.startReusableNode();
        if ($composer2.getInserting()) {
            $composer2.createNode(new Function0<ComposeUiNode>() { // from class: coil.compose.AsyncImageKt$Content$$inlined$Layout$1
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final ComposeUiNode invoke() {
                    return constructor.invoke();
                }
            });
        } else {
            $composer2.useNode();
        }
        Composer $this$Layout_u24lambda_u241$iv = Updater.m3795constructorimpl($composer2);
        Updater.m3802setimpl($this$Layout_u24lambda_u241$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3802setimpl($this$Layout_u24lambda_u241$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m3802setimpl($this$Layout_u24lambda_u241$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if ($this$Layout_u24lambda_u241$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u241$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
            $this$Layout_u24lambda_u241$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
            $this$Layout_u24lambda_u241$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
        }
        $composer2.endNode();
        $composer2.endReplaceableGroup();
        $composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.AsyncImageKt.Content.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                AsyncImageKt.Content(modifier, painter, contentDescription, alignment, contentScale, alpha, colorFilter, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    public static final ImageRequest updateRequest(ImageRequest request, ContentScale contentScale, Composer $composer, int $changed) {
        ImageRequest imageRequestBuild;
        Object value$iv$iv;
        SizeResolver sizeResolver;
        $composer.startReplaceableGroup(402368983);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(402368983, $changed, -1, "coil.compose.updateRequest (AsyncImage.kt:183)");
        }
        if (request.getDefined().getSizeResolver() == null) {
            if (Intrinsics.areEqual(contentScale, ContentScale.INSTANCE.getNone())) {
                sizeResolver = SizeResolvers.create(Size.ORIGINAL);
            } else {
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
                Object it$iv$iv = $composer.rememberedValue();
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = new ConstraintsSizeResolver();
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                sizeResolver = (SizeResolver) value$iv$iv;
            }
            imageRequestBuild = ImageRequest.newBuilder$default(request, null, 1, null).size(sizeResolver).build();
        } else {
            imageRequestBuild = request;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return imageRequestBuild;
    }

    private static final Modifier contentDescription(Modifier $this$contentDescription, final String contentDescription) {
        if (contentDescription != null) {
            return SemanticsModifierKt.semantics$default($this$contentDescription, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: coil.compose.AsyncImageKt.contentDescription.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.setContentDescription($this$semantics, contentDescription);
                    SemanticsPropertiesKt.m6079setRolekuIjeqM($this$semantics, Role.INSTANCE.m6065getImageo7Vup1c());
                }
            }, 1, null);
        }
        return $this$contentDescription;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toSizeOrNull-BRTryo0, reason: not valid java name */
    public static final Size m7127toSizeOrNullBRTryo0(long $this$toSizeOrNull_u2dBRTryo0) {
        if (Constraints.m6748isZeroimpl($this$toSizeOrNull_u2dBRTryo0)) {
            return null;
        }
        return new Size(Constraints.m6740getHasBoundedWidthimpl($this$toSizeOrNull_u2dBRTryo0) ? Dimensions.Dimension(Constraints.m6744getMaxWidthimpl($this$toSizeOrNull_u2dBRTryo0)) : Dimension.Undefined.INSTANCE, Constraints.m6739getHasBoundedHeightimpl($this$toSizeOrNull_u2dBRTryo0) ? Dimensions.Dimension(Constraints.m6743getMaxHeightimpl($this$toSizeOrNull_u2dBRTryo0)) : Dimension.Undefined.INSTANCE);
    }
}
